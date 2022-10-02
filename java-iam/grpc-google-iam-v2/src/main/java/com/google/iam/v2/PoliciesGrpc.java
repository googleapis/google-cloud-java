/*
 * Copyright 2020 Google LLC
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
package com.google.iam.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * An interface for managing Identity and Access Management (IAM) policies.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/iam/v2/policy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PoliciesGrpc {

  private PoliciesGrpc() {}

  public static final String SERVICE_NAME = "google.iam.v2.Policies";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v2.ListPoliciesRequest, com.google.iam.v2.ListPoliciesResponse>
      getListPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPolicies",
      requestType = com.google.iam.v2.ListPoliciesRequest.class,
      responseType = com.google.iam.v2.ListPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v2.ListPoliciesRequest, com.google.iam.v2.ListPoliciesResponse>
      getListPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v2.ListPoliciesRequest, com.google.iam.v2.ListPoliciesResponse>
        getListPoliciesMethod;
    if ((getListPoliciesMethod = PoliciesGrpc.getListPoliciesMethod) == null) {
      synchronized (PoliciesGrpc.class) {
        if ((getListPoliciesMethod = PoliciesGrpc.getListPoliciesMethod) == null) {
          PoliciesGrpc.getListPoliciesMethod =
              getListPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v2.ListPoliciesRequest,
                          com.google.iam.v2.ListPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v2.ListPoliciesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v2.ListPoliciesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new PoliciesMethodDescriptorSupplier("ListPolicies"))
                      .build();
        }
      }
    }
    return getListPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v2.GetPolicyRequest, com.google.iam.v2.Policy>
      getGetPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPolicy",
      requestType = com.google.iam.v2.GetPolicyRequest.class,
      responseType = com.google.iam.v2.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v2.GetPolicyRequest, com.google.iam.v2.Policy>
      getGetPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v2.GetPolicyRequest, com.google.iam.v2.Policy>
        getGetPolicyMethod;
    if ((getGetPolicyMethod = PoliciesGrpc.getGetPolicyMethod) == null) {
      synchronized (PoliciesGrpc.class) {
        if ((getGetPolicyMethod = PoliciesGrpc.getGetPolicyMethod) == null) {
          PoliciesGrpc.getGetPolicyMethod =
              getGetPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v2.GetPolicyRequest, com.google.iam.v2.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v2.GetPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v2.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new PoliciesMethodDescriptorSupplier("GetPolicy"))
                      .build();
        }
      }
    }
    return getGetPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v2.CreatePolicyRequest, com.google.longrunning.Operation>
      getCreatePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePolicy",
      requestType = com.google.iam.v2.CreatePolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v2.CreatePolicyRequest, com.google.longrunning.Operation>
      getCreatePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v2.CreatePolicyRequest, com.google.longrunning.Operation>
        getCreatePolicyMethod;
    if ((getCreatePolicyMethod = PoliciesGrpc.getCreatePolicyMethod) == null) {
      synchronized (PoliciesGrpc.class) {
        if ((getCreatePolicyMethod = PoliciesGrpc.getCreatePolicyMethod) == null) {
          PoliciesGrpc.getCreatePolicyMethod =
              getCreatePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v2.CreatePolicyRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v2.CreatePolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new PoliciesMethodDescriptorSupplier("CreatePolicy"))
                      .build();
        }
      }
    }
    return getCreatePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v2.UpdatePolicyRequest, com.google.longrunning.Operation>
      getUpdatePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePolicy",
      requestType = com.google.iam.v2.UpdatePolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v2.UpdatePolicyRequest, com.google.longrunning.Operation>
      getUpdatePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v2.UpdatePolicyRequest, com.google.longrunning.Operation>
        getUpdatePolicyMethod;
    if ((getUpdatePolicyMethod = PoliciesGrpc.getUpdatePolicyMethod) == null) {
      synchronized (PoliciesGrpc.class) {
        if ((getUpdatePolicyMethod = PoliciesGrpc.getUpdatePolicyMethod) == null) {
          PoliciesGrpc.getUpdatePolicyMethod =
              getUpdatePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v2.UpdatePolicyRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v2.UpdatePolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new PoliciesMethodDescriptorSupplier("UpdatePolicy"))
                      .build();
        }
      }
    }
    return getUpdatePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v2.DeletePolicyRequest, com.google.longrunning.Operation>
      getDeletePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePolicy",
      requestType = com.google.iam.v2.DeletePolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v2.DeletePolicyRequest, com.google.longrunning.Operation>
      getDeletePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v2.DeletePolicyRequest, com.google.longrunning.Operation>
        getDeletePolicyMethod;
    if ((getDeletePolicyMethod = PoliciesGrpc.getDeletePolicyMethod) == null) {
      synchronized (PoliciesGrpc.class) {
        if ((getDeletePolicyMethod = PoliciesGrpc.getDeletePolicyMethod) == null) {
          PoliciesGrpc.getDeletePolicyMethod =
              getDeletePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v2.DeletePolicyRequest, com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v2.DeletePolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new PoliciesMethodDescriptorSupplier("DeletePolicy"))
                      .build();
        }
      }
    }
    return getDeletePolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PoliciesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PoliciesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PoliciesStub>() {
          @java.lang.Override
          public PoliciesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PoliciesStub(channel, callOptions);
          }
        };
    return PoliciesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PoliciesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PoliciesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PoliciesBlockingStub>() {
          @java.lang.Override
          public PoliciesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PoliciesBlockingStub(channel, callOptions);
          }
        };
    return PoliciesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PoliciesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PoliciesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PoliciesFutureStub>() {
          @java.lang.Override
          public PoliciesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PoliciesFutureStub(channel, callOptions);
          }
        };
    return PoliciesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policies.
   * </pre>
   */
  public abstract static class PoliciesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Retrieves the policies of the specified kind that are attached to a
     * resource.
     * The response lists only policy metadata. In particular, policy rules are
     * omitted.
     * </pre>
     */
    public void listPolicies(
        com.google.iam.v2.ListPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v2.ListPoliciesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy.
     * </pre>
     */
    public void getPolicy(
        com.google.iam.v2.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v2.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy.
     * </pre>
     */
    public void createPolicy(
        com.google.iam.v2.CreatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified policy.
     * You can update only the rules and the display name for the policy.
     * To update a policy, you should use a read-modify-write loop:
     * 1. Use [GetPolicy][google.iam.v2.Policies.GetPolicy] to read the current version of the policy.
     * 2. Modify the policy as needed.
     * 3. Use `UpdatePolicy` to write the updated policy.
     * This pattern helps prevent conflicts between concurrent updates.
     * </pre>
     */
    public void updatePolicy(
        com.google.iam.v2.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy. This action is permanent.
     * </pre>
     */
    public void deletePolicy(
        com.google.iam.v2.DeletePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePolicyMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListPoliciesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v2.ListPoliciesRequest,
                      com.google.iam.v2.ListPoliciesResponse>(this, METHODID_LIST_POLICIES)))
          .addMethod(
              getGetPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<com.google.iam.v2.GetPolicyRequest, com.google.iam.v2.Policy>(
                      this, METHODID_GET_POLICY)))
          .addMethod(
              getCreatePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v2.CreatePolicyRequest, com.google.longrunning.Operation>(
                      this, METHODID_CREATE_POLICY)))
          .addMethod(
              getUpdatePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v2.UpdatePolicyRequest, com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_POLICY)))
          .addMethod(
              getDeletePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v2.DeletePolicyRequest, com.google.longrunning.Operation>(
                      this, METHODID_DELETE_POLICY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policies.
   * </pre>
   */
  public static final class PoliciesStub extends io.grpc.stub.AbstractAsyncStub<PoliciesStub> {
    private PoliciesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PoliciesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PoliciesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the policies of the specified kind that are attached to a
     * resource.
     * The response lists only policy metadata. In particular, policy rules are
     * omitted.
     * </pre>
     */
    public void listPolicies(
        com.google.iam.v2.ListPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v2.ListPoliciesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy.
     * </pre>
     */
    public void getPolicy(
        com.google.iam.v2.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v2.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy.
     * </pre>
     */
    public void createPolicy(
        com.google.iam.v2.CreatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified policy.
     * You can update only the rules and the display name for the policy.
     * To update a policy, you should use a read-modify-write loop:
     * 1. Use [GetPolicy][google.iam.v2.Policies.GetPolicy] to read the current version of the policy.
     * 2. Modify the policy as needed.
     * 3. Use `UpdatePolicy` to write the updated policy.
     * This pattern helps prevent conflicts between concurrent updates.
     * </pre>
     */
    public void updatePolicy(
        com.google.iam.v2.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy. This action is permanent.
     * </pre>
     */
    public void deletePolicy(
        com.google.iam.v2.DeletePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policies.
   * </pre>
   */
  public static final class PoliciesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PoliciesBlockingStub> {
    private PoliciesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PoliciesBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PoliciesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the policies of the specified kind that are attached to a
     * resource.
     * The response lists only policy metadata. In particular, policy rules are
     * omitted.
     * </pre>
     */
    public com.google.iam.v2.ListPoliciesResponse listPolicies(
        com.google.iam.v2.ListPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy.
     * </pre>
     */
    public com.google.iam.v2.Policy getPolicy(com.google.iam.v2.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy.
     * </pre>
     */
    public com.google.longrunning.Operation createPolicy(
        com.google.iam.v2.CreatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified policy.
     * You can update only the rules and the display name for the policy.
     * To update a policy, you should use a read-modify-write loop:
     * 1. Use [GetPolicy][google.iam.v2.Policies.GetPolicy] to read the current version of the policy.
     * 2. Modify the policy as needed.
     * 3. Use `UpdatePolicy` to write the updated policy.
     * This pattern helps prevent conflicts between concurrent updates.
     * </pre>
     */
    public com.google.longrunning.Operation updatePolicy(
        com.google.iam.v2.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy. This action is permanent.
     * </pre>
     */
    public com.google.longrunning.Operation deletePolicy(
        com.google.iam.v2.DeletePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policies.
   * </pre>
   */
  public static final class PoliciesFutureStub
      extends io.grpc.stub.AbstractFutureStub<PoliciesFutureStub> {
    private PoliciesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PoliciesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PoliciesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the policies of the specified kind that are attached to a
     * resource.
     * The response lists only policy metadata. In particular, policy rules are
     * omitted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v2.ListPoliciesResponse>
        listPolicies(com.google.iam.v2.ListPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v2.Policy> getPolicy(
        com.google.iam.v2.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPolicy(com.google.iam.v2.CreatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified policy.
     * You can update only the rules and the display name for the policy.
     * To update a policy, you should use a read-modify-write loop:
     * 1. Use [GetPolicy][google.iam.v2.Policies.GetPolicy] to read the current version of the policy.
     * 2. Modify the policy as needed.
     * 3. Use `UpdatePolicy` to write the updated policy.
     * This pattern helps prevent conflicts between concurrent updates.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePolicy(com.google.iam.v2.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy. This action is permanent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePolicy(com.google.iam.v2.DeletePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_POLICIES = 0;
  private static final int METHODID_GET_POLICY = 1;
  private static final int METHODID_CREATE_POLICY = 2;
  private static final int METHODID_UPDATE_POLICY = 3;
  private static final int METHODID_DELETE_POLICY = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PoliciesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PoliciesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_POLICIES:
          serviceImpl.listPolicies(
              (com.google.iam.v2.ListPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v2.ListPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_POLICY:
          serviceImpl.getPolicy(
              (com.google.iam.v2.GetPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v2.Policy>) responseObserver);
          break;
        case METHODID_CREATE_POLICY:
          serviceImpl.createPolicy(
              (com.google.iam.v2.CreatePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_POLICY:
          serviceImpl.updatePolicy(
              (com.google.iam.v2.UpdatePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_POLICY:
          serviceImpl.deletePolicy(
              (com.google.iam.v2.DeletePolicyRequest) request,
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

  private abstract static class PoliciesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PoliciesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.iam.v2.PolicyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Policies");
    }
  }

  private static final class PoliciesFileDescriptorSupplier extends PoliciesBaseDescriptorSupplier {
    PoliciesFileDescriptorSupplier() {}
  }

  private static final class PoliciesMethodDescriptorSupplier extends PoliciesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PoliciesMethodDescriptorSupplier(String methodName) {
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
      synchronized (PoliciesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PoliciesFileDescriptorSupplier())
                      .addMethod(getListPoliciesMethod())
                      .addMethod(getGetPolicyMethod())
                      .addMethod(getCreatePolicyMethod())
                      .addMethod(getUpdatePolicyMethod())
                      .addMethod(getDeletePolicyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
