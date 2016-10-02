package org.a1exworks.card.action;

import org.a1exworks.card.entity.Board;
import org.a1exworks.card.entity.Card;
import org.a1exworks.card.entity.Player;
import org.a1exworks.card.phase.Phase;
import org.a1exworks.card.phase.Turn;

public interface Action<C extends Card, P extends Player> {
    void perform(Board<C, P> board, P player, Turn<C> round, Phase<C> phase);
}
