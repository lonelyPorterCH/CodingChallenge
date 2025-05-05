package com.zuehlke.codingchallenge;

import java.util.List;

public class CodingChallenge {
    private final SomeService someService = new SomeService();

    public List<SomeObject> getMergedObjects() {
        return someService.getData();
    }
}
