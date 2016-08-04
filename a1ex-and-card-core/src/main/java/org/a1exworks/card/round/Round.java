package org.a1exworks.card.round;

import java.util.ArrayList;
import java.util.List;

import org.a1exworks.card.model.Card;

public class Round<C extends Card> {
    public final int            count;
    public final List<Phase<C>> process;

    public Round(int count) {
        this.count = count;
        this.process = new ArrayList<Phase<C>>();
    }
}
