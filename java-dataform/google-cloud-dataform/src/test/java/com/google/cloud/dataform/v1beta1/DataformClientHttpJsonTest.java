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

package com.google.cloud.dataform.v1beta1;

import static com.google.cloud.dataform.v1beta1.DataformClient.FetchRepositoryHistoryPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListCompilationResultsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListLocationsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListReleaseConfigsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListRepositoriesPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListWorkflowConfigsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListWorkflowInvocationsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.ListWorkspacesPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryCompilationResultActionsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryRepositoryDirectoryContentsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.QueryWorkflowInvocationActionsPagedResponse;
import static com.google.cloud.dataform.v1beta1.DataformClient.SearchFilesPagedResponse;

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
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .setNpmrcEnvironmentVariablesSecretVersion(
                "npmrcEnvironmentVariablesSecretVersion-1472767288")
            .setWorkspaceCompilationOverrides(
                Repository.WorkspaceCompilationOverrides.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSetAuthenticatedUserAdmin(true)
            .setServiceAccount("serviceAccount1079137720")
            .setKmsKeyName("kmsKeyName412586233")
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .setNpmrcEnvironmentVariablesSecretVersion(
                "npmrcEnvironmentVariablesSecretVersion-1472767288")
            .setWorkspaceCompilationOverrides(
                Repository.WorkspaceCompilationOverrides.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSetAuthenticatedUserAdmin(true)
            .setServiceAccount("serviceAccount1079137720")
            .setKmsKeyName("kmsKeyName412586233")
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .setNpmrcEnvironmentVariablesSecretVersion(
                "npmrcEnvironmentVariablesSecretVersion-1472767288")
            .setWorkspaceCompilationOverrides(
                Repository.WorkspaceCompilationOverrides.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSetAuthenticatedUserAdmin(true)
            .setServiceAccount("serviceAccount1079137720")
            .setKmsKeyName("kmsKeyName412586233")
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .setNpmrcEnvironmentVariablesSecretVersion(
                "npmrcEnvironmentVariablesSecretVersion-1472767288")
            .setWorkspaceCompilationOverrides(
                Repository.WorkspaceCompilationOverrides.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSetAuthenticatedUserAdmin(true)
            .setServiceAccount("serviceAccount1079137720")
            .setKmsKeyName("kmsKeyName412586233")
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .setNpmrcEnvironmentVariablesSecretVersion(
                "npmrcEnvironmentVariablesSecretVersion-1472767288")
            .setWorkspaceCompilationOverrides(
                Repository.WorkspaceCompilationOverrides.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSetAuthenticatedUserAdmin(true)
            .setServiceAccount("serviceAccount1079137720")
            .setKmsKeyName("kmsKeyName412586233")
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    Repository repository =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
            .setNpmrcEnvironmentVariablesSecretVersion(
                "npmrcEnvironmentVariablesSecretVersion-1472767288")
            .setWorkspaceCompilationOverrides(
                Repository.WorkspaceCompilationOverrides.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSetAuthenticatedUserAdmin(true)
            .setServiceAccount("serviceAccount1079137720")
            .setKmsKeyName("kmsKeyName412586233")
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
              .setCreateTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setGitRemoteSettings(Repository.GitRemoteSettings.newBuilder().build())
              .setNpmrcEnvironmentVariablesSecretVersion(
                  "npmrcEnvironmentVariablesSecretVersion-1472767288")
              .setWorkspaceCompilationOverrides(
                  Repository.WorkspaceCompilationOverrides.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setSetAuthenticatedUserAdmin(true)
              .setServiceAccount("serviceAccount1079137720")
              .setKmsKeyName("kmsKeyName412586233")
              .setDataEncryptionState(DataEncryptionState.newBuilder().build())
              .setInternalMetadata("internalMetadata6789388")
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
  public void commitRepositoryChangesTest() throws Exception {
    CommitRepositoryChangesResponse expectedResponse =
        CommitRepositoryChangesResponse.newBuilder().setCommitSha("commitSha-1491174411").build();
    mockService.addResponse(expectedResponse);

    CommitRepositoryChangesRequest request =
        CommitRepositoryChangesRequest.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setCommitMetadata(CommitMetadata.newBuilder().build())
            .setRequiredHeadCommitSha("requiredHeadCommitSha-393901930")
            .putAllFileOperations(
                new HashMap<String, CommitRepositoryChangesRequest.FileOperation>())
            .build();

    CommitRepositoryChangesResponse actualResponse = client.commitRepositoryChanges(request);
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
  public void commitRepositoryChangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CommitRepositoryChangesRequest request =
          CommitRepositoryChangesRequest.newBuilder()
              .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .setCommitMetadata(CommitMetadata.newBuilder().build())
              .setRequiredHeadCommitSha("requiredHeadCommitSha-393901930")
              .putAllFileOperations(
                  new HashMap<String, CommitRepositoryChangesRequest.FileOperation>())
              .build();
      client.commitRepositoryChanges(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readRepositoryFileTest() throws Exception {
    ReadRepositoryFileResponse expectedResponse =
        ReadRepositoryFileResponse.newBuilder().setContents(ByteString.EMPTY).build();
    mockService.addResponse(expectedResponse);

    ReadRepositoryFileRequest request =
        ReadRepositoryFileRequest.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setCommitSha("commitSha-1491174411")
            .setPath("path3433509")
            .build();

    ReadRepositoryFileResponse actualResponse = client.readRepositoryFile(request);
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
  public void readRepositoryFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReadRepositoryFileRequest request =
          ReadRepositoryFileRequest.newBuilder()
              .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .setCommitSha("commitSha-1491174411")
              .setPath("path3433509")
              .build();
      client.readRepositoryFile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryRepositoryDirectoryContentsTest() throws Exception {
    DirectoryEntry responsesElement = DirectoryEntry.newBuilder().build();
    QueryRepositoryDirectoryContentsResponse expectedResponse =
        QueryRepositoryDirectoryContentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDirectoryEntries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    QueryRepositoryDirectoryContentsRequest request =
        QueryRepositoryDirectoryContentsRequest.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setCommitSha("commitSha-1491174411")
            .setPath("path3433509")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    QueryRepositoryDirectoryContentsPagedResponse pagedListResponse =
        client.queryRepositoryDirectoryContents(request);

    List<DirectoryEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

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
  public void queryRepositoryDirectoryContentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QueryRepositoryDirectoryContentsRequest request =
          QueryRepositoryDirectoryContentsRequest.newBuilder()
              .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .setCommitSha("commitSha-1491174411")
              .setPath("path3433509")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.queryRepositoryDirectoryContents(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchRepositoryHistoryTest() throws Exception {
    CommitLogEntry responsesElement = CommitLogEntry.newBuilder().build();
    FetchRepositoryHistoryResponse expectedResponse =
        FetchRepositoryHistoryResponse.newBuilder()
            .setNextPageToken("")
            .addAllCommits(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    FetchRepositoryHistoryRequest request =
        FetchRepositoryHistoryRequest.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    FetchRepositoryHistoryPagedResponse pagedListResponse = client.fetchRepositoryHistory(request);

    List<CommitLogEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCommitsList().get(0), resources.get(0));

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
  public void fetchRepositoryHistoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FetchRepositoryHistoryRequest request =
          FetchRepositoryHistoryRequest.newBuilder()
              .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.fetchRepositoryHistory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeRepositoryAccessTokenStatusTest() throws Exception {
    ComputeRepositoryAccessTokenStatusResponse expectedResponse =
        ComputeRepositoryAccessTokenStatusResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ComputeRepositoryAccessTokenStatusRequest request =
        ComputeRepositoryAccessTokenStatusRequest.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .build();

    ComputeRepositoryAccessTokenStatusResponse actualResponse =
        client.computeRepositoryAccessTokenStatus(request);
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
  public void computeRepositoryAccessTokenStatusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ComputeRepositoryAccessTokenStatusRequest request =
          ComputeRepositoryAccessTokenStatusRequest.newBuilder()
              .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .build();
      client.computeRepositoryAccessTokenStatus(request);
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
    PullGitCommitsResponse expectedResponse = PullGitCommitsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PullGitCommitsRequest request =
        PullGitCommitsRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setRemoteBranch("remoteBranch-533119608")
            .setAuthor(CommitAuthor.newBuilder().build())
            .build();

    PullGitCommitsResponse actualResponse = client.pullGitCommits(request);
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
    PushGitCommitsResponse expectedResponse = PushGitCommitsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PushGitCommitsRequest request =
        PushGitCommitsRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setRemoteBranch("remoteBranch-533119608")
            .build();

    PushGitCommitsResponse actualResponse = client.pushGitCommits(request);
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
    CommitWorkspaceChangesResponse expectedResponse =
        CommitWorkspaceChangesResponse.newBuilder().build();
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

    CommitWorkspaceChangesResponse actualResponse = client.commitWorkspaceChanges(request);
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
    ResetWorkspaceChangesResponse expectedResponse =
        ResetWorkspaceChangesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ResetWorkspaceChangesRequest request =
        ResetWorkspaceChangesRequest.newBuilder()
            .setName(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .addAllPaths(new ArrayList<String>())
            .setClean(true)
            .build();

    ResetWorkspaceChangesResponse actualResponse = client.resetWorkspaceChanges(request);
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
    DirectoryEntry responsesElement = DirectoryEntry.newBuilder().build();
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

    List<DirectoryEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

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
  public void searchFilesTest() throws Exception {
    SearchResult responsesElement = SearchResult.newBuilder().build();
    SearchFilesResponse expectedResponse =
        SearchFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchFilesRequest request =
        SearchFilesRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    SearchFilesPagedResponse pagedListResponse = client.searchFiles(request);

    List<SearchResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchResultsList().get(0), resources.get(0));

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
  public void searchFilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchFilesRequest request =
          SearchFilesRequest.newBuilder()
              .setWorkspace(
                  WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.searchFiles(request);
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
    RemoveDirectoryResponse expectedResponse = RemoveDirectoryResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RemoveDirectoryRequest request =
        RemoveDirectoryRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    RemoveDirectoryResponse actualResponse = client.removeDirectory(request);
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
            .setRevision("revision-260786213")
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
              .setRevision("revision-260786213")
              .build();
      client.readFile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeFileTest() throws Exception {
    RemoveFileResponse expectedResponse = RemoveFileResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RemoveFileRequest request =
        RemoveFileRequest.newBuilder()
            .setWorkspace(
                WorkspaceName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKSPACE]")
                    .toString())
            .setPath("path3433509")
            .build();

    RemoveFileResponse actualResponse = client.removeFile(request);
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
  public void listReleaseConfigsTest() throws Exception {
    ReleaseConfig responsesElement = ReleaseConfig.newBuilder().build();
    ListReleaseConfigsResponse expectedResponse =
        ListReleaseConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReleaseConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListReleaseConfigsPagedResponse pagedListResponse = client.listReleaseConfigs(parent);

    List<ReleaseConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleaseConfigsList().get(0), resources.get(0));

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
  public void listReleaseConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listReleaseConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReleaseConfigsTest2() throws Exception {
    ReleaseConfig responsesElement = ReleaseConfig.newBuilder().build();
    ListReleaseConfigsResponse expectedResponse =
        ListReleaseConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReleaseConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";

    ListReleaseConfigsPagedResponse pagedListResponse = client.listReleaseConfigs(parent);

    List<ReleaseConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReleaseConfigsList().get(0), resources.get(0));

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
  public void listReleaseConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
      client.listReleaseConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReleaseConfigTest() throws Exception {
    ReleaseConfig expectedResponse =
        ReleaseConfig.newBuilder()
            .setName(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setGitCommitish("gitCommitish-98628555")
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledReleaseRecords(
                new ArrayList<ReleaseConfig.ScheduledReleaseRecord>())
            .setReleaseCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDisabled(true)
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    ReleaseConfigName name =
        ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]");

    ReleaseConfig actualResponse = client.getReleaseConfig(name);
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
  public void getReleaseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseConfigName name =
          ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]");
      client.getReleaseConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReleaseConfigTest2() throws Exception {
    ReleaseConfig expectedResponse =
        ReleaseConfig.newBuilder()
            .setName(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setGitCommitish("gitCommitish-98628555")
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledReleaseRecords(
                new ArrayList<ReleaseConfig.ScheduledReleaseRecord>())
            .setReleaseCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDisabled(true)
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9636/locations/location-9636/repositories/repositorie-9636/releaseConfigs/releaseConfig-9636";

    ReleaseConfig actualResponse = client.getReleaseConfig(name);
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
  public void getReleaseConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9636/locations/location-9636/repositories/repositorie-9636/releaseConfigs/releaseConfig-9636";
      client.getReleaseConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReleaseConfigTest() throws Exception {
    ReleaseConfig expectedResponse =
        ReleaseConfig.newBuilder()
            .setName(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setGitCommitish("gitCommitish-98628555")
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledReleaseRecords(
                new ArrayList<ReleaseConfig.ScheduledReleaseRecord>())
            .setReleaseCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDisabled(true)
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    ReleaseConfig releaseConfig = ReleaseConfig.newBuilder().build();
    String releaseConfigId = "releaseConfigId1350457636";

    ReleaseConfig actualResponse =
        client.createReleaseConfig(parent, releaseConfig, releaseConfigId);
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
  public void createReleaseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      ReleaseConfig releaseConfig = ReleaseConfig.newBuilder().build();
      String releaseConfigId = "releaseConfigId1350457636";
      client.createReleaseConfig(parent, releaseConfig, releaseConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReleaseConfigTest2() throws Exception {
    ReleaseConfig expectedResponse =
        ReleaseConfig.newBuilder()
            .setName(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setGitCommitish("gitCommitish-98628555")
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledReleaseRecords(
                new ArrayList<ReleaseConfig.ScheduledReleaseRecord>())
            .setReleaseCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDisabled(true)
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
    ReleaseConfig releaseConfig = ReleaseConfig.newBuilder().build();
    String releaseConfigId = "releaseConfigId1350457636";

    ReleaseConfig actualResponse =
        client.createReleaseConfig(parent, releaseConfig, releaseConfigId);
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
  public void createReleaseConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
      ReleaseConfig releaseConfig = ReleaseConfig.newBuilder().build();
      String releaseConfigId = "releaseConfigId1350457636";
      client.createReleaseConfig(parent, releaseConfig, releaseConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateReleaseConfigTest() throws Exception {
    ReleaseConfig expectedResponse =
        ReleaseConfig.newBuilder()
            .setName(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setGitCommitish("gitCommitish-98628555")
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledReleaseRecords(
                new ArrayList<ReleaseConfig.ScheduledReleaseRecord>())
            .setReleaseCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDisabled(true)
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    ReleaseConfig releaseConfig =
        ReleaseConfig.newBuilder()
            .setName(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setGitCommitish("gitCommitish-98628555")
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledReleaseRecords(
                new ArrayList<ReleaseConfig.ScheduledReleaseRecord>())
            .setReleaseCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDisabled(true)
            .setInternalMetadata("internalMetadata6789388")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ReleaseConfig actualResponse = client.updateReleaseConfig(releaseConfig, updateMask);
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
  public void updateReleaseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseConfig releaseConfig =
          ReleaseConfig.newBuilder()
              .setName(
                  ReleaseConfigName.of(
                          "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                      .toString())
              .setGitCommitish("gitCommitish-98628555")
              .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
              .setCronSchedule("cronSchedule-1022672059")
              .setTimeZone("timeZone-2077180903")
              .addAllRecentScheduledReleaseRecords(
                  new ArrayList<ReleaseConfig.ScheduledReleaseRecord>())
              .setReleaseCompilationResult(
                  CompilationResultName.of(
                          "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                      .toString())
              .setDisabled(true)
              .setInternalMetadata("internalMetadata6789388")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateReleaseConfig(releaseConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReleaseConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ReleaseConfigName name =
        ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]");

    client.deleteReleaseConfig(name);

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
  public void deleteReleaseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReleaseConfigName name =
          ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]");
      client.deleteReleaseConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReleaseConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9636/locations/location-9636/repositories/repositorie-9636/releaseConfigs/releaseConfig-9636";

    client.deleteReleaseConfig(name);

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
  public void deleteReleaseConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9636/locations/location-9636/repositories/repositorie-9636/releaseConfigs/releaseConfig-9636";
      client.deleteReleaseConfig(name);
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
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setResolvedGitCommitSha("resolvedGitCommitSha1908380763")
            .setDataformCoreVersion("dataformCoreVersion1859535851")
            .addAllCompilationErrors(new ArrayList<CompilationResult.CompilationError>())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setResolvedGitCommitSha("resolvedGitCommitSha1908380763")
            .setDataformCoreVersion("dataformCoreVersion1859535851")
            .addAllCompilationErrors(new ArrayList<CompilationResult.CompilationError>())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setResolvedGitCommitSha("resolvedGitCommitSha1908380763")
            .setDataformCoreVersion("dataformCoreVersion1859535851")
            .addAllCompilationErrors(new ArrayList<CompilationResult.CompilationError>())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setCodeCompilationConfig(CodeCompilationConfig.newBuilder().build())
            .setResolvedGitCommitSha("resolvedGitCommitSha1908380763")
            .setDataformCoreVersion("dataformCoreVersion1859535851")
            .addAllCompilationErrors(new ArrayList<CompilationResult.CompilationError>())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
  public void listWorkflowConfigsTest() throws Exception {
    WorkflowConfig responsesElement = WorkflowConfig.newBuilder().build();
    ListWorkflowConfigsResponse expectedResponse =
        ListWorkflowConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkflowConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListWorkflowConfigsPagedResponse pagedListResponse = client.listWorkflowConfigs(parent);

    List<WorkflowConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkflowConfigsList().get(0), resources.get(0));

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
  public void listWorkflowConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listWorkflowConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkflowConfigsTest2() throws Exception {
    WorkflowConfig responsesElement = WorkflowConfig.newBuilder().build();
    ListWorkflowConfigsResponse expectedResponse =
        ListWorkflowConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkflowConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";

    ListWorkflowConfigsPagedResponse pagedListResponse = client.listWorkflowConfigs(parent);

    List<WorkflowConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkflowConfigsList().get(0), resources.get(0));

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
  public void listWorkflowConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
      client.listWorkflowConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkflowConfigTest() throws Exception {
    WorkflowConfig expectedResponse =
        WorkflowConfig.newBuilder()
            .setName(
                WorkflowConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
                    .toString())
            .setReleaseConfig(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledExecutionRecords(
                new ArrayList<WorkflowConfig.ScheduledExecutionRecord>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    WorkflowConfigName name =
        WorkflowConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]");

    WorkflowConfig actualResponse = client.getWorkflowConfig(name);
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
  public void getWorkflowConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowConfigName name =
          WorkflowConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]");
      client.getWorkflowConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkflowConfigTest2() throws Exception {
    WorkflowConfig expectedResponse =
        WorkflowConfig.newBuilder()
            .setName(
                WorkflowConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
                    .toString())
            .setReleaseConfig(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledExecutionRecords(
                new ArrayList<WorkflowConfig.ScheduledExecutionRecord>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9018/locations/location-9018/repositories/repositorie-9018/workflowConfigs/workflowConfig-9018";

    WorkflowConfig actualResponse = client.getWorkflowConfig(name);
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
  public void getWorkflowConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9018/locations/location-9018/repositories/repositorie-9018/workflowConfigs/workflowConfig-9018";
      client.getWorkflowConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkflowConfigTest() throws Exception {
    WorkflowConfig expectedResponse =
        WorkflowConfig.newBuilder()
            .setName(
                WorkflowConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
                    .toString())
            .setReleaseConfig(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledExecutionRecords(
                new ArrayList<WorkflowConfig.ScheduledExecutionRecord>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    WorkflowConfig workflowConfig = WorkflowConfig.newBuilder().build();
    String workflowConfigId = "workflowConfigId-1331048228";

    WorkflowConfig actualResponse =
        client.createWorkflowConfig(parent, workflowConfig, workflowConfigId);
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
  public void createWorkflowConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      WorkflowConfig workflowConfig = WorkflowConfig.newBuilder().build();
      String workflowConfigId = "workflowConfigId-1331048228";
      client.createWorkflowConfig(parent, workflowConfig, workflowConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkflowConfigTest2() throws Exception {
    WorkflowConfig expectedResponse =
        WorkflowConfig.newBuilder()
            .setName(
                WorkflowConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
                    .toString())
            .setReleaseConfig(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledExecutionRecords(
                new ArrayList<WorkflowConfig.ScheduledExecutionRecord>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
    WorkflowConfig workflowConfig = WorkflowConfig.newBuilder().build();
    String workflowConfigId = "workflowConfigId-1331048228";

    WorkflowConfig actualResponse =
        client.createWorkflowConfig(parent, workflowConfig, workflowConfigId);
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
  public void createWorkflowConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9015/locations/location-9015/repositories/repositorie-9015";
      WorkflowConfig workflowConfig = WorkflowConfig.newBuilder().build();
      String workflowConfigId = "workflowConfigId-1331048228";
      client.createWorkflowConfig(parent, workflowConfig, workflowConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateWorkflowConfigTest() throws Exception {
    WorkflowConfig expectedResponse =
        WorkflowConfig.newBuilder()
            .setName(
                WorkflowConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
                    .toString())
            .setReleaseConfig(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledExecutionRecords(
                new ArrayList<WorkflowConfig.ScheduledExecutionRecord>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
            .build();
    mockService.addResponse(expectedResponse);

    WorkflowConfig workflowConfig =
        WorkflowConfig.newBuilder()
            .setName(
                WorkflowConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
                    .toString())
            .setReleaseConfig(
                ReleaseConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                    .toString())
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setCronSchedule("cronSchedule-1022672059")
            .setTimeZone("timeZone-2077180903")
            .addAllRecentScheduledExecutionRecords(
                new ArrayList<WorkflowConfig.ScheduledExecutionRecord>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkflowConfig actualResponse = client.updateWorkflowConfig(workflowConfig, updateMask);
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
  public void updateWorkflowConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowConfig workflowConfig =
          WorkflowConfig.newBuilder()
              .setName(
                  WorkflowConfigName.of(
                          "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]")
                      .toString())
              .setReleaseConfig(
                  ReleaseConfigName.of(
                          "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RELEASE_CONFIG]")
                      .toString())
              .setInvocationConfig(InvocationConfig.newBuilder().build())
              .setCronSchedule("cronSchedule-1022672059")
              .setTimeZone("timeZone-2077180903")
              .addAllRecentScheduledExecutionRecords(
                  new ArrayList<WorkflowConfig.ScheduledExecutionRecord>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setInternalMetadata("internalMetadata6789388")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkflowConfig(workflowConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkflowConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    WorkflowConfigName name =
        WorkflowConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]");

    client.deleteWorkflowConfig(name);

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
  public void deleteWorkflowConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkflowConfigName name =
          WorkflowConfigName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_CONFIG]");
      client.deleteWorkflowConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkflowConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9018/locations/location-9018/repositories/repositorie-9018/workflowConfigs/workflowConfig-9018";

    client.deleteWorkflowConfig(name);

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
  public void deleteWorkflowConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9018/locations/location-9018/repositories/repositorie-9018/workflowConfigs/workflowConfig-9018";
      client.deleteWorkflowConfig(name);
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
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setInvocationTiming(Interval.newBuilder().build())
            .setResolvedCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setInvocationTiming(Interval.newBuilder().build())
            .setResolvedCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setInvocationTiming(Interval.newBuilder().build())
            .setResolvedCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
            .setInvocationConfig(InvocationConfig.newBuilder().build())
            .setInvocationTiming(Interval.newBuilder().build())
            .setResolvedCompilationResult(
                CompilationResultName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[COMPILATION_RESULT]")
                    .toString())
            .setDataEncryptionState(DataEncryptionState.newBuilder().build())
            .setInternalMetadata("internalMetadata6789388")
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
    CancelWorkflowInvocationResponse expectedResponse =
        CancelWorkflowInvocationResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CancelWorkflowInvocationRequest request =
        CancelWorkflowInvocationRequest.newBuilder()
            .setName(
                WorkflowInvocationName.of(
                        "[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[WORKFLOW_INVOCATION]")
                    .toString())
            .build();

    CancelWorkflowInvocationResponse actualResponse = client.cancelWorkflowInvocation(request);
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
  public void getConfigTest() throws Exception {
    Config expectedResponse =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setDefaultKmsKeyName("defaultKmsKeyName725296666")
            .build();
    mockService.addResponse(expectedResponse);

    ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");

    Config actualResponse = client.getConfig(name);
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
  public void getConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConfigName name = ConfigName.of("[PROJECT]", "[LOCATION]");
      client.getConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConfigTest2() throws Exception {
    Config expectedResponse =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setDefaultKmsKeyName("defaultKmsKeyName725296666")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-505/locations/location-505/config";

    Config actualResponse = client.getConfig(name);
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
  public void getConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-505/locations/location-505/config";
      client.getConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConfigTest() throws Exception {
    Config expectedResponse =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setDefaultKmsKeyName("defaultKmsKeyName725296666")
            .build();
    mockService.addResponse(expectedResponse);

    Config config =
        Config.newBuilder()
            .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .setDefaultKmsKeyName("defaultKmsKeyName725296666")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Config actualResponse = client.updateConfig(config, updateMask);
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
  public void updateConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Config config =
          Config.newBuilder()
              .setName(ConfigName.of("[PROJECT]", "[LOCATION]").toString())
              .setDefaultKmsKeyName("defaultKmsKeyName725296666")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConfig(config, updateMask);
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
            .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
              .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
            .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
              .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
            .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
              .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
