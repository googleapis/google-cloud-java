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
 * Service for Third-Party Packet Intercept (TPPI).
 * TPPI is the "in-band" flavor of the Network Security Integrations product.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class InterceptGrpc {

  private InterceptGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.networksecurity.v1.Intercept";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest,
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>
      getListInterceptEndpointGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInterceptEndpointGroups",
      requestType = com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest,
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>
      getListInterceptEndpointGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest,
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>
        getListInterceptEndpointGroupsMethod;
    if ((getListInterceptEndpointGroupsMethod = InterceptGrpc.getListInterceptEndpointGroupsMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getListInterceptEndpointGroupsMethod =
                InterceptGrpc.getListInterceptEndpointGroupsMethod)
            == null) {
          InterceptGrpc.getListInterceptEndpointGroupsMethod =
              getListInterceptEndpointGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest,
                          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListInterceptEndpointGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListInterceptEndpointGroupsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("ListInterceptEndpointGroups"))
                      .build();
        }
      }
    }
    return getListInterceptEndpointGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest,
          com.google.cloud.networksecurity.v1.InterceptEndpointGroup>
      getGetInterceptEndpointGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInterceptEndpointGroup",
      requestType = com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest.class,
      responseType = com.google.cloud.networksecurity.v1.InterceptEndpointGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest,
          com.google.cloud.networksecurity.v1.InterceptEndpointGroup>
      getGetInterceptEndpointGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest,
            com.google.cloud.networksecurity.v1.InterceptEndpointGroup>
        getGetInterceptEndpointGroupMethod;
    if ((getGetInterceptEndpointGroupMethod = InterceptGrpc.getGetInterceptEndpointGroupMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getGetInterceptEndpointGroupMethod = InterceptGrpc.getGetInterceptEndpointGroupMethod)
            == null) {
          InterceptGrpc.getGetInterceptEndpointGroupMethod =
              getGetInterceptEndpointGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest,
                          com.google.cloud.networksecurity.v1.InterceptEndpointGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetInterceptEndpointGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.InterceptEndpointGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("GetInterceptEndpointGroup"))
                      .build();
        }
      }
    }
    return getGetInterceptEndpointGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest,
          com.google.longrunning.Operation>
      getCreateInterceptEndpointGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInterceptEndpointGroup",
      requestType = com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest,
          com.google.longrunning.Operation>
      getCreateInterceptEndpointGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest,
            com.google.longrunning.Operation>
        getCreateInterceptEndpointGroupMethod;
    if ((getCreateInterceptEndpointGroupMethod =
            InterceptGrpc.getCreateInterceptEndpointGroupMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getCreateInterceptEndpointGroupMethod =
                InterceptGrpc.getCreateInterceptEndpointGroupMethod)
            == null) {
          InterceptGrpc.getCreateInterceptEndpointGroupMethod =
              getCreateInterceptEndpointGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateInterceptEndpointGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateInterceptEndpointGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("CreateInterceptEndpointGroup"))
                      .build();
        }
      }
    }
    return getCreateInterceptEndpointGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest,
          com.google.longrunning.Operation>
      getUpdateInterceptEndpointGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInterceptEndpointGroup",
      requestType = com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest,
          com.google.longrunning.Operation>
      getUpdateInterceptEndpointGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest,
            com.google.longrunning.Operation>
        getUpdateInterceptEndpointGroupMethod;
    if ((getUpdateInterceptEndpointGroupMethod =
            InterceptGrpc.getUpdateInterceptEndpointGroupMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getUpdateInterceptEndpointGroupMethod =
                InterceptGrpc.getUpdateInterceptEndpointGroupMethod)
            == null) {
          InterceptGrpc.getUpdateInterceptEndpointGroupMethod =
              getUpdateInterceptEndpointGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateInterceptEndpointGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateInterceptEndpointGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("UpdateInterceptEndpointGroup"))
                      .build();
        }
      }
    }
    return getUpdateInterceptEndpointGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest,
          com.google.longrunning.Operation>
      getDeleteInterceptEndpointGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInterceptEndpointGroup",
      requestType = com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest,
          com.google.longrunning.Operation>
      getDeleteInterceptEndpointGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest,
            com.google.longrunning.Operation>
        getDeleteInterceptEndpointGroupMethod;
    if ((getDeleteInterceptEndpointGroupMethod =
            InterceptGrpc.getDeleteInterceptEndpointGroupMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getDeleteInterceptEndpointGroupMethod =
                InterceptGrpc.getDeleteInterceptEndpointGroupMethod)
            == null) {
          InterceptGrpc.getDeleteInterceptEndpointGroupMethod =
              getDeleteInterceptEndpointGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteInterceptEndpointGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteInterceptEndpointGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("DeleteInterceptEndpointGroup"))
                      .build();
        }
      }
    }
    return getDeleteInterceptEndpointGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest,
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse>
      getListInterceptEndpointGroupAssociationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInterceptEndpointGroupAssociations",
      requestType =
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest.class,
      responseType =
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest,
          com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse>
      getListInterceptEndpointGroupAssociationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest,
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse>
        getListInterceptEndpointGroupAssociationsMethod;
    if ((getListInterceptEndpointGroupAssociationsMethod =
            InterceptGrpc.getListInterceptEndpointGroupAssociationsMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getListInterceptEndpointGroupAssociationsMethod =
                InterceptGrpc.getListInterceptEndpointGroupAssociationsMethod)
            == null) {
          InterceptGrpc.getListInterceptEndpointGroupAssociationsMethod =
              getListInterceptEndpointGroupAssociationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .ListInterceptEndpointGroupAssociationsRequest,
                          com.google.cloud.networksecurity.v1
                              .ListInterceptEndpointGroupAssociationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListInterceptEndpointGroupAssociations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListInterceptEndpointGroupAssociationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListInterceptEndpointGroupAssociationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier(
                              "ListInterceptEndpointGroupAssociations"))
                      .build();
        }
      }
    }
    return getListInterceptEndpointGroupAssociationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest,
          com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>
      getGetInterceptEndpointGroupAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInterceptEndpointGroupAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest.class,
      responseType = com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest,
          com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>
      getGetInterceptEndpointGroupAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest,
            com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>
        getGetInterceptEndpointGroupAssociationMethod;
    if ((getGetInterceptEndpointGroupAssociationMethod =
            InterceptGrpc.getGetInterceptEndpointGroupAssociationMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getGetInterceptEndpointGroupAssociationMethod =
                InterceptGrpc.getGetInterceptEndpointGroupAssociationMethod)
            == null) {
          InterceptGrpc.getGetInterceptEndpointGroupAssociationMethod =
              getGetInterceptEndpointGroupAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .GetInterceptEndpointGroupAssociationRequest,
                          com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetInterceptEndpointGroupAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .GetInterceptEndpointGroupAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier(
                              "GetInterceptEndpointGroupAssociation"))
                      .build();
        }
      }
    }
    return getGetInterceptEndpointGroupAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getCreateInterceptEndpointGroupAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInterceptEndpointGroupAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getCreateInterceptEndpointGroupAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest,
            com.google.longrunning.Operation>
        getCreateInterceptEndpointGroupAssociationMethod;
    if ((getCreateInterceptEndpointGroupAssociationMethod =
            InterceptGrpc.getCreateInterceptEndpointGroupAssociationMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getCreateInterceptEndpointGroupAssociationMethod =
                InterceptGrpc.getCreateInterceptEndpointGroupAssociationMethod)
            == null) {
          InterceptGrpc.getCreateInterceptEndpointGroupAssociationMethod =
              getCreateInterceptEndpointGroupAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .CreateInterceptEndpointGroupAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreateInterceptEndpointGroupAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateInterceptEndpointGroupAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier(
                              "CreateInterceptEndpointGroupAssociation"))
                      .build();
        }
      }
    }
    return getCreateInterceptEndpointGroupAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateInterceptEndpointGroupAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInterceptEndpointGroupAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateInterceptEndpointGroupAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest,
            com.google.longrunning.Operation>
        getUpdateInterceptEndpointGroupAssociationMethod;
    if ((getUpdateInterceptEndpointGroupAssociationMethod =
            InterceptGrpc.getUpdateInterceptEndpointGroupAssociationMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getUpdateInterceptEndpointGroupAssociationMethod =
                InterceptGrpc.getUpdateInterceptEndpointGroupAssociationMethod)
            == null) {
          InterceptGrpc.getUpdateInterceptEndpointGroupAssociationMethod =
              getUpdateInterceptEndpointGroupAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .UpdateInterceptEndpointGroupAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateInterceptEndpointGroupAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateInterceptEndpointGroupAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier(
                              "UpdateInterceptEndpointGroupAssociation"))
                      .build();
        }
      }
    }
    return getUpdateInterceptEndpointGroupAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteInterceptEndpointGroupAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInterceptEndpointGroupAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteInterceptEndpointGroupAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest,
            com.google.longrunning.Operation>
        getDeleteInterceptEndpointGroupAssociationMethod;
    if ((getDeleteInterceptEndpointGroupAssociationMethod =
            InterceptGrpc.getDeleteInterceptEndpointGroupAssociationMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getDeleteInterceptEndpointGroupAssociationMethod =
                InterceptGrpc.getDeleteInterceptEndpointGroupAssociationMethod)
            == null) {
          InterceptGrpc.getDeleteInterceptEndpointGroupAssociationMethod =
              getDeleteInterceptEndpointGroupAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .DeleteInterceptEndpointGroupAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeleteInterceptEndpointGroupAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteInterceptEndpointGroupAssociationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier(
                              "DeleteInterceptEndpointGroupAssociation"))
                      .build();
        }
      }
    }
    return getDeleteInterceptEndpointGroupAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest,
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>
      getListInterceptDeploymentGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInterceptDeploymentGroups",
      requestType = com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest.class,
      responseType =
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest,
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>
      getListInterceptDeploymentGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest,
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>
        getListInterceptDeploymentGroupsMethod;
    if ((getListInterceptDeploymentGroupsMethod =
            InterceptGrpc.getListInterceptDeploymentGroupsMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getListInterceptDeploymentGroupsMethod =
                InterceptGrpc.getListInterceptDeploymentGroupsMethod)
            == null) {
          InterceptGrpc.getListInterceptDeploymentGroupsMethod =
              getListInterceptDeploymentGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest,
                          com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListInterceptDeploymentGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListInterceptDeploymentGroupsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListInterceptDeploymentGroupsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("ListInterceptDeploymentGroups"))
                      .build();
        }
      }
    }
    return getListInterceptDeploymentGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest,
          com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>
      getGetInterceptDeploymentGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInterceptDeploymentGroup",
      requestType = com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest.class,
      responseType = com.google.cloud.networksecurity.v1.InterceptDeploymentGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest,
          com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>
      getGetInterceptDeploymentGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest,
            com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>
        getGetInterceptDeploymentGroupMethod;
    if ((getGetInterceptDeploymentGroupMethod = InterceptGrpc.getGetInterceptDeploymentGroupMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getGetInterceptDeploymentGroupMethod =
                InterceptGrpc.getGetInterceptDeploymentGroupMethod)
            == null) {
          InterceptGrpc.getGetInterceptDeploymentGroupMethod =
              getGetInterceptDeploymentGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest,
                          com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetInterceptDeploymentGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.InterceptDeploymentGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("GetInterceptDeploymentGroup"))
                      .build();
        }
      }
    }
    return getGetInterceptDeploymentGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getCreateInterceptDeploymentGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInterceptDeploymentGroup",
      requestType = com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getCreateInterceptDeploymentGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest,
            com.google.longrunning.Operation>
        getCreateInterceptDeploymentGroupMethod;
    if ((getCreateInterceptDeploymentGroupMethod =
            InterceptGrpc.getCreateInterceptDeploymentGroupMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getCreateInterceptDeploymentGroupMethod =
                InterceptGrpc.getCreateInterceptDeploymentGroupMethod)
            == null) {
          InterceptGrpc.getCreateInterceptDeploymentGroupMethod =
              getCreateInterceptDeploymentGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateInterceptDeploymentGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateInterceptDeploymentGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("CreateInterceptDeploymentGroup"))
                      .build();
        }
      }
    }
    return getCreateInterceptDeploymentGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getUpdateInterceptDeploymentGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInterceptDeploymentGroup",
      requestType = com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getUpdateInterceptDeploymentGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest,
            com.google.longrunning.Operation>
        getUpdateInterceptDeploymentGroupMethod;
    if ((getUpdateInterceptDeploymentGroupMethod =
            InterceptGrpc.getUpdateInterceptDeploymentGroupMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getUpdateInterceptDeploymentGroupMethod =
                InterceptGrpc.getUpdateInterceptDeploymentGroupMethod)
            == null) {
          InterceptGrpc.getUpdateInterceptDeploymentGroupMethod =
              getUpdateInterceptDeploymentGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateInterceptDeploymentGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateInterceptDeploymentGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("UpdateInterceptDeploymentGroup"))
                      .build();
        }
      }
    }
    return getUpdateInterceptDeploymentGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getDeleteInterceptDeploymentGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInterceptDeploymentGroup",
      requestType = com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest,
          com.google.longrunning.Operation>
      getDeleteInterceptDeploymentGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest,
            com.google.longrunning.Operation>
        getDeleteInterceptDeploymentGroupMethod;
    if ((getDeleteInterceptDeploymentGroupMethod =
            InterceptGrpc.getDeleteInterceptDeploymentGroupMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getDeleteInterceptDeploymentGroupMethod =
                InterceptGrpc.getDeleteInterceptDeploymentGroupMethod)
            == null) {
          InterceptGrpc.getDeleteInterceptDeploymentGroupMethod =
              getDeleteInterceptDeploymentGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteInterceptDeploymentGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteInterceptDeploymentGroupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("DeleteInterceptDeploymentGroup"))
                      .build();
        }
      }
    }
    return getDeleteInterceptDeploymentGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest,
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>
      getListInterceptDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInterceptDeployments",
      requestType = com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest,
          com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>
      getListInterceptDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest,
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>
        getListInterceptDeploymentsMethod;
    if ((getListInterceptDeploymentsMethod = InterceptGrpc.getListInterceptDeploymentsMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getListInterceptDeploymentsMethod = InterceptGrpc.getListInterceptDeploymentsMethod)
            == null) {
          InterceptGrpc.getListInterceptDeploymentsMethod =
              getListInterceptDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest,
                          com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListInterceptDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("ListInterceptDeployments"))
                      .build();
        }
      }
    }
    return getListInterceptDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest,
          com.google.cloud.networksecurity.v1.InterceptDeployment>
      getGetInterceptDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInterceptDeployment",
      requestType = com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest.class,
      responseType = com.google.cloud.networksecurity.v1.InterceptDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest,
          com.google.cloud.networksecurity.v1.InterceptDeployment>
      getGetInterceptDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest,
            com.google.cloud.networksecurity.v1.InterceptDeployment>
        getGetInterceptDeploymentMethod;
    if ((getGetInterceptDeploymentMethod = InterceptGrpc.getGetInterceptDeploymentMethod) == null) {
      synchronized (InterceptGrpc.class) {
        if ((getGetInterceptDeploymentMethod = InterceptGrpc.getGetInterceptDeploymentMethod)
            == null) {
          InterceptGrpc.getGetInterceptDeploymentMethod =
              getGetInterceptDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest,
                          com.google.cloud.networksecurity.v1.InterceptDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetInterceptDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.InterceptDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("GetInterceptDeployment"))
                      .build();
        }
      }
    }
    return getGetInterceptDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateInterceptDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInterceptDeployment",
      requestType = com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateInterceptDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest,
            com.google.longrunning.Operation>
        getCreateInterceptDeploymentMethod;
    if ((getCreateInterceptDeploymentMethod = InterceptGrpc.getCreateInterceptDeploymentMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getCreateInterceptDeploymentMethod = InterceptGrpc.getCreateInterceptDeploymentMethod)
            == null) {
          InterceptGrpc.getCreateInterceptDeploymentMethod =
              getCreateInterceptDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateInterceptDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("CreateInterceptDeployment"))
                      .build();
        }
      }
    }
    return getCreateInterceptDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest,
          com.google.longrunning.Operation>
      getUpdateInterceptDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInterceptDeployment",
      requestType = com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest,
          com.google.longrunning.Operation>
      getUpdateInterceptDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest,
            com.google.longrunning.Operation>
        getUpdateInterceptDeploymentMethod;
    if ((getUpdateInterceptDeploymentMethod = InterceptGrpc.getUpdateInterceptDeploymentMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getUpdateInterceptDeploymentMethod = InterceptGrpc.getUpdateInterceptDeploymentMethod)
            == null) {
          InterceptGrpc.getUpdateInterceptDeploymentMethod =
              getUpdateInterceptDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateInterceptDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("UpdateInterceptDeployment"))
                      .build();
        }
      }
    }
    return getUpdateInterceptDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteInterceptDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInterceptDeployment",
      requestType = com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteInterceptDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest,
            com.google.longrunning.Operation>
        getDeleteInterceptDeploymentMethod;
    if ((getDeleteInterceptDeploymentMethod = InterceptGrpc.getDeleteInterceptDeploymentMethod)
        == null) {
      synchronized (InterceptGrpc.class) {
        if ((getDeleteInterceptDeploymentMethod = InterceptGrpc.getDeleteInterceptDeploymentMethod)
            == null) {
          InterceptGrpc.getDeleteInterceptDeploymentMethod =
              getDeleteInterceptDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteInterceptDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InterceptMethodDescriptorSupplier("DeleteInterceptDeployment"))
                      .build();
        }
      }
    }
    return getDeleteInterceptDeploymentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static InterceptStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InterceptStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InterceptStub>() {
          @java.lang.Override
          public InterceptStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InterceptStub(channel, callOptions);
          }
        };
    return InterceptStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static InterceptBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InterceptBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InterceptBlockingV2Stub>() {
          @java.lang.Override
          public InterceptBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InterceptBlockingV2Stub(channel, callOptions);
          }
        };
    return InterceptBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InterceptBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InterceptBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InterceptBlockingStub>() {
          @java.lang.Override
          public InterceptBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InterceptBlockingStub(channel, callOptions);
          }
        };
    return InterceptBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static InterceptFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InterceptFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InterceptFutureStub>() {
          @java.lang.Override
          public InterceptFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InterceptFutureStub(channel, callOptions);
          }
        };
    return InterceptFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for Third-Party Packet Intercept (TPPI).
   * TPPI is the "in-band" flavor of the Network Security Integrations product.
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
    default void listInterceptEndpointGroups(
        com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInterceptEndpointGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific endpoint group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    default void getInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.InterceptEndpointGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInterceptEndpointGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an endpoint group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    default void createInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInterceptEndpointGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an endpoint group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    default void updateInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInterceptEndpointGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an endpoint group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    default void deleteInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInterceptEndpointGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists associations in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    default void listInterceptEndpointGroupAssociations(
        com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInterceptEndpointGroupAssociationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific association.
     * See https://google.aip.dev/131.
     * </pre>
     */
    default void getInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInterceptEndpointGroupAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an association in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    default void createInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInterceptEndpointGroupAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an association.
     * See https://google.aip.dev/134.
     * </pre>
     */
    default void updateInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInterceptEndpointGroupAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an association.
     * See https://google.aip.dev/135.
     * </pre>
     */
    default void deleteInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInterceptEndpointGroupAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists deployment groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    default void listInterceptDeploymentGroups(
        com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInterceptDeploymentGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    default void getInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInterceptDeploymentGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    default void createInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInterceptDeploymentGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    default void updateInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInterceptDeploymentGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    default void deleteInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInterceptDeploymentGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    default void listInterceptDeployments(
        com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInterceptDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment.
     * See https://google.aip.dev/131.
     * </pre>
     */
    default void getInterceptDeployment(
        com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.InterceptDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInterceptDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    default void createInterceptDeployment(
        com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInterceptDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * See https://google.aip.dev/134.
     * </pre>
     */
    default void updateInterceptDeployment(
        com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInterceptDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment.
     * See https://google.aip.dev/135.
     * </pre>
     */
    default void deleteInterceptDeployment(
        com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInterceptDeploymentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Intercept.
   *
   * <pre>
   * Service for Third-Party Packet Intercept (TPPI).
   * TPPI is the "in-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public abstract static class InterceptImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return InterceptGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Intercept.
   *
   * <pre>
   * Service for Third-Party Packet Intercept (TPPI).
   * TPPI is the "in-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public static final class InterceptStub extends io.grpc.stub.AbstractAsyncStub<InterceptStub> {
    private InterceptStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InterceptStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InterceptStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists endpoint groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public void listInterceptEndpointGroups(
        com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInterceptEndpointGroupsMethod(), getCallOptions()),
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
    public void getInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.InterceptEndpointGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInterceptEndpointGroupMethod(), getCallOptions()),
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
    public void createInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInterceptEndpointGroupMethod(), getCallOptions()),
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
    public void updateInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInterceptEndpointGroupMethod(), getCallOptions()),
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
    public void deleteInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInterceptEndpointGroupMethod(), getCallOptions()),
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
    public void listInterceptEndpointGroupAssociations(
        com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInterceptEndpointGroupAssociationsMethod(), getCallOptions()),
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
    public void getInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInterceptEndpointGroupAssociationMethod(), getCallOptions()),
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
    public void createInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getCreateInterceptEndpointGroupAssociationMethod(), getCallOptions()),
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
    public void updateInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getUpdateInterceptEndpointGroupAssociationMethod(), getCallOptions()),
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
    public void deleteInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getDeleteInterceptEndpointGroupAssociationMethod(), getCallOptions()),
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
    public void listInterceptDeploymentGroups(
        com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInterceptDeploymentGroupsMethod(), getCallOptions()),
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
    public void getInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInterceptDeploymentGroupMethod(), getCallOptions()),
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
    public void createInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInterceptDeploymentGroupMethod(), getCallOptions()),
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
    public void updateInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInterceptDeploymentGroupMethod(), getCallOptions()),
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
    public void deleteInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInterceptDeploymentGroupMethod(), getCallOptions()),
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
    public void listInterceptDeployments(
        com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInterceptDeploymentsMethod(), getCallOptions()),
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
    public void getInterceptDeployment(
        com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.InterceptDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInterceptDeploymentMethod(), getCallOptions()),
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
    public void createInterceptDeployment(
        com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInterceptDeploymentMethod(), getCallOptions()),
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
    public void updateInterceptDeployment(
        com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInterceptDeploymentMethod(), getCallOptions()),
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
    public void deleteInterceptDeployment(
        com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInterceptDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Intercept.
   *
   * <pre>
   * Service for Third-Party Packet Intercept (TPPI).
   * TPPI is the "in-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public static final class InterceptBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<InterceptBlockingV2Stub> {
    private InterceptBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InterceptBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InterceptBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists endpoint groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse
        listInterceptEndpointGroups(
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListInterceptEndpointGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific endpoint group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.InterceptEndpointGroup getInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetInterceptEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an endpoint group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateInterceptEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an endpoint group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateInterceptEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an endpoint group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteInterceptEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists associations in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse
        listInterceptEndpointGroupAssociations(
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest
                request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getListInterceptEndpointGroupAssociationsMethod(),
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
    public com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation
        getInterceptEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetInterceptEndpointGroupAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an association in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getCreateInterceptEndpointGroupAssociationMethod(),
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
    public com.google.longrunning.Operation updateInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getUpdateInterceptEndpointGroupAssociationMethod(),
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
    public com.google.longrunning.Operation deleteInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getDeleteInterceptEndpointGroupAssociationMethod(),
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
    public com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse
        listInterceptDeploymentGroups(
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListInterceptDeploymentGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.InterceptDeploymentGroup getInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetInterceptDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateInterceptDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateInterceptDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteInterceptDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse
        listInterceptDeployments(
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListInterceptDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.InterceptDeployment getInterceptDeployment(
        com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetInterceptDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createInterceptDeployment(
        com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateInterceptDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateInterceptDeployment(
        com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateInterceptDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInterceptDeployment(
        com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteInterceptDeploymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Intercept.
   *
   * <pre>
   * Service for Third-Party Packet Intercept (TPPI).
   * TPPI is the "in-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public static final class InterceptBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InterceptBlockingStub> {
    private InterceptBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InterceptBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InterceptBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists endpoint groups in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse
        listInterceptEndpointGroups(
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInterceptEndpointGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific endpoint group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.InterceptEndpointGroup getInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInterceptEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an endpoint group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInterceptEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an endpoint group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInterceptEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an endpoint group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInterceptEndpointGroup(
        com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInterceptEndpointGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists associations in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse
        listInterceptEndpointGroupAssociations(
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListInterceptEndpointGroupAssociationsMethod(),
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
    public com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation
        getInterceptEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInterceptEndpointGroupAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an association in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getCreateInterceptEndpointGroupAssociationMethod(),
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
    public com.google.longrunning.Operation updateInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getUpdateInterceptEndpointGroupAssociationMethod(),
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
    public com.google.longrunning.Operation deleteInterceptEndpointGroupAssociation(
        com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getDeleteInterceptEndpointGroupAssociationMethod(),
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
    public com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse
        listInterceptDeploymentGroups(
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInterceptDeploymentGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment group.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.InterceptDeploymentGroup getInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInterceptDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment group in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInterceptDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment group.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInterceptDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment group.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInterceptDeploymentGroup(
        com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInterceptDeploymentGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists deployments in a given project and location.
     * See https://google.aip.dev/132.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse
        listInterceptDeployments(
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInterceptDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific deployment.
     * See https://google.aip.dev/131.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.InterceptDeployment getInterceptDeployment(
        com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInterceptDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a deployment in a given project and location.
     * See https://google.aip.dev/133.
     * </pre>
     */
    public com.google.longrunning.Operation createInterceptDeployment(
        com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInterceptDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a deployment.
     * See https://google.aip.dev/134.
     * </pre>
     */
    public com.google.longrunning.Operation updateInterceptDeployment(
        com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInterceptDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a deployment.
     * See https://google.aip.dev/135.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInterceptDeployment(
        com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInterceptDeploymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Intercept.
   *
   * <pre>
   * Service for Third-Party Packet Intercept (TPPI).
   * TPPI is the "in-band" flavor of the Network Security Integrations product.
   * </pre>
   */
  public static final class InterceptFutureStub
      extends io.grpc.stub.AbstractFutureStub<InterceptFutureStub> {
    private InterceptFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InterceptFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InterceptFutureStub(channel, callOptions);
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
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>
        listInterceptEndpointGroups(
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInterceptEndpointGroupsMethod(), getCallOptions()), request);
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
            com.google.cloud.networksecurity.v1.InterceptEndpointGroup>
        getInterceptEndpointGroup(
            com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInterceptEndpointGroupMethod(), getCallOptions()), request);
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
        createInterceptEndpointGroup(
            com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInterceptEndpointGroupMethod(), getCallOptions()), request);
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
        updateInterceptEndpointGroup(
            com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInterceptEndpointGroupMethod(), getCallOptions()), request);
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
        deleteInterceptEndpointGroup(
            com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInterceptEndpointGroupMethod(), getCallOptions()), request);
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
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse>
        listInterceptEndpointGroupAssociations(
            com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInterceptEndpointGroupAssociationsMethod(), getCallOptions()),
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
            com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>
        getInterceptEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInterceptEndpointGroupAssociationMethod(), getCallOptions()),
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
        createInterceptEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getCreateInterceptEndpointGroupAssociationMethod(), getCallOptions()),
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
        updateInterceptEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getUpdateInterceptEndpointGroupAssociationMethod(), getCallOptions()),
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
        deleteInterceptEndpointGroupAssociation(
            com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getDeleteInterceptEndpointGroupAssociationMethod(), getCallOptions()),
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
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>
        listInterceptDeploymentGroups(
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInterceptDeploymentGroupsMethod(), getCallOptions()),
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
            com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>
        getInterceptDeploymentGroup(
            com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInterceptDeploymentGroupMethod(), getCallOptions()), request);
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
        createInterceptDeploymentGroup(
            com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInterceptDeploymentGroupMethod(), getCallOptions()),
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
        updateInterceptDeploymentGroup(
            com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInterceptDeploymentGroupMethod(), getCallOptions()),
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
        deleteInterceptDeploymentGroup(
            com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInterceptDeploymentGroupMethod(), getCallOptions()),
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
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>
        listInterceptDeployments(
            com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInterceptDeploymentsMethod(), getCallOptions()), request);
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
            com.google.cloud.networksecurity.v1.InterceptDeployment>
        getInterceptDeployment(
            com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInterceptDeploymentMethod(), getCallOptions()), request);
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
        createInterceptDeployment(
            com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInterceptDeploymentMethod(), getCallOptions()), request);
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
        updateInterceptDeployment(
            com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInterceptDeploymentMethod(), getCallOptions()), request);
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
        deleteInterceptDeployment(
            com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInterceptDeploymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INTERCEPT_ENDPOINT_GROUPS = 0;
  private static final int METHODID_GET_INTERCEPT_ENDPOINT_GROUP = 1;
  private static final int METHODID_CREATE_INTERCEPT_ENDPOINT_GROUP = 2;
  private static final int METHODID_UPDATE_INTERCEPT_ENDPOINT_GROUP = 3;
  private static final int METHODID_DELETE_INTERCEPT_ENDPOINT_GROUP = 4;
  private static final int METHODID_LIST_INTERCEPT_ENDPOINT_GROUP_ASSOCIATIONS = 5;
  private static final int METHODID_GET_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION = 6;
  private static final int METHODID_CREATE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION = 7;
  private static final int METHODID_UPDATE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION = 8;
  private static final int METHODID_DELETE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION = 9;
  private static final int METHODID_LIST_INTERCEPT_DEPLOYMENT_GROUPS = 10;
  private static final int METHODID_GET_INTERCEPT_DEPLOYMENT_GROUP = 11;
  private static final int METHODID_CREATE_INTERCEPT_DEPLOYMENT_GROUP = 12;
  private static final int METHODID_UPDATE_INTERCEPT_DEPLOYMENT_GROUP = 13;
  private static final int METHODID_DELETE_INTERCEPT_DEPLOYMENT_GROUP = 14;
  private static final int METHODID_LIST_INTERCEPT_DEPLOYMENTS = 15;
  private static final int METHODID_GET_INTERCEPT_DEPLOYMENT = 16;
  private static final int METHODID_CREATE_INTERCEPT_DEPLOYMENT = 17;
  private static final int METHODID_UPDATE_INTERCEPT_DEPLOYMENT = 18;
  private static final int METHODID_DELETE_INTERCEPT_DEPLOYMENT = 19;

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
        case METHODID_LIST_INTERCEPT_ENDPOINT_GROUPS:
          serviceImpl.listInterceptEndpointGroups(
              (com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INTERCEPT_ENDPOINT_GROUP:
          serviceImpl.getInterceptEndpointGroup(
              (com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.InterceptEndpointGroup>)
                  responseObserver);
          break;
        case METHODID_CREATE_INTERCEPT_ENDPOINT_GROUP:
          serviceImpl.createInterceptEndpointGroup(
              (com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INTERCEPT_ENDPOINT_GROUP:
          serviceImpl.updateInterceptEndpointGroup(
              (com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INTERCEPT_ENDPOINT_GROUP:
          serviceImpl.deleteInterceptEndpointGroup(
              (com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INTERCEPT_ENDPOINT_GROUP_ASSOCIATIONS:
          serviceImpl.listInterceptEndpointGroupAssociations(
              (com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1
                          .ListInterceptEndpointGroupAssociationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION:
          serviceImpl.getInterceptEndpointGroupAssociation(
              (com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>)
                  responseObserver);
          break;
        case METHODID_CREATE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION:
          serviceImpl.createInterceptEndpointGroupAssociation(
              (com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION:
          serviceImpl.updateInterceptEndpointGroupAssociation(
              (com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION:
          serviceImpl.deleteInterceptEndpointGroupAssociation(
              (com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INTERCEPT_DEPLOYMENT_GROUPS:
          serviceImpl.listInterceptDeploymentGroups(
              (com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INTERCEPT_DEPLOYMENT_GROUP:
          serviceImpl.getInterceptDeploymentGroup(
              (com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>)
                  responseObserver);
          break;
        case METHODID_CREATE_INTERCEPT_DEPLOYMENT_GROUP:
          serviceImpl.createInterceptDeploymentGroup(
              (com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INTERCEPT_DEPLOYMENT_GROUP:
          serviceImpl.updateInterceptDeploymentGroup(
              (com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INTERCEPT_DEPLOYMENT_GROUP:
          serviceImpl.deleteInterceptDeploymentGroup(
              (com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INTERCEPT_DEPLOYMENTS:
          serviceImpl.listInterceptDeployments(
              (com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INTERCEPT_DEPLOYMENT:
          serviceImpl.getInterceptDeployment(
              (com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.InterceptDeployment>)
                  responseObserver);
          break;
        case METHODID_CREATE_INTERCEPT_DEPLOYMENT:
          serviceImpl.createInterceptDeployment(
              (com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INTERCEPT_DEPLOYMENT:
          serviceImpl.updateInterceptDeployment(
              (com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INTERCEPT_DEPLOYMENT:
          serviceImpl.deleteInterceptDeployment(
              (com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest) request,
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
            getListInterceptEndpointGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest,
                    com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse>(
                    service, METHODID_LIST_INTERCEPT_ENDPOINT_GROUPS)))
        .addMethod(
            getGetInterceptEndpointGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest,
                    com.google.cloud.networksecurity.v1.InterceptEndpointGroup>(
                    service, METHODID_GET_INTERCEPT_ENDPOINT_GROUP)))
        .addMethod(
            getCreateInterceptEndpointGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_INTERCEPT_ENDPOINT_GROUP)))
        .addMethod(
            getUpdateInterceptEndpointGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_INTERCEPT_ENDPOINT_GROUP)))
        .addMethod(
            getDeleteInterceptEndpointGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_INTERCEPT_ENDPOINT_GROUP)))
        .addMethod(
            getListInterceptEndpointGroupAssociationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1
                        .ListInterceptEndpointGroupAssociationsRequest,
                    com.google.cloud.networksecurity.v1
                        .ListInterceptEndpointGroupAssociationsResponse>(
                    service, METHODID_LIST_INTERCEPT_ENDPOINT_GROUP_ASSOCIATIONS)))
        .addMethod(
            getGetInterceptEndpointGroupAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest,
                    com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation>(
                    service, METHODID_GET_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION)))
        .addMethod(
            getCreateInterceptEndpointGroupAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1
                        .CreateInterceptEndpointGroupAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION)))
        .addMethod(
            getUpdateInterceptEndpointGroupAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1
                        .UpdateInterceptEndpointGroupAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION)))
        .addMethod(
            getDeleteInterceptEndpointGroupAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1
                        .DeleteInterceptEndpointGroupAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION)))
        .addMethod(
            getListInterceptDeploymentGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest,
                    com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse>(
                    service, METHODID_LIST_INTERCEPT_DEPLOYMENT_GROUPS)))
        .addMethod(
            getGetInterceptDeploymentGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest,
                    com.google.cloud.networksecurity.v1.InterceptDeploymentGroup>(
                    service, METHODID_GET_INTERCEPT_DEPLOYMENT_GROUP)))
        .addMethod(
            getCreateInterceptDeploymentGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_INTERCEPT_DEPLOYMENT_GROUP)))
        .addMethod(
            getUpdateInterceptDeploymentGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_INTERCEPT_DEPLOYMENT_GROUP)))
        .addMethod(
            getDeleteInterceptDeploymentGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_INTERCEPT_DEPLOYMENT_GROUP)))
        .addMethod(
            getListInterceptDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest,
                    com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse>(
                    service, METHODID_LIST_INTERCEPT_DEPLOYMENTS)))
        .addMethod(
            getGetInterceptDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest,
                    com.google.cloud.networksecurity.v1.InterceptDeployment>(
                    service, METHODID_GET_INTERCEPT_DEPLOYMENT)))
        .addMethod(
            getCreateInterceptDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_INTERCEPT_DEPLOYMENT)))
        .addMethod(
            getUpdateInterceptDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_INTERCEPT_DEPLOYMENT)))
        .addMethod(
            getDeleteInterceptDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_INTERCEPT_DEPLOYMENT)))
        .build();
  }

  private abstract static class InterceptBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InterceptBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1.InterceptProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Intercept");
    }
  }

  private static final class InterceptFileDescriptorSupplier
      extends InterceptBaseDescriptorSupplier {
    InterceptFileDescriptorSupplier() {}
  }

  private static final class InterceptMethodDescriptorSupplier
      extends InterceptBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InterceptMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InterceptGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new InterceptFileDescriptorSupplier())
                      .addMethod(getListInterceptEndpointGroupsMethod())
                      .addMethod(getGetInterceptEndpointGroupMethod())
                      .addMethod(getCreateInterceptEndpointGroupMethod())
                      .addMethod(getUpdateInterceptEndpointGroupMethod())
                      .addMethod(getDeleteInterceptEndpointGroupMethod())
                      .addMethod(getListInterceptEndpointGroupAssociationsMethod())
                      .addMethod(getGetInterceptEndpointGroupAssociationMethod())
                      .addMethod(getCreateInterceptEndpointGroupAssociationMethod())
                      .addMethod(getUpdateInterceptEndpointGroupAssociationMethod())
                      .addMethod(getDeleteInterceptEndpointGroupAssociationMethod())
                      .addMethod(getListInterceptDeploymentGroupsMethod())
                      .addMethod(getGetInterceptDeploymentGroupMethod())
                      .addMethod(getCreateInterceptDeploymentGroupMethod())
                      .addMethod(getUpdateInterceptDeploymentGroupMethod())
                      .addMethod(getDeleteInterceptDeploymentGroupMethod())
                      .addMethod(getListInterceptDeploymentsMethod())
                      .addMethod(getGetInterceptDeploymentMethod())
                      .addMethod(getCreateInterceptDeploymentMethod())
                      .addMethod(getUpdateInterceptDeploymentMethod())
                      .addMethod(getDeleteInterceptDeploymentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
