package com.qatestlab.Units.Humans;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.ATTACK;
import static com.qatestlab.Units.ActionType.SHOOT;
import static com.qatestlab.Units.UnitType.HUMANARCHER;

@Getter
@Setter
public class HumanArcher extends Unit {

    private final int ATTACK_SKILL = 3;
    private final int SHOOT_SKILL = 5;

    private int attackDamage;
    private int shootDamage;

    public HumanArcher () {
        this.setAttackDamage(ATTACK_SKILL);
        this.setShootDamage(SHOOT_SKILL);
        this.setType(HUMANARCHER);
        Action attack = (enemy) -> enemy.takeDamage((this.isFavour() && this.hasDisease()) ? attackDamage*3/4 :
                this.isFavour() ? attackDamage*3/2 :
                this.hasDisease() ? attackDamage/2 : attackDamage);
        Action shoot = (enemy) -> enemy.takeDamage((this.isFavour() && this.hasDisease()) ? shootDamage*3/4 :
                this.isFavour() ? shootDamage*3/2 :
                this.hasDisease() ? shootDamage/2 : shootDamage);
        this.getActions().put(ATTACK, attack);
        this.getActions().put(SHOOT, shoot);
    }
}
