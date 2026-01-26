/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.BaseSerializationTest;
import com.google.cloud.NoCredentials;
import com.google.cloud.Restorable;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

public class SerializationTest extends BaseSerializationTest {

  private static final IncompleteKey INCOMPLETE_KEY1 =
      IncompleteKey.newBuilder("ds", "k").addAncestor(PathElement.of("p", 1)).build();
  private static final Key KEY1 = Key.newBuilder("ds", "k", "n").build();
  private static final IncompleteKey INCOMPLETE_KEY2 =
      IncompleteKey.newBuilder(KEY1, "v").addAncestor(PathElement.of("p", 1)).build();
  private static final Key KEY2 = Key.newBuilder(KEY1, "v", 2).build();
  private static final Timestamp TIMESTAMP = Timestamp.now();
  private static final LatLng LAT_LNG = new LatLng(37.422035, -122.084124);
  private static final Blob BLOB1 = Blob.copyFrom(UTF_8.encode("hello world"));
  private static final Cursor CURSOR1 = Cursor.copyFrom(new byte[] {1, 2});
  private static final Cursor CURSOR2 = Cursor.copyFrom(new byte[] {10});
  private static final Query<?> GQL1 =
      Query.newGqlQueryBuilder("select * from kind1 where name = @name and age > @1")
          .setBinding("name", "name1")
          .addBinding(20)
          .setNamespace("ns1")
          .build();
  private static final Query<Entity> GQL2 =
      Query.newGqlQueryBuilder(
              Query.ResultType.ENTITY, "select * from kind1 where name = @name and age > @1")
          .setBinding("name", "name1")
          .addBinding(20)
          .setNamespace("ns1")
          .build();
  private static final Query<Entity> QUERY1 =
      Query.newEntityQueryBuilder().setKind("kind1").build();
  private static final Query<Key> QUERY2 =
      Query.newKeyQueryBuilder().setKind("k").setFilter(PropertyFilter.eq("p1", "hello")).build();
  private static final Query<ProjectionEntity> QUERY3 =
      Query.newProjectionEntityQueryBuilder()
          .setKind("k")
          .setNamespace("ns1")
          .addProjection("p")
          .setLimit(100)
          .setOffset(5)
          .setStartCursor(CURSOR1)
          .setEndCursor(CURSOR2)
          .setFilter(CompositeFilter.and(PropertyFilter.gt("p1", 10), PropertyFilter.eq("a", "v")))
          .addDistinctOn("p")
          .addOrderBy(OrderBy.asc("p"))
          .build();
  private static final Query<ProjectionEntity> QUERY4 =
      Query.newProjectionEntityQueryBuilder()
          .setKind("k")
          .setNamespace("ns1")
          .addProjection("p")
          .setLimit(100)
          .setOffset(5)
          .setStartCursor(CURSOR1)
          .setEndCursor(CURSOR2)
          .setFilter(CompositeFilter.or(PropertyFilter.gt("p1", 10), PropertyFilter.eq("a", "v")))
          .addDistinctOn("p")
          .addOrderBy(OrderBy.asc("p"))
          .build();
  private static final KeyValue KEY_VALUE = KeyValue.of(KEY1);
  private static final NullValue NULL_VALUE =
      NullValue.newBuilder().setExcludeFromIndexes(true).build();
  private static final StringValue STRING_VALUE = StringValue.of("hello");
  private static final LongValue LONG_VALUE = LongValue.of(123);
  private static final DoubleValue DOUBLE_VALUE = DoubleValue.of(12.34);
  private static final BooleanValue BOOLEAN_VALUE = BooleanValue.of(true);
  private static final TimestampValue TIMESTAMP_VALUE = TimestampValue.of(Timestamp.now());
  private static final BlobValue BLOB_VALUE = BlobValue.of(BLOB1);
  private static final RawValue RAW_VALUE =
      RawValue.of(com.google.datastore.v1.Value.newBuilder().setMeaning(18).build());
  private static final LatLngValue LAT_LNG_VALUE = LatLngValue.of(LAT_LNG);
  private static final Entity ENTITY1 = Entity.newBuilder(KEY1).build();
  private static final Entity ENTITY2 = Entity.newBuilder(KEY2).set("null", NullValue.of()).build();
  private static final Entity ENTITY3 =
      Entity.newBuilder(KEY2)
          .set("p1", StringValue.newBuilder("hi1").setMeaning(10).build())
          .set(
              "p2",
              StringValue.newBuilder("hi2").setMeaning(11).setExcludeFromIndexes(true).build())
          .set("p3", LongValue.newBuilder(100).setExcludeFromIndexes(true).setMeaning(100).build())
          .set("blob", BLOB1)
          .build();
  private static final FullEntity<IncompleteKey> EMBEDDED_ENTITY =
      Entity.newBuilder(INCOMPLETE_KEY1)
          .set("p1", STRING_VALUE)
          .set("p2", LongValue.newBuilder(100).setExcludeFromIndexes(true).setMeaning(100).build())
          .build();
  private static final EntityValue EMBEDDED_ENTITY_VALUE1 = EntityValue.of(ENTITY1);
  private static final EntityValue EMBEDDED_ENTITY_VALUE2 = EntityValue.of(ENTITY2);
  private static final EntityValue EMBEDDED_ENTITY_VALUE3 = EntityValue.of(EMBEDDED_ENTITY);
  private static final ListValue LIST_VALUE =
      ListValue.newBuilder()
          .addValue(NULL_VALUE)
          .addValue(STRING_VALUE)
          .addValue(new NullValue())
          .build();
  private static final ProjectionEntity PROJECTION_ENTITY = ProjectionEntity.fromPb(ENTITY1.toPb());
  private static final DatastoreException DATASTORE_EXCEPTION =
      new DatastoreException(42, "message", "reason");

  @Override
  protected java.io.Serializable[] serializableObjects() {
    DatastoreOptions options =
        DatastoreOptions.newBuilder()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("ds1")
            .build();
    DatastoreOptions otherOptions = options.toBuilder().setNamespace("ns1").build();
    return new java.io.Serializable[] {
      KEY1,
      KEY2,
      INCOMPLETE_KEY1,
      INCOMPLETE_KEY2,
      ENTITY1,
      ENTITY2,
      ENTITY3,
      EMBEDDED_ENTITY,
      PROJECTION_ENTITY,
      TIMESTAMP,
      BLOB1,
      CURSOR1,
      GQL1,
      GQL2,
      QUERY1,
      QUERY2,
      QUERY3,
      QUERY4,
      NULL_VALUE,
      KEY_VALUE,
      STRING_VALUE,
      EMBEDDED_ENTITY_VALUE1,
      EMBEDDED_ENTITY_VALUE2,
      EMBEDDED_ENTITY_VALUE3,
      LIST_VALUE,
      LONG_VALUE,
      DOUBLE_VALUE,
      BOOLEAN_VALUE,
      TIMESTAMP_VALUE,
      BLOB_VALUE,
      RAW_VALUE,
      LAT_LNG_VALUE,
      DATASTORE_EXCEPTION,
      options,
      otherOptions
    };
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    return null;
  }
}
