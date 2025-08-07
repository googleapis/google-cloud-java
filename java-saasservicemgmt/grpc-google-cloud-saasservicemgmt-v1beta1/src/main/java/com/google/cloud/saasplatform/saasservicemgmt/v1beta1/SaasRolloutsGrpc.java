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
package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages the rollout of SaaS services.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/saasplatform/saasservicemgmt/v1beta1/rollouts_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SaasRolloutsGrpc {

  private SaasRolloutsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse>
      getListRolloutsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRollouts",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest.class,
      responseType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse>
      getListRolloutsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse>
        getListRolloutsMethod;
    if ((getListRolloutsMethod = SaasRolloutsGrpc.getListRolloutsMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getListRolloutsMethod = SaasRolloutsGrpc.getListRolloutsMethod) == null) {
          SaasRolloutsGrpc.getListRolloutsMethod =
              getListRolloutsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .ListRolloutsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRollouts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListRolloutsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListRolloutsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SaasRolloutsMethodDescriptorSupplier("ListRollouts"))
                      .build();
        }
      }
    }
    return getListRolloutsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
      getGetRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRollout",
      requestType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
      getGetRolloutMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
        getGetRolloutMethod;
    if ((getGetRolloutMethod = SaasRolloutsGrpc.getGetRolloutMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getGetRolloutMethod = SaasRolloutsGrpc.getGetRolloutMethod) == null) {
          SaasRolloutsGrpc.getGetRolloutMethod =
              getGetRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .GetRolloutRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SaasRolloutsMethodDescriptorSupplier("GetRollout"))
                      .build();
        }
      }
    }
    return getGetRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
      getCreateRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRollout",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
      getCreateRolloutMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
        getCreateRolloutMethod;
    if ((getCreateRolloutMethod = SaasRolloutsGrpc.getCreateRolloutMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getCreateRolloutMethod = SaasRolloutsGrpc.getCreateRolloutMethod) == null) {
          SaasRolloutsGrpc.getCreateRolloutMethod =
              getCreateRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .CreateRolloutRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasRolloutsMethodDescriptorSupplier("CreateRollout"))
                      .build();
        }
      }
    }
    return getCreateRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
      getUpdateRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRollout",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
      getUpdateRolloutMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
        getUpdateRolloutMethod;
    if ((getUpdateRolloutMethod = SaasRolloutsGrpc.getUpdateRolloutMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getUpdateRolloutMethod = SaasRolloutsGrpc.getUpdateRolloutMethod) == null) {
          SaasRolloutsGrpc.getUpdateRolloutMethod =
              getUpdateRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .UpdateRolloutRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasRolloutsMethodDescriptorSupplier("UpdateRollout"))
                      .build();
        }
      }
    }
    return getUpdateRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest,
          com.google.protobuf.Empty>
      getDeleteRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRollout",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest,
          com.google.protobuf.Empty>
      getDeleteRolloutMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest,
            com.google.protobuf.Empty>
        getDeleteRolloutMethod;
    if ((getDeleteRolloutMethod = SaasRolloutsGrpc.getDeleteRolloutMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getDeleteRolloutMethod = SaasRolloutsGrpc.getDeleteRolloutMethod) == null) {
          SaasRolloutsGrpc.getDeleteRolloutMethod =
              getDeleteRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .DeleteRolloutRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasRolloutsMethodDescriptorSupplier("DeleteRollout"))
                      .build();
        }
      }
    }
    return getDeleteRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse>
      getListRolloutKindsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRolloutKinds",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest.class,
      responseType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse>
      getListRolloutKindsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse>
        getListRolloutKindsMethod;
    if ((getListRolloutKindsMethod = SaasRolloutsGrpc.getListRolloutKindsMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getListRolloutKindsMethod = SaasRolloutsGrpc.getListRolloutKindsMethod) == null) {
          SaasRolloutsGrpc.getListRolloutKindsMethod =
              getListRolloutKindsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .ListRolloutKindsRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .ListRolloutKindsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRolloutKinds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListRolloutKindsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .ListRolloutKindsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasRolloutsMethodDescriptorSupplier("ListRolloutKinds"))
                      .build();
        }
      }
    }
    return getListRolloutKindsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
      getGetRolloutKindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRolloutKind",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
      getGetRolloutKindMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
        getGetRolloutKindMethod;
    if ((getGetRolloutKindMethod = SaasRolloutsGrpc.getGetRolloutKindMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getGetRolloutKindMethod = SaasRolloutsGrpc.getGetRolloutKindMethod) == null) {
          SaasRolloutsGrpc.getGetRolloutKindMethod =
              getGetRolloutKindMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRolloutKind"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .GetRolloutKindRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasRolloutsMethodDescriptorSupplier("GetRolloutKind"))
                      .build();
        }
      }
    }
    return getGetRolloutKindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
      getCreateRolloutKindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRolloutKind",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
      getCreateRolloutKindMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
        getCreateRolloutKindMethod;
    if ((getCreateRolloutKindMethod = SaasRolloutsGrpc.getCreateRolloutKindMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getCreateRolloutKindMethod = SaasRolloutsGrpc.getCreateRolloutKindMethod) == null) {
          SaasRolloutsGrpc.getCreateRolloutKindMethod =
              getCreateRolloutKindMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .CreateRolloutKindRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRolloutKind"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .CreateRolloutKindRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasRolloutsMethodDescriptorSupplier("CreateRolloutKind"))
                      .build();
        }
      }
    }
    return getCreateRolloutKindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
      getUpdateRolloutKindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRolloutKind",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest.class,
      responseType = com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest,
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
      getUpdateRolloutKindMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest,
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
        getUpdateRolloutKindMethod;
    if ((getUpdateRolloutKindMethod = SaasRolloutsGrpc.getUpdateRolloutKindMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getUpdateRolloutKindMethod = SaasRolloutsGrpc.getUpdateRolloutKindMethod) == null) {
          SaasRolloutsGrpc.getUpdateRolloutKindMethod =
              getUpdateRolloutKindMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .UpdateRolloutKindRequest,
                          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRolloutKind"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .UpdateRolloutKindRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasRolloutsMethodDescriptorSupplier("UpdateRolloutKind"))
                      .build();
        }
      }
    }
    return getUpdateRolloutKindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest,
          com.google.protobuf.Empty>
      getDeleteRolloutKindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRolloutKind",
      requestType =
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest,
          com.google.protobuf.Empty>
      getDeleteRolloutKindMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest,
            com.google.protobuf.Empty>
        getDeleteRolloutKindMethod;
    if ((getDeleteRolloutKindMethod = SaasRolloutsGrpc.getDeleteRolloutKindMethod) == null) {
      synchronized (SaasRolloutsGrpc.class) {
        if ((getDeleteRolloutKindMethod = SaasRolloutsGrpc.getDeleteRolloutKindMethod) == null) {
          SaasRolloutsGrpc.getDeleteRolloutKindMethod =
              getDeleteRolloutKindMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                              .DeleteRolloutKindRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRolloutKind"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                                  .DeleteRolloutKindRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SaasRolloutsMethodDescriptorSupplier("DeleteRolloutKind"))
                      .build();
        }
      }
    }
    return getDeleteRolloutKindMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SaasRolloutsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaasRolloutsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SaasRolloutsStub>() {
          @java.lang.Override
          public SaasRolloutsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SaasRolloutsStub(channel, callOptions);
          }
        };
    return SaasRolloutsStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SaasRolloutsBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaasRolloutsBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SaasRolloutsBlockingV2Stub>() {
          @java.lang.Override
          public SaasRolloutsBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SaasRolloutsBlockingV2Stub(channel, callOptions);
          }
        };
    return SaasRolloutsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SaasRolloutsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaasRolloutsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SaasRolloutsBlockingStub>() {
          @java.lang.Override
          public SaasRolloutsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SaasRolloutsBlockingStub(channel, callOptions);
          }
        };
    return SaasRolloutsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SaasRolloutsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SaasRolloutsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SaasRolloutsFutureStub>() {
          @java.lang.Override
          public SaasRolloutsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SaasRolloutsFutureStub(channel, callOptions);
          }
        };
    return SaasRolloutsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages the rollout of SaaS services.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollouts.
     * </pre>
     */
    default void listRollouts(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRolloutsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout.
     * </pre>
     */
    default void getRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRolloutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout.
     * </pre>
     */
    default void createRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRolloutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout.
     * </pre>
     */
    default void updateRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRolloutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout.
     * </pre>
     */
    default void deleteRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRolloutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollout kinds.
     * </pre>
     */
    default void listRolloutKinds(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRolloutKindsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout kind.
     * </pre>
     */
    default void getRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRolloutKindMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout kind.
     * </pre>
     */
    default void createRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRolloutKindMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout kind.
     * </pre>
     */
    default void updateRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRolloutKindMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout kind.
     * </pre>
     */
    default void deleteRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRolloutKindMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SaasRollouts.
   *
   * <pre>
   * Manages the rollout of SaaS services.
   * </pre>
   */
  public abstract static class SaasRolloutsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SaasRolloutsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SaasRollouts.
   *
   * <pre>
   * Manages the rollout of SaaS services.
   * </pre>
   */
  public static final class SaasRolloutsStub
      extends io.grpc.stub.AbstractAsyncStub<SaasRolloutsStub> {
    private SaasRolloutsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaasRolloutsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaasRolloutsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollouts.
     * </pre>
     */
    public void listRollouts(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRolloutsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout.
     * </pre>
     */
    public void getRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRolloutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout.
     * </pre>
     */
    public void createRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRolloutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout.
     * </pre>
     */
    public void updateRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRolloutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout.
     * </pre>
     */
    public void deleteRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRolloutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollout kinds.
     * </pre>
     */
    public void listRolloutKinds(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRolloutKindsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout kind.
     * </pre>
     */
    public void getRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRolloutKindMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout kind.
     * </pre>
     */
    public void createRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRolloutKindMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout kind.
     * </pre>
     */
    public void updateRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRolloutKindMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout kind.
     * </pre>
     */
    public void deleteRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRolloutKindMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SaasRollouts.
   *
   * <pre>
   * Manages the rollout of SaaS services.
   * </pre>
   */
  public static final class SaasRolloutsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SaasRolloutsBlockingV2Stub> {
    private SaasRolloutsBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaasRolloutsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaasRolloutsBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollouts.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse listRollouts(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRolloutsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout getRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout createRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout updateRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollout kinds.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse
        listRolloutKinds(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRolloutKindsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind getRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRolloutKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind createRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRolloutKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind updateRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRolloutKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout kind.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRolloutKindMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SaasRollouts.
   *
   * <pre>
   * Manages the rollout of SaaS services.
   * </pre>
   */
  public static final class SaasRolloutsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SaasRolloutsBlockingStub> {
    private SaasRolloutsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaasRolloutsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaasRolloutsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollouts.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse listRollouts(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRolloutsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout getRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout createRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout updateRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRollout(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollout kinds.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse
        listRolloutKinds(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRolloutKindsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind getRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRolloutKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind createRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRolloutKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout kind.
     * </pre>
     */
    public com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind updateRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRolloutKindMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout kind.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRolloutKind(
        com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRolloutKindMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SaasRollouts.
   *
   * <pre>
   * Manages the rollout of SaaS services.
   * </pre>
   */
  public static final class SaasRolloutsFutureStub
      extends io.grpc.stub.AbstractFutureStub<SaasRolloutsFutureStub> {
    private SaasRolloutsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SaasRolloutsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SaasRolloutsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollouts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse>
        listRollouts(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRolloutsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
        getRollout(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRolloutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
        createRollout(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRolloutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>
        updateRollout(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRolloutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRollout(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRolloutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a collection of rollout kinds.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse>
        listRolloutKinds(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRolloutKindsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve a single rollout kind.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
        getRolloutKind(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRolloutKindMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new rollout kind.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
        createRolloutKind(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRolloutKindMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single rollout kind.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>
        updateRolloutKind(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRolloutKindMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single rollout kind.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRolloutKind(
            com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRolloutKindMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ROLLOUTS = 0;
  private static final int METHODID_GET_ROLLOUT = 1;
  private static final int METHODID_CREATE_ROLLOUT = 2;
  private static final int METHODID_UPDATE_ROLLOUT = 3;
  private static final int METHODID_DELETE_ROLLOUT = 4;
  private static final int METHODID_LIST_ROLLOUT_KINDS = 5;
  private static final int METHODID_GET_ROLLOUT_KIND = 6;
  private static final int METHODID_CREATE_ROLLOUT_KIND = 7;
  private static final int METHODID_UPDATE_ROLLOUT_KIND = 8;
  private static final int METHODID_DELETE_ROLLOUT_KIND = 9;

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
        case METHODID_LIST_ROLLOUTS:
          serviceImpl.listRollouts(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ROLLOUT:
          serviceImpl.getRollout(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>)
                  responseObserver);
          break;
        case METHODID_CREATE_ROLLOUT:
          serviceImpl.createRollout(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ROLLOUT:
          serviceImpl.updateRollout(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>)
                  responseObserver);
          break;
        case METHODID_DELETE_ROLLOUT:
          serviceImpl.deleteRollout(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_ROLLOUT_KINDS:
          serviceImpl.listRolloutKinds(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1
                          .ListRolloutKindsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ROLLOUT_KIND:
          serviceImpl.getRolloutKind(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>)
                  responseObserver);
          break;
        case METHODID_CREATE_ROLLOUT_KIND:
          serviceImpl.createRolloutKind(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ROLLOUT_KIND:
          serviceImpl.updateRolloutKind(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>)
                  responseObserver);
          break;
        case METHODID_DELETE_ROLLOUT_KIND:
          serviceImpl.deleteRolloutKind(
              (com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest)
                  request,
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
            getListRolloutsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse>(
                    service, METHODID_LIST_ROLLOUTS)))
        .addMethod(
            getGetRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>(
                    service, METHODID_GET_ROLLOUT)))
        .addMethod(
            getCreateRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>(
                    service, METHODID_CREATE_ROLLOUT)))
        .addMethod(
            getUpdateRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout>(
                    service, METHODID_UPDATE_ROLLOUT)))
        .addMethod(
            getDeleteRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ROLLOUT)))
        .addMethod(
            getListRolloutKindsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse>(
                    service, METHODID_LIST_ROLLOUT_KINDS)))
        .addMethod(
            getGetRolloutKindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>(
                    service, METHODID_GET_ROLLOUT_KIND)))
        .addMethod(
            getCreateRolloutKindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>(
                    service, METHODID_CREATE_ROLLOUT_KIND)))
        .addMethod(
            getUpdateRolloutKindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest,
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind>(
                    service, METHODID_UPDATE_ROLLOUT_KIND)))
        .addMethod(
            getDeleteRolloutKindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ROLLOUT_KIND)))
        .build();
  }

  private abstract static class SaasRolloutsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SaasRolloutsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SaasRollouts");
    }
  }

  private static final class SaasRolloutsFileDescriptorSupplier
      extends SaasRolloutsBaseDescriptorSupplier {
    SaasRolloutsFileDescriptorSupplier() {}
  }

  private static final class SaasRolloutsMethodDescriptorSupplier
      extends SaasRolloutsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SaasRolloutsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SaasRolloutsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SaasRolloutsFileDescriptorSupplier())
                      .addMethod(getListRolloutsMethod())
                      .addMethod(getGetRolloutMethod())
                      .addMethod(getCreateRolloutMethod())
                      .addMethod(getUpdateRolloutMethod())
                      .addMethod(getDeleteRolloutMethod())
                      .addMethod(getListRolloutKindsMethod())
                      .addMethod(getGetRolloutKindMethod())
                      .addMethod(getCreateRolloutKindMethod())
                      .addMethod(getUpdateRolloutKindMethod())
                      .addMethod(getDeleteRolloutKindMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
