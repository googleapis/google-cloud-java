/*
 * Copyright 2024 Google LLC
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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RangeTest {
  private static final Range RANGE_DATE =
      Range.newBuilder()
          .setType(FieldElementType.newBuilder().setType("DATE").build())
          .setStart("1970-01-02")
          .setEnd("1970-03-04")
          .build();

  private static final Range RANGE_DATETIME =
      Range.newBuilder()
          .setType(FieldElementType.newBuilder().setType("DATETIME").build())
          .setStart("2014-08-19 05:41:35.220000")
          .setEnd("2015-09-20 06:41:35.220000")
          .build();

  private static final Range RANGE_TIMESTAMP =
      Range.newBuilder()
          .setType(FieldElementType.newBuilder().setType("TIMESTAMP").build())
          .setStart("2014-08-19 12:41:35.220000+00:00")
          .setEnd("2015-09-20 13:41:35.220000+01:00")
          .build();

  @Test
  public void testOf() {
    compareRange(null, null, Range.of("[null, NULL)"));
    compareRange(null, null, Range.of("[unbounded, UNBOUNDED)"));
    compareRange(null, null, Range.of("[nUlL, uNbOuNdEd)"));

    compareRange(null, "2020-12-31", Range.of("[null, 2020-12-31)"));
    compareRange("2020-01-01", null, Range.of("[2020-01-01, null)"));
    compareRange("2020-01-01", "2020-12-31", Range.of("[2020-01-01, 2020-12-31)"));
  }

  @Test
  public void testBuilder() {
    assertEquals("1970-01-02", RANGE_DATE.getStart().getStringValue());
    assertEquals("1970-03-04", RANGE_DATE.getEnd().getStringValue());
    assertEquals(FieldElementType.newBuilder().setType("DATE").build(), RANGE_DATE.getType());

    assertEquals("2014-08-19 05:41:35.220000", RANGE_DATETIME.getStart().getStringValue());
    assertEquals("2015-09-20 06:41:35.220000", RANGE_DATETIME.getEnd().getStringValue());
    assertEquals(
        FieldElementType.newBuilder().setType("DATETIME").build(), RANGE_DATETIME.getType());

    assertEquals("2014-08-19 12:41:35.220000+00:00", RANGE_TIMESTAMP.getStart().getStringValue());
    assertEquals("2015-09-20 13:41:35.220000+01:00", RANGE_TIMESTAMP.getEnd().getStringValue());
    assertEquals(
        FieldElementType.newBuilder().setType("TIMESTAMP").build(), RANGE_TIMESTAMP.getType());
  }

  @Test
  public void testToBuilder() {
    compareRange(RANGE_DATE, RANGE_DATE.toBuilder().build());
    compareRange(RANGE_DATETIME, RANGE_DATETIME.toBuilder().build());
    compareRange(RANGE_TIMESTAMP, RANGE_TIMESTAMP.toBuilder().build());
  }

  private static void compareRange(Range expected, Range value) {
    assertEquals(expected.getStart(), value.getStart());
    assertEquals(expected.getEnd(), value.getEnd());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private static void compareRange(String expectedStart, String expectedEnd, Range range) {
    if (expectedStart == null) {
      assertTrue(range.getStart().isNull());
    } else {
      assertEquals(expectedStart, range.getStart().getStringValue());
    }
    if (expectedEnd == null) {
      assertTrue(range.getEnd().isNull());
    } else {
      assertEquals(expectedEnd, range.getEnd().getStringValue());
    }
  }
}
