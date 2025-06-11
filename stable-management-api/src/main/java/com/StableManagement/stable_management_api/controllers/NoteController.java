package com.StableManagement.stable_management_api.controllers;

import com.StableManagement.stable_management_api.dto.note.NoteDto;
import com.StableManagement.stable_management_api.dto.note.NotePatchDto;
import com.StableManagement.stable_management_api.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping("/{noteId}")
    @PreAuthorize("hasAnyRole('MANAGER','EMPLOYEE') or " +
            "@noteSecurity.isOwner(#noteId, authentication)")
    public ResponseEntity<NoteDto> getNote(@PathVariable Long noteId){
        NoteDto noteDto = noteService.getNote(noteId);
        return ResponseEntity.ok().body(noteDto);
    }

    @GetMapping("/horse/{horseId}")
    @PreAuthorize("hasAnyRole('MANAGER','EMPLOYEE') or " +
            "(hasRole('BOARDER') and @horseSecurity.isOwner(#horseId, authentication))"
    )
    public ResponseEntity<List<NoteDto>> getHorseNotes(@PathVariable Long horseId){
        List<NoteDto> noteDtos = noteService.getHorseNotes(horseId);
        return ResponseEntity.ok().body(noteDtos);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MANAGER','EMPLOYEE') or " +
            "(hasRole('BOARDER') and @horseSecurity.isOwner(#noteDto.horseId, authentication))"
    )
    public ResponseEntity<NoteDto> createNote(@Valid @RequestBody NoteDto noteDto){
        NoteDto createdNote = noteService.createNote(noteDto);
        URI location = URI.create(String.format("/api/notes/%d", createdNote.getId()));
        return ResponseEntity.created(location).body(createdNote);
    }

    @PatchMapping("/{noteId}")
    @PreAuthorize("@noteSecurity.isOwner(#noteId, authentication)")
    public ResponseEntity<NoteDto> patchNote(@PathVariable Long noteId, @RequestBody NotePatchDto notePatchDto){
        NoteDto patchedNote = noteService.patchNote(noteId, notePatchDto);
        return ResponseEntity.ok().body(patchedNote);
    }

    @DeleteMapping("/{noteId}")
    @PreAuthorize("hasAnyRole('MANAGER','EMPLOYEE') or " +
            "@noteSecurity.isOwner(#noteId, authentication)")
    public ResponseEntity<Void> deleteNote(@PathVariable Long noteId){
        noteService.deleteNote(noteId);
        return ResponseEntity.noContent().build();
    }
}
