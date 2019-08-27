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

public class StandardSQLStructTypeTest {

  private static final StandardSQLField FIELD_1 =
      StandardSQLField.newBuilder("FIELD_1", StandardSQLDataType.newBuilder("STRING").build())
          .build();
  private static final StandardSQLField FIELD_2 =
      StandardSQLField.newBuilder("FIELD_2", StandardSQLDataType.newBuilder("FLOAT64").build())
          .build();

  private static final List<StandardSQLField> FIELD_LIST = ImmutableList.of(FIELD_1, FIELD_2);
  private static final StandardSQLStructType STRUCT_TYPE =
      StandardSQLStructType.newBuilder(FIELD_LIST).build();

  @Test
  public void testToBuilder() {
    compareStandardSQLStructType(STRUCT_TYPE, STRUCT_TYPE.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(FIELD_1, STRUCT_TYPE.getFields().get(0));
    assertEquals(FIELD_2, STRUCT_TYPE.getFields().get(1));
  }

  @Test
  public void testToAndFromPb() {
    compareStandardSQLStructType(STRUCT_TYPE, StandardSQLStructType.fromPb(STRUCT_TYPE.toPb()));
  }

  private void compareStandardSQLStructType(
      StandardSQLStructType expected, StandardSQLStructType value) {
    assertEquals(expected, value);
    assertEquals(expected.getFields(), value.getFields());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
