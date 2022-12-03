package com.denisczwicz.schedulerapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Scheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long responsible;

    @Column(nullable = false)
    private Long room;

    @Column(name = "reservation_date_and_time")
    private LocalDateTime  reservationDateAndTime;
}
