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
package com.google.cloud.financialservices.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The AML (Anti Money Laundering) service allows users to perform REST
 * operations on aml.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/financialservices/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AMLGrpc {

  private AMLGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.financialservices.v1.AML";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListInstancesRequest,
          com.google.cloud.financialservices.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.financialservices.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.financialservices.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListInstancesRequest,
          com.google.cloud.financialservices.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ListInstancesRequest,
            com.google.cloud.financialservices.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = AMLGrpc.getListInstancesMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getListInstancesMethod = AMLGrpc.getListInstancesMethod) == null) {
          AMLGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ListInstancesRequest,
                          com.google.cloud.financialservices.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetInstanceRequest,
          com.google.cloud.financialservices.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.financialservices.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.financialservices.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetInstanceRequest,
          com.google.cloud.financialservices.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.GetInstanceRequest,
            com.google.cloud.financialservices.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = AMLGrpc.getGetInstanceMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getGetInstanceMethod = AMLGrpc.getGetInstanceMethod) == null) {
          AMLGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.GetInstanceRequest,
                          com.google.cloud.financialservices.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateInstanceRequest,
          com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.financialservices.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateInstanceRequest,
          com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.CreateInstanceRequest,
            com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = AMLGrpc.getCreateInstanceMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getCreateInstanceMethod = AMLGrpc.getCreateInstanceMethod) == null) {
          AMLGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateInstanceRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.financialservices.v1.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateInstanceRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.UpdateInstanceRequest,
            com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = AMLGrpc.getUpdateInstanceMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getUpdateInstanceMethod = AMLGrpc.getUpdateInstanceMethod) == null) {
          AMLGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.UpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteInstanceRequest,
          com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.financialservices.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteInstanceRequest,
          com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.DeleteInstanceRequest,
            com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = AMLGrpc.getDeleteInstanceMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getDeleteInstanceMethod = AMLGrpc.getDeleteInstanceMethod) == null) {
          AMLGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest,
          com.google.longrunning.Operation>
      getImportRegisteredPartiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportRegisteredParties",
      requestType = com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest,
          com.google.longrunning.Operation>
      getImportRegisteredPartiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest,
            com.google.longrunning.Operation>
        getImportRegisteredPartiesMethod;
    if ((getImportRegisteredPartiesMethod = AMLGrpc.getImportRegisteredPartiesMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getImportRegisteredPartiesMethod = AMLGrpc.getImportRegisteredPartiesMethod) == null) {
          AMLGrpc.getImportRegisteredPartiesMethod =
              getImportRegisteredPartiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportRegisteredParties"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AMLMethodDescriptorSupplier("ImportRegisteredParties"))
                      .build();
        }
      }
    }
    return getImportRegisteredPartiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest,
          com.google.longrunning.Operation>
      getExportRegisteredPartiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportRegisteredParties",
      requestType = com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest,
          com.google.longrunning.Operation>
      getExportRegisteredPartiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest,
            com.google.longrunning.Operation>
        getExportRegisteredPartiesMethod;
    if ((getExportRegisteredPartiesMethod = AMLGrpc.getExportRegisteredPartiesMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getExportRegisteredPartiesMethod = AMLGrpc.getExportRegisteredPartiesMethod) == null) {
          AMLGrpc.getExportRegisteredPartiesMethod =
              getExportRegisteredPartiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportRegisteredParties"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AMLMethodDescriptorSupplier("ExportRegisteredParties"))
                      .build();
        }
      }
    }
    return getExportRegisteredPartiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListDatasetsRequest,
          com.google.cloud.financialservices.v1.ListDatasetsResponse>
      getListDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatasets",
      requestType = com.google.cloud.financialservices.v1.ListDatasetsRequest.class,
      responseType = com.google.cloud.financialservices.v1.ListDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListDatasetsRequest,
          com.google.cloud.financialservices.v1.ListDatasetsResponse>
      getListDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ListDatasetsRequest,
            com.google.cloud.financialservices.v1.ListDatasetsResponse>
        getListDatasetsMethod;
    if ((getListDatasetsMethod = AMLGrpc.getListDatasetsMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getListDatasetsMethod = AMLGrpc.getListDatasetsMethod) == null) {
          AMLGrpc.getListDatasetsMethod =
              getListDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ListDatasetsRequest,
                          com.google.cloud.financialservices.v1.ListDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("ListDatasets"))
                      .build();
        }
      }
    }
    return getListDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetDatasetRequest,
          com.google.cloud.financialservices.v1.Dataset>
      getGetDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataset",
      requestType = com.google.cloud.financialservices.v1.GetDatasetRequest.class,
      responseType = com.google.cloud.financialservices.v1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetDatasetRequest,
          com.google.cloud.financialservices.v1.Dataset>
      getGetDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.GetDatasetRequest,
            com.google.cloud.financialservices.v1.Dataset>
        getGetDatasetMethod;
    if ((getGetDatasetMethod = AMLGrpc.getGetDatasetMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getGetDatasetMethod = AMLGrpc.getGetDatasetMethod) == null) {
          AMLGrpc.getGetDatasetMethod =
              getGetDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.GetDatasetRequest,
                          com.google.cloud.financialservices.v1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.GetDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("GetDataset"))
                      .build();
        }
      }
    }
    return getGetDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateDatasetRequest,
          com.google.longrunning.Operation>
      getCreateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataset",
      requestType = com.google.cloud.financialservices.v1.CreateDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateDatasetRequest,
          com.google.longrunning.Operation>
      getCreateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.CreateDatasetRequest,
            com.google.longrunning.Operation>
        getCreateDatasetMethod;
    if ((getCreateDatasetMethod = AMLGrpc.getCreateDatasetMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getCreateDatasetMethod = AMLGrpc.getCreateDatasetMethod) == null) {
          AMLGrpc.getCreateDatasetMethod =
              getCreateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.CreateDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.CreateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("CreateDataset"))
                      .build();
        }
      }
    }
    return getCreateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateDatasetRequest,
          com.google.longrunning.Operation>
      getUpdateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataset",
      requestType = com.google.cloud.financialservices.v1.UpdateDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateDatasetRequest,
          com.google.longrunning.Operation>
      getUpdateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.UpdateDatasetRequest,
            com.google.longrunning.Operation>
        getUpdateDatasetMethod;
    if ((getUpdateDatasetMethod = AMLGrpc.getUpdateDatasetMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getUpdateDatasetMethod = AMLGrpc.getUpdateDatasetMethod) == null) {
          AMLGrpc.getUpdateDatasetMethod =
              getUpdateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.UpdateDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.UpdateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("UpdateDataset"))
                      .build();
        }
      }
    }
    return getUpdateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteDatasetRequest,
          com.google.longrunning.Operation>
      getDeleteDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataset",
      requestType = com.google.cloud.financialservices.v1.DeleteDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteDatasetRequest,
          com.google.longrunning.Operation>
      getDeleteDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.DeleteDatasetRequest,
            com.google.longrunning.Operation>
        getDeleteDatasetMethod;
    if ((getDeleteDatasetMethod = AMLGrpc.getDeleteDatasetMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getDeleteDatasetMethod = AMLGrpc.getDeleteDatasetMethod) == null) {
          AMLGrpc.getDeleteDatasetMethod =
              getDeleteDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.DeleteDatasetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.DeleteDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("DeleteDataset"))
                      .build();
        }
      }
    }
    return getDeleteDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListModelsRequest,
          com.google.cloud.financialservices.v1.ListModelsResponse>
      getListModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModels",
      requestType = com.google.cloud.financialservices.v1.ListModelsRequest.class,
      responseType = com.google.cloud.financialservices.v1.ListModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListModelsRequest,
          com.google.cloud.financialservices.v1.ListModelsResponse>
      getListModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ListModelsRequest,
            com.google.cloud.financialservices.v1.ListModelsResponse>
        getListModelsMethod;
    if ((getListModelsMethod = AMLGrpc.getListModelsMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getListModelsMethod = AMLGrpc.getListModelsMethod) == null) {
          AMLGrpc.getListModelsMethod =
              getListModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ListModelsRequest,
                          com.google.cloud.financialservices.v1.ListModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListModelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("ListModels"))
                      .build();
        }
      }
    }
    return getListModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetModelRequest,
          com.google.cloud.financialservices.v1.Model>
      getGetModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModel",
      requestType = com.google.cloud.financialservices.v1.GetModelRequest.class,
      responseType = com.google.cloud.financialservices.v1.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetModelRequest,
          com.google.cloud.financialservices.v1.Model>
      getGetModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.GetModelRequest,
            com.google.cloud.financialservices.v1.Model>
        getGetModelMethod;
    if ((getGetModelMethod = AMLGrpc.getGetModelMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getGetModelMethod = AMLGrpc.getGetModelMethod) == null) {
          AMLGrpc.getGetModelMethod =
              getGetModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.GetModelRequest,
                          com.google.cloud.financialservices.v1.Model>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.GetModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.Model.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("GetModel"))
                      .build();
        }
      }
    }
    return getGetModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateModelRequest,
          com.google.longrunning.Operation>
      getCreateModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateModel",
      requestType = com.google.cloud.financialservices.v1.CreateModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateModelRequest,
          com.google.longrunning.Operation>
      getCreateModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.CreateModelRequest,
            com.google.longrunning.Operation>
        getCreateModelMethod;
    if ((getCreateModelMethod = AMLGrpc.getCreateModelMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getCreateModelMethod = AMLGrpc.getCreateModelMethod) == null) {
          AMLGrpc.getCreateModelMethod =
              getCreateModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.CreateModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.CreateModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("CreateModel"))
                      .build();
        }
      }
    }
    return getCreateModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateModelRequest,
          com.google.longrunning.Operation>
      getUpdateModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateModel",
      requestType = com.google.cloud.financialservices.v1.UpdateModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateModelRequest,
          com.google.longrunning.Operation>
      getUpdateModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.UpdateModelRequest,
            com.google.longrunning.Operation>
        getUpdateModelMethod;
    if ((getUpdateModelMethod = AMLGrpc.getUpdateModelMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getUpdateModelMethod = AMLGrpc.getUpdateModelMethod) == null) {
          AMLGrpc.getUpdateModelMethod =
              getUpdateModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.UpdateModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.UpdateModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("UpdateModel"))
                      .build();
        }
      }
    }
    return getUpdateModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportModelMetadataRequest,
          com.google.longrunning.Operation>
      getExportModelMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportModelMetadata",
      requestType = com.google.cloud.financialservices.v1.ExportModelMetadataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportModelMetadataRequest,
          com.google.longrunning.Operation>
      getExportModelMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ExportModelMetadataRequest,
            com.google.longrunning.Operation>
        getExportModelMetadataMethod;
    if ((getExportModelMetadataMethod = AMLGrpc.getExportModelMetadataMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getExportModelMetadataMethod = AMLGrpc.getExportModelMetadataMethod) == null) {
          AMLGrpc.getExportModelMetadataMethod =
              getExportModelMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ExportModelMetadataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportModelMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ExportModelMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("ExportModelMetadata"))
                      .build();
        }
      }
    }
    return getExportModelMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteModelRequest,
          com.google.longrunning.Operation>
      getDeleteModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteModel",
      requestType = com.google.cloud.financialservices.v1.DeleteModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteModelRequest,
          com.google.longrunning.Operation>
      getDeleteModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.DeleteModelRequest,
            com.google.longrunning.Operation>
        getDeleteModelMethod;
    if ((getDeleteModelMethod = AMLGrpc.getDeleteModelMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getDeleteModelMethod = AMLGrpc.getDeleteModelMethod) == null) {
          AMLGrpc.getDeleteModelMethod =
              getDeleteModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.DeleteModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.DeleteModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("DeleteModel"))
                      .build();
        }
      }
    }
    return getDeleteModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListEngineConfigsRequest,
          com.google.cloud.financialservices.v1.ListEngineConfigsResponse>
      getListEngineConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEngineConfigs",
      requestType = com.google.cloud.financialservices.v1.ListEngineConfigsRequest.class,
      responseType = com.google.cloud.financialservices.v1.ListEngineConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListEngineConfigsRequest,
          com.google.cloud.financialservices.v1.ListEngineConfigsResponse>
      getListEngineConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ListEngineConfigsRequest,
            com.google.cloud.financialservices.v1.ListEngineConfigsResponse>
        getListEngineConfigsMethod;
    if ((getListEngineConfigsMethod = AMLGrpc.getListEngineConfigsMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getListEngineConfigsMethod = AMLGrpc.getListEngineConfigsMethod) == null) {
          AMLGrpc.getListEngineConfigsMethod =
              getListEngineConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ListEngineConfigsRequest,
                          com.google.cloud.financialservices.v1.ListEngineConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEngineConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListEngineConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListEngineConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("ListEngineConfigs"))
                      .build();
        }
      }
    }
    return getListEngineConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetEngineConfigRequest,
          com.google.cloud.financialservices.v1.EngineConfig>
      getGetEngineConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEngineConfig",
      requestType = com.google.cloud.financialservices.v1.GetEngineConfigRequest.class,
      responseType = com.google.cloud.financialservices.v1.EngineConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetEngineConfigRequest,
          com.google.cloud.financialservices.v1.EngineConfig>
      getGetEngineConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.GetEngineConfigRequest,
            com.google.cloud.financialservices.v1.EngineConfig>
        getGetEngineConfigMethod;
    if ((getGetEngineConfigMethod = AMLGrpc.getGetEngineConfigMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getGetEngineConfigMethod = AMLGrpc.getGetEngineConfigMethod) == null) {
          AMLGrpc.getGetEngineConfigMethod =
              getGetEngineConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.GetEngineConfigRequest,
                          com.google.cloud.financialservices.v1.EngineConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEngineConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.GetEngineConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.EngineConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("GetEngineConfig"))
                      .build();
        }
      }
    }
    return getGetEngineConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateEngineConfigRequest,
          com.google.longrunning.Operation>
      getCreateEngineConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEngineConfig",
      requestType = com.google.cloud.financialservices.v1.CreateEngineConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateEngineConfigRequest,
          com.google.longrunning.Operation>
      getCreateEngineConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.CreateEngineConfigRequest,
            com.google.longrunning.Operation>
        getCreateEngineConfigMethod;
    if ((getCreateEngineConfigMethod = AMLGrpc.getCreateEngineConfigMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getCreateEngineConfigMethod = AMLGrpc.getCreateEngineConfigMethod) == null) {
          AMLGrpc.getCreateEngineConfigMethod =
              getCreateEngineConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.CreateEngineConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEngineConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.CreateEngineConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("CreateEngineConfig"))
                      .build();
        }
      }
    }
    return getCreateEngineConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateEngineConfigRequest,
          com.google.longrunning.Operation>
      getUpdateEngineConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEngineConfig",
      requestType = com.google.cloud.financialservices.v1.UpdateEngineConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateEngineConfigRequest,
          com.google.longrunning.Operation>
      getUpdateEngineConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.UpdateEngineConfigRequest,
            com.google.longrunning.Operation>
        getUpdateEngineConfigMethod;
    if ((getUpdateEngineConfigMethod = AMLGrpc.getUpdateEngineConfigMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getUpdateEngineConfigMethod = AMLGrpc.getUpdateEngineConfigMethod) == null) {
          AMLGrpc.getUpdateEngineConfigMethod =
              getUpdateEngineConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.UpdateEngineConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEngineConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.UpdateEngineConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("UpdateEngineConfig"))
                      .build();
        }
      }
    }
    return getUpdateEngineConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest,
          com.google.longrunning.Operation>
      getExportEngineConfigMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportEngineConfigMetadata",
      requestType = com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest,
          com.google.longrunning.Operation>
      getExportEngineConfigMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest,
            com.google.longrunning.Operation>
        getExportEngineConfigMetadataMethod;
    if ((getExportEngineConfigMetadataMethod = AMLGrpc.getExportEngineConfigMetadataMethod)
        == null) {
      synchronized (AMLGrpc.class) {
        if ((getExportEngineConfigMetadataMethod = AMLGrpc.getExportEngineConfigMetadataMethod)
            == null) {
          AMLGrpc.getExportEngineConfigMetadataMethod =
              getExportEngineConfigMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportEngineConfigMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1
                                  .ExportEngineConfigMetadataRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AMLMethodDescriptorSupplier("ExportEngineConfigMetadata"))
                      .build();
        }
      }
    }
    return getExportEngineConfigMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteEngineConfigRequest,
          com.google.longrunning.Operation>
      getDeleteEngineConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEngineConfig",
      requestType = com.google.cloud.financialservices.v1.DeleteEngineConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteEngineConfigRequest,
          com.google.longrunning.Operation>
      getDeleteEngineConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.DeleteEngineConfigRequest,
            com.google.longrunning.Operation>
        getDeleteEngineConfigMethod;
    if ((getDeleteEngineConfigMethod = AMLGrpc.getDeleteEngineConfigMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getDeleteEngineConfigMethod = AMLGrpc.getDeleteEngineConfigMethod) == null) {
          AMLGrpc.getDeleteEngineConfigMethod =
              getDeleteEngineConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.DeleteEngineConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEngineConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.DeleteEngineConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("DeleteEngineConfig"))
                      .build();
        }
      }
    }
    return getDeleteEngineConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetEngineVersionRequest,
          com.google.cloud.financialservices.v1.EngineVersion>
      getGetEngineVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEngineVersion",
      requestType = com.google.cloud.financialservices.v1.GetEngineVersionRequest.class,
      responseType = com.google.cloud.financialservices.v1.EngineVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetEngineVersionRequest,
          com.google.cloud.financialservices.v1.EngineVersion>
      getGetEngineVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.GetEngineVersionRequest,
            com.google.cloud.financialservices.v1.EngineVersion>
        getGetEngineVersionMethod;
    if ((getGetEngineVersionMethod = AMLGrpc.getGetEngineVersionMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getGetEngineVersionMethod = AMLGrpc.getGetEngineVersionMethod) == null) {
          AMLGrpc.getGetEngineVersionMethod =
              getGetEngineVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.GetEngineVersionRequest,
                          com.google.cloud.financialservices.v1.EngineVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEngineVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.GetEngineVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.EngineVersion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("GetEngineVersion"))
                      .build();
        }
      }
    }
    return getGetEngineVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListEngineVersionsRequest,
          com.google.cloud.financialservices.v1.ListEngineVersionsResponse>
      getListEngineVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEngineVersions",
      requestType = com.google.cloud.financialservices.v1.ListEngineVersionsRequest.class,
      responseType = com.google.cloud.financialservices.v1.ListEngineVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListEngineVersionsRequest,
          com.google.cloud.financialservices.v1.ListEngineVersionsResponse>
      getListEngineVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ListEngineVersionsRequest,
            com.google.cloud.financialservices.v1.ListEngineVersionsResponse>
        getListEngineVersionsMethod;
    if ((getListEngineVersionsMethod = AMLGrpc.getListEngineVersionsMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getListEngineVersionsMethod = AMLGrpc.getListEngineVersionsMethod) == null) {
          AMLGrpc.getListEngineVersionsMethod =
              getListEngineVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ListEngineVersionsRequest,
                          com.google.cloud.financialservices.v1.ListEngineVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEngineVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListEngineVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListEngineVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("ListEngineVersions"))
                      .build();
        }
      }
    }
    return getListEngineVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListPredictionResultsRequest,
          com.google.cloud.financialservices.v1.ListPredictionResultsResponse>
      getListPredictionResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPredictionResults",
      requestType = com.google.cloud.financialservices.v1.ListPredictionResultsRequest.class,
      responseType = com.google.cloud.financialservices.v1.ListPredictionResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListPredictionResultsRequest,
          com.google.cloud.financialservices.v1.ListPredictionResultsResponse>
      getListPredictionResultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ListPredictionResultsRequest,
            com.google.cloud.financialservices.v1.ListPredictionResultsResponse>
        getListPredictionResultsMethod;
    if ((getListPredictionResultsMethod = AMLGrpc.getListPredictionResultsMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getListPredictionResultsMethod = AMLGrpc.getListPredictionResultsMethod) == null) {
          AMLGrpc.getListPredictionResultsMethod =
              getListPredictionResultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ListPredictionResultsRequest,
                          com.google.cloud.financialservices.v1.ListPredictionResultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPredictionResults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListPredictionResultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListPredictionResultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("ListPredictionResults"))
                      .build();
        }
      }
    }
    return getListPredictionResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetPredictionResultRequest,
          com.google.cloud.financialservices.v1.PredictionResult>
      getGetPredictionResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPredictionResult",
      requestType = com.google.cloud.financialservices.v1.GetPredictionResultRequest.class,
      responseType = com.google.cloud.financialservices.v1.PredictionResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetPredictionResultRequest,
          com.google.cloud.financialservices.v1.PredictionResult>
      getGetPredictionResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.GetPredictionResultRequest,
            com.google.cloud.financialservices.v1.PredictionResult>
        getGetPredictionResultMethod;
    if ((getGetPredictionResultMethod = AMLGrpc.getGetPredictionResultMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getGetPredictionResultMethod = AMLGrpc.getGetPredictionResultMethod) == null) {
          AMLGrpc.getGetPredictionResultMethod =
              getGetPredictionResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.GetPredictionResultRequest,
                          com.google.cloud.financialservices.v1.PredictionResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPredictionResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.GetPredictionResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.PredictionResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("GetPredictionResult"))
                      .build();
        }
      }
    }
    return getGetPredictionResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreatePredictionResultRequest,
          com.google.longrunning.Operation>
      getCreatePredictionResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePredictionResult",
      requestType = com.google.cloud.financialservices.v1.CreatePredictionResultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreatePredictionResultRequest,
          com.google.longrunning.Operation>
      getCreatePredictionResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.CreatePredictionResultRequest,
            com.google.longrunning.Operation>
        getCreatePredictionResultMethod;
    if ((getCreatePredictionResultMethod = AMLGrpc.getCreatePredictionResultMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getCreatePredictionResultMethod = AMLGrpc.getCreatePredictionResultMethod) == null) {
          AMLGrpc.getCreatePredictionResultMethod =
              getCreatePredictionResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.CreatePredictionResultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePredictionResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.CreatePredictionResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AMLMethodDescriptorSupplier("CreatePredictionResult"))
                      .build();
        }
      }
    }
    return getCreatePredictionResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdatePredictionResultRequest,
          com.google.longrunning.Operation>
      getUpdatePredictionResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePredictionResult",
      requestType = com.google.cloud.financialservices.v1.UpdatePredictionResultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdatePredictionResultRequest,
          com.google.longrunning.Operation>
      getUpdatePredictionResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.UpdatePredictionResultRequest,
            com.google.longrunning.Operation>
        getUpdatePredictionResultMethod;
    if ((getUpdatePredictionResultMethod = AMLGrpc.getUpdatePredictionResultMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getUpdatePredictionResultMethod = AMLGrpc.getUpdatePredictionResultMethod) == null) {
          AMLGrpc.getUpdatePredictionResultMethod =
              getUpdatePredictionResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.UpdatePredictionResultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdatePredictionResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.UpdatePredictionResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AMLMethodDescriptorSupplier("UpdatePredictionResult"))
                      .build();
        }
      }
    }
    return getUpdatePredictionResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest,
          com.google.longrunning.Operation>
      getExportPredictionResultMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportPredictionResultMetadata",
      requestType =
          com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest,
          com.google.longrunning.Operation>
      getExportPredictionResultMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest,
            com.google.longrunning.Operation>
        getExportPredictionResultMetadataMethod;
    if ((getExportPredictionResultMetadataMethod = AMLGrpc.getExportPredictionResultMetadataMethod)
        == null) {
      synchronized (AMLGrpc.class) {
        if ((getExportPredictionResultMetadataMethod =
                AMLGrpc.getExportPredictionResultMetadataMethod)
            == null) {
          AMLGrpc.getExportPredictionResultMetadataMethod =
              getExportPredictionResultMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportPredictionResultMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1
                                  .ExportPredictionResultMetadataRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AMLMethodDescriptorSupplier("ExportPredictionResultMetadata"))
                      .build();
        }
      }
    }
    return getExportPredictionResultMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeletePredictionResultRequest,
          com.google.longrunning.Operation>
      getDeletePredictionResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePredictionResult",
      requestType = com.google.cloud.financialservices.v1.DeletePredictionResultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeletePredictionResultRequest,
          com.google.longrunning.Operation>
      getDeletePredictionResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.DeletePredictionResultRequest,
            com.google.longrunning.Operation>
        getDeletePredictionResultMethod;
    if ((getDeletePredictionResultMethod = AMLGrpc.getDeletePredictionResultMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getDeletePredictionResultMethod = AMLGrpc.getDeletePredictionResultMethod) == null) {
          AMLGrpc.getDeletePredictionResultMethod =
              getDeletePredictionResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.DeletePredictionResultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePredictionResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.DeletePredictionResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AMLMethodDescriptorSupplier("DeletePredictionResult"))
                      .build();
        }
      }
    }
    return getDeletePredictionResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListBacktestResultsRequest,
          com.google.cloud.financialservices.v1.ListBacktestResultsResponse>
      getListBacktestResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBacktestResults",
      requestType = com.google.cloud.financialservices.v1.ListBacktestResultsRequest.class,
      responseType = com.google.cloud.financialservices.v1.ListBacktestResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ListBacktestResultsRequest,
          com.google.cloud.financialservices.v1.ListBacktestResultsResponse>
      getListBacktestResultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ListBacktestResultsRequest,
            com.google.cloud.financialservices.v1.ListBacktestResultsResponse>
        getListBacktestResultsMethod;
    if ((getListBacktestResultsMethod = AMLGrpc.getListBacktestResultsMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getListBacktestResultsMethod = AMLGrpc.getListBacktestResultsMethod) == null) {
          AMLGrpc.getListBacktestResultsMethod =
              getListBacktestResultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ListBacktestResultsRequest,
                          com.google.cloud.financialservices.v1.ListBacktestResultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBacktestResults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListBacktestResultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.ListBacktestResultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("ListBacktestResults"))
                      .build();
        }
      }
    }
    return getListBacktestResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetBacktestResultRequest,
          com.google.cloud.financialservices.v1.BacktestResult>
      getGetBacktestResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBacktestResult",
      requestType = com.google.cloud.financialservices.v1.GetBacktestResultRequest.class,
      responseType = com.google.cloud.financialservices.v1.BacktestResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.GetBacktestResultRequest,
          com.google.cloud.financialservices.v1.BacktestResult>
      getGetBacktestResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.GetBacktestResultRequest,
            com.google.cloud.financialservices.v1.BacktestResult>
        getGetBacktestResultMethod;
    if ((getGetBacktestResultMethod = AMLGrpc.getGetBacktestResultMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getGetBacktestResultMethod = AMLGrpc.getGetBacktestResultMethod) == null) {
          AMLGrpc.getGetBacktestResultMethod =
              getGetBacktestResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.GetBacktestResultRequest,
                          com.google.cloud.financialservices.v1.BacktestResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBacktestResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.GetBacktestResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.BacktestResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("GetBacktestResult"))
                      .build();
        }
      }
    }
    return getGetBacktestResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateBacktestResultRequest,
          com.google.longrunning.Operation>
      getCreateBacktestResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBacktestResult",
      requestType = com.google.cloud.financialservices.v1.CreateBacktestResultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.CreateBacktestResultRequest,
          com.google.longrunning.Operation>
      getCreateBacktestResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.CreateBacktestResultRequest,
            com.google.longrunning.Operation>
        getCreateBacktestResultMethod;
    if ((getCreateBacktestResultMethod = AMLGrpc.getCreateBacktestResultMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getCreateBacktestResultMethod = AMLGrpc.getCreateBacktestResultMethod) == null) {
          AMLGrpc.getCreateBacktestResultMethod =
              getCreateBacktestResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.CreateBacktestResultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBacktestResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.CreateBacktestResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("CreateBacktestResult"))
                      .build();
        }
      }
    }
    return getCreateBacktestResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateBacktestResultRequest,
          com.google.longrunning.Operation>
      getUpdateBacktestResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBacktestResult",
      requestType = com.google.cloud.financialservices.v1.UpdateBacktestResultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.UpdateBacktestResultRequest,
          com.google.longrunning.Operation>
      getUpdateBacktestResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.UpdateBacktestResultRequest,
            com.google.longrunning.Operation>
        getUpdateBacktestResultMethod;
    if ((getUpdateBacktestResultMethod = AMLGrpc.getUpdateBacktestResultMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getUpdateBacktestResultMethod = AMLGrpc.getUpdateBacktestResultMethod) == null) {
          AMLGrpc.getUpdateBacktestResultMethod =
              getUpdateBacktestResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.UpdateBacktestResultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBacktestResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.UpdateBacktestResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("UpdateBacktestResult"))
                      .build();
        }
      }
    }
    return getUpdateBacktestResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest,
          com.google.longrunning.Operation>
      getExportBacktestResultMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportBacktestResultMetadata",
      requestType = com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest,
          com.google.longrunning.Operation>
      getExportBacktestResultMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest,
            com.google.longrunning.Operation>
        getExportBacktestResultMetadataMethod;
    if ((getExportBacktestResultMetadataMethod = AMLGrpc.getExportBacktestResultMetadataMethod)
        == null) {
      synchronized (AMLGrpc.class) {
        if ((getExportBacktestResultMetadataMethod = AMLGrpc.getExportBacktestResultMetadataMethod)
            == null) {
          AMLGrpc.getExportBacktestResultMetadataMethod =
              getExportBacktestResultMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportBacktestResultMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1
                                  .ExportBacktestResultMetadataRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AMLMethodDescriptorSupplier("ExportBacktestResultMetadata"))
                      .build();
        }
      }
    }
    return getExportBacktestResultMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteBacktestResultRequest,
          com.google.longrunning.Operation>
      getDeleteBacktestResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBacktestResult",
      requestType = com.google.cloud.financialservices.v1.DeleteBacktestResultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.financialservices.v1.DeleteBacktestResultRequest,
          com.google.longrunning.Operation>
      getDeleteBacktestResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.financialservices.v1.DeleteBacktestResultRequest,
            com.google.longrunning.Operation>
        getDeleteBacktestResultMethod;
    if ((getDeleteBacktestResultMethod = AMLGrpc.getDeleteBacktestResultMethod) == null) {
      synchronized (AMLGrpc.class) {
        if ((getDeleteBacktestResultMethod = AMLGrpc.getDeleteBacktestResultMethod) == null) {
          AMLGrpc.getDeleteBacktestResultMethod =
              getDeleteBacktestResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.financialservices.v1.DeleteBacktestResultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBacktestResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.financialservices.v1.DeleteBacktestResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AMLMethodDescriptorSupplier("DeleteBacktestResult"))
                      .build();
        }
      }
    }
    return getDeleteBacktestResultMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AMLStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AMLStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AMLStub>() {
          @java.lang.Override
          public AMLStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AMLStub(channel, callOptions);
          }
        };
    return AMLStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AMLBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AMLBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AMLBlockingStub>() {
          @java.lang.Override
          public AMLBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AMLBlockingStub(channel, callOptions);
          }
        };
    return AMLBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AMLFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AMLFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AMLFutureStub>() {
          @java.lang.Override
          public AMLFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AMLFutureStub(channel, callOptions);
          }
        };
    return AMLFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The AML (Anti Money Laundering) service allows users to perform REST
   * operations on aml.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists instances.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.financialservices.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an instance.
     * </pre>
     */
    default void getInstance(
        com.google.cloud.financialservices.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Instance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an instance.
     * </pre>
     */
    default void createInstance(
        com.google.cloud.financialservices.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    default void updateInstance(
        com.google.cloud.financialservices.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an instance.
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.financialservices.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the list of registered parties. See
     * [Create and manage
     * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
     * for information on the input schema and response for this method.
     * </pre>
     */
    default void importRegisteredParties(
        com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportRegisteredPartiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the list of registered parties. See
     * [Create and manage
     * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
     * for information on the output schema for this method.
     * </pre>
     */
    default void exportRegisteredParties(
        com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportRegisteredPartiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets.
     * </pre>
     */
    default void listDatasets(
        com.google.cloud.financialservices.v1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a dataset.
     * </pre>
     */
    default void getDataset(
        com.google.cloud.financialservices.v1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Dataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset.
     * </pre>
     */
    default void createDataset(
        com.google.cloud.financialservices.v1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Dataset.
     * </pre>
     */
    default void updateDataset(
        com.google.cloud.financialservices.v1.UpdateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset.
     * </pre>
     */
    default void deleteDataset(
        com.google.cloud.financialservices.v1.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    default void listModels(
        com.google.cloud.financialservices.v1.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListModelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    default void getModel(
        com.google.cloud.financialservices.v1.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a model.
     * </pre>
     */
    default void createModel(
        com.google.cloud.financialservices.v1.CreateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Model.
     * </pre>
     */
    default void updateModel(
        com.google.cloud.financialservices.v1.UpdateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a Model resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
     * </pre>
     */
    default void exportModelMetadata(
        com.google.cloud.financialservices.v1.ExportModelMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportModelMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * </pre>
     */
    default void deleteModel(
        com.google.cloud.financialservices.v1.DeleteModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists engine configs.
     * </pre>
     */
    default void listEngineConfigs(
        com.google.cloud.financialservices.v1.ListEngineConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.ListEngineConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEngineConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an engine config.
     * </pre>
     */
    default void getEngineConfig(
        com.google.cloud.financialservices.v1.GetEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.EngineConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEngineConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an engine config.
     * </pre>
     */
    default void createEngineConfig(
        com.google.cloud.financialservices.v1.CreateEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEngineConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EngineConfig.
     * </pre>
     */
    default void updateEngineConfig(
        com.google.cloud.financialservices.v1.UpdateEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEngineConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for an EngineConfig resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
     * </pre>
     */
    default void exportEngineConfigMetadata(
        com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportEngineConfigMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an engine config.
     * </pre>
     */
    default void deleteEngineConfig(
        com.google.cloud.financialservices.v1.DeleteEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEngineConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single EngineVersion.
     * </pre>
     */
    default void getEngineVersion(
        com.google.cloud.financialservices.v1.GetEngineVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.EngineVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEngineVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists EngineVersions for given location.
     * </pre>
     */
    default void listEngineVersions(
        com.google.cloud.financialservices.v1.ListEngineVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.financialservices.v1.ListEngineVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEngineVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List PredictionResults.
     * </pre>
     */
    default void listPredictionResults(
        com.google.cloud.financialservices.v1.ListPredictionResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.financialservices.v1.ListPredictionResultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPredictionResultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a PredictionResult.
     * </pre>
     */
    default void getPredictionResult(
        com.google.cloud.financialservices.v1.GetPredictionResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.PredictionResult>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPredictionResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a PredictionResult.
     * </pre>
     */
    default void createPredictionResult(
        com.google.cloud.financialservices.v1.CreatePredictionResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePredictionResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single PredictionResult.
     * </pre>
     */
    default void updatePredictionResult(
        com.google.cloud.financialservices.v1.UpdatePredictionResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePredictionResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a PredictionResult resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
     * </pre>
     */
    default void exportPredictionResultMetadata(
        com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportPredictionResultMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a PredictionResult.
     * </pre>
     */
    default void deletePredictionResult(
        com.google.cloud.financialservices.v1.DeletePredictionResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePredictionResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List BacktestResults.
     * </pre>
     */
    default void listBacktestResults(
        com.google.cloud.financialservices.v1.ListBacktestResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.financialservices.v1.ListBacktestResultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBacktestResultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a BacktestResult.
     * </pre>
     */
    default void getBacktestResult(
        com.google.cloud.financialservices.v1.GetBacktestResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.BacktestResult>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBacktestResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a BacktestResult.
     * </pre>
     */
    default void createBacktestResult(
        com.google.cloud.financialservices.v1.CreateBacktestResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBacktestResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BacktestResult.
     * </pre>
     */
    default void updateBacktestResult(
        com.google.cloud.financialservices.v1.UpdateBacktestResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBacktestResultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a BacktestResult resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
     * </pre>
     */
    default void exportBacktestResultMetadata(
        com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportBacktestResultMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BacktestResult.
     * </pre>
     */
    default void deleteBacktestResult(
        com.google.cloud.financialservices.v1.DeleteBacktestResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBacktestResultMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AML.
   *
   * <pre>
   * The AML (Anti Money Laundering) service allows users to perform REST
   * operations on aml.
   * </pre>
   */
  public abstract static class AMLImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AMLGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AML.
   *
   * <pre>
   * The AML (Anti Money Laundering) service allows users to perform REST
   * operations on aml.
   * </pre>
   */
  public static final class AMLStub extends io.grpc.stub.AbstractAsyncStub<AMLStub> {
    private AMLStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AMLStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AMLStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.financialservices.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.financialservices.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Instance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an instance.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.financialservices.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.financialservices.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.financialservices.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the list of registered parties. See
     * [Create and manage
     * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
     * for information on the input schema and response for this method.
     * </pre>
     */
    public void importRegisteredParties(
        com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportRegisteredPartiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the list of registered parties. See
     * [Create and manage
     * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
     * for information on the output schema for this method.
     * </pre>
     */
    public void exportRegisteredParties(
        com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportRegisteredPartiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets.
     * </pre>
     */
    public void listDatasets(
        com.google.cloud.financialservices.v1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.ListDatasetsResponse>
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
     * Gets a dataset.
     * </pre>
     */
    public void getDataset(
        com.google.cloud.financialservices.v1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Dataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset.
     * </pre>
     */
    public void createDataset(
        com.google.cloud.financialservices.v1.CreateDatasetRequest request,
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
     * Updates the parameters of a single Dataset.
     * </pre>
     */
    public void updateDataset(
        com.google.cloud.financialservices.v1.UpdateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset.
     * </pre>
     */
    public void deleteDataset(
        com.google.cloud.financialservices.v1.DeleteDatasetRequest request,
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
     * Lists models.
     * </pre>
     */
    public void listModels(
        com.google.cloud.financialservices.v1.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.ListModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public void getModel(
        com.google.cloud.financialservices.v1.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a model.
     * </pre>
     */
    public void createModel(
        com.google.cloud.financialservices.v1.CreateModelRequest request,
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
     * Updates the parameters of a single Model.
     * </pre>
     */
    public void updateModel(
        com.google.cloud.financialservices.v1.UpdateModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a Model resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
     * </pre>
     */
    public void exportModelMetadata(
        com.google.cloud.financialservices.v1.ExportModelMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportModelMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * </pre>
     */
    public void deleteModel(
        com.google.cloud.financialservices.v1.DeleteModelRequest request,
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
     * Lists engine configs.
     * </pre>
     */
    public void listEngineConfigs(
        com.google.cloud.financialservices.v1.ListEngineConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.ListEngineConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEngineConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an engine config.
     * </pre>
     */
    public void getEngineConfig(
        com.google.cloud.financialservices.v1.GetEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.EngineConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEngineConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an engine config.
     * </pre>
     */
    public void createEngineConfig(
        com.google.cloud.financialservices.v1.CreateEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEngineConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EngineConfig.
     * </pre>
     */
    public void updateEngineConfig(
        com.google.cloud.financialservices.v1.UpdateEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEngineConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for an EngineConfig resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
     * </pre>
     */
    public void exportEngineConfigMetadata(
        com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportEngineConfigMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an engine config.
     * </pre>
     */
    public void deleteEngineConfig(
        com.google.cloud.financialservices.v1.DeleteEngineConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEngineConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single EngineVersion.
     * </pre>
     */
    public void getEngineVersion(
        com.google.cloud.financialservices.v1.GetEngineVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.EngineVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEngineVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists EngineVersions for given location.
     * </pre>
     */
    public void listEngineVersions(
        com.google.cloud.financialservices.v1.ListEngineVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.financialservices.v1.ListEngineVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEngineVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List PredictionResults.
     * </pre>
     */
    public void listPredictionResults(
        com.google.cloud.financialservices.v1.ListPredictionResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.financialservices.v1.ListPredictionResultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPredictionResultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a PredictionResult.
     * </pre>
     */
    public void getPredictionResult(
        com.google.cloud.financialservices.v1.GetPredictionResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.PredictionResult>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPredictionResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a PredictionResult.
     * </pre>
     */
    public void createPredictionResult(
        com.google.cloud.financialservices.v1.CreatePredictionResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePredictionResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single PredictionResult.
     * </pre>
     */
    public void updatePredictionResult(
        com.google.cloud.financialservices.v1.UpdatePredictionResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePredictionResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a PredictionResult resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
     * </pre>
     */
    public void exportPredictionResultMetadata(
        com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportPredictionResultMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a PredictionResult.
     * </pre>
     */
    public void deletePredictionResult(
        com.google.cloud.financialservices.v1.DeletePredictionResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePredictionResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List BacktestResults.
     * </pre>
     */
    public void listBacktestResults(
        com.google.cloud.financialservices.v1.ListBacktestResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.financialservices.v1.ListBacktestResultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBacktestResultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a BacktestResult.
     * </pre>
     */
    public void getBacktestResult(
        com.google.cloud.financialservices.v1.GetBacktestResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.BacktestResult>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBacktestResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a BacktestResult.
     * </pre>
     */
    public void createBacktestResult(
        com.google.cloud.financialservices.v1.CreateBacktestResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBacktestResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BacktestResult.
     * </pre>
     */
    public void updateBacktestResult(
        com.google.cloud.financialservices.v1.UpdateBacktestResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBacktestResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a BacktestResult resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
     * </pre>
     */
    public void exportBacktestResultMetadata(
        com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportBacktestResultMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BacktestResult.
     * </pre>
     */
    public void deleteBacktestResult(
        com.google.cloud.financialservices.v1.DeleteBacktestResultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBacktestResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AML.
   *
   * <pre>
   * The AML (Anti Money Laundering) service allows users to perform REST
   * operations on aml.
   * </pre>
   */
  public static final class AMLBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AMLBlockingStub> {
    private AMLBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AMLBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AMLBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.ListInstancesResponse listInstances(
        com.google.cloud.financialservices.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an instance.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.Instance getInstance(
        com.google.cloud.financialservices.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an instance.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.financialservices.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.financialservices.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.financialservices.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the list of registered parties. See
     * [Create and manage
     * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
     * for information on the input schema and response for this method.
     * </pre>
     */
    public com.google.longrunning.Operation importRegisteredParties(
        com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportRegisteredPartiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the list of registered parties. See
     * [Create and manage
     * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
     * for information on the output schema for this method.
     * </pre>
     */
    public com.google.longrunning.Operation exportRegisteredParties(
        com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportRegisteredPartiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.ListDatasetsResponse listDatasets(
        com.google.cloud.financialservices.v1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a dataset.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.Dataset getDataset(
        com.google.cloud.financialservices.v1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset.
     * </pre>
     */
    public com.google.longrunning.Operation createDataset(
        com.google.cloud.financialservices.v1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Dataset.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataset(
        com.google.cloud.financialservices.v1.UpdateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataset(
        com.google.cloud.financialservices.v1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.ListModelsResponse listModels(
        com.google.cloud.financialservices.v1.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.Model getModel(
        com.google.cloud.financialservices.v1.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a model.
     * </pre>
     */
    public com.google.longrunning.Operation createModel(
        com.google.cloud.financialservices.v1.CreateModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Model.
     * </pre>
     */
    public com.google.longrunning.Operation updateModel(
        com.google.cloud.financialservices.v1.UpdateModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a Model resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
     * </pre>
     */
    public com.google.longrunning.Operation exportModelMetadata(
        com.google.cloud.financialservices.v1.ExportModelMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportModelMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * </pre>
     */
    public com.google.longrunning.Operation deleteModel(
        com.google.cloud.financialservices.v1.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists engine configs.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.ListEngineConfigsResponse listEngineConfigs(
        com.google.cloud.financialservices.v1.ListEngineConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEngineConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an engine config.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.EngineConfig getEngineConfig(
        com.google.cloud.financialservices.v1.GetEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEngineConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an engine config.
     * </pre>
     */
    public com.google.longrunning.Operation createEngineConfig(
        com.google.cloud.financialservices.v1.CreateEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEngineConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EngineConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateEngineConfig(
        com.google.cloud.financialservices.v1.UpdateEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEngineConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for an EngineConfig resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
     * </pre>
     */
    public com.google.longrunning.Operation exportEngineConfigMetadata(
        com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportEngineConfigMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an engine config.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEngineConfig(
        com.google.cloud.financialservices.v1.DeleteEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEngineConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single EngineVersion.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.EngineVersion getEngineVersion(
        com.google.cloud.financialservices.v1.GetEngineVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEngineVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists EngineVersions for given location.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.ListEngineVersionsResponse listEngineVersions(
        com.google.cloud.financialservices.v1.ListEngineVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEngineVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List PredictionResults.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.ListPredictionResultsResponse
        listPredictionResults(
            com.google.cloud.financialservices.v1.ListPredictionResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPredictionResultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a PredictionResult.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.PredictionResult getPredictionResult(
        com.google.cloud.financialservices.v1.GetPredictionResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPredictionResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a PredictionResult.
     * </pre>
     */
    public com.google.longrunning.Operation createPredictionResult(
        com.google.cloud.financialservices.v1.CreatePredictionResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePredictionResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single PredictionResult.
     * </pre>
     */
    public com.google.longrunning.Operation updatePredictionResult(
        com.google.cloud.financialservices.v1.UpdatePredictionResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePredictionResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a PredictionResult resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
     * </pre>
     */
    public com.google.longrunning.Operation exportPredictionResultMetadata(
        com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportPredictionResultMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a PredictionResult.
     * </pre>
     */
    public com.google.longrunning.Operation deletePredictionResult(
        com.google.cloud.financialservices.v1.DeletePredictionResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePredictionResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List BacktestResults.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.ListBacktestResultsResponse listBacktestResults(
        com.google.cloud.financialservices.v1.ListBacktestResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBacktestResultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a BacktestResult.
     * </pre>
     */
    public com.google.cloud.financialservices.v1.BacktestResult getBacktestResult(
        com.google.cloud.financialservices.v1.GetBacktestResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBacktestResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a BacktestResult.
     * </pre>
     */
    public com.google.longrunning.Operation createBacktestResult(
        com.google.cloud.financialservices.v1.CreateBacktestResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBacktestResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BacktestResult.
     * </pre>
     */
    public com.google.longrunning.Operation updateBacktestResult(
        com.google.cloud.financialservices.v1.UpdateBacktestResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBacktestResultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a BacktestResult resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
     * </pre>
     */
    public com.google.longrunning.Operation exportBacktestResultMetadata(
        com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportBacktestResultMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BacktestResult.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBacktestResult(
        com.google.cloud.financialservices.v1.DeleteBacktestResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBacktestResultMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AML.
   *
   * <pre>
   * The AML (Anti Money Laundering) service allows users to perform REST
   * operations on aml.
   * </pre>
   */
  public static final class AMLFutureStub extends io.grpc.stub.AbstractFutureStub<AMLFutureStub> {
    private AMLFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AMLFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AMLFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.ListInstancesResponse>
        listInstances(com.google.cloud.financialservices.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.Instance>
        getInstance(com.google.cloud.financialservices.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.financialservices.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.financialservices.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.financialservices.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the list of registered parties. See
     * [Create and manage
     * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
     * for information on the input schema and response for this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importRegisteredParties(
            com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportRegisteredPartiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the list of registered parties. See
     * [Create and manage
     * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
     * for information on the output schema for this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportRegisteredParties(
            com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportRegisteredPartiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists datasets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.ListDatasetsResponse>
        listDatasets(com.google.cloud.financialservices.v1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.Dataset>
        getDataset(com.google.cloud.financialservices.v1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataset(com.google.cloud.financialservices.v1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataset(com.google.cloud.financialservices.v1.UpdateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataset(com.google.cloud.financialservices.v1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists models.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.ListModelsResponse>
        listModels(com.google.cloud.financialservices.v1.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.Model>
        getModel(com.google.cloud.financialservices.v1.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createModel(com.google.cloud.financialservices.v1.CreateModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateModel(com.google.cloud.financialservices.v1.UpdateModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a Model resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportModelMetadata(
            com.google.cloud.financialservices.v1.ExportModelMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportModelMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteModel(com.google.cloud.financialservices.v1.DeleteModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists engine configs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.ListEngineConfigsResponse>
        listEngineConfigs(com.google.cloud.financialservices.v1.ListEngineConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEngineConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an engine config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.EngineConfig>
        getEngineConfig(com.google.cloud.financialservices.v1.GetEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEngineConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an engine config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEngineConfig(
            com.google.cloud.financialservices.v1.CreateEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEngineConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EngineConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEngineConfig(
            com.google.cloud.financialservices.v1.UpdateEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEngineConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for an EngineConfig resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportEngineConfigMetadata(
            com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportEngineConfigMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an engine config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEngineConfig(
            com.google.cloud.financialservices.v1.DeleteEngineConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEngineConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single EngineVersion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.EngineVersion>
        getEngineVersion(com.google.cloud.financialservices.v1.GetEngineVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEngineVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists EngineVersions for given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.ListEngineVersionsResponse>
        listEngineVersions(
            com.google.cloud.financialservices.v1.ListEngineVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEngineVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List PredictionResults.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.ListPredictionResultsResponse>
        listPredictionResults(
            com.google.cloud.financialservices.v1.ListPredictionResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPredictionResultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a PredictionResult.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.PredictionResult>
        getPredictionResult(
            com.google.cloud.financialservices.v1.GetPredictionResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPredictionResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a PredictionResult.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPredictionResult(
            com.google.cloud.financialservices.v1.CreatePredictionResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePredictionResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single PredictionResult.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePredictionResult(
            com.google.cloud.financialservices.v1.UpdatePredictionResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePredictionResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a PredictionResult resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportPredictionResultMetadata(
            com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportPredictionResultMetadataMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a PredictionResult.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePredictionResult(
            com.google.cloud.financialservices.v1.DeletePredictionResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePredictionResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List BacktestResults.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.ListBacktestResultsResponse>
        listBacktestResults(
            com.google.cloud.financialservices.v1.ListBacktestResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBacktestResultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a BacktestResult.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.financialservices.v1.BacktestResult>
        getBacktestResult(com.google.cloud.financialservices.v1.GetBacktestResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBacktestResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a BacktestResult.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBacktestResult(
            com.google.cloud.financialservices.v1.CreateBacktestResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBacktestResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single BacktestResult.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBacktestResult(
            com.google.cloud.financialservices.v1.UpdateBacktestResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBacktestResultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Export governance information for a BacktestResult resource. For
     * information on the exported fields, see
     * [AML output data
     * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportBacktestResultMetadata(
            com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportBacktestResultMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a BacktestResult.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBacktestResult(
            com.google.cloud.financialservices.v1.DeleteBacktestResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBacktestResultMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_DELETE_INSTANCE = 4;
  private static final int METHODID_IMPORT_REGISTERED_PARTIES = 5;
  private static final int METHODID_EXPORT_REGISTERED_PARTIES = 6;
  private static final int METHODID_LIST_DATASETS = 7;
  private static final int METHODID_GET_DATASET = 8;
  private static final int METHODID_CREATE_DATASET = 9;
  private static final int METHODID_UPDATE_DATASET = 10;
  private static final int METHODID_DELETE_DATASET = 11;
  private static final int METHODID_LIST_MODELS = 12;
  private static final int METHODID_GET_MODEL = 13;
  private static final int METHODID_CREATE_MODEL = 14;
  private static final int METHODID_UPDATE_MODEL = 15;
  private static final int METHODID_EXPORT_MODEL_METADATA = 16;
  private static final int METHODID_DELETE_MODEL = 17;
  private static final int METHODID_LIST_ENGINE_CONFIGS = 18;
  private static final int METHODID_GET_ENGINE_CONFIG = 19;
  private static final int METHODID_CREATE_ENGINE_CONFIG = 20;
  private static final int METHODID_UPDATE_ENGINE_CONFIG = 21;
  private static final int METHODID_EXPORT_ENGINE_CONFIG_METADATA = 22;
  private static final int METHODID_DELETE_ENGINE_CONFIG = 23;
  private static final int METHODID_GET_ENGINE_VERSION = 24;
  private static final int METHODID_LIST_ENGINE_VERSIONS = 25;
  private static final int METHODID_LIST_PREDICTION_RESULTS = 26;
  private static final int METHODID_GET_PREDICTION_RESULT = 27;
  private static final int METHODID_CREATE_PREDICTION_RESULT = 28;
  private static final int METHODID_UPDATE_PREDICTION_RESULT = 29;
  private static final int METHODID_EXPORT_PREDICTION_RESULT_METADATA = 30;
  private static final int METHODID_DELETE_PREDICTION_RESULT = 31;
  private static final int METHODID_LIST_BACKTEST_RESULTS = 32;
  private static final int METHODID_GET_BACKTEST_RESULT = 33;
  private static final int METHODID_CREATE_BACKTEST_RESULT = 34;
  private static final int METHODID_UPDATE_BACKTEST_RESULT = 35;
  private static final int METHODID_EXPORT_BACKTEST_RESULT_METADATA = 36;
  private static final int METHODID_DELETE_BACKTEST_RESULT = 37;

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
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.financialservices.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.financialservices.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.financialservices.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.financialservices.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.financialservices.v1.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.financialservices.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_REGISTERED_PARTIES:
          serviceImpl.importRegisteredParties(
              (com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_REGISTERED_PARTIES:
          serviceImpl.exportRegisteredParties(
              (com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATASETS:
          serviceImpl.listDatasets(
              (com.google.cloud.financialservices.v1.ListDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.financialservices.v1.ListDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATASET:
          serviceImpl.getDataset(
              (com.google.cloud.financialservices.v1.GetDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Dataset>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATASET:
          serviceImpl.createDataset(
              (com.google.cloud.financialservices.v1.CreateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATASET:
          serviceImpl.updateDataset(
              (com.google.cloud.financialservices.v1.UpdateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATASET:
          serviceImpl.deleteDataset(
              (com.google.cloud.financialservices.v1.DeleteDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MODELS:
          serviceImpl.listModels(
              (com.google.cloud.financialservices.v1.ListModelsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.financialservices.v1.ListModelsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MODEL:
          serviceImpl.getModel(
              (com.google.cloud.financialservices.v1.GetModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.Model>)
                  responseObserver);
          break;
        case METHODID_CREATE_MODEL:
          serviceImpl.createModel(
              (com.google.cloud.financialservices.v1.CreateModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MODEL:
          serviceImpl.updateModel(
              (com.google.cloud.financialservices.v1.UpdateModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_MODEL_METADATA:
          serviceImpl.exportModelMetadata(
              (com.google.cloud.financialservices.v1.ExportModelMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MODEL:
          serviceImpl.deleteModel(
              (com.google.cloud.financialservices.v1.DeleteModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENGINE_CONFIGS:
          serviceImpl.listEngineConfigs(
              (com.google.cloud.financialservices.v1.ListEngineConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.financialservices.v1.ListEngineConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENGINE_CONFIG:
          serviceImpl.getEngineConfig(
              (com.google.cloud.financialservices.v1.GetEngineConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.EngineConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENGINE_CONFIG:
          serviceImpl.createEngineConfig(
              (com.google.cloud.financialservices.v1.CreateEngineConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENGINE_CONFIG:
          serviceImpl.updateEngineConfig(
              (com.google.cloud.financialservices.v1.UpdateEngineConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_ENGINE_CONFIG_METADATA:
          serviceImpl.exportEngineConfigMetadata(
              (com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENGINE_CONFIG:
          serviceImpl.deleteEngineConfig(
              (com.google.cloud.financialservices.v1.DeleteEngineConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ENGINE_VERSION:
          serviceImpl.getEngineVersion(
              (com.google.cloud.financialservices.v1.GetEngineVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.EngineVersion>)
                  responseObserver);
          break;
        case METHODID_LIST_ENGINE_VERSIONS:
          serviceImpl.listEngineVersions(
              (com.google.cloud.financialservices.v1.ListEngineVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.financialservices.v1.ListEngineVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PREDICTION_RESULTS:
          serviceImpl.listPredictionResults(
              (com.google.cloud.financialservices.v1.ListPredictionResultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.financialservices.v1.ListPredictionResultsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PREDICTION_RESULT:
          serviceImpl.getPredictionResult(
              (com.google.cloud.financialservices.v1.GetPredictionResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.PredictionResult>)
                  responseObserver);
          break;
        case METHODID_CREATE_PREDICTION_RESULT:
          serviceImpl.createPredictionResult(
              (com.google.cloud.financialservices.v1.CreatePredictionResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PREDICTION_RESULT:
          serviceImpl.updatePredictionResult(
              (com.google.cloud.financialservices.v1.UpdatePredictionResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_PREDICTION_RESULT_METADATA:
          serviceImpl.exportPredictionResultMetadata(
              (com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PREDICTION_RESULT:
          serviceImpl.deletePredictionResult(
              (com.google.cloud.financialservices.v1.DeletePredictionResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKTEST_RESULTS:
          serviceImpl.listBacktestResults(
              (com.google.cloud.financialservices.v1.ListBacktestResultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.financialservices.v1.ListBacktestResultsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKTEST_RESULT:
          serviceImpl.getBacktestResult(
              (com.google.cloud.financialservices.v1.GetBacktestResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.financialservices.v1.BacktestResult>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKTEST_RESULT:
          serviceImpl.createBacktestResult(
              (com.google.cloud.financialservices.v1.CreateBacktestResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKTEST_RESULT:
          serviceImpl.updateBacktestResult(
              (com.google.cloud.financialservices.v1.UpdateBacktestResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_BACKTEST_RESULT_METADATA:
          serviceImpl.exportBacktestResultMetadata(
              (com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKTEST_RESULT:
          serviceImpl.deleteBacktestResult(
              (com.google.cloud.financialservices.v1.DeleteBacktestResultRequest) request,
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
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ListInstancesRequest,
                    com.google.cloud.financialservices.v1.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.GetInstanceRequest,
                    com.google.cloud.financialservices.v1.Instance>(
                    service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.UpdateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getImportRegisteredPartiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_REGISTERED_PARTIES)))
        .addMethod(
            getExportRegisteredPartiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_REGISTERED_PARTIES)))
        .addMethod(
            getListDatasetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ListDatasetsRequest,
                    com.google.cloud.financialservices.v1.ListDatasetsResponse>(
                    service, METHODID_LIST_DATASETS)))
        .addMethod(
            getGetDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.GetDatasetRequest,
                    com.google.cloud.financialservices.v1.Dataset>(service, METHODID_GET_DATASET)))
        .addMethod(
            getCreateDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.CreateDatasetRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATASET)))
        .addMethod(
            getUpdateDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.UpdateDatasetRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATASET)))
        .addMethod(
            getDeleteDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.DeleteDatasetRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATASET)))
        .addMethod(
            getListModelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ListModelsRequest,
                    com.google.cloud.financialservices.v1.ListModelsResponse>(
                    service, METHODID_LIST_MODELS)))
        .addMethod(
            getGetModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.GetModelRequest,
                    com.google.cloud.financialservices.v1.Model>(service, METHODID_GET_MODEL)))
        .addMethod(
            getCreateModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.CreateModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MODEL)))
        .addMethod(
            getUpdateModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.UpdateModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MODEL)))
        .addMethod(
            getExportModelMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ExportModelMetadataRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_MODEL_METADATA)))
        .addMethod(
            getDeleteModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.DeleteModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MODEL)))
        .addMethod(
            getListEngineConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ListEngineConfigsRequest,
                    com.google.cloud.financialservices.v1.ListEngineConfigsResponse>(
                    service, METHODID_LIST_ENGINE_CONFIGS)))
        .addMethod(
            getGetEngineConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.GetEngineConfigRequest,
                    com.google.cloud.financialservices.v1.EngineConfig>(
                    service, METHODID_GET_ENGINE_CONFIG)))
        .addMethod(
            getCreateEngineConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.CreateEngineConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENGINE_CONFIG)))
        .addMethod(
            getUpdateEngineConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.UpdateEngineConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ENGINE_CONFIG)))
        .addMethod(
            getExportEngineConfigMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_EXPORT_ENGINE_CONFIG_METADATA)))
        .addMethod(
            getDeleteEngineConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.DeleteEngineConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENGINE_CONFIG)))
        .addMethod(
            getGetEngineVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.GetEngineVersionRequest,
                    com.google.cloud.financialservices.v1.EngineVersion>(
                    service, METHODID_GET_ENGINE_VERSION)))
        .addMethod(
            getListEngineVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ListEngineVersionsRequest,
                    com.google.cloud.financialservices.v1.ListEngineVersionsResponse>(
                    service, METHODID_LIST_ENGINE_VERSIONS)))
        .addMethod(
            getListPredictionResultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ListPredictionResultsRequest,
                    com.google.cloud.financialservices.v1.ListPredictionResultsResponse>(
                    service, METHODID_LIST_PREDICTION_RESULTS)))
        .addMethod(
            getGetPredictionResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.GetPredictionResultRequest,
                    com.google.cloud.financialservices.v1.PredictionResult>(
                    service, METHODID_GET_PREDICTION_RESULT)))
        .addMethod(
            getCreatePredictionResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.CreatePredictionResultRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PREDICTION_RESULT)))
        .addMethod(
            getUpdatePredictionResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.UpdatePredictionResultRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_PREDICTION_RESULT)))
        .addMethod(
            getExportPredictionResultMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_EXPORT_PREDICTION_RESULT_METADATA)))
        .addMethod(
            getDeletePredictionResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.DeletePredictionResultRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PREDICTION_RESULT)))
        .addMethod(
            getListBacktestResultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ListBacktestResultsRequest,
                    com.google.cloud.financialservices.v1.ListBacktestResultsResponse>(
                    service, METHODID_LIST_BACKTEST_RESULTS)))
        .addMethod(
            getGetBacktestResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.GetBacktestResultRequest,
                    com.google.cloud.financialservices.v1.BacktestResult>(
                    service, METHODID_GET_BACKTEST_RESULT)))
        .addMethod(
            getCreateBacktestResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.CreateBacktestResultRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKTEST_RESULT)))
        .addMethod(
            getUpdateBacktestResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.UpdateBacktestResultRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKTEST_RESULT)))
        .addMethod(
            getExportBacktestResultMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_EXPORT_BACKTEST_RESULT_METADATA)))
        .addMethod(
            getDeleteBacktestResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.financialservices.v1.DeleteBacktestResultRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKTEST_RESULT)))
        .build();
  }

  private abstract static class AMLBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AMLBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.financialservices.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AML");
    }
  }

  private static final class AMLFileDescriptorSupplier extends AMLBaseDescriptorSupplier {
    AMLFileDescriptorSupplier() {}
  }

  private static final class AMLMethodDescriptorSupplier extends AMLBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AMLMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AMLGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AMLFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getImportRegisteredPartiesMethod())
                      .addMethod(getExportRegisteredPartiesMethod())
                      .addMethod(getListDatasetsMethod())
                      .addMethod(getGetDatasetMethod())
                      .addMethod(getCreateDatasetMethod())
                      .addMethod(getUpdateDatasetMethod())
                      .addMethod(getDeleteDatasetMethod())
                      .addMethod(getListModelsMethod())
                      .addMethod(getGetModelMethod())
                      .addMethod(getCreateModelMethod())
                      .addMethod(getUpdateModelMethod())
                      .addMethod(getExportModelMetadataMethod())
                      .addMethod(getDeleteModelMethod())
                      .addMethod(getListEngineConfigsMethod())
                      .addMethod(getGetEngineConfigMethod())
                      .addMethod(getCreateEngineConfigMethod())
                      .addMethod(getUpdateEngineConfigMethod())
                      .addMethod(getExportEngineConfigMetadataMethod())
                      .addMethod(getDeleteEngineConfigMethod())
                      .addMethod(getGetEngineVersionMethod())
                      .addMethod(getListEngineVersionsMethod())
                      .addMethod(getListPredictionResultsMethod())
                      .addMethod(getGetPredictionResultMethod())
                      .addMethod(getCreatePredictionResultMethod())
                      .addMethod(getUpdatePredictionResultMethod())
                      .addMethod(getExportPredictionResultMetadataMethod())
                      .addMethod(getDeletePredictionResultMethod())
                      .addMethod(getListBacktestResultsMethod())
                      .addMethod(getGetBacktestResultMethod())
                      .addMethod(getCreateBacktestResultMethod())
                      .addMethod(getUpdateBacktestResultMethod())
                      .addMethod(getExportBacktestResultMetadataMethod())
                      .addMethod(getDeleteBacktestResultMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
