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

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class StandardSQLDataTypeTest {
  private static final String STRING_TYPEKIND = "STRING";
  private static final String ARRAY_TYPEKIND = "ARRAY";
  private static final String STRUCT_TYPEKIND = "STRUCT";

  private static final StandardSQLDataType STRING_DATA_TYPE =
      StandardSQLDataType.newBuilder(STRING_TYPEKIND).build();
  private static final StandardSQLDataType ARRAY_OF_STRING_DATA_TYPE =
      StandardSQLDataType.newBuilder(ARRAY_TYPEKIND).setArrayElementType(STRING_DATA_TYPE).build();

  private static final List<StandardSQLField> FIELD_LIST =
      ImmutableList.of(
          StandardSQLField.newBuilder(STRING_DATA_TYPE).build(),
          StandardSQLField.newBuilder(ARRAY_OF_STRING_DATA_TYPE).build());
  private static final StandardSQLStructType STRUCT_TYPE =
      StandardSQLStructType.newBuilder(FIELD_LIST).build();

  private static final StandardSQLDataType STRUCT_DATA_TYPE =
      StandardSQLDataType.newBuilder(STRUCT_TYPEKIND).setStructType(STRUCT_TYPE).build();

  @Test
  public void testToBuilder() {
    compareStandardSQLDataType(STRING_DATA_TYPE, STRING_DATA_TYPE.toBuilder().build());
    compareStandardSQLDataType(
        ARRAY_OF_STRING_DATA_TYPE, ARRAY_OF_STRING_DATA_TYPE.toBuilder().build());
    compareStandardSQLDataType(STRUCT_DATA_TYPE, STRUCT_DATA_TYPE.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(STRING_TYPEKIND, STRING_DATA_TYPE.getTypeKind());
    assertEquals(ARRAY_TYPEKIND, ARRAY_OF_STRING_DATA_TYPE.getTypeKind());
    assertEquals(STRING_DATA_TYPE, ARRAY_OF_STRING_DATA_TYPE.getArrayElementType());
    assertEquals(STRUCT_TYPE, STRUCT_DATA_TYPE.getStructType());
  }

  @Test
  public void testToAndFromPb() {
    compareStandardSQLDataType(
        ARRAY_OF_STRING_DATA_TYPE, StandardSQLDataType.fromPb(ARRAY_OF_STRING_DATA_TYPE.toPb()));
  }

  private void compareStandardSQLDataType(StandardSQLDataType expected, StandardSQLDataType value) {
    assertEquals(expected, value);
    assertEquals(expected.getTypeKind(), value.getTypeKind());
    assertEquals(expected.getArrayElementType(), value.getArrayElementType());
    assertEquals(expected.getStructType(), value.getStructType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
