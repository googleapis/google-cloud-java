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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the AssetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAssetServiceStub extends AssetServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(AnalyzeIamPolicyLongrunningMetadata.getDescriptor())
          .add(ExportAssetsResponse.getDescriptor())
          .add(AnalyzeIamPolicyLongrunningResponse.getDescriptor())
          .add(ExportAssetsRequest.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ExportAssetsRequest, Operation>
      exportAssetsMethodDescriptor =
          ApiMethodDescriptor.<ExportAssetsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/ExportAssets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}:exportAssets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportAssetsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          ApiMethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/ListAssets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}/assets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "assetTypes", request.getAssetTypesList());
                            serializer.putQueryParam(
                                fields, "contentType", request.getContentType());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "readTime", request.getReadTime());
                            serializer.putQueryParam(
                                fields, "relationshipTypes", request.getRelationshipTypesList());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAssetsResponse>newBuilder()
                      .setDefaultInstance(ListAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistoryMethodDescriptor =
          ApiMethodDescriptor
              .<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/BatchGetAssetsHistory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetAssetsHistoryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}:batchGetAssetsHistory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetAssetsHistoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetAssetsHistoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "assetNames", request.getAssetNamesList());
                            serializer.putQueryParam(
                                fields, "contentType", request.getContentType());
                            serializer.putQueryParam(
                                fields, "readTimeWindow", request.getReadTimeWindow());
                            serializer.putQueryParam(
                                fields, "relationshipTypes", request.getRelationshipTypesList());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetAssetsHistoryResponse>newBuilder()
                      .setDefaultInstance(BatchGetAssetsHistoryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFeedRequest, Feed> createFeedMethodDescriptor =
      ApiMethodDescriptor.<CreateFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.asset.v1.AssetService/CreateFeed")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=*/*}/feeds",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearParent().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetFeedRequest, Feed> getFeedMethodDescriptor =
      ApiMethodDescriptor.<GetFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.asset.v1.AssetService/GetFeed")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{name=*/*/feeds/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListFeedsRequest, ListFeedsResponse>
      listFeedsMethodDescriptor =
          ApiMethodDescriptor.<ListFeedsRequest, ListFeedsResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/ListFeeds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFeedsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}/feeds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFeedsResponse>newBuilder()
                      .setDefaultInstance(ListFeedsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateFeedRequest, Feed> updateFeedMethodDescriptor =
      ApiMethodDescriptor.<UpdateFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.asset.v1.AssetService/UpdateFeed")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{feed.name=*/*/feeds/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "feed.name", request.getFeed().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteFeedRequest, Empty> deleteFeedMethodDescriptor =
      ApiMethodDescriptor.<DeleteFeedRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.asset.v1.AssetService/DeleteFeed")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{name=*/*/feeds/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesMethodDescriptor =
          ApiMethodDescriptor.<SearchAllResourcesRequest, SearchAllResourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/SearchAllResources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAllResourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{scope=*/*}:searchAllResources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAllResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scope", request.getScope());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAllResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "assetTypes", request.getAssetTypesList());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "readMask", request.getReadMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAllResourcesResponse>newBuilder()
                      .setDefaultInstance(SearchAllResourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/SearchAllIamPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAllIamPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/{scope=*/*}:searchAllIamPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAllIamPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scope", request.getScope());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAllIamPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "assetTypes", request.getAssetTypesList());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAllIamPoliciesResponse>newBuilder()
                      .setDefaultInstance(SearchAllIamPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/AnalyzeIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{analysisQuery.scope=*/*}:analyzeIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "analysisQuery.scope",
                                request.getAnalysisQuery().getScope());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "analysisQuery", request.getAnalysisQuery());
                            serializer.putQueryParam(
                                fields, "executionTimeout", request.getExecutionTimeout());
                            serializer.putQueryParam(
                                fields, "savedAnalysisQuery", request.getSavedAnalysisQuery());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyzeIamPolicyResponse>newBuilder()
                      .setDefaultInstance(AnalyzeIamPolicyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeIamPolicyLongrunningRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/AnalyzeIamPolicyLongrunning")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeIamPolicyLongrunningRequest>newBuilder()
                      .setPath(
                          "/v1/{analysisQuery.scope=*/*}:analyzeIamPolicyLongrunning",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeIamPolicyLongrunningRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "analysisQuery.scope",
                                request.getAnalysisQuery().getScope());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeIamPolicyLongrunningRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AnalyzeIamPolicyLongrunningRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AnalyzeMoveRequest, AnalyzeMoveResponse>
      analyzeMoveMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeMoveRequest, AnalyzeMoveResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/AnalyzeMove")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeMoveRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=*/*}:analyzeMove",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeMoveRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeMoveRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "destinationParent", request.getDestinationParent());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyzeMoveResponse>newBuilder()
                      .setDefaultInstance(AnalyzeMoveResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<QueryAssetsRequest, QueryAssetsResponse>
      queryAssetsMethodDescriptor =
          ApiMethodDescriptor.<QueryAssetsRequest, QueryAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/QueryAssets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}:queryAssets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryAssetsResponse>newBuilder()
                      .setDefaultInstance(QueryAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSavedQueryRequest, SavedQuery>
      createSavedQueryMethodDescriptor =
          ApiMethodDescriptor.<CreateSavedQueryRequest, SavedQuery>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/CreateSavedQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSavedQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}/savedQueries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSavedQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSavedQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "savedQueryId", request.getSavedQueryId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("savedQuery", request.getSavedQuery(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SavedQuery>newBuilder()
                      .setDefaultInstance(SavedQuery.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSavedQueryRequest, SavedQuery>
      getSavedQueryMethodDescriptor =
          ApiMethodDescriptor.<GetSavedQueryRequest, SavedQuery>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/GetSavedQuery")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSavedQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=*/*/savedQueries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSavedQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSavedQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SavedQuery>newBuilder()
                      .setDefaultInstance(SavedQuery.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesMethodDescriptor =
          ApiMethodDescriptor.<ListSavedQueriesRequest, ListSavedQueriesResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/ListSavedQueries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSavedQueriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}/savedQueries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSavedQueriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSavedQueriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSavedQueriesResponse>newBuilder()
                      .setDefaultInstance(ListSavedQueriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSavedQueryRequest, SavedQuery>
      updateSavedQueryMethodDescriptor =
          ApiMethodDescriptor.<UpdateSavedQueryRequest, SavedQuery>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/UpdateSavedQuery")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSavedQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{savedQuery.name=*/*/savedQueries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSavedQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "savedQuery.name", request.getSavedQuery().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSavedQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("savedQuery", request.getSavedQuery(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SavedQuery>newBuilder()
                      .setDefaultInstance(SavedQuery.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSavedQueryRequest, Empty>
      deleteSavedQueryMethodDescriptor =
          ApiMethodDescriptor.<DeleteSavedQueryRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/DeleteSavedQuery")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSavedQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=*/*/savedQueries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSavedQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSavedQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
      batchGetEffectiveIamPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.asset.v1.AssetService/BatchGetEffectiveIamPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetEffectiveIamPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/{scope=*/*}/effectiveIamPolicies:batchGet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetEffectiveIamPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scope", request.getScope());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetEffectiveIamPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "names", request.getNamesList());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetEffectiveIamPoliciesResponse>newBuilder()
                      .setDefaultInstance(BatchGetEffectiveIamPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAssetServiceStub create(AssetServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAssetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAssetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAssetServiceStub(
        AssetServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAssetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAssetServiceStub(
        AssetServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAssetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAssetServiceStub(AssetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAssetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAssetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAssetServiceStub(
      AssetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ExportAssetsRequest, Operation> exportAssetsTransportSettings =
        HttpJsonCallSettings.<ExportAssetsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        HttpJsonCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
        batchGetAssetsHistoryTransportSettings =
            HttpJsonCallSettings
                .<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>newBuilder()
                .setMethodDescriptor(batchGetAssetsHistoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateFeedRequest, Feed> createFeedTransportSettings =
        HttpJsonCallSettings.<CreateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(createFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetFeedRequest, Feed> getFeedTransportSettings =
        HttpJsonCallSettings.<GetFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(getFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsTransportSettings =
        HttpJsonCallSettings.<ListFeedsRequest, ListFeedsResponse>newBuilder()
            .setMethodDescriptor(listFeedsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateFeedRequest, Feed> updateFeedTransportSettings =
        HttpJsonCallSettings.<UpdateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(updateFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteFeedRequest, Empty> deleteFeedTransportSettings =
        HttpJsonCallSettings.<DeleteFeedRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchAllResourcesRequest, SearchAllResourcesResponse>
        searchAllResourcesTransportSettings =
            HttpJsonCallSettings.<SearchAllResourcesRequest, SearchAllResourcesResponse>newBuilder()
                .setMethodDescriptor(searchAllResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
        searchAllIamPoliciesTransportSettings =
            HttpJsonCallSettings
                .<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>newBuilder()
                .setMethodDescriptor(searchAllIamPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
        analyzeIamPolicyTransportSettings =
            HttpJsonCallSettings.<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>newBuilder()
                .setMethodDescriptor(analyzeIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AnalyzeIamPolicyLongrunningRequest, Operation>
        analyzeIamPolicyLongrunningTransportSettings =
            HttpJsonCallSettings.<AnalyzeIamPolicyLongrunningRequest, Operation>newBuilder()
                .setMethodDescriptor(analyzeIamPolicyLongrunningMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AnalyzeMoveRequest, AnalyzeMoveResponse> analyzeMoveTransportSettings =
        HttpJsonCallSettings.<AnalyzeMoveRequest, AnalyzeMoveResponse>newBuilder()
            .setMethodDescriptor(analyzeMoveMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<QueryAssetsRequest, QueryAssetsResponse> queryAssetsTransportSettings =
        HttpJsonCallSettings.<QueryAssetsRequest, QueryAssetsResponse>newBuilder()
            .setMethodDescriptor(queryAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateSavedQueryRequest, SavedQuery> createSavedQueryTransportSettings =
        HttpJsonCallSettings.<CreateSavedQueryRequest, SavedQuery>newBuilder()
            .setMethodDescriptor(createSavedQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSavedQueryRequest, SavedQuery> getSavedQueryTransportSettings =
        HttpJsonCallSettings.<GetSavedQueryRequest, SavedQuery>newBuilder()
            .setMethodDescriptor(getSavedQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListSavedQueriesRequest, ListSavedQueriesResponse>
        listSavedQueriesTransportSettings =
            HttpJsonCallSettings.<ListSavedQueriesRequest, ListSavedQueriesResponse>newBuilder()
                .setMethodDescriptor(listSavedQueriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateSavedQueryRequest, SavedQuery> updateSavedQueryTransportSettings =
        HttpJsonCallSettings.<UpdateSavedQueryRequest, SavedQuery>newBuilder()
            .setMethodDescriptor(updateSavedQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSavedQueryRequest, Empty> deleteSavedQueryTransportSettings =
        HttpJsonCallSettings.<DeleteSavedQueryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSavedQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
        batchGetEffectiveIamPoliciesTransportSettings =
            HttpJsonCallSettings
                .<BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(batchGetEffectiveIamPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.exportAssetsCallable =
        callableFactory.createUnaryCallable(
            exportAssetsTransportSettings, settings.exportAssetsSettings(), clientContext);
    this.exportAssetsOperationCallable =
        callableFactory.createOperationCallable(
            exportAssetsTransportSettings,
            settings.exportAssetsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(exportAssetsMethodDescriptor);
    methodDescriptors.add(listAssetsMethodDescriptor);
    methodDescriptors.add(batchGetAssetsHistoryMethodDescriptor);
    methodDescriptors.add(createFeedMethodDescriptor);
    methodDescriptors.add(getFeedMethodDescriptor);
    methodDescriptors.add(listFeedsMethodDescriptor);
    methodDescriptors.add(updateFeedMethodDescriptor);
    methodDescriptors.add(deleteFeedMethodDescriptor);
    methodDescriptors.add(searchAllResourcesMethodDescriptor);
    methodDescriptors.add(searchAllIamPoliciesMethodDescriptor);
    methodDescriptors.add(analyzeIamPolicyMethodDescriptor);
    methodDescriptors.add(analyzeIamPolicyLongrunningMethodDescriptor);
    methodDescriptors.add(analyzeMoveMethodDescriptor);
    methodDescriptors.add(queryAssetsMethodDescriptor);
    methodDescriptors.add(createSavedQueryMethodDescriptor);
    methodDescriptors.add(getSavedQueryMethodDescriptor);
    methodDescriptors.add(listSavedQueriesMethodDescriptor);
    methodDescriptors.add(updateSavedQueryMethodDescriptor);
    methodDescriptors.add(deleteSavedQueryMethodDescriptor);
    methodDescriptors.add(batchGetEffectiveIamPoliciesMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
