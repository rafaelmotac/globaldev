package org.globaldev.mappers;

import org.globaldev.dtos.TransactionDTO;
import org.globaldev.models.TransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TransactionMapper {

    @Mapping(source = "this_account.id", target = "accountId")
    @Mapping(source = "other_account.number", target = "counterPartyAccount")
    @Mapping(source = "other_account.holder.name", target = "counterPartyName")
    @Mapping(source = "other_account.metadata.image_URL", target = "counterPartyLogoPath")
    @Mapping(source = "details.value.amount", target = "instructedAmount")
    @Mapping(source = "details.value.currency", target = "instructedCurrency")
    @Mapping(source = "details.value.amount", target = "transactionAmount")
    @Mapping(source = "details.value.currency", target = "transactionCurrency")
    @Mapping(source = "details.type", target = "transactionType")
    @Mapping(source = "details.description", target = "description")
    TransactionModel transactionDtoToTransactionModel(TransactionDTO transactionDTO);


    @Mapping(target = "this_account.id", source = "accountId")
    @Mapping(target = "other_account.number", source = "counterPartyAccount")
    @Mapping(target = "other_account.holder.name", source = "counterPartyName")
    @Mapping(target = "other_account.metadata.image_URL", source = "counterPartyLogoPath")
    @Mapping(target = "details.value.amount", source = "instructedAmount")
    @Mapping(target = "details.value.currency", source = "instructedCurrency")
    @Mapping(target = "details.type", source = "transactionType")
    @Mapping(target = "details.description", source = "description")
    TransactionDTO transactionModelToTransactionDto(TransactionModel transactionModel);

    List<TransactionModel> transactionDtoListToTransactionModelList(List<TransactionDTO> transactionDTOList);

    List<TransactionDTO> transactionModelListToTransactionDtoList(List<TransactionModel> transactionModelList);

}
