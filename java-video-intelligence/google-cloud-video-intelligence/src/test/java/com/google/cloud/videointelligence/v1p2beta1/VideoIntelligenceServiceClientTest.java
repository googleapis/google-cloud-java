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

package com.google.cloud.videointelligence.v1p2beta1;

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
public class VideoIntelligenceServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockVideoIntelligenceService mockVideoIntelligenceService;
  private LocalChannelProvider channelProvider;
  private VideoIntelligenceServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVideoIntelligenceService = new MockVideoIntelligenceService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockVideoIntelligenceService));
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
    VideoIntelligenceServiceSettings settings =
        VideoIntelligenceServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VideoIntelligenceServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void annotateVideoTest() throws Exception {
    AnnotateVideoResponse expectedResponse =
        AnnotateVideoResponse.newBuilder()
            .addAllAnnotationResults(new ArrayList<VideoAnnotationResults>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("annotateVideoTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVideoIntelligenceService.addResponse(resultOperation);

    String inputUri = "inputUri470706498";
    List<Feature> features = new ArrayList<>();

    AnnotateVideoResponse actualResponse = client.annotateVideoAsync(inputUri, features).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVideoIntelligenceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnnotateVideoRequest actualRequest = ((AnnotateVideoRequest) actualRequests.get(0));

    Assert.assertEquals(inputUri, actualRequest.getInputUri());
    Assert.assertEquals(features, actualRequest.getFeaturesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void annotateVideoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVideoIntelligenceService.addException(exception);

    try {
      String inputUri = "inputUri470706498";
      List<Feature> features = new ArrayList<>();
      client.annotateVideoAsync(inputUri, features).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
