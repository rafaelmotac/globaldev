package org.globaldev.services;

import org.globaldev.dtos.TransactionDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface GlobalTransactionService {
    Optional<List<TransactionDTO>> getTransactionsByType(String type) throws IOException;

    Integer getTotalAmountByTransactionType(String type) throws IOException;

    List<TransactionDTO> getTransactions() throws IOException;

}
