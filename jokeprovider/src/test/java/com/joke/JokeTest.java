package com.joke;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sanathnandasiri on 10/7/16.
 */
public class JokeTest {
    @Test
    public void getJokeShouldNotBeNull() throws Exception {
        Joke joke = new Joke();
        String actual = joke.getJoke();
        Assert.assertNotNull(actual);
    }

}