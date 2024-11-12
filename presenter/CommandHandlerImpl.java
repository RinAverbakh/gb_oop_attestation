import java.io.IOException;
import java.time.LocalDateTime;

public class CommandHandlerImpl implements CommandHandler{
    private NotebookView view;
    private Notebook model;
    private FileOperations fileOps;

    public CommandHandlerImpl(Notebook model, NotebookView view){
        this.model = model;
        this.view = view;
        this.fileOps = new FileOperationImpl();
    }

    @Override
    public void addNote() {
        view.showMessage("Введите запись: ");
        String description = view.getDescriptionInput();
        LocalDateTime time = view.getDateTimeInput();
        this.model.addNote(new Note(description, time));
    }

    @Override
    public void showNotes() {
        view.showNotes(model.getNotes());
    }

    @Override
    public void showNotesForDay() {
        view.showNotes(model.getNotesForDay(view.getDateTimeInput()));
    }

    @Override
    public void showNotesForWeek() {
        view.showNotes(model.getNotesForWeek(view.getDateTimeInput()));
    }

    @Override
    public void save() {
        try{
            fileOps.save(model, view.getFileNameInput());
            view.showMessage("Данные сохранены");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        Notebook loadedNotebook = null;
        try {
            loadedNotebook = fileOps.Load(view.getFileNameInput());
            view.showMessage("Данные успешно загружены");
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (loadedNotebook != null) {
            view.showMessage("Полученные записи: ");
            view.showNotes(loadedNotebook.getNotes());
        }

        this.model.addNotes(loadedNotebook.getNotes());
    }

}
