/*
 * Copyright 2016 Google LLC
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

package com.google.cloud;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class RoleTest {

  private static final Role VIEWER = Role.of("viewer");
  private static final Role EDITOR = Role.of("editor");
  private static final Role OWNER = Role.of("owner");

  @Test
  public void testOf() {
    assertThat(VIEWER.getValue()).isEqualTo("roles/viewer");
    assertThat(EDITOR.getValue()).isEqualTo("roles/editor");
    assertThat(OWNER.getValue()).isEqualTo("roles/owner");
    compareRoles(VIEWER, Role.of("roles/viewer"));
    compareRoles(EDITOR, Role.of("roles/editor"));
    compareRoles(OWNER, Role.of("roles/owner"));

    String customRole = "projects/foo/roles/bar";
    assertThat(Role.of(customRole).getValue()).isEqualTo(customRole);
  }

  @Test
  public void testViewer() {
    assertThat(Role.viewer().getValue()).isEqualTo("roles/viewer");
  }

  @Test
  public void testEditor() {
    assertThat(Role.editor().getValue()).isEqualTo("roles/editor");
  }

  @Test
  public void testOwner() {
    assertThat(Role.owner().getValue()).isEqualTo("roles/owner");
  }

  @Test(expected = NullPointerException.class)
  public void testOfNullValue() {
    Role.of(null);
  }

  private void compareRoles(Role expected, Role actual) {
    assertThat(actual).isEqualTo(expected);
    assertThat(actual.getValue()).isEqualTo(expected.getValue());
    assertThat(actual.hashCode()).isEqualTo(expected.hashCode());
    assertThat(actual.toString()).isEqualTo(expected.toString());
  }
}
