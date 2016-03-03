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

import com.google.common.collect.ImmutableSet;
import com.google.gcloud.Identity;

import org.junit.Test;

public class PolicyTest {

  private static final Identity ALL_USERS = Identity.allUsers();
  private static final Identity ALL_AUTH_USERS = Identity.allAuthenticatedUsers();
  private static final Identity USER = Identity.user("abc@gmail.com");
  private static final Identity SERVICE_ACCOUNT =
      Identity.serviceAccount("service-account@gmail.com");
  private static final Identity GROUP = Identity.group("group@gmail.com");
  private static final Identity DOMAIN = Identity.domain("google.com");
  private static final Policy SIMPLE_POLICY = Policy.builder()
      .addBinding(Policy.Role.VIEWER, ImmutableSet.of(USER, SERVICE_ACCOUNT, ALL_USERS))
      .addBinding(Policy.Role.EDITOR, ImmutableSet.of(ALL_AUTH_USERS, GROUP, DOMAIN))
      .build();
  private static final Policy FULL_POLICY =
      new Policy.Builder(SIMPLE_POLICY.bindings(), "etag", 1).build();

  @Test
  public void testIamPolicyToBuilder() {
    assertEquals(FULL_POLICY, FULL_POLICY.toBuilder().build());
    assertEquals(SIMPLE_POLICY, SIMPLE_POLICY.toBuilder().build());
  }

  @Test
  public void testPolicyToAndFromPb() {
    assertEquals(FULL_POLICY, Policy.fromPb(FULL_POLICY.toPb()));
    assertEquals(SIMPLE_POLICY, Policy.fromPb(SIMPLE_POLICY.toPb()));
  }
}
