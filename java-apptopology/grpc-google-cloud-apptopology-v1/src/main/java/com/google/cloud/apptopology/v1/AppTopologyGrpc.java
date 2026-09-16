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
package com.google.cloud.apptopology.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AppTopologyGrpc {

  private AppTopologyGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.apptopology.v1.AppTopology";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest,
          com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse>
      getGenerateDiscoveredResourcesTopologyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateDiscoveredResourcesTopology",
      requestType =
          com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest.class,
      responseType =
          com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest,
          com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse>
      getGenerateDiscoveredResourcesTopologyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest,
            com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse>
        getGenerateDiscoveredResourcesTopologyMethod;
    if ((getGenerateDiscoveredResourcesTopologyMethod =
            AppTopologyGrpc.getGenerateDiscoveredResourcesTopologyMethod)
        == null) {
      synchronized (AppTopologyGrpc.class) {
        if ((getGenerateDiscoveredResourcesTopologyMethod =
                AppTopologyGrpc.getGenerateDiscoveredResourcesTopologyMethod)
            == null) {
          AppTopologyGrpc.getGenerateDiscoveredResourcesTopologyMethod =
              getGenerateDiscoveredResourcesTopologyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest,
                          com.google.cloud.apptopology.v1
                              .GenerateDiscoveredResourcesTopologyResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GenerateDiscoveredResourcesTopology"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apptopology.v1
                                  .GenerateDiscoveredResourcesTopologyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apptopology.v1
                                  .GenerateDiscoveredResourcesTopologyResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppTopologyMethodDescriptorSupplier(
                              "GenerateDiscoveredResourcesTopology"))
                      .build();
        }
      }
    }
    return getGenerateDiscoveredResourcesTopologyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apptopology.v1.GetSchemaRequest, com.google.cloud.apptopology.v1.Schema>
      getGetSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSchema",
      requestType = com.google.cloud.apptopology.v1.GetSchemaRequest.class,
      responseType = com.google.cloud.apptopology.v1.Schema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apptopology.v1.GetSchemaRequest, com.google.cloud.apptopology.v1.Schema>
      getGetSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apptopology.v1.GetSchemaRequest,
            com.google.cloud.apptopology.v1.Schema>
        getGetSchemaMethod;
    if ((getGetSchemaMethod = AppTopologyGrpc.getGetSchemaMethod) == null) {
      synchronized (AppTopologyGrpc.class) {
        if ((getGetSchemaMethod = AppTopologyGrpc.getGetSchemaMethod) == null) {
          AppTopologyGrpc.getGetSchemaMethod =
              getGetSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apptopology.v1.GetSchemaRequest,
                          com.google.cloud.apptopology.v1.Schema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apptopology.v1.GetSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apptopology.v1.Schema.getDefaultInstance()))
                      .setSchemaDescriptor(new AppTopologyMethodDescriptorSupplier("GetSchema"))
                      .build();
        }
      }
    }
    return getGetSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apptopology.v1.GetDomainRequest, com.google.cloud.apptopology.v1.Domain>
      getGetDomainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDomain",
      requestType = com.google.cloud.apptopology.v1.GetDomainRequest.class,
      responseType = com.google.cloud.apptopology.v1.Domain.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apptopology.v1.GetDomainRequest, com.google.cloud.apptopology.v1.Domain>
      getGetDomainMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apptopology.v1.GetDomainRequest,
            com.google.cloud.apptopology.v1.Domain>
        getGetDomainMethod;
    if ((getGetDomainMethod = AppTopologyGrpc.getGetDomainMethod) == null) {
      synchronized (AppTopologyGrpc.class) {
        if ((getGetDomainMethod = AppTopologyGrpc.getGetDomainMethod) == null) {
          AppTopologyGrpc.getGetDomainMethod =
              getGetDomainMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apptopology.v1.GetDomainRequest,
                          com.google.cloud.apptopology.v1.Domain>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDomain"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apptopology.v1.GetDomainRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apptopology.v1.Domain.getDefaultInstance()))
                      .setSchemaDescriptor(new AppTopologyMethodDescriptorSupplier("GetDomain"))
                      .build();
        }
      }
    }
    return getGetDomainMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apptopology.v1.ListDomainsRequest,
          com.google.cloud.apptopology.v1.ListDomainsResponse>
      getListDomainsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDomains",
      requestType = com.google.cloud.apptopology.v1.ListDomainsRequest.class,
      responseType = com.google.cloud.apptopology.v1.ListDomainsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apptopology.v1.ListDomainsRequest,
          com.google.cloud.apptopology.v1.ListDomainsResponse>
      getListDomainsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apptopology.v1.ListDomainsRequest,
            com.google.cloud.apptopology.v1.ListDomainsResponse>
        getListDomainsMethod;
    if ((getListDomainsMethod = AppTopologyGrpc.getListDomainsMethod) == null) {
      synchronized (AppTopologyGrpc.class) {
        if ((getListDomainsMethod = AppTopologyGrpc.getListDomainsMethod) == null) {
          AppTopologyGrpc.getListDomainsMethod =
              getListDomainsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apptopology.v1.ListDomainsRequest,
                          com.google.cloud.apptopology.v1.ListDomainsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDomains"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apptopology.v1.ListDomainsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apptopology.v1.ListDomainsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AppTopologyMethodDescriptorSupplier("ListDomains"))
                      .build();
        }
      }
    }
    return getListDomainsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AppTopologyStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppTopologyStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppTopologyStub>() {
          @java.lang.Override
          public AppTopologyStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppTopologyStub(channel, callOptions);
          }
        };
    return AppTopologyStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AppTopologyBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppTopologyBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppTopologyBlockingV2Stub>() {
          @java.lang.Override
          public AppTopologyBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppTopologyBlockingV2Stub(channel, callOptions);
          }
        };
    return AppTopologyBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppTopologyBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppTopologyBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppTopologyBlockingStub>() {
          @java.lang.Override
          public AppTopologyBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppTopologyBlockingStub(channel, callOptions);
          }
        };
    return AppTopologyBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AppTopologyFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppTopologyFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppTopologyFutureStub>() {
          @java.lang.Override
          public AppTopologyFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppTopologyFutureStub(channel, callOptions);
          }
        };
    return AppTopologyFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Generate the topology for all resources in the given project. If the
     * project represents an
     * [app
     * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary),
     * the topology is generated for all resources in the boundary.
     * </pre>
     */
    default void generateDiscoveredResourcesTopology(
        com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateDiscoveredResourcesTopologyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the schema for the specified topology domain. The schema
     * defines the NodeTypes and EdgeTypes that are supported in
     * GenerateDiscoveredResourcesTopology requests and responses for a given
     * domain.
     * </pre>
     */
    default void getSchema(
        com.google.cloud.apptopology.v1.GetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.Schema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified topology domain.
     * </pre>
     */
    default void getDomain(
        com.google.cloud.apptopology.v1.GetDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.Domain> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDomainMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the topology domains available in a specific location.
     * Only `global` location is supported.
     * </pre>
     */
    default void listDomains(
        com.google.cloud.apptopology.v1.ListDomainsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.ListDomainsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDomainsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AppTopology.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class AppTopologyImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AppTopologyGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AppTopology.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AppTopologyStub
      extends io.grpc.stub.AbstractAsyncStub<AppTopologyStub> {
    private AppTopologyStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppTopologyStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppTopologyStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generate the topology for all resources in the given project. If the
     * project represents an
     * [app
     * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary),
     * the topology is generated for all resources in the boundary.
     * </pre>
     */
    public void generateDiscoveredResourcesTopology(
        com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateDiscoveredResourcesTopologyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the schema for the specified topology domain. The schema
     * defines the NodeTypes and EdgeTypes that are supported in
     * GenerateDiscoveredResourcesTopology requests and responses for a given
     * domain.
     * </pre>
     */
    public void getSchema(
        com.google.cloud.apptopology.v1.GetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.Schema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSchemaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified topology domain.
     * </pre>
     */
    public void getDomain(
        com.google.cloud.apptopology.v1.GetDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.Domain> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDomainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the topology domains available in a specific location.
     * Only `global` location is supported.
     * </pre>
     */
    public void listDomains(
        com.google.cloud.apptopology.v1.ListDomainsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.ListDomainsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDomainsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AppTopology.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AppTopologyBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AppTopologyBlockingV2Stub> {
    private AppTopologyBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppTopologyBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppTopologyBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generate the topology for all resources in the given project. If the
     * project represents an
     * [app
     * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary),
     * the topology is generated for all resources in the boundary.
     * </pre>
     */
    public com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse
        generateDiscoveredResourcesTopology(
            com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateDiscoveredResourcesTopologyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the schema for the specified topology domain. The schema
     * defines the NodeTypes and EdgeTypes that are supported in
     * GenerateDiscoveredResourcesTopology requests and responses for a given
     * domain.
     * </pre>
     */
    public com.google.cloud.apptopology.v1.Schema getSchema(
        com.google.cloud.apptopology.v1.GetSchemaRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified topology domain.
     * </pre>
     */
    public com.google.cloud.apptopology.v1.Domain getDomain(
        com.google.cloud.apptopology.v1.GetDomainRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDomainMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the topology domains available in a specific location.
     * Only `global` location is supported.
     * </pre>
     */
    public com.google.cloud.apptopology.v1.ListDomainsResponse listDomains(
        com.google.cloud.apptopology.v1.ListDomainsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDomainsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AppTopology.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AppTopologyBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AppTopologyBlockingStub> {
    private AppTopologyBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppTopologyBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppTopologyBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generate the topology for all resources in the given project. If the
     * project represents an
     * [app
     * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary),
     * the topology is generated for all resources in the boundary.
     * </pre>
     */
    public com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse
        generateDiscoveredResourcesTopology(
            com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateDiscoveredResourcesTopologyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the schema for the specified topology domain. The schema
     * defines the NodeTypes and EdgeTypes that are supported in
     * GenerateDiscoveredResourcesTopology requests and responses for a given
     * domain.
     * </pre>
     */
    public com.google.cloud.apptopology.v1.Schema getSchema(
        com.google.cloud.apptopology.v1.GetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified topology domain.
     * </pre>
     */
    public com.google.cloud.apptopology.v1.Domain getDomain(
        com.google.cloud.apptopology.v1.GetDomainRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDomainMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the topology domains available in a specific location.
     * Only `global` location is supported.
     * </pre>
     */
    public com.google.cloud.apptopology.v1.ListDomainsResponse listDomains(
        com.google.cloud.apptopology.v1.ListDomainsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDomainsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AppTopology.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AppTopologyFutureStub
      extends io.grpc.stub.AbstractFutureStub<AppTopologyFutureStub> {
    private AppTopologyFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppTopologyFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppTopologyFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generate the topology for all resources in the given project. If the
     * project represents an
     * [app
     * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary),
     * the topology is generated for all resources in the boundary.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse>
        generateDiscoveredResourcesTopology(
            com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateDiscoveredResourcesTopologyMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the schema for the specified topology domain. The schema
     * defines the NodeTypes and EdgeTypes that are supported in
     * GenerateDiscoveredResourcesTopology requests and responses for a given
     * domain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apptopology.v1.Schema>
        getSchema(com.google.cloud.apptopology.v1.GetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified topology domain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apptopology.v1.Domain>
        getDomain(com.google.cloud.apptopology.v1.GetDomainRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDomainMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the topology domains available in a specific location.
     * Only `global` location is supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apptopology.v1.ListDomainsResponse>
        listDomains(com.google.cloud.apptopology.v1.ListDomainsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDomainsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_DISCOVERED_RESOURCES_TOPOLOGY = 0;
  private static final int METHODID_GET_SCHEMA = 1;
  private static final int METHODID_GET_DOMAIN = 2;
  private static final int METHODID_LIST_DOMAINS = 3;

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
        case METHODID_GENERATE_DISCOVERED_RESOURCES_TOPOLOGY:
          serviceImpl.generateDiscoveredResourcesTopology(
              (com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SCHEMA:
          serviceImpl.getSchema(
              (com.google.cloud.apptopology.v1.GetSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.Schema>)
                  responseObserver);
          break;
        case METHODID_GET_DOMAIN:
          serviceImpl.getDomain(
              (com.google.cloud.apptopology.v1.GetDomainRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.Domain>)
                  responseObserver);
          break;
        case METHODID_LIST_DOMAINS:
          serviceImpl.listDomains(
              (com.google.cloud.apptopology.v1.ListDomainsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apptopology.v1.ListDomainsResponse>)
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
            getGenerateDiscoveredResourcesTopologyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest,
                    com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse>(
                    service, METHODID_GENERATE_DISCOVERED_RESOURCES_TOPOLOGY)))
        .addMethod(
            getGetSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apptopology.v1.GetSchemaRequest,
                    com.google.cloud.apptopology.v1.Schema>(service, METHODID_GET_SCHEMA)))
        .addMethod(
            getGetDomainMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apptopology.v1.GetDomainRequest,
                    com.google.cloud.apptopology.v1.Domain>(service, METHODID_GET_DOMAIN)))
        .addMethod(
            getListDomainsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apptopology.v1.ListDomainsRequest,
                    com.google.cloud.apptopology.v1.ListDomainsResponse>(
                    service, METHODID_LIST_DOMAINS)))
        .build();
  }

  private abstract static class AppTopologyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppTopologyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apptopology.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppTopology");
    }
  }

  private static final class AppTopologyFileDescriptorSupplier
      extends AppTopologyBaseDescriptorSupplier {
    AppTopologyFileDescriptorSupplier() {}
  }

  private static final class AppTopologyMethodDescriptorSupplier
      extends AppTopologyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AppTopologyMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AppTopologyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AppTopologyFileDescriptorSupplier())
                      .addMethod(getGenerateDiscoveredResourcesTopologyMethod())
                      .addMethod(getGetSchemaMethod())
                      .addMethod(getGetDomainMethod())
                      .addMethod(getListDomainsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
