package org.globaldev.dtos;

public class TransactionDTO {

    private String id;
    private ThisAccountDTO this_account;
    private OtherAccountDTO other_account;
    private DetailsDTO details;
    private MetadataDTO metadata;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ThisAccountDTO getThis_account() {
        return this_account;
    }

    public void setThis_account(ThisAccountDTO this_account) {
        this.this_account = this_account;
    }

    public OtherAccountDTO getOther_account() {
        return other_account;
    }

    public void setOther_account(OtherAccountDTO other_account) {
        this.other_account = other_account;
    }

    public DetailsDTO getDetails() {
        return details;
    }

    public void setDetails(DetailsDTO details) {
        this.details = details;
    }

    public MetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDTO metadata) {
        this.metadata = metadata;
    }
}
