/*
 * Copyright 2019 Google LLC
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

import org.junit.Test;

public class StandardSQLFieldTest {

  private static final String NAME = "field_name";
  private static final StandardSQLDataType STRING_DATA_TYPE =
      StandardSQLDataType.newBuilder("STRING").build();
  private static final StandardSQLDataType ARRAY_OF_STRING_DATA_TYPE =
      StandardSQLDataType.newBuilder("ARRAY").setArrayElementType(STRING_DATA_TYPE).build();
  private static final StandardSQLField STANDARD_SQL_FIELD_1 =
      StandardSQLField.newBuilder(STRING_DATA_TYPE).build();
  private static final StandardSQLField STANDARD_SQL_FIELD_2 =
      StandardSQLField.newBuilder(NAME, ARRAY_OF_STRING_DATA_TYPE).build();

  @Test
  public void testToBuilder() {
    compareStandardSQLField(STANDARD_SQL_FIELD_1, STANDARD_SQL_FIELD_1.toBuilder().build());
    compareStandardSQLField(STANDARD_SQL_FIELD_2, STANDARD_SQL_FIELD_2.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(null, STANDARD_SQL_FIELD_1.getName());
    assertEquals(STRING_DATA_TYPE, STANDARD_SQL_FIELD_1.getDataType());
    assertEquals(ARRAY_OF_STRING_DATA_TYPE, STANDARD_SQL_FIELD_2.getDataType());
  }

  @Test
  public void testToAndFromPb() {
    compareStandardSQLField(
        STANDARD_SQL_FIELD_1, StandardSQLField.fromPb(STANDARD_SQL_FIELD_1.toPb()));
  }

  private void compareStandardSQLField(StandardSQLField expected, StandardSQLField value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getDataType(), value.getDataType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
