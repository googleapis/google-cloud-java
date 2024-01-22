/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.servicehealth.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Request service health events relevant to your Google Cloud project.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/servicehealth/v1/event_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServiceHealthGrpc {

  private ServiceHealthGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.servicehealth.v1.ServiceHealth";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.ListEventsRequest,
          com.google.cloud.servicehealth.v1.ListEventsResponse>
      getListEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvents",
      requestType = com.google.cloud.servicehealth.v1.ListEventsRequest.class,
      responseType = com.google.cloud.servicehealth.v1.ListEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.ListEventsRequest,
          com.google.cloud.servicehealth.v1.ListEventsResponse>
      getListEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicehealth.v1.ListEventsRequest,
            com.google.cloud.servicehealth.v1.ListEventsResponse>
        getListEventsMethod;
    if ((getListEventsMethod = ServiceHealthGrpc.getListEventsMethod) == null) {
      synchronized (ServiceHealthGrpc.class) {
        if ((getListEventsMethod = ServiceHealthGrpc.getListEventsMethod) == null) {
          ServiceHealthGrpc.getListEventsMethod =
              getListEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicehealth.v1.ListEventsRequest,
                          com.google.cloud.servicehealth.v1.ListEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.ListEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.ListEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ServiceHealthMethodDescriptorSupplier("ListEvents"))
                      .build();
        }
      }
    }
    return getListEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.GetEventRequest,
          com.google.cloud.servicehealth.v1.Event>
      getGetEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvent",
      requestType = com.google.cloud.servicehealth.v1.GetEventRequest.class,
      responseType = com.google.cloud.servicehealth.v1.Event.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.GetEventRequest,
          com.google.cloud.servicehealth.v1.Event>
      getGetEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicehealth.v1.GetEventRequest,
            com.google.cloud.servicehealth.v1.Event>
        getGetEventMethod;
    if ((getGetEventMethod = ServiceHealthGrpc.getGetEventMethod) == null) {
      synchronized (ServiceHealthGrpc.class) {
        if ((getGetEventMethod = ServiceHealthGrpc.getGetEventMethod) == null) {
          ServiceHealthGrpc.getGetEventMethod =
              getGetEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicehealth.v1.GetEventRequest,
                          com.google.cloud.servicehealth.v1.Event>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.GetEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.Event.getDefaultInstance()))
                      .setSchemaDescriptor(new ServiceHealthMethodDescriptorSupplier("GetEvent"))
                      .build();
        }
      }
    }
    return getGetEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest,
          com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>
      getListOrganizationEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrganizationEvents",
      requestType = com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest.class,
      responseType = com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest,
          com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>
      getListOrganizationEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest,
            com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>
        getListOrganizationEventsMethod;
    if ((getListOrganizationEventsMethod = ServiceHealthGrpc.getListOrganizationEventsMethod)
        == null) {
      synchronized (ServiceHealthGrpc.class) {
        if ((getListOrganizationEventsMethod = ServiceHealthGrpc.getListOrganizationEventsMethod)
            == null) {
          ServiceHealthGrpc.getListOrganizationEventsMethod =
              getListOrganizationEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest,
                          com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOrganizationEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceHealthMethodDescriptorSupplier("ListOrganizationEvents"))
                      .build();
        }
      }
    }
    return getListOrganizationEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.GetOrganizationEventRequest,
          com.google.cloud.servicehealth.v1.OrganizationEvent>
      getGetOrganizationEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrganizationEvent",
      requestType = com.google.cloud.servicehealth.v1.GetOrganizationEventRequest.class,
      responseType = com.google.cloud.servicehealth.v1.OrganizationEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.GetOrganizationEventRequest,
          com.google.cloud.servicehealth.v1.OrganizationEvent>
      getGetOrganizationEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicehealth.v1.GetOrganizationEventRequest,
            com.google.cloud.servicehealth.v1.OrganizationEvent>
        getGetOrganizationEventMethod;
    if ((getGetOrganizationEventMethod = ServiceHealthGrpc.getGetOrganizationEventMethod) == null) {
      synchronized (ServiceHealthGrpc.class) {
        if ((getGetOrganizationEventMethod = ServiceHealthGrpc.getGetOrganizationEventMethod)
            == null) {
          ServiceHealthGrpc.getGetOrganizationEventMethod =
              getGetOrganizationEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicehealth.v1.GetOrganizationEventRequest,
                          com.google.cloud.servicehealth.v1.OrganizationEvent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOrganizationEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.GetOrganizationEventRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.OrganizationEvent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceHealthMethodDescriptorSupplier("GetOrganizationEvent"))
                      .build();
        }
      }
    }
    return getGetOrganizationEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest,
          com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>
      getListOrganizationImpactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrganizationImpacts",
      requestType = com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest.class,
      responseType = com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest,
          com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>
      getListOrganizationImpactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest,
            com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>
        getListOrganizationImpactsMethod;
    if ((getListOrganizationImpactsMethod = ServiceHealthGrpc.getListOrganizationImpactsMethod)
        == null) {
      synchronized (ServiceHealthGrpc.class) {
        if ((getListOrganizationImpactsMethod = ServiceHealthGrpc.getListOrganizationImpactsMethod)
            == null) {
          ServiceHealthGrpc.getListOrganizationImpactsMethod =
              getListOrganizationImpactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest,
                          com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOrganizationImpacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceHealthMethodDescriptorSupplier("ListOrganizationImpacts"))
                      .build();
        }
      }
    }
    return getListOrganizationImpactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest,
          com.google.cloud.servicehealth.v1.OrganizationImpact>
      getGetOrganizationImpactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrganizationImpact",
      requestType = com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest.class,
      responseType = com.google.cloud.servicehealth.v1.OrganizationImpact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest,
          com.google.cloud.servicehealth.v1.OrganizationImpact>
      getGetOrganizationImpactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest,
            com.google.cloud.servicehealth.v1.OrganizationImpact>
        getGetOrganizationImpactMethod;
    if ((getGetOrganizationImpactMethod = ServiceHealthGrpc.getGetOrganizationImpactMethod)
        == null) {
      synchronized (ServiceHealthGrpc.class) {
        if ((getGetOrganizationImpactMethod = ServiceHealthGrpc.getGetOrganizationImpactMethod)
            == null) {
          ServiceHealthGrpc.getGetOrganizationImpactMethod =
              getGetOrganizationImpactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest,
                          com.google.cloud.servicehealth.v1.OrganizationImpact>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOrganizationImpact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicehealth.v1.OrganizationImpact
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceHealthMethodDescriptorSupplier("GetOrganizationImpact"))
                      .build();
        }
      }
    }
    return getGetOrganizationImpactMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ServiceHealthStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceHealthStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceHealthStub>() {
          @java.lang.Override
          public ServiceHealthStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceHealthStub(channel, callOptions);
          }
        };
    return ServiceHealthStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceHealthBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceHealthBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceHealthBlockingStub>() {
          @java.lang.Override
          public ServiceHealthBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceHealthBlockingStub(channel, callOptions);
          }
        };
    return ServiceHealthBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ServiceHealthFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceHealthFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceHealthFutureStub>() {
          @java.lang.Override
          public ServiceHealthFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceHealthFutureStub(channel, callOptions);
          }
        };
    return ServiceHealthFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Request service health events relevant to your Google Cloud project.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists events under a given project and location.
     * </pre>
     */
    default void listEvents(
        com.google.cloud.servicehealth.v1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.ListEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about an event.
     * </pre>
     */
    default void getEvent(
        com.google.cloud.servicehealth.v1.GetEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.Event> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists organization events under a given organization and location.
     * </pre>
     */
    default void listOrganizationEvents(
        com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOrganizationEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about an event affecting an
     * organization .
     * </pre>
     */
    default void getOrganizationEvent(
        com.google.cloud.servicehealth.v1.GetOrganizationEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.OrganizationEvent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrganizationEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists assets impacted by organization events under a given organization and
     * location.
     * </pre>
     */
    default void listOrganizationImpacts(
        com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOrganizationImpactsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about impact to an asset under
     * an organization affected by a service health event.
     * </pre>
     */
    default void getOrganizationImpact(
        com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.OrganizationImpact>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrganizationImpactMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ServiceHealth.
   *
   * <pre>
   * Request service health events relevant to your Google Cloud project.
   * </pre>
   */
  public abstract static class ServiceHealthImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ServiceHealthGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ServiceHealth.
   *
   * <pre>
   * Request service health events relevant to your Google Cloud project.
   * </pre>
   */
  public static final class ServiceHealthStub
      extends io.grpc.stub.AbstractAsyncStub<ServiceHealthStub> {
    private ServiceHealthStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceHealthStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceHealthStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists events under a given project and location.
     * </pre>
     */
    public void listEvents(
        com.google.cloud.servicehealth.v1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.ListEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about an event.
     * </pre>
     */
    public void getEvent(
        com.google.cloud.servicehealth.v1.GetEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.Event> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists organization events under a given organization and location.
     * </pre>
     */
    public void listOrganizationEvents(
        com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrganizationEventsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about an event affecting an
     * organization .
     * </pre>
     */
    public void getOrganizationEvent(
        com.google.cloud.servicehealth.v1.GetOrganizationEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.OrganizationEvent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrganizationEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists assets impacted by organization events under a given organization and
     * location.
     * </pre>
     */
    public void listOrganizationImpacts(
        com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrganizationImpactsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about impact to an asset under
     * an organization affected by a service health event.
     * </pre>
     */
    public void getOrganizationImpact(
        com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.OrganizationImpact>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrganizationImpactMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ServiceHealth.
   *
   * <pre>
   * Request service health events relevant to your Google Cloud project.
   * </pre>
   */
  public static final class ServiceHealthBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServiceHealthBlockingStub> {
    private ServiceHealthBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceHealthBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceHealthBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists events under a given project and location.
     * </pre>
     */
    public com.google.cloud.servicehealth.v1.ListEventsResponse listEvents(
        com.google.cloud.servicehealth.v1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about an event.
     * </pre>
     */
    public com.google.cloud.servicehealth.v1.Event getEvent(
        com.google.cloud.servicehealth.v1.GetEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists organization events under a given organization and location.
     * </pre>
     */
    public com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse listOrganizationEvents(
        com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrganizationEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about an event affecting an
     * organization .
     * </pre>
     */
    public com.google.cloud.servicehealth.v1.OrganizationEvent getOrganizationEvent(
        com.google.cloud.servicehealth.v1.GetOrganizationEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrganizationEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists assets impacted by organization events under a given organization and
     * location.
     * </pre>
     */
    public com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse
        listOrganizationImpacts(
            com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrganizationImpactsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about impact to an asset under
     * an organization affected by a service health event.
     * </pre>
     */
    public com.google.cloud.servicehealth.v1.OrganizationImpact getOrganizationImpact(
        com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrganizationImpactMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ServiceHealth.
   *
   * <pre>
   * Request service health events relevant to your Google Cloud project.
   * </pre>
   */
  public static final class ServiceHealthFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServiceHealthFutureStub> {
    private ServiceHealthFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceHealthFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceHealthFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists events under a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicehealth.v1.ListEventsResponse>
        listEvents(com.google.cloud.servicehealth.v1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about an event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicehealth.v1.Event>
        getEvent(com.google.cloud.servicehealth.v1.GetEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists organization events under a given organization and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>
        listOrganizationEvents(
            com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrganizationEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about an event affecting an
     * organization .
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicehealth.v1.OrganizationEvent>
        getOrganizationEvent(
            com.google.cloud.servicehealth.v1.GetOrganizationEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrganizationEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists assets impacted by organization events under a given organization and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>
        listOrganizationImpacts(
            com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrganizationImpactsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about impact to an asset under
     * an organization affected by a service health event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicehealth.v1.OrganizationImpact>
        getOrganizationImpact(
            com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrganizationImpactMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_EVENTS = 0;
  private static final int METHODID_GET_EVENT = 1;
  private static final int METHODID_LIST_ORGANIZATION_EVENTS = 2;
  private static final int METHODID_GET_ORGANIZATION_EVENT = 3;
  private static final int METHODID_LIST_ORGANIZATION_IMPACTS = 4;
  private static final int METHODID_GET_ORGANIZATION_IMPACT = 5;

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
        case METHODID_LIST_EVENTS:
          serviceImpl.listEvents(
              (com.google.cloud.servicehealth.v1.ListEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.ListEventsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EVENT:
          serviceImpl.getEvent(
              (com.google.cloud.servicehealth.v1.GetEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.Event>)
                  responseObserver);
          break;
        case METHODID_LIST_ORGANIZATION_EVENTS:
          serviceImpl.listOrganizationEvents(
              (com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ORGANIZATION_EVENT:
          serviceImpl.getOrganizationEvent(
              (com.google.cloud.servicehealth.v1.GetOrganizationEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.OrganizationEvent>)
                  responseObserver);
          break;
        case METHODID_LIST_ORGANIZATION_IMPACTS:
          serviceImpl.listOrganizationImpacts(
              (com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ORGANIZATION_IMPACT:
          serviceImpl.getOrganizationImpact(
              (com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicehealth.v1.OrganizationImpact>)
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
            getListEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.servicehealth.v1.ListEventsRequest,
                    com.google.cloud.servicehealth.v1.ListEventsResponse>(
                    service, METHODID_LIST_EVENTS)))
        .addMethod(
            getGetEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.servicehealth.v1.GetEventRequest,
                    com.google.cloud.servicehealth.v1.Event>(service, METHODID_GET_EVENT)))
        .addMethod(
            getListOrganizationEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest,
                    com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse>(
                    service, METHODID_LIST_ORGANIZATION_EVENTS)))
        .addMethod(
            getGetOrganizationEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.servicehealth.v1.GetOrganizationEventRequest,
                    com.google.cloud.servicehealth.v1.OrganizationEvent>(
                    service, METHODID_GET_ORGANIZATION_EVENT)))
        .addMethod(
            getListOrganizationImpactsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest,
                    com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse>(
                    service, METHODID_LIST_ORGANIZATION_IMPACTS)))
        .addMethod(
            getGetOrganizationImpactMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest,
                    com.google.cloud.servicehealth.v1.OrganizationImpact>(
                    service, METHODID_GET_ORGANIZATION_IMPACT)))
        .build();
  }

  private abstract static class ServiceHealthBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceHealthBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.servicehealth.v1.EventServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceHealth");
    }
  }

  private static final class ServiceHealthFileDescriptorSupplier
      extends ServiceHealthBaseDescriptorSupplier {
    ServiceHealthFileDescriptorSupplier() {}
  }

  private static final class ServiceHealthMethodDescriptorSupplier
      extends ServiceHealthBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ServiceHealthMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ServiceHealthGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ServiceHealthFileDescriptorSupplier())
                      .addMethod(getListEventsMethod())
                      .addMethod(getGetEventMethod())
                      .addMethod(getListOrganizationEventsMethod())
                      .addMethod(getGetOrganizationEventMethod())
                      .addMethod(getListOrganizationImpactsMethod())
                      .addMethod(getGetOrganizationImpactMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
