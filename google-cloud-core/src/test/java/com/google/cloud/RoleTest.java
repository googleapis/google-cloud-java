/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoleTest {

  private static final Role VIEWER = Role.of("viewer");
  private static final Role EDITOR = Role.of("editor");
  private static final Role OWNER = Role.of("owner");

  @Test
  public void testOf() {
    assertEquals("roles/viewer", VIEWER.getValue());
    assertEquals("roles/editor", EDITOR.getValue());
    assertEquals("roles/owner", OWNER.getValue());
    compareRoles(VIEWER, Role.of("roles/viewer"));
    compareRoles(EDITOR, Role.of("roles/editor"));
    compareRoles(OWNER, Role.of("roles/owner"));
  }


  @Test
  public void testViewer() {
    assertEquals("roles/viewer", Role.viewer().getValue());
  }

  @Test
  public void testEditor() {
    assertEquals("roles/editor", Role.editor().getValue());
  }

  @Test
  public void testOwner() {
    assertEquals("roles/owner", Role.owner().getValue());
  }

  @Test(expected = NullPointerException.class)
  public void testOfNullValue() {
    Role.of(null);
  }

  private void compareRoles(Role expected, Role actual) {
    assertEquals(expected, actual);
    assertEquals(expected.getValue(), actual.getValue());
    assertEquals(expected.hashCode(), actual.hashCode());
    assertEquals(expected.toString(), actual.toString());
  }
}
