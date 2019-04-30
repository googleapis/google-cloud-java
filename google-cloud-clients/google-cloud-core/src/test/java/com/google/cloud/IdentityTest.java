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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class IdentityTest {

  private static final Identity ALL_USERS = Identity.allUsers();
  private static final Identity ALL_AUTH_USERS = Identity.allAuthenticatedUsers();
  private static final Identity USER = Identity.user("abc@gmail.com");
  private static final Identity SERVICE_ACCOUNT =
      Identity.serviceAccount("service-account@gmail.com");
  private static final Identity GROUP = Identity.group("group@gmail.com");
  private static final Identity DOMAIN = Identity.domain("google.com");
  private static final Identity PROJECT_OWNER = Identity.projectOwner("my-sample-project");
  private static final Identity PROJECT_EDITOR = Identity.projectEditor("my-sample-project");
  private static final Identity PROJECT_VIEWER = Identity.projectViewer("my-sample-project");

  @Test
  public void testAllUsers() {
    assertEquals(Identity.Type.ALL_USERS, ALL_USERS.getType());
    assertNull(ALL_USERS.getValue());
  }

  @Test
  public void testAllAuthenticatedUsers() {
    assertEquals(Identity.Type.ALL_AUTHENTICATED_USERS, ALL_AUTH_USERS.getType());
    assertNull(ALL_AUTH_USERS.getValue());
  }

  @Test
  public void testUser() {
    assertEquals(Identity.Type.USER, USER.getType());
    assertEquals("abc@gmail.com", USER.getValue());
  }

  @Test(expected = NullPointerException.class)
  public void testUserNullEmail() {
    Identity.user(null);
  }

  @Test
  public void testServiceAccount() {
    assertEquals(Identity.Type.SERVICE_ACCOUNT, SERVICE_ACCOUNT.getType());
    assertEquals("service-account@gmail.com", SERVICE_ACCOUNT.getValue());
  }

  @Test(expected = NullPointerException.class)
  public void testServiceAccountNullEmail() {
    Identity.serviceAccount(null);
  }

  @Test
  public void testGroup() {
    assertEquals(Identity.Type.GROUP, GROUP.getType());
    assertEquals("group@gmail.com", GROUP.getValue());
  }

  @Test(expected = NullPointerException.class)
  public void testGroupNullEmail() {
    Identity.group(null);
  }

  @Test
  public void testDomain() {
    assertEquals(Identity.Type.DOMAIN, DOMAIN.getType());
    assertEquals("google.com", DOMAIN.getValue());
  }

  @Test(expected = NullPointerException.class)
  public void testDomainNullId() {
    Identity.domain(null);
  }

  @Test
  public void testProjectOwner() {
    assertEquals(Identity.Type.PROJECT_OWNER, PROJECT_OWNER.getType());
    assertEquals("my-sample-project", PROJECT_OWNER.getValue());
  }

  @Test(expected = NullPointerException.class)
  public void testProjectOwnerNullId() {
    Identity.projectOwner(null);
  }

  @Test
  public void testProjectEditor() {
    assertEquals(Identity.Type.PROJECT_EDITOR, PROJECT_EDITOR.getType());
    assertEquals("my-sample-project", PROJECT_EDITOR.getValue());
  }

  @Test(expected = NullPointerException.class)
  public void testProjectEditorNullId() {
    Identity.projectEditor(null);
  }

  @Test
  public void testProjectViewer() {
    assertEquals(Identity.Type.PROJECT_VIEWER, PROJECT_VIEWER.getType());
    assertEquals("my-sample-project", PROJECT_VIEWER.getValue());
  }

  @Test(expected = NullPointerException.class)
  public void testProjectViewerNullId() {
    Identity.projectViewer(null);
  }

  @Test
  public void testIdentityToAndFromPb() {
    compareIdentities(ALL_USERS, Identity.valueOf(ALL_USERS.strValue()));
    compareIdentities(ALL_AUTH_USERS, Identity.valueOf(ALL_AUTH_USERS.strValue()));
    compareIdentities(USER, Identity.valueOf(USER.strValue()));
    compareIdentities(SERVICE_ACCOUNT, Identity.valueOf(SERVICE_ACCOUNT.strValue()));
    compareIdentities(GROUP, Identity.valueOf(GROUP.strValue()));
    compareIdentities(DOMAIN, Identity.valueOf(DOMAIN.strValue()));
    compareIdentities(PROJECT_OWNER, Identity.valueOf(PROJECT_OWNER.strValue()));
    compareIdentities(PROJECT_EDITOR, Identity.valueOf(PROJECT_EDITOR.strValue()));
    compareIdentities(PROJECT_VIEWER, Identity.valueOf(PROJECT_VIEWER.strValue()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfEmpty() {
    Identity.valueOf("");
  }

  @Test
  public void testUnrecognizedToString() {
    assertEquals("a:b", Identity.valueOf("a:b").strValue());
  }

  @Test
  public void testValueOfThreePart() {
    Identity identity = Identity.valueOf("a:b:c");
    assertEquals("A", identity.getType().name());
    assertEquals("b:c", identity.getValue());
  }

  private void compareIdentities(Identity expected, Identity actual) {
    assertEquals(expected, actual);
    assertEquals(expected.getType(), actual.getType());
    assertEquals(expected.getValue(), actual.getValue());
  }
}
