package demo_adapter;

public class vlcPlayer implements AdvanceMediaPlayer{
    @Override
    public void playMp4(String fileName) {
        // Do nothing.
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file " + fileName);
    }
}
