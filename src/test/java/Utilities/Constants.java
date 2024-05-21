package Utilities;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static String baseURL = "https://gorest.co.in/public/v2";

    public static String userEndPoint ="/comments" ;

    public static Map<String,String> generalHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer de5b54c471aada6a031b379b065b55acd7ce63b9b5a9514e2528a271e96c4c7c");
        return headers;
    }
}
