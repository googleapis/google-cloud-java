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
package com.google.cloud.networksecurity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * PM2 is the "out-of-band" flavor of the Network Security Integrations product.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class MirroringGrpc {

  private MirroringGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.networksecurity.v1.Mirroring";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest,
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>
      getListMirroringEndpointGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMirroringEndpointGroups",
      requestType = com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest,
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>
      getListMirroringEndpointGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest,
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>
        getListMirroringEndpointGroupsMethod;
    if ((getListMirroringEndpointGroupsMethod = MirroringGrpc.getListMirroringEndpointGroupsMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getListMirroringEndpointGroupsMethod =
                MirroringGrpc.getListMirroringEndpointGroupsMethod)
            == null) {
          MirroringGrpc.getListMirroringEndpointGroupsMethod =
              getListMirroringEndpointGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest,
                          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMirroringEndpointGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListMirroringEndpointGroupsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("ListMirroringEndpointGroups"))
                      .build();
        }
      }
    }
    return getListMirroringEndpointGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest,
          com.google.cloud.networksecurity.v1.MirroringEndpointGroup>
      getGetMirroringEndpointGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMirroringEndpointGroup",
      requestType = com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest.class,
      responseType = com.google.cloud.networksecurity.v1.MirroringEndpointGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest,
          com.google.cloud.networksecurity.v1.MirroringEndpointGroup>
      getGetMirroringEndpointGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest,
            com.google.cloud.networksecurity.v1.MirroringEndpointGroup>
        getGetMirroringEndpointGroupMethod;
    if ((getGetMirroringEndpointGroupMethod = MirroringGrpc.getGetMirroringEndpointGroupMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getGetMirroringEndpointGroupMethod = MirroringGrpc.getGetMirroringEndpointGroupMethod)
            == null) {
          MirroringGrpc.getGetMirroringEndpointGroupMethod =
              getGetMirroringEndpointGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest,
                          com.google.cloud.networksecurity.v1.MirroringEndpointGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMirroringEndpointGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.MirroringEndpointGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("GetMirroringEndpointGroup"))
                      .build();
        }
      }
    }
    return getGetMirroringEndpointGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest,
          com.google.longrunning.Operation>
      getCreateMirroringEndpointGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMirroringEndpointGroup",
      requestType = com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest,
          com.google.longrunning.Operation>
      getCreateMirroringEndpointGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest,
            com.google.longrunning.Operation>
        getCreateMirroringEndpointGroupMethod;
    if ((getCreateMirroringEndpointGroupMethod =
            MirroringGrpc.getCreateMirroringEndpointGroupMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getCreateMirroringEndpointGroupMethod =
                MirroringGrpc.getCreateMirroringEndpointGroupMethod)
            == null) {
          MirroringGrpc.getCreateMirroringEndpointGroupMethod =
              getCreateMirroringEndpointGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMirroringEndpointGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateMirroringEndpointGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("CreateMirroringEndpointGroup"))
                      .build();
        }
      }
    }
    return getCreateMirroringEndpointGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest,
          com.google.longrunning.Operation>
      getUpdateMirroringEndpointGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMirroringEndpointGroup",
      requestType = com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest,
          com.google.longrunning.Operation>
      getUpdateMirroringEndpointGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest,
            com.google.longrunning.Operation>
        getUpdateMirroringEndpointGroupMethod;
    if ((getUpdateMirroringEndpointGroupMethod =
            MirroringGrpc.getUpdateMirroringEndpointGroupMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getUpdateMirroringEndpointGroupMethod =
                MirroringGrpc.getUpdateMirroringEndpointGroupMethod)
            == null) {
          MirroringGrpc.getUpdateMirroringEndpointGroupMethod =
              getUpdateMirroringEndpointGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMirroringEndpointGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateMirroringEndpointGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("UpdateMirroringEndpointGroup"))
                      .build();
        }
      }
    }
    return getUpdateMirroringEndpointGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest,
          com.google.longrunning.Operation>
      getDeleteMirroringEndpointGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMirroringEndpointGroup",
      requestType = com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest,
          com.google.longrunning.Operation>
      getDeleteMirroringEndpointGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest,
            com.google.longrunning.Operation>
        getDeleteMirroringEndpointGroupMethod;
    if ((getDeleteMirroringEndpointGroupMethod =
            MirroringGrpc.getDeleteMirroringEndpointGroupMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getDeleteMirroringEndpointGroupMethod =
                MirroringGrpc.getDeleteMirroringEndpointGroupMethod)
            == null) {
          MirroringGrpc.getDeleteMirroringEndpointGroupMethod =
              getDeleteMirroringEndpointGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMirroringEndpointGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteMirroringEndpointGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("DeleteMirroringEndpointGroup"))
                      .build();
        }
      }
    }
    return getDeleteMirroringEndpointGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest,
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse>
      getListMirroringEndpointGroupAssociationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMirroringEndpointGroupAssociations",
      requestType =
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest.class,
      responseType =
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest,
          com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse>
      getListMirroringEndpointGroupAssociationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest,
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse>
        getListMirroringEndpointGroupAssociationsMethod;
    if ((getListMirroringEndpointGroupAssociationsMethod =
            MirroringGrpc.getListMirroringEndpointGroupAssociationsMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getListMirroringEndpointGroupAssociationsMethod =
                MirroringGrpc.getListMirroringEndpointGroupAssociationsMethod)
            == null) {
          MirroringGrpc.getListMirroringEndpointGroupAssociationsMethod =
              getListMirroringEndpointGroupAssociationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .ListMirroringEndpointGroupAssociationsRequest,
                          com.google.cloud.networksecurity.v1
                              .ListMirroringEndpointGroupAssociationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListMirroringEndpointGroupAssociations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListMirroringEndpointGroupAssociationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListMirroringEndpointGroupAssociationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier(
                              "ListMirroringEndpointGroupAssociations"))
                      .build();
        }
      }
    }
    return getListMirroringEndpointGroupAssociationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest,
          com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>
      getGetMirroringEndpointGroupAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMirroringEndpointGroupAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest.class,
      responseType = com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest,
          com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>
      getGetMirroringEndpointGroupAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest,
            com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>
        getGetMirroringEndpointGroupAssociationMethod;
    if ((getGetMirroringEndpointGroupAssociationMethod =
            MirroringGrpc.getGetMirroringEndpointGroupAssociationMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getGetMirroringEndpointGroupAssociationMethod =
                MirroringGrpc.getGetMirroringEndpointGroupAssociationMethod)
            == null) {
          MirroringGrpc.getGetMirroringEndpointGroupAssociationMethod =
              getGetMirroringEndpointGroupAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .GetMirroringEndpointGroupAssociationRequest,
                          com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetMirroringEndpointGroupAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .GetMirroringEndpointGroupAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier(
                              "GetMirroringEndpointGroupAssociation"))
                      .build();
        }
      }
    }
    return getGetMirroringEndpointGroupAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getCreateMirroringEndpointGroupAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMirroringEndpointGroupAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getCreateMirroringEndpointGroupAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest,
            com.google.longrunning.Operation>
        getCreateMirroringEndpointGroupAssociationMethod;
    if ((getCreateMirroringEndpointGroupAssociationMethod =
            MirroringGrpc.getCreateMirroringEndpointGroupAssociationMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getCreateMirroringEndpointGroupAssociationMethod =
                MirroringGrpc.getCreateMirroringEndpointGroupAssociationMethod)
            == null) {
          MirroringGrpc.getCreateMirroringEndpointGroupAssociationMethod =
              getCreateMirroringEndpointGroupAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .CreateMirroringEndpointGroupAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateMirroringEndpointGroupAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateMirroringEndpointGroupAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier(
                              "CreateMirroringEndpointGroupAssociation"))
                      .build();
        }
      }
    }
    return getCreateMirroringEndpointGroupAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateMirroringEndpointGroupAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMirroringEndpointGroupAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateMirroringEndpointGroupAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest,
            com.google.longrunning.Operation>
        getUpdateMirroringEndpointGroupAssociationMethod;
    if ((getUpdateMirroringEndpointGroupAssociationMethod =
            MirroringGrpc.getUpdateMirroringEndpointGroupAssociationMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getUpdateMirroringEndpointGroupAssociationMethod =
                MirroringGrpc.getUpdateMirroringEndpointGroupAssociationMethod)
            == null) {
          MirroringGrpc.getUpdateMirroringEndpointGroupAssociationMethod =
              getUpdateMirroringEndpointGroupAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .UpdateMirroringEndpointGroupAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateMirroringEndpointGroupAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateMirroringEndpointGroupAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier(
                              "UpdateMirroringEndpointGroupAssociation"))
                      .build();
        }
      }
    }
    return getUpdateMirroringEndpointGroupAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteMirroringEndpointGroupAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMirroringEndpointGroupAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteMirroringEndpointGroupAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest,
            com.google.longrunning.Operation>
        getDeleteMirroringEndpointGroupAssociationMethod;
    if ((getDeleteMirroringEndpointGroupAssociationMethod =
            MirroringGrpc.getDeleteMirroringEndpointGroupAssociationMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getDeleteMirroringEndpointGroupAssociationMethod =
                MirroringGrpc.getDeleteMirroringEndpointGroupAssociationMethod)
            == null) {
          MirroringGrpc.getDeleteMirroringEndpointGroupAssociationMethod =
              getDeleteMirroringEndpointGroupAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .DeleteMirroringEndpointGroupAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteMirroringEndpointGroupAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteMirroringEndpointGroupAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier(
                              "DeleteMirroringEndpointGroupAssociation"))
                      .build();
        }
      }
    }
    return getDeleteMirroringEndpointGroupAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest,
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>
      getListMirroringDeploymentGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMirroringDeploymentGroups",
      requestType = com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest.class,
      responseType =
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest,
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>
      getListMirroringDeploymentGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest,
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>
        getListMirroringDeploymentGroupsMethod;
    if ((getListMirroringDeploymentGroupsMethod =
            MirroringGrpc.getListMirroringDeploymentGroupsMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getListMirroringDeploymentGroupsMethod =
                MirroringGrpc.getListMirroringDeploymentGroupsMethod)
            == null) {
          MirroringGrpc.getListMirroringDeploymentGroupsMethod =
              getListMirroringDeploymentGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest,
                          com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMirroringDeploymentGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListMirroringDeploymentGroupsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListMirroringDeploymentGroupsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("ListMirroringDeploymentGroups"))
                      .build();
        }
      }
    }
    return getListMirroringDeploymentGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest,
          com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>
      getGetMirroringDeploymentGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMirroringDeploymentGroup",
      requestType = com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest.class,
      responseType = com.google.cloud.networksecurity.v1.MirroringDeploymentGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest,
          com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>
      getGetMirroringDeploymentGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest,
            com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>
        getGetMirroringDeploymentGroupMethod;
    if ((getGetMirroringDeploymentGroupMethod = MirroringGrpc.getGetMirroringDeploymentGroupMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getGetMirroringDeploymentGroupMethod =
                MirroringGrpc.getGetMirroringDeploymentGroupMethod)
            == null) {
          MirroringGrpc.getGetMirroringDeploymentGroupMethod =
              getGetMirroringDeploymentGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest,
                          com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMirroringDeploymentGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.MirroringDeploymentGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("GetMirroringDeploymentGroup"))
                      .build();
        }
      }
    }
    return getGetMirroringDeploymentGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getCreateMirroringDeploymentGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMirroringDeploymentGroup",
      requestType = com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getCreateMirroringDeploymentGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest,
            com.google.longrunning.Operation>
        getCreateMirroringDeploymentGroupMethod;
    if ((getCreateMirroringDeploymentGroupMethod =
            MirroringGrpc.getCreateMirroringDeploymentGroupMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getCreateMirroringDeploymentGroupMethod =
                MirroringGrpc.getCreateMirroringDeploymentGroupMethod)
            == null) {
          MirroringGrpc.getCreateMirroringDeploymentGroupMethod =
              getCreateMirroringDeploymentGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMirroringDeploymentGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateMirroringDeploymentGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("CreateMirroringDeploymentGroup"))
                      .build();
        }
      }
    }
    return getCreateMirroringDeploymentGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getUpdateMirroringDeploymentGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMirroringDeploymentGroup",
      requestType = com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getUpdateMirroringDeploymentGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest,
            com.google.longrunning.Operation>
        getUpdateMirroringDeploymentGroupMethod;
    if ((getUpdateMirroringDeploymentGroupMethod =
            MirroringGrpc.getUpdateMirroringDeploymentGroupMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getUpdateMirroringDeploymentGroupMethod =
                MirroringGrpc.getUpdateMirroringDeploymentGroupMethod)
            == null) {
          MirroringGrpc.getUpdateMirroringDeploymentGroupMethod =
              getUpdateMirroringDeploymentGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMirroringDeploymentGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateMirroringDeploymentGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("UpdateMirroringDeploymentGroup"))
                      .build();
        }
      }
    }
    return getUpdateMirroringDeploymentGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getDeleteMirroringDeploymentGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMirroringDeploymentGroup",
      requestType = com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getDeleteMirroringDeploymentGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest,
            com.google.longrunning.Operation>
        getDeleteMirroringDeploymentGroupMethod;
    if ((getDeleteMirroringDeploymentGroupMethod =
            MirroringGrpc.getDeleteMirroringDeploymentGroupMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getDeleteMirroringDeploymentGroupMethod =
                MirroringGrpc.getDeleteMirroringDeploymentGroupMethod)
            == null) {
          MirroringGrpc.getDeleteMirroringDeploymentGroupMethod =
              getDeleteMirroringDeploymentGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMirroringDeploymentGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteMirroringDeploymentGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("DeleteMirroringDeploymentGroup"))
                      .build();
        }
      }
    }
    return getDeleteMirroringDeploymentGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest,
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>
      getListMirroringDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMirroringDeployments",
      requestType = com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest,
          com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>
      getListMirroringDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest,
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>
        getListMirroringDeploymentsMethod;
    if ((getListMirroringDeploymentsMethod = MirroringGrpc.getListMirroringDeploymentsMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getListMirroringDeploymentsMethod = MirroringGrpc.getListMirroringDeploymentsMethod)
            == null) {
          MirroringGrpc.getListMirroringDeploymentsMethod =
              getListMirroringDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest,
                          com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMirroringDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("ListMirroringDeployments"))
                      .build();
        }
      }
    }
    return getListMirroringDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest,
          com.google.cloud.networksecurity.v1.MirroringDeployment>
      getGetMirroringDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMirroringDeployment",
      requestType = com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest.class,
      responseType = com.google.cloud.networksecurity.v1.MirroringDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest,
          com.google.cloud.networksecurity.v1.MirroringDeployment>
      getGetMirroringDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest,
            com.google.cloud.networksecurity.v1.MirroringDeployment>
        getGetMirroringDeploymentMethod;
    if ((getGetMirroringDeploymentMethod = MirroringGrpc.getGetMirroringDeploymentMethod) == null) {
      synchronized (MirroringGrpc.class) {
        if ((getGetMirroringDeploymentMethod = MirroringGrpc.getGetMirroringDeploymentMethod)
            == null) {
          MirroringGrpc.getGetMirroringDeploymentMethod =
              getGetMirroringDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest,
                          com.google.cloud.networksecurity.v1.MirroringDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMirroringDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.MirroringDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("GetMirroringDeployment"))
                      .build();
        }
      }
    }
    return getGetMirroringDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateMirroringDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMirroringDeployment",
      requestType = com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateMirroringDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest,
            com.google.longrunning.Operation>
        getCreateMirroringDeploymentMethod;
    if ((getCreateMirroringDeploymentMethod = MirroringGrpc.getCreateMirroringDeploymentMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getCreateMirroringDeploymentMethod = MirroringGrpc.getCreateMirroringDeploymentMethod)
            == null) {
          MirroringGrpc.getCreateMirroringDeploymentMethod =
              getCreateMirroringDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMirroringDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("CreateMirroringDeployment"))
                      .build();
        }
      }
    }
    return getCreateMirroringDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest,
          com.google.longrunning.Operation>
      getUpdateMirroringDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMirroringDeployment",
      requestType = com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest,
          com.google.longrunning.Operation>
      getUpdateMirroringDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest,
            com.google.longrunning.Operation>
        getUpdateMirroringDeploymentMethod;
    if ((getUpdateMirroringDeploymentMethod = MirroringGrpc.getUpdateMirroringDeploymentMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getUpdateMirroringDeploymentMethod = MirroringGrpc.getUpdateMirroringDeploymentMethod)
            == null) {
          MirroringGrpc.getUpdateMirroringDeploymentMethod =
              getUpdateMirroringDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMirroringDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("UpdateMirroringDeployment"))
                      .build();
        }
      }
    }
    return getUpdateMirroringDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteMirroringDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMirroringDeployment",
      requestType = com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteMirroringDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest,
            com.google.longrunning.Operation>
        getDeleteMirroringDeploymentMethod;
    if ((getDeleteMirroringDeploymentMethod = MirroringGrpc.getDeleteMirroringDeploymentMethod)
        == null) {
      synchronized (MirroringGrpc.class) {
        if ((getDeleteMirroringDeploymentMethod = MirroringGrpc.getDeleteMirroringDeploymentMethod)
            == null) {
          MirroringGrpc.getDeleteMirroringDeploymentMethod =
              getDeleteMirroringDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMirroringDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MirroringMethodDescriptorSupplier("DeleteMirroringDeployment"))
                      .build();
        }
      }
    }
    return getDeleteMirroringDeploymentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MirroringStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MirroringStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MirroringStub>() {
          @java.lang.Override
          public MirroringStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MirroringStub(channel, callOptions);
          }
        };
    return MirroringStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MirroringBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MirroringBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MirroringBlockingV2Stub>() {
          @java.lang.Override
          public MirroringBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MirroringBlockingV2Stub(channel, callOptions);
          }
        };
    return MirroringBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MirroringBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MirroringBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MirroringBlockingStub>() {
          @java.lang.Override
          public MirroringBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MirroringBlockingStub(channel, callOptions);
          }
        };
    return MirroringBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MirroringFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MirroringFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MirroringFutureStub>() {
          @java.lang.Override
          public MirroringFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MirroringFutureStub(channel, callOptions);
          }
        };
    return MirroringFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * PM2 is the "out-of-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists endpoint groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    default void listMirroringEndpointGroups(
        com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMirroringEndpointGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific endpoint group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    default void getMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.MirroringEndpointGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMirroringEndpointGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an endpoint group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    default void createMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMirroringEndpointGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an endpoint group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    default void updateMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMirroringEndpointGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an endpoint group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    default void deleteMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMirroringEndpointGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists associations in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    default void listMirroringEndpointGroupAssociations(
        com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMirroringEndpointGroupAssociationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific association.
     * See https://google.aip.dev/131.
     * </pre>
     */
    default void getMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMirroringEndpointGroupAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an association in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    default void createMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMirroringEndpointGroupAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an association.
     * See https://google.aip.dev/134.
     * </pre>
     */
    default void updateMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMirroringEndpointGroupAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an association.
     * See https://google.aip.dev/135.
     * </pre>
     */
    default void deleteMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMirroringEndpointGroupAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists deployment groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    default void listMirroringDeploymentGroups(
        com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMirroringDeploymentGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    default void getMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMirroringDeploymentGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    default void createMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMirroringDeploymentGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    default void updateMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMirroringDeploymentGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    default void deleteMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMirroringDeploymentGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    default void listMirroringDeployments(
        com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMirroringDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment.
     * See https://google.aip.dev/131.
     * </pre>
     */
    default void getMirroringDeployment(
        com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.MirroringDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMirroringDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    default void createMirroringDeployment(
        com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMirroringDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * See https://google.aip.dev/134.
     * </pre>
     */
    default void updateMirroringDeployment(
        com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMirroringDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment.
     * See https://google.aip.dev/135.
     * </pre>
     */
    default void deleteMirroringDeployment(
        com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMirroringDeploymentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Mirroring.
   *
   * <pre>
   * PM2 is the "out-of-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public abstract static class MirroringImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MirroringGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Mirroring.
   *
   * <pre>
   * PM2 is the "out-of-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public static final class MirroringStub extends io.grpc.stub.AbstractAsyncStub<MirroringStub> {
    private MirroringStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MirroringStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MirroringStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists endpoint groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public void listMirroringEndpointGroups(
        com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMirroringEndpointGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific endpoint group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public void getMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.MirroringEndpointGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMirroringEndpointGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an endpoint group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public void createMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMirroringEndpointGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an endpoint group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public void updateMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMirroringEndpointGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an endpoint group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public void deleteMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMirroringEndpointGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists associations in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public void listMirroringEndpointGroupAssociations(
        com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMirroringEndpointGroupAssociationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific association.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public void getMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMirroringEndpointGroupAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an association in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public void createMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getCreateMirroringEndpointGroupAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an association.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public void updateMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getUpdateMirroringEndpointGroupAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an association.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public void deleteMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getDeleteMirroringEndpointGroupAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists deployment groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public void listMirroringDeploymentGroups(
        com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMirroringDeploymentGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public void getMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMirroringDeploymentGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public void createMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMirroringDeploymentGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public void updateMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMirroringDeploymentGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public void deleteMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMirroringDeploymentGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public void listMirroringDeployments(
        com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMirroringDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public void getMirroringDeployment(
        com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.MirroringDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMirroringDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public void createMirroringDeployment(
        com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMirroringDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public void updateMirroringDeployment(
        com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMirroringDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public void deleteMirroringDeployment(
        com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMirroringDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Mirroring.
   *
   * <pre>
   * PM2 is the "out-of-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public static final class MirroringBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MirroringBlockingV2Stub> {
    private MirroringBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MirroringBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MirroringBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists endpoint groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse
        listMirroringEndpointGroups(
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMirroringEndpointGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific endpoint group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.MirroringEndpointGroup getMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMirroringEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an endpoint group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMirroringEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an endpoint group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMirroringEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an endpoint group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMirroringEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists associations in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse
        listMirroringEndpointGroupAssociations(
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest
                request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getListMirroringEndpointGroupAssociationsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific association.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation
        getMirroringEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMirroringEndpointGroupAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an association in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getCreateMirroringEndpointGroupAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates an association.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getUpdateMirroringEndpointGroupAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an association.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getDeleteMirroringEndpointGroupAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployment groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse
        listMirroringDeploymentGroups(
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMirroringDeploymentGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.MirroringDeploymentGroup getMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMirroringDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMirroringDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMirroringDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMirroringDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse
        listMirroringDeployments(
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMirroringDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.MirroringDeployment getMirroringDeployment(
        com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMirroringDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createMirroringDeployment(
        com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMirroringDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateMirroringDeployment(
        com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMirroringDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMirroringDeployment(
        com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMirroringDeploymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Mirroring.
   *
   * <pre>
   * PM2 is the "out-of-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public static final class MirroringBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MirroringBlockingStub> {
    private MirroringBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MirroringBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MirroringBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists endpoint groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse
        listMirroringEndpointGroups(
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMirroringEndpointGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific endpoint group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.MirroringEndpointGroup getMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMirroringEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an endpoint group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMirroringEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an endpoint group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMirroringEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an endpoint group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMirroringEndpointGroup(
        com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMirroringEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists associations in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse
        listMirroringEndpointGroupAssociations(
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListMirroringEndpointGroupAssociationsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific association.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation
        getMirroringEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMirroringEndpointGroupAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an association in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCreateMirroringEndpointGroupAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates an association.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getUpdateMirroringEndpointGroupAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an association.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMirroringEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getDeleteMirroringEndpointGroupAssociationMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployment groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse
        listMirroringDeploymentGroups(
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMirroringDeploymentGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.MirroringDeploymentGroup getMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMirroringDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMirroringDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMirroringDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMirroringDeploymentGroup(
        com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMirroringDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse
        listMirroringDeployments(
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMirroringDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.MirroringDeployment getMirroringDeployment(
        com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMirroringDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createMirroringDeployment(
        com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMirroringDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateMirroringDeployment(
        com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMirroringDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMirroringDeployment(
        com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMirroringDeploymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Mirroring.
   *
   * <pre>
   * PM2 is the "out-of-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public static final class MirroringFutureStub
      extends io.grpc.stub.AbstractFutureStub<MirroringFutureStub> {
    private MirroringFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MirroringFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MirroringFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists endpoint groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>
        listMirroringEndpointGroups(
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMirroringEndpointGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific endpoint group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.MirroringEndpointGroup>
        getMirroringEndpointGroup(
            com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMirroringEndpointGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an endpoint group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMirroringEndpointGroup(
            com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMirroringEndpointGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an endpoint group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMirroringEndpointGroup(
            com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMirroringEndpointGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an endpoint group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMirroringEndpointGroup(
            com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMirroringEndpointGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists associations in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse>
        listMirroringEndpointGroupAssociations(
            com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMirroringEndpointGroupAssociationsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific association.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>
        getMirroringEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMirroringEndpointGroupAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates an association in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMirroringEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getCreateMirroringEndpointGroupAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates an association.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMirroringEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getUpdateMirroringEndpointGroupAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an association.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMirroringEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getDeleteMirroringEndpointGroupAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployment groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>
        listMirroringDeploymentGroups(
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMirroringDeploymentGroupsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>
        getMirroringDeploymentGroup(
            com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMirroringDeploymentGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMirroringDeploymentGroup(
            com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMirroringDeploymentGroupMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMirroringDeploymentGroup(
            com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMirroringDeploymentGroupMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMirroringDeploymentGroup(
            com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMirroringDeploymentGroupMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>
        listMirroringDeployments(
            com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMirroringDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.MirroringDeployment>
        getMirroringDeployment(
            com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMirroringDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMirroringDeployment(
            com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMirroringDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMirroringDeployment(
            com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMirroringDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMirroringDeployment(
            com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMirroringDeploymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_MIRRORING_ENDPOINT_GROUPS = 0;
  private static final int METHODID_GET_MIRRORING_ENDPOINT_GROUP = 1;
  private static final int METHODID_CREATE_MIRRORING_ENDPOINT_GROUP = 2;
  private static final int METHODID_UPDATE_MIRRORING_ENDPOINT_GROUP = 3;
  private static final int METHODID_DELETE_MIRRORING_ENDPOINT_GROUP = 4;
  private static final int METHODID_LIST_MIRRORING_ENDPOINT_GROUP_ASSOCIATIONS = 5;
  private static final int METHODID_GET_MIRRORING_ENDPOINT_GROUP_ASSOCIATION = 6;
  private static final int METHODID_CREATE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION = 7;
  private static final int METHODID_UPDATE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION = 8;
  private static final int METHODID_DELETE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION = 9;
  private static final int METHODID_LIST_MIRRORING_DEPLOYMENT_GROUPS = 10;
  private static final int METHODID_GET_MIRRORING_DEPLOYMENT_GROUP = 11;
  private static final int METHODID_CREATE_MIRRORING_DEPLOYMENT_GROUP = 12;
  private static final int METHODID_UPDATE_MIRRORING_DEPLOYMENT_GROUP = 13;
  private static final int METHODID_DELETE_MIRRORING_DEPLOYMENT_GROUP = 14;
  private static final int METHODID_LIST_MIRRORING_DEPLOYMENTS = 15;
  private static final int METHODID_GET_MIRRORING_DEPLOYMENT = 16;
  private static final int METHODID_CREATE_MIRRORING_DEPLOYMENT = 17;
  private static final int METHODID_UPDATE_MIRRORING_DEPLOYMENT = 18;
  private static final int METHODID_DELETE_MIRRORING_DEPLOYMENT = 19;

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
        case METHODID_LIST_MIRRORING_ENDPOINT_GROUPS:
          serviceImpl.listMirroringEndpointGroups(
              (com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MIRRORING_ENDPOINT_GROUP:
          serviceImpl.getMirroringEndpointGroup(
              (com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.MirroringEndpointGroup>)
                  responseObserver);
          break;
        case METHODID_CREATE_MIRRORING_ENDPOINT_GROUP:
          serviceImpl.createMirroringEndpointGroup(
              (com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MIRRORING_ENDPOINT_GROUP:
          serviceImpl.updateMirroringEndpointGroup(
              (com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MIRRORING_ENDPOINT_GROUP:
          serviceImpl.deleteMirroringEndpointGroup(
              (com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MIRRORING_ENDPOINT_GROUP_ASSOCIATIONS:
          serviceImpl.listMirroringEndpointGroupAssociations(
              (com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1
                          .ListMirroringEndpointGroupAssociationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MIRRORING_ENDPOINT_GROUP_ASSOCIATION:
          serviceImpl.getMirroringEndpointGroupAssociation(
              (com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>)
                  responseObserver);
          break;
        case METHODID_CREATE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION:
          serviceImpl.createMirroringEndpointGroupAssociation(
              (com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION:
          serviceImpl.updateMirroringEndpointGroupAssociation(
              (com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION:
          serviceImpl.deleteMirroringEndpointGroupAssociation(
              (com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MIRRORING_DEPLOYMENT_GROUPS:
          serviceImpl.listMirroringDeploymentGroups(
              (com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MIRRORING_DEPLOYMENT_GROUP:
          serviceImpl.getMirroringDeploymentGroup(
              (com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>)
                  responseObserver);
          break;
        case METHODID_CREATE_MIRRORING_DEPLOYMENT_GROUP:
          serviceImpl.createMirroringDeploymentGroup(
              (com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MIRRORING_DEPLOYMENT_GROUP:
          serviceImpl.updateMirroringDeploymentGroup(
              (com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MIRRORING_DEPLOYMENT_GROUP:
          serviceImpl.deleteMirroringDeploymentGroup(
              (com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MIRRORING_DEPLOYMENTS:
          serviceImpl.listMirroringDeployments(
              (com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MIRRORING_DEPLOYMENT:
          serviceImpl.getMirroringDeployment(
              (com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.MirroringDeployment>)
                  responseObserver);
          break;
        case METHODID_CREATE_MIRRORING_DEPLOYMENT:
          serviceImpl.createMirroringDeployment(
              (com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MIRRORING_DEPLOYMENT:
          serviceImpl.updateMirroringDeployment(
              (com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MIRRORING_DEPLOYMENT:
          serviceImpl.deleteMirroringDeployment(
              (com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest) request,
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
            getListMirroringEndpointGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest,
                    com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse>(
                    service, METHODID_LIST_MIRRORING_ENDPOINT_GROUPS)))
        .addMethod(
            getGetMirroringEndpointGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest,
                    com.google.cloud.networksecurity.v1.MirroringEndpointGroup>(
                    service, METHODID_GET_MIRRORING_ENDPOINT_GROUP)))
        .addMethod(
            getCreateMirroringEndpointGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_MIRRORING_ENDPOINT_GROUP)))
        .addMethod(
            getUpdateMirroringEndpointGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_MIRRORING_ENDPOINT_GROUP)))
        .addMethod(
            getDeleteMirroringEndpointGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_MIRRORING_ENDPOINT_GROUP)))
        .addMethod(
            getListMirroringEndpointGroupAssociationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1
                        .ListMirroringEndpointGroupAssociationsRequest,
                    com.google.cloud.networksecurity.v1
                        .ListMirroringEndpointGroupAssociationsResponse>(
                    service, METHODID_LIST_MIRRORING_ENDPOINT_GROUP_ASSOCIATIONS)))
        .addMethod(
            getGetMirroringEndpointGroupAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest,
                    com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation>(
                    service, METHODID_GET_MIRRORING_ENDPOINT_GROUP_ASSOCIATION)))
        .addMethod(
            getCreateMirroringEndpointGroupAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1
                        .CreateMirroringEndpointGroupAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION)))
        .addMethod(
            getUpdateMirroringEndpointGroupAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1
                        .UpdateMirroringEndpointGroupAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION)))
        .addMethod(
            getDeleteMirroringEndpointGroupAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1
                        .DeleteMirroringEndpointGroupAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_MIRRORING_ENDPOINT_GROUP_ASSOCIATION)))
        .addMethod(
            getListMirroringDeploymentGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest,
                    com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse>(
                    service, METHODID_LIST_MIRRORING_DEPLOYMENT_GROUPS)))
        .addMethod(
            getGetMirroringDeploymentGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest,
                    com.google.cloud.networksecurity.v1.MirroringDeploymentGroup>(
                    service, METHODID_GET_MIRRORING_DEPLOYMENT_GROUP)))
        .addMethod(
            getCreateMirroringDeploymentGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_MIRRORING_DEPLOYMENT_GROUP)))
        .addMethod(
            getUpdateMirroringDeploymentGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_MIRRORING_DEPLOYMENT_GROUP)))
        .addMethod(
            getDeleteMirroringDeploymentGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_MIRRORING_DEPLOYMENT_GROUP)))
        .addMethod(
            getListMirroringDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest,
                    com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse>(
                    service, METHODID_LIST_MIRRORING_DEPLOYMENTS)))
        .addMethod(
            getGetMirroringDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest,
                    com.google.cloud.networksecurity.v1.MirroringDeployment>(
                    service, METHODID_GET_MIRRORING_DEPLOYMENT)))
        .addMethod(
            getCreateMirroringDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_MIRRORING_DEPLOYMENT)))
        .addMethod(
            getUpdateMirroringDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_MIRRORING_DEPLOYMENT)))
        .addMethod(
            getDeleteMirroringDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_MIRRORING_DEPLOYMENT)))
        .build();
  }

  private abstract static class MirroringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MirroringBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1.MirroringProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Mirroring");
    }
  }

  private static final class MirroringFileDescriptorSupplier
      extends MirroringBaseDescriptorSupplier {
    MirroringFileDescriptorSupplier() {}
  }

  private static final class MirroringMethodDescriptorSupplier
      extends MirroringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MirroringMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MirroringGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MirroringFileDescriptorSupplier())
                      .addMethod(getListMirroringEndpointGroupsMethod())
                      .addMethod(getGetMirroringEndpointGroupMethod())
                      .addMethod(getCreateMirroringEndpointGroupMethod())
                      .addMethod(getUpdateMirroringEndpointGroupMethod())
                      .addMethod(getDeleteMirroringEndpointGroupMethod())
                      .addMethod(getListMirroringEndpointGroupAssociationsMethod())
                      .addMethod(getGetMirroringEndpointGroupAssociationMethod())
                      .addMethod(getCreateMirroringEndpointGroupAssociationMethod())
                      .addMethod(getUpdateMirroringEndpointGroupAssociationMethod())
                      .addMethod(getDeleteMirroringEndpointGroupAssociationMethod())
                      .addMethod(getListMirroringDeploymentGroupsMethod())
                      .addMethod(getGetMirroringDeploymentGroupMethod())
                      .addMethod(getCreateMirroringDeploymentGroupMethod())
                      .addMethod(getUpdateMirroringDeploymentGroupMethod())
                      .addMethod(getDeleteMirroringDeploymentGroupMethod())
                      .addMethod(getListMirroringDeploymentsMethod())
                      .addMethod(getGetMirroringDeploymentMethod())
                      .addMethod(getCreateMirroringDeploymentMethod())
                      .addMethod(getUpdateMirroringDeploymentMethod())
                      .addMethod(getDeleteMirroringDeploymentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
