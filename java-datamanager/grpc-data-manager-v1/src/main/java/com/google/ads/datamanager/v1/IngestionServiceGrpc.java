/*
 * Copyright 2026 Google LLC
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
package com.google.ads.datamanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for sending audience data to supported destinations.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class IngestionServiceGrpc {

  private IngestionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.ads.datamanager.v1.IngestionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.IngestAudienceMembersRequest,
          com.google.ads.datamanager.v1.IngestAudienceMembersResponse>
      getIngestAudienceMembersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IngestAudienceMembers",
      requestType = com.google.ads.datamanager.v1.IngestAudienceMembersRequest.class,
      responseType = com.google.ads.datamanager.v1.IngestAudienceMembersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.IngestAudienceMembersRequest,
          com.google.ads.datamanager.v1.IngestAudienceMembersResponse>
      getIngestAudienceMembersMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.IngestAudienceMembersRequest,
            com.google.ads.datamanager.v1.IngestAudienceMembersResponse>
        getIngestAudienceMembersMethod;
    if ((getIngestAudienceMembersMethod = IngestionServiceGrpc.getIngestAudienceMembersMethod)
        == null) {
      synchronized (IngestionServiceGrpc.class) {
        if ((getIngestAudienceMembersMethod = IngestionServiceGrpc.getIngestAudienceMembersMethod)
            == null) {
          IngestionServiceGrpc.getIngestAudienceMembersMethod =
              getIngestAudienceMembersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.IngestAudienceMembersRequest,
                          com.google.ads.datamanager.v1.IngestAudienceMembersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "IngestAudienceMembers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.IngestAudienceMembersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.IngestAudienceMembersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IngestionServiceMethodDescriptorSupplier("IngestAudienceMembers"))
                      .build();
        }
      }
    }
    return getIngestAudienceMembersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.RemoveAudienceMembersRequest,
          com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>
      getRemoveAudienceMembersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveAudienceMembers",
      requestType = com.google.ads.datamanager.v1.RemoveAudienceMembersRequest.class,
      responseType = com.google.ads.datamanager.v1.RemoveAudienceMembersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.RemoveAudienceMembersRequest,
          com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>
      getRemoveAudienceMembersMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.RemoveAudienceMembersRequest,
            com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>
        getRemoveAudienceMembersMethod;
    if ((getRemoveAudienceMembersMethod = IngestionServiceGrpc.getRemoveAudienceMembersMethod)
        == null) {
      synchronized (IngestionServiceGrpc.class) {
        if ((getRemoveAudienceMembersMethod = IngestionServiceGrpc.getRemoveAudienceMembersMethod)
            == null) {
          IngestionServiceGrpc.getRemoveAudienceMembersMethod =
              getRemoveAudienceMembersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.RemoveAudienceMembersRequest,
                          com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveAudienceMembers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.RemoveAudienceMembersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.RemoveAudienceMembersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IngestionServiceMethodDescriptorSupplier("RemoveAudienceMembers"))
                      .build();
        }
      }
    }
    return getRemoveAudienceMembersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.IngestEventsRequest,
          com.google.ads.datamanager.v1.IngestEventsResponse>
      getIngestEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IngestEvents",
      requestType = com.google.ads.datamanager.v1.IngestEventsRequest.class,
      responseType = com.google.ads.datamanager.v1.IngestEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.IngestEventsRequest,
          com.google.ads.datamanager.v1.IngestEventsResponse>
      getIngestEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.IngestEventsRequest,
            com.google.ads.datamanager.v1.IngestEventsResponse>
        getIngestEventsMethod;
    if ((getIngestEventsMethod = IngestionServiceGrpc.getIngestEventsMethod) == null) {
      synchronized (IngestionServiceGrpc.class) {
        if ((getIngestEventsMethod = IngestionServiceGrpc.getIngestEventsMethod) == null) {
          IngestionServiceGrpc.getIngestEventsMethod =
              getIngestEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.IngestEventsRequest,
                          com.google.ads.datamanager.v1.IngestEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IngestEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.IngestEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.IngestEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IngestionServiceMethodDescriptorSupplier("IngestEvents"))
                      .build();
        }
      }
    }
    return getIngestEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.RetrieveRequestStatusRequest,
          com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>
      getRetrieveRequestStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveRequestStatus",
      requestType = com.google.ads.datamanager.v1.RetrieveRequestStatusRequest.class,
      responseType = com.google.ads.datamanager.v1.RetrieveRequestStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.RetrieveRequestStatusRequest,
          com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>
      getRetrieveRequestStatusMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.RetrieveRequestStatusRequest,
            com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>
        getRetrieveRequestStatusMethod;
    if ((getRetrieveRequestStatusMethod = IngestionServiceGrpc.getRetrieveRequestStatusMethod)
        == null) {
      synchronized (IngestionServiceGrpc.class) {
        if ((getRetrieveRequestStatusMethod = IngestionServiceGrpc.getRetrieveRequestStatusMethod)
            == null) {
          IngestionServiceGrpc.getRetrieveRequestStatusMethod =
              getRetrieveRequestStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.RetrieveRequestStatusRequest,
                          com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RetrieveRequestStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.RetrieveRequestStatusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.RetrieveRequestStatusResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IngestionServiceMethodDescriptorSupplier("RetrieveRequestStatus"))
                      .build();
        }
      }
    }
    return getRetrieveRequestStatusMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IngestionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IngestionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IngestionServiceStub>() {
          @java.lang.Override
          public IngestionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IngestionServiceStub(channel, callOptions);
          }
        };
    return IngestionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static IngestionServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IngestionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IngestionServiceBlockingV2Stub>() {
          @java.lang.Override
          public IngestionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IngestionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return IngestionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IngestionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IngestionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IngestionServiceBlockingStub>() {
          @java.lang.Override
          public IngestionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IngestionServiceBlockingStub(channel, callOptions);
          }
        };
    return IngestionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IngestionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IngestionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IngestionServiceFutureStub>() {
          @java.lang.Override
          public IngestionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IngestionServiceFutureStub(channel, callOptions);
          }
        };
    return IngestionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for sending audience data to supported destinations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources to the
     * provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    default void ingestAudienceMembers(
        com.google.ads.datamanager.v1.IngestAudienceMembersRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.IngestAudienceMembersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getIngestAudienceMembersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    default void removeAudienceMembers(
        com.google.ads.datamanager.v1.RemoveAudienceMembersRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveAudienceMembersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [Event][google.ads.datamanager.v1.Event] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    default void ingestEvents(
        com.google.ads.datamanager.v1.IngestEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.IngestEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getIngestEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the status of a request given request id.
     * </pre>
     */
    default void retrieveRequestStatus(
        com.google.ads.datamanager.v1.RetrieveRequestStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveRequestStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IngestionService.
   *
   * <pre>
   * Service for sending audience data to supported destinations.
   * </pre>
   */
  public abstract static class IngestionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IngestionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IngestionService.
   *
   * <pre>
   * Service for sending audience data to supported destinations.
   * </pre>
   */
  public static final class IngestionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IngestionServiceStub> {
    private IngestionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IngestionServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IngestionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources to the
     * provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public void ingestAudienceMembers(
        com.google.ads.datamanager.v1.IngestAudienceMembersRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.IngestAudienceMembersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIngestAudienceMembersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public void removeAudienceMembers(
        com.google.ads.datamanager.v1.RemoveAudienceMembersRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveAudienceMembersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [Event][google.ads.datamanager.v1.Event] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public void ingestEvents(
        com.google.ads.datamanager.v1.IngestEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.IngestEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIngestEventsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the status of a request given request id.
     * </pre>
     */
    public void retrieveRequestStatus(
        com.google.ads.datamanager.v1.RetrieveRequestStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveRequestStatusMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IngestionService.
   *
   * <pre>
   * Service for sending audience data to supported destinations.
   * </pre>
   */
  public static final class IngestionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<IngestionServiceBlockingV2Stub> {
    private IngestionServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IngestionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IngestionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources to the
     * provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.ads.datamanager.v1.IngestAudienceMembersResponse ingestAudienceMembers(
        com.google.ads.datamanager.v1.IngestAudienceMembersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getIngestAudienceMembersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.ads.datamanager.v1.RemoveAudienceMembersResponse removeAudienceMembers(
        com.google.ads.datamanager.v1.RemoveAudienceMembersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRemoveAudienceMembersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [Event][google.ads.datamanager.v1.Event] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.ads.datamanager.v1.IngestEventsResponse ingestEvents(
        com.google.ads.datamanager.v1.IngestEventsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getIngestEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the status of a request given request id.
     * </pre>
     */
    public com.google.ads.datamanager.v1.RetrieveRequestStatusResponse retrieveRequestStatus(
        com.google.ads.datamanager.v1.RetrieveRequestStatusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRetrieveRequestStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service IngestionService.
   *
   * <pre>
   * Service for sending audience data to supported destinations.
   * </pre>
   */
  public static final class IngestionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IngestionServiceBlockingStub> {
    private IngestionServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IngestionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IngestionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources to the
     * provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.ads.datamanager.v1.IngestAudienceMembersResponse ingestAudienceMembers(
        com.google.ads.datamanager.v1.IngestAudienceMembersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIngestAudienceMembersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.ads.datamanager.v1.RemoveAudienceMembersResponse removeAudienceMembers(
        com.google.ads.datamanager.v1.RemoveAudienceMembersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveAudienceMembersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [Event][google.ads.datamanager.v1.Event] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.ads.datamanager.v1.IngestEventsResponse ingestEvents(
        com.google.ads.datamanager.v1.IngestEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIngestEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the status of a request given request id.
     * </pre>
     */
    public com.google.ads.datamanager.v1.RetrieveRequestStatusResponse retrieveRequestStatus(
        com.google.ads.datamanager.v1.RetrieveRequestStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveRequestStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IngestionService.
   *
   * <pre>
   * Service for sending audience data to supported destinations.
   * </pre>
   */
  public static final class IngestionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IngestionServiceFutureStub> {
    private IngestionServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IngestionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IngestionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources to the
     * provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.IngestAudienceMembersResponse>
        ingestAudienceMembers(com.google.ads.datamanager.v1.IngestAudienceMembersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIngestAudienceMembersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a list of
     * [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>
        removeAudienceMembers(com.google.ads.datamanager.v1.RemoveAudienceMembersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveAudienceMembersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads a list of
     * [Event][google.ads.datamanager.v1.Event] resources from
     * the provided [Destination][google.ads.datamanager.v1.Destination].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.IngestEventsResponse>
        ingestEvents(com.google.ads.datamanager.v1.IngestEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIngestEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the status of a request given request id.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>
        retrieveRequestStatus(com.google.ads.datamanager.v1.RetrieveRequestStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveRequestStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INGEST_AUDIENCE_MEMBERS = 0;
  private static final int METHODID_REMOVE_AUDIENCE_MEMBERS = 1;
  private static final int METHODID_INGEST_EVENTS = 2;
  private static final int METHODID_RETRIEVE_REQUEST_STATUS = 3;

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
        case METHODID_INGEST_AUDIENCE_MEMBERS:
          serviceImpl.ingestAudienceMembers(
              (com.google.ads.datamanager.v1.IngestAudienceMembersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.datamanager.v1.IngestAudienceMembersResponse>)
                  responseObserver);
          break;
        case METHODID_REMOVE_AUDIENCE_MEMBERS:
          serviceImpl.removeAudienceMembers(
              (com.google.ads.datamanager.v1.RemoveAudienceMembersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>)
                  responseObserver);
          break;
        case METHODID_INGEST_EVENTS:
          serviceImpl.ingestEvents(
              (com.google.ads.datamanager.v1.IngestEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.IngestEventsResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_REQUEST_STATUS:
          serviceImpl.retrieveRequestStatus(
              (com.google.ads.datamanager.v1.RetrieveRequestStatusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getIngestAudienceMembersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.IngestAudienceMembersRequest,
                    com.google.ads.datamanager.v1.IngestAudienceMembersResponse>(
                    service, METHODID_INGEST_AUDIENCE_MEMBERS)))
        .addMethod(
            getRemoveAudienceMembersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.RemoveAudienceMembersRequest,
                    com.google.ads.datamanager.v1.RemoveAudienceMembersResponse>(
                    service, METHODID_REMOVE_AUDIENCE_MEMBERS)))
        .addMethod(
            getIngestEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.IngestEventsRequest,
                    com.google.ads.datamanager.v1.IngestEventsResponse>(
                    service, METHODID_INGEST_EVENTS)))
        .addMethod(
            getRetrieveRequestStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.RetrieveRequestStatusRequest,
                    com.google.ads.datamanager.v1.RetrieveRequestStatusResponse>(
                    service, METHODID_RETRIEVE_REQUEST_STATUS)))
        .build();
  }

  private abstract static class IngestionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IngestionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ads.datamanager.v1.IngestionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IngestionService");
    }
  }

  private static final class IngestionServiceFileDescriptorSupplier
      extends IngestionServiceBaseDescriptorSupplier {
    IngestionServiceFileDescriptorSupplier() {}
  }

  private static final class IngestionServiceMethodDescriptorSupplier
      extends IngestionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IngestionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IngestionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IngestionServiceFileDescriptorSupplier())
                      .addMethod(getIngestAudienceMembersMethod())
                      .addMethod(getRemoveAudienceMembersMethod())
                      .addMethod(getIngestEventsMethod())
                      .addMethod(getRetrieveRequestStatusMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
