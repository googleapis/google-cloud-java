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

package com.google.storage.v2;

import com.google.api.core.BetaApi;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.storage.v2.StorageGrpc.StorageImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockStorageImpl extends StorageImplBase {
  private List<AbstractMessage> requests;
  private Queue<java.lang.Object> responses;

  public MockStorageImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<java.lang.Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void deleteBucket(DeleteBucketRequest request, StreamObserver<Empty> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteBucket, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBucket(GetBucketRequest request, StreamObserver<Bucket> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Bucket) {
      requests.add(request);
      responseObserver.onNext(((Bucket) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBucket, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Bucket.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBucket(CreateBucketRequest request, StreamObserver<Bucket> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Bucket) {
      requests.add(request);
      responseObserver.onNext(((Bucket) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBucket, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Bucket.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBuckets(
      ListBucketsRequest request, StreamObserver<ListBucketsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListBucketsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBucketsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBuckets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBucketsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lockBucketRetentionPolicy(
      LockBucketRetentionPolicyRequest request, StreamObserver<Bucket> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Bucket) {
      requests.add(request);
      responseObserver.onNext(((Bucket) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LockBucketRetentionPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Bucket.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof TestIamPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext(((TestIamPermissionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TestIamPermissions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBucket(UpdateBucketRequest request, StreamObserver<Bucket> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Bucket) {
      requests.add(request);
      responseObserver.onNext(((Bucket) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBucket, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Bucket.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNotification(
      DeleteNotificationRequest request, StreamObserver<Empty> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteNotification, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNotification(
      GetNotificationRequest request, StreamObserver<Notification> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Notification) {
      requests.add(request);
      responseObserver.onNext(((Notification) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNotification, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Notification.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createNotification(
      CreateNotificationRequest request, StreamObserver<Notification> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Notification) {
      requests.add(request);
      responseObserver.onNext(((Notification) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateNotification, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Notification.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNotifications(
      ListNotificationsRequest request,
      StreamObserver<ListNotificationsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListNotificationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNotificationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNotifications, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNotificationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void composeObject(ComposeObjectRequest request, StreamObserver<Object> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Object) {
      requests.add(request);
      responseObserver.onNext(((Object) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ComposeObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Object.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteObject(DeleteObjectRequest request, StreamObserver<Empty> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelResumableWrite(
      CancelResumableWriteRequest request,
      StreamObserver<CancelResumableWriteResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof CancelResumableWriteResponse) {
      requests.add(request);
      responseObserver.onNext(((CancelResumableWriteResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelResumableWrite, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CancelResumableWriteResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getObject(GetObjectRequest request, StreamObserver<Object> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Object) {
      requests.add(request);
      responseObserver.onNext(((Object) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Object.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void readObject(
      ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ReadObjectResponse) {
      requests.add(request);
      responseObserver.onNext(((ReadObjectResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReadObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReadObjectResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateObject(UpdateObjectRequest request, StreamObserver<Object> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Object) {
      requests.add(request);
      responseObserver.onNext(((Object) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Object.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<WriteObjectRequest> writeObject(
      final StreamObserver<WriteObjectResponse> responseObserver) {
    StreamObserver<WriteObjectRequest> requestObserver =
        new StreamObserver<WriteObjectRequest>() {
          @Override
          public void onNext(WriteObjectRequest value) {
            requests.add(value);
            final java.lang.Object response = responses.remove();
            if (response instanceof WriteObjectResponse) {
              responseObserver.onNext(((WriteObjectResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method WriteObject, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          WriteObjectResponse.class.getName(),
                          Exception.class.getName())));
            }
          }

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }

  @Override
  public void listObjects(
      ListObjectsRequest request, StreamObserver<ListObjectsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListObjectsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListObjectsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListObjects, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListObjectsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rewriteObject(
      RewriteObjectRequest request, StreamObserver<RewriteResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof RewriteResponse) {
      requests.add(request);
      responseObserver.onNext(((RewriteResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RewriteObject, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RewriteResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startResumableWrite(
      StartResumableWriteRequest request,
      StreamObserver<StartResumableWriteResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof StartResumableWriteResponse) {
      requests.add(request);
      responseObserver.onNext(((StartResumableWriteResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StartResumableWrite, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StartResumableWriteResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryWriteStatus(
      QueryWriteStatusRequest request, StreamObserver<QueryWriteStatusResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof QueryWriteStatusResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryWriteStatusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryWriteStatus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryWriteStatusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServiceAccount(
      GetServiceAccountRequest request, StreamObserver<ServiceAccount> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ServiceAccount) {
      requests.add(request);
      responseObserver.onNext(((ServiceAccount) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceAccount.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHmacKey(
      CreateHmacKeyRequest request, StreamObserver<CreateHmacKeyResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof CreateHmacKeyResponse) {
      requests.add(request);
      responseObserver.onNext(((CreateHmacKeyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateHmacKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CreateHmacKeyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHmacKey(DeleteHmacKeyRequest request, StreamObserver<Empty> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteHmacKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHmacKey(
      GetHmacKeyRequest request, StreamObserver<HmacKeyMetadata> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof HmacKeyMetadata) {
      requests.add(request);
      responseObserver.onNext(((HmacKeyMetadata) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHmacKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HmacKeyMetadata.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHmacKeys(
      ListHmacKeysRequest request, StreamObserver<ListHmacKeysResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListHmacKeysResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHmacKeysResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHmacKeys, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHmacKeysResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHmacKey(
      UpdateHmacKeyRequest request, StreamObserver<HmacKeyMetadata> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof HmacKeyMetadata) {
      requests.add(request);
      responseObserver.onNext(((HmacKeyMetadata) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateHmacKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HmacKeyMetadata.class.getName(),
                  Exception.class.getName())));
    }
  }
}
