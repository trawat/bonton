
package com.desia.artifacts.booking;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.desia.artifacts.booking package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TPAExtensions_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "TPA_Extensions");
    private final static QName _OTAHotelResModifyNotifRQ_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "OTA_HotelResModifyNotifRQ");
    private final static QName _OTAHotelResModifyNotifRS_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "OTA_HotelResModifyNotifRS");
    private final static QName _OTANotifReportRS_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "OTA_NotifReportRS");
    private final static QName _ParagraphTypeImage_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "Image");
    private final static QName _ParagraphTypeURL_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "URL");
    private final static QName _ParagraphTypeText_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "Text");
    private final static QName _ParagraphTypeListItem_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "ListItem");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.desia.artifacts.booking
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OTANotifReportRQ }
     * 
     */
    public OTANotifReportRQ createOTANotifReportRQ() {
        return new OTANotifReportRQ();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRQ }
     * 
     */
    public OTAHotelAvailRQ createOTAHotelAvailRQ() {
        return new OTAHotelAvailRQ();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS }
     * 
     */
    public OTAHotelAvailRS createOTAHotelAvailRS() {
        return new OTAHotelAvailRS();
    }

    /**
     * Create an instance of {@link OTACancelRS }
     * 
     */
    public OTACancelRS createOTACancelRS() {
        return new OTACancelRS();
    }

    /**
     * Create an instance of {@link ImageJSON }
     * 
     */
    public ImageJSON createImageJSON() {
        return new ImageJSON();
    }

    /**
     * Create an instance of {@link OTACancelRQ }
     * 
     */
    public OTACancelRQ createOTACancelRQ() {
        return new OTACancelRQ();
    }

    /**
     * Create an instance of {@link OTAHotelResRQ }
     * 
     */
    public OTAHotelResRQ createOTAHotelResRQ() {
        return new OTAHotelResRQ();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.Amenities }
     * 
     */
    public com.desia.artifacts.booking.Amenities createAmenities() {
        return new com.desia.artifacts.booking.Amenities();
    }

    /**
     * Create an instance of {@link HotelBasicInformation }
     * 
     */
    public HotelBasicInformation createHotelBasicInformation() {
        return new HotelBasicInformation();
    }

    /**
     * Create an instance of {@link DOWRestrictionsType }
     * 
     */
    public DOWRestrictionsType createDOWRestrictionsType() {
        return new DOWRestrictionsType();
    }

    /**
     * Create an instance of {@link WeatherInfoType }
     * 
     */
    public WeatherInfoType createWeatherInfoType() {
        return new WeatherInfoType();
    }

    /**
     * Create an instance of {@link OriginDestinationInformationType }
     * 
     */
    public OriginDestinationInformationType createOriginDestinationInformationType() {
        return new OriginDestinationInformationType();
    }

    /**
     * Create an instance of {@link URLsType }
     * 
     */
    public URLsType createURLsType() {
        return new URLsType();
    }

    /**
     * Create an instance of {@link RevenueCategoryType }
     * 
     */
    public RevenueCategoryType createRevenueCategoryType() {
        return new RevenueCategoryType();
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link PersonNameType }
     * 
     */
    public PersonNameType createPersonNameType() {
        return new PersonNameType();
    }

    /**
     * Create an instance of {@link OperationScheduleType }
     * 
     */
    public OperationScheduleType createOperationScheduleType() {
        return new OperationScheduleType();
    }

    /**
     * Create an instance of {@link OperationScheduleType.OperationTimes }
     * 
     */
    public OperationScheduleType.OperationTimes createOperationScheduleTypeOperationTimes() {
        return new OperationScheduleType.OperationTimes();
    }

    /**
     * Create an instance of {@link FeaturesType }
     * 
     */
    public FeaturesType createFeaturesType() {
        return new FeaturesType();
    }

    /**
     * Create an instance of {@link FeaturesType.Feature }
     * 
     */
    public FeaturesType.Feature createFeaturesTypeFeature() {
        return new FeaturesType.Feature();
    }

    /**
     * Create an instance of {@link PoliciesType }
     * 
     */
    public PoliciesType createPoliciesType() {
        return new PoliciesType();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy }
     * 
     */
    public PoliciesType.Policy createPoliciesTypePolicy() {
        return new PoliciesType.Policy();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.CommissionPolicy }
     * 
     */
    public PoliciesType.Policy.CommissionPolicy createPoliciesTypePolicyCommissionPolicy() {
        return new PoliciesType.Policy.CommissionPolicy();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.StayRequirements }
     * 
     */
    public PoliciesType.Policy.StayRequirements createPoliciesTypePolicyStayRequirements() {
        return new PoliciesType.Policy.StayRequirements();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.PetsPolicies }
     * 
     */
    public PoliciesType.Policy.PetsPolicies createPoliciesTypePolicyPetsPolicies() {
        return new PoliciesType.Policy.PetsPolicies();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.TaxPolicies }
     * 
     */
    public PoliciesType.Policy.TaxPolicies createPoliciesTypePolicyTaxPolicies() {
        return new PoliciesType.Policy.TaxPolicies();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.CheckoutCharges }
     * 
     */
    public PoliciesType.Policy.CheckoutCharges createPoliciesTypePolicyCheckoutCharges() {
        return new PoliciesType.Policy.CheckoutCharges();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.PolicyInfoCodes }
     * 
     */
    public PoliciesType.Policy.PolicyInfoCodes createPoliciesTypePolicyPolicyInfoCodes() {
        return new PoliciesType.Policy.PolicyInfoCodes();
    }

    /**
     * Create an instance of {@link RequiredPaymentsType }
     * 
     */
    public RequiredPaymentsType createRequiredPaymentsType() {
        return new RequiredPaymentsType();
    }

    /**
     * Create an instance of {@link RequiredPaymentsType.GuaranteePayment }
     * 
     */
    public RequiredPaymentsType.GuaranteePayment createRequiredPaymentsTypeGuaranteePayment() {
        return new RequiredPaymentsType.GuaranteePayment();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link AllianceConsortiumType }
     * 
     */
    public AllianceConsortiumType createAllianceConsortiumType() {
        return new AllianceConsortiumType();
    }

    /**
     * Create an instance of {@link AccessesType }
     * 
     */
    public AccessesType createAccessesType() {
        return new AccessesType();
    }

    /**
     * Create an instance of {@link TransportationType }
     * 
     */
    public TransportationType createTransportationType() {
        return new TransportationType();
    }

    /**
     * Create an instance of {@link AddressesType }
     * 
     */
    public AddressesType createAddressesType() {
        return new AddressesType();
    }

    /**
     * Create an instance of {@link ContactInfoType }
     * 
     */
    public ContactInfoType createContactInfoType() {
        return new ContactInfoType();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType }
     * 
     */
    public BasicPropertyInfoType createBasicPropertyInfoType() {
        return new BasicPropertyInfoType();
    }

    /**
     * Create an instance of {@link PropertyValueMatchType }
     * 
     */
    public PropertyValueMatchType createPropertyValueMatchType() {
        return new PropertyValueMatchType();
    }

    /**
     * Create an instance of {@link PropertyValueMatchType.Amenities }
     * 
     */
    public PropertyValueMatchType.Amenities createPropertyValueMatchTypeAmenities() {
        return new PropertyValueMatchType.Amenities();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType.ContactNumbers }
     * 
     */
    public BasicPropertyInfoType.ContactNumbers createBasicPropertyInfoTypeContactNumbers() {
        return new BasicPropertyInfoType.ContactNumbers();
    }

    /**
     * Create an instance of {@link BookingRulesType }
     * 
     */
    public BookingRulesType createBookingRulesType() {
        return new BookingRulesType();
    }

    /**
     * Create an instance of {@link BookingRulesType.BookingRule }
     * 
     */
    public BookingRulesType.BookingRule createBookingRulesTypeBookingRule() {
        return new BookingRulesType.BookingRule();
    }

    /**
     * Create an instance of {@link BookingRulesType.BookingRule.AddtionalRules }
     * 
     */
    public BookingRulesType.BookingRule.AddtionalRules createBookingRulesTypeBookingRuleAddtionalRules() {
        return new BookingRulesType.BookingRule.AddtionalRules();
    }

    /**
     * Create an instance of {@link BookingRulesType.BookingRule.AcceptableGuarantees }
     * 
     */
    public BookingRulesType.BookingRule.AcceptableGuarantees createBookingRulesTypeBookingRuleAcceptableGuarantees() {
        return new BookingRulesType.BookingRule.AcceptableGuarantees();
    }

    /**
     * Create an instance of {@link GuaranteeType }
     * 
     */
    public GuaranteeType createGuaranteeType() {
        return new GuaranteeType();
    }

    /**
     * Create an instance of {@link GuaranteeType.GuaranteesAccepted }
     * 
     */
    public GuaranteeType.GuaranteesAccepted createGuaranteeTypeGuaranteesAccepted() {
        return new GuaranteeType.GuaranteesAccepted();
    }

    /**
     * Create an instance of {@link PaymentFormType }
     * 
     */
    public PaymentFormType createPaymentFormType() {
        return new PaymentFormType();
    }

    /**
     * Create an instance of {@link PaymentFormType.Ticket }
     * 
     */
    public PaymentFormType.Ticket createPaymentFormTypeTicket() {
        return new PaymentFormType.Ticket();
    }

    /**
     * Create an instance of {@link PaymentFormType.LoyaltyRedemption }
     * 
     */
    public PaymentFormType.LoyaltyRedemption createPaymentFormTypeLoyaltyRedemption() {
        return new PaymentFormType.LoyaltyRedemption();
    }

    /**
     * Create an instance of {@link ViewershipsType }
     * 
     */
    public ViewershipsType createViewershipsType() {
        return new ViewershipsType();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership }
     * 
     */
    public ViewershipsType.Viewership createViewershipsTypeViewership() {
        return new ViewershipsType.Viewership();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.DistributorTypes }
     * 
     */
    public ViewershipsType.Viewership.DistributorTypes createViewershipsTypeViewershipDistributorTypes() {
        return new ViewershipsType.Viewership.DistributorTypes();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.BookingChannelCodes }
     * 
     */
    public ViewershipsType.Viewership.BookingChannelCodes createViewershipsTypeViewershipBookingChannelCodes() {
        return new ViewershipsType.Viewership.BookingChannelCodes();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.LocationCodes }
     * 
     */
    public ViewershipsType.Viewership.LocationCodes createViewershipsTypeViewershipLocationCodes() {
        return new ViewershipsType.Viewership.LocationCodes();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.ProfileTypes }
     * 
     */
    public ViewershipsType.Viewership.ProfileTypes createViewershipsTypeViewershipProfileTypes() {
        return new ViewershipsType.Viewership.ProfileTypes();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.SystemCodes }
     * 
     */
    public ViewershipsType.Viewership.SystemCodes createViewershipsTypeViewershipSystemCodes() {
        return new ViewershipsType.Viewership.SystemCodes();
    }

    /**
     * Create an instance of {@link FacilityInfoType }
     * 
     */
    public FacilityInfoType createFacilityInfoType() {
        return new FacilityInfoType();
    }

    /**
     * Create an instance of {@link FacilityInfoType.GuestRooms }
     * 
     */
    public FacilityInfoType.GuestRooms createFacilityInfoTypeGuestRooms() {
        return new FacilityInfoType.GuestRooms();
    }

    /**
     * Create an instance of {@link FacilityInfoType.GuestRooms.GuestRoom }
     * 
     */
    public FacilityInfoType.GuestRooms.GuestRoom createFacilityInfoTypeGuestRoomsGuestRoom() {
        return new FacilityInfoType.GuestRooms.GuestRoom();
    }

    /**
     * Create an instance of {@link FacilityInfoType.GuestRooms.GuestRoom.Amenities }
     * 
     */
    public FacilityInfoType.GuestRooms.GuestRoom.Amenities createFacilityInfoTypeGuestRoomsGuestRoomAmenities() {
        return new FacilityInfoType.GuestRooms.GuestRoom.Amenities();
    }

    /**
     * Create an instance of {@link MeetingRoomsType }
     * 
     */
    public MeetingRoomsType createMeetingRoomsType() {
        return new MeetingRoomsType();
    }

    /**
     * Create an instance of {@link FacilityInfoType.MeetingRooms }
     * 
     */
    public FacilityInfoType.MeetingRooms createFacilityInfoTypeMeetingRooms() {
        return new FacilityInfoType.MeetingRooms();
    }

    /**
     * Create an instance of {@link MeetingRoomsType.MeetingRoom }
     * 
     */
    public MeetingRoomsType.MeetingRoom createMeetingRoomsTypeMeetingRoom() {
        return new MeetingRoomsType.MeetingRoom();
    }

    /**
     * Create an instance of {@link StatisticApplicationSetType }
     * 
     */
    public StatisticApplicationSetType createStatisticApplicationSetType() {
        return new StatisticApplicationSetType();
    }

    /**
     * Create an instance of {@link StatisticApplicationSetType.CountCategorySummaries }
     * 
     */
    public StatisticApplicationSetType.CountCategorySummaries createStatisticApplicationSetTypeCountCategorySummaries() {
        return new StatisticApplicationSetType.CountCategorySummaries();
    }

    /**
     * Create an instance of {@link StatisticApplicationSetType.RevenueCategorySummaries }
     * 
     */
    public StatisticApplicationSetType.RevenueCategorySummaries createStatisticApplicationSetTypeRevenueCategorySummaries() {
        return new StatisticApplicationSetType.RevenueCategorySummaries();
    }

    /**
     * Create an instance of {@link StatisticApplicationSetType.StatisticCodes }
     * 
     */
    public StatisticApplicationSetType.StatisticCodes createStatisticApplicationSetTypeStatisticCodes() {
        return new StatisticApplicationSetType.StatisticCodes();
    }

    /**
     * Create an instance of {@link RateAmountMessageType }
     * 
     */
    public RateAmountMessageType createRateAmountMessageType() {
        return new RateAmountMessageType();
    }

    /**
     * Create an instance of {@link RateAmountMessageType.Rates }
     * 
     */
    public RateAmountMessageType.Rates createRateAmountMessageTypeRates() {
        return new RateAmountMessageType.Rates();
    }

    /**
     * Create an instance of {@link RateUploadType }
     * 
     */
    public RateUploadType createRateUploadType() {
        return new RateUploadType();
    }

    /**
     * Create an instance of {@link RateUploadType.AdditionalGuestAmounts }
     * 
     */
    public RateUploadType.AdditionalGuestAmounts createRateUploadTypeAdditionalGuestAmounts() {
        return new RateUploadType.AdditionalGuestAmounts();
    }

    /**
     * Create an instance of {@link RateUploadType.BaseByGuestAmts }
     * 
     */
    public RateUploadType.BaseByGuestAmts createRateUploadTypeBaseByGuestAmts() {
        return new RateUploadType.BaseByGuestAmts();
    }

    /**
     * Create an instance of {@link InvBlockType }
     * 
     */
    public InvBlockType createInvBlockType() {
        return new InvBlockType();
    }

    /**
     * Create an instance of {@link InvBlockType.BlockDescriptions }
     * 
     */
    public InvBlockType.BlockDescriptions createInvBlockTypeBlockDescriptions() {
        return new InvBlockType.BlockDescriptions();
    }

    /**
     * Create an instance of {@link ParagraphType }
     * 
     */
    public ParagraphType createParagraphType() {
        return new ParagraphType();
    }

    /**
     * Create an instance of {@link ProfilesType }
     * 
     */
    public ProfilesType createProfilesType() {
        return new ProfilesType();
    }

    /**
     * Create an instance of {@link VideoDescriptionType }
     * 
     */
    public VideoDescriptionType createVideoDescriptionType() {
        return new VideoDescriptionType();
    }

    /**
     * Create an instance of {@link RFPResponseDetailType }
     * 
     */
    public RFPResponseDetailType createRFPResponseDetailType() {
        return new RFPResponseDetailType();
    }

    /**
     * Create an instance of {@link RoomSharesType }
     * 
     */
    public RoomSharesType createRoomSharesType() {
        return new RoomSharesType();
    }

    /**
     * Create an instance of {@link RoomSharesType.RoomShare }
     * 
     */
    public RoomSharesType.RoomShare createRoomSharesTypeRoomShare() {
        return new RoomSharesType.RoomShare();
    }

    /**
     * Create an instance of {@link RoomSharesType.RoomShare.GuestRPHs }
     * 
     */
    public RoomSharesType.RoomShare.GuestRPHs createRoomSharesTypeRoomShareGuestRPHs() {
        return new RoomSharesType.RoomShare.GuestRPHs();
    }

    /**
     * Create an instance of {@link FlightSegmentBaseType }
     * 
     */
    public FlightSegmentBaseType createFlightSegmentBaseType() {
        return new FlightSegmentBaseType();
    }

    /**
     * Create an instance of {@link DateTimeSpanType }
     * 
     */
    public DateTimeSpanType createDateTimeSpanType() {
        return new DateTimeSpanType();
    }

    /**
     * Create an instance of {@link InvBlockRoomType }
     * 
     */
    public InvBlockRoomType createInvBlockRoomType() {
        return new InvBlockRoomType();
    }

    /**
     * Create an instance of {@link InvBlockRoomType.RatePlans }
     * 
     */
    public InvBlockRoomType.RatePlans createInvBlockRoomTypeRatePlans() {
        return new InvBlockRoomType.RatePlans();
    }

    /**
     * Create an instance of {@link InvBlockRoomType.RatePlans.RatePlan }
     * 
     */
    public InvBlockRoomType.RatePlans.RatePlan createInvBlockRoomTypeRatePlansRatePlan() {
        return new InvBlockRoomType.RatePlans.RatePlan();
    }

    /**
     * Create an instance of {@link InvBlockRoomType.RoomTypeAllocations }
     * 
     */
    public InvBlockRoomType.RoomTypeAllocations createInvBlockRoomTypeRoomTypeAllocations() {
        return new InvBlockRoomType.RoomTypeAllocations();
    }

    /**
     * Create an instance of {@link RestaurantsType }
     * 
     */
    public RestaurantsType createRestaurantsType() {
        return new RestaurantsType();
    }

    /**
     * Create an instance of {@link RestaurantsType.SrvcInfoCodes }
     * 
     */
    public RestaurantsType.SrvcInfoCodes createRestaurantsTypeSrvcInfoCodes() {
        return new RestaurantsType.SrvcInfoCodes();
    }

    /**
     * Create an instance of {@link RestaurantType }
     * 
     */
    public RestaurantType createRestaurantType() {
        return new RestaurantType();
    }

    /**
     * Create an instance of {@link RestaurantsType.Restaurant }
     * 
     */
    public RestaurantsType.Restaurant createRestaurantsTypeRestaurant() {
        return new RestaurantsType.Restaurant();
    }

    /**
     * Create an instance of {@link RestaurantsType.Restaurant.SrvcInfoCodes }
     * 
     */
    public RestaurantsType.Restaurant.SrvcInfoCodes createRestaurantsTypeRestaurantSrvcInfoCodes() {
        return new RestaurantsType.Restaurant.SrvcInfoCodes();
    }

    /**
     * Create an instance of {@link RestaurantType.CuisineCodes }
     * 
     */
    public RestaurantType.CuisineCodes createRestaurantTypeCuisineCodes() {
        return new RestaurantType.CuisineCodes();
    }

    /**
     * Create an instance of {@link RestaurantType.InfoCodes }
     * 
     */
    public RestaurantType.InfoCodes createRestaurantTypeInfoCodes() {
        return new RestaurantType.InfoCodes();
    }

    /**
     * Create an instance of {@link GuestCountType }
     * 
     */
    public GuestCountType createGuestCountType() {
        return new GuestCountType();
    }

    /**
     * Create an instance of {@link HotelReservationType }
     * 
     */
    public HotelReservationType createHotelReservationType() {
        return new HotelReservationType();
    }

    /**
     * Create an instance of {@link HotelReservationType.BillingInstructionCode }
     * 
     */
    public HotelReservationType.BillingInstructionCode createHotelReservationTypeBillingInstructionCode() {
        return new HotelReservationType.BillingInstructionCode();
    }

    /**
     * Create an instance of {@link AreaInfoType }
     * 
     */
    public AreaInfoType createAreaInfoType() {
        return new AreaInfoType();
    }

    /**
     * Create an instance of {@link AreaInfoType.OtherHotels }
     * 
     */
    public AreaInfoType.OtherHotels createAreaInfoTypeOtherHotels() {
        return new AreaInfoType.OtherHotels();
    }

    /**
     * Create an instance of {@link AreaInfoType.Recreations }
     * 
     */
    public AreaInfoType.Recreations createAreaInfoTypeRecreations() {
        return new AreaInfoType.Recreations();
    }

    /**
     * Create an instance of {@link AreaInfoType.Recreations.Recreation }
     * 
     */
    public AreaInfoType.Recreations.Recreation createAreaInfoTypeRecreationsRecreation() {
        return new AreaInfoType.Recreations.Recreation();
    }

    /**
     * Create an instance of {@link AreaInfoType.Recreations.Recreation.RecreationDetails }
     * 
     */
    public AreaInfoType.Recreations.Recreation.RecreationDetails createAreaInfoTypeRecreationsRecreationRecreationDetails() {
        return new AreaInfoType.Recreations.Recreation.RecreationDetails();
    }

    /**
     * Create an instance of {@link AreaInfoType.Attractions }
     * 
     */
    public AreaInfoType.Attractions createAreaInfoTypeAttractions() {
        return new AreaInfoType.Attractions();
    }

    /**
     * Create an instance of {@link AreaInfoType.Attractions.Attraction }
     * 
     */
    public AreaInfoType.Attractions.Attraction createAreaInfoTypeAttractionsAttraction() {
        return new AreaInfoType.Attractions.Attraction();
    }

    /**
     * Create an instance of {@link RefPointsType }
     * 
     */
    public RefPointsType createRefPointsType() {
        return new RefPointsType();
    }

    /**
     * Create an instance of {@link RatePlanCandidatesType }
     * 
     */
    public RatePlanCandidatesType createRatePlanCandidatesType() {
        return new RatePlanCandidatesType();
    }

    /**
     * Create an instance of {@link RatePlanCandidatesType.RatePlanCandidate }
     * 
     */
    public RatePlanCandidatesType.RatePlanCandidate createRatePlanCandidatesTypeRatePlanCandidate() {
        return new RatePlanCandidatesType.RatePlanCandidate();
    }

    /**
     * Create an instance of {@link RatePlanCandidatesType.RatePlanCandidate.HotelRefs }
     * 
     */
    public RatePlanCandidatesType.RatePlanCandidate.HotelRefs createRatePlanCandidatesTypeRatePlanCandidateHotelRefs() {
        return new RatePlanCandidatesType.RatePlanCandidate.HotelRefs();
    }

    /**
     * Create an instance of {@link PaymentDetailType }
     * 
     */
    public PaymentDetailType createPaymentDetailType() {
        return new PaymentDetailType();
    }

    /**
     * Create an instance of {@link ResCommonDetailType }
     * 
     */
    public ResCommonDetailType createResCommonDetailType() {
        return new ResCommonDetailType();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType }
     * 
     */
    public ItemSearchCriterionType createItemSearchCriterionType() {
        return new ItemSearchCriterionType();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.AdditionalContents }
     * 
     */
    public ItemSearchCriterionType.AdditionalContents createItemSearchCriterionTypeAdditionalContents() {
        return new ItemSearchCriterionType.AdditionalContents();
    }

    /**
     * Create an instance of {@link RateType }
     * 
     */
    public RateType createRateType() {
        return new RateType();
    }

    /**
     * Create an instance of {@link AmountType }
     * 
     */
    public AmountType createAmountType() {
        return new AmountType();
    }

    /**
     * Create an instance of {@link MeetingRoomCapacityType }
     * 
     */
    public MeetingRoomCapacityType createMeetingRoomCapacityType() {
        return new MeetingRoomCapacityType();
    }

    /**
     * Create an instance of {@link ContactsType }
     * 
     */
    public ContactsType createContactsType() {
        return new ContactsType();
    }

    /**
     * Create an instance of {@link ContactsType.Name }
     * 
     */
    public ContactsType.Name createContactsTypeName() {
        return new ContactsType.Name();
    }

    /**
     * Create an instance of {@link DirectBillType }
     * 
     */
    public DirectBillType createDirectBillType() {
        return new DirectBillType();
    }

    /**
     * Create an instance of {@link TransportInfoType }
     * 
     */
    public TransportInfoType createTransportInfoType() {
        return new TransportInfoType();
    }

    /**
     * Create an instance of {@link RoomTypeType }
     * 
     */
    public RoomTypeType createRoomTypeType() {
        return new RoomTypeType();
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link CustomerType.CustLoyalty }
     * 
     */
    public CustomerType.CustLoyalty createCustomerTypeCustLoyalty() {
        return new CustomerType.CustLoyalty();
    }

    /**
     * Create an instance of {@link CustomerType.CustLoyalty.SecurityInfo }
     * 
     */
    public CustomerType.CustLoyalty.SecurityInfo createCustomerTypeCustLoyaltySecurityInfo() {
        return new CustomerType.CustLoyalty.SecurityInfo();
    }

    /**
     * Create an instance of {@link CustomerType.CustLoyalty.MemberPreferences }
     * 
     */
    public CustomerType.CustLoyalty.MemberPreferences createCustomerTypeCustLoyaltyMemberPreferences() {
        return new CustomerType.CustLoyalty.MemberPreferences();
    }

    /**
     * Create an instance of {@link CustomerType.CustLoyalty.MemberPreferences.Offer }
     * 
     */
    public CustomerType.CustLoyalty.MemberPreferences.Offer createCustomerTypeCustLoyaltyMemberPreferencesOffer() {
        return new CustomerType.CustLoyalty.MemberPreferences.Offer();
    }

    /**
     * Create an instance of {@link CustomerType.PaymentForm }
     * 
     */
    public CustomerType.PaymentForm createCustomerTypePaymentForm() {
        return new CustomerType.PaymentForm();
    }

    /**
     * Create an instance of {@link OrdersType }
     * 
     */
    public OrdersType createOrdersType() {
        return new OrdersType();
    }

    /**
     * Create an instance of {@link OrdersType.Order }
     * 
     */
    public OrdersType.Order createOrdersTypeOrder() {
        return new OrdersType.Order();
    }

    /**
     * Create an instance of {@link OrdersType.Order.Products }
     * 
     */
    public OrdersType.Order.Products createOrdersTypeOrderProducts() {
        return new OrdersType.Order.Products();
    }

    /**
     * Create an instance of {@link AcceptablePaymentCardsInfoType }
     * 
     */
    public AcceptablePaymentCardsInfoType createAcceptablePaymentCardsInfoType() {
        return new AcceptablePaymentCardsInfoType();
    }

    /**
     * Create an instance of {@link AcceptablePaymentCardsInfoType.AcceptablePaymentCards }
     * 
     */
    public AcceptablePaymentCardsInfoType.AcceptablePaymentCards createAcceptablePaymentCardsInfoTypeAcceptablePaymentCards() {
        return new AcceptablePaymentCardsInfoType.AcceptablePaymentCards();
    }

    /**
     * Create an instance of {@link ServiceRPHsType }
     * 
     */
    public ServiceRPHsType createServiceRPHsType() {
        return new ServiceRPHsType();
    }

    /**
     * Create an instance of {@link ProductDescriptionsType }
     * 
     */
    public ProductDescriptionsType createProductDescriptionsType() {
        return new ProductDescriptionsType();
    }

    /**
     * Create an instance of {@link TextItemsType }
     * 
     */
    public TextItemsType createTextItemsType() {
        return new TextItemsType();
    }

    /**
     * Create an instance of {@link TextDescriptionType }
     * 
     */
    public TextDescriptionType createTextDescriptionType() {
        return new TextDescriptionType();
    }

    /**
     * Create an instance of {@link OperationSchedulesPlusChargeType }
     * 
     */
    public OperationSchedulesPlusChargeType createOperationSchedulesPlusChargeType() {
        return new OperationSchedulesPlusChargeType();
    }

    /**
     * Create an instance of {@link SellableProductsType }
     * 
     */
    public SellableProductsType createSellableProductsType() {
        return new SellableProductsType();
    }

    /**
     * Create an instance of {@link SellableProductsType.SellableProduct }
     * 
     */
    public SellableProductsType.SellableProduct createSellableProductsTypeSellableProduct() {
        return new SellableProductsType.SellableProduct();
    }

    /**
     * Create an instance of {@link SellableProductsType.SellableProduct.DestinationSystemCodes }
     * 
     */
    public SellableProductsType.SellableProduct.DestinationSystemCodes createSellableProductsTypeSellableProductDestinationSystemCodes() {
        return new SellableProductsType.SellableProduct.DestinationSystemCodes();
    }

    /**
     * Create an instance of {@link RecipientInfosType }
     * 
     */
    public RecipientInfosType createRecipientInfosType() {
        return new RecipientInfosType();
    }

    /**
     * Create an instance of {@link ContactPersonType }
     * 
     */
    public ContactPersonType createContactPersonType() {
        return new ContactPersonType();
    }

    /**
     * Create an instance of {@link RecipientInfosType.RecipientInfo }
     * 
     */
    public RecipientInfosType.RecipientInfo createRecipientInfosTypeRecipientInfo() {
        return new RecipientInfosType.RecipientInfo();
    }

    /**
     * Create an instance of {@link CommonPrefType }
     * 
     */
    public CommonPrefType createCommonPrefType() {
        return new CommonPrefType();
    }

    /**
     * Create an instance of {@link RateQualifierType }
     * 
     */
    public RateQualifierType createRateQualifierType() {
        return new RateQualifierType();
    }

    /**
     * Create an instance of {@link RateQualifierType.RateComments }
     * 
     */
    public RateQualifierType.RateComments createRateQualifierTypeRateComments() {
        return new RateQualifierType.RateComments();
    }

    /**
     * Create an instance of {@link RoomStayType }
     * 
     */
    public RoomStayType createRoomStayType() {
        return new RoomStayType();
    }

    /**
     * Create an instance of {@link RoomStayType.RoomRates }
     * 
     */
    public RoomStayType.RoomRates createRoomStayTypeRoomRates() {
        return new RoomStayType.RoomRates();
    }

    /**
     * Create an instance of {@link RoomRateType }
     * 
     */
    public RoomRateType createRoomRateType() {
        return new RoomRateType();
    }

    /**
     * Create an instance of {@link RoomStayType.RoomRates.RoomRate }
     * 
     */
    public RoomStayType.RoomRates.RoomRate createRoomStayTypeRoomRatesRoomRate() {
        return new RoomStayType.RoomRates.RoomRate();
    }

    /**
     * Create an instance of {@link RoomStayType.RoomRates.RoomRate.GuestCounts }
     * 
     */
    public RoomStayType.RoomRates.RoomRate.GuestCounts createRoomStayTypeRoomRatesRoomRateGuestCounts() {
        return new RoomStayType.RoomRates.RoomRate.GuestCounts();
    }

    /**
     * Create an instance of {@link RoomStayType.RoomRates.RoomRate.Restrictions }
     * 
     */
    public RoomStayType.RoomRates.RoomRate.Restrictions createRoomStayTypeRoomRatesRoomRateRestrictions() {
        return new RoomStayType.RoomRates.RoomRate.Restrictions();
    }

    /**
     * Create an instance of {@link RoomRateType.Features }
     * 
     */
    public RoomRateType.Features createRoomRateTypeFeatures() {
        return new RoomRateType.Features();
    }

    /**
     * Create an instance of {@link HotelRoomListType }
     * 
     */
    public HotelRoomListType createHotelRoomListType() {
        return new HotelRoomListType();
    }

    /**
     * Create an instance of {@link HotelRoomListType.RoomStays }
     * 
     */
    public HotelRoomListType.RoomStays createHotelRoomListTypeRoomStays() {
        return new HotelRoomListType.RoomStays();
    }

    /**
     * Create an instance of {@link HotelRoomListType.MasterContact }
     * 
     */
    public HotelRoomListType.MasterContact createHotelRoomListTypeMasterContact() {
        return new HotelRoomListType.MasterContact();
    }

    /**
     * Create an instance of {@link HotelRoomListType.Guests }
     * 
     */
    public HotelRoomListType.Guests createHotelRoomListTypeGuests() {
        return new HotelRoomListType.Guests();
    }

    /**
     * Create an instance of {@link HotelRoomListType.Guests.Guest }
     * 
     */
    public HotelRoomListType.Guests.Guest createHotelRoomListTypeGuestsGuest() {
        return new HotelRoomListType.Guests.Guest();
    }

    /**
     * Create an instance of {@link HotelPaymentFormType }
     * 
     */
    public HotelPaymentFormType createHotelPaymentFormType() {
        return new HotelPaymentFormType();
    }

    /**
     * Create an instance of {@link TravelerRPHs }
     * 
     */
    public TravelerRPHs createTravelerRPHs() {
        return new TravelerRPHs();
    }

    /**
     * Create an instance of {@link HotelDescriptiveContentType }
     * 
     */
    public HotelDescriptiveContentType createHotelDescriptiveContentType() {
        return new HotelDescriptiveContentType();
    }

    /**
     * Create an instance of {@link HotelDescriptiveContentType.EffectivePeriods }
     * 
     */
    public HotelDescriptiveContentType.EffectivePeriods createHotelDescriptiveContentTypeEffectivePeriods() {
        return new HotelDescriptiveContentType.EffectivePeriods();
    }

    /**
     * Create an instance of {@link AffiliationInfoType }
     * 
     */
    public AffiliationInfoType createAffiliationInfoType() {
        return new AffiliationInfoType();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.PartnerInfos }
     * 
     */
    public AffiliationInfoType.PartnerInfos createAffiliationInfoTypePartnerInfos() {
        return new AffiliationInfoType.PartnerInfos();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.Awards }
     * 
     */
    public AffiliationInfoType.Awards createAffiliationInfoTypeAwards() {
        return new AffiliationInfoType.Awards();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.LoyalPrograms }
     * 
     */
    public AffiliationInfoType.LoyalPrograms createAffiliationInfoTypeLoyalPrograms() {
        return new AffiliationInfoType.LoyalPrograms();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.LoyalPrograms.LoyalProgram }
     * 
     */
    public AffiliationInfoType.LoyalPrograms.LoyalProgram createAffiliationInfoTypeLoyalProgramsLoyalProgram() {
        return new AffiliationInfoType.LoyalPrograms.LoyalProgram();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.Brands }
     * 
     */
    public AffiliationInfoType.Brands createAffiliationInfoTypeBrands() {
        return new AffiliationInfoType.Brands();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.DistribSystems }
     * 
     */
    public AffiliationInfoType.DistribSystems createAffiliationInfoTypeDistribSystems() {
        return new AffiliationInfoType.DistribSystems();
    }

    /**
     * Create an instance of {@link DocumentType }
     * 
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link ResGuestRPHsType }
     * 
     */
    public ResGuestRPHsType createResGuestRPHsType() {
        return new ResGuestRPHsType();
    }

    /**
     * Create an instance of {@link HotelReservationIDsType }
     * 
     */
    public HotelReservationIDsType createHotelReservationIDsType() {
        return new HotelReservationIDsType();
    }

    /**
     * Create an instance of {@link RoutingHopType }
     * 
     */
    public RoutingHopType createRoutingHopType() {
        return new RoutingHopType();
    }

    /**
     * Create an instance of {@link LoyaltyPointsAccrualsType }
     * 
     */
    public LoyaltyPointsAccrualsType createLoyaltyPointsAccrualsType() {
        return new LoyaltyPointsAccrualsType();
    }

    /**
     * Create an instance of {@link CommentType }
     * 
     */
    public CommentType createCommentType() {
        return new CommentType();
    }

    /**
     * Create an instance of {@link GuestRoomType }
     * 
     */
    public GuestRoomType createGuestRoomType() {
        return new GuestRoomType();
    }

    /**
     * Create an instance of {@link GuestRoomType.Amenities }
     * 
     */
    public GuestRoomType.Amenities createGuestRoomTypeAmenities() {
        return new GuestRoomType.Amenities();
    }

    /**
     * Create an instance of {@link AdjustmentsType }
     * 
     */
    public AdjustmentsType createAdjustmentsType() {
        return new AdjustmentsType();
    }

    /**
     * Create an instance of {@link StatisticType }
     * 
     */
    public StatisticType createStatisticType() {
        return new StatisticType();
    }

    /**
     * Create an instance of {@link PhonePrefType }
     * 
     */
    public PhonePrefType createPhonePrefType() {
        return new PhonePrefType();
    }

    /**
     * Create an instance of {@link ImageDescriptionType }
     * 
     */
    public ImageDescriptionType createImageDescriptionType() {
        return new ImageDescriptionType();
    }

    /**
     * Create an instance of {@link ConnectionType }
     * 
     */
    public ConnectionType createConnectionType() {
        return new ConnectionType();
    }

    /**
     * Create an instance of {@link GDSInfoType }
     * 
     */
    public GDSInfoType createGDSInfoType() {
        return new GDSInfoType();
    }

    /**
     * Create an instance of {@link GDSInfoType.GDSCodes }
     * 
     */
    public GDSInfoType.GDSCodes createGDSInfoTypeGDSCodes() {
        return new GDSInfoType.GDSCodes();
    }

    /**
     * Create an instance of {@link GDSInfoType.GDSCodes.GDSCode }
     * 
     */
    public GDSInfoType.GDSCodes.GDSCode createGDSInfoTypeGDSCodesGDSCode() {
        return new GDSInfoType.GDSCodes.GDSCode();
    }

    /**
     * Create an instance of {@link GDSInfoType.GDSCodes.GDSCode.GDSCodeDetails }
     * 
     */
    public GDSInfoType.GDSCodes.GDSCode.GDSCodeDetails createGDSInfoTypeGDSCodesGDSCodeGDSCodeDetails() {
        return new GDSInfoType.GDSCodes.GDSCode.GDSCodeDetails();
    }

    /**
     * Create an instance of {@link TravelClubType }
     * 
     */
    public TravelClubType createTravelClubType() {
        return new TravelClubType();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link SpecialRequestType }
     * 
     */
    public SpecialRequestType createSpecialRequestType() {
        return new SpecialRequestType();
    }

    /**
     * Create an instance of {@link PhonesType }
     * 
     */
    public PhonesType createPhonesType() {
        return new PhonesType();
    }

    /**
     * Create an instance of {@link CompanyInfoType }
     * 
     */
    public CompanyInfoType createCompanyInfoType() {
        return new CompanyInfoType();
    }

    /**
     * Create an instance of {@link AvailStatusMessageType }
     * 
     */
    public AvailStatusMessageType createAvailStatusMessageType() {
        return new AvailStatusMessageType();
    }

    /**
     * Create an instance of {@link AvailStatusMessageType.BestAvailableRates }
     * 
     */
    public AvailStatusMessageType.BestAvailableRates createAvailStatusMessageTypeBestAvailableRates() {
        return new AvailStatusMessageType.BestAvailableRates();
    }

    /**
     * Create an instance of {@link SourceType }
     * 
     */
    public SourceType createSourceType() {
        return new SourceType();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType }
     * 
     */
    public HotelSearchCriterionType createHotelSearchCriterionType() {
        return new HotelSearchCriterionType();
    }

    /**
     * Create an instance of {@link HotelInfoType }
     * 
     */
    public HotelInfoType createHotelInfoType() {
        return new HotelInfoType();
    }

    /**
     * Create an instance of {@link HotelInfoType.Languages }
     * 
     */
    public HotelInfoType.Languages createHotelInfoTypeLanguages() {
        return new HotelInfoType.Languages();
    }

    /**
     * Create an instance of {@link HotelInfoType.OwnershipManagementInfos }
     * 
     */
    public HotelInfoType.OwnershipManagementInfos createHotelInfoTypeOwnershipManagementInfos() {
        return new HotelInfoType.OwnershipManagementInfos();
    }

    /**
     * Create an instance of {@link HotelInfoType.Services }
     * 
     */
    public HotelInfoType.Services createHotelInfoTypeServices() {
        return new HotelInfoType.Services();
    }

    /**
     * Create an instance of {@link HotelInfoType.HotelInfoCodes }
     * 
     */
    public HotelInfoType.HotelInfoCodes createHotelInfoTypeHotelInfoCodes() {
        return new HotelInfoType.HotelInfoCodes();
    }

    /**
     * Create an instance of {@link HotelInfoType.Descriptions }
     * 
     */
    public HotelInfoType.Descriptions createHotelInfoTypeDescriptions() {
        return new HotelInfoType.Descriptions();
    }

    /**
     * Create an instance of {@link HotelSearchCriteriaType }
     * 
     */
    public HotelSearchCriteriaType createHotelSearchCriteriaType() {
        return new HotelSearchCriteriaType();
    }

    /**
     * Create an instance of {@link PreferencesType }
     * 
     */
    public PreferencesType createPreferencesType() {
        return new PreferencesType();
    }

    /**
     * Create an instance of {@link VideoItemsType }
     * 
     */
    public VideoItemsType createVideoItemsType() {
        return new VideoItemsType();
    }

    /**
     * Create an instance of {@link LengthsOfStayType }
     * 
     */
    public LengthsOfStayType createLengthsOfStayType() {
        return new LengthsOfStayType();
    }

    /**
     * Create an instance of {@link LengthsOfStayType.LengthOfStay }
     * 
     */
    public LengthsOfStayType.LengthOfStay createLengthsOfStayTypeLengthOfStay() {
        return new LengthsOfStayType.LengthOfStay();
    }

    /**
     * Create an instance of {@link MembershipType }
     * 
     */
    public MembershipType createMembershipType() {
        return new MembershipType();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.ProfileType }
     * 
     */
    public com.desia.artifacts.booking.ProfileType createProfileType() {
        return new com.desia.artifacts.booking.ProfileType();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.ProfileType.Comments }
     * 
     */
    public com.desia.artifacts.booking.ProfileType.Comments createProfileTypeComments() {
        return new com.desia.artifacts.booking.ProfileType.Comments();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.ProfileType.Comments.Comment }
     * 
     */
    public com.desia.artifacts.booking.ProfileType.Comments.Comment createProfileTypeCommentsComment() {
        return new com.desia.artifacts.booking.ProfileType.Comments.Comment();
    }

    /**
     * Create an instance of {@link HotelAdditionalChargesType }
     * 
     */
    public HotelAdditionalChargesType createHotelAdditionalChargesType() {
        return new HotelAdditionalChargesType();
    }

    /**
     * Create an instance of {@link BaseInvCountType }
     * 
     */
    public BaseInvCountType createBaseInvCountType() {
        return new BaseInvCountType();
    }

    /**
     * Create an instance of {@link BaseInvCountType.InvCounts }
     * 
     */
    public BaseInvCountType.InvCounts createBaseInvCountTypeInvCounts() {
        return new BaseInvCountType.InvCounts();
    }

    /**
     * Create an instance of {@link BaseInvCountType.InvCounts.InvCount }
     * 
     */
    public BaseInvCountType.InvCounts.InvCount createBaseInvCountTypeInvCountsInvCount() {
        return new BaseInvCountType.InvCounts.InvCount();
    }

    /**
     * Create an instance of {@link CategoryCodesType }
     * 
     */
    public CategoryCodesType createCategoryCodesType() {
        return new CategoryCodesType();
    }

    /**
     * Create an instance of {@link CategoryCodesType.GuestRoomInfo }
     * 
     */
    public CategoryCodesType.GuestRoomInfo createCategoryCodesTypeGuestRoomInfo() {
        return new CategoryCodesType.GuestRoomInfo();
    }

    /**
     * Create an instance of {@link CategoryCodesType.GuestRoomInfo.RateRanges }
     * 
     */
    public CategoryCodesType.GuestRoomInfo.RateRanges createCategoryCodesTypeGuestRoomInfoRateRanges() {
        return new CategoryCodesType.GuestRoomInfo.RateRanges();
    }

    /**
     * Create an instance of {@link RoomStayLiteType }
     * 
     */
    public RoomStayLiteType createRoomStayLiteType() {
        return new RoomStayLiteType();
    }

    /**
     * Create an instance of {@link RatePlanType }
     * 
     */
    public RatePlanType createRatePlanType() {
        return new RatePlanType();
    }

    /**
     * Create an instance of {@link ResGuestType }
     * 
     */
    public ResGuestType createResGuestType() {
        return new ResGuestType();
    }

    /**
     * Create an instance of {@link ResGuestType.ProfileRPHs }
     * 
     */
    public ResGuestType.ProfileRPHs createResGuestTypeProfileRPHs() {
        return new ResGuestType.ProfileRPHs();
    }

    /**
     * Create an instance of {@link ImageItemsType }
     * 
     */
    public ImageItemsType createImageItemsType() {
        return new ImageItemsType();
    }

    /**
     * Create an instance of {@link EmailsType }
     * 
     */
    public EmailsType createEmailsType() {
        return new EmailsType();
    }

    /**
     * Create an instance of {@link AvailRequestSegmentsType }
     * 
     */
    public AvailRequestSegmentsType createAvailRequestSegmentsType() {
        return new AvailRequestSegmentsType();
    }

    /**
     * Create an instance of {@link AvailRequestSegmentsType.AvailRequestSegment }
     * 
     */
    public AvailRequestSegmentsType.AvailRequestSegment createAvailRequestSegmentsTypeAvailRequestSegment() {
        return new AvailRequestSegmentsType.AvailRequestSegment();
    }

    /**
     * Create an instance of {@link PaymentCardType }
     * 
     */
    public PaymentCardType createPaymentCardType() {
        return new PaymentCardType();
    }

    /**
     * Create an instance of {@link HotelResModifyType }
     * 
     */
    public HotelResModifyType createHotelResModifyType() {
        return new HotelResModifyType();
    }

    /**
     * Create an instance of {@link HotelResModifyType.HotelResModify }
     * 
     */
    public HotelResModifyType.HotelResModify createHotelResModifyTypeHotelResModify() {
        return new HotelResModifyType.HotelResModify();
    }

    /**
     * Create an instance of {@link VerificationType }
     * 
     */
    public VerificationType createVerificationType() {
        return new VerificationType();
    }

    /**
     * Create an instance of {@link CommissionType }
     * 
     */
    public CommissionType createCommissionType() {
        return new CommissionType();
    }

    /**
     * Create an instance of {@link CancelPenaltyType }
     * 
     */
    public CancelPenaltyType createCancelPenaltyType() {
        return new CancelPenaltyType();
    }

    /**
     * Create an instance of {@link AgreementsType }
     * 
     */
    public AgreementsType createAgreementsType() {
        return new AgreementsType();
    }

    /**
     * Create an instance of {@link RoomStaysType }
     * 
     */
    public RoomStaysType createRoomStaysType() {
        return new RoomStaysType();
    }

    /**
     * Create an instance of {@link RoomStaysType.RoomStay }
     * 
     */
    public RoomStaysType.RoomStay createRoomStaysTypeRoomStay() {
        return new RoomStaysType.RoomStay();
    }

    /**
     * Create an instance of {@link DonationType }
     * 
     */
    public DonationType createDonationType() {
        return new DonationType();
    }

    /**
     * Create an instance of {@link DonationType.DonorInfo }
     * 
     */
    public DonationType.DonorInfo createDonationTypeDonorInfo() {
        return new DonationType.DonorInfo();
    }

    /**
     * Create an instance of {@link OTACancelRQ.Reasons }
     * 
     */
    public OTACancelRQ.Reasons createOTACancelRQReasons() {
        return new OTACancelRQ.Reasons();
    }

    /**
     * Create an instance of {@link OTACancelRQ.OriginAndDestinationSegment }
     * 
     */
    public OTACancelRQ.OriginAndDestinationSegment createOTACancelRQOriginAndDestinationSegment() {
        return new OTACancelRQ.OriginAndDestinationSegment();
    }

    /**
     * Create an instance of {@link ImageJSON.ImagesList }
     * 
     */
    public ImageJSON.ImagesList createImageJSONImagesList() {
        return new ImageJSON.ImagesList();
    }

    /**
     * Create an instance of {@link CancelInfoRSType }
     * 
     */
    public CancelInfoRSType createCancelInfoRSType() {
        return new CancelInfoRSType();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.CurrencyConversions }
     * 
     */
    public OTAHotelAvailRS.CurrencyConversions createOTAHotelAvailRSCurrencyConversions() {
        return new OTAHotelAvailRS.CurrencyConversions();
    }

    /**
     * Create an instance of {@link AreasType }
     * 
     */
    public AreasType createAreasType() {
        return new AreasType();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.RoomStays }
     * 
     */
    public OTAHotelAvailRS.RoomStays createOTAHotelAvailRSRoomStays() {
        return new OTAHotelAvailRS.RoomStays();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.RoomStays.RoomStay }
     * 
     */
    public OTAHotelAvailRS.RoomStays.RoomStay createOTAHotelAvailRSRoomStaysRoomStay() {
        return new OTAHotelAvailRS.RoomStays.RoomStay();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.HotelStays }
     * 
     */
    public OTAHotelAvailRS.HotelStays createOTAHotelAvailRSHotelStays() {
        return new OTAHotelAvailRS.HotelStays();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.HotelStays.HotelStay }
     * 
     */
    public OTAHotelAvailRS.HotelStays.HotelStay createOTAHotelAvailRSHotelStaysHotelStay() {
        return new OTAHotelAvailRS.HotelStays.HotelStay();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.HotelStays.HotelStay.Availability }
     * 
     */
    public OTAHotelAvailRS.HotelStays.HotelStay.Availability createOTAHotelAvailRSHotelStaysHotelStayAvailability() {
        return new OTAHotelAvailRS.HotelStays.HotelStay.Availability();
    }

    /**
     * Create an instance of {@link OTANotifReportRQ.NotifDetails }
     * 
     */
    public OTANotifReportRQ.NotifDetails createOTANotifReportRQNotifDetails() {
        return new OTANotifReportRQ.NotifDetails();
    }

    /**
     * Create an instance of {@link OTANotifReportRQ.NotifDetails.HotelNotifReport }
     * 
     */
    public OTANotifReportRQ.NotifDetails.HotelNotifReport createOTANotifReportRQNotifDetailsHotelNotifReport() {
        return new OTANotifReportRQ.NotifDetails.HotelNotifReport();
    }

    /**
     * Create an instance of {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents }
     * 
     */
    public OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents createOTANotifReportRQNotifDetailsHotelNotifReportHotelDescriptiveContents() {
        return new OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents();
    }

    /**
     * Create an instance of {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages }
     * 
     */
    public OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages createOTANotifReportRQNotifDetailsHotelNotifReportAvailStatusMessages() {
        return new OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages();
    }

    /**
     * Create an instance of {@link HotelReservationsType }
     * 
     */
    public HotelReservationsType createHotelReservationsType() {
        return new HotelReservationsType();
    }

    /**
     * Create an instance of {@link HotelReservationsType.HotelReservation }
     * 
     */
    public HotelReservationsType.HotelReservation createHotelReservationsTypeHotelReservation() {
        return new HotelReservationsType.HotelReservation();
    }

    /**
     * Create an instance of {@link TPAExtensionsType }
     * 
     */
    public TPAExtensionsType createTPAExtensionsType() {
        return new TPAExtensionsType();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.AdditionalGuests }
     * 
     */
    public TPAExtensionsType.AdditionalGuests createTPAExtensionsTypeAdditionalGuests() {
        return new TPAExtensionsType.AdditionalGuests();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.Deals }
     * 
     */
    public TPAExtensionsType.Deals createTPAExtensionsTypeDeals() {
        return new TPAExtensionsType.Deals();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.SeoInformation }
     * 
     */
    public TPAExtensionsType.SeoInformation createTPAExtensionsTypeSeoInformation() {
        return new TPAExtensionsType.SeoInformation();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.SeoInformation.SeoPageData }
     * 
     */
    public TPAExtensionsType.SeoInformation.SeoPageData createTPAExtensionsTypeSeoInformationSeoPageData() {
        return new TPAExtensionsType.SeoInformation.SeoPageData();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages }
     * 
     */
    public TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages createTPAExtensionsTypeSeoInformationSeoPageDataOtherSeoPages() {
        return new TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.SeoInformation.Destinations }
     * 
     */
    public TPAExtensionsType.SeoInformation.Destinations createTPAExtensionsTypeSeoInformationDestinations() {
        return new TPAExtensionsType.SeoInformation.Destinations();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.SeoInformation.Destinations.Destination }
     * 
     */
    public TPAExtensionsType.SeoInformation.Destinations.Destination createTPAExtensionsTypeSeoInformationDestinationsDestination() {
        return new TPAExtensionsType.SeoInformation.Destinations.Destination();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations }
     * 
     */
    public TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations createTPAExtensionsTypeSeoInformationDestinationsDestinationOtherDestinations() {
        return new TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.Rate }
     * 
     */
    public TPAExtensionsType.Rate createTPAExtensionsTypeRate() {
        return new TPAExtensionsType.Rate();
    }

    /**
     * Create an instance of {@link HotelResModifyRequestType }
     * 
     */
    public HotelResModifyRequestType createHotelResModifyRequestType() {
        return new HotelResModifyRequestType();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.Description }
     * 
     */
    public com.desia.artifacts.booking.Description createDescription() {
        return new com.desia.artifacts.booking.Description();
    }

    /**
     * Create an instance of {@link OTAHotelResRS }
     * 
     */
    public OTAHotelResRS createOTAHotelResRS() {
        return new OTAHotelResRS();
    }

    /**
     * Create an instance of {@link HotelResResponseType }
     * 
     */
    public HotelResResponseType createHotelResResponseType() {
        return new HotelResResponseType();
    }

    /**
     * Create an instance of {@link POSType }
     * 
     */
    public POSType createPOSType() {
        return new POSType();
    }

    /**
     * Create an instance of {@link SuccessType }
     * 
     */
    public SuccessType createSuccessType() {
        return new SuccessType();
    }

    /**
     * Create an instance of {@link WarningsType }
     * 
     */
    public WarningsType createWarningsType() {
        return new WarningsType();
    }

    /**
     * Create an instance of {@link ErrorsType }
     * 
     */
    public ErrorsType createErrorsType() {
        return new ErrorsType();
    }

    /**
     * Create an instance of {@link MessageAcknowledgementType }
     * 
     */
    public MessageAcknowledgementType createMessageAcknowledgementType() {
        return new MessageAcknowledgementType();
    }

    /**
     * Create an instance of {@link UniqueIDType }
     * 
     */
    public UniqueIDType createUniqueIDType() {
        return new UniqueIDType();
    }

    /**
     * Create an instance of {@link HotelPOI }
     * 
     */
    public HotelPOI createHotelPOI() {
        return new HotelPOI();
    }

    /**
     * Create an instance of {@link POI }
     * 
     */
    public POI createPOI() {
        return new POI();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRQ.AvailRequestSegments }
     * 
     */
    public OTAHotelAvailRQ.AvailRequestSegments createOTAHotelAvailRQAvailRequestSegments() {
        return new OTAHotelAvailRQ.AvailRequestSegments();
    }

    /**
     * Create an instance of {@link ServicesType }
     * 
     */
    public ServicesType createServicesType() {
        return new ServicesType();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.Criteria }
     * 
     */
    public OTAHotelAvailRS.Criteria createOTAHotelAvailRSCriteria() {
        return new OTAHotelAvailRS.Criteria();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.RebatePrograms }
     * 
     */
    public OTAHotelAvailRS.RebatePrograms createOTAHotelAvailRSRebatePrograms() {
        return new OTAHotelAvailRS.RebatePrograms();
    }

    /**
     * Create an instance of {@link HotelResModifyResponseType }
     * 
     */
    public HotelResModifyResponseType createHotelResModifyResponseType() {
        return new HotelResModifyResponseType();
    }

    /**
     * Create an instance of {@link Pagination }
     * 
     */
    public Pagination createPagination() {
        return new Pagination();
    }

    /**
     * Create an instance of {@link Reviews }
     * 
     */
    public Reviews createReviews() {
        return new Reviews();
    }

    /**
     * Create an instance of {@link OTACancelRS.Segment }
     * 
     */
    public OTACancelRS.Segment createOTACancelRSSegment() {
        return new OTACancelRS.Segment();
    }

    /**
     * Create an instance of {@link OTAHotelResNotifRS }
     * 
     */
    public OTAHotelResNotifRS createOTAHotelResNotifRS() {
        return new OTAHotelResNotifRS();
    }

    /**
     * Create an instance of {@link OTACancelRQ.UniqueID }
     * 
     */
    public OTACancelRQ.UniqueID createOTACancelRQUniqueID() {
        return new OTACancelRQ.UniqueID();
    }

    /**
     * Create an instance of {@link OTACancelRQ.Segment }
     * 
     */
    public OTACancelRQ.Segment createOTACancelRQSegment() {
        return new OTACancelRQ.Segment();
    }

    /**
     * Create an instance of {@link OTACancelRQ.CancellationOverrides }
     * 
     */
    public OTACancelRQ.CancellationOverrides createOTACancelRQCancellationOverrides() {
        return new OTACancelRQ.CancellationOverrides();
    }

    /**
     * Create an instance of {@link HotelResRequestType }
     * 
     */
    public HotelResRequestType createHotelResRequestType() {
        return new HotelResRequestType();
    }

    /**
     * Create an instance of {@link OTAHotelResRQ.RebatePrograms }
     * 
     */
    public OTAHotelResRQ.RebatePrograms createOTAHotelResRQRebatePrograms() {
        return new OTAHotelResRQ.RebatePrograms();
    }

    /**
     * Create an instance of {@link OTAHotelResNotifRQ }
     * 
     */
    public OTAHotelResNotifRQ createOTAHotelResNotifRQ() {
        return new OTAHotelResNotifRQ();
    }

    /**
     * Create an instance of {@link HotelsInfo }
     * 
     */
    public HotelsInfo createHotelsInfo() {
        return new HotelsInfo();
    }

    /**
     * Create an instance of {@link ImageDTO }
     * 
     */
    public ImageDTO createImageDTO() {
        return new ImageDTO();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.Amenities.PropertyAmenities }
     * 
     */
    public com.desia.artifacts.booking.Amenities.PropertyAmenities createAmenitiesPropertyAmenities() {
        return new com.desia.artifacts.booking.Amenities.PropertyAmenities();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.Amenities.RoomAmenities }
     * 
     */
    public com.desia.artifacts.booking.Amenities.RoomAmenities createAmenitiesRoomAmenities() {
        return new com.desia.artifacts.booking.Amenities.RoomAmenities();
    }

    /**
     * Create an instance of {@link HotelBasicInformation.Multimedia }
     * 
     */
    public HotelBasicInformation.Multimedia createHotelBasicInformationMultimedia() {
        return new HotelBasicInformation.Multimedia();
    }

    /**
     * Create an instance of {@link HotelBasicInformation.CrossLinks }
     * 
     */
    public HotelBasicInformation.CrossLinks createHotelBasicInformationCrossLinks() {
        return new HotelBasicInformation.CrossLinks();
    }

    /**
     * Create an instance of {@link RebateType }
     * 
     */
    public RebateType createRebateType() {
        return new RebateType();
    }

    /**
     * Create an instance of {@link TransportationsType }
     * 
     */
    public TransportationsType createTransportationsType() {
        return new TransportationsType();
    }

    /**
     * Create an instance of {@link SeatingPrefType }
     * 
     */
    public SeatingPrefType createSeatingPrefType() {
        return new SeatingPrefType();
    }

    /**
     * Create an instance of {@link InterestPrefType }
     * 
     */
    public InterestPrefType createInterestPrefType() {
        return new InterestPrefType();
    }

    /**
     * Create an instance of {@link TimeDurationType }
     * 
     */
    public TimeDurationType createTimeDurationType() {
        return new TimeDurationType();
    }

    /**
     * Create an instance of {@link RevenueDetailsType }
     * 
     */
    public RevenueDetailsType createRevenueDetailsType() {
        return new RevenueDetailsType();
    }

    /**
     * Create an instance of {@link OperatingAirlineType }
     * 
     */
    public OperatingAirlineType createOperatingAirlineType() {
        return new OperatingAirlineType();
    }

    /**
     * Create an instance of {@link OperationSchedulesType }
     * 
     */
    public OperationSchedulesType createOperationSchedulesType() {
        return new OperationSchedulesType();
    }

    /**
     * Create an instance of {@link RevenueDetailType }
     * 
     */
    public RevenueDetailType createRevenueDetailType() {
        return new RevenueDetailType();
    }

    /**
     * Create an instance of {@link AmountPercentType }
     * 
     */
    public AmountPercentType createAmountPercentType() {
        return new AmountPercentType();
    }

    /**
     * Create an instance of {@link BusinessSrvcPrefType }
     * 
     */
    public BusinessSrvcPrefType createBusinessSrvcPrefType() {
        return new BusinessSrvcPrefType();
    }

    /**
     * Create an instance of {@link RoomRateLiteType }
     * 
     */
    public RoomRateLiteType createRoomRateLiteType() {
        return new RoomRateLiteType();
    }

    /**
     * Create an instance of {@link VendorMessagesType }
     * 
     */
    public VendorMessagesType createVendorMessagesType() {
        return new VendorMessagesType();
    }

    /**
     * Create an instance of {@link WrittenConfInstType }
     * 
     */
    public WrittenConfInstType createWrittenConfInstType() {
        return new WrittenConfInstType();
    }

    /**
     * Create an instance of {@link DOWRulesType }
     * 
     */
    public DOWRulesType createDOWRulesType() {
        return new DOWRulesType();
    }

    /**
     * Create an instance of {@link OtherSrvcPrefType }
     * 
     */
    public OtherSrvcPrefType createOtherSrvcPrefType() {
        return new OtherSrvcPrefType();
    }

    /**
     * Create an instance of {@link PaymentRulesType }
     * 
     */
    public PaymentRulesType createPaymentRulesType() {
        return new PaymentRulesType();
    }

    /**
     * Create an instance of {@link TimeInstantType }
     * 
     */
    public TimeInstantType createTimeInstantType() {
        return new TimeInstantType();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link RecreationSrvcPrefType }
     * 
     */
    public RecreationSrvcPrefType createRecreationSrvcPrefType() {
        return new RecreationSrvcPrefType();
    }

    /**
     * Create an instance of {@link DescriptionType }
     * 
     */
    public DescriptionType createDescriptionType() {
        return new DescriptionType();
    }

    /**
     * Create an instance of {@link WarningType }
     * 
     */
    public WarningType createWarningType() {
        return new WarningType();
    }

    /**
     * Create an instance of {@link RoomAmenityPrefType }
     * 
     */
    public RoomAmenityPrefType createRoomAmenityPrefType() {
        return new RoomAmenityPrefType();
    }

    /**
     * Create an instance of {@link ReferencePlaceHolderType }
     * 
     */
    public ReferencePlaceHolderType createReferencePlaceHolderType() {
        return new ReferencePlaceHolderType();
    }

    /**
     * Create an instance of {@link EmployeeInfoType }
     * 
     */
    public EmployeeInfoType createEmployeeInfoType() {
        return new EmployeeInfoType();
    }

    /**
     * Create an instance of {@link MultimediaDescriptionsType }
     * 
     */
    public MultimediaDescriptionsType createMultimediaDescriptionsType() {
        return new MultimediaDescriptionsType();
    }

    /**
     * Create an instance of {@link ImageItemType }
     * 
     */
    public ImageItemType createImageItemType() {
        return new ImageItemType();
    }

    /**
     * Create an instance of {@link StayInfoType }
     * 
     */
    public StayInfoType createStayInfoType() {
        return new StayInfoType();
    }

    /**
     * Create an instance of {@link MultimediaDescriptionType }
     * 
     */
    public MultimediaDescriptionType createMultimediaDescriptionType() {
        return new MultimediaDescriptionType();
    }

    /**
     * Create an instance of {@link AmountLiteType }
     * 
     */
    public AmountLiteType createAmountLiteType() {
        return new AmountLiteType();
    }

    /**
     * Create an instance of {@link StreetNmbrType }
     * 
     */
    public StreetNmbrType createStreetNmbrType() {
        return new StreetNmbrType();
    }

    /**
     * Create an instance of {@link VendorMessageType }
     * 
     */
    public VendorMessageType createVendorMessageType() {
        return new VendorMessageType();
    }

    /**
     * Create an instance of {@link EquipmentType }
     * 
     */
    public EquipmentType createEquipmentType() {
        return new EquipmentType();
    }

    /**
     * Create an instance of {@link BedTypePrefType }
     * 
     */
    public BedTypePrefType createBedTypePrefType() {
        return new BedTypePrefType();
    }

    /**
     * Create an instance of {@link RelatedTravelerType }
     * 
     */
    public RelatedTravelerType createRelatedTravelerType() {
        return new RelatedTravelerType();
    }

    /**
     * Create an instance of {@link TicketDistribPrefType }
     * 
     */
    public TicketDistribPrefType createTicketDistribPrefType() {
        return new TicketDistribPrefType();
    }

    /**
     * Create an instance of {@link TaxType }
     * 
     */
    public TaxType createTaxType() {
        return new TaxType();
    }

    /**
     * Create an instance of {@link StatusApplicationControlType }
     * 
     */
    public StatusApplicationControlType createStatusApplicationControlType() {
        return new StatusApplicationControlType();
    }

    /**
     * Create an instance of {@link InsurancePrefType }
     * 
     */
    public InsurancePrefType createInsurancePrefType() {
        return new InsurancePrefType();
    }

    /**
     * Create an instance of {@link DiscountType }
     * 
     */
    public DiscountType createDiscountType() {
        return new DiscountType();
    }

    /**
     * Create an instance of {@link RoomTypeLiteType }
     * 
     */
    public RoomTypeLiteType createRoomTypeLiteType() {
        return new RoomTypeLiteType();
    }

    /**
     * Create an instance of {@link FeeType }
     * 
     */
    public FeeType createFeeType() {
        return new FeeType();
    }

    /**
     * Create an instance of {@link RevenueCategoriesType }
     * 
     */
    public RevenueCategoriesType createRevenueCategoriesType() {
        return new RevenueCategoriesType();
    }

    /**
     * Create an instance of {@link CompanyNamePrefType }
     * 
     */
    public CompanyNamePrefType createCompanyNamePrefType() {
        return new CompanyNamePrefType();
    }

    /**
     * Create an instance of {@link ContactInfoRootType }
     * 
     */
    public ContactInfoRootType createContactInfoRootType() {
        return new ContactInfoRootType();
    }

    /**
     * Create an instance of {@link CompanyNameType }
     * 
     */
    public CompanyNameType createCompanyNameType() {
        return new CompanyNameType();
    }

    /**
     * Create an instance of {@link PropertyTypePrefType }
     * 
     */
    public PropertyTypePrefType createPropertyTypePrefType() {
        return new PropertyTypePrefType();
    }

    /**
     * Create an instance of {@link SpecRequestPrefType }
     * 
     */
    public SpecRequestPrefType createSpecRequestPrefType() {
        return new SpecRequestPrefType();
    }

    /**
     * Create an instance of {@link FreeTextType }
     * 
     */
    public FreeTextType createFreeTextType() {
        return new FreeTextType();
    }

    /**
     * Create an instance of {@link URLType }
     * 
     */
    public URLType createURLType() {
        return new URLType();
    }

    /**
     * Create an instance of {@link SecurityFeaturePrefType }
     * 
     */
    public SecurityFeaturePrefType createSecurityFeaturePrefType() {
        return new SecurityFeaturePrefType();
    }

    /**
     * Create an instance of {@link HotelPrefType }
     * 
     */
    public HotelPrefType createHotelPrefType() {
        return new HotelPrefType();
    }

    /**
     * Create an instance of {@link RateLiteType }
     * 
     */
    public RateLiteType createRateLiteType() {
        return new RateLiteType();
    }

    /**
     * Create an instance of {@link AddressInfoType }
     * 
     */
    public AddressInfoType createAddressInfoType() {
        return new AddressInfoType();
    }

    /**
     * Create an instance of {@link MonetaryRuleType }
     * 
     */
    public MonetaryRuleType createMonetaryRuleType() {
        return new MonetaryRuleType();
    }

    /**
     * Create an instance of {@link CancelPenaltiesType }
     * 
     */
    public CancelPenaltiesType createCancelPenaltiesType() {
        return new CancelPenaltiesType();
    }

    /**
     * Create an instance of {@link PropertyNamePrefType }
     * 
     */
    public PropertyNamePrefType createPropertyNamePrefType() {
        return new PropertyNamePrefType();
    }

    /**
     * Create an instance of {@link LocationType }
     * 
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link CertificationType }
     * 
     */
    public CertificationType createCertificationType() {
        return new CertificationType();
    }

    /**
     * Create an instance of {@link EmailType }
     * 
     */
    public EmailType createEmailType() {
        return new EmailType();
    }

    /**
     * Create an instance of {@link StateProvType }
     * 
     */
    public StateProvType createStateProvType() {
        return new StateProvType();
    }

    /**
     * Create an instance of {@link LocationGeneralType }
     * 
     */
    public LocationGeneralType createLocationGeneralType() {
        return new LocationGeneralType();
    }

    /**
     * Create an instance of {@link RoomStayCandidateType }
     * 
     */
    public RoomStayCandidateType createRoomStayCandidateType() {
        return new RoomStayCandidateType();
    }

    /**
     * Create an instance of {@link ServiceType }
     * 
     */
    public ServiceType createServiceType() {
        return new ServiceType();
    }

    /**
     * Create an instance of {@link TravelDateTimeType }
     * 
     */
    public TravelDateTimeType createTravelDateTimeType() {
        return new TravelDateTimeType();
    }

    /**
     * Create an instance of {@link DestinationSystemCodesType }
     * 
     */
    public DestinationSystemCodesType createDestinationSystemCodesType() {
        return new DestinationSystemCodesType();
    }

    /**
     * Create an instance of {@link AdditionalGuestAmountType }
     * 
     */
    public AdditionalGuestAmountType createAdditionalGuestAmountType() {
        return new AdditionalGuestAmountType();
    }

    /**
     * Create an instance of {@link FoodSrvcPrefType }
     * 
     */
    public FoodSrvcPrefType createFoodSrvcPrefType() {
        return new FoodSrvcPrefType();
    }

    /**
     * Create an instance of {@link BankAcctType }
     * 
     */
    public BankAcctType createBankAcctType() {
        return new BankAcctType();
    }

    /**
     * Create an instance of {@link RelatedTravelerPrefType }
     * 
     */
    public RelatedTravelerPrefType createRelatedTravelerPrefType() {
        return new RelatedTravelerPrefType();
    }

    /**
     * Create an instance of {@link ResGuestsType }
     * 
     */
    public ResGuestsType createResGuestsType() {
        return new ResGuestsType();
    }

    /**
     * Create an instance of {@link PetInfoPrefType }
     * 
     */
    public PetInfoPrefType createPetInfoPrefType() {
        return new PetInfoPrefType();
    }

    /**
     * Create an instance of {@link LoyaltyProgramType }
     * 
     */
    public LoyaltyProgramType createLoyaltyProgramType() {
        return new LoyaltyProgramType();
    }

    /**
     * Create an instance of {@link PersonalSrvcPrefType }
     * 
     */
    public PersonalSrvcPrefType createPersonalSrvcPrefType() {
        return new PersonalSrvcPrefType();
    }

    /**
     * Create an instance of {@link RatePlanLiteType }
     * 
     */
    public RatePlanLiteType createRatePlanLiteType() {
        return new RatePlanLiteType();
    }

    /**
     * Create an instance of {@link InsuranceType }
     * 
     */
    public InsuranceType createInsuranceType() {
        return new InsuranceType();
    }

    /**
     * Create an instance of {@link PaymentFormPrefType }
     * 
     */
    public PaymentFormPrefType createPaymentFormPrefType() {
        return new PaymentFormPrefType();
    }

    /**
     * Create an instance of {@link RoomLocationPrefType }
     * 
     */
    public RoomLocationPrefType createRoomLocationPrefType() {
        return new RoomLocationPrefType();
    }

    /**
     * Create an instance of {@link AdditionalDetailsType }
     * 
     */
    public AdditionalDetailsType createAdditionalDetailsType() {
        return new AdditionalDetailsType();
    }

    /**
     * Create an instance of {@link MealPrefType }
     * 
     */
    public MealPrefType createMealPrefType() {
        return new MealPrefType();
    }

    /**
     * Create an instance of {@link ResGlobalInfoType }
     * 
     */
    public ResGlobalInfoType createResGlobalInfoType() {
        return new ResGlobalInfoType();
    }

    /**
     * Create an instance of {@link AdditionalDetailType }
     * 
     */
    public AdditionalDetailType createAdditionalDetailType() {
        return new AdditionalDetailType();
    }

    /**
     * Create an instance of {@link MeetingRoomCodeType }
     * 
     */
    public MeetingRoomCodeType createMeetingRoomCodeType() {
        return new MeetingRoomCodeType();
    }

    /**
     * Create an instance of {@link AddressPrefType }
     * 
     */
    public AddressPrefType createAddressPrefType() {
        return new AddressPrefType();
    }

    /**
     * Create an instance of {@link FolioIDsType }
     * 
     */
    public FolioIDsType createFolioIDsType() {
        return new FolioIDsType();
    }

    /**
     * Create an instance of {@link TotalType }
     * 
     */
    public TotalType createTotalType() {
        return new TotalType();
    }

    /**
     * Create an instance of {@link FormattedTextSubSectionType }
     * 
     */
    public FormattedTextSubSectionType createFormattedTextSubSectionType() {
        return new FormattedTextSubSectionType();
    }

    /**
     * Create an instance of {@link TravelArrangerType }
     * 
     */
    public TravelArrangerType createTravelArrangerType() {
        return new TravelArrangerType();
    }

    /**
     * Create an instance of {@link VideoItemType }
     * 
     */
    public VideoItemType createVideoItemType() {
        return new VideoItemType();
    }

    /**
     * Create an instance of {@link RequiredPaymentLiteType }
     * 
     */
    public RequiredPaymentLiteType createRequiredPaymentLiteType() {
        return new RequiredPaymentLiteType();
    }

    /**
     * Create an instance of {@link FormattedTextTextType }
     * 
     */
    public FormattedTextTextType createFormattedTextTextType() {
        return new FormattedTextTextType();
    }

    /**
     * Create an instance of {@link FeesType }
     * 
     */
    public FeesType createFeesType() {
        return new FeesType();
    }

    /**
     * Create an instance of {@link FormattedTextType }
     * 
     */
    public FormattedTextType createFormattedTextType() {
        return new FormattedTextType();
    }

    /**
     * Create an instance of {@link BlackoutDateType }
     * 
     */
    public BlackoutDateType createBlackoutDateType() {
        return new BlackoutDateType();
    }

    /**
     * Create an instance of {@link AgentType }
     * 
     */
    public AgentType createAgentType() {
        return new AgentType();
    }

    /**
     * Create an instance of {@link CommissionInfoType }
     * 
     */
    public CommissionInfoType createCommissionInfoType() {
        return new CommissionInfoType();
    }

    /**
     * Create an instance of {@link MediaEntertainPrefType }
     * 
     */
    public MediaEntertainPrefType createMediaEntertainPrefType() {
        return new MediaEntertainPrefType();
    }

    /**
     * Create an instance of {@link CancelRuleType }
     * 
     */
    public CancelRuleType createCancelRuleType() {
        return new CancelRuleType();
    }

    /**
     * Create an instance of {@link RelativePositionType }
     * 
     */
    public RelativePositionType createRelativePositionType() {
        return new RelativePositionType();
    }

    /**
     * Create an instance of {@link PropertyAmenityPrefType }
     * 
     */
    public PropertyAmenityPrefType createPropertyAmenityPrefType() {
        return new PropertyAmenityPrefType();
    }

    /**
     * Create an instance of {@link CancelInfoRQType }
     * 
     */
    public CancelInfoRQType createCancelInfoRQType() {
        return new CancelInfoRQType();
    }

    /**
     * Create an instance of {@link EmployerType }
     * 
     */
    public EmployerType createEmployerType() {
        return new EmployerType();
    }

    /**
     * Create an instance of {@link PropertyClassPrefType }
     * 
     */
    public PropertyClassPrefType createPropertyClassPrefType() {
        return new PropertyClassPrefType();
    }

    /**
     * Create an instance of {@link InvCountType }
     * 
     */
    public InvCountType createInvCountType() {
        return new InvCountType();
    }

    /**
     * Create an instance of {@link PhysChallFeaturePrefType }
     * 
     */
    public PhysChallFeaturePrefType createPhysChallFeaturePrefType() {
        return new PhysChallFeaturePrefType();
    }

    /**
     * Create an instance of {@link ContactInfosType }
     * 
     */
    public ContactInfosType createContactInfosType() {
        return new ContactInfosType();
    }

    /**
     * Create an instance of {@link NamePrefType }
     * 
     */
    public NamePrefType createNamePrefType() {
        return new NamePrefType();
    }

    /**
     * Create an instance of {@link StayInfosType }
     * 
     */
    public StayInfosType createStayInfosType() {
        return new StayInfosType();
    }

    /**
     * Create an instance of {@link TaxesType }
     * 
     */
    public TaxesType createTaxesType() {
        return new TaxesType();
    }

    /**
     * Create an instance of {@link AcceptedPaymentsType }
     * 
     */
    public AcceptedPaymentsType createAcceptedPaymentsType() {
        return new AcceptedPaymentsType();
    }

    /**
     * Create an instance of {@link OperationSchedulePlusChargeType }
     * 
     */
    public OperationSchedulePlusChargeType createOperationSchedulePlusChargeType() {
        return new OperationSchedulePlusChargeType();
    }

    /**
     * Create an instance of {@link PropertyLocationPrefType }
     * 
     */
    public PropertyLocationPrefType createPropertyLocationPrefType() {
        return new PropertyLocationPrefType();
    }

    /**
     * Create an instance of {@link StatisticsType }
     * 
     */
    public StatisticsType createStatisticsType() {
        return new StatisticsType();
    }

    /**
     * Create an instance of {@link LoyaltyPrefType }
     * 
     */
    public LoyaltyPrefType createLoyaltyPrefType() {
        return new LoyaltyPrefType();
    }

    /**
     * Create an instance of {@link CountryNameType }
     * 
     */
    public CountryNameType createCountryNameType() {
        return new CountryNameType();
    }

    /**
     * Create an instance of {@link AffiliationsType }
     * 
     */
    public AffiliationsType createAffiliationsType() {
        return new AffiliationsType();
    }

    /**
     * Create an instance of {@link DOWRestrictionsType.AvailableDaysOfWeek }
     * 
     */
    public DOWRestrictionsType.AvailableDaysOfWeek createDOWRestrictionsTypeAvailableDaysOfWeek() {
        return new DOWRestrictionsType.AvailableDaysOfWeek();
    }

    /**
     * Create an instance of {@link DOWRestrictionsType.ArrivalDaysOfWeek }
     * 
     */
    public DOWRestrictionsType.ArrivalDaysOfWeek createDOWRestrictionsTypeArrivalDaysOfWeek() {
        return new DOWRestrictionsType.ArrivalDaysOfWeek();
    }

    /**
     * Create an instance of {@link DOWRestrictionsType.DepartureDaysOfWeek }
     * 
     */
    public DOWRestrictionsType.DepartureDaysOfWeek createDOWRestrictionsTypeDepartureDaysOfWeek() {
        return new DOWRestrictionsType.DepartureDaysOfWeek();
    }

    /**
     * Create an instance of {@link DOWRestrictionsType.RequiredDaysOfWeek }
     * 
     */
    public DOWRestrictionsType.RequiredDaysOfWeek createDOWRestrictionsTypeRequiredDaysOfWeek() {
        return new DOWRestrictionsType.RequiredDaysOfWeek();
    }

    /**
     * Create an instance of {@link WeatherInfoType.Precipitation }
     * 
     */
    public WeatherInfoType.Precipitation createWeatherInfoTypePrecipitation() {
        return new WeatherInfoType.Precipitation();
    }

    /**
     * Create an instance of {@link WeatherInfoType.Temperature }
     * 
     */
    public WeatherInfoType.Temperature createWeatherInfoTypeTemperature() {
        return new WeatherInfoType.Temperature();
    }

    /**
     * Create an instance of {@link OriginDestinationInformationType.OriginLocation }
     * 
     */
    public OriginDestinationInformationType.OriginLocation createOriginDestinationInformationTypeOriginLocation() {
        return new OriginDestinationInformationType.OriginLocation();
    }

    /**
     * Create an instance of {@link OriginDestinationInformationType.DestinationLocation }
     * 
     */
    public OriginDestinationInformationType.DestinationLocation createOriginDestinationInformationTypeDestinationLocation() {
        return new OriginDestinationInformationType.DestinationLocation();
    }

    /**
     * Create an instance of {@link URLsType.URL }
     * 
     */
    public URLsType.URL createURLsTypeURL() {
        return new URLsType.URL();
    }

    /**
     * Create an instance of {@link RevenueCategoryType.SummaryAmount }
     * 
     */
    public RevenueCategoryType.SummaryAmount createRevenueCategoryTypeSummaryAmount() {
        return new RevenueCategoryType.SummaryAmount();
    }

    /**
     * Create an instance of {@link OrganizationType.OrgMemberName }
     * 
     */
    public OrganizationType.OrgMemberName createOrganizationTypeOrgMemberName() {
        return new OrganizationType.OrgMemberName();
    }

    /**
     * Create an instance of {@link PersonNameType.Document }
     * 
     */
    public PersonNameType.Document createPersonNameTypeDocument() {
        return new PersonNameType.Document();
    }

    /**
     * Create an instance of {@link OperationScheduleType.OperationTimes.OperationTime }
     * 
     */
    public OperationScheduleType.OperationTimes.OperationTime createOperationScheduleTypeOperationTimesOperationTime() {
        return new OperationScheduleType.OperationTimes.OperationTime();
    }

    /**
     * Create an instance of {@link FeaturesType.Feature.Charge }
     * 
     */
    public FeaturesType.Feature.Charge createFeaturesTypeFeatureCharge() {
        return new FeaturesType.Feature.Charge();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.GuaranteePaymentPolicy }
     * 
     */
    public PoliciesType.Policy.GuaranteePaymentPolicy createPoliciesTypePolicyGuaranteePaymentPolicy() {
        return new PoliciesType.Policy.GuaranteePaymentPolicy();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.PolicyInfo }
     * 
     */
    public PoliciesType.Policy.PolicyInfo createPoliciesTypePolicyPolicyInfo() {
        return new PoliciesType.Policy.PolicyInfo();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.FeePolicies }
     * 
     */
    public PoliciesType.Policy.FeePolicies createPoliciesTypePolicyFeePolicies() {
        return new PoliciesType.Policy.FeePolicies();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.CommissionPolicy.PaymentCompany }
     * 
     */
    public PoliciesType.Policy.CommissionPolicy.PaymentCompany createPoliciesTypePolicyCommissionPolicyPaymentCompany() {
        return new PoliciesType.Policy.CommissionPolicy.PaymentCompany();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.StayRequirements.StayRequirement }
     * 
     */
    public PoliciesType.Policy.StayRequirements.StayRequirement createPoliciesTypePolicyStayRequirementsStayRequirement() {
        return new PoliciesType.Policy.StayRequirements.StayRequirement();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.PetsPolicies.PetsPolicy }
     * 
     */
    public PoliciesType.Policy.PetsPolicies.PetsPolicy createPoliciesTypePolicyPetsPoliciesPetsPolicy() {
        return new PoliciesType.Policy.PetsPolicies.PetsPolicy();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.TaxPolicies.TaxPolicy }
     * 
     */
    public PoliciesType.Policy.TaxPolicies.TaxPolicy createPoliciesTypePolicyTaxPoliciesTaxPolicy() {
        return new PoliciesType.Policy.TaxPolicies.TaxPolicy();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.CheckoutCharges.CheckoutCharge }
     * 
     */
    public PoliciesType.Policy.CheckoutCharges.CheckoutCharge createPoliciesTypePolicyCheckoutChargesCheckoutCharge() {
        return new PoliciesType.Policy.CheckoutCharges.CheckoutCharge();
    }

    /**
     * Create an instance of {@link PoliciesType.Policy.PolicyInfoCodes.PolicyInfoCode }
     * 
     */
    public PoliciesType.Policy.PolicyInfoCodes.PolicyInfoCode createPoliciesTypePolicyPolicyInfoCodesPolicyInfoCode() {
        return new PoliciesType.Policy.PolicyInfoCodes.PolicyInfoCode();
    }

    /**
     * Create an instance of {@link RequiredPaymentsType.GuaranteePayment.AmountPercent }
     * 
     */
    public RequiredPaymentsType.GuaranteePayment.AmountPercent createRequiredPaymentsTypeGuaranteePaymentAmountPercent() {
        return new RequiredPaymentsType.GuaranteePayment.AmountPercent();
    }

    /**
     * Create an instance of {@link RequiredPaymentsType.GuaranteePayment.Deadline }
     * 
     */
    public RequiredPaymentsType.GuaranteePayment.Deadline createRequiredPaymentsTypeGuaranteePaymentDeadline() {
        return new RequiredPaymentsType.GuaranteePayment.Deadline();
    }

    /**
     * Create an instance of {@link RequiredPaymentsType.GuaranteePayment.Address }
     * 
     */
    public RequiredPaymentsType.GuaranteePayment.Address createRequiredPaymentsTypeGuaranteePaymentAddress() {
        return new RequiredPaymentsType.GuaranteePayment.Address();
    }

    /**
     * Create an instance of {@link AddressType.StreetNmbr }
     * 
     */
    public AddressType.StreetNmbr createAddressTypeStreetNmbr() {
        return new AddressType.StreetNmbr();
    }

    /**
     * Create an instance of {@link AddressType.BldgRoom }
     * 
     */
    public AddressType.BldgRoom createAddressTypeBldgRoom() {
        return new AddressType.BldgRoom();
    }

    /**
     * Create an instance of {@link AllianceConsortiumType.AllianceMember }
     * 
     */
    public AllianceConsortiumType.AllianceMember createAllianceConsortiumTypeAllianceMember() {
        return new AllianceConsortiumType.AllianceMember();
    }

    /**
     * Create an instance of {@link AccessesType.Access }
     * 
     */
    public AccessesType.Access createAccessesTypeAccess() {
        return new AccessesType.Access();
    }

    /**
     * Create an instance of {@link TransportationType.Transportation }
     * 
     */
    public TransportationType.Transportation createTransportationTypeTransportation() {
        return new TransportationType.Transportation();
    }

    /**
     * Create an instance of {@link AddressesType.Address }
     * 
     */
    public AddressesType.Address createAddressesTypeAddress() {
        return new AddressesType.Address();
    }

    /**
     * Create an instance of {@link ContactInfoType.CompanyName }
     * 
     */
    public ContactInfoType.CompanyName createContactInfoTypeCompanyName() {
        return new ContactInfoType.CompanyName();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType.Position }
     * 
     */
    public BasicPropertyInfoType.Position createBasicPropertyInfoTypePosition() {
        return new BasicPropertyInfoType.Position();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType.Award }
     * 
     */
    public BasicPropertyInfoType.Award createBasicPropertyInfoTypeAward() {
        return new BasicPropertyInfoType.Award();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType.HotelAmenity }
     * 
     */
    public BasicPropertyInfoType.HotelAmenity createBasicPropertyInfoTypeHotelAmenity() {
        return new BasicPropertyInfoType.HotelAmenity();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType.Recreation }
     * 
     */
    public BasicPropertyInfoType.Recreation createBasicPropertyInfoTypeRecreation() {
        return new BasicPropertyInfoType.Recreation();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType.Service }
     * 
     */
    public BasicPropertyInfoType.Service createBasicPropertyInfoTypeService() {
        return new BasicPropertyInfoType.Service();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType.Policy }
     * 
     */
    public BasicPropertyInfoType.Policy createBasicPropertyInfoTypePolicy() {
        return new BasicPropertyInfoType.Policy();
    }

    /**
     * Create an instance of {@link PropertyValueMatchType.SearchValueMatch }
     * 
     */
    public PropertyValueMatchType.SearchValueMatch createPropertyValueMatchTypeSearchValueMatch() {
        return new PropertyValueMatchType.SearchValueMatch();
    }

    /**
     * Create an instance of {@link PropertyValueMatchType.RateRange }
     * 
     */
    public PropertyValueMatchType.RateRange createPropertyValueMatchTypeRateRange() {
        return new PropertyValueMatchType.RateRange();
    }

    /**
     * Create an instance of {@link PropertyValueMatchType.Amenities.Amenity }
     * 
     */
    public PropertyValueMatchType.Amenities.Amenity createPropertyValueMatchTypeAmenitiesAmenity() {
        return new PropertyValueMatchType.Amenities.Amenity();
    }

    /**
     * Create an instance of {@link BasicPropertyInfoType.ContactNumbers.ContactNumber }
     * 
     */
    public BasicPropertyInfoType.ContactNumbers.ContactNumber createBasicPropertyInfoTypeContactNumbersContactNumber() {
        return new BasicPropertyInfoType.ContactNumbers.ContactNumber();
    }

    /**
     * Create an instance of {@link BookingRulesType.BookingRule.RestrictionStatus }
     * 
     */
    public BookingRulesType.BookingRule.RestrictionStatus createBookingRulesTypeBookingRuleRestrictionStatus() {
        return new BookingRulesType.BookingRule.RestrictionStatus();
    }

    /**
     * Create an instance of {@link BookingRulesType.BookingRule.CheckoutCharge }
     * 
     */
    public BookingRulesType.BookingRule.CheckoutCharge createBookingRulesTypeBookingRuleCheckoutCharge() {
        return new BookingRulesType.BookingRule.CheckoutCharge();
    }

    /**
     * Create an instance of {@link BookingRulesType.BookingRule.AddtionalRules.AdditionalRule }
     * 
     */
    public BookingRulesType.BookingRule.AddtionalRules.AdditionalRule createBookingRulesTypeBookingRuleAddtionalRulesAdditionalRule() {
        return new BookingRulesType.BookingRule.AddtionalRules.AdditionalRule();
    }

    /**
     * Create an instance of {@link BookingRulesType.BookingRule.AcceptableGuarantees.AcceptableGuarantee }
     * 
     */
    public BookingRulesType.BookingRule.AcceptableGuarantees.AcceptableGuarantee createBookingRulesTypeBookingRuleAcceptableGuaranteesAcceptableGuarantee() {
        return new BookingRulesType.BookingRule.AcceptableGuarantees.AcceptableGuarantee();
    }

    /**
     * Create an instance of {@link GuaranteeType.Deadline }
     * 
     */
    public GuaranteeType.Deadline createGuaranteeTypeDeadline() {
        return new GuaranteeType.Deadline();
    }

    /**
     * Create an instance of {@link GuaranteeType.GuaranteesAccepted.GuaranteeAccepted }
     * 
     */
    public GuaranteeType.GuaranteesAccepted.GuaranteeAccepted createGuaranteeTypeGuaranteesAcceptedGuaranteeAccepted() {
        return new GuaranteeType.GuaranteesAccepted.GuaranteeAccepted();
    }

    /**
     * Create an instance of {@link PaymentFormType.Voucher }
     * 
     */
    public PaymentFormType.Voucher createPaymentFormTypeVoucher() {
        return new PaymentFormType.Voucher();
    }

    /**
     * Create an instance of {@link PaymentFormType.MiscChargeOrder }
     * 
     */
    public PaymentFormType.MiscChargeOrder createPaymentFormTypeMiscChargeOrder() {
        return new PaymentFormType.MiscChargeOrder();
    }

    /**
     * Create an instance of {@link PaymentFormType.Cash }
     * 
     */
    public PaymentFormType.Cash createPaymentFormTypeCash() {
        return new PaymentFormType.Cash();
    }

    /**
     * Create an instance of {@link PaymentFormType.Ticket.ConjunctionTicketNbr }
     * 
     */
    public PaymentFormType.Ticket.ConjunctionTicketNbr createPaymentFormTypeTicketConjunctionTicketNbr() {
        return new PaymentFormType.Ticket.ConjunctionTicketNbr();
    }

    /**
     * Create an instance of {@link PaymentFormType.LoyaltyRedemption.LoyaltyCertificate }
     * 
     */
    public PaymentFormType.LoyaltyRedemption.LoyaltyCertificate createPaymentFormTypeLoyaltyRedemptionLoyaltyCertificate() {
        return new PaymentFormType.LoyaltyRedemption.LoyaltyCertificate();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.ViewershipCodes }
     * 
     */
    public ViewershipsType.Viewership.ViewershipCodes createViewershipsTypeViewershipViewershipCodes() {
        return new ViewershipsType.Viewership.ViewershipCodes();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.ProfileRefs }
     * 
     */
    public ViewershipsType.Viewership.ProfileRefs createViewershipsTypeViewershipProfileRefs() {
        return new ViewershipsType.Viewership.ProfileRefs();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.Profiles }
     * 
     */
    public ViewershipsType.Viewership.Profiles createViewershipsTypeViewershipProfiles() {
        return new ViewershipsType.Viewership.Profiles();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.DistributorTypes.DistributorType }
     * 
     */
    public ViewershipsType.Viewership.DistributorTypes.DistributorType createViewershipsTypeViewershipDistributorTypesDistributorType() {
        return new ViewershipsType.Viewership.DistributorTypes.DistributorType();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.BookingChannelCodes.BookingChannelCode }
     * 
     */
    public ViewershipsType.Viewership.BookingChannelCodes.BookingChannelCode createViewershipsTypeViewershipBookingChannelCodesBookingChannelCode() {
        return new ViewershipsType.Viewership.BookingChannelCodes.BookingChannelCode();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.LocationCodes.LocationCode }
     * 
     */
    public ViewershipsType.Viewership.LocationCodes.LocationCode createViewershipsTypeViewershipLocationCodesLocationCode() {
        return new ViewershipsType.Viewership.LocationCodes.LocationCode();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.ProfileTypes.ProfileType }
     * 
     */
    public ViewershipsType.Viewership.ProfileTypes.ProfileType createViewershipsTypeViewershipProfileTypesProfileType() {
        return new ViewershipsType.Viewership.ProfileTypes.ProfileType();
    }

    /**
     * Create an instance of {@link ViewershipsType.Viewership.SystemCodes.SystemCode }
     * 
     */
    public ViewershipsType.Viewership.SystemCodes.SystemCode createViewershipsTypeViewershipSystemCodesSystemCode() {
        return new ViewershipsType.Viewership.SystemCodes.SystemCode();
    }

    /**
     * Create an instance of {@link FacilityInfoType.GuestRooms.GuestRoom.TypeRoom }
     * 
     */
    public FacilityInfoType.GuestRooms.GuestRoom.TypeRoom createFacilityInfoTypeGuestRoomsGuestRoomTypeRoom() {
        return new FacilityInfoType.GuestRooms.GuestRoom.TypeRoom();
    }

    /**
     * Create an instance of {@link FacilityInfoType.GuestRooms.GuestRoom.Amenities.Amenity }
     * 
     */
    public FacilityInfoType.GuestRooms.GuestRoom.Amenities.Amenity createFacilityInfoTypeGuestRoomsGuestRoomAmenitiesAmenity() {
        return new FacilityInfoType.GuestRooms.GuestRoom.Amenities.Amenity();
    }

    /**
     * Create an instance of {@link FacilityInfoType.MeetingRooms.Codes }
     * 
     */
    public FacilityInfoType.MeetingRooms.Codes createFacilityInfoTypeMeetingRoomsCodes() {
        return new FacilityInfoType.MeetingRooms.Codes();
    }

    /**
     * Create an instance of {@link MeetingRoomsType.MeetingRoom.Codes }
     * 
     */
    public MeetingRoomsType.MeetingRoom.Codes createMeetingRoomsTypeMeetingRoomCodes() {
        return new MeetingRoomsType.MeetingRoom.Codes();
    }

    /**
     * Create an instance of {@link MeetingRoomsType.MeetingRoom.Dimension }
     * 
     */
    public MeetingRoomsType.MeetingRoom.Dimension createMeetingRoomsTypeMeetingRoomDimension() {
        return new MeetingRoomsType.MeetingRoom.Dimension();
    }

    /**
     * Create an instance of {@link MeetingRoomsType.MeetingRoom.AvailableCapacities }
     * 
     */
    public MeetingRoomsType.MeetingRoom.AvailableCapacities createMeetingRoomsTypeMeetingRoomAvailableCapacities() {
        return new MeetingRoomsType.MeetingRoom.AvailableCapacities();
    }

    /**
     * Create an instance of {@link StatisticApplicationSetType.ReportSummaries }
     * 
     */
    public StatisticApplicationSetType.ReportSummaries createStatisticApplicationSetTypeReportSummaries() {
        return new StatisticApplicationSetType.ReportSummaries();
    }

    /**
     * Create an instance of {@link StatisticApplicationSetType.CountCategorySummaries.CountCategorySummary }
     * 
     */
    public StatisticApplicationSetType.CountCategorySummaries.CountCategorySummary createStatisticApplicationSetTypeCountCategorySummariesCountCategorySummary() {
        return new StatisticApplicationSetType.CountCategorySummaries.CountCategorySummary();
    }

    /**
     * Create an instance of {@link StatisticApplicationSetType.RevenueCategorySummaries.RevenueCategorySummary }
     * 
     */
    public StatisticApplicationSetType.RevenueCategorySummaries.RevenueCategorySummary createStatisticApplicationSetTypeRevenueCategorySummariesRevenueCategorySummary() {
        return new StatisticApplicationSetType.RevenueCategorySummaries.RevenueCategorySummary();
    }

    /**
     * Create an instance of {@link StatisticApplicationSetType.StatisticCodes.StatisticCode }
     * 
     */
    public StatisticApplicationSetType.StatisticCodes.StatisticCode createStatisticApplicationSetTypeStatisticCodesStatisticCode() {
        return new StatisticApplicationSetType.StatisticCodes.StatisticCode();
    }

    /**
     * Create an instance of {@link RateAmountMessageType.Rates.Rate }
     * 
     */
    public RateAmountMessageType.Rates.Rate createRateAmountMessageTypeRatesRate() {
        return new RateAmountMessageType.Rates.Rate();
    }

    /**
     * Create an instance of {@link RateUploadType.GuaranteePolicies }
     * 
     */
    public RateUploadType.GuaranteePolicies createRateUploadTypeGuaranteePolicies() {
        return new RateUploadType.GuaranteePolicies();
    }

    /**
     * Create an instance of {@link RateUploadType.MealsIncluded }
     * 
     */
    public RateUploadType.MealsIncluded createRateUploadTypeMealsIncluded() {
        return new RateUploadType.MealsIncluded();
    }

    /**
     * Create an instance of {@link RateUploadType.AdditionalGuestAmounts.AdditionalGuestAmount }
     * 
     */
    public RateUploadType.AdditionalGuestAmounts.AdditionalGuestAmount createRateUploadTypeAdditionalGuestAmountsAdditionalGuestAmount() {
        return new RateUploadType.AdditionalGuestAmounts.AdditionalGuestAmount();
    }

    /**
     * Create an instance of {@link RateUploadType.BaseByGuestAmts.BaseByGuestAmt }
     * 
     */
    public RateUploadType.BaseByGuestAmts.BaseByGuestAmt createRateUploadTypeBaseByGuestAmtsBaseByGuestAmt() {
        return new RateUploadType.BaseByGuestAmts.BaseByGuestAmt();
    }

    /**
     * Create an instance of {@link InvBlockType.HotelRef }
     * 
     */
    public InvBlockType.HotelRef createInvBlockTypeHotelRef() {
        return new InvBlockType.HotelRef();
    }

    /**
     * Create an instance of {@link InvBlockType.InvBlockDates }
     * 
     */
    public InvBlockType.InvBlockDates createInvBlockTypeInvBlockDates() {
        return new InvBlockType.InvBlockDates();
    }

    /**
     * Create an instance of {@link InvBlockType.RoomTypes }
     * 
     */
    public InvBlockType.RoomTypes createInvBlockTypeRoomTypes() {
        return new InvBlockType.RoomTypes();
    }

    /**
     * Create an instance of {@link InvBlockType.MethodInfo }
     * 
     */
    public InvBlockType.MethodInfo createInvBlockTypeMethodInfo() {
        return new InvBlockType.MethodInfo();
    }

    /**
     * Create an instance of {@link InvBlockType.Contacts }
     * 
     */
    public InvBlockType.Contacts createInvBlockTypeContacts() {
        return new InvBlockType.Contacts();
    }

    /**
     * Create an instance of {@link InvBlockType.BlockDescriptions.BlockDescription }
     * 
     */
    public InvBlockType.BlockDescriptions.BlockDescription createInvBlockTypeBlockDescriptionsBlockDescription() {
        return new InvBlockType.BlockDescriptions.BlockDescription();
    }

    /**
     * Create an instance of {@link ParagraphType.ListItem }
     * 
     */
    public ParagraphType.ListItem createParagraphTypeListItem() {
        return new ParagraphType.ListItem();
    }

    /**
     * Create an instance of {@link ProfilesType.ProfileInfo }
     * 
     */
    public ProfilesType.ProfileInfo createProfilesTypeProfileInfo() {
        return new ProfilesType.ProfileInfo();
    }

    /**
     * Create an instance of {@link VideoDescriptionType.VideoFormat }
     * 
     */
    public VideoDescriptionType.VideoFormat createVideoDescriptionTypeVideoFormat() {
        return new VideoDescriptionType.VideoFormat();
    }

    /**
     * Create an instance of {@link RFPResponseDetailType.Comments }
     * 
     */
    public RFPResponseDetailType.Comments createRFPResponseDetailTypeComments() {
        return new RFPResponseDetailType.Comments();
    }

    /**
     * Create an instance of {@link RoomSharesType.RoomShare.GuestRPHs.GuestRPH }
     * 
     */
    public RoomSharesType.RoomShare.GuestRPHs.GuestRPH createRoomSharesTypeRoomShareGuestRPHsGuestRPH() {
        return new RoomSharesType.RoomShare.GuestRPHs.GuestRPH();
    }

    /**
     * Create an instance of {@link FlightSegmentBaseType.DepartureAirport }
     * 
     */
    public FlightSegmentBaseType.DepartureAirport createFlightSegmentBaseTypeDepartureAirport() {
        return new FlightSegmentBaseType.DepartureAirport();
    }

    /**
     * Create an instance of {@link FlightSegmentBaseType.ArrivalAirport }
     * 
     */
    public FlightSegmentBaseType.ArrivalAirport createFlightSegmentBaseTypeArrivalAirport() {
        return new FlightSegmentBaseType.ArrivalAirport();
    }

    /**
     * Create an instance of {@link DateTimeSpanType.StartDateWindow }
     * 
     */
    public DateTimeSpanType.StartDateWindow createDateTimeSpanTypeStartDateWindow() {
        return new DateTimeSpanType.StartDateWindow();
    }

    /**
     * Create an instance of {@link DateTimeSpanType.EndDateWindow }
     * 
     */
    public DateTimeSpanType.EndDateWindow createDateTimeSpanTypeEndDateWindow() {
        return new DateTimeSpanType.EndDateWindow();
    }

    /**
     * Create an instance of {@link InvBlockRoomType.DaysOfWeeks }
     * 
     */
    public InvBlockRoomType.DaysOfWeeks createInvBlockRoomTypeDaysOfWeeks() {
        return new InvBlockRoomType.DaysOfWeeks();
    }

    /**
     * Create an instance of {@link InvBlockRoomType.RatePlans.RatePlan.MarketCode }
     * 
     */
    public InvBlockRoomType.RatePlans.RatePlan.MarketCode createInvBlockRoomTypeRatePlansRatePlanMarketCode() {
        return new InvBlockRoomType.RatePlans.RatePlan.MarketCode();
    }

    /**
     * Create an instance of {@link InvBlockRoomType.RatePlans.RatePlan.MethodInfo }
     * 
     */
    public InvBlockRoomType.RatePlans.RatePlan.MethodInfo createInvBlockRoomTypeRatePlansRatePlanMethodInfo() {
        return new InvBlockRoomType.RatePlans.RatePlan.MethodInfo();
    }

    /**
     * Create an instance of {@link InvBlockRoomType.RatePlans.RatePlan.DaysOfWeeks }
     * 
     */
    public InvBlockRoomType.RatePlans.RatePlan.DaysOfWeeks createInvBlockRoomTypeRatePlansRatePlanDaysOfWeeks() {
        return new InvBlockRoomType.RatePlans.RatePlan.DaysOfWeeks();
    }

    /**
     * Create an instance of {@link InvBlockRoomType.RoomTypeAllocations.RoomTypeAllocation }
     * 
     */
    public InvBlockRoomType.RoomTypeAllocations.RoomTypeAllocation createInvBlockRoomTypeRoomTypeAllocationsRoomTypeAllocation() {
        return new InvBlockRoomType.RoomTypeAllocations.RoomTypeAllocation();
    }

    /**
     * Create an instance of {@link RestaurantsType.SrvcInfoCodes.SrvcInfoCode }
     * 
     */
    public RestaurantsType.SrvcInfoCodes.SrvcInfoCode createRestaurantsTypeSrvcInfoCodesSrvcInfoCode() {
        return new RestaurantsType.SrvcInfoCodes.SrvcInfoCode();
    }

    /**
     * Create an instance of {@link RestaurantType.MultimediaDescriptions }
     * 
     */
    public RestaurantType.MultimediaDescriptions createRestaurantTypeMultimediaDescriptions() {
        return new RestaurantType.MultimediaDescriptions();
    }

    /**
     * Create an instance of {@link RestaurantsType.Restaurant.SrvcInfoCodes.SrvcInfoCode }
     * 
     */
    public RestaurantsType.Restaurant.SrvcInfoCodes.SrvcInfoCode createRestaurantsTypeRestaurantSrvcInfoCodesSrvcInfoCode() {
        return new RestaurantsType.Restaurant.SrvcInfoCodes.SrvcInfoCode();
    }

    /**
     * Create an instance of {@link RestaurantType.CuisineCodes.CuisineCode }
     * 
     */
    public RestaurantType.CuisineCodes.CuisineCode createRestaurantTypeCuisineCodesCuisineCode() {
        return new RestaurantType.CuisineCodes.CuisineCode();
    }

    /**
     * Create an instance of {@link RestaurantType.InfoCodes.InfoCode }
     * 
     */
    public RestaurantType.InfoCodes.InfoCode createRestaurantTypeInfoCodesInfoCode() {
        return new RestaurantType.InfoCodes.InfoCode();
    }

    /**
     * Create an instance of {@link GuestCountType.GuestCount }
     * 
     */
    public GuestCountType.GuestCount createGuestCountTypeGuestCount() {
        return new GuestCountType.GuestCount();
    }

    /**
     * Create an instance of {@link HotelReservationType.Queue }
     * 
     */
    public HotelReservationType.Queue createHotelReservationTypeQueue() {
        return new HotelReservationType.Queue();
    }

    /**
     * Create an instance of {@link HotelReservationType.BillingInstructionCode.ResGuestRPH }
     * 
     */
    public HotelReservationType.BillingInstructionCode.ResGuestRPH createHotelReservationTypeBillingInstructionCodeResGuestRPH() {
        return new HotelReservationType.BillingInstructionCode.ResGuestRPH();
    }

    /**
     * Create an instance of {@link AreaInfoType.RefPoints }
     * 
     */
    public AreaInfoType.RefPoints createAreaInfoTypeRefPoints() {
        return new AreaInfoType.RefPoints();
    }

    /**
     * Create an instance of {@link AreaInfoType.OtherHotels.OtherHotel }
     * 
     */
    public AreaInfoType.OtherHotels.OtherHotel createAreaInfoTypeOtherHotelsOtherHotel() {
        return new AreaInfoType.OtherHotels.OtherHotel();
    }

    /**
     * Create an instance of {@link AreaInfoType.Recreations.Recreation.MultimediaDescriptions }
     * 
     */
    public AreaInfoType.Recreations.Recreation.MultimediaDescriptions createAreaInfoTypeRecreationsRecreationMultimediaDescriptions() {
        return new AreaInfoType.Recreations.Recreation.MultimediaDescriptions();
    }

    /**
     * Create an instance of {@link AreaInfoType.Recreations.Recreation.RecreationDetails.RecreationDetail }
     * 
     */
    public AreaInfoType.Recreations.Recreation.RecreationDetails.RecreationDetail createAreaInfoTypeRecreationsRecreationRecreationDetailsRecreationDetail() {
        return new AreaInfoType.Recreations.Recreation.RecreationDetails.RecreationDetail();
    }

    /**
     * Create an instance of {@link AreaInfoType.Attractions.Attraction.Contact }
     * 
     */
    public AreaInfoType.Attractions.Attraction.Contact createAreaInfoTypeAttractionsAttractionContact() {
        return new AreaInfoType.Attractions.Attraction.Contact();
    }

    /**
     * Create an instance of {@link RefPointsType.RefPoint }
     * 
     */
    public RefPointsType.RefPoint createRefPointsTypeRefPoint() {
        return new RefPointsType.RefPoint();
    }

    /**
     * Create an instance of {@link RatePlanCandidatesType.RatePlanCandidate.MealsIncluded }
     * 
     */
    public RatePlanCandidatesType.RatePlanCandidate.MealsIncluded createRatePlanCandidatesTypeRatePlanCandidateMealsIncluded() {
        return new RatePlanCandidatesType.RatePlanCandidate.MealsIncluded();
    }

    /**
     * Create an instance of {@link RatePlanCandidatesType.RatePlanCandidate.ArrivalPolicy }
     * 
     */
    public RatePlanCandidatesType.RatePlanCandidate.ArrivalPolicy createRatePlanCandidatesTypeRatePlanCandidateArrivalPolicy() {
        return new RatePlanCandidatesType.RatePlanCandidate.ArrivalPolicy();
    }

    /**
     * Create an instance of {@link RatePlanCandidatesType.RatePlanCandidate.RatePlanCommission }
     * 
     */
    public RatePlanCandidatesType.RatePlanCandidate.RatePlanCommission createRatePlanCandidatesTypeRatePlanCandidateRatePlanCommission() {
        return new RatePlanCandidatesType.RatePlanCandidate.RatePlanCommission();
    }

    /**
     * Create an instance of {@link RatePlanCandidatesType.RatePlanCandidate.HotelRefs.HotelRef }
     * 
     */
    public RatePlanCandidatesType.RatePlanCandidate.HotelRefs.HotelRef createRatePlanCandidatesTypeRatePlanCandidateHotelRefsHotelRef() {
        return new RatePlanCandidatesType.RatePlanCandidate.HotelRefs.HotelRef();
    }

    /**
     * Create an instance of {@link PaymentDetailType.PaymentAmount }
     * 
     */
    public PaymentDetailType.PaymentAmount createPaymentDetailTypePaymentAmount() {
        return new PaymentDetailType.PaymentAmount();
    }

    /**
     * Create an instance of {@link ResCommonDetailType.TimeSpan }
     * 
     */
    public ResCommonDetailType.TimeSpan createResCommonDetailTypeTimeSpan() {
        return new ResCommonDetailType.TimeSpan();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.Position }
     * 
     */
    public ItemSearchCriterionType.Position createItemSearchCriterionTypePosition() {
        return new ItemSearchCriterionType.Position();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.Address }
     * 
     */
    public ItemSearchCriterionType.Address createItemSearchCriterionTypeAddress() {
        return new ItemSearchCriterionType.Address();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.RefPoint }
     * 
     */
    public ItemSearchCriterionType.RefPoint createItemSearchCriterionTypeRefPoint() {
        return new ItemSearchCriterionType.RefPoint();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.CodeRef }
     * 
     */
    public ItemSearchCriterionType.CodeRef createItemSearchCriterionTypeCodeRef() {
        return new ItemSearchCriterionType.CodeRef();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.HotelRef }
     * 
     */
    public ItemSearchCriterionType.HotelRef createItemSearchCriterionTypeHotelRef() {
        return new ItemSearchCriterionType.HotelRef();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.Radius }
     * 
     */
    public ItemSearchCriterionType.Radius createItemSearchCriterionTypeRadius() {
        return new ItemSearchCriterionType.Radius();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.MapArea }
     * 
     */
    public ItemSearchCriterionType.MapArea createItemSearchCriterionTypeMapArea() {
        return new ItemSearchCriterionType.MapArea();
    }

    /**
     * Create an instance of {@link ItemSearchCriterionType.AdditionalContents.AdditionalContent }
     * 
     */
    public ItemSearchCriterionType.AdditionalContents.AdditionalContent createItemSearchCriterionTypeAdditionalContentsAdditionalContent() {
        return new ItemSearchCriterionType.AdditionalContents.AdditionalContent();
    }

    /**
     * Create an instance of {@link RateType.Rate }
     * 
     */
    public RateType.Rate createRateTypeRate() {
        return new RateType.Rate();
    }

    /**
     * Create an instance of {@link AmountType.AdditionalGuestAmounts }
     * 
     */
    public AmountType.AdditionalGuestAmounts createAmountTypeAdditionalGuestAmounts() {
        return new AmountType.AdditionalGuestAmounts();
    }

    /**
     * Create an instance of {@link AmountType.Discount }
     * 
     */
    public AmountType.Discount createAmountTypeDiscount() {
        return new AmountType.Discount();
    }

    /**
     * Create an instance of {@link MeetingRoomCapacityType.Occupancy }
     * 
     */
    public MeetingRoomCapacityType.Occupancy createMeetingRoomCapacityTypeOccupancy() {
        return new MeetingRoomCapacityType.Occupancy();
    }

    /**
     * Create an instance of {@link ContactsType.Name.JobTitle }
     * 
     */
    public ContactsType.Name.JobTitle createContactsTypeNameJobTitle() {
        return new ContactsType.Name.JobTitle();
    }

    /**
     * Create an instance of {@link DirectBillType.CompanyName }
     * 
     */
    public DirectBillType.CompanyName createDirectBillTypeCompanyName() {
        return new DirectBillType.CompanyName();
    }

    /**
     * Create an instance of {@link DirectBillType.Telephone }
     * 
     */
    public DirectBillType.Telephone createDirectBillTypeTelephone() {
        return new DirectBillType.Telephone();
    }

    /**
     * Create an instance of {@link TransportInfoType.TransportInfo }
     * 
     */
    public TransportInfoType.TransportInfo createTransportInfoTypeTransportInfo() {
        return new TransportInfoType.TransportInfo();
    }

    /**
     * Create an instance of {@link RoomTypeType.Amenities }
     * 
     */
    public RoomTypeType.Amenities createRoomTypeTypeAmenities() {
        return new RoomTypeType.Amenities();
    }

    /**
     * Create an instance of {@link RoomTypeType.Occupancy }
     * 
     */
    public RoomTypeType.Occupancy createRoomTypeTypeOccupancy() {
        return new RoomTypeType.Occupancy();
    }

    /**
     * Create an instance of {@link CustomerType.Telephone }
     * 
     */
    public CustomerType.Telephone createCustomerTypeTelephone() {
        return new CustomerType.Telephone();
    }

    /**
     * Create an instance of {@link CustomerType.Email }
     * 
     */
    public CustomerType.Email createCustomerTypeEmail() {
        return new CustomerType.Email();
    }

    /**
     * Create an instance of {@link CustomerType.Address }
     * 
     */
    public CustomerType.Address createCustomerTypeAddress() {
        return new CustomerType.Address();
    }

    /**
     * Create an instance of {@link CustomerType.URL }
     * 
     */
    public CustomerType.URL createCustomerTypeURL() {
        return new CustomerType.URL();
    }

    /**
     * Create an instance of {@link CustomerType.CitizenCountryName }
     * 
     */
    public CustomerType.CitizenCountryName createCustomerTypeCitizenCountryName() {
        return new CustomerType.CitizenCountryName();
    }

    /**
     * Create an instance of {@link CustomerType.PhysChallName }
     * 
     */
    public CustomerType.PhysChallName createCustomerTypePhysChallName() {
        return new CustomerType.PhysChallName();
    }

    /**
     * Create an instance of {@link CustomerType.AdditionalLanguage }
     * 
     */
    public CustomerType.AdditionalLanguage createCustomerTypeAdditionalLanguage() {
        return new CustomerType.AdditionalLanguage();
    }

    /**
     * Create an instance of {@link CustomerType.CustLoyalty.SubAccountBalance }
     * 
     */
    public CustomerType.CustLoyalty.SubAccountBalance createCustomerTypeCustLoyaltySubAccountBalance() {
        return new CustomerType.CustLoyalty.SubAccountBalance();
    }

    /**
     * Create an instance of {@link CustomerType.CustLoyalty.SecurityInfo.PasswordHint }
     * 
     */
    public CustomerType.CustLoyalty.SecurityInfo.PasswordHint createCustomerTypeCustLoyaltySecurityInfoPasswordHint() {
        return new CustomerType.CustLoyalty.SecurityInfo.PasswordHint();
    }

    /**
     * Create an instance of {@link CustomerType.CustLoyalty.MemberPreferences.AdditionalReward }
     * 
     */
    public CustomerType.CustLoyalty.MemberPreferences.AdditionalReward createCustomerTypeCustLoyaltyMemberPreferencesAdditionalReward() {
        return new CustomerType.CustLoyalty.MemberPreferences.AdditionalReward();
    }

    /**
     * Create an instance of {@link CustomerType.CustLoyalty.MemberPreferences.Offer.Communication }
     * 
     */
    public CustomerType.CustLoyalty.MemberPreferences.Offer.Communication createCustomerTypeCustLoyaltyMemberPreferencesOfferCommunication() {
        return new CustomerType.CustLoyalty.MemberPreferences.Offer.Communication();
    }

    /**
     * Create an instance of {@link CustomerType.PaymentForm.AssociatedSupplier }
     * 
     */
    public CustomerType.PaymentForm.AssociatedSupplier createCustomerTypePaymentFormAssociatedSupplier() {
        return new CustomerType.PaymentForm.AssociatedSupplier();
    }

    /**
     * Create an instance of {@link OrdersType.Order.Products.Product }
     * 
     */
    public OrdersType.Order.Products.Product createOrdersTypeOrderProductsProduct() {
        return new OrdersType.Order.Products.Product();
    }

    /**
     * Create an instance of {@link AcceptablePaymentCardsInfoType.AcceptablePaymentCards.AcceptablePaymentCard }
     * 
     */
    public AcceptablePaymentCardsInfoType.AcceptablePaymentCards.AcceptablePaymentCard createAcceptablePaymentCardsInfoTypeAcceptablePaymentCardsAcceptablePaymentCard() {
        return new AcceptablePaymentCardsInfoType.AcceptablePaymentCards.AcceptablePaymentCard();
    }

    /**
     * Create an instance of {@link ServiceRPHsType.ServiceRPH }
     * 
     */
    public ServiceRPHsType.ServiceRPH createServiceRPHsTypeServiceRPH() {
        return new ServiceRPHsType.ServiceRPH();
    }

    /**
     * Create an instance of {@link ProductDescriptionsType.ProductDescription }
     * 
     */
    public ProductDescriptionsType.ProductDescription createProductDescriptionsTypeProductDescription() {
        return new ProductDescriptionsType.ProductDescription();
    }

    /**
     * Create an instance of {@link TextItemsType.TextItem }
     * 
     */
    public TextItemsType.TextItem createTextItemsTypeTextItem() {
        return new TextItemsType.TextItem();
    }

    /**
     * Create an instance of {@link TextDescriptionType.Description }
     * 
     */
    public TextDescriptionType.Description createTextDescriptionTypeDescription() {
        return new TextDescriptionType.Description();
    }

    /**
     * Create an instance of {@link OperationSchedulesPlusChargeType.OperationSchedule }
     * 
     */
    public OperationSchedulesPlusChargeType.OperationSchedule createOperationSchedulesPlusChargeTypeOperationSchedule() {
        return new OperationSchedulesPlusChargeType.OperationSchedule();
    }

    /**
     * Create an instance of {@link SellableProductsType.SellableProduct.InventoryBlock }
     * 
     */
    public SellableProductsType.SellableProduct.InventoryBlock createSellableProductsTypeSellableProductInventoryBlock() {
        return new SellableProductsType.SellableProduct.InventoryBlock();
    }

    /**
     * Create an instance of {@link SellableProductsType.SellableProduct.DestinationSystemCodes.DestinationSystemCode }
     * 
     */
    public SellableProductsType.SellableProduct.DestinationSystemCodes.DestinationSystemCode createSellableProductsTypeSellableProductDestinationSystemCodesDestinationSystemCode() {
        return new SellableProductsType.SellableProduct.DestinationSystemCodes.DestinationSystemCode();
    }

    /**
     * Create an instance of {@link ContactPersonType.Telephone }
     * 
     */
    public ContactPersonType.Telephone createContactPersonTypeTelephone() {
        return new ContactPersonType.Telephone();
    }

    /**
     * Create an instance of {@link RecipientInfosType.RecipientInfo.ShippingInfo }
     * 
     */
    public RecipientInfosType.RecipientInfo.ShippingInfo createRecipientInfosTypeRecipientInfoShippingInfo() {
        return new RecipientInfosType.RecipientInfo.ShippingInfo();
    }

    /**
     * Create an instance of {@link RecipientInfosType.RecipientInfo.Comments }
     * 
     */
    public RecipientInfosType.RecipientInfo.Comments createRecipientInfosTypeRecipientInfoComments() {
        return new RecipientInfosType.RecipientInfo.Comments();
    }

    /**
     * Create an instance of {@link CommonPrefType.ContactPref }
     * 
     */
    public CommonPrefType.ContactPref createCommonPrefTypeContactPref() {
        return new CommonPrefType.ContactPref();
    }

    /**
     * Create an instance of {@link RateQualifierType.RateComments.RateComment }
     * 
     */
    public RateQualifierType.RateComments.RateComment createRateQualifierTypeRateCommentsRateComment() {
        return new RateQualifierType.RateComments.RateComment();
    }

    /**
     * Create an instance of {@link RoomStayType.RoomTypes }
     * 
     */
    public RoomStayType.RoomTypes createRoomStayTypeRoomTypes() {
        return new RoomStayType.RoomTypes();
    }

    /**
     * Create an instance of {@link RoomStayType.RatePlans }
     * 
     */
    public RoomStayType.RatePlans createRoomStayTypeRatePlans() {
        return new RoomStayType.RatePlans();
    }

    /**
     * Create an instance of {@link RoomStayType.MapURL }
     * 
     */
    public RoomStayType.MapURL createRoomStayTypeMapURL() {
        return new RoomStayType.MapURL();
    }

    /**
     * Create an instance of {@link RoomRateType.Availability }
     * 
     */
    public RoomRateType.Availability createRoomRateTypeAvailability() {
        return new RoomRateType.Availability();
    }

    /**
     * Create an instance of {@link RoomStayType.RoomRates.RoomRate.AdvanceBookingRestriction }
     * 
     */
    public RoomStayType.RoomRates.RoomRate.AdvanceBookingRestriction createRoomStayTypeRoomRatesRoomRateAdvanceBookingRestriction() {
        return new RoomStayType.RoomRates.RoomRate.AdvanceBookingRestriction();
    }

    /**
     * Create an instance of {@link RoomStayType.RoomRates.RoomRate.GuestCounts.GuestCount }
     * 
     */
    public RoomStayType.RoomRates.RoomRate.GuestCounts.GuestCount createRoomStayTypeRoomRatesRoomRateGuestCountsGuestCount() {
        return new RoomStayType.RoomRates.RoomRate.GuestCounts.GuestCount();
    }

    /**
     * Create an instance of {@link RoomStayType.RoomRates.RoomRate.Restrictions.Restriction }
     * 
     */
    public RoomStayType.RoomRates.RoomRate.Restrictions.Restriction createRoomStayTypeRoomRatesRoomRateRestrictionsRestriction() {
        return new RoomStayType.RoomRates.RoomRate.Restrictions.Restriction();
    }

    /**
     * Create an instance of {@link RoomRateType.Features.Feature }
     * 
     */
    public RoomRateType.Features.Feature createRoomRateTypeFeaturesFeature() {
        return new RoomRateType.Features.Feature();
    }

    /**
     * Create an instance of {@link HotelRoomListType.MasterAccount }
     * 
     */
    public HotelRoomListType.MasterAccount createHotelRoomListTypeMasterAccount() {
        return new HotelRoomListType.MasterAccount();
    }

    /**
     * Create an instance of {@link HotelRoomListType.Event }
     * 
     */
    public HotelRoomListType.Event createHotelRoomListTypeEvent() {
        return new HotelRoomListType.Event();
    }

    /**
     * Create an instance of {@link HotelRoomListType.RoomStays.RoomStay }
     * 
     */
    public HotelRoomListType.RoomStays.RoomStay createHotelRoomListTypeRoomStaysRoomStay() {
        return new HotelRoomListType.RoomStays.RoomStay();
    }

    /**
     * Create an instance of {@link HotelRoomListType.MasterContact.UniqueIDs }
     * 
     */
    public HotelRoomListType.MasterContact.UniqueIDs createHotelRoomListTypeMasterContactUniqueIDs() {
        return new HotelRoomListType.MasterContact.UniqueIDs();
    }

    /**
     * Create an instance of {@link HotelRoomListType.MasterContact.Loyalty }
     * 
     */
    public HotelRoomListType.MasterContact.Loyalty createHotelRoomListTypeMasterContactLoyalty() {
        return new HotelRoomListType.MasterContact.Loyalty();
    }

    /**
     * Create an instance of {@link HotelRoomListType.Guests.Guest.Loyalty }
     * 
     */
    public HotelRoomListType.Guests.Guest.Loyalty createHotelRoomListTypeGuestsGuestLoyalty() {
        return new HotelRoomListType.Guests.Guest.Loyalty();
    }

    /**
     * Create an instance of {@link HotelRoomListType.Guests.Guest.GuaranteePayment }
     * 
     */
    public HotelRoomListType.Guests.Guest.GuaranteePayment createHotelRoomListTypeGuestsGuestGuaranteePayment() {
        return new HotelRoomListType.Guests.Guest.GuaranteePayment();
    }

    /**
     * Create an instance of {@link HotelPaymentFormType.MasterAccountUsage }
     * 
     */
    public HotelPaymentFormType.MasterAccountUsage createHotelPaymentFormTypeMasterAccountUsage() {
        return new HotelPaymentFormType.MasterAccountUsage();
    }

    /**
     * Create an instance of {@link TravelerRPHs.TravelerRPH }
     * 
     */
    public TravelerRPHs.TravelerRPH createTravelerRPHsTravelerRPH() {
        return new TravelerRPHs.TravelerRPH();
    }

    /**
     * Create an instance of {@link HotelDescriptiveContentType.Policies }
     * 
     */
    public HotelDescriptiveContentType.Policies createHotelDescriptiveContentTypePolicies() {
        return new HotelDescriptiveContentType.Policies();
    }

    /**
     * Create an instance of {@link HotelDescriptiveContentType.EffectivePeriods.EffectivePeriod }
     * 
     */
    public HotelDescriptiveContentType.EffectivePeriods.EffectivePeriod createHotelDescriptiveContentTypeEffectivePeriodsEffectivePeriod() {
        return new HotelDescriptiveContentType.EffectivePeriods.EffectivePeriod();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.Descriptions }
     * 
     */
    public AffiliationInfoType.Descriptions createAffiliationInfoTypeDescriptions() {
        return new AffiliationInfoType.Descriptions();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.PartnerInfos.PartnerInfo }
     * 
     */
    public AffiliationInfoType.PartnerInfos.PartnerInfo createAffiliationInfoTypePartnerInfosPartnerInfo() {
        return new AffiliationInfoType.PartnerInfos.PartnerInfo();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.Awards.Award }
     * 
     */
    public AffiliationInfoType.Awards.Award createAffiliationInfoTypeAwardsAward() {
        return new AffiliationInfoType.Awards.Award();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramDescription }
     * 
     */
    public AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramDescription createAffiliationInfoTypeLoyalProgramsLoyalProgramProgramDescription() {
        return new AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramDescription();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction }
     * 
     */
    public AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction createAffiliationInfoTypeLoyalProgramsLoyalProgramProgramRestriction() {
        return new AffiliationInfoType.LoyalPrograms.LoyalProgram.ProgramRestriction();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.Brands.Brand }
     * 
     */
    public AffiliationInfoType.Brands.Brand createAffiliationInfoTypeBrandsBrand() {
        return new AffiliationInfoType.Brands.Brand();
    }

    /**
     * Create an instance of {@link AffiliationInfoType.DistribSystems.DistribSystem }
     * 
     */
    public AffiliationInfoType.DistribSystems.DistribSystem createAffiliationInfoTypeDistribSystemsDistribSystem() {
        return new AffiliationInfoType.DistribSystems.DistribSystem();
    }

    /**
     * Create an instance of {@link DocumentType.AdditionalPersonNames }
     * 
     */
    public DocumentType.AdditionalPersonNames createDocumentTypeAdditionalPersonNames() {
        return new DocumentType.AdditionalPersonNames();
    }

    /**
     * Create an instance of {@link ResGuestRPHsType.ResGuestRPH }
     * 
     */
    public ResGuestRPHsType.ResGuestRPH createResGuestRPHsTypeResGuestRPH() {
        return new ResGuestRPHsType.ResGuestRPH();
    }

    /**
     * Create an instance of {@link HotelReservationIDsType.HotelReservationID }
     * 
     */
    public HotelReservationIDsType.HotelReservationID createHotelReservationIDsTypeHotelReservationID() {
        return new HotelReservationIDsType.HotelReservationID();
    }

    /**
     * Create an instance of {@link RoutingHopType.RoutingHop }
     * 
     */
    public RoutingHopType.RoutingHop createRoutingHopTypeRoutingHop() {
        return new RoutingHopType.RoutingHop();
    }

    /**
     * Create an instance of {@link LoyaltyPointsAccrualsType.SelectedLoyalty }
     * 
     */
    public LoyaltyPointsAccrualsType.SelectedLoyalty createLoyaltyPointsAccrualsTypeSelectedLoyalty() {
        return new LoyaltyPointsAccrualsType.SelectedLoyalty();
    }

    /**
     * Create an instance of {@link CommentType.Comment }
     * 
     */
    public CommentType.Comment createCommentTypeComment() {
        return new CommentType.Comment();
    }

    /**
     * Create an instance of {@link GuestRoomType.Quantities }
     * 
     */
    public GuestRoomType.Quantities createGuestRoomTypeQuantities() {
        return new GuestRoomType.Quantities();
    }

    /**
     * Create an instance of {@link GuestRoomType.Occupancy }
     * 
     */
    public GuestRoomType.Occupancy createGuestRoomTypeOccupancy() {
        return new GuestRoomType.Occupancy();
    }

    /**
     * Create an instance of {@link GuestRoomType.Room }
     * 
     */
    public GuestRoomType.Room createGuestRoomTypeRoom() {
        return new GuestRoomType.Room();
    }

    /**
     * Create an instance of {@link GuestRoomType.RoomLevelFees }
     * 
     */
    public GuestRoomType.RoomLevelFees createGuestRoomTypeRoomLevelFees() {
        return new GuestRoomType.RoomLevelFees();
    }

    /**
     * Create an instance of {@link GuestRoomType.Amenities.Amenity }
     * 
     */
    public GuestRoomType.Amenities.Amenity createGuestRoomTypeAmenitiesAmenity() {
        return new GuestRoomType.Amenities.Amenity();
    }

    /**
     * Create an instance of {@link AdjustmentsType.Adjustment }
     * 
     */
    public AdjustmentsType.Adjustment createAdjustmentsTypeAdjustment() {
        return new AdjustmentsType.Adjustment();
    }

    /**
     * Create an instance of {@link StatisticType.StatisticApplicationSets }
     * 
     */
    public StatisticType.StatisticApplicationSets createStatisticTypeStatisticApplicationSets() {
        return new StatisticType.StatisticApplicationSets();
    }

    /**
     * Create an instance of {@link PhonePrefType.Telephone }
     * 
     */
    public PhonePrefType.Telephone createPhonePrefTypeTelephone() {
        return new PhonePrefType.Telephone();
    }

    /**
     * Create an instance of {@link ImageDescriptionType.ImageFormat }
     * 
     */
    public ImageDescriptionType.ImageFormat createImageDescriptionTypeImageFormat() {
        return new ImageDescriptionType.ImageFormat();
    }

    /**
     * Create an instance of {@link ImageDescriptionType.Description }
     * 
     */
    public ImageDescriptionType.Description createImageDescriptionTypeDescription() {
        return new ImageDescriptionType.Description();
    }

    /**
     * Create an instance of {@link ConnectionType.ConnectionLocation }
     * 
     */
    public ConnectionType.ConnectionLocation createConnectionTypeConnectionLocation() {
        return new ConnectionType.ConnectionLocation();
    }

    /**
     * Create an instance of {@link GDSInfoType.GDSCodes.GDSCode.GDSCodeDetails.GDSCodeDetail }
     * 
     */
    public GDSInfoType.GDSCodes.GDSCode.GDSCodeDetails.GDSCodeDetail createGDSInfoTypeGDSCodesGDSCodeGDSCodeDetailsGDSCodeDetail() {
        return new GDSInfoType.GDSCodes.GDSCode.GDSCodeDetails.GDSCodeDetail();
    }

    /**
     * Create an instance of {@link TravelClubType.ClubMemberName }
     * 
     */
    public TravelClubType.ClubMemberName createTravelClubTypeClubMemberName() {
        return new TravelClubType.ClubMemberName();
    }

    /**
     * Create an instance of {@link MessageType.OriginalPayloadStdAttributes }
     * 
     */
    public MessageType.OriginalPayloadStdAttributes createMessageTypeOriginalPayloadStdAttributes() {
        return new MessageType.OriginalPayloadStdAttributes();
    }

    /**
     * Create an instance of {@link SpecialRequestType.SpecialRequest }
     * 
     */
    public SpecialRequestType.SpecialRequest createSpecialRequestTypeSpecialRequest() {
        return new SpecialRequestType.SpecialRequest();
    }

    /**
     * Create an instance of {@link PhonesType.Phone }
     * 
     */
    public PhonesType.Phone createPhonesTypePhone() {
        return new PhonesType.Phone();
    }

    /**
     * Create an instance of {@link CompanyInfoType.AddressInfo }
     * 
     */
    public CompanyInfoType.AddressInfo createCompanyInfoTypeAddressInfo() {
        return new CompanyInfoType.AddressInfo();
    }

    /**
     * Create an instance of {@link CompanyInfoType.TelephoneInfo }
     * 
     */
    public CompanyInfoType.TelephoneInfo createCompanyInfoTypeTelephoneInfo() {
        return new CompanyInfoType.TelephoneInfo();
    }

    /**
     * Create an instance of {@link CompanyInfoType.Email }
     * 
     */
    public CompanyInfoType.Email createCompanyInfoTypeEmail() {
        return new CompanyInfoType.Email();
    }

    /**
     * Create an instance of {@link CompanyInfoType.PaymentForm }
     * 
     */
    public CompanyInfoType.PaymentForm createCompanyInfoTypePaymentForm() {
        return new CompanyInfoType.PaymentForm();
    }

    /**
     * Create an instance of {@link CompanyInfoType.TripPurpose }
     * 
     */
    public CompanyInfoType.TripPurpose createCompanyInfoTypeTripPurpose() {
        return new CompanyInfoType.TripPurpose();
    }

    /**
     * Create an instance of {@link AvailStatusMessageType.HurdleRate }
     * 
     */
    public AvailStatusMessageType.HurdleRate createAvailStatusMessageTypeHurdleRate() {
        return new AvailStatusMessageType.HurdleRate();
    }

    /**
     * Create an instance of {@link AvailStatusMessageType.Delta }
     * 
     */
    public AvailStatusMessageType.Delta createAvailStatusMessageTypeDelta() {
        return new AvailStatusMessageType.Delta();
    }

    /**
     * Create an instance of {@link AvailStatusMessageType.RestrictionStatus }
     * 
     */
    public AvailStatusMessageType.RestrictionStatus createAvailStatusMessageTypeRestrictionStatus() {
        return new AvailStatusMessageType.RestrictionStatus();
    }

    /**
     * Create an instance of {@link AvailStatusMessageType.BestAvailableRates.BestAvailableRate }
     * 
     */
    public AvailStatusMessageType.BestAvailableRates.BestAvailableRate createAvailStatusMessageTypeBestAvailableRatesBestAvailableRate() {
        return new AvailStatusMessageType.BestAvailableRates.BestAvailableRate();
    }

    /**
     * Create an instance of {@link SourceType.RequestorID }
     * 
     */
    public SourceType.RequestorID createSourceTypeRequestorID() {
        return new SourceType.RequestorID();
    }

    /**
     * Create an instance of {@link SourceType.Position }
     * 
     */
    public SourceType.Position createSourceTypePosition() {
        return new SourceType.Position();
    }

    /**
     * Create an instance of {@link SourceType.BookingChannel }
     * 
     */
    public SourceType.BookingChannel createSourceTypeBookingChannel() {
        return new SourceType.BookingChannel();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.HotelAmenity }
     * 
     */
    public HotelSearchCriterionType.HotelAmenity createHotelSearchCriterionTypeHotelAmenity() {
        return new HotelSearchCriterionType.HotelAmenity();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.HotelFeature }
     * 
     */
    public HotelSearchCriterionType.HotelFeature createHotelSearchCriterionTypeHotelFeature() {
        return new HotelSearchCriterionType.HotelFeature();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.Award }
     * 
     */
    public HotelSearchCriterionType.Award createHotelSearchCriterionTypeAward() {
        return new HotelSearchCriterionType.Award();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.Recreation }
     * 
     */
    public HotelSearchCriterionType.Recreation createHotelSearchCriterionTypeRecreation() {
        return new HotelSearchCriterionType.Recreation();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.Service }
     * 
     */
    public HotelSearchCriterionType.Service createHotelSearchCriterionTypeService() {
        return new HotelSearchCriterionType.Service();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.Transportation }
     * 
     */
    public HotelSearchCriterionType.Transportation createHotelSearchCriterionTypeTransportation() {
        return new HotelSearchCriterionType.Transportation();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.RateRange }
     * 
     */
    public HotelSearchCriterionType.RateRange createHotelSearchCriterionTypeRateRange() {
        return new HotelSearchCriterionType.RateRange();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.RatePlanCandidates }
     * 
     */
    public HotelSearchCriterionType.RatePlanCandidates createHotelSearchCriterionTypeRatePlanCandidates() {
        return new HotelSearchCriterionType.RatePlanCandidates();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.RoomStayCandidates }
     * 
     */
    public HotelSearchCriterionType.RoomStayCandidates createHotelSearchCriterionTypeRoomStayCandidates() {
        return new HotelSearchCriterionType.RoomStayCandidates();
    }

    /**
     * Create an instance of {@link HotelSearchCriterionType.RebatePrograms }
     * 
     */
    public HotelSearchCriterionType.RebatePrograms createHotelSearchCriterionTypeRebatePrograms() {
        return new HotelSearchCriterionType.RebatePrograms();
    }

    /**
     * Create an instance of {@link HotelInfoType.HotelName }
     * 
     */
    public HotelInfoType.HotelName createHotelInfoTypeHotelName() {
        return new HotelInfoType.HotelName();
    }

    /**
     * Create an instance of {@link HotelInfoType.ClosedSeasons }
     * 
     */
    public HotelInfoType.ClosedSeasons createHotelInfoTypeClosedSeasons() {
        return new HotelInfoType.ClosedSeasons();
    }

    /**
     * Create an instance of {@link HotelInfoType.RelativePositions }
     * 
     */
    public HotelInfoType.RelativePositions createHotelInfoTypeRelativePositions() {
        return new HotelInfoType.RelativePositions();
    }

    /**
     * Create an instance of {@link HotelInfoType.Position }
     * 
     */
    public HotelInfoType.Position createHotelInfoTypePosition() {
        return new HotelInfoType.Position();
    }

    /**
     * Create an instance of {@link HotelInfoType.WeatherInfos }
     * 
     */
    public HotelInfoType.WeatherInfos createHotelInfoTypeWeatherInfos() {
        return new HotelInfoType.WeatherInfos();
    }

    /**
     * Create an instance of {@link HotelInfoType.Languages.Language }
     * 
     */
    public HotelInfoType.Languages.Language createHotelInfoTypeLanguagesLanguage() {
        return new HotelInfoType.Languages.Language();
    }

    /**
     * Create an instance of {@link HotelInfoType.OwnershipManagementInfos.OwnershipManagementInfo }
     * 
     */
    public HotelInfoType.OwnershipManagementInfos.OwnershipManagementInfo createHotelInfoTypeOwnershipManagementInfosOwnershipManagementInfo() {
        return new HotelInfoType.OwnershipManagementInfos.OwnershipManagementInfo();
    }

    /**
     * Create an instance of {@link HotelInfoType.Services.Service }
     * 
     */
    public HotelInfoType.Services.Service createHotelInfoTypeServicesService() {
        return new HotelInfoType.Services.Service();
    }

    /**
     * Create an instance of {@link HotelInfoType.HotelInfoCodes.HotelInfoCode }
     * 
     */
    public HotelInfoType.HotelInfoCodes.HotelInfoCode createHotelInfoTypeHotelInfoCodesHotelInfoCode() {
        return new HotelInfoType.HotelInfoCodes.HotelInfoCode();
    }

    /**
     * Create an instance of {@link HotelInfoType.Descriptions.Renovation }
     * 
     */
    public HotelInfoType.Descriptions.Renovation createHotelInfoTypeDescriptionsRenovation() {
        return new HotelInfoType.Descriptions.Renovation();
    }

    /**
     * Create an instance of {@link HotelInfoType.Descriptions.MultimediaDescriptions }
     * 
     */
    public HotelInfoType.Descriptions.MultimediaDescriptions createHotelInfoTypeDescriptionsMultimediaDescriptions() {
        return new HotelInfoType.Descriptions.MultimediaDescriptions();
    }

    /**
     * Create an instance of {@link HotelSearchCriteriaType.Criterion }
     * 
     */
    public HotelSearchCriteriaType.Criterion createHotelSearchCriteriaTypeCriterion() {
        return new HotelSearchCriteriaType.Criterion();
    }

    /**
     * Create an instance of {@link PreferencesType.PrefCollection }
     * 
     */
    public PreferencesType.PrefCollection createPreferencesTypePrefCollection() {
        return new PreferencesType.PrefCollection();
    }

    /**
     * Create an instance of {@link VideoItemsType.VideoItem }
     * 
     */
    public VideoItemsType.VideoItem createVideoItemsTypeVideoItem() {
        return new VideoItemsType.VideoItem();
    }

    /**
     * Create an instance of {@link LengthsOfStayType.LengthOfStay.LOSPattern }
     * 
     */
    public LengthsOfStayType.LengthOfStay.LOSPattern createLengthsOfStayTypeLengthOfStayLOSPattern() {
        return new LengthsOfStayType.LengthOfStay.LOSPattern();
    }

    /**
     * Create an instance of {@link MembershipType.Membership }
     * 
     */
    public MembershipType.Membership createMembershipTypeMembership() {
        return new MembershipType.Membership();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.ProfileType.UserID }
     * 
     */
    public com.desia.artifacts.booking.ProfileType.UserID createProfileTypeUserID() {
        return new com.desia.artifacts.booking.ProfileType.UserID();
    }

    /**
     * Create an instance of {@link com.desia.artifacts.booking.ProfileType.Comments.Comment.AuthorizedViewer }
     * 
     */
    public com.desia.artifacts.booking.ProfileType.Comments.Comment.AuthorizedViewer createProfileTypeCommentsCommentAuthorizedViewer() {
        return new com.desia.artifacts.booking.ProfileType.Comments.Comment.AuthorizedViewer();
    }

    /**
     * Create an instance of {@link HotelAdditionalChargesType.AdditionalCharge }
     * 
     */
    public HotelAdditionalChargesType.AdditionalCharge createHotelAdditionalChargesTypeAdditionalCharge() {
        return new HotelAdditionalChargesType.AdditionalCharge();
    }

    /**
     * Create an instance of {@link BaseInvCountType.OffSell }
     * 
     */
    public BaseInvCountType.OffSell createBaseInvCountTypeOffSell() {
        return new BaseInvCountType.OffSell();
    }

    /**
     * Create an instance of {@link BaseInvCountType.InvCounts.InvCount.InvBlockCutoff }
     * 
     */
    public BaseInvCountType.InvCounts.InvCount.InvBlockCutoff createBaseInvCountTypeInvCountsInvCountInvBlockCutoff() {
        return new BaseInvCountType.InvCounts.InvCount.InvBlockCutoff();
    }

    /**
     * Create an instance of {@link CategoryCodesType.LocationCategory }
     * 
     */
    public CategoryCodesType.LocationCategory createCategoryCodesTypeLocationCategory() {
        return new CategoryCodesType.LocationCategory();
    }

    /**
     * Create an instance of {@link CategoryCodesType.SegmentCategory }
     * 
     */
    public CategoryCodesType.SegmentCategory createCategoryCodesTypeSegmentCategory() {
        return new CategoryCodesType.SegmentCategory();
    }

    /**
     * Create an instance of {@link CategoryCodesType.HotelCategory }
     * 
     */
    public CategoryCodesType.HotelCategory createCategoryCodesTypeHotelCategory() {
        return new CategoryCodesType.HotelCategory();
    }

    /**
     * Create an instance of {@link CategoryCodesType.ArchitecturalStyle }
     * 
     */
    public CategoryCodesType.ArchitecturalStyle createCategoryCodesTypeArchitecturalStyle() {
        return new CategoryCodesType.ArchitecturalStyle();
    }

    /**
     * Create an instance of {@link CategoryCodesType.GuestRoomInfo.RateRanges.RateRange }
     * 
     */
    public CategoryCodesType.GuestRoomInfo.RateRanges.RateRange createCategoryCodesTypeGuestRoomInfoRateRangesRateRange() {
        return new CategoryCodesType.GuestRoomInfo.RateRanges.RateRange();
    }

    /**
     * Create an instance of {@link RoomStayLiteType.RoomTypes }
     * 
     */
    public RoomStayLiteType.RoomTypes createRoomStayLiteTypeRoomTypes() {
        return new RoomStayLiteType.RoomTypes();
    }

    /**
     * Create an instance of {@link RoomStayLiteType.RatePlans }
     * 
     */
    public RoomStayLiteType.RatePlans createRoomStayLiteTypeRatePlans() {
        return new RoomStayLiteType.RatePlans();
    }

    /**
     * Create an instance of {@link RoomStayLiteType.RoomRates }
     * 
     */
    public RoomStayLiteType.RoomRates createRoomStayLiteTypeRoomRates() {
        return new RoomStayLiteType.RoomRates();
    }

    /**
     * Create an instance of {@link RoomStayLiteType.BasicPropertyInfo }
     * 
     */
    public RoomStayLiteType.BasicPropertyInfo createRoomStayLiteTypeBasicPropertyInfo() {
        return new RoomStayLiteType.BasicPropertyInfo();
    }

    /**
     * Create an instance of {@link RatePlanType.RatePlanInclusions }
     * 
     */
    public RatePlanType.RatePlanInclusions createRatePlanTypeRatePlanInclusions() {
        return new RatePlanType.RatePlanInclusions();
    }

    /**
     * Create an instance of {@link RatePlanType.MealsIncluded }
     * 
     */
    public RatePlanType.MealsIncluded createRatePlanTypeMealsIncluded() {
        return new RatePlanType.MealsIncluded();
    }

    /**
     * Create an instance of {@link RatePlanType.RestrictionStatus }
     * 
     */
    public RatePlanType.RestrictionStatus createRatePlanTypeRestrictionStatus() {
        return new RatePlanType.RestrictionStatus();
    }

    /**
     * Create an instance of {@link ResGuestType.ProfileRPHs.ProfileRPH }
     * 
     */
    public ResGuestType.ProfileRPHs.ProfileRPH createResGuestTypeProfileRPHsProfileRPH() {
        return new ResGuestType.ProfileRPHs.ProfileRPH();
    }

    /**
     * Create an instance of {@link ImageItemsType.ImageItem }
     * 
     */
    public ImageItemsType.ImageItem createImageItemsTypeImageItem() {
        return new ImageItemsType.ImageItem();
    }

    /**
     * Create an instance of {@link EmailsType.Email }
     * 
     */
    public EmailsType.Email createEmailsTypeEmail() {
        return new EmailsType.Email();
    }

    /**
     * Create an instance of {@link AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria }
     * 
     */
    public AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria createAvailRequestSegmentsTypeAvailRequestSegmentHotelSearchCriteria() {
        return new AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria();
    }

    /**
     * Create an instance of {@link PaymentCardType.CardIssuerName }
     * 
     */
    public PaymentCardType.CardIssuerName createPaymentCardTypeCardIssuerName() {
        return new PaymentCardType.CardIssuerName();
    }

    /**
     * Create an instance of {@link PaymentCardType.Telephone }
     * 
     */
    public PaymentCardType.Telephone createPaymentCardTypeTelephone() {
        return new PaymentCardType.Telephone();
    }

    /**
     * Create an instance of {@link PaymentCardType.CustLoyalty }
     * 
     */
    public PaymentCardType.CustLoyalty createPaymentCardTypeCustLoyalty() {
        return new PaymentCardType.CustLoyalty();
    }

    /**
     * Create an instance of {@link PaymentCardType.SignatureOnFile }
     * 
     */
    public PaymentCardType.SignatureOnFile createPaymentCardTypeSignatureOnFile() {
        return new PaymentCardType.SignatureOnFile();
    }

    /**
     * Create an instance of {@link PaymentCardType.MagneticStripe }
     * 
     */
    public PaymentCardType.MagneticStripe createPaymentCardTypeMagneticStripe() {
        return new PaymentCardType.MagneticStripe();
    }

    /**
     * Create an instance of {@link HotelResModifyType.HotelResModify.Verification }
     * 
     */
    public HotelResModifyType.HotelResModify.Verification createHotelResModifyTypeHotelResModifyVerification() {
        return new HotelResModifyType.HotelResModify.Verification();
    }

    /**
     * Create an instance of {@link VerificationType.PersonName }
     * 
     */
    public VerificationType.PersonName createVerificationTypePersonName() {
        return new VerificationType.PersonName();
    }

    /**
     * Create an instance of {@link VerificationType.TelephoneInfo }
     * 
     */
    public VerificationType.TelephoneInfo createVerificationTypeTelephoneInfo() {
        return new VerificationType.TelephoneInfo();
    }

    /**
     * Create an instance of {@link VerificationType.CustLoyalty }
     * 
     */
    public VerificationType.CustLoyalty createVerificationTypeCustLoyalty() {
        return new VerificationType.CustLoyalty();
    }

    /**
     * Create an instance of {@link VerificationType.ReservationTimeSpan }
     * 
     */
    public VerificationType.ReservationTimeSpan createVerificationTypeReservationTimeSpan() {
        return new VerificationType.ReservationTimeSpan();
    }

    /**
     * Create an instance of {@link VerificationType.AssociatedQuantity }
     * 
     */
    public VerificationType.AssociatedQuantity createVerificationTypeAssociatedQuantity() {
        return new VerificationType.AssociatedQuantity();
    }

    /**
     * Create an instance of {@link VerificationType.StartLocation }
     * 
     */
    public VerificationType.StartLocation createVerificationTypeStartLocation() {
        return new VerificationType.StartLocation();
    }

    /**
     * Create an instance of {@link VerificationType.EndLocation }
     * 
     */
    public VerificationType.EndLocation createVerificationTypeEndLocation() {
        return new VerificationType.EndLocation();
    }

    /**
     * Create an instance of {@link CommissionType.CommissionableAmount }
     * 
     */
    public CommissionType.CommissionableAmount createCommissionTypeCommissionableAmount() {
        return new CommissionType.CommissionableAmount();
    }

    /**
     * Create an instance of {@link CommissionType.PrepaidAmount }
     * 
     */
    public CommissionType.PrepaidAmount createCommissionTypePrepaidAmount() {
        return new CommissionType.PrepaidAmount();
    }

    /**
     * Create an instance of {@link CommissionType.FlatCommission }
     * 
     */
    public CommissionType.FlatCommission createCommissionTypeFlatCommission() {
        return new CommissionType.FlatCommission();
    }

    /**
     * Create an instance of {@link CommissionType.CommissionPayableAmount }
     * 
     */
    public CommissionType.CommissionPayableAmount createCommissionTypeCommissionPayableAmount() {
        return new CommissionType.CommissionPayableAmount();
    }

    /**
     * Create an instance of {@link CancelPenaltyType.Deadline }
     * 
     */
    public CancelPenaltyType.Deadline createCancelPenaltyTypeDeadline() {
        return new CancelPenaltyType.Deadline();
    }

    /**
     * Create an instance of {@link AgreementsType.ProfileSecurity }
     * 
     */
    public AgreementsType.ProfileSecurity createAgreementsTypeProfileSecurity() {
        return new AgreementsType.ProfileSecurity();
    }

    /**
     * Create an instance of {@link RoomStaysType.RoomStay.Reference }
     * 
     */
    public RoomStaysType.RoomStay.Reference createRoomStaysTypeRoomStayReference() {
        return new RoomStaysType.RoomStay.Reference();
    }

    /**
     * Create an instance of {@link DonationType.FrontOfficeInfo }
     * 
     */
    public DonationType.FrontOfficeInfo createDonationTypeFrontOfficeInfo() {
        return new DonationType.FrontOfficeInfo();
    }

    /**
     * Create an instance of {@link DonationType.CreditCardInfo }
     * 
     */
    public DonationType.CreditCardInfo createDonationTypeCreditCardInfo() {
        return new DonationType.CreditCardInfo();
    }

    /**
     * Create an instance of {@link DonationType.DonorInfo.Name }
     * 
     */
    public DonationType.DonorInfo.Name createDonationTypeDonorInfoName() {
        return new DonationType.DonorInfo.Name();
    }

    /**
     * Create an instance of {@link DonationType.DonorInfo.ContactInfo }
     * 
     */
    public DonationType.DonorInfo.ContactInfo createDonationTypeDonorInfoContactInfo() {
        return new DonationType.DonorInfo.ContactInfo();
    }

    /**
     * Create an instance of {@link OTACancelRQ.Reasons.Reason }
     * 
     */
    public OTACancelRQ.Reasons.Reason createOTACancelRQReasonsReason() {
        return new OTACancelRQ.Reasons.Reason();
    }

    /**
     * Create an instance of {@link OTACancelRQ.OriginAndDestinationSegment.Traveler }
     * 
     */
    public OTACancelRQ.OriginAndDestinationSegment.Traveler createOTACancelRQOriginAndDestinationSegmentTraveler() {
        return new OTACancelRQ.OriginAndDestinationSegment.Traveler();
    }

    /**
     * Create an instance of {@link OTACancelRQ.OriginAndDestinationSegment.Segment }
     * 
     */
    public OTACancelRQ.OriginAndDestinationSegment.Segment createOTACancelRQOriginAndDestinationSegmentSegment() {
        return new OTACancelRQ.OriginAndDestinationSegment.Segment();
    }

    /**
     * Create an instance of {@link ImageJSON.ImagesList.ThumbnailImageObj }
     * 
     */
    public ImageJSON.ImagesList.ThumbnailImageObj createImageJSONImagesListThumbnailImageObj() {
        return new ImageJSON.ImagesList.ThumbnailImageObj();
    }

    /**
     * Create an instance of {@link ImageJSON.ImagesList.LargeImageObj }
     * 
     */
    public ImageJSON.ImagesList.LargeImageObj createImageJSONImagesListLargeImageObj() {
        return new ImageJSON.ImagesList.LargeImageObj();
    }

    /**
     * Create an instance of {@link CancelInfoRSType.CancelRules }
     * 
     */
    public CancelInfoRSType.CancelRules createCancelInfoRSTypeCancelRules() {
        return new CancelInfoRSType.CancelRules();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.CurrencyConversions.CurrencyConversion }
     * 
     */
    public OTAHotelAvailRS.CurrencyConversions.CurrencyConversion createOTAHotelAvailRSCurrencyConversionsCurrencyConversion() {
        return new OTAHotelAvailRS.CurrencyConversions.CurrencyConversion();
    }

    /**
     * Create an instance of {@link AreasType.Area }
     * 
     */
    public AreasType.Area createAreasTypeArea() {
        return new AreasType.Area();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.RoomStays.RoomStay.Reference }
     * 
     */
    public OTAHotelAvailRS.RoomStays.RoomStay.Reference createOTAHotelAvailRSRoomStaysRoomStayReference() {
        return new OTAHotelAvailRS.RoomStays.RoomStay.Reference();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.HotelStays.HotelStay.Price }
     * 
     */
    public OTAHotelAvailRS.HotelStays.HotelStay.Price createOTAHotelAvailRSHotelStaysHotelStayPrice() {
        return new OTAHotelAvailRS.HotelStays.HotelStay.Price();
    }

    /**
     * Create an instance of {@link OTAHotelAvailRS.HotelStays.HotelStay.Availability.Restriction }
     * 
     */
    public OTAHotelAvailRS.HotelStays.HotelStay.Availability.Restriction createOTAHotelAvailRSHotelStaysHotelStayAvailabilityRestriction() {
        return new OTAHotelAvailRS.HotelStays.HotelStay.Availability.Restriction();
    }

    /**
     * Create an instance of {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.RateAmountMessages }
     * 
     */
    public OTANotifReportRQ.NotifDetails.HotelNotifReport.RateAmountMessages createOTANotifReportRQNotifDetailsHotelNotifReportRateAmountMessages() {
        return new OTANotifReportRQ.NotifDetails.HotelNotifReport.RateAmountMessages();
    }

    /**
     * Create an instance of {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents.HotelDescriptiveContent }
     * 
     */
    public OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents.HotelDescriptiveContent createOTANotifReportRQNotifDetailsHotelNotifReportHotelDescriptiveContentsHotelDescriptiveContent() {
        return new OTANotifReportRQ.NotifDetails.HotelNotifReport.HotelDescriptiveContents.HotelDescriptiveContent();
    }

    /**
     * Create an instance of {@link OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages.AvailStatusMessage }
     * 
     */
    public OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages.AvailStatusMessage createOTANotifReportRQNotifDetailsHotelNotifReportAvailStatusMessagesAvailStatusMessage() {
        return new OTANotifReportRQ.NotifDetails.HotelNotifReport.AvailStatusMessages.AvailStatusMessage();
    }

    /**
     * Create an instance of {@link HotelReservationsType.HotelReservation.RebatePrograms }
     * 
     */
    public HotelReservationsType.HotelReservation.RebatePrograms createHotelReservationsTypeHotelReservationRebatePrograms() {
        return new HotelReservationsType.HotelReservation.RebatePrograms();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.ResGuest }
     * 
     */
    public TPAExtensionsType.ResGuest createTPAExtensionsTypeResGuest() {
        return new TPAExtensionsType.ResGuest();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.RoomType }
     * 
     */
    public TPAExtensionsType.RoomType createTPAExtensionsTypeRoomType() {
        return new TPAExtensionsType.RoomType();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.UserAuthentication }
     * 
     */
    public TPAExtensionsType.UserAuthentication createTPAExtensionsTypeUserAuthentication() {
        return new TPAExtensionsType.UserAuthentication();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.DeepLinkInformation }
     * 
     */
    public TPAExtensionsType.DeepLinkInformation createTPAExtensionsTypeDeepLinkInformation() {
        return new TPAExtensionsType.DeepLinkInformation();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.CancelDates }
     * 
     */
    public TPAExtensionsType.CancelDates createTPAExtensionsTypeCancelDates() {
        return new TPAExtensionsType.CancelDates();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.Promotion }
     * 
     */
    public TPAExtensionsType.Promotion createTPAExtensionsTypePromotion() {
        return new TPAExtensionsType.Promotion();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.DiscountCouponDisplayIndicator }
     * 
     */
    public TPAExtensionsType.DiscountCouponDisplayIndicator createTPAExtensionsTypeDiscountCouponDisplayIndicator() {
        return new TPAExtensionsType.DiscountCouponDisplayIndicator();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.AdditionalGuests.AdditionalGuest }
     * 
     */
    public TPAExtensionsType.AdditionalGuests.AdditionalGuest createTPAExtensionsTypeAdditionalGuestsAdditionalGuest() {
        return new TPAExtensionsType.AdditionalGuests.AdditionalGuest();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.Deals.Deal }
     * 
     */
    public TPAExtensionsType.Deals.Deal createTPAExtensionsTypeDealsDeal() {
        return new TPAExtensionsType.Deals.Deal();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages.OtherSeoPage }
     * 
     */
    public TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages.OtherSeoPage createTPAExtensionsTypeSeoInformationSeoPageDataOtherSeoPagesOtherSeoPage() {
        return new TPAExtensionsType.SeoInformation.SeoPageData.OtherSeoPages.OtherSeoPage();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations.OtherDestination }
     * 
     */
    public TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations.OtherDestination createTPAExtensionsTypeSeoInformationDestinationsDestinationOtherDestinationsOtherDestination() {
        return new TPAExtensionsType.SeoInformation.Destinations.Destination.OtherDestinations.OtherDestination();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.Rate.AdditionalGuestAmounts }
     * 
     */
    public TPAExtensionsType.Rate.AdditionalGuestAmounts createTPAExtensionsTypeRateAdditionalGuestAmounts() {
        return new TPAExtensionsType.Rate.AdditionalGuestAmounts();
    }

    /**
     * Create an instance of {@link TPAExtensionsType.Rate.Discount }
     * 
     */
    public TPAExtensionsType.Rate.Discount createTPAExtensionsTypeRateDiscount() {
        return new TPAExtensionsType.Rate.Discount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPAExtensionsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "TPA_Extensions")
    public JAXBElement<TPAExtensionsType> createTPAExtensions(TPAExtensionsType value) {
        return new JAXBElement<TPAExtensionsType>(_TPAExtensions_QNAME, TPAExtensionsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelResModifyRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "OTA_HotelResModifyNotifRQ")
    public JAXBElement<HotelResModifyRequestType> createOTAHotelResModifyNotifRQ(HotelResModifyRequestType value) {
        return new JAXBElement<HotelResModifyRequestType>(_OTAHotelResModifyNotifRQ_QNAME, HotelResModifyRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelResModifyResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "OTA_HotelResModifyNotifRS")
    public JAXBElement<HotelResModifyResponseType> createOTAHotelResModifyNotifRS(HotelResModifyResponseType value) {
        return new JAXBElement<HotelResModifyResponseType>(_OTAHotelResModifyNotifRS_QNAME, HotelResModifyResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageAcknowledgementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "OTA_NotifReportRS")
    public JAXBElement<MessageAcknowledgementType> createOTANotifReportRS(MessageAcknowledgementType value) {
        return new JAXBElement<MessageAcknowledgementType>(_OTANotifReportRS_QNAME, MessageAcknowledgementType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "Image", scope = ParagraphType.class)
    public JAXBElement<String> createParagraphTypeImage(String value) {
        return new JAXBElement<String>(_ParagraphTypeImage_QNAME, String.class, ParagraphType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "URL", scope = ParagraphType.class)
    public JAXBElement<String> createParagraphTypeURL(String value) {
        return new JAXBElement<String>(_ParagraphTypeURL_QNAME, String.class, ParagraphType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormattedTextTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "Text", scope = ParagraphType.class)
    public JAXBElement<FormattedTextTextType> createParagraphTypeText(FormattedTextTextType value) {
        return new JAXBElement<FormattedTextTextType>(_ParagraphTypeText_QNAME, FormattedTextTextType.class, ParagraphType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParagraphType.ListItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "ListItem", scope = ParagraphType.class)
    public JAXBElement<ParagraphType.ListItem> createParagraphTypeListItem(ParagraphType.ListItem value) {
        return new JAXBElement<ParagraphType.ListItem>(_ParagraphTypeListItem_QNAME, ParagraphType.ListItem.class, ParagraphType.class, value);
    }

}
