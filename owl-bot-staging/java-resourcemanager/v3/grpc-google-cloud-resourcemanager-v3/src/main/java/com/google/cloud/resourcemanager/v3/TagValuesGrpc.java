package com.google.cloud.resourcemanager.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Allow users to create and manage tag values.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/resourcemanager/v3/tag_values.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TagValuesGrpc {

  private TagValuesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.resourcemanager.v3.TagValues";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.ListTagValuesRequest,
      com.google.cloud.resourcemanager.v3.ListTagValuesResponse> getListTagValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTagValues",
      requestType = com.google.cloud.resourcemanager.v3.ListTagValuesRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.ListTagValuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.ListTagValuesRequest,
      com.google.cloud.resourcemanager.v3.ListTagValuesResponse> getListTagValuesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.ListTagValuesRequest, com.google.cloud.resourcemanager.v3.ListTagValuesResponse> getListTagValuesMethod;
    if ((getListTagValuesMethod = TagValuesGrpc.getListTagValuesMethod) == null) {
      synchronized (TagValuesGrpc.class) {
        if ((getListTagValuesMethod = TagValuesGrpc.getListTagValuesMethod) == null) {
          TagValuesGrpc.getListTagValuesMethod = getListTagValuesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.resourcemanager.v3.ListTagValuesRequest, com.google.cloud.resourcemanager.v3.ListTagValuesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTagValues"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.resourcemanager.v3.ListTagValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.resourcemanager.v3.ListTagValuesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TagValuesMethodDescriptorSupplier("ListTagValues"))
              .build();
        }
      }
    }
    return getListTagValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.GetTagValueRequest,
      com.google.cloud.resourcemanager.v3.TagValue> getGetTagValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTagValue",
      requestType = com.google.cloud.resourcemanager.v3.GetTagValueRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.TagValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.GetTagValueRequest,
      com.google.cloud.resourcemanager.v3.TagValue> getGetTagValueMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.GetTagValueRequest, com.google.cloud.resourcemanager.v3.TagValue> getGetTagValueMethod;
    if ((getGetTagValueMethod = TagValuesGrpc.getGetTagValueMethod) == null) {
      synchronized (TagValuesGrpc.class) {
        if ((getGetTagValueMethod = TagValuesGrpc.getGetTagValueMethod) == null) {
          TagValuesGrpc.getGetTagValueMethod = getGetTagValueMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.resourcemanager.v3.GetTagValueRequest, com.google.cloud.resourcemanager.v3.TagValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTagValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.resourcemanager.v3.GetTagValueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.resourcemanager.v3.TagValue.getDefaultInstance()))
              .setSchemaDescriptor(new TagValuesMethodDescriptorSupplier("GetTagValue"))
              .build();
        }
      }
    }
    return getGetTagValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.CreateTagValueRequest,
      com.google.longrunning.Operation> getCreateTagValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTagValue",
      requestType = com.google.cloud.resourcemanager.v3.CreateTagValueRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.CreateTagValueRequest,
      com.google.longrunning.Operation> getCreateTagValueMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.CreateTagValueRequest, com.google.longrunning.Operation> getCreateTagValueMethod;
    if ((getCreateTagValueMethod = TagValuesGrpc.getCreateTagValueMethod) == null) {
      synchronized (TagValuesGrpc.class) {
        if ((getCreateTagValueMethod = TagValuesGrpc.getCreateTagValueMethod) == null) {
          TagValuesGrpc.getCreateTagValueMethod = getCreateTagValueMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.resourcemanager.v3.CreateTagValueRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTagValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.resourcemanager.v3.CreateTagValueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TagValuesMethodDescriptorSupplier("CreateTagValue"))
              .build();
        }
      }
    }
    return getCreateTagValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.UpdateTagValueRequest,
      com.google.longrunning.Operation> getUpdateTagValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTagValue",
      requestType = com.google.cloud.resourcemanager.v3.UpdateTagValueRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.UpdateTagValueRequest,
      com.google.longrunning.Operation> getUpdateTagValueMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.UpdateTagValueRequest, com.google.longrunning.Operation> getUpdateTagValueMethod;
    if ((getUpdateTagValueMethod = TagValuesGrpc.getUpdateTagValueMethod) == null) {
      synchronized (TagValuesGrpc.class) {
        if ((getUpdateTagValueMethod = TagValuesGrpc.getUpdateTagValueMethod) == null) {
          TagValuesGrpc.getUpdateTagValueMethod = getUpdateTagValueMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.resourcemanager.v3.UpdateTagValueRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTagValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.resourcemanager.v3.UpdateTagValueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TagValuesMethodDescriptorSupplier("UpdateTagValue"))
              .build();
        }
      }
    }
    return getUpdateTagValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.DeleteTagValueRequest,
      com.google.longrunning.Operation> getDeleteTagValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTagValue",
      requestType = com.google.cloud.resourcemanager.v3.DeleteTagValueRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.DeleteTagValueRequest,
      com.google.longrunning.Operation> getDeleteTagValueMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.resourcemanager.v3.DeleteTagValueRequest, com.google.longrunning.Operation> getDeleteTagValueMethod;
    if ((getDeleteTagValueMethod = TagValuesGrpc.getDeleteTagValueMethod) == null) {
      synchronized (TagValuesGrpc.class) {
        if ((getDeleteTagValueMethod = TagValuesGrpc.getDeleteTagValueMethod) == null) {
          TagValuesGrpc.getDeleteTagValueMethod = getDeleteTagValueMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.resourcemanager.v3.DeleteTagValueRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTagValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.resourcemanager.v3.DeleteTagValueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new TagValuesMethodDescriptorSupplier("DeleteTagValue"))
              .build();
        }
      }
    }
    return getDeleteTagValueMethod;
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
    if ((getGetIamPolicyMethod = TagValuesGrpc.getGetIamPolicyMethod) == null) {
      synchronized (TagValuesGrpc.class) {
        if ((getGetIamPolicyMethod = TagValuesGrpc.getGetIamPolicyMethod) == null) {
          TagValuesGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new TagValuesMethodDescriptorSupplier("GetIamPolicy"))
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
    if ((getSetIamPolicyMethod = TagValuesGrpc.getSetIamPolicyMethod) == null) {
      synchronized (TagValuesGrpc.class) {
        if ((getSetIamPolicyMethod = TagValuesGrpc.getSetIamPolicyMethod) == null) {
          TagValuesGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new TagValuesMethodDescriptorSupplier("SetIamPolicy"))
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
    if ((getTestIamPermissionsMethod = TagValuesGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (TagValuesGrpc.class) {
        if ((getTestIamPermissionsMethod = TagValuesGrpc.getTestIamPermissionsMethod) == null) {
          TagValuesGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TagValuesMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TagValuesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagValuesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TagValuesStub>() {
        @java.lang.Override
        public TagValuesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TagValuesStub(channel, callOptions);
        }
      };
    return TagValuesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TagValuesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagValuesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TagValuesBlockingStub>() {
        @java.lang.Override
        public TagValuesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TagValuesBlockingStub(channel, callOptions);
        }
      };
    return TagValuesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TagValuesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagValuesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TagValuesFutureStub>() {
        @java.lang.Override
        public TagValuesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TagValuesFutureStub(channel, callOptions);
        }
      };
    return TagValuesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Allow users to create and manage tag values.
   * </pre>
   */
  public static abstract class TagValuesImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists all TagValues for a specific TagKey.
     * </pre>
     */
    public void listTagValues(com.google.cloud.resourcemanager.v3.ListTagValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagValuesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTagValuesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves TagValue. If the TagValue or namespaced name does not exist, or
     * if the user does not have permission to view it, this method will return
     * `PERMISSION_DENIED`.
     * </pre>
     */
    public void getTagValue(com.google.cloud.resourcemanager.v3.GetTagValueRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.TagValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTagValueMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a TagValue as a child of the specified TagKey. If a another
     * request with the same parameters is sent while the original request is in
     * process the second request will receive an error. A maximum of 300
     * TagValues can exist under a TagKey at any given time.
     * </pre>
     */
    public void createTagValue(com.google.cloud.resourcemanager.v3.CreateTagValueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTagValueMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the attributes of the TagValue resource.
     * </pre>
     */
    public void updateTagValue(com.google.cloud.resourcemanager.v3.UpdateTagValueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTagValueMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a TagValue. The TagValue cannot have any bindings when it is
     * deleted.
     * </pre>
     */
    public void deleteTagValue(com.google.cloud.resourcemanager.v3.DeleteTagValueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTagValueMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a TagValue. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the TagValue's resource name. For example: `tagValues/1234`.
     * The caller must have the
     * `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on
     * the identified TagValue to get the access control policy.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on a TagValue, replacing any existing
     * policy. The `resource` field should be the TagValue's resource name.
     * For example: `tagValues/1234`.
     * The caller must have `resourcemanager.tagValues.setIamPolicy` permission
     * on the identified tagValue.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified TagValue.
     * The `resource` field should be the TagValue's resource name. For example:
     * `tagValues/1234`.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListTagValuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.resourcemanager.v3.ListTagValuesRequest,
                com.google.cloud.resourcemanager.v3.ListTagValuesResponse>(
                  this, METHODID_LIST_TAG_VALUES)))
          .addMethod(
            getGetTagValueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.resourcemanager.v3.GetTagValueRequest,
                com.google.cloud.resourcemanager.v3.TagValue>(
                  this, METHODID_GET_TAG_VALUE)))
          .addMethod(
            getCreateTagValueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.resourcemanager.v3.CreateTagValueRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_TAG_VALUE)))
          .addMethod(
            getUpdateTagValueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.resourcemanager.v3.UpdateTagValueRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_TAG_VALUE)))
          .addMethod(
            getDeleteTagValueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.resourcemanager.v3.DeleteTagValueRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_TAG_VALUE)))
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
          .build();
    }
  }

  /**
   * <pre>
   * Allow users to create and manage tag values.
   * </pre>
   */
  public static final class TagValuesStub extends io.grpc.stub.AbstractAsyncStub<TagValuesStub> {
    private TagValuesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagValuesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagValuesStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all TagValues for a specific TagKey.
     * </pre>
     */
    public void listTagValues(com.google.cloud.resourcemanager.v3.ListTagValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagValuesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTagValuesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves TagValue. If the TagValue or namespaced name does not exist, or
     * if the user does not have permission to view it, this method will return
     * `PERMISSION_DENIED`.
     * </pre>
     */
    public void getTagValue(com.google.cloud.resourcemanager.v3.GetTagValueRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.TagValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTagValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a TagValue as a child of the specified TagKey. If a another
     * request with the same parameters is sent while the original request is in
     * process the second request will receive an error. A maximum of 300
     * TagValues can exist under a TagKey at any given time.
     * </pre>
     */
    public void createTagValue(com.google.cloud.resourcemanager.v3.CreateTagValueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the attributes of the TagValue resource.
     * </pre>
     */
    public void updateTagValue(com.google.cloud.resourcemanager.v3.UpdateTagValueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTagValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a TagValue. The TagValue cannot have any bindings when it is
     * deleted.
     * </pre>
     */
    public void deleteTagValue(com.google.cloud.resourcemanager.v3.DeleteTagValueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a TagValue. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the TagValue's resource name. For example: `tagValues/1234`.
     * The caller must have the
     * `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on
     * the identified TagValue to get the access control policy.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on a TagValue, replacing any existing
     * policy. The `resource` field should be the TagValue's resource name.
     * For example: `tagValues/1234`.
     * The caller must have `resourcemanager.tagValues.setIamPolicy` permission
     * on the identified tagValue.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified TagValue.
     * The `resource` field should be the TagValue's resource name. For example:
     * `tagValues/1234`.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Allow users to create and manage tag values.
   * </pre>
   */
  public static final class TagValuesBlockingStub extends io.grpc.stub.AbstractBlockingStub<TagValuesBlockingStub> {
    private TagValuesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagValuesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagValuesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all TagValues for a specific TagKey.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.ListTagValuesResponse listTagValues(com.google.cloud.resourcemanager.v3.ListTagValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTagValuesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves TagValue. If the TagValue or namespaced name does not exist, or
     * if the user does not have permission to view it, this method will return
     * `PERMISSION_DENIED`.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.TagValue getTagValue(com.google.cloud.resourcemanager.v3.GetTagValueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTagValueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a TagValue as a child of the specified TagKey. If a another
     * request with the same parameters is sent while the original request is in
     * process the second request will receive an error. A maximum of 300
     * TagValues can exist under a TagKey at any given time.
     * </pre>
     */
    public com.google.longrunning.Operation createTagValue(com.google.cloud.resourcemanager.v3.CreateTagValueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagValueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the attributes of the TagValue resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateTagValue(com.google.cloud.resourcemanager.v3.UpdateTagValueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTagValueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a TagValue. The TagValue cannot have any bindings when it is
     * deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTagValue(com.google.cloud.resourcemanager.v3.DeleteTagValueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagValueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a TagValue. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the TagValue's resource name. For example: `tagValues/1234`.
     * The caller must have the
     * `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on
     * the identified TagValue to get the access control policy.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the access control policy on a TagValue, replacing any existing
     * policy. The `resource` field should be the TagValue's resource name.
     * For example: `tagValues/1234`.
     * The caller must have `resourcemanager.tagValues.setIamPolicy` permission
     * on the identified tagValue.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified TagValue.
     * The `resource` field should be the TagValue's resource name. For example:
     * `tagValues/1234`.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Allow users to create and manage tag values.
   * </pre>
   */
  public static final class TagValuesFutureStub extends io.grpc.stub.AbstractFutureStub<TagValuesFutureStub> {
    private TagValuesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagValuesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagValuesFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all TagValues for a specific TagKey.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.resourcemanager.v3.ListTagValuesResponse> listTagValues(
        com.google.cloud.resourcemanager.v3.ListTagValuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTagValuesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves TagValue. If the TagValue or namespaced name does not exist, or
     * if the user does not have permission to view it, this method will return
     * `PERMISSION_DENIED`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.resourcemanager.v3.TagValue> getTagValue(
        com.google.cloud.resourcemanager.v3.GetTagValueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTagValueMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a TagValue as a child of the specified TagKey. If a another
     * request with the same parameters is sent while the original request is in
     * process the second request will receive an error. A maximum of 300
     * TagValues can exist under a TagKey at any given time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createTagValue(
        com.google.cloud.resourcemanager.v3.CreateTagValueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagValueMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the attributes of the TagValue resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateTagValue(
        com.google.cloud.resourcemanager.v3.UpdateTagValueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTagValueMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a TagValue. The TagValue cannot have any bindings when it is
     * deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteTagValue(
        com.google.cloud.resourcemanager.v3.DeleteTagValueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagValueMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a TagValue. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the TagValue's resource name. For example: `tagValues/1234`.
     * The caller must have the
     * `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on
     * the identified TagValue to get the access control policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the access control policy on a TagValue, replacing any existing
     * policy. The `resource` field should be the TagValue's resource name.
     * For example: `tagValues/1234`.
     * The caller must have `resourcemanager.tagValues.setIamPolicy` permission
     * on the identified tagValue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified TagValue.
     * The `resource` field should be the TagValue's resource name. For example:
     * `tagValues/1234`.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_TAG_VALUES = 0;
  private static final int METHODID_GET_TAG_VALUE = 1;
  private static final int METHODID_CREATE_TAG_VALUE = 2;
  private static final int METHODID_UPDATE_TAG_VALUE = 3;
  private static final int METHODID_DELETE_TAG_VALUE = 4;
  private static final int METHODID_GET_IAM_POLICY = 5;
  private static final int METHODID_SET_IAM_POLICY = 6;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TagValuesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TagValuesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_TAG_VALUES:
          serviceImpl.listTagValues((com.google.cloud.resourcemanager.v3.ListTagValuesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagValuesResponse>) responseObserver);
          break;
        case METHODID_GET_TAG_VALUE:
          serviceImpl.getTagValue((com.google.cloud.resourcemanager.v3.GetTagValueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.TagValue>) responseObserver);
          break;
        case METHODID_CREATE_TAG_VALUE:
          serviceImpl.createTagValue((com.google.cloud.resourcemanager.v3.CreateTagValueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TAG_VALUE:
          serviceImpl.updateTagValue((com.google.cloud.resourcemanager.v3.UpdateTagValueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TAG_VALUE:
          serviceImpl.deleteTagValue((com.google.cloud.resourcemanager.v3.DeleteTagValueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private static abstract class TagValuesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TagValuesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.resourcemanager.v3.TagValuesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TagValues");
    }
  }

  private static final class TagValuesFileDescriptorSupplier
      extends TagValuesBaseDescriptorSupplier {
    TagValuesFileDescriptorSupplier() {}
  }

  private static final class TagValuesMethodDescriptorSupplier
      extends TagValuesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TagValuesMethodDescriptorSupplier(String methodName) {
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
      synchronized (TagValuesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TagValuesFileDescriptorSupplier())
              .addMethod(getListTagValuesMethod())
              .addMethod(getGetTagValueMethod())
              .addMethod(getCreateTagValueMethod())
              .addMethod(getUpdateTagValueMethod())
              .addMethod(getDeleteTagValueMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
