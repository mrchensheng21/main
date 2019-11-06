package seedu.scheduler.logic.parser;

import seedu.scheduler.logic.commands.DisplayCommand;
import seedu.scheduler.logic.parser.exceptions.ParseException;

import static seedu.scheduler.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.scheduler.logic.commands.DisplayCommand.MESSAGE_USAGE;

public class DisplayCommandParser implements Parser<DisplayCommand> {

    public DisplayCommand parse(String args) throws ParseException {
        args.trim();
        if(args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_USAGE)
            );
        }
        return new DisplayCommand(args);
    }
}
