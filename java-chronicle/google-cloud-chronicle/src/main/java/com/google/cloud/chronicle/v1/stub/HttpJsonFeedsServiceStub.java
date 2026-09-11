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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedPacksPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedSourceTypeSchemasPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedsPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListLogTypeSchemasPagedResponse;

import com.google.api.HttpBody;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.CreateFeedRequest;
import com.google.cloud.chronicle.v1.DeleteFeedRequest;
import com.google.cloud.chronicle.v1.DisableFeedRequest;
import com.google.cloud.chronicle.v1.EnableFeedRequest;
import com.google.cloud.chronicle.v1.Feed;
import com.google.cloud.chronicle.v1.FeedPack;
import com.google.cloud.chronicle.v1.FeedServiceAccount;
import com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest;
import com.google.cloud.chronicle.v1.GenerateSecretRequest;
import com.google.cloud.chronicle.v1.GenerateSecretResponse;
import com.google.cloud.chronicle.v1.GetFeedPackRequest;
import com.google.cloud.chronicle.v1.GetFeedRequest;
import com.google.cloud.chronicle.v1.ImportPushLogsRequest;
import com.google.cloud.chronicle.v1.ListFeedPacksRequest;
import com.google.cloud.chronicle.v1.ListFeedPacksResponse;
import com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest;
import com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse;
import com.google.cloud.chronicle.v1.ListFeedsRequest;
import com.google.cloud.chronicle.v1.ListFeedsResponse;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse;
import com.google.cloud.chronicle.v1.UpdateFeedRequest;
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
 * REST stub implementation for the FeedsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonFeedsServiceStub extends FeedsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerMethodDescriptor =
          ApiMethodDescriptor
              .<FetchServiceAccountForCustomerRequest, FeedServiceAccount>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FeedsService/FetchServiceAccountForCustomer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchServiceAccountForCustomerRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/feedServiceAccounts:fetchServiceAccountForCustomer",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchServiceAccountForCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchServiceAccountForCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FeedServiceAccount>newBuilder()
                      .setDefaultInstance(FeedServiceAccount.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFeedRequest, Feed> createFeedMethodDescriptor =
      ApiMethodDescriptor.<CreateFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/CreateFeed")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/instances/*}/feeds",
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("feed", request.getFeed(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetFeedRequest, Feed> getFeedMethodDescriptor =
      ApiMethodDescriptor.<GetFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/GetFeed")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/feeds/*}",
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<DeleteFeedRequest, Empty> deleteFeedMethodDescriptor =
      ApiMethodDescriptor.<DeleteFeedRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/DeleteFeed")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/feeds/*}",
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
                        serializer.putQueryParam(
                            fields, "deleteBacklog", request.getDeleteBacklog());
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

  private static final ApiMethodDescriptor<EnableFeedRequest, Feed> enableFeedMethodDescriptor =
      ApiMethodDescriptor.<EnableFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/EnableFeed")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<EnableFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/feeds/*}:enable",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<EnableFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<EnableFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DisableFeedRequest, Feed> disableFeedMethodDescriptor =
      ApiMethodDescriptor.<DisableFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/DisableFeed")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DisableFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/feeds/*}:disable",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DisableFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DisableFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), true))
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
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ListFeeds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFeedsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/feeds",
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
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<ListFeedPacksRequest, ListFeedPacksResponse>
      listFeedPacksMethodDescriptor =
          ApiMethodDescriptor.<ListFeedPacksRequest, ListFeedPacksResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ListFeedPacks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFeedPacksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/feedPacks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedPacksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedPacksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFeedPacksResponse>newBuilder()
                      .setDefaultInstance(ListFeedPacksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFeedPackRequest, FeedPack>
      getFeedPackMethodDescriptor =
          ApiMethodDescriptor.<GetFeedPackRequest, FeedPack>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/GetFeedPack")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFeedPackRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/feedPacks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFeedPackRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFeedPackRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FeedPack>newBuilder()
                      .setDefaultInstance(FeedPack.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateFeedRequest, Feed> updateFeedMethodDescriptor =
      ApiMethodDescriptor.<UpdateFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.FeedsService/UpdateFeed")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateFeedRequest>newBuilder()
                  .setPath(
                      "/v1/{feed.name=projects/*/locations/*/instances/*/feeds/*}",
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
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("feed", request.getFeed(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
      listFeedSourceTypeSchemasMethodDescriptor =
          ApiMethodDescriptor
              .<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ListFeedSourceTypeSchemas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFeedSourceTypeSchemasRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/feedSourceTypeSchemas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedSourceTypeSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedSourceTypeSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFeedSourceTypeSchemasResponse>newBuilder()
                      .setDefaultInstance(ListFeedSourceTypeSchemasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
      listLogTypeSchemasMethodDescriptor =
          ApiMethodDescriptor.<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ListLogTypeSchemas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLogTypeSchemasRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/feedSourceTypeSchemas/*}/logTypeSchemas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLogTypeSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLogTypeSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLogTypeSchemasResponse>newBuilder()
                      .setDefaultInstance(ListLogTypeSchemasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportPushLogsRequest, HttpBody>
      importPushLogsMethodDescriptor =
          ApiMethodDescriptor.<ImportPushLogsRequest, HttpBody>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/ImportPushLogs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportPushLogsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/feeds/*}:importPushLogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportPushLogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportPushLogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpBody>newBuilder()
                      .setDefaultInstance(HttpBody.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateSecretRequest, GenerateSecretResponse>
      generateSecretMethodDescriptor =
          ApiMethodDescriptor.<GenerateSecretRequest, GenerateSecretResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.FeedsService/GenerateSecret")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/feeds/*}:generateSecret",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateSecretResponse>newBuilder()
                      .setDefaultInstance(GenerateSecretResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerCallable;
  private final UnaryCallable<CreateFeedRequest, Feed> createFeedCallable;
  private final UnaryCallable<GetFeedRequest, Feed> getFeedCallable;
  private final UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable;
  private final UnaryCallable<EnableFeedRequest, Feed> enableFeedCallable;
  private final UnaryCallable<DisableFeedRequest, Feed> disableFeedCallable;
  private final UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable;
  private final UnaryCallable<ListFeedsRequest, ListFeedsPagedResponse> listFeedsPagedCallable;
  private final UnaryCallable<ListFeedPacksRequest, ListFeedPacksResponse> listFeedPacksCallable;
  private final UnaryCallable<ListFeedPacksRequest, ListFeedPacksPagedResponse>
      listFeedPacksPagedCallable;
  private final UnaryCallable<GetFeedPackRequest, FeedPack> getFeedPackCallable;
  private final UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable;
  private final UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
      listFeedSourceTypeSchemasCallable;
  private final UnaryCallable<
          ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasPagedCallable;
  private final UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
      listLogTypeSchemasCallable;
  private final UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasPagedCallable;
  private final UnaryCallable<ImportPushLogsRequest, HttpBody> importPushLogsCallable;
  private final UnaryCallable<GenerateSecretRequest, GenerateSecretResponse> generateSecretCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFeedsServiceStub create(FeedsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonFeedsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFeedsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonFeedsServiceStub(
        FeedsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFeedsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFeedsServiceStub(
        FeedsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFeedsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFeedsServiceStub(FeedsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFeedsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFeedsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFeedsServiceStub(
      FeedsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
        fetchServiceAccountForCustomerTransportSettings =
            HttpJsonCallSettings
                .<FetchServiceAccountForCustomerRequest, FeedServiceAccount>newBuilder()
                .setMethodDescriptor(fetchServiceAccountForCustomerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateFeedRequest, Feed> createFeedTransportSettings =
        HttpJsonCallSettings.<CreateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(createFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetFeedRequest, Feed> getFeedTransportSettings =
        HttpJsonCallSettings.<GetFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(getFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DeleteFeedRequest, Empty> deleteFeedTransportSettings =
        HttpJsonCallSettings.<DeleteFeedRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<EnableFeedRequest, Feed> enableFeedTransportSettings =
        HttpJsonCallSettings.<EnableFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(enableFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DisableFeedRequest, Feed> disableFeedTransportSettings =
        HttpJsonCallSettings.<DisableFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(disableFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsTransportSettings =
        HttpJsonCallSettings.<ListFeedsRequest, ListFeedsResponse>newBuilder()
            .setMethodDescriptor(listFeedsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<ListFeedPacksRequest, ListFeedPacksResponse>
        listFeedPacksTransportSettings =
            HttpJsonCallSettings.<ListFeedPacksRequest, ListFeedPacksResponse>newBuilder()
                .setMethodDescriptor(listFeedPacksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetFeedPackRequest, FeedPack> getFeedPackTransportSettings =
        HttpJsonCallSettings.<GetFeedPackRequest, FeedPack>newBuilder()
            .setMethodDescriptor(getFeedPackMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateFeedRequest, Feed> updateFeedTransportSettings =
        HttpJsonCallSettings.<UpdateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(updateFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("feed.name", String.valueOf(request.getFeed().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
        listFeedSourceTypeSchemasTransportSettings =
            HttpJsonCallSettings
                .<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>newBuilder()
                .setMethodDescriptor(listFeedSourceTypeSchemasMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
        listLogTypeSchemasTransportSettings =
            HttpJsonCallSettings.<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>newBuilder()
                .setMethodDescriptor(listLogTypeSchemasMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<ImportPushLogsRequest, HttpBody> importPushLogsTransportSettings =
        HttpJsonCallSettings.<ImportPushLogsRequest, HttpBody>newBuilder()
            .setMethodDescriptor(importPushLogsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GenerateSecretRequest, GenerateSecretResponse>
        generateSecretTransportSettings =
            HttpJsonCallSettings.<GenerateSecretRequest, GenerateSecretResponse>newBuilder()
                .setMethodDescriptor(generateSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.fetchServiceAccountForCustomerCallable =
        callableFactory.createUnaryCallable(
            fetchServiceAccountForCustomerTransportSettings,
            settings.fetchServiceAccountForCustomerSettings(),
            clientContext);
    this.createFeedCallable =
        callableFactory.createUnaryCallable(
            createFeedTransportSettings, settings.createFeedSettings(), clientContext);
    this.getFeedCallable =
        callableFactory.createUnaryCallable(
            getFeedTransportSettings, settings.getFeedSettings(), clientContext);
    this.deleteFeedCallable =
        callableFactory.createUnaryCallable(
            deleteFeedTransportSettings, settings.deleteFeedSettings(), clientContext);
    this.enableFeedCallable =
        callableFactory.createUnaryCallable(
            enableFeedTransportSettings, settings.enableFeedSettings(), clientContext);
    this.disableFeedCallable =
        callableFactory.createUnaryCallable(
            disableFeedTransportSettings, settings.disableFeedSettings(), clientContext);
    this.listFeedsCallable =
        callableFactory.createUnaryCallable(
            listFeedsTransportSettings, settings.listFeedsSettings(), clientContext);
    this.listFeedsPagedCallable =
        callableFactory.createPagedCallable(
            listFeedsTransportSettings, settings.listFeedsSettings(), clientContext);
    this.listFeedPacksCallable =
        callableFactory.createUnaryCallable(
            listFeedPacksTransportSettings, settings.listFeedPacksSettings(), clientContext);
    this.listFeedPacksPagedCallable =
        callableFactory.createPagedCallable(
            listFeedPacksTransportSettings, settings.listFeedPacksSettings(), clientContext);
    this.getFeedPackCallable =
        callableFactory.createUnaryCallable(
            getFeedPackTransportSettings, settings.getFeedPackSettings(), clientContext);
    this.updateFeedCallable =
        callableFactory.createUnaryCallable(
            updateFeedTransportSettings, settings.updateFeedSettings(), clientContext);
    this.listFeedSourceTypeSchemasCallable =
        callableFactory.createUnaryCallable(
            listFeedSourceTypeSchemasTransportSettings,
            settings.listFeedSourceTypeSchemasSettings(),
            clientContext);
    this.listFeedSourceTypeSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listFeedSourceTypeSchemasTransportSettings,
            settings.listFeedSourceTypeSchemasSettings(),
            clientContext);
    this.listLogTypeSchemasCallable =
        callableFactory.createUnaryCallable(
            listLogTypeSchemasTransportSettings,
            settings.listLogTypeSchemasSettings(),
            clientContext);
    this.listLogTypeSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listLogTypeSchemasTransportSettings,
            settings.listLogTypeSchemasSettings(),
            clientContext);
    this.importPushLogsCallable =
        callableFactory.createUnaryCallable(
            importPushLogsTransportSettings, settings.importPushLogsSettings(), clientContext);
    this.generateSecretCallable =
        callableFactory.createUnaryCallable(
            generateSecretTransportSettings, settings.generateSecretSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(fetchServiceAccountForCustomerMethodDescriptor);
    methodDescriptors.add(createFeedMethodDescriptor);
    methodDescriptors.add(getFeedMethodDescriptor);
    methodDescriptors.add(deleteFeedMethodDescriptor);
    methodDescriptors.add(enableFeedMethodDescriptor);
    methodDescriptors.add(disableFeedMethodDescriptor);
    methodDescriptors.add(listFeedsMethodDescriptor);
    methodDescriptors.add(listFeedPacksMethodDescriptor);
    methodDescriptors.add(getFeedPackMethodDescriptor);
    methodDescriptors.add(updateFeedMethodDescriptor);
    methodDescriptors.add(listFeedSourceTypeSchemasMethodDescriptor);
    methodDescriptors.add(listLogTypeSchemasMethodDescriptor);
    methodDescriptors.add(importPushLogsMethodDescriptor);
    methodDescriptors.add(generateSecretMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerCallable() {
    return fetchServiceAccountForCustomerCallable;
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
  public UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    return deleteFeedCallable;
  }

  @Override
  public UnaryCallable<EnableFeedRequest, Feed> enableFeedCallable() {
    return enableFeedCallable;
  }

  @Override
  public UnaryCallable<DisableFeedRequest, Feed> disableFeedCallable() {
    return disableFeedCallable;
  }

  @Override
  public UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    return listFeedsCallable;
  }

  @Override
  public UnaryCallable<ListFeedsRequest, ListFeedsPagedResponse> listFeedsPagedCallable() {
    return listFeedsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFeedPacksRequest, ListFeedPacksResponse> listFeedPacksCallable() {
    return listFeedPacksCallable;
  }

  @Override
  public UnaryCallable<ListFeedPacksRequest, ListFeedPacksPagedResponse>
      listFeedPacksPagedCallable() {
    return listFeedPacksPagedCallable;
  }

  @Override
  public UnaryCallable<GetFeedPackRequest, FeedPack> getFeedPackCallable() {
    return getFeedPackCallable;
  }

  @Override
  public UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    return updateFeedCallable;
  }

  @Override
  public UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
      listFeedSourceTypeSchemasCallable() {
    return listFeedSourceTypeSchemasCallable;
  }

  @Override
  public UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasPagedCallable() {
    return listFeedSourceTypeSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
      listLogTypeSchemasCallable() {
    return listLogTypeSchemasCallable;
  }

  @Override
  public UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasPagedCallable() {
    return listLogTypeSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<ImportPushLogsRequest, HttpBody> importPushLogsCallable() {
    return importPushLogsCallable;
  }

  @Override
  public UnaryCallable<GenerateSecretRequest, GenerateSecretResponse> generateSecretCallable() {
    return generateSecretCallable;
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
