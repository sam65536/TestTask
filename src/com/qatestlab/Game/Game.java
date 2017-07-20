package com.qatestlab.Game;

import com.qatestlab.Units.Elves.ElfArcher;
import com.qatestlab.Units.Elves.ElfWarrior;
import com.qatestlab.Units.Elves.ElfWizard;
import com.qatestlab.Units.Humans.HumanArcher;
import com.qatestlab.Units.Humans.HumanWarrior;
import com.qatestlab.Units.Humans.HumanWizard;
import com.qatestlab.Units.Orcs.OrcArcher;
import com.qatestlab.Units.Orcs.OrcHoblin;
import com.qatestlab.Units.Orcs.OrcShaman;
import com.qatestlab.Units.Undeads.Hunter;
import com.qatestlab.Units.Undeads.Necromancer;
import com.qatestlab.Units.Undeads.Zombie;
import com.qatestlab.Units.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static StringBuilder logger = new StringBuilder();

    private static Team firstTeam = new Team();
    private static Team secondTeam = new Team();

    public static Game create() {
        Game game = new Game();

        List<Unit> elves;
        List<Unit> orcs;
        List<Unit> humans;
        List<Unit> undeads;
        int firstMove;

        int gameScenario = new Random().nextInt(4) + 1;

        switch (gameScenario) {
            case 1:
                elves = createElvesТroop();
                orcs = createOrcsТroop();
                firstMove = new Random().nextInt(2);
                firstTeam.setAllies((firstMove == 0) ? elves : orcs);
                firstTeam.setEnemies((firstMove == 0) ? orcs : elves);
                secondTeam.setAllies(firstTeam.getEnemies());
                secondTeam.setEnemies(firstTeam.getAllies());
                break;
            case 2:
                elves = createElvesТroop();
                undeads = createUndeadsТroop();
                firstMove = new Random().nextInt(2);
                firstTeam.setAllies((firstMove == 0) ? elves : undeads);
                firstTeam.setEnemies((firstMove == 0) ? undeads : elves);
                secondTeam.setAllies(firstTeam.getEnemies());
                secondTeam.setEnemies(firstTeam.getAllies());
                break;
            case 3:
                humans = createHumansТroop();
                orcs = createOrcsТroop();
                firstMove = new Random().nextInt(2);
                firstTeam.setAllies((firstMove == 0) ? humans : orcs);
                firstTeam.setEnemies((firstMove == 0) ? orcs : humans);
                secondTeam.setAllies(firstTeam.getEnemies());
                secondTeam.setEnemies(firstTeam.getAllies());
                break;
            case 4:
                humans = createHumansТroop();
                undeads = createUndeadsТroop();
                firstMove = new Random().nextInt(2);
                firstTeam.setAllies((firstMove == 0) ? humans : undeads);
                firstTeam.setEnemies((firstMove == 0) ? undeads : humans);
                secondTeam.setAllies(firstTeam.getEnemies());
                secondTeam.setEnemies(firstTeam.getAllies());
                break;
        }
        return game;
    }

    public boolean isOver() {
        return  (firstTeam.getEnemies().size() == 0) || (secondTeam.getEnemies().size() == 0)
                || (firstTeam.getAllies().size() == 0)  || (secondTeam.getAllies().size() == 0);
    }

    public static Team getFirstTeam() {
        return firstTeam;
    }

    public static Team getSecondTeam() {
        return secondTeam;
    }

    private Game() {
    }

    private static List<Unit> createElvesТroop() {
        List<Unit> elves = new ArrayList<>();
        elves.add(new ElfWizard());
        for (int i=0; i<3; i++) {
            elves.add(new ElfArcher());
        }
        for (int i=0; i<4; i++) {
            elves.add(new ElfWarrior());
        }
        return elves;
    }

    private static List<Unit> createHumansТroop() {
        List<Unit> humans = new ArrayList<>();
        humans.add(new HumanWizard());
        for (int i=0; i<3; i++) {
            humans.add(new HumanArcher());
        }
        for (int i=0; i<4; i++) {
            humans.add(new HumanWarrior());
        }
        return humans;
    }

    private static List<Unit> createOrcsТroop() {
        List<Unit> orcs = new ArrayList<>();
        orcs.add(new OrcShaman());
        for (int i=0; i<3; i++) {
            orcs.add(new OrcArcher());
        }
        for (int i=0; i<4; i++) {
            orcs.add(new OrcHoblin());
        }
        return orcs;
    }

    private static List<Unit> createUndeadsТroop() {
        List<Unit> undeads = new ArrayList<>();
        undeads.add(new Necromancer());
        for (int i=0; i<3; i++) {
            undeads.add(new Hunter());
        }
        for (int i=0; i<4; i++) {
            undeads.add(new Zombie());
        }
        return undeads;
    }
}
