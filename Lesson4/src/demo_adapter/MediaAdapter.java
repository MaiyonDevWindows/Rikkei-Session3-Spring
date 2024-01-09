package demo_adapter;

public class MediaAdapter implements MediaPlayer{
    AdvanceMediaPlayer advanceMediaPlayer;
    MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")) advanceMediaPlayer = new vlcPlayer();
        else if(audioType.equalsIgnoreCase("mp4")) advanceMediaPlayer = new mp4Player();
    }
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) advanceMediaPlayer.playVlc(fileName);
        else if(audioType.equalsIgnoreCase("mp4")) advanceMediaPlayer.playMp4(fileName);
    }
}
