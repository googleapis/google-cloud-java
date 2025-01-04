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

package com.google.cloud.retail.v2alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.stub.GenerativeQuestionServiceStub;
import com.google.cloud.retail.v2alpha.stub.GenerativeQuestionServiceStubSettings;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing LLM generated questions in search serving.
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
 * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
 *     GenerativeQuestionServiceClient.create()) {
 *   GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig =
 *       GenerativeQuestionsFeatureConfig.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   GenerativeQuestionsFeatureConfig response =
 *       generativeQuestionServiceClient.updateGenerativeQuestionsFeatureConfig(
 *           generativeQuestionsFeatureConfig, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GenerativeQuestionServiceClient object to clean up
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
 *      <td><p> UpdateGenerativeQuestionsFeatureConfig</td>
 *      <td><p> Manages overal generative question feature state -- enables toggling feature on and off.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGenerativeQuestionsFeatureConfig(UpdateGenerativeQuestionsFeatureConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateGenerativeQuestionsFeatureConfig(GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGenerativeQuestionsFeatureConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGenerativeQuestionsFeatureConfig</td>
 *      <td><p> Manages overal generative question feature state -- enables toggling feature on and off.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGenerativeQuestionsFeatureConfig(GetGenerativeQuestionsFeatureConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGenerativeQuestionsFeatureConfig(CatalogName catalog)
 *           <li><p> getGenerativeQuestionsFeatureConfig(String catalog)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGenerativeQuestionsFeatureConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGenerativeQuestionConfigs</td>
 *      <td><p> Returns all questions for a given catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGenerativeQuestionConfigs(ListGenerativeQuestionConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGenerativeQuestionConfigs(CatalogName parent)
 *           <li><p> listGenerativeQuestionConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGenerativeQuestionConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGenerativeQuestionConfig</td>
 *      <td><p> Allows management of individual questions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGenerativeQuestionConfig(UpdateGenerativeQuestionConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateGenerativeQuestionConfig(GenerativeQuestionConfig generativeQuestionConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGenerativeQuestionConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateGenerativeQuestionConfigs</td>
 *      <td><p> Allows management of multiple questions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateGenerativeQuestionConfigs(CatalogName parent, List&lt;UpdateGenerativeQuestionConfigRequest&gt; requests)
 *           <li><p> batchUpdateGenerativeQuestionConfigs(String parent, List&lt;UpdateGenerativeQuestionConfigRequest&gt; requests)
 *           <li><p> batchUpdateGenerativeQuestionConfigs(BatchUpdateGenerativeQuestionConfigsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateGenerativeQuestionConfigsCallable()
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
 * GenerativeQuestionServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GenerativeQuestionServiceSettings generativeQuestionServiceSettings =
 *     GenerativeQuestionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GenerativeQuestionServiceClient generativeQuestionServiceClient =
 *     GenerativeQuestionServiceClient.create(generativeQuestionServiceSettings);
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
 * GenerativeQuestionServiceSettings generativeQuestionServiceSettings =
 *     GenerativeQuestionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GenerativeQuestionServiceClient generativeQuestionServiceClient =
 *     GenerativeQuestionServiceClient.create(generativeQuestionServiceSettings);
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
 * GenerativeQuestionServiceSettings generativeQuestionServiceSettings =
 *     GenerativeQuestionServiceSettings.newHttpJsonBuilder().build();
 * GenerativeQuestionServiceClient generativeQuestionServiceClient =
 *     GenerativeQuestionServiceClient.create(generativeQuestionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GenerativeQuestionServiceClient implements BackgroundResource {
  private final GenerativeQuestionServiceSettings settings;
  private final GenerativeQuestionServiceStub stub;

  /** Constructs an instance of GenerativeQuestionServiceClient with default settings. */
  public static final GenerativeQuestionServiceClient create() throws IOException {
    return create(GenerativeQuestionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GenerativeQuestionServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GenerativeQuestionServiceClient create(
      GenerativeQuestionServiceSettings settings) throws IOException {
    return new GenerativeQuestionServiceClient(settings);
  }

  /**
   * Constructs an instance of GenerativeQuestionServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(GenerativeQuestionServiceSettings).
   */
  public static final GenerativeQuestionServiceClient create(GenerativeQuestionServiceStub stub) {
    return new GenerativeQuestionServiceClient(stub);
  }

  /**
   * Constructs an instance of GenerativeQuestionServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GenerativeQuestionServiceClient(GenerativeQuestionServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GenerativeQuestionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected GenerativeQuestionServiceClient(GenerativeQuestionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GenerativeQuestionServiceSettings getSettings() {
    return settings;
  }

  public GenerativeQuestionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages overal generative question feature state -- enables toggling feature on and off.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig =
   *       GenerativeQuestionsFeatureConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GenerativeQuestionsFeatureConfig response =
   *       generativeQuestionServiceClient.updateGenerativeQuestionsFeatureConfig(
   *           generativeQuestionsFeatureConfig, updateMask);
   * }
   * }</pre>
   *
   * @param generativeQuestionsFeatureConfig Required. The configuration managing the feature state.
   * @param updateMask Optional. Indicates which fields in the provided
   *     [GenerativeQuestionsFeatureConfig][google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig]
   *     to update. If not set or empty, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerativeQuestionsFeatureConfig updateGenerativeQuestionsFeatureConfig(
      GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig, FieldMask updateMask) {
    UpdateGenerativeQuestionsFeatureConfigRequest request =
        UpdateGenerativeQuestionsFeatureConfigRequest.newBuilder()
            .setGenerativeQuestionsFeatureConfig(generativeQuestionsFeatureConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateGenerativeQuestionsFeatureConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages overal generative question feature state -- enables toggling feature on and off.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   UpdateGenerativeQuestionsFeatureConfigRequest request =
   *       UpdateGenerativeQuestionsFeatureConfigRequest.newBuilder()
   *           .setGenerativeQuestionsFeatureConfig(
   *               GenerativeQuestionsFeatureConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GenerativeQuestionsFeatureConfig response =
   *       generativeQuestionServiceClient.updateGenerativeQuestionsFeatureConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerativeQuestionsFeatureConfig updateGenerativeQuestionsFeatureConfig(
      UpdateGenerativeQuestionsFeatureConfigRequest request) {
    return updateGenerativeQuestionsFeatureConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages overal generative question feature state -- enables toggling feature on and off.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   UpdateGenerativeQuestionsFeatureConfigRequest request =
   *       UpdateGenerativeQuestionsFeatureConfigRequest.newBuilder()
   *           .setGenerativeQuestionsFeatureConfig(
   *               GenerativeQuestionsFeatureConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerativeQuestionsFeatureConfig> future =
   *       generativeQuestionServiceClient
   *           .updateGenerativeQuestionsFeatureConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GenerativeQuestionsFeatureConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      updateGenerativeQuestionsFeatureConfigCallable() {
    return stub.updateGenerativeQuestionsFeatureConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages overal generative question feature state -- enables toggling feature on and off.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   GenerativeQuestionsFeatureConfig response =
   *       generativeQuestionServiceClient.getGenerativeQuestionsFeatureConfig(catalog);
   * }
   * }</pre>
   *
   * @param catalog Required. Resource name of the parent catalog. Format:
   *     projects/{project}/locations/{location}/catalogs/{catalog}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerativeQuestionsFeatureConfig getGenerativeQuestionsFeatureConfig(
      CatalogName catalog) {
    GetGenerativeQuestionsFeatureConfigRequest request =
        GetGenerativeQuestionsFeatureConfigRequest.newBuilder()
            .setCatalog(catalog == null ? null : catalog.toString())
            .build();
    return getGenerativeQuestionsFeatureConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages overal generative question feature state -- enables toggling feature on and off.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   String catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   GenerativeQuestionsFeatureConfig response =
   *       generativeQuestionServiceClient.getGenerativeQuestionsFeatureConfig(catalog);
   * }
   * }</pre>
   *
   * @param catalog Required. Resource name of the parent catalog. Format:
   *     projects/{project}/locations/{location}/catalogs/{catalog}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerativeQuestionsFeatureConfig getGenerativeQuestionsFeatureConfig(
      String catalog) {
    GetGenerativeQuestionsFeatureConfigRequest request =
        GetGenerativeQuestionsFeatureConfigRequest.newBuilder().setCatalog(catalog).build();
    return getGenerativeQuestionsFeatureConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages overal generative question feature state -- enables toggling feature on and off.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   GetGenerativeQuestionsFeatureConfigRequest request =
   *       GetGenerativeQuestionsFeatureConfigRequest.newBuilder()
   *           .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   GenerativeQuestionsFeatureConfig response =
   *       generativeQuestionServiceClient.getGenerativeQuestionsFeatureConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerativeQuestionsFeatureConfig getGenerativeQuestionsFeatureConfig(
      GetGenerativeQuestionsFeatureConfigRequest request) {
    return getGenerativeQuestionsFeatureConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages overal generative question feature state -- enables toggling feature on and off.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   GetGenerativeQuestionsFeatureConfigRequest request =
   *       GetGenerativeQuestionsFeatureConfigRequest.newBuilder()
   *           .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<GenerativeQuestionsFeatureConfig> future =
   *       generativeQuestionServiceClient
   *           .getGenerativeQuestionsFeatureConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GenerativeQuestionsFeatureConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      getGenerativeQuestionsFeatureConfigCallable() {
    return stub.getGenerativeQuestionsFeatureConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all questions for a given catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   ListGenerativeQuestionConfigsResponse response =
   *       generativeQuestionServiceClient.listGenerativeQuestionConfigs(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent catalog. Format:
   *     projects/{project}/locations/{location}/catalogs/{catalog}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGenerativeQuestionConfigsResponse listGenerativeQuestionConfigs(
      CatalogName parent) {
    ListGenerativeQuestionConfigsRequest request =
        ListGenerativeQuestionConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGenerativeQuestionConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all questions for a given catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   ListGenerativeQuestionConfigsResponse response =
   *       generativeQuestionServiceClient.listGenerativeQuestionConfigs(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent catalog. Format:
   *     projects/{project}/locations/{location}/catalogs/{catalog}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGenerativeQuestionConfigsResponse listGenerativeQuestionConfigs(String parent) {
    ListGenerativeQuestionConfigsRequest request =
        ListGenerativeQuestionConfigsRequest.newBuilder().setParent(parent).build();
    return listGenerativeQuestionConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all questions for a given catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   ListGenerativeQuestionConfigsRequest request =
   *       ListGenerativeQuestionConfigsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ListGenerativeQuestionConfigsResponse response =
   *       generativeQuestionServiceClient.listGenerativeQuestionConfigs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGenerativeQuestionConfigsResponse listGenerativeQuestionConfigs(
      ListGenerativeQuestionConfigsRequest request) {
    return listGenerativeQuestionConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all questions for a given catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   ListGenerativeQuestionConfigsRequest request =
   *       ListGenerativeQuestionConfigsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<ListGenerativeQuestionConfigsResponse> future =
   *       generativeQuestionServiceClient
   *           .listGenerativeQuestionConfigsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ListGenerativeQuestionConfigsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
      listGenerativeQuestionConfigsCallable() {
    return stub.listGenerativeQuestionConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows management of individual questions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   GenerativeQuestionConfig generativeQuestionConfig =
   *       GenerativeQuestionConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GenerativeQuestionConfig response =
   *       generativeQuestionServiceClient.updateGenerativeQuestionConfig(
   *           generativeQuestionConfig, updateMask);
   * }
   * }</pre>
   *
   * @param generativeQuestionConfig Required. The question to update.
   * @param updateMask Optional. Indicates which fields in the provided
   *     [GenerativeQuestionConfig][google.cloud.retail.v2alpha.GenerativeQuestionConfig] to update.
   *     The following are NOT supported:
   *     <ul>
   *       <li>[GenerativeQuestionConfig.frequency][google.cloud.retail.v2alpha.GenerativeQuestionConfig.frequency]
   *     </ul>
   *     <p>If not set or empty, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerativeQuestionConfig updateGenerativeQuestionConfig(
      GenerativeQuestionConfig generativeQuestionConfig, FieldMask updateMask) {
    UpdateGenerativeQuestionConfigRequest request =
        UpdateGenerativeQuestionConfigRequest.newBuilder()
            .setGenerativeQuestionConfig(generativeQuestionConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateGenerativeQuestionConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows management of individual questions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   UpdateGenerativeQuestionConfigRequest request =
   *       UpdateGenerativeQuestionConfigRequest.newBuilder()
   *           .setGenerativeQuestionConfig(GenerativeQuestionConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GenerativeQuestionConfig response =
   *       generativeQuestionServiceClient.updateGenerativeQuestionConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerativeQuestionConfig updateGenerativeQuestionConfig(
      UpdateGenerativeQuestionConfigRequest request) {
    return updateGenerativeQuestionConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows management of individual questions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   UpdateGenerativeQuestionConfigRequest request =
   *       UpdateGenerativeQuestionConfigRequest.newBuilder()
   *           .setGenerativeQuestionConfig(GenerativeQuestionConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerativeQuestionConfig> future =
   *       generativeQuestionServiceClient
   *           .updateGenerativeQuestionConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GenerativeQuestionConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>
      updateGenerativeQuestionConfigCallable() {
    return stub.updateGenerativeQuestionConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows management of multiple questions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();
   *   BatchUpdateGenerativeQuestionConfigsResponse response =
   *       generativeQuestionServiceClient.batchUpdateGenerativeQuestionConfigs(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Optional. Resource name of the parent catalog. Format:
   *     projects/{project}/locations/{location}/catalogs/{catalog}
   * @param requests Required. The updates question configs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateGenerativeQuestionConfigsResponse batchUpdateGenerativeQuestionConfigs(
      CatalogName parent, List<UpdateGenerativeQuestionConfigRequest> requests) {
    BatchUpdateGenerativeQuestionConfigsRequest request =
        BatchUpdateGenerativeQuestionConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateGenerativeQuestionConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows management of multiple questions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();
   *   BatchUpdateGenerativeQuestionConfigsResponse response =
   *       generativeQuestionServiceClient.batchUpdateGenerativeQuestionConfigs(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Optional. Resource name of the parent catalog. Format:
   *     projects/{project}/locations/{location}/catalogs/{catalog}
   * @param requests Required. The updates question configs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateGenerativeQuestionConfigsResponse batchUpdateGenerativeQuestionConfigs(
      String parent, List<UpdateGenerativeQuestionConfigRequest> requests) {
    BatchUpdateGenerativeQuestionConfigsRequest request =
        BatchUpdateGenerativeQuestionConfigsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateGenerativeQuestionConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows management of multiple questions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   BatchUpdateGenerativeQuestionConfigsRequest request =
   *       BatchUpdateGenerativeQuestionConfigsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .addAllRequests(new ArrayList<UpdateGenerativeQuestionConfigRequest>())
   *           .build();
   *   BatchUpdateGenerativeQuestionConfigsResponse response =
   *       generativeQuestionServiceClient.batchUpdateGenerativeQuestionConfigs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateGenerativeQuestionConfigsResponse batchUpdateGenerativeQuestionConfigs(
      BatchUpdateGenerativeQuestionConfigsRequest request) {
    return batchUpdateGenerativeQuestionConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows management of multiple questions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenerativeQuestionServiceClient generativeQuestionServiceClient =
   *     GenerativeQuestionServiceClient.create()) {
   *   BatchUpdateGenerativeQuestionConfigsRequest request =
   *       BatchUpdateGenerativeQuestionConfigsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .addAllRequests(new ArrayList<UpdateGenerativeQuestionConfigRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateGenerativeQuestionConfigsResponse> future =
   *       generativeQuestionServiceClient
   *           .batchUpdateGenerativeQuestionConfigsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateGenerativeQuestionConfigsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateGenerativeQuestionConfigsRequest, BatchUpdateGenerativeQuestionConfigsResponse>
      batchUpdateGenerativeQuestionConfigsCallable() {
    return stub.batchUpdateGenerativeQuestionConfigsCallable();
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
