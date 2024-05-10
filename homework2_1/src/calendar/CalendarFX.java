package calendar;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class CalendarFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 425, 175);

// the two dialogs from which we will input information:
        TextInputDialog idMonth = new TextInputDialog();
        idMonth.setTitle("Input the number of the month");
        idMonth.setHeaderText("Input is between 1-12 with 1 standing for January");
        idMonth.setContentText("Month: ");
        String strMonth = idMonth.showAndWait().get();
        int month = Integer.parseInt(strMonth);
        if( month < 1 || month > 12 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Invalid month!");
            alert.showAndWait();
            System.exit(0);
        }

        TextInputDialog idYear = new TextInputDialog();
        idYear.setTitle("Input the year");
        idYear.setHeaderText("Only years after Christ");
        idYear.setContentText("Year: ");
        String strYear = idYear.showAndWait().get();
        int year = Integer.parseInt(strYear);
        if (year <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Invalid year!");
            alert.showAndWait();
            System.exit(0);
        }

        // getting date
        LocalDate today = LocalDate.now();
        LocalDate chosenDate = LocalDate.of(year, month, 1);

        LocalDate lastOfMonth = chosenDate.with(TemporalAdjusters.lastDayOfMonth());
        Month monthS = chosenDate.getMonth();
        DayOfWeek weekDay = chosenDate.getDayOfWeek();
        int daysInMonth = lastOfMonth.getDayOfMonth();
        int weekday = weekDay.getValue();

        int currentDate = 1;
        int distanceFromBorder = 25;
        int colSize = 50;
        for (int i = 1; i <= 7; i++) {
            Text text1 = new Text(colSize * i, distanceFromBorder, getDays(i));
            group.getChildren().add(text1);
        }
        for (int row = 1; row <= 6; row++) {
            distanceFromBorder += 25;
            for (int col = 0; col < 7; col++) {
                if (currentDate > daysInMonth) {
                    break;
                }
                Text text2 = new Text(weekday * colSize, distanceFromBorder, String.format("%d", currentDate));
                //formatting today's date in red
                if (chosenDate.getYear() == today.getYear() && chosenDate.getMonth() == today.getMonth() && currentDate == today.getDayOfMonth()) {
                    text2.setFill(Color.RED);
                }
                currentDate++;
                weekday++;
                group.getChildren().add(text2);
                if (weekday == 8) {
                    weekday = 1;
                    break;
                }
            }
        }

        stage.setTitle("Calendar for " + monthS  + " " + year);
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    public String getDays(int number) {
        switch (number) {
            case 1:
                return "MON";
            case 2:
                return "TUE";
            case 3:
                return"WED";
            case 4:
                return "THR";
            case 5:
                return "FRI";
            case 6:
                return "SAT";
            case 7:
                return "SUN";
            default:
                return "NULL";

        }
    }
}
