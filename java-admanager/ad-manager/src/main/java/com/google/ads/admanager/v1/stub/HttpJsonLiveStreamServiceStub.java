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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.LiveStreamServiceClient.ListLiveStreamsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchActivateLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchArchiveLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchArchiveLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchCreateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchCreateLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchPauseAdsLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchPauseAdsLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchPauseLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchPauseLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchRefreshMasterPlaylistsRequest;
import com.google.ads.admanager.v1.BatchRefreshMasterPlaylistsResponse;
import com.google.ads.admanager.v1.BatchUpdateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchUpdateLiveStreamsResponse;
import com.google.ads.admanager.v1.CreateLiveStreamRequest;
import com.google.ads.admanager.v1.GetLiveStreamRequest;
import com.google.ads.admanager.v1.ListLiveStreamsRequest;
import com.google.ads.admanager.v1.ListLiveStreamsResponse;
import com.google.ads.admanager.v1.LiveStream;
import com.google.ads.admanager.v1.UpdateLiveStreamRequest;
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
 * REST stub implementation for the LiveStreamService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonLiveStreamServiceStub extends LiveStreamServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLiveStreamRequest, LiveStream>
      getLiveStreamMethodDescriptor =
          ApiMethodDescriptor.<GetLiveStreamRequest, LiveStream>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LiveStreamService/GetLiveStream")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLiveStreamRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/liveStreams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLiveStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLiveStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LiveStream>newBuilder()
                      .setDefaultInstance(LiveStream.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLiveStreamsRequest, ListLiveStreamsResponse>
      listLiveStreamsMethodDescriptor =
          ApiMethodDescriptor.<ListLiveStreamsRequest, ListLiveStreamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LiveStreamService/ListLiveStreams")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLiveStreamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLiveStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLiveStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLiveStreamsResponse>newBuilder()
                      .setDefaultInstance(ListLiveStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateLiveStreamRequest, LiveStream>
      createLiveStreamMethodDescriptor =
          ApiMethodDescriptor.<CreateLiveStreamRequest, LiveStream>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LiveStreamService/CreateLiveStream")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateLiveStreamRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLiveStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLiveStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("liveStream", request.getLiveStream(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LiveStream>newBuilder()
                      .setDefaultInstance(LiveStream.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
      batchCreateLiveStreamsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LiveStreamService/BatchCreateLiveStreams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateLiveStreamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateLiveStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateLiveStreamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateLiveStreamsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateLiveStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateLiveStreamRequest, LiveStream>
      updateLiveStreamMethodDescriptor =
          ApiMethodDescriptor.<UpdateLiveStreamRequest, LiveStream>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LiveStreamService/UpdateLiveStream")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLiveStreamRequest>newBuilder()
                      .setPath(
                          "/v1/{liveStream.name=networks/*/liveStreams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLiveStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "liveStream.name", request.getLiveStream().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLiveStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("liveStream", request.getLiveStream(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LiveStream>newBuilder()
                      .setDefaultInstance(LiveStream.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
      batchUpdateLiveStreamsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LiveStreamService/BatchUpdateLiveStreams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateLiveStreamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateLiveStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateLiveStreamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateLiveStreamsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateLiveStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
      batchActivateLiveStreamsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LiveStreamService/BatchActivateLiveStreams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateLiveStreamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateLiveStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateLiveStreamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateLiveStreamsResponse>newBuilder()
                      .setDefaultInstance(BatchActivateLiveStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
      batchPauseLiveStreamsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LiveStreamService/BatchPauseLiveStreams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchPauseLiveStreamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams:batchPause",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseLiveStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseLiveStreamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchPauseLiveStreamsResponse>newBuilder()
                      .setDefaultInstance(BatchPauseLiveStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
      batchArchiveLiveStreamsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LiveStreamService/BatchArchiveLiveStreams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveLiveStreamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveLiveStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveLiveStreamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveLiveStreamsResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveLiveStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
      batchPauseAdsLiveStreamsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LiveStreamService/BatchPauseAdsLiveStreams")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchPauseAdsLiveStreamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams:batchPauseAds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseAdsLiveStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseAdsLiveStreamsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchPauseAdsLiveStreamsResponse>newBuilder()
                      .setDefaultInstance(BatchPauseAdsLiveStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
      batchRefreshMasterPlaylistsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LiveStreamService/BatchRefreshMasterPlaylists")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRefreshMasterPlaylistsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/liveStreams:batchRefreshMasterPlaylists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRefreshMasterPlaylistsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRefreshMasterPlaylistsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchRefreshMasterPlaylistsResponse>newBuilder()
                      .setDefaultInstance(BatchRefreshMasterPlaylistsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLiveStreamRequest, LiveStream> getLiveStreamCallable;
  private final UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsResponse>
      listLiveStreamsCallable;
  private final UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsPagedResponse>
      listLiveStreamsPagedCallable;
  private final UnaryCallable<CreateLiveStreamRequest, LiveStream> createLiveStreamCallable;
  private final UnaryCallable<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
      batchCreateLiveStreamsCallable;
  private final UnaryCallable<UpdateLiveStreamRequest, LiveStream> updateLiveStreamCallable;
  private final UnaryCallable<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
      batchUpdateLiveStreamsCallable;
  private final UnaryCallable<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
      batchActivateLiveStreamsCallable;
  private final UnaryCallable<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
      batchPauseLiveStreamsCallable;
  private final UnaryCallable<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
      batchArchiveLiveStreamsCallable;
  private final UnaryCallable<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
      batchPauseAdsLiveStreamsCallable;
  private final UnaryCallable<
          BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
      batchRefreshMasterPlaylistsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLiveStreamServiceStub create(LiveStreamServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLiveStreamServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLiveStreamServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLiveStreamServiceStub(
        LiveStreamServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLiveStreamServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLiveStreamServiceStub(
        LiveStreamServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLiveStreamServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLiveStreamServiceStub(
      LiveStreamServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLiveStreamServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLiveStreamServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLiveStreamServiceStub(
      LiveStreamServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLiveStreamRequest, LiveStream> getLiveStreamTransportSettings =
        HttpJsonCallSettings.<GetLiveStreamRequest, LiveStream>newBuilder()
            .setMethodDescriptor(getLiveStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListLiveStreamsRequest, ListLiveStreamsResponse>
        listLiveStreamsTransportSettings =
            HttpJsonCallSettings.<ListLiveStreamsRequest, ListLiveStreamsResponse>newBuilder()
                .setMethodDescriptor(listLiveStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateLiveStreamRequest, LiveStream> createLiveStreamTransportSettings =
        HttpJsonCallSettings.<CreateLiveStreamRequest, LiveStream>newBuilder()
            .setMethodDescriptor(createLiveStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
        batchCreateLiveStreamsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>newBuilder()
                .setMethodDescriptor(batchCreateLiveStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateLiveStreamRequest, LiveStream> updateLiveStreamTransportSettings =
        HttpJsonCallSettings.<UpdateLiveStreamRequest, LiveStream>newBuilder()
            .setMethodDescriptor(updateLiveStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "live_stream.name", String.valueOf(request.getLiveStream().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
        batchUpdateLiveStreamsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateLiveStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
        batchActivateLiveStreamsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>newBuilder()
                .setMethodDescriptor(batchActivateLiveStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
        batchPauseLiveStreamsTransportSettings =
            HttpJsonCallSettings
                .<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>newBuilder()
                .setMethodDescriptor(batchPauseLiveStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
        batchArchiveLiveStreamsTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>newBuilder()
                .setMethodDescriptor(batchArchiveLiveStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
        batchPauseAdsLiveStreamsTransportSettings =
            HttpJsonCallSettings
                .<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>newBuilder()
                .setMethodDescriptor(batchPauseAdsLiveStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
        batchRefreshMasterPlaylistsTransportSettings =
            HttpJsonCallSettings
                .<BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
                    newBuilder()
                .setMethodDescriptor(batchRefreshMasterPlaylistsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getLiveStreamCallable =
        callableFactory.createUnaryCallable(
            getLiveStreamTransportSettings, settings.getLiveStreamSettings(), clientContext);
    this.listLiveStreamsCallable =
        callableFactory.createUnaryCallable(
            listLiveStreamsTransportSettings, settings.listLiveStreamsSettings(), clientContext);
    this.listLiveStreamsPagedCallable =
        callableFactory.createPagedCallable(
            listLiveStreamsTransportSettings, settings.listLiveStreamsSettings(), clientContext);
    this.createLiveStreamCallable =
        callableFactory.createUnaryCallable(
            createLiveStreamTransportSettings, settings.createLiveStreamSettings(), clientContext);
    this.batchCreateLiveStreamsCallable =
        callableFactory.createUnaryCallable(
            batchCreateLiveStreamsTransportSettings,
            settings.batchCreateLiveStreamsSettings(),
            clientContext);
    this.updateLiveStreamCallable =
        callableFactory.createUnaryCallable(
            updateLiveStreamTransportSettings, settings.updateLiveStreamSettings(), clientContext);
    this.batchUpdateLiveStreamsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateLiveStreamsTransportSettings,
            settings.batchUpdateLiveStreamsSettings(),
            clientContext);
    this.batchActivateLiveStreamsCallable =
        callableFactory.createUnaryCallable(
            batchActivateLiveStreamsTransportSettings,
            settings.batchActivateLiveStreamsSettings(),
            clientContext);
    this.batchPauseLiveStreamsCallable =
        callableFactory.createUnaryCallable(
            batchPauseLiveStreamsTransportSettings,
            settings.batchPauseLiveStreamsSettings(),
            clientContext);
    this.batchArchiveLiveStreamsCallable =
        callableFactory.createUnaryCallable(
            batchArchiveLiveStreamsTransportSettings,
            settings.batchArchiveLiveStreamsSettings(),
            clientContext);
    this.batchPauseAdsLiveStreamsCallable =
        callableFactory.createUnaryCallable(
            batchPauseAdsLiveStreamsTransportSettings,
            settings.batchPauseAdsLiveStreamsSettings(),
            clientContext);
    this.batchRefreshMasterPlaylistsCallable =
        callableFactory.createUnaryCallable(
            batchRefreshMasterPlaylistsTransportSettings,
            settings.batchRefreshMasterPlaylistsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLiveStreamMethodDescriptor);
    methodDescriptors.add(listLiveStreamsMethodDescriptor);
    methodDescriptors.add(createLiveStreamMethodDescriptor);
    methodDescriptors.add(batchCreateLiveStreamsMethodDescriptor);
    methodDescriptors.add(updateLiveStreamMethodDescriptor);
    methodDescriptors.add(batchUpdateLiveStreamsMethodDescriptor);
    methodDescriptors.add(batchActivateLiveStreamsMethodDescriptor);
    methodDescriptors.add(batchPauseLiveStreamsMethodDescriptor);
    methodDescriptors.add(batchArchiveLiveStreamsMethodDescriptor);
    methodDescriptors.add(batchPauseAdsLiveStreamsMethodDescriptor);
    methodDescriptors.add(batchRefreshMasterPlaylistsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLiveStreamRequest, LiveStream> getLiveStreamCallable() {
    return getLiveStreamCallable;
  }

  @Override
  public UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsResponse> listLiveStreamsCallable() {
    return listLiveStreamsCallable;
  }

  @Override
  public UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsPagedResponse>
      listLiveStreamsPagedCallable() {
    return listLiveStreamsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateLiveStreamRequest, LiveStream> createLiveStreamCallable() {
    return createLiveStreamCallable;
  }

  @Override
  public UnaryCallable<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
      batchCreateLiveStreamsCallable() {
    return batchCreateLiveStreamsCallable;
  }

  @Override
  public UnaryCallable<UpdateLiveStreamRequest, LiveStream> updateLiveStreamCallable() {
    return updateLiveStreamCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
      batchUpdateLiveStreamsCallable() {
    return batchUpdateLiveStreamsCallable;
  }

  @Override
  public UnaryCallable<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
      batchActivateLiveStreamsCallable() {
    return batchActivateLiveStreamsCallable;
  }

  @Override
  public UnaryCallable<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
      batchPauseLiveStreamsCallable() {
    return batchPauseLiveStreamsCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
      batchArchiveLiveStreamsCallable() {
    return batchArchiveLiveStreamsCallable;
  }

  @Override
  public UnaryCallable<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
      batchPauseAdsLiveStreamsCallable() {
    return batchPauseAdsLiveStreamsCallable;
  }

  @Override
  public UnaryCallable<BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
      batchRefreshMasterPlaylistsCallable() {
    return batchRefreshMasterPlaylistsCallable;
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
