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

package com.google.cloud.recommender.v1.stub;

import static com.google.cloud.recommender.v1.RecommenderClient.ListInsightsPagedResponse;
import static com.google.cloud.recommender.v1.RecommenderClient.ListRecommendationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommender.v1.GetInsightRequest;
import com.google.cloud.recommender.v1.GetInsightTypeConfigRequest;
import com.google.cloud.recommender.v1.GetRecommendationRequest;
import com.google.cloud.recommender.v1.GetRecommenderConfigRequest;
import com.google.cloud.recommender.v1.Insight;
import com.google.cloud.recommender.v1.InsightTypeConfig;
import com.google.cloud.recommender.v1.ListInsightsRequest;
import com.google.cloud.recommender.v1.ListInsightsResponse;
import com.google.cloud.recommender.v1.ListRecommendationsRequest;
import com.google.cloud.recommender.v1.ListRecommendationsResponse;
import com.google.cloud.recommender.v1.MarkInsightAcceptedRequest;
import com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest;
import com.google.cloud.recommender.v1.MarkRecommendationFailedRequest;
import com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest;
import com.google.cloud.recommender.v1.Recommendation;
import com.google.cloud.recommender.v1.RecommenderConfig;
import com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest;
import com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Recommender service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRecommenderStub extends RecommenderStub {
  private static final MethodDescriptor<ListInsightsRequest, ListInsightsResponse>
      listInsightsMethodDescriptor =
          MethodDescriptor.<ListInsightsRequest, ListInsightsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/ListInsights")
              .setRequestMarshaller(ProtoUtils.marshaller(ListInsightsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInsightsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInsightRequest, Insight> getInsightMethodDescriptor =
      MethodDescriptor.<GetInsightRequest, Insight>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.recommender.v1.Recommender/GetInsight")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInsightRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Insight.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<MarkInsightAcceptedRequest, Insight>
      markInsightAcceptedMethodDescriptor =
          MethodDescriptor.<MarkInsightAcceptedRequest, Insight>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/MarkInsightAccepted")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MarkInsightAcceptedRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Insight.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRecommendationsRequest, ListRecommendationsResponse>
      listRecommendationsMethodDescriptor =
          MethodDescriptor.<ListRecommendationsRequest, ListRecommendationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/ListRecommendations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRecommendationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRecommendationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRecommendationRequest, Recommendation>
      getRecommendationMethodDescriptor =
          MethodDescriptor.<GetRecommendationRequest, Recommendation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/GetRecommendation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRecommendationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Recommendation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MarkRecommendationClaimedRequest, Recommendation>
      markRecommendationClaimedMethodDescriptor =
          MethodDescriptor.<MarkRecommendationClaimedRequest, Recommendation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommender.v1.Recommender/MarkRecommendationClaimed")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MarkRecommendationClaimedRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Recommendation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MarkRecommendationSucceededRequest, Recommendation>
      markRecommendationSucceededMethodDescriptor =
          MethodDescriptor.<MarkRecommendationSucceededRequest, Recommendation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommender.v1.Recommender/MarkRecommendationSucceeded")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MarkRecommendationSucceededRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Recommendation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MarkRecommendationFailedRequest, Recommendation>
      markRecommendationFailedMethodDescriptor =
          MethodDescriptor.<MarkRecommendationFailedRequest, Recommendation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/MarkRecommendationFailed")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MarkRecommendationFailedRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Recommendation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRecommenderConfigRequest, RecommenderConfig>
      getRecommenderConfigMethodDescriptor =
          MethodDescriptor.<GetRecommenderConfigRequest, RecommenderConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/GetRecommenderConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRecommenderConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RecommenderConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRecommenderConfigRequest, RecommenderConfig>
      updateRecommenderConfigMethodDescriptor =
          MethodDescriptor.<UpdateRecommenderConfigRequest, RecommenderConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/UpdateRecommenderConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRecommenderConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RecommenderConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInsightTypeConfigRequest, InsightTypeConfig>
      getInsightTypeConfigMethodDescriptor =
          MethodDescriptor.<GetInsightTypeConfigRequest, InsightTypeConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/GetInsightTypeConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInsightTypeConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InsightTypeConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateInsightTypeConfigRequest, InsightTypeConfig>
      updateInsightTypeConfigMethodDescriptor =
          MethodDescriptor.<UpdateInsightTypeConfigRequest, InsightTypeConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.recommender.v1.Recommender/UpdateInsightTypeConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInsightTypeConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InsightTypeConfig.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRecommenderStub create(RecommenderStubSettings settings)
      throws IOException {
    return new GrpcRecommenderStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRecommenderStub create(ClientContext clientContext) throws IOException {
    return new GrpcRecommenderStub(RecommenderStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRecommenderStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRecommenderStub(
        RecommenderStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRecommenderStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRecommenderStub(RecommenderStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRecommenderCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRecommenderStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRecommenderStub(
      RecommenderStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInsightsRequest, ListInsightsResponse> listInsightsTransportSettings =
        GrpcCallSettings.<ListInsightsRequest, ListInsightsResponse>newBuilder()
            .setMethodDescriptor(listInsightsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetInsightRequest, Insight> getInsightTransportSettings =
        GrpcCallSettings.<GetInsightRequest, Insight>newBuilder()
            .setMethodDescriptor(getInsightMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<MarkInsightAcceptedRequest, Insight> markInsightAcceptedTransportSettings =
        GrpcCallSettings.<MarkInsightAcceptedRequest, Insight>newBuilder()
            .setMethodDescriptor(markInsightAcceptedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListRecommendationsRequest, ListRecommendationsResponse>
        listRecommendationsTransportSettings =
            GrpcCallSettings.<ListRecommendationsRequest, ListRecommendationsResponse>newBuilder()
                .setMethodDescriptor(listRecommendationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetRecommendationRequest, Recommendation> getRecommendationTransportSettings =
        GrpcCallSettings.<GetRecommendationRequest, Recommendation>newBuilder()
            .setMethodDescriptor(getRecommendationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<MarkRecommendationClaimedRequest, Recommendation>
        markRecommendationClaimedTransportSettings =
            GrpcCallSettings.<MarkRecommendationClaimedRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationClaimedMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<MarkRecommendationSucceededRequest, Recommendation>
        markRecommendationSucceededTransportSettings =
            GrpcCallSettings.<MarkRecommendationSucceededRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationSucceededMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<MarkRecommendationFailedRequest, Recommendation>
        markRecommendationFailedTransportSettings =
            GrpcCallSettings.<MarkRecommendationFailedRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationFailedMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetRecommenderConfigRequest, RecommenderConfig>
        getRecommenderConfigTransportSettings =
            GrpcCallSettings.<GetRecommenderConfigRequest, RecommenderConfig>newBuilder()
                .setMethodDescriptor(getRecommenderConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateRecommenderConfigRequest, RecommenderConfig>
        updateRecommenderConfigTransportSettings =
            GrpcCallSettings.<UpdateRecommenderConfigRequest, RecommenderConfig>newBuilder()
                .setMethodDescriptor(updateRecommenderConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "recommender_config.name",
                          String.valueOf(request.getRecommenderConfig().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetInsightTypeConfigRequest, InsightTypeConfig>
        getInsightTypeConfigTransportSettings =
            GrpcCallSettings.<GetInsightTypeConfigRequest, InsightTypeConfig>newBuilder()
                .setMethodDescriptor(getInsightTypeConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateInsightTypeConfigRequest, InsightTypeConfig>
        updateInsightTypeConfigTransportSettings =
            GrpcCallSettings.<UpdateInsightTypeConfigRequest, InsightTypeConfig>newBuilder()
                .setMethodDescriptor(updateInsightTypeConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "insight_type_config.name",
                          String.valueOf(request.getInsightTypeConfig().getName()));
                      return params.build();
                    })
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
