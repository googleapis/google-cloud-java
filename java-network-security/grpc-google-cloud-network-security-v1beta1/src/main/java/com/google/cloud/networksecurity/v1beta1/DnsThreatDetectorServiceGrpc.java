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
package com.google.cloud.networksecurity.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Network Security API for DNS Threat Detectors.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DnsThreatDetectorServiceGrpc {

  private DnsThreatDetectorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networksecurity.v1beta1.DnsThreatDetectorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest,
          com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>
      getListDnsThreatDetectorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDnsThreatDetectors",
      requestType = com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest.class,
      responseType = com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest,
          com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>
      getListDnsThreatDetectorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest,
            com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>
        getListDnsThreatDetectorsMethod;
    if ((getListDnsThreatDetectorsMethod =
            DnsThreatDetectorServiceGrpc.getListDnsThreatDetectorsMethod)
        == null) {
      synchronized (DnsThreatDetectorServiceGrpc.class) {
        if ((getListDnsThreatDetectorsMethod =
                DnsThreatDetectorServiceGrpc.getListDnsThreatDetectorsMethod)
            == null) {
          DnsThreatDetectorServiceGrpc.getListDnsThreatDetectorsMethod =
              getListDnsThreatDetectorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest,
                          com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDnsThreatDetectors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1
                                  .ListDnsThreatDetectorsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DnsThreatDetectorServiceMethodDescriptorSupplier(
                              "ListDnsThreatDetectors"))
                      .build();
        }
      }
    }
    return getListDnsThreatDetectorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest,
          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
      getGetDnsThreatDetectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDnsThreatDetector",
      requestType = com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest.class,
      responseType = com.google.cloud.networksecurity.v1beta1.DnsThreatDetector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest,
          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
      getGetDnsThreatDetectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest,
            com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
        getGetDnsThreatDetectorMethod;
    if ((getGetDnsThreatDetectorMethod = DnsThreatDetectorServiceGrpc.getGetDnsThreatDetectorMethod)
        == null) {
      synchronized (DnsThreatDetectorServiceGrpc.class) {
        if ((getGetDnsThreatDetectorMethod =
                DnsThreatDetectorServiceGrpc.getGetDnsThreatDetectorMethod)
            == null) {
          DnsThreatDetectorServiceGrpc.getGetDnsThreatDetectorMethod =
              getGetDnsThreatDetectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest,
                          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDnsThreatDetector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1.DnsThreatDetector
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DnsThreatDetectorServiceMethodDescriptorSupplier(
                              "GetDnsThreatDetector"))
                      .build();
        }
      }
    }
    return getGetDnsThreatDetectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest,
          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
      getCreateDnsThreatDetectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDnsThreatDetector",
      requestType = com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest.class,
      responseType = com.google.cloud.networksecurity.v1beta1.DnsThreatDetector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest,
          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
      getCreateDnsThreatDetectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest,
            com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
        getCreateDnsThreatDetectorMethod;
    if ((getCreateDnsThreatDetectorMethod =
            DnsThreatDetectorServiceGrpc.getCreateDnsThreatDetectorMethod)
        == null) {
      synchronized (DnsThreatDetectorServiceGrpc.class) {
        if ((getCreateDnsThreatDetectorMethod =
                DnsThreatDetectorServiceGrpc.getCreateDnsThreatDetectorMethod)
            == null) {
          DnsThreatDetectorServiceGrpc.getCreateDnsThreatDetectorMethod =
              getCreateDnsThreatDetectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest,
                          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDnsThreatDetector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1
                                  .CreateDnsThreatDetectorRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1.DnsThreatDetector
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DnsThreatDetectorServiceMethodDescriptorSupplier(
                              "CreateDnsThreatDetector"))
                      .build();
        }
      }
    }
    return getCreateDnsThreatDetectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest,
          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
      getUpdateDnsThreatDetectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDnsThreatDetector",
      requestType = com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest.class,
      responseType = com.google.cloud.networksecurity.v1beta1.DnsThreatDetector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest,
          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
      getUpdateDnsThreatDetectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest,
            com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
        getUpdateDnsThreatDetectorMethod;
    if ((getUpdateDnsThreatDetectorMethod =
            DnsThreatDetectorServiceGrpc.getUpdateDnsThreatDetectorMethod)
        == null) {
      synchronized (DnsThreatDetectorServiceGrpc.class) {
        if ((getUpdateDnsThreatDetectorMethod =
                DnsThreatDetectorServiceGrpc.getUpdateDnsThreatDetectorMethod)
            == null) {
          DnsThreatDetectorServiceGrpc.getUpdateDnsThreatDetectorMethod =
              getUpdateDnsThreatDetectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest,
                          com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDnsThreatDetector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1
                                  .UpdateDnsThreatDetectorRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1.DnsThreatDetector
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DnsThreatDetectorServiceMethodDescriptorSupplier(
                              "UpdateDnsThreatDetector"))
                      .build();
        }
      }
    }
    return getUpdateDnsThreatDetectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest,
          com.google.protobuf.Empty>
      getDeleteDnsThreatDetectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDnsThreatDetector",
      requestType = com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest,
          com.google.protobuf.Empty>
      getDeleteDnsThreatDetectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest,
            com.google.protobuf.Empty>
        getDeleteDnsThreatDetectorMethod;
    if ((getDeleteDnsThreatDetectorMethod =
            DnsThreatDetectorServiceGrpc.getDeleteDnsThreatDetectorMethod)
        == null) {
      synchronized (DnsThreatDetectorServiceGrpc.class) {
        if ((getDeleteDnsThreatDetectorMethod =
                DnsThreatDetectorServiceGrpc.getDeleteDnsThreatDetectorMethod)
            == null) {
          DnsThreatDetectorServiceGrpc.getDeleteDnsThreatDetectorMethod =
              getDeleteDnsThreatDetectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDnsThreatDetector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1beta1
                                  .DeleteDnsThreatDetectorRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DnsThreatDetectorServiceMethodDescriptorSupplier(
                              "DeleteDnsThreatDetector"))
                      .build();
        }
      }
    }
    return getDeleteDnsThreatDetectorMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DnsThreatDetectorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DnsThreatDetectorServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DnsThreatDetectorServiceStub>() {
          @java.lang.Override
          public DnsThreatDetectorServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DnsThreatDetectorServiceStub(channel, callOptions);
          }
        };
    return DnsThreatDetectorServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DnsThreatDetectorServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DnsThreatDetectorServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DnsThreatDetectorServiceBlockingV2Stub>() {
          @java.lang.Override
          public DnsThreatDetectorServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DnsThreatDetectorServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DnsThreatDetectorServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DnsThreatDetectorServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DnsThreatDetectorServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DnsThreatDetectorServiceBlockingStub>() {
          @java.lang.Override
          public DnsThreatDetectorServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DnsThreatDetectorServiceBlockingStub(channel, callOptions);
          }
        };
    return DnsThreatDetectorServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DnsThreatDetectorServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DnsThreatDetectorServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DnsThreatDetectorServiceFutureStub>() {
          @java.lang.Override
          public DnsThreatDetectorServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DnsThreatDetectorServiceFutureStub(channel, callOptions);
          }
        };
    return DnsThreatDetectorServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Network Security API for DNS Threat Detectors.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists DnsThreatDetectors in a given project and location.
     * </pre>
     */
    default void listDnsThreatDetectors(
        com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDnsThreatDetectorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DnsThreatDetector.
     * </pre>
     */
    default void getDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDnsThreatDetectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsThreatDetector in a given project and location.
     * </pre>
     */
    default void createDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDnsThreatDetectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single DnsThreatDetector.
     * </pre>
     */
    default void updateDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDnsThreatDetectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsThreatDetector.
     * </pre>
     */
    default void deleteDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDnsThreatDetectorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DnsThreatDetectorService.
   *
   * <pre>
   * The Network Security API for DNS Threat Detectors.
   * </pre>
   */
  public abstract static class DnsThreatDetectorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DnsThreatDetectorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DnsThreatDetectorService.
   *
   * <pre>
   * The Network Security API for DNS Threat Detectors.
   * </pre>
   */
  public static final class DnsThreatDetectorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DnsThreatDetectorServiceStub> {
    private DnsThreatDetectorServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DnsThreatDetectorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DnsThreatDetectorServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists DnsThreatDetectors in a given project and location.
     * </pre>
     */
    public void listDnsThreatDetectors(
        com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDnsThreatDetectorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DnsThreatDetector.
     * </pre>
     */
    public void getDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDnsThreatDetectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsThreatDetector in a given project and location.
     * </pre>
     */
    public void createDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDnsThreatDetectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single DnsThreatDetector.
     * </pre>
     */
    public void updateDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDnsThreatDetectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsThreatDetector.
     * </pre>
     */
    public void deleteDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDnsThreatDetectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DnsThreatDetectorService.
   *
   * <pre>
   * The Network Security API for DNS Threat Detectors.
   * </pre>
   */
  public static final class DnsThreatDetectorServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DnsThreatDetectorServiceBlockingV2Stub> {
    private DnsThreatDetectorServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DnsThreatDetectorServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DnsThreatDetectorServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists DnsThreatDetectors in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse
        listDnsThreatDetectors(
            com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDnsThreatDetectorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DnsThreatDetector.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1beta1.DnsThreatDetector getDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDnsThreatDetectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsThreatDetector in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1beta1.DnsThreatDetector createDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDnsThreatDetectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single DnsThreatDetector.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1beta1.DnsThreatDetector updateDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDnsThreatDetectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsThreatDetector.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDnsThreatDetectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * DnsThreatDetectorService.
   *
   * <pre>
   * The Network Security API for DNS Threat Detectors.
   * </pre>
   */
  public static final class DnsThreatDetectorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DnsThreatDetectorServiceBlockingStub> {
    private DnsThreatDetectorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DnsThreatDetectorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DnsThreatDetectorServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists DnsThreatDetectors in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse
        listDnsThreatDetectors(
            com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDnsThreatDetectorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DnsThreatDetector.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1beta1.DnsThreatDetector getDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDnsThreatDetectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsThreatDetector in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1beta1.DnsThreatDetector createDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDnsThreatDetectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single DnsThreatDetector.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1beta1.DnsThreatDetector updateDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDnsThreatDetectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsThreatDetector.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDnsThreatDetector(
        com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDnsThreatDetectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * DnsThreatDetectorService.
   *
   * <pre>
   * The Network Security API for DNS Threat Detectors.
   * </pre>
   */
  public static final class DnsThreatDetectorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DnsThreatDetectorServiceFutureStub> {
    private DnsThreatDetectorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DnsThreatDetectorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DnsThreatDetectorServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists DnsThreatDetectors in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>
        listDnsThreatDetectors(
            com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDnsThreatDetectorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single DnsThreatDetector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
        getDnsThreatDetector(
            com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDnsThreatDetectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsThreatDetector in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
        createDnsThreatDetector(
            com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDnsThreatDetectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single DnsThreatDetector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>
        updateDnsThreatDetector(
            com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDnsThreatDetectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsThreatDetector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDnsThreatDetector(
            com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDnsThreatDetectorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DNS_THREAT_DETECTORS = 0;
  private static final int METHODID_GET_DNS_THREAT_DETECTOR = 1;
  private static final int METHODID_CREATE_DNS_THREAT_DETECTOR = 2;
  private static final int METHODID_UPDATE_DNS_THREAT_DETECTOR = 3;
  private static final int METHODID_DELETE_DNS_THREAT_DETECTOR = 4;

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
        case METHODID_LIST_DNS_THREAT_DETECTORS:
          serviceImpl.listDnsThreatDetectors(
              (com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DNS_THREAT_DETECTOR:
          serviceImpl.getDnsThreatDetector(
              (com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>)
                  responseObserver);
          break;
        case METHODID_CREATE_DNS_THREAT_DETECTOR:
          serviceImpl.createDnsThreatDetector(
              (com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DNS_THREAT_DETECTOR:
          serviceImpl.updateDnsThreatDetector(
              (com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>)
                  responseObserver);
          break;
        case METHODID_DELETE_DNS_THREAT_DETECTOR:
          serviceImpl.deleteDnsThreatDetector(
              (com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest) request,
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
            getListDnsThreatDetectorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsRequest,
                    com.google.cloud.networksecurity.v1beta1.ListDnsThreatDetectorsResponse>(
                    service, METHODID_LIST_DNS_THREAT_DETECTORS)))
        .addMethod(
            getGetDnsThreatDetectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1beta1.GetDnsThreatDetectorRequest,
                    com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>(
                    service, METHODID_GET_DNS_THREAT_DETECTOR)))
        .addMethod(
            getCreateDnsThreatDetectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1beta1.CreateDnsThreatDetectorRequest,
                    com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>(
                    service, METHODID_CREATE_DNS_THREAT_DETECTOR)))
        .addMethod(
            getUpdateDnsThreatDetectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1beta1.UpdateDnsThreatDetectorRequest,
                    com.google.cloud.networksecurity.v1beta1.DnsThreatDetector>(
                    service, METHODID_UPDATE_DNS_THREAT_DETECTOR)))
        .addMethod(
            getDeleteDnsThreatDetectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1beta1.DeleteDnsThreatDetectorRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DNS_THREAT_DETECTOR)))
        .build();
  }

  private abstract static class DnsThreatDetectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DnsThreatDetectorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1beta1.DnsThreatDetectorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DnsThreatDetectorService");
    }
  }

  private static final class DnsThreatDetectorServiceFileDescriptorSupplier
      extends DnsThreatDetectorServiceBaseDescriptorSupplier {
    DnsThreatDetectorServiceFileDescriptorSupplier() {}
  }

  private static final class DnsThreatDetectorServiceMethodDescriptorSupplier
      extends DnsThreatDetectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DnsThreatDetectorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DnsThreatDetectorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DnsThreatDetectorServiceFileDescriptorSupplier())
                      .addMethod(getListDnsThreatDetectorsMethod())
                      .addMethod(getGetDnsThreatDetectorMethod())
                      .addMethod(getCreateDnsThreatDetectorMethod())
                      .addMethod(getUpdateDnsThreatDetectorMethod())
                      .addMethod(getDeleteDnsThreatDetectorMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
