package com.example.note.model;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteRequest {

    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Body is required")
    private String body;
}
