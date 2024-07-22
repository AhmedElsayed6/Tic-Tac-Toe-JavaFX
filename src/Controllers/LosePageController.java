package Controllers;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


/**
 *
 * @author musta
 */
public class LosePageController {

    @FXML
    private MediaView mediaView;

    private MediaPlayer mediaPlayer;

    public void initialize() {
        String videoPath = getClass().getResource("/Images/loseviedo.mp4").toExternalForm();
        
        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        mediaPlayer.play();
    
        
        }

    public void playVideo() {
        mediaPlayer.play();
    }

    public void pauseVideo() {
        mediaPlayer.play();
    }

    public void stopVideo() {
        mediaPlayer.play();
    }

    public void seekVideo(double seconds) {
        mediaPlayer.seek(Duration.INDEFINITE);
    }
}
