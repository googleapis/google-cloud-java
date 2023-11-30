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
public class ConfigClientTest {
  private static MockConfig mockConfig;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConfigClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConfig = new MockConfig();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConfig, mockLocations, mockIAMPolicy));
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
    ConfigSettings settings =
        ConfigSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listDeploymentsTest() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockConfig.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeploymentsRequest actualRequest = ((ListDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeploymentsRequest actualRequest = ((ListDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConfig.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    Deployment actualResponse = client.getDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeploymentRequest actualRequest = ((GetDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    Deployment actualResponse = client.getDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeploymentRequest actualRequest = ((GetDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfig.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse =
        client.createDeploymentAsync(parent, deployment, deploymentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentRequest actualRequest = ((CreateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertEquals(deploymentId, actualRequest.getDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeploymentAsync(parent, deployment, deploymentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(resultOperation);

    String parent = "parent-995424086";
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse =
        client.createDeploymentAsync(parent, deployment, deploymentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentRequest actualRequest = ((CreateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertEquals(deploymentId, actualRequest.getDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeploymentAsync(parent, deployment, deploymentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(resultOperation);

    Deployment deployment = Deployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Deployment actualResponse = client.updateDeploymentAsync(deployment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeploymentRequest actualRequest = ((UpdateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      Deployment deployment = Deployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeploymentAsync(deployment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(resultOperation);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    Deployment actualResponse = client.deleteDeploymentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeploymentRequest actualRequest = ((DeleteDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.deleteDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(resultOperation);

    String name = "name3373707";

    Deployment actualResponse = client.deleteDeploymentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeploymentRequest actualRequest = ((DeleteDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(expectedResponse);

    DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    ListRevisionsPagedResponse pagedListResponse = client.listRevisions(parent);

    List<Revision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRevisionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRevisionsRequest actualRequest = ((ListRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRevisionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRevisionsPagedResponse pagedListResponse = client.listRevisions(parent);

    List<Revision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRevisionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRevisionsRequest actualRequest = ((ListRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRevisionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConfig.addResponse(expectedResponse);

    RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");

    Revision actualResponse = client.getRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRevisionRequest actualRequest = ((GetRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    Revision actualResponse = client.getRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRevisionRequest actualRequest = ((GetRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRevisionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfig.addResponse(expectedResponse);

    ResourceName name =
        ResourceName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]");

    Resource actualResponse = client.getResource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceRequest actualRequest = ((GetResourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    Resource actualResponse = client.getResource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceRequest actualRequest = ((GetResourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfig.addResponse(expectedResponse);

    RevisionName parent = RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");

    ListResourcesPagedResponse pagedListResponse = client.listResources(parent);

    List<Resource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourcesRequest actualRequest = ((ListResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListResourcesPagedResponse pagedListResponse = client.listResources(parent);

    List<Resource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourcesRequest actualRequest = ((ListResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listResources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportDeploymentStatefileTest() throws Exception {
    Statefile expectedResponse = Statefile.newBuilder().setSignedUri("signedUri1076770992").build();
    mockConfig.addResponse(expectedResponse);

    ExportDeploymentStatefileRequest request =
        ExportDeploymentStatefileRequest.newBuilder()
            .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setDraft(true)
            .build();

    Statefile actualResponse = client.exportDeploymentStatefile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDeploymentStatefileRequest actualRequest =
        ((ExportDeploymentStatefileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDraft(), actualRequest.getDraft());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportDeploymentStatefileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    ExportRevisionStatefileRequest request =
        ExportRevisionStatefileRequest.newBuilder()
            .setParent(
                RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]").toString())
            .build();

    Statefile actualResponse = client.exportRevisionStatefile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportRevisionStatefileRequest actualRequest =
        ((ExportRevisionStatefileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportRevisionStatefileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    long lockId = 338696367;

    Statefile actualResponse = client.importStatefile(parent, lockId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportStatefileRequest actualRequest = ((ImportStatefileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(lockId, actualRequest.getLockId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importStatefileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String parent = "parent-995424086";
    long lockId = 338696367;

    Statefile actualResponse = client.importStatefile(parent, lockId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportStatefileRequest actualRequest = ((ImportStatefileRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(lockId, actualRequest.getLockId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importStatefileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConfig.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    client.deleteStatefile(name);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStatefileRequest actualRequest = ((DeleteStatefileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStatefileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteStatefile(name);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStatefileRequest actualRequest = ((DeleteStatefileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStatefileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
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
    mockConfig.addResponse(resultOperation);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    Deployment actualResponse = client.lockDeploymentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LockDeploymentRequest actualRequest = ((LockDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lockDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.lockDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(resultOperation);

    String name = "name3373707";

    Deployment actualResponse = client.lockDeploymentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LockDeploymentRequest actualRequest = ((LockDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lockDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
      client.lockDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(resultOperation);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    long lockId = 338696367;

    Deployment actualResponse = client.unlockDeploymentAsync(name, lockId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnlockDeploymentRequest actualRequest = ((UnlockDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(lockId, actualRequest.getLockId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unlockDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      long lockId = 338696367;
      client.unlockDeploymentAsync(name, lockId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(resultOperation);

    String name = "name3373707";
    long lockId = 338696367;

    Deployment actualResponse = client.unlockDeploymentAsync(name, lockId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnlockDeploymentRequest actualRequest = ((UnlockDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(lockId, actualRequest.getLockId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unlockDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
      long lockId = 338696367;
      client.unlockDeploymentAsync(name, lockId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockConfig.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    LockInfo actualResponse = client.exportLockInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportLockInfoRequest actualRequest = ((ExportLockInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportLockInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

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
    mockConfig.addResponse(expectedResponse);

    String name = "name3373707";

    LockInfo actualResponse = client.exportLockInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfig.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportLockInfoRequest actualRequest = ((ExportLockInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportLockInfoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfig.addException(exception);

    try {
      String name = "name3373707";
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
            .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
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
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
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
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
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
