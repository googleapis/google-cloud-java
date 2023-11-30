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

package com.google.maps.mapsplatformdatasets.v1alpha;

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
import com.google.maps.mapsplatformdatasets.v1alpha.stub.MapsPlatformDatasetsV1AlphaStub;
import com.google.maps.mapsplatformdatasets.v1alpha.stub.MapsPlatformDatasetsV1AlphaStubSettings;
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
 * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
 *     MapsPlatformDatasetsV1AlphaClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Dataset dataset = Dataset.newBuilder().build();
 *   Dataset response = mapsPlatformDatasetsV1AlphaClient.createDataset(parent, dataset);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MapsPlatformDatasetsV1AlphaClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>CreateDataset</td>
 *      <td><p>Create a new dataset for the specified project.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createDataset(CreateDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createDataset(ProjectName parent, Dataset dataset)
 *           <li>createDataset(String parent, Dataset dataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateDatasetMetadata</td>
 *      <td><p>Update the metadata for the dataset. To update the data use: UploadDataset.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateDatasetMetadata(UpdateDatasetMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateDatasetMetadata(Dataset dataset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateDatasetMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetDataset</td>
 *      <td><p>Get the published or latest version of the dataset.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getDataset(GetDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getDataset(DatasetName name)
 *           <li>getDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListDatasetVersions</td>
 *      <td><p>List all the versions of a dataset.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listDatasetVersions(ListDatasetVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listDatasetVersions(DatasetName name)
 *           <li>listDatasetVersions(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listDatasetVersionsPagedCallable()
 *           <li>listDatasetVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListDatasets</td>
 *      <td><p>List all the datasets for the specified project.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listDatasets(ListDatasetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listDatasets(ProjectName parent)
 *           <li>listDatasets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listDatasetsPagedCallable()
 *           <li>listDatasetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteDataset</td>
 *      <td><p>Delete the specified dataset and optionally all its corresponding
 *  versions.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteDataset(DeleteDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>deleteDataset(DatasetName name)
 *           <li>deleteDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteDatasetVersion</td>
 *      <td><p>Delete a specific version of the dataset.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteDatasetVersion(DeleteDatasetVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>deleteDatasetVersion(DatasetName name)
 *           <li>deleteDatasetVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteDatasetVersionCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * MapsPlatformDatasetsV1AlphaSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MapsPlatformDatasetsV1AlphaSettings mapsPlatformDatasetsV1AlphaSettings =
 *     MapsPlatformDatasetsV1AlphaSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
 *     MapsPlatformDatasetsV1AlphaClient.create(mapsPlatformDatasetsV1AlphaSettings);
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
 * MapsPlatformDatasetsV1AlphaSettings mapsPlatformDatasetsV1AlphaSettings =
 *     MapsPlatformDatasetsV1AlphaSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
 *     MapsPlatformDatasetsV1AlphaClient.create(mapsPlatformDatasetsV1AlphaSettings);
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
 * MapsPlatformDatasetsV1AlphaSettings mapsPlatformDatasetsV1AlphaSettings =
 *     MapsPlatformDatasetsV1AlphaSettings.newHttpJsonBuilder().build();
 * MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
 *     MapsPlatformDatasetsV1AlphaClient.create(mapsPlatformDatasetsV1AlphaSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MapsPlatformDatasetsV1AlphaClient implements BackgroundResource {
  private final MapsPlatformDatasetsV1AlphaSettings settings;
  private final MapsPlatformDatasetsV1AlphaStub stub;

  /** Constructs an instance of MapsPlatformDatasetsV1AlphaClient with default settings. */
  public static final MapsPlatformDatasetsV1AlphaClient create() throws IOException {
    return create(MapsPlatformDatasetsV1AlphaSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MapsPlatformDatasetsV1AlphaClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final MapsPlatformDatasetsV1AlphaClient create(
      MapsPlatformDatasetsV1AlphaSettings settings) throws IOException {
    return new MapsPlatformDatasetsV1AlphaClient(settings);
  }

  /**
   * Constructs an instance of MapsPlatformDatasetsV1AlphaClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(MapsPlatformDatasetsV1AlphaSettings).
   */
  public static final MapsPlatformDatasetsV1AlphaClient create(
      MapsPlatformDatasetsV1AlphaStub stub) {
    return new MapsPlatformDatasetsV1AlphaClient(stub);
  }

  /**
   * Constructs an instance of MapsPlatformDatasetsV1AlphaClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MapsPlatformDatasetsV1AlphaClient(MapsPlatformDatasetsV1AlphaSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((MapsPlatformDatasetsV1AlphaStubSettings) settings.getStubSettings()).createStub();
  }

  protected MapsPlatformDatasetsV1AlphaClient(MapsPlatformDatasetsV1AlphaStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MapsPlatformDatasetsV1AlphaSettings getSettings() {
    return settings;
  }

  public MapsPlatformDatasetsV1AlphaStub getStub() {
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = mapsPlatformDatasetsV1AlphaClient.createDataset(parent, dataset);
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that will own the dataset. Format:
   *     projects/{$project_number}
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = mapsPlatformDatasetsV1AlphaClient.createDataset(parent, dataset);
   * }
   * }</pre>
   *
   * @param parent Required. Parent project that will own the dataset. Format:
   *     projects/{$project_number}
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   Dataset response = mapsPlatformDatasetsV1AlphaClient.createDataset(request);
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsV1AlphaClient.createDatasetCallable().futureCall(request);
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
   * Update the metadata for the dataset. To update the data use: UploadDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   Dataset dataset = Dataset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Dataset response =
   *       mapsPlatformDatasetsV1AlphaClient.updateDatasetMetadata(dataset, updateMask);
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
   * Update the metadata for the dataset. To update the data use: UploadDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   UpdateDatasetMetadataRequest request =
   *       UpdateDatasetMetadataRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Dataset response = mapsPlatformDatasetsV1AlphaClient.updateDatasetMetadata(request);
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
   * Update the metadata for the dataset. To update the data use: UploadDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   UpdateDatasetMetadataRequest request =
   *       UpdateDatasetMetadataRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsV1AlphaClient.updateDatasetMetadataCallable().futureCall(request);
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
   * Get the published or latest version of the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
   *   Dataset response = mapsPlatformDatasetsV1AlphaClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name. Can also fetch a specified version
   *     projects/{project}/datasets/{dataset_id}
   *     projects/{project}/datasets/{dataset_id}{@literal @}{version-id}
   *     <p>In order to retrieve a previous version of the dataset, also provide the version ID.
   *     Example: projects/123/datasets/assisted-driving-preferences{@literal @}c7cfa2a8
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the published or latest version of the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[DATASET]").toString();
   *   Dataset response = mapsPlatformDatasetsV1AlphaClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name. Can also fetch a specified version
   *     projects/{project}/datasets/{dataset_id}
   *     projects/{project}/datasets/{dataset_id}{@literal @}{version-id}
   *     <p>In order to retrieve a previous version of the dataset, also provide the version ID.
   *     Example: projects/123/datasets/assisted-driving-preferences{@literal @}c7cfa2a8
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the published or latest version of the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .setPublishedUsage(Usage.forNumber(0))
   *           .build();
   *   Dataset response = mapsPlatformDatasetsV1AlphaClient.getDataset(request);
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
   * Get the published or latest version of the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .setPublishedUsage(Usage.forNumber(0))
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsV1AlphaClient.getDatasetCallable().futureCall(request);
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
   * List all the versions of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
   *   for (Dataset element :
   *       mapsPlatformDatasetsV1AlphaClient.listDatasetVersions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the dataset to list all the versions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetVersionsPagedResponse listDatasetVersions(DatasetName name) {
    ListDatasetVersionsRequest request =
        ListDatasetVersionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listDatasetVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the versions of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[DATASET]").toString();
   *   for (Dataset element :
   *       mapsPlatformDatasetsV1AlphaClient.listDatasetVersions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the dataset to list all the versions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetVersionsPagedResponse listDatasetVersions(String name) {
    ListDatasetVersionsRequest request =
        ListDatasetVersionsRequest.newBuilder().setName(name).build();
    return listDatasetVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the versions of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   ListDatasetVersionsRequest request =
   *       ListDatasetVersionsRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Dataset element :
   *       mapsPlatformDatasetsV1AlphaClient.listDatasetVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetVersionsPagedResponse listDatasetVersions(
      ListDatasetVersionsRequest request) {
    return listDatasetVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the versions of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   ListDatasetVersionsRequest request =
   *       ListDatasetVersionsRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsV1AlphaClient.listDatasetVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Dataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsPagedResponse>
      listDatasetVersionsPagedCallable() {
    return stub.listDatasetVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the versions of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   ListDatasetVersionsRequest request =
   *       ListDatasetVersionsRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDatasetVersionsResponse response =
   *         mapsPlatformDatasetsV1AlphaClient.listDatasetVersionsCallable().call(request);
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
  public final UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsCallable() {
    return stub.listDatasetVersionsCallable();
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Dataset element : mapsPlatformDatasetsV1AlphaClient.listDatasets(parent).iterateAll()) {
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Dataset element : mapsPlatformDatasetsV1AlphaClient.listDatasets(parent).iterateAll()) {
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Dataset element : mapsPlatformDatasetsV1AlphaClient.listDatasets(request).iterateAll()) {
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Dataset> future =
   *       mapsPlatformDatasetsV1AlphaClient.listDatasetsPagedCallable().futureCall(request);
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
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDatasetsResponse response =
   *         mapsPlatformDatasetsV1AlphaClient.listDatasetsCallable().call(request);
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
   * Delete the specified dataset and optionally all its corresponding versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
   *   mapsPlatformDatasetsV1AlphaClient.deleteDataset(name);
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
   * Delete the specified dataset and optionally all its corresponding versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[DATASET]").toString();
   *   mapsPlatformDatasetsV1AlphaClient.deleteDataset(name);
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
   * Delete the specified dataset and optionally all its corresponding versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .setForce(true)
   *           .build();
   *   mapsPlatformDatasetsV1AlphaClient.deleteDataset(request);
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
   * Delete the specified dataset and optionally all its corresponding versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       mapsPlatformDatasetsV1AlphaClient.deleteDatasetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable() {
    return stub.deleteDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a specific version of the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
   *   mapsPlatformDatasetsV1AlphaClient.deleteDatasetVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: projects/${project}/datasets/{dataset_id}{@literal @}{version-id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDatasetVersion(DatasetName name) {
    DeleteDatasetVersionRequest request =
        DeleteDatasetVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDatasetVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a specific version of the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[DATASET]").toString();
   *   mapsPlatformDatasetsV1AlphaClient.deleteDatasetVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Format: projects/${project}/datasets/{dataset_id}{@literal @}{version-id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDatasetVersion(String name) {
    DeleteDatasetVersionRequest request =
        DeleteDatasetVersionRequest.newBuilder().setName(name).build();
    deleteDatasetVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a specific version of the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   DeleteDatasetVersionRequest request =
   *       DeleteDatasetVersionRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .build();
   *   mapsPlatformDatasetsV1AlphaClient.deleteDatasetVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDatasetVersion(DeleteDatasetVersionRequest request) {
    deleteDatasetVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a specific version of the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MapsPlatformDatasetsV1AlphaClient mapsPlatformDatasetsV1AlphaClient =
   *     MapsPlatformDatasetsV1AlphaClient.create()) {
   *   DeleteDatasetVersionRequest request =
   *       DeleteDatasetVersionRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       mapsPlatformDatasetsV1AlphaClient.deleteDatasetVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatasetVersionRequest, Empty> deleteDatasetVersionCallable() {
    return stub.deleteDatasetVersionCallable();
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

  public static class ListDatasetVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListDatasetVersionsRequest,
          ListDatasetVersionsResponse,
          Dataset,
          ListDatasetVersionsPage,
          ListDatasetVersionsFixedSizeCollection> {

    public static ApiFuture<ListDatasetVersionsPagedResponse> createAsync(
        PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, Dataset> context,
        ApiFuture<ListDatasetVersionsResponse> futureResponse) {
      ApiFuture<ListDatasetVersionsPage> futurePage =
          ListDatasetVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatasetVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatasetVersionsPagedResponse(ListDatasetVersionsPage page) {
      super(page, ListDatasetVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatasetVersionsPage
      extends AbstractPage<
          ListDatasetVersionsRequest,
          ListDatasetVersionsResponse,
          Dataset,
          ListDatasetVersionsPage> {

    private ListDatasetVersionsPage(
        PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, Dataset> context,
        ListDatasetVersionsResponse response) {
      super(context, response);
    }

    private static ListDatasetVersionsPage createEmptyPage() {
      return new ListDatasetVersionsPage(null, null);
    }

    @Override
    protected ListDatasetVersionsPage createPage(
        PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, Dataset> context,
        ListDatasetVersionsResponse response) {
      return new ListDatasetVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatasetVersionsPage> createPageAsync(
        PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, Dataset> context,
        ApiFuture<ListDatasetVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatasetVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatasetVersionsRequest,
          ListDatasetVersionsResponse,
          Dataset,
          ListDatasetVersionsPage,
          ListDatasetVersionsFixedSizeCollection> {

    private ListDatasetVersionsFixedSizeCollection(
        List<ListDatasetVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatasetVersionsFixedSizeCollection createEmptyCollection() {
      return new ListDatasetVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatasetVersionsFixedSizeCollection createCollection(
        List<ListDatasetVersionsPage> pages, int collectionSize) {
      return new ListDatasetVersionsFixedSizeCollection(pages, collectionSize);
    }
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
