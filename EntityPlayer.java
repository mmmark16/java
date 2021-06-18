package com.company;

public class EntityPlayer extends Entity {
    String nickname;
    public void update() {
        if (GameServer.getInstance().getServerTicks()%2 == 0 && this.health < this.maxHealth) {
            this.health++;
        }
    }

    public EntityPlayer(String title, double posX, double posZ, int maxHealth, int health, int attackDamage, String nickname, World serverWorld) {
        super(title, posX, posZ, false, maxHealth, health, attackDamage, serverWorld);
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "EntityPlayer{" +
                "maxHealth=" + maxHealth +
                ", health=" + health +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}