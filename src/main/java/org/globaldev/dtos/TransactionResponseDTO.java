package org.globaldev.dtos;

import java.util.List;

public class TransactionResponseDTO {
    public List<TransactionDTO> transactions;

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
