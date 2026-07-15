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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListSACAttachmentsPagedResponse;
import static com.google.cloud.networksecurity.v1.SSERealmServiceClient.ListSACRealmsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.CreateSACRealmRequest;
import com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.DeleteSACRealmRequest;
import com.google.cloud.networksecurity.v1.GetSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.GetSACRealmRequest;
import com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest;
import com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse;
import com.google.cloud.networksecurity.v1.ListSACRealmsRequest;
import com.google.cloud.networksecurity.v1.ListSACRealmsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.SACAttachment;
import com.google.cloud.networksecurity.v1.SACRealm;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SSERealmService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class SSERealmServiceStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListSACRealmsRequest, ListSACRealmsPagedResponse>
      listSACRealmsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSACRealmsPagedCallable()");
  }

  public UnaryCallable<ListSACRealmsRequest, ListSACRealmsResponse> listSACRealmsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSACRealmsCallable()");
  }

  public UnaryCallable<GetSACRealmRequest, SACRealm> getSACRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: getSACRealmCallable()");
  }

  public OperationCallable<CreateSACRealmRequest, SACRealm, OperationMetadata>
      createSACRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSACRealmOperationCallable()");
  }

  public UnaryCallable<CreateSACRealmRequest, Operation> createSACRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: createSACRealmCallable()");
  }

  public OperationCallable<DeleteSACRealmRequest, Empty, OperationMetadata>
      deleteSACRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSACRealmOperationCallable()");
  }

  public UnaryCallable<DeleteSACRealmRequest, Operation> deleteSACRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSACRealmCallable()");
  }

  public UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsPagedResponse>
      listSACAttachmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSACAttachmentsPagedCallable()");
  }

  public UnaryCallable<ListSACAttachmentsRequest, ListSACAttachmentsResponse>
      listSACAttachmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSACAttachmentsCallable()");
  }

  public UnaryCallable<GetSACAttachmentRequest, SACAttachment> getSACAttachmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getSACAttachmentCallable()");
  }

  public OperationCallable<CreateSACAttachmentRequest, SACAttachment, OperationMetadata>
      createSACAttachmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSACAttachmentOperationCallable()");
  }

  public UnaryCallable<CreateSACAttachmentRequest, Operation> createSACAttachmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createSACAttachmentCallable()");
  }

  public OperationCallable<DeleteSACAttachmentRequest, Empty, OperationMetadata>
      deleteSACAttachmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSACAttachmentOperationCallable()");
  }

  public UnaryCallable<DeleteSACAttachmentRequest, Operation> deleteSACAttachmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSACAttachmentCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
