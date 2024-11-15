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

package com.google.cloud.eventarc.v1.stub;

import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelConnectionsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListEnrollmentsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListGoogleApiSourcesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListLocationsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListMessageBusEnrollmentsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListMessageBusesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListPipelinesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

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
import com.google.cloud.eventarc.v1.Channel;
import com.google.cloud.eventarc.v1.ChannelConnection;
import com.google.cloud.eventarc.v1.CreateChannelConnectionRequest;
import com.google.cloud.eventarc.v1.CreateChannelRequest;
import com.google.cloud.eventarc.v1.CreateEnrollmentRequest;
import com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.CreateMessageBusRequest;
import com.google.cloud.eventarc.v1.CreatePipelineRequest;
import com.google.cloud.eventarc.v1.CreateTriggerRequest;
import com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest;
import com.google.cloud.eventarc.v1.DeleteChannelRequest;
import com.google.cloud.eventarc.v1.DeleteEnrollmentRequest;
import com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.DeleteMessageBusRequest;
import com.google.cloud.eventarc.v1.DeletePipelineRequest;
import com.google.cloud.eventarc.v1.DeleteTriggerRequest;
import com.google.cloud.eventarc.v1.Enrollment;
import com.google.cloud.eventarc.v1.GetChannelConnectionRequest;
import com.google.cloud.eventarc.v1.GetChannelRequest;
import com.google.cloud.eventarc.v1.GetEnrollmentRequest;
import com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.GetMessageBusRequest;
import com.google.cloud.eventarc.v1.GetPipelineRequest;
import com.google.cloud.eventarc.v1.GetProviderRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.GoogleApiSource;
import com.google.cloud.eventarc.v1.GoogleChannelConfig;
import com.google.cloud.eventarc.v1.ListChannelConnectionsRequest;
import com.google.cloud.eventarc.v1.ListChannelConnectionsResponse;
import com.google.cloud.eventarc.v1.ListChannelsRequest;
import com.google.cloud.eventarc.v1.ListChannelsResponse;
import com.google.cloud.eventarc.v1.ListEnrollmentsRequest;
import com.google.cloud.eventarc.v1.ListEnrollmentsResponse;
import com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest;
import com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse;
import com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest;
import com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse;
import com.google.cloud.eventarc.v1.ListMessageBusesRequest;
import com.google.cloud.eventarc.v1.ListMessageBusesResponse;
import com.google.cloud.eventarc.v1.ListPipelinesRequest;
import com.google.cloud.eventarc.v1.ListPipelinesResponse;
import com.google.cloud.eventarc.v1.ListProvidersRequest;
import com.google.cloud.eventarc.v1.ListProvidersResponse;
import com.google.cloud.eventarc.v1.ListTriggersRequest;
import com.google.cloud.eventarc.v1.ListTriggersResponse;
import com.google.cloud.eventarc.v1.MessageBus;
import com.google.cloud.eventarc.v1.OperationMetadata;
import com.google.cloud.eventarc.v1.Pipeline;
import com.google.cloud.eventarc.v1.Provider;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.UpdateChannelRequest;
import com.google.cloud.eventarc.v1.UpdateEnrollmentRequest;
import com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.UpdateMessageBusRequest;
import com.google.cloud.eventarc.v1.UpdatePipelineRequest;
import com.google.cloud.eventarc.v1.UpdateTriggerRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
public class HttpJsonEventarcStub extends EventarcStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Channel.getDescriptor())
          .add(Pipeline.getDescriptor())
          .add(GoogleApiSource.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Trigger.getDescriptor())
          .add(ChannelConnection.getDescriptor())
          .add(MessageBus.getDescriptor())
          .add(Enrollment.getDescriptor())
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("trigger", request.getTrigger(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("trigger", request.getTrigger(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "channelConnection", request.getChannelConnection(), true))
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
                  (DeleteChannelConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigMethodDescriptor =
          ApiMethodDescriptor.<GetGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetGoogleChannelConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGoogleChannelConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/googleChannelConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGoogleChannelConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGoogleChannelConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GoogleChannelConfig>newBuilder()
                      .setDefaultInstance(GoogleChannelConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateGoogleChannelConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGoogleChannelConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{googleChannelConfig.name=projects/*/locations/*/googleChannelConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGoogleChannelConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "googleChannelConfig.name",
                                request.getGoogleChannelConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGoogleChannelConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "googleChannelConfig",
                                      request.getGoogleChannelConfig(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GoogleChannelConfig>newBuilder()
                      .setDefaultInstance(GoogleChannelConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMessageBusRequest, MessageBus>
      getMessageBusMethodDescriptor =
          ApiMethodDescriptor.<GetMessageBusRequest, MessageBus>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetMessageBus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMessageBusRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/messageBuses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMessageBusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMessageBusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MessageBus>newBuilder()
                      .setDefaultInstance(MessageBus.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMessageBusesRequest, ListMessageBusesResponse>
      listMessageBusesMethodDescriptor =
          ApiMethodDescriptor.<ListMessageBusesRequest, ListMessageBusesResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListMessageBuses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMessageBusesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/messageBuses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMessageBusesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMessageBusesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListMessageBusesResponse>newBuilder()
                      .setDefaultInstance(ListMessageBusesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
      listMessageBusEnrollmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListMessageBusEnrollments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMessageBusEnrollmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/messageBuses/*}:listEnrollments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMessageBusEnrollmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMessageBusEnrollmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMessageBusEnrollmentsResponse>newBuilder()
                      .setDefaultInstance(ListMessageBusEnrollmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateMessageBusRequest, Operation>
      createMessageBusMethodDescriptor =
          ApiMethodDescriptor.<CreateMessageBusRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateMessageBus")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMessageBusRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/messageBuses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMessageBusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMessageBusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "messageBusId", request.getMessageBusId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("messageBus", request.getMessageBus(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMessageBusRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateMessageBusRequest, Operation>
      updateMessageBusMethodDescriptor =
          ApiMethodDescriptor.<UpdateMessageBusRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateMessageBus")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMessageBusRequest>newBuilder()
                      .setPath(
                          "/v1/{messageBus.name=projects/*/locations/*/messageBuses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMessageBusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "messageBus.name", request.getMessageBus().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMessageBusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("messageBus", request.getMessageBus(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMessageBusRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMessageBusRequest, Operation>
      deleteMessageBusMethodDescriptor =
          ApiMethodDescriptor.<DeleteMessageBusRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteMessageBus")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMessageBusRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/messageBuses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMessageBusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMessageBusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteMessageBusRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetEnrollmentRequest, Enrollment>
      getEnrollmentMethodDescriptor =
          ApiMethodDescriptor.<GetEnrollmentRequest, Enrollment>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetEnrollment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEnrollmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/enrollments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEnrollmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEnrollmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Enrollment>newBuilder()
                      .setDefaultInstance(Enrollment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEnrollmentsRequest, ListEnrollmentsResponse>
      listEnrollmentsMethodDescriptor =
          ApiMethodDescriptor.<ListEnrollmentsRequest, ListEnrollmentsResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListEnrollments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEnrollmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/enrollments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEnrollmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEnrollmentsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEnrollmentsResponse>newBuilder()
                      .setDefaultInstance(ListEnrollmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEnrollmentRequest, Operation>
      createEnrollmentMethodDescriptor =
          ApiMethodDescriptor.<CreateEnrollmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateEnrollment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEnrollmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/enrollments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEnrollmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEnrollmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "enrollmentId", request.getEnrollmentId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("enrollment", request.getEnrollment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEnrollmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEnrollmentRequest, Operation>
      updateEnrollmentMethodDescriptor =
          ApiMethodDescriptor.<UpdateEnrollmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateEnrollment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEnrollmentRequest>newBuilder()
                      .setPath(
                          "/v1/{enrollment.name=projects/*/locations/*/enrollments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEnrollmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "enrollment.name", request.getEnrollment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEnrollmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("enrollment", request.getEnrollment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEnrollmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEnrollmentRequest, Operation>
      deleteEnrollmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteEnrollmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteEnrollment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEnrollmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/enrollments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEnrollmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEnrollmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteEnrollmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPipelineRequest, Pipeline>
      getPipelineMethodDescriptor =
          ApiMethodDescriptor.<GetPipelineRequest, Pipeline>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetPipeline")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPipelineRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/pipelines/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Pipeline>newBuilder()
                      .setDefaultInstance(Pipeline.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPipelinesRequest, ListPipelinesResponse>
      listPipelinesMethodDescriptor =
          ApiMethodDescriptor.<ListPipelinesRequest, ListPipelinesResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListPipelines")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPipelinesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/pipelines",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPipelinesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPipelinesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPipelinesResponse>newBuilder()
                      .setDefaultInstance(ListPipelinesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePipelineRequest, Operation>
      createPipelineMethodDescriptor =
          ApiMethodDescriptor.<CreatePipelineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreatePipeline")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePipelineRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/pipelines",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pipelineId", request.getPipelineId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("pipeline", request.getPipeline(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePipelineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePipelineRequest, Operation>
      updatePipelineMethodDescriptor =
          ApiMethodDescriptor.<UpdatePipelineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdatePipeline")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePipelineRequest>newBuilder()
                      .setPath(
                          "/v1/{pipeline.name=projects/*/locations/*/pipelines/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "pipeline.name", request.getPipeline().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("pipeline", request.getPipeline(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePipelineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePipelineRequest, Operation>
      deletePipelineMethodDescriptor =
          ApiMethodDescriptor.<DeletePipelineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeletePipeline")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePipelineRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/pipelines/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeletePipelineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetGoogleApiSourceRequest, GoogleApiSource>
      getGoogleApiSourceMethodDescriptor =
          ApiMethodDescriptor.<GetGoogleApiSourceRequest, GoogleApiSource>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetGoogleApiSource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGoogleApiSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/googleApiSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGoogleApiSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGoogleApiSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GoogleApiSource>newBuilder()
                      .setDefaultInstance(GoogleApiSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
      listGoogleApiSourcesMethodDescriptor =
          ApiMethodDescriptor
              .<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListGoogleApiSources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGoogleApiSourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/googleApiSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGoogleApiSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGoogleApiSourcesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGoogleApiSourcesResponse>newBuilder()
                      .setDefaultInstance(ListGoogleApiSourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGoogleApiSourceRequest, Operation>
      createGoogleApiSourceMethodDescriptor =
          ApiMethodDescriptor.<CreateGoogleApiSourceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateGoogleApiSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGoogleApiSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/googleApiSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGoogleApiSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGoogleApiSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "googleApiSourceId", request.getGoogleApiSourceId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("googleApiSource", request.getGoogleApiSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGoogleApiSourceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateGoogleApiSourceRequest, Operation>
      updateGoogleApiSourceMethodDescriptor =
          ApiMethodDescriptor.<UpdateGoogleApiSourceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateGoogleApiSource")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGoogleApiSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{googleApiSource.name=projects/*/locations/*/googleApiSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGoogleApiSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "googleApiSource.name",
                                request.getGoogleApiSource().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGoogleApiSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("googleApiSource", request.getGoogleApiSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGoogleApiSourceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGoogleApiSourceRequest, Operation>
      deleteGoogleApiSourceMethodDescriptor =
          ApiMethodDescriptor.<DeleteGoogleApiSourceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteGoogleApiSource")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGoogleApiSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/googleApiSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGoogleApiSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGoogleApiSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteGoogleApiSourceRequest request, Operation response) ->
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/triggers/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/channels/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/channelConnections/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/messageBuses/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/enrollments/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/pipelines/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/googleApiSources/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/triggers/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/channels/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/channelConnections/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/messageBuses/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/enrollments/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/pipelines/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/googleApiSources/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/triggers/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/channels/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/channelConnections/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/messageBuses/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/enrollments/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/pipelines/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/googleApiSources/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final UnaryCallable<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigCallable;
  private final UnaryCallable<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigCallable;
  private final UnaryCallable<GetMessageBusRequest, MessageBus> getMessageBusCallable;
  private final UnaryCallable<ListMessageBusesRequest, ListMessageBusesResponse>
      listMessageBusesCallable;
  private final UnaryCallable<ListMessageBusesRequest, ListMessageBusesPagedResponse>
      listMessageBusesPagedCallable;
  private final UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
      listMessageBusEnrollmentsCallable;
  private final UnaryCallable<
          ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsPagedResponse>
      listMessageBusEnrollmentsPagedCallable;
  private final UnaryCallable<CreateMessageBusRequest, Operation> createMessageBusCallable;
  private final OperationCallable<CreateMessageBusRequest, MessageBus, OperationMetadata>
      createMessageBusOperationCallable;
  private final UnaryCallable<UpdateMessageBusRequest, Operation> updateMessageBusCallable;
  private final OperationCallable<UpdateMessageBusRequest, MessageBus, OperationMetadata>
      updateMessageBusOperationCallable;
  private final UnaryCallable<DeleteMessageBusRequest, Operation> deleteMessageBusCallable;
  private final OperationCallable<DeleteMessageBusRequest, MessageBus, OperationMetadata>
      deleteMessageBusOperationCallable;
  private final UnaryCallable<GetEnrollmentRequest, Enrollment> getEnrollmentCallable;
  private final UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsResponse>
      listEnrollmentsCallable;
  private final UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsPagedResponse>
      listEnrollmentsPagedCallable;
  private final UnaryCallable<CreateEnrollmentRequest, Operation> createEnrollmentCallable;
  private final OperationCallable<CreateEnrollmentRequest, Enrollment, OperationMetadata>
      createEnrollmentOperationCallable;
  private final UnaryCallable<UpdateEnrollmentRequest, Operation> updateEnrollmentCallable;
  private final OperationCallable<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
      updateEnrollmentOperationCallable;
  private final UnaryCallable<DeleteEnrollmentRequest, Operation> deleteEnrollmentCallable;
  private final OperationCallable<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
      deleteEnrollmentOperationCallable;
  private final UnaryCallable<GetPipelineRequest, Pipeline> getPipelineCallable;
  private final UnaryCallable<ListPipelinesRequest, ListPipelinesResponse> listPipelinesCallable;
  private final UnaryCallable<ListPipelinesRequest, ListPipelinesPagedResponse>
      listPipelinesPagedCallable;
  private final UnaryCallable<CreatePipelineRequest, Operation> createPipelineCallable;
  private final OperationCallable<CreatePipelineRequest, Pipeline, OperationMetadata>
      createPipelineOperationCallable;
  private final UnaryCallable<UpdatePipelineRequest, Operation> updatePipelineCallable;
  private final OperationCallable<UpdatePipelineRequest, Pipeline, OperationMetadata>
      updatePipelineOperationCallable;
  private final UnaryCallable<DeletePipelineRequest, Operation> deletePipelineCallable;
  private final OperationCallable<DeletePipelineRequest, Pipeline, OperationMetadata>
      deletePipelineOperationCallable;
  private final UnaryCallable<GetGoogleApiSourceRequest, GoogleApiSource>
      getGoogleApiSourceCallable;
  private final UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
      listGoogleApiSourcesCallable;
  private final UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesPagedResponse>
      listGoogleApiSourcesPagedCallable;
  private final UnaryCallable<CreateGoogleApiSourceRequest, Operation>
      createGoogleApiSourceCallable;
  private final OperationCallable<CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      createGoogleApiSourceOperationCallable;
  private final UnaryCallable<UpdateGoogleApiSourceRequest, Operation>
      updateGoogleApiSourceCallable;
  private final OperationCallable<UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      updateGoogleApiSourceOperationCallable;
  private final UnaryCallable<DeleteGoogleApiSourceRequest, Operation>
      deleteGoogleApiSourceCallable;
  private final OperationCallable<DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      deleteGoogleApiSourceOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

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
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<GetTriggerRequest, Trigger> getTriggerTransportSettings =
        HttpJsonCallSettings.<GetTriggerRequest, Trigger>newBuilder()
            .setMethodDescriptor(getTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTriggersRequest, ListTriggersResponse> listTriggersTransportSettings =
        HttpJsonCallSettings.<ListTriggersRequest, ListTriggersResponse>newBuilder()
            .setMethodDescriptor(listTriggersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateTriggerRequest, Operation> createTriggerTransportSettings =
        HttpJsonCallSettings.<CreateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(createTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTriggerRequest, Operation> updateTriggerTransportSettings =
        HttpJsonCallSettings.<UpdateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("trigger.name", String.valueOf(request.getTrigger().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTriggerRequest, Operation> deleteTriggerTransportSettings =
        HttpJsonCallSettings.<DeleteTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTriggerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetChannelRequest, Channel> getChannelTransportSettings =
        HttpJsonCallSettings.<GetChannelRequest, Channel>newBuilder()
            .setMethodDescriptor(getChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListChannelsRequest, ListChannelsResponse> listChannelsTransportSettings =
        HttpJsonCallSettings.<ListChannelsRequest, ListChannelsResponse>newBuilder()
            .setMethodDescriptor(listChannelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateChannelRequest, Operation> createChannelTransportSettings =
        HttpJsonCallSettings.<CreateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(createChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateChannelRequest, Operation> updateChannelTransportSettings =
        HttpJsonCallSettings.<UpdateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("channel.name", String.valueOf(request.getChannel().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteChannelRequest, Operation> deleteChannelTransportSettings =
        HttpJsonCallSettings.<DeleteChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteChannelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetProviderRequest, Provider> getProviderTransportSettings =
        HttpJsonCallSettings.<GetProviderRequest, Provider>newBuilder()
            .setMethodDescriptor(getProviderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListProvidersRequest, ListProvidersResponse>
        listProvidersTransportSettings =
            HttpJsonCallSettings.<ListProvidersRequest, ListProvidersResponse>newBuilder()
                .setMethodDescriptor(listProvidersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetChannelConnectionRequest, ChannelConnection>
        getChannelConnectionTransportSettings =
            HttpJsonCallSettings.<GetChannelConnectionRequest, ChannelConnection>newBuilder()
                .setMethodDescriptor(getChannelConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
        listChannelConnectionsTransportSettings =
            HttpJsonCallSettings
                .<ListChannelConnectionsRequest, ListChannelConnectionsResponse>newBuilder()
                .setMethodDescriptor(listChannelConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateChannelConnectionRequest, Operation>
        createChannelConnectionTransportSettings =
            HttpJsonCallSettings.<CreateChannelConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createChannelConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteChannelConnectionRequest, Operation>
        deleteChannelConnectionTransportSettings =
            HttpJsonCallSettings.<DeleteChannelConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteChannelConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetGoogleChannelConfigRequest, GoogleChannelConfig>
        getGoogleChannelConfigTransportSettings =
            HttpJsonCallSettings.<GetGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
                .setMethodDescriptor(getGoogleChannelConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
        updateGoogleChannelConfigTransportSettings =
            HttpJsonCallSettings.<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
                .setMethodDescriptor(updateGoogleChannelConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "google_channel_config.name",
                          String.valueOf(request.getGoogleChannelConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetMessageBusRequest, MessageBus> getMessageBusTransportSettings =
        HttpJsonCallSettings.<GetMessageBusRequest, MessageBus>newBuilder()
            .setMethodDescriptor(getMessageBusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListMessageBusesRequest, ListMessageBusesResponse>
        listMessageBusesTransportSettings =
            HttpJsonCallSettings.<ListMessageBusesRequest, ListMessageBusesResponse>newBuilder()
                .setMethodDescriptor(listMessageBusesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
        listMessageBusEnrollmentsTransportSettings =
            HttpJsonCallSettings
                .<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>newBuilder()
                .setMethodDescriptor(listMessageBusEnrollmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateMessageBusRequest, Operation> createMessageBusTransportSettings =
        HttpJsonCallSettings.<CreateMessageBusRequest, Operation>newBuilder()
            .setMethodDescriptor(createMessageBusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateMessageBusRequest, Operation> updateMessageBusTransportSettings =
        HttpJsonCallSettings.<UpdateMessageBusRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMessageBusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "message_bus.name", String.valueOf(request.getMessageBus().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMessageBusRequest, Operation> deleteMessageBusTransportSettings =
        HttpJsonCallSettings.<DeleteMessageBusRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMessageBusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEnrollmentRequest, Enrollment> getEnrollmentTransportSettings =
        HttpJsonCallSettings.<GetEnrollmentRequest, Enrollment>newBuilder()
            .setMethodDescriptor(getEnrollmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEnrollmentsRequest, ListEnrollmentsResponse>
        listEnrollmentsTransportSettings =
            HttpJsonCallSettings.<ListEnrollmentsRequest, ListEnrollmentsResponse>newBuilder()
                .setMethodDescriptor(listEnrollmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateEnrollmentRequest, Operation> createEnrollmentTransportSettings =
        HttpJsonCallSettings.<CreateEnrollmentRequest, Operation>newBuilder()
            .setMethodDescriptor(createEnrollmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEnrollmentRequest, Operation> updateEnrollmentTransportSettings =
        HttpJsonCallSettings.<UpdateEnrollmentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEnrollmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("enrollment.name", String.valueOf(request.getEnrollment().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEnrollmentRequest, Operation> deleteEnrollmentTransportSettings =
        HttpJsonCallSettings.<DeleteEnrollmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEnrollmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetPipelineRequest, Pipeline> getPipelineTransportSettings =
        HttpJsonCallSettings.<GetPipelineRequest, Pipeline>newBuilder()
            .setMethodDescriptor(getPipelineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPipelinesRequest, ListPipelinesResponse>
        listPipelinesTransportSettings =
            HttpJsonCallSettings.<ListPipelinesRequest, ListPipelinesResponse>newBuilder()
                .setMethodDescriptor(listPipelinesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreatePipelineRequest, Operation> createPipelineTransportSettings =
        HttpJsonCallSettings.<CreatePipelineRequest, Operation>newBuilder()
            .setMethodDescriptor(createPipelineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdatePipelineRequest, Operation> updatePipelineTransportSettings =
        HttpJsonCallSettings.<UpdatePipelineRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePipelineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("pipeline.name", String.valueOf(request.getPipeline().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePipelineRequest, Operation> deletePipelineTransportSettings =
        HttpJsonCallSettings.<DeletePipelineRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePipelineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetGoogleApiSourceRequest, GoogleApiSource>
        getGoogleApiSourceTransportSettings =
            HttpJsonCallSettings.<GetGoogleApiSourceRequest, GoogleApiSource>newBuilder()
                .setMethodDescriptor(getGoogleApiSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
        listGoogleApiSourcesTransportSettings =
            HttpJsonCallSettings
                .<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>newBuilder()
                .setMethodDescriptor(listGoogleApiSourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateGoogleApiSourceRequest, Operation>
        createGoogleApiSourceTransportSettings =
            HttpJsonCallSettings.<CreateGoogleApiSourceRequest, Operation>newBuilder()
                .setMethodDescriptor(createGoogleApiSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateGoogleApiSourceRequest, Operation>
        updateGoogleApiSourceTransportSettings =
            HttpJsonCallSettings.<UpdateGoogleApiSourceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGoogleApiSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "google_api_source.name",
                          String.valueOf(request.getGoogleApiSource().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteGoogleApiSourceRequest, Operation>
        deleteGoogleApiSourceTransportSettings =
            HttpJsonCallSettings.<DeleteGoogleApiSourceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGoogleApiSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
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
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
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
    this.getGoogleChannelConfigCallable =
        callableFactory.createUnaryCallable(
            getGoogleChannelConfigTransportSettings,
            settings.getGoogleChannelConfigSettings(),
            clientContext);
    this.updateGoogleChannelConfigCallable =
        callableFactory.createUnaryCallable(
            updateGoogleChannelConfigTransportSettings,
            settings.updateGoogleChannelConfigSettings(),
            clientContext);
    this.getMessageBusCallable =
        callableFactory.createUnaryCallable(
            getMessageBusTransportSettings, settings.getMessageBusSettings(), clientContext);
    this.listMessageBusesCallable =
        callableFactory.createUnaryCallable(
            listMessageBusesTransportSettings, settings.listMessageBusesSettings(), clientContext);
    this.listMessageBusesPagedCallable =
        callableFactory.createPagedCallable(
            listMessageBusesTransportSettings, settings.listMessageBusesSettings(), clientContext);
    this.listMessageBusEnrollmentsCallable =
        callableFactory.createUnaryCallable(
            listMessageBusEnrollmentsTransportSettings,
            settings.listMessageBusEnrollmentsSettings(),
            clientContext);
    this.listMessageBusEnrollmentsPagedCallable =
        callableFactory.createPagedCallable(
            listMessageBusEnrollmentsTransportSettings,
            settings.listMessageBusEnrollmentsSettings(),
            clientContext);
    this.createMessageBusCallable =
        callableFactory.createUnaryCallable(
            createMessageBusTransportSettings, settings.createMessageBusSettings(), clientContext);
    this.createMessageBusOperationCallable =
        callableFactory.createOperationCallable(
            createMessageBusTransportSettings,
            settings.createMessageBusOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateMessageBusCallable =
        callableFactory.createUnaryCallable(
            updateMessageBusTransportSettings, settings.updateMessageBusSettings(), clientContext);
    this.updateMessageBusOperationCallable =
        callableFactory.createOperationCallable(
            updateMessageBusTransportSettings,
            settings.updateMessageBusOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteMessageBusCallable =
        callableFactory.createUnaryCallable(
            deleteMessageBusTransportSettings, settings.deleteMessageBusSettings(), clientContext);
    this.deleteMessageBusOperationCallable =
        callableFactory.createOperationCallable(
            deleteMessageBusTransportSettings,
            settings.deleteMessageBusOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getEnrollmentCallable =
        callableFactory.createUnaryCallable(
            getEnrollmentTransportSettings, settings.getEnrollmentSettings(), clientContext);
    this.listEnrollmentsCallable =
        callableFactory.createUnaryCallable(
            listEnrollmentsTransportSettings, settings.listEnrollmentsSettings(), clientContext);
    this.listEnrollmentsPagedCallable =
        callableFactory.createPagedCallable(
            listEnrollmentsTransportSettings, settings.listEnrollmentsSettings(), clientContext);
    this.createEnrollmentCallable =
        callableFactory.createUnaryCallable(
            createEnrollmentTransportSettings, settings.createEnrollmentSettings(), clientContext);
    this.createEnrollmentOperationCallable =
        callableFactory.createOperationCallable(
            createEnrollmentTransportSettings,
            settings.createEnrollmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEnrollmentCallable =
        callableFactory.createUnaryCallable(
            updateEnrollmentTransportSettings, settings.updateEnrollmentSettings(), clientContext);
    this.updateEnrollmentOperationCallable =
        callableFactory.createOperationCallable(
            updateEnrollmentTransportSettings,
            settings.updateEnrollmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEnrollmentCallable =
        callableFactory.createUnaryCallable(
            deleteEnrollmentTransportSettings, settings.deleteEnrollmentSettings(), clientContext);
    this.deleteEnrollmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteEnrollmentTransportSettings,
            settings.deleteEnrollmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getPipelineCallable =
        callableFactory.createUnaryCallable(
            getPipelineTransportSettings, settings.getPipelineSettings(), clientContext);
    this.listPipelinesCallable =
        callableFactory.createUnaryCallable(
            listPipelinesTransportSettings, settings.listPipelinesSettings(), clientContext);
    this.listPipelinesPagedCallable =
        callableFactory.createPagedCallable(
            listPipelinesTransportSettings, settings.listPipelinesSettings(), clientContext);
    this.createPipelineCallable =
        callableFactory.createUnaryCallable(
            createPipelineTransportSettings, settings.createPipelineSettings(), clientContext);
    this.createPipelineOperationCallable =
        callableFactory.createOperationCallable(
            createPipelineTransportSettings,
            settings.createPipelineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePipelineCallable =
        callableFactory.createUnaryCallable(
            updatePipelineTransportSettings, settings.updatePipelineSettings(), clientContext);
    this.updatePipelineOperationCallable =
        callableFactory.createOperationCallable(
            updatePipelineTransportSettings,
            settings.updatePipelineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePipelineCallable =
        callableFactory.createUnaryCallable(
            deletePipelineTransportSettings, settings.deletePipelineSettings(), clientContext);
    this.deletePipelineOperationCallable =
        callableFactory.createOperationCallable(
            deletePipelineTransportSettings,
            settings.deletePipelineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getGoogleApiSourceCallable =
        callableFactory.createUnaryCallable(
            getGoogleApiSourceTransportSettings,
            settings.getGoogleApiSourceSettings(),
            clientContext);
    this.listGoogleApiSourcesCallable =
        callableFactory.createUnaryCallable(
            listGoogleApiSourcesTransportSettings,
            settings.listGoogleApiSourcesSettings(),
            clientContext);
    this.listGoogleApiSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listGoogleApiSourcesTransportSettings,
            settings.listGoogleApiSourcesSettings(),
            clientContext);
    this.createGoogleApiSourceCallable =
        callableFactory.createUnaryCallable(
            createGoogleApiSourceTransportSettings,
            settings.createGoogleApiSourceSettings(),
            clientContext);
    this.createGoogleApiSourceOperationCallable =
        callableFactory.createOperationCallable(
            createGoogleApiSourceTransportSettings,
            settings.createGoogleApiSourceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateGoogleApiSourceCallable =
        callableFactory.createUnaryCallable(
            updateGoogleApiSourceTransportSettings,
            settings.updateGoogleApiSourceSettings(),
            clientContext);
    this.updateGoogleApiSourceOperationCallable =
        callableFactory.createOperationCallable(
            updateGoogleApiSourceTransportSettings,
            settings.updateGoogleApiSourceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGoogleApiSourceCallable =
        callableFactory.createUnaryCallable(
            deleteGoogleApiSourceTransportSettings,
            settings.deleteGoogleApiSourceSettings(),
            clientContext);
    this.deleteGoogleApiSourceOperationCallable =
        callableFactory.createOperationCallable(
            deleteGoogleApiSourceTransportSettings,
            settings.deleteGoogleApiSourceOperationSettings(),
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

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
    methodDescriptors.add(getGoogleChannelConfigMethodDescriptor);
    methodDescriptors.add(updateGoogleChannelConfigMethodDescriptor);
    methodDescriptors.add(getMessageBusMethodDescriptor);
    methodDescriptors.add(listMessageBusesMethodDescriptor);
    methodDescriptors.add(listMessageBusEnrollmentsMethodDescriptor);
    methodDescriptors.add(createMessageBusMethodDescriptor);
    methodDescriptors.add(updateMessageBusMethodDescriptor);
    methodDescriptors.add(deleteMessageBusMethodDescriptor);
    methodDescriptors.add(getEnrollmentMethodDescriptor);
    methodDescriptors.add(listEnrollmentsMethodDescriptor);
    methodDescriptors.add(createEnrollmentMethodDescriptor);
    methodDescriptors.add(updateEnrollmentMethodDescriptor);
    methodDescriptors.add(deleteEnrollmentMethodDescriptor);
    methodDescriptors.add(getPipelineMethodDescriptor);
    methodDescriptors.add(listPipelinesMethodDescriptor);
    methodDescriptors.add(createPipelineMethodDescriptor);
    methodDescriptors.add(updatePipelineMethodDescriptor);
    methodDescriptors.add(deletePipelineMethodDescriptor);
    methodDescriptors.add(getGoogleApiSourceMethodDescriptor);
    methodDescriptors.add(listGoogleApiSourcesMethodDescriptor);
    methodDescriptors.add(createGoogleApiSourceMethodDescriptor);
    methodDescriptors.add(updateGoogleApiSourceMethodDescriptor);
    methodDescriptors.add(deleteGoogleApiSourceMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
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
  public UnaryCallable<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigCallable() {
    return getGoogleChannelConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigCallable() {
    return updateGoogleChannelConfigCallable;
  }

  @Override
  public UnaryCallable<GetMessageBusRequest, MessageBus> getMessageBusCallable() {
    return getMessageBusCallable;
  }

  @Override
  public UnaryCallable<ListMessageBusesRequest, ListMessageBusesResponse>
      listMessageBusesCallable() {
    return listMessageBusesCallable;
  }

  @Override
  public UnaryCallable<ListMessageBusesRequest, ListMessageBusesPagedResponse>
      listMessageBusesPagedCallable() {
    return listMessageBusesPagedCallable;
  }

  @Override
  public UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
      listMessageBusEnrollmentsCallable() {
    return listMessageBusEnrollmentsCallable;
  }

  @Override
  public UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsPagedResponse>
      listMessageBusEnrollmentsPagedCallable() {
    return listMessageBusEnrollmentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateMessageBusRequest, Operation> createMessageBusCallable() {
    return createMessageBusCallable;
  }

  @Override
  public OperationCallable<CreateMessageBusRequest, MessageBus, OperationMetadata>
      createMessageBusOperationCallable() {
    return createMessageBusOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMessageBusRequest, Operation> updateMessageBusCallable() {
    return updateMessageBusCallable;
  }

  @Override
  public OperationCallable<UpdateMessageBusRequest, MessageBus, OperationMetadata>
      updateMessageBusOperationCallable() {
    return updateMessageBusOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMessageBusRequest, Operation> deleteMessageBusCallable() {
    return deleteMessageBusCallable;
  }

  @Override
  public OperationCallable<DeleteMessageBusRequest, MessageBus, OperationMetadata>
      deleteMessageBusOperationCallable() {
    return deleteMessageBusOperationCallable;
  }

  @Override
  public UnaryCallable<GetEnrollmentRequest, Enrollment> getEnrollmentCallable() {
    return getEnrollmentCallable;
  }

  @Override
  public UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsResponse> listEnrollmentsCallable() {
    return listEnrollmentsCallable;
  }

  @Override
  public UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsPagedResponse>
      listEnrollmentsPagedCallable() {
    return listEnrollmentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateEnrollmentRequest, Operation> createEnrollmentCallable() {
    return createEnrollmentCallable;
  }

  @Override
  public OperationCallable<CreateEnrollmentRequest, Enrollment, OperationMetadata>
      createEnrollmentOperationCallable() {
    return createEnrollmentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEnrollmentRequest, Operation> updateEnrollmentCallable() {
    return updateEnrollmentCallable;
  }

  @Override
  public OperationCallable<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
      updateEnrollmentOperationCallable() {
    return updateEnrollmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEnrollmentRequest, Operation> deleteEnrollmentCallable() {
    return deleteEnrollmentCallable;
  }

  @Override
  public OperationCallable<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
      deleteEnrollmentOperationCallable() {
    return deleteEnrollmentOperationCallable;
  }

  @Override
  public UnaryCallable<GetPipelineRequest, Pipeline> getPipelineCallable() {
    return getPipelineCallable;
  }

  @Override
  public UnaryCallable<ListPipelinesRequest, ListPipelinesResponse> listPipelinesCallable() {
    return listPipelinesCallable;
  }

  @Override
  public UnaryCallable<ListPipelinesRequest, ListPipelinesPagedResponse>
      listPipelinesPagedCallable() {
    return listPipelinesPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePipelineRequest, Operation> createPipelineCallable() {
    return createPipelineCallable;
  }

  @Override
  public OperationCallable<CreatePipelineRequest, Pipeline, OperationMetadata>
      createPipelineOperationCallable() {
    return createPipelineOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePipelineRequest, Operation> updatePipelineCallable() {
    return updatePipelineCallable;
  }

  @Override
  public OperationCallable<UpdatePipelineRequest, Pipeline, OperationMetadata>
      updatePipelineOperationCallable() {
    return updatePipelineOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePipelineRequest, Operation> deletePipelineCallable() {
    return deletePipelineCallable;
  }

  @Override
  public OperationCallable<DeletePipelineRequest, Pipeline, OperationMetadata>
      deletePipelineOperationCallable() {
    return deletePipelineOperationCallable;
  }

  @Override
  public UnaryCallable<GetGoogleApiSourceRequest, GoogleApiSource> getGoogleApiSourceCallable() {
    return getGoogleApiSourceCallable;
  }

  @Override
  public UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
      listGoogleApiSourcesCallable() {
    return listGoogleApiSourcesCallable;
  }

  @Override
  public UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesPagedResponse>
      listGoogleApiSourcesPagedCallable() {
    return listGoogleApiSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateGoogleApiSourceRequest, Operation> createGoogleApiSourceCallable() {
    return createGoogleApiSourceCallable;
  }

  @Override
  public OperationCallable<CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      createGoogleApiSourceOperationCallable() {
    return createGoogleApiSourceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGoogleApiSourceRequest, Operation> updateGoogleApiSourceCallable() {
    return updateGoogleApiSourceCallable;
  }

  @Override
  public OperationCallable<UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      updateGoogleApiSourceOperationCallable() {
    return updateGoogleApiSourceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGoogleApiSourceRequest, Operation> deleteGoogleApiSourceCallable() {
    return deleteGoogleApiSourceCallable;
  }

  @Override
  public OperationCallable<DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      deleteGoogleApiSourceOperationCallable() {
    return deleteGoogleApiSourceOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
