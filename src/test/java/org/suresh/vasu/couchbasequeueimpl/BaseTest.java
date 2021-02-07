package org.suresh.vasu.couchbasequeueimpl;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.couchbase.BucketDefinition;
import org.testcontainers.couchbase.CouchbaseContainer;

public class BaseTest {
    private static final String BUCKET = "test_bucket";
    protected static Bucket bucket;
    private static CouchbaseContainer couchbaseContainer;

    @BeforeAll
    public static void startUpCouchbaseContainer(){
        couchbaseContainer = new CouchbaseContainer("couchbase/server:6.5.1")
                .withBucket(new BucketDefinition(BUCKET))
                .withCredentials(BUCKET, BUCKET).waitingFor(Wait.defaultWaitStrategy());
        couchbaseContainer.start();
        System.setProperty("couchbase.testcontainer.url", couchbaseContainer.getConnectionString());
        Cluster cluster = Cluster.connect(couchbaseContainer.getConnectionString(), BUCKET, BUCKET);
        bucket = cluster.bucket(BUCKET);
    }

    @AfterAll
    public static void shutdownCouchbaseContainer(){
        couchbaseContainer.stop();
    }
}
