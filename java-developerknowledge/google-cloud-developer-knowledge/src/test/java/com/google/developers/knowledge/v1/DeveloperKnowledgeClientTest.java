/*
 * Copyright 2026 Google LLC
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

package com.google.developers.knowledge.v1;

import static com.google.developers.knowledge.v1.DeveloperKnowledgeClient.SearchDocumentChunksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
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
public class DeveloperKnowledgeClientTest {
  private static MockDeveloperKnowledge mockDeveloperKnowledge;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DeveloperKnowledgeClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDeveloperKnowledge = new MockDeveloperKnowledge();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDeveloperKnowledge));
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
    DeveloperKnowledgeSettings settings =
        DeveloperKnowledgeSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeveloperKnowledgeClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchDocumentChunksTest() throws Exception {
    DocumentChunk responsesElement = DocumentChunk.newBuilder().build();
    SearchDocumentChunksResponse expectedResponse =
        SearchDocumentChunksResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockDeveloperKnowledge.addResponse(expectedResponse);

    SearchDocumentChunksRequest request =
        SearchDocumentChunksRequest.newBuilder()
            .setQuery("query107944136")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    SearchDocumentChunksPagedResponse pagedListResponse = client.searchDocumentChunks(request);

    List<DocumentChunk> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeveloperKnowledge.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchDocumentChunksRequest actualRequest =
        ((SearchDocumentChunksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchDocumentChunksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperKnowledge.addException(exception);

    try {
      SearchDocumentChunksRequest request =
          SearchDocumentChunksRequest.newBuilder()
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.searchDocumentChunks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(DocumentName.of("[DOCUMENT]").toString())
            .setUri("uri116076")
            .setContent("content951530617")
            .setDescription("description-1724546052")
            .setDataSource("dataSource1272470629")
            .setTitle("title110371416")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setView(DocumentView.forNumber(0))
            .build();
    mockDeveloperKnowledge.addResponse(expectedResponse);

    DocumentName name = DocumentName.of("[DOCUMENT]");

    Document actualResponse = client.getDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperKnowledge.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentRequest actualRequest = ((GetDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperKnowledge.addException(exception);

    try {
      DocumentName name = DocumentName.of("[DOCUMENT]");
      client.getDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDocumentTest2() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setName(DocumentName.of("[DOCUMENT]").toString())
            .setUri("uri116076")
            .setContent("content951530617")
            .setDescription("description-1724546052")
            .setDataSource("dataSource1272470629")
            .setTitle("title110371416")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setView(DocumentView.forNumber(0))
            .build();
    mockDeveloperKnowledge.addResponse(expectedResponse);

    String name = "name3373707";

    Document actualResponse = client.getDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperKnowledge.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentRequest actualRequest = ((GetDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperKnowledge.addException(exception);

    try {
      String name = "name3373707";
      client.getDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetDocumentsTest() throws Exception {
    BatchGetDocumentsResponse expectedResponse =
        BatchGetDocumentsResponse.newBuilder().addAllDocuments(new ArrayList<Document>()).build();
    mockDeveloperKnowledge.addResponse(expectedResponse);

    BatchGetDocumentsRequest request =
        BatchGetDocumentsRequest.newBuilder()
            .addAllNames(new ArrayList<String>())
            .setView(DocumentView.forNumber(0))
            .build();

    BatchGetDocumentsResponse actualResponse = client.batchGetDocuments(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeveloperKnowledge.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetDocumentsRequest actualRequest = ((BatchGetDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getNamesList(), actualRequest.getNamesList());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchGetDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeveloperKnowledge.addException(exception);

    try {
      BatchGetDocumentsRequest request =
          BatchGetDocumentsRequest.newBuilder()
              .addAllNames(new ArrayList<String>())
              .setView(DocumentView.forNumber(0))
              .build();
      client.batchGetDocuments(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
