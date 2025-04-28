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
package google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * DataAccessControlService exposes resources and endpoints related to data
 * access control.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/chronicle/v1/data_access_control.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataAccessControlServiceGrpc {

  private DataAccessControlServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.DataAccessControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateDataAccessLabelRequest,
          google.cloud.chronicle.v1.DataAccessLabel>
      getCreateDataAccessLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataAccessLabel",
      requestType = google.cloud.chronicle.v1.CreateDataAccessLabelRequest.class,
      responseType = google.cloud.chronicle.v1.DataAccessLabel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateDataAccessLabelRequest,
          google.cloud.chronicle.v1.DataAccessLabel>
      getCreateDataAccessLabelMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.CreateDataAccessLabelRequest,
            google.cloud.chronicle.v1.DataAccessLabel>
        getCreateDataAccessLabelMethod;
    if ((getCreateDataAccessLabelMethod =
            DataAccessControlServiceGrpc.getCreateDataAccessLabelMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getCreateDataAccessLabelMethod =
                DataAccessControlServiceGrpc.getCreateDataAccessLabelMethod)
            == null) {
          DataAccessControlServiceGrpc.getCreateDataAccessLabelMethod =
              getCreateDataAccessLabelMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.CreateDataAccessLabelRequest,
                          google.cloud.chronicle.v1.DataAccessLabel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDataAccessLabel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.CreateDataAccessLabelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DataAccessLabel.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "CreateDataAccessLabel"))
                      .build();
        }
      }
    }
    return getCreateDataAccessLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetDataAccessLabelRequest,
          google.cloud.chronicle.v1.DataAccessLabel>
      getGetDataAccessLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataAccessLabel",
      requestType = google.cloud.chronicle.v1.GetDataAccessLabelRequest.class,
      responseType = google.cloud.chronicle.v1.DataAccessLabel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetDataAccessLabelRequest,
          google.cloud.chronicle.v1.DataAccessLabel>
      getGetDataAccessLabelMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.GetDataAccessLabelRequest,
            google.cloud.chronicle.v1.DataAccessLabel>
        getGetDataAccessLabelMethod;
    if ((getGetDataAccessLabelMethod = DataAccessControlServiceGrpc.getGetDataAccessLabelMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getGetDataAccessLabelMethod = DataAccessControlServiceGrpc.getGetDataAccessLabelMethod)
            == null) {
          DataAccessControlServiceGrpc.getGetDataAccessLabelMethod =
              getGetDataAccessLabelMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.GetDataAccessLabelRequest,
                          google.cloud.chronicle.v1.DataAccessLabel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataAccessLabel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.GetDataAccessLabelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DataAccessLabel.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "GetDataAccessLabel"))
                      .build();
        }
      }
    }
    return getGetDataAccessLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListDataAccessLabelsRequest,
          google.cloud.chronicle.v1.ListDataAccessLabelsResponse>
      getListDataAccessLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataAccessLabels",
      requestType = google.cloud.chronicle.v1.ListDataAccessLabelsRequest.class,
      responseType = google.cloud.chronicle.v1.ListDataAccessLabelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListDataAccessLabelsRequest,
          google.cloud.chronicle.v1.ListDataAccessLabelsResponse>
      getListDataAccessLabelsMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.ListDataAccessLabelsRequest,
            google.cloud.chronicle.v1.ListDataAccessLabelsResponse>
        getListDataAccessLabelsMethod;
    if ((getListDataAccessLabelsMethod = DataAccessControlServiceGrpc.getListDataAccessLabelsMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getListDataAccessLabelsMethod =
                DataAccessControlServiceGrpc.getListDataAccessLabelsMethod)
            == null) {
          DataAccessControlServiceGrpc.getListDataAccessLabelsMethod =
              getListDataAccessLabelsMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.ListDataAccessLabelsRequest,
                          google.cloud.chronicle.v1.ListDataAccessLabelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDataAccessLabels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListDataAccessLabelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListDataAccessLabelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "ListDataAccessLabels"))
                      .build();
        }
      }
    }
    return getListDataAccessLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateDataAccessLabelRequest,
          google.cloud.chronicle.v1.DataAccessLabel>
      getUpdateDataAccessLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataAccessLabel",
      requestType = google.cloud.chronicle.v1.UpdateDataAccessLabelRequest.class,
      responseType = google.cloud.chronicle.v1.DataAccessLabel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateDataAccessLabelRequest,
          google.cloud.chronicle.v1.DataAccessLabel>
      getUpdateDataAccessLabelMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.UpdateDataAccessLabelRequest,
            google.cloud.chronicle.v1.DataAccessLabel>
        getUpdateDataAccessLabelMethod;
    if ((getUpdateDataAccessLabelMethod =
            DataAccessControlServiceGrpc.getUpdateDataAccessLabelMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getUpdateDataAccessLabelMethod =
                DataAccessControlServiceGrpc.getUpdateDataAccessLabelMethod)
            == null) {
          DataAccessControlServiceGrpc.getUpdateDataAccessLabelMethod =
              getUpdateDataAccessLabelMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.UpdateDataAccessLabelRequest,
                          google.cloud.chronicle.v1.DataAccessLabel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDataAccessLabel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.UpdateDataAccessLabelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DataAccessLabel.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "UpdateDataAccessLabel"))
                      .build();
        }
      }
    }
    return getUpdateDataAccessLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.DeleteDataAccessLabelRequest, com.google.protobuf.Empty>
      getDeleteDataAccessLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataAccessLabel",
      requestType = google.cloud.chronicle.v1.DeleteDataAccessLabelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.DeleteDataAccessLabelRequest, com.google.protobuf.Empty>
      getDeleteDataAccessLabelMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.DeleteDataAccessLabelRequest, com.google.protobuf.Empty>
        getDeleteDataAccessLabelMethod;
    if ((getDeleteDataAccessLabelMethod =
            DataAccessControlServiceGrpc.getDeleteDataAccessLabelMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getDeleteDataAccessLabelMethod =
                DataAccessControlServiceGrpc.getDeleteDataAccessLabelMethod)
            == null) {
          DataAccessControlServiceGrpc.getDeleteDataAccessLabelMethod =
              getDeleteDataAccessLabelMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.DeleteDataAccessLabelRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDataAccessLabel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DeleteDataAccessLabelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "DeleteDataAccessLabel"))
                      .build();
        }
      }
    }
    return getDeleteDataAccessLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateDataAccessScopeRequest,
          google.cloud.chronicle.v1.DataAccessScope>
      getCreateDataAccessScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataAccessScope",
      requestType = google.cloud.chronicle.v1.CreateDataAccessScopeRequest.class,
      responseType = google.cloud.chronicle.v1.DataAccessScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateDataAccessScopeRequest,
          google.cloud.chronicle.v1.DataAccessScope>
      getCreateDataAccessScopeMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.CreateDataAccessScopeRequest,
            google.cloud.chronicle.v1.DataAccessScope>
        getCreateDataAccessScopeMethod;
    if ((getCreateDataAccessScopeMethod =
            DataAccessControlServiceGrpc.getCreateDataAccessScopeMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getCreateDataAccessScopeMethod =
                DataAccessControlServiceGrpc.getCreateDataAccessScopeMethod)
            == null) {
          DataAccessControlServiceGrpc.getCreateDataAccessScopeMethod =
              getCreateDataAccessScopeMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.CreateDataAccessScopeRequest,
                          google.cloud.chronicle.v1.DataAccessScope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDataAccessScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.CreateDataAccessScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DataAccessScope.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "CreateDataAccessScope"))
                      .build();
        }
      }
    }
    return getCreateDataAccessScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetDataAccessScopeRequest,
          google.cloud.chronicle.v1.DataAccessScope>
      getGetDataAccessScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataAccessScope",
      requestType = google.cloud.chronicle.v1.GetDataAccessScopeRequest.class,
      responseType = google.cloud.chronicle.v1.DataAccessScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetDataAccessScopeRequest,
          google.cloud.chronicle.v1.DataAccessScope>
      getGetDataAccessScopeMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.GetDataAccessScopeRequest,
            google.cloud.chronicle.v1.DataAccessScope>
        getGetDataAccessScopeMethod;
    if ((getGetDataAccessScopeMethod = DataAccessControlServiceGrpc.getGetDataAccessScopeMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getGetDataAccessScopeMethod = DataAccessControlServiceGrpc.getGetDataAccessScopeMethod)
            == null) {
          DataAccessControlServiceGrpc.getGetDataAccessScopeMethod =
              getGetDataAccessScopeMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.GetDataAccessScopeRequest,
                          google.cloud.chronicle.v1.DataAccessScope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataAccessScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.GetDataAccessScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DataAccessScope.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "GetDataAccessScope"))
                      .build();
        }
      }
    }
    return getGetDataAccessScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListDataAccessScopesRequest,
          google.cloud.chronicle.v1.ListDataAccessScopesResponse>
      getListDataAccessScopesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataAccessScopes",
      requestType = google.cloud.chronicle.v1.ListDataAccessScopesRequest.class,
      responseType = google.cloud.chronicle.v1.ListDataAccessScopesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListDataAccessScopesRequest,
          google.cloud.chronicle.v1.ListDataAccessScopesResponse>
      getListDataAccessScopesMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.ListDataAccessScopesRequest,
            google.cloud.chronicle.v1.ListDataAccessScopesResponse>
        getListDataAccessScopesMethod;
    if ((getListDataAccessScopesMethod = DataAccessControlServiceGrpc.getListDataAccessScopesMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getListDataAccessScopesMethod =
                DataAccessControlServiceGrpc.getListDataAccessScopesMethod)
            == null) {
          DataAccessControlServiceGrpc.getListDataAccessScopesMethod =
              getListDataAccessScopesMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.ListDataAccessScopesRequest,
                          google.cloud.chronicle.v1.ListDataAccessScopesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDataAccessScopes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListDataAccessScopesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListDataAccessScopesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "ListDataAccessScopes"))
                      .build();
        }
      }
    }
    return getListDataAccessScopesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateDataAccessScopeRequest,
          google.cloud.chronicle.v1.DataAccessScope>
      getUpdateDataAccessScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataAccessScope",
      requestType = google.cloud.chronicle.v1.UpdateDataAccessScopeRequest.class,
      responseType = google.cloud.chronicle.v1.DataAccessScope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateDataAccessScopeRequest,
          google.cloud.chronicle.v1.DataAccessScope>
      getUpdateDataAccessScopeMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.UpdateDataAccessScopeRequest,
            google.cloud.chronicle.v1.DataAccessScope>
        getUpdateDataAccessScopeMethod;
    if ((getUpdateDataAccessScopeMethod =
            DataAccessControlServiceGrpc.getUpdateDataAccessScopeMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getUpdateDataAccessScopeMethod =
                DataAccessControlServiceGrpc.getUpdateDataAccessScopeMethod)
            == null) {
          DataAccessControlServiceGrpc.getUpdateDataAccessScopeMethod =
              getUpdateDataAccessScopeMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.UpdateDataAccessScopeRequest,
                          google.cloud.chronicle.v1.DataAccessScope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDataAccessScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.UpdateDataAccessScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DataAccessScope.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "UpdateDataAccessScope"))
                      .build();
        }
      }
    }
    return getUpdateDataAccessScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.DeleteDataAccessScopeRequest, com.google.protobuf.Empty>
      getDeleteDataAccessScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataAccessScope",
      requestType = google.cloud.chronicle.v1.DeleteDataAccessScopeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.DeleteDataAccessScopeRequest, com.google.protobuf.Empty>
      getDeleteDataAccessScopeMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.DeleteDataAccessScopeRequest, com.google.protobuf.Empty>
        getDeleteDataAccessScopeMethod;
    if ((getDeleteDataAccessScopeMethod =
            DataAccessControlServiceGrpc.getDeleteDataAccessScopeMethod)
        == null) {
      synchronized (DataAccessControlServiceGrpc.class) {
        if ((getDeleteDataAccessScopeMethod =
                DataAccessControlServiceGrpc.getDeleteDataAccessScopeMethod)
            == null) {
          DataAccessControlServiceGrpc.getDeleteDataAccessScopeMethod =
              getDeleteDataAccessScopeMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.DeleteDataAccessScopeRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDataAccessScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DeleteDataAccessScopeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataAccessControlServiceMethodDescriptorSupplier(
                              "DeleteDataAccessScope"))
                      .build();
        }
      }
    }
    return getDeleteDataAccessScopeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataAccessControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataAccessControlServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataAccessControlServiceStub>() {
          @java.lang.Override
          public DataAccessControlServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataAccessControlServiceStub(channel, callOptions);
          }
        };
    return DataAccessControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataAccessControlServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataAccessControlServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataAccessControlServiceBlockingStub>() {
          @java.lang.Override
          public DataAccessControlServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataAccessControlServiceBlockingStub(channel, callOptions);
          }
        };
    return DataAccessControlServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataAccessControlServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataAccessControlServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataAccessControlServiceFutureStub>() {
          @java.lang.Override
          public DataAccessControlServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataAccessControlServiceFutureStub(channel, callOptions);
          }
        };
    return DataAccessControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * DataAccessControlService exposes resources and endpoints related to data
   * access control.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a data access label.
     * Data access labels are applied to incoming event data and selected in data
     * access scopes (another resource), and only users with scopes containing the
     * label can see data with that label. Currently, the data access label
     * resource only includes custom labels, which are labels that correspond
     * to UDM queries over event data.
     * </pre>
     */
    default void createDataAccessLabel(
        google.cloud.chronicle.v1.CreateDataAccessLabelRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataAccessLabelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data access label.
     * </pre>
     */
    default void getDataAccessLabel(
        google.cloud.chronicle.v1.GetDataAccessLabelRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataAccessLabelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all data access labels for the customer.
     * </pre>
     */
    default void listDataAccessLabels(
        google.cloud.chronicle.v1.ListDataAccessLabelsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListDataAccessLabelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataAccessLabelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a data access label.
     * </pre>
     */
    default void updateDataAccessLabel(
        google.cloud.chronicle.v1.UpdateDataAccessLabelRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataAccessLabelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data access label. When a label is deleted, new
     * data that enters in the system will not receive the label, but the label
     * will not be removed from old data that still refers to it.
     * </pre>
     */
    default void deleteDataAccessLabel(
        google.cloud.chronicle.v1.DeleteDataAccessLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataAccessLabelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a data access scope.
     * Data access scope is a combination of allowed and denied labels attached
     * to a permission group. If a scope has allowed labels A and B and denied
     * labels C and D, then the group of people attached to the scope
     * will have permissions to see all events labeled with A or B (or both) and
     * not labeled with either C or D.
     * </pre>
     */
    default void createDataAccessScope(
        google.cloud.chronicle.v1.CreateDataAccessScopeRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataAccessScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an existing data access scope.
     * </pre>
     */
    default void getDataAccessScope(
        google.cloud.chronicle.v1.GetDataAccessScopeRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataAccessScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all existing data access scopes for the customer.
     * </pre>
     */
    default void listDataAccessScopes(
        google.cloud.chronicle.v1.ListDataAccessScopesRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListDataAccessScopesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataAccessScopesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a data access scope.
     * </pre>
     */
    default void updateDataAccessScope(
        google.cloud.chronicle.v1.UpdateDataAccessScopeRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataAccessScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data access scope.
     * </pre>
     */
    default void deleteDataAccessScope(
        google.cloud.chronicle.v1.DeleteDataAccessScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataAccessScopeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataAccessControlService.
   *
   * <pre>
   * DataAccessControlService exposes resources and endpoints related to data
   * access control.
   * </pre>
   */
  public abstract static class DataAccessControlServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataAccessControlServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataAccessControlService.
   *
   * <pre>
   * DataAccessControlService exposes resources and endpoints related to data
   * access control.
   * </pre>
   */
  public static final class DataAccessControlServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataAccessControlServiceStub> {
    private DataAccessControlServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataAccessControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataAccessControlServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a data access label.
     * Data access labels are applied to incoming event data and selected in data
     * access scopes (another resource), and only users with scopes containing the
     * label can see data with that label. Currently, the data access label
     * resource only includes custom labels, which are labels that correspond
     * to UDM queries over event data.
     * </pre>
     */
    public void createDataAccessLabel(
        google.cloud.chronicle.v1.CreateDataAccessLabelRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataAccessLabelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data access label.
     * </pre>
     */
    public void getDataAccessLabel(
        google.cloud.chronicle.v1.GetDataAccessLabelRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataAccessLabelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all data access labels for the customer.
     * </pre>
     */
    public void listDataAccessLabels(
        google.cloud.chronicle.v1.ListDataAccessLabelsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListDataAccessLabelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataAccessLabelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a data access label.
     * </pre>
     */
    public void updateDataAccessLabel(
        google.cloud.chronicle.v1.UpdateDataAccessLabelRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataAccessLabelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data access label. When a label is deleted, new
     * data that enters in the system will not receive the label, but the label
     * will not be removed from old data that still refers to it.
     * </pre>
     */
    public void deleteDataAccessLabel(
        google.cloud.chronicle.v1.DeleteDataAccessLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataAccessLabelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a data access scope.
     * Data access scope is a combination of allowed and denied labels attached
     * to a permission group. If a scope has allowed labels A and B and denied
     * labels C and D, then the group of people attached to the scope
     * will have permissions to see all events labeled with A or B (or both) and
     * not labeled with either C or D.
     * </pre>
     */
    public void createDataAccessScope(
        google.cloud.chronicle.v1.CreateDataAccessScopeRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataAccessScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an existing data access scope.
     * </pre>
     */
    public void getDataAccessScope(
        google.cloud.chronicle.v1.GetDataAccessScopeRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataAccessScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all existing data access scopes for the customer.
     * </pre>
     */
    public void listDataAccessScopes(
        google.cloud.chronicle.v1.ListDataAccessScopesRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListDataAccessScopesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataAccessScopesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a data access scope.
     * </pre>
     */
    public void updateDataAccessScope(
        google.cloud.chronicle.v1.UpdateDataAccessScopeRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataAccessScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data access scope.
     * </pre>
     */
    public void deleteDataAccessScope(
        google.cloud.chronicle.v1.DeleteDataAccessScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataAccessScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataAccessControlService.
   *
   * <pre>
   * DataAccessControlService exposes resources and endpoints related to data
   * access control.
   * </pre>
   */
  public static final class DataAccessControlServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataAccessControlServiceBlockingStub> {
    private DataAccessControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataAccessControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataAccessControlServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a data access label.
     * Data access labels are applied to incoming event data and selected in data
     * access scopes (another resource), and only users with scopes containing the
     * label can see data with that label. Currently, the data access label
     * resource only includes custom labels, which are labels that correspond
     * to UDM queries over event data.
     * </pre>
     */
    public google.cloud.chronicle.v1.DataAccessLabel createDataAccessLabel(
        google.cloud.chronicle.v1.CreateDataAccessLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataAccessLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data access label.
     * </pre>
     */
    public google.cloud.chronicle.v1.DataAccessLabel getDataAccessLabel(
        google.cloud.chronicle.v1.GetDataAccessLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataAccessLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all data access labels for the customer.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListDataAccessLabelsResponse listDataAccessLabels(
        google.cloud.chronicle.v1.ListDataAccessLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataAccessLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data access label.
     * </pre>
     */
    public google.cloud.chronicle.v1.DataAccessLabel updateDataAccessLabel(
        google.cloud.chronicle.v1.UpdateDataAccessLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataAccessLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data access label. When a label is deleted, new
     * data that enters in the system will not receive the label, but the label
     * will not be removed from old data that still refers to it.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataAccessLabel(
        google.cloud.chronicle.v1.DeleteDataAccessLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataAccessLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a data access scope.
     * Data access scope is a combination of allowed and denied labels attached
     * to a permission group. If a scope has allowed labels A and B and denied
     * labels C and D, then the group of people attached to the scope
     * will have permissions to see all events labeled with A or B (or both) and
     * not labeled with either C or D.
     * </pre>
     */
    public google.cloud.chronicle.v1.DataAccessScope createDataAccessScope(
        google.cloud.chronicle.v1.CreateDataAccessScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataAccessScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an existing data access scope.
     * </pre>
     */
    public google.cloud.chronicle.v1.DataAccessScope getDataAccessScope(
        google.cloud.chronicle.v1.GetDataAccessScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataAccessScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all existing data access scopes for the customer.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListDataAccessScopesResponse listDataAccessScopes(
        google.cloud.chronicle.v1.ListDataAccessScopesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataAccessScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data access scope.
     * </pre>
     */
    public google.cloud.chronicle.v1.DataAccessScope updateDataAccessScope(
        google.cloud.chronicle.v1.UpdateDataAccessScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataAccessScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data access scope.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataAccessScope(
        google.cloud.chronicle.v1.DeleteDataAccessScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataAccessScopeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * DataAccessControlService.
   *
   * <pre>
   * DataAccessControlService exposes resources and endpoints related to data
   * access control.
   * </pre>
   */
  public static final class DataAccessControlServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataAccessControlServiceFutureStub> {
    private DataAccessControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataAccessControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataAccessControlServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a data access label.
     * Data access labels are applied to incoming event data and selected in data
     * access scopes (another resource), and only users with scopes containing the
     * label can see data with that label. Currently, the data access label
     * resource only includes custom labels, which are labels that correspond
     * to UDM queries over event data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.DataAccessLabel>
        createDataAccessLabel(google.cloud.chronicle.v1.CreateDataAccessLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataAccessLabelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data access label.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.DataAccessLabel>
        getDataAccessLabel(google.cloud.chronicle.v1.GetDataAccessLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataAccessLabelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all data access labels for the customer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.ListDataAccessLabelsResponse>
        listDataAccessLabels(google.cloud.chronicle.v1.ListDataAccessLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataAccessLabelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data access label.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.DataAccessLabel>
        updateDataAccessLabel(google.cloud.chronicle.v1.UpdateDataAccessLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataAccessLabelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data access label. When a label is deleted, new
     * data that enters in the system will not receive the label, but the label
     * will not be removed from old data that still refers to it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataAccessLabel(google.cloud.chronicle.v1.DeleteDataAccessLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataAccessLabelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a data access scope.
     * Data access scope is a combination of allowed and denied labels attached
     * to a permission group. If a scope has allowed labels A and B and denied
     * labels C and D, then the group of people attached to the scope
     * will have permissions to see all events labeled with A or B (or both) and
     * not labeled with either C or D.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.DataAccessScope>
        createDataAccessScope(google.cloud.chronicle.v1.CreateDataAccessScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataAccessScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an existing data access scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.DataAccessScope>
        getDataAccessScope(google.cloud.chronicle.v1.GetDataAccessScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataAccessScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all existing data access scopes for the customer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.ListDataAccessScopesResponse>
        listDataAccessScopes(google.cloud.chronicle.v1.ListDataAccessScopesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataAccessScopesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data access scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.DataAccessScope>
        updateDataAccessScope(google.cloud.chronicle.v1.UpdateDataAccessScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataAccessScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data access scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataAccessScope(google.cloud.chronicle.v1.DeleteDataAccessScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataAccessScopeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATA_ACCESS_LABEL = 0;
  private static final int METHODID_GET_DATA_ACCESS_LABEL = 1;
  private static final int METHODID_LIST_DATA_ACCESS_LABELS = 2;
  private static final int METHODID_UPDATE_DATA_ACCESS_LABEL = 3;
  private static final int METHODID_DELETE_DATA_ACCESS_LABEL = 4;
  private static final int METHODID_CREATE_DATA_ACCESS_SCOPE = 5;
  private static final int METHODID_GET_DATA_ACCESS_SCOPE = 6;
  private static final int METHODID_LIST_DATA_ACCESS_SCOPES = 7;
  private static final int METHODID_UPDATE_DATA_ACCESS_SCOPE = 8;
  private static final int METHODID_DELETE_DATA_ACCESS_SCOPE = 9;

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
        case METHODID_CREATE_DATA_ACCESS_LABEL:
          serviceImpl.createDataAccessLabel(
              (google.cloud.chronicle.v1.CreateDataAccessLabelRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_ACCESS_LABEL:
          serviceImpl.getDataAccessLabel(
              (google.cloud.chronicle.v1.GetDataAccessLabelRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_ACCESS_LABELS:
          serviceImpl.listDataAccessLabels(
              (google.cloud.chronicle.v1.ListDataAccessLabelsRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListDataAccessLabelsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_ACCESS_LABEL:
          serviceImpl.updateDataAccessLabel(
              (google.cloud.chronicle.v1.UpdateDataAccessLabelRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessLabel>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_ACCESS_LABEL:
          serviceImpl.deleteDataAccessLabel(
              (google.cloud.chronicle.v1.DeleteDataAccessLabelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_DATA_ACCESS_SCOPE:
          serviceImpl.createDataAccessScope(
              (google.cloud.chronicle.v1.CreateDataAccessScopeRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_ACCESS_SCOPE:
          serviceImpl.getDataAccessScope(
              (google.cloud.chronicle.v1.GetDataAccessScopeRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_ACCESS_SCOPES:
          serviceImpl.listDataAccessScopes(
              (google.cloud.chronicle.v1.ListDataAccessScopesRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListDataAccessScopesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_ACCESS_SCOPE:
          serviceImpl.updateDataAccessScope(
              (google.cloud.chronicle.v1.UpdateDataAccessScopeRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.DataAccessScope>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_ACCESS_SCOPE:
          serviceImpl.deleteDataAccessScope(
              (google.cloud.chronicle.v1.DeleteDataAccessScopeRequest) request,
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
            getCreateDataAccessLabelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.CreateDataAccessLabelRequest,
                    google.cloud.chronicle.v1.DataAccessLabel>(
                    service, METHODID_CREATE_DATA_ACCESS_LABEL)))
        .addMethod(
            getGetDataAccessLabelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.GetDataAccessLabelRequest,
                    google.cloud.chronicle.v1.DataAccessLabel>(
                    service, METHODID_GET_DATA_ACCESS_LABEL)))
        .addMethod(
            getListDataAccessLabelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.ListDataAccessLabelsRequest,
                    google.cloud.chronicle.v1.ListDataAccessLabelsResponse>(
                    service, METHODID_LIST_DATA_ACCESS_LABELS)))
        .addMethod(
            getUpdateDataAccessLabelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.UpdateDataAccessLabelRequest,
                    google.cloud.chronicle.v1.DataAccessLabel>(
                    service, METHODID_UPDATE_DATA_ACCESS_LABEL)))
        .addMethod(
            getDeleteDataAccessLabelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.DeleteDataAccessLabelRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_ACCESS_LABEL)))
        .addMethod(
            getCreateDataAccessScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.CreateDataAccessScopeRequest,
                    google.cloud.chronicle.v1.DataAccessScope>(
                    service, METHODID_CREATE_DATA_ACCESS_SCOPE)))
        .addMethod(
            getGetDataAccessScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.GetDataAccessScopeRequest,
                    google.cloud.chronicle.v1.DataAccessScope>(
                    service, METHODID_GET_DATA_ACCESS_SCOPE)))
        .addMethod(
            getListDataAccessScopesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.ListDataAccessScopesRequest,
                    google.cloud.chronicle.v1.ListDataAccessScopesResponse>(
                    service, METHODID_LIST_DATA_ACCESS_SCOPES)))
        .addMethod(
            getUpdateDataAccessScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.UpdateDataAccessScopeRequest,
                    google.cloud.chronicle.v1.DataAccessScope>(
                    service, METHODID_UPDATE_DATA_ACCESS_SCOPE)))
        .addMethod(
            getDeleteDataAccessScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.DeleteDataAccessScopeRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_ACCESS_SCOPE)))
        .build();
  }

  private abstract static class DataAccessControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataAccessControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return google.cloud.chronicle.v1.DataAccessProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataAccessControlService");
    }
  }

  private static final class DataAccessControlServiceFileDescriptorSupplier
      extends DataAccessControlServiceBaseDescriptorSupplier {
    DataAccessControlServiceFileDescriptorSupplier() {}
  }

  private static final class DataAccessControlServiceMethodDescriptorSupplier
      extends DataAccessControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataAccessControlServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataAccessControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataAccessControlServiceFileDescriptorSupplier())
                      .addMethod(getCreateDataAccessLabelMethod())
                      .addMethod(getGetDataAccessLabelMethod())
                      .addMethod(getListDataAccessLabelsMethod())
                      .addMethod(getUpdateDataAccessLabelMethod())
                      .addMethod(getDeleteDataAccessLabelMethod())
                      .addMethod(getCreateDataAccessScopeMethod())
                      .addMethod(getGetDataAccessScopeMethod())
                      .addMethod(getListDataAccessScopesMethod())
                      .addMethod(getUpdateDataAccessScopeMethod())
                      .addMethod(getDeleteDataAccessScopeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
