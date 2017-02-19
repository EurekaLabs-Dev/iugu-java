package com.iugu.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Charge implements Serializable {
    private String email;
    private List<ChargeItem> items = new ArrayList<>();
    @JsonProperty("customer_payment_method_id")
    private String customerPaymentMethodId;
//    private String token;
    private String customerId;

    public Charge(String customerId, String customerPaymentMethodId) {
        this.customerPaymentMethodId = customerPaymentMethodId;
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public Charge addItem(ChargeItem chargeItem) {
        this.items.add(chargeItem);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ChargeItem> getItems() {
        return items;
    }

    public void setItems(List<ChargeItem> items) {
        this.items = items;
    }

    public String getCustomerPaymentMethodId() {
        return customerPaymentMethodId;
    }

    public void setCustomerPaymentMethodId(String customerPaymentMethodId) {
        this.customerPaymentMethodId = customerPaymentMethodId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
}
