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
package com.google.cloud.metastore.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Configures and manages metastore services.
 * Metastore services are fully managed, highly available, autoscaled,
 * autohealing, OSS-native deployments of technical metadata management
 * software. Each metastore service exposes a network endpoint through which
 * metadata queries are served. Metadata queries can originate from a variety
 * of sources, including Apache Hive, Apache Presto, and Apache Spark.
 * The Dataproc Metastore API defines the following resource model:
 * * The service works with a collection of Google Cloud projects, named:
 * `/projects/&#42;`
 * * Each project has a collection of available locations, named: `/locations/&#42;`
 *   (a location must refer to a Google Cloud `region`)
 * * Each location has a collection of services, named: `/services/&#42;`
 * * Dataproc Metastore services are resources with names of the form:
 *   `/projects/{project_number}/locations/{location_id}/services/{service_id}`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/metastore/v1beta/metastore.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataprocMetastoreGrpc {

  private DataprocMetastoreGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.metastore.v1beta.DataprocMetastore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.ListServicesRequest,
          com.google.cloud.metastore.v1beta.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.cloud.metastore.v1beta.ListServicesRequest.class,
      responseType = com.google.cloud.metastore.v1beta.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.ListServicesRequest,
          com.google.cloud.metastore.v1beta.ListServicesResponse>
      getListServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.ListServicesRequest,
            com.google.cloud.metastore.v1beta.ListServicesResponse>
        getListServicesMethod;
    if ((getListServicesMethod = DataprocMetastoreGrpc.getListServicesMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getListServicesMethod = DataprocMetastoreGrpc.getListServicesMethod) == null) {
          DataprocMetastoreGrpc.getListServicesMethod =
              getListServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.ListServicesRequest,
                          com.google.cloud.metastore.v1beta.ListServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.ListServicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.ListServicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("ListServices"))
                      .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.GetServiceRequest,
          com.google.cloud.metastore.v1beta.Service>
      getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.cloud.metastore.v1beta.GetServiceRequest.class,
      responseType = com.google.cloud.metastore.v1beta.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.GetServiceRequest,
          com.google.cloud.metastore.v1beta.Service>
      getGetServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.GetServiceRequest,
            com.google.cloud.metastore.v1beta.Service>
        getGetServiceMethod;
    if ((getGetServiceMethod = DataprocMetastoreGrpc.getGetServiceMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getGetServiceMethod = DataprocMetastoreGrpc.getGetServiceMethod) == null) {
          DataprocMetastoreGrpc.getGetServiceMethod =
              getGetServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.GetServiceRequest,
                          com.google.cloud.metastore.v1beta.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.GetServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.Service.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("GetService"))
                      .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.CreateServiceRequest, com.google.longrunning.Operation>
      getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateService",
      requestType = com.google.cloud.metastore.v1beta.CreateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.CreateServiceRequest, com.google.longrunning.Operation>
      getCreateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.CreateServiceRequest,
            com.google.longrunning.Operation>
        getCreateServiceMethod;
    if ((getCreateServiceMethod = DataprocMetastoreGrpc.getCreateServiceMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getCreateServiceMethod = DataprocMetastoreGrpc.getCreateServiceMethod) == null) {
          DataprocMetastoreGrpc.getCreateServiceMethod =
              getCreateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.CreateServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.CreateServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("CreateService"))
                      .build();
        }
      }
    }
    return getCreateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.UpdateServiceRequest, com.google.longrunning.Operation>
      getUpdateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateService",
      requestType = com.google.cloud.metastore.v1beta.UpdateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.UpdateServiceRequest, com.google.longrunning.Operation>
      getUpdateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.UpdateServiceRequest,
            com.google.longrunning.Operation>
        getUpdateServiceMethod;
    if ((getUpdateServiceMethod = DataprocMetastoreGrpc.getUpdateServiceMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getUpdateServiceMethod = DataprocMetastoreGrpc.getUpdateServiceMethod) == null) {
          DataprocMetastoreGrpc.getUpdateServiceMethod =
              getUpdateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.UpdateServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.UpdateServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("UpdateService"))
                      .build();
        }
      }
    }
    return getUpdateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.DeleteServiceRequest, com.google.longrunning.Operation>
      getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteService",
      requestType = com.google.cloud.metastore.v1beta.DeleteServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.DeleteServiceRequest, com.google.longrunning.Operation>
      getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.DeleteServiceRequest,
            com.google.longrunning.Operation>
        getDeleteServiceMethod;
    if ((getDeleteServiceMethod = DataprocMetastoreGrpc.getDeleteServiceMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getDeleteServiceMethod = DataprocMetastoreGrpc.getDeleteServiceMethod) == null) {
          DataprocMetastoreGrpc.getDeleteServiceMethod =
              getDeleteServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.DeleteServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.DeleteServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("DeleteService"))
                      .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.ListMetadataImportsRequest,
          com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>
      getListMetadataImportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMetadataImports",
      requestType = com.google.cloud.metastore.v1beta.ListMetadataImportsRequest.class,
      responseType = com.google.cloud.metastore.v1beta.ListMetadataImportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.ListMetadataImportsRequest,
          com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>
      getListMetadataImportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.ListMetadataImportsRequest,
            com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>
        getListMetadataImportsMethod;
    if ((getListMetadataImportsMethod = DataprocMetastoreGrpc.getListMetadataImportsMethod)
        == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getListMetadataImportsMethod = DataprocMetastoreGrpc.getListMetadataImportsMethod)
            == null) {
          DataprocMetastoreGrpc.getListMetadataImportsMethod =
              getListMetadataImportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.ListMetadataImportsRequest,
                          com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMetadataImports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.ListMetadataImportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.ListMetadataImportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("ListMetadataImports"))
                      .build();
        }
      }
    }
    return getListMetadataImportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.GetMetadataImportRequest,
          com.google.cloud.metastore.v1beta.MetadataImport>
      getGetMetadataImportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMetadataImport",
      requestType = com.google.cloud.metastore.v1beta.GetMetadataImportRequest.class,
      responseType = com.google.cloud.metastore.v1beta.MetadataImport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.GetMetadataImportRequest,
          com.google.cloud.metastore.v1beta.MetadataImport>
      getGetMetadataImportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.GetMetadataImportRequest,
            com.google.cloud.metastore.v1beta.MetadataImport>
        getGetMetadataImportMethod;
    if ((getGetMetadataImportMethod = DataprocMetastoreGrpc.getGetMetadataImportMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getGetMetadataImportMethod = DataprocMetastoreGrpc.getGetMetadataImportMethod)
            == null) {
          DataprocMetastoreGrpc.getGetMetadataImportMethod =
              getGetMetadataImportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.GetMetadataImportRequest,
                          com.google.cloud.metastore.v1beta.MetadataImport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMetadataImport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.GetMetadataImportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.MetadataImport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("GetMetadataImport"))
                      .build();
        }
      }
    }
    return getGetMetadataImportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.CreateMetadataImportRequest,
          com.google.longrunning.Operation>
      getCreateMetadataImportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMetadataImport",
      requestType = com.google.cloud.metastore.v1beta.CreateMetadataImportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.CreateMetadataImportRequest,
          com.google.longrunning.Operation>
      getCreateMetadataImportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.CreateMetadataImportRequest,
            com.google.longrunning.Operation>
        getCreateMetadataImportMethod;
    if ((getCreateMetadataImportMethod = DataprocMetastoreGrpc.getCreateMetadataImportMethod)
        == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getCreateMetadataImportMethod = DataprocMetastoreGrpc.getCreateMetadataImportMethod)
            == null) {
          DataprocMetastoreGrpc.getCreateMetadataImportMethod =
              getCreateMetadataImportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.CreateMetadataImportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMetadataImport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.CreateMetadataImportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("CreateMetadataImport"))
                      .build();
        }
      }
    }
    return getCreateMetadataImportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest,
          com.google.longrunning.Operation>
      getUpdateMetadataImportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMetadataImport",
      requestType = com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest,
          com.google.longrunning.Operation>
      getUpdateMetadataImportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest,
            com.google.longrunning.Operation>
        getUpdateMetadataImportMethod;
    if ((getUpdateMetadataImportMethod = DataprocMetastoreGrpc.getUpdateMetadataImportMethod)
        == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getUpdateMetadataImportMethod = DataprocMetastoreGrpc.getUpdateMetadataImportMethod)
            == null) {
          DataprocMetastoreGrpc.getUpdateMetadataImportMethod =
              getUpdateMetadataImportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMetadataImport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("UpdateMetadataImport"))
                      .build();
        }
      }
    }
    return getUpdateMetadataImportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.ExportMetadataRequest, com.google.longrunning.Operation>
      getExportMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportMetadata",
      requestType = com.google.cloud.metastore.v1beta.ExportMetadataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.ExportMetadataRequest, com.google.longrunning.Operation>
      getExportMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.ExportMetadataRequest,
            com.google.longrunning.Operation>
        getExportMetadataMethod;
    if ((getExportMetadataMethod = DataprocMetastoreGrpc.getExportMetadataMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getExportMetadataMethod = DataprocMetastoreGrpc.getExportMetadataMethod) == null) {
          DataprocMetastoreGrpc.getExportMetadataMethod =
              getExportMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.ExportMetadataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.ExportMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("ExportMetadata"))
                      .build();
        }
      }
    }
    return getExportMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.RestoreServiceRequest, com.google.longrunning.Operation>
      getRestoreServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreService",
      requestType = com.google.cloud.metastore.v1beta.RestoreServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.RestoreServiceRequest, com.google.longrunning.Operation>
      getRestoreServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.RestoreServiceRequest,
            com.google.longrunning.Operation>
        getRestoreServiceMethod;
    if ((getRestoreServiceMethod = DataprocMetastoreGrpc.getRestoreServiceMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getRestoreServiceMethod = DataprocMetastoreGrpc.getRestoreServiceMethod) == null) {
          DataprocMetastoreGrpc.getRestoreServiceMethod =
              getRestoreServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.RestoreServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.RestoreServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("RestoreService"))
                      .build();
        }
      }
    }
    return getRestoreServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.ListBackupsRequest,
          com.google.cloud.metastore.v1beta.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.metastore.v1beta.ListBackupsRequest.class,
      responseType = com.google.cloud.metastore.v1beta.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.ListBackupsRequest,
          com.google.cloud.metastore.v1beta.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.ListBackupsRequest,
            com.google.cloud.metastore.v1beta.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = DataprocMetastoreGrpc.getListBackupsMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getListBackupsMethod = DataprocMetastoreGrpc.getListBackupsMethod) == null) {
          DataprocMetastoreGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.ListBackupsRequest,
                          com.google.cloud.metastore.v1beta.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.GetBackupRequest,
          com.google.cloud.metastore.v1beta.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.metastore.v1beta.GetBackupRequest.class,
      responseType = com.google.cloud.metastore.v1beta.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.GetBackupRequest,
          com.google.cloud.metastore.v1beta.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.GetBackupRequest,
            com.google.cloud.metastore.v1beta.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = DataprocMetastoreGrpc.getGetBackupMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getGetBackupMethod = DataprocMetastoreGrpc.getGetBackupMethod) == null) {
          DataprocMetastoreGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.GetBackupRequest,
                          com.google.cloud.metastore.v1beta.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.GetBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackup",
      requestType = com.google.cloud.metastore.v1beta.CreateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.CreateBackupRequest, com.google.longrunning.Operation>
        getCreateBackupMethod;
    if ((getCreateBackupMethod = DataprocMetastoreGrpc.getCreateBackupMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getCreateBackupMethod = DataprocMetastoreGrpc.getCreateBackupMethod) == null) {
          DataprocMetastoreGrpc.getCreateBackupMethod =
              getCreateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.CreateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.CreateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("CreateBackup"))
                      .build();
        }
      }
    }
    return getCreateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.metastore.v1beta.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.metastore.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.metastore.v1beta.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = DataprocMetastoreGrpc.getDeleteBackupMethod) == null) {
      synchronized (DataprocMetastoreGrpc.class) {
        if ((getDeleteBackupMethod = DataprocMetastoreGrpc.getDeleteBackupMethod) == null) {
          DataprocMetastoreGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.metastore.v1beta.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.metastore.v1beta.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataprocMetastoreMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataprocMetastoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreStub>() {
          @java.lang.Override
          public DataprocMetastoreStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataprocMetastoreStub(channel, callOptions);
          }
        };
    return DataprocMetastoreStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataprocMetastoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreBlockingStub>() {
          @java.lang.Override
          public DataprocMetastoreBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataprocMetastoreBlockingStub(channel, callOptions);
          }
        };
    return DataprocMetastoreBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataprocMetastoreFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataprocMetastoreFutureStub>() {
          @java.lang.Override
          public DataprocMetastoreFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataprocMetastoreFutureStub(channel, callOptions);
          }
        };
    return DataprocMetastoreFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Configures and manages metastore services.
   * Metastore services are fully managed, highly available, autoscaled,
   * autohealing, OSS-native deployments of technical metadata management
   * software. Each metastore service exposes a network endpoint through which
   * metadata queries are served. Metadata queries can originate from a variety
   * of sources, including Apache Hive, Apache Presto, and Apache Spark.
   * The Dataproc Metastore API defines the following resource model:
   * * The service works with a collection of Google Cloud projects, named:
   * `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   *   (a location must refer to a Google Cloud `region`)
   * * Each location has a collection of services, named: `/services/&#42;`
   * * Dataproc Metastore services are resources with names of the form:
   *   `/projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * </pre>
   */
  public abstract static class DataprocMetastoreImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists services in a project and location.
     * </pre>
     */
    public void listServices(
        com.google.cloud.metastore.v1beta.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single service.
     * </pre>
     */
    public void getService(
        com.google.cloud.metastore.v1beta.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a metastore service in a project and location.
     * </pre>
     */
    public void createService(
        com.google.cloud.metastore.v1beta.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single service.
     * </pre>
     */
    public void updateService(
        com.google.cloud.metastore.v1beta.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single service.
     * </pre>
     */
    public void deleteService(
        com.google.cloud.metastore.v1beta.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists imports in a service.
     * </pre>
     */
    public void listMetadataImports(
        com.google.cloud.metastore.v1beta.ListMetadataImportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMetadataImportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single import.
     * </pre>
     */
    public void getMetadataImport(
        com.google.cloud.metastore.v1beta.GetMetadataImportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.MetadataImport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMetadataImportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MetadataImport in a given project and location.
     * </pre>
     */
    public void createMetadataImport(
        com.google.cloud.metastore.v1beta.CreateMetadataImportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMetadataImportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single import.
     * Only the description field of MetadataImport is supported to be updated.
     * </pre>
     */
    public void updateMetadataImport(
        com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMetadataImportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports metadata from a service.
     * </pre>
     */
    public void exportMetadata(
        com.google.cloud.metastore.v1beta.ExportMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a service from a backup.
     * </pre>
     */
    public void restoreService(
        com.google.cloud.metastore.v1beta.RestoreServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists backups in a service.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.metastore.v1beta.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.metastore.v1beta.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup in a given project and location.
     * </pre>
     */
    public void createBackup(
        com.google.cloud.metastore.v1beta.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.metastore.v1beta.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListServicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.ListServicesRequest,
                      com.google.cloud.metastore.v1beta.ListServicesResponse>(
                      this, METHODID_LIST_SERVICES)))
          .addMethod(
              getGetServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.GetServiceRequest,
                      com.google.cloud.metastore.v1beta.Service>(this, METHODID_GET_SERVICE)))
          .addMethod(
              getCreateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.CreateServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_SERVICE)))
          .addMethod(
              getUpdateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.UpdateServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_SERVICE)))
          .addMethod(
              getDeleteServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.DeleteServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_SERVICE)))
          .addMethod(
              getListMetadataImportsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.ListMetadataImportsRequest,
                      com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>(
                      this, METHODID_LIST_METADATA_IMPORTS)))
          .addMethod(
              getGetMetadataImportMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.GetMetadataImportRequest,
                      com.google.cloud.metastore.v1beta.MetadataImport>(
                      this, METHODID_GET_METADATA_IMPORT)))
          .addMethod(
              getCreateMetadataImportMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.CreateMetadataImportRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_METADATA_IMPORT)))
          .addMethod(
              getUpdateMetadataImportMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_METADATA_IMPORT)))
          .addMethod(
              getExportMetadataMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.ExportMetadataRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_METADATA)))
          .addMethod(
              getRestoreServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.RestoreServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESTORE_SERVICE)))
          .addMethod(
              getListBackupsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.ListBackupsRequest,
                      com.google.cloud.metastore.v1beta.ListBackupsResponse>(
                      this, METHODID_LIST_BACKUPS)))
          .addMethod(
              getGetBackupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.GetBackupRequest,
                      com.google.cloud.metastore.v1beta.Backup>(this, METHODID_GET_BACKUP)))
          .addMethod(
              getCreateBackupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.CreateBackupRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_BACKUP)))
          .addMethod(
              getDeleteBackupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.metastore.v1beta.DeleteBackupRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_BACKUP)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Configures and manages metastore services.
   * Metastore services are fully managed, highly available, autoscaled,
   * autohealing, OSS-native deployments of technical metadata management
   * software. Each metastore service exposes a network endpoint through which
   * metadata queries are served. Metadata queries can originate from a variety
   * of sources, including Apache Hive, Apache Presto, and Apache Spark.
   * The Dataproc Metastore API defines the following resource model:
   * * The service works with a collection of Google Cloud projects, named:
   * `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   *   (a location must refer to a Google Cloud `region`)
   * * Each location has a collection of services, named: `/services/&#42;`
   * * Dataproc Metastore services are resources with names of the form:
   *   `/projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * </pre>
   */
  public static final class DataprocMetastoreStub
      extends io.grpc.stub.AbstractAsyncStub<DataprocMetastoreStub> {
    private DataprocMetastoreStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataprocMetastoreStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataprocMetastoreStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists services in a project and location.
     * </pre>
     */
    public void listServices(
        com.google.cloud.metastore.v1beta.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single service.
     * </pre>
     */
    public void getService(
        com.google.cloud.metastore.v1beta.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a metastore service in a project and location.
     * </pre>
     */
    public void createService(
        com.google.cloud.metastore.v1beta.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single service.
     * </pre>
     */
    public void updateService(
        com.google.cloud.metastore.v1beta.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single service.
     * </pre>
     */
    public void deleteService(
        com.google.cloud.metastore.v1beta.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists imports in a service.
     * </pre>
     */
    public void listMetadataImports(
        com.google.cloud.metastore.v1beta.ListMetadataImportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMetadataImportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single import.
     * </pre>
     */
    public void getMetadataImport(
        com.google.cloud.metastore.v1beta.GetMetadataImportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.MetadataImport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMetadataImportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MetadataImport in a given project and location.
     * </pre>
     */
    public void createMetadataImport(
        com.google.cloud.metastore.v1beta.CreateMetadataImportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMetadataImportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single import.
     * Only the description field of MetadataImport is supported to be updated.
     * </pre>
     */
    public void updateMetadataImport(
        com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMetadataImportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports metadata from a service.
     * </pre>
     */
    public void exportMetadata(
        com.google.cloud.metastore.v1beta.ExportMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a service from a backup.
     * </pre>
     */
    public void restoreService(
        com.google.cloud.metastore.v1beta.RestoreServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists backups in a service.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.metastore.v1beta.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.metastore.v1beta.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup in a given project and location.
     * </pre>
     */
    public void createBackup(
        com.google.cloud.metastore.v1beta.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.metastore.v1beta.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Configures and manages metastore services.
   * Metastore services are fully managed, highly available, autoscaled,
   * autohealing, OSS-native deployments of technical metadata management
   * software. Each metastore service exposes a network endpoint through which
   * metadata queries are served. Metadata queries can originate from a variety
   * of sources, including Apache Hive, Apache Presto, and Apache Spark.
   * The Dataproc Metastore API defines the following resource model:
   * * The service works with a collection of Google Cloud projects, named:
   * `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   *   (a location must refer to a Google Cloud `region`)
   * * Each location has a collection of services, named: `/services/&#42;`
   * * Dataproc Metastore services are resources with names of the form:
   *   `/projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * </pre>
   */
  public static final class DataprocMetastoreBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataprocMetastoreBlockingStub> {
    private DataprocMetastoreBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataprocMetastoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataprocMetastoreBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists services in a project and location.
     * </pre>
     */
    public com.google.cloud.metastore.v1beta.ListServicesResponse listServices(
        com.google.cloud.metastore.v1beta.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single service.
     * </pre>
     */
    public com.google.cloud.metastore.v1beta.Service getService(
        com.google.cloud.metastore.v1beta.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a metastore service in a project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createService(
        com.google.cloud.metastore.v1beta.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single service.
     * </pre>
     */
    public com.google.longrunning.Operation updateService(
        com.google.cloud.metastore.v1beta.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single service.
     * </pre>
     */
    public com.google.longrunning.Operation deleteService(
        com.google.cloud.metastore.v1beta.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists imports in a service.
     * </pre>
     */
    public com.google.cloud.metastore.v1beta.ListMetadataImportsResponse listMetadataImports(
        com.google.cloud.metastore.v1beta.ListMetadataImportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMetadataImportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single import.
     * </pre>
     */
    public com.google.cloud.metastore.v1beta.MetadataImport getMetadataImport(
        com.google.cloud.metastore.v1beta.GetMetadataImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMetadataImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MetadataImport in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createMetadataImport(
        com.google.cloud.metastore.v1beta.CreateMetadataImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMetadataImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single import.
     * Only the description field of MetadataImport is supported to be updated.
     * </pre>
     */
    public com.google.longrunning.Operation updateMetadataImport(
        com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMetadataImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports metadata from a service.
     * </pre>
     */
    public com.google.longrunning.Operation exportMetadata(
        com.google.cloud.metastore.v1beta.ExportMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a service from a backup.
     * </pre>
     */
    public com.google.longrunning.Operation restoreService(
        com.google.cloud.metastore.v1beta.RestoreServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists backups in a service.
     * </pre>
     */
    public com.google.cloud.metastore.v1beta.ListBackupsResponse listBackups(
        com.google.cloud.metastore.v1beta.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single backup.
     * </pre>
     */
    public com.google.cloud.metastore.v1beta.Backup getBackup(
        com.google.cloud.metastore.v1beta.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.cloud.metastore.v1beta.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.metastore.v1beta.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Configures and manages metastore services.
   * Metastore services are fully managed, highly available, autoscaled,
   * autohealing, OSS-native deployments of technical metadata management
   * software. Each metastore service exposes a network endpoint through which
   * metadata queries are served. Metadata queries can originate from a variety
   * of sources, including Apache Hive, Apache Presto, and Apache Spark.
   * The Dataproc Metastore API defines the following resource model:
   * * The service works with a collection of Google Cloud projects, named:
   * `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   *   (a location must refer to a Google Cloud `region`)
   * * Each location has a collection of services, named: `/services/&#42;`
   * * Dataproc Metastore services are resources with names of the form:
   *   `/projects/{project_number}/locations/{location_id}/services/{service_id}`.
   * </pre>
   */
  public static final class DataprocMetastoreFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataprocMetastoreFutureStub> {
    private DataprocMetastoreFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataprocMetastoreFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataprocMetastoreFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists services in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.metastore.v1beta.ListServicesResponse>
        listServices(com.google.cloud.metastore.v1beta.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a single service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.metastore.v1beta.Service>
        getService(com.google.cloud.metastore.v1beta.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a metastore service in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createService(com.google.cloud.metastore.v1beta.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateService(com.google.cloud.metastore.v1beta.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteService(com.google.cloud.metastore.v1beta.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists imports in a service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>
        listMetadataImports(com.google.cloud.metastore.v1beta.ListMetadataImportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMetadataImportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single import.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.metastore.v1beta.MetadataImport>
        getMetadataImport(com.google.cloud.metastore.v1beta.GetMetadataImportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMetadataImportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new MetadataImport in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMetadataImport(
            com.google.cloud.metastore.v1beta.CreateMetadataImportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMetadataImportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single import.
     * Only the description field of MetadataImport is supported to be updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMetadataImport(
            com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMetadataImportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports metadata from a service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportMetadata(com.google.cloud.metastore.v1beta.ExportMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a service from a backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreService(com.google.cloud.metastore.v1beta.RestoreServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists backups in a service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.metastore.v1beta.ListBackupsResponse>
        listBackups(com.google.cloud.metastore.v1beta.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.metastore.v1beta.Backup>
        getBackup(com.google.cloud.metastore.v1beta.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackup(com.google.cloud.metastore.v1beta.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackup(com.google.cloud.metastore.v1beta.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SERVICES = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_CREATE_SERVICE = 2;
  private static final int METHODID_UPDATE_SERVICE = 3;
  private static final int METHODID_DELETE_SERVICE = 4;
  private static final int METHODID_LIST_METADATA_IMPORTS = 5;
  private static final int METHODID_GET_METADATA_IMPORT = 6;
  private static final int METHODID_CREATE_METADATA_IMPORT = 7;
  private static final int METHODID_UPDATE_METADATA_IMPORT = 8;
  private static final int METHODID_EXPORT_METADATA = 9;
  private static final int METHODID_RESTORE_SERVICE = 10;
  private static final int METHODID_LIST_BACKUPS = 11;
  private static final int METHODID_GET_BACKUP = 12;
  private static final int METHODID_CREATE_BACKUP = 13;
  private static final int METHODID_DELETE_BACKUP = 14;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataprocMetastoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataprocMetastoreImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices(
              (com.google.cloud.metastore.v1beta.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.ListServicesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService(
              (com.google.cloud.metastore.v1beta.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.Service>)
                  responseObserver);
          break;
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService(
              (com.google.cloud.metastore.v1beta.CreateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE:
          serviceImpl.updateService(
              (com.google.cloud.metastore.v1beta.UpdateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService(
              (com.google.cloud.metastore.v1beta.DeleteServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_METADATA_IMPORTS:
          serviceImpl.listMetadataImports(
              (com.google.cloud.metastore.v1beta.ListMetadataImportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.metastore.v1beta.ListMetadataImportsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_METADATA_IMPORT:
          serviceImpl.getMetadataImport(
              (com.google.cloud.metastore.v1beta.GetMetadataImportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.MetadataImport>)
                  responseObserver);
          break;
        case METHODID_CREATE_METADATA_IMPORT:
          serviceImpl.createMetadataImport(
              (com.google.cloud.metastore.v1beta.CreateMetadataImportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_METADATA_IMPORT:
          serviceImpl.updateMetadataImport(
              (com.google.cloud.metastore.v1beta.UpdateMetadataImportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_METADATA:
          serviceImpl.exportMetadata(
              (com.google.cloud.metastore.v1beta.ExportMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_SERVICE:
          serviceImpl.restoreService(
              (com.google.cloud.metastore.v1beta.RestoreServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.metastore.v1beta.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.metastore.v1beta.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.metastore.v1beta.Backup>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.cloud.metastore.v1beta.CreateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.metastore.v1beta.DeleteBackupRequest) request,
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

  private abstract static class DataprocMetastoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataprocMetastoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.metastore.v1beta.MetastoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataprocMetastore");
    }
  }

  private static final class DataprocMetastoreFileDescriptorSupplier
      extends DataprocMetastoreBaseDescriptorSupplier {
    DataprocMetastoreFileDescriptorSupplier() {}
  }

  private static final class DataprocMetastoreMethodDescriptorSupplier
      extends DataprocMetastoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataprocMetastoreMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataprocMetastoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataprocMetastoreFileDescriptorSupplier())
                      .addMethod(getListServicesMethod())
                      .addMethod(getGetServiceMethod())
                      .addMethod(getCreateServiceMethod())
                      .addMethod(getUpdateServiceMethod())
                      .addMethod(getDeleteServiceMethod())
                      .addMethod(getListMetadataImportsMethod())
                      .addMethod(getGetMetadataImportMethod())
                      .addMethod(getCreateMetadataImportMethod())
                      .addMethod(getUpdateMetadataImportMethod())
                      .addMethod(getExportMetadataMethod())
                      .addMethod(getRestoreServiceMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getCreateBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
