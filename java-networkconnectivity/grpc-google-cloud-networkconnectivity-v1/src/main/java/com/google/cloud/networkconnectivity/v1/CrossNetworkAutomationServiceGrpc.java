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
package com.google.cloud.networkconnectivity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service for CrossNetworkAutomation resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkconnectivity/v1/cross_network_automation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CrossNetworkAutomationServiceGrpc {

  private CrossNetworkAutomationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest,
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>
      getListServiceConnectionMapsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceConnectionMaps",
      requestType = com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest.class,
      responseType =
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest,
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>
      getListServiceConnectionMapsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest,
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>
        getListServiceConnectionMapsMethod;
    if ((getListServiceConnectionMapsMethod =
            CrossNetworkAutomationServiceGrpc.getListServiceConnectionMapsMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getListServiceConnectionMapsMethod =
                CrossNetworkAutomationServiceGrpc.getListServiceConnectionMapsMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getListServiceConnectionMapsMethod =
              getListServiceConnectionMapsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest,
                          com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListServiceConnectionMaps"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListServiceConnectionMapsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListServiceConnectionMapsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "ListServiceConnectionMaps"))
                      .build();
        }
      }
    }
    return getListServiceConnectionMapsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest,
          com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>
      getGetServiceConnectionMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceConnectionMap",
      requestType = com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.ServiceConnectionMap.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest,
          com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>
      getGetServiceConnectionMapMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest,
            com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>
        getGetServiceConnectionMapMethod;
    if ((getGetServiceConnectionMapMethod =
            CrossNetworkAutomationServiceGrpc.getGetServiceConnectionMapMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getGetServiceConnectionMapMethod =
                CrossNetworkAutomationServiceGrpc.getGetServiceConnectionMapMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getGetServiceConnectionMapMethod =
              getGetServiceConnectionMapMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest,
                          com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetServiceConnectionMap"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ServiceConnectionMap
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "GetServiceConnectionMap"))
                      .build();
        }
      }
    }
    return getGetServiceConnectionMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest,
          com.google.longrunning.Operation>
      getCreateServiceConnectionMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceConnectionMap",
      requestType = com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest,
          com.google.longrunning.Operation>
      getCreateServiceConnectionMapMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest,
            com.google.longrunning.Operation>
        getCreateServiceConnectionMapMethod;
    if ((getCreateServiceConnectionMapMethod =
            CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionMapMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getCreateServiceConnectionMapMethod =
                CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionMapMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionMapMethod =
              getCreateServiceConnectionMapMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateServiceConnectionMap"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .CreateServiceConnectionMapRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "CreateServiceConnectionMap"))
                      .build();
        }
      }
    }
    return getCreateServiceConnectionMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest,
          com.google.longrunning.Operation>
      getUpdateServiceConnectionMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServiceConnectionMap",
      requestType = com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest,
          com.google.longrunning.Operation>
      getUpdateServiceConnectionMapMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest,
            com.google.longrunning.Operation>
        getUpdateServiceConnectionMapMethod;
    if ((getUpdateServiceConnectionMapMethod =
            CrossNetworkAutomationServiceGrpc.getUpdateServiceConnectionMapMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getUpdateServiceConnectionMapMethod =
                CrossNetworkAutomationServiceGrpc.getUpdateServiceConnectionMapMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getUpdateServiceConnectionMapMethod =
              getUpdateServiceConnectionMapMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateServiceConnectionMap"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .UpdateServiceConnectionMapRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "UpdateServiceConnectionMap"))
                      .build();
        }
      }
    }
    return getUpdateServiceConnectionMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest,
          com.google.longrunning.Operation>
      getDeleteServiceConnectionMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceConnectionMap",
      requestType = com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest,
          com.google.longrunning.Operation>
      getDeleteServiceConnectionMapMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest,
            com.google.longrunning.Operation>
        getDeleteServiceConnectionMapMethod;
    if ((getDeleteServiceConnectionMapMethod =
            CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionMapMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getDeleteServiceConnectionMapMethod =
                CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionMapMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionMapMethod =
              getDeleteServiceConnectionMapMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteServiceConnectionMap"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .DeleteServiceConnectionMapRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "DeleteServiceConnectionMap"))
                      .build();
        }
      }
    }
    return getDeleteServiceConnectionMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest,
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse>
      getListServiceConnectionPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceConnectionPolicies",
      requestType =
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest.class,
      responseType =
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest,
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse>
      getListServiceConnectionPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest,
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse>
        getListServiceConnectionPoliciesMethod;
    if ((getListServiceConnectionPoliciesMethod =
            CrossNetworkAutomationServiceGrpc.getListServiceConnectionPoliciesMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getListServiceConnectionPoliciesMethod =
                CrossNetworkAutomationServiceGrpc.getListServiceConnectionPoliciesMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getListServiceConnectionPoliciesMethod =
              getListServiceConnectionPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .ListServiceConnectionPoliciesRequest,
                          com.google.cloud.networkconnectivity.v1
                              .ListServiceConnectionPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListServiceConnectionPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListServiceConnectionPoliciesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListServiceConnectionPoliciesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "ListServiceConnectionPolicies"))
                      .build();
        }
      }
    }
    return getListServiceConnectionPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest,
          com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>
      getGetServiceConnectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceConnectionPolicy",
      requestType = com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest,
          com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>
      getGetServiceConnectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest,
            com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>
        getGetServiceConnectionPolicyMethod;
    if ((getGetServiceConnectionPolicyMethod =
            CrossNetworkAutomationServiceGrpc.getGetServiceConnectionPolicyMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getGetServiceConnectionPolicyMethod =
                CrossNetworkAutomationServiceGrpc.getGetServiceConnectionPolicyMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getGetServiceConnectionPolicyMethod =
              getGetServiceConnectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest,
                          com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetServiceConnectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .GetServiceConnectionPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "GetServiceConnectionPolicy"))
                      .build();
        }
      }
    }
    return getGetServiceConnectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest,
          com.google.longrunning.Operation>
      getCreateServiceConnectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceConnectionPolicy",
      requestType =
          com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest,
          com.google.longrunning.Operation>
      getCreateServiceConnectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest,
            com.google.longrunning.Operation>
        getCreateServiceConnectionPolicyMethod;
    if ((getCreateServiceConnectionPolicyMethod =
            CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionPolicyMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getCreateServiceConnectionPolicyMethod =
                CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionPolicyMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionPolicyMethod =
              getCreateServiceConnectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .CreateServiceConnectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateServiceConnectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .CreateServiceConnectionPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "CreateServiceConnectionPolicy"))
                      .build();
        }
      }
    }
    return getCreateServiceConnectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateServiceConnectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServiceConnectionPolicy",
      requestType =
          com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateServiceConnectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateServiceConnectionPolicyMethod;
    if ((getUpdateServiceConnectionPolicyMethod =
            CrossNetworkAutomationServiceGrpc.getUpdateServiceConnectionPolicyMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getUpdateServiceConnectionPolicyMethod =
                CrossNetworkAutomationServiceGrpc.getUpdateServiceConnectionPolicyMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getUpdateServiceConnectionPolicyMethod =
              getUpdateServiceConnectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .UpdateServiceConnectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateServiceConnectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .UpdateServiceConnectionPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "UpdateServiceConnectionPolicy"))
                      .build();
        }
      }
    }
    return getUpdateServiceConnectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteServiceConnectionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceConnectionPolicy",
      requestType =
          com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteServiceConnectionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteServiceConnectionPolicyMethod;
    if ((getDeleteServiceConnectionPolicyMethod =
            CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionPolicyMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getDeleteServiceConnectionPolicyMethod =
                CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionPolicyMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionPolicyMethod =
              getDeleteServiceConnectionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1
                              .DeleteServiceConnectionPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteServiceConnectionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .DeleteServiceConnectionPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "DeleteServiceConnectionPolicy"))
                      .build();
        }
      }
    }
    return getDeleteServiceConnectionPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest,
          com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>
      getListServiceClassesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceClasses",
      requestType = com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest,
          com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>
      getListServiceClassesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest,
            com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>
        getListServiceClassesMethod;
    if ((getListServiceClassesMethod =
            CrossNetworkAutomationServiceGrpc.getListServiceClassesMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getListServiceClassesMethod =
                CrossNetworkAutomationServiceGrpc.getListServiceClassesMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getListServiceClassesMethod =
              getListServiceClassesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest,
                          com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServiceClasses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "ListServiceClasses"))
                      .build();
        }
      }
    }
    return getListServiceClassesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetServiceClassRequest,
          com.google.cloud.networkconnectivity.v1.ServiceClass>
      getGetServiceClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceClass",
      requestType = com.google.cloud.networkconnectivity.v1.GetServiceClassRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.ServiceClass.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetServiceClassRequest,
          com.google.cloud.networkconnectivity.v1.ServiceClass>
      getGetServiceClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.GetServiceClassRequest,
            com.google.cloud.networkconnectivity.v1.ServiceClass>
        getGetServiceClassMethod;
    if ((getGetServiceClassMethod = CrossNetworkAutomationServiceGrpc.getGetServiceClassMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getGetServiceClassMethod = CrossNetworkAutomationServiceGrpc.getGetServiceClassMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getGetServiceClassMethod =
              getGetServiceClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.GetServiceClassRequest,
                          com.google.cloud.networkconnectivity.v1.ServiceClass>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.GetServiceClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ServiceClass
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "GetServiceClass"))
                      .build();
        }
      }
    }
    return getGetServiceClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest,
          com.google.longrunning.Operation>
      getUpdateServiceClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServiceClass",
      requestType = com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest,
          com.google.longrunning.Operation>
      getUpdateServiceClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest,
            com.google.longrunning.Operation>
        getUpdateServiceClassMethod;
    if ((getUpdateServiceClassMethod =
            CrossNetworkAutomationServiceGrpc.getUpdateServiceClassMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getUpdateServiceClassMethod =
                CrossNetworkAutomationServiceGrpc.getUpdateServiceClassMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getUpdateServiceClassMethod =
              getUpdateServiceClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateServiceClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "UpdateServiceClass"))
                      .build();
        }
      }
    }
    return getUpdateServiceClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest,
          com.google.longrunning.Operation>
      getDeleteServiceClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceClass",
      requestType = com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest,
          com.google.longrunning.Operation>
      getDeleteServiceClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest,
            com.google.longrunning.Operation>
        getDeleteServiceClassMethod;
    if ((getDeleteServiceClassMethod =
            CrossNetworkAutomationServiceGrpc.getDeleteServiceClassMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getDeleteServiceClassMethod =
                CrossNetworkAutomationServiceGrpc.getDeleteServiceClassMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getDeleteServiceClassMethod =
              getDeleteServiceClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteServiceClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "DeleteServiceClass"))
                      .build();
        }
      }
    }
    return getDeleteServiceClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest,
          com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>
      getGetServiceConnectionTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceConnectionToken",
      requestType = com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.ServiceConnectionToken.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest,
          com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>
      getGetServiceConnectionTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest,
            com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>
        getGetServiceConnectionTokenMethod;
    if ((getGetServiceConnectionTokenMethod =
            CrossNetworkAutomationServiceGrpc.getGetServiceConnectionTokenMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getGetServiceConnectionTokenMethod =
                CrossNetworkAutomationServiceGrpc.getGetServiceConnectionTokenMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getGetServiceConnectionTokenMethod =
              getGetServiceConnectionTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest,
                          com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetServiceConnectionToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .GetServiceConnectionTokenRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ServiceConnectionToken
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "GetServiceConnectionToken"))
                      .build();
        }
      }
    }
    return getGetServiceConnectionTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest,
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse>
      getListServiceConnectionTokensMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceConnectionTokens",
      requestType =
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest.class,
      responseType =
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest,
          com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse>
      getListServiceConnectionTokensMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest,
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse>
        getListServiceConnectionTokensMethod;
    if ((getListServiceConnectionTokensMethod =
            CrossNetworkAutomationServiceGrpc.getListServiceConnectionTokensMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getListServiceConnectionTokensMethod =
                CrossNetworkAutomationServiceGrpc.getListServiceConnectionTokensMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getListServiceConnectionTokensMethod =
              getListServiceConnectionTokensMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest,
                          com.google.cloud.networkconnectivity.v1
                              .ListServiceConnectionTokensResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListServiceConnectionTokens"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListServiceConnectionTokensRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .ListServiceConnectionTokensResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "ListServiceConnectionTokens"))
                      .build();
        }
      }
    }
    return getListServiceConnectionTokensMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest,
          com.google.longrunning.Operation>
      getCreateServiceConnectionTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceConnectionToken",
      requestType =
          com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest,
          com.google.longrunning.Operation>
      getCreateServiceConnectionTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest,
            com.google.longrunning.Operation>
        getCreateServiceConnectionTokenMethod;
    if ((getCreateServiceConnectionTokenMethod =
            CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionTokenMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getCreateServiceConnectionTokenMethod =
                CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionTokenMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getCreateServiceConnectionTokenMethod =
              getCreateServiceConnectionTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateServiceConnectionToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .CreateServiceConnectionTokenRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "CreateServiceConnectionToken"))
                      .build();
        }
      }
    }
    return getCreateServiceConnectionTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest,
          com.google.longrunning.Operation>
      getDeleteServiceConnectionTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceConnectionToken",
      requestType =
          com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest,
          com.google.longrunning.Operation>
      getDeleteServiceConnectionTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest,
            com.google.longrunning.Operation>
        getDeleteServiceConnectionTokenMethod;
    if ((getDeleteServiceConnectionTokenMethod =
            CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionTokenMethod)
        == null) {
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        if ((getDeleteServiceConnectionTokenMethod =
                CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionTokenMethod)
            == null) {
          CrossNetworkAutomationServiceGrpc.getDeleteServiceConnectionTokenMethod =
              getDeleteServiceConnectionTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteServiceConnectionToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1
                                  .DeleteServiceConnectionTokenRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceMethodDescriptorSupplier(
                              "DeleteServiceConnectionToken"))
                      .build();
        }
      }
    }
    return getDeleteServiceConnectionTokenMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CrossNetworkAutomationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossNetworkAutomationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CrossNetworkAutomationServiceStub>() {
          @java.lang.Override
          public CrossNetworkAutomationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CrossNetworkAutomationServiceStub(channel, callOptions);
          }
        };
    return CrossNetworkAutomationServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CrossNetworkAutomationServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossNetworkAutomationServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CrossNetworkAutomationServiceBlockingV2Stub>() {
          @java.lang.Override
          public CrossNetworkAutomationServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CrossNetworkAutomationServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return CrossNetworkAutomationServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CrossNetworkAutomationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossNetworkAutomationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CrossNetworkAutomationServiceBlockingStub>() {
          @java.lang.Override
          public CrossNetworkAutomationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CrossNetworkAutomationServiceBlockingStub(channel, callOptions);
          }
        };
    return CrossNetworkAutomationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CrossNetworkAutomationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrossNetworkAutomationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CrossNetworkAutomationServiceFutureStub>() {
          @java.lang.Override
          public CrossNetworkAutomationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CrossNetworkAutomationServiceFutureStub(channel, callOptions);
          }
        };
    return CrossNetworkAutomationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service for CrossNetworkAutomation resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionMaps in a given project and location.
     * </pre>
     */
    default void listServiceConnectionMaps(
        com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServiceConnectionMapsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionMap.
     * </pre>
     */
    default void getServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServiceConnectionMapMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionMap in a given project and location.
     * </pre>
     */
    default void createServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceConnectionMapMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionMap.
     * </pre>
     */
    default void updateServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceConnectionMapMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionMap.
     * </pre>
     */
    default void deleteServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceConnectionMapMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionPolicies in a given project and location.
     * </pre>
     */
    default void listServiceConnectionPolicies(
        com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServiceConnectionPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionPolicy.
     * </pre>
     */
    default void getServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServiceConnectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionPolicy in a given project and location.
     * </pre>
     */
    default void createServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceConnectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionPolicy.
     * </pre>
     */
    default void updateServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceConnectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionPolicy.
     * </pre>
     */
    default void deleteServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceConnectionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceClasses in a given project and location.
     * </pre>
     */
    default void listServiceClasses(
        com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServiceClassesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceClass.
     * </pre>
     */
    default void getServiceClass(
        com.google.cloud.networkconnectivity.v1.GetServiceClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceClass>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServiceClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceClass.
     * </pre>
     */
    default void updateServiceClass(
        com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceClass.
     * </pre>
     */
    default void deleteServiceClass(
        com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionToken.
     * </pre>
     */
    default void getServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServiceConnectionTokenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionTokens in a given project and location.
     * </pre>
     */
    default void listServiceConnectionTokens(
        com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServiceConnectionTokensMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionToken in a given project and location.
     * </pre>
     */
    default void createServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceConnectionTokenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionToken.
     * </pre>
     */
    default void deleteServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceConnectionTokenMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CrossNetworkAutomationService.
   *
   * <pre>
   * The service for CrossNetworkAutomation resources.
   * </pre>
   */
  public abstract static class CrossNetworkAutomationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CrossNetworkAutomationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CrossNetworkAutomationService.
   *
   * <pre>
   * The service for CrossNetworkAutomation resources.
   * </pre>
   */
  public static final class CrossNetworkAutomationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CrossNetworkAutomationServiceStub> {
    private CrossNetworkAutomationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossNetworkAutomationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossNetworkAutomationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionMaps in a given project and location.
     * </pre>
     */
    public void listServiceConnectionMaps(
        com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceConnectionMapsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionMap.
     * </pre>
     */
    public void getServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceConnectionMapMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionMap in a given project and location.
     * </pre>
     */
    public void createServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceConnectionMapMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionMap.
     * </pre>
     */
    public void updateServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceConnectionMapMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionMap.
     * </pre>
     */
    public void deleteServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceConnectionMapMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionPolicies in a given project and location.
     * </pre>
     */
    public void listServiceConnectionPolicies(
        com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceConnectionPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionPolicy.
     * </pre>
     */
    public void getServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceConnectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionPolicy in a given project and location.
     * </pre>
     */
    public void createServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceConnectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionPolicy.
     * </pre>
     */
    public void updateServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceConnectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionPolicy.
     * </pre>
     */
    public void deleteServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceConnectionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceClasses in a given project and location.
     * </pre>
     */
    public void listServiceClasses(
        com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceClassesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceClass.
     * </pre>
     */
    public void getServiceClass(
        com.google.cloud.networkconnectivity.v1.GetServiceClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceClass>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceClass.
     * </pre>
     */
    public void updateServiceClass(
        com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceClass.
     * </pre>
     */
    public void deleteServiceClass(
        com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionToken.
     * </pre>
     */
    public void getServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceConnectionTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionTokens in a given project and location.
     * </pre>
     */
    public void listServiceConnectionTokens(
        com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceConnectionTokensMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionToken in a given project and location.
     * </pre>
     */
    public void createServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceConnectionTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionToken.
     * </pre>
     */
    public void deleteServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceConnectionTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CrossNetworkAutomationService.
   *
   * <pre>
   * The service for CrossNetworkAutomation resources.
   * </pre>
   */
  public static final class CrossNetworkAutomationServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CrossNetworkAutomationServiceBlockingV2Stub> {
    private CrossNetworkAutomationServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossNetworkAutomationServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossNetworkAutomationServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionMaps in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse
        listServiceConnectionMaps(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceConnectionMapsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ServiceConnectionMap getServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceConnectionMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionMap in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceConnectionMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.longrunning.Operation updateServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceConnectionMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceConnectionMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse
        listServiceConnectionPolicies(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceConnectionPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy
        getServiceConnectionPolicy(
            com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceConnectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceConnectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceConnectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceConnectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceClasses in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse listServiceClasses(
        com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceClassesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceClass.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ServiceClass getServiceClass(
        com.google.cloud.networkconnectivity.v1.GetServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceClass.
     * </pre>
     */
    public com.google.longrunning.Operation updateServiceClass(
        com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceClass.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceClass(
        com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionToken.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ServiceConnectionToken getServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceConnectionTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionTokens in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse
        listServiceConnectionTokens(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceConnectionTokensMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionToken in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceConnectionTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionToken.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceConnectionTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * CrossNetworkAutomationService.
   *
   * <pre>
   * The service for CrossNetworkAutomation resources.
   * </pre>
   */
  public static final class CrossNetworkAutomationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CrossNetworkAutomationServiceBlockingStub> {
    private CrossNetworkAutomationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossNetworkAutomationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossNetworkAutomationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionMaps in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse
        listServiceConnectionMaps(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceConnectionMapsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ServiceConnectionMap getServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceConnectionMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionMap in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceConnectionMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.longrunning.Operation updateServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceConnectionMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceConnectionMap(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceConnectionMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse
        listServiceConnectionPolicies(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceConnectionPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy
        getServiceConnectionPolicy(
            com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceConnectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceConnectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceConnectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceConnectionPolicy(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceConnectionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceClasses in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse listServiceClasses(
        com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceClassesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceClass.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ServiceClass getServiceClass(
        com.google.cloud.networkconnectivity.v1.GetServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceClass.
     * </pre>
     */
    public com.google.longrunning.Operation updateServiceClass(
        com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceClass.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceClass(
        com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionToken.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ServiceConnectionToken getServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceConnectionTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionTokens in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse
        listServiceConnectionTokens(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceConnectionTokensMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionToken in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceConnectionTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionToken.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceConnectionToken(
        com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceConnectionTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * CrossNetworkAutomationService.
   *
   * <pre>
   * The service for CrossNetworkAutomation resources.
   * </pre>
   */
  public static final class CrossNetworkAutomationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CrossNetworkAutomationServiceFutureStub> {
    private CrossNetworkAutomationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrossNetworkAutomationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrossNetworkAutomationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionMaps in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>
        listServiceConnectionMaps(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceConnectionMapsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>
        getServiceConnectionMap(
            com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceConnectionMapMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionMap in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createServiceConnectionMap(
            com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceConnectionMapMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateServiceConnectionMap(
            com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceConnectionMapMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionMap.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteServiceConnectionMap(
            com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceConnectionMapMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse>
        listServiceConnectionPolicies(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceConnectionPoliciesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>
        getServiceConnectionPolicy(
            com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceConnectionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createServiceConnectionPolicy(
            com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceConnectionPolicyMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateServiceConnectionPolicy(
            com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceConnectionPolicyMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteServiceConnectionPolicy(
            com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceConnectionPolicyMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceClasses in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>
        listServiceClasses(
            com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceClassesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceClass.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ServiceClass>
        getServiceClass(com.google.cloud.networkconnectivity.v1.GetServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ServiceClass.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateServiceClass(
            com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceClass.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteServiceClass(
            com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceConnectionToken.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>
        getServiceConnectionToken(
            com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceConnectionTokenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceConnectionTokens in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse>
        listServiceConnectionTokens(
            com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceConnectionTokensMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceConnectionToken in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createServiceConnectionToken(
            com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceConnectionTokenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceConnectionToken.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteServiceConnectionToken(
            com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceConnectionTokenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SERVICE_CONNECTION_MAPS = 0;
  private static final int METHODID_GET_SERVICE_CONNECTION_MAP = 1;
  private static final int METHODID_CREATE_SERVICE_CONNECTION_MAP = 2;
  private static final int METHODID_UPDATE_SERVICE_CONNECTION_MAP = 3;
  private static final int METHODID_DELETE_SERVICE_CONNECTION_MAP = 4;
  private static final int METHODID_LIST_SERVICE_CONNECTION_POLICIES = 5;
  private static final int METHODID_GET_SERVICE_CONNECTION_POLICY = 6;
  private static final int METHODID_CREATE_SERVICE_CONNECTION_POLICY = 7;
  private static final int METHODID_UPDATE_SERVICE_CONNECTION_POLICY = 8;
  private static final int METHODID_DELETE_SERVICE_CONNECTION_POLICY = 9;
  private static final int METHODID_LIST_SERVICE_CLASSES = 10;
  private static final int METHODID_GET_SERVICE_CLASS = 11;
  private static final int METHODID_UPDATE_SERVICE_CLASS = 12;
  private static final int METHODID_DELETE_SERVICE_CLASS = 13;
  private static final int METHODID_GET_SERVICE_CONNECTION_TOKEN = 14;
  private static final int METHODID_LIST_SERVICE_CONNECTION_TOKENS = 15;
  private static final int METHODID_CREATE_SERVICE_CONNECTION_TOKEN = 16;
  private static final int METHODID_DELETE_SERVICE_CONNECTION_TOKEN = 17;

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
        case METHODID_LIST_SERVICE_CONNECTION_MAPS:
          serviceImpl.listServiceConnectionMaps(
              (com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE_CONNECTION_MAP:
          serviceImpl.getServiceConnectionMap(
              (com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>)
                  responseObserver);
          break;
        case METHODID_CREATE_SERVICE_CONNECTION_MAP:
          serviceImpl.createServiceConnectionMap(
              (com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE_CONNECTION_MAP:
          serviceImpl.updateServiceConnectionMap(
              (com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_CONNECTION_MAP:
          serviceImpl.deleteServiceConnectionMap(
              (com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERVICE_CONNECTION_POLICIES:
          serviceImpl.listServiceConnectionPolicies(
              (com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1
                          .ListServiceConnectionPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE_CONNECTION_POLICY:
          serviceImpl.getServiceConnectionPolicy(
              (com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_SERVICE_CONNECTION_POLICY:
          serviceImpl.createServiceConnectionPolicy(
              (com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE_CONNECTION_POLICY:
          serviceImpl.updateServiceConnectionPolicy(
              (com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_CONNECTION_POLICY:
          serviceImpl.deleteServiceConnectionPolicy(
              (com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERVICE_CLASSES:
          serviceImpl.listServiceClasses(
              (com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE_CLASS:
          serviceImpl.getServiceClass(
              (com.google.cloud.networkconnectivity.v1.GetServiceClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.ServiceClass>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SERVICE_CLASS:
          serviceImpl.updateServiceClass(
              (com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_CLASS:
          serviceImpl.deleteServiceClass(
              (com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SERVICE_CONNECTION_TOKEN:
          serviceImpl.getServiceConnectionToken(
              (com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>)
                  responseObserver);
          break;
        case METHODID_LIST_SERVICE_CONNECTION_TOKENS:
          serviceImpl.listServiceConnectionTokens(
              (com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SERVICE_CONNECTION_TOKEN:
          serviceImpl.createServiceConnectionToken(
              (com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_CONNECTION_TOKEN:
          serviceImpl.deleteServiceConnectionToken(
              (com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest) request,
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
            getListServiceConnectionMapsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest,
                    com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse>(
                    service, METHODID_LIST_SERVICE_CONNECTION_MAPS)))
        .addMethod(
            getGetServiceConnectionMapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest,
                    com.google.cloud.networkconnectivity.v1.ServiceConnectionMap>(
                    service, METHODID_GET_SERVICE_CONNECTION_MAP)))
        .addMethod(
            getCreateServiceConnectionMapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_SERVICE_CONNECTION_MAP)))
        .addMethod(
            getUpdateServiceConnectionMapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_SERVICE_CONNECTION_MAP)))
        .addMethod(
            getDeleteServiceConnectionMapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_SERVICE_CONNECTION_MAP)))
        .addMethod(
            getListServiceConnectionPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest,
                    com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse>(
                    service, METHODID_LIST_SERVICE_CONNECTION_POLICIES)))
        .addMethod(
            getGetServiceConnectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest,
                    com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy>(
                    service, METHODID_GET_SERVICE_CONNECTION_POLICY)))
        .addMethod(
            getCreateServiceConnectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_SERVICE_CONNECTION_POLICY)))
        .addMethod(
            getUpdateServiceConnectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_SERVICE_CONNECTION_POLICY)))
        .addMethod(
            getDeleteServiceConnectionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_SERVICE_CONNECTION_POLICY)))
        .addMethod(
            getListServiceClassesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest,
                    com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse>(
                    service, METHODID_LIST_SERVICE_CLASSES)))
        .addMethod(
            getGetServiceClassMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.GetServiceClassRequest,
                    com.google.cloud.networkconnectivity.v1.ServiceClass>(
                    service, METHODID_GET_SERVICE_CLASS)))
        .addMethod(
            getUpdateServiceClassMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SERVICE_CLASS)))
        .addMethod(
            getDeleteServiceClassMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SERVICE_CLASS)))
        .addMethod(
            getGetServiceConnectionTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest,
                    com.google.cloud.networkconnectivity.v1.ServiceConnectionToken>(
                    service, METHODID_GET_SERVICE_CONNECTION_TOKEN)))
        .addMethod(
            getListServiceConnectionTokensMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest,
                    com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse>(
                    service, METHODID_LIST_SERVICE_CONNECTION_TOKENS)))
        .addMethod(
            getCreateServiceConnectionTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_SERVICE_CONNECTION_TOKEN)))
        .addMethod(
            getDeleteServiceConnectionTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_SERVICE_CONNECTION_TOKEN)))
        .build();
  }

  private abstract static class CrossNetworkAutomationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CrossNetworkAutomationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CrossNetworkAutomationService");
    }
  }

  private static final class CrossNetworkAutomationServiceFileDescriptorSupplier
      extends CrossNetworkAutomationServiceBaseDescriptorSupplier {
    CrossNetworkAutomationServiceFileDescriptorSupplier() {}
  }

  private static final class CrossNetworkAutomationServiceMethodDescriptorSupplier
      extends CrossNetworkAutomationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CrossNetworkAutomationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CrossNetworkAutomationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new CrossNetworkAutomationServiceFileDescriptorSupplier())
                      .addMethod(getListServiceConnectionMapsMethod())
                      .addMethod(getGetServiceConnectionMapMethod())
                      .addMethod(getCreateServiceConnectionMapMethod())
                      .addMethod(getUpdateServiceConnectionMapMethod())
                      .addMethod(getDeleteServiceConnectionMapMethod())
                      .addMethod(getListServiceConnectionPoliciesMethod())
                      .addMethod(getGetServiceConnectionPolicyMethod())
                      .addMethod(getCreateServiceConnectionPolicyMethod())
                      .addMethod(getUpdateServiceConnectionPolicyMethod())
                      .addMethod(getDeleteServiceConnectionPolicyMethod())
                      .addMethod(getListServiceClassesMethod())
                      .addMethod(getGetServiceClassMethod())
                      .addMethod(getUpdateServiceClassMethod())
                      .addMethod(getDeleteServiceClassMethod())
                      .addMethod(getGetServiceConnectionTokenMethod())
                      .addMethod(getListServiceConnectionTokensMethod())
                      .addMethod(getCreateServiceConnectionTokenMethod())
                      .addMethod(getDeleteServiceConnectionTokenMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
