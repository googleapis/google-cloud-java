/*
 * Copyright 2019 Google LLC
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
import com.google.cloud.compute.v1.stub.ForwardingRuleStub;
import com.google.cloud.compute.v1.stub.ForwardingRuleStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
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
 * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
 *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
 *   Operation response = forwardingRuleClient.deleteForwardingRule(forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the forwardingRuleClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ForwardingRuleSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ForwardingRuleSettings forwardingRuleSettings =
 *     ForwardingRuleSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ForwardingRuleClient forwardingRuleClient =
 *     ForwardingRuleClient.create(forwardingRuleSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ForwardingRuleSettings forwardingRuleSettings =
 *     ForwardingRuleSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ForwardingRuleClient forwardingRuleClient =
 *     ForwardingRuleClient.create(forwardingRuleSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ForwardingRuleClient implements BackgroundResource {
  private final ForwardingRuleSettings settings;
  private final ForwardingRuleStub stub;

  /** Constructs an instance of ForwardingRuleClient with default settings. */
  public static final ForwardingRuleClient create() throws IOException {
    return create(ForwardingRuleSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ForwardingRuleClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ForwardingRuleClient create(ForwardingRuleSettings settings)
      throws IOException {
    return new ForwardingRuleClient(settings);
  }

  /**
   * Constructs an instance of ForwardingRuleClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use ForwardingRuleSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ForwardingRuleClient create(ForwardingRuleStub stub) {
    return new ForwardingRuleClient(stub);
  }

  /**
   * Constructs an instance of ForwardingRuleClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ForwardingRuleClient(ForwardingRuleSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ForwardingRuleStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ForwardingRuleClient(ForwardingRuleStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ForwardingRuleSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ForwardingRuleStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ForwardingRulesScopedList element : forwardingRuleClient.aggregatedListForwardingRules(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListForwardingRulesPagedResponse aggregatedListForwardingRules(
      ProjectName project) {
    AggregatedListForwardingRulesHttpRequest request =
        AggregatedListForwardingRulesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListForwardingRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ForwardingRulesScopedList element : forwardingRuleClient.aggregatedListForwardingRules(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListForwardingRulesPagedResponse aggregatedListForwardingRules(
      String project) {
    AggregatedListForwardingRulesHttpRequest request =
        AggregatedListForwardingRulesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListForwardingRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListForwardingRulesHttpRequest request = AggregatedListForwardingRulesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (ForwardingRulesScopedList element : forwardingRuleClient.aggregatedListForwardingRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListForwardingRulesPagedResponse aggregatedListForwardingRules(
      AggregatedListForwardingRulesHttpRequest request) {
    return aggregatedListForwardingRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListForwardingRulesHttpRequest request = AggregatedListForwardingRulesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListForwardingRulesPagedResponse&gt; future = forwardingRuleClient.aggregatedListForwardingRulesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ForwardingRulesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListForwardingRulesHttpRequest, AggregatedListForwardingRulesPagedResponse>
      aggregatedListForwardingRulesPagedCallable() {
    return stub.aggregatedListForwardingRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListForwardingRulesHttpRequest request = AggregatedListForwardingRulesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     ForwardingRuleAggregatedList response = forwardingRuleClient.aggregatedListForwardingRulesCallable().call(request);
   *     for (ForwardingRulesScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListForwardingRulesHttpRequest, ForwardingRuleAggregatedList>
      aggregatedListForwardingRulesCallable() {
    return stub.aggregatedListForwardingRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   Operation response = forwardingRuleClient.deleteForwardingRule(forwardingRule);
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteForwardingRule(ProjectRegionForwardingRuleName forwardingRule) {

    DeleteForwardingRuleHttpRequest request =
        DeleteForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule == null ? null : forwardingRule.toString())
            .build();
    return deleteForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   Operation response = forwardingRuleClient.deleteForwardingRule(forwardingRule.toString());
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteForwardingRule(String forwardingRule) {

    DeleteForwardingRuleHttpRequest request =
        DeleteForwardingRuleHttpRequest.newBuilder().setForwardingRule(forwardingRule).build();
    return deleteForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   DeleteForwardingRuleHttpRequest request = DeleteForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .build();
   *   Operation response = forwardingRuleClient.deleteForwardingRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteForwardingRule(DeleteForwardingRuleHttpRequest request) {
    return deleteForwardingRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   DeleteForwardingRuleHttpRequest request = DeleteForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = forwardingRuleClient.deleteForwardingRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteForwardingRuleHttpRequest, Operation>
      deleteForwardingRuleCallable() {
    return stub.deleteForwardingRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   ForwardingRule response = forwardingRuleClient.getForwardingRule(forwardingRule);
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ForwardingRule getForwardingRule(ProjectRegionForwardingRuleName forwardingRule) {

    GetForwardingRuleHttpRequest request =
        GetForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule == null ? null : forwardingRule.toString())
            .build();
    return getForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   ForwardingRule response = forwardingRuleClient.getForwardingRule(forwardingRule.toString());
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ForwardingRule getForwardingRule(String forwardingRule) {

    GetForwardingRuleHttpRequest request =
        GetForwardingRuleHttpRequest.newBuilder().setForwardingRule(forwardingRule).build();
    return getForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   GetForwardingRuleHttpRequest request = GetForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .build();
   *   ForwardingRule response = forwardingRuleClient.getForwardingRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ForwardingRule getForwardingRule(GetForwardingRuleHttpRequest request) {
    return getForwardingRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   GetForwardingRuleHttpRequest request = GetForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .build();
   *   ApiFuture&lt;ForwardingRule&gt; future = forwardingRuleClient.getForwardingRuleCallable().futureCall(request);
   *   // Do something
   *   ForwardingRule response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetForwardingRuleHttpRequest, ForwardingRule>
      getForwardingRuleCallable() {
    return stub.getForwardingRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ForwardingRule resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response = forwardingRuleClient.insertForwardingRule(region, forwardingRuleResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param forwardingRuleResource A ForwardingRule resource. A ForwardingRule resource specifies
   *     which pool of target virtual machines to forward a packet to if it matches the given
   *     [IPAddress, IPProtocol, ports] tuple. (== resource_for beta.forwardingRules ==) (==
   *     resource_for v1.forwardingRules ==) (== resource_for beta.globalForwardingRules ==) (==
   *     resource_for v1.globalForwardingRules ==) (== resource_for beta.regionForwardingRules ==)
   *     (== resource_for v1.regionForwardingRules ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertForwardingRule(
      ProjectRegionName region, ForwardingRule forwardingRuleResource) {

    InsertForwardingRuleHttpRequest request =
        InsertForwardingRuleHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return insertForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ForwardingRule resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response = forwardingRuleClient.insertForwardingRule(region.toString(), forwardingRuleResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param forwardingRuleResource A ForwardingRule resource. A ForwardingRule resource specifies
   *     which pool of target virtual machines to forward a packet to if it matches the given
   *     [IPAddress, IPProtocol, ports] tuple. (== resource_for beta.forwardingRules ==) (==
   *     resource_for v1.forwardingRules ==) (== resource_for beta.globalForwardingRules ==) (==
   *     resource_for v1.globalForwardingRules ==) (== resource_for beta.regionForwardingRules ==)
   *     (== resource_for v1.regionForwardingRules ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertForwardingRule(
      String region, ForwardingRule forwardingRuleResource) {

    InsertForwardingRuleHttpRequest request =
        InsertForwardingRuleHttpRequest.newBuilder()
            .setRegion(region)
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return insertForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ForwardingRule resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   InsertForwardingRuleHttpRequest request = InsertForwardingRuleHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .build();
   *   Operation response = forwardingRuleClient.insertForwardingRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertForwardingRule(InsertForwardingRuleHttpRequest request) {
    return insertForwardingRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ForwardingRule resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   InsertForwardingRuleHttpRequest request = InsertForwardingRuleHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = forwardingRuleClient.insertForwardingRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertForwardingRuleHttpRequest, Operation>
      insertForwardingRuleCallable() {
    return stub.insertForwardingRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (ForwardingRule element : forwardingRuleClient.listForwardingRules(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListForwardingRulesPagedResponse listForwardingRules(ProjectRegionName region) {
    ListForwardingRulesHttpRequest request =
        ListForwardingRulesHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listForwardingRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (ForwardingRule element : forwardingRuleClient.listForwardingRules(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListForwardingRulesPagedResponse listForwardingRules(String region) {
    ListForwardingRulesHttpRequest request =
        ListForwardingRulesHttpRequest.newBuilder().setRegion(region).build();
    return listForwardingRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListForwardingRulesHttpRequest request = ListForwardingRulesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (ForwardingRule element : forwardingRuleClient.listForwardingRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListForwardingRulesPagedResponse listForwardingRules(
      ListForwardingRulesHttpRequest request) {
    return listForwardingRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListForwardingRulesHttpRequest request = ListForwardingRulesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListForwardingRulesPagedResponse&gt; future = forwardingRuleClient.listForwardingRulesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ForwardingRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListForwardingRulesHttpRequest, ListForwardingRulesPagedResponse>
      listForwardingRulesPagedCallable() {
    return stub.listForwardingRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListForwardingRulesHttpRequest request = ListForwardingRulesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     ForwardingRuleList response = forwardingRuleClient.listForwardingRulesCallable().call(request);
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
  public final UnaryCallable<ListForwardingRulesHttpRequest, ForwardingRuleList>
      listForwardingRulesCallable() {
    return stub.listForwardingRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for forwarding rule. The new target should be of the same type as the old
   * target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = forwardingRuleClient.setTargetForwardingRule(forwardingRule, targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource in which target is to be set.
   * @param targetReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetForwardingRule(
      ProjectRegionForwardingRuleName forwardingRule, TargetReference targetReferenceResource) {

    SetTargetForwardingRuleHttpRequest request =
        SetTargetForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule == null ? null : forwardingRule.toString())
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setTargetForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for forwarding rule. The new target should be of the same type as the old
   * target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = forwardingRuleClient.setTargetForwardingRule(forwardingRule.toString(), targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param forwardingRule Name of the ForwardingRule resource in which target is to be set.
   * @param targetReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetForwardingRule(
      String forwardingRule, TargetReference targetReferenceResource) {

    SetTargetForwardingRuleHttpRequest request =
        SetTargetForwardingRuleHttpRequest.newBuilder()
            .setForwardingRule(forwardingRule)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setTargetForwardingRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for forwarding rule. The new target should be of the same type as the old
   * target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetTargetForwardingRuleHttpRequest request = SetTargetForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   Operation response = forwardingRuleClient.setTargetForwardingRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetForwardingRule(SetTargetForwardingRuleHttpRequest request) {
    return setTargetForwardingRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for forwarding rule. The new target should be of the same type as the old
   * target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
   *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetTargetForwardingRuleHttpRequest request = SetTargetForwardingRuleHttpRequest.newBuilder()
   *     .setForwardingRule(forwardingRule.toString())
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = forwardingRuleClient.setTargetForwardingRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetTargetForwardingRuleHttpRequest, Operation>
      setTargetForwardingRuleCallable() {
    return stub.setTargetForwardingRuleCallable();
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

  public static class AggregatedListForwardingRulesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListForwardingRulesHttpRequest,
          ForwardingRuleAggregatedList,
          ForwardingRulesScopedList,
          AggregatedListForwardingRulesPage,
          AggregatedListForwardingRulesFixedSizeCollection> {

    public static ApiFuture<AggregatedListForwardingRulesPagedResponse> createAsync(
        PageContext<
                AggregatedListForwardingRulesHttpRequest,
                ForwardingRuleAggregatedList,
                ForwardingRulesScopedList>
            context,
        ApiFuture<ForwardingRuleAggregatedList> futureResponse) {
      ApiFuture<AggregatedListForwardingRulesPage> futurePage =
          AggregatedListForwardingRulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListForwardingRulesPage, AggregatedListForwardingRulesPagedResponse>() {
            @Override
            public AggregatedListForwardingRulesPagedResponse apply(
                AggregatedListForwardingRulesPage input) {
              return new AggregatedListForwardingRulesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListForwardingRulesPagedResponse(AggregatedListForwardingRulesPage page) {
      super(page, AggregatedListForwardingRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListForwardingRulesPage
      extends AbstractPage<
          AggregatedListForwardingRulesHttpRequest,
          ForwardingRuleAggregatedList,
          ForwardingRulesScopedList,
          AggregatedListForwardingRulesPage> {

    private AggregatedListForwardingRulesPage(
        PageContext<
                AggregatedListForwardingRulesHttpRequest,
                ForwardingRuleAggregatedList,
                ForwardingRulesScopedList>
            context,
        ForwardingRuleAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListForwardingRulesPage createEmptyPage() {
      return new AggregatedListForwardingRulesPage(null, null);
    }

    @Override
    protected AggregatedListForwardingRulesPage createPage(
        PageContext<
                AggregatedListForwardingRulesHttpRequest,
                ForwardingRuleAggregatedList,
                ForwardingRulesScopedList>
            context,
        ForwardingRuleAggregatedList response) {
      return new AggregatedListForwardingRulesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListForwardingRulesPage> createPageAsync(
        PageContext<
                AggregatedListForwardingRulesHttpRequest,
                ForwardingRuleAggregatedList,
                ForwardingRulesScopedList>
            context,
        ApiFuture<ForwardingRuleAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListForwardingRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListForwardingRulesHttpRequest,
          ForwardingRuleAggregatedList,
          ForwardingRulesScopedList,
          AggregatedListForwardingRulesPage,
          AggregatedListForwardingRulesFixedSizeCollection> {

    private AggregatedListForwardingRulesFixedSizeCollection(
        List<AggregatedListForwardingRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListForwardingRulesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListForwardingRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListForwardingRulesFixedSizeCollection createCollection(
        List<AggregatedListForwardingRulesPage> pages, int collectionSize) {
      return new AggregatedListForwardingRulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListForwardingRulesPagedResponse
      extends AbstractPagedListResponse<
          ListForwardingRulesHttpRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListForwardingRulesPage,
          ListForwardingRulesFixedSizeCollection> {

    public static ApiFuture<ListForwardingRulesPagedResponse> createAsync(
        PageContext<ListForwardingRulesHttpRequest, ForwardingRuleList, ForwardingRule> context,
        ApiFuture<ForwardingRuleList> futureResponse) {
      ApiFuture<ListForwardingRulesPage> futurePage =
          ListForwardingRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListForwardingRulesPage, ListForwardingRulesPagedResponse>() {
            @Override
            public ListForwardingRulesPagedResponse apply(ListForwardingRulesPage input) {
              return new ListForwardingRulesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListForwardingRulesPagedResponse(ListForwardingRulesPage page) {
      super(page, ListForwardingRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListForwardingRulesPage
      extends AbstractPage<
          ListForwardingRulesHttpRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListForwardingRulesPage> {

    private ListForwardingRulesPage(
        PageContext<ListForwardingRulesHttpRequest, ForwardingRuleList, ForwardingRule> context,
        ForwardingRuleList response) {
      super(context, response);
    }

    private static ListForwardingRulesPage createEmptyPage() {
      return new ListForwardingRulesPage(null, null);
    }

    @Override
    protected ListForwardingRulesPage createPage(
        PageContext<ListForwardingRulesHttpRequest, ForwardingRuleList, ForwardingRule> context,
        ForwardingRuleList response) {
      return new ListForwardingRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListForwardingRulesPage> createPageAsync(
        PageContext<ListForwardingRulesHttpRequest, ForwardingRuleList, ForwardingRule> context,
        ApiFuture<ForwardingRuleList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListForwardingRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListForwardingRulesHttpRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListForwardingRulesPage,
          ListForwardingRulesFixedSizeCollection> {

    private ListForwardingRulesFixedSizeCollection(
        List<ListForwardingRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListForwardingRulesFixedSizeCollection createEmptyCollection() {
      return new ListForwardingRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListForwardingRulesFixedSizeCollection createCollection(
        List<ListForwardingRulesPage> pages, int collectionSize) {
      return new ListForwardingRulesFixedSizeCollection(pages, collectionSize);
    }
  }
}
