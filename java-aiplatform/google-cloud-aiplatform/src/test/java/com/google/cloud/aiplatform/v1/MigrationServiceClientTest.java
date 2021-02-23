/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.MigrationServiceClient.SearchMigratableResourcesPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MigrationServiceClientTest {
  private static MockMigrationService mockMigrationService;
  private static MockServiceHelper mockServiceHelper;
  private MigrationServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockMigrationService = new MockMigrationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMigrationService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
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
  public void searchMigratableResourcesTest() throws Exception {
    MigratableResource responsesElement = MigratableResource.newBuilder().build();
    SearchMigratableResourcesResponse expectedResponse =
        SearchMigratableResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigratableResources(Arrays.asList(responsesElement))
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
        ((SearchMigratableResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchMigratableResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.searchMigratableResources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchMigratableResourcesTest2() throws Exception {
    MigratableResource responsesElement = MigratableResource.newBuilder().build();
    SearchMigratableResourcesResponse expectedResponse =
        SearchMigratableResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigratableResources(Arrays.asList(responsesElement))
            .build();
    mockMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SearchMigratableResourcesPagedResponse pagedListResponse =
        client.searchMigratableResources(parent);

    List<MigratableResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigratableResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMigratableResourcesRequest actualRequest =
        ((SearchMigratableResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchMigratableResourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.searchMigratableResources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchMigrateResourcesTest() throws Exception {
    BatchMigrateResourcesResponse expectedResponse =
        BatchMigrateResourcesResponse.newBuilder()
            .addAllMigrateResourceResponses(new ArrayList<MigrateResourceResponse>())
            .build();
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
        ((BatchMigrateResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(migrateResourceRequests, actualRequest.getMigrateResourceRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchMigrateResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<MigrateResourceRequest> migrateResourceRequests = new ArrayList<>();
      client.batchMigrateResourcesAsync(parent, migrateResourceRequests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchMigrateResourcesTest2() throws Exception {
    BatchMigrateResourcesResponse expectedResponse =
        BatchMigrateResourcesResponse.newBuilder()
            .addAllMigrateResourceResponses(new ArrayList<MigrateResourceResponse>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchMigrateResourcesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMigrationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<MigrateResourceRequest> migrateResourceRequests = new ArrayList<>();

    BatchMigrateResourcesResponse actualResponse =
        client.batchMigrateResourcesAsync(parent, migrateResourceRequests).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchMigrateResourcesRequest actualRequest =
        ((BatchMigrateResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(migrateResourceRequests, actualRequest.getMigrateResourceRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchMigrateResourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<MigrateResourceRequest> migrateResourceRequests = new ArrayList<>();
      client.batchMigrateResourcesAsync(parent, migrateResourceRequests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
