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

package com.google.cloud.vectorsearch.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.stub.DataObjectServiceStub;
import com.google.cloud.vectorsearch.v1beta.stub.DataObjectServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for creating and managing data objects.
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
 * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
 *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
 *   DataObject dataObject = DataObject.newBuilder().build();
 *   String dataObjectId = "dataObjectId1417732740";
 *   DataObject response =
 *       dataObjectServiceClient.createDataObject(parent, dataObject, dataObjectId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataObjectServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataObject</td>
 *      <td><p> Creates a dataObject.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataObject(CreateDataObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataObject(CollectionName parent, DataObject dataObject, String dataObjectId)
 *           <li><p> createDataObject(String parent, DataObject dataObject, String dataObjectId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateDataObjects</td>
 *      <td><p> Creates a batch of dataObjects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateDataObjects(BatchCreateDataObjectsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateDataObjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataObject</td>
 *      <td><p> Gets a data object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataObject(GetDataObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataObject(DataObjectName name)
 *           <li><p> getDataObject(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataObject</td>
 *      <td><p> Updates a dataObject.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataObject(UpdateDataObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataObject(DataObject dataObject, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateDataObjects</td>
 *      <td><p> Updates dataObjects in a batch.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateDataObjects(CollectionName parent, List&lt;UpdateDataObjectRequest&gt; requests)
 *           <li><p> batchUpdateDataObjects(String parent, List&lt;UpdateDataObjectRequest&gt; requests)
 *           <li><p> batchUpdateDataObjects(BatchUpdateDataObjectsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateDataObjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataObject</td>
 *      <td><p> Deletes a dataObject.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataObject(DeleteDataObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataObject(DataObjectName name)
 *           <li><p> deleteDataObject(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteDataObjects</td>
 *      <td><p> Deletes dataObjects in a batch.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteDataObjects(CollectionName parent, List&lt;DeleteDataObjectRequest&gt; requests)
 *           <li><p> batchDeleteDataObjects(String parent, List&lt;DeleteDataObjectRequest&gt; requests)
 *           <li><p> batchDeleteDataObjects(BatchDeleteDataObjectsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteDataObjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.This method can be called in two ways:
 * <p> &#42;   &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;   &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or other locations specifically visibleto the project.</td>
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
 * <p>This class can be customized by passing in a custom instance of DataObjectServiceSettings to
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
 * DataObjectServiceSettings dataObjectServiceSettings =
 *     DataObjectServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataObjectServiceClient dataObjectServiceClient =
 *     DataObjectServiceClient.create(dataObjectServiceSettings);
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
 * DataObjectServiceSettings dataObjectServiceSettings =
 *     DataObjectServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataObjectServiceClient dataObjectServiceClient =
 *     DataObjectServiceClient.create(dataObjectServiceSettings);
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
 * DataObjectServiceSettings dataObjectServiceSettings =
 *     DataObjectServiceSettings.newHttpJsonBuilder().build();
 * DataObjectServiceClient dataObjectServiceClient =
 *     DataObjectServiceClient.create(dataObjectServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataObjectServiceClient implements BackgroundResource {
  private final DataObjectServiceSettings settings;
  private final DataObjectServiceStub stub;

  /** Constructs an instance of DataObjectServiceClient with default settings. */
  public static final DataObjectServiceClient create() throws IOException {
    return create(DataObjectServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataObjectServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataObjectServiceClient create(DataObjectServiceSettings settings)
      throws IOException {
    return new DataObjectServiceClient(settings);
  }

  /**
   * Constructs an instance of DataObjectServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataObjectServiceSettings).
   */
  public static final DataObjectServiceClient create(DataObjectServiceStub stub) {
    return new DataObjectServiceClient(stub);
  }

  /**
   * Constructs an instance of DataObjectServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataObjectServiceClient(DataObjectServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataObjectServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DataObjectServiceClient(DataObjectServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataObjectServiceSettings getSettings() {
    return settings;
  }

  public DataObjectServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   DataObject dataObject = DataObject.newBuilder().build();
   *   String dataObjectId = "dataObjectId1417732740";
   *   DataObject response =
   *       dataObjectServiceClient.createDataObject(parent, dataObject, dataObjectId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Collection to create the DataObject in.
   *     Format: `projects/{project}/locations/{location}/collections/{collection}`
   * @param dataObject Required. The DataObject to create.
   * @param dataObjectId Required. The id of the dataObject to create. The id must be 1-63
   *     characters long, and comply with [RFC1035](https://www.ietf.org/rfc/rfc1035.txt).
   *     Specifically, it must be 1-63 characters long and match the regular expression
   *     `[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataObject createDataObject(
      CollectionName parent, DataObject dataObject, String dataObjectId) {
    CreateDataObjectRequest request =
        CreateDataObjectRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataObject(dataObject)
            .setDataObjectId(dataObjectId)
            .build();
    return createDataObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   String parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   DataObject dataObject = DataObject.newBuilder().build();
   *   String dataObjectId = "dataObjectId1417732740";
   *   DataObject response =
   *       dataObjectServiceClient.createDataObject(parent, dataObject, dataObjectId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Collection to create the DataObject in.
   *     Format: `projects/{project}/locations/{location}/collections/{collection}`
   * @param dataObject Required. The DataObject to create.
   * @param dataObjectId Required. The id of the dataObject to create. The id must be 1-63
   *     characters long, and comply with [RFC1035](https://www.ietf.org/rfc/rfc1035.txt).
   *     Specifically, it must be 1-63 characters long and match the regular expression
   *     `[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataObject createDataObject(
      String parent, DataObject dataObject, String dataObjectId) {
    CreateDataObjectRequest request =
        CreateDataObjectRequest.newBuilder()
            .setParent(parent)
            .setDataObject(dataObject)
            .setDataObjectId(dataObjectId)
            .build();
    return createDataObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   CreateDataObjectRequest request =
   *       CreateDataObjectRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setDataObjectId("dataObjectId1417732740")
   *           .setDataObject(DataObject.newBuilder().build())
   *           .build();
   *   DataObject response = dataObjectServiceClient.createDataObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataObject createDataObject(CreateDataObjectRequest request) {
    return createDataObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   CreateDataObjectRequest request =
   *       CreateDataObjectRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setDataObjectId("dataObjectId1417732740")
   *           .setDataObject(DataObject.newBuilder().build())
   *           .build();
   *   ApiFuture<DataObject> future =
   *       dataObjectServiceClient.createDataObjectCallable().futureCall(request);
   *   // Do something.
   *   DataObject response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataObjectRequest, DataObject> createDataObjectCallable() {
    return stub.createDataObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a batch of dataObjects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   BatchCreateDataObjectsRequest request =
   *       BatchCreateDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .addAllRequests(new ArrayList<CreateDataObjectRequest>())
   *           .build();
   *   BatchCreateDataObjectsResponse response =
   *       dataObjectServiceClient.batchCreateDataObjects(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateDataObjectsResponse batchCreateDataObjects(
      BatchCreateDataObjectsRequest request) {
    return batchCreateDataObjectsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a batch of dataObjects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   BatchCreateDataObjectsRequest request =
   *       BatchCreateDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .addAllRequests(new ArrayList<CreateDataObjectRequest>())
   *           .build();
   *   ApiFuture<BatchCreateDataObjectsResponse> future =
   *       dataObjectServiceClient.batchCreateDataObjectsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateDataObjectsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsCallable() {
    return stub.batchCreateDataObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   DataObjectName name =
   *       DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]");
   *   DataObject response = dataObjectServiceClient.getDataObject(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataObject resource. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataObjects/{dataObject}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataObject getDataObject(DataObjectName name) {
    GetDataObjectRequest request =
        GetDataObjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   String name =
   *       DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]").toString();
   *   DataObject response = dataObjectServiceClient.getDataObject(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataObject resource. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataObjects/{dataObject}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataObject getDataObject(String name) {
    GetDataObjectRequest request = GetDataObjectRequest.newBuilder().setName(name).build();
    return getDataObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   GetDataObjectRequest request =
   *       GetDataObjectRequest.newBuilder()
   *           .setName(
   *               DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
   *                   .toString())
   *           .build();
   *   DataObject response = dataObjectServiceClient.getDataObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataObject getDataObject(GetDataObjectRequest request) {
    return getDataObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   GetDataObjectRequest request =
   *       GetDataObjectRequest.newBuilder()
   *           .setName(
   *               DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataObject> future =
   *       dataObjectServiceClient.getDataObjectCallable().futureCall(request);
   *   // Do something.
   *   DataObject response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataObjectRequest, DataObject> getDataObjectCallable() {
    return stub.getDataObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   DataObject dataObject = DataObject.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataObject response = dataObjectServiceClient.updateDataObject(dataObject, updateMask);
   * }
   * }</pre>
   *
   * @param dataObject Required. The DataObject which replaces the resource on the server.
   * @param updateMask Optional. The update mask applies to the resource. See
   *     [google.protobuf.FieldMask][google.protobuf.FieldMask].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataObject updateDataObject(DataObject dataObject, FieldMask updateMask) {
    UpdateDataObjectRequest request =
        UpdateDataObjectRequest.newBuilder()
            .setDataObject(dataObject)
            .setUpdateMask(updateMask)
            .build();
    return updateDataObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   UpdateDataObjectRequest request =
   *       UpdateDataObjectRequest.newBuilder()
   *           .setDataObject(DataObject.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataObject response = dataObjectServiceClient.updateDataObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataObject updateDataObject(UpdateDataObjectRequest request) {
    return updateDataObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   UpdateDataObjectRequest request =
   *       UpdateDataObjectRequest.newBuilder()
   *           .setDataObject(DataObject.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataObject> future =
   *       dataObjectServiceClient.updateDataObjectCallable().futureCall(request);
   *   // Do something.
   *   DataObject response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataObjectRequest, DataObject> updateDataObjectCallable() {
    return stub.updateDataObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates dataObjects in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   List<UpdateDataObjectRequest> requests = new ArrayList<>();
   *   BatchUpdateDataObjectsResponse response =
   *       dataObjectServiceClient.batchUpdateDataObjects(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Collection to update the DataObjects in.
   *     Format: `projects/{project}/locations/{location}/collections/{collection}`. The parent
   *     field in the UpdateDataObjectRequest messages must match this field.
   * @param requests Required. The request message specifying the resources to update. A maximum of
   *     1000 DataObjects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDataObjectsResponse batchUpdateDataObjects(
      CollectionName parent, List<UpdateDataObjectRequest> requests) {
    BatchUpdateDataObjectsRequest request =
        BatchUpdateDataObjectsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateDataObjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates dataObjects in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   String parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   List<UpdateDataObjectRequest> requests = new ArrayList<>();
   *   BatchUpdateDataObjectsResponse response =
   *       dataObjectServiceClient.batchUpdateDataObjects(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Collection to update the DataObjects in.
   *     Format: `projects/{project}/locations/{location}/collections/{collection}`. The parent
   *     field in the UpdateDataObjectRequest messages must match this field.
   * @param requests Required. The request message specifying the resources to update. A maximum of
   *     1000 DataObjects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDataObjectsResponse batchUpdateDataObjects(
      String parent, List<UpdateDataObjectRequest> requests) {
    BatchUpdateDataObjectsRequest request =
        BatchUpdateDataObjectsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateDataObjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates dataObjects in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   BatchUpdateDataObjectsRequest request =
   *       BatchUpdateDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .addAllRequests(new ArrayList<UpdateDataObjectRequest>())
   *           .build();
   *   BatchUpdateDataObjectsResponse response =
   *       dataObjectServiceClient.batchUpdateDataObjects(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDataObjectsResponse batchUpdateDataObjects(
      BatchUpdateDataObjectsRequest request) {
    return batchUpdateDataObjectsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates dataObjects in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   BatchUpdateDataObjectsRequest request =
   *       BatchUpdateDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .addAllRequests(new ArrayList<UpdateDataObjectRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateDataObjectsResponse> future =
   *       dataObjectServiceClient.batchUpdateDataObjectsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateDataObjectsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsCallable() {
    return stub.batchUpdateDataObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   DataObjectName name =
   *       DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]");
   *   dataObjectServiceClient.deleteDataObject(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataObject resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataObjects/{dataObject}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataObject(DataObjectName name) {
    DeleteDataObjectRequest request =
        DeleteDataObjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDataObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   String name =
   *       DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]").toString();
   *   dataObjectServiceClient.deleteDataObject(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataObject resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/collections/{collection}/dataObjects/{dataObject}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataObject(String name) {
    DeleteDataObjectRequest request = DeleteDataObjectRequest.newBuilder().setName(name).build();
    deleteDataObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   DeleteDataObjectRequest request =
   *       DeleteDataObjectRequest.newBuilder()
   *           .setName(
   *               DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
   *                   .toString())
   *           .build();
   *   dataObjectServiceClient.deleteDataObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataObject(DeleteDataObjectRequest request) {
    deleteDataObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataObject.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   DeleteDataObjectRequest request =
   *       DeleteDataObjectRequest.newBuilder()
   *           .setName(
   *               DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataObjectServiceClient.deleteDataObjectCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataObjectRequest, Empty> deleteDataObjectCallable() {
    return stub.deleteDataObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes dataObjects in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   List<DeleteDataObjectRequest> requests = new ArrayList<>();
   *   dataObjectServiceClient.batchDeleteDataObjects(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Collection to delete the DataObjects in.
   *     Format: `projects/{project}/locations/{location}/collections/{collection}`.
   * @param requests Required. The request message specifying the resources to delete. A maximum of
   *     1000 DataObjects can be deleted in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteDataObjects(
      CollectionName parent, List<DeleteDataObjectRequest> requests) {
    BatchDeleteDataObjectsRequest request =
        BatchDeleteDataObjectsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    batchDeleteDataObjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes dataObjects in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   String parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   List<DeleteDataObjectRequest> requests = new ArrayList<>();
   *   dataObjectServiceClient.batchDeleteDataObjects(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Collection to delete the DataObjects in.
   *     Format: `projects/{project}/locations/{location}/collections/{collection}`.
   * @param requests Required. The request message specifying the resources to delete. A maximum of
   *     1000 DataObjects can be deleted in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteDataObjects(String parent, List<DeleteDataObjectRequest> requests) {
    BatchDeleteDataObjectsRequest request =
        BatchDeleteDataObjectsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    batchDeleteDataObjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes dataObjects in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   BatchDeleteDataObjectsRequest request =
   *       BatchDeleteDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .addAllRequests(new ArrayList<DeleteDataObjectRequest>())
   *           .build();
   *   dataObjectServiceClient.batchDeleteDataObjects(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteDataObjects(BatchDeleteDataObjectsRequest request) {
    batchDeleteDataObjectsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes dataObjects in a batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   BatchDeleteDataObjectsRequest request =
   *       BatchDeleteDataObjectsRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .addAllRequests(new ArrayList<DeleteDataObjectRequest>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataObjectServiceClient.batchDeleteDataObjectsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteDataObjectsRequest, Empty>
      batchDeleteDataObjectsCallable() {
    return stub.batchDeleteDataObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataObjectServiceClient.listLocations(request).iterateAll()) {
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dataObjectServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dataObjectServiceClient.listLocationsCallable().call(request);
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
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataObjectServiceClient.getLocation(request);
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
   * try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       dataObjectServiceClient.getLocationCallable().futureCall(request);
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
