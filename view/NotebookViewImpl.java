import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class NotebookViewImpl implements NotebookView{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showNotes(List<Note> notes) {
        for (Note note : notes) {
            System.out.println(note.toString());
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() {
        System.out.println("Введите дату и время (yyyy-MM-dd HH:mm): ");
        String string = scanner.nextLine();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(string, formatter);
    }

    @Override
    public String getDescriptionInput() {
        return scanner.nextLine();
    }

    @Override
    public String getFileNameInput() {
        System.out.println("Введите имя файла с расширением: ");
        return scanner.nextLine();
    }
}
