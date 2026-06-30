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

package com.google.maps.mapmanagement.v2beta;

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
import com.google.maps.mapmanagement.v2beta.stub.MapManagementStub;
import com.google.maps.mapmanagement.v2beta.stub.MapManagementStubSettings;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Map Management API uses your inputs to create and manage Google Cloud
 * based styling resources for Google Maps.
 *
 * <p>Using this API, you can can create and manage MapConfigs (Map IDs), StyleConfigs (JSON-based
 * styling), and MapContextConfigs (associations between styles, datasets, and map variants).
 *
 * <p>This API offers features through three channels:
 *
 * <ul>
 *   <li>`v2alpha`: Experimental features.
 *   <li>`v2beta`: Preview features, recommended for early adoption.
 *   <li>`v2`: General Availability (GA) features.
 * </ul>
 *
 * <p>Capabilities described here are generally available across both the v2alpha and v2beta
 * endpoints.
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
 * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   MapConfig mapConfig = MapConfig.newBuilder().build();
 *   MapConfig response = mapManagementClient.createMapConfig(parent, mapConfig);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MapManagementClient object to clean up resources such
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
 *      <td><p> CreateMapConfig</td>
 *      <td><p> Creates a MapConfig in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMapConfig(CreateMapConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createMapConfig(ProjectName parent, MapConfig mapConfig)
 *           <li><p> createMapConfig(String parent, MapConfig mapConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMapConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMapConfig</td>
 *      <td><p> Gets a MapConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMapConfig(GetMapConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMapConfig(MapConfigName name)
 *           <li><p> getMapConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMapConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMapConfigs</td>
 *      <td><p> Lists MapConfigs for a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMapConfigs(ListMapConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMapConfigs(ProjectName parent)
 *           <li><p> listMapConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMapConfigsPagedCallable()
 *           <li><p> listMapConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMapConfig</td>
 *      <td><p> Updates a MapConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMapConfig(UpdateMapConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateMapConfig(MapConfig mapConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMapConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMapConfig</td>
 *      <td><p> Deletes a MapConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMapConfig(DeleteMapConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteMapConfig(MapConfigName name, boolean force)
 *           <li><p> deleteMapConfig(String name, boolean force)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMapConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateStyleConfig</td>
 *      <td><p> Creates a StyleConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createStyleConfig(CreateStyleConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createStyleConfig(ProjectName parent, StyleConfig styleConfig)
 *           <li><p> createStyleConfig(String parent, StyleConfig styleConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createStyleConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetStyleConfig</td>
 *      <td><p> Gets a StyleConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getStyleConfig(GetStyleConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getStyleConfig(StyleConfigName name)
 *           <li><p> getStyleConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getStyleConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListStyleConfigs</td>
 *      <td><p> Lists StyleConfigs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listStyleConfigs(ListStyleConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listStyleConfigs(ProjectName parent)
 *           <li><p> listStyleConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listStyleConfigsPagedCallable()
 *           <li><p> listStyleConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateStyleConfig</td>
 *      <td><p> Updates a StyleConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateStyleConfig(UpdateStyleConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateStyleConfig(StyleConfig styleConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateStyleConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteStyleConfig</td>
 *      <td><p> Deletes a StyleConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteStyleConfig(DeleteStyleConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteStyleConfig(StyleConfigName name)
 *           <li><p> deleteStyleConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteStyleConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMapContextConfig</td>
 *      <td><p> Creates a MapContextConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMapContextConfig(CreateMapContextConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createMapContextConfig(MapConfigName parent, MapContextConfig mapContextConfig)
 *           <li><p> createMapContextConfig(String parent, MapContextConfig mapContextConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMapContextConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMapContextConfig</td>
 *      <td><p> Gets a MapContextConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMapContextConfig(GetMapContextConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMapContextConfig(MapContextConfigName name)
 *           <li><p> getMapContextConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMapContextConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMapContextConfigs</td>
 *      <td><p> Lists MapContextConfigs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMapContextConfigs(ListMapContextConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMapContextConfigs(MapConfigName parent)
 *           <li><p> listMapContextConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMapContextConfigsPagedCallable()
 *           <li><p> listMapContextConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMapContextConfig</td>
 *      <td><p> Updates a MapContextConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMapContextConfig(UpdateMapContextConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateMapContextConfig(MapContextConfig mapContextConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMapContextConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMapContextConfig</td>
 *      <td><p> Deletes a MapContextConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMapContextConfig(DeleteMapContextConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteMapContextConfig(MapContextConfigName name)
 *           <li><p> deleteMapContextConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMapContextConfigCallable()
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
 * <p>This class can be customized by passing in a custom instance of MapManagementSettings to
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
 * MapManagementSettings mapManagementSettings =
 *     MapManagementSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MapManagementClient mapManagementClient = MapManagementClient.create(mapManagementSettings);
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
 * MapManagementSettings mapManagementSettings =
 *     MapManagementSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MapManagementClient mapManagementClient = MapManagementClient.create(mapManagementSettings);
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
 * MapManagementSettings mapManagementSettings =
 *     MapManagementSettings.newHttpJsonBuilder().build();
 * MapManagementClient mapManagementClient = MapManagementClient.create(mapManagementSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MapManagementClient implements BackgroundResource {
  private final MapManagementSettings settings;
  private final MapManagementStub stub;

  /** Constructs an instance of MapManagementClient with default settings. */
  public static final MapManagementClient create() throws IOException {
    return create(MapManagementSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MapManagementClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MapManagementClient create(MapManagementSettings settings)
      throws IOException {
    return new MapManagementClient(settings);
  }

  /**
   * Constructs an instance of MapManagementClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(MapManagementSettings).
   */
  public static final MapManagementClient create(MapManagementStub stub) {
    return new MapManagementClient(stub);
  }

  /**
   * Constructs an instance of MapManagementClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MapManagementClient(MapManagementSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MapManagementStubSettings) settings.getStubSettings()).createStub();
  }

  protected MapManagementClient(MapManagementStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MapManagementSettings getSettings() {
    return settings;
  }

  public MapManagementStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MapConfig in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   MapConfig mapConfig = MapConfig.newBuilder().build();
   *   MapConfig response = mapManagementClient.createMapConfig(parent, mapConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that will own the MapConfig. Format:
   *     `projects/{$my-project-id}`
   * @param mapConfig Required. The MapConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapConfig createMapConfig(ProjectName parent, MapConfig mapConfig) {
    CreateMapConfigRequest request =
        CreateMapConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMapConfig(mapConfig)
            .build();
    return createMapConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MapConfig in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   MapConfig mapConfig = MapConfig.newBuilder().build();
   *   MapConfig response = mapManagementClient.createMapConfig(parent, mapConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that will own the MapConfig. Format:
   *     `projects/{$my-project-id}`
   * @param mapConfig Required. The MapConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapConfig createMapConfig(String parent, MapConfig mapConfig) {
    CreateMapConfigRequest request =
        CreateMapConfigRequest.newBuilder().setParent(parent).setMapConfig(mapConfig).build();
    return createMapConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MapConfig in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   CreateMapConfigRequest request =
   *       CreateMapConfigRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setMapConfig(MapConfig.newBuilder().build())
   *           .build();
   *   MapConfig response = mapManagementClient.createMapConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapConfig createMapConfig(CreateMapConfigRequest request) {
    return createMapConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MapConfig in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   CreateMapConfigRequest request =
   *       CreateMapConfigRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setMapConfig(MapConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<MapConfig> future =
   *       mapManagementClient.createMapConfigCallable().futureCall(request);
   *   // Do something.
   *   MapConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMapConfigRequest, MapConfig> createMapConfigCallable() {
    return stub.createMapConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   MapConfigName name = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
   *   MapConfig response = mapManagementClient.getMapConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the MapConfig. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapConfig getMapConfig(MapConfigName name) {
    GetMapConfigRequest request =
        GetMapConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMapConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String name = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString();
   *   MapConfig response = mapManagementClient.getMapConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the MapConfig. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapConfig getMapConfig(String name) {
    GetMapConfigRequest request = GetMapConfigRequest.newBuilder().setName(name).build();
    return getMapConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   GetMapConfigRequest request =
   *       GetMapConfigRequest.newBuilder()
   *           .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .build();
   *   MapConfig response = mapManagementClient.getMapConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapConfig getMapConfig(GetMapConfigRequest request) {
    return getMapConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   GetMapConfigRequest request =
   *       GetMapConfigRequest.newBuilder()
   *           .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .build();
   *   ApiFuture<MapConfig> future = mapManagementClient.getMapConfigCallable().futureCall(request);
   *   // Do something.
   *   MapConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMapConfigRequest, MapConfig> getMapConfigCallable() {
    return stub.getMapConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapConfigs for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (MapConfig element : mapManagementClient.listMapConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that owns the MapConfigs. Format: `projects/{project}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMapConfigsPagedResponse listMapConfigs(ProjectName parent) {
    ListMapConfigsRequest request =
        ListMapConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMapConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapConfigs for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (MapConfig element : mapManagementClient.listMapConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that owns the MapConfigs. Format: `projects/{project}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMapConfigsPagedResponse listMapConfigs(String parent) {
    ListMapConfigsRequest request = ListMapConfigsRequest.newBuilder().setParent(parent).build();
    return listMapConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapConfigs for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListMapConfigsRequest request =
   *       ListMapConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MapConfig element : mapManagementClient.listMapConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMapConfigsPagedResponse listMapConfigs(ListMapConfigsRequest request) {
    return listMapConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapConfigs for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListMapConfigsRequest request =
   *       ListMapConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MapConfig> future =
   *       mapManagementClient.listMapConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MapConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMapConfigsRequest, ListMapConfigsPagedResponse>
      listMapConfigsPagedCallable() {
    return stub.listMapConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapConfigs for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListMapConfigsRequest request =
   *       ListMapConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMapConfigsResponse response =
   *         mapManagementClient.listMapConfigsCallable().call(request);
   *     for (MapConfig element : response.getMapConfigsList()) {
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
  public final UnaryCallable<ListMapConfigsRequest, ListMapConfigsResponse>
      listMapConfigsCallable() {
    return stub.listMapConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   MapConfig mapConfig = MapConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MapConfig response = mapManagementClient.updateMapConfig(mapConfig, updateMask);
   * }
   * }</pre>
   *
   * @param mapConfig Required. The MapConfig to update.
   *     <p>The MapConfig's `name` field is used to identify the MapConfig to update. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @param updateMask Optional. The specific field to update for the MapConfig. If not specified,
   *     the MapConfig will be updated in its entirety. Valid fields are:
   *     <ul>
   *       <li>`display_name`
   *       <li>`description`
   *       <li>`map_features`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapConfig updateMapConfig(MapConfig mapConfig, FieldMask updateMask) {
    UpdateMapConfigRequest request =
        UpdateMapConfigRequest.newBuilder()
            .setMapConfig(mapConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateMapConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   UpdateMapConfigRequest request =
   *       UpdateMapConfigRequest.newBuilder()
   *           .setMapConfig(MapConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   MapConfig response = mapManagementClient.updateMapConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapConfig updateMapConfig(UpdateMapConfigRequest request) {
    return updateMapConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   UpdateMapConfigRequest request =
   *       UpdateMapConfigRequest.newBuilder()
   *           .setMapConfig(MapConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<MapConfig> future =
   *       mapManagementClient.updateMapConfigCallable().futureCall(request);
   *   // Do something.
   *   MapConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMapConfigRequest, MapConfig> updateMapConfigCallable() {
    return stub.updateMapConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   MapConfigName name = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
   *   boolean force = true;
   *   mapManagementClient.deleteMapConfig(name, force);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the MapConfig to delete. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @param force Optional. If set to true, any MapContextConfigs from this MapConfig will also be
   *     deleted. (Otherwise, the request will only work if the MapConfig has no MapContextConfigs.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMapConfig(MapConfigName name, boolean force) {
    DeleteMapConfigRequest request =
        DeleteMapConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    deleteMapConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String name = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString();
   *   boolean force = true;
   *   mapManagementClient.deleteMapConfig(name, force);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the MapConfig to delete. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @param force Optional. If set to true, any MapContextConfigs from this MapConfig will also be
   *     deleted. (Otherwise, the request will only work if the MapConfig has no MapContextConfigs.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMapConfig(String name, boolean force) {
    DeleteMapConfigRequest request =
        DeleteMapConfigRequest.newBuilder().setName(name).setForce(force).build();
    deleteMapConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   DeleteMapConfigRequest request =
   *       DeleteMapConfigRequest.newBuilder()
   *           .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .setForce(true)
   *           .build();
   *   mapManagementClient.deleteMapConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMapConfig(DeleteMapConfigRequest request) {
    deleteMapConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MapConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   DeleteMapConfigRequest request =
   *       DeleteMapConfigRequest.newBuilder()
   *           .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = mapManagementClient.deleteMapConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMapConfigRequest, Empty> deleteMapConfigCallable() {
    return stub.deleteMapConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   StyleConfig styleConfig = StyleConfig.newBuilder().build();
   *   StyleConfig response = mapManagementClient.createStyleConfig(parent, styleConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that will own the StyleConfig. Format:
   *     `projects/{project}`
   * @param styleConfig Required. The StyleConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleConfig createStyleConfig(ProjectName parent, StyleConfig styleConfig) {
    CreateStyleConfigRequest request =
        CreateStyleConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setStyleConfig(styleConfig)
            .build();
    return createStyleConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   StyleConfig styleConfig = StyleConfig.newBuilder().build();
   *   StyleConfig response = mapManagementClient.createStyleConfig(parent, styleConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that will own the StyleConfig. Format:
   *     `projects/{project}`
   * @param styleConfig Required. The StyleConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleConfig createStyleConfig(String parent, StyleConfig styleConfig) {
    CreateStyleConfigRequest request =
        CreateStyleConfigRequest.newBuilder().setParent(parent).setStyleConfig(styleConfig).build();
    return createStyleConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   CreateStyleConfigRequest request =
   *       CreateStyleConfigRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setStyleConfig(StyleConfig.newBuilder().build())
   *           .build();
   *   StyleConfig response = mapManagementClient.createStyleConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleConfig createStyleConfig(CreateStyleConfigRequest request) {
    return createStyleConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   CreateStyleConfigRequest request =
   *       CreateStyleConfigRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setStyleConfig(StyleConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<StyleConfig> future =
   *       mapManagementClient.createStyleConfigCallable().futureCall(request);
   *   // Do something.
   *   StyleConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateStyleConfigRequest, StyleConfig> createStyleConfigCallable() {
    return stub.createStyleConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   StyleConfigName name = StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]");
   *   StyleConfig response = mapManagementClient.getStyleConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the StyleConfig. Format:
   *     `projects/{project}/styleConfigs/{style_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleConfig getStyleConfig(StyleConfigName name) {
    GetStyleConfigRequest request =
        GetStyleConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStyleConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String name = StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString();
   *   StyleConfig response = mapManagementClient.getStyleConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the StyleConfig. Format:
   *     `projects/{project}/styleConfigs/{style_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleConfig getStyleConfig(String name) {
    GetStyleConfigRequest request = GetStyleConfigRequest.newBuilder().setName(name).build();
    return getStyleConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   GetStyleConfigRequest request =
   *       GetStyleConfigRequest.newBuilder()
   *           .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
   *           .build();
   *   StyleConfig response = mapManagementClient.getStyleConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleConfig getStyleConfig(GetStyleConfigRequest request) {
    return getStyleConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   GetStyleConfigRequest request =
   *       GetStyleConfigRequest.newBuilder()
   *           .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
   *           .build();
   *   ApiFuture<StyleConfig> future =
   *       mapManagementClient.getStyleConfigCallable().futureCall(request);
   *   // Do something.
   *   StyleConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStyleConfigRequest, StyleConfig> getStyleConfigCallable() {
    return stub.getStyleConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StyleConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (StyleConfig element : mapManagementClient.listStyleConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that owns the StyleConfigs. Format: `projects/{project}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStyleConfigsPagedResponse listStyleConfigs(ProjectName parent) {
    ListStyleConfigsRequest request =
        ListStyleConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStyleConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StyleConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (StyleConfig element : mapManagementClient.listStyleConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that owns the StyleConfigs. Format: `projects/{project}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStyleConfigsPagedResponse listStyleConfigs(String parent) {
    ListStyleConfigsRequest request =
        ListStyleConfigsRequest.newBuilder().setParent(parent).build();
    return listStyleConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StyleConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListStyleConfigsRequest request =
   *       ListStyleConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(StyleConfigView.forNumber(0))
   *           .build();
   *   for (StyleConfig element : mapManagementClient.listStyleConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStyleConfigsPagedResponse listStyleConfigs(ListStyleConfigsRequest request) {
    return listStyleConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StyleConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListStyleConfigsRequest request =
   *       ListStyleConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(StyleConfigView.forNumber(0))
   *           .build();
   *   ApiFuture<StyleConfig> future =
   *       mapManagementClient.listStyleConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (StyleConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsPagedResponse>
      listStyleConfigsPagedCallable() {
    return stub.listStyleConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StyleConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListStyleConfigsRequest request =
   *       ListStyleConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(StyleConfigView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListStyleConfigsResponse response =
   *         mapManagementClient.listStyleConfigsCallable().call(request);
   *     for (StyleConfig element : response.getStyleConfigsList()) {
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
  public final UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsResponse>
      listStyleConfigsCallable() {
    return stub.listStyleConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   StyleConfig styleConfig = StyleConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   StyleConfig response = mapManagementClient.updateStyleConfig(styleConfig, updateMask);
   * }
   * }</pre>
   *
   * @param styleConfig Required. The StyleConfig to update.
   *     <p>The StyleConfig's `name` field is used to identify the StyleConfig to update. Format:
   *     `projects/{project}/styleConfigs/{style_config}`
   * @param updateMask Optional. The list of fields to update. If not specified, the StyleConfig
   *     will be updated in its entirety. Valid fields are:
   *     <ul>
   *       <li>`display_name`
   *       <li>`description`
   *       <li>`json_style_sheet`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleConfig updateStyleConfig(StyleConfig styleConfig, FieldMask updateMask) {
    UpdateStyleConfigRequest request =
        UpdateStyleConfigRequest.newBuilder()
            .setStyleConfig(styleConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateStyleConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   UpdateStyleConfigRequest request =
   *       UpdateStyleConfigRequest.newBuilder()
   *           .setStyleConfig(StyleConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   StyleConfig response = mapManagementClient.updateStyleConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StyleConfig updateStyleConfig(UpdateStyleConfigRequest request) {
    return updateStyleConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   UpdateStyleConfigRequest request =
   *       UpdateStyleConfigRequest.newBuilder()
   *           .setStyleConfig(StyleConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<StyleConfig> future =
   *       mapManagementClient.updateStyleConfigCallable().futureCall(request);
   *   // Do something.
   *   StyleConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigCallable() {
    return stub.updateStyleConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   StyleConfigName name = StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]");
   *   mapManagementClient.deleteStyleConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the StyleConfig to delete. Format:
   *     `projects/{project}/styleConfigs/{style_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStyleConfig(StyleConfigName name) {
    DeleteStyleConfigRequest request =
        DeleteStyleConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteStyleConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String name = StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString();
   *   mapManagementClient.deleteStyleConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the StyleConfig to delete. Format:
   *     `projects/{project}/styleConfigs/{style_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStyleConfig(String name) {
    DeleteStyleConfigRequest request = DeleteStyleConfigRequest.newBuilder().setName(name).build();
    deleteStyleConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   DeleteStyleConfigRequest request =
   *       DeleteStyleConfigRequest.newBuilder()
   *           .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
   *           .build();
   *   mapManagementClient.deleteStyleConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStyleConfig(DeleteStyleConfigRequest request) {
    deleteStyleConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a StyleConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   DeleteStyleConfigRequest request =
   *       DeleteStyleConfigRequest.newBuilder()
   *           .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
   *           .build();
   *   ApiFuture<Empty> future = mapManagementClient.deleteStyleConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteStyleConfigRequest, Empty> deleteStyleConfigCallable() {
    return stub.deleteStyleConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   MapConfigName parent = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
   *   MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();
   *   MapContextConfig response =
   *       mapManagementClient.createMapContextConfig(parent, mapContextConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Parent MapConfig that will own the MapContextConfig. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @param mapContextConfig Required. The MapContextConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapContextConfig createMapContextConfig(
      MapConfigName parent, MapContextConfig mapContextConfig) {
    CreateMapContextConfigRequest request =
        CreateMapContextConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMapContextConfig(mapContextConfig)
            .build();
    return createMapContextConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String parent = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString();
   *   MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();
   *   MapContextConfig response =
   *       mapManagementClient.createMapContextConfig(parent, mapContextConfig);
   * }
   * }</pre>
   *
   * @param parent Required. Parent MapConfig that will own the MapContextConfig. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @param mapContextConfig Required. The MapContextConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapContextConfig createMapContextConfig(
      String parent, MapContextConfig mapContextConfig) {
    CreateMapContextConfigRequest request =
        CreateMapContextConfigRequest.newBuilder()
            .setParent(parent)
            .setMapContextConfig(mapContextConfig)
            .build();
    return createMapContextConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   CreateMapContextConfigRequest request =
   *       CreateMapContextConfigRequest.newBuilder()
   *           .setParent(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .setMapContextConfig(MapContextConfig.newBuilder().build())
   *           .build();
   *   MapContextConfig response = mapManagementClient.createMapContextConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapContextConfig createMapContextConfig(CreateMapContextConfigRequest request) {
    return createMapContextConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   CreateMapContextConfigRequest request =
   *       CreateMapContextConfigRequest.newBuilder()
   *           .setParent(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .setMapContextConfig(MapContextConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<MapContextConfig> future =
   *       mapManagementClient.createMapContextConfigCallable().futureCall(request);
   *   // Do something.
   *   MapContextConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigCallable() {
    return stub.createMapContextConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   MapContextConfigName name =
   *       MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]");
   *   MapContextConfig response = mapManagementClient.getMapContextConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the MapContextConfig. Format:
   *     `projects/{project}/mapConfigs/{map_config}/mapContextConfigs/{map_context_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapContextConfig getMapContextConfig(MapContextConfigName name) {
    GetMapContextConfigRequest request =
        GetMapContextConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMapContextConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String name =
   *       MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]").toString();
   *   MapContextConfig response = mapManagementClient.getMapContextConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the MapContextConfig. Format:
   *     `projects/{project}/mapConfigs/{map_config}/mapContextConfigs/{map_context_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapContextConfig getMapContextConfig(String name) {
    GetMapContextConfigRequest request =
        GetMapContextConfigRequest.newBuilder().setName(name).build();
    return getMapContextConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   GetMapContextConfigRequest request =
   *       GetMapContextConfigRequest.newBuilder()
   *           .setName(
   *               MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
   *                   .toString())
   *           .build();
   *   MapContextConfig response = mapManagementClient.getMapContextConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapContextConfig getMapContextConfig(GetMapContextConfigRequest request) {
    return getMapContextConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   GetMapContextConfigRequest request =
   *       GetMapContextConfigRequest.newBuilder()
   *           .setName(
   *               MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MapContextConfig> future =
   *       mapManagementClient.getMapContextConfigCallable().futureCall(request);
   *   // Do something.
   *   MapContextConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMapContextConfigRequest, MapContextConfig>
      getMapContextConfigCallable() {
    return stub.getMapContextConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapContextConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   MapConfigName parent = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
   *   for (MapContextConfig element :
   *       mapManagementClient.listMapContextConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent MapConfig that owns the MapContextConfigs. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMapContextConfigsPagedResponse listMapContextConfigs(MapConfigName parent) {
    ListMapContextConfigsRequest request =
        ListMapContextConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMapContextConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapContextConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String parent = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString();
   *   for (MapContextConfig element :
   *       mapManagementClient.listMapContextConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent MapConfig that owns the MapContextConfigs. Format:
   *     `projects/{project}/mapConfigs/{map_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMapContextConfigsPagedResponse listMapContextConfigs(String parent) {
    ListMapContextConfigsRequest request =
        ListMapContextConfigsRequest.newBuilder().setParent(parent).build();
    return listMapContextConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapContextConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListMapContextConfigsRequest request =
   *       ListMapContextConfigsRequest.newBuilder()
   *           .setParent(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MapContextConfig element :
   *       mapManagementClient.listMapContextConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMapContextConfigsPagedResponse listMapContextConfigs(
      ListMapContextConfigsRequest request) {
    return listMapContextConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapContextConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListMapContextConfigsRequest request =
   *       ListMapContextConfigsRequest.newBuilder()
   *           .setParent(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MapContextConfig> future =
   *       mapManagementClient.listMapContextConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MapContextConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsPagedResponse>
      listMapContextConfigsPagedCallable() {
    return stub.listMapContextConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MapContextConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   ListMapContextConfigsRequest request =
   *       ListMapContextConfigsRequest.newBuilder()
   *           .setParent(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMapContextConfigsResponse response =
   *         mapManagementClient.listMapContextConfigsCallable().call(request);
   *     for (MapContextConfig element : response.getMapContextConfigsList()) {
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
  public final UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
      listMapContextConfigsCallable() {
    return stub.listMapContextConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MapContextConfig response =
   *       mapManagementClient.updateMapContextConfig(mapContextConfig, updateMask);
   * }
   * }</pre>
   *
   * @param mapContextConfig Required. The MapContextConfig to update.
   *     <p>The MapContextConfig's `name` field is used to identify the MapContextConfig to update.
   *     Format: `projects/{project}/mapConfigs/{map_config}/mapContextConfigs/{map_context_config}`
   * @param updateMask Optional. The list of fields to update. If not specified, the
   *     MapContextConfig will be updated in its entirety. Valid fields are:
   *     <ul>
   *       <li>`display_name`
   *       <li>`alias`
   *       <li>`map_variants`
   *       <li>`style_config`
   *       <li>`dataset`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapContextConfig updateMapContextConfig(
      MapContextConfig mapContextConfig, FieldMask updateMask) {
    UpdateMapContextConfigRequest request =
        UpdateMapContextConfigRequest.newBuilder()
            .setMapContextConfig(mapContextConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateMapContextConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   UpdateMapContextConfigRequest request =
   *       UpdateMapContextConfigRequest.newBuilder()
   *           .setMapContextConfig(MapContextConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   MapContextConfig response = mapManagementClient.updateMapContextConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MapContextConfig updateMapContextConfig(UpdateMapContextConfigRequest request) {
    return updateMapContextConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   UpdateMapContextConfigRequest request =
   *       UpdateMapContextConfigRequest.newBuilder()
   *           .setMapContextConfig(MapContextConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<MapContextConfig> future =
   *       mapManagementClient.updateMapContextConfigCallable().futureCall(request);
   *   // Do something.
   *   MapContextConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigCallable() {
    return stub.updateMapContextConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   MapContextConfigName name =
   *       MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]");
   *   mapManagementClient.deleteMapContextConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the MapContextConfig to delete. Format:
   *     `projects/{project}/mapConfigs/{map_config}/mapContextConfigs/{map_context_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMapContextConfig(MapContextConfigName name) {
    DeleteMapContextConfigRequest request =
        DeleteMapContextConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteMapContextConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   String name =
   *       MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]").toString();
   *   mapManagementClient.deleteMapContextConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the MapContextConfig to delete. Format:
   *     `projects/{project}/mapConfigs/{map_config}/mapContextConfigs/{map_context_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMapContextConfig(String name) {
    DeleteMapContextConfigRequest request =
        DeleteMapContextConfigRequest.newBuilder().setName(name).build();
    deleteMapContextConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   DeleteMapContextConfigRequest request =
   *       DeleteMapContextConfigRequest.newBuilder()
   *           .setName(
   *               MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
   *                   .toString())
   *           .build();
   *   mapManagementClient.deleteMapContextConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMapContextConfig(DeleteMapContextConfigRequest request) {
    deleteMapContextConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MapContextConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
   *   DeleteMapContextConfigRequest request =
   *       DeleteMapContextConfigRequest.newBuilder()
   *           .setName(
   *               MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       mapManagementClient.deleteMapContextConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMapContextConfigRequest, Empty>
      deleteMapContextConfigCallable() {
    return stub.deleteMapContextConfigCallable();
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

  public static class ListMapConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListMapConfigsRequest,
          ListMapConfigsResponse,
          MapConfig,
          ListMapConfigsPage,
          ListMapConfigsFixedSizeCollection> {

    public static ApiFuture<ListMapConfigsPagedResponse> createAsync(
        PageContext<ListMapConfigsRequest, ListMapConfigsResponse, MapConfig> context,
        ApiFuture<ListMapConfigsResponse> futureResponse) {
      ApiFuture<ListMapConfigsPage> futurePage =
          ListMapConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMapConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMapConfigsPagedResponse(ListMapConfigsPage page) {
      super(page, ListMapConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMapConfigsPage
      extends AbstractPage<
          ListMapConfigsRequest, ListMapConfigsResponse, MapConfig, ListMapConfigsPage> {

    private ListMapConfigsPage(
        PageContext<ListMapConfigsRequest, ListMapConfigsResponse, MapConfig> context,
        ListMapConfigsResponse response) {
      super(context, response);
    }

    private static ListMapConfigsPage createEmptyPage() {
      return new ListMapConfigsPage(null, null);
    }

    @Override
    protected ListMapConfigsPage createPage(
        PageContext<ListMapConfigsRequest, ListMapConfigsResponse, MapConfig> context,
        ListMapConfigsResponse response) {
      return new ListMapConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListMapConfigsPage> createPageAsync(
        PageContext<ListMapConfigsRequest, ListMapConfigsResponse, MapConfig> context,
        ApiFuture<ListMapConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMapConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMapConfigsRequest,
          ListMapConfigsResponse,
          MapConfig,
          ListMapConfigsPage,
          ListMapConfigsFixedSizeCollection> {

    private ListMapConfigsFixedSizeCollection(List<ListMapConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMapConfigsFixedSizeCollection createEmptyCollection() {
      return new ListMapConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMapConfigsFixedSizeCollection createCollection(
        List<ListMapConfigsPage> pages, int collectionSize) {
      return new ListMapConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListStyleConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListStyleConfigsRequest,
          ListStyleConfigsResponse,
          StyleConfig,
          ListStyleConfigsPage,
          ListStyleConfigsFixedSizeCollection> {

    public static ApiFuture<ListStyleConfigsPagedResponse> createAsync(
        PageContext<ListStyleConfigsRequest, ListStyleConfigsResponse, StyleConfig> context,
        ApiFuture<ListStyleConfigsResponse> futureResponse) {
      ApiFuture<ListStyleConfigsPage> futurePage =
          ListStyleConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListStyleConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListStyleConfigsPagedResponse(ListStyleConfigsPage page) {
      super(page, ListStyleConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListStyleConfigsPage
      extends AbstractPage<
          ListStyleConfigsRequest, ListStyleConfigsResponse, StyleConfig, ListStyleConfigsPage> {

    private ListStyleConfigsPage(
        PageContext<ListStyleConfigsRequest, ListStyleConfigsResponse, StyleConfig> context,
        ListStyleConfigsResponse response) {
      super(context, response);
    }

    private static ListStyleConfigsPage createEmptyPage() {
      return new ListStyleConfigsPage(null, null);
    }

    @Override
    protected ListStyleConfigsPage createPage(
        PageContext<ListStyleConfigsRequest, ListStyleConfigsResponse, StyleConfig> context,
        ListStyleConfigsResponse response) {
      return new ListStyleConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListStyleConfigsPage> createPageAsync(
        PageContext<ListStyleConfigsRequest, ListStyleConfigsResponse, StyleConfig> context,
        ApiFuture<ListStyleConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListStyleConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListStyleConfigsRequest,
          ListStyleConfigsResponse,
          StyleConfig,
          ListStyleConfigsPage,
          ListStyleConfigsFixedSizeCollection> {

    private ListStyleConfigsFixedSizeCollection(
        List<ListStyleConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListStyleConfigsFixedSizeCollection createEmptyCollection() {
      return new ListStyleConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListStyleConfigsFixedSizeCollection createCollection(
        List<ListStyleConfigsPage> pages, int collectionSize) {
      return new ListStyleConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMapContextConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListMapContextConfigsRequest,
          ListMapContextConfigsResponse,
          MapContextConfig,
          ListMapContextConfigsPage,
          ListMapContextConfigsFixedSizeCollection> {

    public static ApiFuture<ListMapContextConfigsPagedResponse> createAsync(
        PageContext<ListMapContextConfigsRequest, ListMapContextConfigsResponse, MapContextConfig>
            context,
        ApiFuture<ListMapContextConfigsResponse> futureResponse) {
      ApiFuture<ListMapContextConfigsPage> futurePage =
          ListMapContextConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMapContextConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMapContextConfigsPagedResponse(ListMapContextConfigsPage page) {
      super(page, ListMapContextConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMapContextConfigsPage
      extends AbstractPage<
          ListMapContextConfigsRequest,
          ListMapContextConfigsResponse,
          MapContextConfig,
          ListMapContextConfigsPage> {

    private ListMapContextConfigsPage(
        PageContext<ListMapContextConfigsRequest, ListMapContextConfigsResponse, MapContextConfig>
            context,
        ListMapContextConfigsResponse response) {
      super(context, response);
    }

    private static ListMapContextConfigsPage createEmptyPage() {
      return new ListMapContextConfigsPage(null, null);
    }

    @Override
    protected ListMapContextConfigsPage createPage(
        PageContext<ListMapContextConfigsRequest, ListMapContextConfigsResponse, MapContextConfig>
            context,
        ListMapContextConfigsResponse response) {
      return new ListMapContextConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListMapContextConfigsPage> createPageAsync(
        PageContext<ListMapContextConfigsRequest, ListMapContextConfigsResponse, MapContextConfig>
            context,
        ApiFuture<ListMapContextConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMapContextConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMapContextConfigsRequest,
          ListMapContextConfigsResponse,
          MapContextConfig,
          ListMapContextConfigsPage,
          ListMapContextConfigsFixedSizeCollection> {

    private ListMapContextConfigsFixedSizeCollection(
        List<ListMapContextConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMapContextConfigsFixedSizeCollection createEmptyCollection() {
      return new ListMapContextConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMapContextConfigsFixedSizeCollection createCollection(
        List<ListMapContextConfigsPage> pages, int collectionSize) {
      return new ListMapContextConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
