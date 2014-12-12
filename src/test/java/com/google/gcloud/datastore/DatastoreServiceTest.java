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

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DatastoreServiceTest {

  private static final String DATASET = "dataset1";
  private static final String KIND1 = "kind1";
  private static final String KIND2 = "kind2";
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STR_VALUE = StringValue.of("str");
  private static final BooleanValue BOOL_VALUE = BooleanValue.builder(false).indexed(false).build();
  private static final PartialKey PARTIAL_KEY1 = PartialKey.builder(DATASET, KIND1).build();
  private static final PartialKey PARTIAL_KEY2 = PartialKey.builder(DATASET, KIND2).build();
  private static final Key KEY1 = PARTIAL_KEY1.newKey("name");
  private static final Key KEY2 = Key.builder(KEY1, KIND2, 1).build();
  private static final Key KEY3 = Key.builder(KEY2).name("bla").build();
  private static final Key KEY4 = KEY2.newKey("newName1");
  private static final Key KEY5 = KEY2.newKey("newName2");
  private static final KeyValue KEY_VALUE = KeyValue.of(KEY1);
  private static final ListValue LIST_VALUE1 = ListValue.builder()
      .addValue(NULL_VALUE)
      .addValue(STR_VALUE, BOOL_VALUE)
      .build();
  private static final ListValue LIST_VALUE2 = ListValue.of(Collections.singletonList(KEY_VALUE));
  private static final PartialEntity PARTIAL_ENTITY1 = PartialEntity.builder(PARTIAL_KEY2)
      .set("str", STR_VALUE).set("bool", BOOL_VALUE).set("list", LIST_VALUE1).build();
  private static final PartialEntity PARTIAL_ENTITY2 = PartialEntity.builder(PARTIAL_ENTITY1)
      .remove("str").set("bool", true).set("list", LIST_VALUE1.get()).build();
  private static final Entity ENTITY1 = Entity.builder(KEY1).set("str", STR_VALUE)
      .set("bool", BOOL_VALUE).set("partial1", EntityValue.of(PARTIAL_ENTITY1))
      .set("list", LIST_VALUE2).build();
  private static final Entity ENTITY2 = Entity.builder(ENTITY1).key(KEY2).remove("str")
      .setNull("null").build();
  private static final Entity ENTITY3 = Entity.builder(ENTITY1).key(KEY3).remove("str")
      .set("null", NULL_VALUE).set("partial1", PARTIAL_ENTITY2).set("partial2", ENTITY2).build();

  private DatastoreServiceOptions options;
  private DatastoreService datastore;

  @Before
  public void setUp() {
    // TODO(ozarov): document that this test depends on a local gcd running.
    // Unfortunately, the gcd tool is not bundled with the cloud SDK and need
    // to be downloaded independently from
    // https://cloud.google.com/datastore/docs/tools/devserver (b/16372095).
    // To start the gcd run:
    // gcd.sh create dataset1; gcd.sh start dataset1
    // We should have an option to start the gcd from maven/ant.
    options = DatastoreServiceOptions.builder()
        .dataset(DATASET)
        .host("http://localhost:8080")
        .build();
    datastore = DatastoreServiceFactory.getDefault(options);
    // Prepare data for testing
    datastore.delete(KEY1, KEY2, KEY3, KEY4, KEY5);
    datastore.add(ENTITY1, ENTITY2);
  }

  @Test
  public void testGetOptions() {
    assertSame(options, datastore.getOptions());
  }

  @Test
  public void testNewTransactionCommit() {
    Transaction transaction = datastore.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 = Entity.builder(ENTITY2)
        .clear()
        .setNull("bla")
        .build();
    transaction.update(entity2);
    transaction.delete(KEY1);
    transaction.commit();

    Iterator<Entity> iter = datastore.get(KEY1, KEY2, KEY3);
    assertNull(iter.next());
    assertEquals(entity2, iter.next());
    assertEquals(ENTITY3, iter.next());
    assertFalse(iter.hasNext());

    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }

    try {
      transaction.rollback();
      fail("Expecting a failure");
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }

    verifyNotUsable(transaction);
  }

  @Test
  public void testTransactionWithRead() {
    Transaction transaction = datastore.newTransaction();
    assertNull(transaction.get(KEY3));
    transaction.add(ENTITY3);
    transaction.commit();
    assertEquals(ENTITY3, datastore.get(KEY3));

    transaction = datastore.newTransaction();
    assertEquals(ENTITY3, transaction.get(KEY3));
    // update entity3 during the transaction
    datastore.put(Entity.builder(ENTITY3).clear().build());
    transaction.update(ENTITY2);
    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreServiceException expected) {
      expected.printStackTrace();
      assertEquals(DatastoreServiceException.Code.ABORTED, expected.code());
    }
  }

  @Test
  public void testTransactionWithQuery() {
    fail("not implemented");
  }

  @Test
  public void testNewTransactionRollback() {
    Transaction transaction = datastore.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 = Entity.builder(ENTITY2).clear().setNull("bla")
        .set("list3", StringValue.of("bla"), StringValue.builder("bla").build()).build();
    transaction.update(entity2);
    transaction.delete(KEY1);
    transaction.rollback();
    transaction.rollback(); // should be safe to repeat rollback calls

    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }

    verifyNotUsable(transaction);

    Iterator<Entity> iter = datastore.get(KEY1, KEY2, KEY3);
    assertEquals(ENTITY1, iter.next());
    assertEquals(ENTITY2, iter.next());
    assertNull(iter.next());
    assertFalse(iter.hasNext());
  }

  private void verifyNotUsable(DatastoreWriter writer) {
    try {
      writer.add(ENTITY3);
      fail("Expecting a failure");
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }

    try {
      writer.put(ENTITY3);
      fail("Expecting a failure");
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }

    try {
      writer.update(ENTITY3);
      fail("Expecting a failure");
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }

    try {
      writer.delete(ENTITY3.key());
      fail("Expecting a failure");
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }
  }

  @Test
  public void testNewBatchWriter() {
    BatchWriter batchWriter = datastore.newBatchWriter();
    Entity entity1 = Entity.builder(ENTITY1).clear().build();
    Entity entity2 = Entity.builder(ENTITY2).clear().setNull("bla").build();
    Entity entity4 = Entity.builder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.builder(KEY5).set("value", "value").build();
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
      fail("Expecting a failure");
    } catch (DatastoreServiceException ex) {
      // expected to fail
    }
    verifyNotUsable(batchWriter);

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

    // TODO need to cover the cases of:
    // delete after put/add/update
    // put after delete/add/update
    // update after delete/add/put
    // add after delete/update/put
  }

  @Test
  public void testRunGqlQueryNoCasting() {
    fail("Not yet implemented");
  }

  @Test
  public void testRunGqlQueryWithCasting() {
    fail("Not yet implemented");
  }

  @Test
  public void testRunStructuredQueryFull() {
    fail("Not yet implemented");
  }

  @Test
  public void testRunStructuredQueryProjection() {
    fail("Not yet implemented");
  }

  @Test
  public void testRunStructuredQueryKeysOnly() {
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
    PartialKey partialKey1 = keyBuilder.build();
    PartialKey partialKey2 = keyBuilder.kind(KIND2).addAncestor(KIND1, 10).build();
    Key key3 = keyBuilder.build("name");
    Key key4 = keyBuilder.build(1);
    Iterator<Key> result =
        datastore.allocateId(partialKey1, partialKey2, key3, key4, partialKey1, key3);
    Map<Integer, Key> map = new HashMap<>();
    int count = 0;
    while (result.hasNext()) {
      map.put(++count, result.next());
    }
    assertEquals(6, map.size());
    assertEquals(partialKey1.newKey(map.get(1).id()), map.get(1));
    assertEquals(partialKey1.newKey(map.get(5).id()), map.get(5));
    assertEquals(partialKey2.newKey(map.get(2).id()), map.get(2));
    assertEquals(Key.builder(key3).id(map.get(3).id()).build(), map.get(3));
    assertEquals(Key.builder(key3).id(map.get(6).id()).build(), map.get(6));
    assertEquals(Key.builder(key4).id(map.get(4).id()).build(), map.get(4));
  }

  @Test
  public void testGet() {
    Entity entity = datastore.get(KEY3);
    assertNull(entity);

    entity = datastore.get(KEY1);
    assertEquals(ENTITY1, entity);
    StringValue value1 = entity.getValue("str");
    BooleanValue value2 = entity.getValue("bool");
    ListValue value3 = entity.getValue("list");
    assertEquals(value1, STR_VALUE);
    assertEquals(value2, BOOL_VALUE);
    assertEquals(value3, LIST_VALUE2);
    assertEquals(PARTIAL_ENTITY1, entity.getEntity("partial1"));
    assertEquals(4, entity.names().size());
    assertFalse(entity.contains("bla"));
  }

  @Test
  public void testGetArray() {
    datastore.put(ENTITY3);
    Iterator<Entity> result =
        datastore.get(KEY1, Key.builder(KEY1).name("bla").build(), KEY2, KEY3);
    assertEquals(ENTITY1, result.next());
    assertNull(result.next());
    assertEquals(ENTITY2, result.next());
    Entity entity3 = result.next();
    assertEquals(ENTITY3, entity3);
    assertTrue(entity3.isNull("null"));
    assertEquals(false, entity3.getBoolean("bool"));
    assertEquals(LIST_VALUE2.get(), entity3.getList("list"));
    PartialEntity partial1 = entity3.getEntity("partial1");
    Entity partial2 = (Entity) entity3.getEntity("partial2");
    assertEquals(partial1, PARTIAL_ENTITY2);
    assertEquals(partial2, ENTITY2);
    assertEquals(Value.Type.BOOLEAN, entity3.type("bool"));
    assertEquals(5, entity3.names().size());
    assertFalse(entity3.contains("bla"));
    try {
      entity3.getString("str");
      fail("Expecting a failure");
    } catch (DatastoreServiceException expected) {
      // expected - no such property
    }
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
      fail("Expecting a failure");
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
      fail("Expecting a failure");
    } catch (DatastoreServiceException expected) {
      // expected;
    }
    datastore.add(ENTITY3);
    assertEquals(ENTITY3, datastore.get(ENTITY3.key()));
    Entity entity3 = Entity.builder(ENTITY3).clear().set("bla", new NullValue()).build();
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

    Entity entity2 = Entity.builder(ENTITY2).clear().set("bla", new NullValue()).build();
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
    assertEquals(PartialKey.builder(PARTIAL_KEY1).kind(KIND2).build(),
        datastore.newKeyBuilder(KIND2).build());
    assertEquals(KEY1, keyBuilder.build("name"));
    assertEquals(Key.builder(KEY1).id(2).build(), keyBuilder.build(2));
  }
}
