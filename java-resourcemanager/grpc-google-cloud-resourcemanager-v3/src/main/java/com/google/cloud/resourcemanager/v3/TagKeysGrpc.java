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
 * Allow users to create and manage tag keys.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/resourcemanager/v3/tag_keys.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TagKeysGrpc {

  private TagKeysGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.resourcemanager.v3.TagKeys";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListTagKeysRequest,
          com.google.cloud.resourcemanager.v3.ListTagKeysResponse>
      getListTagKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTagKeys",
      requestType = com.google.cloud.resourcemanager.v3.ListTagKeysRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.ListTagKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListTagKeysRequest,
          com.google.cloud.resourcemanager.v3.ListTagKeysResponse>
      getListTagKeysMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.ListTagKeysRequest,
            com.google.cloud.resourcemanager.v3.ListTagKeysResponse>
        getListTagKeysMethod;
    if ((getListTagKeysMethod = TagKeysGrpc.getListTagKeysMethod) == null) {
      synchronized (TagKeysGrpc.class) {
        if ((getListTagKeysMethod = TagKeysGrpc.getListTagKeysMethod) == null) {
          TagKeysGrpc.getListTagKeysMethod =
              getListTagKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.ListTagKeysRequest,
                          com.google.cloud.resourcemanager.v3.ListTagKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTagKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListTagKeysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListTagKeysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TagKeysMethodDescriptorSupplier("ListTagKeys"))
                      .build();
        }
      }
    }
    return getListTagKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.GetTagKeyRequest,
          com.google.cloud.resourcemanager.v3.TagKey>
      getGetTagKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTagKey",
      requestType = com.google.cloud.resourcemanager.v3.GetTagKeyRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.TagKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.GetTagKeyRequest,
          com.google.cloud.resourcemanager.v3.TagKey>
      getGetTagKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.GetTagKeyRequest,
            com.google.cloud.resourcemanager.v3.TagKey>
        getGetTagKeyMethod;
    if ((getGetTagKeyMethod = TagKeysGrpc.getGetTagKeyMethod) == null) {
      synchronized (TagKeysGrpc.class) {
        if ((getGetTagKeyMethod = TagKeysGrpc.getGetTagKeyMethod) == null) {
          TagKeysGrpc.getGetTagKeyMethod =
              getGetTagKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.GetTagKeyRequest,
                          com.google.cloud.resourcemanager.v3.TagKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTagKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.GetTagKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.TagKey.getDefaultInstance()))
                      .setSchemaDescriptor(new TagKeysMethodDescriptorSupplier("GetTagKey"))
                      .build();
        }
      }
    }
    return getGetTagKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateTagKeyRequest, com.google.longrunning.Operation>
      getCreateTagKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTagKey",
      requestType = com.google.cloud.resourcemanager.v3.CreateTagKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateTagKeyRequest, com.google.longrunning.Operation>
      getCreateTagKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.CreateTagKeyRequest,
            com.google.longrunning.Operation>
        getCreateTagKeyMethod;
    if ((getCreateTagKeyMethod = TagKeysGrpc.getCreateTagKeyMethod) == null) {
      synchronized (TagKeysGrpc.class) {
        if ((getCreateTagKeyMethod = TagKeysGrpc.getCreateTagKeyMethod) == null) {
          TagKeysGrpc.getCreateTagKeyMethod =
              getCreateTagKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.CreateTagKeyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTagKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.CreateTagKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TagKeysMethodDescriptorSupplier("CreateTagKey"))
                      .build();
        }
      }
    }
    return getCreateTagKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest, com.google.longrunning.Operation>
      getUpdateTagKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTagKey",
      requestType = com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest, com.google.longrunning.Operation>
      getUpdateTagKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest,
            com.google.longrunning.Operation>
        getUpdateTagKeyMethod;
    if ((getUpdateTagKeyMethod = TagKeysGrpc.getUpdateTagKeyMethod) == null) {
      synchronized (TagKeysGrpc.class) {
        if ((getUpdateTagKeyMethod = TagKeysGrpc.getUpdateTagKeyMethod) == null) {
          TagKeysGrpc.getUpdateTagKeyMethod =
              getUpdateTagKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTagKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TagKeysMethodDescriptorSupplier("UpdateTagKey"))
                      .build();
        }
      }
    }
    return getUpdateTagKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest, com.google.longrunning.Operation>
      getDeleteTagKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTagKey",
      requestType = com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest, com.google.longrunning.Operation>
      getDeleteTagKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest,
            com.google.longrunning.Operation>
        getDeleteTagKeyMethod;
    if ((getDeleteTagKeyMethod = TagKeysGrpc.getDeleteTagKeyMethod) == null) {
      synchronized (TagKeysGrpc.class) {
        if ((getDeleteTagKeyMethod = TagKeysGrpc.getDeleteTagKeyMethod) == null) {
          TagKeysGrpc.getDeleteTagKeyMethod =
              getDeleteTagKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTagKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TagKeysMethodDescriptorSupplier("DeleteTagKey"))
                      .build();
        }
      }
    }
    return getDeleteTagKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = TagKeysGrpc.getGetIamPolicyMethod) == null) {
      synchronized (TagKeysGrpc.class) {
        if ((getGetIamPolicyMethod = TagKeysGrpc.getGetIamPolicyMethod) == null) {
          TagKeysGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new TagKeysMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = TagKeysGrpc.getSetIamPolicyMethod) == null) {
      synchronized (TagKeysGrpc.class) {
        if ((getSetIamPolicyMethod = TagKeysGrpc.getSetIamPolicyMethod) == null) {
          TagKeysGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new TagKeysMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = TagKeysGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (TagKeysGrpc.class) {
        if ((getTestIamPermissionsMethod = TagKeysGrpc.getTestIamPermissionsMethod) == null) {
          TagKeysGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TagKeysMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TagKeysStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagKeysStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagKeysStub>() {
          @java.lang.Override
          public TagKeysStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagKeysStub(channel, callOptions);
          }
        };
    return TagKeysStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TagKeysBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagKeysBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagKeysBlockingStub>() {
          @java.lang.Override
          public TagKeysBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagKeysBlockingStub(channel, callOptions);
          }
        };
    return TagKeysBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TagKeysFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagKeysFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagKeysFutureStub>() {
          @java.lang.Override
          public TagKeysFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagKeysFutureStub(channel, callOptions);
          }
        };
    return TagKeysFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Allow users to create and manage tag keys.
   * </pre>
   */
  public abstract static class TagKeysImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all TagKeys for a parent resource.
     * </pre>
     */
    public void listTagKeys(
        com.google.cloud.resourcemanager.v3.ListTagKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagKeysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTagKeysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the
     * key does not exist or the user does not have permission to view it.
     * </pre>
     */
    public void getTagKey(
        com.google.cloud.resourcemanager.v3.GetTagKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.TagKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTagKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TagKey. If another request with the same parameters is
     * sent while the original request is in process, the second request
     * will receive an error. A maximum of 300 TagKeys can exist under a parent at
     * any given time.
     * </pre>
     */
    public void createTagKey(
        com.google.cloud.resourcemanager.v3.CreateTagKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTagKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the attributes of the TagKey resource.
     * </pre>
     */
    public void updateTagKey(
        com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTagKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagKey. The TagKey cannot be deleted if it has any child
     * TagValues.
     * </pre>
     */
    public void deleteTagKey(
        com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTagKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a TagKey. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the TagKey's resource name. For example, "tagKeys/1234".
     * The caller must have
     * `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy` permission on
     * the specified TagKey.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a TagKey, replacing any existing
     * policy. The `resource` field should be the TagKey's resource name.
     * For example, "tagKeys/1234".
     * The caller must have `resourcemanager.tagKeys.setIamPolicy` permission
     * on the identified tagValue.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified TagKey.
     * The `resource` field should be the TagKey's resource name.
     * For example, "tagKeys/1234".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListTagKeysMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.ListTagKeysRequest,
                      com.google.cloud.resourcemanager.v3.ListTagKeysResponse>(
                      this, METHODID_LIST_TAG_KEYS)))
          .addMethod(
              getGetTagKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.GetTagKeyRequest,
                      com.google.cloud.resourcemanager.v3.TagKey>(this, METHODID_GET_TAG_KEY)))
          .addMethod(
              getCreateTagKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.CreateTagKeyRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_TAG_KEY)))
          .addMethod(
              getUpdateTagKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_TAG_KEY)))
          .addMethod(
              getDeleteTagKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_TAG_KEY)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
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
   *
   *
   * <pre>
   * Allow users to create and manage tag keys.
   * </pre>
   */
  public static final class TagKeysStub extends io.grpc.stub.AbstractAsyncStub<TagKeysStub> {
    private TagKeysStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagKeysStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagKeysStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all TagKeys for a parent resource.
     * </pre>
     */
    public void listTagKeys(
        com.google.cloud.resourcemanager.v3.ListTagKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagKeysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTagKeysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the
     * key does not exist or the user does not have permission to view it.
     * </pre>
     */
    public void getTagKey(
        com.google.cloud.resourcemanager.v3.GetTagKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.TagKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTagKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TagKey. If another request with the same parameters is
     * sent while the original request is in process, the second request
     * will receive an error. A maximum of 300 TagKeys can exist under a parent at
     * any given time.
     * </pre>
     */
    public void createTagKey(
        com.google.cloud.resourcemanager.v3.CreateTagKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the attributes of the TagKey resource.
     * </pre>
     */
    public void updateTagKey(
        com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTagKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagKey. The TagKey cannot be deleted if it has any child
     * TagValues.
     * </pre>
     */
    public void deleteTagKey(
        com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a TagKey. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the TagKey's resource name. For example, "tagKeys/1234".
     * The caller must have
     * `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy` permission on
     * the specified TagKey.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a TagKey, replacing any existing
     * policy. The `resource` field should be the TagKey's resource name.
     * For example, "tagKeys/1234".
     * The caller must have `resourcemanager.tagKeys.setIamPolicy` permission
     * on the identified tagValue.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified TagKey.
     * The `resource` field should be the TagKey's resource name.
     * For example, "tagKeys/1234".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Allow users to create and manage tag keys.
   * </pre>
   */
  public static final class TagKeysBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TagKeysBlockingStub> {
    private TagKeysBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagKeysBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagKeysBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all TagKeys for a parent resource.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.ListTagKeysResponse listTagKeys(
        com.google.cloud.resourcemanager.v3.ListTagKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTagKeysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the
     * key does not exist or the user does not have permission to view it.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.TagKey getTagKey(
        com.google.cloud.resourcemanager.v3.GetTagKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTagKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TagKey. If another request with the same parameters is
     * sent while the original request is in process, the second request
     * will receive an error. A maximum of 300 TagKeys can exist under a parent at
     * any given time.
     * </pre>
     */
    public com.google.longrunning.Operation createTagKey(
        com.google.cloud.resourcemanager.v3.CreateTagKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the attributes of the TagKey resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateTagKey(
        com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTagKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagKey. The TagKey cannot be deleted if it has any child
     * TagValues.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTagKey(
        com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a TagKey. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the TagKey's resource name. For example, "tagKeys/1234".
     * The caller must have
     * `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy` permission on
     * the specified TagKey.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a TagKey, replacing any existing
     * policy. The `resource` field should be the TagKey's resource name.
     * For example, "tagKeys/1234".
     * The caller must have `resourcemanager.tagKeys.setIamPolicy` permission
     * on the identified tagValue.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified TagKey.
     * The `resource` field should be the TagKey's resource name.
     * For example, "tagKeys/1234".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Allow users to create and manage tag keys.
   * </pre>
   */
  public static final class TagKeysFutureStub
      extends io.grpc.stub.AbstractFutureStub<TagKeysFutureStub> {
    private TagKeysFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagKeysFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagKeysFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all TagKeys for a parent resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.ListTagKeysResponse>
        listTagKeys(com.google.cloud.resourcemanager.v3.ListTagKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTagKeysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the
     * key does not exist or the user does not have permission to view it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.TagKey>
        getTagKey(com.google.cloud.resourcemanager.v3.GetTagKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTagKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TagKey. If another request with the same parameters is
     * sent while the original request is in process, the second request
     * will receive an error. A maximum of 300 TagKeys can exist under a parent at
     * any given time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTagKey(com.google.cloud.resourcemanager.v3.CreateTagKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the attributes of the TagKey resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTagKey(com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTagKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagKey. The TagKey cannot be deleted if it has any child
     * TagValues.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTagKey(com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a TagKey. The returned policy may be
     * empty if no such policy or resource exists. The `resource` field should
     * be the TagKey's resource name. For example, "tagKeys/1234".
     * The caller must have
     * `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy` permission on
     * the specified TagKey.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on a TagKey, replacing any existing
     * policy. The `resource` field should be the TagKey's resource name.
     * For example, "tagKeys/1234".
     * The caller must have `resourcemanager.tagKeys.setIamPolicy` permission
     * on the identified tagValue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified TagKey.
     * The `resource` field should be the TagKey's resource name.
     * For example, "tagKeys/1234".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_TAG_KEYS = 0;
  private static final int METHODID_GET_TAG_KEY = 1;
  private static final int METHODID_CREATE_TAG_KEY = 2;
  private static final int METHODID_UPDATE_TAG_KEY = 3;
  private static final int METHODID_DELETE_TAG_KEY = 4;
  private static final int METHODID_GET_IAM_POLICY = 5;
  private static final int METHODID_SET_IAM_POLICY = 6;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TagKeysImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TagKeysImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_TAG_KEYS:
          serviceImpl.listTagKeys(
              (com.google.cloud.resourcemanager.v3.ListTagKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagKeysResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TAG_KEY:
          serviceImpl.getTagKey(
              (com.google.cloud.resourcemanager.v3.GetTagKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.TagKey>)
                  responseObserver);
          break;
        case METHODID_CREATE_TAG_KEY:
          serviceImpl.createTagKey(
              (com.google.cloud.resourcemanager.v3.CreateTagKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TAG_KEY:
          serviceImpl.updateTagKey(
              (com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TAG_KEY:
          serviceImpl.deleteTagKey(
              (com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
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

  private abstract static class TagKeysBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TagKeysBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.resourcemanager.v3.TagKeysProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TagKeys");
    }
  }

  private static final class TagKeysFileDescriptorSupplier extends TagKeysBaseDescriptorSupplier {
    TagKeysFileDescriptorSupplier() {}
  }

  private static final class TagKeysMethodDescriptorSupplier extends TagKeysBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TagKeysMethodDescriptorSupplier(String methodName) {
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
      synchronized (TagKeysGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TagKeysFileDescriptorSupplier())
                      .addMethod(getListTagKeysMethod())
                      .addMethod(getGetTagKeyMethod())
                      .addMethod(getCreateTagKeyMethod())
                      .addMethod(getUpdateTagKeyMethod())
                      .addMethod(getDeleteTagKeyMethod())
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
