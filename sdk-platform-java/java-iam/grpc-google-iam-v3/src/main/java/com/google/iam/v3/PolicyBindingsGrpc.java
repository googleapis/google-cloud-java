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
package com.google.iam.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * An interface for managing Identity and Access Management (IAM) policy
 * bindings.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class PolicyBindingsGrpc {

  private PolicyBindingsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.iam.v3.PolicyBindings";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3.CreatePolicyBindingRequest, com.google.longrunning.Operation>
      getCreatePolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePolicyBinding",
      requestType = com.google.iam.v3.CreatePolicyBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3.CreatePolicyBindingRequest, com.google.longrunning.Operation>
      getCreatePolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3.CreatePolicyBindingRequest, com.google.longrunning.Operation>
        getCreatePolicyBindingMethod;
    if ((getCreatePolicyBindingMethod = PolicyBindingsGrpc.getCreatePolicyBindingMethod) == null) {
      synchronized (PolicyBindingsGrpc.class) {
        if ((getCreatePolicyBindingMethod = PolicyBindingsGrpc.getCreatePolicyBindingMethod)
            == null) {
          PolicyBindingsGrpc.getCreatePolicyBindingMethod =
              getCreatePolicyBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3.CreatePolicyBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.CreatePolicyBindingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBindingsMethodDescriptorSupplier("CreatePolicyBinding"))
                      .build();
        }
      }
    }
    return getCreatePolicyBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3.GetPolicyBindingRequest, com.google.iam.v3.PolicyBinding>
      getGetPolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPolicyBinding",
      requestType = com.google.iam.v3.GetPolicyBindingRequest.class,
      responseType = com.google.iam.v3.PolicyBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3.GetPolicyBindingRequest, com.google.iam.v3.PolicyBinding>
      getGetPolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3.GetPolicyBindingRequest, com.google.iam.v3.PolicyBinding>
        getGetPolicyBindingMethod;
    if ((getGetPolicyBindingMethod = PolicyBindingsGrpc.getGetPolicyBindingMethod) == null) {
      synchronized (PolicyBindingsGrpc.class) {
        if ((getGetPolicyBindingMethod = PolicyBindingsGrpc.getGetPolicyBindingMethod) == null) {
          PolicyBindingsGrpc.getGetPolicyBindingMethod =
              getGetPolicyBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3.GetPolicyBindingRequest, com.google.iam.v3.PolicyBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.GetPolicyBindingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.PolicyBinding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBindingsMethodDescriptorSupplier("GetPolicyBinding"))
                      .build();
        }
      }
    }
    return getGetPolicyBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3.UpdatePolicyBindingRequest, com.google.longrunning.Operation>
      getUpdatePolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePolicyBinding",
      requestType = com.google.iam.v3.UpdatePolicyBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3.UpdatePolicyBindingRequest, com.google.longrunning.Operation>
      getUpdatePolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3.UpdatePolicyBindingRequest, com.google.longrunning.Operation>
        getUpdatePolicyBindingMethod;
    if ((getUpdatePolicyBindingMethod = PolicyBindingsGrpc.getUpdatePolicyBindingMethod) == null) {
      synchronized (PolicyBindingsGrpc.class) {
        if ((getUpdatePolicyBindingMethod = PolicyBindingsGrpc.getUpdatePolicyBindingMethod)
            == null) {
          PolicyBindingsGrpc.getUpdatePolicyBindingMethod =
              getUpdatePolicyBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3.UpdatePolicyBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdatePolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.UpdatePolicyBindingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBindingsMethodDescriptorSupplier("UpdatePolicyBinding"))
                      .build();
        }
      }
    }
    return getUpdatePolicyBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3.DeletePolicyBindingRequest, com.google.longrunning.Operation>
      getDeletePolicyBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePolicyBinding",
      requestType = com.google.iam.v3.DeletePolicyBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3.DeletePolicyBindingRequest, com.google.longrunning.Operation>
      getDeletePolicyBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3.DeletePolicyBindingRequest, com.google.longrunning.Operation>
        getDeletePolicyBindingMethod;
    if ((getDeletePolicyBindingMethod = PolicyBindingsGrpc.getDeletePolicyBindingMethod) == null) {
      synchronized (PolicyBindingsGrpc.class) {
        if ((getDeletePolicyBindingMethod = PolicyBindingsGrpc.getDeletePolicyBindingMethod)
            == null) {
          PolicyBindingsGrpc.getDeletePolicyBindingMethod =
              getDeletePolicyBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3.DeletePolicyBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePolicyBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.DeletePolicyBindingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBindingsMethodDescriptorSupplier("DeletePolicyBinding"))
                      .build();
        }
      }
    }
    return getDeletePolicyBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3.ListPolicyBindingsRequest, com.google.iam.v3.ListPolicyBindingsResponse>
      getListPolicyBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPolicyBindings",
      requestType = com.google.iam.v3.ListPolicyBindingsRequest.class,
      responseType = com.google.iam.v3.ListPolicyBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3.ListPolicyBindingsRequest, com.google.iam.v3.ListPolicyBindingsResponse>
      getListPolicyBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3.ListPolicyBindingsRequest,
            com.google.iam.v3.ListPolicyBindingsResponse>
        getListPolicyBindingsMethod;
    if ((getListPolicyBindingsMethod = PolicyBindingsGrpc.getListPolicyBindingsMethod) == null) {
      synchronized (PolicyBindingsGrpc.class) {
        if ((getListPolicyBindingsMethod = PolicyBindingsGrpc.getListPolicyBindingsMethod)
            == null) {
          PolicyBindingsGrpc.getListPolicyBindingsMethod =
              getListPolicyBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3.ListPolicyBindingsRequest,
                          com.google.iam.v3.ListPolicyBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPolicyBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.ListPolicyBindingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.ListPolicyBindingsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBindingsMethodDescriptorSupplier("ListPolicyBindings"))
                      .build();
        }
      }
    }
    return getListPolicyBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3.SearchTargetPolicyBindingsRequest,
          com.google.iam.v3.SearchTargetPolicyBindingsResponse>
      getSearchTargetPolicyBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchTargetPolicyBindings",
      requestType = com.google.iam.v3.SearchTargetPolicyBindingsRequest.class,
      responseType = com.google.iam.v3.SearchTargetPolicyBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3.SearchTargetPolicyBindingsRequest,
          com.google.iam.v3.SearchTargetPolicyBindingsResponse>
      getSearchTargetPolicyBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3.SearchTargetPolicyBindingsRequest,
            com.google.iam.v3.SearchTargetPolicyBindingsResponse>
        getSearchTargetPolicyBindingsMethod;
    if ((getSearchTargetPolicyBindingsMethod =
            PolicyBindingsGrpc.getSearchTargetPolicyBindingsMethod)
        == null) {
      synchronized (PolicyBindingsGrpc.class) {
        if ((getSearchTargetPolicyBindingsMethod =
                PolicyBindingsGrpc.getSearchTargetPolicyBindingsMethod)
            == null) {
          PolicyBindingsGrpc.getSearchTargetPolicyBindingsMethod =
              getSearchTargetPolicyBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3.SearchTargetPolicyBindingsRequest,
                          com.google.iam.v3.SearchTargetPolicyBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchTargetPolicyBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.SearchTargetPolicyBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3.SearchTargetPolicyBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBindingsMethodDescriptorSupplier("SearchTargetPolicyBindings"))
                      .build();
        }
      }
    }
    return getSearchTargetPolicyBindingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PolicyBindingsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyBindingsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PolicyBindingsStub>() {
          @java.lang.Override
          public PolicyBindingsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PolicyBindingsStub(channel, callOptions);
          }
        };
    return PolicyBindingsStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static PolicyBindingsBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyBindingsBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PolicyBindingsBlockingV2Stub>() {
          @java.lang.Override
          public PolicyBindingsBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PolicyBindingsBlockingV2Stub(channel, callOptions);
          }
        };
    return PolicyBindingsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PolicyBindingsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyBindingsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PolicyBindingsBlockingStub>() {
          @java.lang.Override
          public PolicyBindingsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PolicyBindingsBlockingStub(channel, callOptions);
          }
        };
    return PolicyBindingsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PolicyBindingsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyBindingsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PolicyBindingsFutureStub>() {
          @java.lang.Override
          public PolicyBindingsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PolicyBindingsFutureStub(channel, callOptions);
          }
        };
    return PolicyBindingsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policy
   * bindings.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is created, the policy is applied to the target.
     * </pre>
     */
    default void createPolicyBinding(
        com.google.iam.v3.CreatePolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePolicyBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy binding.
     * </pre>
     */
    default void getPolicyBinding(
        com.google.iam.v3.GetPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3.PolicyBinding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPolicyBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on the policy and target in the
     * binding to update, and the IAM permission to remove the existing policy
     * from the binding. Target is immutable and cannot be updated. Once the
     * binding is updated, the new policy is applied to the target.
     * </pre>
     */
    default void updatePolicyBinding(
        com.google.iam.v3.UpdatePolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePolicyBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is deleted, the policy no longer applies to the target.
     * </pre>
     */
    default void deletePolicyBinding(
        com.google.iam.v3.DeletePolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePolicyBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists policy bindings.
     * </pre>
     */
    default void listPolicyBindings(
        com.google.iam.v3.ListPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3.ListPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPolicyBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search policy bindings by target. Returns all policy binding objects bound
     * directly to target.
     * </pre>
     */
    default void searchTargetPolicyBindings(
        com.google.iam.v3.SearchTargetPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3.SearchTargetPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchTargetPolicyBindingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PolicyBindings.
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policy
   * bindings.
   * </pre>
   */
  public abstract static class PolicyBindingsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PolicyBindingsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PolicyBindings.
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policy
   * bindings.
   * </pre>
   */
  public static final class PolicyBindingsStub
      extends io.grpc.stub.AbstractAsyncStub<PolicyBindingsStub> {
    private PolicyBindingsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyBindingsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyBindingsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is created, the policy is applied to the target.
     * </pre>
     */
    public void createPolicyBinding(
        com.google.iam.v3.CreatePolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePolicyBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy binding.
     * </pre>
     */
    public void getPolicyBinding(
        com.google.iam.v3.GetPolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3.PolicyBinding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPolicyBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on the policy and target in the
     * binding to update, and the IAM permission to remove the existing policy
     * from the binding. Target is immutable and cannot be updated. Once the
     * binding is updated, the new policy is applied to the target.
     * </pre>
     */
    public void updatePolicyBinding(
        com.google.iam.v3.UpdatePolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePolicyBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is deleted, the policy no longer applies to the target.
     * </pre>
     */
    public void deletePolicyBinding(
        com.google.iam.v3.DeletePolicyBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePolicyBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists policy bindings.
     * </pre>
     */
    public void listPolicyBindings(
        com.google.iam.v3.ListPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3.ListPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPolicyBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search policy bindings by target. Returns all policy binding objects bound
     * directly to target.
     * </pre>
     */
    public void searchTargetPolicyBindings(
        com.google.iam.v3.SearchTargetPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3.SearchTargetPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchTargetPolicyBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PolicyBindings.
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policy
   * bindings.
   * </pre>
   */
  public static final class PolicyBindingsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<PolicyBindingsBlockingV2Stub> {
    private PolicyBindingsBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyBindingsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyBindingsBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is created, the policy is applied to the target.
     * </pre>
     */
    public com.google.longrunning.Operation createPolicyBinding(
        com.google.iam.v3.CreatePolicyBindingRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy binding.
     * </pre>
     */
    public com.google.iam.v3.PolicyBinding getPolicyBinding(
        com.google.iam.v3.GetPolicyBindingRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on the policy and target in the
     * binding to update, and the IAM permission to remove the existing policy
     * from the binding. Target is immutable and cannot be updated. Once the
     * binding is updated, the new policy is applied to the target.
     * </pre>
     */
    public com.google.longrunning.Operation updatePolicyBinding(
        com.google.iam.v3.UpdatePolicyBindingRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdatePolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is deleted, the policy no longer applies to the target.
     * </pre>
     */
    public com.google.longrunning.Operation deletePolicyBinding(
        com.google.iam.v3.DeletePolicyBindingRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeletePolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists policy bindings.
     * </pre>
     */
    public com.google.iam.v3.ListPolicyBindingsResponse listPolicyBindings(
        com.google.iam.v3.ListPolicyBindingsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPolicyBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search policy bindings by target. Returns all policy binding objects bound
     * directly to target.
     * </pre>
     */
    public com.google.iam.v3.SearchTargetPolicyBindingsResponse searchTargetPolicyBindings(
        com.google.iam.v3.SearchTargetPolicyBindingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchTargetPolicyBindingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service PolicyBindings.
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policy
   * bindings.
   * </pre>
   */
  public static final class PolicyBindingsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PolicyBindingsBlockingStub> {
    private PolicyBindingsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyBindingsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyBindingsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is created, the policy is applied to the target.
     * </pre>
     */
    public com.google.longrunning.Operation createPolicyBinding(
        com.google.iam.v3.CreatePolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy binding.
     * </pre>
     */
    public com.google.iam.v3.PolicyBinding getPolicyBinding(
        com.google.iam.v3.GetPolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on the policy and target in the
     * binding to update, and the IAM permission to remove the existing policy
     * from the binding. Target is immutable and cannot be updated. Once the
     * binding is updated, the new policy is applied to the target.
     * </pre>
     */
    public com.google.longrunning.Operation updatePolicyBinding(
        com.google.iam.v3.UpdatePolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is deleted, the policy no longer applies to the target.
     * </pre>
     */
    public com.google.longrunning.Operation deletePolicyBinding(
        com.google.iam.v3.DeletePolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePolicyBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists policy bindings.
     * </pre>
     */
    public com.google.iam.v3.ListPolicyBindingsResponse listPolicyBindings(
        com.google.iam.v3.ListPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPolicyBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search policy bindings by target. Returns all policy binding objects bound
     * directly to target.
     * </pre>
     */
    public com.google.iam.v3.SearchTargetPolicyBindingsResponse searchTargetPolicyBindings(
        com.google.iam.v3.SearchTargetPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchTargetPolicyBindingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PolicyBindings.
   *
   * <pre>
   * An interface for managing Identity and Access Management (IAM) policy
   * bindings.
   * </pre>
   */
  public static final class PolicyBindingsFutureStub
      extends io.grpc.stub.AbstractFutureStub<PolicyBindingsFutureStub> {
    private PolicyBindingsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyBindingsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyBindingsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is created, the policy is applied to the target.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPolicyBinding(com.google.iam.v3.CreatePolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePolicyBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy binding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v3.PolicyBinding>
        getPolicyBinding(com.google.iam.v3.GetPolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPolicyBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on the policy and target in the
     * binding to update, and the IAM permission to remove the existing policy
     * from the binding. Target is immutable and cannot be updated. Once the
     * binding is updated, the new policy is applied to the target.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePolicyBinding(com.google.iam.v3.UpdatePolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePolicyBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy binding and returns a long-running operation.
     * Callers will need the IAM permissions on both the policy and target.
     * Once the binding is deleted, the policy no longer applies to the target.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePolicyBinding(com.google.iam.v3.DeletePolicyBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePolicyBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists policy bindings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v3.ListPolicyBindingsResponse>
        listPolicyBindings(com.google.iam.v3.ListPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPolicyBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search policy bindings by target. Returns all policy binding objects bound
     * directly to target.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v3.SearchTargetPolicyBindingsResponse>
        searchTargetPolicyBindings(com.google.iam.v3.SearchTargetPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchTargetPolicyBindingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_POLICY_BINDING = 0;
  private static final int METHODID_GET_POLICY_BINDING = 1;
  private static final int METHODID_UPDATE_POLICY_BINDING = 2;
  private static final int METHODID_DELETE_POLICY_BINDING = 3;
  private static final int METHODID_LIST_POLICY_BINDINGS = 4;
  private static final int METHODID_SEARCH_TARGET_POLICY_BINDINGS = 5;

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
        case METHODID_CREATE_POLICY_BINDING:
          serviceImpl.createPolicyBinding(
              (com.google.iam.v3.CreatePolicyBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_POLICY_BINDING:
          serviceImpl.getPolicyBinding(
              (com.google.iam.v3.GetPolicyBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v3.PolicyBinding>) responseObserver);
          break;
        case METHODID_UPDATE_POLICY_BINDING:
          serviceImpl.updatePolicyBinding(
              (com.google.iam.v3.UpdatePolicyBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_POLICY_BINDING:
          serviceImpl.deletePolicyBinding(
              (com.google.iam.v3.DeletePolicyBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_POLICY_BINDINGS:
          serviceImpl.listPolicyBindings(
              (com.google.iam.v3.ListPolicyBindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v3.ListPolicyBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_TARGET_POLICY_BINDINGS:
          serviceImpl.searchTargetPolicyBindings(
              (com.google.iam.v3.SearchTargetPolicyBindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v3.SearchTargetPolicyBindingsResponse>)
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
            getCreatePolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3.CreatePolicyBindingRequest, com.google.longrunning.Operation>(
                    service, METHODID_CREATE_POLICY_BINDING)))
        .addMethod(
            getGetPolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3.GetPolicyBindingRequest, com.google.iam.v3.PolicyBinding>(
                    service, METHODID_GET_POLICY_BINDING)))
        .addMethod(
            getUpdatePolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3.UpdatePolicyBindingRequest, com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_POLICY_BINDING)))
        .addMethod(
            getDeletePolicyBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3.DeletePolicyBindingRequest, com.google.longrunning.Operation>(
                    service, METHODID_DELETE_POLICY_BINDING)))
        .addMethod(
            getListPolicyBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3.ListPolicyBindingsRequest,
                    com.google.iam.v3.ListPolicyBindingsResponse>(
                    service, METHODID_LIST_POLICY_BINDINGS)))
        .addMethod(
            getSearchTargetPolicyBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3.SearchTargetPolicyBindingsRequest,
                    com.google.iam.v3.SearchTargetPolicyBindingsResponse>(
                    service, METHODID_SEARCH_TARGET_POLICY_BINDINGS)))
        .build();
  }

  private abstract static class PolicyBindingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PolicyBindingsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.iam.v3.PolicyBindingsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PolicyBindings");
    }
  }

  private static final class PolicyBindingsFileDescriptorSupplier
      extends PolicyBindingsBaseDescriptorSupplier {
    PolicyBindingsFileDescriptorSupplier() {}
  }

  private static final class PolicyBindingsMethodDescriptorSupplier
      extends PolicyBindingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PolicyBindingsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PolicyBindingsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PolicyBindingsFileDescriptorSupplier())
                      .addMethod(getCreatePolicyBindingMethod())
                      .addMethod(getGetPolicyBindingMethod())
                      .addMethod(getUpdatePolicyBindingMethod())
                      .addMethod(getDeletePolicyBindingMethod())
                      .addMethod(getListPolicyBindingsMethod())
                      .addMethod(getSearchTargetPolicyBindingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
