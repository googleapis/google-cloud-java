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

import com.google.ads.datamanager.v1.stub.ReportingServiceStub;
import com.google.ads.datamanager.v1.stub.ReportingServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for querying reports.
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
 * try (ReportingServiceClient reportingServiceClient = ReportingServiceClient.create()) {
 *   String parent = "parent-995424086";
 *   for (PartnerMatchReportEntry element :
 *       reportingServiceClient.retrievePartnerMatchReport(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReportingServiceClient object to clean up resources
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
 *      <td><p> RetrievePartnerMatchReport</td>
 *      <td><p> Retrieves a partner match report.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrievePartnerMatchReport(RetrievePartnerMatchReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> retrievePartnerMatchReport(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrievePartnerMatchReportPagedCallable()
 *           <li><p> retrievePartnerMatchReportCallable()
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
 * <p>This class can be customized by passing in a custom instance of ReportingServiceSettings to
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
 * ReportingServiceSettings reportingServiceSettings =
 *     ReportingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReportingServiceClient reportingServiceClient =
 *     ReportingServiceClient.create(reportingServiceSettings);
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
 * ReportingServiceSettings reportingServiceSettings =
 *     ReportingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReportingServiceClient reportingServiceClient =
 *     ReportingServiceClient.create(reportingServiceSettings);
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
 * ReportingServiceSettings reportingServiceSettings =
 *     ReportingServiceSettings.newHttpJsonBuilder().build();
 * ReportingServiceClient reportingServiceClient =
 *     ReportingServiceClient.create(reportingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ReportingServiceClient implements BackgroundResource {
  private final @Nullable ReportingServiceSettings settings;
  private final ReportingServiceStub stub;

  /** Constructs an instance of ReportingServiceClient with default settings. */
  public static final ReportingServiceClient create() throws IOException {
    return create(ReportingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReportingServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReportingServiceClient create(ReportingServiceSettings settings)
      throws IOException {
    return new ReportingServiceClient(settings);
  }

  /**
   * Constructs an instance of ReportingServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ReportingServiceSettings).
   */
  public static final ReportingServiceClient create(ReportingServiceStub stub) {
    return new ReportingServiceClient(stub);
  }

  /**
   * Constructs an instance of ReportingServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReportingServiceClient(ReportingServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReportingServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ReportingServiceClient(ReportingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ReportingServiceSettings getSettings() {
    return settings;
  }

  public ReportingServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a partner match report.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportingServiceClient reportingServiceClient = ReportingServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (PartnerMatchReportEntry element :
   *       reportingServiceClient.retrievePartnerMatchReport(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account that owns the user list. Format:
   *     `accountTypes/{account_type}/accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrievePartnerMatchReportPagedResponse retrievePartnerMatchReport(String parent) {
    RetrievePartnerMatchReportRequest request =
        RetrievePartnerMatchReportRequest.newBuilder().setParent(parent).build();
    return retrievePartnerMatchReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a partner match report.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportingServiceClient reportingServiceClient = ReportingServiceClient.create()) {
   *   RetrievePartnerMatchReportRequest request =
   *       RetrievePartnerMatchReportRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCurrencyCode("currencyCode1004773790")
   *           .setFilter("filter-1274492040")
   *           .setStartDate(-1573629589)
   *           .setEndDate(1725067410)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PartnerMatchReportEntry element :
   *       reportingServiceClient.retrievePartnerMatchReport(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrievePartnerMatchReportPagedResponse retrievePartnerMatchReport(
      RetrievePartnerMatchReportRequest request) {
    return retrievePartnerMatchReportPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a partner match report.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportingServiceClient reportingServiceClient = ReportingServiceClient.create()) {
   *   RetrievePartnerMatchReportRequest request =
   *       RetrievePartnerMatchReportRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCurrencyCode("currencyCode1004773790")
   *           .setFilter("filter-1274492040")
   *           .setStartDate(-1573629589)
   *           .setEndDate(1725067410)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PartnerMatchReportEntry> future =
   *       reportingServiceClient.retrievePartnerMatchReportPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PartnerMatchReportEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RetrievePartnerMatchReportRequest, RetrievePartnerMatchReportPagedResponse>
      retrievePartnerMatchReportPagedCallable() {
    return stub.retrievePartnerMatchReportPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a partner match report.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportingServiceClient reportingServiceClient = ReportingServiceClient.create()) {
   *   RetrievePartnerMatchReportRequest request =
   *       RetrievePartnerMatchReportRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCurrencyCode("currencyCode1004773790")
   *           .setFilter("filter-1274492040")
   *           .setStartDate(-1573629589)
   *           .setEndDate(1725067410)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     RetrievePartnerMatchReportResponse response =
   *         reportingServiceClient.retrievePartnerMatchReportCallable().call(request);
   *     for (PartnerMatchReportEntry element : response.getPartnerMatchReportEntriesList()) {
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
  public final UnaryCallable<RetrievePartnerMatchReportRequest, RetrievePartnerMatchReportResponse>
      retrievePartnerMatchReportCallable() {
    return stub.retrievePartnerMatchReportCallable();
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

  public static class RetrievePartnerMatchReportPagedResponse
      extends AbstractPagedListResponse<
          RetrievePartnerMatchReportRequest,
          RetrievePartnerMatchReportResponse,
          PartnerMatchReportEntry,
          RetrievePartnerMatchReportPage,
          RetrievePartnerMatchReportFixedSizeCollection> {

    public static ApiFuture<RetrievePartnerMatchReportPagedResponse> createAsync(
        PageContext<
                RetrievePartnerMatchReportRequest,
                RetrievePartnerMatchReportResponse,
                PartnerMatchReportEntry>
            context,
        ApiFuture<RetrievePartnerMatchReportResponse> futureResponse) {
      ApiFuture<RetrievePartnerMatchReportPage> futurePage =
          RetrievePartnerMatchReportPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new RetrievePartnerMatchReportPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private RetrievePartnerMatchReportPagedResponse(RetrievePartnerMatchReportPage page) {
      super(page, RetrievePartnerMatchReportFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class RetrievePartnerMatchReportPage
      extends AbstractPage<
          RetrievePartnerMatchReportRequest,
          RetrievePartnerMatchReportResponse,
          PartnerMatchReportEntry,
          RetrievePartnerMatchReportPage> {

    private RetrievePartnerMatchReportPage(
        @Nullable
            PageContext<
                RetrievePartnerMatchReportRequest,
                RetrievePartnerMatchReportResponse,
                PartnerMatchReportEntry>
            context,
        @Nullable RetrievePartnerMatchReportResponse response) {
      super(context, response);
    }

    private static RetrievePartnerMatchReportPage createEmptyPage() {
      return new RetrievePartnerMatchReportPage(null, null);
    }

    @Override
    protected RetrievePartnerMatchReportPage createPage(
        @Nullable
            PageContext<
                RetrievePartnerMatchReportRequest,
                RetrievePartnerMatchReportResponse,
                PartnerMatchReportEntry>
            context,
        @Nullable RetrievePartnerMatchReportResponse response) {
      return new RetrievePartnerMatchReportPage(context, response);
    }

    @Override
    public ApiFuture<RetrievePartnerMatchReportPage> createPageAsync(
        @Nullable
            PageContext<
                RetrievePartnerMatchReportRequest,
                RetrievePartnerMatchReportResponse,
                PartnerMatchReportEntry>
            context,
        ApiFuture<RetrievePartnerMatchReportResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class RetrievePartnerMatchReportFixedSizeCollection
      extends AbstractFixedSizeCollection<
          RetrievePartnerMatchReportRequest,
          RetrievePartnerMatchReportResponse,
          PartnerMatchReportEntry,
          RetrievePartnerMatchReportPage,
          RetrievePartnerMatchReportFixedSizeCollection> {

    private RetrievePartnerMatchReportFixedSizeCollection(
        @Nullable List<RetrievePartnerMatchReportPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static RetrievePartnerMatchReportFixedSizeCollection createEmptyCollection() {
      return new RetrievePartnerMatchReportFixedSizeCollection(null, 0);
    }

    @Override
    protected RetrievePartnerMatchReportFixedSizeCollection createCollection(
        @Nullable List<RetrievePartnerMatchReportPage> pages, int collectionSize) {
      return new RetrievePartnerMatchReportFixedSizeCollection(pages, collectionSize);
    }
  }
}
