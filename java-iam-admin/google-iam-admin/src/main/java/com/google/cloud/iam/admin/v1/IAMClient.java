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

package com.google.cloud.iam.admin.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.iam.admin.v1.stub.IAMStub;
import com.google.cloud.iam.admin.v1.stub.IAMStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.admin.v1.CreateRoleRequest;
import com.google.iam.admin.v1.CreateServiceAccountKeyRequest;
import com.google.iam.admin.v1.CreateServiceAccountRequest;
import com.google.iam.admin.v1.DeleteRoleRequest;
import com.google.iam.admin.v1.DeleteServiceAccountKeyRequest;
import com.google.iam.admin.v1.DeleteServiceAccountRequest;
import com.google.iam.admin.v1.DisableServiceAccountRequest;
import com.google.iam.admin.v1.EnableServiceAccountRequest;
import com.google.iam.admin.v1.GetRoleRequest;
import com.google.iam.admin.v1.GetServiceAccountKeyRequest;
import com.google.iam.admin.v1.GetServiceAccountRequest;
import com.google.iam.admin.v1.KeyName;
import com.google.iam.admin.v1.LintPolicyRequest;
import com.google.iam.admin.v1.LintPolicyResponse;
import com.google.iam.admin.v1.ListRolesRequest;
import com.google.iam.admin.v1.ListRolesResponse;
import com.google.iam.admin.v1.ListServiceAccountKeysRequest;
import com.google.iam.admin.v1.ListServiceAccountKeysResponse;
import com.google.iam.admin.v1.ListServiceAccountsRequest;
import com.google.iam.admin.v1.ListServiceAccountsResponse;
import com.google.iam.admin.v1.PatchServiceAccountRequest;
import com.google.iam.admin.v1.Permission;
import com.google.iam.admin.v1.ProjectName;
import com.google.iam.admin.v1.QueryAuditableServicesRequest;
import com.google.iam.admin.v1.QueryAuditableServicesResponse;
import com.google.iam.admin.v1.QueryGrantableRolesRequest;
import com.google.iam.admin.v1.QueryGrantableRolesResponse;
import com.google.iam.admin.v1.QueryTestablePermissionsRequest;
import com.google.iam.admin.v1.QueryTestablePermissionsResponse;
import com.google.iam.admin.v1.Role;
import com.google.iam.admin.v1.ServiceAccount;
import com.google.iam.admin.v1.ServiceAccountKey;
import com.google.iam.admin.v1.ServiceAccountKeyAlgorithm;
import com.google.iam.admin.v1.ServiceAccountName;
import com.google.iam.admin.v1.ServiceAccountPrivateKeyType;
import com.google.iam.admin.v1.ServiceAccountPublicKeyType;
import com.google.iam.admin.v1.SignBlobRequest;
import com.google.iam.admin.v1.SignBlobResponse;
import com.google.iam.admin.v1.SignJwtRequest;
import com.google.iam.admin.v1.SignJwtResponse;
import com.google.iam.admin.v1.UndeleteRoleRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountResponse;
import com.google.iam.admin.v1.UpdateRoleRequest;
import com.google.iam.admin.v1.UploadServiceAccountKeyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Creates and manages Identity and Access Management (IAM) resources.
 *
 * <p>You can use this service to work with all of the following resources:
 *
 * <ul>
 *   <li>&#42;&#42;Service accounts&#42;&#42;, which identify an application or a virtual machine
 *       (VM) instance rather than a person
 *   <li>&#42;&#42;Service account keys&#42;&#42;, which service accounts use to authenticate with
 *       Google APIs
 *   <li>&#42;&#42;IAM policies for service accounts&#42;&#42;, which specify the roles that a
 *       member has for the service account
 *   <li>&#42;&#42;IAM custom roles&#42;&#42;, which help you limit the number of permissions that
 *       you grant to members
 * </ul>
 *
 * <p>In addition, you can use this service to complete the following tasks, among others:
 *
 * <ul>
 *   <li>Test whether a service account can use specific permissions
 *   <li>Check which roles you can grant for a specific resource
 *   <li>Lint, or validate, condition expressions in an IAM policy
 * </ul>
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
 * try (IAMClient iAMClient = IAMClient.create()) {
 *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
 *   ServiceAccount response = iAMClient.getServiceAccount(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IAMClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of IAMSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IAMSettings iAMSettings =
 *     IAMSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IAMClient iAMClient = IAMClient.create(iAMSettings);
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
 * IAMSettings iAMSettings = IAMSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IAMClient iAMClient = IAMClient.create(iAMSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IAMClient implements BackgroundResource {
  private final IAMSettings settings;
  private final IAMStub stub;

  /** Constructs an instance of IAMClient with default settings. */
  public static final IAMClient create() throws IOException {
    return create(IAMSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IAMClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IAMClient create(IAMSettings settings) throws IOException {
    return new IAMClient(settings);
  }

  /**
   * Constructs an instance of IAMClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(IAMSettings).
   */
  public static final IAMClient create(IAMStub stub) {
    return new IAMClient(stub);
  }

  /**
   * Constructs an instance of IAMClient, using the given settings. This is protected so that it is
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected IAMClient(IAMSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IAMStubSettings) settings.getStubSettings()).createStub();
  }

  protected IAMClient(IAMStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IAMSettings getSettings() {
    return settings;
  }

  public IAMStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   for (ServiceAccount element : iAMClient.listServiceAccounts(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the project associated with the service accounts,
   *     such as `projects/my-project-123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceAccountsPagedResponse listServiceAccounts(ProjectName name) {
    ListServiceAccountsRequest request =
        ListServiceAccountsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listServiceAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   for (ServiceAccount element : iAMClient.listServiceAccounts(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the project associated with the service accounts,
   *     such as `projects/my-project-123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceAccountsPagedResponse listServiceAccounts(String name) {
    ListServiceAccountsRequest request =
        ListServiceAccountsRequest.newBuilder().setName(name).build();
    return listServiceAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ListServiceAccountsRequest request =
   *       ListServiceAccountsRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ServiceAccount element : iAMClient.listServiceAccounts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceAccountsPagedResponse listServiceAccounts(
      ListServiceAccountsRequest request) {
    return listServiceAccountsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ListServiceAccountsRequest request =
   *       ListServiceAccountsRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ServiceAccount> future =
   *       iAMClient.listServiceAccountsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ServiceAccount element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsPagedResponse>
      listServiceAccountsPagedCallable() {
    return stub.listServiceAccountsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ListServiceAccountsRequest request =
   *       ListServiceAccountsRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListServiceAccountsResponse response =
   *         iAMClient.listServiceAccountsCallable().call(request);
   *     for (ServiceAccount element : response.getAccountsList()) {
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
  public final UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsResponse>
      listServiceAccountsCallable() {
    return stub.listServiceAccountsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   ServiceAccount response = iAMClient.getServiceAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(ServiceAccountName name) {
    GetServiceAccountRequest request =
        GetServiceAccountRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   ServiceAccount response = iAMClient.getServiceAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(String name) {
    GetServiceAccountRequest request = GetServiceAccountRequest.newBuilder().setName(name).build();
    return getServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   GetServiceAccountRequest request =
   *       GetServiceAccountRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .build();
   *   ServiceAccount response = iAMClient.getServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(GetServiceAccountRequest request) {
    return getServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   GetServiceAccountRequest request =
   *       GetServiceAccountRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<ServiceAccount> future = iAMClient.getServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   ServiceAccount response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable() {
    return stub.getServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   String accountId = "accountId-1827029976";
   *   ServiceAccount serviceAccount = ServiceAccount.newBuilder().build();
   *   ServiceAccount response = iAMClient.createServiceAccount(name, accountId, serviceAccount);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the project associated with the service accounts,
   *     such as `projects/my-project-123`.
   * @param accountId Required. The account id that is used to generate the service account email
   *     address and a stable unique id. It is unique within a project, must be 6-30 characters
   *     long, and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])` to comply with
   *     RFC1035.
   * @param serviceAccount The [ServiceAccount][google.iam.admin.v1.ServiceAccount] resource to
   *     create. Currently, only the following values are user assignable: `display_name` and
   *     `description`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount createServiceAccount(
      ProjectName name, String accountId, ServiceAccount serviceAccount) {
    CreateServiceAccountRequest request =
        CreateServiceAccountRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setAccountId(accountId)
            .setServiceAccount(serviceAccount)
            .build();
    return createServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   String accountId = "accountId-1827029976";
   *   ServiceAccount serviceAccount = ServiceAccount.newBuilder().build();
   *   ServiceAccount response = iAMClient.createServiceAccount(name, accountId, serviceAccount);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the project associated with the service accounts,
   *     such as `projects/my-project-123`.
   * @param accountId Required. The account id that is used to generate the service account email
   *     address and a stable unique id. It is unique within a project, must be 6-30 characters
   *     long, and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])` to comply with
   *     RFC1035.
   * @param serviceAccount The [ServiceAccount][google.iam.admin.v1.ServiceAccount] resource to
   *     create. Currently, only the following values are user assignable: `display_name` and
   *     `description`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount createServiceAccount(
      String name, String accountId, ServiceAccount serviceAccount) {
    CreateServiceAccountRequest request =
        CreateServiceAccountRequest.newBuilder()
            .setName(name)
            .setAccountId(accountId)
            .setServiceAccount(serviceAccount)
            .build();
    return createServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   CreateServiceAccountRequest request =
   *       CreateServiceAccountRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setAccountId("accountId-1827029976")
   *           .setServiceAccount(ServiceAccount.newBuilder().build())
   *           .build();
   *   ServiceAccount response = iAMClient.createServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount createServiceAccount(CreateServiceAccountRequest request) {
    return createServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   CreateServiceAccountRequest request =
   *       CreateServiceAccountRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setAccountId("accountId-1827029976")
   *           .setServiceAccount(ServiceAccount.newBuilder().build())
   *           .build();
   *   ApiFuture<ServiceAccount> future =
   *       iAMClient.createServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   ServiceAccount response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceAccountRequest, ServiceAccount>
      createServiceAccountCallable() {
    return stub.createServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; We are in the process of deprecating this method. Use
   * [PatchServiceAccount][google.iam.admin.v1.IAM.PatchServiceAccount] instead.
   *
   * <p>Updates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>You can update only the `display_name` and `description` fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ServiceAccount request =
   *       ServiceAccount.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setProjectId("projectId-894832108")
   *           .setUniqueId("uniqueId-294460212")
   *           .setEmail("email96619420")
   *           .setDisplayName("displayName1714148973")
   *           .setEtag(ByteString.EMPTY)
   *           .setDescription("description-1724546052")
   *           .setOauth2ClientId("oauth2ClientId-1210797087")
   *           .setDisabled(true)
   *           .build();
   *   ServiceAccount response = iAMClient.updateServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount updateServiceAccount(ServiceAccount request) {
    return updateServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; We are in the process of deprecating this method. Use
   * [PatchServiceAccount][google.iam.admin.v1.IAM.PatchServiceAccount] instead.
   *
   * <p>Updates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>You can update only the `display_name` and `description` fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ServiceAccount request =
   *       ServiceAccount.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setProjectId("projectId-894832108")
   *           .setUniqueId("uniqueId-294460212")
   *           .setEmail("email96619420")
   *           .setDisplayName("displayName1714148973")
   *           .setEtag(ByteString.EMPTY)
   *           .setDescription("description-1724546052")
   *           .setOauth2ClientId("oauth2ClientId-1210797087")
   *           .setDisabled(true)
   *           .build();
   *   ApiFuture<ServiceAccount> future =
   *       iAMClient.updateServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   ServiceAccount response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ServiceAccount, ServiceAccount> updateServiceAccountCallable() {
    return stub.updateServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   PatchServiceAccountRequest request =
   *       PatchServiceAccountRequest.newBuilder()
   *           .setServiceAccount(ServiceAccount.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ServiceAccount response = iAMClient.patchServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount patchServiceAccount(PatchServiceAccountRequest request) {
    return patchServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   PatchServiceAccountRequest request =
   *       PatchServiceAccountRequest.newBuilder()
   *           .setServiceAccount(ServiceAccount.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ServiceAccount> future =
   *       iAMClient.patchServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   ServiceAccount response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchServiceAccountRequest, ServiceAccount>
      patchServiceAccountCallable() {
    return stub.patchServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>&#42;&#42;Warning:&#42;&#42; After you delete a service account, you might not be able to
   * undelete it. If you know that you need to re-enable the service account in the future, use
   * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] instead.
   *
   * <p>If you delete a service account, IAM permanently removes the service account 30 days later.
   * Google Cloud cannot recover the service account after it is permanently removed, even if you
   * file a support request.
   *
   * <p>To help avoid unplanned outages, we recommend that you disable the service account before
   * you delete it. Use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] to
   * disable the service account, then wait at least 24 hours and watch for unintended consequences.
   * If there are no unintended consequences, you can delete the service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   iAMClient.deleteServiceAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServiceAccount(ServiceAccountName name) {
    DeleteServiceAccountRequest request =
        DeleteServiceAccountRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>&#42;&#42;Warning:&#42;&#42; After you delete a service account, you might not be able to
   * undelete it. If you know that you need to re-enable the service account in the future, use
   * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] instead.
   *
   * <p>If you delete a service account, IAM permanently removes the service account 30 days later.
   * Google Cloud cannot recover the service account after it is permanently removed, even if you
   * file a support request.
   *
   * <p>To help avoid unplanned outages, we recommend that you disable the service account before
   * you delete it. Use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] to
   * disable the service account, then wait at least 24 hours and watch for unintended consequences.
   * If there are no unintended consequences, you can delete the service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   iAMClient.deleteServiceAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServiceAccount(String name) {
    DeleteServiceAccountRequest request =
        DeleteServiceAccountRequest.newBuilder().setName(name).build();
    deleteServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>&#42;&#42;Warning:&#42;&#42; After you delete a service account, you might not be able to
   * undelete it. If you know that you need to re-enable the service account in the future, use
   * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] instead.
   *
   * <p>If you delete a service account, IAM permanently removes the service account 30 days later.
   * Google Cloud cannot recover the service account after it is permanently removed, even if you
   * file a support request.
   *
   * <p>To help avoid unplanned outages, we recommend that you disable the service account before
   * you delete it. Use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] to
   * disable the service account, then wait at least 24 hours and watch for unintended consequences.
   * If there are no unintended consequences, you can delete the service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   DeleteServiceAccountRequest request =
   *       DeleteServiceAccountRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .build();
   *   iAMClient.deleteServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServiceAccount(DeleteServiceAccountRequest request) {
    deleteServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>&#42;&#42;Warning:&#42;&#42; After you delete a service account, you might not be able to
   * undelete it. If you know that you need to re-enable the service account in the future, use
   * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] instead.
   *
   * <p>If you delete a service account, IAM permanently removes the service account 30 days later.
   * Google Cloud cannot recover the service account after it is permanently removed, even if you
   * file a support request.
   *
   * <p>To help avoid unplanned outages, we recommend that you disable the service account before
   * you delete it. Use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] to
   * disable the service account, then wait at least 24 hours and watch for unintended consequences.
   * If there are no unintended consequences, you can delete the service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   DeleteServiceAccountRequest request =
   *       DeleteServiceAccountRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<Empty> future = iAMClient.deleteServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceAccountRequest, Empty> deleteServiceAccountCallable() {
    return stub.deleteServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a deleted [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>&#42;&#42;Important:&#42;&#42; It is not always possible to restore a deleted service
   * account. Use this method only as a last resort.
   *
   * <p>After you delete a service account, IAM permanently removes the service account 30 days
   * later. There is no way to restore a deleted service account that has been permanently removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   UndeleteServiceAccountRequest request =
   *       UndeleteServiceAccountRequest.newBuilder().setName("name3373707").build();
   *   UndeleteServiceAccountResponse response = iAMClient.undeleteServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UndeleteServiceAccountResponse undeleteServiceAccount(
      UndeleteServiceAccountRequest request) {
    return undeleteServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a deleted [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>&#42;&#42;Important:&#42;&#42; It is not always possible to restore a deleted service
   * account. Use this method only as a last resort.
   *
   * <p>After you delete a service account, IAM permanently removes the service account 30 days
   * later. There is no way to restore a deleted service account that has been permanently removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   UndeleteServiceAccountRequest request =
   *       UndeleteServiceAccountRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<UndeleteServiceAccountResponse> future =
   *       iAMClient.undeleteServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   UndeleteServiceAccountResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
      undeleteServiceAccountCallable() {
    return stub.undeleteServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] that was disabled by
   * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount].
   *
   * <p>If the service account is already enabled, then this method has no effect.
   *
   * <p>If the service account was disabled by other means—for example, if Google disabled the
   * service account because it was compromised—you cannot use this method to enable the service
   * account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   EnableServiceAccountRequest request =
   *       EnableServiceAccountRequest.newBuilder().setName("name3373707").build();
   *   iAMClient.enableServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void enableServiceAccount(EnableServiceAccountRequest request) {
    enableServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] that was disabled by
   * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount].
   *
   * <p>If the service account is already enabled, then this method has no effect.
   *
   * <p>If the service account was disabled by other means—for example, if Google disabled the
   * service account because it was compromised—you cannot use this method to enable the service
   * account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   EnableServiceAccountRequest request =
   *       EnableServiceAccountRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future = iAMClient.enableServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableServiceAccountRequest, Empty> enableServiceAccountCallable() {
    return stub.enableServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] immediately.
   *
   * <p>If an application uses the service account to authenticate, that application can no longer
   * call Google APIs or access Google Cloud resources. Existing access tokens for the service
   * account are rejected, and requests for new access tokens will fail.
   *
   * <p>To re-enable the service account, use
   * [EnableServiceAccount][google.iam.admin.v1.IAM.EnableServiceAccount]. After you re-enable the
   * service account, its existing access tokens will be accepted, and you can request new access
   * tokens.
   *
   * <p>To help avoid unplanned outages, we recommend that you disable the service account before
   * you delete it. Use this method to disable the service account, then wait at least 24 hours and
   * watch for unintended consequences. If there are no unintended consequences, you can delete the
   * service account with [DeleteServiceAccount][google.iam.admin.v1.IAM.DeleteServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   DisableServiceAccountRequest request =
   *       DisableServiceAccountRequest.newBuilder().setName("name3373707").build();
   *   iAMClient.disableServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void disableServiceAccount(DisableServiceAccountRequest request) {
    disableServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] immediately.
   *
   * <p>If an application uses the service account to authenticate, that application can no longer
   * call Google APIs or access Google Cloud resources. Existing access tokens for the service
   * account are rejected, and requests for new access tokens will fail.
   *
   * <p>To re-enable the service account, use
   * [EnableServiceAccount][google.iam.admin.v1.IAM.EnableServiceAccount]. After you re-enable the
   * service account, its existing access tokens will be accepted, and you can request new access
   * tokens.
   *
   * <p>To help avoid unplanned outages, we recommend that you disable the service account before
   * you delete it. Use this method to disable the service account, then wait at least 24 hours and
   * watch for unintended consequences. If there are no unintended consequences, you can delete the
   * service account with [DeleteServiceAccount][google.iam.admin.v1.IAM.DeleteServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   DisableServiceAccountRequest request =
   *       DisableServiceAccountRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future = iAMClient.disableServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableServiceAccountRequest, Empty> disableServiceAccountCallable() {
    return stub.disableServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey] for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   List<ListServiceAccountKeysRequest.KeyType> keyTypes = new ArrayList<>();
   *   ListServiceAccountKeysResponse response = iAMClient.listServiceAccountKeys(name, keyTypes);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`.
   *     <p>Using `-` as a wildcard for the `PROJECT_ID`, will infer the project from the account.
   *     The `ACCOUNT` value can be the `email` address or the `unique_id` of the service account.
   * @param keyTypes Filters the types of keys the user wants to include in the list response.
   *     Duplicate key types are not allowed. If no key type is provided, all keys are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceAccountKeysResponse listServiceAccountKeys(
      ServiceAccountName name, List<ListServiceAccountKeysRequest.KeyType> keyTypes) {
    ListServiceAccountKeysRequest request =
        ListServiceAccountKeysRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllKeyTypes(keyTypes)
            .build();
    return listServiceAccountKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey] for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   List<ListServiceAccountKeysRequest.KeyType> keyTypes = new ArrayList<>();
   *   ListServiceAccountKeysResponse response = iAMClient.listServiceAccountKeys(name, keyTypes);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`.
   *     <p>Using `-` as a wildcard for the `PROJECT_ID`, will infer the project from the account.
   *     The `ACCOUNT` value can be the `email` address or the `unique_id` of the service account.
   * @param keyTypes Filters the types of keys the user wants to include in the list response.
   *     Duplicate key types are not allowed. If no key type is provided, all keys are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceAccountKeysResponse listServiceAccountKeys(
      String name, List<ListServiceAccountKeysRequest.KeyType> keyTypes) {
    ListServiceAccountKeysRequest request =
        ListServiceAccountKeysRequest.newBuilder().setName(name).addAllKeyTypes(keyTypes).build();
    return listServiceAccountKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey] for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ListServiceAccountKeysRequest request =
   *       ListServiceAccountKeysRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllKeyTypes(new ArrayList<ListServiceAccountKeysRequest.KeyType>())
   *           .build();
   *   ListServiceAccountKeysResponse response = iAMClient.listServiceAccountKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceAccountKeysResponse listServiceAccountKeys(
      ListServiceAccountKeysRequest request) {
    return listServiceAccountKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey] for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ListServiceAccountKeysRequest request =
   *       ListServiceAccountKeysRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllKeyTypes(new ArrayList<ListServiceAccountKeysRequest.KeyType>())
   *           .build();
   *   ApiFuture<ListServiceAccountKeysResponse> future =
   *       iAMClient.listServiceAccountKeysCallable().futureCall(request);
   *   // Do something.
   *   ListServiceAccountKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
      listServiceAccountKeysCallable() {
    return stub.listServiceAccountKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");
   *   ServiceAccountPublicKeyType publicKeyType = ServiceAccountPublicKeyType.forNumber(0);
   *   ServiceAccountKey response = iAMClient.getServiceAccountKey(name, publicKeyType);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account key in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}/keys/{key}`.
   *     <p>Using `-` as a wildcard for the `PROJECT_ID` will infer the project from the account.
   *     The `ACCOUNT` value can be the `email` address or the `unique_id` of the service account.
   * @param publicKeyType The output format of the public key requested. X509_PEM is the default
   *     output format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccountKey getServiceAccountKey(
      KeyName name, ServiceAccountPublicKeyType publicKeyType) {
    GetServiceAccountKeyRequest request =
        GetServiceAccountKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPublicKeyType(publicKeyType)
            .build();
    return getServiceAccountKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString();
   *   ServiceAccountPublicKeyType publicKeyType = ServiceAccountPublicKeyType.forNumber(0);
   *   ServiceAccountKey response = iAMClient.getServiceAccountKey(name, publicKeyType);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account key in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}/keys/{key}`.
   *     <p>Using `-` as a wildcard for the `PROJECT_ID` will infer the project from the account.
   *     The `ACCOUNT` value can be the `email` address or the `unique_id` of the service account.
   * @param publicKeyType The output format of the public key requested. X509_PEM is the default
   *     output format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccountKey getServiceAccountKey(
      String name, ServiceAccountPublicKeyType publicKeyType) {
    GetServiceAccountKeyRequest request =
        GetServiceAccountKeyRequest.newBuilder()
            .setName(name)
            .setPublicKeyType(publicKeyType)
            .build();
    return getServiceAccountKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   GetServiceAccountKeyRequest request =
   *       GetServiceAccountKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
   *           .setPublicKeyType(ServiceAccountPublicKeyType.forNumber(0))
   *           .build();
   *   ServiceAccountKey response = iAMClient.getServiceAccountKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccountKey getServiceAccountKey(GetServiceAccountKeyRequest request) {
    return getServiceAccountKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   GetServiceAccountKeyRequest request =
   *       GetServiceAccountKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
   *           .setPublicKeyType(ServiceAccountPublicKeyType.forNumber(0))
   *           .build();
   *   ApiFuture<ServiceAccountKey> future =
   *       iAMClient.getServiceAccountKeyCallable().futureCall(request);
   *   // Do something.
   *   ServiceAccountKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceAccountKeyRequest, ServiceAccountKey>
      getServiceAccountKeyCallable() {
    return stub.getServiceAccountKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   ServiceAccountPrivateKeyType privateKeyType = ServiceAccountPrivateKeyType.forNumber(0);
   *   ServiceAccountKeyAlgorithm keyAlgorithm = ServiceAccountKeyAlgorithm.forNumber(0);
   *   ServiceAccountKey response =
   *       iAMClient.createServiceAccountKey(name, privateKeyType, keyAlgorithm);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @param privateKeyType The output format of the private key. The default value is
   *     `TYPE_GOOGLE_CREDENTIALS_FILE`, which is the Google Credentials File format.
   * @param keyAlgorithm Which type of key and algorithm to use for the key. The default is
   *     currently a 2K RSA key. However this may change in the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccountKey createServiceAccountKey(
      ServiceAccountName name,
      ServiceAccountPrivateKeyType privateKeyType,
      ServiceAccountKeyAlgorithm keyAlgorithm) {
    CreateServiceAccountKeyRequest request =
        CreateServiceAccountKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPrivateKeyType(privateKeyType)
            .setKeyAlgorithm(keyAlgorithm)
            .build();
    return createServiceAccountKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   ServiceAccountPrivateKeyType privateKeyType = ServiceAccountPrivateKeyType.forNumber(0);
   *   ServiceAccountKeyAlgorithm keyAlgorithm = ServiceAccountKeyAlgorithm.forNumber(0);
   *   ServiceAccountKey response =
   *       iAMClient.createServiceAccountKey(name, privateKeyType, keyAlgorithm);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @param privateKeyType The output format of the private key. The default value is
   *     `TYPE_GOOGLE_CREDENTIALS_FILE`, which is the Google Credentials File format.
   * @param keyAlgorithm Which type of key and algorithm to use for the key. The default is
   *     currently a 2K RSA key. However this may change in the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccountKey createServiceAccountKey(
      String name,
      ServiceAccountPrivateKeyType privateKeyType,
      ServiceAccountKeyAlgorithm keyAlgorithm) {
    CreateServiceAccountKeyRequest request =
        CreateServiceAccountKeyRequest.newBuilder()
            .setName(name)
            .setPrivateKeyType(privateKeyType)
            .setKeyAlgorithm(keyAlgorithm)
            .build();
    return createServiceAccountKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   CreateServiceAccountKeyRequest request =
   *       CreateServiceAccountKeyRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setPrivateKeyType(ServiceAccountPrivateKeyType.forNumber(0))
   *           .setKeyAlgorithm(ServiceAccountKeyAlgorithm.forNumber(0))
   *           .build();
   *   ServiceAccountKey response = iAMClient.createServiceAccountKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccountKey createServiceAccountKey(CreateServiceAccountKeyRequest request) {
    return createServiceAccountKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   CreateServiceAccountKeyRequest request =
   *       CreateServiceAccountKeyRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setPrivateKeyType(ServiceAccountPrivateKeyType.forNumber(0))
   *           .setKeyAlgorithm(ServiceAccountKeyAlgorithm.forNumber(0))
   *           .build();
   *   ApiFuture<ServiceAccountKey> future =
   *       iAMClient.createServiceAccountKeyCallable().futureCall(request);
   *   // Do something.
   *   ServiceAccountKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceAccountKeyRequest, ServiceAccountKey>
      createServiceAccountKeyCallable() {
    return stub.createServiceAccountKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey], using a public key that
   * you provide.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   UploadServiceAccountKeyRequest request =
   *       UploadServiceAccountKeyRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPublicKeyData(ByteString.EMPTY)
   *           .build();
   *   ServiceAccountKey response = iAMClient.uploadServiceAccountKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccountKey uploadServiceAccountKey(UploadServiceAccountKeyRequest request) {
    return uploadServiceAccountKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey], using a public key that
   * you provide.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   UploadServiceAccountKeyRequest request =
   *       UploadServiceAccountKeyRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPublicKeyData(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<ServiceAccountKey> future =
   *       iAMClient.uploadServiceAccountKeyCallable().futureCall(request);
   *   // Do something.
   *   ServiceAccountKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadServiceAccountKeyRequest, ServiceAccountKey>
      uploadServiceAccountKeyCallable() {
    return stub.uploadServiceAccountKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. Deleting a service
   * account key does not revoke short-lived credentials that have been issued based on the service
   * account key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");
   *   iAMClient.deleteServiceAccountKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account key in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}/keys/{key}`. Using `-` as a wildcard for
   *     the `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServiceAccountKey(KeyName name) {
    DeleteServiceAccountKeyRequest request =
        DeleteServiceAccountKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteServiceAccountKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. Deleting a service
   * account key does not revoke short-lived credentials that have been issued based on the service
   * account key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString();
   *   iAMClient.deleteServiceAccountKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account key in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}/keys/{key}`. Using `-` as a wildcard for
   *     the `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServiceAccountKey(String name) {
    DeleteServiceAccountKeyRequest request =
        DeleteServiceAccountKeyRequest.newBuilder().setName(name).build();
    deleteServiceAccountKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. Deleting a service
   * account key does not revoke short-lived credentials that have been issued based on the service
   * account key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   DeleteServiceAccountKeyRequest request =
   *       DeleteServiceAccountKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
   *           .build();
   *   iAMClient.deleteServiceAccountKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServiceAccountKey(DeleteServiceAccountKeyRequest request) {
    deleteServiceAccountKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. Deleting a service
   * account key does not revoke short-lived credentials that have been issued based on the service
   * account key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   DeleteServiceAccountKeyRequest request =
   *       DeleteServiceAccountKeyRequest.newBuilder()
   *           .setName(KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]").toString())
   *           .build();
   *   ApiFuture<Empty> future = iAMClient.deleteServiceAccountKeyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceAccountKeyRequest, Empty>
      deleteServiceAccountKeyCallable() {
    return stub.deleteServiceAccountKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; This method is deprecated. Use the
   * [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob)
   * method in the IAM Service Account Credentials API instead. If you currently use this method,
   * see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
   * instructions.
   *
   * <p>Signs a blob using the system-managed private key for a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   ByteString bytesToSign = ByteString.EMPTY;
   *   SignBlobResponse response = iAMClient.signBlob(name, bytesToSign);
   * }
   * }</pre>
   *
   * @param name Required. Deprecated. [Migrate to Service Account Credentials
   *     API](https://cloud.google.com/iam/help/credentials/migrate-api).
   *     <p>The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @param bytesToSign Required. Deprecated. [Migrate to Service Account Credentials
   *     API](https://cloud.google.com/iam/help/credentials/migrate-api).
   *     <p>The bytes to sign.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SignBlobResponse signBlob(ServiceAccountName name, ByteString bytesToSign) {
    SignBlobRequest request =
        SignBlobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setBytesToSign(bytesToSign)
            .build();
    return signBlob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; This method is deprecated. Use the
   * [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob)
   * method in the IAM Service Account Credentials API instead. If you currently use this method,
   * see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
   * instructions.
   *
   * <p>Signs a blob using the system-managed private key for a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   ByteString bytesToSign = ByteString.EMPTY;
   *   SignBlobResponse response = iAMClient.signBlob(name, bytesToSign);
   * }
   * }</pre>
   *
   * @param name Required. Deprecated. [Migrate to Service Account Credentials
   *     API](https://cloud.google.com/iam/help/credentials/migrate-api).
   *     <p>The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @param bytesToSign Required. Deprecated. [Migrate to Service Account Credentials
   *     API](https://cloud.google.com/iam/help/credentials/migrate-api).
   *     <p>The bytes to sign.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SignBlobResponse signBlob(String name, ByteString bytesToSign) {
    SignBlobRequest request =
        SignBlobRequest.newBuilder().setName(name).setBytesToSign(bytesToSign).build();
    return signBlob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; This method is deprecated. Use the
   * [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob)
   * method in the IAM Service Account Credentials API instead. If you currently use this method,
   * see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
   * instructions.
   *
   * <p>Signs a blob using the system-managed private key for a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   SignBlobRequest request =
   *       SignBlobRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setBytesToSign(ByteString.EMPTY)
   *           .build();
   *   SignBlobResponse response = iAMClient.signBlob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SignBlobResponse signBlob(SignBlobRequest request) {
    return signBlobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; This method is deprecated. Use the
   * [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob)
   * method in the IAM Service Account Credentials API instead. If you currently use this method,
   * see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
   * instructions.
   *
   * <p>Signs a blob using the system-managed private key for a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   SignBlobRequest request =
   *       SignBlobRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setBytesToSign(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<SignBlobResponse> future = iAMClient.signBlobCallable().futureCall(request);
   *   // Do something.
   *   SignBlobResponse response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SignBlobRequest, SignBlobResponse> signBlobCallable() {
    return stub.signBlobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; This method is deprecated. Use the
   * [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt)
   * method in the IAM Service Account Credentials API instead. If you currently use this method,
   * see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
   * instructions.
   *
   * <p>Signs a JSON Web Token (JWT) using the system-managed private key for a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   String payload = "payload-786701938";
   *   SignJwtResponse response = iAMClient.signJwt(name, payload);
   * }
   * }</pre>
   *
   * @param name Required. Deprecated. [Migrate to Service Account Credentials
   *     API](https://cloud.google.com/iam/help/credentials/migrate-api).
   *     <p>The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @param payload Required. Deprecated. [Migrate to Service Account Credentials
   *     API](https://cloud.google.com/iam/help/credentials/migrate-api).
   *     <p>The JWT payload to sign. Must be a serialized JSON object that contains a JWT Claims
   *     Set. For example: `{"sub": "user{@literal @}example.com", "iat": 313435}`
   *     <p>If the JWT Claims Set contains an expiration time (`exp`) claim, it must be an integer
   *     timestamp that is not in the past and no more than 1 hour in the future.
   *     <p>If the JWT Claims Set does not contain an expiration time (`exp`) claim, this claim is
   *     added automatically, with a timestamp that is 1 hour in the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SignJwtResponse signJwt(ServiceAccountName name, String payload) {
    SignJwtRequest request =
        SignJwtRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPayload(payload)
            .build();
    return signJwt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; This method is deprecated. Use the
   * [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt)
   * method in the IAM Service Account Credentials API instead. If you currently use this method,
   * see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
   * instructions.
   *
   * <p>Signs a JSON Web Token (JWT) using the system-managed private key for a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   String payload = "payload-786701938";
   *   SignJwtResponse response = iAMClient.signJwt(name, payload);
   * }
   * }</pre>
   *
   * @param name Required. Deprecated. [Migrate to Service Account Credentials
   *     API](https://cloud.google.com/iam/help/credentials/migrate-api).
   *     <p>The resource name of the service account in the following format:
   *     `projects/{PROJECT_ID}/serviceAccounts/{ACCOUNT}`. Using `-` as a wildcard for the
   *     `PROJECT_ID` will infer the project from the account. The `ACCOUNT` value can be the
   *     `email` address or the `unique_id` of the service account.
   * @param payload Required. Deprecated. [Migrate to Service Account Credentials
   *     API](https://cloud.google.com/iam/help/credentials/migrate-api).
   *     <p>The JWT payload to sign. Must be a serialized JSON object that contains a JWT Claims
   *     Set. For example: `{"sub": "user{@literal @}example.com", "iat": 313435}`
   *     <p>If the JWT Claims Set contains an expiration time (`exp`) claim, it must be an integer
   *     timestamp that is not in the past and no more than 1 hour in the future.
   *     <p>If the JWT Claims Set does not contain an expiration time (`exp`) claim, this claim is
   *     added automatically, with a timestamp that is 1 hour in the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SignJwtResponse signJwt(String name, String payload) {
    SignJwtRequest request = SignJwtRequest.newBuilder().setName(name).setPayload(payload).build();
    return signJwt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; This method is deprecated. Use the
   * [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt)
   * method in the IAM Service Account Credentials API instead. If you currently use this method,
   * see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
   * instructions.
   *
   * <p>Signs a JSON Web Token (JWT) using the system-managed private key for a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   SignJwtRequest request =
   *       SignJwtRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setPayload("payload-786701938")
   *           .build();
   *   SignJwtResponse response = iAMClient.signJwt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SignJwtResponse signJwt(SignJwtRequest request) {
    return signJwtCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * &#42;&#42;Note:&#42;&#42; This method is deprecated. Use the
   * [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt)
   * method in the IAM Service Account Credentials API instead. If you currently use this method,
   * see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
   * instructions.
   *
   * <p>Signs a JSON Web Token (JWT) using the system-managed private key for a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   SignJwtRequest request =
   *       SignJwtRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setPayload("payload-786701938")
   *           .build();
   *   ApiFuture<SignJwtResponse> future = iAMClient.signJwtCallable().futureCall(request);
   *   // Do something.
   *   SignJwtResponse response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SignJwtRequest, SignJwtResponse> signJwtCallable() {
    return stub.signJwtCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   * This IAM policy specifies which members have access to the service account.
   *
   * <p>This method does not tell you whether the service account has been granted any roles on
   * other resources. To check whether a service account has role grants on a resource, use the
   * `getIamPolicy` method for that resource. For example, to view the role grants for a project,
   * call the Resource Manager API's
   * [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy)
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   Policy response = iAMClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   * This IAM policy specifies which members have access to the service account.
   *
   * <p>This method does not tell you whether the service account has been granted any roles on
   * other resources. To check whether a service account has role grants on a resource, use the
   * `getIamPolicy` method for that resource. For example, to view the role grants for a project,
   * call the Resource Manager API's
   * [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy)
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String resource = ProjectName.of("[PROJECT]").toString();
   *   Policy response = iAMClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   * This IAM policy specifies which members have access to the service account.
   *
   * <p>This method does not tell you whether the service account has been granted any roles on
   * other resources. To check whether a service account has role grants on a resource, use the
   * `getIamPolicy` method for that resource. For example, to view the role grants for a project,
   * call the Resource Manager API's
   * [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy)
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = iAMClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   * This IAM policy specifies which members have access to the service account.
   *
   * <p>This method does not tell you whether the service account has been granted any roles on
   * other resources. To check whether a service account has role grants on a resource, use the
   * `getIamPolicy` method for that resource. For example, to view the role grants for a project,
   * call the Resource Manager API's
   * [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy)
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = iAMClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Use this method to grant or revoke access to the service account. For example, you could
   * grant a member the ability to impersonate the service account.
   *
   * <p>This method does not enable the service account to access other resources. To grant roles to
   * a service account on a resource, follow these steps:
   *
   * <p>1. Call the resource's `getIamPolicy` method to get its current IAM policy. 2. Edit the
   * policy so that it binds the service account to an IAM role for the resource. 3. Call the
   * resource's `setIamPolicy` method to update its IAM policy.
   *
   * <p>For detailed instructions, see [Granting roles to a service account for specific
   * resources](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = iAMClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Use this method to grant or revoke access to the service account. For example, you could
   * grant a member the ability to impersonate the service account.
   *
   * <p>This method does not enable the service account to access other resources. To grant roles to
   * a service account on a resource, follow these steps:
   *
   * <p>1. Call the resource's `getIamPolicy` method to get its current IAM policy. 2. Edit the
   * policy so that it binds the service account to an IAM role for the resource. 3. Call the
   * resource's `setIamPolicy` method to update its IAM policy.
   *
   * <p>For detailed instructions, see [Granting roles to a service account for specific
   * resources](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String resource = ProjectName.of("[PROJECT]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = iAMClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Use this method to grant or revoke access to the service account. For example, you could
   * grant a member the ability to impersonate the service account.
   *
   * <p>This method does not enable the service account to access other resources. To grant roles to
   * a service account on a resource, follow these steps:
   *
   * <p>1. Call the resource's `getIamPolicy` method to get its current IAM policy. 2. Edit the
   * policy so that it binds the service account to an IAM role for the resource. 3. Call the
   * resource's `setIamPolicy` method to update its IAM policy.
   *
   * <p>For detailed instructions, see [Granting roles to a service account for specific
   * resources](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = iAMClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Use this method to grant or revoke access to the service account. For example, you could
   * grant a member the ability to impersonate the service account.
   *
   * <p>This method does not enable the service account to access other resources. To grant roles to
   * a service account on a resource, follow these steps:
   *
   * <p>1. Call the resource's `getIamPolicy` method to get its current IAM policy. 2. Edit the
   * policy so that it binds the service account to an IAM role for the resource. 3. Call the
   * resource's `setIamPolicy` method to update its IAM policy.
   *
   * <p>For detailed instructions, see [Granting roles to a service account for specific
   * resources](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = iAMClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests whether the caller has the specified permissions on a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ResourceName resource = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response = iAMClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests whether the caller has the specified permissions on a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String resource = ProjectName.of("[PROJECT]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response = iAMClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests whether the caller has the specified permissions on a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = iAMClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests whether the caller has the specified permissions on a
   * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       iAMClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roles that can be granted on a Google Cloud resource. A role is grantable if the IAM
   * policy for the resource can contain bindings to the role.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   String fullResourceName = "fullResourceName-853732376";
   *   for (Role element : iAMClient.queryGrantableRoles(fullResourceName).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param fullResourceName Required. The full resource name to query from the list of grantable
   *     roles.
   *     <p>The name follows the Google Cloud Platform resource format. For example, a Cloud
   *     Platform project with id `my-project` will be named
   *     `//cloudresourcemanager.googleapis.com/projects/my-project`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryGrantableRolesPagedResponse queryGrantableRoles(String fullResourceName) {
    QueryGrantableRolesRequest request =
        QueryGrantableRolesRequest.newBuilder().setFullResourceName(fullResourceName).build();
    return queryGrantableRoles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roles that can be granted on a Google Cloud resource. A role is grantable if the IAM
   * policy for the resource can contain bindings to the role.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   QueryGrantableRolesRequest request =
   *       QueryGrantableRolesRequest.newBuilder()
   *           .setFullResourceName("fullResourceName-853732376")
   *           .setView(RoleView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Role element : iAMClient.queryGrantableRoles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryGrantableRolesPagedResponse queryGrantableRoles(
      QueryGrantableRolesRequest request) {
    return queryGrantableRolesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roles that can be granted on a Google Cloud resource. A role is grantable if the IAM
   * policy for the resource can contain bindings to the role.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   QueryGrantableRolesRequest request =
   *       QueryGrantableRolesRequest.newBuilder()
   *           .setFullResourceName("fullResourceName-853732376")
   *           .setView(RoleView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Role> future = iAMClient.queryGrantableRolesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Role element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesPagedResponse>
      queryGrantableRolesPagedCallable() {
    return stub.queryGrantableRolesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists roles that can be granted on a Google Cloud resource. A role is grantable if the IAM
   * policy for the resource can contain bindings to the role.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   QueryGrantableRolesRequest request =
   *       QueryGrantableRolesRequest.newBuilder()
   *           .setFullResourceName("fullResourceName-853732376")
   *           .setView(RoleView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryGrantableRolesResponse response =
   *         iAMClient.queryGrantableRolesCallable().call(request);
   *     for (Role element : response.getRolesList()) {
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
  public final UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesResponse>
      queryGrantableRolesCallable() {
    return stub.queryGrantableRolesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every predefined [Role][google.iam.admin.v1.Role] that IAM supports, or every custom role
   * that is defined for an organization or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ListRolesRequest request =
   *       ListRolesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RoleView.forNumber(0))
   *           .setShowDeleted(true)
   *           .build();
   *   for (Role element : iAMClient.listRoles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolesPagedResponse listRoles(ListRolesRequest request) {
    return listRolesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every predefined [Role][google.iam.admin.v1.Role] that IAM supports, or every custom role
   * that is defined for an organization or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ListRolesRequest request =
   *       ListRolesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RoleView.forNumber(0))
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Role> future = iAMClient.listRolesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Role element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRolesRequest, ListRolesPagedResponse> listRolesPagedCallable() {
    return stub.listRolesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every predefined [Role][google.iam.admin.v1.Role] that IAM supports, or every custom role
   * that is defined for an organization or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   ListRolesRequest request =
   *       ListRolesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RoleView.forNumber(0))
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListRolesResponse response = iAMClient.listRolesCallable().call(request);
   *     for (Role element : response.getRolesList()) {
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
  public final UnaryCallable<ListRolesRequest, ListRolesResponse> listRolesCallable() {
    return stub.listRolesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the definition of a [Role][google.iam.admin.v1.Role].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   GetRoleRequest request =
   *       GetRoleRequest.newBuilder().setName("GetRoleRequest84528163".toString()).build();
   *   Role response = iAMClient.getRole(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Role getRole(GetRoleRequest request) {
    return getRoleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the definition of a [Role][google.iam.admin.v1.Role].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   GetRoleRequest request =
   *       GetRoleRequest.newBuilder().setName("GetRoleRequest84528163".toString()).build();
   *   ApiFuture<Role> future = iAMClient.getRoleCallable().futureCall(request);
   *   // Do something.
   *   Role response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRoleRequest, Role> getRoleCallable() {
    return stub.getRoleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new custom [Role][google.iam.admin.v1.Role].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   CreateRoleRequest request =
   *       CreateRoleRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setRoleId("roleId-925416399")
   *           .setRole(Role.newBuilder().build())
   *           .build();
   *   Role response = iAMClient.createRole(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Role createRole(CreateRoleRequest request) {
    return createRoleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new custom [Role][google.iam.admin.v1.Role].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   CreateRoleRequest request =
   *       CreateRoleRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setRoleId("roleId-925416399")
   *           .setRole(Role.newBuilder().build())
   *           .build();
   *   ApiFuture<Role> future = iAMClient.createRoleCallable().futureCall(request);
   *   // Do something.
   *   Role response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRoleRequest, Role> createRoleCallable() {
    return stub.createRoleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the definition of a custom [Role][google.iam.admin.v1.Role].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   UpdateRoleRequest request =
   *       UpdateRoleRequest.newBuilder()
   *           .setName("UpdateRoleRequest230834320".toString())
   *           .setRole(Role.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Role response = iAMClient.updateRole(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Role updateRole(UpdateRoleRequest request) {
    return updateRoleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the definition of a custom [Role][google.iam.admin.v1.Role].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   UpdateRoleRequest request =
   *       UpdateRoleRequest.newBuilder()
   *           .setName("UpdateRoleRequest230834320".toString())
   *           .setRole(Role.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Role> future = iAMClient.updateRoleCallable().futureCall(request);
   *   // Do something.
   *   Role response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRoleRequest, Role> updateRoleCallable() {
    return stub.updateRoleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a custom [Role][google.iam.admin.v1.Role].
   *
   * <p>When you delete a custom role, the following changes occur immediately:
   *
   * <ul>
   *   <li>You cannot bind a member to the custom role in an IAM [Policy][google.iam.v1.Policy].
   *   <li>Existing bindings to the custom role are not changed, but they have no effect.
   *   <li>By default, the response from [ListRoles][google.iam.admin.v1.IAM.ListRoles] does not
   *       include the custom role.
   * </ul>
   *
   * <p>You have 7 days to undelete the custom role. After 7 days, the following changes occur:
   *
   * <ul>
   *   <li>The custom role is permanently deleted and cannot be recovered.
   *   <li>If an IAM policy contains a binding to the custom role, the binding is permanently
   *       removed.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   DeleteRoleRequest request =
   *       DeleteRoleRequest.newBuilder()
   *           .setName("DeleteRoleRequest1468559982".toString())
   *           .setEtag(ByteString.EMPTY)
   *           .build();
   *   Role response = iAMClient.deleteRole(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Role deleteRole(DeleteRoleRequest request) {
    return deleteRoleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a custom [Role][google.iam.admin.v1.Role].
   *
   * <p>When you delete a custom role, the following changes occur immediately:
   *
   * <ul>
   *   <li>You cannot bind a member to the custom role in an IAM [Policy][google.iam.v1.Policy].
   *   <li>Existing bindings to the custom role are not changed, but they have no effect.
   *   <li>By default, the response from [ListRoles][google.iam.admin.v1.IAM.ListRoles] does not
   *       include the custom role.
   * </ul>
   *
   * <p>You have 7 days to undelete the custom role. After 7 days, the following changes occur:
   *
   * <ul>
   *   <li>The custom role is permanently deleted and cannot be recovered.
   *   <li>If an IAM policy contains a binding to the custom role, the binding is permanently
   *       removed.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   DeleteRoleRequest request =
   *       DeleteRoleRequest.newBuilder()
   *           .setName("DeleteRoleRequest1468559982".toString())
   *           .setEtag(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<Role> future = iAMClient.deleteRoleCallable().futureCall(request);
   *   // Do something.
   *   Role response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRoleRequest, Role> deleteRoleCallable() {
    return stub.deleteRoleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a custom [Role][google.iam.admin.v1.Role].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   UndeleteRoleRequest request =
   *       UndeleteRoleRequest.newBuilder()
   *           .setName("UndeleteRoleRequest755355893".toString())
   *           .setEtag(ByteString.EMPTY)
   *           .build();
   *   Role response = iAMClient.undeleteRole(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Role undeleteRole(UndeleteRoleRequest request) {
    return undeleteRoleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a custom [Role][google.iam.admin.v1.Role].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   UndeleteRoleRequest request =
   *       UndeleteRoleRequest.newBuilder()
   *           .setName("UndeleteRoleRequest755355893".toString())
   *           .setEtag(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<Role> future = iAMClient.undeleteRoleCallable().futureCall(request);
   *   // Do something.
   *   Role response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteRoleRequest, Role> undeleteRoleCallable() {
    return stub.undeleteRoleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every permission that you can test on a resource. A permission is testable if you can
   * check whether a member has that permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   QueryTestablePermissionsRequest request =
   *       QueryTestablePermissionsRequest.newBuilder()
   *           .setFullResourceName("fullResourceName-853732376")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Permission element : iAMClient.queryTestablePermissions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryTestablePermissionsPagedResponse queryTestablePermissions(
      QueryTestablePermissionsRequest request) {
    return queryTestablePermissionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every permission that you can test on a resource. A permission is testable if you can
   * check whether a member has that permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   QueryTestablePermissionsRequest request =
   *       QueryTestablePermissionsRequest.newBuilder()
   *           .setFullResourceName("fullResourceName-853732376")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Permission> future =
   *       iAMClient.queryTestablePermissionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Permission element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryTestablePermissionsRequest, QueryTestablePermissionsPagedResponse>
      queryTestablePermissionsPagedCallable() {
    return stub.queryTestablePermissionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists every permission that you can test on a resource. A permission is testable if you can
   * check whether a member has that permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   QueryTestablePermissionsRequest request =
   *       QueryTestablePermissionsRequest.newBuilder()
   *           .setFullResourceName("fullResourceName-853732376")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryTestablePermissionsResponse response =
   *         iAMClient.queryTestablePermissionsCallable().call(request);
   *     for (Permission element : response.getPermissionsList()) {
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
  public final UnaryCallable<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>
      queryTestablePermissionsCallable() {
    return stub.queryTestablePermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of services that allow you to opt into audit logs that are not generated by
   * default.
   *
   * <p>To learn more about audit logs, see the [Logging
   * documentation](https://cloud.google.com/logging/docs/audit).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   QueryAuditableServicesRequest request =
   *       QueryAuditableServicesRequest.newBuilder()
   *           .setFullResourceName("fullResourceName-853732376")
   *           .build();
   *   QueryAuditableServicesResponse response = iAMClient.queryAuditableServices(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryAuditableServicesResponse queryAuditableServices(
      QueryAuditableServicesRequest request) {
    return queryAuditableServicesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of services that allow you to opt into audit logs that are not generated by
   * default.
   *
   * <p>To learn more about audit logs, see the [Logging
   * documentation](https://cloud.google.com/logging/docs/audit).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   QueryAuditableServicesRequest request =
   *       QueryAuditableServicesRequest.newBuilder()
   *           .setFullResourceName("fullResourceName-853732376")
   *           .build();
   *   ApiFuture<QueryAuditableServicesResponse> future =
   *       iAMClient.queryAuditableServicesCallable().futureCall(request);
   *   // Do something.
   *   QueryAuditableServicesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
      queryAuditableServicesCallable() {
    return stub.queryAuditableServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lints, or validates, an IAM policy. Currently checks the
   * [google.iam.v1.Binding.condition][google.iam.v1.Binding.condition] field, which contains a
   * condition expression for a role binding.
   *
   * <p>Successful calls to this method always return an HTTP `200 OK` status code, even if the
   * linter detects an issue in the IAM policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   LintPolicyRequest request =
   *       LintPolicyRequest.newBuilder().setFullResourceName("fullResourceName-853732376").build();
   *   LintPolicyResponse response = iAMClient.lintPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LintPolicyResponse lintPolicy(LintPolicyRequest request) {
    return lintPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lints, or validates, an IAM policy. Currently checks the
   * [google.iam.v1.Binding.condition][google.iam.v1.Binding.condition] field, which contains a
   * condition expression for a role binding.
   *
   * <p>Successful calls to this method always return an HTTP `200 OK` status code, even if the
   * linter detects an issue in the IAM policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IAMClient iAMClient = IAMClient.create()) {
   *   LintPolicyRequest request =
   *       LintPolicyRequest.newBuilder().setFullResourceName("fullResourceName-853732376").build();
   *   ApiFuture<LintPolicyResponse> future = iAMClient.lintPolicyCallable().futureCall(request);
   *   // Do something.
   *   LintPolicyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LintPolicyRequest, LintPolicyResponse> lintPolicyCallable() {
    return stub.lintPolicyCallable();
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

  public static class ListServiceAccountsPagedResponse
      extends AbstractPagedListResponse<
          ListServiceAccountsRequest,
          ListServiceAccountsResponse,
          ServiceAccount,
          ListServiceAccountsPage,
          ListServiceAccountsFixedSizeCollection> {

    public static ApiFuture<ListServiceAccountsPagedResponse> createAsync(
        PageContext<ListServiceAccountsRequest, ListServiceAccountsResponse, ServiceAccount>
            context,
        ApiFuture<ListServiceAccountsResponse> futureResponse) {
      ApiFuture<ListServiceAccountsPage> futurePage =
          ListServiceAccountsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceAccountsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceAccountsPagedResponse(ListServiceAccountsPage page) {
      super(page, ListServiceAccountsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceAccountsPage
      extends AbstractPage<
          ListServiceAccountsRequest,
          ListServiceAccountsResponse,
          ServiceAccount,
          ListServiceAccountsPage> {

    private ListServiceAccountsPage(
        PageContext<ListServiceAccountsRequest, ListServiceAccountsResponse, ServiceAccount>
            context,
        ListServiceAccountsResponse response) {
      super(context, response);
    }

    private static ListServiceAccountsPage createEmptyPage() {
      return new ListServiceAccountsPage(null, null);
    }

    @Override
    protected ListServiceAccountsPage createPage(
        PageContext<ListServiceAccountsRequest, ListServiceAccountsResponse, ServiceAccount>
            context,
        ListServiceAccountsResponse response) {
      return new ListServiceAccountsPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceAccountsPage> createPageAsync(
        PageContext<ListServiceAccountsRequest, ListServiceAccountsResponse, ServiceAccount>
            context,
        ApiFuture<ListServiceAccountsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceAccountsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceAccountsRequest,
          ListServiceAccountsResponse,
          ServiceAccount,
          ListServiceAccountsPage,
          ListServiceAccountsFixedSizeCollection> {

    private ListServiceAccountsFixedSizeCollection(
        List<ListServiceAccountsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceAccountsFixedSizeCollection createEmptyCollection() {
      return new ListServiceAccountsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceAccountsFixedSizeCollection createCollection(
        List<ListServiceAccountsPage> pages, int collectionSize) {
      return new ListServiceAccountsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryGrantableRolesPagedResponse
      extends AbstractPagedListResponse<
          QueryGrantableRolesRequest,
          QueryGrantableRolesResponse,
          Role,
          QueryGrantableRolesPage,
          QueryGrantableRolesFixedSizeCollection> {

    public static ApiFuture<QueryGrantableRolesPagedResponse> createAsync(
        PageContext<QueryGrantableRolesRequest, QueryGrantableRolesResponse, Role> context,
        ApiFuture<QueryGrantableRolesResponse> futureResponse) {
      ApiFuture<QueryGrantableRolesPage> futurePage =
          QueryGrantableRolesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryGrantableRolesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryGrantableRolesPagedResponse(QueryGrantableRolesPage page) {
      super(page, QueryGrantableRolesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryGrantableRolesPage
      extends AbstractPage<
          QueryGrantableRolesRequest, QueryGrantableRolesResponse, Role, QueryGrantableRolesPage> {

    private QueryGrantableRolesPage(
        PageContext<QueryGrantableRolesRequest, QueryGrantableRolesResponse, Role> context,
        QueryGrantableRolesResponse response) {
      super(context, response);
    }

    private static QueryGrantableRolesPage createEmptyPage() {
      return new QueryGrantableRolesPage(null, null);
    }

    @Override
    protected QueryGrantableRolesPage createPage(
        PageContext<QueryGrantableRolesRequest, QueryGrantableRolesResponse, Role> context,
        QueryGrantableRolesResponse response) {
      return new QueryGrantableRolesPage(context, response);
    }

    @Override
    public ApiFuture<QueryGrantableRolesPage> createPageAsync(
        PageContext<QueryGrantableRolesRequest, QueryGrantableRolesResponse, Role> context,
        ApiFuture<QueryGrantableRolesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryGrantableRolesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryGrantableRolesRequest,
          QueryGrantableRolesResponse,
          Role,
          QueryGrantableRolesPage,
          QueryGrantableRolesFixedSizeCollection> {

    private QueryGrantableRolesFixedSizeCollection(
        List<QueryGrantableRolesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryGrantableRolesFixedSizeCollection createEmptyCollection() {
      return new QueryGrantableRolesFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryGrantableRolesFixedSizeCollection createCollection(
        List<QueryGrantableRolesPage> pages, int collectionSize) {
      return new QueryGrantableRolesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRolesPagedResponse
      extends AbstractPagedListResponse<
          ListRolesRequest, ListRolesResponse, Role, ListRolesPage, ListRolesFixedSizeCollection> {

    public static ApiFuture<ListRolesPagedResponse> createAsync(
        PageContext<ListRolesRequest, ListRolesResponse, Role> context,
        ApiFuture<ListRolesResponse> futureResponse) {
      ApiFuture<ListRolesPage> futurePage =
          ListRolesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRolesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRolesPagedResponse(ListRolesPage page) {
      super(page, ListRolesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRolesPage
      extends AbstractPage<ListRolesRequest, ListRolesResponse, Role, ListRolesPage> {

    private ListRolesPage(
        PageContext<ListRolesRequest, ListRolesResponse, Role> context,
        ListRolesResponse response) {
      super(context, response);
    }

    private static ListRolesPage createEmptyPage() {
      return new ListRolesPage(null, null);
    }

    @Override
    protected ListRolesPage createPage(
        PageContext<ListRolesRequest, ListRolesResponse, Role> context,
        ListRolesResponse response) {
      return new ListRolesPage(context, response);
    }

    @Override
    public ApiFuture<ListRolesPage> createPageAsync(
        PageContext<ListRolesRequest, ListRolesResponse, Role> context,
        ApiFuture<ListRolesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRolesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRolesRequest, ListRolesResponse, Role, ListRolesPage, ListRolesFixedSizeCollection> {

    private ListRolesFixedSizeCollection(List<ListRolesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRolesFixedSizeCollection createEmptyCollection() {
      return new ListRolesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRolesFixedSizeCollection createCollection(
        List<ListRolesPage> pages, int collectionSize) {
      return new ListRolesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryTestablePermissionsPagedResponse
      extends AbstractPagedListResponse<
          QueryTestablePermissionsRequest,
          QueryTestablePermissionsResponse,
          Permission,
          QueryTestablePermissionsPage,
          QueryTestablePermissionsFixedSizeCollection> {

    public static ApiFuture<QueryTestablePermissionsPagedResponse> createAsync(
        PageContext<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse, Permission>
            context,
        ApiFuture<QueryTestablePermissionsResponse> futureResponse) {
      ApiFuture<QueryTestablePermissionsPage> futurePage =
          QueryTestablePermissionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryTestablePermissionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryTestablePermissionsPagedResponse(QueryTestablePermissionsPage page) {
      super(page, QueryTestablePermissionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryTestablePermissionsPage
      extends AbstractPage<
          QueryTestablePermissionsRequest,
          QueryTestablePermissionsResponse,
          Permission,
          QueryTestablePermissionsPage> {

    private QueryTestablePermissionsPage(
        PageContext<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse, Permission>
            context,
        QueryTestablePermissionsResponse response) {
      super(context, response);
    }

    private static QueryTestablePermissionsPage createEmptyPage() {
      return new QueryTestablePermissionsPage(null, null);
    }

    @Override
    protected QueryTestablePermissionsPage createPage(
        PageContext<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse, Permission>
            context,
        QueryTestablePermissionsResponse response) {
      return new QueryTestablePermissionsPage(context, response);
    }

    @Override
    public ApiFuture<QueryTestablePermissionsPage> createPageAsync(
        PageContext<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse, Permission>
            context,
        ApiFuture<QueryTestablePermissionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryTestablePermissionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryTestablePermissionsRequest,
          QueryTestablePermissionsResponse,
          Permission,
          QueryTestablePermissionsPage,
          QueryTestablePermissionsFixedSizeCollection> {

    private QueryTestablePermissionsFixedSizeCollection(
        List<QueryTestablePermissionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryTestablePermissionsFixedSizeCollection createEmptyCollection() {
      return new QueryTestablePermissionsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryTestablePermissionsFixedSizeCollection createCollection(
        List<QueryTestablePermissionsPage> pages, int collectionSize) {
      return new QueryTestablePermissionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
