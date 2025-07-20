package net.bitstechworld.users.Infrastructure.Serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class PasswordDeserializer extends JsonDeserializer<char[]> {

    @Override
    public char[] deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        JsonNode rawPaswwordNode = p.getCodec().readTree(p);
        return rawPaswwordNode.asText().toCharArray();
    }
}
