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

    private List<String> titles;
    private ObservableList<ObservableList<String>> schedule; // Excluding titles

    @FXML
    private TableView tableView;

    ScheduleView(List<String> titles, ObservableList<ObservableList<String>> schedule) {
        super(FXML);
        this.titles = titles;
        this.schedule = schedule;
    }

    /**
     * Allow the creation of table.
     */
    private void initialise() {
        // Currently the code here will only retrieve the first list of titles.
        for (int i = 0; i < this.titles.size(); i++) {
            final int finalIdx = i;
            TableColumn<ObservableList<String>, String> column =
                    new TableColumn<ObservableList<String>, String>(
                            titles.get(i)
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
