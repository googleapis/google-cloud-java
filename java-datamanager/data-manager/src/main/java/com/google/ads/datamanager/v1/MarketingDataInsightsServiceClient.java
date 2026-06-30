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

package com.google.ads.datamanager.v1;

import com.google.ads.datamanager.v1.stub.MarketingDataInsightsServiceStub;
import com.google.ads.datamanager.v1.stub.MarketingDataInsightsServiceStubSettings;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to return insights on marketing data.
 *
 * <p>This feature is only available to data partners.
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
 * try (MarketingDataInsightsServiceClient marketingDataInsightsServiceClient =
 *     MarketingDataInsightsServiceClient.create()) {
 *   RetrieveInsightsRequest request =
 *       RetrieveInsightsRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setBaseline(Baseline.newBuilder().build())
 *           .setUserListId("userListId1381604868")
 *           .build();
 *   RetrieveInsightsResponse response =
 *       marketingDataInsightsServiceClient.retrieveInsights(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MarketingDataInsightsServiceClient object to clean up
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
 *      <td><p> RetrieveInsights</td>
 *      <td><p> Retrieves marketing data insights for a given user list.
 * <p>  This feature is only available to data partners.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveInsights(RetrieveInsightsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveInsightsCallable()
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
 * MarketingDataInsightsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MarketingDataInsightsServiceSettings marketingDataInsightsServiceSettings =
 *     MarketingDataInsightsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MarketingDataInsightsServiceClient marketingDataInsightsServiceClient =
 *     MarketingDataInsightsServiceClient.create(marketingDataInsightsServiceSettings);
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
 * MarketingDataInsightsServiceSettings marketingDataInsightsServiceSettings =
 *     MarketingDataInsightsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MarketingDataInsightsServiceClient marketingDataInsightsServiceClient =
 *     MarketingDataInsightsServiceClient.create(marketingDataInsightsServiceSettings);
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
 * MarketingDataInsightsServiceSettings marketingDataInsightsServiceSettings =
 *     MarketingDataInsightsServiceSettings.newHttpJsonBuilder().build();
 * MarketingDataInsightsServiceClient marketingDataInsightsServiceClient =
 *     MarketingDataInsightsServiceClient.create(marketingDataInsightsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MarketingDataInsightsServiceClient implements BackgroundResource {
  private final MarketingDataInsightsServiceSettings settings;
  private final MarketingDataInsightsServiceStub stub;

  /** Constructs an instance of MarketingDataInsightsServiceClient with default settings. */
  public static final MarketingDataInsightsServiceClient create() throws IOException {
    return create(MarketingDataInsightsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MarketingDataInsightsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final MarketingDataInsightsServiceClient create(
      MarketingDataInsightsServiceSettings settings) throws IOException {
    return new MarketingDataInsightsServiceClient(settings);
  }

  /**
   * Constructs an instance of MarketingDataInsightsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(MarketingDataInsightsServiceSettings).
   */
  public static final MarketingDataInsightsServiceClient create(
      MarketingDataInsightsServiceStub stub) {
    return new MarketingDataInsightsServiceClient(stub);
  }

  /**
   * Constructs an instance of MarketingDataInsightsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MarketingDataInsightsServiceClient(MarketingDataInsightsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((MarketingDataInsightsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MarketingDataInsightsServiceClient(MarketingDataInsightsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MarketingDataInsightsServiceSettings getSettings() {
    return settings;
  }

  public MarketingDataInsightsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves marketing data insights for a given user list.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingDataInsightsServiceClient marketingDataInsightsServiceClient =
   *     MarketingDataInsightsServiceClient.create()) {
   *   RetrieveInsightsRequest request =
   *       RetrieveInsightsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setBaseline(Baseline.newBuilder().build())
   *           .setUserListId("userListId1381604868")
   *           .build();
   *   RetrieveInsightsResponse response =
   *       marketingDataInsightsServiceClient.retrieveInsights(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveInsightsResponse retrieveInsights(RetrieveInsightsRequest request) {
    return retrieveInsightsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves marketing data insights for a given user list.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingDataInsightsServiceClient marketingDataInsightsServiceClient =
   *     MarketingDataInsightsServiceClient.create()) {
   *   RetrieveInsightsRequest request =
   *       RetrieveInsightsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setBaseline(Baseline.newBuilder().build())
   *           .setUserListId("userListId1381604868")
   *           .build();
   *   ApiFuture<RetrieveInsightsResponse> future =
   *       marketingDataInsightsServiceClient.retrieveInsightsCallable().futureCall(request);
   *   // Do something.
   *   RetrieveInsightsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetrieveInsightsRequest, RetrieveInsightsResponse>
      retrieveInsightsCallable() {
    return stub.retrieveInsightsCallable();
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
