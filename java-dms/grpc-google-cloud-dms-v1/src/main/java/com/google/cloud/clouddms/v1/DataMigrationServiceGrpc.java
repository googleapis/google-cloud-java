/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.clouddms.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Database Migration service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/clouddms/v1/clouddms.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataMigrationServiceGrpc {

  private DataMigrationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.clouddms.v1.DataMigrationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListMigrationJobsRequest,
          com.google.cloud.clouddms.v1.ListMigrationJobsResponse>
      getListMigrationJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMigrationJobs",
      requestType = com.google.cloud.clouddms.v1.ListMigrationJobsRequest.class,
      responseType = com.google.cloud.clouddms.v1.ListMigrationJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListMigrationJobsRequest,
          com.google.cloud.clouddms.v1.ListMigrationJobsResponse>
      getListMigrationJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ListMigrationJobsRequest,
            com.google.cloud.clouddms.v1.ListMigrationJobsResponse>
        getListMigrationJobsMethod;
    if ((getListMigrationJobsMethod = DataMigrationServiceGrpc.getListMigrationJobsMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getListMigrationJobsMethod = DataMigrationServiceGrpc.getListMigrationJobsMethod)
            == null) {
          DataMigrationServiceGrpc.getListMigrationJobsMethod =
              getListMigrationJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ListMigrationJobsRequest,
                          com.google.cloud.clouddms.v1.ListMigrationJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMigrationJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListMigrationJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListMigrationJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("ListMigrationJobs"))
                      .build();
        }
      }
    }
    return getListMigrationJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetMigrationJobRequest,
          com.google.cloud.clouddms.v1.MigrationJob>
      getGetMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMigrationJob",
      requestType = com.google.cloud.clouddms.v1.GetMigrationJobRequest.class,
      responseType = com.google.cloud.clouddms.v1.MigrationJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetMigrationJobRequest,
          com.google.cloud.clouddms.v1.MigrationJob>
      getGetMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.GetMigrationJobRequest,
            com.google.cloud.clouddms.v1.MigrationJob>
        getGetMigrationJobMethod;
    if ((getGetMigrationJobMethod = DataMigrationServiceGrpc.getGetMigrationJobMethod) == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getGetMigrationJobMethod = DataMigrationServiceGrpc.getGetMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getGetMigrationJobMethod =
              getGetMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.GetMigrationJobRequest,
                          com.google.cloud.clouddms.v1.MigrationJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.GetMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.MigrationJob.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("GetMigrationJob"))
                      .build();
        }
      }
    }
    return getGetMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreateMigrationJobRequest, com.google.longrunning.Operation>
      getCreateMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMigrationJob",
      requestType = com.google.cloud.clouddms.v1.CreateMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreateMigrationJobRequest, com.google.longrunning.Operation>
      getCreateMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.CreateMigrationJobRequest,
            com.google.longrunning.Operation>
        getCreateMigrationJobMethod;
    if ((getCreateMigrationJobMethod = DataMigrationServiceGrpc.getCreateMigrationJobMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getCreateMigrationJobMethod = DataMigrationServiceGrpc.getCreateMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getCreateMigrationJobMethod =
              getCreateMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.CreateMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.CreateMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("CreateMigrationJob"))
                      .build();
        }
      }
    }
    return getCreateMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.UpdateMigrationJobRequest, com.google.longrunning.Operation>
      getUpdateMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMigrationJob",
      requestType = com.google.cloud.clouddms.v1.UpdateMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.UpdateMigrationJobRequest, com.google.longrunning.Operation>
      getUpdateMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.UpdateMigrationJobRequest,
            com.google.longrunning.Operation>
        getUpdateMigrationJobMethod;
    if ((getUpdateMigrationJobMethod = DataMigrationServiceGrpc.getUpdateMigrationJobMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getUpdateMigrationJobMethod = DataMigrationServiceGrpc.getUpdateMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getUpdateMigrationJobMethod =
              getUpdateMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.UpdateMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.UpdateMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("UpdateMigrationJob"))
                      .build();
        }
      }
    }
    return getUpdateMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeleteMigrationJobRequest, com.google.longrunning.Operation>
      getDeleteMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMigrationJob",
      requestType = com.google.cloud.clouddms.v1.DeleteMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeleteMigrationJobRequest, com.google.longrunning.Operation>
      getDeleteMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.DeleteMigrationJobRequest,
            com.google.longrunning.Operation>
        getDeleteMigrationJobMethod;
    if ((getDeleteMigrationJobMethod = DataMigrationServiceGrpc.getDeleteMigrationJobMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getDeleteMigrationJobMethod = DataMigrationServiceGrpc.getDeleteMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getDeleteMigrationJobMethod =
              getDeleteMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.DeleteMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.DeleteMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("DeleteMigrationJob"))
                      .build();
        }
      }
    }
    return getDeleteMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.StartMigrationJobRequest, com.google.longrunning.Operation>
      getStartMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartMigrationJob",
      requestType = com.google.cloud.clouddms.v1.StartMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.StartMigrationJobRequest, com.google.longrunning.Operation>
      getStartMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.StartMigrationJobRequest, com.google.longrunning.Operation>
        getStartMigrationJobMethod;
    if ((getStartMigrationJobMethod = DataMigrationServiceGrpc.getStartMigrationJobMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getStartMigrationJobMethod = DataMigrationServiceGrpc.getStartMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getStartMigrationJobMethod =
              getStartMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.StartMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.StartMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("StartMigrationJob"))
                      .build();
        }
      }
    }
    return getStartMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.StopMigrationJobRequest, com.google.longrunning.Operation>
      getStopMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopMigrationJob",
      requestType = com.google.cloud.clouddms.v1.StopMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.StopMigrationJobRequest, com.google.longrunning.Operation>
      getStopMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.StopMigrationJobRequest, com.google.longrunning.Operation>
        getStopMigrationJobMethod;
    if ((getStopMigrationJobMethod = DataMigrationServiceGrpc.getStopMigrationJobMethod) == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getStopMigrationJobMethod = DataMigrationServiceGrpc.getStopMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getStopMigrationJobMethod =
              getStopMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.StopMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.StopMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("StopMigrationJob"))
                      .build();
        }
      }
    }
    return getStopMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ResumeMigrationJobRequest, com.google.longrunning.Operation>
      getResumeMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeMigrationJob",
      requestType = com.google.cloud.clouddms.v1.ResumeMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ResumeMigrationJobRequest, com.google.longrunning.Operation>
      getResumeMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ResumeMigrationJobRequest,
            com.google.longrunning.Operation>
        getResumeMigrationJobMethod;
    if ((getResumeMigrationJobMethod = DataMigrationServiceGrpc.getResumeMigrationJobMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getResumeMigrationJobMethod = DataMigrationServiceGrpc.getResumeMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getResumeMigrationJobMethod =
              getResumeMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ResumeMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ResumeMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("ResumeMigrationJob"))
                      .build();
        }
      }
    }
    return getResumeMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.PromoteMigrationJobRequest, com.google.longrunning.Operation>
      getPromoteMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PromoteMigrationJob",
      requestType = com.google.cloud.clouddms.v1.PromoteMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.PromoteMigrationJobRequest, com.google.longrunning.Operation>
      getPromoteMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.PromoteMigrationJobRequest,
            com.google.longrunning.Operation>
        getPromoteMigrationJobMethod;
    if ((getPromoteMigrationJobMethod = DataMigrationServiceGrpc.getPromoteMigrationJobMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getPromoteMigrationJobMethod = DataMigrationServiceGrpc.getPromoteMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getPromoteMigrationJobMethod =
              getPromoteMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.PromoteMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PromoteMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.PromoteMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("PromoteMigrationJob"))
                      .build();
        }
      }
    }
    return getPromoteMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.VerifyMigrationJobRequest, com.google.longrunning.Operation>
      getVerifyMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyMigrationJob",
      requestType = com.google.cloud.clouddms.v1.VerifyMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.VerifyMigrationJobRequest, com.google.longrunning.Operation>
      getVerifyMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.VerifyMigrationJobRequest,
            com.google.longrunning.Operation>
        getVerifyMigrationJobMethod;
    if ((getVerifyMigrationJobMethod = DataMigrationServiceGrpc.getVerifyMigrationJobMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getVerifyMigrationJobMethod = DataMigrationServiceGrpc.getVerifyMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getVerifyMigrationJobMethod =
              getVerifyMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.VerifyMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.VerifyMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("VerifyMigrationJob"))
                      .build();
        }
      }
    }
    return getVerifyMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.RestartMigrationJobRequest, com.google.longrunning.Operation>
      getRestartMigrationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartMigrationJob",
      requestType = com.google.cloud.clouddms.v1.RestartMigrationJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.RestartMigrationJobRequest, com.google.longrunning.Operation>
      getRestartMigrationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.RestartMigrationJobRequest,
            com.google.longrunning.Operation>
        getRestartMigrationJobMethod;
    if ((getRestartMigrationJobMethod = DataMigrationServiceGrpc.getRestartMigrationJobMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getRestartMigrationJobMethod = DataMigrationServiceGrpc.getRestartMigrationJobMethod)
            == null) {
          DataMigrationServiceGrpc.getRestartMigrationJobMethod =
              getRestartMigrationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.RestartMigrationJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RestartMigrationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.RestartMigrationJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("RestartMigrationJob"))
                      .build();
        }
      }
    }
    return getRestartMigrationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GenerateSshScriptRequest,
          com.google.cloud.clouddms.v1.SshScript>
      getGenerateSshScriptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateSshScript",
      requestType = com.google.cloud.clouddms.v1.GenerateSshScriptRequest.class,
      responseType = com.google.cloud.clouddms.v1.SshScript.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GenerateSshScriptRequest,
          com.google.cloud.clouddms.v1.SshScript>
      getGenerateSshScriptMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.GenerateSshScriptRequest,
            com.google.cloud.clouddms.v1.SshScript>
        getGenerateSshScriptMethod;
    if ((getGenerateSshScriptMethod = DataMigrationServiceGrpc.getGenerateSshScriptMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getGenerateSshScriptMethod = DataMigrationServiceGrpc.getGenerateSshScriptMethod)
            == null) {
          DataMigrationServiceGrpc.getGenerateSshScriptMethod =
              getGenerateSshScriptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.GenerateSshScriptRequest,
                          com.google.cloud.clouddms.v1.SshScript>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateSshScript"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.GenerateSshScriptRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.SshScript.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("GenerateSshScript"))
                      .build();
        }
      }
    }
    return getGenerateSshScriptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest,
          com.google.cloud.clouddms.v1.TcpProxyScript>
      getGenerateTcpProxyScriptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateTcpProxyScript",
      requestType = com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest.class,
      responseType = com.google.cloud.clouddms.v1.TcpProxyScript.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest,
          com.google.cloud.clouddms.v1.TcpProxyScript>
      getGenerateTcpProxyScriptMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest,
            com.google.cloud.clouddms.v1.TcpProxyScript>
        getGenerateTcpProxyScriptMethod;
    if ((getGenerateTcpProxyScriptMethod = DataMigrationServiceGrpc.getGenerateTcpProxyScriptMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getGenerateTcpProxyScriptMethod =
                DataMigrationServiceGrpc.getGenerateTcpProxyScriptMethod)
            == null) {
          DataMigrationServiceGrpc.getGenerateTcpProxyScriptMethod =
              getGenerateTcpProxyScriptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest,
                          com.google.cloud.clouddms.v1.TcpProxyScript>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateTcpProxyScript"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.TcpProxyScript.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "GenerateTcpProxyScript"))
                      .build();
        }
      }
    }
    return getGenerateTcpProxyScriptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListConnectionProfilesRequest,
          com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>
      getListConnectionProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnectionProfiles",
      requestType = com.google.cloud.clouddms.v1.ListConnectionProfilesRequest.class,
      responseType = com.google.cloud.clouddms.v1.ListConnectionProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListConnectionProfilesRequest,
          com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>
      getListConnectionProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ListConnectionProfilesRequest,
            com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>
        getListConnectionProfilesMethod;
    if ((getListConnectionProfilesMethod = DataMigrationServiceGrpc.getListConnectionProfilesMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getListConnectionProfilesMethod =
                DataMigrationServiceGrpc.getListConnectionProfilesMethod)
            == null) {
          DataMigrationServiceGrpc.getListConnectionProfilesMethod =
              getListConnectionProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ListConnectionProfilesRequest,
                          com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConnectionProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListConnectionProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListConnectionProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "ListConnectionProfiles"))
                      .build();
        }
      }
    }
    return getListConnectionProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetConnectionProfileRequest,
          com.google.cloud.clouddms.v1.ConnectionProfile>
      getGetConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnectionProfile",
      requestType = com.google.cloud.clouddms.v1.GetConnectionProfileRequest.class,
      responseType = com.google.cloud.clouddms.v1.ConnectionProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetConnectionProfileRequest,
          com.google.cloud.clouddms.v1.ConnectionProfile>
      getGetConnectionProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.GetConnectionProfileRequest,
            com.google.cloud.clouddms.v1.ConnectionProfile>
        getGetConnectionProfileMethod;
    if ((getGetConnectionProfileMethod = DataMigrationServiceGrpc.getGetConnectionProfileMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getGetConnectionProfileMethod = DataMigrationServiceGrpc.getGetConnectionProfileMethod)
            == null) {
          DataMigrationServiceGrpc.getGetConnectionProfileMethod =
              getGetConnectionProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.GetConnectionProfileRequest,
                          com.google.cloud.clouddms.v1.ConnectionProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetConnectionProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.GetConnectionProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ConnectionProfile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("GetConnectionProfile"))
                      .build();
        }
      }
    }
    return getGetConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreateConnectionProfileRequest,
          com.google.longrunning.Operation>
      getCreateConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnectionProfile",
      requestType = com.google.cloud.clouddms.v1.CreateConnectionProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreateConnectionProfileRequest,
          com.google.longrunning.Operation>
      getCreateConnectionProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.CreateConnectionProfileRequest,
            com.google.longrunning.Operation>
        getCreateConnectionProfileMethod;
    if ((getCreateConnectionProfileMethod =
            DataMigrationServiceGrpc.getCreateConnectionProfileMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getCreateConnectionProfileMethod =
                DataMigrationServiceGrpc.getCreateConnectionProfileMethod)
            == null) {
          DataMigrationServiceGrpc.getCreateConnectionProfileMethod =
              getCreateConnectionProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.CreateConnectionProfileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateConnectionProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.CreateConnectionProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "CreateConnectionProfile"))
                      .build();
        }
      }
    }
    return getCreateConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest,
          com.google.longrunning.Operation>
      getUpdateConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnectionProfile",
      requestType = com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest,
          com.google.longrunning.Operation>
      getUpdateConnectionProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest,
            com.google.longrunning.Operation>
        getUpdateConnectionProfileMethod;
    if ((getUpdateConnectionProfileMethod =
            DataMigrationServiceGrpc.getUpdateConnectionProfileMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getUpdateConnectionProfileMethod =
                DataMigrationServiceGrpc.getUpdateConnectionProfileMethod)
            == null) {
          DataMigrationServiceGrpc.getUpdateConnectionProfileMethod =
              getUpdateConnectionProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConnectionProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "UpdateConnectionProfile"))
                      .build();
        }
      }
    }
    return getUpdateConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest,
          com.google.longrunning.Operation>
      getDeleteConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnectionProfile",
      requestType = com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest,
          com.google.longrunning.Operation>
      getDeleteConnectionProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest,
            com.google.longrunning.Operation>
        getDeleteConnectionProfileMethod;
    if ((getDeleteConnectionProfileMethod =
            DataMigrationServiceGrpc.getDeleteConnectionProfileMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getDeleteConnectionProfileMethod =
                DataMigrationServiceGrpc.getDeleteConnectionProfileMethod)
            == null) {
          DataMigrationServiceGrpc.getDeleteConnectionProfileMethod =
              getDeleteConnectionProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConnectionProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "DeleteConnectionProfile"))
                      .build();
        }
      }
    }
    return getDeleteConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getCreatePrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePrivateConnection",
      requestType = com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getCreatePrivateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest,
            com.google.longrunning.Operation>
        getCreatePrivateConnectionMethod;
    if ((getCreatePrivateConnectionMethod =
            DataMigrationServiceGrpc.getCreatePrivateConnectionMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getCreatePrivateConnectionMethod =
                DataMigrationServiceGrpc.getCreatePrivateConnectionMethod)
            == null) {
          DataMigrationServiceGrpc.getCreatePrivateConnectionMethod =
              getCreatePrivateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePrivateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "CreatePrivateConnection"))
                      .build();
        }
      }
    }
    return getCreatePrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetPrivateConnectionRequest,
          com.google.cloud.clouddms.v1.PrivateConnection>
      getGetPrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrivateConnection",
      requestType = com.google.cloud.clouddms.v1.GetPrivateConnectionRequest.class,
      responseType = com.google.cloud.clouddms.v1.PrivateConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetPrivateConnectionRequest,
          com.google.cloud.clouddms.v1.PrivateConnection>
      getGetPrivateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.GetPrivateConnectionRequest,
            com.google.cloud.clouddms.v1.PrivateConnection>
        getGetPrivateConnectionMethod;
    if ((getGetPrivateConnectionMethod = DataMigrationServiceGrpc.getGetPrivateConnectionMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getGetPrivateConnectionMethod = DataMigrationServiceGrpc.getGetPrivateConnectionMethod)
            == null) {
          DataMigrationServiceGrpc.getGetPrivateConnectionMethod =
              getGetPrivateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.GetPrivateConnectionRequest,
                          com.google.cloud.clouddms.v1.PrivateConnection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPrivateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.GetPrivateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.PrivateConnection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("GetPrivateConnection"))
                      .build();
        }
      }
    }
    return getGetPrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest,
          com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>
      getListPrivateConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrivateConnections",
      requestType = com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest.class,
      responseType = com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest,
          com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>
      getListPrivateConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest,
            com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>
        getListPrivateConnectionsMethod;
    if ((getListPrivateConnectionsMethod = DataMigrationServiceGrpc.getListPrivateConnectionsMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getListPrivateConnectionsMethod =
                DataMigrationServiceGrpc.getListPrivateConnectionsMethod)
            == null) {
          DataMigrationServiceGrpc.getListPrivateConnectionsMethod =
              getListPrivateConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest,
                          com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPrivateConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "ListPrivateConnections"))
                      .build();
        }
      }
    }
    return getListPrivateConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getDeletePrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePrivateConnection",
      requestType = com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest,
          com.google.longrunning.Operation>
      getDeletePrivateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest,
            com.google.longrunning.Operation>
        getDeletePrivateConnectionMethod;
    if ((getDeletePrivateConnectionMethod =
            DataMigrationServiceGrpc.getDeletePrivateConnectionMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getDeletePrivateConnectionMethod =
                DataMigrationServiceGrpc.getDeletePrivateConnectionMethod)
            == null) {
          DataMigrationServiceGrpc.getDeletePrivateConnectionMethod =
              getDeletePrivateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePrivateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "DeletePrivateConnection"))
                      .build();
        }
      }
    }
    return getDeletePrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest,
          com.google.cloud.clouddms.v1.ConversionWorkspace>
      getGetConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest.class,
      responseType = com.google.cloud.clouddms.v1.ConversionWorkspace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest,
          com.google.cloud.clouddms.v1.ConversionWorkspace>
      getGetConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest,
            com.google.cloud.clouddms.v1.ConversionWorkspace>
        getGetConversionWorkspaceMethod;
    if ((getGetConversionWorkspaceMethod = DataMigrationServiceGrpc.getGetConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getGetConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getGetConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getGetConversionWorkspaceMethod =
              getGetConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest,
                          com.google.cloud.clouddms.v1.ConversionWorkspace>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ConversionWorkspace
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "GetConversionWorkspace"))
                      .build();
        }
      }
    }
    return getGetConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest,
          com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>
      getListConversionWorkspacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversionWorkspaces",
      requestType = com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest.class,
      responseType = com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest,
          com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>
      getListConversionWorkspacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest,
            com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>
        getListConversionWorkspacesMethod;
    if ((getListConversionWorkspacesMethod =
            DataMigrationServiceGrpc.getListConversionWorkspacesMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getListConversionWorkspacesMethod =
                DataMigrationServiceGrpc.getListConversionWorkspacesMethod)
            == null) {
          DataMigrationServiceGrpc.getListConversionWorkspacesMethod =
              getListConversionWorkspacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest,
                          com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConversionWorkspaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "ListConversionWorkspaces"))
                      .build();
        }
      }
    }
    return getListConversionWorkspacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getCreateConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getCreateConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest,
            com.google.longrunning.Operation>
        getCreateConversionWorkspaceMethod;
    if ((getCreateConversionWorkspaceMethod =
            DataMigrationServiceGrpc.getCreateConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getCreateConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getCreateConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getCreateConversionWorkspaceMethod =
              getCreateConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "CreateConversionWorkspace"))
                      .build();
        }
      }
    }
    return getCreateConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getUpdateConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getUpdateConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest,
            com.google.longrunning.Operation>
        getUpdateConversionWorkspaceMethod;
    if ((getUpdateConversionWorkspaceMethod =
            DataMigrationServiceGrpc.getUpdateConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getUpdateConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getUpdateConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getUpdateConversionWorkspaceMethod =
              getUpdateConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "UpdateConversionWorkspace"))
                      .build();
        }
      }
    }
    return getUpdateConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getDeleteConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getDeleteConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest,
            com.google.longrunning.Operation>
        getDeleteConversionWorkspaceMethod;
    if ((getDeleteConversionWorkspaceMethod =
            DataMigrationServiceGrpc.getDeleteConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getDeleteConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getDeleteConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getDeleteConversionWorkspaceMethod =
              getDeleteConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "DeleteConversionWorkspace"))
                      .build();
        }
      }
    }
    return getDeleteConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreateMappingRuleRequest,
          com.google.cloud.clouddms.v1.MappingRule>
      getCreateMappingRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMappingRule",
      requestType = com.google.cloud.clouddms.v1.CreateMappingRuleRequest.class,
      responseType = com.google.cloud.clouddms.v1.MappingRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CreateMappingRuleRequest,
          com.google.cloud.clouddms.v1.MappingRule>
      getCreateMappingRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.CreateMappingRuleRequest,
            com.google.cloud.clouddms.v1.MappingRule>
        getCreateMappingRuleMethod;
    if ((getCreateMappingRuleMethod = DataMigrationServiceGrpc.getCreateMappingRuleMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getCreateMappingRuleMethod = DataMigrationServiceGrpc.getCreateMappingRuleMethod)
            == null) {
          DataMigrationServiceGrpc.getCreateMappingRuleMethod =
              getCreateMappingRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.CreateMappingRuleRequest,
                          com.google.cloud.clouddms.v1.MappingRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMappingRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.CreateMappingRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.MappingRule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("CreateMappingRule"))
                      .build();
        }
      }
    }
    return getCreateMappingRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeleteMappingRuleRequest, com.google.protobuf.Empty>
      getDeleteMappingRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMappingRule",
      requestType = com.google.cloud.clouddms.v1.DeleteMappingRuleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DeleteMappingRuleRequest, com.google.protobuf.Empty>
      getDeleteMappingRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.DeleteMappingRuleRequest, com.google.protobuf.Empty>
        getDeleteMappingRuleMethod;
    if ((getDeleteMappingRuleMethod = DataMigrationServiceGrpc.getDeleteMappingRuleMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getDeleteMappingRuleMethod = DataMigrationServiceGrpc.getDeleteMappingRuleMethod)
            == null) {
          DataMigrationServiceGrpc.getDeleteMappingRuleMethod =
              getDeleteMappingRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.DeleteMappingRuleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMappingRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.DeleteMappingRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("DeleteMappingRule"))
                      .build();
        }
      }
    }
    return getDeleteMappingRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListMappingRulesRequest,
          com.google.cloud.clouddms.v1.ListMappingRulesResponse>
      getListMappingRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMappingRules",
      requestType = com.google.cloud.clouddms.v1.ListMappingRulesRequest.class,
      responseType = com.google.cloud.clouddms.v1.ListMappingRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ListMappingRulesRequest,
          com.google.cloud.clouddms.v1.ListMappingRulesResponse>
      getListMappingRulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ListMappingRulesRequest,
            com.google.cloud.clouddms.v1.ListMappingRulesResponse>
        getListMappingRulesMethod;
    if ((getListMappingRulesMethod = DataMigrationServiceGrpc.getListMappingRulesMethod) == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getListMappingRulesMethod = DataMigrationServiceGrpc.getListMappingRulesMethod)
            == null) {
          DataMigrationServiceGrpc.getListMappingRulesMethod =
              getListMappingRulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ListMappingRulesRequest,
                          com.google.cloud.clouddms.v1.ListMappingRulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMappingRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListMappingRulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ListMappingRulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("ListMappingRules"))
                      .build();
        }
      }
    }
    return getListMappingRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetMappingRuleRequest,
          com.google.cloud.clouddms.v1.MappingRule>
      getGetMappingRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMappingRule",
      requestType = com.google.cloud.clouddms.v1.GetMappingRuleRequest.class,
      responseType = com.google.cloud.clouddms.v1.MappingRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.GetMappingRuleRequest,
          com.google.cloud.clouddms.v1.MappingRule>
      getGetMappingRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.GetMappingRuleRequest,
            com.google.cloud.clouddms.v1.MappingRule>
        getGetMappingRuleMethod;
    if ((getGetMappingRuleMethod = DataMigrationServiceGrpc.getGetMappingRuleMethod) == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getGetMappingRuleMethod = DataMigrationServiceGrpc.getGetMappingRuleMethod) == null) {
          DataMigrationServiceGrpc.getGetMappingRuleMethod =
              getGetMappingRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.GetMappingRuleRequest,
                          com.google.cloud.clouddms.v1.MappingRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMappingRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.GetMappingRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.MappingRule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("GetMappingRule"))
                      .build();
        }
      }
    }
    return getGetMappingRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getSeedConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SeedConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getSeedConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest,
            com.google.longrunning.Operation>
        getSeedConversionWorkspaceMethod;
    if ((getSeedConversionWorkspaceMethod =
            DataMigrationServiceGrpc.getSeedConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getSeedConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getSeedConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getSeedConversionWorkspaceMethod =
              getSeedConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SeedConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "SeedConversionWorkspace"))
                      .build();
        }
      }
    }
    return getSeedConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ImportMappingRulesRequest, com.google.longrunning.Operation>
      getImportMappingRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportMappingRules",
      requestType = com.google.cloud.clouddms.v1.ImportMappingRulesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ImportMappingRulesRequest, com.google.longrunning.Operation>
      getImportMappingRulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ImportMappingRulesRequest,
            com.google.longrunning.Operation>
        getImportMappingRulesMethod;
    if ((getImportMappingRulesMethod = DataMigrationServiceGrpc.getImportMappingRulesMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getImportMappingRulesMethod = DataMigrationServiceGrpc.getImportMappingRulesMethod)
            == null) {
          DataMigrationServiceGrpc.getImportMappingRulesMethod =
              getImportMappingRulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ImportMappingRulesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportMappingRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ImportMappingRulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("ImportMappingRules"))
                      .build();
        }
      }
    }
    return getImportMappingRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getConvertConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConvertConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getConvertConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest,
            com.google.longrunning.Operation>
        getConvertConversionWorkspaceMethod;
    if ((getConvertConversionWorkspaceMethod =
            DataMigrationServiceGrpc.getConvertConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getConvertConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getConvertConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getConvertConversionWorkspaceMethod =
              getConvertConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ConvertConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "ConvertConversionWorkspace"))
                      .build();
        }
      }
    }
    return getConvertConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getCommitConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CommitConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getCommitConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest,
            com.google.longrunning.Operation>
        getCommitConversionWorkspaceMethod;
    if ((getCommitConversionWorkspaceMethod =
            DataMigrationServiceGrpc.getCommitConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getCommitConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getCommitConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getCommitConversionWorkspaceMethod =
              getCommitConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CommitConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "CommitConversionWorkspace"))
                      .build();
        }
      }
    }
    return getCommitConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getRollbackConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getRollbackConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest,
            com.google.longrunning.Operation>
        getRollbackConversionWorkspaceMethod;
    if ((getRollbackConversionWorkspaceMethod =
            DataMigrationServiceGrpc.getRollbackConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getRollbackConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getRollbackConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getRollbackConversionWorkspaceMethod =
              getRollbackConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RollbackConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "RollbackConversionWorkspace"))
                      .build();
        }
      }
    }
    return getRollbackConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getApplyConversionWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyConversionWorkspace",
      requestType = com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest,
          com.google.longrunning.Operation>
      getApplyConversionWorkspaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest,
            com.google.longrunning.Operation>
        getApplyConversionWorkspaceMethod;
    if ((getApplyConversionWorkspaceMethod =
            DataMigrationServiceGrpc.getApplyConversionWorkspaceMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getApplyConversionWorkspaceMethod =
                DataMigrationServiceGrpc.getApplyConversionWorkspaceMethod)
            == null) {
          DataMigrationServiceGrpc.getApplyConversionWorkspaceMethod =
              getApplyConversionWorkspaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ApplyConversionWorkspace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "ApplyConversionWorkspace"))
                      .build();
        }
      }
    }
    return getApplyConversionWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest,
          com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>
      getDescribeDatabaseEntitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DescribeDatabaseEntities",
      requestType = com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest.class,
      responseType = com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest,
          com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>
      getDescribeDatabaseEntitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest,
            com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>
        getDescribeDatabaseEntitiesMethod;
    if ((getDescribeDatabaseEntitiesMethod =
            DataMigrationServiceGrpc.getDescribeDatabaseEntitiesMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getDescribeDatabaseEntitiesMethod =
                DataMigrationServiceGrpc.getDescribeDatabaseEntitiesMethod)
            == null) {
          DataMigrationServiceGrpc.getDescribeDatabaseEntitiesMethod =
              getDescribeDatabaseEntitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest,
                          com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DescribeDatabaseEntities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "DescribeDatabaseEntities"))
                      .build();
        }
      }
    }
    return getDescribeDatabaseEntitiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest,
          com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>
      getSearchBackgroundJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchBackgroundJobs",
      requestType = com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest.class,
      responseType = com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest,
          com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>
      getSearchBackgroundJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest,
            com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>
        getSearchBackgroundJobsMethod;
    if ((getSearchBackgroundJobsMethod = DataMigrationServiceGrpc.getSearchBackgroundJobsMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getSearchBackgroundJobsMethod = DataMigrationServiceGrpc.getSearchBackgroundJobsMethod)
            == null) {
          DataMigrationServiceGrpc.getSearchBackgroundJobsMethod =
              getSearchBackgroundJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest,
                          com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchBackgroundJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("SearchBackgroundJobs"))
                      .build();
        }
      }
    }
    return getSearchBackgroundJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest,
          com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>
      getDescribeConversionWorkspaceRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DescribeConversionWorkspaceRevisions",
      requestType = com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest.class,
      responseType =
          com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest,
          com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>
      getDescribeConversionWorkspaceRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest,
            com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>
        getDescribeConversionWorkspaceRevisionsMethod;
    if ((getDescribeConversionWorkspaceRevisionsMethod =
            DataMigrationServiceGrpc.getDescribeConversionWorkspaceRevisionsMethod)
        == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getDescribeConversionWorkspaceRevisionsMethod =
                DataMigrationServiceGrpc.getDescribeConversionWorkspaceRevisionsMethod)
            == null) {
          DataMigrationServiceGrpc.getDescribeConversionWorkspaceRevisionsMethod =
              getDescribeConversionWorkspaceRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest,
                          com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DescribeConversionWorkspaceRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1
                                  .DescribeConversionWorkspaceRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1
                                  .DescribeConversionWorkspaceRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier(
                              "DescribeConversionWorkspaceRevisions"))
                      .build();
        }
      }
    }
    return getDescribeConversionWorkspaceRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.FetchStaticIpsRequest,
          com.google.cloud.clouddms.v1.FetchStaticIpsResponse>
      getFetchStaticIpsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchStaticIps",
      requestType = com.google.cloud.clouddms.v1.FetchStaticIpsRequest.class,
      responseType = com.google.cloud.clouddms.v1.FetchStaticIpsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.clouddms.v1.FetchStaticIpsRequest,
          com.google.cloud.clouddms.v1.FetchStaticIpsResponse>
      getFetchStaticIpsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.clouddms.v1.FetchStaticIpsRequest,
            com.google.cloud.clouddms.v1.FetchStaticIpsResponse>
        getFetchStaticIpsMethod;
    if ((getFetchStaticIpsMethod = DataMigrationServiceGrpc.getFetchStaticIpsMethod) == null) {
      synchronized (DataMigrationServiceGrpc.class) {
        if ((getFetchStaticIpsMethod = DataMigrationServiceGrpc.getFetchStaticIpsMethod) == null) {
          DataMigrationServiceGrpc.getFetchStaticIpsMethod =
              getFetchStaticIpsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.clouddms.v1.FetchStaticIpsRequest,
                          com.google.cloud.clouddms.v1.FetchStaticIpsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchStaticIps"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.FetchStaticIpsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.clouddms.v1.FetchStaticIpsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataMigrationServiceMethodDescriptorSupplier("FetchStaticIps"))
                      .build();
        }
      }
    }
    return getFetchStaticIpsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataMigrationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataMigrationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataMigrationServiceStub>() {
          @java.lang.Override
          public DataMigrationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataMigrationServiceStub(channel, callOptions);
          }
        };
    return DataMigrationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataMigrationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataMigrationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataMigrationServiceBlockingStub>() {
          @java.lang.Override
          public DataMigrationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataMigrationServiceBlockingStub(channel, callOptions);
          }
        };
    return DataMigrationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataMigrationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataMigrationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataMigrationServiceFutureStub>() {
          @java.lang.Override
          public DataMigrationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataMigrationServiceFutureStub(channel, callOptions);
          }
        };
    return DataMigrationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Database Migration service
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists migration jobs in a given project and location.
     * </pre>
     */
    default void listMigrationJobs(
        com.google.cloud.clouddms.v1.ListMigrationJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListMigrationJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMigrationJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single migration job.
     * </pre>
     */
    default void getMigrationJob(
        com.google.cloud.clouddms.v1.GetMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MigrationJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new migration job in a given project and location.
     * </pre>
     */
    default void createMigrationJob(
        com.google.cloud.clouddms.v1.CreateMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single migration job.
     * </pre>
     */
    default void updateMigrationJob(
        com.google.cloud.clouddms.v1.UpdateMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single migration job.
     * </pre>
     */
    default void deleteMigrationJob(
        com.google.cloud.clouddms.v1.DeleteMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start an already created migration job.
     * </pre>
     */
    default void startMigrationJob(
        com.google.cloud.clouddms.v1.StartMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a running migration job.
     * </pre>
     */
    default void stopMigrationJob(
        com.google.cloud.clouddms.v1.StopMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume a migration job that is currently stopped and is resumable (was
     * stopped during CDC phase).
     * </pre>
     */
    default void resumeMigrationJob(
        com.google.cloud.clouddms.v1.ResumeMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Promote a migration job, stopping replication to the destination and
     * promoting the destination to be a standalone database.
     * </pre>
     */
    default void promoteMigrationJob(
        com.google.cloud.clouddms.v1.PromoteMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPromoteMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Verify a migration job, making sure the destination can reach the source
     * and that all configuration and prerequisites are met.
     * </pre>
     */
    default void verifyMigrationJob(
        com.google.cloud.clouddms.v1.VerifyMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getVerifyMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restart a stopped or failed migration job, resetting the destination
     * instance to its original state and starting the migration process from
     * scratch.
     * </pre>
     */
    default void restartMigrationJob(
        com.google.cloud.clouddms.v1.RestartMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestartMigrationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate a SSH configuration script to configure the reverse SSH
     * connectivity.
     * </pre>
     */
    default void generateSshScript(
        com.google.cloud.clouddms.v1.GenerateSshScriptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.SshScript> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateSshScriptMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate a TCP Proxy configuration script to configure a cloud-hosted VM
     * running a TCP Proxy.
     * </pre>
     */
    default void generateTcpProxyScript(
        com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.TcpProxyScript> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateTcpProxyScriptMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of all connection profiles in a given project and
     * location.
     * </pre>
     */
    default void listConnectionProfiles(
        com.google.cloud.clouddms.v1.ListConnectionProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConnectionProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single connection profile.
     * </pre>
     */
    default void getConnectionProfile(
        com.google.cloud.clouddms.v1.GetConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ConnectionProfile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConnectionProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connection profile in a given project and location.
     * </pre>
     */
    default void createConnectionProfile(
        com.google.cloud.clouddms.v1.CreateConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConnectionProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the configuration of a single connection profile.
     * </pre>
     */
    default void updateConnectionProfile(
        com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConnectionProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Database Migration Service connection profile.
     * A connection profile can only be deleted if it is not in use by any
     * active migration jobs.
     * </pre>
     */
    default void deleteConnectionProfile(
        com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConnectionProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new private connection in a given project and location.
     * </pre>
     */
    default void createPrivateConnection(
        com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePrivateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single private connection.
     * </pre>
     */
    default void getPrivateConnection(
        com.google.cloud.clouddms.v1.GetPrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.PrivateConnection>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPrivateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of private connections in a given project and location.
     * </pre>
     */
    default void listPrivateConnections(
        com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPrivateConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Database Migration Service private connection.
     * </pre>
     */
    default void deletePrivateConnection(
        com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePrivateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversion workspace.
     * </pre>
     */
    default void getConversionWorkspace(
        com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ConversionWorkspace>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists conversion workspaces in a given project and location.
     * </pre>
     */
    default void listConversionWorkspaces(
        com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversionWorkspacesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversion workspace in a given project and location.
     * </pre>
     */
    default void createConversionWorkspace(
        com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single conversion workspace.
     * </pre>
     */
    default void updateConversionWorkspace(
        com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single conversion workspace.
     * </pre>
     */
    default void deleteConversionWorkspace(
        com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new mapping rule for a given conversion workspace.
     * </pre>
     */
    default void createMappingRule(
        com.google.cloud.clouddms.v1.CreateMappingRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MappingRule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMappingRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single mapping rule.
     * </pre>
     */
    default void deleteMappingRule(
        com.google.cloud.clouddms.v1.DeleteMappingRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMappingRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the mapping rules for a specific conversion workspace.
     * </pre>
     */
    default void listMappingRules(
        com.google.cloud.clouddms.v1.ListMappingRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListMappingRulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMappingRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a mapping rule.
     * </pre>
     */
    default void getMappingRule(
        com.google.cloud.clouddms.v1.GetMappingRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MappingRule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMappingRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports a snapshot of the source database into the
     * conversion workspace.
     * </pre>
     */
    default void seedConversionWorkspace(
        com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSeedConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the mapping rules for a given conversion workspace.
     * Supports various formats of external rules files.
     * </pre>
     */
    default void importMappingRules(
        com.google.cloud.clouddms.v1.ImportMappingRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportMappingRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a draft tree schema for the destination database.
     * </pre>
     */
    default void convertConversionWorkspace(
        com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getConvertConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks all the data in the conversion workspace as committed.
     * </pre>
     */
    default void commitConversionWorkspace(
        com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCommitConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a conversion workspace to the last committed snapshot.
     * </pre>
     */
    default void rollbackConversionWorkspace(
        com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRollbackConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Applies draft tree onto a specific destination database.
     * </pre>
     */
    default void applyConversionWorkspace(
        com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApplyConversionWorkspaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes the database entities tree for a specific conversion workspace
     * and a specific tree type.
     * Database entities are not resources like conversion workspaces or mapping
     * rules, and they can't be created, updated or deleted. Instead, they are
     * simple data objects describing the structure of the client database.
     * </pre>
     */
    default void describeDatabaseEntities(
        com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDescribeDatabaseEntitiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches/lists the background jobs for a specific
     * conversion workspace.
     * The background jobs are not resources like conversion workspaces or
     * mapping rules, and they can't be created, updated or deleted.
     * Instead, they are a way to expose the data plane jobs log.
     * </pre>
     */
    default void searchBackgroundJobs(
        com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchBackgroundJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of committed revisions of a specific conversion
     * workspace.
     * </pre>
     */
    default void describeConversionWorkspaceRevisions(
        com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDescribeConversionWorkspaceRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a set of static IP addresses that need to be allowlisted by the
     * customer when using the static-IP connectivity method.
     * </pre>
     */
    default void fetchStaticIps(
        com.google.cloud.clouddms.v1.FetchStaticIpsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.FetchStaticIpsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchStaticIpsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataMigrationService.
   *
   * <pre>
   * Database Migration service
   * </pre>
   */
  public abstract static class DataMigrationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataMigrationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataMigrationService.
   *
   * <pre>
   * Database Migration service
   * </pre>
   */
  public static final class DataMigrationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataMigrationServiceStub> {
    private DataMigrationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataMigrationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataMigrationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists migration jobs in a given project and location.
     * </pre>
     */
    public void listMigrationJobs(
        com.google.cloud.clouddms.v1.ListMigrationJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListMigrationJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMigrationJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single migration job.
     * </pre>
     */
    public void getMigrationJob(
        com.google.cloud.clouddms.v1.GetMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MigrationJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new migration job in a given project and location.
     * </pre>
     */
    public void createMigrationJob(
        com.google.cloud.clouddms.v1.CreateMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single migration job.
     * </pre>
     */
    public void updateMigrationJob(
        com.google.cloud.clouddms.v1.UpdateMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single migration job.
     * </pre>
     */
    public void deleteMigrationJob(
        com.google.cloud.clouddms.v1.DeleteMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start an already created migration job.
     * </pre>
     */
    public void startMigrationJob(
        com.google.cloud.clouddms.v1.StartMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a running migration job.
     * </pre>
     */
    public void stopMigrationJob(
        com.google.cloud.clouddms.v1.StopMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume a migration job that is currently stopped and is resumable (was
     * stopped during CDC phase).
     * </pre>
     */
    public void resumeMigrationJob(
        com.google.cloud.clouddms.v1.ResumeMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Promote a migration job, stopping replication to the destination and
     * promoting the destination to be a standalone database.
     * </pre>
     */
    public void promoteMigrationJob(
        com.google.cloud.clouddms.v1.PromoteMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPromoteMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Verify a migration job, making sure the destination can reach the source
     * and that all configuration and prerequisites are met.
     * </pre>
     */
    public void verifyMigrationJob(
        com.google.cloud.clouddms.v1.VerifyMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restart a stopped or failed migration job, resetting the destination
     * instance to its original state and starting the migration process from
     * scratch.
     * </pre>
     */
    public void restartMigrationJob(
        com.google.cloud.clouddms.v1.RestartMigrationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartMigrationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate a SSH configuration script to configure the reverse SSH
     * connectivity.
     * </pre>
     */
    public void generateSshScript(
        com.google.cloud.clouddms.v1.GenerateSshScriptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.SshScript> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateSshScriptMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate a TCP Proxy configuration script to configure a cloud-hosted VM
     * running a TCP Proxy.
     * </pre>
     */
    public void generateTcpProxyScript(
        com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.TcpProxyScript> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateTcpProxyScriptMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of all connection profiles in a given project and
     * location.
     * </pre>
     */
    public void listConnectionProfiles(
        com.google.cloud.clouddms.v1.ListConnectionProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectionProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single connection profile.
     * </pre>
     */
    public void getConnectionProfile(
        com.google.cloud.clouddms.v1.GetConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ConnectionProfile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectionProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connection profile in a given project and location.
     * </pre>
     */
    public void createConnectionProfile(
        com.google.cloud.clouddms.v1.CreateConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectionProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the configuration of a single connection profile.
     * </pre>
     */
    public void updateConnectionProfile(
        com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectionProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Database Migration Service connection profile.
     * A connection profile can only be deleted if it is not in use by any
     * active migration jobs.
     * </pre>
     */
    public void deleteConnectionProfile(
        com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectionProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new private connection in a given project and location.
     * </pre>
     */
    public void createPrivateConnection(
        com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePrivateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single private connection.
     * </pre>
     */
    public void getPrivateConnection(
        com.google.cloud.clouddms.v1.GetPrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.PrivateConnection>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPrivateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of private connections in a given project and location.
     * </pre>
     */
    public void listPrivateConnections(
        com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrivateConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Database Migration Service private connection.
     * </pre>
     */
    public void deletePrivateConnection(
        com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePrivateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversion workspace.
     * </pre>
     */
    public void getConversionWorkspace(
        com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ConversionWorkspace>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists conversion workspaces in a given project and location.
     * </pre>
     */
    public void listConversionWorkspaces(
        com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversionWorkspacesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversion workspace in a given project and location.
     * </pre>
     */
    public void createConversionWorkspace(
        com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single conversion workspace.
     * </pre>
     */
    public void updateConversionWorkspace(
        com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single conversion workspace.
     * </pre>
     */
    public void deleteConversionWorkspace(
        com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new mapping rule for a given conversion workspace.
     * </pre>
     */
    public void createMappingRule(
        com.google.cloud.clouddms.v1.CreateMappingRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MappingRule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMappingRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single mapping rule.
     * </pre>
     */
    public void deleteMappingRule(
        com.google.cloud.clouddms.v1.DeleteMappingRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMappingRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the mapping rules for a specific conversion workspace.
     * </pre>
     */
    public void listMappingRules(
        com.google.cloud.clouddms.v1.ListMappingRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListMappingRulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMappingRulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a mapping rule.
     * </pre>
     */
    public void getMappingRule(
        com.google.cloud.clouddms.v1.GetMappingRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MappingRule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMappingRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports a snapshot of the source database into the
     * conversion workspace.
     * </pre>
     */
    public void seedConversionWorkspace(
        com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSeedConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the mapping rules for a given conversion workspace.
     * Supports various formats of external rules files.
     * </pre>
     */
    public void importMappingRules(
        com.google.cloud.clouddms.v1.ImportMappingRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportMappingRulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a draft tree schema for the destination database.
     * </pre>
     */
    public void convertConversionWorkspace(
        com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConvertConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks all the data in the conversion workspace as committed.
     * </pre>
     */
    public void commitConversionWorkspace(
        com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a conversion workspace to the last committed snapshot.
     * </pre>
     */
    public void rollbackConversionWorkspace(
        com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Applies draft tree onto a specific destination database.
     * </pre>
     */
    public void applyConversionWorkspace(
        com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplyConversionWorkspaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes the database entities tree for a specific conversion workspace
     * and a specific tree type.
     * Database entities are not resources like conversion workspaces or mapping
     * rules, and they can't be created, updated or deleted. Instead, they are
     * simple data objects describing the structure of the client database.
     * </pre>
     */
    public void describeDatabaseEntities(
        com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDescribeDatabaseEntitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches/lists the background jobs for a specific
     * conversion workspace.
     * The background jobs are not resources like conversion workspaces or
     * mapping rules, and they can't be created, updated or deleted.
     * Instead, they are a way to expose the data plane jobs log.
     * </pre>
     */
    public void searchBackgroundJobs(
        com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchBackgroundJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of committed revisions of a specific conversion
     * workspace.
     * </pre>
     */
    public void describeConversionWorkspaceRevisions(
        com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDescribeConversionWorkspaceRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a set of static IP addresses that need to be allowlisted by the
     * customer when using the static-IP connectivity method.
     * </pre>
     */
    public void fetchStaticIps(
        com.google.cloud.clouddms.v1.FetchStaticIpsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.FetchStaticIpsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchStaticIpsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataMigrationService.
   *
   * <pre>
   * Database Migration service
   * </pre>
   */
  public static final class DataMigrationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataMigrationServiceBlockingStub> {
    private DataMigrationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataMigrationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataMigrationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists migration jobs in a given project and location.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.ListMigrationJobsResponse listMigrationJobs(
        com.google.cloud.clouddms.v1.ListMigrationJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMigrationJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single migration job.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.MigrationJob getMigrationJob(
        com.google.cloud.clouddms.v1.GetMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new migration job in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createMigrationJob(
        com.google.cloud.clouddms.v1.CreateMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single migration job.
     * </pre>
     */
    public com.google.longrunning.Operation updateMigrationJob(
        com.google.cloud.clouddms.v1.UpdateMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single migration job.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMigrationJob(
        com.google.cloud.clouddms.v1.DeleteMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Start an already created migration job.
     * </pre>
     */
    public com.google.longrunning.Operation startMigrationJob(
        com.google.cloud.clouddms.v1.StartMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a running migration job.
     * </pre>
     */
    public com.google.longrunning.Operation stopMigrationJob(
        com.google.cloud.clouddms.v1.StopMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a migration job that is currently stopped and is resumable (was
     * stopped during CDC phase).
     * </pre>
     */
    public com.google.longrunning.Operation resumeMigrationJob(
        com.google.cloud.clouddms.v1.ResumeMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Promote a migration job, stopping replication to the destination and
     * promoting the destination to be a standalone database.
     * </pre>
     */
    public com.google.longrunning.Operation promoteMigrationJob(
        com.google.cloud.clouddms.v1.PromoteMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPromoteMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Verify a migration job, making sure the destination can reach the source
     * and that all configuration and prerequisites are met.
     * </pre>
     */
    public com.google.longrunning.Operation verifyMigrationJob(
        com.google.cloud.clouddms.v1.VerifyMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restart a stopped or failed migration job, resetting the destination
     * instance to its original state and starting the migration process from
     * scratch.
     * </pre>
     */
    public com.google.longrunning.Operation restartMigrationJob(
        com.google.cloud.clouddms.v1.RestartMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartMigrationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a SSH configuration script to configure the reverse SSH
     * connectivity.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.SshScript generateSshScript(
        com.google.cloud.clouddms.v1.GenerateSshScriptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateSshScriptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a TCP Proxy configuration script to configure a cloud-hosted VM
     * running a TCP Proxy.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.TcpProxyScript generateTcpProxyScript(
        com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateTcpProxyScriptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of all connection profiles in a given project and
     * location.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.ListConnectionProfilesResponse listConnectionProfiles(
        com.google.cloud.clouddms.v1.ListConnectionProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectionProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single connection profile.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.ConnectionProfile getConnectionProfile(
        com.google.cloud.clouddms.v1.GetConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connection profile in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createConnectionProfile(
        com.google.cloud.clouddms.v1.CreateConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the configuration of a single connection profile.
     * </pre>
     */
    public com.google.longrunning.Operation updateConnectionProfile(
        com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Database Migration Service connection profile.
     * A connection profile can only be deleted if it is not in use by any
     * active migration jobs.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConnectionProfile(
        com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new private connection in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createPrivateConnection(
        com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single private connection.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.PrivateConnection getPrivateConnection(
        com.google.cloud.clouddms.v1.GetPrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of private connections in a given project and location.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse listPrivateConnections(
        com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrivateConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Database Migration Service private connection.
     * </pre>
     */
    public com.google.longrunning.Operation deletePrivateConnection(
        com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversion workspace.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.ConversionWorkspace getConversionWorkspace(
        com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists conversion workspaces in a given project and location.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse listConversionWorkspaces(
        com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversionWorkspacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversion workspace in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createConversionWorkspace(
        com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single conversion workspace.
     * </pre>
     */
    public com.google.longrunning.Operation updateConversionWorkspace(
        com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single conversion workspace.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConversionWorkspace(
        com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new mapping rule for a given conversion workspace.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.MappingRule createMappingRule(
        com.google.cloud.clouddms.v1.CreateMappingRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMappingRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single mapping rule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMappingRule(
        com.google.cloud.clouddms.v1.DeleteMappingRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMappingRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the mapping rules for a specific conversion workspace.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.ListMappingRulesResponse listMappingRules(
        com.google.cloud.clouddms.v1.ListMappingRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMappingRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a mapping rule.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.MappingRule getMappingRule(
        com.google.cloud.clouddms.v1.GetMappingRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMappingRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports a snapshot of the source database into the
     * conversion workspace.
     * </pre>
     */
    public com.google.longrunning.Operation seedConversionWorkspace(
        com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSeedConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the mapping rules for a given conversion workspace.
     * Supports various formats of external rules files.
     * </pre>
     */
    public com.google.longrunning.Operation importMappingRules(
        com.google.cloud.clouddms.v1.ImportMappingRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportMappingRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a draft tree schema for the destination database.
     * </pre>
     */
    public com.google.longrunning.Operation convertConversionWorkspace(
        com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConvertConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks all the data in the conversion workspace as committed.
     * </pre>
     */
    public com.google.longrunning.Operation commitConversionWorkspace(
        com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a conversion workspace to the last committed snapshot.
     * </pre>
     */
    public com.google.longrunning.Operation rollbackConversionWorkspace(
        com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Applies draft tree onto a specific destination database.
     * </pre>
     */
    public com.google.longrunning.Operation applyConversionWorkspace(
        com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyConversionWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Describes the database entities tree for a specific conversion workspace
     * and a specific tree type.
     * Database entities are not resources like conversion workspaces or mapping
     * rules, and they can't be created, updated or deleted. Instead, they are
     * simple data objects describing the structure of the client database.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse describeDatabaseEntities(
        com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDescribeDatabaseEntitiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches/lists the background jobs for a specific
     * conversion workspace.
     * The background jobs are not resources like conversion workspaces or
     * mapping rules, and they can't be created, updated or deleted.
     * Instead, they are a way to expose the data plane jobs log.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse searchBackgroundJobs(
        com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchBackgroundJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of committed revisions of a specific conversion
     * workspace.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse
        describeConversionWorkspaceRevisions(
            com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDescribeConversionWorkspaceRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a set of static IP addresses that need to be allowlisted by the
     * customer when using the static-IP connectivity method.
     * </pre>
     */
    public com.google.cloud.clouddms.v1.FetchStaticIpsResponse fetchStaticIps(
        com.google.cloud.clouddms.v1.FetchStaticIpsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchStaticIpsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataMigrationService.
   *
   * <pre>
   * Database Migration service
   * </pre>
   */
  public static final class DataMigrationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataMigrationServiceFutureStub> {
    private DataMigrationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataMigrationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataMigrationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists migration jobs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.ListMigrationJobsResponse>
        listMigrationJobs(com.google.cloud.clouddms.v1.ListMigrationJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMigrationJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single migration job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.MigrationJob>
        getMigrationJob(com.google.cloud.clouddms.v1.GetMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new migration job in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMigrationJob(com.google.cloud.clouddms.v1.CreateMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single migration job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMigrationJob(com.google.cloud.clouddms.v1.UpdateMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single migration job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMigrationJob(com.google.cloud.clouddms.v1.DeleteMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Start an already created migration job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startMigrationJob(com.google.cloud.clouddms.v1.StartMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a running migration job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        stopMigrationJob(com.google.cloud.clouddms.v1.StopMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a migration job that is currently stopped and is resumable (was
     * stopped during CDC phase).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resumeMigrationJob(com.google.cloud.clouddms.v1.ResumeMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Promote a migration job, stopping replication to the destination and
     * promoting the destination to be a standalone database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        promoteMigrationJob(com.google.cloud.clouddms.v1.PromoteMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPromoteMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Verify a migration job, making sure the destination can reach the source
     * and that all configuration and prerequisites are met.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        verifyMigrationJob(com.google.cloud.clouddms.v1.VerifyMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restart a stopped or failed migration job, resetting the destination
     * instance to its original state and starting the migration process from
     * scratch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restartMigrationJob(com.google.cloud.clouddms.v1.RestartMigrationJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartMigrationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a SSH configuration script to configure the reverse SSH
     * connectivity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.SshScript>
        generateSshScript(com.google.cloud.clouddms.v1.GenerateSshScriptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateSshScriptMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a TCP Proxy configuration script to configure a cloud-hosted VM
     * running a TCP Proxy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.TcpProxyScript>
        generateTcpProxyScript(com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateTcpProxyScriptMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of all connection profiles in a given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>
        listConnectionProfiles(com.google.cloud.clouddms.v1.ListConnectionProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectionProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single connection profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.ConnectionProfile>
        getConnectionProfile(com.google.cloud.clouddms.v1.GetConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connection profile in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createConnectionProfile(
            com.google.cloud.clouddms.v1.CreateConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the configuration of a single connection profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateConnectionProfile(
            com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Database Migration Service connection profile.
     * A connection profile can only be deleted if it is not in use by any
     * active migration jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteConnectionProfile(
            com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new private connection in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPrivateConnection(
            com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single private connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.PrivateConnection>
        getPrivateConnection(com.google.cloud.clouddms.v1.GetPrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of private connections in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>
        listPrivateConnections(com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrivateConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Database Migration Service private connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePrivateConnection(
            com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single conversion workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.ConversionWorkspace>
        getConversionWorkspace(com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists conversion workspaces in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>
        listConversionWorkspaces(
            com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversionWorkspacesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversion workspace in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createConversionWorkspace(
            com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single conversion workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateConversionWorkspace(
            com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single conversion workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteConversionWorkspace(
            com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new mapping rule for a given conversion workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.MappingRule>
        createMappingRule(com.google.cloud.clouddms.v1.CreateMappingRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMappingRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single mapping rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMappingRule(com.google.cloud.clouddms.v1.DeleteMappingRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMappingRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the mapping rules for a specific conversion workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.ListMappingRulesResponse>
        listMappingRules(com.google.cloud.clouddms.v1.ListMappingRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMappingRulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a mapping rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.MappingRule>
        getMappingRule(com.google.cloud.clouddms.v1.GetMappingRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMappingRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports a snapshot of the source database into the
     * conversion workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        seedConversionWorkspace(
            com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSeedConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the mapping rules for a given conversion workspace.
     * Supports various formats of external rules files.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importMappingRules(com.google.cloud.clouddms.v1.ImportMappingRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportMappingRulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a draft tree schema for the destination database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        convertConversionWorkspace(
            com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConvertConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks all the data in the conversion workspace as committed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        commitConversionWorkspace(
            com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back a conversion workspace to the last committed snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        rollbackConversionWorkspace(
            com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Applies draft tree onto a specific destination database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        applyConversionWorkspace(
            com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplyConversionWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Describes the database entities tree for a specific conversion workspace
     * and a specific tree type.
     * Database entities are not resources like conversion workspaces or mapping
     * rules, and they can't be created, updated or deleted. Instead, they are
     * simple data objects describing the structure of the client database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>
        describeDatabaseEntities(
            com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDescribeDatabaseEntitiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches/lists the background jobs for a specific
     * conversion workspace.
     * The background jobs are not resources like conversion workspaces or
     * mapping rules, and they can't be created, updated or deleted.
     * Instead, they are a way to expose the data plane jobs log.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>
        searchBackgroundJobs(com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchBackgroundJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of committed revisions of a specific conversion
     * workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>
        describeConversionWorkspaceRevisions(
            com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDescribeConversionWorkspaceRevisionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a set of static IP addresses that need to be allowlisted by the
     * customer when using the static-IP connectivity method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.clouddms.v1.FetchStaticIpsResponse>
        fetchStaticIps(com.google.cloud.clouddms.v1.FetchStaticIpsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchStaticIpsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_MIGRATION_JOBS = 0;
  private static final int METHODID_GET_MIGRATION_JOB = 1;
  private static final int METHODID_CREATE_MIGRATION_JOB = 2;
  private static final int METHODID_UPDATE_MIGRATION_JOB = 3;
  private static final int METHODID_DELETE_MIGRATION_JOB = 4;
  private static final int METHODID_START_MIGRATION_JOB = 5;
  private static final int METHODID_STOP_MIGRATION_JOB = 6;
  private static final int METHODID_RESUME_MIGRATION_JOB = 7;
  private static final int METHODID_PROMOTE_MIGRATION_JOB = 8;
  private static final int METHODID_VERIFY_MIGRATION_JOB = 9;
  private static final int METHODID_RESTART_MIGRATION_JOB = 10;
  private static final int METHODID_GENERATE_SSH_SCRIPT = 11;
  private static final int METHODID_GENERATE_TCP_PROXY_SCRIPT = 12;
  private static final int METHODID_LIST_CONNECTION_PROFILES = 13;
  private static final int METHODID_GET_CONNECTION_PROFILE = 14;
  private static final int METHODID_CREATE_CONNECTION_PROFILE = 15;
  private static final int METHODID_UPDATE_CONNECTION_PROFILE = 16;
  private static final int METHODID_DELETE_CONNECTION_PROFILE = 17;
  private static final int METHODID_CREATE_PRIVATE_CONNECTION = 18;
  private static final int METHODID_GET_PRIVATE_CONNECTION = 19;
  private static final int METHODID_LIST_PRIVATE_CONNECTIONS = 20;
  private static final int METHODID_DELETE_PRIVATE_CONNECTION = 21;
  private static final int METHODID_GET_CONVERSION_WORKSPACE = 22;
  private static final int METHODID_LIST_CONVERSION_WORKSPACES = 23;
  private static final int METHODID_CREATE_CONVERSION_WORKSPACE = 24;
  private static final int METHODID_UPDATE_CONVERSION_WORKSPACE = 25;
  private static final int METHODID_DELETE_CONVERSION_WORKSPACE = 26;
  private static final int METHODID_CREATE_MAPPING_RULE = 27;
  private static final int METHODID_DELETE_MAPPING_RULE = 28;
  private static final int METHODID_LIST_MAPPING_RULES = 29;
  private static final int METHODID_GET_MAPPING_RULE = 30;
  private static final int METHODID_SEED_CONVERSION_WORKSPACE = 31;
  private static final int METHODID_IMPORT_MAPPING_RULES = 32;
  private static final int METHODID_CONVERT_CONVERSION_WORKSPACE = 33;
  private static final int METHODID_COMMIT_CONVERSION_WORKSPACE = 34;
  private static final int METHODID_ROLLBACK_CONVERSION_WORKSPACE = 35;
  private static final int METHODID_APPLY_CONVERSION_WORKSPACE = 36;
  private static final int METHODID_DESCRIBE_DATABASE_ENTITIES = 37;
  private static final int METHODID_SEARCH_BACKGROUND_JOBS = 38;
  private static final int METHODID_DESCRIBE_CONVERSION_WORKSPACE_REVISIONS = 39;
  private static final int METHODID_FETCH_STATIC_IPS = 40;

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
        case METHODID_LIST_MIGRATION_JOBS:
          serviceImpl.listMigrationJobs(
              (com.google.cloud.clouddms.v1.ListMigrationJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListMigrationJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MIGRATION_JOB:
          serviceImpl.getMigrationJob(
              (com.google.cloud.clouddms.v1.GetMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MigrationJob>)
                  responseObserver);
          break;
        case METHODID_CREATE_MIGRATION_JOB:
          serviceImpl.createMigrationJob(
              (com.google.cloud.clouddms.v1.CreateMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MIGRATION_JOB:
          serviceImpl.updateMigrationJob(
              (com.google.cloud.clouddms.v1.UpdateMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MIGRATION_JOB:
          serviceImpl.deleteMigrationJob(
              (com.google.cloud.clouddms.v1.DeleteMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_MIGRATION_JOB:
          serviceImpl.startMigrationJob(
              (com.google.cloud.clouddms.v1.StartMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_MIGRATION_JOB:
          serviceImpl.stopMigrationJob(
              (com.google.cloud.clouddms.v1.StopMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESUME_MIGRATION_JOB:
          serviceImpl.resumeMigrationJob(
              (com.google.cloud.clouddms.v1.ResumeMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PROMOTE_MIGRATION_JOB:
          serviceImpl.promoteMigrationJob(
              (com.google.cloud.clouddms.v1.PromoteMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_VERIFY_MIGRATION_JOB:
          serviceImpl.verifyMigrationJob(
              (com.google.cloud.clouddms.v1.VerifyMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTART_MIGRATION_JOB:
          serviceImpl.restartMigrationJob(
              (com.google.cloud.clouddms.v1.RestartMigrationJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_SSH_SCRIPT:
          serviceImpl.generateSshScript(
              (com.google.cloud.clouddms.v1.GenerateSshScriptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.SshScript>)
                  responseObserver);
          break;
        case METHODID_GENERATE_TCP_PROXY_SCRIPT:
          serviceImpl.generateTcpProxyScript(
              (com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.TcpProxyScript>)
                  responseObserver);
          break;
        case METHODID_LIST_CONNECTION_PROFILES:
          serviceImpl.listConnectionProfiles(
              (com.google.cloud.clouddms.v1.ListConnectionProfilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONNECTION_PROFILE:
          serviceImpl.getConnectionProfile(
              (com.google.cloud.clouddms.v1.GetConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ConnectionProfile>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONNECTION_PROFILE:
          serviceImpl.createConnectionProfile(
              (com.google.cloud.clouddms.v1.CreateConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONNECTION_PROFILE:
          serviceImpl.updateConnectionProfile(
              (com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONNECTION_PROFILE:
          serviceImpl.deleteConnectionProfile(
              (com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_PRIVATE_CONNECTION:
          serviceImpl.createPrivateConnection(
              (com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PRIVATE_CONNECTION:
          serviceImpl.getPrivateConnection(
              (com.google.cloud.clouddms.v1.GetPrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.PrivateConnection>)
                  responseObserver);
          break;
        case METHODID_LIST_PRIVATE_CONNECTIONS:
          serviceImpl.listPrivateConnections(
              (com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_PRIVATE_CONNECTION:
          serviceImpl.deletePrivateConnection(
              (com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CONVERSION_WORKSPACE:
          serviceImpl.getConversionWorkspace(
              (com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ConversionWorkspace>)
                  responseObserver);
          break;
        case METHODID_LIST_CONVERSION_WORKSPACES:
          serviceImpl.listConversionWorkspaces(
              (com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONVERSION_WORKSPACE:
          serviceImpl.createConversionWorkspace(
              (com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONVERSION_WORKSPACE:
          serviceImpl.updateConversionWorkspace(
              (com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONVERSION_WORKSPACE:
          serviceImpl.deleteConversionWorkspace(
              (com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_MAPPING_RULE:
          serviceImpl.createMappingRule(
              (com.google.cloud.clouddms.v1.CreateMappingRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MappingRule>)
                  responseObserver);
          break;
        case METHODID_DELETE_MAPPING_RULE:
          serviceImpl.deleteMappingRule(
              (com.google.cloud.clouddms.v1.DeleteMappingRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_MAPPING_RULES:
          serviceImpl.listMappingRules(
              (com.google.cloud.clouddms.v1.ListMappingRulesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.ListMappingRulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MAPPING_RULE:
          serviceImpl.getMappingRule(
              (com.google.cloud.clouddms.v1.GetMappingRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.MappingRule>)
                  responseObserver);
          break;
        case METHODID_SEED_CONVERSION_WORKSPACE:
          serviceImpl.seedConversionWorkspace(
              (com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_MAPPING_RULES:
          serviceImpl.importMappingRules(
              (com.google.cloud.clouddms.v1.ImportMappingRulesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CONVERT_CONVERSION_WORKSPACE:
          serviceImpl.convertConversionWorkspace(
              (com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_COMMIT_CONVERSION_WORKSPACE:
          serviceImpl.commitConversionWorkspace(
              (com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ROLLBACK_CONVERSION_WORKSPACE:
          serviceImpl.rollbackConversionWorkspace(
              (com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_APPLY_CONVERSION_WORKSPACE:
          serviceImpl.applyConversionWorkspace(
              (com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DESCRIBE_DATABASE_ENTITIES:
          serviceImpl.describeDatabaseEntities(
              (com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_BACKGROUND_JOBS:
          serviceImpl.searchBackgroundJobs(
              (com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>)
                  responseObserver);
          break;
        case METHODID_DESCRIBE_CONVERSION_WORKSPACE_REVISIONS:
          serviceImpl.describeConversionWorkspaceRevisions(
              (com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_STATIC_IPS:
          serviceImpl.fetchStaticIps(
              (com.google.cloud.clouddms.v1.FetchStaticIpsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.FetchStaticIpsResponse>)
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
            getListMigrationJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ListMigrationJobsRequest,
                    com.google.cloud.clouddms.v1.ListMigrationJobsResponse>(
                    service, METHODID_LIST_MIGRATION_JOBS)))
        .addMethod(
            getGetMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.GetMigrationJobRequest,
                    com.google.cloud.clouddms.v1.MigrationJob>(
                    service, METHODID_GET_MIGRATION_JOB)))
        .addMethod(
            getCreateMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.CreateMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MIGRATION_JOB)))
        .addMethod(
            getUpdateMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.UpdateMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MIGRATION_JOB)))
        .addMethod(
            getDeleteMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.DeleteMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MIGRATION_JOB)))
        .addMethod(
            getStartMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.StartMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_MIGRATION_JOB)))
        .addMethod(
            getStopMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.StopMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_STOP_MIGRATION_JOB)))
        .addMethod(
            getResumeMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ResumeMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESUME_MIGRATION_JOB)))
        .addMethod(
            getPromoteMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.PromoteMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_PROMOTE_MIGRATION_JOB)))
        .addMethod(
            getVerifyMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.VerifyMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_VERIFY_MIGRATION_JOB)))
        .addMethod(
            getRestartMigrationJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.RestartMigrationJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTART_MIGRATION_JOB)))
        .addMethod(
            getGenerateSshScriptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.GenerateSshScriptRequest,
                    com.google.cloud.clouddms.v1.SshScript>(service, METHODID_GENERATE_SSH_SCRIPT)))
        .addMethod(
            getGenerateTcpProxyScriptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.GenerateTcpProxyScriptRequest,
                    com.google.cloud.clouddms.v1.TcpProxyScript>(
                    service, METHODID_GENERATE_TCP_PROXY_SCRIPT)))
        .addMethod(
            getListConnectionProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ListConnectionProfilesRequest,
                    com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>(
                    service, METHODID_LIST_CONNECTION_PROFILES)))
        .addMethod(
            getGetConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.GetConnectionProfileRequest,
                    com.google.cloud.clouddms.v1.ConnectionProfile>(
                    service, METHODID_GET_CONNECTION_PROFILE)))
        .addMethod(
            getCreateConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.CreateConnectionProfileRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CONNECTION_PROFILE)))
        .addMethod(
            getUpdateConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CONNECTION_PROFILE)))
        .addMethod(
            getDeleteConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CONNECTION_PROFILE)))
        .addMethod(
            getCreatePrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.CreatePrivateConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PRIVATE_CONNECTION)))
        .addMethod(
            getGetPrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.GetPrivateConnectionRequest,
                    com.google.cloud.clouddms.v1.PrivateConnection>(
                    service, METHODID_GET_PRIVATE_CONNECTION)))
        .addMethod(
            getListPrivateConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ListPrivateConnectionsRequest,
                    com.google.cloud.clouddms.v1.ListPrivateConnectionsResponse>(
                    service, METHODID_LIST_PRIVATE_CONNECTIONS)))
        .addMethod(
            getDeletePrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.DeletePrivateConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PRIVATE_CONNECTION)))
        .addMethod(
            getGetConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.GetConversionWorkspaceRequest,
                    com.google.cloud.clouddms.v1.ConversionWorkspace>(
                    service, METHODID_GET_CONVERSION_WORKSPACE)))
        .addMethod(
            getListConversionWorkspacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ListConversionWorkspacesRequest,
                    com.google.cloud.clouddms.v1.ListConversionWorkspacesResponse>(
                    service, METHODID_LIST_CONVERSION_WORKSPACES)))
        .addMethod(
            getCreateConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.CreateConversionWorkspaceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_CONVERSION_WORKSPACE)))
        .addMethod(
            getUpdateConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.UpdateConversionWorkspaceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_CONVERSION_WORKSPACE)))
        .addMethod(
            getDeleteConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.DeleteConversionWorkspaceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_CONVERSION_WORKSPACE)))
        .addMethod(
            getCreateMappingRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.CreateMappingRuleRequest,
                    com.google.cloud.clouddms.v1.MappingRule>(
                    service, METHODID_CREATE_MAPPING_RULE)))
        .addMethod(
            getDeleteMappingRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.DeleteMappingRuleRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_MAPPING_RULE)))
        .addMethod(
            getListMappingRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ListMappingRulesRequest,
                    com.google.cloud.clouddms.v1.ListMappingRulesResponse>(
                    service, METHODID_LIST_MAPPING_RULES)))
        .addMethod(
            getGetMappingRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.GetMappingRuleRequest,
                    com.google.cloud.clouddms.v1.MappingRule>(service, METHODID_GET_MAPPING_RULE)))
        .addMethod(
            getSeedConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.SeedConversionWorkspaceRequest,
                    com.google.longrunning.Operation>(service, METHODID_SEED_CONVERSION_WORKSPACE)))
        .addMethod(
            getImportMappingRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ImportMappingRulesRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_MAPPING_RULES)))
        .addMethod(
            getConvertConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ConvertConversionWorkspaceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CONVERT_CONVERSION_WORKSPACE)))
        .addMethod(
            getCommitConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.CommitConversionWorkspaceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_COMMIT_CONVERSION_WORKSPACE)))
        .addMethod(
            getRollbackConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.RollbackConversionWorkspaceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_ROLLBACK_CONVERSION_WORKSPACE)))
        .addMethod(
            getApplyConversionWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.ApplyConversionWorkspaceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_APPLY_CONVERSION_WORKSPACE)))
        .addMethod(
            getDescribeDatabaseEntitiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest,
                    com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesResponse>(
                    service, METHODID_DESCRIBE_DATABASE_ENTITIES)))
        .addMethod(
            getSearchBackgroundJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.SearchBackgroundJobsRequest,
                    com.google.cloud.clouddms.v1.SearchBackgroundJobsResponse>(
                    service, METHODID_SEARCH_BACKGROUND_JOBS)))
        .addMethod(
            getDescribeConversionWorkspaceRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest,
                    com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse>(
                    service, METHODID_DESCRIBE_CONVERSION_WORKSPACE_REVISIONS)))
        .addMethod(
            getFetchStaticIpsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.clouddms.v1.FetchStaticIpsRequest,
                    com.google.cloud.clouddms.v1.FetchStaticIpsResponse>(
                    service, METHODID_FETCH_STATIC_IPS)))
        .build();
  }

  private abstract static class DataMigrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataMigrationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.clouddms.v1.ClouddmsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataMigrationService");
    }
  }

  private static final class DataMigrationServiceFileDescriptorSupplier
      extends DataMigrationServiceBaseDescriptorSupplier {
    DataMigrationServiceFileDescriptorSupplier() {}
  }

  private static final class DataMigrationServiceMethodDescriptorSupplier
      extends DataMigrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataMigrationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataMigrationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataMigrationServiceFileDescriptorSupplier())
                      .addMethod(getListMigrationJobsMethod())
                      .addMethod(getGetMigrationJobMethod())
                      .addMethod(getCreateMigrationJobMethod())
                      .addMethod(getUpdateMigrationJobMethod())
                      .addMethod(getDeleteMigrationJobMethod())
                      .addMethod(getStartMigrationJobMethod())
                      .addMethod(getStopMigrationJobMethod())
                      .addMethod(getResumeMigrationJobMethod())
                      .addMethod(getPromoteMigrationJobMethod())
                      .addMethod(getVerifyMigrationJobMethod())
                      .addMethod(getRestartMigrationJobMethod())
                      .addMethod(getGenerateSshScriptMethod())
                      .addMethod(getGenerateTcpProxyScriptMethod())
                      .addMethod(getListConnectionProfilesMethod())
                      .addMethod(getGetConnectionProfileMethod())
                      .addMethod(getCreateConnectionProfileMethod())
                      .addMethod(getUpdateConnectionProfileMethod())
                      .addMethod(getDeleteConnectionProfileMethod())
                      .addMethod(getCreatePrivateConnectionMethod())
                      .addMethod(getGetPrivateConnectionMethod())
                      .addMethod(getListPrivateConnectionsMethod())
                      .addMethod(getDeletePrivateConnectionMethod())
                      .addMethod(getGetConversionWorkspaceMethod())
                      .addMethod(getListConversionWorkspacesMethod())
                      .addMethod(getCreateConversionWorkspaceMethod())
                      .addMethod(getUpdateConversionWorkspaceMethod())
                      .addMethod(getDeleteConversionWorkspaceMethod())
                      .addMethod(getCreateMappingRuleMethod())
                      .addMethod(getDeleteMappingRuleMethod())
                      .addMethod(getListMappingRulesMethod())
                      .addMethod(getGetMappingRuleMethod())
                      .addMethod(getSeedConversionWorkspaceMethod())
                      .addMethod(getImportMappingRulesMethod())
                      .addMethod(getConvertConversionWorkspaceMethod())
                      .addMethod(getCommitConversionWorkspaceMethod())
                      .addMethod(getRollbackConversionWorkspaceMethod())
                      .addMethod(getApplyConversionWorkspaceMethod())
                      .addMethod(getDescribeDatabaseEntitiesMethod())
                      .addMethod(getSearchBackgroundJobsMethod())
                      .addMethod(getDescribeConversionWorkspaceRevisionsMethod())
                      .addMethod(getFetchStaticIpsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
