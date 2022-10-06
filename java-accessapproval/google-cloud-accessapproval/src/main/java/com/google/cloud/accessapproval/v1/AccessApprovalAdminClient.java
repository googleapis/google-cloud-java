/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
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
 * `approvalRequests/{approval_request}` - The API has top-level settings per
 * Project/Folder/Organization, named `accessApprovalSettings`
 *
 * <p>The service also periodically emails a list of recipients, defined at the
 * Project/Folder/Organization level in the accessApprovalSettings, when there is a pending
 * ApprovalRequest for them to act on. The ApprovalRequests can also optionally be published to a
 * Pub/Sub topic owned by the customer (contact support if you would like to enable Pub/Sub
 * notifications).
 *
 * <p>ApprovalRequests can be approved or dismissed. Google personnel can only access the indicated
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
 *   ApprovalRequestName name =
 *       ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]");
 *   ApprovalRequest response = accessApprovalAdminClient.getApprovalRequest(name);
 * }
 * }</pre>
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessApprovalAdminSettings accessApprovalAdminSettings =
 *     AccessApprovalAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccessApprovalAdminClient accessApprovalAdminClient =
 *     AccessApprovalAdminClient.create(accessApprovalAdminSettings);
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
 * AccessApprovalAdminSettings accessApprovalAdminSettings =
 *     AccessApprovalAdminSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             AccessApprovalAdminSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * AccessApprovalAdminClient accessApprovalAdminClient =
 *     AccessApprovalAdminClient.create(accessApprovalAdminSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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

  protected AccessApprovalAdminClient(AccessApprovalStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccessApprovalAdminSettings getSettings() {
    return settings;
  }

  public AccessApprovalStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists approval requests associated with a project, folder, or organization. Approval requests
   * can be filtered by state (pending, active, dismissed). The order is reverse chronological.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (ApprovalRequest element :
   *       accessApprovalAdminClient.listApprovalRequests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The parent resource. This may be "projects/{project}", "folders/{folder}", or
   *     "organizations/{organization}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApprovalRequestsPagedResponse listApprovalRequests(FolderName parent) {
    ListApprovalRequestsMessage request =
        ListApprovalRequestsMessage.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApprovalRequests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists approval requests associated with a project, folder, or organization. Approval requests
   * can be filtered by state (pending, active, dismissed). The order is reverse chronological.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (ApprovalRequest element :
   *       accessApprovalAdminClient.listApprovalRequests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The parent resource. This may be "projects/{project}", "folders/{folder}", or
   *     "organizations/{organization}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApprovalRequestsPagedResponse listApprovalRequests(OrganizationName parent) {
    ListApprovalRequestsMessage request =
        ListApprovalRequestsMessage.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApprovalRequests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists approval requests associated with a project, folder, or organization. Approval requests
   * can be filtered by state (pending, active, dismissed). The order is reverse chronological.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (ApprovalRequest element :
   *       accessApprovalAdminClient.listApprovalRequests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The parent resource. This may be "projects/{project}", "folders/{folder}", or
   *     "organizations/{organization}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApprovalRequestsPagedResponse listApprovalRequests(ProjectName parent) {
    ListApprovalRequestsMessage request =
        ListApprovalRequestsMessage.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApprovalRequests(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists approval requests associated with a project, folder, or organization. Approval requests
   * can be filtered by state (pending, active, dismissed). The order is reverse chronological.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (ApprovalRequest element :
   *       accessApprovalAdminClient.listApprovalRequests(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The parent resource. This may be "projects/{project}", "folders/{folder}", or
   *     "organizations/{organization}".
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   ListApprovalRequestsMessage request =
   *       ListApprovalRequestsMessage.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ApprovalRequest element :
   *       accessApprovalAdminClient.listApprovalRequests(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   ListApprovalRequestsMessage request =
   *       ListApprovalRequestsMessage.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ApprovalRequest> future =
   *       accessApprovalAdminClient.listApprovalRequestsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApprovalRequest element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   ListApprovalRequestsMessage request =
   *       ListApprovalRequestsMessage.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListApprovalRequestsResponse response =
   *         accessApprovalAdminClient.listApprovalRequestsCallable().call(request);
   *     for (ApprovalRequest element : response.getApprovalRequestsList()) {
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
  public final UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsResponse>
      listApprovalRequestsCallable() {
    return stub.listApprovalRequestsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an approval request. Returns NOT_FOUND if the request does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   ApprovalRequestName name =
   *       ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]");
   *   ApprovalRequest response = accessApprovalAdminClient.getApprovalRequest(name);
   * }
   * }</pre>
   *
   * @param name The name of the approval request to retrieve. Format:
   *     "{projects|folders|organizations}/{id}/approvalRequests/{approval_request}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApprovalRequest getApprovalRequest(ApprovalRequestName name) {
    GetApprovalRequestMessage request =
        GetApprovalRequestMessage.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getApprovalRequest(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an approval request. Returns NOT_FOUND if the request does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   String name =
   *       ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
   *           .toString();
   *   ApprovalRequest response = accessApprovalAdminClient.getApprovalRequest(name);
   * }
   * }</pre>
   *
   * @param name The name of the approval request to retrieve. Format:
   *     "{projects|folders|organizations}/{id}/approvalRequests/{approval_request}"
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   GetApprovalRequestMessage request =
   *       GetApprovalRequestMessage.newBuilder()
   *           .setName(
   *               ApprovalRequestName.ofProjectApprovalRequestName(
   *                       "[PROJECT]", "[APPROVAL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApprovalRequest response = accessApprovalAdminClient.getApprovalRequest(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   GetApprovalRequestMessage request =
   *       GetApprovalRequestMessage.newBuilder()
   *           .setName(
   *               ApprovalRequestName.ofProjectApprovalRequestName(
   *                       "[PROJECT]", "[APPROVAL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApprovalRequest> future =
   *       accessApprovalAdminClient.getApprovalRequestCallable().futureCall(request);
   *   // Do something.
   *   ApprovalRequest response = future.get();
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   ApproveApprovalRequestMessage request =
   *       ApproveApprovalRequestMessage.newBuilder()
   *           .setName(
   *               ApprovalRequestName.ofProjectApprovalRequestName(
   *                       "[PROJECT]", "[APPROVAL_REQUEST]")
   *                   .toString())
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApprovalRequest response = accessApprovalAdminClient.approveApprovalRequest(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   ApproveApprovalRequestMessage request =
   *       ApproveApprovalRequestMessage.newBuilder()
   *           .setName(
   *               ApprovalRequestName.ofProjectApprovalRequestName(
   *                       "[PROJECT]", "[APPROVAL_REQUEST]")
   *                   .toString())
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<ApprovalRequest> future =
   *       accessApprovalAdminClient.approveApprovalRequestCallable().futureCall(request);
   *   // Do something.
   *   ApprovalRequest response = future.get();
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   DismissApprovalRequestMessage request =
   *       DismissApprovalRequestMessage.newBuilder()
   *           .setName(
   *               ApprovalRequestName.ofProjectApprovalRequestName(
   *                       "[PROJECT]", "[APPROVAL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApprovalRequest response = accessApprovalAdminClient.dismissApprovalRequest(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   DismissApprovalRequestMessage request =
   *       DismissApprovalRequestMessage.newBuilder()
   *           .setName(
   *               ApprovalRequestName.ofProjectApprovalRequestName(
   *                       "[PROJECT]", "[APPROVAL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApprovalRequest> future =
   *       accessApprovalAdminClient.dismissApprovalRequestCallable().futureCall(request);
   *   // Do something.
   *   ApprovalRequest response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestCallable() {
    return stub.dismissApprovalRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Invalidates an existing ApprovalRequest. Returns the updated ApprovalRequest.
   *
   * <p>NOTE: This does not deny access to the resource if another request has been made and
   * approved. It only invalidates a single approval.
   *
   * <p>Returns FAILED_PRECONDITION if the request exists but is not in an approved state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   InvalidateApprovalRequestMessage request =
   *       InvalidateApprovalRequestMessage.newBuilder()
   *           .setName(
   *               ApprovalRequestName.ofProjectApprovalRequestName(
   *                       "[PROJECT]", "[APPROVAL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApprovalRequest response = accessApprovalAdminClient.invalidateApprovalRequest(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApprovalRequest invalidateApprovalRequest(InvalidateApprovalRequestMessage request) {
    return invalidateApprovalRequestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Invalidates an existing ApprovalRequest. Returns the updated ApprovalRequest.
   *
   * <p>NOTE: This does not deny access to the resource if another request has been made and
   * approved. It only invalidates a single approval.
   *
   * <p>Returns FAILED_PRECONDITION if the request exists but is not in an approved state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   InvalidateApprovalRequestMessage request =
   *       InvalidateApprovalRequestMessage.newBuilder()
   *           .setName(
   *               ApprovalRequestName.ofProjectApprovalRequestName(
   *                       "[PROJECT]", "[APPROVAL_REQUEST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApprovalRequest> future =
   *       accessApprovalAdminClient.invalidateApprovalRequestCallable().futureCall(request);
   *   // Do something.
   *   ApprovalRequest response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InvalidateApprovalRequestMessage, ApprovalRequest>
      invalidateApprovalRequestCallable() {
    return stub.invalidateApprovalRequestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the settings associated with a project, folder, or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");
   *   AccessApprovalSettings response = accessApprovalAdminClient.getAccessApprovalSettings(name);
   * }
   * }</pre>
   *
   * @param name The name of the AccessApprovalSettings to retrieve. Format:
   *     "{projects|folders|organizations}/{id}/accessApprovalSettings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessApprovalSettings getAccessApprovalSettings(AccessApprovalSettingsName name) {
    GetAccessApprovalSettingsMessage request =
        GetAccessApprovalSettingsMessage.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAccessApprovalSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the settings associated with a project, folder, or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   String name = AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString();
   *   AccessApprovalSettings response = accessApprovalAdminClient.getAccessApprovalSettings(name);
   * }
   * }</pre>
   *
   * @param name The name of the AccessApprovalSettings to retrieve. Format:
   *     "{projects|folders|organizations}/{id}/accessApprovalSettings"
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   GetAccessApprovalSettingsMessage request =
   *       GetAccessApprovalSettingsMessage.newBuilder()
   *           .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   AccessApprovalSettings response =
   *       accessApprovalAdminClient.getAccessApprovalSettings(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   GetAccessApprovalSettingsMessage request =
   *       GetAccessApprovalSettingsMessage.newBuilder()
   *           .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<AccessApprovalSettings> future =
   *       accessApprovalAdminClient.getAccessApprovalSettingsCallable().futureCall(request);
   *   // Do something.
   *   AccessApprovalSettings response = future.get();
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   AccessApprovalSettings settings = AccessApprovalSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AccessApprovalSettings response =
   *       accessApprovalAdminClient.updateAccessApprovalSettings(settings, updateMask);
   * }
   * }</pre>
   *
   * @param settings The new AccessApprovalSettings.
   * @param updateMask The update mask applies to the settings. Only the top level fields of
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   UpdateAccessApprovalSettingsMessage request =
   *       UpdateAccessApprovalSettingsMessage.newBuilder()
   *           .setSettings(AccessApprovalSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AccessApprovalSettings response =
   *       accessApprovalAdminClient.updateAccessApprovalSettings(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   UpdateAccessApprovalSettingsMessage request =
   *       UpdateAccessApprovalSettingsMessage.newBuilder()
   *           .setSettings(AccessApprovalSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AccessApprovalSettings> future =
   *       accessApprovalAdminClient.updateAccessApprovalSettingsCallable().futureCall(request);
   *   // Do something.
   *   AccessApprovalSettings response = future.get();
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");
   *   accessApprovalAdminClient.deleteAccessApprovalSettings(name);
   * }
   * }</pre>
   *
   * @param name Name of the AccessApprovalSettings to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccessApprovalSettings(AccessApprovalSettingsName name) {
    DeleteAccessApprovalSettingsMessage request =
        DeleteAccessApprovalSettingsMessage.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   String name = AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString();
   *   accessApprovalAdminClient.deleteAccessApprovalSettings(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   DeleteAccessApprovalSettingsMessage request =
   *       DeleteAccessApprovalSettingsMessage.newBuilder()
   *           .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   accessApprovalAdminClient.deleteAccessApprovalSettings(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   DeleteAccessApprovalSettingsMessage request =
   *       DeleteAccessApprovalSettingsMessage.newBuilder()
   *           .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       accessApprovalAdminClient.deleteAccessApprovalSettingsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsCallable() {
    return stub.deleteAccessApprovalSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the service account that is used by Access Approval to access KMS keys for signing
   * approved approval requests.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   String name = "name3373707";
   *   AccessApprovalServiceAccount response =
   *       accessApprovalAdminClient.getAccessApprovalServiceAccount(name);
   * }
   * }</pre>
   *
   * @param name Name of the AccessApprovalServiceAccount to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessApprovalServiceAccount getAccessApprovalServiceAccount(String name) {
    GetAccessApprovalServiceAccountMessage request =
        GetAccessApprovalServiceAccountMessage.newBuilder().setName(name).build();
    return getAccessApprovalServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the service account that is used by Access Approval to access KMS keys for signing
   * approved approval requests.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   GetAccessApprovalServiceAccountMessage request =
   *       GetAccessApprovalServiceAccountMessage.newBuilder().setName("name3373707").build();
   *   AccessApprovalServiceAccount response =
   *       accessApprovalAdminClient.getAccessApprovalServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessApprovalServiceAccount getAccessApprovalServiceAccount(
      GetAccessApprovalServiceAccountMessage request) {
    return getAccessApprovalServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the service account that is used by Access Approval to access KMS keys for signing
   * approved approval requests.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
   *   GetAccessApprovalServiceAccountMessage request =
   *       GetAccessApprovalServiceAccountMessage.newBuilder().setName("name3373707").build();
   *   ApiFuture<AccessApprovalServiceAccount> future =
   *       accessApprovalAdminClient.getAccessApprovalServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   AccessApprovalServiceAccount response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
      getAccessApprovalServiceAccountCallable() {
    return stub.getAccessApprovalServiceAccountCallable();
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
          input -> new ListApprovalRequestsPagedResponse(input),
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
