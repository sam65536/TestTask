package com.qatestlab;

import com.qatestlab.Game.Game;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Game game = Game.create();

        do {
            game.getFirstTeam().turn();
            System.out.println();
            Game.logger.append("\n");
            game.getSecondTeam().turn();
            System.out.println();
            Game.logger.append("\n");
        } while (!game.isOver());

        try (FileOutputStream fileOutputStream = new FileOutputStream("game.log")) {
            byte[] buffer = Game.logger.toString().getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch(IOException ex) {}
    }
}
