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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s,
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/sample_query_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SampleQueryServiceGrpc {

  private SampleQueryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.SampleQueryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest,
          com.google.cloud.discoveryengine.v1beta.SampleQuery>
      getGetSampleQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSampleQuery",
      requestType = com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.SampleQuery.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest,
          com.google.cloud.discoveryengine.v1beta.SampleQuery>
      getGetSampleQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest,
            com.google.cloud.discoveryengine.v1beta.SampleQuery>
        getGetSampleQueryMethod;
    if ((getGetSampleQueryMethod = SampleQueryServiceGrpc.getGetSampleQueryMethod) == null) {
      synchronized (SampleQueryServiceGrpc.class) {
        if ((getGetSampleQueryMethod = SampleQueryServiceGrpc.getGetSampleQueryMethod) == null) {
          SampleQueryServiceGrpc.getGetSampleQueryMethod =
              getGetSampleQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest,
                          com.google.cloud.discoveryengine.v1beta.SampleQuery>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSampleQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.SampleQuery
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQueryServiceMethodDescriptorSupplier("GetSampleQuery"))
                      .build();
        }
      }
    }
    return getGetSampleQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest,
          com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>
      getListSampleQueriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSampleQueries",
      requestType = com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest,
          com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>
      getListSampleQueriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest,
            com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>
        getListSampleQueriesMethod;
    if ((getListSampleQueriesMethod = SampleQueryServiceGrpc.getListSampleQueriesMethod) == null) {
      synchronized (SampleQueryServiceGrpc.class) {
        if ((getListSampleQueriesMethod = SampleQueryServiceGrpc.getListSampleQueriesMethod)
            == null) {
          SampleQueryServiceGrpc.getListSampleQueriesMethod =
              getListSampleQueriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest,
                          com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSampleQueries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQueryServiceMethodDescriptorSupplier("ListSampleQueries"))
                      .build();
        }
      }
    }
    return getListSampleQueriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest,
          com.google.cloud.discoveryengine.v1beta.SampleQuery>
      getCreateSampleQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSampleQuery",
      requestType = com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.SampleQuery.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest,
          com.google.cloud.discoveryengine.v1beta.SampleQuery>
      getCreateSampleQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest,
            com.google.cloud.discoveryengine.v1beta.SampleQuery>
        getCreateSampleQueryMethod;
    if ((getCreateSampleQueryMethod = SampleQueryServiceGrpc.getCreateSampleQueryMethod) == null) {
      synchronized (SampleQueryServiceGrpc.class) {
        if ((getCreateSampleQueryMethod = SampleQueryServiceGrpc.getCreateSampleQueryMethod)
            == null) {
          SampleQueryServiceGrpc.getCreateSampleQueryMethod =
              getCreateSampleQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest,
                          com.google.cloud.discoveryengine.v1beta.SampleQuery>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSampleQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.SampleQuery
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQueryServiceMethodDescriptorSupplier("CreateSampleQuery"))
                      .build();
        }
      }
    }
    return getCreateSampleQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest,
          com.google.cloud.discoveryengine.v1beta.SampleQuery>
      getUpdateSampleQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSampleQuery",
      requestType = com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.SampleQuery.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest,
          com.google.cloud.discoveryengine.v1beta.SampleQuery>
      getUpdateSampleQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest,
            com.google.cloud.discoveryengine.v1beta.SampleQuery>
        getUpdateSampleQueryMethod;
    if ((getUpdateSampleQueryMethod = SampleQueryServiceGrpc.getUpdateSampleQueryMethod) == null) {
      synchronized (SampleQueryServiceGrpc.class) {
        if ((getUpdateSampleQueryMethod = SampleQueryServiceGrpc.getUpdateSampleQueryMethod)
            == null) {
          SampleQueryServiceGrpc.getUpdateSampleQueryMethod =
              getUpdateSampleQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest,
                          com.google.cloud.discoveryengine.v1beta.SampleQuery>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSampleQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.SampleQuery
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQueryServiceMethodDescriptorSupplier("UpdateSampleQuery"))
                      .build();
        }
      }
    }
    return getUpdateSampleQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest,
          com.google.protobuf.Empty>
      getDeleteSampleQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSampleQuery",
      requestType = com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest,
          com.google.protobuf.Empty>
      getDeleteSampleQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest,
            com.google.protobuf.Empty>
        getDeleteSampleQueryMethod;
    if ((getDeleteSampleQueryMethod = SampleQueryServiceGrpc.getDeleteSampleQueryMethod) == null) {
      synchronized (SampleQueryServiceGrpc.class) {
        if ((getDeleteSampleQueryMethod = SampleQueryServiceGrpc.getDeleteSampleQueryMethod)
            == null) {
          SampleQueryServiceGrpc.getDeleteSampleQueryMethod =
              getDeleteSampleQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSampleQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQueryServiceMethodDescriptorSupplier("DeleteSampleQuery"))
                      .build();
        }
      }
    }
    return getDeleteSampleQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest,
          com.google.longrunning.Operation>
      getImportSampleQueriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportSampleQueries",
      requestType = com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest,
          com.google.longrunning.Operation>
      getImportSampleQueriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest,
            com.google.longrunning.Operation>
        getImportSampleQueriesMethod;
    if ((getImportSampleQueriesMethod = SampleQueryServiceGrpc.getImportSampleQueriesMethod)
        == null) {
      synchronized (SampleQueryServiceGrpc.class) {
        if ((getImportSampleQueriesMethod = SampleQueryServiceGrpc.getImportSampleQueriesMethod)
            == null) {
          SampleQueryServiceGrpc.getImportSampleQueriesMethod =
              getImportSampleQueriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportSampleQueries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SampleQueryServiceMethodDescriptorSupplier("ImportSampleQueries"))
                      .build();
        }
      }
    }
    return getImportSampleQueriesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SampleQueryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleQueryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SampleQueryServiceStub>() {
          @java.lang.Override
          public SampleQueryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SampleQueryServiceStub(channel, callOptions);
          }
        };
    return SampleQueryServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SampleQueryServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleQueryServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SampleQueryServiceBlockingV2Stub>() {
          @java.lang.Override
          public SampleQueryServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SampleQueryServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SampleQueryServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SampleQueryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleQueryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SampleQueryServiceBlockingStub>() {
          @java.lang.Override
          public SampleQueryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SampleQueryServiceBlockingStub(channel, callOptions);
          }
        };
    return SampleQueryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SampleQueryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleQueryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SampleQueryServiceFutureStub>() {
          @java.lang.Override
          public SampleQueryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SampleQueryServiceFutureStub(channel, callOptions);
          }
        };
    return SampleQueryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s,
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    default void getSampleQuery(
        com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSampleQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s.
     * </pre>
     */
    default void listSampleQueries(
        com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSampleQueriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]
     * </pre>
     */
    default void createSampleQuery(
        com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSampleQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    default void updateSampleQuery(
        com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSampleQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    default void deleteSampleQuery(
        com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSampleQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s. Sample
     * queries that already exist may be deleted.
     * Note: It is possible for a subset of the
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s to be
     * successfully imported.
     * </pre>
     */
    default void importSampleQueries(
        com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportSampleQueriesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SampleQueryService.
   *
   * <pre>
   * Service for managing
   * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s,
   * </pre>
   */
  public abstract static class SampleQueryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SampleQueryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SampleQueryService.
   *
   * <pre>
   * Service for managing
   * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s,
   * </pre>
   */
  public static final class SampleQueryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SampleQueryServiceStub> {
    private SampleQueryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleQueryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleQueryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public void getSampleQuery(
        com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSampleQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s.
     * </pre>
     */
    public void listSampleQueries(
        com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSampleQueriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]
     * </pre>
     */
    public void createSampleQuery(
        com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSampleQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public void updateSampleQuery(
        com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSampleQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public void deleteSampleQuery(
        com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSampleQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s. Sample
     * queries that already exist may be deleted.
     * Note: It is possible for a subset of the
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s to be
     * successfully imported.
     * </pre>
     */
    public void importSampleQueries(
        com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportSampleQueriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SampleQueryService.
   *
   * <pre>
   * Service for managing
   * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s,
   * </pre>
   */
  public static final class SampleQueryServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SampleQueryServiceBlockingV2Stub> {
    private SampleQueryServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleQueryServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleQueryServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.SampleQuery getSampleQuery(
        com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSampleQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse listSampleQueries(
        com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSampleQueriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.SampleQuery createSampleQuery(
        com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSampleQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.SampleQuery updateSampleQuery(
        com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSampleQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.protobuf.Empty deleteSampleQuery(
        com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSampleQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s. Sample
     * queries that already exist may be deleted.
     * Note: It is possible for a subset of the
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s to be
     * successfully imported.
     * </pre>
     */
    public com.google.longrunning.Operation importSampleQueries(
        com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportSampleQueriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SampleQueryService.
   *
   * <pre>
   * Service for managing
   * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s,
   * </pre>
   */
  public static final class SampleQueryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SampleQueryServiceBlockingStub> {
    private SampleQueryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleQueryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleQueryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.SampleQuery getSampleQuery(
        com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSampleQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse listSampleQueries(
        com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSampleQueriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.SampleQuery createSampleQuery(
        com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSampleQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.SampleQuery updateSampleQuery(
        com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSampleQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.protobuf.Empty deleteSampleQuery(
        com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSampleQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s. Sample
     * queries that already exist may be deleted.
     * Note: It is possible for a subset of the
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s to be
     * successfully imported.
     * </pre>
     */
    public com.google.longrunning.Operation importSampleQueries(
        com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportSampleQueriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SampleQueryService.
   *
   * <pre>
   * Service for managing
   * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s,
   * </pre>
   */
  public static final class SampleQueryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SampleQueryServiceFutureStub> {
    private SampleQueryServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleQueryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleQueryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.SampleQuery>
        getSampleQuery(com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSampleQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>
        listSampleQueries(
            com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSampleQueriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.SampleQuery>
        createSampleQuery(
            com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSampleQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.SampleQuery>
        updateSampleQuery(
            com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSampleQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSampleQuery(
            com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSampleQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s. Sample
     * queries that already exist may be deleted.
     * Note: It is possible for a subset of the
     * [SampleQuery][google.cloud.discoveryengine.v1beta.SampleQuery]s to be
     * successfully imported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importSampleQueries(
            com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportSampleQueriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SAMPLE_QUERY = 0;
  private static final int METHODID_LIST_SAMPLE_QUERIES = 1;
  private static final int METHODID_CREATE_SAMPLE_QUERY = 2;
  private static final int METHODID_UPDATE_SAMPLE_QUERY = 3;
  private static final int METHODID_DELETE_SAMPLE_QUERY = 4;
  private static final int METHODID_IMPORT_SAMPLE_QUERIES = 5;

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
        case METHODID_GET_SAMPLE_QUERY:
          serviceImpl.getSampleQuery(
              (com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>)
                  responseObserver);
          break;
        case METHODID_LIST_SAMPLE_QUERIES:
          serviceImpl.listSampleQueries(
              (com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SAMPLE_QUERY:
          serviceImpl.createSampleQuery(
              (com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SAMPLE_QUERY:
          serviceImpl.updateSampleQuery(
              (com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SampleQuery>)
                  responseObserver);
          break;
        case METHODID_DELETE_SAMPLE_QUERY:
          serviceImpl.deleteSampleQuery(
              (com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_IMPORT_SAMPLE_QUERIES:
          serviceImpl.importSampleQueries(
              (com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getGetSampleQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest,
                    com.google.cloud.discoveryengine.v1beta.SampleQuery>(
                    service, METHODID_GET_SAMPLE_QUERY)))
        .addMethod(
            getListSampleQueriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest,
                    com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse>(
                    service, METHODID_LIST_SAMPLE_QUERIES)))
        .addMethod(
            getCreateSampleQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest,
                    com.google.cloud.discoveryengine.v1beta.SampleQuery>(
                    service, METHODID_CREATE_SAMPLE_QUERY)))
        .addMethod(
            getUpdateSampleQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest,
                    com.google.cloud.discoveryengine.v1beta.SampleQuery>(
                    service, METHODID_UPDATE_SAMPLE_QUERY)))
        .addMethod(
            getDeleteSampleQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SAMPLE_QUERY)))
        .addMethod(
            getImportSampleQueriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_SAMPLE_QUERIES)))
        .build();
  }

  private abstract static class SampleQueryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SampleQueryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.SampleQueryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SampleQueryService");
    }
  }

  private static final class SampleQueryServiceFileDescriptorSupplier
      extends SampleQueryServiceBaseDescriptorSupplier {
    SampleQueryServiceFileDescriptorSupplier() {}
  }

  private static final class SampleQueryServiceMethodDescriptorSupplier
      extends SampleQueryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SampleQueryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SampleQueryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SampleQueryServiceFileDescriptorSupplier())
                      .addMethod(getGetSampleQueryMethod())
                      .addMethod(getListSampleQueriesMethod())
                      .addMethod(getCreateSampleQueryMethod())
                      .addMethod(getUpdateSampleQueryMethod())
                      .addMethod(getDeleteSampleQueryMethod())
                      .addMethod(getImportSampleQueriesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
