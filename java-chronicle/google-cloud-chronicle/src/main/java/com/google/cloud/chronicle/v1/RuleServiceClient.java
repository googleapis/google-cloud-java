/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.RuleServiceStub;
import com.google.cloud.chronicle.v1.stub.RuleServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: RuleService provides interface for user-created rules.
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
 * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Rule rule = Rule.newBuilder().build();
 *   Rule response = ruleServiceClient.createRule(parent, rule);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RuleServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRule</td>
 *      <td><p> Creates a new Rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRule(CreateRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRule(InstanceName parent, Rule rule)
 *           <li><p> createRule(String parent, Rule rule)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRule</td>
 *      <td><p> Gets a Rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRule(GetRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRule(RuleName name)
 *           <li><p> getRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRules</td>
 *      <td><p> Lists Rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRules(ListRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRules(InstanceName parent)
 *           <li><p> listRules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRulesPagedCallable()
 *           <li><p> listRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRule</td>
 *      <td><p> Updates a Rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRule(UpdateRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRule(Rule rule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRule</td>
 *      <td><p> Deletes a Rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRule(DeleteRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRule(RuleName name)
 *           <li><p> deleteRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRuleRevisions</td>
 *      <td><p> Lists all revisions of the rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRuleRevisions(ListRuleRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRuleRevisions(RuleName name)
 *           <li><p> listRuleRevisions(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRuleRevisionsPagedCallable()
 *           <li><p> listRuleRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRetrohunt</td>
 *      <td><p> Create a Retrohunt.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRetrohuntAsync(CreateRetrohuntRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRetrohuntAsync(RuleName parent, Retrohunt retrohunt)
 *           <li><p> createRetrohuntAsync(String parent, Retrohunt retrohunt)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRetrohuntOperationCallable()
 *           <li><p> createRetrohuntCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRetrohunt</td>
 *      <td><p> Get a Retrohunt.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRetrohunt(GetRetrohuntRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRetrohunt(RetrohuntName name)
 *           <li><p> getRetrohunt(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRetrohuntCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRetrohunts</td>
 *      <td><p> List Retrohunts.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRetrohunts(ListRetrohuntsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRetrohunts(RuleName parent)
 *           <li><p> listRetrohunts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRetrohuntsPagedCallable()
 *           <li><p> listRetrohuntsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRuleDeployment</td>
 *      <td><p> Gets a RuleDeployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRuleDeployment(GetRuleDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRuleDeployment(RuleDeploymentName name)
 *           <li><p> getRuleDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRuleDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRuleDeployments</td>
 *      <td><p> Lists RuleDeployments across all Rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRuleDeployments(ListRuleDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRuleDeployments(RuleName parent)
 *           <li><p> listRuleDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRuleDeploymentsPagedCallable()
 *           <li><p> listRuleDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRuleDeployment</td>
 *      <td><p> Updates a RuleDeployment. Failures are not necessarily atomic. If there is a request to update multiple fields, and any update to a single field fails, an error will be returned, but other fields may remain successfully updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRuleDeployment(UpdateRuleDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRuleDeployment(RuleDeployment ruleDeployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRuleDeploymentCallable()
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
 * <p>This class can be customized by passing in a custom instance of RuleServiceSettings to
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
 * RuleServiceSettings ruleServiceSettings =
 *     RuleServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RuleServiceClient ruleServiceClient = RuleServiceClient.create(ruleServiceSettings);
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
 * RuleServiceSettings ruleServiceSettings =
 *     RuleServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RuleServiceClient ruleServiceClient = RuleServiceClient.create(ruleServiceSettings);
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
 * RuleServiceSettings ruleServiceSettings = RuleServiceSettings.newHttpJsonBuilder().build();
 * RuleServiceClient ruleServiceClient = RuleServiceClient.create(ruleServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RuleServiceClient implements BackgroundResource {
  private final RuleServiceSettings settings;
  private final RuleServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of RuleServiceClient with default settings. */
  public static final RuleServiceClient create() throws IOException {
    return create(RuleServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RuleServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RuleServiceClient create(RuleServiceSettings settings) throws IOException {
    return new RuleServiceClient(settings);
  }

  /**
   * Constructs an instance of RuleServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RuleServiceSettings).
   */
  public static final RuleServiceClient create(RuleServiceStub stub) {
    return new RuleServiceClient(stub);
  }

  /**
   * Constructs an instance of RuleServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RuleServiceClient(RuleServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RuleServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected RuleServiceClient(RuleServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final RuleServiceSettings getSettings() {
    return settings;
  }

  public RuleServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Rule rule = Rule.newBuilder().build();
   *   Rule response = ruleServiceClient.createRule(parent, rule);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this rule will be created. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @param rule Required. The rule to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule createRule(InstanceName parent, Rule rule) {
    CreateRuleRequest request =
        CreateRuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRule(rule)
            .build();
    return createRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Rule rule = Rule.newBuilder().build();
   *   Rule response = ruleServiceClient.createRule(parent, rule);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this rule will be created. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @param rule Required. The rule to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule createRule(String parent, Rule rule) {
    CreateRuleRequest request =
        CreateRuleRequest.newBuilder().setParent(parent).setRule(rule).build();
    return createRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   CreateRuleRequest request =
   *       CreateRuleRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRule(Rule.newBuilder().build())
   *           .build();
   *   Rule response = ruleServiceClient.createRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule createRule(CreateRuleRequest request) {
    return createRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   CreateRuleRequest request =
   *       CreateRuleRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRule(Rule.newBuilder().build())
   *           .build();
   *   ApiFuture<Rule> future = ruleServiceClient.createRuleCallable().futureCall(request);
   *   // Do something.
   *   Rule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRuleRequest, Rule> createRuleCallable() {
    return stub.createRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
   *   Rule response = ruleServiceClient.getRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule getRule(RuleName name) {
    GetRuleRequest request =
        GetRuleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString();
   *   Rule response = ruleServiceClient.getRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule getRule(String name) {
    GetRuleRequest request = GetRuleRequest.newBuilder().setName(name).build();
    return getRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   GetRuleRequest request =
   *       GetRuleRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setView(RuleView.forNumber(0))
   *           .build();
   *   Rule response = ruleServiceClient.getRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule getRule(GetRuleRequest request) {
    return getRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   GetRuleRequest request =
   *       GetRuleRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setView(RuleView.forNumber(0))
   *           .build();
   *   ApiFuture<Rule> future = ruleServiceClient.getRuleCallable().futureCall(request);
   *   // Do something.
   *   Rule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleRequest, Rule> getRuleCallable() {
    return stub.getRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (Rule element : ruleServiceClient.listRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of rules. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesPagedResponse listRules(InstanceName parent) {
    ListRulesRequest request =
        ListRulesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (Rule element : ruleServiceClient.listRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of rules. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesPagedResponse listRules(String parent) {
    ListRulesRequest request = ListRulesRequest.newBuilder().setParent(parent).build();
    return listRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRulesRequest request =
   *       ListRulesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RuleView.forNumber(0))
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Rule element : ruleServiceClient.listRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRulesPagedResponse listRules(ListRulesRequest request) {
    return listRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRulesRequest request =
   *       ListRulesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RuleView.forNumber(0))
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Rule> future = ruleServiceClient.listRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Rule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRulesRequest, ListRulesPagedResponse> listRulesPagedCallable() {
    return stub.listRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRulesRequest request =
   *       ListRulesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RuleView.forNumber(0))
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListRulesResponse response = ruleServiceClient.listRulesCallable().call(request);
   *     for (Rule element : response.getRulesList()) {
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
  public final UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    return stub.listRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   Rule rule = Rule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Rule response = ruleServiceClient.updateRule(rule, updateMask);
   * }
   * }</pre>
   *
   * @param rule Required. The rule to update.
   *     <p>The rule's `name` field is used to identify the rule to update. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @param updateMask The list of fields to update. If not included, all fields with a non-empty
   *     value will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule updateRule(Rule rule, FieldMask updateMask) {
    UpdateRuleRequest request =
        UpdateRuleRequest.newBuilder().setRule(rule).setUpdateMask(updateMask).build();
    return updateRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   UpdateRuleRequest request =
   *       UpdateRuleRequest.newBuilder()
   *           .setRule(Rule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Rule response = ruleServiceClient.updateRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rule updateRule(UpdateRuleRequest request) {
    return updateRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   UpdateRuleRequest request =
   *       UpdateRuleRequest.newBuilder()
   *           .setRule(Rule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Rule> future = ruleServiceClient.updateRuleCallable().futureCall(request);
   *   // Do something.
   *   Rule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRuleRequest, Rule> updateRuleCallable() {
    return stub.updateRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
   *   ruleServiceClient.deleteRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to delete. A rule revision timestamp cannot be
   *     specified as part of the name, as deleting specific revisions is not supported. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRule(RuleName name) {
    DeleteRuleRequest request =
        DeleteRuleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString();
   *   ruleServiceClient.deleteRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to delete. A rule revision timestamp cannot be
   *     specified as part of the name, as deleting specific revisions is not supported. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRule(String name) {
    DeleteRuleRequest request = DeleteRuleRequest.newBuilder().setName(name).build();
    deleteRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   DeleteRuleRequest request =
   *       DeleteRuleRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setForce(true)
   *           .build();
   *   ruleServiceClient.deleteRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRule(DeleteRuleRequest request) {
    deleteRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   DeleteRuleRequest request =
   *       DeleteRuleRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = ruleServiceClient.deleteRuleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRuleRequest, Empty> deleteRuleCallable() {
    return stub.deleteRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of the rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
   *   for (Rule element : ruleServiceClient.listRuleRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to list revisions for. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleRevisionsPagedResponse listRuleRevisions(RuleName name) {
    ListRuleRevisionsRequest request =
        ListRuleRevisionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listRuleRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of the rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString();
   *   for (Rule element : ruleServiceClient.listRuleRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule to list revisions for. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleRevisionsPagedResponse listRuleRevisions(String name) {
    ListRuleRevisionsRequest request = ListRuleRevisionsRequest.newBuilder().setName(name).build();
    return listRuleRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of the rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRuleRevisionsRequest request =
   *       ListRuleRevisionsRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RuleView.forNumber(0))
   *           .build();
   *   for (Rule element : ruleServiceClient.listRuleRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleRevisionsPagedResponse listRuleRevisions(ListRuleRevisionsRequest request) {
    return listRuleRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of the rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRuleRevisionsRequest request =
   *       ListRuleRevisionsRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RuleView.forNumber(0))
   *           .build();
   *   ApiFuture<Rule> future =
   *       ruleServiceClient.listRuleRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Rule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsPagedResponse>
      listRuleRevisionsPagedCallable() {
    return stub.listRuleRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions of the rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRuleRevisionsRequest request =
   *       ListRuleRevisionsRequest.newBuilder()
   *           .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(RuleView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListRuleRevisionsResponse response =
   *         ruleServiceClient.listRuleRevisionsCallable().call(request);
   *     for (Rule element : response.getRulesList()) {
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
  public final UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
      listRuleRevisionsCallable() {
    return stub.listRuleRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
   *   Retrohunt retrohunt = Retrohunt.newBuilder().build();
   *   Retrohunt response = ruleServiceClient.createRetrohuntAsync(parent, retrohunt).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of retrohunt, which is a rule. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @param retrohunt Required. The retrohunt to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Retrohunt, RetrohuntMetadata> createRetrohuntAsync(
      RuleName parent, Retrohunt retrohunt) {
    CreateRetrohuntRequest request =
        CreateRetrohuntRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRetrohunt(retrohunt)
            .build();
    return createRetrohuntAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString();
   *   Retrohunt retrohunt = Retrohunt.newBuilder().build();
   *   Retrohunt response = ruleServiceClient.createRetrohuntAsync(parent, retrohunt).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of retrohunt, which is a rule. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @param retrohunt Required. The retrohunt to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Retrohunt, RetrohuntMetadata> createRetrohuntAsync(
      String parent, Retrohunt retrohunt) {
    CreateRetrohuntRequest request =
        CreateRetrohuntRequest.newBuilder().setParent(parent).setRetrohunt(retrohunt).build();
    return createRetrohuntAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   CreateRetrohuntRequest request =
   *       CreateRetrohuntRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setRetrohunt(Retrohunt.newBuilder().build())
   *           .build();
   *   Retrohunt response = ruleServiceClient.createRetrohuntAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Retrohunt, RetrohuntMetadata> createRetrohuntAsync(
      CreateRetrohuntRequest request) {
    return createRetrohuntOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   CreateRetrohuntRequest request =
   *       CreateRetrohuntRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setRetrohunt(Retrohunt.newBuilder().build())
   *           .build();
   *   OperationFuture<Retrohunt, RetrohuntMetadata> future =
   *       ruleServiceClient.createRetrohuntOperationCallable().futureCall(request);
   *   // Do something.
   *   Retrohunt response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationCallable() {
    return stub.createRetrohuntOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   CreateRetrohuntRequest request =
   *       CreateRetrohuntRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setRetrohunt(Retrohunt.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = ruleServiceClient.createRetrohuntCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRetrohuntRequest, Operation> createRetrohuntCallable() {
    return stub.createRetrohuntCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RetrohuntName name =
   *       RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]");
   *   Retrohunt response = ruleServiceClient.getRetrohunt(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the retrohunt to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}/retrohunts/{retrohunt}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Retrohunt getRetrohunt(RetrohuntName name) {
    GetRetrohuntRequest request =
        GetRetrohuntRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRetrohunt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String name =
   *       RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]")
   *           .toString();
   *   Retrohunt response = ruleServiceClient.getRetrohunt(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the retrohunt to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}/retrohunts/{retrohunt}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Retrohunt getRetrohunt(String name) {
    GetRetrohuntRequest request = GetRetrohuntRequest.newBuilder().setName(name).build();
    return getRetrohunt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   GetRetrohuntRequest request =
   *       GetRetrohuntRequest.newBuilder()
   *           .setName(
   *               RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]")
   *                   .toString())
   *           .build();
   *   Retrohunt response = ruleServiceClient.getRetrohunt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Retrohunt getRetrohunt(GetRetrohuntRequest request) {
    return getRetrohuntCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a Retrohunt.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   GetRetrohuntRequest request =
   *       GetRetrohuntRequest.newBuilder()
   *           .setName(
   *               RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Retrohunt> future = ruleServiceClient.getRetrohuntCallable().futureCall(request);
   *   // Do something.
   *   Retrohunt response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRetrohuntRequest, Retrohunt> getRetrohuntCallable() {
    return stub.getRetrohuntCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Retrohunts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
   *   for (Retrohunt element : ruleServiceClient.listRetrohunts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The rule that the retrohunts belong to. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRetrohuntsPagedResponse listRetrohunts(RuleName parent) {
    ListRetrohuntsRequest request =
        ListRetrohuntsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRetrohunts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Retrohunts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString();
   *   for (Retrohunt element : ruleServiceClient.listRetrohunts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The rule that the retrohunts belong to. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRetrohuntsPagedResponse listRetrohunts(String parent) {
    ListRetrohuntsRequest request = ListRetrohuntsRequest.newBuilder().setParent(parent).build();
    return listRetrohunts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Retrohunts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRetrohuntsRequest request =
   *       ListRetrohuntsRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Retrohunt element : ruleServiceClient.listRetrohunts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRetrohuntsPagedResponse listRetrohunts(ListRetrohuntsRequest request) {
    return listRetrohuntsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Retrohunts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRetrohuntsRequest request =
   *       ListRetrohuntsRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Retrohunt> future =
   *       ruleServiceClient.listRetrohuntsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Retrohunt element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsPagedResponse>
      listRetrohuntsPagedCallable() {
    return stub.listRetrohuntsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Retrohunts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRetrohuntsRequest request =
   *       ListRetrohuntsRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListRetrohuntsResponse response = ruleServiceClient.listRetrohuntsCallable().call(request);
   *     for (Retrohunt element : response.getRetrohuntsList()) {
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
  public final UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsResponse>
      listRetrohuntsCallable() {
    return stub.listRetrohuntsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RuleDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RuleDeploymentName name =
   *       RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
   *   RuleDeployment response = ruleServiceClient.getRuleDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule deployment to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}/deployment`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleDeployment getRuleDeployment(RuleDeploymentName name) {
    GetRuleDeploymentRequest request =
        GetRuleDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRuleDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RuleDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String name =
   *       RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString();
   *   RuleDeployment response = ruleServiceClient.getRuleDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule deployment to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}/deployment`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleDeployment getRuleDeployment(String name) {
    GetRuleDeploymentRequest request = GetRuleDeploymentRequest.newBuilder().setName(name).build();
    return getRuleDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RuleDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   GetRuleDeploymentRequest request =
   *       GetRuleDeploymentRequest.newBuilder()
   *           .setName(
   *               RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]")
   *                   .toString())
   *           .build();
   *   RuleDeployment response = ruleServiceClient.getRuleDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleDeployment getRuleDeployment(GetRuleDeploymentRequest request) {
    return getRuleDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RuleDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   GetRuleDeploymentRequest request =
   *       GetRuleDeploymentRequest.newBuilder()
   *           .setName(
   *               RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RuleDeployment> future =
   *       ruleServiceClient.getRuleDeploymentCallable().futureCall(request);
   *   // Do something.
   *   RuleDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentCallable() {
    return stub.getRuleDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RuleDeployments across all Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
   *   for (RuleDeployment element : ruleServiceClient.listRuleDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The collection of all parents which own all rule deployments. The "-"
   *     wildcard token must be used as the rule identifier in the resource path. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleDeploymentsPagedResponse listRuleDeployments(RuleName parent) {
    ListRuleDeploymentsRequest request =
        ListRuleDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRuleDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RuleDeployments across all Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   String parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString();
   *   for (RuleDeployment element : ruleServiceClient.listRuleDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The collection of all parents which own all rule deployments. The "-"
   *     wildcard token must be used as the rule identifier in the resource path. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleDeploymentsPagedResponse listRuleDeployments(String parent) {
    ListRuleDeploymentsRequest request =
        ListRuleDeploymentsRequest.newBuilder().setParent(parent).build();
    return listRuleDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RuleDeployments across all Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRuleDeploymentsRequest request =
   *       ListRuleDeploymentsRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (RuleDeployment element : ruleServiceClient.listRuleDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleDeploymentsPagedResponse listRuleDeployments(
      ListRuleDeploymentsRequest request) {
    return listRuleDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RuleDeployments across all Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRuleDeploymentsRequest request =
   *       ListRuleDeploymentsRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<RuleDeployment> future =
   *       ruleServiceClient.listRuleDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RuleDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsPagedCallable() {
    return stub.listRuleDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RuleDeployments across all Rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   ListRuleDeploymentsRequest request =
   *       ListRuleDeploymentsRequest.newBuilder()
   *           .setParent(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListRuleDeploymentsResponse response =
   *         ruleServiceClient.listRuleDeploymentsCallable().call(request);
   *     for (RuleDeployment element : response.getRuleDeploymentsList()) {
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
  public final UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
      listRuleDeploymentsCallable() {
    return stub.listRuleDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RuleDeployment. Failures are not necessarily atomic. If there is a request to update
   * multiple fields, and any update to a single field fails, an error will be returned, but other
   * fields may remain successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   RuleDeployment ruleDeployment = RuleDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   RuleDeployment response = ruleServiceClient.updateRuleDeployment(ruleDeployment, updateMask);
   * }
   * }</pre>
   *
   * @param ruleDeployment Required. The rule deployment to update.
   *     <p>The rule deployment's `name` field is used to identify the rule deployment to update.
   *     Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/rules/{rule}/deployment`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleDeployment updateRuleDeployment(
      RuleDeployment ruleDeployment, FieldMask updateMask) {
    UpdateRuleDeploymentRequest request =
        UpdateRuleDeploymentRequest.newBuilder()
            .setRuleDeployment(ruleDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updateRuleDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RuleDeployment. Failures are not necessarily atomic. If there is a request to update
   * multiple fields, and any update to a single field fails, an error will be returned, but other
   * fields may remain successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   UpdateRuleDeploymentRequest request =
   *       UpdateRuleDeploymentRequest.newBuilder()
   *           .setRuleDeployment(RuleDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   RuleDeployment response = ruleServiceClient.updateRuleDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleDeployment updateRuleDeployment(UpdateRuleDeploymentRequest request) {
    return updateRuleDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RuleDeployment. Failures are not necessarily atomic. If there is a request to update
   * multiple fields, and any update to a single field fails, an error will be returned, but other
   * fields may remain successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
   *   UpdateRuleDeploymentRequest request =
   *       UpdateRuleDeploymentRequest.newBuilder()
   *           .setRuleDeployment(RuleDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<RuleDeployment> future =
   *       ruleServiceClient.updateRuleDeploymentCallable().futureCall(request);
   *   // Do something.
   *   RuleDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRuleDeploymentRequest, RuleDeployment>
      updateRuleDeploymentCallable() {
    return stub.updateRuleDeploymentCallable();
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

  public static class ListRulesPagedResponse
      extends AbstractPagedListResponse<
          ListRulesRequest, ListRulesResponse, Rule, ListRulesPage, ListRulesFixedSizeCollection> {

    public static ApiFuture<ListRulesPagedResponse> createAsync(
        PageContext<ListRulesRequest, ListRulesResponse, Rule> context,
        ApiFuture<ListRulesResponse> futureResponse) {
      ApiFuture<ListRulesPage> futurePage =
          ListRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRulesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRulesPagedResponse(ListRulesPage page) {
      super(page, ListRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRulesPage
      extends AbstractPage<ListRulesRequest, ListRulesResponse, Rule, ListRulesPage> {

    private ListRulesPage(
        PageContext<ListRulesRequest, ListRulesResponse, Rule> context,
        ListRulesResponse response) {
      super(context, response);
    }

    private static ListRulesPage createEmptyPage() {
      return new ListRulesPage(null, null);
    }

    @Override
    protected ListRulesPage createPage(
        PageContext<ListRulesRequest, ListRulesResponse, Rule> context,
        ListRulesResponse response) {
      return new ListRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListRulesPage> createPageAsync(
        PageContext<ListRulesRequest, ListRulesResponse, Rule> context,
        ApiFuture<ListRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRulesRequest, ListRulesResponse, Rule, ListRulesPage, ListRulesFixedSizeCollection> {

    private ListRulesFixedSizeCollection(List<ListRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRulesFixedSizeCollection createEmptyCollection() {
      return new ListRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRulesFixedSizeCollection createCollection(
        List<ListRulesPage> pages, int collectionSize) {
      return new ListRulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRuleRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListRuleRevisionsRequest,
          ListRuleRevisionsResponse,
          Rule,
          ListRuleRevisionsPage,
          ListRuleRevisionsFixedSizeCollection> {

    public static ApiFuture<ListRuleRevisionsPagedResponse> createAsync(
        PageContext<ListRuleRevisionsRequest, ListRuleRevisionsResponse, Rule> context,
        ApiFuture<ListRuleRevisionsResponse> futureResponse) {
      ApiFuture<ListRuleRevisionsPage> futurePage =
          ListRuleRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRuleRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRuleRevisionsPagedResponse(ListRuleRevisionsPage page) {
      super(page, ListRuleRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRuleRevisionsPage
      extends AbstractPage<
          ListRuleRevisionsRequest, ListRuleRevisionsResponse, Rule, ListRuleRevisionsPage> {

    private ListRuleRevisionsPage(
        PageContext<ListRuleRevisionsRequest, ListRuleRevisionsResponse, Rule> context,
        ListRuleRevisionsResponse response) {
      super(context, response);
    }

    private static ListRuleRevisionsPage createEmptyPage() {
      return new ListRuleRevisionsPage(null, null);
    }

    @Override
    protected ListRuleRevisionsPage createPage(
        PageContext<ListRuleRevisionsRequest, ListRuleRevisionsResponse, Rule> context,
        ListRuleRevisionsResponse response) {
      return new ListRuleRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListRuleRevisionsPage> createPageAsync(
        PageContext<ListRuleRevisionsRequest, ListRuleRevisionsResponse, Rule> context,
        ApiFuture<ListRuleRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRuleRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRuleRevisionsRequest,
          ListRuleRevisionsResponse,
          Rule,
          ListRuleRevisionsPage,
          ListRuleRevisionsFixedSizeCollection> {

    private ListRuleRevisionsFixedSizeCollection(
        List<ListRuleRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRuleRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListRuleRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRuleRevisionsFixedSizeCollection createCollection(
        List<ListRuleRevisionsPage> pages, int collectionSize) {
      return new ListRuleRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRetrohuntsPagedResponse
      extends AbstractPagedListResponse<
          ListRetrohuntsRequest,
          ListRetrohuntsResponse,
          Retrohunt,
          ListRetrohuntsPage,
          ListRetrohuntsFixedSizeCollection> {

    public static ApiFuture<ListRetrohuntsPagedResponse> createAsync(
        PageContext<ListRetrohuntsRequest, ListRetrohuntsResponse, Retrohunt> context,
        ApiFuture<ListRetrohuntsResponse> futureResponse) {
      ApiFuture<ListRetrohuntsPage> futurePage =
          ListRetrohuntsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRetrohuntsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRetrohuntsPagedResponse(ListRetrohuntsPage page) {
      super(page, ListRetrohuntsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRetrohuntsPage
      extends AbstractPage<
          ListRetrohuntsRequest, ListRetrohuntsResponse, Retrohunt, ListRetrohuntsPage> {

    private ListRetrohuntsPage(
        PageContext<ListRetrohuntsRequest, ListRetrohuntsResponse, Retrohunt> context,
        ListRetrohuntsResponse response) {
      super(context, response);
    }

    private static ListRetrohuntsPage createEmptyPage() {
      return new ListRetrohuntsPage(null, null);
    }

    @Override
    protected ListRetrohuntsPage createPage(
        PageContext<ListRetrohuntsRequest, ListRetrohuntsResponse, Retrohunt> context,
        ListRetrohuntsResponse response) {
      return new ListRetrohuntsPage(context, response);
    }

    @Override
    public ApiFuture<ListRetrohuntsPage> createPageAsync(
        PageContext<ListRetrohuntsRequest, ListRetrohuntsResponse, Retrohunt> context,
        ApiFuture<ListRetrohuntsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRetrohuntsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRetrohuntsRequest,
          ListRetrohuntsResponse,
          Retrohunt,
          ListRetrohuntsPage,
          ListRetrohuntsFixedSizeCollection> {

    private ListRetrohuntsFixedSizeCollection(List<ListRetrohuntsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRetrohuntsFixedSizeCollection createEmptyCollection() {
      return new ListRetrohuntsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRetrohuntsFixedSizeCollection createCollection(
        List<ListRetrohuntsPage> pages, int collectionSize) {
      return new ListRetrohuntsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRuleDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListRuleDeploymentsRequest,
          ListRuleDeploymentsResponse,
          RuleDeployment,
          ListRuleDeploymentsPage,
          ListRuleDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListRuleDeploymentsPagedResponse> createAsync(
        PageContext<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, RuleDeployment>
            context,
        ApiFuture<ListRuleDeploymentsResponse> futureResponse) {
      ApiFuture<ListRuleDeploymentsPage> futurePage =
          ListRuleDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRuleDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRuleDeploymentsPagedResponse(ListRuleDeploymentsPage page) {
      super(page, ListRuleDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRuleDeploymentsPage
      extends AbstractPage<
          ListRuleDeploymentsRequest,
          ListRuleDeploymentsResponse,
          RuleDeployment,
          ListRuleDeploymentsPage> {

    private ListRuleDeploymentsPage(
        PageContext<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, RuleDeployment>
            context,
        ListRuleDeploymentsResponse response) {
      super(context, response);
    }

    private static ListRuleDeploymentsPage createEmptyPage() {
      return new ListRuleDeploymentsPage(null, null);
    }

    @Override
    protected ListRuleDeploymentsPage createPage(
        PageContext<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, RuleDeployment>
            context,
        ListRuleDeploymentsResponse response) {
      return new ListRuleDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListRuleDeploymentsPage> createPageAsync(
        PageContext<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, RuleDeployment>
            context,
        ApiFuture<ListRuleDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRuleDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRuleDeploymentsRequest,
          ListRuleDeploymentsResponse,
          RuleDeployment,
          ListRuleDeploymentsPage,
          ListRuleDeploymentsFixedSizeCollection> {

    private ListRuleDeploymentsFixedSizeCollection(
        List<ListRuleDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRuleDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListRuleDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRuleDeploymentsFixedSizeCollection createCollection(
        List<ListRuleDeploymentsPage> pages, int collectionSize) {
      return new ListRuleDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
