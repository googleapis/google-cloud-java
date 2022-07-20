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

package com.google.cloud.vision.v1p4beta1;

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
public class ImageAnnotatorClientTest {
  private static MockImageAnnotator mockImageAnnotator;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ImageAnnotatorClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockImageAnnotator = new MockImageAnnotator();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockImageAnnotator));
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
    ImageAnnotatorSettings settings =
        ImageAnnotatorSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ImageAnnotatorClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void batchAnnotateImagesTest() throws Exception {
    BatchAnnotateImagesResponse expectedResponse =
        BatchAnnotateImagesResponse.newBuilder()
            .addAllResponses(new ArrayList<AnnotateImageResponse>())
            .build();
    mockImageAnnotator.addResponse(expectedResponse);

    List<AnnotateImageRequest> requests = new ArrayList<>();

    BatchAnnotateImagesResponse actualResponse = client.batchAnnotateImages(requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockImageAnnotator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchAnnotateImagesRequest actualRequest = ((BatchAnnotateImagesRequest) actualRequests.get(0));

    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchAnnotateImagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockImageAnnotator.addException(exception);

    try {
      List<AnnotateImageRequest> requests = new ArrayList<>();
      client.batchAnnotateImages(requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchAnnotateFilesTest() throws Exception {
    BatchAnnotateFilesResponse expectedResponse =
        BatchAnnotateFilesResponse.newBuilder()
            .addAllResponses(new ArrayList<AnnotateFileResponse>())
            .build();
    mockImageAnnotator.addResponse(expectedResponse);

    List<AnnotateFileRequest> requests = new ArrayList<>();

    BatchAnnotateFilesResponse actualResponse = client.batchAnnotateFiles(requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockImageAnnotator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchAnnotateFilesRequest actualRequest = ((BatchAnnotateFilesRequest) actualRequests.get(0));

    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchAnnotateFilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockImageAnnotator.addException(exception);

    try {
      List<AnnotateFileRequest> requests = new ArrayList<>();
      client.batchAnnotateFiles(requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void asyncBatchAnnotateImagesTest() throws Exception {
    AsyncBatchAnnotateImagesResponse expectedResponse =
        AsyncBatchAnnotateImagesResponse.newBuilder()
            .setOutputConfig(OutputConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("asyncBatchAnnotateImagesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockImageAnnotator.addResponse(resultOperation);

    List<AnnotateImageRequest> requests = new ArrayList<>();
    OutputConfig outputConfig = OutputConfig.newBuilder().build();

    AsyncBatchAnnotateImagesResponse actualResponse =
        client.asyncBatchAnnotateImagesAsync(requests, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockImageAnnotator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AsyncBatchAnnotateImagesRequest actualRequest =
        ((AsyncBatchAnnotateImagesRequest) actualRequests.get(0));

    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void asyncBatchAnnotateImagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockImageAnnotator.addException(exception);

    try {
      List<AnnotateImageRequest> requests = new ArrayList<>();
      OutputConfig outputConfig = OutputConfig.newBuilder().build();
      client.asyncBatchAnnotateImagesAsync(requests, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void asyncBatchAnnotateFilesTest() throws Exception {
    AsyncBatchAnnotateFilesResponse expectedResponse =
        AsyncBatchAnnotateFilesResponse.newBuilder()
            .addAllResponses(new ArrayList<AsyncAnnotateFileResponse>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("asyncBatchAnnotateFilesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockImageAnnotator.addResponse(resultOperation);

    List<AsyncAnnotateFileRequest> requests = new ArrayList<>();

    AsyncBatchAnnotateFilesResponse actualResponse =
        client.asyncBatchAnnotateFilesAsync(requests).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockImageAnnotator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AsyncBatchAnnotateFilesRequest actualRequest =
        ((AsyncBatchAnnotateFilesRequest) actualRequests.get(0));

    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void asyncBatchAnnotateFilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockImageAnnotator.addException(exception);

    try {
      List<AsyncAnnotateFileRequest> requests = new ArrayList<>();
      client.asyncBatchAnnotateFilesAsync(requests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
