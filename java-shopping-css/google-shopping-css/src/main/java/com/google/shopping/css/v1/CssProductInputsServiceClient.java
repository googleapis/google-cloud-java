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

package com.google.shopping.css.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.css.v1.stub.CssProductInputsServiceStub;
import com.google.shopping.css.v1.stub.CssProductInputsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to use CssProductInput resource. This service helps to
 * insert/update/delete CSS Products.
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
 * try (CssProductInputsServiceClient cssProductInputsServiceClient =
 *     CssProductInputsServiceClient.create()) {
 *   InsertCssProductInputRequest request =
 *       InsertCssProductInputRequest.newBuilder()
 *           .setParent(AccountName.of("[ACCOUNT]").toString())
 *           .setCssProductInput(CssProductInput.newBuilder().build())
 *           .setFeedId(-976011428)
 *           .build();
 *   CssProductInput response = cssProductInputsServiceClient.insertCssProductInput(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CssProductInputsServiceClient object to clean up
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
 *      <td><p> InsertCssProductInput</td>
 *      <td><p> Uploads a CssProductInput to your CSS Center account. If an input with the same contentLanguage, identity, feedLabel and feedId already exists, this method replaces that entry.
 * <p>  After inserting, updating, or deleting a CSS Product input, it may take several minutes before the processed CSS Product can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertCssProductInput(InsertCssProductInputRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertCssProductInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCssProductInput</td>
 *      <td><p> Deletes a CSS Product input from your CSS Center account.
 * <p>  After a delete it may take several minutes until the input is no longer available.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCssProductInput(DeleteCssProductInputRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCssProductInput(CssProductInputName name)
 *           <li><p> deleteCssProductInput(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCssProductInputCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * CssProductInputsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CssProductInputsServiceSettings cssProductInputsServiceSettings =
 *     CssProductInputsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CssProductInputsServiceClient cssProductInputsServiceClient =
 *     CssProductInputsServiceClient.create(cssProductInputsServiceSettings);
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
 * CssProductInputsServiceSettings cssProductInputsServiceSettings =
 *     CssProductInputsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CssProductInputsServiceClient cssProductInputsServiceClient =
 *     CssProductInputsServiceClient.create(cssProductInputsServiceSettings);
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
 * CssProductInputsServiceSettings cssProductInputsServiceSettings =
 *     CssProductInputsServiceSettings.newHttpJsonBuilder().build();
 * CssProductInputsServiceClient cssProductInputsServiceClient =
 *     CssProductInputsServiceClient.create(cssProductInputsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CssProductInputsServiceClient implements BackgroundResource {
  private final CssProductInputsServiceSettings settings;
  private final CssProductInputsServiceStub stub;

  /** Constructs an instance of CssProductInputsServiceClient with default settings. */
  public static final CssProductInputsServiceClient create() throws IOException {
    return create(CssProductInputsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CssProductInputsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CssProductInputsServiceClient create(CssProductInputsServiceSettings settings)
      throws IOException {
    return new CssProductInputsServiceClient(settings);
  }

  /**
   * Constructs an instance of CssProductInputsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CssProductInputsServiceSettings).
   */
  public static final CssProductInputsServiceClient create(CssProductInputsServiceStub stub) {
    return new CssProductInputsServiceClient(stub);
  }

  /**
   * Constructs an instance of CssProductInputsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CssProductInputsServiceClient(CssProductInputsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CssProductInputsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CssProductInputsServiceClient(CssProductInputsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CssProductInputsServiceSettings getSettings() {
    return settings;
  }

  public CssProductInputsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a CssProductInput to your CSS Center account. If an input with the same
   * contentLanguage, identity, feedLabel and feedId already exists, this method replaces that
   * entry.
   *
   * <p>After inserting, updating, or deleting a CSS Product input, it may take several minutes
   * before the processed CSS Product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductInputsServiceClient cssProductInputsServiceClient =
   *     CssProductInputsServiceClient.create()) {
   *   InsertCssProductInputRequest request =
   *       InsertCssProductInputRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setCssProductInput(CssProductInput.newBuilder().build())
   *           .setFeedId(-976011428)
   *           .build();
   *   CssProductInput response = cssProductInputsServiceClient.insertCssProductInput(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CssProductInput insertCssProductInput(InsertCssProductInputRequest request) {
    return insertCssProductInputCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a CssProductInput to your CSS Center account. If an input with the same
   * contentLanguage, identity, feedLabel and feedId already exists, this method replaces that
   * entry.
   *
   * <p>After inserting, updating, or deleting a CSS Product input, it may take several minutes
   * before the processed CSS Product can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductInputsServiceClient cssProductInputsServiceClient =
   *     CssProductInputsServiceClient.create()) {
   *   InsertCssProductInputRequest request =
   *       InsertCssProductInputRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setCssProductInput(CssProductInput.newBuilder().build())
   *           .setFeedId(-976011428)
   *           .build();
   *   ApiFuture<CssProductInput> future =
   *       cssProductInputsServiceClient.insertCssProductInputCallable().futureCall(request);
   *   // Do something.
   *   CssProductInput response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertCssProductInputRequest, CssProductInput>
      insertCssProductInputCallable() {
    return stub.insertCssProductInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CSS Product input from your CSS Center account.
   *
   * <p>After a delete it may take several minutes until the input is no longer available.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductInputsServiceClient cssProductInputsServiceClient =
   *     CssProductInputsServiceClient.create()) {
   *   CssProductInputName name = CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]");
   *   cssProductInputsServiceClient.deleteCssProductInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CSS product input resource to delete. Format:
   *     accounts/{account}/cssProductInputs/{css_product_input}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCssProductInput(CssProductInputName name) {
    DeleteCssProductInputRequest request =
        DeleteCssProductInputRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCssProductInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CSS Product input from your CSS Center account.
   *
   * <p>After a delete it may take several minutes until the input is no longer available.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductInputsServiceClient cssProductInputsServiceClient =
   *     CssProductInputsServiceClient.create()) {
   *   String name = CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]").toString();
   *   cssProductInputsServiceClient.deleteCssProductInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CSS product input resource to delete. Format:
   *     accounts/{account}/cssProductInputs/{css_product_input}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCssProductInput(String name) {
    DeleteCssProductInputRequest request =
        DeleteCssProductInputRequest.newBuilder().setName(name).build();
    deleteCssProductInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CSS Product input from your CSS Center account.
   *
   * <p>After a delete it may take several minutes until the input is no longer available.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductInputsServiceClient cssProductInputsServiceClient =
   *     CssProductInputsServiceClient.create()) {
   *   DeleteCssProductInputRequest request =
   *       DeleteCssProductInputRequest.newBuilder()
   *           .setName(CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]").toString())
   *           .setSupplementalFeedId(1845271745)
   *           .build();
   *   cssProductInputsServiceClient.deleteCssProductInput(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCssProductInput(DeleteCssProductInputRequest request) {
    deleteCssProductInputCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a CSS Product input from your CSS Center account.
   *
   * <p>After a delete it may take several minutes until the input is no longer available.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CssProductInputsServiceClient cssProductInputsServiceClient =
   *     CssProductInputsServiceClient.create()) {
   *   DeleteCssProductInputRequest request =
   *       DeleteCssProductInputRequest.newBuilder()
   *           .setName(CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]").toString())
   *           .setSupplementalFeedId(1845271745)
   *           .build();
   *   ApiFuture<Empty> future =
   *       cssProductInputsServiceClient.deleteCssProductInputCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCssProductInputRequest, Empty> deleteCssProductInputCallable() {
    return stub.deleteCssProductInputCallable();
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
