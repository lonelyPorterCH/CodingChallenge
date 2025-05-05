package com.zuehlke.codingchallenge;

import java.util.List;

public class SomeService {
    public List<SomeObject> getData() {
        return List.of(
                new SomeObject("IdentifierA", "A", 1,2,3),
                new SomeObject("IdentifierA", "B", 1,2,3),
                new SomeObject("IdentifierA", "C", 1,2,3),
                new SomeObject("IdentifierB", "Z", 8,9,10),
                new SomeObject("IdentifierB", "Y", 8,9,10),
                new SomeObject("IdentifierC", "AA", 69,420,7),
                new SomeObject("IdentifierC", "ZZ", 69,420, 7),
                new SomeObject("IdentifierD", "QQQ", 100,200,300)
                );
    }
}
