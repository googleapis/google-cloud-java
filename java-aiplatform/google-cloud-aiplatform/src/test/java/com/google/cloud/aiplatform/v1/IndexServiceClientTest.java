/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.IndexServiceClient.ListIndexesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
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
public class IndexServiceClientTest {
  private static MockIndexService mockIndexService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IndexServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIndexService = new MockIndexService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIndexService));
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
    IndexServiceSettings settings =
        IndexServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IndexServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexRef>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIndexService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Index index = Index.newBuilder().build();

    Index actualResponse = client.createIndexAsync(parent, index).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexRequest actualRequest = ((CreateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Index index = Index.newBuilder().build();
      client.createIndexAsync(parent, index).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createIndexTest2() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexRef>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIndexService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Index index = Index.newBuilder().build();

    Index actualResponse = client.createIndexAsync(parent, index).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexRequest actualRequest = ((CreateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      String parent = "parent-995424086";
      Index index = Index.newBuilder().build();
      client.createIndexAsync(parent, index).get();
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
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexRef>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockIndexService.addResponse(expectedResponse);

    IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]");

    Index actualResponse = client.getIndex(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexRequest actualRequest = ((GetIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]");
      client.getIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIndexTest2() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexRef>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockIndexService.addResponse(expectedResponse);

    String name = "name3373707";

    Index actualResponse = client.getIndex(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexRequest actualRequest = ((GetIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      String name = "name3373707";
      client.getIndex(name);
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
    mockIndexService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexesRequest actualRequest = ((ListIndexesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listIndexes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIndexesTest2() throws Exception {
    Index responsesElement = Index.newBuilder().build();
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexes(Arrays.asList(responsesElement))
            .build();
    mockIndexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexesRequest actualRequest = ((ListIndexesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIndexes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexRef>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIndexService.addResponse(resultOperation);

    Index index = Index.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Index actualResponse = client.updateIndexAsync(index, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIndexRequest actualRequest = ((UpdateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      Index index = Index.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIndexAsync(index, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIndexTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIndexService.addResponse(resultOperation);

    IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]");

    client.deleteIndexAsync(name).get();

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexRequest actualRequest = ((DeleteIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]");
      client.deleteIndexAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIndexTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIndexService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIndexAsync(name).get();

    List<AbstractMessage> actualRequests = mockIndexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexRequest actualRequest = ((DeleteIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIndexService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIndexAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
