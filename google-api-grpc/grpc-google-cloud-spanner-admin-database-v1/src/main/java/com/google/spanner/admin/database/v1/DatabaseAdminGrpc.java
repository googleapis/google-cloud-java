package com.google.spanner.admin.database.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Cloud Spanner Database Admin API
 * The Cloud Spanner Database Admin API can be used to create, drop, and
 * list databases. It also enables updating the schema of pre-existing
 * databases.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/spanner/admin/database/v1/spanner_database_admin.proto")
public final class DatabaseAdminGrpc {

  private DatabaseAdminGrpc() {}

  public static final String SERVICE_NAME = "google.spanner.admin.database.v1.DatabaseAdmin";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDatabasesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabasesRequest,
          com.google.spanner.admin.database.v1.ListDatabasesResponse>
      METHOD_LIST_DATABASES = getListDatabasesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabasesRequest,
          com.google.spanner.admin.database.v1.ListDatabasesResponse>
      getListDatabasesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabasesRequest,
          com.google.spanner.admin.database.v1.ListDatabasesResponse>
      getListDatabasesMethod() {
    return getListDatabasesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabasesRequest,
          com.google.spanner.admin.database.v1.ListDatabasesResponse>
      getListDatabasesMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "ListDatabases"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateDatabaseMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateDatabaseRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_DATABASE = getCreateDatabaseMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateDatabaseRequest,
          com.google.longrunning.Operation>
      getCreateDatabaseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateDatabaseRequest,
          com.google.longrunning.Operation>
      getCreateDatabaseMethod() {
    return getCreateDatabaseMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateDatabaseRequest,
          com.google.longrunning.Operation>
      getCreateDatabaseMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "CreateDatabase"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDatabaseMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseRequest,
          com.google.spanner.admin.database.v1.Database>
      METHOD_GET_DATABASE = getGetDatabaseMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseRequest,
          com.google.spanner.admin.database.v1.Database>
      getGetDatabaseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseRequest,
          com.google.spanner.admin.database.v1.Database>
      getGetDatabaseMethod() {
    return getGetDatabaseMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseRequest,
          com.google.spanner.admin.database.v1.Database>
      getGetDatabaseMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "GetDatabase"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateDatabaseDdlMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
          com.google.longrunning.Operation>
      METHOD_UPDATE_DATABASE_DDL = getUpdateDatabaseDdlMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
          com.google.longrunning.Operation>
      getUpdateDatabaseDdlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
          com.google.longrunning.Operation>
      getUpdateDatabaseDdlMethod() {
    return getUpdateDatabaseDdlMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
          com.google.longrunning.Operation>
      getUpdateDatabaseDdlMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin",
                              "UpdateDatabaseDdl"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDropDatabaseMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DropDatabaseRequest, com.google.protobuf.Empty>
      METHOD_DROP_DATABASE = getDropDatabaseMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DropDatabaseRequest, com.google.protobuf.Empty>
      getDropDatabaseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DropDatabaseRequest, com.google.protobuf.Empty>
      getDropDatabaseMethod() {
    return getDropDatabaseMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DropDatabaseRequest, com.google.protobuf.Empty>
      getDropDatabaseMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "DropDatabase"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDatabaseDdlMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
          com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
      METHOD_GET_DATABASE_DDL = getGetDatabaseDdlMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
          com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
      getGetDatabaseDdlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
          com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
      getGetDatabaseDdlMethod() {
    return getGetDatabaseDdlMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
          com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>
      getGetDatabaseDdlMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "GetDatabaseDdl"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_SET_IAM_POLICY = getSetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    return getSetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "SetIamPolicy"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyOnBackupInternalOnlyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_SET_IAM_POLICY_ON_BACKUP_INTERNAL_ONLY =
          getSetIamPolicyOnBackupInternalOnlyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyOnBackupInternalOnlyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyOnBackupInternalOnlyMethod() {
    return getSetIamPolicyOnBackupInternalOnlyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyOnBackupInternalOnlyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyOnBackupInternalOnlyMethod;
    if ((getSetIamPolicyOnBackupInternalOnlyMethod =
            DatabaseAdminGrpc.getSetIamPolicyOnBackupInternalOnlyMethod)
        == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getSetIamPolicyOnBackupInternalOnlyMethod =
                DatabaseAdminGrpc.getSetIamPolicyOnBackupInternalOnlyMethod)
            == null) {
          DatabaseAdminGrpc.getSetIamPolicyOnBackupInternalOnlyMethod =
              getSetIamPolicyOnBackupInternalOnlyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin",
                              "SetIamPolicyOnBackupInternalOnly"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier(
                              "SetIamPolicyOnBackupInternalOnly"))
                      .build();
        }
      }
    }
    return getSetIamPolicyOnBackupInternalOnlyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_GET_IAM_POLICY = getGetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    return getGetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "GetIamPolicy"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyOnBackupInternalOnlyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_GET_IAM_POLICY_ON_BACKUP_INTERNAL_ONLY =
          getGetIamPolicyOnBackupInternalOnlyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyOnBackupInternalOnlyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyOnBackupInternalOnlyMethod() {
    return getGetIamPolicyOnBackupInternalOnlyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyOnBackupInternalOnlyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyOnBackupInternalOnlyMethod;
    if ((getGetIamPolicyOnBackupInternalOnlyMethod =
            DatabaseAdminGrpc.getGetIamPolicyOnBackupInternalOnlyMethod)
        == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getGetIamPolicyOnBackupInternalOnlyMethod =
                DatabaseAdminGrpc.getGetIamPolicyOnBackupInternalOnlyMethod)
            == null) {
          DatabaseAdminGrpc.getGetIamPolicyOnBackupInternalOnlyMethod =
              getGetIamPolicyOnBackupInternalOnlyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin",
                              "GetIamPolicyOnBackupInternalOnly"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier(
                              "GetIamPolicyOnBackupInternalOnly"))
                      .build();
        }
      }
    }
    return getGetIamPolicyOnBackupInternalOnlyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      METHOD_TEST_IAM_PERMISSIONS = getTestIamPermissionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    return getTestIamPermissionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin",
                              "TestIamPermissions"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsOnBackupInternalOnlyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      METHOD_TEST_IAM_PERMISSIONS_ON_BACKUP_INTERNAL_ONLY =
          getTestIamPermissionsOnBackupInternalOnlyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsOnBackupInternalOnlyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsOnBackupInternalOnlyMethod() {
    return getTestIamPermissionsOnBackupInternalOnlyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsOnBackupInternalOnlyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsOnBackupInternalOnlyMethod;
    if ((getTestIamPermissionsOnBackupInternalOnlyMethod =
            DatabaseAdminGrpc.getTestIamPermissionsOnBackupInternalOnlyMethod)
        == null) {
      synchronized (DatabaseAdminGrpc.class) {
        if ((getTestIamPermissionsOnBackupInternalOnlyMethod =
                DatabaseAdminGrpc.getTestIamPermissionsOnBackupInternalOnlyMethod)
            == null) {
          DatabaseAdminGrpc.getTestIamPermissionsOnBackupInternalOnlyMethod =
              getTestIamPermissionsOnBackupInternalOnlyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin",
                              "TestIamPermissionsOnBackupInternalOnly"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DatabaseAdminMethodDescriptorSupplier(
                              "TestIamPermissionsOnBackupInternalOnly"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsOnBackupInternalOnlyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateBackupMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateBackupRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_BACKUP = getCreateBackupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateBackupRequest,
          com.google.longrunning.Operation>
      getCreateBackupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateBackupRequest,
          com.google.longrunning.Operation>
      getCreateBackupMethod() {
    return getCreateBackupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.CreateBackupRequest,
          com.google.longrunning.Operation>
      getCreateBackupMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "CreateBackup"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBackupMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      METHOD_GET_BACKUP = getGetBackupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getGetBackupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getGetBackupMethod() {
    return getGetBackupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.GetBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getGetBackupMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "GetBackup"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateBackupMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      METHOD_UPDATE_BACKUP = getUpdateBackupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getUpdateBackupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getUpdateBackupMethod() {
    return getUpdateBackupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.UpdateBackupRequest,
          com.google.spanner.admin.database.v1.Backup>
      getUpdateBackupMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "UpdateBackup"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteBackupMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DeleteBackupRequest, com.google.protobuf.Empty>
      METHOD_DELETE_BACKUP = getDeleteBackupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DeleteBackupRequest, com.google.protobuf.Empty>
      getDeleteBackupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DeleteBackupRequest, com.google.protobuf.Empty>
      getDeleteBackupMethod() {
    return getDeleteBackupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.DeleteBackupRequest, com.google.protobuf.Empty>
      getDeleteBackupMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "DeleteBackup"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListBackupsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupsRequest,
          com.google.spanner.admin.database.v1.ListBackupsResponse>
      METHOD_LIST_BACKUPS = getListBackupsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupsRequest,
          com.google.spanner.admin.database.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupsRequest,
          com.google.spanner.admin.database.v1.ListBackupsResponse>
      getListBackupsMethod() {
    return getListBackupsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupsRequest,
          com.google.spanner.admin.database.v1.ListBackupsResponse>
      getListBackupsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "ListBackups"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRestoreDatabaseMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
          com.google.longrunning.Operation>
      METHOD_RESTORE_DATABASE = getRestoreDatabaseMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
          com.google.longrunning.Operation>
      getRestoreDatabaseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
          com.google.longrunning.Operation>
      getRestoreDatabaseMethod() {
    return getRestoreDatabaseMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
          com.google.longrunning.Operation>
      getRestoreDatabaseMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin", "RestoreDatabase"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListDatabaseOperationsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
          com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
      METHOD_LIST_DATABASE_OPERATIONS = getListDatabaseOperationsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
          com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
      getListDatabaseOperationsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
          com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
      getListDatabaseOperationsMethod() {
    return getListDatabaseOperationsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
          com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
      getListDatabaseOperationsMethodHelper() {
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
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin",
                              "ListDatabaseOperations"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListBackupOperationsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
          com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
      METHOD_LIST_BACKUP_OPERATIONS = getListBackupOperationsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
          com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
      getListBackupOperationsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
          com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
      getListBackupOperationsMethod() {
    return getListBackupOperationsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
          com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
      getListBackupOperationsMethodHelper() {
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
                          generateFullMethodName(
                              "google.spanner.admin.database.v1.DatabaseAdmin",
                              "ListBackupOperations"))
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

  /** Creates a new async stub that supports all call types for the service */
  public static DatabaseAdminStub newStub(io.grpc.Channel channel) {
    return new DatabaseAdminStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatabaseAdminBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new DatabaseAdminBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DatabaseAdminFutureStub newFutureStub(io.grpc.Channel channel) {
    return new DatabaseAdminFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to create, drop, and
   * list databases. It also enables updating the schema of pre-existing
   * databases.
   * </pre>
   */
  public abstract static class DatabaseAdminImplBase implements io.grpc.BindableService {

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
      asyncUnimplementedUnaryCall(getListDatabasesMethodHelper(), responseObserver);
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
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
     * [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public void createDatabase(
        com.google.spanner.admin.database.v1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateDatabaseMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetDatabaseMethodHelper(), responseObserver);
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
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].  The operation has no response.
     * </pre>
     */
    public void updateDatabaseDdl(
        com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateDatabaseDdlMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * </pre>
     */
    public void dropDatabase(
        com.google.spanner.admin.database.v1.DropDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDropDatabaseMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetDatabaseDdlMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIamPolicyMethodHelper(), responseObserver);
    }

    /** */
    public void setIamPolicyOnBackupInternalOnly(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(
          getSetIamPolicyOnBackupInternalOnlyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database resource.
     * Returns an empty policy if a database exists but does
     * not have a policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIamPolicyMethodHelper(), responseObserver);
    }

    /** */
    public void getIamPolicyOnBackupInternalOnly(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(
          getGetIamPolicyOnBackupInternalOnlyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethodHelper(), responseObserver);
    }

    /** */
    public void testIamPermissionsOnBackupInternalOnly(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(
          getTestIamPermissionsOnBackupInternalOnlyMethodHelper(), responseObserver);
    }

    /** */
    public void createBackup(
        com.google.spanner.admin.database.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateBackupMethodHelper(), responseObserver);
    }

    /** */
    public void getBackup(
        com.google.spanner.admin.database.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBackupMethodHelper(), responseObserver);
    }

    /** */
    public void updateBackup(
        com.google.spanner.admin.database.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateBackupMethodHelper(), responseObserver);
    }

    /** */
    public void deleteBackup(
        com.google.spanner.admin.database.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteBackupMethodHelper(), responseObserver);
    }

    /** */
    public void listBackups(
        com.google.spanner.admin.database.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.ListBackupsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListBackupsMethodHelper(), responseObserver);
    }

    /** */
    public void restoreDatabase(
        com.google.spanner.admin.database.v1.RestoreDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getRestoreDatabaseMethodHelper(), responseObserver);
    }

    /** */
    public void listDatabaseOperations(
        com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListDatabaseOperationsMethodHelper(), responseObserver);
    }

    /** */
    public void listBackupOperations(
        com.google.spanner.admin.database.v1.ListBackupOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListBackupOperationsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListDatabasesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.ListDatabasesRequest,
                      com.google.spanner.admin.database.v1.ListDatabasesResponse>(
                      this, METHODID_LIST_DATABASES)))
          .addMethod(
              getCreateDatabaseMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.CreateDatabaseRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_DATABASE)))
          .addMethod(
              getGetDatabaseMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.GetDatabaseRequest,
                      com.google.spanner.admin.database.v1.Database>(this, METHODID_GET_DATABASE)))
          .addMethod(
              getUpdateDatabaseDdlMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_DATABASE_DDL)))
          .addMethod(
              getDropDatabaseMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.DropDatabaseRequest,
                      com.google.protobuf.Empty>(this, METHODID_DROP_DATABASE)))
          .addMethod(
              getGetDatabaseDdlMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.GetDatabaseDdlRequest,
                      com.google.spanner.admin.database.v1.GetDatabaseDdlResponse>(
                      this, METHODID_GET_DATABASE_DDL)))
          .addMethod(
              getSetIamPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getSetIamPolicyOnBackupInternalOnlyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY_ON_BACKUP_INTERNAL_ONLY)))
          .addMethod(
              getGetIamPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getGetIamPolicyOnBackupInternalOnlyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY_ON_BACKUP_INTERNAL_ONLY)))
          .addMethod(
              getTestIamPermissionsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
              getTestIamPermissionsOnBackupInternalOnlyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS_ON_BACKUP_INTERNAL_ONLY)))
          .addMethod(
              getCreateBackupMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.CreateBackupRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_BACKUP)))
          .addMethod(
              getGetBackupMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.GetBackupRequest,
                      com.google.spanner.admin.database.v1.Backup>(this, METHODID_GET_BACKUP)))
          .addMethod(
              getUpdateBackupMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.UpdateBackupRequest,
                      com.google.spanner.admin.database.v1.Backup>(this, METHODID_UPDATE_BACKUP)))
          .addMethod(
              getDeleteBackupMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.DeleteBackupRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_BACKUP)))
          .addMethod(
              getListBackupsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.ListBackupsRequest,
                      com.google.spanner.admin.database.v1.ListBackupsResponse>(
                      this, METHODID_LIST_BACKUPS)))
          .addMethod(
              getRestoreDatabaseMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.RestoreDatabaseRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESTORE_DATABASE)))
          .addMethod(
              getListDatabaseOperationsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest,
                      com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>(
                      this, METHODID_LIST_DATABASE_OPERATIONS)))
          .addMethod(
              getListBackupOperationsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.spanner.admin.database.v1.ListBackupOperationsRequest,
                      com.google.spanner.admin.database.v1.ListBackupOperationsResponse>(
                      this, METHODID_LIST_BACKUP_OPERATIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to create, drop, and
   * list databases. It also enables updating the schema of pre-existing
   * databases.
   * </pre>
   */
  public static final class DatabaseAdminStub extends io.grpc.stub.AbstractStub<DatabaseAdminStub> {
    private DatabaseAdminStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      asyncUnaryCall(
          getChannel().newCall(getListDatabasesMethodHelper(), getCallOptions()),
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
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
     * [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public void createDatabase(
        com.google.spanner.admin.database.v1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateDatabaseMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetDatabaseMethodHelper(), getCallOptions()),
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
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].  The operation has no response.
     * </pre>
     */
    public void updateDatabaseDdl(
        com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateDatabaseDdlMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * </pre>
     */
    public void dropDatabase(
        com.google.spanner.admin.database.v1.DropDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDropDatabaseMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetDatabaseDdlMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void setIamPolicyOnBackupInternalOnly(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyOnBackupInternalOnlyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database resource.
     * Returns an empty policy if a database exists but does
     * not have a policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getIamPolicyOnBackupInternalOnly(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyOnBackupInternalOnlyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void testIamPermissionsOnBackupInternalOnly(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel()
              .newCall(getTestIamPermissionsOnBackupInternalOnlyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void createBackup(
        com.google.spanner.admin.database.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateBackupMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void getBackup(
        com.google.spanner.admin.database.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBackupMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void updateBackup(
        com.google.spanner.admin.database.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.Backup> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateBackupMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void deleteBackup(
        com.google.spanner.admin.database.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteBackupMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listBackups(
        com.google.spanner.admin.database.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.database.v1.ListBackupsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListBackupsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void restoreDatabase(
        com.google.spanner.admin.database.v1.RestoreDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRestoreDatabaseMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listDatabaseOperations(
        com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDatabaseOperationsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void listBackupOperations(
        com.google.spanner.admin.database.v1.ListBackupOperationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListBackupOperationsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to create, drop, and
   * list databases. It also enables updating the schema of pre-existing
   * databases.
   * </pre>
   */
  public static final class DatabaseAdminBlockingStub
      extends io.grpc.stub.AbstractStub<DatabaseAdminBlockingStub> {
    private DatabaseAdminBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return blockingUnaryCall(
          getChannel(), getListDatabasesMethodHelper(), getCallOptions(), request);
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
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
     * [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public com.google.longrunning.Operation createDatabase(
        com.google.spanner.admin.database.v1.CreateDatabaseRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateDatabaseMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetDatabaseMethodHelper(), getCallOptions(), request);
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
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].  The operation has no response.
     * </pre>
     */
    public com.google.longrunning.Operation updateDatabaseDdl(
        com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateDatabaseDdlMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * </pre>
     */
    public com.google.protobuf.Empty dropDatabase(
        com.google.spanner.admin.database.v1.DropDatabaseRequest request) {
      return blockingUnaryCall(
          getChannel(), getDropDatabaseMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetDatabaseDdlMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.iam.v1.Policy setIamPolicyOnBackupInternalOnly(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(),
          getSetIamPolicyOnBackupInternalOnlyMethodHelper(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database resource.
     * Returns an empty policy if a database exists but does
     * not have a policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.iam.v1.Policy getIamPolicyOnBackupInternalOnly(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(),
          getGetIamPolicyOnBackupInternalOnlyMethodHelper(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissionsOnBackupInternalOnly(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(),
          getTestIamPermissionsOnBackupInternalOnlyMethodHelper(),
          getCallOptions(),
          request);
    }

    /** */
    public com.google.longrunning.Operation createBackup(
        com.google.spanner.admin.database.v1.CreateBackupRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateBackupMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.spanner.admin.database.v1.Backup getBackup(
        com.google.spanner.admin.database.v1.GetBackupRequest request) {
      return blockingUnaryCall(getChannel(), getGetBackupMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.spanner.admin.database.v1.Backup updateBackup(
        com.google.spanner.admin.database.v1.UpdateBackupRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateBackupMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.protobuf.Empty deleteBackup(
        com.google.spanner.admin.database.v1.DeleteBackupRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteBackupMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.spanner.admin.database.v1.ListBackupsResponse listBackups(
        com.google.spanner.admin.database.v1.ListBackupsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListBackupsMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.longrunning.Operation restoreDatabase(
        com.google.spanner.admin.database.v1.RestoreDatabaseRequest request) {
      return blockingUnaryCall(
          getChannel(), getRestoreDatabaseMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse
        listDatabaseOperations(
            com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListDatabaseOperationsMethodHelper(), getCallOptions(), request);
    }

    /** */
    public com.google.spanner.admin.database.v1.ListBackupOperationsResponse listBackupOperations(
        com.google.spanner.admin.database.v1.ListBackupOperationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListBackupOperationsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Spanner Database Admin API
   * The Cloud Spanner Database Admin API can be used to create, drop, and
   * list databases. It also enables updating the schema of pre-existing
   * databases.
   * </pre>
   */
  public static final class DatabaseAdminFutureStub
      extends io.grpc.stub.AbstractStub<DatabaseAdminFutureStub> {
    private DatabaseAdminFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return futureUnaryCall(
          getChannel().newCall(getListDatabasesMethodHelper(), getCallOptions()), request);
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
     * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
     * [response][google.longrunning.Operation.response] field type is
     * [Database][google.spanner.admin.database.v1.Database], if successful.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDatabase(com.google.spanner.admin.database.v1.CreateDatabaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateDatabaseMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetDatabaseMethodHelper(), getCallOptions()), request);
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
     * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata].  The operation has no response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDatabaseDdl(com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateDatabaseDdlMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Drops (aka deletes) a Cloud Spanner database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        dropDatabase(com.google.spanner.admin.database.v1.DropDatabaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDropDatabaseMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetDatabaseDdlMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a database resource.
     * Replaces any existing policy.
     * Authorization requires `spanner.databases.setIamPolicy`
     * permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicyOnBackupInternalOnly(com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyOnBackupInternalOnlyMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a database resource.
     * Returns an empty policy if a database exists but does
     * not have a policy set.
     * Authorization requires `spanner.databases.getIamPolicy` permission on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicyOnBackupInternalOnly(com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyOnBackupInternalOnlyMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that the caller has on the specified database resource.
     * Attempting this RPC on a non-existent Cloud Spanner database will
     * result in a NOT_FOUND error if the user has
     * `spanner.databases.list` permission on the containing Cloud
     * Spanner instance. Otherwise returns an empty set of permissions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissionsOnBackupInternalOnly(
            com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel()
              .newCall(getTestIamPermissionsOnBackupInternalOnlyMethodHelper(), getCallOptions()),
          request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackup(com.google.spanner.admin.database.v1.CreateBackupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateBackupMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.Backup>
        getBackup(com.google.spanner.admin.database.v1.GetBackupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBackupMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.Backup>
        updateBackup(com.google.spanner.admin.database.v1.UpdateBackupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateBackupMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBackup(com.google.spanner.admin.database.v1.DeleteBackupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListBackupsResponse>
        listBackups(com.google.spanner.admin.database.v1.ListBackupsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListBackupsMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreDatabase(com.google.spanner.admin.database.v1.RestoreDatabaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRestoreDatabaseMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse>
        listDatabaseOperations(
            com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDatabaseOperationsMethodHelper(), getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.spanner.admin.database.v1.ListBackupOperationsResponse>
        listBackupOperations(
            com.google.spanner.admin.database.v1.ListBackupOperationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListBackupOperationsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DATABASES = 0;
  private static final int METHODID_CREATE_DATABASE = 1;
  private static final int METHODID_GET_DATABASE = 2;
  private static final int METHODID_UPDATE_DATABASE_DDL = 3;
  private static final int METHODID_DROP_DATABASE = 4;
  private static final int METHODID_GET_DATABASE_DDL = 5;
  private static final int METHODID_SET_IAM_POLICY = 6;
  private static final int METHODID_SET_IAM_POLICY_ON_BACKUP_INTERNAL_ONLY = 7;
  private static final int METHODID_GET_IAM_POLICY = 8;
  private static final int METHODID_GET_IAM_POLICY_ON_BACKUP_INTERNAL_ONLY = 9;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 10;
  private static final int METHODID_TEST_IAM_PERMISSIONS_ON_BACKUP_INTERNAL_ONLY = 11;
  private static final int METHODID_CREATE_BACKUP = 12;
  private static final int METHODID_GET_BACKUP = 13;
  private static final int METHODID_UPDATE_BACKUP = 14;
  private static final int METHODID_DELETE_BACKUP = 15;
  private static final int METHODID_LIST_BACKUPS = 16;
  private static final int METHODID_RESTORE_DATABASE = 17;
  private static final int METHODID_LIST_DATABASE_OPERATIONS = 18;
  private static final int METHODID_LIST_BACKUP_OPERATIONS = 19;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DatabaseAdminImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DatabaseAdminImplBase serviceImpl, int methodId) {
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
        case METHODID_SET_IAM_POLICY_ON_BACKUP_INTERNAL_ONLY:
          serviceImpl.setIamPolicyOnBackupInternalOnly(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY_ON_BACKUP_INTERNAL_ONLY:
          serviceImpl.getIamPolicyOnBackupInternalOnly(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS_ON_BACKUP_INTERNAL_ONLY:
          serviceImpl.testIamPermissionsOnBackupInternalOnly(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.spanner.admin.database.v1.CreateBackupRequest) request,
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
    private final String methodName;

    DatabaseAdminMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getListDatabasesMethodHelper())
                      .addMethod(getCreateDatabaseMethodHelper())
                      .addMethod(getGetDatabaseMethodHelper())
                      .addMethod(getUpdateDatabaseDdlMethodHelper())
                      .addMethod(getDropDatabaseMethodHelper())
                      .addMethod(getGetDatabaseDdlMethodHelper())
                      .addMethod(getSetIamPolicyMethodHelper())
                      .addMethod(getSetIamPolicyOnBackupInternalOnlyMethodHelper())
                      .addMethod(getGetIamPolicyMethodHelper())
                      .addMethod(getGetIamPolicyOnBackupInternalOnlyMethodHelper())
                      .addMethod(getTestIamPermissionsMethodHelper())
                      .addMethod(getTestIamPermissionsOnBackupInternalOnlyMethodHelper())
                      .addMethod(getCreateBackupMethodHelper())
                      .addMethod(getGetBackupMethodHelper())
                      .addMethod(getUpdateBackupMethodHelper())
                      .addMethod(getDeleteBackupMethodHelper())
                      .addMethod(getListBackupsMethodHelper())
                      .addMethod(getRestoreDatabaseMethodHelper())
                      .addMethod(getListDatabaseOperationsMethodHelper())
                      .addMethod(getListBackupOperationsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
