package com.interviewprep.lld.battleship.input;

import com.interviewprep.lld.battleship.exceptions.InvalidInputException;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SysInputProvider implements InputProvider {


    @Override
    @SneakyThrows
    public PlayerInput takeInput() {
        try {
            final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            final BufferedReader br = new BufferedReader(inputStreamReader);
            final String line = br.readLine();

            //FutureImprovement: We can move this string line parsing logic to separate class when multiple input types are
            //supported.
            String[] s = line.split(" ");
            if (s.length != 3) {
                throw new InvalidInputException();
            }

            final int playerNum = Integer.parseInt(s[0]);
            final int targetX = Integer.parseInt(s[1]);
            final int targetY = Integer.parseInt(s[2]);

            return new PlayerInput(playerNum, targetX, targetY);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
