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
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InstanceNameTest {

  @Test
  void testParseOk() {
    assertThat(InstanceName.parse("projects/my-project/instances/my-instance"))
        .isEqualTo(
            InstanceName.builder().setProjectId("my-project").setInstanceId("my-instance").build());
  }

  @Test
  void testParseFail() {
    assertThrows(IllegalArgumentException.class, () -> InstanceName.parse(""));
    assertThrows(IllegalArgumentException.class, () -> InstanceName.parse("projects/my-project"));
    assertThrows(
        IllegalArgumentException.class, () -> TableName.parse("projects/my-project/instances"));
    assertThrows(
        IllegalArgumentException.class,
        () -> InstanceName.parse("projects/my-project/instances/my-instance/extra"));
    assertThrows(
        IllegalArgumentException.class,
        () -> InstanceName.parse("projects//instances/my-instance"));
    assertThrows(
        IllegalArgumentException.class, () -> InstanceName.parse("projects/my-project/instances/"));
    assertThrows(
        IllegalArgumentException.class,
        () -> InstanceName.parse("projects/my-project/instances//"));
  }
}
