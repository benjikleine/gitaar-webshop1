package com.example.Gitaar.Webshop.security.oauth2;

import java.util.Map;

public class GithubOAuth2userInfo extends OAuth2userInfo {

    public GithubOAuth2userInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return ((Integer) attributes.get("id")).toString();
    }

    @Override
    public String getFirstName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getLastName() {
        return "";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }
}
