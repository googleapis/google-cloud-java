package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DatastoreServiceTest {

  private static final String DATASET = "dataset1";
  private static final String KIND1 = "kind1";
  private static final String KIND2 = "kind2";
  private static final NullValue NULL_VALUE = new NullValue();
  private static final StringValue STR_VALUE = new StringValue("str");
  private static final BooleanValue BOOL_VALUE =
      new BooleanValue.Builder(false).indexed(false).build();
  private static final PartialKey PARTIAL_KEY1 = new PartialKey.Builder(DATASET, KIND1).build();
  private static final PartialKey PARTIAL_KEY2 = new PartialKey.Builder(DATASET, KIND2).build();
  private static final Key KEY1 = PARTIAL_KEY1.newKey("name");
  private static final Key KEY2 = new Key.Builder(KEY1, KIND2, 1).build();
  private static final Key KEY3 = KEY2.builder().name("bla").build();
  private static final PartialEntity PARTIAL_ENTITY1 = new PartialEntity.Builder(PARTIAL_KEY2)
      .setProperty("str", STR_VALUE)
      .setProperty("bool", BOOL_VALUE)
      .build();
  private static final Entity ENTITY1 = new Entity.Builder(KEY1)
      .setProperty("str", STR_VALUE)
      .setProperty("bool", BOOL_VALUE)
      .setProperty("partial1", new PartialEntityValue(PARTIAL_ENTITY1))
      .build();
  private static final Entity ENTITY2 = new Entity.Builder(KEY2, ENTITY1)
      .removeProperty("str")
      .setProperty("null", NULL_VALUE)
      .build();
  private static final Entity ENTITY3 = new Entity.Builder(KEY3, ENTITY1)
      .removeProperty("str")
      .setProperty("null", NULL_VALUE)
      .setProperty("partial2", new PartialEntityValue(ENTITY1))
      .build();

  private DatastoreServiceOptions options;
  private DatastoreService datastore;

  @Before
  public void setUp() {
    // TODO(ozarov): document that this test depends on a local gcd running.
    // gcd.sh start dataset1
    // reference: https://cloud.google.com/datastore/docs/tools/devserver
    // Or even better, using a "GCE_HOME" param/env initiate and destroy the server
    // before and after tests via ant or maven
    options = new DatastoreServiceOptions.Builder()
        .dataset(DATASET)
        .host("http://localhost:8080")
        .build();
    datastore = DatastoreServiceFactory.getDefault(options);
    // Prepare data for testing
    datastore.delete(KEY1, KEY2, KEY3);
    datastore.add(ENTITY1, ENTITY2);
  }

  @Test
  public void testGetOptions() {
    assertSame(options, datastore.getOptions());
  }

  @Test
  public void testNewTransactionCommit() {
    fail("Not yet implemented");
  }

  @Test
  public void testNewTransactionRollback() {
    fail("Not yet implemented");
  }

  @Test
  public void testNewBatchWriter() {
    BatchWriter batchWriter = datastore.newBatchWriter();
    Entity entity1 = ENTITY1.builder().clearProperties().build();
    Entity entity2 = ENTITY2.builder()
        .clearProperties()
        .setProperty("bla", new NullValue())
        .build();
    Entity entity4 = new Entity.Builder(KEY2.newKey("newName1"))
        .setProperty("value", new StringValue("value"))
        .build();
    Entity entity5 = new Entity.Builder(KEY2.newKey("newName2"))
        .setProperty("value", new StringValue("value"))
        .build();
    batchWriter.add(entity4, entity5);
    batchWriter.put(ENTITY3, entity1, entity2);
    batchWriter.submit();
    Iterator<Entity> entities = datastore.get(KEY1, KEY2, KEY3, entity4.key(), entity5.key());
    assertEquals(entity1, entities.next());
    assertEquals(entity2, entities.next());
    assertEquals(ENTITY3, entities.next());
    assertEquals(entity4, entities.next());
    assertEquals(entity5, entities.next());
    assertFalse(entities.hasNext());

    try {
      batchWriter.submit();
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }
    batchWriter = datastore.newBatchWriter();
    batchWriter.delete(entity4.key(), entity5.key());
    batchWriter.update(ENTITY1, ENTITY2, ENTITY3);
    batchWriter.submit();
    entities = datastore.get(KEY1, KEY2, KEY3, entity4.key(), entity5.key());
    assertEquals(ENTITY1, entities.next());
    assertEquals(ENTITY2, entities.next());
    assertEquals(ENTITY3, entities.next());
    assertNull(entities.next());
    assertNull(entities.next());
    assertFalse(entities.hasNext());

    // TODO need to cover more edge cases (ds failures, re-use of same entities,..)
  }

  @Test
  public void testRunQuery() {
    fail("Not yet implemented");
  }

  @Test
  public void testAllocateId() {
    KeyBuilder keyBuilder = datastore.newKeyBuilder(KIND1);
    PartialKey pk1 = keyBuilder.build();
    Key key1 = keyBuilder.allocateIdAndBuild();
    assertEquals(key1.dataset(), pk1.dataset());
    assertEquals(key1.namespace(), pk1.namespace());
    assertEquals(key1.ancestors(), pk1.ancestors());
    assertEquals(key1.kind(), pk1.kind());
    assertTrue(key1.hasId());
    assertFalse(key1.hasName());
    assertEquals(pk1.newKey(key1.id()), key1);

    Key key2 = datastore.allocateId(pk1);
    assertNotEquals(key1, key2);
    assertEquals(pk1.newKey(key2.id()), key2);

    Key key3 = datastore.allocateId(key1);
    assertNotEquals(key1, key3);
    assertEquals(pk1.newKey(key3.id()), key3);
  }

  @Test
  public void testAllocateIdArray() {
    KeyBuilder keyBuilder = datastore.newKeyBuilder(KIND1);
    PartialKey pKey1 = keyBuilder.build();
    PartialKey pKey2 = keyBuilder.kind(KIND2).addAncestor(KIND1, 10).build();
    Key key3 = keyBuilder.build("name");
    Key key4 = keyBuilder.build(1);
    Iterator<Key> result = datastore.allocateId(pKey1, pKey2, key3, key4, pKey1, key3);
    Map<Integer, Key> map = new HashMap<>();
    int count = 0;
    while (result.hasNext()) {
      map.put(++count, result.next());
    }
    assertEquals(6, map.size());
    assertEquals(pKey1.newKey(map.get(1).id()), map.get(1));
    assertEquals(pKey1.newKey(map.get(5).id()), map.get(5));
    assertEquals(pKey2.newKey(map.get(2).id()), map.get(2));
    assertEquals(key3.builder().id(map.get(3).id()).build(), map.get(3));
    assertEquals(key3.builder().id(map.get(6).id()).build(), map.get(6));
    assertEquals(key4.builder().id(map.get(4).id()).build(), map.get(4));
  }

  @Test
  public void testGet() {
    Entity entity = datastore.get(KEY3);
    assertNull(entity);

    entity = datastore.get(KEY1);
    StringValue value1 = entity.property("str");
    BooleanValue value2 = entity.property("bool");
    PartialEntityValue value3 = entity.property("partial1");
    assertEquals(value1, STR_VALUE);
    assertEquals(value2, BOOL_VALUE);
    assertEquals(value3, new PartialEntityValue(PARTIAL_ENTITY1));
    assertEquals(3, entity.propertyNames().size());
    assertTrue(entity.propertyNames().contains("str"));
    assertTrue(entity.propertyNames().contains("bool"));
    assertFalse(entity.hasProperty("bla"));
  }

  @Test
  public void testGetArray() {
    Iterator<Entity> result = datastore.get(KEY1, KEY1.builder().name("bla").build(), KEY2);
    assertEquals(ENTITY1, result.next());
    assertNull(result.next());
    assertEquals(ENTITY2, result.next());
    assertFalse(result.hasNext());
  }

  @Test
  public void testAdd() {
    Iterator<Entity> keys = datastore.get(ENTITY1.key(), ENTITY3.key());
    assertEquals(ENTITY1, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());

    try {
      datastore.add(ENTITY1);
    } catch (DatastoreServiceException expected) {
      // expected;
    }
    datastore.add(ENTITY3);
    assertEquals(ENTITY3, datastore.get(ENTITY3.key()));
  }

  @Test
  public void testUpdate() {
    Iterator<Entity> keys = datastore.get(ENTITY1.key(), ENTITY3.key());
    assertEquals(ENTITY1, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());

    try {
      datastore.update(ENTITY3);
    } catch (DatastoreServiceException expected) {
      // expected;
    }
    datastore.add(ENTITY3);
    assertEquals(ENTITY3, datastore.get(ENTITY3.key()));
    Entity entity3 = ENTITY3.builder()
        .clearProperties()
        .setProperty("bla", new NullValue())
        .build();
    assertNotEquals(ENTITY3, entity3);
    datastore.update(entity3);
    assertEquals(entity3, datastore.get(ENTITY3.key()));
  }

  @Test
  public void testPut() {
    Iterator<Entity> keys = datastore.get(ENTITY1.key(), ENTITY2.key(), ENTITY3.key());
    assertEquals(ENTITY1, keys.next());
    assertEquals(ENTITY2, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());

    Entity entity2 = ENTITY2.builder()
        .clearProperties()
        .setProperty("bla", new NullValue())
        .build();
    assertNotEquals(ENTITY2, entity2);
    datastore.put(ENTITY3, ENTITY1, entity2);
    keys = datastore.get(ENTITY1.key(), ENTITY2.key(), ENTITY3.key());
    assertEquals(ENTITY1, keys.next());
    assertEquals(entity2, keys.next());
    assertEquals(ENTITY3, keys.next());
    assertFalse(keys.hasNext());
  }

  @Test
  public void testDelete() {
    Iterator<Entity> keys = datastore.get(ENTITY1.key(), ENTITY2.key(), ENTITY3.key());
    assertEquals(ENTITY1, keys.next());
    assertEquals(ENTITY2, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
    datastore.delete(ENTITY1.key(), ENTITY2.key(), ENTITY3.key());
    keys = datastore.get(ENTITY1.key(), ENTITY2.key(), ENTITY3.key());
    assertNull(keys.next());
    assertNull(keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
  }

  @Test
  public void testNewKeyBuilder() {
    KeyBuilder keyBuilder = datastore.newKeyBuilder(KIND1);
    assertEquals(PARTIAL_KEY1, keyBuilder.build());
    assertEquals(PARTIAL_KEY1.builder().kind(KIND2).build(),
        datastore.newKeyBuilder(KIND2).build());
    assertEquals(KEY1, keyBuilder.build("name"));
    assertEquals(KEY1.builder().id(2).build(), keyBuilder.build(2));
  }
}
