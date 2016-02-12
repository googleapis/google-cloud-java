/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BaseEntityTest {

  private static final Blob BLOB = Blob.copyFrom(new byte[]{1, 2});
  private static final DateTime DATE_TIME = DateTime.now();
  private static final Key KEY = Key.builder("ds1", "k1", "n1").build();
  private static final Entity ENTITY = Entity.builder(KEY).set("name", "foo").build();
  private static final IncompleteKey INCOMPLETE_KEY = IncompleteKey.builder("ds1", "k1").build();
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY =
      Entity.builder(INCOMPLETE_KEY).build();

  private Builder builder;

  private class Builder extends BaseEntity.Builder<Key, Builder> {

    @Override public BaseEntity<Key> build() {

      return new BaseEntity<Key>(this) {

        @Override
        protected BaseEntityTest.Builder emptyBuilder() {
          return new BaseEntityTest.Builder();
        }
      };
    }
  }

  @Before
  public void setUp() {
    builder = new Builder();
    builder.set("blob", BLOB).set("boolean", true).set("dateTime", DATE_TIME);
    builder.set("double", 1.25).set("key", KEY).set("string", "hello world");
    builder.set("long", 125).setNull("null").set("entity", ENTITY);
    builder.set("partialEntity", PARTIAL_ENTITY).set("stringValue", StringValue.of("bla"));
    builder.set("list1", NullValue.of(), StringValue.of("foo"));
    builder.set("list2", ImmutableList.of(LongValue.of(10), DoubleValue.of(2)));
    builder.set("list3", Collections.singletonList(BooleanValue.of(true)));
    builder.set(
        "blobList", BLOB, Blob.copyFrom(new byte[] {3, 4}), Blob.copyFrom(new byte[] {5, 6}));
    builder.set("booleanList", true, false, true);
    builder.set("dateTimeList", DateTime.now(), DateTime.now(), DateTime.now());
    builder.set("doubleList", 12.3, 4.56, .789);
    builder.set("keyList", KEY, Key.builder("ds2", "k2", "n2").build(),
        Key.builder("ds3", "k3", "n3").build());
    builder.set("entityList", ENTITY, PARTIAL_ENTITY);
    builder.set("stringList", "s1", "s2", "s3");
    builder.set("longList", 1, 23, 456);
  }

  @Test
  public void testContains() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertTrue(entity.contains("list1"));
    assertFalse(entity.contains("bla"));
    entity = builder.clear().build();
    assertFalse(entity.contains("list1"));
  }

  @Test
  public void testGetValue() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertEquals(BlobValue.of(BLOB), entity.getValue("blob"));
  }

  @Test(expected = DatastoreException.class)
  public void testGetValueNotFound() throws Exception {
    BaseEntity<Key> entity = builder.clear().build();
    entity.getValue("blob");
  }

  @Test
  public void testIsNull() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertTrue(entity.isNull("null"));
    assertFalse(entity.isNull("blob"));
    entity = builder.setNull("blob").build();
    assertTrue(entity.isNull("blob"));
  }

  @Test(expected = DatastoreException.class)
  public void testIsNullNotFound() throws Exception {
    BaseEntity<Key> entity = builder.clear().build();
    entity.isNull("null");
  }

  @Test
  public void testGetString() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertEquals("hello world", entity.getString("string"));
    assertEquals("bla", entity.getString("stringValue"));
    entity = builder.set("string", "foo").build();
    assertEquals("foo", entity.getString("string"));
  }

  @Test
  public void testGetLong() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertEquals(125, entity.getLong("long"));
    entity = builder.set("long", LongValue.of(10)).build();
    assertEquals(10, entity.getLong("long"));
  }

  @Test
  public void testGetDouble() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertEquals(1.25, entity.getDouble("double"), 0);
    entity = builder.set("double", DoubleValue.of(10)).build();
    assertEquals(10, entity.getDouble("double"), 0);
  }

  @Test
  public void testGetBoolean() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertTrue(entity.getBoolean("boolean"));
    entity = builder.set("boolean", BooleanValue.of(false)).build();
    assertFalse(entity.getBoolean("boolean"));
  }

  @Test
  public void testGetDateTime() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertEquals(DATE_TIME, entity.getDateTime("dateTime"));
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    DateTime dateTime = DateTime.copyFrom(cal);
    entity = builder.set("dateTime", DateTimeValue.of(dateTime)).build();
    assertEquals(dateTime, entity.getDateTime("dateTime"));
  }

  @Test
  public void testGetKey() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertEquals(KEY, entity.getKey("key"));
    Key key = Key.builder(KEY).name("BLA").build();
    entity = builder.set("key", key).build();
    assertEquals(key, entity.getKey("key"));
  }

  @Test
  public void testGetEntity() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertEquals(ENTITY, entity.getEntity("entity"));
    assertEquals(PARTIAL_ENTITY, entity.getEntity("partialEntity"));
    entity = builder.set("entity", EntityValue.of(PARTIAL_ENTITY)).build();
    assertEquals(PARTIAL_ENTITY, entity.getEntity("entity"));
  }

  @Test
  public void testGetList() throws Exception {
    BaseEntity<Key> entity = builder.build();
    List<? extends Value<?>> list = entity.getList("list1");
    assertEquals(2, list.size());
    assertEquals(NullValue.of(), list.get(0));
    assertEquals("foo", list.get(1).get());
    list = entity.getList("list2");
    assertEquals(2, list.size());
    assertEquals(Long.valueOf(10), list.get(0).get());
    assertEquals(Double.valueOf(2), list.get(1).get());
    list = entity.getList("list3");
    assertEquals(1, list.size());
    assertEquals(Boolean.TRUE, list.get(0).get());
    entity = builder.set("list1", ListValue.of(list)).build();
    assertEquals(list, entity.getList("list1"));
    List<Value<?>> stringList = entity.getList("stringList");
    assertEquals(
        ImmutableList.of(StringValue.of("s1"), StringValue.of("s2"), StringValue.of("s3")),
        stringList);
    List<Value<Double>> doubleList = entity.getList("doubleList");
    assertEquals(
        ImmutableList.of(DoubleValue.of(12.3), DoubleValue.of(4.56), DoubleValue.of(.789)),
        doubleList);
    List<EntityValue> entityList = entity.getList("entityList");
    assertEquals(
        ImmutableList.of(EntityValue.of(ENTITY), EntityValue.of(PARTIAL_ENTITY)), entityList);
  }

  @Test
  public void testGetBlob() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertEquals(BLOB, entity.getBlob("blob"));
    Blob blob = Blob.copyFrom(new byte[] {});
    entity = builder.set("blob", BlobValue.of(blob)).build();
    assertEquals(blob, entity.getBlob("blob"));
  }

  @Test
  public void testNames() throws Exception {
    Set<String> names = ImmutableSet.<String>builder()
        .add("string", "stringValue", "boolean", "double", "long", "list1", "list2", "list3")
        .add("entity", "partialEntity", "null", "dateTime", "blob", "key", "blobList")
        .add("booleanList", "dateTimeList", "doubleList", "keyList", "entityList", "stringList")
        .add("longList")
        .build();
    BaseEntity<Key> entity = builder.build();
    assertEquals(names, entity.names());
  }
}
