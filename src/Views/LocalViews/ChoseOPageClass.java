package Views.LocalViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChoseOPageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final Text text;
    protected final ImageView btnO;
    protected final ImageView backChoseOPage;

    public ChoseOPageClass() {

        imageView = new ImageView();
        text = new Text();
        btnO = new ImageView();
        backChoseOPage = new ImageView();

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
        text.setLayoutY(251.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("You Chose");
        text.setFont(new Font("System Bold Italic", 48.0));

        btnO.setFitHeight(150.0);
        btnO.setFitWidth(200.0);
        btnO.setLayoutX(227.0);
        btnO.setLayoutY(316.0);
        btnO.setPickOnBounds(true);
        btnO.setPreserveRatio(true);
        btnO.setImage(new Image(getClass().getResource("/Images/oo.png").toExternalForm()));

        backChoseOPage.setFitHeight(93.0);
        backChoseOPage.setFitWidth(92.0);
        backChoseOPage.setPickOnBounds(true);
        backChoseOPage.setPreserveRatio(true);
        backChoseOPage.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(text);
        getChildren().add(btnO);
        getChildren().add(backChoseOPage);

    }
}
