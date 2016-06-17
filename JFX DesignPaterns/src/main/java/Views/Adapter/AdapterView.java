package Views.Adapter;

import Views.SuperView;
import javafx.fxml.FXML;

/**
 * Created by Indi on 6/16/2016.
 */
public class AdapterView extends SuperView {

    @FXML
    public void doAdapterStuff(){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
