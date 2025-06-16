package net.bitstechworld.users.Controllers;


import net.bitstechworld.users.DTO.UserLoginRequest;
import net.bitstechworld.users.Services.AuthService;
import net.bitstechworld.users.TestUtils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ActiveProfiles("unit")
@Tag("unit")
@ExtendWith(MockitoExtension.class)
public class AuthControllerUnitTest {

    private AuthController authController;
    private AuthService authServiceMock;

    @BeforeEach
    public void setup() {
        this.authServiceMock = mock(AuthService.class);
        this.authController = new AuthController(this.authServiceMock);
    }

    @Test
    @DisplayName("Should auth user")
    public void testAuthUser(){
        UserLoginRequest userLoginRequest = UserUtils.createTestLoginRequest();
        when(this.authServiceMock.authUser(userLoginRequest)).thenReturn(true);
        ResponseEntity<?> authResponse = this.authController.authUser(userLoginRequest);
        verify(this.authServiceMock, times(1)).authUser(any(UserLoginRequest.class));
        assertEquals(HttpStatus.OK, authResponse.getStatusCode());
    }
}
