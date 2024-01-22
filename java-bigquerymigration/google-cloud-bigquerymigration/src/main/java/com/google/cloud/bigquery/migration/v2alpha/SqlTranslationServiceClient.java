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

package com.google.cloud.bigquery.migration.v2alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.migration.v2alpha.stub.SqlTranslationServiceStub;
import com.google.cloud.bigquery.migration.v2alpha.stub.SqlTranslationServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides other SQL dialects to GoogleSQL translation operations.
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
 * try (SqlTranslationServiceClient sqlTranslationServiceClient =
 *     SqlTranslationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
 *       TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
 *   String query = "query107944136";
 *   TranslateQueryResponse response =
 *       sqlTranslationServiceClient.translateQuery(parent, sourceDialect, query);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlTranslationServiceClient object to clean up
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
 *      <td><p> TranslateQuery</td>
 *      <td><p> Translates input queries from source dialects to GoogleSQL.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> translateQuery(TranslateQueryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> translateQuery(LocationName parent, TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect, String query)
 *           <li><p> translateQuery(String parent, TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> translateQueryCallable()
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
 * <p>This class can be customized by passing in a custom instance of SqlTranslationServiceSettings
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
 * SqlTranslationServiceSettings sqlTranslationServiceSettings =
 *     SqlTranslationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlTranslationServiceClient sqlTranslationServiceClient =
 *     SqlTranslationServiceClient.create(sqlTranslationServiceSettings);
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
 * SqlTranslationServiceSettings sqlTranslationServiceSettings =
 *     SqlTranslationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlTranslationServiceClient sqlTranslationServiceClient =
 *     SqlTranslationServiceClient.create(sqlTranslationServiceSettings);
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
 * SqlTranslationServiceSettings sqlTranslationServiceSettings =
 *     SqlTranslationServiceSettings.newHttpJsonBuilder().build();
 * SqlTranslationServiceClient sqlTranslationServiceClient =
 *     SqlTranslationServiceClient.create(sqlTranslationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SqlTranslationServiceClient implements BackgroundResource {
  private final SqlTranslationServiceSettings settings;
  private final SqlTranslationServiceStub stub;

  /** Constructs an instance of SqlTranslationServiceClient with default settings. */
  public static final SqlTranslationServiceClient create() throws IOException {
    return create(SqlTranslationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlTranslationServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlTranslationServiceClient create(SqlTranslationServiceSettings settings)
      throws IOException {
    return new SqlTranslationServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlTranslationServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SqlTranslationServiceSettings).
   */
  public static final SqlTranslationServiceClient create(SqlTranslationServiceStub stub) {
    return new SqlTranslationServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlTranslationServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SqlTranslationServiceClient(SqlTranslationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlTranslationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlTranslationServiceClient(SqlTranslationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SqlTranslationServiceSettings getSettings() {
    return settings;
  }

  public SqlTranslationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input queries from source dialects to GoogleSQL.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlTranslationServiceClient sqlTranslationServiceClient =
   *     SqlTranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
   *       TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
   *   String query = "query107944136";
   *   TranslateQueryResponse response =
   *       sqlTranslationServiceClient.translateQuery(parent, sourceDialect, query);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project to which this translation request belongs.
   *     Example: `projects/foo/locations/bar`
   * @param sourceDialect Required. The source SQL dialect of `queries`.
   * @param query Required. The query to be translated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateQueryResponse translateQuery(
      LocationName parent,
      TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect,
      String query) {
    TranslateQueryRequest request =
        TranslateQueryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSourceDialect(sourceDialect)
            .setQuery(query)
            .build();
    return translateQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input queries from source dialects to GoogleSQL.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlTranslationServiceClient sqlTranslationServiceClient =
   *     SqlTranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
   *       TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
   *   String query = "query107944136";
   *   TranslateQueryResponse response =
   *       sqlTranslationServiceClient.translateQuery(parent, sourceDialect, query);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project to which this translation request belongs.
   *     Example: `projects/foo/locations/bar`
   * @param sourceDialect Required. The source SQL dialect of `queries`.
   * @param query Required. The query to be translated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateQueryResponse translateQuery(
      String parent,
      TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect,
      String query) {
    TranslateQueryRequest request =
        TranslateQueryRequest.newBuilder()
            .setParent(parent)
            .setSourceDialect(sourceDialect)
            .setQuery(query)
            .build();
    return translateQuery(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input queries from source dialects to GoogleSQL.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlTranslationServiceClient sqlTranslationServiceClient =
   *     SqlTranslationServiceClient.create()) {
   *   TranslateQueryRequest request =
   *       TranslateQueryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .build();
   *   TranslateQueryResponse response = sqlTranslationServiceClient.translateQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateQueryResponse translateQuery(TranslateQueryRequest request) {
    return translateQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input queries from source dialects to GoogleSQL.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlTranslationServiceClient sqlTranslationServiceClient =
   *     SqlTranslationServiceClient.create()) {
   *   TranslateQueryRequest request =
   *       TranslateQueryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .build();
   *   ApiFuture<TranslateQueryResponse> future =
   *       sqlTranslationServiceClient.translateQueryCallable().futureCall(request);
   *   // Do something.
   *   TranslateQueryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TranslateQueryRequest, TranslateQueryResponse>
      translateQueryCallable() {
    return stub.translateQueryCallable();
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
}
