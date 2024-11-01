package com.scm.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class  Helper {

    public static String getEmailOfLoggedInUser(Authentication authentication) {

        // Get Email for Logged In User
        if (authentication instanceof OAuth2AuthenticationToken aOAuth2AuthenticationToken) {

            var clientId = aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            var oauth2User = (OAuth2User) authentication.getPrincipal();
            String username = "";

            if (clientId.equalsIgnoreCase("google")) {

                // Sign with Google
                System.out.println("Getting email from google");
                username = oauth2User.getAttribute("email").toString();

            } else if (clientId.equalsIgnoreCase("github")) {

                // Sign with Github
                System.out.println("Getting email from github");
                username = oauth2User.getAttribute("email") != null ? oauth2User.getAttribute("email").toString()
                        : oauth2User.getAttribute("login").toString() + "@gmail.com";
            }

            return username;

        } else {
            System.out.println("Getting data from local database");
            return authentication.getName();
        }

    }

    public static String getLinkForEmailVerificatiton(String emailToken) {

        return "http://localhost:8081/auth/verify-email?token=" + emailToken;

    }
}