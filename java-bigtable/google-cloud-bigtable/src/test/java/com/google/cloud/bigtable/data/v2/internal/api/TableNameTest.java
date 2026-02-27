/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.api;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TableNameTest {

  @Test
  void testParseOk() {
    assertThat(TableName.parse("projects/my-project/instances/my-instance/tables/my-table"))
        .isEqualTo(
            TableName.builder()
                .setProjectId("my-project")
                .setInstanceId("my-instance")
                .setTableId("my-table")
                .build());
  }

  @Test
  void testParseFail() {
    assertThrows(IllegalArgumentException.class, () -> TableName.parse(""));
    assertThrows(IllegalArgumentException.class, () -> TableName.parse("projects/my-project"));
    assertThrows(
        IllegalArgumentException.class, () -> TableName.parse("projects/my-project/instances"));
    assertThrows(
        IllegalArgumentException.class,
        () -> TableName.parse("projects/my-project/instances/my-instance"));
    assertThrows(
        IllegalArgumentException.class,
        () -> TableName.parse("projects/my-project/instances/my-instance/tables"));
    assertThrows(
        IllegalArgumentException.class,
        () -> TableName.parse("projects/my-project/instances/my-instance/tables/my-table/extra"));
    assertThrows(
        IllegalArgumentException.class,
        () -> TableName.parse("projects//instances/my-instance/tables"));
    assertThrows(
        IllegalArgumentException.class,
        () -> TableName.parse("projects/my-project/instances//tables/my-table"));
    assertThrows(
        IllegalArgumentException.class,
        () -> TableName.parse("projects/my-project/instances/my-instance/tables/"));
  }
}
