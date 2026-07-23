/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.sql.v1beta4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlInstancesServiceGrpc {

  private SqlInstancesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.sql.v1beta4.SqlInstancesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getAddServerCaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddServerCa",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getAddServerCaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getAddServerCaMethod;
    if ((getAddServerCaMethod = SqlInstancesServiceGrpc.getAddServerCaMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getAddServerCaMethod = SqlInstancesServiceGrpc.getAddServerCaMethod) == null) {
          SqlInstancesServiceGrpc.getAddServerCaMethod =
              getAddServerCaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddServerCa"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("AddServerCa"))
                      .build();
        }
      }
    }
    return getAddServerCaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getAddServerCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddServerCertificate",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getAddServerCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getAddServerCertificateMethod;
    if ((getAddServerCertificateMethod = SqlInstancesServiceGrpc.getAddServerCertificateMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getAddServerCertificateMethod = SqlInstancesServiceGrpc.getAddServerCertificateMethod)
            == null) {
          SqlInstancesServiceGrpc.getAddServerCertificateMethod =
              getAddServerCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddServerCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("AddServerCertificate"))
                      .build();
        }
      }
    }
    return getAddServerCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getAddEntraIdCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddEntraIdCertificate",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getAddEntraIdCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getAddEntraIdCertificateMethod;
    if ((getAddEntraIdCertificateMethod = SqlInstancesServiceGrpc.getAddEntraIdCertificateMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getAddEntraIdCertificateMethod =
                SqlInstancesServiceGrpc.getAddEntraIdCertificateMethod)
            == null) {
          SqlInstancesServiceGrpc.getAddEntraIdCertificateMethod =
              getAddEntraIdCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddEntraIdCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("AddEntraIdCertificate"))
                      .build();
        }
      }
    }
    return getAddEntraIdCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getCloneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Clone",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getCloneMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getCloneMethod;
    if ((getCloneMethod = SqlInstancesServiceGrpc.getCloneMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getCloneMethod = SqlInstancesServiceGrpc.getCloneMethod) == null) {
          SqlInstancesServiceGrpc.getCloneMethod =
              getCloneMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Clone"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlInstancesServiceMethodDescriptorSupplier("Clone"))
                      .build();
        }
      }
    }
    return getCloneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDeleteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getDeleteMethod;
    if ((getDeleteMethod = SqlInstancesServiceGrpc.getDeleteMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getDeleteMethod = SqlInstancesServiceGrpc.getDeleteMethod) == null) {
          SqlInstancesServiceGrpc.getDeleteMethod =
              getDeleteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Delete"))
                      .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDemoteMasterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DemoteMaster",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDemoteMasterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getDemoteMasterMethod;
    if ((getDemoteMasterMethod = SqlInstancesServiceGrpc.getDemoteMasterMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getDemoteMasterMethod = SqlInstancesServiceGrpc.getDemoteMasterMethod) == null) {
          SqlInstancesServiceGrpc.getDemoteMasterMethod =
              getDemoteMasterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DemoteMaster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("DemoteMaster"))
                      .build();
        }
      }
    }
    return getDemoteMasterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDemoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Demote",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDemoteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getDemoteMethod;
    if ((getDemoteMethod = SqlInstancesServiceGrpc.getDemoteMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getDemoteMethod = SqlInstancesServiceGrpc.getDemoteMethod) == null) {
          SqlInstancesServiceGrpc.getDemoteMethod =
              getDemoteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Demote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Demote"))
                      .build();
        }
      }
    }
    return getDemoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesExportRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Export",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesExportRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesExportRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getExportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesExportRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getExportMethod;
    if ((getExportMethod = SqlInstancesServiceGrpc.getExportMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getExportMethod = SqlInstancesServiceGrpc.getExportMethod) == null) {
          SqlInstancesServiceGrpc.getExportMethod =
              getExportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesExportRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Export"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesExportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Export"))
                      .build();
        }
      }
    }
    return getExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getFailoverMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Failover",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getFailoverMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getFailoverMethod;
    if ((getFailoverMethod = SqlInstancesServiceGrpc.getFailoverMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getFailoverMethod = SqlInstancesServiceGrpc.getFailoverMethod) == null) {
          SqlInstancesServiceGrpc.getFailoverMethod =
              getFailoverMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Failover"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Failover"))
                      .build();
        }
      }
    }
    return getFailoverMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getReencryptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Reencrypt",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getReencryptMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getReencryptMethod;
    if ((getReencryptMethod = SqlInstancesServiceGrpc.getReencryptMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getReencryptMethod = SqlInstancesServiceGrpc.getReencryptMethod) == null) {
          SqlInstancesServiceGrpc.getReencryptMethod =
              getReencryptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Reencrypt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Reencrypt"))
                      .build();
        }
      }
    }
    return getReencryptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesGetRequest,
          com.google.cloud.sql.v1beta4.DatabaseInstance>
      getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesGetRequest.class,
      responseType = com.google.cloud.sql.v1beta4.DatabaseInstance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesGetRequest,
          com.google.cloud.sql.v1beta4.DatabaseInstance>
      getGetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesGetRequest,
            com.google.cloud.sql.v1beta4.DatabaseInstance>
        getGetMethod;
    if ((getGetMethod = SqlInstancesServiceGrpc.getGetMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getGetMethod = SqlInstancesServiceGrpc.getGetMethod) == null) {
          SqlInstancesServiceGrpc.getGetMethod =
              getGetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesGetRequest,
                          com.google.cloud.sql.v1beta4.DatabaseInstance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesGetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.DatabaseInstance.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlInstancesServiceMethodDescriptorSupplier("Get"))
                      .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesImportRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getImportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Import",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesImportRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesImportRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getImportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesImportRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getImportMethod;
    if ((getImportMethod = SqlInstancesServiceGrpc.getImportMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getImportMethod = SqlInstancesServiceGrpc.getImportMethod) == null) {
          SqlInstancesServiceGrpc.getImportMethod =
              getImportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesImportRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Import"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesImportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Import"))
                      .build();
        }
      }
    }
    return getImportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getInsertMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getInsertMethod;
    if ((getInsertMethod = SqlInstancesServiceGrpc.getInsertMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getInsertMethod = SqlInstancesServiceGrpc.getInsertMethod) == null) {
          SqlInstancesServiceGrpc.getInsertMethod =
              getInsertMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Insert"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Insert"))
                      .build();
        }
      }
    }
    return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesListRequest,
          com.google.cloud.sql.v1beta4.InstancesListResponse>
      getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesListRequest.class,
      responseType = com.google.cloud.sql.v1beta4.InstancesListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesListRequest,
          com.google.cloud.sql.v1beta4.InstancesListResponse>
      getListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesListRequest,
            com.google.cloud.sql.v1beta4.InstancesListResponse>
        getListMethod;
    if ((getListMethod = SqlInstancesServiceGrpc.getListMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getListMethod = SqlInstancesServiceGrpc.getListMethod) == null) {
          SqlInstancesServiceGrpc.getListMethod =
              getListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesListRequest,
                          com.google.cloud.sql.v1beta4.InstancesListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.InstancesListResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SqlInstancesServiceMethodDescriptorSupplier("List"))
                      .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest,
          com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>
      getListServerCasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServerCas",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest.class,
      responseType = com.google.cloud.sql.v1beta4.InstancesListServerCasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest,
          com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>
      getListServerCasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest,
            com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>
        getListServerCasMethod;
    if ((getListServerCasMethod = SqlInstancesServiceGrpc.getListServerCasMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getListServerCasMethod = SqlInstancesServiceGrpc.getListServerCasMethod) == null) {
          SqlInstancesServiceGrpc.getListServerCasMethod =
              getListServerCasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest,
                          com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServerCas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.InstancesListServerCasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("ListServerCas"))
                      .build();
        }
      }
    }
    return getListServerCasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest,
          com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>
      getListServerCertificatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServerCertificates",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest.class,
      responseType = com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest,
          com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>
      getListServerCertificatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest,
            com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>
        getListServerCertificatesMethod;
    if ((getListServerCertificatesMethod = SqlInstancesServiceGrpc.getListServerCertificatesMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getListServerCertificatesMethod =
                SqlInstancesServiceGrpc.getListServerCertificatesMethod)
            == null) {
          SqlInstancesServiceGrpc.getListServerCertificatesMethod =
              getListServerCertificatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest,
                          com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListServerCertificates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("ListServerCertificates"))
                      .build();
        }
      }
    }
    return getListServerCertificatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest,
          com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>
      getListEntraIdCertificatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntraIdCertificates",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest.class,
      responseType = com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest,
          com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>
      getListEntraIdCertificatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest,
            com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>
        getListEntraIdCertificatesMethod;
    if ((getListEntraIdCertificatesMethod =
            SqlInstancesServiceGrpc.getListEntraIdCertificatesMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getListEntraIdCertificatesMethod =
                SqlInstancesServiceGrpc.getListEntraIdCertificatesMethod)
            == null) {
          SqlInstancesServiceGrpc.getListEntraIdCertificatesMethod =
              getListEntraIdCertificatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest,
                          com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEntraIdCertificates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4
                                  .SqlInstancesListEntraIdCertificatesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier(
                              "ListEntraIdCertificates"))
                      .build();
        }
      }
    }
    return getListEntraIdCertificatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Patch",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPatchMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getPatchMethod;
    if ((getPatchMethod = SqlInstancesServiceGrpc.getPatchMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getPatchMethod = SqlInstancesServiceGrpc.getPatchMethod) == null) {
          SqlInstancesServiceGrpc.getPatchMethod =
              getPatchMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Patch"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlInstancesServiceMethodDescriptorSupplier("Patch"))
                      .build();
        }
      }
    }
    return getPatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPromoteReplicaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PromoteReplica",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPromoteReplicaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getPromoteReplicaMethod;
    if ((getPromoteReplicaMethod = SqlInstancesServiceGrpc.getPromoteReplicaMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getPromoteReplicaMethod = SqlInstancesServiceGrpc.getPromoteReplicaMethod) == null) {
          SqlInstancesServiceGrpc.getPromoteReplicaMethod =
              getPromoteReplicaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PromoteReplica"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("PromoteReplica"))
                      .build();
        }
      }
    }
    return getPromoteReplicaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getSwitchoverMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Switchover",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getSwitchoverMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getSwitchoverMethod;
    if ((getSwitchoverMethod = SqlInstancesServiceGrpc.getSwitchoverMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getSwitchoverMethod = SqlInstancesServiceGrpc.getSwitchoverMethod) == null) {
          SqlInstancesServiceGrpc.getSwitchoverMethod =
              getSwitchoverMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Switchover"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Switchover"))
                      .build();
        }
      }
    }
    return getSwitchoverMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getResetSslConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetSslConfig",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getResetSslConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getResetSslConfigMethod;
    if ((getResetSslConfigMethod = SqlInstancesServiceGrpc.getResetSslConfigMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getResetSslConfigMethod = SqlInstancesServiceGrpc.getResetSslConfigMethod) == null) {
          SqlInstancesServiceGrpc.getResetSslConfigMethod =
              getResetSslConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetSslConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("ResetSslConfig"))
                      .build();
        }
      }
    }
    return getResetSslConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRestartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Restart",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRestartMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getRestartMethod;
    if ((getRestartMethod = SqlInstancesServiceGrpc.getRestartMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getRestartMethod = SqlInstancesServiceGrpc.getRestartMethod) == null) {
          SqlInstancesServiceGrpc.getRestartMethod =
              getRestartMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Restart"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Restart"))
                      .build();
        }
      }
    }
    return getRestartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRestoreBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreBackup",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRestoreBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getRestoreBackupMethod;
    if ((getRestoreBackupMethod = SqlInstancesServiceGrpc.getRestoreBackupMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getRestoreBackupMethod = SqlInstancesServiceGrpc.getRestoreBackupMethod) == null) {
          SqlInstancesServiceGrpc.getRestoreBackupMethod =
              getRestoreBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("RestoreBackup"))
                      .build();
        }
      }
    }
    return getRestoreBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRotateServerCaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RotateServerCa",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRotateServerCaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getRotateServerCaMethod;
    if ((getRotateServerCaMethod = SqlInstancesServiceGrpc.getRotateServerCaMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getRotateServerCaMethod = SqlInstancesServiceGrpc.getRotateServerCaMethod) == null) {
          SqlInstancesServiceGrpc.getRotateServerCaMethod =
              getRotateServerCaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RotateServerCa"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("RotateServerCa"))
                      .build();
        }
      }
    }
    return getRotateServerCaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRotateServerCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RotateServerCertificate",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRotateServerCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getRotateServerCertificateMethod;
    if ((getRotateServerCertificateMethod =
            SqlInstancesServiceGrpc.getRotateServerCertificateMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getRotateServerCertificateMethod =
                SqlInstancesServiceGrpc.getRotateServerCertificateMethod)
            == null) {
          SqlInstancesServiceGrpc.getRotateServerCertificateMethod =
              getRotateServerCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RotateServerCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4
                                  .SqlInstancesRotateServerCertificateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier(
                              "RotateServerCertificate"))
                      .build();
        }
      }
    }
    return getRotateServerCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRotateEntraIdCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RotateEntraIdCertificate",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRotateEntraIdCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getRotateEntraIdCertificateMethod;
    if ((getRotateEntraIdCertificateMethod =
            SqlInstancesServiceGrpc.getRotateEntraIdCertificateMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getRotateEntraIdCertificateMethod =
                SqlInstancesServiceGrpc.getRotateEntraIdCertificateMethod)
            == null) {
          SqlInstancesServiceGrpc.getRotateEntraIdCertificateMethod =
              getRotateEntraIdCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RotateEntraIdCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4
                                  .SqlInstancesRotateEntraIdCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier(
                              "RotateEntraIdCertificate"))
                      .build();
        }
      }
    }
    return getRotateEntraIdCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getStartReplicaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartReplica",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getStartReplicaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getStartReplicaMethod;
    if ((getStartReplicaMethod = SqlInstancesServiceGrpc.getStartReplicaMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getStartReplicaMethod = SqlInstancesServiceGrpc.getStartReplicaMethod) == null) {
          SqlInstancesServiceGrpc.getStartReplicaMethod =
              getStartReplicaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartReplica"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("StartReplica"))
                      .build();
        }
      }
    }
    return getStartReplicaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getStopReplicaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopReplica",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getStopReplicaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getStopReplicaMethod;
    if ((getStopReplicaMethod = SqlInstancesServiceGrpc.getStopReplicaMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getStopReplicaMethod = SqlInstancesServiceGrpc.getStopReplicaMethod) == null) {
          SqlInstancesServiceGrpc.getStopReplicaMethod =
              getStopReplicaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopReplica"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("StopReplica"))
                      .build();
        }
      }
    }
    return getStopReplicaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getTruncateLogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TruncateLog",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getTruncateLogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getTruncateLogMethod;
    if ((getTruncateLogMethod = SqlInstancesServiceGrpc.getTruncateLogMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getTruncateLogMethod = SqlInstancesServiceGrpc.getTruncateLogMethod) == null) {
          SqlInstancesServiceGrpc.getTruncateLogMethod =
              getTruncateLogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TruncateLog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("TruncateLog"))
                      .build();
        }
      }
    }
    return getTruncateLogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getUpdateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getUpdateMethod;
    if ((getUpdateMethod = SqlInstancesServiceGrpc.getUpdateMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getUpdateMethod = SqlInstancesServiceGrpc.getUpdateMethod) == null) {
          SqlInstancesServiceGrpc.getUpdateMethod =
              getUpdateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("Update"))
                      .build();
        }
      }
    }
    return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest,
          com.google.cloud.sql.v1beta4.SslCert>
      getCreateEphemeralMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEphemeral",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SslCert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest,
          com.google.cloud.sql.v1beta4.SslCert>
      getCreateEphemeralMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest,
            com.google.cloud.sql.v1beta4.SslCert>
        getCreateEphemeralMethod;
    if ((getCreateEphemeralMethod = SqlInstancesServiceGrpc.getCreateEphemeralMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getCreateEphemeralMethod = SqlInstancesServiceGrpc.getCreateEphemeralMethod) == null) {
          SqlInstancesServiceGrpc.getCreateEphemeralMethod =
              getCreateEphemeralMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest,
                          com.google.cloud.sql.v1beta4.SslCert>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEphemeral"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SslCert.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("CreateEphemeral"))
                      .build();
        }
      }
    }
    return getCreateEphemeralMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRescheduleMaintenanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RescheduleMaintenance",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getRescheduleMaintenanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getRescheduleMaintenanceMethod;
    if ((getRescheduleMaintenanceMethod = SqlInstancesServiceGrpc.getRescheduleMaintenanceMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getRescheduleMaintenanceMethod =
                SqlInstancesServiceGrpc.getRescheduleMaintenanceMethod)
            == null) {
          SqlInstancesServiceGrpc.getRescheduleMaintenanceMethod =
              getRescheduleMaintenanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RescheduleMaintenance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("RescheduleMaintenance"))
                      .build();
        }
      }
    }
    return getRescheduleMaintenanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse>
      getVerifyExternalSyncSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyExternalSyncSettings",
      requestType =
          com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest.class,
      responseType =
          com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse>
      getVerifyExternalSyncSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest,
            com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse>
        getVerifyExternalSyncSettingsMethod;
    if ((getVerifyExternalSyncSettingsMethod =
            SqlInstancesServiceGrpc.getVerifyExternalSyncSettingsMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getVerifyExternalSyncSettingsMethod =
                SqlInstancesServiceGrpc.getVerifyExternalSyncSettingsMethod)
            == null) {
          SqlInstancesServiceGrpc.getVerifyExternalSyncSettingsMethod =
              getVerifyExternalSyncSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest,
                          com.google.cloud.sql.v1beta4
                              .SqlInstancesVerifyExternalSyncSettingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "VerifyExternalSyncSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4
                                  .SqlInstancesVerifyExternalSyncSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4
                                  .SqlInstancesVerifyExternalSyncSettingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier(
                              "VerifyExternalSyncSettings"))
                      .build();
        }
      }
    }
    return getVerifyExternalSyncSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getStartExternalSyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartExternalSync",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getStartExternalSyncMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getStartExternalSyncMethod;
    if ((getStartExternalSyncMethod = SqlInstancesServiceGrpc.getStartExternalSyncMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getStartExternalSyncMethod = SqlInstancesServiceGrpc.getStartExternalSyncMethod)
            == null) {
          SqlInstancesServiceGrpc.getStartExternalSyncMethod =
              getStartExternalSyncMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartExternalSync"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("StartExternalSync"))
                      .build();
        }
      }
    }
    return getStartExternalSyncMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPerformDiskShrinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PerformDiskShrink",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPerformDiskShrinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getPerformDiskShrinkMethod;
    if ((getPerformDiskShrinkMethod = SqlInstancesServiceGrpc.getPerformDiskShrinkMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getPerformDiskShrinkMethod = SqlInstancesServiceGrpc.getPerformDiskShrinkMethod)
            == null) {
          SqlInstancesServiceGrpc.getPerformDiskShrinkMethod =
              getPerformDiskShrinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PerformDiskShrink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("PerformDiskShrink"))
                      .build();
        }
      }
    }
    return getPerformDiskShrinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>
      getGetDiskShrinkConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDiskShrinkConfig",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>
      getGetDiskShrinkConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest,
            com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>
        getGetDiskShrinkConfigMethod;
    if ((getGetDiskShrinkConfigMethod = SqlInstancesServiceGrpc.getGetDiskShrinkConfigMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getGetDiskShrinkConfigMethod = SqlInstancesServiceGrpc.getGetDiskShrinkConfigMethod)
            == null) {
          SqlInstancesServiceGrpc.getGetDiskShrinkConfigMethod =
              getGetDiskShrinkConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest,
                          com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDiskShrinkConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("GetDiskShrinkConfig"))
                      .build();
        }
      }
    }
    return getGetDiskShrinkConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getResetReplicaSizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetReplicaSize",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getResetReplicaSizeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getResetReplicaSizeMethod;
    if ((getResetReplicaSizeMethod = SqlInstancesServiceGrpc.getResetReplicaSizeMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getResetReplicaSizeMethod = SqlInstancesServiceGrpc.getResetReplicaSizeMethod)
            == null) {
          SqlInstancesServiceGrpc.getResetReplicaSizeMethod =
              getResetReplicaSizeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetReplicaSize"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("ResetReplicaSize"))
                      .build();
        }
      }
    }
    return getResetReplicaSizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>
      getGetLatestRecoveryTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatestRecoveryTime",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>
      getGetLatestRecoveryTimeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest,
            com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>
        getGetLatestRecoveryTimeMethod;
    if ((getGetLatestRecoveryTimeMethod = SqlInstancesServiceGrpc.getGetLatestRecoveryTimeMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getGetLatestRecoveryTimeMethod =
                SqlInstancesServiceGrpc.getGetLatestRecoveryTimeMethod)
            == null) {
          SqlInstancesServiceGrpc.getGetLatestRecoveryTimeMethod =
              getGetLatestRecoveryTimeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest,
                          com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLatestRecoveryTime"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("GetLatestRecoveryTime"))
                      .build();
        }
      }
    }
    return getGetLatestRecoveryTimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>
      getExecuteSqlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteSql",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>
      getExecuteSqlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest,
            com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>
        getExecuteSqlMethod;
    if ((getExecuteSqlMethod = SqlInstancesServiceGrpc.getExecuteSqlMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getExecuteSqlMethod = SqlInstancesServiceGrpc.getExecuteSqlMethod) == null) {
          SqlInstancesServiceGrpc.getExecuteSqlMethod =
              getExecuteSqlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest,
                          com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteSql"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("ExecuteSql"))
                      .build();
        }
      }
    }
    return getExecuteSqlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>
      getAcquireSsrsLeaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcquireSsrsLease",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>
      getAcquireSsrsLeaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest,
            com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>
        getAcquireSsrsLeaseMethod;
    if ((getAcquireSsrsLeaseMethod = SqlInstancesServiceGrpc.getAcquireSsrsLeaseMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getAcquireSsrsLeaseMethod = SqlInstancesServiceGrpc.getAcquireSsrsLeaseMethod)
            == null) {
          SqlInstancesServiceGrpc.getAcquireSsrsLeaseMethod =
              getAcquireSsrsLeaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest,
                          com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcquireSsrsLease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("AcquireSsrsLease"))
                      .build();
        }
      }
    }
    return getAcquireSsrsLeaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>
      getReleaseSsrsLeaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReleaseSsrsLease",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest.class,
      responseType = com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest,
          com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>
      getReleaseSsrsLeaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest,
            com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>
        getReleaseSsrsLeaseMethod;
    if ((getReleaseSsrsLeaseMethod = SqlInstancesServiceGrpc.getReleaseSsrsLeaseMethod) == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getReleaseSsrsLeaseMethod = SqlInstancesServiceGrpc.getReleaseSsrsLeaseMethod)
            == null) {
          SqlInstancesServiceGrpc.getReleaseSsrsLeaseMethod =
              getReleaseSsrsLeaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest,
                          com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReleaseSsrsLease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("ReleaseSsrsLease"))
                      .build();
        }
      }
    }
    return getReleaseSsrsLeaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPreCheckMajorVersionUpgradeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PreCheckMajorVersionUpgrade",
      requestType =
          com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPreCheckMajorVersionUpgradeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getPreCheckMajorVersionUpgradeMethod;
    if ((getPreCheckMajorVersionUpgradeMethod =
            SqlInstancesServiceGrpc.getPreCheckMajorVersionUpgradeMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getPreCheckMajorVersionUpgradeMethod =
                SqlInstancesServiceGrpc.getPreCheckMajorVersionUpgradeMethod)
            == null) {
          SqlInstancesServiceGrpc.getPreCheckMajorVersionUpgradeMethod =
              getPreCheckMajorVersionUpgradeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PreCheckMajorVersionUpgrade"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4
                                  .SqlInstancesPreCheckMajorVersionUpgradeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier(
                              "PreCheckMajorVersionUpgrade"))
                      .build();
        }
      }
    }
    return getPreCheckMajorVersionUpgradeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPointInTimeRestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PointInTimeRestore",
      requestType = com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getPointInTimeRestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getPointInTimeRestoreMethod;
    if ((getPointInTimeRestoreMethod = SqlInstancesServiceGrpc.getPointInTimeRestoreMethod)
        == null) {
      synchronized (SqlInstancesServiceGrpc.class) {
        if ((getPointInTimeRestoreMethod = SqlInstancesServiceGrpc.getPointInTimeRestoreMethod)
            == null) {
          SqlInstancesServiceGrpc.getPointInTimeRestoreMethod =
              getPointInTimeRestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PointInTimeRestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlInstancesServiceMethodDescriptorSupplier("PointInTimeRestore"))
                      .build();
        }
      }
    }
    return getPointInTimeRestoreMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlInstancesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlInstancesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlInstancesServiceStub>() {
          @java.lang.Override
          public SqlInstancesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlInstancesServiceStub(channel, callOptions);
          }
        };
    return SqlInstancesServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlInstancesServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlInstancesServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlInstancesServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlInstancesServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlInstancesServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlInstancesServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlInstancesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlInstancesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlInstancesServiceBlockingStub>() {
          @java.lang.Override
          public SqlInstancesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlInstancesServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlInstancesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlInstancesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlInstancesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlInstancesServiceFutureStub>() {
          @java.lang.Override
          public SqlInstancesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlInstancesServiceFutureStub(channel, callOptions);
          }
        };
    return SqlInstancesServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Add a new trusted Certificate Authority (CA) version for the specified
     * instance. Required to prepare for a certificate rotation. If a CA version
     * was previously added but never used in a certificate rotation, this
     * operation replaces that version. There cannot be more than one CA version
     * waiting to be rotated in. For instances that have enabled Certificate
     * Authority Service (CAS) based server CA, use AddServerCertificate to add a
     * new server certificate.
     * </pre>
     */
    default void addServerCa(
        com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddServerCaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted server certificate version for the specified instance
     * using Certificate Authority Service (CAS) server CA. Required to prepare
     * for a certificate rotation. If a server certificate version was previously
     * added but never used in a certificate rotation, this operation replaces
     * that version. There cannot be more than one certificate version waiting to
     * be rotated in. For instances not using CAS server CA, use AddServerCa
     * instead.
     * </pre>
     */
    default void addServerCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddServerCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Entra ID certificate for the specified instance. If an Entra ID
     * certificate was previously added but never used in a certificate rotation,
     * this operation replaces that version.
     * </pre>
     */
    default void addEntraIdCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddEntraIdCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud SQL instance as a clone of the source instance. Using this
     * operation might cause your instance to restart.
     * </pre>
     */
    default void clone(
        com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloneMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Cloud SQL instance.
     * </pre>
     */
    default void delete(
        com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Demotes the stand-alone instance to be a Cloud SQL read replica for an
     * external database server.
     * </pre>
     */
    default void demoteMaster(
        com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDemoteMasterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Demotes an existing standalone instance to be a Cloud SQL read replica
     * for an external database server.
     * </pre>
     */
    default void demote(
        com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDemoteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL
     * dump or CSV file.
     * </pre>
     */
    default void export(
        com.google.cloud.sql.v1beta4.SqlInstancesExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a manual failover of a high availability (HA) primary instance
     * to a standby instance, which becomes the primary instance. Users are
     * then rerouted to the new primary. For more information, see the
     * [Overview of high
     * availability](https://cloud.google.com/sql/docs/mysql/high-availability)
     * page in the Cloud SQL documentation.
     * If using Legacy HA (MySQL only), this causes the instance to failover to
     * its failover replica instance.
     * </pre>
     */
    default void failover(
        com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFailoverMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reencrypt CMEK instance with latest key version.
     * </pre>
     */
    default void reencrypt(
        com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReencryptMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a Cloud SQL instance.
     * </pre>
     */
    default void get(
        com.google.cloud.sql.v1beta4.SqlInstancesGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.DatabaseInstance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Cloud SQL instance from a SQL dump  or CSV file in
     * Cloud Storage.
     * </pre>
     */
    default void import_(
        com.google.cloud.sql.v1beta4.SqlInstancesImportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud SQL instance.
     * </pre>
     */
    default void insert(
        com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists instances under a given project.
     * </pre>
     */
    default void list(
        com.google.cloud.sql.v1beta4.SqlInstancesListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.InstancesListResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the trusted Certificate Authorities (CAs) for the specified
     * instance. There can be up to three CAs listed: the CA that was used to sign
     * the certificate that is currently in use, a CA that has been added but not
     * yet used to sign a certificate, and a CA used to sign a certificate that
     * has previously rotated out.
     * </pre>
     */
    default void listServerCas(
        com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServerCasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of server certificates and certificate authorities (CAs)
     * for the specified instance. There can be up to three sets of certs listed:
     * the certificate that is currently in use, a future that has been added but
     * not yet used to sign a certificate, and a certificate that has been rotated
     * out. For instances not using Certificate Authority Service (CAS) server CA,
     * use ListServerCas instead.
     * </pre>
     */
    default void listServerCertificates(
        com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServerCertificatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of EntraID certificates for the specified instance.
     * There can be up to three sets of certificates listed: the certificate that
     * is currently in use, a future that has been added but not yet used to sign
     * a certificate, and a certificate that has been rotated out.
     * </pre>
     */
    default void listEntraIdCertificates(
        com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntraIdCertificatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates settings of a Cloud SQL instance by merging the request
     * with the current configuration. This method supports patch semantics.
     * </pre>
     */
    default void patch(
        com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPatchMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Promotes the read replica instance to be an independent Cloud SQL
     * primary instance.
     * Using this operation might cause your instance to restart.
     * </pre>
     */
    default void promoteReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPromoteReplicaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Switches over from the primary instance to the DR replica
     * instance.
     * </pre>
     */
    default void switchover(
        com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSwitchoverMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes all client certificates and generates a new server SSL certificate
     * for the instance.
     * </pre>
     */
    default void resetSslConfig(
        com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetSslConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restarts a Cloud SQL instance.
     * </pre>
     */
    default void restart(
        com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestartMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a backup of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    default void restoreBackup(
        com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate to one signed by the Certificate Authority
     * (CA) version previously added with the addServerCA method. For instances
     * that have enabled Certificate Authority Service (CAS) based server CA,
     * use RotateServerCertificate to rotate the server certificate.
     * </pre>
     */
    default void rotateServerCa(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRotateServerCaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate version to one previously added with the
     * addServerCertificate method. For instances not using Certificate Authority
     * Service (CAS) server CA, use RotateServerCa instead.
     * </pre>
     */
    default void rotateServerCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRotateServerCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rotates the Entra Id certificate version to one previously added with the
     * addEntraIdCertificate method.
     * </pre>
     */
    default void rotateEntraIdCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRotateEntraIdCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts the replication in the read replica instance.
     * </pre>
     */
    default void startReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartReplicaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops the replication in the read replica instance.
     * </pre>
     */
    default void stopReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopReplicaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Truncate MySQL general and slow query log tables
     * MySQL only.
     * </pre>
     */
    default void truncateLog(
        com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTruncateLogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    default void update(
        com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    default void createEphemeral(
        com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCert> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEphemeralMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reschedules the maintenance on the given instance.
     * </pre>
     */
    default void rescheduleMaintenance(
        com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRescheduleMaintenanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Verify External primary instance external sync settings.
     * </pre>
     */
    default void verifyExternalSyncSettings(
        com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getVerifyExternalSyncSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start External primary instance migration.
     * </pre>
     */
    default void startExternalSync(
        com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartExternalSyncMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Perform Disk Shrink on primary instance.
     * </pre>
     */
    default void performDiskShrink(
        com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPerformDiskShrinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get Disk Shrink Config for a given instance.
     * </pre>
     */
    default void getDiskShrinkConfig(
        com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDiskShrinkConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reset Replica Size to primary instance disk size.
     * </pre>
     */
    default void resetReplicaSize(
        com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetReplicaSizeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get Latest Recovery Time for a given instance.
     * </pre>
     */
    default void getLatestRecoveryTime(
        com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLatestRecoveryTimeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Execute SQL statements.
     * </pre>
     */
    default void executeSql(
        com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteSqlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Acquire a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    default void acquireSsrsLease(
        com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcquireSsrsLeaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Release a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    default void releaseSsrsLease(
        com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReleaseSsrsLeaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Execute MVU Pre-checks
     * </pre>
     */
    default void preCheckMajorVersionUpgrade(
        com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPreCheckMajorVersionUpgradeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Point in time restore for an instance managed by Google Cloud Backup and
     * Disaster Recovery.
     * </pre>
     */
    default void pointInTimeRestore(
        com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPointInTimeRestoreMethod(), responseObserver);
    }
  }

  /** Base class for the server implementation of the service SqlInstancesService. */
  public abstract static class SqlInstancesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlInstancesServiceGrpc.bindService(this);
    }
  }

  /** A stub to allow clients to do asynchronous rpc calls to service SqlInstancesService. */
  public static final class SqlInstancesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlInstancesServiceStub> {
    private SqlInstancesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlInstancesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlInstancesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted Certificate Authority (CA) version for the specified
     * instance. Required to prepare for a certificate rotation. If a CA version
     * was previously added but never used in a certificate rotation, this
     * operation replaces that version. There cannot be more than one CA version
     * waiting to be rotated in. For instances that have enabled Certificate
     * Authority Service (CAS) based server CA, use AddServerCertificate to add a
     * new server certificate.
     * </pre>
     */
    public void addServerCa(
        com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddServerCaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted server certificate version for the specified instance
     * using Certificate Authority Service (CAS) server CA. Required to prepare
     * for a certificate rotation. If a server certificate version was previously
     * added but never used in a certificate rotation, this operation replaces
     * that version. There cannot be more than one certificate version waiting to
     * be rotated in. For instances not using CAS server CA, use AddServerCa
     * instead.
     * </pre>
     */
    public void addServerCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddServerCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Entra ID certificate for the specified instance. If an Entra ID
     * certificate was previously added but never used in a certificate rotation,
     * this operation replaces that version.
     * </pre>
     */
    public void addEntraIdCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddEntraIdCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud SQL instance as a clone of the source instance. Using this
     * operation might cause your instance to restart.
     * </pre>
     */
    public void clone(
        com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Cloud SQL instance.
     * </pre>
     */
    public void delete(
        com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Demotes the stand-alone instance to be a Cloud SQL read replica for an
     * external database server.
     * </pre>
     */
    public void demoteMaster(
        com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDemoteMasterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Demotes an existing standalone instance to be a Cloud SQL read replica
     * for an external database server.
     * </pre>
     */
    public void demote(
        com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDemoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL
     * dump or CSV file.
     * </pre>
     */
    public void export(
        com.google.cloud.sql.v1beta4.SqlInstancesExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a manual failover of a high availability (HA) primary instance
     * to a standby instance, which becomes the primary instance. Users are
     * then rerouted to the new primary. For more information, see the
     * [Overview of high
     * availability](https://cloud.google.com/sql/docs/mysql/high-availability)
     * page in the Cloud SQL documentation.
     * If using Legacy HA (MySQL only), this causes the instance to failover to
     * its failover replica instance.
     * </pre>
     */
    public void failover(
        com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFailoverMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reencrypt CMEK instance with latest key version.
     * </pre>
     */
    public void reencrypt(
        com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReencryptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a Cloud SQL instance.
     * </pre>
     */
    public void get(
        com.google.cloud.sql.v1beta4.SqlInstancesGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.DatabaseInstance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Cloud SQL instance from a SQL dump  or CSV file in
     * Cloud Storage.
     * </pre>
     */
    public void import_(
        com.google.cloud.sql.v1beta4.SqlInstancesImportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud SQL instance.
     * </pre>
     */
    public void insert(
        com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists instances under a given project.
     * </pre>
     */
    public void list(
        com.google.cloud.sql.v1beta4.SqlInstancesListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.InstancesListResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the trusted Certificate Authorities (CAs) for the specified
     * instance. There can be up to three CAs listed: the CA that was used to sign
     * the certificate that is currently in use, a CA that has been added but not
     * yet used to sign a certificate, and a CA used to sign a certificate that
     * has previously rotated out.
     * </pre>
     */
    public void listServerCas(
        com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServerCasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of server certificates and certificate authorities (CAs)
     * for the specified instance. There can be up to three sets of certs listed:
     * the certificate that is currently in use, a future that has been added but
     * not yet used to sign a certificate, and a certificate that has been rotated
     * out. For instances not using Certificate Authority Service (CAS) server CA,
     * use ListServerCas instead.
     * </pre>
     */
    public void listServerCertificates(
        com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServerCertificatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of EntraID certificates for the specified instance.
     * There can be up to three sets of certificates listed: the certificate that
     * is currently in use, a future that has been added but not yet used to sign
     * a certificate, and a certificate that has been rotated out.
     * </pre>
     */
    public void listEntraIdCertificates(
        com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntraIdCertificatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Partially updates settings of a Cloud SQL instance by merging the request
     * with the current configuration. This method supports patch semantics.
     * </pre>
     */
    public void patch(
        com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Promotes the read replica instance to be an independent Cloud SQL
     * primary instance.
     * Using this operation might cause your instance to restart.
     * </pre>
     */
    public void promoteReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPromoteReplicaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Switches over from the primary instance to the DR replica
     * instance.
     * </pre>
     */
    public void switchover(
        com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchoverMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes all client certificates and generates a new server SSL certificate
     * for the instance.
     * </pre>
     */
    public void resetSslConfig(
        com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetSslConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restarts a Cloud SQL instance.
     * </pre>
     */
    public void restart(
        com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a backup of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    public void restoreBackup(
        com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate to one signed by the Certificate Authority
     * (CA) version previously added with the addServerCA method. For instances
     * that have enabled Certificate Authority Service (CAS) based server CA,
     * use RotateServerCertificate to rotate the server certificate.
     * </pre>
     */
    public void rotateServerCa(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRotateServerCaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate version to one previously added with the
     * addServerCertificate method. For instances not using Certificate Authority
     * Service (CAS) server CA, use RotateServerCa instead.
     * </pre>
     */
    public void rotateServerCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRotateServerCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rotates the Entra Id certificate version to one previously added with the
     * addEntraIdCertificate method.
     * </pre>
     */
    public void rotateEntraIdCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRotateEntraIdCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts the replication in the read replica instance.
     * </pre>
     */
    public void startReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartReplicaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops the replication in the read replica instance.
     * </pre>
     */
    public void stopReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopReplicaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Truncate MySQL general and slow query log tables
     * MySQL only.
     * </pre>
     */
    public void truncateLog(
        com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTruncateLogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    public void update(
        com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    public void createEphemeral(
        com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCert> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEphemeralMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reschedules the maintenance on the given instance.
     * </pre>
     */
    public void rescheduleMaintenance(
        com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRescheduleMaintenanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Verify External primary instance external sync settings.
     * </pre>
     */
    public void verifyExternalSyncSettings(
        com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyExternalSyncSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start External primary instance migration.
     * </pre>
     */
    public void startExternalSync(
        com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartExternalSyncMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Perform Disk Shrink on primary instance.
     * </pre>
     */
    public void performDiskShrink(
        com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPerformDiskShrinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get Disk Shrink Config for a given instance.
     * </pre>
     */
    public void getDiskShrinkConfig(
        com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDiskShrinkConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reset Replica Size to primary instance disk size.
     * </pre>
     */
    public void resetReplicaSize(
        com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetReplicaSizeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get Latest Recovery Time for a given instance.
     * </pre>
     */
    public void getLatestRecoveryTime(
        com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLatestRecoveryTimeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Execute SQL statements.
     * </pre>
     */
    public void executeSql(
        com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteSqlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Acquire a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    public void acquireSsrsLease(
        com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcquireSsrsLeaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Release a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    public void releaseSsrsLease(
        com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReleaseSsrsLeaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Execute MVU Pre-checks
     * </pre>
     */
    public void preCheckMajorVersionUpgrade(
        com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPreCheckMajorVersionUpgradeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Point in time restore for an instance managed by Google Cloud Backup and
     * Disaster Recovery.
     * </pre>
     */
    public void pointInTimeRestore(
        com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPointInTimeRestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** A stub to allow clients to do synchronous rpc calls to service SqlInstancesService. */
  public static final class SqlInstancesServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlInstancesServiceBlockingV2Stub> {
    private SqlInstancesServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlInstancesServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlInstancesServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted Certificate Authority (CA) version for the specified
     * instance. Required to prepare for a certificate rotation. If a CA version
     * was previously added but never used in a certificate rotation, this
     * operation replaces that version. There cannot be more than one CA version
     * waiting to be rotated in. For instances that have enabled Certificate
     * Authority Service (CAS) based server CA, use AddServerCertificate to add a
     * new server certificate.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation addServerCa(
        com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddServerCaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted server certificate version for the specified instance
     * using Certificate Authority Service (CAS) server CA. Required to prepare
     * for a certificate rotation. If a server certificate version was previously
     * added but never used in a certificate rotation, this operation replaces
     * that version. There cannot be more than one certificate version waiting to
     * be rotated in. For instances not using CAS server CA, use AddServerCa
     * instead.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation addServerCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddServerCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Entra ID certificate for the specified instance. If an Entra ID
     * certificate was previously added but never used in a certificate rotation,
     * this operation replaces that version.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation addEntraIdCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddEntraIdCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud SQL instance as a clone of the source instance. Using this
     * operation might cause your instance to restart.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation clone(
        com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCloneMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation delete(
        com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Demotes the stand-alone instance to be a Cloud SQL read replica for an
     * external database server.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation demoteMaster(
        com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDemoteMasterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Demotes an existing standalone instance to be a Cloud SQL read replica
     * for an external database server.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation demote(
        com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDemoteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL
     * dump or CSV file.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation export(
        com.google.cloud.sql.v1beta4.SqlInstancesExportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a manual failover of a high availability (HA) primary instance
     * to a standby instance, which becomes the primary instance. Users are
     * then rerouted to the new primary. For more information, see the
     * [Overview of high
     * availability](https://cloud.google.com/sql/docs/mysql/high-availability)
     * page in the Cloud SQL documentation.
     * If using Legacy HA (MySQL only), this causes the instance to failover to
     * its failover replica instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation failover(
        com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFailoverMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reencrypt CMEK instance with latest key version.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation reencrypt(
        com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReencryptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.DatabaseInstance get(
        com.google.cloud.sql.v1beta4.SqlInstancesGetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Cloud SQL instance from a SQL dump  or CSV file in
     * Cloud Storage.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation import_(
        com.google.cloud.sql.v1beta4.SqlInstancesImportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation insert(
        com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists instances under a given project.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.InstancesListResponse list(
        com.google.cloud.sql.v1beta4.SqlInstancesListRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the trusted Certificate Authorities (CAs) for the specified
     * instance. There can be up to three CAs listed: the CA that was used to sign
     * the certificate that is currently in use, a CA that has been added but not
     * yet used to sign a certificate, and a CA used to sign a certificate that
     * has previously rotated out.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.InstancesListServerCasResponse listServerCas(
        com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListServerCasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of server certificates and certificate authorities (CAs)
     * for the specified instance. There can be up to three sets of certs listed:
     * the certificate that is currently in use, a future that has been added but
     * not yet used to sign a certificate, and a certificate that has been rotated
     * out. For instances not using Certificate Authority Service (CAS) server CA,
     * use ListServerCas instead.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse
        listServerCertificates(
            com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListServerCertificatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of EntraID certificates for the specified instance.
     * There can be up to three sets of certificates listed: the certificate that
     * is currently in use, a future that has been added but not yet used to sign
     * a certificate, and a certificate that has been rotated out.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse
        listEntraIdCertificates(
            com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEntraIdCertificatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates settings of a Cloud SQL instance by merging the request
     * with the current configuration. This method supports patch semantics.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation patch(
        com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPatchMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Promotes the read replica instance to be an independent Cloud SQL
     * primary instance.
     * Using this operation might cause your instance to restart.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation promoteReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPromoteReplicaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Switches over from the primary instance to the DR replica
     * instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation switchover(
        com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSwitchoverMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes all client certificates and generates a new server SSL certificate
     * for the instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation resetSslConfig(
        com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getResetSslConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation restart(
        com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a backup of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation restoreBackup(
        com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestoreBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate to one signed by the Certificate Authority
     * (CA) version previously added with the addServerCA method. For instances
     * that have enabled Certificate Authority Service (CAS) based server CA,
     * use RotateServerCertificate to rotate the server certificate.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation rotateServerCa(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRotateServerCaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate version to one previously added with the
     * addServerCertificate method. For instances not using Certificate Authority
     * Service (CAS) server CA, use RotateServerCa instead.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation rotateServerCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRotateServerCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the Entra Id certificate version to one previously added with the
     * addEntraIdCertificate method.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation rotateEntraIdCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRotateEntraIdCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts the replication in the read replica instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation startReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartReplicaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops the replication in the read replica instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation stopReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopReplicaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Truncate MySQL general and slow query log tables
     * MySQL only.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation truncateLog(
        com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTruncateLogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation update(
        com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SslCert createEphemeral(
        com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateEphemeralMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reschedules the maintenance on the given instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation rescheduleMaintenance(
        com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRescheduleMaintenanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Verify External primary instance external sync settings.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse
        verifyExternalSyncSettings(
            com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getVerifyExternalSyncSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Start External primary instance migration.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation startExternalSync(
        com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartExternalSyncMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Perform Disk Shrink on primary instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation performDiskShrink(
        com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPerformDiskShrinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get Disk Shrink Config for a given instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse getDiskShrinkConfig(
        com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDiskShrinkConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reset Replica Size to primary instance disk size.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation resetReplicaSize(
        com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getResetReplicaSizeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get Latest Recovery Time for a given instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse
        getLatestRecoveryTime(
            com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetLatestRecoveryTimeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Execute SQL statements.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse executeSql(
        com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExecuteSqlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Acquire a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse acquireSsrsLease(
        com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAcquireSsrsLeaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Release a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse releaseSsrsLease(
        com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReleaseSsrsLeaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Execute MVU Pre-checks
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation preCheckMajorVersionUpgrade(
        com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPreCheckMajorVersionUpgradeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Point in time restore for an instance managed by Google Cloud Backup and
     * Disaster Recovery.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation pointInTimeRestore(
        com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPointInTimeRestoreMethod(), getCallOptions(), request);
    }
  }

  /** A stub to allow clients to do limited synchronous rpc calls to service SqlInstancesService. */
  public static final class SqlInstancesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlInstancesServiceBlockingStub> {
    private SqlInstancesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlInstancesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlInstancesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted Certificate Authority (CA) version for the specified
     * instance. Required to prepare for a certificate rotation. If a CA version
     * was previously added but never used in a certificate rotation, this
     * operation replaces that version. There cannot be more than one CA version
     * waiting to be rotated in. For instances that have enabled Certificate
     * Authority Service (CAS) based server CA, use AddServerCertificate to add a
     * new server certificate.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation addServerCa(
        com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddServerCaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted server certificate version for the specified instance
     * using Certificate Authority Service (CAS) server CA. Required to prepare
     * for a certificate rotation. If a server certificate version was previously
     * added but never used in a certificate rotation, this operation replaces
     * that version. There cannot be more than one certificate version waiting to
     * be rotated in. For instances not using CAS server CA, use AddServerCa
     * instead.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation addServerCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddServerCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Entra ID certificate for the specified instance. If an Entra ID
     * certificate was previously added but never used in a certificate rotation,
     * this operation replaces that version.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation addEntraIdCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddEntraIdCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud SQL instance as a clone of the source instance. Using this
     * operation might cause your instance to restart.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation clone(
        com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloneMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation delete(
        com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Demotes the stand-alone instance to be a Cloud SQL read replica for an
     * external database server.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation demoteMaster(
        com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDemoteMasterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Demotes an existing standalone instance to be a Cloud SQL read replica
     * for an external database server.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation demote(
        com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDemoteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL
     * dump or CSV file.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation export(
        com.google.cloud.sql.v1beta4.SqlInstancesExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a manual failover of a high availability (HA) primary instance
     * to a standby instance, which becomes the primary instance. Users are
     * then rerouted to the new primary. For more information, see the
     * [Overview of high
     * availability](https://cloud.google.com/sql/docs/mysql/high-availability)
     * page in the Cloud SQL documentation.
     * If using Legacy HA (MySQL only), this causes the instance to failover to
     * its failover replica instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation failover(
        com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFailoverMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reencrypt CMEK instance with latest key version.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation reencrypt(
        com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReencryptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.DatabaseInstance get(
        com.google.cloud.sql.v1beta4.SqlInstancesGetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Cloud SQL instance from a SQL dump  or CSV file in
     * Cloud Storage.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation import_(
        com.google.cloud.sql.v1beta4.SqlInstancesImportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation insert(
        com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists instances under a given project.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.InstancesListResponse list(
        com.google.cloud.sql.v1beta4.SqlInstancesListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the trusted Certificate Authorities (CAs) for the specified
     * instance. There can be up to three CAs listed: the CA that was used to sign
     * the certificate that is currently in use, a CA that has been added but not
     * yet used to sign a certificate, and a CA used to sign a certificate that
     * has previously rotated out.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.InstancesListServerCasResponse listServerCas(
        com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServerCasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of server certificates and certificate authorities (CAs)
     * for the specified instance. There can be up to three sets of certs listed:
     * the certificate that is currently in use, a future that has been added but
     * not yet used to sign a certificate, and a certificate that has been rotated
     * out. For instances not using Certificate Authority Service (CAS) server CA,
     * use ListServerCas instead.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse
        listServerCertificates(
            com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServerCertificatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of EntraID certificates for the specified instance.
     * There can be up to three sets of certificates listed: the certificate that
     * is currently in use, a future that has been added but not yet used to sign
     * a certificate, and a certificate that has been rotated out.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse
        listEntraIdCertificates(
            com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntraIdCertificatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates settings of a Cloud SQL instance by merging the request
     * with the current configuration. This method supports patch semantics.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation patch(
        com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPatchMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Promotes the read replica instance to be an independent Cloud SQL
     * primary instance.
     * Using this operation might cause your instance to restart.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation promoteReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPromoteReplicaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Switches over from the primary instance to the DR replica
     * instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation switchover(
        com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchoverMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes all client certificates and generates a new server SSL certificate
     * for the instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation resetSslConfig(
        com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetSslConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation restart(
        com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a backup of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation restoreBackup(
        com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate to one signed by the Certificate Authority
     * (CA) version previously added with the addServerCA method. For instances
     * that have enabled Certificate Authority Service (CAS) based server CA,
     * use RotateServerCertificate to rotate the server certificate.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation rotateServerCa(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRotateServerCaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate version to one previously added with the
     * addServerCertificate method. For instances not using Certificate Authority
     * Service (CAS) server CA, use RotateServerCa instead.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation rotateServerCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRotateServerCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the Entra Id certificate version to one previously added with the
     * addEntraIdCertificate method.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation rotateEntraIdCertificate(
        com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRotateEntraIdCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts the replication in the read replica instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation startReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartReplicaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops the replication in the read replica instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation stopReplica(
        com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopReplicaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Truncate MySQL general and slow query log tables
     * MySQL only.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation truncateLog(
        com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTruncateLogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation update(
        com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SslCert createEphemeral(
        com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEphemeralMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reschedules the maintenance on the given instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation rescheduleMaintenance(
        com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRescheduleMaintenanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Verify External primary instance external sync settings.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse
        verifyExternalSyncSettings(
            com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyExternalSyncSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Start External primary instance migration.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation startExternalSync(
        com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartExternalSyncMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Perform Disk Shrink on primary instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation performDiskShrink(
        com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPerformDiskShrinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get Disk Shrink Config for a given instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse getDiskShrinkConfig(
        com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDiskShrinkConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reset Replica Size to primary instance disk size.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation resetReplicaSize(
        com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetReplicaSizeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get Latest Recovery Time for a given instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse
        getLatestRecoveryTime(
            com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLatestRecoveryTimeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Execute SQL statements.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse executeSql(
        com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteSqlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Acquire a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse acquireSsrsLease(
        com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcquireSsrsLeaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Release a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse releaseSsrsLease(
        com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReleaseSsrsLeaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Execute MVU Pre-checks
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation preCheckMajorVersionUpgrade(
        com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPreCheckMajorVersionUpgradeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Point in time restore for an instance managed by Google Cloud Backup and
     * Disaster Recovery.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation pointInTimeRestore(
        com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPointInTimeRestoreMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlInstancesService.
   */
  public static final class SqlInstancesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlInstancesServiceFutureStub> {
    private SqlInstancesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlInstancesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlInstancesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted Certificate Authority (CA) version for the specified
     * instance. Required to prepare for a certificate rotation. If a CA version
     * was previously added but never used in a certificate rotation, this
     * operation replaces that version. There cannot be more than one CA version
     * waiting to be rotated in. For instances that have enabled Certificate
     * Authority Service (CAS) based server CA, use AddServerCertificate to add a
     * new server certificate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        addServerCa(com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddServerCaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Add a new trusted server certificate version for the specified instance
     * using Certificate Authority Service (CAS) server CA. Required to prepare
     * for a certificate rotation. If a server certificate version was previously
     * added but never used in a certificate rotation, this operation replaces
     * that version. There cannot be more than one certificate version waiting to
     * be rotated in. For instances not using CAS server CA, use AddServerCa
     * instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        addServerCertificate(
            com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddServerCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Entra ID certificate for the specified instance. If an Entra ID
     * certificate was previously added but never used in a certificate rotation,
     * this operation replaces that version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        addEntraIdCertificate(
            com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddEntraIdCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud SQL instance as a clone of the source instance. Using this
     * operation might cause your instance to restart.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        clone(com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloneMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        delete(com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Demotes the stand-alone instance to be a Cloud SQL read replica for an
     * external database server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        demoteMaster(com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDemoteMasterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Demotes an existing standalone instance to be a Cloud SQL read replica
     * for an external database server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        demote(com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDemoteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL
     * dump or CSV file.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        export(com.google.cloud.sql.v1beta4.SqlInstancesExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a manual failover of a high availability (HA) primary instance
     * to a standby instance, which becomes the primary instance. Users are
     * then rerouted to the new primary. For more information, see the
     * [Overview of high
     * availability](https://cloud.google.com/sql/docs/mysql/high-availability)
     * page in the Cloud SQL documentation.
     * If using Legacy HA (MySQL only), this causes the instance to failover to
     * its failover replica instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        failover(com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFailoverMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reencrypt CMEK instance with latest key version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        reencrypt(com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReencryptMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.DatabaseInstance>
        get(com.google.cloud.sql.v1beta4.SqlInstancesGetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data into a Cloud SQL instance from a SQL dump  or CSV file in
     * Cloud Storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        import_(com.google.cloud.sql.v1beta4.SqlInstancesImportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        insert(com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists instances under a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.InstancesListResponse>
        list(com.google.cloud.sql.v1beta4.SqlInstancesListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all of the trusted Certificate Authorities (CAs) for the specified
     * instance. There can be up to three CAs listed: the CA that was used to sign
     * the certificate that is currently in use, a CA that has been added but not
     * yet used to sign a certificate, and a CA used to sign a certificate that
     * has previously rotated out.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>
        listServerCas(com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServerCasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of server certificates and certificate authorities (CAs)
     * for the specified instance. There can be up to three sets of certs listed:
     * the certificate that is currently in use, a future that has been added but
     * not yet used to sign a certificate, and a certificate that has been rotated
     * out. For instances not using Certificate Authority Service (CAS) server CA,
     * use ListServerCas instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>
        listServerCertificates(
            com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServerCertificatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of EntraID certificates for the specified instance.
     * There can be up to three sets of certificates listed: the certificate that
     * is currently in use, a future that has been added but not yet used to sign
     * a certificate, and a certificate that has been rotated out.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>
        listEntraIdCertificates(
            com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntraIdCertificatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Partially updates settings of a Cloud SQL instance by merging the request
     * with the current configuration. This method supports patch semantics.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        patch(com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPatchMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Promotes the read replica instance to be an independent Cloud SQL
     * primary instance.
     * Using this operation might cause your instance to restart.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        promoteReplica(com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPromoteReplicaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Switches over from the primary instance to the DR replica
     * instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        switchover(com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchoverMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes all client certificates and generates a new server SSL certificate
     * for the instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        resetSslConfig(com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetSslConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts a Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        restart(com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a backup of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        restoreBackup(com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate to one signed by the Certificate Authority
     * (CA) version previously added with the addServerCA method. For instances
     * that have enabled Certificate Authority Service (CAS) based server CA,
     * use RotateServerCertificate to rotate the server certificate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        rotateServerCa(com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRotateServerCaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the server certificate version to one previously added with the
     * addServerCertificate method. For instances not using Certificate Authority
     * Service (CAS) server CA, use RotateServerCa instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        rotateServerCertificate(
            com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRotateServerCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rotates the Entra Id certificate version to one previously added with the
     * addEntraIdCertificate method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        rotateEntraIdCertificate(
            com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRotateEntraIdCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts the replication in the read replica instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        startReplica(com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartReplicaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops the replication in the read replica instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        stopReplica(com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopReplicaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Truncate MySQL general and slow query log tables
     * MySQL only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        truncateLog(com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTruncateLogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a Cloud SQL instance. Using this operation might cause
     * your instance to restart.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        update(com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a short-lived X509 certificate containing the provided public key
     * and signed by a private key specific to the target instance. Users may use
     * the certificate to authenticate as themselves when connecting to the
     * database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1beta4.SslCert>
        createEphemeral(
            com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEphemeralMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reschedules the maintenance on the given instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        rescheduleMaintenance(
            com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRescheduleMaintenanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Verify External primary instance external sync settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse>
        verifyExternalSyncSettings(
            com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyExternalSyncSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Start External primary instance migration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        startExternalSync(
            com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartExternalSyncMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Perform Disk Shrink on primary instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        performDiskShrink(
            com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPerformDiskShrinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get Disk Shrink Config for a given instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>
        getDiskShrinkConfig(
            com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDiskShrinkConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reset Replica Size to primary instance disk size.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        resetReplicaSize(com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetReplicaSizeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get Latest Recovery Time for a given instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>
        getLatestRecoveryTime(
            com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLatestRecoveryTimeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Execute SQL statements.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>
        executeSql(com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteSqlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Acquire a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>
        acquireSsrsLease(com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcquireSsrsLeaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Release a lease for the setup of SQL Server Reporting Services (SSRS).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>
        releaseSsrsLease(com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReleaseSsrsLeaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Execute MVU Pre-checks
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        preCheckMajorVersionUpgrade(
            com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPreCheckMajorVersionUpgradeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Point in time restore for an instance managed by Google Cloud Backup and
     * Disaster Recovery.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        pointInTimeRestore(
            com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPointInTimeRestoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SERVER_CA = 0;
  private static final int METHODID_ADD_SERVER_CERTIFICATE = 1;
  private static final int METHODID_ADD_ENTRA_ID_CERTIFICATE = 2;
  private static final int METHODID_CLONE = 3;
  private static final int METHODID_DELETE = 4;
  private static final int METHODID_DEMOTE_MASTER = 5;
  private static final int METHODID_DEMOTE = 6;
  private static final int METHODID_EXPORT = 7;
  private static final int METHODID_FAILOVER = 8;
  private static final int METHODID_REENCRYPT = 9;
  private static final int METHODID_GET = 10;
  private static final int METHODID_IMPORT = 11;
  private static final int METHODID_INSERT = 12;
  private static final int METHODID_LIST = 13;
  private static final int METHODID_LIST_SERVER_CAS = 14;
  private static final int METHODID_LIST_SERVER_CERTIFICATES = 15;
  private static final int METHODID_LIST_ENTRA_ID_CERTIFICATES = 16;
  private static final int METHODID_PATCH = 17;
  private static final int METHODID_PROMOTE_REPLICA = 18;
  private static final int METHODID_SWITCHOVER = 19;
  private static final int METHODID_RESET_SSL_CONFIG = 20;
  private static final int METHODID_RESTART = 21;
  private static final int METHODID_RESTORE_BACKUP = 22;
  private static final int METHODID_ROTATE_SERVER_CA = 23;
  private static final int METHODID_ROTATE_SERVER_CERTIFICATE = 24;
  private static final int METHODID_ROTATE_ENTRA_ID_CERTIFICATE = 25;
  private static final int METHODID_START_REPLICA = 26;
  private static final int METHODID_STOP_REPLICA = 27;
  private static final int METHODID_TRUNCATE_LOG = 28;
  private static final int METHODID_UPDATE = 29;
  private static final int METHODID_CREATE_EPHEMERAL = 30;
  private static final int METHODID_RESCHEDULE_MAINTENANCE = 31;
  private static final int METHODID_VERIFY_EXTERNAL_SYNC_SETTINGS = 32;
  private static final int METHODID_START_EXTERNAL_SYNC = 33;
  private static final int METHODID_PERFORM_DISK_SHRINK = 34;
  private static final int METHODID_GET_DISK_SHRINK_CONFIG = 35;
  private static final int METHODID_RESET_REPLICA_SIZE = 36;
  private static final int METHODID_GET_LATEST_RECOVERY_TIME = 37;
  private static final int METHODID_EXECUTE_SQL = 38;
  private static final int METHODID_ACQUIRE_SSRS_LEASE = 39;
  private static final int METHODID_RELEASE_SSRS_LEASE = 40;
  private static final int METHODID_PRE_CHECK_MAJOR_VERSION_UPGRADE = 41;
  private static final int METHODID_POINT_IN_TIME_RESTORE = 42;

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
        case METHODID_ADD_SERVER_CA:
          serviceImpl.addServerCa(
              (com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_ADD_SERVER_CERTIFICATE:
          serviceImpl.addServerCertificate(
              (com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_ADD_ENTRA_ID_CERTIFICATE:
          serviceImpl.addEntraIdCertificate(
              (com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_CLONE:
          serviceImpl.clone(
              (com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete(
              (com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_DEMOTE_MASTER:
          serviceImpl.demoteMaster(
              (com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_DEMOTE:
          serviceImpl.demote(
              (com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_EXPORT:
          serviceImpl.export(
              (com.google.cloud.sql.v1beta4.SqlInstancesExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_FAILOVER:
          serviceImpl.failover(
              (com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_REENCRYPT:
          serviceImpl.reencrypt(
              (com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get(
              (com.google.cloud.sql.v1beta4.SqlInstancesGetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.DatabaseInstance>)
                  responseObserver);
          break;
        case METHODID_IMPORT:
          serviceImpl.import_(
              (com.google.cloud.sql.v1beta4.SqlInstancesImportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert(
              (com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list(
              (com.google.cloud.sql.v1beta4.SqlInstancesListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.InstancesListResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SERVER_CAS:
          serviceImpl.listServerCas(
              (com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SERVER_CERTIFICATES:
          serviceImpl.listServerCertificates(
              (com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ENTRA_ID_CERTIFICATES:
          serviceImpl.listEntraIdCertificates(
              (com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>)
                  responseObserver);
          break;
        case METHODID_PATCH:
          serviceImpl.patch(
              (com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_PROMOTE_REPLICA:
          serviceImpl.promoteReplica(
              (com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_SWITCHOVER:
          serviceImpl.switchover(
              (com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_RESET_SSL_CONFIG:
          serviceImpl.resetSslConfig(
              (com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_RESTART:
          serviceImpl.restart(
              (com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_RESTORE_BACKUP:
          serviceImpl.restoreBackup(
              (com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_ROTATE_SERVER_CA:
          serviceImpl.rotateServerCa(
              (com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_ROTATE_SERVER_CERTIFICATE:
          serviceImpl.rotateServerCertificate(
              (com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_ROTATE_ENTRA_ID_CERTIFICATE:
          serviceImpl.rotateEntraIdCertificate(
              (com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_START_REPLICA:
          serviceImpl.startReplica(
              (com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_STOP_REPLICA:
          serviceImpl.stopReplica(
              (com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_TRUNCATE_LOG:
          serviceImpl.truncateLog(
              (com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update(
              (com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_CREATE_EPHEMERAL:
          serviceImpl.createEphemeral(
              (com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.SslCert>) responseObserver);
          break;
        case METHODID_RESCHEDULE_MAINTENANCE:
          serviceImpl.rescheduleMaintenance(
              (com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_VERIFY_EXTERNAL_SYNC_SETTINGS:
          serviceImpl.verifyExternalSyncSettings(
              (com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse>)
                  responseObserver);
          break;
        case METHODID_START_EXTERNAL_SYNC:
          serviceImpl.startExternalSync(
              (com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_PERFORM_DISK_SHRINK:
          serviceImpl.performDiskShrink(
              (com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_GET_DISK_SHRINK_CONFIG:
          serviceImpl.getDiskShrinkConfig(
              (com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>)
                  responseObserver);
          break;
        case METHODID_RESET_REPLICA_SIZE:
          serviceImpl.resetReplicaSize(
              (com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_GET_LATEST_RECOVERY_TIME:
          serviceImpl.getLatestRecoveryTime(
              (com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>)
                  responseObserver);
          break;
        case METHODID_EXECUTE_SQL:
          serviceImpl.executeSql(
              (com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>)
                  responseObserver);
          break;
        case METHODID_ACQUIRE_SSRS_LEASE:
          serviceImpl.acquireSsrsLease(
              (com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>)
                  responseObserver);
          break;
        case METHODID_RELEASE_SSRS_LEASE:
          serviceImpl.releaseSsrsLease(
              (com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>)
                  responseObserver);
          break;
        case METHODID_PRE_CHECK_MAJOR_VERSION_UPGRADE:
          serviceImpl.preCheckMajorVersionUpgrade(
              (com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_POINT_IN_TIME_RESTORE:
          serviceImpl.pointInTimeRestore(
              (com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
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
            getAddServerCaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesAddServerCaRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_ADD_SERVER_CA)))
        .addMethod(
            getAddServerCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesAddServerCertificateRequest,
                    com.google.cloud.sql.v1beta4.Operation>(
                    service, METHODID_ADD_SERVER_CERTIFICATE)))
        .addMethod(
            getAddEntraIdCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesAddEntraIdCertificateRequest,
                    com.google.cloud.sql.v1beta4.Operation>(
                    service, METHODID_ADD_ENTRA_ID_CERTIFICATE)))
        .addMethod(
            getCloneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesCloneRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_CLONE)))
        .addMethod(
            getDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesDeleteRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_DELETE)))
        .addMethod(
            getDemoteMasterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_DEMOTE_MASTER)))
        .addMethod(
            getDemoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesDemoteRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_DEMOTE)))
        .addMethod(
            getExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesExportRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_EXPORT)))
        .addMethod(
            getFailoverMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesFailoverRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_FAILOVER)))
        .addMethod(
            getReencryptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesReencryptRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_REENCRYPT)))
        .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesGetRequest,
                    com.google.cloud.sql.v1beta4.DatabaseInstance>(service, METHODID_GET)))
        .addMethod(
            getImportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesImportRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_IMPORT)))
        .addMethod(
            getInsertMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesInsertRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_INSERT)))
        .addMethod(
            getListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesListRequest,
                    com.google.cloud.sql.v1beta4.InstancesListResponse>(service, METHODID_LIST)))
        .addMethod(
            getListServerCasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesListServerCasRequest,
                    com.google.cloud.sql.v1beta4.InstancesListServerCasResponse>(
                    service, METHODID_LIST_SERVER_CAS)))
        .addMethod(
            getListServerCertificatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesListServerCertificatesRequest,
                    com.google.cloud.sql.v1beta4.InstancesListServerCertificatesResponse>(
                    service, METHODID_LIST_SERVER_CERTIFICATES)))
        .addMethod(
            getListEntraIdCertificatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesListEntraIdCertificatesRequest,
                    com.google.cloud.sql.v1beta4.InstancesListEntraIdCertificatesResponse>(
                    service, METHODID_LIST_ENTRA_ID_CERTIFICATES)))
        .addMethod(
            getPatchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesPatchRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_PATCH)))
        .addMethod(
            getPromoteReplicaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesPromoteReplicaRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_PROMOTE_REPLICA)))
        .addMethod(
            getSwitchoverMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesSwitchoverRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_SWITCHOVER)))
        .addMethod(
            getResetSslConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesResetSslConfigRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_RESET_SSL_CONFIG)))
        .addMethod(
            getRestartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesRestartRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_RESTART)))
        .addMethod(
            getRestoreBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesRestoreBackupRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_RESTORE_BACKUP)))
        .addMethod(
            getRotateServerCaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCaRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_ROTATE_SERVER_CA)))
        .addMethod(
            getRotateServerCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesRotateServerCertificateRequest,
                    com.google.cloud.sql.v1beta4.Operation>(
                    service, METHODID_ROTATE_SERVER_CERTIFICATE)))
        .addMethod(
            getRotateEntraIdCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesRotateEntraIdCertificateRequest,
                    com.google.cloud.sql.v1beta4.Operation>(
                    service, METHODID_ROTATE_ENTRA_ID_CERTIFICATE)))
        .addMethod(
            getStartReplicaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesStartReplicaRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_START_REPLICA)))
        .addMethod(
            getStopReplicaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesStopReplicaRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_STOP_REPLICA)))
        .addMethod(
            getTruncateLogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesTruncateLogRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_TRUNCATE_LOG)))
        .addMethod(
            getUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesUpdateRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_UPDATE)))
        .addMethod(
            getCreateEphemeralMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesCreateEphemeralCertRequest,
                    com.google.cloud.sql.v1beta4.SslCert>(service, METHODID_CREATE_EPHEMERAL)))
        .addMethod(
            getRescheduleMaintenanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesRescheduleMaintenanceRequest,
                    com.google.cloud.sql.v1beta4.Operation>(
                    service, METHODID_RESCHEDULE_MAINTENANCE)))
        .addMethod(
            getVerifyExternalSyncSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsRequest,
                    com.google.cloud.sql.v1beta4.SqlInstancesVerifyExternalSyncSettingsResponse>(
                    service, METHODID_VERIFY_EXTERNAL_SYNC_SETTINGS)))
        .addMethod(
            getStartExternalSyncMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesStartExternalSyncRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_START_EXTERNAL_SYNC)))
        .addMethod(
            getPerformDiskShrinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesPerformDiskShrinkRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_PERFORM_DISK_SHRINK)))
        .addMethod(
            getGetDiskShrinkConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigRequest,
                    com.google.cloud.sql.v1beta4.SqlInstancesGetDiskShrinkConfigResponse>(
                    service, METHODID_GET_DISK_SHRINK_CONFIG)))
        .addMethod(
            getResetReplicaSizeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesResetReplicaSizeRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_RESET_REPLICA_SIZE)))
        .addMethod(
            getGetLatestRecoveryTimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeRequest,
                    com.google.cloud.sql.v1beta4.SqlInstancesGetLatestRecoveryTimeResponse>(
                    service, METHODID_GET_LATEST_RECOVERY_TIME)))
        .addMethod(
            getExecuteSqlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlRequest,
                    com.google.cloud.sql.v1beta4.SqlInstancesExecuteSqlResponse>(
                    service, METHODID_EXECUTE_SQL)))
        .addMethod(
            getAcquireSsrsLeaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseRequest,
                    com.google.cloud.sql.v1beta4.SqlInstancesAcquireSsrsLeaseResponse>(
                    service, METHODID_ACQUIRE_SSRS_LEASE)))
        .addMethod(
            getReleaseSsrsLeaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseRequest,
                    com.google.cloud.sql.v1beta4.SqlInstancesReleaseSsrsLeaseResponse>(
                    service, METHODID_RELEASE_SSRS_LEASE)))
        .addMethod(
            getPreCheckMajorVersionUpgradeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesPreCheckMajorVersionUpgradeRequest,
                    com.google.cloud.sql.v1beta4.Operation>(
                    service, METHODID_PRE_CHECK_MAJOR_VERSION_UPGRADE)))
        .addMethod(
            getPointInTimeRestoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlInstancesPointInTimeRestoreRequest,
                    com.google.cloud.sql.v1beta4.Operation>(
                    service, METHODID_POINT_IN_TIME_RESTORE)))
        .build();
  }

  private abstract static class SqlInstancesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlInstancesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1beta4.CloudSqlServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlInstancesService");
    }
  }

  private static final class SqlInstancesServiceFileDescriptorSupplier
      extends SqlInstancesServiceBaseDescriptorSupplier {
    SqlInstancesServiceFileDescriptorSupplier() {}
  }

  private static final class SqlInstancesServiceMethodDescriptorSupplier
      extends SqlInstancesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlInstancesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlInstancesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlInstancesServiceFileDescriptorSupplier())
                      .addMethod(getAddServerCaMethod())
                      .addMethod(getAddServerCertificateMethod())
                      .addMethod(getAddEntraIdCertificateMethod())
                      .addMethod(getCloneMethod())
                      .addMethod(getDeleteMethod())
                      .addMethod(getDemoteMasterMethod())
                      .addMethod(getDemoteMethod())
                      .addMethod(getExportMethod())
                      .addMethod(getFailoverMethod())
                      .addMethod(getReencryptMethod())
                      .addMethod(getGetMethod())
                      .addMethod(getImportMethod())
                      .addMethod(getInsertMethod())
                      .addMethod(getListMethod())
                      .addMethod(getListServerCasMethod())
                      .addMethod(getListServerCertificatesMethod())
                      .addMethod(getListEntraIdCertificatesMethod())
                      .addMethod(getPatchMethod())
                      .addMethod(getPromoteReplicaMethod())
                      .addMethod(getSwitchoverMethod())
                      .addMethod(getResetSslConfigMethod())
                      .addMethod(getRestartMethod())
                      .addMethod(getRestoreBackupMethod())
                      .addMethod(getRotateServerCaMethod())
                      .addMethod(getRotateServerCertificateMethod())
                      .addMethod(getRotateEntraIdCertificateMethod())
                      .addMethod(getStartReplicaMethod())
                      .addMethod(getStopReplicaMethod())
                      .addMethod(getTruncateLogMethod())
                      .addMethod(getUpdateMethod())
                      .addMethod(getCreateEphemeralMethod())
                      .addMethod(getRescheduleMaintenanceMethod())
                      .addMethod(getVerifyExternalSyncSettingsMethod())
                      .addMethod(getStartExternalSyncMethod())
                      .addMethod(getPerformDiskShrinkMethod())
                      .addMethod(getGetDiskShrinkConfigMethod())
                      .addMethod(getResetReplicaSizeMethod())
                      .addMethod(getGetLatestRecoveryTimeMethod())
                      .addMethod(getExecuteSqlMethod())
                      .addMethod(getAcquireSsrsLeaseMethod())
                      .addMethod(getReleaseSsrsLeaseMethod())
                      .addMethod(getPreCheckMajorVersionUpgradeMethod())
                      .addMethod(getPointInTimeRestoreMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
