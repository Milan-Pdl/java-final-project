package com.pgs.apiProject.service;

import com.pgs.apiProject.entity.Journal;
import com.pgs.apiProject.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(String id) {
        return journalRepository.findById(id);
    }

    public void deleteJournal(String id) {
        journalRepository.deleteById(id);
    }

    public Journal saveJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public Journal updateJournal(String id, Journal updatedJournal) {
        Journal existing = journalRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        if (updatedJournal.getTitle() != null && !updatedJournal.getTitle().isBlank()) {
            existing.setTitle(updatedJournal.getTitle());
        }
        if (updatedJournal.getContent() != null && !updatedJournal.getContent().isBlank()) {
            existing.setContent(updatedJournal.getContent());
        }
        if (updatedJournal.getAuthor() != null && !updatedJournal.getAuthor().isBlank()) {
            existing.setAuthor(updatedJournal.getAuthor());
        }
        if (updatedJournal.getCategory() != null && !updatedJournal.getCategory().isBlank()) {
            existing.setCategory(updatedJournal.getCategory());
        }
        return journalRepository.save(existing);
    }
}
