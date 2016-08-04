package org.a1exworks.card.model;

import java.util.LinkedList;
import java.util.List;

public class Area<C extends Card> {
    public final int     id;
    public final List<C> deck;

    public Area(int id) {
        this.id = id;
        this.deck = new LinkedList<C>();
    }
}
