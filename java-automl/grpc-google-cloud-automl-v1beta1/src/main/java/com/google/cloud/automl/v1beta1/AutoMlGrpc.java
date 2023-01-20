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
package com.google.cloud.automl.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * AutoML Server API.
 * The resource names are assigned by the server.
 * The server never reuses names that it has created after the resources with
 * those names are deleted.
 * An ID of a resource is the last element of the item's resource name. For
 * `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`, then
 * the id for the item is `{dataset_id}`.
 * Currently the only supported `location_id` is "us-central1".
 * On any input that is documented to expect a string parameter in
 * snake_case or kebab-case, either of those cases is accepted.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/automl/v1beta1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutoMlGrpc {

  private AutoMlGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.automl.v1beta1.AutoMl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.CreateDatasetRequest,
          com.google.cloud.automl.v1beta1.Dataset>
      getCreateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataset",
      requestType = com.google.cloud.automl.v1beta1.CreateDatasetRequest.class,
      responseType = com.google.cloud.automl.v1beta1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.CreateDatasetRequest,
          com.google.cloud.automl.v1beta1.Dataset>
      getCreateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.CreateDatasetRequest,
            com.google.cloud.automl.v1beta1.Dataset>
        getCreateDatasetMethod;
    if ((getCreateDatasetMethod = AutoMlGrpc.getCreateDatasetMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getCreateDatasetMethod = AutoMlGrpc.getCreateDatasetMethod) == null) {
          AutoMlGrpc.getCreateDatasetMethod =
              getCreateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.CreateDatasetRequest,
                          com.google.cloud.automl.v1beta1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.CreateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("CreateDataset"))
                      .build();
        }
      }
    }
    return getCreateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetDatasetRequest,
          com.google.cloud.automl.v1beta1.Dataset>
      getGetDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataset",
      requestType = com.google.cloud.automl.v1beta1.GetDatasetRequest.class,
      responseType = com.google.cloud.automl.v1beta1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetDatasetRequest,
          com.google.cloud.automl.v1beta1.Dataset>
      getGetDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.GetDatasetRequest,
            com.google.cloud.automl.v1beta1.Dataset>
        getGetDatasetMethod;
    if ((getGetDatasetMethod = AutoMlGrpc.getGetDatasetMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getGetDatasetMethod = AutoMlGrpc.getGetDatasetMethod) == null) {
          AutoMlGrpc.getGetDatasetMethod =
              getGetDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.GetDatasetRequest,
                          com.google.cloud.automl.v1beta1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.GetDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("GetDataset"))
                      .build();
        }
      }
    }
    return getGetDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListDatasetsRequest,
          com.google.cloud.automl.v1beta1.ListDatasetsResponse>
      getListDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatasets",
      requestType = com.google.cloud.automl.v1beta1.ListDatasetsRequest.class,
      responseType = com.google.cloud.automl.v1beta1.ListDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListDatasetsRequest,
          com.google.cloud.automl.v1beta1.ListDatasetsResponse>
      getListDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ListDatasetsRequest,
            com.google.cloud.automl.v1beta1.ListDatasetsResponse>
        getListDatasetsMethod;
    if ((getListDatasetsMethod = AutoMlGrpc.getListDatasetsMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getListDatasetsMethod = AutoMlGrpc.getListDatasetsMethod) == null) {
          AutoMlGrpc.getListDatasetsMethod =
              getListDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ListDatasetsRequest,
                          com.google.cloud.automl.v1beta1.ListDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("ListDatasets"))
                      .build();
        }
      }
    }
    return getListDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.UpdateDatasetRequest,
          com.google.cloud.automl.v1beta1.Dataset>
      getUpdateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataset",
      requestType = com.google.cloud.automl.v1beta1.UpdateDatasetRequest.class,
      responseType = com.google.cloud.automl.v1beta1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.UpdateDatasetRequest,
          com.google.cloud.automl.v1beta1.Dataset>
      getUpdateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.UpdateDatasetRequest,
            com.google.cloud.automl.v1beta1.Dataset>
        getUpdateDatasetMethod;
    if ((getUpdateDatasetMethod = AutoMlGrpc.getUpdateDatasetMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getUpdateDatasetMethod = AutoMlGrpc.getUpdateDatasetMethod) == null) {
          AutoMlGrpc.getUpdateDatasetMethod =
              getUpdateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.UpdateDatasetRequest,
                          com.google.cloud.automl.v1beta1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.UpdateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("UpdateDataset"))
                      .build();
        }
      }
    }
    return getUpdateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.DeleteDatasetRequest, com.google.longrunning.Operation>
      getDeleteDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataset",
      requestType = com.google.cloud.automl.v1beta1.DeleteDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.DeleteDatasetRequest, com.google.longrunning.Operation>
      getDeleteDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.DeleteDatasetRequest, com.google.longrunning.Operation>
        getDeleteDatasetMethod;
    if ((getDeleteDatasetMethod = AutoMlGrpc.getDeleteDatasetMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getDeleteDatasetMethod = AutoMlGrpc.getDeleteDatasetMethod) == null) {
          AutoMlGrpc.getDeleteDatasetMethod =
              getDeleteDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.DeleteDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.DeleteDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("DeleteDataset"))
                      .build();
        }
      }
    }
    return getDeleteDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportData",
      requestType = com.google.cloud.automl.v1beta1.ImportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ImportDataRequest, com.google.longrunning.Operation>
        getImportDataMethod;
    if ((getImportDataMethod = AutoMlGrpc.getImportDataMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getImportDataMethod = AutoMlGrpc.getImportDataMethod) == null) {
          AutoMlGrpc.getImportDataMethod =
              getImportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ImportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ImportDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("ImportData"))
                      .build();
        }
      }
    }
    return getImportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportData",
      requestType = com.google.cloud.automl.v1beta1.ExportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ExportDataRequest, com.google.longrunning.Operation>
        getExportDataMethod;
    if ((getExportDataMethod = AutoMlGrpc.getExportDataMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getExportDataMethod = AutoMlGrpc.getExportDataMethod) == null) {
          AutoMlGrpc.getExportDataMethod =
              getExportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ExportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ExportDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("ExportData"))
                      .build();
        }
      }
    }
    return getExportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest,
          com.google.cloud.automl.v1beta1.AnnotationSpec>
      getGetAnnotationSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnotationSpec",
      requestType = com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest.class,
      responseType = com.google.cloud.automl.v1beta1.AnnotationSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest,
          com.google.cloud.automl.v1beta1.AnnotationSpec>
      getGetAnnotationSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest,
            com.google.cloud.automl.v1beta1.AnnotationSpec>
        getGetAnnotationSpecMethod;
    if ((getGetAnnotationSpecMethod = AutoMlGrpc.getGetAnnotationSpecMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getGetAnnotationSpecMethod = AutoMlGrpc.getGetAnnotationSpecMethod) == null) {
          AutoMlGrpc.getGetAnnotationSpecMethod =
              getGetAnnotationSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest,
                          com.google.cloud.automl.v1beta1.AnnotationSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnnotationSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.AnnotationSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("GetAnnotationSpec"))
                      .build();
        }
      }
    }
    return getGetAnnotationSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetTableSpecRequest,
          com.google.cloud.automl.v1beta1.TableSpec>
      getGetTableSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTableSpec",
      requestType = com.google.cloud.automl.v1beta1.GetTableSpecRequest.class,
      responseType = com.google.cloud.automl.v1beta1.TableSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetTableSpecRequest,
          com.google.cloud.automl.v1beta1.TableSpec>
      getGetTableSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.GetTableSpecRequest,
            com.google.cloud.automl.v1beta1.TableSpec>
        getGetTableSpecMethod;
    if ((getGetTableSpecMethod = AutoMlGrpc.getGetTableSpecMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getGetTableSpecMethod = AutoMlGrpc.getGetTableSpecMethod) == null) {
          AutoMlGrpc.getGetTableSpecMethod =
              getGetTableSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.GetTableSpecRequest,
                          com.google.cloud.automl.v1beta1.TableSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTableSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.GetTableSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.TableSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("GetTableSpec"))
                      .build();
        }
      }
    }
    return getGetTableSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListTableSpecsRequest,
          com.google.cloud.automl.v1beta1.ListTableSpecsResponse>
      getListTableSpecsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTableSpecs",
      requestType = com.google.cloud.automl.v1beta1.ListTableSpecsRequest.class,
      responseType = com.google.cloud.automl.v1beta1.ListTableSpecsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListTableSpecsRequest,
          com.google.cloud.automl.v1beta1.ListTableSpecsResponse>
      getListTableSpecsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ListTableSpecsRequest,
            com.google.cloud.automl.v1beta1.ListTableSpecsResponse>
        getListTableSpecsMethod;
    if ((getListTableSpecsMethod = AutoMlGrpc.getListTableSpecsMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getListTableSpecsMethod = AutoMlGrpc.getListTableSpecsMethod) == null) {
          AutoMlGrpc.getListTableSpecsMethod =
              getListTableSpecsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ListTableSpecsRequest,
                          com.google.cloud.automl.v1beta1.ListTableSpecsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTableSpecs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListTableSpecsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListTableSpecsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("ListTableSpecs"))
                      .build();
        }
      }
    }
    return getListTableSpecsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.UpdateTableSpecRequest,
          com.google.cloud.automl.v1beta1.TableSpec>
      getUpdateTableSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTableSpec",
      requestType = com.google.cloud.automl.v1beta1.UpdateTableSpecRequest.class,
      responseType = com.google.cloud.automl.v1beta1.TableSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.UpdateTableSpecRequest,
          com.google.cloud.automl.v1beta1.TableSpec>
      getUpdateTableSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.UpdateTableSpecRequest,
            com.google.cloud.automl.v1beta1.TableSpec>
        getUpdateTableSpecMethod;
    if ((getUpdateTableSpecMethod = AutoMlGrpc.getUpdateTableSpecMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getUpdateTableSpecMethod = AutoMlGrpc.getUpdateTableSpecMethod) == null) {
          AutoMlGrpc.getUpdateTableSpecMethod =
              getUpdateTableSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.UpdateTableSpecRequest,
                          com.google.cloud.automl.v1beta1.TableSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTableSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.UpdateTableSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.TableSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("UpdateTableSpec"))
                      .build();
        }
      }
    }
    return getUpdateTableSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetColumnSpecRequest,
          com.google.cloud.automl.v1beta1.ColumnSpec>
      getGetColumnSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetColumnSpec",
      requestType = com.google.cloud.automl.v1beta1.GetColumnSpecRequest.class,
      responseType = com.google.cloud.automl.v1beta1.ColumnSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetColumnSpecRequest,
          com.google.cloud.automl.v1beta1.ColumnSpec>
      getGetColumnSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.GetColumnSpecRequest,
            com.google.cloud.automl.v1beta1.ColumnSpec>
        getGetColumnSpecMethod;
    if ((getGetColumnSpecMethod = AutoMlGrpc.getGetColumnSpecMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getGetColumnSpecMethod = AutoMlGrpc.getGetColumnSpecMethod) == null) {
          AutoMlGrpc.getGetColumnSpecMethod =
              getGetColumnSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.GetColumnSpecRequest,
                          com.google.cloud.automl.v1beta1.ColumnSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetColumnSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.GetColumnSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ColumnSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("GetColumnSpec"))
                      .build();
        }
      }
    }
    return getGetColumnSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListColumnSpecsRequest,
          com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>
      getListColumnSpecsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListColumnSpecs",
      requestType = com.google.cloud.automl.v1beta1.ListColumnSpecsRequest.class,
      responseType = com.google.cloud.automl.v1beta1.ListColumnSpecsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListColumnSpecsRequest,
          com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>
      getListColumnSpecsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ListColumnSpecsRequest,
            com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>
        getListColumnSpecsMethod;
    if ((getListColumnSpecsMethod = AutoMlGrpc.getListColumnSpecsMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getListColumnSpecsMethod = AutoMlGrpc.getListColumnSpecsMethod) == null) {
          AutoMlGrpc.getListColumnSpecsMethod =
              getListColumnSpecsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ListColumnSpecsRequest,
                          com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListColumnSpecs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListColumnSpecsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListColumnSpecsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("ListColumnSpecs"))
                      .build();
        }
      }
    }
    return getListColumnSpecsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest,
          com.google.cloud.automl.v1beta1.ColumnSpec>
      getUpdateColumnSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateColumnSpec",
      requestType = com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest.class,
      responseType = com.google.cloud.automl.v1beta1.ColumnSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest,
          com.google.cloud.automl.v1beta1.ColumnSpec>
      getUpdateColumnSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest,
            com.google.cloud.automl.v1beta1.ColumnSpec>
        getUpdateColumnSpecMethod;
    if ((getUpdateColumnSpecMethod = AutoMlGrpc.getUpdateColumnSpecMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getUpdateColumnSpecMethod = AutoMlGrpc.getUpdateColumnSpecMethod) == null) {
          AutoMlGrpc.getUpdateColumnSpecMethod =
              getUpdateColumnSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest,
                          com.google.cloud.automl.v1beta1.ColumnSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateColumnSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ColumnSpec.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("UpdateColumnSpec"))
                      .build();
        }
      }
    }
    return getUpdateColumnSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.CreateModelRequest, com.google.longrunning.Operation>
      getCreateModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateModel",
      requestType = com.google.cloud.automl.v1beta1.CreateModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.CreateModelRequest, com.google.longrunning.Operation>
      getCreateModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.CreateModelRequest, com.google.longrunning.Operation>
        getCreateModelMethod;
    if ((getCreateModelMethod = AutoMlGrpc.getCreateModelMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getCreateModelMethod = AutoMlGrpc.getCreateModelMethod) == null) {
          AutoMlGrpc.getCreateModelMethod =
              getCreateModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.CreateModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.CreateModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("CreateModel"))
                      .build();
        }
      }
    }
    return getCreateModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetModelRequest, com.google.cloud.automl.v1beta1.Model>
      getGetModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModel",
      requestType = com.google.cloud.automl.v1beta1.GetModelRequest.class,
      responseType = com.google.cloud.automl.v1beta1.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetModelRequest, com.google.cloud.automl.v1beta1.Model>
      getGetModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.GetModelRequest, com.google.cloud.automl.v1beta1.Model>
        getGetModelMethod;
    if ((getGetModelMethod = AutoMlGrpc.getGetModelMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getGetModelMethod = AutoMlGrpc.getGetModelMethod) == null) {
          AutoMlGrpc.getGetModelMethod =
              getGetModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.GetModelRequest,
                          com.google.cloud.automl.v1beta1.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.GetModelRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.Model.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("GetModel"))
                      .build();
        }
      }
    }
    return getGetModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListModelsRequest,
          com.google.cloud.automl.v1beta1.ListModelsResponse>
      getListModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModels",
      requestType = com.google.cloud.automl.v1beta1.ListModelsRequest.class,
      responseType = com.google.cloud.automl.v1beta1.ListModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListModelsRequest,
          com.google.cloud.automl.v1beta1.ListModelsResponse>
      getListModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ListModelsRequest,
            com.google.cloud.automl.v1beta1.ListModelsResponse>
        getListModelsMethod;
    if ((getListModelsMethod = AutoMlGrpc.getListModelsMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getListModelsMethod = AutoMlGrpc.getListModelsMethod) == null) {
          AutoMlGrpc.getListModelsMethod =
              getListModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ListModelsRequest,
                          com.google.cloud.automl.v1beta1.ListModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListModelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("ListModels"))
                      .build();
        }
      }
    }
    return getListModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.DeleteModelRequest, com.google.longrunning.Operation>
      getDeleteModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModel",
      requestType = com.google.cloud.automl.v1beta1.DeleteModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.DeleteModelRequest, com.google.longrunning.Operation>
      getDeleteModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.DeleteModelRequest, com.google.longrunning.Operation>
        getDeleteModelMethod;
    if ((getDeleteModelMethod = AutoMlGrpc.getDeleteModelMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getDeleteModelMethod = AutoMlGrpc.getDeleteModelMethod) == null) {
          AutoMlGrpc.getDeleteModelMethod =
              getDeleteModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.DeleteModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.DeleteModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("DeleteModel"))
                      .build();
        }
      }
    }
    return getDeleteModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.DeployModelRequest, com.google.longrunning.Operation>
      getDeployModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployModel",
      requestType = com.google.cloud.automl.v1beta1.DeployModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.DeployModelRequest, com.google.longrunning.Operation>
      getDeployModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.DeployModelRequest, com.google.longrunning.Operation>
        getDeployModelMethod;
    if ((getDeployModelMethod = AutoMlGrpc.getDeployModelMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getDeployModelMethod = AutoMlGrpc.getDeployModelMethod) == null) {
          AutoMlGrpc.getDeployModelMethod =
              getDeployModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.DeployModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.DeployModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("DeployModel"))
                      .build();
        }
      }
    }
    return getDeployModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.UndeployModelRequest, com.google.longrunning.Operation>
      getUndeployModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployModel",
      requestType = com.google.cloud.automl.v1beta1.UndeployModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.UndeployModelRequest, com.google.longrunning.Operation>
      getUndeployModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.UndeployModelRequest, com.google.longrunning.Operation>
        getUndeployModelMethod;
    if ((getUndeployModelMethod = AutoMlGrpc.getUndeployModelMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getUndeployModelMethod = AutoMlGrpc.getUndeployModelMethod) == null) {
          AutoMlGrpc.getUndeployModelMethod =
              getUndeployModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.UndeployModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeployModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.UndeployModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("UndeployModel"))
                      .build();
        }
      }
    }
    return getUndeployModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ExportModelRequest, com.google.longrunning.Operation>
      getExportModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportModel",
      requestType = com.google.cloud.automl.v1beta1.ExportModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ExportModelRequest, com.google.longrunning.Operation>
      getExportModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ExportModelRequest, com.google.longrunning.Operation>
        getExportModelMethod;
    if ((getExportModelMethod = AutoMlGrpc.getExportModelMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getExportModelMethod = AutoMlGrpc.getExportModelMethod) == null) {
          AutoMlGrpc.getExportModelMethod =
              getExportModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ExportModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ExportModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("ExportModel"))
                      .build();
        }
      }
    }
    return getExportModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest,
          com.google.longrunning.Operation>
      getExportEvaluatedExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportEvaluatedExamples",
      requestType = com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest,
          com.google.longrunning.Operation>
      getExportEvaluatedExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest,
            com.google.longrunning.Operation>
        getExportEvaluatedExamplesMethod;
    if ((getExportEvaluatedExamplesMethod = AutoMlGrpc.getExportEvaluatedExamplesMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getExportEvaluatedExamplesMethod = AutoMlGrpc.getExportEvaluatedExamplesMethod)
            == null) {
          AutoMlGrpc.getExportEvaluatedExamplesMethod =
              getExportEvaluatedExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportEvaluatedExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutoMlMethodDescriptorSupplier("ExportEvaluatedExamples"))
                      .build();
        }
      }
    }
    return getExportEvaluatedExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetModelEvaluationRequest,
          com.google.cloud.automl.v1beta1.ModelEvaluation>
      getGetModelEvaluationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModelEvaluation",
      requestType = com.google.cloud.automl.v1beta1.GetModelEvaluationRequest.class,
      responseType = com.google.cloud.automl.v1beta1.ModelEvaluation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.GetModelEvaluationRequest,
          com.google.cloud.automl.v1beta1.ModelEvaluation>
      getGetModelEvaluationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.GetModelEvaluationRequest,
            com.google.cloud.automl.v1beta1.ModelEvaluation>
        getGetModelEvaluationMethod;
    if ((getGetModelEvaluationMethod = AutoMlGrpc.getGetModelEvaluationMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getGetModelEvaluationMethod = AutoMlGrpc.getGetModelEvaluationMethod) == null) {
          AutoMlGrpc.getGetModelEvaluationMethod =
              getGetModelEvaluationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.GetModelEvaluationRequest,
                          com.google.cloud.automl.v1beta1.ModelEvaluation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModelEvaluation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.GetModelEvaluationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ModelEvaluation.getDefaultInstance()))
                      .setSchemaDescriptor(new AutoMlMethodDescriptorSupplier("GetModelEvaluation"))
                      .build();
        }
      }
    }
    return getGetModelEvaluationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest,
          com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>
      getListModelEvaluationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModelEvaluations",
      requestType = com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest.class,
      responseType = com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest,
          com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>
      getListModelEvaluationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest,
            com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>
        getListModelEvaluationsMethod;
    if ((getListModelEvaluationsMethod = AutoMlGrpc.getListModelEvaluationsMethod) == null) {
      synchronized (AutoMlGrpc.class) {
        if ((getListModelEvaluationsMethod = AutoMlGrpc.getListModelEvaluationsMethod) == null) {
          AutoMlGrpc.getListModelEvaluationsMethod =
              getListModelEvaluationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest,
                          com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListModelEvaluations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutoMlMethodDescriptorSupplier("ListModelEvaluations"))
                      .build();
        }
      }
    }
    return getListModelEvaluationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AutoMlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoMlStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutoMlStub>() {
          @java.lang.Override
          public AutoMlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutoMlStub(channel, callOptions);
          }
        };
    return AutoMlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutoMlBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoMlBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutoMlBlockingStub>() {
          @java.lang.Override
          public AutoMlBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutoMlBlockingStub(channel, callOptions);
          }
        };
    return AutoMlBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AutoMlFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoMlFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AutoMlFutureStub>() {
          @java.lang.Override
          public AutoMlFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AutoMlFutureStub(channel, callOptions);
          }
        };
    return AutoMlFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * AutoML Server API.
   * The resource names are assigned by the server.
   * The server never reuses names that it has created after the resources with
   * those names are deleted.
   * An ID of a resource is the last element of the item's resource name. For
   * `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`, then
   * the id for the item is `{dataset_id}`.
   * Currently the only supported `location_id` is "us-central1".
   * On any input that is documented to expect a string parameter in
   * snake_case or kebab-case, either of those cases is accepted.
   * </pre>
   */
  public abstract static class AutoMlImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a dataset.
     * </pre>
     */
    public void createDataset(
        com.google.cloud.automl.v1beta1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a dataset.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.automl.v1beta1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets in a project.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.automl.v1beta1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataset.
     * </pre>
     */
    public void updateDataset(
        com.google.cloud.automl.v1beta1.UpdateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset and all of its contents.
     * Returns empty response in the
     * [response][google.longrunning.Operation.response] field when it completes,
     * and `delete_details` in the
     * [metadata][google.longrunning.Operation.metadata] field.
     * </pre>
     */
    public void deleteDataset(
        com.google.cloud.automl.v1beta1.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a dataset.
     * For Tables this method can only be called on an empty Dataset.
     * For Tables:
     * *   A
     * [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params]
     *     parameter must be explicitly set.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void importData(
        com.google.cloud.automl.v1beta1.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports dataset's data to the provided output location.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void exportData(
        com.google.cloud.automl.v1beta1.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotation spec.
     * </pre>
     */
    public void getAnnotationSpec(
        com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.AnnotationSpec>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnnotationSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a table spec.
     * </pre>
     */
    public void getTableSpec(
        com.google.cloud.automl.v1beta1.GetTableSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.TableSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTableSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists table specs in a dataset.
     * </pre>
     */
    public void listTableSpecs(
        com.google.cloud.automl.v1beta1.ListTableSpecsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListTableSpecsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTableSpecsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a table spec.
     * </pre>
     */
    public void updateTableSpec(
        com.google.cloud.automl.v1beta1.UpdateTableSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.TableSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTableSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a column spec.
     * </pre>
     */
    public void getColumnSpec(
        com.google.cloud.automl.v1beta1.GetColumnSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ColumnSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetColumnSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists column specs in a table spec.
     * </pre>
     */
    public void listColumnSpecs(
        com.google.cloud.automl.v1beta1.ListColumnSpecsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListColumnSpecsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a column spec.
     * </pre>
     */
    public void updateColumnSpec(
        com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ColumnSpec> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateColumnSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a model.
     * Returns a Model in the [response][google.longrunning.Operation.response]
     * field when it completes.
     * When you create a model, several model evaluations are created for it:
     * a global evaluation, and one evaluation for each annotation spec.
     * </pre>
     */
    public void createModel(
        com.google.cloud.automl.v1beta1.CreateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public void getModel(
        com.google.cloud.automl.v1beta1.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public void listModels(
        com.google.cloud.automl.v1beta1.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListModelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * Returns `google.protobuf.Empty` in the
     * [response][google.longrunning.Operation.response] field when it completes,
     * and `delete_details` in the
     * [metadata][google.longrunning.Operation.metadata] field.
     * </pre>
     */
    public void deleteModel(
        com.google.cloud.automl.v1beta1.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model. If a model is already deployed, deploying it with the
     * same parameters has no effect. Deploying with different parametrs
     * (as e.g. changing
     * [node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
     *  will reset the deployment state without pausing the model's availability.
     * Only applicable for Text Classification, Image Object Detection , Tables, and Image Segmentation; all other domains manage
     * deployment automatically.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void deployModel(
        com.google.cloud.automl.v1beta1.DeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a model. If the model is not deployed this method has no effect.
     * Only applicable for Text Classification, Image Object Detection and Tables;
     * all other domains manage deployment automatically.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void undeployModel(
        com.google.cloud.automl.v1beta1.UndeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a trained, "export-able", model to a user specified Google Cloud
     * Storage location. A model is considered export-able if and only if it has
     * an export format defined for it in
     * [ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void exportModel(
        com.google.cloud.automl.v1beta1.ExportModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports examples on which the model was evaluated (i.e. which were in the
     * TEST set of the dataset the model was created from), together with their
     * ground truth annotations and the annotations created (predicted) by the
     * model.
     * The examples, ground truth and predictions are exported in the state
     * they were at the moment the model was evaluated.
     * This export is available only for 30 days since the model evaluation is
     * created.
     * Currently only available for Tables.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void exportEvaluatedExamples(
        com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportEvaluatedExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a model evaluation.
     * </pre>
     */
    public void getModelEvaluation(
        com.google.cloud.automl.v1beta1.GetModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ModelEvaluation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetModelEvaluationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists model evaluations.
     * </pre>
     */
    public void listModelEvaluations(
        com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListModelEvaluationsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.CreateDatasetRequest,
                      com.google.cloud.automl.v1beta1.Dataset>(this, METHODID_CREATE_DATASET)))
          .addMethod(
              getGetDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.GetDatasetRequest,
                      com.google.cloud.automl.v1beta1.Dataset>(this, METHODID_GET_DATASET)))
          .addMethod(
              getListDatasetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ListDatasetsRequest,
                      com.google.cloud.automl.v1beta1.ListDatasetsResponse>(
                      this, METHODID_LIST_DATASETS)))
          .addMethod(
              getUpdateDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.UpdateDatasetRequest,
                      com.google.cloud.automl.v1beta1.Dataset>(this, METHODID_UPDATE_DATASET)))
          .addMethod(
              getDeleteDatasetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.DeleteDatasetRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_DATASET)))
          .addMethod(
              getImportDataMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ImportDataRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_DATA)))
          .addMethod(
              getExportDataMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ExportDataRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_DATA)))
          .addMethod(
              getGetAnnotationSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest,
                      com.google.cloud.automl.v1beta1.AnnotationSpec>(
                      this, METHODID_GET_ANNOTATION_SPEC)))
          .addMethod(
              getGetTableSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.GetTableSpecRequest,
                      com.google.cloud.automl.v1beta1.TableSpec>(this, METHODID_GET_TABLE_SPEC)))
          .addMethod(
              getListTableSpecsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ListTableSpecsRequest,
                      com.google.cloud.automl.v1beta1.ListTableSpecsResponse>(
                      this, METHODID_LIST_TABLE_SPECS)))
          .addMethod(
              getUpdateTableSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.UpdateTableSpecRequest,
                      com.google.cloud.automl.v1beta1.TableSpec>(this, METHODID_UPDATE_TABLE_SPEC)))
          .addMethod(
              getGetColumnSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.GetColumnSpecRequest,
                      com.google.cloud.automl.v1beta1.ColumnSpec>(this, METHODID_GET_COLUMN_SPEC)))
          .addMethod(
              getListColumnSpecsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ListColumnSpecsRequest,
                      com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>(
                      this, METHODID_LIST_COLUMN_SPECS)))
          .addMethod(
              getUpdateColumnSpecMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest,
                      com.google.cloud.automl.v1beta1.ColumnSpec>(
                      this, METHODID_UPDATE_COLUMN_SPEC)))
          .addMethod(
              getCreateModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.CreateModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_MODEL)))
          .addMethod(
              getGetModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.GetModelRequest,
                      com.google.cloud.automl.v1beta1.Model>(this, METHODID_GET_MODEL)))
          .addMethod(
              getListModelsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ListModelsRequest,
                      com.google.cloud.automl.v1beta1.ListModelsResponse>(
                      this, METHODID_LIST_MODELS)))
          .addMethod(
              getDeleteModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.DeleteModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_MODEL)))
          .addMethod(
              getDeployModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.DeployModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_DEPLOY_MODEL)))
          .addMethod(
              getUndeployModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.UndeployModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDEPLOY_MODEL)))
          .addMethod(
              getExportModelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ExportModelRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_MODEL)))
          .addMethod(
              getExportEvaluatedExamplesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_EVALUATED_EXAMPLES)))
          .addMethod(
              getGetModelEvaluationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.GetModelEvaluationRequest,
                      com.google.cloud.automl.v1beta1.ModelEvaluation>(
                      this, METHODID_GET_MODEL_EVALUATION)))
          .addMethod(
              getListModelEvaluationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest,
                      com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>(
                      this, METHODID_LIST_MODEL_EVALUATIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * AutoML Server API.
   * The resource names are assigned by the server.
   * The server never reuses names that it has created after the resources with
   * those names are deleted.
   * An ID of a resource is the last element of the item's resource name. For
   * `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`, then
   * the id for the item is `{dataset_id}`.
   * Currently the only supported `location_id` is "us-central1".
   * On any input that is documented to expect a string parameter in
   * snake_case or kebab-case, either of those cases is accepted.
   * </pre>
   */
  public static final class AutoMlStub extends io.grpc.stub.AbstractAsyncStub<AutoMlStub> {
    private AutoMlStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoMlStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoMlStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset.
     * </pre>
     */
    public void createDataset(
        com.google.cloud.automl.v1beta1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a dataset.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.automl.v1beta1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets in a project.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.automl.v1beta1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListDatasetsResponse>
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
     * Updates a dataset.
     * </pre>
     */
    public void updateDataset(
        com.google.cloud.automl.v1beta1.UpdateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset and all of its contents.
     * Returns empty response in the
     * [response][google.longrunning.Operation.response] field when it completes,
     * and `delete_details` in the
     * [metadata][google.longrunning.Operation.metadata] field.
     * </pre>
     */
    public void deleteDataset(
        com.google.cloud.automl.v1beta1.DeleteDatasetRequest request,
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
     * Imports data into a dataset.
     * For Tables this method can only be called on an empty Dataset.
     * For Tables:
     * *   A
     * [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params]
     *     parameter must be explicitly set.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void importData(
        com.google.cloud.automl.v1beta1.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports dataset's data to the provided output location.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void exportData(
        com.google.cloud.automl.v1beta1.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotation spec.
     * </pre>
     */
    public void getAnnotationSpec(
        com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.AnnotationSpec>
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
     * Gets a table spec.
     * </pre>
     */
    public void getTableSpec(
        com.google.cloud.automl.v1beta1.GetTableSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.TableSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTableSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists table specs in a dataset.
     * </pre>
     */
    public void listTableSpecs(
        com.google.cloud.automl.v1beta1.ListTableSpecsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListTableSpecsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTableSpecsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a table spec.
     * </pre>
     */
    public void updateTableSpec(
        com.google.cloud.automl.v1beta1.UpdateTableSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.TableSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTableSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a column spec.
     * </pre>
     */
    public void getColumnSpec(
        com.google.cloud.automl.v1beta1.GetColumnSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ColumnSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetColumnSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists column specs in a table spec.
     * </pre>
     */
    public void listColumnSpecs(
        com.google.cloud.automl.v1beta1.ListColumnSpecsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListColumnSpecsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a column spec.
     * </pre>
     */
    public void updateColumnSpec(
        com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ColumnSpec> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateColumnSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a model.
     * Returns a Model in the [response][google.longrunning.Operation.response]
     * field when it completes.
     * When you create a model, several model evaluations are created for it:
     * a global evaluation, and one evaluation for each annotation spec.
     * </pre>
     */
    public void createModel(
        com.google.cloud.automl.v1beta1.CreateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public void getModel(
        com.google.cloud.automl.v1beta1.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public void listModels(
        com.google.cloud.automl.v1beta1.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * Returns `google.protobuf.Empty` in the
     * [response][google.longrunning.Operation.response] field when it completes,
     * and `delete_details` in the
     * [metadata][google.longrunning.Operation.metadata] field.
     * </pre>
     */
    public void deleteModel(
        com.google.cloud.automl.v1beta1.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model. If a model is already deployed, deploying it with the
     * same parameters has no effect. Deploying with different parametrs
     * (as e.g. changing
     * [node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
     *  will reset the deployment state without pausing the model's availability.
     * Only applicable for Text Classification, Image Object Detection , Tables, and Image Segmentation; all other domains manage
     * deployment automatically.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void deployModel(
        com.google.cloud.automl.v1beta1.DeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a model. If the model is not deployed this method has no effect.
     * Only applicable for Text Classification, Image Object Detection and Tables;
     * all other domains manage deployment automatically.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void undeployModel(
        com.google.cloud.automl.v1beta1.UndeployModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a trained, "export-able", model to a user specified Google Cloud
     * Storage location. A model is considered export-able if and only if it has
     * an export format defined for it in
     * [ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void exportModel(
        com.google.cloud.automl.v1beta1.ExportModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports examples on which the model was evaluated (i.e. which were in the
     * TEST set of the dataset the model was created from), together with their
     * ground truth annotations and the annotations created (predicted) by the
     * model.
     * The examples, ground truth and predictions are exported in the state
     * they were at the moment the model was evaluated.
     * This export is available only for 30 days since the model evaluation is
     * created.
     * Currently only available for Tables.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public void exportEvaluatedExamples(
        com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportEvaluatedExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a model evaluation.
     * </pre>
     */
    public void getModelEvaluation(
        com.google.cloud.automl.v1beta1.GetModelEvaluationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ModelEvaluation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelEvaluationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists model evaluations.
     * </pre>
     */
    public void listModelEvaluations(
        com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelEvaluationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * AutoML Server API.
   * The resource names are assigned by the server.
   * The server never reuses names that it has created after the resources with
   * those names are deleted.
   * An ID of a resource is the last element of the item's resource name. For
   * `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`, then
   * the id for the item is `{dataset_id}`.
   * Currently the only supported `location_id` is "us-central1".
   * On any input that is documented to expect a string parameter in
   * snake_case or kebab-case, either of those cases is accepted.
   * </pre>
   */
  public static final class AutoMlBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AutoMlBlockingStub> {
    private AutoMlBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoMlBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoMlBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.Dataset createDataset(
        com.google.cloud.automl.v1beta1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a dataset.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.Dataset getDataset(
        com.google.cloud.automl.v1beta1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets in a project.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.ListDatasetsResponse listDatasets(
        com.google.cloud.automl.v1beta1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataset.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.Dataset updateDataset(
        com.google.cloud.automl.v1beta1.UpdateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset and all of its contents.
     * Returns empty response in the
     * [response][google.longrunning.Operation.response] field when it completes,
     * and `delete_details` in the
     * [metadata][google.longrunning.Operation.metadata] field.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataset(
        com.google.cloud.automl.v1beta1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a dataset.
     * For Tables this method can only be called on an empty Dataset.
     * For Tables:
     * *   A
     * [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params]
     *     parameter must be explicitly set.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.longrunning.Operation importData(
        com.google.cloud.automl.v1beta1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports dataset's data to the provided output location.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.longrunning.Operation exportData(
        com.google.cloud.automl.v1beta1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotation spec.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.AnnotationSpec getAnnotationSpec(
        com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnotationSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a table spec.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.TableSpec getTableSpec(
        com.google.cloud.automl.v1beta1.GetTableSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTableSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists table specs in a dataset.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.ListTableSpecsResponse listTableSpecs(
        com.google.cloud.automl.v1beta1.ListTableSpecsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTableSpecsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a table spec.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.TableSpec updateTableSpec(
        com.google.cloud.automl.v1beta1.UpdateTableSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTableSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a column spec.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.ColumnSpec getColumnSpec(
        com.google.cloud.automl.v1beta1.GetColumnSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetColumnSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists column specs in a table spec.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.ListColumnSpecsResponse listColumnSpecs(
        com.google.cloud.automl.v1beta1.ListColumnSpecsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListColumnSpecsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a column spec.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.ColumnSpec updateColumnSpec(
        com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateColumnSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a model.
     * Returns a Model in the [response][google.longrunning.Operation.response]
     * field when it completes.
     * When you create a model, several model evaluations are created for it:
     * a global evaluation, and one evaluation for each annotation spec.
     * </pre>
     */
    public com.google.longrunning.Operation createModel(
        com.google.cloud.automl.v1beta1.CreateModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.Model getModel(
        com.google.cloud.automl.v1beta1.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.ListModelsResponse listModels(
        com.google.cloud.automl.v1beta1.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * Returns `google.protobuf.Empty` in the
     * [response][google.longrunning.Operation.response] field when it completes,
     * and `delete_details` in the
     * [metadata][google.longrunning.Operation.metadata] field.
     * </pre>
     */
    public com.google.longrunning.Operation deleteModel(
        com.google.cloud.automl.v1beta1.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model. If a model is already deployed, deploying it with the
     * same parameters has no effect. Deploying with different parametrs
     * (as e.g. changing
     * [node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
     *  will reset the deployment state without pausing the model's availability.
     * Only applicable for Text Classification, Image Object Detection , Tables, and Image Segmentation; all other domains manage
     * deployment automatically.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.longrunning.Operation deployModel(
        com.google.cloud.automl.v1beta1.DeployModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a model. If the model is not deployed this method has no effect.
     * Only applicable for Text Classification, Image Object Detection and Tables;
     * all other domains manage deployment automatically.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.longrunning.Operation undeployModel(
        com.google.cloud.automl.v1beta1.UndeployModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a trained, "export-able", model to a user specified Google Cloud
     * Storage location. A model is considered export-able if and only if it has
     * an export format defined for it in
     * [ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.longrunning.Operation exportModel(
        com.google.cloud.automl.v1beta1.ExportModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports examples on which the model was evaluated (i.e. which were in the
     * TEST set of the dataset the model was created from), together with their
     * ground truth annotations and the annotations created (predicted) by the
     * model.
     * The examples, ground truth and predictions are exported in the state
     * they were at the moment the model was evaluated.
     * This export is available only for 30 days since the model evaluation is
     * created.
     * Currently only available for Tables.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.longrunning.Operation exportEvaluatedExamples(
        com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportEvaluatedExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a model evaluation.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.ModelEvaluation getModelEvaluation(
        com.google.cloud.automl.v1beta1.GetModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelEvaluationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists model evaluations.
     * </pre>
     */
    public com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse listModelEvaluations(
        com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelEvaluationsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * AutoML Server API.
   * The resource names are assigned by the server.
   * The server never reuses names that it has created after the resources with
   * those names are deleted.
   * An ID of a resource is the last element of the item's resource name. For
   * `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`, then
   * the id for the item is `{dataset_id}`.
   * Currently the only supported `location_id` is "us-central1".
   * On any input that is documented to expect a string parameter in
   * snake_case or kebab-case, either of those cases is accepted.
   * </pre>
   */
  public static final class AutoMlFutureStub
      extends io.grpc.stub.AbstractFutureStub<AutoMlFutureStub> {
    private AutoMlFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoMlFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoMlFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.Dataset>
        createDataset(com.google.cloud.automl.v1beta1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.Dataset>
        getDataset(com.google.cloud.automl.v1beta1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.ListDatasetsResponse>
        listDatasets(com.google.cloud.automl.v1beta1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.Dataset>
        updateDataset(com.google.cloud.automl.v1beta1.UpdateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset and all of its contents.
     * Returns empty response in the
     * [response][google.longrunning.Operation.response] field when it completes,
     * and `delete_details` in the
     * [metadata][google.longrunning.Operation.metadata] field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataset(com.google.cloud.automl.v1beta1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a dataset.
     * For Tables this method can only be called on an empty Dataset.
     * For Tables:
     * *   A
     * [schema_inference_version][google.cloud.automl.v1beta1.InputConfig.params]
     *     parameter must be explicitly set.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importData(com.google.cloud.automl.v1beta1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports dataset's data to the provided output location.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportData(com.google.cloud.automl.v1beta1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an annotation spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.AnnotationSpec>
        getAnnotationSpec(com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnotationSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a table spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.TableSpec>
        getTableSpec(com.google.cloud.automl.v1beta1.GetTableSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTableSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists table specs in a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.ListTableSpecsResponse>
        listTableSpecs(com.google.cloud.automl.v1beta1.ListTableSpecsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTableSpecsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a table spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.TableSpec>
        updateTableSpec(com.google.cloud.automl.v1beta1.UpdateTableSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTableSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a column spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.ColumnSpec>
        getColumnSpec(com.google.cloud.automl.v1beta1.GetColumnSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetColumnSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists column specs in a table spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>
        listColumnSpecs(com.google.cloud.automl.v1beta1.ListColumnSpecsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListColumnSpecsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a column spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.ColumnSpec>
        updateColumnSpec(com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateColumnSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a model.
     * Returns a Model in the [response][google.longrunning.Operation.response]
     * field when it completes.
     * When you create a model, several model evaluations are created for it:
     * a global evaluation, and one evaluation for each annotation spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createModel(com.google.cloud.automl.v1beta1.CreateModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.automl.v1beta1.Model>
        getModel(com.google.cloud.automl.v1beta1.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.ListModelsResponse>
        listModels(com.google.cloud.automl.v1beta1.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * Returns `google.protobuf.Empty` in the
     * [response][google.longrunning.Operation.response] field when it completes,
     * and `delete_details` in the
     * [metadata][google.longrunning.Operation.metadata] field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteModel(com.google.cloud.automl.v1beta1.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a model. If a model is already deployed, deploying it with the
     * same parameters has no effect. Deploying with different parametrs
     * (as e.g. changing
     * [node_number][google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata.node_number])
     *  will reset the deployment state without pausing the model's availability.
     * Only applicable for Text Classification, Image Object Detection , Tables, and Image Segmentation; all other domains manage
     * deployment automatically.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployModel(com.google.cloud.automl.v1beta1.DeployModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a model. If the model is not deployed this method has no effect.
     * Only applicable for Text Classification, Image Object Detection and Tables;
     * all other domains manage deployment automatically.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeployModel(com.google.cloud.automl.v1beta1.UndeployModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a trained, "export-able", model to a user specified Google Cloud
     * Storage location. A model is considered export-able if and only if it has
     * an export format defined for it in
     * [ModelExportOutputConfig][google.cloud.automl.v1beta1.ModelExportOutputConfig].
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportModel(com.google.cloud.automl.v1beta1.ExportModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports examples on which the model was evaluated (i.e. which were in the
     * TEST set of the dataset the model was created from), together with their
     * ground truth annotations and the annotations created (predicted) by the
     * model.
     * The examples, ground truth and predictions are exported in the state
     * they were at the moment the model was evaluated.
     * This export is available only for 30 days since the model evaluation is
     * created.
     * Currently only available for Tables.
     * Returns an empty response in the
     * [response][google.longrunning.Operation.response] field when it completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportEvaluatedExamples(
            com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportEvaluatedExamplesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a model evaluation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.ModelEvaluation>
        getModelEvaluation(com.google.cloud.automl.v1beta1.GetModelEvaluationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelEvaluationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists model evaluations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>
        listModelEvaluations(com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelEvaluationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATASET = 0;
  private static final int METHODID_GET_DATASET = 1;
  private static final int METHODID_LIST_DATASETS = 2;
  private static final int METHODID_UPDATE_DATASET = 3;
  private static final int METHODID_DELETE_DATASET = 4;
  private static final int METHODID_IMPORT_DATA = 5;
  private static final int METHODID_EXPORT_DATA = 6;
  private static final int METHODID_GET_ANNOTATION_SPEC = 7;
  private static final int METHODID_GET_TABLE_SPEC = 8;
  private static final int METHODID_LIST_TABLE_SPECS = 9;
  private static final int METHODID_UPDATE_TABLE_SPEC = 10;
  private static final int METHODID_GET_COLUMN_SPEC = 11;
  private static final int METHODID_LIST_COLUMN_SPECS = 12;
  private static final int METHODID_UPDATE_COLUMN_SPEC = 13;
  private static final int METHODID_CREATE_MODEL = 14;
  private static final int METHODID_GET_MODEL = 15;
  private static final int METHODID_LIST_MODELS = 16;
  private static final int METHODID_DELETE_MODEL = 17;
  private static final int METHODID_DEPLOY_MODEL = 18;
  private static final int METHODID_UNDEPLOY_MODEL = 19;
  private static final int METHODID_EXPORT_MODEL = 20;
  private static final int METHODID_EXPORT_EVALUATED_EXAMPLES = 21;
  private static final int METHODID_GET_MODEL_EVALUATION = 22;
  private static final int METHODID_LIST_MODEL_EVALUATIONS = 23;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AutoMlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AutoMlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DATASET:
          serviceImpl.createDataset(
              (com.google.cloud.automl.v1beta1.CreateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset>)
                  responseObserver);
          break;
        case METHODID_GET_DATASET:
          serviceImpl.getDataset(
              (com.google.cloud.automl.v1beta1.GetDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset>)
                  responseObserver);
          break;
        case METHODID_LIST_DATASETS:
          serviceImpl.listDatasets(
              (com.google.cloud.automl.v1beta1.ListDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATASET:
          serviceImpl.updateDataset(
              (com.google.cloud.automl.v1beta1.UpdateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Dataset>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATASET:
          serviceImpl.deleteDataset(
              (com.google.cloud.automl.v1beta1.DeleteDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_DATA:
          serviceImpl.importData(
              (com.google.cloud.automl.v1beta1.ImportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_DATA:
          serviceImpl.exportData(
              (com.google.cloud.automl.v1beta1.ExportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ANNOTATION_SPEC:
          serviceImpl.getAnnotationSpec(
              (com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.AnnotationSpec>)
                  responseObserver);
          break;
        case METHODID_GET_TABLE_SPEC:
          serviceImpl.getTableSpec(
              (com.google.cloud.automl.v1beta1.GetTableSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.TableSpec>)
                  responseObserver);
          break;
        case METHODID_LIST_TABLE_SPECS:
          serviceImpl.listTableSpecs(
              (com.google.cloud.automl.v1beta1.ListTableSpecsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListTableSpecsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TABLE_SPEC:
          serviceImpl.updateTableSpec(
              (com.google.cloud.automl.v1beta1.UpdateTableSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.TableSpec>)
                  responseObserver);
          break;
        case METHODID_GET_COLUMN_SPEC:
          serviceImpl.getColumnSpec(
              (com.google.cloud.automl.v1beta1.GetColumnSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ColumnSpec>)
                  responseObserver);
          break;
        case METHODID_LIST_COLUMN_SPECS:
          serviceImpl.listColumnSpecs(
              (com.google.cloud.automl.v1beta1.ListColumnSpecsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListColumnSpecsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_COLUMN_SPEC:
          serviceImpl.updateColumnSpec(
              (com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ColumnSpec>)
                  responseObserver);
          break;
        case METHODID_CREATE_MODEL:
          serviceImpl.createModel(
              (com.google.cloud.automl.v1beta1.CreateModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_MODEL:
          serviceImpl.getModel(
              (com.google.cloud.automl.v1beta1.GetModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.Model>)
                  responseObserver);
          break;
        case METHODID_LIST_MODELS:
          serviceImpl.listModels(
              (com.google.cloud.automl.v1beta1.ListModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ListModelsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_MODEL:
          serviceImpl.deleteModel(
              (com.google.cloud.automl.v1beta1.DeleteModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_MODEL:
          serviceImpl.deployModel(
              (com.google.cloud.automl.v1beta1.DeployModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_MODEL:
          serviceImpl.undeployModel(
              (com.google.cloud.automl.v1beta1.UndeployModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_MODEL:
          serviceImpl.exportModel(
              (com.google.cloud.automl.v1beta1.ExportModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_EVALUATED_EXAMPLES:
          serviceImpl.exportEvaluatedExamples(
              (com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_MODEL_EVALUATION:
          serviceImpl.getModelEvaluation(
              (com.google.cloud.automl.v1beta1.GetModelEvaluationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.automl.v1beta1.ModelEvaluation>)
                  responseObserver);
          break;
        case METHODID_LIST_MODEL_EVALUATIONS:
          serviceImpl.listModelEvaluations(
              (com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse>)
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

  private abstract static class AutoMlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutoMlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.automl.v1beta1.AutoMlProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutoMl");
    }
  }

  private static final class AutoMlFileDescriptorSupplier extends AutoMlBaseDescriptorSupplier {
    AutoMlFileDescriptorSupplier() {}
  }

  private static final class AutoMlMethodDescriptorSupplier extends AutoMlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AutoMlMethodDescriptorSupplier(String methodName) {
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
      synchronized (AutoMlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AutoMlFileDescriptorSupplier())
                      .addMethod(getCreateDatasetMethod())
                      .addMethod(getGetDatasetMethod())
                      .addMethod(getListDatasetsMethod())
                      .addMethod(getUpdateDatasetMethod())
                      .addMethod(getDeleteDatasetMethod())
                      .addMethod(getImportDataMethod())
                      .addMethod(getExportDataMethod())
                      .addMethod(getGetAnnotationSpecMethod())
                      .addMethod(getGetTableSpecMethod())
                      .addMethod(getListTableSpecsMethod())
                      .addMethod(getUpdateTableSpecMethod())
                      .addMethod(getGetColumnSpecMethod())
                      .addMethod(getListColumnSpecsMethod())
                      .addMethod(getUpdateColumnSpecMethod())
                      .addMethod(getCreateModelMethod())
                      .addMethod(getGetModelMethod())
                      .addMethod(getListModelsMethod())
                      .addMethod(getDeleteModelMethod())
                      .addMethod(getDeployModelMethod())
                      .addMethod(getUndeployModelMethod())
                      .addMethod(getExportModelMethod())
                      .addMethod(getExportEvaluatedExamplesMethod())
                      .addMethod(getGetModelEvaluationMethod())
                      .addMethod(getListModelEvaluationsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
