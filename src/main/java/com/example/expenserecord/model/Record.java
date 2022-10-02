package com.example.expenserecord.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springdoc.core.converters.models.MonetaryAmount;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Record {
    @NonNull
    private Long id;
    @NonNull
    private Long userId;
    @NonNull
    private Long categoryId;
    @NonNull
    private LocalDateTime creationTime;
    @NonNull
    private MonetaryAmount money;
}
