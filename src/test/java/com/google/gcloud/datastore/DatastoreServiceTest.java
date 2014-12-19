package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreException;
import com.google.common.collect.Maps;
import com.google.gcloud.datastore.Query.Type;
import com.google.gcloud.datastore.StructuredQuery.OrderBy;
import com.google.gcloud.datastore.StructuredQuery.Projection;
import com.google.gcloud.datastore.StructuredQuery.PropertyFilter;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
  private static final DateTimeValue DATE_TIME_VALUE = new DateTimeValue(DateTime.now());
  private static final PartialEntity PARTIAL_ENTITY1 = PartialEntity.builder(PARTIAL_KEY2)
      .set("str", STR_VALUE).set("bool", BOOL_VALUE).set("list", LIST_VALUE1).build();
  private static final PartialEntity PARTIAL_ENTITY2 = PartialEntity.builder(PARTIAL_ENTITY1)
      .remove("str").set("bool", true).set("list", LIST_VALUE1.get()).build();
  private static final Entity ENTITY1 = Entity.builder(KEY1)
      .set("str", STR_VALUE)
      .set("date", DATE_TIME_VALUE)
      .set("bool", BOOL_VALUE)
      .set("partial1", EntityValue.of(PARTIAL_ENTITY1))
      .set("list", LIST_VALUE2)
      .build();
  private static final Entity ENTITY2 = Entity.builder(ENTITY1).key(KEY2).remove("str")
      .set("name", "koko").setNull("null").set("age", 20).build();
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
    assertSame(options, datastore.options());
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

    List<Entity> list = fetch(KEY1, KEY2, KEY3);
    assertNull(list.get(0));
    assertEquals(entity2, list.get(1));
    assertEquals(ENTITY3, list.get(2));
    assertEquals(3, list.size());

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
    Query<Entity> query =
        StructuredQuery.builder().kind(KIND2).filter(PropertyFilter.hasAncestor(KEY2)).build();
    Transaction transaction = datastore.newTransaction();
    QueryResult<Entity> results = transaction.run(query);
    assertEquals(ENTITY2, results.next());
    assertFalse(results.hasNext());
    transaction.add(ENTITY3);
    transaction.commit();
    assertEquals(ENTITY3, datastore.get(KEY3));

    transaction = datastore.newTransaction();
    results = transaction.run(query);
    assertEquals(ENTITY2, results.next());
    transaction.delete(ENTITY3.key());
    // update entity2 during the transaction
    datastore.put(Entity.builder(ENTITY2).clear().build());
    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreServiceException expected) {
      expected.printStackTrace();
      assertEquals(DatastoreServiceException.Code.ABORTED, expected.code());
    }
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

    List<Entity> list = fetch(KEY1, KEY2, KEY3);
    assertEquals(ENTITY1, list.get(0));
    assertEquals(ENTITY2, list.get(1));
    assertNull(list.get(2));
    assertEquals(3, list.size());
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
    Iterator<Entity> entities = fetch(KEY1, KEY2, KEY3, entity4.key(), entity5.key()).iterator();
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
    entities = fetch(KEY1, KEY2, KEY3, entity4.key(), entity5.key()).iterator();
    assertEquals(ENTITY1, entities.next());
    assertEquals(ENTITY2, entities.next());
    assertEquals(ENTITY3, entities.next());
    assertNull(entities.next());
    assertNull(entities.next());
    assertFalse(entities.hasNext());

    // TODO need to cover the following use-cases:
    // delete after put/add/update
    // put after delete/add/update
    // update after delete/add/put
    // add after delete/update/put
  }

  @Test
  public void testRunGqlQueryNoCasting() throws DatastoreException {
    Query<Entity> query1 = GqlQuery.builder(Type.FULL, "select * from " + KIND1).build();
    QueryResult<Entity> results1 = datastore.run(query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    datastore.put(ENTITY3);
    Query<? extends PartialEntity> query2 =  GqlQuery.builder(
        Type.FULL, "select * from " + KIND2 + " order by __key__").build();
    QueryResult<? extends PartialEntity> results2 = datastore.run(query2);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY2, results2.next());
    assertTrue(results2.hasNext());
    assertEquals(ENTITY3, results2.next());
    assertFalse(results2.hasNext());

    query1 = GqlQuery.builder(Type.FULL, "select * from bla").build();
    results1 = datastore.run(query1);
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery =
        GqlQuery.builder(Type.KEY_ONLY, "select __key__ from " + KIND1).build();
    QueryResult<Key> keyOnlyResults = datastore.run(keyOnlyQuery);
    assertTrue(keyOnlyResults.hasNext());
    assertEquals(KEY1, keyOnlyResults.next());
    assertFalse(keyOnlyResults.hasNext());

    GqlQuery<ProjectionEntity> keyProjectionQuery = GqlQuery.builder(
        Type.PROJECTION, "select __key__ from " + KIND1).build();
    QueryResult<ProjectionEntity> keyProjectionResult = datastore.run(keyProjectionQuery);
    assertTrue(keyProjectionResult.hasNext());
    ProjectionEntity p = keyProjectionResult.next();
    assertEquals(KEY1, p.key());
    assertTrue(p.properties().isEmpty());
    assertFalse(keyProjectionResult.hasNext());

    GqlQuery<ProjectionEntity> projectionQuery = GqlQuery.builder(
        Type.PROJECTION, "select str, date from " + KIND1).build();

    // this hack is needed because of b/18806697
    DatastoreV1.RunQueryRequest.Builder requestPb = DatastoreV1.RunQueryRequest.newBuilder();
    requestPb.setGqlQuery(projectionQuery.toPb());
    requestPb.setPartitionId(DatastoreV1.PartitionId.newBuilder().setDatasetId(DATASET).build());
    DatastoreV1.RunQueryResponse responsePb =
        ((DatastoreServiceImpl) datastore).run(requestPb.build());
    DatastoreV1.RunQueryResponse.Builder responsePbBuilder = responsePb.toBuilder();
    responsePbBuilder.getBatchBuilder()
        .setEntityResultType(DatastoreV1.EntityResult.ResultType.PROJECTION).build();
    Datastore mockDatastore = EasyMock.createMock(Datastore.class);
    EasyMock.expect(mockDatastore.runQuery(requestPb.build())).andReturn(responsePbBuilder.build());
    EasyMock.replay(mockDatastore);
    datastore = DatastoreServiceFactory.getDefault(
        datastore.options().toBuilder().datastore(mockDatastore).build());
    // end of hack

    QueryResult<ProjectionEntity> projectionResult = datastore.run(projectionQuery);
    assertTrue(projectionResult.hasNext());
    ProjectionEntity projectionEntity = projectionResult.next();
    assertEquals("str", projectionEntity.getString("str"));
    assertEquals(DATE_TIME_VALUE.get(), projectionEntity.getDateTime("date"));
    assertEquals(DATE_TIME_VALUE.get().timestampMicroseconds(),
        projectionEntity.getLong("date"));
    assertEquals(2, projectionEntity.names().size());
    assertFalse(projectionResult.hasNext());
    EasyMock.verify(mockDatastore);
  }

  @Test
  public void testRunGqlQueryWithCasting() {
    @SuppressWarnings("unchecked")
    Query<Entity> query1 = (Query<Entity>) GqlQuery.builder("select * from " + KIND1).build();
    QueryResult<Entity> results1 = datastore.run(query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<?> query2 = GqlQuery.builder("select * from " + KIND1).build();
    QueryResult<?> results2 = datastore.run(query2);
    assertEquals(Entity.class, results2.resultClass());
    @SuppressWarnings("unchecked")
    QueryResult<Entity> results3 = (QueryResult<Entity>) results2;
    assertTrue(results3.hasNext());
    assertEquals(ENTITY1, results3.next());
    assertFalse(results3.hasNext());
  }

  @Test
  public void testRunStructuredQuery() throws DatastoreException {
    StructuredQuery<Entity> query =
        StructuredQuery.builder().kind(KIND1).orderBy(OrderBy.asc("__key__")).build();
    QueryResult<Entity> results1 = datastore.run(query);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    StructuredQuery<Key> keyOnlyQuery =  StructuredQuery.keyOnlyBuilder().kind(KIND1).build();
    QueryResult<Key> results2 = datastore.run(keyOnlyQuery);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY1.key(), results2.next());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> keyOnlyProjectionQuery = StructuredQuery.projectionBuilder()
        .kind(KIND1).projection(Projection.property("__key__")).build();
    QueryResult<ProjectionEntity> results3 = datastore.run(keyOnlyProjectionQuery);
    assertTrue(results3.hasNext());
    ProjectionEntity projectionEntity = results3.next();
    assertEquals(ENTITY1.key(), projectionEntity.key());
    assertTrue(projectionEntity.names().isEmpty());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> projectionQuery = StructuredQuery.projectionBuilder()
        .kind(KIND2)
        .projection(Projection.property("age"), Projection.first("name"))
        .filter(PropertyFilter.gt("age", 18))
        .groupBy("age")
        .orderBy(OrderBy.asc("age"))
        .limit(10)
        .build();
    // this hack is needed because of b/18806697
    DatastoreV1.RunQueryRequest.Builder requestPb = DatastoreV1.RunQueryRequest.newBuilder();
    requestPb.setQuery(projectionQuery.toPb());
    requestPb.setPartitionId(DatastoreV1.PartitionId.newBuilder().setDatasetId(DATASET).build());
    DatastoreV1.RunQueryResponse responsePb =
        ((DatastoreServiceImpl) datastore).run(requestPb.build());
    DatastoreV1.RunQueryResponse.Builder responsePbBuilder = responsePb.toBuilder();
    responsePbBuilder.getBatchBuilder()
        .setEntityResultType(DatastoreV1.EntityResult.ResultType.PROJECTION).build();
    Datastore mockDatastore = EasyMock.createMock(Datastore.class);
    EasyMock.expect(mockDatastore.runQuery(requestPb.build())).andReturn(responsePbBuilder.build());
    EasyMock.replay(mockDatastore);
    datastore = DatastoreServiceFactory.getDefault(
        datastore.options().toBuilder().datastore(mockDatastore).build());
    // end of hack

    QueryResult<ProjectionEntity> results4 = datastore.run(projectionQuery);
    assertTrue(results4.hasNext());
    ProjectionEntity entity = results4.next();
    assertEquals(ENTITY2.key(), entity.key());
    assertEquals(20, entity.getLong("age"));
    assertEquals("koko", entity.getString("name"));
    assertEquals(2, entity.properties().size());
    assertFalse(results4.hasNext());
    EasyMock.verify(mockDatastore);

    // TODO(ozarov): construct a test to verify nextQuery/pagination
  }

  @Test
  public void testAllocateId() {
    KeyFactory keyFactory = new KeyFactory(datastore, KIND1);
    PartialKey pk1 = keyFactory.newKey();
    Key key1 = keyFactory.allocateId();
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
    KeyFactory keyFactory = new KeyFactory(datastore, KIND1);
    PartialKey partialKey1 = keyFactory.newKey();
    PartialKey partialKey2 = keyFactory.kind(KIND2).addAncestor(KIND1, 10).newKey();
    Key key3 = keyFactory.newKey("name");
    Key key4 = keyFactory.newKey(1);
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
    DateTimeValue value4 = entity.getValue("date");
    PartialEntity value5 = entity.getEntity("partial1");
    assertEquals(STR_VALUE, value1);
    assertEquals(BOOL_VALUE, value2);
    assertEquals(LIST_VALUE2, value3);
    assertEquals(DATE_TIME_VALUE, value4);
    assertEquals(PARTIAL_ENTITY1, value5);
    assertEquals(5, entity.names().size());
    assertFalse(entity.contains("bla"));
  }

  @Test
  public void testGetArray() {
    datastore.put(ENTITY3);
    Iterator<Entity> result =
        fetch(KEY1, Key.builder(KEY1).name("bla").build(), KEY2, KEY3).iterator();
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
    assertEquals(6, entity3.names().size());
    assertFalse(entity3.contains("bla"));
    try {
      entity3.getString("str");
      fail("Expecting a failure");
    } catch (DatastoreServiceException expected) {
      // expected - no such property
    }
    assertFalse(result.hasNext());
    // TODO(ozarov): construct a test to verify more results
  }

  public List<Entity> fetch(Key key, Key... others) {
    Iterator<Entity> entities = datastore.get(key, others);
    Map<Key, Entity> map = Maps.newHashMapWithExpectedSize(1 + others.length);
    while (entities.hasNext()) {
      Entity entity = entities.next();
      map.put(entity.key(), entity);
    }
    List<Entity> list = new ArrayList<>(1 + others.length);
    list.add(map.get(key));
    for (Key other : others) {
      list.add(map.get(other));
    }
    return list;
  }

  @Test
  public void testAdd() {
    List<Entity> keys = fetch(ENTITY1.key(), ENTITY3.key());
    assertEquals(ENTITY1, keys.get(0));
    assertNull(keys.get(1));
    assertEquals(2, keys.size());

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
    List<Entity> keys = fetch(ENTITY1.key(), ENTITY3.key());
    assertEquals(ENTITY1, keys.get(0));
    assertNull(keys.get(1));
    assertEquals(2, keys.size());

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
    Iterator<Entity> keys = fetch(ENTITY1.key(), ENTITY2.key(), ENTITY3.key()).iterator();
    assertEquals(ENTITY1, keys.next());
    assertEquals(ENTITY2, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());

    Entity entity2 = Entity.builder(ENTITY2).clear().set("bla", new NullValue()).build();
    assertNotEquals(ENTITY2, entity2);
    datastore.put(ENTITY3, ENTITY1, entity2);
    keys = fetch(ENTITY1.key(), ENTITY2.key(), ENTITY3.key()).iterator();
    assertEquals(ENTITY1, keys.next());
    assertEquals(entity2, keys.next());
    assertEquals(ENTITY3, keys.next());
    assertFalse(keys.hasNext());
  }

  @Test
  public void testDelete() {
    Iterator<Entity> keys = fetch(ENTITY1.key(), ENTITY2.key(), ENTITY3.key()).iterator();
    assertEquals(ENTITY1, keys.next());
    assertEquals(ENTITY2, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
    datastore.delete(ENTITY1.key(), ENTITY2.key(), ENTITY3.key());
    keys = fetch(ENTITY1.key(), ENTITY2.key(), ENTITY3.key()).iterator();
    assertNull(keys.next());
    assertNull(keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
  }

  @Test
  public void testKeyFactory() {
    KeyFactory keyFactory = new KeyFactory(datastore, KIND1);
    assertEquals(PARTIAL_KEY1, keyFactory.newKey());
    assertEquals(PartialKey.builder(PARTIAL_KEY1).kind(KIND2).build(),
        new KeyFactory(datastore, KIND2).newKey());
    assertEquals(KEY1, keyFactory.newKey("name"));
    assertEquals(Key.builder(KEY1).id(2).build(), keyFactory.newKey(2));
  }
}
