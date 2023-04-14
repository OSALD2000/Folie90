import java.util.function.Function;

public abstract class OurList<T>{
    public abstract void insert(T ele);
    public abstract void insert(T ele, int pos);
    public abstract Boolean delete(Function<T,Boolean> func);
    @Override
    public abstract String toString();
}