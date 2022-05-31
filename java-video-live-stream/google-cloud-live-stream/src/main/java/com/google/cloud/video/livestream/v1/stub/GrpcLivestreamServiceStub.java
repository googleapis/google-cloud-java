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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
 * gRPC stub implementation for the LivestreamService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLivestreamServiceStub extends LivestreamServiceStub {
  private static final MethodDescriptor<CreateChannelRequest, Operation>
      createChannelMethodDescriptor =
          MethodDescriptor.<CreateChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/CreateChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListChannelsRequest, ListChannelsResponse>
      listChannelsMethodDescriptor =
          MethodDescriptor.<ListChannelsRequest, ListChannelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/ListChannels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListChannelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChannelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetChannelRequest, Channel> getChannelMethodDescriptor =
      MethodDescriptor.<GetChannelRequest, Channel>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/GetChannel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetChannelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Channel.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteChannelRequest, Operation>
      deleteChannelMethodDescriptor =
          MethodDescriptor.<DeleteChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/DeleteChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateChannelRequest, Operation>
      updateChannelMethodDescriptor =
          MethodDescriptor.<UpdateChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/UpdateChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartChannelRequest, Operation>
      startChannelMethodDescriptor =
          MethodDescriptor.<StartChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/StartChannel")
              .setRequestMarshaller(ProtoUtils.marshaller(StartChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopChannelRequest, Operation> stopChannelMethodDescriptor =
      MethodDescriptor.<StopChannelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/StopChannel")
          .setRequestMarshaller(ProtoUtils.marshaller(StopChannelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateInputRequest, Operation> createInputMethodDescriptor =
      MethodDescriptor.<CreateInputRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/CreateInput")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateInputRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListInputsRequest, ListInputsResponse>
      listInputsMethodDescriptor =
          MethodDescriptor.<ListInputsRequest, ListInputsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/ListInputs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListInputsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListInputsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInputRequest, Input> getInputMethodDescriptor =
      MethodDescriptor.<GetInputRequest, Input>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/GetInput")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInputRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Input.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteInputRequest, Operation> deleteInputMethodDescriptor =
      MethodDescriptor.<DeleteInputRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/DeleteInput")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteInputRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateInputRequest, Operation> updateInputMethodDescriptor =
      MethodDescriptor.<UpdateInputRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/UpdateInput")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateInputRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateEventRequest, Event> createEventMethodDescriptor =
      MethodDescriptor.<CreateEventRequest, Event>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/CreateEvent")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateEventRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Event.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListEventsRequest, ListEventsResponse>
      listEventsMethodDescriptor =
          MethodDescriptor.<ListEventsRequest, ListEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/ListEvents")
              .setRequestMarshaller(ProtoUtils.marshaller(ListEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEventRequest, Event> getEventMethodDescriptor =
      MethodDescriptor.<GetEventRequest, Event>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/GetEvent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEventRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Event.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteEventRequest, Empty> deleteEventMethodDescriptor =
      MethodDescriptor.<DeleteEventRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.livestream.v1.LivestreamService/DeleteEvent")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteEventRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLivestreamServiceStub create(LivestreamServiceStubSettings settings)
      throws IOException {
    return new GrpcLivestreamServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLivestreamServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLivestreamServiceStub(
        LivestreamServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLivestreamServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLivestreamServiceStub(
        LivestreamServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLivestreamServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLivestreamServiceStub(
      LivestreamServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcLivestreamServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLivestreamServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLivestreamServiceStub(
      LivestreamServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

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
    GrpcCallSettings<StartChannelRequest, Operation> startChannelTransportSettings =
        GrpcCallSettings.<StartChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(startChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StopChannelRequest, Operation> stopChannelTransportSettings =
        GrpcCallSettings.<StopChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(stopChannelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateInputRequest, Operation> createInputTransportSettings =
        GrpcCallSettings.<CreateInputRequest, Operation>newBuilder()
            .setMethodDescriptor(createInputMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListInputsRequest, ListInputsResponse> listInputsTransportSettings =
        GrpcCallSettings.<ListInputsRequest, ListInputsResponse>newBuilder()
            .setMethodDescriptor(listInputsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetInputRequest, Input> getInputTransportSettings =
        GrpcCallSettings.<GetInputRequest, Input>newBuilder()
            .setMethodDescriptor(getInputMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteInputRequest, Operation> deleteInputTransportSettings =
        GrpcCallSettings.<DeleteInputRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInputMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateInputRequest, Operation> updateInputTransportSettings =
        GrpcCallSettings.<UpdateInputRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInputMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("input.name", String.valueOf(request.getInput().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateEventRequest, Event> createEventTransportSettings =
        GrpcCallSettings.<CreateEventRequest, Event>newBuilder()
            .setMethodDescriptor(createEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListEventsRequest, ListEventsResponse> listEventsTransportSettings =
        GrpcCallSettings.<ListEventsRequest, ListEventsResponse>newBuilder()
            .setMethodDescriptor(listEventsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetEventRequest, Event> getEventTransportSettings =
        GrpcCallSettings.<GetEventRequest, Event>newBuilder()
            .setMethodDescriptor(getEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEventRequest, Empty> deleteEventTransportSettings =
        GrpcCallSettings.<DeleteEventRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createChannelCallable =
        callableFactory.createUnaryCallable(
            createChannelTransportSettings, settings.createChannelSettings(), clientContext);
    this.createChannelOperationCallable =
        callableFactory.createOperationCallable(
            createChannelTransportSettings,
            settings.createChannelOperationSettings(),
            clientContext,
            operationsStub);
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
    this.startChannelCallable =
        callableFactory.createUnaryCallable(
            startChannelTransportSettings, settings.startChannelSettings(), clientContext);
    this.startChannelOperationCallable =
        callableFactory.createOperationCallable(
            startChannelTransportSettings,
            settings.startChannelOperationSettings(),
            clientContext,
            operationsStub);
    this.stopChannelCallable =
        callableFactory.createUnaryCallable(
            stopChannelTransportSettings, settings.stopChannelSettings(), clientContext);
    this.stopChannelOperationCallable =
        callableFactory.createOperationCallable(
            stopChannelTransportSettings,
            settings.stopChannelOperationSettings(),
            clientContext,
            operationsStub);
    this.createInputCallable =
        callableFactory.createUnaryCallable(
            createInputTransportSettings, settings.createInputSettings(), clientContext);
    this.createInputOperationCallable =
        callableFactory.createOperationCallable(
            createInputTransportSettings,
            settings.createInputOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateInputCallable =
        callableFactory.createUnaryCallable(
            updateInputTransportSettings, settings.updateInputSettings(), clientContext);
    this.updateInputOperationCallable =
        callableFactory.createOperationCallable(
            updateInputTransportSettings,
            settings.updateInputOperationSettings(),
            clientContext,
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
