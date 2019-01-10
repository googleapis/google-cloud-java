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
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.testing.FakeOperationSnapshot;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.admin.v2.models.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.MultiClusterRoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.CreateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateClusterRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.PartialListClustersException;
import com.google.cloud.bigtable.admin.v2.models.PartialListInstancesException;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import com.google.cloud.bigtable.admin.v2.models.UpdateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class BigtableInstanceAdminClientTest {

  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String CLUSTER_ID = "my-cluster";
  private static final String APP_PROFILE_ID = "my-app-profile";

  private static final String PROJECT_NAME = NameUtil.formatProjectName(PROJECT_ID);
  private static final String INSTANCE_NAME = NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID);
  private static final String CLUSTER_NAME =
      NameUtil.formatClusterName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID);
  private static final String APP_PROFILE_NAME =
      NameUtil.formatAppProfileName(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID);

  private BigtableInstanceAdminClient adminClient;

  @Mock private BigtableInstanceAdminStub mockStub;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.CreateInstanceRequest,
          com.google.bigtable.admin.v2.Instance,
          CreateInstanceMetadata>
      mockCreateInstanceCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
          com.google.bigtable.admin.v2.Instance,
          UpdateInstanceMetadata>
      mockUpdateInstanceCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.GetInstanceRequest, com.google.bigtable.admin.v2.Instance>
      mockGetInstanceCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.ListInstancesRequest,
          com.google.bigtable.admin.v2.ListInstancesResponse>
      mockListInstancesCallable;

  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.DeleteInstanceRequest, Empty>
      mockDeleteInstanceCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.CreateClusterRequest,
          com.google.bigtable.admin.v2.Cluster,
          com.google.bigtable.admin.v2.CreateClusterMetadata>
      mockCreateClusterCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.GetClusterRequest, com.google.bigtable.admin.v2.Cluster>
      mockGetClusterCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.ListClustersRequest,
          com.google.bigtable.admin.v2.ListClustersResponse>
      mockListClustersCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.Cluster,
          com.google.bigtable.admin.v2.Cluster,
          UpdateClusterMetadata>
      mockUpdateClusterCallable;

  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.DeleteClusterRequest, Empty>
      mockDeleteClusterCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.CreateAppProfileRequest,
          com.google.bigtable.admin.v2.AppProfile>
      mockCreateAppProfileCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.GetAppProfileRequest,
          com.google.bigtable.admin.v2.AppProfile>
      mockGetAppProfileCallable;

  @Mock
  private UnaryCallable<
          com.google.bigtable.admin.v2.ListAppProfilesRequest, ListAppProfilesPagedResponse>
      mockListAppProfilesCallable;

  @Mock
  private OperationCallable<
          com.google.bigtable.admin.v2.UpdateAppProfileRequest,
          com.google.bigtable.admin.v2.AppProfile,
          com.google.bigtable.admin.v2.UpdateAppProfileMetadata>
      mockUpdateAppProfileCallable;

  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.DeleteAppProfileRequest, Empty>
      mockDeleteAppProfileCallable;

  @Mock
  private UnaryCallable<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      mockGetIamPolicyCallable;

  @Mock
  private UnaryCallable<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      mockSetIamPolicyCallable;

  @Mock
  private UnaryCallable<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      mockTestIamPermissionsCallable;

  @Before
  public void setUp() {
    adminClient = BigtableInstanceAdminClient.create(PROJECT_ID, mockStub);

    Mockito.when(mockStub.createInstanceOperationCallable()).thenReturn(mockCreateInstanceCallable);
    Mockito.when(mockStub.partialUpdateInstanceOperationCallable())
        .thenReturn(mockUpdateInstanceCallable);
    Mockito.when(mockStub.getInstanceCallable()).thenReturn(mockGetInstanceCallable);
    Mockito.when(mockStub.listInstancesCallable()).thenReturn(mockListInstancesCallable);
    Mockito.when(mockStub.deleteInstanceCallable()).thenReturn(mockDeleteInstanceCallable);

    Mockito.when(mockStub.createClusterOperationCallable()).thenReturn(mockCreateClusterCallable);
    Mockito.when(mockStub.getClusterCallable()).thenReturn(mockGetClusterCallable);
    Mockito.when(mockStub.listClustersCallable()).thenReturn(mockListClustersCallable);
    Mockito.when(mockStub.updateClusterOperationCallable()).thenReturn(mockUpdateClusterCallable);
    Mockito.when(mockStub.deleteClusterCallable()).thenReturn(mockDeleteClusterCallable);

    Mockito.when(mockStub.createAppProfileCallable()).thenReturn(mockCreateAppProfileCallable);
    Mockito.when(mockStub.getAppProfileCallable()).thenReturn(mockGetAppProfileCallable);
    Mockito.when(mockStub.listAppProfilesPagedCallable()).thenReturn(mockListAppProfilesCallable);
    Mockito.when(mockStub.updateAppProfileOperationCallable())
        .thenReturn(mockUpdateAppProfileCallable);
    Mockito.when(mockStub.deleteAppProfileCallable()).thenReturn(mockDeleteAppProfileCallable);

    Mockito.when(mockStub.getIamPolicyCallable()).thenReturn(mockGetIamPolicyCallable);
    Mockito.when(mockStub.setIamPolicyCallable()).thenReturn(mockSetIamPolicyCallable);
    Mockito.when(mockStub.testIamPermissionsCallable()).thenReturn(mockTestIamPermissionsCallable);
  }

  @Test
  public void testProjectName() {
    assertThat(adminClient.getProjectId()).isEqualTo(PROJECT_ID);
  }

  @Test
  public void testClose() {
    adminClient.close();
    Mockito.verify(mockStub).close();
  }

  @Test
  public void testCreateInstance() {
    // Setup
    com.google.bigtable.admin.v2.CreateInstanceRequest expectedRequest =
        com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder()
            .setParent(PROJECT_NAME)
            .setInstanceId(INSTANCE_ID)
            .setInstance(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setType(com.google.bigtable.admin.v2.Instance.Type.DEVELOPMENT)
                    .setDisplayName(INSTANCE_ID))
            .putClusters(
                "cluster1",
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(1)
                    .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD)
                    .build())
            .build();

    com.google.bigtable.admin.v2.Instance expectedResponse =
        com.google.bigtable.admin.v2.Instance.newBuilder().setName(INSTANCE_NAME).build();

    mockOperationResult(mockCreateInstanceCallable, expectedRequest, expectedResponse);

    // Execute
    Instance actualResult =
        adminClient.createInstance(
            CreateInstanceRequest.of(INSTANCE_ID)
                .setType(Instance.Type.DEVELOPMENT)
                .addCluster("cluster1", "us-east1-c", 1, StorageType.SSD));

    // Verify
    assertThat(actualResult).isEqualTo(Instance.fromProto(expectedResponse));
  }

  @Test
  public void testUpdateInstance() {
    // Setup
    com.google.bigtable.admin.v2.PartialUpdateInstanceRequest expectedRequest =
        com.google.bigtable.admin.v2.PartialUpdateInstanceRequest.newBuilder()
            .setUpdateMask(FieldMask.newBuilder().addPaths("display_name"))
            .setInstance(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setName(INSTANCE_NAME)
                    .setDisplayName("new display name"))
            .build();

    com.google.bigtable.admin.v2.Instance expectedResponse =
        com.google.bigtable.admin.v2.Instance.newBuilder().setName(INSTANCE_NAME).build();

    mockOperationResult(mockUpdateInstanceCallable, expectedRequest, expectedResponse);

    // Execute
    Instance actualResult =
        adminClient.updateInstance(
            UpdateInstanceRequest.of(INSTANCE_ID).setDisplayName("new display name"));

    // Verify
    assertThat(actualResult).isEqualTo(Instance.fromProto(expectedResponse));
  }

  @Test
  public void testGetInstance() {
    // Setup
    com.google.bigtable.admin.v2.GetInstanceRequest expectedRequest =
        com.google.bigtable.admin.v2.GetInstanceRequest.newBuilder().setName(INSTANCE_NAME).build();

    com.google.bigtable.admin.v2.Instance expectedResponse =
        com.google.bigtable.admin.v2.Instance.newBuilder().setName(INSTANCE_NAME).build();

    Mockito.when(mockGetInstanceCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Instance actualResult = adminClient.getInstance(INSTANCE_ID);

    // Verify
    assertThat(actualResult).isEqualTo(Instance.fromProto(expectedResponse));
  }

  @Test
  public void testListInstances() {
    // Setup
    com.google.bigtable.admin.v2.ListInstancesRequest expectedRequest =
        com.google.bigtable.admin.v2.ListInstancesRequest.newBuilder()
            .setParent(PROJECT_NAME)
            .build();

    com.google.bigtable.admin.v2.ListInstancesResponse expectedResponse =
        com.google.bigtable.admin.v2.ListInstancesResponse.newBuilder()
            .addInstances(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setName(INSTANCE_NAME + "1")
                    .build())
            .addInstances(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setName(INSTANCE_NAME + "2")
                    .build())
            .build();

    Mockito.when(mockListInstancesCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    List<Instance> actualResult = adminClient.listInstances();

    // Verify
    assertThat(actualResult)
        .containsExactly(
            Instance.fromProto(expectedResponse.getInstances(0)),
            Instance.fromProto(expectedResponse.getInstances(1)));
  }

  @Test
  public void testListInstancesFailedZone() {
    // Setup
    com.google.bigtable.admin.v2.ListInstancesRequest expectedRequest =
        com.google.bigtable.admin.v2.ListInstancesRequest.newBuilder()
            .setParent(PROJECT_NAME)
            .build();

    com.google.bigtable.admin.v2.ListInstancesResponse expectedResponse =
        com.google.bigtable.admin.v2.ListInstancesResponse.newBuilder()
            .addInstances(
                com.google.bigtable.admin.v2.Instance.newBuilder()
                    .setName(INSTANCE_NAME + "1")
                    .build())
            .addFailedLocations(NameUtil.formatLocationName(PROJECT_ID, "us-east1-d"))
            .build();

    Mockito.when(mockListInstancesCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Exception actualError = null;

    try {
      adminClient.listInstances();
    } catch (Exception e) {
      actualError = e;
    }

    // Verify
    assertThat(actualError).isInstanceOf(PartialListInstancesException.class);
    assert actualError != null;
    PartialListInstancesException partialListError = (PartialListInstancesException) actualError;

    assertThat(partialListError.getInstances())
        .containsExactly(Instance.fromProto(expectedResponse.getInstances(0)));
    assertThat(partialListError.getUnavailableZones()).containsExactly("us-east1-d");
  }

  @Test
  public void testDeleteInstance() {
    // Setup
    com.google.bigtable.admin.v2.DeleteInstanceRequest expectedRequest =
        com.google.bigtable.admin.v2.DeleteInstanceRequest.newBuilder()
            .setName(INSTANCE_NAME)
            .build();

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockDeleteInstanceCallable.futureCall(expectedRequest))
        .thenAnswer(
            new Answer<ApiFuture<Empty>>() {
              @Override
              public ApiFuture<Empty> answer(InvocationOnMock invocationOnMock) {
                wasCalled.set(true);
                return ApiFutures.immediateFuture(Empty.getDefaultInstance());
              }
            });

    // Execute
    adminClient.deleteInstance(INSTANCE_ID);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testCreateCluster() {
    // Setup
    com.google.bigtable.admin.v2.CreateClusterRequest expectedRequest =
        com.google.bigtable.admin.v2.CreateClusterRequest.newBuilder()
            .setParent(INSTANCE_NAME)
            .setClusterId(CLUSTER_ID)
            .setCluster(
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(3)
                    .setDefaultStorageType(com.google.bigtable.admin.v2.StorageType.SSD))
            .build();
    com.google.bigtable.admin.v2.Cluster expectedResponse =
        com.google.bigtable.admin.v2.Cluster.newBuilder().setName(CLUSTER_NAME).build();
    mockOperationResult(mockCreateClusterCallable, expectedRequest, expectedResponse);

    // Execute
    Cluster actualResult =
        adminClient.createCluster(
            CreateClusterRequest.of(INSTANCE_ID, CLUSTER_ID)
                .setZone("us-east1-c")
                .setServeNodes(3)
                .setStorageType(StorageType.SSD));
    // Verify
    assertThat(actualResult).isEqualTo(Cluster.fromProto(expectedResponse));
  }

  @Test
  public void testGetCluster() {
    // Setup
    com.google.bigtable.admin.v2.GetClusterRequest expectedRequest =
        com.google.bigtable.admin.v2.GetClusterRequest.newBuilder().setName(CLUSTER_NAME).build();

    com.google.bigtable.admin.v2.Cluster expectedResponse =
        com.google.bigtable.admin.v2.Cluster.newBuilder().setName(CLUSTER_NAME).build();

    Mockito.when(mockGetClusterCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Cluster actualResult = adminClient.getCluster(INSTANCE_ID, CLUSTER_ID);

    // Verify
    assertThat(actualResult).isEqualTo(Cluster.fromProto(expectedResponse));
  }

  @Test
  public void testListClusters() {
    // Setup
    com.google.bigtable.admin.v2.ListClustersRequest expectedRequest =
        com.google.bigtable.admin.v2.ListClustersRequest.newBuilder()
            .setParent(INSTANCE_NAME)
            .build();

    com.google.bigtable.admin.v2.ListClustersResponse expectedResponse =
        com.google.bigtable.admin.v2.ListClustersResponse.newBuilder()
            .addClusters(
                com.google.bigtable.admin.v2.Cluster.newBuilder().setName(CLUSTER_NAME + "1"))
            .addClusters(
                com.google.bigtable.admin.v2.Cluster.newBuilder().setName(CLUSTER_NAME + "2"))
            .build();

    Mockito.when(mockListClustersCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    List<Cluster> actualResult = adminClient.listClusters(INSTANCE_ID);

    // Verify
    assertThat(actualResult)
        .containsExactly(
            Cluster.fromProto(expectedResponse.getClusters(0)),
            Cluster.fromProto(expectedResponse.getClusters(1)));
  }

  @Test
  public void testListClustersFailedZone() {
    // Setup
    com.google.bigtable.admin.v2.ListClustersRequest expectedRequest =
        com.google.bigtable.admin.v2.ListClustersRequest.newBuilder()
            .setParent(INSTANCE_NAME)
            .build();

    com.google.bigtable.admin.v2.ListClustersResponse expectedResponse =
        com.google.bigtable.admin.v2.ListClustersResponse.newBuilder()
            .addClusters(com.google.bigtable.admin.v2.Cluster.newBuilder().setName(CLUSTER_NAME))
            .addFailedLocations(NameUtil.formatLocationName(PROJECT_ID, "us-east1-c"))
            .build();

    Mockito.when(mockListClustersCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Exception actualError = null;

    try {
      adminClient.listClusters(INSTANCE_ID);
    } catch (Exception e) {
      actualError = e;
    }

    // Verify
    assertThat(actualError).isInstanceOf(PartialListClustersException.class);
    assert actualError != null;
    PartialListClustersException partialListError = (PartialListClustersException) actualError;
    assertThat(partialListError.getClusters())
        .containsExactly(Cluster.fromProto(expectedResponse.getClusters(0)));
    assertThat(partialListError.getUnavailableZones()).containsExactly("us-east1-c");
  }

  @Test
  public void testResizeCluster() {
    // Setup
    com.google.bigtable.admin.v2.Cluster expectedRequest =
        com.google.bigtable.admin.v2.Cluster.newBuilder()
            .setName(CLUSTER_NAME)
            .setServeNodes(30)
            .build();

    com.google.bigtable.admin.v2.Cluster expectedResponse =
        com.google.bigtable.admin.v2.Cluster.newBuilder()
            .setName(CLUSTER_NAME)
            .setLocation(NameUtil.formatLocationName(PROJECT_ID, "us-east1-c"))
            .setServeNodes(30)
            .build();

    mockOperationResult(mockUpdateClusterCallable, expectedRequest, expectedResponse);

    // Execute
    Cluster actualResult = adminClient.resizeCluster(INSTANCE_ID, CLUSTER_ID, 30);

    // Verify
    assertThat(actualResult).isEqualTo(Cluster.fromProto(expectedResponse));
  }

  @Test
  public void testDeleteCluster() {
    // Setup
    com.google.bigtable.admin.v2.DeleteClusterRequest expectedRequest =
        com.google.bigtable.admin.v2.DeleteClusterRequest.newBuilder()
            .setName(CLUSTER_NAME)
            .build();

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockDeleteClusterCallable.futureCall(expectedRequest))
        .thenAnswer(
            new Answer<ApiFuture<Empty>>() {
              @Override
              public ApiFuture<Empty> answer(InvocationOnMock invocationOnMock) {
                wasCalled.set(true);
                return ApiFutures.immediateFuture(Empty.getDefaultInstance());
              }
            });

    // Execute
    adminClient.deleteCluster(INSTANCE_ID, CLUSTER_ID);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testCreateAppProfile() {
    // Setup
    com.google.bigtable.admin.v2.CreateAppProfileRequest expectedRequest =
        com.google.bigtable.admin.v2.CreateAppProfileRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .setAppProfileId(APP_PROFILE_ID)
            .setAppProfile(
                com.google.bigtable.admin.v2.AppProfile.newBuilder()
                    .setDescription("my description")
                    .setMultiClusterRoutingUseAny(
                        com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny
                            .getDefaultInstance()))
            .build();

    com.google.bigtable.admin.v2.AppProfile expectedResponse =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName(APP_PROFILE_NAME)
            .setDescription("my description")
            .setMultiClusterRoutingUseAny(
                com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny
                    .getDefaultInstance())
            .build();

    Mockito.when(mockCreateAppProfileCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    AppProfile actualResult =
        adminClient.createAppProfile(
            CreateAppProfileRequest.of(INSTANCE_ID, APP_PROFILE_ID)
                .setDescription("my description")
                .setRoutingPolicy(MultiClusterRoutingPolicy.of()));

    // Verify
    assertThat(actualResult).isEqualTo(AppProfile.fromProto(expectedResponse));
  }

  @Test
  public void testGetAppProfile() {
    // Setup
    com.google.bigtable.admin.v2.GetAppProfileRequest expectedRequest =
        com.google.bigtable.admin.v2.GetAppProfileRequest.newBuilder()
            .setName(APP_PROFILE_NAME)
            .build();

    com.google.bigtable.admin.v2.AppProfile expectedResponse =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName(APP_PROFILE_NAME)
            .setDescription("my description")
            .setMultiClusterRoutingUseAny(
                com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny
                    .getDefaultInstance())
            .build();

    Mockito.when(mockGetAppProfileCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    AppProfile actualResult = adminClient.getAppProfile(INSTANCE_ID, APP_PROFILE_ID);

    // Verify
    assertThat(actualResult).isEqualTo(AppProfile.fromProto(expectedResponse));
  }

  @Test
  public void testListAppProfiles() {
    // Setup
    com.google.bigtable.admin.v2.ListAppProfilesRequest expectedRequest =
        com.google.bigtable.admin.v2.ListAppProfilesRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .build();

    // 3 AppProfiles spread across 2 pages
    List<com.google.bigtable.admin.v2.AppProfile> expectedProtos = Lists.newArrayList();
    for (int i = 0; i < 3; i++) {
      expectedProtos.add(
          com.google.bigtable.admin.v2.AppProfile.newBuilder()
              .setName(APP_PROFILE_NAME + i)
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
    Mockito.when(page0.getNextPageAsync()).thenReturn(ApiFutures.immediateFuture(page1));

    // Link page to the response
    ListAppProfilesPagedResponse response0 = Mockito.mock(ListAppProfilesPagedResponse.class);
    Mockito.when(response0.getPage()).thenReturn(page0);

    Mockito.when(mockListAppProfilesCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(response0));

    // Execute
    List<AppProfile> actualResults = adminClient.listAppProfiles(INSTANCE_ID);

    // Verify
    List<AppProfile> expectedResults = Lists.newArrayList();
    for (com.google.bigtable.admin.v2.AppProfile expectedProto : expectedProtos) {
      expectedResults.add(AppProfile.fromProto(expectedProto));
    }

    assertThat(actualResults).containsExactlyElementsIn(expectedResults);
  }

  @Test
  public void testUpdateAppProfile() {
    // Setup
    com.google.bigtable.admin.v2.UpdateAppProfileRequest expectedRequest =
        com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder()
            .setAppProfile(
                com.google.bigtable.admin.v2.AppProfile.newBuilder()
                    .setName(APP_PROFILE_NAME)
                    .setDescription("updated description"))
            .setUpdateMask(FieldMask.newBuilder().addPaths("description"))
            .build();

    com.google.bigtable.admin.v2.AppProfile expectedResponse =
        com.google.bigtable.admin.v2.AppProfile.newBuilder()
            .setName(APP_PROFILE_NAME)
            .setDescription("updated description")
            .setMultiClusterRoutingUseAny(
                com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny
                    .getDefaultInstance())
            .build();

    mockOperationResult(mockUpdateAppProfileCallable, expectedRequest, expectedResponse);

    // Execute
    AppProfile actualResult =
        adminClient.updateAppProfile(
            UpdateAppProfileRequest.of(INSTANCE_ID, APP_PROFILE_ID)
                .setDescription("updated description"));

    // Verify
    assertThat(actualResult).isEqualTo(AppProfile.fromProto(expectedResponse));
  }

  @Test
  public void testDeleteAppProfile() {
    // Setup
    com.google.bigtable.admin.v2.DeleteAppProfileRequest expectedRequest =
        com.google.bigtable.admin.v2.DeleteAppProfileRequest.newBuilder()
            .setName(APP_PROFILE_NAME)
            .build();

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockDeleteAppProfileCallable.futureCall(expectedRequest))
        .thenAnswer(
            new Answer<ApiFuture<Empty>>() {
              @Override
              public ApiFuture<Empty> answer(InvocationOnMock invocationOnMock) {
                wasCalled.set(true);
                return ApiFutures.immediateFuture(Empty.getDefaultInstance());
              }
            });

    // Execute
    adminClient.deleteAppProfile(INSTANCE_ID, APP_PROFILE_ID);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  private <ReqT, RespT, MetaT> void mockOperationResult(
      OperationCallable<ReqT, RespT, MetaT> callable, ReqT request, RespT response) {
    OperationSnapshot operationSnapshot =
        FakeOperationSnapshot.newBuilder()
            .setDone(true)
            .setErrorCode(GrpcStatusCode.of(Code.OK))
            .setName("fake-name")
            .setResponse(response)
            .build();
    OperationFuture<RespT, MetaT> operationFuture =
        OperationFutures.immediateOperationFuture(operationSnapshot);
    Mockito.when(callable.futureCall(request)).thenReturn(operationFuture);
  }

  @Test
  public void testGetIamPolicy() {
    // Setup
    com.google.iam.v1.GetIamPolicyRequest expectedRequest =
        com.google.iam.v1.GetIamPolicyRequest.newBuilder()
            .setResource(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .build();

    com.google.iam.v1.Policy expectedResponse =
        com.google.iam.v1.Policy.newBuilder()
            .addBindings(
                com.google.iam.v1.Binding.newBuilder()
                    .setRole("roles/bigtable.user")
                    .addMembers("user:someone@example.com"))
            .setEtag(ByteString.copyFromUtf8("my-etag"))
            .build();

    Mockito.when(mockGetIamPolicyCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Policy actualResult = adminClient.getIamPolicy(INSTANCE_ID);

    // Verify
    assertThat(actualResult)
        .isEqualTo(
            Policy.newBuilder()
                .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
                .setEtag(BaseEncoding.base64().encode("my-etag".getBytes()))
                .build());
  }

  @Test
  public void testSetIamPolicy() {
    // Setup
    com.google.iam.v1.SetIamPolicyRequest expectedRequest =
        com.google.iam.v1.SetIamPolicyRequest.newBuilder()
            .setResource(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .setPolicy(
                com.google.iam.v1.Policy.newBuilder()
                    .addBindings(
                        com.google.iam.v1.Binding.newBuilder()
                            .setRole("roles/bigtable.user")
                            .addMembers("user:someone@example.com")))
            .build();

    com.google.iam.v1.Policy expectedResponse =
        com.google.iam.v1.Policy.newBuilder()
            .addBindings(
                com.google.iam.v1.Binding.newBuilder()
                    .setRole("roles/bigtable.user")
                    .addMembers("user:someone@example.com"))
            .setEtag(ByteString.copyFromUtf8("my-etag"))
            .build();

    Mockito.when(mockSetIamPolicyCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    Policy actualResult =
        adminClient.setIamPolicy(
            INSTANCE_ID,
            Policy.newBuilder()
                .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
                .build());

    // Verify
    assertThat(actualResult)
        .isEqualTo(
            Policy.newBuilder()
                .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
                .setEtag(BaseEncoding.base64().encode("my-etag".getBytes()))
                .build());
  }

  @Test
  public void testTestIamPermissions() {
    // Setup
    com.google.iam.v1.TestIamPermissionsRequest expectedRequest =
        com.google.iam.v1.TestIamPermissionsRequest.newBuilder()
            .setResource(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .addPermissions("bigtable.tables.readRows")
            .build();

    com.google.iam.v1.TestIamPermissionsResponse expectedResponse =
        com.google.iam.v1.TestIamPermissionsResponse.newBuilder()
            .addPermissions("bigtable.tables.readRows")
            .build();

    Mockito.when(mockTestIamPermissionsCallable.futureCall(expectedRequest))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    List<String> actualResult =
        adminClient.testIamPermission(INSTANCE_ID, "bigtable.tables.readRows");

    // Verify
    assertThat(actualResult).containsExactly("bigtable.tables.readRows");
  }

  @Test
  public void testExistsTrue() {
    // Setup
    com.google.bigtable.admin.v2.Instance expectedResponse =
        com.google.bigtable.admin.v2.Instance.newBuilder()
            .setName(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .build();

    Mockito.when(mockGetInstanceCallable.futureCall(Matchers.any(GetInstanceRequest.class)))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    // Execute
    boolean found = adminClient.exists(INSTANCE_ID);

    // Verify
    assertThat(found).isTrue();
  }

  @Test
  public void testExistsFalse() {
    // Setup
    NotFoundException exception =
        new NotFoundException("fake-error", null, GrpcStatusCode.of(Status.Code.NOT_FOUND), false);

    Mockito.when(mockGetInstanceCallable.futureCall(Matchers.any(GetInstanceRequest.class)))
        .thenReturn(
            ApiFutures.<com.google.bigtable.admin.v2.Instance>immediateFailedFuture(exception));

    // Execute
    boolean found = adminClient.exists(INSTANCE_ID);

    // Verify
    assertThat(found).isFalse();
  }
}
