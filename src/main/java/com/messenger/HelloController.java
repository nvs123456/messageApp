package com.messenger;

import de.jensd.fx.glyphs.fontawesome.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private double totalHeightOfMessage=0;
    @FXML
    private FontAwesomeIconView phone;
    @FXML
    private FontAwesomeIconView video_camera;
    @FXML
    private FontAwesomeIconView send;
    @FXML
    private FontAwesomeIconView microphone;
    @FXML
    private FontAwesomeIconView image;
    @FXML
    private VBox messageList;
    @FXML
    private TextArea inputMessage;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    protected void sendMessage(MouseEvent event) {
        String message = inputMessage.getText();
        totalHeightOfMessage+=getHeightOfMessage(message);
        if(totalHeightOfMessage>anchorPane.getHeight()){
            anchorPane.setPrefHeight(totalHeightOfMessage+15);
        }
        inputMessage.setText("");
        Label sentMessage = new Label(message);
        messageList.getChildren().add(sentMessage);
        setStyleOfMessage(sentMessage);
        scrollPane.setVvalue(1);
    }
    private double getHeightOfMessage(String mess){
        int lines=1;
        int cur=0;
        for(int i=0;i<mess.length();i++){
            if(cur==27||mess.charAt(i)=='\n'){
                lines++;
                cur=0;
            }else {
                cur++;
            }
        }
        return 30+heightOfLine*lines;
    }
    private final double heightOfLine = 17.3;
    private void setStyleOfMessage(Label message){
        message.setWrapText(true);
        message.setStyle("-fx-background-color:#0084ff;" +
                "-fx-border-radius:17px;" +
                "-fx-background-radius:17px;" +
                "-fx-text-fill:white;" +
                "-fx-padding:10;" +
                "-fx-font-weight:700;");
        message.setMaxWidth(200);
        message.setMinHeight(34);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}