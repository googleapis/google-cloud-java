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
package com.google.cloud.privilegedaccessmanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This API allows customers to manage temporary, request based privileged
 * access to their resources.
 * It defines the following resource model:
 * * A collection of `Entitlement` resources. An entitlement allows configuring
 *   (among other things):
 *   * Some kind of privileged access that users can request.
 *   * A set of users called _requesters_ who can request this access.
 *   * A maximum duration for which the access can be requested.
 *   * An optional approval workflow which must be satisfied before access is
 *     granted.
 * * A collection of `Grant` resources. A grant is a request by a requester to
 *   get the privileged access specified in an entitlement for some duration.
 *   After the approval workflow as specified in the entitlement is satisfied,
 *   the specified access is given to the requester. The access is automatically
 *   taken back after the requested duration is over.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/privilegedaccessmanager/v1/privilegedaccessmanager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PrivilegedAccessManagerGrpc {

  private PrivilegedAccessManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest,
          com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>
      getCheckOnboardingStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckOnboardingStatus",
      requestType = com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest.class,
      responseType =
          com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest,
          com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>
      getCheckOnboardingStatusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest,
            com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>
        getCheckOnboardingStatusMethod;
    if ((getCheckOnboardingStatusMethod =
            PrivilegedAccessManagerGrpc.getCheckOnboardingStatusMethod)
        == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getCheckOnboardingStatusMethod =
                PrivilegedAccessManagerGrpc.getCheckOnboardingStatusMethod)
            == null) {
          PrivilegedAccessManagerGrpc.getCheckOnboardingStatusMethod =
              getCheckOnboardingStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest,
                          com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CheckOnboardingStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1
                                  .CheckOnboardingStatusRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1
                                  .CheckOnboardingStatusResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier(
                              "CheckOnboardingStatus"))
                      .build();
        }
      }
    }
    return getCheckOnboardingStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest,
          com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>
      getListEntitlementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntitlements",
      requestType = com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest,
          com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>
      getListEntitlementsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest,
            com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>
        getListEntitlementsMethod;
    if ((getListEntitlementsMethod = PrivilegedAccessManagerGrpc.getListEntitlementsMethod)
        == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getListEntitlementsMethod = PrivilegedAccessManagerGrpc.getListEntitlementsMethod)
            == null) {
          PrivilegedAccessManagerGrpc.getListEntitlementsMethod =
              getListEntitlementsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest,
                          com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntitlements"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("ListEntitlements"))
                      .build();
        }
      }
    }
    return getListEntitlementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest,
          com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>
      getSearchEntitlementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchEntitlements",
      requestType = com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest,
          com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>
      getSearchEntitlementsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest,
            com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>
        getSearchEntitlementsMethod;
    if ((getSearchEntitlementsMethod = PrivilegedAccessManagerGrpc.getSearchEntitlementsMethod)
        == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getSearchEntitlementsMethod = PrivilegedAccessManagerGrpc.getSearchEntitlementsMethod)
            == null) {
          PrivilegedAccessManagerGrpc.getSearchEntitlementsMethod =
              getSearchEntitlementsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest,
                          com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchEntitlements"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("SearchEntitlements"))
                      .build();
        }
      }
    }
    return getSearchEntitlementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest,
          com.google.cloud.privilegedaccessmanager.v1.Entitlement>
      getGetEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntitlement",
      requestType = com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.Entitlement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest,
          com.google.cloud.privilegedaccessmanager.v1.Entitlement>
      getGetEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest,
            com.google.cloud.privilegedaccessmanager.v1.Entitlement>
        getGetEntitlementMethod;
    if ((getGetEntitlementMethod = PrivilegedAccessManagerGrpc.getGetEntitlementMethod) == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getGetEntitlementMethod = PrivilegedAccessManagerGrpc.getGetEntitlementMethod)
            == null) {
          PrivilegedAccessManagerGrpc.getGetEntitlementMethod =
              getGetEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest,
                          com.google.cloud.privilegedaccessmanager.v1.Entitlement>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.Entitlement
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("GetEntitlement"))
                      .build();
        }
      }
    }
    return getGetEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest,
          com.google.longrunning.Operation>
      getCreateEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntitlement",
      requestType = com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest,
          com.google.longrunning.Operation>
      getCreateEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest,
            com.google.longrunning.Operation>
        getCreateEntitlementMethod;
    if ((getCreateEntitlementMethod = PrivilegedAccessManagerGrpc.getCreateEntitlementMethod)
        == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getCreateEntitlementMethod = PrivilegedAccessManagerGrpc.getCreateEntitlementMethod)
            == null) {
          PrivilegedAccessManagerGrpc.getCreateEntitlementMethod =
              getCreateEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("CreateEntitlement"))
                      .build();
        }
      }
    }
    return getCreateEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest,
          com.google.longrunning.Operation>
      getDeleteEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntitlement",
      requestType = com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest,
          com.google.longrunning.Operation>
      getDeleteEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest,
            com.google.longrunning.Operation>
        getDeleteEntitlementMethod;
    if ((getDeleteEntitlementMethod = PrivilegedAccessManagerGrpc.getDeleteEntitlementMethod)
        == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getDeleteEntitlementMethod = PrivilegedAccessManagerGrpc.getDeleteEntitlementMethod)
            == null) {
          PrivilegedAccessManagerGrpc.getDeleteEntitlementMethod =
              getDeleteEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("DeleteEntitlement"))
                      .build();
        }
      }
    }
    return getDeleteEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest,
          com.google.longrunning.Operation>
      getUpdateEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntitlement",
      requestType = com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest,
          com.google.longrunning.Operation>
      getUpdateEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest,
            com.google.longrunning.Operation>
        getUpdateEntitlementMethod;
    if ((getUpdateEntitlementMethod = PrivilegedAccessManagerGrpc.getUpdateEntitlementMethod)
        == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getUpdateEntitlementMethod = PrivilegedAccessManagerGrpc.getUpdateEntitlementMethod)
            == null) {
          PrivilegedAccessManagerGrpc.getUpdateEntitlementMethod =
              getUpdateEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("UpdateEntitlement"))
                      .build();
        }
      }
    }
    return getUpdateEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest,
          com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>
      getListGrantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGrants",
      requestType = com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest,
          com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>
      getListGrantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest,
            com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>
        getListGrantsMethod;
    if ((getListGrantsMethod = PrivilegedAccessManagerGrpc.getListGrantsMethod) == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getListGrantsMethod = PrivilegedAccessManagerGrpc.getListGrantsMethod) == null) {
          PrivilegedAccessManagerGrpc.getListGrantsMethod =
              getListGrantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest,
                          com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGrants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("ListGrants"))
                      .build();
        }
      }
    }
    return getListGrantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest,
          com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>
      getSearchGrantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchGrants",
      requestType = com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest,
          com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>
      getSearchGrantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest,
            com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>
        getSearchGrantsMethod;
    if ((getSearchGrantsMethod = PrivilegedAccessManagerGrpc.getSearchGrantsMethod) == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getSearchGrantsMethod = PrivilegedAccessManagerGrpc.getSearchGrantsMethod) == null) {
          PrivilegedAccessManagerGrpc.getSearchGrantsMethod =
              getSearchGrantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest,
                          com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchGrants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("SearchGrants"))
                      .build();
        }
      }
    }
    return getSearchGrantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest,
          com.google.cloud.privilegedaccessmanager.v1.Grant>
      getGetGrantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGrant",
      requestType = com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.Grant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest,
          com.google.cloud.privilegedaccessmanager.v1.Grant>
      getGetGrantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest,
            com.google.cloud.privilegedaccessmanager.v1.Grant>
        getGetGrantMethod;
    if ((getGetGrantMethod = PrivilegedAccessManagerGrpc.getGetGrantMethod) == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getGetGrantMethod = PrivilegedAccessManagerGrpc.getGetGrantMethod) == null) {
          PrivilegedAccessManagerGrpc.getGetGrantMethod =
              getGetGrantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest,
                          com.google.cloud.privilegedaccessmanager.v1.Grant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGrant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.Grant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("GetGrant"))
                      .build();
        }
      }
    }
    return getGetGrantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest,
          com.google.cloud.privilegedaccessmanager.v1.Grant>
      getCreateGrantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGrant",
      requestType = com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.Grant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest,
          com.google.cloud.privilegedaccessmanager.v1.Grant>
      getCreateGrantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest,
            com.google.cloud.privilegedaccessmanager.v1.Grant>
        getCreateGrantMethod;
    if ((getCreateGrantMethod = PrivilegedAccessManagerGrpc.getCreateGrantMethod) == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getCreateGrantMethod = PrivilegedAccessManagerGrpc.getCreateGrantMethod) == null) {
          PrivilegedAccessManagerGrpc.getCreateGrantMethod =
              getCreateGrantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest,
                          com.google.cloud.privilegedaccessmanager.v1.Grant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGrant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.Grant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("CreateGrant"))
                      .build();
        }
      }
    }
    return getCreateGrantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest,
          com.google.cloud.privilegedaccessmanager.v1.Grant>
      getApproveGrantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApproveGrant",
      requestType = com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.Grant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest,
          com.google.cloud.privilegedaccessmanager.v1.Grant>
      getApproveGrantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest,
            com.google.cloud.privilegedaccessmanager.v1.Grant>
        getApproveGrantMethod;
    if ((getApproveGrantMethod = PrivilegedAccessManagerGrpc.getApproveGrantMethod) == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getApproveGrantMethod = PrivilegedAccessManagerGrpc.getApproveGrantMethod) == null) {
          PrivilegedAccessManagerGrpc.getApproveGrantMethod =
              getApproveGrantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest,
                          com.google.cloud.privilegedaccessmanager.v1.Grant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApproveGrant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.Grant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("ApproveGrant"))
                      .build();
        }
      }
    }
    return getApproveGrantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest,
          com.google.cloud.privilegedaccessmanager.v1.Grant>
      getDenyGrantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DenyGrant",
      requestType = com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest.class,
      responseType = com.google.cloud.privilegedaccessmanager.v1.Grant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest,
          com.google.cloud.privilegedaccessmanager.v1.Grant>
      getDenyGrantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest,
            com.google.cloud.privilegedaccessmanager.v1.Grant>
        getDenyGrantMethod;
    if ((getDenyGrantMethod = PrivilegedAccessManagerGrpc.getDenyGrantMethod) == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getDenyGrantMethod = PrivilegedAccessManagerGrpc.getDenyGrantMethod) == null) {
          PrivilegedAccessManagerGrpc.getDenyGrantMethod =
              getDenyGrantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest,
                          com.google.cloud.privilegedaccessmanager.v1.Grant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DenyGrant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.Grant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("DenyGrant"))
                      .build();
        }
      }
    }
    return getDenyGrantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest,
          com.google.longrunning.Operation>
      getRevokeGrantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RevokeGrant",
      requestType = com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest,
          com.google.longrunning.Operation>
      getRevokeGrantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest,
            com.google.longrunning.Operation>
        getRevokeGrantMethod;
    if ((getRevokeGrantMethod = PrivilegedAccessManagerGrpc.getRevokeGrantMethod) == null) {
      synchronized (PrivilegedAccessManagerGrpc.class) {
        if ((getRevokeGrantMethod = PrivilegedAccessManagerGrpc.getRevokeGrantMethod) == null) {
          PrivilegedAccessManagerGrpc.getRevokeGrantMethod =
              getRevokeGrantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RevokeGrant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrivilegedAccessManagerMethodDescriptorSupplier("RevokeGrant"))
                      .build();
        }
      }
    }
    return getRevokeGrantMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PrivilegedAccessManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivilegedAccessManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PrivilegedAccessManagerStub>() {
          @java.lang.Override
          public PrivilegedAccessManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PrivilegedAccessManagerStub(channel, callOptions);
          }
        };
    return PrivilegedAccessManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrivilegedAccessManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivilegedAccessManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PrivilegedAccessManagerBlockingStub>() {
          @java.lang.Override
          public PrivilegedAccessManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PrivilegedAccessManagerBlockingStub(channel, callOptions);
          }
        };
    return PrivilegedAccessManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PrivilegedAccessManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivilegedAccessManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PrivilegedAccessManagerFutureStub>() {
          @java.lang.Override
          public PrivilegedAccessManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PrivilegedAccessManagerFutureStub(channel, callOptions);
          }
        };
    return PrivilegedAccessManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This API allows customers to manage temporary, request based privileged
   * access to their resources.
   * It defines the following resource model:
   * * A collection of `Entitlement` resources. An entitlement allows configuring
   *   (among other things):
   *   * Some kind of privileged access that users can request.
   *   * A set of users called _requesters_ who can request this access.
   *   * A maximum duration for which the access can be requested.
   *   * An optional approval workflow which must be satisfied before access is
   *     granted.
   * * A collection of `Grant` resources. A grant is a request by a requester to
   *   get the privileged access specified in an entitlement for some duration.
   *   After the approval workflow as specified in the entitlement is satisfied,
   *   the specified access is given to the requester. The access is automatically
   *   taken back after the requested duration is over.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * CheckOnboardingStatus reports the onboarding status for a
     * project/folder/organization. Any findings reported by this API need to be
     * fixed before PAM can be used on the resource.
     * </pre>
     */
    default void checkOnboardingStatus(
        com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckOnboardingStatusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists entitlements in a given project/folder/organization and location.
     * </pre>
     */
    default void listEntitlements(
        com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntitlementsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `SearchEntitlements` returns entitlements on which the caller has the
     * specified access.
     * </pre>
     */
    default void searchEntitlements(
        com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchEntitlementsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single entitlement.
     * </pre>
     */
    default void getEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Entitlement>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new entitlement in a given project/folder/organization and
     * location.
     * </pre>
     */
    default void createEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single entitlement. This method can only be called when there
     * are no in-progress (ACTIVE/ACTIVATING/REVOKING) grants under the
     * entitlement.
     * </pre>
     */
    default void deleteEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the entitlement specified in the request. Updated fields in the
     * entitlement need to be specified in an update mask. The changes made to an
     * entitlement are applicable only on future grants of the entitlement.
     * However, if new approvers are added or existing approvers are removed from
     * the approval workflow, the changes are effective on existing grants.
     * The following fields are not supported for updates:
     *  * All immutable fields
     *  * Entitlement name
     *  * Resource name
     *  * Resource type
     *  * Adding an approval workflow in an entitlement which previously had no
     *    approval workflow.
     *  * Deleting the approval workflow from an entitlement.
     *  * Adding or deleting a step in the approval workflow (only one step is
     *    supported)
     * Note that updates are allowed on the list of approvers in an approval
     * workflow step.
     * </pre>
     */
    default void updateEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists grants for a given entitlement.
     * </pre>
     */
    default void listGrants(
        com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGrantsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `SearchGrants` returns grants that are related to the calling user in the
     * specified way.
     * </pre>
     */
    default void searchGrants(
        com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchGrantsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single grant.
     * </pre>
     */
    default void getGrant(
        com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGrantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new grant in a given project and location.
     * </pre>
     */
    default void createGrant(
        com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGrantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `ApproveGrant` is used to approve a grant. This method can only be called
     * on a grant when it's in the `APPROVAL_AWAITED` state. This operation can't
     * be undone.
     * </pre>
     */
    default void approveGrant(
        com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getApproveGrantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `DenyGrant` is used to deny a grant. This method can only be called on a
     * grant when it's in the `APPROVAL_AWAITED` state. This operation can't be
     * undone.
     * </pre>
     */
    default void denyGrant(
        com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDenyGrantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `RevokeGrant` is used to immediately revoke access for a grant. This method
     * can be called when the grant is in a non-terminal state.
     * </pre>
     */
    default void revokeGrant(
        com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRevokeGrantMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PrivilegedAccessManager.
   *
   * <pre>
   * This API allows customers to manage temporary, request based privileged
   * access to their resources.
   * It defines the following resource model:
   * * A collection of `Entitlement` resources. An entitlement allows configuring
   *   (among other things):
   *   * Some kind of privileged access that users can request.
   *   * A set of users called _requesters_ who can request this access.
   *   * A maximum duration for which the access can be requested.
   *   * An optional approval workflow which must be satisfied before access is
   *     granted.
   * * A collection of `Grant` resources. A grant is a request by a requester to
   *   get the privileged access specified in an entitlement for some duration.
   *   After the approval workflow as specified in the entitlement is satisfied,
   *   the specified access is given to the requester. The access is automatically
   *   taken back after the requested duration is over.
   * </pre>
   */
  public abstract static class PrivilegedAccessManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PrivilegedAccessManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PrivilegedAccessManager.
   *
   * <pre>
   * This API allows customers to manage temporary, request based privileged
   * access to their resources.
   * It defines the following resource model:
   * * A collection of `Entitlement` resources. An entitlement allows configuring
   *   (among other things):
   *   * Some kind of privileged access that users can request.
   *   * A set of users called _requesters_ who can request this access.
   *   * A maximum duration for which the access can be requested.
   *   * An optional approval workflow which must be satisfied before access is
   *     granted.
   * * A collection of `Grant` resources. A grant is a request by a requester to
   *   get the privileged access specified in an entitlement for some duration.
   *   After the approval workflow as specified in the entitlement is satisfied,
   *   the specified access is given to the requester. The access is automatically
   *   taken back after the requested duration is over.
   * </pre>
   */
  public static final class PrivilegedAccessManagerStub
      extends io.grpc.stub.AbstractAsyncStub<PrivilegedAccessManagerStub> {
    private PrivilegedAccessManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivilegedAccessManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivilegedAccessManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * CheckOnboardingStatus reports the onboarding status for a
     * project/folder/organization. Any findings reported by this API need to be
     * fixed before PAM can be used on the resource.
     * </pre>
     */
    public void checkOnboardingStatus(
        com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckOnboardingStatusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists entitlements in a given project/folder/organization and location.
     * </pre>
     */
    public void listEntitlements(
        com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntitlementsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `SearchEntitlements` returns entitlements on which the caller has the
     * specified access.
     * </pre>
     */
    public void searchEntitlements(
        com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchEntitlementsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single entitlement.
     * </pre>
     */
    public void getEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Entitlement>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new entitlement in a given project/folder/organization and
     * location.
     * </pre>
     */
    public void createEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single entitlement. This method can only be called when there
     * are no in-progress (ACTIVE/ACTIVATING/REVOKING) grants under the
     * entitlement.
     * </pre>
     */
    public void deleteEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the entitlement specified in the request. Updated fields in the
     * entitlement need to be specified in an update mask. The changes made to an
     * entitlement are applicable only on future grants of the entitlement.
     * However, if new approvers are added or existing approvers are removed from
     * the approval workflow, the changes are effective on existing grants.
     * The following fields are not supported for updates:
     *  * All immutable fields
     *  * Entitlement name
     *  * Resource name
     *  * Resource type
     *  * Adding an approval workflow in an entitlement which previously had no
     *    approval workflow.
     *  * Deleting the approval workflow from an entitlement.
     *  * Adding or deleting a step in the approval workflow (only one step is
     *    supported)
     * Note that updates are allowed on the list of approvers in an approval
     * workflow step.
     * </pre>
     */
    public void updateEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists grants for a given entitlement.
     * </pre>
     */
    public void listGrants(
        com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGrantsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `SearchGrants` returns grants that are related to the calling user in the
     * specified way.
     * </pre>
     */
    public void searchGrants(
        com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchGrantsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single grant.
     * </pre>
     */
    public void getGrant(
        com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGrantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new grant in a given project and location.
     * </pre>
     */
    public void createGrant(
        com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGrantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `ApproveGrant` is used to approve a grant. This method can only be called
     * on a grant when it's in the `APPROVAL_AWAITED` state. This operation can't
     * be undone.
     * </pre>
     */
    public void approveGrant(
        com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApproveGrantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `DenyGrant` is used to deny a grant. This method can only be called on a
     * grant when it's in the `APPROVAL_AWAITED` state. This operation can't be
     * undone.
     * </pre>
     */
    public void denyGrant(
        com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDenyGrantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * `RevokeGrant` is used to immediately revoke access for a grant. This method
     * can be called when the grant is in a non-terminal state.
     * </pre>
     */
    public void revokeGrant(
        com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRevokeGrantMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PrivilegedAccessManager.
   *
   * <pre>
   * This API allows customers to manage temporary, request based privileged
   * access to their resources.
   * It defines the following resource model:
   * * A collection of `Entitlement` resources. An entitlement allows configuring
   *   (among other things):
   *   * Some kind of privileged access that users can request.
   *   * A set of users called _requesters_ who can request this access.
   *   * A maximum duration for which the access can be requested.
   *   * An optional approval workflow which must be satisfied before access is
   *     granted.
   * * A collection of `Grant` resources. A grant is a request by a requester to
   *   get the privileged access specified in an entitlement for some duration.
   *   After the approval workflow as specified in the entitlement is satisfied,
   *   the specified access is given to the requester. The access is automatically
   *   taken back after the requested duration is over.
   * </pre>
   */
  public static final class PrivilegedAccessManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PrivilegedAccessManagerBlockingStub> {
    private PrivilegedAccessManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivilegedAccessManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivilegedAccessManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * CheckOnboardingStatus reports the onboarding status for a
     * project/folder/organization. Any findings reported by this API need to be
     * fixed before PAM can be used on the resource.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse
        checkOnboardingStatus(
            com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckOnboardingStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists entitlements in a given project/folder/organization and location.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse listEntitlements(
        com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntitlementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * `SearchEntitlements` returns entitlements on which the caller has the
     * specified access.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse
        searchEntitlements(
            com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchEntitlementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single entitlement.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.Entitlement getEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new entitlement in a given project/folder/organization and
     * location.
     * </pre>
     */
    public com.google.longrunning.Operation createEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single entitlement. This method can only be called when there
     * are no in-progress (ACTIVE/ACTIVATING/REVOKING) grants under the
     * entitlement.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the entitlement specified in the request. Updated fields in the
     * entitlement need to be specified in an update mask. The changes made to an
     * entitlement are applicable only on future grants of the entitlement.
     * However, if new approvers are added or existing approvers are removed from
     * the approval workflow, the changes are effective on existing grants.
     * The following fields are not supported for updates:
     *  * All immutable fields
     *  * Entitlement name
     *  * Resource name
     *  * Resource type
     *  * Adding an approval workflow in an entitlement which previously had no
     *    approval workflow.
     *  * Deleting the approval workflow from an entitlement.
     *  * Adding or deleting a step in the approval workflow (only one step is
     *    supported)
     * Note that updates are allowed on the list of approvers in an approval
     * workflow step.
     * </pre>
     */
    public com.google.longrunning.Operation updateEntitlement(
        com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists grants for a given entitlement.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse listGrants(
        com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGrantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * `SearchGrants` returns grants that are related to the calling user in the
     * specified way.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse searchGrants(
        com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchGrantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single grant.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.Grant getGrant(
        com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGrantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new grant in a given project and location.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.Grant createGrant(
        com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGrantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * `ApproveGrant` is used to approve a grant. This method can only be called
     * on a grant when it's in the `APPROVAL_AWAITED` state. This operation can't
     * be undone.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.Grant approveGrant(
        com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApproveGrantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * `DenyGrant` is used to deny a grant. This method can only be called on a
     * grant when it's in the `APPROVAL_AWAITED` state. This operation can't be
     * undone.
     * </pre>
     */
    public com.google.cloud.privilegedaccessmanager.v1.Grant denyGrant(
        com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDenyGrantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * `RevokeGrant` is used to immediately revoke access for a grant. This method
     * can be called when the grant is in a non-terminal state.
     * </pre>
     */
    public com.google.longrunning.Operation revokeGrant(
        com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevokeGrantMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * PrivilegedAccessManager.
   *
   * <pre>
   * This API allows customers to manage temporary, request based privileged
   * access to their resources.
   * It defines the following resource model:
   * * A collection of `Entitlement` resources. An entitlement allows configuring
   *   (among other things):
   *   * Some kind of privileged access that users can request.
   *   * A set of users called _requesters_ who can request this access.
   *   * A maximum duration for which the access can be requested.
   *   * An optional approval workflow which must be satisfied before access is
   *     granted.
   * * A collection of `Grant` resources. A grant is a request by a requester to
   *   get the privileged access specified in an entitlement for some duration.
   *   After the approval workflow as specified in the entitlement is satisfied,
   *   the specified access is given to the requester. The access is automatically
   *   taken back after the requested duration is over.
   * </pre>
   */
  public static final class PrivilegedAccessManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<PrivilegedAccessManagerFutureStub> {
    private PrivilegedAccessManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivilegedAccessManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivilegedAccessManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * CheckOnboardingStatus reports the onboarding status for a
     * project/folder/organization. Any findings reported by this API need to be
     * fixed before PAM can be used on the resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>
        checkOnboardingStatus(
            com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckOnboardingStatusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists entitlements in a given project/folder/organization and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>
        listEntitlements(
            com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntitlementsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * `SearchEntitlements` returns entitlements on which the caller has the
     * specified access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>
        searchEntitlements(
            com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchEntitlementsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single entitlement.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.Entitlement>
        getEntitlement(com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new entitlement in a given project/folder/organization and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEntitlement(
            com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single entitlement. This method can only be called when there
     * are no in-progress (ACTIVE/ACTIVATING/REVOKING) grants under the
     * entitlement.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEntitlement(
            com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the entitlement specified in the request. Updated fields in the
     * entitlement need to be specified in an update mask. The changes made to an
     * entitlement are applicable only on future grants of the entitlement.
     * However, if new approvers are added or existing approvers are removed from
     * the approval workflow, the changes are effective on existing grants.
     * The following fields are not supported for updates:
     *  * All immutable fields
     *  * Entitlement name
     *  * Resource name
     *  * Resource type
     *  * Adding an approval workflow in an entitlement which previously had no
     *    approval workflow.
     *  * Deleting the approval workflow from an entitlement.
     *  * Adding or deleting a step in the approval workflow (only one step is
     *    supported)
     * Note that updates are allowed on the list of approvers in an approval
     * workflow step.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEntitlement(
            com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists grants for a given entitlement.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>
        listGrants(com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGrantsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * `SearchGrants` returns grants that are related to the calling user in the
     * specified way.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>
        searchGrants(com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchGrantsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single grant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.Grant>
        getGrant(com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGrantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new grant in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.Grant>
        createGrant(com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGrantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * `ApproveGrant` is used to approve a grant. This method can only be called
     * on a grant when it's in the `APPROVAL_AWAITED` state. This operation can't
     * be undone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.Grant>
        approveGrant(com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApproveGrantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * `DenyGrant` is used to deny a grant. This method can only be called on a
     * grant when it's in the `APPROVAL_AWAITED` state. This operation can't be
     * undone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.privilegedaccessmanager.v1.Grant>
        denyGrant(com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDenyGrantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * `RevokeGrant` is used to immediately revoke access for a grant. This method
     * can be called when the grant is in a non-terminal state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        revokeGrant(com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRevokeGrantMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_ONBOARDING_STATUS = 0;
  private static final int METHODID_LIST_ENTITLEMENTS = 1;
  private static final int METHODID_SEARCH_ENTITLEMENTS = 2;
  private static final int METHODID_GET_ENTITLEMENT = 3;
  private static final int METHODID_CREATE_ENTITLEMENT = 4;
  private static final int METHODID_DELETE_ENTITLEMENT = 5;
  private static final int METHODID_UPDATE_ENTITLEMENT = 6;
  private static final int METHODID_LIST_GRANTS = 7;
  private static final int METHODID_SEARCH_GRANTS = 8;
  private static final int METHODID_GET_GRANT = 9;
  private static final int METHODID_CREATE_GRANT = 10;
  private static final int METHODID_APPROVE_GRANT = 11;
  private static final int METHODID_DENY_GRANT = 12;
  private static final int METHODID_REVOKE_GRANT = 13;

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
        case METHODID_CHECK_ONBOARDING_STATUS:
          serviceImpl.checkOnboardingStatus(
              (com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ENTITLEMENTS:
          serviceImpl.listEntitlements(
              (com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_ENTITLEMENTS:
          serviceImpl.searchEntitlements(
              (com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENTITLEMENT:
          serviceImpl.getEntitlement(
              (com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Entitlement>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENTITLEMENT:
          serviceImpl.createEntitlement(
              (com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENTITLEMENT:
          serviceImpl.deleteEntitlement(
              (com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENTITLEMENT:
          serviceImpl.updateEntitlement(
              (com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GRANTS:
          serviceImpl.listGrants(
              (com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_GRANTS:
          serviceImpl.searchGrants(
              (com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GRANT:
          serviceImpl.getGrant(
              (com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>)
                  responseObserver);
          break;
        case METHODID_CREATE_GRANT:
          serviceImpl.createGrant(
              (com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>)
                  responseObserver);
          break;
        case METHODID_APPROVE_GRANT:
          serviceImpl.approveGrant(
              (com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>)
                  responseObserver);
          break;
        case METHODID_DENY_GRANT:
          serviceImpl.denyGrant(
              (com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.privilegedaccessmanager.v1.Grant>)
                  responseObserver);
          break;
        case METHODID_REVOKE_GRANT:
          serviceImpl.revokeGrant(
              (com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest) request,
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
            getCheckOnboardingStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest,
                    com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse>(
                    service, METHODID_CHECK_ONBOARDING_STATUS)))
        .addMethod(
            getListEntitlementsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest,
                    com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse>(
                    service, METHODID_LIST_ENTITLEMENTS)))
        .addMethod(
            getSearchEntitlementsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest,
                    com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse>(
                    service, METHODID_SEARCH_ENTITLEMENTS)))
        .addMethod(
            getGetEntitlementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest,
                    com.google.cloud.privilegedaccessmanager.v1.Entitlement>(
                    service, METHODID_GET_ENTITLEMENT)))
        .addMethod(
            getCreateEntitlementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENTITLEMENT)))
        .addMethod(
            getDeleteEntitlementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENTITLEMENT)))
        .addMethod(
            getUpdateEntitlementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ENTITLEMENT)))
        .addMethod(
            getListGrantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest,
                    com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse>(
                    service, METHODID_LIST_GRANTS)))
        .addMethod(
            getSearchGrantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest,
                    com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse>(
                    service, METHODID_SEARCH_GRANTS)))
        .addMethod(
            getGetGrantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest,
                    com.google.cloud.privilegedaccessmanager.v1.Grant>(
                    service, METHODID_GET_GRANT)))
        .addMethod(
            getCreateGrantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest,
                    com.google.cloud.privilegedaccessmanager.v1.Grant>(
                    service, METHODID_CREATE_GRANT)))
        .addMethod(
            getApproveGrantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest,
                    com.google.cloud.privilegedaccessmanager.v1.Grant>(
                    service, METHODID_APPROVE_GRANT)))
        .addMethod(
            getDenyGrantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest,
                    com.google.cloud.privilegedaccessmanager.v1.Grant>(
                    service, METHODID_DENY_GRANT)))
        .addMethod(
            getRevokeGrantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest,
                    com.google.longrunning.Operation>(service, METHODID_REVOKE_GRANT)))
        .build();
  }

  private abstract static class PrivilegedAccessManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrivilegedAccessManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrivilegedAccessManager");
    }
  }

  private static final class PrivilegedAccessManagerFileDescriptorSupplier
      extends PrivilegedAccessManagerBaseDescriptorSupplier {
    PrivilegedAccessManagerFileDescriptorSupplier() {}
  }

  private static final class PrivilegedAccessManagerMethodDescriptorSupplier
      extends PrivilegedAccessManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PrivilegedAccessManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PrivilegedAccessManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PrivilegedAccessManagerFileDescriptorSupplier())
                      .addMethod(getCheckOnboardingStatusMethod())
                      .addMethod(getListEntitlementsMethod())
                      .addMethod(getSearchEntitlementsMethod())
                      .addMethod(getGetEntitlementMethod())
                      .addMethod(getCreateEntitlementMethod())
                      .addMethod(getDeleteEntitlementMethod())
                      .addMethod(getUpdateEntitlementMethod())
                      .addMethod(getListGrantsMethod())
                      .addMethod(getSearchGrantsMethod())
                      .addMethod(getGetGrantMethod())
                      .addMethod(getCreateGrantMethod())
                      .addMethod(getApproveGrantMethod())
                      .addMethod(getDenyGrantMethod())
                      .addMethod(getRevokeGrantMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
