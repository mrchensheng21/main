package seedu.scheduler.ui;

public interface TabListener {

    /**
     * Signal to the main window to change tabs
     */
    void changeTabSchedule();

    void changeTabInterviewee();

    void changeTabInterviewer();
}
