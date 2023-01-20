package in.co.anand.manager.stickynote.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="STICKY_NOTE")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class StickyNote {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "STICKY_NOTE_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Lob
    @Column(name = "BODY", columnDefinition = "CLOB")
    private String body;
}

