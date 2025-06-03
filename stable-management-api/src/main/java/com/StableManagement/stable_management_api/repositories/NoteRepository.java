package com.StableManagement.stable_management_api.repositories;

import com.StableManagement.stable_management_api.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByHorse_Id(Long horseId);
}
