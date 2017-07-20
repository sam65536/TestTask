package com.qatestlab.Units;

import com.qatestlab.Game.Game;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
@Setter
public abstract class Unit {

    private final int HEALTH_CAPACITY = 100;

    private int health = HEALTH_CAPACITY;
    private UnitType type;
    private boolean favour;
    private boolean disease;
    private Map<ActionType, Action> actions = new HashMap<>();

    public ActionType selectAction() {
        ArrayList<ActionType> actionTypesList = new ArrayList<>(actions.keySet());
        int randomIndex = new Random().nextInt(actionTypesList.size());
        ActionType actionType = actionTypesList.get(randomIndex);
        return actionType;
    }

    public void takeDamage(int damage) {
        health -= damage;
        String message = this.isAlive()
                ? this.toString() + " " + "got damage " + damage + "HP..."
                : this.getType() + " " + "got damage " + damage + "HP and died...";
        System.out.println(message);
        Game.logger.append(message + "\n");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isFavour() {
        return favour;
    }

    public boolean hasDisease() {
        return disease;
    }

    @Override
    public String toString() {
        return this.getType().name() + "(" + this.getHealth() + ")";
    }
}
