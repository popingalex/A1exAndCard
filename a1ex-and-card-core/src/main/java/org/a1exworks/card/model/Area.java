package org.a1exworks.card.model;

import java.util.LinkedList;
import java.util.List;

public class Area<C extends Card> {
    public final int     id;
    public final String  name;
    public final List<C> deck;

    public Area(int id, String name) {
        this.id = id;
        this.name = name;
        this.deck = new LinkedList<C>();
    }

    @Override
    public String toString() {
        return new StringBuffer().append("A").append(deck.toString()).toString();
    }
}
