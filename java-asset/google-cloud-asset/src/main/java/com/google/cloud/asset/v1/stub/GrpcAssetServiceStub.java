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

package com.google.cloud.asset.v1.stub;

import static com.google.cloud.asset.v1.AssetServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.ListSavedQueriesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningMetadata;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningResponse;
import com.google.cloud.asset.v1.AnalyzeIamPolicyRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyResponse;
import com.google.cloud.asset.v1.AnalyzeMoveRequest;
import com.google.cloud.asset.v1.AnalyzeMoveResponse;
import com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest;
import com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse;
import com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest;
import com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse;
import com.google.cloud.asset.v1.CreateFeedRequest;
import com.google.cloud.asset.v1.CreateSavedQueryRequest;
import com.google.cloud.asset.v1.DeleteFeedRequest;
import com.google.cloud.asset.v1.DeleteSavedQueryRequest;
import com.google.cloud.asset.v1.ExportAssetsRequest;
import com.google.cloud.asset.v1.ExportAssetsResponse;
import com.google.cloud.asset.v1.Feed;
import com.google.cloud.asset.v1.GetFeedRequest;
import com.google.cloud.asset.v1.GetSavedQueryRequest;
import com.google.cloud.asset.v1.ListAssetsRequest;
import com.google.cloud.asset.v1.ListAssetsResponse;
import com.google.cloud.asset.v1.ListFeedsRequest;
import com.google.cloud.asset.v1.ListFeedsResponse;
import com.google.cloud.asset.v1.ListSavedQueriesRequest;
import com.google.cloud.asset.v1.ListSavedQueriesResponse;
import com.google.cloud.asset.v1.QueryAssetsRequest;
import com.google.cloud.asset.v1.QueryAssetsResponse;
import com.google.cloud.asset.v1.SavedQuery;
import com.google.cloud.asset.v1.SearchAllIamPoliciesRequest;
import com.google.cloud.asset.v1.SearchAllIamPoliciesResponse;
import com.google.cloud.asset.v1.SearchAllResourcesRequest;
import com.google.cloud.asset.v1.SearchAllResourcesResponse;
import com.google.cloud.asset.v1.UpdateFeedRequest;
import com.google.cloud.asset.v1.UpdateSavedQueryRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
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

  private static final MethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          MethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/ListAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAssetsResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<AnalyzeMoveRequest, AnalyzeMoveResponse>
      analyzeMoveMethodDescriptor =
          MethodDescriptor.<AnalyzeMoveRequest, AnalyzeMoveResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/AnalyzeMove")
              .setRequestMarshaller(ProtoUtils.marshaller(AnalyzeMoveRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyzeMoveResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<QueryAssetsRequest, QueryAssetsResponse>
      queryAssetsMethodDescriptor =
          MethodDescriptor.<QueryAssetsRequest, QueryAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/QueryAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(QueryAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSavedQueryRequest, SavedQuery>
      createSavedQueryMethodDescriptor =
          MethodDescriptor.<CreateSavedQueryRequest, SavedQuery>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/CreateSavedQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSavedQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SavedQuery.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSavedQueryRequest, SavedQuery>
      getSavedQueryMethodDescriptor =
          MethodDescriptor.<GetSavedQueryRequest, SavedQuery>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/GetSavedQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSavedQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SavedQuery.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesMethodDescriptor =
          MethodDescriptor.<ListSavedQueriesRequest, ListSavedQueriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/ListSavedQueries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSavedQueriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSavedQueriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSavedQueryRequest, SavedQuery>
      updateSavedQueryMethodDescriptor =
          MethodDescriptor.<UpdateSavedQueryRequest, SavedQuery>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/UpdateSavedQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSavedQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SavedQuery.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSavedQueryRequest, Empty>
      deleteSavedQueryMethodDescriptor =
          MethodDescriptor.<DeleteSavedQueryRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/DeleteSavedQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSavedQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
      batchGetEffectiveIamPoliciesMethodDescriptor =
          MethodDescriptor
              .<BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1.AssetService/BatchGetEffectiveIamPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetEffectiveIamPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetEffectiveIamPoliciesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ExportAssetsRequest, Operation> exportAssetsCallable;
  private final OperationCallable<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable;
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
          AnalyzeIamPolicyLongrunningMetadata>
      analyzeIamPolicyLongrunningOperationCallable;
  private final UnaryCallable<AnalyzeMoveRequest, AnalyzeMoveResponse> analyzeMoveCallable;
  private final UnaryCallable<QueryAssetsRequest, QueryAssetsResponse> queryAssetsCallable;
  private final UnaryCallable<CreateSavedQueryRequest, SavedQuery> createSavedQueryCallable;
  private final UnaryCallable<GetSavedQueryRequest, SavedQuery> getSavedQueryCallable;
  private final UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesCallable;
  private final UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesPagedResponse>
      listSavedQueriesPagedCallable;
  private final UnaryCallable<UpdateSavedQueryRequest, SavedQuery> updateSavedQueryCallable;
  private final UnaryCallable<DeleteSavedQueryRequest, Empty> deleteSavedQueryCallable;
  private final UnaryCallable<
          BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
      batchGetEffectiveIamPoliciesCallable;

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
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        GrpcCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
        batchGetAssetsHistoryTransportSettings =
            GrpcCallSettings
                .<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>newBuilder()
                .setMethodDescriptor(batchGetAssetsHistoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateFeedRequest, Feed> createFeedTransportSettings =
        GrpcCallSettings.<CreateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(createFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetFeedRequest, Feed> getFeedTransportSettings =
        GrpcCallSettings.<GetFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(getFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsTransportSettings =
        GrpcCallSettings.<ListFeedsRequest, ListFeedsResponse>newBuilder()
            .setMethodDescriptor(listFeedsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateFeedRequest, Feed> updateFeedTransportSettings =
        GrpcCallSettings.<UpdateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(updateFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("feed.name", String.valueOf(request.getFeed().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteFeedRequest, Empty> deleteFeedTransportSettings =
        GrpcCallSettings.<DeleteFeedRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SearchAllResourcesRequest, SearchAllResourcesResponse>
        searchAllResourcesTransportSettings =
            GrpcCallSettings.<SearchAllResourcesRequest, SearchAllResourcesResponse>newBuilder()
                .setMethodDescriptor(searchAllResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("scope", String.valueOf(request.getScope()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
        searchAllIamPoliciesTransportSettings =
            GrpcCallSettings.<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>newBuilder()
                .setMethodDescriptor(searchAllIamPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("scope", String.valueOf(request.getScope()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
        analyzeIamPolicyTransportSettings =
            GrpcCallSettings.<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>newBuilder()
                .setMethodDescriptor(analyzeIamPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "analysis_query.scope",
                          String.valueOf(request.getAnalysisQuery().getScope()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<AnalyzeIamPolicyLongrunningRequest, Operation>
        analyzeIamPolicyLongrunningTransportSettings =
            GrpcCallSettings.<AnalyzeIamPolicyLongrunningRequest, Operation>newBuilder()
                .setMethodDescriptor(analyzeIamPolicyLongrunningMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "analysis_query.scope",
                          String.valueOf(request.getAnalysisQuery().getScope()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<AnalyzeMoveRequest, AnalyzeMoveResponse> analyzeMoveTransportSettings =
        GrpcCallSettings.<AnalyzeMoveRequest, AnalyzeMoveResponse>newBuilder()
            .setMethodDescriptor(analyzeMoveMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<QueryAssetsRequest, QueryAssetsResponse> queryAssetsTransportSettings =
        GrpcCallSettings.<QueryAssetsRequest, QueryAssetsResponse>newBuilder()
            .setMethodDescriptor(queryAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateSavedQueryRequest, SavedQuery> createSavedQueryTransportSettings =
        GrpcCallSettings.<CreateSavedQueryRequest, SavedQuery>newBuilder()
            .setMethodDescriptor(createSavedQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetSavedQueryRequest, SavedQuery> getSavedQueryTransportSettings =
        GrpcCallSettings.<GetSavedQueryRequest, SavedQuery>newBuilder()
            .setMethodDescriptor(getSavedQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListSavedQueriesRequest, ListSavedQueriesResponse>
        listSavedQueriesTransportSettings =
            GrpcCallSettings.<ListSavedQueriesRequest, ListSavedQueriesResponse>newBuilder()
                .setMethodDescriptor(listSavedQueriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateSavedQueryRequest, SavedQuery> updateSavedQueryTransportSettings =
        GrpcCallSettings.<UpdateSavedQueryRequest, SavedQuery>newBuilder()
            .setMethodDescriptor(updateSavedQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("saved_query.name", String.valueOf(request.getSavedQuery().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteSavedQueryRequest, Empty> deleteSavedQueryTransportSettings =
        GrpcCallSettings.<DeleteSavedQueryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSavedQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
        batchGetEffectiveIamPoliciesTransportSettings =
            GrpcCallSettings
                .<BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(batchGetEffectiveIamPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("scope", String.valueOf(request.getScope()));
                      return params.build();
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
    this.listAssetsCallable =
        callableFactory.createUnaryCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.listAssetsPagedCallable =
        callableFactory.createPagedCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
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
    this.analyzeMoveCallable =
        callableFactory.createUnaryCallable(
            analyzeMoveTransportSettings, settings.analyzeMoveSettings(), clientContext);
    this.queryAssetsCallable =
        callableFactory.createUnaryCallable(
            queryAssetsTransportSettings, settings.queryAssetsSettings(), clientContext);
    this.createSavedQueryCallable =
        callableFactory.createUnaryCallable(
            createSavedQueryTransportSettings, settings.createSavedQuerySettings(), clientContext);
    this.getSavedQueryCallable =
        callableFactory.createUnaryCallable(
            getSavedQueryTransportSettings, settings.getSavedQuerySettings(), clientContext);
    this.listSavedQueriesCallable =
        callableFactory.createUnaryCallable(
            listSavedQueriesTransportSettings, settings.listSavedQueriesSettings(), clientContext);
    this.listSavedQueriesPagedCallable =
        callableFactory.createPagedCallable(
            listSavedQueriesTransportSettings, settings.listSavedQueriesSettings(), clientContext);
    this.updateSavedQueryCallable =
        callableFactory.createUnaryCallable(
            updateSavedQueryTransportSettings, settings.updateSavedQuerySettings(), clientContext);
    this.deleteSavedQueryCallable =
        callableFactory.createUnaryCallable(
            deleteSavedQueryTransportSettings, settings.deleteSavedQuerySettings(), clientContext);
    this.batchGetEffectiveIamPoliciesCallable =
        callableFactory.createUnaryCallable(
            batchGetEffectiveIamPoliciesTransportSettings,
            settings.batchGetEffectiveIamPoliciesSettings(),
            clientContext);

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
  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return listAssetsCallable;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return listAssetsPagedCallable;
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
          AnalyzeIamPolicyLongrunningMetadata>
      analyzeIamPolicyLongrunningOperationCallable() {
    return analyzeIamPolicyLongrunningOperationCallable;
  }

  @Override
  public UnaryCallable<AnalyzeMoveRequest, AnalyzeMoveResponse> analyzeMoveCallable() {
    return analyzeMoveCallable;
  }

  @Override
  public UnaryCallable<QueryAssetsRequest, QueryAssetsResponse> queryAssetsCallable() {
    return queryAssetsCallable;
  }

  @Override
  public UnaryCallable<CreateSavedQueryRequest, SavedQuery> createSavedQueryCallable() {
    return createSavedQueryCallable;
  }

  @Override
  public UnaryCallable<GetSavedQueryRequest, SavedQuery> getSavedQueryCallable() {
    return getSavedQueryCallable;
  }

  @Override
  public UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesCallable() {
    return listSavedQueriesCallable;
  }

  @Override
  public UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesPagedResponse>
      listSavedQueriesPagedCallable() {
    return listSavedQueriesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSavedQueryRequest, SavedQuery> updateSavedQueryCallable() {
    return updateSavedQueryCallable;
  }

  @Override
  public UnaryCallable<DeleteSavedQueryRequest, Empty> deleteSavedQueryCallable() {
    return deleteSavedQueryCallable;
  }

  @Override
  public UnaryCallable<BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
      batchGetEffectiveIamPoliciesCallable() {
    return batchGetEffectiveIamPoliciesCallable;
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
