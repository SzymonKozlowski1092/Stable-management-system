package com.StableManagement.stable_management_api.security;

import com.StableManagement.stable_management_api.repositories.NoteRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("noteSecurity")
public class NoteSecurity {
    private final NoteRepository noteRepository;

    public NoteSecurity(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public boolean isOwner(Long noteId, Authentication auth){
        String username = auth.getName();
        return noteRepository.findById(noteId)
                .map(note -> note.getCreator().getUsername().equals(username))
                .orElse(false);
    }
}
