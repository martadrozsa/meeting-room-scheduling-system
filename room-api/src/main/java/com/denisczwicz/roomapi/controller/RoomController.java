package com.denisczwicz.roomapi.controller;

import com.denisczwicz.roomapi.controller.dto.RoomDTO;
import com.denisczwicz.roomapi.model.Room;
import com.denisczwicz.roomapi.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public ResponseEntity<RoomDTO> insert(@RequestBody RoomDTO roomDTO) {
        Room room = roomDTO.convertRoom();
        roomService.insert(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RoomDTO> update(@PathVariable Long id, @RequestBody RoomDTO roomDTO) {
        Room room = roomDTO.convertRoom();
        Room updateRoom = roomService.update(id, room);
        RoomDTO roomDTOUpdated = RoomDTO.convertRoomDTO(updateRoom);
        return ResponseEntity.ok().body(roomDTOUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        roomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
