package com.company;
//Eric Tiancheng Gu

public class PriorityQueueArray {

    int lastNode = 0;
    Node[] minHeap = new Node[2];
    Node[] maxHeap = new Node[2];

    PriorityQueueArray() {

    }

    PriorityQueueArray(Node node) {
        lastNode++;
        minHeap[lastNode] = node;
        maxHeap[lastNode] = node;
        node.maxIndex = 1;
        node.maxIndex = 1;

    }

    public int deleteMin() {
        int maxIndex = minHeap[1].maxIndex;
        int value = minHeap[1].value;
        deleteMinAt(1);
        lastNode++;
        deleteMaxAt(maxIndex);
        return value;
    }

    public int deleteMax() {
        int minIndex = maxHeap[1].minIndex;
        int value = maxHeap[1].value;
        deleteMaxAt(1);
        lastNode++;
        deleteMinAt(minIndex);
        return value;
    }

    private void deleteMinAt(int index) {
        minSwap(index, lastNode);
        minHeap[lastNode] = null;
        lastNode--;
        //swim down
        while (index * 2 <= lastNode) {
            int swapIndex = index * 2;


            if (swapIndex < lastNode && minHeap[1 + swapIndex].value < minHeap[swapIndex].value) {
                swapIndex++;
            }

            if (minHeap[index].value >= minHeap[swapIndex].value) {
                minSwap(index, swapIndex);
                index = swapIndex;
            } else {
                break;
            }
        }
    }

    private void deleteMaxAt(int index) {
        maxSwap(index, lastNode);
        maxHeap[lastNode] = null;
        lastNode--;

        //swim down
        while (index * 2 <= lastNode) {
            int swapIndex = index * 2;

            if (swapIndex < lastNode && maxHeap[1 + swapIndex].value > maxHeap[swapIndex].value) {
                swapIndex++;
            }

            if (maxHeap[index].value <= maxHeap[swapIndex].value) {
                maxSwap(index, swapIndex);
                index = swapIndex;
            } else {
                break;
            }
        }
    }

    public int findMin() {
        return minHeap[1].value;
    }

    public int findMax() {
        return maxHeap[1].value;
    }

    public void insert(int key) {
        Node n = new Node(key);
        insert(n);
    }

    public void insert(Node node) {
        if ((lastNode) == 0) {
            node.minIndex = 1;
            node.maxIndex = 1;
            lastNode++;
            minHeap[lastNode] = node;
            maxHeap[lastNode] = node;
            return;
        }
        lastNode++;
        resize();
        this.insertMax(node);
        this.insertMin(node);
    }

    private void insertMin(Node node) {
        node.minIndex = lastNode;
        minHeap[lastNode] = node;

        //swim up
        int index = lastNode;
        while (index > 1) {
            if (minHeap[index].value < minHeap[(index / 2)].value) {
                minSwap(index, index / 2);
                index = (index / 2);
            } else {
                break;
            }
        }
    }

    private void insertMax(Node node) {
        node.maxIndex = lastNode;
        maxHeap[lastNode] = node;

        //swim up
        int index = lastNode;
        while (index > 1) {
            if (maxHeap[index].value > maxHeap[(index / 2)].value) {
                maxSwap(index, index / 2);
                index = (index / 2);
            } else {
                break;
            }
        }
    }

    public void resize() {
        if (lastNode > (maxHeap.length - 1) / 2 || lastNode > (minHeap.length - 1) / 2) {
            Node[] tempMin = minHeap;
            minHeap = new Node[tempMin.length * 2];
            for (int i = 1; i < tempMin.length; i++) {
                minHeap[i] = tempMin[i];
            }

            Node[] tempMax = maxHeap;
            maxHeap = new Node[maxHeap.length * 2];
            for (int i = 1; i < tempMax.length; i++) {
                maxHeap[i] = tempMax[i];
            }

        }

        else if (lastNode < (maxHeap.length - 1) / 4 || lastNode < (minHeap.length - 1) / 4) {
            // copy min
            Node[] tempMin = minHeap;
            minHeap = new Node[tempMin.length / 2];
            for (int i = 1; i < minHeap.length; i++) {
                minHeap[i] = tempMin[i];
            }

            //copy max
            Node[] tempMax = maxHeap;
            maxHeap = new Node[maxHeap.length / 2];
            for (int i = 1; i < maxHeap.length; i++) {
                maxHeap[i] = tempMax[i];
            }
        }

    }

    private void minSwap(int a, int b) {
        minHeap[a].minIndex = b;
        minHeap[b].minIndex = a;
        Node n = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = n;
    }

    private void maxSwap(int a, int b) {
        maxHeap[a].maxIndex = b;
        maxHeap[b].maxIndex = a;
        Node n = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = n;
    }

}