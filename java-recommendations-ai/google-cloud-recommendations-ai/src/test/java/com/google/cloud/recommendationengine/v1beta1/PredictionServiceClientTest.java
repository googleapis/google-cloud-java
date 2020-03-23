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
package com.google.cloud.recommendationengine.v1beta1;

import static com.google.cloud.recommendationengine.v1beta1.PredictionServiceClient.PredictPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class PredictionServiceClientTest {
  private static MockCatalogService mockCatalogService;
  private static MockPredictionApiKeyRegistry mockPredictionApiKeyRegistry;
  private static MockPredictionService mockPredictionService;
  private static MockUserEventService mockUserEventService;
  private static MockServiceHelper serviceHelper;
  private PredictionServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCatalogService = new MockCatalogService();
    mockPredictionApiKeyRegistry = new MockPredictionApiKeyRegistry();
    mockPredictionService = new MockPredictionService();
    mockUserEventService = new MockUserEventService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockCatalogService,
                mockPredictionApiKeyRegistry,
                mockPredictionService,
                mockUserEventService));
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
    PredictionServiceSettings settings =
        PredictionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PredictionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void predictTest() {
    String recommendationToken = "recommendationToken-1973883405";
    boolean dryRun = false;
    String nextPageToken = "";
    PredictResponse.PredictionResult resultsElement =
        PredictResponse.PredictionResult.newBuilder().build();
    List<PredictResponse.PredictionResult> results = Arrays.asList(resultsElement);
    PredictResponse expectedResponse =
        PredictResponse.newBuilder()
            .setRecommendationToken(recommendationToken)
            .setDryRun(dryRun)
            .setNextPageToken(nextPageToken)
            .addAllResults(results)
            .build();
    mockPredictionService.addResponse(expectedResponse);

    String formattedName =
        PredictionServiceClient.formatPlacementName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PLACEMENT]");
    UserEvent userEvent = UserEvent.newBuilder().build();
    PredictRequest request =
        PredictRequest.newBuilder().setName(formattedName).setUserEvent(userEvent).build();

    PredictPagedResponse pagedListResponse = client.predict(request);

    List<PredictResponse.PredictionResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PredictRequest actualRequest = (PredictRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(userEvent, actualRequest.getUserEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void predictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      String formattedName =
          PredictionServiceClient.formatPlacementName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PLACEMENT]");
      UserEvent userEvent = UserEvent.newBuilder().build();
      PredictRequest request =
          PredictRequest.newBuilder().setName(formattedName).setUserEvent(userEvent).build();

      client.predict(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
