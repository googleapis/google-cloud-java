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
 * SecurityProfileGroup is a resource that defines an action for specific threat
 * signatures or severity levels.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SecurityProfileGroupServiceGrpc {

  private SecurityProfileGroupServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networksecurity.v1.SecurityProfileGroupService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest,
          com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>
      getListSecurityProfileGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSecurityProfileGroups",
      requestType = com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest,
          com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>
      getListSecurityProfileGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest,
            com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>
        getListSecurityProfileGroupsMethod;
    if ((getListSecurityProfileGroupsMethod =
            SecurityProfileGroupServiceGrpc.getListSecurityProfileGroupsMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getListSecurityProfileGroupsMethod =
                SecurityProfileGroupServiceGrpc.getListSecurityProfileGroupsMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getListSecurityProfileGroupsMethod =
              getListSecurityProfileGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest,
                          com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSecurityProfileGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "ListSecurityProfileGroups"))
                      .build();
        }
      }
    }
    return getListSecurityProfileGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest,
          com.google.cloud.networksecurity.v1.SecurityProfileGroup>
      getGetSecurityProfileGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSecurityProfileGroup",
      requestType = com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest.class,
      responseType = com.google.cloud.networksecurity.v1.SecurityProfileGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest,
          com.google.cloud.networksecurity.v1.SecurityProfileGroup>
      getGetSecurityProfileGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest,
            com.google.cloud.networksecurity.v1.SecurityProfileGroup>
        getGetSecurityProfileGroupMethod;
    if ((getGetSecurityProfileGroupMethod =
            SecurityProfileGroupServiceGrpc.getGetSecurityProfileGroupMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getGetSecurityProfileGroupMethod =
                SecurityProfileGroupServiceGrpc.getGetSecurityProfileGroupMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getGetSecurityProfileGroupMethod =
              getGetSecurityProfileGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest,
                          com.google.cloud.networksecurity.v1.SecurityProfileGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSecurityProfileGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.SecurityProfileGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "GetSecurityProfileGroup"))
                      .build();
        }
      }
    }
    return getGetSecurityProfileGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest,
          com.google.longrunning.Operation>
      getCreateSecurityProfileGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecurityProfileGroup",
      requestType = com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest,
          com.google.longrunning.Operation>
      getCreateSecurityProfileGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest,
            com.google.longrunning.Operation>
        getCreateSecurityProfileGroupMethod;
    if ((getCreateSecurityProfileGroupMethod =
            SecurityProfileGroupServiceGrpc.getCreateSecurityProfileGroupMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getCreateSecurityProfileGroupMethod =
                SecurityProfileGroupServiceGrpc.getCreateSecurityProfileGroupMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getCreateSecurityProfileGroupMethod =
              getCreateSecurityProfileGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSecurityProfileGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "CreateSecurityProfileGroup"))
                      .build();
        }
      }
    }
    return getCreateSecurityProfileGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest,
          com.google.longrunning.Operation>
      getUpdateSecurityProfileGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSecurityProfileGroup",
      requestType = com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest,
          com.google.longrunning.Operation>
      getUpdateSecurityProfileGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest,
            com.google.longrunning.Operation>
        getUpdateSecurityProfileGroupMethod;
    if ((getUpdateSecurityProfileGroupMethod =
            SecurityProfileGroupServiceGrpc.getUpdateSecurityProfileGroupMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getUpdateSecurityProfileGroupMethod =
                SecurityProfileGroupServiceGrpc.getUpdateSecurityProfileGroupMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getUpdateSecurityProfileGroupMethod =
              getUpdateSecurityProfileGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSecurityProfileGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "UpdateSecurityProfileGroup"))
                      .build();
        }
      }
    }
    return getUpdateSecurityProfileGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest,
          com.google.longrunning.Operation>
      getDeleteSecurityProfileGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSecurityProfileGroup",
      requestType = com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest,
          com.google.longrunning.Operation>
      getDeleteSecurityProfileGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest,
            com.google.longrunning.Operation>
        getDeleteSecurityProfileGroupMethod;
    if ((getDeleteSecurityProfileGroupMethod =
            SecurityProfileGroupServiceGrpc.getDeleteSecurityProfileGroupMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getDeleteSecurityProfileGroupMethod =
                SecurityProfileGroupServiceGrpc.getDeleteSecurityProfileGroupMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getDeleteSecurityProfileGroupMethod =
              getDeleteSecurityProfileGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSecurityProfileGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "DeleteSecurityProfileGroup"))
                      .build();
        }
      }
    }
    return getDeleteSecurityProfileGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest,
          com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>
      getListSecurityProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSecurityProfiles",
      requestType = com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest,
          com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>
      getListSecurityProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest,
            com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>
        getListSecurityProfilesMethod;
    if ((getListSecurityProfilesMethod =
            SecurityProfileGroupServiceGrpc.getListSecurityProfilesMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getListSecurityProfilesMethod =
                SecurityProfileGroupServiceGrpc.getListSecurityProfilesMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getListSecurityProfilesMethod =
              getListSecurityProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest,
                          com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSecurityProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "ListSecurityProfiles"))
                      .build();
        }
      }
    }
    return getListSecurityProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetSecurityProfileRequest,
          com.google.cloud.networksecurity.v1.SecurityProfile>
      getGetSecurityProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSecurityProfile",
      requestType = com.google.cloud.networksecurity.v1.GetSecurityProfileRequest.class,
      responseType = com.google.cloud.networksecurity.v1.SecurityProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetSecurityProfileRequest,
          com.google.cloud.networksecurity.v1.SecurityProfile>
      getGetSecurityProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetSecurityProfileRequest,
            com.google.cloud.networksecurity.v1.SecurityProfile>
        getGetSecurityProfileMethod;
    if ((getGetSecurityProfileMethod = SecurityProfileGroupServiceGrpc.getGetSecurityProfileMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getGetSecurityProfileMethod =
                SecurityProfileGroupServiceGrpc.getGetSecurityProfileMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getGetSecurityProfileMethod =
              getGetSecurityProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetSecurityProfileRequest,
                          com.google.cloud.networksecurity.v1.SecurityProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSecurityProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetSecurityProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.SecurityProfile
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "GetSecurityProfile"))
                      .build();
        }
      }
    }
    return getGetSecurityProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest,
          com.google.longrunning.Operation>
      getCreateSecurityProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecurityProfile",
      requestType = com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest,
          com.google.longrunning.Operation>
      getCreateSecurityProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest,
            com.google.longrunning.Operation>
        getCreateSecurityProfileMethod;
    if ((getCreateSecurityProfileMethod =
            SecurityProfileGroupServiceGrpc.getCreateSecurityProfileMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getCreateSecurityProfileMethod =
                SecurityProfileGroupServiceGrpc.getCreateSecurityProfileMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getCreateSecurityProfileMethod =
              getCreateSecurityProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSecurityProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "CreateSecurityProfile"))
                      .build();
        }
      }
    }
    return getCreateSecurityProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest,
          com.google.longrunning.Operation>
      getUpdateSecurityProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSecurityProfile",
      requestType = com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest,
          com.google.longrunning.Operation>
      getUpdateSecurityProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest,
            com.google.longrunning.Operation>
        getUpdateSecurityProfileMethod;
    if ((getUpdateSecurityProfileMethod =
            SecurityProfileGroupServiceGrpc.getUpdateSecurityProfileMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getUpdateSecurityProfileMethod =
                SecurityProfileGroupServiceGrpc.getUpdateSecurityProfileMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getUpdateSecurityProfileMethod =
              getUpdateSecurityProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSecurityProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "UpdateSecurityProfile"))
                      .build();
        }
      }
    }
    return getUpdateSecurityProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest,
          com.google.longrunning.Operation>
      getDeleteSecurityProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSecurityProfile",
      requestType = com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest,
          com.google.longrunning.Operation>
      getDeleteSecurityProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest,
            com.google.longrunning.Operation>
        getDeleteSecurityProfileMethod;
    if ((getDeleteSecurityProfileMethod =
            SecurityProfileGroupServiceGrpc.getDeleteSecurityProfileMethod)
        == null) {
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        if ((getDeleteSecurityProfileMethod =
                SecurityProfileGroupServiceGrpc.getDeleteSecurityProfileMethod)
            == null) {
          SecurityProfileGroupServiceGrpc.getDeleteSecurityProfileMethod =
              getDeleteSecurityProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSecurityProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityProfileGroupServiceMethodDescriptorSupplier(
                              "DeleteSecurityProfile"))
                      .build();
        }
      }
    }
    return getDeleteSecurityProfileMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecurityProfileGroupServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityProfileGroupServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityProfileGroupServiceStub>() {
          @java.lang.Override
          public SecurityProfileGroupServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityProfileGroupServiceStub(channel, callOptions);
          }
        };
    return SecurityProfileGroupServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SecurityProfileGroupServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityProfileGroupServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityProfileGroupServiceBlockingV2Stub>() {
          @java.lang.Override
          public SecurityProfileGroupServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityProfileGroupServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SecurityProfileGroupServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityProfileGroupServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityProfileGroupServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityProfileGroupServiceBlockingStub>() {
          @java.lang.Override
          public SecurityProfileGroupServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityProfileGroupServiceBlockingStub(channel, callOptions);
          }
        };
    return SecurityProfileGroupServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecurityProfileGroupServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityProfileGroupServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecurityProfileGroupServiceFutureStub>() {
          @java.lang.Override
          public SecurityProfileGroupServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecurityProfileGroupServiceFutureStub(channel, callOptions);
          }
        };
    return SecurityProfileGroupServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * SecurityProfileGroup is a resource that defines an action for specific threat
   * signatures or severity levels.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists SecurityProfileGroups in a given project and location.
     * </pre>
     */
    default void listSecurityProfileGroups(
        com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSecurityProfileGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfileGroup.
     * </pre>
     */
    default void getSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SecurityProfileGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSecurityProfileGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfileGroup in a given project and location.
     * </pre>
     */
    default void createSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSecurityProfileGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfileGroup.
     * </pre>
     */
    default void updateSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSecurityProfileGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfileGroup.
     * </pre>
     */
    default void deleteSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSecurityProfileGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfiles in a given project and location.
     * </pre>
     */
    default void listSecurityProfiles(
        com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSecurityProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfile.
     * </pre>
     */
    default void getSecurityProfile(
        com.google.cloud.networksecurity.v1.GetSecurityProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SecurityProfile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSecurityProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfile in a given project and location.
     * </pre>
     */
    default void createSecurityProfile(
        com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSecurityProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfile.
     * </pre>
     */
    default void updateSecurityProfile(
        com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSecurityProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfile.
     * </pre>
     */
    default void deleteSecurityProfile(
        com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSecurityProfileMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecurityProfileGroupService.
   *
   * <pre>
   * SecurityProfileGroup is a resource that defines an action for specific threat
   * signatures or severity levels.
   * </pre>
   */
  public abstract static class SecurityProfileGroupServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SecurityProfileGroupServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecurityProfileGroupService.
   *
   * <pre>
   * SecurityProfileGroup is a resource that defines an action for specific threat
   * signatures or severity levels.
   * </pre>
   */
  public static final class SecurityProfileGroupServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SecurityProfileGroupServiceStub> {
    private SecurityProfileGroupServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityProfileGroupServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityProfileGroupServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfileGroups in a given project and location.
     * </pre>
     */
    public void listSecurityProfileGroups(
        com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSecurityProfileGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfileGroup.
     * </pre>
     */
    public void getSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SecurityProfileGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSecurityProfileGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfileGroup in a given project and location.
     * </pre>
     */
    public void createSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSecurityProfileGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfileGroup.
     * </pre>
     */
    public void updateSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSecurityProfileGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfileGroup.
     * </pre>
     */
    public void deleteSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSecurityProfileGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfiles in a given project and location.
     * </pre>
     */
    public void listSecurityProfiles(
        com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSecurityProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfile.
     * </pre>
     */
    public void getSecurityProfile(
        com.google.cloud.networksecurity.v1.GetSecurityProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SecurityProfile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSecurityProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfile in a given project and location.
     * </pre>
     */
    public void createSecurityProfile(
        com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSecurityProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfile.
     * </pre>
     */
    public void updateSecurityProfile(
        com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSecurityProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfile.
     * </pre>
     */
    public void deleteSecurityProfile(
        com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSecurityProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecurityProfileGroupService.
   *
   * <pre>
   * SecurityProfileGroup is a resource that defines an action for specific threat
   * signatures or severity levels.
   * </pre>
   */
  public static final class SecurityProfileGroupServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SecurityProfileGroupServiceBlockingV2Stub> {
    private SecurityProfileGroupServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityProfileGroupServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityProfileGroupServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfileGroups in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse
        listSecurityProfileGroups(
            com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSecurityProfileGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.SecurityProfileGroup getSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSecurityProfileGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfileGroup in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSecurityProfileGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.longrunning.Operation updateSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSecurityProfileGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSecurityProfileGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfiles in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse listSecurityProfiles(
        com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSecurityProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfile.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.SecurityProfile getSecurityProfile(
        com.google.cloud.networksecurity.v1.GetSecurityProfileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSecurityProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfile in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSecurityProfile(
        com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSecurityProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfile.
     * </pre>
     */
    public com.google.longrunning.Operation updateSecurityProfile(
        com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSecurityProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfile.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSecurityProfile(
        com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSecurityProfileMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * SecurityProfileGroupService.
   *
   * <pre>
   * SecurityProfileGroup is a resource that defines an action for specific threat
   * signatures or severity levels.
   * </pre>
   */
  public static final class SecurityProfileGroupServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecurityProfileGroupServiceBlockingStub> {
    private SecurityProfileGroupServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityProfileGroupServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityProfileGroupServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfileGroups in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse
        listSecurityProfileGroups(
            com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSecurityProfileGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.SecurityProfileGroup getSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSecurityProfileGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfileGroup in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSecurityProfileGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.longrunning.Operation updateSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSecurityProfileGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSecurityProfileGroup(
        com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSecurityProfileGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfiles in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse listSecurityProfiles(
        com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSecurityProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfile.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.SecurityProfile getSecurityProfile(
        com.google.cloud.networksecurity.v1.GetSecurityProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSecurityProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfile in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSecurityProfile(
        com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSecurityProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfile.
     * </pre>
     */
    public com.google.longrunning.Operation updateSecurityProfile(
        com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSecurityProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfile.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSecurityProfile(
        com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSecurityProfileMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SecurityProfileGroupService.
   *
   * <pre>
   * SecurityProfileGroup is a resource that defines an action for specific threat
   * signatures or severity levels.
   * </pre>
   */
  public static final class SecurityProfileGroupServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecurityProfileGroupServiceFutureStub> {
    private SecurityProfileGroupServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityProfileGroupServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityProfileGroupServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfileGroups in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>
        listSecurityProfileGroups(
            com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSecurityProfileGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.SecurityProfileGroup>
        getSecurityProfileGroup(
            com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSecurityProfileGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfileGroup in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSecurityProfileGroup(
            com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSecurityProfileGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSecurityProfileGroup(
            com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSecurityProfileGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfileGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSecurityProfileGroup(
            com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSecurityProfileGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SecurityProfiles in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>
        listSecurityProfiles(
            com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSecurityProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SecurityProfile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.SecurityProfile>
        getSecurityProfile(com.google.cloud.networksecurity.v1.GetSecurityProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSecurityProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SecurityProfile in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSecurityProfile(
            com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSecurityProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single SecurityProfile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSecurityProfile(
            com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSecurityProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single SecurityProfile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSecurityProfile(
            com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSecurityProfileMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SECURITY_PROFILE_GROUPS = 0;
  private static final int METHODID_GET_SECURITY_PROFILE_GROUP = 1;
  private static final int METHODID_CREATE_SECURITY_PROFILE_GROUP = 2;
  private static final int METHODID_UPDATE_SECURITY_PROFILE_GROUP = 3;
  private static final int METHODID_DELETE_SECURITY_PROFILE_GROUP = 4;
  private static final int METHODID_LIST_SECURITY_PROFILES = 5;
  private static final int METHODID_GET_SECURITY_PROFILE = 6;
  private static final int METHODID_CREATE_SECURITY_PROFILE = 7;
  private static final int METHODID_UPDATE_SECURITY_PROFILE = 8;
  private static final int METHODID_DELETE_SECURITY_PROFILE = 9;

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
        case METHODID_LIST_SECURITY_PROFILE_GROUPS:
          serviceImpl.listSecurityProfileGroups(
              (com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SECURITY_PROFILE_GROUP:
          serviceImpl.getSecurityProfileGroup(
              (com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.SecurityProfileGroup>)
                  responseObserver);
          break;
        case METHODID_CREATE_SECURITY_PROFILE_GROUP:
          serviceImpl.createSecurityProfileGroup(
              (com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SECURITY_PROFILE_GROUP:
          serviceImpl.updateSecurityProfileGroup(
              (com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SECURITY_PROFILE_GROUP:
          serviceImpl.deleteSecurityProfileGroup(
              (com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SECURITY_PROFILES:
          serviceImpl.listSecurityProfiles(
              (com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SECURITY_PROFILE:
          serviceImpl.getSecurityProfile(
              (com.google.cloud.networksecurity.v1.GetSecurityProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SecurityProfile>)
                  responseObserver);
          break;
        case METHODID_CREATE_SECURITY_PROFILE:
          serviceImpl.createSecurityProfile(
              (com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SECURITY_PROFILE:
          serviceImpl.updateSecurityProfile(
              (com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SECURITY_PROFILE:
          serviceImpl.deleteSecurityProfile(
              (com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest) request,
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
            getListSecurityProfileGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest,
                    com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse>(
                    service, METHODID_LIST_SECURITY_PROFILE_GROUPS)))
        .addMethod(
            getGetSecurityProfileGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest,
                    com.google.cloud.networksecurity.v1.SecurityProfileGroup>(
                    service, METHODID_GET_SECURITY_PROFILE_GROUP)))
        .addMethod(
            getCreateSecurityProfileGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_SECURITY_PROFILE_GROUP)))
        .addMethod(
            getUpdateSecurityProfileGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_SECURITY_PROFILE_GROUP)))
        .addMethod(
            getDeleteSecurityProfileGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_SECURITY_PROFILE_GROUP)))
        .addMethod(
            getListSecurityProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest,
                    com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse>(
                    service, METHODID_LIST_SECURITY_PROFILES)))
        .addMethod(
            getGetSecurityProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetSecurityProfileRequest,
                    com.google.cloud.networksecurity.v1.SecurityProfile>(
                    service, METHODID_GET_SECURITY_PROFILE)))
        .addMethod(
            getCreateSecurityProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SECURITY_PROFILE)))
        .addMethod(
            getUpdateSecurityProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SECURITY_PROFILE)))
        .addMethod(
            getDeleteSecurityProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SECURITY_PROFILE)))
        .build();
  }

  private abstract static class SecurityProfileGroupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityProfileGroupServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1.SecurityProfileGroupServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityProfileGroupService");
    }
  }

  private static final class SecurityProfileGroupServiceFileDescriptorSupplier
      extends SecurityProfileGroupServiceBaseDescriptorSupplier {
    SecurityProfileGroupServiceFileDescriptorSupplier() {}
  }

  private static final class SecurityProfileGroupServiceMethodDescriptorSupplier
      extends SecurityProfileGroupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecurityProfileGroupServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SecurityProfileGroupServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SecurityProfileGroupServiceFileDescriptorSupplier())
                      .addMethod(getListSecurityProfileGroupsMethod())
                      .addMethod(getGetSecurityProfileGroupMethod())
                      .addMethod(getCreateSecurityProfileGroupMethod())
                      .addMethod(getUpdateSecurityProfileGroupMethod())
                      .addMethod(getDeleteSecurityProfileGroupMethod())
                      .addMethod(getListSecurityProfilesMethod())
                      .addMethod(getGetSecurityProfileMethod())
                      .addMethod(getCreateSecurityProfileMethod())
                      .addMethod(getUpdateSecurityProfileMethod())
                      .addMethod(getDeleteSecurityProfileMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
