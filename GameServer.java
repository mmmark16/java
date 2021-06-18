package com.company;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private static GameServer instance;
    private String ip;
    private int difficulty;
    World serverWorld;
    int serverTicks;

    public void updateServer(){
        serverWorld.updateWorld();
        serverTicks++;
    }

    public static void main(String[] args){
        new GameServer();
    }

    private GameServer() {
        instance = this;

        ip = "123.345.678";

        difficulty = 1;
        List<Entity> entities = new ArrayList<>();
        serverWorld = new World(1, "ABOBUS", entities);

        Entity Zombie = new Entity("Zombie", 0, 0, true, 140, 140, 10, serverWorld);
        Entity Skeleton = new Entity("Skeleton", 5,5, true, 80, 80, 10, serverWorld);
        Entity Pig = new Entity("Pig", 3, 3, false, 20, 20, 0, serverWorld);
        Entity Human = new EntityPlayer("Human", 1, 1, 100, 100, 20, "mvp44", serverWorld);
        entities.add(Zombie);
        entities.add(Skeleton);
        entities.add(Pig);
        entities.add(Human);


        System.out.println(getInstance());
        while (serverTicks < 100) updateServer();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static GameServer getInstance() {
        return instance;
    }

    public static void setInstance(GameServer instance) {
        GameServer.instance = instance;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public World getServerWorld() {
        return serverWorld;
    }

    public int getServerTicks() {
        return serverTicks;
    }

    @Override
    public String toString() {
        return "GameServer{" +
                "ip='" + ip + '\'' +
                ", difficulty=" + difficulty +
                ", serverWorld=" + serverWorld +
                ", serverTicks=" + serverTicks +
                '}';
    }
}