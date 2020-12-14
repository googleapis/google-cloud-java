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

package com.google.cloud.documentai.v1beta2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DocumentUnderstandingServiceClientTest {
  private static MockDocumentUnderstandingService mockDocumentUnderstandingService;
  private static MockServiceHelper mockServiceHelper;
  private DocumentUnderstandingServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentUnderstandingService = new MockDocumentUnderstandingService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDocumentUnderstandingService));
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
    DocumentUnderstandingServiceSettings settings =
        DocumentUnderstandingServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentUnderstandingServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void batchProcessDocumentsTest() throws Exception {
    BatchProcessDocumentsResponse expectedResponse =
        BatchProcessDocumentsResponse.newBuilder()
            .addAllResponses(new ArrayList<ProcessDocumentResponse>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchProcessDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentUnderstandingService.addResponse(resultOperation);

    List<ProcessDocumentRequest> requests = new ArrayList<>();

    BatchProcessDocumentsResponse actualResponse =
        client.batchProcessDocumentsAsync(requests).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentUnderstandingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchProcessDocumentsRequest actualRequest =
        ((BatchProcessDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchProcessDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentUnderstandingService.addException(exception);

    try {
      List<ProcessDocumentRequest> requests = new ArrayList<>();
      client.batchProcessDocumentsAsync(requests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void processDocumentTest() throws Exception {
    Document expectedResponse =
        Document.newBuilder()
            .setMimeType("mimeType-1392120434")
            .setText("text3556653")
            .addAllTextStyles(new ArrayList<Document.Style>())
            .addAllPages(new ArrayList<Document.Page>())
            .addAllEntities(new ArrayList<Document.Entity>())
            .addAllEntityRelations(new ArrayList<Document.EntityRelation>())
            .addAllLabels(new ArrayList<Document.Label>())
            .setError(Status.newBuilder().build())
            .build();
    mockDocumentUnderstandingService.addResponse(expectedResponse);

    ProcessDocumentRequest request =
        ProcessDocumentRequest.newBuilder()
            .setParent("parent-995424086")
            .setInputConfig(InputConfig.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .setDocumentType("documentType-1473196299")
            .setTableExtractionParams(TableExtractionParams.newBuilder().build())
            .setFormExtractionParams(FormExtractionParams.newBuilder().build())
            .setEntityExtractionParams(EntityExtractionParams.newBuilder().build())
            .setOcrParams(OcrParams.newBuilder().build())
            .setAutomlParams(AutoMlParams.newBuilder().build())
            .build();

    Document actualResponse = client.processDocument(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentUnderstandingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProcessDocumentRequest actualRequest = ((ProcessDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInputConfig(), actualRequest.getInputConfig());
    Assert.assertEquals(request.getOutputConfig(), actualRequest.getOutputConfig());
    Assert.assertEquals(request.getDocumentType(), actualRequest.getDocumentType());
    Assert.assertEquals(
        request.getTableExtractionParams(), actualRequest.getTableExtractionParams());
    Assert.assertEquals(request.getFormExtractionParams(), actualRequest.getFormExtractionParams());
    Assert.assertEquals(
        request.getEntityExtractionParams(), actualRequest.getEntityExtractionParams());
    Assert.assertEquals(request.getOcrParams(), actualRequest.getOcrParams());
    Assert.assertEquals(request.getAutomlParams(), actualRequest.getAutomlParams());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void processDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentUnderstandingService.addException(exception);

    try {
      ProcessDocumentRequest request =
          ProcessDocumentRequest.newBuilder()
              .setParent("parent-995424086")
              .setInputConfig(InputConfig.newBuilder().build())
              .setOutputConfig(OutputConfig.newBuilder().build())
              .setDocumentType("documentType-1473196299")
              .setTableExtractionParams(TableExtractionParams.newBuilder().build())
              .setFormExtractionParams(FormExtractionParams.newBuilder().build())
              .setEntityExtractionParams(EntityExtractionParams.newBuilder().build())
              .setOcrParams(OcrParams.newBuilder().build())
              .setAutomlParams(AutoMlParams.newBuilder().build())
              .build();
      client.processDocument(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
