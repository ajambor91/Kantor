package net.bitstechworld.users.Application.DTO;

import java.time.LocalDateTime;

public record UserLoginRecord(long id, String email, String jwt, LocalDateTime createdAt) {
}
