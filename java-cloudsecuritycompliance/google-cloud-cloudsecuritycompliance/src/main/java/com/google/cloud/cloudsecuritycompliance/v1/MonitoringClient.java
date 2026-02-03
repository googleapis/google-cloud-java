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

package com.google.cloud.cloudsecuritycompliance.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.stub.MonitoringStub;
import com.google.cloud.cloudsecuritycompliance.v1.stub.MonitoringStubSettings;
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
 * Service Description: Service describing handlers for resources
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
 * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
 *   FrameworkComplianceReportName name =
 *       FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
 *           "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");
 *   FrameworkComplianceReport response = monitoringClient.fetchFrameworkComplianceReport(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MonitoringClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListFrameworkComplianceSummaries</td>
 *      <td><p> Lists the framework compliance summary for a given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFrameworkComplianceSummaries(ListFrameworkComplianceSummariesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFrameworkComplianceSummaries(FolderLocationName parent)
 *           <li><p> listFrameworkComplianceSummaries(LocationName parent)
 *           <li><p> listFrameworkComplianceSummaries(OrganizationLocationName parent)
 *           <li><p> listFrameworkComplianceSummaries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFrameworkComplianceSummariesPagedCallable()
 *           <li><p> listFrameworkComplianceSummariesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFindingSummaries</td>
 *      <td><p> Lists the finding summary by category for a given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFindingSummaries(ListFindingSummariesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFindingSummaries(FolderLocationName parent)
 *           <li><p> listFindingSummaries(LocationName parent)
 *           <li><p> listFindingSummaries(OrganizationLocationName parent)
 *           <li><p> listFindingSummaries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFindingSummariesPagedCallable()
 *           <li><p> listFindingSummariesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchFrameworkComplianceReport</td>
 *      <td><p> Fetches the framework compliance report for a given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchFrameworkComplianceReport(FetchFrameworkComplianceReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchFrameworkComplianceReport(FrameworkComplianceReportName name)
 *           <li><p> fetchFrameworkComplianceReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchFrameworkComplianceReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListControlComplianceSummaries</td>
 *      <td><p> Lists the control compliance summary for a given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listControlComplianceSummaries(ListControlComplianceSummariesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listControlComplianceSummaries(FrameworkComplianceReportName parent)
 *           <li><p> listControlComplianceSummaries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listControlComplianceSummariesPagedCallable()
 *           <li><p> listControlComplianceSummariesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AggregateFrameworkComplianceReport</td>
 *      <td><p> Gets the aggregated compliance report over time for a given scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregateFrameworkComplianceReport(AggregateFrameworkComplianceReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> aggregateFrameworkComplianceReport(FrameworkComplianceReportName name)
 *           <li><p> aggregateFrameworkComplianceReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> aggregateFrameworkComplianceReportCallable()
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
 * <p>This class can be customized by passing in a custom instance of MonitoringSettings to
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
 * MonitoringSettings monitoringSettings =
 *     MonitoringSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MonitoringClient monitoringClient = MonitoringClient.create(monitoringSettings);
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
 * MonitoringSettings monitoringSettings =
 *     MonitoringSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MonitoringClient monitoringClient = MonitoringClient.create(monitoringSettings);
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
 * MonitoringSettings monitoringSettings = MonitoringSettings.newHttpJsonBuilder().build();
 * MonitoringClient monitoringClient = MonitoringClient.create(monitoringSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MonitoringClient implements BackgroundResource {
  private final MonitoringSettings settings;
  private final MonitoringStub stub;

  /** Constructs an instance of MonitoringClient with default settings. */
  public static final MonitoringClient create() throws IOException {
    return create(MonitoringSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MonitoringClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MonitoringClient create(MonitoringSettings settings) throws IOException {
    return new MonitoringClient(settings);
  }

  /**
   * Constructs an instance of MonitoringClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(MonitoringSettings).
   */
  public static final MonitoringClient create(MonitoringStub stub) {
    return new MonitoringClient(stub);
  }

  /**
   * Constructs an instance of MonitoringClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected MonitoringClient(MonitoringSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MonitoringStubSettings) settings.getStubSettings()).createStub();
  }

  protected MonitoringClient(MonitoringStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MonitoringSettings getSettings() {
    return settings;
  }

  public MonitoringStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (FrameworkComplianceSummary element :
   *       monitoringClient.listFrameworkComplianceSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework compliance summary.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkComplianceSummariesPagedResponse listFrameworkComplianceSummaries(
      FolderLocationName parent) {
    ListFrameworkComplianceSummariesRequest request =
        ListFrameworkComplianceSummariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFrameworkComplianceSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (FrameworkComplianceSummary element :
   *       monitoringClient.listFrameworkComplianceSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework compliance summary.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkComplianceSummariesPagedResponse listFrameworkComplianceSummaries(
      LocationName parent) {
    ListFrameworkComplianceSummariesRequest request =
        ListFrameworkComplianceSummariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFrameworkComplianceSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (FrameworkComplianceSummary element :
   *       monitoringClient.listFrameworkComplianceSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework compliance summary.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkComplianceSummariesPagedResponse listFrameworkComplianceSummaries(
      OrganizationLocationName parent) {
    ListFrameworkComplianceSummariesRequest request =
        ListFrameworkComplianceSummariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFrameworkComplianceSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (FrameworkComplianceSummary element :
   *       monitoringClient.listFrameworkComplianceSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework compliance summary.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkComplianceSummariesPagedResponse listFrameworkComplianceSummaries(
      String parent) {
    ListFrameworkComplianceSummariesRequest request =
        ListFrameworkComplianceSummariesRequest.newBuilder().setParent(parent).build();
    return listFrameworkComplianceSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListFrameworkComplianceSummariesRequest request =
   *       ListFrameworkComplianceSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (FrameworkComplianceSummary element :
   *       monitoringClient.listFrameworkComplianceSummaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkComplianceSummariesPagedResponse listFrameworkComplianceSummaries(
      ListFrameworkComplianceSummariesRequest request) {
    return listFrameworkComplianceSummariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListFrameworkComplianceSummariesRequest request =
   *       ListFrameworkComplianceSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<FrameworkComplianceSummary> future =
   *       monitoringClient.listFrameworkComplianceSummariesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FrameworkComplianceSummary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesPagedResponse>
      listFrameworkComplianceSummariesPagedCallable() {
    return stub.listFrameworkComplianceSummariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListFrameworkComplianceSummariesRequest request =
   *       ListFrameworkComplianceSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListFrameworkComplianceSummariesResponse response =
   *         monitoringClient.listFrameworkComplianceSummariesCallable().call(request);
   *     for (FrameworkComplianceSummary element : response.getFrameworkComplianceSummariesList()) {
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
  public final UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
      listFrameworkComplianceSummariesCallable() {
    return stub.listFrameworkComplianceSummariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the finding summary by category for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (FindingSummary element : monitoringClient.listFindingSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework overview page.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingSummariesPagedResponse listFindingSummaries(FolderLocationName parent) {
    ListFindingSummariesRequest request =
        ListFindingSummariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFindingSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the finding summary by category for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (FindingSummary element : monitoringClient.listFindingSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework overview page.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingSummariesPagedResponse listFindingSummaries(LocationName parent) {
    ListFindingSummariesRequest request =
        ListFindingSummariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFindingSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the finding summary by category for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (FindingSummary element : monitoringClient.listFindingSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework overview page.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingSummariesPagedResponse listFindingSummaries(
      OrganizationLocationName parent) {
    ListFindingSummariesRequest request =
        ListFindingSummariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFindingSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the finding summary by category for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (FindingSummary element : monitoringClient.listFindingSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework overview page.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingSummariesPagedResponse listFindingSummaries(String parent) {
    ListFindingSummariesRequest request =
        ListFindingSummariesRequest.newBuilder().setParent(parent).build();
    return listFindingSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the finding summary by category for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListFindingSummariesRequest request =
   *       ListFindingSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   for (FindingSummary element : monitoringClient.listFindingSummaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingSummariesPagedResponse listFindingSummaries(
      ListFindingSummariesRequest request) {
    return listFindingSummariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the finding summary by category for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListFindingSummariesRequest request =
   *       ListFindingSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<FindingSummary> future =
   *       monitoringClient.listFindingSummariesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FindingSummary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesPagedResponse>
      listFindingSummariesPagedCallable() {
    return stub.listFindingSummariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the finding summary by category for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListFindingSummariesRequest request =
   *       ListFindingSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListFindingSummariesResponse response =
   *         monitoringClient.listFindingSummariesCallable().call(request);
   *     for (FindingSummary element : response.getFindingSummariesList()) {
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
  public final UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesResponse>
      listFindingSummariesCallable() {
    return stub.listFindingSummariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the framework compliance report for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   FrameworkComplianceReportName name =
   *       FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *           "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");
   *   FrameworkComplianceReport response = monitoringClient.fetchFrameworkComplianceReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the framework compliance report to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkComplianceReport fetchFrameworkComplianceReport(
      FrameworkComplianceReportName name) {
    FetchFrameworkComplianceReportRequest request =
        FetchFrameworkComplianceReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return fetchFrameworkComplianceReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the framework compliance report for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   String name =
   *       FrameworkComplianceReportName.ofProjectLocationFrameworkComplianceReportName(
   *               "[PROJECT]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *           .toString();
   *   FrameworkComplianceReport response = monitoringClient.fetchFrameworkComplianceReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the framework compliance report to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkComplianceReport fetchFrameworkComplianceReport(String name) {
    FetchFrameworkComplianceReportRequest request =
        FetchFrameworkComplianceReportRequest.newBuilder().setName(name).build();
    return fetchFrameworkComplianceReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the framework compliance report for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   FetchFrameworkComplianceReportRequest request =
   *       FetchFrameworkComplianceReportRequest.newBuilder()
   *           .setName(
   *               FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *                   .toString())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   FrameworkComplianceReport response = monitoringClient.fetchFrameworkComplianceReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkComplianceReport fetchFrameworkComplianceReport(
      FetchFrameworkComplianceReportRequest request) {
    return fetchFrameworkComplianceReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the framework compliance report for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   FetchFrameworkComplianceReportRequest request =
   *       FetchFrameworkComplianceReportRequest.newBuilder()
   *           .setName(
   *               FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *                   .toString())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<FrameworkComplianceReport> future =
   *       monitoringClient.fetchFrameworkComplianceReportCallable().futureCall(request);
   *   // Do something.
   *   FrameworkComplianceReport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportCallable() {
    return stub.fetchFrameworkComplianceReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the control compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   FrameworkComplianceReportName parent =
   *       FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *           "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");
   *   for (ControlComplianceSummary element :
   *       monitoringClient.listControlComplianceSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework overview page.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlComplianceSummariesPagedResponse listControlComplianceSummaries(
      FrameworkComplianceReportName parent) {
    ListControlComplianceSummariesRequest request =
        ListControlComplianceSummariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listControlComplianceSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the control compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   String parent =
   *       FrameworkComplianceReportName.ofProjectLocationFrameworkComplianceReportName(
   *               "[PROJECT]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *           .toString();
   *   for (ControlComplianceSummary element :
   *       monitoringClient.listControlComplianceSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for the framework overview page.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlComplianceSummariesPagedResponse listControlComplianceSummaries(
      String parent) {
    ListControlComplianceSummariesRequest request =
        ListControlComplianceSummariesRequest.newBuilder().setParent(parent).build();
    return listControlComplianceSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the control compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListControlComplianceSummariesRequest request =
   *       ListControlComplianceSummariesRequest.newBuilder()
   *           .setParent(
   *               FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *                   .toString())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ControlComplianceSummary element :
   *       monitoringClient.listControlComplianceSummaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlComplianceSummariesPagedResponse listControlComplianceSummaries(
      ListControlComplianceSummariesRequest request) {
    return listControlComplianceSummariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the control compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListControlComplianceSummariesRequest request =
   *       ListControlComplianceSummariesRequest.newBuilder()
   *           .setParent(
   *               FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *                   .toString())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ControlComplianceSummary> future =
   *       monitoringClient.listControlComplianceSummariesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ControlComplianceSummary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesPagedResponse>
      listControlComplianceSummariesPagedCallable() {
    return stub.listControlComplianceSummariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the control compliance summary for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListControlComplianceSummariesRequest request =
   *       ListControlComplianceSummariesRequest.newBuilder()
   *           .setParent(
   *               FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *                   .toString())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListControlComplianceSummariesResponse response =
   *         monitoringClient.listControlComplianceSummariesCallable().call(request);
   *     for (ControlComplianceSummary element : response.getControlComplianceSummariesList()) {
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
  public final UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
      listControlComplianceSummariesCallable() {
    return stub.listControlComplianceSummariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the aggregated compliance report over time for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   FrameworkComplianceReportName name =
   *       FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *           "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");
   *   AggregateFrameworkComplianceReportResponse response =
   *       monitoringClient.aggregateFrameworkComplianceReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the aggregated compliance report over time to retrieve.
   *     <p>The supported format is:
   *     `organizations/{organization_id}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateFrameworkComplianceReportResponse aggregateFrameworkComplianceReport(
      FrameworkComplianceReportName name) {
    AggregateFrameworkComplianceReportRequest request =
        AggregateFrameworkComplianceReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return aggregateFrameworkComplianceReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the aggregated compliance report over time for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   String name =
   *       FrameworkComplianceReportName.ofProjectLocationFrameworkComplianceReportName(
   *               "[PROJECT]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *           .toString();
   *   AggregateFrameworkComplianceReportResponse response =
   *       monitoringClient.aggregateFrameworkComplianceReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the aggregated compliance report over time to retrieve.
   *     <p>The supported format is:
   *     `organizations/{organization_id}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateFrameworkComplianceReportResponse aggregateFrameworkComplianceReport(
      String name) {
    AggregateFrameworkComplianceReportRequest request =
        AggregateFrameworkComplianceReportRequest.newBuilder().setName(name).build();
    return aggregateFrameworkComplianceReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the aggregated compliance report over time for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   AggregateFrameworkComplianceReportRequest request =
   *       AggregateFrameworkComplianceReportRequest.newBuilder()
   *           .setName(
   *               FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *                   .toString())
   *           .setInterval(Interval.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   AggregateFrameworkComplianceReportResponse response =
   *       monitoringClient.aggregateFrameworkComplianceReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateFrameworkComplianceReportResponse aggregateFrameworkComplianceReport(
      AggregateFrameworkComplianceReportRequest request) {
    return aggregateFrameworkComplianceReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the aggregated compliance report over time for a given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   AggregateFrameworkComplianceReportRequest request =
   *       AggregateFrameworkComplianceReportRequest.newBuilder()
   *           .setName(
   *               FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
   *                   .toString())
   *           .setInterval(Interval.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<AggregateFrameworkComplianceReportResponse> future =
   *       monitoringClient.aggregateFrameworkComplianceReportCallable().futureCall(request);
   *   // Do something.
   *   AggregateFrameworkComplianceReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportCallable() {
    return stub.aggregateFrameworkComplianceReportCallable();
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
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : monitoringClient.listLocations(request).iterateAll()) {
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
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       monitoringClient.listLocationsPagedCallable().futureCall(request);
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
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = monitoringClient.listLocationsCallable().call(request);
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
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = monitoringClient.getLocation(request);
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
   * try (MonitoringClient monitoringClient = MonitoringClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = monitoringClient.getLocationCallable().futureCall(request);
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

  public static class ListFrameworkComplianceSummariesPagedResponse
      extends AbstractPagedListResponse<
          ListFrameworkComplianceSummariesRequest,
          ListFrameworkComplianceSummariesResponse,
          FrameworkComplianceSummary,
          ListFrameworkComplianceSummariesPage,
          ListFrameworkComplianceSummariesFixedSizeCollection> {

    public static ApiFuture<ListFrameworkComplianceSummariesPagedResponse> createAsync(
        PageContext<
                ListFrameworkComplianceSummariesRequest,
                ListFrameworkComplianceSummariesResponse,
                FrameworkComplianceSummary>
            context,
        ApiFuture<ListFrameworkComplianceSummariesResponse> futureResponse) {
      ApiFuture<ListFrameworkComplianceSummariesPage> futurePage =
          ListFrameworkComplianceSummariesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFrameworkComplianceSummariesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFrameworkComplianceSummariesPagedResponse(
        ListFrameworkComplianceSummariesPage page) {
      super(page, ListFrameworkComplianceSummariesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFrameworkComplianceSummariesPage
      extends AbstractPage<
          ListFrameworkComplianceSummariesRequest,
          ListFrameworkComplianceSummariesResponse,
          FrameworkComplianceSummary,
          ListFrameworkComplianceSummariesPage> {

    private ListFrameworkComplianceSummariesPage(
        PageContext<
                ListFrameworkComplianceSummariesRequest,
                ListFrameworkComplianceSummariesResponse,
                FrameworkComplianceSummary>
            context,
        ListFrameworkComplianceSummariesResponse response) {
      super(context, response);
    }

    private static ListFrameworkComplianceSummariesPage createEmptyPage() {
      return new ListFrameworkComplianceSummariesPage(null, null);
    }

    @Override
    protected ListFrameworkComplianceSummariesPage createPage(
        PageContext<
                ListFrameworkComplianceSummariesRequest,
                ListFrameworkComplianceSummariesResponse,
                FrameworkComplianceSummary>
            context,
        ListFrameworkComplianceSummariesResponse response) {
      return new ListFrameworkComplianceSummariesPage(context, response);
    }

    @Override
    public ApiFuture<ListFrameworkComplianceSummariesPage> createPageAsync(
        PageContext<
                ListFrameworkComplianceSummariesRequest,
                ListFrameworkComplianceSummariesResponse,
                FrameworkComplianceSummary>
            context,
        ApiFuture<ListFrameworkComplianceSummariesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFrameworkComplianceSummariesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFrameworkComplianceSummariesRequest,
          ListFrameworkComplianceSummariesResponse,
          FrameworkComplianceSummary,
          ListFrameworkComplianceSummariesPage,
          ListFrameworkComplianceSummariesFixedSizeCollection> {

    private ListFrameworkComplianceSummariesFixedSizeCollection(
        List<ListFrameworkComplianceSummariesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFrameworkComplianceSummariesFixedSizeCollection createEmptyCollection() {
      return new ListFrameworkComplianceSummariesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFrameworkComplianceSummariesFixedSizeCollection createCollection(
        List<ListFrameworkComplianceSummariesPage> pages, int collectionSize) {
      return new ListFrameworkComplianceSummariesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFindingSummariesPagedResponse
      extends AbstractPagedListResponse<
          ListFindingSummariesRequest,
          ListFindingSummariesResponse,
          FindingSummary,
          ListFindingSummariesPage,
          ListFindingSummariesFixedSizeCollection> {

    public static ApiFuture<ListFindingSummariesPagedResponse> createAsync(
        PageContext<ListFindingSummariesRequest, ListFindingSummariesResponse, FindingSummary>
            context,
        ApiFuture<ListFindingSummariesResponse> futureResponse) {
      ApiFuture<ListFindingSummariesPage> futurePage =
          ListFindingSummariesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFindingSummariesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFindingSummariesPagedResponse(ListFindingSummariesPage page) {
      super(page, ListFindingSummariesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFindingSummariesPage
      extends AbstractPage<
          ListFindingSummariesRequest,
          ListFindingSummariesResponse,
          FindingSummary,
          ListFindingSummariesPage> {

    private ListFindingSummariesPage(
        PageContext<ListFindingSummariesRequest, ListFindingSummariesResponse, FindingSummary>
            context,
        ListFindingSummariesResponse response) {
      super(context, response);
    }

    private static ListFindingSummariesPage createEmptyPage() {
      return new ListFindingSummariesPage(null, null);
    }

    @Override
    protected ListFindingSummariesPage createPage(
        PageContext<ListFindingSummariesRequest, ListFindingSummariesResponse, FindingSummary>
            context,
        ListFindingSummariesResponse response) {
      return new ListFindingSummariesPage(context, response);
    }

    @Override
    public ApiFuture<ListFindingSummariesPage> createPageAsync(
        PageContext<ListFindingSummariesRequest, ListFindingSummariesResponse, FindingSummary>
            context,
        ApiFuture<ListFindingSummariesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFindingSummariesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFindingSummariesRequest,
          ListFindingSummariesResponse,
          FindingSummary,
          ListFindingSummariesPage,
          ListFindingSummariesFixedSizeCollection> {

    private ListFindingSummariesFixedSizeCollection(
        List<ListFindingSummariesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFindingSummariesFixedSizeCollection createEmptyCollection() {
      return new ListFindingSummariesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFindingSummariesFixedSizeCollection createCollection(
        List<ListFindingSummariesPage> pages, int collectionSize) {
      return new ListFindingSummariesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListControlComplianceSummariesPagedResponse
      extends AbstractPagedListResponse<
          ListControlComplianceSummariesRequest,
          ListControlComplianceSummariesResponse,
          ControlComplianceSummary,
          ListControlComplianceSummariesPage,
          ListControlComplianceSummariesFixedSizeCollection> {

    public static ApiFuture<ListControlComplianceSummariesPagedResponse> createAsync(
        PageContext<
                ListControlComplianceSummariesRequest,
                ListControlComplianceSummariesResponse,
                ControlComplianceSummary>
            context,
        ApiFuture<ListControlComplianceSummariesResponse> futureResponse) {
      ApiFuture<ListControlComplianceSummariesPage> futurePage =
          ListControlComplianceSummariesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListControlComplianceSummariesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListControlComplianceSummariesPagedResponse(ListControlComplianceSummariesPage page) {
      super(page, ListControlComplianceSummariesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListControlComplianceSummariesPage
      extends AbstractPage<
          ListControlComplianceSummariesRequest,
          ListControlComplianceSummariesResponse,
          ControlComplianceSummary,
          ListControlComplianceSummariesPage> {

    private ListControlComplianceSummariesPage(
        PageContext<
                ListControlComplianceSummariesRequest,
                ListControlComplianceSummariesResponse,
                ControlComplianceSummary>
            context,
        ListControlComplianceSummariesResponse response) {
      super(context, response);
    }

    private static ListControlComplianceSummariesPage createEmptyPage() {
      return new ListControlComplianceSummariesPage(null, null);
    }

    @Override
    protected ListControlComplianceSummariesPage createPage(
        PageContext<
                ListControlComplianceSummariesRequest,
                ListControlComplianceSummariesResponse,
                ControlComplianceSummary>
            context,
        ListControlComplianceSummariesResponse response) {
      return new ListControlComplianceSummariesPage(context, response);
    }

    @Override
    public ApiFuture<ListControlComplianceSummariesPage> createPageAsync(
        PageContext<
                ListControlComplianceSummariesRequest,
                ListControlComplianceSummariesResponse,
                ControlComplianceSummary>
            context,
        ApiFuture<ListControlComplianceSummariesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListControlComplianceSummariesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListControlComplianceSummariesRequest,
          ListControlComplianceSummariesResponse,
          ControlComplianceSummary,
          ListControlComplianceSummariesPage,
          ListControlComplianceSummariesFixedSizeCollection> {

    private ListControlComplianceSummariesFixedSizeCollection(
        List<ListControlComplianceSummariesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListControlComplianceSummariesFixedSizeCollection createEmptyCollection() {
      return new ListControlComplianceSummariesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListControlComplianceSummariesFixedSizeCollection createCollection(
        List<ListControlComplianceSummariesPage> pages, int collectionSize) {
      return new ListControlComplianceSummariesFixedSizeCollection(pages, collectionSize);
    }
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
