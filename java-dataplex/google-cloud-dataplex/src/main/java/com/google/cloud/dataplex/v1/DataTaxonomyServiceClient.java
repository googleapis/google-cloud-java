/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dataplex.v1;

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
import com.google.cloud.dataplex.v1.stub.DataTaxonomyServiceStub;
import com.google.cloud.dataplex.v1.stub.DataTaxonomyServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: DataTaxonomyService enables attribute-based governance. The resources
 * currently offered include DataTaxonomy and DataAttribute.
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
 * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
 *   DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
 *   DataTaxonomy response = dataTaxonomyServiceClient.getDataTaxonomy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataTaxonomyServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>CreateDataTaxonomy</td>
 *      <td><p> Create a DataTaxonomy resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createDataTaxonomyAsync(CreateDataTaxonomyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createDataTaxonomyAsync(LocationName parent, DataTaxonomy dataTaxonomy, String dataTaxonomyId)
 *           <li>createDataTaxonomyAsync(String parent, DataTaxonomy dataTaxonomy, String dataTaxonomyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createDataTaxonomyOperationCallable()
 *           <li>createDataTaxonomyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateDataTaxonomy</td>
 *      <td><p> Updates a DataTaxonomy resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateDataTaxonomyAsync(UpdateDataTaxonomyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateDataTaxonomyAsync(DataTaxonomy dataTaxonomy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateDataTaxonomyOperationCallable()
 *           <li>updateDataTaxonomyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteDataTaxonomy</td>
 *      <td><p> Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy must be deleted before the DataTaxonomy can be deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteDataTaxonomyAsync(DeleteDataTaxonomyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteDataTaxonomyAsync(DataTaxonomyName name)
 *           <li>deleteDataTaxonomyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteDataTaxonomyOperationCallable()
 *           <li>deleteDataTaxonomyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListDataTaxonomies</td>
 *      <td><p> Lists DataTaxonomy resources in a project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listDataTaxonomies(ListDataTaxonomiesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listDataTaxonomies(LocationName parent)
 *           <li>listDataTaxonomies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listDataTaxonomiesPagedCallable()
 *           <li>listDataTaxonomiesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetDataTaxonomy</td>
 *      <td><p> Retrieves a DataTaxonomy resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getDataTaxonomy(GetDataTaxonomyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getDataTaxonomy(DataTaxonomyName name)
 *           <li>getDataTaxonomy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getDataTaxonomyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateDataAttributeBinding</td>
 *      <td><p> Create a DataAttributeBinding resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createDataAttributeBindingAsync(CreateDataAttributeBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createDataAttributeBindingAsync(LocationName parent, DataAttributeBinding dataAttributeBinding, String dataAttributeBindingId)
 *           <li>createDataAttributeBindingAsync(String parent, DataAttributeBinding dataAttributeBinding, String dataAttributeBindingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createDataAttributeBindingOperationCallable()
 *           <li>createDataAttributeBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateDataAttributeBinding</td>
 *      <td><p> Updates a DataAttributeBinding resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateDataAttributeBindingAsync(UpdateDataAttributeBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateDataAttributeBindingAsync(DataAttributeBinding dataAttributeBinding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateDataAttributeBindingOperationCallable()
 *           <li>updateDataAttributeBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteDataAttributeBinding</td>
 *      <td><p> Deletes a DataAttributeBinding resource. All attributes within the DataAttributeBinding must be deleted before the DataAttributeBinding can be deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteDataAttributeBindingAsync(DeleteDataAttributeBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteDataAttributeBindingAsync(DataAttributeBindingName name)
 *           <li>deleteDataAttributeBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteDataAttributeBindingOperationCallable()
 *           <li>deleteDataAttributeBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListDataAttributeBindings</td>
 *      <td><p> Lists DataAttributeBinding resources in a project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listDataAttributeBindings(ListDataAttributeBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listDataAttributeBindings(LocationName parent)
 *           <li>listDataAttributeBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listDataAttributeBindingsPagedCallable()
 *           <li>listDataAttributeBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetDataAttributeBinding</td>
 *      <td><p> Retrieves a DataAttributeBinding resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getDataAttributeBinding(GetDataAttributeBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getDataAttributeBinding(DataAttributeBindingName name)
 *           <li>getDataAttributeBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getDataAttributeBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateDataAttribute</td>
 *      <td><p> Create a DataAttribute resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createDataAttributeAsync(CreateDataAttributeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createDataAttributeAsync(DataTaxonomyName parent, DataAttribute dataAttribute, String dataAttributeId)
 *           <li>createDataAttributeAsync(String parent, DataAttribute dataAttribute, String dataAttributeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createDataAttributeOperationCallable()
 *           <li>createDataAttributeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateDataAttribute</td>
 *      <td><p> Updates a DataAttribute resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateDataAttributeAsync(UpdateDataAttributeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateDataAttributeAsync(DataAttribute dataAttribute, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateDataAttributeOperationCallable()
 *           <li>updateDataAttributeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteDataAttribute</td>
 *      <td><p> Deletes a Data Attribute resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteDataAttributeAsync(DeleteDataAttributeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteDataAttributeAsync(DataAttributeName name)
 *           <li>deleteDataAttributeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteDataAttributeOperationCallable()
 *           <li>deleteDataAttributeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListDataAttributes</td>
 *      <td><p> Lists Data Attribute resources in a DataTaxonomy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listDataAttributes(ListDataAttributesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listDataAttributes(DataTaxonomyName parent)
 *           <li>listDataAttributes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listDataAttributesPagedCallable()
 *           <li>listDataAttributesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetDataAttribute</td>
 *      <td><p> Retrieves a Data Attribute resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getDataAttribute(GetDataAttributeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getDataAttribute(DataAttributeName name)
 *           <li>getDataAttribute(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getDataAttributeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLocationsPagedCallable()
 *           <li>listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DataTaxonomyServiceSettings to
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
 * DataTaxonomyServiceSettings dataTaxonomyServiceSettings =
 *     DataTaxonomyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataTaxonomyServiceClient dataTaxonomyServiceClient =
 *     DataTaxonomyServiceClient.create(dataTaxonomyServiceSettings);
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
 * DataTaxonomyServiceSettings dataTaxonomyServiceSettings =
 *     DataTaxonomyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataTaxonomyServiceClient dataTaxonomyServiceClient =
 *     DataTaxonomyServiceClient.create(dataTaxonomyServiceSettings);
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
 * DataTaxonomyServiceSettings dataTaxonomyServiceSettings =
 *     DataTaxonomyServiceSettings.newHttpJsonBuilder().build();
 * DataTaxonomyServiceClient dataTaxonomyServiceClient =
 *     DataTaxonomyServiceClient.create(dataTaxonomyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataTaxonomyServiceClient implements BackgroundResource {
  private final DataTaxonomyServiceSettings settings;
  private final DataTaxonomyServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataTaxonomyServiceClient with default settings. */
  public static final DataTaxonomyServiceClient create() throws IOException {
    return create(DataTaxonomyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataTaxonomyServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataTaxonomyServiceClient create(DataTaxonomyServiceSettings settings)
      throws IOException {
    return new DataTaxonomyServiceClient(settings);
  }

  /**
   * Constructs an instance of DataTaxonomyServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DataTaxonomyServiceSettings).
   */
  public static final DataTaxonomyServiceClient create(DataTaxonomyServiceStub stub) {
    return new DataTaxonomyServiceClient(stub);
  }

  /**
   * Constructs an instance of DataTaxonomyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataTaxonomyServiceClient(DataTaxonomyServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataTaxonomyServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataTaxonomyServiceClient(DataTaxonomyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataTaxonomyServiceSettings getSettings() {
    return settings;
  }

  public DataTaxonomyServiceStub getStub() {
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
   * Create a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
   *   String dataTaxonomyId = "dataTaxonomyId987458454";
   *   DataTaxonomy response =
   *       dataTaxonomyServiceClient
   *           .createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the data taxonomy location, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param dataTaxonomy Required. DataTaxonomy resource.
   * @param dataTaxonomyId Required. DataTaxonomy identifier.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the Project.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataTaxonomy, OperationMetadata> createDataTaxonomyAsync(
      LocationName parent, DataTaxonomy dataTaxonomy, String dataTaxonomyId) {
    CreateDataTaxonomyRequest request =
        CreateDataTaxonomyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataTaxonomy(dataTaxonomy)
            .setDataTaxonomyId(dataTaxonomyId)
            .build();
    return createDataTaxonomyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
   *   String dataTaxonomyId = "dataTaxonomyId987458454";
   *   DataTaxonomy response =
   *       dataTaxonomyServiceClient
   *           .createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the data taxonomy location, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param dataTaxonomy Required. DataTaxonomy resource.
   * @param dataTaxonomyId Required. DataTaxonomy identifier.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the Project.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataTaxonomy, OperationMetadata> createDataTaxonomyAsync(
      String parent, DataTaxonomy dataTaxonomy, String dataTaxonomyId) {
    CreateDataTaxonomyRequest request =
        CreateDataTaxonomyRequest.newBuilder()
            .setParent(parent)
            .setDataTaxonomy(dataTaxonomy)
            .setDataTaxonomyId(dataTaxonomyId)
            .build();
    return createDataTaxonomyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataTaxonomyRequest request =
   *       CreateDataTaxonomyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataTaxonomyId("dataTaxonomyId987458454")
   *           .setDataTaxonomy(DataTaxonomy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataTaxonomy response = dataTaxonomyServiceClient.createDataTaxonomyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataTaxonomy, OperationMetadata> createDataTaxonomyAsync(
      CreateDataTaxonomyRequest request) {
    return createDataTaxonomyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataTaxonomyRequest request =
   *       CreateDataTaxonomyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataTaxonomyId("dataTaxonomyId987458454")
   *           .setDataTaxonomy(DataTaxonomy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataTaxonomy, OperationMetadata> future =
   *       dataTaxonomyServiceClient.createDataTaxonomyOperationCallable().futureCall(request);
   *   // Do something.
   *   DataTaxonomy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationCallable() {
    return stub.createDataTaxonomyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataTaxonomyRequest request =
   *       CreateDataTaxonomyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataTaxonomyId("dataTaxonomyId987458454")
   *           .setDataTaxonomy(DataTaxonomy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.createDataTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataTaxonomyRequest, Operation> createDataTaxonomyCallable() {
    return stub.createDataTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataTaxonomy response =
   *       dataTaxonomyServiceClient.updateDataTaxonomyAsync(dataTaxonomy, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataTaxonomy Required. Only fields specified in `update_mask` are updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataTaxonomy, OperationMetadata> updateDataTaxonomyAsync(
      DataTaxonomy dataTaxonomy, FieldMask updateMask) {
    UpdateDataTaxonomyRequest request =
        UpdateDataTaxonomyRequest.newBuilder()
            .setDataTaxonomy(dataTaxonomy)
            .setUpdateMask(updateMask)
            .build();
    return updateDataTaxonomyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataTaxonomyRequest request =
   *       UpdateDataTaxonomyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataTaxonomy(DataTaxonomy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataTaxonomy response = dataTaxonomyServiceClient.updateDataTaxonomyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataTaxonomy, OperationMetadata> updateDataTaxonomyAsync(
      UpdateDataTaxonomyRequest request) {
    return updateDataTaxonomyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataTaxonomyRequest request =
   *       UpdateDataTaxonomyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataTaxonomy(DataTaxonomy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataTaxonomy, OperationMetadata> future =
   *       dataTaxonomyServiceClient.updateDataTaxonomyOperationCallable().futureCall(request);
   *   // Do something.
   *   DataTaxonomy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationCallable() {
    return stub.updateDataTaxonomyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataTaxonomyRequest request =
   *       UpdateDataTaxonomyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataTaxonomy(DataTaxonomy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.updateDataTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomyCallable() {
    return stub.updateDataTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy must be deleted before
   * the DataTaxonomy can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
   *   dataTaxonomyServiceClient.deleteDataTaxonomyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataTaxonomy:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataTaxonomyAsync(
      DataTaxonomyName name) {
    DeleteDataTaxonomyRequest request =
        DeleteDataTaxonomyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDataTaxonomyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy must be deleted before
   * the DataTaxonomy can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString();
   *   dataTaxonomyServiceClient.deleteDataTaxonomyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataTaxonomy:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataTaxonomyAsync(String name) {
    DeleteDataTaxonomyRequest request =
        DeleteDataTaxonomyRequest.newBuilder().setName(name).build();
    return deleteDataTaxonomyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy must be deleted before
   * the DataTaxonomy can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataTaxonomyRequest request =
   *       DeleteDataTaxonomyRequest.newBuilder()
   *           .setName(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   dataTaxonomyServiceClient.deleteDataTaxonomyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataTaxonomyAsync(
      DeleteDataTaxonomyRequest request) {
    return deleteDataTaxonomyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy must be deleted before
   * the DataTaxonomy can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataTaxonomyRequest request =
   *       DeleteDataTaxonomyRequest.newBuilder()
   *           .setName(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataTaxonomyServiceClient.deleteDataTaxonomyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationCallable() {
    return stub.deleteDataTaxonomyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy must be deleted before
   * the DataTaxonomy can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataTaxonomyRequest request =
   *       DeleteDataTaxonomyRequest.newBuilder()
   *           .setName(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.deleteDataTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomyCallable() {
    return stub.deleteDataTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataTaxonomy resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DataTaxonomy element :
   *       dataTaxonomyServiceClient.listDataTaxonomies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the DataTaxonomy location, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTaxonomiesPagedResponse listDataTaxonomies(LocationName parent) {
    ListDataTaxonomiesRequest request =
        ListDataTaxonomiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataTaxonomies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataTaxonomy resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DataTaxonomy element :
   *       dataTaxonomyServiceClient.listDataTaxonomies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the DataTaxonomy location, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTaxonomiesPagedResponse listDataTaxonomies(String parent) {
    ListDataTaxonomiesRequest request =
        ListDataTaxonomiesRequest.newBuilder().setParent(parent).build();
    return listDataTaxonomies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataTaxonomy resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataTaxonomiesRequest request =
   *       ListDataTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataTaxonomy element :
   *       dataTaxonomyServiceClient.listDataTaxonomies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTaxonomiesPagedResponse listDataTaxonomies(
      ListDataTaxonomiesRequest request) {
    return listDataTaxonomiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataTaxonomy resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataTaxonomiesRequest request =
   *       ListDataTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataTaxonomy> future =
   *       dataTaxonomyServiceClient.listDataTaxonomiesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataTaxonomy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesPagedCallable() {
    return stub.listDataTaxonomiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataTaxonomy resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataTaxonomiesRequest request =
   *       ListDataTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDataTaxonomiesResponse response =
   *         dataTaxonomyServiceClient.listDataTaxonomiesCallable().call(request);
   *     for (DataTaxonomy element : response.getDataTaxonomiesList()) {
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
  public final UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
      listDataTaxonomiesCallable() {
    return stub.listDataTaxonomiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
   *   DataTaxonomy response = dataTaxonomyServiceClient.getDataTaxonomy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataTaxonomy:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTaxonomy getDataTaxonomy(DataTaxonomyName name) {
    GetDataTaxonomyRequest request =
        GetDataTaxonomyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString();
   *   DataTaxonomy response = dataTaxonomyServiceClient.getDataTaxonomy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataTaxonomy:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTaxonomy getDataTaxonomy(String name) {
    GetDataTaxonomyRequest request = GetDataTaxonomyRequest.newBuilder().setName(name).build();
    return getDataTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   GetDataTaxonomyRequest request =
   *       GetDataTaxonomyRequest.newBuilder()
   *           .setName(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .build();
   *   DataTaxonomy response = dataTaxonomyServiceClient.getDataTaxonomy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTaxonomy getDataTaxonomy(GetDataTaxonomyRequest request) {
    return getDataTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a DataTaxonomy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   GetDataTaxonomyRequest request =
   *       GetDataTaxonomyRequest.newBuilder()
   *           .setName(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .build();
   *   ApiFuture<DataTaxonomy> future =
   *       dataTaxonomyServiceClient.getDataTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   DataTaxonomy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomyCallable() {
    return stub.getDataTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
   *   String dataAttributeBindingId = "dataAttributeBindingId1952425102";
   *   DataAttributeBinding response =
   *       dataTaxonomyServiceClient
   *           .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent data taxonomy
   *     projects/{project_number}/locations/{location_id}
   * @param dataAttributeBinding Required. DataAttributeBinding resource.
   * @param dataAttributeBindingId Required. DataAttributeBinding identifier.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the Location.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingAsync(
          LocationName parent,
          DataAttributeBinding dataAttributeBinding,
          String dataAttributeBindingId) {
    CreateDataAttributeBindingRequest request =
        CreateDataAttributeBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataAttributeBinding(dataAttributeBinding)
            .setDataAttributeBindingId(dataAttributeBindingId)
            .build();
    return createDataAttributeBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
   *   String dataAttributeBindingId = "dataAttributeBindingId1952425102";
   *   DataAttributeBinding response =
   *       dataTaxonomyServiceClient
   *           .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent data taxonomy
   *     projects/{project_number}/locations/{location_id}
   * @param dataAttributeBinding Required. DataAttributeBinding resource.
   * @param dataAttributeBindingId Required. DataAttributeBinding identifier.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the Location.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingAsync(
          String parent, DataAttributeBinding dataAttributeBinding, String dataAttributeBindingId) {
    CreateDataAttributeBindingRequest request =
        CreateDataAttributeBindingRequest.newBuilder()
            .setParent(parent)
            .setDataAttributeBinding(dataAttributeBinding)
            .setDataAttributeBindingId(dataAttributeBindingId)
            .build();
    return createDataAttributeBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataAttributeBindingRequest request =
   *       CreateDataAttributeBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataAttributeBindingId("dataAttributeBindingId1952425102")
   *           .setDataAttributeBinding(DataAttributeBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataAttributeBinding response =
   *       dataTaxonomyServiceClient.createDataAttributeBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingAsync(CreateDataAttributeBindingRequest request) {
    return createDataAttributeBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataAttributeBindingRequest request =
   *       CreateDataAttributeBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataAttributeBindingId("dataAttributeBindingId1952425102")
   *           .setDataAttributeBinding(DataAttributeBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataAttributeBinding, OperationMetadata> future =
   *       dataTaxonomyServiceClient
   *           .createDataAttributeBindingOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DataAttributeBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationCallable() {
    return stub.createDataAttributeBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataAttributeBindingRequest request =
   *       CreateDataAttributeBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataAttributeBindingId("dataAttributeBindingId1952425102")
   *           .setDataAttributeBinding(DataAttributeBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.createDataAttributeBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingCallable() {
    return stub.createDataAttributeBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataAttributeBinding response =
   *       dataTaxonomyServiceClient
   *           .updateDataAttributeBindingAsync(dataAttributeBinding, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param dataAttributeBinding Required. Only fields specified in `update_mask` are updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingAsync(
          DataAttributeBinding dataAttributeBinding, FieldMask updateMask) {
    UpdateDataAttributeBindingRequest request =
        UpdateDataAttributeBindingRequest.newBuilder()
            .setDataAttributeBinding(dataAttributeBinding)
            .setUpdateMask(updateMask)
            .build();
    return updateDataAttributeBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataAttributeBindingRequest request =
   *       UpdateDataAttributeBindingRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAttributeBinding(DataAttributeBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataAttributeBinding response =
   *       dataTaxonomyServiceClient.updateDataAttributeBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingAsync(UpdateDataAttributeBindingRequest request) {
    return updateDataAttributeBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataAttributeBindingRequest request =
   *       UpdateDataAttributeBindingRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAttributeBinding(DataAttributeBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataAttributeBinding, OperationMetadata> future =
   *       dataTaxonomyServiceClient
   *           .updateDataAttributeBindingOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DataAttributeBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationCallable() {
    return stub.updateDataAttributeBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataAttributeBindingRequest request =
   *       UpdateDataAttributeBindingRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAttributeBinding(DataAttributeBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.updateDataAttributeBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingCallable() {
    return stub.updateDataAttributeBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataAttributeBinding resource. All attributes within the DataAttributeBinding must be
   * deleted before the DataAttributeBinding can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataAttributeBindingName name =
   *       DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");
   *   dataTaxonomyServiceClient.deleteDataAttributeBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataAttributeBinding:
   *     projects/{project_number}/locations/{location_id}/dataAttributeBindings/{data_attribute_binding_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAttributeBindingAsync(
      DataAttributeBindingName name) {
    DeleteDataAttributeBindingRequest request =
        DeleteDataAttributeBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDataAttributeBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataAttributeBinding resource. All attributes within the DataAttributeBinding must be
   * deleted before the DataAttributeBinding can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String name =
   *       DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
   *           .toString();
   *   dataTaxonomyServiceClient.deleteDataAttributeBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataAttributeBinding:
   *     projects/{project_number}/locations/{location_id}/dataAttributeBindings/{data_attribute_binding_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAttributeBindingAsync(
      String name) {
    DeleteDataAttributeBindingRequest request =
        DeleteDataAttributeBindingRequest.newBuilder().setName(name).build();
    return deleteDataAttributeBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataAttributeBinding resource. All attributes within the DataAttributeBinding must be
   * deleted before the DataAttributeBinding can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataAttributeBindingRequest request =
   *       DeleteDataAttributeBindingRequest.newBuilder()
   *           .setName(
   *               DataAttributeBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   dataTaxonomyServiceClient.deleteDataAttributeBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAttributeBindingAsync(
      DeleteDataAttributeBindingRequest request) {
    return deleteDataAttributeBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataAttributeBinding resource. All attributes within the DataAttributeBinding must be
   * deleted before the DataAttributeBinding can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataAttributeBindingRequest request =
   *       DeleteDataAttributeBindingRequest.newBuilder()
   *           .setName(
   *               DataAttributeBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataTaxonomyServiceClient
   *           .deleteDataAttributeBindingOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationCallable() {
    return stub.deleteDataAttributeBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a DataAttributeBinding resource. All attributes within the DataAttributeBinding must be
   * deleted before the DataAttributeBinding can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataAttributeBindingRequest request =
   *       DeleteDataAttributeBindingRequest.newBuilder()
   *           .setName(
   *               DataAttributeBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.deleteDataAttributeBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingCallable() {
    return stub.deleteDataAttributeBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAttributeBinding resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DataAttributeBinding element :
   *       dataTaxonomyServiceClient.listDataAttributeBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location:
   *     projects/{project_number}/locations/{location_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAttributeBindingsPagedResponse listDataAttributeBindings(
      LocationName parent) {
    ListDataAttributeBindingsRequest request =
        ListDataAttributeBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataAttributeBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAttributeBinding resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DataAttributeBinding element :
   *       dataTaxonomyServiceClient.listDataAttributeBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location:
   *     projects/{project_number}/locations/{location_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAttributeBindingsPagedResponse listDataAttributeBindings(String parent) {
    ListDataAttributeBindingsRequest request =
        ListDataAttributeBindingsRequest.newBuilder().setParent(parent).build();
    return listDataAttributeBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAttributeBinding resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataAttributeBindingsRequest request =
   *       ListDataAttributeBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataAttributeBinding element :
   *       dataTaxonomyServiceClient.listDataAttributeBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAttributeBindingsPagedResponse listDataAttributeBindings(
      ListDataAttributeBindingsRequest request) {
    return listDataAttributeBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAttributeBinding resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataAttributeBindingsRequest request =
   *       ListDataAttributeBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataAttributeBinding> future =
   *       dataTaxonomyServiceClient.listDataAttributeBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataAttributeBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDataAttributeBindingsRequest, ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsPagedCallable() {
    return stub.listDataAttributeBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAttributeBinding resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataAttributeBindingsRequest request =
   *       ListDataAttributeBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDataAttributeBindingsResponse response =
   *         dataTaxonomyServiceClient.listDataAttributeBindingsCallable().call(request);
   *     for (DataAttributeBinding element : response.getDataAttributeBindingsList()) {
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
  public final UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
      listDataAttributeBindingsCallable() {
    return stub.listDataAttributeBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataAttributeBindingName name =
   *       DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");
   *   DataAttributeBinding response = dataTaxonomyServiceClient.getDataAttributeBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataAttributeBinding:
   *     projects/{project_number}/locations/{location_id}/dataAttributeBindings/{data_attribute_binding_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAttributeBinding getDataAttributeBinding(DataAttributeBindingName name) {
    GetDataAttributeBindingRequest request =
        GetDataAttributeBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataAttributeBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String name =
   *       DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
   *           .toString();
   *   DataAttributeBinding response = dataTaxonomyServiceClient.getDataAttributeBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataAttributeBinding:
   *     projects/{project_number}/locations/{location_id}/dataAttributeBindings/{data_attribute_binding_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAttributeBinding getDataAttributeBinding(String name) {
    GetDataAttributeBindingRequest request =
        GetDataAttributeBindingRequest.newBuilder().setName(name).build();
    return getDataAttributeBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   GetDataAttributeBindingRequest request =
   *       GetDataAttributeBindingRequest.newBuilder()
   *           .setName(
   *               DataAttributeBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
   *                   .toString())
   *           .build();
   *   DataAttributeBinding response = dataTaxonomyServiceClient.getDataAttributeBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAttributeBinding getDataAttributeBinding(
      GetDataAttributeBindingRequest request) {
    return getDataAttributeBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a DataAttributeBinding resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   GetDataAttributeBindingRequest request =
   *       GetDataAttributeBindingRequest.newBuilder()
   *           .setName(
   *               DataAttributeBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataAttributeBinding> future =
   *       dataTaxonomyServiceClient.getDataAttributeBindingCallable().futureCall(request);
   *   // Do something.
   *   DataAttributeBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingCallable() {
    return stub.getDataAttributeBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataTaxonomyName parent =
   *       DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
   *   DataAttribute dataAttribute = DataAttribute.newBuilder().build();
   *   String dataAttributeId = "dataAttributeId-44128563";
   *   DataAttribute response =
   *       dataTaxonomyServiceClient
   *           .createDataAttributeAsync(parent, dataAttribute, dataAttributeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent data taxonomy
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
   * @param dataAttribute Required. DataAttribute resource.
   * @param dataAttributeId Required. DataAttribute identifier.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the DataTaxonomy.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttribute, OperationMetadata> createDataAttributeAsync(
      DataTaxonomyName parent, DataAttribute dataAttribute, String dataAttributeId) {
    CreateDataAttributeRequest request =
        CreateDataAttributeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataAttribute(dataAttribute)
            .setDataAttributeId(dataAttributeId)
            .build();
    return createDataAttributeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String parent =
   *       DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString();
   *   DataAttribute dataAttribute = DataAttribute.newBuilder().build();
   *   String dataAttributeId = "dataAttributeId-44128563";
   *   DataAttribute response =
   *       dataTaxonomyServiceClient
   *           .createDataAttributeAsync(parent, dataAttribute, dataAttributeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent data taxonomy
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
   * @param dataAttribute Required. DataAttribute resource.
   * @param dataAttributeId Required. DataAttribute identifier.
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the DataTaxonomy.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttribute, OperationMetadata> createDataAttributeAsync(
      String parent, DataAttribute dataAttribute, String dataAttributeId) {
    CreateDataAttributeRequest request =
        CreateDataAttributeRequest.newBuilder()
            .setParent(parent)
            .setDataAttribute(dataAttribute)
            .setDataAttributeId(dataAttributeId)
            .build();
    return createDataAttributeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataAttributeRequest request =
   *       CreateDataAttributeRequest.newBuilder()
   *           .setParent(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setDataAttributeId("dataAttributeId-44128563")
   *           .setDataAttribute(DataAttribute.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataAttribute response = dataTaxonomyServiceClient.createDataAttributeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttribute, OperationMetadata> createDataAttributeAsync(
      CreateDataAttributeRequest request) {
    return createDataAttributeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataAttributeRequest request =
   *       CreateDataAttributeRequest.newBuilder()
   *           .setParent(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setDataAttributeId("dataAttributeId-44128563")
   *           .setDataAttribute(DataAttribute.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataAttribute, OperationMetadata> future =
   *       dataTaxonomyServiceClient.createDataAttributeOperationCallable().futureCall(request);
   *   // Do something.
   *   DataAttribute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationCallable() {
    return stub.createDataAttributeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   CreateDataAttributeRequest request =
   *       CreateDataAttributeRequest.newBuilder()
   *           .setParent(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setDataAttributeId("dataAttributeId-44128563")
   *           .setDataAttribute(DataAttribute.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.createDataAttributeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataAttributeRequest, Operation> createDataAttributeCallable() {
    return stub.createDataAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataAttribute dataAttribute = DataAttribute.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataAttribute response =
   *       dataTaxonomyServiceClient.updateDataAttributeAsync(dataAttribute, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataAttribute Required. Only fields specified in `update_mask` are updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttribute, OperationMetadata> updateDataAttributeAsync(
      DataAttribute dataAttribute, FieldMask updateMask) {
    UpdateDataAttributeRequest request =
        UpdateDataAttributeRequest.newBuilder()
            .setDataAttribute(dataAttribute)
            .setUpdateMask(updateMask)
            .build();
    return updateDataAttributeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataAttributeRequest request =
   *       UpdateDataAttributeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAttribute(DataAttribute.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   DataAttribute response = dataTaxonomyServiceClient.updateDataAttributeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAttribute, OperationMetadata> updateDataAttributeAsync(
      UpdateDataAttributeRequest request) {
    return updateDataAttributeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataAttributeRequest request =
   *       UpdateDataAttributeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAttribute(DataAttribute.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<DataAttribute, OperationMetadata> future =
   *       dataTaxonomyServiceClient.updateDataAttributeOperationCallable().futureCall(request);
   *   // Do something.
   *   DataAttribute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationCallable() {
    return stub.updateDataAttributeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DataAttribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   UpdateDataAttributeRequest request =
   *       UpdateDataAttributeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAttribute(DataAttribute.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.updateDataAttributeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataAttributeRequest, Operation> updateDataAttributeCallable() {
    return stub.updateDataAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataAttributeName name =
   *       DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");
   *   dataTaxonomyServiceClient.deleteDataAttributeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataAttribute:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAttributeAsync(
      DataAttributeName name) {
    DeleteDataAttributeRequest request =
        DeleteDataAttributeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDataAttributeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String name =
   *       DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
   *           .toString();
   *   dataTaxonomyServiceClient.deleteDataAttributeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DataAttribute:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAttributeAsync(String name) {
    DeleteDataAttributeRequest request =
        DeleteDataAttributeRequest.newBuilder().setName(name).build();
    return deleteDataAttributeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataAttributeRequest request =
   *       DeleteDataAttributeRequest.newBuilder()
   *           .setName(
   *               DataAttributeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   dataTaxonomyServiceClient.deleteDataAttributeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAttributeAsync(
      DeleteDataAttributeRequest request) {
    return deleteDataAttributeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataAttributeRequest request =
   *       DeleteDataAttributeRequest.newBuilder()
   *           .setName(
   *               DataAttributeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataTaxonomyServiceClient.deleteDataAttributeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationCallable() {
    return stub.deleteDataAttributeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DeleteDataAttributeRequest request =
   *       DeleteDataAttributeRequest.newBuilder()
   *           .setName(
   *               DataAttributeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataTaxonomyServiceClient.deleteDataAttributeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataAttributeRequest, Operation> deleteDataAttributeCallable() {
    return stub.deleteDataAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Attribute resources in a DataTaxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataTaxonomyName parent =
   *       DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
   *   for (DataAttribute element :
   *       dataTaxonomyServiceClient.listDataAttributes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the DataTaxonomy:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAttributesPagedResponse listDataAttributes(DataTaxonomyName parent) {
    ListDataAttributesRequest request =
        ListDataAttributesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataAttributes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Attribute resources in a DataTaxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String parent =
   *       DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString();
   *   for (DataAttribute element :
   *       dataTaxonomyServiceClient.listDataAttributes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the DataTaxonomy:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAttributesPagedResponse listDataAttributes(String parent) {
    ListDataAttributesRequest request =
        ListDataAttributesRequest.newBuilder().setParent(parent).build();
    return listDataAttributes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Attribute resources in a DataTaxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataAttributesRequest request =
   *       ListDataAttributesRequest.newBuilder()
   *           .setParent(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataAttribute element :
   *       dataTaxonomyServiceClient.listDataAttributes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAttributesPagedResponse listDataAttributes(
      ListDataAttributesRequest request) {
    return listDataAttributesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Attribute resources in a DataTaxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataAttributesRequest request =
   *       ListDataAttributesRequest.newBuilder()
   *           .setParent(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataAttribute> future =
   *       dataTaxonomyServiceClient.listDataAttributesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataAttribute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataAttributesRequest, ListDataAttributesPagedResponse>
      listDataAttributesPagedCallable() {
    return stub.listDataAttributesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Attribute resources in a DataTaxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListDataAttributesRequest request =
   *       ListDataAttributesRequest.newBuilder()
   *           .setParent(
   *               DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDataAttributesResponse response =
   *         dataTaxonomyServiceClient.listDataAttributesCallable().call(request);
   *     for (DataAttribute element : response.getDataAttributesList()) {
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
  public final UnaryCallable<ListDataAttributesRequest, ListDataAttributesResponse>
      listDataAttributesCallable() {
    return stub.listDataAttributesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   DataAttributeName name =
   *       DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");
   *   DataAttribute response = dataTaxonomyServiceClient.getDataAttribute(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataAttribute:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAttribute getDataAttribute(DataAttributeName name) {
    GetDataAttributeRequest request =
        GetDataAttributeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   String name =
   *       DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
   *           .toString();
   *   DataAttribute response = dataTaxonomyServiceClient.getDataAttribute(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataAttribute:
   *     projects/{project_number}/locations/{location_id}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAttribute getDataAttribute(String name) {
    GetDataAttributeRequest request = GetDataAttributeRequest.newBuilder().setName(name).build();
    return getDataAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   GetDataAttributeRequest request =
   *       GetDataAttributeRequest.newBuilder()
   *           .setName(
   *               DataAttributeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
   *                   .toString())
   *           .build();
   *   DataAttribute response = dataTaxonomyServiceClient.getDataAttribute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAttribute getDataAttribute(GetDataAttributeRequest request) {
    return getDataAttributeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a Data Attribute resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   GetDataAttributeRequest request =
   *       GetDataAttributeRequest.newBuilder()
   *           .setName(
   *               DataAttributeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataAttribute> future =
   *       dataTaxonomyServiceClient.getDataAttributeCallable().futureCall(request);
   *   // Do something.
   *   DataAttribute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataAttributeRequest, DataAttribute> getDataAttributeCallable() {
    return stub.getDataAttributeCallable();
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
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataTaxonomyServiceClient.listLocations(request).iterateAll()) {
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
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dataTaxonomyServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dataTaxonomyServiceClient.listLocationsCallable().call(request);
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
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataTaxonomyServiceClient.getLocation(request);
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
   * try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       dataTaxonomyServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListDataTaxonomiesPagedResponse
      extends AbstractPagedListResponse<
          ListDataTaxonomiesRequest,
          ListDataTaxonomiesResponse,
          DataTaxonomy,
          ListDataTaxonomiesPage,
          ListDataTaxonomiesFixedSizeCollection> {

    public static ApiFuture<ListDataTaxonomiesPagedResponse> createAsync(
        PageContext<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, DataTaxonomy> context,
        ApiFuture<ListDataTaxonomiesResponse> futureResponse) {
      ApiFuture<ListDataTaxonomiesPage> futurePage =
          ListDataTaxonomiesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataTaxonomiesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataTaxonomiesPagedResponse(ListDataTaxonomiesPage page) {
      super(page, ListDataTaxonomiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataTaxonomiesPage
      extends AbstractPage<
          ListDataTaxonomiesRequest,
          ListDataTaxonomiesResponse,
          DataTaxonomy,
          ListDataTaxonomiesPage> {

    private ListDataTaxonomiesPage(
        PageContext<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, DataTaxonomy> context,
        ListDataTaxonomiesResponse response) {
      super(context, response);
    }

    private static ListDataTaxonomiesPage createEmptyPage() {
      return new ListDataTaxonomiesPage(null, null);
    }

    @Override
    protected ListDataTaxonomiesPage createPage(
        PageContext<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, DataTaxonomy> context,
        ListDataTaxonomiesResponse response) {
      return new ListDataTaxonomiesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataTaxonomiesPage> createPageAsync(
        PageContext<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, DataTaxonomy> context,
        ApiFuture<ListDataTaxonomiesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataTaxonomiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataTaxonomiesRequest,
          ListDataTaxonomiesResponse,
          DataTaxonomy,
          ListDataTaxonomiesPage,
          ListDataTaxonomiesFixedSizeCollection> {

    private ListDataTaxonomiesFixedSizeCollection(
        List<ListDataTaxonomiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataTaxonomiesFixedSizeCollection createEmptyCollection() {
      return new ListDataTaxonomiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataTaxonomiesFixedSizeCollection createCollection(
        List<ListDataTaxonomiesPage> pages, int collectionSize) {
      return new ListDataTaxonomiesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataAttributeBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListDataAttributeBindingsRequest,
          ListDataAttributeBindingsResponse,
          DataAttributeBinding,
          ListDataAttributeBindingsPage,
          ListDataAttributeBindingsFixedSizeCollection> {

    public static ApiFuture<ListDataAttributeBindingsPagedResponse> createAsync(
        PageContext<
                ListDataAttributeBindingsRequest,
                ListDataAttributeBindingsResponse,
                DataAttributeBinding>
            context,
        ApiFuture<ListDataAttributeBindingsResponse> futureResponse) {
      ApiFuture<ListDataAttributeBindingsPage> futurePage =
          ListDataAttributeBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataAttributeBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataAttributeBindingsPagedResponse(ListDataAttributeBindingsPage page) {
      super(page, ListDataAttributeBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataAttributeBindingsPage
      extends AbstractPage<
          ListDataAttributeBindingsRequest,
          ListDataAttributeBindingsResponse,
          DataAttributeBinding,
          ListDataAttributeBindingsPage> {

    private ListDataAttributeBindingsPage(
        PageContext<
                ListDataAttributeBindingsRequest,
                ListDataAttributeBindingsResponse,
                DataAttributeBinding>
            context,
        ListDataAttributeBindingsResponse response) {
      super(context, response);
    }

    private static ListDataAttributeBindingsPage createEmptyPage() {
      return new ListDataAttributeBindingsPage(null, null);
    }

    @Override
    protected ListDataAttributeBindingsPage createPage(
        PageContext<
                ListDataAttributeBindingsRequest,
                ListDataAttributeBindingsResponse,
                DataAttributeBinding>
            context,
        ListDataAttributeBindingsResponse response) {
      return new ListDataAttributeBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataAttributeBindingsPage> createPageAsync(
        PageContext<
                ListDataAttributeBindingsRequest,
                ListDataAttributeBindingsResponse,
                DataAttributeBinding>
            context,
        ApiFuture<ListDataAttributeBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataAttributeBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataAttributeBindingsRequest,
          ListDataAttributeBindingsResponse,
          DataAttributeBinding,
          ListDataAttributeBindingsPage,
          ListDataAttributeBindingsFixedSizeCollection> {

    private ListDataAttributeBindingsFixedSizeCollection(
        List<ListDataAttributeBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataAttributeBindingsFixedSizeCollection createEmptyCollection() {
      return new ListDataAttributeBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataAttributeBindingsFixedSizeCollection createCollection(
        List<ListDataAttributeBindingsPage> pages, int collectionSize) {
      return new ListDataAttributeBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataAttributesPagedResponse
      extends AbstractPagedListResponse<
          ListDataAttributesRequest,
          ListDataAttributesResponse,
          DataAttribute,
          ListDataAttributesPage,
          ListDataAttributesFixedSizeCollection> {

    public static ApiFuture<ListDataAttributesPagedResponse> createAsync(
        PageContext<ListDataAttributesRequest, ListDataAttributesResponse, DataAttribute> context,
        ApiFuture<ListDataAttributesResponse> futureResponse) {
      ApiFuture<ListDataAttributesPage> futurePage =
          ListDataAttributesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataAttributesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataAttributesPagedResponse(ListDataAttributesPage page) {
      super(page, ListDataAttributesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataAttributesPage
      extends AbstractPage<
          ListDataAttributesRequest,
          ListDataAttributesResponse,
          DataAttribute,
          ListDataAttributesPage> {

    private ListDataAttributesPage(
        PageContext<ListDataAttributesRequest, ListDataAttributesResponse, DataAttribute> context,
        ListDataAttributesResponse response) {
      super(context, response);
    }

    private static ListDataAttributesPage createEmptyPage() {
      return new ListDataAttributesPage(null, null);
    }

    @Override
    protected ListDataAttributesPage createPage(
        PageContext<ListDataAttributesRequest, ListDataAttributesResponse, DataAttribute> context,
        ListDataAttributesResponse response) {
      return new ListDataAttributesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataAttributesPage> createPageAsync(
        PageContext<ListDataAttributesRequest, ListDataAttributesResponse, DataAttribute> context,
        ApiFuture<ListDataAttributesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataAttributesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataAttributesRequest,
          ListDataAttributesResponse,
          DataAttribute,
          ListDataAttributesPage,
          ListDataAttributesFixedSizeCollection> {

    private ListDataAttributesFixedSizeCollection(
        List<ListDataAttributesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataAttributesFixedSizeCollection createEmptyCollection() {
      return new ListDataAttributesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataAttributesFixedSizeCollection createCollection(
        List<ListDataAttributesPage> pages, int collectionSize) {
      return new ListDataAttributesFixedSizeCollection(pages, collectionSize);
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
