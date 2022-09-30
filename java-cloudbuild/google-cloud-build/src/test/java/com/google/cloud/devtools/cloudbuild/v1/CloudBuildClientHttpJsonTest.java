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

package com.google.cloud.devtools.cloudbuild.v1;

import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildTriggersPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildsPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListWorkerPoolsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.devtools.cloudbuild.v1.stub.HttpJsonCloudBuildStub;
import com.google.cloudbuild.v1.ApprovalResult;
import com.google.cloudbuild.v1.Artifacts;
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildApproval;
import com.google.cloudbuild.v1.BuildName;
import com.google.cloudbuild.v1.BuildOptions;
import com.google.cloudbuild.v1.BuildStep;
import com.google.cloudbuild.v1.BuildTrigger;
import com.google.cloudbuild.v1.BuildTriggerName;
import com.google.cloudbuild.v1.GitHubEventsConfig;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.LocationName;
import com.google.cloudbuild.v1.PubsubConfig;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse;
import com.google.cloudbuild.v1.RepoSource;
import com.google.cloudbuild.v1.Results;
import com.google.cloudbuild.v1.Secret;
import com.google.cloudbuild.v1.Secrets;
import com.google.cloudbuild.v1.Source;
import com.google.cloudbuild.v1.SourceProvenance;
import com.google.cloudbuild.v1.TimeSpan;
import com.google.cloudbuild.v1.WebhookConfig;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.cloudbuild.v1.WorkerPoolName;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
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
public class CloudBuildClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudBuildClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudBuildStub.getMethodDescriptors(), CloudBuildSettings.getDefaultEndpoint());
    CloudBuildSettings settings =
        CloudBuildSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudBuildSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudBuildClient.create(settings);
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
  public void createBuildTest() throws Exception {
    Build expectedResponse =
        Build.newBuilder()
            .setName(BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]").toString())
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setStatusDetail("statusDetail1651087075")
            .setSource(Source.newBuilder().build())
            .addAllSteps(new ArrayList<BuildStep>())
            .setResults(Results.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllImages(new ArrayList<String>())
            .setQueueTtl(Duration.newBuilder().build())
            .setArtifacts(Artifacts.newBuilder().build())
            .setLogsBucket("logsBucket1592573049")
            .setSourceProvenance(SourceProvenance.newBuilder().build())
            .setBuildTriggerId("buildTriggerId781747749")
            .setOptions(BuildOptions.newBuilder().build())
            .setLogUrl("logUrl-1097354357")
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllSecrets(new ArrayList<Secret>())
            .putAllTiming(new HashMap<String, TimeSpan>())
            .setApproval(BuildApproval.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setAvailableSecrets(Secrets.newBuilder().build())
            .addAllWarnings(new ArrayList<Build.Warning>())
            .setFailureInfo(Build.FailureInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBuildTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    Build build = Build.newBuilder().build();

    Build actualResponse = client.createBuildAsync(projectId, build).get();
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
  public void createBuildExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      Build build = Build.newBuilder().build();
      client.createBuildAsync(projectId, build).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getBuildTest() throws Exception {
    Build expectedResponse =
        Build.newBuilder()
            .setName(BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]").toString())
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setStatusDetail("statusDetail1651087075")
            .setSource(Source.newBuilder().build())
            .addAllSteps(new ArrayList<BuildStep>())
            .setResults(Results.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllImages(new ArrayList<String>())
            .setQueueTtl(Duration.newBuilder().build())
            .setArtifacts(Artifacts.newBuilder().build())
            .setLogsBucket("logsBucket1592573049")
            .setSourceProvenance(SourceProvenance.newBuilder().build())
            .setBuildTriggerId("buildTriggerId781747749")
            .setOptions(BuildOptions.newBuilder().build())
            .setLogUrl("logUrl-1097354357")
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllSecrets(new ArrayList<Secret>())
            .putAllTiming(new HashMap<String, TimeSpan>())
            .setApproval(BuildApproval.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setAvailableSecrets(Secrets.newBuilder().build())
            .addAllWarnings(new ArrayList<Build.Warning>())
            .setFailureInfo(Build.FailureInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String id = "id-4047";

    Build actualResponse = client.getBuild(projectId, id);
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
  public void getBuildExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String id = "id-4047";
      client.getBuild(projectId, id);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBuildsTest() throws Exception {
    Build responsesElement = Build.newBuilder().build();
    ListBuildsResponse expectedResponse =
        ListBuildsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuilds(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String filter = "filter-1274492040";

    ListBuildsPagedResponse pagedListResponse = client.listBuilds(projectId, filter);

    List<Build> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBuildsList().get(0), resources.get(0));

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
  public void listBuildsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String filter = "filter-1274492040";
      client.listBuilds(projectId, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelBuildTest() throws Exception {
    Build expectedResponse =
        Build.newBuilder()
            .setName(BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]").toString())
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setStatusDetail("statusDetail1651087075")
            .setSource(Source.newBuilder().build())
            .addAllSteps(new ArrayList<BuildStep>())
            .setResults(Results.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllImages(new ArrayList<String>())
            .setQueueTtl(Duration.newBuilder().build())
            .setArtifacts(Artifacts.newBuilder().build())
            .setLogsBucket("logsBucket1592573049")
            .setSourceProvenance(SourceProvenance.newBuilder().build())
            .setBuildTriggerId("buildTriggerId781747749")
            .setOptions(BuildOptions.newBuilder().build())
            .setLogUrl("logUrl-1097354357")
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllSecrets(new ArrayList<Secret>())
            .putAllTiming(new HashMap<String, TimeSpan>())
            .setApproval(BuildApproval.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setAvailableSecrets(Secrets.newBuilder().build())
            .addAllWarnings(new ArrayList<Build.Warning>())
            .setFailureInfo(Build.FailureInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String id = "id-4047";

    Build actualResponse = client.cancelBuild(projectId, id);
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
  public void cancelBuildExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String id = "id-4047";
      client.cancelBuild(projectId, id);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retryBuildTest() throws Exception {
    Build expectedResponse =
        Build.newBuilder()
            .setName(BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]").toString())
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setStatusDetail("statusDetail1651087075")
            .setSource(Source.newBuilder().build())
            .addAllSteps(new ArrayList<BuildStep>())
            .setResults(Results.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllImages(new ArrayList<String>())
            .setQueueTtl(Duration.newBuilder().build())
            .setArtifacts(Artifacts.newBuilder().build())
            .setLogsBucket("logsBucket1592573049")
            .setSourceProvenance(SourceProvenance.newBuilder().build())
            .setBuildTriggerId("buildTriggerId781747749")
            .setOptions(BuildOptions.newBuilder().build())
            .setLogUrl("logUrl-1097354357")
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllSecrets(new ArrayList<Secret>())
            .putAllTiming(new HashMap<String, TimeSpan>())
            .setApproval(BuildApproval.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setAvailableSecrets(Secrets.newBuilder().build())
            .addAllWarnings(new ArrayList<Build.Warning>())
            .setFailureInfo(Build.FailureInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("retryBuildTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    String id = "id-4047";

    Build actualResponse = client.retryBuildAsync(projectId, id).get();
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
  public void retryBuildExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String id = "id-4047";
      client.retryBuildAsync(projectId, id).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void approveBuildTest() throws Exception {
    Build expectedResponse =
        Build.newBuilder()
            .setName(BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]").toString())
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setStatusDetail("statusDetail1651087075")
            .setSource(Source.newBuilder().build())
            .addAllSteps(new ArrayList<BuildStep>())
            .setResults(Results.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllImages(new ArrayList<String>())
            .setQueueTtl(Duration.newBuilder().build())
            .setArtifacts(Artifacts.newBuilder().build())
            .setLogsBucket("logsBucket1592573049")
            .setSourceProvenance(SourceProvenance.newBuilder().build())
            .setBuildTriggerId("buildTriggerId781747749")
            .setOptions(BuildOptions.newBuilder().build())
            .setLogUrl("logUrl-1097354357")
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllSecrets(new ArrayList<Secret>())
            .putAllTiming(new HashMap<String, TimeSpan>())
            .setApproval(BuildApproval.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setAvailableSecrets(Secrets.newBuilder().build())
            .addAllWarnings(new ArrayList<Build.Warning>())
            .setFailureInfo(Build.FailureInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("approveBuildTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3679/builds/build-3679";
    ApprovalResult approvalResult = ApprovalResult.newBuilder().build();

    Build actualResponse = client.approveBuildAsync(name, approvalResult).get();
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
  public void approveBuildExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3679/builds/build-3679";
      ApprovalResult approvalResult = ApprovalResult.newBuilder().build();
      client.approveBuildAsync(name, approvalResult).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createBuildTriggerTest() throws Exception {
    BuildTrigger expectedResponse =
        BuildTrigger.newBuilder()
            .setResourceName("resourceName-384566343")
            .setId("id3355")
            .setDescription("description-1724546052")
            .setName(BuildTriggerName.ofProjectTriggerName("[PROJECT]", "[TRIGGER]").toString())
            .addAllTags(new ArrayList<String>())
            .setTriggerTemplate(RepoSource.newBuilder().build())
            .setGithub(GitHubEventsConfig.newBuilder().build())
            .setPubsubConfig(PubsubConfig.newBuilder().build())
            .setWebhookConfig(WebhookConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllIgnoredFiles(new ArrayList<String>())
            .addAllIncludedFiles(new ArrayList<String>())
            .setFilter("filter-1274492040")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    BuildTrigger trigger = BuildTrigger.newBuilder().build();

    BuildTrigger actualResponse = client.createBuildTrigger(projectId, trigger);
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
  public void createBuildTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      BuildTrigger trigger = BuildTrigger.newBuilder().build();
      client.createBuildTrigger(projectId, trigger);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBuildTriggerTest() throws Exception {
    BuildTrigger expectedResponse =
        BuildTrigger.newBuilder()
            .setResourceName("resourceName-384566343")
            .setId("id3355")
            .setDescription("description-1724546052")
            .setName(BuildTriggerName.ofProjectTriggerName("[PROJECT]", "[TRIGGER]").toString())
            .addAllTags(new ArrayList<String>())
            .setTriggerTemplate(RepoSource.newBuilder().build())
            .setGithub(GitHubEventsConfig.newBuilder().build())
            .setPubsubConfig(PubsubConfig.newBuilder().build())
            .setWebhookConfig(WebhookConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllIgnoredFiles(new ArrayList<String>())
            .addAllIncludedFiles(new ArrayList<String>())
            .setFilter("filter-1274492040")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String triggerId = "triggerId-6343";

    BuildTrigger actualResponse = client.getBuildTrigger(projectId, triggerId);
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
  public void getBuildTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String triggerId = "triggerId-6343";
      client.getBuildTrigger(projectId, triggerId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBuildTriggersTest() throws Exception {
    BuildTrigger responsesElement = BuildTrigger.newBuilder().build();
    ListBuildTriggersResponse expectedResponse =
        ListBuildTriggersResponse.newBuilder()
            .setNextPageToken("")
            .addAllTriggers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";

    ListBuildTriggersPagedResponse pagedListResponse = client.listBuildTriggers(projectId);

    List<BuildTrigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTriggersList().get(0), resources.get(0));

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
  public void listBuildTriggersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      client.listBuildTriggers(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBuildTriggerTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String triggerId = "triggerId-6343";

    client.deleteBuildTrigger(projectId, triggerId);

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
  public void deleteBuildTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String triggerId = "triggerId-6343";
      client.deleteBuildTrigger(projectId, triggerId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBuildTriggerTest() throws Exception {
    BuildTrigger expectedResponse =
        BuildTrigger.newBuilder()
            .setResourceName("resourceName-384566343")
            .setId("id3355")
            .setDescription("description-1724546052")
            .setName(BuildTriggerName.ofProjectTriggerName("[PROJECT]", "[TRIGGER]").toString())
            .addAllTags(new ArrayList<String>())
            .setTriggerTemplate(RepoSource.newBuilder().build())
            .setGithub(GitHubEventsConfig.newBuilder().build())
            .setPubsubConfig(PubsubConfig.newBuilder().build())
            .setWebhookConfig(WebhookConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllIgnoredFiles(new ArrayList<String>())
            .addAllIncludedFiles(new ArrayList<String>())
            .setFilter("filter-1274492040")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    String triggerId = "triggerId-6343";
    BuildTrigger trigger =
        BuildTrigger.newBuilder()
            .setResourceName("resourceName-384566343")
            .setId("id3355")
            .setDescription("description-1724546052")
            .setName(BuildTriggerName.ofProjectTriggerName("[PROJECT]", "[TRIGGER]").toString())
            .addAllTags(new ArrayList<String>())
            .setTriggerTemplate(RepoSource.newBuilder().build())
            .setGithub(GitHubEventsConfig.newBuilder().build())
            .setPubsubConfig(PubsubConfig.newBuilder().build())
            .setWebhookConfig(WebhookConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllIgnoredFiles(new ArrayList<String>())
            .addAllIncludedFiles(new ArrayList<String>())
            .setFilter("filter-1274492040")
            .setServiceAccount("serviceAccount1079137720")
            .build();

    BuildTrigger actualResponse = client.updateBuildTrigger(projectId, triggerId, trigger);
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
  public void updateBuildTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String triggerId = "triggerId-6343";
      BuildTrigger trigger =
          BuildTrigger.newBuilder()
              .setResourceName("resourceName-384566343")
              .setId("id3355")
              .setDescription("description-1724546052")
              .setName(BuildTriggerName.ofProjectTriggerName("[PROJECT]", "[TRIGGER]").toString())
              .addAllTags(new ArrayList<String>())
              .setTriggerTemplate(RepoSource.newBuilder().build())
              .setGithub(GitHubEventsConfig.newBuilder().build())
              .setPubsubConfig(PubsubConfig.newBuilder().build())
              .setWebhookConfig(WebhookConfig.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setDisabled(true)
              .putAllSubstitutions(new HashMap<String, String>())
              .addAllIgnoredFiles(new ArrayList<String>())
              .addAllIncludedFiles(new ArrayList<String>())
              .setFilter("filter-1274492040")
              .setServiceAccount("serviceAccount1079137720")
              .build();
      client.updateBuildTrigger(projectId, triggerId, trigger);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runBuildTriggerTest() throws Exception {
    Build expectedResponse =
        Build.newBuilder()
            .setName(BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]").toString())
            .setId("id3355")
            .setProjectId("projectId-894832108")
            .setStatusDetail("statusDetail1651087075")
            .setSource(Source.newBuilder().build())
            .addAllSteps(new ArrayList<BuildStep>())
            .setResults(Results.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setTimeout(Duration.newBuilder().build())
            .addAllImages(new ArrayList<String>())
            .setQueueTtl(Duration.newBuilder().build())
            .setArtifacts(Artifacts.newBuilder().build())
            .setLogsBucket("logsBucket1592573049")
            .setSourceProvenance(SourceProvenance.newBuilder().build())
            .setBuildTriggerId("buildTriggerId781747749")
            .setOptions(BuildOptions.newBuilder().build())
            .setLogUrl("logUrl-1097354357")
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .addAllSecrets(new ArrayList<Secret>())
            .putAllTiming(new HashMap<String, TimeSpan>())
            .setApproval(BuildApproval.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setAvailableSecrets(Secrets.newBuilder().build())
            .addAllWarnings(new ArrayList<Build.Warning>())
            .setFailureInfo(Build.FailureInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runBuildTriggerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String projectId = "projectId-1530";
    String triggerId = "triggerId-6343";
    RepoSource source = RepoSource.newBuilder().build();

    Build actualResponse = client.runBuildTriggerAsync(projectId, triggerId, source).get();
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
  public void runBuildTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      String triggerId = "triggerId-6343";
      RepoSource source = RepoSource.newBuilder().build();
      client.runBuildTriggerAsync(projectId, triggerId, source).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void receiveTriggerWebhookTest() throws Exception {
    ReceiveTriggerWebhookResponse expectedResponse =
        ReceiveTriggerWebhookResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ReceiveTriggerWebhookRequest request =
        ReceiveTriggerWebhookRequest.newBuilder()
            .setName("name3373707")
            .setBody(HttpBody.newBuilder().build())
            .setProjectId("projectId-1530")
            .setTrigger("trigger-3106")
            .setSecret("secret-906277200")
            .build();

    ReceiveTriggerWebhookResponse actualResponse = client.receiveTriggerWebhook(request);
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
  public void receiveTriggerWebhookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReceiveTriggerWebhookRequest request =
          ReceiveTriggerWebhookRequest.newBuilder()
              .setName("name3373707")
              .setBody(HttpBody.newBuilder().build())
              .setProjectId("projectId-1530")
              .setTrigger("trigger-3106")
              .setSecret("secret-906277200")
              .build();
      client.receiveTriggerWebhook(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    WorkerPool workerPool = WorkerPool.newBuilder().build();
    String workerPoolId = "workerPoolId-46320779";

    WorkerPool actualResponse =
        client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
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
  public void createWorkerPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      String workerPoolId = "workerPoolId-46320779";
      client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createWorkerPoolTest2() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    WorkerPool workerPool = WorkerPool.newBuilder().build();
    String workerPoolId = "workerPoolId-46320779";

    WorkerPool actualResponse =
        client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
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
  public void createWorkerPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      String workerPoolId = "workerPoolId-46320779";
      client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");

    WorkerPool actualResponse = client.getWorkerPool(name);
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
  public void getWorkerPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
      client.getWorkerPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkerPoolTest2() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9807/locations/location-9807/workerPools/workerPool-9807";

    WorkerPool actualResponse = client.getWorkerPool(name);
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
  public void getWorkerPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9807/locations/location-9807/workerPools/workerPool-9807";
      client.getWorkerPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkerPoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");

    client.deleteWorkerPoolAsync(name).get();

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
  public void deleteWorkerPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
      client.deleteWorkerPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteWorkerPoolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9807/locations/location-9807/workerPools/workerPool-9807";

    client.deleteWorkerPoolAsync(name).get();

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
  public void deleteWorkerPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9807/locations/location-9807/workerPools/workerPool-9807";
      client.deleteWorkerPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateWorkerPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WorkerPool workerPool =
        WorkerPool.newBuilder()
            .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkerPool actualResponse = client.updateWorkerPoolAsync(workerPool, updateMask).get();
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
  public void updateWorkerPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WorkerPool workerPool =
          WorkerPool.newBuilder()
              .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
              .setDisplayName("displayName1714148973")
              .setUid("uid115792")
              .putAllAnnotations(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkerPoolAsync(workerPool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listWorkerPoolsTest() throws Exception {
    WorkerPool responsesElement = WorkerPool.newBuilder().build();
    ListWorkerPoolsResponse expectedResponse =
        ListWorkerPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkerPools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListWorkerPoolsPagedResponse pagedListResponse = client.listWorkerPools(parent);

    List<WorkerPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkerPoolsList().get(0), resources.get(0));

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
  public void listWorkerPoolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listWorkerPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkerPoolsTest2() throws Exception {
    WorkerPool responsesElement = WorkerPool.newBuilder().build();
    ListWorkerPoolsResponse expectedResponse =
        ListWorkerPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkerPools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListWorkerPoolsPagedResponse pagedListResponse = client.listWorkerPools(parent);

    List<WorkerPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkerPoolsList().get(0), resources.get(0));

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
  public void listWorkerPoolsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listWorkerPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
