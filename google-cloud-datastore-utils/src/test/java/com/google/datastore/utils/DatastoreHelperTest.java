/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.utils;

import static com.google.datastore.utils.DatastoreHelper.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.datastore.v1.Key;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.Value;
import com.google.datastore.v1.Value.ValueTypeCase;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link DatastoreHelper}. */
@RunWith(JUnit4.class)
public class DatastoreHelperTest {

  private static final Key PARENT =
      Key.newBuilder().addPath(Key.PathElement.newBuilder().setKind("Parent").setId(23L)).build();
  private static final Key GRANDPARENT =
      Key.newBuilder()
          .addPath(Key.PathElement.newBuilder().setKind("Grandparent").setId(24L))
          .build();
  private static final Key CHILD =
      Key.newBuilder().addPath(Key.PathElement.newBuilder().setKind("Child").setId(26L)).build();

  @Test
  public void testMakeKey_BadTypeForKind() {
    try {
      DatastoreHelper.makeKey(new Object());
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void testMakeKey_BadTypeForNameId() {
    try {
      DatastoreHelper.makeKey("kind", new Object());
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void testMakeKey_Empty() {
    assertEquals(Key.newBuilder().build(), DatastoreHelper.makeKey().build());
  }

  @Test
  public void testMakeKey_Incomplete() {
    assertEquals(
        Key.newBuilder().addPath(Key.PathElement.newBuilder().setKind("Foo")).build(),
        makeKey("Foo").build());
  }

  @Test
  public void testMakeKey_IdInt() {
    assertEquals(
        Key.newBuilder().addPath(Key.PathElement.newBuilder().setKind("Foo").setId(1)).build(),
        makeKey("Foo", 1).build());
  }

  @Test
  public void testMakeKey_IdLong() {
    assertEquals(
        Key.newBuilder().addPath(Key.PathElement.newBuilder().setKind("Foo").setId(1)).build(),
        makeKey("Foo", 1L).build());
  }

  @Test
  public void testMakeKey_IdShort() {
    assertEquals(
        Key.newBuilder().addPath(Key.PathElement.newBuilder().setKind("Foo").setId(1)).build(),
        makeKey("Foo", (short) 1).build());
  }

  @Test
  public void testMakeKey_Name() {
    assertEquals(
        Key.newBuilder().addPath(Key.PathElement.newBuilder().setKind("Foo").setName("hi")).build(),
        makeKey("Foo", "hi").build());
  }

  @Test
  public void testMakeKey_KindNameKind() {
    assertEquals(
        Key.newBuilder()
            .addPath(Key.PathElement.newBuilder().setKind("Foo").setName("hi"))
            .addPath(Key.PathElement.newBuilder().setKind("Bar"))
            .build(),
        makeKey("Foo", "hi", "Bar").build());
  }

  @Test
  public void testMakeKey_KeyKind() {
    // 1 key at the beginning of the series
    assertEquals(
        Key.newBuilder()
            .addPath(PARENT.getPath(0))
            .addPath(Key.PathElement.newBuilder().setKind("Child"))
            .build(),
        makeKey(PARENT, "Child").build());
  }

  @Test
  public void testMakeKey_KindIdKeyKind() {
    // 1 key in the middle of the series
    assertEquals(
        Key.newBuilder()
            .addPath(Key.PathElement.newBuilder().setKind("Grandparent").setId(24L))
            .addPath(PARENT.getPath(0))
            .addPath(Key.PathElement.newBuilder().setKind("Child"))
            .build(),
        makeKey("Grandparent", 24L, PARENT, "Child").build());
  }

  @Test
  public void testMakeKey_KindIdKey() {
    // 1 key at the end of the series
    assertEquals(
        Key.newBuilder()
            .addPath(Key.PathElement.newBuilder().setKind("Grandparent").setId(24L))
            .addPath(PARENT.getPath(0))
            .build(),
        makeKey("Grandparent", 24L, PARENT).build());
  }

  @Test
  public void testMakeKey_KeyKindIdKey() {
    // 1 key at the beginning and 1 key at the end of the series
    assertEquals(
        Key.newBuilder()
            .addPath(GRANDPARENT.getPath(0))
            .addPath(Key.PathElement.newBuilder().setKind("Parent").setId(23L))
            .addPath(CHILD.getPath(0))
            .build(),
        makeKey(GRANDPARENT, "Parent", 23, CHILD).build());
  }

  @Test
  public void testMakeKey_Key() {
    // Just 1 key
    assertEquals(Key.newBuilder().addPath(CHILD.getPath(0)).build(), makeKey(CHILD).build());
  }

  @Test
  public void testMakeKey_KeyKey() {
    // Just 2 keys
    assertEquals(
        Key.newBuilder().addPath(PARENT.getPath(0)).addPath(CHILD.getPath(0)).build(),
        makeKey(PARENT, CHILD).build());
  }

  @Test
  public void testMakeKey_KeyKeyKey() {
    // Just 3 keys
    assertEquals(
        Key.newBuilder()
            .addPath(GRANDPARENT.getPath(0))
            .addPath(PARENT.getPath(0))
            .addPath(CHILD.getPath(0))
            .build(),
        makeKey(GRANDPARENT, PARENT, CHILD).build());
  }

  @Test
  public void testMakeKey_KeyMultiLevelKey() {
    // 1 key with 2 elements
    assertEquals(
        Key.newBuilder()
            .addPath(GRANDPARENT.getPath(0))
            .addPath(PARENT.getPath(0))
            .addPath(CHILD.getPath(0))
            .build(),
        makeKey(GRANDPARENT, makeKey(PARENT, CHILD).build()).build());
  }

  @Test
  public void testMakeKey_MultiLevelKeyKey() {
    // 1 key with 2 elements
    assertEquals(
        Key.newBuilder()
            .addPath(GRANDPARENT.getPath(0))
            .addPath(PARENT.getPath(0))
            .addPath(CHILD.getPath(0))
            .build(),
        makeKey(makeKey(GRANDPARENT, PARENT).build(), CHILD).build());
  }

  @Test
  public void testMakeKey_MultiLevelKey() {
    // 1 key with 3 elements
    assertEquals(
        Key.newBuilder()
            .addPath(GRANDPARENT.getPath(0))
            .addPath(PARENT.getPath(0))
            .addPath(CHILD.getPath(0))
            .build(),
        makeKey(makeKey(GRANDPARENT, PARENT, CHILD).build()).build());
  }

  @Test
  public void testMakeKey_PartitionId() {
    PartitionId partitionId = PartitionId.newBuilder().setNamespaceId("namespace-id").build();
    Key parent = PARENT.toBuilder().setPartitionId(partitionId).build();
    assertEquals(
        Key.newBuilder()
            .setPartitionId(partitionId)
            .addPath(PARENT.getPath(0))
            .addPath(Key.PathElement.newBuilder().setKind("Child"))
            .build(),
        makeKey(parent, "Child").build());
  }

  @Test
  public void testMakeKey_NonMatchingPartitionId2() {
    PartitionId partitionId1 = PartitionId.newBuilder().setNamespaceId("namespace-id").build();
    PartitionId partitionId2 =
        PartitionId.newBuilder().setNamespaceId("another-namespace-id").build();
    try {
      makeKey(
          PARENT.toBuilder().setPartitionId(partitionId1).build(),
          CHILD.toBuilder().setPartitionId(partitionId2).build());
      fail("expected IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void testMakeTimestampValue() throws Exception {
    // Test cases with nanos == 0.
    assertConversion(-50_000, -50, 0);
    assertConversion(-1_000, -1, 0);
    assertConversion(0, 0, 0);
    assertConversion(1_000, 1, 0);
    assertConversion(2_000, 2, 0);
    assertConversion(100_000, 100, 0);

    // Test cases with nanos % 1_000_000 == 0 (no loss of precision).
    assertConversion(2, 0, 2_000_000);
    assertConversion(1_003, 1, 3_000_000);
    assertConversion(2_005, 2, 5_000_000);

    // Timestamp specification requires that nanos >= 0 even if the timestamp
    // is before the epoch.
    assertConversion(0, 0, 0);
    assertConversion(-250, -1, 750_000_000); // 1/4 second before epoch
    assertConversion(-500, -1, 500_000_000); // 1/2 second before epoch
    assertConversion(-750, -1, 250_000_000); // 3/4 second before epoch

    // If nanos % 1_000_000 != 0, precision is lost (via truncation) when
    // converting to milliseconds.
    assertTimestampToMilliseconds(3_100, 3, 100_000_999);
    assertMillisecondsToTimestamp(3_100, 3, 100_000_000);
    assertTimestampToMilliseconds(5_999, 5, 999_999_999);
    assertMillisecondsToTimestamp(5_999, 5, 999_000_000);
    assertTimestampToMilliseconds(7_100, 7, 100_000_001);
    assertMillisecondsToTimestamp(7_100, 7, 100_000_000);
  }

  private void assertConversion(long millis, long seconds, int nanos) {
    assertMillisecondsToTimestamp(millis, seconds, nanos);
    assertTimestampToMilliseconds(millis, seconds, nanos);
  }

  private void assertMillisecondsToTimestamp(long millis, long seconds, long nanos) {
    Value timestampValue = makeValue(new Date(millis)).build();
    assertEquals(ValueTypeCase.TIMESTAMP_VALUE, timestampValue.getValueTypeCase());
    assertEquals(seconds, timestampValue.getTimestampValue().getSeconds());
    assertEquals(nanos, timestampValue.getTimestampValue().getNanos());
  }

  private void assertTimestampToMilliseconds(long millis, long seconds, int nanos) {
    Value.Builder value =
        Value.newBuilder()
            .setTimestampValue(Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos));
    assertEquals(millis, DatastoreHelper.toDate(value.build()).getTime());
  }

  @Test
  public void testProjectionHandling() {
    assertEquals(
        ByteString.copyFromUtf8("hi"), getByteString(makeValue("hi").setMeaning(18).build()));
    try {
      getByteString(makeValue("hi").build());
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
    }

    assertEquals(new Date(1), toDate(makeValue(1000).setMeaning(18).build()));
    try {
      toDate(makeValue(1000).build());
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
    }
  }
}
