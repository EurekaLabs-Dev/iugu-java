package com.iugu.utils;

import com.iugu.exceptions.IuguException;

import javax.ws.rs.core.Response;


public class ResponseUtils {

    public static <T>T handleResponse(Response  response, String errorCause, Class<T> clazz) throws IuguException {
        String responseText = "Transação não autorizada";
        Integer responseStatus = response.getStatus();

        if(responseStatus == 200) {
            return response.readEntity(clazz);
         }

        if(response.hasEntity()) {
            responseText = response.readEntity(String.class);
        }

        response.close();
        throw new IuguException(errorCause, responseStatus, responseText);
    }
}
