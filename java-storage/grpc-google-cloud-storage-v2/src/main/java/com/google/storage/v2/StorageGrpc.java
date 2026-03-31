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
package com.google.storage.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * ## API Overview and Naming Syntax
 * The Cloud Storage gRPC API allows applications to read and write data through
 * the abstractions of buckets and objects. For a description of these
 * abstractions please see [Cloud Storage
 * documentation](https://cloud.google.com/storage/docs).
 * Resources are named as follows:
 *   - Projects are referred to as they are defined by the Resource Manager API,
 *     using strings like `projects/123456` or `projects/my-string-id`.
 *   - Buckets are named using string names of the form:
 *     `projects/{project}/buckets/{bucket}`.
 *     For globally unique buckets, `_` might be substituted for the project.
 *   - Objects are uniquely identified by their name along with the name of the
 *     bucket they belong to, as separate strings in this API. For example:
 *         ```
 *         ReadObjectRequest {
 *         bucket: 'projects/_/buckets/my-bucket'
 *         object: 'my-object'
 *         }
 *         ```
 * Note that object names can contain `/` characters, which are treated as
 * any other character (no special directory semantics).
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class StorageGrpc {

  private StorageGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.storage.v2.Storage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.DeleteBucketRequest, com.google.protobuf.Empty>
      getDeleteBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBucket",
      requestType = com.google.storage.v2.DeleteBucketRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.DeleteBucketRequest, com.google.protobuf.Empty>
      getDeleteBucketMethod() {
    io.grpc.MethodDescriptor<com.google.storage.v2.DeleteBucketRequest, com.google.protobuf.Empty>
        getDeleteBucketMethod;
    if ((getDeleteBucketMethod = StorageGrpc.getDeleteBucketMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getDeleteBucketMethod = StorageGrpc.getDeleteBucketMethod) == null) {
          StorageGrpc.getDeleteBucketMethod =
              getDeleteBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.DeleteBucketRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.DeleteBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("DeleteBucket"))
                      .build();
        }
      }
    }
    return getDeleteBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.GetBucketRequest, com.google.storage.v2.Bucket>
      getGetBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBucket",
      requestType = com.google.storage.v2.GetBucketRequest.class,
      responseType = com.google.storage.v2.Bucket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.GetBucketRequest, com.google.storage.v2.Bucket>
      getGetBucketMethod() {
    io.grpc.MethodDescriptor<com.google.storage.v2.GetBucketRequest, com.google.storage.v2.Bucket>
        getGetBucketMethod;
    if ((getGetBucketMethod = StorageGrpc.getGetBucketMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getGetBucketMethod = StorageGrpc.getGetBucketMethod) == null) {
          StorageGrpc.getGetBucketMethod =
              getGetBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.GetBucketRequest, com.google.storage.v2.Bucket>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.GetBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Bucket.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("GetBucket"))
                      .build();
        }
      }
    }
    return getGetBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.CreateBucketRequest, com.google.storage.v2.Bucket>
      getCreateBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBucket",
      requestType = com.google.storage.v2.CreateBucketRequest.class,
      responseType = com.google.storage.v2.Bucket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.CreateBucketRequest, com.google.storage.v2.Bucket>
      getCreateBucketMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.CreateBucketRequest, com.google.storage.v2.Bucket>
        getCreateBucketMethod;
    if ((getCreateBucketMethod = StorageGrpc.getCreateBucketMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getCreateBucketMethod = StorageGrpc.getCreateBucketMethod) == null) {
          StorageGrpc.getCreateBucketMethod =
              getCreateBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.CreateBucketRequest, com.google.storage.v2.Bucket>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.CreateBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Bucket.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("CreateBucket"))
                      .build();
        }
      }
    }
    return getCreateBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.ListBucketsRequest, com.google.storage.v2.ListBucketsResponse>
      getListBucketsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBuckets",
      requestType = com.google.storage.v2.ListBucketsRequest.class,
      responseType = com.google.storage.v2.ListBucketsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.ListBucketsRequest, com.google.storage.v2.ListBucketsResponse>
      getListBucketsMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.ListBucketsRequest, com.google.storage.v2.ListBucketsResponse>
        getListBucketsMethod;
    if ((getListBucketsMethod = StorageGrpc.getListBucketsMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getListBucketsMethod = StorageGrpc.getListBucketsMethod) == null) {
          StorageGrpc.getListBucketsMethod =
              getListBucketsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.ListBucketsRequest,
                          com.google.storage.v2.ListBucketsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBuckets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.ListBucketsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.ListBucketsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("ListBuckets"))
                      .build();
        }
      }
    }
    return getListBucketsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.LockBucketRetentionPolicyRequest, com.google.storage.v2.Bucket>
      getLockBucketRetentionPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LockBucketRetentionPolicy",
      requestType = com.google.storage.v2.LockBucketRetentionPolicyRequest.class,
      responseType = com.google.storage.v2.Bucket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.LockBucketRetentionPolicyRequest, com.google.storage.v2.Bucket>
      getLockBucketRetentionPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.LockBucketRetentionPolicyRequest, com.google.storage.v2.Bucket>
        getLockBucketRetentionPolicyMethod;
    if ((getLockBucketRetentionPolicyMethod = StorageGrpc.getLockBucketRetentionPolicyMethod)
        == null) {
      synchronized (StorageGrpc.class) {
        if ((getLockBucketRetentionPolicyMethod = StorageGrpc.getLockBucketRetentionPolicyMethod)
            == null) {
          StorageGrpc.getLockBucketRetentionPolicyMethod =
              getLockBucketRetentionPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.LockBucketRetentionPolicyRequest,
                          com.google.storage.v2.Bucket>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "LockBucketRetentionPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.LockBucketRetentionPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Bucket.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageMethodDescriptorSupplier("LockBucketRetentionPolicy"))
                      .build();
        }
      }
    }
    return getLockBucketRetentionPolicyMethod;
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
    if ((getGetIamPolicyMethod = StorageGrpc.getGetIamPolicyMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getGetIamPolicyMethod = StorageGrpc.getGetIamPolicyMethod) == null) {
          StorageGrpc.getGetIamPolicyMethod =
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
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("GetIamPolicy"))
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
    if ((getSetIamPolicyMethod = StorageGrpc.getSetIamPolicyMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getSetIamPolicyMethod = StorageGrpc.getSetIamPolicyMethod) == null) {
          StorageGrpc.getSetIamPolicyMethod =
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
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("SetIamPolicy"))
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
    if ((getTestIamPermissionsMethod = StorageGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getTestIamPermissionsMethod = StorageGrpc.getTestIamPermissionsMethod) == null) {
          StorageGrpc.getTestIamPermissionsMethod =
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
                          new StorageMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.UpdateBucketRequest, com.google.storage.v2.Bucket>
      getUpdateBucketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBucket",
      requestType = com.google.storage.v2.UpdateBucketRequest.class,
      responseType = com.google.storage.v2.Bucket.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.UpdateBucketRequest, com.google.storage.v2.Bucket>
      getUpdateBucketMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.UpdateBucketRequest, com.google.storage.v2.Bucket>
        getUpdateBucketMethod;
    if ((getUpdateBucketMethod = StorageGrpc.getUpdateBucketMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getUpdateBucketMethod = StorageGrpc.getUpdateBucketMethod) == null) {
          StorageGrpc.getUpdateBucketMethod =
              getUpdateBucketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.UpdateBucketRequest, com.google.storage.v2.Bucket>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBucket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.UpdateBucketRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Bucket.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("UpdateBucket"))
                      .build();
        }
      }
    }
    return getUpdateBucketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.ComposeObjectRequest, com.google.storage.v2.Object>
      getComposeObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComposeObject",
      requestType = com.google.storage.v2.ComposeObjectRequest.class,
      responseType = com.google.storage.v2.Object.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.ComposeObjectRequest, com.google.storage.v2.Object>
      getComposeObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.ComposeObjectRequest, com.google.storage.v2.Object>
        getComposeObjectMethod;
    if ((getComposeObjectMethod = StorageGrpc.getComposeObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getComposeObjectMethod = StorageGrpc.getComposeObjectMethod) == null) {
          StorageGrpc.getComposeObjectMethod =
              getComposeObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.ComposeObjectRequest, com.google.storage.v2.Object>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComposeObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.ComposeObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Object.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("ComposeObject"))
                      .build();
        }
      }
    }
    return getComposeObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.DeleteObjectRequest, com.google.protobuf.Empty>
      getDeleteObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteObject",
      requestType = com.google.storage.v2.DeleteObjectRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.DeleteObjectRequest, com.google.protobuf.Empty>
      getDeleteObjectMethod() {
    io.grpc.MethodDescriptor<com.google.storage.v2.DeleteObjectRequest, com.google.protobuf.Empty>
        getDeleteObjectMethod;
    if ((getDeleteObjectMethod = StorageGrpc.getDeleteObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getDeleteObjectMethod = StorageGrpc.getDeleteObjectMethod) == null) {
          StorageGrpc.getDeleteObjectMethod =
              getDeleteObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.DeleteObjectRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.DeleteObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("DeleteObject"))
                      .build();
        }
      }
    }
    return getDeleteObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.RestoreObjectRequest, com.google.storage.v2.Object>
      getRestoreObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreObject",
      requestType = com.google.storage.v2.RestoreObjectRequest.class,
      responseType = com.google.storage.v2.Object.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.RestoreObjectRequest, com.google.storage.v2.Object>
      getRestoreObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.RestoreObjectRequest, com.google.storage.v2.Object>
        getRestoreObjectMethod;
    if ((getRestoreObjectMethod = StorageGrpc.getRestoreObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getRestoreObjectMethod = StorageGrpc.getRestoreObjectMethod) == null) {
          StorageGrpc.getRestoreObjectMethod =
              getRestoreObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.RestoreObjectRequest, com.google.storage.v2.Object>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.RestoreObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Object.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("RestoreObject"))
                      .build();
        }
      }
    }
    return getRestoreObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.CancelResumableWriteRequest,
          com.google.storage.v2.CancelResumableWriteResponse>
      getCancelResumableWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelResumableWrite",
      requestType = com.google.storage.v2.CancelResumableWriteRequest.class,
      responseType = com.google.storage.v2.CancelResumableWriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.CancelResumableWriteRequest,
          com.google.storage.v2.CancelResumableWriteResponse>
      getCancelResumableWriteMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.CancelResumableWriteRequest,
            com.google.storage.v2.CancelResumableWriteResponse>
        getCancelResumableWriteMethod;
    if ((getCancelResumableWriteMethod = StorageGrpc.getCancelResumableWriteMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getCancelResumableWriteMethod = StorageGrpc.getCancelResumableWriteMethod) == null) {
          StorageGrpc.getCancelResumableWriteMethod =
              getCancelResumableWriteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.CancelResumableWriteRequest,
                          com.google.storage.v2.CancelResumableWriteResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CancelResumableWrite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.CancelResumableWriteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.CancelResumableWriteResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageMethodDescriptorSupplier("CancelResumableWrite"))
                      .build();
        }
      }
    }
    return getCancelResumableWriteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.GetObjectRequest, com.google.storage.v2.Object>
      getGetObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetObject",
      requestType = com.google.storage.v2.GetObjectRequest.class,
      responseType = com.google.storage.v2.Object.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.GetObjectRequest, com.google.storage.v2.Object>
      getGetObjectMethod() {
    io.grpc.MethodDescriptor<com.google.storage.v2.GetObjectRequest, com.google.storage.v2.Object>
        getGetObjectMethod;
    if ((getGetObjectMethod = StorageGrpc.getGetObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getGetObjectMethod = StorageGrpc.getGetObjectMethod) == null) {
          StorageGrpc.getGetObjectMethod =
              getGetObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.GetObjectRequest, com.google.storage.v2.Object>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.GetObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Object.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("GetObject"))
                      .build();
        }
      }
    }
    return getGetObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.ReadObjectRequest, com.google.storage.v2.ReadObjectResponse>
      getReadObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadObject",
      requestType = com.google.storage.v2.ReadObjectRequest.class,
      responseType = com.google.storage.v2.ReadObjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.ReadObjectRequest, com.google.storage.v2.ReadObjectResponse>
      getReadObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.ReadObjectRequest, com.google.storage.v2.ReadObjectResponse>
        getReadObjectMethod;
    if ((getReadObjectMethod = StorageGrpc.getReadObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getReadObjectMethod = StorageGrpc.getReadObjectMethod) == null) {
          StorageGrpc.getReadObjectMethod =
              getReadObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.ReadObjectRequest,
                          com.google.storage.v2.ReadObjectResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.ReadObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.ReadObjectResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("ReadObject"))
                      .build();
        }
      }
    }
    return getReadObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.BidiReadObjectRequest, com.google.storage.v2.BidiReadObjectResponse>
      getBidiReadObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidiReadObject",
      requestType = com.google.storage.v2.BidiReadObjectRequest.class,
      responseType = com.google.storage.v2.BidiReadObjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.BidiReadObjectRequest, com.google.storage.v2.BidiReadObjectResponse>
      getBidiReadObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.BidiReadObjectRequest,
            com.google.storage.v2.BidiReadObjectResponse>
        getBidiReadObjectMethod;
    if ((getBidiReadObjectMethod = StorageGrpc.getBidiReadObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getBidiReadObjectMethod = StorageGrpc.getBidiReadObjectMethod) == null) {
          StorageGrpc.getBidiReadObjectMethod =
              getBidiReadObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.BidiReadObjectRequest,
                          com.google.storage.v2.BidiReadObjectResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BidiReadObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.BidiReadObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.BidiReadObjectResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("BidiReadObject"))
                      .build();
        }
      }
    }
    return getBidiReadObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.UpdateObjectRequest, com.google.storage.v2.Object>
      getUpdateObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateObject",
      requestType = com.google.storage.v2.UpdateObjectRequest.class,
      responseType = com.google.storage.v2.Object.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.UpdateObjectRequest, com.google.storage.v2.Object>
      getUpdateObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.UpdateObjectRequest, com.google.storage.v2.Object>
        getUpdateObjectMethod;
    if ((getUpdateObjectMethod = StorageGrpc.getUpdateObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getUpdateObjectMethod = StorageGrpc.getUpdateObjectMethod) == null) {
          StorageGrpc.getUpdateObjectMethod =
              getUpdateObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.UpdateObjectRequest, com.google.storage.v2.Object>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.UpdateObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Object.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("UpdateObject"))
                      .build();
        }
      }
    }
    return getUpdateObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.WriteObjectRequest, com.google.storage.v2.WriteObjectResponse>
      getWriteObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteObject",
      requestType = com.google.storage.v2.WriteObjectRequest.class,
      responseType = com.google.storage.v2.WriteObjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.WriteObjectRequest, com.google.storage.v2.WriteObjectResponse>
      getWriteObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.WriteObjectRequest, com.google.storage.v2.WriteObjectResponse>
        getWriteObjectMethod;
    if ((getWriteObjectMethod = StorageGrpc.getWriteObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getWriteObjectMethod = StorageGrpc.getWriteObjectMethod) == null) {
          StorageGrpc.getWriteObjectMethod =
              getWriteObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.WriteObjectRequest,
                          com.google.storage.v2.WriteObjectResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.WriteObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.WriteObjectResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("WriteObject"))
                      .build();
        }
      }
    }
    return getWriteObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.BidiWriteObjectRequest,
          com.google.storage.v2.BidiWriteObjectResponse>
      getBidiWriteObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidiWriteObject",
      requestType = com.google.storage.v2.BidiWriteObjectRequest.class,
      responseType = com.google.storage.v2.BidiWriteObjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.BidiWriteObjectRequest,
          com.google.storage.v2.BidiWriteObjectResponse>
      getBidiWriteObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.BidiWriteObjectRequest,
            com.google.storage.v2.BidiWriteObjectResponse>
        getBidiWriteObjectMethod;
    if ((getBidiWriteObjectMethod = StorageGrpc.getBidiWriteObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getBidiWriteObjectMethod = StorageGrpc.getBidiWriteObjectMethod) == null) {
          StorageGrpc.getBidiWriteObjectMethod =
              getBidiWriteObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.BidiWriteObjectRequest,
                          com.google.storage.v2.BidiWriteObjectResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BidiWriteObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.BidiWriteObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.BidiWriteObjectResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("BidiWriteObject"))
                      .build();
        }
      }
    }
    return getBidiWriteObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.ListObjectsRequest, com.google.storage.v2.ListObjectsResponse>
      getListObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListObjects",
      requestType = com.google.storage.v2.ListObjectsRequest.class,
      responseType = com.google.storage.v2.ListObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.ListObjectsRequest, com.google.storage.v2.ListObjectsResponse>
      getListObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.ListObjectsRequest, com.google.storage.v2.ListObjectsResponse>
        getListObjectsMethod;
    if ((getListObjectsMethod = StorageGrpc.getListObjectsMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getListObjectsMethod = StorageGrpc.getListObjectsMethod) == null) {
          StorageGrpc.getListObjectsMethod =
              getListObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.ListObjectsRequest,
                          com.google.storage.v2.ListObjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.ListObjectsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.ListObjectsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("ListObjects"))
                      .build();
        }
      }
    }
    return getListObjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.RewriteObjectRequest, com.google.storage.v2.RewriteResponse>
      getRewriteObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RewriteObject",
      requestType = com.google.storage.v2.RewriteObjectRequest.class,
      responseType = com.google.storage.v2.RewriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.RewriteObjectRequest, com.google.storage.v2.RewriteResponse>
      getRewriteObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.RewriteObjectRequest, com.google.storage.v2.RewriteResponse>
        getRewriteObjectMethod;
    if ((getRewriteObjectMethod = StorageGrpc.getRewriteObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getRewriteObjectMethod = StorageGrpc.getRewriteObjectMethod) == null) {
          StorageGrpc.getRewriteObjectMethod =
              getRewriteObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.RewriteObjectRequest,
                          com.google.storage.v2.RewriteResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RewriteObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.RewriteObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.RewriteResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("RewriteObject"))
                      .build();
        }
      }
    }
    return getRewriteObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.StartResumableWriteRequest,
          com.google.storage.v2.StartResumableWriteResponse>
      getStartResumableWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartResumableWrite",
      requestType = com.google.storage.v2.StartResumableWriteRequest.class,
      responseType = com.google.storage.v2.StartResumableWriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.StartResumableWriteRequest,
          com.google.storage.v2.StartResumableWriteResponse>
      getStartResumableWriteMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.StartResumableWriteRequest,
            com.google.storage.v2.StartResumableWriteResponse>
        getStartResumableWriteMethod;
    if ((getStartResumableWriteMethod = StorageGrpc.getStartResumableWriteMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getStartResumableWriteMethod = StorageGrpc.getStartResumableWriteMethod) == null) {
          StorageGrpc.getStartResumableWriteMethod =
              getStartResumableWriteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.StartResumableWriteRequest,
                          com.google.storage.v2.StartResumableWriteResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StartResumableWrite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.StartResumableWriteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.StartResumableWriteResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageMethodDescriptorSupplier("StartResumableWrite"))
                      .build();
        }
      }
    }
    return getStartResumableWriteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.QueryWriteStatusRequest,
          com.google.storage.v2.QueryWriteStatusResponse>
      getQueryWriteStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryWriteStatus",
      requestType = com.google.storage.v2.QueryWriteStatusRequest.class,
      responseType = com.google.storage.v2.QueryWriteStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.QueryWriteStatusRequest,
          com.google.storage.v2.QueryWriteStatusResponse>
      getQueryWriteStatusMethod() {
    io.grpc.MethodDescriptor<
            com.google.storage.v2.QueryWriteStatusRequest,
            com.google.storage.v2.QueryWriteStatusResponse>
        getQueryWriteStatusMethod;
    if ((getQueryWriteStatusMethod = StorageGrpc.getQueryWriteStatusMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getQueryWriteStatusMethod = StorageGrpc.getQueryWriteStatusMethod) == null) {
          StorageGrpc.getQueryWriteStatusMethod =
              getQueryWriteStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.QueryWriteStatusRequest,
                          com.google.storage.v2.QueryWriteStatusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryWriteStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.QueryWriteStatusRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.QueryWriteStatusResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("QueryWriteStatus"))
                      .build();
        }
      }
    }
    return getQueryWriteStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.storage.v2.MoveObjectRequest, com.google.storage.v2.Object>
      getMoveObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MoveObject",
      requestType = com.google.storage.v2.MoveObjectRequest.class,
      responseType = com.google.storage.v2.Object.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.storage.v2.MoveObjectRequest, com.google.storage.v2.Object>
      getMoveObjectMethod() {
    io.grpc.MethodDescriptor<com.google.storage.v2.MoveObjectRequest, com.google.storage.v2.Object>
        getMoveObjectMethod;
    if ((getMoveObjectMethod = StorageGrpc.getMoveObjectMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getMoveObjectMethod = StorageGrpc.getMoveObjectMethod) == null) {
          StorageGrpc.getMoveObjectMethod =
              getMoveObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.storage.v2.MoveObjectRequest, com.google.storage.v2.Object>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MoveObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.MoveObjectRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.storage.v2.Object.getDefaultInstance()))
                      .setSchemaDescriptor(new StorageMethodDescriptorSupplier("MoveObject"))
                      .build();
        }
      }
    }
    return getMoveObjectMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static StorageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageStub>() {
          @java.lang.Override
          public StorageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageStub(channel, callOptions);
          }
        };
    return StorageStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static StorageBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageBlockingV2Stub>() {
          @java.lang.Override
          public StorageBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageBlockingV2Stub(channel, callOptions);
          }
        };
    return StorageBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageBlockingStub>() {
          @java.lang.Override
          public StorageBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageBlockingStub(channel, callOptions);
          }
        };
    return StorageBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static StorageFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageFutureStub>() {
          @java.lang.Override
          public StorageFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageFutureStub(channel, callOptions);
          }
        };
    return StorageFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * ## API Overview and Naming Syntax
   * The Cloud Storage gRPC API allows applications to read and write data through
   * the abstractions of buckets and objects. For a description of these
   * abstractions please see [Cloud Storage
   * documentation](https://cloud.google.com/storage/docs).
   * Resources are named as follows:
   *   - Projects are referred to as they are defined by the Resource Manager API,
   *     using strings like `projects/123456` or `projects/my-string-id`.
   *   - Buckets are named using string names of the form:
   *     `projects/{project}/buckets/{bucket}`.
   *     For globally unique buckets, `_` might be substituted for the project.
   *   - Objects are uniquely identified by their name along with the name of the
   *     bucket they belong to, as separate strings in this API. For example:
   *         ```
   *         ReadObjectRequest {
   *         bucket: 'projects/_/buckets/my-bucket'
   *         object: 'my-object'
   *         }
   *         ```
   * Note that object names can contain `/` characters, which are treated as
   * any other character (no special directory semantics).
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty bucket.
     * The request fails if there are any live or
     * noncurrent objects in the bucket, but the request succeeds if the
     * bucket only contains soft-deleted objects or incomplete uploads, such
     * as ongoing XML API multipart uploads. Does not permanently delete
     * soft-deleted objects.
     * When this API is used to delete a bucket containing an object that has a
     * soft delete policy
     * enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the
     * object.
     * Objects and multipart uploads that were in the bucket at the time of
     * deletion are also retained for the specified retention duration. When
     * a soft-deleted bucket reaches the end of its retention duration, it
     * is permanently deleted. The `hardDeleteTime` of the bucket always
     * equals
     * or exceeds the expiration time of the last soft-deleted object in the
     * bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.delete` IAM permission on the bucket.
     * </pre>
     */
    default void deleteBucket(
        com.google.storage.v2.DeleteBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.get`
     * IAM permission on
     * the bucket. Additionally, to return specific bucket metadata, the
     * authenticated user must have the following permissions:
     * - To return the IAM policies: `storage.buckets.getIamPolicy`
     * - To return the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    default void getBucket(
        com.google.storage.v2.GetBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.create` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To enable object retention using the `enableObjectRetention` query
     * parameter: `storage.buckets.enableObjectRetention`
     * - To set the bucket IP filtering rules: `storage.buckets.setIpFilter`
     * </pre>
     */
    default void createBucket(
        com.google.storage.v2.CreateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of buckets for a given project, ordered
     * lexicographically by name.
     * **IAM Permissions**:
     * Requires `storage.buckets.list` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated
     * user must have the following permissions:
     * - To list the IAM policies: `storage.buckets.getIamPolicy`
     * - To list the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    default void listBuckets(
        com.google.storage.v2.ListBucketsRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.ListBucketsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBucketsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently locks the retention
     * policy that is
     * currently applied to the specified bucket.
     * Caution: Locking a bucket is an
     * irreversible action. Once you lock a bucket:
     * - You cannot remove the retention policy from the bucket.
     * - You cannot decrease the retention period for the policy.
     * Once locked, you must delete the entire bucket in order to remove the
     * bucket's retention policy. However, before you can delete the bucket, you
     * must delete all the objects in the bucket, which is only
     * possible if all the objects have reached the retention period set by the
     * retention policy.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * </pre>
     */
    default void lockBucketRetentionPolicy(
        com.google.storage.v2.LockBucketRetentionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLockBucketRetentionPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * **IAM Permissions**:
     * Requires `storage.buckets.getIamPolicy` on the bucket or
     * `storage.managedFolders.getIamPolicy` IAM permission on the
     * managed folder.
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an IAM policy for the specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller. The `resource` field in the
     * request should be `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a bucket. Changes to the bucket are readable immediately after
     * writing, but configuration changes might take time to propagate. This
     * method supports `patch` semantics.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To set bucket IP filtering rules: `storage.buckets.setIpFilter`
     * - To update public access prevention policies or access control lists
     * (ACLs): `storage.buckets.setIamPolicy`
     * </pre>
     */
    default void updateBucket(
        com.google.storage.v2.UpdateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBucketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Concatenates a list of existing objects into a new object in the same
     * bucket. The existing source objects are unaffected by this operation.
     * **IAM Permissions**:
     * Requires the `storage.objects.create` and `storage.objects.get` IAM
     * permissions to use this method. If the new composite object
     * overwrites an existing object, the authenticated user must also have
     * the `storage.objects.delete` permission. If the request body includes
     * the retention property, the authenticated user must also have the
     * `storage.objects.setRetention` IAM permission.
     * </pre>
     */
    default void composeObject(
        com.google.storage.v2.ComposeObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComposeObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an object and its metadata. Deletions are permanent if versioning
     * is not enabled for the bucket, or if the generation parameter is used, or
     * if soft delete is not
     * enabled for the bucket.
     * When this API is used to delete an object from a bucket that has soft
     * delete policy enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the object.
     * This API cannot be used to permanently delete soft-deleted objects.
     * Soft-deleted objects are permanently deleted according to their
     * `hardDeleteTime`.
     * You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject]
     * API to restore soft-deleted objects until the soft delete retention period
     * has passed.
     * **IAM Permissions**:
     * Requires `storage.objects.delete` IAM permission on the bucket.
     * </pre>
     */
    default void deleteObject(
        com.google.storage.v2.DeleteObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a
     * soft-deleted object.
     * When a soft-deleted object is restored, a new copy of that object is
     * created in the same bucket and inherits the same metadata as the
     * soft-deleted object. The inherited metadata is the metadata that existed
     * when the original object became soft deleted, with the following
     * exceptions:
     *   - The `createTime` of the new object is set to the time at which the
     *   soft-deleted object was restored.
     *   - The `softDeleteTime` and `hardDeleteTime` values are cleared.
     *   - A new generation is assigned and the metageneration is reset to 1.
     *   - If the soft-deleted object was in a bucket that had Autoclass enabled,
     *   the new object is
     *     restored to Standard storage.
     *   - The restored object inherits the bucket's default object ACL, unless
     *   `copySourceAcl` is `true`.
     * If a live object using the same name already exists in the bucket and
     * becomes overwritten, the live object becomes a noncurrent object if Object
     * Versioning is enabled on the bucket. If Object Versioning is not enabled,
     * the live object becomes soft deleted.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.restore`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     *   - `storage.objects.getIamPolicy` (only required if `projection` is `full`
     *   and the relevant bucket
     *     has uniform bucket-level access disabled)
     *   - `storage.objects.setIamPolicy` (only required if `copySourceAcl` is
     *   `true` and the relevant
     *     bucket has uniform bucket-level access disabled)
     * </pre>
     */
    default void restoreObject(
        com.google.storage.v2.RestoreObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels an in-progress resumable upload.
     * Any attempts to write to the resumable upload after cancelling the upload
     * fail.
     * The behavior for any in-progress write operations is not guaranteed;
     * they could either complete before the cancellation or fail if the
     * cancellation completes first.
     * </pre>
     */
    default void cancelResumableWrite(
        com.google.storage.v2.CancelResumableWriteRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.CancelResumableWriteResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelResumableWriteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object metadata.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * To return object ACLs, the authenticated user must also have
     * the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    default void getObject(
        com.google.storage.v2.GetObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object data.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * </pre>
     */
    default void readObject(
        com.google.storage.v2.ReadObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.ReadObjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads an object's data.
     * This bi-directional API reads data from an object, allowing you to request
     * multiple data ranges within a single stream, even across several messages.
     * If an error occurs with any request, the stream closes with a relevant
     * error code. Since you can have multiple outstanding requests, the error
     * response includes a `BidiReadObjectError` proto in its `details` field,
     * reporting the specific error, if any, for each pending `read_id`.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.storage.v2.BidiReadObjectRequest> bidiReadObject(
        io.grpc.stub.StreamObserver<com.google.storage.v2.BidiReadObjectResponse>
            responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getBidiReadObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an object's metadata.
     * Equivalent to JSON API's `storage.objects.patch` method.
     * **IAM Permissions**:
     * Requires `storage.objects.update` IAM permission on the bucket.
     * </pre>
     */
    default void updateObject(
        com.google.storage.v2.UpdateObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stores a new object and metadata.
     * An object can be written either in a single message stream or in a
     * resumable sequence of message streams. To write using a single stream,
     * the client should include in the first message of the stream an
     * `WriteObjectSpec` describing the destination bucket, object, and any
     * preconditions. Additionally, the final message must set 'finish_write' to
     * true, or else it is an error.
     * For a resumable write, the client should instead call
     * `StartResumableWrite()`, populating a `WriteObjectSpec` into that request.
     * They should then attach the returned `upload_id` to the first message of
     * each following call to `WriteObject`. If the stream is closed before
     * finishing the upload (either explicitly by the client or due to a network
     * error or an error response from the server), the client should do as
     * follows:
     *   - Check the result Status of the stream, to determine if writing can be
     *     resumed on this stream or must be restarted from scratch (by calling
     *     `StartResumableWrite()`). The resumable errors are `DEADLINE_EXCEEDED`,
     *     `INTERNAL`, and `UNAVAILABLE`. For each case, the client should use
     *     binary exponential backoff before retrying.  Additionally, writes can
     *     be resumed after `RESOURCE_EXHAUSTED` errors, but only after taking
     *     appropriate measures, which might include reducing aggregate send rate
     *     across clients and/or requesting a quota increase for your project.
     *   - If the call to `WriteObject` returns `ABORTED`, that indicates
     *     concurrent attempts to update the resumable write, caused either by
     *     multiple racing clients or by a single client where the previous
     *     request was timed out on the client side but nonetheless reached the
     *     server. In this case the client should take steps to prevent further
     *     concurrent writes. For example, increase the timeouts and stop using
     *     more than one process to perform the upload. Follow the steps below for
     *     resuming the upload.
     *   - For resumable errors, the client should call `QueryWriteStatus()` and
     *     then continue writing from the returned `persisted_size`. This might be
     *     less than the amount of data the client previously sent. Note also that
     *     it is acceptable to send data starting at an offset earlier than the
     *     returned `persisted_size`; in this case, the service skips data at
     *     offsets that were already persisted (without checking that it matches
     *     the previously written data), and write only the data starting from the
     *     persisted offset. Even though the data isn't written, it might still
     *     incur a performance cost over resuming at the correct write offset.
     *     This behavior can make client-side handling simpler in some cases.
     *   - Clients must only send data that is a multiple of 256 KiB per message,
     *     unless the object is being finished with `finish_write` set to `true`.
     * The service does not view the object as complete until the client has
     * sent a `WriteObjectRequest` with `finish_write` set to `true`. Sending any
     * requests on a stream after sending a request with `finish_write` set to
     * `true` causes an error. The client must check the response it
     * receives to determine how much data the service is able to commit and
     * whether the service views the object as complete.
     * Attempting to resume an already finalized object results in an `OK`
     * status, with a `WriteObjectResponse` containing the finalized object's
     * metadata.
     * Alternatively, you can use the `BidiWriteObject` operation to write an
     * object with controls over flushing and the ability to fetch the ability to
     * determine the current persisted size.
     * **IAM Permissions**:
     * Requires `storage.objects.create`
     * IAM permission on
     * the bucket.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.storage.v2.WriteObjectRequest> writeObject(
        io.grpc.stub.StreamObserver<com.google.storage.v2.WriteObjectResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getWriteObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stores a new object and metadata.
     * This is similar to the `WriteObject` call with the added support for
     * manual flushing of persisted state, and the ability to determine current
     * persisted size without closing the stream.
     * The client might specify one or both of the `state_lookup` and `flush`
     * fields in each `BidiWriteObjectRequest`. If `flush` is specified, the data
     * written so far is persisted to storage. If `state_lookup` is specified, the
     * service responds with a `BidiWriteObjectResponse` that contains the
     * persisted size. If both `flush` and `state_lookup` are specified, the flush
     * always occurs before a `state_lookup`, so that both might be set in the
     * same request and the returned state is the state of the object
     * post-flush. When the stream is closed, a `BidiWriteObjectResponse`
     * is always sent to the client, regardless of the value of `state_lookup`.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.storage.v2.BidiWriteObjectRequest>
        bidiWriteObject(
            io.grpc.stub.StreamObserver<com.google.storage.v2.BidiWriteObjectResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getBidiWriteObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of objects matching the criteria.
     * **IAM Permissions**:
     * The authenticated user requires `storage.objects.list`
     * IAM permission to use this method. To return object ACLs, the
     * authenticated user must also
     * have the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    default void listObjects(
        com.google.storage.v2.ListObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.ListObjectsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListObjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rewrites a source object to a destination object. Optionally overrides
     * metadata.
     * </pre>
     */
    default void rewriteObject(
        com.google.storage.v2.RewriteObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.RewriteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRewriteObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a resumable write operation. This
     * method is part of the Resumable
     * upload feature.
     * This allows you to upload large objects in multiple chunks, which is more
     * resilient to network interruptions than a single upload. The validity
     * duration of the write operation, and the consequences of it becoming
     * invalid, are service-dependent.
     * **IAM Permissions**:
     * Requires `storage.objects.create` IAM permission on the bucket.
     * </pre>
     */
    default void startResumableWrite(
        com.google.storage.v2.StartResumableWriteRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.StartResumableWriteResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartResumableWriteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Determines the `persisted_size` of an object that is being written. This
     * method is part of the resumable
     * upload feature.
     * The returned value is the size of the object that has been persisted so
     * far. The value can be used as the `write_offset` for the next `Write()`
     * call.
     * If the object does not exist, meaning if it was deleted, or the
     * first `Write()` has not yet reached the service, this method returns the
     * error `NOT_FOUND`.
     * This method is useful for clients that buffer data and need to know which
     * data can be safely evicted. The client can call `QueryWriteStatus()` at any
     * time to determine how much data has been logged for this object.
     * For any sequence of `QueryWriteStatus()` calls for a given
     * object name, the sequence of returned `persisted_size` values are
     * non-decreasing.
     * </pre>
     */
    default void queryWriteStatus(
        com.google.storage.v2.QueryWriteStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.QueryWriteStatusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryWriteStatusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Moves the source object to the destination object in the same bucket.
     * This operation moves a source object to a destination object in the
     * same bucket by renaming the object. The move itself is an atomic
     * transaction, ensuring all steps either complete successfully or no
     * changes are made.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.move`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     * </pre>
     */
    default void moveObject(
        com.google.storage.v2.MoveObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMoveObjectMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Storage.
   *
   * <pre>
   * ## API Overview and Naming Syntax
   * The Cloud Storage gRPC API allows applications to read and write data through
   * the abstractions of buckets and objects. For a description of these
   * abstractions please see [Cloud Storage
   * documentation](https://cloud.google.com/storage/docs).
   * Resources are named as follows:
   *   - Projects are referred to as they are defined by the Resource Manager API,
   *     using strings like `projects/123456` or `projects/my-string-id`.
   *   - Buckets are named using string names of the form:
   *     `projects/{project}/buckets/{bucket}`.
   *     For globally unique buckets, `_` might be substituted for the project.
   *   - Objects are uniquely identified by their name along with the name of the
   *     bucket they belong to, as separate strings in this API. For example:
   *         ```
   *         ReadObjectRequest {
   *         bucket: 'projects/_/buckets/my-bucket'
   *         object: 'my-object'
   *         }
   *         ```
   * Note that object names can contain `/` characters, which are treated as
   * any other character (no special directory semantics).
   * </pre>
   */
  public abstract static class StorageImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return StorageGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Storage.
   *
   * <pre>
   * ## API Overview and Naming Syntax
   * The Cloud Storage gRPC API allows applications to read and write data through
   * the abstractions of buckets and objects. For a description of these
   * abstractions please see [Cloud Storage
   * documentation](https://cloud.google.com/storage/docs).
   * Resources are named as follows:
   *   - Projects are referred to as they are defined by the Resource Manager API,
   *     using strings like `projects/123456` or `projects/my-string-id`.
   *   - Buckets are named using string names of the form:
   *     `projects/{project}/buckets/{bucket}`.
   *     For globally unique buckets, `_` might be substituted for the project.
   *   - Objects are uniquely identified by their name along with the name of the
   *     bucket they belong to, as separate strings in this API. For example:
   *         ```
   *         ReadObjectRequest {
   *         bucket: 'projects/_/buckets/my-bucket'
   *         object: 'my-object'
   *         }
   *         ```
   * Note that object names can contain `/` characters, which are treated as
   * any other character (no special directory semantics).
   * </pre>
   */
  public static final class StorageStub extends io.grpc.stub.AbstractAsyncStub<StorageStub> {
    private StorageStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty bucket.
     * The request fails if there are any live or
     * noncurrent objects in the bucket, but the request succeeds if the
     * bucket only contains soft-deleted objects or incomplete uploads, such
     * as ongoing XML API multipart uploads. Does not permanently delete
     * soft-deleted objects.
     * When this API is used to delete a bucket containing an object that has a
     * soft delete policy
     * enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the
     * object.
     * Objects and multipart uploads that were in the bucket at the time of
     * deletion are also retained for the specified retention duration. When
     * a soft-deleted bucket reaches the end of its retention duration, it
     * is permanently deleted. The `hardDeleteTime` of the bucket always
     * equals
     * or exceeds the expiration time of the last soft-deleted object in the
     * bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.delete` IAM permission on the bucket.
     * </pre>
     */
    public void deleteBucket(
        com.google.storage.v2.DeleteBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.get`
     * IAM permission on
     * the bucket. Additionally, to return specific bucket metadata, the
     * authenticated user must have the following permissions:
     * - To return the IAM policies: `storage.buckets.getIamPolicy`
     * - To return the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    public void getBucket(
        com.google.storage.v2.GetBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBucketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.create` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To enable object retention using the `enableObjectRetention` query
     * parameter: `storage.buckets.enableObjectRetention`
     * - To set the bucket IP filtering rules: `storage.buckets.setIpFilter`
     * </pre>
     */
    public void createBucket(
        com.google.storage.v2.CreateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of buckets for a given project, ordered
     * lexicographically by name.
     * **IAM Permissions**:
     * Requires `storage.buckets.list` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated
     * user must have the following permissions:
     * - To list the IAM policies: `storage.buckets.getIamPolicy`
     * - To list the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    public void listBuckets(
        com.google.storage.v2.ListBucketsRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.ListBucketsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBucketsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently locks the retention
     * policy that is
     * currently applied to the specified bucket.
     * Caution: Locking a bucket is an
     * irreversible action. Once you lock a bucket:
     * - You cannot remove the retention policy from the bucket.
     * - You cannot decrease the retention period for the policy.
     * Once locked, you must delete the entire bucket in order to remove the
     * bucket's retention policy. However, before you can delete the bucket, you
     * must delete all the objects in the bucket, which is only
     * possible if all the objects have reached the retention period set by the
     * retention policy.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * </pre>
     */
    public void lockBucketRetentionPolicy(
        com.google.storage.v2.LockBucketRetentionPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLockBucketRetentionPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * **IAM Permissions**:
     * Requires `storage.buckets.getIamPolicy` on the bucket or
     * `storage.managedFolders.getIamPolicy` IAM permission on the
     * managed folder.
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
     * Updates an IAM policy for the specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
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
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller. The `resource` field in the
     * request should be `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
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

    /**
     *
     *
     * <pre>
     * Updates a bucket. Changes to the bucket are readable immediately after
     * writing, but configuration changes might take time to propagate. This
     * method supports `patch` semantics.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To set bucket IP filtering rules: `storage.buckets.setIpFilter`
     * - To update public access prevention policies or access control lists
     * (ACLs): `storage.buckets.setIamPolicy`
     * </pre>
     */
    public void updateBucket(
        com.google.storage.v2.UpdateBucketRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBucketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Concatenates a list of existing objects into a new object in the same
     * bucket. The existing source objects are unaffected by this operation.
     * **IAM Permissions**:
     * Requires the `storage.objects.create` and `storage.objects.get` IAM
     * permissions to use this method. If the new composite object
     * overwrites an existing object, the authenticated user must also have
     * the `storage.objects.delete` permission. If the request body includes
     * the retention property, the authenticated user must also have the
     * `storage.objects.setRetention` IAM permission.
     * </pre>
     */
    public void composeObject(
        com.google.storage.v2.ComposeObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComposeObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an object and its metadata. Deletions are permanent if versioning
     * is not enabled for the bucket, or if the generation parameter is used, or
     * if soft delete is not
     * enabled for the bucket.
     * When this API is used to delete an object from a bucket that has soft
     * delete policy enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the object.
     * This API cannot be used to permanently delete soft-deleted objects.
     * Soft-deleted objects are permanently deleted according to their
     * `hardDeleteTime`.
     * You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject]
     * API to restore soft-deleted objects until the soft delete retention period
     * has passed.
     * **IAM Permissions**:
     * Requires `storage.objects.delete` IAM permission on the bucket.
     * </pre>
     */
    public void deleteObject(
        com.google.storage.v2.DeleteObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a
     * soft-deleted object.
     * When a soft-deleted object is restored, a new copy of that object is
     * created in the same bucket and inherits the same metadata as the
     * soft-deleted object. The inherited metadata is the metadata that existed
     * when the original object became soft deleted, with the following
     * exceptions:
     *   - The `createTime` of the new object is set to the time at which the
     *   soft-deleted object was restored.
     *   - The `softDeleteTime` and `hardDeleteTime` values are cleared.
     *   - A new generation is assigned and the metageneration is reset to 1.
     *   - If the soft-deleted object was in a bucket that had Autoclass enabled,
     *   the new object is
     *     restored to Standard storage.
     *   - The restored object inherits the bucket's default object ACL, unless
     *   `copySourceAcl` is `true`.
     * If a live object using the same name already exists in the bucket and
     * becomes overwritten, the live object becomes a noncurrent object if Object
     * Versioning is enabled on the bucket. If Object Versioning is not enabled,
     * the live object becomes soft deleted.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.restore`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     *   - `storage.objects.getIamPolicy` (only required if `projection` is `full`
     *   and the relevant bucket
     *     has uniform bucket-level access disabled)
     *   - `storage.objects.setIamPolicy` (only required if `copySourceAcl` is
     *   `true` and the relevant
     *     bucket has uniform bucket-level access disabled)
     * </pre>
     */
    public void restoreObject(
        com.google.storage.v2.RestoreObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels an in-progress resumable upload.
     * Any attempts to write to the resumable upload after cancelling the upload
     * fail.
     * The behavior for any in-progress write operations is not guaranteed;
     * they could either complete before the cancellation or fail if the
     * cancellation completes first.
     * </pre>
     */
    public void cancelResumableWrite(
        com.google.storage.v2.CancelResumableWriteRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.CancelResumableWriteResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelResumableWriteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object metadata.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * To return object ACLs, the authenticated user must also have
     * the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    public void getObject(
        com.google.storage.v2.GetObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetObjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object data.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * </pre>
     */
    public void readObject(
        com.google.storage.v2.ReadObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.ReadObjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReadObjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reads an object's data.
     * This bi-directional API reads data from an object, allowing you to request
     * multiple data ranges within a single stream, even across several messages.
     * If an error occurs with any request, the stream closes with a relevant
     * error code. Since you can have multiple outstanding requests, the error
     * response includes a `BidiReadObjectError` proto in its `details` field,
     * reporting the specific error, if any, for each pending `read_id`.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.storage.v2.BidiReadObjectRequest> bidiReadObject(
        io.grpc.stub.StreamObserver<com.google.storage.v2.BidiReadObjectResponse>
            responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBidiReadObjectMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an object's metadata.
     * Equivalent to JSON API's `storage.objects.patch` method.
     * **IAM Permissions**:
     * Requires `storage.objects.update` IAM permission on the bucket.
     * </pre>
     */
    public void updateObject(
        com.google.storage.v2.UpdateObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stores a new object and metadata.
     * An object can be written either in a single message stream or in a
     * resumable sequence of message streams. To write using a single stream,
     * the client should include in the first message of the stream an
     * `WriteObjectSpec` describing the destination bucket, object, and any
     * preconditions. Additionally, the final message must set 'finish_write' to
     * true, or else it is an error.
     * For a resumable write, the client should instead call
     * `StartResumableWrite()`, populating a `WriteObjectSpec` into that request.
     * They should then attach the returned `upload_id` to the first message of
     * each following call to `WriteObject`. If the stream is closed before
     * finishing the upload (either explicitly by the client or due to a network
     * error or an error response from the server), the client should do as
     * follows:
     *   - Check the result Status of the stream, to determine if writing can be
     *     resumed on this stream or must be restarted from scratch (by calling
     *     `StartResumableWrite()`). The resumable errors are `DEADLINE_EXCEEDED`,
     *     `INTERNAL`, and `UNAVAILABLE`. For each case, the client should use
     *     binary exponential backoff before retrying.  Additionally, writes can
     *     be resumed after `RESOURCE_EXHAUSTED` errors, but only after taking
     *     appropriate measures, which might include reducing aggregate send rate
     *     across clients and/or requesting a quota increase for your project.
     *   - If the call to `WriteObject` returns `ABORTED`, that indicates
     *     concurrent attempts to update the resumable write, caused either by
     *     multiple racing clients or by a single client where the previous
     *     request was timed out on the client side but nonetheless reached the
     *     server. In this case the client should take steps to prevent further
     *     concurrent writes. For example, increase the timeouts and stop using
     *     more than one process to perform the upload. Follow the steps below for
     *     resuming the upload.
     *   - For resumable errors, the client should call `QueryWriteStatus()` and
     *     then continue writing from the returned `persisted_size`. This might be
     *     less than the amount of data the client previously sent. Note also that
     *     it is acceptable to send data starting at an offset earlier than the
     *     returned `persisted_size`; in this case, the service skips data at
     *     offsets that were already persisted (without checking that it matches
     *     the previously written data), and write only the data starting from the
     *     persisted offset. Even though the data isn't written, it might still
     *     incur a performance cost over resuming at the correct write offset.
     *     This behavior can make client-side handling simpler in some cases.
     *   - Clients must only send data that is a multiple of 256 KiB per message,
     *     unless the object is being finished with `finish_write` set to `true`.
     * The service does not view the object as complete until the client has
     * sent a `WriteObjectRequest` with `finish_write` set to `true`. Sending any
     * requests on a stream after sending a request with `finish_write` set to
     * `true` causes an error. The client must check the response it
     * receives to determine how much data the service is able to commit and
     * whether the service views the object as complete.
     * Attempting to resume an already finalized object results in an `OK`
     * status, with a `WriteObjectResponse` containing the finalized object's
     * metadata.
     * Alternatively, you can use the `BidiWriteObject` operation to write an
     * object with controls over flushing and the ability to fetch the ability to
     * determine the current persisted size.
     * **IAM Permissions**:
     * Requires `storage.objects.create`
     * IAM permission on
     * the bucket.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.storage.v2.WriteObjectRequest> writeObject(
        io.grpc.stub.StreamObserver<com.google.storage.v2.WriteObjectResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getWriteObjectMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stores a new object and metadata.
     * This is similar to the `WriteObject` call with the added support for
     * manual flushing of persisted state, and the ability to determine current
     * persisted size without closing the stream.
     * The client might specify one or both of the `state_lookup` and `flush`
     * fields in each `BidiWriteObjectRequest`. If `flush` is specified, the data
     * written so far is persisted to storage. If `state_lookup` is specified, the
     * service responds with a `BidiWriteObjectResponse` that contains the
     * persisted size. If both `flush` and `state_lookup` are specified, the flush
     * always occurs before a `state_lookup`, so that both might be set in the
     * same request and the returned state is the state of the object
     * post-flush. When the stream is closed, a `BidiWriteObjectResponse`
     * is always sent to the client, regardless of the value of `state_lookup`.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.storage.v2.BidiWriteObjectRequest>
        bidiWriteObject(
            io.grpc.stub.StreamObserver<com.google.storage.v2.BidiWriteObjectResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBidiWriteObjectMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of objects matching the criteria.
     * **IAM Permissions**:
     * The authenticated user requires `storage.objects.list`
     * IAM permission to use this method. To return object ACLs, the
     * authenticated user must also
     * have the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    public void listObjects(
        com.google.storage.v2.ListObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.ListObjectsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rewrites a source object to a destination object. Optionally overrides
     * metadata.
     * </pre>
     */
    public void rewriteObject(
        com.google.storage.v2.RewriteObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.RewriteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRewriteObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a resumable write operation. This
     * method is part of the Resumable
     * upload feature.
     * This allows you to upload large objects in multiple chunks, which is more
     * resilient to network interruptions than a single upload. The validity
     * duration of the write operation, and the consequences of it becoming
     * invalid, are service-dependent.
     * **IAM Permissions**:
     * Requires `storage.objects.create` IAM permission on the bucket.
     * </pre>
     */
    public void startResumableWrite(
        com.google.storage.v2.StartResumableWriteRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.StartResumableWriteResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartResumableWriteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Determines the `persisted_size` of an object that is being written. This
     * method is part of the resumable
     * upload feature.
     * The returned value is the size of the object that has been persisted so
     * far. The value can be used as the `write_offset` for the next `Write()`
     * call.
     * If the object does not exist, meaning if it was deleted, or the
     * first `Write()` has not yet reached the service, this method returns the
     * error `NOT_FOUND`.
     * This method is useful for clients that buffer data and need to know which
     * data can be safely evicted. The client can call `QueryWriteStatus()` at any
     * time to determine how much data has been logged for this object.
     * For any sequence of `QueryWriteStatus()` calls for a given
     * object name, the sequence of returned `persisted_size` values are
     * non-decreasing.
     * </pre>
     */
    public void queryWriteStatus(
        com.google.storage.v2.QueryWriteStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.QueryWriteStatusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryWriteStatusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Moves the source object to the destination object in the same bucket.
     * This operation moves a source object to a destination object in the
     * same bucket by renaming the object. The move itself is an atomic
     * transaction, ensuring all steps either complete successfully or no
     * changes are made.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.move`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     * </pre>
     */
    public void moveObject(
        com.google.storage.v2.MoveObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.storage.v2.Object> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMoveObjectMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Storage.
   *
   * <pre>
   * ## API Overview and Naming Syntax
   * The Cloud Storage gRPC API allows applications to read and write data through
   * the abstractions of buckets and objects. For a description of these
   * abstractions please see [Cloud Storage
   * documentation](https://cloud.google.com/storage/docs).
   * Resources are named as follows:
   *   - Projects are referred to as they are defined by the Resource Manager API,
   *     using strings like `projects/123456` or `projects/my-string-id`.
   *   - Buckets are named using string names of the form:
   *     `projects/{project}/buckets/{bucket}`.
   *     For globally unique buckets, `_` might be substituted for the project.
   *   - Objects are uniquely identified by their name along with the name of the
   *     bucket they belong to, as separate strings in this API. For example:
   *         ```
   *         ReadObjectRequest {
   *         bucket: 'projects/_/buckets/my-bucket'
   *         object: 'my-object'
   *         }
   *         ```
   * Note that object names can contain `/` characters, which are treated as
   * any other character (no special directory semantics).
   * </pre>
   */
  public static final class StorageBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<StorageBlockingV2Stub> {
    private StorageBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty bucket.
     * The request fails if there are any live or
     * noncurrent objects in the bucket, but the request succeeds if the
     * bucket only contains soft-deleted objects or incomplete uploads, such
     * as ongoing XML API multipart uploads. Does not permanently delete
     * soft-deleted objects.
     * When this API is used to delete a bucket containing an object that has a
     * soft delete policy
     * enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the
     * object.
     * Objects and multipart uploads that were in the bucket at the time of
     * deletion are also retained for the specified retention duration. When
     * a soft-deleted bucket reaches the end of its retention duration, it
     * is permanently deleted. The `hardDeleteTime` of the bucket always
     * equals
     * or exceeds the expiration time of the last soft-deleted object in the
     * bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.delete` IAM permission on the bucket.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBucket(com.google.storage.v2.DeleteBucketRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.get`
     * IAM permission on
     * the bucket. Additionally, to return specific bucket metadata, the
     * authenticated user must have the following permissions:
     * - To return the IAM policies: `storage.buckets.getIamPolicy`
     * - To return the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    public com.google.storage.v2.Bucket getBucket(com.google.storage.v2.GetBucketRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.create` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To enable object retention using the `enableObjectRetention` query
     * parameter: `storage.buckets.enableObjectRetention`
     * - To set the bucket IP filtering rules: `storage.buckets.setIpFilter`
     * </pre>
     */
    public com.google.storage.v2.Bucket createBucket(
        com.google.storage.v2.CreateBucketRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of buckets for a given project, ordered
     * lexicographically by name.
     * **IAM Permissions**:
     * Requires `storage.buckets.list` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated
     * user must have the following permissions:
     * - To list the IAM policies: `storage.buckets.getIamPolicy`
     * - To list the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    public com.google.storage.v2.ListBucketsResponse listBuckets(
        com.google.storage.v2.ListBucketsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBucketsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently locks the retention
     * policy that is
     * currently applied to the specified bucket.
     * Caution: Locking a bucket is an
     * irreversible action. Once you lock a bucket:
     * - You cannot remove the retention policy from the bucket.
     * - You cannot decrease the retention period for the policy.
     * Once locked, you must delete the entire bucket in order to remove the
     * bucket's retention policy. However, before you can delete the bucket, you
     * must delete all the objects in the bucket, which is only
     * possible if all the objects have reached the retention period set by the
     * retention policy.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * </pre>
     */
    public com.google.storage.v2.Bucket lockBucketRetentionPolicy(
        com.google.storage.v2.LockBucketRetentionPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getLockBucketRetentionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * **IAM Permissions**:
     * Requires `storage.buckets.getIamPolicy` on the bucket or
     * `storage.managedFolders.getIamPolicy` IAM permission on the
     * managed folder.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an IAM policy for the specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller. The `resource` field in the
     * request should be `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a bucket. Changes to the bucket are readable immediately after
     * writing, but configuration changes might take time to propagate. This
     * method supports `patch` semantics.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To set bucket IP filtering rules: `storage.buckets.setIpFilter`
     * - To update public access prevention policies or access control lists
     * (ACLs): `storage.buckets.setIamPolicy`
     * </pre>
     */
    public com.google.storage.v2.Bucket updateBucket(
        com.google.storage.v2.UpdateBucketRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Concatenates a list of existing objects into a new object in the same
     * bucket. The existing source objects are unaffected by this operation.
     * **IAM Permissions**:
     * Requires the `storage.objects.create` and `storage.objects.get` IAM
     * permissions to use this method. If the new composite object
     * overwrites an existing object, the authenticated user must also have
     * the `storage.objects.delete` permission. If the request body includes
     * the retention property, the authenticated user must also have the
     * `storage.objects.setRetention` IAM permission.
     * </pre>
     */
    public com.google.storage.v2.Object composeObject(
        com.google.storage.v2.ComposeObjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getComposeObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an object and its metadata. Deletions are permanent if versioning
     * is not enabled for the bucket, or if the generation parameter is used, or
     * if soft delete is not
     * enabled for the bucket.
     * When this API is used to delete an object from a bucket that has soft
     * delete policy enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the object.
     * This API cannot be used to permanently delete soft-deleted objects.
     * Soft-deleted objects are permanently deleted according to their
     * `hardDeleteTime`.
     * You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject]
     * API to restore soft-deleted objects until the soft delete retention period
     * has passed.
     * **IAM Permissions**:
     * Requires `storage.objects.delete` IAM permission on the bucket.
     * </pre>
     */
    public com.google.protobuf.Empty deleteObject(com.google.storage.v2.DeleteObjectRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a
     * soft-deleted object.
     * When a soft-deleted object is restored, a new copy of that object is
     * created in the same bucket and inherits the same metadata as the
     * soft-deleted object. The inherited metadata is the metadata that existed
     * when the original object became soft deleted, with the following
     * exceptions:
     *   - The `createTime` of the new object is set to the time at which the
     *   soft-deleted object was restored.
     *   - The `softDeleteTime` and `hardDeleteTime` values are cleared.
     *   - A new generation is assigned and the metageneration is reset to 1.
     *   - If the soft-deleted object was in a bucket that had Autoclass enabled,
     *   the new object is
     *     restored to Standard storage.
     *   - The restored object inherits the bucket's default object ACL, unless
     *   `copySourceAcl` is `true`.
     * If a live object using the same name already exists in the bucket and
     * becomes overwritten, the live object becomes a noncurrent object if Object
     * Versioning is enabled on the bucket. If Object Versioning is not enabled,
     * the live object becomes soft deleted.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.restore`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     *   - `storage.objects.getIamPolicy` (only required if `projection` is `full`
     *   and the relevant bucket
     *     has uniform bucket-level access disabled)
     *   - `storage.objects.setIamPolicy` (only required if `copySourceAcl` is
     *   `true` and the relevant
     *     bucket has uniform bucket-level access disabled)
     * </pre>
     */
    public com.google.storage.v2.Object restoreObject(
        com.google.storage.v2.RestoreObjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestoreObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an in-progress resumable upload.
     * Any attempts to write to the resumable upload after cancelling the upload
     * fail.
     * The behavior for any in-progress write operations is not guaranteed;
     * they could either complete before the cancellation or fail if the
     * cancellation completes first.
     * </pre>
     */
    public com.google.storage.v2.CancelResumableWriteResponse cancelResumableWrite(
        com.google.storage.v2.CancelResumableWriteRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelResumableWriteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object metadata.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * To return object ACLs, the authenticated user must also have
     * the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    public com.google.storage.v2.Object getObject(com.google.storage.v2.GetObjectRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object data.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.google.storage.v2.ReadObjectResponse> readObject(
        com.google.storage.v2.ReadObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getReadObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reads an object's data.
     * This bi-directional API reads data from an object, allowing you to request
     * multiple data ranges within a single stream, even across several messages.
     * If an error occurs with any request, the stream closes with a relevant
     * error code. Since you can have multiple outstanding requests, the error
     * response includes a `BidiReadObjectError` proto in its `details` field,
     * reporting the specific error, if any, for each pending `read_id`.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.storage.v2.BidiReadObjectRequest,
            com.google.storage.v2.BidiReadObjectResponse>
        bidiReadObject() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getBidiReadObjectMethod(), getCallOptions());
    }

    /**
     *
     *
     * <pre>
     * Updates an object's metadata.
     * Equivalent to JSON API's `storage.objects.patch` method.
     * **IAM Permissions**:
     * Requires `storage.objects.update` IAM permission on the bucket.
     * </pre>
     */
    public com.google.storage.v2.Object updateObject(
        com.google.storage.v2.UpdateObjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stores a new object and metadata.
     * An object can be written either in a single message stream or in a
     * resumable sequence of message streams. To write using a single stream,
     * the client should include in the first message of the stream an
     * `WriteObjectSpec` describing the destination bucket, object, and any
     * preconditions. Additionally, the final message must set 'finish_write' to
     * true, or else it is an error.
     * For a resumable write, the client should instead call
     * `StartResumableWrite()`, populating a `WriteObjectSpec` into that request.
     * They should then attach the returned `upload_id` to the first message of
     * each following call to `WriteObject`. If the stream is closed before
     * finishing the upload (either explicitly by the client or due to a network
     * error or an error response from the server), the client should do as
     * follows:
     *   - Check the result Status of the stream, to determine if writing can be
     *     resumed on this stream or must be restarted from scratch (by calling
     *     `StartResumableWrite()`). The resumable errors are `DEADLINE_EXCEEDED`,
     *     `INTERNAL`, and `UNAVAILABLE`. For each case, the client should use
     *     binary exponential backoff before retrying.  Additionally, writes can
     *     be resumed after `RESOURCE_EXHAUSTED` errors, but only after taking
     *     appropriate measures, which might include reducing aggregate send rate
     *     across clients and/or requesting a quota increase for your project.
     *   - If the call to `WriteObject` returns `ABORTED`, that indicates
     *     concurrent attempts to update the resumable write, caused either by
     *     multiple racing clients or by a single client where the previous
     *     request was timed out on the client side but nonetheless reached the
     *     server. In this case the client should take steps to prevent further
     *     concurrent writes. For example, increase the timeouts and stop using
     *     more than one process to perform the upload. Follow the steps below for
     *     resuming the upload.
     *   - For resumable errors, the client should call `QueryWriteStatus()` and
     *     then continue writing from the returned `persisted_size`. This might be
     *     less than the amount of data the client previously sent. Note also that
     *     it is acceptable to send data starting at an offset earlier than the
     *     returned `persisted_size`; in this case, the service skips data at
     *     offsets that were already persisted (without checking that it matches
     *     the previously written data), and write only the data starting from the
     *     persisted offset. Even though the data isn't written, it might still
     *     incur a performance cost over resuming at the correct write offset.
     *     This behavior can make client-side handling simpler in some cases.
     *   - Clients must only send data that is a multiple of 256 KiB per message,
     *     unless the object is being finished with `finish_write` set to `true`.
     * The service does not view the object as complete until the client has
     * sent a `WriteObjectRequest` with `finish_write` set to `true`. Sending any
     * requests on a stream after sending a request with `finish_write` set to
     * `true` causes an error. The client must check the response it
     * receives to determine how much data the service is able to commit and
     * whether the service views the object as complete.
     * Attempting to resume an already finalized object results in an `OK`
     * status, with a `WriteObjectResponse` containing the finalized object's
     * metadata.
     * Alternatively, you can use the `BidiWriteObject` operation to write an
     * object with controls over flushing and the ability to fetch the ability to
     * determine the current persisted size.
     * **IAM Permissions**:
     * Requires `storage.objects.create`
     * IAM permission on
     * the bucket.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.storage.v2.WriteObjectRequest, com.google.storage.v2.WriteObjectResponse>
        writeObject() {
      return io.grpc.stub.ClientCalls.blockingClientStreamingCall(
          getChannel(), getWriteObjectMethod(), getCallOptions());
    }

    /**
     *
     *
     * <pre>
     * Stores a new object and metadata.
     * This is similar to the `WriteObject` call with the added support for
     * manual flushing of persisted state, and the ability to determine current
     * persisted size without closing the stream.
     * The client might specify one or both of the `state_lookup` and `flush`
     * fields in each `BidiWriteObjectRequest`. If `flush` is specified, the data
     * written so far is persisted to storage. If `state_lookup` is specified, the
     * service responds with a `BidiWriteObjectResponse` that contains the
     * persisted size. If both `flush` and `state_lookup` are specified, the flush
     * always occurs before a `state_lookup`, so that both might be set in the
     * same request and the returned state is the state of the object
     * post-flush. When the stream is closed, a `BidiWriteObjectResponse`
     * is always sent to the client, regardless of the value of `state_lookup`.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.storage.v2.BidiWriteObjectRequest,
            com.google.storage.v2.BidiWriteObjectResponse>
        bidiWriteObject() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getBidiWriteObjectMethod(), getCallOptions());
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of objects matching the criteria.
     * **IAM Permissions**:
     * The authenticated user requires `storage.objects.list`
     * IAM permission to use this method. To return object ACLs, the
     * authenticated user must also
     * have the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    public com.google.storage.v2.ListObjectsResponse listObjects(
        com.google.storage.v2.ListObjectsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rewrites a source object to a destination object. Optionally overrides
     * metadata.
     * </pre>
     */
    public com.google.storage.v2.RewriteResponse rewriteObject(
        com.google.storage.v2.RewriteObjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRewriteObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a resumable write operation. This
     * method is part of the Resumable
     * upload feature.
     * This allows you to upload large objects in multiple chunks, which is more
     * resilient to network interruptions than a single upload. The validity
     * duration of the write operation, and the consequences of it becoming
     * invalid, are service-dependent.
     * **IAM Permissions**:
     * Requires `storage.objects.create` IAM permission on the bucket.
     * </pre>
     */
    public com.google.storage.v2.StartResumableWriteResponse startResumableWrite(
        com.google.storage.v2.StartResumableWriteRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartResumableWriteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Determines the `persisted_size` of an object that is being written. This
     * method is part of the resumable
     * upload feature.
     * The returned value is the size of the object that has been persisted so
     * far. The value can be used as the `write_offset` for the next `Write()`
     * call.
     * If the object does not exist, meaning if it was deleted, or the
     * first `Write()` has not yet reached the service, this method returns the
     * error `NOT_FOUND`.
     * This method is useful for clients that buffer data and need to know which
     * data can be safely evicted. The client can call `QueryWriteStatus()` at any
     * time to determine how much data has been logged for this object.
     * For any sequence of `QueryWriteStatus()` calls for a given
     * object name, the sequence of returned `persisted_size` values are
     * non-decreasing.
     * </pre>
     */
    public com.google.storage.v2.QueryWriteStatusResponse queryWriteStatus(
        com.google.storage.v2.QueryWriteStatusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryWriteStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Moves the source object to the destination object in the same bucket.
     * This operation moves a source object to a destination object in the
     * same bucket by renaming the object. The move itself is an atomic
     * transaction, ensuring all steps either complete successfully or no
     * changes are made.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.move`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     * </pre>
     */
    public com.google.storage.v2.Object moveObject(com.google.storage.v2.MoveObjectRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getMoveObjectMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Storage.
   *
   * <pre>
   * ## API Overview and Naming Syntax
   * The Cloud Storage gRPC API allows applications to read and write data through
   * the abstractions of buckets and objects. For a description of these
   * abstractions please see [Cloud Storage
   * documentation](https://cloud.google.com/storage/docs).
   * Resources are named as follows:
   *   - Projects are referred to as they are defined by the Resource Manager API,
   *     using strings like `projects/123456` or `projects/my-string-id`.
   *   - Buckets are named using string names of the form:
   *     `projects/{project}/buckets/{bucket}`.
   *     For globally unique buckets, `_` might be substituted for the project.
   *   - Objects are uniquely identified by their name along with the name of the
   *     bucket they belong to, as separate strings in this API. For example:
   *         ```
   *         ReadObjectRequest {
   *         bucket: 'projects/_/buckets/my-bucket'
   *         object: 'my-object'
   *         }
   *         ```
   * Note that object names can contain `/` characters, which are treated as
   * any other character (no special directory semantics).
   * </pre>
   */
  public static final class StorageBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StorageBlockingStub> {
    private StorageBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty bucket.
     * The request fails if there are any live or
     * noncurrent objects in the bucket, but the request succeeds if the
     * bucket only contains soft-deleted objects or incomplete uploads, such
     * as ongoing XML API multipart uploads. Does not permanently delete
     * soft-deleted objects.
     * When this API is used to delete a bucket containing an object that has a
     * soft delete policy
     * enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the
     * object.
     * Objects and multipart uploads that were in the bucket at the time of
     * deletion are also retained for the specified retention duration. When
     * a soft-deleted bucket reaches the end of its retention duration, it
     * is permanently deleted. The `hardDeleteTime` of the bucket always
     * equals
     * or exceeds the expiration time of the last soft-deleted object in the
     * bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.delete` IAM permission on the bucket.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBucket(
        com.google.storage.v2.DeleteBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.get`
     * IAM permission on
     * the bucket. Additionally, to return specific bucket metadata, the
     * authenticated user must have the following permissions:
     * - To return the IAM policies: `storage.buckets.getIamPolicy`
     * - To return the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    public com.google.storage.v2.Bucket getBucket(com.google.storage.v2.GetBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.create` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To enable object retention using the `enableObjectRetention` query
     * parameter: `storage.buckets.enableObjectRetention`
     * - To set the bucket IP filtering rules: `storage.buckets.setIpFilter`
     * </pre>
     */
    public com.google.storage.v2.Bucket createBucket(
        com.google.storage.v2.CreateBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of buckets for a given project, ordered
     * lexicographically by name.
     * **IAM Permissions**:
     * Requires `storage.buckets.list` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated
     * user must have the following permissions:
     * - To list the IAM policies: `storage.buckets.getIamPolicy`
     * - To list the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    public com.google.storage.v2.ListBucketsResponse listBuckets(
        com.google.storage.v2.ListBucketsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBucketsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently locks the retention
     * policy that is
     * currently applied to the specified bucket.
     * Caution: Locking a bucket is an
     * irreversible action. Once you lock a bucket:
     * - You cannot remove the retention policy from the bucket.
     * - You cannot decrease the retention period for the policy.
     * Once locked, you must delete the entire bucket in order to remove the
     * bucket's retention policy. However, before you can delete the bucket, you
     * must delete all the objects in the bucket, which is only
     * possible if all the objects have reached the retention period set by the
     * retention policy.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * </pre>
     */
    public com.google.storage.v2.Bucket lockBucketRetentionPolicy(
        com.google.storage.v2.LockBucketRetentionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLockBucketRetentionPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * **IAM Permissions**:
     * Requires `storage.buckets.getIamPolicy` on the bucket or
     * `storage.managedFolders.getIamPolicy` IAM permission on the
     * managed folder.
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
     * Updates an IAM policy for the specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
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
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller. The `resource` field in the
     * request should be `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a bucket. Changes to the bucket are readable immediately after
     * writing, but configuration changes might take time to propagate. This
     * method supports `patch` semantics.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To set bucket IP filtering rules: `storage.buckets.setIpFilter`
     * - To update public access prevention policies or access control lists
     * (ACLs): `storage.buckets.setIamPolicy`
     * </pre>
     */
    public com.google.storage.v2.Bucket updateBucket(
        com.google.storage.v2.UpdateBucketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBucketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Concatenates a list of existing objects into a new object in the same
     * bucket. The existing source objects are unaffected by this operation.
     * **IAM Permissions**:
     * Requires the `storage.objects.create` and `storage.objects.get` IAM
     * permissions to use this method. If the new composite object
     * overwrites an existing object, the authenticated user must also have
     * the `storage.objects.delete` permission. If the request body includes
     * the retention property, the authenticated user must also have the
     * `storage.objects.setRetention` IAM permission.
     * </pre>
     */
    public com.google.storage.v2.Object composeObject(
        com.google.storage.v2.ComposeObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComposeObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an object and its metadata. Deletions are permanent if versioning
     * is not enabled for the bucket, or if the generation parameter is used, or
     * if soft delete is not
     * enabled for the bucket.
     * When this API is used to delete an object from a bucket that has soft
     * delete policy enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the object.
     * This API cannot be used to permanently delete soft-deleted objects.
     * Soft-deleted objects are permanently deleted according to their
     * `hardDeleteTime`.
     * You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject]
     * API to restore soft-deleted objects until the soft delete retention period
     * has passed.
     * **IAM Permissions**:
     * Requires `storage.objects.delete` IAM permission on the bucket.
     * </pre>
     */
    public com.google.protobuf.Empty deleteObject(
        com.google.storage.v2.DeleteObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a
     * soft-deleted object.
     * When a soft-deleted object is restored, a new copy of that object is
     * created in the same bucket and inherits the same metadata as the
     * soft-deleted object. The inherited metadata is the metadata that existed
     * when the original object became soft deleted, with the following
     * exceptions:
     *   - The `createTime` of the new object is set to the time at which the
     *   soft-deleted object was restored.
     *   - The `softDeleteTime` and `hardDeleteTime` values are cleared.
     *   - A new generation is assigned and the metageneration is reset to 1.
     *   - If the soft-deleted object was in a bucket that had Autoclass enabled,
     *   the new object is
     *     restored to Standard storage.
     *   - The restored object inherits the bucket's default object ACL, unless
     *   `copySourceAcl` is `true`.
     * If a live object using the same name already exists in the bucket and
     * becomes overwritten, the live object becomes a noncurrent object if Object
     * Versioning is enabled on the bucket. If Object Versioning is not enabled,
     * the live object becomes soft deleted.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.restore`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     *   - `storage.objects.getIamPolicy` (only required if `projection` is `full`
     *   and the relevant bucket
     *     has uniform bucket-level access disabled)
     *   - `storage.objects.setIamPolicy` (only required if `copySourceAcl` is
     *   `true` and the relevant
     *     bucket has uniform bucket-level access disabled)
     * </pre>
     */
    public com.google.storage.v2.Object restoreObject(
        com.google.storage.v2.RestoreObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an in-progress resumable upload.
     * Any attempts to write to the resumable upload after cancelling the upload
     * fail.
     * The behavior for any in-progress write operations is not guaranteed;
     * they could either complete before the cancellation or fail if the
     * cancellation completes first.
     * </pre>
     */
    public com.google.storage.v2.CancelResumableWriteResponse cancelResumableWrite(
        com.google.storage.v2.CancelResumableWriteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelResumableWriteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object metadata.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * To return object ACLs, the authenticated user must also have
     * the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    public com.google.storage.v2.Object getObject(com.google.storage.v2.GetObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object data.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * </pre>
     */
    public java.util.Iterator<com.google.storage.v2.ReadObjectResponse> readObject(
        com.google.storage.v2.ReadObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReadObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an object's metadata.
     * Equivalent to JSON API's `storage.objects.patch` method.
     * **IAM Permissions**:
     * Requires `storage.objects.update` IAM permission on the bucket.
     * </pre>
     */
    public com.google.storage.v2.Object updateObject(
        com.google.storage.v2.UpdateObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of objects matching the criteria.
     * **IAM Permissions**:
     * The authenticated user requires `storage.objects.list`
     * IAM permission to use this method. To return object ACLs, the
     * authenticated user must also
     * have the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    public com.google.storage.v2.ListObjectsResponse listObjects(
        com.google.storage.v2.ListObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rewrites a source object to a destination object. Optionally overrides
     * metadata.
     * </pre>
     */
    public com.google.storage.v2.RewriteResponse rewriteObject(
        com.google.storage.v2.RewriteObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRewriteObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a resumable write operation. This
     * method is part of the Resumable
     * upload feature.
     * This allows you to upload large objects in multiple chunks, which is more
     * resilient to network interruptions than a single upload. The validity
     * duration of the write operation, and the consequences of it becoming
     * invalid, are service-dependent.
     * **IAM Permissions**:
     * Requires `storage.objects.create` IAM permission on the bucket.
     * </pre>
     */
    public com.google.storage.v2.StartResumableWriteResponse startResumableWrite(
        com.google.storage.v2.StartResumableWriteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartResumableWriteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Determines the `persisted_size` of an object that is being written. This
     * method is part of the resumable
     * upload feature.
     * The returned value is the size of the object that has been persisted so
     * far. The value can be used as the `write_offset` for the next `Write()`
     * call.
     * If the object does not exist, meaning if it was deleted, or the
     * first `Write()` has not yet reached the service, this method returns the
     * error `NOT_FOUND`.
     * This method is useful for clients that buffer data and need to know which
     * data can be safely evicted. The client can call `QueryWriteStatus()` at any
     * time to determine how much data has been logged for this object.
     * For any sequence of `QueryWriteStatus()` calls for a given
     * object name, the sequence of returned `persisted_size` values are
     * non-decreasing.
     * </pre>
     */
    public com.google.storage.v2.QueryWriteStatusResponse queryWriteStatus(
        com.google.storage.v2.QueryWriteStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryWriteStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Moves the source object to the destination object in the same bucket.
     * This operation moves a source object to a destination object in the
     * same bucket by renaming the object. The move itself is an atomic
     * transaction, ensuring all steps either complete successfully or no
     * changes are made.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.move`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     * </pre>
     */
    public com.google.storage.v2.Object moveObject(
        com.google.storage.v2.MoveObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMoveObjectMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Storage.
   *
   * <pre>
   * ## API Overview and Naming Syntax
   * The Cloud Storage gRPC API allows applications to read and write data through
   * the abstractions of buckets and objects. For a description of these
   * abstractions please see [Cloud Storage
   * documentation](https://cloud.google.com/storage/docs).
   * Resources are named as follows:
   *   - Projects are referred to as they are defined by the Resource Manager API,
   *     using strings like `projects/123456` or `projects/my-string-id`.
   *   - Buckets are named using string names of the form:
   *     `projects/{project}/buckets/{bucket}`.
   *     For globally unique buckets, `_` might be substituted for the project.
   *   - Objects are uniquely identified by their name along with the name of the
   *     bucket they belong to, as separate strings in this API. For example:
   *         ```
   *         ReadObjectRequest {
   *         bucket: 'projects/_/buckets/my-bucket'
   *         object: 'my-object'
   *         }
   *         ```
   * Note that object names can contain `/` characters, which are treated as
   * any other character (no special directory semantics).
   * </pre>
   */
  public static final class StorageFutureStub
      extends io.grpc.stub.AbstractFutureStub<StorageFutureStub> {
    private StorageFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes an empty bucket.
     * The request fails if there are any live or
     * noncurrent objects in the bucket, but the request succeeds if the
     * bucket only contains soft-deleted objects or incomplete uploads, such
     * as ongoing XML API multipart uploads. Does not permanently delete
     * soft-deleted objects.
     * When this API is used to delete a bucket containing an object that has a
     * soft delete policy
     * enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the
     * object.
     * Objects and multipart uploads that were in the bucket at the time of
     * deletion are also retained for the specified retention duration. When
     * a soft-deleted bucket reaches the end of its retention duration, it
     * is permanently deleted. The `hardDeleteTime` of the bucket always
     * equals
     * or exceeds the expiration time of the last soft-deleted object in the
     * bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.delete` IAM permission on the bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBucket(com.google.storage.v2.DeleteBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for the specified bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.get`
     * IAM permission on
     * the bucket. Additionally, to return specific bucket metadata, the
     * authenticated user must have the following permissions:
     * - To return the IAM policies: `storage.buckets.getIamPolicy`
     * - To return the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Bucket>
        getBucket(com.google.storage.v2.GetBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new bucket.
     * **IAM Permissions**:
     * Requires `storage.buckets.create` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To enable object retention using the `enableObjectRetention` query
     * parameter: `storage.buckets.enableObjectRetention`
     * - To set the bucket IP filtering rules: `storage.buckets.setIpFilter`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Bucket>
        createBucket(com.google.storage.v2.CreateBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of buckets for a given project, ordered
     * lexicographically by name.
     * **IAM Permissions**:
     * Requires `storage.buckets.list` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated
     * user must have the following permissions:
     * - To list the IAM policies: `storage.buckets.getIamPolicy`
     * - To list the bucket IP filtering rules: `storage.buckets.getIpFilter`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.v2.ListBucketsResponse>
        listBuckets(com.google.storage.v2.ListBucketsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBucketsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently locks the retention
     * policy that is
     * currently applied to the specified bucket.
     * Caution: Locking a bucket is an
     * irreversible action. Once you lock a bucket:
     * - You cannot remove the retention policy from the bucket.
     * - You cannot decrease the retention period for the policy.
     * Once locked, you must delete the entire bucket in order to remove the
     * bucket's retention policy. However, before you can delete the bucket, you
     * must delete all the objects in the bucket, which is only
     * possible if all the objects have reached the retention period set by the
     * retention policy.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Bucket>
        lockBucketRetentionPolicy(com.google.storage.v2.LockBucketRetentionPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLockBucketRetentionPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * **IAM Permissions**:
     * Requires `storage.buckets.getIamPolicy` on the bucket or
     * `storage.managedFolders.getIamPolicy` IAM permission on the
     * managed folder.
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
     * Updates an IAM policy for the specified bucket or managed folder.
     * The `resource` field in the request should be
     * `projects/_/buckets/{bucket}` for a bucket, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
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
     * Tests a set of permissions on the given bucket, object, or managed folder
     * to see which, if any, are held by the caller. The `resource` field in the
     * request should be `projects/_/buckets/{bucket}` for a bucket,
     * `projects/_/buckets/{bucket}/objects/{object}` for an object, or
     * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}`
     * for a managed folder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a bucket. Changes to the bucket are readable immediately after
     * writing, but configuration changes might take time to propagate. This
     * method supports `patch` semantics.
     * **IAM Permissions**:
     * Requires `storage.buckets.update` IAM permission on the bucket.
     * Additionally, to enable specific bucket features, the authenticated user
     * must have the following permissions:
     * - To set bucket IP filtering rules: `storage.buckets.setIpFilter`
     * - To update public access prevention policies or access control lists
     * (ACLs): `storage.buckets.setIamPolicy`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Bucket>
        updateBucket(com.google.storage.v2.UpdateBucketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBucketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Concatenates a list of existing objects into a new object in the same
     * bucket. The existing source objects are unaffected by this operation.
     * **IAM Permissions**:
     * Requires the `storage.objects.create` and `storage.objects.get` IAM
     * permissions to use this method. If the new composite object
     * overwrites an existing object, the authenticated user must also have
     * the `storage.objects.delete` permission. If the request body includes
     * the retention property, the authenticated user must also have the
     * `storage.objects.setRetention` IAM permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Object>
        composeObject(com.google.storage.v2.ComposeObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComposeObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an object and its metadata. Deletions are permanent if versioning
     * is not enabled for the bucket, or if the generation parameter is used, or
     * if soft delete is not
     * enabled for the bucket.
     * When this API is used to delete an object from a bucket that has soft
     * delete policy enabled, the object becomes soft deleted, and the
     * `softDeleteTime` and `hardDeleteTime` properties are set on the object.
     * This API cannot be used to permanently delete soft-deleted objects.
     * Soft-deleted objects are permanently deleted according to their
     * `hardDeleteTime`.
     * You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject]
     * API to restore soft-deleted objects until the soft delete retention period
     * has passed.
     * **IAM Permissions**:
     * Requires `storage.objects.delete` IAM permission on the bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteObject(com.google.storage.v2.DeleteObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a
     * soft-deleted object.
     * When a soft-deleted object is restored, a new copy of that object is
     * created in the same bucket and inherits the same metadata as the
     * soft-deleted object. The inherited metadata is the metadata that existed
     * when the original object became soft deleted, with the following
     * exceptions:
     *   - The `createTime` of the new object is set to the time at which the
     *   soft-deleted object was restored.
     *   - The `softDeleteTime` and `hardDeleteTime` values are cleared.
     *   - A new generation is assigned and the metageneration is reset to 1.
     *   - If the soft-deleted object was in a bucket that had Autoclass enabled,
     *   the new object is
     *     restored to Standard storage.
     *   - The restored object inherits the bucket's default object ACL, unless
     *   `copySourceAcl` is `true`.
     * If a live object using the same name already exists in the bucket and
     * becomes overwritten, the live object becomes a noncurrent object if Object
     * Versioning is enabled on the bucket. If Object Versioning is not enabled,
     * the live object becomes soft deleted.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.restore`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     *   - `storage.objects.getIamPolicy` (only required if `projection` is `full`
     *   and the relevant bucket
     *     has uniform bucket-level access disabled)
     *   - `storage.objects.setIamPolicy` (only required if `copySourceAcl` is
     *   `true` and the relevant
     *     bucket has uniform bucket-level access disabled)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Object>
        restoreObject(com.google.storage.v2.RestoreObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an in-progress resumable upload.
     * Any attempts to write to the resumable upload after cancelling the upload
     * fail.
     * The behavior for any in-progress write operations is not guaranteed;
     * they could either complete before the cancellation or fail if the
     * cancellation completes first.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.v2.CancelResumableWriteResponse>
        cancelResumableWrite(com.google.storage.v2.CancelResumableWriteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelResumableWriteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves object metadata.
     * **IAM Permissions**:
     * Requires `storage.objects.get` IAM permission on the bucket.
     * To return object ACLs, the authenticated user must also have
     * the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Object>
        getObject(com.google.storage.v2.GetObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an object's metadata.
     * Equivalent to JSON API's `storage.objects.patch` method.
     * **IAM Permissions**:
     * Requires `storage.objects.update` IAM permission on the bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Object>
        updateObject(com.google.storage.v2.UpdateObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a list of objects matching the criteria.
     * **IAM Permissions**:
     * The authenticated user requires `storage.objects.list`
     * IAM permission to use this method. To return object ACLs, the
     * authenticated user must also
     * have the `storage.objects.getIamPolicy` permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.v2.ListObjectsResponse>
        listObjects(com.google.storage.v2.ListObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListObjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rewrites a source object to a destination object. Optionally overrides
     * metadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.RewriteResponse>
        rewriteObject(com.google.storage.v2.RewriteObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRewriteObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a resumable write operation. This
     * method is part of the Resumable
     * upload feature.
     * This allows you to upload large objects in multiple chunks, which is more
     * resilient to network interruptions than a single upload. The validity
     * duration of the write operation, and the consequences of it becoming
     * invalid, are service-dependent.
     * **IAM Permissions**:
     * Requires `storage.objects.create` IAM permission on the bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.v2.StartResumableWriteResponse>
        startResumableWrite(com.google.storage.v2.StartResumableWriteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartResumableWriteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Determines the `persisted_size` of an object that is being written. This
     * method is part of the resumable
     * upload feature.
     * The returned value is the size of the object that has been persisted so
     * far. The value can be used as the `write_offset` for the next `Write()`
     * call.
     * If the object does not exist, meaning if it was deleted, or the
     * first `Write()` has not yet reached the service, this method returns the
     * error `NOT_FOUND`.
     * This method is useful for clients that buffer data and need to know which
     * data can be safely evicted. The client can call `QueryWriteStatus()` at any
     * time to determine how much data has been logged for this object.
     * For any sequence of `QueryWriteStatus()` calls for a given
     * object name, the sequence of returned `persisted_size` values are
     * non-decreasing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.storage.v2.QueryWriteStatusResponse>
        queryWriteStatus(com.google.storage.v2.QueryWriteStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryWriteStatusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Moves the source object to the destination object in the same bucket.
     * This operation moves a source object to a destination object in the
     * same bucket by renaming the object. The move itself is an atomic
     * transaction, ensuring all steps either complete successfully or no
     * changes are made.
     * **IAM Permissions**:
     * Requires the following IAM permissions to use this method:
     *   - `storage.objects.move`
     *   - `storage.objects.create`
     *   - `storage.objects.delete` (only required if overwriting an existing
     *   object)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.storage.v2.Object>
        moveObject(com.google.storage.v2.MoveObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMoveObjectMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_BUCKET = 0;
  private static final int METHODID_GET_BUCKET = 1;
  private static final int METHODID_CREATE_BUCKET = 2;
  private static final int METHODID_LIST_BUCKETS = 3;
  private static final int METHODID_LOCK_BUCKET_RETENTION_POLICY = 4;
  private static final int METHODID_GET_IAM_POLICY = 5;
  private static final int METHODID_SET_IAM_POLICY = 6;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 7;
  private static final int METHODID_UPDATE_BUCKET = 8;
  private static final int METHODID_COMPOSE_OBJECT = 9;
  private static final int METHODID_DELETE_OBJECT = 10;
  private static final int METHODID_RESTORE_OBJECT = 11;
  private static final int METHODID_CANCEL_RESUMABLE_WRITE = 12;
  private static final int METHODID_GET_OBJECT = 13;
  private static final int METHODID_READ_OBJECT = 14;
  private static final int METHODID_UPDATE_OBJECT = 15;
  private static final int METHODID_LIST_OBJECTS = 16;
  private static final int METHODID_REWRITE_OBJECT = 17;
  private static final int METHODID_START_RESUMABLE_WRITE = 18;
  private static final int METHODID_QUERY_WRITE_STATUS = 19;
  private static final int METHODID_MOVE_OBJECT = 20;
  private static final int METHODID_BIDI_READ_OBJECT = 21;
  private static final int METHODID_WRITE_OBJECT = 22;
  private static final int METHODID_BIDI_WRITE_OBJECT = 23;

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
        case METHODID_DELETE_BUCKET:
          serviceImpl.deleteBucket(
              (com.google.storage.v2.DeleteBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BUCKET:
          serviceImpl.getBucket(
              (com.google.storage.v2.GetBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket>) responseObserver);
          break;
        case METHODID_CREATE_BUCKET:
          serviceImpl.createBucket(
              (com.google.storage.v2.CreateBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket>) responseObserver);
          break;
        case METHODID_LIST_BUCKETS:
          serviceImpl.listBuckets(
              (com.google.storage.v2.ListBucketsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.ListBucketsResponse>)
                  responseObserver);
          break;
        case METHODID_LOCK_BUCKET_RETENTION_POLICY:
          serviceImpl.lockBucketRetentionPolicy(
              (com.google.storage.v2.LockBucketRetentionPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket>) responseObserver);
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
        case METHODID_UPDATE_BUCKET:
          serviceImpl.updateBucket(
              (com.google.storage.v2.UpdateBucketRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Bucket>) responseObserver);
          break;
        case METHODID_COMPOSE_OBJECT:
          serviceImpl.composeObject(
              (com.google.storage.v2.ComposeObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Object>) responseObserver);
          break;
        case METHODID_DELETE_OBJECT:
          serviceImpl.deleteObject(
              (com.google.storage.v2.DeleteObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESTORE_OBJECT:
          serviceImpl.restoreObject(
              (com.google.storage.v2.RestoreObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Object>) responseObserver);
          break;
        case METHODID_CANCEL_RESUMABLE_WRITE:
          serviceImpl.cancelResumableWrite(
              (com.google.storage.v2.CancelResumableWriteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.CancelResumableWriteResponse>)
                  responseObserver);
          break;
        case METHODID_GET_OBJECT:
          serviceImpl.getObject(
              (com.google.storage.v2.GetObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Object>) responseObserver);
          break;
        case METHODID_READ_OBJECT:
          serviceImpl.readObject(
              (com.google.storage.v2.ReadObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.ReadObjectResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_OBJECT:
          serviceImpl.updateObject(
              (com.google.storage.v2.UpdateObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Object>) responseObserver);
          break;
        case METHODID_LIST_OBJECTS:
          serviceImpl.listObjects(
              (com.google.storage.v2.ListObjectsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.ListObjectsResponse>)
                  responseObserver);
          break;
        case METHODID_REWRITE_OBJECT:
          serviceImpl.rewriteObject(
              (com.google.storage.v2.RewriteObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.RewriteResponse>)
                  responseObserver);
          break;
        case METHODID_START_RESUMABLE_WRITE:
          serviceImpl.startResumableWrite(
              (com.google.storage.v2.StartResumableWriteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.StartResumableWriteResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_WRITE_STATUS:
          serviceImpl.queryWriteStatus(
              (com.google.storage.v2.QueryWriteStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.QueryWriteStatusResponse>)
                  responseObserver);
          break;
        case METHODID_MOVE_OBJECT:
          serviceImpl.moveObject(
              (com.google.storage.v2.MoveObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.storage.v2.Object>) responseObserver);
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
        case METHODID_BIDI_READ_OBJECT:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.bidiReadObject(
                  (io.grpc.stub.StreamObserver<com.google.storage.v2.BidiReadObjectResponse>)
                      responseObserver);
        case METHODID_WRITE_OBJECT:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.writeObject(
                  (io.grpc.stub.StreamObserver<com.google.storage.v2.WriteObjectResponse>)
                      responseObserver);
        case METHODID_BIDI_WRITE_OBJECT:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.bidiWriteObject(
                  (io.grpc.stub.StreamObserver<com.google.storage.v2.BidiWriteObjectResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getDeleteBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.DeleteBucketRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_BUCKET)))
        .addMethod(
            getGetBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.GetBucketRequest, com.google.storage.v2.Bucket>(
                    service, METHODID_GET_BUCKET)))
        .addMethod(
            getCreateBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.CreateBucketRequest, com.google.storage.v2.Bucket>(
                    service, METHODID_CREATE_BUCKET)))
        .addMethod(
            getListBucketsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.ListBucketsRequest,
                    com.google.storage.v2.ListBucketsResponse>(service, METHODID_LIST_BUCKETS)))
        .addMethod(
            getLockBucketRetentionPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.LockBucketRetentionPolicyRequest,
                    com.google.storage.v2.Bucket>(service, METHODID_LOCK_BUCKET_RETENTION_POLICY)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .addMethod(
            getUpdateBucketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.UpdateBucketRequest, com.google.storage.v2.Bucket>(
                    service, METHODID_UPDATE_BUCKET)))
        .addMethod(
            getComposeObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.ComposeObjectRequest, com.google.storage.v2.Object>(
                    service, METHODID_COMPOSE_OBJECT)))
        .addMethod(
            getDeleteObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.DeleteObjectRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_OBJECT)))
        .addMethod(
            getRestoreObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.RestoreObjectRequest, com.google.storage.v2.Object>(
                    service, METHODID_RESTORE_OBJECT)))
        .addMethod(
            getCancelResumableWriteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.CancelResumableWriteRequest,
                    com.google.storage.v2.CancelResumableWriteResponse>(
                    service, METHODID_CANCEL_RESUMABLE_WRITE)))
        .addMethod(
            getGetObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.GetObjectRequest, com.google.storage.v2.Object>(
                    service, METHODID_GET_OBJECT)))
        .addMethod(
            getReadObjectMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.storage.v2.ReadObjectRequest,
                    com.google.storage.v2.ReadObjectResponse>(service, METHODID_READ_OBJECT)))
        .addMethod(
            getBidiReadObjectMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.storage.v2.BidiReadObjectRequest,
                    com.google.storage.v2.BidiReadObjectResponse>(
                    service, METHODID_BIDI_READ_OBJECT)))
        .addMethod(
            getUpdateObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.UpdateObjectRequest, com.google.storage.v2.Object>(
                    service, METHODID_UPDATE_OBJECT)))
        .addMethod(
            getWriteObjectMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
                new MethodHandlers<
                    com.google.storage.v2.WriteObjectRequest,
                    com.google.storage.v2.WriteObjectResponse>(service, METHODID_WRITE_OBJECT)))
        .addMethod(
            getBidiWriteObjectMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.storage.v2.BidiWriteObjectRequest,
                    com.google.storage.v2.BidiWriteObjectResponse>(
                    service, METHODID_BIDI_WRITE_OBJECT)))
        .addMethod(
            getListObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.ListObjectsRequest,
                    com.google.storage.v2.ListObjectsResponse>(service, METHODID_LIST_OBJECTS)))
        .addMethod(
            getRewriteObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.RewriteObjectRequest,
                    com.google.storage.v2.RewriteResponse>(service, METHODID_REWRITE_OBJECT)))
        .addMethod(
            getStartResumableWriteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.StartResumableWriteRequest,
                    com.google.storage.v2.StartResumableWriteResponse>(
                    service, METHODID_START_RESUMABLE_WRITE)))
        .addMethod(
            getQueryWriteStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.QueryWriteStatusRequest,
                    com.google.storage.v2.QueryWriteStatusResponse>(
                    service, METHODID_QUERY_WRITE_STATUS)))
        .addMethod(
            getMoveObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.storage.v2.MoveObjectRequest, com.google.storage.v2.Object>(
                    service, METHODID_MOVE_OBJECT)))
        .build();
  }

  private abstract static class StorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.storage.v2.StorageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Storage");
    }
  }

  private static final class StorageFileDescriptorSupplier extends StorageBaseDescriptorSupplier {
    StorageFileDescriptorSupplier() {}
  }

  private static final class StorageMethodDescriptorSupplier extends StorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StorageMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StorageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new StorageFileDescriptorSupplier())
                      .addMethod(getDeleteBucketMethod())
                      .addMethod(getGetBucketMethod())
                      .addMethod(getCreateBucketMethod())
                      .addMethod(getListBucketsMethod())
                      .addMethod(getLockBucketRetentionPolicyMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getUpdateBucketMethod())
                      .addMethod(getComposeObjectMethod())
                      .addMethod(getDeleteObjectMethod())
                      .addMethod(getRestoreObjectMethod())
                      .addMethod(getCancelResumableWriteMethod())
                      .addMethod(getGetObjectMethod())
                      .addMethod(getReadObjectMethod())
                      .addMethod(getBidiReadObjectMethod())
                      .addMethod(getUpdateObjectMethod())
                      .addMethod(getWriteObjectMethod())
                      .addMethod(getBidiWriteObjectMethod())
                      .addMethod(getListObjectsMethod())
                      .addMethod(getRewriteObjectMethod())
                      .addMethod(getStartResumableWriteMethod())
                      .addMethod(getQueryWriteStatusMethod())
                      .addMethod(getMoveObjectMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
