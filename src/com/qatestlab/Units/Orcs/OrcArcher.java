package com.qatestlab.Units.Orcs;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.ATTACK;
import static com.qatestlab.Units.ActionType.SHOOT;
import static com.qatestlab.Units.UnitType.ORCARCHER;

@Getter
@Setter
public class OrcArcher extends Unit {

    private final int ATTACK_SKILL = 2;
    private final int SHOOT_SKILL = 3;

    private int attackDamage;
    private int shootDamage;

    public OrcArcher () {
        this.setAttackDamage(ATTACK_SKILL);
        this.setShootDamage(SHOOT_SKILL);
        this.setType(ORCARCHER);
        Action attack = (enemy) -> enemy.takeDamage(this.isFavour() ? attackDamage*3/2 : attackDamage);
        Action shoot = (enemy) -> enemy.takeDamage(this.isFavour() ? shootDamage*3/2 : shootDamage);
        this.getActions().put(ATTACK, attack);
        this.getActions().put(SHOOT, shoot);
    }
}
