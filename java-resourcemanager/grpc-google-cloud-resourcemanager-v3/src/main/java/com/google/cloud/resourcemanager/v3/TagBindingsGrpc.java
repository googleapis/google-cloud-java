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
package com.google.cloud.resourcemanager.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Allow users to create and manage TagBindings between TagValues and
 * different cloud resources throughout the GCP resource hierarchy.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/resourcemanager/v3/tag_bindings.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TagBindingsGrpc {

  private TagBindingsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.resourcemanager.v3.TagBindings";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListTagBindingsRequest,
          com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>
      getListTagBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTagBindings",
      requestType = com.google.cloud.resourcemanager.v3.ListTagBindingsRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.ListTagBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListTagBindingsRequest,
          com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>
      getListTagBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.ListTagBindingsRequest,
            com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>
        getListTagBindingsMethod;
    if ((getListTagBindingsMethod = TagBindingsGrpc.getListTagBindingsMethod) == null) {
      synchronized (TagBindingsGrpc.class) {
        if ((getListTagBindingsMethod = TagBindingsGrpc.getListTagBindingsMethod) == null) {
          TagBindingsGrpc.getListTagBindingsMethod =
              getListTagBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.ListTagBindingsRequest,
                          com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTagBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListTagBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListTagBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TagBindingsMethodDescriptorSupplier("ListTagBindings"))
                      .build();
        }
      }
    }
    return getListTagBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateTagBindingRequest,
          com.google.longrunning.Operation>
      getCreateTagBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTagBinding",
      requestType = com.google.cloud.resourcemanager.v3.CreateTagBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateTagBindingRequest,
          com.google.longrunning.Operation>
      getCreateTagBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.CreateTagBindingRequest,
            com.google.longrunning.Operation>
        getCreateTagBindingMethod;
    if ((getCreateTagBindingMethod = TagBindingsGrpc.getCreateTagBindingMethod) == null) {
      synchronized (TagBindingsGrpc.class) {
        if ((getCreateTagBindingMethod = TagBindingsGrpc.getCreateTagBindingMethod) == null) {
          TagBindingsGrpc.getCreateTagBindingMethod =
              getCreateTagBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.CreateTagBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTagBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.CreateTagBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TagBindingsMethodDescriptorSupplier("CreateTagBinding"))
                      .build();
        }
      }
    }
    return getCreateTagBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest,
          com.google.longrunning.Operation>
      getDeleteTagBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTagBinding",
      requestType = com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest,
          com.google.longrunning.Operation>
      getDeleteTagBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest,
            com.google.longrunning.Operation>
        getDeleteTagBindingMethod;
    if ((getDeleteTagBindingMethod = TagBindingsGrpc.getDeleteTagBindingMethod) == null) {
      synchronized (TagBindingsGrpc.class) {
        if ((getDeleteTagBindingMethod = TagBindingsGrpc.getDeleteTagBindingMethod) == null) {
          TagBindingsGrpc.getDeleteTagBindingMethod =
              getDeleteTagBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTagBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TagBindingsMethodDescriptorSupplier("DeleteTagBinding"))
                      .build();
        }
      }
    }
    return getDeleteTagBindingMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TagBindingsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagBindingsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagBindingsStub>() {
          @java.lang.Override
          public TagBindingsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagBindingsStub(channel, callOptions);
          }
        };
    return TagBindingsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TagBindingsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagBindingsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagBindingsBlockingStub>() {
          @java.lang.Override
          public TagBindingsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagBindingsBlockingStub(channel, callOptions);
          }
        };
    return TagBindingsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TagBindingsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagBindingsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagBindingsFutureStub>() {
          @java.lang.Override
          public TagBindingsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagBindingsFutureStub(channel, callOptions);
          }
        };
    return TagBindingsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Allow users to create and manage TagBindings between TagValues and
   * different cloud resources throughout the GCP resource hierarchy.
   * </pre>
   */
  public abstract static class TagBindingsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists the TagBindings for the given cloud resource, as specified with
     * `parent`.
     * NOTE: The `parent` field is expected to be a full resource name:
     * https://cloud.google.com/apis/design/resource_names#full_resource_name
     * </pre>
     */
    public void listTagBindings(
        com.google.cloud.resourcemanager.v3.ListTagBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTagBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a TagBinding between a TagValue and a cloud resource
     * (currently project, folder, or organization).
     * </pre>
     */
    public void createTagBinding(
        com.google.cloud.resourcemanager.v3.CreateTagBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTagBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagBinding.
     * </pre>
     */
    public void deleteTagBinding(
        com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTagBindingMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListTagBindingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.ListTagBindingsRequest,
                      com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>(
                      this, METHODID_LIST_TAG_BINDINGS)))
          .addMethod(
              getCreateTagBindingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.CreateTagBindingRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_TAG_BINDING)))
          .addMethod(
              getDeleteTagBindingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_TAG_BINDING)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Allow users to create and manage TagBindings between TagValues and
   * different cloud resources throughout the GCP resource hierarchy.
   * </pre>
   */
  public static final class TagBindingsStub
      extends io.grpc.stub.AbstractAsyncStub<TagBindingsStub> {
    private TagBindingsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagBindingsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagBindingsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the TagBindings for the given cloud resource, as specified with
     * `parent`.
     * NOTE: The `parent` field is expected to be a full resource name:
     * https://cloud.google.com/apis/design/resource_names#full_resource_name
     * </pre>
     */
    public void listTagBindings(
        com.google.cloud.resourcemanager.v3.ListTagBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTagBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a TagBinding between a TagValue and a cloud resource
     * (currently project, folder, or organization).
     * </pre>
     */
    public void createTagBinding(
        com.google.cloud.resourcemanager.v3.CreateTagBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagBinding.
     * </pre>
     */
    public void deleteTagBinding(
        com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Allow users to create and manage TagBindings between TagValues and
   * different cloud resources throughout the GCP resource hierarchy.
   * </pre>
   */
  public static final class TagBindingsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TagBindingsBlockingStub> {
    private TagBindingsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagBindingsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagBindingsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the TagBindings for the given cloud resource, as specified with
     * `parent`.
     * NOTE: The `parent` field is expected to be a full resource name:
     * https://cloud.google.com/apis/design/resource_names#full_resource_name
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.ListTagBindingsResponse listTagBindings(
        com.google.cloud.resourcemanager.v3.ListTagBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTagBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a TagBinding between a TagValue and a cloud resource
     * (currently project, folder, or organization).
     * </pre>
     */
    public com.google.longrunning.Operation createTagBinding(
        com.google.cloud.resourcemanager.v3.CreateTagBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagBinding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTagBinding(
        com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagBindingMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Allow users to create and manage TagBindings between TagValues and
   * different cloud resources throughout the GCP resource hierarchy.
   * </pre>
   */
  public static final class TagBindingsFutureStub
      extends io.grpc.stub.AbstractFutureStub<TagBindingsFutureStub> {
    private TagBindingsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagBindingsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagBindingsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the TagBindings for the given cloud resource, as specified with
     * `parent`.
     * NOTE: The `parent` field is expected to be a full resource name:
     * https://cloud.google.com/apis/design/resource_names#full_resource_name
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>
        listTagBindings(com.google.cloud.resourcemanager.v3.ListTagBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTagBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a TagBinding between a TagValue and a cloud resource
     * (currently project, folder, or organization).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTagBinding(com.google.cloud.resourcemanager.v3.CreateTagBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTagBinding(com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagBindingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_TAG_BINDINGS = 0;
  private static final int METHODID_CREATE_TAG_BINDING = 1;
  private static final int METHODID_DELETE_TAG_BINDING = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TagBindingsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TagBindingsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_TAG_BINDINGS:
          serviceImpl.listTagBindings(
              (com.google.cloud.resourcemanager.v3.ListTagBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.resourcemanager.v3.ListTagBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TAG_BINDING:
          serviceImpl.createTagBinding(
              (com.google.cloud.resourcemanager.v3.CreateTagBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TAG_BINDING:
          serviceImpl.deleteTagBinding(
              (com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest) request,
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

  private abstract static class TagBindingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TagBindingsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.resourcemanager.v3.TagBindingsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TagBindings");
    }
  }

  private static final class TagBindingsFileDescriptorSupplier
      extends TagBindingsBaseDescriptorSupplier {
    TagBindingsFileDescriptorSupplier() {}
  }

  private static final class TagBindingsMethodDescriptorSupplier
      extends TagBindingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TagBindingsMethodDescriptorSupplier(String methodName) {
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
      synchronized (TagBindingsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TagBindingsFileDescriptorSupplier())
                      .addMethod(getListTagBindingsMethod())
                      .addMethod(getCreateTagBindingMethod())
                      .addMethod(getDeleteTagBindingMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
