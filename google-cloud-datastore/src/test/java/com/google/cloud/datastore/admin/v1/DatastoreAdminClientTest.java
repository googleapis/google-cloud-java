/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.datastore.admin.v1;

import static com.google.cloud.datastore.admin.v1.DatastoreAdminClient.ListIndexesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.datastore.admin.v1.CreateIndexRequest;
import com.google.datastore.admin.v1.DeleteIndexRequest;
import com.google.datastore.admin.v1.EntityFilter;
import com.google.datastore.admin.v1.ExportEntitiesRequest;
import com.google.datastore.admin.v1.ExportEntitiesResponse;
import com.google.datastore.admin.v1.GetIndexRequest;
import com.google.datastore.admin.v1.ImportEntitiesRequest;
import com.google.datastore.admin.v1.Index;
import com.google.datastore.admin.v1.ListIndexesRequest;
import com.google.datastore.admin.v1.ListIndexesResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class DatastoreAdminClientTest {
  private static MockDatastoreAdmin mockDatastoreAdmin;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DatastoreAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDatastoreAdmin = new MockDatastoreAdmin();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDatastoreAdmin));
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
    DatastoreAdminSettings settings =
        DatastoreAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatastoreAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void exportEntitiesTest() throws Exception {
    ExportEntitiesResponse expectedResponse =
        ExportEntitiesResponse.newBuilder().setOutputUrl("outputUrl-2119300946").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportEntitiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastoreAdmin.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    Map<String, String> labels = new HashMap<>();
    EntityFilter entityFilter = EntityFilter.newBuilder().build();
    String outputUrlPrefix = "outputUrlPrefix-1132598048";

    ExportEntitiesResponse actualResponse =
        client.exportEntitiesAsync(projectId, labels, entityFilter, outputUrlPrefix).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportEntitiesRequest actualRequest = ((ExportEntitiesRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(labels, actualRequest.getLabelsMap());
    Assert.assertEquals(entityFilter, actualRequest.getEntityFilter());
    Assert.assertEquals(outputUrlPrefix, actualRequest.getOutputUrlPrefix());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportEntitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastoreAdmin.addException(exception);

    try {
      String projectId = "projectId-894832108";
      Map<String, String> labels = new HashMap<>();
      EntityFilter entityFilter = EntityFilter.newBuilder().build();
      String outputUrlPrefix = "outputUrlPrefix-1132598048";
      client.exportEntitiesAsync(projectId, labels, entityFilter, outputUrlPrefix).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importEntitiesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importEntitiesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastoreAdmin.addResponse(resultOperation);

    String projectId = "projectId-894832108";
    Map<String, String> labels = new HashMap<>();
    String inputUrl = "inputUrl470706501";
    EntityFilter entityFilter = EntityFilter.newBuilder().build();

    client.importEntitiesAsync(projectId, labels, inputUrl, entityFilter).get();

    List<AbstractMessage> actualRequests = mockDatastoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportEntitiesRequest actualRequest = ((ImportEntitiesRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(labels, actualRequest.getLabelsMap());
    Assert.assertEquals(inputUrl, actualRequest.getInputUrl());
    Assert.assertEquals(entityFilter, actualRequest.getEntityFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importEntitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastoreAdmin.addException(exception);

    try {
      String projectId = "projectId-894832108";
      Map<String, String> labels = new HashMap<>();
      String inputUrl = "inputUrl470706501";
      EntityFilter entityFilter = EntityFilter.newBuilder().build();
      client.importEntitiesAsync(projectId, labels, inputUrl, entityFilter).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndexId("indexId1943291277")
            .setKind("kind3292052")
            .addAllProperties(new ArrayList<Index.IndexedProperty>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastoreAdmin.addResponse(resultOperation);

    CreateIndexRequest request =
        CreateIndexRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndex(Index.newBuilder().build())
            .build();

    Index actualResponse = client.createIndexAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexRequest actualRequest = ((CreateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getIndex(), actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastoreAdmin.addException(exception);

    try {
      CreateIndexRequest request =
          CreateIndexRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setIndex(Index.newBuilder().build())
              .build();
      client.createIndexAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndexId("indexId1943291277")
            .setKind("kind3292052")
            .addAllProperties(new ArrayList<Index.IndexedProperty>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastoreAdmin.addResponse(resultOperation);

    DeleteIndexRequest request =
        DeleteIndexRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndexId("indexId1943291277")
            .build();

    Index actualResponse = client.deleteIndexAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexRequest actualRequest = ((DeleteIndexRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getIndexId(), actualRequest.getIndexId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastoreAdmin.addException(exception);

    try {
      DeleteIndexRequest request =
          DeleteIndexRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setIndexId("indexId1943291277")
              .build();
      client.deleteIndexAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndexId("indexId1943291277")
            .setKind("kind3292052")
            .addAllProperties(new ArrayList<Index.IndexedProperty>())
            .build();
    mockDatastoreAdmin.addResponse(expectedResponse);

    GetIndexRequest request =
        GetIndexRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setIndexId("indexId1943291277")
            .build();

    Index actualResponse = client.getIndex(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexRequest actualRequest = ((GetIndexRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getIndexId(), actualRequest.getIndexId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastoreAdmin.addException(exception);

    try {
      GetIndexRequest request =
          GetIndexRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setIndexId("indexId1943291277")
              .build();
      client.getIndex(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIndexesTest() throws Exception {
    Index responsesElement = Index.newBuilder().build();
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexes(Arrays.asList(responsesElement))
            .build();
    mockDatastoreAdmin.addResponse(expectedResponse);

    ListIndexesRequest request =
        ListIndexesRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(request);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexesRequest actualRequest = ((ListIndexesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastoreAdmin.addException(exception);

    try {
      ListIndexesRequest request =
          ListIndexesRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listIndexes(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
