/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.ImmutableList;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.showcase.v1beta1.IdentityClient;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ITIam {
  private static final Policy DEFAULT_POLICY =
      Policy.newBuilder()
          .addBindings(Binding.newBuilder().setRole("foo.editor").addMembers("allUsers"))
          .build();
  private static IdentityClient grpcClient;
  private static IdentityClient httpjsonClient;
  private String resourceName;

  @BeforeAll
  static void createClients() throws Exception {
    grpcClient = TestClientInitializer.createGrpcIdentityClient();
    httpjsonClient = TestClientInitializer.createHttpJsonIdentityClient();
  }

  @BeforeEach
  void setupTests() {
    resourceName = "users/" + UUID.randomUUID().toString().substring(0, 8);
  }

  @AfterAll
  public static void destroyClients() throws InterruptedException {
    grpcClient.close();
    httpjsonClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpjsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testGrpc_setIamPolicy() {
    SetIamPolicyRequest policyRequest =
        SetIamPolicyRequest.newBuilder()
            .setPolicy(DEFAULT_POLICY)
            .setResource(resourceName)
            .build();
    Policy policy = grpcClient.setIamPolicy(policyRequest);
    assertThat(policy).isEqualTo(DEFAULT_POLICY);
  }

  @Test
  void testHttpJson_setIamPolicy() {
    SetIamPolicyRequest policyRequest =
        SetIamPolicyRequest.newBuilder()
            .setPolicy(DEFAULT_POLICY)
            .setResource(resourceName)
            .build();
    Policy policy = httpjsonClient.setIamPolicy(policyRequest);
    assertThat(policy).isEqualTo(DEFAULT_POLICY);
  }

  @Test
  void testGrpc_getIamPolicy() {
    SetIamPolicyRequest policyRequest =
        SetIamPolicyRequest.newBuilder()
            .setPolicy(DEFAULT_POLICY)
            .setResource(resourceName)
            .build();
    grpcClient.setIamPolicy(policyRequest);

    Policy policy =
        grpcClient.getIamPolicy(
            GetIamPolicyRequest.newBuilder().setResource(policyRequest.getResource()).build());
    assertThat(policy).isEqualTo(DEFAULT_POLICY);
  }

  @Test
  void testHttpJson_getIamPolicy() {
    SetIamPolicyRequest policyRequest =
        SetIamPolicyRequest.newBuilder()
            .setPolicy(DEFAULT_POLICY)
            .setResource(resourceName)
            .build();
    httpjsonClient.setIamPolicy(policyRequest);

    Policy policy =
        httpjsonClient.getIamPolicy(
            GetIamPolicyRequest.newBuilder().setResource(policyRequest.getResource()).build());
    assertThat(policy).isEqualTo(DEFAULT_POLICY);
  }

  @Test
  void testGrpc_testIamPermissions() {
    SetIamPolicyRequest policyRequest =
        SetIamPolicyRequest.newBuilder()
            .setPolicy(DEFAULT_POLICY)
            .setResource(resourceName)
            .build();
    grpcClient.setIamPolicy(policyRequest);
    List<String> permissions = ImmutableList.of("foo.create", "foo.write");
    TestIamPermissionsResponse testIamPermissionsResponse =
        grpcClient.testIamPermissions(
            TestIamPermissionsRequest.newBuilder()
                .setResource(policyRequest.getResource())
                .addAllPermissions(permissions)
                .build());
    // Showcase server will simply echo the request's Permissions List back
    // if the resource exists and contains a policy
    assertThat(testIamPermissionsResponse.getPermissionsList())
        .containsExactlyElementsIn(permissions);
  }

  @Test
  void testHttpJson_testIamPermissions() {
    SetIamPolicyRequest policyRequest =
        SetIamPolicyRequest.newBuilder()
            .setPolicy(DEFAULT_POLICY)
            .setResource(resourceName)
            .build();
    httpjsonClient.setIamPolicy(policyRequest);
    List<String> permissions = ImmutableList.of("foo.create", "foo.write");
    TestIamPermissionsResponse testIamPermissionsResponse =
        httpjsonClient.testIamPermissions(
            TestIamPermissionsRequest.newBuilder()
                .setResource(policyRequest.getResource())
                .addAllPermissions(permissions)
                .build());
    // Showcase server will simply echo the request's Permissions List back
    // if the resource exists and contains a policy
    assertThat(testIamPermissionsResponse.getPermissionsList())
        .containsExactlyElementsIn(permissions);
  }

  // The tests below simply assert that an exception is being thrown for an invalid request
  // in both transports. Showcase's IAM backend service will throw a few exceptions for a few
  // cases, and we simply assert that an exception has been thrown for a single case with a single
  // RPC (No resource in the request for SetIamPolicy's RPC).
  @Test
  void testGrpc_iamThrowsException() {
    SetIamPolicyRequest setIamPolicyRequest = SetIamPolicyRequest.newBuilder().build();
    assertThrows(
        InvalidArgumentException.class, () -> grpcClient.setIamPolicy(setIamPolicyRequest));
  }

  @Test
  void testHttpJson_iamThrowsException() {
    SetIamPolicyRequest setIamPolicyRequest = SetIamPolicyRequest.newBuilder().build();
    assertThrows(
        InvalidArgumentException.class, () -> httpjsonClient.setIamPolicy(setIamPolicyRequest));
  }
}
