package Views.Adapter;

/**
 * Created by Indi on 6/16/2016.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file : " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}
