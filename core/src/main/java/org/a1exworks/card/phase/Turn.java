package org.a1exworks.card.phase;

import java.util.ArrayList;
import java.util.List;

import org.a1exworks.card.entity.Card;
import org.a1exworks.card.entity.Player;

public class Turn<C extends Card, P extends Player> {
    public final int            count;
    public final List<Phase<C>> phases;

    public Turn(int count) {
        this.count = count;
        this.phases = new ArrayList<Phase<C>>();
    }
}
