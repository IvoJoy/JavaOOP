package illusion;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.ORANGE;


public class Image extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        int sceneHeight = 500;
        int sceneLength = 600;
        int partitionHeight = sceneHeight/20;
        int partitionLength = sceneLength/20;
        Scene scene = new Scene(group, sceneLength, sceneHeight);
        // creating a rectangle (because with a square it is a lot easier and we don't want easy)


        // TODO  Type code for Java FX drawing objects
        // looping trough i and j (they will finish at the same time (reaching 500 and 600))
        for (int i=0, j=0; i<=sceneLength; i+=partitionLength, j+=partitionHeight)
        {
            Line leftDown = new Line(0,j,i,sceneHeight);
            group.getChildren().add(leftDown);
            leftDown.setStroke(ORANGE);

            Line leftUp = new Line(0,sceneHeight-j,i,0);
            group.getChildren().add(leftUp);
            leftUp.setStroke(ORANGE);

            Line rightUp = new Line(sceneLength,j,i,0);
            group.getChildren().add(rightUp);
            rightUp.setStroke(ORANGE);

            Line rightDown = new Line(sceneLength,j,sceneLength-i,sceneHeight);
            group.getChildren().add(rightDown);
            rightDown.setStroke(ORANGE);
        }

        // end TODO
        stage.setTitle("Canvas Demo"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
