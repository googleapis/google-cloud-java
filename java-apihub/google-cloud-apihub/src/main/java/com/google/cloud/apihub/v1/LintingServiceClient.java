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

package com.google.cloud.apihub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.stub.LintingServiceStub;
import com.google.cloud.apihub.v1.stub.LintingServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service provides all methods related to the 1p Linter.
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
 * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
 *   StyleGuideName name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
 *   StyleGuide response = lintingServiceClient.getStyleGuide(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LintingServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetStyleGuide</td>
 *      <td><p> Get the style guide being used for linting.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getStyleGuide(GetStyleGuideRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getStyleGuide(StyleGuideName name)
 *           <li><p> getStyleGuide(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getStyleGuideCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateStyleGuide</td>
 *      <td><p> Update the styleGuide to be used for liniting in by API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateStyleGuide(UpdateStyleGuideRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateStyleGuide(StyleGuide styleGuide, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateStyleGuideCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetStyleGuideContents</td>
 *      <td><p> Get the contents of the style guide.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getStyleGuideContents(GetStyleGuideContentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getStyleGuideContents(StyleGuideName name)
 *           <li><p> getStyleGuideContents(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getStyleGuideContentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LintSpec</td>
 *      <td><p> Lints the requested spec and updates the corresponding API Spec with the lint response. This lint response will be available in all subsequent Get and List Spec calls to Core service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lintSpec(LintSpecRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lintSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of LintingServiceSettings to
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
 * LintingServiceSettings lintingServiceSettings =
 *     LintingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LintingServiceClient lintingServiceClient = LintingServiceClient.create(lintingServiceSettings);
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
 * LintingServiceSettings lintingServiceSettings =
 *     LintingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LintingServiceClient lintingServiceClient = LintingServiceClient.create(lintingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LintingServiceClient implements BackgroundResource {
  private final LintingServiceSettings settings;
  private final LintingServiceStub stub;

  /** Constructs an instance of LintingServiceClient with default settings. */
  public static final LintingServiceClient create() throws IOException {
    return create(LintingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LintingServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LintingServiceClient create(LintingServiceSettings settings)
      throws IOException {
    return new LintingServiceClient(settings);
  }

  /**
   * Constructs an instance of LintingServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LintingServiceSettings).
   */
  public static final LintingServiceClient create(LintingServiceStub stub) {
    return new LintingServiceClient(stub);
  }

  /**
   * Constructs an instance of LintingServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LintingServiceClient(LintingServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LintingServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LintingServiceClient(LintingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LintingServiceSettings getSettings() {
    return settings;
  }

  public LintingServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the style guide being used for linting.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   StyleGuideName name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
   *   StyleGuide response = lintingServiceClient.getStyleGuide(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to retrieve. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/styleGuide`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleGuide getStyleGuide(StyleGuideName name) {
    GetStyleGuideRequest request =
        GetStyleGuideRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStyleGuide(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the style guide being used for linting.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   String name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString();
   *   StyleGuide response = lintingServiceClient.getStyleGuide(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to retrieve. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/styleGuide`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleGuide getStyleGuide(String name) {
    GetStyleGuideRequest request = GetStyleGuideRequest.newBuilder().setName(name).build();
    return getStyleGuide(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the style guide being used for linting.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   GetStyleGuideRequest request =
   *       GetStyleGuideRequest.newBuilder()
   *           .setName(StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   StyleGuide response = lintingServiceClient.getStyleGuide(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleGuide getStyleGuide(GetStyleGuideRequest request) {
    return getStyleGuideCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the style guide being used for linting.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   GetStyleGuideRequest request =
   *       GetStyleGuideRequest.newBuilder()
   *           .setName(StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   ApiFuture<StyleGuide> future =
   *       lintingServiceClient.getStyleGuideCallable().futureCall(request);
   *   // Do something.
   *   StyleGuide response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStyleGuideRequest, StyleGuide> getStyleGuideCallable() {
    return stub.getStyleGuideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the styleGuide to be used for liniting in by API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   StyleGuide styleGuide = StyleGuide.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   StyleGuide response = lintingServiceClient.updateStyleGuide(styleGuide, updateMask);
   * }
   * }</pre>
   *
   * @param styleGuide Required. The Style guide resource to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleGuide updateStyleGuide(StyleGuide styleGuide, FieldMask updateMask) {
    UpdateStyleGuideRequest request =
        UpdateStyleGuideRequest.newBuilder()
            .setStyleGuide(styleGuide)
            .setUpdateMask(updateMask)
            .build();
    return updateStyleGuide(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the styleGuide to be used for liniting in by API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   UpdateStyleGuideRequest request =
   *       UpdateStyleGuideRequest.newBuilder()
   *           .setStyleGuide(StyleGuide.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   StyleGuide response = lintingServiceClient.updateStyleGuide(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleGuide updateStyleGuide(UpdateStyleGuideRequest request) {
    return updateStyleGuideCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the styleGuide to be used for liniting in by API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   UpdateStyleGuideRequest request =
   *       UpdateStyleGuideRequest.newBuilder()
   *           .setStyleGuide(StyleGuide.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<StyleGuide> future =
   *       lintingServiceClient.updateStyleGuideCallable().futureCall(request);
   *   // Do something.
   *   StyleGuide response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateStyleGuideRequest, StyleGuide> updateStyleGuideCallable() {
    return stub.updateStyleGuideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the contents of the style guide.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   StyleGuideName name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
   *   StyleGuideContents response = lintingServiceClient.getStyleGuideContents(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the StyleGuide whose contents need to be retrieved. There is
   *     exactly one style guide resource per project per location. The expected format is
   *     `projects/{project}/locations/{location}/plugins/{plugin}/styleGuide`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleGuideContents getStyleGuideContents(StyleGuideName name) {
    GetStyleGuideContentsRequest request =
        GetStyleGuideContentsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getStyleGuideContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the contents of the style guide.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   String name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString();
   *   StyleGuideContents response = lintingServiceClient.getStyleGuideContents(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the StyleGuide whose contents need to be retrieved. There is
   *     exactly one style guide resource per project per location. The expected format is
   *     `projects/{project}/locations/{location}/plugins/{plugin}/styleGuide`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleGuideContents getStyleGuideContents(String name) {
    GetStyleGuideContentsRequest request =
        GetStyleGuideContentsRequest.newBuilder().setName(name).build();
    return getStyleGuideContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the contents of the style guide.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   GetStyleGuideContentsRequest request =
   *       GetStyleGuideContentsRequest.newBuilder()
   *           .setName(StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   StyleGuideContents response = lintingServiceClient.getStyleGuideContents(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleGuideContents getStyleGuideContents(GetStyleGuideContentsRequest request) {
    return getStyleGuideContentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the contents of the style guide.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   GetStyleGuideContentsRequest request =
   *       GetStyleGuideContentsRequest.newBuilder()
   *           .setName(StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   ApiFuture<StyleGuideContents> future =
   *       lintingServiceClient.getStyleGuideContentsCallable().futureCall(request);
   *   // Do something.
   *   StyleGuideContents response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStyleGuideContentsRequest, StyleGuideContents>
      getStyleGuideContentsCallable() {
    return stub.getStyleGuideContentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lints the requested spec and updates the corresponding API Spec with the lint response. This
   * lint response will be available in all subsequent Get and List Spec calls to Core service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   LintSpecRequest request =
   *       LintSpecRequest.newBuilder()
   *           .setName(
   *               SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
   *           .build();
   *   lintingServiceClient.lintSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void lintSpec(LintSpecRequest request) {
    lintSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lints the requested spec and updates the corresponding API Spec with the lint response. This
   * lint response will be available in all subsequent Get and List Spec calls to Core service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   LintSpecRequest request =
   *       LintSpecRequest.newBuilder()
   *           .setName(
   *               SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
   *           .build();
   *   ApiFuture<Empty> future = lintingServiceClient.lintSpecCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LintSpecRequest, Empty> lintSpecCallable() {
    return stub.lintSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : lintingServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       lintingServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = lintingServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = lintingServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = lintingServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
