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
import static com.google.cloud.eventarc.v1.EventarcClient.ListLocationsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.GetProviderRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.GoogleChannelConfig;
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
import com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Eventarc service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEventarcStub extends EventarcStub {
  private static final MethodDescriptor<GetTriggerRequest, Trigger> getTriggerMethodDescriptor =
      MethodDescriptor.<GetTriggerRequest, Trigger>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetTrigger")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTriggerRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trigger.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTriggersRequest, ListTriggersResponse>
      listTriggersMethodDescriptor =
          MethodDescriptor.<ListTriggersRequest, ListTriggersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListTriggers")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTriggersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTriggersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTriggerRequest, Operation>
      createTriggerMethodDescriptor =
          MethodDescriptor.<CreateTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTriggerRequest, Operation>
      updateTriggerMethodDescriptor =
          MethodDescriptor.<UpdateTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTriggerRequest, Operation>
      deleteTriggerMethodDescriptor =
          MethodDescriptor.<DeleteTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetChannelRequest, Channel> getChannelMethodDescriptor =
      MethodDescriptor.<GetChannelRequest, Channel>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetChannel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetChannelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Channel.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListChannelsRequest, ListChannelsResponse>
      listChannelsMethodDescriptor =
          MethodDescriptor.<ListChannelsRequest, ListChannelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListChannels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChannelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateChannelRequest, Operation>
      createChannelMethodDescriptor =
          MethodDescriptor.<CreateChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateChannelRequest, Operation>
      updateChannelMethodDescriptor =
          MethodDescriptor.<UpdateChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteChannelRequest, Operation>
      deleteChannelMethodDescriptor =
          MethodDescriptor.<DeleteChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProviderRequest, Provider> getProviderMethodDescriptor =
      MethodDescriptor.<GetProviderRequest, Provider>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetProvider")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProviderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Provider.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListProvidersRequest, ListProvidersResponse>
      listProvidersMethodDescriptor =
          MethodDescriptor.<ListProvidersRequest, ListProvidersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListProviders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProvidersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProvidersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionMethodDescriptor =
          MethodDescriptor.<GetChannelConnectionRequest, ChannelConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetChannelConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetChannelConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChannelConnection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsMethodDescriptor =
          MethodDescriptor
              .<ListChannelConnectionsRequest, ListChannelConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListChannelConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListChannelConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChannelConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateChannelConnectionRequest, Operation>
      createChannelConnectionMethodDescriptor =
          MethodDescriptor.<CreateChannelConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateChannelConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateChannelConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionMethodDescriptor =
          MethodDescriptor.<DeleteChannelConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteChannelConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteChannelConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigMethodDescriptor =
          MethodDescriptor.<GetGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetGoogleChannelConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGoogleChannelConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GoogleChannelConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigMethodDescriptor =
          MethodDescriptor.<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateGoogleChannelConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGoogleChannelConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GoogleChannelConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
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
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEventarcStub create(EventarcStubSettings settings) throws IOException {
    return new GrpcEventarcStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEventarcStub create(ClientContext clientContext) throws IOException {
    return new GrpcEventarcStub(EventarcStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEventarcStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEventarcStub(
        EventarcStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEventarcStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcEventarcStub(EventarcStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEventarcCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEventarcStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcEventarcStub(
      EventarcStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetTriggerRequest, Trigger> getTriggerTransportSettings =
        GrpcCallSettings.<GetTriggerRequest, Trigger>newBuilder()
            .setMethodDescriptor(getTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListTriggersRequest, ListTriggersResponse> listTriggersTransportSettings =
        GrpcCallSettings.<ListTriggersRequest, ListTriggersResponse>newBuilder()
            .setMethodDescriptor(listTriggersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateTriggerRequest, Operation> createTriggerTransportSettings =
        GrpcCallSettings.<CreateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(createTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateTriggerRequest, Operation> updateTriggerTransportSettings =
        GrpcCallSettings.<UpdateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("trigger.name", String.valueOf(request.getTrigger().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteTriggerRequest, Operation> deleteTriggerTransportSettings =
        GrpcCallSettings.<DeleteTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetChannelRequest, Channel> getChannelTransportSettings =
        GrpcCallSettings.<GetChannelRequest, Channel>newBuilder()
            .setMethodDescriptor(getChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListChannelsRequest, ListChannelsResponse> listChannelsTransportSettings =
        GrpcCallSettings.<ListChannelsRequest, ListChannelsResponse>newBuilder()
            .setMethodDescriptor(listChannelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateChannelRequest, Operation> createChannelTransportSettings =
        GrpcCallSettings.<CreateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(createChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateChannelRequest, Operation> updateChannelTransportSettings =
        GrpcCallSettings.<UpdateChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("channel.name", String.valueOf(request.getChannel().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteChannelRequest, Operation> deleteChannelTransportSettings =
        GrpcCallSettings.<DeleteChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetProviderRequest, Provider> getProviderTransportSettings =
        GrpcCallSettings.<GetProviderRequest, Provider>newBuilder()
            .setMethodDescriptor(getProviderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListProvidersRequest, ListProvidersResponse> listProvidersTransportSettings =
        GrpcCallSettings.<ListProvidersRequest, ListProvidersResponse>newBuilder()
            .setMethodDescriptor(listProvidersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetChannelConnectionRequest, ChannelConnection>
        getChannelConnectionTransportSettings =
            GrpcCallSettings.<GetChannelConnectionRequest, ChannelConnection>newBuilder()
                .setMethodDescriptor(getChannelConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
        listChannelConnectionsTransportSettings =
            GrpcCallSettings
                .<ListChannelConnectionsRequest, ListChannelConnectionsResponse>newBuilder()
                .setMethodDescriptor(listChannelConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateChannelConnectionRequest, Operation>
        createChannelConnectionTransportSettings =
            GrpcCallSettings.<CreateChannelConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createChannelConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteChannelConnectionRequest, Operation>
        deleteChannelConnectionTransportSettings =
            GrpcCallSettings.<DeleteChannelConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteChannelConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetGoogleChannelConfigRequest, GoogleChannelConfig>
        getGoogleChannelConfigTransportSettings =
            GrpcCallSettings.<GetGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
                .setMethodDescriptor(getGoogleChannelConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
        updateGoogleChannelConfigTransportSettings =
            GrpcCallSettings.<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>newBuilder()
                .setMethodDescriptor(updateGoogleChannelConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "google_channel_config.name",
                          String.valueOf(request.getGoogleChannelConfig().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
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
            operationsStub);
    this.updateTriggerCallable =
        callableFactory.createUnaryCallable(
            updateTriggerTransportSettings, settings.updateTriggerSettings(), clientContext);
    this.updateTriggerOperationCallable =
        callableFactory.createOperationCallable(
            updateTriggerTransportSettings,
            settings.updateTriggerOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTriggerCallable =
        callableFactory.createUnaryCallable(
            deleteTriggerTransportSettings, settings.deleteTriggerSettings(), clientContext);
    this.deleteTriggerOperationCallable =
        callableFactory.createOperationCallable(
            deleteTriggerTransportSettings,
            settings.deleteTriggerOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateChannelCallable =
        callableFactory.createUnaryCallable(
            updateChannelTransportSettings, settings.updateChannelSettings(), clientContext);
    this.updateChannelOperationCallable =
        callableFactory.createOperationCallable(
            updateChannelTransportSettings,
            settings.updateChannelOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteChannelCallable =
        callableFactory.createUnaryCallable(
            deleteChannelTransportSettings, settings.deleteChannelSettings(), clientContext);
    this.deleteChannelOperationCallable =
        callableFactory.createOperationCallable(
            deleteChannelTransportSettings,
            settings.deleteChannelOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
