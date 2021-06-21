package kz.edu.sdulife.model;

public class ProfileItem {
    public ProfileItem(String value_name, String value) {
        this.value_name = value_name;
        this.value = value;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value_name,value;
}
