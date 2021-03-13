package edu.stanford.cs108.tetris;

/**
 * Created by peichenwu on 2/9/17.
 */

public class TetrisBrainLogic extends TetrisLogic {
    private DefaultBrain brain;
    private Brain.Move bMove;
    protected boolean brainMode = false;

    public TetrisBrainLogic (TetrisUIInterface uiInterface) {
        super(uiInterface);
        brain = new DefaultBrain();
        bMove = new Brain.Move();
    }

    public void setBrainMode(boolean b) {
        brainMode = b;
    }

    @Override
    public void tick(int verb) {
        if (brainMode){
            if (currentY < HEIGHT && verb == DOWN) {
                board.undo();
                bMove = brain.bestMove(board, currentPiece, board.getHeight()-4, bMove);

                if (bMove != null) {
                    if (!currentPiece.equals(bMove.piece)) {
                        currentPiece = currentPiece.fastRotation();
                    }
                    if (currentX > bMove.x) currentX--;
                    else if (currentX < bMove.x) currentX++;
                    if (currentX == bMove.x && currentPiece.equals(bMove.piece) && currentY != bMove.y) verb = DROP;
                }
            }
        }
        super.tick(verb);
    }
}
