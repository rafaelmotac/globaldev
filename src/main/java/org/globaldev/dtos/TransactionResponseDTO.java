package org.globaldev.dtos;

import java.util.List;

public class TransactionResponseDTO {
    public List<TransactionDTO> transactions;

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }
}
