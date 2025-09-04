import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class GameController {
    private VBox root = new VBox(15);
    private Label statusLabel = new Label("Welcome to Hand Cricket App!");
    private Label scoreLabel = new Label("");
    private HBox buttonRow = new HBox(10);
    private Button restartButton = new Button("Restart");

    private ImageView userHand = new ImageView();
    private ImageView compHand = new ImageView();

    private Label userLabel = new Label("You");
    private Label compLabel = new Label("Computer");

    private GameLogic logic;

    public Scene initUI() {
        logic = new GameLogic(this);

        root.setPadding(new Insets(25));
        root.setAlignment(Pos.CENTER);
        statusLabel.setFont(Font.font("Arial", 18));
        scoreLabel.setFont(Font.font("Arial", 22));
        restartButton.getStyleClass().add("reset-score");
        restartButton.setVisible(false);

        restartButton.setOnAction(e -> logic.resetGame());
        buttonRow.setAlignment(Pos.CENTER);

        HBox handRow = new HBox(50);
        handRow.setAlignment(Pos.CENTER);

        VBox userBox = new VBox(10, userHand, userLabel);
        VBox compBox = new VBox(10, compHand, compLabel);

        userLabel.setFont(Font.font("Arial", 16));
        compLabel.setFont(Font.font("Arial", 16));
        userLabel.setStyle("-fx-text-fill: white;");
        compLabel.setStyle("-fx-text-fill: white;");

        userHand.setFitHeight(80);
        userHand.setFitWidth(80);
        compHand.setFitHeight(80);
        compHand.setFitWidth(80);

        handRow.getChildren().addAll(userBox, compBox);

        root.getChildren().addAll(statusLabel, scoreLabel, handRow, buttonRow, restartButton);

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        logic.startToss();

        return scene;
    }

    public void setStatus(String text) { statusLabel.setText(text); }

    public void setScore(String text) { scoreLabel.setText(text); } 


    public void showButtons(Button... buttons) {  
        buttonRow.getChildren().clear();
        if (buttons.length > 0)
            buttonRow.getChildren().addAll(buttons); 
    }

    public void showRestart(boolean visible) { restartButton.setVisible(visible); }

    public void setUserHandImage(int number) { userHand.setImage(loadHandImage(number)); }

    public void setCompHandImage(int number) { compHand.setImage(loadHandImage(number)); }

    public Image loadHandImage(int number) {  
        // number 0 = defence, hand0.png, 1-6 hand1.png ... hand6.png
        return new Image(getClass().getResourceAsStream("/images/hand" + number + ".png"));
    }
}

