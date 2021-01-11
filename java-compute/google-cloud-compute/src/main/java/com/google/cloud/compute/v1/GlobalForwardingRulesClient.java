/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.GlobalForwardingRulesStub;
import com.google.cloud.compute.v1.stub.GlobalForwardingRulesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The GlobalForwardingRules API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
 *   String project = "";
 *   String forwardingRule = "";
 *   Operation response = globalForwardingRulesClient.delete(project, forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the globalForwardingRulesClient object to clean up
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
 * <pre>
 * <code>
 * GlobalForwardingRulesSettings globalForwardingRulesSettings =
 *     GlobalForwardingRulesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalForwardingRulesClient globalForwardingRulesClient =
 *     GlobalForwardingRulesClient.create(globalForwardingRulesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GlobalForwardingRulesSettings globalForwardingRulesSettings =
 *     GlobalForwardingRulesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalForwardingRulesClient globalForwardingRulesClient =
 *     GlobalForwardingRulesClient.create(globalForwardingRulesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * This is for advanced usage - prefer to use GlobalForwardingRulesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GlobalForwardingRulesClient(GlobalForwardingRulesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalForwardingRulesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalForwardingRulesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   String forwardingRule = "";
   *   Operation response = globalForwardingRulesClient.delete(project, forwardingRule);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRule Name of the ForwardingRule resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String forwardingRule) {
    DeleteGlobalForwardingRuleRequest request =
        DeleteGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRule(forwardingRule)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   DeleteGlobalForwardingRuleRequest request = DeleteGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .build();
   *   Operation response = globalForwardingRulesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteGlobalForwardingRuleRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   DeleteGlobalForwardingRuleRequest request = DeleteGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalForwardingRulesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteGlobalForwardingRuleRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   String forwardingRule = "";
   *   ForwardingRule response = globalForwardingRulesClient.get(project, forwardingRule);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   GetGlobalForwardingRuleRequest request = GetGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .build();
   *   ForwardingRule response = globalForwardingRulesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForwardingRule get(GetGlobalForwardingRuleRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   GetGlobalForwardingRuleRequest request = GetGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ForwardingRule&gt; future = globalForwardingRulesClient.getCallable().futureCall(request);
   *   // Do something
   *   ForwardingRule response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGlobalForwardingRuleRequest, ForwardingRule> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response = globalForwardingRulesClient.insert(project, forwardingRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, ForwardingRule forwardingRuleResource) {
    InsertGlobalForwardingRuleRequest request =
        InsertGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   String project = "";
   *   InsertGlobalForwardingRuleRequest request = InsertGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = globalForwardingRulesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertGlobalForwardingRuleRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   String project = "";
   *   InsertGlobalForwardingRuleRequest request = InsertGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalForwardingRulesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertGlobalForwardingRuleRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   for (ForwardingRule element : globalForwardingRulesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListGlobalForwardingRulesRequest request =
        ListGlobalForwardingRulesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   ListGlobalForwardingRulesRequest request = ListGlobalForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (ForwardingRule element : globalForwardingRulesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListGlobalForwardingRulesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   ListGlobalForwardingRulesRequest request = ListGlobalForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = globalForwardingRulesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (ForwardingRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGlobalForwardingRulesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   ListGlobalForwardingRulesRequest request = ListGlobalForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListGlobalForwardingRulesRequest, ForwardingRuleList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   String forwardingRule = "";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response = globalForwardingRulesClient.patch(project, forwardingRule, forwardingRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRule Name of the ForwardingRule resource to patch.
   * @param forwardingRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String forwardingRule, ForwardingRule forwardingRuleResource) {
    PatchGlobalForwardingRuleRequest request =
        PatchGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRule(forwardingRule)
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   String project = "";
   *   PatchGlobalForwardingRuleRequest request = PatchGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = globalForwardingRulesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchGlobalForwardingRuleRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   String project = "";
   *   PatchGlobalForwardingRuleRequest request = PatchGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalForwardingRulesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchGlobalForwardingRuleRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String project = "";
   *   String forwardingRule = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = globalForwardingRulesClient.setTarget(project, forwardingRule, targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRule Name of the ForwardingRule resource in which target is to be set.
   * @param targetReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTarget(
      String project, String forwardingRule, TargetReference targetReferenceResource) {
    SetTargetGlobalForwardingRuleRequest request =
        SetTargetGlobalForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setForwardingRule(forwardingRule)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetTargetGlobalForwardingRuleRequest request = SetTargetGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   Operation response = globalForwardingRulesClient.setTarget(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTarget(SetTargetGlobalForwardingRuleRequest request) {
    return setTargetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetTargetGlobalForwardingRuleRequest request = SetTargetGlobalForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalForwardingRulesClient.setTargetCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
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
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
