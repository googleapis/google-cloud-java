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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
 * gRPC stub implementation for the StreamsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcStreamsServiceStub extends StreamsServiceStub {
  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListStreamsRequest, ListStreamsResponse>
      listStreamsMethodDescriptor =
          MethodDescriptor.<ListStreamsRequest, ListStreamsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/ListStreams")
              .setRequestMarshaller(ProtoUtils.marshaller(ListStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListStreamsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetStreamRequest, Stream> getStreamMethodDescriptor =
      MethodDescriptor.<GetStreamRequest, Stream>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetStream")
          .setRequestMarshaller(ProtoUtils.marshaller(GetStreamRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Stream.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateStreamRequest, Operation>
      createStreamMethodDescriptor =
          MethodDescriptor.<CreateStreamRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/CreateStream")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateStreamRequest, Operation>
      updateStreamMethodDescriptor =
          MethodDescriptor.<UpdateStreamRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/UpdateStream")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteStreamRequest, Operation>
      deleteStreamMethodDescriptor =
          MethodDescriptor.<DeleteStreamRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/DeleteStream")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetStreamThumbnailRequest, Operation>
      getStreamThumbnailMethodDescriptor =
          MethodDescriptor.<GetStreamThumbnailRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetStreamThumbnail")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStreamThumbnailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenMethodDescriptor =
          MethodDescriptor
              .<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/GenerateStreamHlsToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateStreamHlsTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateStreamHlsTokenResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEventsRequest, ListEventsResponse>
      listEventsMethodDescriptor =
          MethodDescriptor.<ListEventsRequest, ListEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/ListEvents")
              .setRequestMarshaller(ProtoUtils.marshaller(ListEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEventRequest, Event> getEventMethodDescriptor =
      MethodDescriptor.<GetEventRequest, Event>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetEvent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEventRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Event.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateEventRequest, Operation> createEventMethodDescriptor =
      MethodDescriptor.<CreateEventRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/CreateEvent")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateEventRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateEventRequest, Operation> updateEventMethodDescriptor =
      MethodDescriptor.<UpdateEventRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/UpdateEvent")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateEventRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteEventRequest, Operation> deleteEventMethodDescriptor =
      MethodDescriptor.<DeleteEventRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/DeleteEvent")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteEventRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSeriesRequest, ListSeriesResponse>
      listSeriesMethodDescriptor =
          MethodDescriptor.<ListSeriesRequest, ListSeriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/ListSeries")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSeriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSeriesRequest, Series> getSeriesMethodDescriptor =
      MethodDescriptor.<GetSeriesRequest, Series>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamsService/GetSeries")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSeriesRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Series.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSeriesRequest, Operation>
      createSeriesMethodDescriptor =
          MethodDescriptor.<CreateSeriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/CreateSeries")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSeriesRequest, Operation>
      updateSeriesMethodDescriptor =
          MethodDescriptor.<UpdateSeriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/UpdateSeries")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSeriesRequest, Operation>
      deleteSeriesMethodDescriptor =
          MethodDescriptor.<DeleteSeriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/DeleteSeries")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MaterializeChannelRequest, Operation>
      materializeChannelMethodDescriptor =
          MethodDescriptor.<MaterializeChannelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamsService/MaterializeChannel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MaterializeChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcStreamsServiceStub create(StreamsServiceStubSettings settings)
      throws IOException {
    return new GrpcStreamsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcStreamsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcStreamsServiceStub(
        StreamsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcStreamsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcStreamsServiceStub(
        StreamsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcStreamsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcStreamsServiceStub(StreamsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcStreamsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcStreamsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcStreamsServiceStub(
      StreamsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        GrpcCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        GrpcCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster.name", String.valueOf(request.getCluster().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListStreamsRequest, ListStreamsResponse> listStreamsTransportSettings =
        GrpcCallSettings.<ListStreamsRequest, ListStreamsResponse>newBuilder()
            .setMethodDescriptor(listStreamsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetStreamRequest, Stream> getStreamTransportSettings =
        GrpcCallSettings.<GetStreamRequest, Stream>newBuilder()
            .setMethodDescriptor(getStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateStreamRequest, Operation> createStreamTransportSettings =
        GrpcCallSettings.<CreateStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(createStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateStreamRequest, Operation> updateStreamTransportSettings =
        GrpcCallSettings.<UpdateStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(updateStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("stream.name", String.valueOf(request.getStream().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteStreamRequest, Operation> deleteStreamTransportSettings =
        GrpcCallSettings.<DeleteStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetStreamThumbnailRequest, Operation> getStreamThumbnailTransportSettings =
        GrpcCallSettings.<GetStreamThumbnailRequest, Operation>newBuilder()
            .setMethodDescriptor(getStreamThumbnailMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("stream", String.valueOf(request.getStream()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
        generateStreamHlsTokenTransportSettings =
            GrpcCallSettings
                .<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>newBuilder()
                .setMethodDescriptor(generateStreamHlsTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("stream", String.valueOf(request.getStream()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEventsRequest, ListEventsResponse> listEventsTransportSettings =
        GrpcCallSettings.<ListEventsRequest, ListEventsResponse>newBuilder()
            .setMethodDescriptor(listEventsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEventRequest, Event> getEventTransportSettings =
        GrpcCallSettings.<GetEventRequest, Event>newBuilder()
            .setMethodDescriptor(getEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEventRequest, Operation> createEventTransportSettings =
        GrpcCallSettings.<CreateEventRequest, Operation>newBuilder()
            .setMethodDescriptor(createEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEventRequest, Operation> updateEventTransportSettings =
        GrpcCallSettings.<UpdateEventRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("event.name", String.valueOf(request.getEvent().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEventRequest, Operation> deleteEventTransportSettings =
        GrpcCallSettings.<DeleteEventRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSeriesRequest, ListSeriesResponse> listSeriesTransportSettings =
        GrpcCallSettings.<ListSeriesRequest, ListSeriesResponse>newBuilder()
            .setMethodDescriptor(listSeriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSeriesRequest, Series> getSeriesTransportSettings =
        GrpcCallSettings.<GetSeriesRequest, Series>newBuilder()
            .setMethodDescriptor(getSeriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSeriesRequest, Operation> createSeriesTransportSettings =
        GrpcCallSettings.<CreateSeriesRequest, Operation>newBuilder()
            .setMethodDescriptor(createSeriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSeriesRequest, Operation> updateSeriesTransportSettings =
        GrpcCallSettings.<UpdateSeriesRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSeriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("series.name", String.valueOf(request.getSeries().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSeriesRequest, Operation> deleteSeriesTransportSettings =
        GrpcCallSettings.<DeleteSeriesRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSeriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MaterializeChannelRequest, Operation> materializeChannelTransportSettings =
        GrpcCallSettings.<MaterializeChannelRequest, Operation>newBuilder()
            .setMethodDescriptor(materializeChannelMethodDescriptor)
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
            operationsStub);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateClusterTransportSettings,
            settings.updateClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.deleteClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteClusterTransportSettings,
            settings.deleteClusterOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.updateEventCallable =
        callableFactory.createUnaryCallable(
            updateEventTransportSettings, settings.updateEventSettings(), clientContext);
    this.updateEventOperationCallable =
        callableFactory.createOperationCallable(
            updateEventTransportSettings,
            settings.updateEventOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEventCallable =
        callableFactory.createUnaryCallable(
            deleteEventTransportSettings, settings.deleteEventSettings(), clientContext);
    this.deleteEventOperationCallable =
        callableFactory.createOperationCallable(
            deleteEventTransportSettings,
            settings.deleteEventOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.updateSeriesCallable =
        callableFactory.createUnaryCallable(
            updateSeriesTransportSettings, settings.updateSeriesSettings(), clientContext);
    this.updateSeriesOperationCallable =
        callableFactory.createOperationCallable(
            updateSeriesTransportSettings,
            settings.updateSeriesOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSeriesCallable =
        callableFactory.createUnaryCallable(
            deleteSeriesTransportSettings, settings.deleteSeriesSettings(), clientContext);
    this.deleteSeriesOperationCallable =
        callableFactory.createOperationCallable(
            deleteSeriesTransportSettings,
            settings.deleteSeriesOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
