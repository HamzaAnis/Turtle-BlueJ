
import com.sun.org.apache.bcel.internal.Repository;
import static java.lang.Math.E;
import java.util.Iterator;


public class CutoffIterator<E> implements Iterator<E> {

    private int limit;
    private Iterator<E> itr;

    public CutoffIterator(int limit) {
        this.limit = limit;
        itr.hasNext();
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
