package com.example.note.service;

import com.example.note.exception.NoteNotFoundException;
import com.example.note.model.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public Note create(String title, String body) {
        Long id = counter.getAndIncrement();
        Note note = Note.builder()
                .id(id)
                .title(title)
                .body(body)
                .build();
        notes.put(id, note);
        return note;
    }

    public List<Note> findAll() {
        return notes.values()
                .stream()
                .toList();
    }

    public Note findById(Long id) {
        Note note = notes.get(id);
        if (note == null) {
            throw new NoteNotFoundException(id);
        }
        return note;
    }

    public Note update(Long id, String title, String body) {
        Note note = findById(id);
        note.setTitle(title);
        note.setBody(body);
        notes.put(id, note);
        return note;
    }

    public void delete(Long id) {
        if (!notes.containsKey(id)) {
            throw new NoteNotFoundException(id);
        }
        notes.remove(id);
    }
}
