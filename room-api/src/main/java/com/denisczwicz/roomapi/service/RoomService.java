package com.denisczwicz.roomapi.service;

import com.denisczwicz.roomapi.model.Room;
import com.denisczwicz.roomapi.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> getById(Long id) {
        return roomRepository.findById(id);
    }

    public Room insert(Room room) {
        return roomRepository.save(room);
    }

    public Room update(Long id, Room room) {
        Room saveRoom = roomRepository.getReferenceById(id);
        saveRoom.setId(room.getId());
        return roomRepository.save(saveRoom);
    }
}
