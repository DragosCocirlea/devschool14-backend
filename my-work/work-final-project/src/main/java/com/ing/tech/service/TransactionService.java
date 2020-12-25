package com.ing.tech.service;

import com.ing.tech.model.Account;
import com.ing.tech.model.Transaction;
import com.ing.tech.model.dto.TransactionHistoryResponseDTO;
import com.ing.tech.model.dto.TransactionInternalRequestDTO;
import com.ing.tech.model.dto.TransactionResponseDTO;
import com.ing.tech.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionResponseDTO makeTransaction(TransactionInternalRequestDTO transactionInternalRequestDTO) {
        // update balances
        transactionInternalRequestDTO.getFromAccount().transferFundsFrom(transactionInternalRequestDTO.getAmount());
        transactionInternalRequestDTO.getToAccount().transferFundsTo(transactionInternalRequestDTO.getAmount());

        // create transaction
        Transaction transaction = new Transaction(transactionInternalRequestDTO);
        transactionRepository.save(transaction);

        return new TransactionResponseDTO(transaction);
    }

    public List<TransactionResponseDTO> getInboundTransactions(Account account) {
        List<Transaction> inboundTransactions = transactionRepository.getAllByToAccount(account);
        return inboundTransactions.stream().map(TransactionResponseDTO::new).collect(Collectors.toList());
    }

    public List<TransactionResponseDTO> getOutboundTransactions(Account account) {
        List<Transaction> outboundTransactions = transactionRepository.getAllByFromAccount(account);
        return outboundTransactions.stream().map(TransactionResponseDTO::new).collect(Collectors.toList());
    }

    public TransactionHistoryResponseDTO getAllTransactions(Account account) {
        return new TransactionHistoryResponseDTO(getInboundTransactions(account), getOutboundTransactions(account));
    }
}
