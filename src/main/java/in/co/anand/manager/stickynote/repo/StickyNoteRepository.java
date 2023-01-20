package in.co.anand.manager.stickynote.repo;

import in.co.anand.manager.stickynote.model.dto.StickyNote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StickyNoteRepository extends CrudRepository<StickyNote, Long> {

    @Query(value = "SELECT ID, TITLE, BODY FROM STICKY_NOTE where title like %:query% or body like %:query%", nativeQuery = true)
    Iterable<StickyNote> findByQuery(@Param("query") String query);
}
