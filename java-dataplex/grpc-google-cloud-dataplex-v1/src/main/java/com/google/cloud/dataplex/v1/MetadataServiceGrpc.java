/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Metadata service manages metadata resources such as tables, filesets and
 * partitions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/metadata.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MetadataServiceGrpc {

  private MetadataServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataplex.v1.MetadataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateEntityRequest, com.google.cloud.dataplex.v1.Entity>
      getCreateEntityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntity",
      requestType = com.google.cloud.dataplex.v1.CreateEntityRequest.class,
      responseType = com.google.cloud.dataplex.v1.Entity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateEntityRequest, com.google.cloud.dataplex.v1.Entity>
      getCreateEntityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateEntityRequest, com.google.cloud.dataplex.v1.Entity>
        getCreateEntityMethod;
    if ((getCreateEntityMethod = MetadataServiceGrpc.getCreateEntityMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getCreateEntityMethod = MetadataServiceGrpc.getCreateEntityMethod) == null) {
          MetadataServiceGrpc.getCreateEntityMethod =
              getCreateEntityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateEntityRequest,
                          com.google.cloud.dataplex.v1.Entity>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateEntityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Entity.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("CreateEntity"))
                      .build();
        }
      }
    }
    return getCreateEntityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateEntityRequest, com.google.cloud.dataplex.v1.Entity>
      getUpdateEntityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntity",
      requestType = com.google.cloud.dataplex.v1.UpdateEntityRequest.class,
      responseType = com.google.cloud.dataplex.v1.Entity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateEntityRequest, com.google.cloud.dataplex.v1.Entity>
      getUpdateEntityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateEntityRequest, com.google.cloud.dataplex.v1.Entity>
        getUpdateEntityMethod;
    if ((getUpdateEntityMethod = MetadataServiceGrpc.getUpdateEntityMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getUpdateEntityMethod = MetadataServiceGrpc.getUpdateEntityMethod) == null) {
          MetadataServiceGrpc.getUpdateEntityMethod =
              getUpdateEntityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateEntityRequest,
                          com.google.cloud.dataplex.v1.Entity>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateEntityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Entity.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("UpdateEntity"))
                      .build();
        }
      }
    }
    return getUpdateEntityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteEntityRequest, com.google.protobuf.Empty>
      getDeleteEntityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntity",
      requestType = com.google.cloud.dataplex.v1.DeleteEntityRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteEntityRequest, com.google.protobuf.Empty>
      getDeleteEntityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteEntityRequest, com.google.protobuf.Empty>
        getDeleteEntityMethod;
    if ((getDeleteEntityMethod = MetadataServiceGrpc.getDeleteEntityMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getDeleteEntityMethod = MetadataServiceGrpc.getDeleteEntityMethod) == null) {
          MetadataServiceGrpc.getDeleteEntityMethod =
              getDeleteEntityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteEntityRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteEntityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("DeleteEntity"))
                      .build();
        }
      }
    }
    return getDeleteEntityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetEntityRequest, com.google.cloud.dataplex.v1.Entity>
      getGetEntityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntity",
      requestType = com.google.cloud.dataplex.v1.GetEntityRequest.class,
      responseType = com.google.cloud.dataplex.v1.Entity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetEntityRequest, com.google.cloud.dataplex.v1.Entity>
      getGetEntityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetEntityRequest, com.google.cloud.dataplex.v1.Entity>
        getGetEntityMethod;
    if ((getGetEntityMethod = MetadataServiceGrpc.getGetEntityMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getGetEntityMethod = MetadataServiceGrpc.getGetEntityMethod) == null) {
          MetadataServiceGrpc.getGetEntityMethod =
              getGetEntityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetEntityRequest,
                          com.google.cloud.dataplex.v1.Entity>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetEntityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Entity.getDefaultInstance()))
                      .setSchemaDescriptor(new MetadataServiceMethodDescriptorSupplier("GetEntity"))
                      .build();
        }
      }
    }
    return getGetEntityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListEntitiesRequest,
          com.google.cloud.dataplex.v1.ListEntitiesResponse>
      getListEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntities",
      requestType = com.google.cloud.dataplex.v1.ListEntitiesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListEntitiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListEntitiesRequest,
          com.google.cloud.dataplex.v1.ListEntitiesResponse>
      getListEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListEntitiesRequest,
            com.google.cloud.dataplex.v1.ListEntitiesResponse>
        getListEntitiesMethod;
    if ((getListEntitiesMethod = MetadataServiceGrpc.getListEntitiesMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getListEntitiesMethod = MetadataServiceGrpc.getListEntitiesMethod) == null) {
          MetadataServiceGrpc.getListEntitiesMethod =
              getListEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListEntitiesRequest,
                          com.google.cloud.dataplex.v1.ListEntitiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListEntitiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("ListEntities"))
                      .build();
        }
      }
    }
    return getListEntitiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreatePartitionRequest,
          com.google.cloud.dataplex.v1.Partition>
      getCreatePartitionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePartition",
      requestType = com.google.cloud.dataplex.v1.CreatePartitionRequest.class,
      responseType = com.google.cloud.dataplex.v1.Partition.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreatePartitionRequest,
          com.google.cloud.dataplex.v1.Partition>
      getCreatePartitionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreatePartitionRequest,
            com.google.cloud.dataplex.v1.Partition>
        getCreatePartitionMethod;
    if ((getCreatePartitionMethod = MetadataServiceGrpc.getCreatePartitionMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getCreatePartitionMethod = MetadataServiceGrpc.getCreatePartitionMethod) == null) {
          MetadataServiceGrpc.getCreatePartitionMethod =
              getCreatePartitionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreatePartitionRequest,
                          com.google.cloud.dataplex.v1.Partition>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePartition"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreatePartitionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Partition.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("CreatePartition"))
                      .build();
        }
      }
    }
    return getCreatePartitionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeletePartitionRequest, com.google.protobuf.Empty>
      getDeletePartitionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePartition",
      requestType = com.google.cloud.dataplex.v1.DeletePartitionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeletePartitionRequest, com.google.protobuf.Empty>
      getDeletePartitionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeletePartitionRequest, com.google.protobuf.Empty>
        getDeletePartitionMethod;
    if ((getDeletePartitionMethod = MetadataServiceGrpc.getDeletePartitionMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getDeletePartitionMethod = MetadataServiceGrpc.getDeletePartitionMethod) == null) {
          MetadataServiceGrpc.getDeletePartitionMethod =
              getDeletePartitionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeletePartitionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePartition"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeletePartitionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("DeletePartition"))
                      .build();
        }
      }
    }
    return getDeletePartitionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetPartitionRequest, com.google.cloud.dataplex.v1.Partition>
      getGetPartitionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPartition",
      requestType = com.google.cloud.dataplex.v1.GetPartitionRequest.class,
      responseType = com.google.cloud.dataplex.v1.Partition.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetPartitionRequest, com.google.cloud.dataplex.v1.Partition>
      getGetPartitionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetPartitionRequest,
            com.google.cloud.dataplex.v1.Partition>
        getGetPartitionMethod;
    if ((getGetPartitionMethod = MetadataServiceGrpc.getGetPartitionMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getGetPartitionMethod = MetadataServiceGrpc.getGetPartitionMethod) == null) {
          MetadataServiceGrpc.getGetPartitionMethod =
              getGetPartitionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetPartitionRequest,
                          com.google.cloud.dataplex.v1.Partition>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPartition"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetPartitionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Partition.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("GetPartition"))
                      .build();
        }
      }
    }
    return getGetPartitionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListPartitionsRequest,
          com.google.cloud.dataplex.v1.ListPartitionsResponse>
      getListPartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPartitions",
      requestType = com.google.cloud.dataplex.v1.ListPartitionsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListPartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListPartitionsRequest,
          com.google.cloud.dataplex.v1.ListPartitionsResponse>
      getListPartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListPartitionsRequest,
            com.google.cloud.dataplex.v1.ListPartitionsResponse>
        getListPartitionsMethod;
    if ((getListPartitionsMethod = MetadataServiceGrpc.getListPartitionsMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getListPartitionsMethod = MetadataServiceGrpc.getListPartitionsMethod) == null) {
          MetadataServiceGrpc.getListPartitionsMethod =
              getListPartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListPartitionsRequest,
                          com.google.cloud.dataplex.v1.ListPartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListPartitionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListPartitionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("ListPartitions"))
                      .build();
        }
      }
    }
    return getListPartitionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MetadataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetadataServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetadataServiceStub>() {
          @java.lang.Override
          public MetadataServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetadataServiceStub(channel, callOptions);
          }
        };
    return MetadataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetadataServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetadataServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetadataServiceBlockingStub>() {
          @java.lang.Override
          public MetadataServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetadataServiceBlockingStub(channel, callOptions);
          }
        };
    return MetadataServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MetadataServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetadataServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetadataServiceFutureStub>() {
          @java.lang.Override
          public MetadataServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetadataServiceFutureStub(channel, callOptions);
          }
        };
    return MetadataServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Metadata service manages metadata resources such as tables, filesets and
   * partitions.
   * </pre>
   */
  public abstract static class MetadataServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create a metadata entity.
     * </pre>
     */
    public void createEntity(
        com.google.cloud.dataplex.v1.CreateEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEntityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a metadata entity. Only supports full resource update.
     * </pre>
     */
    public void updateEntity(
        com.google.cloud.dataplex.v1.UpdateEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEntityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a metadata entity.
     * </pre>
     */
    public void deleteEntity(
        com.google.cloud.dataplex.v1.DeleteEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEntityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a metadata entity.
     * </pre>
     */
    public void getEntity(
        com.google.cloud.dataplex.v1.GetEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEntityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List metadata entities in a zone.
     * </pre>
     */
    public void listEntities(
        com.google.cloud.dataplex.v1.ListEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a metadata partition.
     * </pre>
     */
    public void createPartition(
        com.google.cloud.dataplex.v1.CreatePartitionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Partition> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePartitionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a metadata partition.
     * </pre>
     */
    public void deletePartition(
        com.google.cloud.dataplex.v1.DeletePartitionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePartitionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a metadata partition of an entity.
     * </pre>
     */
    public void getPartition(
        com.google.cloud.dataplex.v1.GetPartitionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Partition> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPartitionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List metadata partitions of an entity.
     * </pre>
     */
    public void listPartitions(
        com.google.cloud.dataplex.v1.ListPartitionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListPartitionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPartitionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateEntityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.CreateEntityRequest,
                      com.google.cloud.dataplex.v1.Entity>(this, METHODID_CREATE_ENTITY)))
          .addMethod(
              getUpdateEntityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.UpdateEntityRequest,
                      com.google.cloud.dataplex.v1.Entity>(this, METHODID_UPDATE_ENTITY)))
          .addMethod(
              getDeleteEntityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.DeleteEntityRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_ENTITY)))
          .addMethod(
              getGetEntityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.GetEntityRequest,
                      com.google.cloud.dataplex.v1.Entity>(this, METHODID_GET_ENTITY)))
          .addMethod(
              getListEntitiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.ListEntitiesRequest,
                      com.google.cloud.dataplex.v1.ListEntitiesResponse>(
                      this, METHODID_LIST_ENTITIES)))
          .addMethod(
              getCreatePartitionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.CreatePartitionRequest,
                      com.google.cloud.dataplex.v1.Partition>(this, METHODID_CREATE_PARTITION)))
          .addMethod(
              getDeletePartitionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.DeletePartitionRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_PARTITION)))
          .addMethod(
              getGetPartitionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.GetPartitionRequest,
                      com.google.cloud.dataplex.v1.Partition>(this, METHODID_GET_PARTITION)))
          .addMethod(
              getListPartitionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataplex.v1.ListPartitionsRequest,
                      com.google.cloud.dataplex.v1.ListPartitionsResponse>(
                      this, METHODID_LIST_PARTITIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Metadata service manages metadata resources such as tables, filesets and
   * partitions.
   * </pre>
   */
  public static final class MetadataServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MetadataServiceStub> {
    private MetadataServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetadataServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetadataServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a metadata entity.
     * </pre>
     */
    public void createEntity(
        com.google.cloud.dataplex.v1.CreateEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a metadata entity. Only supports full resource update.
     * </pre>
     */
    public void updateEntity(
        com.google.cloud.dataplex.v1.UpdateEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a metadata entity.
     * </pre>
     */
    public void deleteEntity(
        com.google.cloud.dataplex.v1.DeleteEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a metadata entity.
     * </pre>
     */
    public void getEntity(
        com.google.cloud.dataplex.v1.GetEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List metadata entities in a zone.
     * </pre>
     */
    public void listEntities(
        com.google.cloud.dataplex.v1.ListEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a metadata partition.
     * </pre>
     */
    public void createPartition(
        com.google.cloud.dataplex.v1.CreatePartitionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Partition> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePartitionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a metadata partition.
     * </pre>
     */
    public void deletePartition(
        com.google.cloud.dataplex.v1.DeletePartitionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePartitionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a metadata partition of an entity.
     * </pre>
     */
    public void getPartition(
        com.google.cloud.dataplex.v1.GetPartitionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Partition> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPartitionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List metadata partitions of an entity.
     * </pre>
     */
    public void listPartitions(
        com.google.cloud.dataplex.v1.ListPartitionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListPartitionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Metadata service manages metadata resources such as tables, filesets and
   * partitions.
   * </pre>
   */
  public static final class MetadataServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MetadataServiceBlockingStub> {
    private MetadataServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetadataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetadataServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a metadata entity.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Entity createEntity(
        com.google.cloud.dataplex.v1.CreateEntityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a metadata entity. Only supports full resource update.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Entity updateEntity(
        com.google.cloud.dataplex.v1.UpdateEntityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a metadata entity.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntity(
        com.google.cloud.dataplex.v1.DeleteEntityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a metadata entity.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Entity getEntity(
        com.google.cloud.dataplex.v1.GetEntityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List metadata entities in a zone.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListEntitiesResponse listEntities(
        com.google.cloud.dataplex.v1.ListEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a metadata partition.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Partition createPartition(
        com.google.cloud.dataplex.v1.CreatePartitionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePartitionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a metadata partition.
     * </pre>
     */
    public com.google.protobuf.Empty deletePartition(
        com.google.cloud.dataplex.v1.DeletePartitionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePartitionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a metadata partition of an entity.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Partition getPartition(
        com.google.cloud.dataplex.v1.GetPartitionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPartitionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List metadata partitions of an entity.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListPartitionsResponse listPartitions(
        com.google.cloud.dataplex.v1.ListPartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPartitionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Metadata service manages metadata resources such as tables, filesets and
   * partitions.
   * </pre>
   */
  public static final class MetadataServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MetadataServiceFutureStub> {
    private MetadataServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetadataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetadataServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a metadata entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Entity>
        createEntity(com.google.cloud.dataplex.v1.CreateEntityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a metadata entity. Only supports full resource update.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Entity>
        updateEntity(com.google.cloud.dataplex.v1.UpdateEntityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a metadata entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEntity(com.google.cloud.dataplex.v1.DeleteEntityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a metadata entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Entity>
        getEntity(com.google.cloud.dataplex.v1.GetEntityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List metadata entities in a zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListEntitiesResponse>
        listEntities(com.google.cloud.dataplex.v1.ListEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntitiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a metadata partition.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.Partition>
        createPartition(com.google.cloud.dataplex.v1.CreatePartitionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePartitionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a metadata partition.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePartition(com.google.cloud.dataplex.v1.DeletePartitionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePartitionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a metadata partition of an entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.Partition>
        getPartition(com.google.cloud.dataplex.v1.GetPartitionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPartitionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List metadata partitions of an entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListPartitionsResponse>
        listPartitions(com.google.cloud.dataplex.v1.ListPartitionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPartitionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ENTITY = 0;
  private static final int METHODID_UPDATE_ENTITY = 1;
  private static final int METHODID_DELETE_ENTITY = 2;
  private static final int METHODID_GET_ENTITY = 3;
  private static final int METHODID_LIST_ENTITIES = 4;
  private static final int METHODID_CREATE_PARTITION = 5;
  private static final int METHODID_DELETE_PARTITION = 6;
  private static final int METHODID_GET_PARTITION = 7;
  private static final int METHODID_LIST_PARTITIONS = 8;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MetadataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MetadataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ENTITY:
          serviceImpl.createEntity(
              (com.google.cloud.dataplex.v1.CreateEntityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity>) responseObserver);
          break;
        case METHODID_UPDATE_ENTITY:
          serviceImpl.updateEntity(
              (com.google.cloud.dataplex.v1.UpdateEntityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity>) responseObserver);
          break;
        case METHODID_DELETE_ENTITY:
          serviceImpl.deleteEntity(
              (com.google.cloud.dataplex.v1.DeleteEntityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ENTITY:
          serviceImpl.getEntity(
              (com.google.cloud.dataplex.v1.GetEntityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entity>) responseObserver);
          break;
        case METHODID_LIST_ENTITIES:
          serviceImpl.listEntities(
              (com.google.cloud.dataplex.v1.ListEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntitiesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PARTITION:
          serviceImpl.createPartition(
              (com.google.cloud.dataplex.v1.CreatePartitionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Partition>)
                  responseObserver);
          break;
        case METHODID_DELETE_PARTITION:
          serviceImpl.deletePartition(
              (com.google.cloud.dataplex.v1.DeletePartitionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_PARTITION:
          serviceImpl.getPartition(
              (com.google.cloud.dataplex.v1.GetPartitionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Partition>)
                  responseObserver);
          break;
        case METHODID_LIST_PARTITIONS:
          serviceImpl.listPartitions(
              (com.google.cloud.dataplex.v1.ListPartitionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListPartitionsResponse>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class MetadataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetadataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.MetadataProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetadataService");
    }
  }

  private static final class MetadataServiceFileDescriptorSupplier
      extends MetadataServiceBaseDescriptorSupplier {
    MetadataServiceFileDescriptorSupplier() {}
  }

  private static final class MetadataServiceMethodDescriptorSupplier
      extends MetadataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MetadataServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MetadataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MetadataServiceFileDescriptorSupplier())
                      .addMethod(getCreateEntityMethod())
                      .addMethod(getUpdateEntityMethod())
                      .addMethod(getDeleteEntityMethod())
                      .addMethod(getGetEntityMethod())
                      .addMethod(getListEntitiesMethod())
                      .addMethod(getCreatePartitionMethod())
                      .addMethod(getDeletePartitionMethod())
                      .addMethod(getGetPartitionMethod())
                      .addMethod(getListPartitionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
