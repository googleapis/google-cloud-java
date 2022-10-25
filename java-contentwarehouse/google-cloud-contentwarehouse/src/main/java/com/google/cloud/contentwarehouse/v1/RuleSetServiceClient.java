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

package com.google.cloud.contentwarehouse.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.stub.RuleSetServiceStub;
import com.google.cloud.contentwarehouse.v1.stub.RuleSetServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage customer specific RuleSets.
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
 * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   RuleSet ruleSet = RuleSet.newBuilder().build();
 *   RuleSet response = ruleSetServiceClient.createRuleSet(parent, ruleSet);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RuleSetServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of RuleSetServiceSettings to
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
 * RuleSetServiceSettings ruleSetServiceSettings =
 *     RuleSetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create(ruleSetServiceSettings);
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
 * RuleSetServiceSettings ruleSetServiceSettings =
 *     RuleSetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create(ruleSetServiceSettings);
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
 * RuleSetServiceSettings ruleSetServiceSettings =
 *     RuleSetServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             RuleSetServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create(ruleSetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RuleSetServiceClient implements BackgroundResource {
  private final RuleSetServiceSettings settings;
  private final RuleSetServiceStub stub;

  /** Constructs an instance of RuleSetServiceClient with default settings. */
  public static final RuleSetServiceClient create() throws IOException {
    return create(RuleSetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RuleSetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RuleSetServiceClient create(RuleSetServiceSettings settings)
      throws IOException {
    return new RuleSetServiceClient(settings);
  }

  /**
   * Constructs an instance of RuleSetServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(RuleSetServiceSettings).
   */
  public static final RuleSetServiceClient create(RuleSetServiceStub stub) {
    return new RuleSetServiceClient(stub);
  }

  /**
   * Constructs an instance of RuleSetServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RuleSetServiceClient(RuleSetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RuleSetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RuleSetServiceClient(RuleSetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RuleSetServiceSettings getSettings() {
    return settings;
  }

  public RuleSetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ruleset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RuleSet ruleSet = RuleSet.newBuilder().build();
   *   RuleSet response = ruleSetServiceClient.createRuleSet(parent, ruleSet);
   * }
   * }</pre>
   *
   * @param parent Required. The parent name. Format:
   *     projects/{project_number}/locations/{location}.
   * @param ruleSet Required. The rule set to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet createRuleSet(LocationName parent, RuleSet ruleSet) {
    CreateRuleSetRequest request =
        CreateRuleSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRuleSet(ruleSet)
            .build();
    return createRuleSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ruleset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RuleSet ruleSet = RuleSet.newBuilder().build();
   *   RuleSet response = ruleSetServiceClient.createRuleSet(parent, ruleSet);
   * }
   * }</pre>
   *
   * @param parent Required. The parent name. Format:
   *     projects/{project_number}/locations/{location}.
   * @param ruleSet Required. The rule set to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet createRuleSet(String parent, RuleSet ruleSet) {
    CreateRuleSetRequest request =
        CreateRuleSetRequest.newBuilder().setParent(parent).setRuleSet(ruleSet).build();
    return createRuleSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ruleset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   CreateRuleSetRequest request =
   *       CreateRuleSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRuleSet(RuleSet.newBuilder().build())
   *           .build();
   *   RuleSet response = ruleSetServiceClient.createRuleSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet createRuleSet(CreateRuleSetRequest request) {
    return createRuleSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ruleset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   CreateRuleSetRequest request =
   *       CreateRuleSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRuleSet(RuleSet.newBuilder().build())
   *           .build();
   *   ApiFuture<RuleSet> future = ruleSetServiceClient.createRuleSetCallable().futureCall(request);
   *   // Do something.
   *   RuleSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRuleSetRequest, RuleSet> createRuleSetCallable() {
    return stub.createRuleSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");
   *   RuleSet response = ruleSetServiceClient.getRuleSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule set to retrieve. Format:
   *     projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet getRuleSet(RuleSetName name) {
    GetRuleSetRequest request =
        GetRuleSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRuleSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   String name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString();
   *   RuleSet response = ruleSetServiceClient.getRuleSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule set to retrieve. Format:
   *     projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet getRuleSet(String name) {
    GetRuleSetRequest request = GetRuleSetRequest.newBuilder().setName(name).build();
    return getRuleSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   GetRuleSetRequest request =
   *       GetRuleSetRequest.newBuilder()
   *           .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
   *           .build();
   *   RuleSet response = ruleSetServiceClient.getRuleSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet getRuleSet(GetRuleSetRequest request) {
    return getRuleSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   GetRuleSetRequest request =
   *       GetRuleSetRequest.newBuilder()
   *           .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
   *           .build();
   *   ApiFuture<RuleSet> future = ruleSetServiceClient.getRuleSetCallable().futureCall(request);
   *   // Do something.
   *   RuleSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleSetRequest, RuleSet> getRuleSetCallable() {
    return stub.getRuleSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset is non-empty and does
   * not equal the existing name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");
   *   RuleSet ruleSet = RuleSet.newBuilder().build();
   *   RuleSet response = ruleSetServiceClient.updateRuleSet(name, ruleSet);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule set to update. Format:
   *     projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}.
   * @param ruleSet Required. The rule set to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet updateRuleSet(RuleSetName name, RuleSet ruleSet) {
    UpdateRuleSetRequest request =
        UpdateRuleSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRuleSet(ruleSet)
            .build();
    return updateRuleSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset is non-empty and does
   * not equal the existing name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   String name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString();
   *   RuleSet ruleSet = RuleSet.newBuilder().build();
   *   RuleSet response = ruleSetServiceClient.updateRuleSet(name, ruleSet);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule set to update. Format:
   *     projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}.
   * @param ruleSet Required. The rule set to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet updateRuleSet(String name, RuleSet ruleSet) {
    UpdateRuleSetRequest request =
        UpdateRuleSetRequest.newBuilder().setName(name).setRuleSet(ruleSet).build();
    return updateRuleSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset is non-empty and does
   * not equal the existing name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   UpdateRuleSetRequest request =
   *       UpdateRuleSetRequest.newBuilder()
   *           .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
   *           .setRuleSet(RuleSet.newBuilder().build())
   *           .build();
   *   RuleSet response = ruleSetServiceClient.updateRuleSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RuleSet updateRuleSet(UpdateRuleSetRequest request) {
    return updateRuleSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset is non-empty and does
   * not equal the existing name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   UpdateRuleSetRequest request =
   *       UpdateRuleSetRequest.newBuilder()
   *           .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
   *           .setRuleSet(RuleSet.newBuilder().build())
   *           .build();
   *   ApiFuture<RuleSet> future = ruleSetServiceClient.updateRuleSetCallable().futureCall(request);
   *   // Do something.
   *   RuleSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRuleSetRequest, RuleSet> updateRuleSetCallable() {
    return stub.updateRuleSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");
   *   ruleSetServiceClient.deleteRuleSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule set to delete. Format:
   *     projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRuleSet(RuleSetName name) {
    DeleteRuleSetRequest request =
        DeleteRuleSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteRuleSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   String name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString();
   *   ruleSetServiceClient.deleteRuleSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the rule set to delete. Format:
   *     projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRuleSet(String name) {
    DeleteRuleSetRequest request = DeleteRuleSetRequest.newBuilder().setName(name).build();
    deleteRuleSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   DeleteRuleSetRequest request =
   *       DeleteRuleSetRequest.newBuilder()
   *           .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
   *           .build();
   *   ruleSetServiceClient.deleteRuleSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRuleSet(DeleteRuleSetRequest request) {
    deleteRuleSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   DeleteRuleSetRequest request =
   *       DeleteRuleSetRequest.newBuilder()
   *           .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
   *           .build();
   *   ApiFuture<Empty> future = ruleSetServiceClient.deleteRuleSetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRuleSetRequest, Empty> deleteRuleSetCallable() {
    return stub.deleteRuleSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rulesets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RuleSet element : ruleSetServiceClient.listRuleSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of document. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleSetsPagedResponse listRuleSets(LocationName parent) {
    ListRuleSetsRequest request =
        ListRuleSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRuleSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rulesets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RuleSet element : ruleSetServiceClient.listRuleSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of document. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleSetsPagedResponse listRuleSets(String parent) {
    ListRuleSetsRequest request = ListRuleSetsRequest.newBuilder().setParent(parent).build();
    return listRuleSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rulesets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   ListRuleSetsRequest request =
   *       ListRuleSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RuleSet element : ruleSetServiceClient.listRuleSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleSetsPagedResponse listRuleSets(ListRuleSetsRequest request) {
    return listRuleSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rulesets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   ListRuleSetsRequest request =
   *       ListRuleSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RuleSet> future =
   *       ruleSetServiceClient.listRuleSetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RuleSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRuleSetsRequest, ListRuleSetsPagedResponse>
      listRuleSetsPagedCallable() {
    return stub.listRuleSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rulesets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleSetServiceClient ruleSetServiceClient = RuleSetServiceClient.create()) {
   *   ListRuleSetsRequest request =
   *       ListRuleSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRuleSetsResponse response = ruleSetServiceClient.listRuleSetsCallable().call(request);
   *     for (RuleSet element : response.getRuleSetsList()) {
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
  public final UnaryCallable<ListRuleSetsRequest, ListRuleSetsResponse> listRuleSetsCallable() {
    return stub.listRuleSetsCallable();
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

  public static class ListRuleSetsPagedResponse
      extends AbstractPagedListResponse<
          ListRuleSetsRequest,
          ListRuleSetsResponse,
          RuleSet,
          ListRuleSetsPage,
          ListRuleSetsFixedSizeCollection> {

    public static ApiFuture<ListRuleSetsPagedResponse> createAsync(
        PageContext<ListRuleSetsRequest, ListRuleSetsResponse, RuleSet> context,
        ApiFuture<ListRuleSetsResponse> futureResponse) {
      ApiFuture<ListRuleSetsPage> futurePage =
          ListRuleSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRuleSetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRuleSetsPagedResponse(ListRuleSetsPage page) {
      super(page, ListRuleSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRuleSetsPage
      extends AbstractPage<ListRuleSetsRequest, ListRuleSetsResponse, RuleSet, ListRuleSetsPage> {

    private ListRuleSetsPage(
        PageContext<ListRuleSetsRequest, ListRuleSetsResponse, RuleSet> context,
        ListRuleSetsResponse response) {
      super(context, response);
    }

    private static ListRuleSetsPage createEmptyPage() {
      return new ListRuleSetsPage(null, null);
    }

    @Override
    protected ListRuleSetsPage createPage(
        PageContext<ListRuleSetsRequest, ListRuleSetsResponse, RuleSet> context,
        ListRuleSetsResponse response) {
      return new ListRuleSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListRuleSetsPage> createPageAsync(
        PageContext<ListRuleSetsRequest, ListRuleSetsResponse, RuleSet> context,
        ApiFuture<ListRuleSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRuleSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRuleSetsRequest,
          ListRuleSetsResponse,
          RuleSet,
          ListRuleSetsPage,
          ListRuleSetsFixedSizeCollection> {

    private ListRuleSetsFixedSizeCollection(List<ListRuleSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRuleSetsFixedSizeCollection createEmptyCollection() {
      return new ListRuleSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRuleSetsFixedSizeCollection createCollection(
        List<ListRuleSetsPage> pages, int collectionSize) {
      return new ListRuleSetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
