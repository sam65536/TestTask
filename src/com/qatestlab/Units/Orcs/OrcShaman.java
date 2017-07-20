package com.qatestlab.Units.Orcs;

import com.qatestlab.Units.Action;
import com.qatestlab.Units.Unit;
import lombok.Getter;
import lombok.Setter;

import static com.qatestlab.Units.ActionType.CURSE;
import static com.qatestlab.Units.ActionType.UPGRADE;
import static com.qatestlab.Units.UnitType.ORCSHAMAN;

@Getter
@Setter
public class OrcShaman extends Unit {

    public OrcShaman () {
        this.setType(ORCSHAMAN);
        Action upgrade = (ally) -> ally.setFavour(true);
        Action curse = (enemy) -> enemy.setFavour(false);
        this.getActions().put(UPGRADE, upgrade);
        this.getActions().put(CURSE, curse);
    }
}
