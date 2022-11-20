package com.denisczwicz.roomapi.controller;

import com.denisczwicz.roomapi.controller.dto.RoomDTO;
import com.denisczwicz.roomapi.model.Room;
import com.denisczwicz.roomapi.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
}
