/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.StreamsServiceClient.ListClustersPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListEventsPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListSeriesPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListStreamsPagedResponse;

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
import com.google.cloud.visionai.v1.Channel;
import com.google.cloud.visionai.v1.Cluster;
import com.google.cloud.visionai.v1.CreateClusterRequest;
import com.google.cloud.visionai.v1.CreateEventRequest;
import com.google.cloud.visionai.v1.CreateSeriesRequest;
import com.google.cloud.visionai.v1.CreateStreamRequest;
import com.google.cloud.visionai.v1.DeleteClusterRequest;
import com.google.cloud.visionai.v1.DeleteEventRequest;
import com.google.cloud.visionai.v1.DeleteSeriesRequest;
import com.google.cloud.visionai.v1.DeleteStreamRequest;
import com.google.cloud.visionai.v1.Event;
import com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest;
import com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse;
import com.google.cloud.visionai.v1.GetClusterRequest;
import com.google.cloud.visionai.v1.GetEventRequest;
import com.google.cloud.visionai.v1.GetSeriesRequest;
import com.google.cloud.visionai.v1.GetStreamRequest;
import com.google.cloud.visionai.v1.GetStreamThumbnailRequest;
import com.google.cloud.visionai.v1.GetStreamThumbnailResponse;
import com.google.cloud.visionai.v1.ListClustersRequest;
import com.google.cloud.visionai.v1.ListClustersResponse;
import com.google.cloud.visionai.v1.ListEventsRequest;
import com.google.cloud.visionai.v1.ListEventsResponse;
import com.google.cloud.visionai.v1.ListSeriesRequest;
import com.google.cloud.visionai.v1.ListSeriesResponse;
import com.google.cloud.visionai.v1.ListStreamsRequest;
import com.google.cloud.visionai.v1.ListStreamsResponse;
import com.google.cloud.visionai.v1.MaterializeChannelRequest;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Series;
import com.google.cloud.visionai.v1.Stream;
import com.google.cloud.visionai.v1.UpdateClusterRequest;
import com.google.cloud.visionai.v1.UpdateEventRequest;
import com.google.cloud.visionai.v1.UpdateSeriesRequest;
import com.google.cloud.visionai.v1.UpdateStreamRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the StreamsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonStreamsServiceStub extends StreamsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Stream.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Channel.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Cluster.getDescriptor())
          .add(GetStreamThumbnailResponse.getDescriptor())
          .add(Series.getDescriptor())
          .add(Event.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          ApiMethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/ListClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/clusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListClustersResponse>newBuilder()
                      .setDefaultInstance(ListClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      ApiMethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetCluster")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetClusterRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/clusters/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetClusterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetClusterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Cluster>newBuilder()
                  .setDefaultInstance(Cluster.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/CreateCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/clusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "clusterId", request.getClusterId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cluster", request.getCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/UpdateCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{cluster.name=projects/*/locations/*/clusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "cluster.name", request.getCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cluster", request.getCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/DeleteCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListStreamsRequest, ListStreamsResponse>
      listStreamsMethodDescriptor =
          ApiMethodDescriptor.<ListStreamsRequest, ListStreamsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/ListStreams")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListStreamsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/streams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListStreamsResponse>newBuilder()
                      .setDefaultInstance(ListStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetStreamRequest, Stream> getStreamMethodDescriptor =
      ApiMethodDescriptor.<GetStreamRequest, Stream>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetStream")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetStreamRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/clusters/*/streams/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetStreamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetStreamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Stream>newBuilder()
                  .setDefaultInstance(Stream.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateStreamRequest, Operation>
      createStreamMethodDescriptor =
          ApiMethodDescriptor.<CreateStreamRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/CreateStream")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateStreamRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/streams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "streamId", request.getStreamId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("stream", request.getStream(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateStreamRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateStreamRequest, Operation>
      updateStreamMethodDescriptor =
          ApiMethodDescriptor.<UpdateStreamRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/UpdateStream")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateStreamRequest>newBuilder()
                      .setPath(
                          "/v1/{stream.name=projects/*/locations/*/clusters/*/streams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "stream.name", request.getStream().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("stream", request.getStream(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateStreamRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteStreamRequest, Operation>
      deleteStreamMethodDescriptor =
          ApiMethodDescriptor.<DeleteStreamRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/DeleteStream")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteStreamRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/streams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteStreamRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetStreamThumbnailRequest, Operation>
      getStreamThumbnailMethodDescriptor =
          ApiMethodDescriptor.<GetStreamThumbnailRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetStreamThumbnail")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetStreamThumbnailRequest>newBuilder()
                      .setPath(
                          "/v1/{stream=projects/*/locations/*/clusters/*/streams/*}:getThumbnail",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetStreamThumbnailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "stream", request.getStream());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetStreamThumbnailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearStream().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GetStreamThumbnailRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/GenerateStreamHlsToken")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateStreamHlsTokenRequest>newBuilder()
                      .setPath(
                          "/v1/{stream=projects/*/locations/*/clusters/*/streams/*}:generateStreamHlsToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateStreamHlsTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "stream", request.getStream());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateStreamHlsTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearStream().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateStreamHlsTokenResponse>newBuilder()
                      .setDefaultInstance(GenerateStreamHlsTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEventsRequest, ListEventsResponse>
      listEventsMethodDescriptor =
          ApiMethodDescriptor.<ListEventsRequest, ListEventsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/ListEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEventsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/events",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEventsResponse>newBuilder()
                      .setDefaultInstance(ListEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEventRequest, Event> getEventMethodDescriptor =
      ApiMethodDescriptor.<GetEventRequest, Event>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetEvent")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetEventRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/clusters/*/events/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetEventRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetEventRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Event>newBuilder()
                  .setDefaultInstance(Event.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateEventRequest, Operation>
      createEventMethodDescriptor =
          ApiMethodDescriptor.<CreateEventRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/CreateEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEventRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/events",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "eventId", request.getEventId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("event", request.getEvent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEventRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEventRequest, Operation>
      updateEventMethodDescriptor =
          ApiMethodDescriptor.<UpdateEventRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/UpdateEvent")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEventRequest>newBuilder()
                      .setPath(
                          "/v1/{event.name=projects/*/locations/*/clusters/*/events/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "event.name", request.getEvent().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("event", request.getEvent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEventRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEventRequest, Operation>
      deleteEventMethodDescriptor =
          ApiMethodDescriptor.<DeleteEventRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/DeleteEvent")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEventRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/events/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteEventRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListSeriesRequest, ListSeriesResponse>
      listSeriesMethodDescriptor =
          ApiMethodDescriptor.<ListSeriesRequest, ListSeriesResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/ListSeries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSeriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/series",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSeriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSeriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSeriesResponse>newBuilder()
                      .setDefaultInstance(ListSeriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSeriesRequest, Series> getSeriesMethodDescriptor =
      ApiMethodDescriptor.<GetSeriesRequest, Series>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetSeries")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSeriesRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/clusters/*/series/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSeriesRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSeriesRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Series>newBuilder()
                  .setDefaultInstance(Series.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateSeriesRequest, Operation>
      createSeriesMethodDescriptor =
          ApiMethodDescriptor.<CreateSeriesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/CreateSeries")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSeriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/series",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSeriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSeriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "seriesId", request.getSeriesId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("series", request.getSeries(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSeriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateSeriesRequest, Operation>
      updateSeriesMethodDescriptor =
          ApiMethodDescriptor.<UpdateSeriesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/UpdateSeries")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSeriesRequest>newBuilder()
                      .setPath(
                          "/v1/{series.name=projects/*/locations/*/clusters/*/series/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSeriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "series.name", request.getSeries().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSeriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("series", request.getSeries(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSeriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSeriesRequest, Operation>
      deleteSeriesMethodDescriptor =
          ApiMethodDescriptor.<DeleteSeriesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/DeleteSeries")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSeriesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/series/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSeriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSeriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteSeriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<MaterializeChannelRequest, Operation>
      materializeChannelMethodDescriptor =
          ApiMethodDescriptor.<MaterializeChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/MaterializeChannel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MaterializeChannelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/channels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MaterializeChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MaterializeChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "channelId", request.getChannelId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("channel", request.getChannel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (MaterializeChannelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable;
  private final UnaryCallable<ListStreamsRequest, ListStreamsResponse> listStreamsCallable;
  private final UnaryCallable<ListStreamsRequest, ListStreamsPagedResponse>
      listStreamsPagedCallable;
  private final UnaryCallable<GetStreamRequest, Stream> getStreamCallable;
  private final UnaryCallable<CreateStreamRequest, Operation> createStreamCallable;
  private final OperationCallable<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationCallable;
  private final UnaryCallable<UpdateStreamRequest, Operation> updateStreamCallable;
  private final OperationCallable<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationCallable;
  private final UnaryCallable<DeleteStreamRequest, Operation> deleteStreamCallable;
  private final OperationCallable<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationCallable;
  private final UnaryCallable<GetStreamThumbnailRequest, Operation> getStreamThumbnailCallable;
  private final OperationCallable<
          GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailOperationCallable;
  private final UnaryCallable<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable;
  private final UnaryCallable<GetEventRequest, Event> getEventCallable;
  private final UnaryCallable<CreateEventRequest, Operation> createEventCallable;
  private final OperationCallable<CreateEventRequest, Event, OperationMetadata>
      createEventOperationCallable;
  private final UnaryCallable<UpdateEventRequest, Operation> updateEventCallable;
  private final OperationCallable<UpdateEventRequest, Event, OperationMetadata>
      updateEventOperationCallable;
  private final UnaryCallable<DeleteEventRequest, Operation> deleteEventCallable;
  private final OperationCallable<DeleteEventRequest, Empty, OperationMetadata>
      deleteEventOperationCallable;
  private final UnaryCallable<ListSeriesRequest, ListSeriesResponse> listSeriesCallable;
  private final UnaryCallable<ListSeriesRequest, ListSeriesPagedResponse> listSeriesPagedCallable;
  private final UnaryCallable<GetSeriesRequest, Series> getSeriesCallable;
  private final UnaryCallable<CreateSeriesRequest, Operation> createSeriesCallable;
  private final OperationCallable<CreateSeriesRequest, Series, OperationMetadata>
      createSeriesOperationCallable;
  private final UnaryCallable<UpdateSeriesRequest, Operation> updateSeriesCallable;
  private final OperationCallable<UpdateSeriesRequest, Series, OperationMetadata>
      updateSeriesOperationCallable;
  private final UnaryCallable<DeleteSeriesRequest, Operation> deleteSeriesCallable;
  private final OperationCallable<DeleteSeriesRequest, Empty, OperationMetadata>
      deleteSeriesOperationCallable;
  private final UnaryCallable<MaterializeChannelRequest, Operation> materializeChannelCallable;
  private final OperationCallable<MaterializeChannelRequest, Channel, OperationMetadata>
      materializeChannelOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonStreamsServiceStub create(StreamsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonStreamsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonStreamsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonStreamsServiceStub(
        StreamsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonStreamsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonStreamsServiceStub(
        StreamsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonStreamsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStreamsServiceStub(
      StreamsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonStreamsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonStreamsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStreamsServiceStub(
      StreamsServiceStubSettings settings,
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
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/warehouseOperations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/assets/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/imageIndexes/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/indexes/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/corpora/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/indexEndpoints/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        HttpJsonCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        HttpJsonCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        HttpJsonCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        HttpJsonCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster.name", String.valueOf(request.getCluster().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        HttpJsonCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListStreamsRequest, ListStreamsResponse> listStreamsTransportSettings =
        HttpJsonCallSettings.<ListStreamsRequest, ListStreamsResponse>newBuilder()
            .setMethodDescriptor(listStreamsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetStreamRequest, Stream> getStreamTransportSettings =
        HttpJsonCallSettings.<GetStreamRequest, Stream>newBuilder()
            .setMethodDescriptor(getStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateStreamRequest, Operation> createStreamTransportSettings =
        HttpJsonCallSettings.<CreateStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(createStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateStreamRequest, Operation> updateStreamTransportSettings =
        HttpJsonCallSettings.<UpdateStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(updateStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("stream.name", String.valueOf(request.getStream().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteStreamRequest, Operation> deleteStreamTransportSettings =
        HttpJsonCallSettings.<DeleteStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetStreamThumbnailRequest, Operation> getStreamThumbnailTransportSettings =
        HttpJsonCallSettings.<GetStreamThumbnailRequest, Operation>newBuilder()
            .setMethodDescriptor(getStreamThumbnailMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("stream", String.valueOf(request.getStream()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
        generateStreamHlsTokenTransportSettings =
            HttpJsonCallSettings
                .<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>newBuilder()
                .setMethodDescriptor(generateStreamHlsTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("stream", String.valueOf(request.getStream()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEventsRequest, ListEventsResponse> listEventsTransportSettings =
        HttpJsonCallSettings.<ListEventsRequest, ListEventsResponse>newBuilder()
            .setMethodDescriptor(listEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEventRequest, Event> getEventTransportSettings =
        HttpJsonCallSettings.<GetEventRequest, Event>newBuilder()
            .setMethodDescriptor(getEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEventRequest, Operation> createEventTransportSettings =
        HttpJsonCallSettings.<CreateEventRequest, Operation>newBuilder()
            .setMethodDescriptor(createEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEventRequest, Operation> updateEventTransportSettings =
        HttpJsonCallSettings.<UpdateEventRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("event.name", String.valueOf(request.getEvent().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEventRequest, Operation> deleteEventTransportSettings =
        HttpJsonCallSettings.<DeleteEventRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSeriesRequest, ListSeriesResponse> listSeriesTransportSettings =
        HttpJsonCallSettings.<ListSeriesRequest, ListSeriesResponse>newBuilder()
            .setMethodDescriptor(listSeriesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSeriesRequest, Series> getSeriesTransportSettings =
        HttpJsonCallSettings.<GetSeriesRequest, Series>newBuilder()
            .setMethodDescriptor(getSeriesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSeriesRequest, Operation> createSeriesTransportSettings =
        HttpJsonCallSettings.<CreateSeriesRequest, Operation>newBuilder()
            .setMethodDescriptor(createSeriesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSeriesRequest, Operation> updateSeriesTransportSettings =
        HttpJsonCallSettings.<UpdateSeriesRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSeriesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("series.name", String.valueOf(request.getSeries().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSeriesRequest, Operation> deleteSeriesTransportSettings =
        HttpJsonCallSettings.<DeleteSeriesRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSeriesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<MaterializeChannelRequest, Operation> materializeChannelTransportSettings =
        HttpJsonCallSettings.<MaterializeChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(materializeChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.listClustersCallable =
        callableFactory.createUnaryCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.listClustersPagedCallable =
        callableFactory.createPagedCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.createClusterOperationCallable =
        callableFactory.createOperationCallable(
            createClusterTransportSettings,
            settings.createClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateClusterTransportSettings,
            settings.updateClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.deleteClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteClusterTransportSettings,
            settings.deleteClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listStreamsCallable =
        callableFactory.createUnaryCallable(
            listStreamsTransportSettings, settings.listStreamsSettings(), clientContext);
    this.listStreamsPagedCallable =
        callableFactory.createPagedCallable(
            listStreamsTransportSettings, settings.listStreamsSettings(), clientContext);
    this.getStreamCallable =
        callableFactory.createUnaryCallable(
            getStreamTransportSettings, settings.getStreamSettings(), clientContext);
    this.createStreamCallable =
        callableFactory.createUnaryCallable(
            createStreamTransportSettings, settings.createStreamSettings(), clientContext);
    this.createStreamOperationCallable =
        callableFactory.createOperationCallable(
            createStreamTransportSettings,
            settings.createStreamOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateStreamCallable =
        callableFactory.createUnaryCallable(
            updateStreamTransportSettings, settings.updateStreamSettings(), clientContext);
    this.updateStreamOperationCallable =
        callableFactory.createOperationCallable(
            updateStreamTransportSettings,
            settings.updateStreamOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteStreamCallable =
        callableFactory.createUnaryCallable(
            deleteStreamTransportSettings, settings.deleteStreamSettings(), clientContext);
    this.deleteStreamOperationCallable =
        callableFactory.createOperationCallable(
            deleteStreamTransportSettings,
            settings.deleteStreamOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getStreamThumbnailCallable =
        callableFactory.createUnaryCallable(
            getStreamThumbnailTransportSettings,
            settings.getStreamThumbnailSettings(),
            clientContext);
    this.getStreamThumbnailOperationCallable =
        callableFactory.createOperationCallable(
            getStreamThumbnailTransportSettings,
            settings.getStreamThumbnailOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateStreamHlsTokenCallable =
        callableFactory.createUnaryCallable(
            generateStreamHlsTokenTransportSettings,
            settings.generateStreamHlsTokenSettings(),
            clientContext);
    this.listEventsCallable =
        callableFactory.createUnaryCallable(
            listEventsTransportSettings, settings.listEventsSettings(), clientContext);
    this.listEventsPagedCallable =
        callableFactory.createPagedCallable(
            listEventsTransportSettings, settings.listEventsSettings(), clientContext);
    this.getEventCallable =
        callableFactory.createUnaryCallable(
            getEventTransportSettings, settings.getEventSettings(), clientContext);
    this.createEventCallable =
        callableFactory.createUnaryCallable(
            createEventTransportSettings, settings.createEventSettings(), clientContext);
    this.createEventOperationCallable =
        callableFactory.createOperationCallable(
            createEventTransportSettings,
            settings.createEventOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEventCallable =
        callableFactory.createUnaryCallable(
            updateEventTransportSettings, settings.updateEventSettings(), clientContext);
    this.updateEventOperationCallable =
        callableFactory.createOperationCallable(
            updateEventTransportSettings,
            settings.updateEventOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEventCallable =
        callableFactory.createUnaryCallable(
            deleteEventTransportSettings, settings.deleteEventSettings(), clientContext);
    this.deleteEventOperationCallable =
        callableFactory.createOperationCallable(
            deleteEventTransportSettings,
            settings.deleteEventOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listSeriesCallable =
        callableFactory.createUnaryCallable(
            listSeriesTransportSettings, settings.listSeriesSettings(), clientContext);
    this.listSeriesPagedCallable =
        callableFactory.createPagedCallable(
            listSeriesTransportSettings, settings.listSeriesSettings(), clientContext);
    this.getSeriesCallable =
        callableFactory.createUnaryCallable(
            getSeriesTransportSettings, settings.getSeriesSettings(), clientContext);
    this.createSeriesCallable =
        callableFactory.createUnaryCallable(
            createSeriesTransportSettings, settings.createSeriesSettings(), clientContext);
    this.createSeriesOperationCallable =
        callableFactory.createOperationCallable(
            createSeriesTransportSettings,
            settings.createSeriesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateSeriesCallable =
        callableFactory.createUnaryCallable(
            updateSeriesTransportSettings, settings.updateSeriesSettings(), clientContext);
    this.updateSeriesOperationCallable =
        callableFactory.createOperationCallable(
            updateSeriesTransportSettings,
            settings.updateSeriesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteSeriesCallable =
        callableFactory.createUnaryCallable(
            deleteSeriesTransportSettings, settings.deleteSeriesSettings(), clientContext);
    this.deleteSeriesOperationCallable =
        callableFactory.createOperationCallable(
            deleteSeriesTransportSettings,
            settings.deleteSeriesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.materializeChannelCallable =
        callableFactory.createUnaryCallable(
            materializeChannelTransportSettings,
            settings.materializeChannelSettings(),
            clientContext);
    this.materializeChannelOperationCallable =
        callableFactory.createOperationCallable(
            materializeChannelTransportSettings,
            settings.materializeChannelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listClustersMethodDescriptor);
    methodDescriptors.add(getClusterMethodDescriptor);
    methodDescriptors.add(createClusterMethodDescriptor);
    methodDescriptors.add(updateClusterMethodDescriptor);
    methodDescriptors.add(deleteClusterMethodDescriptor);
    methodDescriptors.add(listStreamsMethodDescriptor);
    methodDescriptors.add(getStreamMethodDescriptor);
    methodDescriptors.add(createStreamMethodDescriptor);
    methodDescriptors.add(updateStreamMethodDescriptor);
    methodDescriptors.add(deleteStreamMethodDescriptor);
    methodDescriptors.add(getStreamThumbnailMethodDescriptor);
    methodDescriptors.add(generateStreamHlsTokenMethodDescriptor);
    methodDescriptors.add(listEventsMethodDescriptor);
    methodDescriptors.add(getEventMethodDescriptor);
    methodDescriptors.add(createEventMethodDescriptor);
    methodDescriptors.add(updateEventMethodDescriptor);
    methodDescriptors.add(deleteEventMethodDescriptor);
    methodDescriptors.add(listSeriesMethodDescriptor);
    methodDescriptors.add(getSeriesMethodDescriptor);
    methodDescriptors.add(createSeriesMethodDescriptor);
    methodDescriptors.add(updateSeriesMethodDescriptor);
    methodDescriptors.add(deleteSeriesMethodDescriptor);
    methodDescriptors.add(materializeChannelMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    return listClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  @Override
  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  @Override
  public OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  @Override
  public OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    return deleteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListStreamsRequest, ListStreamsResponse> listStreamsCallable() {
    return listStreamsCallable;
  }

  @Override
  public UnaryCallable<ListStreamsRequest, ListStreamsPagedResponse> listStreamsPagedCallable() {
    return listStreamsPagedCallable;
  }

  @Override
  public UnaryCallable<GetStreamRequest, Stream> getStreamCallable() {
    return getStreamCallable;
  }

  @Override
  public UnaryCallable<CreateStreamRequest, Operation> createStreamCallable() {
    return createStreamCallable;
  }

  @Override
  public OperationCallable<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationCallable() {
    return createStreamOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateStreamRequest, Operation> updateStreamCallable() {
    return updateStreamCallable;
  }

  @Override
  public OperationCallable<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationCallable() {
    return updateStreamOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteStreamRequest, Operation> deleteStreamCallable() {
    return deleteStreamCallable;
  }

  @Override
  public OperationCallable<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationCallable() {
    return deleteStreamOperationCallable;
  }

  @Override
  public UnaryCallable<GetStreamThumbnailRequest, Operation> getStreamThumbnailCallable() {
    return getStreamThumbnailCallable;
  }

  @Override
  public OperationCallable<GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailOperationCallable() {
    return getStreamThumbnailOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenCallable() {
    return generateStreamHlsTokenCallable;
  }

  @Override
  public UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return listEventsCallable;
  }

  @Override
  public UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return listEventsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEventRequest, Event> getEventCallable() {
    return getEventCallable;
  }

  @Override
  public UnaryCallable<CreateEventRequest, Operation> createEventCallable() {
    return createEventCallable;
  }

  @Override
  public OperationCallable<CreateEventRequest, Event, OperationMetadata>
      createEventOperationCallable() {
    return createEventOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEventRequest, Operation> updateEventCallable() {
    return updateEventCallable;
  }

  @Override
  public OperationCallable<UpdateEventRequest, Event, OperationMetadata>
      updateEventOperationCallable() {
    return updateEventOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEventRequest, Operation> deleteEventCallable() {
    return deleteEventCallable;
  }

  @Override
  public OperationCallable<DeleteEventRequest, Empty, OperationMetadata>
      deleteEventOperationCallable() {
    return deleteEventOperationCallable;
  }

  @Override
  public UnaryCallable<ListSeriesRequest, ListSeriesResponse> listSeriesCallable() {
    return listSeriesCallable;
  }

  @Override
  public UnaryCallable<ListSeriesRequest, ListSeriesPagedResponse> listSeriesPagedCallable() {
    return listSeriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSeriesRequest, Series> getSeriesCallable() {
    return getSeriesCallable;
  }

  @Override
  public UnaryCallable<CreateSeriesRequest, Operation> createSeriesCallable() {
    return createSeriesCallable;
  }

  @Override
  public OperationCallable<CreateSeriesRequest, Series, OperationMetadata>
      createSeriesOperationCallable() {
    return createSeriesOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSeriesRequest, Operation> updateSeriesCallable() {
    return updateSeriesCallable;
  }

  @Override
  public OperationCallable<UpdateSeriesRequest, Series, OperationMetadata>
      updateSeriesOperationCallable() {
    return updateSeriesOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSeriesRequest, Operation> deleteSeriesCallable() {
    return deleteSeriesCallable;
  }

  @Override
  public OperationCallable<DeleteSeriesRequest, Empty, OperationMetadata>
      deleteSeriesOperationCallable() {
    return deleteSeriesOperationCallable;
  }

  @Override
  public UnaryCallable<MaterializeChannelRequest, Operation> materializeChannelCallable() {
    return materializeChannelCallable;
  }

  @Override
  public OperationCallable<MaterializeChannelRequest, Channel, OperationMetadata>
      materializeChannelOperationCallable() {
    return materializeChannelOperationCallable;
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
