package com.shashi.dsalgo.heapdemo;

public class Heap {

    int[] heap;
    int size;

    //Constructor to create array
    public Heap(int capacity) {
        heap = new int[capacity];
    }

    //insert
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is Full");
        }

        heap[size] = value;       //element inserted

        //heapify
        fixHeapAbove(size);
        size++;

    }

    //Delete an element
    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is Empty");
        }

        int parent = getParentIndex(index);
        int deletedValue = heap[index];       //item to delete

        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        size--;

        return deletedValue;
    }

    //Heapify above
    private void fixHeapAbove(int index) {
        int newValue = heap[index];

        //If value inserted is greater than the parent then save parent's index
        while (index > 0 && newValue > heap[getParentIndex(index)]) {
            heap[index] = heap[getParentIndex(index)];
            index = getParentIndex(index);
        }

        heap[index] = newValue;
    }

    //Heapify below
    private void fixHeapBelow(int index, int lastHeapIndex) {         //lastHeapIndex is used in Heap sort algo
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChildIndex(index, true);
            int rightChild = getChildIndex(index, false);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }

                //if value is less than it's largest child then swap
                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }

                index = childToSwap;
            } else {
                break;
            }
        }
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        System.out.println("Heap: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    //get child's index
    public int getChildIndex(int index, boolean leftChild) {
        return 2 * index + (leftChild ? 1 : 2);
    }

    //get parent's index of an element
    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    //Peek Element
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        
        return heap[0];
    }


}
