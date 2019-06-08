package socket;

import javax.sound.midi.Receiver;

public class ChangeCommand extends  Command{
    ChangeCommand(Televison receiver) {
        super(receiver);
    }

    @Override
    public void excuteCommand(int channel) {
        receiver.change(channel);
    }
}
