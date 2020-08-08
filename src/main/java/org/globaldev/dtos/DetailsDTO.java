package org.globaldev.dtos;

public class DetailsDTO {
    private String type;
    private String description;
    private String posted;
    private String completed;
    private NewBalanceDTO new_balance;
    private ValueDTO value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public NewBalanceDTO getNew_balance() {
        return new_balance;
    }

    public void setNew_balance(NewBalanceDTO new_balance) {
        this.new_balance = new_balance;
    }

    public ValueDTO getValue() {
        return value;
    }

    public void setValue(ValueDTO value) {
        this.value = value;
    }
}
