/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildName;
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
import com.google.cloudbuild.v1.ListBuildTriggersRequest;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsRequest;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsRequest;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.RepoSource;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.ServiceAccountName;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class CloudBuildClientTest {
  private static MockCloudBuild mockCloudBuild;
  private static MockServiceHelper serviceHelper;
  private CloudBuildClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudBuild = new MockCloudBuild();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudBuild));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void listBuildsTest() {
    String nextPageToken = "";
    Build buildsElement = Build.newBuilder().build();
    List<Build> builds = Arrays.asList(buildsElement);
    ListBuildsResponse expectedResponse =
        ListBuildsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllBuilds(builds)
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String filter = "filter-1274492040";

    ListBuildsPagedResponse pagedListResponse = client.listBuilds(projectId, filter);

    List<Build> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBuildsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBuildsRequest actualRequest = (ListBuildsRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listBuildsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String filter = "filter-1274492040";

      client.listBuilds(projectId, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteBuildTriggerTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String triggerId = "triggerId1363517698";

    client.deleteBuildTrigger(projectId, triggerId);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBuildTriggerRequest actualRequest = (DeleteBuildTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String triggerId = "triggerId1363517698";

      client.deleteBuildTrigger(projectId, triggerId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createBuildTest() throws Exception {
    BuildName name = BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]");
    String id = "id3355";
    String projectId2 = "projectId2939242356";
    String statusDetail = "statusDetail2089931070";
    String logsBucket = "logsBucket1565363834";
    String buildTriggerId = "buildTriggerId1105559411";
    String logUrl = "logUrl342054388";
    ServiceAccountName serviceAccount = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    Build expectedResponse =
        Build.newBuilder()
            .setName(name.toString())
            .setId(id)
            .setProjectId(projectId2)
            .setStatusDetail(statusDetail)
            .setLogsBucket(logsBucket)
            .setBuildTriggerId(buildTriggerId)
            .setLogUrl(logUrl)
            .setServiceAccount(serviceAccount.toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBuildTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudBuild.addResponse(resultOperation);

    String projectId = "projectId-1969970175";
    Build build = Build.newBuilder().build();

    Build actualResponse = client.createBuildAsync(projectId, build).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBuildRequest actualRequest = (CreateBuildRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(build, actualRequest.getBuild());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      Build build = Build.newBuilder().build();

      client.createBuildAsync(projectId, build).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getBuildTest() {
    BuildName name = BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]");
    String id2 = "id23227150";
    String projectId2 = "projectId2939242356";
    String statusDetail = "statusDetail2089931070";
    String logsBucket = "logsBucket1565363834";
    String buildTriggerId = "buildTriggerId1105559411";
    String logUrl = "logUrl342054388";
    ServiceAccountName serviceAccount = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    Build expectedResponse =
        Build.newBuilder()
            .setName(name.toString())
            .setId(id2)
            .setProjectId(projectId2)
            .setStatusDetail(statusDetail)
            .setLogsBucket(logsBucket)
            .setBuildTriggerId(buildTriggerId)
            .setLogUrl(logUrl)
            .setServiceAccount(serviceAccount.toString())
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String id = "id3355";

    Build actualResponse = client.getBuild(projectId, id);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBuildRequest actualRequest = (GetBuildRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(id, actualRequest.getId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String id = "id3355";

      client.getBuild(projectId, id);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelBuildTest() {
    BuildName name = BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]");
    String id2 = "id23227150";
    String projectId2 = "projectId2939242356";
    String statusDetail = "statusDetail2089931070";
    String logsBucket = "logsBucket1565363834";
    String buildTriggerId = "buildTriggerId1105559411";
    String logUrl = "logUrl342054388";
    ServiceAccountName serviceAccount = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    Build expectedResponse =
        Build.newBuilder()
            .setName(name.toString())
            .setId(id2)
            .setProjectId(projectId2)
            .setStatusDetail(statusDetail)
            .setLogsBucket(logsBucket)
            .setBuildTriggerId(buildTriggerId)
            .setLogUrl(logUrl)
            .setServiceAccount(serviceAccount.toString())
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String id = "id3355";

    Build actualResponse = client.cancelBuild(projectId, id);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelBuildRequest actualRequest = (CancelBuildRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(id, actualRequest.getId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String id = "id3355";

      client.cancelBuild(projectId, id);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void retryBuildTest() throws Exception {
    BuildName name = BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]");
    String id2 = "id23227150";
    String projectId2 = "projectId2939242356";
    String statusDetail = "statusDetail2089931070";
    String logsBucket = "logsBucket1565363834";
    String buildTriggerId = "buildTriggerId1105559411";
    String logUrl = "logUrl342054388";
    ServiceAccountName serviceAccount = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    Build expectedResponse =
        Build.newBuilder()
            .setName(name.toString())
            .setId(id2)
            .setProjectId(projectId2)
            .setStatusDetail(statusDetail)
            .setLogsBucket(logsBucket)
            .setBuildTriggerId(buildTriggerId)
            .setLogUrl(logUrl)
            .setServiceAccount(serviceAccount.toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("retryBuildTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudBuild.addResponse(resultOperation);

    String projectId = "projectId-1969970175";
    String id = "id3355";

    Build actualResponse = client.retryBuildAsync(projectId, id).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetryBuildRequest actualRequest = (RetryBuildRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(id, actualRequest.getId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void retryBuildExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String id = "id3355";

      client.retryBuildAsync(projectId, id).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createBuildTriggerTest() {
    String id = "id3355";
    String description = "description-1724546052";
    BuildTriggerName name = BuildTriggerName.of("[PROJECT]", "[TRIGGER]");
    String filename = "filename-734768633";
    boolean disabled = true;
    BuildTrigger expectedResponse =
        BuildTrigger.newBuilder()
            .setId(id)
            .setDescription(description)
            .setName(name.toString())
            .setFilename(filename)
            .setDisabled(disabled)
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    BuildTrigger trigger = BuildTrigger.newBuilder().build();

    BuildTrigger actualResponse = client.createBuildTrigger(projectId, trigger);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBuildTriggerRequest actualRequest = (CreateBuildTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(trigger, actualRequest.getTrigger());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      BuildTrigger trigger = BuildTrigger.newBuilder().build();

      client.createBuildTrigger(projectId, trigger);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getBuildTriggerTest() {
    String id = "id3355";
    String description = "description-1724546052";
    BuildTriggerName name = BuildTriggerName.of("[PROJECT]", "[TRIGGER]");
    String filename = "filename-734768633";
    boolean disabled = true;
    BuildTrigger expectedResponse =
        BuildTrigger.newBuilder()
            .setId(id)
            .setDescription(description)
            .setName(name.toString())
            .setFilename(filename)
            .setDisabled(disabled)
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String triggerId = "triggerId1363517698";

    BuildTrigger actualResponse = client.getBuildTrigger(projectId, triggerId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBuildTriggerRequest actualRequest = (GetBuildTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String triggerId = "triggerId1363517698";

      client.getBuildTrigger(projectId, triggerId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listBuildTriggersTest() {
    String nextPageToken = "";
    BuildTrigger triggersElement = BuildTrigger.newBuilder().build();
    List<BuildTrigger> triggers = Arrays.asList(triggersElement);
    ListBuildTriggersResponse expectedResponse =
        ListBuildTriggersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTriggers(triggers)
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";

    ListBuildTriggersPagedResponse pagedListResponse = client.listBuildTriggers(projectId);

    List<BuildTrigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTriggersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBuildTriggersRequest actualRequest = (ListBuildTriggersRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listBuildTriggersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";

      client.listBuildTriggers(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateBuildTriggerTest() {
    String id = "id3355";
    String description = "description-1724546052";
    BuildTriggerName name = BuildTriggerName.of("[PROJECT]", "[TRIGGER]");
    String filename = "filename-734768633";
    boolean disabled = true;
    BuildTrigger expectedResponse =
        BuildTrigger.newBuilder()
            .setId(id)
            .setDescription(description)
            .setName(name.toString())
            .setFilename(filename)
            .setDisabled(disabled)
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    String projectId = "projectId-1969970175";
    String triggerId = "triggerId1363517698";
    BuildTrigger trigger = BuildTrigger.newBuilder().build();

    BuildTrigger actualResponse = client.updateBuildTrigger(projectId, triggerId, trigger);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBuildTriggerRequest actualRequest = (UpdateBuildTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertEquals(trigger, actualRequest.getTrigger());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String triggerId = "triggerId1363517698";
      BuildTrigger trigger = BuildTrigger.newBuilder().build();

      client.updateBuildTrigger(projectId, triggerId, trigger);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void runBuildTriggerTest() throws Exception {
    BuildName name = BuildName.ofProjectBuildName("[PROJECT]", "[BUILD]");
    String id = "id3355";
    String projectId2 = "projectId2939242356";
    String statusDetail = "statusDetail2089931070";
    String logsBucket = "logsBucket1565363834";
    String buildTriggerId = "buildTriggerId1105559411";
    String logUrl = "logUrl342054388";
    ServiceAccountName serviceAccount = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
    Build expectedResponse =
        Build.newBuilder()
            .setName(name.toString())
            .setId(id)
            .setProjectId(projectId2)
            .setStatusDetail(statusDetail)
            .setLogsBucket(logsBucket)
            .setBuildTriggerId(buildTriggerId)
            .setLogUrl(logUrl)
            .setServiceAccount(serviceAccount.toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runBuildTriggerTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudBuild.addResponse(resultOperation);

    String projectId = "projectId-1969970175";
    String triggerId = "triggerId1363517698";
    RepoSource source = RepoSource.newBuilder().build();

    Build actualResponse = client.runBuildTriggerAsync(projectId, triggerId, source).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunBuildTriggerRequest actualRequest = (RunBuildTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(triggerId, actualRequest.getTriggerId());
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void runBuildTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      String projectId = "projectId-1969970175";
      String triggerId = "triggerId1363517698";
      RepoSource source = RepoSource.newBuilder().build();

      client.runBuildTriggerAsync(projectId, triggerId, source).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createWorkerPoolTest() {
    String name = "name3373707";
    String projectId = "projectId-1969970175";
    String serviceAccountEmail = "serviceAccountEmail-1300473088";
    long workerCount = 372044046L;
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(name)
            .setProjectId(projectId)
            .setServiceAccountEmail(serviceAccountEmail)
            .setWorkerCount(workerCount)
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    CreateWorkerPoolRequest request = CreateWorkerPoolRequest.newBuilder().build();

    WorkerPool actualResponse = client.createWorkerPool(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkerPoolRequest actualRequest = (CreateWorkerPoolRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      CreateWorkerPoolRequest request = CreateWorkerPoolRequest.newBuilder().build();

      client.createWorkerPool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getWorkerPoolTest() {
    String name = "name3373707";
    String projectId = "projectId-1969970175";
    String serviceAccountEmail = "serviceAccountEmail-1300473088";
    long workerCount = 372044046L;
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(name)
            .setProjectId(projectId)
            .setServiceAccountEmail(serviceAccountEmail)
            .setWorkerCount(workerCount)
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    GetWorkerPoolRequest request = GetWorkerPoolRequest.newBuilder().build();

    WorkerPool actualResponse = client.getWorkerPool(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkerPoolRequest actualRequest = (GetWorkerPoolRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      GetWorkerPoolRequest request = GetWorkerPoolRequest.newBuilder().build();

      client.getWorkerPool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWorkerPoolTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudBuild.addResponse(expectedResponse);

    DeleteWorkerPoolRequest request = DeleteWorkerPoolRequest.newBuilder().build();

    client.deleteWorkerPool(request);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkerPoolRequest actualRequest = (DeleteWorkerPoolRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      DeleteWorkerPoolRequest request = DeleteWorkerPoolRequest.newBuilder().build();

      client.deleteWorkerPool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateWorkerPoolTest() {
    String name = "name3373707";
    String projectId = "projectId-1969970175";
    String serviceAccountEmail = "serviceAccountEmail-1300473088";
    long workerCount = 372044046L;
    WorkerPool expectedResponse =
        WorkerPool.newBuilder()
            .setName(name)
            .setProjectId(projectId)
            .setServiceAccountEmail(serviceAccountEmail)
            .setWorkerCount(workerCount)
            .build();
    mockCloudBuild.addResponse(expectedResponse);

    UpdateWorkerPoolRequest request = UpdateWorkerPoolRequest.newBuilder().build();

    WorkerPool actualResponse = client.updateWorkerPool(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkerPoolRequest actualRequest = (UpdateWorkerPoolRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateWorkerPoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      UpdateWorkerPoolRequest request = UpdateWorkerPoolRequest.newBuilder().build();

      client.updateWorkerPool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listWorkerPoolsTest() {
    ListWorkerPoolsResponse expectedResponse = ListWorkerPoolsResponse.newBuilder().build();
    mockCloudBuild.addResponse(expectedResponse);

    ListWorkerPoolsRequest request = ListWorkerPoolsRequest.newBuilder().build();

    ListWorkerPoolsResponse actualResponse = client.listWorkerPools(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudBuild.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkerPoolsRequest actualRequest = (ListWorkerPoolsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listWorkerPoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudBuild.addException(exception);

    try {
      ListWorkerPoolsRequest request = ListWorkerPoolsRequest.newBuilder().build();

      client.listWorkerPools(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
