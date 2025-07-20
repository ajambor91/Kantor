package net.bitstechworld.users.Application.DTO;

import java.time.LocalDateTime;

public record UserRegisteredRecord(long id, String email, LocalDateTime createdAt) {
}
