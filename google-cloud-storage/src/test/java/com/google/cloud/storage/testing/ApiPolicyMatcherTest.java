/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage.testing;

import static com.google.cloud.storage.testing.ApiPolicyMatcher.eqApiPolicy;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Test;

import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.Policy.Bindings;
import com.google.common.collect.ImmutableList;

public class ApiPolicyMatcherTest {

  private static interface PolicyAcceptor {
    int accept(Policy policy);
  }

  private static final String ETAG = "CAE=";
  private static final Policy API_POLICY_1 =
      new Policy()
          .setBindings(ImmutableList.of(
              new Bindings()
                  .setMembers(ImmutableList.of("allUsers"))
                  .setRole("roles/storage.objectViewer"),
              new Bindings()
                  .setMembers(
                      ImmutableList.of(
                          "user:test1@gmail.com",
                          "user:test2@gmail.com"))
                  .setRole("roles/storage.objectAdmin"),
              new Bindings()
                  .setMembers(ImmutableList.of("group:test-group@gmail.com"))
                  .setRole("roles/storage.admin")))
          .setEtag(ETAG);
  private static final Policy API_POLICY_2 =
      new Policy()
          .setBindings(ImmutableList.of(
              new Bindings()
                  .setMembers(ImmutableList.of("group:test-group@gmail.com"))
                  .setRole("roles/storage.admin"),
              new Bindings()
                  .setMembers(ImmutableList.of("allUsers"))
                  .setRole("roles/storage.objectViewer"),
              new Bindings()
                  .setMembers(
                      ImmutableList.of(
                          "user:test2@gmail.com",
                          "user:test1@gmail.com"))
                  .setRole("roles/storage.objectAdmin")))
          .setEtag(ETAG);
  private static final Policy API_POLICY_MISSING_BINDINGS =
      new Policy().setEtag(ETAG);
  private static final Policy API_POLICY_MISSING_ETAG =
      new Policy()
          .setBindings(ImmutableList.of(
              new Bindings()
                  .setMembers(ImmutableList.of("group:test-group@gmail.com"))
                  .setRole("roles/storage.admin"),
              new Bindings()
                  .setMembers(ImmutableList.of("allUsers"))
                  .setRole("roles/storage.objectViewer"),
              new Bindings()
                  .setMembers(
                      ImmutableList.of(
                          "user:test2@gmail.com",
                          "user:test1@gmail.com"))
                  .setRole("roles/storage.objectAdmin")));

  @Test
  public void testEquivalence() {
    assertMatch(API_POLICY_1, API_POLICY_2);
    assertMatch(API_POLICY_2, API_POLICY_1);
    assertNoMatch(API_POLICY_1, API_POLICY_MISSING_BINDINGS);
    assertNoMatch(API_POLICY_MISSING_BINDINGS, API_POLICY_1);
    assertNoMatch(API_POLICY_1, API_POLICY_MISSING_ETAG);
    assertNoMatch(API_POLICY_MISSING_ETAG, API_POLICY_1);
    assertNoMatch(API_POLICY_MISSING_BINDINGS, API_POLICY_MISSING_ETAG);
    assertNoMatch(API_POLICY_MISSING_ETAG, API_POLICY_MISSING_BINDINGS);
  }

  private static void assertMatch(Policy expected, Policy actual) {
    assertTrue(new ApiPolicyMatcher(expected).matches(actual));
  }

  private static void assertNoMatch(Policy expected, Policy actual) {
    assertFalse(new ApiPolicyMatcher(expected).matches(actual));
  }

  @Test
  public void testStaticMocker() {
    PolicyAcceptor mock = EasyMock.createMock(PolicyAcceptor.class);
    EasyMock.expect(mock.accept(eqApiPolicy(API_POLICY_1))).andReturn(0);
    EasyMock.replay(mock);
    mock.accept(API_POLICY_2);
    EasyMock.verify(mock);
  }
}
