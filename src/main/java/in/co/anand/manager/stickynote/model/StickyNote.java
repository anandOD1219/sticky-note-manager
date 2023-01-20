package in.co.anand.manager.stickynote.model;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class StickyNote {

    private long id;
    @NonNull
    private String title;
    @NonNull
    private String body;
}
