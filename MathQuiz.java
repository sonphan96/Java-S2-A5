
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import javafx.event.ActionEvent;
import java.util.Random;

/**
 * This is a application which can check your ability to calculate.
 * This app also keep track on right and wrong answer.
 * @author Son Phan
 */
public class MathQuiz extends Application {

    // TODO: Instance Variables for View Components and Model
    private MathModel model;
    Label numb1, numb2, rightAnswer, wrongAnswer, plusSign, equalSign, title;
    Button okButton;
    TextField userInput;
    int rightScore = 0;
    int wrongScore = 0;
    int n1, n2;
    Random random = new Random();

    // TODO: Private Event Handlers and Helper Methods
    private void okButtonHandler(ActionEvent e){
        int answer = Integer.parseInt(userInput.getText());
        if(model.compare(n1, n2, answer))
        {
            rightScore++;
            rightAnswer.setText(String.valueOf(rightScore));
        }
        else {
            wrongScore++;
            wrongAnswer.setText(String.valueOf(wrongScore));
        }

        n1 = random.nextInt(21);
        n2 = random.nextInt(21);

        numb1.setText(String.valueOf(n1));
        numb2.setText(String.valueOf(n2));

        userInput.requestFocus();
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 200); // set the size here
        stage.setTitle("Math Quiz"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model

        n1 = random.nextInt(21);
        n2 = random.nextInt(21);
        model = new MathModel();

        // 2. Create the GUI components
        numb1 = new Label(String.valueOf(n1));
        numb2 = new Label(String.valueOf(n2));
        plusSign = new Label("+");
        equalSign = new Label("=");
        title = new Label("Math quiz");
        rightAnswer = new Label(String.valueOf(rightScore));
        wrongAnswer = new Label(String.valueOf(wrongScore));

        okButton = new Button("Ok");

        userInput = new TextField("");


        // 3. Add components to the root
        root.getChildren().addAll(numb1, numb2, plusSign, equalSign, title,
                rightAnswer, wrongAnswer, okButton, userInput);

        // 4. Configure the components (colors, fonts, size, location)
        title.relocate(10,10);
        title.setFont(new Font("System", 20));

        rightAnswer.relocate(150,20);
        rightAnswer.setFont(new Font("System", 20));
        rightAnswer.setStyle("-fx-text-fill: darkblue;");

        wrongAnswer.relocate(200,20);
        wrongAnswer.setFont(new Font("System",20));
        wrongAnswer.setStyle("-fx-text-fill: darkred;");

        numb1.relocate(10,100);
        numb1.setFont(new Font("System", 30));

        plusSign.relocate(50,100);
        plusSign.setFont(new Font("System", 30));

        numb2.relocate(90,100);
        numb2.setFont(new Font("System", 30));

        equalSign.relocate(130,100);
        equalSign.setFont(new Font("System",30));

        userInput.relocate(160,105);
        userInput.setPrefWidth(40);
        okButton.relocate(230,105);


        // 5. Add Event Handlers and do final setup
        okButton.setOnAction(this::okButtonHandler);

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
