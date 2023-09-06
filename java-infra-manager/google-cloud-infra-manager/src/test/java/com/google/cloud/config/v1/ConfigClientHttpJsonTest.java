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

package com.google.cloud.config.v1;

import static com.google.cloud.config.v1.ConfigClient.ListDeploymentsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListLocationsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListResourcesPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListRevisionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.config.v1.stub.HttpJsonConfigStub;
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
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class ConfigClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConfigClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConfigStub.getMethodDescriptors(), ConfigSettings.getDefaultEndpoint());
    ConfigSettings settings =
        ConfigSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConfigSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigClient.create(settings);
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
  public void listDeploymentsTest() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void listDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentsTest2() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void listDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    Deployment actualResponse = client.getDeployment(name);
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
  public void getDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";

    Deployment actualResponse = client.getDeployment(name);
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
  public void getDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse =
        client.createDeploymentAsync(parent, deployment, deploymentId).get();
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
  public void createDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeploymentAsync(parent, deployment, deploymentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse =
        client.createDeploymentAsync(parent, deployment, deploymentId).get();
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
  public void createDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeploymentAsync(parent, deployment, deploymentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Deployment deployment =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Deployment actualResponse = client.updateDeploymentAsync(deployment, updateMask).get();
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
  public void updateDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Deployment deployment =
          Deployment.newBuilder()
              .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setLatestRevision("latestRevision-1002490750")
              .setStateDetail("stateDetail748574786")
              .setDeleteResults(ApplyResults.newBuilder().build())
              .setDeleteBuild("deleteBuild-1148574845")
              .setDeleteLogs("deleteLogs1764356602")
              .addAllTfErrors(new ArrayList<TerraformError>())
              .setErrorLogs("errorLogs329304023")
              .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
              .setServiceAccount("serviceAccount1079137720")
              .setImportExistingResources(true)
              .setWorkerPool("workerPool-384405318")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeploymentAsync(deployment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    Deployment actualResponse = client.deleteDeploymentAsync(name).get();
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
  public void deleteDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.deleteDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";

    Deployment actualResponse = client.deleteDeploymentAsync(name).get();
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
  public void deleteDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";
      client.deleteDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listRevisionsTest() throws Exception {
    Revision responsesElement = Revision.newBuilder().build();
    ListRevisionsResponse expectedResponse =
        ListRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    ListRevisionsPagedResponse pagedListResponse = client.listRevisions(parent);

    List<Revision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRevisionsList().get(0), resources.get(0));

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
  public void listRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.listRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRevisionsTest2() throws Exception {
    Revision responsesElement = Revision.newBuilder().build();
    ListRevisionsResponse expectedResponse =
        ListRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2099/locations/location-2099/deployments/deployment-2099";

    ListRevisionsPagedResponse pagedListResponse = client.listRevisions(parent);

    List<Revision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRevisionsList().get(0), resources.get(0));

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
  public void listRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2099/locations/location-2099/deployments/deployment-2099";
      client.listRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRevisionTest() throws Exception {
    Revision expectedResponse =
        Revision.newBuilder()
            .setName(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setApplyResults(ApplyResults.newBuilder().build())
            .setStateDetail("stateDetail748574786")
            .setBuild("build94094958")
            .setLogs("logs3327407")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    mockService.addResponse(expectedResponse);

    RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");

    Revision actualResponse = client.getRevision(name);
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
  public void getRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");
      client.getRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRevisionTest2() throws Exception {
    Revision expectedResponse =
        Revision.newBuilder()
            .setName(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setApplyResults(ApplyResults.newBuilder().build())
            .setStateDetail("stateDetail748574786")
            .setBuild("build94094958")
            .setLogs("logs3327407")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6392/locations/location-6392/deployments/deployment-6392/revisions/revision-6392";

    Revision actualResponse = client.getRevision(name);
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
  public void getRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6392/locations/location-6392/deployments/deployment-6392/revisions/revision-6392";
      client.getRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceTest() throws Exception {
    Resource expectedResponse =
        Resource.newBuilder()
            .setName(
                ResourceName.of(
                        "[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]")
                    .toString())
            .setTerraformInfo(ResourceTerraformInfo.newBuilder().build())
            .putAllCaiAssets(new HashMap<String, ResourceCAIInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    ResourceName name =
        ResourceName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]");

    Resource actualResponse = client.getResource(name);
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
  public void getResourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName name =
          ResourceName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]");
      client.getResource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceTest2() throws Exception {
    Resource expectedResponse =
        Resource.newBuilder()
            .setName(
                ResourceName.of(
                        "[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]")
                    .toString())
            .setTerraformInfo(ResourceTerraformInfo.newBuilder().build())
            .putAllCaiAssets(new HashMap<String, ResourceCAIInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3735/locations/location-3735/deployments/deployment-3735/revisions/revision-3735/resources/resource-3735";

    Resource actualResponse = client.getResource(name);
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
  public void getResourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3735/locations/location-3735/deployments/deployment-3735/revisions/revision-3735/resources/resource-3735";
      client.getResource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourcesTest() throws Exception {
    Resource responsesElement = Resource.newBuilder().build();
    ListResourcesResponse expectedResponse =
        ListResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    RevisionName parent = RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");

    ListResourcesPagedResponse pagedListResponse = client.listResources(parent);

    List<Resource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

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
  public void listResourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RevisionName parent =
          RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");
      client.listResources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourcesTest2() throws Exception {
    Resource responsesElement = Resource.newBuilder().build();
    ListResourcesResponse expectedResponse =
        ListResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9641/locations/location-9641/deployments/deployment-9641/revisions/revision-9641";

    ListResourcesPagedResponse pagedListResponse = client.listResources(parent);

    List<Resource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

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
  public void listResourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9641/locations/location-9641/deployments/deployment-9641/revisions/revision-9641";
      client.listResources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportDeploymentStatefileTest() throws Exception {
    Statefile expectedResponse = Statefile.newBuilder().setSignedUri("signedUri1076770992").build();
    mockService.addResponse(expectedResponse);

    ExportDeploymentStatefileRequest request =
        ExportDeploymentStatefileRequest.newBuilder()
            .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setDraft(true)
            .build();

    Statefile actualResponse = client.exportDeploymentStatefile(request);
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
  public void exportDeploymentStatefileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportDeploymentStatefileRequest request =
          ExportDeploymentStatefileRequest.newBuilder()
              .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
              .setDraft(true)
              .build();
      client.exportDeploymentStatefile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportRevisionStatefileTest() throws Exception {
    Statefile expectedResponse = Statefile.newBuilder().setSignedUri("signedUri1076770992").build();
    mockService.addResponse(expectedResponse);

    ExportRevisionStatefileRequest request =
        ExportRevisionStatefileRequest.newBuilder()
            .setParent(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]").toString())
            .build();

    Statefile actualResponse = client.exportRevisionStatefile(request);
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
  public void exportRevisionStatefileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportRevisionStatefileRequest request =
          ExportRevisionStatefileRequest.newBuilder()
              .setParent(
                  RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
                      .toString())
              .build();
      client.exportRevisionStatefile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importStatefileTest() throws Exception {
    Statefile expectedResponse = Statefile.newBuilder().setSignedUri("signedUri1076770992").build();
    mockService.addResponse(expectedResponse);

    DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    long lockId = 338696367;

    Statefile actualResponse = client.importStatefile(parent, lockId);
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
  public void importStatefileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      long lockId = 338696367;
      client.importStatefile(parent, lockId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importStatefileTest2() throws Exception {
    Statefile expectedResponse = Statefile.newBuilder().setSignedUri("signedUri1076770992").build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2099/locations/location-2099/deployments/deployment-2099";
    long lockId = 338696367;

    Statefile actualResponse = client.importStatefile(parent, lockId);
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
  public void importStatefileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2099/locations/location-2099/deployments/deployment-2099";
      long lockId = 338696367;
      client.importStatefile(parent, lockId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteStatefileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    client.deleteStatefile(name);

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
  public void deleteStatefileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.deleteStatefile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteStatefileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";

    client.deleteStatefile(name);

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
  public void deleteStatefileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";
      client.deleteStatefile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lockDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("lockDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    Deployment actualResponse = client.lockDeploymentAsync(name).get();
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
  public void lockDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.lockDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void lockDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("lockDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";

    Deployment actualResponse = client.lockDeploymentAsync(name).get();
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
  public void lockDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";
      client.lockDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void unlockDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("unlockDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    long lockId = 338696367;

    Deployment actualResponse = client.unlockDeploymentAsync(name, lockId).get();
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
  public void unlockDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      long lockId = 338696367;
      client.unlockDeploymentAsync(name, lockId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void unlockDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setLatestRevision("latestRevision-1002490750")
            .setStateDetail("stateDetail748574786")
            .setDeleteResults(ApplyResults.newBuilder().build())
            .setDeleteBuild("deleteBuild-1148574845")
            .setDeleteLogs("deleteLogs1764356602")
            .addAllTfErrors(new ArrayList<TerraformError>())
            .setErrorLogs("errorLogs329304023")
            .setArtifactsGcsBucket("artifactsGcsBucket-1978454016")
            .setServiceAccount("serviceAccount1079137720")
            .setImportExistingResources(true)
            .setWorkerPool("workerPool-384405318")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("unlockDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";
    long lockId = 338696367;

    Deployment actualResponse = client.unlockDeploymentAsync(name, lockId).get();
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
  public void unlockDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";
      long lockId = 338696367;
      client.unlockDeploymentAsync(name, lockId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportLockInfoTest() throws Exception {
    LockInfo expectedResponse =
        LockInfo.newBuilder()
            .setLockId(338696367)
            .setOperation("operation1662702951")
            .setInfo("info3237038")
            .setWho("who117694")
            .setVersion("version351608024")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    LockInfo actualResponse = client.exportLockInfo(name);
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
  public void exportLockInfoExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.exportLockInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportLockInfoTest2() throws Exception {
    LockInfo expectedResponse =
        LockInfo.newBuilder()
            .setLockId(338696367)
            .setOperation("operation1662702951")
            .setInfo("info3237038")
            .setWho("who117694")
            .setVersion("version351608024")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";

    LockInfo actualResponse = client.exportLockInfo(name);
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
  public void exportLockInfoExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4348/locations/location-4348/deployments/deployment-4348";
      client.exportLockInfo(name);
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
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
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
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
              .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
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
            .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
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
              .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
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
            .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
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
              .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
