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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Policy.DefaultMarshaller;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class PolicyTest {

  private static final Identity ALL_USERS = Identity.allUsers();
  private static final Identity ALL_AUTH_USERS = Identity.allAuthenticatedUsers();
  private static final Identity USER = Identity.user("abc@gmail.com");
  private static final Identity SERVICE_ACCOUNT =
      Identity.serviceAccount("service-account@gmail.com");
  private static final Identity GROUP = Identity.group("group@gmail.com");
  private static final Identity DOMAIN = Identity.domain("google.com");
  private static final Role VIEWER = Role.viewer();
  private static final Role EDITOR = Role.editor();
  private static final Role OWNER = Role.owner();
  private static final Map<Role, ImmutableSet<Identity>> BINDINGS =
      ImmutableMap.of(
          VIEWER,
          ImmutableSet.of(USER, SERVICE_ACCOUNT, ALL_USERS),
          EDITOR,
          ImmutableSet.of(ALL_AUTH_USERS, GROUP, DOMAIN));
  private static final Policy SIMPLE_POLICY =
      Policy.newBuilder()
          .addIdentity(VIEWER, USER, SERVICE_ACCOUNT, ALL_USERS)
          .addIdentity(EDITOR, ALL_AUTH_USERS, GROUP, DOMAIN)
          .build();
  private static final Policy FULL_POLICY =
      Policy.newBuilder()
          .setBindings(SIMPLE_POLICY.getBindings())
          .setEtag("etag")
          .setVersion(1)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(BINDINGS, SIMPLE_POLICY.getBindings());
    assertEquals(null, SIMPLE_POLICY.getEtag());
    assertEquals(0, SIMPLE_POLICY.getVersion());
    assertEquals(BINDINGS, FULL_POLICY.getBindings());
    assertEquals("etag", FULL_POLICY.getEtag());
    assertEquals(1, FULL_POLICY.getVersion());
    Map<Role, Set<Identity>> editorBinding =
        ImmutableMap.<Role, Set<Identity>>builder().put(EDITOR, BINDINGS.get(EDITOR)).build();
    Policy policy = FULL_POLICY.toBuilder().setBindings(editorBinding).build();
    assertEquals(editorBinding, policy.getBindings());
    assertEquals("etag", policy.getEtag());
    assertEquals(1, policy.getVersion());
    policy = SIMPLE_POLICY.toBuilder().removeRole(EDITOR).build();
    assertEquals(ImmutableMap.of(VIEWER, BINDINGS.get(VIEWER)), policy.getBindings());
    assertNull(policy.getEtag());
    assertEquals(0, policy.getVersion());
    policy =
        policy
            .toBuilder()
            .removeIdentity(VIEWER, USER, ALL_USERS)
            .addIdentity(VIEWER, DOMAIN, GROUP)
            .build();
    assertEquals(
        ImmutableMap.of(VIEWER, ImmutableSet.of(SERVICE_ACCOUNT, DOMAIN, GROUP)),
        policy.getBindings());
    assertNull(policy.getEtag());
    assertEquals(0, policy.getVersion());
    policy =
        Policy.newBuilder()
            .removeIdentity(VIEWER, USER)
            .addIdentity(OWNER, USER, SERVICE_ACCOUNT)
            .addIdentity(EDITOR, GROUP)
            .removeIdentity(EDITOR, GROUP)
            .build();
    assertEquals(
        ImmutableMap.of(OWNER, ImmutableSet.of(USER, SERVICE_ACCOUNT)), policy.getBindings());
    assertNull(policy.getEtag());
    assertEquals(0, policy.getVersion());
  }

  @Test
  public void testIllegalPolicies() {
    try {
      Policy.newBuilder().addIdentity(null, USER);
      fail("Null role should cause exception.");
    } catch (NullPointerException ex) {
      assertEquals("The role cannot be null.", ex.getMessage());
    }
    try {
      Policy.newBuilder().addIdentity(VIEWER, null, USER);
      fail("Null identity should cause exception.");
    } catch (NullPointerException ex) {
      assertEquals("Null identities are not permitted.", ex.getMessage());
    }
    try {
      Policy.newBuilder().addIdentity(VIEWER, USER, (Identity[]) null);
      fail("Null identity should cause exception.");
    } catch (NullPointerException ex) {
      assertEquals("Null identities are not permitted.", ex.getMessage());
    }
    try {
      Policy.newBuilder().setBindings(null);
      fail("Null bindings map should cause exception.");
    } catch (NullPointerException ex) {
      assertEquals("The provided map of bindings cannot be null.", ex.getMessage());
    }
    try {
      Map<Role, Set<Identity>> bindings = new HashMap<>();
      bindings.put(VIEWER, null);
      Policy.newBuilder().setBindings(bindings);
      fail("Null set of identities should cause exception.");
    } catch (NullPointerException ex) {
      assertEquals("A role cannot be assigned to a null set of identities.", ex.getMessage());
    }
    try {
      Map<Role, Set<Identity>> bindings = new HashMap<>();
      Set<Identity> identities = new HashSet<>();
      identities.add(null);
      bindings.put(VIEWER, identities);
      Policy.newBuilder().setBindings(bindings);
      fail("Null identity should cause exception.");
    } catch (IllegalArgumentException ex) {
      assertEquals("Null identities are not permitted.", ex.getMessage());
    }
  }

  @Test
  public void testEqualsHashCode() {
    assertNotNull(FULL_POLICY);
    Policy emptyPolicy = Policy.newBuilder().build();
    Policy anotherPolicy = Policy.newBuilder().build();
    assertEquals(emptyPolicy, anotherPolicy);
    assertEquals(emptyPolicy.hashCode(), anotherPolicy.hashCode());
    assertNotEquals(FULL_POLICY, SIMPLE_POLICY);
    assertNotEquals(FULL_POLICY.hashCode(), SIMPLE_POLICY.hashCode());
    Policy copy = SIMPLE_POLICY.toBuilder().build();
    assertEquals(SIMPLE_POLICY, copy);
    assertEquals(SIMPLE_POLICY.hashCode(), copy.hashCode());
  }

  @Test
  public void testBindings() {
    assertTrue(Policy.newBuilder().build().getBindings().isEmpty());
    assertEquals(BINDINGS, SIMPLE_POLICY.getBindings());
  }

  @Test
  public void testEtag() {
    assertNull(SIMPLE_POLICY.getEtag());
    assertEquals("etag", FULL_POLICY.getEtag());
  }

  @Test
  public void testVersion() {
    assertEquals(0, SIMPLE_POLICY.getVersion());
    assertEquals(1, FULL_POLICY.getVersion());
  }

  @Test
  public void testDefaultMarshaller() {
    DefaultMarshaller marshaller = new DefaultMarshaller();
    Policy emptyPolicy = Policy.newBuilder().build();
    assertEquals(emptyPolicy, marshaller.fromPb(marshaller.toPb(emptyPolicy)));
    assertEquals(SIMPLE_POLICY, marshaller.fromPb(marshaller.toPb(SIMPLE_POLICY)));
    assertEquals(FULL_POLICY, marshaller.fromPb(marshaller.toPb(FULL_POLICY)));
    com.google.iam.v1.Policy policyPb = com.google.iam.v1.Policy.getDefaultInstance();
    Policy policy = marshaller.fromPb(policyPb);
    assertTrue(policy.getBindings().isEmpty());
    assertNull(policy.getEtag());
    assertEquals(0, policy.getVersion());
  }
}
