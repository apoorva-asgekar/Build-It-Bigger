package com.example;

import java.util.HashMap;
import java.util.Random;

public class JokeGenerator {

    private static HashMap<Integer, String> jokeMap = new HashMap<>();

    public static String getJoke() {
        createJokeMap();
        int randomJokeNum = getRandomInt();
        String joke = jokeMap.get(Integer.valueOf(randomJokeNum)).toString();
        return joke;
    }

    /**
     * Returns a psuedo-random number between 1 and 10, inclusive.
     *
     * @return Random Integer between 1 and 10, inclusive.
     */
    private static int getRandomInt() {

        int min = 1;
        int max = 10;

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     * Returns a HashMap of 10 Jokes associated with Integer ids.
     *
     * @return HashMap<Integer, String>
     */
    private static HashMap<Integer, String> createJokeMap() {
        jokeMap.put(1,
                "My psychiatrist told me I was crazy and I said I want a second opinion. "
                        + "He said okay, you’re ugly too.");
        jokeMap.put(2, "Artificial intelligence is no match for natural stupidity.");
        jokeMap.put(3, "Change is inevitable, except from a vending machine");
        jokeMap.put(4, "I didn’t say it was your fault, I said I was blaming you.");
        jokeMap.put(5, "Whoever coined the phrase “Quiet as a mouse” has never stepped on one.");
        jokeMap.put(6, "The sole purpose of a child’s middle name, is so he can tell when he’s "
                + "really in trouble.");
        jokeMap.put(7, "Money can’t buy happiness, but it sure makes misery easier to live with.");
        jokeMap.put(8, "My opinions may have changed, but not the fact that I am right.");
        jokeMap.put(9, "He who smiles in a crisis has found someone to blame.");
        jokeMap.put(10, "Always borrow money from a pessimist. He won’t expect it back.");

        return jokeMap;
    }
}
