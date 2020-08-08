package org.globaldev.dtos;

import java.util.List;

public class ThisAccountDTO {

    private String id;
    private List<HolderDTO> holders;
    private String number;
    private String kind;
    private String IBAN;
    private String swift_bic;
    private BankDTO bank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<HolderDTO> getHolders() {
        return holders;
    }

    public void setHolders(List<HolderDTO> holders) {
        this.holders = holders;
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
}