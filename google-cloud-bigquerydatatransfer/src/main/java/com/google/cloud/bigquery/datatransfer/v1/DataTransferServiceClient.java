/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.datatransfer.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datatransfer.v1.stub.DataTransferServiceStub;
import com.google.cloud.bigquery.datatransfer.v1.stub.DataTransferServiceStubSettings;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Google BigQuery Data Transfer Service API enables BigQuery users to
 * configure the transfer of their data from other Google Products into BigQuery. This service
 * contains methods that are end user exposed. It backs up the frontend.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
 *   DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");
 *   DataSource response = dataTransferServiceClient.getDataSource(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the dataTransferServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DataTransferServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * DataTransferServiceSettings dataTransferServiceSettings =
 *     DataTransferServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataTransferServiceClient dataTransferServiceClient =
 *     DataTransferServiceClient.create(dataTransferServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DataTransferServiceSettings dataTransferServiceSettings =
 *     DataTransferServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataTransferServiceClient dataTransferServiceClient =
 *     DataTransferServiceClient.create(dataTransferServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DataTransferServiceClient implements BackgroundResource {
  private final DataTransferServiceSettings settings;
  private final DataTransferServiceStub stub;

  /** Constructs an instance of DataTransferServiceClient with default settings. */
  public static final DataTransferServiceClient create() throws IOException {
    return create(DataTransferServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataTransferServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataTransferServiceClient create(DataTransferServiceSettings settings)
      throws IOException {
    return new DataTransferServiceClient(settings);
  }

  /**
   * Constructs an instance of DataTransferServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use DataTransferServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DataTransferServiceClient create(DataTransferServiceStub stub) {
    return new DataTransferServiceClient(stub);
  }

  /**
   * Constructs an instance of DataTransferServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataTransferServiceClient(DataTransferServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataTransferServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DataTransferServiceClient(DataTransferServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataTransferServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DataTransferServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a supported data source and returns its settings, which can be used for UI rendering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");
   *   DataSource response = dataTransferServiceClient.getDataSource(name);
   * }
   * </code></pre>
   *
   * @param name The field will contain name of the resource requested, for example:
   *     `projects/{project_id}/dataSources/{data_source_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource getDataSource(DataSourceName name) {

    GetDataSourceRequest request =
        GetDataSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a supported data source and returns its settings, which can be used for UI rendering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");
   *   GetDataSourceRequest request = GetDataSourceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   DataSource response = dataTransferServiceClient.getDataSource(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final DataSource getDataSource(GetDataSourceRequest request) {
    return getDataSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a supported data source and returns its settings, which can be used for UI rendering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");
   *   GetDataSourceRequest request = GetDataSourceRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;DataSource&gt; future = dataTransferServiceClient.getDataSourceCallable().futureCall(request);
   *   // Do something
   *   DataSource response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return stub.getDataSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists supported data sources and returns their settings, which can be used for UI rendering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   for (DataSource element : dataTransferServiceClient.listDataSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The BigQuery project id for which data sources should be returned. Must be in the
   *     form: `projects/{project_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSourcesPagedResponse listDataSources(ParentName parent) {
    ListDataSourcesRequest request =
        ListDataSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists supported data sources and returns their settings, which can be used for UI rendering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   ListDataSourcesRequest request = ListDataSourcesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (DataSource element : dataTransferServiceClient.listDataSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSourcesPagedResponse listDataSources(ListDataSourcesRequest request) {
    return listDataSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists supported data sources and returns their settings, which can be used for UI rendering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   ListDataSourcesRequest request = ListDataSourcesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListDataSourcesPagedResponse&gt; future = dataTransferServiceClient.listDataSourcesPagedCallable().futureCall(request);
   *   // Do something
   *   for (DataSource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return stub.listDataSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists supported data sources and returns their settings, which can be used for UI rendering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   ListDataSourcesRequest request = ListDataSourcesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListDataSourcesResponse response = dataTransferServiceClient.listDataSourcesCallable().call(request);
   *     for (DataSource element : response.getDataSourcesList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable() {
    return stub.listDataSourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new data transfer configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   TransferConfig transferConfig = TransferConfig.newBuilder().build();
   *   TransferConfig response = dataTransferServiceClient.createTransferConfig(parent, transferConfig);
   * }
   * </code></pre>
   *
   * @param parent The BigQuery project id where the transfer configuration should be created. Must
   *     be in the format /projects/{project_id}/locations/{location_id} If specified location and
   *     location of the destination bigquery dataset do not match - the request will fail.
   * @param transferConfig Data transfer configuration to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferConfig createTransferConfig(
      ParentName parent, TransferConfig transferConfig) {

    CreateTransferConfigRequest request =
        CreateTransferConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTransferConfig(transferConfig)
            .build();
    return createTransferConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new data transfer configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   TransferConfig transferConfig = TransferConfig.newBuilder().build();
   *   CreateTransferConfigRequest request = CreateTransferConfigRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setTransferConfig(transferConfig)
   *     .build();
   *   TransferConfig response = dataTransferServiceClient.createTransferConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferConfig createTransferConfig(CreateTransferConfigRequest request) {
    return createTransferConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new data transfer configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   TransferConfig transferConfig = TransferConfig.newBuilder().build();
   *   CreateTransferConfigRequest request = CreateTransferConfigRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setTransferConfig(transferConfig)
   *     .build();
   *   ApiFuture&lt;TransferConfig&gt; future = dataTransferServiceClient.createTransferConfigCallable().futureCall(request);
   *   // Do something
   *   TransferConfig response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateTransferConfigRequest, TransferConfig>
      createTransferConfigCallable() {
    return stub.createTransferConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a data transfer configuration. All fields must be set, even if they are not updated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfig transferConfig = TransferConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TransferConfig response = dataTransferServiceClient.updateTransferConfig(transferConfig, updateMask);
   * }
   * </code></pre>
   *
   * @param transferConfig Data transfer configuration to create.
   * @param updateMask Required list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferConfig updateTransferConfig(
      TransferConfig transferConfig, FieldMask updateMask) {

    UpdateTransferConfigRequest request =
        UpdateTransferConfigRequest.newBuilder()
            .setTransferConfig(transferConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateTransferConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a data transfer configuration. All fields must be set, even if they are not updated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfig transferConfig = TransferConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateTransferConfigRequest request = UpdateTransferConfigRequest.newBuilder()
   *     .setTransferConfig(transferConfig)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   TransferConfig response = dataTransferServiceClient.updateTransferConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferConfig updateTransferConfig(UpdateTransferConfigRequest request) {
    return updateTransferConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a data transfer configuration. All fields must be set, even if they are not updated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfig transferConfig = TransferConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateTransferConfigRequest request = UpdateTransferConfigRequest.newBuilder()
   *     .setTransferConfig(transferConfig)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;TransferConfig&gt; future = dataTransferServiceClient.updateTransferConfigCallable().futureCall(request);
   *   // Do something
   *   TransferConfig response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateTransferConfigRequest, TransferConfig>
      updateTransferConfigCallable() {
    return stub.updateTransferConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a data transfer configuration, including any associated transfer runs and logs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   dataTransferServiceClient.deleteTransferConfig(name);
   * }
   * </code></pre>
   *
   * @param name The field will contain name of the resource requested, for example:
   *     `projects/{project_id}/transferConfigs/{config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTransferConfig(TransferConfigName name) {

    DeleteTransferConfigRequest request =
        DeleteTransferConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteTransferConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a data transfer configuration, including any associated transfer runs and logs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   DeleteTransferConfigRequest request = DeleteTransferConfigRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   dataTransferServiceClient.deleteTransferConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteTransferConfig(DeleteTransferConfigRequest request) {
    deleteTransferConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a data transfer configuration, including any associated transfer runs and logs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   DeleteTransferConfigRequest request = DeleteTransferConfigRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dataTransferServiceClient.deleteTransferConfigCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTransferConfigRequest, Empty> deleteTransferConfigCallable() {
    return stub.deleteTransferConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a data transfer config.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   TransferConfig response = dataTransferServiceClient.getTransferConfig(name);
   * }
   * </code></pre>
   *
   * @param name The field will contain name of the resource requested, for example:
   *     `projects/{project_id}/transferConfigs/{config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferConfig getTransferConfig(TransferConfigName name) {

    GetTransferConfigRequest request =
        GetTransferConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTransferConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a data transfer config.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   GetTransferConfigRequest request = GetTransferConfigRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   TransferConfig response = dataTransferServiceClient.getTransferConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final TransferConfig getTransferConfig(GetTransferConfigRequest request) {
    return getTransferConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about a data transfer config.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName name = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   GetTransferConfigRequest request = GetTransferConfigRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;TransferConfig&gt; future = dataTransferServiceClient.getTransferConfigCallable().futureCall(request);
   *   // Do something
   *   TransferConfig response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTransferConfigRequest, TransferConfig> getTransferConfigCallable() {
    return stub.getTransferConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about all data transfers in the project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   for (TransferConfig element : dataTransferServiceClient.listTransferConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The BigQuery project id for which data sources should be returned:
   *     `projects/{project_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferConfigsPagedResponse listTransferConfigs(ParentName parent) {
    ListTransferConfigsRequest request =
        ListTransferConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTransferConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about all data transfers in the project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   ListTransferConfigsRequest request = ListTransferConfigsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (TransferConfig element : dataTransferServiceClient.listTransferConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferConfigsPagedResponse listTransferConfigs(
      ListTransferConfigsRequest request) {
    return listTransferConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about all data transfers in the project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   ListTransferConfigsRequest request = ListTransferConfigsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListTransferConfigsPagedResponse&gt; future = dataTransferServiceClient.listTransferConfigsPagedCallable().futureCall(request);
   *   // Do something
   *   for (TransferConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsPagedResponse>
      listTransferConfigsPagedCallable() {
    return stub.listTransferConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about all data transfers in the project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   ParentName parent = ProjectName.of("[PROJECT]");
   *   ListTransferConfigsRequest request = ListTransferConfigsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListTransferConfigsResponse response = dataTransferServiceClient.listTransferConfigsCallable().call(request);
   *     for (TransferConfig element : response.getTransferConfigsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsCallable() {
    return stub.listTransferConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates transfer runs for a time range [start_time, end_time]. For each date - or whatever
   * granularity the data source supports - in the range, one transfer run is created. Note that
   * runs are created per UTC time in the time range.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Timestamp endTime = Timestamp.newBuilder().build();
   *   ScheduleTransferRunsResponse response = dataTransferServiceClient.scheduleTransferRuns(parent, startTime, endTime);
   * }
   * </code></pre>
   *
   * @param parent Transfer configuration name in the form:
   *     `projects/{project_id}/transferConfigs/{config_id}`.
   * @param startTime Start time of the range of transfer runs. For example,
   *     `"2017-05-25T00:00:00+00:00"`.
   * @param endTime End time of the range of transfer runs. For example,
   *     `"2017-05-30T00:00:00+00:00"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduleTransferRunsResponse scheduleTransferRuns(
      TransferConfigName parent, Timestamp startTime, Timestamp endTime) {

    ScheduleTransferRunsRequest request =
        ScheduleTransferRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    return scheduleTransferRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates transfer runs for a time range [start_time, end_time]. For each date - or whatever
   * granularity the data source supports - in the range, one transfer run is created. Note that
   * runs are created per UTC time in the time range.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Timestamp endTime = Timestamp.newBuilder().build();
   *   ScheduleTransferRunsRequest request = ScheduleTransferRunsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setStartTime(startTime)
   *     .setEndTime(endTime)
   *     .build();
   *   ScheduleTransferRunsResponse response = dataTransferServiceClient.scheduleTransferRuns(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduleTransferRunsResponse scheduleTransferRuns(
      ScheduleTransferRunsRequest request) {
    return scheduleTransferRunsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates transfer runs for a time range [start_time, end_time]. For each date - or whatever
   * granularity the data source supports - in the range, one transfer run is created. Note that
   * runs are created per UTC time in the time range.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   Timestamp startTime = Timestamp.newBuilder().build();
   *   Timestamp endTime = Timestamp.newBuilder().build();
   *   ScheduleTransferRunsRequest request = ScheduleTransferRunsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setStartTime(startTime)
   *     .setEndTime(endTime)
   *     .build();
   *   ApiFuture&lt;ScheduleTransferRunsResponse&gt; future = dataTransferServiceClient.scheduleTransferRunsCallable().futureCall(request);
   *   // Do something
   *   ScheduleTransferRunsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsCallable() {
    return stub.scheduleTransferRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the particular transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   TransferRun response = dataTransferServiceClient.getTransferRun(name);
   * }
   * </code></pre>
   *
   * @param name The field will contain name of the resource requested, for example:
   *     `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferRun getTransferRun(RunName name) {

    GetTransferRunRequest request =
        GetTransferRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTransferRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the particular transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   GetTransferRunRequest request = GetTransferRunRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   TransferRun response = dataTransferServiceClient.getTransferRun(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final TransferRun getTransferRun(GetTransferRunRequest request) {
    return getTransferRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about the particular transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   GetTransferRunRequest request = GetTransferRunRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;TransferRun&gt; future = dataTransferServiceClient.getTransferRunCallable().futureCall(request);
   *   // Do something
   *   TransferRun response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTransferRunRequest, TransferRun> getTransferRunCallable() {
    return stub.getTransferRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   dataTransferServiceClient.deleteTransferRun(name);
   * }
   * </code></pre>
   *
   * @param name The field will contain name of the resource requested, for example:
   *     `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTransferRun(RunName name) {

    DeleteTransferRunRequest request =
        DeleteTransferRunRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteTransferRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   DeleteTransferRunRequest request = DeleteTransferRunRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   dataTransferServiceClient.deleteTransferRun(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteTransferRun(DeleteTransferRunRequest request) {
    deleteTransferRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName name = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   DeleteTransferRunRequest request = DeleteTransferRunRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dataTransferServiceClient.deleteTransferRunCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTransferRunRequest, Empty> deleteTransferRunCallable() {
    return stub.deleteTransferRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about running and completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   for (TransferRun element : dataTransferServiceClient.listTransferRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Name of transfer configuration for which transfer runs should be retrieved.
   *     Format of transfer configuration resource name is:
   *     `projects/{project_id}/transferConfigs/{config_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferRunsPagedResponse listTransferRuns(TransferConfigName parent) {
    ListTransferRunsRequest request =
        ListTransferRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTransferRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about running and completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   ListTransferRunsRequest request = ListTransferRunsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (TransferRun element : dataTransferServiceClient.listTransferRuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferRunsPagedResponse listTransferRuns(ListTransferRunsRequest request) {
    return listTransferRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about running and completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   ListTransferRunsRequest request = ListTransferRunsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListTransferRunsPagedResponse&gt; future = dataTransferServiceClient.listTransferRunsPagedCallable().futureCall(request);
   *   // Do something
   *   for (TransferRun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTransferRunsRequest, ListTransferRunsPagedResponse>
      listTransferRunsPagedCallable() {
    return stub.listTransferRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns information about running and completed jobs.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   TransferConfigName parent = ProjectTransferConfigName.of("[PROJECT]", "[TRANSFER_CONFIG]");
   *   ListTransferRunsRequest request = ListTransferRunsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListTransferRunsResponse response = dataTransferServiceClient.listTransferRunsCallable().call(request);
   *     for (TransferRun element : response.getTransferRunsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsCallable() {
    return stub.listTransferRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns user facing log messages for the data transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName parent = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   for (TransferMessage element : dataTransferServiceClient.listTransferLogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Transfer run name in the form:
   *     `projects/{project_id}/transferConfigs/{config_Id}/runs/{run_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferLogsPagedResponse listTransferLogs(RunName parent) {
    ListTransferLogsRequest request =
        ListTransferLogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTransferLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns user facing log messages for the data transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName parent = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   ListTransferLogsRequest request = ListTransferLogsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (TransferMessage element : dataTransferServiceClient.listTransferLogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferLogsPagedResponse listTransferLogs(ListTransferLogsRequest request) {
    return listTransferLogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns user facing log messages for the data transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName parent = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   ListTransferLogsRequest request = ListTransferLogsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListTransferLogsPagedResponse&gt; future = dataTransferServiceClient.listTransferLogsPagedCallable().futureCall(request);
   *   // Do something
   *   for (TransferMessage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTransferLogsRequest, ListTransferLogsPagedResponse>
      listTransferLogsPagedCallable() {
    return stub.listTransferLogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns user facing log messages for the data transfer run.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   RunName parent = ProjectRunName.of("[PROJECT]", "[TRANSFER_CONFIG]", "[RUN]");
   *   ListTransferLogsRequest request = ListTransferLogsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListTransferLogsResponse response = dataTransferServiceClient.listTransferLogsCallable().call(request);
   *     for (TransferMessage element : response.getTransferMessagesList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsCallable() {
    return stub.listTransferLogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns true if valid credentials exist for the given data source and requesting user. Some
   * data sources doesn't support service account, so we need to talk to them on behalf of the end
   * user. This API just checks whether we have OAuth token for the particular user, which is a
   * pre-requisite before user can create a transfer config.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");
   *   CheckValidCredsResponse response = dataTransferServiceClient.checkValidCreds(name);
   * }
   * </code></pre>
   *
   * @param name The data source in the form: `projects/{project_id}/dataSources/{data_source_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckValidCredsResponse checkValidCreds(DataSourceName name) {

    CheckValidCredsRequest request =
        CheckValidCredsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return checkValidCreds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns true if valid credentials exist for the given data source and requesting user. Some
   * data sources doesn't support service account, so we need to talk to them on behalf of the end
   * user. This API just checks whether we have OAuth token for the particular user, which is a
   * pre-requisite before user can create a transfer config.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");
   *   CheckValidCredsRequest request = CheckValidCredsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   CheckValidCredsResponse response = dataTransferServiceClient.checkValidCreds(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final CheckValidCredsResponse checkValidCreds(CheckValidCredsRequest request) {
    return checkValidCredsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns true if valid credentials exist for the given data source and requesting user. Some
   * data sources doesn't support service account, so we need to talk to them on behalf of the end
   * user. This API just checks whether we have OAuth token for the particular user, which is a
   * pre-requisite before user can create a transfer config.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
   *   DataSourceName name = ProjectDataSourceName.of("[PROJECT]", "[DATA_SOURCE]");
   *   CheckValidCredsRequest request = CheckValidCredsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;CheckValidCredsResponse&gt; future = dataTransferServiceClient.checkValidCredsCallable().futureCall(request);
   *   // Do something
   *   CheckValidCredsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CheckValidCredsRequest, CheckValidCredsResponse>
      checkValidCredsCallable() {
    return stub.checkValidCredsCallable();
  }

  @Override
  public final void close() throws Exception {
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

  public static class ListDataSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource, ListDataSourcesPage,
          ListDataSourcesFixedSizeCollection> {

    public static ApiFuture<ListDataSourcesPagedResponse> createAsync(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ApiFuture<ListDataSourcesResponse> futureResponse) {
      ApiFuture<ListDataSourcesPage> futurePage =
          ListDataSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDataSourcesPage, ListDataSourcesPagedResponse>() {
            @Override
            public ListDataSourcesPagedResponse apply(ListDataSourcesPage input) {
              return new ListDataSourcesPagedResponse(input);
            }
          });
    }

    private ListDataSourcesPagedResponse(ListDataSourcesPage page) {
      super(page, ListDataSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataSourcesPage
      extends AbstractPage<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource, ListDataSourcesPage> {

    private ListDataSourcesPage(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ListDataSourcesResponse response) {
      super(context, response);
    }

    private static ListDataSourcesPage createEmptyPage() {
      return new ListDataSourcesPage(null, null);
    }

    @Override
    protected ListDataSourcesPage createPage(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ListDataSourcesResponse response) {
      return new ListDataSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataSourcesPage> createPageAsync(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ApiFuture<ListDataSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource, ListDataSourcesPage,
          ListDataSourcesFixedSizeCollection> {

    private ListDataSourcesFixedSizeCollection(
        List<ListDataSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataSourcesFixedSizeCollection createEmptyCollection() {
      return new ListDataSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataSourcesFixedSizeCollection createCollection(
        List<ListDataSourcesPage> pages, int collectionSize) {
      return new ListDataSourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransferConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig,
          ListTransferConfigsPage, ListTransferConfigsFixedSizeCollection> {

    public static ApiFuture<ListTransferConfigsPagedResponse> createAsync(
        PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
            context,
        ApiFuture<ListTransferConfigsResponse> futureResponse) {
      ApiFuture<ListTransferConfigsPage> futurePage =
          ListTransferConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTransferConfigsPage, ListTransferConfigsPagedResponse>() {
            @Override
            public ListTransferConfigsPagedResponse apply(ListTransferConfigsPage input) {
              return new ListTransferConfigsPagedResponse(input);
            }
          });
    }

    private ListTransferConfigsPagedResponse(ListTransferConfigsPage page) {
      super(page, ListTransferConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferConfigsPage
      extends AbstractPage<
          ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig,
          ListTransferConfigsPage> {

    private ListTransferConfigsPage(
        PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
            context,
        ListTransferConfigsResponse response) {
      super(context, response);
    }

    private static ListTransferConfigsPage createEmptyPage() {
      return new ListTransferConfigsPage(null, null);
    }

    @Override
    protected ListTransferConfigsPage createPage(
        PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
            context,
        ListTransferConfigsResponse response) {
      return new ListTransferConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferConfigsPage> createPageAsync(
        PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
            context,
        ApiFuture<ListTransferConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig,
          ListTransferConfigsPage, ListTransferConfigsFixedSizeCollection> {

    private ListTransferConfigsFixedSizeCollection(
        List<ListTransferConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferConfigsFixedSizeCollection createEmptyCollection() {
      return new ListTransferConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferConfigsFixedSizeCollection createCollection(
        List<ListTransferConfigsPage> pages, int collectionSize) {
      return new ListTransferConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransferRunsPagedResponse
      extends AbstractPagedListResponse<
          ListTransferRunsRequest, ListTransferRunsResponse, TransferRun, ListTransferRunsPage,
          ListTransferRunsFixedSizeCollection> {

    public static ApiFuture<ListTransferRunsPagedResponse> createAsync(
        PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun> context,
        ApiFuture<ListTransferRunsResponse> futureResponse) {
      ApiFuture<ListTransferRunsPage> futurePage =
          ListTransferRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTransferRunsPage, ListTransferRunsPagedResponse>() {
            @Override
            public ListTransferRunsPagedResponse apply(ListTransferRunsPage input) {
              return new ListTransferRunsPagedResponse(input);
            }
          });
    }

    private ListTransferRunsPagedResponse(ListTransferRunsPage page) {
      super(page, ListTransferRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferRunsPage
      extends AbstractPage<
          ListTransferRunsRequest, ListTransferRunsResponse, TransferRun, ListTransferRunsPage> {

    private ListTransferRunsPage(
        PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun> context,
        ListTransferRunsResponse response) {
      super(context, response);
    }

    private static ListTransferRunsPage createEmptyPage() {
      return new ListTransferRunsPage(null, null);
    }

    @Override
    protected ListTransferRunsPage createPage(
        PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun> context,
        ListTransferRunsResponse response) {
      return new ListTransferRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferRunsPage> createPageAsync(
        PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun> context,
        ApiFuture<ListTransferRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransferRunsRequest, ListTransferRunsResponse, TransferRun, ListTransferRunsPage,
          ListTransferRunsFixedSizeCollection> {

    private ListTransferRunsFixedSizeCollection(
        List<ListTransferRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferRunsFixedSizeCollection createEmptyCollection() {
      return new ListTransferRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferRunsFixedSizeCollection createCollection(
        List<ListTransferRunsPage> pages, int collectionSize) {
      return new ListTransferRunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransferLogsPagedResponse
      extends AbstractPagedListResponse<
          ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage, ListTransferLogsPage,
          ListTransferLogsFixedSizeCollection> {

    public static ApiFuture<ListTransferLogsPagedResponse> createAsync(
        PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage> context,
        ApiFuture<ListTransferLogsResponse> futureResponse) {
      ApiFuture<ListTransferLogsPage> futurePage =
          ListTransferLogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTransferLogsPage, ListTransferLogsPagedResponse>() {
            @Override
            public ListTransferLogsPagedResponse apply(ListTransferLogsPage input) {
              return new ListTransferLogsPagedResponse(input);
            }
          });
    }

    private ListTransferLogsPagedResponse(ListTransferLogsPage page) {
      super(page, ListTransferLogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferLogsPage
      extends AbstractPage<
          ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage,
          ListTransferLogsPage> {

    private ListTransferLogsPage(
        PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage> context,
        ListTransferLogsResponse response) {
      super(context, response);
    }

    private static ListTransferLogsPage createEmptyPage() {
      return new ListTransferLogsPage(null, null);
    }

    @Override
    protected ListTransferLogsPage createPage(
        PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage> context,
        ListTransferLogsResponse response) {
      return new ListTransferLogsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferLogsPage> createPageAsync(
        PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage> context,
        ApiFuture<ListTransferLogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferLogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage, ListTransferLogsPage,
          ListTransferLogsFixedSizeCollection> {

    private ListTransferLogsFixedSizeCollection(
        List<ListTransferLogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferLogsFixedSizeCollection createEmptyCollection() {
      return new ListTransferLogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferLogsFixedSizeCollection createCollection(
        List<ListTransferLogsPage> pages, int collectionSize) {
      return new ListTransferLogsFixedSizeCollection(pages, collectionSize);
    }
  }
}
