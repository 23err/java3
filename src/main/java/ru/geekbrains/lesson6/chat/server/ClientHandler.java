package ru.geekbrains.lesson6.chat.server;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {
    private static Logger log = Logger.getLogger(ClientHandler.class);
    private Server server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;

    List<String> blackList;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.blackList = new ArrayList<>();
            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth")) { // /auth login72 pass72
                            String[] tokens = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                            if (newNick != null) {
                                if (!server.isNickBusy(newNick)) {
                                    sendMsg("/authok");
                                    nick = newNick;
                                    server.subscribe(this);
                                    break;
                                } else {
                                    sendMsg("Учетная запись уже используется");
                                    log.info("Попытка зарегистрировать существующую учетную запись");
                                }
                            } else {
                                sendMsg("Неверный логин/пароль");
                                log.info("Неверный логин или пароль");
                            }
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/")) {
                            if (str.equals("/end")) {
                                out.writeUTF("/serverclosed");
                                break;
                            }
                            if (str.startsWith("/w ")) { // /w nick3 lsdfhldf sdkfjhsdf wkerhwr
                                String[] tokens = str.split(" ", 3);
                                String m = str.substring(tokens[1].length() + 4);
                                server.sendPersonalMsg(this, tokens[1], tokens[2]);
                            }
                            if (str.startsWith("/blacklist ")) { // /blacklist nick3
                                String[] tokens = str.split(" ");
                                blackList.add(tokens[1]);
                                sendMsg("Вы добавили пользователя " + tokens[1] + " в черный список");
                                log.info("Пользователь " + tokens[1] + " добавлен в черный список");
                            }
                        } else {
                            server.broadcastMsg(this, nick + ": " + str);
                        }
                        log.info("Client: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        log.log(Level.WARN, "Что-то пошло не так", e);
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        log.log(Level.WARN, "Что-то пошло не так", e);
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        log.log(Level.WARN, "Что-то пошло не так", e);
                    }
                    server.unsubscribe(this);
                }
            }).start();
        } catch (Exception e) {
            log.log(Level.WARN, "Что-то пошло не так", e);
        }
    }

    public boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            log.log(Level.WARN, "Что-то пошло не так", e);
        }
    }
}
