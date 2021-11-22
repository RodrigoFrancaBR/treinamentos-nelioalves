package br.com.franca.hrworker.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_WORKER")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Double dailyIncome;
}
