package com.qatestlab.Units.Undeads;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.ATTACK;
import static com.qatestlab.Units.ActionType.SHOOT;
import static com.qatestlab.Units.UnitType.HUNTER;

@Getter
@Setter
public class Hunter extends Unit {

    private final int ATTACK_SKILL = 2;
    private final int SHOOT_SKILL = 4;

    private int attackDamage;
    private int shootDamage;

    public Hunter () {
        this.setAttackDamage(ATTACK_SKILL);
        this.setShootDamage(SHOOT_SKILL);
        this.setType(HUNTER);
        Action attack = (enemy) -> enemy.takeDamage(attackDamage);
        Action shoot = (enemy) -> enemy.takeDamage(shootDamage);
        this.getActions().put(ATTACK, attack);
        this.getActions().put(SHOOT, shoot);
    }
}
