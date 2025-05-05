package com.zuehlke.codingchallenge;

import java.util.List;

public class CodingChallenge {
    private final SomeService someService = new SomeService();

    /**
     * Returns all SomeObject, SomeObject with the same Identifier are merged with value containing all
     * values comma separated.
     */
    public List<SomeObject> getMergedObjects() {
        return someService.getData();
    }
}
