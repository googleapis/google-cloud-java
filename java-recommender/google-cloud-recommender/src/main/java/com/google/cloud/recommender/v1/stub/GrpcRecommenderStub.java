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
package com.google.cloud.recommender.v1.stub;

import static com.google.cloud.recommender.v1.RecommenderClient.ListRecommendationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommender.v1.GetRecommendationRequest;
import com.google.cloud.recommender.v1.ListRecommendationsRequest;
import com.google.cloud.recommender.v1.ListRecommendationsResponse;
import com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest;
import com.google.cloud.recommender.v1.MarkRecommendationFailedRequest;
import com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest;
import com.google.cloud.recommender.v1.Recommendation;
import com.google.common.collect.ImmutableMap;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Recommender API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcRecommenderStub extends RecommenderStub {

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

  private final BackgroundResource backgroundResources;

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

    GrpcCallSettings<ListRecommendationsRequest, ListRecommendationsResponse>
        listRecommendationsTransportSettings =
            GrpcCallSettings.<ListRecommendationsRequest, ListRecommendationsResponse>newBuilder()
                .setMethodDescriptor(listRecommendationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListRecommendationsRequest>() {
                      @Override
                      public Map<String, String> extract(ListRecommendationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetRecommendationRequest, Recommendation> getRecommendationTransportSettings =
        GrpcCallSettings.<GetRecommendationRequest, Recommendation>newBuilder()
            .setMethodDescriptor(getRecommendationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetRecommendationRequest>() {
                  @Override
                  public Map<String, String> extract(GetRecommendationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<MarkRecommendationClaimedRequest, Recommendation>
        markRecommendationClaimedTransportSettings =
            GrpcCallSettings.<MarkRecommendationClaimedRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationClaimedMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<MarkRecommendationClaimedRequest>() {
                      @Override
                      public Map<String, String> extract(MarkRecommendationClaimedRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<MarkRecommendationSucceededRequest, Recommendation>
        markRecommendationSucceededTransportSettings =
            GrpcCallSettings.<MarkRecommendationSucceededRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationSucceededMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<MarkRecommendationSucceededRequest>() {
                      @Override
                      public Map<String, String> extract(
                          MarkRecommendationSucceededRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<MarkRecommendationFailedRequest, Recommendation>
        markRecommendationFailedTransportSettings =
            GrpcCallSettings.<MarkRecommendationFailedRequest, Recommendation>newBuilder()
                .setMethodDescriptor(markRecommendationFailedMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<MarkRecommendationFailedRequest>() {
                      @Override
                      public Map<String, String> extract(MarkRecommendationFailedRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();

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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ListRecommendationsRequest, ListRecommendationsPagedResponse>
      listRecommendationsPagedCallable() {
    return listRecommendationsPagedCallable;
  }

  public UnaryCallable<ListRecommendationsRequest, ListRecommendationsResponse>
      listRecommendationsCallable() {
    return listRecommendationsCallable;
  }

  public UnaryCallable<GetRecommendationRequest, Recommendation> getRecommendationCallable() {
    return getRecommendationCallable;
  }

  public UnaryCallable<MarkRecommendationClaimedRequest, Recommendation>
      markRecommendationClaimedCallable() {
    return markRecommendationClaimedCallable;
  }

  public UnaryCallable<MarkRecommendationSucceededRequest, Recommendation>
      markRecommendationSucceededCallable() {
    return markRecommendationSucceededCallable;
  }

  public UnaryCallable<MarkRecommendationFailedRequest, Recommendation>
      markRecommendationFailedCallable() {
    return markRecommendationFailedCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
