package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movement {

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Builder
    @Embeddable
    public static class MovementId implements Serializable {
        private long idMovement;
        private long idUser;

    }
    @Id
    @EmbeddedId
    private MovementId id;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private BigDecimal period;
    @ManyToOne // many movements for one occorrence
    private Occurrence occurrence;
    @ManyToOne // many movements for one calendar
    private Calendar calendar;


}
