package com.api.magalu.controller;

import com.api.magalu.dto.CommunicationDTO;
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
    public ResponseEntity<CommunicationDTO> save(@Valid @RequestBody CommunicationDTO communicationDTO) {
        communicationService.save(communicationDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{communicationId}")
    public ResponseEntity<Void> delete(@PathVariable("communicationId") Long communicationId) {
        communicationService.delete(communicationId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{communicationId}")
    public ResponseEntity<CommunicationDTO> getById(@PathVariable("communicationId") Long communicationId) {
        return ResponseEntity.ok(communicationService.getById(communicationId));
    }

    @GetMapping
    public ResponseEntity<List<CommunicationDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(communicationService.getAll(pageable).getContent());
    }

    @PutMapping("/{communicationId}")
    public ResponseEntity<CommunicationDTO> update(
            @PathVariable("/{communicationId}") Long communicationId,
            @Valid @RequestBody CommunicationDTO communicationDTO
    ) {
        return ResponseEntity.ok(communicationService.update(communicationId, communicationDTO));
    }

}
