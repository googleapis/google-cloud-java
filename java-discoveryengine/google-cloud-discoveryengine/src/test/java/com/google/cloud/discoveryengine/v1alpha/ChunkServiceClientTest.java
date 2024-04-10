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

package com.google.cloud.discoveryengine.v1alpha;

import static com.google.cloud.discoveryengine.v1alpha.ChunkServiceClient.ListChunksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Struct;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class ChunkServiceClientTest {
  private static MockChunkService mockChunkService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ChunkServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockChunkService = new MockChunkService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockChunkService, mockLocations));
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
    ChunkServiceSettings settings =
        ChunkServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ChunkServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getChunkTest() throws Exception {
    Chunk expectedResponse =
        Chunk.newBuilder()
            .setName(
                ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[DATA_STORE]",
                        "[BRANCH]",
                        "[DOCUMENT]",
                        "[CHUNK]")
                    .toString())
            .setId("id3355")
            .setContent("content951530617")
            .setDocumentMetadata(Chunk.DocumentMetadata.newBuilder().build())
            .setDerivedStructData(Struct.newBuilder().build())
            .setPageSpan(Chunk.PageSpan.newBuilder().build())
            .setChunkMetadata(Chunk.ChunkMetadata.newBuilder().build())
            .build();
    mockChunkService.addResponse(expectedResponse);

    ChunkName name =
        ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]", "[CHUNK]");

    Chunk actualResponse = client.getChunk(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChunkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChunkRequest actualRequest = ((GetChunkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChunkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChunkService.addException(exception);

    try {
      ChunkName name =
          ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]", "[CHUNK]");
      client.getChunk(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChunkTest2() throws Exception {
    Chunk expectedResponse =
        Chunk.newBuilder()
            .setName(
                ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[DATA_STORE]",
                        "[BRANCH]",
                        "[DOCUMENT]",
                        "[CHUNK]")
                    .toString())
            .setId("id3355")
            .setContent("content951530617")
            .setDocumentMetadata(Chunk.DocumentMetadata.newBuilder().build())
            .setDerivedStructData(Struct.newBuilder().build())
            .setPageSpan(Chunk.PageSpan.newBuilder().build())
            .setChunkMetadata(Chunk.ChunkMetadata.newBuilder().build())
            .build();
    mockChunkService.addResponse(expectedResponse);

    String name = "name3373707";

    Chunk actualResponse = client.getChunk(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChunkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChunkRequest actualRequest = ((GetChunkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChunkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChunkService.addException(exception);

    try {
      String name = "name3373707";
      client.getChunk(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChunksTest() throws Exception {
    Chunk responsesElement = Chunk.newBuilder().build();
    ListChunksResponse expectedResponse =
        ListChunksResponse.newBuilder()
            .setNextPageToken("")
            .addAllChunks(Arrays.asList(responsesElement))
            .build();
    mockChunkService.addResponse(expectedResponse);

    DocumentName parent =
        DocumentName.ofProjectLocationDataStoreBranchDocumentName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");

    ListChunksPagedResponse pagedListResponse = client.listChunks(parent);

    List<Chunk> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChunksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChunkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChunksRequest actualRequest = ((ListChunksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChunksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChunkService.addException(exception);

    try {
      DocumentName parent =
          DocumentName.ofProjectLocationDataStoreBranchDocumentName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
      client.listChunks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChunksTest2() throws Exception {
    Chunk responsesElement = Chunk.newBuilder().build();
    ListChunksResponse expectedResponse =
        ListChunksResponse.newBuilder()
            .setNextPageToken("")
            .addAllChunks(Arrays.asList(responsesElement))
            .build();
    mockChunkService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChunksPagedResponse pagedListResponse = client.listChunks(parent);

    List<Chunk> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChunksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChunkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChunksRequest actualRequest = ((ListChunksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChunksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChunkService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listChunks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
