package org.a1exworks.card.play;

import org.a1exworks.card.model.Board;
import org.a1exworks.card.model.Card;
import org.a1exworks.card.model.Player;
import org.a1exworks.card.round.Phase;
import org.a1exworks.card.round.Round;

public interface Action <C extends Card, P extends Player>{
    void perform(Board<C, P> board, P player, Round<C> round, Phase<C> phase);
}
