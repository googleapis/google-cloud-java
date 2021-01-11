/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.accessapproval.v1.stub;

import static com.google.cloud.accessapproval.v1.AccessApprovalAdminClient.ListApprovalRequestsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.accessapproval.v1.AccessApprovalSettings;
import com.google.cloud.accessapproval.v1.ApprovalRequest;
import com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage;
import com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage;
import com.google.cloud.accessapproval.v1.GetApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage;
import com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse;
import com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AccessApproval service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AccessApprovalStub implements BackgroundResource {

  public UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsPagedResponse>
      listApprovalRequestsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApprovalRequestsPagedCallable()");
  }

  public UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsResponse>
      listApprovalRequestsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApprovalRequestsCallable()");
  }

  public UnaryCallable<GetApprovalRequestMessage, ApprovalRequest> getApprovalRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: getApprovalRequestCallable()");
  }

  public UnaryCallable<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: approveApprovalRequestCallable()");
  }

  public UnaryCallable<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestCallable() {
    throw new UnsupportedOperationException("Not implemented: dismissApprovalRequestCallable()");
  }

  public UnaryCallable<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccessApprovalSettingsCallable()");
  }

  public UnaryCallable<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAccessApprovalSettingsCallable()");
  }

  public UnaryCallable<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAccessApprovalSettingsCallable()");
  }

  @Override
  public abstract void close();
}
