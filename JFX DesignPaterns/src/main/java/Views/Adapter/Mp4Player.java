package Views.Adapter;

/**
 * Created by Indi on 6/16/2016.
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file : " +fileName);
    }
}
