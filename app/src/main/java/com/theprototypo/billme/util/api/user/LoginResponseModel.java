package com.theprototypo.billme.util.api.user;

import com.theprototypo.billme.util.api.BillMeResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by walesadanto on 26/7/15.
 */
public class LoginResponseModel extends BillMeResponseModel{

    private List<LoginResponseData> data = new ArrayList<LoginResponseData>();

    public List<LoginResponseData> getData() {
        return data;
    }

    public void setData(List<LoginResponseData> data) {
        this.data = data;
    }

    public class LoginResponseData {
        private Integer userId;
        private String auth;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         *
         * @return
         * The userId
         */
        public Integer getUserId() {
            return userId;
        }

        /**
         *
         * @param userId
         * The user_id
         */
        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        /**
         *
         * @return
         * The auth
         */
        public String getAuth() {
            return auth;
        }

        /**
         *
         * @param auth
         * The auth
         */
        public void setAuth(String auth) {
            this.auth = auth;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
    }
}
