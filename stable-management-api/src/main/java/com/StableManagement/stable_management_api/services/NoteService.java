package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.dto.note.NoteDto;
import com.StableManagement.stable_management_api.dto.note.NotePatchDto;
import com.StableManagement.stable_management_api.exceptions.NotFoundException;
import com.StableManagement.stable_management_api.mappers.NoteMapper;
import com.StableManagement.stable_management_api.models.Note;
import com.StableManagement.stable_management_api.repositories.NoteRepository;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserService userService;
    private final HorseService horseService;
    private final NoteMapper mapper;

    public NoteService(NoteRepository noteRepository,
                       UserService userService,
                       HorseService horseService,
                       NoteMapper mapper){
        this.noteRepository = noteRepository;
        this.horseService = horseService;
        this.userService = userService;
        this.mapper = mapper;
    }

    public NoteDto getNote(Long noteId){
        Note note = noteRepository
                .findById(noteId)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono notatki z id: " + noteId));

        return mapper.entityToDto(note);
    }

    public List<NoteDto> getHorseNotes(Long horseId){
        List<Note> notes = noteRepository.findByHorse_Id(horseId);
        List<NoteDto> noteDtos = mapper.entitiesToDtos(notes);

        return noteDtos;
    }

    public NoteDto createNote(NoteDto noteDto){
        Note note = mapper.dtoToEntity(noteDto, userService, horseService);
        Note savedNote = noteRepository.save(note);

        return mapper.entityToDto(savedNote);
    }

    public NoteDto patchNote(Long noteId, NotePatchDto notePatchDto){
        Note note = noteRepository
                .findById(noteId)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono notatki z id: " + noteId));
        mapper.patchEntityFromDto(notePatchDto, note);

        Note patchedNote = noteRepository.save(note);

        return mapper.entityToDto(patchedNote);
    }

    public void deleteNote(Long noteId){
        if(!noteRepository.existsById(noteId)){
            throw new NotFoundException("Nie znaleziono notatki z id: " + noteId);
        }

        noteRepository.deleteById(noteId);
    }
}
