package com.denisczwicz.schedulerapi.controller.dto;

import lombok.Data;

@Data
public class RoomDTO {

    private Long id;
    private String name;
    private Integer numbersOfPlaces;
}