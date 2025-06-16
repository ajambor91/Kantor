package net.bitstechworld.users.DTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.bitstechworld.users.Serializers.PasswordDeserializer;

public record UserLoginRequest(String name, @JsonDeserialize(using = PasswordDeserializer.class) char[] rawPassword) {
}
