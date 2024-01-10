package demo_adapter;

public class Test {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "Khi em lớn.mp3");
        audioPlayer.play("mp4", "Tam quốc diễn nghĩa.mp4");
        audioPlayer.play("vlc", "Thuỷ hử.vlc");
        audioPlayer.play("avi", "something.avi");
    }
}
