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

package com.google.appengine.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.firewall.FirewallRule;
import com.google.appengine.v1.stub.FirewallStub;
import com.google.appengine.v1.stub.FirewallStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Firewall resources are used to define a collection of access control rules
 * for an Application. Each rule is defined with a position which specifies the rule's order in the
 * sequence of rules, an IP range to be matched against requests, and an action to take upon
 * matching requests.
 *
 * <p>Every request is evaluated against the Firewall rules in priority order. Processesing stops at
 * the first rule which matches the request's IP address. A final rule always specifies an action
 * that applies to all remaining IP addresses. The default final rule for a newly-created
 * application will be set to "allow" if not otherwise specified by the user.
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
 * try (FirewallClient firewallClient = FirewallClient.create()) {
 *   BatchUpdateIngressRulesRequest request =
 *       BatchUpdateIngressRulesRequest.newBuilder()
 *           .setName("name3373707")
 *           .addAllIngressRules(new ArrayList<FirewallRule>())
 *           .build();
 *   BatchUpdateIngressRulesResponse response = firewallClient.batchUpdateIngressRules(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FirewallClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of FirewallSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirewallSettings firewallSettings =
 *     FirewallSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirewallClient firewallClient = FirewallClient.create(firewallSettings);
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
 * FirewallSettings firewallSettings =
 *     FirewallSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirewallClient firewallClient = FirewallClient.create(firewallSettings);
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
 * FirewallSettings firewallSettings = FirewallSettings.newHttpJsonBuilder().build();
 * FirewallClient firewallClient = FirewallClient.create(firewallSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FirewallClient implements BackgroundResource {
  private final FirewallSettings settings;
  private final FirewallStub stub;

  /** Constructs an instance of FirewallClient with default settings. */
  public static final FirewallClient create() throws IOException {
    return create(FirewallSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FirewallClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FirewallClient create(FirewallSettings settings) throws IOException {
    return new FirewallClient(settings);
  }

  /**
   * Constructs an instance of FirewallClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(FirewallSettings).
   */
  public static final FirewallClient create(FirewallStub stub) {
    return new FirewallClient(stub);
  }

  /**
   * Constructs an instance of FirewallClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected FirewallClient(FirewallSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FirewallStubSettings) settings.getStubSettings()).createStub();
  }

  protected FirewallClient(FirewallStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FirewallSettings getSettings() {
    return settings;
  }

  public FirewallStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the firewall rules of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ListIngressRulesRequest request =
   *       ListIngressRulesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMatchingAddress("matchingAddress861962551")
   *           .build();
   *   for (FirewallRule element : firewallClient.listIngressRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIngressRulesPagedResponse listIngressRules(ListIngressRulesRequest request) {
    return listIngressRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the firewall rules of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ListIngressRulesRequest request =
   *       ListIngressRulesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMatchingAddress("matchingAddress861962551")
   *           .build();
   *   ApiFuture<FirewallRule> future =
   *       firewallClient.listIngressRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FirewallRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIngressRulesRequest, ListIngressRulesPagedResponse>
      listIngressRulesPagedCallable() {
    return stub.listIngressRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the firewall rules of an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ListIngressRulesRequest request =
   *       ListIngressRulesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMatchingAddress("matchingAddress861962551")
   *           .build();
   *   while (true) {
   *     ListIngressRulesResponse response = firewallClient.listIngressRulesCallable().call(request);
   *     for (FirewallRule element : response.getIngressRulesList()) {
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
  public final UnaryCallable<ListIngressRulesRequest, ListIngressRulesResponse>
      listIngressRulesCallable() {
    return stub.listIngressRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces the entire firewall ruleset in one bulk operation. This overrides and replaces the
   * rules of an existing firewall with the new rules.
   *
   * <p>If the final rule does not match traffic with the '&#42;' wildcard IP range, then an "allow
   * all" rule is explicitly added to the end of the list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   BatchUpdateIngressRulesRequest request =
   *       BatchUpdateIngressRulesRequest.newBuilder()
   *           .setName("name3373707")
   *           .addAllIngressRules(new ArrayList<FirewallRule>())
   *           .build();
   *   BatchUpdateIngressRulesResponse response = firewallClient.batchUpdateIngressRules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateIngressRulesResponse batchUpdateIngressRules(
      BatchUpdateIngressRulesRequest request) {
    return batchUpdateIngressRulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces the entire firewall ruleset in one bulk operation. This overrides and replaces the
   * rules of an existing firewall with the new rules.
   *
   * <p>If the final rule does not match traffic with the '&#42;' wildcard IP range, then an "allow
   * all" rule is explicitly added to the end of the list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   BatchUpdateIngressRulesRequest request =
   *       BatchUpdateIngressRulesRequest.newBuilder()
   *           .setName("name3373707")
   *           .addAllIngressRules(new ArrayList<FirewallRule>())
   *           .build();
   *   ApiFuture<BatchUpdateIngressRulesResponse> future =
   *       firewallClient.batchUpdateIngressRulesCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateIngressRulesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesCallable() {
    return stub.batchUpdateIngressRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a firewall rule for the application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   CreateIngressRuleRequest request =
   *       CreateIngressRuleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setRule(FirewallRule.newBuilder().build())
   *           .build();
   *   FirewallRule response = firewallClient.createIngressRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallRule createIngressRule(CreateIngressRuleRequest request) {
    return createIngressRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a firewall rule for the application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   CreateIngressRuleRequest request =
   *       CreateIngressRuleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setRule(FirewallRule.newBuilder().build())
   *           .build();
   *   ApiFuture<FirewallRule> future =
   *       firewallClient.createIngressRuleCallable().futureCall(request);
   *   // Do something.
   *   FirewallRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIngressRuleRequest, FirewallRule> createIngressRuleCallable() {
    return stub.createIngressRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified firewall rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   GetIngressRuleRequest request =
   *       GetIngressRuleRequest.newBuilder().setName("name3373707").build();
   *   FirewallRule response = firewallClient.getIngressRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallRule getIngressRule(GetIngressRuleRequest request) {
    return getIngressRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified firewall rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   GetIngressRuleRequest request =
   *       GetIngressRuleRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<FirewallRule> future = firewallClient.getIngressRuleCallable().futureCall(request);
   *   // Do something.
   *   FirewallRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIngressRuleRequest, FirewallRule> getIngressRuleCallable() {
    return stub.getIngressRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified firewall rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   UpdateIngressRuleRequest request =
   *       UpdateIngressRuleRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRule(FirewallRule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   FirewallRule response = firewallClient.updateIngressRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallRule updateIngressRule(UpdateIngressRuleRequest request) {
    return updateIngressRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified firewall rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   UpdateIngressRuleRequest request =
   *       UpdateIngressRuleRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRule(FirewallRule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<FirewallRule> future =
   *       firewallClient.updateIngressRuleCallable().futureCall(request);
   *   // Do something.
   *   FirewallRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleCallable() {
    return stub.updateIngressRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified firewall rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   DeleteIngressRuleRequest request =
   *       DeleteIngressRuleRequest.newBuilder().setName("name3373707").build();
   *   firewallClient.deleteIngressRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIngressRule(DeleteIngressRuleRequest request) {
    deleteIngressRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified firewall rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   DeleteIngressRuleRequest request =
   *       DeleteIngressRuleRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future = firewallClient.deleteIngressRuleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIngressRuleRequest, Empty> deleteIngressRuleCallable() {
    return stub.deleteIngressRuleCallable();
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

  public static class ListIngressRulesPagedResponse
      extends AbstractPagedListResponse<
          ListIngressRulesRequest,
          ListIngressRulesResponse,
          FirewallRule,
          ListIngressRulesPage,
          ListIngressRulesFixedSizeCollection> {

    public static ApiFuture<ListIngressRulesPagedResponse> createAsync(
        PageContext<ListIngressRulesRequest, ListIngressRulesResponse, FirewallRule> context,
        ApiFuture<ListIngressRulesResponse> futureResponse) {
      ApiFuture<ListIngressRulesPage> futurePage =
          ListIngressRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIngressRulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIngressRulesPagedResponse(ListIngressRulesPage page) {
      super(page, ListIngressRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIngressRulesPage
      extends AbstractPage<
          ListIngressRulesRequest, ListIngressRulesResponse, FirewallRule, ListIngressRulesPage> {

    private ListIngressRulesPage(
        PageContext<ListIngressRulesRequest, ListIngressRulesResponse, FirewallRule> context,
        ListIngressRulesResponse response) {
      super(context, response);
    }

    private static ListIngressRulesPage createEmptyPage() {
      return new ListIngressRulesPage(null, null);
    }

    @Override
    protected ListIngressRulesPage createPage(
        PageContext<ListIngressRulesRequest, ListIngressRulesResponse, FirewallRule> context,
        ListIngressRulesResponse response) {
      return new ListIngressRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListIngressRulesPage> createPageAsync(
        PageContext<ListIngressRulesRequest, ListIngressRulesResponse, FirewallRule> context,
        ApiFuture<ListIngressRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIngressRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIngressRulesRequest,
          ListIngressRulesResponse,
          FirewallRule,
          ListIngressRulesPage,
          ListIngressRulesFixedSizeCollection> {

    private ListIngressRulesFixedSizeCollection(
        List<ListIngressRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIngressRulesFixedSizeCollection createEmptyCollection() {
      return new ListIngressRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIngressRulesFixedSizeCollection createCollection(
        List<ListIngressRulesPage> pages, int collectionSize) {
      return new ListIngressRulesFixedSizeCollection(pages, collectionSize);
    }
  }
}
