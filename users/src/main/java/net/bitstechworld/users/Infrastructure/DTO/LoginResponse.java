package net.bitstechworld.users.Infrastructure.DTO;

import java.time.LocalDateTime;

public record LoginResponse(Long id, String email,String jwt, LocalDateTime createdAt) {
}
