/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.functions.v2alpha;

import static com.google.cloud.functions.v2alpha.FunctionServiceClient.ListFunctionsPagedResponse;
import static com.google.cloud.functions.v2alpha.FunctionServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
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
public class FunctionServiceClientTest {
  private static MockFunctionService mockFunctionService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FunctionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFunctionService = new MockFunctionService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockFunctionService, mockLocations, mockIAMPolicy));
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
    FunctionServiceSettings settings =
        FunctionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FunctionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getFunctionTest() throws Exception {
    Function expectedResponse =
        Function.newBuilder()
            .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setEnvironment(Environment.forNumber(0))
            .setDescription("description-1724546052")
            .setBuildConfig(BuildConfig.newBuilder().build())
            .setServiceConfig(ServiceConfig.newBuilder().build())
            .setEventTrigger(EventTrigger.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllStateMessages(new ArrayList<StateMessage>())
            .build();
    mockFunctionService.addResponse(expectedResponse);

    FunctionName name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

    Function actualResponse = client.getFunction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFunctionRequest actualRequest = ((GetFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      FunctionName name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      client.getFunction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFunctionTest2() throws Exception {
    Function expectedResponse =
        Function.newBuilder()
            .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setEnvironment(Environment.forNumber(0))
            .setDescription("description-1724546052")
            .setBuildConfig(BuildConfig.newBuilder().build())
            .setServiceConfig(ServiceConfig.newBuilder().build())
            .setEventTrigger(EventTrigger.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllStateMessages(new ArrayList<StateMessage>())
            .build();
    mockFunctionService.addResponse(expectedResponse);

    String name = "name3373707";

    Function actualResponse = client.getFunction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFunctionRequest actualRequest = ((GetFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFunctionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      String name = "name3373707";
      client.getFunction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFunctionsTest() throws Exception {
    Function responsesElement = Function.newBuilder().build();
    ListFunctionsResponse expectedResponse =
        ListFunctionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFunctions(Arrays.asList(responsesElement))
            .build();
    mockFunctionService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFunctionsPagedResponse pagedListResponse = client.listFunctions(parent);

    List<Function> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFunctionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFunctionsRequest actualRequest = ((ListFunctionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFunctionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFunctions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFunctionsTest2() throws Exception {
    Function responsesElement = Function.newBuilder().build();
    ListFunctionsResponse expectedResponse =
        ListFunctionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFunctions(Arrays.asList(responsesElement))
            .build();
    mockFunctionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFunctionsPagedResponse pagedListResponse = client.listFunctions(parent);

    List<Function> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFunctionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFunctionsRequest actualRequest = ((ListFunctionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFunctionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFunctions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFunctionTest() throws Exception {
    Function expectedResponse =
        Function.newBuilder()
            .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setEnvironment(Environment.forNumber(0))
            .setDescription("description-1724546052")
            .setBuildConfig(BuildConfig.newBuilder().build())
            .setServiceConfig(ServiceConfig.newBuilder().build())
            .setEventTrigger(EventTrigger.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllStateMessages(new ArrayList<StateMessage>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFunctionService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Function function = Function.newBuilder().build();
    String functionId = "functionId-62789869";

    Function actualResponse = client.createFunctionAsync(parent, function, functionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFunctionRequest actualRequest = ((CreateFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(function, actualRequest.getFunction());
    Assert.assertEquals(functionId, actualRequest.getFunctionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Function function = Function.newBuilder().build();
      String functionId = "functionId-62789869";
      client.createFunctionAsync(parent, function, functionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFunctionTest2() throws Exception {
    Function expectedResponse =
        Function.newBuilder()
            .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setEnvironment(Environment.forNumber(0))
            .setDescription("description-1724546052")
            .setBuildConfig(BuildConfig.newBuilder().build())
            .setServiceConfig(ServiceConfig.newBuilder().build())
            .setEventTrigger(EventTrigger.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllStateMessages(new ArrayList<StateMessage>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFunctionService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Function function = Function.newBuilder().build();
    String functionId = "functionId-62789869";

    Function actualResponse = client.createFunctionAsync(parent, function, functionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFunctionRequest actualRequest = ((CreateFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(function, actualRequest.getFunction());
    Assert.assertEquals(functionId, actualRequest.getFunctionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFunctionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      String parent = "parent-995424086";
      Function function = Function.newBuilder().build();
      String functionId = "functionId-62789869";
      client.createFunctionAsync(parent, function, functionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateFunctionTest() throws Exception {
    Function expectedResponse =
        Function.newBuilder()
            .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setEnvironment(Environment.forNumber(0))
            .setDescription("description-1724546052")
            .setBuildConfig(BuildConfig.newBuilder().build())
            .setServiceConfig(ServiceConfig.newBuilder().build())
            .setEventTrigger(EventTrigger.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllStateMessages(new ArrayList<StateMessage>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFunctionService.addResponse(resultOperation);

    Function function = Function.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Function actualResponse = client.updateFunctionAsync(function, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFunctionRequest actualRequest = ((UpdateFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(function, actualRequest.getFunction());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      Function function = Function.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFunctionAsync(function, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFunctionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFunctionService.addResponse(resultOperation);

    FunctionName name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

    client.deleteFunctionAsync(name).get();

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFunctionRequest actualRequest = ((DeleteFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      FunctionName name = FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      client.deleteFunctionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFunctionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFunctionService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFunctionAsync(name).get();

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFunctionRequest actualRequest = ((DeleteFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFunctionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFunctionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateUploadUrlTest() throws Exception {
    GenerateUploadUrlResponse expectedResponse =
        GenerateUploadUrlResponse.newBuilder()
            .setUploadUrl("uploadUrl1239085998")
            .setStorageSource(StorageSource.newBuilder().build())
            .build();
    mockFunctionService.addResponse(expectedResponse);

    GenerateUploadUrlRequest request =
        GenerateUploadUrlRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .build();

    GenerateUploadUrlResponse actualResponse = client.generateUploadUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateUploadUrlRequest actualRequest = ((GenerateUploadUrlRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateUploadUrlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      GenerateUploadUrlRequest request =
          GenerateUploadUrlRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      client.generateUploadUrl(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateDownloadUrlTest() throws Exception {
    GenerateDownloadUrlResponse expectedResponse =
        GenerateDownloadUrlResponse.newBuilder().setDownloadUrl("downloadUrl-1211148345").build();
    mockFunctionService.addResponse(expectedResponse);

    GenerateDownloadUrlRequest request =
        GenerateDownloadUrlRequest.newBuilder()
            .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .build();

    GenerateDownloadUrlResponse actualResponse = client.generateDownloadUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateDownloadUrlRequest actualRequest = ((GenerateDownloadUrlRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateDownloadUrlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      GenerateDownloadUrlRequest request =
          GenerateDownloadUrlRequest.newBuilder()
              .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
              .build();
      client.generateDownloadUrl(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuntimesTest() throws Exception {
    ListRuntimesResponse expectedResponse =
        ListRuntimesResponse.newBuilder()
            .addAllRuntimes(new ArrayList<ListRuntimesResponse.Runtime>())
            .build();
    mockFunctionService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRuntimesResponse actualResponse = client.listRuntimes(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuntimesRequest actualRequest = ((ListRuntimesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuntimesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRuntimes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuntimesTest2() throws Exception {
    ListRuntimesResponse expectedResponse =
        ListRuntimesResponse.newBuilder()
            .addAllRuntimes(new ArrayList<ListRuntimesResponse.Runtime>())
            .build();
    mockFunctionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRuntimesResponse actualResponse = client.listRuntimes(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFunctionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuntimesRequest actualRequest = ((ListRuntimesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuntimesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFunctionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRuntimes(parent);
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
            .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
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
              .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
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
            .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
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
              .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
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
            .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
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
              .setResource(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
