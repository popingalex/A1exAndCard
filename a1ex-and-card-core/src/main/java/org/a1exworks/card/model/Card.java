package org.a1exworks.card.model;

public class Card {
    private static int counter = 0;
    public final int   uid;
    public final int   id;

    public Card(int id) {
        this.id = id;
        this.uid = counter++;
    }
}
