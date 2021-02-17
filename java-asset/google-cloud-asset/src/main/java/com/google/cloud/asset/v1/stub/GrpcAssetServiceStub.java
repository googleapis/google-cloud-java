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

package com.google.cloud.asset.v1.stub;

import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningResponse;
import com.google.cloud.asset.v1.AnalyzeIamPolicyRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyResponse;
import com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest;
import com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse;
import com.google.cloud.asset.v1.CreateFeedRequest;
import com.google.cloud.asset.v1.DeleteFeedRequest;
import com.google.cloud.asset.v1.ExportAssetsRequest;
import com.google.cloud.asset.v1.ExportAssetsResponse;
import com.google.cloud.asset.v1.Feed;
import com.google.cloud.asset.v1.GetFeedRequest;
import com.google.cloud.asset.v1.ListFeedsRequest;
import com.google.cloud.asset.v1.ListFeedsResponse;
import com.google.cloud.asset.v1.SearchAllIamPoliciesRequest;
import com.google.cloud.asset.v1.SearchAllIamPoliciesResponse;
import com.google.cloud.asset.v1.SearchAllResourcesRequest;
import com.google.cloud.asset.v1.SearchAllResourcesResponse;
import com.google.cloud.asset.v1.UpdateFeedRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AssetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAssetServiceStub extends AssetServiceStub {
  private static final MethodDescriptor<ExportAssetsRequest, Operation>
      exportAssetsMethodDescriptor =
          MethodDescriptor.<ExportAssetsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/ExportAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(ExportAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistoryMethodDescriptor =
          MethodDescriptor.<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/BatchGetAssetsHistory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetAssetsHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetAssetsHistoryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFeedRequest, Feed> createFeedMethodDescriptor =
      MethodDescriptor.<CreateFeedRequest, Feed>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.asset.v1.AssetService/CreateFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feed.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetFeedRequest, Feed> getFeedMethodDescriptor =
      MethodDescriptor.<GetFeedRequest, Feed>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.asset.v1.AssetService/GetFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feed.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListFeedsRequest, ListFeedsResponse>
      listFeedsMethodDescriptor =
          MethodDescriptor.<ListFeedsRequest, ListFeedsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/ListFeeds")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFeedsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFeedsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFeedRequest, Feed> updateFeedMethodDescriptor =
      MethodDescriptor.<UpdateFeedRequest, Feed>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.asset.v1.AssetService/UpdateFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feed.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteFeedRequest, Empty> deleteFeedMethodDescriptor =
      MethodDescriptor.<DeleteFeedRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.asset.v1.AssetService/DeleteFeed")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteFeedRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesMethodDescriptor =
          MethodDescriptor.<SearchAllResourcesRequest, SearchAllResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/SearchAllResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchAllResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAllResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesMethodDescriptor =
          MethodDescriptor.<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/SearchAllIamPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchAllIamPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAllIamPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyMethodDescriptor =
          MethodDescriptor.<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/AnalyzeIamPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyzeIamPolicyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningMethodDescriptor =
          MethodDescriptor.<AnalyzeIamPolicyLongrunningRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/AnalyzeIamPolicyLongrunning")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeIamPolicyLongrunningRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ExportAssetsRequest, Operation> exportAssetsCallable;
  private final OperationCallable<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationCallable;
  private final UnaryCallable<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistoryCallable;
  private final UnaryCallable<CreateFeedRequest, Feed> createFeedCallable;
  private final UnaryCallable<GetFeedRequest, Feed> getFeedCallable;
  private final UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable;
  private final UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable;
  private final UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable;
  private final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable;
  private final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable;
  private final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable;
  private final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable;
  private final UnaryCallable<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyCallable;
  private final UnaryCallable<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningCallable;
  private final OperationCallable<
          AnalyzeIamPolicyLongrunningRequest,
          AnalyzeIamPolicyLongrunningResponse,
          AnalyzeIamPolicyLongrunningRequest>
      analyzeIamPolicyLongrunningOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAssetServiceStub create(AssetServiceStubSettings settings)
      throws IOException {
    return new GrpcAssetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAssetServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcAssetServiceStub(AssetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAssetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAssetServiceStub(
        AssetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAssetServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAssetServiceStub(AssetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAssetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAssetServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAssetServiceStub(
      AssetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ExportAssetsRequest, Operation> exportAssetsTransportSettings =
        GrpcCallSettings.<ExportAssetsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportAssetsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportAssetsRequest>() {
                  @Override
                  public Map<String, String> extract(ExportAssetsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
        batchGetAssetsHistoryTransportSettings =
            GrpcCallSettings
                .<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>newBuilder()
                .setMethodDescriptor(batchGetAssetsHistoryMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchGetAssetsHistoryRequest>() {
                      @Override
                      public Map<String, String> extract(BatchGetAssetsHistoryRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateFeedRequest, Feed> createFeedTransportSettings =
        GrpcCallSettings.<CreateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(createFeedMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateFeedRequest>() {
                  @Override
                  public Map<String, String> extract(CreateFeedRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetFeedRequest, Feed> getFeedTransportSettings =
        GrpcCallSettings.<GetFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(getFeedMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetFeedRequest>() {
                  @Override
                  public Map<String, String> extract(GetFeedRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsTransportSettings =
        GrpcCallSettings.<ListFeedsRequest, ListFeedsResponse>newBuilder()
            .setMethodDescriptor(listFeedsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListFeedsRequest>() {
                  @Override
                  public Map<String, String> extract(ListFeedsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateFeedRequest, Feed> updateFeedTransportSettings =
        GrpcCallSettings.<UpdateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(updateFeedMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateFeedRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateFeedRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("feed.name", String.valueOf(request.getFeed().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteFeedRequest, Empty> deleteFeedTransportSettings =
        GrpcCallSettings.<DeleteFeedRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFeedMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteFeedRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteFeedRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SearchAllResourcesRequest, SearchAllResourcesResponse>
        searchAllResourcesTransportSettings =
            GrpcCallSettings.<SearchAllResourcesRequest, SearchAllResourcesResponse>newBuilder()
                .setMethodDescriptor(searchAllResourcesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SearchAllResourcesRequest>() {
                      @Override
                      public Map<String, String> extract(SearchAllResourcesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("scope", String.valueOf(request.getScope()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
        searchAllIamPoliciesTransportSettings =
            GrpcCallSettings.<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>newBuilder()
                .setMethodDescriptor(searchAllIamPoliciesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SearchAllIamPoliciesRequest>() {
                      @Override
                      public Map<String, String> extract(SearchAllIamPoliciesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("scope", String.valueOf(request.getScope()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
        analyzeIamPolicyTransportSettings =
            GrpcCallSettings.<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>newBuilder()
                .setMethodDescriptor(analyzeIamPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<AnalyzeIamPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(AnalyzeIamPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "analysis_query.scope",
                            String.valueOf(request.getAnalysisQuery().getScope()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<AnalyzeIamPolicyLongrunningRequest, Operation>
        analyzeIamPolicyLongrunningTransportSettings =
            GrpcCallSettings.<AnalyzeIamPolicyLongrunningRequest, Operation>newBuilder()
                .setMethodDescriptor(analyzeIamPolicyLongrunningMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<AnalyzeIamPolicyLongrunningRequest>() {
                      @Override
                      public Map<String, String> extract(
                          AnalyzeIamPolicyLongrunningRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "analysis_query.scope",
                            String.valueOf(request.getAnalysisQuery().getScope()));
                        return params.build();
                      }
                    })
                .build();

    this.exportAssetsCallable =
        callableFactory.createUnaryCallable(
            exportAssetsTransportSettings, settings.exportAssetsSettings(), clientContext);
    this.exportAssetsOperationCallable =
        callableFactory.createOperationCallable(
            exportAssetsTransportSettings,
            settings.exportAssetsOperationSettings(),
            clientContext,
            operationsStub);
    this.batchGetAssetsHistoryCallable =
        callableFactory.createUnaryCallable(
            batchGetAssetsHistoryTransportSettings,
            settings.batchGetAssetsHistorySettings(),
            clientContext);
    this.createFeedCallable =
        callableFactory.createUnaryCallable(
            createFeedTransportSettings, settings.createFeedSettings(), clientContext);
    this.getFeedCallable =
        callableFactory.createUnaryCallable(
            getFeedTransportSettings, settings.getFeedSettings(), clientContext);
    this.listFeedsCallable =
        callableFactory.createUnaryCallable(
            listFeedsTransportSettings, settings.listFeedsSettings(), clientContext);
    this.updateFeedCallable =
        callableFactory.createUnaryCallable(
            updateFeedTransportSettings, settings.updateFeedSettings(), clientContext);
    this.deleteFeedCallable =
        callableFactory.createUnaryCallable(
            deleteFeedTransportSettings, settings.deleteFeedSettings(), clientContext);
    this.searchAllResourcesCallable =
        callableFactory.createUnaryCallable(
            searchAllResourcesTransportSettings,
            settings.searchAllResourcesSettings(),
            clientContext);
    this.searchAllResourcesPagedCallable =
        callableFactory.createPagedCallable(
            searchAllResourcesTransportSettings,
            settings.searchAllResourcesSettings(),
            clientContext);
    this.searchAllIamPoliciesCallable =
        callableFactory.createUnaryCallable(
            searchAllIamPoliciesTransportSettings,
            settings.searchAllIamPoliciesSettings(),
            clientContext);
    this.searchAllIamPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            searchAllIamPoliciesTransportSettings,
            settings.searchAllIamPoliciesSettings(),
            clientContext);
    this.analyzeIamPolicyCallable =
        callableFactory.createUnaryCallable(
            analyzeIamPolicyTransportSettings, settings.analyzeIamPolicySettings(), clientContext);
    this.analyzeIamPolicyLongrunningCallable =
        callableFactory.createUnaryCallable(
            analyzeIamPolicyLongrunningTransportSettings,
            settings.analyzeIamPolicyLongrunningSettings(),
            clientContext);
    this.analyzeIamPolicyLongrunningOperationCallable =
        callableFactory.createOperationCallable(
            analyzeIamPolicyLongrunningTransportSettings,
            settings.analyzeIamPolicyLongrunningOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ExportAssetsRequest, Operation> exportAssetsCallable() {
    return exportAssetsCallable;
  }

  @Override
  public OperationCallable<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationCallable() {
    return exportAssetsOperationCallable;
  }

  @Override
  public UnaryCallable<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistoryCallable() {
    return batchGetAssetsHistoryCallable;
  }

  @Override
  public UnaryCallable<CreateFeedRequest, Feed> createFeedCallable() {
    return createFeedCallable;
  }

  @Override
  public UnaryCallable<GetFeedRequest, Feed> getFeedCallable() {
    return getFeedCallable;
  }

  @Override
  public UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    return listFeedsCallable;
  }

  @Override
  public UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    return updateFeedCallable;
  }

  @Override
  public UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    return deleteFeedCallable;
  }

  @Override
  public UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable() {
    return searchAllResourcesCallable;
  }

  @Override
  public UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable() {
    return searchAllResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable() {
    return searchAllIamPoliciesCallable;
  }

  @Override
  public UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable() {
    return searchAllIamPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyCallable() {
    return analyzeIamPolicyCallable;
  }

  @Override
  public UnaryCallable<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningCallable() {
    return analyzeIamPolicyLongrunningCallable;
  }

  @Override
  public OperationCallable<
          AnalyzeIamPolicyLongrunningRequest,
          AnalyzeIamPolicyLongrunningResponse,
          AnalyzeIamPolicyLongrunningRequest>
      analyzeIamPolicyLongrunningOperationCallable() {
    return analyzeIamPolicyLongrunningOperationCallable;
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
