/*
 * Copyright 2020 Google LLC
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
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class PolicyV3Test {

  private static final String ALL_USERS = "allUsers";
  private static final String ALL_AUTH_USERS = "allAuthenticatedUsers";
  private static final String USER = "user:abc@gmail.com";
  private static final String SERVICE_ACCOUNT = "serviceAccount:service-account@gmail.com";
  private static final String GROUP = "group:group@gmail.com";
  private static final String DOMAIN = "domain:google.com";
  private static final String VIEWER = "roles/viewer";
  private static final String EDITOR = "roles/editor";
  private static final String OWNER = "roles/owner";
  private static final List<String> MEMBERS_LIST_1 =
      ImmutableList.of(USER, SERVICE_ACCOUNT, ALL_USERS);
  private static final List<String> MEMBERS_LIST_2 =
      ImmutableList.of(ALL_AUTH_USERS, GROUP, DOMAIN);
  private static final List<Binding> BINDINGS_NO_CONDITIONS =
      ImmutableList.of(
          Binding.newBuilder().setRole(VIEWER).setMembers(MEMBERS_LIST_1).build(),
          Binding.newBuilder().setRole(EDITOR).setMembers(MEMBERS_LIST_2).build());
  private static final List<Binding> BINDINGS_WITH_CONDITIONS =
      ImmutableList.copyOf(BINDINGS_NO_CONDITIONS)
          .of(
              Binding.newBuilder()
                  .setRole(VIEWER)
                  .setMembers(MEMBERS_LIST_1)
                  .setCondition(
                      Condition.newBuilder()
                          .setTitle("Condition")
                          .setDescription("Condition")
                          .setExpression("Expr")
                          .build())
                  .build(),
              Binding.newBuilder().setRole(EDITOR).setMembers(MEMBERS_LIST_2).build());
  private static final Policy FULL_POLICY_V1 =
      Policy.newBuilder().setBindings(BINDINGS_NO_CONDITIONS).setEtag("etag").setVersion(1).build();

  private static final Policy FULL_POLICY_V3 =
      Policy.newBuilder()
          .setBindings(BINDINGS_WITH_CONDITIONS)
          .setEtag("etag")
          .setVersion(3)
          .build();

  private static final Policy FULL_POLICY_V3_WITH_VERSION_1 =
      Policy.newBuilder()
          .setBindings(BINDINGS_WITH_CONDITIONS)
          .setEtag("etag")
          .setVersion(1)
          .build();

  @Test
  public void testBuilderV1() {
    assertEquals(BINDINGS_NO_CONDITIONS, FULL_POLICY_V1.getBindingsList());
    assertEquals(1, FULL_POLICY_V1.getVersion());
    assertEquals("etag", FULL_POLICY_V1.getEtag());
    Policy policy = FULL_POLICY_V1.toBuilder().setBindings(BINDINGS_NO_CONDITIONS).build();
    assertEquals(BINDINGS_NO_CONDITIONS, policy.getBindingsList());
    assertEquals("etag", policy.getEtag());
    assertEquals(1, policy.getVersion());
  }

  @Test
  public void testBuilderV3WithConditions() {
    assertEquals(BINDINGS_WITH_CONDITIONS, FULL_POLICY_V3.getBindingsList());
    assertEquals(3, FULL_POLICY_V3.getVersion());
    assertEquals("etag", FULL_POLICY_V3.getEtag());
    Policy policy = FULL_POLICY_V3.toBuilder().setBindings(BINDINGS_WITH_CONDITIONS).build();
    assertEquals(BINDINGS_WITH_CONDITIONS, policy.getBindingsList());
    assertEquals("etag", policy.getEtag());
    assertEquals(3, policy.getVersion());
  }

  @Test
  public void testBuilderV1ToV3Compatability() {
    assertEquals(BINDINGS_WITH_CONDITIONS, FULL_POLICY_V3_WITH_VERSION_1.getBindingsList());
    assertEquals(1, FULL_POLICY_V3_WITH_VERSION_1.getVersion());
    assertEquals("etag", FULL_POLICY_V3_WITH_VERSION_1.getEtag());
    Policy policy =
        FULL_POLICY_V3_WITH_VERSION_1
            .toBuilder()
            .setBindings(BINDINGS_WITH_CONDITIONS)
            .setVersion(3)
            .build();
    assertEquals(BINDINGS_WITH_CONDITIONS, policy.getBindingsList());
    assertEquals("etag", policy.getEtag());
    assertEquals(3, policy.getVersion());
  }

  @Test
  public void removeMemberFromPolicy() {
    assertEquals(3, FULL_POLICY_V3.getBindingsList().get(0).getMembers().size());
    List<Binding> bindings = new ArrayList<>(FULL_POLICY_V3.getBindingsList());

    for (int i = 0; i < bindings.size(); i++) {
      Binding binding = bindings.get(i);
      if (binding.getRole().equals(VIEWER)) {
        bindings.set(i, binding.toBuilder().removeMembers(ALL_USERS).build());
        break;
      }
    }

    Policy updatedPolicy = FULL_POLICY_V3.toBuilder().setBindings(bindings).build();
    assertEquals(2, updatedPolicy.getBindingsList().get(0).getMembers().size());
  }

  @Test
  public void addMemberFromPolicy() {
    assertEquals(3, FULL_POLICY_V3.getBindingsList().get(0).getMembers().size());
    List<Binding> bindings = new ArrayList<>(FULL_POLICY_V3.getBindingsList());

    for (int i = 0; i < bindings.size(); i++) {
      Binding binding = bindings.get(i);
      if (binding.getRole().equals(VIEWER)) {
        bindings.set(i, binding.toBuilder().addMembers("user:example@example.com").build());
      }
    }

    Policy updatedPolicy = FULL_POLICY_V3.toBuilder().setBindings(bindings).build();
    assertEquals(4, updatedPolicy.getBindingsList().get(0).getMembers().size());
  }

  @Test
  public void removeBindingFromPolicy() {
    assertEquals(2, FULL_POLICY_V3.getBindingsList().size());
    List<Binding> bindings = new ArrayList<>(FULL_POLICY_V3.getBindingsList());

    Iterator iterator = bindings.iterator();
    while (iterator.hasNext()) {
      Binding binding = (Binding) iterator.next();
      if (binding.getRole().equals(EDITOR) && binding.getCondition() == null) {
        iterator.remove();
        break;
      }
    }

    Policy updatedPolicy = FULL_POLICY_V3.toBuilder().setBindings(bindings).build();
    assertEquals(1, updatedPolicy.getBindingsList().size());
  }

  @Test
  public void addBindingToPolicy() {
    assertEquals(2, FULL_POLICY_V3.getBindingsList().size());
    List<Binding> bindings = new ArrayList<>(FULL_POLICY_V3.getBindingsList());
    bindings.add(Binding.newBuilder().setRole(OWNER).setMembers(ImmutableList.of(USER)).build());
    Policy updatedPolicy = FULL_POLICY_V3.toBuilder().setBindings(bindings).build();
    assertEquals(3, updatedPolicy.getBindingsList().size());
  }

  @Test
  public void testIllegalPolicies() {
    try {
      Binding.newBuilder().setRole(null).build();
      fail("Null role should cause exception.");
    } catch (NullPointerException ex) {
      assertEquals("Null role", ex.getMessage());
    }
    try {
      FULL_POLICY_V3
          .toBuilder()
          .setBindings(
              Arrays.asList(
                  Binding.newBuilder()
                      .setRole("test")
                      .setMembers(Arrays.asList(null, "user"))
                      .build()))
          .build();
      fail("Null member should cause exception.");
    } catch (NullPointerException ex) {
      assertEquals("at index 0", ex.getMessage());
    }
    try {
      FULL_POLICY_V3.getBindings();
      fail("getBindings() should cause exception with Policy V3.");
    } catch (IllegalArgumentException ex) {
      assertEquals(
          "getBindings() is only supported with version 1 policies and non-conditional policies",
          ex.getMessage());
    }
    try {
      FULL_POLICY_V3.toBuilder().addIdentity(Role.editor(), Identity.allUsers());
      fail("getBindings() should cause exception with Policy V3.");
    } catch (IllegalArgumentException ex) {
      assertEquals(
          "addIdentity() is only supported with version 1 policies and non-conditional policies",
          ex.getMessage());
    }
    try {
      FULL_POLICY_V3.toBuilder().removeIdentity(Role.editor(), Identity.allUsers());
      fail("getBindings() should cause exception with Policy V3.");
    } catch (IllegalArgumentException ex) {
      assertEquals(
          "removeIdentity() is only supported with version 1 policies and non-conditional policies",
          ex.getMessage());
    }
    try {
      FULL_POLICY_V3.toBuilder().setBindings(FULL_POLICY_V1.getBindings());
      fail("getBindings() should cause exception with Policy V3.");
    } catch (IllegalArgumentException ex) {
      assertEquals(
          "setBindings() is only supported with version 1 policies and non-conditional policies",
          ex.getMessage());
    }
  }

  @Test
  public void testEqualsHashCode() {
    assertNotNull(FULL_POLICY_V3);
    Policy emptyPolicy = Policy.newBuilder().build();
    Policy anotherPolicy = Policy.newBuilder().build();
    assertEquals(emptyPolicy, anotherPolicy);
    assertEquals(emptyPolicy.hashCode(), anotherPolicy.hashCode());
    assertNotEquals(FULL_POLICY_V3, FULL_POLICY_V1);
    assertNotEquals(FULL_POLICY_V3.hashCode(), FULL_POLICY_V1.hashCode());
    Policy copy = FULL_POLICY_V1.toBuilder().build();
    assertEquals(FULL_POLICY_V1, copy);
    assertEquals(FULL_POLICY_V1.hashCode(), copy.hashCode());
  }

  @Test
  public void testBindings() {
    assertTrue(Policy.newBuilder().build().getBindingsList().isEmpty());
    assertEquals(BINDINGS_WITH_CONDITIONS, FULL_POLICY_V3.getBindingsList());
  }

  @Test
  public void testEtag() {
    assertNotNull(FULL_POLICY_V3.getEtag());
    assertEquals("etag", FULL_POLICY_V3.getEtag());
  }

  @Test
  public void testVersion() {
    assertEquals(1, FULL_POLICY_V1.getVersion());
    assertEquals(3, FULL_POLICY_V3.getVersion());
    assertEquals(1, FULL_POLICY_V3_WITH_VERSION_1.getVersion());
  }

  @Test
  public void testDefaultMarshaller() {
    DefaultMarshaller marshaller = new DefaultMarshaller();
    Policy emptyPolicy = Policy.newBuilder().build();
    assertEquals(emptyPolicy, marshaller.fromPb(marshaller.toPb(emptyPolicy)));
    assertEquals(FULL_POLICY_V3, marshaller.fromPb(marshaller.toPb(FULL_POLICY_V3)));
    assertEquals(FULL_POLICY_V1, marshaller.fromPb(marshaller.toPb(FULL_POLICY_V1)));
    com.google.iam.v1.Policy policyPb = com.google.iam.v1.Policy.getDefaultInstance();
    Policy policy = marshaller.fromPb(policyPb);
    assertTrue(policy.getBindingsList().isEmpty());
    assertNull(policy.getEtag());
    assertEquals(0, policy.getVersion());
  }
}
