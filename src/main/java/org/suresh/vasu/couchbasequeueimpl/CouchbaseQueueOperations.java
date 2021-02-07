package org.suresh.vasu.couchbasequeueimpl;

import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;

import java.util.Queue;

public class CouchbaseQueueOperations {

  private Collection collection;


  public CouchbaseQueueOperations(Collection collection) {
    this.collection = collection;
  }

  public void queueAdd() {
    Payload payload = new Payload();
    payload.setName("test");
    payload.setValue("test");
    Queue<Payload> payloadQueue1 = collection.queue("queue-1", Payload.class);
    payloadQueue1.add(payload);
    printQueue(collection);
  }

  private void printQueue(Collection collection) {
    GetResult getResult = collection.get("queue-1");

    String payloadString = new String(getResult.contentAsArray().toBytes());

    System.out.println("queue content->"+payloadString);

  }

  public void queueRemove(){
    Queue<Payload> payloadQueue1 = collection.queue("queue-1", Payload.class);
    printQueue(collection);
    while (!payloadQueue1.isEmpty()){
      payloadQueue1.remove();
    }
    printQueue(collection);
  }

  public void pollQueue(){
    Queue<Payload> payloadQueue1 = collection.queue("queue-1", Payload.class);
    printQueue(collection);
  }
}
