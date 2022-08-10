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
package com.google.cloud.datalabeling.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for the AI Platform Data Labeling API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/datalabeling/v1beta1/data_labeling_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataLabelingServiceGrpc {

  private DataLabelingServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datalabeling.v1beta1.DataLabelingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest,
          com.google.cloud.datalabeling.v1beta1.Dataset>
      getCreateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataset",
      requestType = com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest,
          com.google.cloud.datalabeling.v1beta1.Dataset>
      getCreateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest,
            com.google.cloud.datalabeling.v1beta1.Dataset>
        getCreateDatasetMethod;
    if ((getCreateDatasetMethod = DataLabelingServiceGrpc.getCreateDatasetMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getCreateDatasetMethod = DataLabelingServiceGrpc.getCreateDatasetMethod) == null) {
          DataLabelingServiceGrpc.getCreateDatasetMethod =
              getCreateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest,
                          com.google.cloud.datalabeling.v1beta1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("CreateDataset"))
                      .build();
        }
      }
    }
    return getCreateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetDatasetRequest,
          com.google.cloud.datalabeling.v1beta1.Dataset>
      getGetDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataset",
      requestType = com.google.cloud.datalabeling.v1beta1.GetDatasetRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetDatasetRequest,
          com.google.cloud.datalabeling.v1beta1.Dataset>
      getGetDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.GetDatasetRequest,
            com.google.cloud.datalabeling.v1beta1.Dataset>
        getGetDatasetMethod;
    if ((getGetDatasetMethod = DataLabelingServiceGrpc.getGetDatasetMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getGetDatasetMethod = DataLabelingServiceGrpc.getGetDatasetMethod) == null) {
          DataLabelingServiceGrpc.getGetDatasetMethod =
              getGetDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.GetDatasetRequest,
                          com.google.cloud.datalabeling.v1beta1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.GetDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("GetDataset"))
                      .build();
        }
      }
    }
    return getGetDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest,
          com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>
      getListDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatasets",
      requestType = com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest,
          com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>
      getListDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest,
            com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>
        getListDatasetsMethod;
    if ((getListDatasetsMethod = DataLabelingServiceGrpc.getListDatasetsMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getListDatasetsMethod = DataLabelingServiceGrpc.getListDatasetsMethod) == null) {
          DataLabelingServiceGrpc.getListDatasetsMethod =
              getListDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest,
                          com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ListDatasets"))
                      .build();
        }
      }
    }
    return getListDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest, com.google.protobuf.Empty>
      getDeleteDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataset",
      requestType = com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest, com.google.protobuf.Empty>
      getDeleteDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest, com.google.protobuf.Empty>
        getDeleteDatasetMethod;
    if ((getDeleteDatasetMethod = DataLabelingServiceGrpc.getDeleteDatasetMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getDeleteDatasetMethod = DataLabelingServiceGrpc.getDeleteDatasetMethod) == null) {
          DataLabelingServiceGrpc.getDeleteDatasetMethod =
              getDeleteDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("DeleteDataset"))
                      .build();
        }
      }
    }
    return getDeleteDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportData",
      requestType = com.google.cloud.datalabeling.v1beta1.ImportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ImportDataRequest,
            com.google.longrunning.Operation>
        getImportDataMethod;
    if ((getImportDataMethod = DataLabelingServiceGrpc.getImportDataMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getImportDataMethod = DataLabelingServiceGrpc.getImportDataMethod) == null) {
          DataLabelingServiceGrpc.getImportDataMethod =
              getImportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ImportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ImportDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ImportData"))
                      .build();
        }
      }
    }
    return getImportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportData",
      requestType = com.google.cloud.datalabeling.v1beta1.ExportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ExportDataRequest,
            com.google.longrunning.Operation>
        getExportDataMethod;
    if ((getExportDataMethod = DataLabelingServiceGrpc.getExportDataMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getExportDataMethod = DataLabelingServiceGrpc.getExportDataMethod) == null) {
          DataLabelingServiceGrpc.getExportDataMethod =
              getExportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ExportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ExportDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ExportData"))
                      .build();
        }
      }
    }
    return getExportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetDataItemRequest,
          com.google.cloud.datalabeling.v1beta1.DataItem>
      getGetDataItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataItem",
      requestType = com.google.cloud.datalabeling.v1beta1.GetDataItemRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.DataItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetDataItemRequest,
          com.google.cloud.datalabeling.v1beta1.DataItem>
      getGetDataItemMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.GetDataItemRequest,
            com.google.cloud.datalabeling.v1beta1.DataItem>
        getGetDataItemMethod;
    if ((getGetDataItemMethod = DataLabelingServiceGrpc.getGetDataItemMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getGetDataItemMethod = DataLabelingServiceGrpc.getGetDataItemMethod) == null) {
          DataLabelingServiceGrpc.getGetDataItemMethod =
              getGetDataItemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.GetDataItemRequest,
                          com.google.cloud.datalabeling.v1beta1.DataItem>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataItem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.GetDataItemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.DataItem.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("GetDataItem"))
                      .build();
        }
      }
    }
    return getGetDataItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest,
          com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>
      getListDataItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataItems",
      requestType = com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest,
          com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>
      getListDataItemsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest,
            com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>
        getListDataItemsMethod;
    if ((getListDataItemsMethod = DataLabelingServiceGrpc.getListDataItemsMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getListDataItemsMethod = DataLabelingServiceGrpc.getListDataItemsMethod) == null) {
          DataLabelingServiceGrpc.getListDataItemsMethod =
              getListDataItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest,
                          com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ListDataItems"))
                      .build();
        }
      }
    }
    return getListDataItemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest,
          com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>
      getGetAnnotatedDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnotatedDataset",
      requestType = com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.AnnotatedDataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest,
          com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>
      getGetAnnotatedDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest,
            com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>
        getGetAnnotatedDatasetMethod;
    if ((getGetAnnotatedDatasetMethod = DataLabelingServiceGrpc.getGetAnnotatedDatasetMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getGetAnnotatedDatasetMethod = DataLabelingServiceGrpc.getGetAnnotatedDatasetMethod)
            == null) {
          DataLabelingServiceGrpc.getGetAnnotatedDatasetMethod =
              getGetAnnotatedDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest,
                          com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAnnotatedDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.AnnotatedDataset
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("GetAnnotatedDataset"))
                      .build();
        }
      }
    }
    return getGetAnnotatedDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest,
          com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>
      getListAnnotatedDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnnotatedDatasets",
      requestType = com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest,
          com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>
      getListAnnotatedDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest,
            com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>
        getListAnnotatedDatasetsMethod;
    if ((getListAnnotatedDatasetsMethod = DataLabelingServiceGrpc.getListAnnotatedDatasetsMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getListAnnotatedDatasetsMethod =
                DataLabelingServiceGrpc.getListAnnotatedDatasetsMethod)
            == null) {
          DataLabelingServiceGrpc.getListAnnotatedDatasetsMethod =
              getListAnnotatedDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest,
                          com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAnnotatedDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ListAnnotatedDatasets"))
                      .build();
        }
      }
    }
    return getListAnnotatedDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest,
          com.google.protobuf.Empty>
      getDeleteAnnotatedDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnnotatedDataset",
      requestType = com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest,
          com.google.protobuf.Empty>
      getDeleteAnnotatedDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest,
            com.google.protobuf.Empty>
        getDeleteAnnotatedDatasetMethod;
    if ((getDeleteAnnotatedDatasetMethod = DataLabelingServiceGrpc.getDeleteAnnotatedDatasetMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getDeleteAnnotatedDatasetMethod =
                DataLabelingServiceGrpc.getDeleteAnnotatedDatasetMethod)
            == null) {
          DataLabelingServiceGrpc.getDeleteAnnotatedDatasetMethod =
              getDeleteAnnotatedDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAnnotatedDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("DeleteAnnotatedDataset"))
                      .build();
        }
      }
    }
    return getDeleteAnnotatedDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.LabelImageRequest, com.google.longrunning.Operation>
      getLabelImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LabelImage",
      requestType = com.google.cloud.datalabeling.v1beta1.LabelImageRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.LabelImageRequest, com.google.longrunning.Operation>
      getLabelImageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.LabelImageRequest,
            com.google.longrunning.Operation>
        getLabelImageMethod;
    if ((getLabelImageMethod = DataLabelingServiceGrpc.getLabelImageMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getLabelImageMethod = DataLabelingServiceGrpc.getLabelImageMethod) == null) {
          DataLabelingServiceGrpc.getLabelImageMethod =
              getLabelImageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.LabelImageRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LabelImage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.LabelImageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("LabelImage"))
                      .build();
        }
      }
    }
    return getLabelImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.LabelVideoRequest, com.google.longrunning.Operation>
      getLabelVideoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LabelVideo",
      requestType = com.google.cloud.datalabeling.v1beta1.LabelVideoRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.LabelVideoRequest, com.google.longrunning.Operation>
      getLabelVideoMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.LabelVideoRequest,
            com.google.longrunning.Operation>
        getLabelVideoMethod;
    if ((getLabelVideoMethod = DataLabelingServiceGrpc.getLabelVideoMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getLabelVideoMethod = DataLabelingServiceGrpc.getLabelVideoMethod) == null) {
          DataLabelingServiceGrpc.getLabelVideoMethod =
              getLabelVideoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.LabelVideoRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LabelVideo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.LabelVideoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("LabelVideo"))
                      .build();
        }
      }
    }
    return getLabelVideoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.LabelTextRequest, com.google.longrunning.Operation>
      getLabelTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LabelText",
      requestType = com.google.cloud.datalabeling.v1beta1.LabelTextRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.LabelTextRequest, com.google.longrunning.Operation>
      getLabelTextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.LabelTextRequest,
            com.google.longrunning.Operation>
        getLabelTextMethod;
    if ((getLabelTextMethod = DataLabelingServiceGrpc.getLabelTextMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getLabelTextMethod = DataLabelingServiceGrpc.getLabelTextMethod) == null) {
          DataLabelingServiceGrpc.getLabelTextMethod =
              getLabelTextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.LabelTextRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LabelText"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.LabelTextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("LabelText"))
                      .build();
        }
      }
    }
    return getLabelTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetExampleRequest,
          com.google.cloud.datalabeling.v1beta1.Example>
      getGetExampleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExample",
      requestType = com.google.cloud.datalabeling.v1beta1.GetExampleRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.Example.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetExampleRequest,
          com.google.cloud.datalabeling.v1beta1.Example>
      getGetExampleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.GetExampleRequest,
            com.google.cloud.datalabeling.v1beta1.Example>
        getGetExampleMethod;
    if ((getGetExampleMethod = DataLabelingServiceGrpc.getGetExampleMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getGetExampleMethod = DataLabelingServiceGrpc.getGetExampleMethod) == null) {
          DataLabelingServiceGrpc.getGetExampleMethod =
              getGetExampleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.GetExampleRequest,
                          com.google.cloud.datalabeling.v1beta1.Example>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExample"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.GetExampleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.Example.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("GetExample"))
                      .build();
        }
      }
    }
    return getGetExampleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListExamplesRequest,
          com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>
      getListExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExamples",
      requestType = com.google.cloud.datalabeling.v1beta1.ListExamplesRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.ListExamplesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListExamplesRequest,
          com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>
      getListExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ListExamplesRequest,
            com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>
        getListExamplesMethod;
    if ((getListExamplesMethod = DataLabelingServiceGrpc.getListExamplesMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getListExamplesMethod = DataLabelingServiceGrpc.getListExamplesMethod) == null) {
          DataLabelingServiceGrpc.getListExamplesMethod =
              getListExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ListExamplesRequest,
                          com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListExamplesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ListExamples"))
                      .build();
        }
      }
    }
    return getListExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest,
          com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
      getCreateAnnotationSpecSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnnotationSpecSet",
      requestType = com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest,
          com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
      getCreateAnnotationSpecSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest,
            com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
        getCreateAnnotationSpecSetMethod;
    if ((getCreateAnnotationSpecSetMethod =
            DataLabelingServiceGrpc.getCreateAnnotationSpecSetMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getCreateAnnotationSpecSetMethod =
                DataLabelingServiceGrpc.getCreateAnnotationSpecSetMethod)
            == null) {
          DataLabelingServiceGrpc.getCreateAnnotationSpecSetMethod =
              getCreateAnnotationSpecSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest,
                          com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAnnotationSpecSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier(
                              "CreateAnnotationSpecSet"))
                      .build();
        }
      }
    }
    return getCreateAnnotationSpecSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest,
          com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
      getGetAnnotationSpecSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnotationSpecSet",
      requestType = com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest,
          com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
      getGetAnnotationSpecSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest,
            com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
        getGetAnnotationSpecSetMethod;
    if ((getGetAnnotationSpecSetMethod = DataLabelingServiceGrpc.getGetAnnotationSpecSetMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getGetAnnotationSpecSetMethod = DataLabelingServiceGrpc.getGetAnnotationSpecSetMethod)
            == null) {
          DataLabelingServiceGrpc.getGetAnnotationSpecSetMethod =
              getGetAnnotationSpecSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest,
                          com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAnnotationSpecSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("GetAnnotationSpecSet"))
                      .build();
        }
      }
    }
    return getGetAnnotationSpecSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest,
          com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>
      getListAnnotationSpecSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnnotationSpecSets",
      requestType = com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest,
          com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>
      getListAnnotationSpecSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest,
            com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>
        getListAnnotationSpecSetsMethod;
    if ((getListAnnotationSpecSetsMethod = DataLabelingServiceGrpc.getListAnnotationSpecSetsMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getListAnnotationSpecSetsMethod =
                DataLabelingServiceGrpc.getListAnnotationSpecSetsMethod)
            == null) {
          DataLabelingServiceGrpc.getListAnnotationSpecSetsMethod =
              getListAnnotationSpecSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest,
                          com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAnnotationSpecSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ListAnnotationSpecSets"))
                      .build();
        }
      }
    }
    return getListAnnotationSpecSetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest,
          com.google.protobuf.Empty>
      getDeleteAnnotationSpecSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnnotationSpecSet",
      requestType = com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest,
          com.google.protobuf.Empty>
      getDeleteAnnotationSpecSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest,
            com.google.protobuf.Empty>
        getDeleteAnnotationSpecSetMethod;
    if ((getDeleteAnnotationSpecSetMethod =
            DataLabelingServiceGrpc.getDeleteAnnotationSpecSetMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getDeleteAnnotationSpecSetMethod =
                DataLabelingServiceGrpc.getDeleteAnnotationSpecSetMethod)
            == null) {
          DataLabelingServiceGrpc.getDeleteAnnotationSpecSetMethod =
              getDeleteAnnotationSpecSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAnnotationSpecSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier(
                              "DeleteAnnotationSpecSet"))
                      .build();
        }
      }
    }
    return getDeleteAnnotationSpecSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest,
          com.google.longrunning.Operation>
      getCreateInstructionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstruction",
      requestType = com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest,
          com.google.longrunning.Operation>
      getCreateInstructionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest,
            com.google.longrunning.Operation>
        getCreateInstructionMethod;
    if ((getCreateInstructionMethod = DataLabelingServiceGrpc.getCreateInstructionMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getCreateInstructionMethod = DataLabelingServiceGrpc.getCreateInstructionMethod)
            == null) {
          DataLabelingServiceGrpc.getCreateInstructionMethod =
              getCreateInstructionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstruction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("CreateInstruction"))
                      .build();
        }
      }
    }
    return getCreateInstructionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetInstructionRequest,
          com.google.cloud.datalabeling.v1beta1.Instruction>
      getGetInstructionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstruction",
      requestType = com.google.cloud.datalabeling.v1beta1.GetInstructionRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.Instruction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetInstructionRequest,
          com.google.cloud.datalabeling.v1beta1.Instruction>
      getGetInstructionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.GetInstructionRequest,
            com.google.cloud.datalabeling.v1beta1.Instruction>
        getGetInstructionMethod;
    if ((getGetInstructionMethod = DataLabelingServiceGrpc.getGetInstructionMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getGetInstructionMethod = DataLabelingServiceGrpc.getGetInstructionMethod) == null) {
          DataLabelingServiceGrpc.getGetInstructionMethod =
              getGetInstructionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.GetInstructionRequest,
                          com.google.cloud.datalabeling.v1beta1.Instruction>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstruction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.GetInstructionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.Instruction
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("GetInstruction"))
                      .build();
        }
      }
    }
    return getGetInstructionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest,
          com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>
      getListInstructionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstructions",
      requestType = com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest,
          com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>
      getListInstructionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest,
            com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>
        getListInstructionsMethod;
    if ((getListInstructionsMethod = DataLabelingServiceGrpc.getListInstructionsMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getListInstructionsMethod = DataLabelingServiceGrpc.getListInstructionsMethod)
            == null) {
          DataLabelingServiceGrpc.getListInstructionsMethod =
              getListInstructionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest,
                          com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstructions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ListInstructions"))
                      .build();
        }
      }
    }
    return getListInstructionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest, com.google.protobuf.Empty>
      getDeleteInstructionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstruction",
      requestType = com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest, com.google.protobuf.Empty>
      getDeleteInstructionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest,
            com.google.protobuf.Empty>
        getDeleteInstructionMethod;
    if ((getDeleteInstructionMethod = DataLabelingServiceGrpc.getDeleteInstructionMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getDeleteInstructionMethod = DataLabelingServiceGrpc.getDeleteInstructionMethod)
            == null) {
          DataLabelingServiceGrpc.getDeleteInstructionMethod =
              getDeleteInstructionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstruction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("DeleteInstruction"))
                      .build();
        }
      }
    }
    return getDeleteInstructionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest,
          com.google.cloud.datalabeling.v1beta1.Evaluation>
      getGetEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluation",
      requestType = com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.Evaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest,
          com.google.cloud.datalabeling.v1beta1.Evaluation>
      getGetEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest,
            com.google.cloud.datalabeling.v1beta1.Evaluation>
        getGetEvaluationMethod;
    if ((getGetEvaluationMethod = DataLabelingServiceGrpc.getGetEvaluationMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getGetEvaluationMethod = DataLabelingServiceGrpc.getGetEvaluationMethod) == null) {
          DataLabelingServiceGrpc.getGetEvaluationMethod =
              getGetEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest,
                          com.google.cloud.datalabeling.v1beta1.Evaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.Evaluation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("GetEvaluation"))
                      .build();
        }
      }
    }
    return getGetEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest,
          com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>
      getSearchEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchEvaluations",
      requestType = com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest,
          com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>
      getSearchEvaluationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest,
            com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>
        getSearchEvaluationsMethod;
    if ((getSearchEvaluationsMethod = DataLabelingServiceGrpc.getSearchEvaluationsMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getSearchEvaluationsMethod = DataLabelingServiceGrpc.getSearchEvaluationsMethod)
            == null) {
          DataLabelingServiceGrpc.getSearchEvaluationsMethod =
              getSearchEvaluationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest,
                          com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchEvaluations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("SearchEvaluations"))
                      .build();
        }
      }
    }
    return getSearchEvaluationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest,
          com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>
      getSearchExampleComparisonsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchExampleComparisons",
      requestType = com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest,
          com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>
      getSearchExampleComparisonsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest,
            com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>
        getSearchExampleComparisonsMethod;
    if ((getSearchExampleComparisonsMethod =
            DataLabelingServiceGrpc.getSearchExampleComparisonsMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getSearchExampleComparisonsMethod =
                DataLabelingServiceGrpc.getSearchExampleComparisonsMethod)
            == null) {
          DataLabelingServiceGrpc.getSearchExampleComparisonsMethod =
              getSearchExampleComparisonsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest,
                          com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchExampleComparisons"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier(
                              "SearchExampleComparisons"))
                      .build();
        }
      }
    }
    return getSearchExampleComparisonsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest,
          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
      getCreateEvaluationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEvaluationJob",
      requestType = com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.EvaluationJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest,
          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
      getCreateEvaluationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest,
            com.google.cloud.datalabeling.v1beta1.EvaluationJob>
        getCreateEvaluationJobMethod;
    if ((getCreateEvaluationJobMethod = DataLabelingServiceGrpc.getCreateEvaluationJobMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getCreateEvaluationJobMethod = DataLabelingServiceGrpc.getCreateEvaluationJobMethod)
            == null) {
          DataLabelingServiceGrpc.getCreateEvaluationJobMethod =
              getCreateEvaluationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest,
                          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEvaluationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.EvaluationJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("CreateEvaluationJob"))
                      .build();
        }
      }
    }
    return getCreateEvaluationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest,
          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
      getUpdateEvaluationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEvaluationJob",
      requestType = com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.EvaluationJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest,
          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
      getUpdateEvaluationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest,
            com.google.cloud.datalabeling.v1beta1.EvaluationJob>
        getUpdateEvaluationJobMethod;
    if ((getUpdateEvaluationJobMethod = DataLabelingServiceGrpc.getUpdateEvaluationJobMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getUpdateEvaluationJobMethod = DataLabelingServiceGrpc.getUpdateEvaluationJobMethod)
            == null) {
          DataLabelingServiceGrpc.getUpdateEvaluationJobMethod =
              getUpdateEvaluationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest,
                          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEvaluationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.EvaluationJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("UpdateEvaluationJob"))
                      .build();
        }
      }
    }
    return getUpdateEvaluationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest,
          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
      getGetEvaluationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvaluationJob",
      requestType = com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.EvaluationJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest,
          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
      getGetEvaluationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest,
            com.google.cloud.datalabeling.v1beta1.EvaluationJob>
        getGetEvaluationJobMethod;
    if ((getGetEvaluationJobMethod = DataLabelingServiceGrpc.getGetEvaluationJobMethod) == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getGetEvaluationJobMethod = DataLabelingServiceGrpc.getGetEvaluationJobMethod)
            == null) {
          DataLabelingServiceGrpc.getGetEvaluationJobMethod =
              getGetEvaluationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest,
                          com.google.cloud.datalabeling.v1beta1.EvaluationJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvaluationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.EvaluationJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("GetEvaluationJob"))
                      .build();
        }
      }
    }
    return getGetEvaluationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest,
          com.google.protobuf.Empty>
      getPauseEvaluationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseEvaluationJob",
      requestType = com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest,
          com.google.protobuf.Empty>
      getPauseEvaluationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest,
            com.google.protobuf.Empty>
        getPauseEvaluationJobMethod;
    if ((getPauseEvaluationJobMethod = DataLabelingServiceGrpc.getPauseEvaluationJobMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getPauseEvaluationJobMethod = DataLabelingServiceGrpc.getPauseEvaluationJobMethod)
            == null) {
          DataLabelingServiceGrpc.getPauseEvaluationJobMethod =
              getPauseEvaluationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseEvaluationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("PauseEvaluationJob"))
                      .build();
        }
      }
    }
    return getPauseEvaluationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest,
          com.google.protobuf.Empty>
      getResumeEvaluationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeEvaluationJob",
      requestType = com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest,
          com.google.protobuf.Empty>
      getResumeEvaluationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest,
            com.google.protobuf.Empty>
        getResumeEvaluationJobMethod;
    if ((getResumeEvaluationJobMethod = DataLabelingServiceGrpc.getResumeEvaluationJobMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getResumeEvaluationJobMethod = DataLabelingServiceGrpc.getResumeEvaluationJobMethod)
            == null) {
          DataLabelingServiceGrpc.getResumeEvaluationJobMethod =
              getResumeEvaluationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResumeEvaluationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ResumeEvaluationJob"))
                      .build();
        }
      }
    }
    return getResumeEvaluationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest,
          com.google.protobuf.Empty>
      getDeleteEvaluationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvaluationJob",
      requestType = com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest,
          com.google.protobuf.Empty>
      getDeleteEvaluationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest,
            com.google.protobuf.Empty>
        getDeleteEvaluationJobMethod;
    if ((getDeleteEvaluationJobMethod = DataLabelingServiceGrpc.getDeleteEvaluationJobMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getDeleteEvaluationJobMethod = DataLabelingServiceGrpc.getDeleteEvaluationJobMethod)
            == null) {
          DataLabelingServiceGrpc.getDeleteEvaluationJobMethod =
              getDeleteEvaluationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEvaluationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("DeleteEvaluationJob"))
                      .build();
        }
      }
    }
    return getDeleteEvaluationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest,
          com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>
      getListEvaluationJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvaluationJobs",
      requestType = com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest.class,
      responseType = com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest,
          com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>
      getListEvaluationJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest,
            com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>
        getListEvaluationJobsMethod;
    if ((getListEvaluationJobsMethod = DataLabelingServiceGrpc.getListEvaluationJobsMethod)
        == null) {
      synchronized (DataLabelingServiceGrpc.class) {
        if ((getListEvaluationJobsMethod = DataLabelingServiceGrpc.getListEvaluationJobsMethod)
            == null) {
          DataLabelingServiceGrpc.getListEvaluationJobsMethod =
              getListEvaluationJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest,
                          com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvaluationJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataLabelingServiceMethodDescriptorSupplier("ListEvaluationJobs"))
                      .build();
        }
      }
    }
    return getListEvaluationJobsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataLabelingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataLabelingServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataLabelingServiceStub>() {
          @java.lang.Override
          public DataLabelingServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataLabelingServiceStub(channel, callOptions);
          }
        };
    return DataLabelingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataLabelingServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataLabelingServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataLabelingServiceBlockingStub>() {
          @java.lang.Override
          public DataLabelingServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataLabelingServiceBlockingStub(channel, callOptions);
          }
        };
    return DataLabelingServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataLabelingServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataLabelingServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataLabelingServiceFutureStub>() {
          @java.lang.Override
          public DataLabelingServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataLabelingServiceFutureStub(channel, callOptions);
          }
        };
    return DataLabelingServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for the AI Platform Data Labeling API.
   * </pre>
   */
  public abstract static class DataLabelingServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates dataset. If success return a Dataset resource.
     * </pre>
     */
    public void createDataset(
        com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Dataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets dataset by resource name.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.datalabeling.v1beta1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Dataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets under a project. Pagination is supported.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset by resource name.
     * </pre>
     */
    public void deleteDataset(
        com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data into dataset based on source locations defined in request.
     * It can be called multiple times for the same dataset. Each dataset can
     * only have one long running operation running on it. For example, no
     * labeling task (also long running operation) can be started while
     * importing is still ongoing. Vice versa.
     * </pre>
     */
    public void importData(
        com.google.cloud.datalabeling.v1beta1.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data and annotations from dataset.
     * </pre>
     */
    public void exportData(
        com.google.cloud.datalabeling.v1beta1.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data item in a dataset by resource name. This API can be
     * called after data are imported into dataset.
     * </pre>
     */
    public void getDataItem(
        com.google.cloud.datalabeling.v1beta1.GetDataItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.DataItem>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataItemMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists data items in a dataset. This API can be called after data
     * are imported into dataset. Pagination is supported.
     * </pre>
     */
    public void listDataItems(
        com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataItemsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotated dataset by resource name.
     * </pre>
     */
    public void getAnnotatedDataset(
        com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnnotatedDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists annotated datasets for a dataset. Pagination is supported.
     * </pre>
     */
    public void listAnnotatedDatasets(
        com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnnotatedDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an annotated dataset by resource name.
     * </pre>
     */
    public void deleteAnnotatedDataset(
        com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAnnotatedDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for image. The type of image labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public void labelImage(
        com.google.cloud.datalabeling.v1beta1.LabelImageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLabelImageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for video. The type of video labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public void labelVideo(
        com.google.cloud.datalabeling.v1beta1.LabelVideoRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLabelVideoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for text. The type of text labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public void labelText(
        com.google.cloud.datalabeling.v1beta1.LabelTextRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLabelTextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an example by resource name, including both data and annotation.
     * </pre>
     */
    public void getExample(
        com.google.cloud.datalabeling.v1beta1.GetExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Example>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetExampleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in an annotated dataset. Pagination is supported.
     * </pre>
     */
    public void listExamples(
        com.google.cloud.datalabeling.v1beta1.ListExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an annotation spec set by providing a set of labels.
     * </pre>
     */
    public void createAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAnnotationSpecSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotation spec set by resource name.
     * </pre>
     */
    public void getAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnnotationSpecSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists annotation spec sets for a project. Pagination is supported.
     * </pre>
     */
    public void listAnnotationSpecSets(
        com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnnotationSpecSetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an annotation spec set by resource name.
     * </pre>
     */
    public void deleteAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAnnotationSpecSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an instruction for how data should be labeled.
     * </pre>
     */
    public void createInstruction(
        com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstructionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an instruction by resource name.
     * </pre>
     */
    public void getInstruction(
        com.google.cloud.datalabeling.v1beta1.GetInstructionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Instruction>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstructionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists instructions for a project. Pagination is supported.
     * </pre>
     */
    public void listInstructions(
        com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstructionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an instruction object by resource name.
     * </pre>
     */
    public void deleteInstruction(
        com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstructionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation by resource name (to search, use
     * [projects.evaluations.search][google.cloud.datalabeling.v1beta1.DataLabelingService.SearchEvaluations]).
     * </pre>
     */
    public void getEvaluation(
        com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Evaluation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
     * </pre>
     */
    public void searchEvaluations(
        com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchEvaluationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches example comparisons from an evaluation. The return format is a
     * list of example comparisons that show ground truth and prediction(s) for
     * a single input. Search by providing an evaluation ID.
     * </pre>
     */
    public void searchExampleComparisons(
        com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchExampleComparisonsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation job.
     * </pre>
     */
    public void createEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEvaluationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation job. You can only update certain fields of the job's
     * [EvaluationJobConfig][google.cloud.datalabeling.v1beta1.EvaluationJobConfig]: `humanAnnotationConfig.instruction`,
     * `exampleCount`, and `exampleSamplePercentage`.
     * If you want to change any other aspect of the evaluation job, you must
     * delete the job and create a new one.
     * </pre>
     */
    public void updateEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEvaluationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation job by resource name.
     * </pre>
     */
    public void getEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEvaluationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses an evaluation job. Pausing an evaluation job that is already in a
     * `PAUSED` state is a no-op.
     * </pre>
     */
    public void pauseEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPauseEvaluationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused evaluation job. A deleted evaluation job can't be resumed.
     * Resuming a running or scheduled evaluation job is a no-op.
     * </pre>
     */
    public void resumeEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeEvaluationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops and deletes an evaluation job.
     * </pre>
     */
    public void deleteEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEvaluationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation jobs within a project with possible filters.
     * Pagination is supported.
     * </pre>
     */
    public void listEvaluationJobs(
        com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEvaluationJobsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest,
                      com.google.cloud.datalabeling.v1beta1.Dataset>(
                      this, METHODID_CREATE_DATASET)))
          .addMethod(
              getGetDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.GetDatasetRequest,
                      com.google.cloud.datalabeling.v1beta1.Dataset>(this, METHODID_GET_DATASET)))
          .addMethod(
              getListDatasetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest,
                      com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>(
                      this, METHODID_LIST_DATASETS)))
          .addMethod(
              getDeleteDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_DATASET)))
          .addMethod(
              getImportDataMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ImportDataRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_DATA)))
          .addMethod(
              getExportDataMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ExportDataRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_DATA)))
          .addMethod(
              getGetDataItemMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.GetDataItemRequest,
                      com.google.cloud.datalabeling.v1beta1.DataItem>(
                      this, METHODID_GET_DATA_ITEM)))
          .addMethod(
              getListDataItemsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest,
                      com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>(
                      this, METHODID_LIST_DATA_ITEMS)))
          .addMethod(
              getGetAnnotatedDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest,
                      com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>(
                      this, METHODID_GET_ANNOTATED_DATASET)))
          .addMethod(
              getListAnnotatedDatasetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest,
                      com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>(
                      this, METHODID_LIST_ANNOTATED_DATASETS)))
          .addMethod(
              getDeleteAnnotatedDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ANNOTATED_DATASET)))
          .addMethod(
              getLabelImageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.LabelImageRequest,
                      com.google.longrunning.Operation>(this, METHODID_LABEL_IMAGE)))
          .addMethod(
              getLabelVideoMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.LabelVideoRequest,
                      com.google.longrunning.Operation>(this, METHODID_LABEL_VIDEO)))
          .addMethod(
              getLabelTextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.LabelTextRequest,
                      com.google.longrunning.Operation>(this, METHODID_LABEL_TEXT)))
          .addMethod(
              getGetExampleMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.GetExampleRequest,
                      com.google.cloud.datalabeling.v1beta1.Example>(this, METHODID_GET_EXAMPLE)))
          .addMethod(
              getListExamplesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ListExamplesRequest,
                      com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>(
                      this, METHODID_LIST_EXAMPLES)))
          .addMethod(
              getCreateAnnotationSpecSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest,
                      com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>(
                      this, METHODID_CREATE_ANNOTATION_SPEC_SET)))
          .addMethod(
              getGetAnnotationSpecSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest,
                      com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>(
                      this, METHODID_GET_ANNOTATION_SPEC_SET)))
          .addMethod(
              getListAnnotationSpecSetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest,
                      com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>(
                      this, METHODID_LIST_ANNOTATION_SPEC_SETS)))
          .addMethod(
              getDeleteAnnotationSpecSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ANNOTATION_SPEC_SET)))
          .addMethod(
              getCreateInstructionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_INSTRUCTION)))
          .addMethod(
              getGetInstructionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.GetInstructionRequest,
                      com.google.cloud.datalabeling.v1beta1.Instruction>(
                      this, METHODID_GET_INSTRUCTION)))
          .addMethod(
              getListInstructionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest,
                      com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>(
                      this, METHODID_LIST_INSTRUCTIONS)))
          .addMethod(
              getDeleteInstructionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_INSTRUCTION)))
          .addMethod(
              getGetEvaluationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest,
                      com.google.cloud.datalabeling.v1beta1.Evaluation>(
                      this, METHODID_GET_EVALUATION)))
          .addMethod(
              getSearchEvaluationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest,
                      com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>(
                      this, METHODID_SEARCH_EVALUATIONS)))
          .addMethod(
              getSearchExampleComparisonsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest,
                      com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>(
                      this, METHODID_SEARCH_EXAMPLE_COMPARISONS)))
          .addMethod(
              getCreateEvaluationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest,
                      com.google.cloud.datalabeling.v1beta1.EvaluationJob>(
                      this, METHODID_CREATE_EVALUATION_JOB)))
          .addMethod(
              getUpdateEvaluationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest,
                      com.google.cloud.datalabeling.v1beta1.EvaluationJob>(
                      this, METHODID_UPDATE_EVALUATION_JOB)))
          .addMethod(
              getGetEvaluationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest,
                      com.google.cloud.datalabeling.v1beta1.EvaluationJob>(
                      this, METHODID_GET_EVALUATION_JOB)))
          .addMethod(
              getPauseEvaluationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_PAUSE_EVALUATION_JOB)))
          .addMethod(
              getResumeEvaluationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_RESUME_EVALUATION_JOB)))
          .addMethod(
              getDeleteEvaluationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_EVALUATION_JOB)))
          .addMethod(
              getListEvaluationJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest,
                      com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>(
                      this, METHODID_LIST_EVALUATION_JOBS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for the AI Platform Data Labeling API.
   * </pre>
   */
  public static final class DataLabelingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataLabelingServiceStub> {
    private DataLabelingServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataLabelingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataLabelingServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates dataset. If success return a Dataset resource.
     * </pre>
     */
    public void createDataset(
        com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Dataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets dataset by resource name.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.datalabeling.v1beta1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Dataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets under a project. Pagination is supported.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>
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
     * Deletes a dataset by resource name.
     * </pre>
     */
    public void deleteDataset(
        com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data into dataset based on source locations defined in request.
     * It can be called multiple times for the same dataset. Each dataset can
     * only have one long running operation running on it. For example, no
     * labeling task (also long running operation) can be started while
     * importing is still ongoing. Vice versa.
     * </pre>
     */
    public void importData(
        com.google.cloud.datalabeling.v1beta1.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data and annotations from dataset.
     * </pre>
     */
    public void exportData(
        com.google.cloud.datalabeling.v1beta1.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data item in a dataset by resource name. This API can be
     * called after data are imported into dataset.
     * </pre>
     */
    public void getDataItem(
        com.google.cloud.datalabeling.v1beta1.GetDataItemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.DataItem>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataItemMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists data items in a dataset. This API can be called after data
     * are imported into dataset. Pagination is supported.
     * </pre>
     */
    public void listDataItems(
        com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>
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
     * Gets an annotated dataset by resource name.
     * </pre>
     */
    public void getAnnotatedDataset(
        com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnnotatedDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists annotated datasets for a dataset. Pagination is supported.
     * </pre>
     */
    public void listAnnotatedDatasets(
        com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnnotatedDatasetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an annotated dataset by resource name.
     * </pre>
     */
    public void deleteAnnotatedDataset(
        com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnnotatedDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for image. The type of image labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public void labelImage(
        com.google.cloud.datalabeling.v1beta1.LabelImageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLabelImageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for video. The type of video labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public void labelVideo(
        com.google.cloud.datalabeling.v1beta1.LabelVideoRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLabelVideoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for text. The type of text labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public void labelText(
        com.google.cloud.datalabeling.v1beta1.LabelTextRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLabelTextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an example by resource name, including both data and annotation.
     * </pre>
     */
    public void getExample(
        com.google.cloud.datalabeling.v1beta1.GetExampleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Example>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExampleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in an annotated dataset. Pagination is supported.
     * </pre>
     */
    public void listExamples(
        com.google.cloud.datalabeling.v1beta1.ListExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an annotation spec set by providing a set of labels.
     * </pre>
     */
    public void createAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnnotationSpecSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotation spec set by resource name.
     * </pre>
     */
    public void getAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnnotationSpecSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists annotation spec sets for a project. Pagination is supported.
     * </pre>
     */
    public void listAnnotationSpecSets(
        com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnnotationSpecSetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an annotation spec set by resource name.
     * </pre>
     */
    public void deleteAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnnotationSpecSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an instruction for how data should be labeled.
     * </pre>
     */
    public void createInstruction(
        com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstructionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an instruction by resource name.
     * </pre>
     */
    public void getInstruction(
        com.google.cloud.datalabeling.v1beta1.GetInstructionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Instruction>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstructionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists instructions for a project. Pagination is supported.
     * </pre>
     */
    public void listInstructions(
        com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstructionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an instruction object by resource name.
     * </pre>
     */
    public void deleteInstruction(
        com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstructionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation by resource name (to search, use
     * [projects.evaluations.search][google.cloud.datalabeling.v1beta1.DataLabelingService.SearchEvaluations]).
     * </pre>
     */
    public void getEvaluation(
        com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Evaluation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
     * </pre>
     */
    public void searchEvaluations(
        com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchEvaluationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches example comparisons from an evaluation. The return format is a
     * list of example comparisons that show ground truth and prediction(s) for
     * a single input. Search by providing an evaluation ID.
     * </pre>
     */
    public void searchExampleComparisons(
        com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchExampleComparisonsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation job.
     * </pre>
     */
    public void createEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEvaluationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation job. You can only update certain fields of the job's
     * [EvaluationJobConfig][google.cloud.datalabeling.v1beta1.EvaluationJobConfig]: `humanAnnotationConfig.instruction`,
     * `exampleCount`, and `exampleSamplePercentage`.
     * If you want to change any other aspect of the evaluation job, you must
     * delete the job and create a new one.
     * </pre>
     */
    public void updateEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEvaluationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation job by resource name.
     * </pre>
     */
    public void getEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEvaluationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses an evaluation job. Pausing an evaluation job that is already in a
     * `PAUSED` state is a no-op.
     * </pre>
     */
    public void pauseEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseEvaluationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused evaluation job. A deleted evaluation job can't be resumed.
     * Resuming a running or scheduled evaluation job is a no-op.
     * </pre>
     */
    public void resumeEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeEvaluationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops and deletes an evaluation job.
     * </pre>
     */
    public void deleteEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEvaluationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation jobs within a project with possible filters.
     * Pagination is supported.
     * </pre>
     */
    public void listEvaluationJobs(
        com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEvaluationJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for the AI Platform Data Labeling API.
   * </pre>
   */
  public static final class DataLabelingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataLabelingServiceBlockingStub> {
    private DataLabelingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataLabelingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataLabelingServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates dataset. If success return a Dataset resource.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.Dataset createDataset(
        com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets dataset by resource name.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.Dataset getDataset(
        com.google.cloud.datalabeling.v1beta1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets under a project. Pagination is supported.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse listDatasets(
        com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset by resource name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataset(
        com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into dataset based on source locations defined in request.
     * It can be called multiple times for the same dataset. Each dataset can
     * only have one long running operation running on it. For example, no
     * labeling task (also long running operation) can be started while
     * importing is still ongoing. Vice versa.
     * </pre>
     */
    public com.google.longrunning.Operation importData(
        com.google.cloud.datalabeling.v1beta1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data and annotations from dataset.
     * </pre>
     */
    public com.google.longrunning.Operation exportData(
        com.google.cloud.datalabeling.v1beta1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data item in a dataset by resource name. This API can be
     * called after data are imported into dataset.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.DataItem getDataItem(
        com.google.cloud.datalabeling.v1beta1.GetDataItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataItemMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists data items in a dataset. This API can be called after data
     * are imported into dataset. Pagination is supported.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse listDataItems(
        com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotated dataset by resource name.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.AnnotatedDataset getAnnotatedDataset(
        com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnotatedDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists annotated datasets for a dataset. Pagination is supported.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse
        listAnnotatedDatasets(
            com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnnotatedDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an annotated dataset by resource name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAnnotatedDataset(
        com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnnotatedDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for image. The type of image labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public com.google.longrunning.Operation labelImage(
        com.google.cloud.datalabeling.v1beta1.LabelImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLabelImageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for video. The type of video labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public com.google.longrunning.Operation labelVideo(
        com.google.cloud.datalabeling.v1beta1.LabelVideoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLabelVideoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for text. The type of text labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public com.google.longrunning.Operation labelText(
        com.google.cloud.datalabeling.v1beta1.LabelTextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLabelTextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an example by resource name, including both data and annotation.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.Example getExample(
        com.google.cloud.datalabeling.v1beta1.GetExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExampleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in an annotated dataset. Pagination is supported.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.ListExamplesResponse listExamples(
        com.google.cloud.datalabeling.v1beta1.ListExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an annotation spec set by providing a set of labels.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet createAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnnotationSpecSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotation spec set by resource name.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet getAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnotationSpecSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists annotation spec sets for a project. Pagination is supported.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse
        listAnnotationSpecSets(
            com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnnotationSpecSetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an annotation spec set by resource name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAnnotationSpecSet(
        com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnnotationSpecSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an instruction for how data should be labeled.
     * </pre>
     */
    public com.google.longrunning.Operation createInstruction(
        com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstructionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an instruction by resource name.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.Instruction getInstruction(
        com.google.cloud.datalabeling.v1beta1.GetInstructionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstructionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists instructions for a project. Pagination is supported.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse listInstructions(
        com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstructionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an instruction object by resource name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteInstruction(
        com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstructionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation by resource name (to search, use
     * [projects.evaluations.search][google.cloud.datalabeling.v1beta1.DataLabelingService.SearchEvaluations]).
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.Evaluation getEvaluation(
        com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse searchEvaluations(
        com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchEvaluationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches example comparisons from an evaluation. The return format is a
     * list of example comparisons that show ground truth and prediction(s) for
     * a single input. Search by providing an evaluation ID.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse
        searchExampleComparisons(
            com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchExampleComparisonsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation job.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.EvaluationJob createEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEvaluationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation job. You can only update certain fields of the job's
     * [EvaluationJobConfig][google.cloud.datalabeling.v1beta1.EvaluationJobConfig]: `humanAnnotationConfig.instruction`,
     * `exampleCount`, and `exampleSamplePercentage`.
     * If you want to change any other aspect of the evaluation job, you must
     * delete the job and create a new one.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.EvaluationJob updateEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEvaluationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation job by resource name.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.EvaluationJob getEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEvaluationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses an evaluation job. Pausing an evaluation job that is already in a
     * `PAUSED` state is a no-op.
     * </pre>
     */
    public com.google.protobuf.Empty pauseEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseEvaluationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused evaluation job. A deleted evaluation job can't be resumed.
     * Resuming a running or scheduled evaluation job is a no-op.
     * </pre>
     */
    public com.google.protobuf.Empty resumeEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeEvaluationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops and deletes an evaluation job.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEvaluationJob(
        com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEvaluationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation jobs within a project with possible filters.
     * Pagination is supported.
     * </pre>
     */
    public com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse listEvaluationJobs(
        com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEvaluationJobsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for the AI Platform Data Labeling API.
   * </pre>
   */
  public static final class DataLabelingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataLabelingServiceFutureStub> {
    private DataLabelingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataLabelingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataLabelingServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates dataset. If success return a Dataset resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.Dataset>
        createDataset(com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets dataset by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.Dataset>
        getDataset(com.google.cloud.datalabeling.v1beta1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets under a project. Pagination is supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>
        listDatasets(com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataset(com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into dataset based on source locations defined in request.
     * It can be called multiple times for the same dataset. Each dataset can
     * only have one long running operation running on it. For example, no
     * labeling task (also long running operation) can be started while
     * importing is still ongoing. Vice versa.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importData(com.google.cloud.datalabeling.v1beta1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data and annotations from dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportData(com.google.cloud.datalabeling.v1beta1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data item in a dataset by resource name. This API can be
     * called after data are imported into dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.DataItem>
        getDataItem(com.google.cloud.datalabeling.v1beta1.GetDataItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataItemMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists data items in a dataset. This API can be called after data
     * are imported into dataset. Pagination is supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>
        listDataItems(com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataItemsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotated dataset by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>
        getAnnotatedDataset(
            com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnotatedDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists annotated datasets for a dataset. Pagination is supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>
        listAnnotatedDatasets(
            com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnnotatedDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an annotated dataset by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAnnotatedDataset(
            com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnnotatedDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for image. The type of image labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        labelImage(com.google.cloud.datalabeling.v1beta1.LabelImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLabelImageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for video. The type of video labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        labelVideo(com.google.cloud.datalabeling.v1beta1.LabelVideoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLabelVideoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a labeling task for text. The type of text labeling task is
     * configured by feature in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        labelText(com.google.cloud.datalabeling.v1beta1.LabelTextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLabelTextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an example by resource name, including both data and annotation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.Example>
        getExample(com.google.cloud.datalabeling.v1beta1.GetExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExampleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists examples in an annotated dataset. Pagination is supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>
        listExamples(com.google.cloud.datalabeling.v1beta1.ListExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExamplesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an annotation spec set by providing a set of labels.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
        createAnnotationSpecSet(
            com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnnotationSpecSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotation spec set by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>
        getAnnotationSpecSet(
            com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnotationSpecSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists annotation spec sets for a project. Pagination is supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>
        listAnnotationSpecSets(
            com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnnotationSpecSetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an annotation spec set by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAnnotationSpecSet(
            com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnnotationSpecSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an instruction for how data should be labeled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstruction(com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstructionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an instruction by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.Instruction>
        getInstruction(com.google.cloud.datalabeling.v1beta1.GetInstructionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstructionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists instructions for a project. Pagination is supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>
        listInstructions(com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstructionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an instruction object by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteInstruction(com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstructionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation by resource name (to search, use
     * [projects.evaluations.search][google.cloud.datalabeling.v1beta1.DataLabelingService.SearchEvaluations]).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.Evaluation>
        getEvaluation(com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches [evaluations][google.cloud.datalabeling.v1beta1.Evaluation] within a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>
        searchEvaluations(com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchEvaluationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches example comparisons from an evaluation. The return format is a
     * list of example comparisons that show ground truth and prediction(s) for
     * a single input. Search by providing an evaluation ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>
        searchExampleComparisons(
            com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchExampleComparisonsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an evaluation job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.EvaluationJob>
        createEvaluationJob(
            com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEvaluationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an evaluation job. You can only update certain fields of the job's
     * [EvaluationJobConfig][google.cloud.datalabeling.v1beta1.EvaluationJobConfig]: `humanAnnotationConfig.instruction`,
     * `exampleCount`, and `exampleSamplePercentage`.
     * If you want to change any other aspect of the evaluation job, you must
     * delete the job and create a new one.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.EvaluationJob>
        updateEvaluationJob(
            com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEvaluationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an evaluation job by resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.EvaluationJob>
        getEvaluationJob(com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEvaluationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses an evaluation job. Pausing an evaluation job that is already in a
     * `PAUSED` state is a no-op.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        pauseEvaluationJob(
            com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseEvaluationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused evaluation job. A deleted evaluation job can't be resumed.
     * Resuming a running or scheduled evaluation job is a no-op.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        resumeEvaluationJob(
            com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeEvaluationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops and deletes an evaluation job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEvaluationJob(
            com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEvaluationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all evaluation jobs within a project with possible filters.
     * Pagination is supported.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>
        listEvaluationJobs(
            com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEvaluationJobsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATASET = 0;
  private static final int METHODID_GET_DATASET = 1;
  private static final int METHODID_LIST_DATASETS = 2;
  private static final int METHODID_DELETE_DATASET = 3;
  private static final int METHODID_IMPORT_DATA = 4;
  private static final int METHODID_EXPORT_DATA = 5;
  private static final int METHODID_GET_DATA_ITEM = 6;
  private static final int METHODID_LIST_DATA_ITEMS = 7;
  private static final int METHODID_GET_ANNOTATED_DATASET = 8;
  private static final int METHODID_LIST_ANNOTATED_DATASETS = 9;
  private static final int METHODID_DELETE_ANNOTATED_DATASET = 10;
  private static final int METHODID_LABEL_IMAGE = 11;
  private static final int METHODID_LABEL_VIDEO = 12;
  private static final int METHODID_LABEL_TEXT = 13;
  private static final int METHODID_GET_EXAMPLE = 14;
  private static final int METHODID_LIST_EXAMPLES = 15;
  private static final int METHODID_CREATE_ANNOTATION_SPEC_SET = 16;
  private static final int METHODID_GET_ANNOTATION_SPEC_SET = 17;
  private static final int METHODID_LIST_ANNOTATION_SPEC_SETS = 18;
  private static final int METHODID_DELETE_ANNOTATION_SPEC_SET = 19;
  private static final int METHODID_CREATE_INSTRUCTION = 20;
  private static final int METHODID_GET_INSTRUCTION = 21;
  private static final int METHODID_LIST_INSTRUCTIONS = 22;
  private static final int METHODID_DELETE_INSTRUCTION = 23;
  private static final int METHODID_GET_EVALUATION = 24;
  private static final int METHODID_SEARCH_EVALUATIONS = 25;
  private static final int METHODID_SEARCH_EXAMPLE_COMPARISONS = 26;
  private static final int METHODID_CREATE_EVALUATION_JOB = 27;
  private static final int METHODID_UPDATE_EVALUATION_JOB = 28;
  private static final int METHODID_GET_EVALUATION_JOB = 29;
  private static final int METHODID_PAUSE_EVALUATION_JOB = 30;
  private static final int METHODID_RESUME_EVALUATION_JOB = 31;
  private static final int METHODID_DELETE_EVALUATION_JOB = 32;
  private static final int METHODID_LIST_EVALUATION_JOBS = 33;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataLabelingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataLabelingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DATASET:
          serviceImpl.createDataset(
              (com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Dataset>)
                  responseObserver);
          break;
        case METHODID_GET_DATASET:
          serviceImpl.getDataset(
              (com.google.cloud.datalabeling.v1beta1.GetDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Dataset>)
                  responseObserver);
          break;
        case METHODID_LIST_DATASETS:
          serviceImpl.listDatasets(
              (com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATASET:
          serviceImpl.deleteDataset(
              (com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_IMPORT_DATA:
          serviceImpl.importData(
              (com.google.cloud.datalabeling.v1beta1.ImportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_DATA:
          serviceImpl.exportData(
              (com.google.cloud.datalabeling.v1beta1.ExportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATA_ITEM:
          serviceImpl.getDataItem(
              (com.google.cloud.datalabeling.v1beta1.GetDataItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.DataItem>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_ITEMS:
          serviceImpl.listDataItems(
              (com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ANNOTATED_DATASET:
          serviceImpl.getAnnotatedDataset(
              (com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotatedDataset>)
                  responseObserver);
          break;
        case METHODID_LIST_ANNOTATED_DATASETS:
          serviceImpl.listAnnotatedDatasets(
              (com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ANNOTATED_DATASET:
          serviceImpl.deleteAnnotatedDataset(
              (com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LABEL_IMAGE:
          serviceImpl.labelImage(
              (com.google.cloud.datalabeling.v1beta1.LabelImageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LABEL_VIDEO:
          serviceImpl.labelVideo(
              (com.google.cloud.datalabeling.v1beta1.LabelVideoRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LABEL_TEXT:
          serviceImpl.labelText(
              (com.google.cloud.datalabeling.v1beta1.LabelTextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_EXAMPLE:
          serviceImpl.getExample(
              (com.google.cloud.datalabeling.v1beta1.GetExampleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Example>)
                  responseObserver);
          break;
        case METHODID_LIST_EXAMPLES:
          serviceImpl.listExamples(
              (com.google.cloud.datalabeling.v1beta1.ListExamplesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.ListExamplesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ANNOTATION_SPEC_SET:
          serviceImpl.createAnnotationSpecSet(
              (com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>)
                  responseObserver);
          break;
        case METHODID_GET_ANNOTATION_SPEC_SET:
          serviceImpl.getAnnotationSpecSet(
              (com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet>)
                  responseObserver);
          break;
        case METHODID_LIST_ANNOTATION_SPEC_SETS:
          serviceImpl.listAnnotationSpecSets(
              (com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ANNOTATION_SPEC_SET:
          serviceImpl.deleteAnnotationSpecSet(
              (com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_INSTRUCTION:
          serviceImpl.createInstruction(
              (com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INSTRUCTION:
          serviceImpl.getInstruction(
              (com.google.cloud.datalabeling.v1beta1.GetInstructionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Instruction>)
                  responseObserver);
          break;
        case METHODID_LIST_INSTRUCTIONS:
          serviceImpl.listInstructions(
              (com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_INSTRUCTION:
          serviceImpl.deleteInstruction(
              (com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_EVALUATION:
          serviceImpl.getEvaluation(
              (com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.Evaluation>)
                  responseObserver);
          break;
        case METHODID_SEARCH_EVALUATIONS:
          serviceImpl.searchEvaluations(
              (com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_EXAMPLE_COMPARISONS:
          serviceImpl.searchExampleComparisons(
              (com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_EVALUATION_JOB:
          serviceImpl.createEvaluationJob(
              (com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EVALUATION_JOB:
          serviceImpl.updateEvaluationJob(
              (com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>)
                  responseObserver);
          break;
        case METHODID_GET_EVALUATION_JOB:
          serviceImpl.getEvaluationJob(
              (com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datalabeling.v1beta1.EvaluationJob>)
                  responseObserver);
          break;
        case METHODID_PAUSE_EVALUATION_JOB:
          serviceImpl.pauseEvaluationJob(
              (com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESUME_EVALUATION_JOB:
          serviceImpl.resumeEvaluationJob(
              (com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_EVALUATION_JOB:
          serviceImpl.deleteEvaluationJob(
              (com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_EVALUATION_JOBS:
          serviceImpl.listEvaluationJobs(
              (com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse>)
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

  private abstract static class DataLabelingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataLabelingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datalabeling.v1beta1.DataLabelingServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataLabelingService");
    }
  }

  private static final class DataLabelingServiceFileDescriptorSupplier
      extends DataLabelingServiceBaseDescriptorSupplier {
    DataLabelingServiceFileDescriptorSupplier() {}
  }

  private static final class DataLabelingServiceMethodDescriptorSupplier
      extends DataLabelingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataLabelingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataLabelingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataLabelingServiceFileDescriptorSupplier())
                      .addMethod(getCreateDatasetMethod())
                      .addMethod(getGetDatasetMethod())
                      .addMethod(getListDatasetsMethod())
                      .addMethod(getDeleteDatasetMethod())
                      .addMethod(getImportDataMethod())
                      .addMethod(getExportDataMethod())
                      .addMethod(getGetDataItemMethod())
                      .addMethod(getListDataItemsMethod())
                      .addMethod(getGetAnnotatedDatasetMethod())
                      .addMethod(getListAnnotatedDatasetsMethod())
                      .addMethod(getDeleteAnnotatedDatasetMethod())
                      .addMethod(getLabelImageMethod())
                      .addMethod(getLabelVideoMethod())
                      .addMethod(getLabelTextMethod())
                      .addMethod(getGetExampleMethod())
                      .addMethod(getListExamplesMethod())
                      .addMethod(getCreateAnnotationSpecSetMethod())
                      .addMethod(getGetAnnotationSpecSetMethod())
                      .addMethod(getListAnnotationSpecSetsMethod())
                      .addMethod(getDeleteAnnotationSpecSetMethod())
                      .addMethod(getCreateInstructionMethod())
                      .addMethod(getGetInstructionMethod())
                      .addMethod(getListInstructionsMethod())
                      .addMethod(getDeleteInstructionMethod())
                      .addMethod(getGetEvaluationMethod())
                      .addMethod(getSearchEvaluationsMethod())
                      .addMethod(getSearchExampleComparisonsMethod())
                      .addMethod(getCreateEvaluationJobMethod())
                      .addMethod(getUpdateEvaluationJobMethod())
                      .addMethod(getGetEvaluationJobMethod())
                      .addMethod(getPauseEvaluationJobMethod())
                      .addMethod(getResumeEvaluationJobMethod())
                      .addMethod(getDeleteEvaluationJobMethod())
                      .addMethod(getListEvaluationJobsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
