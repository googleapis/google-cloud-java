/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.models;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TableIdTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String TABLE_ID = "my-table";

  @Test
  public void testToResourceName() {
    TableId tableId = TableId.of(TABLE_ID);

    assertThat(tableId.toResourceName(PROJECT_ID, INSTANCE_ID))
        .isEqualTo("projects/my-project/instances/my-instance/tables/my-table");
  }

  @Test
  public void testEquality() {
    TableId tableId = TableId.of(TABLE_ID);

    assertThat(tableId).isEqualTo(TableId.of(TABLE_ID));
    assertThat(tableId).isNotEqualTo(TableId.of("another-table"));
  }

  @Test
  public void testHashCode() {
    TableId tableId = TableId.of(TABLE_ID);

    assertThat(tableId.hashCode()).isEqualTo(TableId.of(TABLE_ID).hashCode());
    assertThat(tableId.hashCode()).isNotEqualTo(TableId.of("another-table").hashCode());
  }

  @Test
  public void testToString() {
    TableId tableId = TableId.of(TABLE_ID);

    assertThat(tableId.toString()).isEqualTo("TableId{tableId=my-table}");
  }
}
