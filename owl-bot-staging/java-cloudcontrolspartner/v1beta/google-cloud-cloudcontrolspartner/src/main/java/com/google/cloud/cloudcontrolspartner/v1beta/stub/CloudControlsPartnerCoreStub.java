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

package com.google.cloud.cloudcontrolspartner.v1beta.stub;

import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListAccessApprovalRequestsPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListCustomersPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListWorkloadsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudcontrolspartner.v1beta.Customer;
import com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections;
import com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.Partner;
import com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions;
import com.google.cloud.cloudcontrolspartner.v1beta.Workload;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudControlsPartnerCore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
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
