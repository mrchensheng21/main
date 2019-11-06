package seedu.scheduler.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

import seedu.scheduler.commons.core.LogsCenter;
import seedu.scheduler.model.person.Interviewee;

/**
 * Panel containing the list of interviewee.
 */
public class IntervieweeListPanel extends UiPart<Region> {
    private static final String FXML = "IntervieweeListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(IntervieweeListPanel.class);

    private ObservableList<Interviewee> intervieweeList;

    @FXML
    private TableView intervieweeTableView;

    IntervieweeListPanel(ObservableList<Interviewee> intervieweeList) {
        super(FXML);
        this.intervieweeList = intervieweeList;
        initialise();
    }

    /**
     * Set the columns and the data from each column
     */
    private void initialise() {
        setTableColumn();
        this.intervieweeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.intervieweeTableView.setItems(this.intervieweeList);
    }

    /**
     * Set the table columns.
     */
    private void setTableColumn() {
        createNewTableColumn("Name");
        createNewTableColumn("Role");
        createNewTableColumn("Phone");
        createNewTableColumn("Emails");
        createNewTableColumn("Faculty");
        createNewTableColumn("Year of study");
        createNewTableColumn("Choice of departments");
        createNewTableColumn("Time slots");
        createNewTableColumn("Tags");
    }

    /**
     * Create a new TableColumn object.
     * @param titles The titles for each columns.
     */
    private void createNewTableColumn(String titles) {
        TableColumn<ObservableList<String>, String> columnTitle =
                new TableColumn<ObservableList<String>, String>(
                        titles
                );
        columnTitle.setReorderable(false);
        columnTitle.setMinWidth(80);

        columnTitle.setCellValueFactory(new PropertyValueFactory<ObservableList<String>, String>(
                titles
        ));

        intervieweeTableView.getColumns().add(columnTitle);
    }

    protected void listUpdated(ObservableList<Interviewee> newIntervieweeList) {
        clearData();
        this.intervieweeTableView.setItems(newIntervieweeList);
    }

    protected void clearData() {
        this.intervieweeTableView.getItems().removeAll();
    }
}
