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
 * Manages Identity and Access Management (IAM) principal access boundary
 * policies.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class PrincipalAccessBoundaryPoliciesGrpc {

  private PrincipalAccessBoundaryPoliciesGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.iam.v3beta.PrincipalAccessBoundaryPolicies";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest,
          com.google.longrunning.Operation>
      getCreatePrincipalAccessBoundaryPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePrincipalAccessBoundaryPolicy",
      requestType = com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest,
          com.google.longrunning.Operation>
      getCreatePrincipalAccessBoundaryPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest,
            com.google.longrunning.Operation>
        getCreatePrincipalAccessBoundaryPolicyMethod;
    if ((getCreatePrincipalAccessBoundaryPolicyMethod =
            PrincipalAccessBoundaryPoliciesGrpc.getCreatePrincipalAccessBoundaryPolicyMethod)
        == null) {
      synchronized (PrincipalAccessBoundaryPoliciesGrpc.class) {
        if ((getCreatePrincipalAccessBoundaryPolicyMethod =
                PrincipalAccessBoundaryPoliciesGrpc.getCreatePrincipalAccessBoundaryPolicyMethod)
            == null) {
          PrincipalAccessBoundaryPoliciesGrpc.getCreatePrincipalAccessBoundaryPolicyMethod =
              getCreatePrincipalAccessBoundaryPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "CreatePrincipalAccessBoundaryPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrincipalAccessBoundaryPoliciesMethodDescriptorSupplier(
                              "CreatePrincipalAccessBoundaryPolicy"))
                      .build();
        }
      }
    }
    return getCreatePrincipalAccessBoundaryPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest,
          com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>
      getGetPrincipalAccessBoundaryPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrincipalAccessBoundaryPolicy",
      requestType = com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest.class,
      responseType = com.google.iam.v3beta.PrincipalAccessBoundaryPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest,
          com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>
      getGetPrincipalAccessBoundaryPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest,
            com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>
        getGetPrincipalAccessBoundaryPolicyMethod;
    if ((getGetPrincipalAccessBoundaryPolicyMethod =
            PrincipalAccessBoundaryPoliciesGrpc.getGetPrincipalAccessBoundaryPolicyMethod)
        == null) {
      synchronized (PrincipalAccessBoundaryPoliciesGrpc.class) {
        if ((getGetPrincipalAccessBoundaryPolicyMethod =
                PrincipalAccessBoundaryPoliciesGrpc.getGetPrincipalAccessBoundaryPolicyMethod)
            == null) {
          PrincipalAccessBoundaryPoliciesGrpc.getGetPrincipalAccessBoundaryPolicyMethod =
              getGetPrincipalAccessBoundaryPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest,
                          com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPrincipalAccessBoundaryPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.PrincipalAccessBoundaryPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrincipalAccessBoundaryPoliciesMethodDescriptorSupplier(
                              "GetPrincipalAccessBoundaryPolicy"))
                      .build();
        }
      }
    }
    return getGetPrincipalAccessBoundaryPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest,
          com.google.longrunning.Operation>
      getUpdatePrincipalAccessBoundaryPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePrincipalAccessBoundaryPolicy",
      requestType = com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest,
          com.google.longrunning.Operation>
      getUpdatePrincipalAccessBoundaryPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest,
            com.google.longrunning.Operation>
        getUpdatePrincipalAccessBoundaryPolicyMethod;
    if ((getUpdatePrincipalAccessBoundaryPolicyMethod =
            PrincipalAccessBoundaryPoliciesGrpc.getUpdatePrincipalAccessBoundaryPolicyMethod)
        == null) {
      synchronized (PrincipalAccessBoundaryPoliciesGrpc.class) {
        if ((getUpdatePrincipalAccessBoundaryPolicyMethod =
                PrincipalAccessBoundaryPoliciesGrpc.getUpdatePrincipalAccessBoundaryPolicyMethod)
            == null) {
          PrincipalAccessBoundaryPoliciesGrpc.getUpdatePrincipalAccessBoundaryPolicyMethod =
              getUpdatePrincipalAccessBoundaryPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdatePrincipalAccessBoundaryPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrincipalAccessBoundaryPoliciesMethodDescriptorSupplier(
                              "UpdatePrincipalAccessBoundaryPolicy"))
                      .build();
        }
      }
    }
    return getUpdatePrincipalAccessBoundaryPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest,
          com.google.longrunning.Operation>
      getDeletePrincipalAccessBoundaryPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePrincipalAccessBoundaryPolicy",
      requestType = com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest,
          com.google.longrunning.Operation>
      getDeletePrincipalAccessBoundaryPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest,
            com.google.longrunning.Operation>
        getDeletePrincipalAccessBoundaryPolicyMethod;
    if ((getDeletePrincipalAccessBoundaryPolicyMethod =
            PrincipalAccessBoundaryPoliciesGrpc.getDeletePrincipalAccessBoundaryPolicyMethod)
        == null) {
      synchronized (PrincipalAccessBoundaryPoliciesGrpc.class) {
        if ((getDeletePrincipalAccessBoundaryPolicyMethod =
                PrincipalAccessBoundaryPoliciesGrpc.getDeletePrincipalAccessBoundaryPolicyMethod)
            == null) {
          PrincipalAccessBoundaryPoliciesGrpc.getDeletePrincipalAccessBoundaryPolicyMethod =
              getDeletePrincipalAccessBoundaryPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "DeletePrincipalAccessBoundaryPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrincipalAccessBoundaryPoliciesMethodDescriptorSupplier(
                              "DeletePrincipalAccessBoundaryPolicy"))
                      .build();
        }
      }
    }
    return getDeletePrincipalAccessBoundaryPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest,
          com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>
      getListPrincipalAccessBoundaryPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrincipalAccessBoundaryPolicies",
      requestType = com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest.class,
      responseType = com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest,
          com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>
      getListPrincipalAccessBoundaryPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest,
            com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>
        getListPrincipalAccessBoundaryPoliciesMethod;
    if ((getListPrincipalAccessBoundaryPoliciesMethod =
            PrincipalAccessBoundaryPoliciesGrpc.getListPrincipalAccessBoundaryPoliciesMethod)
        == null) {
      synchronized (PrincipalAccessBoundaryPoliciesGrpc.class) {
        if ((getListPrincipalAccessBoundaryPoliciesMethod =
                PrincipalAccessBoundaryPoliciesGrpc.getListPrincipalAccessBoundaryPoliciesMethod)
            == null) {
          PrincipalAccessBoundaryPoliciesGrpc.getListPrincipalAccessBoundaryPoliciesMethod =
              getListPrincipalAccessBoundaryPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest,
                          com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListPrincipalAccessBoundaryPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrincipalAccessBoundaryPoliciesMethodDescriptorSupplier(
                              "ListPrincipalAccessBoundaryPolicies"))
                      .build();
        }
      }
    }
    return getListPrincipalAccessBoundaryPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      getSearchPrincipalAccessBoundaryPolicyBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchPrincipalAccessBoundaryPolicyBindings",
      requestType = com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest.class,
      responseType =
          com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      getSearchPrincipalAccessBoundaryPolicyBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest,
            com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>
        getSearchPrincipalAccessBoundaryPolicyBindingsMethod;
    if ((getSearchPrincipalAccessBoundaryPolicyBindingsMethod =
            PrincipalAccessBoundaryPoliciesGrpc
                .getSearchPrincipalAccessBoundaryPolicyBindingsMethod)
        == null) {
      synchronized (PrincipalAccessBoundaryPoliciesGrpc.class) {
        if ((getSearchPrincipalAccessBoundaryPolicyBindingsMethod =
                PrincipalAccessBoundaryPoliciesGrpc
                    .getSearchPrincipalAccessBoundaryPolicyBindingsMethod)
            == null) {
          PrincipalAccessBoundaryPoliciesGrpc.getSearchPrincipalAccessBoundaryPolicyBindingsMethod =
              getSearchPrincipalAccessBoundaryPolicyBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                          com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "SearchPrincipalAccessBoundaryPolicyBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta
                                  .SearchPrincipalAccessBoundaryPolicyBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v3beta
                                  .SearchPrincipalAccessBoundaryPolicyBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PrincipalAccessBoundaryPoliciesMethodDescriptorSupplier(
                              "SearchPrincipalAccessBoundaryPolicyBindings"))
                      .build();
        }
      }
    }
    return getSearchPrincipalAccessBoundaryPolicyBindingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PrincipalAccessBoundaryPoliciesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrincipalAccessBoundaryPoliciesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PrincipalAccessBoundaryPoliciesStub>() {
          @java.lang.Override
          public PrincipalAccessBoundaryPoliciesStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PrincipalAccessBoundaryPoliciesStub(channel, callOptions);
          }
        };
    return PrincipalAccessBoundaryPoliciesStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static PrincipalAccessBoundaryPoliciesBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrincipalAccessBoundaryPoliciesBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PrincipalAccessBoundaryPoliciesBlockingV2Stub>() {
          @java.lang.Override
          public PrincipalAccessBoundaryPoliciesBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PrincipalAccessBoundaryPoliciesBlockingV2Stub(channel, callOptions);
          }
        };
    return PrincipalAccessBoundaryPoliciesBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrincipalAccessBoundaryPoliciesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrincipalAccessBoundaryPoliciesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PrincipalAccessBoundaryPoliciesBlockingStub>() {
          @java.lang.Override
          public PrincipalAccessBoundaryPoliciesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PrincipalAccessBoundaryPoliciesBlockingStub(channel, callOptions);
          }
        };
    return PrincipalAccessBoundaryPoliciesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PrincipalAccessBoundaryPoliciesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrincipalAccessBoundaryPoliciesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PrincipalAccessBoundaryPoliciesFutureStub>() {
          @java.lang.Override
          public PrincipalAccessBoundaryPoliciesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PrincipalAccessBoundaryPoliciesFutureStub(channel, callOptions);
          }
        };
    return PrincipalAccessBoundaryPoliciesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages Identity and Access Management (IAM) principal access boundary
   * policies.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a principal access boundary policy, and returns a long running
     * operation.
     * </pre>
     */
    default void createPrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePrincipalAccessBoundaryPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a principal access boundary policy.
     * </pre>
     */
    default void getPrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPrincipalAccessBoundaryPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a principal access boundary policy.
     * </pre>
     */
    default void updatePrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePrincipalAccessBoundaryPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a principal access boundary policy.
     * </pre>
     */
    default void deletePrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePrincipalAccessBoundaryPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists principal access boundary policies.
     * </pre>
     */
    default void listPrincipalAccessBoundaryPolicies(
        com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPrincipalAccessBoundaryPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all policy bindings that bind a specific policy if a user has
     * searchPolicyBindings permission on that policy.
     * </pre>
     */
    default void searchPrincipalAccessBoundaryPolicyBindings(
        com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchPrincipalAccessBoundaryPolicyBindingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PrincipalAccessBoundaryPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) principal access boundary
   * policies.
   * </pre>
   */
  public abstract static class PrincipalAccessBoundaryPoliciesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PrincipalAccessBoundaryPoliciesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * PrincipalAccessBoundaryPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) principal access boundary
   * policies.
   * </pre>
   */
  public static final class PrincipalAccessBoundaryPoliciesStub
      extends io.grpc.stub.AbstractAsyncStub<PrincipalAccessBoundaryPoliciesStub> {
    private PrincipalAccessBoundaryPoliciesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrincipalAccessBoundaryPoliciesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrincipalAccessBoundaryPoliciesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a principal access boundary policy, and returns a long running
     * operation.
     * </pre>
     */
    public void createPrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePrincipalAccessBoundaryPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a principal access boundary policy.
     * </pre>
     */
    public void getPrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPrincipalAccessBoundaryPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a principal access boundary policy.
     * </pre>
     */
    public void updatePrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePrincipalAccessBoundaryPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a principal access boundary policy.
     * </pre>
     */
    public void deletePrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePrincipalAccessBoundaryPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists principal access boundary policies.
     * </pre>
     */
    public void listPrincipalAccessBoundaryPolicies(
        com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrincipalAccessBoundaryPoliciesMethod(), getCallOptions()),
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
    public void searchPrincipalAccessBoundaryPolicyBindings(
        com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getSearchPrincipalAccessBoundaryPolicyBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PrincipalAccessBoundaryPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) principal access boundary
   * policies.
   * </pre>
   */
  public static final class PrincipalAccessBoundaryPoliciesBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<PrincipalAccessBoundaryPoliciesBlockingV2Stub> {
    private PrincipalAccessBoundaryPoliciesBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrincipalAccessBoundaryPoliciesBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrincipalAccessBoundaryPoliciesBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a principal access boundary policy, and returns a long running
     * operation.
     * </pre>
     */
    public com.google.longrunning.Operation createPrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePrincipalAccessBoundaryPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a principal access boundary policy.
     * </pre>
     */
    public com.google.iam.v3beta.PrincipalAccessBoundaryPolicy getPrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPrincipalAccessBoundaryPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a principal access boundary policy.
     * </pre>
     */
    public com.google.longrunning.Operation updatePrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdatePrincipalAccessBoundaryPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a principal access boundary policy.
     * </pre>
     */
    public com.google.longrunning.Operation deletePrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeletePrincipalAccessBoundaryPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists principal access boundary policies.
     * </pre>
     */
    public com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse
        listPrincipalAccessBoundaryPolicies(
            com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPrincipalAccessBoundaryPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all policy bindings that bind a specific policy if a user has
     * searchPolicyBindings permission on that policy.
     * </pre>
     */
    public com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse
        searchPrincipalAccessBoundaryPolicyBindings(
            com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getSearchPrincipalAccessBoundaryPolicyBindingsMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * PrincipalAccessBoundaryPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) principal access boundary
   * policies.
   * </pre>
   */
  public static final class PrincipalAccessBoundaryPoliciesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PrincipalAccessBoundaryPoliciesBlockingStub> {
    private PrincipalAccessBoundaryPoliciesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrincipalAccessBoundaryPoliciesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrincipalAccessBoundaryPoliciesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a principal access boundary policy, and returns a long running
     * operation.
     * </pre>
     */
    public com.google.longrunning.Operation createPrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePrincipalAccessBoundaryPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a principal access boundary policy.
     * </pre>
     */
    public com.google.iam.v3beta.PrincipalAccessBoundaryPolicy getPrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPrincipalAccessBoundaryPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a principal access boundary policy.
     * </pre>
     */
    public com.google.longrunning.Operation updatePrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePrincipalAccessBoundaryPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a principal access boundary policy.
     * </pre>
     */
    public com.google.longrunning.Operation deletePrincipalAccessBoundaryPolicy(
        com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePrincipalAccessBoundaryPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists principal access boundary policies.
     * </pre>
     */
    public com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse
        listPrincipalAccessBoundaryPolicies(
            com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrincipalAccessBoundaryPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all policy bindings that bind a specific policy if a user has
     * searchPolicyBindings permission on that policy.
     * </pre>
     */
    public com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse
        searchPrincipalAccessBoundaryPolicyBindings(
            com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getSearchPrincipalAccessBoundaryPolicyBindingsMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * PrincipalAccessBoundaryPolicies.
   *
   * <pre>
   * Manages Identity and Access Management (IAM) principal access boundary
   * policies.
   * </pre>
   */
  public static final class PrincipalAccessBoundaryPoliciesFutureStub
      extends io.grpc.stub.AbstractFutureStub<PrincipalAccessBoundaryPoliciesFutureStub> {
    private PrincipalAccessBoundaryPoliciesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrincipalAccessBoundaryPoliciesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrincipalAccessBoundaryPoliciesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a principal access boundary policy, and returns a long running
     * operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPrincipalAccessBoundaryPolicy(
            com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePrincipalAccessBoundaryPolicyMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a principal access boundary policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>
        getPrincipalAccessBoundaryPolicy(
            com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPrincipalAccessBoundaryPolicyMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a principal access boundary policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePrincipalAccessBoundaryPolicy(
            com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePrincipalAccessBoundaryPolicyMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a principal access boundary policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePrincipalAccessBoundaryPolicy(
            com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePrincipalAccessBoundaryPolicyMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists principal access boundary policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>
        listPrincipalAccessBoundaryPolicies(
            com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrincipalAccessBoundaryPoliciesMethod(), getCallOptions()),
          request);
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
            com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>
        searchPrincipalAccessBoundaryPolicyBindings(
            com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getSearchPrincipalAccessBoundaryPolicyBindingsMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_PRINCIPAL_ACCESS_BOUNDARY_POLICY = 0;
  private static final int METHODID_GET_PRINCIPAL_ACCESS_BOUNDARY_POLICY = 1;
  private static final int METHODID_UPDATE_PRINCIPAL_ACCESS_BOUNDARY_POLICY = 2;
  private static final int METHODID_DELETE_PRINCIPAL_ACCESS_BOUNDARY_POLICY = 3;
  private static final int METHODID_LIST_PRINCIPAL_ACCESS_BOUNDARY_POLICIES = 4;
  private static final int METHODID_SEARCH_PRINCIPAL_ACCESS_BOUNDARY_POLICY_BINDINGS = 5;

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
        case METHODID_CREATE_PRINCIPAL_ACCESS_BOUNDARY_POLICY:
          serviceImpl.createPrincipalAccessBoundaryPolicy(
              (com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PRINCIPAL_ACCESS_BOUNDARY_POLICY:
          serviceImpl.getPrincipalAccessBoundaryPolicy(
              (com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PRINCIPAL_ACCESS_BOUNDARY_POLICY:
          serviceImpl.updatePrincipalAccessBoundaryPolicy(
              (com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PRINCIPAL_ACCESS_BOUNDARY_POLICY:
          serviceImpl.deletePrincipalAccessBoundaryPolicy(
              (com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PRINCIPAL_ACCESS_BOUNDARY_POLICIES:
          serviceImpl.listPrincipalAccessBoundaryPolicies(
              (com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_PRINCIPAL_ACCESS_BOUNDARY_POLICY_BINDINGS:
          serviceImpl.searchPrincipalAccessBoundaryPolicyBindings(
              (com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>)
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
            getCreatePrincipalAccessBoundaryPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_PRINCIPAL_ACCESS_BOUNDARY_POLICY)))
        .addMethod(
            getGetPrincipalAccessBoundaryPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest,
                    com.google.iam.v3beta.PrincipalAccessBoundaryPolicy>(
                    service, METHODID_GET_PRINCIPAL_ACCESS_BOUNDARY_POLICY)))
        .addMethod(
            getUpdatePrincipalAccessBoundaryPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_PRINCIPAL_ACCESS_BOUNDARY_POLICY)))
        .addMethod(
            getDeletePrincipalAccessBoundaryPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_PRINCIPAL_ACCESS_BOUNDARY_POLICY)))
        .addMethod(
            getListPrincipalAccessBoundaryPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest,
                    com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse>(
                    service, METHODID_LIST_PRINCIPAL_ACCESS_BOUNDARY_POLICIES)))
        .addMethod(
            getSearchPrincipalAccessBoundaryPolicyBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                    com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse>(
                    service, METHODID_SEARCH_PRINCIPAL_ACCESS_BOUNDARY_POLICY_BINDINGS)))
        .build();
  }

  private abstract static class PrincipalAccessBoundaryPoliciesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrincipalAccessBoundaryPoliciesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrincipalAccessBoundaryPolicies");
    }
  }

  private static final class PrincipalAccessBoundaryPoliciesFileDescriptorSupplier
      extends PrincipalAccessBoundaryPoliciesBaseDescriptorSupplier {
    PrincipalAccessBoundaryPoliciesFileDescriptorSupplier() {}
  }

  private static final class PrincipalAccessBoundaryPoliciesMethodDescriptorSupplier
      extends PrincipalAccessBoundaryPoliciesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PrincipalAccessBoundaryPoliciesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PrincipalAccessBoundaryPoliciesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new PrincipalAccessBoundaryPoliciesFileDescriptorSupplier())
                      .addMethod(getCreatePrincipalAccessBoundaryPolicyMethod())
                      .addMethod(getGetPrincipalAccessBoundaryPolicyMethod())
                      .addMethod(getUpdatePrincipalAccessBoundaryPolicyMethod())
                      .addMethod(getDeletePrincipalAccessBoundaryPolicyMethod())
                      .addMethod(getListPrincipalAccessBoundaryPoliciesMethod())
                      .addMethod(getSearchPrincipalAccessBoundaryPolicyBindingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
