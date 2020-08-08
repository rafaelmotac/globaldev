package globaldev.mappers;

import org.globaldev.controllers.GlobalTransactionController;
import org.globaldev.dtos.TransactionDTO;
import org.globaldev.mappers.TransactionMapper;
import org.globaldev.mappers.TransactionMapperImpl;
import org.globaldev.models.TransactionModel;
import org.globaldev.services.impl.GlobalTransactionServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionMapperTest {

   @Test
   public void verifyIfMapperToDtoHasValue() {
       GlobalTransactionServiceImpl testImpl = new GlobalTransactionServiceImpl();

       TransactionMapper mapper = new TransactionMapperImpl();

       try {
           List<TransactionDTO> transactionDTOListFirst = testImpl.getTransactions();

           List<TransactionModel> transactionModelList = mapper.transactionDtoListToTransactionModelList(transactionDTOListFirst);

           List<TransactionDTO> transactionDTOListSecond = mapper.transactionModelListToTransactionDtoList(transactionModelList);

           Assert.assertNotNull(transactionDTOListSecond.get(0).getId());

       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    @Test
    public void verifyIfMapperNullToDtoNull() {
        TransactionMapper mapper = new TransactionMapperImpl();

        try {

            List<TransactionDTO> transactionDTOListSecond = mapper.transactionModelListToTransactionDtoList(new ArrayList<>());

            Assert.assertTrue(transactionDTOListSecond.size() == 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
