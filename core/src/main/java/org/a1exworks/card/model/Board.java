package org.a1exworks.card.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board<C extends Card, P extends Player> {
    public final int                  id;
    public final String               name;
    public final List<P>              players;
    public final Map<Object, Pile<C>> piles;

    public Board(int id, String name) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<P>();
        this.piles = new HashMap<Object, Pile<C>>();
    }

    private static String LF = System.getProperty("line.separator");

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("B[");
        if (null != name) {
            int length = (10 - (name.getBytes().length - name.length()) / 2);
            buffer.append(String.format("Name:%-" + length + "s, ", name));
        }
        buffer.append(String.format("ID:%3d", id));
        buffer.append("]").append(LF);
        for (Object key : piles.keySet()) {
            buffer.append(key + ":" + piles.get(key)).append(LF);
        }
        buffer.append(players.toString());
        return buffer.toString();
    }
}
