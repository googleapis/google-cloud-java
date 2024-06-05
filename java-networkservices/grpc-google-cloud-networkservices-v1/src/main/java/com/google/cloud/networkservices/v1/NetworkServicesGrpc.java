/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.networkservices.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkservices/v1/network_services.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NetworkServicesGrpc {

  private NetworkServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkservices.v1.NetworkServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest,
          com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>
      getListEndpointPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEndpointPolicies",
      requestType = com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest,
          com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>
      getListEndpointPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest,
            com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>
        getListEndpointPoliciesMethod;
    if ((getListEndpointPoliciesMethod = NetworkServicesGrpc.getListEndpointPoliciesMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListEndpointPoliciesMethod = NetworkServicesGrpc.getListEndpointPoliciesMethod)
            == null) {
          NetworkServicesGrpc.getListEndpointPoliciesMethod =
              getListEndpointPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest,
                          com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEndpointPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListEndpointPolicies"))
                      .build();
        }
      }
    }
    return getListEndpointPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetEndpointPolicyRequest,
          com.google.cloud.networkservices.v1.EndpointPolicy>
      getGetEndpointPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEndpointPolicy",
      requestType = com.google.cloud.networkservices.v1.GetEndpointPolicyRequest.class,
      responseType = com.google.cloud.networkservices.v1.EndpointPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetEndpointPolicyRequest,
          com.google.cloud.networkservices.v1.EndpointPolicy>
      getGetEndpointPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetEndpointPolicyRequest,
            com.google.cloud.networkservices.v1.EndpointPolicy>
        getGetEndpointPolicyMethod;
    if ((getGetEndpointPolicyMethod = NetworkServicesGrpc.getGetEndpointPolicyMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetEndpointPolicyMethod = NetworkServicesGrpc.getGetEndpointPolicyMethod) == null) {
          NetworkServicesGrpc.getGetEndpointPolicyMethod =
              getGetEndpointPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetEndpointPolicyRequest,
                          com.google.cloud.networkservices.v1.EndpointPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEndpointPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetEndpointPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.EndpointPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("GetEndpointPolicy"))
                      .build();
        }
      }
    }
    return getGetEndpointPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getCreateEndpointPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEndpointPolicy",
      requestType = com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getCreateEndpointPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest,
            com.google.longrunning.Operation>
        getCreateEndpointPolicyMethod;
    if ((getCreateEndpointPolicyMethod = NetworkServicesGrpc.getCreateEndpointPolicyMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateEndpointPolicyMethod = NetworkServicesGrpc.getCreateEndpointPolicyMethod)
            == null) {
          NetworkServicesGrpc.getCreateEndpointPolicyMethod =
              getCreateEndpointPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEndpointPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateEndpointPolicy"))
                      .build();
        }
      }
    }
    return getCreateEndpointPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateEndpointPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEndpointPolicy",
      requestType = com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateEndpointPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateEndpointPolicyMethod;
    if ((getUpdateEndpointPolicyMethod = NetworkServicesGrpc.getUpdateEndpointPolicyMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getUpdateEndpointPolicyMethod = NetworkServicesGrpc.getUpdateEndpointPolicyMethod)
            == null) {
          NetworkServicesGrpc.getUpdateEndpointPolicyMethod =
              getUpdateEndpointPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEndpointPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("UpdateEndpointPolicy"))
                      .build();
        }
      }
    }
    return getUpdateEndpointPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteEndpointPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEndpointPolicy",
      requestType = com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteEndpointPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteEndpointPolicyMethod;
    if ((getDeleteEndpointPolicyMethod = NetworkServicesGrpc.getDeleteEndpointPolicyMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteEndpointPolicyMethod = NetworkServicesGrpc.getDeleteEndpointPolicyMethod)
            == null) {
          NetworkServicesGrpc.getDeleteEndpointPolicyMethod =
              getDeleteEndpointPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEndpointPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteEndpointPolicy"))
                      .build();
        }
      }
    }
    return getDeleteEndpointPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListGatewaysRequest,
          com.google.cloud.networkservices.v1.ListGatewaysResponse>
      getListGatewaysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGateways",
      requestType = com.google.cloud.networkservices.v1.ListGatewaysRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListGatewaysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListGatewaysRequest,
          com.google.cloud.networkservices.v1.ListGatewaysResponse>
      getListGatewaysMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListGatewaysRequest,
            com.google.cloud.networkservices.v1.ListGatewaysResponse>
        getListGatewaysMethod;
    if ((getListGatewaysMethod = NetworkServicesGrpc.getListGatewaysMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListGatewaysMethod = NetworkServicesGrpc.getListGatewaysMethod) == null) {
          NetworkServicesGrpc.getListGatewaysMethod =
              getListGatewaysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListGatewaysRequest,
                          com.google.cloud.networkservices.v1.ListGatewaysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGateways"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListGatewaysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListGatewaysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListGateways"))
                      .build();
        }
      }
    }
    return getListGatewaysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetGatewayRequest,
          com.google.cloud.networkservices.v1.Gateway>
      getGetGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGateway",
      requestType = com.google.cloud.networkservices.v1.GetGatewayRequest.class,
      responseType = com.google.cloud.networkservices.v1.Gateway.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetGatewayRequest,
          com.google.cloud.networkservices.v1.Gateway>
      getGetGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetGatewayRequest,
            com.google.cloud.networkservices.v1.Gateway>
        getGetGatewayMethod;
    if ((getGetGatewayMethod = NetworkServicesGrpc.getGetGatewayMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetGatewayMethod = NetworkServicesGrpc.getGetGatewayMethod) == null) {
          NetworkServicesGrpc.getGetGatewayMethod =
              getGetGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetGatewayRequest,
                          com.google.cloud.networkservices.v1.Gateway>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.Gateway.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("GetGateway"))
                      .build();
        }
      }
    }
    return getGetGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateGatewayRequest,
          com.google.longrunning.Operation>
      getCreateGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGateway",
      requestType = com.google.cloud.networkservices.v1.CreateGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateGatewayRequest,
          com.google.longrunning.Operation>
      getCreateGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateGatewayRequest,
            com.google.longrunning.Operation>
        getCreateGatewayMethod;
    if ((getCreateGatewayMethod = NetworkServicesGrpc.getCreateGatewayMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateGatewayMethod = NetworkServicesGrpc.getCreateGatewayMethod) == null) {
          NetworkServicesGrpc.getCreateGatewayMethod =
              getCreateGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateGatewayRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateGateway"))
                      .build();
        }
      }
    }
    return getCreateGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateGatewayRequest,
          com.google.longrunning.Operation>
      getUpdateGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGateway",
      requestType = com.google.cloud.networkservices.v1.UpdateGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateGatewayRequest,
          com.google.longrunning.Operation>
      getUpdateGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateGatewayRequest,
            com.google.longrunning.Operation>
        getUpdateGatewayMethod;
    if ((getUpdateGatewayMethod = NetworkServicesGrpc.getUpdateGatewayMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getUpdateGatewayMethod = NetworkServicesGrpc.getUpdateGatewayMethod) == null) {
          NetworkServicesGrpc.getUpdateGatewayMethod =
              getUpdateGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateGatewayRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("UpdateGateway"))
                      .build();
        }
      }
    }
    return getUpdateGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteGatewayRequest,
          com.google.longrunning.Operation>
      getDeleteGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGateway",
      requestType = com.google.cloud.networkservices.v1.DeleteGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteGatewayRequest,
          com.google.longrunning.Operation>
      getDeleteGatewayMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteGatewayRequest,
            com.google.longrunning.Operation>
        getDeleteGatewayMethod;
    if ((getDeleteGatewayMethod = NetworkServicesGrpc.getDeleteGatewayMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteGatewayMethod = NetworkServicesGrpc.getDeleteGatewayMethod) == null) {
          NetworkServicesGrpc.getDeleteGatewayMethod =
              getDeleteGatewayMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteGatewayRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGateway"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteGatewayRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteGateway"))
                      .build();
        }
      }
    }
    return getDeleteGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListGrpcRoutesRequest,
          com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>
      getListGrpcRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGrpcRoutes",
      requestType = com.google.cloud.networkservices.v1.ListGrpcRoutesRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListGrpcRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListGrpcRoutesRequest,
          com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>
      getListGrpcRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListGrpcRoutesRequest,
            com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>
        getListGrpcRoutesMethod;
    if ((getListGrpcRoutesMethod = NetworkServicesGrpc.getListGrpcRoutesMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListGrpcRoutesMethod = NetworkServicesGrpc.getListGrpcRoutesMethod) == null) {
          NetworkServicesGrpc.getListGrpcRoutesMethod =
              getListGrpcRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListGrpcRoutesRequest,
                          com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGrpcRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListGrpcRoutesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListGrpcRoutesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListGrpcRoutes"))
                      .build();
        }
      }
    }
    return getListGrpcRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetGrpcRouteRequest,
          com.google.cloud.networkservices.v1.GrpcRoute>
      getGetGrpcRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGrpcRoute",
      requestType = com.google.cloud.networkservices.v1.GetGrpcRouteRequest.class,
      responseType = com.google.cloud.networkservices.v1.GrpcRoute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetGrpcRouteRequest,
          com.google.cloud.networkservices.v1.GrpcRoute>
      getGetGrpcRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetGrpcRouteRequest,
            com.google.cloud.networkservices.v1.GrpcRoute>
        getGetGrpcRouteMethod;
    if ((getGetGrpcRouteMethod = NetworkServicesGrpc.getGetGrpcRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetGrpcRouteMethod = NetworkServicesGrpc.getGetGrpcRouteMethod) == null) {
          NetworkServicesGrpc.getGetGrpcRouteMethod =
              getGetGrpcRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetGrpcRouteRequest,
                          com.google.cloud.networkservices.v1.GrpcRoute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGrpcRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetGrpcRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GrpcRoute.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("GetGrpcRoute"))
                      .build();
        }
      }
    }
    return getGetGrpcRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateGrpcRouteRequest,
          com.google.longrunning.Operation>
      getCreateGrpcRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGrpcRoute",
      requestType = com.google.cloud.networkservices.v1.CreateGrpcRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateGrpcRouteRequest,
          com.google.longrunning.Operation>
      getCreateGrpcRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateGrpcRouteRequest,
            com.google.longrunning.Operation>
        getCreateGrpcRouteMethod;
    if ((getCreateGrpcRouteMethod = NetworkServicesGrpc.getCreateGrpcRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateGrpcRouteMethod = NetworkServicesGrpc.getCreateGrpcRouteMethod) == null) {
          NetworkServicesGrpc.getCreateGrpcRouteMethod =
              getCreateGrpcRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateGrpcRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGrpcRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateGrpcRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateGrpcRoute"))
                      .build();
        }
      }
    }
    return getCreateGrpcRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest,
          com.google.longrunning.Operation>
      getUpdateGrpcRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGrpcRoute",
      requestType = com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest,
          com.google.longrunning.Operation>
      getUpdateGrpcRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest,
            com.google.longrunning.Operation>
        getUpdateGrpcRouteMethod;
    if ((getUpdateGrpcRouteMethod = NetworkServicesGrpc.getUpdateGrpcRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getUpdateGrpcRouteMethod = NetworkServicesGrpc.getUpdateGrpcRouteMethod) == null) {
          NetworkServicesGrpc.getUpdateGrpcRouteMethod =
              getUpdateGrpcRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGrpcRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("UpdateGrpcRoute"))
                      .build();
        }
      }
    }
    return getUpdateGrpcRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest,
          com.google.longrunning.Operation>
      getDeleteGrpcRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGrpcRoute",
      requestType = com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest,
          com.google.longrunning.Operation>
      getDeleteGrpcRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest,
            com.google.longrunning.Operation>
        getDeleteGrpcRouteMethod;
    if ((getDeleteGrpcRouteMethod = NetworkServicesGrpc.getDeleteGrpcRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteGrpcRouteMethod = NetworkServicesGrpc.getDeleteGrpcRouteMethod) == null) {
          NetworkServicesGrpc.getDeleteGrpcRouteMethod =
              getDeleteGrpcRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGrpcRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteGrpcRoute"))
                      .build();
        }
      }
    }
    return getDeleteGrpcRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListHttpRoutesRequest,
          com.google.cloud.networkservices.v1.ListHttpRoutesResponse>
      getListHttpRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHttpRoutes",
      requestType = com.google.cloud.networkservices.v1.ListHttpRoutesRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListHttpRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListHttpRoutesRequest,
          com.google.cloud.networkservices.v1.ListHttpRoutesResponse>
      getListHttpRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListHttpRoutesRequest,
            com.google.cloud.networkservices.v1.ListHttpRoutesResponse>
        getListHttpRoutesMethod;
    if ((getListHttpRoutesMethod = NetworkServicesGrpc.getListHttpRoutesMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListHttpRoutesMethod = NetworkServicesGrpc.getListHttpRoutesMethod) == null) {
          NetworkServicesGrpc.getListHttpRoutesMethod =
              getListHttpRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListHttpRoutesRequest,
                          com.google.cloud.networkservices.v1.ListHttpRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHttpRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListHttpRoutesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListHttpRoutesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListHttpRoutes"))
                      .build();
        }
      }
    }
    return getListHttpRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetHttpRouteRequest,
          com.google.cloud.networkservices.v1.HttpRoute>
      getGetHttpRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHttpRoute",
      requestType = com.google.cloud.networkservices.v1.GetHttpRouteRequest.class,
      responseType = com.google.cloud.networkservices.v1.HttpRoute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetHttpRouteRequest,
          com.google.cloud.networkservices.v1.HttpRoute>
      getGetHttpRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetHttpRouteRequest,
            com.google.cloud.networkservices.v1.HttpRoute>
        getGetHttpRouteMethod;
    if ((getGetHttpRouteMethod = NetworkServicesGrpc.getGetHttpRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetHttpRouteMethod = NetworkServicesGrpc.getGetHttpRouteMethod) == null) {
          NetworkServicesGrpc.getGetHttpRouteMethod =
              getGetHttpRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetHttpRouteRequest,
                          com.google.cloud.networkservices.v1.HttpRoute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHttpRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetHttpRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.HttpRoute.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("GetHttpRoute"))
                      .build();
        }
      }
    }
    return getGetHttpRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateHttpRouteRequest,
          com.google.longrunning.Operation>
      getCreateHttpRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHttpRoute",
      requestType = com.google.cloud.networkservices.v1.CreateHttpRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateHttpRouteRequest,
          com.google.longrunning.Operation>
      getCreateHttpRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateHttpRouteRequest,
            com.google.longrunning.Operation>
        getCreateHttpRouteMethod;
    if ((getCreateHttpRouteMethod = NetworkServicesGrpc.getCreateHttpRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateHttpRouteMethod = NetworkServicesGrpc.getCreateHttpRouteMethod) == null) {
          NetworkServicesGrpc.getCreateHttpRouteMethod =
              getCreateHttpRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateHttpRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHttpRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateHttpRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateHttpRoute"))
                      .build();
        }
      }
    }
    return getCreateHttpRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateHttpRouteRequest,
          com.google.longrunning.Operation>
      getUpdateHttpRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHttpRoute",
      requestType = com.google.cloud.networkservices.v1.UpdateHttpRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateHttpRouteRequest,
          com.google.longrunning.Operation>
      getUpdateHttpRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateHttpRouteRequest,
            com.google.longrunning.Operation>
        getUpdateHttpRouteMethod;
    if ((getUpdateHttpRouteMethod = NetworkServicesGrpc.getUpdateHttpRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getUpdateHttpRouteMethod = NetworkServicesGrpc.getUpdateHttpRouteMethod) == null) {
          NetworkServicesGrpc.getUpdateHttpRouteMethod =
              getUpdateHttpRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateHttpRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHttpRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateHttpRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("UpdateHttpRoute"))
                      .build();
        }
      }
    }
    return getUpdateHttpRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteHttpRouteRequest,
          com.google.longrunning.Operation>
      getDeleteHttpRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHttpRoute",
      requestType = com.google.cloud.networkservices.v1.DeleteHttpRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteHttpRouteRequest,
          com.google.longrunning.Operation>
      getDeleteHttpRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteHttpRouteRequest,
            com.google.longrunning.Operation>
        getDeleteHttpRouteMethod;
    if ((getDeleteHttpRouteMethod = NetworkServicesGrpc.getDeleteHttpRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteHttpRouteMethod = NetworkServicesGrpc.getDeleteHttpRouteMethod) == null) {
          NetworkServicesGrpc.getDeleteHttpRouteMethod =
              getDeleteHttpRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteHttpRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHttpRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteHttpRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteHttpRoute"))
                      .build();
        }
      }
    }
    return getDeleteHttpRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListTcpRoutesRequest,
          com.google.cloud.networkservices.v1.ListTcpRoutesResponse>
      getListTcpRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTcpRoutes",
      requestType = com.google.cloud.networkservices.v1.ListTcpRoutesRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListTcpRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListTcpRoutesRequest,
          com.google.cloud.networkservices.v1.ListTcpRoutesResponse>
      getListTcpRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListTcpRoutesRequest,
            com.google.cloud.networkservices.v1.ListTcpRoutesResponse>
        getListTcpRoutesMethod;
    if ((getListTcpRoutesMethod = NetworkServicesGrpc.getListTcpRoutesMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListTcpRoutesMethod = NetworkServicesGrpc.getListTcpRoutesMethod) == null) {
          NetworkServicesGrpc.getListTcpRoutesMethod =
              getListTcpRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListTcpRoutesRequest,
                          com.google.cloud.networkservices.v1.ListTcpRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTcpRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListTcpRoutesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListTcpRoutesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListTcpRoutes"))
                      .build();
        }
      }
    }
    return getListTcpRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetTcpRouteRequest,
          com.google.cloud.networkservices.v1.TcpRoute>
      getGetTcpRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTcpRoute",
      requestType = com.google.cloud.networkservices.v1.GetTcpRouteRequest.class,
      responseType = com.google.cloud.networkservices.v1.TcpRoute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetTcpRouteRequest,
          com.google.cloud.networkservices.v1.TcpRoute>
      getGetTcpRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetTcpRouteRequest,
            com.google.cloud.networkservices.v1.TcpRoute>
        getGetTcpRouteMethod;
    if ((getGetTcpRouteMethod = NetworkServicesGrpc.getGetTcpRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetTcpRouteMethod = NetworkServicesGrpc.getGetTcpRouteMethod) == null) {
          NetworkServicesGrpc.getGetTcpRouteMethod =
              getGetTcpRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetTcpRouteRequest,
                          com.google.cloud.networkservices.v1.TcpRoute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTcpRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetTcpRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.TcpRoute.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("GetTcpRoute"))
                      .build();
        }
      }
    }
    return getGetTcpRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateTcpRouteRequest,
          com.google.longrunning.Operation>
      getCreateTcpRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTcpRoute",
      requestType = com.google.cloud.networkservices.v1.CreateTcpRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateTcpRouteRequest,
          com.google.longrunning.Operation>
      getCreateTcpRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateTcpRouteRequest,
            com.google.longrunning.Operation>
        getCreateTcpRouteMethod;
    if ((getCreateTcpRouteMethod = NetworkServicesGrpc.getCreateTcpRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateTcpRouteMethod = NetworkServicesGrpc.getCreateTcpRouteMethod) == null) {
          NetworkServicesGrpc.getCreateTcpRouteMethod =
              getCreateTcpRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateTcpRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTcpRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateTcpRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateTcpRoute"))
                      .build();
        }
      }
    }
    return getCreateTcpRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateTcpRouteRequest,
          com.google.longrunning.Operation>
      getUpdateTcpRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTcpRoute",
      requestType = com.google.cloud.networkservices.v1.UpdateTcpRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateTcpRouteRequest,
          com.google.longrunning.Operation>
      getUpdateTcpRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateTcpRouteRequest,
            com.google.longrunning.Operation>
        getUpdateTcpRouteMethod;
    if ((getUpdateTcpRouteMethod = NetworkServicesGrpc.getUpdateTcpRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getUpdateTcpRouteMethod = NetworkServicesGrpc.getUpdateTcpRouteMethod) == null) {
          NetworkServicesGrpc.getUpdateTcpRouteMethod =
              getUpdateTcpRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateTcpRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTcpRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateTcpRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("UpdateTcpRoute"))
                      .build();
        }
      }
    }
    return getUpdateTcpRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteTcpRouteRequest,
          com.google.longrunning.Operation>
      getDeleteTcpRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTcpRoute",
      requestType = com.google.cloud.networkservices.v1.DeleteTcpRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteTcpRouteRequest,
          com.google.longrunning.Operation>
      getDeleteTcpRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteTcpRouteRequest,
            com.google.longrunning.Operation>
        getDeleteTcpRouteMethod;
    if ((getDeleteTcpRouteMethod = NetworkServicesGrpc.getDeleteTcpRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteTcpRouteMethod = NetworkServicesGrpc.getDeleteTcpRouteMethod) == null) {
          NetworkServicesGrpc.getDeleteTcpRouteMethod =
              getDeleteTcpRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteTcpRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTcpRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteTcpRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteTcpRoute"))
                      .build();
        }
      }
    }
    return getDeleteTcpRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListTlsRoutesRequest,
          com.google.cloud.networkservices.v1.ListTlsRoutesResponse>
      getListTlsRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTlsRoutes",
      requestType = com.google.cloud.networkservices.v1.ListTlsRoutesRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListTlsRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListTlsRoutesRequest,
          com.google.cloud.networkservices.v1.ListTlsRoutesResponse>
      getListTlsRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListTlsRoutesRequest,
            com.google.cloud.networkservices.v1.ListTlsRoutesResponse>
        getListTlsRoutesMethod;
    if ((getListTlsRoutesMethod = NetworkServicesGrpc.getListTlsRoutesMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListTlsRoutesMethod = NetworkServicesGrpc.getListTlsRoutesMethod) == null) {
          NetworkServicesGrpc.getListTlsRoutesMethod =
              getListTlsRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListTlsRoutesRequest,
                          com.google.cloud.networkservices.v1.ListTlsRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTlsRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListTlsRoutesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListTlsRoutesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListTlsRoutes"))
                      .build();
        }
      }
    }
    return getListTlsRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetTlsRouteRequest,
          com.google.cloud.networkservices.v1.TlsRoute>
      getGetTlsRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTlsRoute",
      requestType = com.google.cloud.networkservices.v1.GetTlsRouteRequest.class,
      responseType = com.google.cloud.networkservices.v1.TlsRoute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetTlsRouteRequest,
          com.google.cloud.networkservices.v1.TlsRoute>
      getGetTlsRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetTlsRouteRequest,
            com.google.cloud.networkservices.v1.TlsRoute>
        getGetTlsRouteMethod;
    if ((getGetTlsRouteMethod = NetworkServicesGrpc.getGetTlsRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetTlsRouteMethod = NetworkServicesGrpc.getGetTlsRouteMethod) == null) {
          NetworkServicesGrpc.getGetTlsRouteMethod =
              getGetTlsRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetTlsRouteRequest,
                          com.google.cloud.networkservices.v1.TlsRoute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTlsRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetTlsRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.TlsRoute.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("GetTlsRoute"))
                      .build();
        }
      }
    }
    return getGetTlsRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateTlsRouteRequest,
          com.google.longrunning.Operation>
      getCreateTlsRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTlsRoute",
      requestType = com.google.cloud.networkservices.v1.CreateTlsRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateTlsRouteRequest,
          com.google.longrunning.Operation>
      getCreateTlsRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateTlsRouteRequest,
            com.google.longrunning.Operation>
        getCreateTlsRouteMethod;
    if ((getCreateTlsRouteMethod = NetworkServicesGrpc.getCreateTlsRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateTlsRouteMethod = NetworkServicesGrpc.getCreateTlsRouteMethod) == null) {
          NetworkServicesGrpc.getCreateTlsRouteMethod =
              getCreateTlsRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateTlsRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTlsRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateTlsRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateTlsRoute"))
                      .build();
        }
      }
    }
    return getCreateTlsRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateTlsRouteRequest,
          com.google.longrunning.Operation>
      getUpdateTlsRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTlsRoute",
      requestType = com.google.cloud.networkservices.v1.UpdateTlsRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateTlsRouteRequest,
          com.google.longrunning.Operation>
      getUpdateTlsRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateTlsRouteRequest,
            com.google.longrunning.Operation>
        getUpdateTlsRouteMethod;
    if ((getUpdateTlsRouteMethod = NetworkServicesGrpc.getUpdateTlsRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getUpdateTlsRouteMethod = NetworkServicesGrpc.getUpdateTlsRouteMethod) == null) {
          NetworkServicesGrpc.getUpdateTlsRouteMethod =
              getUpdateTlsRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateTlsRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTlsRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateTlsRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("UpdateTlsRoute"))
                      .build();
        }
      }
    }
    return getUpdateTlsRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteTlsRouteRequest,
          com.google.longrunning.Operation>
      getDeleteTlsRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTlsRoute",
      requestType = com.google.cloud.networkservices.v1.DeleteTlsRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteTlsRouteRequest,
          com.google.longrunning.Operation>
      getDeleteTlsRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteTlsRouteRequest,
            com.google.longrunning.Operation>
        getDeleteTlsRouteMethod;
    if ((getDeleteTlsRouteMethod = NetworkServicesGrpc.getDeleteTlsRouteMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteTlsRouteMethod = NetworkServicesGrpc.getDeleteTlsRouteMethod) == null) {
          NetworkServicesGrpc.getDeleteTlsRouteMethod =
              getDeleteTlsRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteTlsRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTlsRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteTlsRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteTlsRoute"))
                      .build();
        }
      }
    }
    return getDeleteTlsRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListServiceBindingsRequest,
          com.google.cloud.networkservices.v1.ListServiceBindingsResponse>
      getListServiceBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceBindings",
      requestType = com.google.cloud.networkservices.v1.ListServiceBindingsRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListServiceBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListServiceBindingsRequest,
          com.google.cloud.networkservices.v1.ListServiceBindingsResponse>
      getListServiceBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListServiceBindingsRequest,
            com.google.cloud.networkservices.v1.ListServiceBindingsResponse>
        getListServiceBindingsMethod;
    if ((getListServiceBindingsMethod = NetworkServicesGrpc.getListServiceBindingsMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListServiceBindingsMethod = NetworkServicesGrpc.getListServiceBindingsMethod)
            == null) {
          NetworkServicesGrpc.getListServiceBindingsMethod =
              getListServiceBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListServiceBindingsRequest,
                          com.google.cloud.networkservices.v1.ListServiceBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListServiceBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListServiceBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListServiceBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListServiceBindings"))
                      .build();
        }
      }
    }
    return getListServiceBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetServiceBindingRequest,
          com.google.cloud.networkservices.v1.ServiceBinding>
      getGetServiceBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceBinding",
      requestType = com.google.cloud.networkservices.v1.GetServiceBindingRequest.class,
      responseType = com.google.cloud.networkservices.v1.ServiceBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetServiceBindingRequest,
          com.google.cloud.networkservices.v1.ServiceBinding>
      getGetServiceBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetServiceBindingRequest,
            com.google.cloud.networkservices.v1.ServiceBinding>
        getGetServiceBindingMethod;
    if ((getGetServiceBindingMethod = NetworkServicesGrpc.getGetServiceBindingMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetServiceBindingMethod = NetworkServicesGrpc.getGetServiceBindingMethod) == null) {
          NetworkServicesGrpc.getGetServiceBindingMethod =
              getGetServiceBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetServiceBindingRequest,
                          com.google.cloud.networkservices.v1.ServiceBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetServiceBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ServiceBinding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("GetServiceBinding"))
                      .build();
        }
      }
    }
    return getGetServiceBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateServiceBindingRequest,
          com.google.longrunning.Operation>
      getCreateServiceBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceBinding",
      requestType = com.google.cloud.networkservices.v1.CreateServiceBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateServiceBindingRequest,
          com.google.longrunning.Operation>
      getCreateServiceBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateServiceBindingRequest,
            com.google.longrunning.Operation>
        getCreateServiceBindingMethod;
    if ((getCreateServiceBindingMethod = NetworkServicesGrpc.getCreateServiceBindingMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateServiceBindingMethod = NetworkServicesGrpc.getCreateServiceBindingMethod)
            == null) {
          NetworkServicesGrpc.getCreateServiceBindingMethod =
              getCreateServiceBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateServiceBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateServiceBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateServiceBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateServiceBinding"))
                      .build();
        }
      }
    }
    return getCreateServiceBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteServiceBindingRequest,
          com.google.longrunning.Operation>
      getDeleteServiceBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceBinding",
      requestType = com.google.cloud.networkservices.v1.DeleteServiceBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteServiceBindingRequest,
          com.google.longrunning.Operation>
      getDeleteServiceBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteServiceBindingRequest,
            com.google.longrunning.Operation>
        getDeleteServiceBindingMethod;
    if ((getDeleteServiceBindingMethod = NetworkServicesGrpc.getDeleteServiceBindingMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteServiceBindingMethod = NetworkServicesGrpc.getDeleteServiceBindingMethod)
            == null) {
          NetworkServicesGrpc.getDeleteServiceBindingMethod =
              getDeleteServiceBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteServiceBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteServiceBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteServiceBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteServiceBinding"))
                      .build();
        }
      }
    }
    return getDeleteServiceBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListMeshesRequest,
          com.google.cloud.networkservices.v1.ListMeshesResponse>
      getListMeshesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMeshes",
      requestType = com.google.cloud.networkservices.v1.ListMeshesRequest.class,
      responseType = com.google.cloud.networkservices.v1.ListMeshesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.ListMeshesRequest,
          com.google.cloud.networkservices.v1.ListMeshesResponse>
      getListMeshesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.ListMeshesRequest,
            com.google.cloud.networkservices.v1.ListMeshesResponse>
        getListMeshesMethod;
    if ((getListMeshesMethod = NetworkServicesGrpc.getListMeshesMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListMeshesMethod = NetworkServicesGrpc.getListMeshesMethod) == null) {
          NetworkServicesGrpc.getListMeshesMethod =
              getListMeshesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.ListMeshesRequest,
                          com.google.cloud.networkservices.v1.ListMeshesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMeshes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListMeshesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.ListMeshesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListMeshes"))
                      .build();
        }
      }
    }
    return getListMeshesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetMeshRequest,
          com.google.cloud.networkservices.v1.Mesh>
      getGetMeshMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMesh",
      requestType = com.google.cloud.networkservices.v1.GetMeshRequest.class,
      responseType = com.google.cloud.networkservices.v1.Mesh.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.GetMeshRequest,
          com.google.cloud.networkservices.v1.Mesh>
      getGetMeshMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.GetMeshRequest,
            com.google.cloud.networkservices.v1.Mesh>
        getGetMeshMethod;
    if ((getGetMeshMethod = NetworkServicesGrpc.getGetMeshMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetMeshMethod = NetworkServicesGrpc.getGetMeshMethod) == null) {
          NetworkServicesGrpc.getGetMeshMethod =
              getGetMeshMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.GetMeshRequest,
                          com.google.cloud.networkservices.v1.Mesh>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMesh"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.GetMeshRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.Mesh.getDefaultInstance()))
                      .setSchemaDescriptor(new NetworkServicesMethodDescriptorSupplier("GetMesh"))
                      .build();
        }
      }
    }
    return getGetMeshMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateMeshRequest, com.google.longrunning.Operation>
      getCreateMeshMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMesh",
      requestType = com.google.cloud.networkservices.v1.CreateMeshRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.CreateMeshRequest, com.google.longrunning.Operation>
      getCreateMeshMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.CreateMeshRequest, com.google.longrunning.Operation>
        getCreateMeshMethod;
    if ((getCreateMeshMethod = NetworkServicesGrpc.getCreateMeshMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateMeshMethod = NetworkServicesGrpc.getCreateMeshMethod) == null) {
          NetworkServicesGrpc.getCreateMeshMethod =
              getCreateMeshMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.CreateMeshRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMesh"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.CreateMeshRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateMesh"))
                      .build();
        }
      }
    }
    return getCreateMeshMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateMeshRequest, com.google.longrunning.Operation>
      getUpdateMeshMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMesh",
      requestType = com.google.cloud.networkservices.v1.UpdateMeshRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.UpdateMeshRequest, com.google.longrunning.Operation>
      getUpdateMeshMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.UpdateMeshRequest, com.google.longrunning.Operation>
        getUpdateMeshMethod;
    if ((getUpdateMeshMethod = NetworkServicesGrpc.getUpdateMeshMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getUpdateMeshMethod = NetworkServicesGrpc.getUpdateMeshMethod) == null) {
          NetworkServicesGrpc.getUpdateMeshMethod =
              getUpdateMeshMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.UpdateMeshRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMesh"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.UpdateMeshRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("UpdateMesh"))
                      .build();
        }
      }
    }
    return getUpdateMeshMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteMeshRequest, com.google.longrunning.Operation>
      getDeleteMeshMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMesh",
      requestType = com.google.cloud.networkservices.v1.DeleteMeshRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1.DeleteMeshRequest, com.google.longrunning.Operation>
      getDeleteMeshMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1.DeleteMeshRequest, com.google.longrunning.Operation>
        getDeleteMeshMethod;
    if ((getDeleteMeshMethod = NetworkServicesGrpc.getDeleteMeshMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteMeshMethod = NetworkServicesGrpc.getDeleteMeshMethod) == null) {
          NetworkServicesGrpc.getDeleteMeshMethod =
              getDeleteMeshMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1.DeleteMeshRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMesh"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1.DeleteMeshRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteMesh"))
                      .build();
        }
      }
    }
    return getDeleteMeshMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NetworkServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkServicesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkServicesStub>() {
          @java.lang.Override
          public NetworkServicesStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkServicesStub(channel, callOptions);
          }
        };
    return NetworkServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NetworkServicesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkServicesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkServicesBlockingStub>() {
          @java.lang.Override
          public NetworkServicesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkServicesBlockingStub(channel, callOptions);
          }
        };
    return NetworkServicesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NetworkServicesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkServicesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkServicesFutureStub>() {
          @java.lang.Override
          public NetworkServicesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkServicesFutureStub(channel, callOptions);
          }
        };
    return NetworkServicesFutureStub.newStub(factory, channel);
  }

  /** */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    default void listEndpointPolicies(
        com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEndpointPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    default void getEndpointPolicy(
        com.google.cloud.networkservices.v1.GetEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.EndpointPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEndpointPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    default void createEndpointPolicy(
        com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEndpointPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    default void updateEndpointPolicy(
        com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEndpointPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    default void deleteEndpointPolicy(
        com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEndpointPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Gateways in a given project and location.
     * </pre>
     */
    default void listGateways(
        com.google.cloud.networkservices.v1.ListGatewaysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListGatewaysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGatewaysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Gateway.
     * </pre>
     */
    default void getGateway(
        com.google.cloud.networkservices.v1.GetGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.Gateway> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGatewayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Gateway in a given project and location.
     * </pre>
     */
    default void createGateway(
        com.google.cloud.networkservices.v1.CreateGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGatewayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Gateway.
     * </pre>
     */
    default void updateGateway(
        com.google.cloud.networkservices.v1.UpdateGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGatewayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Gateway.
     * </pre>
     */
    default void deleteGateway(
        com.google.cloud.networkservices.v1.DeleteGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGatewayMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GrpcRoutes in a given project and location.
     * </pre>
     */
    default void listGrpcRoutes(
        com.google.cloud.networkservices.v1.ListGrpcRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGrpcRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GrpcRoute.
     * </pre>
     */
    default void getGrpcRoute(
        com.google.cloud.networkservices.v1.GetGrpcRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.GrpcRoute>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGrpcRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GrpcRoute in a given project and location.
     * </pre>
     */
    default void createGrpcRoute(
        com.google.cloud.networkservices.v1.CreateGrpcRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGrpcRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GrpcRoute.
     * </pre>
     */
    default void updateGrpcRoute(
        com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGrpcRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GrpcRoute.
     * </pre>
     */
    default void deleteGrpcRoute(
        com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGrpcRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists HttpRoute in a given project and location.
     * </pre>
     */
    default void listHttpRoutes(
        com.google.cloud.networkservices.v1.ListHttpRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListHttpRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHttpRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single HttpRoute.
     * </pre>
     */
    default void getHttpRoute(
        com.google.cloud.networkservices.v1.GetHttpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.HttpRoute>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHttpRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new HttpRoute in a given project and location.
     * </pre>
     */
    default void createHttpRoute(
        com.google.cloud.networkservices.v1.CreateHttpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHttpRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single HttpRoute.
     * </pre>
     */
    default void updateHttpRoute(
        com.google.cloud.networkservices.v1.UpdateHttpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateHttpRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single HttpRoute.
     * </pre>
     */
    default void deleteHttpRoute(
        com.google.cloud.networkservices.v1.DeleteHttpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteHttpRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TcpRoute in a given project and location.
     * </pre>
     */
    default void listTcpRoutes(
        com.google.cloud.networkservices.v1.ListTcpRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListTcpRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTcpRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TcpRoute.
     * </pre>
     */
    default void getTcpRoute(
        com.google.cloud.networkservices.v1.GetTcpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.TcpRoute>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTcpRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TcpRoute in a given project and location.
     * </pre>
     */
    default void createTcpRoute(
        com.google.cloud.networkservices.v1.CreateTcpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTcpRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TcpRoute.
     * </pre>
     */
    default void updateTcpRoute(
        com.google.cloud.networkservices.v1.UpdateTcpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTcpRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TcpRoute.
     * </pre>
     */
    default void deleteTcpRoute(
        com.google.cloud.networkservices.v1.DeleteTcpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTcpRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsRoute in a given project and location.
     * </pre>
     */
    default void listTlsRoutes(
        com.google.cloud.networkservices.v1.ListTlsRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListTlsRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTlsRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsRoute.
     * </pre>
     */
    default void getTlsRoute(
        com.google.cloud.networkservices.v1.GetTlsRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.TlsRoute>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTlsRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsRoute in a given project and location.
     * </pre>
     */
    default void createTlsRoute(
        com.google.cloud.networkservices.v1.CreateTlsRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTlsRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsRoute.
     * </pre>
     */
    default void updateTlsRoute(
        com.google.cloud.networkservices.v1.UpdateTlsRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTlsRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsRoute.
     * </pre>
     */
    default void deleteTlsRoute(
        com.google.cloud.networkservices.v1.DeleteTlsRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTlsRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceBinding in a given project and location.
     * </pre>
     */
    default void listServiceBindings(
        com.google.cloud.networkservices.v1.ListServiceBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListServiceBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServiceBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceBinding.
     * </pre>
     */
    default void getServiceBinding(
        com.google.cloud.networkservices.v1.GetServiceBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ServiceBinding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServiceBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceBinding in a given project and location.
     * </pre>
     */
    default void createServiceBinding(
        com.google.cloud.networkservices.v1.CreateServiceBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceBinding.
     * </pre>
     */
    default void deleteServiceBinding(
        com.google.cloud.networkservices.v1.DeleteServiceBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Meshes in a given project and location.
     * </pre>
     */
    default void listMeshes(
        com.google.cloud.networkservices.v1.ListMeshesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListMeshesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMeshesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Mesh.
     * </pre>
     */
    default void getMesh(
        com.google.cloud.networkservices.v1.GetMeshRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.Mesh> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMeshMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Mesh in a given project and location.
     * </pre>
     */
    default void createMesh(
        com.google.cloud.networkservices.v1.CreateMeshRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMeshMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Mesh.
     * </pre>
     */
    default void updateMesh(
        com.google.cloud.networkservices.v1.UpdateMeshRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMeshMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Mesh.
     * </pre>
     */
    default void deleteMesh(
        com.google.cloud.networkservices.v1.DeleteMeshRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMeshMethod(), responseObserver);
    }
  }

  /** Base class for the server implementation of the service NetworkServices. */
  public abstract static class NetworkServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NetworkServicesGrpc.bindService(this);
    }
  }

  /** A stub to allow clients to do asynchronous rpc calls to service NetworkServices. */
  public static final class NetworkServicesStub
      extends io.grpc.stub.AbstractAsyncStub<NetworkServicesStub> {
    private NetworkServicesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkServicesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkServicesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    public void listEndpointPolicies(
        com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEndpointPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    public void getEndpointPolicy(
        com.google.cloud.networkservices.v1.GetEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.EndpointPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEndpointPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    public void createEndpointPolicy(
        com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEndpointPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    public void updateEndpointPolicy(
        com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEndpointPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    public void deleteEndpointPolicy(
        com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEndpointPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Gateways in a given project and location.
     * </pre>
     */
    public void listGateways(
        com.google.cloud.networkservices.v1.ListGatewaysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListGatewaysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGatewaysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Gateway.
     * </pre>
     */
    public void getGateway(
        com.google.cloud.networkservices.v1.GetGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.Gateway> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGatewayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Gateway in a given project and location.
     * </pre>
     */
    public void createGateway(
        com.google.cloud.networkservices.v1.CreateGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGatewayMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Gateway.
     * </pre>
     */
    public void updateGateway(
        com.google.cloud.networkservices.v1.UpdateGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGatewayMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Gateway.
     * </pre>
     */
    public void deleteGateway(
        com.google.cloud.networkservices.v1.DeleteGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGatewayMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GrpcRoutes in a given project and location.
     * </pre>
     */
    public void listGrpcRoutes(
        com.google.cloud.networkservices.v1.ListGrpcRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGrpcRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GrpcRoute.
     * </pre>
     */
    public void getGrpcRoute(
        com.google.cloud.networkservices.v1.GetGrpcRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.GrpcRoute>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGrpcRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GrpcRoute in a given project and location.
     * </pre>
     */
    public void createGrpcRoute(
        com.google.cloud.networkservices.v1.CreateGrpcRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGrpcRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GrpcRoute.
     * </pre>
     */
    public void updateGrpcRoute(
        com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGrpcRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GrpcRoute.
     * </pre>
     */
    public void deleteGrpcRoute(
        com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGrpcRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists HttpRoute in a given project and location.
     * </pre>
     */
    public void listHttpRoutes(
        com.google.cloud.networkservices.v1.ListHttpRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListHttpRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHttpRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single HttpRoute.
     * </pre>
     */
    public void getHttpRoute(
        com.google.cloud.networkservices.v1.GetHttpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.HttpRoute>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHttpRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new HttpRoute in a given project and location.
     * </pre>
     */
    public void createHttpRoute(
        com.google.cloud.networkservices.v1.CreateHttpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHttpRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single HttpRoute.
     * </pre>
     */
    public void updateHttpRoute(
        com.google.cloud.networkservices.v1.UpdateHttpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHttpRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single HttpRoute.
     * </pre>
     */
    public void deleteHttpRoute(
        com.google.cloud.networkservices.v1.DeleteHttpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHttpRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TcpRoute in a given project and location.
     * </pre>
     */
    public void listTcpRoutes(
        com.google.cloud.networkservices.v1.ListTcpRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListTcpRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTcpRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TcpRoute.
     * </pre>
     */
    public void getTcpRoute(
        com.google.cloud.networkservices.v1.GetTcpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.TcpRoute>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTcpRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TcpRoute in a given project and location.
     * </pre>
     */
    public void createTcpRoute(
        com.google.cloud.networkservices.v1.CreateTcpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTcpRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TcpRoute.
     * </pre>
     */
    public void updateTcpRoute(
        com.google.cloud.networkservices.v1.UpdateTcpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTcpRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TcpRoute.
     * </pre>
     */
    public void deleteTcpRoute(
        com.google.cloud.networkservices.v1.DeleteTcpRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTcpRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsRoute in a given project and location.
     * </pre>
     */
    public void listTlsRoutes(
        com.google.cloud.networkservices.v1.ListTlsRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListTlsRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTlsRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsRoute.
     * </pre>
     */
    public void getTlsRoute(
        com.google.cloud.networkservices.v1.GetTlsRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.TlsRoute>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTlsRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsRoute in a given project and location.
     * </pre>
     */
    public void createTlsRoute(
        com.google.cloud.networkservices.v1.CreateTlsRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTlsRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsRoute.
     * </pre>
     */
    public void updateTlsRoute(
        com.google.cloud.networkservices.v1.UpdateTlsRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTlsRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsRoute.
     * </pre>
     */
    public void deleteTlsRoute(
        com.google.cloud.networkservices.v1.DeleteTlsRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTlsRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceBinding in a given project and location.
     * </pre>
     */
    public void listServiceBindings(
        com.google.cloud.networkservices.v1.ListServiceBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListServiceBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceBinding.
     * </pre>
     */
    public void getServiceBinding(
        com.google.cloud.networkservices.v1.GetServiceBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ServiceBinding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceBinding in a given project and location.
     * </pre>
     */
    public void createServiceBinding(
        com.google.cloud.networkservices.v1.CreateServiceBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceBinding.
     * </pre>
     */
    public void deleteServiceBinding(
        com.google.cloud.networkservices.v1.DeleteServiceBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Meshes in a given project and location.
     * </pre>
     */
    public void listMeshes(
        com.google.cloud.networkservices.v1.ListMeshesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListMeshesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMeshesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Mesh.
     * </pre>
     */
    public void getMesh(
        com.google.cloud.networkservices.v1.GetMeshRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.Mesh> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMeshMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Mesh in a given project and location.
     * </pre>
     */
    public void createMesh(
        com.google.cloud.networkservices.v1.CreateMeshRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMeshMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Mesh.
     * </pre>
     */
    public void updateMesh(
        com.google.cloud.networkservices.v1.UpdateMeshRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMeshMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Mesh.
     * </pre>
     */
    public void deleteMesh(
        com.google.cloud.networkservices.v1.DeleteMeshRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMeshMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /** A stub to allow clients to do synchronous rpc calls to service NetworkServices. */
  public static final class NetworkServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NetworkServicesBlockingStub> {
    private NetworkServicesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkServicesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse listEndpointPolicies(
        com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEndpointPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.EndpointPolicy getEndpointPolicy(
        com.google.cloud.networkservices.v1.GetEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEndpointPolicy(
        com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateEndpointPolicy(
        com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEndpointPolicy(
        com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Gateways in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListGatewaysResponse listGateways(
        com.google.cloud.networkservices.v1.ListGatewaysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGatewaysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Gateway.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.Gateway getGateway(
        com.google.cloud.networkservices.v1.GetGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGatewayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Gateway in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGateway(
        com.google.cloud.networkservices.v1.CreateGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGatewayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Gateway.
     * </pre>
     */
    public com.google.longrunning.Operation updateGateway(
        com.google.cloud.networkservices.v1.UpdateGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGatewayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Gateway.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGateway(
        com.google.cloud.networkservices.v1.DeleteGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGatewayMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GrpcRoutes in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListGrpcRoutesResponse listGrpcRoutes(
        com.google.cloud.networkservices.v1.ListGrpcRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGrpcRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GrpcRoute.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.GrpcRoute getGrpcRoute(
        com.google.cloud.networkservices.v1.GetGrpcRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGrpcRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GrpcRoute in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGrpcRoute(
        com.google.cloud.networkservices.v1.CreateGrpcRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGrpcRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GrpcRoute.
     * </pre>
     */
    public com.google.longrunning.Operation updateGrpcRoute(
        com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGrpcRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GrpcRoute.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGrpcRoute(
        com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGrpcRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists HttpRoute in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListHttpRoutesResponse listHttpRoutes(
        com.google.cloud.networkservices.v1.ListHttpRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHttpRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single HttpRoute.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.HttpRoute getHttpRoute(
        com.google.cloud.networkservices.v1.GetHttpRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHttpRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new HttpRoute in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createHttpRoute(
        com.google.cloud.networkservices.v1.CreateHttpRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHttpRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single HttpRoute.
     * </pre>
     */
    public com.google.longrunning.Operation updateHttpRoute(
        com.google.cloud.networkservices.v1.UpdateHttpRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHttpRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single HttpRoute.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHttpRoute(
        com.google.cloud.networkservices.v1.DeleteHttpRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHttpRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TcpRoute in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListTcpRoutesResponse listTcpRoutes(
        com.google.cloud.networkservices.v1.ListTcpRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTcpRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TcpRoute.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.TcpRoute getTcpRoute(
        com.google.cloud.networkservices.v1.GetTcpRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTcpRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TcpRoute in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTcpRoute(
        com.google.cloud.networkservices.v1.CreateTcpRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTcpRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TcpRoute.
     * </pre>
     */
    public com.google.longrunning.Operation updateTcpRoute(
        com.google.cloud.networkservices.v1.UpdateTcpRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTcpRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TcpRoute.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTcpRoute(
        com.google.cloud.networkservices.v1.DeleteTcpRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTcpRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsRoute in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListTlsRoutesResponse listTlsRoutes(
        com.google.cloud.networkservices.v1.ListTlsRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTlsRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsRoute.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.TlsRoute getTlsRoute(
        com.google.cloud.networkservices.v1.GetTlsRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTlsRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsRoute in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTlsRoute(
        com.google.cloud.networkservices.v1.CreateTlsRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTlsRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsRoute.
     * </pre>
     */
    public com.google.longrunning.Operation updateTlsRoute(
        com.google.cloud.networkservices.v1.UpdateTlsRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTlsRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsRoute.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTlsRoute(
        com.google.cloud.networkservices.v1.DeleteTlsRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTlsRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceBinding in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListServiceBindingsResponse listServiceBindings(
        com.google.cloud.networkservices.v1.ListServiceBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceBinding.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ServiceBinding getServiceBinding(
        com.google.cloud.networkservices.v1.GetServiceBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceBinding in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServiceBinding(
        com.google.cloud.networkservices.v1.CreateServiceBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceBinding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceBinding(
        com.google.cloud.networkservices.v1.DeleteServiceBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Meshes in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.ListMeshesResponse listMeshes(
        com.google.cloud.networkservices.v1.ListMeshesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMeshesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Mesh.
     * </pre>
     */
    public com.google.cloud.networkservices.v1.Mesh getMesh(
        com.google.cloud.networkservices.v1.GetMeshRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMeshMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Mesh in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createMesh(
        com.google.cloud.networkservices.v1.CreateMeshRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMeshMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Mesh.
     * </pre>
     */
    public com.google.longrunning.Operation updateMesh(
        com.google.cloud.networkservices.v1.UpdateMeshRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMeshMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Mesh.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMesh(
        com.google.cloud.networkservices.v1.DeleteMeshRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMeshMethod(), getCallOptions(), request);
    }
  }

  /** A stub to allow clients to do ListenableFuture-style rpc calls to service NetworkServices. */
  public static final class NetworkServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<NetworkServicesFutureStub> {
    private NetworkServicesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkServicesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>
        listEndpointPolicies(
            com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEndpointPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.EndpointPolicy>
        getEndpointPolicy(com.google.cloud.networkservices.v1.GetEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEndpointPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEndpointPolicy(
            com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEndpointPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEndpointPolicy(
            com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEndpointPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEndpointPolicy(
            com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEndpointPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Gateways in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListGatewaysResponse>
        listGateways(com.google.cloud.networkservices.v1.ListGatewaysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGatewaysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.Gateway>
        getGateway(com.google.cloud.networkservices.v1.GetGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGatewayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Gateway in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGateway(com.google.cloud.networkservices.v1.CreateGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGatewayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGateway(com.google.cloud.networkservices.v1.UpdateGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGatewayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGateway(com.google.cloud.networkservices.v1.DeleteGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGatewayMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GrpcRoutes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>
        listGrpcRoutes(com.google.cloud.networkservices.v1.ListGrpcRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGrpcRoutesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single GrpcRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.GrpcRoute>
        getGrpcRoute(com.google.cloud.networkservices.v1.GetGrpcRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGrpcRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GrpcRoute in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGrpcRoute(com.google.cloud.networkservices.v1.CreateGrpcRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGrpcRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single GrpcRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGrpcRoute(com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGrpcRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single GrpcRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGrpcRoute(com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGrpcRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists HttpRoute in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListHttpRoutesResponse>
        listHttpRoutes(com.google.cloud.networkservices.v1.ListHttpRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHttpRoutesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single HttpRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.HttpRoute>
        getHttpRoute(com.google.cloud.networkservices.v1.GetHttpRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHttpRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new HttpRoute in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createHttpRoute(com.google.cloud.networkservices.v1.CreateHttpRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHttpRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single HttpRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateHttpRoute(com.google.cloud.networkservices.v1.UpdateHttpRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHttpRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single HttpRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteHttpRoute(com.google.cloud.networkservices.v1.DeleteHttpRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHttpRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TcpRoute in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListTcpRoutesResponse>
        listTcpRoutes(com.google.cloud.networkservices.v1.ListTcpRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTcpRoutesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TcpRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.TcpRoute>
        getTcpRoute(com.google.cloud.networkservices.v1.GetTcpRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTcpRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TcpRoute in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTcpRoute(com.google.cloud.networkservices.v1.CreateTcpRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTcpRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TcpRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTcpRoute(com.google.cloud.networkservices.v1.UpdateTcpRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTcpRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TcpRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTcpRoute(com.google.cloud.networkservices.v1.DeleteTcpRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTcpRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TlsRoute in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListTlsRoutesResponse>
        listTlsRoutes(com.google.cloud.networkservices.v1.ListTlsRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTlsRoutesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TlsRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.TlsRoute>
        getTlsRoute(com.google.cloud.networkservices.v1.GetTlsRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTlsRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TlsRoute in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTlsRoute(com.google.cloud.networkservices.v1.CreateTlsRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTlsRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single TlsRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTlsRoute(com.google.cloud.networkservices.v1.UpdateTlsRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTlsRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TlsRoute.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTlsRoute(com.google.cloud.networkservices.v1.DeleteTlsRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTlsRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ServiceBinding in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListServiceBindingsResponse>
        listServiceBindings(
            com.google.cloud.networkservices.v1.ListServiceBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ServiceBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ServiceBinding>
        getServiceBinding(com.google.cloud.networkservices.v1.GetServiceBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ServiceBinding in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createServiceBinding(
            com.google.cloud.networkservices.v1.CreateServiceBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ServiceBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteServiceBinding(
            com.google.cloud.networkservices.v1.DeleteServiceBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Meshes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.ListMeshesResponse>
        listMeshes(com.google.cloud.networkservices.v1.ListMeshesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMeshesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Mesh.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1.Mesh>
        getMesh(com.google.cloud.networkservices.v1.GetMeshRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMeshMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Mesh in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMesh(com.google.cloud.networkservices.v1.CreateMeshRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMeshMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Mesh.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMesh(com.google.cloud.networkservices.v1.UpdateMeshRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMeshMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Mesh.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMesh(com.google.cloud.networkservices.v1.DeleteMeshRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMeshMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ENDPOINT_POLICIES = 0;
  private static final int METHODID_GET_ENDPOINT_POLICY = 1;
  private static final int METHODID_CREATE_ENDPOINT_POLICY = 2;
  private static final int METHODID_UPDATE_ENDPOINT_POLICY = 3;
  private static final int METHODID_DELETE_ENDPOINT_POLICY = 4;
  private static final int METHODID_LIST_GATEWAYS = 5;
  private static final int METHODID_GET_GATEWAY = 6;
  private static final int METHODID_CREATE_GATEWAY = 7;
  private static final int METHODID_UPDATE_GATEWAY = 8;
  private static final int METHODID_DELETE_GATEWAY = 9;
  private static final int METHODID_LIST_GRPC_ROUTES = 10;
  private static final int METHODID_GET_GRPC_ROUTE = 11;
  private static final int METHODID_CREATE_GRPC_ROUTE = 12;
  private static final int METHODID_UPDATE_GRPC_ROUTE = 13;
  private static final int METHODID_DELETE_GRPC_ROUTE = 14;
  private static final int METHODID_LIST_HTTP_ROUTES = 15;
  private static final int METHODID_GET_HTTP_ROUTE = 16;
  private static final int METHODID_CREATE_HTTP_ROUTE = 17;
  private static final int METHODID_UPDATE_HTTP_ROUTE = 18;
  private static final int METHODID_DELETE_HTTP_ROUTE = 19;
  private static final int METHODID_LIST_TCP_ROUTES = 20;
  private static final int METHODID_GET_TCP_ROUTE = 21;
  private static final int METHODID_CREATE_TCP_ROUTE = 22;
  private static final int METHODID_UPDATE_TCP_ROUTE = 23;
  private static final int METHODID_DELETE_TCP_ROUTE = 24;
  private static final int METHODID_LIST_TLS_ROUTES = 25;
  private static final int METHODID_GET_TLS_ROUTE = 26;
  private static final int METHODID_CREATE_TLS_ROUTE = 27;
  private static final int METHODID_UPDATE_TLS_ROUTE = 28;
  private static final int METHODID_DELETE_TLS_ROUTE = 29;
  private static final int METHODID_LIST_SERVICE_BINDINGS = 30;
  private static final int METHODID_GET_SERVICE_BINDING = 31;
  private static final int METHODID_CREATE_SERVICE_BINDING = 32;
  private static final int METHODID_DELETE_SERVICE_BINDING = 33;
  private static final int METHODID_LIST_MESHES = 34;
  private static final int METHODID_GET_MESH = 35;
  private static final int METHODID_CREATE_MESH = 36;
  private static final int METHODID_UPDATE_MESH = 37;
  private static final int METHODID_DELETE_MESH = 38;

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
        case METHODID_LIST_ENDPOINT_POLICIES:
          serviceImpl.listEndpointPolicies(
              (com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENDPOINT_POLICY:
          serviceImpl.getEndpointPolicy(
              (com.google.cloud.networkservices.v1.GetEndpointPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.EndpointPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENDPOINT_POLICY:
          serviceImpl.createEndpointPolicy(
              (com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENDPOINT_POLICY:
          serviceImpl.updateEndpointPolicy(
              (com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENDPOINT_POLICY:
          serviceImpl.deleteEndpointPolicy(
              (com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GATEWAYS:
          serviceImpl.listGateways(
              (com.google.cloud.networkservices.v1.ListGatewaysRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListGatewaysResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GATEWAY:
          serviceImpl.getGateway(
              (com.google.cloud.networkservices.v1.GetGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.Gateway>)
                  responseObserver);
          break;
        case METHODID_CREATE_GATEWAY:
          serviceImpl.createGateway(
              (com.google.cloud.networkservices.v1.CreateGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GATEWAY:
          serviceImpl.updateGateway(
              (com.google.cloud.networkservices.v1.UpdateGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GATEWAY:
          serviceImpl.deleteGateway(
              (com.google.cloud.networkservices.v1.DeleteGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GRPC_ROUTES:
          serviceImpl.listGrpcRoutes(
              (com.google.cloud.networkservices.v1.ListGrpcRoutesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GRPC_ROUTE:
          serviceImpl.getGrpcRoute(
              (com.google.cloud.networkservices.v1.GetGrpcRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.GrpcRoute>)
                  responseObserver);
          break;
        case METHODID_CREATE_GRPC_ROUTE:
          serviceImpl.createGrpcRoute(
              (com.google.cloud.networkservices.v1.CreateGrpcRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GRPC_ROUTE:
          serviceImpl.updateGrpcRoute(
              (com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GRPC_ROUTE:
          serviceImpl.deleteGrpcRoute(
              (com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_HTTP_ROUTES:
          serviceImpl.listHttpRoutes(
              (com.google.cloud.networkservices.v1.ListHttpRoutesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListHttpRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_HTTP_ROUTE:
          serviceImpl.getHttpRoute(
              (com.google.cloud.networkservices.v1.GetHttpRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.HttpRoute>)
                  responseObserver);
          break;
        case METHODID_CREATE_HTTP_ROUTE:
          serviceImpl.createHttpRoute(
              (com.google.cloud.networkservices.v1.CreateHttpRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_HTTP_ROUTE:
          serviceImpl.updateHttpRoute(
              (com.google.cloud.networkservices.v1.UpdateHttpRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_HTTP_ROUTE:
          serviceImpl.deleteHttpRoute(
              (com.google.cloud.networkservices.v1.DeleteHttpRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TCP_ROUTES:
          serviceImpl.listTcpRoutes(
              (com.google.cloud.networkservices.v1.ListTcpRoutesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListTcpRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TCP_ROUTE:
          serviceImpl.getTcpRoute(
              (com.google.cloud.networkservices.v1.GetTcpRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.TcpRoute>)
                  responseObserver);
          break;
        case METHODID_CREATE_TCP_ROUTE:
          serviceImpl.createTcpRoute(
              (com.google.cloud.networkservices.v1.CreateTcpRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TCP_ROUTE:
          serviceImpl.updateTcpRoute(
              (com.google.cloud.networkservices.v1.UpdateTcpRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TCP_ROUTE:
          serviceImpl.deleteTcpRoute(
              (com.google.cloud.networkservices.v1.DeleteTcpRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TLS_ROUTES:
          serviceImpl.listTlsRoutes(
              (com.google.cloud.networkservices.v1.ListTlsRoutesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListTlsRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TLS_ROUTE:
          serviceImpl.getTlsRoute(
              (com.google.cloud.networkservices.v1.GetTlsRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.TlsRoute>)
                  responseObserver);
          break;
        case METHODID_CREATE_TLS_ROUTE:
          serviceImpl.createTlsRoute(
              (com.google.cloud.networkservices.v1.CreateTlsRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TLS_ROUTE:
          serviceImpl.updateTlsRoute(
              (com.google.cloud.networkservices.v1.UpdateTlsRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TLS_ROUTE:
          serviceImpl.deleteTlsRoute(
              (com.google.cloud.networkservices.v1.DeleteTlsRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERVICE_BINDINGS:
          serviceImpl.listServiceBindings(
              (com.google.cloud.networkservices.v1.ListServiceBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1.ListServiceBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE_BINDING:
          serviceImpl.getServiceBinding(
              (com.google.cloud.networkservices.v1.GetServiceBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ServiceBinding>)
                  responseObserver);
          break;
        case METHODID_CREATE_SERVICE_BINDING:
          serviceImpl.createServiceBinding(
              (com.google.cloud.networkservices.v1.CreateServiceBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_BINDING:
          serviceImpl.deleteServiceBinding(
              (com.google.cloud.networkservices.v1.DeleteServiceBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MESHES:
          serviceImpl.listMeshes(
              (com.google.cloud.networkservices.v1.ListMeshesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.ListMeshesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MESH:
          serviceImpl.getMesh(
              (com.google.cloud.networkservices.v1.GetMeshRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1.Mesh>)
                  responseObserver);
          break;
        case METHODID_CREATE_MESH:
          serviceImpl.createMesh(
              (com.google.cloud.networkservices.v1.CreateMeshRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MESH:
          serviceImpl.updateMesh(
              (com.google.cloud.networkservices.v1.UpdateMeshRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MESH:
          serviceImpl.deleteMesh(
              (com.google.cloud.networkservices.v1.DeleteMeshRequest) request,
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
            getListEndpointPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest,
                    com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse>(
                    service, METHODID_LIST_ENDPOINT_POLICIES)))
        .addMethod(
            getGetEndpointPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetEndpointPolicyRequest,
                    com.google.cloud.networkservices.v1.EndpointPolicy>(
                    service, METHODID_GET_ENDPOINT_POLICY)))
        .addMethod(
            getCreateEndpointPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENDPOINT_POLICY)))
        .addMethod(
            getUpdateEndpointPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ENDPOINT_POLICY)))
        .addMethod(
            getDeleteEndpointPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENDPOINT_POLICY)))
        .addMethod(
            getListGatewaysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListGatewaysRequest,
                    com.google.cloud.networkservices.v1.ListGatewaysResponse>(
                    service, METHODID_LIST_GATEWAYS)))
        .addMethod(
            getGetGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetGatewayRequest,
                    com.google.cloud.networkservices.v1.Gateway>(service, METHODID_GET_GATEWAY)))
        .addMethod(
            getCreateGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateGatewayRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_GATEWAY)))
        .addMethod(
            getUpdateGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateGatewayRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_GATEWAY)))
        .addMethod(
            getDeleteGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteGatewayRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_GATEWAY)))
        .addMethod(
            getListGrpcRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListGrpcRoutesRequest,
                    com.google.cloud.networkservices.v1.ListGrpcRoutesResponse>(
                    service, METHODID_LIST_GRPC_ROUTES)))
        .addMethod(
            getGetGrpcRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetGrpcRouteRequest,
                    com.google.cloud.networkservices.v1.GrpcRoute>(
                    service, METHODID_GET_GRPC_ROUTE)))
        .addMethod(
            getCreateGrpcRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateGrpcRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_GRPC_ROUTE)))
        .addMethod(
            getUpdateGrpcRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_GRPC_ROUTE)))
        .addMethod(
            getDeleteGrpcRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_GRPC_ROUTE)))
        .addMethod(
            getListHttpRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListHttpRoutesRequest,
                    com.google.cloud.networkservices.v1.ListHttpRoutesResponse>(
                    service, METHODID_LIST_HTTP_ROUTES)))
        .addMethod(
            getGetHttpRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetHttpRouteRequest,
                    com.google.cloud.networkservices.v1.HttpRoute>(
                    service, METHODID_GET_HTTP_ROUTE)))
        .addMethod(
            getCreateHttpRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateHttpRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_HTTP_ROUTE)))
        .addMethod(
            getUpdateHttpRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateHttpRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_HTTP_ROUTE)))
        .addMethod(
            getDeleteHttpRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteHttpRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_HTTP_ROUTE)))
        .addMethod(
            getListTcpRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListTcpRoutesRequest,
                    com.google.cloud.networkservices.v1.ListTcpRoutesResponse>(
                    service, METHODID_LIST_TCP_ROUTES)))
        .addMethod(
            getGetTcpRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetTcpRouteRequest,
                    com.google.cloud.networkservices.v1.TcpRoute>(service, METHODID_GET_TCP_ROUTE)))
        .addMethod(
            getCreateTcpRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateTcpRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_TCP_ROUTE)))
        .addMethod(
            getUpdateTcpRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateTcpRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_TCP_ROUTE)))
        .addMethod(
            getDeleteTcpRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteTcpRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_TCP_ROUTE)))
        .addMethod(
            getListTlsRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListTlsRoutesRequest,
                    com.google.cloud.networkservices.v1.ListTlsRoutesResponse>(
                    service, METHODID_LIST_TLS_ROUTES)))
        .addMethod(
            getGetTlsRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetTlsRouteRequest,
                    com.google.cloud.networkservices.v1.TlsRoute>(service, METHODID_GET_TLS_ROUTE)))
        .addMethod(
            getCreateTlsRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateTlsRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_TLS_ROUTE)))
        .addMethod(
            getUpdateTlsRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateTlsRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_TLS_ROUTE)))
        .addMethod(
            getDeleteTlsRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteTlsRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_TLS_ROUTE)))
        .addMethod(
            getListServiceBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListServiceBindingsRequest,
                    com.google.cloud.networkservices.v1.ListServiceBindingsResponse>(
                    service, METHODID_LIST_SERVICE_BINDINGS)))
        .addMethod(
            getGetServiceBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetServiceBindingRequest,
                    com.google.cloud.networkservices.v1.ServiceBinding>(
                    service, METHODID_GET_SERVICE_BINDING)))
        .addMethod(
            getCreateServiceBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateServiceBindingRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SERVICE_BINDING)))
        .addMethod(
            getDeleteServiceBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteServiceBindingRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SERVICE_BINDING)))
        .addMethod(
            getListMeshesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.ListMeshesRequest,
                    com.google.cloud.networkservices.v1.ListMeshesResponse>(
                    service, METHODID_LIST_MESHES)))
        .addMethod(
            getGetMeshMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.GetMeshRequest,
                    com.google.cloud.networkservices.v1.Mesh>(service, METHODID_GET_MESH)))
        .addMethod(
            getCreateMeshMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.CreateMeshRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MESH)))
        .addMethod(
            getUpdateMeshMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.UpdateMeshRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MESH)))
        .addMethod(
            getDeleteMeshMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1.DeleteMeshRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MESH)))
        .build();
  }

  private abstract static class NetworkServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NetworkServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkservices.v1.NetworkServicesOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NetworkServices");
    }
  }

  private static final class NetworkServicesFileDescriptorSupplier
      extends NetworkServicesBaseDescriptorSupplier {
    NetworkServicesFileDescriptorSupplier() {}
  }

  private static final class NetworkServicesMethodDescriptorSupplier
      extends NetworkServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NetworkServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NetworkServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NetworkServicesFileDescriptorSupplier())
                      .addMethod(getListEndpointPoliciesMethod())
                      .addMethod(getGetEndpointPolicyMethod())
                      .addMethod(getCreateEndpointPolicyMethod())
                      .addMethod(getUpdateEndpointPolicyMethod())
                      .addMethod(getDeleteEndpointPolicyMethod())
                      .addMethod(getListGatewaysMethod())
                      .addMethod(getGetGatewayMethod())
                      .addMethod(getCreateGatewayMethod())
                      .addMethod(getUpdateGatewayMethod())
                      .addMethod(getDeleteGatewayMethod())
                      .addMethod(getListGrpcRoutesMethod())
                      .addMethod(getGetGrpcRouteMethod())
                      .addMethod(getCreateGrpcRouteMethod())
                      .addMethod(getUpdateGrpcRouteMethod())
                      .addMethod(getDeleteGrpcRouteMethod())
                      .addMethod(getListHttpRoutesMethod())
                      .addMethod(getGetHttpRouteMethod())
                      .addMethod(getCreateHttpRouteMethod())
                      .addMethod(getUpdateHttpRouteMethod())
                      .addMethod(getDeleteHttpRouteMethod())
                      .addMethod(getListTcpRoutesMethod())
                      .addMethod(getGetTcpRouteMethod())
                      .addMethod(getCreateTcpRouteMethod())
                      .addMethod(getUpdateTcpRouteMethod())
                      .addMethod(getDeleteTcpRouteMethod())
                      .addMethod(getListTlsRoutesMethod())
                      .addMethod(getGetTlsRouteMethod())
                      .addMethod(getCreateTlsRouteMethod())
                      .addMethod(getUpdateTlsRouteMethod())
                      .addMethod(getDeleteTlsRouteMethod())
                      .addMethod(getListServiceBindingsMethod())
                      .addMethod(getGetServiceBindingMethod())
                      .addMethod(getCreateServiceBindingMethod())
                      .addMethod(getDeleteServiceBindingMethod())
                      .addMethod(getListMeshesMethod())
                      .addMethod(getGetMeshMethod())
                      .addMethod(getCreateMeshMethod())
                      .addMethod(getUpdateMeshMethod())
                      .addMethod(getDeleteMeshMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
