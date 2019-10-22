package seedu.address.ui;

import seedu.address.logic.Logic;

public class RefreshListenerManager implements RefreshListener {

    ScheduleViewPanel scheduleViewPanel;

    @Override
    public void dataImported(MainWindow window, Logic logic) {
        this.scheduleViewPanel = window.getScheduleViewPanel();
        this.scheduleViewPanel.fillPanel(logic.getTitlesLists(), logic.getObservableLists());
    }
}
