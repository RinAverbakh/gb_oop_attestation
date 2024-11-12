import java.io.Serializable;
import java.time.LocalDateTime;

public class Note implements Serializable{
    private String description;
    private LocalDateTime time;

    public Note(String description, LocalDateTime time){
        this.description = description;
        this.time = time;
    }

    public String getDescription(){
        return description;
    }

    public LocalDateTime getTime(){
        return time;
    }

    @Override
    public String toString() {
        return time.toString() + " - " + description;
    }
}
