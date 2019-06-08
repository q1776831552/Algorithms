package socket;

public abstract class Command {
    protected Televison receiver;

    Command(Televison receiver) {
        this.receiver = receiver;
    }

    public abstract void excuteCommand(int channel);
}
