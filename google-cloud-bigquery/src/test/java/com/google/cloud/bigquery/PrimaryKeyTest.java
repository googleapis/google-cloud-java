/*
 * Copyright 2023 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class PrimaryKeyTest {
  private static final List<String> COLUMNS = Arrays.asList("column1", "column2");
  private static final PrimaryKey PRIMARY_KEY = PrimaryKey.newBuilder().setColumns(COLUMNS).build();

  @Test
  public void testToBuilder() {
    comparePrimaryKeyDefinition(PRIMARY_KEY, PRIMARY_KEY.toBuilder().build());
    PrimaryKey primaryKey =
        PRIMARY_KEY.toBuilder().setColumns(Arrays.asList("col1", "col2", "col3")).build();
    assertEquals(Arrays.asList("col1", "col2", "col3"), primaryKey.getColumns());
  }

  @Test
  public void testBuilder() {
    assertEquals(COLUMNS, PRIMARY_KEY.getColumns());
    PrimaryKey primaryKey = PRIMARY_KEY.newBuilder().setColumns(COLUMNS).build();
    assertEquals(PRIMARY_KEY, primaryKey);
  }

  @Test
  public void testToAndFromPb() {
    PrimaryKey primaryKey = PRIMARY_KEY.toBuilder().build();
    assertTrue(PrimaryKey.fromPb(primaryKey.toPb()) instanceof PrimaryKey);
    comparePrimaryKeyDefinition(primaryKey, PrimaryKey.fromPb(primaryKey.toPb()));
  }

  private void comparePrimaryKeyDefinition(PrimaryKey expected, PrimaryKey value) {
    assertEquals(expected.getColumns(), value.getColumns());
  }
}
