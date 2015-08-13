package com.theprototypo.billme.util.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillMeResponseModel {

    private Boolean Error;
    private String Message;
//    private List data = new ArrayList<>();
    private Integer Balance;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The Error
     */
    public Boolean getError() {
        return Error;
    }

    /**
     *
     * @param Error
     * The Error
     */
    public void setError(Boolean Error) {
        this.Error = Error;
    }

    /**
     *
     * @return
     * The Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     *
     * @param Message
     * The Message
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

//    /**
//     *
//     * @return
//     * The data
//     */
//    public List getData() {
//        return data;
//    }
//
//    /**
//     *
//     * @param data
//     * The data
//     */
//    public void setData(List data) {
//        this.data = data;
//    }

    /**
     *
     * @return
     * The Balance
     */
    public Integer getBalance() {
        return Balance;
    }

    /**
     *
     * @param Balance
     * The Balance
     */
    public void setBalance(Integer Balance) {
        this.Balance = Balance;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}