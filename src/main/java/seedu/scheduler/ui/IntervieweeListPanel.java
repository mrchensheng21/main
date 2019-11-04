package seedu.scheduler.ui;

import seedu.scheduler.commons.core.LogsCenter;
import seedu.scheduler.model.person.Interviewee;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

/**
 * Panel containing the list of interviewee.
 */
public class IntervieweeListPanel extends UiPart<Region> {
    private static final String FXML = "IntervieweeListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(IntervieweeListPanel.class);

    private ObservableList<Interviewee> intervieweeList;

    @FXML
    private TableView<Interviewee> intervieweeTableView;

    IntervieweeListPanel(ObservableList<Interviewee> intervieweeList) {
        super(FXML);
        this.intervieweeList = intervieweeList;
        initialise();
    }

    private void initialise() {
       setTableColumn();
       this.intervieweeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       this.intervieweeTableView.setItems(this.intervieweeList);
    }

    private void setTableColumn() {
        createNewTableColumn("Full Name");
        createNewTableColumn("NUS Email");
        createNewTableColumn("Personal Email");
        createNewTableColumn("Mobile");
        createNewTableColumn("Faculty/School");
        createNewTableColumn("Acad Year");
        createNewTableColumn("Choice of Department");
        createNewTableColumn("Time Slots");
    }

    private void createNewTableColumn(String titles) {
        TableColumn columnTitle = new TableColumn(titles);
        columnTitle.setReorderable(false);
        columnTitle.setMinWidth(80);

        intervieweeTableView.getColumns().add(columnTitle);
    }
}
