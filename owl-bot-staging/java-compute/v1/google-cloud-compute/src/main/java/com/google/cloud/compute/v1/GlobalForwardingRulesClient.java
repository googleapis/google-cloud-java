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

package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.GlobalForwardingRulesStub;
import com.google.cloud.compute.v1.stub.GlobalForwardingRulesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The GlobalForwardingRules API.
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
 * try (GlobalForwardingRulesClient globalForwardingRulesClient =
 *     GlobalForwardingRulesClient.create()) {
 *   String project = "project-309310695";
 *   String forwardingRule = "forwardingRule-1429104743";
 *   ForwardingRule response = globalForwardingRulesClient.get(project, forwardingRule);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GlobalForwardingRulesClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of GlobalForwardingRulesSettings
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
 * GlobalForwardingRulesSettings globalForwardingRulesSettings =
 *     GlobalForwardingRulesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalForwardingRulesClient globalForwardingRulesClient =
 *     GlobalForwardingRulesClient.create(globalForwardingRulesSettings);
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
 * GlobalForwardingRulesSettings globalForwardingRulesSettings =
 *     GlobalForwardingRulesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalForwardingRulesClient globalForwardingRulesClient =
 *     GlobalForwardingRulesClient.create(globalForwardingRulesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GlobalForwardingRulesClient implements BackgroundResource {
  private final GlobalForwardingRulesSettings settings;
  private final GlobalForwardingRulesStub stub;

  /** Constructs an instance of GlobalForwardingRulesClient with default settings. */
  public static final GlobalForwardingRulesClient create() throws IOException {
    return create(GlobalForwardingRulesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalForwardingRulesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GlobalForwardingRulesClient create(GlobalForwardingRulesSettings settings)
      throws IOException {
    return new GlobalForwardingRulesClient(settings);
  }

  /**
   * Constructs an instance of GlobalForwardingRulesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(GlobalForwardingRulesSettings).
   */
  public static final GlobalForwardingRulesClient create(GlobalForwardingRulesStub stub) {
    return new GlobalForwardingRulesClient(stub);
  }

  /**
   * Constructs an instance of GlobalForwardingRulesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GlobalForwardingRulesClient(GlobalForwardingRulesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GlobalForwardingRulesStubSettings) settings.getStubSettings()).createStub();
  }

  protected GlobalForwardingRulesClient(GlobalForwardingRulesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalForwardingRulesSettings getSettings() {
    return settings;
  }

  public GlobalForwardingRulesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   String project = "project-309310695";
   *   String forwardingRule = "forwardingRule-1429104743";
   *   Operation response = globalForwardingRulesClient.deleteAsync(project, forwardingRule).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRule Name of the ForwardingRule resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String forwardingRule) {
    DeleteGlobalForwardingRuleRequest request =
        DeleteGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRule(forwardingRule)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   DeleteGlobalForwardingRuleRequest request =
   *       DeleteGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalForwardingRulesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteGlobalForwardingRuleRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   DeleteGlobalForwardingRuleRequest request =
   *       DeleteGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalForwardingRulesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGlobalForwardingRuleRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   DeleteGlobalForwardingRuleRequest request =
   *       DeleteGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalForwardingRulesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlobalForwardingRuleRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   String project = "project-309310695";
   *   String forwardingRule = "forwardingRule-1429104743";
   *   ForwardingRule response = globalForwardingRulesClient.get(project, forwardingRule);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRule Name of the ForwardingRule resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForwardingRule get(String project, String forwardingRule) {
    GetGlobalForwardingRuleRequest request =
        GetGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRule(forwardingRule)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   GetGlobalForwardingRuleRequest request =
   *       GetGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setProject("project-309310695")
   *           .build();
   *   ForwardingRule response = globalForwardingRulesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForwardingRule get(GetGlobalForwardingRuleRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   GetGlobalForwardingRuleRequest request =
   *       GetGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<ForwardingRule> future =
   *       globalForwardingRulesClient.getCallable().futureCall(request);
   *   // Do something.
   *   ForwardingRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlobalForwardingRuleRequest, ForwardingRule> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   String project = "project-309310695";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response =
   *       globalForwardingRulesClient.insertAsync(project, forwardingRuleResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, ForwardingRule forwardingRuleResource) {
    InsertGlobalForwardingRuleRequest request =
        InsertGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   InsertGlobalForwardingRuleRequest request =
   *       InsertGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRuleResource(ForwardingRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalForwardingRulesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertGlobalForwardingRuleRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   InsertGlobalForwardingRuleRequest request =
   *       InsertGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRuleResource(ForwardingRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalForwardingRulesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertGlobalForwardingRuleRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   InsertGlobalForwardingRuleRequest request =
   *       InsertGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRuleResource(ForwardingRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalForwardingRulesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertGlobalForwardingRuleRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   String project = "project-309310695";
   *   for (ForwardingRule element : globalForwardingRulesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListGlobalForwardingRulesRequest request =
        ListGlobalForwardingRulesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   ListGlobalForwardingRulesRequest request =
   *       ListGlobalForwardingRulesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (ForwardingRule element : globalForwardingRulesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListGlobalForwardingRulesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   ListGlobalForwardingRulesRequest request =
   *       ListGlobalForwardingRulesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<ForwardingRule> future =
   *       globalForwardingRulesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ForwardingRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlobalForwardingRulesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   ListGlobalForwardingRulesRequest request =
   *       ListGlobalForwardingRulesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ForwardingRuleList response = globalForwardingRulesClient.listCallable().call(request);
   *     for (ForwardingRule element : response.getItemsList()) {
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
  public final UnaryCallable<ListGlobalForwardingRulesRequest, ForwardingRuleList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   String project = "project-309310695";
   *   String forwardingRule = "forwardingRule-1429104743";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response =
   *       globalForwardingRulesClient
   *           .patchAsync(project, forwardingRule, forwardingRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRule Name of the ForwardingRule resource to patch.
   * @param forwardingRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String forwardingRule, ForwardingRule forwardingRuleResource) {
    PatchGlobalForwardingRuleRequest request =
        PatchGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRule(forwardingRule)
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   PatchGlobalForwardingRuleRequest request =
   *       PatchGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setForwardingRuleResource(ForwardingRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalForwardingRulesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchGlobalForwardingRuleRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   PatchGlobalForwardingRuleRequest request =
   *       PatchGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setForwardingRuleResource(ForwardingRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalForwardingRulesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchGlobalForwardingRuleRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   PatchGlobalForwardingRuleRequest request =
   *       PatchGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setForwardingRuleResource(ForwardingRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = globalForwardingRulesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchGlobalForwardingRuleRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on the specified resource. To learn more about labels, read the Labeling
   * resources documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource =
   *       GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response =
   *       globalForwardingRulesClient
   *           .setLabelsAsync(project, resource, globalSetLabelsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      String project, String resource, GlobalSetLabelsRequest globalSetLabelsRequestResource) {
    SetLabelsGlobalForwardingRuleRequest request =
        SetLabelsGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on the specified resource. To learn more about labels, read the Labeling
   * resources documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   SetLabelsGlobalForwardingRuleRequest request =
   *       SetLabelsGlobalForwardingRuleRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Operation response = globalForwardingRulesClient.setLabelsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      SetLabelsGlobalForwardingRuleRequest request) {
    return setLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on the specified resource. To learn more about labels, read the Labeling
   * resources documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   SetLabelsGlobalForwardingRuleRequest request =
   *       SetLabelsGlobalForwardingRuleRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalForwardingRulesClient.setLabelsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetLabelsGlobalForwardingRuleRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return stub.setLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on the specified resource. To learn more about labels, read the Labeling
   * resources documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   SetLabelsGlobalForwardingRuleRequest request =
   *       SetLabelsGlobalForwardingRuleRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalForwardingRulesClient.setLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLabelsGlobalForwardingRuleRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   String project = "project-309310695";
   *   String forwardingRule = "forwardingRule-1429104743";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response =
   *       globalForwardingRulesClient
   *           .setTargetAsync(project, forwardingRule, targetReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRule Name of the ForwardingRule resource in which target is to be set.
   * @param targetReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setTargetAsync(
      String project, String forwardingRule, TargetReference targetReferenceResource) {
    SetTargetGlobalForwardingRuleRequest request =
        SetTargetGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRule(forwardingRule)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setTargetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   SetTargetGlobalForwardingRuleRequest request =
   *       SetTargetGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetReferenceResource(TargetReference.newBuilder().build())
   *           .build();
   *   Operation response = globalForwardingRulesClient.setTargetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setTargetAsync(
      SetTargetGlobalForwardingRuleRequest request) {
    return setTargetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   SetTargetGlobalForwardingRuleRequest request =
   *       SetTargetGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetReferenceResource(TargetReference.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalForwardingRulesClient.setTargetOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetTargetGlobalForwardingRuleRequest, Operation, Operation>
      setTargetOperationCallable() {
    return stub.setTargetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalForwardingRulesClient globalForwardingRulesClient =
   *     GlobalForwardingRulesClient.create()) {
   *   SetTargetGlobalForwardingRuleRequest request =
   *       SetTargetGlobalForwardingRuleRequest.newBuilder()
   *           .setForwardingRule("forwardingRule-1429104743")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetReferenceResource(TargetReference.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalForwardingRulesClient.setTargetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetTargetGlobalForwardingRuleRequest, Operation> setTargetCallable() {
    return stub.setTargetCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListGlobalForwardingRulesRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListGlobalForwardingRulesRequest, ForwardingRuleList, ForwardingRule> context,
        ApiFuture<ForwardingRuleList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListGlobalForwardingRulesRequest, ForwardingRuleList, ForwardingRule, ListPage> {

    private ListPage(
        PageContext<ListGlobalForwardingRulesRequest, ForwardingRuleList, ForwardingRule> context,
        ForwardingRuleList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListGlobalForwardingRulesRequest, ForwardingRuleList, ForwardingRule> context,
        ForwardingRuleList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListGlobalForwardingRulesRequest, ForwardingRuleList, ForwardingRule> context,
        ApiFuture<ForwardingRuleList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalForwardingRulesRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
