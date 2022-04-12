package com.example.extrawest.controller;

import com.example.extrawest.dto.mapper.AdvertisingMapper;
import com.example.extrawest.dto.response.AdvertisingResponseDto;
import com.example.extrawest.service.AdvertisingService;
import com.example.extrawest.util.PaginationUtil;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertising")
@AllArgsConstructor
public class AdvertisingController {
    private final AdvertisingService advertisingService;
    private final AdvertisingMapper advertisingMapper;
    private final PaginationUtil pagination;

    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    public List<AdvertisingResponseDto> getAll(
            @RequestParam (defaultValue = "0") Integer page,
            @RequestParam (defaultValue = "5") Integer size,
            @RequestParam (defaultValue = "price") String sortBy) {
        PageRequest pageRequest = pagination.paginate(page, size, sortBy);
        return advertisingService.findAll(pageRequest).stream()
                .map(advertisingMapper::toDto)
                .collect(Collectors.toList());
    }
}
