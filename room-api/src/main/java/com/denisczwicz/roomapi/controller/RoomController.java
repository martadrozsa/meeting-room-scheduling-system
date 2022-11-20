package com.denisczwicz.roomapi.controller;

import com.denisczwicz.roomapi.controller.dto.RoomDTO;
import com.denisczwicz.roomapi.model.Room;
import com.denisczwicz.roomapi.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/")
    public ResponseEntity<List<RoomDTO>> getAll()  {
        List<Room> rooms = roomService.getAll();
        List<RoomDTO> roomDTOList = RoomDTO.convertDTOList(rooms);
        return ResponseEntity.ok().body(roomDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getById(@PathVariable(name = "id")Long id) {
        Optional<Room> optionalRoom = roomService.getById(id);
        if (optionalRoom.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new RoomDTO(optionalRoom.get()));
    }
}
