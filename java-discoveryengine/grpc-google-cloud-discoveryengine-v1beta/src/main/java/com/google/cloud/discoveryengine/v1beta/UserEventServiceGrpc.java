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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for ingesting end user actions on a website to Discovery Engine API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/user_event_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserEventServiceGrpc {

  private UserEventServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.discoveryengine.v1beta.UserEventService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest,
          com.google.cloud.discoveryengine.v1beta.UserEvent>
      getWriteUserEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteUserEvent",
      requestType = com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.UserEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest,
          com.google.cloud.discoveryengine.v1beta.UserEvent>
      getWriteUserEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest,
            com.google.cloud.discoveryengine.v1beta.UserEvent>
        getWriteUserEventMethod;
    if ((getWriteUserEventMethod = UserEventServiceGrpc.getWriteUserEventMethod) == null) {
      synchronized (UserEventServiceGrpc.class) {
        if ((getWriteUserEventMethod = UserEventServiceGrpc.getWriteUserEventMethod) == null) {
          UserEventServiceGrpc.getWriteUserEventMethod =
              getWriteUserEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest,
                          com.google.cloud.discoveryengine.v1beta.UserEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteUserEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UserEvent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserEventServiceMethodDescriptorSupplier("WriteUserEvent"))
                      .build();
        }
      }
    }
    return getWriteUserEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest, com.google.api.HttpBody>
      getCollectUserEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CollectUserEvent",
      requestType = com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest.class,
      responseType = com.google.api.HttpBody.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest, com.google.api.HttpBody>
      getCollectUserEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest,
            com.google.api.HttpBody>
        getCollectUserEventMethod;
    if ((getCollectUserEventMethod = UserEventServiceGrpc.getCollectUserEventMethod) == null) {
      synchronized (UserEventServiceGrpc.class) {
        if ((getCollectUserEventMethod = UserEventServiceGrpc.getCollectUserEventMethod) == null) {
          UserEventServiceGrpc.getCollectUserEventMethod =
              getCollectUserEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest,
                          com.google.api.HttpBody>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CollectUserEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.HttpBody.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserEventServiceMethodDescriptorSupplier("CollectUserEvent"))
                      .build();
        }
      }
    }
    return getCollectUserEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest,
          com.google.longrunning.Operation>
      getImportUserEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportUserEvents",
      requestType = com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest,
          com.google.longrunning.Operation>
      getImportUserEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest,
            com.google.longrunning.Operation>
        getImportUserEventsMethod;
    if ((getImportUserEventsMethod = UserEventServiceGrpc.getImportUserEventsMethod) == null) {
      synchronized (UserEventServiceGrpc.class) {
        if ((getImportUserEventsMethod = UserEventServiceGrpc.getImportUserEventsMethod) == null) {
          UserEventServiceGrpc.getImportUserEventsMethod =
              getImportUserEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportUserEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserEventServiceMethodDescriptorSupplier("ImportUserEvents"))
                      .build();
        }
      }
    }
    return getImportUserEventsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UserEventServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserEventServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserEventServiceStub>() {
          @java.lang.Override
          public UserEventServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserEventServiceStub(channel, callOptions);
          }
        };
    return UserEventServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserEventServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserEventServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserEventServiceBlockingStub>() {
          @java.lang.Override
          public UserEventServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserEventServiceBlockingStub(channel, callOptions);
          }
        };
    return UserEventServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UserEventServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserEventServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserEventServiceFutureStub>() {
          @java.lang.Override
          public UserEventServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserEventServiceFutureStub(channel, callOptions);
          }
        };
    return UserEventServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting end user actions on a website to Discovery Engine API.
   * </pre>
   */
  public abstract static class UserEventServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Writes a single user event.
     * </pre>
     */
    public void writeUserEvent(
        com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getWriteUserEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Writes a single user event from the browser. This uses a GET request to
     * due to browser restriction of POST-ing to a 3rd party domain.
     * This method is used only by the Discovery Engine API JavaScript pixel and
     * Google Tag Manager. Users should not call this method directly.
     * </pre>
     */
    public void collectUserEvent(
        com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCollectUserEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of User events. Request processing might be
     * synchronous. Events that already exist are skipped.
     * Use this method for backfilling historical user events.
     * Operation.response is of type ImportResponse. Note that it is
     * possible for a subset of the items to be successfully inserted.
     * Operation.metadata is of type ImportMetadata.
     * </pre>
     */
    public void importUserEvents(
        com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportUserEventsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getWriteUserEventMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest,
                      com.google.cloud.discoveryengine.v1beta.UserEvent>(
                      this, METHODID_WRITE_USER_EVENT)))
          .addMethod(
              getCollectUserEventMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest,
                      com.google.api.HttpBody>(this, METHODID_COLLECT_USER_EVENT)))
          .addMethod(
              getImportUserEventsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_USER_EVENTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting end user actions on a website to Discovery Engine API.
   * </pre>
   */
  public static final class UserEventServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserEventServiceStub> {
    private UserEventServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserEventServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserEventServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Writes a single user event.
     * </pre>
     */
    public void writeUserEvent(
        com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserEvent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteUserEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Writes a single user event from the browser. This uses a GET request to
     * due to browser restriction of POST-ing to a 3rd party domain.
     * This method is used only by the Discovery Engine API JavaScript pixel and
     * Google Tag Manager. Users should not call this method directly.
     * </pre>
     */
    public void collectUserEvent(
        com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest request,
        io.grpc.stub.StreamObserver<com.google.api.HttpBody> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCollectUserEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of User events. Request processing might be
     * synchronous. Events that already exist are skipped.
     * Use this method for backfilling historical user events.
     * Operation.response is of type ImportResponse. Note that it is
     * possible for a subset of the items to be successfully inserted.
     * Operation.metadata is of type ImportMetadata.
     * </pre>
     */
    public void importUserEvents(
        com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportUserEventsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting end user actions on a website to Discovery Engine API.
   * </pre>
   */
  public static final class UserEventServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserEventServiceBlockingStub> {
    private UserEventServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserEventServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserEventServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Writes a single user event.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.UserEvent writeUserEvent(
        com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteUserEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Writes a single user event from the browser. This uses a GET request to
     * due to browser restriction of POST-ing to a 3rd party domain.
     * This method is used only by the Discovery Engine API JavaScript pixel and
     * Google Tag Manager. Users should not call this method directly.
     * </pre>
     */
    public com.google.api.HttpBody collectUserEvent(
        com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCollectUserEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of User events. Request processing might be
     * synchronous. Events that already exist are skipped.
     * Use this method for backfilling historical user events.
     * Operation.response is of type ImportResponse. Note that it is
     * possible for a subset of the items to be successfully inserted.
     * Operation.metadata is of type ImportMetadata.
     * </pre>
     */
    public com.google.longrunning.Operation importUserEvents(
        com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportUserEventsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting end user actions on a website to Discovery Engine API.
   * </pre>
   */
  public static final class UserEventServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserEventServiceFutureStub> {
    private UserEventServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserEventServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserEventServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Writes a single user event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.UserEvent>
        writeUserEvent(com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteUserEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Writes a single user event from the browser. This uses a GET request to
     * due to browser restriction of POST-ing to a 3rd party domain.
     * This method is used only by the Discovery Engine API JavaScript pixel and
     * Google Tag Manager. Users should not call this method directly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.HttpBody>
        collectUserEvent(com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCollectUserEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of User events. Request processing might be
     * synchronous. Events that already exist are skipped.
     * Use this method for backfilling historical user events.
     * Operation.response is of type ImportResponse. Note that it is
     * possible for a subset of the items to be successfully inserted.
     * Operation.metadata is of type ImportMetadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importUserEvents(com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportUserEventsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WRITE_USER_EVENT = 0;
  private static final int METHODID_COLLECT_USER_EVENT = 1;
  private static final int METHODID_IMPORT_USER_EVENTS = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserEventServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserEventServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRITE_USER_EVENT:
          serviceImpl.writeUserEvent(
              (com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserEvent>)
                  responseObserver);
          break;
        case METHODID_COLLECT_USER_EVENT:
          serviceImpl.collectUserEvent(
              (com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.HttpBody>) responseObserver);
          break;
        case METHODID_IMPORT_USER_EVENTS:
          serviceImpl.importUserEvents(
              (com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private abstract static class UserEventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserEventServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.UserEventServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserEventService");
    }
  }

  private static final class UserEventServiceFileDescriptorSupplier
      extends UserEventServiceBaseDescriptorSupplier {
    UserEventServiceFileDescriptorSupplier() {}
  }

  private static final class UserEventServiceMethodDescriptorSupplier
      extends UserEventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserEventServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserEventServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UserEventServiceFileDescriptorSupplier())
                      .addMethod(getWriteUserEventMethod())
                      .addMethod(getCollectUserEventMethod())
                      .addMethod(getImportUserEventsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
