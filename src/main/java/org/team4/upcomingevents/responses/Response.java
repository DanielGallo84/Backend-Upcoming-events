package org.team4.upcomingevents.responses;

import java.util.HashMap;

public class Response {
    
    private static HashMap<String,String> response = new HashMap<>();

    public static HashMap<String,String> getResponse(String message) {
        response.put("message", message);
        return response;
    }


}
