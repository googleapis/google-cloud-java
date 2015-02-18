package com.google.gcloud.datastore;

import static junit.framework.TestCase.assertEquals;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.client.Datastore;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class KeyFactoryTest {

  private static final String DATASET = "dataset";

  private KeyFactory keyFactory;
  private Datastore mock;

  @Before
  public void setUp() {
    mock = EasyMock.createMock(Datastore.class);
    DatastoreServiceOptions options =
        DatastoreServiceOptions.builder().normalizeDataset(false).datastore(mock).dataset(DATASET).build();
    DatastoreService datastore = DatastoreServiceFactory.getDefault(options);
    keyFactory = new KeyFactory(datastore).kind("k");
  }

  @Test
  public void testNewKey() throws Exception {
    Key key = keyFactory.newKey(1);
    verifyKey(key, 1L, null);
    key = keyFactory.newKey("n");
    verifyKey(key, "n", null);
    PathElement p1 = PathElement.of("k1", "n");
    PathElement p2 = PathElement.of("k2", 10);
    key = keyFactory.namespace("ns").ancestors(p1, p2).newKey("k3");
    verifyKey(key, "k3", "ns", p1, p2);
  }

  @Test
  public void testNewPartialKey() throws Exception {
    PartialKey key = keyFactory.newKey();
    verifyPartialKey(key, null);
    PathElement p1 = PathElement.of("k1", "n");
    PathElement p2 = PathElement.of("k2", 10);
    key = keyFactory.namespace("ns").ancestors(p1, p2).newKey();
    verifyPartialKey(key, "ns", p1, p2);
  }

  @Test(expected = NullPointerException.class)
  public void testNewPartialWithNoKind() {
    new KeyFactory(keyFactory.datastore()).build();
  }

  private void verifyKey(Key key, String name, String namespace, PathElement... ancestors) {
    assertEquals(name, key.name());
    verifyPartialKey(key, namespace, ancestors);
  }

  private void verifyKey(Key key, Long id, String namespace, PathElement... ancestors) {
    assertEquals(id, key.id());
    verifyPartialKey(key, namespace, ancestors);
  }

  private void verifyPartialKey(PartialKey key, String namespace, PathElement... ancestors) {
    assertEquals("k", key.kind());
    assertEquals(DATASET, key.dataset());
    assertEquals(namespace, key.namespace());
    assertEquals(ancestors.length, key.ancestors().size());
    Iterator<PathElement> iter = key.ancestors().iterator();
    for (PathElement ancestor : ancestors) {
      assertEquals(ancestor, iter.next());
    }
  }

  @Test
  public void testAllocateId() throws Exception {
    PartialKey pk = keyFactory.newKey();
    Key key = keyFactory.newKey(1);
    DatastoreV1.AllocateIdsRequest.Builder requestPb = DatastoreV1.AllocateIdsRequest.newBuilder();
    requestPb.addKey(pk.toPb());
    DatastoreV1.AllocateIdsResponse.Builder responsePb = DatastoreV1.AllocateIdsResponse.newBuilder();
    responsePb.addKey(key.toPb());
    EasyMock.expect(mock.allocateIds(requestPb.build())).andReturn(responsePb.build());
    EasyMock.replay(mock);
    assertEquals(key, keyFactory.allocateId());
    EasyMock.verify(mock);
  }
}
