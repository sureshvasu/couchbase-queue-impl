package org.suresh.vasu.couchbasequeueimpl;

import org.junit.jupiter.api.Test;

public class CouchbaseListOperationsTest extends BaseTest {

    @Test
    public void testListAdd(){
        CouchbaseListOperations couchbaseListOperations = new CouchbaseListOperations(bucket.defaultCollection());
        couchbaseListOperations.listAddOperation();
    }

}
