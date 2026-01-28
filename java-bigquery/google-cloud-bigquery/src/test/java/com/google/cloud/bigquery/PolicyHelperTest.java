/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigquery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.api.services.bigquery.model.Binding;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

class PolicyHelperTest {

  public static final String ETAG = "etag";
  public static final String ROLE1 = "roles/bigquery.admin";
  public static final String ROLE2 = "roles/bigquery.dataEditor";
  public static final String USER1 = "user1@gmail.com";
  public static final String USER2 = "user2@gmail.com";

  static final com.google.api.services.bigquery.model.Policy API_POLICY =
      new com.google.api.services.bigquery.model.Policy()
          .setBindings(
              ImmutableList.of(
                  new Binding()
                      .setRole(ROLE1)
                      .setMembers(ImmutableList.of(String.format("user:%s", USER1))),
                  new Binding()
                      .setRole(ROLE2)
                      .setMembers(ImmutableList.of(String.format("user:%s", USER2), "allUsers"))))
          .setEtag(ETAG)
          .setVersion(1);
  static final com.google.api.services.bigquery.model.Policy API_POLICY_NO_BINDINGS =
      new com.google.api.services.bigquery.model.Policy().setEtag(ETAG).setVersion(1);

  static final Policy IAM_POLICY =
      Policy.newBuilder()
          .addIdentity(Role.of(ROLE1), Identity.user(USER1))
          .addIdentity(Role.of(ROLE2), Identity.user(USER2), Identity.allUsers())
          .setEtag(ETAG)
          .setVersion(1)
          .build();
  static final Policy IAM_POLICY_NO_BINDINGS =
      Policy.newBuilder().setEtag(ETAG).setVersion(1).build();

  @Test
  void testConversionWithBindings() {
    assertEquals(IAM_POLICY, PolicyHelper.convertFromApiPolicy(API_POLICY));
    assertEquals(API_POLICY, PolicyHelper.convertToApiPolicy(IAM_POLICY));
    assertEquals(
        IAM_POLICY, PolicyHelper.convertFromApiPolicy(PolicyHelper.convertToApiPolicy(IAM_POLICY)));
    assertEquals(
        API_POLICY, PolicyHelper.convertToApiPolicy(PolicyHelper.convertFromApiPolicy(API_POLICY)));
  }

  @Test
  void testConversionNoBindings() {
    assertEquals(IAM_POLICY_NO_BINDINGS, PolicyHelper.convertFromApiPolicy(API_POLICY_NO_BINDINGS));
    assertEquals(API_POLICY_NO_BINDINGS, PolicyHelper.convertToApiPolicy(IAM_POLICY_NO_BINDINGS));
    assertEquals(
        IAM_POLICY_NO_BINDINGS,
        PolicyHelper.convertFromApiPolicy(PolicyHelper.convertToApiPolicy(IAM_POLICY_NO_BINDINGS)));
    assertEquals(
        API_POLICY_NO_BINDINGS,
        PolicyHelper.convertToApiPolicy(PolicyHelper.convertFromApiPolicy(API_POLICY_NO_BINDINGS)));
  }
}
