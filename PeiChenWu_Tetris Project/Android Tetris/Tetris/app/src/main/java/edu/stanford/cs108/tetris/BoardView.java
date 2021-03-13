package edu.stanford.cs108.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by pyoung on 9/5/2016.
 */
public class BoardView extends View {

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private Paint myPaint;
    private Paint filledRowPaint;
    private Paint myOutlinePaint;

    private TetrisLogic tetrisLogic;

    private void init() {
        myPaint = new Paint();
        filledRowPaint = new Paint();
        filledRowPaint.setColor(Color.GREEN);
        myOutlinePaint = new Paint();
        myOutlinePaint.setStyle(Paint.Style.STROKE);
        myOutlinePaint.setStrokeWidth(3f);
        myOutlinePaint.setColor(Color.RED);
    }

    public void setLogic(TetrisLogic tetrisLogic) {
        this.tetrisLogic = tetrisLogic;
    }

    int viewWidth, viewHeight;
    float viewMargin;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;

        //viewMargin = Math.min(w,h) * 0.05f;
        viewMargin = Math.min(w,h) * 0f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (tetrisLogic == null) {
            return;
        }
        int boardHeightSquares = tetrisLogic.getTotalHeight();
        int boardWidthSquares = tetrisLogic.getWidth();
        int topHeightSquares = tetrisLogic.getTopAreaHeight();

        float squareHeightLimit = (viewHeight - 2*viewMargin) / boardHeightSquares;
        float squareWidthLimit = (viewWidth - 2*viewMargin) / boardWidthSquares;

        float squareSize = Math.min(squareHeightLimit, squareWidthLimit);

        canvas.drawLine(viewMargin,squareSize*topHeightSquares + viewMargin,
                viewMargin+squareSize*boardWidthSquares,squareSize*topHeightSquares + viewMargin,myPaint);

        for (int row = 0; row < boardHeightSquares; row++) {
            Paint rowPaint = (tetrisLogic.rowFilled(row))?filledRowPaint:myPaint;
            for(int col=0; col < boardWidthSquares; col++) {
                if (tetrisLogic.getGrid(col,row)) {
                    drawSquare(canvas,squareSize,
                            col*squareSize + viewMargin,
                            (boardHeightSquares * squareSize) - (row+1)*squareSize + viewMargin,
                            rowPaint);
                }
            }
        }

        canvas.drawRect(viewMargin,viewMargin,
                squareSize*boardWidthSquares+viewMargin,
                squareSize*boardHeightSquares+viewMargin,myOutlinePaint);
    }

    private void drawSquare(Canvas canvas, float size, float left, float top,Paint paint) {
        float edge = size * 0.05f; // inset around each square
        canvas.drawRect(left+edge,top+edge,left+size-edge,top+size-edge,paint);
    }
}
