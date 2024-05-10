package fibonacci;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class fibonacciSquareSpiral extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group group = new Group();
        int sceneSize = 480;
        Scene scene = new Scene(group, sceneSize, sceneSize);

        double startHeight = sceneSize / 12.0;
        double startWidth = sceneSize / 12.0;
        double currentPositionX = sceneSize / 2.0;
        double currentPositionY = sceneSize / 2.0;

        //looping and drawing the centerToRight, centerToLeft, centerToUp and centerToDown lines
        for (int i = 0; i < 20; i++) {
            int c = i % 4;
            switch (c) {
                case 0:
                    drawLine(group, currentPositionX, currentPositionY, currentPositionX, currentPositionY + startHeight, Color.LIGHTCORAL);
                    currentPositionY += startHeight;
                    startHeight += sceneSize / 12.0;
                    break;
                case 1:
                    drawLine(group, currentPositionX, currentPositionY, currentPositionX - startWidth, currentPositionY, Color.LIGHTCORAL);
                    currentPositionX -= startWidth;
                    startWidth += sceneSize / 12.0;
                    break;
                case 2:
                    drawLine(group, currentPositionX, currentPositionY, currentPositionX, currentPositionY - startHeight, Color.LIGHTCORAL);
                    currentPositionY -= startHeight;
                    startHeight += sceneSize / 12.0;
                    break;
                case 3:
                    drawLine(group, currentPositionX, currentPositionY, currentPositionX + startWidth, currentPositionY, Color.LIGHTCORAL);
                    currentPositionX += startWidth;
                    startWidth += sceneSize / 12.0;
                    break;
            }
        }

        stage.setTitle("Draw square shaped spiral");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void drawLine(Group group, double startX, double startY, double endX, double endY, Color color) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(color);
        line.setStrokeWidth(3);
        group.getChildren().add(line);
    }
}

