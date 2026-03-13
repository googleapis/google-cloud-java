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
import static com.google.storage.v2.StorageClient.ListHmacKeysPagedResponse;
import static com.google.storage.v2.StorageClient.ListNotificationsPagedResponse;
import static com.google.storage.v2.StorageClient.ListObjectsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.storage.v2.Bucket;
import com.google.storage.v2.CancelResumableWriteRequest;
import com.google.storage.v2.CancelResumableWriteResponse;
import com.google.storage.v2.ComposeObjectRequest;
import com.google.storage.v2.CreateBucketRequest;
import com.google.storage.v2.CreateHmacKeyRequest;
import com.google.storage.v2.CreateHmacKeyResponse;
import com.google.storage.v2.CreateNotificationRequest;
import com.google.storage.v2.DeleteBucketRequest;
import com.google.storage.v2.DeleteHmacKeyRequest;
import com.google.storage.v2.DeleteNotificationRequest;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.GetBucketRequest;
import com.google.storage.v2.GetHmacKeyRequest;
import com.google.storage.v2.GetNotificationRequest;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.GetServiceAccountRequest;
import com.google.storage.v2.HmacKeyMetadata;
import com.google.storage.v2.ListBucketsRequest;
import com.google.storage.v2.ListBucketsResponse;
import com.google.storage.v2.ListHmacKeysRequest;
import com.google.storage.v2.ListHmacKeysResponse;
import com.google.storage.v2.ListNotificationsRequest;
import com.google.storage.v2.ListNotificationsResponse;
import com.google.storage.v2.ListObjectsRequest;
import com.google.storage.v2.ListObjectsResponse;
import com.google.storage.v2.LockBucketRetentionPolicyRequest;
import com.google.storage.v2.Notification;
import com.google.storage.v2.Object;
import com.google.storage.v2.QueryWriteStatusRequest;
import com.google.storage.v2.QueryWriteStatusResponse;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.RewriteResponse;
import com.google.storage.v2.ServiceAccount;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.UpdateBucketRequest;
import com.google.storage.v2.UpdateHmacKeyRequest;
import com.google.storage.v2.UpdateObjectRequest;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
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

  private static final MethodDescriptor<DeleteNotificationRequest, Empty>
      deleteNotificationMethodDescriptor =
          MethodDescriptor.<DeleteNotificationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/DeleteNotification")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetNotificationRequest, Notification>
      getNotificationMethodDescriptor =
          MethodDescriptor.<GetNotificationRequest, Notification>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/GetNotification")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Notification.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateNotificationRequest, Notification>
      createNotificationMethodDescriptor =
          MethodDescriptor.<CreateNotificationRequest, Notification>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/CreateNotification")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Notification.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsMethodDescriptor =
          MethodDescriptor.<ListNotificationsRequest, ListNotificationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/ListNotifications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotificationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotificationsResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<GetServiceAccountRequest, ServiceAccount>
      getServiceAccountMethodDescriptor =
          MethodDescriptor.<GetServiceAccountRequest, ServiceAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/GetServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccount.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateHmacKeyRequest, CreateHmacKeyResponse>
      createHmacKeyMethodDescriptor =
          MethodDescriptor.<CreateHmacKeyRequest, CreateHmacKeyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/CreateHmacKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHmacKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CreateHmacKeyResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteHmacKeyRequest, Empty> deleteHmacKeyMethodDescriptor =
      MethodDescriptor.<DeleteHmacKeyRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.v2.Storage/DeleteHmacKey")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteHmacKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetHmacKeyRequest, HmacKeyMetadata>
      getHmacKeyMethodDescriptor =
          MethodDescriptor.<GetHmacKeyRequest, HmacKeyMetadata>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/GetHmacKey")
              .setRequestMarshaller(ProtoUtils.marshaller(GetHmacKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HmacKeyMetadata.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListHmacKeysRequest, ListHmacKeysResponse>
      listHmacKeysMethodDescriptor =
          MethodDescriptor.<ListHmacKeysRequest, ListHmacKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/ListHmacKeys")
              .setRequestMarshaller(ProtoUtils.marshaller(ListHmacKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHmacKeysResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateHmacKeyRequest, HmacKeyMetadata>
      updateHmacKeyMethodDescriptor =
          MethodDescriptor.<UpdateHmacKeyRequest, HmacKeyMetadata>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.v2.Storage/UpdateHmacKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHmacKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HmacKeyMetadata.getDefaultInstance()))
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
  private final UnaryCallable<DeleteNotificationRequest, Empty> deleteNotificationCallable;
  private final UnaryCallable<GetNotificationRequest, Notification> getNotificationCallable;
  private final UnaryCallable<CreateNotificationRequest, Notification> createNotificationCallable;
  private final UnaryCallable<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsCallable;
  private final UnaryCallable<ListNotificationsRequest, ListNotificationsPagedResponse>
      listNotificationsPagedCallable;
  private final UnaryCallable<ComposeObjectRequest, Object> composeObjectCallable;
  private final UnaryCallable<DeleteObjectRequest, Empty> deleteObjectCallable;
  private final UnaryCallable<CancelResumableWriteRequest, CancelResumableWriteResponse>
      cancelResumableWriteCallable;
  private final UnaryCallable<GetObjectRequest, Object> getObjectCallable;
  private final ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> readObjectCallable;
  private final UnaryCallable<UpdateObjectRequest, Object> updateObjectCallable;
  private final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse>
      writeObjectCallable;
  private final UnaryCallable<ListObjectsRequest, ListObjectsResponse> listObjectsCallable;
  private final UnaryCallable<ListObjectsRequest, ListObjectsPagedResponse>
      listObjectsPagedCallable;
  private final UnaryCallable<RewriteObjectRequest, RewriteResponse> rewriteObjectCallable;
  private final UnaryCallable<StartResumableWriteRequest, StartResumableWriteResponse>
      startResumableWriteCallable;
  private final UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse>
      queryWriteStatusCallable;
  private final UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable;
  private final UnaryCallable<CreateHmacKeyRequest, CreateHmacKeyResponse> createHmacKeyCallable;
  private final UnaryCallable<DeleteHmacKeyRequest, Empty> deleteHmacKeyCallable;
  private final UnaryCallable<GetHmacKeyRequest, HmacKeyMetadata> getHmacKeyCallable;
  private final UnaryCallable<ListHmacKeysRequest, ListHmacKeysResponse> listHmacKeysCallable;
  private final UnaryCallable<ListHmacKeysRequest, ListHmacKeysPagedResponse>
      listHmacKeysPagedCallable;
  private final UnaryCallable<UpdateHmacKeyRequest, HmacKeyMetadata> updateHmacKeyCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_BUCKET_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate GET_BUCKET_0_PATH_TEMPLATE = PathTemplate.create("{bucket=**}");
  private static final PathTemplate CREATE_BUCKET_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate LIST_BUCKETS_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate LOCK_BUCKET_RETENTION_POLICY_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate GET_IAM_POLICY_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate GET_IAM_POLICY_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/objects/**");
  private static final PathTemplate SET_IAM_POLICY_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate SET_IAM_POLICY_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/objects/**");
  private static final PathTemplate TEST_IAM_PERMISSIONS_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate TEST_IAM_PERMISSIONS_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/objects/**");
  private static final PathTemplate UPDATE_BUCKET_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate DELETE_NOTIFICATION_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate GET_NOTIFICATION_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate CREATE_NOTIFICATION_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate LIST_NOTIFICATIONS_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate COMPOSE_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate DELETE_OBJECT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate CANCEL_RESUMABLE_WRITE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate GET_OBJECT_0_PATH_TEMPLATE = PathTemplate.create("{bucket=**}");
  private static final PathTemplate READ_OBJECT_0_PATH_TEMPLATE =
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
  private static final PathTemplate GET_SERVICE_ACCOUNT_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate CREATE_HMAC_KEY_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate DELETE_HMAC_KEY_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate GET_HMAC_KEY_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate LIST_HMAC_KEYS_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");
  private static final PathTemplate UPDATE_HMAC_KEY_0_PATH_TEMPLATE =
      PathTemplate.create("{project=**}");

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
            .build();
    GrpcCallSettings<CreateBucketRequest, Bucket> createBucketTransportSettings =
        GrpcCallSettings.<CreateBucketRequest, Bucket>newBuilder()
            .setMethodDescriptor(createBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "project", CREATE_BUCKET_0_PATH_TEMPLATE);
                  return builder.build();
                })
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
                      return builder.build();
                    })
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
    GrpcCallSettings<DeleteNotificationRequest, Empty> deleteNotificationTransportSettings =
        GrpcCallSettings.<DeleteNotificationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteNotificationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", DELETE_NOTIFICATION_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNotificationRequest, Notification> getNotificationTransportSettings =
        GrpcCallSettings.<GetNotificationRequest, Notification>newBuilder()
            .setMethodDescriptor(getNotificationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", GET_NOTIFICATION_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateNotificationRequest, Notification> createNotificationTransportSettings =
        GrpcCallSettings.<CreateNotificationRequest, Notification>newBuilder()
            .setMethodDescriptor(createNotificationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "bucket", CREATE_NOTIFICATION_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNotificationsRequest, ListNotificationsResponse>
        listNotificationsTransportSettings =
            GrpcCallSettings.<ListNotificationsRequest, ListNotificationsResponse>newBuilder()
                .setMethodDescriptor(listNotificationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "bucket", LIST_NOTIFICATIONS_0_PATH_TEMPLATE);
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
    GrpcCallSettings<ListObjectsRequest, ListObjectsResponse> listObjectsTransportSettings =
        GrpcCallSettings.<ListObjectsRequest, ListObjectsResponse>newBuilder()
            .setMethodDescriptor(listObjectsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "bucket", LIST_OBJECTS_0_PATH_TEMPLATE);
                  return builder.build();
                })
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
    GrpcCallSettings<GetServiceAccountRequest, ServiceAccount> getServiceAccountTransportSettings =
        GrpcCallSettings.<GetServiceAccountRequest, ServiceAccount>newBuilder()
            .setMethodDescriptor(getServiceAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProject(), "project", GET_SERVICE_ACCOUNT_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateHmacKeyRequest, CreateHmacKeyResponse> createHmacKeyTransportSettings =
        GrpcCallSettings.<CreateHmacKeyRequest, CreateHmacKeyResponse>newBuilder()
            .setMethodDescriptor(createHmacKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProject(), "project", CREATE_HMAC_KEY_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHmacKeyRequest, Empty> deleteHmacKeyTransportSettings =
        GrpcCallSettings.<DeleteHmacKeyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteHmacKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProject(), "project", DELETE_HMAC_KEY_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetHmacKeyRequest, HmacKeyMetadata> getHmacKeyTransportSettings =
        GrpcCallSettings.<GetHmacKeyRequest, HmacKeyMetadata>newBuilder()
            .setMethodDescriptor(getHmacKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProject(), "project", GET_HMAC_KEY_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListHmacKeysRequest, ListHmacKeysResponse> listHmacKeysTransportSettings =
        GrpcCallSettings.<ListHmacKeysRequest, ListHmacKeysResponse>newBuilder()
            .setMethodDescriptor(listHmacKeysMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProject(), "project", LIST_HMAC_KEYS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateHmacKeyRequest, HmacKeyMetadata> updateHmacKeyTransportSettings =
        GrpcCallSettings.<UpdateHmacKeyRequest, HmacKeyMetadata>newBuilder()
            .setMethodDescriptor(updateHmacKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getHmacKey() != null) {
                    builder.add(
                        request.getHmacKey().getProject(),
                        "project",
                        UPDATE_HMAC_KEY_0_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
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
    this.deleteNotificationCallable =
        callableFactory.createUnaryCallable(
            deleteNotificationTransportSettings,
            settings.deleteNotificationSettings(),
            clientContext);
    this.getNotificationCallable =
        callableFactory.createUnaryCallable(
            getNotificationTransportSettings, settings.getNotificationSettings(), clientContext);
    this.createNotificationCallable =
        callableFactory.createUnaryCallable(
            createNotificationTransportSettings,
            settings.createNotificationSettings(),
            clientContext);
    this.listNotificationsCallable =
        callableFactory.createUnaryCallable(
            listNotificationsTransportSettings,
            settings.listNotificationsSettings(),
            clientContext);
    this.listNotificationsPagedCallable =
        callableFactory.createPagedCallable(
            listNotificationsTransportSettings,
            settings.listNotificationsSettings(),
            clientContext);
    this.composeObjectCallable =
        callableFactory.createUnaryCallable(
            composeObjectTransportSettings, settings.composeObjectSettings(), clientContext);
    this.deleteObjectCallable =
        callableFactory.createUnaryCallable(
            deleteObjectTransportSettings, settings.deleteObjectSettings(), clientContext);
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
    this.updateObjectCallable =
        callableFactory.createUnaryCallable(
            updateObjectTransportSettings, settings.updateObjectSettings(), clientContext);
    this.writeObjectCallable =
        callableFactory.createClientStreamingCallable(
            writeObjectTransportSettings, settings.writeObjectSettings(), clientContext);
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
    this.getServiceAccountCallable =
        callableFactory.createUnaryCallable(
            getServiceAccountTransportSettings,
            settings.getServiceAccountSettings(),
            clientContext);
    this.createHmacKeyCallable =
        callableFactory.createUnaryCallable(
            createHmacKeyTransportSettings, settings.createHmacKeySettings(), clientContext);
    this.deleteHmacKeyCallable =
        callableFactory.createUnaryCallable(
            deleteHmacKeyTransportSettings, settings.deleteHmacKeySettings(), clientContext);
    this.getHmacKeyCallable =
        callableFactory.createUnaryCallable(
            getHmacKeyTransportSettings, settings.getHmacKeySettings(), clientContext);
    this.listHmacKeysCallable =
        callableFactory.createUnaryCallable(
            listHmacKeysTransportSettings, settings.listHmacKeysSettings(), clientContext);
    this.listHmacKeysPagedCallable =
        callableFactory.createPagedCallable(
            listHmacKeysTransportSettings, settings.listHmacKeysSettings(), clientContext);
    this.updateHmacKeyCallable =
        callableFactory.createUnaryCallable(
            updateHmacKeyTransportSettings, settings.updateHmacKeySettings(), clientContext);

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
  public UnaryCallable<DeleteNotificationRequest, Empty> deleteNotificationCallable() {
    return deleteNotificationCallable;
  }

  @Override
  public UnaryCallable<GetNotificationRequest, Notification> getNotificationCallable() {
    return getNotificationCallable;
  }

  @Override
  public UnaryCallable<CreateNotificationRequest, Notification> createNotificationCallable() {
    return createNotificationCallable;
  }

  @Override
  public UnaryCallable<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsCallable() {
    return listNotificationsCallable;
  }

  @Override
  public UnaryCallable<ListNotificationsRequest, ListNotificationsPagedResponse>
      listNotificationsPagedCallable() {
    return listNotificationsPagedCallable;
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
  public UnaryCallable<UpdateObjectRequest, Object> updateObjectCallable() {
    return updateObjectCallable;
  }

  @Override
  public ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> writeObjectCallable() {
    return writeObjectCallable;
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
  public UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable() {
    return getServiceAccountCallable;
  }

  @Override
  public UnaryCallable<CreateHmacKeyRequest, CreateHmacKeyResponse> createHmacKeyCallable() {
    return createHmacKeyCallable;
  }

  @Override
  public UnaryCallable<DeleteHmacKeyRequest, Empty> deleteHmacKeyCallable() {
    return deleteHmacKeyCallable;
  }

  @Override
  public UnaryCallable<GetHmacKeyRequest, HmacKeyMetadata> getHmacKeyCallable() {
    return getHmacKeyCallable;
  }

  @Override
  public UnaryCallable<ListHmacKeysRequest, ListHmacKeysResponse> listHmacKeysCallable() {
    return listHmacKeysCallable;
  }

  @Override
  public UnaryCallable<ListHmacKeysRequest, ListHmacKeysPagedResponse> listHmacKeysPagedCallable() {
    return listHmacKeysPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHmacKeyRequest, HmacKeyMetadata> updateHmacKeyCallable() {
    return updateHmacKeyCallable;
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
