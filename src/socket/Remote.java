package socket;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Remote {

    private ArrayDeque<ChannelMemento> channels = new ArrayDeque<>();
    private ChangeCommand command;

    public void setChannel(Command command, int channel) {
        command.excuteCommand(channel);
        channels.push(new ChannelMemento(channel));
    }

    public void undo(Command command) {
        channels.pop();
        command.excuteCommand(channels.peek().getChannel());
    }
}
