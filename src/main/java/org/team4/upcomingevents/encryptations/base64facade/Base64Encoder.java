package org.team4.upcomingevents.encryptations.base64facade;

import java.util.Base64;

import org.team4.upcomingevents.encryptations.IEncoder;

public class Base64Encoder implements IEncoder {

    @Override
    public String encode(String data) {
        String dataEncoded = Base64.getEncoder().encodeToString(data.getBytes());
        return dataEncoded;
    }

    public String decode(String data) {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        String dataDecoded = new String(decodedBytes);
        return dataDecoded;
    }
    
}
