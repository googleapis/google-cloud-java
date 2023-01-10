package com.google.cloud.metastore.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Configures and manages metastore federation services.
 * Dataproc Metastore Federation Service allows federating a collection of
 * backend metastores like BigQuery, Dataplex Lakes, and other Dataproc
 * Metastores. The Federation Service exposes a gRPC URL through which metadata
 * from the backend metastores are served at query time.
 * The Dataproc Metastore Federation API defines the following resource model:
 * * The service works with a collection of Google Cloud projects.
 * * Each project has a collection of available locations.
 * * Each location has a collection of federations.
 * * Dataproc Metastore Federations are resources with names of the
 * form:
 * `projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/metastore/v1/metastore_federation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataprocMetastoreFederationGrpc {

  private DataprocMetastoreFederationGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.metastore.v1.DataprocMetastoreFederation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.ListFederationsRequest,
      com.google.cloud.metastore.v1.ListFederationsResponse> getListFederationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFederations",
      requestType = com.google.cloud.metastore.v1.ListFederationsRequest.class,
      responseType = com.google.cloud.metastore.v1.ListFederationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.ListFederationsRequest,
      com.google.cloud.metastore.v1.ListFederationsResponse> getListFederationsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.ListFederationsRequest, com.google.cloud.metastore.v1.ListFederationsResponse> getListFederationsMethod;
    if ((getListFederationsMethod = DataprocMetastoreFederationGrpc.getListFederationsMethod) == null) {
      synchronized (DataprocMetastoreFederationGrpc.class) {
        if ((getListFederationsMethod = DataprocMetastoreFederationGrpc.getListFederationsMethod) == null) {
          DataprocMetastoreFederationGrpc.getListFederationsMethod = getListFederationsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.metastore.v1.ListFederationsRequest, com.google.cloud.metastore.v1.ListFederationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFederations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.metastore.v1.ListFederationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.metastore.v1.ListFederationsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataprocMetastoreFederationMethodDescriptorSupplier("ListFederations"))
              .build();
        }
      }
    }
    return getListFederationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.GetFederationRequest,
      com.google.cloud.metastore.v1.Federation> getGetFederationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFederation",
      requestType = com.google.cloud.metastore.v1.GetFederationRequest.class,
      responseType = com.google.cloud.metastore.v1.Federation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.GetFederationRequest,
      com.google.cloud.metastore.v1.Federation> getGetFederationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.GetFederationRequest, com.google.cloud.metastore.v1.Federation> getGetFederationMethod;
    if ((getGetFederationMethod = DataprocMetastoreFederationGrpc.getGetFederationMethod) == null) {
      synchronized (DataprocMetastoreFederationGrpc.class) {
        if ((getGetFederationMethod = DataprocMetastoreFederationGrpc.getGetFederationMethod) == null) {
          DataprocMetastoreFederationGrpc.getGetFederationMethod = getGetFederationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.metastore.v1.GetFederationRequest, com.google.cloud.metastore.v1.Federation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFederation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.metastore.v1.GetFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.metastore.v1.Federation.getDefaultInstance()))
              .setSchemaDescriptor(new DataprocMetastoreFederationMethodDescriptorSupplier("GetFederation"))
              .build();
        }
      }
    }
    return getGetFederationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.CreateFederationRequest,
      com.google.longrunning.Operation> getCreateFederationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFederation",
      requestType = com.google.cloud.metastore.v1.CreateFederationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.CreateFederationRequest,
      com.google.longrunning.Operation> getCreateFederationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.CreateFederationRequest, com.google.longrunning.Operation> getCreateFederationMethod;
    if ((getCreateFederationMethod = DataprocMetastoreFederationGrpc.getCreateFederationMethod) == null) {
      synchronized (DataprocMetastoreFederationGrpc.class) {
        if ((getCreateFederationMethod = DataprocMetastoreFederationGrpc.getCreateFederationMethod) == null) {
          DataprocMetastoreFederationGrpc.getCreateFederationMethod = getCreateFederationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.metastore.v1.CreateFederationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFederation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.metastore.v1.CreateFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataprocMetastoreFederationMethodDescriptorSupplier("CreateFederation"))
              .build();
        }
      }
    }
    return getCreateFederationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.UpdateFederationRequest,
      com.google.longrunning.Operation> getUpdateFederationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFederation",
      requestType = com.google.cloud.metastore.v1.UpdateFederationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.UpdateFederationRequest,
      com.google.longrunning.Operation> getUpdateFederationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.UpdateFederationRequest, com.google.longrunning.Operation> getUpdateFederationMethod;
    if ((getUpdateFederationMethod = DataprocMetastoreFederationGrpc.getUpdateFederationMethod) == null) {
      synchronized (DataprocMetastoreFederationGrpc.class) {
        if ((getUpdateFederationMethod = DataprocMetastoreFederationGrpc.getUpdateFederationMethod) == null) {
          DataprocMetastoreFederationGrpc.getUpdateFederationMethod = getUpdateFederationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.metastore.v1.UpdateFederationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFederation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.metastore.v1.UpdateFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataprocMetastoreFederationMethodDescriptorSupplier("UpdateFederation"))
              .build();
        }
      }
    }
    return getUpdateFederationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.DeleteFederationRequest,
      com.google.longrunning.Operation> getDeleteFederationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFederation",
      requestType = com.google.cloud.metastore.v1.DeleteFederationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.DeleteFederationRequest,
      com.google.longrunning.Operation> getDeleteFederationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.metastore.v1.DeleteFederationRequest, com.google.longrunning.Operation> getDeleteFederationMethod;
    if ((getDeleteFederationMethod = DataprocMetastoreFederationGrpc.getDeleteFederationMethod) == null) {
      synchronized (DataprocMetastoreFederationGrpc.class) {
        if ((getDeleteFederationMethod = DataprocMetastoreFederationGrpc.getDeleteFederationMethod) == null) {
          DataprocMetastoreFederationGrpc.getDeleteFederationMethod = getDeleteFederationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.metastore.v1.DeleteFederationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFederation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.metastore.v1.DeleteFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataprocMetastoreFederationMethodDescriptorSupplier("DeleteFederation"))
              .build();
        }
      }
    }
    return getDeleteFederationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataprocMetastoreFederationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreFederationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreFederationStub>() {
        @java.lang.Override
        public DataprocMetastoreFederationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataprocMetastoreFederationStub(channel, callOptions);
        }
      };
    return DataprocMetastoreFederationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataprocMetastoreFederationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreFederationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreFederationBlockingStub>() {
        @java.lang.Override
        public DataprocMetastoreFederationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataprocMetastoreFederationBlockingStub(channel, callOptions);
        }
      };
    return DataprocMetastoreFederationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataprocMetastoreFederationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreFederationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreFederationFutureStub>() {
        @java.lang.Override
        public DataprocMetastoreFederationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataprocMetastoreFederationFutureStub(channel, callOptions);
        }
      };
    return DataprocMetastoreFederationFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Configures and manages metastore federation services.
   * Dataproc Metastore Federation Service allows federating a collection of
   * backend metastores like BigQuery, Dataplex Lakes, and other Dataproc
   * Metastores. The Federation Service exposes a gRPC URL through which metadata
   * from the backend metastores are served at query time.
   * The Dataproc Metastore Federation API defines the following resource model:
   * * The service works with a collection of Google Cloud projects.
   * * Each project has a collection of available locations.
   * * Each location has a collection of federations.
   * * Dataproc Metastore Federations are resources with names of the
   * form:
   * `projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
   * </pre>
   */
  public static abstract class DataprocMetastoreFederationImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists federations in a project and location.
     * </pre>
     */
    public void listFederations(com.google.cloud.metastore.v1.ListFederationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1.ListFederationsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFederationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a single federation.
     * </pre>
     */
    public void getFederation(com.google.cloud.metastore.v1.GetFederationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1.Federation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFederationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a metastore federation in a project and location.
     * </pre>
     */
    public void createFederation(com.google.cloud.metastore.v1.CreateFederationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFederationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the fields of a federation.
     * </pre>
     */
    public void updateFederation(com.google.cloud.metastore.v1.UpdateFederationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFederationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single federation.
     * </pre>
     */
    public void deleteFederation(com.google.cloud.metastore.v1.DeleteFederationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFederationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListFederationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.metastore.v1.ListFederationsRequest,
                com.google.cloud.metastore.v1.ListFederationsResponse>(
                  this, METHODID_LIST_FEDERATIONS)))
          .addMethod(
            getGetFederationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.metastore.v1.GetFederationRequest,
                com.google.cloud.metastore.v1.Federation>(
                  this, METHODID_GET_FEDERATION)))
          .addMethod(
            getCreateFederationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.metastore.v1.CreateFederationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_FEDERATION)))
          .addMethod(
            getUpdateFederationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.metastore.v1.UpdateFederationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_FEDERATION)))
          .addMethod(
            getDeleteFederationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.metastore.v1.DeleteFederationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_FEDERATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Configures and manages metastore federation services.
   * Dataproc Metastore Federation Service allows federating a collection of
   * backend metastores like BigQuery, Dataplex Lakes, and other Dataproc
   * Metastores. The Federation Service exposes a gRPC URL through which metadata
   * from the backend metastores are served at query time.
   * The Dataproc Metastore Federation API defines the following resource model:
   * * The service works with a collection of Google Cloud projects.
   * * Each project has a collection of available locations.
   * * Each location has a collection of federations.
   * * Dataproc Metastore Federations are resources with names of the
   * form:
   * `projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
   * </pre>
   */
  public static final class DataprocMetastoreFederationStub extends io.grpc.stub.AbstractAsyncStub<DataprocMetastoreFederationStub> {
    private DataprocMetastoreFederationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataprocMetastoreFederationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataprocMetastoreFederationStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists federations in a project and location.
     * </pre>
     */
    public void listFederations(com.google.cloud.metastore.v1.ListFederationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1.ListFederationsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFederationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a single federation.
     * </pre>
     */
    public void getFederation(com.google.cloud.metastore.v1.GetFederationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1.Federation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFederationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a metastore federation in a project and location.
     * </pre>
     */
    public void createFederation(com.google.cloud.metastore.v1.CreateFederationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFederationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the fields of a federation.
     * </pre>
     */
    public void updateFederation(com.google.cloud.metastore.v1.UpdateFederationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFederationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single federation.
     * </pre>
     */
    public void deleteFederation(com.google.cloud.metastore.v1.DeleteFederationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFederationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Configures and manages metastore federation services.
   * Dataproc Metastore Federation Service allows federating a collection of
   * backend metastores like BigQuery, Dataplex Lakes, and other Dataproc
   * Metastores. The Federation Service exposes a gRPC URL through which metadata
   * from the backend metastores are served at query time.
   * The Dataproc Metastore Federation API defines the following resource model:
   * * The service works with a collection of Google Cloud projects.
   * * Each project has a collection of available locations.
   * * Each location has a collection of federations.
   * * Dataproc Metastore Federations are resources with names of the
   * form:
   * `projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
   * </pre>
   */
  public static final class DataprocMetastoreFederationBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataprocMetastoreFederationBlockingStub> {
    private DataprocMetastoreFederationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataprocMetastoreFederationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataprocMetastoreFederationBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists federations in a project and location.
     * </pre>
     */
    public com.google.cloud.metastore.v1.ListFederationsResponse listFederations(com.google.cloud.metastore.v1.ListFederationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFederationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a single federation.
     * </pre>
     */
    public com.google.cloud.metastore.v1.Federation getFederation(com.google.cloud.metastore.v1.GetFederationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFederationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a metastore federation in a project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFederation(com.google.cloud.metastore.v1.CreateFederationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFederationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the fields of a federation.
     * </pre>
     */
    public com.google.longrunning.Operation updateFederation(com.google.cloud.metastore.v1.UpdateFederationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFederationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single federation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFederation(com.google.cloud.metastore.v1.DeleteFederationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFederationMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Configures and manages metastore federation services.
   * Dataproc Metastore Federation Service allows federating a collection of
   * backend metastores like BigQuery, Dataplex Lakes, and other Dataproc
   * Metastores. The Federation Service exposes a gRPC URL through which metadata
   * from the backend metastores are served at query time.
   * The Dataproc Metastore Federation API defines the following resource model:
   * * The service works with a collection of Google Cloud projects.
   * * Each project has a collection of available locations.
   * * Each location has a collection of federations.
   * * Dataproc Metastore Federations are resources with names of the
   * form:
   * `projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
   * </pre>
   */
  public static final class DataprocMetastoreFederationFutureStub extends io.grpc.stub.AbstractFutureStub<DataprocMetastoreFederationFutureStub> {
    private DataprocMetastoreFederationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataprocMetastoreFederationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataprocMetastoreFederationFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists federations in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.metastore.v1.ListFederationsResponse> listFederations(
        com.google.cloud.metastore.v1.ListFederationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFederationsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a single federation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.metastore.v1.Federation> getFederation(
        com.google.cloud.metastore.v1.GetFederationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFederationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a metastore federation in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createFederation(
        com.google.cloud.metastore.v1.CreateFederationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFederationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the fields of a federation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateFederation(
        com.google.cloud.metastore.v1.UpdateFederationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFederationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single federation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteFederation(
        com.google.cloud.metastore.v1.DeleteFederationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFederationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_FEDERATIONS = 0;
  private static final int METHODID_GET_FEDERATION = 1;
  private static final int METHODID_CREATE_FEDERATION = 2;
  private static final int METHODID_UPDATE_FEDERATION = 3;
  private static final int METHODID_DELETE_FEDERATION = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataprocMetastoreFederationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataprocMetastoreFederationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_FEDERATIONS:
          serviceImpl.listFederations((com.google.cloud.metastore.v1.ListFederationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1.ListFederationsResponse>) responseObserver);
          break;
        case METHODID_GET_FEDERATION:
          serviceImpl.getFederation((com.google.cloud.metastore.v1.GetFederationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1.Federation>) responseObserver);
          break;
        case METHODID_CREATE_FEDERATION:
          serviceImpl.createFederation((com.google.cloud.metastore.v1.CreateFederationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FEDERATION:
          serviceImpl.updateFederation((com.google.cloud.metastore.v1.UpdateFederationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEDERATION:
          serviceImpl.deleteFederation((com.google.cloud.metastore.v1.DeleteFederationRequest) request,
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

  private static abstract class DataprocMetastoreFederationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataprocMetastoreFederationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.metastore.v1.MetastoreFederationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataprocMetastoreFederation");
    }
  }

  private static final class DataprocMetastoreFederationFileDescriptorSupplier
      extends DataprocMetastoreFederationBaseDescriptorSupplier {
    DataprocMetastoreFederationFileDescriptorSupplier() {}
  }

  private static final class DataprocMetastoreFederationMethodDescriptorSupplier
      extends DataprocMetastoreFederationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataprocMetastoreFederationMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataprocMetastoreFederationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataprocMetastoreFederationFileDescriptorSupplier())
              .addMethod(getListFederationsMethod())
              .addMethod(getGetFederationMethod())
              .addMethod(getCreateFederationMethod())
              .addMethod(getUpdateFederationMethod())
              .addMethod(getDeleteFederationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
