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

package com.google.cloud.enterpriseknowledgegraph.v1;

import static com.google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphServiceClient.ListEntityReconciliationJobsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class EnterpriseKnowledgeGraphServiceClientTest {
  private static MockEnterpriseKnowledgeGraphService mockEnterpriseKnowledgeGraphService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EnterpriseKnowledgeGraphServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEnterpriseKnowledgeGraphService = new MockEnterpriseKnowledgeGraphService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEnterpriseKnowledgeGraphService));
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
    EnterpriseKnowledgeGraphServiceSettings settings =
        EnterpriseKnowledgeGraphServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EnterpriseKnowledgeGraphServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createEntityReconciliationJobTest() throws Exception {
    EntityReconciliationJob expectedResponse =
        EntityReconciliationJob.newBuilder()
            .setName(
                EntityReconciliationJobName.of(
                        "[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]")
                    .toString())
            .setInputConfig(InputConfig.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconConfig(ReconConfig.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EntityReconciliationJob entityReconciliationJob = EntityReconciliationJob.newBuilder().build();

    EntityReconciliationJob actualResponse =
        client.createEntityReconciliationJob(parent, entityReconciliationJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntityReconciliationJobRequest actualRequest =
        ((CreateEntityReconciliationJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entityReconciliationJob, actualRequest.getEntityReconciliationJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntityReconciliationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EntityReconciliationJob entityReconciliationJob =
          EntityReconciliationJob.newBuilder().build();
      client.createEntityReconciliationJob(parent, entityReconciliationJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntityReconciliationJobTest2() throws Exception {
    EntityReconciliationJob expectedResponse =
        EntityReconciliationJob.newBuilder()
            .setName(
                EntityReconciliationJobName.of(
                        "[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]")
                    .toString())
            .setInputConfig(InputConfig.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconConfig(ReconConfig.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    EntityReconciliationJob entityReconciliationJob = EntityReconciliationJob.newBuilder().build();

    EntityReconciliationJob actualResponse =
        client.createEntityReconciliationJob(parent, entityReconciliationJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntityReconciliationJobRequest actualRequest =
        ((CreateEntityReconciliationJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(entityReconciliationJob, actualRequest.getEntityReconciliationJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntityReconciliationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String parent = "parent-995424086";
      EntityReconciliationJob entityReconciliationJob =
          EntityReconciliationJob.newBuilder().build();
      client.createEntityReconciliationJob(parent, entityReconciliationJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntityReconciliationJobTest() throws Exception {
    EntityReconciliationJob expectedResponse =
        EntityReconciliationJob.newBuilder()
            .setName(
                EntityReconciliationJobName.of(
                        "[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]")
                    .toString())
            .setInputConfig(InputConfig.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconConfig(ReconConfig.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    EntityReconciliationJobName name =
        EntityReconciliationJobName.of("[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]");

    EntityReconciliationJob actualResponse = client.getEntityReconciliationJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntityReconciliationJobRequest actualRequest =
        ((GetEntityReconciliationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntityReconciliationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      EntityReconciliationJobName name =
          EntityReconciliationJobName.of("[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]");
      client.getEntityReconciliationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntityReconciliationJobTest2() throws Exception {
    EntityReconciliationJob expectedResponse =
        EntityReconciliationJob.newBuilder()
            .setName(
                EntityReconciliationJobName.of(
                        "[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]")
                    .toString())
            .setInputConfig(InputConfig.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .setState(JobState.forNumber(0))
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconConfig(ReconConfig.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String name = "name3373707";

    EntityReconciliationJob actualResponse = client.getEntityReconciliationJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntityReconciliationJobRequest actualRequest =
        ((GetEntityReconciliationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntityReconciliationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String name = "name3373707";
      client.getEntityReconciliationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntityReconciliationJobsTest() throws Exception {
    EntityReconciliationJob responsesElement = EntityReconciliationJob.newBuilder().build();
    ListEntityReconciliationJobsResponse expectedResponse =
        ListEntityReconciliationJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntityReconciliationJobs(Arrays.asList(responsesElement))
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntityReconciliationJobsPagedResponse pagedListResponse =
        client.listEntityReconciliationJobs(parent);

    List<EntityReconciliationJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEntityReconciliationJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntityReconciliationJobsRequest actualRequest =
        ((ListEntityReconciliationJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntityReconciliationJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntityReconciliationJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntityReconciliationJobsTest2() throws Exception {
    EntityReconciliationJob responsesElement = EntityReconciliationJob.newBuilder().build();
    ListEntityReconciliationJobsResponse expectedResponse =
        ListEntityReconciliationJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntityReconciliationJobs(Arrays.asList(responsesElement))
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntityReconciliationJobsPagedResponse pagedListResponse =
        client.listEntityReconciliationJobs(parent);

    List<EntityReconciliationJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getEntityReconciliationJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntityReconciliationJobsRequest actualRequest =
        ((ListEntityReconciliationJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntityReconciliationJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntityReconciliationJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelEntityReconciliationJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    EntityReconciliationJobName name =
        EntityReconciliationJobName.of("[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]");

    client.cancelEntityReconciliationJob(name);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelEntityReconciliationJobRequest actualRequest =
        ((CancelEntityReconciliationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelEntityReconciliationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      EntityReconciliationJobName name =
          EntityReconciliationJobName.of("[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]");
      client.cancelEntityReconciliationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelEntityReconciliationJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelEntityReconciliationJob(name);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelEntityReconciliationJobRequest actualRequest =
        ((CancelEntityReconciliationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelEntityReconciliationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelEntityReconciliationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntityReconciliationJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    EntityReconciliationJobName name =
        EntityReconciliationJobName.of("[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]");

    client.deleteEntityReconciliationJob(name);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntityReconciliationJobRequest actualRequest =
        ((DeleteEntityReconciliationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntityReconciliationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      EntityReconciliationJobName name =
          EntityReconciliationJobName.of("[PROJECT]", "[LOCATION]", "[ENTITY_RECONCILIATION_JOB]");
      client.deleteEntityReconciliationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntityReconciliationJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEntityReconciliationJob(name);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntityReconciliationJobRequest actualRequest =
        ((DeleteEntityReconciliationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntityReconciliationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEntityReconciliationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupTest() throws Exception {
    LookupResponse expectedResponse =
        LookupResponse.newBuilder()
            .setContext(Value.newBuilder().setBoolValue(true).build())
            .setType(Value.newBuilder().setBoolValue(true).build())
            .setItemListElement(ListValue.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> ids = new ArrayList<>();

    LookupResponse actualResponse = client.lookup(parent, ids);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupRequest actualRequest = ((LookupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(ids, actualRequest.getIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> ids = new ArrayList<>();
      client.lookup(parent, ids);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupTest2() throws Exception {
    LookupResponse expectedResponse =
        LookupResponse.newBuilder()
            .setContext(Value.newBuilder().setBoolValue(true).build())
            .setType(Value.newBuilder().setBoolValue(true).build())
            .setItemListElement(ListValue.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> ids = new ArrayList<>();

    LookupResponse actualResponse = client.lookup(parent, ids);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupRequest actualRequest = ((LookupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(ids, actualRequest.getIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> ids = new ArrayList<>();
      client.lookup(parent, ids);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTest() throws Exception {
    SearchResponse expectedResponse =
        SearchResponse.newBuilder()
            .setContext(Value.newBuilder().setBoolValue(true).build())
            .setType(Value.newBuilder().setBoolValue(true).build())
            .setItemListElement(ListValue.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String query = "query107944136";

    SearchResponse actualResponse = client.search(parent, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRequest actualRequest = ((SearchRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String query = "query107944136";
      client.search(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTest2() throws Exception {
    SearchResponse expectedResponse =
        SearchResponse.newBuilder()
            .setContext(Value.newBuilder().setBoolValue(true).build())
            .setType(Value.newBuilder().setBoolValue(true).build())
            .setItemListElement(ListValue.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String query = "query107944136";

    SearchResponse actualResponse = client.search(parent, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRequest actualRequest = ((SearchRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String parent = "parent-995424086";
      String query = "query107944136";
      client.search(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupPublicKgTest() throws Exception {
    LookupPublicKgResponse expectedResponse =
        LookupPublicKgResponse.newBuilder()
            .setContext(Value.newBuilder().setBoolValue(true).build())
            .setType(Value.newBuilder().setBoolValue(true).build())
            .setItemListElement(ListValue.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> ids = new ArrayList<>();

    LookupPublicKgResponse actualResponse = client.lookupPublicKg(parent, ids);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupPublicKgRequest actualRequest = ((LookupPublicKgRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(ids, actualRequest.getIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupPublicKgExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> ids = new ArrayList<>();
      client.lookupPublicKg(parent, ids);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupPublicKgTest2() throws Exception {
    LookupPublicKgResponse expectedResponse =
        LookupPublicKgResponse.newBuilder()
            .setContext(Value.newBuilder().setBoolValue(true).build())
            .setType(Value.newBuilder().setBoolValue(true).build())
            .setItemListElement(ListValue.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> ids = new ArrayList<>();

    LookupPublicKgResponse actualResponse = client.lookupPublicKg(parent, ids);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupPublicKgRequest actualRequest = ((LookupPublicKgRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(ids, actualRequest.getIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupPublicKgExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> ids = new ArrayList<>();
      client.lookupPublicKg(parent, ids);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPublicKgTest() throws Exception {
    SearchPublicKgResponse expectedResponse =
        SearchPublicKgResponse.newBuilder()
            .setContext(Value.newBuilder().setBoolValue(true).build())
            .setType(Value.newBuilder().setBoolValue(true).build())
            .setItemListElement(ListValue.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String query = "query107944136";

    SearchPublicKgResponse actualResponse = client.searchPublicKg(parent, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchPublicKgRequest actualRequest = ((SearchPublicKgRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchPublicKgExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String query = "query107944136";
      client.searchPublicKg(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPublicKgTest2() throws Exception {
    SearchPublicKgResponse expectedResponse =
        SearchPublicKgResponse.newBuilder()
            .setContext(Value.newBuilder().setBoolValue(true).build())
            .setType(Value.newBuilder().setBoolValue(true).build())
            .setItemListElement(ListValue.newBuilder().build())
            .build();
    mockEnterpriseKnowledgeGraphService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String query = "query107944136";

    SearchPublicKgResponse actualResponse = client.searchPublicKg(parent, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnterpriseKnowledgeGraphService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchPublicKgRequest actualRequest = ((SearchPublicKgRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchPublicKgExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnterpriseKnowledgeGraphService.addException(exception);

    try {
      String parent = "parent-995424086";
      String query = "query107944136";
      client.searchPublicKg(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
