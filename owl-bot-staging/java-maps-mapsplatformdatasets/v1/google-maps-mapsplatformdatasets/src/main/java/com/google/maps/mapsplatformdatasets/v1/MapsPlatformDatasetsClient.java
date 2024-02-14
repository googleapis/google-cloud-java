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

package com.google.maps.mapsplatformdatasets.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.maps.mapsplatformdatasets.v1.stub.MapsPlatformDatasetsStub;
import com.google.maps.mapsplatformdatasets.v1.stub.MapsPlatformDatasetsStubSettings;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service definition for the Maps Platform Datasets API.
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
 * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
 *     MapsPlatformDatasetsClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Dataset dataset = Dataset.newBuilder().build();
 *   Dataset response = mapsPlatformDatasetsClient.createDataset(parent, dataset);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MapsPlatformDatasetsClient object to clean up
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
 *      <td><p> CreateDataset</td>
 *      <td><p> Create a new dataset for the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataset(CreateDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataset(ProjectName parent, Dataset dataset)
 *           <li><p> createDataset(String parent, Dataset dataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDatasetMetadata</td>
 *      <td><p> Update the metadata for the dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDatasetMetadata(UpdateDatasetMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDatasetMetadata(Dataset dataset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatasetMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataset</td>
 *      <td><p> Get the dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataset(GetDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataset(DatasetName name)
 *           <li><p> getDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatasets</td>
 *      <td><p> List all the datasets for the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatasets(ListDatasetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatasets(ProjectName parent)
 *           <li><p> listDatasets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatasetsPagedCallable()
 *           <li><p> listDatasetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataset</td>
 *      <td><p> Delete the specified dataset .</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataset(DeleteDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataset(DatasetName name)
 *           <li><p> deleteDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDatasetCallable()
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
 * <p>This class can be customized by passing in a custom instance of MapsPlatformDatasetsSettings
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
 * MapsPlatformDatasetsSettings mapsPlatformDatasetsSettings =
 *     MapsPlatformDatasetsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
 *     MapsPlatformDatasetsClient.create(mapsPlatformDatasetsSettings);
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
 * MapsPlatformDatasetsSettings mapsPlatformDatasetsSettings =
 *     MapsPlatformDatasetsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
 *     MapsPlatformDatasetsClient.create(mapsPlatformDatasetsSettings);
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
 * MapsPlatformDatasetsSettings mapsPlatformDatasetsSettings =
 *     MapsPlatformDatasetsSettings.newHttpJsonBuilder().build();
 * MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
 *     MapsPlatformDatasetsClient.create(mapsPlatformDatasetsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MapsPlatformDatasetsClient implements BackgroundResource {
  private final MapsPlatformDatasetsSettings settings;
  private final MapsPlatformDatasetsStub stub;

  /** Constructs an instance of MapsPlatformDatasetsClient with default settings. */
  public static final MapsPlatformDatasetsClient create() throws IOException {
    return create(MapsPlatformDatasetsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MapsPlatformDatasetsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MapsPlatformDatasetsClient create(MapsPlatformDatasetsSettings settings)
      throws IOException {
    return new MapsPlatformDatasetsClient(settings);
  }

  /**
   * Constructs an instance of MapsPlatformDatasetsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(MapsPlatformDatasetsSettings).
   */
  public static final MapsPlatformDatasetsClient create(MapsPlatformDatasetsStub stub) {
    return new MapsPlatformDatasetsClient(stub);
  }

  /**
   * Constructs an instance of MapsPlatformDatasetsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MapsPlatformDatasetsClient(MapsPlatformDatasetsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MapsPlatformDatasetsStubSettings) settings.getStubSettings()).createStub();
  }

  protected MapsPlatformDatasetsClient(MapsPlatformDatasetsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MapsPlatformDatasetsSettings getSettings() {
    return settings;
  }

  public MapsPlatformDatasetsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new dataset for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = mapsPlatformDatasetsClient.createDataset(parent, dataset);
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that will own the dataset. Format: projects/{$project}
   * @param dataset Required. The dataset version to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(ProjectName parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataset(dataset)
            .build();
    return createDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new dataset for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = mapsPlatformDatasetsClient.createDataset(parent, dataset);
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that will own the dataset. Format: projects/{$project}
   * @param dataset Required. The dataset version to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(String parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder().setParent(parent).setDataset(dataset).build();
    return createDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new dataset for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   Dataset response = mapsPlatformDatasetsClient.createDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset createDataset(CreateDatasetRequest request) {
    return createDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new dataset for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsClient.createDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    return stub.createDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the metadata for the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   Dataset dataset = Dataset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Dataset response = mapsPlatformDatasetsClient.updateDatasetMetadata(dataset, updateMask);
   * }
   * }</pre>
   *
   * @param dataset Required. The dataset to update. The dataset's name is used to identify the
   *     dataset to be updated. The name has the format: projects/{project}/datasets/{dataset_id}
   * @param updateMask The list of fields to be updated. Support the value "&#42;" for full
   *     replacement.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset updateDatasetMetadata(Dataset dataset, FieldMask updateMask) {
    UpdateDatasetMetadataRequest request =
        UpdateDatasetMetadataRequest.newBuilder()
            .setDataset(dataset)
            .setUpdateMask(updateMask)
            .build();
    return updateDatasetMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the metadata for the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   UpdateDatasetMetadataRequest request =
   *       UpdateDatasetMetadataRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Dataset response = mapsPlatformDatasetsClient.updateDatasetMetadata(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset updateDatasetMetadata(UpdateDatasetMetadataRequest request) {
    return updateDatasetMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the metadata for the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   UpdateDatasetMetadataRequest request =
   *       UpdateDatasetMetadataRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsClient.updateDatasetMetadataCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatasetMetadataRequest, Dataset>
      updateDatasetMetadataCallable() {
    return stub.updateDatasetMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
   *   Dataset response = mapsPlatformDatasetsClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name. projects/{project}/datasets/{dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[DATASET]").toString();
   *   Dataset response = mapsPlatformDatasetsClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name. projects/{project}/datasets/{dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .build();
   *   Dataset response = mapsPlatformDatasetsClient.getDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(GetDatasetRequest request) {
    return getDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsClient.getDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return stub.getDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the datasets for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Dataset element : mapsPlatformDatasetsClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project to list all the datasets for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ProjectName parent) {
    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the datasets for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Dataset element : mapsPlatformDatasetsClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project to list all the datasets for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(String parent) {
    ListDatasetsRequest request = ListDatasetsRequest.newBuilder().setParent(parent).build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the datasets for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Dataset element : mapsPlatformDatasetsClient.listDatasets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ListDatasetsRequest request) {
    return listDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the datasets for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsClient.listDatasetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Dataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable() {
    return stub.listDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the datasets for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDatasetsResponse response =
   *         mapsPlatformDatasetsClient.listDatasetsCallable().call(request);
   *     for (Dataset element : response.getDatasetsList()) {
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
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return stub.listDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the specified dataset .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
   *   mapsPlatformDatasetsClient.deleteDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: projects/${project}/datasets/{dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataset(DatasetName name) {
    DeleteDatasetRequest request =
        DeleteDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the specified dataset .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[DATASET]").toString();
   *   mapsPlatformDatasetsClient.deleteDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: projects/${project}/datasets/{dataset_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataset(String name) {
    DeleteDatasetRequest request = DeleteDatasetRequest.newBuilder().setName(name).build();
    deleteDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the specified dataset .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .build();
   *   mapsPlatformDatasetsClient.deleteDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataset(DeleteDatasetRequest request) {
    deleteDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the specified dataset .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsClient mapsPlatformDatasetsClient =
   *     MapsPlatformDatasetsClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       mapsPlatformDatasetsClient.deleteDatasetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable() {
    return stub.deleteDatasetCallable();
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

  public static class ListDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    public static ApiFuture<ListDatasetsPagedResponse> createAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      ApiFuture<ListDatasetsPage> futurePage =
          ListDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatasetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatasetsPagedResponse(ListDatasetsPage page) {
      super(page, ListDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatasetsPage
      extends AbstractPage<ListDatasetsRequest, ListDatasetsResponse, Dataset, ListDatasetsPage> {

    private ListDatasetsPage(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ListDatasetsResponse response) {
      super(context, response);
    }

    private static ListDatasetsPage createEmptyPage() {
      return new ListDatasetsPage(null, null);
    }

    @Override
    protected ListDatasetsPage createPage(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ListDatasetsResponse response) {
      return new ListDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatasetsPage> createPageAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    private ListDatasetsFixedSizeCollection(List<ListDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatasetsFixedSizeCollection createCollection(
        List<ListDatasetsPage> pages, int collectionSize) {
      return new ListDatasetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
