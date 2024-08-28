package com.example.shiptracking.service;



import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.example.shiptracking.service.MessageParse;

/**
 * This example demonstrates how to create a websocket connection to a server. Only the most
 * important callbacks are overloaded.
 */
public class AisStreamWebSocketClient extends WebSocketClient {

    public AisStreamWebSocketClient(URI serverURI) {
        super(serverURI);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        // send subscription message upon connection
        send("{\"APIKey\":\"97bc2d0359b033cb9e1b46df5dcf78e4885dcd78\",\"BoundingBoxes\":[[[-90,-180],[90,180]]]}");
    }


    @Override
    public void onMessage(ByteBuffer message) {
        String jsonString = StandardCharsets.UTF_8.decode(message).toString();

        MessageParse.parseMessage(jsonString);
    }

    @Override
    public void onMessage(String message) {
        // unused as aisstream.io returns messages as byte buffers
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        // The close codes are documented in class org.java_websocket.framing.CloseFrame
        System.out.println(
                "Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: "
                        + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}