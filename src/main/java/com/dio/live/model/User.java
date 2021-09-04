package com.dio.live.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class User {
    @Id
    private Long id;
    @ManyToOne // multiple users for one category
    private UserCategory userCategory;
    private String name;
    @ManyToOne // multiple users for one company
    private Company company;
    @ManyToOne //multiple users for one access level
    private AccessLevel accessLevel;
    @ManyToOne
    private WorkingDay workingDay;
    private BigDecimal tolerance;
    private LocalDateTime journeyStart;
    private LocalDateTime journeyEnd;
}
