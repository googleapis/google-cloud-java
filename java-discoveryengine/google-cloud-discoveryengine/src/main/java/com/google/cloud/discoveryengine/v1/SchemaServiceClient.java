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

package com.google.cloud.discoveryengine.v1;

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
import com.google.cloud.discoveryengine.v1.stub.SchemaServiceStub;
import com.google.cloud.discoveryengine.v1.stub.SchemaServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Schema][google.cloud.discoveryengine.v1.Schema]s.
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
 * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
 *   SchemaName name =
 *       SchemaName.ofProjectLocationDataStoreSchemaName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");
 *   Schema response = schemaServiceClient.getSchema(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SchemaServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>GetSchema</td>
 *      <td><p> Gets a [Schema][google.cloud.discoveryengine.v1.Schema].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getSchema(GetSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getSchema(SchemaName name)
 *           <li>getSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListSchemas</td>
 *      <td><p> Gets a list of [Schema][google.cloud.discoveryengine.v1.Schema]s.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listSchemas(ListSchemasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listSchemas(DataStoreName parent)
 *           <li>listSchemas(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listSchemasPagedCallable()
 *           <li>listSchemasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateSchema</td>
 *      <td><p> Creates a [Schema][google.cloud.discoveryengine.v1.Schema].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createSchemaAsync(CreateSchemaRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createSchemaAsync(DataStoreName parent, Schema schema, String schemaId)
 *           <li>createSchemaAsync(String parent, Schema schema, String schemaId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createSchemaOperationCallable()
 *           <li>createSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateSchema</td>
 *      <td><p> Updates a [Schema][google.cloud.discoveryengine.v1.Schema].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateSchemaAsync(UpdateSchemaRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateSchemaOperationCallable()
 *           <li>updateSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteSchema</td>
 *      <td><p> Deletes a [Schema][google.cloud.discoveryengine.v1.Schema].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteSchemaAsync(DeleteSchemaRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteSchemaAsync(SchemaName name)
 *           <li>deleteSchemaAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteSchemaOperationCallable()
 *           <li>deleteSchemaCallable()
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
 * <p>This class can be customized by passing in a custom instance of SchemaServiceSettings to
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
 * SchemaServiceSettings schemaServiceSettings =
 *     SchemaServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SchemaServiceClient schemaServiceClient = SchemaServiceClient.create(schemaServiceSettings);
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
 * SchemaServiceSettings schemaServiceSettings =
 *     SchemaServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SchemaServiceClient schemaServiceClient = SchemaServiceClient.create(schemaServiceSettings);
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
 * SchemaServiceSettings schemaServiceSettings =
 *     SchemaServiceSettings.newHttpJsonBuilder().build();
 * SchemaServiceClient schemaServiceClient = SchemaServiceClient.create(schemaServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SchemaServiceClient implements BackgroundResource {
  private final SchemaServiceSettings settings;
  private final SchemaServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SchemaServiceClient with default settings. */
  public static final SchemaServiceClient create() throws IOException {
    return create(SchemaServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SchemaServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SchemaServiceClient create(SchemaServiceSettings settings)
      throws IOException {
    return new SchemaServiceClient(settings);
  }

  /**
   * Constructs an instance of SchemaServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SchemaServiceSettings).
   */
  public static final SchemaServiceClient create(SchemaServiceStub stub) {
    return new SchemaServiceClient(stub);
  }

  /**
   * Constructs an instance of SchemaServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SchemaServiceClient(SchemaServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SchemaServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SchemaServiceClient(SchemaServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SchemaServiceSettings getSettings() {
    return settings;
  }

  public SchemaServiceStub getStub() {
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
   * Gets a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name =
   *       SchemaName.ofProjectLocationDataStoreSchemaName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");
   *   Schema response = schemaServiceClient.getSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the schema, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(SchemaName name) {
    GetSchemaRequest request =
        GetSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String name =
   *       SchemaName.ofProjectLocationDataStoreSchemaName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
   *           .toString();
   *   Schema response = schemaServiceClient.getSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the schema, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(String name) {
    GetSchemaRequest request = GetSchemaRequest.newBuilder().setName(name).build();
    return getSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   GetSchemaRequest request =
   *       GetSchemaRequest.newBuilder()
   *           .setName(
   *               SchemaName.ofProjectLocationDataStoreSchemaName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
   *                   .toString())
   *           .build();
   *   Schema response = schemaServiceClient.getSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(GetSchemaRequest request) {
    return getSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   GetSchemaRequest request =
   *       GetSchemaRequest.newBuilder()
   *           .setName(
   *               SchemaName.ofProjectLocationDataStoreSchemaName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Schema> future = schemaServiceClient.getSchemaCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    return stub.getSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Schema][google.cloud.discoveryengine.v1.Schema]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   for (Schema element : schemaServiceClient.listSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent data store resource name, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemasPagedResponse listSchemas(DataStoreName parent) {
    ListSchemasRequest request =
        ListSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Schema][google.cloud.discoveryengine.v1.Schema]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   for (Schema element : schemaServiceClient.listSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent data store resource name, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemasPagedResponse listSchemas(String parent) {
    ListSchemasRequest request = ListSchemasRequest.newBuilder().setParent(parent).build();
    return listSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Schema][google.cloud.discoveryengine.v1.Schema]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemasRequest request =
   *       ListSchemasRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Schema element : schemaServiceClient.listSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemasPagedResponse listSchemas(ListSchemasRequest request) {
    return listSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Schema][google.cloud.discoveryengine.v1.Schema]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemasRequest request =
   *       ListSchemasRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Schema> future = schemaServiceClient.listSchemasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Schema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse>
      listSchemasPagedCallable() {
    return stub.listSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Schema][google.cloud.discoveryengine.v1.Schema]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemasRequest request =
   *       ListSchemasRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSchemasResponse response = schemaServiceClient.listSchemasCallable().call(request);
   *     for (Schema element : response.getSchemasList()) {
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
  public final UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable() {
    return stub.listSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   Schema schema = Schema.newBuilder().build();
   *   String schemaId = "schemaId-697673060";
   *   Schema response = schemaServiceClient.createSchemaAsync(parent, schema, schemaId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent data store resource name, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.
   * @param schema Required. The [Schema][google.cloud.discoveryengine.v1.Schema] to create.
   * @param schemaId Required. The ID to use for the
   *     [Schema][google.cloud.discoveryengine.v1.Schema], which will become the final component of
   *     the [Schema.name][google.cloud.discoveryengine.v1.Schema.name].
   *     <p>This field should conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard
   *     with a length limit of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Schema, CreateSchemaMetadata> createSchemaAsync(
      DataStoreName parent, Schema schema, String schemaId) {
    CreateSchemaRequest request =
        CreateSchemaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSchema(schema)
            .setSchemaId(schemaId)
            .build();
    return createSchemaAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   Schema schema = Schema.newBuilder().build();
   *   String schemaId = "schemaId-697673060";
   *   Schema response = schemaServiceClient.createSchemaAsync(parent, schema, schemaId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent data store resource name, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.
   * @param schema Required. The [Schema][google.cloud.discoveryengine.v1.Schema] to create.
   * @param schemaId Required. The ID to use for the
   *     [Schema][google.cloud.discoveryengine.v1.Schema], which will become the final component of
   *     the [Schema.name][google.cloud.discoveryengine.v1.Schema.name].
   *     <p>This field should conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard
   *     with a length limit of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Schema, CreateSchemaMetadata> createSchemaAsync(
      String parent, Schema schema, String schemaId) {
    CreateSchemaRequest request =
        CreateSchemaRequest.newBuilder()
            .setParent(parent)
            .setSchema(schema)
            .setSchemaId(schemaId)
            .build();
    return createSchemaAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   CreateSchemaRequest request =
   *       CreateSchemaRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .setSchemaId("schemaId-697673060")
   *           .build();
   *   Schema response = schemaServiceClient.createSchemaAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Schema, CreateSchemaMetadata> createSchemaAsync(
      CreateSchemaRequest request) {
    return createSchemaOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   CreateSchemaRequest request =
   *       CreateSchemaRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .setSchemaId("schemaId-697673060")
   *           .build();
   *   OperationFuture<Schema, CreateSchemaMetadata> future =
   *       schemaServiceClient.createSchemaOperationCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSchemaRequest, Schema, CreateSchemaMetadata>
      createSchemaOperationCallable() {
    return stub.createSchemaOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   CreateSchemaRequest request =
   *       CreateSchemaRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .setSchemaId("schemaId-697673060")
   *           .build();
   *   ApiFuture<Operation> future = schemaServiceClient.createSchemaCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSchemaRequest, Operation> createSchemaCallable() {
    return stub.createSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   UpdateSchemaRequest request =
   *       UpdateSchemaRequest.newBuilder()
   *           .setSchema(Schema.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Schema response = schemaServiceClient.updateSchemaAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Schema, UpdateSchemaMetadata> updateSchemaAsync(
      UpdateSchemaRequest request) {
    return updateSchemaOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   UpdateSchemaRequest request =
   *       UpdateSchemaRequest.newBuilder()
   *           .setSchema(Schema.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Schema, UpdateSchemaMetadata> future =
   *       schemaServiceClient.updateSchemaOperationCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSchemaRequest, Schema, UpdateSchemaMetadata>
      updateSchemaOperationCallable() {
    return stub.updateSchemaOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   UpdateSchemaRequest request =
   *       UpdateSchemaRequest.newBuilder()
   *           .setSchema(Schema.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future = schemaServiceClient.updateSchemaCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSchemaRequest, Operation> updateSchemaCallable() {
    return stub.updateSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name =
   *       SchemaName.ofProjectLocationDataStoreSchemaName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");
   *   schemaServiceClient.deleteSchemaAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the schema, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSchemaMetadata> deleteSchemaAsync(SchemaName name) {
    DeleteSchemaRequest request =
        DeleteSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSchemaAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String name =
   *       SchemaName.ofProjectLocationDataStoreSchemaName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
   *           .toString();
   *   schemaServiceClient.deleteSchemaAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the schema, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSchemaMetadata> deleteSchemaAsync(String name) {
    DeleteSchemaRequest request = DeleteSchemaRequest.newBuilder().setName(name).build();
    return deleteSchemaAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DeleteSchemaRequest request =
   *       DeleteSchemaRequest.newBuilder()
   *           .setName(
   *               SchemaName.ofProjectLocationDataStoreSchemaName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
   *                   .toString())
   *           .build();
   *   schemaServiceClient.deleteSchemaAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSchemaMetadata> deleteSchemaAsync(
      DeleteSchemaRequest request) {
    return deleteSchemaOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DeleteSchemaRequest request =
   *       DeleteSchemaRequest.newBuilder()
   *           .setName(
   *               SchemaName.ofProjectLocationDataStoreSchemaName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteSchemaMetadata> future =
   *       schemaServiceClient.deleteSchemaOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSchemaRequest, Empty, DeleteSchemaMetadata>
      deleteSchemaOperationCallable() {
    return stub.deleteSchemaOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Schema][google.cloud.discoveryengine.v1.Schema].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DeleteSchemaRequest request =
   *       DeleteSchemaRequest.newBuilder()
   *           .setName(
   *               SchemaName.ofProjectLocationDataStoreSchemaName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = schemaServiceClient.deleteSchemaCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSchemaRequest, Operation> deleteSchemaCallable() {
    return stub.deleteSchemaCallable();
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

  public static class ListSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListSchemasRequest,
          ListSchemasResponse,
          Schema,
          ListSchemasPage,
          ListSchemasFixedSizeCollection> {

    public static ApiFuture<ListSchemasPagedResponse> createAsync(
        PageContext<ListSchemasRequest, ListSchemasResponse, Schema> context,
        ApiFuture<ListSchemasResponse> futureResponse) {
      ApiFuture<ListSchemasPage> futurePage =
          ListSchemasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSchemasPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSchemasPagedResponse(ListSchemasPage page) {
      super(page, ListSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSchemasPage
      extends AbstractPage<ListSchemasRequest, ListSchemasResponse, Schema, ListSchemasPage> {

    private ListSchemasPage(
        PageContext<ListSchemasRequest, ListSchemasResponse, Schema> context,
        ListSchemasResponse response) {
      super(context, response);
    }

    private static ListSchemasPage createEmptyPage() {
      return new ListSchemasPage(null, null);
    }

    @Override
    protected ListSchemasPage createPage(
        PageContext<ListSchemasRequest, ListSchemasResponse, Schema> context,
        ListSchemasResponse response) {
      return new ListSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListSchemasPage> createPageAsync(
        PageContext<ListSchemasRequest, ListSchemasResponse, Schema> context,
        ApiFuture<ListSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSchemasRequest,
          ListSchemasResponse,
          Schema,
          ListSchemasPage,
          ListSchemasFixedSizeCollection> {

    private ListSchemasFixedSizeCollection(List<ListSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSchemasFixedSizeCollection createEmptyCollection() {
      return new ListSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSchemasFixedSizeCollection createCollection(
        List<ListSchemasPage> pages, int collectionSize) {
      return new ListSchemasFixedSizeCollection(pages, collectionSize);
    }
  }
}
