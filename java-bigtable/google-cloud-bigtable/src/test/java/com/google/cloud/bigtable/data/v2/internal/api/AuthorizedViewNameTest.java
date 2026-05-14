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
public class AuthorizedViewNameTest {

  @Test
  public void testParseOk() {
    String name = "projects/fake-p/instances/fake-i/tables/fake-t/authorizedViews/fake-v";
    AuthorizedViewName parsed = AuthorizedViewName.parse(name);

    assertThat(parsed)
        .isEqualTo(
            AuthorizedViewName.builder()
                .setProjectId("fake-p")
                .setInstanceId("fake-i")
                .setTableId("fake-t")
                .setAuthorizedViewId("fake-v")
                .build());
  }

  @Test
  public void testParseFail() {
    assertThrows(IllegalArgumentException.class, () -> AuthorizedViewName.parse(""));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "project/fake-p/instances/fake-i/tables/fake-t/authorizedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects/fake-p/instance/fake-i/tables/fake-t/authorizedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects/fake-p/instances/fake-i/table/fake-t/authorizedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects/fake-p/instances/fake-i/tables/fake-t/authorizedView/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects//instances/fake-i/tables/fake-t/authorizedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects/fake-p/instances//tables/fake-t/authorizedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects/fake-p/instances/fake-i/tables//authorizedViews/fake-v"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects/fake-p/instances/fake-i/tables/fake-t/authorizedViews"));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AuthorizedViewName.parse(
                "projects/fake-p/instances/fake-i/tables/fake-t/authorizedViews/fake-v/extra"));
  }
}
