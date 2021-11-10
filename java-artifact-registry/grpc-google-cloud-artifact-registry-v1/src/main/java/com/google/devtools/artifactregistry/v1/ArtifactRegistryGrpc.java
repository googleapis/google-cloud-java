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
package com.google.devtools.artifactregistry.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Artifact Registry API service.
 * Artifact Registry is an artifact management system for storing artifacts
 * from different package management systems.
 * The resources managed by this API are:
 * * Repositories, which group packages and their data.
 * * Packages, which group versions and their tags.
 * * Versions, which are specific forms of a package.
 * * Tags, which represent alternative names for versions.
 * * Files, which contain content and are optionally associated with a Package
 *   or Version.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/artifactregistry/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ArtifactRegistryGrpc {

  private ArtifactRegistryGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.artifactregistry.v1.ArtifactRegistry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
          com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
      getListDockerImagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDockerImages",
      requestType = com.google.devtools.artifactregistry.v1.ListDockerImagesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListDockerImagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
          com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
      getListDockerImagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
            com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
        getListDockerImagesMethod;
    if ((getListDockerImagesMethod = ArtifactRegistryGrpc.getListDockerImagesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListDockerImagesMethod = ArtifactRegistryGrpc.getListDockerImagesMethod) == null) {
          ArtifactRegistryGrpc.getListDockerImagesMethod =
              getListDockerImagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
                          com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDockerImages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListDockerImagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListDockerImagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListDockerImages"))
                      .build();
        }
      }
    }
    return getListDockerImagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
          com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
      getListRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRepositories",
      requestType = com.google.devtools.artifactregistry.v1.ListRepositoriesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListRepositoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
          com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
      getListRepositoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
            com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
        getListRepositoriesMethod;
    if ((getListRepositoriesMethod = ArtifactRegistryGrpc.getListRepositoriesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListRepositoriesMethod = ArtifactRegistryGrpc.getListRepositoriesMethod) == null) {
          ArtifactRegistryGrpc.getListRepositoriesMethod =
              getListRepositoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
                          com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRepositories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListRepositoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListRepositoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListRepositories"))
                      .build();
        }
      }
    }
    return getListRepositoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
          com.google.devtools.artifactregistry.v1.Repository>
      getGetRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRepository",
      requestType = com.google.devtools.artifactregistry.v1.GetRepositoryRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.Repository.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
          com.google.devtools.artifactregistry.v1.Repository>
      getGetRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
            com.google.devtools.artifactregistry.v1.Repository>
        getGetRepositoryMethod;
    if ((getGetRepositoryMethod = ArtifactRegistryGrpc.getGetRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetRepositoryMethod = ArtifactRegistryGrpc.getGetRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getGetRepositoryMethod =
              getGetRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
                          com.google.devtools.artifactregistry.v1.Repository>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.Repository
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetRepository"))
                      .build();
        }
      }
    }
    return getGetRepositoryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ArtifactRegistryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryStub>() {
          @java.lang.Override
          public ArtifactRegistryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ArtifactRegistryStub(channel, callOptions);
          }
        };
    return ArtifactRegistryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArtifactRegistryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryBlockingStub>() {
          @java.lang.Override
          public ArtifactRegistryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ArtifactRegistryBlockingStub(channel, callOptions);
          }
        };
    return ArtifactRegistryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ArtifactRegistryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryFutureStub>() {
          @java.lang.Override
          public ArtifactRegistryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ArtifactRegistryFutureStub(channel, callOptions);
          }
        };
    return ArtifactRegistryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Artifact Registry API service.
   * Artifact Registry is an artifact management system for storing artifacts
   * from different package management systems.
   * The resources managed by this API are:
   * * Repositories, which group packages and their data.
   * * Packages, which group versions and their tags.
   * * Versions, which are specific forms of a package.
   * * Tags, which represent alternative names for versions.
   * * Files, which contain content and are optionally associated with a Package
   *   or Version.
   * </pre>
   */
  public abstract static class ArtifactRegistryImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists docker images.
     * </pre>
     */
    public void listDockerImages(
        com.google.devtools.artifactregistry.v1.ListDockerImagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDockerImagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists repositories.
     * </pre>
     */
    public void listRepositories(
        com.google.devtools.artifactregistry.v1.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRepositoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a repository.
     * </pre>
     */
    public void getRepository(
        com.google.devtools.artifactregistry.v1.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRepositoryMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListDockerImagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
                      com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>(
                      this, METHODID_LIST_DOCKER_IMAGES)))
          .addMethod(
              getListRepositoriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
                      com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>(
                      this, METHODID_LIST_REPOSITORIES)))
          .addMethod(
              getGetRepositoryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
                      com.google.devtools.artifactregistry.v1.Repository>(
                      this, METHODID_GET_REPOSITORY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Artifact Registry API service.
   * Artifact Registry is an artifact management system for storing artifacts
   * from different package management systems.
   * The resources managed by this API are:
   * * Repositories, which group packages and their data.
   * * Packages, which group versions and their tags.
   * * Versions, which are specific forms of a package.
   * * Tags, which represent alternative names for versions.
   * * Files, which contain content and are optionally associated with a Package
   *   or Version.
   * </pre>
   */
  public static final class ArtifactRegistryStub
      extends io.grpc.stub.AbstractAsyncStub<ArtifactRegistryStub> {
    private ArtifactRegistryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArtifactRegistryStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArtifactRegistryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists docker images.
     * </pre>
     */
    public void listDockerImages(
        com.google.devtools.artifactregistry.v1.ListDockerImagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDockerImagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists repositories.
     * </pre>
     */
    public void listRepositories(
        com.google.devtools.artifactregistry.v1.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a repository.
     * </pre>
     */
    public void getRepository(
        com.google.devtools.artifactregistry.v1.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Artifact Registry API service.
   * Artifact Registry is an artifact management system for storing artifacts
   * from different package management systems.
   * The resources managed by this API are:
   * * Repositories, which group packages and their data.
   * * Packages, which group versions and their tags.
   * * Versions, which are specific forms of a package.
   * * Tags, which represent alternative names for versions.
   * * Files, which contain content and are optionally associated with a Package
   *   or Version.
   * </pre>
   */
  public static final class ArtifactRegistryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ArtifactRegistryBlockingStub> {
    private ArtifactRegistryBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArtifactRegistryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArtifactRegistryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists docker images.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.ListDockerImagesResponse listDockerImages(
        com.google.devtools.artifactregistry.v1.ListDockerImagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDockerImagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists repositories.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.ListRepositoriesResponse listRepositories(
        com.google.devtools.artifactregistry.v1.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a repository.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.Repository getRepository(
        com.google.devtools.artifactregistry.v1.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRepositoryMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Artifact Registry API service.
   * Artifact Registry is an artifact management system for storing artifacts
   * from different package management systems.
   * The resources managed by this API are:
   * * Repositories, which group packages and their data.
   * * Packages, which group versions and their tags.
   * * Versions, which are specific forms of a package.
   * * Tags, which represent alternative names for versions.
   * * Files, which contain content and are optionally associated with a Package
   *   or Version.
   * </pre>
   */
  public static final class ArtifactRegistryFutureStub
      extends io.grpc.stub.AbstractFutureStub<ArtifactRegistryFutureStub> {
    private ArtifactRegistryFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArtifactRegistryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArtifactRegistryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists docker images.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
        listDockerImages(com.google.devtools.artifactregistry.v1.ListDockerImagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDockerImagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists repositories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
        listRepositories(com.google.devtools.artifactregistry.v1.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.Repository>
        getRepository(com.google.devtools.artifactregistry.v1.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DOCKER_IMAGES = 0;
  private static final int METHODID_LIST_REPOSITORIES = 1;
  private static final int METHODID_GET_REPOSITORY = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ArtifactRegistryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ArtifactRegistryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_DOCKER_IMAGES:
          serviceImpl.listDockerImages(
              (com.google.devtools.artifactregistry.v1.ListDockerImagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_REPOSITORIES:
          serviceImpl.listRepositories(
              (com.google.devtools.artifactregistry.v1.ListRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPOSITORY:
          serviceImpl.getRepository(
              (com.google.devtools.artifactregistry.v1.GetRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>)
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

  private abstract static class ArtifactRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArtifactRegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.artifactregistry.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ArtifactRegistry");
    }
  }

  private static final class ArtifactRegistryFileDescriptorSupplier
      extends ArtifactRegistryBaseDescriptorSupplier {
    ArtifactRegistryFileDescriptorSupplier() {}
  }

  private static final class ArtifactRegistryMethodDescriptorSupplier
      extends ArtifactRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ArtifactRegistryMethodDescriptorSupplier(String methodName) {
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
      synchronized (ArtifactRegistryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ArtifactRegistryFileDescriptorSupplier())
                      .addMethod(getListDockerImagesMethod())
                      .addMethod(getListRepositoriesMethod())
                      .addMethod(getGetRepositoryMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
