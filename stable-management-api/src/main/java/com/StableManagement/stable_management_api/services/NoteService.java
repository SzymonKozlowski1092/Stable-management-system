package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.models.Note;
import com.StableManagement.stable_management_api.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public List<Note> getHorseNotes(Long horseId){
        return noteRepository.findByHorse_Id(horseId);
    }
}
