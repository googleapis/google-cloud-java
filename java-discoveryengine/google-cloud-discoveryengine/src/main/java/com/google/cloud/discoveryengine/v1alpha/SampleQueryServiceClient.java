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

package com.google.cloud.discoveryengine.v1alpha;

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
import com.google.cloud.discoveryengine.v1alpha.stub.SampleQueryServiceStub;
import com.google.cloud.discoveryengine.v1alpha.stub.SampleQueryServiceStubSettings;
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
 * Service Description: Service for managing
 * [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s,
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
 * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
 *   SampleQueryName name =
 *       SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");
 *   SampleQuery response = sampleQueryServiceClient.getSampleQuery(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SampleQueryServiceClient object to clean up resources
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
 *      <td><p> GetSampleQuery</td>
 *      <td><p> Gets a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSampleQuery(GetSampleQueryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSampleQuery(SampleQueryName name)
 *           <li><p> getSampleQuery(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSampleQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSampleQueries</td>
 *      <td><p> Gets a list of [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSampleQueries(ListSampleQueriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSampleQueries(SampleQuerySetName parent)
 *           <li><p> listSampleQueries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSampleQueriesPagedCallable()
 *           <li><p> listSampleQueriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSampleQuery</td>
 *      <td><p> Creates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSampleQuery(CreateSampleQueryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSampleQuery(SampleQuerySetName parent, SampleQuery sampleQuery, String sampleQueryId)
 *           <li><p> createSampleQuery(String parent, SampleQuery sampleQuery, String sampleQueryId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSampleQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSampleQuery</td>
 *      <td><p> Updates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSampleQuery(UpdateSampleQueryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSampleQuery(SampleQuery sampleQuery, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSampleQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSampleQuery</td>
 *      <td><p> Deletes a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSampleQuery(DeleteSampleQueryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSampleQuery(SampleQueryName name)
 *           <li><p> deleteSampleQuery(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSampleQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportSampleQueries</td>
 *      <td><p> Bulk import of multiple [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s. Sample queries that already exist may be deleted.
 * <p>  Note: It is possible for a subset of the [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s to be successfully imported.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importSampleQueriesAsync(ImportSampleQueriesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importSampleQueriesOperationCallable()
 *           <li><p> importSampleQueriesCallable()
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
 * <p>This class can be customized by passing in a custom instance of SampleQueryServiceSettings to
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
 * SampleQueryServiceSettings sampleQueryServiceSettings =
 *     SampleQueryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SampleQueryServiceClient sampleQueryServiceClient =
 *     SampleQueryServiceClient.create(sampleQueryServiceSettings);
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
 * SampleQueryServiceSettings sampleQueryServiceSettings =
 *     SampleQueryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SampleQueryServiceClient sampleQueryServiceClient =
 *     SampleQueryServiceClient.create(sampleQueryServiceSettings);
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
 * SampleQueryServiceSettings sampleQueryServiceSettings =
 *     SampleQueryServiceSettings.newHttpJsonBuilder().build();
 * SampleQueryServiceClient sampleQueryServiceClient =
 *     SampleQueryServiceClient.create(sampleQueryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SampleQueryServiceClient implements BackgroundResource {
  private final SampleQueryServiceSettings settings;
  private final SampleQueryServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SampleQueryServiceClient with default settings. */
  public static final SampleQueryServiceClient create() throws IOException {
    return create(SampleQueryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SampleQueryServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SampleQueryServiceClient create(SampleQueryServiceSettings settings)
      throws IOException {
    return new SampleQueryServiceClient(settings);
  }

  /**
   * Constructs an instance of SampleQueryServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(SampleQueryServiceSettings).
   */
  public static final SampleQueryServiceClient create(SampleQueryServiceStub stub) {
    return new SampleQueryServiceClient(stub);
  }

  /**
   * Constructs an instance of SampleQueryServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SampleQueryServiceClient(SampleQueryServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SampleQueryServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SampleQueryServiceClient(SampleQueryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SampleQueryServiceSettings getSettings() {
    return settings;
  }

  public SampleQueryServiceStub getStub() {
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
   * Gets a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   SampleQueryName name =
   *       SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");
   *   SampleQuery response = sampleQueryServiceClient.getSampleQuery(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}/sampleQueries/{sample_query}`.
   *     <p>If the caller does not have permission to access the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], regardless of whether or
   *     not it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery] does
   *     not exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuery getSampleQuery(SampleQueryName name) {
    GetSampleQueryRequest request =
        GetSampleQueryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSampleQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   String name =
   *       SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
   *           .toString();
   *   SampleQuery response = sampleQueryServiceClient.getSampleQuery(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}/sampleQueries/{sample_query}`.
   *     <p>If the caller does not have permission to access the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], regardless of whether or
   *     not it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery] does
   *     not exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuery getSampleQuery(String name) {
    GetSampleQueryRequest request = GetSampleQueryRequest.newBuilder().setName(name).build();
    return getSampleQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   GetSampleQueryRequest request =
   *       GetSampleQueryRequest.newBuilder()
   *           .setName(
   *               SampleQueryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
   *                   .toString())
   *           .build();
   *   SampleQuery response = sampleQueryServiceClient.getSampleQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuery getSampleQuery(GetSampleQueryRequest request) {
    return getSampleQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   GetSampleQueryRequest request =
   *       GetSampleQueryRequest.newBuilder()
   *           .setName(
   *               SampleQueryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SampleQuery> future =
   *       sampleQueryServiceClient.getSampleQueryCallable().futureCall(request);
   *   // Do something.
   *   SampleQuery response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSampleQueryRequest, SampleQuery> getSampleQueryCallable() {
    return stub.getSampleQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   SampleQuerySetName parent =
   *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
   *   for (SampleQuery element : sampleQueryServiceClient.listSampleQueries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent sample query set resource name, such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sampleQuerySet}`.
   *     <p>If the caller does not have permission to list
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s under this sample query
   *     set, regardless of whether or not this sample query set exists, a `PERMISSION_DENIED` error
   *     is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSampleQueriesPagedResponse listSampleQueries(SampleQuerySetName parent) {
    ListSampleQueriesRequest request =
        ListSampleQueriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSampleQueries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   String parent =
   *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString();
   *   for (SampleQuery element : sampleQueryServiceClient.listSampleQueries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent sample query set resource name, such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sampleQuerySet}`.
   *     <p>If the caller does not have permission to list
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s under this sample query
   *     set, regardless of whether or not this sample query set exists, a `PERMISSION_DENIED` error
   *     is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSampleQueriesPagedResponse listSampleQueries(String parent) {
    ListSampleQueriesRequest request =
        ListSampleQueriesRequest.newBuilder().setParent(parent).build();
    return listSampleQueries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   ListSampleQueriesRequest request =
   *       ListSampleQueriesRequest.newBuilder()
   *           .setParent(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SampleQuery element : sampleQueryServiceClient.listSampleQueries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSampleQueriesPagedResponse listSampleQueries(ListSampleQueriesRequest request) {
    return listSampleQueriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   ListSampleQueriesRequest request =
   *       ListSampleQueriesRequest.newBuilder()
   *           .setParent(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SampleQuery> future =
   *       sampleQueryServiceClient.listSampleQueriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SampleQuery element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesPagedResponse>
      listSampleQueriesPagedCallable() {
    return stub.listSampleQueriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   ListSampleQueriesRequest request =
   *       ListSampleQueriesRequest.newBuilder()
   *           .setParent(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSampleQueriesResponse response =
   *         sampleQueryServiceClient.listSampleQueriesCallable().call(request);
   *     for (SampleQuery element : response.getSampleQueriesList()) {
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
  public final UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesResponse>
      listSampleQueriesCallable() {
    return stub.listSampleQueriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   SampleQuerySetName parent =
   *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
   *   SampleQuery sampleQuery = SampleQuery.newBuilder().build();
   *   String sampleQueryId = "sampleQueryId1739022073";
   *   SampleQuery response =
   *       sampleQueryServiceClient.createSampleQuery(parent, sampleQuery, sampleQueryId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sampleQuerySet}`.
   * @param sampleQuery Required. The
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery] to create.
   * @param sampleQueryId Required. The ID to use for the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], which will become the
   *     final component of the
   *     [SampleQuery.name][google.cloud.discoveryengine.v1alpha.SampleQuery.name].
   *     <p>If the caller does not have permission to create the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], regardless of whether or
   *     not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>This field must be unique among all
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s with the same
   *     [parent][google.cloud.discoveryengine.v1alpha.CreateSampleQueryRequest.parent]. Otherwise,
   *     an `ALREADY_EXISTS` error is returned.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuery createSampleQuery(
      SampleQuerySetName parent, SampleQuery sampleQuery, String sampleQueryId) {
    CreateSampleQueryRequest request =
        CreateSampleQueryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSampleQuery(sampleQuery)
            .setSampleQueryId(sampleQueryId)
            .build();
    return createSampleQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   String parent =
   *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString();
   *   SampleQuery sampleQuery = SampleQuery.newBuilder().build();
   *   String sampleQueryId = "sampleQueryId1739022073";
   *   SampleQuery response =
   *       sampleQueryServiceClient.createSampleQuery(parent, sampleQuery, sampleQueryId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sampleQuerySet}`.
   * @param sampleQuery Required. The
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery] to create.
   * @param sampleQueryId Required. The ID to use for the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], which will become the
   *     final component of the
   *     [SampleQuery.name][google.cloud.discoveryengine.v1alpha.SampleQuery.name].
   *     <p>If the caller does not have permission to create the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], regardless of whether or
   *     not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>This field must be unique among all
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s with the same
   *     [parent][google.cloud.discoveryengine.v1alpha.CreateSampleQueryRequest.parent]. Otherwise,
   *     an `ALREADY_EXISTS` error is returned.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuery createSampleQuery(
      String parent, SampleQuery sampleQuery, String sampleQueryId) {
    CreateSampleQueryRequest request =
        CreateSampleQueryRequest.newBuilder()
            .setParent(parent)
            .setSampleQuery(sampleQuery)
            .setSampleQueryId(sampleQueryId)
            .build();
    return createSampleQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   CreateSampleQueryRequest request =
   *       CreateSampleQueryRequest.newBuilder()
   *           .setParent(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .setSampleQuery(SampleQuery.newBuilder().build())
   *           .setSampleQueryId("sampleQueryId1739022073")
   *           .build();
   *   SampleQuery response = sampleQueryServiceClient.createSampleQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuery createSampleQuery(CreateSampleQueryRequest request) {
    return createSampleQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   CreateSampleQueryRequest request =
   *       CreateSampleQueryRequest.newBuilder()
   *           .setParent(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .setSampleQuery(SampleQuery.newBuilder().build())
   *           .setSampleQueryId("sampleQueryId1739022073")
   *           .build();
   *   ApiFuture<SampleQuery> future =
   *       sampleQueryServiceClient.createSampleQueryCallable().futureCall(request);
   *   // Do something.
   *   SampleQuery response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSampleQueryRequest, SampleQuery> createSampleQueryCallable() {
    return stub.createSampleQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   SampleQuery sampleQuery = SampleQuery.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SampleQuery response = sampleQueryServiceClient.updateSampleQuery(sampleQuery, updateMask);
   * }
   * }</pre>
   *
   * @param sampleQuery Required. The simple query to update.
   *     <p>If the caller does not have permission to update the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], regardless of whether or
   *     not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery] to update does
   *     not exist a `NOT_FOUND` error is returned.
   * @param updateMask Indicates which fields in the provided imported 'simple query' to update. If
   *     not set, will by default update all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuery updateSampleQuery(SampleQuery sampleQuery, FieldMask updateMask) {
    UpdateSampleQueryRequest request =
        UpdateSampleQueryRequest.newBuilder()
            .setSampleQuery(sampleQuery)
            .setUpdateMask(updateMask)
            .build();
    return updateSampleQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   UpdateSampleQueryRequest request =
   *       UpdateSampleQueryRequest.newBuilder()
   *           .setSampleQuery(SampleQuery.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SampleQuery response = sampleQueryServiceClient.updateSampleQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuery updateSampleQuery(UpdateSampleQueryRequest request) {
    return updateSampleQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   UpdateSampleQueryRequest request =
   *       UpdateSampleQueryRequest.newBuilder()
   *           .setSampleQuery(SampleQuery.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SampleQuery> future =
   *       sampleQueryServiceClient.updateSampleQueryCallable().futureCall(request);
   *   // Do something.
   *   SampleQuery response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSampleQueryRequest, SampleQuery> updateSampleQueryCallable() {
    return stub.updateSampleQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   SampleQueryName name =
   *       SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");
   *   sampleQueryServiceClient.deleteSampleQuery(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}/sampleQueries/{sample_query}`.
   *     <p>If the caller does not have permission to delete the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], regardless of whether or
   *     not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery] to delete does
   *     not exist, a `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSampleQuery(SampleQueryName name) {
    DeleteSampleQueryRequest request =
        DeleteSampleQueryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSampleQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   String name =
   *       SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
   *           .toString();
   *   sampleQueryServiceClient.deleteSampleQuery(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}/sampleQueries/{sample_query}`.
   *     <p>If the caller does not have permission to delete the
   *     [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery], regardless of whether or
   *     not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery] to delete does
   *     not exist, a `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSampleQuery(String name) {
    DeleteSampleQueryRequest request = DeleteSampleQueryRequest.newBuilder().setName(name).build();
    deleteSampleQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   DeleteSampleQueryRequest request =
   *       DeleteSampleQueryRequest.newBuilder()
   *           .setName(
   *               SampleQueryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
   *                   .toString())
   *           .build();
   *   sampleQueryServiceClient.deleteSampleQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSampleQuery(DeleteSampleQueryRequest request) {
    deleteSampleQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   DeleteSampleQueryRequest request =
   *       DeleteSampleQueryRequest.newBuilder()
   *           .setName(
   *               SampleQueryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       sampleQueryServiceClient.deleteSampleQueryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSampleQueryRequest, Empty> deleteSampleQueryCallable() {
    return stub.deleteSampleQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.
   * Sample queries that already exist may be deleted.
   *
   * <p>Note: It is possible for a subset of the
   * [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s to be successfully imported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   ImportSampleQueriesRequest request =
   *       ImportSampleQueriesRequest.newBuilder()
   *           .setParent(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .build();
   *   ImportSampleQueriesResponse response =
   *       sampleQueryServiceClient.importSampleQueriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesAsync(ImportSampleQueriesRequest request) {
    return importSampleQueriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.
   * Sample queries that already exist may be deleted.
   *
   * <p>Note: It is possible for a subset of the
   * [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s to be successfully imported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   ImportSampleQueriesRequest request =
   *       ImportSampleQueriesRequest.newBuilder()
   *           .setParent(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ImportSampleQueriesResponse, ImportSampleQueriesMetadata> future =
   *       sampleQueryServiceClient.importSampleQueriesOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportSampleQueriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationCallable() {
    return stub.importSampleQueriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s.
   * Sample queries that already exist may be deleted.
   *
   * <p>Note: It is possible for a subset of the
   * [SampleQuery][google.cloud.discoveryengine.v1alpha.SampleQuery]s to be successfully imported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQueryServiceClient sampleQueryServiceClient = SampleQueryServiceClient.create()) {
   *   ImportSampleQueriesRequest request =
   *       ImportSampleQueriesRequest.newBuilder()
   *           .setParent(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sampleQueryServiceClient.importSampleQueriesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportSampleQueriesRequest, Operation> importSampleQueriesCallable() {
    return stub.importSampleQueriesCallable();
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

  public static class ListSampleQueriesPagedResponse
      extends AbstractPagedListResponse<
          ListSampleQueriesRequest,
          ListSampleQueriesResponse,
          SampleQuery,
          ListSampleQueriesPage,
          ListSampleQueriesFixedSizeCollection> {

    public static ApiFuture<ListSampleQueriesPagedResponse> createAsync(
        PageContext<ListSampleQueriesRequest, ListSampleQueriesResponse, SampleQuery> context,
        ApiFuture<ListSampleQueriesResponse> futureResponse) {
      ApiFuture<ListSampleQueriesPage> futurePage =
          ListSampleQueriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSampleQueriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSampleQueriesPagedResponse(ListSampleQueriesPage page) {
      super(page, ListSampleQueriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSampleQueriesPage
      extends AbstractPage<
          ListSampleQueriesRequest, ListSampleQueriesResponse, SampleQuery, ListSampleQueriesPage> {

    private ListSampleQueriesPage(
        PageContext<ListSampleQueriesRequest, ListSampleQueriesResponse, SampleQuery> context,
        ListSampleQueriesResponse response) {
      super(context, response);
    }

    private static ListSampleQueriesPage createEmptyPage() {
      return new ListSampleQueriesPage(null, null);
    }

    @Override
    protected ListSampleQueriesPage createPage(
        PageContext<ListSampleQueriesRequest, ListSampleQueriesResponse, SampleQuery> context,
        ListSampleQueriesResponse response) {
      return new ListSampleQueriesPage(context, response);
    }

    @Override
    public ApiFuture<ListSampleQueriesPage> createPageAsync(
        PageContext<ListSampleQueriesRequest, ListSampleQueriesResponse, SampleQuery> context,
        ApiFuture<ListSampleQueriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSampleQueriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSampleQueriesRequest,
          ListSampleQueriesResponse,
          SampleQuery,
          ListSampleQueriesPage,
          ListSampleQueriesFixedSizeCollection> {

    private ListSampleQueriesFixedSizeCollection(
        List<ListSampleQueriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSampleQueriesFixedSizeCollection createEmptyCollection() {
      return new ListSampleQueriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSampleQueriesFixedSizeCollection createCollection(
        List<ListSampleQueriesPage> pages, int collectionSize) {
      return new ListSampleQueriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
