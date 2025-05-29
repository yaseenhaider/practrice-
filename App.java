import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.HashMap;

// KnowledgeBase class to store and fetch answers
class KnowledgeBase {
    private HashMap<String, String> faq;

    public KnowledgeBase() {
        faq = new HashMap<>();
        loadQuestions();
    }

    private void loadQuestions() {
        faq.put("what is the fee for bscs", "The fee for BSCS is $500 per semester.");
        faq.put("what is the timing of library", "The library is open from 8 AM to 8 PM.");
        faq.put("who is the dean of it", "Dr. Ahmed is the Dean of the IT department.");
        faq.put("when does semester start", "The semester starts on September 1st.");
        faq.put("how to register for courses", "You can register through the student portal using your ID.");
    }

    public String findAnswer(String question) {
        question = question.toLowerCase().trim();
        return faq.getOrDefault(question, "Sorry, I don't understand your question.");
    }
}

// ChatBot class
class ChatBot {
    private KnowledgeBase kb;

    public ChatBot() {
        kb = new KnowledgeBase();
    }

    public String getResponse(String input) {
        return kb.findAnswer(input);
    }
}

// Main GUI class
public class CollegeChatBotFX extends Application {
    private ChatBot bot = new ChatBot();
    private TextArea chatArea = new TextArea();
    private TextField userInput = new TextField();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AI Chatbot - College Assistant");

        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        userInput.setPromptText("Ask your question here...");

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> handleUserInput());

        userInput.setOnAction(e -> handleUserInput()); // Press Enter to send

        HBox inputBox = new HBox(10, userInput, sendButton);
        VBox root = new VBox(10, chatArea, inputBox);
        root.setStyle("-fx-padding: 10;");

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleUserInput() {
        String input = userInput.getText();
        if (input.isEmpty()) return;

        chatArea.appendText("You: " + input + "\n");
        String response = bot.getResponse(input);
        chatArea.appendText("Bot: " + response + "\n\n");

        userInput.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
