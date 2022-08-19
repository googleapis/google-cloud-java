package com.google.appengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages domains serving an application.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/appengine/v1/appengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DomainMappingsGrpc {

  private DomainMappingsGrpc() {}

  public static final String SERVICE_NAME = "google.appengine.v1.DomainMappings";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.ListDomainMappingsRequest,
      com.google.appengine.v1.ListDomainMappingsResponse> getListDomainMappingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDomainMappings",
      requestType = com.google.appengine.v1.ListDomainMappingsRequest.class,
      responseType = com.google.appengine.v1.ListDomainMappingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.ListDomainMappingsRequest,
      com.google.appengine.v1.ListDomainMappingsResponse> getListDomainMappingsMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.ListDomainMappingsRequest, com.google.appengine.v1.ListDomainMappingsResponse> getListDomainMappingsMethod;
    if ((getListDomainMappingsMethod = DomainMappingsGrpc.getListDomainMappingsMethod) == null) {
      synchronized (DomainMappingsGrpc.class) {
        if ((getListDomainMappingsMethod = DomainMappingsGrpc.getListDomainMappingsMethod) == null) {
          DomainMappingsGrpc.getListDomainMappingsMethod = getListDomainMappingsMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.ListDomainMappingsRequest, com.google.appengine.v1.ListDomainMappingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDomainMappings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.ListDomainMappingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.ListDomainMappingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DomainMappingsMethodDescriptorSupplier("ListDomainMappings"))
              .build();
        }
      }
    }
    return getListDomainMappingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.GetDomainMappingRequest,
      com.google.appengine.v1.DomainMapping> getGetDomainMappingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDomainMapping",
      requestType = com.google.appengine.v1.GetDomainMappingRequest.class,
      responseType = com.google.appengine.v1.DomainMapping.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.GetDomainMappingRequest,
      com.google.appengine.v1.DomainMapping> getGetDomainMappingMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.GetDomainMappingRequest, com.google.appengine.v1.DomainMapping> getGetDomainMappingMethod;
    if ((getGetDomainMappingMethod = DomainMappingsGrpc.getGetDomainMappingMethod) == null) {
      synchronized (DomainMappingsGrpc.class) {
        if ((getGetDomainMappingMethod = DomainMappingsGrpc.getGetDomainMappingMethod) == null) {
          DomainMappingsGrpc.getGetDomainMappingMethod = getGetDomainMappingMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.GetDomainMappingRequest, com.google.appengine.v1.DomainMapping>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDomainMapping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.GetDomainMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.DomainMapping.getDefaultInstance()))
              .setSchemaDescriptor(new DomainMappingsMethodDescriptorSupplier("GetDomainMapping"))
              .build();
        }
      }
    }
    return getGetDomainMappingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.CreateDomainMappingRequest,
      com.google.longrunning.Operation> getCreateDomainMappingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDomainMapping",
      requestType = com.google.appengine.v1.CreateDomainMappingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.CreateDomainMappingRequest,
      com.google.longrunning.Operation> getCreateDomainMappingMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.CreateDomainMappingRequest, com.google.longrunning.Operation> getCreateDomainMappingMethod;
    if ((getCreateDomainMappingMethod = DomainMappingsGrpc.getCreateDomainMappingMethod) == null) {
      synchronized (DomainMappingsGrpc.class) {
        if ((getCreateDomainMappingMethod = DomainMappingsGrpc.getCreateDomainMappingMethod) == null) {
          DomainMappingsGrpc.getCreateDomainMappingMethod = getCreateDomainMappingMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.CreateDomainMappingRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDomainMapping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.CreateDomainMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DomainMappingsMethodDescriptorSupplier("CreateDomainMapping"))
              .build();
        }
      }
    }
    return getCreateDomainMappingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateDomainMappingRequest,
      com.google.longrunning.Operation> getUpdateDomainMappingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDomainMapping",
      requestType = com.google.appengine.v1.UpdateDomainMappingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateDomainMappingRequest,
      com.google.longrunning.Operation> getUpdateDomainMappingMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateDomainMappingRequest, com.google.longrunning.Operation> getUpdateDomainMappingMethod;
    if ((getUpdateDomainMappingMethod = DomainMappingsGrpc.getUpdateDomainMappingMethod) == null) {
      synchronized (DomainMappingsGrpc.class) {
        if ((getUpdateDomainMappingMethod = DomainMappingsGrpc.getUpdateDomainMappingMethod) == null) {
          DomainMappingsGrpc.getUpdateDomainMappingMethod = getUpdateDomainMappingMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.UpdateDomainMappingRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDomainMapping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.UpdateDomainMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DomainMappingsMethodDescriptorSupplier("UpdateDomainMapping"))
              .build();
        }
      }
    }
    return getUpdateDomainMappingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteDomainMappingRequest,
      com.google.longrunning.Operation> getDeleteDomainMappingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDomainMapping",
      requestType = com.google.appengine.v1.DeleteDomainMappingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteDomainMappingRequest,
      com.google.longrunning.Operation> getDeleteDomainMappingMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteDomainMappingRequest, com.google.longrunning.Operation> getDeleteDomainMappingMethod;
    if ((getDeleteDomainMappingMethod = DomainMappingsGrpc.getDeleteDomainMappingMethod) == null) {
      synchronized (DomainMappingsGrpc.class) {
        if ((getDeleteDomainMappingMethod = DomainMappingsGrpc.getDeleteDomainMappingMethod) == null) {
          DomainMappingsGrpc.getDeleteDomainMappingMethod = getDeleteDomainMappingMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.DeleteDomainMappingRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDomainMapping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.DeleteDomainMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DomainMappingsMethodDescriptorSupplier("DeleteDomainMapping"))
              .build();
        }
      }
    }
    return getDeleteDomainMappingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DomainMappingsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DomainMappingsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DomainMappingsStub>() {
        @java.lang.Override
        public DomainMappingsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DomainMappingsStub(channel, callOptions);
        }
      };
    return DomainMappingsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DomainMappingsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DomainMappingsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DomainMappingsBlockingStub>() {
        @java.lang.Override
        public DomainMappingsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DomainMappingsBlockingStub(channel, callOptions);
        }
      };
    return DomainMappingsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DomainMappingsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DomainMappingsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DomainMappingsFutureStub>() {
        @java.lang.Override
        public DomainMappingsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DomainMappingsFutureStub(channel, callOptions);
        }
      };
    return DomainMappingsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages domains serving an application.
   * </pre>
   */
  public static abstract class DomainMappingsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the domain mappings on an application.
     * </pre>
     */
    public void listDomainMappings(com.google.appengine.v1.ListDomainMappingsRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListDomainMappingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDomainMappingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the specified domain mapping.
     * </pre>
     */
    public void getDomainMapping(com.google.appengine.v1.GetDomainMappingRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.DomainMapping> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDomainMappingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Maps a domain to an application. A user must be authorized to administer a
     * domain in order to map it to an application. For a list of available
     * authorized domains, see [`AuthorizedDomains.ListAuthorizedDomains`]().
     * </pre>
     */
    public void createDomainMapping(com.google.appengine.v1.CreateDomainMappingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDomainMappingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified domain mapping. To map an SSL certificate to a
     * domain mapping, update `certificate_id` to point to an `AuthorizedCertificate`
     * resource. A user must be authorized to administer the associated domain
     * in order to update a `DomainMapping` resource.
     * </pre>
     */
    public void updateDomainMapping(com.google.appengine.v1.UpdateDomainMappingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateDomainMappingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified domain mapping. A user must be authorized to
     * administer the associated domain in order to delete a `DomainMapping`
     * resource.
     * </pre>
     */
    public void deleteDomainMapping(com.google.appengine.v1.DeleteDomainMappingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDomainMappingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListDomainMappingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.ListDomainMappingsRequest,
                com.google.appengine.v1.ListDomainMappingsResponse>(
                  this, METHODID_LIST_DOMAIN_MAPPINGS)))
          .addMethod(
            getGetDomainMappingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.GetDomainMappingRequest,
                com.google.appengine.v1.DomainMapping>(
                  this, METHODID_GET_DOMAIN_MAPPING)))
          .addMethod(
            getCreateDomainMappingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.CreateDomainMappingRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_DOMAIN_MAPPING)))
          .addMethod(
            getUpdateDomainMappingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.UpdateDomainMappingRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_DOMAIN_MAPPING)))
          .addMethod(
            getDeleteDomainMappingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.DeleteDomainMappingRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_DOMAIN_MAPPING)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages domains serving an application.
   * </pre>
   */
  public static final class DomainMappingsStub extends io.grpc.stub.AbstractAsyncStub<DomainMappingsStub> {
    private DomainMappingsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DomainMappingsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DomainMappingsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the domain mappings on an application.
     * </pre>
     */
    public void listDomainMappings(com.google.appengine.v1.ListDomainMappingsRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListDomainMappingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDomainMappingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the specified domain mapping.
     * </pre>
     */
    public void getDomainMapping(com.google.appengine.v1.GetDomainMappingRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.DomainMapping> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDomainMappingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Maps a domain to an application. A user must be authorized to administer a
     * domain in order to map it to an application. For a list of available
     * authorized domains, see [`AuthorizedDomains.ListAuthorizedDomains`]().
     * </pre>
     */
    public void createDomainMapping(com.google.appengine.v1.CreateDomainMappingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDomainMappingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified domain mapping. To map an SSL certificate to a
     * domain mapping, update `certificate_id` to point to an `AuthorizedCertificate`
     * resource. A user must be authorized to administer the associated domain
     * in order to update a `DomainMapping` resource.
     * </pre>
     */
    public void updateDomainMapping(com.google.appengine.v1.UpdateDomainMappingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDomainMappingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified domain mapping. A user must be authorized to
     * administer the associated domain in order to delete a `DomainMapping`
     * resource.
     * </pre>
     */
    public void deleteDomainMapping(com.google.appengine.v1.DeleteDomainMappingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDomainMappingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages domains serving an application.
   * </pre>
   */
  public static final class DomainMappingsBlockingStub extends io.grpc.stub.AbstractBlockingStub<DomainMappingsBlockingStub> {
    private DomainMappingsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DomainMappingsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DomainMappingsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the domain mappings on an application.
     * </pre>
     */
    public com.google.appengine.v1.ListDomainMappingsResponse listDomainMappings(com.google.appengine.v1.ListDomainMappingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDomainMappingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the specified domain mapping.
     * </pre>
     */
    public com.google.appengine.v1.DomainMapping getDomainMapping(com.google.appengine.v1.GetDomainMappingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDomainMappingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Maps a domain to an application. A user must be authorized to administer a
     * domain in order to map it to an application. For a list of available
     * authorized domains, see [`AuthorizedDomains.ListAuthorizedDomains`]().
     * </pre>
     */
    public com.google.longrunning.Operation createDomainMapping(com.google.appengine.v1.CreateDomainMappingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDomainMappingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified domain mapping. To map an SSL certificate to a
     * domain mapping, update `certificate_id` to point to an `AuthorizedCertificate`
     * resource. A user must be authorized to administer the associated domain
     * in order to update a `DomainMapping` resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateDomainMapping(com.google.appengine.v1.UpdateDomainMappingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDomainMappingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified domain mapping. A user must be authorized to
     * administer the associated domain in order to delete a `DomainMapping`
     * resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDomainMapping(com.google.appengine.v1.DeleteDomainMappingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDomainMappingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages domains serving an application.
   * </pre>
   */
  public static final class DomainMappingsFutureStub extends io.grpc.stub.AbstractFutureStub<DomainMappingsFutureStub> {
    private DomainMappingsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DomainMappingsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DomainMappingsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the domain mappings on an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.ListDomainMappingsResponse> listDomainMappings(
        com.google.appengine.v1.ListDomainMappingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDomainMappingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the specified domain mapping.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.DomainMapping> getDomainMapping(
        com.google.appengine.v1.GetDomainMappingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDomainMappingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Maps a domain to an application. A user must be authorized to administer a
     * domain in order to map it to an application. For a list of available
     * authorized domains, see [`AuthorizedDomains.ListAuthorizedDomains`]().
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createDomainMapping(
        com.google.appengine.v1.CreateDomainMappingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDomainMappingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified domain mapping. To map an SSL certificate to a
     * domain mapping, update `certificate_id` to point to an `AuthorizedCertificate`
     * resource. A user must be authorized to administer the associated domain
     * in order to update a `DomainMapping` resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateDomainMapping(
        com.google.appengine.v1.UpdateDomainMappingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDomainMappingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified domain mapping. A user must be authorized to
     * administer the associated domain in order to delete a `DomainMapping`
     * resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteDomainMapping(
        com.google.appengine.v1.DeleteDomainMappingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDomainMappingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DOMAIN_MAPPINGS = 0;
  private static final int METHODID_GET_DOMAIN_MAPPING = 1;
  private static final int METHODID_CREATE_DOMAIN_MAPPING = 2;
  private static final int METHODID_UPDATE_DOMAIN_MAPPING = 3;
  private static final int METHODID_DELETE_DOMAIN_MAPPING = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DomainMappingsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DomainMappingsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_DOMAIN_MAPPINGS:
          serviceImpl.listDomainMappings((com.google.appengine.v1.ListDomainMappingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.ListDomainMappingsResponse>) responseObserver);
          break;
        case METHODID_GET_DOMAIN_MAPPING:
          serviceImpl.getDomainMapping((com.google.appengine.v1.GetDomainMappingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.DomainMapping>) responseObserver);
          break;
        case METHODID_CREATE_DOMAIN_MAPPING:
          serviceImpl.createDomainMapping((com.google.appengine.v1.CreateDomainMappingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DOMAIN_MAPPING:
          serviceImpl.updateDomainMapping((com.google.appengine.v1.UpdateDomainMappingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DOMAIN_MAPPING:
          serviceImpl.deleteDomainMapping((com.google.appengine.v1.DeleteDomainMappingRequest) request,
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

  private static abstract class DomainMappingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DomainMappingsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.appengine.v1.AppengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DomainMappings");
    }
  }

  private static final class DomainMappingsFileDescriptorSupplier
      extends DomainMappingsBaseDescriptorSupplier {
    DomainMappingsFileDescriptorSupplier() {}
  }

  private static final class DomainMappingsMethodDescriptorSupplier
      extends DomainMappingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DomainMappingsMethodDescriptorSupplier(String methodName) {
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
      synchronized (DomainMappingsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DomainMappingsFileDescriptorSupplier())
              .addMethod(getListDomainMappingsMethod())
              .addMethod(getGetDomainMappingMethod())
              .addMethod(getCreateDomainMappingMethod())
              .addMethod(getUpdateDomainMappingMethod())
              .addMethod(getDeleteDomainMappingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
