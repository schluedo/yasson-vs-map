
public class Pojo {

    private String stringAttribute;

    private Boolean booleanAttribute;
    private Integer integerAttribute;

    public Pojo() {
        super();
    }
    public Pojo(String stringAttribute, Boolean booleanAttribute, Integer integerAttribute) {
        super();
        this.stringAttribute = stringAttribute;
        this.booleanAttribute = booleanAttribute;
        this.integerAttribute = integerAttribute;
    }
    public String getStringAttribute() {
        return stringAttribute;
    }
    public void setStringAttribute(String stringAttribute) {
        this.stringAttribute = stringAttribute;
    }
    public Boolean getBooleanAttribute() {
        return booleanAttribute;
    }
    public void setBooleanAttribute(Boolean booleanAttribute) {
        this.booleanAttribute = booleanAttribute;
    }
    public Integer getIntegerAttribute() {
        return integerAttribute;
    }
    public void setIntegerAttribute(Integer integerAttribute) {
        this.integerAttribute = integerAttribute;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pojo [stringAttribute=").append(stringAttribute)
                .append(", booleanAttribute=").append(booleanAttribute)
                .append(", integerAttribute=").append(integerAttribute).append("]");
        return builder.toString();
    }

}
