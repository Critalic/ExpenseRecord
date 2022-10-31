package com.example.expenserecord.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Record {
    @Id
    @EqualsAndHashCode.Exclude
    private Long id;
    @EqualsAndHashCode.Exclude
    private Long moneyId;
    @NotNull(message = "User id can't be null")
    private Long userId;
    @NotNull(message = "Category id can't be null")
    private Long categoryId;
    @NotNull(message = "Creation time can't be null")
    private LocalDateTime creationTime;
}
