package net.bitstechworld.users.Services;

import net.bitstechworld.users.DTO.UserLoginRequest;
import net.bitstechworld.users.TestUtils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit")
@Tag("unit")
public class AuthServiceUnitTest {

    private AuthService authService;
    @BeforeEach
    public void setup() {
        this.authService = new AuthService();
    }

    @Test
    @DisplayName("Should auth user")
    public void testAuthUser() {
        UserLoginRequest userLoginRequest = UserUtils.createTestLoginRequest();
        boolean isAuth = this.authService.authUser(userLoginRequest);
        assertTrue(isAuth);
    }

    @Test
    @DisplayName("Shouldn't auth user")
    public void testAuthUserUserNull() {

        NoSuchElementException noSuchElementException = assertThrows(NoSuchElementException.class, () -> {
            this.authService.authUser(null);
        });
        
        assertInstanceOf(NoSuchElementException.class, noSuchElementException);
        assertEquals("User DTO cannot be null!!", noSuchElementException.getMessage());
    }
}
