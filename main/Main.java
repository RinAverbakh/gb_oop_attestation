public class Main {
    public static void main(String[] args) {
        NotebookPresenter np = new NotebookPresenter(new Notebook(), new NotebookViewImpl());
        np.start();
    }
}
