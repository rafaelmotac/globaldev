package org.globaldev.services.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.globaldev.dtos.TransactionDTO;
import org.globaldev.dtos.TransactionResponseDTO;
import org.globaldev.services.GlobalTransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GlobalTransactionServiceImpl implements GlobalTransactionService {

    private static final String transactionsUrl = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";

    public List<TransactionDTO> getTransactions() throws IOException {
        return recoverTransactionFromGet();
    }

    public Optional<List<TransactionDTO>> getTransactionsByType(String type) throws IOException {
        List<TransactionDTO> transactions = recoverTransactionFromGet()
                .stream()
                .filter(transaction ->
                        transaction.getDetails().getType().equalsIgnoreCase(type)
                ).collect(Collectors.toList());

        return Optional.ofNullable(transactions);
    }

    public Integer getTotalAmountByTransactionType(String type) throws IOException {
        Optional<List<TransactionDTO>> transactions = this.getTransactionsByType(type);
        Integer amount = transactions.isPresent() ? transactions.get().size() : 0;

        return amount;
    }

    private List<TransactionDTO> recoverTransactionFromGet() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(transactionsUrl);
        HttpResponse httpresponse = httpclient.execute(httpget);

        String json = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

        Gson gson = new Gson();
        Type typeGson = new TypeToken<TransactionResponseDTO>() {
        }.getType();
        TransactionResponseDTO transactionResponseDTO = gson.fromJson(json, typeGson);

        return transactionResponseDTO.getTransactions();
    }
}
