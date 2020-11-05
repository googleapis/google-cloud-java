/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.MigrationServiceClient.SearchMigratableResourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class MigrationServiceClientTest {
  private static MockDatasetService mockDatasetService;
  private static MockEndpointService mockEndpointService;
  private static MockJobService mockJobService;
  private static MockMigrationService mockMigrationService;
  private static MockModelService mockModelService;
  private static MockPipelineService mockPipelineService;
  private static MockPredictionService mockPredictionService;
  private static MockSpecialistPoolService mockSpecialistPoolService;
  private static MockServiceHelper serviceHelper;
  private MigrationServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDatasetService = new MockDatasetService();
    mockEndpointService = new MockEndpointService();
    mockJobService = new MockJobService();
    mockMigrationService = new MockMigrationService();
    mockModelService = new MockModelService();
    mockPipelineService = new MockPipelineService();
    mockPredictionService = new MockPredictionService();
    mockSpecialistPoolService = new MockSpecialistPoolService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockDatasetService,
                mockEndpointService,
                mockJobService,
                mockMigrationService,
                mockModelService,
                mockPipelineService,
                mockPredictionService,
                mockSpecialistPoolService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    MigrationServiceSettings settings =
        MigrationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MigrationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void searchMigratableResourcesTest() {
    String nextPageToken = "";
    MigratableResource migratableResourcesElement = MigratableResource.newBuilder().build();
    List<MigratableResource> migratableResources = Arrays.asList(migratableResourcesElement);
    SearchMigratableResourcesResponse expectedResponse =
        SearchMigratableResourcesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllMigratableResources(migratableResources)
            .build();
    mockMigrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchMigratableResourcesPagedResponse pagedListResponse =
        client.searchMigratableResources(parent);

    List<MigratableResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigratableResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMigratableResourcesRequest actualRequest =
        (SearchMigratableResourcesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchMigratableResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.searchMigratableResources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchMigrateResourcesTest() throws Exception {
    BatchMigrateResourcesResponse expectedResponse =
        BatchMigrateResourcesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchMigrateResourcesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMigrationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<MigrateResourceRequest> migrateResourceRequests = new ArrayList<>();

    BatchMigrateResourcesResponse actualResponse =
        client.batchMigrateResourcesAsync(parent, migrateResourceRequests).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchMigrateResourcesRequest actualRequest =
        (BatchMigrateResourcesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(migrateResourceRequests, actualRequest.getMigrateResourceRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchMigrateResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<MigrateResourceRequest> migrateResourceRequests = new ArrayList<>();

      client.batchMigrateResourcesAsync(parent, migrateResourceRequests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
