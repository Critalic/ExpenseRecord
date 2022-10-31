package com.example.expenserecord.dto;

import com.example.expenserecord.model.Record;
import com.example.expenserecord.repository.mongo.entityrepo.CustomerRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Getter
@Setter
@NoArgsConstructor
public class MonetaryUnitDTO {
    private String moneyId;
    @NotEmpty(message = "User id can't be null")
    private String userId;
    @NotEmpty(message = "Category id can't be null")
    private String categoryId;
    private LocalDateTime creationTime;

}
