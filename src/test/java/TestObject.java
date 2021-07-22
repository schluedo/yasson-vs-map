import java.lang.annotation.ElementType;
import java.util.Locale;
import java.util.Map;

public class TestObject {

    private Map<String, String> stringKeyMap;
    private Map<Integer, String> integerKeyMap;
    private Map<Boolean, String> booleanKeyMap;
    private Map<ElementType, String> enumKeyMap;
    private Map<Pojo, String> pojoKeyMap;
    private Map<Locale, String> localeKeyMap;
    private Map<String, Map<Locale, String>> localeKeyMapInStringMap;
    private Locale localeAttribute;

    public TestObject() {
        super();
    }
    public Map<String, String> getStringKeyMap() {
        return stringKeyMap;
    }
    public void setStringKeyMap(Map<String, String> stringKeyMap) {
        this.stringKeyMap = stringKeyMap;
    }
    public Map<Integer, String> getIntegerKeyMap() {
        return integerKeyMap;
    }
    public void setIntegerKeyMap(Map<Integer, String> integerKeyMap) {
        this.integerKeyMap = integerKeyMap;
    }
    public Map<Boolean, String> getBooleanKeyMap() {
        return booleanKeyMap;
    }
    public void setBooleanKeyMap(Map<Boolean, String> booleanKeyMap) {
        this.booleanKeyMap = booleanKeyMap;
    }
    public Map<Locale, String> getLocaleKeyMap() {
        return localeKeyMap;
    }
    public void setLocaleKeyMap(Map<Locale, String> localeKeyMap) {
        this.localeKeyMap = localeKeyMap;
    }
    public Map<ElementType, String> getEnumKeyMap() {
        return enumKeyMap;
    }
    public void setEnumKeyMap(Map<ElementType, String> enumKeyMap) {
        this.enumKeyMap = enumKeyMap;
    }
    public Map<Pojo, String> getPojoKeyMap() {
        return pojoKeyMap;
    }
    public void setPojoKeyMap(Map<Pojo, String> pojoKeyMap) {
        this.pojoKeyMap = pojoKeyMap;
    }
    public Locale getLocaleAttribute() {
        return localeAttribute;
    }
    public void setLocaleAttribute(Locale localeAttribute) {
        this.localeAttribute = localeAttribute;
    }
    public Map<String, Map<Locale, String>> getLocaleKeyMapInStringMap() {
        return localeKeyMapInStringMap;
    }
    public void setLocaleKeyMapInStringMap(
            Map<String, Map<Locale, String>> localeKeyMapInStringMap) {
        this.localeKeyMapInStringMap = localeKeyMapInStringMap;
    }

}
