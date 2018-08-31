/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BigtableInstanceAdminClientTest {
  private static final ProjectName PROJECT_NAME = ProjectName.of("my-project");
  private static final InstanceName INSTANCE_NAME =
      InstanceName.of(PROJECT_NAME.getProject(), "my-instance");

  private BigtableInstanceAdminClient adminClient;

  @Mock
  private BigtableInstanceAdminStub mockStub;
  @Mock
  private UnaryCallable<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> mockGetIamPolicyCallable;
  @Mock
  private UnaryCallable<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> mockSetIamPolicyCallable;
  @Mock
  private UnaryCallable<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> mockTestIamPermissionsCallable;

  @Before
  public void setUp() {
    adminClient = BigtableInstanceAdminClient
        .create(PROJECT_NAME, mockStub);

    Mockito.when(mockStub.getIamPolicyCallable()).thenReturn(mockGetIamPolicyCallable);
    Mockito.when(mockStub.setIamPolicyCallable()).thenReturn(mockSetIamPolicyCallable);
    Mockito.when(mockStub.testIamPermissionsCallable()).thenReturn(mockTestIamPermissionsCallable);
  }

  @Test
  public void testProjectName() {
    assertThat(adminClient.getProjectName()).isEqualTo(PROJECT_NAME);
  }

  @Test
  public void testClose() {
    adminClient.close();
    Mockito.verify(mockStub).close();
  }

  @Test
  public void testGetIamPolicy() {
    // Setup
    com.google.iam.v1.GetIamPolicyRequest expectedRequest =
        com.google.iam.v1.GetIamPolicyRequest.newBuilder()
            .setResource(INSTANCE_NAME.toString())
            .build();

    com.google.iam.v1.Policy expectedResponse =
        com.google.iam.v1.Policy.newBuilder()
            .addBindings(
                com.google.iam.v1.Binding.newBuilder()
                    .setRole("roles/bigtable.user")
                    .addMembers("user:someone@example.com")
            )
            .setEtag(ByteString.copyFromUtf8("my-etag"))
            .build();

    Mockito.when(mockGetIamPolicyCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Policy actualResult = adminClient.getIamPolicy(INSTANCE_NAME.getInstance());

    // Verify
    assertThat(actualResult).isEqualTo(
        Policy.newBuilder()
            .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
            .setEtag(BaseEncoding.base64().encode("my-etag".getBytes()))
            .build()
    );
  }

  @Test
  public void testSetIamPolicy() {
    // Setup
    com.google.iam.v1.SetIamPolicyRequest expectedRequest =
        com.google.iam.v1.SetIamPolicyRequest.newBuilder()
            .setResource(INSTANCE_NAME.toString())
            .setPolicy(
                com.google.iam.v1.Policy.newBuilder()
                  .addBindings(
                      com.google.iam.v1.Binding.newBuilder()
                         .setRole("roles/bigtable.user")
                        .addMembers("user:someone@example.com")
                  )
            )
            .build();

    com.google.iam.v1.Policy expectedResponse =
        com.google.iam.v1.Policy.newBuilder()
            .addBindings(
                com.google.iam.v1.Binding.newBuilder()
                    .setRole("roles/bigtable.user")
                    .addMembers("user:someone@example.com")
            )
            .setEtag(ByteString.copyFromUtf8("my-etag"))
            .build();

    Mockito.when(mockSetIamPolicyCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Policy actualResult = adminClient.setIamPolicy(INSTANCE_NAME.getInstance(),
        Policy.newBuilder()
            .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
            .build());

    // Verify
    assertThat(actualResult).isEqualTo(
        Policy.newBuilder()
            .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
            .setEtag(BaseEncoding.base64().encode("my-etag".getBytes()))
            .build()
    );
  }

  @Test
  public void testTestIamPermissions() {
    // Setup
    com.google.iam.v1.TestIamPermissionsRequest expectedRequest =
        com.google.iam.v1.TestIamPermissionsRequest.newBuilder()
            .setResource(INSTANCE_NAME.toString())
            .addPermissions("bigtable.tables.readRows")
            .build();

    com.google.iam.v1.TestIamPermissionsResponse expectedResponse =
        com.google.iam.v1.TestIamPermissionsResponse.newBuilder()
            .addPermissions("bigtable.tables.readRows")
            .build();

    Mockito.when(mockTestIamPermissionsCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    List<String> actualResult = adminClient.testIamPermission(INSTANCE_NAME.getInstance(),
        "bigtable.tables.readRows");

    // Verify
    assertThat(actualResult).containsExactly("bigtable.tables.readRows");
  }
}
