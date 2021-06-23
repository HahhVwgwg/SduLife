package kz.edu.sdulife.model;

public class ProfileItem {

    String value_name;
    String value;
    String type_name;
    int icon;
    int type;


    public int getType() {
        return type;
    }


    public ProfileItem(int type,String value_name, int icon) {
        this.type = type;
        this.value_name = value_name;
        this.icon = icon;
    }

    public ProfileItem(int type,String value_name, String value) {
        this.type = type;
        this.value_name = value_name;
        this.value = value;
    }

    public ProfileItem(int type,String type_name) {
        this.type = type;
        this.type_name = type_name;
    }



    public String getValue_name() {
        return value_name;
    }

    public String getValue() {
        return value;
    }

    public String getType_name() {
        return type_name;
    }

    public int getIcon() {
        return icon;
    }





}
