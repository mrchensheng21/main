package seedu.scheduler.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.scheduler.commons.core.LogsCenter;

/**
 * Panel consisting a of schedules
 */
public class ScheduleViewPanel extends UiPart<Region> {
    private static final String FXML = "ScheduleViewPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ScheduleViewPanel.class);

    private List<ObservableList<ObservableList<String>>> scheduleList;

    private List<ScheduleView> scheduleViewList;

    private List<List<String>> titles;

    @FXML
    private ListView<ScheduleView> scheduleListView;

    public ScheduleViewPanel(List<List<String>> titles,
                             List<ObservableList<ObservableList<String>>> scheduleList) {
        super(FXML);
        this.titles = titles;
        this.scheduleList = scheduleList;
        this.scheduleViewList = new ArrayList<>();
        fillPanel();
    }

    private void fillPanel() {
        for (int i = 0; i < this.scheduleList.size(); i++) {
            scheduleViewList.add(new ScheduleView(this.titles.get(i), this.scheduleList.get(i)));
        }

        ObservableList<ScheduleView> scheduleViewsObservable = FXCollections.observableArrayList(scheduleViewList);

        scheduleListView.setItems(scheduleViewsObservable);
        scheduleListView.setCellFactory(listView -> new ScheduleListViewCell());
    }
    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class ScheduleListViewCell extends ListCell<ScheduleView> {
        @Override
        protected void updateItem(ScheduleView schedule, boolean empty) {
            super.updateItem(schedule, empty);

            if (empty || schedule == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ScheduleViewCard(schedule).getRoot());
            }
        }
    }

    public void dataUpdated(List<List<String>> titles, List<ObservableList<ObservableList<String>>> newSchedules) {
        clearData();
        this.titles = titles;
        this.scheduleList = newSchedules;
        for (int i = 0; i < this.scheduleList.size(); i++) {
            scheduleViewList.add(new ScheduleView(this.titles.get(i), this.scheduleList.get(i)));
        }

        ObservableList<ScheduleView> scheduleViewsObservable = FXCollections.observableArrayList(scheduleViewList);

        scheduleListView.setItems(scheduleViewsObservable);
        scheduleListView.setCellFactory(listView -> new ScheduleListViewCell());
    }

    protected void clearData() {
        this.scheduleViewList.clear();
    }
}




