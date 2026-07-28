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
package com.google.iam.v3beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages Identity and Access Management (IAM) access policies.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AccessPoliciesGrpc {

  private AccessPoliciesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.iam.v3beta.AccessPolicies";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.CreateAccessPolicyRequest, com.google.longrunning.Operation>
      getCreateAccessPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccessPolicy",
      requestType = com.google.iam.v3beta.CreateAccessPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.CreateAccessPolicyRequest, com.google.longrunning.Operation>
      getCreateAccessPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.CreateAccessPolicyRequest, com.google.longrunning.Operation>
        getCreateAccessPolicyMethod;
    if ((getCreateAccessPolicyMethod = AccessPoliciesGrpc.getCreateAccessPolicyMethod) == null) {
      synchronized (AccessPoliciesGrpc.class) {
        if ((getCreateAccessPolicyMethod = AccessPoliciesGrpc.getCreateAccessPolicyMethod)
            == null) {
          AccessPoliciesGrpc.getCreateAccessPolicyMethod =
              getCreateAccessPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.CreateAccessPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccessPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.CreateAccessPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccessPoliciesMethodDescriptorSupplier("CreateAccessPolicy"))
                      .build();
        }
      }
    }
    return getCreateAccessPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.GetAccessPolicyRequest, com.google.iam.v3beta.AccessPolicy>
      getGetAccessPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccessPolicy",
      requestType = com.google.iam.v3beta.GetAccessPolicyRequest.class,
      responseType = com.google.iam.v3beta.AccessPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.GetAccessPolicyRequest, com.google.iam.v3beta.AccessPolicy>
      getGetAccessPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.GetAccessPolicyRequest, com.google.iam.v3beta.AccessPolicy>
        getGetAccessPolicyMethod;
    if ((getGetAccessPolicyMethod = AccessPoliciesGrpc.getGetAccessPolicyMethod) == null) {
      synchronized (AccessPoliciesGrpc.class) {
        if ((getGetAccessPolicyMethod = AccessPoliciesGrpc.getGetAccessPolicyMethod) == null) {
          AccessPoliciesGrpc.getGetAccessPolicyMethod =
              getGetAccessPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.GetAccessPolicyRequest,
                          com.google.iam.v3beta.AccessPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccessPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.GetAccessPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.AccessPolicy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccessPoliciesMethodDescriptorSupplier("GetAccessPolicy"))
                      .build();
        }
      }
    }
    return getGetAccessPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.UpdateAccessPolicyRequest, com.google.longrunning.Operation>
      getUpdateAccessPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccessPolicy",
      requestType = com.google.iam.v3beta.UpdateAccessPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.UpdateAccessPolicyRequest, com.google.longrunning.Operation>
      getUpdateAccessPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.UpdateAccessPolicyRequest, com.google.longrunning.Operation>
        getUpdateAccessPolicyMethod;
    if ((getUpdateAccessPolicyMethod = AccessPoliciesGrpc.getUpdateAccessPolicyMethod) == null) {
      synchronized (AccessPoliciesGrpc.class) {
        if ((getUpdateAccessPolicyMethod = AccessPoliciesGrpc.getUpdateAccessPolicyMethod)
            == null) {
          AccessPoliciesGrpc.getUpdateAccessPolicyMethod =
              getUpdateAccessPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.UpdateAccessPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccessPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.UpdateAccessPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccessPoliciesMethodDescriptorSupplier("UpdateAccessPolicy"))
                      .build();
        }
      }
    }
    return getUpdateAccessPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.DeleteAccessPolicyRequest, com.google.longrunning.Operation>
      getDeleteAccessPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccessPolicy",
      requestType = com.google.iam.v3beta.DeleteAccessPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.DeleteAccessPolicyRequest, com.google.longrunning.Operation>
      getDeleteAccessPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.DeleteAccessPolicyRequest, com.google.longrunning.Operation>
        getDeleteAccessPolicyMethod;
    if ((getDeleteAccessPolicyMethod = AccessPoliciesGrpc.getDeleteAccessPolicyMethod) == null) {
      synchronized (AccessPoliciesGrpc.class) {
        if ((getDeleteAccessPolicyMethod = AccessPoliciesGrpc.getDeleteAccessPolicyMethod)
            == null) {
          AccessPoliciesGrpc.getDeleteAccessPolicyMethod =
              getDeleteAccessPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.DeleteAccessPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccessPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.DeleteAccessPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccessPoliciesMethodDescriptorSupplier("DeleteAccessPolicy"))
                      .build();
        }
      }
    }
    return getDeleteAccessPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.ListAccessPoliciesRequest,
          com.google.iam.v3beta.ListAccessPoliciesResponse>
      getListAccessPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccessPolicies",
      requestType = com.google.iam.v3beta.ListAccessPoliciesRequest.class,
      responseType = com.google.iam.v3beta.ListAccessPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.ListAccessPoliciesRequest,
          com.google.iam.v3beta.ListAccessPoliciesResponse>
      getListAccessPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.ListAccessPoliciesRequest,
            com.google.iam.v3beta.ListAccessPoliciesResponse>
        getListAccessPoliciesMethod;
    if ((getListAccessPoliciesMethod = AccessPoliciesGrpc.getListAccessPoliciesMethod) == null) {
      synchronized (AccessPoliciesGrpc.class) {
        if ((getListAccessPoliciesMethod = AccessPoliciesGrpc.getListAccessPoliciesMethod)
            == null) {
          AccessPoliciesGrpc.getListAccessPoliciesMethod =
              getListAccessPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.ListAccessPoliciesRequest,
                          com.google.iam.v3beta.ListAccessPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccessPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.ListAccessPoliciesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.ListAccessPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccessPoliciesMethodDescriptorSupplier("ListAccessPolicies"))
                      .build();
        }
      }
    }
    return getListAccessPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.SearchAccessPolicyBindingsRequest,
          com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>
      getSearchAccessPolicyBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAccessPolicyBindings",
      requestType = com.google.iam.v3beta.SearchAccessPolicyBindingsRequest.class,
      responseType = com.google.iam.v3beta.SearchAccessPolicyBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.SearchAccessPolicyBindingsRequest,
          com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>
      getSearchAccessPolicyBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.SearchAccessPolicyBindingsRequest,
            com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>
        getSearchAccessPolicyBindingsMethod;
    if ((getSearchAccessPolicyBindingsMethod =
            AccessPoliciesGrpc.getSearchAccessPolicyBindingsMethod)
        == null) {
      synchronized (AccessPoliciesGrpc.class) {
        if ((getSearchAccessPolicyBindingsMethod =
                AccessPoliciesGrpc.getSearchAccessPolicyBindingsMethod)
            == null) {
          AccessPoliciesGrpc.getSearchAccessPolicyBindingsMethod =
              getSearchAccessPolicyBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.SearchAccessPolicyBindingsRequest,
                          com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchAccessPolicyBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.SearchAccessPolicyBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.SearchAccessPolicyBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AccessPoliciesMethodDescriptorSupplier("SearchAccessPolicyBindings"))
                      .build();
        }
      }
    }
    return getSearchAccessPolicyBindingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AccessPoliciesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessPoliciesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccessPoliciesStub>() {
          @java.lang.Override
          public AccessPoliciesStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccessPoliciesStub(channel, callOptions);
          }
        };
    return AccessPoliciesStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AccessPoliciesBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessPoliciesBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccessPoliciesBlockingV2Stub>() {
          @java.lang.Override
          public AccessPoliciesBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccessPoliciesBlockingV2Stub(channel, callOptions);
          }
        };
    return AccessPoliciesBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccessPoliciesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessPoliciesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccessPoliciesBlockingStub>() {
          @java.lang.Override
          public AccessPoliciesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccessPoliciesBlockingStub(channel, callOptions);
          }
        };
    return AccessPoliciesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AccessPoliciesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessPoliciesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AccessPoliciesFutureStub>() {
          @java.lang.Override
          public AccessPoliciesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AccessPoliciesFutureStub(channel, callOptions);
          }
        };
    return AccessPoliciesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages Identity and Access Management (IAM) access policies.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates an access policy, and returns a long running operation.
     * </pre>
     */
    default void createAccessPolicy(
        com.google.iam.v3beta.CreateAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAccessPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an access policy.
     * </pre>
     */
    default void getAccessPolicy(
        com.google.iam.v3beta.GetAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3beta.AccessPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAccessPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an access policy.
     * </pre>
     */
    default void updateAccessPolicy(
        com.google.iam.v3beta.UpdateAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAccessPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access policy.
     * </pre>
     */
    default void deleteAccessPolicy(
        com.google.iam.v3beta.DeleteAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAccessPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists access policies.
     * </pre>
     */
    default void listAccessPolicies(
        com.google.iam.v3beta.ListAccessPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3beta.ListAccessPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAccessPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all policy bindings that bind a specific policy if a user has
     * searchPolicyBindings permission on that policy.
     * </pre>
     */
    default void searchAccessPolicyBindings(
        com.google.iam.v3beta.SearchAccessPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchAccessPolicyBindingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccessPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) access policies.
   * </pre>
   */
  public abstract static class AccessPoliciesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AccessPoliciesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccessPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) access policies.
   * </pre>
   */
  public static final class AccessPoliciesStub
      extends io.grpc.stub.AbstractAsyncStub<AccessPoliciesStub> {
    private AccessPoliciesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessPoliciesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessPoliciesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an access policy, and returns a long running operation.
     * </pre>
     */
    public void createAccessPolicy(
        com.google.iam.v3beta.CreateAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccessPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an access policy.
     * </pre>
     */
    public void getAccessPolicy(
        com.google.iam.v3beta.GetAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3beta.AccessPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccessPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an access policy.
     * </pre>
     */
    public void updateAccessPolicy(
        com.google.iam.v3beta.UpdateAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccessPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access policy.
     * </pre>
     */
    public void deleteAccessPolicy(
        com.google.iam.v3beta.DeleteAccessPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccessPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists access policies.
     * </pre>
     */
    public void listAccessPolicies(
        com.google.iam.v3beta.ListAccessPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3beta.ListAccessPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccessPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all policy bindings that bind a specific policy if a user has
     * searchPolicyBindings permission on that policy.
     * </pre>
     */
    public void searchAccessPolicyBindings(
        com.google.iam.v3beta.SearchAccessPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAccessPolicyBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccessPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) access policies.
   * </pre>
   */
  public static final class AccessPoliciesBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AccessPoliciesBlockingV2Stub> {
    private AccessPoliciesBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessPoliciesBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessPoliciesBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an access policy, and returns a long running operation.
     * </pre>
     */
    public com.google.longrunning.Operation createAccessPolicy(
        com.google.iam.v3beta.CreateAccessPolicyRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an access policy.
     * </pre>
     */
    public com.google.iam.v3beta.AccessPolicy getAccessPolicy(
        com.google.iam.v3beta.GetAccessPolicyRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an access policy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAccessPolicy(
        com.google.iam.v3beta.UpdateAccessPolicyRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access policy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAccessPolicy(
        com.google.iam.v3beta.DeleteAccessPolicyRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists access policies.
     * </pre>
     */
    public com.google.iam.v3beta.ListAccessPoliciesResponse listAccessPolicies(
        com.google.iam.v3beta.ListAccessPoliciesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAccessPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all policy bindings that bind a specific policy if a user has
     * searchPolicyBindings permission on that policy.
     * </pre>
     */
    public com.google.iam.v3beta.SearchAccessPolicyBindingsResponse searchAccessPolicyBindings(
        com.google.iam.v3beta.SearchAccessPolicyBindingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchAccessPolicyBindingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AccessPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) access policies.
   * </pre>
   */
  public static final class AccessPoliciesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccessPoliciesBlockingStub> {
    private AccessPoliciesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessPoliciesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessPoliciesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an access policy, and returns a long running operation.
     * </pre>
     */
    public com.google.longrunning.Operation createAccessPolicy(
        com.google.iam.v3beta.CreateAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an access policy.
     * </pre>
     */
    public com.google.iam.v3beta.AccessPolicy getAccessPolicy(
        com.google.iam.v3beta.GetAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an access policy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAccessPolicy(
        com.google.iam.v3beta.UpdateAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access policy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAccessPolicy(
        com.google.iam.v3beta.DeleteAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccessPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists access policies.
     * </pre>
     */
    public com.google.iam.v3beta.ListAccessPoliciesResponse listAccessPolicies(
        com.google.iam.v3beta.ListAccessPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccessPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all policy bindings that bind a specific policy if a user has
     * searchPolicyBindings permission on that policy.
     * </pre>
     */
    public com.google.iam.v3beta.SearchAccessPolicyBindingsResponse searchAccessPolicyBindings(
        com.google.iam.v3beta.SearchAccessPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAccessPolicyBindingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccessPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) access policies.
   * </pre>
   */
  public static final class AccessPoliciesFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccessPoliciesFutureStub> {
    private AccessPoliciesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessPoliciesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessPoliciesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an access policy, and returns a long running operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAccessPolicy(com.google.iam.v3beta.CreateAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccessPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an access policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v3beta.AccessPolicy>
        getAccessPolicy(com.google.iam.v3beta.GetAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccessPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an access policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAccessPolicy(com.google.iam.v3beta.UpdateAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccessPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an access policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAccessPolicy(com.google.iam.v3beta.DeleteAccessPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccessPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists access policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v3beta.ListAccessPoliciesResponse>
        listAccessPolicies(com.google.iam.v3beta.ListAccessPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccessPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all policy bindings that bind a specific policy if a user has
     * searchPolicyBindings permission on that policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>
        searchAccessPolicyBindings(
            com.google.iam.v3beta.SearchAccessPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAccessPolicyBindingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ACCESS_POLICY = 0;
  private static final int METHODID_GET_ACCESS_POLICY = 1;
  private static final int METHODID_UPDATE_ACCESS_POLICY = 2;
  private static final int METHODID_DELETE_ACCESS_POLICY = 3;
  private static final int METHODID_LIST_ACCESS_POLICIES = 4;
  private static final int METHODID_SEARCH_ACCESS_POLICY_BINDINGS = 5;

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
        case METHODID_CREATE_ACCESS_POLICY:
          serviceImpl.createAccessPolicy(
              (com.google.iam.v3beta.CreateAccessPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ACCESS_POLICY:
          serviceImpl.getAccessPolicy(
              (com.google.iam.v3beta.GetAccessPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v3beta.AccessPolicy>) responseObserver);
          break;
        case METHODID_UPDATE_ACCESS_POLICY:
          serviceImpl.updateAccessPolicy(
              (com.google.iam.v3beta.UpdateAccessPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ACCESS_POLICY:
          serviceImpl.deleteAccessPolicy(
              (com.google.iam.v3beta.DeleteAccessPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ACCESS_POLICIES:
          serviceImpl.listAccessPolicies(
              (com.google.iam.v3beta.ListAccessPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v3beta.ListAccessPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_ACCESS_POLICY_BINDINGS:
          serviceImpl.searchAccessPolicyBindings(
              (com.google.iam.v3beta.SearchAccessPolicyBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>)
                  responseObserver);
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
            getCreateAccessPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.CreateAccessPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ACCESS_POLICY)))
        .addMethod(
            getGetAccessPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.GetAccessPolicyRequest,
                    com.google.iam.v3beta.AccessPolicy>(service, METHODID_GET_ACCESS_POLICY)))
        .addMethod(
            getUpdateAccessPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.UpdateAccessPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ACCESS_POLICY)))
        .addMethod(
            getDeleteAccessPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.DeleteAccessPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ACCESS_POLICY)))
        .addMethod(
            getListAccessPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.ListAccessPoliciesRequest,
                    com.google.iam.v3beta.ListAccessPoliciesResponse>(
                    service, METHODID_LIST_ACCESS_POLICIES)))
        .addMethod(
            getSearchAccessPolicyBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.SearchAccessPolicyBindingsRequest,
                    com.google.iam.v3beta.SearchAccessPolicyBindingsResponse>(
                    service, METHODID_SEARCH_ACCESS_POLICY_BINDINGS)))
        .build();
  }

  private abstract static class AccessPoliciesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccessPoliciesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.iam.v3beta.AccessPoliciesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccessPolicies");
    }
  }

  private static final class AccessPoliciesFileDescriptorSupplier
      extends AccessPoliciesBaseDescriptorSupplier {
    AccessPoliciesFileDescriptorSupplier() {}
  }

  private static final class AccessPoliciesMethodDescriptorSupplier
      extends AccessPoliciesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccessPoliciesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccessPoliciesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AccessPoliciesFileDescriptorSupplier())
                      .addMethod(getCreateAccessPolicyMethod())
                      .addMethod(getGetAccessPolicyMethod())
                      .addMethod(getUpdateAccessPolicyMethod())
                      .addMethod(getDeleteAccessPolicyMethod())
                      .addMethod(getListAccessPoliciesMethod())
                      .addMethod(getSearchAccessPolicyBindingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
