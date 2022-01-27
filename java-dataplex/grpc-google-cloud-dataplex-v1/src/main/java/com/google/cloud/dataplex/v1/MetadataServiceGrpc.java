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

  private static final int METHODID_GET_ENTITY = 0;
  private static final int METHODID_LIST_ENTITIES = 1;
  private static final int METHODID_GET_PARTITION = 2;
  private static final int METHODID_LIST_PARTITIONS = 3;

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
                      .addMethod(getGetEntityMethod())
                      .addMethod(getListEntitiesMethod())
                      .addMethod(getGetPartitionMethod())
                      .addMethod(getListPartitionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
