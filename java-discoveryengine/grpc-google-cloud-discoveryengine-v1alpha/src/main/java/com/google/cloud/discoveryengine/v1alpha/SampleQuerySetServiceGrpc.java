/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s,
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/sample_query_set_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SampleQuerySetServiceGrpc {

  private SampleQuerySetServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1alpha.SampleQuerySetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest,
          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
      getGetSampleQuerySetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSampleQuerySet",
      requestType = com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.SampleQuerySet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest,
          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
      getGetSampleQuerySetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest,
            com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
        getGetSampleQuerySetMethod;
    if ((getGetSampleQuerySetMethod = SampleQuerySetServiceGrpc.getGetSampleQuerySetMethod)
        == null) {
      synchronized (SampleQuerySetServiceGrpc.class) {
        if ((getGetSampleQuerySetMethod = SampleQuerySetServiceGrpc.getGetSampleQuerySetMethod)
            == null) {
          SampleQuerySetServiceGrpc.getGetSampleQuerySetMethod =
              getGetSampleQuerySetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest,
                          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSampleQuerySet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.SampleQuerySet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQuerySetServiceMethodDescriptorSupplier("GetSampleQuerySet"))
                      .build();
        }
      }
    }
    return getGetSampleQuerySetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest,
          com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>
      getListSampleQuerySetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSampleQuerySets",
      requestType = com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest,
          com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>
      getListSampleQuerySetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest,
            com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>
        getListSampleQuerySetsMethod;
    if ((getListSampleQuerySetsMethod = SampleQuerySetServiceGrpc.getListSampleQuerySetsMethod)
        == null) {
      synchronized (SampleQuerySetServiceGrpc.class) {
        if ((getListSampleQuerySetsMethod = SampleQuerySetServiceGrpc.getListSampleQuerySetsMethod)
            == null) {
          SampleQuerySetServiceGrpc.getListSampleQuerySetsMethod =
              getListSampleQuerySetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest,
                          com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSampleQuerySets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQuerySetServiceMethodDescriptorSupplier("ListSampleQuerySets"))
                      .build();
        }
      }
    }
    return getListSampleQuerySetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest,
          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
      getCreateSampleQuerySetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSampleQuerySet",
      requestType = com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.SampleQuerySet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest,
          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
      getCreateSampleQuerySetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest,
            com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
        getCreateSampleQuerySetMethod;
    if ((getCreateSampleQuerySetMethod = SampleQuerySetServiceGrpc.getCreateSampleQuerySetMethod)
        == null) {
      synchronized (SampleQuerySetServiceGrpc.class) {
        if ((getCreateSampleQuerySetMethod =
                SampleQuerySetServiceGrpc.getCreateSampleQuerySetMethod)
            == null) {
          SampleQuerySetServiceGrpc.getCreateSampleQuerySetMethod =
              getCreateSampleQuerySetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest,
                          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSampleQuerySet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.SampleQuerySet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQuerySetServiceMethodDescriptorSupplier("CreateSampleQuerySet"))
                      .build();
        }
      }
    }
    return getCreateSampleQuerySetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest,
          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
      getUpdateSampleQuerySetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSampleQuerySet",
      requestType = com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.SampleQuerySet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest,
          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
      getUpdateSampleQuerySetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest,
            com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
        getUpdateSampleQuerySetMethod;
    if ((getUpdateSampleQuerySetMethod = SampleQuerySetServiceGrpc.getUpdateSampleQuerySetMethod)
        == null) {
      synchronized (SampleQuerySetServiceGrpc.class) {
        if ((getUpdateSampleQuerySetMethod =
                SampleQuerySetServiceGrpc.getUpdateSampleQuerySetMethod)
            == null) {
          SampleQuerySetServiceGrpc.getUpdateSampleQuerySetMethod =
              getUpdateSampleQuerySetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest,
                          com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSampleQuerySet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.SampleQuerySet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQuerySetServiceMethodDescriptorSupplier("UpdateSampleQuerySet"))
                      .build();
        }
      }
    }
    return getUpdateSampleQuerySetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest,
          com.google.protobuf.Empty>
      getDeleteSampleQuerySetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSampleQuerySet",
      requestType = com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest,
          com.google.protobuf.Empty>
      getDeleteSampleQuerySetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest,
            com.google.protobuf.Empty>
        getDeleteSampleQuerySetMethod;
    if ((getDeleteSampleQuerySetMethod = SampleQuerySetServiceGrpc.getDeleteSampleQuerySetMethod)
        == null) {
      synchronized (SampleQuerySetServiceGrpc.class) {
        if ((getDeleteSampleQuerySetMethod =
                SampleQuerySetServiceGrpc.getDeleteSampleQuerySetMethod)
            == null) {
          SampleQuerySetServiceGrpc.getDeleteSampleQuerySetMethod =
              getDeleteSampleQuerySetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSampleQuerySet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQuerySetServiceMethodDescriptorSupplier("DeleteSampleQuerySet"))
                      .build();
        }
      }
    }
    return getDeleteSampleQuerySetMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SampleQuerySetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleQuerySetServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SampleQuerySetServiceStub>() {
          @java.lang.Override
          public SampleQuerySetServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SampleQuerySetServiceStub(channel, callOptions);
          }
        };
    return SampleQuerySetServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SampleQuerySetServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleQuerySetServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SampleQuerySetServiceBlockingV2Stub>() {
          @java.lang.Override
          public SampleQuerySetServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SampleQuerySetServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SampleQuerySetServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SampleQuerySetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleQuerySetServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SampleQuerySetServiceBlockingStub>() {
          @java.lang.Override
          public SampleQuerySetServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SampleQuerySetServiceBlockingStub(channel, callOptions);
          }
        };
    return SampleQuerySetServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SampleQuerySetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleQuerySetServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SampleQuerySetServiceFutureStub>() {
          @java.lang.Override
          public SampleQuerySetServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SampleQuerySetServiceFutureStub(channel, callOptions);
          }
        };
    return SampleQuerySetServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s,
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    default void getSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSampleQuerySetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s.
     * </pre>
     */
    default void listSampleQuerySets(
        com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSampleQuerySetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]
     * </pre>
     */
    default void createSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSampleQuerySetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    default void updateSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSampleQuerySetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    default void deleteSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSampleQuerySetMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SampleQuerySetService.
   *
   * <pre>
   * Service for managing
   * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s,
   * </pre>
   */
  public abstract static class SampleQuerySetServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SampleQuerySetServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SampleQuerySetService.
   *
   * <pre>
   * Service for managing
   * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s,
   * </pre>
   */
  public static final class SampleQuerySetServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SampleQuerySetServiceStub> {
    private SampleQuerySetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleQuerySetServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleQuerySetServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public void getSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSampleQuerySetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s.
     * </pre>
     */
    public void listSampleQuerySets(
        com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSampleQuerySetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]
     * </pre>
     */
    public void createSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSampleQuerySetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public void updateSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSampleQuerySetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public void deleteSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSampleQuerySetMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SampleQuerySetService.
   *
   * <pre>
   * Service for managing
   * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s,
   * </pre>
   */
  public static final class SampleQuerySetServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SampleQuerySetServiceBlockingV2Stub> {
    private SampleQuerySetServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleQuerySetServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleQuerySetServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.SampleQuerySet getSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSampleQuerySetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse listSampleQuerySets(
        com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSampleQuerySetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.SampleQuerySet createSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSampleQuerySetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.SampleQuerySet updateSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSampleQuerySetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.protobuf.Empty deleteSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSampleQuerySetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SampleQuerySetService.
   *
   * <pre>
   * Service for managing
   * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s,
   * </pre>
   */
  public static final class SampleQuerySetServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SampleQuerySetServiceBlockingStub> {
    private SampleQuerySetServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleQuerySetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleQuerySetServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.SampleQuerySet getSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSampleQuerySetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse listSampleQuerySets(
        com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSampleQuerySetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.SampleQuerySet createSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSampleQuerySetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.SampleQuerySet updateSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSampleQuerySetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.protobuf.Empty deleteSampleQuerySet(
        com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSampleQuerySetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SampleQuerySetService.
   *
   * <pre>
   * Service for managing
   * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s,
   * </pre>
   */
  public static final class SampleQuerySetServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SampleQuerySetServiceFutureStub> {
    private SampleQuerySetServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleQuerySetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleQuerySetServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
        getSampleQuerySet(
            com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSampleQuerySetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>
        listSampleQuerySets(
            com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSampleQuerySetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
        createSampleQuerySet(
            com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSampleQuerySetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>
        updateSampleQuerySet(
            com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSampleQuerySetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SampleQuerySet][google.cloud.discoveryengine.v1alpha.SampleQuerySet].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSampleQuerySet(
            com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSampleQuerySetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SAMPLE_QUERY_SET = 0;
  private static final int METHODID_LIST_SAMPLE_QUERY_SETS = 1;
  private static final int METHODID_CREATE_SAMPLE_QUERY_SET = 2;
  private static final int METHODID_UPDATE_SAMPLE_QUERY_SET = 3;
  private static final int METHODID_DELETE_SAMPLE_QUERY_SET = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SAMPLE_QUERY_SET:
          serviceImpl.getSampleQuerySet(
              (com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>)
                  responseObserver);
          break;
        case METHODID_LIST_SAMPLE_QUERY_SETS:
          serviceImpl.listSampleQuerySets(
              (com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SAMPLE_QUERY_SET:
          serviceImpl.createSampleQuerySet(
              (com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SAMPLE_QUERY_SET:
          serviceImpl.updateSampleQuerySet(
              (com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>)
                  responseObserver);
          break;
        case METHODID_DELETE_SAMPLE_QUERY_SET:
          serviceImpl.deleteSampleQuerySet(
              (com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getGetSampleQuerySetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest,
                    com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>(
                    service, METHODID_GET_SAMPLE_QUERY_SET)))
        .addMethod(
            getListSampleQuerySetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest,
                    com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse>(
                    service, METHODID_LIST_SAMPLE_QUERY_SETS)))
        .addMethod(
            getCreateSampleQuerySetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest,
                    com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>(
                    service, METHODID_CREATE_SAMPLE_QUERY_SET)))
        .addMethod(
            getUpdateSampleQuerySetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest,
                    com.google.cloud.discoveryengine.v1alpha.SampleQuerySet>(
                    service, METHODID_UPDATE_SAMPLE_QUERY_SET)))
        .addMethod(
            getDeleteSampleQuerySetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SAMPLE_QUERY_SET)))
        .build();
  }

  private abstract static class SampleQuerySetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SampleQuerySetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.SampleQuerySetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SampleQuerySetService");
    }
  }

  private static final class SampleQuerySetServiceFileDescriptorSupplier
      extends SampleQuerySetServiceBaseDescriptorSupplier {
    SampleQuerySetServiceFileDescriptorSupplier() {}
  }

  private static final class SampleQuerySetServiceMethodDescriptorSupplier
      extends SampleQuerySetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SampleQuerySetServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SampleQuerySetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SampleQuerySetServiceFileDescriptorSupplier())
                      .addMethod(getGetSampleQuerySetMethod())
                      .addMethod(getListSampleQuerySetsMethod())
                      .addMethod(getCreateSampleQuerySetMethod())
                      .addMethod(getUpdateSampleQuerySetMethod())
                      .addMethod(getDeleteSampleQuerySetMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
