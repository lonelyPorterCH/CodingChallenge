package com.zuehlke.codingchallenge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CodingChallengeTest {

    @Test
    void getMergedObjects() {
        CodingChallenge testee = new CodingChallenge();
        List<Object> expected = List.of(
                new SomeObject("IdentifierA", "A, B, C", 1,2,3),
                new SomeObject("IdentifierB", "Z, Y", 8,9,10),
                new SomeObject("IdentifierC", "AA, ZZ", 69,420,7),
                new SomeObject("IdentifierD", "QQQ", 100,200,300)
        );

        List<SomeObject> actual = testee.getMergedObjects();

        assertThat(actual).isEqualTo(expected);
    }
}