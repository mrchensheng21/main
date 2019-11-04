package seedu.scheduler.ui;

import seedu.scheduler.commons.core.LogsCenter;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import seedu.scheduler.model.person.Interviewer;

/**
 * Panel containing the list of interviewee.
 */
public class InterviewerListPanel extends UiPart<Region> {
    private static final String FXML = "InterviewerListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(InterviewerListPanel.class);

    private ObservableList<Interviewer> interviewerList;

    @FXML
    private TableView<Interviewer> interviewerTableView;

    InterviewerListPanel(ObservableList<Interviewer> interviewerList) {
        super(FXML);
        this.interviewerList = interviewerList;
        initialise();
    }

    private void initialise() {
        setTableColumn();
        this.interviewerTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.interviewerTableView.setItems(this.interviewerList);
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

        interviewerTableView.getColumns().add(columnTitle);
    }
}

