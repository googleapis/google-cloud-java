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

package com.google.ads.marketingplatform.admin.v1alpha.stub;

import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAdminAccessBindingsPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAnalyticsAccountLinksPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListOrganizationsPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListUserGroupMembersPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListUserGroupsPagedResponse;

import com.google.ads.marketingplatform.admin.v1alpha.AdminAccessBinding;
import com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAdminAccessBindingRequest;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.CreateUserGroupMemberRequest;
import com.google.ads.marketingplatform.admin.v1alpha.CreateUserGroupRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteUserGroupMemberRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteUserGroupRequest;
import com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest;
import com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse;
import com.google.ads.marketingplatform.admin.v1alpha.GetAdminAccessBindingRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetUserGroupMemberRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetUserGroupRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAdminAccessBindingsRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAdminAccessBindingsResponse;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse;
import com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupMembersRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupMembersResponse;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupsRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupsResponse;
import com.google.ads.marketingplatform.admin.v1alpha.Organization;
import com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse;
import com.google.ads.marketingplatform.admin.v1alpha.UpdateAdminAccessBindingRequest;
import com.google.ads.marketingplatform.admin.v1alpha.UpdateUserGroupMemberRequest;
import com.google.ads.marketingplatform.admin.v1alpha.UpdateUserGroupRequest;
import com.google.ads.marketingplatform.admin.v1alpha.UserGroup;
import com.google.ads.marketingplatform.admin.v1alpha.UserGroupMember;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MarketingplatformAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MarketingplatformAdminServiceStub implements BackgroundResource {

  public UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrganizationCallable()");
  }

  public UnaryCallable<ListOrganizationsRequest, ListOrganizationsPagedResponse>
      listOrganizationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrganizationsPagedCallable()");
  }

  public UnaryCallable<ListOrganizationsRequest, ListOrganizationsResponse>
      listOrganizationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrganizationsCallable()");
  }

  public UnaryCallable<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: findSalesPartnerManagedClientsCallable()");
  }

  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAnalyticsAccountLinksPagedCallable()");
  }

  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalyticsAccountLinksCallable()");
  }

  public UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAnalyticsAccountLinkCallable()");
  }

  public UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAnalyticsAccountLinkCallable()");
  }

  public UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable() {
    throw new UnsupportedOperationException("Not implemented: setPropertyServiceLevelCallable()");
  }

  public UnaryCallable<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageCallable() {
    throw new UnsupportedOperationException("Not implemented: reportPropertyUsageCallable()");
  }

  public UnaryCallable<GetUserGroupRequest, UserGroup> getUserGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserGroupCallable()");
  }

  public UnaryCallable<ListUserGroupsRequest, ListUserGroupsPagedResponse>
      listUserGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserGroupsPagedCallable()");
  }

  public UnaryCallable<ListUserGroupsRequest, ListUserGroupsResponse> listUserGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserGroupsCallable()");
  }

  public UnaryCallable<CreateUserGroupRequest, UserGroup> createUserGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserGroupCallable()");
  }

  public UnaryCallable<UpdateUserGroupRequest, UserGroup> updateUserGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUserGroupCallable()");
  }

  public UnaryCallable<DeleteUserGroupRequest, Empty> deleteUserGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserGroupCallable()");
  }

  public UnaryCallable<GetUserGroupMemberRequest, UserGroupMember> getUserGroupMemberCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserGroupMemberCallable()");
  }

  public UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersPagedResponse>
      listUserGroupMembersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserGroupMembersPagedCallable()");
  }

  public UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersResponse>
      listUserGroupMembersCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserGroupMembersCallable()");
  }

  public UnaryCallable<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserGroupMemberCallable()");
  }

  public UnaryCallable<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUserGroupMemberCallable()");
  }

  public UnaryCallable<DeleteUserGroupMemberRequest, Empty> deleteUserGroupMemberCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserGroupMemberCallable()");
  }

  public UnaryCallable<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getAdminAccessBindingCallable()");
  }

  public UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsPagedResponse>
      listAdminAccessBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAdminAccessBindingsPagedCallable()");
  }

  public UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
      listAdminAccessBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdminAccessBindingsCallable()");
  }

  public UnaryCallable<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createAdminAccessBindingCallable()");
  }

  public UnaryCallable<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAdminAccessBindingCallable()");
  }

  @Override
  public abstract void close();
}
