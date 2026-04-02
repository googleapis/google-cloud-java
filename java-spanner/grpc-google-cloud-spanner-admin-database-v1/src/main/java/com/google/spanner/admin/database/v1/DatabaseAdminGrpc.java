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
package com.google.spanner.admin.database.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Spanner Database Admin API
 * The Cloud Spanner Database Admin API can be used to:
 *   * create, drop, and list databases
 *   * update the schema of pre-existing databases
 *   * create, delete, copy and list backups for a database
 *   * restore a database from an existing backup
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DatabaseAdminGrpc {

  private DatabaseAdminGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.spanner.admin.database.v1.DatabaseAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabasesRequest,
          com.google.spanner.admin.database.v1.ListDatabasesResponse>
      getListDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabases",
      requestType = com.google.spanner.admin.database.v1.ListDatabasesRequest.class,
      responseType = com.google.spanner.admin.database.v1.ListDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabasesRequest,
          com.google.spanner.admin.database.v1.ListDatabasesResponse>
      getListDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.ListDatabasesRequest,
            com.google.spanner.admin.database.v1.ListDatabasesResponse>
        getListDatabasesMethod;
    if ((getListDatabasesMethod = DatabaseAdminGrpc.getListDatabasesMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getListDatabasesMethod = DatabaseAdminGrpc.getListDatabasesMethod) == null) {
          DatabaseAdminGrpc.getListDatabasesMethod =
              getListDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.ListDatabasesRequest,
                          com.google.spanner.admin.database.v1.ListDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("ListDatabases"))
                      .build();
        }
      }
    }
    return getListDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateDatabaseRequest,
          com.google.longrunning.Operation>
      getCreateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDatabase",
      requestType = com.google.spanner.admin.database.v1.CreateDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateDatabaseRequest,
          com.google.longrunning.Operation>
      getCreateDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.CreateDatabaseRequest,
            com.google.longrunning.Operation>
        getCreateDatabaseMethod;
    if ((getCreateDatabaseMethod = DatabaseAdminGrpc.getCreateDatabaseMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getCreateDatabaseMethod = DatabaseAdminGrpc.getCreateDatabaseMethod) == null) {
          DatabaseAdminGrpc.getCreateDatabaseMethod =
              getCreateDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.CreateDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.CreateDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("CreateDatabase"))
                      .build();
        }
      }
    }
    return getCreateDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseRequest,
          com.google.spanner.admin.database.v1.Database>
      getGetDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatabase",
      requestType = com.google.spanner.admin.database.v1.GetDatabaseRequest.class,
      responseType = com.google.spanner.admin.database.v1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseRequest,
          com.google.spanner.admin.database.v1.Database>
      getGetDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.GetDatabaseRequest,
            com.google.spanner.admin.database.v1.Database>
        getGetDatabaseMethod;
    if ((getGetDatabaseMethod = DatabaseAdminGrpc.getGetDatabaseMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getGetDatabaseMethod = DatabaseAdminGrpc.getGetDatabaseMethod) == null) {
          DatabaseAdminGrpc.getGetDatabaseMethod =
              getGetDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.GetDatabaseRequest,
                          com.google.spanner.admin.database.v1.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.GetDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.Database.getDefaultInstance()))
                      .setSchemaDescriptor(new DatabaseAdminMethodDescriptorSupplier("GetDatabase"))
                      .build();
        }
      }
    }
    return getGetDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateDatabaseRequest,
          com.google.longrunning.Operation>
      getUpdateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDatabase",
      requestType = com.google.spanner.admin.database.v1.UpdateDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateDatabaseRequest,
          com.google.longrunning.Operation>
      getUpdateDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.UpdateDatabaseRequest,
            com.google.longrunning.Operation>
        getUpdateDatabaseMethod;
    if ((getUpdateDatabaseMethod = DatabaseAdminGrpc.getUpdateDatabaseMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getUpdateDatabaseMethod = DatabaseAdminGrpc.getUpdateDatabaseMethod) == null) {
          DatabaseAdminGrpc.getUpdateDatabaseMethod =
              getUpdateDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.UpdateDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.UpdateDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("UpdateDatabase"))
                      .build();
        }
      }
    }
    return getUpdateDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
          com.google.longrunning.Operation>
      getUpdateDatabaseDdlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDatabaseDdl",
      requestType = com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
          com.google.longrunning.Operation>
      getUpdateDatabaseDdlMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
            com.google.longrunning.Operation>
        getUpdateDatabaseDdlMethod;
    if ((getUpdateDatabaseDdlMethod = DatabaseAdminGrpc.getUpdateDatabaseDdlMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getUpdateDatabaseDdlMethod = DatabaseAdminGrpc.getUpdateDatabaseDdlMethod) == null) {
          DatabaseAdminGrpc.getUpdateDatabaseDdlMethod =
              getUpdateDatabaseDdlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDatabaseDdl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("UpdateDatabaseDdl"))
                      .build();
        }
      }
    }
    return getUpdateDatabaseDdlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DropDatabaseRequest, com.google.protobuf.Empty>
      getDropDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DropDatabase",
      requestType = com.google.spanner.admin.database.v1.DropDatabaseRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DropDatabaseRequest, com.google.protobuf.Empty>
      getDropDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.DropDatabaseRequest, com.google.protobuf.Empty>
        getDropDatabaseMethod;
    if ((getDropDatabaseMethod = DatabaseAdminGrpc.getDropDatabaseMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getDropDatabaseMethod = DatabaseAdminGrpc.getDropDatabaseMethod) == null) {
          DatabaseAdminGrpc.getDropDatabaseMethod =
              getDropDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.DropDatabaseRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DropDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.DropDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("DropDatabase"))
                      .build();
        }
      }
    }
    return getDropDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
          com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
      getGetDatabaseDdlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatabaseDdl",
      requestType = com.google.spanner.admin.database.v1.GetDatabaseDdlRequest.class,
      responseType = com.google.spanner.admin.database.v1.GetDatabaseDdlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
          com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
      getGetDatabaseDdlMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
            com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
        getGetDatabaseDdlMethod;
    if ((getGetDatabaseDdlMethod = DatabaseAdminGrpc.getGetDatabaseDdlMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getGetDatabaseDdlMethod = DatabaseAdminGrpc.getGetDatabaseDdlMethod) == null) {
          DatabaseAdminGrpc.getGetDatabaseDdlMethod =
              getGetDatabaseDdlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
                          com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDatabaseDdl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.GetDatabaseDdlRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.GetDatabaseDdlResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("GetDatabaseDdl"))
                      .build();
        }
      }
    }
    return getGetDatabaseDdlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = DatabaseAdminGrpc.getSetIamPolicyMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getSetIamPolicyMethod = DatabaseAdminGrpc.getSetIamPolicyMethod) == null) {
          DatabaseAdminGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = DatabaseAdminGrpc.getGetIamPolicyMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getGetIamPolicyMethod = DatabaseAdminGrpc.getGetIamPolicyMethod) == null) {
          DatabaseAdminGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = DatabaseAdminGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getTestIamPermissionsMethod = DatabaseAdminGrpc.getTestIamPermissionsMethod) == null) {
          DatabaseAdminGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateBackupRequest,
          com.google.longrunning.Operation>
      getCreateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackup",
      requestType = com.google.spanner.admin.database.v1.CreateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateBackupRequest,
          com.google.longrunning.Operation>
      getCreateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.CreateBackupRequest,
            com.google.longrunning.Operation>
        getCreateBackupMethod;
    if ((getCreateBackupMethod = DatabaseAdminGrpc.getCreateBackupMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getCreateBackupMethod = DatabaseAdminGrpc.getCreateBackupMethod) == null) {
          DatabaseAdminGrpc.getCreateBackupMethod =
              getCreateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.CreateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.CreateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("CreateBackup"))
                      .build();
        }
      }
    }
    return getCreateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CopyBackupRequest, com.google.longrunning.Operation>
      getCopyBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CopyBackup",
      requestType = com.google.spanner.admin.database.v1.CopyBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CopyBackupRequest, com.google.longrunning.Operation>
      getCopyBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.CopyBackupRequest,
            com.google.longrunning.Operation>
        getCopyBackupMethod;
    if ((getCopyBackupMethod = DatabaseAdminGrpc.getCopyBackupMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getCopyBackupMethod = DatabaseAdminGrpc.getCopyBackupMethod) == null) {
          DatabaseAdminGrpc.getCopyBackupMethod =
              getCopyBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.CopyBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CopyBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.CopyBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DatabaseAdminMethodDescriptorSupplier("CopyBackup"))
                      .build();
        }
      }
    }
    return getCopyBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.spanner.admin.database.v1.GetBackupRequest.class,
      responseType = com.google.spanner.admin.database.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.GetBackupRequest,
            com.google.spanner.admin.database.v1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = DatabaseAdminGrpc.getGetBackupMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getGetBackupMethod = DatabaseAdminGrpc.getGetBackupMethod) == null) {
          DatabaseAdminGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.GetBackupRequest,
                          com.google.spanner.admin.database.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.GetBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new DatabaseAdminMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.spanner.admin.database.v1.UpdateBackupRequest.class,
      responseType = com.google.spanner.admin.database.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.UpdateBackupRequest,
            com.google.spanner.admin.database.v1.Backup>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = DatabaseAdminGrpc.getUpdateBackupMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getUpdateBackupMethod = DatabaseAdminGrpc.getUpdateBackupMethod) == null) {
          DatabaseAdminGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.UpdateBackupRequest,
                          com.google.spanner.admin.database.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.UpdateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("UpdateBackup"))
                      .build();
        }
      }
    }
    return getUpdateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DeleteBackupRequest, com.google.protobuf.Empty>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.spanner.admin.database.v1.DeleteBackupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DeleteBackupRequest, com.google.protobuf.Empty>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.DeleteBackupRequest, com.google.protobuf.Empty>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = DatabaseAdminGrpc.getDeleteBackupMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getDeleteBackupMethod = DatabaseAdminGrpc.getDeleteBackupMethod) == null) {
          DatabaseAdminGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.DeleteBackupRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupsRequest,
          com.google.spanner.admin.database.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.spanner.admin.database.v1.ListBackupsRequest.class,
      responseType = com.google.spanner.admin.database.v1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupsRequest,
          com.google.spanner.admin.database.v1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.ListBackupsRequest,
            com.google.spanner.admin.database.v1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = DatabaseAdminGrpc.getListBackupsMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getListBackupsMethod = DatabaseAdminGrpc.getListBackupsMethod) == null) {
          DatabaseAdminGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.ListBackupsRequest,
                          com.google.spanner.admin.database.v1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DatabaseAdminMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
          com.google.longrunning.Operation>
      getRestoreDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreDatabase",
      requestType = com.google.spanner.admin.database.v1.RestoreDatabaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
          com.google.longrunning.Operation>
      getRestoreDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
            com.google.longrunning.Operation>
        getRestoreDatabaseMethod;
    if ((getRestoreDatabaseMethod = DatabaseAdminGrpc.getRestoreDatabaseMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getRestoreDatabaseMethod = DatabaseAdminGrpc.getRestoreDatabaseMethod) == null) {
          DatabaseAdminGrpc.getRestoreDatabaseMethod =
              getRestoreDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.RestoreDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("RestoreDatabase"))
                      .build();
        }
      }
    }
    return getRestoreDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
          com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
      getListDatabaseOperationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabaseOperations",
      requestType = com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest.class,
      responseType = com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
          com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
      getListDatabaseOperationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
            com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
        getListDatabaseOperationsMethod;
    if ((getListDatabaseOperationsMethod = DatabaseAdminGrpc.getListDatabaseOperationsMethod)
        == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getListDatabaseOperationsMethod = DatabaseAdminGrpc.getListDatabaseOperationsMethod)
            == null) {
          DatabaseAdminGrpc.getListDatabaseOperationsMethod =
              getListDatabaseOperationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
                          com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDatabaseOperations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("ListDatabaseOperations"))
                      .build();
        }
      }
    }
    return getListDatabaseOperationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
          com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
      getListBackupOperationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupOperations",
      requestType = com.google.spanner.admin.database.v1.ListBackupOperationsRequest.class,
      responseType = com.google.spanner.admin.database.v1.ListBackupOperationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
          com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
      getListBackupOperationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
            com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
        getListBackupOperationsMethod;
    if ((getListBackupOperationsMethod = DatabaseAdminGrpc.getListBackupOperationsMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getListBackupOperationsMethod = DatabaseAdminGrpc.getListBackupOperationsMethod)
            == null) {
          DatabaseAdminGrpc.getListBackupOperationsMethod =
              getListBackupOperationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
                          com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupOperations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListBackupOperationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListBackupOperationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("ListBackupOperations"))
                      .build();
        }
      }
    }
    return getListBackupOperationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabaseRolesRequest,
          com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>
      getListDatabaseRolesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabaseRoles",
      requestType = com.google.spanner.admin.database.v1.ListDatabaseRolesRequest.class,
      responseType = com.google.spanner.admin.database.v1.ListDatabaseRolesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabaseRolesRequest,
          com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>
      getListDatabaseRolesMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.ListDatabaseRolesRequest,
            com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>
        getListDatabaseRolesMethod;
    if ((getListDatabaseRolesMethod = DatabaseAdminGrpc.getListDatabaseRolesMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getListDatabaseRolesMethod = DatabaseAdminGrpc.getListDatabaseRolesMethod) == null) {
          DatabaseAdminGrpc.getListDatabaseRolesMethod =
              getListDatabaseRolesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.ListDatabaseRolesRequest,
                          com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatabaseRoles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListDatabaseRolesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListDatabaseRolesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("ListDatabaseRoles"))
                      .build();
        }
      }
    }
    return getListDatabaseRolesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.AddSplitPointsRequest,
          com.google.spanner.admin.database.v1.AddSplitPointsResponse>
      getAddSplitPointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddSplitPoints",
      requestType = com.google.spanner.admin.database.v1.AddSplitPointsRequest.class,
      responseType = com.google.spanner.admin.database.v1.AddSplitPointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.AddSplitPointsRequest,
          com.google.spanner.admin.database.v1.AddSplitPointsResponse>
      getAddSplitPointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.AddSplitPointsRequest,
            com.google.spanner.admin.database.v1.AddSplitPointsResponse>
        getAddSplitPointsMethod;
    if ((getAddSplitPointsMethod = DatabaseAdminGrpc.getAddSplitPointsMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getAddSplitPointsMethod = DatabaseAdminGrpc.getAddSplitPointsMethod) == null) {
          DatabaseAdminGrpc.getAddSplitPointsMethod =
              getAddSplitPointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.AddSplitPointsRequest,
                          com.google.spanner.admin.database.v1.AddSplitPointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddSplitPoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.AddSplitPointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.AddSplitPointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("AddSplitPoints"))
                      .build();
        }
      }
    }
    return getAddSplitPointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateBackupScheduleRequest,
          com.google.spanner.admin.database.v1.BackupSchedule>
      getCreateBackupScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupSchedule",
      requestType = com.google.spanner.admin.database.v1.CreateBackupScheduleRequest.class,
      responseType = com.google.spanner.admin.database.v1.BackupSchedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateBackupScheduleRequest,
          com.google.spanner.admin.database.v1.BackupSchedule>
      getCreateBackupScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.CreateBackupScheduleRequest,
            com.google.spanner.admin.database.v1.BackupSchedule>
        getCreateBackupScheduleMethod;
    if ((getCreateBackupScheduleMethod = DatabaseAdminGrpc.getCreateBackupScheduleMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getCreateBackupScheduleMethod = DatabaseAdminGrpc.getCreateBackupScheduleMethod)
            == null) {
          DatabaseAdminGrpc.getCreateBackupScheduleMethod =
              getCreateBackupScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.CreateBackupScheduleRequest,
                          com.google.spanner.admin.database.v1.BackupSchedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateBackupSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.CreateBackupScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.BackupSchedule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("CreateBackupSchedule"))
                      .build();
        }
      }
    }
    return getCreateBackupScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetBackupScheduleRequest,
          com.google.spanner.admin.database.v1.BackupSchedule>
      getGetBackupScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupSchedule",
      requestType = com.google.spanner.admin.database.v1.GetBackupScheduleRequest.class,
      responseType = com.google.spanner.admin.database.v1.BackupSchedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetBackupScheduleRequest,
          com.google.spanner.admin.database.v1.BackupSchedule>
      getGetBackupScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.GetBackupScheduleRequest,
            com.google.spanner.admin.database.v1.BackupSchedule>
        getGetBackupScheduleMethod;
    if ((getGetBackupScheduleMethod = DatabaseAdminGrpc.getGetBackupScheduleMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getGetBackupScheduleMethod = DatabaseAdminGrpc.getGetBackupScheduleMethod) == null) {
          DatabaseAdminGrpc.getGetBackupScheduleMethod =
              getGetBackupScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.GetBackupScheduleRequest,
                          com.google.spanner.admin.database.v1.BackupSchedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.GetBackupScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.BackupSchedule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("GetBackupSchedule"))
                      .build();
        }
      }
    }
    return getGetBackupScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest,
          com.google.spanner.admin.database.v1.BackupSchedule>
      getUpdateBackupScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupSchedule",
      requestType = com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest.class,
      responseType = com.google.spanner.admin.database.v1.BackupSchedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest,
          com.google.spanner.admin.database.v1.BackupSchedule>
      getUpdateBackupScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest,
            com.google.spanner.admin.database.v1.BackupSchedule>
        getUpdateBackupScheduleMethod;
    if ((getUpdateBackupScheduleMethod = DatabaseAdminGrpc.getUpdateBackupScheduleMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getUpdateBackupScheduleMethod = DatabaseAdminGrpc.getUpdateBackupScheduleMethod)
            == null) {
          DatabaseAdminGrpc.getUpdateBackupScheduleMethod =
              getUpdateBackupScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest,
                          com.google.spanner.admin.database.v1.BackupSchedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateBackupSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.BackupSchedule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("UpdateBackupSchedule"))
                      .build();
        }
      }
    }
    return getUpdateBackupScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest,
          com.google.protobuf.Empty>
      getDeleteBackupScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupSchedule",
      requestType = com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest,
          com.google.protobuf.Empty>
      getDeleteBackupScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest,
            com.google.protobuf.Empty>
        getDeleteBackupScheduleMethod;
    if ((getDeleteBackupScheduleMethod = DatabaseAdminGrpc.getDeleteBackupScheduleMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getDeleteBackupScheduleMethod = DatabaseAdminGrpc.getDeleteBackupScheduleMethod)
            == null) {
          DatabaseAdminGrpc.getDeleteBackupScheduleMethod =
              getDeleteBackupScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteBackupSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("DeleteBackupSchedule"))
                      .build();
        }
      }
    }
    return getDeleteBackupScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupSchedulesRequest,
          com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>
      getListBackupSchedulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupSchedules",
      requestType = com.google.spanner.admin.database.v1.ListBackupSchedulesRequest.class,
      responseType = com.google.spanner.admin.database.v1.ListBackupSchedulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupSchedulesRequest,
          com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>
      getListBackupSchedulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.ListBackupSchedulesRequest,
            com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>
        getListBackupSchedulesMethod;
    if ((getListBackupSchedulesMethod = DatabaseAdminGrpc.getListBackupSchedulesMethod) == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getListBackupSchedulesMethod = DatabaseAdminGrpc.getListBackupSchedulesMethod)
            == null) {
          DatabaseAdminGrpc.getListBackupSchedulesMethod =
              getListBackupSchedulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.ListBackupSchedulesRequest,
                          com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupSchedules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListBackupSchedulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1.ListBackupSchedulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("ListBackupSchedules"))
                      .build();
        }
      }
    }
    return getListBackupSchedulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest,
          com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>
      getInternalUpdateGraphOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InternalUpdateGraphOperation",
      requestType = com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest.class,
      responseType =
          com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest,
          com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>
      getInternalUpdateGraphOperationMethod() {
    io.grpc.MethodDescriptor<
            com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest,
            com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>
        getInternalUpdateGraphOperationMethod;
    if ((getInternalUpdateGraphOperationMethod =
            DatabaseAdminGrpc.getInternalUpdateGraphOperationMethod)
        == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getInternalUpdateGraphOperationMethod =
                DatabaseAdminGrpc.getInternalUpdateGraphOperationMethod)
            == null) {
          DatabaseAdminGrpc.getInternalUpdateGraphOperationMethod =
              getInternalUpdateGraphOperationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest,
                          com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "InternalUpdateGraphOperation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1
                                  .InternalUpdateGraphOperationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.spanner.admin.database.v1
                                  .InternalUpdateGraphOperationResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier("InternalUpdateGraphOperation"))
                      .build();
        }
      }
    }
    return getInternalUpdateGraphOperationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DatabaseAdminStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseAdminStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatabaseAdminStub>() {
          @java.lang.Override
          public DatabaseAdminStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatabaseAdminStub(channel, callOptions);
          }
        };
    return DatabaseAdminStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DatabaseAdminBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseAdminBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatabaseAdminBlockingV2Stub>() {
          @java.lang.Override
          public DatabaseAdminBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatabaseAdminBlockingV2Stub(channel, callOptions);
          }
        };
    return DatabaseAdminBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatabaseAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseAdminBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatabaseAdminBlockingStub>() {
          @java.lang.Override
          public DatabaseAdminBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatabaseAdminBlockingStub(channel, callOptions);
          }
        };
    return DatabaseAdminBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DatabaseAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatabaseAdminFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DatabaseAdminFutureStub>() {
          @java.lang.Override
          public DatabaseAdminFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DatabaseAdminFutureStub(channel, callOptions);
          }
        };
    return DatabaseAdminFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to:
   *   * create, drop, and list databases
   *   * update the schema of pre-existing databases
   *   * create, delete, copy and list backups for a database
   *   * restore a database from an existing backup
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner databases.
     * </pre>
     */
    default void listDatabases(
        com.google.spanner.admin.database.v1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud Spanner database and starts to prepare it for serving.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track preparation of the database. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    default void createDatabase(
        com.google.spanner.admin.database.v1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the state of a Cloud Spanner database.
     * </pre>
     */
    default void getDatabase(
        com.google.spanner.admin.database.v1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Database>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Cloud Spanner database. The returned
     * [long-running operation][google.longrunning.Operation] can be used to track
     * the progress of updating the database. If the named database does not
     * exist, returns `NOT_FOUND`.
     * While the operation is pending:
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field is set to true.
     *   * Cancelling the operation is best-effort. If the cancellation succeeds,
     *     the operation metadata's
     *     [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time]
     *     is set, the updates are reverted, and the operation terminates with a
     *     `CANCELLED` status.
     *   * New UpdateDatabase requests will return a `FAILED_PRECONDITION` error
     *     until the pending operation is done (returns successfully or with
     *     error).
     *   * Reading the database via the API continues to give the pre-request
     *     values.
     * Upon completion of the returned operation:
     *   * The new values are in effect and readable via the API.
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field becomes false.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track the database modification. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    default void updateDatabase(
        com.google.spanner.admin.database.v1.UpdateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the schema of a Cloud Spanner database by
     * creating/altering/dropping tables, columns, indexes, etc. The returned
     * [long-running operation][google.longrunning.Operation] will have a name of
     * the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
     * track execution of the schema change(s). The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].
     * The operation has no response.
     * </pre>
     */
    default void updateDatabaseDdl(
        com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatabaseDdlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * Completed backups for the database will be retained according to their
     * `expire_time`.
     * Note: Cloud Spanner might continue to accept requests for a few seconds
     * after the database has been deleted.
     * </pre>
     */
    default void dropDatabase(
        com.google.spanner.admin.database.v1.DropDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDropDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the schema of a Cloud Spanner database as a list of formatted
     * DDL statements. This method does not show pending schema updates, those may
     * be queried using the [Operations][google.longrunning.Operations] API.
     * </pre>
     */
    default void getDatabaseDdl(
        com.google.spanner.admin.database.v1.GetDatabaseDdlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDatabaseDdlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database or backup resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database or backup resource.
     * Returns an empty policy if a database or backup exists but does not have a
     * policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.getIamPolicy`
     * permission on [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database or backup
     * resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * Calling this method on a backup that does not exist will
     * result in a NOT_FOUND error if the user has
     * `spanner.backups.list` permission on the containing instance.
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts creating a new Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track creation of the backup. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the creation and delete the
     * backup. There can be only one pending backup creation per database. Backup
     * creation of different databases can run concurrently.
     * </pre>
     */
    default void createBackup(
        com.google.spanner.admin.database.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts copying a Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track copying of the backup. The operation is associated
     * with the destination backup.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the copying and delete the
     * destination backup. Concurrent CopyBackup requests can run on the same
     * source backup.
     * </pre>
     */
    default void copyBackup(
        com.google.spanner.admin.database.v1.CopyBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCopyBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata on a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    default void getBackup(
        com.google.spanner.admin.database.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    default void updateBackup(
        com.google.spanner.admin.database.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    default void deleteBackup(
        com.google.spanner.admin.database.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists completed and pending backups.
     * Backups returned are ordered by `create_time` in descending order,
     * starting from the most recent `create_time`.
     * </pre>
     */
    default void listBackups(
        com.google.spanner.admin.database.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new database by restoring from a completed backup. The new
     * database must be in the same project and in an instance with the same
     * instance configuration as the instance containing
     * the backup. The returned database [long-running
     * operation][google.longrunning.Operation] has a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
     * and can be used to track the progress of the operation, and to cancel it.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type
     * is [Database][google.spanner.admin.database.v1.Database], if
     * successful. Cancelling the returned operation will stop the restore and
     * delete the database.
     * There can be only one database being restored into an instance at a time.
     * Once the restore operation completes, a new restore operation can be
     * initiated, without waiting for the optimize operation associated with the
     * first restore to complete.
     * </pre>
     */
    default void restoreDatabase(
        com.google.spanner.admin.database.v1.RestoreDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists database [longrunning-operations][google.longrunning.Operation].
     * A database operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations.
     * </pre>
     */
    default void listDatabaseOperations(
        com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabaseOperationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the backup [long-running operations][google.longrunning.Operation] in
     * the given instance. A backup operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations. Operations returned are ordered by
     * `operation.metadata.value.progress.start_time` in descending order starting
     * from the most recently started operation.
     * </pre>
     */
    default void listBackupOperations(
        com.google.spanner.admin.database.v1.ListBackupOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupOperationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner database roles.
     * </pre>
     */
    default void listDatabaseRoles(
        com.google.spanner.admin.database.v1.ListDatabaseRolesRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabaseRolesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds split points to specified tables, indexes of a database.
     * </pre>
     */
    default void addSplitPoints(
        com.google.spanner.admin.database.v1.AddSplitPointsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.AddSplitPointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddSplitPointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup schedule.
     * </pre>
     */
    default void createBackupSchedule(
        com.google.spanner.admin.database.v1.CreateBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets backup schedule for the input schedule name.
     * </pre>
     */
    default void getBackupSchedule(
        com.google.spanner.admin.database.v1.GetBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    default void updateBackupSchedule(
        com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    default void deleteBackupSchedule(
        com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backup schedules for the database.
     * </pre>
     */
    default void listBackupSchedules(
        com.google.spanner.admin.database.v1.ListBackupSchedulesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupSchedulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is an internal API called by Spanner Graph jobs. You should never need
     * to call this API directly.
     * </pre>
     */
    default void internalUpdateGraphOperation(
        com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInternalUpdateGraphOperationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DatabaseAdmin.
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to:
   *   * create, drop, and list databases
   *   * update the schema of pre-existing databases
   *   * create, delete, copy and list backups for a database
   *   * restore a database from an existing backup
   * </pre>
   */
  public abstract static class DatabaseAdminImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DatabaseAdminGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DatabaseAdmin.
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to:
   *   * create, drop, and list databases
   *   * update the schema of pre-existing databases
   *   * create, delete, copy and list backups for a database
   *   * restore a database from an existing backup
   * </pre>
   */
  public static final class DatabaseAdminStub
      extends io.grpc.stub.AbstractAsyncStub<DatabaseAdminStub> {
    private DatabaseAdminStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseAdminStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseAdminStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner databases.
     * </pre>
     */
    public void listDatabases(
        com.google.spanner.admin.database.v1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud Spanner database and starts to prepare it for serving.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track preparation of the database. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public void createDatabase(
        com.google.spanner.admin.database.v1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the state of a Cloud Spanner database.
     * </pre>
     */
    public void getDatabase(
        com.google.spanner.admin.database.v1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Database>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Cloud Spanner database. The returned
     * [long-running operation][google.longrunning.Operation] can be used to track
     * the progress of updating the database. If the named database does not
     * exist, returns `NOT_FOUND`.
     * While the operation is pending:
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field is set to true.
     *   * Cancelling the operation is best-effort. If the cancellation succeeds,
     *     the operation metadata's
     *     [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time]
     *     is set, the updates are reverted, and the operation terminates with a
     *     `CANCELLED` status.
     *   * New UpdateDatabase requests will return a `FAILED_PRECONDITION` error
     *     until the pending operation is done (returns successfully or with
     *     error).
     *   * Reading the database via the API continues to give the pre-request
     *     values.
     * Upon completion of the returned operation:
     *   * The new values are in effect and readable via the API.
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field becomes false.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track the database modification. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public void updateDatabase(
        com.google.spanner.admin.database.v1.UpdateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the schema of a Cloud Spanner database by
     * creating/altering/dropping tables, columns, indexes, etc. The returned
     * [long-running operation][google.longrunning.Operation] will have a name of
     * the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
     * track execution of the schema change(s). The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].
     * The operation has no response.
     * </pre>
     */
    public void updateDatabaseDdl(
        com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatabaseDdlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * Completed backups for the database will be retained according to their
     * `expire_time`.
     * Note: Cloud Spanner might continue to accept requests for a few seconds
     * after the database has been deleted.
     * </pre>
     */
    public void dropDatabase(
        com.google.spanner.admin.database.v1.DropDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDropDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the schema of a Cloud Spanner database as a list of formatted
     * DDL statements. This method does not show pending schema updates, those may
     * be queried using the [Operations][google.longrunning.Operations] API.
     * </pre>
     */
    public void getDatabaseDdl(
        com.google.spanner.admin.database.v1.GetDatabaseDdlRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatabaseDdlMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database or backup resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database or backup resource.
     * Returns an empty policy if a database or backup exists but does not have a
     * policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.getIamPolicy`
     * permission on [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database or backup
     * resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * Calling this method on a backup that does not exist will
     * result in a NOT_FOUND error if the user has
     * `spanner.backups.list` permission on the containing instance.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts creating a new Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track creation of the backup. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the creation and delete the
     * backup. There can be only one pending backup creation per database. Backup
     * creation of different databases can run concurrently.
     * </pre>
     */
    public void createBackup(
        com.google.spanner.admin.database.v1.CreateBackupRequest request,
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
     * Starts copying a Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track copying of the backup. The operation is associated
     * with the destination backup.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the copying and delete the
     * destination backup. Concurrent CopyBackup requests can run on the same
     * source backup.
     * </pre>
     */
    public void copyBackup(
        com.google.spanner.admin.database.v1.CopyBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCopyBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata on a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public void getBackup(
        com.google.spanner.admin.database.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public void updateBackup(
        com.google.spanner.admin.database.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public void deleteBackup(
        com.google.spanner.admin.database.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists completed and pending backups.
     * Backups returned are ordered by `create_time` in descending order,
     * starting from the most recent `create_time`.
     * </pre>
     */
    public void listBackups(
        com.google.spanner.admin.database.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.ListBackupsResponse>
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
     * Create a new database by restoring from a completed backup. The new
     * database must be in the same project and in an instance with the same
     * instance configuration as the instance containing
     * the backup. The returned database [long-running
     * operation][google.longrunning.Operation] has a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
     * and can be used to track the progress of the operation, and to cancel it.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type
     * is [Database][google.spanner.admin.database.v1.Database], if
     * successful. Cancelling the returned operation will stop the restore and
     * delete the database.
     * There can be only one database being restored into an instance at a time.
     * Once the restore operation completes, a new restore operation can be
     * initiated, without waiting for the optimize operation associated with the
     * first restore to complete.
     * </pre>
     */
    public void restoreDatabase(
        com.google.spanner.admin.database.v1.RestoreDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists database [longrunning-operations][google.longrunning.Operation].
     * A database operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations.
     * </pre>
     */
    public void listDatabaseOperations(
        com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabaseOperationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the backup [long-running operations][google.longrunning.Operation] in
     * the given instance. A backup operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations. Operations returned are ordered by
     * `operation.metadata.value.progress.start_time` in descending order starting
     * from the most recently started operation.
     * </pre>
     */
    public void listBackupOperations(
        com.google.spanner.admin.database.v1.ListBackupOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupOperationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner database roles.
     * </pre>
     */
    public void listDatabaseRoles(
        com.google.spanner.admin.database.v1.ListDatabaseRolesRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabaseRolesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds split points to specified tables, indexes of a database.
     * </pre>
     */
    public void addSplitPoints(
        com.google.spanner.admin.database.v1.AddSplitPointsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.AddSplitPointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddSplitPointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup schedule.
     * </pre>
     */
    public void createBackupSchedule(
        com.google.spanner.admin.database.v1.CreateBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets backup schedule for the input schedule name.
     * </pre>
     */
    public void getBackupSchedule(
        com.google.spanner.admin.database.v1.GetBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    public void updateBackupSchedule(
        com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    public void deleteBackupSchedule(
        com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backup schedules for the database.
     * </pre>
     */
    public void listBackupSchedules(
        com.google.spanner.admin.database.v1.ListBackupSchedulesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupSchedulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This is an internal API called by Spanner Graph jobs. You should never need
     * to call this API directly.
     * </pre>
     */
    public void internalUpdateGraphOperation(
        com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInternalUpdateGraphOperationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DatabaseAdmin.
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to:
   *   * create, drop, and list databases
   *   * update the schema of pre-existing databases
   *   * create, delete, copy and list backups for a database
   *   * restore a database from an existing backup
   * </pre>
   */
  public static final class DatabaseAdminBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DatabaseAdminBlockingV2Stub> {
    private DatabaseAdminBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseAdminBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseAdminBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner databases.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListDatabasesResponse listDatabases(
        com.google.spanner.admin.database.v1.ListDatabasesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud Spanner database and starts to prepare it for serving.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track preparation of the database. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public com.google.longrunning.Operation createDatabase(
        com.google.spanner.admin.database.v1.CreateDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the state of a Cloud Spanner database.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.Database getDatabase(
        com.google.spanner.admin.database.v1.GetDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Cloud Spanner database. The returned
     * [long-running operation][google.longrunning.Operation] can be used to track
     * the progress of updating the database. If the named database does not
     * exist, returns `NOT_FOUND`.
     * While the operation is pending:
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field is set to true.
     *   * Cancelling the operation is best-effort. If the cancellation succeeds,
     *     the operation metadata's
     *     [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time]
     *     is set, the updates are reverted, and the operation terminates with a
     *     `CANCELLED` status.
     *   * New UpdateDatabase requests will return a `FAILED_PRECONDITION` error
     *     until the pending operation is done (returns successfully or with
     *     error).
     *   * Reading the database via the API continues to give the pre-request
     *     values.
     * Upon completion of the returned operation:
     *   * The new values are in effect and readable via the API.
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field becomes false.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track the database modification. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatabase(
        com.google.spanner.admin.database.v1.UpdateDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the schema of a Cloud Spanner database by
     * creating/altering/dropping tables, columns, indexes, etc. The returned
     * [long-running operation][google.longrunning.Operation] will have a name of
     * the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
     * track execution of the schema change(s). The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].
     * The operation has no response.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatabaseDdl(
        com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDatabaseDdlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * Completed backups for the database will be retained according to their
     * `expire_time`.
     * Note: Cloud Spanner might continue to accept requests for a few seconds
     * after the database has been deleted.
     * </pre>
     */
    public com.google.protobuf.Empty dropDatabase(
        com.google.spanner.admin.database.v1.DropDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDropDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the schema of a Cloud Spanner database as a list of formatted
     * DDL statements. This method does not show pending schema updates, those may
     * be queried using the [Operations][google.longrunning.Operations] API.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.GetDatabaseDdlResponse getDatabaseDdl(
        com.google.spanner.admin.database.v1.GetDatabaseDdlRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDatabaseDdlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database or backup resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database or backup resource.
     * Returns an empty policy if a database or backup exists but does not have a
     * policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.getIamPolicy`
     * permission on [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database or backup
     * resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * Calling this method on a backup that does not exist will
     * result in a NOT_FOUND error if the user has
     * `spanner.backups.list` permission on the containing instance.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts creating a new Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track creation of the backup. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the creation and delete the
     * backup. There can be only one pending backup creation per database. Backup
     * creation of different databases can run concurrently.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.spanner.admin.database.v1.CreateBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts copying a Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track copying of the backup. The operation is associated
     * with the destination backup.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the copying and delete the
     * destination backup. Concurrent CopyBackup requests can run on the same
     * source backup.
     * </pre>
     */
    public com.google.longrunning.Operation copyBackup(
        com.google.spanner.admin.database.v1.CopyBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCopyBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata on a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.spanner.admin.database.v1.Backup getBackup(
        com.google.spanner.admin.database.v1.GetBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.spanner.admin.database.v1.Backup updateBackup(
        com.google.spanner.admin.database.v1.UpdateBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.protobuf.Empty deleteBackup(
        com.google.spanner.admin.database.v1.DeleteBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists completed and pending backups.
     * Backups returned are ordered by `create_time` in descending order,
     * starting from the most recent `create_time`.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListBackupsResponse listBackups(
        com.google.spanner.admin.database.v1.ListBackupsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new database by restoring from a completed backup. The new
     * database must be in the same project and in an instance with the same
     * instance configuration as the instance containing
     * the backup. The returned database [long-running
     * operation][google.longrunning.Operation] has a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
     * and can be used to track the progress of the operation, and to cancel it.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type
     * is [Database][google.spanner.admin.database.v1.Database], if
     * successful. Cancelling the returned operation will stop the restore and
     * delete the database.
     * There can be only one database being restored into an instance at a time.
     * Once the restore operation completes, a new restore operation can be
     * initiated, without waiting for the optimize operation associated with the
     * first restore to complete.
     * </pre>
     */
    public com.google.longrunning.Operation restoreDatabase(
        com.google.spanner.admin.database.v1.RestoreDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestoreDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists database [longrunning-operations][google.longrunning.Operation].
     * A database operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse
        listDatabaseOperations(
            com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDatabaseOperationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the backup [long-running operations][google.longrunning.Operation] in
     * the given instance. A backup operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations. Operations returned are ordered by
     * `operation.metadata.value.progress.start_time` in descending order starting
     * from the most recently started operation.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListBackupOperationsResponse listBackupOperations(
        com.google.spanner.admin.database.v1.ListBackupOperationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupOperationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner database roles.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListDatabaseRolesResponse listDatabaseRoles(
        com.google.spanner.admin.database.v1.ListDatabaseRolesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDatabaseRolesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds split points to specified tables, indexes of a database.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.AddSplitPointsResponse addSplitPoints(
        com.google.spanner.admin.database.v1.AddSplitPointsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddSplitPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup schedule.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.BackupSchedule createBackupSchedule(
        com.google.spanner.admin.database.v1.CreateBackupScheduleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets backup schedule for the input schedule name.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.BackupSchedule getBackupSchedule(
        com.google.spanner.admin.database.v1.GetBackupScheduleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.BackupSchedule updateBackupSchedule(
        com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBackupSchedule(
        com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backup schedules for the database.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListBackupSchedulesResponse listBackupSchedules(
        com.google.spanner.admin.database.v1.ListBackupSchedulesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupSchedulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This is an internal API called by Spanner Graph jobs. You should never need
     * to call this API directly.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse
        internalUpdateGraphOperation(
            com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getInternalUpdateGraphOperationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DatabaseAdmin.
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to:
   *   * create, drop, and list databases
   *   * update the schema of pre-existing databases
   *   * create, delete, copy and list backups for a database
   *   * restore a database from an existing backup
   * </pre>
   */
  public static final class DatabaseAdminBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DatabaseAdminBlockingStub> {
    private DatabaseAdminBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseAdminBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseAdminBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner databases.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListDatabasesResponse listDatabases(
        com.google.spanner.admin.database.v1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud Spanner database and starts to prepare it for serving.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track preparation of the database. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public com.google.longrunning.Operation createDatabase(
        com.google.spanner.admin.database.v1.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the state of a Cloud Spanner database.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.Database getDatabase(
        com.google.spanner.admin.database.v1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Cloud Spanner database. The returned
     * [long-running operation][google.longrunning.Operation] can be used to track
     * the progress of updating the database. If the named database does not
     * exist, returns `NOT_FOUND`.
     * While the operation is pending:
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field is set to true.
     *   * Cancelling the operation is best-effort. If the cancellation succeeds,
     *     the operation metadata's
     *     [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time]
     *     is set, the updates are reverted, and the operation terminates with a
     *     `CANCELLED` status.
     *   * New UpdateDatabase requests will return a `FAILED_PRECONDITION` error
     *     until the pending operation is done (returns successfully or with
     *     error).
     *   * Reading the database via the API continues to give the pre-request
     *     values.
     * Upon completion of the returned operation:
     *   * The new values are in effect and readable via the API.
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field becomes false.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track the database modification. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatabase(
        com.google.spanner.admin.database.v1.UpdateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the schema of a Cloud Spanner database by
     * creating/altering/dropping tables, columns, indexes, etc. The returned
     * [long-running operation][google.longrunning.Operation] will have a name of
     * the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
     * track execution of the schema change(s). The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].
     * The operation has no response.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatabaseDdl(
        com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatabaseDdlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * Completed backups for the database will be retained according to their
     * `expire_time`.
     * Note: Cloud Spanner might continue to accept requests for a few seconds
     * after the database has been deleted.
     * </pre>
     */
    public com.google.protobuf.Empty dropDatabase(
        com.google.spanner.admin.database.v1.DropDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDropDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the schema of a Cloud Spanner database as a list of formatted
     * DDL statements. This method does not show pending schema updates, those may
     * be queried using the [Operations][google.longrunning.Operations] API.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.GetDatabaseDdlResponse getDatabaseDdl(
        com.google.spanner.admin.database.v1.GetDatabaseDdlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatabaseDdlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database or backup resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database or backup resource.
     * Returns an empty policy if a database or backup exists but does not have a
     * policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.getIamPolicy`
     * permission on [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database or backup
     * resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * Calling this method on a backup that does not exist will
     * result in a NOT_FOUND error if the user has
     * `spanner.backups.list` permission on the containing instance.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts creating a new Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track creation of the backup. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the creation and delete the
     * backup. There can be only one pending backup creation per database. Backup
     * creation of different databases can run concurrently.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.spanner.admin.database.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts copying a Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track copying of the backup. The operation is associated
     * with the destination backup.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the copying and delete the
     * destination backup. Concurrent CopyBackup requests can run on the same
     * source backup.
     * </pre>
     */
    public com.google.longrunning.Operation copyBackup(
        com.google.spanner.admin.database.v1.CopyBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCopyBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata on a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.spanner.admin.database.v1.Backup getBackup(
        com.google.spanner.admin.database.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.spanner.admin.database.v1.Backup updateBackup(
        com.google.spanner.admin.database.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.protobuf.Empty deleteBackup(
        com.google.spanner.admin.database.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists completed and pending backups.
     * Backups returned are ordered by `create_time` in descending order,
     * starting from the most recent `create_time`.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListBackupsResponse listBackups(
        com.google.spanner.admin.database.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new database by restoring from a completed backup. The new
     * database must be in the same project and in an instance with the same
     * instance configuration as the instance containing
     * the backup. The returned database [long-running
     * operation][google.longrunning.Operation] has a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
     * and can be used to track the progress of the operation, and to cancel it.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type
     * is [Database][google.spanner.admin.database.v1.Database], if
     * successful. Cancelling the returned operation will stop the restore and
     * delete the database.
     * There can be only one database being restored into an instance at a time.
     * Once the restore operation completes, a new restore operation can be
     * initiated, without waiting for the optimize operation associated with the
     * first restore to complete.
     * </pre>
     */
    public com.google.longrunning.Operation restoreDatabase(
        com.google.spanner.admin.database.v1.RestoreDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists database [longrunning-operations][google.longrunning.Operation].
     * A database operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse
        listDatabaseOperations(
            com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabaseOperationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the backup [long-running operations][google.longrunning.Operation] in
     * the given instance. A backup operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations. Operations returned are ordered by
     * `operation.metadata.value.progress.start_time` in descending order starting
     * from the most recently started operation.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListBackupOperationsResponse listBackupOperations(
        com.google.spanner.admin.database.v1.ListBackupOperationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupOperationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner database roles.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListDatabaseRolesResponse listDatabaseRoles(
        com.google.spanner.admin.database.v1.ListDatabaseRolesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabaseRolesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds split points to specified tables, indexes of a database.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.AddSplitPointsResponse addSplitPoints(
        com.google.spanner.admin.database.v1.AddSplitPointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddSplitPointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup schedule.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.BackupSchedule createBackupSchedule(
        com.google.spanner.admin.database.v1.CreateBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets backup schedule for the input schedule name.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.BackupSchedule getBackupSchedule(
        com.google.spanner.admin.database.v1.GetBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.BackupSchedule updateBackupSchedule(
        com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBackupSchedule(
        com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backup schedules for the database.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.ListBackupSchedulesResponse listBackupSchedules(
        com.google.spanner.admin.database.v1.ListBackupSchedulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupSchedulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This is an internal API called by Spanner Graph jobs. You should never need
     * to call this API directly.
     * </pre>
     */
    public com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse
        internalUpdateGraphOperation(
            com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInternalUpdateGraphOperationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DatabaseAdmin.
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to:
   *   * create, drop, and list databases
   *   * update the schema of pre-existing databases
   *   * create, delete, copy and list backups for a database
   *   * restore a database from an existing backup
   * </pre>
   */
  public static final class DatabaseAdminFutureStub
      extends io.grpc.stub.AbstractFutureStub<DatabaseAdminFutureStub> {
    private DatabaseAdminFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseAdminFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatabaseAdminFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner databases.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListDatabasesResponse>
        listDatabases(com.google.spanner.admin.database.v1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cloud Spanner database and starts to prepare it for serving.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track preparation of the database. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDatabase(com.google.spanner.admin.database.v1.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the state of a Cloud Spanner database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.Database>
        getDatabase(com.google.spanner.admin.database.v1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Cloud Spanner database. The returned
     * [long-running operation][google.longrunning.Operation] can be used to track
     * the progress of updating the database. If the named database does not
     * exist, returns `NOT_FOUND`.
     * While the operation is pending:
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field is set to true.
     *   * Cancelling the operation is best-effort. If the cancellation succeeds,
     *     the operation metadata's
     *     [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time]
     *     is set, the updates are reverted, and the operation terminates with a
     *     `CANCELLED` status.
     *   * New UpdateDatabase requests will return a `FAILED_PRECONDITION` error
     *     until the pending operation is done (returns successfully or with
     *     error).
     *   * Reading the database via the API continues to give the pre-request
     *     values.
     * Upon completion of the returned operation:
     *   * The new values are in effect and readable via the API.
     *   * The database's
     *     [reconciling][google.spanner.admin.database.v1.Database.reconciling]
     *     field becomes false.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track the database modification. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDatabase(com.google.spanner.admin.database.v1.UpdateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the schema of a Cloud Spanner database by
     * creating/altering/dropping tables, columns, indexes, etc. The returned
     * [long-running operation][google.longrunning.Operation] will have a name of
     * the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
     * track execution of the schema change(s). The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].
     * The operation has no response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDatabaseDdl(com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatabaseDdlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * Completed backups for the database will be retained according to their
     * `expire_time`.
     * Note: Cloud Spanner might continue to accept requests for a few seconds
     * after the database has been deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        dropDatabase(com.google.spanner.admin.database.v1.DropDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDropDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the schema of a Cloud Spanner database as a list of formatted
     * DDL statements. This method does not show pending schema updates, those may
     * be queried using the [Operations][google.longrunning.Operations] API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
        getDatabaseDdl(com.google.spanner.admin.database.v1.GetDatabaseDdlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatabaseDdlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database or backup resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database or backup resource.
     * Returns an empty policy if a database or backup exists but does not have a
     * policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * For backups, authorization requires `spanner.backups.getIamPolicy`
     * permission on [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database or backup
     * resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * Calling this method on a backup that does not exist will
     * result in a NOT_FOUND error if the user has
     * `spanner.backups.list` permission on the containing instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts creating a new Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track creation of the backup. The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the creation and delete the
     * backup. There can be only one pending backup creation per database. Backup
     * creation of different databases can run concurrently.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackup(com.google.spanner.admin.database.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts copying a Cloud Spanner Backup.
     * The returned backup [long-running operation][google.longrunning.Operation]
     * will have a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
     * and can be used to track copying of the backup. The operation is associated
     * with the destination backup.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Backup][google.spanner.admin.database.v1.Backup], if successful.
     * Cancelling the returned operation will stop the copying and delete the
     * destination backup. Concurrent CopyBackup requests can run on the same
     * source backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        copyBackup(com.google.spanner.admin.database.v1.CopyBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCopyBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata on a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.Backup>
        getBackup(com.google.spanner.admin.database.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.Backup>
        updateBackup(com.google.spanner.admin.database.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pending or completed
     * [Backup][google.spanner.admin.database.v1.Backup].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBackup(com.google.spanner.admin.database.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists completed and pending backups.
     * Backups returned are ordered by `create_time` in descending order,
     * starting from the most recent `create_time`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListBackupsResponse>
        listBackups(com.google.spanner.admin.database.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new database by restoring from a completed backup. The new
     * database must be in the same project and in an instance with the same
     * instance configuration as the instance containing
     * the backup. The returned database [long-running
     * operation][google.longrunning.Operation] has a name of the format
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
     * and can be used to track the progress of the operation, and to cancel it.
     * The [metadata][google.longrunning.Operation.metadata] field type is
     * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata].
     * The [response][google.longrunning.Operation.response] type
     * is [Database][google.spanner.admin.database.v1.Database], if
     * successful. Cancelling the returned operation will stop the restore and
     * delete the database.
     * There can be only one database being restored into an instance at a time.
     * Once the restore operation completes, a new restore operation can be
     * initiated, without waiting for the optimize operation associated with the
     * first restore to complete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreDatabase(com.google.spanner.admin.database.v1.RestoreDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists database [longrunning-operations][google.longrunning.Operation].
     * A database operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
        listDatabaseOperations(
            com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabaseOperationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the backup [long-running operations][google.longrunning.Operation] in
     * the given instance. A backup operation has a name of the form
     * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
     * The long-running operation
     * [metadata][google.longrunning.Operation.metadata] field type
     * `metadata.type_url` describes the type of the metadata. Operations returned
     * include those that have completed/failed/canceled within the last 7 days,
     * and pending operations. Operations returned are ordered by
     * `operation.metadata.value.progress.start_time` in descending order starting
     * from the most recently started operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
        listBackupOperations(
            com.google.spanner.admin.database.v1.ListBackupOperationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupOperationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Cloud Spanner database roles.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>
        listDatabaseRoles(com.google.spanner.admin.database.v1.ListDatabaseRolesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabaseRolesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds split points to specified tables, indexes of a database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.AddSplitPointsResponse>
        addSplitPoints(com.google.spanner.admin.database.v1.AddSplitPointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddSplitPointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.BackupSchedule>
        createBackupSchedule(
            com.google.spanner.admin.database.v1.CreateBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets backup schedule for the input schedule name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.BackupSchedule>
        getBackupSchedule(com.google.spanner.admin.database.v1.GetBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a backup schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.BackupSchedule>
        updateBackupSchedule(
            com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a backup schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBackupSchedule(
            com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the backup schedules for the database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>
        listBackupSchedules(
            com.google.spanner.admin.database.v1.ListBackupSchedulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupSchedulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This is an internal API called by Spanner Graph jobs. You should never need
     * to call this API directly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>
        internalUpdateGraphOperation(
            com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInternalUpdateGraphOperationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DATABASES = 0;
  private static final int METHODID_CREATE_DATABASE = 1;
  private static final int METHODID_GET_DATABASE = 2;
  private static final int METHODID_UPDATE_DATABASE = 3;
  private static final int METHODID_UPDATE_DATABASE_DDL = 4;
  private static final int METHODID_DROP_DATABASE = 5;
  private static final int METHODID_GET_DATABASE_DDL = 6;
  private static final int METHODID_SET_IAM_POLICY = 7;
  private static final int METHODID_GET_IAM_POLICY = 8;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 9;
  private static final int METHODID_CREATE_BACKUP = 10;
  private static final int METHODID_COPY_BACKUP = 11;
  private static final int METHODID_GET_BACKUP = 12;
  private static final int METHODID_UPDATE_BACKUP = 13;
  private static final int METHODID_DELETE_BACKUP = 14;
  private static final int METHODID_LIST_BACKUPS = 15;
  private static final int METHODID_RESTORE_DATABASE = 16;
  private static final int METHODID_LIST_DATABASE_OPERATIONS = 17;
  private static final int METHODID_LIST_BACKUP_OPERATIONS = 18;
  private static final int METHODID_LIST_DATABASE_ROLES = 19;
  private static final int METHODID_ADD_SPLIT_POINTS = 20;
  private static final int METHODID_CREATE_BACKUP_SCHEDULE = 21;
  private static final int METHODID_GET_BACKUP_SCHEDULE = 22;
  private static final int METHODID_UPDATE_BACKUP_SCHEDULE = 23;
  private static final int METHODID_DELETE_BACKUP_SCHEDULE = 24;
  private static final int METHODID_LIST_BACKUP_SCHEDULES = 25;
  private static final int METHODID_INTERNAL_UPDATE_GRAPH_OPERATION = 26;

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
        case METHODID_LIST_DATABASES:
          serviceImpl.listDatabases(
              (com.google.spanner.admin.database.v1.ListDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.ListDatabasesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATABASE:
          serviceImpl.createDatabase(
              (com.google.spanner.admin.database.v1.CreateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATABASE:
          serviceImpl.getDatabase(
              (com.google.spanner.admin.database.v1.GetDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Database>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATABASE:
          serviceImpl.updateDatabase(
              (com.google.spanner.admin.database.v1.UpdateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATABASE_DDL:
          serviceImpl.updateDatabaseDdl(
              (com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DROP_DATABASE:
          serviceImpl.dropDatabase(
              (com.google.spanner.admin.database.v1.DropDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_DATABASE_DDL:
          serviceImpl.getDatabaseDdl(
              (com.google.spanner.admin.database.v1.GetDatabaseDdlRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>)
                  responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.spanner.admin.database.v1.CreateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_COPY_BACKUP:
          serviceImpl.copyBackup(
              (com.google.spanner.admin.database.v1.CopyBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.spanner.admin.database.v1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.spanner.admin.database.v1.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.spanner.admin.database.v1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.spanner.admin.database.v1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_RESTORE_DATABASE:
          serviceImpl.restoreDatabase(
              (com.google.spanner.admin.database.v1.RestoreDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATABASE_OPERATIONS:
          serviceImpl.listDatabaseOperations(
              (com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_OPERATIONS:
          serviceImpl.listBackupOperations(
              (com.google.spanner.admin.database.v1.ListBackupOperationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.ListBackupOperationsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_DATABASE_ROLES:
          serviceImpl.listDatabaseRoles(
              (com.google.spanner.admin.database.v1.ListDatabaseRolesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>)
                  responseObserver);
          break;
        case METHODID_ADD_SPLIT_POINTS:
          serviceImpl.addSplitPoints(
              (com.google.spanner.admin.database.v1.AddSplitPointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.AddSplitPointsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP_SCHEDULE:
          serviceImpl.createBackupSchedule(
              (com.google.spanner.admin.database.v1.CreateBackupScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP_SCHEDULE:
          serviceImpl.getBackupSchedule(
              (com.google.spanner.admin.database.v1.GetBackupScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_SCHEDULE:
          serviceImpl.updateBackupSchedule(
              (com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.BackupSchedule>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP_SCHEDULE:
          serviceImpl.deleteBackupSchedule(
              (com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_BACKUP_SCHEDULES:
          serviceImpl.listBackupSchedules(
              (com.google.spanner.admin.database.v1.ListBackupSchedulesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>)
                  responseObserver);
          break;
        case METHODID_INTERNAL_UPDATE_GRAPH_OPERATION:
          serviceImpl.internalUpdateGraphOperation(
              (com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>)
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
            getListDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.ListDatabasesRequest,
                    com.google.spanner.admin.database.v1.ListDatabasesResponse>(
                    service, METHODID_LIST_DATABASES)))
        .addMethod(
            getCreateDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.CreateDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATABASE)))
        .addMethod(
            getGetDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.GetDatabaseRequest,
                    com.google.spanner.admin.database.v1.Database>(service, METHODID_GET_DATABASE)))
        .addMethod(
            getUpdateDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.UpdateDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATABASE)))
        .addMethod(
            getUpdateDatabaseDdlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATABASE_DDL)))
        .addMethod(
            getDropDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.DropDatabaseRequest,
                    com.google.protobuf.Empty>(service, METHODID_DROP_DATABASE)))
        .addMethod(
            getGetDatabaseDdlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
                    com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>(
                    service, METHODID_GET_DATABASE_DDL)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .addMethod(
            getCreateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.CreateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP)))
        .addMethod(
            getCopyBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.CopyBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_COPY_BACKUP)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.GetBackupRequest,
                    com.google.spanner.admin.database.v1.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getUpdateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.UpdateBackupRequest,
                    com.google.spanner.admin.database.v1.Backup>(service, METHODID_UPDATE_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.DeleteBackupRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.ListBackupsRequest,
                    com.google.spanner.admin.database.v1.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getRestoreDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_DATABASE)))
        .addMethod(
            getListDatabaseOperationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
                    com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>(
                    service, METHODID_LIST_DATABASE_OPERATIONS)))
        .addMethod(
            getListBackupOperationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
                    com.google.spanner.admin.database.v1.ListBackupOperationsResponse>(
                    service, METHODID_LIST_BACKUP_OPERATIONS)))
        .addMethod(
            getListDatabaseRolesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.ListDatabaseRolesRequest,
                    com.google.spanner.admin.database.v1.ListDatabaseRolesResponse>(
                    service, METHODID_LIST_DATABASE_ROLES)))
        .addMethod(
            getAddSplitPointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.AddSplitPointsRequest,
                    com.google.spanner.admin.database.v1.AddSplitPointsResponse>(
                    service, METHODID_ADD_SPLIT_POINTS)))
        .addMethod(
            getCreateBackupScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.CreateBackupScheduleRequest,
                    com.google.spanner.admin.database.v1.BackupSchedule>(
                    service, METHODID_CREATE_BACKUP_SCHEDULE)))
        .addMethod(
            getGetBackupScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.GetBackupScheduleRequest,
                    com.google.spanner.admin.database.v1.BackupSchedule>(
                    service, METHODID_GET_BACKUP_SCHEDULE)))
        .addMethod(
            getUpdateBackupScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest,
                    com.google.spanner.admin.database.v1.BackupSchedule>(
                    service, METHODID_UPDATE_BACKUP_SCHEDULE)))
        .addMethod(
            getDeleteBackupScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_BACKUP_SCHEDULE)))
        .addMethod(
            getListBackupSchedulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.ListBackupSchedulesRequest,
                    com.google.spanner.admin.database.v1.ListBackupSchedulesResponse>(
                    service, METHODID_LIST_BACKUP_SCHEDULES)))
        .addMethod(
            getInternalUpdateGraphOperationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest,
                    com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse>(
                    service, METHODID_INTERNAL_UPDATE_GRAPH_OPERATION)))
        .build();
  }

  private abstract static class DatabaseAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatabaseAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.spanner.admin.database.v1.SpannerDatabaseAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DatabaseAdmin");
    }
  }

  private static final class DatabaseAdminFileDescriptorSupplier
      extends DatabaseAdminBaseDescriptorSupplier {
    DatabaseAdminFileDescriptorSupplier() {}
  }

  private static final class DatabaseAdminMethodDescriptorSupplier
      extends DatabaseAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DatabaseAdminMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DatabaseAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DatabaseAdminFileDescriptorSupplier())
                      .addMethod(getListDatabasesMethod())
                      .addMethod(getCreateDatabaseMethod())
                      .addMethod(getGetDatabaseMethod())
                      .addMethod(getUpdateDatabaseMethod())
                      .addMethod(getUpdateDatabaseDdlMethod())
                      .addMethod(getDropDatabaseMethod())
                      .addMethod(getGetDatabaseDdlMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getCreateBackupMethod())
                      .addMethod(getCopyBackupMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getUpdateBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getRestoreDatabaseMethod())
                      .addMethod(getListDatabaseOperationsMethod())
                      .addMethod(getListBackupOperationsMethod())
                      .addMethod(getListDatabaseRolesMethod())
                      .addMethod(getAddSplitPointsMethod())
                      .addMethod(getCreateBackupScheduleMethod())
                      .addMethod(getGetBackupScheduleMethod())
                      .addMethod(getUpdateBackupScheduleMethod())
                      .addMethod(getDeleteBackupScheduleMethod())
                      .addMethod(getListBackupSchedulesMethod())
                      .addMethod(getInternalUpdateGraphOperationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
