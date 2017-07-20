package com.qatestlab.Units.Undeads;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.*;
import static com.qatestlab.Units.UnitType.NECROMANCER;

@Getter
@Setter
public class Necromancer extends Unit {

    private final int ATTACK_SKILL = 5;

    private int attackDamage;

    public Necromancer () {
        this.setAttackDamage(ATTACK_SKILL);
        this.setType(NECROMANCER);
        Action disease = (enemy) -> enemy.setDisease(true);
        Action attack = (enemy) -> enemy.takeDamage(attackDamage);
        this.getActions().put(DISEASE, disease);
        this.getActions().put(ATTACK, attack);
    }
}
