package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.models.Note;
import com.StableManagement.stable_management_api.repositories.NoteRepository;

import java.util.List;

public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public List<Note> getHorseNotes(Long horseId){
        return noteRepository.findByHorse_Id(horseId);
    }
}
