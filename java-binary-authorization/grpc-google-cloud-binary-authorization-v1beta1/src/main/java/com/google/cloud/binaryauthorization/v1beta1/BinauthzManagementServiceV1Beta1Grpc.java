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
package com.google.cloud.binaryauthorization.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Google Cloud Management Service for Binary Authorization admission policies
 * and attestation authorities.
 * This API implements a REST model with the following objects:
 * * [Policy][google.cloud.binaryauthorization.v1beta1.Policy]
 * * [Attestor][google.cloud.binaryauthorization.v1beta1.Attestor]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/binaryauthorization/v1beta1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BinauthzManagementServiceV1Beta1Grpc {

  private BinauthzManagementServiceV1Beta1Grpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest,
          com.google.cloud.binaryauthorization.v1beta1.Policy>
      getGetPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPolicy",
      requestType = com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest.class,
      responseType = com.google.cloud.binaryauthorization.v1beta1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest,
          com.google.cloud.binaryauthorization.v1beta1.Policy>
      getGetPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest,
            com.google.cloud.binaryauthorization.v1beta1.Policy>
        getGetPolicyMethod;
    if ((getGetPolicyMethod = BinauthzManagementServiceV1Beta1Grpc.getGetPolicyMethod) == null) {
      synchronized (BinauthzManagementServiceV1Beta1Grpc.class) {
        if ((getGetPolicyMethod = BinauthzManagementServiceV1Beta1Grpc.getGetPolicyMethod)
            == null) {
          BinauthzManagementServiceV1Beta1Grpc.getGetPolicyMethod =
              getGetPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest,
                          com.google.cloud.binaryauthorization.v1beta1.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.Policy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BinauthzManagementServiceV1Beta1MethodDescriptorSupplier("GetPolicy"))
                      .build();
        }
      }
    }
    return getGetPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest,
          com.google.cloud.binaryauthorization.v1beta1.Policy>
      getUpdatePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePolicy",
      requestType = com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest.class,
      responseType = com.google.cloud.binaryauthorization.v1beta1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest,
          com.google.cloud.binaryauthorization.v1beta1.Policy>
      getUpdatePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest,
            com.google.cloud.binaryauthorization.v1beta1.Policy>
        getUpdatePolicyMethod;
    if ((getUpdatePolicyMethod = BinauthzManagementServiceV1Beta1Grpc.getUpdatePolicyMethod)
        == null) {
      synchronized (BinauthzManagementServiceV1Beta1Grpc.class) {
        if ((getUpdatePolicyMethod = BinauthzManagementServiceV1Beta1Grpc.getUpdatePolicyMethod)
            == null) {
          BinauthzManagementServiceV1Beta1Grpc.getUpdatePolicyMethod =
              getUpdatePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest,
                          com.google.cloud.binaryauthorization.v1beta1.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.Policy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BinauthzManagementServiceV1Beta1MethodDescriptorSupplier(
                              "UpdatePolicy"))
                      .build();
        }
      }
    }
    return getUpdatePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest,
          com.google.cloud.binaryauthorization.v1beta1.Attestor>
      getCreateAttestorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAttestor",
      requestType = com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest.class,
      responseType = com.google.cloud.binaryauthorization.v1beta1.Attestor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest,
          com.google.cloud.binaryauthorization.v1beta1.Attestor>
      getCreateAttestorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest,
            com.google.cloud.binaryauthorization.v1beta1.Attestor>
        getCreateAttestorMethod;
    if ((getCreateAttestorMethod = BinauthzManagementServiceV1Beta1Grpc.getCreateAttestorMethod)
        == null) {
      synchronized (BinauthzManagementServiceV1Beta1Grpc.class) {
        if ((getCreateAttestorMethod = BinauthzManagementServiceV1Beta1Grpc.getCreateAttestorMethod)
            == null) {
          BinauthzManagementServiceV1Beta1Grpc.getCreateAttestorMethod =
              getCreateAttestorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest,
                          com.google.cloud.binaryauthorization.v1beta1.Attestor>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAttestor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.Attestor
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BinauthzManagementServiceV1Beta1MethodDescriptorSupplier(
                              "CreateAttestor"))
                      .build();
        }
      }
    }
    return getCreateAttestorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest,
          com.google.cloud.binaryauthorization.v1beta1.Attestor>
      getGetAttestorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttestor",
      requestType = com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest.class,
      responseType = com.google.cloud.binaryauthorization.v1beta1.Attestor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest,
          com.google.cloud.binaryauthorization.v1beta1.Attestor>
      getGetAttestorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest,
            com.google.cloud.binaryauthorization.v1beta1.Attestor>
        getGetAttestorMethod;
    if ((getGetAttestorMethod = BinauthzManagementServiceV1Beta1Grpc.getGetAttestorMethod)
        == null) {
      synchronized (BinauthzManagementServiceV1Beta1Grpc.class) {
        if ((getGetAttestorMethod = BinauthzManagementServiceV1Beta1Grpc.getGetAttestorMethod)
            == null) {
          BinauthzManagementServiceV1Beta1Grpc.getGetAttestorMethod =
              getGetAttestorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest,
                          com.google.cloud.binaryauthorization.v1beta1.Attestor>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAttestor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.Attestor
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BinauthzManagementServiceV1Beta1MethodDescriptorSupplier(
                              "GetAttestor"))
                      .build();
        }
      }
    }
    return getGetAttestorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest,
          com.google.cloud.binaryauthorization.v1beta1.Attestor>
      getUpdateAttestorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAttestor",
      requestType = com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest.class,
      responseType = com.google.cloud.binaryauthorization.v1beta1.Attestor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest,
          com.google.cloud.binaryauthorization.v1beta1.Attestor>
      getUpdateAttestorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest,
            com.google.cloud.binaryauthorization.v1beta1.Attestor>
        getUpdateAttestorMethod;
    if ((getUpdateAttestorMethod = BinauthzManagementServiceV1Beta1Grpc.getUpdateAttestorMethod)
        == null) {
      synchronized (BinauthzManagementServiceV1Beta1Grpc.class) {
        if ((getUpdateAttestorMethod = BinauthzManagementServiceV1Beta1Grpc.getUpdateAttestorMethod)
            == null) {
          BinauthzManagementServiceV1Beta1Grpc.getUpdateAttestorMethod =
              getUpdateAttestorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest,
                          com.google.cloud.binaryauthorization.v1beta1.Attestor>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAttestor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.Attestor
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BinauthzManagementServiceV1Beta1MethodDescriptorSupplier(
                              "UpdateAttestor"))
                      .build();
        }
      }
    }
    return getUpdateAttestorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest,
          com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>
      getListAttestorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAttestors",
      requestType = com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest.class,
      responseType = com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest,
          com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>
      getListAttestorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest,
            com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>
        getListAttestorsMethod;
    if ((getListAttestorsMethod = BinauthzManagementServiceV1Beta1Grpc.getListAttestorsMethod)
        == null) {
      synchronized (BinauthzManagementServiceV1Beta1Grpc.class) {
        if ((getListAttestorsMethod = BinauthzManagementServiceV1Beta1Grpc.getListAttestorsMethod)
            == null) {
          BinauthzManagementServiceV1Beta1Grpc.getListAttestorsMethod =
              getListAttestorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest,
                          com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAttestors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BinauthzManagementServiceV1Beta1MethodDescriptorSupplier(
                              "ListAttestors"))
                      .build();
        }
      }
    }
    return getListAttestorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest,
          com.google.protobuf.Empty>
      getDeleteAttestorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAttestor",
      requestType = com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest,
          com.google.protobuf.Empty>
      getDeleteAttestorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest,
            com.google.protobuf.Empty>
        getDeleteAttestorMethod;
    if ((getDeleteAttestorMethod = BinauthzManagementServiceV1Beta1Grpc.getDeleteAttestorMethod)
        == null) {
      synchronized (BinauthzManagementServiceV1Beta1Grpc.class) {
        if ((getDeleteAttestorMethod = BinauthzManagementServiceV1Beta1Grpc.getDeleteAttestorMethod)
            == null) {
          BinauthzManagementServiceV1Beta1Grpc.getDeleteAttestorMethod =
              getDeleteAttestorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAttestor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BinauthzManagementServiceV1Beta1MethodDescriptorSupplier(
                              "DeleteAttestor"))
                      .build();
        }
      }
    }
    return getDeleteAttestorMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BinauthzManagementServiceV1Beta1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1Beta1Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1Beta1Stub>() {
          @java.lang.Override
          public BinauthzManagementServiceV1Beta1Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BinauthzManagementServiceV1Beta1Stub(channel, callOptions);
          }
        };
    return BinauthzManagementServiceV1Beta1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BinauthzManagementServiceV1Beta1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1Beta1BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1Beta1BlockingStub>() {
          @java.lang.Override
          public BinauthzManagementServiceV1Beta1BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BinauthzManagementServiceV1Beta1BlockingStub(channel, callOptions);
          }
        };
    return BinauthzManagementServiceV1Beta1BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BinauthzManagementServiceV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1Beta1FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1Beta1FutureStub>() {
          @java.lang.Override
          public BinauthzManagementServiceV1Beta1FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BinauthzManagementServiceV1Beta1FutureStub(channel, callOptions);
          }
        };
    return BinauthzManagementServiceV1Beta1FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Management Service for Binary Authorization admission policies
   * and attestation authorities.
   * This API implements a REST model with the following objects:
   * * [Policy][google.cloud.binaryauthorization.v1beta1.Policy]
   * * [Attestor][google.cloud.binaryauthorization.v1beta1.Attestor]
   * </pre>
   */
  public abstract static class BinauthzManagementServiceV1Beta1ImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * A [policy][google.cloud.binaryauthorization.v1beta1.Policy] specifies the [attestors][google.cloud.binaryauthorization.v1beta1.Attestor] that must attest to
     * a container image, before the project is allowed to deploy that
     * image. There is at most one policy per project. All image admission
     * requests are permitted if a project has no policy.
     * Gets the [policy][google.cloud.binaryauthorization.v1beta1.Policy] for this project. Returns a default
     * [policy][google.cloud.binaryauthorization.v1beta1.Policy] if the project does not have one.
     * </pre>
     */
    public void getPolicy(
        com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Policy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1beta1.Policy], and returns a copy of the
     * new [policy][google.cloud.binaryauthorization.v1beta1.Policy]. A policy is always updated as a whole, to avoid race
     * conditions with concurrent policy enforcement (or management!)
     * requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT
     * if the request is malformed.
     * </pre>
     */
    public void updatePolicy(
        com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Policy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor], and returns a copy of the new
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor]. Returns NOT_FOUND if the project does not exist,
     * INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] already exists.
     * </pre>
     */
    public void createAttestor(
        com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAttestorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public void getAttestor(
        com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAttestorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public void updateAttestor(
        com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAttestorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [attestors][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns INVALID_ARGUMENT if the project does not exist.
     * </pre>
     */
    public void listAttestors(
        com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAttestorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor]. Returns NOT_FOUND if the
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public void deleteAttestor(
        com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAttestorMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest,
                      com.google.cloud.binaryauthorization.v1beta1.Policy>(
                      this, METHODID_GET_POLICY)))
          .addMethod(
              getUpdatePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest,
                      com.google.cloud.binaryauthorization.v1beta1.Policy>(
                      this, METHODID_UPDATE_POLICY)))
          .addMethod(
              getCreateAttestorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest,
                      com.google.cloud.binaryauthorization.v1beta1.Attestor>(
                      this, METHODID_CREATE_ATTESTOR)))
          .addMethod(
              getGetAttestorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest,
                      com.google.cloud.binaryauthorization.v1beta1.Attestor>(
                      this, METHODID_GET_ATTESTOR)))
          .addMethod(
              getUpdateAttestorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest,
                      com.google.cloud.binaryauthorization.v1beta1.Attestor>(
                      this, METHODID_UPDATE_ATTESTOR)))
          .addMethod(
              getListAttestorsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest,
                      com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>(
                      this, METHODID_LIST_ATTESTORS)))
          .addMethod(
              getDeleteAttestorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ATTESTOR)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Management Service for Binary Authorization admission policies
   * and attestation authorities.
   * This API implements a REST model with the following objects:
   * * [Policy][google.cloud.binaryauthorization.v1beta1.Policy]
   * * [Attestor][google.cloud.binaryauthorization.v1beta1.Attestor]
   * </pre>
   */
  public static final class BinauthzManagementServiceV1Beta1Stub
      extends io.grpc.stub.AbstractAsyncStub<BinauthzManagementServiceV1Beta1Stub> {
    private BinauthzManagementServiceV1Beta1Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BinauthzManagementServiceV1Beta1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BinauthzManagementServiceV1Beta1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * A [policy][google.cloud.binaryauthorization.v1beta1.Policy] specifies the [attestors][google.cloud.binaryauthorization.v1beta1.Attestor] that must attest to
     * a container image, before the project is allowed to deploy that
     * image. There is at most one policy per project. All image admission
     * requests are permitted if a project has no policy.
     * Gets the [policy][google.cloud.binaryauthorization.v1beta1.Policy] for this project. Returns a default
     * [policy][google.cloud.binaryauthorization.v1beta1.Policy] if the project does not have one.
     * </pre>
     */
    public void getPolicy(
        com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Policy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1beta1.Policy], and returns a copy of the
     * new [policy][google.cloud.binaryauthorization.v1beta1.Policy]. A policy is always updated as a whole, to avoid race
     * conditions with concurrent policy enforcement (or management!)
     * requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT
     * if the request is malformed.
     * </pre>
     */
    public void updatePolicy(
        com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Policy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor], and returns a copy of the new
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor]. Returns NOT_FOUND if the project does not exist,
     * INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] already exists.
     * </pre>
     */
    public void createAttestor(
        com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAttestorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public void getAttestor(
        com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttestorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public void updateAttestor(
        com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAttestorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [attestors][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns INVALID_ARGUMENT if the project does not exist.
     * </pre>
     */
    public void listAttestors(
        com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAttestorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor]. Returns NOT_FOUND if the
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public void deleteAttestor(
        com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAttestorMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Management Service for Binary Authorization admission policies
   * and attestation authorities.
   * This API implements a REST model with the following objects:
   * * [Policy][google.cloud.binaryauthorization.v1beta1.Policy]
   * * [Attestor][google.cloud.binaryauthorization.v1beta1.Attestor]
   * </pre>
   */
  public static final class BinauthzManagementServiceV1Beta1BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BinauthzManagementServiceV1Beta1BlockingStub> {
    private BinauthzManagementServiceV1Beta1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BinauthzManagementServiceV1Beta1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BinauthzManagementServiceV1Beta1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * A [policy][google.cloud.binaryauthorization.v1beta1.Policy] specifies the [attestors][google.cloud.binaryauthorization.v1beta1.Attestor] that must attest to
     * a container image, before the project is allowed to deploy that
     * image. There is at most one policy per project. All image admission
     * requests are permitted if a project has no policy.
     * Gets the [policy][google.cloud.binaryauthorization.v1beta1.Policy] for this project. Returns a default
     * [policy][google.cloud.binaryauthorization.v1beta1.Policy] if the project does not have one.
     * </pre>
     */
    public com.google.cloud.binaryauthorization.v1beta1.Policy getPolicy(
        com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1beta1.Policy], and returns a copy of the
     * new [policy][google.cloud.binaryauthorization.v1beta1.Policy]. A policy is always updated as a whole, to avoid race
     * conditions with concurrent policy enforcement (or management!)
     * requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT
     * if the request is malformed.
     * </pre>
     */
    public com.google.cloud.binaryauthorization.v1beta1.Policy updatePolicy(
        com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor], and returns a copy of the new
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor]. Returns NOT_FOUND if the project does not exist,
     * INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] already exists.
     * </pre>
     */
    public com.google.cloud.binaryauthorization.v1beta1.Attestor createAttestor(
        com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAttestorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public com.google.cloud.binaryauthorization.v1beta1.Attestor getAttestor(
        com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttestorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public com.google.cloud.binaryauthorization.v1beta1.Attestor updateAttestor(
        com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAttestorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [attestors][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns INVALID_ARGUMENT if the project does not exist.
     * </pre>
     */
    public com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse listAttestors(
        com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAttestorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor]. Returns NOT_FOUND if the
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAttestor(
        com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAttestorMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Management Service for Binary Authorization admission policies
   * and attestation authorities.
   * This API implements a REST model with the following objects:
   * * [Policy][google.cloud.binaryauthorization.v1beta1.Policy]
   * * [Attestor][google.cloud.binaryauthorization.v1beta1.Attestor]
   * </pre>
   */
  public static final class BinauthzManagementServiceV1Beta1FutureStub
      extends io.grpc.stub.AbstractFutureStub<BinauthzManagementServiceV1Beta1FutureStub> {
    private BinauthzManagementServiceV1Beta1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BinauthzManagementServiceV1Beta1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BinauthzManagementServiceV1Beta1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * A [policy][google.cloud.binaryauthorization.v1beta1.Policy] specifies the [attestors][google.cloud.binaryauthorization.v1beta1.Attestor] that must attest to
     * a container image, before the project is allowed to deploy that
     * image. There is at most one policy per project. All image admission
     * requests are permitted if a project has no policy.
     * Gets the [policy][google.cloud.binaryauthorization.v1beta1.Policy] for this project. Returns a default
     * [policy][google.cloud.binaryauthorization.v1beta1.Policy] if the project does not have one.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.binaryauthorization.v1beta1.Policy>
        getPolicy(com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1beta1.Policy], and returns a copy of the
     * new [policy][google.cloud.binaryauthorization.v1beta1.Policy]. A policy is always updated as a whole, to avoid race
     * conditions with concurrent policy enforcement (or management!)
     * requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT
     * if the request is malformed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.binaryauthorization.v1beta1.Policy>
        updatePolicy(com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor], and returns a copy of the new
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor]. Returns NOT_FOUND if the project does not exist,
     * INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] already exists.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.binaryauthorization.v1beta1.Attestor>
        createAttestor(com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAttestorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.binaryauthorization.v1beta1.Attestor>
        getAttestor(com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttestorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.binaryauthorization.v1beta1.Attestor>
        updateAttestor(com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAttestorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [attestors][google.cloud.binaryauthorization.v1beta1.Attestor].
     * Returns INVALID_ARGUMENT if the project does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>
        listAttestors(com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAttestorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an [attestor][google.cloud.binaryauthorization.v1beta1.Attestor]. Returns NOT_FOUND if the
     * [attestor][google.cloud.binaryauthorization.v1beta1.Attestor] does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAttestor(com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAttestorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_POLICY = 0;
  private static final int METHODID_UPDATE_POLICY = 1;
  private static final int METHODID_CREATE_ATTESTOR = 2;
  private static final int METHODID_GET_ATTESTOR = 3;
  private static final int METHODID_UPDATE_ATTESTOR = 4;
  private static final int METHODID_LIST_ATTESTORS = 5;
  private static final int METHODID_DELETE_ATTESTOR = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BinauthzManagementServiceV1Beta1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BinauthzManagementServiceV1Beta1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_POLICY:
          serviceImpl.getPolicy(
              (com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Policy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_POLICY:
          serviceImpl.updatePolicy(
              (com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Policy>)
                  responseObserver);
          break;
        case METHODID_CREATE_ATTESTOR:
          serviceImpl.createAttestor(
              (com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>)
                  responseObserver);
          break;
        case METHODID_GET_ATTESTOR:
          serviceImpl.getAttestor(
              (com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ATTESTOR:
          serviceImpl.updateAttestor(
              (com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.binaryauthorization.v1beta1.Attestor>)
                  responseObserver);
          break;
        case METHODID_LIST_ATTESTORS:
          serviceImpl.listAttestors(
              (com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ATTESTOR:
          serviceImpl.deleteAttestor(
              (com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest) request,
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

  private abstract static class BinauthzManagementServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BinauthzManagementServiceV1Beta1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.binaryauthorization.v1beta1.BinaryAuthorizationServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BinauthzManagementServiceV1Beta1");
    }
  }

  private static final class BinauthzManagementServiceV1Beta1FileDescriptorSupplier
      extends BinauthzManagementServiceV1Beta1BaseDescriptorSupplier {
    BinauthzManagementServiceV1Beta1FileDescriptorSupplier() {}
  }

  private static final class BinauthzManagementServiceV1Beta1MethodDescriptorSupplier
      extends BinauthzManagementServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BinauthzManagementServiceV1Beta1MethodDescriptorSupplier(String methodName) {
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
      synchronized (BinauthzManagementServiceV1Beta1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new BinauthzManagementServiceV1Beta1FileDescriptorSupplier())
                      .addMethod(getGetPolicyMethod())
                      .addMethod(getUpdatePolicyMethod())
                      .addMethod(getCreateAttestorMethod())
                      .addMethod(getGetAttestorMethod())
                      .addMethod(getUpdateAttestorMethod())
                      .addMethod(getListAttestorsMethod())
                      .addMethod(getDeleteAttestorMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
