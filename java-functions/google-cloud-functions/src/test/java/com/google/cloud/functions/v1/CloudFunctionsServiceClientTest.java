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

package com.google.cloud.functions.v1;

import static com.google.cloud.functions.v1.CloudFunctionsServiceClient.ListFunctionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
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
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
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
public class CloudFunctionsServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private CloudFunctionsServiceClient client;
  private static MockCloudFunctionsService mockCloudFunctionsService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudFunctionsService = new MockCloudFunctionsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudFunctionsService));
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
    CloudFunctionsServiceSettings settings =
        CloudFunctionsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudFunctionsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listFunctionsTest() throws Exception {
    CloudFunction responsesElement = CloudFunction.newBuilder().build();
    ListFunctionsResponse expectedResponse =
        ListFunctionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFunctions(Arrays.asList(responsesElement))
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    ListFunctionsRequest request =
        ListFunctionsRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListFunctionsPagedResponse pagedListResponse = client.listFunctions(request);

    List<CloudFunction> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFunctionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFunctionsRequest actualRequest = ((ListFunctionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFunctionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      ListFunctionsRequest request =
          ListFunctionsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listFunctions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFunctionTest() throws Exception {
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setDescription("description-1724546052")
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setVpcConnector("vpcConnector2101559652")
            .setBuildId("buildId230943785")
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

    CloudFunction actualResponse = client.getFunction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
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
    mockCloudFunctionsService.addException(exception);

    try {
      CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      client.getFunction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFunctionTest2() throws Exception {
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setDescription("description-1724546052")
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setVpcConnector("vpcConnector2101559652")
            .setBuildId("buildId230943785")
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    String name = "name3373707";

    CloudFunction actualResponse = client.getFunction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
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
    mockCloudFunctionsService.addException(exception);

    try {
      String name = "name3373707";
      client.getFunction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFunctionTest() throws Exception {
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setDescription("description-1724546052")
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setVpcConnector("vpcConnector2101559652")
            .setBuildId("buildId230943785")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudFunctionsService.addResponse(resultOperation);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    CloudFunction function = CloudFunction.newBuilder().build();

    CloudFunction actualResponse = client.createFunctionAsync(location, function).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFunctionRequest actualRequest = ((CreateFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(location.toString(), actualRequest.getLocation());
    Assert.assertEquals(function, actualRequest.getFunction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      CloudFunction function = CloudFunction.newBuilder().build();
      client.createFunctionAsync(location, function).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFunctionTest2() throws Exception {
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setDescription("description-1724546052")
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setVpcConnector("vpcConnector2101559652")
            .setBuildId("buildId230943785")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudFunctionsService.addResponse(resultOperation);

    String location = "location1901043637";
    CloudFunction function = CloudFunction.newBuilder().build();

    CloudFunction actualResponse = client.createFunctionAsync(location, function).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFunctionRequest actualRequest = ((CreateFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertEquals(function, actualRequest.getFunction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFunctionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      String location = "location1901043637";
      CloudFunction function = CloudFunction.newBuilder().build();
      client.createFunctionAsync(location, function).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateFunctionTest() throws Exception {
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setDescription("description-1724546052")
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setVpcConnector("vpcConnector2101559652")
            .setBuildId("buildId230943785")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudFunctionsService.addResponse(resultOperation);

    CloudFunction function = CloudFunction.newBuilder().build();

    CloudFunction actualResponse = client.updateFunctionAsync(function).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFunctionRequest actualRequest = ((UpdateFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(function, actualRequest.getFunction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      CloudFunction function = CloudFunction.newBuilder().build();
      client.updateFunctionAsync(function).get();
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
    mockCloudFunctionsService.addResponse(resultOperation);

    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

    client.deleteFunctionAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
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
    mockCloudFunctionsService.addException(exception);

    try {
      CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
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
    mockCloudFunctionsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFunctionAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
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
    mockCloudFunctionsService.addException(exception);

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
  public void callFunctionTest() throws Exception {
    CallFunctionResponse expectedResponse =
        CallFunctionResponse.newBuilder()
            .setExecutionId("executionId-454906285")
            .setResult("result-934426595")
            .setError("error96784904")
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    String data = "data3076010";

    CallFunctionResponse actualResponse = client.callFunction(name, data);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CallFunctionRequest actualRequest = ((CallFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(data, actualRequest.getData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void callFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      String data = "data3076010";
      client.callFunction(name, data);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void callFunctionTest2() throws Exception {
    CallFunctionResponse expectedResponse =
        CallFunctionResponse.newBuilder()
            .setExecutionId("executionId-454906285")
            .setResult("result-934426595")
            .setError("error96784904")
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    String name = "name3373707";
    String data = "data3076010";

    CallFunctionResponse actualResponse = client.callFunction(name, data);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CallFunctionRequest actualRequest = ((CallFunctionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(data, actualRequest.getData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void callFunctionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      String name = "name3373707";
      String data = "data3076010";
      client.callFunction(name, data);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateUploadUrlTest() throws Exception {
    GenerateUploadUrlResponse expectedResponse =
        GenerateUploadUrlResponse.newBuilder().setUploadUrl("uploadUrl1239085998").build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    GenerateUploadUrlRequest request =
        GenerateUploadUrlRequest.newBuilder().setParent("parent-995424086").build();

    GenerateUploadUrlResponse actualResponse = client.generateUploadUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
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
    mockCloudFunctionsService.addException(exception);

    try {
      GenerateUploadUrlRequest request =
          GenerateUploadUrlRequest.newBuilder().setParent("parent-995424086").build();
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
    mockCloudFunctionsService.addResponse(expectedResponse);

    GenerateDownloadUrlRequest request =
        GenerateDownloadUrlRequest.newBuilder()
            .setName("name3373707")
            .setVersionId(-670497310)
            .build();

    GenerateDownloadUrlResponse actualResponse = client.generateDownloadUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateDownloadUrlRequest actualRequest = ((GenerateDownloadUrlRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getVersionId(), actualRequest.getVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateDownloadUrlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      GenerateDownloadUrlRequest request =
          GenerateDownloadUrlRequest.newBuilder()
              .setName("name3373707")
              .setVersionId(-670497310)
              .build();
      client.generateDownloadUrl(request);
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setPolicy(Policy.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
              .setPolicy(Policy.newBuilder().build())
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
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
    mockCloudFunctionsService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
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
    mockCloudFunctionsService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
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
    mockCloudFunctionsService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
