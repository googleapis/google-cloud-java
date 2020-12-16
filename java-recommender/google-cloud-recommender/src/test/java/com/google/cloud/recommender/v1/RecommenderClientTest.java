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

package com.google.cloud.recommender.v1;

import static com.google.cloud.recommender.v1.RecommenderClient.ListInsightsPagedResponse;
import static com.google.cloud.recommender.v1.RecommenderClient.ListRecommendationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class RecommenderClientTest {
  private static MockServiceHelper mockServiceHelper;
  private RecommenderClient client;
  private LocalChannelProvider channelProvider;
  private static MockRecommender mockRecommender;

  @BeforeClass
  public static void startStaticServer() {
    mockRecommender = new MockRecommender();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockRecommender));
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
  public void listInsightsTest() throws Exception {
    Insight responsesElement = Insight.newBuilder().build();
    ListInsightsResponse expectedResponse =
        ListInsightsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInsights(Arrays.asList(responsesElement))
            .build();
    mockRecommender.addResponse(expectedResponse);

    InsightTypeName parent =
        InsightTypeName.ofProjectLocationInsightTypeName(
            "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]");

    ListInsightsPagedResponse pagedListResponse = client.listInsights(parent);

    List<Insight> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInsightsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInsightsRequest actualRequest = ((ListInsightsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInsightsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      InsightTypeName parent =
          InsightTypeName.ofProjectLocationInsightTypeName(
              "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]");
      client.listInsights(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInsightsTest2() throws Exception {
    Insight responsesElement = Insight.newBuilder().build();
    ListInsightsResponse expectedResponse =
        ListInsightsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInsights(Arrays.asList(responsesElement))
            .build();
    mockRecommender.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInsightsPagedResponse pagedListResponse = client.listInsights(parent);

    List<Insight> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInsightsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInsightsRequest actualRequest = ((ListInsightsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInsightsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInsights(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInsightTest() throws Exception {
    Insight expectedResponse =
        Insight.newBuilder()
            .setName(
                InsightName.ofProjectLocationInsightTypeInsightName(
                        "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllTargetResources(new ArrayList<String>())
            .setInsightSubtype("insightSubtype841535170")
            .setContent(Struct.newBuilder().build())
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setObservationPeriod(Duration.newBuilder().build())
            .setStateInfo(InsightStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedRecommendations(new ArrayList<Insight.RecommendationReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    InsightName name =
        InsightName.ofProjectLocationInsightTypeInsightName(
            "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");

    Insight actualResponse = client.getInsight(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInsightRequest actualRequest = ((GetInsightRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInsightExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      InsightName name =
          InsightName.ofProjectLocationInsightTypeInsightName(
              "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");
      client.getInsight(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInsightTest2() throws Exception {
    Insight expectedResponse =
        Insight.newBuilder()
            .setName(
                InsightName.ofProjectLocationInsightTypeInsightName(
                        "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllTargetResources(new ArrayList<String>())
            .setInsightSubtype("insightSubtype841535170")
            .setContent(Struct.newBuilder().build())
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setObservationPeriod(Duration.newBuilder().build())
            .setStateInfo(InsightStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedRecommendations(new ArrayList<Insight.RecommendationReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    String name = "name3373707";

    Insight actualResponse = client.getInsight(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInsightRequest actualRequest = ((GetInsightRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInsightExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String name = "name3373707";
      client.getInsight(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void markInsightAcceptedTest() throws Exception {
    Insight expectedResponse =
        Insight.newBuilder()
            .setName(
                InsightName.ofProjectLocationInsightTypeInsightName(
                        "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllTargetResources(new ArrayList<String>())
            .setInsightSubtype("insightSubtype841535170")
            .setContent(Struct.newBuilder().build())
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setObservationPeriod(Duration.newBuilder().build())
            .setStateInfo(InsightStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedRecommendations(new ArrayList<Insight.RecommendationReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    InsightName name =
        InsightName.ofProjectLocationInsightTypeInsightName(
            "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Insight actualResponse = client.markInsightAccepted(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkInsightAcceptedRequest actualRequest = ((MarkInsightAcceptedRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void markInsightAcceptedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      InsightName name =
          InsightName.ofProjectLocationInsightTypeInsightName(
              "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";
      client.markInsightAccepted(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void markInsightAcceptedTest2() throws Exception {
    Insight expectedResponse =
        Insight.newBuilder()
            .setName(
                InsightName.ofProjectLocationInsightTypeInsightName(
                        "[PROJECT]", "[LOCATION]", "[INSIGHT_TYPE]", "[INSIGHT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllTargetResources(new ArrayList<String>())
            .setInsightSubtype("insightSubtype841535170")
            .setContent(Struct.newBuilder().build())
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setObservationPeriod(Duration.newBuilder().build())
            .setStateInfo(InsightStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedRecommendations(new ArrayList<Insight.RecommendationReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    String name = "name3373707";
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Insight actualResponse = client.markInsightAccepted(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkInsightAcceptedRequest actualRequest = ((MarkInsightAcceptedRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void markInsightAcceptedExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String name = "name3373707";
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";
      client.markInsightAccepted(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRecommendationsTest() throws Exception {
    Recommendation responsesElement = Recommendation.newBuilder().build();
    ListRecommendationsResponse expectedResponse =
        ListRecommendationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRecommendations(Arrays.asList(responsesElement))
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommenderName parent =
        RecommenderName.ofProjectLocationRecommenderName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]");

    ListRecommendationsPagedResponse pagedListResponse = client.listRecommendations(parent);

    List<Recommendation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecommendationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRecommendationsRequest actualRequest = ((ListRecommendationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRecommendationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      RecommenderName parent =
          RecommenderName.ofProjectLocationRecommenderName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]");
      client.listRecommendations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRecommendationsTest2() throws Exception {
    Recommendation responsesElement = Recommendation.newBuilder().build();
    ListRecommendationsResponse expectedResponse =
        ListRecommendationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRecommendations(Arrays.asList(responsesElement))
            .build();
    mockRecommender.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRecommendationsPagedResponse pagedListResponse = client.listRecommendations(parent);

    List<Recommendation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecommendationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRecommendationsRequest actualRequest = ((ListRecommendationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRecommendationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRecommendations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRecommendationsTest3() throws Exception {
    Recommendation responsesElement = Recommendation.newBuilder().build();
    ListRecommendationsResponse expectedResponse =
        ListRecommendationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRecommendations(Arrays.asList(responsesElement))
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommenderName parent =
        RecommenderName.ofProjectLocationRecommenderName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]");
    String filter = "filter-1274492040";

    ListRecommendationsPagedResponse pagedListResponse = client.listRecommendations(parent, filter);

    List<Recommendation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecommendationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRecommendationsRequest actualRequest = ((ListRecommendationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRecommendationsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      RecommenderName parent =
          RecommenderName.ofProjectLocationRecommenderName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]");
      String filter = "filter-1274492040";
      client.listRecommendations(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRecommendationsTest4() throws Exception {
    Recommendation responsesElement = Recommendation.newBuilder().build();
    ListRecommendationsResponse expectedResponse =
        ListRecommendationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRecommendations(Arrays.asList(responsesElement))
            .build();
    mockRecommender.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListRecommendationsPagedResponse pagedListResponse = client.listRecommendations(parent, filter);

    List<Recommendation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecommendationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRecommendationsRequest actualRequest = ((ListRecommendationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRecommendationsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listRecommendations(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRecommendationTest() throws Exception {
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(
                RecommendationName.ofProjectLocationRecommenderRecommendationName(
                        "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setRecommenderSubtype("recommenderSubtype1811451601")
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setPrimaryImpact(Impact.newBuilder().build())
            .addAllAdditionalImpact(new ArrayList<Impact>())
            .setContent(RecommendationContent.newBuilder().build())
            .setStateInfo(RecommendationStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedInsights(new ArrayList<Recommendation.InsightReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommendationName name =
        RecommendationName.ofProjectLocationRecommenderRecommendationName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");

    Recommendation actualResponse = client.getRecommendation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRecommendationRequest actualRequest = ((GetRecommendationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRecommendationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      RecommendationName name =
          RecommendationName.ofProjectLocationRecommenderRecommendationName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      client.getRecommendation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRecommendationTest2() throws Exception {
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(
                RecommendationName.ofProjectLocationRecommenderRecommendationName(
                        "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setRecommenderSubtype("recommenderSubtype1811451601")
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setPrimaryImpact(Impact.newBuilder().build())
            .addAllAdditionalImpact(new ArrayList<Impact>())
            .setContent(RecommendationContent.newBuilder().build())
            .setStateInfo(RecommendationStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedInsights(new ArrayList<Recommendation.InsightReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    String name = "name3373707";

    Recommendation actualResponse = client.getRecommendation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRecommendationRequest actualRequest = ((GetRecommendationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRecommendationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String name = "name3373707";
      client.getRecommendation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void markRecommendationClaimedTest() throws Exception {
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(
                RecommendationName.ofProjectLocationRecommenderRecommendationName(
                        "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setRecommenderSubtype("recommenderSubtype1811451601")
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setPrimaryImpact(Impact.newBuilder().build())
            .addAllAdditionalImpact(new ArrayList<Impact>())
            .setContent(RecommendationContent.newBuilder().build())
            .setStateInfo(RecommendationStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedInsights(new ArrayList<Recommendation.InsightReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommendationName name =
        RecommendationName.ofProjectLocationRecommenderRecommendationName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationClaimed(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationClaimedRequest actualRequest =
        ((MarkRecommendationClaimedRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void markRecommendationClaimedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      RecommendationName name =
          RecommendationName.ofProjectLocationRecommenderRecommendationName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";
      client.markRecommendationClaimed(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void markRecommendationClaimedTest2() throws Exception {
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(
                RecommendationName.ofProjectLocationRecommenderRecommendationName(
                        "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setRecommenderSubtype("recommenderSubtype1811451601")
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setPrimaryImpact(Impact.newBuilder().build())
            .addAllAdditionalImpact(new ArrayList<Impact>())
            .setContent(RecommendationContent.newBuilder().build())
            .setStateInfo(RecommendationStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedInsights(new ArrayList<Recommendation.InsightReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    String name = "name3373707";
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationClaimed(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationClaimedRequest actualRequest =
        ((MarkRecommendationClaimedRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void markRecommendationClaimedExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String name = "name3373707";
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";
      client.markRecommendationClaimed(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void markRecommendationSucceededTest() throws Exception {
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(
                RecommendationName.ofProjectLocationRecommenderRecommendationName(
                        "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setRecommenderSubtype("recommenderSubtype1811451601")
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setPrimaryImpact(Impact.newBuilder().build())
            .addAllAdditionalImpact(new ArrayList<Impact>())
            .setContent(RecommendationContent.newBuilder().build())
            .setStateInfo(RecommendationStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedInsights(new ArrayList<Recommendation.InsightReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommendationName name =
        RecommendationName.ofProjectLocationRecommenderRecommendationName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationSucceeded(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationSucceededRequest actualRequest =
        ((MarkRecommendationSucceededRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void markRecommendationSucceededExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      RecommendationName name =
          RecommendationName.ofProjectLocationRecommenderRecommendationName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";
      client.markRecommendationSucceeded(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void markRecommendationSucceededTest2() throws Exception {
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(
                RecommendationName.ofProjectLocationRecommenderRecommendationName(
                        "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setRecommenderSubtype("recommenderSubtype1811451601")
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setPrimaryImpact(Impact.newBuilder().build())
            .addAllAdditionalImpact(new ArrayList<Impact>())
            .setContent(RecommendationContent.newBuilder().build())
            .setStateInfo(RecommendationStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedInsights(new ArrayList<Recommendation.InsightReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    String name = "name3373707";
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationSucceeded(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationSucceededRequest actualRequest =
        ((MarkRecommendationSucceededRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void markRecommendationSucceededExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String name = "name3373707";
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";
      client.markRecommendationSucceeded(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void markRecommendationFailedTest() throws Exception {
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(
                RecommendationName.ofProjectLocationRecommenderRecommendationName(
                        "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setRecommenderSubtype("recommenderSubtype1811451601")
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setPrimaryImpact(Impact.newBuilder().build())
            .addAllAdditionalImpact(new ArrayList<Impact>())
            .setContent(RecommendationContent.newBuilder().build())
            .setStateInfo(RecommendationStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedInsights(new ArrayList<Recommendation.InsightReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    RecommendationName name =
        RecommendationName.ofProjectLocationRecommenderRecommendationName(
            "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationFailed(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationFailedRequest actualRequest =
        ((MarkRecommendationFailedRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void markRecommendationFailedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      RecommendationName name =
          RecommendationName.ofProjectLocationRecommenderRecommendationName(
              "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]");
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";
      client.markRecommendationFailed(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void markRecommendationFailedTest2() throws Exception {
    Recommendation expectedResponse =
        Recommendation.newBuilder()
            .setName(
                RecommendationName.ofProjectLocationRecommenderRecommendationName(
                        "[PROJECT]", "[LOCATION]", "[RECOMMENDER]", "[RECOMMENDATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setRecommenderSubtype("recommenderSubtype1811451601")
            .setLastRefreshTime(Timestamp.newBuilder().build())
            .setPrimaryImpact(Impact.newBuilder().build())
            .addAllAdditionalImpact(new ArrayList<Impact>())
            .setContent(RecommendationContent.newBuilder().build())
            .setStateInfo(RecommendationStateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .addAllAssociatedInsights(new ArrayList<Recommendation.InsightReference>())
            .build();
    mockRecommender.addResponse(expectedResponse);

    String name = "name3373707";
    Map<String, String> stateMetadata = new HashMap<>();
    String etag = "etag3123477";

    Recommendation actualResponse = client.markRecommendationFailed(name, stateMetadata, etag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecommender.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MarkRecommendationFailedRequest actualRequest =
        ((MarkRecommendationFailedRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(stateMetadata, actualRequest.getStateMetadataMap());
    Assert.assertEquals(etag, actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void markRecommendationFailedExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecommender.addException(exception);

    try {
      String name = "name3373707";
      Map<String, String> stateMetadata = new HashMap<>();
      String etag = "etag3123477";
      client.markRecommendationFailed(name, stateMetadata, etag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
