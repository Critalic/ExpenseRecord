package com.example.expenserecord.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springdoc.core.converters.models.MonetaryAmount;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Record {
    @EqualsAndHashCode.Exclude
    private Long id;
    @NotNull(message = "User id can't be null")
    private Long userId;
    @NotNull(message = "Category id can't be null")
    private Long categoryId;
    @NotNull(message = "Creation time can't be null")
    private LocalDateTime creationTime;
    @EqualsAndHashCode.Exclude
    private MonetaryAmount money;
}
