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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.gcloud.resourcemanager.Policy.Binding;
import com.google.gcloud.resourcemanager.Policy.Member;
import com.google.gcloud.resourcemanager.Policy.RoleType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PolicyTest {

  private static final Binding OWNER_BINDING;
  private static final Binding EDITOR_BINDING;
  private static final Binding VIEWER_BINDING;
  private static final Binding EMPTY_BINDING = Policy.Binding.builder().build();
  private static final List<Member> OWNER_MEMBER_LIST = new ArrayList<>();
  private static final List<Member> EDITOR_MEMBER_LIST = new ArrayList<>();
  private static final List<Member> VIEWER_MEMBER_LIST = new ArrayList<>();
  static {
    OWNER_MEMBER_LIST.add(Member.user("first-owner@email.com"));
    OWNER_MEMBER_LIST.add(Member.group("group-of-owners@email.com"));
    OWNER_BINDING =
        Policy.Binding.builder().role(RoleType.OWNER).members(OWNER_MEMBER_LIST).build();
    EDITOR_MEMBER_LIST.add(Member.serviceAccount("editor@someemail.com"));
    EDITOR_BINDING =
        Policy.Binding.builder().role(RoleType.EDITOR).members(EDITOR_MEMBER_LIST).build();
    VIEWER_MEMBER_LIST.add(Member.serviceAccount("app@someemail.com"));
    VIEWER_MEMBER_LIST.add(Member.user("viewer@email.com"));
    VIEWER_BINDING =
        Policy.Binding.builder().role(RoleType.VIEWER).members(VIEWER_MEMBER_LIST).build();
  }
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
    assertEquals(OWNER_BINDING.role(), RoleType.OWNER);
    assertEquals(OWNER_BINDING.members(), OWNER_MEMBER_LIST);
    assertNull(EMPTY_BINDING.role());
    assertTrue(EMPTY_BINDING.members().isEmpty());
  }

  @Test
  public void testBindingToBuilder() {
    assertEquals(OWNER_BINDING, OWNER_BINDING.toBuilder().build());
    assertEquals(EMPTY_BINDING, EMPTY_BINDING.toBuilder().build());
  }

  @Test
  public void testBindingToAndFromPb() {
    assertEquals(OWNER_BINDING, Binding.fromPb(OWNER_BINDING.toPb()));
    assertEquals(EDITOR_BINDING, Binding.fromPb(EDITOR_BINDING.toPb()));
    assertEquals(VIEWER_BINDING, Binding.fromPb(VIEWER_BINDING.toPb()));
    assertEquals(EMPTY_BINDING, Binding.fromPb(EMPTY_BINDING.toPb()));
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
    assertEquals(FULL_POLICY, FULL_POLICY.toBuilder().build());
    assertEquals(EMPTY_POLICY, EMPTY_POLICY.toBuilder().build());
  }

  @Test
  public void testPolicyToAndFromPb() {
    assertEquals(EMPTY_POLICY, Policy.fromPb(EMPTY_POLICY.toPb()));
    assertEquals(FULL_POLICY, Policy.fromPb(FULL_POLICY.toPb()));
  }
}
