import java.lang.annotation.ElementType;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbConfig;
import javax.json.bind.JsonbException;
import javax.json.bind.spi.JsonbProvider;

import org.junit.Assert;
import org.junit.Test;

import test.LocaleJsonbDeserializer;
import test.LocaleJsonbSerializer;

public class JsonbDeserializingTest {

    private Jsonb getJsonBWithLocalSerialization() {
        JsonbConfig config = new JsonbConfig().withSerializers(new LocaleJsonbSerializer())
                .withDeserializers(new LocaleJsonbDeserializer());
        return JsonbProvider.provider().create().withConfig(config).build();
    }

    @Test
    public void testSerializationOfDifferentMapTypes() throws Exception {
        TestObject to = new TestObject();
        to.setBooleanKeyMap(Collections.singletonMap(Boolean.TRUE, "booleanKey"));
        to.setIntegerKeyMap(Collections.singletonMap(Integer.MAX_VALUE, "integerKey"));
        to.setStringKeyMap(Collections.singletonMap("anything", "stringKey"));
        to.setEnumKeyMap(Collections.singletonMap(ElementType.ANNOTATION_TYPE, "enumKey"));
        to.setPojoKeyMap(Collections.singletonMap(new Pojo("test", true, 5), "pojoKey"));
        Jsonb jsonb = JsonbProvider.provider().create().build();
        String json = jsonb.toJson(to);
        System.out.println(json);

        TestObject to2 = jsonb.fromJson(json, TestObject.class);
        Class<?> boolClass = printKeyClass(to2.getBooleanKeyMap());
        Class<?> integerClass = printKeyClass(to2.getIntegerKeyMap());
        Class<?> stringClass = printKeyClass(to2.getStringKeyMap());
        Class<?> enumClass = printKeyClass(to2.getEnumKeyMap());
        Class<?> pojoClass = printKeyClass(to2.getPojoKeyMap());

        Assert.assertEquals(String.class, stringClass);
        Assert.assertEquals(Pojo.class, pojoClass);

        Assert.assertEquals(Boolean.class, boolClass);
        Assert.assertEquals(Integer.class, integerClass);
        Assert.assertEquals(ElementType.class, enumClass);

    }

    /**
     * cannot work (no deserializer for Locale)
     * 
     * @throws Exception
     */
    @Test(expected = JsonbException.class)
    public void testSerializationOfLocalMap() throws Exception {
        TestObject to = new TestObject();
        to.setLocaleKeyMap(Collections.singletonMap(Locale.GERMAN, "localeKey"));

        Jsonb jsonb = JsonbProvider.provider().create().build();
        String json = jsonb.toJson(to);
        System.out.println(json);

        TestObject to2 = jsonb.fromJson(json, TestObject.class);
        Class<?> localeClass = printKeyClass(to2.getLocaleKeyMap());

        Assert.assertEquals(Locale.class, localeClass);

    }

    @Test
    public void testSerializationOfLocalMapWithCustomSerialization() throws Exception {
        TestObject to = new TestObject();
        to.setLocaleKeyMap(Collections.singletonMap(Locale.GERMAN, "localeKey"));

        Jsonb jsonb = getJsonBWithLocalSerialization();
        String json = jsonb.toJson(to);
        System.out.println(json);

        TestObject to2 = jsonb.fromJson(json, TestObject.class);
        Class<?> localeClass = printKeyClass(to2.getLocaleKeyMap());

        Assert.assertEquals(Locale.class, localeClass);

    }

    /**
     * cannot work (no deserializer for Locale)
     * 
     * @throws Exception
     */
    @Test(expected = JsonbException.class)
    public void testSerializationOfLocalAttribute() throws Exception {
        TestObject to = new TestObject();
        to.setLocaleAttribute(Locale.GERMAN);

        Jsonb jsonb = JsonbProvider.provider().create().build();
        String json = jsonb.toJson(to);
        System.out.println(json);

        TestObject to2 = jsonb.fromJson(json, TestObject.class);

    }

    /**
     * simple (de-)serialization of Locale works
     * 
     * @throws Exception
     */
    @Test
    public void testSerializationOfLocalAttributeWithCustomSerialization() throws Exception {
        TestObject to = new TestObject();
        to.setLocaleAttribute(Locale.GERMAN);

        Jsonb jsonb = getJsonBWithLocalSerialization();
        String json = jsonb.toJson(to);
        System.out.println(json);

        TestObject to2 = jsonb.fromJson(json, TestObject.class);

    }

    private Class<?> printKeyClass(Map<?, String> map) {
        Entry<?, String> e = map.entrySet().iterator().next();
        Class<? extends Object> class1 = e.getKey().getClass();
        System.out.println(e.getValue() + " has key class: " + class1);
        return class1;
    }

}
