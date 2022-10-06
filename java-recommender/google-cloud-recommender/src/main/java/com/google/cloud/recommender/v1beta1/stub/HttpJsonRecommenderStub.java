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

package com.google.cloud.recommender.v1beta1.stub;

import static com.google.cloud.recommender.v1beta1.RecommenderClient.ListInsightsPagedResponse;
import static com.google.cloud.recommender.v1beta1.RecommenderClient.ListRecommendationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommender.v1beta1.GetInsightRequest;
import com.google.cloud.recommender.v1beta1.GetInsightTypeConfigRequest;
import com.google.cloud.recommender.v1beta1.GetRecommendationRequest;
import com.google.cloud.recommender.v1beta1.GetRecommenderConfigRequest;
import com.google.cloud.recommender.v1beta1.Insight;
import com.google.cloud.recommender.v1beta1.InsightTypeConfig;
import com.google.cloud.recommender.v1beta1.ListInsightsRequest;
import com.google.cloud.recommender.v1beta1.ListInsightsResponse;
import com.google.cloud.recommender.v1beta1.ListRecommendationsRequest;
import com.google.cloud.recommender.v1beta1.ListRecommendationsResponse;
import com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest;
import com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest;
import com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest;
import com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest;
import com.google.cloud.recommender.v1beta1.Recommendation;
import com.google.cloud.recommender.v1beta1.RecommenderConfig;
import com.google.cloud.recommender.v1beta1.UpdateInsightTypeConfigRequest;
import com.google.cloud.recommender.v1beta1.UpdateRecommenderConfigRequest;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Recommender service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonRecommenderStub extends RecommenderStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListInsightsRequest, ListInsightsResponse>
      listInsightsMethodDescriptor =
          ApiMethodDescriptor.<ListInsightsRequest, ListInsightsResponse>newBuilder()
              .setFullMethodName("google.cloud.recommender.v1beta1.Recommender/ListInsights")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInsightsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/insightTypes/*}/insights",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInsightsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{parent=billingAccounts/*/locations/*/insightTypes/*}/insights",
                          "/v1beta1/{parent=folders/*/locations/*/insightTypes/*}/insights",
                          "/v1beta1/{parent=organizations/*/locations/*/insightTypes/*}/insights")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInsightsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListInsightsResponse>newBuilder()
                      .setDefaultInstance(ListInsightsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInsightRequest, Insight> getInsightMethodDescriptor =
      ApiMethodDescriptor.<GetInsightRequest, Insight>newBuilder()
          .setFullMethodName("google.cloud.recommender.v1beta1.Recommender/GetInsight")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetInsightRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/insightTypes/*/insights/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetInsightRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1beta1/{name=billingAccounts/*/locations/*/insightTypes/*/insights/*}",
                      "/v1beta1/{name=folders/*/locations/*/insightTypes/*/insights/*}",
                      "/v1beta1/{name=organizations/*/locations/*/insightTypes/*/insights/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetInsightRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Insight>newBuilder()
                  .setDefaultInstance(Insight.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<MarkInsightAcceptedRequest, Insight>
      markInsightAcceptedMethodDescriptor =
          ApiMethodDescriptor.<MarkInsightAcceptedRequest, Insight>newBuilder()
              .setFullMethodName("google.cloud.recommender.v1beta1.Recommender/MarkInsightAccepted")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MarkInsightAcceptedRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/insightTypes/*/insights/*}:markAccepted",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MarkInsightAcceptedRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{name=billingAccounts/*/locations/*/insightTypes/*/insights/*}:markAccepted",
                          "/v1beta1/{name=folders/*/locations/*/insightTypes/*/insights/*}:markAccepted",
                          "/v1beta1/{name=organizations/*/locations/*/insightTypes/*/insights/*}:markAccepted")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MarkInsightAcceptedRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Insight>newBuilder()
                      .setDefaultInstance(Insight.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRecommendationsRequest, ListRecommendationsResponse>
      listRecommendationsMethodDescriptor =
          ApiMethodDescriptor.<ListRecommendationsRequest, ListRecommendationsResponse>newBuilder()
              .setFullMethodName("google.cloud.recommender.v1beta1.Recommender/ListRecommendations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRecommendationsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/recommenders/*}/recommendations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRecommendationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{parent=billingAccounts/*/locations/*/recommenders/*}/recommendations",
                          "/v1beta1/{parent=folders/*/locations/*/recommenders/*}/recommendations",
                          "/v1beta1/{parent=organizations/*/locations/*/recommenders/*}/recommendations")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRecommendationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRecommendationsResponse>newBuilder()
                      .setDefaultInstance(ListRecommendationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRecommendationRequest, Recommendation>
      getRecommendationMethodDescriptor =
          ApiMethodDescriptor.<GetRecommendationRequest, Recommendation>newBuilder()
              .setFullMethodName("google.cloud.recommender.v1beta1.Recommender/GetRecommendation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRecommendationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/recommenders/*/recommendations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecommendationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{name=billingAccounts/*/locations/*/recommenders/*/recommendations/*}",
                          "/v1beta1/{name=folders/*/locations/*/recommenders/*/recommendations/*}",
                          "/v1beta1/{name=organizations/*/locations/*/recommenders/*/recommendations/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecommendationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Recommendation>newBuilder()
                      .setDefaultInstance(Recommendation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MarkRecommendationClaimedRequest, Recommendation>
      markRecommendationClaimedMethodDescriptor =
          ApiMethodDescriptor.<MarkRecommendationClaimedRequest, Recommendation>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommender.v1beta1.Recommender/MarkRecommendationClaimed")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MarkRecommendationClaimedRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/recommenders/*/recommendations/*}:markClaimed",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MarkRecommendationClaimedRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{name=billingAccounts/*/locations/*/recommenders/*/recommendations/*}:markClaimed",
                          "/v1beta1/{name=folders/*/locations/*/recommenders/*/recommendations/*}:markClaimed",
                          "/v1beta1/{name=organizations/*/locations/*/recommenders/*/recommendations/*}:markClaimed")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MarkRecommendationClaimedRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Recommendation>newBuilder()
                      .setDefaultInstance(Recommendation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MarkRecommendationSucceededRequest, Recommendation>
      markRecommendationSucceededMethodDescriptor =
          ApiMethodDescriptor.<MarkRecommendationSucceededRequest, Recommendation>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommender.v1beta1.Recommender/MarkRecommendationSucceeded")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MarkRecommendationSucceededRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/recommenders/*/recommendations/*}:markSucceeded",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MarkRecommendationSucceededRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{name=billingAccounts/*/locations/*/recommenders/*/recommendations/*}:markSucceeded",
                          "/v1beta1/{name=folders/*/locations/*/recommenders/*/recommendations/*}:markSucceeded",
                          "/v1beta1/{name=organizations/*/locations/*/recommenders/*/recommendations/*}:markSucceeded")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MarkRecommendationSucceededRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Recommendation>newBuilder()
                      .setDefaultInstance(Recommendation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<MarkRecommendationFailedRequest, Recommendation>
      markRecommendationFailedMethodDescriptor =
          ApiMethodDescriptor.<MarkRecommendationFailedRequest, Recommendation>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommender.v1beta1.Recommender/MarkRecommendationFailed")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MarkRecommendationFailedRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/recommenders/*/recommendations/*}:markFailed",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MarkRecommendationFailedRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{name=billingAccounts/*/locations/*/recommenders/*/recommendations/*}:markFailed",
                          "/v1beta1/{name=folders/*/locations/*/recommenders/*/recommendations/*}:markFailed",
                          "/v1beta1/{name=organizations/*/locations/*/recommenders/*/recommendations/*}:markFailed")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MarkRecommendationFailedRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Recommendation>newBuilder()
                      .setDefaultInstance(Recommendation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRecommenderConfigRequest, RecommenderConfig>
      getRecommenderConfigMethodDescriptor =
          ApiMethodDescriptor.<GetRecommenderConfigRequest, RecommenderConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommender.v1beta1.Recommender/GetRecommenderConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRecommenderConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/recommenders/*/config}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecommenderConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{name=organizations/*/locations/*/recommenders/*/config}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecommenderConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RecommenderConfig>newBuilder()
                      .setDefaultInstance(RecommenderConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRecommenderConfigRequest, RecommenderConfig>
      updateRecommenderConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateRecommenderConfigRequest, RecommenderConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommender.v1beta1.Recommender/UpdateRecommenderConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRecommenderConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{recommenderConfig.name=projects/*/locations/*/recommenders/*/config}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRecommenderConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "recommenderConfig.name",
                                request.getRecommenderConfig().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{recommenderConfig.name=organizations/*/locations/*/recommenders/*/config}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRecommenderConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "recommenderConfig", request.getRecommenderConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RecommenderConfig>newBuilder()
                      .setDefaultInstance(RecommenderConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInsightTypeConfigRequest, InsightTypeConfig>
      getInsightTypeConfigMethodDescriptor =
          ApiMethodDescriptor.<GetInsightTypeConfigRequest, InsightTypeConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommender.v1beta1.Recommender/GetInsightTypeConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInsightTypeConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/insightTypes/*/config}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInsightTypeConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{name=organizations/*/locations/*/insightTypes/*/config}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInsightTypeConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InsightTypeConfig>newBuilder()
                      .setDefaultInstance(InsightTypeConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateInsightTypeConfigRequest, InsightTypeConfig>
      updateInsightTypeConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateInsightTypeConfigRequest, InsightTypeConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.recommender.v1beta1.Recommender/UpdateInsightTypeConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInsightTypeConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{insightTypeConfig.name=projects/*/locations/*/insightTypes/*/config}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInsightTypeConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "insightTypeConfig.name",
                                request.getInsightTypeConfig().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{insightTypeConfig.name=organizations/*/locations/*/insightTypes/*/config}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInsightTypeConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "insightTypeConfig", request.getInsightTypeConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InsightTypeConfig>newBuilder()
                      .setDefaultInstance(InsightTypeConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListInsightsRequest, ListInsightsResponse> listInsightsCallable;
  private final UnaryCallable<ListInsightsRequest, ListInsightsPagedResponse>
      listInsightsPagedCallable;
  private final UnaryCallable<GetInsightRequest, Insight> getInsightCallable;
  private final UnaryCallable<MarkInsightAcceptedRequest, Insight> markInsightAcceptedCallable;
  private final UnaryCallable<ListRecommendationsRequest, ListRecommendationsResponse>
      listRecommendationsCallable;
  private final UnaryCallable<ListRecommendationsRequest, ListRecommendationsPagedResponse>
      listRecommendationsPagedCallable;
  private final UnaryCallable<GetRecommendationRequest, Recommendation> getRecommendationCallable;
  private final UnaryCallable<MarkRecommendationClaimedRequest, Recommendation>
      markRecommendationClaimedCallable;
  private final UnaryCallable<MarkRecommendationSucceededRequest, Recommendation>
      markRecommendationSucceededCallable;
  private final UnaryCallable<MarkRecommendationFailedRequest, Recommendation>
      markRecommendationFailedCallable;
  private final UnaryCallable<GetRecommenderConfigRequest, RecommenderConfig>
      getRecommenderConfigCallable;
  private final UnaryCallable<UpdateRecommenderConfigRequest, RecommenderConfig>
      updateRecommenderConfigCallable;
  private final UnaryCallable<GetInsightTypeConfigRequest, InsightTypeConfig>
      getInsightTypeConfigCallable;
  private final UnaryCallable<UpdateInsightTypeConfigRequest, InsightTypeConfig>
      updateInsightTypeConfigCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRecommenderStub create(RecommenderStubSettings settings)
      throws IOException {
    return new HttpJsonRecommenderStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRecommenderStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRecommenderStub(
        RecommenderStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRecommenderStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRecommenderStub(
        RecommenderStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRecommenderStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRecommenderStub(RecommenderStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRecommenderCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRecommenderStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRecommenderStub(
      RecommenderStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListInsightsRequest, ListInsightsResponse> listInsightsTransportSettings =
        HttpJsonCallSettings.<ListInsightsRequest, ListInsightsResponse>newBuilder()
            .setMethodDescriptor(listInsightsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetInsightRequest, Insight> getInsightTransportSettings =
        HttpJsonCallSettings.<GetInsightRequest, Insight>newBuilder()
            .setMethodDescriptor(getInsightMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<MarkInsightAcceptedRequest, Insight> markInsightAcceptedTransportSettings =
        HttpJsonCallSettings.<MarkInsightAcceptedRequest, Insight>newBuilder()
            .setMethodDescriptor(markInsightAcceptedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRecommendationsRequest, ListRecommendationsResponse>
        listRecommendationsTransportSettings =
            HttpJsonCallSettings
                .<ListRecommendationsRequest, ListRecommendationsResponse>newBuilder()
                .setMethodDescriptor(listRecommendationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRecommendationRequest, Recommendation>
        getRecommendationTransportSettings =
            HttpJsonCallSettings.<GetRecommendationRequest, Recommendation>newBuilder()
                .setMethodDescriptor(getRecommendationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<MarkRecommendationClaimedRequest, Recommendation>
        markRecommendationClaimedTransportSettings =
            HttpJsonCallSettings.<MarkRecommendationClaimedRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationClaimedMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<MarkRecommendationSucceededRequest, Recommendation>
        markRecommendationSucceededTransportSettings =
            HttpJsonCallSettings.<MarkRecommendationSucceededRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationSucceededMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<MarkRecommendationFailedRequest, Recommendation>
        markRecommendationFailedTransportSettings =
            HttpJsonCallSettings.<MarkRecommendationFailedRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationFailedMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRecommenderConfigRequest, RecommenderConfig>
        getRecommenderConfigTransportSettings =
            HttpJsonCallSettings.<GetRecommenderConfigRequest, RecommenderConfig>newBuilder()
                .setMethodDescriptor(getRecommenderConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateRecommenderConfigRequest, RecommenderConfig>
        updateRecommenderConfigTransportSettings =
            HttpJsonCallSettings.<UpdateRecommenderConfigRequest, RecommenderConfig>newBuilder()
                .setMethodDescriptor(updateRecommenderConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetInsightTypeConfigRequest, InsightTypeConfig>
        getInsightTypeConfigTransportSettings =
            HttpJsonCallSettings.<GetInsightTypeConfigRequest, InsightTypeConfig>newBuilder()
                .setMethodDescriptor(getInsightTypeConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateInsightTypeConfigRequest, InsightTypeConfig>
        updateInsightTypeConfigTransportSettings =
            HttpJsonCallSettings.<UpdateInsightTypeConfigRequest, InsightTypeConfig>newBuilder()
                .setMethodDescriptor(updateInsightTypeConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listInsightsCallable =
        callableFactory.createUnaryCallable(
            listInsightsTransportSettings, settings.listInsightsSettings(), clientContext);
    this.listInsightsPagedCallable =
        callableFactory.createPagedCallable(
            listInsightsTransportSettings, settings.listInsightsSettings(), clientContext);
    this.getInsightCallable =
        callableFactory.createUnaryCallable(
            getInsightTransportSettings, settings.getInsightSettings(), clientContext);
    this.markInsightAcceptedCallable =
        callableFactory.createUnaryCallable(
            markInsightAcceptedTransportSettings,
            settings.markInsightAcceptedSettings(),
            clientContext);
    this.listRecommendationsCallable =
        callableFactory.createUnaryCallable(
            listRecommendationsTransportSettings,
            settings.listRecommendationsSettings(),
            clientContext);
    this.listRecommendationsPagedCallable =
        callableFactory.createPagedCallable(
            listRecommendationsTransportSettings,
            settings.listRecommendationsSettings(),
            clientContext);
    this.getRecommendationCallable =
        callableFactory.createUnaryCallable(
            getRecommendationTransportSettings,
            settings.getRecommendationSettings(),
            clientContext);
    this.markRecommendationClaimedCallable =
        callableFactory.createUnaryCallable(
            markRecommendationClaimedTransportSettings,
            settings.markRecommendationClaimedSettings(),
            clientContext);
    this.markRecommendationSucceededCallable =
        callableFactory.createUnaryCallable(
            markRecommendationSucceededTransportSettings,
            settings.markRecommendationSucceededSettings(),
            clientContext);
    this.markRecommendationFailedCallable =
        callableFactory.createUnaryCallable(
            markRecommendationFailedTransportSettings,
            settings.markRecommendationFailedSettings(),
            clientContext);
    this.getRecommenderConfigCallable =
        callableFactory.createUnaryCallable(
            getRecommenderConfigTransportSettings,
            settings.getRecommenderConfigSettings(),
            clientContext);
    this.updateRecommenderConfigCallable =
        callableFactory.createUnaryCallable(
            updateRecommenderConfigTransportSettings,
            settings.updateRecommenderConfigSettings(),
            clientContext);
    this.getInsightTypeConfigCallable =
        callableFactory.createUnaryCallable(
            getInsightTypeConfigTransportSettings,
            settings.getInsightTypeConfigSettings(),
            clientContext);
    this.updateInsightTypeConfigCallable =
        callableFactory.createUnaryCallable(
            updateInsightTypeConfigTransportSettings,
            settings.updateInsightTypeConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listInsightsMethodDescriptor);
    methodDescriptors.add(getInsightMethodDescriptor);
    methodDescriptors.add(markInsightAcceptedMethodDescriptor);
    methodDescriptors.add(listRecommendationsMethodDescriptor);
    methodDescriptors.add(getRecommendationMethodDescriptor);
    methodDescriptors.add(markRecommendationClaimedMethodDescriptor);
    methodDescriptors.add(markRecommendationSucceededMethodDescriptor);
    methodDescriptors.add(markRecommendationFailedMethodDescriptor);
    methodDescriptors.add(getRecommenderConfigMethodDescriptor);
    methodDescriptors.add(updateRecommenderConfigMethodDescriptor);
    methodDescriptors.add(getInsightTypeConfigMethodDescriptor);
    methodDescriptors.add(updateInsightTypeConfigMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListInsightsRequest, ListInsightsResponse> listInsightsCallable() {
    return listInsightsCallable;
  }

  @Override
  public UnaryCallable<ListInsightsRequest, ListInsightsPagedResponse> listInsightsPagedCallable() {
    return listInsightsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInsightRequest, Insight> getInsightCallable() {
    return getInsightCallable;
  }

  @Override
  public UnaryCallable<MarkInsightAcceptedRequest, Insight> markInsightAcceptedCallable() {
    return markInsightAcceptedCallable;
  }

  @Override
  public UnaryCallable<ListRecommendationsRequest, ListRecommendationsResponse>
      listRecommendationsCallable() {
    return listRecommendationsCallable;
  }

  @Override
  public UnaryCallable<ListRecommendationsRequest, ListRecommendationsPagedResponse>
      listRecommendationsPagedCallable() {
    return listRecommendationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRecommendationRequest, Recommendation> getRecommendationCallable() {
    return getRecommendationCallable;
  }

  @Override
  public UnaryCallable<MarkRecommendationClaimedRequest, Recommendation>
      markRecommendationClaimedCallable() {
    return markRecommendationClaimedCallable;
  }

  @Override
  public UnaryCallable<MarkRecommendationSucceededRequest, Recommendation>
      markRecommendationSucceededCallable() {
    return markRecommendationSucceededCallable;
  }

  @Override
  public UnaryCallable<MarkRecommendationFailedRequest, Recommendation>
      markRecommendationFailedCallable() {
    return markRecommendationFailedCallable;
  }

  @Override
  public UnaryCallable<GetRecommenderConfigRequest, RecommenderConfig>
      getRecommenderConfigCallable() {
    return getRecommenderConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateRecommenderConfigRequest, RecommenderConfig>
      updateRecommenderConfigCallable() {
    return updateRecommenderConfigCallable;
  }

  @Override
  public UnaryCallable<GetInsightTypeConfigRequest, InsightTypeConfig>
      getInsightTypeConfigCallable() {
    return getInsightTypeConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateInsightTypeConfigRequest, InsightTypeConfig>
      updateInsightTypeConfigCallable() {
    return updateInsightTypeConfigCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
