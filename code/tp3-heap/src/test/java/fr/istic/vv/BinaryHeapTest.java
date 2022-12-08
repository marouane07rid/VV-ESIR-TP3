package fr.istic.vv;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    Comparator<Integer> comparator = new intComparator();
    BinaryHeap<Integer> heap = new BinaryHeap<Integer>(comparator);

    @Test
    public void pushTest() {
        heap.push(3);
        heap.push(5);
        assertEquals(3, heap.peek(), heap.toString());
    }

    @Test
    public void pushTest2() {
        heap.push(3);
        heap.push(5);
        heap.push(6);
        heap.push(7);
        assertEquals(3, heap.peek(), heap.toString());
    }

    @Test
    public void pushTest3() {
        heap.push(3);
        heap.push(5);
        heap.push(6);
        heap.push(7);
        heap.push(4);
        assertEquals(3, heap.peek(), heap.toString());
    }


    @Test
    public void popTest() {
        heap.push(3);
        heap.push(5);
        assertEquals(3, heap.pop());
        assertEquals(5, heap.peek());

    }

    @Test
    public void popTest2() {
        heap.push(3);
        heap.push(5);
        heap.push(6);
        heap.push(7);
        heap.push(4);
        assertEquals(3, heap.pop());
        assertEquals(4, heap.peek());
    }

    @Test
    public void popTest3() {
        heap.push(3);
        heap.push(5);
        heap.push(6);
        heap.push(7);
        heap.push(4);
        heap.push(2);
        heap.push(1);
        heap.push(0);
        assertEquals(0, heap.pop());
        assertEquals(1, heap.peek());
    }

    @Test
    public void testHeapify() {
        heap.push(3);
        heap.push(5);
        heap.push(6);
        heap.push(7);
        heap.push(4);
        heap.push(2);
        heap.push(1);
        heap.push(0);
        heap.heapify(0);
        assertEquals(0, heap.peek());
    }

    @Test
    public void testHeapify2() {
        heap.push(3);
        heap.push(5);
        heap.push(6);
        heap.push(7);
        heap.push(4);
        heap.push(2);
        heap.push(1);
        heap.push(0);
        heap.heapify(0);
        assertEquals(0, heap.pop());
        assertEquals(1, heap.peek());
    }

    @Test
    public void testHeapify3() {
        heap.push(3);
        heap.push(5);
        heap.push(6);
        heap.push(7);
        heap.push(4);
        heap.push(2);
        heap.push(1);
        heap.push(0);
        heap.heapify(2);
        assertEquals(0, heap.pop());

    }

    @Test
    public void testCount() {
        heap.push(3);
        heap.push(5);
        heap.push(6);
        heap.push(7);
        heap.push(4);
        heap.push(2);
        heap.push(1);
        heap.push(0);
        assertEquals(8, heap.count());
    }

}

class intComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}