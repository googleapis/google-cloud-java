/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.compute.v1.stub.GlobalForwardingRuleStub;
import com.google.cloud.compute.v1.stub.GlobalForwardingRuleStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
 *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
 *   Operation response = globalForwardingRuleClient.deleteGlobalForwardingRule(forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the globalForwardingRuleClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of GlobalForwardingRuleSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * GlobalForwardingRuleSettings globalForwardingRuleSettings =
 *     GlobalForwardingRuleSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalForwardingRuleClient globalForwardingRuleClient =
 *     GlobalForwardingRuleClient.create(globalForwardingRuleSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GlobalForwardingRuleSettings globalForwardingRuleSettings =
 *     GlobalForwardingRuleSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalForwardingRuleClient globalForwardingRuleClient =
 *     GlobalForwardingRuleClient.create(globalForwardingRuleSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalForwardingRuleClient implements BackgroundResource {
  private final GlobalForwardingRuleSettings settings;
  private final GlobalForwardingRuleStub stub;

  /** Constructs an instance of GlobalForwardingRuleClient with default settings. */
  public static final GlobalForwardingRuleClient create() throws IOException {
    return create(GlobalForwardingRuleSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalForwardingRuleClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GlobalForwardingRuleClient create(GlobalForwardingRuleSettings settings)
      throws IOException {
    return new GlobalForwardingRuleClient(settings);
  }

  /**
   * Constructs an instance of GlobalForwardingRuleClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use GlobalForwardingRuleSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final GlobalForwardingRuleClient create(GlobalForwardingRuleStub stub) {
    return new GlobalForwardingRuleClient(stub);
  }

  /**
   * Constructs an instance of GlobalForwardingRuleClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GlobalForwardingRuleClient(GlobalForwardingRuleSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GlobalForwardingRuleStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GlobalForwardingRuleClient(GlobalForwardingRuleStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalForwardingRuleSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalForwardingRuleStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   Operation response = globalForwardingRuleClient.deleteGlobalForwardingRule(forwardingRule);
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteGlobalForwardingRule(
      ProjectGlobalForwardingRuleName forwardingRule) {

    DeleteGlobalForwardingRuleHttpRequest request =
        DeleteGlobalForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule == null ? null : forwardingRule.toString())
            .build();
    return deleteGlobalForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   Operation response = globalForwardingRuleClient.deleteGlobalForwardingRule(forwardingRule.toString());
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteGlobalForwardingRule(String forwardingRule) {

    DeleteGlobalForwardingRuleHttpRequest request =
        DeleteGlobalForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule)
            .build();
    return deleteGlobalForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   DeleteGlobalForwardingRuleHttpRequest request = DeleteGlobalForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .build();
   *   Operation response = globalForwardingRuleClient.deleteGlobalForwardingRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteGlobalForwardingRule(DeleteGlobalForwardingRuleHttpRequest request) {
    return deleteGlobalForwardingRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified GlobalForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   DeleteGlobalForwardingRuleHttpRequest request = DeleteGlobalForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalForwardingRuleClient.deleteGlobalForwardingRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteGlobalForwardingRuleHttpRequest, Operation>
      deleteGlobalForwardingRuleCallable() {
    return stub.deleteGlobalForwardingRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   ForwardingRule response = globalForwardingRuleClient.getGlobalForwardingRule(forwardingRule);
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ForwardingRule getGlobalForwardingRule(
      ProjectGlobalForwardingRuleName forwardingRule) {

    GetGlobalForwardingRuleHttpRequest request =
        GetGlobalForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule == null ? null : forwardingRule.toString())
            .build();
    return getGlobalForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   ForwardingRule response = globalForwardingRuleClient.getGlobalForwardingRule(forwardingRule.toString());
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ForwardingRule getGlobalForwardingRule(String forwardingRule) {

    GetGlobalForwardingRuleHttpRequest request =
        GetGlobalForwardingRuleHttpRequest.newBuilder().setForwardingRule(forwardingRule).build();
    return getGlobalForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   GetGlobalForwardingRuleHttpRequest request = GetGlobalForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .build();
   *   ForwardingRule response = globalForwardingRuleClient.getGlobalForwardingRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ForwardingRule getGlobalForwardingRule(GetGlobalForwardingRuleHttpRequest request) {
    return getGlobalForwardingRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   GetGlobalForwardingRuleHttpRequest request = GetGlobalForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .build();
   *   ApiFuture&lt;ForwardingRule&gt; future = globalForwardingRuleClient.getGlobalForwardingRuleCallable().futureCall(request);
   *   // Do something
   *   ForwardingRule response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetGlobalForwardingRuleHttpRequest, ForwardingRule>
      getGlobalForwardingRuleCallable() {
    return stub.getGlobalForwardingRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response = globalForwardingRuleClient.insertGlobalForwardingRule(project, forwardingRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRuleResource A ForwardingRule resource. A ForwardingRule resource specifies
   *     which pool of target virtual machines to forward a packet to if it matches the given
   *     [IPAddress, IPProtocol, ports] tuple. (== resource_for beta.forwardingRules ==) (==
   *     resource_for v1.forwardingRules ==) (== resource_for beta.globalForwardingRules ==) (==
   *     resource_for v1.globalForwardingRules ==) (== resource_for beta.regionForwardingRules ==)
   *     (== resource_for v1.regionForwardingRules ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertGlobalForwardingRule(
      ProjectName project, ForwardingRule forwardingRuleResource) {

    InsertGlobalForwardingRuleHttpRequest request =
        InsertGlobalForwardingRuleHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return insertGlobalForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response = globalForwardingRuleClient.insertGlobalForwardingRule(project.toString(), forwardingRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param forwardingRuleResource A ForwardingRule resource. A ForwardingRule resource specifies
   *     which pool of target virtual machines to forward a packet to if it matches the given
   *     [IPAddress, IPProtocol, ports] tuple. (== resource_for beta.forwardingRules ==) (==
   *     resource_for v1.forwardingRules ==) (== resource_for beta.globalForwardingRules ==) (==
   *     resource_for v1.globalForwardingRules ==) (== resource_for beta.regionForwardingRules ==)
   *     (== resource_for v1.regionForwardingRules ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertGlobalForwardingRule(
      String project, ForwardingRule forwardingRuleResource) {

    InsertGlobalForwardingRuleHttpRequest request =
        InsertGlobalForwardingRuleHttpRequest.newBuilder()
            .setProject(project)
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return insertGlobalForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   InsertGlobalForwardingRuleHttpRequest request = InsertGlobalForwardingRuleHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .build();
   *   Operation response = globalForwardingRuleClient.insertGlobalForwardingRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertGlobalForwardingRule(InsertGlobalForwardingRuleHttpRequest request) {
    return insertGlobalForwardingRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a GlobalForwardingRule resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   InsertGlobalForwardingRuleHttpRequest request = InsertGlobalForwardingRuleHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalForwardingRuleClient.insertGlobalForwardingRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertGlobalForwardingRuleHttpRequest, Operation>
      insertGlobalForwardingRuleCallable() {
    return stub.insertGlobalForwardingRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ForwardingRule element : globalForwardingRuleClient.listGlobalForwardingRules(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalForwardingRulesPagedResponse listGlobalForwardingRules(
      ProjectName project) {
    ListGlobalForwardingRulesHttpRequest request =
        ListGlobalForwardingRulesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listGlobalForwardingRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ForwardingRule element : globalForwardingRuleClient.listGlobalForwardingRules(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalForwardingRulesPagedResponse listGlobalForwardingRules(String project) {
    ListGlobalForwardingRulesHttpRequest request =
        ListGlobalForwardingRulesHttpRequest.newBuilder().setProject(project).build();
    return listGlobalForwardingRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListGlobalForwardingRulesHttpRequest request = ListGlobalForwardingRulesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (ForwardingRule element : globalForwardingRuleClient.listGlobalForwardingRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListGlobalForwardingRulesPagedResponse listGlobalForwardingRules(
      ListGlobalForwardingRulesHttpRequest request) {
    return listGlobalForwardingRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListGlobalForwardingRulesHttpRequest request = ListGlobalForwardingRulesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListGlobalForwardingRulesPagedResponse&gt; future = globalForwardingRuleClient.listGlobalForwardingRulesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ForwardingRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListGlobalForwardingRulesHttpRequest, ListGlobalForwardingRulesPagedResponse>
      listGlobalForwardingRulesPagedCallable() {
    return stub.listGlobalForwardingRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of GlobalForwardingRule resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListGlobalForwardingRulesHttpRequest request = ListGlobalForwardingRulesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     ForwardingRuleList response = globalForwardingRuleClient.listGlobalForwardingRulesCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList>
      listGlobalForwardingRulesCallable() {
    return stub.listGlobalForwardingRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = globalForwardingRuleClient.setTargetGlobalForwardingRule(forwardingRule, targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource in which target is to be set.
   * @param targetReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetGlobalForwardingRule(
      ProjectGlobalForwardingRuleName forwardingRule, TargetReference targetReferenceResource) {

    SetTargetGlobalForwardingRuleHttpRequest request =
        SetTargetGlobalForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule == null ? null : forwardingRule.toString())
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setTargetGlobalForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = globalForwardingRuleClient.setTargetGlobalForwardingRule(forwardingRule.toString(), targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource in which target is to be set.
   * @param targetReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetGlobalForwardingRule(
      String forwardingRule, TargetReference targetReferenceResource) {

    SetTargetGlobalForwardingRuleHttpRequest request =
        SetTargetGlobalForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setTargetGlobalForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetTargetGlobalForwardingRuleHttpRequest request = SetTargetGlobalForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   Operation response = globalForwardingRuleClient.setTargetGlobalForwardingRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetGlobalForwardingRule(
      SetTargetGlobalForwardingRuleHttpRequest request) {
    return setTargetGlobalForwardingRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for the GlobalForwardingRule resource. The new target should be of the same
   * type as the old target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
   *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetTargetGlobalForwardingRuleHttpRequest request = SetTargetGlobalForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalForwardingRuleClient.setTargetGlobalForwardingRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetTargetGlobalForwardingRuleHttpRequest, Operation>
      setTargetGlobalForwardingRuleCallable() {
    return stub.setTargetGlobalForwardingRuleCallable();
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

  public static class ListGlobalForwardingRulesPagedResponse
      extends AbstractPagedListResponse<
          ListGlobalForwardingRulesHttpRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListGlobalForwardingRulesPage,
          ListGlobalForwardingRulesFixedSizeCollection> {

    public static ApiFuture<ListGlobalForwardingRulesPagedResponse> createAsync(
        PageContext<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList, ForwardingRule>
            context,
        ApiFuture<ForwardingRuleList> futureResponse) {
      ApiFuture<ListGlobalForwardingRulesPage> futurePage =
          ListGlobalForwardingRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGlobalForwardingRulesPage, ListGlobalForwardingRulesPagedResponse>() {
            @Override
            public ListGlobalForwardingRulesPagedResponse apply(
                ListGlobalForwardingRulesPage input) {
              return new ListGlobalForwardingRulesPagedResponse(input);
            }
          });
    }

    private ListGlobalForwardingRulesPagedResponse(ListGlobalForwardingRulesPage page) {
      super(page, ListGlobalForwardingRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlobalForwardingRulesPage
      extends AbstractPage<
          ListGlobalForwardingRulesHttpRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListGlobalForwardingRulesPage> {

    private ListGlobalForwardingRulesPage(
        PageContext<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList, ForwardingRule>
            context,
        ForwardingRuleList response) {
      super(context, response);
    }

    private static ListGlobalForwardingRulesPage createEmptyPage() {
      return new ListGlobalForwardingRulesPage(null, null);
    }

    @Override
    protected ListGlobalForwardingRulesPage createPage(
        PageContext<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList, ForwardingRule>
            context,
        ForwardingRuleList response) {
      return new ListGlobalForwardingRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListGlobalForwardingRulesPage> createPageAsync(
        PageContext<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList, ForwardingRule>
            context,
        ApiFuture<ForwardingRuleList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlobalForwardingRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalForwardingRulesHttpRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListGlobalForwardingRulesPage,
          ListGlobalForwardingRulesFixedSizeCollection> {

    private ListGlobalForwardingRulesFixedSizeCollection(
        List<ListGlobalForwardingRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlobalForwardingRulesFixedSizeCollection createEmptyCollection() {
      return new ListGlobalForwardingRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlobalForwardingRulesFixedSizeCollection createCollection(
        List<ListGlobalForwardingRulesPage> pages, int collectionSize) {
      return new ListGlobalForwardingRulesFixedSizeCollection(pages, collectionSize);
    }
  }
}
