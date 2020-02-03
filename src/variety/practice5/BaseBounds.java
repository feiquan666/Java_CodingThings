package variety.practice5;

import java.awt.*;

interface HasColor{
    Color getColor();
}
class HoldItem<T>{
    T item;
    HoldItem(T item){
        this.item = item;
    }
    T getItem(){
        return this.item;
    }
}
class Colored<T extends HasColor>{
    T item;
    Colored(T item){
        this.item = item;
    }
    Color color(){
        return item.getColor();
    }
}
class Colored2<T extends HasColor> extends HoldItem<T>{
    Colored2(T item) {
        super(item);
    }
    Color color(){
        return item.getColor();
    }
}
class Dimension{
    public int x,y,z;
}
class ColoredDimension<T extends Dimension & HasColor>{
    T item;
    ColoredDimension(T item){
        this.item = item;
    }
    T getItem(){
        return  this.item;
    }
    Color color(){
        return  item.getColor();
    }
    int getX(){
        return item.x;
    }
    int getY(){
        return item.y;
    }
    int getZ(){
        return item.z;
    }
}
interface Weight{
    int weight();
}
class Solid<T extends Dimension & HasColor & Weight>{
    T item;
    Solid(T item){
        this.item = item;
    }
    T getItem(){
        return  this.item;
    }
    Color color(){
        return  item.getColor();
    }
    int getX(){
        return item.x;
    }
    int getY(){
        return item.y;
    }
    int getZ(){
        return item.z;
    }
    int weight(){
        return item.weight();
    }
}
class Bounded extends Dimension implements HasColor,Weight{
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
public class BaseBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
