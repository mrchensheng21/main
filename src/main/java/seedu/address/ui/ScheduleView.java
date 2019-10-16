package seedu.address.ui;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.Schedule;
import seedu.address.model.person.Person;

public class ScheduleView extends UiPart<Region> {

    public static final String FXML = "ScheduleView.fxml";

    private final Schedule schedule;

    @FXML
    private TableView<ObservableList<String>> tableView;

    public ScheduleView(Schedule schedule) {
        super(FXML);
        this.schedule = schedule;
        tableView = new TableView<>();

        for (int i = 0; i < columnNames.size(); i++) {
            final int finalIdx = i;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(
                    columnNames.get(i)
            );
            column.setCellValueFactory(param ->
                    new ReadOnlyObjectWrapper<>(param.getValue().get(finalIdx))
            );
            tableView.getColumns().add(column);
        }
    }
}
