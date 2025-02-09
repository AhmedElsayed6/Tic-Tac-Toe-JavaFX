package Views.LocalViews;

import Views.GeneralViews.ChosePageClass;
import Controllers.ChangeSceneController;
import Controllers.LocalGameInitController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LocalChooseXOPageView extends AnchorPane {

    protected final ImageView btnBackChooseXOView;
    protected final ImageView back;
    protected final Text text;
    protected final ImageView imageX;
    protected final ImageView imageO;
    protected final Text text0;
    protected final Text txtTimer;
    protected final Text txtTimer3;
    protected final Text txtTimer2;
    protected final Text txtTimer1;
    LocalGameInitController   localGameInitController;  
    public LocalChooseXOPageView() {
        
        btnBackChooseXOView = new ImageView();
        back = new ImageView();
        text = new Text();
        imageX = new ImageView();
        imageO = new ImageView();
        text0 = new Text();
        txtTimer = new Text();
        txtTimer3 = new Text();
        txtTimer2 = new Text();
        txtTimer1 = new Text();
        
        localGameInitController = new LocalGameInitController(imageX, imageO,txtTimer,txtTimer3,txtTimer2,txtTimer1);
        setId("AnchorPane");
        setMaxHeight(700.0);
        setMaxWidth(600.0);
        setMinHeight(700.0);
        setMinWidth(600.0);
        setPrefHeight(700.0);
        setPrefWidth(600.0);
        
        btnBackChooseXOView.setFitHeight(727.0);
        btnBackChooseXOView.setFitWidth(630.0);
        btnBackChooseXOView.setLayoutX(-5.0);
        btnBackChooseXOView.setLayoutY(-2.0);
        btnBackChooseXOView.setPickOnBounds(true);
        btnBackChooseXOView.setPreserveRatio(true);
        btnBackChooseXOView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        back.setFitHeight(85.0);
        back.setFitWidth(93.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeSceneController.switchScene(new ChosePageClass(),event);
            }
        });
        back.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        text.setLayoutX(160.0);
        text.setLayoutY(151.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("CHOOSE");
        text.setFont(new Font("Rockwell Bold Italic", 64.0));
        
        
        imageX.setFitHeight(188.0);
        imageX.setFitWidth(157.0);
        imageX.setLayoutX(82.0);
        imageX.setLayoutY(266.0);
        imageX.setPickOnBounds(true);
        imageX.setPreserveRatio(true);
  
        imageX.setImage(new Image(getClass().getResource("/Images/xx.png").toExternalForm()));

        imageO.setFitHeight(183.0);
        imageO.setFitWidth(171.0);
        imageO.setLayoutX(369.0);
        imageO.setLayoutY(269.0);
        imageO.setPickOnBounds(true);
        imageO.setPreserveRatio(true);
        imageO.setImage(new Image(getClass().getResource("/Images/oo.png").toExternalForm()));

        
        
      
        text0.setLayoutX(272.0);
        text0.setLayoutY(373.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("OR");
        text0.setFont(new Font("Rockwell Bold", 36.0));

        txtTimer.setLayoutX(234.0);
        txtTimer.setLayoutY(567.0);
        txtTimer.setOpacity(0.0);
        txtTimer.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtTimer.setStrokeWidth(0.0);
        txtTimer.setText("Timer");
        txtTimer.setFont(new Font("System Bold Italic", 48.0));

        txtTimer3.setLayoutX(275.0);
        txtTimer3.setLayoutY(663.0);
        txtTimer3.setOpacity(0);
        txtTimer3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtTimer3.setStrokeWidth(0.0);
        txtTimer3.setText("3");
        txtTimer3.setFont(new Font("System Bold Italic", 64.0));

        txtTimer2.setLayoutX(275.0);
        txtTimer2.setLayoutY(663.0);
        txtTimer2.setOpacity(0.0);
        txtTimer2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtTimer2.setStrokeWidth(0.0);
        txtTimer2.setText("2");
        txtTimer2.setFont(new Font("System Bold Italic", 64.0));

        txtTimer1.setLayoutX(275.0);
        txtTimer1.setLayoutY(663.0);
        txtTimer1.setOpacity(0.0);
        txtTimer1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtTimer1.setStrokeWidth(0.0);
        txtTimer1.setText("1");
        txtTimer1.setFont(new Font("System Bold Italic", 64.0));

        getChildren().add(btnBackChooseXOView);
        getChildren().add(back);
        getChildren().add(text);
        getChildren().add(imageX);
        getChildren().add(imageO);
        getChildren().add(text0);
        getChildren().add(txtTimer);
        getChildren().add(txtTimer3);
        getChildren().add(txtTimer2);
        getChildren().add(txtTimer1);

    }
    
}

