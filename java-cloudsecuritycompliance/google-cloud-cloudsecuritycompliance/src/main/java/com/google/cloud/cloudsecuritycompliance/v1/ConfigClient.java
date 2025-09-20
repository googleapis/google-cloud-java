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

package com.google.cloud.cloudsecuritycompliance.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.stub.ConfigStub;
import com.google.cloud.cloudsecuritycompliance.v1.stub.ConfigStubSettings;
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
 * Service Description: Config Service manages compliance frameworks, cloud controls, and their
 * configurations.
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
 * try (ConfigClient configClient = ConfigClient.create()) {
 *   FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");
 *   Framework response = configClient.getFramework(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConfigClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListFrameworks</td>
 *      <td><p> Lists all Frameworks (both Built-in and Custom) available within a given parent resource. This method supports pagination. The latest major version of each Framework is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFrameworks(ListFrameworksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFrameworks(OrganizationLocationName parent)
 *           <li><p> listFrameworks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFrameworksPagedCallable()
 *           <li><p> listFrameworksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFramework</td>
 *      <td><p> Gets details of a single Framework. This method retrieves a Framework resource, which can be either Built-in or Custom, identified by its name.
 * <p>  By default, the latest major version of the Framework is returned. A specific major version can be retrieved by specifying the `major_revision_id` in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFramework(GetFrameworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFramework(FrameworkName name)
 *           <li><p> getFramework(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFrameworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFramework</td>
 *      <td><p> Creates a new Framework with type `Custom` under a given parent resource. Frameworks with type `Built-in` are managed by Google and cannot be created through this API.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFramework(CreateFrameworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createFramework(OrganizationLocationName parent, Framework framework, String frameworkId)
 *           <li><p> createFramework(String parent, Framework framework, String frameworkId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFrameworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFramework</td>
 *      <td><p> Updates a single Framework. This method allows for partial updates of a Framework resource. The fields to be updated are specified using the `update_mask`.
 * <p>  - If an `update_mask` is provided, only the fields specified in the mask will be updated. - If no `update_mask` is provided, all fields present in the request's `framework` body will be used to overwrite the existing resource.
 * <p>  This operation can only be performed on Frameworks with type `CUSTOM`. A successful update will result in a new version of the Framework.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFramework(UpdateFrameworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFramework(Framework framework, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFrameworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFramework</td>
 *      <td><p> Deletes a single Custom Framework, including all its minor and minor revisions.
 * <p>  - This operation can only be performed on Frameworks with type `CUSTOM`.   Built-in Frameworks cannot be deleted. - The Framework cannot be deleted if it is currently deployed on any   resource. - This action is permanent and cannot be undone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFramework(DeleteFrameworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteFramework(FrameworkName name)
 *           <li><p> deleteFramework(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFrameworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCloudControls</td>
 *      <td><p> Lists all CloudControls (both Built-in and Custom) available within a given parent resource. This method supports pagination. The latest major version of each CloudControl is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCloudControls(ListCloudControlsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCloudControls(OrganizationLocationName parent)
 *           <li><p> listCloudControls(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCloudControlsPagedCallable()
 *           <li><p> listCloudControlsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCloudControl</td>
 *      <td><p> Gets details of a single CloudControl. This method retrieves a CloudControl resource, which can be either Built-in or Custom, identified by its name.
 * <p>  By default, the latest major version of the CloudControl is returned. A specific major version can be retrieved by specifying the `major_revision_id` in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCloudControl(GetCloudControlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCloudControl(CloudControlName name)
 *           <li><p> getCloudControl(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCloudControlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCloudControl</td>
 *      <td><p> Creates a new CloudControl with type `Custom` under a given parent resource. `Built-in` CloudControls are managed by Google and cannot be created through this API.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCloudControl(CreateCloudControlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCloudControl(OrganizationLocationName parent, CloudControl cloudControl, String cloudControlId)
 *           <li><p> createCloudControl(String parent, CloudControl cloudControl, String cloudControlId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCloudControlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCloudControl</td>
 *      <td><p> Updates a single CloudControl. This method allows for partial updates of a Custom CloudControl resource. Built-in CloudControls cannot be updated.
 * <p>  - If an `update_mask` is provided, only the fields specified in the mask will be updated. - If no `update_mask` is provided, all fields present in the request's `cloud_control` body will be used to overwrite the existing resource.
 * <p>  A successful update will result in a new version of the CloudControl.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCloudControl(UpdateCloudControlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCloudControl(CloudControl cloudControl, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCloudControlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCloudControl</td>
 *      <td><p> Deletes a single Custom CloudControl, including all its major and minor revisions.
 * <p>  - This operation can only be performed on CloudControls with type `CUSTOM`.   Built-in CloudControls cannot be deleted. - The CloudControl cannot be deleted if any of its revisions are currently   referenced by any Framework. - This action is permanent and cannot be undone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCloudControl(DeleteCloudControlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCloudControl(CloudControlName name)
 *           <li><p> deleteCloudControl(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCloudControlCallable()
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
 * <p>This class can be customized by passing in a custom instance of ConfigSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigSettings configSettings =
 *     ConfigSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
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
 * ConfigSettings configSettings = ConfigSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
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
 * ConfigSettings configSettings = ConfigSettings.newHttpJsonBuilder().build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConfigClient implements BackgroundResource {
  private final ConfigSettings settings;
  private final ConfigStub stub;

  /** Constructs an instance of ConfigClient with default settings. */
  public static final ConfigClient create() throws IOException {
    return create(ConfigSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConfigClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConfigClient create(ConfigSettings settings) throws IOException {
    return new ConfigClient(settings);
  }

  /**
   * Constructs an instance of ConfigClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ConfigSettings).
   */
  public static final ConfigClient create(ConfigStub stub) {
    return new ConfigClient(stub);
  }

  /**
   * Constructs an instance of ConfigClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ConfigClient(ConfigSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConfigStubSettings) settings.getStubSettings()).createStub();
  }

  protected ConfigClient(ConfigStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConfigSettings getSettings() {
    return settings;
  }

  public ConfigStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Frameworks (both Built-in and Custom) available within a given parent resource. This
   * method supports pagination. The latest major version of each Framework is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (Framework element : configClient.listFrameworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the format
   *     `organizations/{organization}/locations/{location}`. Only global location is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworksPagedResponse listFrameworks(OrganizationLocationName parent) {
    ListFrameworksRequest request =
        ListFrameworksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFrameworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Frameworks (both Built-in and Custom) available within a given parent resource. This
   * method supports pagination. The latest major version of each Framework is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (Framework element : configClient.listFrameworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the format
   *     `organizations/{organization}/locations/{location}`. Only global location is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworksPagedResponse listFrameworks(String parent) {
    ListFrameworksRequest request = ListFrameworksRequest.newBuilder().setParent(parent).build();
    return listFrameworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Frameworks (both Built-in and Custom) available within a given parent resource. This
   * method supports pagination. The latest major version of each Framework is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListFrameworksRequest request =
   *       ListFrameworksRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Framework element : configClient.listFrameworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworksPagedResponse listFrameworks(ListFrameworksRequest request) {
    return listFrameworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Frameworks (both Built-in and Custom) available within a given parent resource. This
   * method supports pagination. The latest major version of each Framework is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListFrameworksRequest request =
   *       ListFrameworksRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Framework> future = configClient.listFrameworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Framework element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFrameworksRequest, ListFrameworksPagedResponse>
      listFrameworksPagedCallable() {
    return stub.listFrameworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Frameworks (both Built-in and Custom) available within a given parent resource. This
   * method supports pagination. The latest major version of each Framework is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListFrameworksRequest request =
   *       ListFrameworksRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFrameworksResponse response = configClient.listFrameworksCallable().call(request);
   *     for (Framework element : response.getFrameworksList()) {
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
  public final UnaryCallable<ListFrameworksRequest, ListFrameworksResponse>
      listFrameworksCallable() {
    return stub.listFrameworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Framework. This method retrieves a Framework resource, which can be
   * either Built-in or Custom, identified by its name.
   *
   * <p>By default, the latest major version of the Framework is returned. A specific major version
   * can be retrieved by specifying the `major_revision_id` in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");
   *   Framework response = configClient.getFramework(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the framework to retrieve. Format:
   *     organizations/{organization}/locations/{location}/frameworks/{framework_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Framework getFramework(FrameworkName name) {
    GetFrameworkRequest request =
        GetFrameworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFramework(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Framework. This method retrieves a Framework resource, which can be
   * either Built-in or Custom, identified by its name.
   *
   * <p>By default, the latest major version of the Framework is returned. A specific major version
   * can be retrieved by specifying the `major_revision_id` in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString();
   *   Framework response = configClient.getFramework(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the framework to retrieve. Format:
   *     organizations/{organization}/locations/{location}/frameworks/{framework_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Framework getFramework(String name) {
    GetFrameworkRequest request = GetFrameworkRequest.newBuilder().setName(name).build();
    return getFramework(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Framework. This method retrieves a Framework resource, which can be
   * either Built-in or Custom, identified by its name.
   *
   * <p>By default, the latest major version of the Framework is returned. A specific major version
   * can be retrieved by specifying the `major_revision_id` in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetFrameworkRequest request =
   *       GetFrameworkRequest.newBuilder()
   *           .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
   *           .setMajorRevisionId(612576889)
   *           .build();
   *   Framework response = configClient.getFramework(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Framework getFramework(GetFrameworkRequest request) {
    return getFrameworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Framework. This method retrieves a Framework resource, which can be
   * either Built-in or Custom, identified by its name.
   *
   * <p>By default, the latest major version of the Framework is returned. A specific major version
   * can be retrieved by specifying the `major_revision_id` in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetFrameworkRequest request =
   *       GetFrameworkRequest.newBuilder()
   *           .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
   *           .setMajorRevisionId(612576889)
   *           .build();
   *   ApiFuture<Framework> future = configClient.getFrameworkCallable().futureCall(request);
   *   // Do something.
   *   Framework response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFrameworkRequest, Framework> getFrameworkCallable() {
    return stub.getFrameworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Framework with type `Custom` under a given parent resource. Frameworks with type
   * `Built-in` are managed by Google and cannot be created through this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   Framework framework = Framework.newBuilder().build();
   *   String frameworkId = "frameworkId886666169";
   *   Framework response = configClient.createFramework(parent, framework, frameworkId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the format
   *     `organizations/{organization}/locations/{location}`.
   * @param framework Required. The resource being created
   * @param frameworkId Required. ID of the framework. This is not the full name of the framework.
   *     This is the last part of the full name of the framework.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Framework createFramework(
      OrganizationLocationName parent, Framework framework, String frameworkId) {
    CreateFrameworkRequest request =
        CreateFrameworkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFramework(framework)
            .setFrameworkId(frameworkId)
            .build();
    return createFramework(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Framework with type `Custom` under a given parent resource. Frameworks with type
   * `Built-in` are managed by Google and cannot be created through this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   Framework framework = Framework.newBuilder().build();
   *   String frameworkId = "frameworkId886666169";
   *   Framework response = configClient.createFramework(parent, framework, frameworkId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the format
   *     `organizations/{organization}/locations/{location}`.
   * @param framework Required. The resource being created
   * @param frameworkId Required. ID of the framework. This is not the full name of the framework.
   *     This is the last part of the full name of the framework.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Framework createFramework(String parent, Framework framework, String frameworkId) {
    CreateFrameworkRequest request =
        CreateFrameworkRequest.newBuilder()
            .setParent(parent)
            .setFramework(framework)
            .setFrameworkId(frameworkId)
            .build();
    return createFramework(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Framework with type `Custom` under a given parent resource. Frameworks with type
   * `Built-in` are managed by Google and cannot be created through this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateFrameworkRequest request =
   *       CreateFrameworkRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setFrameworkId("frameworkId886666169")
   *           .setFramework(Framework.newBuilder().build())
   *           .build();
   *   Framework response = configClient.createFramework(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Framework createFramework(CreateFrameworkRequest request) {
    return createFrameworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Framework with type `Custom` under a given parent resource. Frameworks with type
   * `Built-in` are managed by Google and cannot be created through this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateFrameworkRequest request =
   *       CreateFrameworkRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setFrameworkId("frameworkId886666169")
   *           .setFramework(Framework.newBuilder().build())
   *           .build();
   *   ApiFuture<Framework> future = configClient.createFrameworkCallable().futureCall(request);
   *   // Do something.
   *   Framework response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFrameworkRequest, Framework> createFrameworkCallable() {
    return stub.createFrameworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Framework. This method allows for partial updates of a Framework resource. The
   * fields to be updated are specified using the `update_mask`.
   *
   * <p>- If an `update_mask` is provided, only the fields specified in the mask will be updated. -
   * If no `update_mask` is provided, all fields present in the request's `framework` body will be
   * used to overwrite the existing resource.
   *
   * <p>This operation can only be performed on Frameworks with type `CUSTOM`. A successful update
   * will result in a new version of the Framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   Framework framework = Framework.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Framework response = configClient.updateFramework(framework, updateMask);
   * }
   * }</pre>
   *
   * @param framework Required. The resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Framework resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields present in the request will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Framework updateFramework(Framework framework, FieldMask updateMask) {
    UpdateFrameworkRequest request =
        UpdateFrameworkRequest.newBuilder()
            .setFramework(framework)
            .setUpdateMask(updateMask)
            .build();
    return updateFramework(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Framework. This method allows for partial updates of a Framework resource. The
   * fields to be updated are specified using the `update_mask`.
   *
   * <p>- If an `update_mask` is provided, only the fields specified in the mask will be updated. -
   * If no `update_mask` is provided, all fields present in the request's `framework` body will be
   * used to overwrite the existing resource.
   *
   * <p>This operation can only be performed on Frameworks with type `CUSTOM`. A successful update
   * will result in a new version of the Framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateFrameworkRequest request =
   *       UpdateFrameworkRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFramework(Framework.newBuilder().build())
   *           .setMajorRevisionId(612576889)
   *           .build();
   *   Framework response = configClient.updateFramework(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Framework updateFramework(UpdateFrameworkRequest request) {
    return updateFrameworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Framework. This method allows for partial updates of a Framework resource. The
   * fields to be updated are specified using the `update_mask`.
   *
   * <p>- If an `update_mask` is provided, only the fields specified in the mask will be updated. -
   * If no `update_mask` is provided, all fields present in the request's `framework` body will be
   * used to overwrite the existing resource.
   *
   * <p>This operation can only be performed on Frameworks with type `CUSTOM`. A successful update
   * will result in a new version of the Framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateFrameworkRequest request =
   *       UpdateFrameworkRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFramework(Framework.newBuilder().build())
   *           .setMajorRevisionId(612576889)
   *           .build();
   *   ApiFuture<Framework> future = configClient.updateFrameworkCallable().futureCall(request);
   *   // Do something.
   *   Framework response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFrameworkRequest, Framework> updateFrameworkCallable() {
    return stub.updateFrameworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Custom Framework, including all its minor and minor revisions.
   *
   * <p>- This operation can only be performed on Frameworks with type `CUSTOM`. Built-in Frameworks
   * cannot be deleted. - The Framework cannot be deleted if it is currently deployed on any
   * resource. - This action is permanent and cannot be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");
   *   configClient.deleteFramework(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the format
   *     `organizations/{organization}/locations/{location}/frameworks/{framework}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFramework(FrameworkName name) {
    DeleteFrameworkRequest request =
        DeleteFrameworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteFramework(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Custom Framework, including all its minor and minor revisions.
   *
   * <p>- This operation can only be performed on Frameworks with type `CUSTOM`. Built-in Frameworks
   * cannot be deleted. - The Framework cannot be deleted if it is currently deployed on any
   * resource. - This action is permanent and cannot be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString();
   *   configClient.deleteFramework(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the format
   *     `organizations/{organization}/locations/{location}/frameworks/{framework}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFramework(String name) {
    DeleteFrameworkRequest request = DeleteFrameworkRequest.newBuilder().setName(name).build();
    deleteFramework(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Custom Framework, including all its minor and minor revisions.
   *
   * <p>- This operation can only be performed on Frameworks with type `CUSTOM`. Built-in Frameworks
   * cannot be deleted. - The Framework cannot be deleted if it is currently deployed on any
   * resource. - This action is permanent and cannot be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteFrameworkRequest request =
   *       DeleteFrameworkRequest.newBuilder()
   *           .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
   *           .build();
   *   configClient.deleteFramework(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFramework(DeleteFrameworkRequest request) {
    deleteFrameworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Custom Framework, including all its minor and minor revisions.
   *
   * <p>- This operation can only be performed on Frameworks with type `CUSTOM`. Built-in Frameworks
   * cannot be deleted. - The Framework cannot be deleted if it is currently deployed on any
   * resource. - This action is permanent and cannot be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteFrameworkRequest request =
   *       DeleteFrameworkRequest.newBuilder()
   *           .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
   *           .build();
   *   ApiFuture<Empty> future = configClient.deleteFrameworkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFrameworkRequest, Empty> deleteFrameworkCallable() {
    return stub.deleteFrameworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CloudControls (both Built-in and Custom) available within a given parent resource.
   * This method supports pagination. The latest major version of each CloudControl is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (CloudControl element : configClient.listCloudControls(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the format
   *     `organizations/{organization}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudControlsPagedResponse listCloudControls(OrganizationLocationName parent) {
    ListCloudControlsRequest request =
        ListCloudControlsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCloudControls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CloudControls (both Built-in and Custom) available within a given parent resource.
   * This method supports pagination. The latest major version of each CloudControl is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (CloudControl element : configClient.listCloudControls(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the format
   *     `organizations/{organization}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudControlsPagedResponse listCloudControls(String parent) {
    ListCloudControlsRequest request =
        ListCloudControlsRequest.newBuilder().setParent(parent).build();
    return listCloudControls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CloudControls (both Built-in and Custom) available within a given parent resource.
   * This method supports pagination. The latest major version of each CloudControl is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListCloudControlsRequest request =
   *       ListCloudControlsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CloudControl element : configClient.listCloudControls(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudControlsPagedResponse listCloudControls(ListCloudControlsRequest request) {
    return listCloudControlsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CloudControls (both Built-in and Custom) available within a given parent resource.
   * This method supports pagination. The latest major version of each CloudControl is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListCloudControlsRequest request =
   *       ListCloudControlsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CloudControl> future =
   *       configClient.listCloudControlsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CloudControl element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCloudControlsRequest, ListCloudControlsPagedResponse>
      listCloudControlsPagedCallable() {
    return stub.listCloudControlsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CloudControls (both Built-in and Custom) available within a given parent resource.
   * This method supports pagination. The latest major version of each CloudControl is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListCloudControlsRequest request =
   *       ListCloudControlsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCloudControlsResponse response = configClient.listCloudControlsCallable().call(request);
   *     for (CloudControl element : response.getCloudControlsList()) {
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
  public final UnaryCallable<ListCloudControlsRequest, ListCloudControlsResponse>
      listCloudControlsCallable() {
    return stub.listCloudControlsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloudControl. This method retrieves a CloudControl resource, which can
   * be either Built-in or Custom, identified by its name.
   *
   * <p>By default, the latest major version of the CloudControl is returned. A specific major
   * version can be retrieved by specifying the `major_revision_id` in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CloudControlName name =
   *       CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");
   *   CloudControl response = configClient.getCloudControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the cloudcontrol to retrieve in the format:
   *     organizations/{organization}/locations/{location}/cloudControls/{cloud_control}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControl getCloudControl(CloudControlName name) {
    GetCloudControlRequest request =
        GetCloudControlRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCloudControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloudControl. This method retrieves a CloudControl resource, which can
   * be either Built-in or Custom, identified by its name.
   *
   * <p>By default, the latest major version of the CloudControl is returned. A specific major
   * version can be retrieved by specifying the `major_revision_id` in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString();
   *   CloudControl response = configClient.getCloudControl(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the cloudcontrol to retrieve in the format:
   *     organizations/{organization}/locations/{location}/cloudControls/{cloud_control}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControl getCloudControl(String name) {
    GetCloudControlRequest request = GetCloudControlRequest.newBuilder().setName(name).build();
    return getCloudControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloudControl. This method retrieves a CloudControl resource, which can
   * be either Built-in or Custom, identified by its name.
   *
   * <p>By default, the latest major version of the CloudControl is returned. A specific major
   * version can be retrieved by specifying the `major_revision_id` in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetCloudControlRequest request =
   *       GetCloudControlRequest.newBuilder()
   *           .setName(
   *               CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
   *           .build();
   *   CloudControl response = configClient.getCloudControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControl getCloudControl(GetCloudControlRequest request) {
    return getCloudControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloudControl. This method retrieves a CloudControl resource, which can
   * be either Built-in or Custom, identified by its name.
   *
   * <p>By default, the latest major version of the CloudControl is returned. A specific major
   * version can be retrieved by specifying the `major_revision_id` in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetCloudControlRequest request =
   *       GetCloudControlRequest.newBuilder()
   *           .setName(
   *               CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
   *           .build();
   *   ApiFuture<CloudControl> future = configClient.getCloudControlCallable().futureCall(request);
   *   // Do something.
   *   CloudControl response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCloudControlRequest, CloudControl> getCloudControlCallable() {
    return stub.getCloudControlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CloudControl with type `Custom` under a given parent resource. `Built-in`
   * CloudControls are managed by Google and cannot be created through this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   CloudControl cloudControl = CloudControl.newBuilder().build();
   *   String cloudControlId = "cloudControlId657324195";
   *   CloudControl response = configClient.createCloudControl(parent, cloudControl, cloudControlId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the format
   *     `organizations/{organization}/locations/{location}`.
   * @param cloudControl Required. The resource being created
   * @param cloudControlId Required. ID of the CloudControl. This is the last segment of the
   *     CloudControl resource name. Format: `^[a-zA-Z][a-zA-Z0-9-]{0,61}[a-zA-Z0-9]$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControl createCloudControl(
      OrganizationLocationName parent, CloudControl cloudControl, String cloudControlId) {
    CreateCloudControlRequest request =
        CreateCloudControlRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCloudControl(cloudControl)
            .setCloudControlId(cloudControlId)
            .build();
    return createCloudControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CloudControl with type `Custom` under a given parent resource. `Built-in`
   * CloudControls are managed by Google and cannot be created through this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   CloudControl cloudControl = CloudControl.newBuilder().build();
   *   String cloudControlId = "cloudControlId657324195";
   *   CloudControl response = configClient.createCloudControl(parent, cloudControl, cloudControlId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the format
   *     `organizations/{organization}/locations/{location}`.
   * @param cloudControl Required. The resource being created
   * @param cloudControlId Required. ID of the CloudControl. This is the last segment of the
   *     CloudControl resource name. Format: `^[a-zA-Z][a-zA-Z0-9-]{0,61}[a-zA-Z0-9]$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControl createCloudControl(
      String parent, CloudControl cloudControl, String cloudControlId) {
    CreateCloudControlRequest request =
        CreateCloudControlRequest.newBuilder()
            .setParent(parent)
            .setCloudControl(cloudControl)
            .setCloudControlId(cloudControlId)
            .build();
    return createCloudControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CloudControl with type `Custom` under a given parent resource. `Built-in`
   * CloudControls are managed by Google and cannot be created through this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateCloudControlRequest request =
   *       CreateCloudControlRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setCloudControlId("cloudControlId657324195")
   *           .setCloudControl(CloudControl.newBuilder().build())
   *           .build();
   *   CloudControl response = configClient.createCloudControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControl createCloudControl(CreateCloudControlRequest request) {
    return createCloudControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CloudControl with type `Custom` under a given parent resource. `Built-in`
   * CloudControls are managed by Google and cannot be created through this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateCloudControlRequest request =
   *       CreateCloudControlRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setCloudControlId("cloudControlId657324195")
   *           .setCloudControl(CloudControl.newBuilder().build())
   *           .build();
   *   ApiFuture<CloudControl> future =
   *       configClient.createCloudControlCallable().futureCall(request);
   *   // Do something.
   *   CloudControl response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCloudControlRequest, CloudControl> createCloudControlCallable() {
    return stub.createCloudControlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single CloudControl. This method allows for partial updates of a Custom CloudControl
   * resource. Built-in CloudControls cannot be updated.
   *
   * <p>- If an `update_mask` is provided, only the fields specified in the mask will be updated. -
   * If no `update_mask` is provided, all fields present in the request's `cloud_control` body will
   * be used to overwrite the existing resource.
   *
   * <p>A successful update will result in a new version of the CloudControl.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CloudControl cloudControl = CloudControl.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CloudControl response = configClient.updateCloudControl(cloudControl, updateMask);
   * }
   * }</pre>
   *
   * @param cloudControl Required. The resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     CloudControl resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields present in the request will be
   *     overwritten. The fields that can be updated are: 1. Display_name 2. Description 3.
   *     Parameters 4. Rules 5. ParameterSpec.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControl updateCloudControl(CloudControl cloudControl, FieldMask updateMask) {
    UpdateCloudControlRequest request =
        UpdateCloudControlRequest.newBuilder()
            .setCloudControl(cloudControl)
            .setUpdateMask(updateMask)
            .build();
    return updateCloudControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single CloudControl. This method allows for partial updates of a Custom CloudControl
   * resource. Built-in CloudControls cannot be updated.
   *
   * <p>- If an `update_mask` is provided, only the fields specified in the mask will be updated. -
   * If no `update_mask` is provided, all fields present in the request's `cloud_control` body will
   * be used to overwrite the existing resource.
   *
   * <p>A successful update will result in a new version of the CloudControl.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateCloudControlRequest request =
   *       UpdateCloudControlRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCloudControl(CloudControl.newBuilder().build())
   *           .build();
   *   CloudControl response = configClient.updateCloudControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudControl updateCloudControl(UpdateCloudControlRequest request) {
    return updateCloudControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single CloudControl. This method allows for partial updates of a Custom CloudControl
   * resource. Built-in CloudControls cannot be updated.
   *
   * <p>- If an `update_mask` is provided, only the fields specified in the mask will be updated. -
   * If no `update_mask` is provided, all fields present in the request's `cloud_control` body will
   * be used to overwrite the existing resource.
   *
   * <p>A successful update will result in a new version of the CloudControl.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateCloudControlRequest request =
   *       UpdateCloudControlRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCloudControl(CloudControl.newBuilder().build())
   *           .build();
   *   ApiFuture<CloudControl> future =
   *       configClient.updateCloudControlCallable().futureCall(request);
   *   // Do something.
   *   CloudControl response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCloudControlRequest, CloudControl> updateCloudControlCallable() {
    return stub.updateCloudControlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Custom CloudControl, including all its major and minor revisions.
   *
   * <p>- This operation can only be performed on CloudControls with type `CUSTOM`. Built-in
   * CloudControls cannot be deleted. - The CloudControl cannot be deleted if any of its revisions
   * are currently referenced by any Framework. - This action is permanent and cannot be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CloudControlName name =
   *       CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");
   *   configClient.deleteCloudControl(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the format
   *     `organizations/{organization}/locations/{location}/CloudControls/{CloudControl}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCloudControl(CloudControlName name) {
    DeleteCloudControlRequest request =
        DeleteCloudControlRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCloudControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Custom CloudControl, including all its major and minor revisions.
   *
   * <p>- This operation can only be performed on CloudControls with type `CUSTOM`. Built-in
   * CloudControls cannot be deleted. - The CloudControl cannot be deleted if any of its revisions
   * are currently referenced by any Framework. - This action is permanent and cannot be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString();
   *   configClient.deleteCloudControl(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the format
   *     `organizations/{organization}/locations/{location}/CloudControls/{CloudControl}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCloudControl(String name) {
    DeleteCloudControlRequest request =
        DeleteCloudControlRequest.newBuilder().setName(name).build();
    deleteCloudControl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Custom CloudControl, including all its major and minor revisions.
   *
   * <p>- This operation can only be performed on CloudControls with type `CUSTOM`. Built-in
   * CloudControls cannot be deleted. - The CloudControl cannot be deleted if any of its revisions
   * are currently referenced by any Framework. - This action is permanent and cannot be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteCloudControlRequest request =
   *       DeleteCloudControlRequest.newBuilder()
   *           .setName(
   *               CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
   *           .build();
   *   configClient.deleteCloudControl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCloudControl(DeleteCloudControlRequest request) {
    deleteCloudControlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Custom CloudControl, including all its major and minor revisions.
   *
   * <p>- This operation can only be performed on CloudControls with type `CUSTOM`. Built-in
   * CloudControls cannot be deleted. - The CloudControl cannot be deleted if any of its revisions
   * are currently referenced by any Framework. - This action is permanent and cannot be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteCloudControlRequest request =
   *       DeleteCloudControlRequest.newBuilder()
   *           .setName(
   *               CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
   *           .build();
   *   ApiFuture<Empty> future = configClient.deleteCloudControlCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCloudControlRequest, Empty> deleteCloudControlCallable() {
    return stub.deleteCloudControlCallable();
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : configClient.listLocations(request).iterateAll()) {
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = configClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = configClient.listLocationsCallable().call(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = configClient.getLocation(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = configClient.getLocationCallable().futureCall(request);
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

  public static class ListFrameworksPagedResponse
      extends AbstractPagedListResponse<
          ListFrameworksRequest,
          ListFrameworksResponse,
          Framework,
          ListFrameworksPage,
          ListFrameworksFixedSizeCollection> {

    public static ApiFuture<ListFrameworksPagedResponse> createAsync(
        PageContext<ListFrameworksRequest, ListFrameworksResponse, Framework> context,
        ApiFuture<ListFrameworksResponse> futureResponse) {
      ApiFuture<ListFrameworksPage> futurePage =
          ListFrameworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFrameworksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFrameworksPagedResponse(ListFrameworksPage page) {
      super(page, ListFrameworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFrameworksPage
      extends AbstractPage<
          ListFrameworksRequest, ListFrameworksResponse, Framework, ListFrameworksPage> {

    private ListFrameworksPage(
        PageContext<ListFrameworksRequest, ListFrameworksResponse, Framework> context,
        ListFrameworksResponse response) {
      super(context, response);
    }

    private static ListFrameworksPage createEmptyPage() {
      return new ListFrameworksPage(null, null);
    }

    @Override
    protected ListFrameworksPage createPage(
        PageContext<ListFrameworksRequest, ListFrameworksResponse, Framework> context,
        ListFrameworksResponse response) {
      return new ListFrameworksPage(context, response);
    }

    @Override
    public ApiFuture<ListFrameworksPage> createPageAsync(
        PageContext<ListFrameworksRequest, ListFrameworksResponse, Framework> context,
        ApiFuture<ListFrameworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFrameworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFrameworksRequest,
          ListFrameworksResponse,
          Framework,
          ListFrameworksPage,
          ListFrameworksFixedSizeCollection> {

    private ListFrameworksFixedSizeCollection(List<ListFrameworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFrameworksFixedSizeCollection createEmptyCollection() {
      return new ListFrameworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFrameworksFixedSizeCollection createCollection(
        List<ListFrameworksPage> pages, int collectionSize) {
      return new ListFrameworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCloudControlsPagedResponse
      extends AbstractPagedListResponse<
          ListCloudControlsRequest,
          ListCloudControlsResponse,
          CloudControl,
          ListCloudControlsPage,
          ListCloudControlsFixedSizeCollection> {

    public static ApiFuture<ListCloudControlsPagedResponse> createAsync(
        PageContext<ListCloudControlsRequest, ListCloudControlsResponse, CloudControl> context,
        ApiFuture<ListCloudControlsResponse> futureResponse) {
      ApiFuture<ListCloudControlsPage> futurePage =
          ListCloudControlsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCloudControlsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCloudControlsPagedResponse(ListCloudControlsPage page) {
      super(page, ListCloudControlsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCloudControlsPage
      extends AbstractPage<
          ListCloudControlsRequest,
          ListCloudControlsResponse,
          CloudControl,
          ListCloudControlsPage> {

    private ListCloudControlsPage(
        PageContext<ListCloudControlsRequest, ListCloudControlsResponse, CloudControl> context,
        ListCloudControlsResponse response) {
      super(context, response);
    }

    private static ListCloudControlsPage createEmptyPage() {
      return new ListCloudControlsPage(null, null);
    }

    @Override
    protected ListCloudControlsPage createPage(
        PageContext<ListCloudControlsRequest, ListCloudControlsResponse, CloudControl> context,
        ListCloudControlsResponse response) {
      return new ListCloudControlsPage(context, response);
    }

    @Override
    public ApiFuture<ListCloudControlsPage> createPageAsync(
        PageContext<ListCloudControlsRequest, ListCloudControlsResponse, CloudControl> context,
        ApiFuture<ListCloudControlsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCloudControlsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCloudControlsRequest,
          ListCloudControlsResponse,
          CloudControl,
          ListCloudControlsPage,
          ListCloudControlsFixedSizeCollection> {

    private ListCloudControlsFixedSizeCollection(
        List<ListCloudControlsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCloudControlsFixedSizeCollection createEmptyCollection() {
      return new ListCloudControlsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCloudControlsFixedSizeCollection createCollection(
        List<ListCloudControlsPage> pages, int collectionSize) {
      return new ListCloudControlsFixedSizeCollection(pages, collectionSize);
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
