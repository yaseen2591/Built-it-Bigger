package com.example;

import java.util.Random;

public class Joke {
  private static final String jokes[] = {
            "Isn't it great to live in the 21st century? Where deleting history has become more important than making it.",
            "Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?",
            "I changed my password to \"incorrect\". So whenever I forget what it is the computer will say \"Your password is incorrect\"",
            "A recent study has found that women who carry a little extra weight live longer than the men who mention it."
    };
    public Joke(){

    }
    public String getRandomJoke(){
        Random rm = new Random();
        return jokes[rm.nextInt(jokes.length)];
    }
}
