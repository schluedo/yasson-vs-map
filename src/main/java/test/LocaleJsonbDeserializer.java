package test;

import java.lang.reflect.Type;
import java.util.Locale;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

public class LocaleJsonbDeserializer implements JsonbDeserializer<Locale> {

    public Locale deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        return Locale.forLanguageTag(parser.getString());
    }

}
