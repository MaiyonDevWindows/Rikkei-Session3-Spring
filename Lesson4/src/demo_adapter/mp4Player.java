package demo_adapter;

public class mp4Player implements AdvanceMediaPlayer{
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file " + fileName);
    }

    @Override
    public void playVlc(String fileName) {
        // Do nothing.
    }
}
