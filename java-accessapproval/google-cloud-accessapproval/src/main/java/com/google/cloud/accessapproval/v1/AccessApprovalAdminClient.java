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

package com.google.cloud.accessapproval.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.accessapproval.v1.stub.AccessApprovalStub;
import com.google.cloud.accessapproval.v1.stub.AccessApprovalStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This API allows a customer to manage accesses to cloud resources by Google
 * personnel. It defines the following resource model:
 *
 * <p>- The API has a collection of
 * [ApprovalRequest][google.cloud.accessapproval.v1.ApprovalRequest] resources, named
 * `approvalRequests/{approval_request_id}` - The API has top-level settings per
 * Project/Folder/Organization, named `accessApprovalSettings`
 *
 * <p>The service also periodically emails a list of recipients, defined at the
 * Project/Folder/Organization level in the accessApprovalSettings, when there is a pending
 * ApprovalRequest for them to act on. The ApprovalRequests can also optionally be published to a
 * Cloud Pub/Sub topic owned by the customer (for Beta, the Pub/Sub setup is managed manually).
 *
 * <p>ApprovalRequests can be approved or dismissed. Google personel can only access the indicated
 * resource or resources if the request is approved (subject to some exclusions:
 * https://cloud.google.com/access-approval/docs/overview#exclusions).
 *
 * <p>Note: Using Access Approval functionality will mean that Google may not be able to meet the
 * SLAs for your chosen products, as any support response times may be dramatically increased. As
 * such the SLAs do not apply to any service disruption to the extent impacted by Customer's use of
 * Access Approval. Do not enable Access Approval for projects where you may require high service
 * availability and rapid response by Google Cloud Support.
 *
 * <p>After a request is approved or dismissed, no further action may be taken on it. Requests with
 * the requested_expiration in the past or with no activity for 14 days are considered dismissed.
 * When an approval expires, the request is considered dismissed.
 *
 * <p>If a request is not approved or dismissed, we call it pending.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the AccessApprovalAdminClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of AccessApprovalAdminSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * AccessApprovalAdminSettings accessApprovalAdminSettings =
 *     AccessApprovalAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccessApprovalAdminClient accessApprovalAdminClient =
 *     AccessApprovalAdminClient.create(accessApprovalAdminSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * AccessApprovalAdminSettings accessApprovalAdminSettings =
 *     AccessApprovalAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccessApprovalAdminClient accessApprovalAdminClient =
 *     AccessApprovalAdminClient.create(accessApprovalAdminSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class AccessApprovalAdminClient implements BackgroundResource {
  private final AccessApprovalAdminSettings settings;
  private final AccessApprovalStub stub;

  /** Constructs an instance of AccessApprovalAdminClient with default settings. */
  public static final AccessApprovalAdminClient create() throws IOException {
    return create(AccessApprovalAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccessApprovalAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AccessApprovalAdminClient create(AccessApprovalAdminSettings settings)
      throws IOException {
    return new AccessApprovalAdminClient(settings);
  }

  /**
   * Constructs an instance of AccessApprovalAdminClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AccessApprovalAdminSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AccessApprovalAdminClient create(AccessApprovalStub stub) {
    return new AccessApprovalAdminClient(stub);
  }

  /**
   * Constructs an instance of AccessApprovalAdminClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AccessApprovalAdminClient(AccessApprovalAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AccessApprovalStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AccessApprovalAdminClient(AccessApprovalStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccessApprovalAdminSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AccessApprovalStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists approval requests associated with a project, folder, or organization. Approval requests
   * can be filtered by state (pending, active, dismissed). The order is reverse chronological.
   *
   * @param parent The parent resource. This may be "projects/{project_id}", "folders/{folder_id}",
   *     or "organizations/{organization_id}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApprovalRequestsPagedResponse listApprovalRequests(String parent) {
    ListApprovalRequestsMessage request =
        ListApprovalRequestsMessage.newBuilder().setParent(parent).build();
    return listApprovalRequests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists approval requests associated with a project, folder, or organization. Approval requests
   * can be filtered by state (pending, active, dismissed). The order is reverse chronological.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApprovalRequestsPagedResponse listApprovalRequests(
      ListApprovalRequestsMessage request) {
    return listApprovalRequestsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists approval requests associated with a project, folder, or organization. Approval requests
   * can be filtered by state (pending, active, dismissed). The order is reverse chronological.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsPagedResponse>
      listApprovalRequestsPagedCallable() {
    return stub.listApprovalRequestsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists approval requests associated with a project, folder, or organization. Approval requests
   * can be filtered by state (pending, active, dismissed). The order is reverse chronological.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsResponse>
      listApprovalRequestsCallable() {
    return stub.listApprovalRequestsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an approval request. Returns NOT_FOUND if the request does not exist.
   *
   * @param name Name of the approval request to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApprovalRequest getApprovalRequest(String name) {
    GetApprovalRequestMessage request =
        GetApprovalRequestMessage.newBuilder().setName(name).build();
    return getApprovalRequest(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an approval request. Returns NOT_FOUND if the request does not exist.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApprovalRequest getApprovalRequest(GetApprovalRequestMessage request) {
    return getApprovalRequestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an approval request. Returns NOT_FOUND if the request does not exist.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetApprovalRequestMessage, ApprovalRequest>
      getApprovalRequestCallable() {
    return stub.getApprovalRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a request and returns the updated ApprovalRequest.
   *
   * <p>Returns NOT_FOUND if the request does not exist. Returns FAILED_PRECONDITION if the request
   * exists but is not in a pending state.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApprovalRequest approveApprovalRequest(ApproveApprovalRequestMessage request) {
    return approveApprovalRequestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a request and returns the updated ApprovalRequest.
   *
   * <p>Returns NOT_FOUND if the request does not exist. Returns FAILED_PRECONDITION if the request
   * exists but is not in a pending state.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestCallable() {
    return stub.approveApprovalRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Dismisses a request. Returns the updated ApprovalRequest.
   *
   * <p>NOTE: This does not deny access to the resource if another request has been made and
   * approved. It is equivalent in effect to ignoring the request altogether.
   *
   * <p>Returns NOT_FOUND if the request does not exist.
   *
   * <p>Returns FAILED_PRECONDITION if the request exists but is not in a pending state.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApprovalRequest dismissApprovalRequest(DismissApprovalRequestMessage request) {
    return dismissApprovalRequestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Dismisses a request. Returns the updated ApprovalRequest.
   *
   * <p>NOTE: This does not deny access to the resource if another request has been made and
   * approved. It is equivalent in effect to ignoring the request altogether.
   *
   * <p>Returns NOT_FOUND if the request does not exist.
   *
   * <p>Returns FAILED_PRECONDITION if the request exists but is not in a pending state.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestCallable() {
    return stub.dismissApprovalRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the settings associated with a project, folder, or organization.
   *
   * @param name Name of the AccessApprovalSettings to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessApprovalSettings getAccessApprovalSettings(String name) {
    GetAccessApprovalSettingsMessage request =
        GetAccessApprovalSettingsMessage.newBuilder().setName(name).build();
    return getAccessApprovalSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the settings associated with a project, folder, or organization.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessApprovalSettings getAccessApprovalSettings(
      GetAccessApprovalSettingsMessage request) {
    return getAccessApprovalSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the settings associated with a project, folder, or organization.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsCallable() {
    return stub.getAccessApprovalSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings associated with a project, folder, or organization. Settings to update are
   * determined by the value of field_mask.
   *
   * @param settings The new AccessApprovalSettings.
   * @param update_mask The update mask applies to the settings. Only the top level fields of
   *     AccessApprovalSettings (notification_emails &amp; enrolled_services) are supported. For
   *     each field, if it is included, the currently stored value will be entirely overwritten with
   *     the value of the field passed in this request.
   *     <p>For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If
   *     this field is left unset, only the notification_emails field will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessApprovalSettings updateAccessApprovalSettings(
      AccessApprovalSettings settings, FieldMask updateMask) {
    UpdateAccessApprovalSettingsMessage request =
        UpdateAccessApprovalSettingsMessage.newBuilder()
            .setSettings(settings)
            .setUpdateMask(updateMask)
            .build();
    return updateAccessApprovalSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings associated with a project, folder, or organization. Settings to update are
   * determined by the value of field_mask.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessApprovalSettings updateAccessApprovalSettings(
      UpdateAccessApprovalSettingsMessage request) {
    return updateAccessApprovalSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings associated with a project, folder, or organization. Settings to update are
   * determined by the value of field_mask.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsCallable() {
    return stub.updateAccessApprovalSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the settings associated with a project, folder, or organization. This will have the
   * effect of disabling Access Approval for the project, folder, or organization, but only if all
   * ancestors also have Access Approval disabled. If Access Approval is enabled at a higher level
   * of the hierarchy, then Access Approval will still be enabled at this level as the settings are
   * inherited.
   *
   * @param name Name of the AccessApprovalSettings to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccessApprovalSettings(String name) {
    DeleteAccessApprovalSettingsMessage request =
        DeleteAccessApprovalSettingsMessage.newBuilder().setName(name).build();
    deleteAccessApprovalSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the settings associated with a project, folder, or organization. This will have the
   * effect of disabling Access Approval for the project, folder, or organization, but only if all
   * ancestors also have Access Approval disabled. If Access Approval is enabled at a higher level
   * of the hierarchy, then Access Approval will still be enabled at this level as the settings are
   * inherited.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccessApprovalSettings(DeleteAccessApprovalSettingsMessage request) {
    deleteAccessApprovalSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the settings associated with a project, folder, or organization. This will have the
   * effect of disabling Access Approval for the project, folder, or organization, but only if all
   * ancestors also have Access Approval disabled. If Access Approval is enabled at a higher level
   * of the hierarchy, then Access Approval will still be enabled at this level as the settings are
   * inherited.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsCallable() {
    return stub.deleteAccessApprovalSettingsCallable();
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

  public static class ListApprovalRequestsPagedResponse
      extends AbstractPagedListResponse<
          ListApprovalRequestsMessage,
          ListApprovalRequestsResponse,
          ApprovalRequest,
          ListApprovalRequestsPage,
          ListApprovalRequestsFixedSizeCollection> {

    public static ApiFuture<ListApprovalRequestsPagedResponse> createAsync(
        PageContext<ListApprovalRequestsMessage, ListApprovalRequestsResponse, ApprovalRequest>
            context,
        ApiFuture<ListApprovalRequestsResponse> futureResponse) {
      ApiFuture<ListApprovalRequestsPage> futurePage =
          ListApprovalRequestsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListApprovalRequestsPage, ListApprovalRequestsPagedResponse>() {
            @Override
            public ListApprovalRequestsPagedResponse apply(ListApprovalRequestsPage input) {
              return new ListApprovalRequestsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListApprovalRequestsPagedResponse(ListApprovalRequestsPage page) {
      super(page, ListApprovalRequestsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApprovalRequestsPage
      extends AbstractPage<
          ListApprovalRequestsMessage,
          ListApprovalRequestsResponse,
          ApprovalRequest,
          ListApprovalRequestsPage> {

    private ListApprovalRequestsPage(
        PageContext<ListApprovalRequestsMessage, ListApprovalRequestsResponse, ApprovalRequest>
            context,
        ListApprovalRequestsResponse response) {
      super(context, response);
    }

    private static ListApprovalRequestsPage createEmptyPage() {
      return new ListApprovalRequestsPage(null, null);
    }

    @Override
    protected ListApprovalRequestsPage createPage(
        PageContext<ListApprovalRequestsMessage, ListApprovalRequestsResponse, ApprovalRequest>
            context,
        ListApprovalRequestsResponse response) {
      return new ListApprovalRequestsPage(context, response);
    }

    @Override
    public ApiFuture<ListApprovalRequestsPage> createPageAsync(
        PageContext<ListApprovalRequestsMessage, ListApprovalRequestsResponse, ApprovalRequest>
            context,
        ApiFuture<ListApprovalRequestsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApprovalRequestsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApprovalRequestsMessage,
          ListApprovalRequestsResponse,
          ApprovalRequest,
          ListApprovalRequestsPage,
          ListApprovalRequestsFixedSizeCollection> {

    private ListApprovalRequestsFixedSizeCollection(
        List<ListApprovalRequestsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApprovalRequestsFixedSizeCollection createEmptyCollection() {
      return new ListApprovalRequestsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApprovalRequestsFixedSizeCollection createCollection(
        List<ListApprovalRequestsPage> pages, int collectionSize) {
      return new ListApprovalRequestsFixedSizeCollection(pages, collectionSize);
    }
  }
}
