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

package com.google.storagetransfer.v1.proto;

import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListAgentPoolsPagedResponse;
import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListTransferJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.storagetransfer.v1.proto.stub.HttpJsonStorageTransferServiceStub;
import java.io.IOException;
import java.util.Arrays;
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
public class StorageTransferServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static StorageTransferServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonStorageTransferServiceStub.getMethodDescriptors(),
            StorageTransferServiceSettings.getDefaultEndpoint());
    StorageTransferServiceSettings settings =
        StorageTransferServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                StorageTransferServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StorageTransferServiceClient.create(settings);
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
  public void getGoogleServiceAccountTest() throws Exception {
    TransferTypes.GoogleServiceAccount expectedResponse =
        TransferTypes.GoogleServiceAccount.newBuilder()
            .setAccountEmail("accountEmail1067197807")
            .setSubjectId("subjectId258589543")
            .build();
    mockService.addResponse(expectedResponse);

    TransferProto.GetGoogleServiceAccountRequest request =
        TransferProto.GetGoogleServiceAccountRequest.newBuilder()
            .setProjectId("projectId-1530")
            .build();

    TransferTypes.GoogleServiceAccount actualResponse = client.getGoogleServiceAccount(request);
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
  public void getGoogleServiceAccountExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.GetGoogleServiceAccountRequest request =
          TransferProto.GetGoogleServiceAccountRequest.newBuilder()
              .setProjectId("projectId-1530")
              .build();
      client.getGoogleServiceAccount(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTransferJobTest() throws Exception {
    TransferTypes.TransferJob expectedResponse =
        TransferTypes.TransferJob.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setProjectId("projectId-894832108")
            .setTransferSpec(TransferTypes.TransferSpec.newBuilder().build())
            .setNotificationConfig(TransferTypes.NotificationConfig.newBuilder().build())
            .setLoggingConfig(TransferTypes.LoggingConfig.newBuilder().build())
            .setSchedule(TransferTypes.Schedule.newBuilder().build())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastModificationTime(Timestamp.newBuilder().build())
            .setDeletionTime(Timestamp.newBuilder().build())
            .setLatestOperationName("latestOperationName-1244328885")
            .build();
    mockService.addResponse(expectedResponse);

    TransferProto.CreateTransferJobRequest request =
        TransferProto.CreateTransferJobRequest.newBuilder()
            .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
            .build();

    TransferTypes.TransferJob actualResponse = client.createTransferJob(request);
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
  public void createTransferJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.CreateTransferJobRequest request =
          TransferProto.CreateTransferJobRequest.newBuilder()
              .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
              .build();
      client.createTransferJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTransferJobTest() throws Exception {
    TransferTypes.TransferJob expectedResponse =
        TransferTypes.TransferJob.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setProjectId("projectId-894832108")
            .setTransferSpec(TransferTypes.TransferSpec.newBuilder().build())
            .setNotificationConfig(TransferTypes.NotificationConfig.newBuilder().build())
            .setLoggingConfig(TransferTypes.LoggingConfig.newBuilder().build())
            .setSchedule(TransferTypes.Schedule.newBuilder().build())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastModificationTime(Timestamp.newBuilder().build())
            .setDeletionTime(Timestamp.newBuilder().build())
            .setLatestOperationName("latestOperationName-1244328885")
            .build();
    mockService.addResponse(expectedResponse);

    TransferProto.UpdateTransferJobRequest request =
        TransferProto.UpdateTransferJobRequest.newBuilder()
            .setJobName("transferJobs/transferJob-1286")
            .setProjectId("projectId-894832108")
            .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
            .setUpdateTransferJobFieldMask(FieldMask.newBuilder().build())
            .build();

    TransferTypes.TransferJob actualResponse = client.updateTransferJob(request);
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
  public void updateTransferJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.UpdateTransferJobRequest request =
          TransferProto.UpdateTransferJobRequest.newBuilder()
              .setJobName("transferJobs/transferJob-1286")
              .setProjectId("projectId-894832108")
              .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
              .setUpdateTransferJobFieldMask(FieldMask.newBuilder().build())
              .build();
      client.updateTransferJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTransferJobTest() throws Exception {
    TransferTypes.TransferJob expectedResponse =
        TransferTypes.TransferJob.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setProjectId("projectId-894832108")
            .setTransferSpec(TransferTypes.TransferSpec.newBuilder().build())
            .setNotificationConfig(TransferTypes.NotificationConfig.newBuilder().build())
            .setLoggingConfig(TransferTypes.LoggingConfig.newBuilder().build())
            .setSchedule(TransferTypes.Schedule.newBuilder().build())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastModificationTime(Timestamp.newBuilder().build())
            .setDeletionTime(Timestamp.newBuilder().build())
            .setLatestOperationName("latestOperationName-1244328885")
            .build();
    mockService.addResponse(expectedResponse);

    TransferProto.GetTransferJobRequest request =
        TransferProto.GetTransferJobRequest.newBuilder()
            .setJobName("transferJobs/transferJob-1286")
            .setProjectId("projectId-894832108")
            .build();

    TransferTypes.TransferJob actualResponse = client.getTransferJob(request);
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
  public void getTransferJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.GetTransferJobRequest request =
          TransferProto.GetTransferJobRequest.newBuilder()
              .setJobName("transferJobs/transferJob-1286")
              .setProjectId("projectId-894832108")
              .build();
      client.getTransferJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferJobsTest() throws Exception {
    TransferTypes.TransferJob responsesElement = TransferTypes.TransferJob.newBuilder().build();
    TransferProto.ListTransferJobsResponse expectedResponse =
        TransferProto.ListTransferJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    TransferProto.ListTransferJobsRequest request =
        TransferProto.ListTransferJobsRequest.newBuilder()
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListTransferJobsPagedResponse pagedListResponse = client.listTransferJobs(request);

    List<TransferTypes.TransferJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferJobsList().get(0), resources.get(0));

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
  public void listTransferJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.ListTransferJobsRequest request =
          TransferProto.ListTransferJobsRequest.newBuilder()
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listTransferJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseTransferOperationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TransferProto.PauseTransferOperationRequest request =
        TransferProto.PauseTransferOperationRequest.newBuilder()
            .setName("transferOperations/transferOperation-5763")
            .build();

    client.pauseTransferOperation(request);

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
  public void pauseTransferOperationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.PauseTransferOperationRequest request =
          TransferProto.PauseTransferOperationRequest.newBuilder()
              .setName("transferOperations/transferOperation-5763")
              .build();
      client.pauseTransferOperation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeTransferOperationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TransferProto.ResumeTransferOperationRequest request =
        TransferProto.ResumeTransferOperationRequest.newBuilder()
            .setName("transferOperations/transferOperation-5763")
            .build();

    client.resumeTransferOperation(request);

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
  public void resumeTransferOperationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.ResumeTransferOperationRequest request =
          TransferProto.ResumeTransferOperationRequest.newBuilder()
              .setName("transferOperations/transferOperation-5763")
              .build();
      client.resumeTransferOperation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runTransferJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runTransferJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TransferProto.RunTransferJobRequest request =
        TransferProto.RunTransferJobRequest.newBuilder()
            .setJobName("transferJobs/transferJob-1286")
            .setProjectId("projectId-894832108")
            .build();

    client.runTransferJobAsync(request).get();

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
  public void runTransferJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.RunTransferJobRequest request =
          TransferProto.RunTransferJobRequest.newBuilder()
              .setJobName("transferJobs/transferJob-1286")
              .setProjectId("projectId-894832108")
              .build();
      client.runTransferJobAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTransferJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TransferProto.DeleteTransferJobRequest request =
        TransferProto.DeleteTransferJobRequest.newBuilder()
            .setJobName("transferJobs/transferJob-1286")
            .setProjectId("projectId-894832108")
            .build();

    client.deleteTransferJob(request);

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
  public void deleteTransferJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferProto.DeleteTransferJobRequest request =
          TransferProto.DeleteTransferJobRequest.newBuilder()
              .setJobName("transferJobs/transferJob-1286")
              .setProjectId("projectId-894832108")
              .build();
      client.deleteTransferJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAgentPoolTest() throws Exception {
    TransferTypes.AgentPool expectedResponse =
        TransferTypes.AgentPool.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setBandwidthLimit(TransferTypes.AgentPool.BandwidthLimit.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";
    TransferTypes.AgentPool agentPool = TransferTypes.AgentPool.newBuilder().build();
    String agentPoolId = "agentPoolId1562124732";

    TransferTypes.AgentPool actualResponse =
        client.createAgentPool(projectId, agentPool, agentPoolId);
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
  public void createAgentPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      TransferTypes.AgentPool agentPool = TransferTypes.AgentPool.newBuilder().build();
      String agentPoolId = "agentPoolId1562124732";
      client.createAgentPool(projectId, agentPool, agentPoolId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAgentPoolTest() throws Exception {
    TransferTypes.AgentPool expectedResponse =
        TransferTypes.AgentPool.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setBandwidthLimit(TransferTypes.AgentPool.BandwidthLimit.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TransferTypes.AgentPool agentPool =
        TransferTypes.AgentPool.newBuilder()
            .setName("projects/project-9180/agentPools/agentPool-9180")
            .setDisplayName("displayName1714148973")
            .setBandwidthLimit(TransferTypes.AgentPool.BandwidthLimit.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TransferTypes.AgentPool actualResponse = client.updateAgentPool(agentPool, updateMask);
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
  public void updateAgentPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferTypes.AgentPool agentPool =
          TransferTypes.AgentPool.newBuilder()
              .setName("projects/project-9180/agentPools/agentPool-9180")
              .setDisplayName("displayName1714148973")
              .setBandwidthLimit(TransferTypes.AgentPool.BandwidthLimit.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAgentPool(agentPool, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentPoolTest() throws Exception {
    TransferTypes.AgentPool expectedResponse =
        TransferTypes.AgentPool.newBuilder()
            .setName("name3373707")
            .setDisplayName("displayName1714148973")
            .setBandwidthLimit(TransferTypes.AgentPool.BandwidthLimit.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9180/agentPools/agentPool-9180";

    TransferTypes.AgentPool actualResponse = client.getAgentPool(name);
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
  public void getAgentPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9180/agentPools/agentPool-9180";
      client.getAgentPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAgentPoolsTest() throws Exception {
    TransferTypes.AgentPool responsesElement = TransferTypes.AgentPool.newBuilder().build();
    TransferProto.ListAgentPoolsResponse expectedResponse =
        TransferProto.ListAgentPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgentPools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-1530";

    ListAgentPoolsPagedResponse pagedListResponse = client.listAgentPools(projectId);

    List<TransferTypes.AgentPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentPoolsList().get(0), resources.get(0));

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
  public void listAgentPoolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String projectId = "projectId-1530";
      client.listAgentPools(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAgentPoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9180/agentPools/agentPool-9180";

    client.deleteAgentPool(name);

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
  public void deleteAgentPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9180/agentPools/agentPool-9180";
      client.deleteAgentPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
