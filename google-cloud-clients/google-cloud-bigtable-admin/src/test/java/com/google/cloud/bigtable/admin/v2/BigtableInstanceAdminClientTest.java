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
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.LocationName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.StorageType;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.CreateClusterRequest;
import com.google.cloud.bigtable.admin.v2.models.PartialListClustersException;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.protobuf.Empty;
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
  private static final ClusterName CLUSTER_NAME =
      ClusterName.of(INSTANCE_NAME.getProject(), INSTANCE_NAME.getInstance(), "my-cluster");

  private BigtableInstanceAdminClient adminClient;

  @Mock
  private BigtableInstanceAdminStub mockStub;

  @Mock
  private OperationCallable<com.google.bigtable.admin.v2.CreateClusterRequest, com.google.bigtable.admin.v2.Cluster, com.google.bigtable.admin.v2.CreateClusterMetadata> mockCreateClusterCallable;
  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.GetClusterRequest, com.google.bigtable.admin.v2.Cluster> mockGetClusterCallable;
  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.ListClustersRequest, com.google.bigtable.admin.v2.ListClustersResponse> mockListClustersCallable;
  @Mock
  private OperationCallable<com.google.bigtable.admin.v2.Cluster, com.google.bigtable.admin.v2.Cluster, UpdateClusterMetadata> mockUpdateClusterCallable;
  @Mock
  private UnaryCallable<com.google.bigtable.admin.v2.DeleteClusterRequest, Empty> mockDeleteClusterCallable;

  @Before
  public void setUp() {
    adminClient = BigtableInstanceAdminClient
        .create(PROJECT_NAME, mockStub);

    Mockito.when(mockStub.createClusterOperationCallable()).thenReturn(mockCreateClusterCallable);
    Mockito.when(mockStub.getClusterCallable()).thenReturn(mockGetClusterCallable);
    Mockito.when(mockStub.listClustersCallable()).thenReturn(mockListClustersCallable);
    Mockito.when(mockStub.updateClusterOperationCallable()).thenReturn(mockUpdateClusterCallable);
    Mockito.when(mockStub.deleteClusterCallable()).thenReturn(mockDeleteClusterCallable);
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
  public void testCreateCluster() {
    // Setup
    com.google.bigtable.admin.v2.CreateClusterRequest expectedRequest =
        com.google.bigtable.admin.v2.CreateClusterRequest.newBuilder()
            .setParent(INSTANCE_NAME.toString())
            .setClusterId(CLUSTER_NAME.getCluster())
            .setCluster(
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setLocation("projects/my-project/locations/us-east1-c")
                    .setServeNodes(3)
                    .setDefaultStorageType(StorageType.SSD)
            )
            .build();
    com.google.bigtable.admin.v2.Cluster expectedResponse = com.google.bigtable.admin.v2.Cluster
        .newBuilder()
        .setName(CLUSTER_NAME.toString())
        .build();
    mockOperationResult(mockCreateClusterCallable, expectedRequest, expectedResponse);

    // Execute
    Cluster actualResult = adminClient.createCluster(
        CreateClusterRequest.of(CLUSTER_NAME.getInstance(), CLUSTER_NAME.getCluster())
            .setZone("us-east1-c")
            .setServeNodes(3)
            .setStorageType(StorageType.SSD)
    );
    // Verify
    assertThat(actualResult).isEqualTo(Cluster.fromProto(expectedResponse));
  }

  @Test
  public void testGetCluster() {
    // Setup
    com.google.bigtable.admin.v2.GetClusterRequest expectedRequest =
        com.google.bigtable.admin.v2.GetClusterRequest.newBuilder()
            .setName(CLUSTER_NAME.toString())
            .build();

    com.google.bigtable.admin.v2.Cluster expectedResponse = com.google.bigtable.admin.v2.Cluster
        .newBuilder()
        .setName(CLUSTER_NAME.toString())
        .build();

    Mockito.when(mockGetClusterCallable.futureCall(expectedRequest)).thenReturn(
        ApiFutures.immediateFuture(expectedResponse)
    );

    // Execute
    Cluster actualResult = adminClient
        .getCluster(CLUSTER_NAME.getInstance(), CLUSTER_NAME.getCluster());

    // Verify
    assertThat(actualResult).isEqualTo(Cluster.fromProto(expectedResponse));
  }

  @Test
  public void testListClusters() {
    // Setup
    com.google.bigtable.admin.v2.ListClustersRequest expectedRequest =
        com.google.bigtable.admin.v2.ListClustersRequest.newBuilder()
            .setParent(INSTANCE_NAME.toString())
            .build();

    com.google.bigtable.admin.v2.ListClustersResponse expectedResponse =
        com.google.bigtable.admin.v2.ListClustersResponse.newBuilder()
            .addClusters(
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setName(CLUSTER_NAME.toString() + "1")
            )
            .addClusters(
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setName(CLUSTER_NAME.toString() + "2")
            )
            .build();

    Mockito.when(mockListClustersCallable.futureCall(expectedRequest)).thenReturn(
        ApiFutures.immediateFuture(expectedResponse)
    );

    // Execute
    List<Cluster> actualResult = adminClient.listClusters(INSTANCE_NAME.getInstance());

    // Verify
    assertThat(actualResult).containsExactly(
        Cluster.fromProto(expectedResponse.getClusters(0)),
        Cluster.fromProto(expectedResponse.getClusters(1))
    );
  }

  @Test
  public void testListClustersFailedZone() {
    // Setup
    com.google.bigtable.admin.v2.ListClustersRequest expectedRequest =
        com.google.bigtable.admin.v2.ListClustersRequest.newBuilder()
            .setParent(INSTANCE_NAME.toString())
            .build();

    com.google.bigtable.admin.v2.ListClustersResponse expectedResponse =
        com.google.bigtable.admin.v2.ListClustersResponse.newBuilder()
            .addClusters(
                com.google.bigtable.admin.v2.Cluster.newBuilder()
                    .setName(CLUSTER_NAME.toString())
            )
            .addFailedLocations(
                LocationName.of(PROJECT_NAME.getProject(), "us-east1-c").toString()
            )
            .build();

    Mockito.when(mockListClustersCallable.futureCall(expectedRequest)).thenReturn(
        ApiFutures.immediateFuture(expectedResponse)
    );

    // Execute
    Exception actualError = null;

    try {
      adminClient.listClusters(INSTANCE_NAME.getInstance());
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
            .setName(CLUSTER_NAME.toString())
            .setServeNodes(30)
            .build();

    com.google.bigtable.admin.v2.Cluster expectedResponse =
        com.google.bigtable.admin.v2.Cluster.newBuilder()
            .setName(CLUSTER_NAME.toString())
            .setLocation(LocationName.of(PROJECT_NAME.getProject(), "us-east1-c").toString())
            .setServeNodes(30)
            .build();

    mockOperationResult(mockUpdateClusterCallable, expectedRequest, expectedResponse);

    // Execute
    Cluster actualResult = adminClient
        .resizeCluster(CLUSTER_NAME.getInstance(), CLUSTER_NAME.getCluster(), 30);

    // Verify
    assertThat(actualResult).isEqualTo(Cluster.fromProto(expectedResponse));
  }

  @Test
  public void testDeleteCluster() {
    // Setup
    com.google.bigtable.admin.v2.DeleteClusterRequest expectedRequest =
        com.google.bigtable.admin.v2.DeleteClusterRequest.newBuilder()
            .setName(CLUSTER_NAME.toString())
            .build();

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockDeleteClusterCallable.futureCall(expectedRequest))
        .thenAnswer(new Answer<ApiFuture<Empty>>() {
          @Override
          public ApiFuture<Empty> answer(InvocationOnMock invocationOnMock) {
            wasCalled.set(true);
            return ApiFutures.immediateFuture(Empty.getDefaultInstance());
          }
        });

    // Execute
    adminClient.deleteCluster(CLUSTER_NAME.getInstance(), CLUSTER_NAME.getCluster());

    // Verify
    assertThat(wasCalled.get()).isTrue();
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
