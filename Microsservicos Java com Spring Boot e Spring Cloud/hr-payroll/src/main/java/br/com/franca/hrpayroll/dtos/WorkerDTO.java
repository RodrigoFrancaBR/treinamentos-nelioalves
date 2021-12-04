package br.com.franca.hrpayroll.dtos;

import lombok.*;

@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkerDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Double dailyIncome;
}
