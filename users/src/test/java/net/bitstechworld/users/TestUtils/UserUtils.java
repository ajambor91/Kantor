package net.bitstechworld.users.TestUtils;

import net.bitstechworld.users.DTO.UserLoginRequest;

public class UserUtils {
    public static String CORRECT_NAME = "LOGIN";
    public static String CORRECT_PASSWORD = "PASSWORD";

    public static UserLoginRequest createTestLoginRequest() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(CORRECT_NAME, CORRECT_PASSWORD.toCharArray());
        return userLoginRequest;
    }
}
