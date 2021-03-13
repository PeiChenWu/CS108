package edu.stanford.cs108.tetris;

/**
 * Created by pyoung on 9/5/2016.
 */
public interface TetrisUIInterface {

    /* The board has changed */
    void boardUpdated();

    /* Score and Piece data has changed */
    void dataUpdated();

    /* Setup the UI to Show New State */
    void rigGameOver();
    void rigGameInProgress();
}
