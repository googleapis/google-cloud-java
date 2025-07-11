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

package com.google.cloud.licensemanager.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.licensemanager.v1.stub.LicenseManagerStub;
import com.google.cloud.licensemanager.v1.stub.LicenseManagerStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
 *   ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
 *   Configuration response = licenseManagerClient.getConfiguration(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LicenseManagerClient object to clean up resources such
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
 *      <td><p> ListConfigurations</td>
 *      <td><p> Lists Configurations in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConfigurations(ListConfigurationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConfigurations(LocationName parent)
 *           <li><p> listConfigurations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConfigurationsPagedCallable()
 *           <li><p> listConfigurationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConfiguration</td>
 *      <td><p> Gets details of a single Configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConfiguration(GetConfigurationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConfiguration(ConfigurationName name)
 *           <li><p> getConfiguration(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConfigurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateConfiguration</td>
 *      <td><p> Creates a new Configuration in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConfigurationAsync(CreateConfigurationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createConfigurationAsync(LocationName parent, Configuration configuration, String configurationId)
 *           <li><p> createConfigurationAsync(String parent, Configuration configuration, String configurationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConfigurationOperationCallable()
 *           <li><p> createConfigurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConfiguration</td>
 *      <td><p> Updates the parameters of a single Configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConfigurationAsync(UpdateConfigurationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateConfigurationAsync(Configuration configuration, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConfigurationOperationCallable()
 *           <li><p> updateConfigurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConfiguration</td>
 *      <td><p> Deletes a single Configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConfigurationAsync(DeleteConfigurationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteConfigurationAsync(ConfigurationName name)
 *           <li><p> deleteConfigurationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConfigurationOperationCallable()
 *           <li><p> deleteConfigurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListInstances</td>
 *      <td><p> Lists Instances in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInstances(ListInstancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInstances(LocationName parent)
 *           <li><p> listInstances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInstancesPagedCallable()
 *           <li><p> listInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInstance</td>
 *      <td><p> Gets details of a single Instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInstance(GetInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInstance(InstanceName name)
 *           <li><p> getInstance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeactivateConfiguration</td>
 *      <td><p> Deactivates the given configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deactivateConfigurationAsync(DeactivateConfigurationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deactivateConfigurationAsync(ConfigurationName name)
 *           <li><p> deactivateConfigurationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deactivateConfigurationOperationCallable()
 *           <li><p> deactivateConfigurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReactivateConfiguration</td>
 *      <td><p> Reactivates the given configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> reactivateConfigurationAsync(ReactivateConfigurationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> reactivateConfigurationAsync(ConfigurationName name)
 *           <li><p> reactivateConfigurationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> reactivateConfigurationOperationCallable()
 *           <li><p> reactivateConfigurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryConfigurationLicenseUsage</td>
 *      <td><p> License Usage information for a Configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryConfigurationLicenseUsage(QueryConfigurationLicenseUsageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> queryConfigurationLicenseUsage(ConfigurationName name, Timestamp startTime, Timestamp endTime)
 *           <li><p> queryConfigurationLicenseUsage(String name, Timestamp startTime, Timestamp endTime)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryConfigurationLicenseUsageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AggregateUsage</td>
 *      <td><p> Aggregates Usage per Instance for a Configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregateUsage(AggregateUsageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> aggregateUsage(ConfigurationName name, Timestamp startTime, Timestamp endTime)
 *           <li><p> aggregateUsage(String name, Timestamp startTime, Timestamp endTime)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> aggregateUsagePagedCallable()
 *           <li><p> aggregateUsageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProducts</td>
 *      <td><p> Lists Products in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProducts(ListProductsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProducts(LocationName parent)
 *           <li><p> listProducts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProductsPagedCallable()
 *           <li><p> listProductsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetProduct</td>
 *      <td><p> Gets details of a single Product.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProduct(GetProductRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProduct(ProductName name)
 *           <li><p> getProduct(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProductCallable()
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
 * <p>This class can be customized by passing in a custom instance of LicenseManagerSettings to
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
 * LicenseManagerSettings licenseManagerSettings =
 *     LicenseManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LicenseManagerClient licenseManagerClient = LicenseManagerClient.create(licenseManagerSettings);
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
 * LicenseManagerSettings licenseManagerSettings =
 *     LicenseManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LicenseManagerClient licenseManagerClient = LicenseManagerClient.create(licenseManagerSettings);
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
 * LicenseManagerSettings licenseManagerSettings =
 *     LicenseManagerSettings.newHttpJsonBuilder().build();
 * LicenseManagerClient licenseManagerClient = LicenseManagerClient.create(licenseManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LicenseManagerClient implements BackgroundResource {
  private final LicenseManagerSettings settings;
  private final LicenseManagerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of LicenseManagerClient with default settings. */
  public static final LicenseManagerClient create() throws IOException {
    return create(LicenseManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LicenseManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LicenseManagerClient create(LicenseManagerSettings settings)
      throws IOException {
    return new LicenseManagerClient(settings);
  }

  /**
   * Constructs an instance of LicenseManagerClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LicenseManagerSettings).
   */
  public static final LicenseManagerClient create(LicenseManagerStub stub) {
    return new LicenseManagerClient(stub);
  }

  /**
   * Constructs an instance of LicenseManagerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LicenseManagerClient(LicenseManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LicenseManagerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected LicenseManagerClient(LicenseManagerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final LicenseManagerSettings getSettings() {
    return settings;
  }

  public LicenseManagerStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Configurations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Configuration element : licenseManagerClient.listConfigurations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListConfigurationsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConfigurationsPagedResponse listConfigurations(LocationName parent) {
    ListConfigurationsRequest request =
        ListConfigurationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConfigurations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Configurations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Configuration element : licenseManagerClient.listConfigurations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListConfigurationsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConfigurationsPagedResponse listConfigurations(String parent) {
    ListConfigurationsRequest request =
        ListConfigurationsRequest.newBuilder().setParent(parent).build();
    return listConfigurations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Configurations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListConfigurationsRequest request =
   *       ListConfigurationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Configuration element : licenseManagerClient.listConfigurations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConfigurationsPagedResponse listConfigurations(
      ListConfigurationsRequest request) {
    return listConfigurationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Configurations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListConfigurationsRequest request =
   *       ListConfigurationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Configuration> future =
   *       licenseManagerClient.listConfigurationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Configuration element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConfigurationsRequest, ListConfigurationsPagedResponse>
      listConfigurationsPagedCallable() {
    return stub.listConfigurationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Configurations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListConfigurationsRequest request =
   *       ListConfigurationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListConfigurationsResponse response =
   *         licenseManagerClient.listConfigurationsCallable().call(request);
   *     for (Configuration element : response.getConfigurationsList()) {
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
  public final UnaryCallable<ListConfigurationsRequest, ListConfigurationsResponse>
      listConfigurationsCallable() {
    return stub.listConfigurationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
   *   Configuration response = licenseManagerClient.getConfiguration(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Configuration getConfiguration(ConfigurationName name) {
    GetConfigurationRequest request =
        GetConfigurationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConfiguration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString();
   *   Configuration response = licenseManagerClient.getConfiguration(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Configuration getConfiguration(String name) {
    GetConfigurationRequest request = GetConfigurationRequest.newBuilder().setName(name).build();
    return getConfiguration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   GetConfigurationRequest request =
   *       GetConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .build();
   *   Configuration response = licenseManagerClient.getConfiguration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Configuration getConfiguration(GetConfigurationRequest request) {
    return getConfigurationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   GetConfigurationRequest request =
   *       GetConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .build();
   *   ApiFuture<Configuration> future =
   *       licenseManagerClient.getConfigurationCallable().futureCall(request);
   *   // Do something.
   *   Configuration response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConfigurationRequest, Configuration> getConfigurationCallable() {
    return stub.getConfigurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Configuration in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Configuration configuration = Configuration.newBuilder().build();
   *   String configurationId = "configurationId1948915889";
   *   Configuration response =
   *       licenseManagerClient
   *           .createConfigurationAsync(parent, configuration, configurationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param configuration Required. The resource being created
   * @param configurationId Required. Id of the requesting object
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> createConfigurationAsync(
      LocationName parent, Configuration configuration, String configurationId) {
    CreateConfigurationRequest request =
        CreateConfigurationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConfiguration(configuration)
            .setConfigurationId(configurationId)
            .build();
    return createConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Configuration in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Configuration configuration = Configuration.newBuilder().build();
   *   String configurationId = "configurationId1948915889";
   *   Configuration response =
   *       licenseManagerClient
   *           .createConfigurationAsync(parent, configuration, configurationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param configuration Required. The resource being created
   * @param configurationId Required. Id of the requesting object
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> createConfigurationAsync(
      String parent, Configuration configuration, String configurationId) {
    CreateConfigurationRequest request =
        CreateConfigurationRequest.newBuilder()
            .setParent(parent)
            .setConfiguration(configuration)
            .setConfigurationId(configurationId)
            .build();
    return createConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Configuration in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   CreateConfigurationRequest request =
   *       CreateConfigurationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConfigurationId("configurationId1948915889")
   *           .setConfiguration(Configuration.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Configuration response = licenseManagerClient.createConfigurationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> createConfigurationAsync(
      CreateConfigurationRequest request) {
    return createConfigurationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Configuration in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   CreateConfigurationRequest request =
   *       CreateConfigurationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConfigurationId("configurationId1948915889")
   *           .setConfiguration(Configuration.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Configuration, OperationMetadata> future =
   *       licenseManagerClient.createConfigurationOperationCallable().futureCall(request);
   *   // Do something.
   *   Configuration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationCallable() {
    return stub.createConfigurationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Configuration in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   CreateConfigurationRequest request =
   *       CreateConfigurationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConfigurationId("configurationId1948915889")
   *           .setConfiguration(Configuration.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       licenseManagerClient.createConfigurationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConfigurationRequest, Operation> createConfigurationCallable() {
    return stub.createConfigurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   Configuration configuration = Configuration.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Configuration response =
   *       licenseManagerClient.updateConfigurationAsync(configuration, updateMask).get();
   * }
   * }</pre>
   *
   * @param configuration Required. The resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Configuration resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> updateConfigurationAsync(
      Configuration configuration, FieldMask updateMask) {
    UpdateConfigurationRequest request =
        UpdateConfigurationRequest.newBuilder()
            .setConfiguration(configuration)
            .setUpdateMask(updateMask)
            .build();
    return updateConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   UpdateConfigurationRequest request =
   *       UpdateConfigurationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConfiguration(Configuration.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Configuration response = licenseManagerClient.updateConfigurationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> updateConfigurationAsync(
      UpdateConfigurationRequest request) {
    return updateConfigurationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   UpdateConfigurationRequest request =
   *       UpdateConfigurationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConfiguration(Configuration.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Configuration, OperationMetadata> future =
   *       licenseManagerClient.updateConfigurationOperationCallable().futureCall(request);
   *   // Do something.
   *   Configuration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationCallable() {
    return stub.updateConfigurationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   UpdateConfigurationRequest request =
   *       UpdateConfigurationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConfiguration(Configuration.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       licenseManagerClient.updateConfigurationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConfigurationRequest, Operation> updateConfigurationCallable() {
    return stub.updateConfigurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
   *   licenseManagerClient.deleteConfigurationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConfigurationAsync(
      ConfigurationName name) {
    DeleteConfigurationRequest request =
        DeleteConfigurationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString();
   *   licenseManagerClient.deleteConfigurationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConfigurationAsync(String name) {
    DeleteConfigurationRequest request =
        DeleteConfigurationRequest.newBuilder().setName(name).build();
    return deleteConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   DeleteConfigurationRequest request =
   *       DeleteConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   licenseManagerClient.deleteConfigurationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConfigurationAsync(
      DeleteConfigurationRequest request) {
    return deleteConfigurationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   DeleteConfigurationRequest request =
   *       DeleteConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       licenseManagerClient.deleteConfigurationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationCallable() {
    return stub.deleteConfigurationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   DeleteConfigurationRequest request =
   *       DeleteConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       licenseManagerClient.deleteConfigurationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConfigurationRequest, Operation> deleteConfigurationCallable() {
    return stub.deleteConfigurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : licenseManagerClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Instance element : licenseManagerClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Instance element : licenseManagerClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Instance> future =
   *       licenseManagerClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response = licenseManagerClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getInstancesList()) {
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
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = licenseManagerClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Instance response = licenseManagerClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = licenseManagerClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future = licenseManagerClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
   *   Configuration response = licenseManagerClient.deactivateConfigurationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> deactivateConfigurationAsync(
      ConfigurationName name) {
    DeactivateConfigurationRequest request =
        DeactivateConfigurationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deactivateConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString();
   *   Configuration response = licenseManagerClient.deactivateConfigurationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> deactivateConfigurationAsync(
      String name) {
    DeactivateConfigurationRequest request =
        DeactivateConfigurationRequest.newBuilder().setName(name).build();
    return deactivateConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   DeactivateConfigurationRequest request =
   *       DeactivateConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Configuration response = licenseManagerClient.deactivateConfigurationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> deactivateConfigurationAsync(
      DeactivateConfigurationRequest request) {
    return deactivateConfigurationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   DeactivateConfigurationRequest request =
   *       DeactivateConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Configuration, OperationMetadata> future =
   *       licenseManagerClient.deactivateConfigurationOperationCallable().futureCall(request);
   *   // Do something.
   *   Configuration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationCallable() {
    return stub.deactivateConfigurationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   DeactivateConfigurationRequest request =
   *       DeactivateConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       licenseManagerClient.deactivateConfigurationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationCallable() {
    return stub.deactivateConfigurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
   *   Configuration response = licenseManagerClient.reactivateConfigurationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> reactivateConfigurationAsync(
      ConfigurationName name) {
    ReactivateConfigurationRequest request =
        ReactivateConfigurationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return reactivateConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString();
   *   Configuration response = licenseManagerClient.reactivateConfigurationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> reactivateConfigurationAsync(
      String name) {
    ReactivateConfigurationRequest request =
        ReactivateConfigurationRequest.newBuilder().setName(name).build();
    return reactivateConfigurationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ReactivateConfigurationRequest request =
   *       ReactivateConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Configuration response = licenseManagerClient.reactivateConfigurationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Configuration, OperationMetadata> reactivateConfigurationAsync(
      ReactivateConfigurationRequest request) {
    return reactivateConfigurationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ReactivateConfigurationRequest request =
   *       ReactivateConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Configuration, OperationMetadata> future =
   *       licenseManagerClient.reactivateConfigurationOperationCallable().futureCall(request);
   *   // Do something.
   *   Configuration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationCallable() {
    return stub.reactivateConfigurationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates the given configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ReactivateConfigurationRequest request =
   *       ReactivateConfigurationRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       licenseManagerClient.reactivateConfigurationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationCallable() {
    return stub.reactivateConfigurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * License Usage information for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Timestamp endTime = Timestamp.newBuilder().build();
   *   QueryConfigurationLicenseUsageResponse response =
   *       licenseManagerClient.queryConfigurationLicenseUsage(name, startTime, endTime);
   * }
   * }</pre>
   *
   * @param name Required. The resource path of the Configuration.
   * @param startTime Required. The start time for retrieving the usage. If not specified, we will
   *     use the first day of the current billing period.
   * @param endTime Required. The end time for retrieving the usage. If not specified, we will use
   *     the last day of the current billing period.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryConfigurationLicenseUsageResponse queryConfigurationLicenseUsage(
      ConfigurationName name, Timestamp startTime, Timestamp endTime) {
    QueryConfigurationLicenseUsageRequest request =
        QueryConfigurationLicenseUsageRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    return queryConfigurationLicenseUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * License Usage information for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString();
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Timestamp endTime = Timestamp.newBuilder().build();
   *   QueryConfigurationLicenseUsageResponse response =
   *       licenseManagerClient.queryConfigurationLicenseUsage(name, startTime, endTime);
   * }
   * }</pre>
   *
   * @param name Required. The resource path of the Configuration.
   * @param startTime Required. The start time for retrieving the usage. If not specified, we will
   *     use the first day of the current billing period.
   * @param endTime Required. The end time for retrieving the usage. If not specified, we will use
   *     the last day of the current billing period.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryConfigurationLicenseUsageResponse queryConfigurationLicenseUsage(
      String name, Timestamp startTime, Timestamp endTime) {
    QueryConfigurationLicenseUsageRequest request =
        QueryConfigurationLicenseUsageRequest.newBuilder()
            .setName(name)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    return queryConfigurationLicenseUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * License Usage information for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   QueryConfigurationLicenseUsageRequest request =
   *       QueryConfigurationLicenseUsageRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   QueryConfigurationLicenseUsageResponse response =
   *       licenseManagerClient.queryConfigurationLicenseUsage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryConfigurationLicenseUsageResponse queryConfigurationLicenseUsage(
      QueryConfigurationLicenseUsageRequest request) {
    return queryConfigurationLicenseUsageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * License Usage information for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   QueryConfigurationLicenseUsageRequest request =
   *       QueryConfigurationLicenseUsageRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<QueryConfigurationLicenseUsageResponse> future =
   *       licenseManagerClient.queryConfigurationLicenseUsageCallable().futureCall(request);
   *   // Do something.
   *   QueryConfigurationLicenseUsageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageCallable() {
    return stub.queryConfigurationLicenseUsageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates Usage per Instance for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ConfigurationName name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]");
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Timestamp endTime = Timestamp.newBuilder().build();
   *   for (Usage element :
   *       licenseManagerClient.aggregateUsage(name, startTime, endTime).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. Parent value for AggregateUsageRequest
   * @param startTime Required. Licenses are purchased per month - so usage track needs start time
   *     of a month.
   * @param endTime Required. Usage track is always for a month. This parameter is for the end time
   *     of the month.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateUsagePagedResponse aggregateUsage(
      ConfigurationName name, Timestamp startTime, Timestamp endTime) {
    AggregateUsageRequest request =
        AggregateUsageRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    return aggregateUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates Usage per Instance for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String name = ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString();
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Timestamp endTime = Timestamp.newBuilder().build();
   *   for (Usage element :
   *       licenseManagerClient.aggregateUsage(name, startTime, endTime).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. Parent value for AggregateUsageRequest
   * @param startTime Required. Licenses are purchased per month - so usage track needs start time
   *     of a month.
   * @param endTime Required. Usage track is always for a month. This parameter is for the end time
   *     of the month.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateUsagePagedResponse aggregateUsage(
      String name, Timestamp startTime, Timestamp endTime) {
    AggregateUsageRequest request =
        AggregateUsageRequest.newBuilder()
            .setName(name)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    return aggregateUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates Usage per Instance for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   AggregateUsageRequest request =
   *       AggregateUsageRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   for (Usage element : licenseManagerClient.aggregateUsage(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateUsagePagedResponse aggregateUsage(AggregateUsageRequest request) {
    return aggregateUsagePagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates Usage per Instance for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   AggregateUsageRequest request =
   *       AggregateUsageRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Usage> future =
   *       licenseManagerClient.aggregateUsagePagedCallable().futureCall(request);
   *   // Do something.
   *   for (Usage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregateUsageRequest, AggregateUsagePagedResponse>
      aggregateUsagePagedCallable() {
    return stub.aggregateUsagePagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates Usage per Instance for a Configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   AggregateUsageRequest request =
   *       AggregateUsageRequest.newBuilder()
   *           .setName(
   *               ConfigurationName.of("[PROJECT]", "[LOCATION]", "[CONFIGURATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   while (true) {
   *     AggregateUsageResponse response =
   *         licenseManagerClient.aggregateUsageCallable().call(request);
   *     for (Usage element : response.getUsagesList()) {
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
  public final UnaryCallable<AggregateUsageRequest, AggregateUsageResponse>
      aggregateUsageCallable() {
    return stub.aggregateUsageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Products in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Product element : licenseManagerClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProductsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(LocationName parent) {
    ListProductsRequest request =
        ListProductsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Products in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Product element : licenseManagerClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProductsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(String parent) {
    ListProductsRequest request = ListProductsRequest.newBuilder().setParent(parent).build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Products in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Product element : licenseManagerClient.listProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(ListProductsRequest request) {
    return listProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Products in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Product> future =
   *       licenseManagerClient.listProductsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable() {
    return stub.listProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Products in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListProductsResponse response = licenseManagerClient.listProductsCallable().call(request);
   *     for (Product element : response.getProductsList()) {
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
  public final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return stub.listProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   Product response = licenseManagerClient.getProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(ProductName name) {
    GetProductRequest request =
        GetProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   String name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   Product response = licenseManagerClient.getProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(String name) {
    GetProductRequest request = GetProductRequest.newBuilder().setName(name).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   GetProductRequest request =
   *       GetProductRequest.newBuilder()
   *           .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   Product response = licenseManagerClient.getProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(GetProductRequest request) {
    return getProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Product.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   GetProductRequest request =
   *       GetProductRequest.newBuilder()
   *           .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   ApiFuture<Product> future = licenseManagerClient.getProductCallable().futureCall(request);
   *   // Do something.
   *   Product response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return stub.getProductCallable();
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
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : licenseManagerClient.listLocations(request).iterateAll()) {
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
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       licenseManagerClient.listLocationsPagedCallable().futureCall(request);
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
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = licenseManagerClient.listLocationsCallable().call(request);
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
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = licenseManagerClient.getLocation(request);
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
   * try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = licenseManagerClient.getLocationCallable().futureCall(request);
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

  public static class ListConfigurationsPagedResponse
      extends AbstractPagedListResponse<
          ListConfigurationsRequest,
          ListConfigurationsResponse,
          Configuration,
          ListConfigurationsPage,
          ListConfigurationsFixedSizeCollection> {

    public static ApiFuture<ListConfigurationsPagedResponse> createAsync(
        PageContext<ListConfigurationsRequest, ListConfigurationsResponse, Configuration> context,
        ApiFuture<ListConfigurationsResponse> futureResponse) {
      ApiFuture<ListConfigurationsPage> futurePage =
          ListConfigurationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConfigurationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConfigurationsPagedResponse(ListConfigurationsPage page) {
      super(page, ListConfigurationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConfigurationsPage
      extends AbstractPage<
          ListConfigurationsRequest,
          ListConfigurationsResponse,
          Configuration,
          ListConfigurationsPage> {

    private ListConfigurationsPage(
        PageContext<ListConfigurationsRequest, ListConfigurationsResponse, Configuration> context,
        ListConfigurationsResponse response) {
      super(context, response);
    }

    private static ListConfigurationsPage createEmptyPage() {
      return new ListConfigurationsPage(null, null);
    }

    @Override
    protected ListConfigurationsPage createPage(
        PageContext<ListConfigurationsRequest, ListConfigurationsResponse, Configuration> context,
        ListConfigurationsResponse response) {
      return new ListConfigurationsPage(context, response);
    }

    @Override
    public ApiFuture<ListConfigurationsPage> createPageAsync(
        PageContext<ListConfigurationsRequest, ListConfigurationsResponse, Configuration> context,
        ApiFuture<ListConfigurationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConfigurationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConfigurationsRequest,
          ListConfigurationsResponse,
          Configuration,
          ListConfigurationsPage,
          ListConfigurationsFixedSizeCollection> {

    private ListConfigurationsFixedSizeCollection(
        List<ListConfigurationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConfigurationsFixedSizeCollection createEmptyCollection() {
      return new ListConfigurationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConfigurationsFixedSizeCollection createCollection(
        List<ListConfigurationsPage> pages, int collectionSize) {
      return new ListConfigurationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class AggregateUsagePagedResponse
      extends AbstractPagedListResponse<
          AggregateUsageRequest,
          AggregateUsageResponse,
          Usage,
          AggregateUsagePage,
          AggregateUsageFixedSizeCollection> {

    public static ApiFuture<AggregateUsagePagedResponse> createAsync(
        PageContext<AggregateUsageRequest, AggregateUsageResponse, Usage> context,
        ApiFuture<AggregateUsageResponse> futureResponse) {
      ApiFuture<AggregateUsagePage> futurePage =
          AggregateUsagePage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregateUsagePagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregateUsagePagedResponse(AggregateUsagePage page) {
      super(page, AggregateUsageFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregateUsagePage
      extends AbstractPage<
          AggregateUsageRequest, AggregateUsageResponse, Usage, AggregateUsagePage> {

    private AggregateUsagePage(
        PageContext<AggregateUsageRequest, AggregateUsageResponse, Usage> context,
        AggregateUsageResponse response) {
      super(context, response);
    }

    private static AggregateUsagePage createEmptyPage() {
      return new AggregateUsagePage(null, null);
    }

    @Override
    protected AggregateUsagePage createPage(
        PageContext<AggregateUsageRequest, AggregateUsageResponse, Usage> context,
        AggregateUsageResponse response) {
      return new AggregateUsagePage(context, response);
    }

    @Override
    public ApiFuture<AggregateUsagePage> createPageAsync(
        PageContext<AggregateUsageRequest, AggregateUsageResponse, Usage> context,
        ApiFuture<AggregateUsageResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregateUsageFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregateUsageRequest,
          AggregateUsageResponse,
          Usage,
          AggregateUsagePage,
          AggregateUsageFixedSizeCollection> {

    private AggregateUsageFixedSizeCollection(List<AggregateUsagePage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregateUsageFixedSizeCollection createEmptyCollection() {
      return new AggregateUsageFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregateUsageFixedSizeCollection createCollection(
        List<AggregateUsagePage> pages, int collectionSize) {
      return new AggregateUsageFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProductsPagedResponse
      extends AbstractPagedListResponse<
          ListProductsRequest,
          ListProductsResponse,
          Product,
          ListProductsPage,
          ListProductsFixedSizeCollection> {

    public static ApiFuture<ListProductsPagedResponse> createAsync(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ApiFuture<ListProductsResponse> futureResponse) {
      ApiFuture<ListProductsPage> futurePage =
          ListProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProductsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProductsPagedResponse(ListProductsPage page) {
      super(page, ListProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProductsPage
      extends AbstractPage<ListProductsRequest, ListProductsResponse, Product, ListProductsPage> {

    private ListProductsPage(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ListProductsResponse response) {
      super(context, response);
    }

    private static ListProductsPage createEmptyPage() {
      return new ListProductsPage(null, null);
    }

    @Override
    protected ListProductsPage createPage(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ListProductsResponse response) {
      return new ListProductsPage(context, response);
    }

    @Override
    public ApiFuture<ListProductsPage> createPageAsync(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ApiFuture<ListProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProductsRequest,
          ListProductsResponse,
          Product,
          ListProductsPage,
          ListProductsFixedSizeCollection> {

    private ListProductsFixedSizeCollection(List<ListProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProductsFixedSizeCollection createEmptyCollection() {
      return new ListProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProductsFixedSizeCollection createCollection(
        List<ListProductsPage> pages, int collectionSize) {
      return new ListProductsFixedSizeCollection(pages, collectionSize);
    }
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
