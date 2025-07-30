package com.example.note.controller;

import com.example.note.model.ApiResponse;
import com.example.note.model.Note;
import com.example.note.model.NoteRequest;
import com.example.note.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Note>> create(@Valid @RequestBody NoteRequest request) {
        Note note = noteService.create(request.getTitle(), request.getBody());
        return ResponseEntity.ok(new ApiResponse<>(true, "Note created", note));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Note>>> getAll() {
        List<Note> notes = noteService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(true, "Notes retrieved", notes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Note>> getById(@PathVariable Long id) {
        Note note = noteService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Note retrieved", note));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Note>> update(@PathVariable Long id, @Valid @RequestBody NoteRequest request) {
        Note note = noteService.update(id, request.getTitle(), request.getBody());
        return ResponseEntity.ok(new ApiResponse<>(true, "Note updated", note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        noteService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Note deleted", null));
    }
}