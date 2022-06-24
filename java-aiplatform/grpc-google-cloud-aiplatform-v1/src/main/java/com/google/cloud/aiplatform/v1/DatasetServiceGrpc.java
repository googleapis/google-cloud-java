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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that handles the CRUD of Vertex AI Dataset and its child
 * resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/dataset_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DatasetServiceGrpc {

  private DatasetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1.DatasetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateDatasetRequest, com.google.longrunning.Operation>
      getCreateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataset",
      requestType = com.google.cloud.aiplatform.v1.CreateDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateDatasetRequest, com.google.longrunning.Operation>
      getCreateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateDatasetRequest, com.google.longrunning.Operation>
        getCreateDatasetMethod;
    if ((getCreateDatasetMethod = DatasetServiceGrpc.getCreateDatasetMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getCreateDatasetMethod = DatasetServiceGrpc.getCreateDatasetMethod) == null) {
          DatasetServiceGrpc.getCreateDatasetMethod =
              getCreateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatasetServiceMethodDescriptorSupplier("CreateDataset"))
                      .build();
        }
      }
    }
    return getCreateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetDatasetRequest, com.google.cloud.aiplatform.v1.Dataset>
      getGetDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataset",
      requestType = com.google.cloud.aiplatform.v1.GetDatasetRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetDatasetRequest, com.google.cloud.aiplatform.v1.Dataset>
      getGetDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetDatasetRequest,
            com.google.cloud.aiplatform.v1.Dataset>
        getGetDatasetMethod;
    if ((getGetDatasetMethod = DatasetServiceGrpc.getGetDatasetMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getGetDatasetMethod = DatasetServiceGrpc.getGetDatasetMethod) == null) {
          DatasetServiceGrpc.getGetDatasetMethod =
              getGetDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetDatasetRequest,
                          com.google.cloud.aiplatform.v1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(new DatasetServiceMethodDescriptorSupplier("GetDataset"))
                      .build();
        }
      }
    }
    return getGetDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateDatasetRequest,
          com.google.cloud.aiplatform.v1.Dataset>
      getUpdateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataset",
      requestType = com.google.cloud.aiplatform.v1.UpdateDatasetRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateDatasetRequest,
          com.google.cloud.aiplatform.v1.Dataset>
      getUpdateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UpdateDatasetRequest,
            com.google.cloud.aiplatform.v1.Dataset>
        getUpdateDatasetMethod;
    if ((getUpdateDatasetMethod = DatasetServiceGrpc.getUpdateDatasetMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getUpdateDatasetMethod = DatasetServiceGrpc.getUpdateDatasetMethod) == null) {
          DatasetServiceGrpc.getUpdateDatasetMethod =
              getUpdateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UpdateDatasetRequest,
                          com.google.cloud.aiplatform.v1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UpdateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatasetServiceMethodDescriptorSupplier("UpdateDataset"))
                      .build();
        }
      }
    }
    return getUpdateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListDatasetsRequest,
          com.google.cloud.aiplatform.v1.ListDatasetsResponse>
      getListDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatasets",
      requestType = com.google.cloud.aiplatform.v1.ListDatasetsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListDatasetsRequest,
          com.google.cloud.aiplatform.v1.ListDatasetsResponse>
      getListDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListDatasetsRequest,
            com.google.cloud.aiplatform.v1.ListDatasetsResponse>
        getListDatasetsMethod;
    if ((getListDatasetsMethod = DatasetServiceGrpc.getListDatasetsMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getListDatasetsMethod = DatasetServiceGrpc.getListDatasetsMethod) == null) {
          DatasetServiceGrpc.getListDatasetsMethod =
              getListDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListDatasetsRequest,
                          com.google.cloud.aiplatform.v1.ListDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatasetServiceMethodDescriptorSupplier("ListDatasets"))
                      .build();
        }
      }
    }
    return getListDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteDatasetRequest, com.google.longrunning.Operation>
      getDeleteDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataset",
      requestType = com.google.cloud.aiplatform.v1.DeleteDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteDatasetRequest, com.google.longrunning.Operation>
      getDeleteDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteDatasetRequest, com.google.longrunning.Operation>
        getDeleteDatasetMethod;
    if ((getDeleteDatasetMethod = DatasetServiceGrpc.getDeleteDatasetMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getDeleteDatasetMethod = DatasetServiceGrpc.getDeleteDatasetMethod) == null) {
          DatasetServiceGrpc.getDeleteDatasetMethod =
              getDeleteDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatasetServiceMethodDescriptorSupplier("DeleteDataset"))
                      .build();
        }
      }
    }
    return getDeleteDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportData",
      requestType = com.google.cloud.aiplatform.v1.ImportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ImportDataRequest, com.google.longrunning.Operation>
        getImportDataMethod;
    if ((getImportDataMethod = DatasetServiceGrpc.getImportDataMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getImportDataMethod = DatasetServiceGrpc.getImportDataMethod) == null) {
          DatasetServiceGrpc.getImportDataMethod =
              getImportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ImportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ImportDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DatasetServiceMethodDescriptorSupplier("ImportData"))
                      .build();
        }
      }
    }
    return getImportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportData",
      requestType = com.google.cloud.aiplatform.v1.ExportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ExportDataRequest, com.google.longrunning.Operation>
        getExportDataMethod;
    if ((getExportDataMethod = DatasetServiceGrpc.getExportDataMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getExportDataMethod = DatasetServiceGrpc.getExportDataMethod) == null) {
          DatasetServiceGrpc.getExportDataMethod =
              getExportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ExportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ExportDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DatasetServiceMethodDescriptorSupplier("ExportData"))
                      .build();
        }
      }
    }
    return getExportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListDataItemsRequest,
          com.google.cloud.aiplatform.v1.ListDataItemsResponse>
      getListDataItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataItems",
      requestType = com.google.cloud.aiplatform.v1.ListDataItemsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListDataItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListDataItemsRequest,
          com.google.cloud.aiplatform.v1.ListDataItemsResponse>
      getListDataItemsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListDataItemsRequest,
            com.google.cloud.aiplatform.v1.ListDataItemsResponse>
        getListDataItemsMethod;
    if ((getListDataItemsMethod = DatasetServiceGrpc.getListDataItemsMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getListDataItemsMethod = DatasetServiceGrpc.getListDataItemsMethod) == null) {
          DatasetServiceGrpc.getListDataItemsMethod =
              getListDataItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListDataItemsRequest,
                          com.google.cloud.aiplatform.v1.ListDataItemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListDataItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListDataItemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatasetServiceMethodDescriptorSupplier("ListDataItems"))
                      .build();
        }
      }
    }
    return getListDataItemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListSavedQueriesRequest,
          com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>
      getListSavedQueriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSavedQueries",
      requestType = com.google.cloud.aiplatform.v1.ListSavedQueriesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListSavedQueriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListSavedQueriesRequest,
          com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>
      getListSavedQueriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListSavedQueriesRequest,
            com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>
        getListSavedQueriesMethod;
    if ((getListSavedQueriesMethod = DatasetServiceGrpc.getListSavedQueriesMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getListSavedQueriesMethod = DatasetServiceGrpc.getListSavedQueriesMethod) == null) {
          DatasetServiceGrpc.getListSavedQueriesMethod =
              getListSavedQueriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListSavedQueriesRequest,
                          com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSavedQueries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListSavedQueriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListSavedQueriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatasetServiceMethodDescriptorSupplier("ListSavedQueries"))
                      .build();
        }
      }
    }
    return getListSavedQueriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest,
          com.google.cloud.aiplatform.v1.AnnotationSpec>
      getGetAnnotationSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnotationSpec",
      requestType = com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest.class,
      responseType = com.google.cloud.aiplatform.v1.AnnotationSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest,
          com.google.cloud.aiplatform.v1.AnnotationSpec>
      getGetAnnotationSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest,
            com.google.cloud.aiplatform.v1.AnnotationSpec>
        getGetAnnotationSpecMethod;
    if ((getGetAnnotationSpecMethod = DatasetServiceGrpc.getGetAnnotationSpecMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getGetAnnotationSpecMethod = DatasetServiceGrpc.getGetAnnotationSpecMethod) == null) {
          DatasetServiceGrpc.getGetAnnotationSpecMethod =
              getGetAnnotationSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest,
                          com.google.cloud.aiplatform.v1.AnnotationSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnnotationSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AnnotationSpec.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatasetServiceMethodDescriptorSupplier("GetAnnotationSpec"))
                      .build();
        }
      }
    }
    return getGetAnnotationSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListAnnotationsRequest,
          com.google.cloud.aiplatform.v1.ListAnnotationsResponse>
      getListAnnotationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnnotations",
      requestType = com.google.cloud.aiplatform.v1.ListAnnotationsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListAnnotationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListAnnotationsRequest,
          com.google.cloud.aiplatform.v1.ListAnnotationsResponse>
      getListAnnotationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListAnnotationsRequest,
            com.google.cloud.aiplatform.v1.ListAnnotationsResponse>
        getListAnnotationsMethod;
    if ((getListAnnotationsMethod = DatasetServiceGrpc.getListAnnotationsMethod) == null) {
      synchronized (DatasetServiceGrpc.class) {
        if ((getListAnnotationsMethod = DatasetServiceGrpc.getListAnnotationsMethod) == null) {
          DatasetServiceGrpc.getListAnnotationsMethod =
              getListAnnotationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListAnnotationsRequest,
                          com.google.cloud.aiplatform.v1.ListAnnotationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAnnotations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListAnnotationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListAnnotationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatasetServiceMethodDescriptorSupplier("ListAnnotations"))
                      .build();
        }
      }
    }
    return getListAnnotationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DatasetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatasetServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatasetServiceStub>() {
          @java.lang.Override
          public DatasetServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatasetServiceStub(channel, callOptions);
          }
        };
    return DatasetServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatasetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatasetServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatasetServiceBlockingStub>() {
          @java.lang.Override
          public DatasetServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatasetServiceBlockingStub(channel, callOptions);
          }
        };
    return DatasetServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DatasetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatasetServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatasetServiceFutureStub>() {
          @java.lang.Override
          public DatasetServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatasetServiceFutureStub(channel, callOptions);
          }
        };
    return DatasetServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service that handles the CRUD of Vertex AI Dataset and its child
   * resources.
   * </pre>
   */
  public abstract static class DatasetServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a Dataset.
     * </pre>
     */
    public void createDataset(
        com.google.cloud.aiplatform.v1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Dataset.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.aiplatform.v1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Dataset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Dataset.
     * </pre>
     */
    public void updateDataset(
        com.google.cloud.aiplatform.v1.UpdateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Dataset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Datasets in a Location.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.aiplatform.v1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Dataset.
     * </pre>
     */
    public void deleteDataset(
        com.google.cloud.aiplatform.v1.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Dataset.
     * </pre>
     */
    public void importData(
        com.google.cloud.aiplatform.v1.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Dataset.
     * </pre>
     */
    public void exportData(
        com.google.cloud.aiplatform.v1.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataItems in a Dataset.
     * </pre>
     */
    public void listDataItems(
        com.google.cloud.aiplatform.v1.ListDataItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListDataItemsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataItemsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SavedQueries in a Dataset.
     * </pre>
     */
    public void listSavedQueries(
        com.google.cloud.aiplatform.v1.ListSavedQueriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSavedQueriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an AnnotationSpec.
     * </pre>
     */
    public void getAnnotationSpec(
        com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnnotationSpec>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnnotationSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Annotations belongs to a dataitem
     * </pre>
     */
    public void listAnnotations(
        com.google.cloud.aiplatform.v1.ListAnnotationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListAnnotationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnnotationsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.CreateDatasetRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_DATASET)))
          .addMethod(
              getGetDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetDatasetRequest,
                      com.google.cloud.aiplatform.v1.Dataset>(this, METHODID_GET_DATASET)))
          .addMethod(
              getUpdateDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.UpdateDatasetRequest,
                      com.google.cloud.aiplatform.v1.Dataset>(this, METHODID_UPDATE_DATASET)))
          .addMethod(
              getListDatasetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListDatasetsRequest,
                      com.google.cloud.aiplatform.v1.ListDatasetsResponse>(
                      this, METHODID_LIST_DATASETS)))
          .addMethod(
              getDeleteDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.DeleteDatasetRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_DATASET)))
          .addMethod(
              getImportDataMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ImportDataRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_DATA)))
          .addMethod(
              getExportDataMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ExportDataRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_DATA)))
          .addMethod(
              getListDataItemsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListDataItemsRequest,
                      com.google.cloud.aiplatform.v1.ListDataItemsResponse>(
                      this, METHODID_LIST_DATA_ITEMS)))
          .addMethod(
              getListSavedQueriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListSavedQueriesRequest,
                      com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>(
                      this, METHODID_LIST_SAVED_QUERIES)))
          .addMethod(
              getGetAnnotationSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest,
                      com.google.cloud.aiplatform.v1.AnnotationSpec>(
                      this, METHODID_GET_ANNOTATION_SPEC)))
          .addMethod(
              getListAnnotationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListAnnotationsRequest,
                      com.google.cloud.aiplatform.v1.ListAnnotationsResponse>(
                      this, METHODID_LIST_ANNOTATIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The service that handles the CRUD of Vertex AI Dataset and its child
   * resources.
   * </pre>
   */
  public static final class DatasetServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DatasetServiceStub> {
    private DatasetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatasetServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatasetServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Dataset.
     * </pre>
     */
    public void createDataset(
        com.google.cloud.aiplatform.v1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Dataset.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.aiplatform.v1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Dataset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Dataset.
     * </pre>
     */
    public void updateDataset(
        com.google.cloud.aiplatform.v1.UpdateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Dataset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Datasets in a Location.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.aiplatform.v1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Dataset.
     * </pre>
     */
    public void deleteDataset(
        com.google.cloud.aiplatform.v1.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Dataset.
     * </pre>
     */
    public void importData(
        com.google.cloud.aiplatform.v1.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Dataset.
     * </pre>
     */
    public void exportData(
        com.google.cloud.aiplatform.v1.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataItems in a Dataset.
     * </pre>
     */
    public void listDataItems(
        com.google.cloud.aiplatform.v1.ListDataItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListDataItemsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataItemsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SavedQueries in a Dataset.
     * </pre>
     */
    public void listSavedQueries(
        com.google.cloud.aiplatform.v1.ListSavedQueriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSavedQueriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an AnnotationSpec.
     * </pre>
     */
    public void getAnnotationSpec(
        com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnnotationSpec>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnnotationSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Annotations belongs to a dataitem
     * </pre>
     */
    public void listAnnotations(
        com.google.cloud.aiplatform.v1.ListAnnotationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListAnnotationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnnotationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The service that handles the CRUD of Vertex AI Dataset and its child
   * resources.
   * </pre>
   */
  public static final class DatasetServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DatasetServiceBlockingStub> {
    private DatasetServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatasetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatasetServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Dataset.
     * </pre>
     */
    public com.google.longrunning.Operation createDataset(
        com.google.cloud.aiplatform.v1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Dataset.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Dataset getDataset(
        com.google.cloud.aiplatform.v1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Dataset.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Dataset updateDataset(
        com.google.cloud.aiplatform.v1.UpdateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Datasets in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListDatasetsResponse listDatasets(
        com.google.cloud.aiplatform.v1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Dataset.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataset(
        com.google.cloud.aiplatform.v1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Dataset.
     * </pre>
     */
    public com.google.longrunning.Operation importData(
        com.google.cloud.aiplatform.v1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Dataset.
     * </pre>
     */
    public com.google.longrunning.Operation exportData(
        com.google.cloud.aiplatform.v1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataItems in a Dataset.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListDataItemsResponse listDataItems(
        com.google.cloud.aiplatform.v1.ListDataItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SavedQueries in a Dataset.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListSavedQueriesResponse listSavedQueries(
        com.google.cloud.aiplatform.v1.ListSavedQueriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSavedQueriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an AnnotationSpec.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.AnnotationSpec getAnnotationSpec(
        com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnotationSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Annotations belongs to a dataitem
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListAnnotationsResponse listAnnotations(
        com.google.cloud.aiplatform.v1.ListAnnotationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnnotationsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The service that handles the CRUD of Vertex AI Dataset and its child
   * resources.
   * </pre>
   */
  public static final class DatasetServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DatasetServiceFutureStub> {
    private DatasetServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatasetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatasetServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataset(com.google.cloud.aiplatform.v1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Dataset>
        getDataset(com.google.cloud.aiplatform.v1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Dataset>
        updateDataset(com.google.cloud.aiplatform.v1.UpdateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Datasets in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListDatasetsResponse>
        listDatasets(com.google.cloud.aiplatform.v1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataset(com.google.cloud.aiplatform.v1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importData(com.google.cloud.aiplatform.v1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportData(com.google.cloud.aiplatform.v1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataItems in a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListDataItemsResponse>
        listDataItems(com.google.cloud.aiplatform.v1.ListDataItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataItemsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SavedQueries in a Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>
        listSavedQueries(com.google.cloud.aiplatform.v1.ListSavedQueriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSavedQueriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an AnnotationSpec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.AnnotationSpec>
        getAnnotationSpec(com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnotationSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Annotations belongs to a dataitem
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListAnnotationsResponse>
        listAnnotations(com.google.cloud.aiplatform.v1.ListAnnotationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnnotationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATASET = 0;
  private static final int METHODID_GET_DATASET = 1;
  private static final int METHODID_UPDATE_DATASET = 2;
  private static final int METHODID_LIST_DATASETS = 3;
  private static final int METHODID_DELETE_DATASET = 4;
  private static final int METHODID_IMPORT_DATA = 5;
  private static final int METHODID_EXPORT_DATA = 6;
  private static final int METHODID_LIST_DATA_ITEMS = 7;
  private static final int METHODID_LIST_SAVED_QUERIES = 8;
  private static final int METHODID_GET_ANNOTATION_SPEC = 9;
  private static final int METHODID_LIST_ANNOTATIONS = 10;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DatasetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DatasetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DATASET:
          serviceImpl.createDataset(
              (com.google.cloud.aiplatform.v1.CreateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATASET:
          serviceImpl.getDataset(
              (com.google.cloud.aiplatform.v1.GetDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Dataset>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATASET:
          serviceImpl.updateDataset(
              (com.google.cloud.aiplatform.v1.UpdateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Dataset>)
                  responseObserver);
          break;
        case METHODID_LIST_DATASETS:
          serviceImpl.listDatasets(
              (com.google.cloud.aiplatform.v1.ListDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATASET:
          serviceImpl.deleteDataset(
              (com.google.cloud.aiplatform.v1.DeleteDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_DATA:
          serviceImpl.importData(
              (com.google.cloud.aiplatform.v1.ImportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_DATA:
          serviceImpl.exportData(
              (com.google.cloud.aiplatform.v1.ExportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATA_ITEMS:
          serviceImpl.listDataItems(
              (com.google.cloud.aiplatform.v1.ListDataItemsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListDataItemsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SAVED_QUERIES:
          serviceImpl.listSavedQueries(
              (com.google.cloud.aiplatform.v1.ListSavedQueriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSavedQueriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ANNOTATION_SPEC:
          serviceImpl.getAnnotationSpec(
              (com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.AnnotationSpec>)
                  responseObserver);
          break;
        case METHODID_LIST_ANNOTATIONS:
          serviceImpl.listAnnotations(
              (com.google.cloud.aiplatform.v1.ListAnnotationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListAnnotationsResponse>)
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

  private abstract static class DatasetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatasetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.DatasetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DatasetService");
    }
  }

  private static final class DatasetServiceFileDescriptorSupplier
      extends DatasetServiceBaseDescriptorSupplier {
    DatasetServiceFileDescriptorSupplier() {}
  }

  private static final class DatasetServiceMethodDescriptorSupplier
      extends DatasetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DatasetServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DatasetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DatasetServiceFileDescriptorSupplier())
                      .addMethod(getCreateDatasetMethod())
                      .addMethod(getGetDatasetMethod())
                      .addMethod(getUpdateDatasetMethod())
                      .addMethod(getListDatasetsMethod())
                      .addMethod(getDeleteDatasetMethod())
                      .addMethod(getImportDataMethod())
                      .addMethod(getExportDataMethod())
                      .addMethod(getListDataItemsMethod())
                      .addMethod(getListSavedQueriesMethod())
                      .addMethod(getGetAnnotationSpecMethod())
                      .addMethod(getListAnnotationsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
