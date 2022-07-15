package com.google.cloud.networksecurity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Network Security API provides resources to configure authentication and
 * authorization policies. Refer to per API resource documentation for more
 * information.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networksecurity/v1/network_security.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NetworkSecurityGrpc {

  private NetworkSecurityGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.networksecurity.v1.NetworkSecurity";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest,
      com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse> getListAuthorizationPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthorizationPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest,
      com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse> getListAuthorizationPoliciesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest, com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse> getListAuthorizationPoliciesMethod;
    if ((getListAuthorizationPoliciesMethod = NetworkSecurityGrpc.getListAuthorizationPoliciesMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListAuthorizationPoliciesMethod = NetworkSecurityGrpc.getListAuthorizationPoliciesMethod) == null) {
          NetworkSecurityGrpc.getListAuthorizationPoliciesMethod = getListAuthorizationPoliciesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest, com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAuthorizationPolicies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("ListAuthorizationPolicies"))
              .build();
        }
      }
    }
    return getListAuthorizationPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest,
      com.google.cloud.networksecurity.v1.AuthorizationPolicy> getGetAuthorizationPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthorizationPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.AuthorizationPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest,
      com.google.cloud.networksecurity.v1.AuthorizationPolicy> getGetAuthorizationPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest, com.google.cloud.networksecurity.v1.AuthorizationPolicy> getGetAuthorizationPolicyMethod;
    if ((getGetAuthorizationPolicyMethod = NetworkSecurityGrpc.getGetAuthorizationPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetAuthorizationPolicyMethod = NetworkSecurityGrpc.getGetAuthorizationPolicyMethod) == null) {
          NetworkSecurityGrpc.getGetAuthorizationPolicyMethod = getGetAuthorizationPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest, com.google.cloud.networksecurity.v1.AuthorizationPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuthorizationPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.AuthorizationPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("GetAuthorizationPolicy"))
              .build();
        }
      }
    }
    return getGetAuthorizationPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest,
      com.google.longrunning.Operation> getCreateAuthorizationPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAuthorizationPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest,
      com.google.longrunning.Operation> getCreateAuthorizationPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest, com.google.longrunning.Operation> getCreateAuthorizationPolicyMethod;
    if ((getCreateAuthorizationPolicyMethod = NetworkSecurityGrpc.getCreateAuthorizationPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateAuthorizationPolicyMethod = NetworkSecurityGrpc.getCreateAuthorizationPolicyMethod) == null) {
          NetworkSecurityGrpc.getCreateAuthorizationPolicyMethod = getCreateAuthorizationPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAuthorizationPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("CreateAuthorizationPolicy"))
              .build();
        }
      }
    }
    return getCreateAuthorizationPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest,
      com.google.longrunning.Operation> getUpdateAuthorizationPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAuthorizationPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest,
      com.google.longrunning.Operation> getUpdateAuthorizationPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest, com.google.longrunning.Operation> getUpdateAuthorizationPolicyMethod;
    if ((getUpdateAuthorizationPolicyMethod = NetworkSecurityGrpc.getUpdateAuthorizationPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateAuthorizationPolicyMethod = NetworkSecurityGrpc.getUpdateAuthorizationPolicyMethod) == null) {
          NetworkSecurityGrpc.getUpdateAuthorizationPolicyMethod = getUpdateAuthorizationPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAuthorizationPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("UpdateAuthorizationPolicy"))
              .build();
        }
      }
    }
    return getUpdateAuthorizationPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest,
      com.google.longrunning.Operation> getDeleteAuthorizationPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAuthorizationPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest,
      com.google.longrunning.Operation> getDeleteAuthorizationPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest, com.google.longrunning.Operation> getDeleteAuthorizationPolicyMethod;
    if ((getDeleteAuthorizationPolicyMethod = NetworkSecurityGrpc.getDeleteAuthorizationPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteAuthorizationPolicyMethod = NetworkSecurityGrpc.getDeleteAuthorizationPolicyMethod) == null) {
          NetworkSecurityGrpc.getDeleteAuthorizationPolicyMethod = getDeleteAuthorizationPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAuthorizationPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("DeleteAuthorizationPolicy"))
              .build();
        }
      }
    }
    return getDeleteAuthorizationPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest,
      com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse> getListServerTlsPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServerTlsPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest,
      com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse> getListServerTlsPoliciesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest, com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse> getListServerTlsPoliciesMethod;
    if ((getListServerTlsPoliciesMethod = NetworkSecurityGrpc.getListServerTlsPoliciesMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListServerTlsPoliciesMethod = NetworkSecurityGrpc.getListServerTlsPoliciesMethod) == null) {
          NetworkSecurityGrpc.getListServerTlsPoliciesMethod = getListServerTlsPoliciesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest, com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServerTlsPolicies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("ListServerTlsPolicies"))
              .build();
        }
      }
    }
    return getListServerTlsPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest,
      com.google.cloud.networksecurity.v1.ServerTlsPolicy> getGetServerTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServerTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ServerTlsPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest,
      com.google.cloud.networksecurity.v1.ServerTlsPolicy> getGetServerTlsPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest, com.google.cloud.networksecurity.v1.ServerTlsPolicy> getGetServerTlsPolicyMethod;
    if ((getGetServerTlsPolicyMethod = NetworkSecurityGrpc.getGetServerTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetServerTlsPolicyMethod = NetworkSecurityGrpc.getGetServerTlsPolicyMethod) == null) {
          NetworkSecurityGrpc.getGetServerTlsPolicyMethod = getGetServerTlsPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest, com.google.cloud.networksecurity.v1.ServerTlsPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServerTlsPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.ServerTlsPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("GetServerTlsPolicy"))
              .build();
        }
      }
    }
    return getGetServerTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest,
      com.google.longrunning.Operation> getCreateServerTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServerTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest,
      com.google.longrunning.Operation> getCreateServerTlsPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest, com.google.longrunning.Operation> getCreateServerTlsPolicyMethod;
    if ((getCreateServerTlsPolicyMethod = NetworkSecurityGrpc.getCreateServerTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateServerTlsPolicyMethod = NetworkSecurityGrpc.getCreateServerTlsPolicyMethod) == null) {
          NetworkSecurityGrpc.getCreateServerTlsPolicyMethod = getCreateServerTlsPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateServerTlsPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("CreateServerTlsPolicy"))
              .build();
        }
      }
    }
    return getCreateServerTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest,
      com.google.longrunning.Operation> getUpdateServerTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServerTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest,
      com.google.longrunning.Operation> getUpdateServerTlsPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest, com.google.longrunning.Operation> getUpdateServerTlsPolicyMethod;
    if ((getUpdateServerTlsPolicyMethod = NetworkSecurityGrpc.getUpdateServerTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateServerTlsPolicyMethod = NetworkSecurityGrpc.getUpdateServerTlsPolicyMethod) == null) {
          NetworkSecurityGrpc.getUpdateServerTlsPolicyMethod = getUpdateServerTlsPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateServerTlsPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("UpdateServerTlsPolicy"))
              .build();
        }
      }
    }
    return getUpdateServerTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest,
      com.google.longrunning.Operation> getDeleteServerTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServerTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest,
      com.google.longrunning.Operation> getDeleteServerTlsPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest, com.google.longrunning.Operation> getDeleteServerTlsPolicyMethod;
    if ((getDeleteServerTlsPolicyMethod = NetworkSecurityGrpc.getDeleteServerTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteServerTlsPolicyMethod = NetworkSecurityGrpc.getDeleteServerTlsPolicyMethod) == null) {
          NetworkSecurityGrpc.getDeleteServerTlsPolicyMethod = getDeleteServerTlsPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteServerTlsPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("DeleteServerTlsPolicy"))
              .build();
        }
      }
    }
    return getDeleteServerTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest,
      com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse> getListClientTlsPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClientTlsPolicies",
      requestType = com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest,
      com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse> getListClientTlsPoliciesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest, com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse> getListClientTlsPoliciesMethod;
    if ((getListClientTlsPoliciesMethod = NetworkSecurityGrpc.getListClientTlsPoliciesMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getListClientTlsPoliciesMethod = NetworkSecurityGrpc.getListClientTlsPoliciesMethod) == null) {
          NetworkSecurityGrpc.getListClientTlsPoliciesMethod = getListClientTlsPoliciesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest, com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClientTlsPolicies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("ListClientTlsPolicies"))
              .build();
        }
      }
    }
    return getListClientTlsPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest,
      com.google.cloud.networksecurity.v1.ClientTlsPolicy> getGetClientTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClientTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ClientTlsPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest,
      com.google.cloud.networksecurity.v1.ClientTlsPolicy> getGetClientTlsPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest, com.google.cloud.networksecurity.v1.ClientTlsPolicy> getGetClientTlsPolicyMethod;
    if ((getGetClientTlsPolicyMethod = NetworkSecurityGrpc.getGetClientTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getGetClientTlsPolicyMethod = NetworkSecurityGrpc.getGetClientTlsPolicyMethod) == null) {
          NetworkSecurityGrpc.getGetClientTlsPolicyMethod = getGetClientTlsPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest, com.google.cloud.networksecurity.v1.ClientTlsPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetClientTlsPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.ClientTlsPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("GetClientTlsPolicy"))
              .build();
        }
      }
    }
    return getGetClientTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest,
      com.google.longrunning.Operation> getCreateClientTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateClientTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest,
      com.google.longrunning.Operation> getCreateClientTlsPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest, com.google.longrunning.Operation> getCreateClientTlsPolicyMethod;
    if ((getCreateClientTlsPolicyMethod = NetworkSecurityGrpc.getCreateClientTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getCreateClientTlsPolicyMethod = NetworkSecurityGrpc.getCreateClientTlsPolicyMethod) == null) {
          NetworkSecurityGrpc.getCreateClientTlsPolicyMethod = getCreateClientTlsPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateClientTlsPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("CreateClientTlsPolicy"))
              .build();
        }
      }
    }
    return getCreateClientTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest,
      com.google.longrunning.Operation> getUpdateClientTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateClientTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest,
      com.google.longrunning.Operation> getUpdateClientTlsPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest, com.google.longrunning.Operation> getUpdateClientTlsPolicyMethod;
    if ((getUpdateClientTlsPolicyMethod = NetworkSecurityGrpc.getUpdateClientTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getUpdateClientTlsPolicyMethod = NetworkSecurityGrpc.getUpdateClientTlsPolicyMethod) == null) {
          NetworkSecurityGrpc.getUpdateClientTlsPolicyMethod = getUpdateClientTlsPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateClientTlsPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("UpdateClientTlsPolicy"))
              .build();
        }
      }
    }
    return getUpdateClientTlsPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest,
      com.google.longrunning.Operation> getDeleteClientTlsPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteClientTlsPolicy",
      requestType = com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest,
      com.google.longrunning.Operation> getDeleteClientTlsPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest, com.google.longrunning.Operation> getDeleteClientTlsPolicyMethod;
    if ((getDeleteClientTlsPolicyMethod = NetworkSecurityGrpc.getDeleteClientTlsPolicyMethod) == null) {
      synchronized (NetworkSecurityGrpc.class) {
        if ((getDeleteClientTlsPolicyMethod = NetworkSecurityGrpc.getDeleteClientTlsPolicyMethod) == null) {
          NetworkSecurityGrpc.getDeleteClientTlsPolicyMethod = getDeleteClientTlsPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteClientTlsPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new NetworkSecurityMethodDescriptorSupplier("DeleteClientTlsPolicy"))
              .build();
        }
      }
    }
    return getDeleteClientTlsPolicyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NetworkSecurityStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityStub>() {
        @java.lang.Override
        public NetworkSecurityStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NetworkSecurityStub(channel, callOptions);
        }
      };
    return NetworkSecurityStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NetworkSecurityBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityBlockingStub>() {
        @java.lang.Override
        public NetworkSecurityBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NetworkSecurityBlockingStub(channel, callOptions);
        }
      };
    return NetworkSecurityBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NetworkSecurityFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NetworkSecurityFutureStub>() {
        @java.lang.Override
        public NetworkSecurityFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NetworkSecurityFutureStub(channel, callOptions);
        }
      };
    return NetworkSecurityFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public static abstract class NetworkSecurityImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    public void listAuthorizationPolicies(com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAuthorizationPoliciesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    public void getAuthorizationPolicy(com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthorizationPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAuthorizationPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    public void createAuthorizationPolicy(com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAuthorizationPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    public void updateAuthorizationPolicy(com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAuthorizationPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    public void deleteAuthorizationPolicy(com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAuthorizationPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    public void listServerTlsPolicies(com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServerTlsPoliciesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    public void getServerTlsPolicy(com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ServerTlsPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServerTlsPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    public void createServerTlsPolicy(com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServerTlsPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    public void updateServerTlsPolicy(com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateServerTlsPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    public void deleteServerTlsPolicy(com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteServerTlsPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    public void listClientTlsPolicies(com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListClientTlsPoliciesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    public void getClientTlsPolicy(com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ClientTlsPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClientTlsPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    public void createClientTlsPolicy(com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateClientTlsPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    public void updateClientTlsPolicy(com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateClientTlsPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    public void deleteClientTlsPolicy(com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteClientTlsPolicyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAuthorizationPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest,
                com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>(
                  this, METHODID_LIST_AUTHORIZATION_POLICIES)))
          .addMethod(
            getGetAuthorizationPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest,
                com.google.cloud.networksecurity.v1.AuthorizationPolicy>(
                  this, METHODID_GET_AUTHORIZATION_POLICY)))
          .addMethod(
            getCreateAuthorizationPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_AUTHORIZATION_POLICY)))
          .addMethod(
            getUpdateAuthorizationPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_AUTHORIZATION_POLICY)))
          .addMethod(
            getDeleteAuthorizationPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_AUTHORIZATION_POLICY)))
          .addMethod(
            getListServerTlsPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest,
                com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>(
                  this, METHODID_LIST_SERVER_TLS_POLICIES)))
          .addMethod(
            getGetServerTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest,
                com.google.cloud.networksecurity.v1.ServerTlsPolicy>(
                  this, METHODID_GET_SERVER_TLS_POLICY)))
          .addMethod(
            getCreateServerTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_SERVER_TLS_POLICY)))
          .addMethod(
            getUpdateServerTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_SERVER_TLS_POLICY)))
          .addMethod(
            getDeleteServerTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_SERVER_TLS_POLICY)))
          .addMethod(
            getListClientTlsPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest,
                com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>(
                  this, METHODID_LIST_CLIENT_TLS_POLICIES)))
          .addMethod(
            getGetClientTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest,
                com.google.cloud.networksecurity.v1.ClientTlsPolicy>(
                  this, METHODID_GET_CLIENT_TLS_POLICY)))
          .addMethod(
            getCreateClientTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CLIENT_TLS_POLICY)))
          .addMethod(
            getUpdateClientTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CLIENT_TLS_POLICY)))
          .addMethod(
            getDeleteClientTlsPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CLIENT_TLS_POLICY)))
          .build();
    }
  }

  /**
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public static final class NetworkSecurityStub extends io.grpc.stub.AbstractAsyncStub<NetworkSecurityStub> {
    private NetworkSecurityStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkSecurityStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkSecurityStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    public void listAuthorizationPolicies(com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuthorizationPoliciesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    public void getAuthorizationPolicy(com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthorizationPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthorizationPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    public void createAuthorizationPolicy(com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAuthorizationPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    public void updateAuthorizationPolicy(com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAuthorizationPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    public void deleteAuthorizationPolicy(com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAuthorizationPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    public void listServerTlsPolicies(com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServerTlsPoliciesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    public void getServerTlsPolicy(com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ServerTlsPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServerTlsPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    public void createServerTlsPolicy(com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServerTlsPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    public void updateServerTlsPolicy(com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServerTlsPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    public void deleteServerTlsPolicy(com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServerTlsPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    public void listClientTlsPolicies(com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClientTlsPoliciesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    public void getClientTlsPolicy(com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ClientTlsPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClientTlsPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    public void createClientTlsPolicy(com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClientTlsPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    public void updateClientTlsPolicy(com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClientTlsPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    public void deleteClientTlsPolicy(com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClientTlsPolicyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public static final class NetworkSecurityBlockingStub extends io.grpc.stub.AbstractBlockingStub<NetworkSecurityBlockingStub> {
    private NetworkSecurityBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkSecurityBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkSecurityBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse listAuthorizationPolicies(com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuthorizationPoliciesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.AuthorizationPolicy getAuthorizationPolicy(com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAuthorizationPolicy(com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAuthorizationPolicy(com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAuthorizationPolicy(com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAuthorizationPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse listServerTlsPolicies(com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServerTlsPoliciesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ServerTlsPolicy getServerTlsPolicy(com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createServerTlsPolicy(com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateServerTlsPolicy(com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServerTlsPolicy(com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServerTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse listClientTlsPolicies(com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClientTlsPoliciesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ClientTlsPolicy getClientTlsPolicy(com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createClientTlsPolicy(com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateClientTlsPolicy(com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClientTlsPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteClientTlsPolicy(com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClientTlsPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Network Security API provides resources to configure authentication and
   * authorization policies. Refer to per API resource documentation for more
   * information.
   * </pre>
   */
  public static final class NetworkSecurityFutureStub extends io.grpc.stub.AbstractFutureStub<NetworkSecurityFutureStub> {
    private NetworkSecurityFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkSecurityFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkSecurityFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists AuthorizationPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse> listAuthorizationPolicies(
        com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuthorizationPoliciesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.networksecurity.v1.AuthorizationPolicy> getAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthorizationPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new AuthorizationPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAuthorizationPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAuthorizationPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single AuthorizationPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAuthorizationPolicy(
        com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAuthorizationPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists ServerTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse> listServerTlsPolicies(
        com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServerTlsPoliciesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.networksecurity.v1.ServerTlsPolicy> getServerTlsPolicy(
        com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServerTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new ServerTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createServerTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServerTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateServerTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServerTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single ServerTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteServerTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServerTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists ClientTlsPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse> listClientTlsPolicies(
        com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClientTlsPoliciesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.networksecurity.v1.ClientTlsPolicy> getClientTlsPolicy(
        com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClientTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new ClientTlsPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createClientTlsPolicy(
        com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClientTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateClientTlsPolicy(
        com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClientTlsPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single ClientTlsPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteClientTlsPolicy(
        com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClientTlsPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AUTHORIZATION_POLICIES = 0;
  private static final int METHODID_GET_AUTHORIZATION_POLICY = 1;
  private static final int METHODID_CREATE_AUTHORIZATION_POLICY = 2;
  private static final int METHODID_UPDATE_AUTHORIZATION_POLICY = 3;
  private static final int METHODID_DELETE_AUTHORIZATION_POLICY = 4;
  private static final int METHODID_LIST_SERVER_TLS_POLICIES = 5;
  private static final int METHODID_GET_SERVER_TLS_POLICY = 6;
  private static final int METHODID_CREATE_SERVER_TLS_POLICY = 7;
  private static final int METHODID_UPDATE_SERVER_TLS_POLICY = 8;
  private static final int METHODID_DELETE_SERVER_TLS_POLICY = 9;
  private static final int METHODID_LIST_CLIENT_TLS_POLICIES = 10;
  private static final int METHODID_GET_CLIENT_TLS_POLICY = 11;
  private static final int METHODID_CREATE_CLIENT_TLS_POLICY = 12;
  private static final int METHODID_UPDATE_CLIENT_TLS_POLICY = 13;
  private static final int METHODID_DELETE_CLIENT_TLS_POLICY = 14;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NetworkSecurityImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NetworkSecurityImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_AUTHORIZATION_POLICIES:
          serviceImpl.listAuthorizationPolicies((com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse>) responseObserver);
          break;
        case METHODID_GET_AUTHORIZATION_POLICY:
          serviceImpl.getAuthorizationPolicy((com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AuthorizationPolicy>) responseObserver);
          break;
        case METHODID_CREATE_AUTHORIZATION_POLICY:
          serviceImpl.createAuthorizationPolicy((com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_AUTHORIZATION_POLICY:
          serviceImpl.updateAuthorizationPolicy((com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_AUTHORIZATION_POLICY:
          serviceImpl.deleteAuthorizationPolicy((com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERVER_TLS_POLICIES:
          serviceImpl.listServerTlsPolicies((com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse>) responseObserver);
          break;
        case METHODID_GET_SERVER_TLS_POLICY:
          serviceImpl.getServerTlsPolicy((com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ServerTlsPolicy>) responseObserver);
          break;
        case METHODID_CREATE_SERVER_TLS_POLICY:
          serviceImpl.createServerTlsPolicy((com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SERVER_TLS_POLICY:
          serviceImpl.updateServerTlsPolicy((com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVER_TLS_POLICY:
          serviceImpl.deleteServerTlsPolicy((com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CLIENT_TLS_POLICIES:
          serviceImpl.listClientTlsPolicies((com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse>) responseObserver);
          break;
        case METHODID_GET_CLIENT_TLS_POLICY:
          serviceImpl.getClientTlsPolicy((com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ClientTlsPolicy>) responseObserver);
          break;
        case METHODID_CREATE_CLIENT_TLS_POLICY:
          serviceImpl.createClientTlsPolicy((com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLIENT_TLS_POLICY:
          serviceImpl.updateClientTlsPolicy((com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLIENT_TLS_POLICY:
          serviceImpl.deleteClientTlsPolicy((com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest) request,
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

  private static abstract class NetworkSecurityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NetworkSecurityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1.NetworkSecurityOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NetworkSecurity");
    }
  }

  private static final class NetworkSecurityFileDescriptorSupplier
      extends NetworkSecurityBaseDescriptorSupplier {
    NetworkSecurityFileDescriptorSupplier() {}
  }

  private static final class NetworkSecurityMethodDescriptorSupplier
      extends NetworkSecurityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NetworkSecurityMethodDescriptorSupplier(String methodName) {
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
      synchronized (NetworkSecurityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NetworkSecurityFileDescriptorSupplier())
              .addMethod(getListAuthorizationPoliciesMethod())
              .addMethod(getGetAuthorizationPolicyMethod())
              .addMethod(getCreateAuthorizationPolicyMethod())
              .addMethod(getUpdateAuthorizationPolicyMethod())
              .addMethod(getDeleteAuthorizationPolicyMethod())
              .addMethod(getListServerTlsPoliciesMethod())
              .addMethod(getGetServerTlsPolicyMethod())
              .addMethod(getCreateServerTlsPolicyMethod())
              .addMethod(getUpdateServerTlsPolicyMethod())
              .addMethod(getDeleteServerTlsPolicyMethod())
              .addMethod(getListClientTlsPoliciesMethod())
              .addMethod(getGetClientTlsPolicyMethod())
              .addMethod(getCreateClientTlsPolicyMethod())
              .addMethod(getUpdateClientTlsPolicyMethod())
              .addMethod(getDeleteClientTlsPolicyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
