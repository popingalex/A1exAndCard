package org.a1exworks.card.entity;

import java.util.Collections;
import java.util.LinkedList;

public class Pile<C extends Card> {
    public final int           id;
    public final String        name;
    public final LinkedList<C> cards;

    public Pile(int id, String name) {
        this.id = id;
        this.name = name;
        this.cards = new LinkedList<C>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    private static String LF = System.getProperty("line.separator");

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("P(");
        if (null != name) {
            int length = (10 - (name.getBytes().length - name.length()) / 2);
            buffer.append(String.format("Name:%-" + length + "s, ", name));
        }
        buffer.append(String.format("ID:%3d", id));
        buffer.append(")").append(LF);
        buffer.append(cards.toString());
        return buffer.toString();
    }
}
