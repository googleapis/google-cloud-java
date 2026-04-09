/*
 * Copyright 2026 Google LLC
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MaterializedViewNameTest {

  @Test
  public void testParseOk() {
    String name = "projects/fake-p/instances/fake-i/materializedViews/fake-v";

    assertThat(MaterializedViewName.parse(name))
        .isEqualTo(
            MaterializedViewName.builder()
                .setProjectId("fake-p")
                .setInstanceId("fake-i")
                .setMaterializedViewId("fake-v")
                .build());
  }

  @Test
  public void testParseError() {
    assertThrows(IllegalArgumentException.class, () -> AuthorizedViewName.parse(""));
    assertThrows(
        IllegalArgumentException.class,
        () -> AuthorizedViewName.parse("project/fake-p/instances/fake-i/materializedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () -> AuthorizedViewName.parse("projects/fake-p/instance/fake-i/materializedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () -> AuthorizedViewName.parse("projects/fake-p/instances/fake-i/materializedView/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () -> AuthorizedViewName.parse("projects//instances/fake-i/materializedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () -> AuthorizedViewName.parse("projects/fake-p/instances//materializedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () -> AuthorizedViewName.parse("projects/fake-p/instances/fake-i/materializedViews/"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects/fake-p/instances/fake-i/materializedViews/fake-v/extra"));
  }
}
