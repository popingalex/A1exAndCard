package org.a1exworks.card.play;

import org.a1exworks.card.model.Board;
import org.a1exworks.card.model.Card;
import org.a1exworks.card.model.Player;
import org.a1exworks.card.round.Phase;
import org.a1exworks.card.round.Turn;

public interface Action <C extends Card, P extends Player>{
    void perform(Board<C, P> board, P player, Turn<C> round, Phase<C> phase);
}
