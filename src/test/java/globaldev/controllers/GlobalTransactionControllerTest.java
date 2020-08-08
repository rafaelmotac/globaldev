package globaldev.controllers;

import org.globaldev.controllers.GlobalTransactionController;
import org.globaldev.mappers.TransactionMapper;
import org.globaldev.mappers.TransactionMapperImpl;
import org.globaldev.models.TransactionModel;
import org.globaldev.services.impl.GlobalTransactionServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GlobalTransactionControllerTest {

    @Test
    public void verifyIfTransactionsAreReturned() {
        GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

        TransactionMapper mapper = new TransactionMapperImpl();
        GlobalTransactionController testController = new GlobalTransactionController(testImpl, mapper);

        try {
            Assert.assertEquals(HttpStatus.OK,testController.getTransactions().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyIfTransactionsAreSepaType() {
        GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

        TransactionMapper mapper = new TransactionMapperImpl();
        GlobalTransactionController testController = new GlobalTransactionController(testImpl, mapper);

        String type = "SEPA";

        try {
            ResponseEntity<List<TransactionModel>> result = testController.getTransactionsByType(type);
            Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
            Assert.assertNotNull(result.getBody().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyIfTransactionsAreTypeEmpty() {
        GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

        TransactionMapper mapper = new TransactionMapperImpl();
        GlobalTransactionController testController = new GlobalTransactionController(testImpl, mapper);

        String type = "dasdsadas";

        try {
            ResponseEntity<List<TransactionModel>> result = testController.getTransactionsByType(type);
            Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
            Assert.assertTrue(result.getBody().size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyIfTransactionsReturnAmountTypeMoreThanZero() {
        GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

        TransactionMapper mapper = new TransactionMapperImpl();
        GlobalTransactionController testController = new GlobalTransactionController(testImpl, mapper);

        String type = "SEPA";

        try {
            ResponseEntity<Integer> result = testController.getAmountTransactionsByType(type);
            Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
            Assert.assertTrue(result.getBody() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyIfTransactionsReturnAmountTypeZero() {
        GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

        TransactionMapper mapper = new TransactionMapperImpl();
        GlobalTransactionController testController = new GlobalTransactionController(testImpl, mapper);

        String type = "SADASDASDAS";

        try {
            ResponseEntity<Integer> result = testController.getAmountTransactionsByType(type);
            Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
            Assert.assertTrue(result.getBody() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
