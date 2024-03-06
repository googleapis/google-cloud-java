/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1.stub;

import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListAccessApprovalRequestsPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListCustomersPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerCoreClient.ListWorkloadsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudcontrolspartner.v1.Customer;
import com.google.cloud.cloudcontrolspartner.v1.EkmConnections;
import com.google.cloud.cloudcontrolspartner.v1.GetCustomerRequest;
import com.google.cloud.cloudcontrolspartner.v1.GetEkmConnectionsRequest;
import com.google.cloud.cloudcontrolspartner.v1.GetPartnerPermissionsRequest;
import com.google.cloud.cloudcontrolspartner.v1.GetPartnerRequest;
import com.google.cloud.cloudcontrolspartner.v1.GetWorkloadRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListAccessApprovalRequestsRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListAccessApprovalRequestsResponse;
import com.google.cloud.cloudcontrolspartner.v1.ListCustomersRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListCustomersResponse;
import com.google.cloud.cloudcontrolspartner.v1.ListWorkloadsRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListWorkloadsResponse;
import com.google.cloud.cloudcontrolspartner.v1.Partner;
import com.google.cloud.cloudcontrolspartner.v1.PartnerPermissions;
import com.google.cloud.cloudcontrolspartner.v1.Workload;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudControlsPartnerCore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudControlsPartnerCoreStub implements BackgroundResource {

  public UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkloadCallable()");
  }

  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkloadsPagedCallable()");
  }

  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkloadsCallable()");
  }

  public UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomerCallable()");
  }

  public UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomersPagedCallable()");
  }

  public UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomersCallable()");
  }

  public UnaryCallable<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: getEkmConnectionsCallable()");
  }

  public UnaryCallable<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: getPartnerPermissionsCallable()");
  }

  public UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAccessApprovalRequestsPagedCallable()");
  }

  public UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
      listAccessApprovalRequestsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAccessApprovalRequestsCallable()");
  }

  public UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable() {
    throw new UnsupportedOperationException("Not implemented: getPartnerCallable()");
  }

  @Override
  public abstract void close();
}
