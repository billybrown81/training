package leetcode;
import java.util.Iterator;

public class PeekingIterator {
	private Iterator<Integer> itr;
	private Integer next = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		itr = iterator;
		if (itr.hasNext()) {
			next = itr.next();
		}
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	public Integer next() {
	    Integer res = next;
	    next = itr.hasNext()? itr.next() : null;
	    return res;
	}

	public boolean hasNext() {
	    return next != null;
	}
}
