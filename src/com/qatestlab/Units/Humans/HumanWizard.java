package com.qatestlab.Units.Humans;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.ATTACK;
import static com.qatestlab.Units.ActionType.UPGRADE;
import static com.qatestlab.Units.UnitType.HUMANWIZARD;

@Getter
@Setter
public class HumanWizard extends Unit {

    private final int ATTACK_SKILL = 4;

    private int attackDamage;

    public HumanWizard () {
        this.setAttackDamage(ATTACK_SKILL);
        this.setType(HUMANWIZARD);
        Action attack = (enemy) -> enemy.takeDamage((this.isFavour() && this.hasDisease()) ? attackDamage*3/4 :
                this.isFavour() ? attackDamage*3/2 :
                this.hasDisease() ? attackDamage/2 : attackDamage);
        Action upgrade = (ally) -> ally.setFavour(true);
        this.getActions().put(ATTACK, attack);
        this.getActions().put(UPGRADE, upgrade);
    }
}
