package Views;


import Controllers.LocalGameController;
import Model.Player;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;



public class LocalGameBoardView extends AnchorPane {
    
    protected final ImageView imgViewBackGround;
    protected final BorderPane borderPane;
    protected final Pane boardPane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final VBox vb00;
    protected final ImageView imgv00;
    protected final VBox vb01;
    protected final ImageView imgv01;
    protected final VBox vb02;
    protected final ImageView imgv02;
    protected final VBox vb10;
    protected final ImageView imgv10;
    protected final VBox vb11;
    protected final ImageView imgv11;
    protected final VBox vb12;
    protected final ImageView imgv12;
    protected final VBox vb20;
    protected final ImageView imgv20;
    protected final VBox vb21;
    protected final ImageView imgv21;
    protected final VBox vb22;
    protected final ImageView imgv22;
    protected final Line row1Line;
    protected final Line row2Line;
    protected final Line row3Line;
    protected final Line column1Line;
    protected final Line column2Line;
    protected final Line column3Line;
    protected final Line diag1Line;
    protected final Line diag2Line;
    protected final VBox vBox;
    protected final VBox vBox0;
    protected final AnchorPane player1InfoPane;
    protected final ImageView imgViewPlayer1Image;
    protected final Label labelPlayer1Name;
    protected final Label labelPlayer1;
    protected final Label labelPlayer1Score;
    protected final Label labelScore1;
    protected final Button btnSurrunder;
    protected final AnchorPane player2InfoPane;
    protected final ImageView imgViewPlayer2Image;
    protected final Label labelPlayer2Name;
    protected final Label labelPlayer2;
    protected final Label labelPlayer2Score;
    protected final Label labelScore2;
    LocalGameController gameController;
    List<VBox> vboxList ;
    List<Line> linesList;
    List<Label> labelList;
    List<ImageView> imageViewList;
    Player player1,player2;
    public LocalGameBoardView(Player player1, Player player2) {

        
        imgViewBackGround = new ImageView();
        borderPane = new BorderPane();
        boardPane = new Pane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        vb00 = new VBox();
        imgv00 = new ImageView();
        vb01 = new VBox();
        imgv01 = new ImageView();
        vb02 = new VBox();
        imgv02 = new ImageView();
        vb10 = new VBox();
        imgv10 = new ImageView();
        vb11 = new VBox();
        imgv11 = new ImageView();
        vb12 = new VBox();
        imgv12 = new ImageView();
        vb20 = new VBox();
        imgv20 = new ImageView();
        vb21 = new VBox();
        imgv21 = new ImageView();
        vb22 = new VBox();
        imgv22 = new ImageView();
        row1Line = new Line();
        row2Line = new Line();
        row3Line = new Line();
        column1Line = new Line();
        column2Line = new Line();
        column3Line = new Line();
        diag1Line = new Line();
        diag2Line = new Line();
        vBox = new VBox();
        vBox0 = new VBox();
        player1InfoPane = new AnchorPane();
        imgViewPlayer1Image = new ImageView();
        labelPlayer1Name = new Label();
        labelPlayer1 = new Label();
        labelPlayer1Score = new Label();
        labelScore1 = new Label();
        btnSurrunder = new Button();
        player2InfoPane = new AnchorPane();
        imgViewPlayer2Image = new ImageView();
        labelPlayer2Name = new Label();
        labelPlayer2 = new Label();
        labelPlayer2Score = new Label();
        labelScore2 = new Label();

        

   
        
        
        imgViewBackGround.setFitHeight(750.0);
        imgViewBackGround.setFitWidth(650.0);
        imgViewBackGround.setLayoutX(-5);
        imgViewBackGround.setLayoutY(-2);
        
        imgViewBackGround.setPickOnBounds(true);
        imgViewBackGround.setPreserveRatio(true);
        imgViewBackGround.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        borderPane.setMaxHeight(700.0);
        borderPane.setMaxWidth(600.0);
        borderPane.setMinHeight(700.0);
        borderPane.setMinWidth(600.0);
        borderPane.setPrefHeight(0.0);
        borderPane.setPrefWidth(0.0);

        BorderPane.setAlignment(boardPane, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(boardPane, new Insets(0.0));

        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(459.0);
        gridPane.setPrefWidth(378.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        vb00.setAlignment(javafx.geometry.Pos.CENTER);
        vb00.setStyle("-fx-border-color: #e3f2fd; -fx-border-width: 0px 10px 10px 0px;");

        imgv00.setFitHeight(100.0);
        imgv00.setFitWidth(100.0);
        imgv00.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv00.setPickOnBounds(true);
        imgv00.setPreserveRatio(true);
      

        GridPane.setColumnIndex(vb01, 1);
        vb01.setAlignment(javafx.geometry.Pos.CENTER);
        vb01.setLayoutX(10.0);
        vb01.setLayoutY(10.0);
        vb01.setStyle("-fx-border-color: #e3f2fd; -fx-border-width: 0px 10px 10px 0px;");

        imgv01.setFitHeight(100.0);
        imgv01.setFitWidth(100.0);
        imgv01.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv01.setPickOnBounds(true);
        imgv01.setPreserveRatio(true);
       

        GridPane.setColumnIndex(vb02, 2);
        vb02.setAlignment(javafx.geometry.Pos.CENTER);
        vb02.setLayoutX(144.0);
        vb02.setLayoutY(154.0);
        vb02.setStyle("-fx-border-color: #e3f2fd; -fx-border-width: 0px 0px 10px 0px;");

        imgv02.setFitHeight(100.0);
        imgv02.setFitWidth(100.0);
        imgv02.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv02.setPickOnBounds(true);
        imgv02.setPreserveRatio(true);
      

        GridPane.setRowIndex(vb10, 1);
        vb10.setAlignment(javafx.geometry.Pos.CENTER);
        vb10.setLayoutX(10.0);
        vb10.setLayoutY(10.0);
        vb10.setStyle("-fx-border-color: #e3f2fd; -fx-border-width: 0px 10px 10px 0px;");

        imgv10.setFitHeight(100.0);
        imgv10.setFitWidth(100.0);
        imgv10.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv10.setPickOnBounds(true);
        imgv10.setPreserveRatio(true);
      

        GridPane.setColumnIndex(vb11, 1);
        GridPane.setRowIndex(vb11, 1);
        vb11.setAlignment(javafx.geometry.Pos.CENTER);
        vb11.setLayoutX(10.0);
        vb11.setLayoutY(10.0);
        vb11.setStyle("-fx-border-color: #e3f2fd; -fx-border-width: 0px 10px 10px 0px;");

        imgv11.setFitHeight(100.0);
        imgv11.setFitWidth(100.0);
        imgv11.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv11.setPickOnBounds(true);
        imgv11.setPreserveRatio(true);
       

        GridPane.setColumnIndex(vb12, 2);
        GridPane.setRowIndex(vb12, 1);
        vb12.setAlignment(javafx.geometry.Pos.CENTER);
        vb12.setLayoutX(277.0);
        vb12.setLayoutY(10.0);
        vb12.setStyle("-fx-border-color: #e3f2fd; -fx-border-width: 0px 0px 10px 0px;");

        imgv12.setFitHeight(100.0);
        imgv12.setFitWidth(100.0);
        imgv12.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv12.setPickOnBounds(true);
        imgv12.setPreserveRatio(true);
      

        GridPane.setRowIndex(vb20, 2);
        vb20.setAlignment(javafx.geometry.Pos.CENTER);
        vb20.setLayoutX(277.0);
        vb20.setLayoutY(154.0);
        vb20.setStyle("-fx-border-color: #e3f2fd; -fx-border-width: 0px 10px 0px 0px;");

        imgv20.setFitHeight(100.0);
        imgv20.setFitWidth(100.0);
        imgv20.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv20.setPickOnBounds(true);
        imgv20.setPreserveRatio(true);
      

        GridPane.setColumnIndex(vb21, 1);
        GridPane.setRowIndex(vb21, 2);
        vb21.setAlignment(javafx.geometry.Pos.CENTER);
        vb21.setLayoutX(10.0);
        vb21.setLayoutY(298.0);
        vb21.setStyle("-fx-border-color: #e3f2fd; -fx-border-width: 0px 10px 0px 0px;");

        imgv21.setFitHeight(100.0);
        imgv21.setFitWidth(100.0);
        imgv21.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv21.setPickOnBounds(true);
        imgv21.setPreserveRatio(true);
       

        GridPane.setColumnIndex(vb22, 2);
        GridPane.setRowIndex(vb22, 2);
        vb22.setAlignment(javafx.geometry.Pos.CENTER);
        vb22.setLayoutX(144.0);
        vb22.setLayoutY(298.0);

        imgv22.setFitHeight(100.0);
        imgv22.setFitWidth(100.0);
        imgv22.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        imgv22.setPickOnBounds(true);
        imgv22.setPreserveRatio(true);

//

//

//

//

//

//

//

        borderPane.setCenter(boardPane);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(461.0);
        vBox.setPrefWidth(114.0);
        borderPane.setLeft(vBox);

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(461.0);
        vBox0.setPrefWidth(96.0);
        borderPane.setRight(vBox0);

        BorderPane.setAlignment(player1InfoPane, javafx.geometry.Pos.CENTER);
        player1InfoPane.setPrefHeight(129.0);
        player1InfoPane.setPrefWidth(600.0);

        imgViewPlayer1Image.setFitHeight(67.0);
        imgViewPlayer1Image.setFitWidth(65.0);
        imgViewPlayer1Image.setLayoutX(502.0);
        imgViewPlayer1Image.setLayoutY(13.0);
        imgViewPlayer1Image.setPickOnBounds(true);
        imgViewPlayer1Image.setPreserveRatio(true);
   

        labelPlayer1Name.setEllipsisString("");
        labelPlayer1Name.setLayoutX(235.0);
        labelPlayer1Name.setLayoutY(17.0);
        labelPlayer1Name.setMaxWidth(351.0);
        labelPlayer1Name.setPrefHeight(58.0);
        labelPlayer1Name.setPrefWidth(184.0);
        labelPlayer1Name.setText("Ahmed Eid");
        labelPlayer1Name.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayer1Name.setFont(new Font("Rockwell Italic", 26.0));

        labelPlayer1.setEllipsisString("");
        labelPlayer1.setLayoutX(118.0);
        labelPlayer1.setLayoutY(17.0);
        labelPlayer1.setMaxWidth(351.0);
        labelPlayer1.setPrefHeight(58.0);
        labelPlayer1.setPrefWidth(158.0);
        labelPlayer1.setText("Player 1:");
        labelPlayer1.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayer1.setFont(new Font("Rockwell Italic", 26.0));

        labelPlayer1Score.setEllipsisString("");
        labelPlayer1Score.setLayoutX(221.0);
        labelPlayer1Score.setLayoutY(62.0);
        labelPlayer1Score.setMaxWidth(351.0);
        labelPlayer1Score.setPrefHeight(23.0);
        labelPlayer1Score.setPrefWidth(98.0);
        labelPlayer1Score.setText("6");
        labelPlayer1Score.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayer1Score.setFont(new Font("Rockwell Italic", 26.0));

        labelScore1.setEllipsisString("");
        labelScore1.setLayoutX(118.0);
        labelScore1.setLayoutY(46.0);
        labelScore1.setMaxWidth(351.0);
        labelScore1.setPrefHeight(58.0);
        labelScore1.setPrefWidth(158.0);
        labelScore1.setText("Score: ");
        labelScore1.setTextFill(javafx.scene.paint.Color.WHITE);
        labelScore1.setFont(new Font("Rockwell Italic", 26.0));

        btnSurrunder.setLayoutX(14.0);
        btnSurrunder.setLayoutY(34.0);
        btnSurrunder.setMnemonicParsing(false);
        btnSurrunder.setStyle("-fx-background-color: #1976d2; -fx-background-radius: 50px; -fx-border-color: #ffffff; -fx-border-radius: 50px; -fx-shape: url('Rec.svg');;");
        btnSurrunder.setText("Surrunder ");
        btnSurrunder.setTextFill(javafx.scene.paint.Color.WHITE);
        borderPane.setTop(player1InfoPane);

        BorderPane.setAlignment(player2InfoPane, javafx.geometry.Pos.CENTER);
        player2InfoPane.setPrefHeight(110.0);
        player2InfoPane.setPrefWidth(600.0);

        imgViewPlayer2Image.setFitHeight(67.0);
        imgViewPlayer2Image.setFitWidth(65.0);
        imgViewPlayer2Image.setLayoutX(27.0);
        imgViewPlayer2Image.setLayoutY(16.0);
        imgViewPlayer2Image.setPickOnBounds(true);
        imgViewPlayer2Image.setPreserveRatio(true);
     

        labelPlayer2Name.setEllipsisString("");
        labelPlayer2Name.setLayoutX(300.0);
        labelPlayer2Name.setLayoutY(4.0);
        labelPlayer2Name.setMaxWidth(351.0);
        labelPlayer2Name.setPrefHeight(58.0);
        labelPlayer2Name.setPrefWidth(196.0);
        labelPlayer2Name.setText("Nourhan Omar");
        labelPlayer2Name.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayer2Name.setFont(new Font("Rockwell Italic", 26.0));

        labelPlayer2.setEllipsisString("");
        labelPlayer2.setLayoutX(159.0);
        labelPlayer2.setLayoutY(4.0);
        labelPlayer2.setMaxWidth(351.0);
        labelPlayer2.setPrefHeight(58.0);
        labelPlayer2.setPrefWidth(124.0);
        labelPlayer2.setText("Player 2:");
        labelPlayer2.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayer2.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        labelPlayer2.setFont(new Font("Rockwell Italic", 26.0));

        labelPlayer2Score.setEllipsisString("");
        labelPlayer2Score.setLayoutX(300.0);
        labelPlayer2Score.setLayoutY(62.0);
        labelPlayer2Score.setMaxWidth(351.0);
        labelPlayer2Score.setPrefHeight(32.0);
        labelPlayer2Score.setPrefWidth(64.0);
        labelPlayer2Score.setText("6");
        labelPlayer2Score.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayer2Score.setFont(new Font("Rockwell Italic", 26.0));

        labelScore2.setEllipsisString("");
        labelScore2.setLayoutX(159.0);
        labelScore2.setLayoutY(49.0);
        labelScore2.setMaxWidth(351.0);
        labelScore2.setPrefHeight(58.0);
        labelScore2.setPrefWidth(158.0);
        labelScore2.setText("Score: ");
        labelScore2.setTextFill(javafx.scene.paint.Color.WHITE);
        labelScore2.setFont(new Font("Rockwell Italic", 26.0));
        borderPane.setBottom(player2InfoPane);

        getChildren().add(imgViewBackGround);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        vb00.getChildren().add(imgv00);
        gridPane.getChildren().add(vb00);
        vb01.getChildren().add(imgv01);
        gridPane.getChildren().add(vb01);
        vb02.getChildren().add(imgv02);
        gridPane.getChildren().add(vb02);
        vb10.getChildren().add(imgv10);
        gridPane.getChildren().add(vb10);
        vb11.getChildren().add(imgv11);
        gridPane.getChildren().add(vb11);
        vb12.getChildren().add(imgv12);
        gridPane.getChildren().add(vb12);
        vb20.getChildren().add(imgv20);
        gridPane.getChildren().add(vb20);
        vb21.getChildren().add(imgv21);
        gridPane.getChildren().add(vb21);
        vb22.getChildren().add(imgv22);
        gridPane.getChildren().add(vb22);
        boardPane.getChildren().add(gridPane);
        boardPane.getChildren().add(row1Line);
        boardPane.getChildren().add(row2Line);
        boardPane.getChildren().add(row3Line);
        boardPane.getChildren().add(column1Line);
        boardPane.getChildren().add(column2Line);
        boardPane.getChildren().add(column3Line);
        boardPane.getChildren().add(diag1Line);
        boardPane.getChildren().add(diag2Line);
        player1InfoPane.getChildren().add(imgViewPlayer1Image);
        player1InfoPane.getChildren().add(labelPlayer1Name);
        player1InfoPane.getChildren().add(labelPlayer1);
        player1InfoPane.getChildren().add(labelPlayer1Score);
        player1InfoPane.getChildren().add(labelScore1);
        player1InfoPane.getChildren().add(btnSurrunder);
        player2InfoPane.getChildren().add(imgViewPlayer2Image);
        player2InfoPane.getChildren().add(labelPlayer2Name);
        player2InfoPane.getChildren().add(labelPlayer2);
        player2InfoPane.getChildren().add(labelPlayer2Score);
        player2InfoPane.getChildren().add(labelScore2);
        vboxList = new ArrayList<>();
        linesList = new ArrayList<>();
        labelList = new ArrayList<>();
        imageViewList = new ArrayList<>();
        
   
        getChildren().add(borderPane);
         for (Node node : gridPane.getChildren()) {
            if (node instanceof VBox) {
               vboxList.add((VBox) node );
            }
        }
         
         imageViewList.add(imgv00);
         imageViewList.add(imgv01);   
         imageViewList.add(imgv02);  
         imageViewList.add(imgv10);  
         imageViewList.add(imgv11);  
         imageViewList.add(imgv12);  
         imageViewList.add(imgv20);  
         imageViewList.add(imgv21);
         imageViewList.add(imgv22);  
         
         linesList.add(row1Line);
         linesList.add(row2Line);
         linesList.add(row3Line);
         linesList.add(column1Line);
         linesList.add(column2Line);
         linesList.add(column3Line);
         linesList.add(diag1Line); 
         linesList.add(diag2Line); 
         
         labelList.add(labelPlayer1Score);
         labelList.add(labelPlayer2Score);
        gameController = new LocalGameController(btnSurrunder , imageViewList , linesList , labelList , player1 , player2);
    }
}
