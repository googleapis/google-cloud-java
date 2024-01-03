/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.orgpolicy.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * An interface for managing organization policies.
 * The Organization Policy Service provides a simple mechanism for
 * organizations to restrict the allowed configurations across their entire
 * resource hierarchy.
 * You can use a policy to configure restrictions on resources. For
 * example, you can enforce a policy that restricts which Google
 * Cloud APIs can be activated in a certain part of your resource
 * hierarchy, or prevents serial port access to VM instances in a
 * particular folder.
 * Policies are inherited down through the resource hierarchy. A policy
 * applied to a parent resource automatically applies to all its child resources
 * unless overridden with a policy lower in the hierarchy.
 * A constraint defines an aspect of a resource's configuration that can be
 * controlled by an organization's policy administrator. Policies are a
 * collection of constraints that defines their allowable configuration on a
 * particular resource and its child resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/orgpolicy/v2/orgpolicy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrgPolicyGrpc {

  private OrgPolicyGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.orgpolicy.v2.OrgPolicy";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.ListConstraintsRequest,
          com.google.cloud.orgpolicy.v2.ListConstraintsResponse>
      getListConstraintsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConstraints",
      requestType = com.google.cloud.orgpolicy.v2.ListConstraintsRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.ListConstraintsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.ListConstraintsRequest,
          com.google.cloud.orgpolicy.v2.ListConstraintsResponse>
      getListConstraintsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.ListConstraintsRequest,
            com.google.cloud.orgpolicy.v2.ListConstraintsResponse>
        getListConstraintsMethod;
    if ((getListConstraintsMethod = OrgPolicyGrpc.getListConstraintsMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getListConstraintsMethod = OrgPolicyGrpc.getListConstraintsMethod) == null) {
          OrgPolicyGrpc.getListConstraintsMethod =
              getListConstraintsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.ListConstraintsRequest,
                          com.google.cloud.orgpolicy.v2.ListConstraintsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConstraints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.ListConstraintsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.ListConstraintsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new OrgPolicyMethodDescriptorSupplier("ListConstraints"))
                      .build();
        }
      }
    }
    return getListConstraintsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.ListPoliciesRequest,
          com.google.cloud.orgpolicy.v2.ListPoliciesResponse>
      getListPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPolicies",
      requestType = com.google.cloud.orgpolicy.v2.ListPoliciesRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.ListPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.ListPoliciesRequest,
          com.google.cloud.orgpolicy.v2.ListPoliciesResponse>
      getListPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.ListPoliciesRequest,
            com.google.cloud.orgpolicy.v2.ListPoliciesResponse>
        getListPoliciesMethod;
    if ((getListPoliciesMethod = OrgPolicyGrpc.getListPoliciesMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getListPoliciesMethod = OrgPolicyGrpc.getListPoliciesMethod) == null) {
          OrgPolicyGrpc.getListPoliciesMethod =
              getListPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.ListPoliciesRequest,
                          com.google.cloud.orgpolicy.v2.ListPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.ListPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.ListPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new OrgPolicyMethodDescriptorSupplier("ListPolicies"))
                      .build();
        }
      }
    }
    return getListPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.GetPolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
      getGetPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPolicy",
      requestType = com.google.cloud.orgpolicy.v2.GetPolicyRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.GetPolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
      getGetPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.GetPolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
        getGetPolicyMethod;
    if ((getGetPolicyMethod = OrgPolicyGrpc.getGetPolicyMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getGetPolicyMethod = OrgPolicyGrpc.getGetPolicyMethod) == null) {
          OrgPolicyGrpc.getGetPolicyMethod =
              getGetPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.GetPolicyRequest,
                          com.google.cloud.orgpolicy.v2.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.GetPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new OrgPolicyMethodDescriptorSupplier("GetPolicy"))
                      .build();
        }
      }
    }
    return getGetPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest,
          com.google.cloud.orgpolicy.v2.Policy>
      getGetEffectivePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEffectivePolicy",
      requestType = com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest,
          com.google.cloud.orgpolicy.v2.Policy>
      getGetEffectivePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest,
            com.google.cloud.orgpolicy.v2.Policy>
        getGetEffectivePolicyMethod;
    if ((getGetEffectivePolicyMethod = OrgPolicyGrpc.getGetEffectivePolicyMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getGetEffectivePolicyMethod = OrgPolicyGrpc.getGetEffectivePolicyMethod) == null) {
          OrgPolicyGrpc.getGetEffectivePolicyMethod =
              getGetEffectivePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest,
                          com.google.cloud.orgpolicy.v2.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEffectivePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyMethodDescriptorSupplier("GetEffectivePolicy"))
                      .build();
        }
      }
    }
    return getGetEffectivePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.CreatePolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
      getCreatePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePolicy",
      requestType = com.google.cloud.orgpolicy.v2.CreatePolicyRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.CreatePolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
      getCreatePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.CreatePolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
        getCreatePolicyMethod;
    if ((getCreatePolicyMethod = OrgPolicyGrpc.getCreatePolicyMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getCreatePolicyMethod = OrgPolicyGrpc.getCreatePolicyMethod) == null) {
          OrgPolicyGrpc.getCreatePolicyMethod =
              getCreatePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.CreatePolicyRequest,
                          com.google.cloud.orgpolicy.v2.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.CreatePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new OrgPolicyMethodDescriptorSupplier("CreatePolicy"))
                      .build();
        }
      }
    }
    return getCreatePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.UpdatePolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
      getUpdatePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePolicy",
      requestType = com.google.cloud.orgpolicy.v2.UpdatePolicyRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.UpdatePolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
      getUpdatePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.UpdatePolicyRequest, com.google.cloud.orgpolicy.v2.Policy>
        getUpdatePolicyMethod;
    if ((getUpdatePolicyMethod = OrgPolicyGrpc.getUpdatePolicyMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getUpdatePolicyMethod = OrgPolicyGrpc.getUpdatePolicyMethod) == null) {
          OrgPolicyGrpc.getUpdatePolicyMethod =
              getUpdatePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.UpdatePolicyRequest,
                          com.google.cloud.orgpolicy.v2.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.UpdatePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new OrgPolicyMethodDescriptorSupplier("UpdatePolicy"))
                      .build();
        }
      }
    }
    return getUpdatePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.DeletePolicyRequest, com.google.protobuf.Empty>
      getDeletePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePolicy",
      requestType = com.google.cloud.orgpolicy.v2.DeletePolicyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.DeletePolicyRequest, com.google.protobuf.Empty>
      getDeletePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.DeletePolicyRequest, com.google.protobuf.Empty>
        getDeletePolicyMethod;
    if ((getDeletePolicyMethod = OrgPolicyGrpc.getDeletePolicyMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getDeletePolicyMethod = OrgPolicyGrpc.getDeletePolicyMethod) == null) {
          OrgPolicyGrpc.getDeletePolicyMethod =
              getDeletePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.DeletePolicyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.DeletePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new OrgPolicyMethodDescriptorSupplier("DeletePolicy"))
                      .build();
        }
      }
    }
    return getDeletePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest,
          com.google.cloud.orgpolicy.v2.CustomConstraint>
      getCreateCustomConstraintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomConstraint",
      requestType = com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.CustomConstraint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest,
          com.google.cloud.orgpolicy.v2.CustomConstraint>
      getCreateCustomConstraintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest,
            com.google.cloud.orgpolicy.v2.CustomConstraint>
        getCreateCustomConstraintMethod;
    if ((getCreateCustomConstraintMethod = OrgPolicyGrpc.getCreateCustomConstraintMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getCreateCustomConstraintMethod = OrgPolicyGrpc.getCreateCustomConstraintMethod)
            == null) {
          OrgPolicyGrpc.getCreateCustomConstraintMethod =
              getCreateCustomConstraintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest,
                          com.google.cloud.orgpolicy.v2.CustomConstraint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCustomConstraint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.CustomConstraint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyMethodDescriptorSupplier("CreateCustomConstraint"))
                      .build();
        }
      }
    }
    return getCreateCustomConstraintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest,
          com.google.cloud.orgpolicy.v2.CustomConstraint>
      getUpdateCustomConstraintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomConstraint",
      requestType = com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.CustomConstraint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest,
          com.google.cloud.orgpolicy.v2.CustomConstraint>
      getUpdateCustomConstraintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest,
            com.google.cloud.orgpolicy.v2.CustomConstraint>
        getUpdateCustomConstraintMethod;
    if ((getUpdateCustomConstraintMethod = OrgPolicyGrpc.getUpdateCustomConstraintMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getUpdateCustomConstraintMethod = OrgPolicyGrpc.getUpdateCustomConstraintMethod)
            == null) {
          OrgPolicyGrpc.getUpdateCustomConstraintMethod =
              getUpdateCustomConstraintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest,
                          com.google.cloud.orgpolicy.v2.CustomConstraint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCustomConstraint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.CustomConstraint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyMethodDescriptorSupplier("UpdateCustomConstraint"))
                      .build();
        }
      }
    }
    return getUpdateCustomConstraintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest,
          com.google.cloud.orgpolicy.v2.CustomConstraint>
      getGetCustomConstraintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomConstraint",
      requestType = com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.CustomConstraint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest,
          com.google.cloud.orgpolicy.v2.CustomConstraint>
      getGetCustomConstraintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest,
            com.google.cloud.orgpolicy.v2.CustomConstraint>
        getGetCustomConstraintMethod;
    if ((getGetCustomConstraintMethod = OrgPolicyGrpc.getGetCustomConstraintMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getGetCustomConstraintMethod = OrgPolicyGrpc.getGetCustomConstraintMethod) == null) {
          OrgPolicyGrpc.getGetCustomConstraintMethod =
              getGetCustomConstraintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest,
                          com.google.cloud.orgpolicy.v2.CustomConstraint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCustomConstraint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.CustomConstraint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyMethodDescriptorSupplier("GetCustomConstraint"))
                      .build();
        }
      }
    }
    return getGetCustomConstraintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest,
          com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>
      getListCustomConstraintsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomConstraints",
      requestType = com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest.class,
      responseType = com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest,
          com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>
      getListCustomConstraintsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest,
            com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>
        getListCustomConstraintsMethod;
    if ((getListCustomConstraintsMethod = OrgPolicyGrpc.getListCustomConstraintsMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getListCustomConstraintsMethod = OrgPolicyGrpc.getListCustomConstraintsMethod)
            == null) {
          OrgPolicyGrpc.getListCustomConstraintsMethod =
              getListCustomConstraintsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest,
                          com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCustomConstraints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyMethodDescriptorSupplier("ListCustomConstraints"))
                      .build();
        }
      }
    }
    return getListCustomConstraintsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest, com.google.protobuf.Empty>
      getDeleteCustomConstraintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomConstraint",
      requestType = com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest, com.google.protobuf.Empty>
      getDeleteCustomConstraintMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest, com.google.protobuf.Empty>
        getDeleteCustomConstraintMethod;
    if ((getDeleteCustomConstraintMethod = OrgPolicyGrpc.getDeleteCustomConstraintMethod) == null) {
      synchronized (OrgPolicyGrpc.class) {
        if ((getDeleteCustomConstraintMethod = OrgPolicyGrpc.getDeleteCustomConstraintMethod)
            == null) {
          OrgPolicyGrpc.getDeleteCustomConstraintMethod =
              getDeleteCustomConstraintMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCustomConstraint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyMethodDescriptorSupplier("DeleteCustomConstraint"))
                      .build();
        }
      }
    }
    return getDeleteCustomConstraintMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OrgPolicyStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrgPolicyStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrgPolicyStub>() {
          @java.lang.Override
          public OrgPolicyStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrgPolicyStub(channel, callOptions);
          }
        };
    return OrgPolicyStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrgPolicyBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrgPolicyBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrgPolicyBlockingStub>() {
          @java.lang.Override
          public OrgPolicyBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrgPolicyBlockingStub(channel, callOptions);
          }
        };
    return OrgPolicyBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OrgPolicyFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrgPolicyFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrgPolicyFutureStub>() {
          @java.lang.Override
          public OrgPolicyFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrgPolicyFutureStub(channel, callOptions);
          }
        };
    return OrgPolicyFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * An interface for managing organization policies.
   * The Organization Policy Service provides a simple mechanism for
   * organizations to restrict the allowed configurations across their entire
   * resource hierarchy.
   * You can use a policy to configure restrictions on resources. For
   * example, you can enforce a policy that restricts which Google
   * Cloud APIs can be activated in a certain part of your resource
   * hierarchy, or prevents serial port access to VM instances in a
   * particular folder.
   * Policies are inherited down through the resource hierarchy. A policy
   * applied to a parent resource automatically applies to all its child resources
   * unless overridden with a policy lower in the hierarchy.
   * A constraint defines an aspect of a resource's configuration that can be
   * controlled by an organization's policy administrator. Policies are a
   * collection of constraints that defines their allowable configuration on a
   * particular resource and its child resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists constraints that could be applied on the specified resource.
     * </pre>
     */
    default void listConstraints(
        com.google.cloud.orgpolicy.v2.ListConstraintsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.ListConstraintsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConstraintsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all of the policies that exist on a particular resource.
     * </pre>
     */
    default void listPolicies(
        com.google.cloud.orgpolicy.v2.ListPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.ListPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy on a resource.
     * If no policy is set on the resource, `NOT_FOUND` is returned. The
     * `etag` value can be used with `UpdatePolicy()` to update a
     * policy during read-modify-write.
     * </pre>
     */
    default void getPolicy(
        com.google.cloud.orgpolicy.v2.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the effective policy on a resource. This is the result of merging
     * policies in the resource hierarchy and evaluating conditions. The
     * returned policy will not have an `etag` or `condition` set because it is
     * an evaluated policy across multiple resources.
     * Subtrees of Resource Manager resource hierarchy with 'under:' prefix will
     * not be expanded.
     * </pre>
     */
    default void getEffectivePolicy(
        com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEffectivePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the
     * policy already exists on the given Google Cloud resource.
     * </pre>
     */
    default void createPolicy(
        com.google.cloud.orgpolicy.v2.CreatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint or the policy do not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the policy
     * Note: the supplied policy will perform a full overwrite of all
     * fields.
     * </pre>
     */
    default void updatePolicy(
        com.google.cloud.orgpolicy.v2.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint or organization policy does not exist.
     * </pre>
     */
    default void deletePolicy(
        com.google.cloud.orgpolicy.v2.DeletePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * organization does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the
     * constraint already exists on the given organization.
     * </pre>
     */
    default void createCustomConstraint(
        com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCustomConstraintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * Note: the supplied policy will perform a full overwrite of all
     * fields.
     * </pre>
     */
    default void updateCustomConstraint(
        com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCustomConstraintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * custom constraint does not exist.
     * </pre>
     */
    default void getCustomConstraint(
        com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCustomConstraintMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all of the custom constraints that exist on a particular
     * organization resource.
     * </pre>
     */
    default void listCustomConstraints(
        com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCustomConstraintsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * </pre>
     */
    default void deleteCustomConstraint(
        com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCustomConstraintMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrgPolicy.
   *
   * <pre>
   * An interface for managing organization policies.
   * The Organization Policy Service provides a simple mechanism for
   * organizations to restrict the allowed configurations across their entire
   * resource hierarchy.
   * You can use a policy to configure restrictions on resources. For
   * example, you can enforce a policy that restricts which Google
   * Cloud APIs can be activated in a certain part of your resource
   * hierarchy, or prevents serial port access to VM instances in a
   * particular folder.
   * Policies are inherited down through the resource hierarchy. A policy
   * applied to a parent resource automatically applies to all its child resources
   * unless overridden with a policy lower in the hierarchy.
   * A constraint defines an aspect of a resource's configuration that can be
   * controlled by an organization's policy administrator. Policies are a
   * collection of constraints that defines their allowable configuration on a
   * particular resource and its child resources.
   * </pre>
   */
  public abstract static class OrgPolicyImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OrgPolicyGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrgPolicy.
   *
   * <pre>
   * An interface for managing organization policies.
   * The Organization Policy Service provides a simple mechanism for
   * organizations to restrict the allowed configurations across their entire
   * resource hierarchy.
   * You can use a policy to configure restrictions on resources. For
   * example, you can enforce a policy that restricts which Google
   * Cloud APIs can be activated in a certain part of your resource
   * hierarchy, or prevents serial port access to VM instances in a
   * particular folder.
   * Policies are inherited down through the resource hierarchy. A policy
   * applied to a parent resource automatically applies to all its child resources
   * unless overridden with a policy lower in the hierarchy.
   * A constraint defines an aspect of a resource's configuration that can be
   * controlled by an organization's policy administrator. Policies are a
   * collection of constraints that defines their allowable configuration on a
   * particular resource and its child resources.
   * </pre>
   */
  public static final class OrgPolicyStub extends io.grpc.stub.AbstractAsyncStub<OrgPolicyStub> {
    private OrgPolicyStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrgPolicyStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrgPolicyStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists constraints that could be applied on the specified resource.
     * </pre>
     */
    public void listConstraints(
        com.google.cloud.orgpolicy.v2.ListConstraintsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.ListConstraintsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConstraintsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all of the policies that exist on a particular resource.
     * </pre>
     */
    public void listPolicies(
        com.google.cloud.orgpolicy.v2.ListPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.ListPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy on a resource.
     * If no policy is set on the resource, `NOT_FOUND` is returned. The
     * `etag` value can be used with `UpdatePolicy()` to update a
     * policy during read-modify-write.
     * </pre>
     */
    public void getPolicy(
        com.google.cloud.orgpolicy.v2.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the effective policy on a resource. This is the result of merging
     * policies in the resource hierarchy and evaluating conditions. The
     * returned policy will not have an `etag` or `condition` set because it is
     * an evaluated policy across multiple resources.
     * Subtrees of Resource Manager resource hierarchy with 'under:' prefix will
     * not be expanded.
     * </pre>
     */
    public void getEffectivePolicy(
        com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEffectivePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the
     * policy already exists on the given Google Cloud resource.
     * </pre>
     */
    public void createPolicy(
        com.google.cloud.orgpolicy.v2.CreatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint or the policy do not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the policy
     * Note: the supplied policy will perform a full overwrite of all
     * fields.
     * </pre>
     */
    public void updatePolicy(
        com.google.cloud.orgpolicy.v2.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint or organization policy does not exist.
     * </pre>
     */
    public void deletePolicy(
        com.google.cloud.orgpolicy.v2.DeletePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * organization does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the
     * constraint already exists on the given organization.
     * </pre>
     */
    public void createCustomConstraint(
        com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomConstraintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * Note: the supplied policy will perform a full overwrite of all
     * fields.
     * </pre>
     */
    public void updateCustomConstraint(
        com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCustomConstraintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * custom constraint does not exist.
     * </pre>
     */
    public void getCustomConstraint(
        com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomConstraintMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all of the custom constraints that exist on a particular
     * organization resource.
     * </pre>
     */
    public void listCustomConstraints(
        com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomConstraintsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * </pre>
     */
    public void deleteCustomConstraint(
        com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCustomConstraintMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrgPolicy.
   *
   * <pre>
   * An interface for managing organization policies.
   * The Organization Policy Service provides a simple mechanism for
   * organizations to restrict the allowed configurations across their entire
   * resource hierarchy.
   * You can use a policy to configure restrictions on resources. For
   * example, you can enforce a policy that restricts which Google
   * Cloud APIs can be activated in a certain part of your resource
   * hierarchy, or prevents serial port access to VM instances in a
   * particular folder.
   * Policies are inherited down through the resource hierarchy. A policy
   * applied to a parent resource automatically applies to all its child resources
   * unless overridden with a policy lower in the hierarchy.
   * A constraint defines an aspect of a resource's configuration that can be
   * controlled by an organization's policy administrator. Policies are a
   * collection of constraints that defines their allowable configuration on a
   * particular resource and its child resources.
   * </pre>
   */
  public static final class OrgPolicyBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrgPolicyBlockingStub> {
    private OrgPolicyBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrgPolicyBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrgPolicyBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists constraints that could be applied on the specified resource.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.ListConstraintsResponse listConstraints(
        com.google.cloud.orgpolicy.v2.ListConstraintsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConstraintsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all of the policies that exist on a particular resource.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.ListPoliciesResponse listPolicies(
        com.google.cloud.orgpolicy.v2.ListPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy on a resource.
     * If no policy is set on the resource, `NOT_FOUND` is returned. The
     * `etag` value can be used with `UpdatePolicy()` to update a
     * policy during read-modify-write.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.Policy getPolicy(
        com.google.cloud.orgpolicy.v2.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the effective policy on a resource. This is the result of merging
     * policies in the resource hierarchy and evaluating conditions. The
     * returned policy will not have an `etag` or `condition` set because it is
     * an evaluated policy across multiple resources.
     * Subtrees of Resource Manager resource hierarchy with 'under:' prefix will
     * not be expanded.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.Policy getEffectivePolicy(
        com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEffectivePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the
     * policy already exists on the given Google Cloud resource.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.Policy createPolicy(
        com.google.cloud.orgpolicy.v2.CreatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint or the policy do not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the policy
     * Note: the supplied policy will perform a full overwrite of all
     * fields.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.Policy updatePolicy(
        com.google.cloud.orgpolicy.v2.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint or organization policy does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deletePolicy(
        com.google.cloud.orgpolicy.v2.DeletePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * organization does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the
     * constraint already exists on the given organization.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.CustomConstraint createCustomConstraint(
        com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomConstraintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * Note: the supplied policy will perform a full overwrite of all
     * fields.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.CustomConstraint updateCustomConstraint(
        com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCustomConstraintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * custom constraint does not exist.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.CustomConstraint getCustomConstraint(
        com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomConstraintMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all of the custom constraints that exist on a particular
     * organization resource.
     * </pre>
     */
    public com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse listCustomConstraints(
        com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomConstraintsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCustomConstraint(
        com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCustomConstraintMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OrgPolicy.
   *
   * <pre>
   * An interface for managing organization policies.
   * The Organization Policy Service provides a simple mechanism for
   * organizations to restrict the allowed configurations across their entire
   * resource hierarchy.
   * You can use a policy to configure restrictions on resources. For
   * example, you can enforce a policy that restricts which Google
   * Cloud APIs can be activated in a certain part of your resource
   * hierarchy, or prevents serial port access to VM instances in a
   * particular folder.
   * Policies are inherited down through the resource hierarchy. A policy
   * applied to a parent resource automatically applies to all its child resources
   * unless overridden with a policy lower in the hierarchy.
   * A constraint defines an aspect of a resource's configuration that can be
   * controlled by an organization's policy administrator. Policies are a
   * collection of constraints that defines their allowable configuration on a
   * particular resource and its child resources.
   * </pre>
   */
  public static final class OrgPolicyFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrgPolicyFutureStub> {
    private OrgPolicyFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrgPolicyFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrgPolicyFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists constraints that could be applied on the specified resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orgpolicy.v2.ListConstraintsResponse>
        listConstraints(com.google.cloud.orgpolicy.v2.ListConstraintsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConstraintsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all of the policies that exist on a particular resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orgpolicy.v2.ListPoliciesResponse>
        listPolicies(com.google.cloud.orgpolicy.v2.ListPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy on a resource.
     * If no policy is set on the resource, `NOT_FOUND` is returned. The
     * `etag` value can be used with `UpdatePolicy()` to update a
     * policy during read-modify-write.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orgpolicy.v2.Policy>
        getPolicy(com.google.cloud.orgpolicy.v2.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the effective policy on a resource. This is the result of merging
     * policies in the resource hierarchy and evaluating conditions. The
     * returned policy will not have an `etag` or `condition` set because it is
     * an evaluated policy across multiple resources.
     * Subtrees of Resource Manager resource hierarchy with 'under:' prefix will
     * not be expanded.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orgpolicy.v2.Policy>
        getEffectivePolicy(com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEffectivePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the
     * policy already exists on the given Google Cloud resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orgpolicy.v2.Policy>
        createPolicy(com.google.cloud.orgpolicy.v2.CreatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint or the policy do not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the policy
     * Note: the supplied policy will perform a full overwrite of all
     * fields.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.orgpolicy.v2.Policy>
        updatePolicy(com.google.cloud.orgpolicy.v2.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint or organization policy does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePolicy(com.google.cloud.orgpolicy.v2.DeletePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * organization does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the
     * constraint already exists on the given organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orgpolicy.v2.CustomConstraint>
        createCustomConstraint(
            com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomConstraintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * Note: the supplied policy will perform a full overwrite of all
     * fields.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orgpolicy.v2.CustomConstraint>
        updateCustomConstraint(
            com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCustomConstraintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * custom constraint does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orgpolicy.v2.CustomConstraint>
        getCustomConstraint(com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomConstraintMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all of the custom constraints that exist on a particular
     * organization resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>
        listCustomConstraints(com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomConstraintsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a custom constraint.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * constraint does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCustomConstraint(
            com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCustomConstraintMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONSTRAINTS = 0;
  private static final int METHODID_LIST_POLICIES = 1;
  private static final int METHODID_GET_POLICY = 2;
  private static final int METHODID_GET_EFFECTIVE_POLICY = 3;
  private static final int METHODID_CREATE_POLICY = 4;
  private static final int METHODID_UPDATE_POLICY = 5;
  private static final int METHODID_DELETE_POLICY = 6;
  private static final int METHODID_CREATE_CUSTOM_CONSTRAINT = 7;
  private static final int METHODID_UPDATE_CUSTOM_CONSTRAINT = 8;
  private static final int METHODID_GET_CUSTOM_CONSTRAINT = 9;
  private static final int METHODID_LIST_CUSTOM_CONSTRAINTS = 10;
  private static final int METHODID_DELETE_CUSTOM_CONSTRAINT = 11;

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
        case METHODID_LIST_CONSTRAINTS:
          serviceImpl.listConstraints(
              (com.google.cloud.orgpolicy.v2.ListConstraintsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.ListConstraintsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_POLICIES:
          serviceImpl.listPolicies(
              (com.google.cloud.orgpolicy.v2.ListPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.ListPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_POLICY:
          serviceImpl.getPolicy(
              (com.google.cloud.orgpolicy.v2.GetPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy>) responseObserver);
          break;
        case METHODID_GET_EFFECTIVE_POLICY:
          serviceImpl.getEffectivePolicy(
              (com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy>) responseObserver);
          break;
        case METHODID_CREATE_POLICY:
          serviceImpl.createPolicy(
              (com.google.cloud.orgpolicy.v2.CreatePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy>) responseObserver);
          break;
        case METHODID_UPDATE_POLICY:
          serviceImpl.updatePolicy(
              (com.google.cloud.orgpolicy.v2.UpdatePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.Policy>) responseObserver);
          break;
        case METHODID_DELETE_POLICY:
          serviceImpl.deletePolicy(
              (com.google.cloud.orgpolicy.v2.DeletePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_CUSTOM_CONSTRAINT:
          serviceImpl.createCustomConstraint(
              (com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CUSTOM_CONSTRAINT:
          serviceImpl.updateCustomConstraint(
              (com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>)
                  responseObserver);
          break;
        case METHODID_GET_CUSTOM_CONSTRAINT:
          serviceImpl.getCustomConstraint(
              (com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.orgpolicy.v2.CustomConstraint>)
                  responseObserver);
          break;
        case METHODID_LIST_CUSTOM_CONSTRAINTS:
          serviceImpl.listCustomConstraints(
              (com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CUSTOM_CONSTRAINT:
          serviceImpl.deleteCustomConstraint(
              (com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest) request,
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
            getListConstraintsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.ListConstraintsRequest,
                    com.google.cloud.orgpolicy.v2.ListConstraintsResponse>(
                    service, METHODID_LIST_CONSTRAINTS)))
        .addMethod(
            getListPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.ListPoliciesRequest,
                    com.google.cloud.orgpolicy.v2.ListPoliciesResponse>(
                    service, METHODID_LIST_POLICIES)))
        .addMethod(
            getGetPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.GetPolicyRequest,
                    com.google.cloud.orgpolicy.v2.Policy>(service, METHODID_GET_POLICY)))
        .addMethod(
            getGetEffectivePolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest,
                    com.google.cloud.orgpolicy.v2.Policy>(service, METHODID_GET_EFFECTIVE_POLICY)))
        .addMethod(
            getCreatePolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.CreatePolicyRequest,
                    com.google.cloud.orgpolicy.v2.Policy>(service, METHODID_CREATE_POLICY)))
        .addMethod(
            getUpdatePolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.UpdatePolicyRequest,
                    com.google.cloud.orgpolicy.v2.Policy>(service, METHODID_UPDATE_POLICY)))
        .addMethod(
            getDeletePolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.DeletePolicyRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_POLICY)))
        .addMethod(
            getCreateCustomConstraintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.CreateCustomConstraintRequest,
                    com.google.cloud.orgpolicy.v2.CustomConstraint>(
                    service, METHODID_CREATE_CUSTOM_CONSTRAINT)))
        .addMethod(
            getUpdateCustomConstraintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.UpdateCustomConstraintRequest,
                    com.google.cloud.orgpolicy.v2.CustomConstraint>(
                    service, METHODID_UPDATE_CUSTOM_CONSTRAINT)))
        .addMethod(
            getGetCustomConstraintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.GetCustomConstraintRequest,
                    com.google.cloud.orgpolicy.v2.CustomConstraint>(
                    service, METHODID_GET_CUSTOM_CONSTRAINT)))
        .addMethod(
            getListCustomConstraintsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.ListCustomConstraintsRequest,
                    com.google.cloud.orgpolicy.v2.ListCustomConstraintsResponse>(
                    service, METHODID_LIST_CUSTOM_CONSTRAINTS)))
        .addMethod(
            getDeleteCustomConstraintMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.orgpolicy.v2.DeleteCustomConstraintRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CUSTOM_CONSTRAINT)))
        .build();
  }

  private abstract static class OrgPolicyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrgPolicyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.orgpolicy.v2.OrgPolicyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrgPolicy");
    }
  }

  private static final class OrgPolicyFileDescriptorSupplier
      extends OrgPolicyBaseDescriptorSupplier {
    OrgPolicyFileDescriptorSupplier() {}
  }

  private static final class OrgPolicyMethodDescriptorSupplier
      extends OrgPolicyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrgPolicyMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrgPolicyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OrgPolicyFileDescriptorSupplier())
                      .addMethod(getListConstraintsMethod())
                      .addMethod(getListPoliciesMethod())
                      .addMethod(getGetPolicyMethod())
                      .addMethod(getGetEffectivePolicyMethod())
                      .addMethod(getCreatePolicyMethod())
                      .addMethod(getUpdatePolicyMethod())
                      .addMethod(getDeletePolicyMethod())
                      .addMethod(getCreateCustomConstraintMethod())
                      .addMethod(getUpdateCustomConstraintMethod())
                      .addMethod(getGetCustomConstraintMethod())
                      .addMethod(getListCustomConstraintsMethod())
                      .addMethod(getDeleteCustomConstraintMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
