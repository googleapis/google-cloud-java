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
package com.google.cloud.kms.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Google Cloud HSM Management Service
 * Provides interfaces for managing HSM instances.
 * Implements a REST model with the following objects:
 * * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]
 * * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class HsmManagementGrpc {

  private HsmManagementGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.kms.v1.HsmManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest,
          com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>
      getListSingleTenantHsmInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSingleTenantHsmInstances",
      requestType = com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest.class,
      responseType = com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest,
          com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>
      getListSingleTenantHsmInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest,
            com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>
        getListSingleTenantHsmInstancesMethod;
    if ((getListSingleTenantHsmInstancesMethod =
            HsmManagementGrpc.getListSingleTenantHsmInstancesMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getListSingleTenantHsmInstancesMethod =
                HsmManagementGrpc.getListSingleTenantHsmInstancesMethod)
            == null) {
          HsmManagementGrpc.getListSingleTenantHsmInstancesMethod =
              getListSingleTenantHsmInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest,
                          com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSingleTenantHsmInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier("ListSingleTenantHsmInstances"))
                      .build();
        }
      }
    }
    return getListSingleTenantHsmInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest,
          com.google.cloud.kms.v1.SingleTenantHsmInstance>
      getGetSingleTenantHsmInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSingleTenantHsmInstance",
      requestType = com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest.class,
      responseType = com.google.cloud.kms.v1.SingleTenantHsmInstance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest,
          com.google.cloud.kms.v1.SingleTenantHsmInstance>
      getGetSingleTenantHsmInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest,
            com.google.cloud.kms.v1.SingleTenantHsmInstance>
        getGetSingleTenantHsmInstanceMethod;
    if ((getGetSingleTenantHsmInstanceMethod =
            HsmManagementGrpc.getGetSingleTenantHsmInstanceMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getGetSingleTenantHsmInstanceMethod =
                HsmManagementGrpc.getGetSingleTenantHsmInstanceMethod)
            == null) {
          HsmManagementGrpc.getGetSingleTenantHsmInstanceMethod =
              getGetSingleTenantHsmInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest,
                          com.google.cloud.kms.v1.SingleTenantHsmInstance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSingleTenantHsmInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.SingleTenantHsmInstance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier("GetSingleTenantHsmInstance"))
                      .build();
        }
      }
    }
    return getGetSingleTenantHsmInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest,
          com.google.longrunning.Operation>
      getCreateSingleTenantHsmInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSingleTenantHsmInstance",
      requestType = com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest,
          com.google.longrunning.Operation>
      getCreateSingleTenantHsmInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest,
            com.google.longrunning.Operation>
        getCreateSingleTenantHsmInstanceMethod;
    if ((getCreateSingleTenantHsmInstanceMethod =
            HsmManagementGrpc.getCreateSingleTenantHsmInstanceMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getCreateSingleTenantHsmInstanceMethod =
                HsmManagementGrpc.getCreateSingleTenantHsmInstanceMethod)
            == null) {
          HsmManagementGrpc.getCreateSingleTenantHsmInstanceMethod =
              getCreateSingleTenantHsmInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSingleTenantHsmInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier(
                              "CreateSingleTenantHsmInstance"))
                      .build();
        }
      }
    }
    return getCreateSingleTenantHsmInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest,
          com.google.longrunning.Operation>
      getCreateSingleTenantHsmInstanceProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSingleTenantHsmInstanceProposal",
      requestType = com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest,
          com.google.longrunning.Operation>
      getCreateSingleTenantHsmInstanceProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest,
            com.google.longrunning.Operation>
        getCreateSingleTenantHsmInstanceProposalMethod;
    if ((getCreateSingleTenantHsmInstanceProposalMethod =
            HsmManagementGrpc.getCreateSingleTenantHsmInstanceProposalMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getCreateSingleTenantHsmInstanceProposalMethod =
                HsmManagementGrpc.getCreateSingleTenantHsmInstanceProposalMethod)
            == null) {
          HsmManagementGrpc.getCreateSingleTenantHsmInstanceProposalMethod =
              getCreateSingleTenantHsmInstanceProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateSingleTenantHsmInstanceProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier(
                              "CreateSingleTenantHsmInstanceProposal"))
                      .build();
        }
      }
    }
    return getCreateSingleTenantHsmInstanceProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest,
          com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>
      getApproveSingleTenantHsmInstanceProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApproveSingleTenantHsmInstanceProposal",
      requestType = com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest.class,
      responseType = com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest,
          com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>
      getApproveSingleTenantHsmInstanceProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest,
            com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>
        getApproveSingleTenantHsmInstanceProposalMethod;
    if ((getApproveSingleTenantHsmInstanceProposalMethod =
            HsmManagementGrpc.getApproveSingleTenantHsmInstanceProposalMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getApproveSingleTenantHsmInstanceProposalMethod =
                HsmManagementGrpc.getApproveSingleTenantHsmInstanceProposalMethod)
            == null) {
          HsmManagementGrpc.getApproveSingleTenantHsmInstanceProposalMethod =
              getApproveSingleTenantHsmInstanceProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest,
                          com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ApproveSingleTenantHsmInstanceProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier(
                              "ApproveSingleTenantHsmInstanceProposal"))
                      .build();
        }
      }
    }
    return getApproveSingleTenantHsmInstanceProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest,
          com.google.longrunning.Operation>
      getExecuteSingleTenantHsmInstanceProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteSingleTenantHsmInstanceProposal",
      requestType = com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest,
          com.google.longrunning.Operation>
      getExecuteSingleTenantHsmInstanceProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest,
            com.google.longrunning.Operation>
        getExecuteSingleTenantHsmInstanceProposalMethod;
    if ((getExecuteSingleTenantHsmInstanceProposalMethod =
            HsmManagementGrpc.getExecuteSingleTenantHsmInstanceProposalMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getExecuteSingleTenantHsmInstanceProposalMethod =
                HsmManagementGrpc.getExecuteSingleTenantHsmInstanceProposalMethod)
            == null) {
          HsmManagementGrpc.getExecuteSingleTenantHsmInstanceProposalMethod =
              getExecuteSingleTenantHsmInstanceProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ExecuteSingleTenantHsmInstanceProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier(
                              "ExecuteSingleTenantHsmInstanceProposal"))
                      .build();
        }
      }
    }
    return getExecuteSingleTenantHsmInstanceProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest,
          com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>
      getGetSingleTenantHsmInstanceProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSingleTenantHsmInstanceProposal",
      requestType = com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest.class,
      responseType = com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest,
          com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>
      getGetSingleTenantHsmInstanceProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest,
            com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>
        getGetSingleTenantHsmInstanceProposalMethod;
    if ((getGetSingleTenantHsmInstanceProposalMethod =
            HsmManagementGrpc.getGetSingleTenantHsmInstanceProposalMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getGetSingleTenantHsmInstanceProposalMethod =
                HsmManagementGrpc.getGetSingleTenantHsmInstanceProposalMethod)
            == null) {
          HsmManagementGrpc.getGetSingleTenantHsmInstanceProposalMethod =
              getGetSingleTenantHsmInstanceProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest,
                          com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetSingleTenantHsmInstanceProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier(
                              "GetSingleTenantHsmInstanceProposal"))
                      .build();
        }
      }
    }
    return getGetSingleTenantHsmInstanceProposalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest,
          com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>
      getListSingleTenantHsmInstanceProposalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSingleTenantHsmInstanceProposals",
      requestType = com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest.class,
      responseType = com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest,
          com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>
      getListSingleTenantHsmInstanceProposalsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest,
            com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>
        getListSingleTenantHsmInstanceProposalsMethod;
    if ((getListSingleTenantHsmInstanceProposalsMethod =
            HsmManagementGrpc.getListSingleTenantHsmInstanceProposalsMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getListSingleTenantHsmInstanceProposalsMethod =
                HsmManagementGrpc.getListSingleTenantHsmInstanceProposalsMethod)
            == null) {
          HsmManagementGrpc.getListSingleTenantHsmInstanceProposalsMethod =
              getListSingleTenantHsmInstanceProposalsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest,
                          com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListSingleTenantHsmInstanceProposals"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier(
                              "ListSingleTenantHsmInstanceProposals"))
                      .build();
        }
      }
    }
    return getListSingleTenantHsmInstanceProposalsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest,
          com.google.protobuf.Empty>
      getDeleteSingleTenantHsmInstanceProposalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSingleTenantHsmInstanceProposal",
      requestType = com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest,
          com.google.protobuf.Empty>
      getDeleteSingleTenantHsmInstanceProposalMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest,
            com.google.protobuf.Empty>
        getDeleteSingleTenantHsmInstanceProposalMethod;
    if ((getDeleteSingleTenantHsmInstanceProposalMethod =
            HsmManagementGrpc.getDeleteSingleTenantHsmInstanceProposalMethod)
        == null) {
      synchronized (HsmManagementGrpc.class) {
        if ((getDeleteSingleTenantHsmInstanceProposalMethod =
                HsmManagementGrpc.getDeleteSingleTenantHsmInstanceProposalMethod)
            == null) {
          HsmManagementGrpc.getDeleteSingleTenantHsmInstanceProposalMethod =
              getDeleteSingleTenantHsmInstanceProposalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteSingleTenantHsmInstanceProposal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HsmManagementMethodDescriptorSupplier(
                              "DeleteSingleTenantHsmInstanceProposal"))
                      .build();
        }
      }
    }
    return getDeleteSingleTenantHsmInstanceProposalMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static HsmManagementStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HsmManagementStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HsmManagementStub>() {
          @java.lang.Override
          public HsmManagementStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HsmManagementStub(channel, callOptions);
          }
        };
    return HsmManagementStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static HsmManagementBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HsmManagementBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HsmManagementBlockingV2Stub>() {
          @java.lang.Override
          public HsmManagementBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HsmManagementBlockingV2Stub(channel, callOptions);
          }
        };
    return HsmManagementBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HsmManagementBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HsmManagementBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HsmManagementBlockingStub>() {
          @java.lang.Override
          public HsmManagementBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HsmManagementBlockingStub(channel, callOptions);
          }
        };
    return HsmManagementBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static HsmManagementFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HsmManagementFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HsmManagementFutureStub>() {
          @java.lang.Override
          public HsmManagementFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HsmManagementFutureStub(channel, callOptions);
          }
        };
    return HsmManagementFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Google Cloud HSM Management Service
   * Provides interfaces for managing HSM instances.
   * Implements a REST model with the following objects:
   * * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]
   * * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    default void listSingleTenantHsmInstances(
        com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSingleTenantHsmInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    default void getSingleTenantHsmInstance(
        com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.SingleTenantHsmInstance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSingleTenantHsmInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a
     * given Project and Location. User must create a RegisterTwoFactorAuthKeys
     * proposal with this single-tenant HSM instance to finish setup of the
     * instance.
     * </pre>
     */
    default void createSingleTenantHsmInstance(
        com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSingleTenantHsmInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    default void createSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSingleTenantHsmInstanceProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approves a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING]
     * state.
     * </pre>
     */
    default void approveSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApproveSingleTenantHsmInstanceProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED]
     * state.
     * </pre>
     */
    default void executeSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExecuteSingleTenantHsmInstanceProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    default void getSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSingleTenantHsmInstanceProposalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    default void listSingleTenantHsmInstanceProposals(
        com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSingleTenantHsmInstanceProposalsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    default void deleteSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSingleTenantHsmInstanceProposalMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HsmManagement.
   *
   * <pre>
   * Google Cloud HSM Management Service
   * Provides interfaces for managing HSM instances.
   * Implements a REST model with the following objects:
   * * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]
   * * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   * </pre>
   */
  public abstract static class HsmManagementImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return HsmManagementGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HsmManagement.
   *
   * <pre>
   * Google Cloud HSM Management Service
   * Provides interfaces for managing HSM instances.
   * Implements a REST model with the following objects:
   * * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]
   * * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   * </pre>
   */
  public static final class HsmManagementStub
      extends io.grpc.stub.AbstractAsyncStub<HsmManagementStub> {
    private HsmManagementStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HsmManagementStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HsmManagementStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public void listSingleTenantHsmInstances(
        com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSingleTenantHsmInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public void getSingleTenantHsmInstance(
        com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.SingleTenantHsmInstance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSingleTenantHsmInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a
     * given Project and Location. User must create a RegisterTwoFactorAuthKeys
     * proposal with this single-tenant HSM instance to finish setup of the
     * instance.
     * </pre>
     */
    public void createSingleTenantHsmInstance(
        com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSingleTenantHsmInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public void createSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Approves a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING]
     * state.
     * </pre>
     */
    public void approveSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApproveSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Executes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED]
     * state.
     * </pre>
     */
    public void executeSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public void getSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public void listSingleTenantHsmInstanceProposals(
        com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSingleTenantHsmInstanceProposalsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public void deleteSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HsmManagement.
   *
   * <pre>
   * Google Cloud HSM Management Service
   * Provides interfaces for managing HSM instances.
   * Implements a REST model with the following objects:
   * * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]
   * * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   * </pre>
   */
  public static final class HsmManagementBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<HsmManagementBlockingV2Stub> {
    private HsmManagementBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HsmManagementBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HsmManagementBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse
        listSingleTenantHsmInstances(
            com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSingleTenantHsmInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.cloud.kms.v1.SingleTenantHsmInstance getSingleTenantHsmInstance(
        com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSingleTenantHsmInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a
     * given Project and Location. User must create a RegisterTwoFactorAuthKeys
     * proposal with this single-tenant HSM instance to finish setup of the
     * instance.
     * </pre>
     */
    public com.google.longrunning.Operation createSingleTenantHsmInstance(
        com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSingleTenantHsmInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.longrunning.Operation createSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getCreateSingleTenantHsmInstanceProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Approves a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING]
     * state.
     * </pre>
     */
    public com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse
        approveSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getApproveSingleTenantHsmInstanceProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Executes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED]
     * state.
     * </pre>
     */
    public com.google.longrunning.Operation executeSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getExecuteSingleTenantHsmInstanceProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal
        getSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSingleTenantHsmInstanceProposalMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse
        listSingleTenantHsmInstanceProposals(
            com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSingleTenantHsmInstanceProposalsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.protobuf.Empty deleteSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getDeleteSingleTenantHsmInstanceProposalMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service HsmManagement.
   *
   * <pre>
   * Google Cloud HSM Management Service
   * Provides interfaces for managing HSM instances.
   * Implements a REST model with the following objects:
   * * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]
   * * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   * </pre>
   */
  public static final class HsmManagementBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HsmManagementBlockingStub> {
    private HsmManagementBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HsmManagementBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HsmManagementBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse
        listSingleTenantHsmInstances(
            com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSingleTenantHsmInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.cloud.kms.v1.SingleTenantHsmInstance getSingleTenantHsmInstance(
        com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSingleTenantHsmInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a
     * given Project and Location. User must create a RegisterTwoFactorAuthKeys
     * proposal with this single-tenant HSM instance to finish setup of the
     * instance.
     * </pre>
     */
    public com.google.longrunning.Operation createSingleTenantHsmInstance(
        com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSingleTenantHsmInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.longrunning.Operation createSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCreateSingleTenantHsmInstanceProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Approves a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING]
     * state.
     * </pre>
     */
    public com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse
        approveSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getApproveSingleTenantHsmInstanceProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Executes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED]
     * state.
     * </pre>
     */
    public com.google.longrunning.Operation executeSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getExecuteSingleTenantHsmInstanceProposalMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal
        getSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSingleTenantHsmInstanceProposalMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse
        listSingleTenantHsmInstanceProposals(
            com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSingleTenantHsmInstanceProposalsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.protobuf.Empty deleteSingleTenantHsmInstanceProposal(
        com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getDeleteSingleTenantHsmInstanceProposalMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HsmManagement.
   *
   * <pre>
   * Google Cloud HSM Management Service
   * Provides interfaces for managing HSM instances.
   * Implements a REST model with the following objects:
   * * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]
   * * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
   * </pre>
   */
  public static final class HsmManagementFutureStub
      extends io.grpc.stub.AbstractFutureStub<HsmManagementFutureStub> {
    private HsmManagementFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HsmManagementFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HsmManagementFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstances][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>
        listSingleTenantHsmInstances(
            com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSingleTenantHsmInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.SingleTenantHsmInstance>
        getSingleTenantHsmInstance(
            com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSingleTenantHsmInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance] in a
     * given Project and Location. User must create a RegisterTwoFactorAuthKeys
     * proposal with this single-tenant HSM instance to finish setup of the
     * instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSingleTenantHsmInstance(
            com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSingleTenantHsmInstanceMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Approves a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [PENDING][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.PENDING]
     * state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>
        approveSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApproveSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Executes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal]
     * for a given
     * [SingleTenantHsmInstance][google.cloud.kms.v1.SingleTenantHsmInstance]. The
     * proposal must be in the
     * [APPROVED][google.cloud.kms.v1.SingleTenantHsmInstanceProposal.State.APPROVED]
     * state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        executeSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>
        getSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists
     * [SingleTenantHsmInstanceProposals][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>
        listSingleTenantHsmInstanceProposals(
            com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSingleTenantHsmInstanceProposalsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a
     * [SingleTenantHsmInstanceProposal][google.cloud.kms.v1.SingleTenantHsmInstanceProposal].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSingleTenantHsmInstanceProposal(
            com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSingleTenantHsmInstanceProposalMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_SINGLE_TENANT_HSM_INSTANCES = 0;
  private static final int METHODID_GET_SINGLE_TENANT_HSM_INSTANCE = 1;
  private static final int METHODID_CREATE_SINGLE_TENANT_HSM_INSTANCE = 2;
  private static final int METHODID_CREATE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL = 3;
  private static final int METHODID_APPROVE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL = 4;
  private static final int METHODID_EXECUTE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL = 5;
  private static final int METHODID_GET_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL = 6;
  private static final int METHODID_LIST_SINGLE_TENANT_HSM_INSTANCE_PROPOSALS = 7;
  private static final int METHODID_DELETE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL = 8;

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
        case METHODID_LIST_SINGLE_TENANT_HSM_INSTANCES:
          serviceImpl.listSingleTenantHsmInstances(
              (com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SINGLE_TENANT_HSM_INSTANCE:
          serviceImpl.getSingleTenantHsmInstance(
              (com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.SingleTenantHsmInstance>)
                  responseObserver);
          break;
        case METHODID_CREATE_SINGLE_TENANT_HSM_INSTANCE:
          serviceImpl.createSingleTenantHsmInstance(
              (com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL:
          serviceImpl.createSingleTenantHsmInstanceProposal(
              (com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_APPROVE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL:
          serviceImpl.approveSingleTenantHsmInstanceProposal(
              (com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>)
                  responseObserver);
          break;
        case METHODID_EXECUTE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL:
          serviceImpl.executeSingleTenantHsmInstanceProposal(
              (com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL:
          serviceImpl.getSingleTenantHsmInstanceProposal(
              (com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>)
                  responseObserver);
          break;
        case METHODID_LIST_SINGLE_TENANT_HSM_INSTANCE_PROPOSALS:
          serviceImpl.listSingleTenantHsmInstanceProposals(
              (com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL:
          serviceImpl.deleteSingleTenantHsmInstanceProposal(
              (com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getListSingleTenantHsmInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest,
                    com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse>(
                    service, METHODID_LIST_SINGLE_TENANT_HSM_INSTANCES)))
        .addMethod(
            getGetSingleTenantHsmInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest,
                    com.google.cloud.kms.v1.SingleTenantHsmInstance>(
                    service, METHODID_GET_SINGLE_TENANT_HSM_INSTANCE)))
        .addMethod(
            getCreateSingleTenantHsmInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_SINGLE_TENANT_HSM_INSTANCE)))
        .addMethod(
            getCreateSingleTenantHsmInstanceProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL)))
        .addMethod(
            getApproveSingleTenantHsmInstanceProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest,
                    com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse>(
                    service, METHODID_APPROVE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL)))
        .addMethod(
            getExecuteSingleTenantHsmInstanceProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_EXECUTE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL)))
        .addMethod(
            getGetSingleTenantHsmInstanceProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest,
                    com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal>(
                    service, METHODID_GET_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL)))
        .addMethod(
            getListSingleTenantHsmInstanceProposalsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest,
                    com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse>(
                    service, METHODID_LIST_SINGLE_TENANT_HSM_INSTANCE_PROPOSALS)))
        .addMethod(
            getDeleteSingleTenantHsmInstanceProposalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SINGLE_TENANT_HSM_INSTANCE_PROPOSAL)))
        .build();
  }

  private abstract static class HsmManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HsmManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.kms.v1.HsmManagementProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HsmManagement");
    }
  }

  private static final class HsmManagementFileDescriptorSupplier
      extends HsmManagementBaseDescriptorSupplier {
    HsmManagementFileDescriptorSupplier() {}
  }

  private static final class HsmManagementMethodDescriptorSupplier
      extends HsmManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HsmManagementMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HsmManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new HsmManagementFileDescriptorSupplier())
                      .addMethod(getListSingleTenantHsmInstancesMethod())
                      .addMethod(getGetSingleTenantHsmInstanceMethod())
                      .addMethod(getCreateSingleTenantHsmInstanceMethod())
                      .addMethod(getCreateSingleTenantHsmInstanceProposalMethod())
                      .addMethod(getApproveSingleTenantHsmInstanceProposalMethod())
                      .addMethod(getExecuteSingleTenantHsmInstanceProposalMethod())
                      .addMethod(getGetSingleTenantHsmInstanceProposalMethod())
                      .addMethod(getListSingleTenantHsmInstanceProposalsMethod())
                      .addMethod(getDeleteSingleTenantHsmInstanceProposalMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
