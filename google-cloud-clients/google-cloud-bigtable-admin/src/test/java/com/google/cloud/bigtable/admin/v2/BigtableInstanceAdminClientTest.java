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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationFutures;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.testing.FakeOperationSnapshot;
import com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;
import com.google.cloud.bigtable.admin.v2.models.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.MultiClusterRoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.CreateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.common.collect.Lists;
import com.google.common.truth.Truth;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status.Code;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class BigtableInstanceAdminClientTest {
  private static final ProjectName PROJECT_NAME = ProjectName.of("my-project");
  private static final InstanceName INSTANCE_NAME =
      InstanceName.of(PROJECT_NAME.getProject(), "my-instance");
  private static final AppProfileName APP_PROFILE_NAME =
      AppProfileName.of(INSTANCE_NAME.getProject(), INSTANCE_NAME.getInstance(), "my-cluster");

  private BigtableInstanceAdminClient adminClient;

  @Mock
  private BigtableInstanceAdminStub mockStub;

  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.CreateAppProfileRequest, com.google.bigtable.admin.v2.AppProfile> mockCreateAppProfileCallable;
  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.GetAppProfileRequest, com.google.bigtable.admin.v2.AppProfile> mockGetAppProfileCallable;
  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.ListAppProfilesRequest, ListAppProfilesPagedResponse> mockListAppProfilesCallable;
  @Mock
  private OperationCallable<com.google.bigtable.admin.v2.UpdateAppProfileRequest, com.google.bigtable.admin.v2.AppProfile, com.google.bigtable.admin.v2.UpdateAppProfileMetadata> mockUpdateAppProfileCallable;
  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.DeleteAppProfileRequest, Empty> mockDeleteAppProfileCallable;


  @Before
  public void setUp() {
    adminClient = BigtableInstanceAdminClient.create(PROJECT_NAME, mockStub);

    Mockito.when(mockStub.createAppProfileCallable()).thenReturn(mockCreateAppProfileCallable);
    Mockito.when(mockStub.getAppProfileCallable()).thenReturn(mockGetAppProfileCallable);
    Mockito.when(mockStub.listAppProfilesPagedCallable()).thenReturn(mockListAppProfilesCallable);
    Mockito.when(mockStub.updateAppProfileOperationCallable())
        .thenReturn(mockUpdateAppProfileCallable);
    Mockito.when(mockStub.deleteAppProfileCallable()).thenReturn(mockDeleteAppProfileCallable);
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
  public void testCreateAppProfile() {
    // Setup
    com.google.bigtable.admin.v2.CreateAppProfileRequest expectedRequest =
        com.google.bigtable.admin.v2.CreateAppProfileRequest.newBuilder()
            .setParent(INSTANCE_NAME.toString())
            .setAppProfileId(APP_PROFILE_NAME.getAppProfile())
            .setAppProfile(
                com.google.bigtable.admin.v2.AppProfile.newBuilder()
                    .setDescription("my description")
                    .setMultiClusterRoutingUseAny(
                        com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny
                            .getDefaultInstance())
            )
            .build();

    com.google.bigtable.admin.v2.AppProfile expectedResponse =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName(APP_PROFILE_NAME.toString())
            .setDescription("my description")
            .setMultiClusterRoutingUseAny(
                com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny
                    .getDefaultInstance())
            .build();

    Mockito.when(mockCreateAppProfileCallable.futureCall(expectedRequest)).thenReturn(
        ApiFutures.immediateFuture(expectedResponse)
    );

    // Execute
    AppProfile actualResult = adminClient.createAppProfile(
        CreateAppProfileRequest.of(APP_PROFILE_NAME.getInstance(), APP_PROFILE_NAME.getAppProfile())
            .setDescription("my description")
            .setRoutingPolicy(MultiClusterRoutingPolicy.of())
    );

    // Verify
    Truth.assertThat(actualResult).isEqualTo(AppProfile.fromProto(expectedResponse));
  }

  @Test
  public void testGetAppProfile() {
    // Setup
    com.google.bigtable.admin.v2.GetAppProfileRequest expectedRequest =
        com.google.bigtable.admin.v2.GetAppProfileRequest.newBuilder()
            .setName(APP_PROFILE_NAME.toString())
            .build();

    com.google.bigtable.admin.v2.AppProfile expectedResponse =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName(APP_PROFILE_NAME.toString())
            .setDescription("my description")
            .setMultiClusterRoutingUseAny(
                com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny
                    .getDefaultInstance())
            .build();

    Mockito.when(mockGetAppProfileCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    AppProfile actualResult = adminClient
        .getAppProfile(APP_PROFILE_NAME.getInstance(), APP_PROFILE_NAME.getAppProfile());

    // Verify
    Truth.assertThat(actualResult).isEqualTo(AppProfile.fromProto(expectedResponse));
  }

  @Test
  public void testListAppProfiles() {
    // Setup
    com.google.bigtable.admin.v2.ListAppProfilesRequest expectedRequest =
        com.google.bigtable.admin.v2.ListAppProfilesRequest.newBuilder()
            .setParent(INSTANCE_NAME.toString())
            .build();

    // 3 AppProfiles spread across 2 pages
    List<com.google.bigtable.admin.v2.AppProfile> expectedProtos = Lists.newArrayList();
    for (int i = 0; i < 3; i++) {
      expectedProtos.add(
          com.google.bigtable.admin.v2.AppProfile.newBuilder()
              .setName(APP_PROFILE_NAME.toString() + i)
              .setDescription("profile" + i)
              .setMultiClusterRoutingUseAny(
                  com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny
                      .getDefaultInstance())
              .build());
    }
    // 2 on the first page
    ListAppProfilesPage page0 = Mockito.mock(ListAppProfilesPage.class);
    Mockito.when(page0.getValues()).thenReturn(expectedProtos.subList(0, 2));
    Mockito.when(page0.getNextPageToken()).thenReturn("next-page");
    Mockito.when(page0.hasNextPage()).thenReturn(true);

    // 1 on the last page
    ListAppProfilesPage page1 = Mockito.mock(ListAppProfilesPage.class);
    Mockito.when(page1.getValues()).thenReturn(expectedProtos.subList(2, 3));

    // Link page0 to page1
    Mockito.when(page0.getNextPageAsync()).thenReturn(
        ApiFutures.immediateFuture(page1)
    );

    // Link page to the response
    ListAppProfilesPagedResponse response0 = Mockito.mock(ListAppProfilesPagedResponse.class);
    Mockito.when(response0.getPage()).thenReturn(page0);

    Mockito.when(mockListAppProfilesCallable.futureCall(expectedRequest)).thenReturn(
        ApiFutures.immediateFuture(response0)
    );

    // Execute
    List<AppProfile> actualResults = adminClient.listAppProfiles(INSTANCE_NAME.getInstance());

    // Verify
    List<AppProfile> expectedResults = Lists.newArrayList();
    for (com.google.bigtable.admin.v2.AppProfile expectedProto : expectedProtos) {
      expectedResults.add(AppProfile.fromProto(expectedProto));
    }

    Truth.assertThat(actualResults).containsExactlyElementsIn(expectedResults);
  }

  @Test
  public void testUpdateAppProfile() {
    // Setup
    com.google.bigtable.admin.v2.UpdateAppProfileRequest expectedRequest =
        com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder()
            .setAppProfile(
                com.google.bigtable.admin.v2.AppProfile.newBuilder()
                    .setName(APP_PROFILE_NAME.toString())
                    .setDescription("updated description")
            )
            .setUpdateMask(FieldMask.newBuilder().addPaths("description"))
            .build();

    com.google.bigtable.admin.v2.AppProfile expectedResponse =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName(APP_PROFILE_NAME.toString())
            .setDescription("updated description")
            .setMultiClusterRoutingUseAny(MultiClusterRoutingUseAny.getDefaultInstance())
            .build();

    mockOperationResult(mockUpdateAppProfileCallable, expectedRequest, expectedResponse);

    // Execute
    AppProfile actualResult = adminClient.updateAppProfile(
        UpdateAppProfileRequest.of(APP_PROFILE_NAME.getInstance(), APP_PROFILE_NAME.getAppProfile())
            .setDescription("updated description")
    );

    // Verify
    Truth.assertThat(actualResult).isEqualTo(AppProfile.fromProto(expectedResponse));
  }

  @Test
  public void testDeleteAppProfile() {
    // Setup
    com.google.bigtable.admin.v2.DeleteAppProfileRequest expectedRequest =
        com.google.bigtable.admin.v2.DeleteAppProfileRequest.newBuilder()
            .setName(APP_PROFILE_NAME.toString())
            .build();

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockDeleteAppProfileCallable.futureCall(expectedRequest))
        .thenAnswer(new Answer<ApiFuture<Empty>>() {
          @Override
          public ApiFuture<Empty> answer(InvocationOnMock invocationOnMock) {
            wasCalled.set(true);
            return ApiFutures.immediateFuture(Empty.getDefaultInstance());
          }
        });

    // Execute
    adminClient.deleteAppProfile(APP_PROFILE_NAME.getInstance(), APP_PROFILE_NAME.getAppProfile());

    // Verify
    Truth.assertThat(wasCalled.get()).isTrue();
  }

  private <ReqT, RespT, MetaT> void mockOperationResult(
      OperationCallable<ReqT, RespT, MetaT> callable, ReqT request, RespT response) {
    OperationSnapshot operationSnapshot = FakeOperationSnapshot.newBuilder()
        .setDone(true)
        .setErrorCode(GrpcStatusCode.of(Code.OK))
        .setName("fake-name")
        .setResponse(response)
        .build();
    OperationFuture<RespT, MetaT> operationFuture = OperationFutures
        .immediateOperationFuture(operationSnapshot);
    Mockito.when(callable.futureCall(request)).thenReturn(operationFuture);
  }
}
