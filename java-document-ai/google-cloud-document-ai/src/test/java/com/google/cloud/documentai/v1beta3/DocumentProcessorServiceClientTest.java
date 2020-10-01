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
package com.google.cloud.documentai.v1beta3;

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
public class DocumentProcessorServiceClientTest {
  private static MockDocumentProcessorService mockDocumentProcessorService;
  private static MockServiceHelper serviceHelper;
  private DocumentProcessorServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentProcessorService = new MockDocumentProcessorService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDocumentProcessorService));
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
    DocumentProcessorServiceSettings settings =
        DocumentProcessorServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentProcessorServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void processDocumentTest() {
    String humanReviewOperation = "humanReviewOperation2074827282";
    ProcessResponse expectedResponse =
        ProcessResponse.newBuilder().setHumanReviewOperation(humanReviewOperation).build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    ProcessResponse actualResponse = client.processDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProcessRequest actualRequest = (ProcessRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProcessorName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void processDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

      client.processDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchProcessDocumentsTest() throws Exception {
    BatchProcessResponse expectedResponse = BatchProcessResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchProcessDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    BatchProcessResponse actualResponse = client.batchProcessDocumentsAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchProcessRequest actualRequest = (BatchProcessRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProcessorName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchProcessDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

      client.batchProcessDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void reviewDocumentTest() throws Exception {
    String gcsDestination = "gcsDestination714819302";
    ReviewDocumentResponse expectedResponse =
        ReviewDocumentResponse.newBuilder().setGcsDestination(gcsDestination).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reviewDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    HumanReviewConfigName humanReviewConfig =
        HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    ReviewDocumentResponse actualResponse = client.reviewDocumentAsync(humanReviewConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReviewDocumentRequest actualRequest = (ReviewDocumentRequest) actualRequests.get(0);

    Assert.assertEquals(
        humanReviewConfig, HumanReviewConfigName.parse(actualRequest.getHumanReviewConfig()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void reviewDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      HumanReviewConfigName humanReviewConfig =
          HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

      client.reviewDocumentAsync(humanReviewConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
