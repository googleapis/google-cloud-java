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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloudbuild.v1.ApprovalResult;
import com.google.cloudbuild.v1.ApproveBuildRequest;
import com.google.cloudbuild.v1.Artifacts;
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildApproval;
import com.google.cloudbuild.v1.BuildName;
import com.google.cloudbuild.v1.BuildOptions;
import com.google.cloudbuild.v1.BuildStep;
import com.google.cloudbuild.v1.BuildTrigger;
import com.google.cloudbuild.v1.BuildTriggerName;
import com.google.cloudbuild.v1.CancelBuildRequest;
import com.google.cloudbuild.v1.CreateBuildRequest;
import com.google.cloudbuild.v1.CreateBuildTriggerRequest;
import com.google.cloudbuild.v1.CreateWorkerPoolRequest;
import com.google.cloudbuild.v1.DeleteBuildTriggerRequest;
import com.google.cloudbuild.v1.DeleteWorkerPoolRequest;
import com.google.cloudbuild.v1.GetBuildRequest;
import com.google.cloudbuild.v1.GetBuildTriggerRequest;
import com.google.cloudbuild.v1.GetWorkerPoolRequest;
import com.google.cloudbuild.v1.GitHubEventsConfig;
import com.google.cloudbuild.v1.ListBuildTriggersRequest;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsRequest;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsRequest;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.LocationName;
import com.google.cloudbuild.v1.PubsubConfig;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse;
import com.google.cloudbuild.v1.RepoSource;
import com.google.cloudbuild.v1.Results;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.Secret;
import com.google.cloudbuild.v1.Secrets;
import com.google.cloudbuild.v1.Source;
import com.google.cloudbuild.v1.SourceProvenance;
import com.google.cloudbuild.v1.TimeSpan;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WebhookConfig;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.cloudbuild.v1.WorkerPoolName;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
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
public class CloudBuildClientTest {
  private static MockCloudBuild mockCloudBuild;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudBuildClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudBuild = new MockCloudBuild();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudBuild));
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
    CloudBuildSettings settings =
        CloudBuildSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudBuildClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockCloudBuild.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    Build build = Build.newBuilder().build();

    Build actualResponse = client.createBuildAsync(projectId, build).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBuildRequest actualRequest = ((CreateBuildRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(build, actualRequest.getBuild());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      Build build = Build.newBuilder().build();
      client.createBuildAsync(projectId, build).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String id = "id3355";

    Build actualResponse = client.getBuild(projectId, id);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBuildRequest actualRequest = ((GetBuildRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(id, actualRequest.getId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String id = "id3355";
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
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String filter = "filter-1274492040";

    ListBuildsPagedResponse pagedListResponse = client.listBuilds(projectId, filter);

    List<Build> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBuildsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBuildsRequest actualRequest = ((ListBuildsRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBuildsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
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
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String id = "id3355";

    Build actualResponse = client.cancelBuild(projectId, id);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelBuildRequest actualRequest = ((CancelBuildRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(id, actualRequest.getId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String id = "id3355";
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
    mockCloudBuild.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    String id = "id3355";

    Build actualResponse = client.retryBuildAsync(projectId, id).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetryBuildRequest actualRequest = ((RetryBuildRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(id, actualRequest.getId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retryBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String id = "id3355";
      client.retryBuildAsync(projectId, id).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudBuild.addResponse(resultOperation);

    String name = "name3373707";
    ApprovalResult approvalResult = ApprovalResult.newBuilder().build();

    Build actualResponse = client.approveBuildAsync(name, approvalResult).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApproveBuildRequest actualRequest = ((ApproveBuildRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(approvalResult, actualRequest.getApprovalResult());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void approveBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String name = "name3373707";
      ApprovalResult approvalResult = ApprovalResult.newBuilder().build();
      client.approveBuildAsync(name, approvalResult).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    BuildTrigger trigger = BuildTrigger.newBuilder().build();

    BuildTrigger actualResponse = client.createBuildTrigger(projectId, trigger);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBuildTriggerRequest actualRequest = ((CreateBuildTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(trigger, actualRequest.getTrigger());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
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
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String triggerId = "triggerId-648752909";

    BuildTrigger actualResponse = client.getBuildTrigger(projectId, triggerId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBuildTriggerRequest actualRequest = ((GetBuildTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String triggerId = "triggerId-648752909";
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
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-894832108";

    ListBuildTriggersPagedResponse pagedListResponse = client.listBuildTriggers(projectId);

    List<BuildTrigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTriggersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBuildTriggersRequest actualRequest = ((ListBuildTriggersRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBuildTriggersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      client.listBuildTriggers(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBuildTriggerTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String triggerId = "triggerId-648752909";

    client.deleteBuildTrigger(projectId, triggerId);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBuildTriggerRequest actualRequest = ((DeleteBuildTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String triggerId = "triggerId-648752909";
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
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String triggerId = "triggerId-648752909";
    BuildTrigger trigger = BuildTrigger.newBuilder().build();

    BuildTrigger actualResponse = client.updateBuildTrigger(projectId, triggerId, trigger);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBuildTriggerRequest actualRequest = ((UpdateBuildTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertEquals(trigger, actualRequest.getTrigger());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String triggerId = "triggerId-648752909";
      BuildTrigger trigger = BuildTrigger.newBuilder().build();
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
    mockCloudBuild.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    String triggerId = "triggerId-648752909";
    RepoSource source = RepoSource.newBuilder().build();

    Build actualResponse = client.runBuildTriggerAsync(projectId, triggerId, source).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunBuildTriggerRequest actualRequest = ((RunBuildTriggerRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String triggerId = "triggerId-648752909";
      RepoSource source = RepoSource.newBuilder().build();
      client.runBuildTriggerAsync(projectId, triggerId, source).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void receiveTriggerWebhookTest() throws Exception {
    ReceiveTriggerWebhookResponse expectedResponse =
        ReceiveTriggerWebhookResponse.newBuilder().build();
    mockCloudBuild.addResponse(expectedResponse);

    ReceiveTriggerWebhookRequest request =
        ReceiveTriggerWebhookRequest.newBuilder()
            .setName("name3373707")
            .setBody(HttpBody.newBuilder().build())
            .setProjectId("projectId-894832108")
            .setTrigger("trigger-1059891784")
            .setSecret("secret-906277200")
            .build();

    ReceiveTriggerWebhookResponse actualResponse = client.receiveTriggerWebhook(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReceiveTriggerWebhookRequest actualRequest =
        ((ReceiveTriggerWebhookRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getTrigger(), actualRequest.getTrigger());
    Assert.assertEquals(request.getSecret(), actualRequest.getSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void receiveTriggerWebhookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      ReceiveTriggerWebhookRequest request =
          ReceiveTriggerWebhookRequest.newBuilder()
              .setName("name3373707")
              .setBody(HttpBody.newBuilder().build())
              .setProjectId("projectId-894832108")
              .setTrigger("trigger-1059891784")
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
    mockCloudBuild.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    WorkerPool workerPool = WorkerPool.newBuilder().build();
    String workerPoolId = "workerPoolId-46320779";

    WorkerPool actualResponse =
        client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkerPoolRequest actualRequest = ((CreateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workerPool, actualRequest.getWorkerPool());
    Assert.assertEquals(workerPoolId, actualRequest.getWorkerPoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      String workerPoolId = "workerPoolId-46320779";
      client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudBuild.addResponse(resultOperation);

    String parent = "parent-995424086";
    WorkerPool workerPool = WorkerPool.newBuilder().build();
    String workerPoolId = "workerPoolId-46320779";

    WorkerPool actualResponse =
        client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkerPoolRequest actualRequest = ((CreateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workerPool, actualRequest.getWorkerPool());
    Assert.assertEquals(workerPoolId, actualRequest.getWorkerPoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkerPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String parent = "parent-995424086";
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      String workerPoolId = "workerPoolId-46320779";
      client.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudBuild.addResponse(expectedResponse);

    WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");

    WorkerPool actualResponse = client.getWorkerPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkerPoolRequest actualRequest = ((GetWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

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
    mockCloudBuild.addResponse(expectedResponse);

    String name = "name3373707";

    WorkerPool actualResponse = client.getWorkerPool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkerPoolRequest actualRequest = ((GetWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkerPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String name = "name3373707";
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
    mockCloudBuild.addResponse(resultOperation);

    WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");

    client.deleteWorkerPoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkerPoolRequest actualRequest = ((DeleteWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
      client.deleteWorkerPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudBuild.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteWorkerPoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkerPoolRequest actualRequest = ((DeleteWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkerPoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkerPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudBuild.addResponse(resultOperation);

    WorkerPool workerPool = WorkerPool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WorkerPool actualResponse = client.updateWorkerPoolAsync(workerPool, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkerPoolRequest actualRequest = ((UpdateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(workerPool, actualRequest.getWorkerPool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      WorkerPool workerPool = WorkerPool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkerPoolAsync(workerPool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCloudBuild.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListWorkerPoolsPagedResponse pagedListResponse = client.listWorkerPools(parent);

    List<WorkerPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkerPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkerPoolsRequest actualRequest = ((ListWorkerPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkerPoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

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
    mockCloudBuild.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkerPoolsPagedResponse pagedListResponse = client.listWorkerPools(parent);

    List<WorkerPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkerPoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkerPoolsRequest actualRequest = ((ListWorkerPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkerPoolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkerPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
