package org.example.tdas;

public interface QueueOfQueues {
    Queue getFirst();
    void remove();
    void add(Queue queue);
    boolean isEmpty();
    QueueOfQueues concatenate(QueueOfQueues queue, int n);
    Queue  flat(QueueOfQueues queueOfQueues);
    void reverseWithDepth(StatickQueueOfQueues queueOfQueues);
}
