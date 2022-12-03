package com.denisczwicz.schedulerapi.client;

import com.denisczwicz.schedulerapi.controller.dto.RoomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "${client.room.name}", url = "${client.room.url}", decode404 = true)
public interface RoomClient {

    @GetMapping("/room/{id}")
    Optional<RoomDTO> getById(@PathVariable("id") Long id);
}
