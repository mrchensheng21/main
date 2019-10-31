package seedu.address.ui;


import javafx.fxml.FXML;
import javafx.scene.layout.*;


/**
 * An UI component that displays information of a {@code Interviewer}.
 */
public class ScheduleViewCard extends UiPart<Region> {

    private static final String FXML = "ScheduleViewCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final ScheduleView schedule;

    @FXML
    private StackPane scheduleViewPane;

    @FXML
    private FlowPane scheduleViews;

    public ScheduleViewCard(ScheduleView schedule) {
        super(FXML);
        this.schedule = schedule;
        scheduleViewPane.getChildren().setAll(schedule.getRoot());
    }
}
