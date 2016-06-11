package com.hotelbeds.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpEngine;
import okio.Buffer;

import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

@Data
@Slf4j
public final class LoggingRequestInterceptor implements Interceptor {
	
	
	public LoggingRequestInterceptor(Logger logger) {
	    this.logger = logger;
	}

	private final Logger logger;

	
	@Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!logger.isInfoEnabled()) {
            return chain.proceed(request);
        } else {
            final RequestBody requestBody = request.body();
            final boolean hasRequestBody = requestBody != null;
            final Connection connection = chain.connection();
            final Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
            final StringBuilder requestInformation = new StringBuilder("Request: ");
            requestInformation.append(ObjectJoiner.join(" ", protocol.toString().toUpperCase(), request.method(), request.url()));
            long requestBodySize = -1;
            if (hasRequestBody) {
                requestBodySize = requestBody.contentLength();
                requestInformation.append(", body:");
                requestInformation.append(requestBodySize);
                requestInformation.append(" bytes");
            }
            logger.info(requestInformation.toString());

            if (logger.isDebugEnabled()) {
                // If the request has a body, sometimes these headers are not present, so let's make them explicit
                if (hasRequestBody) {
                    if (requestBody.contentType() != null) {
                        logHeader(BontonProperties.CONTENT_TYPE_HEADER, requestBody.contentType().toString());
                    }
                    if (requestBodySize != -1) {
                        logHeader(BontonProperties.CONTENT_LENGTH_HEADER, Long.toString(requestBodySize));
                    }
                }
                // logger the other headers
                for (String header : request.headers().names()) {
                    if (!BontonProperties.CONTENT_TYPE_HEADER.equalsIgnoreCase(header)
                        && !BontonProperties.CONTENT_LENGTH_HEADER.equalsIgnoreCase(header)) {
                        for (String value : request.headers().values(header)) {
                            logHeader(header, value);
                        }
                    }
                }
                if (logger.isTraceEnabled() && hasRequestBody) {
                    Supplier<Buffer> requestBufferSupplier = null;
                    		
                    	/*Unchecked.supplier(() -> {
                        Buffer buffer = new Buffer();
                        requestBody.writeTo(buffer);
                        return buffer;
                    });*/
                    logBody(requestBufferSupplier, requestBody.contentType(), request.headers());
                }
            }
            final long requestStart = System.nanoTime();
            final Response response = chain.proceed(request);
            final long totalRequestTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - requestStart);

            final ResponseBody responseBody = response.body();
            final long contentLength = responseBody.contentLength();

            logger.info("Response: {}", ObjectJoiner.join(" ", response.code(), response.message()));
            if (contentLength >= 0) {
                logger.info("  {}: {}", BontonProperties.CONTENT_LENGTH_HEADER, contentLength);
            }
            logger.info("  Request took {} ms", totalRequestTime);

            if (logger.isDebugEnabled()) {
                for (String header : response.headers().names()) {
                    for (String value : response.headers().values(header)) {
                        logHeader(header, value);
                    }
                }
                if (logger.isTraceEnabled() && HttpEngine.hasBody(response)) {
                    MediaType contentType = responseBody.contentType();
                    Supplier<Buffer> responseBufferSupplier = null;
                    	/*Unchecked.supplier(() -> {
                        BufferedSource source = responseBody.source();
                        source.request(Long.MAX_VALUE);
                        return source.buffer().clone();
                    });*/
                    logBody(responseBufferSupplier, contentType, response.headers());
                }
            }
            return response;
        }
    }

    private void logBody(Supplier<Buffer> bufferSupplier, MediaType contentType, Headers headers) {
        String body = "";
    	if (bodyEncoded(headers)) {
            logger.trace("  Body: encoded, not shown");
        } else {
        	if(bufferSupplier != null) {
        		Buffer buffer = bufferSupplier.get();
                Charset charset = BontonProperties.UTF8;
                if (contentType != null) {
                    try {
                        charset = contentType.charset(BontonProperties.UTF8);
                    } catch (UnsupportedCharsetException e) {
                        logger.error("  Body: Could not be decoded {}", e.getMessage());
                    }
                }
                body = buffer.readString(charset);
                String bodyContentType = headers.get(BontonProperties.CONTENT_TYPE_HEADER);
                if (bodyContentType != null && bodyContentType.toLowerCase().startsWith(BontonProperties.APPLICATION_JSON_HEADER)) {
                    logger.trace("  JSON Body: {}", writeJSON(body));
                } else {
                    logger.trace("  Body: {}", body);
                }
        	}else {
        		logger.trace("  Body: {}", body);
        	}
        }
    }

    private void logHeader(final String headerName, final String headerValue) {
        logger.debug("  Header: {}: \"{}\"", headerName, headerValue);
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get(BontonProperties.CONTENT_ENCODING_HEADER);
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }

    public String writeJSON(final Object object) {
        ObjectMapper mapper = null;
        String result = null;
        mapper = new ObjectMapper();
        try {
            if (object instanceof String) {
                Object json = mapper.readValue((String) object, Object.class);
                result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            } else {
                result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            }
        } catch (final IOException e) {
            logger.warn("Body is not a json object {}", e.getMessage());
        }
        return result;
    }

}
