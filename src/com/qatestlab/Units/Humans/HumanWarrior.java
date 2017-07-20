package com.qatestlab.Units.Humans;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.ATTACK;
import static com.qatestlab.Units.UnitType.HUMANWARRIOR;

@Getter
@Setter
public class HumanWarrior extends Unit {

    private final int ATTACK_SKILL = 18;

    private int attackDamage;

    public HumanWarrior () {
        this.setAttackDamage(ATTACK_SKILL);
        this.setType(HUMANWARRIOR);
        Action attack = (enemy) -> enemy.takeDamage((this.isFavour() && this.hasDisease()) ? attackDamage*3/4 :
                this.isFavour() ? attackDamage*3/2 :
                this.hasDisease() ? attackDamage/2 : attackDamage);
        this.getActions().put(ATTACK, attack);
    }
}
