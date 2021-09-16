package com.unsa.tourism.constants;

public class TourismConstants {
	public static final String API_VERSION = "v1";
    // ERRORS
    public static final String PREFIX_SERVER_ERROR = "SRV";
    public static final String PREFIX_CLIENT_ERROR = "CLI";

    // CLIENT ERRORS
    public static final String BAD_REQUEST = "001";
    public static final String UNAUTHORIZED = "002";
    public static final String FORBIDDEN = "003";
    public static final String NOT_FOUND = "004";
    public static final String METHOD_NOT_ALLOWED = "005";
    public static final String NOT_ACCEPTABLE = "006";
    public static final String CONFLICT = "009";

    // SERVER ERRORS
    public static final String INTERNAL_SERVER_ERROR = "001";
    public static final String NOT_IMPLEMENTED = "002";
    public static final String BAD_GATEWAY = "003";
    public static final String SERVICE_UNAVAILABLE = "004";
    public static final String GATEWAY_TIMEOUT = "005";
    public static final String NOT_VALIDATED = "006";
    
	//global path
    public static final String RESOURCE_PAGE = "/page";
    
	//T_USER path
    public static final String RESOURCE_USERS = "/users";
    public static final String RESOURCE_USERS_USER = "/user";
    
	//T_COMPANY_TYPE path
    public static final String RESOURCE_COMPANY_TYPES = "/company-types";
    public static final String RESOURCE_COMPANY_TYPES_COMPANY_TYPE = "/company-type";
    
    //T_PREFERENCE_QUESTION
    public static final String RESOURCE_PREFERENCE_QUESTIONS = "/preference-questions";
    public static final String RESOURCE_PREFERENCE_QUESTIONS_PREFERENCE_QUESTION = "/preference-question";
    
    //T_PREFERENCE_QUESTION
    public static final String RESOURCE_PRODUCTS = "/products";
    public static final String RESOURCE_PRODUCTS_RESOURCE_PRODUCT = "/product";

  //T_COMPANY_TYPE path
    public static final String RESOURCE_TOURIST_SPOTS = "/tourist-spots";
    public static final String RESOURCE_TOURIST_SPOTS_TOURIST_SPOT = "/tourist-spot";
    
    public static final String RESOURCE_TOURIST_SPOTS_TABS = "/tourist-spots-tabs";
    public static final String RESOURCE_TOURIST_SPOTS_TABS_SPOT_TAB = "/spot-tab";
    public static final String RESOURCE_TOURIST_SPOTS_TABS_SPOT = "/spot";
    public static final String RESOURCE_TOURIST_SPOTS_TABS_TAB = "/tab";
    
    public static final String RESOURCE_FILES = "/file-storage";
    public static final String RESOURCE_FILES_FILE = "/file";
    public static final String RESOURCE_FILES_TOURISTSPOT = "/touristSpot";
    public static final String RESOURCE_FILES_TOURISTSPOTTOURISTTAB = "/touristSpotTouristTab";
    public static final String FILE_STORAGE_PATH = "D:/PROYECTOS/AQPTOURISM/be-tourism/target/classes/static/pdrt2/";
    public static final int FILE_STORAGE_SIZE_LIMIT = 10485760 ;
    
    public static final String RESOURCE_TOURIST_SPOTS_PREFERENCE_QUESTIONS = "/tourist-spot-preference-questions";
    public static final String RESOURCE_TOURIST_SPOTS_PREFERENCE_QUESTIONS_PREFERENCE_QUESTION = "/tourist-spot-preference-question";
    public static final String RESOURCE_TOURIST_SPOTS_PREFERENCE_QUESTIONS_TOURIST_SPOT = "/tourist-spot-preference-question";
    
    public static final String RESOURCE_TOURIST_SPOTS_PREFERENCES = "/tourist-spot-preferences";
    public static final String RESOURCE_TOURIST_SPOTS_PREFERENCES_PREFERENCE = "/tourist-spot-preference";
    
    public static final String RESOURCE_TABS = "/tabs";
    public static final String RESOURCE_TABS_TAB = "/tab";
    
    public static final String NOT_SHOULD_BE = "This field shouldn't be";
    public static final String MESSAGE_NOT_BLANK = NOT_SHOULD_BE + " blank";
    public static final String MESSAGE_NOT_EMPTY = NOT_SHOULD_BE + " empty";
    public static final String MESSAGE_NOT_NULL = NOT_SHOULD_BE + " null";
    
    public static final Integer RESORCE_ENABLE = 1;
    public static final Integer RESORCE_DISABLE = 0;
}
