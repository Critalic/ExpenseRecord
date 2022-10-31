package com.example.expenserecord.dto;

import com.example.expenserecord.model.Record;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Getter
@Setter
@NoArgsConstructor
public class RecordDTO {
    private String moneyId;
    @NotEmpty(message = "Customer id can't be null")
    private String customerId;
    @NotEmpty(message = "Category id can't be null")
    private String categoryId;
    private LocalDateTime creationTime;

    public Record toRecord() {
        return new Record(this.moneyId, this.customerId, this.categoryId,
                isNull(this.creationTime) ? LocalDateTime.now() : this.creationTime);
    }
}
