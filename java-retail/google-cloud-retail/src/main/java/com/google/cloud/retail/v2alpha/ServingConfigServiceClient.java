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

package com.google.cloud.retail.v2alpha;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.stub.ServingConfigServiceStub;
import com.google.cloud.retail.v2alpha.stub.ServingConfigServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for modifying ServingConfig.
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
 * try (ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create()) {
 *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   ServingConfig servingConfig = ServingConfig.newBuilder().build();
 *   String servingConfigId = "servingConfigId-831052759";
 *   ServingConfig response =
 *       servingConfigServiceClient.createServingConfig(parent, servingConfig, servingConfigId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ServingConfigServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of ServingConfigServiceSettings
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
 * ServingConfigServiceSettings servingConfigServiceSettings =
 *     ServingConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create(servingConfigServiceSettings);
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
 * ServingConfigServiceSettings servingConfigServiceSettings =
 *     ServingConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create(servingConfigServiceSettings);
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
 * ServingConfigServiceSettings servingConfigServiceSettings =
 *     ServingConfigServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ServingConfigServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create(servingConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ServingConfigServiceClient implements BackgroundResource {
  private final ServingConfigServiceSettings settings;
  private final ServingConfigServiceStub stub;

  /** Constructs an instance of ServingConfigServiceClient with default settings. */
  public static final ServingConfigServiceClient create() throws IOException {
    return create(ServingConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ServingConfigServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ServingConfigServiceClient create(ServingConfigServiceSettings settings)
      throws IOException {
    return new ServingConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of ServingConfigServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ServingConfigServiceSettings).
   */
  public static final ServingConfigServiceClient create(ServingConfigServiceStub stub) {
    return new ServingConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of ServingConfigServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ServingConfigServiceClient(ServingConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ServingConfigServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ServingConfigServiceClient(ServingConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ServingConfigServiceSettings getSettings() {
    return settings;
  }

  public ServingConfigServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ServingConfig.
   *
   * <p>A maximum of 100 [ServingConfig][google.cloud.retail.v2alpha.ServingConfig]s are allowed in
   * a [Catalog][google.cloud.retail.v2alpha.Catalog], otherwise a FAILED_PRECONDITION error is
   * returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   ServingConfig servingConfig = ServingConfig.newBuilder().build();
   *   String servingConfigId = "servingConfigId-831052759";
   *   ServingConfig response =
   *       servingConfigServiceClient.createServingConfig(parent, servingConfig, servingConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}`
   * @param servingConfig Required. The ServingConfig to create.
   * @param servingConfigId Required. The ID to use for the ServingConfig, which will become the
   *     final component of the ServingConfig's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig createServingConfig(
      CatalogName parent, ServingConfig servingConfig, String servingConfigId) {
    CreateServingConfigRequest request =
        CreateServingConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setServingConfig(servingConfig)
            .setServingConfigId(servingConfigId)
            .build();
    return createServingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ServingConfig.
   *
   * <p>A maximum of 100 [ServingConfig][google.cloud.retail.v2alpha.ServingConfig]s are allowed in
   * a [Catalog][google.cloud.retail.v2alpha.Catalog], otherwise a FAILED_PRECONDITION error is
   * returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   ServingConfig servingConfig = ServingConfig.newBuilder().build();
   *   String servingConfigId = "servingConfigId-831052759";
   *   ServingConfig response =
   *       servingConfigServiceClient.createServingConfig(parent, servingConfig, servingConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}`
   * @param servingConfig Required. The ServingConfig to create.
   * @param servingConfigId Required. The ID to use for the ServingConfig, which will become the
   *     final component of the ServingConfig's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig createServingConfig(
      String parent, ServingConfig servingConfig, String servingConfigId) {
    CreateServingConfigRequest request =
        CreateServingConfigRequest.newBuilder()
            .setParent(parent)
            .setServingConfig(servingConfig)
            .setServingConfigId(servingConfigId)
            .build();
    return createServingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ServingConfig.
   *
   * <p>A maximum of 100 [ServingConfig][google.cloud.retail.v2alpha.ServingConfig]s are allowed in
   * a [Catalog][google.cloud.retail.v2alpha.Catalog], otherwise a FAILED_PRECONDITION error is
   * returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   CreateServingConfigRequest request =
   *       CreateServingConfigRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setServingConfig(ServingConfig.newBuilder().build())
   *           .setServingConfigId("servingConfigId-831052759")
   *           .build();
   *   ServingConfig response = servingConfigServiceClient.createServingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig createServingConfig(CreateServingConfigRequest request) {
    return createServingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ServingConfig.
   *
   * <p>A maximum of 100 [ServingConfig][google.cloud.retail.v2alpha.ServingConfig]s are allowed in
   * a [Catalog][google.cloud.retail.v2alpha.Catalog], otherwise a FAILED_PRECONDITION error is
   * returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   CreateServingConfigRequest request =
   *       CreateServingConfigRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setServingConfig(ServingConfig.newBuilder().build())
   *           .setServingConfigId("servingConfigId-831052759")
   *           .build();
   *   ApiFuture<ServingConfig> future =
   *       servingConfigServiceClient.createServingConfigCallable().futureCall(request);
   *   // Do something.
   *   ServingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServingConfigRequest, ServingConfig>
      createServingConfigCallable() {
    return stub.createServingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ServingConfig.
   *
   * <p>Returns a NotFound error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ServingConfigName name =
   *       ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");
   *   servingConfigServiceClient.deleteServingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ServingConfig to delete. Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/servingConfigs/{serving_config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServingConfig(ServingConfigName name) {
    DeleteServingConfigRequest request =
        DeleteServingConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteServingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ServingConfig.
   *
   * <p>Returns a NotFound error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   String name =
   *       ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *           .toString();
   *   servingConfigServiceClient.deleteServingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ServingConfig to delete. Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/servingConfigs/{serving_config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServingConfig(String name) {
    DeleteServingConfigRequest request =
        DeleteServingConfigRequest.newBuilder().setName(name).build();
    deleteServingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ServingConfig.
   *
   * <p>Returns a NotFound error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   DeleteServingConfigRequest request =
   *       DeleteServingConfigRequest.newBuilder()
   *           .setName(
   *               ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .build();
   *   servingConfigServiceClient.deleteServingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteServingConfig(DeleteServingConfigRequest request) {
    deleteServingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ServingConfig.
   *
   * <p>Returns a NotFound error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   DeleteServingConfigRequest request =
   *       DeleteServingConfigRequest.newBuilder()
   *           .setName(
   *               ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       servingConfigServiceClient.deleteServingConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServingConfigRequest, Empty> deleteServingConfigCallable() {
    return stub.deleteServingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ServingConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ServingConfig servingConfig = ServingConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ServingConfig response =
   *       servingConfigServiceClient.updateServingConfig(servingConfig, updateMask);
   * }
   * }</pre>
   *
   * @param servingConfig Required. The ServingConfig to update.
   * @param updateMask Indicates which fields in the provided
   *     [ServingConfig][google.cloud.retail.v2alpha.ServingConfig] to update. The following are NOT
   *     supported:
   *     <ul>
   *       <li>[ServingConfig.name][google.cloud.retail.v2alpha.ServingConfig.name]
   *     </ul>
   *     <p>If not set, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig updateServingConfig(
      ServingConfig servingConfig, FieldMask updateMask) {
    UpdateServingConfigRequest request =
        UpdateServingConfigRequest.newBuilder()
            .setServingConfig(servingConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateServingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ServingConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   UpdateServingConfigRequest request =
   *       UpdateServingConfigRequest.newBuilder()
   *           .setServingConfig(ServingConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ServingConfig response = servingConfigServiceClient.updateServingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig updateServingConfig(UpdateServingConfigRequest request) {
    return updateServingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ServingConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   UpdateServingConfigRequest request =
   *       UpdateServingConfigRequest.newBuilder()
   *           .setServingConfig(ServingConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ServingConfig> future =
   *       servingConfigServiceClient.updateServingConfigCallable().futureCall(request);
   *   // Do something.
   *   ServingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServingConfigRequest, ServingConfig>
      updateServingConfigCallable() {
    return stub.updateServingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ServingConfig.
   *
   * <p>Returns a NotFound error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ServingConfigName name =
   *       ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");
   *   ServingConfig response = servingConfigServiceClient.getServingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ServingConfig to get. Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/servingConfigs/{serving_config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig getServingConfig(ServingConfigName name) {
    GetServingConfigRequest request =
        GetServingConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getServingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ServingConfig.
   *
   * <p>Returns a NotFound error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   String name =
   *       ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *           .toString();
   *   ServingConfig response = servingConfigServiceClient.getServingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ServingConfig to get. Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/servingConfigs/{serving_config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig getServingConfig(String name) {
    GetServingConfigRequest request = GetServingConfigRequest.newBuilder().setName(name).build();
    return getServingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ServingConfig.
   *
   * <p>Returns a NotFound error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   GetServingConfigRequest request =
   *       GetServingConfigRequest.newBuilder()
   *           .setName(
   *               ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ServingConfig response = servingConfigServiceClient.getServingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig getServingConfig(GetServingConfigRequest request) {
    return getServingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ServingConfig.
   *
   * <p>Returns a NotFound error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   GetServingConfigRequest request =
   *       GetServingConfigRequest.newBuilder()
   *           .setName(
   *               ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ServingConfig> future =
   *       servingConfigServiceClient.getServingConfigCallable().futureCall(request);
   *   // Do something.
   *   ServingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServingConfigRequest, ServingConfig> getServingConfigCallable() {
    return stub.getServingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ServingConfigs linked to this catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   for (ServingConfig element :
   *       servingConfigServiceClient.listServingConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The catalog resource name. Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServingConfigsPagedResponse listServingConfigs(CatalogName parent) {
    ListServingConfigsRequest request =
        ListServingConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServingConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ServingConfigs linked to this catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   for (ServingConfig element :
   *       servingConfigServiceClient.listServingConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The catalog resource name. Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServingConfigsPagedResponse listServingConfigs(String parent) {
    ListServingConfigsRequest request =
        ListServingConfigsRequest.newBuilder().setParent(parent).build();
    return listServingConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ServingConfigs linked to this catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ListServingConfigsRequest request =
   *       ListServingConfigsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ServingConfig element :
   *       servingConfigServiceClient.listServingConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServingConfigsPagedResponse listServingConfigs(
      ListServingConfigsRequest request) {
    return listServingConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ServingConfigs linked to this catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ListServingConfigsRequest request =
   *       ListServingConfigsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ServingConfig> future =
   *       servingConfigServiceClient.listServingConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ServingConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServingConfigsRequest, ListServingConfigsPagedResponse>
      listServingConfigsPagedCallable() {
    return stub.listServingConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ServingConfigs linked to this catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ListServingConfigsRequest request =
   *       ListServingConfigsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListServingConfigsResponse response =
   *         servingConfigServiceClient.listServingConfigsCallable().call(request);
   *     for (ServingConfig element : response.getServingConfigsList()) {
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
  public final UnaryCallable<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsCallable() {
    return stub.listServingConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a Control on the specified ServingConfig. The control is added in the last position of
   * the list of controls it belongs to (e.g. if it's a facet spec control it will be applied in the
   * last position of servingConfig.facetSpecIds) Returns a ALREADY_EXISTS error if the control has
   * already been applied. Returns a FAILED_PRECONDITION error if the addition could exceed maximum
   * number of control allowed for that type of control.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ServingConfigName servingConfig =
   *       ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");
   *   ServingConfig response = servingConfigServiceClient.addControl(servingConfig);
   * }
   * }</pre>
   *
   * @param servingConfig Required. The source ServingConfig resource name . Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/servingConfigs/{serving_config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig addControl(ServingConfigName servingConfig) {
    AddControlRequest request =
        AddControlRequest.newBuilder()
            .setServingConfig(servingConfig == null ? null : servingConfig.toString())
            .build();
    return addControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a Control on the specified ServingConfig. The control is added in the last position of
   * the list of controls it belongs to (e.g. if it's a facet spec control it will be applied in the
   * last position of servingConfig.facetSpecIds) Returns a ALREADY_EXISTS error if the control has
   * already been applied. Returns a FAILED_PRECONDITION error if the addition could exceed maximum
   * number of control allowed for that type of control.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   String servingConfig =
   *       ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *           .toString();
   *   ServingConfig response = servingConfigServiceClient.addControl(servingConfig);
   * }
   * }</pre>
   *
   * @param servingConfig Required. The source ServingConfig resource name . Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/servingConfigs/{serving_config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig addControl(String servingConfig) {
    AddControlRequest request =
        AddControlRequest.newBuilder().setServingConfig(servingConfig).build();
    return addControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a Control on the specified ServingConfig. The control is added in the last position of
   * the list of controls it belongs to (e.g. if it's a facet spec control it will be applied in the
   * last position of servingConfig.facetSpecIds) Returns a ALREADY_EXISTS error if the control has
   * already been applied. Returns a FAILED_PRECONDITION error if the addition could exceed maximum
   * number of control allowed for that type of control.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   AddControlRequest request =
   *       AddControlRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setControlId("controlId-395080872")
   *           .build();
   *   ServingConfig response = servingConfigServiceClient.addControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig addControl(AddControlRequest request) {
    return addControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a Control on the specified ServingConfig. The control is added in the last position of
   * the list of controls it belongs to (e.g. if it's a facet spec control it will be applied in the
   * last position of servingConfig.facetSpecIds) Returns a ALREADY_EXISTS error if the control has
   * already been applied. Returns a FAILED_PRECONDITION error if the addition could exceed maximum
   * number of control allowed for that type of control.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   AddControlRequest request =
   *       AddControlRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setControlId("controlId-395080872")
   *           .build();
   *   ApiFuture<ServingConfig> future =
   *       servingConfigServiceClient.addControlCallable().futureCall(request);
   *   // Do something.
   *   ServingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddControlRequest, ServingConfig> addControlCallable() {
    return stub.addControlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a Control on the specified ServingConfig. The control is removed from the
   * ServingConfig. Returns a NOT_FOUND error if the Control is not enabled for the ServingConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ServingConfigName servingConfig =
   *       ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");
   *   ServingConfig response = servingConfigServiceClient.removeControl(servingConfig);
   * }
   * }</pre>
   *
   * @param servingConfig Required. The source ServingConfig resource name . Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/servingConfigs/{serving_config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig removeControl(ServingConfigName servingConfig) {
    RemoveControlRequest request =
        RemoveControlRequest.newBuilder()
            .setServingConfig(servingConfig == null ? null : servingConfig.toString())
            .build();
    return removeControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a Control on the specified ServingConfig. The control is removed from the
   * ServingConfig. Returns a NOT_FOUND error if the Control is not enabled for the ServingConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   String servingConfig =
   *       ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *           .toString();
   *   ServingConfig response = servingConfigServiceClient.removeControl(servingConfig);
   * }
   * }</pre>
   *
   * @param servingConfig Required. The source ServingConfig resource name . Format:
   *     projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/servingConfigs/{serving_config_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig removeControl(String servingConfig) {
    RemoveControlRequest request =
        RemoveControlRequest.newBuilder().setServingConfig(servingConfig).build();
    return removeControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a Control on the specified ServingConfig. The control is removed from the
   * ServingConfig. Returns a NOT_FOUND error if the Control is not enabled for the ServingConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   RemoveControlRequest request =
   *       RemoveControlRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setControlId("controlId-395080872")
   *           .build();
   *   ServingConfig response = servingConfigServiceClient.removeControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig removeControl(RemoveControlRequest request) {
    return removeControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a Control on the specified ServingConfig. The control is removed from the
   * ServingConfig. Returns a NOT_FOUND error if the Control is not enabled for the ServingConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   RemoveControlRequest request =
   *       RemoveControlRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setControlId("controlId-395080872")
   *           .build();
   *   ApiFuture<ServingConfig> future =
   *       servingConfigServiceClient.removeControlCallable().futureCall(request);
   *   // Do something.
   *   ServingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveControlRequest, ServingConfig> removeControlCallable() {
    return stub.removeControlCallable();
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

  public static class ListServingConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListServingConfigsRequest,
          ListServingConfigsResponse,
          ServingConfig,
          ListServingConfigsPage,
          ListServingConfigsFixedSizeCollection> {

    public static ApiFuture<ListServingConfigsPagedResponse> createAsync(
        PageContext<ListServingConfigsRequest, ListServingConfigsResponse, ServingConfig> context,
        ApiFuture<ListServingConfigsResponse> futureResponse) {
      ApiFuture<ListServingConfigsPage> futurePage =
          ListServingConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServingConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServingConfigsPagedResponse(ListServingConfigsPage page) {
      super(page, ListServingConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServingConfigsPage
      extends AbstractPage<
          ListServingConfigsRequest,
          ListServingConfigsResponse,
          ServingConfig,
          ListServingConfigsPage> {

    private ListServingConfigsPage(
        PageContext<ListServingConfigsRequest, ListServingConfigsResponse, ServingConfig> context,
        ListServingConfigsResponse response) {
      super(context, response);
    }

    private static ListServingConfigsPage createEmptyPage() {
      return new ListServingConfigsPage(null, null);
    }

    @Override
    protected ListServingConfigsPage createPage(
        PageContext<ListServingConfigsRequest, ListServingConfigsResponse, ServingConfig> context,
        ListServingConfigsResponse response) {
      return new ListServingConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListServingConfigsPage> createPageAsync(
        PageContext<ListServingConfigsRequest, ListServingConfigsResponse, ServingConfig> context,
        ApiFuture<ListServingConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServingConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServingConfigsRequest,
          ListServingConfigsResponse,
          ServingConfig,
          ListServingConfigsPage,
          ListServingConfigsFixedSizeCollection> {

    private ListServingConfigsFixedSizeCollection(
        List<ListServingConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServingConfigsFixedSizeCollection createEmptyCollection() {
      return new ListServingConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServingConfigsFixedSizeCollection createCollection(
        List<ListServingConfigsPage> pages, int collectionSize) {
      return new ListServingConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
