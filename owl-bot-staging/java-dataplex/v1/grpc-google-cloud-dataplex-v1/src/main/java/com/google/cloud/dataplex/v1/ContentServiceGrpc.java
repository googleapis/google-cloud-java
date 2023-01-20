package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ContentService manages Notebook and SQL Scripts for Dataplex.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/content.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContentServiceGrpc {

  private ContentServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataplex.v1.ContentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateContentRequest,
      com.google.cloud.dataplex.v1.Content> getCreateContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateContent",
      requestType = com.google.cloud.dataplex.v1.CreateContentRequest.class,
      responseType = com.google.cloud.dataplex.v1.Content.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateContentRequest,
      com.google.cloud.dataplex.v1.Content> getCreateContentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateContentRequest, com.google.cloud.dataplex.v1.Content> getCreateContentMethod;
    if ((getCreateContentMethod = ContentServiceGrpc.getCreateContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getCreateContentMethod = ContentServiceGrpc.getCreateContentMethod) == null) {
          ContentServiceGrpc.getCreateContentMethod = getCreateContentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateContentRequest, com.google.cloud.dataplex.v1.Content>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Content.getDefaultInstance()))
              .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("CreateContent"))
              .build();
        }
      }
    }
    return getCreateContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateContentRequest,
      com.google.cloud.dataplex.v1.Content> getUpdateContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateContent",
      requestType = com.google.cloud.dataplex.v1.UpdateContentRequest.class,
      responseType = com.google.cloud.dataplex.v1.Content.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateContentRequest,
      com.google.cloud.dataplex.v1.Content> getUpdateContentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateContentRequest, com.google.cloud.dataplex.v1.Content> getUpdateContentMethod;
    if ((getUpdateContentMethod = ContentServiceGrpc.getUpdateContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getUpdateContentMethod = ContentServiceGrpc.getUpdateContentMethod) == null) {
          ContentServiceGrpc.getUpdateContentMethod = getUpdateContentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateContentRequest, com.google.cloud.dataplex.v1.Content>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Content.getDefaultInstance()))
              .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("UpdateContent"))
              .build();
        }
      }
    }
    return getUpdateContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteContentRequest,
      com.google.protobuf.Empty> getDeleteContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteContent",
      requestType = com.google.cloud.dataplex.v1.DeleteContentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteContentRequest,
      com.google.protobuf.Empty> getDeleteContentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteContentRequest, com.google.protobuf.Empty> getDeleteContentMethod;
    if ((getDeleteContentMethod = ContentServiceGrpc.getDeleteContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getDeleteContentMethod = ContentServiceGrpc.getDeleteContentMethod) == null) {
          ContentServiceGrpc.getDeleteContentMethod = getDeleteContentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteContentRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("DeleteContent"))
              .build();
        }
      }
    }
    return getDeleteContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetContentRequest,
      com.google.cloud.dataplex.v1.Content> getGetContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetContent",
      requestType = com.google.cloud.dataplex.v1.GetContentRequest.class,
      responseType = com.google.cloud.dataplex.v1.Content.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetContentRequest,
      com.google.cloud.dataplex.v1.Content> getGetContentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetContentRequest, com.google.cloud.dataplex.v1.Content> getGetContentMethod;
    if ((getGetContentMethod = ContentServiceGrpc.getGetContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getGetContentMethod = ContentServiceGrpc.getGetContentMethod) == null) {
          ContentServiceGrpc.getGetContentMethod = getGetContentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetContentRequest, com.google.cloud.dataplex.v1.Content>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Content.getDefaultInstance()))
              .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("GetContent"))
              .build();
        }
      }
    }
    return getGetContentMethod;
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
    if ((getGetIamPolicyMethod = ContentServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getGetIamPolicyMethod = ContentServiceGrpc.getGetIamPolicyMethod) == null) {
          ContentServiceGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
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
    if ((getSetIamPolicyMethod = ContentServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getSetIamPolicyMethod = ContentServiceGrpc.getSetIamPolicyMethod) == null) {
          ContentServiceGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
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
    if ((getTestIamPermissionsMethod = ContentServiceGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getTestIamPermissionsMethod = ContentServiceGrpc.getTestIamPermissionsMethod) == null) {
          ContentServiceGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListContentRequest,
      com.google.cloud.dataplex.v1.ListContentResponse> getListContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListContent",
      requestType = com.google.cloud.dataplex.v1.ListContentRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListContentRequest,
      com.google.cloud.dataplex.v1.ListContentResponse> getListContentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListContentRequest, com.google.cloud.dataplex.v1.ListContentResponse> getListContentMethod;
    if ((getListContentMethod = ContentServiceGrpc.getListContentMethod) == null) {
      synchronized (ContentServiceGrpc.class) {
        if ((getListContentMethod = ContentServiceGrpc.getListContentMethod) == null) {
          ContentServiceGrpc.getListContentMethod = getListContentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListContentRequest, com.google.cloud.dataplex.v1.ListContentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListContentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContentServiceMethodDescriptorSupplier("ListContent"))
              .build();
        }
      }
    }
    return getListContentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ContentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContentServiceStub>() {
        @java.lang.Override
        public ContentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContentServiceStub(channel, callOptions);
        }
      };
    return ContentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContentServiceBlockingStub>() {
        @java.lang.Override
        public ContentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContentServiceBlockingStub(channel, callOptions);
        }
      };
    return ContentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ContentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContentServiceFutureStub>() {
        @java.lang.Override
        public ContentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContentServiceFutureStub(channel, callOptions);
        }
      };
    return ContentServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex.
   * </pre>
   */
  public static abstract class ContentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Create a content.
     * </pre>
     */
    public void createContent(com.google.cloud.dataplex.v1.CreateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateContentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update a content. Only supports full resource update.
     * </pre>
     */
    public void updateContent(com.google.cloud.dataplex.v1.UpdateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateContentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete a content.
     * </pre>
     */
    public void deleteContent(com.google.cloud.dataplex.v1.DeleteContentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteContentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a content resource.
     * </pre>
     */
    public void getContent(com.google.cloud.dataplex.v1.GetContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetContentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a contentitem resource. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * Caller must have Google IAM `dataplex.content.getIamPolicy` permission
     * on the resource.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified contentitem resource.
     * Replaces any existing policy.
     * Caller must have Google IAM `dataplex.content.setIamPolicy` permission
     * on the resource.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the caller's permissions on a resource.
     * If the resource does not exist, an empty set of
     * permissions is returned (a `NOT_FOUND` error is not returned).
     * A caller is not required to have Google IAM permission to make this
     * request.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * List content.
     * </pre>
     */
    public void listContent(com.google.cloud.dataplex.v1.ListContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListContentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListContentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.CreateContentRequest,
                com.google.cloud.dataplex.v1.Content>(
                  this, METHODID_CREATE_CONTENT)))
          .addMethod(
            getUpdateContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.UpdateContentRequest,
                com.google.cloud.dataplex.v1.Content>(
                  this, METHODID_UPDATE_CONTENT)))
          .addMethod(
            getDeleteContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.DeleteContentRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_CONTENT)))
          .addMethod(
            getGetContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.GetContentRequest,
                com.google.cloud.dataplex.v1.Content>(
                  this, METHODID_GET_CONTENT)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
            getListContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListContentRequest,
                com.google.cloud.dataplex.v1.ListContentResponse>(
                  this, METHODID_LIST_CONTENT)))
          .build();
    }
  }

  /**
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex.
   * </pre>
   */
  public static final class ContentServiceStub extends io.grpc.stub.AbstractAsyncStub<ContentServiceStub> {
    private ContentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a content.
     * </pre>
     */
    public void createContent(com.google.cloud.dataplex.v1.CreateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateContentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update a content. Only supports full resource update.
     * </pre>
     */
    public void updateContent(com.google.cloud.dataplex.v1.UpdateContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateContentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete a content.
     * </pre>
     */
    public void deleteContent(com.google.cloud.dataplex.v1.DeleteContentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteContentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a content resource.
     * </pre>
     */
    public void getContent(com.google.cloud.dataplex.v1.GetContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetContentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a contentitem resource. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * Caller must have Google IAM `dataplex.content.getIamPolicy` permission
     * on the resource.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified contentitem resource.
     * Replaces any existing policy.
     * Caller must have Google IAM `dataplex.content.setIamPolicy` permission
     * on the resource.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the caller's permissions on a resource.
     * If the resource does not exist, an empty set of
     * permissions is returned (a `NOT_FOUND` error is not returned).
     * A caller is not required to have Google IAM permission to make this
     * request.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List content.
     * </pre>
     */
    public void listContent(com.google.cloud.dataplex.v1.ListContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListContentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListContentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex.
   * </pre>
   */
  public static final class ContentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ContentServiceBlockingStub> {
    private ContentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a content.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Content createContent(com.google.cloud.dataplex.v1.CreateContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateContentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update a content. Only supports full resource update.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Content updateContent(com.google.cloud.dataplex.v1.UpdateContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateContentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete a content.
     * </pre>
     */
    public com.google.protobuf.Empty deleteContent(com.google.cloud.dataplex.v1.DeleteContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteContentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a content resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Content getContent(com.google.cloud.dataplex.v1.GetContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetContentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a contentitem resource. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * Caller must have Google IAM `dataplex.content.getIamPolicy` permission
     * on the resource.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified contentitem resource.
     * Replaces any existing policy.
     * Caller must have Google IAM `dataplex.content.setIamPolicy` permission
     * on the resource.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the caller's permissions on a resource.
     * If the resource does not exist, an empty set of
     * permissions is returned (a `NOT_FOUND` error is not returned).
     * A caller is not required to have Google IAM permission to make this
     * request.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List content.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListContentResponse listContent(com.google.cloud.dataplex.v1.ListContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListContentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex.
   * </pre>
   */
  public static final class ContentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ContentServiceFutureStub> {
    private ContentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Content> createContent(
        com.google.cloud.dataplex.v1.CreateContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateContentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update a content. Only supports full resource update.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Content> updateContent(
        com.google.cloud.dataplex.v1.UpdateContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateContentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete a content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteContent(
        com.google.cloud.dataplex.v1.DeleteContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteContentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a content resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Content> getContent(
        com.google.cloud.dataplex.v1.GetContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetContentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a contentitem resource. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * Caller must have Google IAM `dataplex.content.getIamPolicy` permission
     * on the resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified contentitem resource.
     * Replaces any existing policy.
     * Caller must have Google IAM `dataplex.content.setIamPolicy` permission
     * on the resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the caller's permissions on a resource.
     * If the resource does not exist, an empty set of
     * permissions is returned (a `NOT_FOUND` error is not returned).
     * A caller is not required to have Google IAM permission to make this
     * request.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListContentResponse> listContent(
        com.google.cloud.dataplex.v1.ListContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListContentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONTENT = 0;
  private static final int METHODID_UPDATE_CONTENT = 1;
  private static final int METHODID_DELETE_CONTENT = 2;
  private static final int METHODID_GET_CONTENT = 3;
  private static final int METHODID_GET_IAM_POLICY = 4;
  private static final int METHODID_SET_IAM_POLICY = 5;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 6;
  private static final int METHODID_LIST_CONTENT = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CONTENT:
          serviceImpl.createContent((com.google.cloud.dataplex.v1.CreateContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content>) responseObserver);
          break;
        case METHODID_UPDATE_CONTENT:
          serviceImpl.updateContent((com.google.cloud.dataplex.v1.UpdateContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content>) responseObserver);
          break;
        case METHODID_DELETE_CONTENT:
          serviceImpl.deleteContent((com.google.cloud.dataplex.v1.DeleteContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CONTENT:
          serviceImpl.getContent((com.google.cloud.dataplex.v1.GetContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Content>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
          break;
        case METHODID_LIST_CONTENT:
          serviceImpl.listContent((com.google.cloud.dataplex.v1.ListContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListContentResponse>) responseObserver);
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

  private static abstract class ContentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.ContentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContentService");
    }
  }

  private static final class ContentServiceFileDescriptorSupplier
      extends ContentServiceBaseDescriptorSupplier {
    ContentServiceFileDescriptorSupplier() {}
  }

  private static final class ContentServiceMethodDescriptorSupplier
      extends ContentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ContentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ContentServiceFileDescriptorSupplier())
              .addMethod(getCreateContentMethod())
              .addMethod(getUpdateContentMethod())
              .addMethod(getDeleteContentMethod())
              .addMethod(getGetContentMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .addMethod(getListContentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
