/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.stub.LicenseConfigServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.LicenseConfigServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing license config related resources.
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
 * try (LicenseConfigServiceClient licenseConfigServiceClient =
 *     LicenseConfigServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
 *   String licenseConfigId = "licenseConfigId-372057250";
 *   LicenseConfig response =
 *       licenseConfigServiceClient.createLicenseConfig(parent, licenseConfig, licenseConfigId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LicenseConfigServiceClient object to clean up
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
 *      <td><p> CreateLicenseConfig</td>
 *      <td><p> Creates a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This method should only be used for creating NotebookLm licenses or Gemini Enterprise free trial licenses.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLicenseConfig(CreateLicenseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createLicenseConfig(LocationName parent, LicenseConfig licenseConfig, String licenseConfigId)
 *           <li><p> createLicenseConfig(String parent, LicenseConfig licenseConfig, String licenseConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLicenseConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLicenseConfig</td>
 *      <td><p> Updates the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLicenseConfig(UpdateLicenseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLicenseConfig(LicenseConfig licenseConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLicenseConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLicenseConfig</td>
 *      <td><p> Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLicenseConfig(GetLicenseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLicenseConfig(LicenseConfigName name)
 *           <li><p> getLicenseConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLicenseConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLicenseConfigs</td>
 *      <td><p> Lists all the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s associated with the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLicenseConfigs(ListLicenseConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLicenseConfigs(LocationName parent)
 *           <li><p> listLicenseConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLicenseConfigsPagedCallable()
 *           <li><p> listLicenseConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DistributeLicenseConfig</td>
 *      <td><p> Distributes a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from billing account level to project level.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> distributeLicenseConfig(DistributeLicenseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> distributeLicenseConfig(BillingAccountLicenseConfigName billingAccountLicenseConfig, long projectNumber, String location, long licenseCount, String licenseConfigId)
 *           <li><p> distributeLicenseConfig(String billingAccountLicenseConfig, long projectNumber, String location, long licenseCount, String licenseConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> distributeLicenseConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetractLicenseConfig</td>
 *      <td><p> This method is called from the billing account side to retract the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the given project back to the billing account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retractLicenseConfig(RetractLicenseConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> retractLicenseConfig(BillingAccountLicenseConfigName billingAccountLicenseConfig, LicenseConfigName licenseConfig, boolean fullRetract, long licenseCount)
 *           <li><p> retractLicenseConfig(BillingAccountLicenseConfigName billingAccountLicenseConfig, String licenseConfig, boolean fullRetract, long licenseCount)
 *           <li><p> retractLicenseConfig(String billingAccountLicenseConfig, LicenseConfigName licenseConfig, boolean fullRetract, long licenseCount)
 *           <li><p> retractLicenseConfig(String billingAccountLicenseConfig, String licenseConfig, boolean fullRetract, long licenseCount)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retractLicenseConfigCallable()
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
 * <p>This class can be customized by passing in a custom instance of LicenseConfigServiceSettings
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
 * LicenseConfigServiceSettings licenseConfigServiceSettings =
 *     LicenseConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LicenseConfigServiceClient licenseConfigServiceClient =
 *     LicenseConfigServiceClient.create(licenseConfigServiceSettings);
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
 * LicenseConfigServiceSettings licenseConfigServiceSettings =
 *     LicenseConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LicenseConfigServiceClient licenseConfigServiceClient =
 *     LicenseConfigServiceClient.create(licenseConfigServiceSettings);
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
 * LicenseConfigServiceSettings licenseConfigServiceSettings =
 *     LicenseConfigServiceSettings.newHttpJsonBuilder().build();
 * LicenseConfigServiceClient licenseConfigServiceClient =
 *     LicenseConfigServiceClient.create(licenseConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class LicenseConfigServiceClient implements BackgroundResource {
  private final LicenseConfigServiceSettings settings;
  private final LicenseConfigServiceStub stub;

  /** Constructs an instance of LicenseConfigServiceClient with default settings. */
  public static final LicenseConfigServiceClient create() throws IOException {
    return create(LicenseConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LicenseConfigServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LicenseConfigServiceClient create(LicenseConfigServiceSettings settings)
      throws IOException {
    return new LicenseConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of LicenseConfigServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(LicenseConfigServiceSettings).
   */
  public static final LicenseConfigServiceClient create(LicenseConfigServiceStub stub) {
    return new LicenseConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of LicenseConfigServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LicenseConfigServiceClient(LicenseConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LicenseConfigServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LicenseConfigServiceClient(LicenseConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LicenseConfigServiceSettings getSettings() {
    return settings;
  }

  public LicenseConfigServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This method should
   * only be used for creating NotebookLm licenses or Gemini Enterprise free trial licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
   *   String licenseConfigId = "licenseConfigId-372057250";
   *   LicenseConfig response =
   *       licenseConfigServiceClient.createLicenseConfig(parent, licenseConfig, licenseConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @param licenseConfig Required. The
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] to create.
   * @param licenseConfigId Optional. The ID to use for the
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig], which will become the
   *     final component of the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]'s
   *     resource name. We are using the tier (product edition) name as the license config id such
   *     as `search` or `search_and_assistant`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseConfig createLicenseConfig(
      LocationName parent, LicenseConfig licenseConfig, String licenseConfigId) {
    CreateLicenseConfigRequest request =
        CreateLicenseConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLicenseConfig(licenseConfig)
            .setLicenseConfigId(licenseConfigId)
            .build();
    return createLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This method should
   * only be used for creating NotebookLm licenses or Gemini Enterprise free trial licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
   *   String licenseConfigId = "licenseConfigId-372057250";
   *   LicenseConfig response =
   *       licenseConfigServiceClient.createLicenseConfig(parent, licenseConfig, licenseConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @param licenseConfig Required. The
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] to create.
   * @param licenseConfigId Optional. The ID to use for the
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig], which will become the
   *     final component of the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]'s
   *     resource name. We are using the tier (product edition) name as the license config id such
   *     as `search` or `search_and_assistant`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseConfig createLicenseConfig(
      String parent, LicenseConfig licenseConfig, String licenseConfigId) {
    CreateLicenseConfigRequest request =
        CreateLicenseConfigRequest.newBuilder()
            .setParent(parent)
            .setLicenseConfig(licenseConfig)
            .setLicenseConfigId(licenseConfigId)
            .build();
    return createLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This method should
   * only be used for creating NotebookLm licenses or Gemini Enterprise free trial licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   CreateLicenseConfigRequest request =
   *       CreateLicenseConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLicenseConfig(LicenseConfig.newBuilder().build())
   *           .setLicenseConfigId("licenseConfigId-372057250")
   *           .build();
   *   LicenseConfig response = licenseConfigServiceClient.createLicenseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseConfig createLicenseConfig(CreateLicenseConfigRequest request) {
    return createLicenseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] This method should
   * only be used for creating NotebookLm licenses or Gemini Enterprise free trial licenses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   CreateLicenseConfigRequest request =
   *       CreateLicenseConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLicenseConfig(LicenseConfig.newBuilder().build())
   *           .setLicenseConfigId("licenseConfigId-372057250")
   *           .build();
   *   ApiFuture<LicenseConfig> future =
   *       licenseConfigServiceClient.createLicenseConfigCallable().futureCall(request);
   *   // Do something.
   *   LicenseConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLicenseConfigRequest, LicenseConfig>
      createLicenseConfigCallable() {
    return stub.createLicenseConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LicenseConfig response =
   *       licenseConfigServiceClient.updateLicenseConfig(licenseConfig, updateMask);
   * }
   * }</pre>
   *
   * @param licenseConfig Required. The
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] to update.
   * @param updateMask Optional. Indicates which fields in the provided
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] to update.
   *     <p>If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseConfig updateLicenseConfig(
      LicenseConfig licenseConfig, FieldMask updateMask) {
    UpdateLicenseConfigRequest request =
        UpdateLicenseConfigRequest.newBuilder()
            .setLicenseConfig(licenseConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   UpdateLicenseConfigRequest request =
   *       UpdateLicenseConfigRequest.newBuilder()
   *           .setLicenseConfig(LicenseConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LicenseConfig response = licenseConfigServiceClient.updateLicenseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseConfig updateLicenseConfig(UpdateLicenseConfigRequest request) {
    return updateLicenseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   UpdateLicenseConfigRequest request =
   *       UpdateLicenseConfigRequest.newBuilder()
   *           .setLicenseConfig(LicenseConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LicenseConfig> future =
   *       licenseConfigServiceClient.updateLicenseConfigCallable().futureCall(request);
   *   // Do something.
   *   LicenseConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLicenseConfigRequest, LicenseConfig>
      updateLicenseConfigCallable() {
    return stub.updateLicenseConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   LicenseConfigName name = LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
   *   LicenseConfig response = licenseConfigServiceClient.getLicenseConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig], such as
   *     `projects/{project}/locations/{location}/licenseConfigs/&#42;`.
   *     <p>If the caller does not have permission to access the
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig], regardless of whether
   *     or not it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] does
   *     not exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseConfig getLicenseConfig(LicenseConfigName name) {
    GetLicenseConfigRequest request =
        GetLicenseConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   String name = LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString();
   *   LicenseConfig response = licenseConfigServiceClient.getLicenseConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig], such as
   *     `projects/{project}/locations/{location}/licenseConfigs/&#42;`.
   *     <p>If the caller does not have permission to access the
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig], regardless of whether
   *     or not it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] does
   *     not exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseConfig getLicenseConfig(String name) {
    GetLicenseConfigRequest request = GetLicenseConfigRequest.newBuilder().setName(name).build();
    return getLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   GetLicenseConfigRequest request =
   *       GetLicenseConfigRequest.newBuilder()
   *           .setName(
   *               LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
   *           .build();
   *   LicenseConfig response = licenseConfigServiceClient.getLicenseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseConfig getLicenseConfig(GetLicenseConfigRequest request) {
    return getLicenseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   GetLicenseConfigRequest request =
   *       GetLicenseConfigRequest.newBuilder()
   *           .setName(
   *               LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
   *           .build();
   *   ApiFuture<LicenseConfig> future =
   *       licenseConfigServiceClient.getLicenseConfigCallable().futureCall(request);
   *   // Do something.
   *   LicenseConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigCallable() {
    return stub.getLicenseConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s associated
   * with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (LicenseConfig element :
   *       licenseConfigServiceClient.listLicenseConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLicenseConfigsPagedResponse listLicenseConfigs(LocationName parent) {
    ListLicenseConfigsRequest request =
        ListLicenseConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLicenseConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s associated
   * with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (LicenseConfig element :
   *       licenseConfigServiceClient.listLicenseConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLicenseConfigsPagedResponse listLicenseConfigs(String parent) {
    ListLicenseConfigsRequest request =
        ListLicenseConfigsRequest.newBuilder().setParent(parent).build();
    return listLicenseConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s associated
   * with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   ListLicenseConfigsRequest request =
   *       ListLicenseConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (LicenseConfig element :
   *       licenseConfigServiceClient.listLicenseConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLicenseConfigsPagedResponse listLicenseConfigs(
      ListLicenseConfigsRequest request) {
    return listLicenseConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s associated
   * with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   ListLicenseConfigsRequest request =
   *       ListLicenseConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<LicenseConfig> future =
   *       licenseConfigServiceClient.listLicenseConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LicenseConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsPagedResponse>
      listLicenseConfigsPagedCallable() {
    return stub.listLicenseConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig]s associated
   * with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   ListLicenseConfigsRequest request =
   *       ListLicenseConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListLicenseConfigsResponse response =
   *         licenseConfigServiceClient.listLicenseConfigsCallable().call(request);
   *     for (LicenseConfig element : response.getLicenseConfigsList()) {
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
  public final UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
      listLicenseConfigsCallable() {
    return stub.listLicenseConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Distributes a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from billing
   * account level to project level.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   BillingAccountLicenseConfigName billingAccountLicenseConfig =
   *       BillingAccountLicenseConfigName.of(
   *           "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
   *   long projectNumber = 828084015;
   *   String location = "location1901043637";
   *   long licenseCount = -1565113455;
   *   String licenseConfigId = "licenseConfigId-372057250";
   *   DistributeLicenseConfigResponse response =
   *       licenseConfigServiceClient.distributeLicenseConfig(
   *           billingAccountLicenseConfig, projectNumber, location, licenseCount, licenseConfigId);
   * }
   * }</pre>
   *
   * @param billingAccountLicenseConfig Required. Full resource name of
   *     [BillingAccountLicenseConfig][].
   *     <p>Format:
   *     `billingAccounts/{billing_account}/billingAccountLicenseConfigs/{billing_account_license_config_id}`.
   * @param projectNumber Required. The target GCP project number to distribute the license config
   *     to.
   * @param location Required. The target GCP project region to distribute the license config to.
   * @param licenseCount Required. The number of licenses to distribute.
   * @param licenseConfigId Optional. Distribute seats to this license config instead of creating a
   *     new one. If not specified, a new license config will be created from the billing account
   *     license config.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DistributeLicenseConfigResponse distributeLicenseConfig(
      BillingAccountLicenseConfigName billingAccountLicenseConfig,
      long projectNumber,
      String location,
      long licenseCount,
      String licenseConfigId) {
    DistributeLicenseConfigRequest request =
        DistributeLicenseConfigRequest.newBuilder()
            .setBillingAccountLicenseConfig(
                billingAccountLicenseConfig == null ? null : billingAccountLicenseConfig.toString())
            .setProjectNumber(projectNumber)
            .setLocation(location)
            .setLicenseCount(licenseCount)
            .setLicenseConfigId(licenseConfigId)
            .build();
    return distributeLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Distributes a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from billing
   * account level to project level.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   String billingAccountLicenseConfig =
   *       BillingAccountLicenseConfigName.of(
   *               "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]")
   *           .toString();
   *   long projectNumber = 828084015;
   *   String location = "location1901043637";
   *   long licenseCount = -1565113455;
   *   String licenseConfigId = "licenseConfigId-372057250";
   *   DistributeLicenseConfigResponse response =
   *       licenseConfigServiceClient.distributeLicenseConfig(
   *           billingAccountLicenseConfig, projectNumber, location, licenseCount, licenseConfigId);
   * }
   * }</pre>
   *
   * @param billingAccountLicenseConfig Required. Full resource name of
   *     [BillingAccountLicenseConfig][].
   *     <p>Format:
   *     `billingAccounts/{billing_account}/billingAccountLicenseConfigs/{billing_account_license_config_id}`.
   * @param projectNumber Required. The target GCP project number to distribute the license config
   *     to.
   * @param location Required. The target GCP project region to distribute the license config to.
   * @param licenseCount Required. The number of licenses to distribute.
   * @param licenseConfigId Optional. Distribute seats to this license config instead of creating a
   *     new one. If not specified, a new license config will be created from the billing account
   *     license config.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DistributeLicenseConfigResponse distributeLicenseConfig(
      String billingAccountLicenseConfig,
      long projectNumber,
      String location,
      long licenseCount,
      String licenseConfigId) {
    DistributeLicenseConfigRequest request =
        DistributeLicenseConfigRequest.newBuilder()
            .setBillingAccountLicenseConfig(billingAccountLicenseConfig)
            .setProjectNumber(projectNumber)
            .setLocation(location)
            .setLicenseCount(licenseCount)
            .setLicenseConfigId(licenseConfigId)
            .build();
    return distributeLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Distributes a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from billing
   * account level to project level.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   DistributeLicenseConfigRequest request =
   *       DistributeLicenseConfigRequest.newBuilder()
   *           .setBillingAccountLicenseConfig(
   *               BillingAccountLicenseConfigName.of(
   *                       "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]")
   *                   .toString())
   *           .setProjectNumber(828084015)
   *           .setLocation("location1901043637")
   *           .setLicenseCount(-1565113455)
   *           .setLicenseConfigId("licenseConfigId-372057250")
   *           .build();
   *   DistributeLicenseConfigResponse response =
   *       licenseConfigServiceClient.distributeLicenseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DistributeLicenseConfigResponse distributeLicenseConfig(
      DistributeLicenseConfigRequest request) {
    return distributeLicenseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Distributes a [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from billing
   * account level to project level.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   DistributeLicenseConfigRequest request =
   *       DistributeLicenseConfigRequest.newBuilder()
   *           .setBillingAccountLicenseConfig(
   *               BillingAccountLicenseConfigName.of(
   *                       "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]")
   *                   .toString())
   *           .setProjectNumber(828084015)
   *           .setLocation("location1901043637")
   *           .setLicenseCount(-1565113455)
   *           .setLicenseConfigId("licenseConfigId-372057250")
   *           .build();
   *   ApiFuture<DistributeLicenseConfigResponse> future =
   *       licenseConfigServiceClient.distributeLicenseConfigCallable().futureCall(request);
   *   // Do something.
   *   DistributeLicenseConfigResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigCallable() {
    return stub.distributeLicenseConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is called from the billing account side to retract the
   * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the given project back
   * to the billing account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   BillingAccountLicenseConfigName billingAccountLicenseConfig =
   *       BillingAccountLicenseConfigName.of(
   *           "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
   *   LicenseConfigName licenseConfig =
   *       LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
   *   boolean fullRetract = true;
   *   long licenseCount = -1565113455;
   *   RetractLicenseConfigResponse response =
   *       licenseConfigServiceClient.retractLicenseConfig(
   *           billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
   * }
   * }</pre>
   *
   * @param billingAccountLicenseConfig Required. Full resource name of
   *     [BillingAccountLicenseConfig][].
   *     <p>Format:
   *     `billingAccounts/{billing_account}/billingAccountLicenseConfigs/{billing_account_license_config_id}`.
   * @param licenseConfig Required. Full resource name of
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
   *     <p>Format: `projects/{project}/locations/{location}/licenseConfigs/{license_config_id}`.
   * @param fullRetract Optional. If set to true, retract the entire license config. Otherwise,
   *     retract the specified license count.
   * @param licenseCount Optional. The number of licenses to retract. Only used when full_retract is
   *     false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetractLicenseConfigResponse retractLicenseConfig(
      BillingAccountLicenseConfigName billingAccountLicenseConfig,
      LicenseConfigName licenseConfig,
      boolean fullRetract,
      long licenseCount) {
    RetractLicenseConfigRequest request =
        RetractLicenseConfigRequest.newBuilder()
            .setBillingAccountLicenseConfig(
                billingAccountLicenseConfig == null ? null : billingAccountLicenseConfig.toString())
            .setLicenseConfig(licenseConfig == null ? null : licenseConfig.toString())
            .setFullRetract(fullRetract)
            .setLicenseCount(licenseCount)
            .build();
    return retractLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is called from the billing account side to retract the
   * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the given project back
   * to the billing account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   BillingAccountLicenseConfigName billingAccountLicenseConfig =
   *       BillingAccountLicenseConfigName.of(
   *           "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
   *   String licenseConfig =
   *       LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString();
   *   boolean fullRetract = true;
   *   long licenseCount = -1565113455;
   *   RetractLicenseConfigResponse response =
   *       licenseConfigServiceClient.retractLicenseConfig(
   *           billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
   * }
   * }</pre>
   *
   * @param billingAccountLicenseConfig Required. Full resource name of
   *     [BillingAccountLicenseConfig][].
   *     <p>Format:
   *     `billingAccounts/{billing_account}/billingAccountLicenseConfigs/{billing_account_license_config_id}`.
   * @param licenseConfig Required. Full resource name of
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
   *     <p>Format: `projects/{project}/locations/{location}/licenseConfigs/{license_config_id}`.
   * @param fullRetract Optional. If set to true, retract the entire license config. Otherwise,
   *     retract the specified license count.
   * @param licenseCount Optional. The number of licenses to retract. Only used when full_retract is
   *     false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetractLicenseConfigResponse retractLicenseConfig(
      BillingAccountLicenseConfigName billingAccountLicenseConfig,
      String licenseConfig,
      boolean fullRetract,
      long licenseCount) {
    RetractLicenseConfigRequest request =
        RetractLicenseConfigRequest.newBuilder()
            .setBillingAccountLicenseConfig(
                billingAccountLicenseConfig == null ? null : billingAccountLicenseConfig.toString())
            .setLicenseConfig(licenseConfig)
            .setFullRetract(fullRetract)
            .setLicenseCount(licenseCount)
            .build();
    return retractLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is called from the billing account side to retract the
   * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the given project back
   * to the billing account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   String billingAccountLicenseConfig =
   *       BillingAccountLicenseConfigName.of(
   *               "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]")
   *           .toString();
   *   LicenseConfigName licenseConfig =
   *       LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
   *   boolean fullRetract = true;
   *   long licenseCount = -1565113455;
   *   RetractLicenseConfigResponse response =
   *       licenseConfigServiceClient.retractLicenseConfig(
   *           billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
   * }
   * }</pre>
   *
   * @param billingAccountLicenseConfig Required. Full resource name of
   *     [BillingAccountLicenseConfig][].
   *     <p>Format:
   *     `billingAccounts/{billing_account}/billingAccountLicenseConfigs/{billing_account_license_config_id}`.
   * @param licenseConfig Required. Full resource name of
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
   *     <p>Format: `projects/{project}/locations/{location}/licenseConfigs/{license_config_id}`.
   * @param fullRetract Optional. If set to true, retract the entire license config. Otherwise,
   *     retract the specified license count.
   * @param licenseCount Optional. The number of licenses to retract. Only used when full_retract is
   *     false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetractLicenseConfigResponse retractLicenseConfig(
      String billingAccountLicenseConfig,
      LicenseConfigName licenseConfig,
      boolean fullRetract,
      long licenseCount) {
    RetractLicenseConfigRequest request =
        RetractLicenseConfigRequest.newBuilder()
            .setBillingAccountLicenseConfig(billingAccountLicenseConfig)
            .setLicenseConfig(licenseConfig == null ? null : licenseConfig.toString())
            .setFullRetract(fullRetract)
            .setLicenseCount(licenseCount)
            .build();
    return retractLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is called from the billing account side to retract the
   * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the given project back
   * to the billing account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   String billingAccountLicenseConfig =
   *       BillingAccountLicenseConfigName.of(
   *               "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]")
   *           .toString();
   *   String licenseConfig =
   *       LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString();
   *   boolean fullRetract = true;
   *   long licenseCount = -1565113455;
   *   RetractLicenseConfigResponse response =
   *       licenseConfigServiceClient.retractLicenseConfig(
   *           billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
   * }
   * }</pre>
   *
   * @param billingAccountLicenseConfig Required. Full resource name of
   *     [BillingAccountLicenseConfig][].
   *     <p>Format:
   *     `billingAccounts/{billing_account}/billingAccountLicenseConfigs/{billing_account_license_config_id}`.
   * @param licenseConfig Required. Full resource name of
   *     [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig].
   *     <p>Format: `projects/{project}/locations/{location}/licenseConfigs/{license_config_id}`.
   * @param fullRetract Optional. If set to true, retract the entire license config. Otherwise,
   *     retract the specified license count.
   * @param licenseCount Optional. The number of licenses to retract. Only used when full_retract is
   *     false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetractLicenseConfigResponse retractLicenseConfig(
      String billingAccountLicenseConfig,
      String licenseConfig,
      boolean fullRetract,
      long licenseCount) {
    RetractLicenseConfigRequest request =
        RetractLicenseConfigRequest.newBuilder()
            .setBillingAccountLicenseConfig(billingAccountLicenseConfig)
            .setLicenseConfig(licenseConfig)
            .setFullRetract(fullRetract)
            .setLicenseCount(licenseCount)
            .build();
    return retractLicenseConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is called from the billing account side to retract the
   * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the given project back
   * to the billing account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   RetractLicenseConfigRequest request =
   *       RetractLicenseConfigRequest.newBuilder()
   *           .setBillingAccountLicenseConfig(
   *               BillingAccountLicenseConfigName.of(
   *                       "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]")
   *                   .toString())
   *           .setLicenseConfig(
   *               LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
   *           .setFullRetract(true)
   *           .setLicenseCount(-1565113455)
   *           .build();
   *   RetractLicenseConfigResponse response =
   *       licenseConfigServiceClient.retractLicenseConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetractLicenseConfigResponse retractLicenseConfig(
      RetractLicenseConfigRequest request) {
    return retractLicenseConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is called from the billing account side to retract the
   * [LicenseConfig][google.cloud.discoveryengine.v1beta.LicenseConfig] from the given project back
   * to the billing account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseConfigServiceClient licenseConfigServiceClient =
   *     LicenseConfigServiceClient.create()) {
   *   RetractLicenseConfigRequest request =
   *       RetractLicenseConfigRequest.newBuilder()
   *           .setBillingAccountLicenseConfig(
   *               BillingAccountLicenseConfigName.of(
   *                       "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]")
   *                   .toString())
   *           .setLicenseConfig(
   *               LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
   *           .setFullRetract(true)
   *           .setLicenseCount(-1565113455)
   *           .build();
   *   ApiFuture<RetractLicenseConfigResponse> future =
   *       licenseConfigServiceClient.retractLicenseConfigCallable().futureCall(request);
   *   // Do something.
   *   RetractLicenseConfigResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigCallable() {
    return stub.retractLicenseConfigCallable();
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

  public static class ListLicenseConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListLicenseConfigsRequest,
          ListLicenseConfigsResponse,
          LicenseConfig,
          ListLicenseConfigsPage,
          ListLicenseConfigsFixedSizeCollection> {

    public static ApiFuture<ListLicenseConfigsPagedResponse> createAsync(
        PageContext<ListLicenseConfigsRequest, ListLicenseConfigsResponse, LicenseConfig> context,
        ApiFuture<ListLicenseConfigsResponse> futureResponse) {
      ApiFuture<ListLicenseConfigsPage> futurePage =
          ListLicenseConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLicenseConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLicenseConfigsPagedResponse(ListLicenseConfigsPage page) {
      super(page, ListLicenseConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLicenseConfigsPage
      extends AbstractPage<
          ListLicenseConfigsRequest,
          ListLicenseConfigsResponse,
          LicenseConfig,
          ListLicenseConfigsPage> {

    private ListLicenseConfigsPage(
        PageContext<ListLicenseConfigsRequest, ListLicenseConfigsResponse, LicenseConfig> context,
        ListLicenseConfigsResponse response) {
      super(context, response);
    }

    private static ListLicenseConfigsPage createEmptyPage() {
      return new ListLicenseConfigsPage(null, null);
    }

    @Override
    protected ListLicenseConfigsPage createPage(
        PageContext<ListLicenseConfigsRequest, ListLicenseConfigsResponse, LicenseConfig> context,
        ListLicenseConfigsResponse response) {
      return new ListLicenseConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListLicenseConfigsPage> createPageAsync(
        PageContext<ListLicenseConfigsRequest, ListLicenseConfigsResponse, LicenseConfig> context,
        ApiFuture<ListLicenseConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLicenseConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLicenseConfigsRequest,
          ListLicenseConfigsResponse,
          LicenseConfig,
          ListLicenseConfigsPage,
          ListLicenseConfigsFixedSizeCollection> {

    private ListLicenseConfigsFixedSizeCollection(
        List<ListLicenseConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLicenseConfigsFixedSizeCollection createEmptyCollection() {
      return new ListLicenseConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLicenseConfigsFixedSizeCollection createCollection(
        List<ListLicenseConfigsPage> pages, int collectionSize) {
      return new ListLicenseConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
