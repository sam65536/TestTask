package com.qatestlab.Units.Undeads;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.ATTACK;
import static com.qatestlab.Units.UnitType.ZOMBIE;

@Getter
@Setter
public class Zombie extends Unit {

    private final int ATTACK_SKILL = 18;

    private int attackDamage;

    public Zombie () {
        this.setAttackDamage(ATTACK_SKILL);
        this.setType(ZOMBIE);
        Action attack = (enemy) -> enemy.takeDamage(attackDamage);
        this.getActions().put(ATTACK, attack);
    }
}
