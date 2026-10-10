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

package com.google.ads.marketingplatform.admin.v1alpha;

import com.google.ads.marketingplatform.admin.v1alpha.stub.MarketingplatformAdminServiceStub;
import com.google.ads.marketingplatform.admin.v1alpha.stub.MarketingplatformAdminServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service Interface for the Google Marketing Platform Admin API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
 *     MarketingplatformAdminServiceClient.create()) {
 *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
 *   Organization response = marketingplatformAdminServiceClient.getOrganization(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MarketingplatformAdminServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetOrganization</td>
 *      <td><p> Looks up a single organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOrganization(GetOrganizationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOrganization(OrganizationName name)
 *           <li><p> getOrganization(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOrganizationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOrganizations</td>
 *      <td><p> Returns a list of organizations that the user has access to.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOrganizations(ListOrganizationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOrganizationsPagedCallable()
 *           <li><p> listOrganizationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FindSalesPartnerManagedClients</td>
 *      <td><p> Returns a list of clients managed by the sales partner organization.
 * <p>  User needs to be an OrgAdmin/BillingAdmin on the sales partner organization in order to view the end clients.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> findSalesPartnerManagedClients(FindSalesPartnerManagedClientsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> findSalesPartnerManagedClientsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnalyticsAccountLinks</td>
 *      <td><p> Lists the Google Analytics accounts link to the specified Google Marketing Platform organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnalyticsAccountLinks(ListAnalyticsAccountLinksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnalyticsAccountLinks(OrganizationName parent)
 *           <li><p> listAnalyticsAccountLinks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnalyticsAccountLinksPagedCallable()
 *           <li><p> listAnalyticsAccountLinksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAnalyticsAccountLink</td>
 *      <td><p> Creates the link between the Analytics account and the Google Marketing Platform organization.
 * <p>  User needs to be an org user, and admin on the Analytics account to create the link. If the account is already linked to an organization, user needs to unlink the account from the current organization, then try link again.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAnalyticsAccountLink(CreateAnalyticsAccountLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAnalyticsAccountLink(OrganizationName parent, AnalyticsAccountLink analyticsAccountLink)
 *           <li><p> createAnalyticsAccountLink(String parent, AnalyticsAccountLink analyticsAccountLink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAnalyticsAccountLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAnalyticsAccountLink</td>
 *      <td><p> Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google Marketing Platform organization.
 * <p>  User needs to be an org user, and admin on the Analytics account in order to delete the link.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAnalyticsAccountLink(DeleteAnalyticsAccountLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAnalyticsAccountLink(AnalyticsAccountLinkName name)
 *           <li><p> deleteAnalyticsAccountLink(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAnalyticsAccountLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetPropertyServiceLevel</td>
 *      <td><p> Updates the service level for an Analytics property.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setPropertyServiceLevel(SetPropertyServiceLevelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setPropertyServiceLevel(String analyticsAccountLink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setPropertyServiceLevelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReportPropertyUsage</td>
 *      <td><p> Gets the usage and billing data for properties within the organization for the specified month.
 * <p>  Per direct client org, user needs to be OrgAdmin/BillingAdmin on the organization in order to view the billing and usage data.
 * <p>  Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on the sales partner org in order to view the billing and usage data, or OrgAdmin/BillingAdmin on the sales partner client org in order to view the usage data only.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> reportPropertyUsage(ReportPropertyUsageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> reportPropertyUsage(String organization)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> reportPropertyUsageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUserGroup</td>
 *      <td><p> Looks up a single user group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUserGroup(GetUserGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUserGroup(UserGroupName name)
 *           <li><p> getUserGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUserGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUserGroups</td>
 *      <td><p> Returns a list of user groups in the specified GMP organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUserGroups(ListUserGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUserGroups(OrganizationName parent)
 *           <li><p> listUserGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUserGroupsPagedCallable()
 *           <li><p> listUserGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateUserGroup</td>
 *      <td><p> Creates a user group in the specified GMP organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUserGroup(CreateUserGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUserGroup(OrganizationName parent, UserGroup userGroup)
 *           <li><p> createUserGroup(String parent, UserGroup userGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUserGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUserGroup</td>
 *      <td><p> Updates a user group in the specified GMP organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUserGroup(UpdateUserGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUserGroup(UserGroup userGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUserGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUserGroup</td>
 *      <td><p> Deletes a user group in the specified GMP organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUserGroup(DeleteUserGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteUserGroup(UserGroupName name)
 *           <li><p> deleteUserGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUserGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUserGroupMember</td>
 *      <td><p> Looks up a single user group member.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUserGroupMember(GetUserGroupMemberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUserGroupMember(UserGroupMemberName name)
 *           <li><p> getUserGroupMember(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUserGroupMemberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUserGroupMembers</td>
 *      <td><p> Returns a list of members in the specified user group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUserGroupMembers(ListUserGroupMembersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUserGroupMembers(UserGroupName parent)
 *           <li><p> listUserGroupMembers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUserGroupMembersPagedCallable()
 *           <li><p> listUserGroupMembersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateUserGroupMember</td>
 *      <td><p> Adds a member to the specified GMP user group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUserGroupMember(CreateUserGroupMemberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUserGroupMember(UserGroupName parent, UserGroupMember userGroupMember)
 *           <li><p> createUserGroupMember(String parent, UserGroupMember userGroupMember)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUserGroupMemberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUserGroupMember</td>
 *      <td><p> Updates a member in the specified GMP user group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUserGroupMember(UpdateUserGroupMemberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUserGroupMember(UserGroupMember userGroupMember, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUserGroupMemberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUserGroupMember</td>
 *      <td><p> Deletes a member in the specified GMP user group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUserGroupMember(DeleteUserGroupMemberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteUserGroupMember(UserGroupMemberName name)
 *           <li><p> deleteUserGroupMember(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUserGroupMemberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAdminAccessBinding</td>
 *      <td><p> Looks up a single admin access binding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdminAccessBinding(GetAdminAccessBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdminAccessBinding(AdminAccessBindingName name)
 *           <li><p> getAdminAccessBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdminAccessBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdminAccessBindings</td>
 *      <td><p> Returns a list of admin access bindings in the specified GMP organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdminAccessBindings(ListAdminAccessBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdminAccessBindings(OrganizationName parent)
 *           <li><p> listAdminAccessBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdminAccessBindingsPagedCallable()
 *           <li><p> listAdminAccessBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAdminAccessBinding</td>
 *      <td><p> Creates an admin access binding in the specified GMP organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAdminAccessBinding(CreateAdminAccessBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAdminAccessBinding(OrganizationName parent, AdminAccessBinding adminAccessBinding)
 *           <li><p> createAdminAccessBinding(String parent, AdminAccessBinding adminAccessBinding)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAdminAccessBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAdminAccessBinding</td>
 *      <td><p> Updates an admin access binding in the specified GMP organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAdminAccessBinding(UpdateAdminAccessBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAdminAccessBinding(AdminAccessBinding adminAccessBinding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAdminAccessBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * MarketingplatformAdminServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MarketingplatformAdminServiceSettings marketingplatformAdminServiceSettings =
 *     MarketingplatformAdminServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
 *     MarketingplatformAdminServiceClient.create(marketingplatformAdminServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MarketingplatformAdminServiceSettings marketingplatformAdminServiceSettings =
 *     MarketingplatformAdminServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
 *     MarketingplatformAdminServiceClient.create(marketingplatformAdminServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MarketingplatformAdminServiceSettings marketingplatformAdminServiceSettings =
 *     MarketingplatformAdminServiceSettings.newHttpJsonBuilder().build();
 * MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
 *     MarketingplatformAdminServiceClient.create(marketingplatformAdminServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class MarketingplatformAdminServiceClient implements BackgroundResource {
  private final @Nullable MarketingplatformAdminServiceSettings settings;
  private final MarketingplatformAdminServiceStub stub;

  /** Constructs an instance of MarketingplatformAdminServiceClient with default settings. */
  public static final MarketingplatformAdminServiceClient create() throws IOException {
    return create(MarketingplatformAdminServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MarketingplatformAdminServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final MarketingplatformAdminServiceClient create(
      MarketingplatformAdminServiceSettings settings) throws IOException {
    return new MarketingplatformAdminServiceClient(settings);
  }

  /**
   * Constructs an instance of MarketingplatformAdminServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(MarketingplatformAdminServiceSettings).
   */
  public static final MarketingplatformAdminServiceClient create(
      MarketingplatformAdminServiceStub stub) {
    return new MarketingplatformAdminServiceClient(stub);
  }

  /**
   * Constructs an instance of MarketingplatformAdminServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MarketingplatformAdminServiceClient(MarketingplatformAdminServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((MarketingplatformAdminServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MarketingplatformAdminServiceClient(MarketingplatformAdminServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable MarketingplatformAdminServiceSettings getSettings() {
    return settings;
  }

  public MarketingplatformAdminServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
   *   Organization response = marketingplatformAdminServiceClient.getOrganization(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Organization to retrieve. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(@Nullable OrganizationName name) {
    GetOrganizationRequest request =
        GetOrganizationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOrganization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name = OrganizationName.of("[ORGANIZATION]").toString();
   *   Organization response = marketingplatformAdminServiceClient.getOrganization(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Organization to retrieve. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(String name) {
    GetOrganizationRequest request = GetOrganizationRequest.newBuilder().setName(name).build();
    return getOrganization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetOrganizationRequest request =
   *       GetOrganizationRequest.newBuilder()
   *           .setName(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   Organization response = marketingplatformAdminServiceClient.getOrganization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(GetOrganizationRequest request) {
    return getOrganizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetOrganizationRequest request =
   *       GetOrganizationRequest.newBuilder()
   *           .setName(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   ApiFuture<Organization> future =
   *       marketingplatformAdminServiceClient.getOrganizationCallable().futureCall(request);
   *   // Do something.
   *   Organization response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    return stub.getOrganizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of organizations that the user has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListOrganizationsRequest request =
   *       ListOrganizationsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Organization element :
   *       marketingplatformAdminServiceClient.listOrganizations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrganizationsPagedResponse listOrganizations(ListOrganizationsRequest request) {
    return listOrganizationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of organizations that the user has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListOrganizationsRequest request =
   *       ListOrganizationsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Organization> future =
   *       marketingplatformAdminServiceClient.listOrganizationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Organization element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrganizationsRequest, ListOrganizationsPagedResponse>
      listOrganizationsPagedCallable() {
    return stub.listOrganizationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of organizations that the user has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListOrganizationsRequest request =
   *       ListOrganizationsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOrganizationsResponse response =
   *         marketingplatformAdminServiceClient.listOrganizationsCallable().call(request);
   *     for (Organization element : response.getOrganizationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrganizationsRequest, ListOrganizationsResponse>
      listOrganizationsCallable() {
    return stub.listOrganizationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of clients managed by the sales partner organization.
   *
   * <p>User needs to be an OrgAdmin/BillingAdmin on the sales partner organization in order to view
   * the end clients.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   FindSalesPartnerManagedClientsRequest request =
   *       FindSalesPartnerManagedClientsRequest.newBuilder()
   *           .setOrganization(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setIsActive(true)
   *           .build();
   *   FindSalesPartnerManagedClientsResponse response =
   *       marketingplatformAdminServiceClient.findSalesPartnerManagedClients(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindSalesPartnerManagedClientsResponse findSalesPartnerManagedClients(
      FindSalesPartnerManagedClientsRequest request) {
    return findSalesPartnerManagedClientsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of clients managed by the sales partner organization.
   *
   * <p>User needs to be an OrgAdmin/BillingAdmin on the sales partner organization in order to view
   * the end clients.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   FindSalesPartnerManagedClientsRequest request =
   *       FindSalesPartnerManagedClientsRequest.newBuilder()
   *           .setOrganization(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setIsActive(true)
   *           .build();
   *   ApiFuture<FindSalesPartnerManagedClientsResponse> future =
   *       marketingplatformAdminServiceClient
   *           .findSalesPartnerManagedClientsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FindSalesPartnerManagedClientsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsCallable() {
    return stub.findSalesPartnerManagedClientsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (AnalyticsAccountLink element :
   *       marketingplatformAdminServiceClient.listAnalyticsAccountLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent organization, which owns this collection of Analytics
   *     account links. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyticsAccountLinksPagedResponse listAnalyticsAccountLinks(
      @Nullable OrganizationName parent) {
    ListAnalyticsAccountLinksRequest request =
        ListAnalyticsAccountLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnalyticsAccountLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (AnalyticsAccountLink element :
   *       marketingplatformAdminServiceClient.listAnalyticsAccountLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent organization, which owns this collection of Analytics
   *     account links. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyticsAccountLinksPagedResponse listAnalyticsAccountLinks(String parent) {
    ListAnalyticsAccountLinksRequest request =
        ListAnalyticsAccountLinksRequest.newBuilder().setParent(parent).build();
    return listAnalyticsAccountLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAnalyticsAccountLinksRequest request =
   *       ListAnalyticsAccountLinksRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AnalyticsAccountLink element :
   *       marketingplatformAdminServiceClient.listAnalyticsAccountLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyticsAccountLinksPagedResponse listAnalyticsAccountLinks(
      ListAnalyticsAccountLinksRequest request) {
    return listAnalyticsAccountLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAnalyticsAccountLinksRequest request =
   *       ListAnalyticsAccountLinksRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AnalyticsAccountLink> future =
   *       marketingplatformAdminServiceClient
   *           .listAnalyticsAccountLinksPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AnalyticsAccountLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable() {
    return stub.listAnalyticsAccountLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAnalyticsAccountLinksRequest request =
   *       ListAnalyticsAccountLinksRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAnalyticsAccountLinksResponse response =
   *         marketingplatformAdminServiceClient.listAnalyticsAccountLinksCallable().call(request);
   *     for (AnalyticsAccountLink element : response.getAnalyticsAccountLinksList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable() {
    return stub.listAnalyticsAccountLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the link between the Analytics account and the Google Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account to create the link. If the
   * account is already linked to an organization, user needs to unlink the account from the current
   * organization, then try link again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();
   *   AnalyticsAccountLink response =
   *       marketingplatformAdminServiceClient.createAnalyticsAccountLink(
   *           parent, analyticsAccountLink);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Analytics account link will be created.
   *     Format: organizations/{org_id}
   * @param analyticsAccountLink Required. The Analytics account link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyticsAccountLink createAnalyticsAccountLink(
      @Nullable OrganizationName parent, AnalyticsAccountLink analyticsAccountLink) {
    CreateAnalyticsAccountLinkRequest request =
        CreateAnalyticsAccountLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnalyticsAccountLink(analyticsAccountLink)
            .build();
    return createAnalyticsAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the link between the Analytics account and the Google Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account to create the link. If the
   * account is already linked to an organization, user needs to unlink the account from the current
   * organization, then try link again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();
   *   AnalyticsAccountLink response =
   *       marketingplatformAdminServiceClient.createAnalyticsAccountLink(
   *           parent, analyticsAccountLink);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Analytics account link will be created.
   *     Format: organizations/{org_id}
   * @param analyticsAccountLink Required. The Analytics account link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyticsAccountLink createAnalyticsAccountLink(
      String parent, AnalyticsAccountLink analyticsAccountLink) {
    CreateAnalyticsAccountLinkRequest request =
        CreateAnalyticsAccountLinkRequest.newBuilder()
            .setParent(parent)
            .setAnalyticsAccountLink(analyticsAccountLink)
            .build();
    return createAnalyticsAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the link between the Analytics account and the Google Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account to create the link. If the
   * account is already linked to an organization, user needs to unlink the account from the current
   * organization, then try link again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateAnalyticsAccountLinkRequest request =
   *       CreateAnalyticsAccountLinkRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setAnalyticsAccountLink(AnalyticsAccountLink.newBuilder().build())
   *           .build();
   *   AnalyticsAccountLink response =
   *       marketingplatformAdminServiceClient.createAnalyticsAccountLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyticsAccountLink createAnalyticsAccountLink(
      CreateAnalyticsAccountLinkRequest request) {
    return createAnalyticsAccountLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the link between the Analytics account and the Google Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account to create the link. If the
   * account is already linked to an organization, user needs to unlink the account from the current
   * organization, then try link again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateAnalyticsAccountLinkRequest request =
   *       CreateAnalyticsAccountLinkRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setAnalyticsAccountLink(AnalyticsAccountLink.newBuilder().build())
   *           .build();
   *   ApiFuture<AnalyticsAccountLink> future =
   *       marketingplatformAdminServiceClient
   *           .createAnalyticsAccountLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   AnalyticsAccountLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable() {
    return stub.createAnalyticsAccountLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google
   * Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account in order to delete the
   * link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   AnalyticsAccountLinkName name =
   *       AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]");
   *   marketingplatformAdminServiceClient.deleteAnalyticsAccountLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Analytics account link to delete. Format:
   *     organizations/{org_id}/analyticsAccountLinks/{analytics_account_link_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalyticsAccountLink(@Nullable AnalyticsAccountLinkName name) {
    DeleteAnalyticsAccountLinkRequest request =
        DeleteAnalyticsAccountLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAnalyticsAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google
   * Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account in order to delete the
   * link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name =
   *       AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]").toString();
   *   marketingplatformAdminServiceClient.deleteAnalyticsAccountLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Analytics account link to delete. Format:
   *     organizations/{org_id}/analyticsAccountLinks/{analytics_account_link_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalyticsAccountLink(String name) {
    DeleteAnalyticsAccountLinkRequest request =
        DeleteAnalyticsAccountLinkRequest.newBuilder().setName(name).build();
    deleteAnalyticsAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google
   * Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account in order to delete the
   * link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   DeleteAnalyticsAccountLinkRequest request =
   *       DeleteAnalyticsAccountLinkRequest.newBuilder()
   *           .setName(
   *               AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
   *                   .toString())
   *           .build();
   *   marketingplatformAdminServiceClient.deleteAnalyticsAccountLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalyticsAccountLink(DeleteAnalyticsAccountLinkRequest request) {
    deleteAnalyticsAccountLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google
   * Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account in order to delete the
   * link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   DeleteAnalyticsAccountLinkRequest request =
   *       DeleteAnalyticsAccountLinkRequest.newBuilder()
   *           .setName(
   *               AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       marketingplatformAdminServiceClient
   *           .deleteAnalyticsAccountLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable() {
    return stub.deleteAnalyticsAccountLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the service level for an Analytics property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String analyticsAccountLink = "analyticsAccountLink-397570975";
   *   SetPropertyServiceLevelResponse response =
   *       marketingplatformAdminServiceClient.setPropertyServiceLevel(analyticsAccountLink);
   * }
   * }</pre>
   *
   * @param analyticsAccountLink Required. The parent AnalyticsAccountLink scope where this property
   *     is in. Format: organizations/{org_id}/analyticsAccountLinks/{analytics_account_link_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetPropertyServiceLevelResponse setPropertyServiceLevel(
      String analyticsAccountLink) {
    SetPropertyServiceLevelRequest request =
        SetPropertyServiceLevelRequest.newBuilder()
            .setAnalyticsAccountLink(analyticsAccountLink)
            .build();
    return setPropertyServiceLevel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the service level for an Analytics property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   SetPropertyServiceLevelRequest request =
   *       SetPropertyServiceLevelRequest.newBuilder()
   *           .setAnalyticsAccountLink("analyticsAccountLink-397570975")
   *           .setAnalyticsProperty(PropertyName.of("[PROPERTY]").toString())
   *           .setServiceLevel(AnalyticsServiceLevel.forNumber(0))
   *           .build();
   *   SetPropertyServiceLevelResponse response =
   *       marketingplatformAdminServiceClient.setPropertyServiceLevel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetPropertyServiceLevelResponse setPropertyServiceLevel(
      SetPropertyServiceLevelRequest request) {
    return setPropertyServiceLevelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the service level for an Analytics property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   SetPropertyServiceLevelRequest request =
   *       SetPropertyServiceLevelRequest.newBuilder()
   *           .setAnalyticsAccountLink("analyticsAccountLink-397570975")
   *           .setAnalyticsProperty(PropertyName.of("[PROPERTY]").toString())
   *           .setServiceLevel(AnalyticsServiceLevel.forNumber(0))
   *           .build();
   *   ApiFuture<SetPropertyServiceLevelResponse> future =
   *       marketingplatformAdminServiceClient.setPropertyServiceLevelCallable().futureCall(request);
   *   // Do something.
   *   SetPropertyServiceLevelResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable() {
    return stub.setPropertyServiceLevelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the usage and billing data for properties within the organization for the specified month.
   *
   * <p>Per direct client org, user needs to be OrgAdmin/BillingAdmin on the organization in order
   * to view the billing and usage data.
   *
   * <p>Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on the sales partner
   * org in order to view the billing and usage data, or OrgAdmin/BillingAdmin on the sales partner
   * client org in order to view the usage data only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String organization = "organization1178922291";
   *   ReportPropertyUsageResponse response =
   *       marketingplatformAdminServiceClient.reportPropertyUsage(organization);
   * }
   * }</pre>
   *
   * @param organization Required. Specifies the organization whose property usage will be listed.
   *     <p>Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportPropertyUsageResponse reportPropertyUsage(String organization) {
    ReportPropertyUsageRequest request =
        ReportPropertyUsageRequest.newBuilder().setOrganization(organization).build();
    return reportPropertyUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the usage and billing data for properties within the organization for the specified month.
   *
   * <p>Per direct client org, user needs to be OrgAdmin/BillingAdmin on the organization in order
   * to view the billing and usage data.
   *
   * <p>Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on the sales partner
   * org in order to view the billing and usage data, or OrgAdmin/BillingAdmin on the sales partner
   * client org in order to view the usage data only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ReportPropertyUsageRequest request =
   *       ReportPropertyUsageRequest.newBuilder()
   *           .setOrganization("organization1178922291")
   *           .setMonth("month104080000")
   *           .build();
   *   ReportPropertyUsageResponse response =
   *       marketingplatformAdminServiceClient.reportPropertyUsage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportPropertyUsageResponse reportPropertyUsage(ReportPropertyUsageRequest request) {
    return reportPropertyUsageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the usage and billing data for properties within the organization for the specified month.
   *
   * <p>Per direct client org, user needs to be OrgAdmin/BillingAdmin on the organization in order
   * to view the billing and usage data.
   *
   * <p>Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on the sales partner
   * org in order to view the billing and usage data, or OrgAdmin/BillingAdmin on the sales partner
   * client org in order to view the usage data only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ReportPropertyUsageRequest request =
   *       ReportPropertyUsageRequest.newBuilder()
   *           .setOrganization("organization1178922291")
   *           .setMonth("month104080000")
   *           .build();
   *   ApiFuture<ReportPropertyUsageResponse> future =
   *       marketingplatformAdminServiceClient.reportPropertyUsageCallable().futureCall(request);
   *   // Do something.
   *   ReportPropertyUsageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageCallable() {
    return stub.reportPropertyUsageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UserGroupName name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
   *   UserGroup response = marketingplatformAdminServiceClient.getUserGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the UserGroup to retrieve. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroup getUserGroup(@Nullable UserGroupName name) {
    GetUserGroupRequest request =
        GetUserGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUserGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString();
   *   UserGroup response = marketingplatformAdminServiceClient.getUserGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the UserGroup to retrieve. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroup getUserGroup(String name) {
    GetUserGroupRequest request = GetUserGroupRequest.newBuilder().setName(name).build();
    return getUserGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetUserGroupRequest request =
   *       GetUserGroupRequest.newBuilder()
   *           .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .build();
   *   UserGroup response = marketingplatformAdminServiceClient.getUserGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroup getUserGroup(GetUserGroupRequest request) {
    return getUserGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetUserGroupRequest request =
   *       GetUserGroupRequest.newBuilder()
   *           .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .build();
   *   ApiFuture<UserGroup> future =
   *       marketingplatformAdminServiceClient.getUserGroupCallable().futureCall(request);
   *   // Do something.
   *   UserGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserGroupRequest, UserGroup> getUserGroupCallable() {
    return stub.getUserGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of user groups in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (UserGroup element :
   *       marketingplatformAdminServiceClient.listUserGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent org where this UserGroup will be listed. Format:
   *     organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserGroupsPagedResponse listUserGroups(@Nullable OrganizationName parent) {
    ListUserGroupsRequest request =
        ListUserGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of user groups in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (UserGroup element :
   *       marketingplatformAdminServiceClient.listUserGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent org where this UserGroup will be listed. Format:
   *     organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserGroupsPagedResponse listUserGroups(String parent) {
    ListUserGroupsRequest request = ListUserGroupsRequest.newBuilder().setParent(parent).build();
    return listUserGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of user groups in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListUserGroupsRequest request =
   *       ListUserGroupsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UserGroup element :
   *       marketingplatformAdminServiceClient.listUserGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserGroupsPagedResponse listUserGroups(ListUserGroupsRequest request) {
    return listUserGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of user groups in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListUserGroupsRequest request =
   *       ListUserGroupsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UserGroup> future =
   *       marketingplatformAdminServiceClient.listUserGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UserGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUserGroupsRequest, ListUserGroupsPagedResponse>
      listUserGroupsPagedCallable() {
    return stub.listUserGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of user groups in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListUserGroupsRequest request =
   *       ListUserGroupsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUserGroupsResponse response =
   *         marketingplatformAdminServiceClient.listUserGroupsCallable().call(request);
   *     for (UserGroup element : response.getUserGroupsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUserGroupsRequest, ListUserGroupsResponse>
      listUserGroupsCallable() {
    return stub.listUserGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   UserGroup userGroup = UserGroup.newBuilder().build();
   *   UserGroup response = marketingplatformAdminServiceClient.createUserGroup(parent, userGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this UserGroup will be created. Format:
   *     organizations/{org_id}
   * @param userGroup Required. The user group to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroup createUserGroup(@Nullable OrganizationName parent, UserGroup userGroup) {
    CreateUserGroupRequest request =
        CreateUserGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUserGroup(userGroup)
            .build();
    return createUserGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   UserGroup userGroup = UserGroup.newBuilder().build();
   *   UserGroup response = marketingplatformAdminServiceClient.createUserGroup(parent, userGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this UserGroup will be created. Format:
   *     organizations/{org_id}
   * @param userGroup Required. The user group to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroup createUserGroup(String parent, UserGroup userGroup) {
    CreateUserGroupRequest request =
        CreateUserGroupRequest.newBuilder().setParent(parent).setUserGroup(userGroup).build();
    return createUserGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateUserGroupRequest request =
   *       CreateUserGroupRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setUserGroup(UserGroup.newBuilder().build())
   *           .build();
   *   UserGroup response = marketingplatformAdminServiceClient.createUserGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroup createUserGroup(CreateUserGroupRequest request) {
    return createUserGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateUserGroupRequest request =
   *       CreateUserGroupRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setUserGroup(UserGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<UserGroup> future =
   *       marketingplatformAdminServiceClient.createUserGroupCallable().futureCall(request);
   *   // Do something.
   *   UserGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUserGroupRequest, UserGroup> createUserGroupCallable() {
    return stub.createUserGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UserGroup userGroup = UserGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UserGroup response =
   *       marketingplatformAdminServiceClient.updateUserGroup(userGroup, updateMask);
   * }
   * }</pre>
   *
   * @param userGroup Required. The user group to update.
   * @param updateMask Required. The list of fields to update. Field names must be in snake case
   *     (for example, "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroup updateUserGroup(UserGroup userGroup, FieldMask updateMask) {
    UpdateUserGroupRequest request =
        UpdateUserGroupRequest.newBuilder()
            .setUserGroup(userGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateUserGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UpdateUserGroupRequest request =
   *       UpdateUserGroupRequest.newBuilder()
   *           .setUserGroup(UserGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   UserGroup response = marketingplatformAdminServiceClient.updateUserGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroup updateUserGroup(UpdateUserGroupRequest request) {
    return updateUserGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UpdateUserGroupRequest request =
   *       UpdateUserGroupRequest.newBuilder()
   *           .setUserGroup(UserGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<UserGroup> future =
   *       marketingplatformAdminServiceClient.updateUserGroupCallable().futureCall(request);
   *   // Do something.
   *   UserGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserGroupRequest, UserGroup> updateUserGroupCallable() {
    return stub.updateUserGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UserGroupName name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
   *   marketingplatformAdminServiceClient.deleteUserGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user group to delete. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserGroup(@Nullable UserGroupName name) {
    DeleteUserGroupRequest request =
        DeleteUserGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteUserGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString();
   *   marketingplatformAdminServiceClient.deleteUserGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user group to delete. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserGroup(String name) {
    DeleteUserGroupRequest request = DeleteUserGroupRequest.newBuilder().setName(name).build();
    deleteUserGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   DeleteUserGroupRequest request =
   *       DeleteUserGroupRequest.newBuilder()
   *           .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .build();
   *   marketingplatformAdminServiceClient.deleteUserGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserGroup(DeleteUserGroupRequest request) {
    deleteUserGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user group in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   DeleteUserGroupRequest request =
   *       DeleteUserGroupRequest.newBuilder()
   *           .setName(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       marketingplatformAdminServiceClient.deleteUserGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUserGroupRequest, Empty> deleteUserGroupCallable() {
    return stub.deleteUserGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single user group member.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UserGroupMemberName name =
   *       UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]");
   *   UserGroupMember response = marketingplatformAdminServiceClient.getUserGroupMember(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user group member to retrieve. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}/members/{member_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroupMember getUserGroupMember(@Nullable UserGroupMemberName name) {
    GetUserGroupMemberRequest request =
        GetUserGroupMemberRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getUserGroupMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single user group member.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name = UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString();
   *   UserGroupMember response = marketingplatformAdminServiceClient.getUserGroupMember(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user group member to retrieve. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}/members/{member_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroupMember getUserGroupMember(String name) {
    GetUserGroupMemberRequest request =
        GetUserGroupMemberRequest.newBuilder().setName(name).build();
    return getUserGroupMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single user group member.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetUserGroupMemberRequest request =
   *       GetUserGroupMemberRequest.newBuilder()
   *           .setName(
   *               UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
   *           .build();
   *   UserGroupMember response = marketingplatformAdminServiceClient.getUserGroupMember(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroupMember getUserGroupMember(GetUserGroupMemberRequest request) {
    return getUserGroupMemberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single user group member.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetUserGroupMemberRequest request =
   *       GetUserGroupMemberRequest.newBuilder()
   *           .setName(
   *               UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
   *           .build();
   *   ApiFuture<UserGroupMember> future =
   *       marketingplatformAdminServiceClient.getUserGroupMemberCallable().futureCall(request);
   *   // Do something.
   *   UserGroupMember response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserGroupMemberRequest, UserGroupMember>
      getUserGroupMemberCallable() {
    return stub.getUserGroupMemberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of members in the specified user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UserGroupName parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
   *   for (UserGroupMember element :
   *       marketingplatformAdminServiceClient.listUserGroupMembers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent user group where this UserGroupMember will be listed.
   *     Format: organizations/{org_id}/userGroups/{user_group_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserGroupMembersPagedResponse listUserGroupMembers(
      @Nullable UserGroupName parent) {
    ListUserGroupMembersRequest request =
        ListUserGroupMembersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserGroupMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of members in the specified user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString();
   *   for (UserGroupMember element :
   *       marketingplatformAdminServiceClient.listUserGroupMembers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent user group where this UserGroupMember will be listed.
   *     Format: organizations/{org_id}/userGroups/{user_group_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserGroupMembersPagedResponse listUserGroupMembers(String parent) {
    ListUserGroupMembersRequest request =
        ListUserGroupMembersRequest.newBuilder().setParent(parent).build();
    return listUserGroupMembers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of members in the specified user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListUserGroupMembersRequest request =
   *       ListUserGroupMembersRequest.newBuilder()
   *           .setParent(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UserGroupMember element :
   *       marketingplatformAdminServiceClient.listUserGroupMembers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserGroupMembersPagedResponse listUserGroupMembers(
      ListUserGroupMembersRequest request) {
    return listUserGroupMembersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of members in the specified user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListUserGroupMembersRequest request =
   *       ListUserGroupMembersRequest.newBuilder()
   *           .setParent(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UserGroupMember> future =
   *       marketingplatformAdminServiceClient
   *           .listUserGroupMembersPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (UserGroupMember element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersPagedResponse>
      listUserGroupMembersPagedCallable() {
    return stub.listUserGroupMembersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of members in the specified user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListUserGroupMembersRequest request =
   *       ListUserGroupMembersRequest.newBuilder()
   *           .setParent(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUserGroupMembersResponse response =
   *         marketingplatformAdminServiceClient.listUserGroupMembersCallable().call(request);
   *     for (UserGroupMember element : response.getUserGroupMembersList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersResponse>
      listUserGroupMembersCallable() {
    return stub.listUserGroupMembersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a member to the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UserGroupName parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]");
   *   UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();
   *   UserGroupMember response =
   *       marketingplatformAdminServiceClient.createUserGroupMember(parent, userGroupMember);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this UserGroupMember will be created. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}
   * @param userGroupMember Required. The user group member to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroupMember createUserGroupMember(
      @Nullable UserGroupName parent, UserGroupMember userGroupMember) {
    CreateUserGroupMemberRequest request =
        CreateUserGroupMemberRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUserGroupMember(userGroupMember)
            .build();
    return createUserGroupMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a member to the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString();
   *   UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();
   *   UserGroupMember response =
   *       marketingplatformAdminServiceClient.createUserGroupMember(parent, userGroupMember);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this UserGroupMember will be created. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}
   * @param userGroupMember Required. The user group member to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroupMember createUserGroupMember(
      String parent, UserGroupMember userGroupMember) {
    CreateUserGroupMemberRequest request =
        CreateUserGroupMemberRequest.newBuilder()
            .setParent(parent)
            .setUserGroupMember(userGroupMember)
            .build();
    return createUserGroupMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a member to the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateUserGroupMemberRequest request =
   *       CreateUserGroupMemberRequest.newBuilder()
   *           .setParent(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .setUserGroupMember(UserGroupMember.newBuilder().build())
   *           .build();
   *   UserGroupMember response = marketingplatformAdminServiceClient.createUserGroupMember(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroupMember createUserGroupMember(CreateUserGroupMemberRequest request) {
    return createUserGroupMemberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a member to the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateUserGroupMemberRequest request =
   *       CreateUserGroupMemberRequest.newBuilder()
   *           .setParent(UserGroupName.of("[ORGANIZATION]", "[USER_GROUP]").toString())
   *           .setUserGroupMember(UserGroupMember.newBuilder().build())
   *           .build();
   *   ApiFuture<UserGroupMember> future =
   *       marketingplatformAdminServiceClient.createUserGroupMemberCallable().futureCall(request);
   *   // Do something.
   *   UserGroupMember response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberCallable() {
    return stub.createUserGroupMemberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a member in the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UserGroupMember userGroupMember = UserGroupMember.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UserGroupMember response =
   *       marketingplatformAdminServiceClient.updateUserGroupMember(userGroupMember, updateMask);
   * }
   * }</pre>
   *
   * @param userGroupMember Required. The user group member to update.
   * @param updateMask Required. The list of fields to update. Field names must be in snake case
   *     (for example, "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroupMember updateUserGroupMember(
      UserGroupMember userGroupMember, FieldMask updateMask) {
    UpdateUserGroupMemberRequest request =
        UpdateUserGroupMemberRequest.newBuilder()
            .setUserGroupMember(userGroupMember)
            .setUpdateMask(updateMask)
            .build();
    return updateUserGroupMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a member in the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UpdateUserGroupMemberRequest request =
   *       UpdateUserGroupMemberRequest.newBuilder()
   *           .setUserGroupMember(UserGroupMember.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   UserGroupMember response = marketingplatformAdminServiceClient.updateUserGroupMember(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserGroupMember updateUserGroupMember(UpdateUserGroupMemberRequest request) {
    return updateUserGroupMemberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a member in the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UpdateUserGroupMemberRequest request =
   *       UpdateUserGroupMemberRequest.newBuilder()
   *           .setUserGroupMember(UserGroupMember.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<UserGroupMember> future =
   *       marketingplatformAdminServiceClient.updateUserGroupMemberCallable().futureCall(request);
   *   // Do something.
   *   UserGroupMember response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberCallable() {
    return stub.updateUserGroupMemberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a member in the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UserGroupMemberName name =
   *       UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]");
   *   marketingplatformAdminServiceClient.deleteUserGroupMember(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user group member to delete. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}/members/{member_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserGroupMember(@Nullable UserGroupMemberName name) {
    DeleteUserGroupMemberRequest request =
        DeleteUserGroupMemberRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteUserGroupMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a member in the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name = UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString();
   *   marketingplatformAdminServiceClient.deleteUserGroupMember(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user group member to delete. Format:
   *     organizations/{org_id}/userGroups/{user_group_id}/members/{member_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserGroupMember(String name) {
    DeleteUserGroupMemberRequest request =
        DeleteUserGroupMemberRequest.newBuilder().setName(name).build();
    deleteUserGroupMember(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a member in the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   DeleteUserGroupMemberRequest request =
   *       DeleteUserGroupMemberRequest.newBuilder()
   *           .setName(
   *               UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
   *           .build();
   *   marketingplatformAdminServiceClient.deleteUserGroupMember(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserGroupMember(DeleteUserGroupMemberRequest request) {
    deleteUserGroupMemberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a member in the specified GMP user group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   DeleteUserGroupMemberRequest request =
   *       DeleteUserGroupMemberRequest.newBuilder()
   *           .setName(
   *               UserGroupMemberName.of("[ORGANIZATION]", "[USER_GROUP]", "[MEMBER]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       marketingplatformAdminServiceClient.deleteUserGroupMemberCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUserGroupMemberRequest, Empty> deleteUserGroupMemberCallable() {
    return stub.deleteUserGroupMemberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single admin access binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   AdminAccessBindingName name =
   *       AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]");
   *   AdminAccessBinding response = marketingplatformAdminServiceClient.getAdminAccessBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AdminAccessBinding to retrieve. Format:
   *     organizations/{org_id}/adminAccessBindings/{admin_access_binding_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdminAccessBinding getAdminAccessBinding(@Nullable AdminAccessBindingName name) {
    GetAdminAccessBindingRequest request =
        GetAdminAccessBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAdminAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single admin access binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name =
   *       AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString();
   *   AdminAccessBinding response = marketingplatformAdminServiceClient.getAdminAccessBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AdminAccessBinding to retrieve. Format:
   *     organizations/{org_id}/adminAccessBindings/{admin_access_binding_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdminAccessBinding getAdminAccessBinding(String name) {
    GetAdminAccessBindingRequest request =
        GetAdminAccessBindingRequest.newBuilder().setName(name).build();
    return getAdminAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single admin access binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetAdminAccessBindingRequest request =
   *       GetAdminAccessBindingRequest.newBuilder()
   *           .setName(
   *               AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
   *           .build();
   *   AdminAccessBinding response =
   *       marketingplatformAdminServiceClient.getAdminAccessBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdminAccessBinding getAdminAccessBinding(GetAdminAccessBindingRequest request) {
    return getAdminAccessBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single admin access binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetAdminAccessBindingRequest request =
   *       GetAdminAccessBindingRequest.newBuilder()
   *           .setName(
   *               AdminAccessBindingName.of("[ORGANIZATION]", "[ADMIN_ACCESS_BINDING]").toString())
   *           .build();
   *   ApiFuture<AdminAccessBinding> future =
   *       marketingplatformAdminServiceClient.getAdminAccessBindingCallable().futureCall(request);
   *   // Do something.
   *   AdminAccessBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingCallable() {
    return stub.getAdminAccessBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of admin access bindings in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (AdminAccessBinding element :
   *       marketingplatformAdminServiceClient.listAdminAccessBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent organization, which owns this collection of Admin Access
   *     Bindings. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdminAccessBindingsPagedResponse listAdminAccessBindings(
      @Nullable OrganizationName parent) {
    ListAdminAccessBindingsRequest request =
        ListAdminAccessBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdminAccessBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of admin access bindings in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (AdminAccessBinding element :
   *       marketingplatformAdminServiceClient.listAdminAccessBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent organization, which owns this collection of Admin Access
   *     Bindings. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdminAccessBindingsPagedResponse listAdminAccessBindings(String parent) {
    ListAdminAccessBindingsRequest request =
        ListAdminAccessBindingsRequest.newBuilder().setParent(parent).build();
    return listAdminAccessBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of admin access bindings in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAdminAccessBindingsRequest request =
   *       ListAdminAccessBindingsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AdminAccessBinding element :
   *       marketingplatformAdminServiceClient.listAdminAccessBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdminAccessBindingsPagedResponse listAdminAccessBindings(
      ListAdminAccessBindingsRequest request) {
    return listAdminAccessBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of admin access bindings in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAdminAccessBindingsRequest request =
   *       ListAdminAccessBindingsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AdminAccessBinding> future =
   *       marketingplatformAdminServiceClient
   *           .listAdminAccessBindingsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AdminAccessBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsPagedResponse>
      listAdminAccessBindingsPagedCallable() {
    return stub.listAdminAccessBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of admin access bindings in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAdminAccessBindingsRequest request =
   *       ListAdminAccessBindingsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAdminAccessBindingsResponse response =
   *         marketingplatformAdminServiceClient.listAdminAccessBindingsCallable().call(request);
   *     for (AdminAccessBinding element : response.getAdminAccessBindingsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
      listAdminAccessBindingsCallable() {
    return stub.listAdminAccessBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an admin access binding in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();
   *   AdminAccessBinding response =
   *       marketingplatformAdminServiceClient.createAdminAccessBinding(parent, adminAccessBinding);
   * }
   * }</pre>
   *
   * @param parent Required. The parent organization, which owns this Admin Access Binding. Format:
   *     organizations/{org_id}
   * @param adminAccessBinding Required. The Admin Access Binding to create.
   *     <p>Only 'user_email' input is allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdminAccessBinding createAdminAccessBinding(
      @Nullable OrganizationName parent, AdminAccessBinding adminAccessBinding) {
    CreateAdminAccessBindingRequest request =
        CreateAdminAccessBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAdminAccessBinding(adminAccessBinding)
            .build();
    return createAdminAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an admin access binding in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();
   *   AdminAccessBinding response =
   *       marketingplatformAdminServiceClient.createAdminAccessBinding(parent, adminAccessBinding);
   * }
   * }</pre>
   *
   * @param parent Required. The parent organization, which owns this Admin Access Binding. Format:
   *     organizations/{org_id}
   * @param adminAccessBinding Required. The Admin Access Binding to create.
   *     <p>Only 'user_email' input is allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdminAccessBinding createAdminAccessBinding(
      String parent, AdminAccessBinding adminAccessBinding) {
    CreateAdminAccessBindingRequest request =
        CreateAdminAccessBindingRequest.newBuilder()
            .setParent(parent)
            .setAdminAccessBinding(adminAccessBinding)
            .build();
    return createAdminAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an admin access binding in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateAdminAccessBindingRequest request =
   *       CreateAdminAccessBindingRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setAdminAccessBinding(AdminAccessBinding.newBuilder().build())
   *           .build();
   *   AdminAccessBinding response =
   *       marketingplatformAdminServiceClient.createAdminAccessBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdminAccessBinding createAdminAccessBinding(
      CreateAdminAccessBindingRequest request) {
    return createAdminAccessBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an admin access binding in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateAdminAccessBindingRequest request =
   *       CreateAdminAccessBindingRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setAdminAccessBinding(AdminAccessBinding.newBuilder().build())
   *           .build();
   *   ApiFuture<AdminAccessBinding> future =
   *       marketingplatformAdminServiceClient
   *           .createAdminAccessBindingCallable()
   *           .futureCall(request);
   *   // Do something.
   *   AdminAccessBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingCallable() {
    return stub.createAdminAccessBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an admin access binding in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   AdminAccessBinding adminAccessBinding = AdminAccessBinding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AdminAccessBinding response =
   *       marketingplatformAdminServiceClient.updateAdminAccessBinding(
   *           adminAccessBinding, updateMask);
   * }
   * }</pre>
   *
   * @param adminAccessBinding Required. The AdminAccessBinding to update.
   * @param updateMask Required. The list of fields to update. Field names must be in snake case
   *     (for example, "field_to_update"). Omitted fields will not be updated. To replace the entire
   *     entity, use one path with the string "&#42;" to match all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdminAccessBinding updateAdminAccessBinding(
      AdminAccessBinding adminAccessBinding, FieldMask updateMask) {
    UpdateAdminAccessBindingRequest request =
        UpdateAdminAccessBindingRequest.newBuilder()
            .setAdminAccessBinding(adminAccessBinding)
            .setUpdateMask(updateMask)
            .build();
    return updateAdminAccessBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an admin access binding in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UpdateAdminAccessBindingRequest request =
   *       UpdateAdminAccessBindingRequest.newBuilder()
   *           .setAdminAccessBinding(AdminAccessBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AdminAccessBinding response =
   *       marketingplatformAdminServiceClient.updateAdminAccessBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdminAccessBinding updateAdminAccessBinding(
      UpdateAdminAccessBindingRequest request) {
    return updateAdminAccessBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an admin access binding in the specified GMP organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   UpdateAdminAccessBindingRequest request =
   *       UpdateAdminAccessBindingRequest.newBuilder()
   *           .setAdminAccessBinding(AdminAccessBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AdminAccessBinding> future =
   *       marketingplatformAdminServiceClient
   *           .updateAdminAccessBindingCallable()
   *           .futureCall(request);
   *   // Do something.
   *   AdminAccessBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingCallable() {
    return stub.updateAdminAccessBindingCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListOrganizationsPagedResponse
      extends AbstractPagedListResponse<
          ListOrganizationsRequest,
          ListOrganizationsResponse,
          Organization,
          ListOrganizationsPage,
          ListOrganizationsFixedSizeCollection> {

    public static ApiFuture<ListOrganizationsPagedResponse> createAsync(
        PageContext<ListOrganizationsRequest, ListOrganizationsResponse, Organization> context,
        ApiFuture<ListOrganizationsResponse> futureResponse) {
      ApiFuture<ListOrganizationsPage> futurePage =
          ListOrganizationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOrganizationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOrganizationsPagedResponse(ListOrganizationsPage page) {
      super(page, ListOrganizationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrganizationsPage
      extends AbstractPage<
          ListOrganizationsRequest,
          ListOrganizationsResponse,
          Organization,
          ListOrganizationsPage> {

    private ListOrganizationsPage(
        @Nullable PageContext<ListOrganizationsRequest, ListOrganizationsResponse, Organization>
            context,
        @Nullable ListOrganizationsResponse response) {
      super(context, response);
    }

    private static ListOrganizationsPage createEmptyPage() {
      return new ListOrganizationsPage(null, null);
    }

    @Override
    protected ListOrganizationsPage createPage(
        @Nullable PageContext<ListOrganizationsRequest, ListOrganizationsResponse, Organization>
            context,
        @Nullable ListOrganizationsResponse response) {
      return new ListOrganizationsPage(context, response);
    }

    @Override
    public ApiFuture<ListOrganizationsPage> createPageAsync(
        @Nullable PageContext<ListOrganizationsRequest, ListOrganizationsResponse, Organization>
            context,
        ApiFuture<ListOrganizationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrganizationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrganizationsRequest,
          ListOrganizationsResponse,
          Organization,
          ListOrganizationsPage,
          ListOrganizationsFixedSizeCollection> {

    private ListOrganizationsFixedSizeCollection(
        @Nullable List<ListOrganizationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrganizationsFixedSizeCollection createEmptyCollection() {
      return new ListOrganizationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrganizationsFixedSizeCollection createCollection(
        @Nullable List<ListOrganizationsPage> pages, int collectionSize) {
      return new ListOrganizationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnalyticsAccountLinksPagedResponse
      extends AbstractPagedListResponse<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          AnalyticsAccountLink,
          ListAnalyticsAccountLinksPage,
          ListAnalyticsAccountLinksFixedSizeCollection> {

    public static ApiFuture<ListAnalyticsAccountLinksPagedResponse> createAsync(
        PageContext<
                ListAnalyticsAccountLinksRequest,
                ListAnalyticsAccountLinksResponse,
                AnalyticsAccountLink>
            context,
        ApiFuture<ListAnalyticsAccountLinksResponse> futureResponse) {
      ApiFuture<ListAnalyticsAccountLinksPage> futurePage =
          ListAnalyticsAccountLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnalyticsAccountLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnalyticsAccountLinksPagedResponse(ListAnalyticsAccountLinksPage page) {
      super(page, ListAnalyticsAccountLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnalyticsAccountLinksPage
      extends AbstractPage<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          AnalyticsAccountLink,
          ListAnalyticsAccountLinksPage> {

    private ListAnalyticsAccountLinksPage(
        @Nullable
            PageContext<
                ListAnalyticsAccountLinksRequest,
                ListAnalyticsAccountLinksResponse,
                AnalyticsAccountLink>
            context,
        @Nullable ListAnalyticsAccountLinksResponse response) {
      super(context, response);
    }

    private static ListAnalyticsAccountLinksPage createEmptyPage() {
      return new ListAnalyticsAccountLinksPage(null, null);
    }

    @Override
    protected ListAnalyticsAccountLinksPage createPage(
        @Nullable
            PageContext<
                ListAnalyticsAccountLinksRequest,
                ListAnalyticsAccountLinksResponse,
                AnalyticsAccountLink>
            context,
        @Nullable ListAnalyticsAccountLinksResponse response) {
      return new ListAnalyticsAccountLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListAnalyticsAccountLinksPage> createPageAsync(
        @Nullable
            PageContext<
                ListAnalyticsAccountLinksRequest,
                ListAnalyticsAccountLinksResponse,
                AnalyticsAccountLink>
            context,
        ApiFuture<ListAnalyticsAccountLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnalyticsAccountLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          AnalyticsAccountLink,
          ListAnalyticsAccountLinksPage,
          ListAnalyticsAccountLinksFixedSizeCollection> {

    private ListAnalyticsAccountLinksFixedSizeCollection(
        @Nullable List<ListAnalyticsAccountLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnalyticsAccountLinksFixedSizeCollection createEmptyCollection() {
      return new ListAnalyticsAccountLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnalyticsAccountLinksFixedSizeCollection createCollection(
        @Nullable List<ListAnalyticsAccountLinksPage> pages, int collectionSize) {
      return new ListAnalyticsAccountLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUserGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListUserGroupsRequest,
          ListUserGroupsResponse,
          UserGroup,
          ListUserGroupsPage,
          ListUserGroupsFixedSizeCollection> {

    public static ApiFuture<ListUserGroupsPagedResponse> createAsync(
        PageContext<ListUserGroupsRequest, ListUserGroupsResponse, UserGroup> context,
        ApiFuture<ListUserGroupsResponse> futureResponse) {
      ApiFuture<ListUserGroupsPage> futurePage =
          ListUserGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUserGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUserGroupsPagedResponse(ListUserGroupsPage page) {
      super(page, ListUserGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserGroupsPage
      extends AbstractPage<
          ListUserGroupsRequest, ListUserGroupsResponse, UserGroup, ListUserGroupsPage> {

    private ListUserGroupsPage(
        @Nullable PageContext<ListUserGroupsRequest, ListUserGroupsResponse, UserGroup> context,
        @Nullable ListUserGroupsResponse response) {
      super(context, response);
    }

    private static ListUserGroupsPage createEmptyPage() {
      return new ListUserGroupsPage(null, null);
    }

    @Override
    protected ListUserGroupsPage createPage(
        @Nullable PageContext<ListUserGroupsRequest, ListUserGroupsResponse, UserGroup> context,
        @Nullable ListUserGroupsResponse response) {
      return new ListUserGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListUserGroupsPage> createPageAsync(
        @Nullable PageContext<ListUserGroupsRequest, ListUserGroupsResponse, UserGroup> context,
        ApiFuture<ListUserGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserGroupsRequest,
          ListUserGroupsResponse,
          UserGroup,
          ListUserGroupsPage,
          ListUserGroupsFixedSizeCollection> {

    private ListUserGroupsFixedSizeCollection(
        @Nullable List<ListUserGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserGroupsFixedSizeCollection createEmptyCollection() {
      return new ListUserGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserGroupsFixedSizeCollection createCollection(
        @Nullable List<ListUserGroupsPage> pages, int collectionSize) {
      return new ListUserGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUserGroupMembersPagedResponse
      extends AbstractPagedListResponse<
          ListUserGroupMembersRequest,
          ListUserGroupMembersResponse,
          UserGroupMember,
          ListUserGroupMembersPage,
          ListUserGroupMembersFixedSizeCollection> {

    public static ApiFuture<ListUserGroupMembersPagedResponse> createAsync(
        PageContext<ListUserGroupMembersRequest, ListUserGroupMembersResponse, UserGroupMember>
            context,
        ApiFuture<ListUserGroupMembersResponse> futureResponse) {
      ApiFuture<ListUserGroupMembersPage> futurePage =
          ListUserGroupMembersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUserGroupMembersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUserGroupMembersPagedResponse(ListUserGroupMembersPage page) {
      super(page, ListUserGroupMembersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserGroupMembersPage
      extends AbstractPage<
          ListUserGroupMembersRequest,
          ListUserGroupMembersResponse,
          UserGroupMember,
          ListUserGroupMembersPage> {

    private ListUserGroupMembersPage(
        @Nullable
            PageContext<ListUserGroupMembersRequest, ListUserGroupMembersResponse, UserGroupMember>
            context,
        @Nullable ListUserGroupMembersResponse response) {
      super(context, response);
    }

    private static ListUserGroupMembersPage createEmptyPage() {
      return new ListUserGroupMembersPage(null, null);
    }

    @Override
    protected ListUserGroupMembersPage createPage(
        @Nullable
            PageContext<ListUserGroupMembersRequest, ListUserGroupMembersResponse, UserGroupMember>
            context,
        @Nullable ListUserGroupMembersResponse response) {
      return new ListUserGroupMembersPage(context, response);
    }

    @Override
    public ApiFuture<ListUserGroupMembersPage> createPageAsync(
        @Nullable
            PageContext<ListUserGroupMembersRequest, ListUserGroupMembersResponse, UserGroupMember>
            context,
        ApiFuture<ListUserGroupMembersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserGroupMembersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserGroupMembersRequest,
          ListUserGroupMembersResponse,
          UserGroupMember,
          ListUserGroupMembersPage,
          ListUserGroupMembersFixedSizeCollection> {

    private ListUserGroupMembersFixedSizeCollection(
        @Nullable List<ListUserGroupMembersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserGroupMembersFixedSizeCollection createEmptyCollection() {
      return new ListUserGroupMembersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserGroupMembersFixedSizeCollection createCollection(
        @Nullable List<ListUserGroupMembersPage> pages, int collectionSize) {
      return new ListUserGroupMembersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAdminAccessBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListAdminAccessBindingsRequest,
          ListAdminAccessBindingsResponse,
          AdminAccessBinding,
          ListAdminAccessBindingsPage,
          ListAdminAccessBindingsFixedSizeCollection> {

    public static ApiFuture<ListAdminAccessBindingsPagedResponse> createAsync(
        PageContext<
                ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse, AdminAccessBinding>
            context,
        ApiFuture<ListAdminAccessBindingsResponse> futureResponse) {
      ApiFuture<ListAdminAccessBindingsPage> futurePage =
          ListAdminAccessBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdminAccessBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdminAccessBindingsPagedResponse(ListAdminAccessBindingsPage page) {
      super(page, ListAdminAccessBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdminAccessBindingsPage
      extends AbstractPage<
          ListAdminAccessBindingsRequest,
          ListAdminAccessBindingsResponse,
          AdminAccessBinding,
          ListAdminAccessBindingsPage> {

    private ListAdminAccessBindingsPage(
        @Nullable
            PageContext<
                ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse, AdminAccessBinding>
            context,
        @Nullable ListAdminAccessBindingsResponse response) {
      super(context, response);
    }

    private static ListAdminAccessBindingsPage createEmptyPage() {
      return new ListAdminAccessBindingsPage(null, null);
    }

    @Override
    protected ListAdminAccessBindingsPage createPage(
        @Nullable
            PageContext<
                ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse, AdminAccessBinding>
            context,
        @Nullable ListAdminAccessBindingsResponse response) {
      return new ListAdminAccessBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListAdminAccessBindingsPage> createPageAsync(
        @Nullable
            PageContext<
                ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse, AdminAccessBinding>
            context,
        ApiFuture<ListAdminAccessBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdminAccessBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdminAccessBindingsRequest,
          ListAdminAccessBindingsResponse,
          AdminAccessBinding,
          ListAdminAccessBindingsPage,
          ListAdminAccessBindingsFixedSizeCollection> {

    private ListAdminAccessBindingsFixedSizeCollection(
        @Nullable List<ListAdminAccessBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdminAccessBindingsFixedSizeCollection createEmptyCollection() {
      return new ListAdminAccessBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdminAccessBindingsFixedSizeCollection createCollection(
        @Nullable List<ListAdminAccessBindingsPage> pages, int collectionSize) {
      return new ListAdminAccessBindingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
