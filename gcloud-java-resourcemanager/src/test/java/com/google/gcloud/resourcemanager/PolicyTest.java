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

package com.google.gcloud.resourcemanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.resourcemanager.Policy.Binding;
import com.google.gcloud.resourcemanager.Policy.Member;
import com.google.gcloud.resourcemanager.Policy.RoleType;

import org.junit.Test;

import java.util.List;

public class PolicyTest {

  private static final List<Member> OWNER_MEMBER_LIST = ImmutableList.of(
      Member.user("first-owner@email.com"), Member.group("group-of-owners@email.com"));
  private static final List<Member> EDITOR_MEMBER_LIST =
      ImmutableList.of(Member.serviceAccount("editor@someemail.com"));
  private static final List<Member> VIEWER_MEMBER_LIST =
      ImmutableList.of(Member.serviceAccount("app@someemail.com"), Member.user("viewer@email.com"));
  private static final Binding OWNER_BINDING =
      Policy.Binding.builder().role(RoleType.OWNER).members(OWNER_MEMBER_LIST).build();
  private static final Binding EDITOR_BINDING =
      Policy.Binding.builder().role(RoleType.EDITOR).members(EDITOR_MEMBER_LIST).build();
  private static final Binding VIEWER_BINDING =
      Policy.Binding.builder().role(RoleType.VIEWER).members(VIEWER_MEMBER_LIST).build();
  private static final Policy EMPTY_POLICY = Policy.builder().build();
  private static final Integer VERSION = 1;
  private static final String ETAG = "some-etag-value";
  private static final Policy FULL_POLICY =
      Policy.builder()
          .addBinding(OWNER_BINDING)
          .addBinding(EDITOR_BINDING)
          .addBinding(VIEWER_BINDING)
          .version(VERSION)
          .etag(ETAG)
          .build();

  @Test
  public void testBindingBuilder() {
    assertEquals(RoleType.OWNER, OWNER_BINDING.role());
    assertEquals(OWNER_MEMBER_LIST, OWNER_BINDING.members());
  }

  @Test
  public void testBindingToBuilder() {
    assertEquals(OWNER_BINDING, OWNER_BINDING.toBuilder().build());
  }

  @Test
  public void testBindingToAndFromPb() {
    assertEquals(OWNER_BINDING, Binding.fromPb(OWNER_BINDING.toPb()));
    assertEquals(EDITOR_BINDING, Binding.fromPb(EDITOR_BINDING.toPb()));
    assertEquals(VIEWER_BINDING, Binding.fromPb(VIEWER_BINDING.toPb()));
  }

  @Test
  public void testPolicyBuilder() {
    assertEquals(OWNER_BINDING, FULL_POLICY.bindings().get(0));
    assertEquals(EDITOR_BINDING, FULL_POLICY.bindings().get(1));
    assertEquals(VIEWER_BINDING, FULL_POLICY.bindings().get(2));
    assertEquals(VERSION, FULL_POLICY.version());
    assertEquals(ETAG, FULL_POLICY.etag());
  }

  @Test
  public void testPolicyToBuilder() {
    comparePolicies(FULL_POLICY, FULL_POLICY.toBuilder().build());
    comparePolicies(EMPTY_POLICY, EMPTY_POLICY.toBuilder().build());
  }

  @Test
  public void testPolicyToAndFromPb() {
    comparePolicies(FULL_POLICY, Policy.fromPb(FULL_POLICY.toPb()));
    comparePolicies(EMPTY_POLICY, Policy.fromPb(EMPTY_POLICY.toPb()));
  }

  @Test
  public void testEquals() {
    comparePolicies(
        FULL_POLICY,
        Policy.builder()
            .addBinding(OWNER_BINDING)
            .addBinding(EDITOR_BINDING)
            .addBinding(VIEWER_BINDING)
            .version(VERSION)
            .etag(ETAG)
            .build());
    comparePolicies(EMPTY_POLICY, Policy.builder().build());
    assertNotEquals(FULL_POLICY, EMPTY_POLICY);
  }

  private void comparePolicies(Policy expected, Policy value) {
    assertEquals(expected, value);
    assertEquals(expected.bindings(), value.bindings());
    assertEquals(expected.version(), value.version());
    assertEquals(expected.etag(), value.etag());
  }
}
