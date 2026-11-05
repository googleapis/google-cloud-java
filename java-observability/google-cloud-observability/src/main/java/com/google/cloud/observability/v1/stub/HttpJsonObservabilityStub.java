/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.observability.v1.stub;

import static com.google.cloud.observability.v1.ObservabilityClient.ListBucketsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListDatasetsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLinksPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLocationsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListTraceScopesPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListViewsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.observability.v1.Bucket;
import com.google.cloud.observability.v1.CreateBucketRequest;
import com.google.cloud.observability.v1.CreateLinkRequest;
import com.google.cloud.observability.v1.CreateTraceScopeRequest;
import com.google.cloud.observability.v1.Dataset;
import com.google.cloud.observability.v1.DeleteLinkRequest;
import com.google.cloud.observability.v1.DeleteTraceScopeRequest;
import com.google.cloud.observability.v1.GetBucketRequest;
import com.google.cloud.observability.v1.GetDatasetRequest;
import com.google.cloud.observability.v1.GetLinkRequest;
import com.google.cloud.observability.v1.GetScopeRequest;
import com.google.cloud.observability.v1.GetSettingsRequest;
import com.google.cloud.observability.v1.GetTraceScopeRequest;
import com.google.cloud.observability.v1.GetViewRequest;
import com.google.cloud.observability.v1.Link;
import com.google.cloud.observability.v1.ListBucketsRequest;
import com.google.cloud.observability.v1.ListBucketsResponse;
import com.google.cloud.observability.v1.ListDatasetsRequest;
import com.google.cloud.observability.v1.ListDatasetsResponse;
import com.google.cloud.observability.v1.ListLinksRequest;
import com.google.cloud.observability.v1.ListLinksResponse;
import com.google.cloud.observability.v1.ListTraceScopesRequest;
import com.google.cloud.observability.v1.ListTraceScopesResponse;
import com.google.cloud.observability.v1.ListViewsRequest;
import com.google.cloud.observability.v1.ListViewsResponse;
import com.google.cloud.observability.v1.OperationMetadata;
import com.google.cloud.observability.v1.Scope;
import com.google.cloud.observability.v1.Settings;
import com.google.cloud.observability.v1.TraceScope;
import com.google.cloud.observability.v1.UpdateBucketRequest;
import com.google.cloud.observability.v1.UpdateLinkRequest;
import com.google.cloud.observability.v1.UpdateScopeRequest;
import com.google.cloud.observability.v1.UpdateSettingsRequest;
import com.google.cloud.observability.v1.UpdateTraceScopeRequest;
import com.google.cloud.observability.v1.View;
import com.google.common.collect.ImmutableMap;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Observability service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonObservabilityStub extends ObservabilityStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Bucket.getDescriptor())
          .add(Link.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Settings.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetScopeRequest, Scope> getScopeMethodDescriptor =
      ApiMethodDescriptor.<GetScopeRequest, Scope>newBuilder()
          .setFullMethodName("google.cloud.observability.v1.Observability/GetScope")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetScopeRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/scopes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetScopeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetScopeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Scope>newBuilder()
                  .setDefaultInstance(Scope.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateScopeRequest, Scope> updateScopeMethodDescriptor =
      ApiMethodDescriptor.<UpdateScopeRequest, Scope>newBuilder()
          .setFullMethodName("google.cloud.observability.v1.Observability/UpdateScope")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateScopeRequest>newBuilder()
                  .setPath(
                      "/v1/{scope.name=projects/*/locations/*/scopes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateScopeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "scope.name", request.getScope().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateScopeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("scope", request.getScope(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Scope>newBuilder()
                  .setDefaultInstance(Scope.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetBucketRequest, Bucket> getBucketMethodDescriptor =
      ApiMethodDescriptor.<GetBucketRequest, Bucket>newBuilder()
          .setFullMethodName("google.cloud.observability.v1.Observability/GetBucket")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBucketRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/buckets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBucketRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBucketRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Bucket>newBuilder()
                  .setDefaultInstance(Bucket.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListBucketsRequest, ListBucketsResponse>
      listBucketsMethodDescriptor =
          ApiMethodDescriptor.<ListBucketsRequest, ListBucketsResponse>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/ListBuckets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBucketsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/buckets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBucketsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBucketsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBucketsResponse>newBuilder()
                      .setDefaultInstance(ListBucketsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBucketRequest, Operation>
      createBucketMethodDescriptor =
          ApiMethodDescriptor.<CreateBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/CreateBucket")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBucketRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/buckets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "bucketId", request.getBucketId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("bucket", request.getBucket(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBucketRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateBucketRequest, Operation>
      updateBucketMethodDescriptor =
          ApiMethodDescriptor.<UpdateBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/UpdateBucket")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBucketRequest>newBuilder()
                      .setPath(
                          "/v1/{bucket.name=projects/*/locations/*/buckets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "bucket.name", request.getBucket().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("bucket", request.getBucket(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBucketRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      ApiMethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setFullMethodName("google.cloud.observability.v1.Observability/GetDataset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDatasetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/buckets/*/datasets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetDatasetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetDatasetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Dataset>newBuilder()
                  .setDefaultInstance(Dataset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          ApiMethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/ListDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatasetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/buckets/*}/datasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDatasetsResponse>newBuilder()
                      .setDefaultInstance(ListDatasetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetViewRequest, View> getViewMethodDescriptor =
      ApiMethodDescriptor.<GetViewRequest, View>newBuilder()
          .setFullMethodName("google.cloud.observability.v1.Observability/GetView")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetViewRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/buckets/*/datasets/*/views/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<View>newBuilder()
                  .setDefaultInstance(View.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListViewsRequest, ListViewsResponse>
      listViewsMethodDescriptor =
          ApiMethodDescriptor.<ListViewsRequest, ListViewsResponse>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/ListViews")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListViewsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/buckets/*/datasets/*}/views",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListViewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListViewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListViewsResponse>newBuilder()
                      .setDefaultInstance(ListViewsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLinkRequest, Link> getLinkMethodDescriptor =
      ApiMethodDescriptor.<GetLinkRequest, Link>newBuilder()
          .setFullMethodName("google.cloud.observability.v1.Observability/GetLink")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetLinkRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/buckets/*/datasets/*/links/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetLinkRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetLinkRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Link>newBuilder()
                  .setDefaultInstance(Link.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListLinksRequest, ListLinksResponse>
      listLinksMethodDescriptor =
          ApiMethodDescriptor.<ListLinksRequest, ListLinksResponse>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/ListLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLinksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/buckets/*/datasets/*}/links",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLinksResponse>newBuilder()
                      .setDefaultInstance(ListLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateLinkRequest, Operation>
      createLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateLinkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/CreateLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/buckets/*/datasets/*}/links",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "linkId", request.getLinkId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("link", request.getLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateLinkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateLinkRequest, Operation>
      updateLinkMethodDescriptor =
          ApiMethodDescriptor.<UpdateLinkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/UpdateLink")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{link.name=projects/*/locations/*/buckets/*/datasets/*/links/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "link.name", request.getLink().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("link", request.getLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateLinkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteLinkRequest, Operation>
      deleteLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteLinkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/DeleteLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/buckets/*/datasets/*/links/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteLinkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetTraceScopeRequest, TraceScope>
      getTraceScopeMethodDescriptor =
          ApiMethodDescriptor.<GetTraceScopeRequest, TraceScope>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/GetTraceScope")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTraceScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/traceScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTraceScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTraceScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TraceScope>newBuilder()
                      .setDefaultInstance(TraceScope.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTraceScopesRequest, ListTraceScopesResponse>
      listTraceScopesMethodDescriptor =
          ApiMethodDescriptor.<ListTraceScopesRequest, ListTraceScopesResponse>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/ListTraceScopes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTraceScopesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/traceScopes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTraceScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTraceScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTraceScopesResponse>newBuilder()
                      .setDefaultInstance(ListTraceScopesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTraceScopeRequest, TraceScope>
      createTraceScopeMethodDescriptor =
          ApiMethodDescriptor.<CreateTraceScopeRequest, TraceScope>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/CreateTraceScope")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTraceScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/traceScopes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTraceScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTraceScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "traceScopeId", request.getTraceScopeId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("traceScope", request.getTraceScope(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TraceScope>newBuilder()
                      .setDefaultInstance(TraceScope.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTraceScopeRequest, TraceScope>
      updateTraceScopeMethodDescriptor =
          ApiMethodDescriptor.<UpdateTraceScopeRequest, TraceScope>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/UpdateTraceScope")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTraceScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{traceScope.name=projects/*/locations/*/traceScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTraceScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "traceScope.name", request.getTraceScope().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTraceScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("traceScope", request.getTraceScope(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TraceScope>newBuilder()
                      .setDefaultInstance(TraceScope.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTraceScopeRequest, Empty>
      deleteTraceScopeMethodDescriptor =
          ApiMethodDescriptor.<DeleteTraceScopeRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/DeleteTraceScope")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTraceScopeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/traceScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTraceScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTraceScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<GetSettingsRequest, Settings>
      getSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/GetSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/settings}",
                          "/v1/{name=organizations/*/locations/*/settings}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Settings>newBuilder()
                      .setDefaultInstance(Settings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSettingsRequest, Operation>
      updateSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateSettingsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.observability.v1.Observability/UpdateSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{settings.name=projects/*/locations/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "settings.name", request.getSettings().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{settings.name=folders/*/locations/*/settings}",
                          "/v1/{settings.name=organizations/*/locations/*/settings}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("settings", request.getSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSettingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*}/locations", "/v1/{name=organizations/*}/locations")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*}",
                          "/v1/{name=organizations/*/locations/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetScopeRequest, Scope> getScopeCallable;
  private final UnaryCallable<UpdateScopeRequest, Scope> updateScopeCallable;
  private final UnaryCallable<GetBucketRequest, Bucket> getBucketCallable;
  private final UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable;
  private final UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse>
      listBucketsPagedCallable;
  private final UnaryCallable<CreateBucketRequest, Operation> createBucketCallable;
  private final OperationCallable<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationCallable;
  private final UnaryCallable<UpdateBucketRequest, Operation> updateBucketCallable;
  private final OperationCallable<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<GetViewRequest, View> getViewCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable;
  private final UnaryCallable<GetLinkRequest, Link> getLinkCallable;
  private final UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable;
  private final UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable;
  private final UnaryCallable<CreateLinkRequest, Operation> createLinkCallable;
  private final OperationCallable<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationCallable;
  private final UnaryCallable<UpdateLinkRequest, Operation> updateLinkCallable;
  private final OperationCallable<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationCallable;
  private final UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable;
  private final OperationCallable<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationCallable;
  private final UnaryCallable<GetTraceScopeRequest, TraceScope> getTraceScopeCallable;
  private final UnaryCallable<ListTraceScopesRequest, ListTraceScopesResponse>
      listTraceScopesCallable;
  private final UnaryCallable<ListTraceScopesRequest, ListTraceScopesPagedResponse>
      listTraceScopesPagedCallable;
  private final UnaryCallable<CreateTraceScopeRequest, TraceScope> createTraceScopeCallable;
  private final UnaryCallable<UpdateTraceScopeRequest, TraceScope> updateTraceScopeCallable;
  private final UnaryCallable<DeleteTraceScopeRequest, Empty> deleteTraceScopeCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable;
  private final OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonObservabilityStub create(ObservabilityStubSettings settings)
      throws IOException {
    return new HttpJsonObservabilityStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonObservabilityStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonObservabilityStub(
        ObservabilityStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonObservabilityStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonObservabilityStub(
        ObservabilityStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonObservabilityStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonObservabilityStub(
      ObservabilityStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonObservabilityCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonObservabilityStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonObservabilityStub(
      ObservabilityStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost("/v1/{name=folders/*/locations/*/operations/*}:cancel")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=organizations/*/locations/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete("/v1/{name=folders/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=folders/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=folders/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<GetScopeRequest, Scope> getScopeTransportSettings =
        HttpJsonCallSettings.<GetScopeRequest, Scope>newBuilder()
            .setMethodDescriptor(getScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateScopeRequest, Scope> updateScopeTransportSettings =
        HttpJsonCallSettings.<UpdateScopeRequest, Scope>newBuilder()
            .setMethodDescriptor(updateScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("scope.name", String.valueOf(request.getScope().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBucketRequest, Bucket> getBucketTransportSettings =
        HttpJsonCallSettings.<GetBucketRequest, Bucket>newBuilder()
            .setMethodDescriptor(getBucketMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListBucketsRequest, ListBucketsResponse> listBucketsTransportSettings =
        HttpJsonCallSettings.<ListBucketsRequest, ListBucketsResponse>newBuilder()
            .setMethodDescriptor(listBucketsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateBucketRequest, Operation> createBucketTransportSettings =
        HttpJsonCallSettings.<CreateBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(createBucketMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateBucketRequest, Operation> updateBucketTransportSettings =
        HttpJsonCallSettings.<UpdateBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBucketMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("bucket.name", String.valueOf(request.getBucket().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        HttpJsonCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        HttpJsonCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetViewRequest, View> getViewTransportSettings =
        HttpJsonCallSettings.<GetViewRequest, View>newBuilder()
            .setMethodDescriptor(getViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListViewsRequest, ListViewsResponse> listViewsTransportSettings =
        HttpJsonCallSettings.<ListViewsRequest, ListViewsResponse>newBuilder()
            .setMethodDescriptor(listViewsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetLinkRequest, Link> getLinkTransportSettings =
        HttpJsonCallSettings.<GetLinkRequest, Link>newBuilder()
            .setMethodDescriptor(getLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListLinksRequest, ListLinksResponse> listLinksTransportSettings =
        HttpJsonCallSettings.<ListLinksRequest, ListLinksResponse>newBuilder()
            .setMethodDescriptor(listLinksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateLinkRequest, Operation> createLinkTransportSettings =
        HttpJsonCallSettings.<CreateLinkRequest, Operation>newBuilder()
            .setMethodDescriptor(createLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateLinkRequest, Operation> updateLinkTransportSettings =
        HttpJsonCallSettings.<UpdateLinkRequest, Operation>newBuilder()
            .setMethodDescriptor(updateLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("link.name", String.valueOf(request.getLink().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteLinkRequest, Operation> deleteLinkTransportSettings =
        HttpJsonCallSettings.<DeleteLinkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetTraceScopeRequest, TraceScope> getTraceScopeTransportSettings =
        HttpJsonCallSettings.<GetTraceScopeRequest, TraceScope>newBuilder()
            .setMethodDescriptor(getTraceScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListTraceScopesRequest, ListTraceScopesResponse>
        listTraceScopesTransportSettings =
            HttpJsonCallSettings.<ListTraceScopesRequest, ListTraceScopesResponse>newBuilder()
                .setMethodDescriptor(listTraceScopesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateTraceScopeRequest, TraceScope> createTraceScopeTransportSettings =
        HttpJsonCallSettings.<CreateTraceScopeRequest, TraceScope>newBuilder()
            .setMethodDescriptor(createTraceScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateTraceScopeRequest, TraceScope> updateTraceScopeTransportSettings =
        HttpJsonCallSettings.<UpdateTraceScopeRequest, TraceScope>newBuilder()
            .setMethodDescriptor(updateTraceScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "trace_scope.name", String.valueOf(request.getTraceScope().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTraceScopeRequest, Empty> deleteTraceScopeTransportSettings =
        HttpJsonCallSettings.<DeleteTraceScopeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTraceScopeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        HttpJsonCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateSettingsRequest, Operation> updateSettingsTransportSettings =
        HttpJsonCallSettings.<UpdateSettingsRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getScopeCallable =
        callableFactory.createUnaryCallable(
            getScopeTransportSettings, settings.getScopeSettings(), clientContext);
    this.updateScopeCallable =
        callableFactory.createUnaryCallable(
            updateScopeTransportSettings, settings.updateScopeSettings(), clientContext);
    this.getBucketCallable =
        callableFactory.createUnaryCallable(
            getBucketTransportSettings, settings.getBucketSettings(), clientContext);
    this.listBucketsCallable =
        callableFactory.createUnaryCallable(
            listBucketsTransportSettings, settings.listBucketsSettings(), clientContext);
    this.listBucketsPagedCallable =
        callableFactory.createPagedCallable(
            listBucketsTransportSettings, settings.listBucketsSettings(), clientContext);
    this.createBucketCallable =
        callableFactory.createUnaryCallable(
            createBucketTransportSettings, settings.createBucketSettings(), clientContext);
    this.createBucketOperationCallable =
        callableFactory.createOperationCallable(
            createBucketTransportSettings,
            settings.createBucketOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateBucketCallable =
        callableFactory.createUnaryCallable(
            updateBucketTransportSettings, settings.updateBucketSettings(), clientContext);
    this.updateBucketOperationCallable =
        callableFactory.createOperationCallable(
            updateBucketTransportSettings,
            settings.updateBucketOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.getViewCallable =
        callableFactory.createUnaryCallable(
            getViewTransportSettings, settings.getViewSettings(), clientContext);
    this.listViewsCallable =
        callableFactory.createUnaryCallable(
            listViewsTransportSettings, settings.listViewsSettings(), clientContext);
    this.listViewsPagedCallable =
        callableFactory.createPagedCallable(
            listViewsTransportSettings, settings.listViewsSettings(), clientContext);
    this.getLinkCallable =
        callableFactory.createUnaryCallable(
            getLinkTransportSettings, settings.getLinkSettings(), clientContext);
    this.listLinksCallable =
        callableFactory.createUnaryCallable(
            listLinksTransportSettings, settings.listLinksSettings(), clientContext);
    this.listLinksPagedCallable =
        callableFactory.createPagedCallable(
            listLinksTransportSettings, settings.listLinksSettings(), clientContext);
    this.createLinkCallable =
        callableFactory.createUnaryCallable(
            createLinkTransportSettings, settings.createLinkSettings(), clientContext);
    this.createLinkOperationCallable =
        callableFactory.createOperationCallable(
            createLinkTransportSettings,
            settings.createLinkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateLinkCallable =
        callableFactory.createUnaryCallable(
            updateLinkTransportSettings, settings.updateLinkSettings(), clientContext);
    this.updateLinkOperationCallable =
        callableFactory.createOperationCallable(
            updateLinkTransportSettings,
            settings.updateLinkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteLinkCallable =
        callableFactory.createUnaryCallable(
            deleteLinkTransportSettings, settings.deleteLinkSettings(), clientContext);
    this.deleteLinkOperationCallable =
        callableFactory.createOperationCallable(
            deleteLinkTransportSettings,
            settings.deleteLinkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getTraceScopeCallable =
        callableFactory.createUnaryCallable(
            getTraceScopeTransportSettings, settings.getTraceScopeSettings(), clientContext);
    this.listTraceScopesCallable =
        callableFactory.createUnaryCallable(
            listTraceScopesTransportSettings, settings.listTraceScopesSettings(), clientContext);
    this.listTraceScopesPagedCallable =
        callableFactory.createPagedCallable(
            listTraceScopesTransportSettings, settings.listTraceScopesSettings(), clientContext);
    this.createTraceScopeCallable =
        callableFactory.createUnaryCallable(
            createTraceScopeTransportSettings, settings.createTraceScopeSettings(), clientContext);
    this.updateTraceScopeCallable =
        callableFactory.createUnaryCallable(
            updateTraceScopeTransportSettings, settings.updateTraceScopeSettings(), clientContext);
    this.deleteTraceScopeCallable =
        callableFactory.createUnaryCallable(
            deleteTraceScopeTransportSettings, settings.deleteTraceScopeSettings(), clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);
    this.updateSettingsOperationCallable =
        callableFactory.createOperationCallable(
            updateSettingsTransportSettings,
            settings.updateSettingsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getScopeMethodDescriptor);
    methodDescriptors.add(updateScopeMethodDescriptor);
    methodDescriptors.add(getBucketMethodDescriptor);
    methodDescriptors.add(listBucketsMethodDescriptor);
    methodDescriptors.add(createBucketMethodDescriptor);
    methodDescriptors.add(updateBucketMethodDescriptor);
    methodDescriptors.add(getDatasetMethodDescriptor);
    methodDescriptors.add(listDatasetsMethodDescriptor);
    methodDescriptors.add(getViewMethodDescriptor);
    methodDescriptors.add(listViewsMethodDescriptor);
    methodDescriptors.add(getLinkMethodDescriptor);
    methodDescriptors.add(listLinksMethodDescriptor);
    methodDescriptors.add(createLinkMethodDescriptor);
    methodDescriptors.add(updateLinkMethodDescriptor);
    methodDescriptors.add(deleteLinkMethodDescriptor);
    methodDescriptors.add(getTraceScopeMethodDescriptor);
    methodDescriptors.add(listTraceScopesMethodDescriptor);
    methodDescriptors.add(createTraceScopeMethodDescriptor);
    methodDescriptors.add(updateTraceScopeMethodDescriptor);
    methodDescriptors.add(deleteTraceScopeMethodDescriptor);
    methodDescriptors.add(getSettingsMethodDescriptor);
    methodDescriptors.add(updateSettingsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetScopeRequest, Scope> getScopeCallable() {
    return getScopeCallable;
  }

  @Override
  public UnaryCallable<UpdateScopeRequest, Scope> updateScopeCallable() {
    return updateScopeCallable;
  }

  @Override
  public UnaryCallable<GetBucketRequest, Bucket> getBucketCallable() {
    return getBucketCallable;
  }

  @Override
  public UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable() {
    return listBucketsCallable;
  }

  @Override
  public UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse> listBucketsPagedCallable() {
    return listBucketsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateBucketRequest, Operation> createBucketCallable() {
    return createBucketCallable;
  }

  @Override
  public OperationCallable<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationCallable() {
    return createBucketOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBucketRequest, Operation> updateBucketCallable() {
    return updateBucketCallable;
  }

  @Override
  public OperationCallable<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationCallable() {
    return updateBucketOperationCallable;
  }

  @Override
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetViewRequest, View> getViewCallable() {
    return getViewCallable;
  }

  @Override
  public UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    return listViewsCallable;
  }

  @Override
  public UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    return listViewsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLinkRequest, Link> getLinkCallable() {
    return getLinkCallable;
  }

  @Override
  public UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable() {
    return listLinksCallable;
  }

  @Override
  public UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable() {
    return listLinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateLinkRequest, Operation> createLinkCallable() {
    return createLinkCallable;
  }

  @Override
  public OperationCallable<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationCallable() {
    return createLinkOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLinkRequest, Operation> updateLinkCallable() {
    return updateLinkCallable;
  }

  @Override
  public OperationCallable<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationCallable() {
    return updateLinkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable() {
    return deleteLinkCallable;
  }

  @Override
  public OperationCallable<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationCallable() {
    return deleteLinkOperationCallable;
  }

  @Override
  public UnaryCallable<GetTraceScopeRequest, TraceScope> getTraceScopeCallable() {
    return getTraceScopeCallable;
  }

  @Override
  public UnaryCallable<ListTraceScopesRequest, ListTraceScopesResponse> listTraceScopesCallable() {
    return listTraceScopesCallable;
  }

  @Override
  public UnaryCallable<ListTraceScopesRequest, ListTraceScopesPagedResponse>
      listTraceScopesPagedCallable() {
    return listTraceScopesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTraceScopeRequest, TraceScope> createTraceScopeCallable() {
    return createTraceScopeCallable;
  }

  @Override
  public UnaryCallable<UpdateTraceScopeRequest, TraceScope> updateTraceScopeCallable() {
    return updateTraceScopeCallable;
  }

  @Override
  public UnaryCallable<DeleteTraceScopeRequest, Empty> deleteTraceScopeCallable() {
    return deleteTraceScopeCallable;
  }

  @Override
  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return getSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable() {
    return updateSettingsCallable;
  }

  @Override
  public OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable() {
    return updateSettingsOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
