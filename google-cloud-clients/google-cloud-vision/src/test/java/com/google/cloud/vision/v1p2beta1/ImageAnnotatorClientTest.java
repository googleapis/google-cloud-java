/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.vision.v1p2beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ImageAnnotatorClientTest {
  private static MockImageAnnotator mockImageAnnotator;
  private static MockServiceHelper serviceHelper;
  private ImageAnnotatorClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockImageAnnotator = new MockImageAnnotator();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockImageAnnotator));
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
  @SuppressWarnings("all")
  public void batchAnnotateImagesTest() {
    BatchAnnotateImagesResponse expectedResponse = BatchAnnotateImagesResponse.newBuilder().build();
    mockImageAnnotator.addResponse(expectedResponse);

    List<AnnotateImageRequest> requests = new ArrayList<>();

    BatchAnnotateImagesResponse actualResponse = client.batchAnnotateImages(requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockImageAnnotator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchAnnotateImagesRequest actualRequest = (BatchAnnotateImagesRequest) actualRequests.get(0);

    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchAnnotateImagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockImageAnnotator.addException(exception);

    try {
      List<AnnotateImageRequest> requests = new ArrayList<>();

      client.batchAnnotateImages(requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void asyncBatchAnnotateFilesTest() throws Exception {
    AsyncBatchAnnotateFilesResponse expectedResponse =
        AsyncBatchAnnotateFilesResponse.newBuilder().build();
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

    List<GeneratedMessageV3> actualRequests = mockImageAnnotator.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AsyncBatchAnnotateFilesRequest actualRequest =
        (AsyncBatchAnnotateFilesRequest) actualRequests.get(0);

    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void asyncBatchAnnotateFilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockImageAnnotator.addException(exception);

    try {
      List<AsyncAnnotateFileRequest> requests = new ArrayList<>();

      client.asyncBatchAnnotateFilesAsync(requests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
