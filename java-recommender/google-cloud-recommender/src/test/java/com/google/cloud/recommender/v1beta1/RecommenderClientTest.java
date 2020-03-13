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
package com.google.cloud.recommender.v1beta1;

import static com.google.cloud.recommender.v1beta1.RecommenderClient.ListInsightsPagedResponse;
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
  public void listInsightsTest() {
    String nextPageToken = "";
    Insight insightsElement = Insight.newBuilder().build();
    List<Insight> insights = Arrays.asList(insightsElement);
    ListInsightsResponse expectedResponse =
        ListInsightsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllInsights(insights)
            .build();
    mockRecommender.addResponse(expectedResponse);

    InsightTypeName parent = InsightTypeName.of("[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]");

    ListInsightsPagedResponse pagedListResponse = client.listInsights(parent);

    List<Insight> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInsightsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInsightsRequest actualRequest = (ListInsightsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, InsightTypeName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listInsightsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      InsightTypeName parent = InsightTypeName.of("[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]");

      client.listInsights(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInsightTest() {
    InsightName name2 = InsightName.of("[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");
    String description = "description-1724546052";
    String insightSubtype = "insightSubtype-1491142701";
    String etag = "etag3123477";
    Insight expectedResponse =
        Insight.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setInsightSubtype(insightSubtype)
            .setEtag(etag)
            .build();
    mockRecommender.addResponse(expectedResponse);

    InsightName name = InsightName.of("[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");

    Insight actualResponse = client.getInsight(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInsightRequest actualRequest = (GetInsightRequest) actualRequests.get(0);

    Assert.assertEquals(name, InsightName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getInsightExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      InsightName name = InsightName.of("[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");

      client.getInsight(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void markInsightAcceptedTest() {
    InsightName name2 = InsightName.of("[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");
    String description = "description-1724546052";
    String insightSubtype = "insightSubtype-1491142701";
    String etag2 = "etag2-1293302904";
    Insight expectedResponse =
        Insight.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setInsightSubtype(insightSubtype)
            .setEtag(etag2)
            .build();
    mockRecommender.addResponse(expectedResponse);

    InsightName name = InsightName.of("[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Insight actualResponse = client.markInsightAccepted(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkInsightAcceptedRequest actualRequest = (MarkInsightAcceptedRequest) actualRequests.get(0);

    Assert.assertEquals(name, InsightName.parse(actualRequest.getName()));
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void markInsightAcceptedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      InsightName name = InsightName.of("[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";

      client.markInsightAccepted(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
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

    RecommenderName parent = RecommenderName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]");
    String filter = "filter-1274492040";

    ListRecommendationsPagedResponse pagedListResponse = client.listRecommendations(parent, filter);

    List<Recommendation> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecommendationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRecommendationsRequest actualRequest = (ListRecommendationsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RecommenderName.parse(actualRequest.getParent()));
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
      RecommenderName parent = RecommenderName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]");
      String filter = "filter-1274492040";

      client.listRecommendations(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getRecommendationTest() {
    RecommendationName name2 =
        RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    String description = "description-1724546052";
    String recommenderSubtype = "recommenderSubtype-1488504412";
    String etag = "etag3123477";
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setRecommenderSubtype(recommenderSubtype)
            .setEtag(etag)
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommendationName name =
        RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");

    Recommendation actualResponse = client.getRecommendation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRecommendationRequest actualRequest = (GetRecommendationRequest) actualRequests.get(0);

    Assert.assertEquals(name, RecommendationName.parse(actualRequest.getName()));
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
      RecommendationName name =
          RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");

      client.getRecommendation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationClaimedTest() {
    RecommendationName name2 =
        RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    String description = "description-1724546052";
    String recommenderSubtype = "recommenderSubtype-1488504412";
    String etag2 = "etag2-1293302904";
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setRecommenderSubtype(recommenderSubtype)
            .setEtag(etag2)
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommendationName name =
        RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationClaimed(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationClaimedRequest actualRequest =
        (MarkRecommendationClaimedRequest) actualRequests.get(0);

    Assert.assertEquals(name, RecommendationName.parse(actualRequest.getName()));
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
      RecommendationName name =
          RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";

      client.markRecommendationClaimed(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationSucceededTest() {
    RecommendationName name2 =
        RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    String description = "description-1724546052";
    String recommenderSubtype = "recommenderSubtype-1488504412";
    String etag2 = "etag2-1293302904";
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setRecommenderSubtype(recommenderSubtype)
            .setEtag(etag2)
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommendationName name =
        RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationSucceeded(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationSucceededRequest actualRequest =
        (MarkRecommendationSucceededRequest) actualRequests.get(0);

    Assert.assertEquals(name, RecommendationName.parse(actualRequest.getName()));
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
      RecommendationName name =
          RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";

      client.markRecommendationSucceeded(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void markRecommendationFailedTest() {
    RecommendationName name2 =
        RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    String description = "description-1724546052";
    String recommenderSubtype = "recommenderSubtype-1488504412";
    String etag2 = "etag2-1293302904";
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setRecommenderSubtype(recommenderSubtype)
            .setEtag(etag2)
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommendationName name =
        RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationFailed(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationFailedRequest actualRequest =
        (MarkRecommendationFailedRequest) actualRequests.get(0);

    Assert.assertEquals(name, RecommendationName.parse(actualRequest.getName()));
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
      RecommendationName name =
          RecommendationName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";

      client.markRecommendationFailed(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
