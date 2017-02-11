package org.a1exworks.card.phase;

import org.a1exworks.card.entity.Card;
import org.a1exworks.card.entity.Player;

public class Phase<C extends Card, P extends Player> {
    public final int    id;
    public final String name;

    public Phase(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
