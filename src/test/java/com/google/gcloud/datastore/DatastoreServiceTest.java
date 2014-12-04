package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.datastore.client.LocalDevelopmentDatastore;
import com.google.api.services.datastore.client.LocalDevelopmentDatastoreException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

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
  private static final Key KEY1 = PARTIAL_KEY1.toKey("name");
  private static final Key KEY2 = new Key.Builder(KEY1, KIND2, 1).build();
  private static final Key KEY3 = KEY2.builder().name("bla").build();
  private static final Entity ENTITY1 = new Entity.Builder(KEY1)
      .setProperty("str", STR_VALUE)
      .setProperty("bool", BOOL_VALUE)
      .build();
  private static final Entity ENTITY2 = new Entity.Builder(KEY2, ENTITY1)
      .removeProperty("str")
      .setProperty("null", NULL_VALUE)
      .build();

  private DatastoreServiceOptions options;
  private DatastoreService datastore;
  private LocalDevelopmentDatastore localDatastore;

  @Before
  public void setUp() throws LocalDevelopmentDatastoreException {
    options = new DatastoreServiceOptions.Builder()
        .dataset(DATASET)
        .host("http://localhost:8080/")
        .build();
    datastore = DatastoreServiceFactory.Mode.TESTING.get(options);
    localDatastore = (LocalDevelopmentDatastore) ((DatastoreServiceImpl) datastore).datastore();
    localDatastore.start("/usr/local/gcd-sdk", DATASET);
  }

  @After
  public void tearDown() throws LocalDevelopmentDatastoreException {
    localDatastore.stop();
  }

  @Test
  public void testGetOptions() {
    assertSame(options, datastore.getOptions());
  }

  @Test
  public void testNewTransaction() {
    fail("Not yet implemented");
  }

  @Test
  public void testNewBatchWriter() {
    fail("Not yet implemented");
  }

  @Test
  public void testAllocateId() {
    fail("Not yet implemented");
  }

  @Test
  public void testAllocateIds() {
    fail("Not yet implemented");
  }

  @Test
  public void testAddAndGet() {
    Entity entity = datastore.get(KEY1);
    assertNull(entity);

    datastore.add(ENTITY1);

    entity = datastore.get(KEY1);
    StringValue value1 = entity.property("str");
    BooleanValue value2 = entity.property("bool");
    assertEquals(value1, STR_VALUE);
    assertEquals(value2, BOOL_VALUE);
    assertEquals(2, entity.propertyNames().size());
    assertTrue(entity.propertyNames().contains("str"));
    assertTrue(entity.propertyNames().contains("bool"));
    assertFalse(entity.hasProperty("bla"));
  }

  @Test
  public void testAddAndGetArray() {
    Iterator<Entity> result = datastore.get(KEY1, KEY2);
    assertNull(result.next());
    assertNull(result.next());
    assertFalse(result.hasNext());

    populateDatastore();

    result = datastore.get(KEY1, KEY1.builder().name("bla").build(), KEY2);
    assertEquals(ENTITY1, result.next());
    assertNull(result.next());
    assertEquals(ENTITY2, result.next());
    assertFalse(result.hasNext());
  }

  private void populateDatastore() {
    datastore.add(ENTITY1, ENTITY2);
  }

  @Test
  public void testAdd() {
    fail("Not yet implemented");
  }

  @Test
  public void testUpdate() {
    fail("Not yet implemented");
  }

  @Test
  public void testPut() {
    fail("Not yet implemented");
  }

  @Test
  public void testDelete() {
    fail("Not yet implemented");
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
