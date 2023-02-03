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

package com.google.cloud.functions.v1;

import static com.google.cloud.functions.v1.CloudFunctionsServiceClient.ListFunctionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.functions.v1.stub.HttpJsonCloudFunctionsServiceStub;
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
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CloudFunctionsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudFunctionsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudFunctionsServiceStub.getMethodDescriptors(),
            CloudFunctionsServiceSettings.getDefaultEndpoint());
    CloudFunctionsServiceSettings settings =
        CloudFunctionsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudFunctionsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudFunctionsServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listFunctionsTest() throws Exception {
    CloudFunction responsesElement = CloudFunction.newBuilder().build();
    ListFunctionsResponse expectedResponse =
        ListFunctionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFunctions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listFunctionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setStatus(CloudFunctionStatus.forNumber(0))
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .putAllBuildEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setMinInstances(1491624145)
            .setVpcConnector("vpcConnector2101559652")
            .setKmsKeyName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setBuildWorkerPool("buildWorkerPool1011442120")
            .setBuildId("buildId230943785")
            .setBuildName("buildName-1401172455")
            .addAllSecretEnvironmentVariables(new ArrayList<SecretEnvVar>())
            .addAllSecretVolumes(new ArrayList<SecretVolume>())
            .setSourceToken("sourceToken-94946658")
            .setDockerRepository("dockerRepository1588395402")
            .build();
    mockService.addResponse(expectedResponse);

    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

    CloudFunction actualResponse = client.getFunction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getFunctionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setStatus(CloudFunctionStatus.forNumber(0))
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .putAllBuildEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setMinInstances(1491624145)
            .setVpcConnector("vpcConnector2101559652")
            .setKmsKeyName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setBuildWorkerPool("buildWorkerPool1011442120")
            .setBuildId("buildId230943785")
            .setBuildName("buildName-1401172455")
            .addAllSecretEnvironmentVariables(new ArrayList<SecretEnvVar>())
            .addAllSecretVolumes(new ArrayList<SecretVolume>())
            .setSourceToken("sourceToken-94946658")
            .setDockerRepository("dockerRepository1588395402")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-129/locations/location-129/functions/function-129";

    CloudFunction actualResponse = client.getFunction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getFunctionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-129/locations/location-129/functions/function-129";
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
            .setStatus(CloudFunctionStatus.forNumber(0))
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .putAllBuildEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setMinInstances(1491624145)
            .setVpcConnector("vpcConnector2101559652")
            .setKmsKeyName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setBuildWorkerPool("buildWorkerPool1011442120")
            .setBuildId("buildId230943785")
            .setBuildName("buildName-1401172455")
            .addAllSecretEnvironmentVariables(new ArrayList<SecretEnvVar>())
            .addAllSecretVolumes(new ArrayList<SecretVolume>())
            .setSourceToken("sourceToken-94946658")
            .setDockerRepository("dockerRepository1588395402")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    CloudFunction function = CloudFunction.newBuilder().build();

    CloudFunction actualResponse = client.createFunctionAsync(location, function).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createFunctionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      CloudFunction function = CloudFunction.newBuilder().build();
      client.createFunctionAsync(location, function).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createFunctionTest2() throws Exception {
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setDescription("description-1724546052")
            .setStatus(CloudFunctionStatus.forNumber(0))
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .putAllBuildEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setMinInstances(1491624145)
            .setVpcConnector("vpcConnector2101559652")
            .setKmsKeyName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setBuildWorkerPool("buildWorkerPool1011442120")
            .setBuildId("buildId230943785")
            .setBuildName("buildName-1401172455")
            .addAllSecretEnvironmentVariables(new ArrayList<SecretEnvVar>())
            .addAllSecretVolumes(new ArrayList<SecretVolume>())
            .setSourceToken("sourceToken-94946658")
            .setDockerRepository("dockerRepository1588395402")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String location = "projects/project-7132/locations/location-7132";
    CloudFunction function = CloudFunction.newBuilder().build();

    CloudFunction actualResponse = client.createFunctionAsync(location, function).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createFunctionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String location = "projects/project-7132/locations/location-7132";
      CloudFunction function = CloudFunction.newBuilder().build();
      client.createFunctionAsync(location, function).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateFunctionTest() throws Exception {
    CloudFunction expectedResponse =
        CloudFunction.newBuilder()
            .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setDescription("description-1724546052")
            .setStatus(CloudFunctionStatus.forNumber(0))
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .putAllBuildEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setMinInstances(1491624145)
            .setVpcConnector("vpcConnector2101559652")
            .setKmsKeyName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setBuildWorkerPool("buildWorkerPool1011442120")
            .setBuildId("buildId230943785")
            .setBuildName("buildName-1401172455")
            .addAllSecretEnvironmentVariables(new ArrayList<SecretEnvVar>())
            .addAllSecretVolumes(new ArrayList<SecretVolume>())
            .setSourceToken("sourceToken-94946658")
            .setDockerRepository("dockerRepository1588395402")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFunctionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CloudFunction function =
        CloudFunction.newBuilder()
            .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setDescription("description-1724546052")
            .setStatus(CloudFunctionStatus.forNumber(0))
            .setEntryPoint("entryPoint-1979329474")
            .setRuntime("runtime1550962648")
            .setTimeout(Duration.newBuilder().build())
            .setAvailableMemoryMb(1964533661)
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionId(-670497310)
            .putAllLabels(new HashMap<String, String>())
            .putAllEnvironmentVariables(new HashMap<String, String>())
            .putAllBuildEnvironmentVariables(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setMaxInstances(-330682013)
            .setMinInstances(1491624145)
            .setVpcConnector("vpcConnector2101559652")
            .setKmsKeyName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setBuildWorkerPool("buildWorkerPool1011442120")
            .setBuildId("buildId230943785")
            .setBuildName("buildName-1401172455")
            .addAllSecretEnvironmentVariables(new ArrayList<SecretEnvVar>())
            .addAllSecretVolumes(new ArrayList<SecretVolume>())
            .setSourceToken("sourceToken-94946658")
            .setDockerRepository("dockerRepository1588395402")
            .build();

    CloudFunction actualResponse = client.updateFunctionAsync(function).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateFunctionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudFunction function =
          CloudFunction.newBuilder()
              .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
              .setDescription("description-1724546052")
              .setStatus(CloudFunctionStatus.forNumber(0))
              .setEntryPoint("entryPoint-1979329474")
              .setRuntime("runtime1550962648")
              .setTimeout(Duration.newBuilder().build())
              .setAvailableMemoryMb(1964533661)
              .setServiceAccountEmail("serviceAccountEmail1825953988")
              .setUpdateTime(Timestamp.newBuilder().build())
              .setVersionId(-670497310)
              .putAllLabels(new HashMap<String, String>())
              .putAllEnvironmentVariables(new HashMap<String, String>())
              .putAllBuildEnvironmentVariables(new HashMap<String, String>())
              .setNetwork("network1843485230")
              .setMaxInstances(-330682013)
              .setMinInstances(1491624145)
              .setVpcConnector("vpcConnector2101559652")
              .setKmsKeyName(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .setBuildWorkerPool("buildWorkerPool1011442120")
              .setBuildId("buildId230943785")
              .setBuildName("buildName-1401172455")
              .addAllSecretEnvironmentVariables(new ArrayList<SecretEnvVar>())
              .addAllSecretVolumes(new ArrayList<SecretVolume>())
              .setSourceToken("sourceToken-94946658")
              .setDockerRepository("dockerRepository1588395402")
              .build();
      client.updateFunctionAsync(function).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");

    client.deleteFunctionAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteFunctionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
      client.deleteFunctionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-129/locations/location-129/functions/function-129";

    client.deleteFunctionAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteFunctionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-129/locations/location-129/functions/function-129";
      client.deleteFunctionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    CloudFunctionName name = CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]");
    String data = "data3076010";

    CallFunctionResponse actualResponse = client.callFunction(name, data);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void callFunctionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-129/locations/location-129/functions/function-129";
    String data = "data3076010";

    CallFunctionResponse actualResponse = client.callFunction(name, data);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void callFunctionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-129/locations/location-129/functions/function-129";
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
    mockService.addResponse(expectedResponse);

    GenerateUploadUrlRequest request =
        GenerateUploadUrlRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setKmsKeyName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .build();

    GenerateUploadUrlResponse actualResponse = client.generateUploadUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void generateUploadUrlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateUploadUrlRequest request =
          GenerateUploadUrlRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .setKmsKeyName(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
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
    mockService.addResponse(expectedResponse);

    GenerateDownloadUrlRequest request =
        GenerateDownloadUrlRequest.newBuilder()
            .setName("projects/project-129/locations/location-129/functions/function-129")
            .setVersionId(-670497310)
            .build();

    GenerateDownloadUrlResponse actualResponse = client.generateDownloadUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void generateDownloadUrlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateDownloadUrlRequest request =
          GenerateDownloadUrlRequest.newBuilder()
              .setName("projects/project-129/locations/location-129/functions/function-129")
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
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
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
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
