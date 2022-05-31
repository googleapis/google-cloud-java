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

  public static final String SERVICE_NAME = "google.cloud.clouddms.v1.DataMigrationService";

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
  public abstract static class DataMigrationServiceImplBase implements io.grpc.BindableService {

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
    public void getMigrationJob(
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
    public void createMigrationJob(
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
    public void updateMigrationJob(
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
    public void deleteMigrationJob(
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
    public void startMigrationJob(
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
    public void stopMigrationJob(
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
    public void resumeMigrationJob(
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
    public void promoteMigrationJob(
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
    public void verifyMigrationJob(
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
    public void restartMigrationJob(
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
    public void generateSshScript(
        com.google.cloud.clouddms.v1.GenerateSshScriptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.clouddms.v1.SshScript> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateSshScriptMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a list of all connection profiles in a given project and location.
     * </pre>
     */
    public void listConnectionProfiles(
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
    public void getConnectionProfile(
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
    public void createConnectionProfile(
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
    public void updateConnectionProfile(
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
    public void deleteConnectionProfile(
        com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConnectionProfileMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListMigrationJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.ListMigrationJobsRequest,
                      com.google.cloud.clouddms.v1.ListMigrationJobsResponse>(
                      this, METHODID_LIST_MIGRATION_JOBS)))
          .addMethod(
              getGetMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.GetMigrationJobRequest,
                      com.google.cloud.clouddms.v1.MigrationJob>(this, METHODID_GET_MIGRATION_JOB)))
          .addMethod(
              getCreateMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.CreateMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_MIGRATION_JOB)))
          .addMethod(
              getUpdateMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.UpdateMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_MIGRATION_JOB)))
          .addMethod(
              getDeleteMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.DeleteMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_MIGRATION_JOB)))
          .addMethod(
              getStartMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.StartMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_START_MIGRATION_JOB)))
          .addMethod(
              getStopMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.StopMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_STOP_MIGRATION_JOB)))
          .addMethod(
              getResumeMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.ResumeMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESUME_MIGRATION_JOB)))
          .addMethod(
              getPromoteMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.PromoteMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_PROMOTE_MIGRATION_JOB)))
          .addMethod(
              getVerifyMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.VerifyMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_VERIFY_MIGRATION_JOB)))
          .addMethod(
              getRestartMigrationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.RestartMigrationJobRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESTART_MIGRATION_JOB)))
          .addMethod(
              getGenerateSshScriptMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.GenerateSshScriptRequest,
                      com.google.cloud.clouddms.v1.SshScript>(this, METHODID_GENERATE_SSH_SCRIPT)))
          .addMethod(
              getListConnectionProfilesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.ListConnectionProfilesRequest,
                      com.google.cloud.clouddms.v1.ListConnectionProfilesResponse>(
                      this, METHODID_LIST_CONNECTION_PROFILES)))
          .addMethod(
              getGetConnectionProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.GetConnectionProfileRequest,
                      com.google.cloud.clouddms.v1.ConnectionProfile>(
                      this, METHODID_GET_CONNECTION_PROFILE)))
          .addMethod(
              getCreateConnectionProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.CreateConnectionProfileRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_CONNECTION_PROFILE)))
          .addMethod(
              getUpdateConnectionProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_CONNECTION_PROFILE)))
          .addMethod(
              getDeleteConnectionProfileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_CONNECTION_PROFILE)))
          .build();
    }
  }

  /**
   *
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
     * Retrieve a list of all connection profiles in a given project and location.
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
  }

  /**
   *
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
     * Retrieve a list of all connection profiles in a given project and location.
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
  }

  /**
   *
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
     * Retrieve a list of all connection profiles in a given project and location.
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
  private static final int METHODID_LIST_CONNECTION_PROFILES = 12;
  private static final int METHODID_GET_CONNECTION_PROFILE = 13;
  private static final int METHODID_CREATE_CONNECTION_PROFILE = 14;
  private static final int METHODID_UPDATE_CONNECTION_PROFILE = 15;
  private static final int METHODID_DELETE_CONNECTION_PROFILE = 16;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataMigrationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataMigrationServiceImplBase serviceImpl, int methodId) {
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
    private final String methodName;

    DataMigrationServiceMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getListConnectionProfilesMethod())
                      .addMethod(getGetConnectionProfileMethod())
                      .addMethod(getCreateConnectionProfileMethod())
                      .addMethod(getUpdateConnectionProfileMethod())
                      .addMethod(getDeleteConnectionProfileMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
