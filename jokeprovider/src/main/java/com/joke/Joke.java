package com.joke;

import java.util.Random;

public class Joke {

    Random random = new Random();

    String[] jokes = new String[]{
            "Alcohol is a perfect solvent: It dissolves marriages, families and careers.",
            "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.",
            "If i had a dollar for every girl that found me unattractive, they would eventually find me attractive.",
            "A recent study has found that women who carry a little extra weight live longer than the men who mention it.",
            "What's the difference between your wife and your job? After five years your job will still suck.",
            "When wearing a bikini, women reveal 90 % of their body... men are so polite they only look at the covered parts.",
            "If you think nobody cares whether you're alive, try missing a couple of payments.",
            "I can totally keep secrets. It's the people I tell them to that can't.",
            "Life is like toilet paper, you're either on a roll or taking shit from some asshole.",
            "Strong people don't put others down. They lift them up and slam them on the ground for maximum damage."
    };

    public String getJoke() {
        return jokes[random.nextInt(10)];
    }
}
