package org.suresh.vasu.couchbasequeueimpl;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.datastructures.CouchbaseArrayList;
import com.couchbase.client.java.kv.ArrayListOptions;
import com.couchbase.client.java.kv.GetResult;

import java.util.List;

public class CouchbaseListOperations {


  private Collection collection;

  public CouchbaseListOperations(Collection collection) {
    this.collection = collection;
  }

  public void listAddOperation() {
    Payload payload = new Payload();
    payload.setName("test");
    payload.setValue("test");

    List<Payload> payloadList =
        new CouchbaseArrayList<>(
            "list-1", collection, Payload.class, ArrayListOptions.arrayListOptions());
    payloadList.add(payload);
    printList(collection);
  }

  private void printList(Collection collection) {
    GetResult getResult = collection.get("list-1");

    String payloadString = new String(getResult.contentAsArray().toBytes());

    System.out.println("list content->"+payloadString);
  }




  // Poll
  // Listener
  // Prepend , append
  // Performance
}
