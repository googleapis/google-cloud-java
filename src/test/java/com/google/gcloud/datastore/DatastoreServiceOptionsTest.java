package com.google.gcloud.datastore;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertTrue;

import com.google.api.services.datastore.client.Datastore;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DatastoreServiceOptionsTest {

  private static final String DATASET = "dataset";
  private Datastore datastore;
  private DatastoreServiceOptions.Builder options;

  @Before
  public void setUp() throws IOException, InterruptedException {
    datastore = EasyMock.createMock(Datastore.class);
    options = DatastoreServiceOptions.builder()
        .normalizeDataset(false)
        .datastore(datastore)
        .dataset(DATASET)
        .host("http://localhost:" + LocalGcdHelper.PORT);
  }

  @Test
  public void testDataset() throws Exception {
    assertEquals(DATASET, options.build().dataset());
  }

  @Test
  public void testHost() throws Exception {
    assertEquals("http://localhost:" + LocalGcdHelper.PORT, options.build().host());
  }

  @Test
  public void testNamespace() throws Exception {
    assertNull(options.build().namespace());
    assertEquals("ns1", options.namespace("ns1").build().namespace());
  }

  @Test
  public void testForce() throws Exception {
    assertFalse(options.build().force());
    assertTrue(options.force(true).build().force());
  }

  @Test
  public void testDatastore() throws Exception {
    assertSame(datastore, options.build().datastore());
  }

  @Test
  public void testToBuilder() throws Exception {
    DatastoreServiceOptions original = options.namespace("ns1").force(true).build();
    DatastoreServiceOptions copy = original.toBuilder().build();
    assertEquals(original.dataset(), copy.dataset());
    assertEquals(original.namespace(), copy.namespace());
    assertEquals(original.host(), copy.host());
    assertEquals(original.force(), copy.force());
    assertEquals(original.retryParams(), copy.retryParams());
    assertEquals(original.authConfig(), copy.authConfig());
  }
}
