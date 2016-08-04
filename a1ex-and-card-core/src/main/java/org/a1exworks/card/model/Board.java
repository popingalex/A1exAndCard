package org.a1exworks.card.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board<C extends Card> {
    public final int                  id;
    public final List<Player>         party;
    public final Map<Object, Area<C>> table;

    public Board(int id) {
        this.id = id;
        this.party = new ArrayList<Player>();
        this.table = new HashMap<Object, Area<C>>();
    }
}
