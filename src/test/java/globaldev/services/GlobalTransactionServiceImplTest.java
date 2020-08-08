package globaldev.services;

import org.globaldev.dtos.TransactionDTO;
import org.globaldev.services.impl.GlobalTransactionServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlobalTransactionServiceImplTest {

    @Test
    public void verifyIfTransactionsAreReturned() {
        GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

        try {
            Assert.assertNotNull(testImpl.getTransactions().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyIfTransactionsAreSepaType() {
        GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

        AtomicBoolean result = new AtomicBoolean(true);

        String type = "SEPA";

        try {
            Optional<List<TransactionDTO>> transactions = testImpl.getTransactionsByType(type);

            if (transactions.isPresent() && transactions.get().size() > 0) {
                transactions.get().stream().forEach(trans -> {
                    if (!trans.getDetails().getType().equalsIgnoreCase(type)) {
                        result.set(false);
                    }
                });
            } else {
                result.set(false);
            }

            Assert.assertTrue(result.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyIfTransactionsReturnAmountType() {
        GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

        AtomicBoolean result = new AtomicBoolean(true);

        String type = "SEPA";

        try {
            Integer transactions = testImpl.getTotalAmountByTransactionType(type);

            if (transactions != 3) {
                result.set(false);
            }

            Assert.assertTrue(result.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
