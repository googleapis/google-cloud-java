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

package com.google.cloud.biglake.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.biglake.v1.stub.IcebergCatalogServiceStub;
import com.google.cloud.biglake.v1.stub.IcebergCatalogServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Iceberg Catalog Service API: this implements the open-source Iceberg REST
 * Catalog API. See the API definition here:
 * https://github.com/apache/iceberg/blob/main/open-api/rest-catalog-open-api.yaml
 *
 * <p>The API is defined as OpenAPI 3.1.1 spec.
 *
 * <p>Currently we only support the following methods: - GetConfig/GetIcebergCatalogConfig -
 * ListIcebergNamespaces - CheckIcebergNamespaceExists - GetIcebergNamespace -
 * CreateIcebergNamespace (only supports single level) - DeleteIcebergNamespace -
 * UpdateIcebergNamespace properties - ListTableIdentifiers - CreateIcebergTable -
 * DeleteIcebergTable - GetIcebergTable - UpdateIcebergTable (CommitTable) -
 * LoadIcebergTableCredentials - RegisterTable
 *
 * <p>Users are required to provided the `X-Goog-User-Project` header with the project id or number
 * which can be different from the bucket project id. That project will be charged for the API calls
 * and the calling user must have access to that project. The caller must have
 * `serviceusage.services.use` permission on the project.
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
 * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
 *     IcebergCatalogServiceClient.create()) {
 *   CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
 *   IcebergCatalog response = icebergCatalogServiceClient.getIcebergCatalog(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IcebergCatalogServiceClient object to clean up
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
 *      <td><p> GetIcebergCatalog</td>
 *      <td><p> Returns the Iceberg REST Catalog configuration options.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIcebergCatalog(GetIcebergCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIcebergCatalog(CatalogName name)
 *           <li><p> getIcebergCatalog(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIcebergCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIcebergCatalogs</td>
 *      <td><p> Lists the Iceberg REST Catalogs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIcebergCatalogs(ListIcebergCatalogsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIcebergCatalogs(ProjectName parent)
 *           <li><p> listIcebergCatalogs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIcebergCatalogsPagedCallable()
 *           <li><p> listIcebergCatalogsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIcebergCatalog</td>
 *      <td><p> Update the Iceberg REST Catalog configuration options.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIcebergCatalog(UpdateIcebergCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateIcebergCatalog(IcebergCatalog icebergCatalog, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIcebergCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateIcebergCatalog</td>
 *      <td><p> Creates the Iceberg REST Catalog. Currently only supports Google Cloud Storage Bucket catalogs. Google Cloud Storage Bucket catalog id is the bucket for which the catalog is created (e.g. `my-catalog` for `gs://my-catalog`).
 * <p>  If the bucket does not exist, of the caller does not have bucket metadata permissions, the catalog will not be created.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIcebergCatalog(CreateIcebergCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createIcebergCatalog(ProjectName parent, IcebergCatalog icebergCatalog, String icebergCatalogId)
 *           <li><p> createIcebergCatalog(String parent, IcebergCatalog icebergCatalog, String icebergCatalogId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIcebergCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FailoverIcebergCatalog</td>
 *      <td><p> Failover the catalog to a new primary replica region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> failoverIcebergCatalog(FailoverIcebergCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> failoverIcebergCatalog(String name, String primaryReplica)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> failoverIcebergCatalogCallable()
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
 * <p>This class can be customized by passing in a custom instance of IcebergCatalogServiceSettings
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
 * IcebergCatalogServiceSettings icebergCatalogServiceSettings =
 *     IcebergCatalogServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IcebergCatalogServiceClient icebergCatalogServiceClient =
 *     IcebergCatalogServiceClient.create(icebergCatalogServiceSettings);
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
 * IcebergCatalogServiceSettings icebergCatalogServiceSettings =
 *     IcebergCatalogServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IcebergCatalogServiceClient icebergCatalogServiceClient =
 *     IcebergCatalogServiceClient.create(icebergCatalogServiceSettings);
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
 * IcebergCatalogServiceSettings icebergCatalogServiceSettings =
 *     IcebergCatalogServiceSettings.newHttpJsonBuilder().build();
 * IcebergCatalogServiceClient icebergCatalogServiceClient =
 *     IcebergCatalogServiceClient.create(icebergCatalogServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IcebergCatalogServiceClient implements BackgroundResource {
  private final IcebergCatalogServiceSettings settings;
  private final IcebergCatalogServiceStub stub;

  /** Constructs an instance of IcebergCatalogServiceClient with default settings. */
  public static final IcebergCatalogServiceClient create() throws IOException {
    return create(IcebergCatalogServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IcebergCatalogServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IcebergCatalogServiceClient create(IcebergCatalogServiceSettings settings)
      throws IOException {
    return new IcebergCatalogServiceClient(settings);
  }

  /**
   * Constructs an instance of IcebergCatalogServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(IcebergCatalogServiceSettings).
   */
  public static final IcebergCatalogServiceClient create(IcebergCatalogServiceStub stub) {
    return new IcebergCatalogServiceClient(stub);
  }

  /**
   * Constructs an instance of IcebergCatalogServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected IcebergCatalogServiceClient(IcebergCatalogServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IcebergCatalogServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected IcebergCatalogServiceClient(IcebergCatalogServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IcebergCatalogServiceSettings getSettings() {
    return settings;
  }

  public IcebergCatalogServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Iceberg REST Catalog configuration options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
   *   IcebergCatalog response = icebergCatalogServiceClient.getIcebergCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The catalog to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IcebergCatalog getIcebergCatalog(CatalogName name) {
    GetIcebergCatalogRequest request =
        GetIcebergCatalogRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getIcebergCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Iceberg REST Catalog configuration options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   String name = CatalogName.of("[PROJECT]", "[CATALOG]").toString();
   *   IcebergCatalog response = icebergCatalogServiceClient.getIcebergCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The catalog to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IcebergCatalog getIcebergCatalog(String name) {
    GetIcebergCatalogRequest request = GetIcebergCatalogRequest.newBuilder().setName(name).build();
    return getIcebergCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Iceberg REST Catalog configuration options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   GetIcebergCatalogRequest request =
   *       GetIcebergCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .build();
   *   IcebergCatalog response = icebergCatalogServiceClient.getIcebergCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IcebergCatalog getIcebergCatalog(GetIcebergCatalogRequest request) {
    return getIcebergCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Iceberg REST Catalog configuration options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   GetIcebergCatalogRequest request =
   *       GetIcebergCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<IcebergCatalog> future =
   *       icebergCatalogServiceClient.getIcebergCatalogCallable().futureCall(request);
   *   // Do something.
   *   IcebergCatalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIcebergCatalogRequest, IcebergCatalog> getIcebergCatalogCallable() {
    return stub.getIcebergCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Iceberg REST Catalogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (IcebergCatalog element :
   *       icebergCatalogServiceClient.listIcebergCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this catalog will be created. Format:
   *     projects/{project_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIcebergCatalogsPagedResponse listIcebergCatalogs(ProjectName parent) {
    ListIcebergCatalogsRequest request =
        ListIcebergCatalogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIcebergCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Iceberg REST Catalogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (IcebergCatalog element :
   *       icebergCatalogServiceClient.listIcebergCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this catalog will be created. Format:
   *     projects/{project_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIcebergCatalogsPagedResponse listIcebergCatalogs(String parent) {
    ListIcebergCatalogsRequest request =
        ListIcebergCatalogsRequest.newBuilder().setParent(parent).build();
    return listIcebergCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Iceberg REST Catalogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   ListIcebergCatalogsRequest request =
   *       ListIcebergCatalogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (IcebergCatalog element :
   *       icebergCatalogServiceClient.listIcebergCatalogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIcebergCatalogsPagedResponse listIcebergCatalogs(
      ListIcebergCatalogsRequest request) {
    return listIcebergCatalogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Iceberg REST Catalogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   ListIcebergCatalogsRequest request =
   *       ListIcebergCatalogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<IcebergCatalog> future =
   *       icebergCatalogServiceClient.listIcebergCatalogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (IcebergCatalog element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsPagedResponse>
      listIcebergCatalogsPagedCallable() {
    return stub.listIcebergCatalogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Iceberg REST Catalogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   ListIcebergCatalogsRequest request =
   *       ListIcebergCatalogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListIcebergCatalogsResponse response =
   *         icebergCatalogServiceClient.listIcebergCatalogsCallable().call(request);
   *     for (IcebergCatalog element : response.getIcebergCatalogsList()) {
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
  public final UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
      listIcebergCatalogsCallable() {
    return stub.listIcebergCatalogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the Iceberg REST Catalog configuration options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IcebergCatalog response =
   *       icebergCatalogServiceClient.updateIcebergCatalog(icebergCatalog, updateMask);
   * }
   * }</pre>
   *
   * @param icebergCatalog Required. The catalog to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IcebergCatalog updateIcebergCatalog(
      IcebergCatalog icebergCatalog, FieldMask updateMask) {
    UpdateIcebergCatalogRequest request =
        UpdateIcebergCatalogRequest.newBuilder()
            .setIcebergCatalog(icebergCatalog)
            .setUpdateMask(updateMask)
            .build();
    return updateIcebergCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the Iceberg REST Catalog configuration options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   UpdateIcebergCatalogRequest request =
   *       UpdateIcebergCatalogRequest.newBuilder()
   *           .setIcebergCatalog(IcebergCatalog.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   IcebergCatalog response = icebergCatalogServiceClient.updateIcebergCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IcebergCatalog updateIcebergCatalog(UpdateIcebergCatalogRequest request) {
    return updateIcebergCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the Iceberg REST Catalog configuration options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   UpdateIcebergCatalogRequest request =
   *       UpdateIcebergCatalogRequest.newBuilder()
   *           .setIcebergCatalog(IcebergCatalog.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<IcebergCatalog> future =
   *       icebergCatalogServiceClient.updateIcebergCatalogCallable().futureCall(request);
   *   // Do something.
   *   IcebergCatalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIcebergCatalogRequest, IcebergCatalog>
      updateIcebergCatalogCallable() {
    return stub.updateIcebergCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the Iceberg REST Catalog. Currently only supports Google Cloud Storage Bucket catalogs.
   * Google Cloud Storage Bucket catalog id is the bucket for which the catalog is created (e.g.
   * `my-catalog` for `gs://my-catalog`).
   *
   * <p>If the bucket does not exist, of the caller does not have bucket metadata permissions, the
   * catalog will not be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
   *   String icebergCatalogId = "icebergCatalogId504062865";
   *   IcebergCatalog response =
   *       icebergCatalogServiceClient.createIcebergCatalog(
   *           parent, icebergCatalog, icebergCatalogId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this catalog will be created. Format:
   *     projects/{project_id}
   * @param icebergCatalog Required. The catalog to create. The required fields for creation are: -
   *     catalog_type. Optionally: credential_mode can be provided, if Credential Vending is
   *     desired.
   * @param icebergCatalogId Required. The name of the catalog.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IcebergCatalog createIcebergCatalog(
      ProjectName parent, IcebergCatalog icebergCatalog, String icebergCatalogId) {
    CreateIcebergCatalogRequest request =
        CreateIcebergCatalogRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIcebergCatalog(icebergCatalog)
            .setIcebergCatalogId(icebergCatalogId)
            .build();
    return createIcebergCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the Iceberg REST Catalog. Currently only supports Google Cloud Storage Bucket catalogs.
   * Google Cloud Storage Bucket catalog id is the bucket for which the catalog is created (e.g.
   * `my-catalog` for `gs://my-catalog`).
   *
   * <p>If the bucket does not exist, of the caller does not have bucket metadata permissions, the
   * catalog will not be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
   *   String icebergCatalogId = "icebergCatalogId504062865";
   *   IcebergCatalog response =
   *       icebergCatalogServiceClient.createIcebergCatalog(
   *           parent, icebergCatalog, icebergCatalogId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this catalog will be created. Format:
   *     projects/{project_id}
   * @param icebergCatalog Required. The catalog to create. The required fields for creation are: -
   *     catalog_type. Optionally: credential_mode can be provided, if Credential Vending is
   *     desired.
   * @param icebergCatalogId Required. The name of the catalog.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IcebergCatalog createIcebergCatalog(
      String parent, IcebergCatalog icebergCatalog, String icebergCatalogId) {
    CreateIcebergCatalogRequest request =
        CreateIcebergCatalogRequest.newBuilder()
            .setParent(parent)
            .setIcebergCatalog(icebergCatalog)
            .setIcebergCatalogId(icebergCatalogId)
            .build();
    return createIcebergCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the Iceberg REST Catalog. Currently only supports Google Cloud Storage Bucket catalogs.
   * Google Cloud Storage Bucket catalog id is the bucket for which the catalog is created (e.g.
   * `my-catalog` for `gs://my-catalog`).
   *
   * <p>If the bucket does not exist, of the caller does not have bucket metadata permissions, the
   * catalog will not be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   CreateIcebergCatalogRequest request =
   *       CreateIcebergCatalogRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setIcebergCatalogId("icebergCatalogId504062865")
   *           .setIcebergCatalog(IcebergCatalog.newBuilder().build())
   *           .build();
   *   IcebergCatalog response = icebergCatalogServiceClient.createIcebergCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IcebergCatalog createIcebergCatalog(CreateIcebergCatalogRequest request) {
    return createIcebergCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the Iceberg REST Catalog. Currently only supports Google Cloud Storage Bucket catalogs.
   * Google Cloud Storage Bucket catalog id is the bucket for which the catalog is created (e.g.
   * `my-catalog` for `gs://my-catalog`).
   *
   * <p>If the bucket does not exist, of the caller does not have bucket metadata permissions, the
   * catalog will not be created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   CreateIcebergCatalogRequest request =
   *       CreateIcebergCatalogRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setIcebergCatalogId("icebergCatalogId504062865")
   *           .setIcebergCatalog(IcebergCatalog.newBuilder().build())
   *           .build();
   *   ApiFuture<IcebergCatalog> future =
   *       icebergCatalogServiceClient.createIcebergCatalogCallable().futureCall(request);
   *   // Do something.
   *   IcebergCatalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIcebergCatalogRequest, IcebergCatalog>
      createIcebergCatalogCallable() {
    return stub.createIcebergCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Failover the catalog to a new primary replica region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   String name = "name3373707";
   *   String primaryReplica = "primaryReplica-389090218";
   *   FailoverIcebergCatalogResponse response =
   *       icebergCatalogServiceClient.failoverIcebergCatalog(name, primaryReplica);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog in the form
   *     "projects/{project_id}/catalogs/{catalog_id}"
   * @param primaryReplica Required. The region being assigned as the new primary replica region.
   *     For example "us-east1". This must be one of the replica regions in the catalog's list of
   *     replicas marked as a "secondary".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FailoverIcebergCatalogResponse failoverIcebergCatalog(
      String name, String primaryReplica) {
    FailoverIcebergCatalogRequest request =
        FailoverIcebergCatalogRequest.newBuilder()
            .setName(name)
            .setPrimaryReplica(primaryReplica)
            .build();
    return failoverIcebergCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Failover the catalog to a new primary replica region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   FailoverIcebergCatalogRequest request =
   *       FailoverIcebergCatalogRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPrimaryReplica("primaryReplica-389090218")
   *           .setValidateOnly(true)
   *           .setConditionalFailoverReplicationTime(Timestamp.newBuilder().build())
   *           .build();
   *   FailoverIcebergCatalogResponse response =
   *       icebergCatalogServiceClient.failoverIcebergCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FailoverIcebergCatalogResponse failoverIcebergCatalog(
      FailoverIcebergCatalogRequest request) {
    return failoverIcebergCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Failover the catalog to a new primary replica region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IcebergCatalogServiceClient icebergCatalogServiceClient =
   *     IcebergCatalogServiceClient.create()) {
   *   FailoverIcebergCatalogRequest request =
   *       FailoverIcebergCatalogRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPrimaryReplica("primaryReplica-389090218")
   *           .setValidateOnly(true)
   *           .setConditionalFailoverReplicationTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<FailoverIcebergCatalogResponse> future =
   *       icebergCatalogServiceClient.failoverIcebergCatalogCallable().futureCall(request);
   *   // Do something.
   *   FailoverIcebergCatalogResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogCallable() {
    return stub.failoverIcebergCatalogCallable();
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

  public static class ListIcebergCatalogsPagedResponse
      extends AbstractPagedListResponse<
          ListIcebergCatalogsRequest,
          ListIcebergCatalogsResponse,
          IcebergCatalog,
          ListIcebergCatalogsPage,
          ListIcebergCatalogsFixedSizeCollection> {

    public static ApiFuture<ListIcebergCatalogsPagedResponse> createAsync(
        PageContext<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, IcebergCatalog>
            context,
        ApiFuture<ListIcebergCatalogsResponse> futureResponse) {
      ApiFuture<ListIcebergCatalogsPage> futurePage =
          ListIcebergCatalogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIcebergCatalogsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIcebergCatalogsPagedResponse(ListIcebergCatalogsPage page) {
      super(page, ListIcebergCatalogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIcebergCatalogsPage
      extends AbstractPage<
          ListIcebergCatalogsRequest,
          ListIcebergCatalogsResponse,
          IcebergCatalog,
          ListIcebergCatalogsPage> {

    private ListIcebergCatalogsPage(
        PageContext<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, IcebergCatalog>
            context,
        ListIcebergCatalogsResponse response) {
      super(context, response);
    }

    private static ListIcebergCatalogsPage createEmptyPage() {
      return new ListIcebergCatalogsPage(null, null);
    }

    @Override
    protected ListIcebergCatalogsPage createPage(
        PageContext<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, IcebergCatalog>
            context,
        ListIcebergCatalogsResponse response) {
      return new ListIcebergCatalogsPage(context, response);
    }

    @Override
    public ApiFuture<ListIcebergCatalogsPage> createPageAsync(
        PageContext<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, IcebergCatalog>
            context,
        ApiFuture<ListIcebergCatalogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIcebergCatalogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIcebergCatalogsRequest,
          ListIcebergCatalogsResponse,
          IcebergCatalog,
          ListIcebergCatalogsPage,
          ListIcebergCatalogsFixedSizeCollection> {

    private ListIcebergCatalogsFixedSizeCollection(
        List<ListIcebergCatalogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIcebergCatalogsFixedSizeCollection createEmptyCollection() {
      return new ListIcebergCatalogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIcebergCatalogsFixedSizeCollection createCollection(
        List<ListIcebergCatalogsPage> pages, int collectionSize) {
      return new ListIcebergCatalogsFixedSizeCollection(pages, collectionSize);
    }
  }
}
