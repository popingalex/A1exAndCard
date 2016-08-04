package org.a1exworks.card.model;

public class Player {
    public final int    id;
    public final String name;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("P[");
        if (null != name) {
            int length = (10 - (name.getBytes().length - name.length()) / 2);
            String.format("Name:%-" + length + "s, ", name);
        }
        buffer.append(String.format("ID:%4d", id));
        buffer.append("]");
        return buffer.toString();
    }
}
