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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1alpha.stub.HttpJsonChunkServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ChunkServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ChunkServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonChunkServiceStub.getMethodDescriptors(),
            ChunkServiceSettings.getDefaultEndpoint());
    ChunkServiceSettings settings =
        ChunkServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ChunkServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ChunkServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    ChunkName name =
        ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]", "[CHUNK]");

    Chunk actualResponse = client.getChunk(name);
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
  public void getChunkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6658/locations/location-6658/dataStores/dataStore-6658/branches/branche-6658/documents/document-6658/chunks/chunk-6658";

    Chunk actualResponse = client.getChunk(name);
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
  public void getChunkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6658/locations/location-6658/dataStores/dataStore-6658/branches/branche-6658/documents/document-6658/chunks/chunk-6658";
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
    mockService.addResponse(expectedResponse);

    DocumentName parent =
        DocumentName.ofProjectLocationDataStoreBranchDocumentName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");

    ListChunksPagedResponse pagedListResponse = client.listChunks(parent);

    List<Chunk> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChunksList().get(0), resources.get(0));

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
  public void listChunksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3185/locations/location-3185/dataStores/dataStore-3185/branches/branche-3185/documents/document-3185";

    ListChunksPagedResponse pagedListResponse = client.listChunks(parent);

    List<Chunk> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChunksList().get(0), resources.get(0));

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
  public void listChunksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3185/locations/location-3185/dataStores/dataStore-3185/branches/branche-3185/documents/document-3185";
      client.listChunks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
