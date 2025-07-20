package net.bitstechworld.users.Infrastructure.DTO;

import java.time.LocalDateTime;

public record RegisterResponse(Long id, String email, LocalDateTime createdAt) {
}
