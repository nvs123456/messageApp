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
    private LinkedList<Double> heightsOfMessage=new LinkedList<>();
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
    protected void sendMessage(MouseEvent event) {
        String message = inputMessage.getText();
        inputMessage.setText("");
        Label sentMessage = new Label(message);
        messageList.getChildren().add(sentMessage);
        setStyleOfMessage(sentMessage);
        heightsOfMessage.addLast(sentMessage.getHeight());
        System.out.println("message list :"+messageList.getHeight());
        Platform.runLater(()->{
            System.out.println(sentMessage.getText());
            System.out.println("sent message : "+sentMessage.getHeight());
            System.out.println(sentMessage.getPrefHeight());
        });
        System.out.println("total height : "+totalHeightOfMessage);


    }
    private void setStyleOfMessage(Label message){
        message.setWrapText(true);
        message.setStyle("-fx-background-color:#0084ff;" +
                "-fx-border-radius:17px;" +
                "-fx-background-radius:17px;" +
                "-fx-text-fill:white;" +
                "-fx-padding:10;" +
                "-fx-font-weight:700;");
        message.setMaxWidth(150);
        message.setMinHeight(34);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}