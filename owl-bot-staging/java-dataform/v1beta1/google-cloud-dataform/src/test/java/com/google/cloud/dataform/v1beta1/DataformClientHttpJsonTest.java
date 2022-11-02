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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataform.v1beta1.stub.HttpJsonDataformStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.type.Interval;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DataformClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataformClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataformStub.getMethodDescriptors(), DataformSettings.getDefaultEndpoint());
    DataformSettings settings =
        DataformSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataformSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataformClient.create(settings);
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
  public void listRepositoriesTest() throws Exception {
    Repository responsesElement = Repository.newBuilder().build();
    ListRepositoriesResponse expectedResponse =
        ListRepositoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRepositories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRepositoriesPagedResponse pagedListResponse = client.listRepositories(parent);

    List<Repository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRepositoriesList().get(0), resources.get(0));

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
  public void listRepositoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListRepositoriesPagedResponse pagedListResponse = client.listRepositories(parent);

    List<Repository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRepositoriesList().get(0), resources.get(0));

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
  public void listRepositoriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    Repository actualResponse = client.getRepository(name);
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
  public void getRepositoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4840/locations/location-4840/repositories/repositorie-4840";

    Repository actualResponse = client.getRepository(name);
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
  public void getRepositoryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4840/locations/location-4840/repositories/repositorie-4840";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Repository repository = Repository.newBuilder().build();
    String repositoryId = "repositoryId2113747461";

    Repository actualResponse = client.createRepository(parent, repository, repositoryId);
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
  public void createRepositoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Repository repository = Repository.newBuilder().build();
    String repositoryId = "repositoryId2113747461";

    Repository actualResponse = client.createRepository(parent, repository, repositoryId);
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
  public void createRepositoryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    Repository repository =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Repository actualResponse = client.updateRepository(repository, updateMask);
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
  public void updateRepositoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Repository repository =
          Repository.newBuilder()
              .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
              .build();
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
    mockService.addResponse(expectedResponse);

    RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    client.deleteRepository(name);

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
  public void deleteRepositoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4840/locations/location-4840/repositories/repositorie-4840";

    client.deleteRepository(name);

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
  public void deleteRepositoryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4840/locations/location-4840/repositories/repositorie-4840";
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
    mockService.addResponse(expectedResponse);

    FetchRemoteBranchesRequest request =
        FetchRemoteBranchesRequest.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .build();

    FetchRemoteBranchesResponse actualResponse = client.fetchRemoteBranches(request);
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
  public void fetchRemoteBranchesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListWorkspacesPagedResponse pagedListResponse = client.listWorkspaces(parent);

    List<Workspace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkspacesList().get(0), resources.get(0));

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
  public void listWorkspacesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";

    ListWorkspacesPagedResponse pagedListResponse = client.listWorkspaces(parent);

    List<Workspace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkspacesList().get(0), resources.get(0));

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
  public void listWorkspacesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
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
    mockService.addResponse(expectedResponse);

    WorkspaceName name = WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]");

    Workspace actualResponse = client.getWorkspace(name);
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
  public void getWorkspaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2384/locations/location-2384/repositories/repositorie-2384/workspaces/workspace-2384";

    Workspace actualResponse = client.getWorkspace(name);
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
  public void getWorkspaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2384/locations/location-2384/repositories/repositorie-2384/workspaces/workspace-2384";
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
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    Workspace workspace = Workspace.newBuilder().build();
    String workspaceId = "workspaceId466560144";

    Workspace actualResponse = client.createWorkspace(parent, workspace, workspaceId);
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
  public void createWorkspaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
    Workspace workspace = Workspace.newBuilder().build();
    String workspaceId = "workspaceId466560144";

    Workspace actualResponse = client.createWorkspace(parent, workspace, workspaceId);
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
  public void createWorkspaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
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
    mockService.addResponse(expectedResponse);

    WorkspaceName name = WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]");

    client.deleteWorkspace(name);

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
  public void deleteWorkspaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2384/locations/location-2384/repositories/repositorie-2384/workspaces/workspace-2384";

    client.deleteWorkspace(name);

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
  public void deleteWorkspaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2384/locations/location-2384/repositories/repositorie-2384/workspaces/workspace-2384";
      client.deleteWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void installNpmPackagesTest() throws Exception {
    InstallNpmPackagesResponse expectedResponse = InstallNpmPackagesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    InstallNpmPackagesRequest request =
        InstallNpmPackagesRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .build();

    InstallNpmPackagesResponse actualResponse = client.installNpmPackages(request);
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
  public void installNpmPackagesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    PullGitCommitsRequest request =
        PullGitCommitsRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setRemoteBranch("remoteBranch-533119608")
            .setAuthor(CommitAuthor.newBuilder().build())
            .build();

    client.pullGitCommits(request);

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
  public void pullGitCommitsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    PushGitCommitsRequest request =
        PushGitCommitsRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setRemoteBranch("remoteBranch-533119608")
            .build();

    client.pushGitCommits(request);

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
  public void pushGitCommitsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    FetchFileGitStatusesRequest request =
        FetchFileGitStatusesRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .build();

    FetchFileGitStatusesResponse actualResponse = client.fetchFileGitStatuses(request);
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
  public void fetchFileGitStatusesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    FetchGitAheadBehindRequest request =
        FetchGitAheadBehindRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setRemoteBranch("remoteBranch-533119608")
            .build();

    FetchGitAheadBehindResponse actualResponse = client.fetchGitAheadBehind(request);
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
  public void fetchGitAheadBehindExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void commitWorkspaceChangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ResetWorkspaceChangesRequest request =
        ResetWorkspaceChangesRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .addAllPaths(new ArrayList<String>())
            .setClean(true)
            .build();

    client.resetWorkspaceChanges(request);

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
  public void resetWorkspaceChangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    FetchFileDiffRequest request =
        FetchFileDiffRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    FetchFileDiffResponse actualResponse = client.fetchFileDiff(request);
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
  public void fetchFileDiffExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void queryDirectoryContentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    MakeDirectoryRequest request =
        MakeDirectoryRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    MakeDirectoryResponse actualResponse = client.makeDirectory(request);
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
  public void makeDirectoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    RemoveDirectoryRequest request =
        RemoveDirectoryRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    client.removeDirectory(request);

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
  public void removeDirectoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void moveDirectoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ReadFileRequest request =
        ReadFileRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    ReadFileResponse actualResponse = client.readFile(request);
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
  public void readFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    RemoveFileRequest request =
        RemoveFileRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    client.removeFile(request);

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
  public void removeFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void moveFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void writeFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListCompilationResultsPagedResponse pagedListResponse = client.listCompilationResults(parent);

    List<CompilationResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompilationResultsList().get(0), resources.get(0));

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
  public void listCompilationResultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";

    ListCompilationResultsPagedResponse pagedListResponse = client.listCompilationResults(parent);

    List<CompilationResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompilationResultsList().get(0), resources.get(0));

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
  public void listCompilationResultsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
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
    mockService.addResponse(expectedResponse);

    CompilationResultName name =
        CompilationResultName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]");

    CompilationResult actualResponse = client.getCompilationResult(name);
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
  public void getCompilationResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7493/locations/location-7493/repositories/repositorie-7493/compilationResults/compilationResult-7493";

    CompilationResult actualResponse = client.getCompilationResult(name);
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
  public void getCompilationResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7493/locations/location-7493/repositories/repositorie-7493/compilationResults/compilationResult-7493";
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
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    CompilationResult compilationResult = CompilationResult.newBuilder().build();

    CompilationResult actualResponse = client.createCompilationResult(parent, compilationResult);
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
  public void createCompilationResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
    CompilationResult compilationResult = CompilationResult.newBuilder().build();

    CompilationResult actualResponse = client.createCompilationResult(parent, compilationResult);
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
  public void createCompilationResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
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
    mockService.addResponse(expectedResponse);

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
  public void queryCompilationResultActionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListWorkflowInvocationsPagedResponse pagedListResponse = client.listWorkflowInvocations(parent);

    List<WorkflowInvocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkflowInvocationsList().get(0), resources.get(0));

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
  public void listWorkflowInvocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";

    ListWorkflowInvocationsPagedResponse pagedListResponse = client.listWorkflowInvocations(parent);

    List<WorkflowInvocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkflowInvocationsList().get(0), resources.get(0));

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
  public void listWorkflowInvocationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
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
    mockService.addResponse(expectedResponse);

    WorkflowInvocationName name =
        WorkflowInvocationName.of(
            "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]");

    WorkflowInvocation actualResponse = client.getWorkflowInvocation(name);
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
  public void getWorkflowInvocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2248/locations/location-2248/repositories/repositorie-2248/workflowInvocations/workflowInvocation-2248";

    WorkflowInvocation actualResponse = client.getWorkflowInvocation(name);
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
  public void getWorkflowInvocationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2248/locations/location-2248/repositories/repositorie-2248/workflowInvocations/workflowInvocation-2248";
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
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    WorkflowInvocation workflowInvocation = WorkflowInvocation.newBuilder().build();

    WorkflowInvocation actualResponse = client.createWorkflowInvocation(parent, workflowInvocation);
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
  public void createWorkflowInvocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
    WorkflowInvocation workflowInvocation = WorkflowInvocation.newBuilder().build();

    WorkflowInvocation actualResponse = client.createWorkflowInvocation(parent, workflowInvocation);
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
  public void createWorkflowInvocationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
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
    mockService.addResponse(expectedResponse);

    WorkflowInvocationName name =
        WorkflowInvocationName.of(
            "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]");

    client.deleteWorkflowInvocation(name);

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
  public void deleteWorkflowInvocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2248/locations/location-2248/repositories/repositorie-2248/workflowInvocations/workflowInvocation-2248";

    client.deleteWorkflowInvocation(name);

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
  public void deleteWorkflowInvocationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2248/locations/location-2248/repositories/repositorie-2248/workflowInvocations/workflowInvocation-2248";
      client.deleteWorkflowInvocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelWorkflowInvocationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CancelWorkflowInvocationRequest request =
        CancelWorkflowInvocationRequest.newBuilder()
            .setName(
                WorkflowInvocationName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                    .toString())
            .build();

    client.cancelWorkflowInvocation(request);

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
  public void cancelWorkflowInvocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void queryWorkflowInvocationActionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
}
