package net.bitstechworld.users;

import net.bitstechworld.users.Application.Ports.*;
import net.bitstechworld.users.Application.Services.LoginUserUseCaseImpl;
import net.bitstechworld.users.Application.Services.RegisterUserUseCaseImpl;
import net.bitstechworld.users.Infrastructure.Adapters.UsersRepositoryAdapter;
import net.bitstechworld.users.Infrastructure.Encoders.PasswordEncoder;
import net.bitstechworld.users.Infrastructure.Repositories.UserRepository;
import net.bitstechworld.users.Infrastructure.Security.JWTService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Bean
	public PasswordEncoderPort passwordEncoderPort(@Value("${password.pepper}") String passwordPepper) {
		return new PasswordEncoder(new BCryptPasswordEncoder(), passwordPepper);
	}

	@Bean
	public UserRepositoryPort userRepositoryPort(UserRepository userRepository) {
		return new UsersRepositoryAdapter(userRepository);
	}

	@Bean
	public RegisterUserUseCase registerUserUseCase(PasswordEncoderPort passwordEncoderPort, UserRepositoryPort userRepositoryPort) {
		return new RegisterUserUseCaseImpl(passwordEncoderPort, userRepositoryPort);
	}

	@Bean
	public LoginUserUseCase loginUserUseCase(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort, JWTService jwtService ) {
		return new LoginUserUseCaseImpl(userRepositoryPort, passwordEncoderPort, jwtService);
	}

}
