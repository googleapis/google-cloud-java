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

package com.google.cloud.geminidataanalytics.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.geminidataanalytics.v1beta.stub.ContextRetrievalServiceStub;
import com.google.cloud.geminidataanalytics.v1beta.stub.ContextRetrievalServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to ask a natural language question with a provided project, returns
 * BigQuery tables that are relevant to the question within the project scope that is accessible to
 * the user, along with contextual data including table schema information as well as sample values.
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
 * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
 *     ContextRetrievalServiceClient.create()) {
 *   RetrieveBigQueryTableContextRequest request =
 *       RetrieveBigQueryTableContextRequest.newBuilder()
 *           .setProject("project-309310695")
 *           .setParent("parent-995424086")
 *           .setQuery("query107944136")
 *           .addAllDirectLookup(new ArrayList<DirectLookup>())
 *           .build();
 *   RetrieveBigQueryTableContextResponse response =
 *       contextRetrievalServiceClient.retrieveBigQueryTableContext(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContextRetrievalServiceClient object to clean up
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
 *      <td><p> RetrieveBigQueryTableContext</td>
 *      <td><p> Retrieves BigQuery table contextual data for provided table references. Contextual data includes table schema information as well as sample values.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableContext(RetrieveBigQueryTableContextRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableContextCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveBigQueryTableContexts</td>
 *      <td><p> Retrieves BigQuery table contextual data for provided table references. Contextual data includes table schema information as well as sample values.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableContexts(RetrieveBigQueryTableContextsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableContextsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveBigQueryTableContextsFromRecentTables</td>
 *      <td><p> Retrieves BigQuery table contextual data from recently accessed tables. Contextual data includes table schema information as well as sample values.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableContextsFromRecentTables(RetrieveBigQueryTableContextsFromRecentTablesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableContextsFromRecentTablesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveBigQueryTableSuggestedDescriptions</td>
 *      <td><p> Retrieves BigQuery table schema with suggested table and column descriptions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableSuggestedDescriptions(RetrieveBigQueryTableSuggestedDescriptionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableSuggestedDescriptionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveBigQueryTableSuggestedExamples</td>
 *      <td><p> Retrieves BigQuery table schema with suggested NL-SQL examples.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableSuggestedExamples(RetrieveBigQueryTableSuggestedExamplesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryTableSuggestedExamplesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveBigQueryRecentRelevantTables</td>
 *      <td><p> Retrieves BigQuery table references from recently accessed tables.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryRecentRelevantTables(RetrieveBigQueryRecentRelevantTablesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveBigQueryRecentRelevantTablesCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * ContextRetrievalServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContextRetrievalServiceSettings contextRetrievalServiceSettings =
 *     ContextRetrievalServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContextRetrievalServiceClient contextRetrievalServiceClient =
 *     ContextRetrievalServiceClient.create(contextRetrievalServiceSettings);
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
 * ContextRetrievalServiceSettings contextRetrievalServiceSettings =
 *     ContextRetrievalServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContextRetrievalServiceClient contextRetrievalServiceClient =
 *     ContextRetrievalServiceClient.create(contextRetrievalServiceSettings);
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
 * ContextRetrievalServiceSettings contextRetrievalServiceSettings =
 *     ContextRetrievalServiceSettings.newHttpJsonBuilder().build();
 * ContextRetrievalServiceClient contextRetrievalServiceClient =
 *     ContextRetrievalServiceClient.create(contextRetrievalServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ContextRetrievalServiceClient implements BackgroundResource {
  private final ContextRetrievalServiceSettings settings;
  private final ContextRetrievalServiceStub stub;

  /** Constructs an instance of ContextRetrievalServiceClient with default settings. */
  public static final ContextRetrievalServiceClient create() throws IOException {
    return create(ContextRetrievalServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContextRetrievalServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContextRetrievalServiceClient create(ContextRetrievalServiceSettings settings)
      throws IOException {
    return new ContextRetrievalServiceClient(settings);
  }

  /**
   * Constructs an instance of ContextRetrievalServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ContextRetrievalServiceSettings).
   */
  public static final ContextRetrievalServiceClient create(ContextRetrievalServiceStub stub) {
    return new ContextRetrievalServiceClient(stub);
  }

  /**
   * Constructs an instance of ContextRetrievalServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ContextRetrievalServiceClient(ContextRetrievalServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ContextRetrievalServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ContextRetrievalServiceClient(ContextRetrievalServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContextRetrievalServiceSettings getSettings() {
    return settings;
  }

  public ContextRetrievalServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table contextual data for provided table references. Contextual data
   * includes table schema information as well as sample values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableContextRequest request =
   *       RetrieveBigQueryTableContextRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .addAllDirectLookup(new ArrayList<DirectLookup>())
   *           .build();
   *   RetrieveBigQueryTableContextResponse response =
   *       contextRetrievalServiceClient.retrieveBigQueryTableContext(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveBigQueryTableContextResponse retrieveBigQueryTableContext(
      RetrieveBigQueryTableContextRequest request) {
    return retrieveBigQueryTableContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table contextual data for provided table references. Contextual data
   * includes table schema information as well as sample values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableContextRequest request =
   *       RetrieveBigQueryTableContextRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .addAllDirectLookup(new ArrayList<DirectLookup>())
   *           .build();
   *   ApiFuture<RetrieveBigQueryTableContextResponse> future =
   *       contextRetrievalServiceClient.retrieveBigQueryTableContextCallable().futureCall(request);
   *   // Do something.
   *   RetrieveBigQueryTableContextResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextCallable() {
    return stub.retrieveBigQueryTableContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table contextual data for provided table references. Contextual data
   * includes table schema information as well as sample values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableContextsRequest request =
   *       RetrieveBigQueryTableContextsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .addAllDirectLookups(new ArrayList<DirectLookup>())
   *           .build();
   *   RetrieveBigQueryTableContextsResponse response =
   *       contextRetrievalServiceClient.retrieveBigQueryTableContexts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveBigQueryTableContextsResponse retrieveBigQueryTableContexts(
      RetrieveBigQueryTableContextsRequest request) {
    return retrieveBigQueryTableContextsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table contextual data for provided table references. Contextual data
   * includes table schema information as well as sample values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableContextsRequest request =
   *       RetrieveBigQueryTableContextsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .addAllDirectLookups(new ArrayList<DirectLookup>())
   *           .build();
   *   ApiFuture<RetrieveBigQueryTableContextsResponse> future =
   *       contextRetrievalServiceClient.retrieveBigQueryTableContextsCallable().futureCall(request);
   *   // Do something.
   *   RetrieveBigQueryTableContextsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsCallable() {
    return stub.retrieveBigQueryTableContextsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table contextual data from recently accessed tables. Contextual data
   * includes table schema information as well as sample values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableContextsFromRecentTablesRequest request =
   *       RetrieveBigQueryTableContextsFromRecentTablesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .build();
   *   RetrieveBigQueryTableContextsFromRecentTablesResponse response =
   *       contextRetrievalServiceClient.retrieveBigQueryTableContextsFromRecentTables(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveBigQueryTableContextsFromRecentTablesResponse
      retrieveBigQueryTableContextsFromRecentTables(
          RetrieveBigQueryTableContextsFromRecentTablesRequest request) {
    return retrieveBigQueryTableContextsFromRecentTablesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table contextual data from recently accessed tables. Contextual data
   * includes table schema information as well as sample values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableContextsFromRecentTablesRequest request =
   *       RetrieveBigQueryTableContextsFromRecentTablesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .build();
   *   ApiFuture<RetrieveBigQueryTableContextsFromRecentTablesResponse> future =
   *       contextRetrievalServiceClient
   *           .retrieveBigQueryTableContextsFromRecentTablesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   RetrieveBigQueryTableContextsFromRecentTablesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesCallable() {
    return stub.retrieveBigQueryTableContextsFromRecentTablesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table schema with suggested table and column descriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableSuggestedDescriptionsRequest request =
   *       RetrieveBigQueryTableSuggestedDescriptionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllDirectLookup(new ArrayList<DirectLookup>())
   *           .build();
   *   RetrieveBigQueryTableSuggestedDescriptionsResponse response =
   *       contextRetrievalServiceClient.retrieveBigQueryTableSuggestedDescriptions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveBigQueryTableSuggestedDescriptionsResponse
      retrieveBigQueryTableSuggestedDescriptions(
          RetrieveBigQueryTableSuggestedDescriptionsRequest request) {
    return retrieveBigQueryTableSuggestedDescriptionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table schema with suggested table and column descriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableSuggestedDescriptionsRequest request =
   *       RetrieveBigQueryTableSuggestedDescriptionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllDirectLookup(new ArrayList<DirectLookup>())
   *           .build();
   *   ApiFuture<RetrieveBigQueryTableSuggestedDescriptionsResponse> future =
   *       contextRetrievalServiceClient
   *           .retrieveBigQueryTableSuggestedDescriptionsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   RetrieveBigQueryTableSuggestedDescriptionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsCallable() {
    return stub.retrieveBigQueryTableSuggestedDescriptionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table schema with suggested NL-SQL examples.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableSuggestedExamplesRequest request =
   *       RetrieveBigQueryTableSuggestedExamplesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllDirectLookup(new ArrayList<DirectLookup>())
   *           .build();
   *   RetrieveBigQueryTableSuggestedExamplesResponse response =
   *       contextRetrievalServiceClient.retrieveBigQueryTableSuggestedExamples(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveBigQueryTableSuggestedExamplesResponse
      retrieveBigQueryTableSuggestedExamples(
          RetrieveBigQueryTableSuggestedExamplesRequest request) {
    return retrieveBigQueryTableSuggestedExamplesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table schema with suggested NL-SQL examples.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryTableSuggestedExamplesRequest request =
   *       RetrieveBigQueryTableSuggestedExamplesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllDirectLookup(new ArrayList<DirectLookup>())
   *           .build();
   *   ApiFuture<RetrieveBigQueryTableSuggestedExamplesResponse> future =
   *       contextRetrievalServiceClient
   *           .retrieveBigQueryTableSuggestedExamplesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   RetrieveBigQueryTableSuggestedExamplesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesCallable() {
    return stub.retrieveBigQueryTableSuggestedExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table references from recently accessed tables.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryRecentRelevantTablesRequest request =
   *       RetrieveBigQueryRecentRelevantTablesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .build();
   *   RetrieveBigQueryRecentRelevantTablesResponse response =
   *       contextRetrievalServiceClient.retrieveBigQueryRecentRelevantTables(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveBigQueryRecentRelevantTablesResponse retrieveBigQueryRecentRelevantTables(
      RetrieveBigQueryRecentRelevantTablesRequest request) {
    return retrieveBigQueryRecentRelevantTablesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves BigQuery table references from recently accessed tables.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   RetrieveBigQueryRecentRelevantTablesRequest request =
   *       RetrieveBigQueryRecentRelevantTablesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .build();
   *   ApiFuture<RetrieveBigQueryRecentRelevantTablesResponse> future =
   *       contextRetrievalServiceClient
   *           .retrieveBigQueryRecentRelevantTablesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   RetrieveBigQueryRecentRelevantTablesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesCallable() {
    return stub.retrieveBigQueryRecentRelevantTablesCallable();
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
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : contextRetrievalServiceClient.listLocations(request).iterateAll()) {
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
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       contextRetrievalServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         contextRetrievalServiceClient.listLocationsCallable().call(request);
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
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = contextRetrievalServiceClient.getLocation(request);
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
   * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
   *     ContextRetrievalServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       contextRetrievalServiceClient.getLocationCallable().futureCall(request);
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
