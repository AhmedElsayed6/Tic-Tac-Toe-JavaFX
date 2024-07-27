package Views.LocalViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChoseXPageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final Text text;
    protected final ImageView btnX;
    protected final ImageView backChoseXPage;

    public ChoseXPageClass() {

        imageView = new ImageView();
        text = new Text();
        btnX = new ImageView();
        backChoseXPage = new ImageView();

        setId("AnchorPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(750.0);
        imageView.setFitWidth(650.0);
        imageView.setLayoutX(-18.0);
        imageView.setLayoutY(-25.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        text.setLayoutX(184.0);
        text.setLayoutY(254.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("You Chose");
        text.setFont(new Font("System Bold Italic", 48.0));

        btnX.setFitHeight(150.0);
        btnX.setFitWidth(200.0);
        btnX.setLayoutX(235.0);
        btnX.setLayoutY(315.0);
        btnX.setPickOnBounds(true);
        btnX.setPreserveRatio(true);
        btnX.setImage(new Image(getClass().getResource("/Images/xx.png").toExternalForm()));

        backChoseXPage.setFitHeight(93.0);
        backChoseXPage.setFitWidth(92.0);
        backChoseXPage.setPickOnBounds(true);
        backChoseXPage.setPreserveRatio(true);
        backChoseXPage.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(text);
        getChildren().add(btnX);
        getChildren().add(backChoseXPage);

    }
}
