import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook implements Serializable{
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note){
        this.notes.add(note);
    }

    public void addNotes(List<Note> notebook){
        this.notes.addAll(notebook);
    }

    public List<Note> getNotes(){
        return notes;
    }

    public void removeNote(Note note){
        this.notes.remove(note);
    }

    public List<Note> getNotesForDay(LocalDateTime time){
        return notes.stream().filter(note -> note.getTime().toLocalDate().isEqual(time.toLocalDate())).sorted(Comparator.comparing(Note :: getTime)).collect(Collectors.toList());
    }

    public List<Note> getNotesForWeek(LocalDateTime startOfWeek){
        LocalDateTime endOfWeek = startOfWeek.plusWeeks(1);
        return notes.stream().filter(note ->  !note.getTime().isBefore(startOfWeek) && !note.getTime().isAfter(endOfWeek)).sorted(Comparator.comparing(Note :: getTime)).collect(Collectors.toList());
    }
}
