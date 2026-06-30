/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.storage.v2.stub;

import static com.google.storage.v2.StorageClient.ListBucketsPagedResponse;
import static com.google.storage.v2.StorageClient.ListObjectsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.Bucket;
import com.google.storage.v2.CancelResumableWriteRequest;
import com.google.storage.v2.CancelResumableWriteResponse;
import com.google.storage.v2.ComposeObjectRequest;
import com.google.storage.v2.CreateBucketRequest;
import com.google.storage.v2.DeleteBucketRequest;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.GetBucketRequest;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.ListBucketsRequest;
import com.google.storage.v2.ListBucketsResponse;
import com.google.storage.v2.ListObjectsRequest;
import com.google.storage.v2.ListObjectsResponse;
import com.google.storage.v2.LockBucketRetentionPolicyRequest;
import com.google.storage.v2.MoveObjectRequest;
import com.google.storage.v2.Object;
import com.google.storage.v2.QueryWriteStatusRequest;
import com.google.storage.v2.QueryWriteStatusResponse;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.RestoreObjectRequest;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.RewriteResponse;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.UpdateBucketRequest;
import com.google.storage.v2.UpdateObjectRequest;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Storage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcStorageStub extends StorageStub {
  private static final MethodDescriptor<DeleteBucketRequest, Empty> deleteBucketMethodDescriptor =
      MethodDescriptor.<DeleteBucketRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/DeleteBucket")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBucketRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetBucketRequest, Bucket> getBucketMethodDescriptor =
      MethodDescriptor.<GetBucketRequest, Bucket>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/GetBucket")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBucketRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Bucket.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateBucketRequest, Bucket> createBucketMethodDescriptor =
      MethodDescriptor.<CreateBucketRequest, Bucket>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/CreateBucket")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateBucketRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Bucket.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListBucketsRequest, ListBucketsResponse>
      listBucketsMethodDescriptor =
          MethodDescriptor.<ListBucketsRequest, ListBucketsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/ListBuckets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBucketsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBucketsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<LockBucketRetentionPolicyRequest, Bucket>
      lockBucketRetentionPolicyMethodDescriptor =
          MethodDescriptor.<LockBucketRetentionPolicyRequest, Bucket>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/LockBucketRetentionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LockBucketRetentionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Bucket.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBucketRequest, Bucket> updateBucketMethodDescriptor =
      MethodDescriptor.<UpdateBucketRequest, Bucket>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/UpdateBucket")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateBucketRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Bucket.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ComposeObjectRequest, Object>
      composeObjectMethodDescriptor =
          MethodDescriptor.<ComposeObjectRequest, Object>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/ComposeObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ComposeObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Object.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteObjectRequest, Empty> deleteObjectMethodDescriptor =
      MethodDescriptor.<DeleteObjectRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/DeleteObject")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteObjectRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RestoreObjectRequest, Object>
      restoreObjectMethodDescriptor =
          MethodDescriptor.<RestoreObjectRequest, Object>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/RestoreObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Object.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CancelResumableWriteRequest, CancelResumableWriteResponse>
      cancelResumableWriteMethodDescriptor =
          MethodDescriptor.<CancelResumableWriteRequest, CancelResumableWriteResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/CancelResumableWrite")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelResumableWriteRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CancelResumableWriteResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetObjectRequest, Object> getObjectMethodDescriptor =
      MethodDescriptor.<GetObjectRequest, Object>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/GetObject")
          .setRequestMarshaller(ProtoUtils.marshaller(GetObjectRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Object.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ReadObjectRequest, ReadObjectResponse>
      readObjectMethodDescriptor =
          MethodDescriptor.<ReadObjectRequest, ReadObjectResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.storage.v2.Storage/ReadObject")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadObjectResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BidiReadObjectRequest, BidiReadObjectResponse>
      bidiReadObjectMethodDescriptor =
          MethodDescriptor.<BidiReadObjectRequest, BidiReadObjectResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.storage.v2.Storage/BidiReadObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BidiReadObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BidiReadObjectResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateObjectRequest, Object> updateObjectMethodDescriptor =
      MethodDescriptor.<UpdateObjectRequest, Object>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/UpdateObject")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateObjectRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Object.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<WriteObjectRequest, WriteObjectResponse>
      writeObjectMethodDescriptor =
          MethodDescriptor.<WriteObjectRequest, WriteObjectResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName("google.storage.v2.Storage/WriteObject")
              .setRequestMarshaller(ProtoUtils.marshaller(WriteObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(WriteObjectResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BidiWriteObjectRequest, BidiWriteObjectResponse>
      bidiWriteObjectMethodDescriptor =
          MethodDescriptor.<BidiWriteObjectRequest, BidiWriteObjectResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.storage.v2.Storage/BidiWriteObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BidiWriteObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BidiWriteObjectResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListObjectsRequest, ListObjectsResponse>
      listObjectsMethodDescriptor =
          MethodDescriptor.<ListObjectsRequest, ListObjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/ListObjects")
              .setRequestMarshaller(ProtoUtils.marshaller(ListObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListObjectsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RewriteObjectRequest, RewriteResponse>
      rewriteObjectMethodDescriptor =
          MethodDescriptor.<RewriteObjectRequest, RewriteResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/RewriteObject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RewriteObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RewriteResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<StartResumableWriteRequest, StartResumableWriteResponse>
      startResumableWriteMethodDescriptor =
          MethodDescriptor.<StartResumableWriteRequest, StartResumableWriteResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/StartResumableWrite")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartResumableWriteRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StartResumableWriteResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<QueryWriteStatusRequest, QueryWriteStatusResponse>
      queryWriteStatusMethodDescriptor =
          MethodDescriptor.<QueryWriteStatusRequest, QueryWriteStatusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/QueryWriteStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryWriteStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryWriteStatusResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MoveObjectRequest, Object> moveObjectMethodDescriptor =
      MethodDescriptor.<MoveObjectRequest, Object>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/MoveObject")
          .setRequestMarshaller(ProtoUtils.marshaller(MoveObjectRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Object.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<DeleteBucketRequest, Empty> deleteBucketCallable;
  private final UnaryCallable<GetBucketRequest, Bucket> getBucketCallable;
  private final UnaryCallable<CreateBucketRequest, Bucket> createBucketCallable;
  private final UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable;
  private final UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse>
      listBucketsPagedCallable;
  private final UnaryCallable<LockBucketRetentionPolicyRequest, Bucket>
      lockBucketRetentionPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<UpdateBucketRequest, Bucket> updateBucketCallable;
  private final UnaryCallable<ComposeObjectRequest, Object> composeObjectCallable;
  private final UnaryCallable<DeleteObjectRequest, Empty> deleteObjectCallable;
  private final UnaryCallable<RestoreObjectRequest, Object> restoreObjectCallable;
  private final UnaryCallable<CancelResumableWriteRequest, CancelResumableWriteResponse>
      cancelResumableWriteCallable;
  private final UnaryCallable<GetObjectRequest, Object> getObjectCallable;
  private final ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> readObjectCallable;
  private final BidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      bidiReadObjectCallable;
  private final UnaryCallable<UpdateObjectRequest, Object> updateObjectCallable;
  private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse>
      writeObjectCallable;
  private final BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse>
      bidiWriteObjectCallable;
  private final UnaryCallable<ListObjectsRequest, ListObjectsResponse> listObjectsCallable;
  private final UnaryCallable<ListObjectsRequest, ListObjectsPagedResponse>
      listObjectsPagedCallable;
  private final UnaryCallable<RewriteObjectRequest, RewriteResponse> rewriteObjectCallable;
  private final UnaryCallable<StartResumableWriteRequest, StartResumableWriteResponse>
      startResumableWriteCallable;
  private final UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse>
      queryWriteStatusCallable;
  private final UnaryCallable<MoveObjectRequest, Object> moveObjectCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_BUCKET_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate GET_BUCKET_0_PATH_TEMPLATE = PathTemplate.create("{bucket=**}");
  private static final PathTemplate CREATE_BUCKET_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate CREATE_BUCKET_1_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate LIST_BUCKETS_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate LOCK_BUCKET_RETENTION_POLICY_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate GET_IAM_POLICY_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate GET_IAM_POLICY_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate SET_IAM_POLICY_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate SET_IAM_POLICY_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate TEST_IAM_PERMISSIONS_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate TEST_IAM_PERMISSIONS_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/objects/**");
  private static final PathTemplate TEST_IAM_PERMISSIONS_2_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/managedFolders/**");
  private static final PathTemplate UPDATE_BUCKET_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate COMPOSE_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate DELETE_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate RESTORE_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate CANCEL_RESUMABLE_WRITE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate GET_OBJECT_0_PATH_TEMPLATE = PathTemplate.create("{bucket=**}");
  private static final PathTemplate READ_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate BIDI_READ_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate UPDATE_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate LIST_OBJECTS_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate REWRITE_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{source_bucket=**}");
  private static final PathTemplate REWRITE_OBJECT_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate START_RESUMABLE_WRITE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate QUERY_WRITE_STATUS_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate MOVE_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");

  public static final GrpcStorageStub create(StorageStubSettings settings) throws IOException {
    return new GrpcStorageStub(settings, ClientContext.create(settings));
  }

  public static final GrpcStorageStub create(ClientContext clientContext) throws IOException {
    return new GrpcStorageStub(StorageStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcStorageStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcStorageStub(
        StorageStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcStorageStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcStorageStub(StorageStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcStorageCallableFactory());
  }

  /**
   * Constructs an instance of GrpcStorageStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcStorageStub(
      StorageStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<DeleteBucketRequest, Empty> deleteBucketTransportSettings =
        GrpcCallSettings.<DeleteBucketRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", DELETE_BUCKET_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetBucketRequest, Bucket> getBucketTransportSettings =
        GrpcCallSettings.<GetBucketRequest, Bucket>newBuilder()
            .setMethodDescriptor(getBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", GET_BUCKET_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateBucketRequest, Bucket> createBucketTransportSettings =
        GrpcCallSettings.<CreateBucketRequest, Bucket>newBuilder()
            .setMethodDescriptor(createBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "project", CREATE_BUCKET_0_PATH_TEMPLATE);
                  if (request.getBucket() != null) {
                    builder.add(
                        request.getBucket().getProject(), "project", CREATE_BUCKET_1_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListBucketsRequest, ListBucketsResponse> listBucketsTransportSettings =
        GrpcCallSettings.<ListBucketsRequest, ListBucketsResponse>newBuilder()
            .setMethodDescriptor(listBucketsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "project", LIST_BUCKETS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<LockBucketRetentionPolicyRequest, Bucket>
        lockBucketRetentionPolicyTransportSettings =
            GrpcCallSettings.<LockBucketRetentionPolicyRequest, Bucket>newBuilder()
                .setMethodDescriptor(lockBucketRetentionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getBucket(),
                          "bucket",
                          LOCK_BUCKET_RETENTION_POLICY_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getBucket())
                .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getResource(), "bucket", GET_IAM_POLICY_0_PATH_TEMPLATE);
                  builder.add(request.getResource(), "bucket", GET_IAM_POLICY_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getResource(), "bucket", SET_IAM_POLICY_0_PATH_TEMPLATE);
                  builder.add(request.getResource(), "bucket", SET_IAM_POLICY_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getResource(), "bucket", TEST_IAM_PERMISSIONS_0_PATH_TEMPLATE);
                      builder.add(
                          request.getResource(), "bucket", TEST_IAM_PERMISSIONS_1_PATH_TEMPLATE);
                      builder.add(
                          request.getResource(), "bucket", TEST_IAM_PERMISSIONS_2_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();
    GrpcCallSettings<UpdateBucketRequest, Bucket> updateBucketTransportSettings =
        GrpcCallSettings.<UpdateBucketRequest, Bucket>newBuilder()
            .setMethodDescriptor(updateBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getBucket() != null) {
                    builder.add(
                        request.getBucket().getName(), "bucket", UPDATE_BUCKET_0_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ComposeObjectRequest, Object> composeObjectTransportSettings =
        GrpcCallSettings.<ComposeObjectRequest, Object>newBuilder()
            .setMethodDescriptor(composeObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getDestination() != null) {
                    builder.add(
                        request.getDestination().getBucket(),
                        "bucket",
                        COMPOSE_OBJECT_0_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getKmsKey())
            .build();
    GrpcCallSettings<DeleteObjectRequest, Empty> deleteObjectTransportSettings =
        GrpcCallSettings.<DeleteObjectRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getBucket(), "bucket", DELETE_OBJECT_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getBucket())
            .build();
    GrpcCallSettings<RestoreObjectRequest, Object> restoreObjectTransportSettings =
        GrpcCallSettings.<RestoreObjectRequest, Object>newBuilder()
            .setMethodDescriptor(restoreObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getBucket(), "bucket", RESTORE_OBJECT_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getBucket())
            .build();
    GrpcCallSettings<CancelResumableWriteRequest, CancelResumableWriteResponse>
        cancelResumableWriteTransportSettings =
            GrpcCallSettings.<CancelResumableWriteRequest, CancelResumableWriteResponse>newBuilder()
                .setMethodDescriptor(cancelResumableWriteMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getUploadId(), "bucket", CANCEL_RESUMABLE_WRITE_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetObjectRequest, Object> getObjectTransportSettings =
        GrpcCallSettings.<GetObjectRequest, Object>newBuilder()
            .setMethodDescriptor(getObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getBucket(), "bucket", GET_OBJECT_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getBucket())
            .build();
    GrpcCallSettings<ReadObjectRequest, ReadObjectResponse> readObjectTransportSettings =
        GrpcCallSettings.<ReadObjectRequest, ReadObjectResponse>newBuilder()
            .setMethodDescriptor(readObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getBucket(), "bucket", READ_OBJECT_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getBucket())
            .build();
    GrpcCallSettings<BidiReadObjectRequest, BidiReadObjectResponse>
        bidiReadObjectTransportSettings =
            GrpcCallSettings.<BidiReadObjectRequest, BidiReadObjectResponse>newBuilder()
                .setMethodDescriptor(bidiReadObjectMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      if (request.getReadObjectSpec() != null) {
                        builder.add(
                            request.getReadObjectSpec().getBucket(),
                            "bucket",
                            BIDI_READ_OBJECT_0_PATH_TEMPLATE);
                      }
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateObjectRequest, Object> updateObjectTransportSettings =
        GrpcCallSettings.<UpdateObjectRequest, Object>newBuilder()
            .setMethodDescriptor(updateObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getObject() != null) {
                    builder.add(
                        request.getObject().getBucket(), "bucket", UPDATE_OBJECT_0_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .build();
    GrpcCallSettings<WriteObjectRequest, WriteObjectResponse> writeObjectTransportSettings =
        GrpcCallSettings.<WriteObjectRequest, WriteObjectResponse>newBuilder()
            .setMethodDescriptor(writeObjectMethodDescriptor)
            .build();
    GrpcCallSettings<BidiWriteObjectRequest, BidiWriteObjectResponse>
        bidiWriteObjectTransportSettings =
            GrpcCallSettings.<BidiWriteObjectRequest, BidiWriteObjectResponse>newBuilder()
                .setMethodDescriptor(bidiWriteObjectMethodDescriptor)
                .build();
    GrpcCallSettings<ListObjectsRequest, ListObjectsResponse> listObjectsTransportSettings =
        GrpcCallSettings.<ListObjectsRequest, ListObjectsResponse>newBuilder()
            .setMethodDescriptor(listObjectsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "bucket", LIST_OBJECTS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<RewriteObjectRequest, RewriteResponse> rewriteObjectTransportSettings =
        GrpcCallSettings.<RewriteObjectRequest, RewriteResponse>newBuilder()
            .setMethodDescriptor(rewriteObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      request.getSourceBucket(), "source_bucket", REWRITE_OBJECT_0_PATH_TEMPLATE);
                  builder.add(
                      request.getDestinationBucket(), "bucket", REWRITE_OBJECT_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getDestinationBucket())
            .build();
    GrpcCallSettings<StartResumableWriteRequest, StartResumableWriteResponse>
        startResumableWriteTransportSettings =
            GrpcCallSettings.<StartResumableWriteRequest, StartResumableWriteResponse>newBuilder()
                .setMethodDescriptor(startResumableWriteMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      if (request.getWriteObjectSpec() != null
                          && request.getWriteObjectSpec().getResource() != null) {
                        builder.add(
                            request.getWriteObjectSpec().getResource().getBucket(),
                            "bucket",
                            START_RESUMABLE_WRITE_0_PATH_TEMPLATE);
                      }
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<QueryWriteStatusRequest, QueryWriteStatusResponse>
        queryWriteStatusTransportSettings =
            GrpcCallSettings.<QueryWriteStatusRequest, QueryWriteStatusResponse>newBuilder()
                .setMethodDescriptor(queryWriteStatusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getUploadId(), "bucket", QUERY_WRITE_STATUS_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<MoveObjectRequest, Object> moveObjectTransportSettings =
        GrpcCallSettings.<MoveObjectRequest, Object>newBuilder()
            .setMethodDescriptor(moveObjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getBucket(), "bucket", MOVE_OBJECT_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getBucket())
            .build();

    this.deleteBucketCallable =
        callableFactory.createUnaryCallable(
            deleteBucketTransportSettings, settings.deleteBucketSettings(), clientContext);
    this.getBucketCallable =
        callableFactory.createUnaryCallable(
            getBucketTransportSettings, settings.getBucketSettings(), clientContext);
    this.createBucketCallable =
        callableFactory.createUnaryCallable(
            createBucketTransportSettings, settings.createBucketSettings(), clientContext);
    this.listBucketsCallable =
        callableFactory.createUnaryCallable(
            listBucketsTransportSettings, settings.listBucketsSettings(), clientContext);
    this.listBucketsPagedCallable =
        callableFactory.createPagedCallable(
            listBucketsTransportSettings, settings.listBucketsSettings(), clientContext);
    this.lockBucketRetentionPolicyCallable =
        callableFactory.createUnaryCallable(
            lockBucketRetentionPolicyTransportSettings,
            settings.lockBucketRetentionPolicySettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.updateBucketCallable =
        callableFactory.createUnaryCallable(
            updateBucketTransportSettings, settings.updateBucketSettings(), clientContext);
    this.composeObjectCallable =
        callableFactory.createUnaryCallable(
            composeObjectTransportSettings, settings.composeObjectSettings(), clientContext);
    this.deleteObjectCallable =
        callableFactory.createUnaryCallable(
            deleteObjectTransportSettings, settings.deleteObjectSettings(), clientContext);
    this.restoreObjectCallable =
        callableFactory.createUnaryCallable(
            restoreObjectTransportSettings, settings.restoreObjectSettings(), clientContext);
    this.cancelResumableWriteCallable =
        callableFactory.createUnaryCallable(
            cancelResumableWriteTransportSettings,
            settings.cancelResumableWriteSettings(),
            clientContext);
    this.getObjectCallable =
        callableFactory.createUnaryCallable(
            getObjectTransportSettings, settings.getObjectSettings(), clientContext);
    this.readObjectCallable =
        callableFactory.createServerStreamingCallable(
            readObjectTransportSettings, settings.readObjectSettings(), clientContext);
    this.bidiReadObjectCallable =
        callableFactory.createBidiStreamingCallable(
            bidiReadObjectTransportSettings, settings.bidiReadObjectSettings(), clientContext);
    this.updateObjectCallable =
        callableFactory.createUnaryCallable(
            updateObjectTransportSettings, settings.updateObjectSettings(), clientContext);
    this.writeObjectCallable =
        callableFactory.createClientStreamingCallable(
            writeObjectTransportSettings, settings.writeObjectSettings(), clientContext);
    this.bidiWriteObjectCallable =
        callableFactory.createBidiStreamingCallable(
            bidiWriteObjectTransportSettings, settings.bidiWriteObjectSettings(), clientContext);
    this.listObjectsCallable =
        callableFactory.createUnaryCallable(
            listObjectsTransportSettings, settings.listObjectsSettings(), clientContext);
    this.listObjectsPagedCallable =
        callableFactory.createPagedCallable(
            listObjectsTransportSettings, settings.listObjectsSettings(), clientContext);
    this.rewriteObjectCallable =
        callableFactory.createUnaryCallable(
            rewriteObjectTransportSettings, settings.rewriteObjectSettings(), clientContext);
    this.startResumableWriteCallable =
        callableFactory.createUnaryCallable(
            startResumableWriteTransportSettings,
            settings.startResumableWriteSettings(),
            clientContext);
    this.queryWriteStatusCallable =
        callableFactory.createUnaryCallable(
            queryWriteStatusTransportSettings, settings.queryWriteStatusSettings(), clientContext);
    this.moveObjectCallable =
        callableFactory.createUnaryCallable(
            moveObjectTransportSettings, settings.moveObjectSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<DeleteBucketRequest, Empty> deleteBucketCallable() {
    return deleteBucketCallable;
  }

  @Override
  public UnaryCallable<GetBucketRequest, Bucket> getBucketCallable() {
    return getBucketCallable;
  }

  @Override
  public UnaryCallable<CreateBucketRequest, Bucket> createBucketCallable() {
    return createBucketCallable;
  }

  @Override
  public UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable() {
    return listBucketsCallable;
  }

  @Override
  public UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse> listBucketsPagedCallable() {
    return listBucketsPagedCallable;
  }

  @Override
  public UnaryCallable<LockBucketRetentionPolicyRequest, Bucket>
      lockBucketRetentionPolicyCallable() {
    return lockBucketRetentionPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<UpdateBucketRequest, Bucket> updateBucketCallable() {
    return updateBucketCallable;
  }

  @Override
  public UnaryCallable<ComposeObjectRequest, Object> composeObjectCallable() {
    return composeObjectCallable;
  }

  @Override
  public UnaryCallable<DeleteObjectRequest, Empty> deleteObjectCallable() {
    return deleteObjectCallable;
  }

  @Override
  public UnaryCallable<RestoreObjectRequest, Object> restoreObjectCallable() {
    return restoreObjectCallable;
  }

  @Override
  public UnaryCallable<CancelResumableWriteRequest, CancelResumableWriteResponse>
      cancelResumableWriteCallable() {
    return cancelResumableWriteCallable;
  }

  @Override
  public UnaryCallable<GetObjectRequest, Object> getObjectCallable() {
    return getObjectCallable;
  }

  @Override
  public ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> readObjectCallable() {
    return readObjectCallable;
  }

  @Override
  public BidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      bidiReadObjectCallable() {
    return bidiReadObjectCallable;
  }

  @Override
  public UnaryCallable<UpdateObjectRequest, Object> updateObjectCallable() {
    return updateObjectCallable;
  }

  @Override
  public ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> writeObjectCallable() {
    return writeObjectCallable;
  }

  @Override
  public BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse>
      bidiWriteObjectCallable() {
    return bidiWriteObjectCallable;
  }

  @Override
  public UnaryCallable<ListObjectsRequest, ListObjectsResponse> listObjectsCallable() {
    return listObjectsCallable;
  }

  @Override
  public UnaryCallable<ListObjectsRequest, ListObjectsPagedResponse> listObjectsPagedCallable() {
    return listObjectsPagedCallable;
  }

  @Override
  public UnaryCallable<RewriteObjectRequest, RewriteResponse> rewriteObjectCallable() {
    return rewriteObjectCallable;
  }

  @Override
  public UnaryCallable<StartResumableWriteRequest, StartResumableWriteResponse>
      startResumableWriteCallable() {
    return startResumableWriteCallable;
  }

  @Override
  public UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse>
      queryWriteStatusCallable() {
    return queryWriteStatusCallable;
  }

  @Override
  public UnaryCallable<MoveObjectRequest, Object> moveObjectCallable() {
    return moveObjectCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
