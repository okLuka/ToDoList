import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class toDoList extends Application {

    private ObservableList<String> tasks;
    private ListView<String> taskListView;
    private TextField taskInput;

    @Override
    public void start(Stage primaryStage) {
        tasks = FXCollections.observableArrayList();

        taskListView = new ListView<>(tasks);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addTask());

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> removeTask());

        HBox buttonBox = new HBox(10, addButton, removeButton);
        buttonBox.setPadding(new Insets(10));

        taskInput = new TextField();
        taskInput.setOnAction(e -> addTask());

        VBox inputBox = new VBox(10, taskInput, buttonBox);
        inputBox.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setCenter(taskListView);
        root.setRight(inputBox);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("To-Do List");
        primaryStage.show();
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            taskInput.clear();
        }
    }

    private void removeTask() {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tasks.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}