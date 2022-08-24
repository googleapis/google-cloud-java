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

package com.google.cloud.datastream.v1alpha1.stub;

import static com.google.cloud.datastream.v1alpha1.DatastreamClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListPrivateConnectionsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListRoutesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListStreamsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datastream.v1alpha1.ConnectionProfile;
import com.google.cloud.datastream.v1alpha1.CreateConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.CreatePrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.CreateRouteRequest;
import com.google.cloud.datastream.v1alpha1.CreateStreamRequest;
import com.google.cloud.datastream.v1alpha1.DeleteConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.DeletePrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.DeleteRouteRequest;
import com.google.cloud.datastream.v1alpha1.DeleteStreamRequest;
import com.google.cloud.datastream.v1alpha1.DiscoverConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.DiscoverConnectionProfileResponse;
import com.google.cloud.datastream.v1alpha1.FetchErrorsRequest;
import com.google.cloud.datastream.v1alpha1.FetchErrorsResponse;
import com.google.cloud.datastream.v1alpha1.FetchStaticIpsRequest;
import com.google.cloud.datastream.v1alpha1.FetchStaticIpsResponse;
import com.google.cloud.datastream.v1alpha1.GetConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.GetPrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.GetRouteRequest;
import com.google.cloud.datastream.v1alpha1.GetStreamRequest;
import com.google.cloud.datastream.v1alpha1.ListConnectionProfilesRequest;
import com.google.cloud.datastream.v1alpha1.ListConnectionProfilesResponse;
import com.google.cloud.datastream.v1alpha1.ListPrivateConnectionsRequest;
import com.google.cloud.datastream.v1alpha1.ListPrivateConnectionsResponse;
import com.google.cloud.datastream.v1alpha1.ListRoutesRequest;
import com.google.cloud.datastream.v1alpha1.ListRoutesResponse;
import com.google.cloud.datastream.v1alpha1.ListStreamsRequest;
import com.google.cloud.datastream.v1alpha1.ListStreamsResponse;
import com.google.cloud.datastream.v1alpha1.OperationMetadata;
import com.google.cloud.datastream.v1alpha1.PrivateConnection;
import com.google.cloud.datastream.v1alpha1.Route;
import com.google.cloud.datastream.v1alpha1.Stream;
import com.google.cloud.datastream.v1alpha1.UpdateConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.UpdateStreamRequest;
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
 * gRPC stub implementation for the Datastream service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDatastreamStub extends DatastreamStub {
  private static final MethodDescriptor<
          ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesMethodDescriptor =
          MethodDescriptor
              .<ListConnectionProfilesRequest, ListConnectionProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/ListConnectionProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectionProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectionProfilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileMethodDescriptor =
          MethodDescriptor.<GetConnectionProfileRequest, ConnectionProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/GetConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConnectionProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConnectionProfileRequest, Operation>
      createConnectionProfileMethodDescriptor =
          MethodDescriptor.<CreateConnectionProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/CreateConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileMethodDescriptor =
          MethodDescriptor.<UpdateConnectionProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/UpdateConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileMethodDescriptor =
          MethodDescriptor.<DeleteConnectionProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/DeleteConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileMethodDescriptor =
          MethodDescriptor
              .<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/DiscoverConnectionProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiscoverConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DiscoverConnectionProfileResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListStreamsRequest, ListStreamsResponse>
      listStreamsMethodDescriptor =
          MethodDescriptor.<ListStreamsRequest, ListStreamsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/ListStreams")
              .setRequestMarshaller(ProtoUtils.marshaller(ListStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListStreamsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetStreamRequest, Stream> getStreamMethodDescriptor =
      MethodDescriptor.<GetStreamRequest, Stream>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/GetStream")
          .setRequestMarshaller(ProtoUtils.marshaller(GetStreamRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Stream.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateStreamRequest, Operation>
      createStreamMethodDescriptor =
          MethodDescriptor.<CreateStreamRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/CreateStream")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateStreamRequest, Operation>
      updateStreamMethodDescriptor =
          MethodDescriptor.<UpdateStreamRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/UpdateStream")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteStreamRequest, Operation>
      deleteStreamMethodDescriptor =
          MethodDescriptor.<DeleteStreamRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/DeleteStream")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchErrorsRequest, Operation> fetchErrorsMethodDescriptor =
      MethodDescriptor.<FetchErrorsRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/FetchErrors")
          .setRequestMarshaller(ProtoUtils.marshaller(FetchErrorsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<FetchStaticIpsRequest, FetchStaticIpsResponse>
      fetchStaticIpsMethodDescriptor =
          MethodDescriptor.<FetchStaticIpsRequest, FetchStaticIpsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/FetchStaticIps")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchStaticIpsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchStaticIpsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionMethodDescriptor =
          MethodDescriptor.<CreatePrivateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/CreatePrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionMethodDescriptor =
          MethodDescriptor.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/GetPrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateConnection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsMethodDescriptor =
          MethodDescriptor
              .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/ListPrivateConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPrivateConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPrivateConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionMethodDescriptor =
          MethodDescriptor.<DeletePrivateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/DeletePrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRouteRequest, Operation> createRouteMethodDescriptor =
      MethodDescriptor.<CreateRouteRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/CreateRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetRouteRequest, Route> getRouteMethodDescriptor =
      MethodDescriptor.<GetRouteRequest, Route>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/GetRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Route.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRoutesRequest, ListRoutesResponse>
      listRoutesMethodDescriptor =
          MethodDescriptor.<ListRoutesRequest, ListRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/ListRoutes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRoutesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRouteRequest, Operation> deleteRouteMethodDescriptor =
      MethodDescriptor.<DeleteRouteRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/DeleteRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable;
  private final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable;
  private final UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable;
  private final UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable;
  private final OperationCallable<
          CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable;
  private final UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable;
  private final OperationCallable<
          UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable;
  private final UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable;
  private final OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable;
  private final UnaryCallable<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileCallable;
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
  private final UnaryCallable<FetchErrorsRequest, Operation> fetchErrorsCallable;
  private final OperationCallable<FetchErrorsRequest, FetchErrorsResponse, OperationMetadata>
      fetchErrorsOperationCallable;
  private final UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> fetchStaticIpsCallable;
  private final UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable;
  private final UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable;
  private final OperationCallable<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable;
  private final UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable;
  private final UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable;
  private final OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable;
  private final UnaryCallable<CreateRouteRequest, Operation> createRouteCallable;
  private final OperationCallable<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationCallable;
  private final UnaryCallable<GetRouteRequest, Route> getRouteCallable;
  private final UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable;
  private final UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable;
  private final UnaryCallable<DeleteRouteRequest, Operation> deleteRouteCallable;
  private final OperationCallable<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDatastreamStub create(DatastreamStubSettings settings)
      throws IOException {
    return new GrpcDatastreamStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDatastreamStub create(ClientContext clientContext) throws IOException {
    return new GrpcDatastreamStub(DatastreamStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDatastreamStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDatastreamStub(
        DatastreamStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDatastreamStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatastreamStub(DatastreamStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDatastreamCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDatastreamStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatastreamStub(
      DatastreamStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
        listConnectionProfilesTransportSettings =
            GrpcCallSettings
                .<ListConnectionProfilesRequest, ListConnectionProfilesResponse>newBuilder()
                .setMethodDescriptor(listConnectionProfilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileTransportSettings =
            GrpcCallSettings.<GetConnectionProfileRequest, ConnectionProfile>newBuilder()
                .setMethodDescriptor(getConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateConnectionProfileRequest, Operation>
        createConnectionProfileTransportSettings =
            GrpcCallSettings.<CreateConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(createConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileTransportSettings =
            GrpcCallSettings.<UpdateConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "connection_profile.name",
                          String.valueOf(request.getConnectionProfile().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileTransportSettings =
            GrpcCallSettings.<DeleteConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
        discoverConnectionProfileTransportSettings =
            GrpcCallSettings
                .<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>newBuilder()
                .setMethodDescriptor(discoverConnectionProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListStreamsRequest, ListStreamsResponse> listStreamsTransportSettings =
        GrpcCallSettings.<ListStreamsRequest, ListStreamsResponse>newBuilder()
            .setMethodDescriptor(listStreamsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetStreamRequest, Stream> getStreamTransportSettings =
        GrpcCallSettings.<GetStreamRequest, Stream>newBuilder()
            .setMethodDescriptor(getStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateStreamRequest, Operation> createStreamTransportSettings =
        GrpcCallSettings.<CreateStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(createStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateStreamRequest, Operation> updateStreamTransportSettings =
        GrpcCallSettings.<UpdateStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(updateStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("stream.name", String.valueOf(request.getStream().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteStreamRequest, Operation> deleteStreamTransportSettings =
        GrpcCallSettings.<DeleteStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<FetchErrorsRequest, Operation> fetchErrorsTransportSettings =
        GrpcCallSettings.<FetchErrorsRequest, Operation>newBuilder()
            .setMethodDescriptor(fetchErrorsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("stream", String.valueOf(request.getStream()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<FetchStaticIpsRequest, FetchStaticIpsResponse>
        fetchStaticIpsTransportSettings =
            GrpcCallSettings.<FetchStaticIpsRequest, FetchStaticIpsResponse>newBuilder()
                .setMethodDescriptor(fetchStaticIpsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionTransportSettings =
            GrpcCallSettings.<CreatePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createPrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionTransportSettings =
            GrpcCallSettings.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
                .setMethodDescriptor(getPrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
        listPrivateConnectionsTransportSettings =
            GrpcCallSettings
                .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
                .setMethodDescriptor(listPrivateConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionTransportSettings =
            GrpcCallSettings.<DeletePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateRouteRequest, Operation> createRouteTransportSettings =
        GrpcCallSettings.<CreateRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetRouteRequest, Route> getRouteTransportSettings =
        GrpcCallSettings.<GetRouteRequest, Route>newBuilder()
            .setMethodDescriptor(getRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListRoutesRequest, ListRoutesResponse> listRoutesTransportSettings =
        GrpcCallSettings.<ListRoutesRequest, ListRoutesResponse>newBuilder()
            .setMethodDescriptor(listRoutesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteRouteRequest, Operation> deleteRouteTransportSettings =
        GrpcCallSettings.<DeleteRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listConnectionProfilesCallable =
        callableFactory.createUnaryCallable(
            listConnectionProfilesTransportSettings,
            settings.listConnectionProfilesSettings(),
            clientContext);
    this.listConnectionProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionProfilesTransportSettings,
            settings.listConnectionProfilesSettings(),
            clientContext);
    this.getConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            getConnectionProfileTransportSettings,
            settings.getConnectionProfileSettings(),
            clientContext);
    this.createConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            createConnectionProfileTransportSettings,
            settings.createConnectionProfileSettings(),
            clientContext);
    this.createConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            createConnectionProfileTransportSettings,
            settings.createConnectionProfileOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            updateConnectionProfileTransportSettings,
            settings.updateConnectionProfileSettings(),
            clientContext);
    this.updateConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectionProfileTransportSettings,
            settings.updateConnectionProfileOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionProfileTransportSettings,
            settings.deleteConnectionProfileSettings(),
            clientContext);
    this.deleteConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectionProfileTransportSettings,
            settings.deleteConnectionProfileOperationSettings(),
            clientContext,
            operationsStub);
    this.discoverConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            discoverConnectionProfileTransportSettings,
            settings.discoverConnectionProfileSettings(),
            clientContext);
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
            operationsStub);
    this.updateStreamCallable =
        callableFactory.createUnaryCallable(
            updateStreamTransportSettings, settings.updateStreamSettings(), clientContext);
    this.updateStreamOperationCallable =
        callableFactory.createOperationCallable(
            updateStreamTransportSettings,
            settings.updateStreamOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteStreamCallable =
        callableFactory.createUnaryCallable(
            deleteStreamTransportSettings, settings.deleteStreamSettings(), clientContext);
    this.deleteStreamOperationCallable =
        callableFactory.createOperationCallable(
            deleteStreamTransportSettings,
            settings.deleteStreamOperationSettings(),
            clientContext,
            operationsStub);
    this.fetchErrorsCallable =
        callableFactory.createUnaryCallable(
            fetchErrorsTransportSettings, settings.fetchErrorsSettings(), clientContext);
    this.fetchErrorsOperationCallable =
        callableFactory.createOperationCallable(
            fetchErrorsTransportSettings,
            settings.fetchErrorsOperationSettings(),
            clientContext,
            operationsStub);
    this.fetchStaticIpsCallable =
        callableFactory.createUnaryCallable(
            fetchStaticIpsTransportSettings, settings.fetchStaticIpsSettings(), clientContext);
    this.fetchStaticIpsPagedCallable =
        callableFactory.createPagedCallable(
            fetchStaticIpsTransportSettings, settings.fetchStaticIpsSettings(), clientContext);
    this.createPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionSettings(),
            clientContext);
    this.createPrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.getPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            getPrivateConnectionTransportSettings,
            settings.getPrivateConnectionSettings(),
            clientContext);
    this.listPrivateConnectionsCallable =
        callableFactory.createUnaryCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.listPrivateConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.deletePrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionSettings(),
            clientContext);
    this.deletePrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.createRouteCallable =
        callableFactory.createUnaryCallable(
            createRouteTransportSettings, settings.createRouteSettings(), clientContext);
    this.createRouteOperationCallable =
        callableFactory.createOperationCallable(
            createRouteTransportSettings,
            settings.createRouteOperationSettings(),
            clientContext,
            operationsStub);
    this.getRouteCallable =
        callableFactory.createUnaryCallable(
            getRouteTransportSettings, settings.getRouteSettings(), clientContext);
    this.listRoutesCallable =
        callableFactory.createUnaryCallable(
            listRoutesTransportSettings, settings.listRoutesSettings(), clientContext);
    this.listRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listRoutesTransportSettings, settings.listRoutesSettings(), clientContext);
    this.deleteRouteCallable =
        callableFactory.createUnaryCallable(
            deleteRouteTransportSettings, settings.deleteRouteSettings(), clientContext);
    this.deleteRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteRouteTransportSettings,
            settings.deleteRouteOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable() {
    return listConnectionProfilesCallable;
  }

  @Override
  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable() {
    return listConnectionProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable() {
    return getConnectionProfileCallable;
  }

  @Override
  public UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable() {
    return createConnectionProfileCallable;
  }

  @Override
  public OperationCallable<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable() {
    return createConnectionProfileOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable() {
    return updateConnectionProfileCallable;
  }

  @Override
  public OperationCallable<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable() {
    return updateConnectionProfileOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable() {
    return deleteConnectionProfileCallable;
  }

  @Override
  public OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable() {
    return deleteConnectionProfileOperationCallable;
  }

  @Override
  public UnaryCallable<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileCallable() {
    return discoverConnectionProfileCallable;
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
  public UnaryCallable<FetchErrorsRequest, Operation> fetchErrorsCallable() {
    return fetchErrorsCallable;
  }

  @Override
  public OperationCallable<FetchErrorsRequest, FetchErrorsResponse, OperationMetadata>
      fetchErrorsOperationCallable() {
    return fetchErrorsOperationCallable;
  }

  @Override
  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> fetchStaticIpsCallable() {
    return fetchStaticIpsCallable;
  }

  @Override
  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable() {
    return fetchStaticIpsPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    return createPrivateConnectionCallable;
  }

  @Override
  public OperationCallable<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    return createPrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    return getPrivateConnectionCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    return listPrivateConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    return listPrivateConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    return deletePrivateConnectionCallable;
  }

  @Override
  public OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    return deletePrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<CreateRouteRequest, Operation> createRouteCallable() {
    return createRouteCallable;
  }

  @Override
  public OperationCallable<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationCallable() {
    return createRouteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRouteRequest, Route> getRouteCallable() {
    return getRouteCallable;
  }

  @Override
  public UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable() {
    return listRoutesCallable;
  }

  @Override
  public UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    return listRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRouteRequest, Operation> deleteRouteCallable() {
    return deleteRouteCallable;
  }

  @Override
  public OperationCallable<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationCallable() {
    return deleteRouteOperationCallable;
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
