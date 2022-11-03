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

package com.google.cloud.eventarc.v1.stub;

import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelConnectionsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

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
import com.google.cloud.eventarc.v1.Channel;
import com.google.cloud.eventarc.v1.ChannelConnection;
import com.google.cloud.eventarc.v1.CreateChannelConnectionRequest;
import com.google.cloud.eventarc.v1.CreateChannelRequest;
import com.google.cloud.eventarc.v1.CreateTriggerRequest;
import com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest;
import com.google.cloud.eventarc.v1.DeleteChannelRequest;
import com.google.cloud.eventarc.v1.DeleteTriggerRequest;
import com.google.cloud.eventarc.v1.GetChannelConnectionRequest;
import com.google.cloud.eventarc.v1.GetChannelRequest;
import com.google.cloud.eventarc.v1.GetProviderRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.ListChannelConnectionsRequest;
import com.google.cloud.eventarc.v1.ListChannelConnectionsResponse;
import com.google.cloud.eventarc.v1.ListChannelsRequest;
import com.google.cloud.eventarc.v1.ListChannelsResponse;
import com.google.cloud.eventarc.v1.ListProvidersRequest;
import com.google.cloud.eventarc.v1.ListProvidersResponse;
import com.google.cloud.eventarc.v1.ListTriggersRequest;
import com.google.cloud.eventarc.v1.ListTriggersResponse;
import com.google.cloud.eventarc.v1.OperationMetadata;
import com.google.cloud.eventarc.v1.Provider;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.UpdateChannelRequest;
import com.google.cloud.eventarc.v1.UpdateTriggerRequest;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the Eventarc service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonEventarcStub extends EventarcStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Channel.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Trigger.getDescriptor())
          .add(ChannelConnection.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetTriggerRequest, Trigger> getTriggerMethodDescriptor =
      ApiMethodDescriptor.<GetTriggerRequest, Trigger>newBuilder()
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetTrigger")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTriggerRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/triggers/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTriggerRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTriggerRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Trigger>newBuilder()
                  .setDefaultInstance(Trigger.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListTriggersRequest, ListTriggersResponse>
      listTriggersMethodDescriptor =
          ApiMethodDescriptor.<ListTriggersRequest, ListTriggersResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListTriggers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTriggersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/triggers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTriggersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTriggersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTriggersResponse>newBuilder()
                      .setDefaultInstance(ListTriggersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTriggerRequest, Operation>
      createTriggerMethodDescriptor =
          ApiMethodDescriptor.<CreateTriggerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateTrigger")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTriggerRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/triggers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "triggerId", request.getTriggerId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("trigger", request.getTrigger(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTriggerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateTriggerRequest, Operation>
      updateTriggerMethodDescriptor =
          ApiMethodDescriptor.<UpdateTriggerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateTrigger")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTriggerRequest>newBuilder()
                      .setPath(
                          "/v1/{trigger.name=projects/*/locations/*/triggers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "trigger.name", request.getTrigger().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("trigger", request.getTrigger(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateTriggerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTriggerRequest, Operation>
      deleteTriggerMethodDescriptor =
          ApiMethodDescriptor.<DeleteTriggerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteTrigger")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTriggerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/triggers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTriggerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteTriggerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetChannelRequest, Channel> getChannelMethodDescriptor =
      ApiMethodDescriptor.<GetChannelRequest, Channel>newBuilder()
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetChannel")
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

  private static final ApiMethodDescriptor<ListChannelsRequest, ListChannelsResponse>
      listChannelsMethodDescriptor =
          ApiMethodDescriptor.<ListChannelsRequest, ListChannelsResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListChannels")
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
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
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

  private static final ApiMethodDescriptor<CreateChannelRequest, Operation>
      createChannelMethodDescriptor =
          ApiMethodDescriptor.<CreateChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateChannel")
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
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("channel", request.getChannel(), false))
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

  private static final ApiMethodDescriptor<UpdateChannelRequest, Operation>
      updateChannelMethodDescriptor =
          ApiMethodDescriptor.<UpdateChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateChannel")
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
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("channel", request.getChannel(), false))
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

  private static final ApiMethodDescriptor<DeleteChannelRequest, Operation>
      deleteChannelMethodDescriptor =
          ApiMethodDescriptor.<DeleteChannelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteChannel")
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
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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

  private static final ApiMethodDescriptor<GetProviderRequest, Provider>
      getProviderMethodDescriptor =
          ApiMethodDescriptor.<GetProviderRequest, Provider>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetProvider")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/providers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Provider>newBuilder()
                      .setDefaultInstance(Provider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListProvidersRequest, ListProvidersResponse>
      listProvidersMethodDescriptor =
          ApiMethodDescriptor.<ListProvidersRequest, ListProvidersResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListProviders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProvidersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/providers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProvidersResponse>newBuilder()
                      .setDefaultInstance(ListProvidersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionMethodDescriptor =
          ApiMethodDescriptor.<GetChannelConnectionRequest, ChannelConnection>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetChannelConnection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetChannelConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/channelConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetChannelConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetChannelConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelConnection>newBuilder()
                      .setDefaultInstance(ChannelConnection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListChannelConnectionsRequest, ListChannelConnectionsResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListChannelConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChannelConnectionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/channelConnections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListChannelConnectionsResponse>newBuilder()
                      .setDefaultInstance(ListChannelConnectionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateChannelConnectionRequest, Operation>
      createChannelConnectionMethodDescriptor =
          ApiMethodDescriptor.<CreateChannelConnectionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateChannelConnection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateChannelConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/channelConnections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "channelConnectionId", request.getChannelConnectionId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "channelConnection", request.getChannelConnection(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateChannelConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionMethodDescriptor =
          ApiMethodDescriptor.<DeleteChannelConnectionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteChannelConnection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteChannelConnectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/channelConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteChannelConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteChannelConnectionRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteChannelConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable;
  private final UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable;
  private final UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse>
      listTriggersPagedCallable;
  private final UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable;
  private final OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable;
  private final UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable;
  private final OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable;
  private final UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable;
  private final OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable;
  private final UnaryCallable<GetChannelRequest, Channel> getChannelCallable;
  private final UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable;
  private final UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse>
      listChannelsPagedCallable;
  private final UnaryCallable<CreateChannelRequest, Operation> createChannelCallable;
  private final OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable;
  private final UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable;
  private final OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable;
  private final UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable;
  private final OperationCallable<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationCallable;
  private final UnaryCallable<GetProviderRequest, Provider> getProviderCallable;
  private final UnaryCallable<ListProvidersRequest, ListProvidersResponse> listProvidersCallable;
  private final UnaryCallable<ListProvidersRequest, ListProvidersPagedResponse>
      listProvidersPagedCallable;
  private final UnaryCallable<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionCallable;
  private final UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsCallable;
  private final UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsPagedResponse>
      listChannelConnectionsPagedCallable;
  private final UnaryCallable<CreateChannelConnectionRequest, Operation>
      createChannelConnectionCallable;
  private final OperationCallable<
          CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationCallable;
  private final UnaryCallable<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionCallable;
  private final OperationCallable<
          DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEventarcStub create(EventarcStubSettings settings)
      throws IOException {
    return new HttpJsonEventarcStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEventarcStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonEventarcStub(
        EventarcStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEventarcStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEventarcStub(
        EventarcStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEventarcStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonEventarcStub(EventarcStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEventarcCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEventarcStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonEventarcStub(
      EventarcStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetTriggerRequest, Trigger> getTriggerTransportSettings =
        HttpJsonCallSettings.<GetTriggerRequest, Trigger>newBuilder()
            .setMethodDescriptor(getTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTriggersRequest, ListTriggersResponse> listTriggersTransportSettings =
        HttpJsonCallSettings.<ListTriggersRequest, ListTriggersResponse>newBuilder()
            .setMethodDescriptor(listTriggersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateTriggerRequest, Operation> createTriggerTransportSettings =
        HttpJsonCallSettings.<CreateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(createTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTriggerRequest, Operation> updateTriggerTransportSettings =
        HttpJsonCallSettings.<UpdateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTriggerRequest, Operation> deleteTriggerTransportSettings =
        HttpJsonCallSettings.<DeleteTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetChannelRequest, Channel> getChannelTransportSettings =
        HttpJsonCallSettings.<GetChannelRequest, Channel>newBuilder()
            .setMethodDescriptor(getChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListChannelsRequest, ListChannelsResponse> listChannelsTransportSettings =
        HttpJsonCallSettings.<ListChannelsRequest, ListChannelsResponse>newBuilder()
            .setMethodDescriptor(listChannelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateChannelRequest, Operation> createChannelTransportSettings =
        HttpJsonCallSettings.<CreateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(createChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateChannelRequest, Operation> updateChannelTransportSettings =
        HttpJsonCallSettings.<UpdateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteChannelRequest, Operation> deleteChannelTransportSettings =
        HttpJsonCallSettings.<DeleteChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetProviderRequest, Provider> getProviderTransportSettings =
        HttpJsonCallSettings.<GetProviderRequest, Provider>newBuilder()
            .setMethodDescriptor(getProviderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListProvidersRequest, ListProvidersResponse>
        listProvidersTransportSettings =
            HttpJsonCallSettings.<ListProvidersRequest, ListProvidersResponse>newBuilder()
                .setMethodDescriptor(listProvidersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetChannelConnectionRequest, ChannelConnection>
        getChannelConnectionTransportSettings =
            HttpJsonCallSettings.<GetChannelConnectionRequest, ChannelConnection>newBuilder()
                .setMethodDescriptor(getChannelConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
        listChannelConnectionsTransportSettings =
            HttpJsonCallSettings
                .<ListChannelConnectionsRequest, ListChannelConnectionsResponse>newBuilder()
                .setMethodDescriptor(listChannelConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateChannelConnectionRequest, Operation>
        createChannelConnectionTransportSettings =
            HttpJsonCallSettings.<CreateChannelConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createChannelConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteChannelConnectionRequest, Operation>
        deleteChannelConnectionTransportSettings =
            HttpJsonCallSettings.<DeleteChannelConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteChannelConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getTriggerCallable =
        callableFactory.createUnaryCallable(
            getTriggerTransportSettings, settings.getTriggerSettings(), clientContext);
    this.listTriggersCallable =
        callableFactory.createUnaryCallable(
            listTriggersTransportSettings, settings.listTriggersSettings(), clientContext);
    this.listTriggersPagedCallable =
        callableFactory.createPagedCallable(
            listTriggersTransportSettings, settings.listTriggersSettings(), clientContext);
    this.createTriggerCallable =
        callableFactory.createUnaryCallable(
            createTriggerTransportSettings, settings.createTriggerSettings(), clientContext);
    this.createTriggerOperationCallable =
        callableFactory.createOperationCallable(
            createTriggerTransportSettings,
            settings.createTriggerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateTriggerCallable =
        callableFactory.createUnaryCallable(
            updateTriggerTransportSettings, settings.updateTriggerSettings(), clientContext);
    this.updateTriggerOperationCallable =
        callableFactory.createOperationCallable(
            updateTriggerTransportSettings,
            settings.updateTriggerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTriggerCallable =
        callableFactory.createUnaryCallable(
            deleteTriggerTransportSettings, settings.deleteTriggerSettings(), clientContext);
    this.deleteTriggerOperationCallable =
        callableFactory.createOperationCallable(
            deleteTriggerTransportSettings,
            settings.deleteTriggerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getChannelCallable =
        callableFactory.createUnaryCallable(
            getChannelTransportSettings, settings.getChannelSettings(), clientContext);
    this.listChannelsCallable =
        callableFactory.createUnaryCallable(
            listChannelsTransportSettings, settings.listChannelsSettings(), clientContext);
    this.listChannelsPagedCallable =
        callableFactory.createPagedCallable(
            listChannelsTransportSettings, settings.listChannelsSettings(), clientContext);
    this.createChannelCallable =
        callableFactory.createUnaryCallable(
            createChannelTransportSettings, settings.createChannelSettings(), clientContext);
    this.createChannelOperationCallable =
        callableFactory.createOperationCallable(
            createChannelTransportSettings,
            settings.createChannelOperationSettings(),
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
    this.deleteChannelCallable =
        callableFactory.createUnaryCallable(
            deleteChannelTransportSettings, settings.deleteChannelSettings(), clientContext);
    this.deleteChannelOperationCallable =
        callableFactory.createOperationCallable(
            deleteChannelTransportSettings,
            settings.deleteChannelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getProviderCallable =
        callableFactory.createUnaryCallable(
            getProviderTransportSettings, settings.getProviderSettings(), clientContext);
    this.listProvidersCallable =
        callableFactory.createUnaryCallable(
            listProvidersTransportSettings, settings.listProvidersSettings(), clientContext);
    this.listProvidersPagedCallable =
        callableFactory.createPagedCallable(
            listProvidersTransportSettings, settings.listProvidersSettings(), clientContext);
    this.getChannelConnectionCallable =
        callableFactory.createUnaryCallable(
            getChannelConnectionTransportSettings,
            settings.getChannelConnectionSettings(),
            clientContext);
    this.listChannelConnectionsCallable =
        callableFactory.createUnaryCallable(
            listChannelConnectionsTransportSettings,
            settings.listChannelConnectionsSettings(),
            clientContext);
    this.listChannelConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listChannelConnectionsTransportSettings,
            settings.listChannelConnectionsSettings(),
            clientContext);
    this.createChannelConnectionCallable =
        callableFactory.createUnaryCallable(
            createChannelConnectionTransportSettings,
            settings.createChannelConnectionSettings(),
            clientContext);
    this.createChannelConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createChannelConnectionTransportSettings,
            settings.createChannelConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteChannelConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteChannelConnectionTransportSettings,
            settings.deleteChannelConnectionSettings(),
            clientContext);
    this.deleteChannelConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteChannelConnectionTransportSettings,
            settings.deleteChannelConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getTriggerMethodDescriptor);
    methodDescriptors.add(listTriggersMethodDescriptor);
    methodDescriptors.add(createTriggerMethodDescriptor);
    methodDescriptors.add(updateTriggerMethodDescriptor);
    methodDescriptors.add(deleteTriggerMethodDescriptor);
    methodDescriptors.add(getChannelMethodDescriptor);
    methodDescriptors.add(listChannelsMethodDescriptor);
    methodDescriptors.add(createChannelMethodDescriptor);
    methodDescriptors.add(updateChannelMethodDescriptor);
    methodDescriptors.add(deleteChannelMethodDescriptor);
    methodDescriptors.add(getProviderMethodDescriptor);
    methodDescriptors.add(listProvidersMethodDescriptor);
    methodDescriptors.add(getChannelConnectionMethodDescriptor);
    methodDescriptors.add(listChannelConnectionsMethodDescriptor);
    methodDescriptors.add(createChannelConnectionMethodDescriptor);
    methodDescriptors.add(deleteChannelConnectionMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable() {
    return getTriggerCallable;
  }

  @Override
  public UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable() {
    return listTriggersCallable;
  }

  @Override
  public UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse> listTriggersPagedCallable() {
    return listTriggersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable() {
    return createTriggerCallable;
  }

  @Override
  public OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable() {
    return createTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable() {
    return updateTriggerCallable;
  }

  @Override
  public OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable() {
    return updateTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable() {
    return deleteTriggerCallable;
  }

  @Override
  public OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable() {
    return deleteTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<GetChannelRequest, Channel> getChannelCallable() {
    return getChannelCallable;
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
  public UnaryCallable<CreateChannelRequest, Operation> createChannelCallable() {
    return createChannelCallable;
  }

  @Override
  public OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable() {
    return createChannelOperationCallable;
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
  public UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    return deleteChannelCallable;
  }

  @Override
  public OperationCallable<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationCallable() {
    return deleteChannelOperationCallable;
  }

  @Override
  public UnaryCallable<GetProviderRequest, Provider> getProviderCallable() {
    return getProviderCallable;
  }

  @Override
  public UnaryCallable<ListProvidersRequest, ListProvidersResponse> listProvidersCallable() {
    return listProvidersCallable;
  }

  @Override
  public UnaryCallable<ListProvidersRequest, ListProvidersPagedResponse>
      listProvidersPagedCallable() {
    return listProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionCallable() {
    return getChannelConnectionCallable;
  }

  @Override
  public UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsCallable() {
    return listChannelConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsPagedResponse>
      listChannelConnectionsPagedCallable() {
    return listChannelConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateChannelConnectionRequest, Operation>
      createChannelConnectionCallable() {
    return createChannelConnectionCallable;
  }

  @Override
  public OperationCallable<CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationCallable() {
    return createChannelConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionCallable() {
    return deleteChannelConnectionCallable;
  }

  @Override
  public OperationCallable<DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationCallable() {
    return deleteChannelConnectionOperationCallable;
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
