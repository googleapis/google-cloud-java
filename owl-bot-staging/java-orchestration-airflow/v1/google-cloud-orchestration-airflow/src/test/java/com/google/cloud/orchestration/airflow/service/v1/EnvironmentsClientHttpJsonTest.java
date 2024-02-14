/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.orchestration.airflow.service.v1;

import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListUserWorkloadsConfigMapsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListUserWorkloadsSecretsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListWorkloadsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.orchestration.airflow.service.v1.stub.HttpJsonEnvironmentsStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
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
public class EnvironmentsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static EnvironmentsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonEnvironmentsStub.getMethodDescriptors(),
            EnvironmentsSettings.getDefaultEndpoint());
    EnvironmentsSettings settings =
        EnvironmentsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                EnvironmentsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EnvironmentsClient.create(settings);
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
  public void createEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
            .setConfig(EnvironmentConfig.newBuilder().build())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSatisfiesPzs(true)
            .setStorageConfig(StorageConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Environment environment = Environment.newBuilder().build();

    Environment actualResponse = client.createEnvironmentAsync(parent, environment).get();
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
  public void createEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Environment environment = Environment.newBuilder().build();
      client.createEnvironmentAsync(parent, environment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
            .setConfig(EnvironmentConfig.newBuilder().build())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSatisfiesPzs(true)
            .setStorageConfig(StorageConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7856/locations/location-7856/environments/environment-7856";

    Environment actualResponse = client.getEnvironment(name);
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
  public void getEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7856/locations/location-7856/environments/environment-7856";
      client.getEnvironment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnvironmentsTest() throws Exception {
    Environment responsesElement = Environment.newBuilder().build();
    ListEnvironmentsResponse expectedResponse =
        ListEnvironmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnvironments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(parent);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

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
  public void listEnvironmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listEnvironments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
            .setConfig(EnvironmentConfig.newBuilder().build())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSatisfiesPzs(true)
            .setStorageConfig(StorageConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7856/locations/location-7856/environments/environment-7856";
    Environment environment = Environment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Environment actualResponse = client.updateEnvironmentAsync(name, environment, updateMask).get();
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
  public void updateEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7856/locations/location-7856/environments/environment-7856";
      Environment environment = Environment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEnvironmentAsync(name, environment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEnvironmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7856/locations/location-7856/environments/environment-7856";

    client.deleteEnvironmentAsync(name).get();

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
  public void deleteEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7856/locations/location-7856/environments/environment-7856";
      client.deleteEnvironmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void executeAirflowCommandTest() throws Exception {
    ExecuteAirflowCommandResponse expectedResponse =
        ExecuteAirflowCommandResponse.newBuilder()
            .setExecutionId("executionId-454906285")
            .setPod("pod111173")
            .setPodNamespace("podNamespace463962262")
            .setError("error96784904")
            .build();
    mockService.addResponse(expectedResponse);

    ExecuteAirflowCommandRequest request =
        ExecuteAirflowCommandRequest.newBuilder()
            .setEnvironment(
                "projects/project-4088/locations/location-4088/environments/environment-4088")
            .setCommand("command950394699")
            .setSubcommand("subcommand2099091723")
            .addAllParameters(new ArrayList<String>())
            .build();

    ExecuteAirflowCommandResponse actualResponse = client.executeAirflowCommand(request);
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
  public void executeAirflowCommandExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExecuteAirflowCommandRequest request =
          ExecuteAirflowCommandRequest.newBuilder()
              .setEnvironment(
                  "projects/project-4088/locations/location-4088/environments/environment-4088")
              .setCommand("command950394699")
              .setSubcommand("subcommand2099091723")
              .addAllParameters(new ArrayList<String>())
              .build();
      client.executeAirflowCommand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopAirflowCommandTest() throws Exception {
    StopAirflowCommandResponse expectedResponse =
        StopAirflowCommandResponse.newBuilder()
            .setIsDone(true)
            .addAllOutput(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    StopAirflowCommandRequest request =
        StopAirflowCommandRequest.newBuilder()
            .setEnvironment(
                "projects/project-4088/locations/location-4088/environments/environment-4088")
            .setExecutionId("executionId-454906285")
            .setPod("pod111173")
            .setPodNamespace("podNamespace463962262")
            .setForce(true)
            .build();

    StopAirflowCommandResponse actualResponse = client.stopAirflowCommand(request);
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
  public void stopAirflowCommandExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StopAirflowCommandRequest request =
          StopAirflowCommandRequest.newBuilder()
              .setEnvironment(
                  "projects/project-4088/locations/location-4088/environments/environment-4088")
              .setExecutionId("executionId-454906285")
              .setPod("pod111173")
              .setPodNamespace("podNamespace463962262")
              .setForce(true)
              .build();
      client.stopAirflowCommand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pollAirflowCommandTest() throws Exception {
    PollAirflowCommandResponse expectedResponse =
        PollAirflowCommandResponse.newBuilder()
            .addAllOutput(new ArrayList<PollAirflowCommandResponse.Line>())
            .setOutputEnd(true)
            .setExitInfo(PollAirflowCommandResponse.ExitInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PollAirflowCommandRequest request =
        PollAirflowCommandRequest.newBuilder()
            .setEnvironment(
                "projects/project-4088/locations/location-4088/environments/environment-4088")
            .setExecutionId("executionId-454906285")
            .setPod("pod111173")
            .setPodNamespace("podNamespace463962262")
            .setNextLineNumber(1176642216)
            .build();

    PollAirflowCommandResponse actualResponse = client.pollAirflowCommand(request);
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
  public void pollAirflowCommandExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PollAirflowCommandRequest request =
          PollAirflowCommandRequest.newBuilder()
              .setEnvironment(
                  "projects/project-4088/locations/location-4088/environments/environment-4088")
              .setExecutionId("executionId-454906285")
              .setPod("pod111173")
              .setPodNamespace("podNamespace463962262")
              .setNextLineNumber(1176642216)
              .build();
      client.pollAirflowCommand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest() throws Exception {
    ListWorkloadsResponse.ComposerWorkload responsesElement =
        ListWorkloadsResponse.ComposerWorkload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<ListWorkloadsResponse.ComposerWorkload> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

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
  public void listWorkloadsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest2() throws Exception {
    ListWorkloadsResponse.ComposerWorkload responsesElement =
        ListWorkloadsResponse.ComposerWorkload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<ListWorkloadsResponse.ComposerWorkload> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

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
  public void listWorkloadsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserWorkloadsSecretTest() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
    UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();

    UserWorkloadsSecret actualResponse =
        client.createUserWorkloadsSecret(parent, userWorkloadsSecret);
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
  public void createUserWorkloadsSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();
      client.createUserWorkloadsSecret(parent, userWorkloadsSecret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserWorkloadsSecretTest2() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";
    UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();

    UserWorkloadsSecret actualResponse =
        client.createUserWorkloadsSecret(parent, userWorkloadsSecret);
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
  public void createUserWorkloadsSecretExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";
      UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();
      client.createUserWorkloadsSecret(parent, userWorkloadsSecret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserWorkloadsSecretTest() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    UserWorkloadsSecretName name =
        UserWorkloadsSecretName.of(
            "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]");

    UserWorkloadsSecret actualResponse = client.getUserWorkloadsSecret(name);
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
  public void getUserWorkloadsSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserWorkloadsSecretName name =
          UserWorkloadsSecretName.of(
              "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]");
      client.getUserWorkloadsSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserWorkloadsSecretTest2() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3380/locations/location-3380/environments/environment-3380/userWorkloadsSecrets/userWorkloadsSecret-3380";

    UserWorkloadsSecret actualResponse = client.getUserWorkloadsSecret(name);
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
  public void getUserWorkloadsSecretExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3380/locations/location-3380/environments/environment-3380/userWorkloadsSecrets/userWorkloadsSecret-3380";
      client.getUserWorkloadsSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserWorkloadsSecretsTest() throws Exception {
    UserWorkloadsSecret responsesElement = UserWorkloadsSecret.newBuilder().build();
    ListUserWorkloadsSecretsResponse expectedResponse =
        ListUserWorkloadsSecretsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserWorkloadsSecrets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");

    ListUserWorkloadsSecretsPagedResponse pagedListResponse =
        client.listUserWorkloadsSecrets(parent);

    List<UserWorkloadsSecret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserWorkloadsSecretsList().get(0), resources.get(0));

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
  public void listUserWorkloadsSecretsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      client.listUserWorkloadsSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserWorkloadsSecretsTest2() throws Exception {
    UserWorkloadsSecret responsesElement = UserWorkloadsSecret.newBuilder().build();
    ListUserWorkloadsSecretsResponse expectedResponse =
        ListUserWorkloadsSecretsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserWorkloadsSecrets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";

    ListUserWorkloadsSecretsPagedResponse pagedListResponse =
        client.listUserWorkloadsSecrets(parent);

    List<UserWorkloadsSecret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserWorkloadsSecretsList().get(0), resources.get(0));

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
  public void listUserWorkloadsSecretsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";
      client.listUserWorkloadsSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserWorkloadsSecretTest() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    UserWorkloadsSecret userWorkloadsSecret =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();

    UserWorkloadsSecret actualResponse = client.updateUserWorkloadsSecret(userWorkloadsSecret);
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
  public void updateUserWorkloadsSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserWorkloadsSecret userWorkloadsSecret =
          UserWorkloadsSecret.newBuilder()
              .setName(
                  UserWorkloadsSecretName.of(
                          "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                      .toString())
              .putAllData(new HashMap<String, String>())
              .build();
      client.updateUserWorkloadsSecret(userWorkloadsSecret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserWorkloadsSecretTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    UserWorkloadsSecretName name =
        UserWorkloadsSecretName.of(
            "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]");

    client.deleteUserWorkloadsSecret(name);

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
  public void deleteUserWorkloadsSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserWorkloadsSecretName name =
          UserWorkloadsSecretName.of(
              "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]");
      client.deleteUserWorkloadsSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserWorkloadsSecretTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3380/locations/location-3380/environments/environment-3380/userWorkloadsSecrets/userWorkloadsSecret-3380";

    client.deleteUserWorkloadsSecret(name);

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
  public void deleteUserWorkloadsSecretExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3380/locations/location-3380/environments/environment-3380/userWorkloadsSecrets/userWorkloadsSecret-3380";
      client.deleteUserWorkloadsSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserWorkloadsConfigMapTest() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
    UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();

    UserWorkloadsConfigMap actualResponse =
        client.createUserWorkloadsConfigMap(parent, userWorkloadsConfigMap);
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
  public void createUserWorkloadsConfigMapExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();
      client.createUserWorkloadsConfigMap(parent, userWorkloadsConfigMap);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserWorkloadsConfigMapTest2() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";
    UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();

    UserWorkloadsConfigMap actualResponse =
        client.createUserWorkloadsConfigMap(parent, userWorkloadsConfigMap);
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
  public void createUserWorkloadsConfigMapExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";
      UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();
      client.createUserWorkloadsConfigMap(parent, userWorkloadsConfigMap);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserWorkloadsConfigMapTest() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    UserWorkloadsConfigMapName name =
        UserWorkloadsConfigMapName.of(
            "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]");

    UserWorkloadsConfigMap actualResponse = client.getUserWorkloadsConfigMap(name);
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
  public void getUserWorkloadsConfigMapExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserWorkloadsConfigMapName name =
          UserWorkloadsConfigMapName.of(
              "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]");
      client.getUserWorkloadsConfigMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserWorkloadsConfigMapTest2() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6842/locations/location-6842/environments/environment-6842/userWorkloadsConfigMaps/userWorkloadsConfigMap-6842";

    UserWorkloadsConfigMap actualResponse = client.getUserWorkloadsConfigMap(name);
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
  public void getUserWorkloadsConfigMapExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6842/locations/location-6842/environments/environment-6842/userWorkloadsConfigMaps/userWorkloadsConfigMap-6842";
      client.getUserWorkloadsConfigMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserWorkloadsConfigMapsTest() throws Exception {
    UserWorkloadsConfigMap responsesElement = UserWorkloadsConfigMap.newBuilder().build();
    ListUserWorkloadsConfigMapsResponse expectedResponse =
        ListUserWorkloadsConfigMapsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserWorkloadsConfigMaps(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");

    ListUserWorkloadsConfigMapsPagedResponse pagedListResponse =
        client.listUserWorkloadsConfigMaps(parent);

    List<UserWorkloadsConfigMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserWorkloadsConfigMapsList().get(0), resources.get(0));

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
  public void listUserWorkloadsConfigMapsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      client.listUserWorkloadsConfigMaps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserWorkloadsConfigMapsTest2() throws Exception {
    UserWorkloadsConfigMap responsesElement = UserWorkloadsConfigMap.newBuilder().build();
    ListUserWorkloadsConfigMapsResponse expectedResponse =
        ListUserWorkloadsConfigMapsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserWorkloadsConfigMaps(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";

    ListUserWorkloadsConfigMapsPagedResponse pagedListResponse =
        client.listUserWorkloadsConfigMaps(parent);

    List<UserWorkloadsConfigMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserWorkloadsConfigMapsList().get(0), resources.get(0));

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
  public void listUserWorkloadsConfigMapsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2031/locations/location-2031/environments/environment-2031";
      client.listUserWorkloadsConfigMaps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserWorkloadsConfigMapTest() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    UserWorkloadsConfigMap userWorkloadsConfigMap =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();

    UserWorkloadsConfigMap actualResponse =
        client.updateUserWorkloadsConfigMap(userWorkloadsConfigMap);
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
  public void updateUserWorkloadsConfigMapExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserWorkloadsConfigMap userWorkloadsConfigMap =
          UserWorkloadsConfigMap.newBuilder()
              .setName(
                  UserWorkloadsConfigMapName.of(
                          "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                      .toString())
              .putAllData(new HashMap<String, String>())
              .build();
      client.updateUserWorkloadsConfigMap(userWorkloadsConfigMap);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserWorkloadsConfigMapTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    UserWorkloadsConfigMapName name =
        UserWorkloadsConfigMapName.of(
            "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]");

    client.deleteUserWorkloadsConfigMap(name);

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
  public void deleteUserWorkloadsConfigMapExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserWorkloadsConfigMapName name =
          UserWorkloadsConfigMapName.of(
              "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]");
      client.deleteUserWorkloadsConfigMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserWorkloadsConfigMapTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6842/locations/location-6842/environments/environment-6842/userWorkloadsConfigMaps/userWorkloadsConfigMap-6842";

    client.deleteUserWorkloadsConfigMap(name);

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
  public void deleteUserWorkloadsConfigMapExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6842/locations/location-6842/environments/environment-6842/userWorkloadsConfigMaps/userWorkloadsConfigMap-6842";
      client.deleteUserWorkloadsConfigMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void saveSnapshotTest() throws Exception {
    SaveSnapshotResponse expectedResponse =
        SaveSnapshotResponse.newBuilder().setSnapshotPath("snapshotPath-931648503").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("saveSnapshotTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SaveSnapshotRequest request =
        SaveSnapshotRequest.newBuilder()
            .setEnvironment(
                "projects/project-4088/locations/location-4088/environments/environment-4088")
            .setSnapshotLocation("snapshotLocation1625609625")
            .build();

    SaveSnapshotResponse actualResponse = client.saveSnapshotAsync(request).get();
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
  public void saveSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SaveSnapshotRequest request =
          SaveSnapshotRequest.newBuilder()
              .setEnvironment(
                  "projects/project-4088/locations/location-4088/environments/environment-4088")
              .setSnapshotLocation("snapshotLocation1625609625")
              .build();
      client.saveSnapshotAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void loadSnapshotTest() throws Exception {
    LoadSnapshotResponse expectedResponse = LoadSnapshotResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("loadSnapshotTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LoadSnapshotRequest request =
        LoadSnapshotRequest.newBuilder()
            .setEnvironment(
                "projects/project-4088/locations/location-4088/environments/environment-4088")
            .setSnapshotPath("snapshotPath-931648503")
            .setSkipPypiPackagesInstallation(true)
            .setSkipEnvironmentVariablesSetting(true)
            .setSkipAirflowOverridesSetting(true)
            .setSkipGcsDataCopying(true)
            .build();

    LoadSnapshotResponse actualResponse = client.loadSnapshotAsync(request).get();
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
  public void loadSnapshotExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LoadSnapshotRequest request =
          LoadSnapshotRequest.newBuilder()
              .setEnvironment(
                  "projects/project-4088/locations/location-4088/environments/environment-4088")
              .setSnapshotPath("snapshotPath-931648503")
              .setSkipPypiPackagesInstallation(true)
              .setSkipEnvironmentVariablesSetting(true)
              .setSkipAirflowOverridesSetting(true)
              .setSkipGcsDataCopying(true)
              .build();
      client.loadSnapshotAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void databaseFailoverTest() throws Exception {
    DatabaseFailoverResponse expectedResponse = DatabaseFailoverResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("databaseFailoverTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DatabaseFailoverRequest request =
        DatabaseFailoverRequest.newBuilder()
            .setEnvironment(
                "projects/project-4088/locations/location-4088/environments/environment-4088")
            .build();

    DatabaseFailoverResponse actualResponse = client.databaseFailoverAsync(request).get();
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
  public void databaseFailoverExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseFailoverRequest request =
          DatabaseFailoverRequest.newBuilder()
              .setEnvironment(
                  "projects/project-4088/locations/location-4088/environments/environment-4088")
              .build();
      client.databaseFailoverAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchDatabasePropertiesTest() throws Exception {
    FetchDatabasePropertiesResponse expectedResponse =
        FetchDatabasePropertiesResponse.newBuilder()
            .setPrimaryGceZone("primaryGceZone-1629643277")
            .setSecondaryGceZone("secondaryGceZone227989057")
            .setIsFailoverReplicaAvailable(true)
            .build();
    mockService.addResponse(expectedResponse);

    FetchDatabasePropertiesRequest request =
        FetchDatabasePropertiesRequest.newBuilder()
            .setEnvironment(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
            .build();

    FetchDatabasePropertiesResponse actualResponse = client.fetchDatabaseProperties(request);
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
  public void fetchDatabasePropertiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FetchDatabasePropertiesRequest request =
          FetchDatabasePropertiesRequest.newBuilder()
              .setEnvironment(
                  EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
              .build();
      client.fetchDatabaseProperties(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
