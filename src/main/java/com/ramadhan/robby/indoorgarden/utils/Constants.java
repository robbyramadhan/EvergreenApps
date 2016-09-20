package com.ramadhan.robby.indoorgarden.utils;

import com.ramadhan.robby.indoorgarden.BuildConfig;

public class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where user lists are stored (ie "userLists")
     */

    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_LOCATION_USER_LISTS = "userLists";
    public static final String FIREBASE_LOCATION_USER_FRIENDS = "userFriends";
    public static final String FIREBASE_LOCATION_LISTS_SHARED_WITH = "sharedWith";
    public static final String FIREBASE_LOCATION_UID_MAPPINGS = "uidMappings";
    public static final String FIREBASE_LOCATION_OWNER_MAPPINGS = "ownerMappings";
    public static final String FIREBASE_LOCATION_ACTIVE_MODULES = "activeModules";
    public static final String FIREBASE_LOCATION_MODULES_CODE = "modulesCode";
    public static final String FIREBASE_LOCATION_AIR_TEMPERATURE = "airTemperature";
    public static final String FIREBASE_LOCATION_LIQUID_TEMPERATURE = "LiquidTemperature";
    public static final String FIREBASE_LOCATION_HUMIDITY = "humidity";
    public static final String FIREBASE_LOCATION_EC = "EC";
    public static final String FIREBASE_LOCATION_LIGHT_INTENSITY = "lightIntensity";
    public static final String FIREBASE_LOCATION_PH = "pH";
    public static final String FIREBASE_LOCATION_PLANT_NAME = "plantName";
    public static final String FIREBASE_LOCATION_PLANT_DATE = "plantDate";





    /**
     * Constants for Firebase object properties
     */
    public static final String FIREBASE_PROPERTY_LIST_NAME = "listName";
    public static final String FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED = "timestampLastChanged";
    public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";
    public static final String FIREBASE_PROPERTY_ITEM_NAME = "itemName";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String FIREBASE_PROPERTY_USER_HAS_LOGGED_IN_WITH_PASSWORD = "hasLoggedInWithPassword";
    public static final String FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED_REVERSE = "timestampLastChangedReverse";


    /**
     * Constants for Firebase URL
     */
    public static final String FIREBASE_URL = BuildConfig.UNIQUE_FIREBASE_ROOT_URL;
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
    public static final String FIREBASE_URL_USER_LISTS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USER_LISTS;
    public static final String FIREBASE_URL_USER_FRIENDS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USER_FRIENDS;
    public static final String FIREBASE_URL_LISTS_SHARED_WITH = FIREBASE_URL + "/" + FIREBASE_LOCATION_LISTS_SHARED_WITH;
    public static final String FIREBASE_URL_ACTIVE_LISTS = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES;
    public static final String FIREBASE_URL_ACTIVE_MODULES = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES + "/" + FIREBASE_LOCATION_MODULES_CODE;
    public static final String FIREBASE_URL_ACTIVE_PH = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES + "/" +
            FIREBASE_LOCATION_MODULES_CODE + "/" + FIREBASE_LOCATION_PH;
    public static final String FIREBASE_URL_ACTIVE_EC = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES + "/" +
            FIREBASE_LOCATION_MODULES_CODE + "/" + FIREBASE_LOCATION_EC;
    public static final String FIREBASE_URL_ACTIVE_HUMIDITY = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES + "/" +
            FIREBASE_LOCATION_MODULES_CODE + "/" + FIREBASE_LOCATION_HUMIDITY;
    public static final String FIREBASE_URL_ACTIVE_LIGHT_INTENSITY = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES + "/" +
            FIREBASE_LOCATION_MODULES_CODE + "/" + FIREBASE_LOCATION_LIGHT_INTENSITY;
    public static final String FIREBASE_URL_ACTIVE_AIR_TEMPERATURE = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES + "/" +
            FIREBASE_LOCATION_MODULES_CODE + "/" + FIREBASE_LOCATION_AIR_TEMPERATURE;
    public static final String FIREBASE_URL_ACTIVE_LIQUID_TEMPERATURE = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES + "/" +
            FIREBASE_LOCATION_MODULES_CODE + "/" + FIREBASE_LOCATION_LIQUID_TEMPERATURE;
    public static final String FIREBASE_URL_ACTIVE_PLANT_NAME = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_MODULES + "/" +
            FIREBASE_LOCATION_MODULES_CODE + "/" + FIREBASE_LOCATION_PLANT_NAME;
    /**
     * Constants for bundles, extras and shared preferences keys
     */
    public static final String KEY_LIST_NAME = "LIST_NAME";
    public static final String KEY_LAYOUT_RESOURCE = "LAYOUT_RESOURCE";
    public static final String KEY_LIST_ID = "LIST_ID";
    public static final String KEY_SIGNUP_EMAIL = "SIGNUP_EMAIL";
    public static final String KEY_LIST_ITEM_NAME = "ITEM_NAME";
    public static final String KEY_LIST_ITEM_ID = "LIST_ITEM_ID";
    public static final String KEY_PROVIDER = "PROVIDER";
    public static final String KEY_ENCODED_EMAIL = "ENCODED_EMAIL";
    public static final String KEY_LIST_OWNER = "LIST_OWNER";
    public static final String KEY_GOOGLE_EMAIL = "GOOGLE_EMAIL";
    public static final String KEY_PREF_SORT_ORDER_LISTS = "PERF_SORT_ORDER_LISTS";
    public static final String KEY_SHARED_WITH_USERS = "SHARED_WITH_USERS";


    /**
     * Constants for Firebase login
     */
    public static final String PASSWORD_PROVIDER = "password";
    public static final String GOOGLE_PROVIDER = "google";
    public static final String PROVIDER_DATA_DISPLAY_NAME = "displayName";


    /**
     * Constant for sorting
     */
    public static final String ORDER_BY_KEY = "orderByPushKey";
    public static final String ORDER_BY_OWNER_EMAIL = "orderByOwnerEmail";



}
