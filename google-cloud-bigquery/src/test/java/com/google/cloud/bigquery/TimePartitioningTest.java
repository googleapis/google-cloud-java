/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.bigquery.TimePartitioning.Type;
import org.junit.Assert;
import org.junit.Test;

public class TimePartitioningTest {

  private static final Type TYPE_DAY = Type.DAY;
  private static final Type TYPE_HOUR = Type.HOUR;
  private static final long EXPIRATION_MS = 42;
  private static final boolean REQUIRE_PARTITION_FILTER = false;
  private static final String FIELD = "field";
  private static final TimePartitioning TIME_PARTITIONING_DAY =
      TimePartitioning.newBuilder(TYPE_DAY)
          .setExpirationMs(EXPIRATION_MS)
          .setRequirePartitionFilter(REQUIRE_PARTITION_FILTER)
          .setField(FIELD)
          .build();
  private static final TimePartitioning TIME_PARTITIONING_HOUR =
      TimePartitioning.newBuilder(TYPE_HOUR)
          .setExpirationMs(EXPIRATION_MS)
          .setRequirePartitionFilter(REQUIRE_PARTITION_FILTER)
          .setField(FIELD)
          .build();

  @Test
  public void testOf() {
    assertEquals(TYPE_DAY, TIME_PARTITIONING_DAY.getType());
    assertEquals(TYPE_HOUR, TIME_PARTITIONING_HOUR.getType());
    assertEquals(EXPIRATION_MS, TIME_PARTITIONING_DAY.getExpirationMs().longValue());
    assertEquals(REQUIRE_PARTITION_FILTER, TIME_PARTITIONING_DAY.getRequirePartitionFilter());
    assertEquals(FIELD, TIME_PARTITIONING_DAY.getField());
    TimePartitioning partitioning = TimePartitioning.of(TYPE_DAY);
    assertEquals(TYPE_DAY, partitioning.getType());
    assertNull(partitioning.getExpirationMs());
  }

  @Test
  public void testBuilder() {
    TimePartitioning partitioning = TimePartitioning.newBuilder(TYPE_DAY).build();
    assertEquals(TYPE_DAY, partitioning.getType());
    assertNull(partitioning.getExpirationMs());
    assertNull(partitioning.getRequirePartitionFilter());
    assertNull(partitioning.getField());
    partitioning = TimePartitioning.newBuilder(TYPE_DAY).setExpirationMs(100L).build();
    assertEquals(TYPE_DAY, partitioning.getType());
    assertEquals(100, (long) partitioning.getExpirationMs());
    assertNull(partitioning.getRequirePartitionFilter());
    assertNull(partitioning.getField());
    compareTimePartitioning(TIME_PARTITIONING_HOUR, TIME_PARTITIONING_HOUR.toBuilder().build());
    assertNotEquals(TIME_PARTITIONING_DAY, TYPE_DAY);
  }

  @Test
  public void testTypeOf_Npe() {
    try {
      TimePartitioning.of(null);
      Assert.fail();
    } catch (NullPointerException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void testTypeAndExpirationOf_Npe() {
    try {
      TimePartitioning.of(null, EXPIRATION_MS);
      Assert.fail();
    } catch (NullPointerException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void testToAndFromPb() {
    compareTimePartitioning(
        TIME_PARTITIONING_DAY, TimePartitioning.fromPb(TIME_PARTITIONING_DAY.toPb()));
    TimePartitioning partitioning = TimePartitioning.of(TYPE_DAY);
    compareTimePartitioning(partitioning, TimePartitioning.fromPb(partitioning.toPb()));
  }

  private void compareTimePartitioning(TimePartitioning expected, TimePartitioning value) {
    assertEquals(expected, value);
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getExpirationMs(), value.getExpirationMs());
    assertEquals(expected.getRequirePartitionFilter(), value.getRequirePartitionFilter());
    assertEquals(expected.getField(), value.getField());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
