package com.iugu.services;


import com.iugu.Iugu;
import com.iugu.exceptions.IuguException;
import com.iugu.model.PaymentMethod;
import com.iugu.responses.PaymentMethodResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import java.util.List;

import static com.iugu.utils.ResponseUtils.handleResponse;

public class PaymentMethodService {
    private final static String URL = Iugu.url("/customers/%s/payment_methods/%s");

    public String getUrlWithIds(String ...ids) {
        return String.format(URL, ids);
    }

    public PaymentMethodResponse create(String customerId, PaymentMethod paymentMethod) throws IuguException {
         return handleResponse(
                Iugu.getClient()
                        .target(getUrlWithIds(customerId, ""))
                        .request()
                        .post(Entity.entity(paymentMethod, "application/json")),
                "Error creating payment method",
                PaymentMethodResponse.class
        );
    }

    public PaymentMethodResponse update(String customerId, String paymentMethodId, PaymentMethod paymentMethod) throws IuguException {
        return handleResponse(
                Iugu.getClient()
                        .target(getUrlWithIds(customerId, paymentMethodId))
                        .request()
                        .put(Entity.entity(paymentMethod, "application/json")),
                "Error updating payment method",
                PaymentMethodResponse.class
        );
    }

    public PaymentMethodResponse find(String customerId, String paymentMethodId) throws IuguException {
        return handleResponse(
                Iugu.getClient()
                        .target(getUrlWithIds(customerId, paymentMethodId))
                        .request()
                        .get(),
                "Error finding payment method",
                PaymentMethodResponse.class
        );
    }

    public List<PaymentMethodResponse> find(String customerId) throws IuguException {
        GenericType<List<PaymentMethodResponse>> list = new GenericType<List<PaymentMethodResponse>>(){};
        return Iugu.getClient()
            .target(getUrlWithIds(customerId, ""))
            .request()
            .get(list);

    }
}
