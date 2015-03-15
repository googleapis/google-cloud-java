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

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.gcloud.datastore.StructuredQuery.CompositeFilter;
import com.google.gcloud.datastore.StructuredQuery.OrderBy;
import com.google.gcloud.datastore.StructuredQuery.Projection;
import com.google.gcloud.datastore.StructuredQuery.PropertyFilter;
import com.google.gcloud.datastore.Value.Type;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

  private static final IncompleteKey INCOMPLETE_KEY1 =
      IncompleteKey.builder("ds", "k").ancestors(PathElement.of("p", 1)).build();
  private static final Key KEY1 = Key.builder("ds", "k", "n").build();
  private static final IncompleteKey INCOMPLETE_KEY2 =
      IncompleteKey.builder(KEY1, "v").ancestors(PathElement.of("p", 1)).build();
  private static final Key KEY2 = Key.builder(KEY1, "v", 2).build();
  private static final DateTime DATE_TIME1 = DateTime.now();
  private static final Blob BLOB1 = Blob.copyFrom(UTF_8.encode("hello world"));
  private static final Cursor CURSOR1 = Cursor.copyFrom(new byte[] {1,2});
  private static final Cursor CURSOR2 = Cursor.copyFrom(new byte[] {10});
  private static final Query<?> GQL1 =
      Query.gqlQueryBuilder("select * from kind1 where name = @name and age > @1")
      .setBinding("name", "name1")
      .addBinding(20)
      .namespace("ns1")
      .build();
  private static final Query<Entity> GQL2 =
      Query.gqlQueryBuilder(Query.ResultType.ENTITY, "select * from kind1 where name = @name and age > @1")
      .setBinding("name", "name1")
      .addBinding(20)
      .namespace("ns1")
      .build();
  private static final Query<Entity> QUERY1 =
      Query.entityQueryBuilder().kind("kind1").build();
  private static final Query<Key> QUERY2 = Query.keyQueryBuilder()
      .kind("k")
      .filter(PropertyFilter.eq("p1", "hello"))
      .build();
  private static final Query<ProjectionEntity> QUERY3 = Query.projectionQueryBuilder()
      .kind("k")
      .namespace("ns1")
      .projection(Projection.property("p"))
      .limit(100)
      .offset(5)
      .startCursor(CURSOR1)
      .endCursor(CURSOR2)
      .filter(CompositeFilter.and(PropertyFilter.gt("p1", 10), PropertyFilter.eq("a", "v")))
      .addGroupBy("p")
      .addOrderBy(OrderBy.asc("p"))
      .build();
  private static final KeyValue KEY_VALUE = KeyValue.of(KEY1);
  private static final NullValue NULL_VALUE = NullValue.builder().indexed(true).build();
  private static final StringValue STRING_VALUE = StringValue.of("hello");
  private static final LongValue LONG_VALUE = LongValue.of(123);
  private static final DoubleValue DOUBLE_VALUE = DoubleValue.of(12.34);
  private static final BooleanValue BOOLEAN_VALUE = BooleanValue.of(true);
  private static final DateTimeValue DATE_AND_TIME_VALUE = DateTimeValue.of(DateTime.now());
  private static final BlobValue BLOB_VALUE = BlobValue.of(BLOB1);
  private static final RawValue RAW_VALUE = RawValue.of(
      DatastoreV1.Value.newBuilder().setBlobKeyValue("blob-key").setMeaning(18).build());
  private static final Entity ENTITY1 = Entity.builder(KEY1).build();
  private static final Entity ENTITY2 =
      Entity.builder(KEY2).set("null", NullValue.of()).build();
  private static final Entity ENTITY3 = Entity.builder(KEY2)
      .set("p1", StringValue.builder("hi1").meaning(10).build())
      .set("p2", StringValue.builder("hi2").meaning(11).indexed(false).build())
      .set("p3", LongValue.builder(100).indexed(false).meaning(100).build())
      .set("blob", BLOB1)
      .build();
  private static final FullEntity<IncompleteKey> EMBEDDED_ENTITY = Entity.builder(INCOMPLETE_KEY1)
      .set("p1", STRING_VALUE)
      .set("p2", LongValue.builder(100).indexed(false).meaning(100).build())
      .build();
  private static final EntityValue EMBEDDED_ENTITY_VALUE1 = EntityValue.of(ENTITY1);
  private static final EntityValue EMBEDDED_ENTITY_VALUE2 = EntityValue.of(ENTITY2);
  private static final EntityValue EMBEDDED_ENTITY_VALUE3 = EntityValue.of(EMBEDDED_ENTITY);
  private static final ListValue LIST_VALUE = ListValue.builder()
      .addValue(NULL_VALUE)
      .addValue(STRING_VALUE)
      .addValue(new NullValue())
      .build();
  private static final ProjectionEntity PROJECTION_ENTITY = ProjectionEntity.fromPb(ENTITY1.toPb());

  @SuppressWarnings("rawtypes")
  private static final Multimap<Type, Value> TYPE_TO_VALUES =
      ImmutableMultimap.<Type, Value>builder()
      .put(Type.NULL, NULL_VALUE)
      .put(Type.KEY, KEY_VALUE)
      .put(Type.STRING, STRING_VALUE)
      .putAll(Type.ENTITY, EMBEDDED_ENTITY_VALUE1, EMBEDDED_ENTITY_VALUE2,
          EMBEDDED_ENTITY_VALUE3)
      .put(Type.LIST, LIST_VALUE)
      .put(Type.LONG, LONG_VALUE)
      .put(Type.DOUBLE, DOUBLE_VALUE)
      .put(Type.BOOLEAN, BOOLEAN_VALUE)
      .put(Type.DATE_TIME, DATE_AND_TIME_VALUE)
      .put(Type.BLOB, BLOB_VALUE)
      .put(Type.RAW_VALUE, RAW_VALUE)
      .build();

  @Test
  public void testValues() throws Exception {
    for (Type type : Type.values()) {
      for (Value<?> value : TYPE_TO_VALUES.get(type)) {
        Value<?> copy = serializeAndDeserialize(value);
        assertEquals(value, value);
        assertEquals(value, copy);
        assertNotSame(value, copy);
        assertEquals(copy, copy);
        assertEquals(value.get(), copy.get());
      }
    }
  }

  @Test
  public void testTypes() throws Exception {
    Serializable[] types = { KEY1, KEY2, INCOMPLETE_KEY1, INCOMPLETE_KEY2, ENTITY1, ENTITY2,
        ENTITY3, EMBEDDED_ENTITY, PROJECTION_ENTITY, DATE_TIME1, BLOB1, CURSOR1, GQL1, GQL2,
        QUERY1, QUERY2, QUERY3};
    for (Serializable obj : types) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @SuppressWarnings("unchecked")
  private <T extends Serializable> T serializeAndDeserialize(T obj)
      throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(obj);
    }
    try (ObjectInputStream input =
        new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
      return (T) input.readObject();
    }
  }
}
