package in.co.anand.manager.stickynote.controller;

import in.co.anand.manager.stickynote.model.StickyNote;
import in.co.anand.manager.stickynote.service.StickyNoteManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/stickynote/v1")
public class StickyNoteManagerController {

    @Autowired
    private StickyNoteManagerService stickyNoteManagerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StickyNote>> getNotes() {
        return new ResponseEntity<List<StickyNote>>(stickyNoteManagerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StickyNote> getNoteById(@PathVariable(name = "id") long id) {
        StickyNote stickyNote = stickyNoteManagerService.findById(id);
        if (stickyNote != null) {
            return new ResponseEntity<StickyNote>(stickyNote, HttpStatus.OK);
        } else {
            return new ResponseEntity<StickyNote>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StickyNote>> searchNotes(@RequestParam(name = "query") String query) {
        return new ResponseEntity<List<StickyNote>>(stickyNoteManagerService.findByQuery(query), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addNewNote(@RequestBody StickyNote stickyNote) {
        stickyNoteManagerService.create(stickyNote);
        ResponseEntity<Void> response = ResponseEntity.status(HttpStatus.CREATED.value()).build();
        return response;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@RequestBody StickyNote stickyNote) {
        stickyNoteManagerService.update(stickyNote);
        ResponseEntity<Void> response = ResponseEntity.status(HttpStatus.OK.value()).build();
        return response;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable(name = "id") long id) {
        stickyNoteManagerService.delete(id);
        ResponseEntity<Void> response = ResponseEntity.status(HttpStatus.OK.value()).build();
        return response;
    }
}
