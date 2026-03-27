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
 * Service for managing Firewall Endpoints and Associations.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class FirewallActivationGrpc {

  private FirewallActivationGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networksecurity.v1.FirewallActivation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest,
          com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>
      getListFirewallEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFirewallEndpoints",
      requestType = com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest,
          com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>
      getListFirewallEndpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest,
            com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>
        getListFirewallEndpointsMethod;
    if ((getListFirewallEndpointsMethod = FirewallActivationGrpc.getListFirewallEndpointsMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getListFirewallEndpointsMethod = FirewallActivationGrpc.getListFirewallEndpointsMethod)
            == null) {
          FirewallActivationGrpc.getListFirewallEndpointsMethod =
              getListFirewallEndpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest,
                          com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFirewallEndpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier("ListFirewallEndpoints"))
                      .build();
        }
      }
    }
    return getListFirewallEndpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest,
          com.google.cloud.networksecurity.v1.FirewallEndpoint>
      getGetFirewallEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFirewallEndpoint",
      requestType = com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest.class,
      responseType = com.google.cloud.networksecurity.v1.FirewallEndpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest,
          com.google.cloud.networksecurity.v1.FirewallEndpoint>
      getGetFirewallEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest,
            com.google.cloud.networksecurity.v1.FirewallEndpoint>
        getGetFirewallEndpointMethod;
    if ((getGetFirewallEndpointMethod = FirewallActivationGrpc.getGetFirewallEndpointMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getGetFirewallEndpointMethod = FirewallActivationGrpc.getGetFirewallEndpointMethod)
            == null) {
          FirewallActivationGrpc.getGetFirewallEndpointMethod =
              getGetFirewallEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest,
                          com.google.cloud.networksecurity.v1.FirewallEndpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFirewallEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.FirewallEndpoint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier("GetFirewallEndpoint"))
                      .build();
        }
      }
    }
    return getGetFirewallEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest,
          com.google.longrunning.Operation>
      getCreateFirewallEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFirewallEndpoint",
      requestType = com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest,
          com.google.longrunning.Operation>
      getCreateFirewallEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest,
            com.google.longrunning.Operation>
        getCreateFirewallEndpointMethod;
    if ((getCreateFirewallEndpointMethod = FirewallActivationGrpc.getCreateFirewallEndpointMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getCreateFirewallEndpointMethod =
                FirewallActivationGrpc.getCreateFirewallEndpointMethod)
            == null) {
          FirewallActivationGrpc.getCreateFirewallEndpointMethod =
              getCreateFirewallEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateFirewallEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier("CreateFirewallEndpoint"))
                      .build();
        }
      }
    }
    return getCreateFirewallEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest,
          com.google.longrunning.Operation>
      getDeleteFirewallEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFirewallEndpoint",
      requestType = com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest,
          com.google.longrunning.Operation>
      getDeleteFirewallEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest,
            com.google.longrunning.Operation>
        getDeleteFirewallEndpointMethod;
    if ((getDeleteFirewallEndpointMethod = FirewallActivationGrpc.getDeleteFirewallEndpointMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getDeleteFirewallEndpointMethod =
                FirewallActivationGrpc.getDeleteFirewallEndpointMethod)
            == null) {
          FirewallActivationGrpc.getDeleteFirewallEndpointMethod =
              getDeleteFirewallEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteFirewallEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier("DeleteFirewallEndpoint"))
                      .build();
        }
      }
    }
    return getDeleteFirewallEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest,
          com.google.longrunning.Operation>
      getUpdateFirewallEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFirewallEndpoint",
      requestType = com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest,
          com.google.longrunning.Operation>
      getUpdateFirewallEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest,
            com.google.longrunning.Operation>
        getUpdateFirewallEndpointMethod;
    if ((getUpdateFirewallEndpointMethod = FirewallActivationGrpc.getUpdateFirewallEndpointMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getUpdateFirewallEndpointMethod =
                FirewallActivationGrpc.getUpdateFirewallEndpointMethod)
            == null) {
          FirewallActivationGrpc.getUpdateFirewallEndpointMethod =
              getUpdateFirewallEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateFirewallEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier("UpdateFirewallEndpoint"))
                      .build();
        }
      }
    }
    return getUpdateFirewallEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest,
          com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse>
      getListFirewallEndpointAssociationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFirewallEndpointAssociations",
      requestType =
          com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest.class,
      responseType =
          com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest,
          com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse>
      getListFirewallEndpointAssociationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest,
            com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse>
        getListFirewallEndpointAssociationsMethod;
    if ((getListFirewallEndpointAssociationsMethod =
            FirewallActivationGrpc.getListFirewallEndpointAssociationsMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getListFirewallEndpointAssociationsMethod =
                FirewallActivationGrpc.getListFirewallEndpointAssociationsMethod)
            == null) {
          FirewallActivationGrpc.getListFirewallEndpointAssociationsMethod =
              getListFirewallEndpointAssociationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest,
                          com.google.cloud.networksecurity.v1
                              .ListFirewallEndpointAssociationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFirewallEndpointAssociations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListFirewallEndpointAssociationsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .ListFirewallEndpointAssociationsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier(
                              "ListFirewallEndpointAssociations"))
                      .build();
        }
      }
    }
    return getListFirewallEndpointAssociationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest,
          com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>
      getGetFirewallEndpointAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFirewallEndpointAssociation",
      requestType = com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest.class,
      responseType = com.google.cloud.networksecurity.v1.FirewallEndpointAssociation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest,
          com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>
      getGetFirewallEndpointAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest,
            com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>
        getGetFirewallEndpointAssociationMethod;
    if ((getGetFirewallEndpointAssociationMethod =
            FirewallActivationGrpc.getGetFirewallEndpointAssociationMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getGetFirewallEndpointAssociationMethod =
                FirewallActivationGrpc.getGetFirewallEndpointAssociationMethod)
            == null) {
          FirewallActivationGrpc.getGetFirewallEndpointAssociationMethod =
              getGetFirewallEndpointAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest,
                          com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFirewallEndpointAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .GetFirewallEndpointAssociationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.FirewallEndpointAssociation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier(
                              "GetFirewallEndpointAssociation"))
                      .build();
        }
      }
    }
    return getGetFirewallEndpointAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest,
          com.google.longrunning.Operation>
      getCreateFirewallEndpointAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFirewallEndpointAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest,
          com.google.longrunning.Operation>
      getCreateFirewallEndpointAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest,
            com.google.longrunning.Operation>
        getCreateFirewallEndpointAssociationMethod;
    if ((getCreateFirewallEndpointAssociationMethod =
            FirewallActivationGrpc.getCreateFirewallEndpointAssociationMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getCreateFirewallEndpointAssociationMethod =
                FirewallActivationGrpc.getCreateFirewallEndpointAssociationMethod)
            == null) {
          FirewallActivationGrpc.getCreateFirewallEndpointAssociationMethod =
              getCreateFirewallEndpointAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .CreateFirewallEndpointAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateFirewallEndpointAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .CreateFirewallEndpointAssociationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier(
                              "CreateFirewallEndpointAssociation"))
                      .build();
        }
      }
    }
    return getCreateFirewallEndpointAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteFirewallEndpointAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFirewallEndpointAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest,
          com.google.longrunning.Operation>
      getDeleteFirewallEndpointAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest,
            com.google.longrunning.Operation>
        getDeleteFirewallEndpointAssociationMethod;
    if ((getDeleteFirewallEndpointAssociationMethod =
            FirewallActivationGrpc.getDeleteFirewallEndpointAssociationMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getDeleteFirewallEndpointAssociationMethod =
                FirewallActivationGrpc.getDeleteFirewallEndpointAssociationMethod)
            == null) {
          FirewallActivationGrpc.getDeleteFirewallEndpointAssociationMethod =
              getDeleteFirewallEndpointAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .DeleteFirewallEndpointAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteFirewallEndpointAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .DeleteFirewallEndpointAssociationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier(
                              "DeleteFirewallEndpointAssociation"))
                      .build();
        }
      }
    }
    return getDeleteFirewallEndpointAssociationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateFirewallEndpointAssociationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFirewallEndpointAssociation",
      requestType =
          com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest,
          com.google.longrunning.Operation>
      getUpdateFirewallEndpointAssociationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest,
            com.google.longrunning.Operation>
        getUpdateFirewallEndpointAssociationMethod;
    if ((getUpdateFirewallEndpointAssociationMethod =
            FirewallActivationGrpc.getUpdateFirewallEndpointAssociationMethod)
        == null) {
      synchronized (FirewallActivationGrpc.class) {
        if ((getUpdateFirewallEndpointAssociationMethod =
                FirewallActivationGrpc.getUpdateFirewallEndpointAssociationMethod)
            == null) {
          FirewallActivationGrpc.getUpdateFirewallEndpointAssociationMethod =
              getUpdateFirewallEndpointAssociationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1
                              .UpdateFirewallEndpointAssociationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateFirewallEndpointAssociation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1
                                  .UpdateFirewallEndpointAssociationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FirewallActivationMethodDescriptorSupplier(
                              "UpdateFirewallEndpointAssociation"))
                      .build();
        }
      }
    }
    return getUpdateFirewallEndpointAssociationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FirewallActivationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirewallActivationStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirewallActivationStub>() {
          @java.lang.Override
          public FirewallActivationStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirewallActivationStub(channel, callOptions);
          }
        };
    return FirewallActivationStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static FirewallActivationBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirewallActivationBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirewallActivationBlockingV2Stub>() {
          @java.lang.Override
          public FirewallActivationBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirewallActivationBlockingV2Stub(channel, callOptions);
          }
        };
    return FirewallActivationBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FirewallActivationBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirewallActivationBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirewallActivationBlockingStub>() {
          @java.lang.Override
          public FirewallActivationBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirewallActivationBlockingStub(channel, callOptions);
          }
        };
    return FirewallActivationBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FirewallActivationFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirewallActivationFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FirewallActivationFutureStub>() {
          @java.lang.Override
          public FirewallActivationFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FirewallActivationFutureStub(channel, callOptions);
          }
        };
    return FirewallActivationFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing Firewall Endpoints and Associations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists FirewallEndpoints in a given organization and location.
     * </pre>
     */
    default void listFirewallEndpoints(
        com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFirewallEndpointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single org Endpoint.
     * </pre>
     */
    default void getFirewallEndpoint(
        com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.FirewallEndpoint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFirewallEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpoint in a given organization and location.
     * </pre>
     */
    default void createFirewallEndpoint(
        com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFirewallEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single org Endpoint.
     * </pre>
     */
    default void deleteFirewallEndpoint(
        com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFirewallEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single org Endpoint.
     * </pre>
     */
    default void updateFirewallEndpoint(
        com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFirewallEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Associations in a given project and location.
     * </pre>
     */
    default void listFirewallEndpointAssociations(
        com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFirewallEndpointAssociationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FirewallEndpointAssociation.
     * </pre>
     */
    default void getFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFirewallEndpointAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpointAssociation in a given project and location.
     * </pre>
     */
    default void createFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFirewallEndpointAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FirewallEndpointAssociation.
     * </pre>
     */
    default void deleteFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFirewallEndpointAssociationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single FirewallEndpointAssociation.
     * </pre>
     */
    default void updateFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFirewallEndpointAssociationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FirewallActivation.
   *
   * <pre>
   * Service for managing Firewall Endpoints and Associations.
   * </pre>
   */
  public abstract static class FirewallActivationImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FirewallActivationGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FirewallActivation.
   *
   * <pre>
   * Service for managing Firewall Endpoints and Associations.
   * </pre>
   */
  public static final class FirewallActivationStub
      extends io.grpc.stub.AbstractAsyncStub<FirewallActivationStub> {
    private FirewallActivationStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirewallActivationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirewallActivationStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists FirewallEndpoints in a given organization and location.
     * </pre>
     */
    public void listFirewallEndpoints(
        com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFirewallEndpointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single org Endpoint.
     * </pre>
     */
    public void getFirewallEndpoint(
        com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.FirewallEndpoint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFirewallEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpoint in a given organization and location.
     * </pre>
     */
    public void createFirewallEndpoint(
        com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFirewallEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single org Endpoint.
     * </pre>
     */
    public void deleteFirewallEndpoint(
        com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFirewallEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single org Endpoint.
     * </pre>
     */
    public void updateFirewallEndpoint(
        com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFirewallEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Associations in a given project and location.
     * </pre>
     */
    public void listFirewallEndpointAssociations(
        com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFirewallEndpointAssociationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FirewallEndpointAssociation.
     * </pre>
     */
    public void getFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFirewallEndpointAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpointAssociation in a given project and location.
     * </pre>
     */
    public void createFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFirewallEndpointAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FirewallEndpointAssociation.
     * </pre>
     */
    public void deleteFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFirewallEndpointAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single FirewallEndpointAssociation.
     * </pre>
     */
    public void updateFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFirewallEndpointAssociationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FirewallActivation.
   *
   * <pre>
   * Service for managing Firewall Endpoints and Associations.
   * </pre>
   */
  public static final class FirewallActivationBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<FirewallActivationBlockingV2Stub> {
    private FirewallActivationBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirewallActivationBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirewallActivationBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists FirewallEndpoints in a given organization and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse listFirewallEndpoints(
        com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFirewallEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single org Endpoint.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.FirewallEndpoint getFirewallEndpoint(
        com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFirewallEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpoint in a given organization and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFirewallEndpoint(
        com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateFirewallEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single org Endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFirewallEndpoint(
        com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteFirewallEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single org Endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation updateFirewallEndpoint(
        com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFirewallEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Associations in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse
        listFirewallEndpointAssociations(
            com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFirewallEndpointAssociationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.FirewallEndpointAssociation
        getFirewallEndpointAssociation(
            com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFirewallEndpointAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpointAssociation in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateFirewallEndpointAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteFirewallEndpointAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.longrunning.Operation updateFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFirewallEndpointAssociationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service FirewallActivation.
   *
   * <pre>
   * Service for managing Firewall Endpoints and Associations.
   * </pre>
   */
  public static final class FirewallActivationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FirewallActivationBlockingStub> {
    private FirewallActivationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirewallActivationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirewallActivationBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists FirewallEndpoints in a given organization and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse listFirewallEndpoints(
        com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFirewallEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single org Endpoint.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.FirewallEndpoint getFirewallEndpoint(
        com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFirewallEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpoint in a given organization and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFirewallEndpoint(
        com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFirewallEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single org Endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFirewallEndpoint(
        com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFirewallEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single org Endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation updateFirewallEndpoint(
        com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFirewallEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Associations in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse
        listFirewallEndpointAssociations(
            com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFirewallEndpointAssociationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.FirewallEndpointAssociation
        getFirewallEndpointAssociation(
            com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFirewallEndpointAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpointAssociation in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFirewallEndpointAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFirewallEndpointAssociationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.longrunning.Operation updateFirewallEndpointAssociation(
        com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFirewallEndpointAssociationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FirewallActivation.
   *
   * <pre>
   * Service for managing Firewall Endpoints and Associations.
   * </pre>
   */
  public static final class FirewallActivationFutureStub
      extends io.grpc.stub.AbstractFutureStub<FirewallActivationFutureStub> {
    private FirewallActivationFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirewallActivationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirewallActivationFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists FirewallEndpoints in a given organization and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>
        listFirewallEndpoints(
            com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFirewallEndpointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single org Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.FirewallEndpoint>
        getFirewallEndpoint(
            com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFirewallEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpoint in a given organization and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFirewallEndpoint(
            com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFirewallEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single org Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFirewallEndpoint(
            com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFirewallEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single org Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFirewallEndpoint(
            com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFirewallEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Associations in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse>
        listFirewallEndpointAssociations(
            com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFirewallEndpointAssociationsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>
        getFirewallEndpointAssociation(
            com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFirewallEndpointAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallEndpointAssociation in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFirewallEndpointAssociation(
            com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFirewallEndpointAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFirewallEndpointAssociation(
            com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFirewallEndpointAssociationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Update a single FirewallEndpointAssociation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFirewallEndpointAssociation(
            com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFirewallEndpointAssociationMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_FIREWALL_ENDPOINTS = 0;
  private static final int METHODID_GET_FIREWALL_ENDPOINT = 1;
  private static final int METHODID_CREATE_FIREWALL_ENDPOINT = 2;
  private static final int METHODID_DELETE_FIREWALL_ENDPOINT = 3;
  private static final int METHODID_UPDATE_FIREWALL_ENDPOINT = 4;
  private static final int METHODID_LIST_FIREWALL_ENDPOINT_ASSOCIATIONS = 5;
  private static final int METHODID_GET_FIREWALL_ENDPOINT_ASSOCIATION = 6;
  private static final int METHODID_CREATE_FIREWALL_ENDPOINT_ASSOCIATION = 7;
  private static final int METHODID_DELETE_FIREWALL_ENDPOINT_ASSOCIATION = 8;
  private static final int METHODID_UPDATE_FIREWALL_ENDPOINT_ASSOCIATION = 9;

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
        case METHODID_LIST_FIREWALL_ENDPOINTS:
          serviceImpl.listFirewallEndpoints(
              (com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FIREWALL_ENDPOINT:
          serviceImpl.getFirewallEndpoint(
              (com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.FirewallEndpoint>)
                  responseObserver);
          break;
        case METHODID_CREATE_FIREWALL_ENDPOINT:
          serviceImpl.createFirewallEndpoint(
              (com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FIREWALL_ENDPOINT:
          serviceImpl.deleteFirewallEndpoint(
              (com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FIREWALL_ENDPOINT:
          serviceImpl.updateFirewallEndpoint(
              (com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_FIREWALL_ENDPOINT_ASSOCIATIONS:
          serviceImpl.listFirewallEndpointAssociations(
              (com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FIREWALL_ENDPOINT_ASSOCIATION:
          serviceImpl.getFirewallEndpointAssociation(
              (com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>)
                  responseObserver);
          break;
        case METHODID_CREATE_FIREWALL_ENDPOINT_ASSOCIATION:
          serviceImpl.createFirewallEndpointAssociation(
              (com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FIREWALL_ENDPOINT_ASSOCIATION:
          serviceImpl.deleteFirewallEndpointAssociation(
              (com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FIREWALL_ENDPOINT_ASSOCIATION:
          serviceImpl.updateFirewallEndpointAssociation(
              (com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest)
                  request,
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
            getListFirewallEndpointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListFirewallEndpointsRequest,
                    com.google.cloud.networksecurity.v1.ListFirewallEndpointsResponse>(
                    service, METHODID_LIST_FIREWALL_ENDPOINTS)))
        .addMethod(
            getGetFirewallEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetFirewallEndpointRequest,
                    com.google.cloud.networksecurity.v1.FirewallEndpoint>(
                    service, METHODID_GET_FIREWALL_ENDPOINT)))
        .addMethod(
            getCreateFirewallEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateFirewallEndpointRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_FIREWALL_ENDPOINT)))
        .addMethod(
            getDeleteFirewallEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteFirewallEndpointRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_FIREWALL_ENDPOINT)))
        .addMethod(
            getUpdateFirewallEndpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateFirewallEndpointRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_FIREWALL_ENDPOINT)))
        .addMethod(
            getListFirewallEndpointAssociationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsRequest,
                    com.google.cloud.networksecurity.v1.ListFirewallEndpointAssociationsResponse>(
                    service, METHODID_LIST_FIREWALL_ENDPOINT_ASSOCIATIONS)))
        .addMethod(
            getGetFirewallEndpointAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetFirewallEndpointAssociationRequest,
                    com.google.cloud.networksecurity.v1.FirewallEndpointAssociation>(
                    service, METHODID_GET_FIREWALL_ENDPOINT_ASSOCIATION)))
        .addMethod(
            getCreateFirewallEndpointAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateFirewallEndpointAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_FIREWALL_ENDPOINT_ASSOCIATION)))
        .addMethod(
            getDeleteFirewallEndpointAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteFirewallEndpointAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_FIREWALL_ENDPOINT_ASSOCIATION)))
        .addMethod(
            getUpdateFirewallEndpointAssociationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateFirewallEndpointAssociationRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_FIREWALL_ENDPOINT_ASSOCIATION)))
        .build();
  }

  private abstract static class FirewallActivationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FirewallActivationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1.FirewallActivationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FirewallActivation");
    }
  }

  private static final class FirewallActivationFileDescriptorSupplier
      extends FirewallActivationBaseDescriptorSupplier {
    FirewallActivationFileDescriptorSupplier() {}
  }

  private static final class FirewallActivationMethodDescriptorSupplier
      extends FirewallActivationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FirewallActivationMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FirewallActivationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FirewallActivationFileDescriptorSupplier())
                      .addMethod(getListFirewallEndpointsMethod())
                      .addMethod(getGetFirewallEndpointMethod())
                      .addMethod(getCreateFirewallEndpointMethod())
                      .addMethod(getDeleteFirewallEndpointMethod())
                      .addMethod(getUpdateFirewallEndpointMethod())
                      .addMethod(getListFirewallEndpointAssociationsMethod())
                      .addMethod(getGetFirewallEndpointAssociationMethod())
                      .addMethod(getCreateFirewallEndpointAssociationMethod())
                      .addMethod(getDeleteFirewallEndpointAssociationMethod())
                      .addMethod(getUpdateFirewallEndpointAssociationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
