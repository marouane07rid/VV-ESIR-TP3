package fr.istic.vv;

import java.util.Comparator;

class BinaryHeap<T> {

    private T[] heap;
    private int size;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) { 
        this.comparator = comparator;
        heap = (T[]) new Object[10];
     }

    public T pop() { 
        T result = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return result;
     }

    private void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
        if (left < size && comparator.compare(heap[left], heap[min]) < 0) {
            min = left;
        }
        if (right < size && comparator.compare(heap[right], heap[min]) < 0) {
            min = right;
        }
        if (min != i) {
            swap(i, min);
            heapify(min);
        }
    }

    private void swap(int i, int min) {
        T tmp = heap[i];
        heap[i] = heap[min];
        heap[min] = tmp;
    }

    public T peek() { 
        return heap[0];
     }

    public void push(T element) { 
        if (size == heap.length) {
            T[] newHeap = (T[]) new Object[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
        heap[size] = element;
        int i = size;
        size++;
        while (i > 0 && comparator.compare(heap[i], heap[(i - 1) / 2]) < 0) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
     }

    public int count() { 
        return size;
     }
}