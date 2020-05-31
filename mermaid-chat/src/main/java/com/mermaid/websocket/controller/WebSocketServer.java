package com.mermaid.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/imserver/{userId}")
public class WebSocketServer {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private Session session;

    private String userId = "";

    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
        }

        webSocketMap.put(userId,this);

        logger.info("用户{}已连接",userId);

        try {
            sendMessage("连接成功");
        } catch (Exception e) {
            logger.error("连接异常",e);
        }
    }

    @OnClose
    public void onClose() {
        webSocketMap.remove(userId);
    }

    @OnMessage
    public void onMessage(String message,Session session) {

    }

    private void sendMessage(String message) throws Exception {
    }
}
