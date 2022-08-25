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
package com.google.cloud.shell.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * API for interacting with Google Cloud Shell. Each user of Cloud Shell has at
 * least one environment, which has the ID "default". Environment consists of a
 * Docker image defining what is installed on the environment and a home
 * directory containing the user's data that will remain across sessions.
 * Clients use this API to start and fetch information about their environment,
 * which can then be used to connect to that environment via a separate SSH
 * client.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/shell/v1/cloudshell.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudShellServiceGrpc {

  private CloudShellServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.shell.v1.CloudShellService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.GetEnvironmentRequest, com.google.cloud.shell.v1.Environment>
      getGetEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnvironment",
      requestType = com.google.cloud.shell.v1.GetEnvironmentRequest.class,
      responseType = com.google.cloud.shell.v1.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.GetEnvironmentRequest, com.google.cloud.shell.v1.Environment>
      getGetEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.shell.v1.GetEnvironmentRequest, com.google.cloud.shell.v1.Environment>
        getGetEnvironmentMethod;
    if ((getGetEnvironmentMethod = CloudShellServiceGrpc.getGetEnvironmentMethod) == null) {
      synchronized (CloudShellServiceGrpc.class) {
        if ((getGetEnvironmentMethod = CloudShellServiceGrpc.getGetEnvironmentMethod) == null) {
          CloudShellServiceGrpc.getGetEnvironmentMethod =
              getGetEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.shell.v1.GetEnvironmentRequest,
                          com.google.cloud.shell.v1.Environment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.shell.v1.GetEnvironmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.shell.v1.Environment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudShellServiceMethodDescriptorSupplier("GetEnvironment"))
                      .build();
        }
      }
    }
    return getGetEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.StartEnvironmentRequest, com.google.longrunning.Operation>
      getStartEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartEnvironment",
      requestType = com.google.cloud.shell.v1.StartEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.StartEnvironmentRequest, com.google.longrunning.Operation>
      getStartEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.shell.v1.StartEnvironmentRequest, com.google.longrunning.Operation>
        getStartEnvironmentMethod;
    if ((getStartEnvironmentMethod = CloudShellServiceGrpc.getStartEnvironmentMethod) == null) {
      synchronized (CloudShellServiceGrpc.class) {
        if ((getStartEnvironmentMethod = CloudShellServiceGrpc.getStartEnvironmentMethod) == null) {
          CloudShellServiceGrpc.getStartEnvironmentMethod =
              getStartEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.shell.v1.StartEnvironmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.shell.v1.StartEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudShellServiceMethodDescriptorSupplier("StartEnvironment"))
                      .build();
        }
      }
    }
    return getStartEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.AuthorizeEnvironmentRequest, com.google.longrunning.Operation>
      getAuthorizeEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AuthorizeEnvironment",
      requestType = com.google.cloud.shell.v1.AuthorizeEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.AuthorizeEnvironmentRequest, com.google.longrunning.Operation>
      getAuthorizeEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.shell.v1.AuthorizeEnvironmentRequest, com.google.longrunning.Operation>
        getAuthorizeEnvironmentMethod;
    if ((getAuthorizeEnvironmentMethod = CloudShellServiceGrpc.getAuthorizeEnvironmentMethod)
        == null) {
      synchronized (CloudShellServiceGrpc.class) {
        if ((getAuthorizeEnvironmentMethod = CloudShellServiceGrpc.getAuthorizeEnvironmentMethod)
            == null) {
          CloudShellServiceGrpc.getAuthorizeEnvironmentMethod =
              getAuthorizeEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.shell.v1.AuthorizeEnvironmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AuthorizeEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.shell.v1.AuthorizeEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudShellServiceMethodDescriptorSupplier("AuthorizeEnvironment"))
                      .build();
        }
      }
    }
    return getAuthorizeEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.AddPublicKeyRequest, com.google.longrunning.Operation>
      getAddPublicKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPublicKey",
      requestType = com.google.cloud.shell.v1.AddPublicKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.AddPublicKeyRequest, com.google.longrunning.Operation>
      getAddPublicKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.shell.v1.AddPublicKeyRequest, com.google.longrunning.Operation>
        getAddPublicKeyMethod;
    if ((getAddPublicKeyMethod = CloudShellServiceGrpc.getAddPublicKeyMethod) == null) {
      synchronized (CloudShellServiceGrpc.class) {
        if ((getAddPublicKeyMethod = CloudShellServiceGrpc.getAddPublicKeyMethod) == null) {
          CloudShellServiceGrpc.getAddPublicKeyMethod =
              getAddPublicKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.shell.v1.AddPublicKeyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddPublicKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.shell.v1.AddPublicKeyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudShellServiceMethodDescriptorSupplier("AddPublicKey"))
                      .build();
        }
      }
    }
    return getAddPublicKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.RemovePublicKeyRequest, com.google.longrunning.Operation>
      getRemovePublicKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemovePublicKey",
      requestType = com.google.cloud.shell.v1.RemovePublicKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.shell.v1.RemovePublicKeyRequest, com.google.longrunning.Operation>
      getRemovePublicKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.shell.v1.RemovePublicKeyRequest, com.google.longrunning.Operation>
        getRemovePublicKeyMethod;
    if ((getRemovePublicKeyMethod = CloudShellServiceGrpc.getRemovePublicKeyMethod) == null) {
      synchronized (CloudShellServiceGrpc.class) {
        if ((getRemovePublicKeyMethod = CloudShellServiceGrpc.getRemovePublicKeyMethod) == null) {
          CloudShellServiceGrpc.getRemovePublicKeyMethod =
              getRemovePublicKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.shell.v1.RemovePublicKeyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemovePublicKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.shell.v1.RemovePublicKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudShellServiceMethodDescriptorSupplier("RemovePublicKey"))
                      .build();
        }
      }
    }
    return getRemovePublicKeyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudShellServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudShellServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudShellServiceStub>() {
          @java.lang.Override
          public CloudShellServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudShellServiceStub(channel, callOptions);
          }
        };
    return CloudShellServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudShellServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudShellServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudShellServiceBlockingStub>() {
          @java.lang.Override
          public CloudShellServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudShellServiceBlockingStub(channel, callOptions);
          }
        };
    return CloudShellServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudShellServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudShellServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudShellServiceFutureStub>() {
          @java.lang.Override
          public CloudShellServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudShellServiceFutureStub(channel, callOptions);
          }
        };
    return CloudShellServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * API for interacting with Google Cloud Shell. Each user of Cloud Shell has at
   * least one environment, which has the ID "default". Environment consists of a
   * Docker image defining what is installed on the environment and a home
   * directory containing the user's data that will remain across sessions.
   * Clients use this API to start and fetch information about their environment,
   * which can then be used to connect to that environment via a separate SSH
   * client.
   * </pre>
   */
  public abstract static class CloudShellServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets an environment. Returns NOT_FOUND if the environment does not exist.
     * </pre>
     */
    public void getEnvironment(
        com.google.cloud.shell.v1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.shell.v1.Environment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts an existing environment, allowing clients to connect to it. The
     * returned operation will contain an instance of StartEnvironmentMetadata in
     * its metadata field. Users can wait for the environment to start by polling
     * this operation via GetOperation. Once the environment has finished starting
     * and is ready to accept connections, the operation will contain a
     * StartEnvironmentResponse in its response field.
     * </pre>
     */
    public void startEnvironment(
        com.google.cloud.shell.v1.StartEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sends OAuth credentials to a running environment on behalf of a user. When
     * this completes, the environment will be authorized to run various Google
     * Cloud command line tools without requiring the user to manually
     * authenticate.
     * </pre>
     */
    public void authorizeEnvironment(
        com.google.cloud.shell.v1.AuthorizeEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAuthorizeEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a public SSH key to an environment, allowing clients with the
     * corresponding private key to connect to that environment via SSH. If a key
     * with the same content already exists, this will error with ALREADY_EXISTS.
     * </pre>
     */
    public void addPublicKey(
        com.google.cloud.shell.v1.AddPublicKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddPublicKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a public SSH key from an environment. Clients will no longer be
     * able to connect to the environment using the corresponding private key.
     * If a key with the same content is not present, this will error with
     * NOT_FOUND.
     * </pre>
     */
    public void removePublicKey(
        com.google.cloud.shell.v1.RemovePublicKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemovePublicKeyMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetEnvironmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.shell.v1.GetEnvironmentRequest,
                      com.google.cloud.shell.v1.Environment>(this, METHODID_GET_ENVIRONMENT)))
          .addMethod(
              getStartEnvironmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.shell.v1.StartEnvironmentRequest,
                      com.google.longrunning.Operation>(this, METHODID_START_ENVIRONMENT)))
          .addMethod(
              getAuthorizeEnvironmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.shell.v1.AuthorizeEnvironmentRequest,
                      com.google.longrunning.Operation>(this, METHODID_AUTHORIZE_ENVIRONMENT)))
          .addMethod(
              getAddPublicKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.shell.v1.AddPublicKeyRequest,
                      com.google.longrunning.Operation>(this, METHODID_ADD_PUBLIC_KEY)))
          .addMethod(
              getRemovePublicKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.shell.v1.RemovePublicKeyRequest,
                      com.google.longrunning.Operation>(this, METHODID_REMOVE_PUBLIC_KEY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * API for interacting with Google Cloud Shell. Each user of Cloud Shell has at
   * least one environment, which has the ID "default". Environment consists of a
   * Docker image defining what is installed on the environment and a home
   * directory containing the user's data that will remain across sessions.
   * Clients use this API to start and fetch information about their environment,
   * which can then be used to connect to that environment via a separate SSH
   * client.
   * </pre>
   */
  public static final class CloudShellServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CloudShellServiceStub> {
    private CloudShellServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudShellServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudShellServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets an environment. Returns NOT_FOUND if the environment does not exist.
     * </pre>
     */
    public void getEnvironment(
        com.google.cloud.shell.v1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.shell.v1.Environment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts an existing environment, allowing clients to connect to it. The
     * returned operation will contain an instance of StartEnvironmentMetadata in
     * its metadata field. Users can wait for the environment to start by polling
     * this operation via GetOperation. Once the environment has finished starting
     * and is ready to accept connections, the operation will contain a
     * StartEnvironmentResponse in its response field.
     * </pre>
     */
    public void startEnvironment(
        com.google.cloud.shell.v1.StartEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sends OAuth credentials to a running environment on behalf of a user. When
     * this completes, the environment will be authorized to run various Google
     * Cloud command line tools without requiring the user to manually
     * authenticate.
     * </pre>
     */
    public void authorizeEnvironment(
        com.google.cloud.shell.v1.AuthorizeEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuthorizeEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a public SSH key to an environment, allowing clients with the
     * corresponding private key to connect to that environment via SSH. If a key
     * with the same content already exists, this will error with ALREADY_EXISTS.
     * </pre>
     */
    public void addPublicKey(
        com.google.cloud.shell.v1.AddPublicKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddPublicKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a public SSH key from an environment. Clients will no longer be
     * able to connect to the environment using the corresponding private key.
     * If a key with the same content is not present, this will error with
     * NOT_FOUND.
     * </pre>
     */
    public void removePublicKey(
        com.google.cloud.shell.v1.RemovePublicKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemovePublicKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * API for interacting with Google Cloud Shell. Each user of Cloud Shell has at
   * least one environment, which has the ID "default". Environment consists of a
   * Docker image defining what is installed on the environment and a home
   * directory containing the user's data that will remain across sessions.
   * Clients use this API to start and fetch information about their environment,
   * which can then be used to connect to that environment via a separate SSH
   * client.
   * </pre>
   */
  public static final class CloudShellServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudShellServiceBlockingStub> {
    private CloudShellServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudShellServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudShellServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets an environment. Returns NOT_FOUND if the environment does not exist.
     * </pre>
     */
    public com.google.cloud.shell.v1.Environment getEnvironment(
        com.google.cloud.shell.v1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts an existing environment, allowing clients to connect to it. The
     * returned operation will contain an instance of StartEnvironmentMetadata in
     * its metadata field. Users can wait for the environment to start by polling
     * this operation via GetOperation. Once the environment has finished starting
     * and is ready to accept connections, the operation will contain a
     * StartEnvironmentResponse in its response field.
     * </pre>
     */
    public com.google.longrunning.Operation startEnvironment(
        com.google.cloud.shell.v1.StartEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sends OAuth credentials to a running environment on behalf of a user. When
     * this completes, the environment will be authorized to run various Google
     * Cloud command line tools without requiring the user to manually
     * authenticate.
     * </pre>
     */
    public com.google.longrunning.Operation authorizeEnvironment(
        com.google.cloud.shell.v1.AuthorizeEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuthorizeEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a public SSH key to an environment, allowing clients with the
     * corresponding private key to connect to that environment via SSH. If a key
     * with the same content already exists, this will error with ALREADY_EXISTS.
     * </pre>
     */
    public com.google.longrunning.Operation addPublicKey(
        com.google.cloud.shell.v1.AddPublicKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddPublicKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a public SSH key from an environment. Clients will no longer be
     * able to connect to the environment using the corresponding private key.
     * If a key with the same content is not present, this will error with
     * NOT_FOUND.
     * </pre>
     */
    public com.google.longrunning.Operation removePublicKey(
        com.google.cloud.shell.v1.RemovePublicKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemovePublicKeyMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * API for interacting with Google Cloud Shell. Each user of Cloud Shell has at
   * least one environment, which has the ID "default". Environment consists of a
   * Docker image defining what is installed on the environment and a home
   * directory containing the user's data that will remain across sessions.
   * Clients use this API to start and fetch information about their environment,
   * which can then be used to connect to that environment via a separate SSH
   * client.
   * </pre>
   */
  public static final class CloudShellServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudShellServiceFutureStub> {
    private CloudShellServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudShellServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudShellServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets an environment. Returns NOT_FOUND if the environment does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.shell.v1.Environment>
        getEnvironment(com.google.cloud.shell.v1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts an existing environment, allowing clients to connect to it. The
     * returned operation will contain an instance of StartEnvironmentMetadata in
     * its metadata field. Users can wait for the environment to start by polling
     * this operation via GetOperation. Once the environment has finished starting
     * and is ready to accept connections, the operation will contain a
     * StartEnvironmentResponse in its response field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startEnvironment(com.google.cloud.shell.v1.StartEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sends OAuth credentials to a running environment on behalf of a user. When
     * this completes, the environment will be authorized to run various Google
     * Cloud command line tools without requiring the user to manually
     * authenticate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        authorizeEnvironment(com.google.cloud.shell.v1.AuthorizeEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuthorizeEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a public SSH key to an environment, allowing clients with the
     * corresponding private key to connect to that environment via SSH. If a key
     * with the same content already exists, this will error with ALREADY_EXISTS.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addPublicKey(com.google.cloud.shell.v1.AddPublicKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddPublicKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a public SSH key from an environment. Clients will no longer be
     * able to connect to the environment using the corresponding private key.
     * If a key with the same content is not present, this will error with
     * NOT_FOUND.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removePublicKey(com.google.cloud.shell.v1.RemovePublicKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemovePublicKeyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ENVIRONMENT = 0;
  private static final int METHODID_START_ENVIRONMENT = 1;
  private static final int METHODID_AUTHORIZE_ENVIRONMENT = 2;
  private static final int METHODID_ADD_PUBLIC_KEY = 3;
  private static final int METHODID_REMOVE_PUBLIC_KEY = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudShellServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudShellServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ENVIRONMENT:
          serviceImpl.getEnvironment(
              (com.google.cloud.shell.v1.GetEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.shell.v1.Environment>)
                  responseObserver);
          break;
        case METHODID_START_ENVIRONMENT:
          serviceImpl.startEnvironment(
              (com.google.cloud.shell.v1.StartEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_AUTHORIZE_ENVIRONMENT:
          serviceImpl.authorizeEnvironment(
              (com.google.cloud.shell.v1.AuthorizeEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_PUBLIC_KEY:
          serviceImpl.addPublicKey(
              (com.google.cloud.shell.v1.AddPublicKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_PUBLIC_KEY:
          serviceImpl.removePublicKey(
              (com.google.cloud.shell.v1.RemovePublicKeyRequest) request,
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

  private abstract static class CloudShellServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudShellServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.shell.v1.CloudShellProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudShellService");
    }
  }

  private static final class CloudShellServiceFileDescriptorSupplier
      extends CloudShellServiceBaseDescriptorSupplier {
    CloudShellServiceFileDescriptorSupplier() {}
  }

  private static final class CloudShellServiceMethodDescriptorSupplier
      extends CloudShellServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudShellServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudShellServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudShellServiceFileDescriptorSupplier())
                      .addMethod(getGetEnvironmentMethod())
                      .addMethod(getStartEnvironmentMethod())
                      .addMethod(getAuthorizeEnvironmentMethod())
                      .addMethod(getAddPublicKeyMethod())
                      .addMethod(getRemovePublicKeyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
