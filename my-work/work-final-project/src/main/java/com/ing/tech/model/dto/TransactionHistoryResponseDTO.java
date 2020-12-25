package com.ing.tech.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TransactionHistoryResponseDTO {

    List<TransactionResponseDTO> inbound;
    List<TransactionResponseDTO> outbound;
}
