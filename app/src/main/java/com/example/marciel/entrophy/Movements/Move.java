package com.example.marciel.entrophy.Movements;

import android.util.Log;

import com.example.marciel.entrophy.Dimens.Dimens;
import com.example.marciel.entrophy.LettersClasses.Letter;

/**A Move encapsulates the way a character can moveLetters
 * Created by david on 11/06/2014.
 */
public abstract class Move {

    //screen propertues
    static float Y_MAX_SCREEN_SIZE = Dimens.Y_MAX_SCREEN_SIZE;//1400;
    static float X_MAX_SCREEN_SIZE = Dimens.X_MAX_SCREEN_SIZE;//1050; //900;
    static float Y_MIN_SCREEN_SIZE = Dimens.Y_MIN_SCREEN_SIZE;// 100;
    static float X_MIN_SCREEN_SIZE = Dimens.X_MIN_SCREEN_SIZE;//50;
    static float SCREEN_WIDTH = X_MAX_SCREEN_SIZE - X_MIN_SCREEN_SIZE;
    static float SCREEN_HEIGHT = Y_MAX_SCREEN_SIZE - Y_MIN_SCREEN_SIZE;

    //movement properties
    public static final int STATIC_MOVE = 0;
    public static final int HORIZONTAL_BLOCK_BOUNCE_MOVE = 1;
    public static final int VERTICAL_BLOCK_BOUNCE_MOVE = 2;
    public static final int LINE_MOVE = 3;
    public static final int MATRIX_MOVE = 4;
    //public static final int EXTRANGE_MOVE_1 = 5;
    public static final int VERTICAL_BOUNCE_MOVE = 6;
    public static final int LINE_BOUNCE_MOVE = 7;
    public static final int INFINITE_BLOCK_MOVE = 8;
    public static final int LATERAL_WIND_MOVE = 9;
    public static final int LASER_MOVE = 10;
    public static final int SNAKE_MOVE = 11;

    /**Static constructor, returns an instance of the required movement
     *
     * @param movementType tipo de movimiento requerido (usar las constantes de la clase Move)
     * @return Move pedido
     */
    public static Move movementStaticFactory(Letter letter, int movementType) {

        switch (movementType){
            case STATIC_MOVE: return new StaticMove(letter);
            case HORIZONTAL_BLOCK_BOUNCE_MOVE: return new HorizontalBlockBounceMove(letter);
            case VERTICAL_BLOCK_BOUNCE_MOVE: return new VerticalBlockBounceMove(letter);
            case LINE_MOVE: return new LineMove(letter);
            case MATRIX_MOVE: return new MatrixMove(letter);
            //case EXTRANGE_MOVE_1: return new MovimientoRaro1(letter);
            case VERTICAL_BOUNCE_MOVE: return new VerticalBounceMove(letter);
            case LINE_BOUNCE_MOVE: return new LineBounceMove(letter);
            case INFINITE_BLOCK_MOVE: return new InfiniteBlockMove(letter);
            case LATERAL_WIND_MOVE: return new LateralWindMove(letter);
            case LASER_MOVE: return new LaserMove(letter);
            case SNAKE_MOVE: return new SnakeMove(letter);
            default: return new StaticMove(letter);
        }
    }


    //instance properties
    protected Letter letter;
    protected float x, y;

    public Move(Letter letter) {
        this.letter = letter;
        initPosition();
    }

    private void initPosition() {
        x = letter.getX();
        y = letter.getY();
    }

    //TODO Explore the possibility to remove this method
    public void update(){
        letter.setX(x);
        letter.setY(y);
    }

    public abstract void move();
}
