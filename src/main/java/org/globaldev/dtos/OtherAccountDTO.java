package org.globaldev.dtos;

public class OtherAccountDTO {

    private String id;
    private HolderDTO holder;
    private String number;
    private String kind;
    private String IBAN;
    private String swift_bic;
    private BankDTO bank;
    private OtherAccountMetadataDTO metadata;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HolderDTO getHolder() {
        return holder;
    }

    public void setHolder(HolderDTO holder) {
        this.holder = holder;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getSwift_bic() {
        return swift_bic;
    }

    public void setSwift_bic(String swift_bic) {
        this.swift_bic = swift_bic;
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    public OtherAccountMetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(OtherAccountMetadataDTO metadata) {
        this.metadata = metadata;
    }
}