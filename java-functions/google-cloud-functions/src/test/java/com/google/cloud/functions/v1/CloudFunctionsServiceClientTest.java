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
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class CloudFunctionsServiceClientTest {
  private static MockCloudFunctionsService mockCloudFunctionsService;
  private static MockServiceHelper serviceHelper;
  private CloudFunctionsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudFunctionsService = new MockCloudFunctionsService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudFunctionsService));
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
  @SuppressWarnings("all")
  public void listFunctionsTest() {
    String nextPageToken = "";
    CloudFunction functionsElement = CloudFunction.newBuilder().build();
    List<CloudFunction> functions = Arrays.asList(functionsElement);
    ListFunctionsResponse expectedResponse =
        ListFunctionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllFunctions(functions)
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    ListFunctionsRequest request = ListFunctionsRequest.newBuilder().build();

    ListFunctionsPagedResponse pagedListResponse = client.listFunctions(request);

    List<CloudFunction> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFunctionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFunctionsRequest actualRequest = (ListFunctionsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listFunctionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      ListFunctionsRequest request = ListFunctionsRequest.newBuilder().build();

      client.listFunctions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getFunctionTest() {
    CloudFunctionName name2 = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    String description = "description-1724546052";
    String sourceArchiveUrl = "sourceArchiveUrl-289007026";
    String entryPoint = "entryPoint-799136893";
    String runtime = "runtime1550962648";
    int availableMemoryMb = 1964533661;
    String serviceAccountEmail = "serviceAccountEmail-1300473088";
    long versionId = 670497310L;
    String network = "network1843485230";
    int maxInstances = 330682013;
    String vpcConnector = "vpcConnector1732864119";
    String buildId = "buildId-1430655860";
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setSourceArchiveUrl(sourceArchiveUrl)
            .setEntryPoint(entryPoint)
            .setRuntime(runtime)
            .setAvailableMemoryMb(availableMemoryMb)
            .setServiceAccountEmail(serviceAccountEmail)
            .setVersionId(versionId)
            .setNetwork(network)
            .setMaxInstances(maxInstances)
            .setVpcConnector(vpcConnector)
            .setBuildId(buildId)
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

    CloudFunction actualResponse = client.getFunction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFunctionRequest actualRequest = (GetFunctionRequest) actualRequests.get(0);

    Assert.assertEquals(name, CloudFunctionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

      client.getFunction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createFunctionTest() throws Exception {
    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    String description = "description-1724546052";
    String sourceArchiveUrl = "sourceArchiveUrl-289007026";
    String entryPoint = "entryPoint-799136893";
    String runtime = "runtime1550962648";
    int availableMemoryMb = 1964533661;
    String serviceAccountEmail = "serviceAccountEmail-1300473088";
    long versionId = 670497310L;
    String network = "network1843485230";
    int maxInstances = 330682013;
    String vpcConnector = "vpcConnector1732864119";
    String buildId = "buildId-1430655860";
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setSourceArchiveUrl(sourceArchiveUrl)
            .setEntryPoint(entryPoint)
            .setRuntime(runtime)
            .setAvailableMemoryMb(availableMemoryMb)
            .setServiceAccountEmail(serviceAccountEmail)
            .setVersionId(versionId)
            .setNetwork(network)
            .setMaxInstances(maxInstances)
            .setVpcConnector(vpcConnector)
            .setBuildId(buildId)
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
    CreateFunctionRequest actualRequest = (CreateFunctionRequest) actualRequests.get(0);

    Assert.assertEquals(location, LocationName.parse(actualRequest.getLocation()));
    Assert.assertEquals(function, actualRequest.getFunction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      CloudFunction function = CloudFunction.newBuilder().build();

      client.createFunctionAsync(location, function).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateFunctionTest() throws Exception {
    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    String description = "description-1724546052";
    String sourceArchiveUrl = "sourceArchiveUrl-289007026";
    String entryPoint = "entryPoint-799136893";
    String runtime = "runtime1550962648";
    int availableMemoryMb = 1964533661;
    String serviceAccountEmail = "serviceAccountEmail-1300473088";
    long versionId = 670497310L;
    String network = "network1843485230";
    int maxInstances = 330682013;
    String vpcConnector = "vpcConnector1732864119";
    String buildId = "buildId-1430655860";
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setSourceArchiveUrl(sourceArchiveUrl)
            .setEntryPoint(entryPoint)
            .setRuntime(runtime)
            .setAvailableMemoryMb(availableMemoryMb)
            .setServiceAccountEmail(serviceAccountEmail)
            .setVersionId(versionId)
            .setNetwork(network)
            .setMaxInstances(maxInstances)
            .setVpcConnector(vpcConnector)
            .setBuildId(buildId)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudFunctionsService.addResponse(resultOperation);

    CloudFunctionName function = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

    CloudFunction actualResponse = client.updateFunctionAsync(function).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFunctionRequest actualRequest = (UpdateFunctionRequest) actualRequests.get(0);

    Assert.assertEquals(function, CloudFunctionName.parse(actualRequest.getFunction()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      CloudFunctionName function = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

      client.updateFunctionAsync(function).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
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

    Empty actualResponse = client.deleteFunctionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFunctionRequest actualRequest = (DeleteFunctionRequest) actualRequests.get(0);

    Assert.assertEquals(name, CloudFunctionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

      client.deleteFunctionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void callFunctionTest() {
    String executionId = "executionId-1217171550";
    String result = "result-934426595";
    String error = "error96784904";
    CallFunctionResponse expectedResponse =
        CallFunctionResponse.newBuilder()
            .setExecutionId(executionId)
            .setResult(result)
            .setError(error)
            .build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    String data = "data3076010";

    CallFunctionResponse actualResponse = client.callFunction(name, data);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CallFunctionRequest actualRequest = (CallFunctionRequest) actualRequests.get(0);

    Assert.assertEquals(name, CloudFunctionName.parse(actualRequest.getName()));
    Assert.assertEquals(data, actualRequest.getData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void callFunctionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      String data = "data3076010";

      client.callFunction(name, data);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void generateUploadUrlTest() {
    String uploadUrl = "uploadUrl-242738639";
    GenerateUploadUrlResponse expectedResponse =
        GenerateUploadUrlResponse.newBuilder().setUploadUrl(uploadUrl).build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    GenerateUploadUrlRequest request = GenerateUploadUrlRequest.newBuilder().build();

    GenerateUploadUrlResponse actualResponse = client.generateUploadUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateUploadUrlRequest actualRequest = (GenerateUploadUrlRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void generateUploadUrlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      GenerateUploadUrlRequest request = GenerateUploadUrlRequest.newBuilder().build();

      client.generateUploadUrl(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void generateDownloadUrlTest() {
    String downloadUrl = "downloadUrl1109408056";
    GenerateDownloadUrlResponse expectedResponse =
        GenerateDownloadUrlResponse.newBuilder().setDownloadUrl(downloadUrl).build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    GenerateDownloadUrlRequest request = GenerateDownloadUrlRequest.newBuilder().build();

    GenerateDownloadUrlResponse actualResponse = client.generateDownloadUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateDownloadUrlRequest actualRequest = (GenerateDownloadUrlRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void generateDownloadUrlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      GenerateDownloadUrlRequest request = GenerateDownloadUrlRequest.newBuilder().build();

      client.generateDownloadUrl(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    ResourceName resource = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    Policy policy = Policy.newBuilder().build();
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource.toString()).setPolicy(policy).build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      ResourceName resource = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      Policy policy = Policy.newBuilder().build();
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(resource.toString())
              .setPolicy(policy)
              .build();

      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    ResourceName resource = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder().setResource(resource.toString()).build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      ResourceName resource = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder().setResource(resource.toString()).build();

      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockCloudFunctionsService.addResponse(expectedResponse);

    ResourceName resource = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    List<String> permissions = new ArrayList<>();
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource.toString())
            .addAllPermissions(permissions)
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudFunctionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudFunctionsService.addException(exception);

    try {
      ResourceName resource = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      List<String> permissions = new ArrayList<>();
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(resource.toString())
              .addAllPermissions(permissions)
              .build();

      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
