public class NotebookPresenter {
    private NotebookView view;
    private CommandHandler cm;

    public NotebookPresenter(Notebook model, NotebookView view){
        this.view = view;
        this.cm = new CommandHandlerImpl(model, view);
    }

    public void start(){
        while (true){

            view.showMessage("Введите номер команды");
            view.showMessage("1. Добавить запись");
            view.showMessage("2. Посмотреть все записи ");
            view.showMessage("3. Посмотреть записи за день ");
            view.showMessage("4. Посмотреть записи за неделю ");
            view.showMessage("5. Сохранить в файл ");
            view.showMessage("6. Загрузить из файла ");
            view.showMessage("0. Выход ");
            String action = view.getDescriptionInput(); 

            switch (action) {
                case "1":
                    cm.addNote();
                    break;

                case "2":
                    cm.showNotes();
                    break;

                case "3":
                    cm.showNotesForDay();
                    break;

                case "4":
                    cm.showNotesForWeek();
                    break;
                    
                case "5":
                    cm.save();
                    break;
                    
                case "6":
                   cm.load();
                    break;

                case "0":
                    return;
            
                default:
                    view.showMessage("Неверный ввод команды.");
            }
        }
    }
}
