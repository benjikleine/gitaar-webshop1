package com.example.Gitaar.Webshop.security.oauth2;

import java.util.Map;

public abstract class OAuth2userInfo {

    protected Map<String, Object> attributes;

    public OAuth2userInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();

    public abstract String getFirstName();

    public abstract String getLastName();

    public abstract String getEmail();
}
