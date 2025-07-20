package net.bitstechworld.users.Domain;

import net.bitstechworld.users.Application.Ports.PasswordEncoderPort;

import java.time.LocalDateTime;

public class User {

    private long id;

    private String email;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private User(String email, String hashedPassword){
        this.password = hashedPassword;
        this.email = email;
    }

    private User(long id, String email, String hashedPassword, LocalDateTime createdAt) {
        this(id, email, createdAt);
        this.password = hashedPassword;

    }

    private User(long id, String email, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.createdAt = createdAt;

    }

    public static User registerUser(String email, String hashedPassword) {
        return new User(email, hashedPassword);
    }

    public static User of(long id, String email, LocalDateTime createdAt) {
        return new User(id,email, createdAt);
    }

    public static User of(long id, String email,String hashedPassword, LocalDateTime createdAt) {
        return new User(id,email, hashedPassword, createdAt);
    }

    public boolean isPasswordValid(char[] rawPassword, PasswordEncoderPort passwordEncoderPort) {
        if (passwordEncoderPort.validatePassword(rawPassword, this.password)) {
            return true;
        }
        throw new RuntimeException("Invalid Password");
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
