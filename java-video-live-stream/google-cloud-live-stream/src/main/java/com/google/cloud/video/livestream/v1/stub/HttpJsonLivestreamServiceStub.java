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

package com.google.cloud.video.livestream.v1.stub;

import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListChannelsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListEventsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListInputsPagedResponse;

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
import com.google.cloud.video.livestream.v1.Channel;
import com.google.cloud.video.livestream.v1.ChannelOperationResponse;
import com.google.cloud.video.livestream.v1.CreateChannelRequest;
import com.google.cloud.video.livestream.v1.CreateEventRequest;
import com.google.cloud.video.livestream.v1.CreateInputRequest;
import com.google.cloud.video.livestream.v1.DeleteChannelRequest;
import com.google.cloud.video.livestream.v1.DeleteEventRequest;
import com.google.cloud.video.livestream.v1.DeleteInputRequest;
import com.google.cloud.video.livestream.v1.Event;
import com.google.cloud.video.livestream.v1.GetChannelRequest;
import com.google.cloud.video.livestream.v1.GetEventRequest;
import com.google.cloud.video.livestream.v1.GetInputRequest;
import com.google.cloud.video.livestream.v1.Input;
import com.google.cloud.video.livestream.v1.ListChannelsRequest;
import com.google.cloud.video.livestream.v1.ListChannelsResponse;
import com.google.cloud.video.livestream.v1.ListEventsRequest;
import com.google.cloud.video.livestream.v1.ListEventsResponse;
import com.google.cloud.video.livestream.v1.ListInputsRequest;
import com.google.cloud.video.livestream.v1.ListInputsResponse;
import com.google.cloud.video.livestream.v1.OperationMetadata;
import com.google.cloud.video.livestream.v1.StartChannelRequest;
import com.google.cloud.video.livestream.v1.StopChannelRequest;
import com.google.cloud.video.livestream.v1.UpdateChannelRequest;
import com.google.cloud.video.livestream.v1.UpdateInputRequest;
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
 * REST stub implementation for the LivestreamService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonLivestreamServiceStub extends LivestreamServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Channel.getDescriptor())
          .add(Input.getDescriptor())
          .add(ChannelOperationResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateChannelRequest, Operation>
      createChannelMethodDescriptor =
          ApiMethodDescriptor.<CreateChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/CreateChannel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateChannelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/channels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelRequest> serializer =
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
                  (CreateChannelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListChannelsRequest, ListChannelsResponse>
      listChannelsMethodDescriptor =
          ApiMethodDescriptor.<ListChannelsRequest, ListChannelsResponse>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/ListChannels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChannelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/channels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListChannelsResponse>newBuilder()
                      .setDefaultInstance(ListChannelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetChannelRequest, Channel> getChannelMethodDescriptor =
      ApiMethodDescriptor.<GetChannelRequest, Channel>newBuilder()
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/GetChannel")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetChannelRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/channels/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetChannelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetChannelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Channel>newBuilder()
                  .setDefaultInstance(Channel.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteChannelRequest, Operation>
      deleteChannelMethodDescriptor =
          ApiMethodDescriptor.<DeleteChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/DeleteChannel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteChannelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/channels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteChannelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateChannelRequest, Operation>
      updateChannelMethodDescriptor =
          ApiMethodDescriptor.<UpdateChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/UpdateChannel")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateChannelRequest>newBuilder()
                      .setPath(
                          "/v1/{channel.name=projects/*/locations/*/channels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "channel.name", request.getChannel().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
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
                  (UpdateChannelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StartChannelRequest, Operation>
      startChannelMethodDescriptor =
          ApiMethodDescriptor.<StartChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/StartChannel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartChannelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/channels/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartChannelRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StartChannelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StopChannelRequest, Operation>
      stopChannelMethodDescriptor =
          ApiMethodDescriptor.<StopChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/StopChannel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopChannelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/channels/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopChannelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopChannelRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StopChannelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateInputRequest, Operation>
      createInputMethodDescriptor =
          ApiMethodDescriptor.<CreateInputRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/CreateInput")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInputRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/inputs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "inputId", request.getInputId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("input", request.getInput(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateInputRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListInputsRequest, ListInputsResponse>
      listInputsMethodDescriptor =
          ApiMethodDescriptor.<ListInputsRequest, ListInputsResponse>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/ListInputs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInputsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/inputs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInputsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInputsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListInputsResponse>newBuilder()
                      .setDefaultInstance(ListInputsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInputRequest, Input> getInputMethodDescriptor =
      ApiMethodDescriptor.<GetInputRequest, Input>newBuilder()
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/GetInput")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetInputRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/inputs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetInputRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetInputRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Input>newBuilder()
                  .setDefaultInstance(Input.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteInputRequest, Operation>
      deleteInputMethodDescriptor =
          ApiMethodDescriptor.<DeleteInputRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/DeleteInput")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInputRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/inputs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInputRequest> serializer =
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
                  (DeleteInputRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateInputRequest, Operation>
      updateInputMethodDescriptor =
          ApiMethodDescriptor.<UpdateInputRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/UpdateInput")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInputRequest>newBuilder()
                      .setPath(
                          "/v1/{input.name=projects/*/locations/*/inputs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "input.name", request.getInput().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("input", request.getInput(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateInputRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateEventRequest, Event> createEventMethodDescriptor =
      ApiMethodDescriptor.<CreateEventRequest, Event>newBuilder()
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/CreateEvent")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateEventRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/channels/*}/events",
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
                          ProtoRestSerializer.create().toBody("event", request.getEvent(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Event>newBuilder()
                  .setDefaultInstance(Event.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListEventsRequest, ListEventsResponse>
      listEventsMethodDescriptor =
          ApiMethodDescriptor.<ListEventsRequest, ListEventsResponse>newBuilder()
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/ListEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEventsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/channels/*}/events",
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
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/GetEvent")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetEventRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/channels/*/events/*}",
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

  private static final ApiMethodDescriptor<DeleteEventRequest, Empty> deleteEventMethodDescriptor =
      ApiMethodDescriptor.<DeleteEventRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/DeleteEvent")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteEventRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/channels/*/events/*}",
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
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private final UnaryCallable<CreateChannelRequest, Operation> createChannelCallable;
  private final OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable;
  private final UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable;
  private final UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse>
      listChannelsPagedCallable;
  private final UnaryCallable<GetChannelRequest, Channel> getChannelCallable;
  private final UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable;
  private final OperationCallable<DeleteChannelRequest, Empty, OperationMetadata>
      deleteChannelOperationCallable;
  private final UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable;
  private final OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable;
  private final UnaryCallable<StartChannelRequest, Operation> startChannelCallable;
  private final OperationCallable<StartChannelRequest, ChannelOperationResponse, OperationMetadata>
      startChannelOperationCallable;
  private final UnaryCallable<StopChannelRequest, Operation> stopChannelCallable;
  private final OperationCallable<StopChannelRequest, ChannelOperationResponse, OperationMetadata>
      stopChannelOperationCallable;
  private final UnaryCallable<CreateInputRequest, Operation> createInputCallable;
  private final OperationCallable<CreateInputRequest, Input, OperationMetadata>
      createInputOperationCallable;
  private final UnaryCallable<ListInputsRequest, ListInputsResponse> listInputsCallable;
  private final UnaryCallable<ListInputsRequest, ListInputsPagedResponse> listInputsPagedCallable;
  private final UnaryCallable<GetInputRequest, Input> getInputCallable;
  private final UnaryCallable<DeleteInputRequest, Operation> deleteInputCallable;
  private final OperationCallable<DeleteInputRequest, Empty, OperationMetadata>
      deleteInputOperationCallable;
  private final UnaryCallable<UpdateInputRequest, Operation> updateInputCallable;
  private final OperationCallable<UpdateInputRequest, Input, OperationMetadata>
      updateInputOperationCallable;
  private final UnaryCallable<CreateEventRequest, Event> createEventCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable;
  private final UnaryCallable<GetEventRequest, Event> getEventCallable;
  private final UnaryCallable<DeleteEventRequest, Empty> deleteEventCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLivestreamServiceStub create(LivestreamServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLivestreamServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLivestreamServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLivestreamServiceStub(
        LivestreamServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLivestreamServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLivestreamServiceStub(
        LivestreamServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLivestreamServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLivestreamServiceStub(
      LivestreamServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLivestreamServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLivestreamServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLivestreamServiceStub(
      LivestreamServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateChannelRequest, Operation> createChannelTransportSettings =
        HttpJsonCallSettings.<CreateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(createChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListChannelsRequest, ListChannelsResponse> listChannelsTransportSettings =
        HttpJsonCallSettings.<ListChannelsRequest, ListChannelsResponse>newBuilder()
            .setMethodDescriptor(listChannelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetChannelRequest, Channel> getChannelTransportSettings =
        HttpJsonCallSettings.<GetChannelRequest, Channel>newBuilder()
            .setMethodDescriptor(getChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteChannelRequest, Operation> deleteChannelTransportSettings =
        HttpJsonCallSettings.<DeleteChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateChannelRequest, Operation> updateChannelTransportSettings =
        HttpJsonCallSettings.<UpdateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartChannelRequest, Operation> startChannelTransportSettings =
        HttpJsonCallSettings.<StartChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(startChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StopChannelRequest, Operation> stopChannelTransportSettings =
        HttpJsonCallSettings.<StopChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(stopChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateInputRequest, Operation> createInputTransportSettings =
        HttpJsonCallSettings.<CreateInputRequest, Operation>newBuilder()
            .setMethodDescriptor(createInputMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListInputsRequest, ListInputsResponse> listInputsTransportSettings =
        HttpJsonCallSettings.<ListInputsRequest, ListInputsResponse>newBuilder()
            .setMethodDescriptor(listInputsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetInputRequest, Input> getInputTransportSettings =
        HttpJsonCallSettings.<GetInputRequest, Input>newBuilder()
            .setMethodDescriptor(getInputMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteInputRequest, Operation> deleteInputTransportSettings =
        HttpJsonCallSettings.<DeleteInputRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInputMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateInputRequest, Operation> updateInputTransportSettings =
        HttpJsonCallSettings.<UpdateInputRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInputMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateEventRequest, Event> createEventTransportSettings =
        HttpJsonCallSettings.<CreateEventRequest, Event>newBuilder()
            .setMethodDescriptor(createEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListEventsRequest, ListEventsResponse> listEventsTransportSettings =
        HttpJsonCallSettings.<ListEventsRequest, ListEventsResponse>newBuilder()
            .setMethodDescriptor(listEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetEventRequest, Event> getEventTransportSettings =
        HttpJsonCallSettings.<GetEventRequest, Event>newBuilder()
            .setMethodDescriptor(getEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteEventRequest, Empty> deleteEventTransportSettings =
        HttpJsonCallSettings.<DeleteEventRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createChannelCallable =
        callableFactory.createUnaryCallable(
            createChannelTransportSettings, settings.createChannelSettings(), clientContext);
    this.createChannelOperationCallable =
        callableFactory.createOperationCallable(
            createChannelTransportSettings,
            settings.createChannelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listChannelsCallable =
        callableFactory.createUnaryCallable(
            listChannelsTransportSettings, settings.listChannelsSettings(), clientContext);
    this.listChannelsPagedCallable =
        callableFactory.createPagedCallable(
            listChannelsTransportSettings, settings.listChannelsSettings(), clientContext);
    this.getChannelCallable =
        callableFactory.createUnaryCallable(
            getChannelTransportSettings, settings.getChannelSettings(), clientContext);
    this.deleteChannelCallable =
        callableFactory.createUnaryCallable(
            deleteChannelTransportSettings, settings.deleteChannelSettings(), clientContext);
    this.deleteChannelOperationCallable =
        callableFactory.createOperationCallable(
            deleteChannelTransportSettings,
            settings.deleteChannelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateChannelCallable =
        callableFactory.createUnaryCallable(
            updateChannelTransportSettings, settings.updateChannelSettings(), clientContext);
    this.updateChannelOperationCallable =
        callableFactory.createOperationCallable(
            updateChannelTransportSettings,
            settings.updateChannelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startChannelCallable =
        callableFactory.createUnaryCallable(
            startChannelTransportSettings, settings.startChannelSettings(), clientContext);
    this.startChannelOperationCallable =
        callableFactory.createOperationCallable(
            startChannelTransportSettings,
            settings.startChannelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopChannelCallable =
        callableFactory.createUnaryCallable(
            stopChannelTransportSettings, settings.stopChannelSettings(), clientContext);
    this.stopChannelOperationCallable =
        callableFactory.createOperationCallable(
            stopChannelTransportSettings,
            settings.stopChannelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createInputCallable =
        callableFactory.createUnaryCallable(
            createInputTransportSettings, settings.createInputSettings(), clientContext);
    this.createInputOperationCallable =
        callableFactory.createOperationCallable(
            createInputTransportSettings,
            settings.createInputOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listInputsCallable =
        callableFactory.createUnaryCallable(
            listInputsTransportSettings, settings.listInputsSettings(), clientContext);
    this.listInputsPagedCallable =
        callableFactory.createPagedCallable(
            listInputsTransportSettings, settings.listInputsSettings(), clientContext);
    this.getInputCallable =
        callableFactory.createUnaryCallable(
            getInputTransportSettings, settings.getInputSettings(), clientContext);
    this.deleteInputCallable =
        callableFactory.createUnaryCallable(
            deleteInputTransportSettings, settings.deleteInputSettings(), clientContext);
    this.deleteInputOperationCallable =
        callableFactory.createOperationCallable(
            deleteInputTransportSettings,
            settings.deleteInputOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateInputCallable =
        callableFactory.createUnaryCallable(
            updateInputTransportSettings, settings.updateInputSettings(), clientContext);
    this.updateInputOperationCallable =
        callableFactory.createOperationCallable(
            updateInputTransportSettings,
            settings.updateInputOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createEventCallable =
        callableFactory.createUnaryCallable(
            createEventTransportSettings, settings.createEventSettings(), clientContext);
    this.listEventsCallable =
        callableFactory.createUnaryCallable(
            listEventsTransportSettings, settings.listEventsSettings(), clientContext);
    this.listEventsPagedCallable =
        callableFactory.createPagedCallable(
            listEventsTransportSettings, settings.listEventsSettings(), clientContext);
    this.getEventCallable =
        callableFactory.createUnaryCallable(
            getEventTransportSettings, settings.getEventSettings(), clientContext);
    this.deleteEventCallable =
        callableFactory.createUnaryCallable(
            deleteEventTransportSettings, settings.deleteEventSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createChannelMethodDescriptor);
    methodDescriptors.add(listChannelsMethodDescriptor);
    methodDescriptors.add(getChannelMethodDescriptor);
    methodDescriptors.add(deleteChannelMethodDescriptor);
    methodDescriptors.add(updateChannelMethodDescriptor);
    methodDescriptors.add(startChannelMethodDescriptor);
    methodDescriptors.add(stopChannelMethodDescriptor);
    methodDescriptors.add(createInputMethodDescriptor);
    methodDescriptors.add(listInputsMethodDescriptor);
    methodDescriptors.add(getInputMethodDescriptor);
    methodDescriptors.add(deleteInputMethodDescriptor);
    methodDescriptors.add(updateInputMethodDescriptor);
    methodDescriptors.add(createEventMethodDescriptor);
    methodDescriptors.add(listEventsMethodDescriptor);
    methodDescriptors.add(getEventMethodDescriptor);
    methodDescriptors.add(deleteEventMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateChannelRequest, Operation> createChannelCallable() {
    return createChannelCallable;
  }

  @Override
  public OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable() {
    return createChannelOperationCallable;
  }

  @Override
  public UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable() {
    return listChannelsCallable;
  }

  @Override
  public UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse> listChannelsPagedCallable() {
    return listChannelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetChannelRequest, Channel> getChannelCallable() {
    return getChannelCallable;
  }

  @Override
  public UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    return deleteChannelCallable;
  }

  @Override
  public OperationCallable<DeleteChannelRequest, Empty, OperationMetadata>
      deleteChannelOperationCallable() {
    return deleteChannelOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable() {
    return updateChannelCallable;
  }

  @Override
  public OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable() {
    return updateChannelOperationCallable;
  }

  @Override
  public UnaryCallable<StartChannelRequest, Operation> startChannelCallable() {
    return startChannelCallable;
  }

  @Override
  public OperationCallable<StartChannelRequest, ChannelOperationResponse, OperationMetadata>
      startChannelOperationCallable() {
    return startChannelOperationCallable;
  }

  @Override
  public UnaryCallable<StopChannelRequest, Operation> stopChannelCallable() {
    return stopChannelCallable;
  }

  @Override
  public OperationCallable<StopChannelRequest, ChannelOperationResponse, OperationMetadata>
      stopChannelOperationCallable() {
    return stopChannelOperationCallable;
  }

  @Override
  public UnaryCallable<CreateInputRequest, Operation> createInputCallable() {
    return createInputCallable;
  }

  @Override
  public OperationCallable<CreateInputRequest, Input, OperationMetadata>
      createInputOperationCallable() {
    return createInputOperationCallable;
  }

  @Override
  public UnaryCallable<ListInputsRequest, ListInputsResponse> listInputsCallable() {
    return listInputsCallable;
  }

  @Override
  public UnaryCallable<ListInputsRequest, ListInputsPagedResponse> listInputsPagedCallable() {
    return listInputsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInputRequest, Input> getInputCallable() {
    return getInputCallable;
  }

  @Override
  public UnaryCallable<DeleteInputRequest, Operation> deleteInputCallable() {
    return deleteInputCallable;
  }

  @Override
  public OperationCallable<DeleteInputRequest, Empty, OperationMetadata>
      deleteInputOperationCallable() {
    return deleteInputOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInputRequest, Operation> updateInputCallable() {
    return updateInputCallable;
  }

  @Override
  public OperationCallable<UpdateInputRequest, Input, OperationMetadata>
      updateInputOperationCallable() {
    return updateInputOperationCallable;
  }

  @Override
  public UnaryCallable<CreateEventRequest, Event> createEventCallable() {
    return createEventCallable;
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
  public UnaryCallable<DeleteEventRequest, Empty> deleteEventCallable() {
    return deleteEventCallable;
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
