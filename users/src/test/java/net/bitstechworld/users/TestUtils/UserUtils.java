package net.bitstechworld.users.TestUtils;

import net.bitstechworld.users.Application.DTO.UserRecord;
import net.bitstechworld.users.Domain.User;

import java.time.LocalDateTime;

public class UserUtils {
    public static long TEST_USER_ID = 1;
    public static String TEST_USER_EMAIL = "test@test.example";
    public static String TEST_CORRECT_NAME = "LOGIN";
    public static String TEST_CORRECT_PASSWORD = "PASSWORD";


    public static UserRecord createTestUserRecord() {
        return new UserRecord(TEST_USER_EMAIL, TEST_CORRECT_PASSWORD.toCharArray());
    }

    public static User createTestUser() {
        return User.of(TEST_USER_ID, TEST_USER_EMAIL, LocalDateTime.now());
    }
}
