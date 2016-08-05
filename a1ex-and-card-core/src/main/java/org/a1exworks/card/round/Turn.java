package org.a1exworks.card.round;

import java.util.ArrayList;
import java.util.List;

import org.a1exworks.card.model.Card;

public class Turn<C extends Card> {
    public final int            count;
    public final List<Phase<C>> phases;

    public Turn(int count) {
        this.count = count;
        this.phases = new ArrayList<Phase<C>>();
    }
}
