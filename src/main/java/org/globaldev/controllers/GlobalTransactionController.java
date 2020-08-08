package org.globaldev.controllers;

import org.globaldev.dtos.TransactionDTO;
import org.globaldev.mappers.TransactionMapper;
import org.globaldev.models.TransactionModel;
import org.globaldev.services.GlobalTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/transactions")
public class GlobalTransactionController {

    private GlobalTransactionService globalTransactionService;
    private TransactionMapper transactionMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalTransactionController.class);

    @Autowired
    public GlobalTransactionController(
            GlobalTransactionService globalTransactionService,
            TransactionMapper transactionMapper
    ) {
        this.globalTransactionService = globalTransactionService;
        this.transactionMapper = transactionMapper;

    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionModel>> getTransactions() {
        LOGGER.info("getTransactions:: in");
        try {
            List<TransactionModel> model = transactionMapper.transactionDtoListToTransactionModelList(this.globalTransactionService.getTransactions());

            LOGGER.info("getTransactions:: success!");

            return new ResponseEntity<>(model, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error("getTransactions:: error!");
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionModel>> getTransactionsByType(@PathVariable String type) {
        LOGGER.info("getTransactionsByType:: in");
        try {
            Optional<List<TransactionDTO>> transactions = this.globalTransactionService.getTransactionsByType(type);

            List<TransactionModel> transactionModels = this.transactionMapper.transactionDtoListToTransactionModelList(transactions.orElse(new ArrayList<>()));

            LOGGER.info("getTransactionsByType:: success!");

            return new ResponseEntity<>(transactionModels, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error("getTransactionsByType:: error!");
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/count/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getAmountTransactionsByType(@PathVariable String type) {

        LOGGER.info("getAmountTransactionsByType:: in");

        try {
            Integer transactionsCount = this.globalTransactionService.getTotalAmountByTransactionType(type);

            LOGGER.info("getAmountTransactionsByType:: success!");

            return new ResponseEntity<>(transactionsCount, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error("getAmountTransactionsByType:: error!");
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
