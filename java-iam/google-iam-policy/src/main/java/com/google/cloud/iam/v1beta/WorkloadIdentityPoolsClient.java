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

package com.google.cloud.iam.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iam.v1beta.stub.WorkloadIdentityPoolsStub;
import com.google.cloud.iam.v1beta.stub.WorkloadIdentityPoolsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse;
import com.google.iam.v1beta.ProjectName;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.WorkloadIdentityPool;
import com.google.iam.v1beta.WorkloadIdentityPoolName;
import com.google.iam.v1beta.WorkloadIdentityPoolOperationMetadata;
import com.google.iam.v1beta.WorkloadIdentityPoolProvider;
import com.google.iam.v1beta.WorkloadIdentityPoolProviderName;
import com.google.iam.v1beta.WorkloadIdentityPoolProviderOperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages WorkloadIdentityPools.
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
 * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
 *     WorkloadIdentityPoolsClient.create()) {
 *   WorkloadIdentityPoolName name =
 *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
 *   WorkloadIdentityPool response = workloadIdentityPoolsClient.getWorkloadIdentityPool(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WorkloadIdentityPoolsClient object to clean up
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
 *      <td><p> ListWorkloadIdentityPools</td>
 *      <td><p> Lists all non-deleted [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a project. If `show_deleted` is set to `true`, then deleted pools are also listed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkloadIdentityPools(ListWorkloadIdentityPoolsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkloadIdentityPools(ProjectName parent)
 *           <li><p> listWorkloadIdentityPools(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkloadIdentityPoolsPagedCallable()
 *           <li><p> listWorkloadIdentityPoolsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkloadIdentityPool</td>
 *      <td><p> Gets an individual [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkloadIdentityPool(GetWorkloadIdentityPoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkloadIdentityPool(WorkloadIdentityPoolName name)
 *           <li><p> getWorkloadIdentityPool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkloadIdentityPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkloadIdentityPool</td>
 *      <td><p> Creates a new [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
 * <p>  You cannot reuse the name of a deleted pool until 30 days after deletion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkloadIdentityPoolAsync(CreateWorkloadIdentityPoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createWorkloadIdentityPoolAsync(ProjectName parent, WorkloadIdentityPool workloadIdentityPool, String workloadIdentityPoolId)
 *           <li><p> createWorkloadIdentityPoolAsync(String parent, WorkloadIdentityPool workloadIdentityPool, String workloadIdentityPoolId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkloadIdentityPoolOperationCallable()
 *           <li><p> createWorkloadIdentityPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkloadIdentityPool</td>
 *      <td><p> Updates an existing [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkloadIdentityPoolAsync(UpdateWorkloadIdentityPoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateWorkloadIdentityPoolAsync(WorkloadIdentityPool workloadIdentityPool, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkloadIdentityPoolOperationCallable()
 *           <li><p> updateWorkloadIdentityPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkloadIdentityPool</td>
 *      <td><p> Deletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
 * <p>  You cannot use a deleted pool to exchange external credentials for Google Cloud credentials. However, deletion does not revoke credentials that have already been issued. Credentials issued for a deleted pool do not grant access to resources. If the pool is undeleted, and the credentials are not expired, they grant access again. You can undelete a pool for 30 days. After 30 days, deletion is permanent. You cannot update deleted pools. However, you can view and list them.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkloadIdentityPoolAsync(DeleteWorkloadIdentityPoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteWorkloadIdentityPoolAsync(WorkloadIdentityPoolName name)
 *           <li><p> deleteWorkloadIdentityPoolAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkloadIdentityPoolOperationCallable()
 *           <li><p> deleteWorkloadIdentityPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeleteWorkloadIdentityPool</td>
 *      <td><p> Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool], as long as it was deleted fewer than 30 days ago.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeleteWorkloadIdentityPoolAsync(UndeleteWorkloadIdentityPoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> undeleteWorkloadIdentityPoolAsync(WorkloadIdentityPoolName name)
 *           <li><p> undeleteWorkloadIdentityPoolAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeleteWorkloadIdentityPoolOperationCallable()
 *           <li><p> undeleteWorkloadIdentityPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkloadIdentityPoolProviders</td>
 *      <td><p> Lists all non-deleted [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]. If `show_deleted` is set to `true`, then deleted providers are also listed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkloadIdentityPoolProviders(ListWorkloadIdentityPoolProvidersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkloadIdentityPoolProviders(WorkloadIdentityPoolName parent)
 *           <li><p> listWorkloadIdentityPoolProviders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkloadIdentityPoolProvidersPagedCallable()
 *           <li><p> listWorkloadIdentityPoolProvidersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkloadIdentityPoolProvider</td>
 *      <td><p> Gets an individual [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkloadIdentityPoolProvider(GetWorkloadIdentityPoolProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkloadIdentityPoolProvider(WorkloadIdentityPoolProviderName name)
 *           <li><p> getWorkloadIdentityPoolProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkloadIdentityPoolProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkloadIdentityPoolProvider</td>
 *      <td><p> Creates a new [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider] in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
 * <p>  You cannot reuse the name of a deleted provider until 30 days after deletion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkloadIdentityPoolProviderAsync(CreateWorkloadIdentityPoolProviderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createWorkloadIdentityPoolProviderAsync(WorkloadIdentityPoolName parent, WorkloadIdentityPoolProvider workloadIdentityPoolProvider, String workloadIdentityPoolProviderId)
 *           <li><p> createWorkloadIdentityPoolProviderAsync(String parent, WorkloadIdentityPoolProvider workloadIdentityPoolProvider, String workloadIdentityPoolProviderId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkloadIdentityPoolProviderOperationCallable()
 *           <li><p> createWorkloadIdentityPoolProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkloadIdentityPoolProvider</td>
 *      <td><p> Updates an existing [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkloadIdentityPoolProviderAsync(UpdateWorkloadIdentityPoolProviderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateWorkloadIdentityPoolProviderAsync(WorkloadIdentityPoolProvider workloadIdentityPoolProvider, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkloadIdentityPoolProviderOperationCallable()
 *           <li><p> updateWorkloadIdentityPoolProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkloadIdentityPoolProvider</td>
 *      <td><p> Deletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]. Deleting a provider does not revoke credentials that have already been issued; they continue to grant access. You can undelete a provider for 30 days. After 30 days, deletion is permanent. You cannot update deleted providers. However, you can view and list them.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkloadIdentityPoolProviderAsync(DeleteWorkloadIdentityPoolProviderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteWorkloadIdentityPoolProviderAsync(WorkloadIdentityPoolProviderName name)
 *           <li><p> deleteWorkloadIdentityPoolProviderAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkloadIdentityPoolProviderOperationCallable()
 *           <li><p> deleteWorkloadIdentityPoolProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeleteWorkloadIdentityPoolProvider</td>
 *      <td><p> Undeletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider], as long as it was deleted fewer than 30 days ago.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeleteWorkloadIdentityPoolProviderAsync(UndeleteWorkloadIdentityPoolProviderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> undeleteWorkloadIdentityPoolProviderAsync(WorkloadIdentityPoolProviderName name)
 *           <li><p> undeleteWorkloadIdentityPoolProviderAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeleteWorkloadIdentityPoolProviderOperationCallable()
 *           <li><p> undeleteWorkloadIdentityPoolProviderCallable()
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
 * <p>This class can be customized by passing in a custom instance of WorkloadIdentityPoolsSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkloadIdentityPoolsSettings workloadIdentityPoolsSettings =
 *     WorkloadIdentityPoolsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
 *     WorkloadIdentityPoolsClient.create(workloadIdentityPoolsSettings);
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
 * WorkloadIdentityPoolsSettings workloadIdentityPoolsSettings =
 *     WorkloadIdentityPoolsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
 *     WorkloadIdentityPoolsClient.create(workloadIdentityPoolsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WorkloadIdentityPoolsClient implements BackgroundResource {
  private final WorkloadIdentityPoolsSettings settings;
  private final WorkloadIdentityPoolsStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of WorkloadIdentityPoolsClient with default settings. */
  public static final WorkloadIdentityPoolsClient create() throws IOException {
    return create(WorkloadIdentityPoolsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WorkloadIdentityPoolsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WorkloadIdentityPoolsClient create(WorkloadIdentityPoolsSettings settings)
      throws IOException {
    return new WorkloadIdentityPoolsClient(settings);
  }

  /**
   * Constructs an instance of WorkloadIdentityPoolsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(WorkloadIdentityPoolsSettings).
   */
  public static final WorkloadIdentityPoolsClient create(WorkloadIdentityPoolsStub stub) {
    return new WorkloadIdentityPoolsClient(stub);
  }

  /**
   * Constructs an instance of WorkloadIdentityPoolsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected WorkloadIdentityPoolsClient(WorkloadIdentityPoolsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WorkloadIdentityPoolsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected WorkloadIdentityPoolsClient(WorkloadIdentityPoolsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final WorkloadIdentityPoolsSettings getSettings() {
    return settings;
  }

  public WorkloadIdentityPoolsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
   * project. If `show_deleted` is set to `true`, then deleted pools are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (WorkloadIdentityPool element :
   *       workloadIdentityPoolsClient.listWorkloadIdentityPools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to list pools for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadIdentityPoolsPagedResponse listWorkloadIdentityPools(
      ProjectName parent) {
    ListWorkloadIdentityPoolsRequest request =
        ListWorkloadIdentityPoolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkloadIdentityPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
   * project. If `show_deleted` is set to `true`, then deleted pools are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (WorkloadIdentityPool element :
   *       workloadIdentityPoolsClient.listWorkloadIdentityPools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to list pools for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadIdentityPoolsPagedResponse listWorkloadIdentityPools(String parent) {
    ListWorkloadIdentityPoolsRequest request =
        ListWorkloadIdentityPoolsRequest.newBuilder().setParent(parent).build();
    return listWorkloadIdentityPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
   * project. If `show_deleted` is set to `true`, then deleted pools are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   ListWorkloadIdentityPoolsRequest request =
   *       ListWorkloadIdentityPoolsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (WorkloadIdentityPool element :
   *       workloadIdentityPoolsClient.listWorkloadIdentityPools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadIdentityPoolsPagedResponse listWorkloadIdentityPools(
      ListWorkloadIdentityPoolsRequest request) {
    return listWorkloadIdentityPoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
   * project. If `show_deleted` is set to `true`, then deleted pools are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   ListWorkloadIdentityPoolsRequest request =
   *       ListWorkloadIdentityPoolsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<WorkloadIdentityPool> future =
   *       workloadIdentityPoolsClient.listWorkloadIdentityPoolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkloadIdentityPool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsPagedResponse>
      listWorkloadIdentityPoolsPagedCallable() {
    return stub.listWorkloadIdentityPoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
   * project. If `show_deleted` is set to `true`, then deleted pools are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   ListWorkloadIdentityPoolsRequest request =
   *       ListWorkloadIdentityPoolsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListWorkloadIdentityPoolsResponse response =
   *         workloadIdentityPoolsClient.listWorkloadIdentityPoolsCallable().call(request);
   *     for (WorkloadIdentityPool element : response.getWorkloadIdentityPoolsList()) {
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
  public final UnaryCallable<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>
      listWorkloadIdentityPoolsCallable() {
    return stub.listWorkloadIdentityPoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an individual [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolName name =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
   *   WorkloadIdentityPool response = workloadIdentityPoolsClient.getWorkloadIdentityPool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the pool to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkloadIdentityPool getWorkloadIdentityPool(WorkloadIdentityPoolName name) {
    GetWorkloadIdentityPoolRequest request =
        GetWorkloadIdentityPoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getWorkloadIdentityPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an individual [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String name =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *           .toString();
   *   WorkloadIdentityPool response = workloadIdentityPoolsClient.getWorkloadIdentityPool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the pool to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkloadIdentityPool getWorkloadIdentityPool(String name) {
    GetWorkloadIdentityPoolRequest request =
        GetWorkloadIdentityPoolRequest.newBuilder().setName(name).build();
    return getWorkloadIdentityPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an individual [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   GetWorkloadIdentityPoolRequest request =
   *       GetWorkloadIdentityPoolRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .build();
   *   WorkloadIdentityPool response = workloadIdentityPoolsClient.getWorkloadIdentityPool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkloadIdentityPool getWorkloadIdentityPool(
      GetWorkloadIdentityPoolRequest request) {
    return getWorkloadIdentityPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an individual [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   GetWorkloadIdentityPoolRequest request =
   *       GetWorkloadIdentityPoolRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<WorkloadIdentityPool> future =
   *       workloadIdentityPoolsClient.getWorkloadIdentityPoolCallable().futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
      getWorkloadIdentityPoolCallable() {
    return stub.getWorkloadIdentityPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted pool until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
   *   String workloadIdentityPoolId = "workloadIdentityPoolId1304488972";
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient
   *           .createWorkloadIdentityPoolAsync(parent, workloadIdentityPool, workloadIdentityPoolId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to create the pool in. The only supported location
   *     is `global`.
   * @param workloadIdentityPool Required. The pool to create.
   * @param workloadIdentityPoolId Required. The ID to use for the pool, which becomes the final
   *     component of the resource name. This value should be 4-32 characters, and may contain the
   *     characters [a-z0-9-]. The prefix `gcp-` is reserved for use by Google, and may not be
   *     specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolAsync(
          ProjectName parent,
          WorkloadIdentityPool workloadIdentityPool,
          String workloadIdentityPoolId) {
    CreateWorkloadIdentityPoolRequest request =
        CreateWorkloadIdentityPoolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkloadIdentityPool(workloadIdentityPool)
            .setWorkloadIdentityPoolId(workloadIdentityPoolId)
            .build();
    return createWorkloadIdentityPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted pool until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
   *   String workloadIdentityPoolId = "workloadIdentityPoolId1304488972";
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient
   *           .createWorkloadIdentityPoolAsync(parent, workloadIdentityPool, workloadIdentityPoolId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to create the pool in. The only supported location
   *     is `global`.
   * @param workloadIdentityPool Required. The pool to create.
   * @param workloadIdentityPoolId Required. The ID to use for the pool, which becomes the final
   *     component of the resource name. This value should be 4-32 characters, and may contain the
   *     characters [a-z0-9-]. The prefix `gcp-` is reserved for use by Google, and may not be
   *     specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolAsync(
          String parent, WorkloadIdentityPool workloadIdentityPool, String workloadIdentityPoolId) {
    CreateWorkloadIdentityPoolRequest request =
        CreateWorkloadIdentityPoolRequest.newBuilder()
            .setParent(parent)
            .setWorkloadIdentityPool(workloadIdentityPool)
            .setWorkloadIdentityPoolId(workloadIdentityPoolId)
            .build();
    return createWorkloadIdentityPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted pool until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   CreateWorkloadIdentityPoolRequest request =
   *       CreateWorkloadIdentityPoolRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setWorkloadIdentityPool(WorkloadIdentityPool.newBuilder().build())
   *           .setWorkloadIdentityPoolId("workloadIdentityPoolId1304488972")
   *           .build();
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient.createWorkloadIdentityPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolAsync(CreateWorkloadIdentityPoolRequest request) {
    return createWorkloadIdentityPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted pool until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   CreateWorkloadIdentityPoolRequest request =
   *       CreateWorkloadIdentityPoolRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setWorkloadIdentityPool(WorkloadIdentityPool.newBuilder().build())
   *           .setWorkloadIdentityPoolId("workloadIdentityPoolId1304488972")
   *           .build();
   *   OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata> future =
   *       workloadIdentityPoolsClient
   *           .createWorkloadIdentityPoolOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolOperationCallable() {
    return stub.createWorkloadIdentityPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted pool until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   CreateWorkloadIdentityPoolRequest request =
   *       CreateWorkloadIdentityPoolRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setWorkloadIdentityPool(WorkloadIdentityPool.newBuilder().build())
   *           .setWorkloadIdentityPoolId("workloadIdentityPoolId1304488972")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadIdentityPoolsClient.createWorkloadIdentityPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkloadIdentityPoolRequest, Operation>
      createWorkloadIdentityPoolCallable() {
    return stub.createWorkloadIdentityPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPool workloadIdentityPool = WorkloadIdentityPool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient
   *           .updateWorkloadIdentityPoolAsync(workloadIdentityPool, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param workloadIdentityPool Required. The pool to update. The `name` field is used to identify
   *     the pool.
   * @param updateMask Required. The list of fields update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolAsync(
          WorkloadIdentityPool workloadIdentityPool, FieldMask updateMask) {
    UpdateWorkloadIdentityPoolRequest request =
        UpdateWorkloadIdentityPoolRequest.newBuilder()
            .setWorkloadIdentityPool(workloadIdentityPool)
            .setUpdateMask(updateMask)
            .build();
    return updateWorkloadIdentityPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UpdateWorkloadIdentityPoolRequest request =
   *       UpdateWorkloadIdentityPoolRequest.newBuilder()
   *           .setWorkloadIdentityPool(WorkloadIdentityPool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient.updateWorkloadIdentityPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolAsync(UpdateWorkloadIdentityPoolRequest request) {
    return updateWorkloadIdentityPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UpdateWorkloadIdentityPoolRequest request =
   *       UpdateWorkloadIdentityPoolRequest.newBuilder()
   *           .setWorkloadIdentityPool(WorkloadIdentityPool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata> future =
   *       workloadIdentityPoolsClient
   *           .updateWorkloadIdentityPoolOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolOperationCallable() {
    return stub.updateWorkloadIdentityPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UpdateWorkloadIdentityPoolRequest request =
   *       UpdateWorkloadIdentityPoolRequest.newBuilder()
   *           .setWorkloadIdentityPool(WorkloadIdentityPool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadIdentityPoolsClient.updateWorkloadIdentityPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkloadIdentityPoolRequest, Operation>
      updateWorkloadIdentityPoolCallable() {
    return stub.updateWorkloadIdentityPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot use a deleted pool to exchange external credentials for Google Cloud credentials.
   * However, deletion does not revoke credentials that have already been issued. Credentials issued
   * for a deleted pool do not grant access to resources. If the pool is undeleted, and the
   * credentials are not expired, they grant access again. You can undelete a pool for 30 days.
   * After 30 days, deletion is permanent. You cannot update deleted pools. However, you can view
   * and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolName name =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient.deleteWorkloadIdentityPoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the pool to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolAsync(WorkloadIdentityPoolName name) {
    DeleteWorkloadIdentityPoolRequest request =
        DeleteWorkloadIdentityPoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteWorkloadIdentityPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot use a deleted pool to exchange external credentials for Google Cloud credentials.
   * However, deletion does not revoke credentials that have already been issued. Credentials issued
   * for a deleted pool do not grant access to resources. If the pool is undeleted, and the
   * credentials are not expired, they grant access again. You can undelete a pool for 30 days.
   * After 30 days, deletion is permanent. You cannot update deleted pools. However, you can view
   * and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String name =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *           .toString();
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient.deleteWorkloadIdentityPoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the pool to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolAsync(String name) {
    DeleteWorkloadIdentityPoolRequest request =
        DeleteWorkloadIdentityPoolRequest.newBuilder().setName(name).build();
    return deleteWorkloadIdentityPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot use a deleted pool to exchange external credentials for Google Cloud credentials.
   * However, deletion does not revoke credentials that have already been issued. Credentials issued
   * for a deleted pool do not grant access to resources. If the pool is undeleted, and the
   * credentials are not expired, they grant access again. You can undelete a pool for 30 days.
   * After 30 days, deletion is permanent. You cannot update deleted pools. However, you can view
   * and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   DeleteWorkloadIdentityPoolRequest request =
   *       DeleteWorkloadIdentityPoolRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .build();
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient.deleteWorkloadIdentityPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolAsync(DeleteWorkloadIdentityPoolRequest request) {
    return deleteWorkloadIdentityPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot use a deleted pool to exchange external credentials for Google Cloud credentials.
   * However, deletion does not revoke credentials that have already been issued. Credentials issued
   * for a deleted pool do not grant access to resources. If the pool is undeleted, and the
   * credentials are not expired, they grant access again. You can undelete a pool for 30 days.
   * After 30 days, deletion is permanent. You cannot update deleted pools. However, you can view
   * and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   DeleteWorkloadIdentityPoolRequest request =
   *       DeleteWorkloadIdentityPoolRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .build();
   *   OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata> future =
   *       workloadIdentityPoolsClient
   *           .deleteWorkloadIdentityPoolOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolOperationCallable() {
    return stub.deleteWorkloadIdentityPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot use a deleted pool to exchange external credentials for Google Cloud credentials.
   * However, deletion does not revoke credentials that have already been issued. Credentials issued
   * for a deleted pool do not grant access to resources. If the pool is undeleted, and the
   * credentials are not expired, they grant access again. You can undelete a pool for 30 days.
   * After 30 days, deletion is permanent. You cannot update deleted pools. However, you can view
   * and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   DeleteWorkloadIdentityPoolRequest request =
   *       DeleteWorkloadIdentityPoolRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadIdentityPoolsClient.deleteWorkloadIdentityPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkloadIdentityPoolRequest, Operation>
      deleteWorkloadIdentityPoolCallable() {
    return stub.deleteWorkloadIdentityPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool], as long as it was
   * deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolName name =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient.undeleteWorkloadIdentityPoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the pool to undelete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolAsync(WorkloadIdentityPoolName name) {
    UndeleteWorkloadIdentityPoolRequest request =
        UndeleteWorkloadIdentityPoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeleteWorkloadIdentityPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool], as long as it was
   * deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String name =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *           .toString();
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient.undeleteWorkloadIdentityPoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the pool to undelete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolAsync(String name) {
    UndeleteWorkloadIdentityPoolRequest request =
        UndeleteWorkloadIdentityPoolRequest.newBuilder().setName(name).build();
    return undeleteWorkloadIdentityPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool], as long as it was
   * deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UndeleteWorkloadIdentityPoolRequest request =
   *       UndeleteWorkloadIdentityPoolRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .build();
   *   WorkloadIdentityPool response =
   *       workloadIdentityPoolsClient.undeleteWorkloadIdentityPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolAsync(UndeleteWorkloadIdentityPoolRequest request) {
    return undeleteWorkloadIdentityPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool], as long as it was
   * deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UndeleteWorkloadIdentityPoolRequest request =
   *       UndeleteWorkloadIdentityPoolRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .build();
   *   OperationFuture<WorkloadIdentityPool, WorkloadIdentityPoolOperationMetadata> future =
   *       workloadIdentityPoolsClient
   *           .undeleteWorkloadIdentityPoolOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolOperationCallable() {
    return stub.undeleteWorkloadIdentityPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool], as long as it was
   * deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UndeleteWorkloadIdentityPoolRequest request =
   *       UndeleteWorkloadIdentityPoolRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadIdentityPoolsClient.undeleteWorkloadIdentityPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteWorkloadIdentityPoolRequest, Operation>
      undeleteWorkloadIdentityPoolCallable() {
    return stub.undeleteWorkloadIdentityPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]. If `show_deleted` is set to
   * `true`, then deleted providers are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolName parent =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
   *   for (WorkloadIdentityPoolProvider element :
   *       workloadIdentityPoolsClient.listWorkloadIdentityPoolProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The pool to list providers for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadIdentityPoolProvidersPagedResponse listWorkloadIdentityPoolProviders(
      WorkloadIdentityPoolName parent) {
    ListWorkloadIdentityPoolProvidersRequest request =
        ListWorkloadIdentityPoolProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkloadIdentityPoolProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]. If `show_deleted` is set to
   * `true`, then deleted providers are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String parent =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *           .toString();
   *   for (WorkloadIdentityPoolProvider element :
   *       workloadIdentityPoolsClient.listWorkloadIdentityPoolProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The pool to list providers for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadIdentityPoolProvidersPagedResponse listWorkloadIdentityPoolProviders(
      String parent) {
    ListWorkloadIdentityPoolProvidersRequest request =
        ListWorkloadIdentityPoolProvidersRequest.newBuilder().setParent(parent).build();
    return listWorkloadIdentityPoolProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]. If `show_deleted` is set to
   * `true`, then deleted providers are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   ListWorkloadIdentityPoolProvidersRequest request =
   *       ListWorkloadIdentityPoolProvidersRequest.newBuilder()
   *           .setParent(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (WorkloadIdentityPoolProvider element :
   *       workloadIdentityPoolsClient.listWorkloadIdentityPoolProviders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkloadIdentityPoolProvidersPagedResponse listWorkloadIdentityPoolProviders(
      ListWorkloadIdentityPoolProvidersRequest request) {
    return listWorkloadIdentityPoolProvidersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]. If `show_deleted` is set to
   * `true`, then deleted providers are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   ListWorkloadIdentityPoolProvidersRequest request =
   *       ListWorkloadIdentityPoolProvidersRequest.newBuilder()
   *           .setParent(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<WorkloadIdentityPoolProvider> future =
   *       workloadIdentityPoolsClient
   *           .listWorkloadIdentityPoolProvidersPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (WorkloadIdentityPoolProvider element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersPagedResponse>
      listWorkloadIdentityPoolProvidersPagedCallable() {
    return stub.listWorkloadIdentityPoolProvidersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all non-deleted
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]. If `show_deleted` is set to
   * `true`, then deleted providers are also listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   ListWorkloadIdentityPoolProvidersRequest request =
   *       ListWorkloadIdentityPoolProvidersRequest.newBuilder()
   *           .setParent(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListWorkloadIdentityPoolProvidersResponse response =
   *         workloadIdentityPoolsClient.listWorkloadIdentityPoolProvidersCallable().call(request);
   *     for (WorkloadIdentityPoolProvider element :
   *         response.getWorkloadIdentityPoolProvidersList()) {
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
  public final UnaryCallable<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersResponse>
      listWorkloadIdentityPoolProvidersCallable() {
    return stub.listWorkloadIdentityPoolProvidersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an individual
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolProviderName name =
   *       WorkloadIdentityPoolProviderName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[WORKLOAD_IDENTITY_POOL]",
   *           "[WORKLOAD_IDENTITY_POOL_PROVIDER]");
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.getWorkloadIdentityPoolProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkloadIdentityPoolProvider getWorkloadIdentityPoolProvider(
      WorkloadIdentityPoolProviderName name) {
    GetWorkloadIdentityPoolProviderRequest request =
        GetWorkloadIdentityPoolProviderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getWorkloadIdentityPoolProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an individual
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String name =
   *       WorkloadIdentityPoolProviderName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[WORKLOAD_IDENTITY_POOL]",
   *               "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *           .toString();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.getWorkloadIdentityPoolProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkloadIdentityPoolProvider getWorkloadIdentityPoolProvider(String name) {
    GetWorkloadIdentityPoolProviderRequest request =
        GetWorkloadIdentityPoolProviderRequest.newBuilder().setName(name).build();
    return getWorkloadIdentityPoolProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an individual
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   GetWorkloadIdentityPoolProviderRequest request =
   *       GetWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolProviderName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKLOAD_IDENTITY_POOL]",
   *                       "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *                   .toString())
   *           .build();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.getWorkloadIdentityPoolProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkloadIdentityPoolProvider getWorkloadIdentityPoolProvider(
      GetWorkloadIdentityPoolProviderRequest request) {
    return getWorkloadIdentityPoolProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an individual
   * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   GetWorkloadIdentityPoolProviderRequest request =
   *       GetWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolProviderName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKLOAD_IDENTITY_POOL]",
   *                       "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<WorkloadIdentityPoolProvider> future =
   *       workloadIdentityPoolsClient.getWorkloadIdentityPoolProviderCallable().futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPoolProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
      getWorkloadIdentityPoolProviderCallable() {
    return stub.getWorkloadIdentityPoolProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider] in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted provider until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolName parent =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]");
   *   WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
   *       WorkloadIdentityPoolProvider.newBuilder().build();
   *   String workloadIdentityPoolProviderId = "workloadIdentityPoolProviderId-2035698467";
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient
   *           .createWorkloadIdentityPoolProviderAsync(
   *               parent, workloadIdentityPoolProvider, workloadIdentityPoolProviderId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The pool to create this provider in.
   * @param workloadIdentityPoolProvider Required. The provider to create.
   * @param workloadIdentityPoolProviderId Required. The ID for the provider, which becomes the
   *     final component of the resource name. This value must be 4-32 characters, and may contain
   *     the characters [a-z0-9-]. The prefix `gcp-` is reserved for use by Google, and may not be
   *     specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderAsync(
          WorkloadIdentityPoolName parent,
          WorkloadIdentityPoolProvider workloadIdentityPoolProvider,
          String workloadIdentityPoolProviderId) {
    CreateWorkloadIdentityPoolProviderRequest request =
        CreateWorkloadIdentityPoolProviderRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkloadIdentityPoolProvider(workloadIdentityPoolProvider)
            .setWorkloadIdentityPoolProviderId(workloadIdentityPoolProviderId)
            .build();
    return createWorkloadIdentityPoolProviderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider] in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted provider until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String parent =
   *       WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *           .toString();
   *   WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
   *       WorkloadIdentityPoolProvider.newBuilder().build();
   *   String workloadIdentityPoolProviderId = "workloadIdentityPoolProviderId-2035698467";
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient
   *           .createWorkloadIdentityPoolProviderAsync(
   *               parent, workloadIdentityPoolProvider, workloadIdentityPoolProviderId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The pool to create this provider in.
   * @param workloadIdentityPoolProvider Required. The provider to create.
   * @param workloadIdentityPoolProviderId Required. The ID for the provider, which becomes the
   *     final component of the resource name. This value must be 4-32 characters, and may contain
   *     the characters [a-z0-9-]. The prefix `gcp-` is reserved for use by Google, and may not be
   *     specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderAsync(
          String parent,
          WorkloadIdentityPoolProvider workloadIdentityPoolProvider,
          String workloadIdentityPoolProviderId) {
    CreateWorkloadIdentityPoolProviderRequest request =
        CreateWorkloadIdentityPoolProviderRequest.newBuilder()
            .setParent(parent)
            .setWorkloadIdentityPoolProvider(workloadIdentityPoolProvider)
            .setWorkloadIdentityPoolProviderId(workloadIdentityPoolProviderId)
            .build();
    return createWorkloadIdentityPoolProviderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider] in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted provider until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   CreateWorkloadIdentityPoolProviderRequest request =
   *       CreateWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setParent(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .setWorkloadIdentityPoolProvider(WorkloadIdentityPoolProvider.newBuilder().build())
   *           .setWorkloadIdentityPoolProviderId("workloadIdentityPoolProviderId-2035698467")
   *           .build();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.createWorkloadIdentityPoolProviderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderAsync(CreateWorkloadIdentityPoolProviderRequest request) {
    return createWorkloadIdentityPoolProviderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider] in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted provider until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   CreateWorkloadIdentityPoolProviderRequest request =
   *       CreateWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setParent(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .setWorkloadIdentityPoolProvider(WorkloadIdentityPoolProvider.newBuilder().build())
   *           .setWorkloadIdentityPoolProviderId("workloadIdentityPoolProviderId-2035698467")
   *           .build();
   *   OperationFuture<WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
   *       future =
   *           workloadIdentityPoolsClient
   *               .createWorkloadIdentityPoolProviderOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPoolProvider response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderOperationCallable() {
    return stub.createWorkloadIdentityPoolProviderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider] in a
   * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
   *
   * <p>You cannot reuse the name of a deleted provider until 30 days after deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   CreateWorkloadIdentityPoolProviderRequest request =
   *       CreateWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setParent(
   *               WorkloadIdentityPoolName.of("[PROJECT]", "[LOCATION]", "[WORKLOAD_IDENTITY_POOL]")
   *                   .toString())
   *           .setWorkloadIdentityPoolProvider(WorkloadIdentityPoolProvider.newBuilder().build())
   *           .setWorkloadIdentityPoolProviderId("workloadIdentityPoolProviderId-2035698467")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadIdentityPoolsClient
   *           .createWorkloadIdentityPoolProviderCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkloadIdentityPoolProviderRequest, Operation>
      createWorkloadIdentityPoolProviderCallable() {
    return stub.createWorkloadIdentityPoolProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolProvider workloadIdentityPoolProvider =
   *       WorkloadIdentityPoolProvider.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient
   *           .updateWorkloadIdentityPoolProviderAsync(workloadIdentityPoolProvider, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param workloadIdentityPoolProvider Required. The provider to update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderAsync(
          WorkloadIdentityPoolProvider workloadIdentityPoolProvider, FieldMask updateMask) {
    UpdateWorkloadIdentityPoolProviderRequest request =
        UpdateWorkloadIdentityPoolProviderRequest.newBuilder()
            .setWorkloadIdentityPoolProvider(workloadIdentityPoolProvider)
            .setUpdateMask(updateMask)
            .build();
    return updateWorkloadIdentityPoolProviderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UpdateWorkloadIdentityPoolProviderRequest request =
   *       UpdateWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setWorkloadIdentityPoolProvider(WorkloadIdentityPoolProvider.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.updateWorkloadIdentityPoolProviderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderAsync(UpdateWorkloadIdentityPoolProviderRequest request) {
    return updateWorkloadIdentityPoolProviderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UpdateWorkloadIdentityPoolProviderRequest request =
   *       UpdateWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setWorkloadIdentityPoolProvider(WorkloadIdentityPoolProvider.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
   *       future =
   *           workloadIdentityPoolsClient
   *               .updateWorkloadIdentityPoolProviderOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPoolProvider response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderOperationCallable() {
    return stub.updateWorkloadIdentityPoolProviderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UpdateWorkloadIdentityPoolProviderRequest request =
   *       UpdateWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setWorkloadIdentityPoolProvider(WorkloadIdentityPoolProvider.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadIdentityPoolsClient
   *           .updateWorkloadIdentityPoolProviderCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkloadIdentityPoolProviderRequest, Operation>
      updateWorkloadIdentityPoolProviderCallable() {
    return stub.updateWorkloadIdentityPoolProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]. Deleting
   * a provider does not revoke credentials that have already been issued; they continue to grant
   * access. You can undelete a provider for 30 days. After 30 days, deletion is permanent. You
   * cannot update deleted providers. However, you can view and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolProviderName name =
   *       WorkloadIdentityPoolProviderName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[WORKLOAD_IDENTITY_POOL]",
   *           "[WORKLOAD_IDENTITY_POOL_PROVIDER]");
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.deleteWorkloadIdentityPoolProviderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderAsync(WorkloadIdentityPoolProviderName name) {
    DeleteWorkloadIdentityPoolProviderRequest request =
        DeleteWorkloadIdentityPoolProviderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteWorkloadIdentityPoolProviderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]. Deleting
   * a provider does not revoke credentials that have already been issued; they continue to grant
   * access. You can undelete a provider for 30 days. After 30 days, deletion is permanent. You
   * cannot update deleted providers. However, you can view and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String name =
   *       WorkloadIdentityPoolProviderName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[WORKLOAD_IDENTITY_POOL]",
   *               "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *           .toString();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.deleteWorkloadIdentityPoolProviderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderAsync(String name) {
    DeleteWorkloadIdentityPoolProviderRequest request =
        DeleteWorkloadIdentityPoolProviderRequest.newBuilder().setName(name).build();
    return deleteWorkloadIdentityPoolProviderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]. Deleting
   * a provider does not revoke credentials that have already been issued; they continue to grant
   * access. You can undelete a provider for 30 days. After 30 days, deletion is permanent. You
   * cannot update deleted providers. However, you can view and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   DeleteWorkloadIdentityPoolProviderRequest request =
   *       DeleteWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolProviderName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKLOAD_IDENTITY_POOL]",
   *                       "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *                   .toString())
   *           .build();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.deleteWorkloadIdentityPoolProviderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderAsync(DeleteWorkloadIdentityPoolProviderRequest request) {
    return deleteWorkloadIdentityPoolProviderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]. Deleting
   * a provider does not revoke credentials that have already been issued; they continue to grant
   * access. You can undelete a provider for 30 days. After 30 days, deletion is permanent. You
   * cannot update deleted providers. However, you can view and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   DeleteWorkloadIdentityPoolProviderRequest request =
   *       DeleteWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolProviderName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKLOAD_IDENTITY_POOL]",
   *                       "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *                   .toString())
   *           .build();
   *   OperationFuture<WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
   *       future =
   *           workloadIdentityPoolsClient
   *               .deleteWorkloadIdentityPoolProviderOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPoolProvider response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderOperationCallable() {
    return stub.deleteWorkloadIdentityPoolProviderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]. Deleting
   * a provider does not revoke credentials that have already been issued; they continue to grant
   * access. You can undelete a provider for 30 days. After 30 days, deletion is permanent. You
   * cannot update deleted providers. However, you can view and list them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   DeleteWorkloadIdentityPoolProviderRequest request =
   *       DeleteWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolProviderName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKLOAD_IDENTITY_POOL]",
   *                       "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadIdentityPoolsClient
   *           .deleteWorkloadIdentityPoolProviderCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkloadIdentityPoolProviderRequest, Operation>
      deleteWorkloadIdentityPoolProviderCallable() {
    return stub.deleteWorkloadIdentityPoolProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider], as long
   * as it was deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   WorkloadIdentityPoolProviderName name =
   *       WorkloadIdentityPoolProviderName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[WORKLOAD_IDENTITY_POOL]",
   *           "[WORKLOAD_IDENTITY_POOL_PROVIDER]");
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.undeleteWorkloadIdentityPoolProviderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to undelete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderAsync(WorkloadIdentityPoolProviderName name) {
    UndeleteWorkloadIdentityPoolProviderRequest request =
        UndeleteWorkloadIdentityPoolProviderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeleteWorkloadIdentityPoolProviderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider], as long
   * as it was deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   String name =
   *       WorkloadIdentityPoolProviderName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[WORKLOAD_IDENTITY_POOL]",
   *               "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *           .toString();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.undeleteWorkloadIdentityPoolProviderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to undelete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderAsync(String name) {
    UndeleteWorkloadIdentityPoolProviderRequest request =
        UndeleteWorkloadIdentityPoolProviderRequest.newBuilder().setName(name).build();
    return undeleteWorkloadIdentityPoolProviderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider], as long
   * as it was deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UndeleteWorkloadIdentityPoolProviderRequest request =
   *       UndeleteWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolProviderName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKLOAD_IDENTITY_POOL]",
   *                       "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *                   .toString())
   *           .build();
   *   WorkloadIdentityPoolProvider response =
   *       workloadIdentityPoolsClient.undeleteWorkloadIdentityPoolProviderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderAsync(
          UndeleteWorkloadIdentityPoolProviderRequest request) {
    return undeleteWorkloadIdentityPoolProviderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider], as long
   * as it was deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UndeleteWorkloadIdentityPoolProviderRequest request =
   *       UndeleteWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolProviderName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKLOAD_IDENTITY_POOL]",
   *                       "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *                   .toString())
   *           .build();
   *   OperationFuture<WorkloadIdentityPoolProvider, WorkloadIdentityPoolProviderOperationMetadata>
   *       future =
   *           workloadIdentityPoolsClient
   *               .undeleteWorkloadIdentityPoolProviderOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   WorkloadIdentityPoolProvider response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderOperationCallable() {
    return stub.undeleteWorkloadIdentityPoolProviderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider], as long
   * as it was deleted fewer than 30 days ago.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkloadIdentityPoolsClient workloadIdentityPoolsClient =
   *     WorkloadIdentityPoolsClient.create()) {
   *   UndeleteWorkloadIdentityPoolProviderRequest request =
   *       UndeleteWorkloadIdentityPoolProviderRequest.newBuilder()
   *           .setName(
   *               WorkloadIdentityPoolProviderName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKLOAD_IDENTITY_POOL]",
   *                       "[WORKLOAD_IDENTITY_POOL_PROVIDER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       workloadIdentityPoolsClient
   *           .undeleteWorkloadIdentityPoolProviderCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
      undeleteWorkloadIdentityPoolProviderCallable() {
    return stub.undeleteWorkloadIdentityPoolProviderCallable();
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

  public static class ListWorkloadIdentityPoolsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkloadIdentityPoolsRequest,
          ListWorkloadIdentityPoolsResponse,
          WorkloadIdentityPool,
          ListWorkloadIdentityPoolsPage,
          ListWorkloadIdentityPoolsFixedSizeCollection> {

    public static ApiFuture<ListWorkloadIdentityPoolsPagedResponse> createAsync(
        PageContext<
                ListWorkloadIdentityPoolsRequest,
                ListWorkloadIdentityPoolsResponse,
                WorkloadIdentityPool>
            context,
        ApiFuture<ListWorkloadIdentityPoolsResponse> futureResponse) {
      ApiFuture<ListWorkloadIdentityPoolsPage> futurePage =
          ListWorkloadIdentityPoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkloadIdentityPoolsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkloadIdentityPoolsPagedResponse(ListWorkloadIdentityPoolsPage page) {
      super(page, ListWorkloadIdentityPoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkloadIdentityPoolsPage
      extends AbstractPage<
          ListWorkloadIdentityPoolsRequest,
          ListWorkloadIdentityPoolsResponse,
          WorkloadIdentityPool,
          ListWorkloadIdentityPoolsPage> {

    private ListWorkloadIdentityPoolsPage(
        PageContext<
                ListWorkloadIdentityPoolsRequest,
                ListWorkloadIdentityPoolsResponse,
                WorkloadIdentityPool>
            context,
        ListWorkloadIdentityPoolsResponse response) {
      super(context, response);
    }

    private static ListWorkloadIdentityPoolsPage createEmptyPage() {
      return new ListWorkloadIdentityPoolsPage(null, null);
    }

    @Override
    protected ListWorkloadIdentityPoolsPage createPage(
        PageContext<
                ListWorkloadIdentityPoolsRequest,
                ListWorkloadIdentityPoolsResponse,
                WorkloadIdentityPool>
            context,
        ListWorkloadIdentityPoolsResponse response) {
      return new ListWorkloadIdentityPoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkloadIdentityPoolsPage> createPageAsync(
        PageContext<
                ListWorkloadIdentityPoolsRequest,
                ListWorkloadIdentityPoolsResponse,
                WorkloadIdentityPool>
            context,
        ApiFuture<ListWorkloadIdentityPoolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkloadIdentityPoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkloadIdentityPoolsRequest,
          ListWorkloadIdentityPoolsResponse,
          WorkloadIdentityPool,
          ListWorkloadIdentityPoolsPage,
          ListWorkloadIdentityPoolsFixedSizeCollection> {

    private ListWorkloadIdentityPoolsFixedSizeCollection(
        List<ListWorkloadIdentityPoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkloadIdentityPoolsFixedSizeCollection createEmptyCollection() {
      return new ListWorkloadIdentityPoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkloadIdentityPoolsFixedSizeCollection createCollection(
        List<ListWorkloadIdentityPoolsPage> pages, int collectionSize) {
      return new ListWorkloadIdentityPoolsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListWorkloadIdentityPoolProvidersPagedResponse
      extends AbstractPagedListResponse<
          ListWorkloadIdentityPoolProvidersRequest,
          ListWorkloadIdentityPoolProvidersResponse,
          WorkloadIdentityPoolProvider,
          ListWorkloadIdentityPoolProvidersPage,
          ListWorkloadIdentityPoolProvidersFixedSizeCollection> {

    public static ApiFuture<ListWorkloadIdentityPoolProvidersPagedResponse> createAsync(
        PageContext<
                ListWorkloadIdentityPoolProvidersRequest,
                ListWorkloadIdentityPoolProvidersResponse,
                WorkloadIdentityPoolProvider>
            context,
        ApiFuture<ListWorkloadIdentityPoolProvidersResponse> futureResponse) {
      ApiFuture<ListWorkloadIdentityPoolProvidersPage> futurePage =
          ListWorkloadIdentityPoolProvidersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkloadIdentityPoolProvidersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkloadIdentityPoolProvidersPagedResponse(
        ListWorkloadIdentityPoolProvidersPage page) {
      super(page, ListWorkloadIdentityPoolProvidersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkloadIdentityPoolProvidersPage
      extends AbstractPage<
          ListWorkloadIdentityPoolProvidersRequest,
          ListWorkloadIdentityPoolProvidersResponse,
          WorkloadIdentityPoolProvider,
          ListWorkloadIdentityPoolProvidersPage> {

    private ListWorkloadIdentityPoolProvidersPage(
        PageContext<
                ListWorkloadIdentityPoolProvidersRequest,
                ListWorkloadIdentityPoolProvidersResponse,
                WorkloadIdentityPoolProvider>
            context,
        ListWorkloadIdentityPoolProvidersResponse response) {
      super(context, response);
    }

    private static ListWorkloadIdentityPoolProvidersPage createEmptyPage() {
      return new ListWorkloadIdentityPoolProvidersPage(null, null);
    }

    @Override
    protected ListWorkloadIdentityPoolProvidersPage createPage(
        PageContext<
                ListWorkloadIdentityPoolProvidersRequest,
                ListWorkloadIdentityPoolProvidersResponse,
                WorkloadIdentityPoolProvider>
            context,
        ListWorkloadIdentityPoolProvidersResponse response) {
      return new ListWorkloadIdentityPoolProvidersPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkloadIdentityPoolProvidersPage> createPageAsync(
        PageContext<
                ListWorkloadIdentityPoolProvidersRequest,
                ListWorkloadIdentityPoolProvidersResponse,
                WorkloadIdentityPoolProvider>
            context,
        ApiFuture<ListWorkloadIdentityPoolProvidersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkloadIdentityPoolProvidersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkloadIdentityPoolProvidersRequest,
          ListWorkloadIdentityPoolProvidersResponse,
          WorkloadIdentityPoolProvider,
          ListWorkloadIdentityPoolProvidersPage,
          ListWorkloadIdentityPoolProvidersFixedSizeCollection> {

    private ListWorkloadIdentityPoolProvidersFixedSizeCollection(
        List<ListWorkloadIdentityPoolProvidersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkloadIdentityPoolProvidersFixedSizeCollection createEmptyCollection() {
      return new ListWorkloadIdentityPoolProvidersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkloadIdentityPoolProvidersFixedSizeCollection createCollection(
        List<ListWorkloadIdentityPoolProvidersPage> pages, int collectionSize) {
      return new ListWorkloadIdentityPoolProvidersFixedSizeCollection(pages, collectionSize);
    }
  }
}
