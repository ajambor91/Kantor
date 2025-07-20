package net.bitstechworld.users.Infrastructure.DTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.bitstechworld.users.Infrastructure.Serializers.PasswordDeserializer;

public record LoginRequest(String email, @JsonDeserialize(using = PasswordDeserializer.class) char[] rawPassword) {
}
