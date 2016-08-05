package org.a1exworks.card.model;

public class Card {
    private static int  counter = 0;
    public final int    id;
    public final int    uid;
    public final String name;

    public Card(int id, String name) {
        this.id = id;
        this.uid = counter++;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("C(");
        if (null != name) {
            int length = (10 - (name.getBytes().length - name.length()) / 2);
            buffer.append(String.format("Name:%-" + length + "s, ", name));
        }
        buffer.append(String.format("ID:%3d", id));
        buffer.append(")");
        return buffer.toString();
    }
}
