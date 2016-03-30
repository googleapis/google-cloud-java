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

import com.google.gcloud.AuthCredentials;
import com.google.gcloud.BaseSerializationTest;
import com.google.gcloud.Restorable;
import com.google.gcloud.datastore.StructuredQuery.CompositeFilter;
import com.google.gcloud.datastore.StructuredQuery.OrderBy;
import com.google.gcloud.datastore.StructuredQuery.PropertyFilter;

public class SerializationTest extends BaseSerializationTest {

  private static final IncompleteKey INCOMPLETE_KEY1 =
      IncompleteKey.builder("ds", "k").ancestors(PathElement.of("p", 1)).build();
  private static final Key KEY1 = Key.builder("ds", "k", "n").build();
  private static final IncompleteKey INCOMPLETE_KEY2 =
      IncompleteKey.builder(KEY1, "v").ancestors(PathElement.of("p", 1)).build();
  private static final Key KEY2 = Key.builder(KEY1, "v", 2).build();
  private static final DateTime DATE_TIME1 = DateTime.now();
  private static final LatLng LAT_LNG = new LatLng(37.422035, -122.084124);
  private static final Blob BLOB1 = Blob.copyFrom(UTF_8.encode("hello world"));
  private static final Cursor CURSOR1 = Cursor.copyFrom(new byte[] {1, 2});
  private static final Cursor CURSOR2 = Cursor.copyFrom(new byte[] {10});
  private static final Query<?> GQL1 =
      Query.gqlQueryBuilder("select * from kind1 where name = @name and age > @1")
      .setBinding("name", "name1")
      .addBinding(20)
      .namespace("ns1")
      .build();
  private static final Query<Entity> GQL2 =
      Query.gqlQueryBuilder(
          Query.ResultType.ENTITY, "select * from kind1 where name = @name and age > @1")
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
  private static final Query<ProjectionEntity> QUERY3 =
      Query.projectionEntityQueryBuilder()
          .kind("k")
          .namespace("ns1")
          .projection("p")
          .limit(100)
          .offset(5)
          .startCursor(CURSOR1)
          .endCursor(CURSOR2)
          .filter(CompositeFilter.and(PropertyFilter.gt("p1", 10), PropertyFilter.eq("a", "v")))
          .addDistinctOn("p")
          .addOrderBy(OrderBy.asc("p"))
          .build();
  private static final KeyValue KEY_VALUE = KeyValue.of(KEY1);
  private static final NullValue NULL_VALUE = NullValue.builder().excludeFromIndexes(true).build();
  private static final StringValue STRING_VALUE = StringValue.of("hello");
  private static final LongValue LONG_VALUE = LongValue.of(123);
  private static final DoubleValue DOUBLE_VALUE = DoubleValue.of(12.34);
  private static final BooleanValue BOOLEAN_VALUE = BooleanValue.of(true);
  private static final DateTimeValue DATE_AND_TIME_VALUE = DateTimeValue.of(DateTime.now());
  private static final BlobValue BLOB_VALUE = BlobValue.of(BLOB1);
  private static final RawValue RAW_VALUE = 
      RawValue.of(com.google.datastore.v1beta3.Value.newBuilder().setMeaning(18).build());
  private static final LatLngValue LAT_LNG_VALUE = LatLngValue.of(LAT_LNG);
  private static final Entity ENTITY1 = Entity.builder(KEY1).build();
  private static final Entity ENTITY2 =
      Entity.builder(KEY2).set("null", NullValue.of()).build();
  private static final Entity ENTITY3 = Entity.builder(KEY2)
      .set("p1", StringValue.builder("hi1").meaning(10).build())
      .set("p2", StringValue.builder("hi2").meaning(11).excludeFromIndexes(true).build())
      .set("p3", LongValue.builder(100).excludeFromIndexes(true).meaning(100).build())
      .set("blob", BLOB1)
      .build();
  private static final FullEntity<IncompleteKey> EMBEDDED_ENTITY = Entity.builder(INCOMPLETE_KEY1)
      .set("p1", STRING_VALUE)
      .set("p2", LongValue.builder(100).excludeFromIndexes(true).meaning(100).build())
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
  private static final DatastoreException DATASTORE_EXCEPTION =
      new DatastoreException(42, "message", "reason");

  @Override
  protected java.io.Serializable[] serializableObjects() {
    DatastoreOptions options = DatastoreOptions.builder()
        .authCredentials(AuthCredentials.createForAppEngine())
        .normalizeDataset(false)
        .projectId("ds1")
        .build();
    DatastoreOptions otherOptions = options.toBuilder()
        .namespace("ns1")
        .authCredentials(null)
        .build();
    return new java.io.Serializable[]{KEY1, KEY2, INCOMPLETE_KEY1, INCOMPLETE_KEY2, ENTITY1,
        ENTITY2, ENTITY3, EMBEDDED_ENTITY, PROJECTION_ENTITY, DATE_TIME1, BLOB1, CURSOR1, GQL1,
        GQL2, QUERY1, QUERY2, QUERY3, NULL_VALUE, KEY_VALUE, STRING_VALUE, EMBEDDED_ENTITY_VALUE1,
        EMBEDDED_ENTITY_VALUE2, EMBEDDED_ENTITY_VALUE3, LIST_VALUE, LONG_VALUE, DOUBLE_VALUE,
        BOOLEAN_VALUE, DATE_AND_TIME_VALUE, BLOB_VALUE, RAW_VALUE, LAT_LNG_VALUE,
        DATASTORE_EXCEPTION, options, otherOptions};
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    return null;
  }
}
