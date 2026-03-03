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

package com.google.showcase.v1beta1.stub;

import static com.google.showcase.v1beta1.MessagingClient.ListBlurbsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListRoomsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.Blurb;
import com.google.showcase.v1beta1.ConnectRequest;
import com.google.showcase.v1beta1.CreateBlurbRequest;
import com.google.showcase.v1beta1.CreateRoomRequest;
import com.google.showcase.v1beta1.DeleteBlurbRequest;
import com.google.showcase.v1beta1.DeleteRoomRequest;
import com.google.showcase.v1beta1.GetBlurbRequest;
import com.google.showcase.v1beta1.GetRoomRequest;
import com.google.showcase.v1beta1.ListBlurbsRequest;
import com.google.showcase.v1beta1.ListBlurbsResponse;
import com.google.showcase.v1beta1.ListRoomsRequest;
import com.google.showcase.v1beta1.ListRoomsResponse;
import com.google.showcase.v1beta1.Room;
import com.google.showcase.v1beta1.SearchBlurbsMetadata;
import com.google.showcase.v1beta1.SearchBlurbsRequest;
import com.google.showcase.v1beta1.SearchBlurbsResponse;
import com.google.showcase.v1beta1.SendBlurbsResponse;
import com.google.showcase.v1beta1.StreamBlurbsRequest;
import com.google.showcase.v1beta1.StreamBlurbsResponse;
import com.google.showcase.v1beta1.UpdateBlurbRequest;
import com.google.showcase.v1beta1.UpdateRoomRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Messaging service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMessagingStub extends MessagingStub {
  private static final MethodDescriptor<CreateRoomRequest, Room> createRoomMethodDescriptor =
      MethodDescriptor.<CreateRoomRequest, Room>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Messaging/CreateRoom")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRoomRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Room.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetRoomRequest, Room> getRoomMethodDescriptor =
      MethodDescriptor.<GetRoomRequest, Room>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Messaging/GetRoom")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRoomRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Room.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateRoomRequest, Room> updateRoomMethodDescriptor =
      MethodDescriptor.<UpdateRoomRequest, Room>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Messaging/UpdateRoom")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateRoomRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Room.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteRoomRequest, Empty> deleteRoomMethodDescriptor =
      MethodDescriptor.<DeleteRoomRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Messaging/DeleteRoom")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRoomRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListRoomsRequest, ListRoomsResponse>
      listRoomsMethodDescriptor =
          MethodDescriptor.<ListRoomsRequest, ListRoomsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.Messaging/ListRooms")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRoomsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRoomsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBlurbRequest, Blurb> createBlurbMethodDescriptor =
      MethodDescriptor.<CreateBlurbRequest, Blurb>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Messaging/CreateBlurb")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateBlurbRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Blurb.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetBlurbRequest, Blurb> getBlurbMethodDescriptor =
      MethodDescriptor.<GetBlurbRequest, Blurb>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Messaging/GetBlurb")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBlurbRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Blurb.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateBlurbRequest, Blurb> updateBlurbMethodDescriptor =
      MethodDescriptor.<UpdateBlurbRequest, Blurb>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Messaging/UpdateBlurb")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateBlurbRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Blurb.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteBlurbRequest, Empty> deleteBlurbMethodDescriptor =
      MethodDescriptor.<DeleteBlurbRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.showcase.v1beta1.Messaging/DeleteBlurb")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBlurbRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListBlurbsRequest, ListBlurbsResponse>
      listBlurbsMethodDescriptor =
          MethodDescriptor.<ListBlurbsRequest, ListBlurbsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.Messaging/ListBlurbs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBlurbsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListBlurbsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchBlurbsRequest, Operation>
      searchBlurbsMethodDescriptor =
          MethodDescriptor.<SearchBlurbsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.showcase.v1beta1.Messaging/SearchBlurbs")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchBlurbsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<StreamBlurbsRequest, StreamBlurbsResponse>
      streamBlurbsMethodDescriptor =
          MethodDescriptor.<StreamBlurbsRequest, StreamBlurbsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.showcase.v1beta1.Messaging/StreamBlurbs")
              .setRequestMarshaller(ProtoUtils.marshaller(StreamBlurbsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamBlurbsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBlurbRequest, SendBlurbsResponse>
      sendBlurbsMethodDescriptor =
          MethodDescriptor.<CreateBlurbRequest, SendBlurbsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName("google.showcase.v1beta1.Messaging/SendBlurbs")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBlurbRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SendBlurbsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ConnectRequest, StreamBlurbsResponse>
      connectMethodDescriptor =
          MethodDescriptor.<ConnectRequest, StreamBlurbsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.showcase.v1beta1.Messaging/Connect")
              .setRequestMarshaller(ProtoUtils.marshaller(ConnectRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamBlurbsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateRoomRequest, Room> createRoomCallable;
  private final UnaryCallable<GetRoomRequest, Room> getRoomCallable;
  private final UnaryCallable<UpdateRoomRequest, Room> updateRoomCallable;
  private final UnaryCallable<DeleteRoomRequest, Empty> deleteRoomCallable;
  private final UnaryCallable<ListRoomsRequest, ListRoomsResponse> listRoomsCallable;
  private final UnaryCallable<ListRoomsRequest, ListRoomsPagedResponse> listRoomsPagedCallable;
  private final UnaryCallable<CreateBlurbRequest, Blurb> createBlurbCallable;
  private final UnaryCallable<GetBlurbRequest, Blurb> getBlurbCallable;
  private final UnaryCallable<UpdateBlurbRequest, Blurb> updateBlurbCallable;
  private final UnaryCallable<DeleteBlurbRequest, Empty> deleteBlurbCallable;
  private final UnaryCallable<ListBlurbsRequest, ListBlurbsResponse> listBlurbsCallable;
  private final UnaryCallable<ListBlurbsRequest, ListBlurbsPagedResponse> listBlurbsPagedCallable;
  private final UnaryCallable<SearchBlurbsRequest, Operation> searchBlurbsCallable;
  private final OperationCallable<SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
      searchBlurbsOperationCallable;
  private final ServerStreamingCallable<StreamBlurbsRequest, StreamBlurbsResponse>
      streamBlurbsCallable;
  private final ClientStreamingCallable<CreateBlurbRequest, SendBlurbsResponse> sendBlurbsCallable;
  private final BidiStreamingCallable<ConnectRequest, StreamBlurbsResponse> connectCallable;
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

  public static final GrpcMessagingStub create(MessagingStubSettings settings) throws IOException {
    return new GrpcMessagingStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMessagingStub create(ClientContext clientContext) throws IOException {
    return new GrpcMessagingStub(MessagingStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMessagingStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMessagingStub(
        MessagingStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMessagingStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMessagingStub(MessagingStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMessagingCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMessagingStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMessagingStub(
      MessagingStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateRoomRequest, Room> createRoomTransportSettings =
        GrpcCallSettings.<CreateRoomRequest, Room>newBuilder()
            .setMethodDescriptor(createRoomMethodDescriptor)
            .build();
    GrpcCallSettings<GetRoomRequest, Room> getRoomTransportSettings =
        GrpcCallSettings.<GetRoomRequest, Room>newBuilder()
            .setMethodDescriptor(getRoomMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRoomRequest, Room> updateRoomTransportSettings =
        GrpcCallSettings.<UpdateRoomRequest, Room>newBuilder()
            .setMethodDescriptor(updateRoomMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("room.name", String.valueOf(request.getRoom().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRoomRequest, Empty> deleteRoomTransportSettings =
        GrpcCallSettings.<DeleteRoomRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRoomMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRoomsRequest, ListRoomsResponse> listRoomsTransportSettings =
        GrpcCallSettings.<ListRoomsRequest, ListRoomsResponse>newBuilder()
            .setMethodDescriptor(listRoomsMethodDescriptor)
            .build();
    GrpcCallSettings<CreateBlurbRequest, Blurb> createBlurbTransportSettings =
        GrpcCallSettings.<CreateBlurbRequest, Blurb>newBuilder()
            .setMethodDescriptor(createBlurbMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBlurbRequest, Blurb> getBlurbTransportSettings =
        GrpcCallSettings.<GetBlurbRequest, Blurb>newBuilder()
            .setMethodDescriptor(getBlurbMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBlurbRequest, Blurb> updateBlurbTransportSettings =
        GrpcCallSettings.<UpdateBlurbRequest, Blurb>newBuilder()
            .setMethodDescriptor(updateBlurbMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("blurb.name", String.valueOf(request.getBlurb().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBlurbRequest, Empty> deleteBlurbTransportSettings =
        GrpcCallSettings.<DeleteBlurbRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBlurbMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBlurbsRequest, ListBlurbsResponse> listBlurbsTransportSettings =
        GrpcCallSettings.<ListBlurbsRequest, ListBlurbsResponse>newBuilder()
            .setMethodDescriptor(listBlurbsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchBlurbsRequest, Operation> searchBlurbsTransportSettings =
        GrpcCallSettings.<SearchBlurbsRequest, Operation>newBuilder()
            .setMethodDescriptor(searchBlurbsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StreamBlurbsRequest, StreamBlurbsResponse> streamBlurbsTransportSettings =
        GrpcCallSettings.<StreamBlurbsRequest, StreamBlurbsResponse>newBuilder()
            .setMethodDescriptor(streamBlurbsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBlurbRequest, SendBlurbsResponse> sendBlurbsTransportSettings =
        GrpcCallSettings.<CreateBlurbRequest, SendBlurbsResponse>newBuilder()
            .setMethodDescriptor(sendBlurbsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ConnectRequest, StreamBlurbsResponse> connectTransportSettings =
        GrpcCallSettings.<ConnectRequest, StreamBlurbsResponse>newBuilder()
            .setMethodDescriptor(connectMethodDescriptor)
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createRoomCallable =
        callableFactory.createUnaryCallable(
            createRoomTransportSettings, settings.createRoomSettings(), clientContext);
    this.getRoomCallable =
        callableFactory.createUnaryCallable(
            getRoomTransportSettings, settings.getRoomSettings(), clientContext);
    this.updateRoomCallable =
        callableFactory.createUnaryCallable(
            updateRoomTransportSettings, settings.updateRoomSettings(), clientContext);
    this.deleteRoomCallable =
        callableFactory.createUnaryCallable(
            deleteRoomTransportSettings, settings.deleteRoomSettings(), clientContext);
    this.listRoomsCallable =
        callableFactory.createUnaryCallable(
            listRoomsTransportSettings, settings.listRoomsSettings(), clientContext);
    this.listRoomsPagedCallable =
        callableFactory.createPagedCallable(
            listRoomsTransportSettings, settings.listRoomsSettings(), clientContext);
    this.createBlurbCallable =
        callableFactory.createUnaryCallable(
            createBlurbTransportSettings, settings.createBlurbSettings(), clientContext);
    this.getBlurbCallable =
        callableFactory.createUnaryCallable(
            getBlurbTransportSettings, settings.getBlurbSettings(), clientContext);
    this.updateBlurbCallable =
        callableFactory.createUnaryCallable(
            updateBlurbTransportSettings, settings.updateBlurbSettings(), clientContext);
    this.deleteBlurbCallable =
        callableFactory.createUnaryCallable(
            deleteBlurbTransportSettings, settings.deleteBlurbSettings(), clientContext);
    this.listBlurbsCallable =
        callableFactory.createUnaryCallable(
            listBlurbsTransportSettings, settings.listBlurbsSettings(), clientContext);
    this.listBlurbsPagedCallable =
        callableFactory.createPagedCallable(
            listBlurbsTransportSettings, settings.listBlurbsSettings(), clientContext);
    this.searchBlurbsCallable =
        callableFactory.createUnaryCallable(
            searchBlurbsTransportSettings, settings.searchBlurbsSettings(), clientContext);
    this.searchBlurbsOperationCallable =
        callableFactory.createOperationCallable(
            searchBlurbsTransportSettings,
            settings.searchBlurbsOperationSettings(),
            clientContext,
            operationsStub);
    this.streamBlurbsCallable =
        callableFactory.createServerStreamingCallable(
            streamBlurbsTransportSettings, settings.streamBlurbsSettings(), clientContext);
    this.sendBlurbsCallable =
        callableFactory.createClientStreamingCallable(
            sendBlurbsTransportSettings, settings.sendBlurbsSettings(), clientContext);
    this.connectCallable =
        callableFactory.createBidiStreamingCallable(
            connectTransportSettings, settings.connectSettings(), clientContext);
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
  public UnaryCallable<CreateRoomRequest, Room> createRoomCallable() {
    return createRoomCallable;
  }

  @Override
  public UnaryCallable<GetRoomRequest, Room> getRoomCallable() {
    return getRoomCallable;
  }

  @Override
  public UnaryCallable<UpdateRoomRequest, Room> updateRoomCallable() {
    return updateRoomCallable;
  }

  @Override
  public UnaryCallable<DeleteRoomRequest, Empty> deleteRoomCallable() {
    return deleteRoomCallable;
  }

  @Override
  public UnaryCallable<ListRoomsRequest, ListRoomsResponse> listRoomsCallable() {
    return listRoomsCallable;
  }

  @Override
  public UnaryCallable<ListRoomsRequest, ListRoomsPagedResponse> listRoomsPagedCallable() {
    return listRoomsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateBlurbRequest, Blurb> createBlurbCallable() {
    return createBlurbCallable;
  }

  @Override
  public UnaryCallable<GetBlurbRequest, Blurb> getBlurbCallable() {
    return getBlurbCallable;
  }

  @Override
  public UnaryCallable<UpdateBlurbRequest, Blurb> updateBlurbCallable() {
    return updateBlurbCallable;
  }

  @Override
  public UnaryCallable<DeleteBlurbRequest, Empty> deleteBlurbCallable() {
    return deleteBlurbCallable;
  }

  @Override
  public UnaryCallable<ListBlurbsRequest, ListBlurbsResponse> listBlurbsCallable() {
    return listBlurbsCallable;
  }

  @Override
  public UnaryCallable<ListBlurbsRequest, ListBlurbsPagedResponse> listBlurbsPagedCallable() {
    return listBlurbsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchBlurbsRequest, Operation> searchBlurbsCallable() {
    return searchBlurbsCallable;
  }

  @Override
  public OperationCallable<SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
      searchBlurbsOperationCallable() {
    return searchBlurbsOperationCallable;
  }

  @Override
  public ServerStreamingCallable<StreamBlurbsRequest, StreamBlurbsResponse> streamBlurbsCallable() {
    return streamBlurbsCallable;
  }

  @Override
  public ClientStreamingCallable<CreateBlurbRequest, SendBlurbsResponse> sendBlurbsCallable() {
    return sendBlurbsCallable;
  }

  @Override
  public BidiStreamingCallable<ConnectRequest, StreamBlurbsResponse> connectCallable() {
    return connectCallable;
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
