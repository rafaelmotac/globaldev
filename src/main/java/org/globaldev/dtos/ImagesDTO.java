package org.globaldev.dtos;

public class ImagesDTO {
    private String id;
    private String label;
    private String URL;
    private String date;
    private OpenBankUserDTO user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OpenBankUserDTO getUser() {
        return user;
    }

    public void setUser(OpenBankUserDTO user) {
        this.user = user;
    }
}
