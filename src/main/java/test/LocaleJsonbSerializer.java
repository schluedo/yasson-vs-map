package test;

import java.util.Locale;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class LocaleJsonbSerializer implements JsonbSerializer<Locale> {

    public void serialize(Locale obj, JsonGenerator generator, SerializationContext ctx) {
        generator.write(obj.toLanguageTag());
    }

}
