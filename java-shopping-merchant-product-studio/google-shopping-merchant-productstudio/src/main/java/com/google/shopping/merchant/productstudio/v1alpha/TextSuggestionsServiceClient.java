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

package com.google.shopping.merchant.productstudio.v1alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.productstudio.v1alpha.stub.TextSuggestionsServiceStub;
import com.google.shopping.merchant.productstudio.v1alpha.stub.TextSuggestionsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service that exposes Generative AI (GenAI) endpoints for creating and
 * enhancing product text content, such as titles, descriptions, etc.
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
 * try (TextSuggestionsServiceClient textSuggestionsServiceClient =
 *     TextSuggestionsServiceClient.create()) {
 *   String name = "name3373707";
 *   GenerateProductTextSuggestionsResponse response =
 *       textSuggestionsServiceClient.generateProductTextSuggestions(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TextSuggestionsServiceClient object to clean up
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
 *      <td><p> GenerateProductTextSuggestions</td>
 *      <td><p> GenerateProductTextSuggestions generates a set of candidate text completions (e.g., product titles, descriptions) based on provided product information. This endpoint leverages GenAI models to create suggestions for improving existing product text or generating new content.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateProductTextSuggestions(GenerateProductTextSuggestionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateProductTextSuggestions(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateProductTextSuggestionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of TextSuggestionsServiceSettings
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
 * TextSuggestionsServiceSettings textSuggestionsServiceSettings =
 *     TextSuggestionsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TextSuggestionsServiceClient textSuggestionsServiceClient =
 *     TextSuggestionsServiceClient.create(textSuggestionsServiceSettings);
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
 * TextSuggestionsServiceSettings textSuggestionsServiceSettings =
 *     TextSuggestionsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TextSuggestionsServiceClient textSuggestionsServiceClient =
 *     TextSuggestionsServiceClient.create(textSuggestionsServiceSettings);
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
 * TextSuggestionsServiceSettings textSuggestionsServiceSettings =
 *     TextSuggestionsServiceSettings.newHttpJsonBuilder().build();
 * TextSuggestionsServiceClient textSuggestionsServiceClient =
 *     TextSuggestionsServiceClient.create(textSuggestionsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TextSuggestionsServiceClient implements BackgroundResource {
  private final TextSuggestionsServiceSettings settings;
  private final TextSuggestionsServiceStub stub;

  /** Constructs an instance of TextSuggestionsServiceClient with default settings. */
  public static final TextSuggestionsServiceClient create() throws IOException {
    return create(TextSuggestionsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TextSuggestionsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TextSuggestionsServiceClient create(TextSuggestionsServiceSettings settings)
      throws IOException {
    return new TextSuggestionsServiceClient(settings);
  }

  /**
   * Constructs an instance of TextSuggestionsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(TextSuggestionsServiceSettings).
   */
  public static final TextSuggestionsServiceClient create(TextSuggestionsServiceStub stub) {
    return new TextSuggestionsServiceClient(stub);
  }

  /**
   * Constructs an instance of TextSuggestionsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected TextSuggestionsServiceClient(TextSuggestionsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((TextSuggestionsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TextSuggestionsServiceClient(TextSuggestionsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TextSuggestionsServiceSettings getSettings() {
    return settings;
  }

  public TextSuggestionsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateProductTextSuggestions generates a set of candidate text completions (e.g., product
   * titles, descriptions) based on provided product information. This endpoint leverages GenAI
   * models to create suggestions for improving existing product text or generating new content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextSuggestionsServiceClient textSuggestionsServiceClient =
   *     TextSuggestionsServiceClient.create()) {
   *   String name = "name3373707";
   *   GenerateProductTextSuggestionsResponse response =
   *       textSuggestionsServiceClient.generateProductTextSuggestions(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the account to generate text suggestions for. This acts as a
   *     container for the request and does not affect the generation itself, as this is a stateless
   *     API. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateProductTextSuggestionsResponse generateProductTextSuggestions(String name) {
    GenerateProductTextSuggestionsRequest request =
        GenerateProductTextSuggestionsRequest.newBuilder().setName(name).build();
    return generateProductTextSuggestions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateProductTextSuggestions generates a set of candidate text completions (e.g., product
   * titles, descriptions) based on provided product information. This endpoint leverages GenAI
   * models to create suggestions for improving existing product text or generating new content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextSuggestionsServiceClient textSuggestionsServiceClient =
   *     TextSuggestionsServiceClient.create()) {
   *   GenerateProductTextSuggestionsRequest request =
   *       GenerateProductTextSuggestionsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setProductInfo(ProductInfo.newBuilder().build())
   *           .setOutputSpec(OutputSpec.newBuilder().build())
   *           .addAllTitleExamples(new ArrayList<TitleExample>())
   *           .build();
   *   GenerateProductTextSuggestionsResponse response =
   *       textSuggestionsServiceClient.generateProductTextSuggestions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateProductTextSuggestionsResponse generateProductTextSuggestions(
      GenerateProductTextSuggestionsRequest request) {
    return generateProductTextSuggestionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GenerateProductTextSuggestions generates a set of candidate text completions (e.g., product
   * titles, descriptions) based on provided product information. This endpoint leverages GenAI
   * models to create suggestions for improving existing product text or generating new content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextSuggestionsServiceClient textSuggestionsServiceClient =
   *     TextSuggestionsServiceClient.create()) {
   *   GenerateProductTextSuggestionsRequest request =
   *       GenerateProductTextSuggestionsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setProductInfo(ProductInfo.newBuilder().build())
   *           .setOutputSpec(OutputSpec.newBuilder().build())
   *           .addAllTitleExamples(new ArrayList<TitleExample>())
   *           .build();
   *   ApiFuture<GenerateProductTextSuggestionsResponse> future =
   *       textSuggestionsServiceClient.generateProductTextSuggestionsCallable().futureCall(request);
   *   // Do something.
   *   GenerateProductTextSuggestionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateProductTextSuggestionsRequest, GenerateProductTextSuggestionsResponse>
      generateProductTextSuggestionsCallable() {
    return stub.generateProductTextSuggestionsCallable();
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
