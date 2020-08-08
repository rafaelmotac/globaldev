//package globaldev.mappers;
//
//import org.globaldev.dtos.TransactionDTO;
//import org.globaldev.models.TransactionModel;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import java.util.List;
//
//@Mapper
//public interface TransactionMapperTest {
//
//    @Mapping(source = "this_account.id", target = "accountId")
//    @Mapping(source = "other_account.number", target = "counterPartyAccount")
//    @Mapping(source = "other_account.holder.name", target = "counterPartyName")
//    @Mapping(source = "other_account.metadata.image_URL", target = "counterPartyLogoPath")
//    @Mapping(source = "details.value.amount", target = "instructedAmount")
//    @Mapping(source = "details.value.currency", target = "instructedCurrency")
//    @Mapping(source = "details.value.amount", target = "transactionAmount")
//    @Mapping(source = "details.value.currency", target = "transactionCurrency")
//    @Mapping(source = "details.type", target = "transactionType")
//    @Mapping(source = "details.description", target = "description")
//    TransactionModel transactionDtoToTransactionModel(TransactionDTO transactionDTO);
//
//    List<TransactionModel> transactionDtoListToTransactionModelList(List<TransactionDTO> transactionDTOList);
//
//}
