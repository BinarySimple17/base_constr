package model;

/**  public class DirectionAdv extends Direction{
 * По своей природе enum в Java является финальным (final) классом
 * Это сделано для обеспечения уникальности значений, типобезопасности и простоты использования.
 * Если вам нужно расширить функциональность enum, используйте методы, поля, интерфейсы или композицию.
 */
public class DirectionAdv implements Colorable{
    private final Direction dir;

    public DirectionAdv(Direction dir) {
        this.dir = dir;
    }

    @Override
    public String getColor() {
        return switch (dir){
            case LEFT -> "\033[0;37m";
            case RIGHT -> "\033[0;32m";
        };
    }

    public Direction getDir() {
        return dir;
    }
}
