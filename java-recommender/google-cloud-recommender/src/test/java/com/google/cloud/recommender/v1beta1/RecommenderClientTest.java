/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.recommender.v1beta1;

import static com.google.cloud.recommender.v1beta1.RecommenderClient.ListRecommendationsPagedResponse;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class RecommenderClientTest {
  private static MockRecommender mockRecommender;
  private static MockServiceHelper serviceHelper;
  private RecommenderClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockRecommender = new MockRecommender();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockRecommender));
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
    RecommenderSettings settings =
        RecommenderSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RecommenderClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listRecommendationsTest() {
    String nextPageToken = "";
    Recommendation recommendationsElement = Recommendation.newBuilder().build();
    List<Recommendation> recommendations = Arrays.asList(recommendationsElement);
    ListRecommendationsResponse expectedResponse =
        ListRecommendationsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllRecommendations(recommendations)
            .build();
    mockRecommender.addResponse(expectedResponse);

    String formattedParent =
        RecommenderClient.formatRecommenderName("[PROJECT]", "[LOCATION]", "[RECOMMENDER]");
    String filter = "filter-1274492040";

    ListRecommendationsPagedResponse pagedListResponse =
        client.listRecommendations(formattedParent, filter);

    List<Recommendation> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecommendationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRecommendationsRequest actualRequest = (ListRecommendationsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listRecommendationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String formattedParent =
          RecommenderClient.formatRecommenderName("[PROJECT]", "[LOCATION]", "[RECOMMENDER]");
      String filter = "filter-1274492040";

      client.listRecommendations(formattedParent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getRecommendationTest() {
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    String recommenderSubtype = "recommenderSubtype-1488504412";
    String etag = "etag3123477";
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setRecommenderSubtype(recommenderSubtype)
            .setEtag(etag)
            .build();
    mockRecommender.addResponse(expectedResponse);

    String formattedName =
        RecommenderClient.formatRecommendationName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");

    Recommendation actualResponse = client.getRecommendation(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRecommendationRequest actualRequest = (GetRecommendationRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getRecommendationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String formattedName =
          RecommenderClient.formatRecommendationName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");

      client.getRecommendation(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationClaimedTest() {
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    String recommenderSubtype = "recommenderSubtype-1488504412";
    String etag2 = "etag2-1293302904";
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setRecommenderSubtype(recommenderSubtype)
            .setEtag(etag2)
            .build();
    mockRecommender.addResponse(expectedResponse);

    String formattedName =
        RecommenderClient.formatRecommendationName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse =
        client.markRecommendationClaimed(formattedName, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationClaimedRequest actualRequest =
        (MarkRecommendationClaimedRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationClaimedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String formattedName =
          RecommenderClient.formatRecommendationName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";

      client.markRecommendationClaimed(formattedName, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationSucceededTest() {
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    String recommenderSubtype = "recommenderSubtype-1488504412";
    String etag2 = "etag2-1293302904";
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setRecommenderSubtype(recommenderSubtype)
            .setEtag(etag2)
            .build();
    mockRecommender.addResponse(expectedResponse);

    String formattedName =
        RecommenderClient.formatRecommendationName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse =
        client.markRecommendationSucceeded(formattedName, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationSucceededRequest actualRequest =
        (MarkRecommendationSucceededRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationSucceededExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String formattedName =
          RecommenderClient.formatRecommendationName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";

      client.markRecommendationSucceeded(formattedName, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationFailedTest() {
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    String recommenderSubtype = "recommenderSubtype-1488504412";
    String etag2 = "etag2-1293302904";
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setRecommenderSubtype(recommenderSubtype)
            .setEtag(etag2)
            .build();
    mockRecommender.addResponse(expectedResponse);

    String formattedName =
        RecommenderClient.formatRecommendationName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse =
        client.markRecommendationFailed(formattedName, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationFailedRequest actualRequest =
        (MarkRecommendationFailedRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationFailedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String formattedName =
          RecommenderClient.formatRecommendationName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";

      client.markRecommendationFailed(formattedName, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
