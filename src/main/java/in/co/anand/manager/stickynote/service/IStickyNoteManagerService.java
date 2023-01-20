package in.co.anand.manager.stickynote.service;

import in.co.anand.manager.stickynote.model.StickyNote;

import java.util.List;

public interface IStickyNoteManagerService {

    void create(StickyNote s);

    StickyNote findById(Long id);

    List<StickyNote> findByQuery(String query);

    List<StickyNote> findAll();

    void update(StickyNote s);

    void delete(Long id);
}
