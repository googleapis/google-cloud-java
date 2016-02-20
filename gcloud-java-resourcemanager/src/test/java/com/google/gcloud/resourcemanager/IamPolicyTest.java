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

package com.google.gcloud.resourcemanager;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.BaseIamPolicy.Identity;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IamPolicyTest {

  private static final Identity ALL_USERS = Identity.allUsers();
  private static final Identity ALL_AUTH_USERS = Identity.allAuthenticatedUsers();
  private static final Identity USER = Identity.user("abc@gmail.com");
  private static final Identity SERVICE_ACCOUNT =
      Identity.serviceAccount("service-account@gmail.com");
  private static final Identity GROUP = Identity.group("group@gmail.com");
  private static final Identity DOMAIN = Identity.domain("google.com");
  private static final Map<String, ImmutableList<Identity>> BINDINGS = ImmutableMap.of(
      "viewer",
      ImmutableList.of(USER, SERVICE_ACCOUNT, ALL_USERS),
      "editor",
      ImmutableList.of(ALL_AUTH_USERS, GROUP, DOMAIN));
  private static final IamPolicy SIMPLE_POLICY = IamPolicy.builder()
      .addBinding("viewer", ImmutableList.of(USER, SERVICE_ACCOUNT, ALL_USERS))
      .addBinding("editor", ImmutableList.of(ALL_AUTH_USERS, GROUP, DOMAIN))
      .build();
  private static final IamPolicy FULL_POLICY =
      new IamPolicy.Builder(SIMPLE_POLICY.bindings(), "etag", 1).build();

  @Test
  public void testIamPolicyBuilder() {
    assertEquals(BINDINGS, FULL_POLICY.bindings());
    assertEquals("etag", FULL_POLICY.etag());
    assertEquals(1, FULL_POLICY.version());
    Map<String, List<Identity>> editorBinding = new HashMap<>();
    editorBinding.put("editor", BINDINGS.get("editor"));
    IamPolicy policy = FULL_POLICY.toBuilder().bindings(editorBinding).build();
    assertEquals(ImmutableMap.of("editor", BINDINGS.get("editor")), policy.bindings());
    assertEquals("etag", policy.etag());
    assertEquals(1, policy.version());
    policy = SIMPLE_POLICY.toBuilder().removeBinding("editor").build();
    assertEquals(ImmutableMap.of("viewer", BINDINGS.get("viewer")), policy.bindings());
    assertEquals(null, policy.etag());
    assertEquals(0, policy.version());
  }

  @Test
  public void testIamPolicyToBuilder() {
    assertEquals(FULL_POLICY, FULL_POLICY.toBuilder().build());
    assertEquals(SIMPLE_POLICY, SIMPLE_POLICY.toBuilder().build());
  }

  @Test
  public void testIdentityToAndFromPb() {
    assertEquals(ALL_USERS, IamPolicy.identityFromPb(IamPolicy.identityToPb(ALL_USERS)));
    assertEquals(ALL_AUTH_USERS, IamPolicy.identityFromPb(IamPolicy.identityToPb(ALL_AUTH_USERS)));
    assertEquals(USER, IamPolicy.identityFromPb(IamPolicy.identityToPb(USER)));
    assertEquals(
        SERVICE_ACCOUNT, IamPolicy.identityFromPb(IamPolicy.identityToPb(SERVICE_ACCOUNT)));
    assertEquals(GROUP, IamPolicy.identityFromPb(IamPolicy.identityToPb(GROUP)));
    assertEquals(DOMAIN, IamPolicy.identityFromPb(IamPolicy.identityToPb(DOMAIN)));
  }

  @Test
  public void testPolicyToAndFromPb() {
    assertEquals(FULL_POLICY, IamPolicy.fromPb(FULL_POLICY.toPb()));
    assertEquals(SIMPLE_POLICY, IamPolicy.fromPb(SIMPLE_POLICY.toPb()));
  }
}
