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

package com.google.shopping.merchant.issueresolution.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.issueresolution.v1.stub.IssueResolutionServiceStub;
import com.google.shopping.merchant.issueresolution.v1.stub.IssueResolutionServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to provide an issue resolution content for account issues and
 * product issues.
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
 * try (IssueResolutionServiceClient issueResolutionServiceClient =
 *     IssueResolutionServiceClient.create()) {
 *   AccountName name = AccountName.of("[ACCOUNT]");
 *   RenderAccountIssuesResponse response = issueResolutionServiceClient.renderAccountIssues(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IssueResolutionServiceClient object to clean up
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
 *      <td><p> RenderAccountIssues</td>
 *      <td><p> Provide a list of business's account issues with an issue resolution content and available actions. This content and actions are meant to be rendered and shown in third-party applications.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renderAccountIssues(RenderAccountIssuesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renderAccountIssues(AccountName name)
 *           <li><p> renderAccountIssues(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renderAccountIssuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenderProductIssues</td>
 *      <td><p> Provide a list of issues for business's product with an issue resolution content and available actions. This content and actions are meant to be rendered and shown in third-party applications.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renderProductIssues(RenderProductIssuesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renderProductIssues(ProductName name)
 *           <li><p> renderProductIssues(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renderProductIssuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TriggerAction</td>
 *      <td><p> Start an action. The action can be requested by a business in third-party application. Before the business can request the action, the third-party application needs to show them action specific content and display a user input form.
 * <p>  The action can be successfully started only once all `required` inputs are provided. If any `required` input is missing, or invalid value was provided, the service will return 400 error. Validation errors will contain [Ids][google.shopping.merchant.issueresolution.v1.InputField.id] for all problematic field together with translated, human readable error messages that can be shown to the user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> triggerAction(TriggerActionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> triggerAction(AccountName name)
 *           <li><p> triggerAction(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> triggerActionCallable()
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
 * <p>This class can be customized by passing in a custom instance of IssueResolutionServiceSettings
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
 * IssueResolutionServiceSettings issueResolutionServiceSettings =
 *     IssueResolutionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IssueResolutionServiceClient issueResolutionServiceClient =
 *     IssueResolutionServiceClient.create(issueResolutionServiceSettings);
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
 * IssueResolutionServiceSettings issueResolutionServiceSettings =
 *     IssueResolutionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IssueResolutionServiceClient issueResolutionServiceClient =
 *     IssueResolutionServiceClient.create(issueResolutionServiceSettings);
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
 * IssueResolutionServiceSettings issueResolutionServiceSettings =
 *     IssueResolutionServiceSettings.newHttpJsonBuilder().build();
 * IssueResolutionServiceClient issueResolutionServiceClient =
 *     IssueResolutionServiceClient.create(issueResolutionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IssueResolutionServiceClient implements BackgroundResource {
  private final IssueResolutionServiceSettings settings;
  private final IssueResolutionServiceStub stub;

  /** Constructs an instance of IssueResolutionServiceClient with default settings. */
  public static final IssueResolutionServiceClient create() throws IOException {
    return create(IssueResolutionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IssueResolutionServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IssueResolutionServiceClient create(IssueResolutionServiceSettings settings)
      throws IOException {
    return new IssueResolutionServiceClient(settings);
  }

  /**
   * Constructs an instance of IssueResolutionServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(IssueResolutionServiceSettings).
   */
  public static final IssueResolutionServiceClient create(IssueResolutionServiceStub stub) {
    return new IssueResolutionServiceClient(stub);
  }

  /**
   * Constructs an instance of IssueResolutionServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected IssueResolutionServiceClient(IssueResolutionServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((IssueResolutionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected IssueResolutionServiceClient(IssueResolutionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IssueResolutionServiceSettings getSettings() {
    return settings;
  }

  public IssueResolutionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provide a list of business's account issues with an issue resolution content and available
   * actions. This content and actions are meant to be rendered and shown in third-party
   * applications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   AccountName name = AccountName.of("[ACCOUNT]");
   *   RenderAccountIssuesResponse response = issueResolutionServiceClient.renderAccountIssues(name);
   * }
   * }</pre>
   *
   * @param name Required. The account to fetch issues for. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderAccountIssuesResponse renderAccountIssues(AccountName name) {
    RenderAccountIssuesRequest request =
        RenderAccountIssuesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return renderAccountIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provide a list of business's account issues with an issue resolution content and available
   * actions. This content and actions are meant to be rendered and shown in third-party
   * applications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   String name = AccountName.of("[ACCOUNT]").toString();
   *   RenderAccountIssuesResponse response = issueResolutionServiceClient.renderAccountIssues(name);
   * }
   * }</pre>
   *
   * @param name Required. The account to fetch issues for. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderAccountIssuesResponse renderAccountIssues(String name) {
    RenderAccountIssuesRequest request =
        RenderAccountIssuesRequest.newBuilder().setName(name).build();
    return renderAccountIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provide a list of business's account issues with an issue resolution content and available
   * actions. This content and actions are meant to be rendered and shown in third-party
   * applications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   RenderAccountIssuesRequest request =
   *       RenderAccountIssuesRequest.newBuilder()
   *           .setName(AccountName.of("[ACCOUNT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setTimeZone("timeZone-2077180903")
   *           .setPayload(RenderIssuesRequestPayload.newBuilder().build())
   *           .build();
   *   RenderAccountIssuesResponse response =
   *       issueResolutionServiceClient.renderAccountIssues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderAccountIssuesResponse renderAccountIssues(RenderAccountIssuesRequest request) {
    return renderAccountIssuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provide a list of business's account issues with an issue resolution content and available
   * actions. This content and actions are meant to be rendered and shown in third-party
   * applications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   RenderAccountIssuesRequest request =
   *       RenderAccountIssuesRequest.newBuilder()
   *           .setName(AccountName.of("[ACCOUNT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setTimeZone("timeZone-2077180903")
   *           .setPayload(RenderIssuesRequestPayload.newBuilder().build())
   *           .build();
   *   ApiFuture<RenderAccountIssuesResponse> future =
   *       issueResolutionServiceClient.renderAccountIssuesCallable().futureCall(request);
   *   // Do something.
   *   RenderAccountIssuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
      renderAccountIssuesCallable() {
    return stub.renderAccountIssuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provide a list of issues for business's product with an issue resolution content and available
   * actions. This content and actions are meant to be rendered and shown in third-party
   * applications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   ProductName name = ProductName.of("[ACCOUNT]", "[PRODUCT]");
   *   RenderProductIssuesResponse response = issueResolutionServiceClient.renderProductIssues(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the product to fetch issues for. Format:
   *     `accounts/{account}/products/{product}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderProductIssuesResponse renderProductIssues(ProductName name) {
    RenderProductIssuesRequest request =
        RenderProductIssuesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return renderProductIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provide a list of issues for business's product with an issue resolution content and available
   * actions. This content and actions are meant to be rendered and shown in third-party
   * applications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   String name = ProductName.of("[ACCOUNT]", "[PRODUCT]").toString();
   *   RenderProductIssuesResponse response = issueResolutionServiceClient.renderProductIssues(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the product to fetch issues for. Format:
   *     `accounts/{account}/products/{product}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderProductIssuesResponse renderProductIssues(String name) {
    RenderProductIssuesRequest request =
        RenderProductIssuesRequest.newBuilder().setName(name).build();
    return renderProductIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provide a list of issues for business's product with an issue resolution content and available
   * actions. This content and actions are meant to be rendered and shown in third-party
   * applications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   RenderProductIssuesRequest request =
   *       RenderProductIssuesRequest.newBuilder()
   *           .setName(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setTimeZone("timeZone-2077180903")
   *           .setPayload(RenderIssuesRequestPayload.newBuilder().build())
   *           .build();
   *   RenderProductIssuesResponse response =
   *       issueResolutionServiceClient.renderProductIssues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderProductIssuesResponse renderProductIssues(RenderProductIssuesRequest request) {
    return renderProductIssuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provide a list of issues for business's product with an issue resolution content and available
   * actions. This content and actions are meant to be rendered and shown in third-party
   * applications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   RenderProductIssuesRequest request =
   *       RenderProductIssuesRequest.newBuilder()
   *           .setName(ProductName.of("[ACCOUNT]", "[PRODUCT]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setTimeZone("timeZone-2077180903")
   *           .setPayload(RenderIssuesRequestPayload.newBuilder().build())
   *           .build();
   *   ApiFuture<RenderProductIssuesResponse> future =
   *       issueResolutionServiceClient.renderProductIssuesCallable().futureCall(request);
   *   // Do something.
   *   RenderProductIssuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenderProductIssuesRequest, RenderProductIssuesResponse>
      renderProductIssuesCallable() {
    return stub.renderProductIssuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start an action. The action can be requested by a business in third-party application. Before
   * the business can request the action, the third-party application needs to show them action
   * specific content and display a user input form.
   *
   * <p>The action can be successfully started only once all `required` inputs are provided. If any
   * `required` input is missing, or invalid value was provided, the service will return 400 error.
   * Validation errors will contain [Ids][google.shopping.merchant.issueresolution.v1.InputField.id]
   * for all problematic field together with translated, human readable error messages that can be
   * shown to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   AccountName name = AccountName.of("[ACCOUNT]");
   *   TriggerActionResponse response = issueResolutionServiceClient.triggerAction(name);
   * }
   * }</pre>
   *
   * @param name Required. The business's account that is triggering the action. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TriggerActionResponse triggerAction(AccountName name) {
    TriggerActionRequest request =
        TriggerActionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return triggerAction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start an action. The action can be requested by a business in third-party application. Before
   * the business can request the action, the third-party application needs to show them action
   * specific content and display a user input form.
   *
   * <p>The action can be successfully started only once all `required` inputs are provided. If any
   * `required` input is missing, or invalid value was provided, the service will return 400 error.
   * Validation errors will contain [Ids][google.shopping.merchant.issueresolution.v1.InputField.id]
   * for all problematic field together with translated, human readable error messages that can be
   * shown to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   String name = AccountName.of("[ACCOUNT]").toString();
   *   TriggerActionResponse response = issueResolutionServiceClient.triggerAction(name);
   * }
   * }</pre>
   *
   * @param name Required. The business's account that is triggering the action. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TriggerActionResponse triggerAction(String name) {
    TriggerActionRequest request = TriggerActionRequest.newBuilder().setName(name).build();
    return triggerAction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start an action. The action can be requested by a business in third-party application. Before
   * the business can request the action, the third-party application needs to show them action
   * specific content and display a user input form.
   *
   * <p>The action can be successfully started only once all `required` inputs are provided. If any
   * `required` input is missing, or invalid value was provided, the service will return 400 error.
   * Validation errors will contain [Ids][google.shopping.merchant.issueresolution.v1.InputField.id]
   * for all problematic field together with translated, human readable error messages that can be
   * shown to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   TriggerActionRequest request =
   *       TriggerActionRequest.newBuilder()
   *           .setName(AccountName.of("[ACCOUNT]").toString())
   *           .setPayload(TriggerActionPayload.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   TriggerActionResponse response = issueResolutionServiceClient.triggerAction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TriggerActionResponse triggerAction(TriggerActionRequest request) {
    return triggerActionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start an action. The action can be requested by a business in third-party application. Before
   * the business can request the action, the third-party application needs to show them action
   * specific content and display a user input form.
   *
   * <p>The action can be successfully started only once all `required` inputs are provided. If any
   * `required` input is missing, or invalid value was provided, the service will return 400 error.
   * Validation errors will contain [Ids][google.shopping.merchant.issueresolution.v1.InputField.id]
   * for all problematic field together with translated, human readable error messages that can be
   * shown to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IssueResolutionServiceClient issueResolutionServiceClient =
   *     IssueResolutionServiceClient.create()) {
   *   TriggerActionRequest request =
   *       TriggerActionRequest.newBuilder()
   *           .setName(AccountName.of("[ACCOUNT]").toString())
   *           .setPayload(TriggerActionPayload.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<TriggerActionResponse> future =
   *       issueResolutionServiceClient.triggerActionCallable().futureCall(request);
   *   // Do something.
   *   TriggerActionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TriggerActionRequest, TriggerActionResponse> triggerActionCallable() {
    return stub.triggerActionCallable();
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
}
