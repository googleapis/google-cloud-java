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

package com.google.shopping.merchant.conversions.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.conversions.v1beta.stub.ConversionSourcesServiceStub;
import com.google.shopping.merchant.conversions.v1beta.stub.ConversionSourcesServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing conversion sources for a merchant account.
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
 * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
 *     ConversionSourcesServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   ConversionSource conversionSource = ConversionSource.newBuilder().build();
 *   ConversionSource response =
 *       conversionSourcesServiceClient.createConversionSource(parent, conversionSource);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConversionSourcesServiceClient object to clean up
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
 *      <td><p> CreateConversionSource</td>
 *      <td><p> Creates a new conversion source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConversionSource(CreateConversionSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createConversionSource(AccountName parent, ConversionSource conversionSource)
 *           <li><p> createConversionSource(String parent, ConversionSource conversionSource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConversionSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConversionSource</td>
 *      <td><p> Updates information of an existing conversion source. Available only for Merchant Center Destination conversion sources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConversionSource(UpdateConversionSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateConversionSource(ConversionSource conversionSource, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConversionSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConversionSource</td>
 *      <td><p> Archives an existing conversion source. If the conversion source is a Merchant Center Destination, it will be recoverable for 30 days. If the conversion source is a Google Analytics Link, it will be deleted immediately and can be restored by creating a new one.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConversionSource(DeleteConversionSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteConversionSource(ConversionSourceName name)
 *           <li><p> deleteConversionSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConversionSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeleteConversionSource</td>
 *      <td><p> Re-enables an archived conversion source. Only Available for Merchant Center Destination conversion sources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeleteConversionSource(UndeleteConversionSourceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeleteConversionSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConversionSource</td>
 *      <td><p> Fetches a conversion source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConversionSource(GetConversionSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConversionSource(ConversionSourceName name)
 *           <li><p> getConversionSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConversionSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListConversionSources</td>
 *      <td><p> Retrieves the list of conversion sources the caller has access to.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConversionSources(ListConversionSourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConversionSources(AccountName parent)
 *           <li><p> listConversionSources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConversionSourcesPagedCallable()
 *           <li><p> listConversionSourcesCallable()
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
 * ConversionSourcesServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversionSourcesServiceSettings conversionSourcesServiceSettings =
 *     ConversionSourcesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConversionSourcesServiceClient conversionSourcesServiceClient =
 *     ConversionSourcesServiceClient.create(conversionSourcesServiceSettings);
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
 * ConversionSourcesServiceSettings conversionSourcesServiceSettings =
 *     ConversionSourcesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConversionSourcesServiceClient conversionSourcesServiceClient =
 *     ConversionSourcesServiceClient.create(conversionSourcesServiceSettings);
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
 * ConversionSourcesServiceSettings conversionSourcesServiceSettings =
 *     ConversionSourcesServiceSettings.newHttpJsonBuilder().build();
 * ConversionSourcesServiceClient conversionSourcesServiceClient =
 *     ConversionSourcesServiceClient.create(conversionSourcesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConversionSourcesServiceClient implements BackgroundResource {
  private final ConversionSourcesServiceSettings settings;
  private final ConversionSourcesServiceStub stub;

  /** Constructs an instance of ConversionSourcesServiceClient with default settings. */
  public static final ConversionSourcesServiceClient create() throws IOException {
    return create(ConversionSourcesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConversionSourcesServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ConversionSourcesServiceClient create(
      ConversionSourcesServiceSettings settings) throws IOException {
    return new ConversionSourcesServiceClient(settings);
  }

  /**
   * Constructs an instance of ConversionSourcesServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ConversionSourcesServiceSettings).
   */
  public static final ConversionSourcesServiceClient create(ConversionSourcesServiceStub stub) {
    return new ConversionSourcesServiceClient(stub);
  }

  /**
   * Constructs an instance of ConversionSourcesServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ConversionSourcesServiceClient(ConversionSourcesServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ConversionSourcesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ConversionSourcesServiceClient(ConversionSourcesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConversionSourcesServiceSettings getSettings() {
    return settings;
  }

  public ConversionSourcesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversion source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   ConversionSource conversionSource = ConversionSource.newBuilder().build();
   *   ConversionSource response =
   *       conversionSourcesServiceClient.createConversionSource(parent, conversionSource);
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account that will own the new conversion source. Format:
   *     accounts/{account}
   * @param conversionSource Required. The conversion source description. A new ID will be
   *     automatically assigned to it upon creation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource createConversionSource(
      AccountName parent, ConversionSource conversionSource) {
    CreateConversionSourceRequest request =
        CreateConversionSourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversionSource(conversionSource)
            .build();
    return createConversionSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversion source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   ConversionSource conversionSource = ConversionSource.newBuilder().build();
   *   ConversionSource response =
   *       conversionSourcesServiceClient.createConversionSource(parent, conversionSource);
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account that will own the new conversion source. Format:
   *     accounts/{account}
   * @param conversionSource Required. The conversion source description. A new ID will be
   *     automatically assigned to it upon creation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource createConversionSource(
      String parent, ConversionSource conversionSource) {
    CreateConversionSourceRequest request =
        CreateConversionSourceRequest.newBuilder()
            .setParent(parent)
            .setConversionSource(conversionSource)
            .build();
    return createConversionSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversion source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   CreateConversionSourceRequest request =
   *       CreateConversionSourceRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setConversionSource(ConversionSource.newBuilder().build())
   *           .build();
   *   ConversionSource response = conversionSourcesServiceClient.createConversionSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource createConversionSource(CreateConversionSourceRequest request) {
    return createConversionSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversion source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   CreateConversionSourceRequest request =
   *       CreateConversionSourceRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setConversionSource(ConversionSource.newBuilder().build())
   *           .build();
   *   ApiFuture<ConversionSource> future =
   *       conversionSourcesServiceClient.createConversionSourceCallable().futureCall(request);
   *   // Do something.
   *   ConversionSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceCallable() {
    return stub.createConversionSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates information of an existing conversion source. Available only for Merchant Center
   * Destination conversion sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   ConversionSource conversionSource = ConversionSource.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ConversionSource response =
   *       conversionSourcesServiceClient.updateConversionSource(conversionSource, updateMask);
   * }
   * }</pre>
   *
   * @param conversionSource Required. The new version of the conversion source data. Format:
   *     accounts/{account}/conversionSources/{conversion_source}
   * @param updateMask Required. List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource updateConversionSource(
      ConversionSource conversionSource, FieldMask updateMask) {
    UpdateConversionSourceRequest request =
        UpdateConversionSourceRequest.newBuilder()
            .setConversionSource(conversionSource)
            .setUpdateMask(updateMask)
            .build();
    return updateConversionSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates information of an existing conversion source. Available only for Merchant Center
   * Destination conversion sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   UpdateConversionSourceRequest request =
   *       UpdateConversionSourceRequest.newBuilder()
   *           .setConversionSource(ConversionSource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ConversionSource response = conversionSourcesServiceClient.updateConversionSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource updateConversionSource(UpdateConversionSourceRequest request) {
    return updateConversionSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates information of an existing conversion source. Available only for Merchant Center
   * Destination conversion sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   UpdateConversionSourceRequest request =
   *       UpdateConversionSourceRequest.newBuilder()
   *           .setConversionSource(ConversionSource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ConversionSource> future =
   *       conversionSourcesServiceClient.updateConversionSourceCallable().futureCall(request);
   *   // Do something.
   *   ConversionSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceCallable() {
    return stub.updateConversionSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives an existing conversion source. If the conversion source is a Merchant Center
   * Destination, it will be recoverable for 30 days. If the conversion source is a Google Analytics
   * Link, it will be deleted immediately and can be restored by creating a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");
   *   conversionSourcesServiceClient.deleteConversionSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversion source to be deleted. Format:
   *     accounts/{account}/conversionSources/{conversion_source}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversionSource(ConversionSourceName name) {
    DeleteConversionSourceRequest request =
        DeleteConversionSourceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteConversionSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives an existing conversion source. If the conversion source is a Merchant Center
   * Destination, it will be recoverable for 30 days. If the conversion source is a Google Analytics
   * Link, it will be deleted immediately and can be restored by creating a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   String name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString();
   *   conversionSourcesServiceClient.deleteConversionSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversion source to be deleted. Format:
   *     accounts/{account}/conversionSources/{conversion_source}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversionSource(String name) {
    DeleteConversionSourceRequest request =
        DeleteConversionSourceRequest.newBuilder().setName(name).build();
    deleteConversionSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives an existing conversion source. If the conversion source is a Merchant Center
   * Destination, it will be recoverable for 30 days. If the conversion source is a Google Analytics
   * Link, it will be deleted immediately and can be restored by creating a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   DeleteConversionSourceRequest request =
   *       DeleteConversionSourceRequest.newBuilder()
   *           .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
   *           .build();
   *   conversionSourcesServiceClient.deleteConversionSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversionSource(DeleteConversionSourceRequest request) {
    deleteConversionSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives an existing conversion source. If the conversion source is a Merchant Center
   * Destination, it will be recoverable for 30 days. If the conversion source is a Google Analytics
   * Link, it will be deleted immediately and can be restored by creating a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   DeleteConversionSourceRequest request =
   *       DeleteConversionSourceRequest.newBuilder()
   *           .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       conversionSourcesServiceClient.deleteConversionSourceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConversionSourceRequest, Empty>
      deleteConversionSourceCallable() {
    return stub.deleteConversionSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Re-enables an archived conversion source. Only Available for Merchant Center Destination
   * conversion sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   UndeleteConversionSourceRequest request =
   *       UndeleteConversionSourceRequest.newBuilder()
   *           .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
   *           .build();
   *   ConversionSource response = conversionSourcesServiceClient.undeleteConversionSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource undeleteConversionSource(UndeleteConversionSourceRequest request) {
    return undeleteConversionSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Re-enables an archived conversion source. Only Available for Merchant Center Destination
   * conversion sources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   UndeleteConversionSourceRequest request =
   *       UndeleteConversionSourceRequest.newBuilder()
   *           .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
   *           .build();
   *   ApiFuture<ConversionSource> future =
   *       conversionSourcesServiceClient.undeleteConversionSourceCallable().futureCall(request);
   *   // Do something.
   *   ConversionSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceCallable() {
    return stub.undeleteConversionSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a conversion source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");
   *   ConversionSource response = conversionSourcesServiceClient.getConversionSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversion source to be fetched. Format:
   *     accounts/{account}/conversionsources/{conversion_source}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource getConversionSource(ConversionSourceName name) {
    GetConversionSourceRequest request =
        GetConversionSourceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConversionSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a conversion source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   String name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString();
   *   ConversionSource response = conversionSourcesServiceClient.getConversionSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversion source to be fetched. Format:
   *     accounts/{account}/conversionsources/{conversion_source}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource getConversionSource(String name) {
    GetConversionSourceRequest request =
        GetConversionSourceRequest.newBuilder().setName(name).build();
    return getConversionSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a conversion source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   GetConversionSourceRequest request =
   *       GetConversionSourceRequest.newBuilder()
   *           .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
   *           .build();
   *   ConversionSource response = conversionSourcesServiceClient.getConversionSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversionSource getConversionSource(GetConversionSourceRequest request) {
    return getConversionSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches a conversion source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   GetConversionSourceRequest request =
   *       GetConversionSourceRequest.newBuilder()
   *           .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
   *           .build();
   *   ApiFuture<ConversionSource> future =
   *       conversionSourcesServiceClient.getConversionSourceCallable().futureCall(request);
   *   // Do something.
   *   ConversionSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversionSourceRequest, ConversionSource>
      getConversionSourceCallable() {
    return stub.getConversionSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of conversion sources the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (ConversionSource element :
   *       conversionSourcesServiceClient.listConversionSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account who owns the collection of conversion sources.
   *     Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversionSourcesPagedResponse listConversionSources(AccountName parent) {
    ListConversionSourcesRequest request =
        ListConversionSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversionSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of conversion sources the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (ConversionSource element :
   *       conversionSourcesServiceClient.listConversionSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account who owns the collection of conversion sources.
   *     Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversionSourcesPagedResponse listConversionSources(String parent) {
    ListConversionSourcesRequest request =
        ListConversionSourcesRequest.newBuilder().setParent(parent).build();
    return listConversionSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of conversion sources the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   ListConversionSourcesRequest request =
   *       ListConversionSourcesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (ConversionSource element :
   *       conversionSourcesServiceClient.listConversionSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversionSourcesPagedResponse listConversionSources(
      ListConversionSourcesRequest request) {
    return listConversionSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of conversion sources the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   ListConversionSourcesRequest request =
   *       ListConversionSourcesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<ConversionSource> future =
   *       conversionSourcesServiceClient.listConversionSourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConversionSource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesPagedResponse>
      listConversionSourcesPagedCallable() {
    return stub.listConversionSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of conversion sources the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversionSourcesServiceClient conversionSourcesServiceClient =
   *     ConversionSourcesServiceClient.create()) {
   *   ListConversionSourcesRequest request =
   *       ListConversionSourcesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListConversionSourcesResponse response =
   *         conversionSourcesServiceClient.listConversionSourcesCallable().call(request);
   *     for (ConversionSource element : response.getConversionSourcesList()) {
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
  public final UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesResponse>
      listConversionSourcesCallable() {
    return stub.listConversionSourcesCallable();
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

  public static class ListConversionSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListConversionSourcesRequest,
          ListConversionSourcesResponse,
          ConversionSource,
          ListConversionSourcesPage,
          ListConversionSourcesFixedSizeCollection> {

    public static ApiFuture<ListConversionSourcesPagedResponse> createAsync(
        PageContext<ListConversionSourcesRequest, ListConversionSourcesResponse, ConversionSource>
            context,
        ApiFuture<ListConversionSourcesResponse> futureResponse) {
      ApiFuture<ListConversionSourcesPage> futurePage =
          ListConversionSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversionSourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversionSourcesPagedResponse(ListConversionSourcesPage page) {
      super(page, ListConversionSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversionSourcesPage
      extends AbstractPage<
          ListConversionSourcesRequest,
          ListConversionSourcesResponse,
          ConversionSource,
          ListConversionSourcesPage> {

    private ListConversionSourcesPage(
        PageContext<ListConversionSourcesRequest, ListConversionSourcesResponse, ConversionSource>
            context,
        ListConversionSourcesResponse response) {
      super(context, response);
    }

    private static ListConversionSourcesPage createEmptyPage() {
      return new ListConversionSourcesPage(null, null);
    }

    @Override
    protected ListConversionSourcesPage createPage(
        PageContext<ListConversionSourcesRequest, ListConversionSourcesResponse, ConversionSource>
            context,
        ListConversionSourcesResponse response) {
      return new ListConversionSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListConversionSourcesPage> createPageAsync(
        PageContext<ListConversionSourcesRequest, ListConversionSourcesResponse, ConversionSource>
            context,
        ApiFuture<ListConversionSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversionSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversionSourcesRequest,
          ListConversionSourcesResponse,
          ConversionSource,
          ListConversionSourcesPage,
          ListConversionSourcesFixedSizeCollection> {

    private ListConversionSourcesFixedSizeCollection(
        List<ListConversionSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversionSourcesFixedSizeCollection createEmptyCollection() {
      return new ListConversionSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversionSourcesFixedSizeCollection createCollection(
        List<ListConversionSourcesPage> pages, int collectionSize) {
      return new ListConversionSourcesFixedSizeCollection(pages, collectionSize);
    }
  }
}
