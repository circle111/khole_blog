package com.circle.service;

public interface TokenLogniService {
    String createToken(String openid);

    boolean checkToken(String token);

    String getOpenId(String token);

    void deleteToken(String token);
}
