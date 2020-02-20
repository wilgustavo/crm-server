package com.gmw.crm.security.util;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

/**
 * Decrypt a string to return the username and password
 *
 * @author Gustavo Wilgenhoff
 */
public class DecodeBasicAuth {

    public static final String BASIC_AUTH = "Basic ";
    public static final String TOKEN_SEPARATOR = ":";

    private DecodeBasicAuth() {}

    /**
     * Decrypt a token and return an array containing the username and password.
     *
     * @param token encrypted credentials. It must start with the word "Basic" and after a
     *              space must contain the user and password separated by a colon (":").
     *              The username and password must be encoded with base64.
     * @return an array where the first element contains the user and the second, the password,
     */
    public static String[] decode(String token) {
        if (!StringUtils.hasText(token) || !token.startsWith(BASIC_AUTH)) {
            throw new BadCredentialsException("Authorization header not found");
        }
        String credentials;
        try {
            credentials = new String(Base64Utils.decodeFromString(token.substring(BASIC_AUTH.length())), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        if (!credentials.contains(TOKEN_SEPARATOR)) {
            throw new BadCredentialsException("Invalid basic authentication token");
        }
        return credentials.split(TOKEN_SEPARATOR, 2);
    }

}
