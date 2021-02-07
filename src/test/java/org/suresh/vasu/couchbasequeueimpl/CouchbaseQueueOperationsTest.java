package org.suresh.vasu.couchbasequeueimpl;

import org.junit.jupiter.api.Test;

public class CouchbaseQueueOperationsTest extends BaseTest {

    @Test
    public void testqueueAdd(){
        CouchbaseQueueOperations couchbaseQueueOperations = new CouchbaseQueueOperations(bucket.defaultCollection());
        couchbaseQueueOperations.queueAdd();
    }
    @Test
    public void testQueueRemove(){
        CouchbaseQueueOperations couchbaseQueueOperations = new CouchbaseQueueOperations(bucket.defaultCollection());
        couchbaseQueueOperations.queueRemove();
    }

}
