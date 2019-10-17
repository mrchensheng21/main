package seedu.address.ui;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import java.util.List;

/**
 * Table consisting of timetables of scheduling.
 */
public class ScheduleView extends UiPart<Region> {

    private static final String FXML = "ScheduleView.fxml";

    private List<ObservableList<ObservableList<String>>> scheduleList;

    @FXML
    private TableView tableView;

    public ScheduleView(List<ObservableList<ObservableList<String>>> scheduleList) {
        super(FXML);
        this.scheduleList = scheduleList;
        tableView = new TableView<>();

      for (int i = 0; i < this.scheduleList.get(0).size(); i++) {
            final int finalIdx = i;
            TableColumn<ObservableList<String>, String> column =
                    new TableColumn<ObservableList<String>, String>(
                            this.scheduleList.get(0).get(i).toString()
                    );
            column.setCellValueFactory(param ->
                    new ReadOnlyObjectWrapper<>(param.getValue().get(finalIdx))
            );
            tableView.getColumns().add(column);

    }
        for (int i = 0; i < this.scheduleList.size(); i++) {
            tableView.getItems().add(this.scheduleList.get(i));
        }
    }
}
