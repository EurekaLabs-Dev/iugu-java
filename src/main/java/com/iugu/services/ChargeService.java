package com.iugu.services;


import com.iugu.Iugu;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Charge;
import com.iugu.responses.ChargeResponse;

import javax.ws.rs.client.Entity;

import static com.iugu.utils.ResponseUtils.handleResponse;


public class ChargeService {
    private static final String URL = Iugu.url("/charge");

    public ChargeResponse send(Charge charge) throws IuguException {
        return handleResponse(
            Iugu.getClient().target(URL).request().post(Entity.entity(charge, "application/json")),
            "Error sending charge",
            ChargeResponse.class
        );
    }



}
