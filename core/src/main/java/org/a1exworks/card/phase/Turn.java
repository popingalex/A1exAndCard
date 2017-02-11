package org.a1exworks.card.phase;

import org.a1exworks.card.entity.Card;
import org.a1exworks.card.entity.Player;

public class Turn<C extends Card, P extends Player> {
    public final int            count;

    public Turn(int count) {
        this.count = count;
    }
}
