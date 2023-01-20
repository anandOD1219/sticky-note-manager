package in.co.anand.manager.stickynote.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.co.anand.manager.stickynote.model.dto.StickyNote;
import in.co.anand.manager.stickynote.repo.StickyNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StickyNoteManagerService implements IStickyNoteManagerService{

    @Autowired
    private StickyNoteRepository stickyNoteRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void create(in.co.anand.manager.stickynote.model.StickyNote s) {
     stickyNoteRepository.save(objectMapper.convertValue(s, StickyNote.class));
    }

    @Override
    public in.co.anand.manager.stickynote.model.StickyNote findById(Long id) {
        Optional<StickyNote> stickyNoteOptional = stickyNoteRepository.findById(id);
        in.co.anand.manager.stickynote.model.StickyNote stickyNote = null;
        if (stickyNoteOptional.isPresent()) {
            stickyNote = objectMapper.convertValue(stickyNoteRepository.findById(id).get(), in.co.anand.manager.stickynote.model.StickyNote.class);
        }
        return stickyNote;
    }

    @Override
    public List<in.co.anand.manager.stickynote.model.StickyNote> findByQuery(String query) {
        Iterable<StickyNote> queryResult = stickyNoteRepository.findByQuery(query);
        List<in.co.anand.manager.stickynote.model.StickyNote> result = new ArrayList<>();
        queryResult.forEach((element) -> result.add(objectMapper.convertValue(element, in.co.anand.manager.stickynote.model.StickyNote.class)));
        return result;
    }

    @Override
    public List<in.co.anand.manager.stickynote.model.StickyNote> findAll() {
        Iterable<StickyNote> queryResult = stickyNoteRepository.findAll();
        List<in.co.anand.manager.stickynote.model.StickyNote> result = new ArrayList<>();
        queryResult.forEach((element) -> result.add(objectMapper.convertValue(element, in.co.anand.manager.stickynote.model.StickyNote.class)));
        return result;
    }

    @Override
    public void update(in.co.anand.manager.stickynote.model.StickyNote s) {
        stickyNoteRepository.save(objectMapper.convertValue(s, StickyNote.class));
    }

    @Override
    public void delete(Long id) {
        stickyNoteRepository.deleteById(id);
    }

}
