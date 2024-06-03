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

package com.google.cloud.managedkafka.v1.stub;

import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListConsumerGroupsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListLocationsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListTopicsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.Cluster;
import com.google.cloud.managedkafka.v1.ConsumerGroup;
import com.google.cloud.managedkafka.v1.CreateClusterRequest;
import com.google.cloud.managedkafka.v1.CreateTopicRequest;
import com.google.cloud.managedkafka.v1.DeleteClusterRequest;
import com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest;
import com.google.cloud.managedkafka.v1.DeleteTopicRequest;
import com.google.cloud.managedkafka.v1.GetClusterRequest;
import com.google.cloud.managedkafka.v1.GetConsumerGroupRequest;
import com.google.cloud.managedkafka.v1.GetTopicRequest;
import com.google.cloud.managedkafka.v1.ListClustersRequest;
import com.google.cloud.managedkafka.v1.ListClustersResponse;
import com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest;
import com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse;
import com.google.cloud.managedkafka.v1.ListTopicsRequest;
import com.google.cloud.managedkafka.v1.ListTopicsResponse;
import com.google.cloud.managedkafka.v1.OperationMetadata;
import com.google.cloud.managedkafka.v1.Topic;
import com.google.cloud.managedkafka.v1.UpdateClusterRequest;
import com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest;
import com.google.cloud.managedkafka.v1.UpdateTopicRequest;
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
 * gRPC stub implementation for the ManagedKafka service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcManagedKafkaStub extends ManagedKafkaStub {
  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTopicsRequest, ListTopicsResponse>
      listTopicsMethodDescriptor =
          MethodDescriptor.<ListTopicsRequest, ListTopicsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/ListTopics")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTopicsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTopicsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTopicRequest, Topic> getTopicMethodDescriptor =
      MethodDescriptor.<GetTopicRequest, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/GetTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTopicRequest, Topic> createTopicMethodDescriptor =
      MethodDescriptor.<CreateTopicRequest, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/CreateTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTopicRequest, Topic> updateTopicMethodDescriptor =
      MethodDescriptor.<UpdateTopicRequest, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/UpdateTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTopicRequest, Empty> deleteTopicMethodDescriptor =
      MethodDescriptor.<DeleteTopicRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/DeleteTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListConsumerGroupsRequest, ListConsumerGroupsResponse>
      listConsumerGroupsMethodDescriptor =
          MethodDescriptor.<ListConsumerGroupsRequest, ListConsumerGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/ListConsumerGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConsumerGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConsumerGroupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConsumerGroupRequest, ConsumerGroup>
      getConsumerGroupMethodDescriptor =
          MethodDescriptor.<GetConsumerGroupRequest, ConsumerGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/GetConsumerGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConsumerGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConsumerGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConsumerGroupRequest, ConsumerGroup>
      updateConsumerGroupMethodDescriptor =
          MethodDescriptor.<UpdateConsumerGroupRequest, ConsumerGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/UpdateConsumerGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConsumerGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConsumerGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConsumerGroupRequest, Empty>
      deleteConsumerGroupMethodDescriptor =
          MethodDescriptor.<DeleteConsumerGroupRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafka/DeleteConsumerGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConsumerGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
  private final UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable;
  private final UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable;
  private final UnaryCallable<GetTopicRequest, Topic> getTopicCallable;
  private final UnaryCallable<CreateTopicRequest, Topic> createTopicCallable;
  private final UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable;
  private final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable;
  private final UnaryCallable<ListConsumerGroupsRequest, ListConsumerGroupsResponse>
      listConsumerGroupsCallable;
  private final UnaryCallable<ListConsumerGroupsRequest, ListConsumerGroupsPagedResponse>
      listConsumerGroupsPagedCallable;
  private final UnaryCallable<GetConsumerGroupRequest, ConsumerGroup> getConsumerGroupCallable;
  private final UnaryCallable<UpdateConsumerGroupRequest, ConsumerGroup>
      updateConsumerGroupCallable;
  private final UnaryCallable<DeleteConsumerGroupRequest, Empty> deleteConsumerGroupCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcManagedKafkaStub create(ManagedKafkaStubSettings settings)
      throws IOException {
    return new GrpcManagedKafkaStub(settings, ClientContext.create(settings));
  }

  public static final GrpcManagedKafkaStub create(ClientContext clientContext) throws IOException {
    return new GrpcManagedKafkaStub(ManagedKafkaStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcManagedKafkaStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcManagedKafkaStub(
        ManagedKafkaStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcManagedKafkaStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcManagedKafkaStub(ManagedKafkaStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcManagedKafkaCallableFactory());
  }

  /**
   * Constructs an instance of GrpcManagedKafkaStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcManagedKafkaStub(
      ManagedKafkaStubSettings settings,
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
    GrpcCallSettings<ListTopicsRequest, ListTopicsResponse> listTopicsTransportSettings =
        GrpcCallSettings.<ListTopicsRequest, ListTopicsResponse>newBuilder()
            .setMethodDescriptor(listTopicsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTopicRequest, Topic> getTopicTransportSettings =
        GrpcCallSettings.<GetTopicRequest, Topic>newBuilder()
            .setMethodDescriptor(getTopicMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateTopicRequest, Topic> createTopicTransportSettings =
        GrpcCallSettings.<CreateTopicRequest, Topic>newBuilder()
            .setMethodDescriptor(createTopicMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTopicRequest, Topic> updateTopicTransportSettings =
        GrpcCallSettings.<UpdateTopicRequest, Topic>newBuilder()
            .setMethodDescriptor(updateTopicMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("topic.name", String.valueOf(request.getTopic().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTopicRequest, Empty> deleteTopicTransportSettings =
        GrpcCallSettings.<DeleteTopicRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTopicMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListConsumerGroupsRequest, ListConsumerGroupsResponse>
        listConsumerGroupsTransportSettings =
            GrpcCallSettings.<ListConsumerGroupsRequest, ListConsumerGroupsResponse>newBuilder()
                .setMethodDescriptor(listConsumerGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConsumerGroupRequest, ConsumerGroup> getConsumerGroupTransportSettings =
        GrpcCallSettings.<GetConsumerGroupRequest, ConsumerGroup>newBuilder()
            .setMethodDescriptor(getConsumerGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConsumerGroupRequest, ConsumerGroup>
        updateConsumerGroupTransportSettings =
            GrpcCallSettings.<UpdateConsumerGroupRequest, ConsumerGroup>newBuilder()
                .setMethodDescriptor(updateConsumerGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "consumer_group.name",
                          String.valueOf(request.getConsumerGroup().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteConsumerGroupRequest, Empty> deleteConsumerGroupTransportSettings =
        GrpcCallSettings.<DeleteConsumerGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConsumerGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
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
    this.listTopicsCallable =
        callableFactory.createUnaryCallable(
            listTopicsTransportSettings, settings.listTopicsSettings(), clientContext);
    this.listTopicsPagedCallable =
        callableFactory.createPagedCallable(
            listTopicsTransportSettings, settings.listTopicsSettings(), clientContext);
    this.getTopicCallable =
        callableFactory.createUnaryCallable(
            getTopicTransportSettings, settings.getTopicSettings(), clientContext);
    this.createTopicCallable =
        callableFactory.createUnaryCallable(
            createTopicTransportSettings, settings.createTopicSettings(), clientContext);
    this.updateTopicCallable =
        callableFactory.createUnaryCallable(
            updateTopicTransportSettings, settings.updateTopicSettings(), clientContext);
    this.deleteTopicCallable =
        callableFactory.createUnaryCallable(
            deleteTopicTransportSettings, settings.deleteTopicSettings(), clientContext);
    this.listConsumerGroupsCallable =
        callableFactory.createUnaryCallable(
            listConsumerGroupsTransportSettings,
            settings.listConsumerGroupsSettings(),
            clientContext);
    this.listConsumerGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listConsumerGroupsTransportSettings,
            settings.listConsumerGroupsSettings(),
            clientContext);
    this.getConsumerGroupCallable =
        callableFactory.createUnaryCallable(
            getConsumerGroupTransportSettings, settings.getConsumerGroupSettings(), clientContext);
    this.updateConsumerGroupCallable =
        callableFactory.createUnaryCallable(
            updateConsumerGroupTransportSettings,
            settings.updateConsumerGroupSettings(),
            clientContext);
    this.deleteConsumerGroupCallable =
        callableFactory.createUnaryCallable(
            deleteConsumerGroupTransportSettings,
            settings.deleteConsumerGroupSettings(),
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
  public UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return listTopicsCallable;
  }

  @Override
  public UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    return listTopicsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    return getTopicCallable;
  }

  @Override
  public UnaryCallable<CreateTopicRequest, Topic> createTopicCallable() {
    return createTopicCallable;
  }

  @Override
  public UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable() {
    return updateTopicCallable;
  }

  @Override
  public UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return deleteTopicCallable;
  }

  @Override
  public UnaryCallable<ListConsumerGroupsRequest, ListConsumerGroupsResponse>
      listConsumerGroupsCallable() {
    return listConsumerGroupsCallable;
  }

  @Override
  public UnaryCallable<ListConsumerGroupsRequest, ListConsumerGroupsPagedResponse>
      listConsumerGroupsPagedCallable() {
    return listConsumerGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConsumerGroupRequest, ConsumerGroup> getConsumerGroupCallable() {
    return getConsumerGroupCallable;
  }

  @Override
  public UnaryCallable<UpdateConsumerGroupRequest, ConsumerGroup> updateConsumerGroupCallable() {
    return updateConsumerGroupCallable;
  }

  @Override
  public UnaryCallable<DeleteConsumerGroupRequest, Empty> deleteConsumerGroupCallable() {
    return deleteConsumerGroupCallable;
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
