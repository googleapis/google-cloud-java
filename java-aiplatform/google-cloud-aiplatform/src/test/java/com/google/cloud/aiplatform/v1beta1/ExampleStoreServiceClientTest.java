/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.FetchExamplesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.ListExampleStoresPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class ExampleStoreServiceClientTest {
  private static MockExampleStoreService mockExampleStoreService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ExampleStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockExampleStoreService = new MockExampleStoreService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockExampleStoreService, mockLocations, mockIAMPolicy));
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
    ExampleStoreServiceSettings settings =
        ExampleStoreServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ExampleStoreServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createExampleStoreTest() throws Exception {
    ExampleStore expectedResponse =
        ExampleStore.newBuilder()
            .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExampleStoreConfig(ExampleStoreConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExampleStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockExampleStoreService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ExampleStore exampleStore = ExampleStore.newBuilder().build();

    ExampleStore actualResponse = client.createExampleStoreAsync(parent, exampleStore).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExampleStoreRequest actualRequest = ((CreateExampleStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exampleStore, actualRequest.getExampleStore());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExampleStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ExampleStore exampleStore = ExampleStore.newBuilder().build();
      client.createExampleStoreAsync(parent, exampleStore).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createExampleStoreTest2() throws Exception {
    ExampleStore expectedResponse =
        ExampleStore.newBuilder()
            .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExampleStoreConfig(ExampleStoreConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExampleStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockExampleStoreService.addResponse(resultOperation);

    String parent = "parent-995424086";
    ExampleStore exampleStore = ExampleStore.newBuilder().build();

    ExampleStore actualResponse = client.createExampleStoreAsync(parent, exampleStore).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExampleStoreRequest actualRequest = ((CreateExampleStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(exampleStore, actualRequest.getExampleStore());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExampleStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      ExampleStore exampleStore = ExampleStore.newBuilder().build();
      client.createExampleStoreAsync(parent, exampleStore).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getExampleStoreTest() throws Exception {
    ExampleStore expectedResponse =
        ExampleStore.newBuilder()
            .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExampleStoreConfig(ExampleStoreConfig.newBuilder().build())
            .build();
    mockExampleStoreService.addResponse(expectedResponse);

    ExampleStoreName name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]");

    ExampleStore actualResponse = client.getExampleStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleStoreRequest actualRequest = ((GetExampleStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExampleStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      ExampleStoreName name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]");
      client.getExampleStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExampleStoreTest2() throws Exception {
    ExampleStore expectedResponse =
        ExampleStore.newBuilder()
            .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExampleStoreConfig(ExampleStoreConfig.newBuilder().build())
            .build();
    mockExampleStoreService.addResponse(expectedResponse);

    String name = "name3373707";

    ExampleStore actualResponse = client.getExampleStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleStoreRequest actualRequest = ((GetExampleStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExampleStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getExampleStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExampleStoreTest() throws Exception {
    ExampleStore expectedResponse =
        ExampleStore.newBuilder()
            .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setExampleStoreConfig(ExampleStoreConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateExampleStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockExampleStoreService.addResponse(resultOperation);

    ExampleStore exampleStore = ExampleStore.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ExampleStore actualResponse = client.updateExampleStoreAsync(exampleStore, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExampleStoreRequest actualRequest = ((UpdateExampleStoreRequest) actualRequests.get(0));

    Assert.assertEquals(exampleStore, actualRequest.getExampleStore());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExampleStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      ExampleStore exampleStore = ExampleStore.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExampleStoreAsync(exampleStore, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExampleStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExampleStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockExampleStoreService.addResponse(resultOperation);

    ExampleStoreName name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]");

    client.deleteExampleStoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExampleStoreRequest actualRequest = ((DeleteExampleStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExampleStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      ExampleStoreName name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]");
      client.deleteExampleStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExampleStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExampleStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockExampleStoreService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteExampleStoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExampleStoreRequest actualRequest = ((DeleteExampleStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExampleStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExampleStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listExampleStoresTest() throws Exception {
    ExampleStore responsesElement = ExampleStore.newBuilder().build();
    ListExampleStoresResponse expectedResponse =
        ListExampleStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllExampleStores(Arrays.asList(responsesElement))
            .build();
    mockExampleStoreService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListExampleStoresPagedResponse pagedListResponse = client.listExampleStores(parent);

    List<ExampleStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExampleStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExampleStoresRequest actualRequest = ((ListExampleStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExampleStoresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listExampleStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExampleStoresTest2() throws Exception {
    ExampleStore responsesElement = ExampleStore.newBuilder().build();
    ListExampleStoresResponse expectedResponse =
        ListExampleStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllExampleStores(Arrays.asList(responsesElement))
            .build();
    mockExampleStoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExampleStoresPagedResponse pagedListResponse = client.listExampleStores(parent);

    List<ExampleStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExampleStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExampleStoresRequest actualRequest = ((ListExampleStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExampleStoresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExampleStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void upsertExamplesTest() throws Exception {
    UpsertExamplesResponse expectedResponse =
        UpsertExamplesResponse.newBuilder()
            .addAllResults(new ArrayList<UpsertExamplesResponse.UpsertResult>())
            .build();
    mockExampleStoreService.addResponse(expectedResponse);

    UpsertExamplesRequest request =
        UpsertExamplesRequest.newBuilder()
            .setExampleStore(
                ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .addAllExamples(new ArrayList<Example>())
            .setOverwrite(true)
            .build();

    UpsertExamplesResponse actualResponse = client.upsertExamples(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpsertExamplesRequest actualRequest = ((UpsertExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getExampleStore(), actualRequest.getExampleStore());
    Assert.assertEquals(request.getExamplesList(), actualRequest.getExamplesList());
    Assert.assertEquals(request.getOverwrite(), actualRequest.getOverwrite());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upsertExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      UpsertExamplesRequest request =
          UpsertExamplesRequest.newBuilder()
              .setExampleStore(
                  ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
              .addAllExamples(new ArrayList<Example>())
              .setOverwrite(true)
              .build();
      client.upsertExamples(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeExamplesTest() throws Exception {
    RemoveExamplesResponse expectedResponse =
        RemoveExamplesResponse.newBuilder().addAllExampleIds(new ArrayList<String>()).build();
    mockExampleStoreService.addResponse(expectedResponse);

    RemoveExamplesRequest request =
        RemoveExamplesRequest.newBuilder()
            .setExampleStore(
                ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .addAllExampleIds(new ArrayList<String>())
            .build();

    RemoveExamplesResponse actualResponse = client.removeExamples(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveExamplesRequest actualRequest = ((RemoveExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(
        request.getStoredContentsExampleFilter(), actualRequest.getStoredContentsExampleFilter());
    Assert.assertEquals(request.getExampleStore(), actualRequest.getExampleStore());
    Assert.assertEquals(request.getExampleIdsList(), actualRequest.getExampleIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      RemoveExamplesRequest request =
          RemoveExamplesRequest.newBuilder()
              .setExampleStore(
                  ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
              .addAllExampleIds(new ArrayList<String>())
              .build();
      client.removeExamples(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchExamplesTest() throws Exception {
    SearchExamplesResponse expectedResponse =
        SearchExamplesResponse.newBuilder()
            .addAllResults(new ArrayList<SearchExamplesResponse.SimilarExample>())
            .build();
    mockExampleStoreService.addResponse(expectedResponse);

    SearchExamplesRequest request =
        SearchExamplesRequest.newBuilder()
            .setExampleStore(
                ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .setTopK(110545921)
            .build();

    SearchExamplesResponse actualResponse = client.searchExamples(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchExamplesRequest actualRequest = ((SearchExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(
        request.getStoredContentsExampleParameters(),
        actualRequest.getStoredContentsExampleParameters());
    Assert.assertEquals(request.getExampleStore(), actualRequest.getExampleStore());
    Assert.assertEquals(request.getTopK(), actualRequest.getTopK());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      SearchExamplesRequest request =
          SearchExamplesRequest.newBuilder()
              .setExampleStore(
                  ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
              .setTopK(110545921)
              .build();
      client.searchExamples(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchExamplesTest() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    FetchExamplesResponse expectedResponse =
        FetchExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
            .build();
    mockExampleStoreService.addResponse(expectedResponse);

    FetchExamplesRequest request =
        FetchExamplesRequest.newBuilder()
            .setExampleStore(
                ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .addAllExampleIds(new ArrayList<String>())
            .build();

    FetchExamplesPagedResponse pagedListResponse = client.fetchExamples(request);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockExampleStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchExamplesRequest actualRequest = ((FetchExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(
        request.getStoredContentsExampleFilter(), actualRequest.getStoredContentsExampleFilter());
    Assert.assertEquals(request.getExampleStore(), actualRequest.getExampleStore());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getExampleIdsList(), actualRequest.getExampleIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockExampleStoreService.addException(exception);

    try {
      FetchExamplesRequest request =
          FetchExamplesRequest.newBuilder()
              .setExampleStore(
                  ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .addAllExampleIds(new ArrayList<String>())
              .build();
      client.fetchExamples(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
