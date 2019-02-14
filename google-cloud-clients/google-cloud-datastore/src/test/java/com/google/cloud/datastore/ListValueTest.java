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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ListValueTest {

  private static final List<Value<?>> CONTENT =
      ImmutableList.of(NullValue.of(), StringValue.of("foo"));
  private static final String STRING1 = "string1";
  private static final String STRING2 = "string2";
  private static final long LONG1 = 1L;
  private static final long LONG2 = 2L;
  private static final double DOUBLE1 = 1.0;
  private static final double DOUBLE2 = 2.0;
  private static final boolean BOOLEAN1 = true;
  private static final boolean BOOLEAN2 = false;
  private static final Timestamp TIMESTAMP1 = Timestamp.ofTimeMicroseconds(1);
  private static final Timestamp TIMESTAMP2 = Timestamp.ofTimeMicroseconds(2);
  private static final LatLng LATLNG1 = LatLng.of(DOUBLE1, DOUBLE2);
  private static final LatLng LATLNG2 = LatLng.of(DOUBLE2, DOUBLE1);
  private static final Key KEY1 = Key.newBuilder("project", "kind", "name1").build();
  private static final Key KEY2 = Key.newBuilder("project", "kind", "name2").build();
  private static final FullEntity<Key> ENTITY1 = FullEntity.newBuilder(KEY1).build();
  private static final FullEntity<Key> ENTITY2 = FullEntity.newBuilder(KEY2).build();
  private static final Blob BLOB1 = Blob.copyFrom(new byte[] {0xD, 0xE, 0xA, 0xD});
  private static final Blob BLOB2 = Blob.copyFrom(new byte[] {0xB, 0x0, 0x0, 0x0});

  @Test
  public void testToBuilder() throws Exception {
    ListValue value = ListValue.of(CONTENT);
    assertEquals(value, value.toBuilder().build());
  }

  @Test
  public void testOf() throws Exception {
    ListValue value = ListValue.of(CONTENT);
    assertEquals(CONTENT, value.get());
    assertFalse(value.excludeFromIndexes());
    value = ListValue.of(Collections.<Value<?>>emptyList());
    assertEquals(Collections.<Value<?>>emptyList(), value.get());
    assertFalse(value.excludeFromIndexes());
    value = ListValue.of(STRING1);
    assertEquals(ImmutableList.of(StringValue.of(STRING1)), value.get());
    value = ListValue.of(STRING1, STRING2);
    assertEquals(ImmutableList.of(StringValue.of(STRING1), StringValue.of(STRING2)), value.get());
    value = ListValue.of(LONG1);
    assertEquals(ImmutableList.of(LongValue.of(LONG1)), value.get());
    value = ListValue.of(LONG1, LONG2);
    assertEquals(ImmutableList.of(LongValue.of(LONG1), LongValue.of(LONG2)), value.get());
    value = ListValue.of(DOUBLE1);
    assertEquals(ImmutableList.of(DoubleValue.of(DOUBLE1)), value.get());
    value = ListValue.of(DOUBLE1, DOUBLE2);
    assertEquals(ImmutableList.of(DoubleValue.of(DOUBLE1), DoubleValue.of(DOUBLE2)), value.get());
    value = ListValue.of(BOOLEAN1);
    assertEquals(ImmutableList.of(BooleanValue.of(BOOLEAN1)), value.get());
    value = ListValue.of(BOOLEAN1, BOOLEAN2);
    assertEquals(
        ImmutableList.of(BooleanValue.of(BOOLEAN1), BooleanValue.of(BOOLEAN2)), value.get());
    value = ListValue.of(TIMESTAMP1);
    assertEquals(ImmutableList.of(TimestampValue.of(TIMESTAMP1)), value.get());
    value = ListValue.of(TIMESTAMP1, TIMESTAMP2);
    assertEquals(
        ImmutableList.of(TimestampValue.of(TIMESTAMP1), TimestampValue.of(TIMESTAMP2)),
        value.get());
    value = ListValue.of(LATLNG1);
    assertEquals(ImmutableList.of(LatLngValue.of(LATLNG1)), value.get());
    value = ListValue.of(LATLNG1, LATLNG2);
    assertEquals(ImmutableList.of(LatLngValue.of(LATLNG1), LatLngValue.of(LATLNG2)), value.get());
    value = ListValue.of(KEY1);
    assertEquals(ImmutableList.of(KeyValue.of(KEY1)), value.get());
    value = ListValue.of(KEY1, KEY2);
    assertEquals(ImmutableList.of(KeyValue.of(KEY1), KeyValue.of(KEY2)), value.get());
    value = ListValue.of(ENTITY1);
    assertEquals(ImmutableList.of(EntityValue.of(ENTITY1)), value.get());
    value = ListValue.of(ENTITY1, ENTITY2);
    assertEquals(ImmutableList.of(EntityValue.of(ENTITY1), EntityValue.of(ENTITY2)), value.get());
    value = ListValue.of(BLOB1);
    assertEquals(ImmutableList.of(BlobValue.of(BLOB1)), value.get());
    value = ListValue.of(BLOB1, BLOB2);
    assertEquals(ImmutableList.of(BlobValue.of(BLOB1), BlobValue.of(BLOB2)), value.get());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testBuilder() throws Exception {
    ListValue.Builder builder = ListValue.newBuilder().set(CONTENT);
    ListValue value = builder.setMeaning(1).setExcludeFromIndexes(true).build();
    assertEquals(CONTENT, value.get());
    assertEquals(1, value.getMeaning());
    assertTrue(value.excludeFromIndexes());

    builder = ListValue.newBuilder();
    for (Value<?> v : CONTENT) {
      builder.addValue(v);
    }
    assertEquals(CONTENT, builder.build().get());

    builder = builder.set(Collections.<Value<?>>emptyList());
    assertEquals(Collections.<Value<?>>emptyList(), builder.build().get());

    builder = builder.addValue(STRING1);
    assertEquals(ImmutableList.of(StringValue.of(STRING1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(STRING1, STRING2);
    assertEquals(
        ImmutableList.of(StringValue.of(STRING1), StringValue.of(STRING2)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(LONG1);
    assertEquals(ImmutableList.of(LongValue.of(LONG1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(LONG1, LONG2);
    assertEquals(ImmutableList.of(LongValue.of(LONG1), LongValue.of(LONG2)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(DOUBLE1);
    assertEquals(ImmutableList.of(DoubleValue.of(DOUBLE1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(DOUBLE1, DOUBLE2);
    assertEquals(
        ImmutableList.of(DoubleValue.of(DOUBLE1), DoubleValue.of(DOUBLE2)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(BOOLEAN1);
    assertEquals(ImmutableList.of(BooleanValue.of(BOOLEAN1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(BOOLEAN1, BOOLEAN2);
    assertEquals(
        ImmutableList.of(BooleanValue.of(BOOLEAN1), BooleanValue.of(BOOLEAN2)),
        builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(TIMESTAMP1);
    assertEquals(ImmutableList.of(TimestampValue.of(TIMESTAMP1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(TIMESTAMP1, TIMESTAMP2);
    assertEquals(
        ImmutableList.of(TimestampValue.of(TIMESTAMP1), TimestampValue.of(TIMESTAMP2)),
        builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(LATLNG1);
    assertEquals(ImmutableList.of(LatLngValue.of(LATLNG1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(LATLNG1, LATLNG2);
    assertEquals(
        ImmutableList.of(LatLngValue.of(LATLNG1), LatLngValue.of(LATLNG2)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(KEY1);
    assertEquals(ImmutableList.of(KeyValue.of(KEY1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(KEY1, KEY2);
    assertEquals(ImmutableList.of(KeyValue.of(KEY1), KeyValue.of(KEY2)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(ENTITY1);
    assertEquals(ImmutableList.of(EntityValue.of(ENTITY1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(ENTITY1, ENTITY2);
    assertEquals(
        ImmutableList.of(EntityValue.of(ENTITY1), EntityValue.of(ENTITY2)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(BLOB1);
    assertEquals(ImmutableList.of(BlobValue.of(BLOB1)), builder.build().get());
    builder = builder.set(Collections.<Value<?>>emptyList());

    builder = builder.addValue(BLOB1, BLOB2);
    assertEquals(ImmutableList.of(BlobValue.of(BLOB1), BlobValue.of(BLOB2)), builder.build().get());
  }
}
