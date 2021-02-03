/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloudbuild.v1.Artifacts;
import com.google.cloudbuild.v1.Build;
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
import com.google.cloudbuild.v1.RepoSource;
import com.google.cloudbuild.v1.Results;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.Secret;
import com.google.cloudbuild.v1.ServiceAccountName;
import com.google.cloudbuild.v1.Source;
import com.google.cloudbuild.v1.SourceProvenance;
import com.google.cloudbuild.v1.TimeSpan;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerConfig;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
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
  private static MockServiceHelper mockServiceHelper;
  private CloudBuildClient client;
  private static MockCloudBuild mockCloudBuild;
  private LocalChannelProvider channelProvider;

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
            .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
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
            .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
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
            .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
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
            .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
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
  public void createBuildTriggerTest() throws Exception {
    BuildTrigger expectedResponse =
        BuildTrigger.newBuilder()
            .setId("id3355")
            .setDescription("description-1724546052")
            .setName(BuildTriggerName.of("[PROJECT]", "[TRIGGER]").toString())
            .addAllTags(new ArrayList<String>())
            .setTriggerTemplate(RepoSource.newBuilder().build())
            .setGithub(GitHubEventsConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllIgnoredFiles(new ArrayList<String>())
            .addAllIncludedFiles(new ArrayList<String>())
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
            .setId("id3355")
            .setDescription("description-1724546052")
            .setName(BuildTriggerName.of("[PROJECT]", "[TRIGGER]").toString())
            .addAllTags(new ArrayList<String>())
            .setTriggerTemplate(RepoSource.newBuilder().build())
            .setGithub(GitHubEventsConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllIgnoredFiles(new ArrayList<String>())
            .addAllIncludedFiles(new ArrayList<String>())
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
            .setId("id3355")
            .setDescription("description-1724546052")
            .setName(BuildTriggerName.of("[PROJECT]", "[TRIGGER]").toString())
            .addAllTags(new ArrayList<String>())
            .setTriggerTemplate(RepoSource.newBuilder().build())
            .setGithub(GitHubEventsConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .putAllSubstitutions(new HashMap<String, String>())
            .addAllIgnoredFiles(new ArrayList<String>())
            .addAllIncludedFiles(new ArrayList<String>())
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
            .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
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
  public void createWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName("name3373707")
            .setProjectId("projectId-894832108")
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setWorkerCount(372044046)
            .setWorkerConfig(WorkerConfig.newBuilder().build())
            .addAllRegions(new ArrayList<WorkerPool.Region>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    CreateWorkerPoolRequest request =
        CreateWorkerPoolRequest.newBuilder()
            .setParent("parent-995424086")
            .setWorkerPool(WorkerPool.newBuilder().build())
            .build();

    WorkerPool actualResponse = client.createWorkerPool(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkerPoolRequest actualRequest = ((CreateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getWorkerPool(), actualRequest.getWorkerPool());
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
      CreateWorkerPoolRequest request =
          CreateWorkerPoolRequest.newBuilder()
              .setParent("parent-995424086")
              .setWorkerPool(WorkerPool.newBuilder().build())
              .build();
      client.createWorkerPool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName("name3373707")
            .setProjectId("projectId-894832108")
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setWorkerCount(372044046)
            .setWorkerConfig(WorkerConfig.newBuilder().build())
            .addAllRegions(new ArrayList<WorkerPool.Region>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    GetWorkerPoolRequest request = GetWorkerPoolRequest.newBuilder().setName("name3373707").build();

    WorkerPool actualResponse = client.getWorkerPool(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkerPoolRequest actualRequest = ((GetWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      GetWorkerPoolRequest request =
          GetWorkerPoolRequest.newBuilder().setName("name3373707").build();
      client.getWorkerPool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkerPoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudBuild.addResponse(expectedResponse);

    DeleteWorkerPoolRequest request =
        DeleteWorkerPoolRequest.newBuilder().setName("name3373707").build();

    client.deleteWorkerPool(request);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkerPoolRequest actualRequest = ((DeleteWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
      DeleteWorkerPoolRequest request =
          DeleteWorkerPoolRequest.newBuilder().setName("name3373707").build();
      client.deleteWorkerPool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateWorkerPoolTest() throws Exception {
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName("name3373707")
            .setProjectId("projectId-894832108")
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setWorkerCount(372044046)
            .setWorkerConfig(WorkerConfig.newBuilder().build())
            .addAllRegions(new ArrayList<WorkerPool.Region>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    UpdateWorkerPoolRequest request =
        UpdateWorkerPoolRequest.newBuilder()
            .setName("name3373707")
            .setWorkerPool(WorkerPool.newBuilder().build())
            .build();

    WorkerPool actualResponse = client.updateWorkerPool(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkerPoolRequest actualRequest = ((UpdateWorkerPoolRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getWorkerPool(), actualRequest.getWorkerPool());
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
      UpdateWorkerPoolRequest request =
          UpdateWorkerPoolRequest.newBuilder()
              .setName("name3373707")
              .setWorkerPool(WorkerPool.newBuilder().build())
              .build();
      client.updateWorkerPool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkerPoolsTest() throws Exception {
    ListWorkerPoolsResponse expectedResponse =
        ListWorkerPoolsResponse.newBuilder().addAllWorkerPools(new ArrayList<WorkerPool>()).build();
    mockCloudBuild.addResponse(expectedResponse);

    ListWorkerPoolsRequest request =
        ListWorkerPoolsRequest.newBuilder().setParent("parent-995424086").build();

    ListWorkerPoolsResponse actualResponse = client.listWorkerPools(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkerPoolsRequest actualRequest = ((ListWorkerPoolsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
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
      ListWorkerPoolsRequest request =
          ListWorkerPoolsRequest.newBuilder().setParent("parent-995424086").build();
      client.listWorkerPools(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
