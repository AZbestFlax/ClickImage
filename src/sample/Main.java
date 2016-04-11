package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        List<Rectangle> el = new ArrayList<>();

        BorderPane root = new BorderPane();
        primaryStage.setTitle("GS");

        Group pane = new Group();
        ImageView img = new ImageView("sample/bgd.jpg");
        pane.getChildren().add(img);

        HBox hBox = new HBox();

        Label label = new Label("X: 000; Y: 000");
        label.setPrefWidth(125);
        hBox.getChildren().add(label);

        Button btnForTest = new Button("Test Action");
        btnForTest.setOnAction( (ae) -> {
            for (Rectangle r: el) {
                pane.getChildren().add(r);
            }
        } );
        hBox.getChildren().add(btnForTest);

        root.setBottom(hBox);

        ObservableList<String> list = FXCollections.observableArrayList("Am", "Dm", "Cm");
        list.add("F");


        root.setCenter(pane);
        root.setAlignment(img, Pos.TOP_LEFT);

        final int wRectalgle = 20;

        root.setOnMouseClicked( (ae) -> {
            if ( ae.getButton().equals(MouseButton.PRIMARY) ) {
                String s = "X: " + ae.getX() + "; Y: " + ae.getY();
                label.setText(s);
                list.add(s);

                Rectangle r = new Rectangle();
                r.setX(ae.getX()-125 - wRectalgle/2);
                r.setY(ae.getY() - wRectalgle/2);
                r.setWidth(wRectalgle);
                r.setHeight(wRectalgle);
                //pane.getChildren().add(r);
                el.add(r);
            } else {
                list.clear();
            }
        } );

        ListView<String> accords = new ListView<>(list);
        accords.setPrefWidth(125);
        root.setLeft(accords);

        primaryStage.setScene(new Scene(root, img.getImage().getWidth() + 125, 480 + 30));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
