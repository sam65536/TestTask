package com.qatestlab.Units.Orcs;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.ATTACK;
import static com.qatestlab.Units.UnitType.ORCHOBLIN;

@Getter
@Setter
public class OrcHoblin extends Unit {

    private final int ATTACK_SKILL = 20;

    private int attackDamage;

    public OrcHoblin () {
        this.setAttackDamage(ATTACK_SKILL);
        this.setType(ORCHOBLIN);
        Action attack = (enemy) -> enemy.takeDamage(this.isFavour() ? attackDamage*3/2 : attackDamage);
        this.getActions().put(ATTACK, attack);
    }
}
