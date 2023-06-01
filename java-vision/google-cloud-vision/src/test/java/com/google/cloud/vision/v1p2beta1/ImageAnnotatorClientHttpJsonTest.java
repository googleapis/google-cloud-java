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

package com.google.cloud.vision.v1p2beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.vision.v1p2beta1.stub.HttpJsonImageAnnotatorStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ImageAnnotatorClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ImageAnnotatorClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonImageAnnotatorStub.getMethodDescriptors(),
            ImageAnnotatorSettings.getDefaultEndpoint());
    ImageAnnotatorSettings settings =
        ImageAnnotatorSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ImageAnnotatorSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ImageAnnotatorClient.create(settings);
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
  public void batchAnnotateImagesTest() throws Exception {
    BatchAnnotateImagesResponse expectedResponse =
        BatchAnnotateImagesResponse.newBuilder()
            .addAllResponses(new ArrayList<AnnotateImageResponse>())
            .build();
    mockService.addResponse(expectedResponse);

    List<AnnotateImageRequest> requests = new ArrayList<>();

    BatchAnnotateImagesResponse actualResponse = client.batchAnnotateImages(requests);
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
  public void batchAnnotateImagesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      List<AnnotateImageRequest> requests = new ArrayList<>();
      client.batchAnnotateImages(requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockService.addResponse(resultOperation);

    List<AsyncAnnotateFileRequest> requests = new ArrayList<>();

    AsyncBatchAnnotateFilesResponse actualResponse =
        client.asyncBatchAnnotateFilesAsync(requests).get();
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
  public void asyncBatchAnnotateFilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      List<AsyncAnnotateFileRequest> requests = new ArrayList<>();
      client.asyncBatchAnnotateFilesAsync(requests).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
