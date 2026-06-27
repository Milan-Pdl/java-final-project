package com.pgs.apiProject.controller;

import com.pgs.apiProject.entity.Journal;
import com.pgs.apiProject.service.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/posts")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping
    public List<Journal> getAll() {
        return journalService.getAll();
    }

    @GetMapping("/{id}")
    public Journal getJournalById(@PathVariable String id) {
        return journalService.getJournalById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Journal createJournal(@RequestBody Journal newJournal) {
        return journalService.saveJournal(newJournal);
    }

    @DeleteMapping("/{id}")
    public boolean deleteJournal(@PathVariable String id) {
        journalService.deleteJournal(id);
        return true;
    }

    @PutMapping("/{id}")
    public Journal updateJournal(@PathVariable String id, @RequestBody Journal newJournal) {
        return journalService.updateJournal(id, newJournal);
    }
}
