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

package com.google.cloud.dataform.v1beta1;

import static com.google.cloud.dataform.v1beta1.DataformClient.ListCompilationResultsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListLocationsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListRepositoriesPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListWorkflowInvocationsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListWorkspacesPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryCompilationResultActionsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryWorkflowInvocationActionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.type.Interval;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DataformClientTest {
  private static MockDataform mockDataform;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataformClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataform = new MockDataform();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataform, mockLocations, mockIAMPolicy));
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
    DataformSettings settings =
        DataformSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataformClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listRepositoriesTest() throws Exception {
    Repository responsesElement = Repository.newBuilder().build();
    ListRepositoriesResponse expectedResponse =
        ListRepositoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRepositories(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRepositoriesPagedResponse pagedListResponse = client.listRepositories(parent);

    List<Repository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRepositoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

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
    mockDataform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRepositoriesPagedResponse pagedListResponse = client.listRepositories(parent);

    List<Repository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRepositoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

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
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    Repository actualResponse = client.getRepository(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

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
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    String name = "name3373707";

    Repository actualResponse = client.getRepository(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

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
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Repository repository = Repository.newBuilder().build();
    String repositoryId = "repositoryId2113747461";

    Repository actualResponse = client.createRepository(parent, repository, repositoryId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Repository repository = Repository.newBuilder().build();
      String repositoryId = "repositoryId2113747461";
      client.createRepository(parent, repository, repositoryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRepositoryTest2() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Repository repository = Repository.newBuilder().build();
    String repositoryId = "repositoryId2113747461";

    Repository actualResponse = client.createRepository(parent, repository, repositoryId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

    try {
      String parent = "parent-995424086";
      Repository repository = Repository.newBuilder().build();
      String repositoryId = "repositoryId2113747461";
      client.createRepository(parent, repository, repositoryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRepositoryTest() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    Repository repository = Repository.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Repository actualResponse = client.updateRepository(repository, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

    try {
      Repository repository = Repository.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRepository(repository, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRepositoryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    client.deleteRepository(name);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

    try {
      RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.deleteRepository(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRepositoryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRepository(name);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
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
    mockDataform.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRepository(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchRemoteBranchesTest() throws Exception {
    FetchRemoteBranchesResponse expectedResponse =
        FetchRemoteBranchesResponse.newBuilder().addAllBranches(new ArrayList<String>()).build();
    mockDataform.addResponse(expectedResponse);

    FetchRemoteBranchesRequest request =
        FetchRemoteBranchesRequest.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .build();

    FetchRemoteBranchesResponse actualResponse = client.fetchRemoteBranches(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchRemoteBranchesRequest actualRequest = ((FetchRemoteBranchesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchRemoteBranchesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      FetchRemoteBranchesRequest request =
          FetchRemoteBranchesRequest.newBuilder()
              .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .build();
      client.fetchRemoteBranches(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkspacesTest() throws Exception {
    Workspace responsesElement = Workspace.newBuilder().build();
    ListWorkspacesResponse expectedResponse =
        ListWorkspacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkspaces(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListWorkspacesPagedResponse pagedListResponse = client.listWorkspaces(parent);

    List<Workspace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkspacesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkspacesRequest actualRequest = ((ListWorkspacesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkspacesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listWorkspaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkspacesTest2() throws Exception {
    Workspace responsesElement = Workspace.newBuilder().build();
    ListWorkspacesResponse expectedResponse =
        ListWorkspacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkspaces(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkspacesPagedResponse pagedListResponse = client.listWorkspaces(parent);

    List<Workspace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkspacesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkspacesRequest actualRequest = ((ListWorkspacesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkspacesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkspaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkspaceTest() throws Exception {
    Workspace expectedResponse =
        Workspace.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .build();
    mockDataform.addResponse(expectedResponse);

    WorkspaceName name = WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]");

    Workspace actualResponse = client.getWorkspace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkspaceRequest actualRequest = ((GetWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      WorkspaceName name =
          WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]");
      client.getWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkspaceTest2() throws Exception {
    Workspace expectedResponse =
        Workspace.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .build();
    mockDataform.addResponse(expectedResponse);

    String name = "name3373707";

    Workspace actualResponse = client.getWorkspace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkspaceRequest actualRequest = ((GetWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkspaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String name = "name3373707";
      client.getWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkspaceTest() throws Exception {
    Workspace expectedResponse =
        Workspace.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .build();
    mockDataform.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    Workspace workspace = Workspace.newBuilder().build();
    String workspaceId = "workspaceId466560144";

    Workspace actualResponse = client.createWorkspace(parent, workspace, workspaceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkspaceRequest actualRequest = ((CreateWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workspace, actualRequest.getWorkspace());
    Assert.assertEquals(workspaceId, actualRequest.getWorkspaceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      Workspace workspace = Workspace.newBuilder().build();
      String workspaceId = "workspaceId466560144";
      client.createWorkspace(parent, workspace, workspaceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkspaceTest2() throws Exception {
    Workspace expectedResponse =
        Workspace.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .build();
    mockDataform.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Workspace workspace = Workspace.newBuilder().build();
    String workspaceId = "workspaceId466560144";

    Workspace actualResponse = client.createWorkspace(parent, workspace, workspaceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkspaceRequest actualRequest = ((CreateWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workspace, actualRequest.getWorkspace());
    Assert.assertEquals(workspaceId, actualRequest.getWorkspaceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkspaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String parent = "parent-995424086";
      Workspace workspace = Workspace.newBuilder().build();
      String workspaceId = "workspaceId466560144";
      client.createWorkspace(parent, workspace, workspaceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkspaceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    WorkspaceName name = WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]");

    client.deleteWorkspace(name);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkspaceRequest actualRequest = ((DeleteWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      WorkspaceName name =
          WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]");
      client.deleteWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkspaceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteWorkspace(name);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkspaceRequest actualRequest = ((DeleteWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkspaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void installNpmPackagesTest() throws Exception {
    InstallNpmPackagesResponse expectedResponse = InstallNpmPackagesResponse.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    InstallNpmPackagesRequest request =
        InstallNpmPackagesRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .build();

    InstallNpmPackagesResponse actualResponse = client.installNpmPackages(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InstallNpmPackagesRequest actualRequest = ((InstallNpmPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void installNpmPackagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      InstallNpmPackagesRequest request =
          InstallNpmPackagesRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .build();
      client.installNpmPackages(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pullGitCommitsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    PullGitCommitsRequest request =
        PullGitCommitsRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setRemoteBranch("remoteBranch-533119608")
            .setAuthor(CommitAuthor.newBuilder().build())
            .build();

    client.pullGitCommits(request);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PullGitCommitsRequest actualRequest = ((PullGitCommitsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRemoteBranch(), actualRequest.getRemoteBranch());
    Assert.assertEquals(request.getAuthor(), actualRequest.getAuthor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pullGitCommitsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      PullGitCommitsRequest request =
          PullGitCommitsRequest.newBuilder()
              .setName(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setRemoteBranch("remoteBranch-533119608")
              .setAuthor(CommitAuthor.newBuilder().build())
              .build();
      client.pullGitCommits(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pushGitCommitsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    PushGitCommitsRequest request =
        PushGitCommitsRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setRemoteBranch("remoteBranch-533119608")
            .build();

    client.pushGitCommits(request);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PushGitCommitsRequest actualRequest = ((PushGitCommitsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRemoteBranch(), actualRequest.getRemoteBranch());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pushGitCommitsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      PushGitCommitsRequest request =
          PushGitCommitsRequest.newBuilder()
              .setName(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setRemoteBranch("remoteBranch-533119608")
              .build();
      client.pushGitCommits(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchFileGitStatusesTest() throws Exception {
    FetchFileGitStatusesResponse expectedResponse =
        FetchFileGitStatusesResponse.newBuilder()
            .addAllUncommittedFileChanges(
                new ArrayList<FetchFileGitStatusesResponse.UncommittedFileChange>())
            .build();
    mockDataform.addResponse(expectedResponse);

    FetchFileGitStatusesRequest request =
        FetchFileGitStatusesRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .build();

    FetchFileGitStatusesResponse actualResponse = client.fetchFileGitStatuses(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchFileGitStatusesRequest actualRequest =
        ((FetchFileGitStatusesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchFileGitStatusesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      FetchFileGitStatusesRequest request =
          FetchFileGitStatusesRequest.newBuilder()
              .setName(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .build();
      client.fetchFileGitStatuses(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchGitAheadBehindTest() throws Exception {
    FetchGitAheadBehindResponse expectedResponse =
        FetchGitAheadBehindResponse.newBuilder()
            .setCommitsAhead(1216483806)
            .setCommitsBehind(-917751619)
            .build();
    mockDataform.addResponse(expectedResponse);

    FetchGitAheadBehindRequest request =
        FetchGitAheadBehindRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setRemoteBranch("remoteBranch-533119608")
            .build();

    FetchGitAheadBehindResponse actualResponse = client.fetchGitAheadBehind(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchGitAheadBehindRequest actualRequest = ((FetchGitAheadBehindRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRemoteBranch(), actualRequest.getRemoteBranch());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchGitAheadBehindExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      FetchGitAheadBehindRequest request =
          FetchGitAheadBehindRequest.newBuilder()
              .setName(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setRemoteBranch("remoteBranch-533119608")
              .build();
      client.fetchGitAheadBehind(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitWorkspaceChangesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    CommitWorkspaceChangesRequest request =
        CommitWorkspaceChangesRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setAuthor(CommitAuthor.newBuilder().build())
            .setCommitMessage("commitMessage2039804624")
            .addAllPaths(new ArrayList<String>())
            .build();

    client.commitWorkspaceChanges(request);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitWorkspaceChangesRequest actualRequest =
        ((CommitWorkspaceChangesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAuthor(), actualRequest.getAuthor());
    Assert.assertEquals(request.getCommitMessage(), actualRequest.getCommitMessage());
    Assert.assertEquals(request.getPathsList(), actualRequest.getPathsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitWorkspaceChangesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      CommitWorkspaceChangesRequest request =
          CommitWorkspaceChangesRequest.newBuilder()
              .setName(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setAuthor(CommitAuthor.newBuilder().build())
              .setCommitMessage("commitMessage2039804624")
              .addAllPaths(new ArrayList<String>())
              .build();
      client.commitWorkspaceChanges(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetWorkspaceChangesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    ResetWorkspaceChangesRequest request =
        ResetWorkspaceChangesRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .addAllPaths(new ArrayList<String>())
            .setClean(true)
            .build();

    client.resetWorkspaceChanges(request);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetWorkspaceChangesRequest actualRequest =
        ((ResetWorkspaceChangesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getPathsList(), actualRequest.getPathsList());
    Assert.assertEquals(request.getClean(), actualRequest.getClean());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetWorkspaceChangesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      ResetWorkspaceChangesRequest request =
          ResetWorkspaceChangesRequest.newBuilder()
              .setName(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .addAllPaths(new ArrayList<String>())
              .setClean(true)
              .build();
      client.resetWorkspaceChanges(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchFileDiffTest() throws Exception {
    FetchFileDiffResponse expectedResponse =
        FetchFileDiffResponse.newBuilder().setFormattedDiff("formattedDiff-1717800223").build();
    mockDataform.addResponse(expectedResponse);

    FetchFileDiffRequest request =
        FetchFileDiffRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    FetchFileDiffResponse actualResponse = client.fetchFileDiff(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchFileDiffRequest actualRequest = ((FetchFileDiffRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchFileDiffExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      FetchFileDiffRequest request =
          FetchFileDiffRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .build();
      client.fetchFileDiff(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryDirectoryContentsTest() throws Exception {
    QueryDirectoryContentsResponse.DirectoryEntry responsesElement =
        QueryDirectoryContentsResponse.DirectoryEntry.newBuilder().build();
    QueryDirectoryContentsResponse expectedResponse =
        QueryDirectoryContentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDirectoryEntries(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    QueryDirectoryContentsRequest request =
        QueryDirectoryContentsRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    QueryDirectoryContentsPagedResponse pagedListResponse = client.queryDirectoryContents(request);

    List<QueryDirectoryContentsResponse.DirectoryEntry> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDirectoryEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryDirectoryContentsRequest actualRequest =
        ((QueryDirectoryContentsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryDirectoryContentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      QueryDirectoryContentsRequest request =
          QueryDirectoryContentsRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.queryDirectoryContents(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void makeDirectoryTest() throws Exception {
    MakeDirectoryResponse expectedResponse = MakeDirectoryResponse.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    MakeDirectoryRequest request =
        MakeDirectoryRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    MakeDirectoryResponse actualResponse = client.makeDirectory(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MakeDirectoryRequest actualRequest = ((MakeDirectoryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void makeDirectoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      MakeDirectoryRequest request =
          MakeDirectoryRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .build();
      client.makeDirectory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeDirectoryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    RemoveDirectoryRequest request =
        RemoveDirectoryRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    client.removeDirectory(request);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveDirectoryRequest actualRequest = ((RemoveDirectoryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeDirectoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      RemoveDirectoryRequest request =
          RemoveDirectoryRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .build();
      client.removeDirectory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveDirectoryTest() throws Exception {
    MoveDirectoryResponse expectedResponse = MoveDirectoryResponse.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    MoveDirectoryRequest request =
        MoveDirectoryRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .setNewPath("newPath1845080549")
            .build();

    MoveDirectoryResponse actualResponse = client.moveDirectory(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveDirectoryRequest actualRequest = ((MoveDirectoryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertEquals(request.getNewPath(), actualRequest.getNewPath());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveDirectoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      MoveDirectoryRequest request =
          MoveDirectoryRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .setNewPath("newPath1845080549")
              .build();
      client.moveDirectory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readFileTest() throws Exception {
    ReadFileResponse expectedResponse =
        ReadFileResponse.newBuilder().setFileContents(ByteString.EMPTY).build();
    mockDataform.addResponse(expectedResponse);

    ReadFileRequest request =
        ReadFileRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    ReadFileResponse actualResponse = client.readFile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadFileRequest actualRequest = ((ReadFileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      ReadFileRequest request =
          ReadFileRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .build();
      client.readFile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeFileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    RemoveFileRequest request =
        RemoveFileRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    client.removeFile(request);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveFileRequest actualRequest = ((RemoveFileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      RemoveFileRequest request =
          RemoveFileRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .build();
      client.removeFile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveFileTest() throws Exception {
    MoveFileResponse expectedResponse = MoveFileResponse.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    MoveFileRequest request =
        MoveFileRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .setNewPath("newPath1845080549")
            .build();

    MoveFileResponse actualResponse = client.moveFile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveFileRequest actualRequest = ((MoveFileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertEquals(request.getNewPath(), actualRequest.getNewPath());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      MoveFileRequest request =
          MoveFileRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .setNewPath("newPath1845080549")
              .build();
      client.moveFile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void writeFileTest() throws Exception {
    WriteFileResponse expectedResponse = WriteFileResponse.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    WriteFileRequest request =
        WriteFileRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .setContents(ByteString.EMPTY)
            .build();

    WriteFileResponse actualResponse = client.writeFile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteFileRequest actualRequest = ((WriteFileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWorkspace(), actualRequest.getWorkspace());
    Assert.assertEquals(request.getPath(), actualRequest.getPath());
    Assert.assertEquals(request.getContents(), actualRequest.getContents());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void writeFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      WriteFileRequest request =
          WriteFileRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPath("path3433509")
              .setContents(ByteString.EMPTY)
              .build();
      client.writeFile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompilationResultsTest() throws Exception {
    CompilationResult responsesElement = CompilationResult.newBuilder().build();
    ListCompilationResultsResponse expectedResponse =
        ListCompilationResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompilationResults(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListCompilationResultsPagedResponse pagedListResponse = client.listCompilationResults(parent);

    List<CompilationResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompilationResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCompilationResultsRequest actualRequest =
        ((ListCompilationResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCompilationResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listCompilationResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompilationResultsTest2() throws Exception {
    CompilationResult responsesElement = CompilationResult.newBuilder().build();
    ListCompilationResultsResponse expectedResponse =
        ListCompilationResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompilationResults(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCompilationResultsPagedResponse pagedListResponse = client.listCompilationResults(parent);

    List<CompilationResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompilationResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCompilationResultsRequest actualRequest =
        ((ListCompilationResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCompilationResultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCompilationResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompilationResultTest() throws Exception {
    CompilationResult expectedResponse =
        CompilationResult.newBuilder()
            .setName(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setCodeCompilationConfig(CompilationResult.CodeCompilationConfig.newBuilder().build())
            .setDataformCoreVersion("dataformCoreVersion1859535851")
            .addAllCompilationErrors(new ArrayList<CompilationResult.CompilationError>())
            .build();
    mockDataform.addResponse(expectedResponse);

    CompilationResultName name =
        CompilationResultName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]");

    CompilationResult actualResponse = client.getCompilationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompilationResultRequest actualRequest =
        ((GetCompilationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCompilationResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      CompilationResultName name =
          CompilationResultName.of(
              "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]");
      client.getCompilationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompilationResultTest2() throws Exception {
    CompilationResult expectedResponse =
        CompilationResult.newBuilder()
            .setName(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setCodeCompilationConfig(CompilationResult.CodeCompilationConfig.newBuilder().build())
            .setDataformCoreVersion("dataformCoreVersion1859535851")
            .addAllCompilationErrors(new ArrayList<CompilationResult.CompilationError>())
            .build();
    mockDataform.addResponse(expectedResponse);

    String name = "name3373707";

    CompilationResult actualResponse = client.getCompilationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompilationResultRequest actualRequest =
        ((GetCompilationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCompilationResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String name = "name3373707";
      client.getCompilationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCompilationResultTest() throws Exception {
    CompilationResult expectedResponse =
        CompilationResult.newBuilder()
            .setName(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setCodeCompilationConfig(CompilationResult.CodeCompilationConfig.newBuilder().build())
            .setDataformCoreVersion("dataformCoreVersion1859535851")
            .addAllCompilationErrors(new ArrayList<CompilationResult.CompilationError>())
            .build();
    mockDataform.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    CompilationResult compilationResult = CompilationResult.newBuilder().build();

    CompilationResult actualResponse = client.createCompilationResult(parent, compilationResult);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCompilationResultRequest actualRequest =
        ((CreateCompilationResultRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(compilationResult, actualRequest.getCompilationResult());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCompilationResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      CompilationResult compilationResult = CompilationResult.newBuilder().build();
      client.createCompilationResult(parent, compilationResult);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCompilationResultTest2() throws Exception {
    CompilationResult expectedResponse =
        CompilationResult.newBuilder()
            .setName(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setCodeCompilationConfig(CompilationResult.CodeCompilationConfig.newBuilder().build())
            .setDataformCoreVersion("dataformCoreVersion1859535851")
            .addAllCompilationErrors(new ArrayList<CompilationResult.CompilationError>())
            .build();
    mockDataform.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CompilationResult compilationResult = CompilationResult.newBuilder().build();

    CompilationResult actualResponse = client.createCompilationResult(parent, compilationResult);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCompilationResultRequest actualRequest =
        ((CreateCompilationResultRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(compilationResult, actualRequest.getCompilationResult());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCompilationResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String parent = "parent-995424086";
      CompilationResult compilationResult = CompilationResult.newBuilder().build();
      client.createCompilationResult(parent, compilationResult);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryCompilationResultActionsTest() throws Exception {
    CompilationResultAction responsesElement = CompilationResultAction.newBuilder().build();
    QueryCompilationResultActionsResponse expectedResponse =
        QueryCompilationResultActionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompilationResultActions(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    QueryCompilationResultActionsRequest request =
        QueryCompilationResultActionsRequest.newBuilder()
            .setName(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    QueryCompilationResultActionsPagedResponse pagedListResponse =
        client.queryCompilationResultActions(request);

    List<CompilationResultAction> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCompilationResultActionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryCompilationResultActionsRequest actualRequest =
        ((QueryCompilationResultActionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryCompilationResultActionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      QueryCompilationResultActionsRequest request =
          QueryCompilationResultActionsRequest.newBuilder()
              .setName(
                  CompilationResultName.of(
                          "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.queryCompilationResultActions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkflowInvocationsTest() throws Exception {
    WorkflowInvocation responsesElement = WorkflowInvocation.newBuilder().build();
    ListWorkflowInvocationsResponse expectedResponse =
        ListWorkflowInvocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkflowInvocations(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListWorkflowInvocationsPagedResponse pagedListResponse = client.listWorkflowInvocations(parent);

    List<WorkflowInvocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkflowInvocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkflowInvocationsRequest actualRequest =
        ((ListWorkflowInvocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkflowInvocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listWorkflowInvocations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkflowInvocationsTest2() throws Exception {
    WorkflowInvocation responsesElement = WorkflowInvocation.newBuilder().build();
    ListWorkflowInvocationsResponse expectedResponse =
        ListWorkflowInvocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkflowInvocations(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkflowInvocationsPagedResponse pagedListResponse = client.listWorkflowInvocations(parent);

    List<WorkflowInvocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkflowInvocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkflowInvocationsRequest actualRequest =
        ((ListWorkflowInvocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkflowInvocationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkflowInvocations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkflowInvocationTest() throws Exception {
    WorkflowInvocation expectedResponse =
        WorkflowInvocation.newBuilder()
            .setName(
                WorkflowInvocationName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                    .toString())
            .setCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setInvocationConfig(WorkflowInvocation.InvocationConfig.newBuilder().build())
            .setInvocationTiming(Interval.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    WorkflowInvocationName name =
        WorkflowInvocationName.of(
            "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]");

    WorkflowInvocation actualResponse = client.getWorkflowInvocation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkflowInvocationRequest actualRequest =
        ((GetWorkflowInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkflowInvocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      WorkflowInvocationName name =
          WorkflowInvocationName.of(
              "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]");
      client.getWorkflowInvocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkflowInvocationTest2() throws Exception {
    WorkflowInvocation expectedResponse =
        WorkflowInvocation.newBuilder()
            .setName(
                WorkflowInvocationName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                    .toString())
            .setCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setInvocationConfig(WorkflowInvocation.InvocationConfig.newBuilder().build())
            .setInvocationTiming(Interval.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    String name = "name3373707";

    WorkflowInvocation actualResponse = client.getWorkflowInvocation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkflowInvocationRequest actualRequest =
        ((GetWorkflowInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkflowInvocationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String name = "name3373707";
      client.getWorkflowInvocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkflowInvocationTest() throws Exception {
    WorkflowInvocation expectedResponse =
        WorkflowInvocation.newBuilder()
            .setName(
                WorkflowInvocationName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                    .toString())
            .setCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setInvocationConfig(WorkflowInvocation.InvocationConfig.newBuilder().build())
            .setInvocationTiming(Interval.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    WorkflowInvocation workflowInvocation = WorkflowInvocation.newBuilder().build();

    WorkflowInvocation actualResponse = client.createWorkflowInvocation(parent, workflowInvocation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkflowInvocationRequest actualRequest =
        ((CreateWorkflowInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workflowInvocation, actualRequest.getWorkflowInvocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkflowInvocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      WorkflowInvocation workflowInvocation = WorkflowInvocation.newBuilder().build();
      client.createWorkflowInvocation(parent, workflowInvocation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkflowInvocationTest2() throws Exception {
    WorkflowInvocation expectedResponse =
        WorkflowInvocation.newBuilder()
            .setName(
                WorkflowInvocationName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                    .toString())
            .setCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setInvocationConfig(WorkflowInvocation.InvocationConfig.newBuilder().build())
            .setInvocationTiming(Interval.newBuilder().build())
            .build();
    mockDataform.addResponse(expectedResponse);

    String parent = "parent-995424086";
    WorkflowInvocation workflowInvocation = WorkflowInvocation.newBuilder().build();

    WorkflowInvocation actualResponse = client.createWorkflowInvocation(parent, workflowInvocation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkflowInvocationRequest actualRequest =
        ((CreateWorkflowInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workflowInvocation, actualRequest.getWorkflowInvocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkflowInvocationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String parent = "parent-995424086";
      WorkflowInvocation workflowInvocation = WorkflowInvocation.newBuilder().build();
      client.createWorkflowInvocation(parent, workflowInvocation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkflowInvocationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    WorkflowInvocationName name =
        WorkflowInvocationName.of(
            "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]");

    client.deleteWorkflowInvocation(name);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkflowInvocationRequest actualRequest =
        ((DeleteWorkflowInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkflowInvocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      WorkflowInvocationName name =
          WorkflowInvocationName.of(
              "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]");
      client.deleteWorkflowInvocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkflowInvocationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteWorkflowInvocation(name);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkflowInvocationRequest actualRequest =
        ((DeleteWorkflowInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkflowInvocationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkflowInvocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelWorkflowInvocationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataform.addResponse(expectedResponse);

    CancelWorkflowInvocationRequest request =
        CancelWorkflowInvocationRequest.newBuilder()
            .setName(
                WorkflowInvocationName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                    .toString())
            .build();

    client.cancelWorkflowInvocation(request);

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelWorkflowInvocationRequest actualRequest =
        ((CancelWorkflowInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelWorkflowInvocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      CancelWorkflowInvocationRequest request =
          CancelWorkflowInvocationRequest.newBuilder()
              .setName(
                  WorkflowInvocationName.of(
                          "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                      .toString())
              .build();
      client.cancelWorkflowInvocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryWorkflowInvocationActionsTest() throws Exception {
    WorkflowInvocationAction responsesElement = WorkflowInvocationAction.newBuilder().build();
    QueryWorkflowInvocationActionsResponse expectedResponse =
        QueryWorkflowInvocationActionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkflowInvocationActions(Arrays.asList(responsesElement))
            .build();
    mockDataform.addResponse(expectedResponse);

    QueryWorkflowInvocationActionsRequest request =
        QueryWorkflowInvocationActionsRequest.newBuilder()
            .setName(
                WorkflowInvocationName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    QueryWorkflowInvocationActionsPagedResponse pagedListResponse =
        client.queryWorkflowInvocationActions(request);

    List<WorkflowInvocationAction> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getWorkflowInvocationActionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryWorkflowInvocationActionsRequest actualRequest =
        ((QueryWorkflowInvocationActionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryWorkflowInvocationActionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataform.addException(exception);

    try {
      QueryWorkflowInvocationActionsRequest request =
          QueryWorkflowInvocationActionsRequest.newBuilder()
              .setName(
                  WorkflowInvocationName.of(
                          "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.queryWorkflowInvocationActions(request);
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
}
