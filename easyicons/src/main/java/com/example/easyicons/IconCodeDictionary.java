package com.example.easyicons;

import java.util.HashMap;

public class IconCodeDictionary {

    private static final HashMap<String, String> iconRecordMap = new HashMap<String, String>(){{
        put("001", "ic_launcher_background");
        put("002", "ic_launcher_foreground");
    }};

    public static HashMap<String, String> getIconRecords(){
        return  iconRecordMap;
    }
}
