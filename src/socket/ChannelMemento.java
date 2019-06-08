package socket;

public class ChannelMemento {
    private int channel;
    ChannelMemento(int channel) {
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}
