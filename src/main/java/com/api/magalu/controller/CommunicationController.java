package com.api.magalu.controller;

import com.api.magalu.controller.dto.CommunicationRequestDTO;
import com.api.magalu.controller.dto.CommunicationResponseDTO;
import com.api.magalu.service.CommunicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/communications")
public class CommunicationController {

    @Autowired
    private CommunicationService communicationService;

    @PostMapping
    public ResponseEntity<CommunicationRequestDTO> save(@Valid @RequestBody CommunicationRequestDTO communicationRequestDTO) {
        communicationService.save(communicationRequestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{communicationId}")
    public ResponseEntity<Void> delete(@PathVariable("communicationId") Long communicationId) {
        communicationService.delete(communicationId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{communicationId}")
    public ResponseEntity<CommunicationResponseDTO> getById(@PathVariable("communicationId") Long communicationId) {
        return ResponseEntity.ok(communicationService.getById(communicationId));
    }

    @GetMapping
    public ResponseEntity<List<CommunicationResponseDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(communicationService.getAll(pageable).getContent());
    }

    @PutMapping("/{communicationId}")
    public ResponseEntity<CommunicationResponseDTO> update(
            @PathVariable("/{communicationId}") Long communicationId,
            @Valid @RequestBody CommunicationRequestDTO communicationRequestDTO
    ) {
        return ResponseEntity.ok(communicationService.update(communicationId, communicationRequestDTO));
    }

    @PostMapping("/cancel/{communicationId}")
    public ResponseEntity<String> cancel(@PathVariable("communicationId") Long communicationId) {
        communicationService.cancel(communicationId);
        return ResponseEntity.ok().body("Communication cancelled successfully");
    }

}
