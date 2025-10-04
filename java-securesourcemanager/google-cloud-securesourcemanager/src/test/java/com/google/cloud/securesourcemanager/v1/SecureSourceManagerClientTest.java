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

package com.google.cloud.securesourcemanager.v1;

import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.FetchTreePagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListBranchRulesPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListHooksPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListIssueCommentsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListIssuesPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListPullRequestCommentsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListPullRequestFileDiffsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListPullRequestsPagedResponse;
import static com.google.cloud.securesourcemanager.v1.SecureSourceManagerClient.ListRepositoriesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
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
public class SecureSourceManagerClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockSecureSourceManager mockSecureSourceManager;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SecureSourceManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSecureSourceManager = new MockSecureSourceManager();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSecureSourceManager, mockLocations, mockIAMPolicy));
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
    SecureSourceManagerSettings settings =
        SecureSourceManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecureSourceManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest2() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPrivateConfig(Instance.PrivateConfig.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .setHostConfig(Instance.HostConfig.newBuilder().build())
            .setWorkforceIdentityFederationConfig(
                Instance.WorkforceIdentityFederationConfig.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPrivateConfig(Instance.PrivateConfig.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .setHostConfig(Instance.HostConfig.newBuilder().build())
            .setWorkforceIdentityFederationConfig(
                Instance.WorkforceIdentityFederationConfig.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPrivateConfig(Instance.PrivateConfig.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .setHostConfig(Instance.HostConfig.newBuilder().build())
            .setWorkforceIdentityFederationConfig(
                Instance.WorkforceIdentityFederationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Instance instance = Instance.newBuilder().build();
      String instanceId = "instanceId902024336";
      client.createInstanceAsync(parent, instance, instanceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setPrivateConfig(Instance.PrivateConfig.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .setHostConfig(Instance.HostConfig.newBuilder().build())
            .setWorkforceIdentityFederationConfig(
                Instance.WorkforceIdentityFederationConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Instance instance = Instance.newBuilder().build();
      String instanceId = "instanceId902024336";
      client.createInstanceAsync(parent, instance, instanceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInstanceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listRepositoriesTest() throws Exception {
    Repository responsesElement = Repository.newBuilder().build();
    ListRepositoriesResponse expectedResponse =
        ListRepositoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRepositories(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRepositoriesPagedResponse pagedListResponse = client.listRepositories(parent);

    List<Repository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRepositoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRepositoriesRequest actualRequest = ((ListRepositoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRepositoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRepositories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRepositoriesTest2() throws Exception {
    Repository responsesElement = Repository.newBuilder().build();
    ListRepositoriesResponse expectedResponse =
        ListRepositoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRepositories(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRepositoriesPagedResponse pagedListResponse = client.listRepositories(parent);

    List<Repository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRepositoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRepositoriesRequest actualRequest = ((ListRepositoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRepositoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRepositories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRepositoryTest() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setUris(Repository.URIs.newBuilder().build())
            .setInitialConfig(Repository.InitialConfig.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    Repository actualResponse = client.getRepository(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRepositoryRequest actualRequest = ((GetRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRepositoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.getRepository(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRepositoryTest2() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setUris(Repository.URIs.newBuilder().build())
            .setInitialConfig(Repository.InitialConfig.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    Repository actualResponse = client.getRepository(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRepositoryRequest actualRequest = ((GetRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRepositoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.getRepository(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRepositoryTest() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setUris(Repository.URIs.newBuilder().build())
            .setInitialConfig(Repository.InitialConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Repository repository = Repository.newBuilder().build();
    String repositoryId = "repositoryId2113747461";

    Repository actualResponse =
        client.createRepositoryAsync(parent, repository, repositoryId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRepositoryRequest actualRequest = ((CreateRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(repository, actualRequest.getRepository());
    Assert.assertEquals(repositoryId, actualRequest.getRepositoryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRepositoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Repository repository = Repository.newBuilder().build();
      String repositoryId = "repositoryId2113747461";
      client.createRepositoryAsync(parent, repository, repositoryId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRepositoryTest2() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setUris(Repository.URIs.newBuilder().build())
            .setInitialConfig(Repository.InitialConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Repository repository = Repository.newBuilder().build();
    String repositoryId = "repositoryId2113747461";

    Repository actualResponse =
        client.createRepositoryAsync(parent, repository, repositoryId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRepositoryRequest actualRequest = ((CreateRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(repository, actualRequest.getRepository());
    Assert.assertEquals(repositoryId, actualRequest.getRepositoryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRepositoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Repository repository = Repository.newBuilder().build();
      String repositoryId = "repositoryId2113747461";
      client.createRepositoryAsync(parent, repository, repositoryId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateRepositoryTest() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setUris(Repository.URIs.newBuilder().build())
            .setInitialConfig(Repository.InitialConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    Repository repository = Repository.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Repository actualResponse = client.updateRepositoryAsync(repository, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRepositoryRequest actualRequest = ((UpdateRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(repository, actualRequest.getRepository());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRepositoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      Repository repository = Repository.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRepositoryAsync(repository, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRepositoryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    client.deleteRepositoryAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRepositoryRequest actualRequest = ((DeleteRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRepositoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.deleteRepositoryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRepositoryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRepositoryAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRepositoryRequest actualRequest = ((DeleteRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRepositoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRepositoryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listHooksTest() throws Exception {
    Hook responsesElement = Hook.newBuilder().build();
    ListHooksResponse expectedResponse =
        ListHooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllHooks(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListHooksPagedResponse pagedListResponse = client.listHooks(parent);

    List<Hook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHooksRequest actualRequest = ((ListHooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHooksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listHooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHooksTest2() throws Exception {
    Hook responsesElement = Hook.newBuilder().build();
    ListHooksResponse expectedResponse =
        ListHooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllHooks(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHooksPagedResponse pagedListResponse = client.listHooks(parent);

    List<Hook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHooksRequest actualRequest = ((ListHooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHooksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHookTest() throws Exception {
    Hook expectedResponse =
        Hook.newBuilder()
            .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
            .setTargetUri("targetUri-815585765")
            .setDisabled(true)
            .addAllEvents(new ArrayList<Hook.HookEventType>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setPushOption(Hook.PushOption.newBuilder().build())
            .setSensitiveQueryString("sensitiveQueryString-690213245")
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    HookName name = HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]");

    Hook actualResponse = client.getHook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHookRequest actualRequest = ((GetHookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      HookName name = HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]");
      client.getHook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHookTest2() throws Exception {
    Hook expectedResponse =
        Hook.newBuilder()
            .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
            .setTargetUri("targetUri-815585765")
            .setDisabled(true)
            .addAllEvents(new ArrayList<Hook.HookEventType>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setPushOption(Hook.PushOption.newBuilder().build())
            .setSensitiveQueryString("sensitiveQueryString-690213245")
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    Hook actualResponse = client.getHook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHookRequest actualRequest = ((GetHookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.getHook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHookTest() throws Exception {
    Hook expectedResponse =
        Hook.newBuilder()
            .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
            .setTargetUri("targetUri-815585765")
            .setDisabled(true)
            .addAllEvents(new ArrayList<Hook.HookEventType>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setPushOption(Hook.PushOption.newBuilder().build())
            .setSensitiveQueryString("sensitiveQueryString-690213245")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    Hook hook = Hook.newBuilder().build();
    String hookId = "hookId-1211612770";

    Hook actualResponse = client.createHookAsync(parent, hook, hookId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHookRequest actualRequest = ((CreateHookRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hook, actualRequest.getHook());
    Assert.assertEquals(hookId, actualRequest.getHookId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      Hook hook = Hook.newBuilder().build();
      String hookId = "hookId-1211612770";
      client.createHookAsync(parent, hook, hookId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createHookTest2() throws Exception {
    Hook expectedResponse =
        Hook.newBuilder()
            .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
            .setTargetUri("targetUri-815585765")
            .setDisabled(true)
            .addAllEvents(new ArrayList<Hook.HookEventType>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setPushOption(Hook.PushOption.newBuilder().build())
            .setSensitiveQueryString("sensitiveQueryString-690213245")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Hook hook = Hook.newBuilder().build();
    String hookId = "hookId-1211612770";

    Hook actualResponse = client.createHookAsync(parent, hook, hookId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHookRequest actualRequest = ((CreateHookRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hook, actualRequest.getHook());
    Assert.assertEquals(hookId, actualRequest.getHookId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Hook hook = Hook.newBuilder().build();
      String hookId = "hookId-1211612770";
      client.createHookAsync(parent, hook, hookId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateHookTest() throws Exception {
    Hook expectedResponse =
        Hook.newBuilder()
            .setName(HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]").toString())
            .setTargetUri("targetUri-815585765")
            .setDisabled(true)
            .addAllEvents(new ArrayList<Hook.HookEventType>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setPushOption(Hook.PushOption.newBuilder().build())
            .setSensitiveQueryString("sensitiveQueryString-690213245")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateHookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    Hook hook = Hook.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Hook actualResponse = client.updateHookAsync(hook, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHookRequest actualRequest = ((UpdateHookRequest) actualRequests.get(0));

    Assert.assertEquals(hook, actualRequest.getHook());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      Hook hook = Hook.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHookAsync(hook, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHookTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    HookName name = HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]");

    client.deleteHookAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHookRequest actualRequest = ((DeleteHookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      HookName name = HookName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[HOOK]");
      client.deleteHookAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteHookTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteHookAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHookRequest actualRequest = ((DeleteHookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHookAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getIamPolicyRepoTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    Policy actualResponse = client.getIamPolicyRepo(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyRepoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.getIamPolicyRepo(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyRepoTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicyRepo(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyRepoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicyRepo(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyRepoTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    Policy actualResponse = client.setIamPolicyRepo(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyRepoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.setIamPolicyRepo(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyRepoTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.setIamPolicyRepo(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyRepoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String resource = "resource-341064690";
      client.setIamPolicyRepo(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsRepoTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockSecureSourceManager.addResponse(expectedResponse);

    ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    TestIamPermissionsResponse actualResponse = client.testIamPermissionsRepo(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsRepoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      ResourceName resource = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.testIamPermissionsRepo(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsRepoTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String resource = "resource-341064690";

    TestIamPermissionsResponse actualResponse = client.testIamPermissionsRepo(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsRepoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String resource = "resource-341064690";
      client.testIamPermissionsRepo(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBranchRuleTest() throws Exception {
    BranchRule expectedResponse =
        BranchRule.newBuilder()
            .setName(
                BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setIncludePattern("includePattern-1431887416")
            .setDisabled(true)
            .setRequirePullRequest(true)
            .setMinimumReviewsCount(672799098)
            .setMinimumApprovalsCount(-579210129)
            .setRequireCommentsResolved(true)
            .setAllowStaleReviews(true)
            .setRequireLinearHistory(true)
            .addAllRequiredStatusChecks(new ArrayList<BranchRule.Check>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBranchRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    BranchRule branchRule = BranchRule.newBuilder().build();
    String branchRuleId = "branchRuleId-1052663431";

    BranchRule actualResponse =
        client.createBranchRuleAsync(parent, branchRule, branchRuleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBranchRuleRequest actualRequest = ((CreateBranchRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(branchRule, actualRequest.getBranchRule());
    Assert.assertEquals(branchRuleId, actualRequest.getBranchRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBranchRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      BranchRule branchRule = BranchRule.newBuilder().build();
      String branchRuleId = "branchRuleId-1052663431";
      client.createBranchRuleAsync(parent, branchRule, branchRuleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBranchRuleTest2() throws Exception {
    BranchRule expectedResponse =
        BranchRule.newBuilder()
            .setName(
                BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setIncludePattern("includePattern-1431887416")
            .setDisabled(true)
            .setRequirePullRequest(true)
            .setMinimumReviewsCount(672799098)
            .setMinimumApprovalsCount(-579210129)
            .setRequireCommentsResolved(true)
            .setAllowStaleReviews(true)
            .setRequireLinearHistory(true)
            .addAllRequiredStatusChecks(new ArrayList<BranchRule.Check>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBranchRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    BranchRule branchRule = BranchRule.newBuilder().build();
    String branchRuleId = "branchRuleId-1052663431";

    BranchRule actualResponse =
        client.createBranchRuleAsync(parent, branchRule, branchRuleId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBranchRuleRequest actualRequest = ((CreateBranchRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(branchRule, actualRequest.getBranchRule());
    Assert.assertEquals(branchRuleId, actualRequest.getBranchRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBranchRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      BranchRule branchRule = BranchRule.newBuilder().build();
      String branchRuleId = "branchRuleId-1052663431";
      client.createBranchRuleAsync(parent, branchRule, branchRuleId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listBranchRulesTest() throws Exception {
    BranchRule responsesElement = BranchRule.newBuilder().build();
    ListBranchRulesResponse expectedResponse =
        ListBranchRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBranchRules(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListBranchRulesPagedResponse pagedListResponse = client.listBranchRules(parent);

    List<BranchRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBranchRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBranchRulesRequest actualRequest = ((ListBranchRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBranchRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listBranchRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBranchRulesTest2() throws Exception {
    BranchRule responsesElement = BranchRule.newBuilder().build();
    ListBranchRulesResponse expectedResponse =
        ListBranchRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBranchRules(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBranchRulesPagedResponse pagedListResponse = client.listBranchRules(parent);

    List<BranchRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBranchRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBranchRulesRequest actualRequest = ((ListBranchRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBranchRulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBranchRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBranchRuleTest() throws Exception {
    BranchRule expectedResponse =
        BranchRule.newBuilder()
            .setName(
                BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setIncludePattern("includePattern-1431887416")
            .setDisabled(true)
            .setRequirePullRequest(true)
            .setMinimumReviewsCount(672799098)
            .setMinimumApprovalsCount(-579210129)
            .setRequireCommentsResolved(true)
            .setAllowStaleReviews(true)
            .setRequireLinearHistory(true)
            .addAllRequiredStatusChecks(new ArrayList<BranchRule.Check>())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    BranchRuleName name =
        BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]");

    BranchRule actualResponse = client.getBranchRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBranchRuleRequest actualRequest = ((GetBranchRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBranchRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      BranchRuleName name =
          BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]");
      client.getBranchRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBranchRuleTest2() throws Exception {
    BranchRule expectedResponse =
        BranchRule.newBuilder()
            .setName(
                BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setIncludePattern("includePattern-1431887416")
            .setDisabled(true)
            .setRequirePullRequest(true)
            .setMinimumReviewsCount(672799098)
            .setMinimumApprovalsCount(-579210129)
            .setRequireCommentsResolved(true)
            .setAllowStaleReviews(true)
            .setRequireLinearHistory(true)
            .addAllRequiredStatusChecks(new ArrayList<BranchRule.Check>())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    BranchRule actualResponse = client.getBranchRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBranchRuleRequest actualRequest = ((GetBranchRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBranchRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.getBranchRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBranchRuleTest() throws Exception {
    BranchRule expectedResponse =
        BranchRule.newBuilder()
            .setName(
                BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setIncludePattern("includePattern-1431887416")
            .setDisabled(true)
            .setRequirePullRequest(true)
            .setMinimumReviewsCount(672799098)
            .setMinimumApprovalsCount(-579210129)
            .setRequireCommentsResolved(true)
            .setAllowStaleReviews(true)
            .setRequireLinearHistory(true)
            .addAllRequiredStatusChecks(new ArrayList<BranchRule.Check>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBranchRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    BranchRule branchRule = BranchRule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BranchRule actualResponse = client.updateBranchRuleAsync(branchRule, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBranchRuleRequest actualRequest = ((UpdateBranchRuleRequest) actualRequests.get(0));

    Assert.assertEquals(branchRule, actualRequest.getBranchRule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBranchRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      BranchRule branchRule = BranchRule.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBranchRuleAsync(branchRule, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBranchRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBranchRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    BranchRuleName name =
        BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]");

    client.deleteBranchRuleAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBranchRuleRequest actualRequest = ((DeleteBranchRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBranchRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      BranchRuleName name =
          BranchRuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[BRANCH_RULE]");
      client.deleteBranchRuleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBranchRuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBranchRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBranchRuleAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBranchRuleRequest actualRequest = ((DeleteBranchRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBranchRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBranchRuleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPullRequestTest() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    PullRequest pullRequest = PullRequest.newBuilder().build();

    PullRequest actualResponse = client.createPullRequestAsync(parent, pullRequest).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePullRequestRequest actualRequest = ((CreatePullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(pullRequest, actualRequest.getPullRequest());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPullRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      PullRequest pullRequest = PullRequest.newBuilder().build();
      client.createPullRequestAsync(parent, pullRequest).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPullRequestTest2() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    PullRequest pullRequest = PullRequest.newBuilder().build();

    PullRequest actualResponse = client.createPullRequestAsync(parent, pullRequest).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePullRequestRequest actualRequest = ((CreatePullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(pullRequest, actualRequest.getPullRequest());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPullRequestExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      PullRequest pullRequest = PullRequest.newBuilder().build();
      client.createPullRequestAsync(parent, pullRequest).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getPullRequestTest() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    PullRequestName name =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");

    PullRequest actualResponse = client.getPullRequest(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPullRequestRequest actualRequest = ((GetPullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPullRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName name =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      client.getPullRequest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPullRequestTest2() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    PullRequest actualResponse = client.getPullRequest(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPullRequestRequest actualRequest = ((GetPullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPullRequestExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.getPullRequest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPullRequestsTest() throws Exception {
    PullRequest responsesElement = PullRequest.newBuilder().build();
    ListPullRequestsResponse expectedResponse =
        ListPullRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPullRequests(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListPullRequestsPagedResponse pagedListResponse = client.listPullRequests(parent);

    List<PullRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPullRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPullRequestsRequest actualRequest = ((ListPullRequestsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPullRequestsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listPullRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPullRequestsTest2() throws Exception {
    PullRequest responsesElement = PullRequest.newBuilder().build();
    ListPullRequestsResponse expectedResponse =
        ListPullRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPullRequests(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPullRequestsPagedResponse pagedListResponse = client.listPullRequests(parent);

    List<PullRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPullRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPullRequestsRequest actualRequest = ((ListPullRequestsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPullRequestsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPullRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePullRequestTest() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequest pullRequest = PullRequest.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PullRequest actualResponse = client.updatePullRequestAsync(pullRequest, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePullRequestRequest actualRequest = ((UpdatePullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(pullRequest, actualRequest.getPullRequest());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePullRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequest pullRequest = PullRequest.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePullRequestAsync(pullRequest, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void mergePullRequestTest() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("mergePullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestName name =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");

    PullRequest actualResponse = client.mergePullRequestAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergePullRequestRequest actualRequest = ((MergePullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergePullRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName name =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      client.mergePullRequestAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void mergePullRequestTest2() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("mergePullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    PullRequest actualResponse = client.mergePullRequestAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergePullRequestRequest actualRequest = ((MergePullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergePullRequestExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.mergePullRequestAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void openPullRequestTest() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("openPullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestName name =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");

    PullRequest actualResponse = client.openPullRequestAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    OpenPullRequestRequest actualRequest = ((OpenPullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void openPullRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName name =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      client.openPullRequestAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void openPullRequestTest2() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("openPullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    PullRequest actualResponse = client.openPullRequestAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    OpenPullRequestRequest actualRequest = ((OpenPullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void openPullRequestExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.openPullRequestAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void closePullRequestTest() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("closePullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestName name =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");

    PullRequest actualResponse = client.closePullRequestAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ClosePullRequestRequest actualRequest = ((ClosePullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void closePullRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName name =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      client.closePullRequestAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void closePullRequestTest2() throws Exception {
    PullRequest expectedResponse =
        PullRequest.newBuilder()
            .setName(
                PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]")
                    .toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setBase(PullRequest.Branch.newBuilder().build())
            .setHead(PullRequest.Branch.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("closePullRequestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    PullRequest actualResponse = client.closePullRequestAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ClosePullRequestRequest actualRequest = ((ClosePullRequestRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void closePullRequestExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.closePullRequestAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listPullRequestFileDiffsTest() throws Exception {
    FileDiff responsesElement = FileDiff.newBuilder().build();
    ListPullRequestFileDiffsResponse expectedResponse =
        ListPullRequestFileDiffsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFileDiffs(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    PullRequestName name =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");

    ListPullRequestFileDiffsPagedResponse pagedListResponse = client.listPullRequestFileDiffs(name);

    List<FileDiff> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFileDiffsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPullRequestFileDiffsRequest actualRequest =
        ((ListPullRequestFileDiffsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPullRequestFileDiffsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName name =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      client.listPullRequestFileDiffs(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPullRequestFileDiffsTest2() throws Exception {
    FileDiff responsesElement = FileDiff.newBuilder().build();
    ListPullRequestFileDiffsResponse expectedResponse =
        ListPullRequestFileDiffsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFileDiffs(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    ListPullRequestFileDiffsPagedResponse pagedListResponse = client.listPullRequestFileDiffs(name);

    List<FileDiff> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFileDiffsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPullRequestFileDiffsRequest actualRequest =
        ((ListPullRequestFileDiffsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPullRequestFileDiffsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.listPullRequestFileDiffs(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchTreeTest() throws Exception {
    TreeEntry responsesElement = TreeEntry.newBuilder().build();
    FetchTreeResponse expectedResponse =
        FetchTreeResponse.newBuilder()
            .setNextPageToken("")
            .addAllTreeEntries(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    FetchTreeRequest request =
        FetchTreeRequest.newBuilder()
            .setRepository(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setRef("ref112787")
            .setRecursive(true)
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    FetchTreePagedResponse pagedListResponse = client.fetchTree(request);

    List<TreeEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTreeEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchTreeRequest actualRequest = ((FetchTreeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getRepository(), actualRequest.getRepository());
    Assert.assertEquals(request.getRef(), actualRequest.getRef());
    Assert.assertEquals(request.getRecursive(), actualRequest.getRecursive());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchTreeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      FetchTreeRequest request =
          FetchTreeRequest.newBuilder()
              .setRepository(
                  RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .setRef("ref112787")
              .setRecursive(true)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.fetchTree(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchBlobTest() throws Exception {
    FetchBlobResponse expectedResponse =
        FetchBlobResponse.newBuilder().setSha("sha113836").setContent("content951530617").build();
    mockSecureSourceManager.addResponse(expectedResponse);

    FetchBlobRequest request =
        FetchBlobRequest.newBuilder()
            .setRepository(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setSha("sha113836")
            .build();

    FetchBlobResponse actualResponse = client.fetchBlob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchBlobRequest actualRequest = ((FetchBlobRequest) actualRequests.get(0));

    Assert.assertEquals(request.getRepository(), actualRequest.getRepository());
    Assert.assertEquals(request.getSha(), actualRequest.getSha());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchBlobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      FetchBlobRequest request =
          FetchBlobRequest.newBuilder()
              .setRepository(
                  RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .setSha("sha113836")
              .build();
      client.fetchBlob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIssueTest() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    Issue issue = Issue.newBuilder().build();

    Issue actualResponse = client.createIssueAsync(parent, issue).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIssueRequest actualRequest = ((CreateIssueRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(issue, actualRequest.getIssue());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      Issue issue = Issue.newBuilder().build();
      client.createIssueAsync(parent, issue).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createIssueTest2() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Issue issue = Issue.newBuilder().build();

    Issue actualResponse = client.createIssueAsync(parent, issue).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIssueRequest actualRequest = ((CreateIssueRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(issue, actualRequest.getIssue());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIssueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Issue issue = Issue.newBuilder().build();
      client.createIssueAsync(parent, issue).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getIssueTest() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");

    Issue actualResponse = client.getIssue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIssueRequest actualRequest = ((GetIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
      client.getIssue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIssueTest2() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    Issue actualResponse = client.getIssue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIssueRequest actualRequest = ((GetIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIssueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.getIssue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIssuesTest() throws Exception {
    Issue responsesElement = Issue.newBuilder().build();
    ListIssuesResponse expectedResponse =
        ListIssuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIssues(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListIssuesPagedResponse pagedListResponse = client.listIssues(parent);

    List<Issue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIssuesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIssuesRequest actualRequest = ((ListIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIssuesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listIssues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIssuesTest2() throws Exception {
    Issue responsesElement = Issue.newBuilder().build();
    ListIssuesResponse expectedResponse =
        ListIssuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIssues(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIssuesPagedResponse pagedListResponse = client.listIssues(parent);

    List<Issue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIssuesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIssuesRequest actualRequest = ((ListIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIssuesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIssues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIssueTest() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    Issue issue = Issue.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Issue actualResponse = client.updateIssueAsync(issue, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIssueRequest actualRequest = ((UpdateIssueRequest) actualRequests.get(0));

    Assert.assertEquals(issue, actualRequest.getIssue());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      Issue issue = Issue.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIssueAsync(issue, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIssueTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");

    client.deleteIssueAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIssueRequest actualRequest = ((DeleteIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
      client.deleteIssueAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIssueTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIssueAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIssueRequest actualRequest = ((DeleteIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIssueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIssueAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void openIssueTest() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("openIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");

    Issue actualResponse = client.openIssueAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    OpenIssueRequest actualRequest = ((OpenIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void openIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
      client.openIssueAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void openIssueTest2() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("openIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    Issue actualResponse = client.openIssueAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    OpenIssueRequest actualRequest = ((OpenIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void openIssueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.openIssueAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void closeIssueTest() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("closeIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");

    Issue actualResponse = client.closeIssueAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CloseIssueRequest actualRequest = ((CloseIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void closeIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
      client.closeIssueAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void closeIssueTest2() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]").toString())
            .setTitle("title110371416")
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloseTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("closeIssueTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    Issue actualResponse = client.closeIssueAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CloseIssueRequest actualRequest = ((CloseIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void closeIssueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.closeIssueAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getPullRequestCommentTest() throws Exception {
    PullRequestComment expectedResponse =
        PullRequestComment.newBuilder()
            .setName(
                PullRequestCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    PullRequestCommentName name =
        PullRequestCommentName.of(
            "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]");

    PullRequestComment actualResponse = client.getPullRequestComment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPullRequestCommentRequest actualRequest =
        ((GetPullRequestCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPullRequestCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestCommentName name =
          PullRequestCommentName.of(
              "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]");
      client.getPullRequestComment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPullRequestCommentTest2() throws Exception {
    PullRequestComment expectedResponse =
        PullRequestComment.newBuilder()
            .setName(
                PullRequestCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    PullRequestComment actualResponse = client.getPullRequestComment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPullRequestCommentRequest actualRequest =
        ((GetPullRequestCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPullRequestCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.getPullRequestComment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPullRequestCommentsTest() throws Exception {
    PullRequestComment responsesElement = PullRequestComment.newBuilder().build();
    ListPullRequestCommentsResponse expectedResponse =
        ListPullRequestCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPullRequestComments(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    PullRequestName parent =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");

    ListPullRequestCommentsPagedResponse pagedListResponse = client.listPullRequestComments(parent);

    List<PullRequestComment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPullRequestCommentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPullRequestCommentsRequest actualRequest =
        ((ListPullRequestCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPullRequestCommentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName parent =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      client.listPullRequestComments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPullRequestCommentsTest2() throws Exception {
    PullRequestComment responsesElement = PullRequestComment.newBuilder().build();
    ListPullRequestCommentsResponse expectedResponse =
        ListPullRequestCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPullRequestComments(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPullRequestCommentsPagedResponse pagedListResponse = client.listPullRequestComments(parent);

    List<PullRequestComment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPullRequestCommentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPullRequestCommentsRequest actualRequest =
        ((ListPullRequestCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPullRequestCommentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPullRequestComments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPullRequestCommentTest() throws Exception {
    PullRequestComment expectedResponse =
        PullRequestComment.newBuilder()
            .setName(
                PullRequestCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPullRequestCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestName parent =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
    PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();

    PullRequestComment actualResponse =
        client.createPullRequestCommentAsync(parent, pullRequestComment).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePullRequestCommentRequest actualRequest =
        ((CreatePullRequestCommentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(pullRequestComment, actualRequest.getPullRequestComment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPullRequestCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName parent =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();
      client.createPullRequestCommentAsync(parent, pullRequestComment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPullRequestCommentTest2() throws Exception {
    PullRequestComment expectedResponse =
        PullRequestComment.newBuilder()
            .setName(
                PullRequestCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPullRequestCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();

    PullRequestComment actualResponse =
        client.createPullRequestCommentAsync(parent, pullRequestComment).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePullRequestCommentRequest actualRequest =
        ((CreatePullRequestCommentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(pullRequestComment, actualRequest.getPullRequestComment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPullRequestCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();
      client.createPullRequestCommentAsync(parent, pullRequestComment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updatePullRequestCommentTest() throws Exception {
    PullRequestComment expectedResponse =
        PullRequestComment.newBuilder()
            .setName(
                PullRequestCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePullRequestCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PullRequestComment actualResponse =
        client.updatePullRequestCommentAsync(pullRequestComment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePullRequestCommentRequest actualRequest =
        ((UpdatePullRequestCommentRequest) actualRequests.get(0));

    Assert.assertEquals(pullRequestComment, actualRequest.getPullRequestComment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePullRequestCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestComment pullRequestComment = PullRequestComment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePullRequestCommentAsync(pullRequestComment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePullRequestCommentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePullRequestCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestCommentName name =
        PullRequestCommentName.of(
            "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]");

    client.deletePullRequestCommentAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePullRequestCommentRequest actualRequest =
        ((DeletePullRequestCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePullRequestCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestCommentName name =
          PullRequestCommentName.of(
              "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]", "[COMMENT]");
      client.deletePullRequestCommentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePullRequestCommentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePullRequestCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePullRequestCommentAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePullRequestCommentRequest actualRequest =
        ((DeletePullRequestCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePullRequestCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.deletePullRequestCommentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchCreatePullRequestCommentsTest() throws Exception {
    BatchCreatePullRequestCommentsResponse expectedResponse =
        BatchCreatePullRequestCommentsResponse.newBuilder()
            .addAllPullRequestComments(new ArrayList<PullRequestComment>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreatePullRequestCommentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestName parent =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
    List<CreatePullRequestCommentRequest> requests = new ArrayList<>();

    BatchCreatePullRequestCommentsResponse actualResponse =
        client.batchCreatePullRequestCommentsAsync(parent, requests).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreatePullRequestCommentsRequest actualRequest =
        ((BatchCreatePullRequestCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreatePullRequestCommentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName parent =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      List<CreatePullRequestCommentRequest> requests = new ArrayList<>();
      client.batchCreatePullRequestCommentsAsync(parent, requests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchCreatePullRequestCommentsTest2() throws Exception {
    BatchCreatePullRequestCommentsResponse expectedResponse =
        BatchCreatePullRequestCommentsResponse.newBuilder()
            .addAllPullRequestComments(new ArrayList<PullRequestComment>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreatePullRequestCommentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<CreatePullRequestCommentRequest> requests = new ArrayList<>();

    BatchCreatePullRequestCommentsResponse actualResponse =
        client.batchCreatePullRequestCommentsAsync(parent, requests).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreatePullRequestCommentsRequest actualRequest =
        ((BatchCreatePullRequestCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreatePullRequestCommentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      List<CreatePullRequestCommentRequest> requests = new ArrayList<>();
      client.batchCreatePullRequestCommentsAsync(parent, requests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resolvePullRequestCommentsTest() throws Exception {
    ResolvePullRequestCommentsResponse expectedResponse =
        ResolvePullRequestCommentsResponse.newBuilder()
            .addAllPullRequestComments(new ArrayList<PullRequestComment>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resolvePullRequestCommentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestName parent =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
    List<String> names = new ArrayList<>();

    ResolvePullRequestCommentsResponse actualResponse =
        client.resolvePullRequestCommentsAsync(parent, names).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResolvePullRequestCommentsRequest actualRequest =
        ((ResolvePullRequestCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resolvePullRequestCommentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName parent =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      List<String> names = new ArrayList<>();
      client.resolvePullRequestCommentsAsync(parent, names).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resolvePullRequestCommentsTest2() throws Exception {
    ResolvePullRequestCommentsResponse expectedResponse =
        ResolvePullRequestCommentsResponse.newBuilder()
            .addAllPullRequestComments(new ArrayList<PullRequestComment>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resolvePullRequestCommentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<String> names = new ArrayList<>();

    ResolvePullRequestCommentsResponse actualResponse =
        client.resolvePullRequestCommentsAsync(parent, names).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResolvePullRequestCommentsRequest actualRequest =
        ((ResolvePullRequestCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resolvePullRequestCommentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> names = new ArrayList<>();
      client.resolvePullRequestCommentsAsync(parent, names).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void unresolvePullRequestCommentsTest() throws Exception {
    UnresolvePullRequestCommentsResponse expectedResponse =
        UnresolvePullRequestCommentsResponse.newBuilder()
            .addAllPullRequestComments(new ArrayList<PullRequestComment>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("unresolvePullRequestCommentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    PullRequestName parent =
        PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
    List<String> names = new ArrayList<>();

    UnresolvePullRequestCommentsResponse actualResponse =
        client.unresolvePullRequestCommentsAsync(parent, names).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnresolvePullRequestCommentsRequest actualRequest =
        ((UnresolvePullRequestCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unresolvePullRequestCommentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      PullRequestName parent =
          PullRequestName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PULL_REQUEST]");
      List<String> names = new ArrayList<>();
      client.unresolvePullRequestCommentsAsync(parent, names).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void unresolvePullRequestCommentsTest2() throws Exception {
    UnresolvePullRequestCommentsResponse expectedResponse =
        UnresolvePullRequestCommentsResponse.newBuilder()
            .addAllPullRequestComments(new ArrayList<PullRequestComment>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("unresolvePullRequestCommentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<String> names = new ArrayList<>();

    UnresolvePullRequestCommentsResponse actualResponse =
        client.unresolvePullRequestCommentsAsync(parent, names).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnresolvePullRequestCommentsRequest actualRequest =
        ((UnresolvePullRequestCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unresolvePullRequestCommentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> names = new ArrayList<>();
      client.unresolvePullRequestCommentsAsync(parent, names).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createIssueCommentTest() throws Exception {
    IssueComment expectedResponse =
        IssueComment.newBuilder()
            .setName(
                IssueCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
                    .toString())
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIssueCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    IssueName parent = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
    IssueComment issueComment = IssueComment.newBuilder().build();

    IssueComment actualResponse = client.createIssueCommentAsync(parent, issueComment).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIssueCommentRequest actualRequest = ((CreateIssueCommentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(issueComment, actualRequest.getIssueComment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIssueCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueName parent = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
      IssueComment issueComment = IssueComment.newBuilder().build();
      client.createIssueCommentAsync(parent, issueComment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createIssueCommentTest2() throws Exception {
    IssueComment expectedResponse =
        IssueComment.newBuilder()
            .setName(
                IssueCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
                    .toString())
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIssueCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    IssueComment issueComment = IssueComment.newBuilder().build();

    IssueComment actualResponse = client.createIssueCommentAsync(parent, issueComment).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIssueCommentRequest actualRequest = ((CreateIssueCommentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(issueComment, actualRequest.getIssueComment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIssueCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      IssueComment issueComment = IssueComment.newBuilder().build();
      client.createIssueCommentAsync(parent, issueComment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getIssueCommentTest() throws Exception {
    IssueComment expectedResponse =
        IssueComment.newBuilder()
            .setName(
                IssueCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
                    .toString())
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    IssueCommentName name =
        IssueCommentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]");

    IssueComment actualResponse = client.getIssueComment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIssueCommentRequest actualRequest = ((GetIssueCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIssueCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueCommentName name =
          IssueCommentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]");
      client.getIssueComment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIssueCommentTest2() throws Exception {
    IssueComment expectedResponse =
        IssueComment.newBuilder()
            .setName(
                IssueCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
                    .toString())
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String name = "name3373707";

    IssueComment actualResponse = client.getIssueComment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIssueCommentRequest actualRequest = ((GetIssueCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIssueCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.getIssueComment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIssueCommentsTest() throws Exception {
    IssueComment responsesElement = IssueComment.newBuilder().build();
    ListIssueCommentsResponse expectedResponse =
        ListIssueCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIssueComments(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    IssueName parent = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");

    ListIssueCommentsPagedResponse pagedListResponse = client.listIssueComments(parent);

    List<IssueComment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIssueCommentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIssueCommentsRequest actualRequest = ((ListIssueCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIssueCommentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueName parent = IssueName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]");
      client.listIssueComments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIssueCommentsTest2() throws Exception {
    IssueComment responsesElement = IssueComment.newBuilder().build();
    ListIssueCommentsResponse expectedResponse =
        ListIssueCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIssueComments(Arrays.asList(responsesElement))
            .build();
    mockSecureSourceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIssueCommentsPagedResponse pagedListResponse = client.listIssueComments(parent);

    List<IssueComment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIssueCommentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIssueCommentsRequest actualRequest = ((ListIssueCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIssueCommentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIssueComments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIssueCommentTest() throws Exception {
    IssueComment expectedResponse =
        IssueComment.newBuilder()
            .setName(
                IssueCommentName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]")
                    .toString())
            .setBody("body3029410")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateIssueCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    IssueComment issueComment = IssueComment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IssueComment actualResponse = client.updateIssueCommentAsync(issueComment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIssueCommentRequest actualRequest = ((UpdateIssueCommentRequest) actualRequests.get(0));

    Assert.assertEquals(issueComment, actualRequest.getIssueComment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIssueCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueComment issueComment = IssueComment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIssueCommentAsync(issueComment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIssueCommentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIssueCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    IssueCommentName name =
        IssueCommentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]");

    client.deleteIssueCommentAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIssueCommentRequest actualRequest = ((DeleteIssueCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIssueCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      IssueCommentName name =
          IssueCommentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ISSUE]", "[COMMENT]");
      client.deleteIssueCommentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIssueCommentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIssueCommentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecureSourceManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIssueCommentAsync(name).get();

    List<AbstractMessage> actualRequests = mockSecureSourceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIssueCommentRequest actualRequest = ((DeleteIssueCommentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIssueCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecureSourceManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIssueCommentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
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
              .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
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
            .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
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
              .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
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
            .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
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
              .setResource(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
