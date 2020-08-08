package org.globaldev.dtos;

public class WhereDTO {

    private Float latitude;
    private Float longitude;
    private String date;
    private OpenBankUserDTO user;

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
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
