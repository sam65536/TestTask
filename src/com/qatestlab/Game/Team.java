package com.qatestlab.Game;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.ActionType;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.qatestlab.Units.ActionType.UPGRADE;

@Getter
@Setter
public class Team {

    private List<Unit> allies;
    private List<Unit> enemies;

    public void unitsMove(List<Unit> units) {
        for (Unit unit : units) {
            if (enemies.size() == 0) {
                break;
            }
            ActionType actionType = unit.selectAction();
            if (actionType != UPGRADE) {
                int randomIndex = new Random().nextInt(enemies.size());
                Unit target = enemies.get(randomIndex);
                Action action = unit.getActions().get(actionType);
                String message = unit.toString() + " " + actionType.name() + " " + target.toString();
                System.out.println(message);
                Game.logger.append(message + "\n");
                action.move(target);
                unit.setFavour(false);
                unit.setDisease(false);
                if (!target.isAlive()) {
                    enemies.remove(target);
                }
            } else {
                int randomIndex = new Random().nextInt(allies.size());
                Unit target = allies.get(randomIndex);
                Action action = unit.getActions().get(actionType);
                String message = unit.toString() + " " + actionType.name() + " " + target.toString();
                System.out.println(message);
                Game.logger.append(message + "\n");
                action.move(target);
                if (unit != target) {
                    unit.setFavour(false);
                }
                unit.setDisease(false);
            }
        }
    }

    public void turn() {
        List<Unit> favourGroup = new ArrayList<>();
        List<Unit> simpleGroup = new ArrayList<>();
        allies.forEach(unit -> {
            if (unit.isFavour()) {
                favourGroup.add(unit);
            } else simpleGroup.add(unit);
        });
        Collections.shuffle(favourGroup);
        unitsMove(favourGroup);
        Collections.shuffle(simpleGroup);
        unitsMove(simpleGroup);
    }
}
