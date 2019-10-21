package seedu.address.ui;

import java.util.List;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

/**
 * Table consisting of timetables of scheduling.
 */
public class ScheduleView extends UiPart<Region> {

    private static final String FXML = "ScheduleView.fxml";

    private ObservableList<ObservableList<String>> schedule;

    @FXML
    private TableView tableView;

    ScheduleView(ObservableList<ObservableList<String>> schedule) {
        super(FXML);
        this.schedule = schedule;
        initialise();
    }

    /**
     * Allow the creation of table.
     */
    private void initialise() {
        for (int i = 0; i < this.schedule.get(0).size(); i++) {
            final int finalIdx = i;
            TableColumn<ObservableList<String>, String> column =
                    new TableColumn<ObservableList<String>, String>(
                            this.schedule.get(0).get(i)
                    );
            column.setCellValueFactory(param ->
                    new ReadOnlyObjectWrapper<>(param.getValue().get(finalIdx))
            );
            this.tableView.getColumns().add(column);
            this.tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        }

        this.tableView.setItems(this.schedule);
    }
}
