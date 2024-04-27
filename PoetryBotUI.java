import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PoetryBotUI extends Application {
    private PoetryBot poetryBot;
    private TextArea outputTextArea;

    public PoetryBotUI() {
        this.poetryBot = new PoetryBot();
        this.outputTextArea = new TextArea();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Poet Bot");
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(400);

        Button huzunluButton = new Button("Hüzünlü Şiir Oluştur");
        huzunluButton.setOnAction(e -> {
            String huzunluSiir = poetryBot.huzunluSiirOlustur();
            outputTextArea.appendText("Hüzünlü Şiir:\n" + huzunluSiir + "\n\n\n\n");
        });

        Button askButton = new Button("Aşk Şiiri Oluştur");
        askButton.setOnAction(e -> {
            String askSiiri = poetryBot.askSiiriOlustur();
            outputTextArea.appendText("Aşk Şiiri:\n" + askSiiri + "\n\n\n\n");
        });

        Button saveButton = new Button("Şiiri Kaydet");
        saveButton.setOnAction(e -> {
            String siir = outputTextArea.getText();
            if (!siir.isEmpty()) {
                saveSiir(siir);
            }
        });

        Button openButton = new Button("Şiir Aç");
        openButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Şiir Seç");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PoetryBot Dosyası", "*.pbot"));
            File file = fileChooser.showOpenDialog(null);

            if (file != null) {
                try {
                    String siir = new String(Files.readAllBytes(file.toPath()));
                    outputTextArea.setText(siir);
                } catch (IOException ex) {
                    outputTextArea.setText("\nHata: Şiir açılamadı.\n\n");
                    ex.printStackTrace();
                }
            }
        });

        Button clearButton = new Button("Konsolu Temizle");
        clearButton.setOnAction(e -> outputTextArea.clear());

        Button themeButton = new Button("Tema Değiştir: Açık");
        themeButton.setOnAction(e -> {
            if (themeButton.getText().equals("Tema Değiştir: Açık")) {
                outputTextArea.setStyle("-fx-control-inner-background: #1C1C1C; -fx-text-fill: #ffffff;");
                themeButton.setText("Tema Değiştir: Koyu");
            } else {
                outputTextArea.setStyle("-fx-control-inner-background: #ffffff; -fx-text-fill: #1C1C1C;");
                themeButton.setText("Tema Değiştir: Açık");
            }
        });

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(huzunluButton, askButton, saveButton, openButton, clearButton, themeButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setCenter(outputTextArea);

        Scene scene = new Scene(borderPane, 640, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveSiir(String siir) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Şiiri Kaydet");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PoetryBot Dosyası", "*.pbot"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try {
                Files.write(file.toPath(), siir.getBytes());
                outputTextArea.appendText("\nŞiir başarıyla kaydedildi: " + file.getAbsolutePath() + "\n\n");
            } catch (IOException e) {
                outputTextArea.appendText("\nHata: Şiir kaydedilemedi.\n\n");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
