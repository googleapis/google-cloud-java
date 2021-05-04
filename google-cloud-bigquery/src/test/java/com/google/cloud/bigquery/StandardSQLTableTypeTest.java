/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import static org.junit.Assert.*;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class StandardSQLTableTypeTest {

  private static final StandardSQLField COLUMN_1 =
      StandardSQLField.newBuilder("COLUMN_1", StandardSQLDataType.newBuilder("STRING").build())
          .build();
  private static final StandardSQLField COLUMN_2 =
      StandardSQLField.newBuilder("COLUMN_2", StandardSQLDataType.newBuilder("FLOAT64").build())
          .build();

  private static final List<StandardSQLField> COLUMN_LIST = ImmutableList.of(COLUMN_1, COLUMN_2);
  private static final StandardSQLTableType TABLE_TYPE =
      StandardSQLTableType.newBuilder(COLUMN_LIST).build();

  @Test
  public void testToBuilder() {
    compareStandardSQLTableType(TABLE_TYPE, TABLE_TYPE.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(COLUMN_1, TABLE_TYPE.getColumns().get(0));
    assertEquals(COLUMN_2, TABLE_TYPE.getColumns().get(1));
  }

  @Test
  public void testToAndFromPb() {
    compareStandardSQLTableType(TABLE_TYPE, StandardSQLTableType.fromPb(TABLE_TYPE.toPb()));
  }

  private void compareStandardSQLTableType(
      StandardSQLTableType expected, StandardSQLTableType value) {
    assertEquals(expected, value);
    assertEquals(expected.getColumns(), value.getColumns());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
