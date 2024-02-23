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
package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * DataScanService manages DataScan resources which can be configured to run
 * various types of data scanning workload and generate enriched metadata (e.g.
 * Data Profile, Data Quality) for the data source.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/datascans.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataScanServiceGrpc {

  private DataScanServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dataplex.v1.DataScanService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataScanRequest, com.google.longrunning.Operation>
      getCreateDataScanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataScan",
      requestType = com.google.cloud.dataplex.v1.CreateDataScanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataScanRequest, com.google.longrunning.Operation>
      getCreateDataScanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateDataScanRequest, com.google.longrunning.Operation>
        getCreateDataScanMethod;
    if ((getCreateDataScanMethod = DataScanServiceGrpc.getCreateDataScanMethod) == null) {
      synchronized (DataScanServiceGrpc.class) {
        if ((getCreateDataScanMethod = DataScanServiceGrpc.getCreateDataScanMethod) == null) {
          DataScanServiceGrpc.getCreateDataScanMethod =
              getCreateDataScanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateDataScanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataScan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateDataScanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataScanServiceMethodDescriptorSupplier("CreateDataScan"))
                      .build();
        }
      }
    }
    return getCreateDataScanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataScanRequest, com.google.longrunning.Operation>
      getUpdateDataScanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataScan",
      requestType = com.google.cloud.dataplex.v1.UpdateDataScanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataScanRequest, com.google.longrunning.Operation>
      getUpdateDataScanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateDataScanRequest, com.google.longrunning.Operation>
        getUpdateDataScanMethod;
    if ((getUpdateDataScanMethod = DataScanServiceGrpc.getUpdateDataScanMethod) == null) {
      synchronized (DataScanServiceGrpc.class) {
        if ((getUpdateDataScanMethod = DataScanServiceGrpc.getUpdateDataScanMethod) == null) {
          DataScanServiceGrpc.getUpdateDataScanMethod =
              getUpdateDataScanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateDataScanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataScan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateDataScanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataScanServiceMethodDescriptorSupplier("UpdateDataScan"))
                      .build();
        }
      }
    }
    return getUpdateDataScanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataScanRequest, com.google.longrunning.Operation>
      getDeleteDataScanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataScan",
      requestType = com.google.cloud.dataplex.v1.DeleteDataScanRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataScanRequest, com.google.longrunning.Operation>
      getDeleteDataScanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteDataScanRequest, com.google.longrunning.Operation>
        getDeleteDataScanMethod;
    if ((getDeleteDataScanMethod = DataScanServiceGrpc.getDeleteDataScanMethod) == null) {
      synchronized (DataScanServiceGrpc.class) {
        if ((getDeleteDataScanMethod = DataScanServiceGrpc.getDeleteDataScanMethod) == null) {
          DataScanServiceGrpc.getDeleteDataScanMethod =
              getDeleteDataScanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteDataScanRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataScan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteDataScanRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataScanServiceMethodDescriptorSupplier("DeleteDataScan"))
                      .build();
        }
      }
    }
    return getDeleteDataScanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataScanRequest, com.google.cloud.dataplex.v1.DataScan>
      getGetDataScanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataScan",
      requestType = com.google.cloud.dataplex.v1.GetDataScanRequest.class,
      responseType = com.google.cloud.dataplex.v1.DataScan.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataScanRequest, com.google.cloud.dataplex.v1.DataScan>
      getGetDataScanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetDataScanRequest, com.google.cloud.dataplex.v1.DataScan>
        getGetDataScanMethod;
    if ((getGetDataScanMethod = DataScanServiceGrpc.getGetDataScanMethod) == null) {
      synchronized (DataScanServiceGrpc.class) {
        if ((getGetDataScanMethod = DataScanServiceGrpc.getGetDataScanMethod) == null) {
          DataScanServiceGrpc.getGetDataScanMethod =
              getGetDataScanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetDataScanRequest,
                          com.google.cloud.dataplex.v1.DataScan>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataScan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetDataScanRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DataScan.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataScanServiceMethodDescriptorSupplier("GetDataScan"))
                      .build();
        }
      }
    }
    return getGetDataScanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataScansRequest,
          com.google.cloud.dataplex.v1.ListDataScansResponse>
      getListDataScansMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataScans",
      requestType = com.google.cloud.dataplex.v1.ListDataScansRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListDataScansResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataScansRequest,
          com.google.cloud.dataplex.v1.ListDataScansResponse>
      getListDataScansMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListDataScansRequest,
            com.google.cloud.dataplex.v1.ListDataScansResponse>
        getListDataScansMethod;
    if ((getListDataScansMethod = DataScanServiceGrpc.getListDataScansMethod) == null) {
      synchronized (DataScanServiceGrpc.class) {
        if ((getListDataScansMethod = DataScanServiceGrpc.getListDataScansMethod) == null) {
          DataScanServiceGrpc.getListDataScansMethod =
              getListDataScansMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListDataScansRequest,
                          com.google.cloud.dataplex.v1.ListDataScansResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataScans"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataScansRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataScansResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataScanServiceMethodDescriptorSupplier("ListDataScans"))
                      .build();
        }
      }
    }
    return getListDataScansMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.RunDataScanRequest,
          com.google.cloud.dataplex.v1.RunDataScanResponse>
      getRunDataScanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunDataScan",
      requestType = com.google.cloud.dataplex.v1.RunDataScanRequest.class,
      responseType = com.google.cloud.dataplex.v1.RunDataScanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.RunDataScanRequest,
          com.google.cloud.dataplex.v1.RunDataScanResponse>
      getRunDataScanMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.RunDataScanRequest,
            com.google.cloud.dataplex.v1.RunDataScanResponse>
        getRunDataScanMethod;
    if ((getRunDataScanMethod = DataScanServiceGrpc.getRunDataScanMethod) == null) {
      synchronized (DataScanServiceGrpc.class) {
        if ((getRunDataScanMethod = DataScanServiceGrpc.getRunDataScanMethod) == null) {
          DataScanServiceGrpc.getRunDataScanMethod =
              getRunDataScanMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.RunDataScanRequest,
                          com.google.cloud.dataplex.v1.RunDataScanResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunDataScan"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.RunDataScanRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.RunDataScanResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataScanServiceMethodDescriptorSupplier("RunDataScan"))
                      .build();
        }
      }
    }
    return getRunDataScanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataScanJobRequest,
          com.google.cloud.dataplex.v1.DataScanJob>
      getGetDataScanJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataScanJob",
      requestType = com.google.cloud.dataplex.v1.GetDataScanJobRequest.class,
      responseType = com.google.cloud.dataplex.v1.DataScanJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataScanJobRequest,
          com.google.cloud.dataplex.v1.DataScanJob>
      getGetDataScanJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetDataScanJobRequest,
            com.google.cloud.dataplex.v1.DataScanJob>
        getGetDataScanJobMethod;
    if ((getGetDataScanJobMethod = DataScanServiceGrpc.getGetDataScanJobMethod) == null) {
      synchronized (DataScanServiceGrpc.class) {
        if ((getGetDataScanJobMethod = DataScanServiceGrpc.getGetDataScanJobMethod) == null) {
          DataScanServiceGrpc.getGetDataScanJobMethod =
              getGetDataScanJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetDataScanJobRequest,
                          com.google.cloud.dataplex.v1.DataScanJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataScanJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetDataScanJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DataScanJob.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataScanServiceMethodDescriptorSupplier("GetDataScanJob"))
                      .build();
        }
      }
    }
    return getGetDataScanJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataScanJobsRequest,
          com.google.cloud.dataplex.v1.ListDataScanJobsResponse>
      getListDataScanJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataScanJobs",
      requestType = com.google.cloud.dataplex.v1.ListDataScanJobsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListDataScanJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataScanJobsRequest,
          com.google.cloud.dataplex.v1.ListDataScanJobsResponse>
      getListDataScanJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListDataScanJobsRequest,
            com.google.cloud.dataplex.v1.ListDataScanJobsResponse>
        getListDataScanJobsMethod;
    if ((getListDataScanJobsMethod = DataScanServiceGrpc.getListDataScanJobsMethod) == null) {
      synchronized (DataScanServiceGrpc.class) {
        if ((getListDataScanJobsMethod = DataScanServiceGrpc.getListDataScanJobsMethod) == null) {
          DataScanServiceGrpc.getListDataScanJobsMethod =
              getListDataScanJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListDataScanJobsRequest,
                          com.google.cloud.dataplex.v1.ListDataScanJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataScanJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataScanJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataScanJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataScanServiceMethodDescriptorSupplier("ListDataScanJobs"))
                      .build();
        }
      }
    }
    return getListDataScanJobsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataScanServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataScanServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataScanServiceStub>() {
          @java.lang.Override
          public DataScanServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataScanServiceStub(channel, callOptions);
          }
        };
    return DataScanServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataScanServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataScanServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataScanServiceBlockingStub>() {
          @java.lang.Override
          public DataScanServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataScanServiceBlockingStub(channel, callOptions);
          }
        };
    return DataScanServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataScanServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataScanServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataScanServiceFutureStub>() {
          @java.lang.Override
          public DataScanServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataScanServiceFutureStub(channel, callOptions);
          }
        };
    return DataScanServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * DataScanService manages DataScan resources which can be configured to run
   * various types of data scanning workload and generate enriched metadata (e.g.
   * Data Profile, Data Quality) for the data source.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a DataScan resource.
     * </pre>
     */
    default void createDataScan(
        com.google.cloud.dataplex.v1.CreateDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataScanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataScan resource.
     * </pre>
     */
    default void updateDataScan(
        com.google.cloud.dataplex.v1.UpdateDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataScanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataScan resource.
     * </pre>
     */
    default void deleteDataScan(
        com.google.cloud.dataplex.v1.DeleteDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataScanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataScan resource.
     * </pre>
     */
    default void getDataScan(
        com.google.cloud.dataplex.v1.GetDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataScan> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataScanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataScans.
     * </pre>
     */
    default void listDataScans(
        com.google.cloud.dataplex.v1.ListDataScansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataScansResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataScansMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs an on-demand execution of a DataScan
     * </pre>
     */
    default void runDataScan(
        com.google.cloud.dataplex.v1.RunDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.RunDataScanResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunDataScanMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataScanJob resource.
     * </pre>
     */
    default void getDataScanJob(
        com.google.cloud.dataplex.v1.GetDataScanJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataScanJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataScanJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataScanJobs under the given DataScan.
     * </pre>
     */
    default void listDataScanJobs(
        com.google.cloud.dataplex.v1.ListDataScanJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataScanJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataScanJobsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataScanService.
   *
   * <pre>
   * DataScanService manages DataScan resources which can be configured to run
   * various types of data scanning workload and generate enriched metadata (e.g.
   * Data Profile, Data Quality) for the data source.
   * </pre>
   */
  public abstract static class DataScanServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataScanServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataScanService.
   *
   * <pre>
   * DataScanService manages DataScan resources which can be configured to run
   * various types of data scanning workload and generate enriched metadata (e.g.
   * Data Profile, Data Quality) for the data source.
   * </pre>
   */
  public static final class DataScanServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataScanServiceStub> {
    private DataScanServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataScanServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataScanServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataScan resource.
     * </pre>
     */
    public void createDataScan(
        com.google.cloud.dataplex.v1.CreateDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataScanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataScan resource.
     * </pre>
     */
    public void updateDataScan(
        com.google.cloud.dataplex.v1.UpdateDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataScanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataScan resource.
     * </pre>
     */
    public void deleteDataScan(
        com.google.cloud.dataplex.v1.DeleteDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataScanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataScan resource.
     * </pre>
     */
    public void getDataScan(
        com.google.cloud.dataplex.v1.GetDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataScan> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataScanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataScans.
     * </pre>
     */
    public void listDataScans(
        com.google.cloud.dataplex.v1.ListDataScansRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataScansResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataScansMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs an on-demand execution of a DataScan
     * </pre>
     */
    public void runDataScan(
        com.google.cloud.dataplex.v1.RunDataScanRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.RunDataScanResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunDataScanMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataScanJob resource.
     * </pre>
     */
    public void getDataScanJob(
        com.google.cloud.dataplex.v1.GetDataScanJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataScanJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataScanJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataScanJobs under the given DataScan.
     * </pre>
     */
    public void listDataScanJobs(
        com.google.cloud.dataplex.v1.ListDataScanJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataScanJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataScanJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataScanService.
   *
   * <pre>
   * DataScanService manages DataScan resources which can be configured to run
   * various types of data scanning workload and generate enriched metadata (e.g.
   * Data Profile, Data Quality) for the data source.
   * </pre>
   */
  public static final class DataScanServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataScanServiceBlockingStub> {
    private DataScanServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataScanServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataScanServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataScan resource.
     * </pre>
     */
    public com.google.longrunning.Operation createDataScan(
        com.google.cloud.dataplex.v1.CreateDataScanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataScanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataScan resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataScan(
        com.google.cloud.dataplex.v1.UpdateDataScanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataScanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataScan resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataScan(
        com.google.cloud.dataplex.v1.DeleteDataScanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataScanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataScan resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataScan getDataScan(
        com.google.cloud.dataplex.v1.GetDataScanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataScanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataScans.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataScansResponse listDataScans(
        com.google.cloud.dataplex.v1.ListDataScansRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataScansMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an on-demand execution of a DataScan
     * </pre>
     */
    public com.google.cloud.dataplex.v1.RunDataScanResponse runDataScan(
        com.google.cloud.dataplex.v1.RunDataScanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunDataScanMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataScanJob resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataScanJob getDataScanJob(
        com.google.cloud.dataplex.v1.GetDataScanJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataScanJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataScanJobs under the given DataScan.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataScanJobsResponse listDataScanJobs(
        com.google.cloud.dataplex.v1.ListDataScanJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataScanJobsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataScanService.
   *
   * <pre>
   * DataScanService manages DataScan resources which can be configured to run
   * various types of data scanning workload and generate enriched metadata (e.g.
   * Data Profile, Data Quality) for the data source.
   * </pre>
   */
  public static final class DataScanServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataScanServiceFutureStub> {
    private DataScanServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataScanServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataScanServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a DataScan resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataScan(com.google.cloud.dataplex.v1.CreateDataScanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataScanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataScan resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataScan(com.google.cloud.dataplex.v1.UpdateDataScanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataScanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataScan resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataScan(com.google.cloud.dataplex.v1.DeleteDataScanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataScanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataScan resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.DataScan>
        getDataScan(com.google.cloud.dataplex.v1.GetDataScanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataScanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataScans.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListDataScansResponse>
        listDataScans(com.google.cloud.dataplex.v1.ListDataScansRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataScansMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs an on-demand execution of a DataScan
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.RunDataScanResponse>
        runDataScan(com.google.cloud.dataplex.v1.RunDataScanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunDataScanMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DataScanJob resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.DataScanJob>
        getDataScanJob(com.google.cloud.dataplex.v1.GetDataScanJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataScanJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataScanJobs under the given DataScan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListDataScanJobsResponse>
        listDataScanJobs(com.google.cloud.dataplex.v1.ListDataScanJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataScanJobsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATA_SCAN = 0;
  private static final int METHODID_UPDATE_DATA_SCAN = 1;
  private static final int METHODID_DELETE_DATA_SCAN = 2;
  private static final int METHODID_GET_DATA_SCAN = 3;
  private static final int METHODID_LIST_DATA_SCANS = 4;
  private static final int METHODID_RUN_DATA_SCAN = 5;
  private static final int METHODID_GET_DATA_SCAN_JOB = 6;
  private static final int METHODID_LIST_DATA_SCAN_JOBS = 7;

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
        case METHODID_CREATE_DATA_SCAN:
          serviceImpl.createDataScan(
              (com.google.cloud.dataplex.v1.CreateDataScanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_SCAN:
          serviceImpl.updateDataScan(
              (com.google.cloud.dataplex.v1.UpdateDataScanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATA_SCAN:
          serviceImpl.deleteDataScan(
              (com.google.cloud.dataplex.v1.DeleteDataScanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATA_SCAN:
          serviceImpl.getDataScan(
              (com.google.cloud.dataplex.v1.GetDataScanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataScan>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_SCANS:
          serviceImpl.listDataScans(
              (com.google.cloud.dataplex.v1.ListDataScansRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataScansResponse>)
                  responseObserver);
          break;
        case METHODID_RUN_DATA_SCAN:
          serviceImpl.runDataScan(
              (com.google.cloud.dataplex.v1.RunDataScanRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.RunDataScanResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_SCAN_JOB:
          serviceImpl.getDataScanJob(
              (com.google.cloud.dataplex.v1.GetDataScanJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataScanJob>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_SCAN_JOBS:
          serviceImpl.listDataScanJobs(
              (com.google.cloud.dataplex.v1.ListDataScanJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataScanJobsResponse>)
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
            getCreateDataScanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateDataScanRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATA_SCAN)))
        .addMethod(
            getUpdateDataScanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateDataScanRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_SCAN)))
        .addMethod(
            getDeleteDataScanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteDataScanRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATA_SCAN)))
        .addMethod(
            getGetDataScanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetDataScanRequest,
                    com.google.cloud.dataplex.v1.DataScan>(service, METHODID_GET_DATA_SCAN)))
        .addMethod(
            getListDataScansMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListDataScansRequest,
                    com.google.cloud.dataplex.v1.ListDataScansResponse>(
                    service, METHODID_LIST_DATA_SCANS)))
        .addMethod(
            getRunDataScanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.RunDataScanRequest,
                    com.google.cloud.dataplex.v1.RunDataScanResponse>(
                    service, METHODID_RUN_DATA_SCAN)))
        .addMethod(
            getGetDataScanJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetDataScanJobRequest,
                    com.google.cloud.dataplex.v1.DataScanJob>(service, METHODID_GET_DATA_SCAN_JOB)))
        .addMethod(
            getListDataScanJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListDataScanJobsRequest,
                    com.google.cloud.dataplex.v1.ListDataScanJobsResponse>(
                    service, METHODID_LIST_DATA_SCAN_JOBS)))
        .build();
  }

  private abstract static class DataScanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataScanServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.DataScansProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataScanService");
    }
  }

  private static final class DataScanServiceFileDescriptorSupplier
      extends DataScanServiceBaseDescriptorSupplier {
    DataScanServiceFileDescriptorSupplier() {}
  }

  private static final class DataScanServiceMethodDescriptorSupplier
      extends DataScanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataScanServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataScanServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataScanServiceFileDescriptorSupplier())
                      .addMethod(getCreateDataScanMethod())
                      .addMethod(getUpdateDataScanMethod())
                      .addMethod(getDeleteDataScanMethod())
                      .addMethod(getGetDataScanMethod())
                      .addMethod(getListDataScansMethod())
                      .addMethod(getRunDataScanMethod())
                      .addMethod(getGetDataScanJobMethod())
                      .addMethod(getListDataScanJobsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
