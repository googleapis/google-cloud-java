package com.google.identity.accesscontextmanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * API for setting [access levels]
 * [google.identity.accesscontextmanager.v1.AccessLevel] and [service
 * perimeters] [google.identity.accesscontextmanager.v1.ServicePerimeter]
 * for Google Cloud projects. Each organization has one [access policy]
 * [google.identity.accesscontextmanager.v1.AccessPolicy] that contains the
 * [access levels] [google.identity.accesscontextmanager.v1.AccessLevel]
 * and [service perimeters]
 * [google.identity.accesscontextmanager.v1.ServicePerimeter]. This
 * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy] is
 * applicable to all resources in the organization.
 * AccessPolicies
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/identity/accesscontextmanager/v1/access_context_manager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccessContextManagerGrpc {

  private AccessContextManagerGrpc() {}

  public static final String SERVICE_NAME = "google.identity.accesscontextmanager.v1.AccessContextManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest,
      com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse> getListAccessPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccessPolicies",
      requestType = com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest.class,
      responseType = com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest,
      com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse> getListAccessPoliciesMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest, com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse> getListAccessPoliciesMethod;
    if ((getListAccessPoliciesMethod = AccessContextManagerGrpc.getListAccessPoliciesMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getListAccessPoliciesMethod = AccessContextManagerGrpc.getListAccessPoliciesMethod) == null) {
          AccessContextManagerGrpc.getListAccessPoliciesMethod = getListAccessPoliciesMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest, com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccessPolicies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("ListAccessPolicies"))
              .build();
        }
      }
    }
    return getListAccessPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest,
      com.google.identity.accesscontextmanager.v1.AccessPolicy> getGetAccessPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccessPolicy",
      requestType = com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest.class,
      responseType = com.google.identity.accesscontextmanager.v1.AccessPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest,
      com.google.identity.accesscontextmanager.v1.AccessPolicy> getGetAccessPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest, com.google.identity.accesscontextmanager.v1.AccessPolicy> getGetAccessPolicyMethod;
    if ((getGetAccessPolicyMethod = AccessContextManagerGrpc.getGetAccessPolicyMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getGetAccessPolicyMethod = AccessContextManagerGrpc.getGetAccessPolicyMethod) == null) {
          AccessContextManagerGrpc.getGetAccessPolicyMethod = getGetAccessPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest, com.google.identity.accesscontextmanager.v1.AccessPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccessPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.AccessPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("GetAccessPolicy"))
              .build();
        }
      }
    }
    return getGetAccessPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.AccessPolicy,
      com.google.longrunning.Operation> getCreateAccessPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccessPolicy",
      requestType = com.google.identity.accesscontextmanager.v1.AccessPolicy.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.AccessPolicy,
      com.google.longrunning.Operation> getCreateAccessPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.AccessPolicy, com.google.longrunning.Operation> getCreateAccessPolicyMethod;
    if ((getCreateAccessPolicyMethod = AccessContextManagerGrpc.getCreateAccessPolicyMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getCreateAccessPolicyMethod = AccessContextManagerGrpc.getCreateAccessPolicyMethod) == null) {
          AccessContextManagerGrpc.getCreateAccessPolicyMethod = getCreateAccessPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.AccessPolicy, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccessPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.AccessPolicy.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("CreateAccessPolicy"))
              .build();
        }
      }
    }
    return getCreateAccessPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest,
      com.google.longrunning.Operation> getUpdateAccessPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccessPolicy",
      requestType = com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest,
      com.google.longrunning.Operation> getUpdateAccessPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest, com.google.longrunning.Operation> getUpdateAccessPolicyMethod;
    if ((getUpdateAccessPolicyMethod = AccessContextManagerGrpc.getUpdateAccessPolicyMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getUpdateAccessPolicyMethod = AccessContextManagerGrpc.getUpdateAccessPolicyMethod) == null) {
          AccessContextManagerGrpc.getUpdateAccessPolicyMethod = getUpdateAccessPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccessPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("UpdateAccessPolicy"))
              .build();
        }
      }
    }
    return getUpdateAccessPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest,
      com.google.longrunning.Operation> getDeleteAccessPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccessPolicy",
      requestType = com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest,
      com.google.longrunning.Operation> getDeleteAccessPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest, com.google.longrunning.Operation> getDeleteAccessPolicyMethod;
    if ((getDeleteAccessPolicyMethod = AccessContextManagerGrpc.getDeleteAccessPolicyMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getDeleteAccessPolicyMethod = AccessContextManagerGrpc.getDeleteAccessPolicyMethod) == null) {
          AccessContextManagerGrpc.getDeleteAccessPolicyMethod = getDeleteAccessPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccessPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("DeleteAccessPolicy"))
              .build();
        }
      }
    }
    return getDeleteAccessPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest,
      com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse> getListAccessLevelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccessLevels",
      requestType = com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest.class,
      responseType = com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest,
      com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse> getListAccessLevelsMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest, com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse> getListAccessLevelsMethod;
    if ((getListAccessLevelsMethod = AccessContextManagerGrpc.getListAccessLevelsMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getListAccessLevelsMethod = AccessContextManagerGrpc.getListAccessLevelsMethod) == null) {
          AccessContextManagerGrpc.getListAccessLevelsMethod = getListAccessLevelsMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest, com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccessLevels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("ListAccessLevels"))
              .build();
        }
      }
    }
    return getListAccessLevelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest,
      com.google.identity.accesscontextmanager.v1.AccessLevel> getGetAccessLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccessLevel",
      requestType = com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest.class,
      responseType = com.google.identity.accesscontextmanager.v1.AccessLevel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest,
      com.google.identity.accesscontextmanager.v1.AccessLevel> getGetAccessLevelMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest, com.google.identity.accesscontextmanager.v1.AccessLevel> getGetAccessLevelMethod;
    if ((getGetAccessLevelMethod = AccessContextManagerGrpc.getGetAccessLevelMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getGetAccessLevelMethod = AccessContextManagerGrpc.getGetAccessLevelMethod) == null) {
          AccessContextManagerGrpc.getGetAccessLevelMethod = getGetAccessLevelMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest, com.google.identity.accesscontextmanager.v1.AccessLevel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccessLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.AccessLevel.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("GetAccessLevel"))
              .build();
        }
      }
    }
    return getGetAccessLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest,
      com.google.longrunning.Operation> getCreateAccessLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccessLevel",
      requestType = com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest,
      com.google.longrunning.Operation> getCreateAccessLevelMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest, com.google.longrunning.Operation> getCreateAccessLevelMethod;
    if ((getCreateAccessLevelMethod = AccessContextManagerGrpc.getCreateAccessLevelMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getCreateAccessLevelMethod = AccessContextManagerGrpc.getCreateAccessLevelMethod) == null) {
          AccessContextManagerGrpc.getCreateAccessLevelMethod = getCreateAccessLevelMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccessLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("CreateAccessLevel"))
              .build();
        }
      }
    }
    return getCreateAccessLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest,
      com.google.longrunning.Operation> getUpdateAccessLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccessLevel",
      requestType = com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest,
      com.google.longrunning.Operation> getUpdateAccessLevelMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest, com.google.longrunning.Operation> getUpdateAccessLevelMethod;
    if ((getUpdateAccessLevelMethod = AccessContextManagerGrpc.getUpdateAccessLevelMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getUpdateAccessLevelMethod = AccessContextManagerGrpc.getUpdateAccessLevelMethod) == null) {
          AccessContextManagerGrpc.getUpdateAccessLevelMethod = getUpdateAccessLevelMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccessLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("UpdateAccessLevel"))
              .build();
        }
      }
    }
    return getUpdateAccessLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest,
      com.google.longrunning.Operation> getDeleteAccessLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccessLevel",
      requestType = com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest,
      com.google.longrunning.Operation> getDeleteAccessLevelMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest, com.google.longrunning.Operation> getDeleteAccessLevelMethod;
    if ((getDeleteAccessLevelMethod = AccessContextManagerGrpc.getDeleteAccessLevelMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getDeleteAccessLevelMethod = AccessContextManagerGrpc.getDeleteAccessLevelMethod) == null) {
          AccessContextManagerGrpc.getDeleteAccessLevelMethod = getDeleteAccessLevelMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccessLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("DeleteAccessLevel"))
              .build();
        }
      }
    }
    return getDeleteAccessLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest,
      com.google.longrunning.Operation> getReplaceAccessLevelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReplaceAccessLevels",
      requestType = com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest,
      com.google.longrunning.Operation> getReplaceAccessLevelsMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest, com.google.longrunning.Operation> getReplaceAccessLevelsMethod;
    if ((getReplaceAccessLevelsMethod = AccessContextManagerGrpc.getReplaceAccessLevelsMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getReplaceAccessLevelsMethod = AccessContextManagerGrpc.getReplaceAccessLevelsMethod) == null) {
          AccessContextManagerGrpc.getReplaceAccessLevelsMethod = getReplaceAccessLevelsMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReplaceAccessLevels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("ReplaceAccessLevels"))
              .build();
        }
      }
    }
    return getReplaceAccessLevelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest,
      com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse> getListServicePerimetersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServicePerimeters",
      requestType = com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest.class,
      responseType = com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest,
      com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse> getListServicePerimetersMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest, com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse> getListServicePerimetersMethod;
    if ((getListServicePerimetersMethod = AccessContextManagerGrpc.getListServicePerimetersMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getListServicePerimetersMethod = AccessContextManagerGrpc.getListServicePerimetersMethod) == null) {
          AccessContextManagerGrpc.getListServicePerimetersMethod = getListServicePerimetersMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest, com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServicePerimeters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("ListServicePerimeters"))
              .build();
        }
      }
    }
    return getListServicePerimetersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest,
      com.google.identity.accesscontextmanager.v1.ServicePerimeter> getGetServicePerimeterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServicePerimeter",
      requestType = com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest.class,
      responseType = com.google.identity.accesscontextmanager.v1.ServicePerimeter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest,
      com.google.identity.accesscontextmanager.v1.ServicePerimeter> getGetServicePerimeterMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest, com.google.identity.accesscontextmanager.v1.ServicePerimeter> getGetServicePerimeterMethod;
    if ((getGetServicePerimeterMethod = AccessContextManagerGrpc.getGetServicePerimeterMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getGetServicePerimeterMethod = AccessContextManagerGrpc.getGetServicePerimeterMethod) == null) {
          AccessContextManagerGrpc.getGetServicePerimeterMethod = getGetServicePerimeterMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest, com.google.identity.accesscontextmanager.v1.ServicePerimeter>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServicePerimeter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ServicePerimeter.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("GetServicePerimeter"))
              .build();
        }
      }
    }
    return getGetServicePerimeterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest,
      com.google.longrunning.Operation> getCreateServicePerimeterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServicePerimeter",
      requestType = com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest,
      com.google.longrunning.Operation> getCreateServicePerimeterMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest, com.google.longrunning.Operation> getCreateServicePerimeterMethod;
    if ((getCreateServicePerimeterMethod = AccessContextManagerGrpc.getCreateServicePerimeterMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getCreateServicePerimeterMethod = AccessContextManagerGrpc.getCreateServicePerimeterMethod) == null) {
          AccessContextManagerGrpc.getCreateServicePerimeterMethod = getCreateServicePerimeterMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateServicePerimeter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("CreateServicePerimeter"))
              .build();
        }
      }
    }
    return getCreateServicePerimeterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest,
      com.google.longrunning.Operation> getUpdateServicePerimeterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServicePerimeter",
      requestType = com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest,
      com.google.longrunning.Operation> getUpdateServicePerimeterMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest, com.google.longrunning.Operation> getUpdateServicePerimeterMethod;
    if ((getUpdateServicePerimeterMethod = AccessContextManagerGrpc.getUpdateServicePerimeterMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getUpdateServicePerimeterMethod = AccessContextManagerGrpc.getUpdateServicePerimeterMethod) == null) {
          AccessContextManagerGrpc.getUpdateServicePerimeterMethod = getUpdateServicePerimeterMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateServicePerimeter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("UpdateServicePerimeter"))
              .build();
        }
      }
    }
    return getUpdateServicePerimeterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest,
      com.google.longrunning.Operation> getDeleteServicePerimeterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServicePerimeter",
      requestType = com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest,
      com.google.longrunning.Operation> getDeleteServicePerimeterMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest, com.google.longrunning.Operation> getDeleteServicePerimeterMethod;
    if ((getDeleteServicePerimeterMethod = AccessContextManagerGrpc.getDeleteServicePerimeterMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getDeleteServicePerimeterMethod = AccessContextManagerGrpc.getDeleteServicePerimeterMethod) == null) {
          AccessContextManagerGrpc.getDeleteServicePerimeterMethod = getDeleteServicePerimeterMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteServicePerimeter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("DeleteServicePerimeter"))
              .build();
        }
      }
    }
    return getDeleteServicePerimeterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest,
      com.google.longrunning.Operation> getReplaceServicePerimetersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReplaceServicePerimeters",
      requestType = com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest,
      com.google.longrunning.Operation> getReplaceServicePerimetersMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest, com.google.longrunning.Operation> getReplaceServicePerimetersMethod;
    if ((getReplaceServicePerimetersMethod = AccessContextManagerGrpc.getReplaceServicePerimetersMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getReplaceServicePerimetersMethod = AccessContextManagerGrpc.getReplaceServicePerimetersMethod) == null) {
          AccessContextManagerGrpc.getReplaceServicePerimetersMethod = getReplaceServicePerimetersMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReplaceServicePerimeters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("ReplaceServicePerimeters"))
              .build();
        }
      }
    }
    return getReplaceServicePerimetersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest,
      com.google.longrunning.Operation> getCommitServicePerimetersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CommitServicePerimeters",
      requestType = com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest,
      com.google.longrunning.Operation> getCommitServicePerimetersMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest, com.google.longrunning.Operation> getCommitServicePerimetersMethod;
    if ((getCommitServicePerimetersMethod = AccessContextManagerGrpc.getCommitServicePerimetersMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getCommitServicePerimetersMethod = AccessContextManagerGrpc.getCommitServicePerimetersMethod) == null) {
          AccessContextManagerGrpc.getCommitServicePerimetersMethod = getCommitServicePerimetersMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CommitServicePerimeters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("CommitServicePerimeters"))
              .build();
        }
      }
    }
    return getCommitServicePerimetersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest,
      com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse> getListGcpUserAccessBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGcpUserAccessBindings",
      requestType = com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest.class,
      responseType = com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest,
      com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse> getListGcpUserAccessBindingsMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest, com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse> getListGcpUserAccessBindingsMethod;
    if ((getListGcpUserAccessBindingsMethod = AccessContextManagerGrpc.getListGcpUserAccessBindingsMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getListGcpUserAccessBindingsMethod = AccessContextManagerGrpc.getListGcpUserAccessBindingsMethod) == null) {
          AccessContextManagerGrpc.getListGcpUserAccessBindingsMethod = getListGcpUserAccessBindingsMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest, com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGcpUserAccessBindings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("ListGcpUserAccessBindings"))
              .build();
        }
      }
    }
    return getListGcpUserAccessBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest,
      com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding> getGetGcpUserAccessBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGcpUserAccessBinding",
      requestType = com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest.class,
      responseType = com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest,
      com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding> getGetGcpUserAccessBindingMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest, com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding> getGetGcpUserAccessBindingMethod;
    if ((getGetGcpUserAccessBindingMethod = AccessContextManagerGrpc.getGetGcpUserAccessBindingMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getGetGcpUserAccessBindingMethod = AccessContextManagerGrpc.getGetGcpUserAccessBindingMethod) == null) {
          AccessContextManagerGrpc.getGetGcpUserAccessBindingMethod = getGetGcpUserAccessBindingMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest, com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGcpUserAccessBinding"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("GetGcpUserAccessBinding"))
              .build();
        }
      }
    }
    return getGetGcpUserAccessBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest,
      com.google.longrunning.Operation> getCreateGcpUserAccessBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGcpUserAccessBinding",
      requestType = com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest,
      com.google.longrunning.Operation> getCreateGcpUserAccessBindingMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest, com.google.longrunning.Operation> getCreateGcpUserAccessBindingMethod;
    if ((getCreateGcpUserAccessBindingMethod = AccessContextManagerGrpc.getCreateGcpUserAccessBindingMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getCreateGcpUserAccessBindingMethod = AccessContextManagerGrpc.getCreateGcpUserAccessBindingMethod) == null) {
          AccessContextManagerGrpc.getCreateGcpUserAccessBindingMethod = getCreateGcpUserAccessBindingMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGcpUserAccessBinding"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("CreateGcpUserAccessBinding"))
              .build();
        }
      }
    }
    return getCreateGcpUserAccessBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest,
      com.google.longrunning.Operation> getUpdateGcpUserAccessBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGcpUserAccessBinding",
      requestType = com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest,
      com.google.longrunning.Operation> getUpdateGcpUserAccessBindingMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest, com.google.longrunning.Operation> getUpdateGcpUserAccessBindingMethod;
    if ((getUpdateGcpUserAccessBindingMethod = AccessContextManagerGrpc.getUpdateGcpUserAccessBindingMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getUpdateGcpUserAccessBindingMethod = AccessContextManagerGrpc.getUpdateGcpUserAccessBindingMethod) == null) {
          AccessContextManagerGrpc.getUpdateGcpUserAccessBindingMethod = getUpdateGcpUserAccessBindingMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGcpUserAccessBinding"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("UpdateGcpUserAccessBinding"))
              .build();
        }
      }
    }
    return getUpdateGcpUserAccessBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest,
      com.google.longrunning.Operation> getDeleteGcpUserAccessBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGcpUserAccessBinding",
      requestType = com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest,
      com.google.longrunning.Operation> getDeleteGcpUserAccessBindingMethod() {
    io.grpc.MethodDescriptor<com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest, com.google.longrunning.Operation> getDeleteGcpUserAccessBindingMethod;
    if ((getDeleteGcpUserAccessBindingMethod = AccessContextManagerGrpc.getDeleteGcpUserAccessBindingMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getDeleteGcpUserAccessBindingMethod = AccessContextManagerGrpc.getDeleteGcpUserAccessBindingMethod) == null) {
          AccessContextManagerGrpc.getDeleteGcpUserAccessBindingMethod = getDeleteGcpUserAccessBindingMethod =
              io.grpc.MethodDescriptor.<com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGcpUserAccessBinding"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("DeleteGcpUserAccessBinding"))
              .build();
        }
      }
    }
    return getDeleteGcpUserAccessBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = AccessContextManagerGrpc.getSetIamPolicyMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getSetIamPolicyMethod = AccessContextManagerGrpc.getSetIamPolicyMethod) == null) {
          AccessContextManagerGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = AccessContextManagerGrpc.getGetIamPolicyMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getGetIamPolicyMethod = AccessContextManagerGrpc.getGetIamPolicyMethod) == null) {
          AccessContextManagerGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = AccessContextManagerGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (AccessContextManagerGrpc.class) {
        if ((getTestIamPermissionsMethod = AccessContextManagerGrpc.getTestIamPermissionsMethod) == null) {
          AccessContextManagerGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccessContextManagerMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccessContextManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessContextManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccessContextManagerStub>() {
        @java.lang.Override
        public AccessContextManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccessContextManagerStub(channel, callOptions);
        }
      };
    return AccessContextManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccessContextManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessContextManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccessContextManagerBlockingStub>() {
        @java.lang.Override
        public AccessContextManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccessContextManagerBlockingStub(channel, callOptions);
        }
      };
    return AccessContextManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccessContextManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessContextManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccessContextManagerFutureStub>() {
        @java.lang.Override
        public AccessContextManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccessContextManagerFutureStub(channel, callOptions);
        }
      };
    return AccessContextManagerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * API for setting [access levels]
   * [google.identity.accesscontextmanager.v1.AccessLevel] and [service
   * perimeters] [google.identity.accesscontextmanager.v1.ServicePerimeter]
   * for Google Cloud projects. Each organization has one [access policy]
   * [google.identity.accesscontextmanager.v1.AccessPolicy] that contains the
   * [access levels] [google.identity.accesscontextmanager.v1.AccessLevel]
   * and [service perimeters]
   * [google.identity.accesscontextmanager.v1.ServicePerimeter]. This
   * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy] is
   * applicable to all resources in the organization.
   * AccessPolicies
   * </pre>
   */
  public static abstract class AccessContextManagerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists all [access policies]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] in an
     * organization.
     * </pre>
     */
    public void listAccessPolicies(com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAccessPoliciesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] based on the name.
     * </pre>
     */
    public void getAccessPolicy(com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.AccessPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccessPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an access policy. This method fails if the organization already has
     * an access policy. The long-running operation has a successful status
     * after the access policy propagates to long-lasting storage.
     * Syntactic and basic semantic errors are returned in `metadata` as a
     * BadRequest proto.
     * </pre>
     */
    public void createAccessPolicy(com.google.identity.accesscontextmanager.v1.AccessPolicy request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccessPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy]. The
     * long-running operation from this RPC has a successful status after the
     * changes to the [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] propagate
     * to long-lasting storage.
     * </pre>
     */
    public void updateAccessPolicy(com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAccessPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] based on the
     * resource name. The long-running operation has a successful status after the
     * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy]
     * is removed from long-lasting storage.
     * </pre>
     */
    public void deleteAccessPolicy(com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAccessPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] for an access
     * policy.
     * </pre>
     */
    public void listAccessLevels(com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAccessLevelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] based on the resource
     * name.
     * </pre>
     */
    public void getAccessLevel(com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.AccessLevel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccessLevelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel]. The long-running
     * operation from this RPC has a successful status after the [access
     * level] [google.identity.accesscontextmanager.v1.AccessLevel]
     * propagates to long-lasting storage. If [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contain
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public void createAccessLevel(com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccessLevelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel]. The long-running
     * operation from this RPC has a successful status after the changes to
     * the [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] propagate
     * to long-lasting storage. If [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contain
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public void updateAccessLevel(com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAccessLevelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] based on the resource
     * name. The long-running operation from this RPC has a successful status
     * after the [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] has been removed
     * from long-lasting storage.
     * </pre>
     */
    public void deleteAccessLevel(com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAccessLevelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Replaces all existing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] in an [access
     * policy] [google.identity.accesscontextmanager.v1.AccessPolicy] with
     * the [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] provided. This
     * is done atomically. The long-running operation from this RPC has a
     * successful status after all replacements propagate to long-lasting
     * storage. If the replacement contains errors, an error response is returned
     * for the first error encountered.  Upon error, the replacement is cancelled,
     * and existing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] are not
     * affected. The Operation.response field contains
     * ReplaceAccessLevelsResponse. Removing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contained in existing
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] result in an
     * error.
     * </pre>
     */
    public void replaceAccessLevels(com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReplaceAccessLevelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] for an
     * access policy.
     * </pre>
     */
    public void listServicePerimeters(com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServicePerimetersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] based on the
     * resource name.
     * </pre>
     */
    public void getServicePerimeter(com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ServicePerimeter> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServicePerimeterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]. The
     * long-running operation from this RPC has a successful status after the
     * [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]
     * propagates to long-lasting storage. If a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] contains
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public void createServicePerimeter(com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServicePerimeterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]. The
     * long-running operation from this RPC has a successful status after the
     * [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]
     * propagates to long-lasting storage. If a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] contains
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public void updateServicePerimeter(com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateServicePerimeterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] based on the
     * resource name. The long-running operation from this RPC has a successful
     * status after the [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] is removed from
     * long-lasting storage.
     * </pre>
     */
    public void deleteServicePerimeter(com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteServicePerimeterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Replace all existing [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] in an [access
     * policy] [google.identity.accesscontextmanager.v1.AccessPolicy] with the
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] provided. This
     * is done atomically. The long-running operation from this RPC has a
     * successful status after all replacements propagate to long-lasting storage.
     * Replacements containing errors result in an error response for the first
     * error encountered. Upon an error, replacement are cancelled and existing
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] are not
     * affected. The Operation.response field contains
     * ReplaceServicePerimetersResponse.
     * </pre>
     */
    public void replaceServicePerimeters(com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReplaceServicePerimetersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Commits the dry-run specification for all the [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] in an
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * A commit operation on a service perimeter involves copying its `spec` field
     * to the `status` field of the service perimeter. Only [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] with
     * `use_explicit_dry_run_spec` field set to true are affected by a commit
     * operation. The long-running operation from this RPC has a successful
     * status after the dry-run specifications for all the [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] have been
     * committed. If a commit fails, it causes the long-running operation to
     * return an error response and the entire commit operation is cancelled.
     * When successful, the Operation.response field contains
     * CommitServicePerimetersResponse. The `dry_run` and the `spec` fields are
     * cleared after a successful commit operation.
     * </pre>
     */
    public void commitServicePerimeters(com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCommitServicePerimetersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all [GcpUserAccessBindings]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding] for a
     * Google Cloud organization.
     * </pre>
     */
    public void listGcpUserAccessBindings(com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGcpUserAccessBindingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding] with
     * the given name.
     * </pre>
     */
    public void getGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGcpUserAccessBindingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding]. If the
     * client specifies a [name]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding.name],
     * the server ignores it. Fails if a resource already exists with the same
     * [group_key]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding.group_key].
     * Completion of this long-running operation does not necessarily signify that
     * the new binding is deployed onto all affected users, which may take more
     * time.
     * </pre>
     */
    public void createGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateGcpUserAccessBindingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding].
     * Completion of this long-running operation does not necessarily signify that
     * the changed binding is deployed onto all affected users, which may take
     * more time.
     * </pre>
     */
    public void updateGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateGcpUserAccessBindingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding].
     * Completion of this long-running operation does not necessarily signify that
     * the binding deletion is deployed onto all affected users, which may take
     * more time.
     * </pre>
     */
    public void deleteGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteGcpUserAccessBindingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM policy for the specified Access Context Manager
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * This method replaces the existing IAM policy on the access policy. The IAM
     * policy controls the set of users who can perform specific operations on the
     * Access Context Manager [access
     * policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM policy for the specified Access Context Manager
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the IAM permissions that the caller has on the specified Access
     * Context Manager resource. The resource can be an
     * [AccessPolicy][google.identity.accesscontextmanager.v1.AccessPolicy],
     * [AccessLevel][google.identity.accesscontextmanager.v1.AccessLevel], or
     * [ServicePerimeter][google.identity.accesscontextmanager.v1.ServicePerimeter
     * ]. This method does not support other resources.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAccessPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest,
                com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse>(
                  this, METHODID_LIST_ACCESS_POLICIES)))
          .addMethod(
            getGetAccessPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest,
                com.google.identity.accesscontextmanager.v1.AccessPolicy>(
                  this, METHODID_GET_ACCESS_POLICY)))
          .addMethod(
            getCreateAccessPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.AccessPolicy,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ACCESS_POLICY)))
          .addMethod(
            getUpdateAccessPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_ACCESS_POLICY)))
          .addMethod(
            getDeleteAccessPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_ACCESS_POLICY)))
          .addMethod(
            getListAccessLevelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest,
                com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse>(
                  this, METHODID_LIST_ACCESS_LEVELS)))
          .addMethod(
            getGetAccessLevelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest,
                com.google.identity.accesscontextmanager.v1.AccessLevel>(
                  this, METHODID_GET_ACCESS_LEVEL)))
          .addMethod(
            getCreateAccessLevelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ACCESS_LEVEL)))
          .addMethod(
            getUpdateAccessLevelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_ACCESS_LEVEL)))
          .addMethod(
            getDeleteAccessLevelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_ACCESS_LEVEL)))
          .addMethod(
            getReplaceAccessLevelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_REPLACE_ACCESS_LEVELS)))
          .addMethod(
            getListServicePerimetersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest,
                com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse>(
                  this, METHODID_LIST_SERVICE_PERIMETERS)))
          .addMethod(
            getGetServicePerimeterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest,
                com.google.identity.accesscontextmanager.v1.ServicePerimeter>(
                  this, METHODID_GET_SERVICE_PERIMETER)))
          .addMethod(
            getCreateServicePerimeterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_SERVICE_PERIMETER)))
          .addMethod(
            getUpdateServicePerimeterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_SERVICE_PERIMETER)))
          .addMethod(
            getDeleteServicePerimeterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_SERVICE_PERIMETER)))
          .addMethod(
            getReplaceServicePerimetersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_REPLACE_SERVICE_PERIMETERS)))
          .addMethod(
            getCommitServicePerimetersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_COMMIT_SERVICE_PERIMETERS)))
          .addMethod(
            getListGcpUserAccessBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest,
                com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse>(
                  this, METHODID_LIST_GCP_USER_ACCESS_BINDINGS)))
          .addMethod(
            getGetGcpUserAccessBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest,
                com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding>(
                  this, METHODID_GET_GCP_USER_ACCESS_BINDING)))
          .addMethod(
            getCreateGcpUserAccessBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_GCP_USER_ACCESS_BINDING)))
          .addMethod(
            getUpdateGcpUserAccessBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_GCP_USER_ACCESS_BINDING)))
          .addMethod(
            getDeleteGcpUserAccessBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_GCP_USER_ACCESS_BINDING)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * API for setting [access levels]
   * [google.identity.accesscontextmanager.v1.AccessLevel] and [service
   * perimeters] [google.identity.accesscontextmanager.v1.ServicePerimeter]
   * for Google Cloud projects. Each organization has one [access policy]
   * [google.identity.accesscontextmanager.v1.AccessPolicy] that contains the
   * [access levels] [google.identity.accesscontextmanager.v1.AccessLevel]
   * and [service perimeters]
   * [google.identity.accesscontextmanager.v1.ServicePerimeter]. This
   * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy] is
   * applicable to all resources in the organization.
   * AccessPolicies
   * </pre>
   */
  public static final class AccessContextManagerStub extends io.grpc.stub.AbstractAsyncStub<AccessContextManagerStub> {
    private AccessContextManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessContextManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessContextManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all [access policies]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] in an
     * organization.
     * </pre>
     */
    public void listAccessPolicies(com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccessPoliciesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] based on the name.
     * </pre>
     */
    public void getAccessPolicy(com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.AccessPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccessPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an access policy. This method fails if the organization already has
     * an access policy. The long-running operation has a successful status
     * after the access policy propagates to long-lasting storage.
     * Syntactic and basic semantic errors are returned in `metadata` as a
     * BadRequest proto.
     * </pre>
     */
    public void createAccessPolicy(com.google.identity.accesscontextmanager.v1.AccessPolicy request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccessPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy]. The
     * long-running operation from this RPC has a successful status after the
     * changes to the [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] propagate
     * to long-lasting storage.
     * </pre>
     */
    public void updateAccessPolicy(com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccessPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] based on the
     * resource name. The long-running operation has a successful status after the
     * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy]
     * is removed from long-lasting storage.
     * </pre>
     */
    public void deleteAccessPolicy(com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccessPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] for an access
     * policy.
     * </pre>
     */
    public void listAccessLevels(com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccessLevelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] based on the resource
     * name.
     * </pre>
     */
    public void getAccessLevel(com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.AccessLevel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccessLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel]. The long-running
     * operation from this RPC has a successful status after the [access
     * level] [google.identity.accesscontextmanager.v1.AccessLevel]
     * propagates to long-lasting storage. If [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contain
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public void createAccessLevel(com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccessLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel]. The long-running
     * operation from this RPC has a successful status after the changes to
     * the [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] propagate
     * to long-lasting storage. If [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contain
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public void updateAccessLevel(com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccessLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] based on the resource
     * name. The long-running operation from this RPC has a successful status
     * after the [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] has been removed
     * from long-lasting storage.
     * </pre>
     */
    public void deleteAccessLevel(com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccessLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Replaces all existing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] in an [access
     * policy] [google.identity.accesscontextmanager.v1.AccessPolicy] with
     * the [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] provided. This
     * is done atomically. The long-running operation from this RPC has a
     * successful status after all replacements propagate to long-lasting
     * storage. If the replacement contains errors, an error response is returned
     * for the first error encountered.  Upon error, the replacement is cancelled,
     * and existing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] are not
     * affected. The Operation.response field contains
     * ReplaceAccessLevelsResponse. Removing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contained in existing
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] result in an
     * error.
     * </pre>
     */
    public void replaceAccessLevels(com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReplaceAccessLevelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] for an
     * access policy.
     * </pre>
     */
    public void listServicePerimeters(com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicePerimetersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] based on the
     * resource name.
     * </pre>
     */
    public void getServicePerimeter(com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ServicePerimeter> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServicePerimeterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]. The
     * long-running operation from this RPC has a successful status after the
     * [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]
     * propagates to long-lasting storage. If a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] contains
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public void createServicePerimeter(com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServicePerimeterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]. The
     * long-running operation from this RPC has a successful status after the
     * [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]
     * propagates to long-lasting storage. If a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] contains
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public void updateServicePerimeter(com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServicePerimeterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] based on the
     * resource name. The long-running operation from this RPC has a successful
     * status after the [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] is removed from
     * long-lasting storage.
     * </pre>
     */
    public void deleteServicePerimeter(com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServicePerimeterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Replace all existing [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] in an [access
     * policy] [google.identity.accesscontextmanager.v1.AccessPolicy] with the
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] provided. This
     * is done atomically. The long-running operation from this RPC has a
     * successful status after all replacements propagate to long-lasting storage.
     * Replacements containing errors result in an error response for the first
     * error encountered. Upon an error, replacement are cancelled and existing
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] are not
     * affected. The Operation.response field contains
     * ReplaceServicePerimetersResponse.
     * </pre>
     */
    public void replaceServicePerimeters(com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReplaceServicePerimetersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Commits the dry-run specification for all the [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] in an
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * A commit operation on a service perimeter involves copying its `spec` field
     * to the `status` field of the service perimeter. Only [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] with
     * `use_explicit_dry_run_spec` field set to true are affected by a commit
     * operation. The long-running operation from this RPC has a successful
     * status after the dry-run specifications for all the [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] have been
     * committed. If a commit fails, it causes the long-running operation to
     * return an error response and the entire commit operation is cancelled.
     * When successful, the Operation.response field contains
     * CommitServicePerimetersResponse. The `dry_run` and the `spec` fields are
     * cleared after a successful commit operation.
     * </pre>
     */
    public void commitServicePerimeters(com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitServicePerimetersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all [GcpUserAccessBindings]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding] for a
     * Google Cloud organization.
     * </pre>
     */
    public void listGcpUserAccessBindings(com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGcpUserAccessBindingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding] with
     * the given name.
     * </pre>
     */
    public void getGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGcpUserAccessBindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding]. If the
     * client specifies a [name]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding.name],
     * the server ignores it. Fails if a resource already exists with the same
     * [group_key]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding.group_key].
     * Completion of this long-running operation does not necessarily signify that
     * the new binding is deployed onto all affected users, which may take more
     * time.
     * </pre>
     */
    public void createGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGcpUserAccessBindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding].
     * Completion of this long-running operation does not necessarily signify that
     * the changed binding is deployed onto all affected users, which may take
     * more time.
     * </pre>
     */
    public void updateGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGcpUserAccessBindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding].
     * Completion of this long-running operation does not necessarily signify that
     * the binding deletion is deployed onto all affected users, which may take
     * more time.
     * </pre>
     */
    public void deleteGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGcpUserAccessBindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM policy for the specified Access Context Manager
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * This method replaces the existing IAM policy on the access policy. The IAM
     * policy controls the set of users who can perform specific operations on the
     * Access Context Manager [access
     * policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM policy for the specified Access Context Manager
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the IAM permissions that the caller has on the specified Access
     * Context Manager resource. The resource can be an
     * [AccessPolicy][google.identity.accesscontextmanager.v1.AccessPolicy],
     * [AccessLevel][google.identity.accesscontextmanager.v1.AccessLevel], or
     * [ServicePerimeter][google.identity.accesscontextmanager.v1.ServicePerimeter
     * ]. This method does not support other resources.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * API for setting [access levels]
   * [google.identity.accesscontextmanager.v1.AccessLevel] and [service
   * perimeters] [google.identity.accesscontextmanager.v1.ServicePerimeter]
   * for Google Cloud projects. Each organization has one [access policy]
   * [google.identity.accesscontextmanager.v1.AccessPolicy] that contains the
   * [access levels] [google.identity.accesscontextmanager.v1.AccessLevel]
   * and [service perimeters]
   * [google.identity.accesscontextmanager.v1.ServicePerimeter]. This
   * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy] is
   * applicable to all resources in the organization.
   * AccessPolicies
   * </pre>
   */
  public static final class AccessContextManagerBlockingStub extends io.grpc.stub.AbstractBlockingStub<AccessContextManagerBlockingStub> {
    private AccessContextManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessContextManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessContextManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all [access policies]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] in an
     * organization.
     * </pre>
     */
    public com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse listAccessPolicies(com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccessPoliciesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] based on the name.
     * </pre>
     */
    public com.google.identity.accesscontextmanager.v1.AccessPolicy getAccessPolicy(com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an access policy. This method fails if the organization already has
     * an access policy. The long-running operation has a successful status
     * after the access policy propagates to long-lasting storage.
     * Syntactic and basic semantic errors are returned in `metadata` as a
     * BadRequest proto.
     * </pre>
     */
    public com.google.longrunning.Operation createAccessPolicy(com.google.identity.accesscontextmanager.v1.AccessPolicy request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy]. The
     * long-running operation from this RPC has a successful status after the
     * changes to the [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] propagate
     * to long-lasting storage.
     * </pre>
     */
    public com.google.longrunning.Operation updateAccessPolicy(com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] based on the
     * resource name. The long-running operation has a successful status after the
     * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy]
     * is removed from long-lasting storage.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAccessPolicy(com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] for an access
     * policy.
     * </pre>
     */
    public com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse listAccessLevels(com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccessLevelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] based on the resource
     * name.
     * </pre>
     */
    public com.google.identity.accesscontextmanager.v1.AccessLevel getAccessLevel(com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccessLevelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel]. The long-running
     * operation from this RPC has a successful status after the [access
     * level] [google.identity.accesscontextmanager.v1.AccessLevel]
     * propagates to long-lasting storage. If [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contain
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public com.google.longrunning.Operation createAccessLevel(com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccessLevelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel]. The long-running
     * operation from this RPC has a successful status after the changes to
     * the [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] propagate
     * to long-lasting storage. If [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contain
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public com.google.longrunning.Operation updateAccessLevel(com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccessLevelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] based on the resource
     * name. The long-running operation from this RPC has a successful status
     * after the [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] has been removed
     * from long-lasting storage.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAccessLevel(com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccessLevelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Replaces all existing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] in an [access
     * policy] [google.identity.accesscontextmanager.v1.AccessPolicy] with
     * the [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] provided. This
     * is done atomically. The long-running operation from this RPC has a
     * successful status after all replacements propagate to long-lasting
     * storage. If the replacement contains errors, an error response is returned
     * for the first error encountered.  Upon error, the replacement is cancelled,
     * and existing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] are not
     * affected. The Operation.response field contains
     * ReplaceAccessLevelsResponse. Removing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contained in existing
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] result in an
     * error.
     * </pre>
     */
    public com.google.longrunning.Operation replaceAccessLevels(com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReplaceAccessLevelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] for an
     * access policy.
     * </pre>
     */
    public com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse listServicePerimeters(com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicePerimetersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] based on the
     * resource name.
     * </pre>
     */
    public com.google.identity.accesscontextmanager.v1.ServicePerimeter getServicePerimeter(com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServicePerimeterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]. The
     * long-running operation from this RPC has a successful status after the
     * [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]
     * propagates to long-lasting storage. If a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] contains
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public com.google.longrunning.Operation createServicePerimeter(com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServicePerimeterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]. The
     * long-running operation from this RPC has a successful status after the
     * [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]
     * propagates to long-lasting storage. If a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] contains
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public com.google.longrunning.Operation updateServicePerimeter(com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServicePerimeterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] based on the
     * resource name. The long-running operation from this RPC has a successful
     * status after the [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] is removed from
     * long-lasting storage.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServicePerimeter(com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServicePerimeterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Replace all existing [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] in an [access
     * policy] [google.identity.accesscontextmanager.v1.AccessPolicy] with the
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] provided. This
     * is done atomically. The long-running operation from this RPC has a
     * successful status after all replacements propagate to long-lasting storage.
     * Replacements containing errors result in an error response for the first
     * error encountered. Upon an error, replacement are cancelled and existing
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] are not
     * affected. The Operation.response field contains
     * ReplaceServicePerimetersResponse.
     * </pre>
     */
    public com.google.longrunning.Operation replaceServicePerimeters(com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReplaceServicePerimetersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Commits the dry-run specification for all the [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] in an
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * A commit operation on a service perimeter involves copying its `spec` field
     * to the `status` field of the service perimeter. Only [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] with
     * `use_explicit_dry_run_spec` field set to true are affected by a commit
     * operation. The long-running operation from this RPC has a successful
     * status after the dry-run specifications for all the [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] have been
     * committed. If a commit fails, it causes the long-running operation to
     * return an error response and the entire commit operation is cancelled.
     * When successful, the Operation.response field contains
     * CommitServicePerimetersResponse. The `dry_run` and the `spec` fields are
     * cleared after a successful commit operation.
     * </pre>
     */
    public com.google.longrunning.Operation commitServicePerimeters(com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitServicePerimetersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all [GcpUserAccessBindings]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding] for a
     * Google Cloud organization.
     * </pre>
     */
    public com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse listGcpUserAccessBindings(com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGcpUserAccessBindingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding] with
     * the given name.
     * </pre>
     */
    public com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding getGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGcpUserAccessBindingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding]. If the
     * client specifies a [name]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding.name],
     * the server ignores it. Fails if a resource already exists with the same
     * [group_key]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding.group_key].
     * Completion of this long-running operation does not necessarily signify that
     * the new binding is deployed onto all affected users, which may take more
     * time.
     * </pre>
     */
    public com.google.longrunning.Operation createGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGcpUserAccessBindingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding].
     * Completion of this long-running operation does not necessarily signify that
     * the changed binding is deployed onto all affected users, which may take
     * more time.
     * </pre>
     */
    public com.google.longrunning.Operation updateGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGcpUserAccessBindingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding].
     * Completion of this long-running operation does not necessarily signify that
     * the binding deletion is deployed onto all affected users, which may take
     * more time.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGcpUserAccessBinding(com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGcpUserAccessBindingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the IAM policy for the specified Access Context Manager
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * This method replaces the existing IAM policy on the access policy. The IAM
     * policy controls the set of users who can perform specific operations on the
     * Access Context Manager [access
     * policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the IAM policy for the specified Access Context Manager
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the IAM permissions that the caller has on the specified Access
     * Context Manager resource. The resource can be an
     * [AccessPolicy][google.identity.accesscontextmanager.v1.AccessPolicy],
     * [AccessLevel][google.identity.accesscontextmanager.v1.AccessLevel], or
     * [ServicePerimeter][google.identity.accesscontextmanager.v1.ServicePerimeter
     * ]. This method does not support other resources.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * API for setting [access levels]
   * [google.identity.accesscontextmanager.v1.AccessLevel] and [service
   * perimeters] [google.identity.accesscontextmanager.v1.ServicePerimeter]
   * for Google Cloud projects. Each organization has one [access policy]
   * [google.identity.accesscontextmanager.v1.AccessPolicy] that contains the
   * [access levels] [google.identity.accesscontextmanager.v1.AccessLevel]
   * and [service perimeters]
   * [google.identity.accesscontextmanager.v1.ServicePerimeter]. This
   * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy] is
   * applicable to all resources in the organization.
   * AccessPolicies
   * </pre>
   */
  public static final class AccessContextManagerFutureStub extends io.grpc.stub.AbstractFutureStub<AccessContextManagerFutureStub> {
    private AccessContextManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessContextManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessContextManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all [access policies]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] in an
     * organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse> listAccessPolicies(
        com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccessPoliciesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] based on the name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.identity.accesscontextmanager.v1.AccessPolicy> getAccessPolicy(
        com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccessPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an access policy. This method fails if the organization already has
     * an access policy. The long-running operation has a successful status
     * after the access policy propagates to long-lasting storage.
     * Syntactic and basic semantic errors are returned in `metadata` as a
     * BadRequest proto.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAccessPolicy(
        com.google.identity.accesscontextmanager.v1.AccessPolicy request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccessPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy]. The
     * long-running operation from this RPC has a successful status after the
     * changes to the [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] propagate
     * to long-lasting storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAccessPolicy(
        com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccessPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an [access policy]
     * [google.identity.accesscontextmanager.v1.AccessPolicy] based on the
     * resource name. The long-running operation has a successful status after the
     * [access policy] [google.identity.accesscontextmanager.v1.AccessPolicy]
     * is removed from long-lasting storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAccessPolicy(
        com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccessPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] for an access
     * policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse> listAccessLevels(
        com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccessLevelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] based on the resource
     * name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.identity.accesscontextmanager.v1.AccessLevel> getAccessLevel(
        com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccessLevelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel]. The long-running
     * operation from this RPC has a successful status after the [access
     * level] [google.identity.accesscontextmanager.v1.AccessLevel]
     * propagates to long-lasting storage. If [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contain
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAccessLevel(
        com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccessLevelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel]. The long-running
     * operation from this RPC has a successful status after the changes to
     * the [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] propagate
     * to long-lasting storage. If [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contain
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAccessLevel(
        com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccessLevelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] based on the resource
     * name. The long-running operation from this RPC has a successful status
     * after the [access level]
     * [google.identity.accesscontextmanager.v1.AccessLevel] has been removed
     * from long-lasting storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAccessLevel(
        com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccessLevelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Replaces all existing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] in an [access
     * policy] [google.identity.accesscontextmanager.v1.AccessPolicy] with
     * the [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] provided. This
     * is done atomically. The long-running operation from this RPC has a
     * successful status after all replacements propagate to long-lasting
     * storage. If the replacement contains errors, an error response is returned
     * for the first error encountered.  Upon error, the replacement is cancelled,
     * and existing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] are not
     * affected. The Operation.response field contains
     * ReplaceAccessLevelsResponse. Removing [access levels]
     * [google.identity.accesscontextmanager.v1.AccessLevel] contained in existing
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] result in an
     * error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> replaceAccessLevels(
        com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReplaceAccessLevelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] for an
     * access policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse> listServicePerimeters(
        com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicePerimetersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] based on the
     * resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.identity.accesscontextmanager.v1.ServicePerimeter> getServicePerimeter(
        com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServicePerimeterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]. The
     * long-running operation from this RPC has a successful status after the
     * [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]
     * propagates to long-lasting storage. If a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] contains
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createServicePerimeter(
        com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServicePerimeterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]. The
     * long-running operation from this RPC has a successful status after the
     * [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter]
     * propagates to long-lasting storage. If a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] contains
     * errors, an error response is returned for the first error encountered.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateServicePerimeter(
        com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServicePerimeterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] based on the
     * resource name. The long-running operation from this RPC has a successful
     * status after the [service perimeter]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] is removed from
     * long-lasting storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteServicePerimeter(
        com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServicePerimeterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Replace all existing [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] in an [access
     * policy] [google.identity.accesscontextmanager.v1.AccessPolicy] with the
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] provided. This
     * is done atomically. The long-running operation from this RPC has a
     * successful status after all replacements propagate to long-lasting storage.
     * Replacements containing errors result in an error response for the first
     * error encountered. Upon an error, replacement are cancelled and existing
     * [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] are not
     * affected. The Operation.response field contains
     * ReplaceServicePerimetersResponse.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> replaceServicePerimeters(
        com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReplaceServicePerimetersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Commits the dry-run specification for all the [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] in an
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * A commit operation on a service perimeter involves copying its `spec` field
     * to the `status` field of the service perimeter. Only [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] with
     * `use_explicit_dry_run_spec` field set to true are affected by a commit
     * operation. The long-running operation from this RPC has a successful
     * status after the dry-run specifications for all the [service perimeters]
     * [google.identity.accesscontextmanager.v1.ServicePerimeter] have been
     * committed. If a commit fails, it causes the long-running operation to
     * return an error response and the entire commit operation is cancelled.
     * When successful, the Operation.response field contains
     * CommitServicePerimetersResponse. The `dry_run` and the `spec` fields are
     * cleared after a successful commit operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> commitServicePerimeters(
        com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitServicePerimetersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all [GcpUserAccessBindings]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding] for a
     * Google Cloud organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse> listGcpUserAccessBindings(
        com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGcpUserAccessBindingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding] with
     * the given name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding> getGcpUserAccessBinding(
        com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGcpUserAccessBindingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding]. If the
     * client specifies a [name]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding.name],
     * the server ignores it. Fails if a resource already exists with the same
     * [group_key]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding.group_key].
     * Completion of this long-running operation does not necessarily signify that
     * the new binding is deployed onto all affected users, which may take more
     * time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createGcpUserAccessBinding(
        com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGcpUserAccessBindingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding].
     * Completion of this long-running operation does not necessarily signify that
     * the changed binding is deployed onto all affected users, which may take
     * more time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateGcpUserAccessBinding(
        com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGcpUserAccessBindingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a [GcpUserAccessBinding]
     * [google.identity.accesscontextmanager.v1.GcpUserAccessBinding].
     * Completion of this long-running operation does not necessarily signify that
     * the binding deletion is deployed onto all affected users, which may take
     * more time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteGcpUserAccessBinding(
        com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGcpUserAccessBindingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the IAM policy for the specified Access Context Manager
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * This method replaces the existing IAM policy on the access policy. The IAM
     * policy controls the set of users who can perform specific operations on the
     * Access Context Manager [access
     * policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the IAM policy for the specified Access Context Manager
     * [access policy][google.identity.accesscontextmanager.v1.AccessPolicy].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the IAM permissions that the caller has on the specified Access
     * Context Manager resource. The resource can be an
     * [AccessPolicy][google.identity.accesscontextmanager.v1.AccessPolicy],
     * [AccessLevel][google.identity.accesscontextmanager.v1.AccessLevel], or
     * [ServicePerimeter][google.identity.accesscontextmanager.v1.ServicePerimeter
     * ]. This method does not support other resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ACCESS_POLICIES = 0;
  private static final int METHODID_GET_ACCESS_POLICY = 1;
  private static final int METHODID_CREATE_ACCESS_POLICY = 2;
  private static final int METHODID_UPDATE_ACCESS_POLICY = 3;
  private static final int METHODID_DELETE_ACCESS_POLICY = 4;
  private static final int METHODID_LIST_ACCESS_LEVELS = 5;
  private static final int METHODID_GET_ACCESS_LEVEL = 6;
  private static final int METHODID_CREATE_ACCESS_LEVEL = 7;
  private static final int METHODID_UPDATE_ACCESS_LEVEL = 8;
  private static final int METHODID_DELETE_ACCESS_LEVEL = 9;
  private static final int METHODID_REPLACE_ACCESS_LEVELS = 10;
  private static final int METHODID_LIST_SERVICE_PERIMETERS = 11;
  private static final int METHODID_GET_SERVICE_PERIMETER = 12;
  private static final int METHODID_CREATE_SERVICE_PERIMETER = 13;
  private static final int METHODID_UPDATE_SERVICE_PERIMETER = 14;
  private static final int METHODID_DELETE_SERVICE_PERIMETER = 15;
  private static final int METHODID_REPLACE_SERVICE_PERIMETERS = 16;
  private static final int METHODID_COMMIT_SERVICE_PERIMETERS = 17;
  private static final int METHODID_LIST_GCP_USER_ACCESS_BINDINGS = 18;
  private static final int METHODID_GET_GCP_USER_ACCESS_BINDING = 19;
  private static final int METHODID_CREATE_GCP_USER_ACCESS_BINDING = 20;
  private static final int METHODID_UPDATE_GCP_USER_ACCESS_BINDING = 21;
  private static final int METHODID_DELETE_GCP_USER_ACCESS_BINDING = 22;
  private static final int METHODID_SET_IAM_POLICY = 23;
  private static final int METHODID_GET_IAM_POLICY = 24;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 25;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccessContextManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccessContextManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ACCESS_POLICIES:
          serviceImpl.listAccessPolicies((com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse>) responseObserver);
          break;
        case METHODID_GET_ACCESS_POLICY:
          serviceImpl.getAccessPolicy((com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.AccessPolicy>) responseObserver);
          break;
        case METHODID_CREATE_ACCESS_POLICY:
          serviceImpl.createAccessPolicy((com.google.identity.accesscontextmanager.v1.AccessPolicy) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ACCESS_POLICY:
          serviceImpl.updateAccessPolicy((com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ACCESS_POLICY:
          serviceImpl.deleteAccessPolicy((com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ACCESS_LEVELS:
          serviceImpl.listAccessLevels((com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse>) responseObserver);
          break;
        case METHODID_GET_ACCESS_LEVEL:
          serviceImpl.getAccessLevel((com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.AccessLevel>) responseObserver);
          break;
        case METHODID_CREATE_ACCESS_LEVEL:
          serviceImpl.createAccessLevel((com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ACCESS_LEVEL:
          serviceImpl.updateAccessLevel((com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ACCESS_LEVEL:
          serviceImpl.deleteAccessLevel((com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REPLACE_ACCESS_LEVELS:
          serviceImpl.replaceAccessLevels((com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERVICE_PERIMETERS:
          serviceImpl.listServicePerimeters((com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse>) responseObserver);
          break;
        case METHODID_GET_SERVICE_PERIMETER:
          serviceImpl.getServicePerimeter((com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ServicePerimeter>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE_PERIMETER:
          serviceImpl.createServicePerimeter((com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE_PERIMETER:
          serviceImpl.updateServicePerimeter((com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_PERIMETER:
          serviceImpl.deleteServicePerimeter((com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REPLACE_SERVICE_PERIMETERS:
          serviceImpl.replaceServicePerimeters((com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_COMMIT_SERVICE_PERIMETERS:
          serviceImpl.commitServicePerimeters((com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_GCP_USER_ACCESS_BINDINGS:
          serviceImpl.listGcpUserAccessBindings((com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse>) responseObserver);
          break;
        case METHODID_GET_GCP_USER_ACCESS_BINDING:
          serviceImpl.getGcpUserAccessBinding((com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding>) responseObserver);
          break;
        case METHODID_CREATE_GCP_USER_ACCESS_BINDING:
          serviceImpl.createGcpUserAccessBinding((com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GCP_USER_ACCESS_BINDING:
          serviceImpl.updateGcpUserAccessBinding((com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GCP_USER_ACCESS_BINDING:
          serviceImpl.deleteGcpUserAccessBinding((com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
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

  private static abstract class AccessContextManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccessContextManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.identity.accesscontextmanager.v1.AccessContextManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccessContextManager");
    }
  }

  private static final class AccessContextManagerFileDescriptorSupplier
      extends AccessContextManagerBaseDescriptorSupplier {
    AccessContextManagerFileDescriptorSupplier() {}
  }

  private static final class AccessContextManagerMethodDescriptorSupplier
      extends AccessContextManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccessContextManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccessContextManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccessContextManagerFileDescriptorSupplier())
              .addMethod(getListAccessPoliciesMethod())
              .addMethod(getGetAccessPolicyMethod())
              .addMethod(getCreateAccessPolicyMethod())
              .addMethod(getUpdateAccessPolicyMethod())
              .addMethod(getDeleteAccessPolicyMethod())
              .addMethod(getListAccessLevelsMethod())
              .addMethod(getGetAccessLevelMethod())
              .addMethod(getCreateAccessLevelMethod())
              .addMethod(getUpdateAccessLevelMethod())
              .addMethod(getDeleteAccessLevelMethod())
              .addMethod(getReplaceAccessLevelsMethod())
              .addMethod(getListServicePerimetersMethod())
              .addMethod(getGetServicePerimeterMethod())
              .addMethod(getCreateServicePerimeterMethod())
              .addMethod(getUpdateServicePerimeterMethod())
              .addMethod(getDeleteServicePerimeterMethod())
              .addMethod(getReplaceServicePerimetersMethod())
              .addMethod(getCommitServicePerimetersMethod())
              .addMethod(getListGcpUserAccessBindingsMethod())
              .addMethod(getGetGcpUserAccessBindingMethod())
              .addMethod(getCreateGcpUserAccessBindingMethod())
              .addMethod(getUpdateGcpUserAccessBindingMethod())
              .addMethod(getDeleteGcpUserAccessBindingMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
