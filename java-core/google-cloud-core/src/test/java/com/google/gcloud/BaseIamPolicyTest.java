/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud;

import static org.junit.Assert.assertEquals;

import com.google.gcloud.BaseIamPolicy.Identity;

import org.junit.Test;

public class BaseIamPolicyTest {

  private static final Identity ALL_USERS = Identity.allUsers();
  private static final Identity ALL_AUTH_USERS = Identity.allAuthenticatedUsers();
  private static final Identity USER = Identity.user("abc@gmail.com");
  private static final Identity SERVICE_ACCOUNT =
      Identity.serviceAccount("service-account@gmail.com");
  private static final Identity GROUP = Identity.group("group@gmail.com");
  private static final Identity DOMAIN = Identity.domain("google.com");

  @Test
  public void testIdentityOf() {
    assertEquals(Identity.Type.ALL_USERS, ALL_USERS.type());
    assertEquals(null, ALL_USERS.id());
    assertEquals(Identity.Type.ALL_AUTHENTICATED_USERS, ALL_AUTH_USERS.type());
    assertEquals(null, ALL_AUTH_USERS.id());
    assertEquals(Identity.Type.USER, USER.type());
    assertEquals("abc@gmail.com", USER.id());
    assertEquals(Identity.Type.SERVICE_ACCOUNT, SERVICE_ACCOUNT.type());
    assertEquals("service-account@gmail.com", SERVICE_ACCOUNT.id());
    assertEquals(Identity.Type.GROUP, GROUP.type());
    assertEquals("group@gmail.com", GROUP.id());
    assertEquals(Identity.Type.DOMAIN, DOMAIN.type());
    assertEquals("google.com", DOMAIN.id());
  }
}
