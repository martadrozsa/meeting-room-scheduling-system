package com.denisczwicz.roomapi.controller.dto;

import com.denisczwicz.roomapi.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {

    private Long id;
    private String name;
    private Integer numbersOfPlaces;

    public RoomDTO(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.numbersOfPlaces = room.getNumbersOfPlaces();
    }

    public Room convertRoom() {
        Room room = new Room();
        room.setId(this.getId());
        room.setName(this.getName());
        room.setNumbersOfPlaces((this.numbersOfPlaces));
        return room;
    }

    public static RoomDTO convertRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setNumbersOfPlaces(room.getNumbersOfPlaces());
        return roomDTO;
    }

    public static List<RoomDTO> convertDTOList(List<Room> roomList) {
        List<RoomDTO> roomDTOS = new ArrayList<>();

        for (Room room : roomList) {
            RoomDTO roomDTO = new RoomDTO(room);
            roomDTOS.add(roomDTO);
        }
        return roomDTOS;
    }
}


