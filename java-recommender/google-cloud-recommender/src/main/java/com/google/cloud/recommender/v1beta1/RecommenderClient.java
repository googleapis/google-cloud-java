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

package com.google.cloud.recommender.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommender.v1beta1.stub.RecommenderStub;
import com.google.cloud.recommender.v1beta1.stub.RecommenderStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides insights and recommendations for cloud customers for various
 * categories like performance optimization, cost savings, reliability, feature discovery, etc.
 * Insights and recommendations are generated automatically based on analysis of user resources,
 * configuration and monitoring metrics.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the RecommenderClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of RecommenderSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * RecommenderSettings recommenderSettings =
 *     RecommenderSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RecommenderClient recommenderClient = RecommenderClient.create(recommenderSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * RecommenderSettings recommenderSettings =
 *     RecommenderSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RecommenderClient recommenderClient = RecommenderClient.create(recommenderSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class RecommenderClient implements BackgroundResource {
  private final RecommenderSettings settings;
  private final RecommenderStub stub;

  /** Constructs an instance of RecommenderClient with default settings. */
  public static final RecommenderClient create() throws IOException {
    return create(RecommenderSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RecommenderClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RecommenderClient create(RecommenderSettings settings) throws IOException {
    return new RecommenderClient(settings);
  }

  /**
   * Constructs an instance of RecommenderClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RecommenderSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RecommenderClient create(RecommenderStub stub) {
    return new RecommenderClient(stub);
  }

  /**
   * Constructs an instance of RecommenderClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RecommenderClient(RecommenderSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RecommenderStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RecommenderClient(RecommenderStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RecommenderSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RecommenderStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists insights for a Cloud project. Requires the recommender.&#42;.list IAM permission for the
   * specified insight type.
   *
   * @param parent Required. The container resource on which to execute the request. Acceptable
   *     formats:
   *     <p>1. "projects/[PROJECT_NUMBER]/locations/[LOCATION]/insightTypes/[INSIGHT_TYPE_ID]",
   *     <p>LOCATION here refers to GCP Locations: https://cloud.google.com/about/locations/
   *     INSIGHT_TYPE_ID refers to supported insight types:
   *     https://cloud.google.com/recommender/docs/insights/insight-types.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInsightsPagedResponse listInsights(InsightTypeName parent) {
    ListInsightsRequest request =
        ListInsightsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInsights(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists insights for a Cloud project. Requires the recommender.&#42;.list IAM permission for the
   * specified insight type.
   *
   * @param parent Required. The container resource on which to execute the request. Acceptable
   *     formats:
   *     <p>1. "projects/[PROJECT_NUMBER]/locations/[LOCATION]/insightTypes/[INSIGHT_TYPE_ID]",
   *     <p>LOCATION here refers to GCP Locations: https://cloud.google.com/about/locations/
   *     INSIGHT_TYPE_ID refers to supported insight types:
   *     https://cloud.google.com/recommender/docs/insights/insight-types.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInsightsPagedResponse listInsights(String parent) {
    ListInsightsRequest request = ListInsightsRequest.newBuilder().setParent(parent).build();
    return listInsights(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists insights for a Cloud project. Requires the recommender.&#42;.list IAM permission for the
   * specified insight type.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInsightsPagedResponse listInsights(ListInsightsRequest request) {
    return listInsightsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists insights for a Cloud project. Requires the recommender.&#42;.list IAM permission for the
   * specified insight type.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListInsightsRequest, ListInsightsPagedResponse>
      listInsightsPagedCallable() {
    return stub.listInsightsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists insights for a Cloud project. Requires the recommender.&#42;.list IAM permission for the
   * specified insight type.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListInsightsRequest, ListInsightsResponse> listInsightsCallable() {
    return stub.listInsightsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the requested insight. Requires the recommender.&#42;.get IAM permission for the specified
   * insight type.
   *
   * @param name Required. Name of the insight.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Insight getInsight(InsightName name) {
    GetInsightRequest request =
        GetInsightRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInsight(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the requested insight. Requires the recommender.&#42;.get IAM permission for the specified
   * insight type.
   *
   * @param name Required. Name of the insight.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Insight getInsight(String name) {
    GetInsightRequest request = GetInsightRequest.newBuilder().setName(name).build();
    return getInsight(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the requested insight. Requires the recommender.&#42;.get IAM permission for the specified
   * insight type.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Insight getInsight(GetInsightRequest request) {
    return getInsightCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the requested insight. Requires the recommender.&#42;.get IAM permission for the specified
   * insight type.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetInsightRequest, Insight> getInsightCallable() {
    return stub.getInsightCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Insight State as Accepted. Users can use this method to indicate to the Recommender
   * API that they have applied some action based on the insight. This stops the insight content
   * from being updated.
   *
   * <p>MarkInsightAccepted can be applied to insights in ACTIVE state. Requires the
   * recommender.&#42;.update IAM permission for the specified insight.
   *
   * @param name Required. Name of the insight.
   * @param stateMetadata Optional. State properties user wish to include with this state. Full
   *     replace of the current state_metadata.
   * @param etag Required. Fingerprint of the Insight. Provides optimistic locking.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Insight markInsightAccepted(
      InsightName name, Map<String, String> stateMetadata, String etag) {
    MarkInsightAcceptedRequest request =
        MarkInsightAcceptedRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .putAllStateMetadata(stateMetadata)
            .setEtag(etag)
            .build();
    return markInsightAccepted(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Insight State as Accepted. Users can use this method to indicate to the Recommender
   * API that they have applied some action based on the insight. This stops the insight content
   * from being updated.
   *
   * <p>MarkInsightAccepted can be applied to insights in ACTIVE state. Requires the
   * recommender.&#42;.update IAM permission for the specified insight.
   *
   * @param name Required. Name of the insight.
   * @param stateMetadata Optional. State properties user wish to include with this state. Full
   *     replace of the current state_metadata.
   * @param etag Required. Fingerprint of the Insight. Provides optimistic locking.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Insight markInsightAccepted(
      String name, Map<String, String> stateMetadata, String etag) {
    MarkInsightAcceptedRequest request =
        MarkInsightAcceptedRequest.newBuilder()
            .setName(name)
            .putAllStateMetadata(stateMetadata)
            .setEtag(etag)
            .build();
    return markInsightAccepted(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Insight State as Accepted. Users can use this method to indicate to the Recommender
   * API that they have applied some action based on the insight. This stops the insight content
   * from being updated.
   *
   * <p>MarkInsightAccepted can be applied to insights in ACTIVE state. Requires the
   * recommender.&#42;.update IAM permission for the specified insight.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Insight markInsightAccepted(MarkInsightAcceptedRequest request) {
    return markInsightAcceptedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Insight State as Accepted. Users can use this method to indicate to the Recommender
   * API that they have applied some action based on the insight. This stops the insight content
   * from being updated.
   *
   * <p>MarkInsightAccepted can be applied to insights in ACTIVE state. Requires the
   * recommender.&#42;.update IAM permission for the specified insight.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<MarkInsightAcceptedRequest, Insight> markInsightAcceptedCallable() {
    return stub.markInsightAcceptedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists recommendations for a Cloud project. Requires the recommender.&#42;.list IAM permission
   * for the specified recommender.
   *
   * @param parent Required. The container resource on which to execute the request. Acceptable
   *     formats:
   *     <p>1. "projects/[PROJECT_NUMBER]/locations/[LOCATION]/recommenders/[RECOMMENDER_ID]",
   *     <p>LOCATION here refers to GCP Locations: https://cloud.google.com/about/locations/
   *     RECOMMENDER_ID refers to supported recommenders:
   *     https://cloud.google.com/recommender/docs/recommenders.
   * @param filter Filter expression to restrict the recommendations returned. Supported filter
   *     fields: state_info.state Eg: `state_info.state:"DISMISSED" or state_info.state:"FAILED"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecommendationsPagedResponse listRecommendations(
      RecommenderName parent, String filter) {
    ListRecommendationsRequest request =
        ListRecommendationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listRecommendations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists recommendations for a Cloud project. Requires the recommender.&#42;.list IAM permission
   * for the specified recommender.
   *
   * @param parent Required. The container resource on which to execute the request. Acceptable
   *     formats:
   *     <p>1. "projects/[PROJECT_NUMBER]/locations/[LOCATION]/recommenders/[RECOMMENDER_ID]",
   *     <p>LOCATION here refers to GCP Locations: https://cloud.google.com/about/locations/
   *     RECOMMENDER_ID refers to supported recommenders:
   *     https://cloud.google.com/recommender/docs/recommenders.
   * @param filter Filter expression to restrict the recommendations returned. Supported filter
   *     fields: state_info.state Eg: `state_info.state:"DISMISSED" or state_info.state:"FAILED"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecommendationsPagedResponse listRecommendations(String parent, String filter) {
    ListRecommendationsRequest request =
        ListRecommendationsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listRecommendations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists recommendations for a Cloud project. Requires the recommender.&#42;.list IAM permission
   * for the specified recommender.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecommendationsPagedResponse listRecommendations(
      ListRecommendationsRequest request) {
    return listRecommendationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists recommendations for a Cloud project. Requires the recommender.&#42;.list IAM permission
   * for the specified recommender.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListRecommendationsRequest, ListRecommendationsPagedResponse>
      listRecommendationsPagedCallable() {
    return stub.listRecommendationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists recommendations for a Cloud project. Requires the recommender.&#42;.list IAM permission
   * for the specified recommender.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListRecommendationsRequest, ListRecommendationsResponse>
      listRecommendationsCallable() {
    return stub.listRecommendationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the requested recommendation. Requires the recommender.&#42;.get IAM permission for the
   * specified recommender.
   *
   * @param name Required. Name of the recommendation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation getRecommendation(RecommendationName name) {
    GetRecommendationRequest request =
        GetRecommendationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRecommendation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the requested recommendation. Requires the recommender.&#42;.get IAM permission for the
   * specified recommender.
   *
   * @param name Required. Name of the recommendation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation getRecommendation(String name) {
    GetRecommendationRequest request = GetRecommendationRequest.newBuilder().setName(name).build();
    return getRecommendation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the requested recommendation. Requires the recommender.&#42;.get IAM permission for the
   * specified recommender.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation getRecommendation(GetRecommendationRequest request) {
    return getRecommendationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the requested recommendation. Requires the recommender.&#42;.get IAM permission for the
   * specified recommender.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetRecommendationRequest, Recommendation> getRecommendationCallable() {
    return stub.getRecommendationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Claimed. Users can use this method to indicate to the
   * Recommender API that they are starting to apply the recommendation themselves. This stops the
   * recommendation content from being updated. Associated insights are frozen and placed in the
   * ACCEPTED state.
   *
   * <p>MarkRecommendationClaimed can be applied to recommendations in CLAIMED or ACTIVE state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param name Required. Name of the recommendation.
   * @param stateMetadata State properties to include with this state. Overwrites any existing
   *     `state_metadata`. Keys must match the regex /^[a-z0-9][a-z0-9_.-]{0,62}$/. Values must
   *     match the regex /^[a-zA-Z0-9_./-]{0,255}$/.
   * @param etag Required. Fingerprint of the Recommendation. Provides optimistic locking.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationClaimed(
      RecommendationName name, Map<String, String> stateMetadata, String etag) {
    MarkRecommendationClaimedRequest request =
        MarkRecommendationClaimedRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .putAllStateMetadata(stateMetadata)
            .setEtag(etag)
            .build();
    return markRecommendationClaimed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Claimed. Users can use this method to indicate to the
   * Recommender API that they are starting to apply the recommendation themselves. This stops the
   * recommendation content from being updated. Associated insights are frozen and placed in the
   * ACCEPTED state.
   *
   * <p>MarkRecommendationClaimed can be applied to recommendations in CLAIMED or ACTIVE state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param name Required. Name of the recommendation.
   * @param stateMetadata State properties to include with this state. Overwrites any existing
   *     `state_metadata`. Keys must match the regex /^[a-z0-9][a-z0-9_.-]{0,62}$/. Values must
   *     match the regex /^[a-zA-Z0-9_./-]{0,255}$/.
   * @param etag Required. Fingerprint of the Recommendation. Provides optimistic locking.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationClaimed(
      String name, Map<String, String> stateMetadata, String etag) {
    MarkRecommendationClaimedRequest request =
        MarkRecommendationClaimedRequest.newBuilder()
            .setName(name)
            .putAllStateMetadata(stateMetadata)
            .setEtag(etag)
            .build();
    return markRecommendationClaimed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Claimed. Users can use this method to indicate to the
   * Recommender API that they are starting to apply the recommendation themselves. This stops the
   * recommendation content from being updated. Associated insights are frozen and placed in the
   * ACCEPTED state.
   *
   * <p>MarkRecommendationClaimed can be applied to recommendations in CLAIMED or ACTIVE state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationClaimed(MarkRecommendationClaimedRequest request) {
    return markRecommendationClaimedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Claimed. Users can use this method to indicate to the
   * Recommender API that they are starting to apply the recommendation themselves. This stops the
   * recommendation content from being updated. Associated insights are frozen and placed in the
   * ACCEPTED state.
   *
   * <p>MarkRecommendationClaimed can be applied to recommendations in CLAIMED or ACTIVE state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<MarkRecommendationClaimedRequest, Recommendation>
      markRecommendationClaimedCallable() {
    return stub.markRecommendationClaimedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Succeeded. Users can use this method to indicate to the
   * Recommender API that they have applied the recommendation themselves, and the operation was
   * successful. This stops the recommendation content from being updated. Associated insights are
   * frozen and placed in the ACCEPTED state.
   *
   * <p>MarkRecommendationSucceeded can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED,
   * or FAILED state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param name Required. Name of the recommendation.
   * @param stateMetadata State properties to include with this state. Overwrites any existing
   *     `state_metadata`. Keys must match the regex /^[a-z0-9][a-z0-9_.-]{0,62}$/. Values must
   *     match the regex /^[a-zA-Z0-9_./-]{0,255}$/.
   * @param etag Required. Fingerprint of the Recommendation. Provides optimistic locking.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationSucceeded(
      RecommendationName name, Map<String, String> stateMetadata, String etag) {
    MarkRecommendationSucceededRequest request =
        MarkRecommendationSucceededRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .putAllStateMetadata(stateMetadata)
            .setEtag(etag)
            .build();
    return markRecommendationSucceeded(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Succeeded. Users can use this method to indicate to the
   * Recommender API that they have applied the recommendation themselves, and the operation was
   * successful. This stops the recommendation content from being updated. Associated insights are
   * frozen and placed in the ACCEPTED state.
   *
   * <p>MarkRecommendationSucceeded can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED,
   * or FAILED state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param name Required. Name of the recommendation.
   * @param stateMetadata State properties to include with this state. Overwrites any existing
   *     `state_metadata`. Keys must match the regex /^[a-z0-9][a-z0-9_.-]{0,62}$/. Values must
   *     match the regex /^[a-zA-Z0-9_./-]{0,255}$/.
   * @param etag Required. Fingerprint of the Recommendation. Provides optimistic locking.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationSucceeded(
      String name, Map<String, String> stateMetadata, String etag) {
    MarkRecommendationSucceededRequest request =
        MarkRecommendationSucceededRequest.newBuilder()
            .setName(name)
            .putAllStateMetadata(stateMetadata)
            .setEtag(etag)
            .build();
    return markRecommendationSucceeded(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Succeeded. Users can use this method to indicate to the
   * Recommender API that they have applied the recommendation themselves, and the operation was
   * successful. This stops the recommendation content from being updated. Associated insights are
   * frozen and placed in the ACCEPTED state.
   *
   * <p>MarkRecommendationSucceeded can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED,
   * or FAILED state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationSucceeded(
      MarkRecommendationSucceededRequest request) {
    return markRecommendationSucceededCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Succeeded. Users can use this method to indicate to the
   * Recommender API that they have applied the recommendation themselves, and the operation was
   * successful. This stops the recommendation content from being updated. Associated insights are
   * frozen and placed in the ACCEPTED state.
   *
   * <p>MarkRecommendationSucceeded can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED,
   * or FAILED state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<MarkRecommendationSucceededRequest, Recommendation>
      markRecommendationSucceededCallable() {
    return stub.markRecommendationSucceededCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Failed. Users can use this method to indicate to the
   * Recommender API that they have applied the recommendation themselves, and the operation failed.
   * This stops the recommendation content from being updated. Associated insights are frozen and
   * placed in the ACCEPTED state.
   *
   * <p>MarkRecommendationFailed can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED, or
   * FAILED state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param name Required. Name of the recommendation.
   * @param stateMetadata State properties to include with this state. Overwrites any existing
   *     `state_metadata`. Keys must match the regex /^[a-z0-9][a-z0-9_.-]{0,62}$/. Values must
   *     match the regex /^[a-zA-Z0-9_./-]{0,255}$/.
   * @param etag Required. Fingerprint of the Recommendation. Provides optimistic locking.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationFailed(
      RecommendationName name, Map<String, String> stateMetadata, String etag) {
    MarkRecommendationFailedRequest request =
        MarkRecommendationFailedRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .putAllStateMetadata(stateMetadata)
            .setEtag(etag)
            .build();
    return markRecommendationFailed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Failed. Users can use this method to indicate to the
   * Recommender API that they have applied the recommendation themselves, and the operation failed.
   * This stops the recommendation content from being updated. Associated insights are frozen and
   * placed in the ACCEPTED state.
   *
   * <p>MarkRecommendationFailed can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED, or
   * FAILED state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param name Required. Name of the recommendation.
   * @param stateMetadata State properties to include with this state. Overwrites any existing
   *     `state_metadata`. Keys must match the regex /^[a-z0-9][a-z0-9_.-]{0,62}$/. Values must
   *     match the regex /^[a-zA-Z0-9_./-]{0,255}$/.
   * @param etag Required. Fingerprint of the Recommendation. Provides optimistic locking.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationFailed(
      String name, Map<String, String> stateMetadata, String etag) {
    MarkRecommendationFailedRequest request =
        MarkRecommendationFailedRequest.newBuilder()
            .setName(name)
            .putAllStateMetadata(stateMetadata)
            .setEtag(etag)
            .build();
    return markRecommendationFailed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Failed. Users can use this method to indicate to the
   * Recommender API that they have applied the recommendation themselves, and the operation failed.
   * This stops the recommendation content from being updated. Associated insights are frozen and
   * placed in the ACCEPTED state.
   *
   * <p>MarkRecommendationFailed can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED, or
   * FAILED state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recommendation markRecommendationFailed(MarkRecommendationFailedRequest request) {
    return markRecommendationFailedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks the Recommendation State as Failed. Users can use this method to indicate to the
   * Recommender API that they have applied the recommendation themselves, and the operation failed.
   * This stops the recommendation content from being updated. Associated insights are frozen and
   * placed in the ACCEPTED state.
   *
   * <p>MarkRecommendationFailed can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED, or
   * FAILED state.
   *
   * <p>Requires the recommender.&#42;.update IAM permission for the specified recommender.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<MarkRecommendationFailedRequest, Recommendation>
      markRecommendationFailedCallable() {
    return stub.markRecommendationFailedCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListInsightsPagedResponse
      extends AbstractPagedListResponse<
          ListInsightsRequest,
          ListInsightsResponse,
          Insight,
          ListInsightsPage,
          ListInsightsFixedSizeCollection> {

    public static ApiFuture<ListInsightsPagedResponse> createAsync(
        PageContext<ListInsightsRequest, ListInsightsResponse, Insight> context,
        ApiFuture<ListInsightsResponse> futureResponse) {
      ApiFuture<ListInsightsPage> futurePage =
          ListInsightsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInsightsPage, ListInsightsPagedResponse>() {
            @Override
            public ListInsightsPagedResponse apply(ListInsightsPage input) {
              return new ListInsightsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInsightsPagedResponse(ListInsightsPage page) {
      super(page, ListInsightsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInsightsPage
      extends AbstractPage<ListInsightsRequest, ListInsightsResponse, Insight, ListInsightsPage> {

    private ListInsightsPage(
        PageContext<ListInsightsRequest, ListInsightsResponse, Insight> context,
        ListInsightsResponse response) {
      super(context, response);
    }

    private static ListInsightsPage createEmptyPage() {
      return new ListInsightsPage(null, null);
    }

    @Override
    protected ListInsightsPage createPage(
        PageContext<ListInsightsRequest, ListInsightsResponse, Insight> context,
        ListInsightsResponse response) {
      return new ListInsightsPage(context, response);
    }

    @Override
    public ApiFuture<ListInsightsPage> createPageAsync(
        PageContext<ListInsightsRequest, ListInsightsResponse, Insight> context,
        ApiFuture<ListInsightsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInsightsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInsightsRequest,
          ListInsightsResponse,
          Insight,
          ListInsightsPage,
          ListInsightsFixedSizeCollection> {

    private ListInsightsFixedSizeCollection(List<ListInsightsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInsightsFixedSizeCollection createEmptyCollection() {
      return new ListInsightsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInsightsFixedSizeCollection createCollection(
        List<ListInsightsPage> pages, int collectionSize) {
      return new ListInsightsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRecommendationsPagedResponse
      extends AbstractPagedListResponse<
          ListRecommendationsRequest,
          ListRecommendationsResponse,
          Recommendation,
          ListRecommendationsPage,
          ListRecommendationsFixedSizeCollection> {

    public static ApiFuture<ListRecommendationsPagedResponse> createAsync(
        PageContext<ListRecommendationsRequest, ListRecommendationsResponse, Recommendation>
            context,
        ApiFuture<ListRecommendationsResponse> futureResponse) {
      ApiFuture<ListRecommendationsPage> futurePage =
          ListRecommendationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRecommendationsPage, ListRecommendationsPagedResponse>() {
            @Override
            public ListRecommendationsPagedResponse apply(ListRecommendationsPage input) {
              return new ListRecommendationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRecommendationsPagedResponse(ListRecommendationsPage page) {
      super(page, ListRecommendationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRecommendationsPage
      extends AbstractPage<
          ListRecommendationsRequest,
          ListRecommendationsResponse,
          Recommendation,
          ListRecommendationsPage> {

    private ListRecommendationsPage(
        PageContext<ListRecommendationsRequest, ListRecommendationsResponse, Recommendation>
            context,
        ListRecommendationsResponse response) {
      super(context, response);
    }

    private static ListRecommendationsPage createEmptyPage() {
      return new ListRecommendationsPage(null, null);
    }

    @Override
    protected ListRecommendationsPage createPage(
        PageContext<ListRecommendationsRequest, ListRecommendationsResponse, Recommendation>
            context,
        ListRecommendationsResponse response) {
      return new ListRecommendationsPage(context, response);
    }

    @Override
    public ApiFuture<ListRecommendationsPage> createPageAsync(
        PageContext<ListRecommendationsRequest, ListRecommendationsResponse, Recommendation>
            context,
        ApiFuture<ListRecommendationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRecommendationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRecommendationsRequest,
          ListRecommendationsResponse,
          Recommendation,
          ListRecommendationsPage,
          ListRecommendationsFixedSizeCollection> {

    private ListRecommendationsFixedSizeCollection(
        List<ListRecommendationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRecommendationsFixedSizeCollection createEmptyCollection() {
      return new ListRecommendationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRecommendationsFixedSizeCollection createCollection(
        List<ListRecommendationsPage> pages, int collectionSize) {
      return new ListRecommendationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
