package net.bitstechworld.users.Application.Services;


import net.bitstechworld.users.Application.DTO.UserRecord;
import net.bitstechworld.users.Application.DTO.UserRegisteredRecord;
import net.bitstechworld.users.Application.Ports.PasswordEncoderPort;
import net.bitstechworld.users.Application.Ports.RegisterUserUseCase;
import net.bitstechworld.users.Application.Ports.UserRepositoryPort;
import net.bitstechworld.users.Domain.User;
import net.bitstechworld.users.TestUtils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static net.bitstechworld.users.TestUtils.UserUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@Tag("unit")
@ExtendWith(MockitoExtension.class)
public class RegisterUserUseCaseImplTest {

    private RegisterUserUseCase registerUserUseCase;
    @Mock
    private PasswordEncoderPort passwordEncoderPortMock;
    @Mock
    private UserRepositoryPort userRepositoryPortMock;
    @BeforeEach
    public void setuo() {

        this.registerUserUseCase = new RegisterUserUseCaseImpl(this.passwordEncoderPortMock, this.userRepositoryPortMock);

    }

    @Test
    @DisplayName("Should register user and return")
    public void  registerUserSuccess() {
        UserRecord userRecord = UserUtils.createTestUserRecord();
        when(this.passwordEncoderPortMock.hashPassword(eq(TEST_CORRECT_PASSWORD.toCharArray()))).thenReturn(TEST_CORRECT_PASSWORD);
        when(this.userRepositoryPortMock.saveUser(any(User.class))).thenReturn(UserUtils.createTestUser());
        UserRegisteredRecord userRegisteredRecord = this.registerUserUseCase.registerUser(userRecord);
        assertEquals(TEST_USER_EMAIL, userRegisteredRecord.email());
        assertEquals(TEST_USER_ID, userRegisteredRecord.id());
        assertNotNull(userRegisteredRecord.createdAt());
        assertInstanceOf(LocalDateTime.class, userRegisteredRecord.createdAt());
    }
}
