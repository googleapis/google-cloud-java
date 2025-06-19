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

import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListMemoriesPagedResponse;

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
public class MemoryBankServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockMemoryBankService mockMemoryBankService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MemoryBankServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMemoryBankService = new MockMemoryBankService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMemoryBankService, mockLocations, mockIAMPolicy));
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
    MemoryBankServiceSettings settings =
        MemoryBankServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MemoryBankServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createMemoryTest() throws Exception {
    Memory expectedResponse =
        Memory.newBuilder()
            .setName(
                MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFact("fact3135084")
            .putAllScope(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMemoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemoryBankService.addResponse(resultOperation);

    CreateMemoryRequest request =
        CreateMemoryRequest.newBuilder()
            .setParent(
                ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]").toString())
            .setMemory(Memory.newBuilder().build())
            .build();

    Memory actualResponse = client.createMemoryAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMemoryRequest actualRequest = ((CreateMemoryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getMemory(), actualRequest.getMemory());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMemoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      CreateMemoryRequest request =
          CreateMemoryRequest.newBuilder()
              .setParent(
                  ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
                      .toString())
              .setMemory(Memory.newBuilder().build())
              .build();
      client.createMemoryAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getMemoryTest() throws Exception {
    Memory expectedResponse =
        Memory.newBuilder()
            .setName(
                MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFact("fact3135084")
            .putAllScope(new HashMap<String, String>())
            .build();
    mockMemoryBankService.addResponse(expectedResponse);

    MemoryName name = MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]");

    Memory actualResponse = client.getMemory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMemoryRequest actualRequest = ((GetMemoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMemoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      MemoryName name = MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]");
      client.getMemory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMemoryTest2() throws Exception {
    Memory expectedResponse =
        Memory.newBuilder()
            .setName(
                MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFact("fact3135084")
            .putAllScope(new HashMap<String, String>())
            .build();
    mockMemoryBankService.addResponse(expectedResponse);

    String name = "name3373707";

    Memory actualResponse = client.getMemory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMemoryRequest actualRequest = ((GetMemoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMemoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      String name = "name3373707";
      client.getMemory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMemoryTest() throws Exception {
    Memory expectedResponse =
        Memory.newBuilder()
            .setName(
                MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFact("fact3135084")
            .putAllScope(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMemoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemoryBankService.addResponse(resultOperation);

    Memory memory = Memory.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Memory actualResponse = client.updateMemoryAsync(memory, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMemoryRequest actualRequest = ((UpdateMemoryRequest) actualRequests.get(0));

    Assert.assertEquals(memory, actualRequest.getMemory());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMemoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      Memory memory = Memory.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMemoryAsync(memory, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listMemoriesTest() throws Exception {
    Memory responsesElement = Memory.newBuilder().build();
    ListMemoriesResponse expectedResponse =
        ListMemoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMemories(Arrays.asList(responsesElement))
            .build();
    mockMemoryBankService.addResponse(expectedResponse);

    ReasoningEngineName parent =
        ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");

    ListMemoriesPagedResponse pagedListResponse = client.listMemories(parent);

    List<Memory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMemoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMemoriesRequest actualRequest = ((ListMemoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMemoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      ReasoningEngineName parent =
          ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
      client.listMemories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMemoriesTest2() throws Exception {
    Memory responsesElement = Memory.newBuilder().build();
    ListMemoriesResponse expectedResponse =
        ListMemoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMemories(Arrays.asList(responsesElement))
            .build();
    mockMemoryBankService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMemoriesPagedResponse pagedListResponse = client.listMemories(parent);

    List<Memory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMemoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMemoriesRequest actualRequest = ((ListMemoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMemoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMemories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMemoryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMemoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemoryBankService.addResponse(resultOperation);

    MemoryName name = MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]");

    client.deleteMemoryAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMemoryRequest actualRequest = ((DeleteMemoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMemoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      MemoryName name = MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]");
      client.deleteMemoryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMemoryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMemoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemoryBankService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMemoryAsync(name).get();

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMemoryRequest actualRequest = ((DeleteMemoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMemoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMemoryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateMemoriesTest() throws Exception {
    GenerateMemoriesResponse expectedResponse =
        GenerateMemoriesResponse.newBuilder()
            .addAllGeneratedMemories(new ArrayList<GenerateMemoriesResponse.GeneratedMemory>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateMemoriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemoryBankService.addResponse(resultOperation);

    ReasoningEngineName parent =
        ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");

    GenerateMemoriesResponse actualResponse = client.generateMemoriesAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateMemoriesRequest actualRequest = ((GenerateMemoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateMemoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      ReasoningEngineName parent =
          ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
      client.generateMemoriesAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateMemoriesTest2() throws Exception {
    GenerateMemoriesResponse expectedResponse =
        GenerateMemoriesResponse.newBuilder()
            .addAllGeneratedMemories(new ArrayList<GenerateMemoriesResponse.GeneratedMemory>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateMemoriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMemoryBankService.addResponse(resultOperation);

    String parent = "parent-995424086";

    GenerateMemoriesResponse actualResponse = client.generateMemoriesAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateMemoriesRequest actualRequest = ((GenerateMemoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateMemoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.generateMemoriesAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void retrieveMemoriesTest() throws Exception {
    RetrieveMemoriesResponse expectedResponse =
        RetrieveMemoriesResponse.newBuilder()
            .addAllRetrievedMemories(new ArrayList<RetrieveMemoriesResponse.RetrievedMemory>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockMemoryBankService.addResponse(expectedResponse);

    ReasoningEngineName parent =
        ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");

    RetrieveMemoriesResponse actualResponse = client.retrieveMemories(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveMemoriesRequest actualRequest = ((RetrieveMemoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveMemoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      ReasoningEngineName parent =
          ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
      client.retrieveMemories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveMemoriesTest2() throws Exception {
    RetrieveMemoriesResponse expectedResponse =
        RetrieveMemoriesResponse.newBuilder()
            .addAllRetrievedMemories(new ArrayList<RetrieveMemoriesResponse.RetrievedMemory>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockMemoryBankService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    RetrieveMemoriesResponse actualResponse = client.retrieveMemories(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMemoryBankService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveMemoriesRequest actualRequest = ((RetrieveMemoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveMemoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMemoryBankService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.retrieveMemories(parent);
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
