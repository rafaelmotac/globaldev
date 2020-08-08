package org.globaldev.dtos;

public class TagDTO {

    private String id;
    private String date;
    private String value;
    private OpenBankUserDTO user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OpenBankUserDTO getUser() {
        return user;
    }

    public void setUser(OpenBankUserDTO user) {
        this.user = user;
    }
}
