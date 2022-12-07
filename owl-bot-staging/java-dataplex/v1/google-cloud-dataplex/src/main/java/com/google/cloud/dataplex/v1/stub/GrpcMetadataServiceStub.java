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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListEntitiesPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListPartitionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateEntityRequest;
import com.google.cloud.dataplex.v1.CreatePartitionRequest;
import com.google.cloud.dataplex.v1.DeleteEntityRequest;
import com.google.cloud.dataplex.v1.DeletePartitionRequest;
import com.google.cloud.dataplex.v1.Entity;
import com.google.cloud.dataplex.v1.GetEntityRequest;
import com.google.cloud.dataplex.v1.GetPartitionRequest;
import com.google.cloud.dataplex.v1.ListEntitiesRequest;
import com.google.cloud.dataplex.v1.ListEntitiesResponse;
import com.google.cloud.dataplex.v1.ListPartitionsRequest;
import com.google.cloud.dataplex.v1.ListPartitionsResponse;
import com.google.cloud.dataplex.v1.Partition;
import com.google.cloud.dataplex.v1.UpdateEntityRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MetadataService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMetadataServiceStub extends MetadataServiceStub {
  private static final MethodDescriptor<CreateEntityRequest, Entity> createEntityMethodDescriptor =
      MethodDescriptor.<CreateEntityRequest, Entity>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.MetadataService/CreateEntity")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateEntityRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entity.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateEntityRequest, Entity> updateEntityMethodDescriptor =
      MethodDescriptor.<UpdateEntityRequest, Entity>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.MetadataService/UpdateEntity")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateEntityRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entity.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteEntityRequest, Empty> deleteEntityMethodDescriptor =
      MethodDescriptor.<DeleteEntityRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.MetadataService/DeleteEntity")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteEntityRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetEntityRequest, Entity> getEntityMethodDescriptor =
      MethodDescriptor.<GetEntityRequest, Entity>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.MetadataService/GetEntity")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEntityRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entity.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListEntitiesRequest, ListEntitiesResponse>
      listEntitiesMethodDescriptor =
          MethodDescriptor.<ListEntitiesRequest, ListEntitiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/ListEntities")
              .setRequestMarshaller(ProtoUtils.marshaller(ListEntitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntitiesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePartitionRequest, Partition>
      createPartitionMethodDescriptor =
          MethodDescriptor.<CreatePartitionRequest, Partition>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/CreatePartition")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePartitionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Partition.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePartitionRequest, Empty>
      deletePartitionMethodDescriptor =
          MethodDescriptor.<DeletePartitionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/DeletePartition")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePartitionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPartitionRequest, Partition>
      getPartitionMethodDescriptor =
          MethodDescriptor.<GetPartitionRequest, Partition>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/GetPartition")
              .setRequestMarshaller(ProtoUtils.marshaller(GetPartitionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Partition.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsMethodDescriptor =
          MethodDescriptor.<ListPartitionsRequest, ListPartitionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/ListPartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPartitionsResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateEntityRequest, Entity> createEntityCallable;
  private final UnaryCallable<UpdateEntityRequest, Entity> updateEntityCallable;
  private final UnaryCallable<DeleteEntityRequest, Empty> deleteEntityCallable;
  private final UnaryCallable<GetEntityRequest, Entity> getEntityCallable;
  private final UnaryCallable<ListEntitiesRequest, ListEntitiesResponse> listEntitiesCallable;
  private final UnaryCallable<ListEntitiesRequest, ListEntitiesPagedResponse>
      listEntitiesPagedCallable;
  private final UnaryCallable<CreatePartitionRequest, Partition> createPartitionCallable;
  private final UnaryCallable<DeletePartitionRequest, Empty> deletePartitionCallable;
  private final UnaryCallable<GetPartitionRequest, Partition> getPartitionCallable;
  private final UnaryCallable<ListPartitionsRequest, ListPartitionsResponse> listPartitionsCallable;
  private final UnaryCallable<ListPartitionsRequest, ListPartitionsPagedResponse>
      listPartitionsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMetadataServiceStub create(MetadataServiceStubSettings settings)
      throws IOException {
    return new GrpcMetadataServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetadataServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMetadataServiceStub(
        MetadataServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMetadataServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMetadataServiceStub(
        MetadataServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMetadataServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetadataServiceStub(
      MetadataServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMetadataServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMetadataServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetadataServiceStub(
      MetadataServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateEntityRequest, Entity> createEntityTransportSettings =
        GrpcCallSettings.<CreateEntityRequest, Entity>newBuilder()
            .setMethodDescriptor(createEntityMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateEntityRequest, Entity> updateEntityTransportSettings =
        GrpcCallSettings.<UpdateEntityRequest, Entity>newBuilder()
            .setMethodDescriptor(updateEntityMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("entity.name", String.valueOf(request.getEntity().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEntityRequest, Empty> deleteEntityTransportSettings =
        GrpcCallSettings.<DeleteEntityRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntityMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetEntityRequest, Entity> getEntityTransportSettings =
        GrpcCallSettings.<GetEntityRequest, Entity>newBuilder()
            .setMethodDescriptor(getEntityMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListEntitiesRequest, ListEntitiesResponse> listEntitiesTransportSettings =
        GrpcCallSettings.<ListEntitiesRequest, ListEntitiesResponse>newBuilder()
            .setMethodDescriptor(listEntitiesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreatePartitionRequest, Partition> createPartitionTransportSettings =
        GrpcCallSettings.<CreatePartitionRequest, Partition>newBuilder()
            .setMethodDescriptor(createPartitionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeletePartitionRequest, Empty> deletePartitionTransportSettings =
        GrpcCallSettings.<DeletePartitionRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePartitionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetPartitionRequest, Partition> getPartitionTransportSettings =
        GrpcCallSettings.<GetPartitionRequest, Partition>newBuilder()
            .setMethodDescriptor(getPartitionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListPartitionsRequest, ListPartitionsResponse>
        listPartitionsTransportSettings =
            GrpcCallSettings.<ListPartitionsRequest, ListPartitionsResponse>newBuilder()
                .setMethodDescriptor(listPartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
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

    this.createEntityCallable =
        callableFactory.createUnaryCallable(
            createEntityTransportSettings, settings.createEntitySettings(), clientContext);
    this.updateEntityCallable =
        callableFactory.createUnaryCallable(
            updateEntityTransportSettings, settings.updateEntitySettings(), clientContext);
    this.deleteEntityCallable =
        callableFactory.createUnaryCallable(
            deleteEntityTransportSettings, settings.deleteEntitySettings(), clientContext);
    this.getEntityCallable =
        callableFactory.createUnaryCallable(
            getEntityTransportSettings, settings.getEntitySettings(), clientContext);
    this.listEntitiesCallable =
        callableFactory.createUnaryCallable(
            listEntitiesTransportSettings, settings.listEntitiesSettings(), clientContext);
    this.listEntitiesPagedCallable =
        callableFactory.createPagedCallable(
            listEntitiesTransportSettings, settings.listEntitiesSettings(), clientContext);
    this.createPartitionCallable =
        callableFactory.createUnaryCallable(
            createPartitionTransportSettings, settings.createPartitionSettings(), clientContext);
    this.deletePartitionCallable =
        callableFactory.createUnaryCallable(
            deletePartitionTransportSettings, settings.deletePartitionSettings(), clientContext);
    this.getPartitionCallable =
        callableFactory.createUnaryCallable(
            getPartitionTransportSettings, settings.getPartitionSettings(), clientContext);
    this.listPartitionsCallable =
        callableFactory.createUnaryCallable(
            listPartitionsTransportSettings, settings.listPartitionsSettings(), clientContext);
    this.listPartitionsPagedCallable =
        callableFactory.createPagedCallable(
            listPartitionsTransportSettings, settings.listPartitionsSettings(), clientContext);
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
  public UnaryCallable<CreateEntityRequest, Entity> createEntityCallable() {
    return createEntityCallable;
  }

  @Override
  public UnaryCallable<UpdateEntityRequest, Entity> updateEntityCallable() {
    return updateEntityCallable;
  }

  @Override
  public UnaryCallable<DeleteEntityRequest, Empty> deleteEntityCallable() {
    return deleteEntityCallable;
  }

  @Override
  public UnaryCallable<GetEntityRequest, Entity> getEntityCallable() {
    return getEntityCallable;
  }

  @Override
  public UnaryCallable<ListEntitiesRequest, ListEntitiesResponse> listEntitiesCallable() {
    return listEntitiesCallable;
  }

  @Override
  public UnaryCallable<ListEntitiesRequest, ListEntitiesPagedResponse> listEntitiesPagedCallable() {
    return listEntitiesPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePartitionRequest, Partition> createPartitionCallable() {
    return createPartitionCallable;
  }

  @Override
  public UnaryCallable<DeletePartitionRequest, Empty> deletePartitionCallable() {
    return deletePartitionCallable;
  }

  @Override
  public UnaryCallable<GetPartitionRequest, Partition> getPartitionCallable() {
    return getPartitionCallable;
  }

  @Override
  public UnaryCallable<ListPartitionsRequest, ListPartitionsResponse> listPartitionsCallable() {
    return listPartitionsCallable;
  }

  @Override
  public UnaryCallable<ListPartitionsRequest, ListPartitionsPagedResponse>
      listPartitionsPagedCallable() {
    return listPartitionsPagedCallable;
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
