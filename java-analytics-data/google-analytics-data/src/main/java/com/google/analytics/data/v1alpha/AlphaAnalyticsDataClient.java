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

package com.google.analytics.data.v1alpha;

import com.google.analytics.data.v1alpha.stub.AlphaAnalyticsDataStub;
import com.google.analytics.data.v1alpha.stub.AlphaAnalyticsDataStubSettings;
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
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Analytics reporting data service.
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
 * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
 *   RunFunnelReportRequest request =
 *       RunFunnelReportRequest.newBuilder()
 *           .setProperty("property-993141291")
 *           .addAllDateRanges(new ArrayList<DateRange>())
 *           .setFunnel(Funnel.newBuilder().build())
 *           .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
 *           .setFunnelNextAction(FunnelNextAction.newBuilder().build())
 *           .addAllSegments(new ArrayList<Segment>())
 *           .setLimit(102976443)
 *           .setDimensionFilter(FilterExpression.newBuilder().build())
 *           .setReturnPropertyQuota(true)
 *           .build();
 *   RunFunnelReportResponse response = alphaAnalyticsDataClient.runFunnelReport(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AlphaAnalyticsDataClient object to clean up resources
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
 *      <td><p> RunFunnelReport</td>
 *      <td><p> Returns a customized funnel report of your Google Analytics event data. The data returned from the API is as a table with columns for the requested dimensions and metrics.
 * <p>  Funnel exploration lets you visualize the steps your users take to complete a task and quickly see how well they are succeeding or failing at each step. For example, how do prospects become shoppers and then become buyers? How do one time buyers become repeat buyers? With this information, you can improve inefficient or abandoned customer journeys. To learn more, see [GA4 Funnel Explorations](https://support.google.com/analytics/answer/9327974).
 * <p>  This method is introduced at alpha stability with the intention of gathering feedback on syntax and capabilities before entering beta. To give your feedback on this API, complete the [Google Analytics Data API Funnel Reporting Feedback](https://docs.google.com/forms/d/e/1FAIpQLSdwOlQDJAUoBiIgUZZ3S_Lwi8gr7Bb0k1jhvc-DEg7Rol3UjA/viewform).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runFunnelReport(RunFunnelReportRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runFunnelReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAudienceList</td>
 *      <td><p> Creates an audience list for later retrieval. This method quickly returns the audience list's resource name and initiates a long running asynchronous request to form an audience list. To list the users in an audience list, first create the audience list through this method and then send the audience resource name to the `QueryAudienceList` method.
 * <p>  See [Creating an Audience List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Lists with examples.
 * <p>  An audience list is a snapshot of the users currently in the audience at the time of audience list creation. Creating audience lists for one audience on different days will return different results as users enter and exit the audience.
 * <p>  Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572. Audience lists contain the users in each audience.
 * <p>  This method is available at beta stability at [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create). To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAudienceListAsync(CreateAudienceListRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAudienceListAsync(PropertyName parent, AudienceList audienceList)
 *           <li><p> createAudienceListAsync(String parent, AudienceList audienceList)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAudienceListOperationCallable()
 *           <li><p> createAudienceListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryAudienceList</td>
 *      <td><p> Retrieves an audience list of users. After creating an audience, the users are not immediately available for listing. First, a request to `CreateAudienceList` is necessary to create an audience list of users, and then second, this method is used to retrieve the users in the audience list.
 * <p>  See [Creating an Audience List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Lists with examples.
 * <p>  Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572.
 * <p>  This method is available at beta stability at [audienceExports.query](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/query). To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryAudienceList(QueryAudienceListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> queryAudienceList(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryAudienceListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SheetExportAudienceList</td>
 *      <td><p> Exports an audience list of users to a Google Sheet. After creating an audience, the users are not immediately available for listing. First, a request to `CreateAudienceList` is necessary to create an audience list of users, and then second, this method is used to export those users in the audience list to a Google Sheet.
 * <p>  See [Creating an Audience List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Lists with examples.
 * <p>  Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572.
 * <p>  This method is introduced at alpha stability with the intention of gathering feedback on syntax and capabilities before entering beta. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> sheetExportAudienceList(SheetExportAudienceListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> sheetExportAudienceList(AudienceListName name)
 *           <li><p> sheetExportAudienceList(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> sheetExportAudienceListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAudienceList</td>
 *      <td><p> Gets configuration metadata about a specific audience list. This method can be used to understand an audience list after it has been created.
 * <p>  See [Creating an Audience List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Lists with examples.
 * <p>  This method is available at beta stability at [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get). To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAudienceList(GetAudienceListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAudienceList(AudienceListName name)
 *           <li><p> getAudienceList(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAudienceListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAudienceLists</td>
 *      <td><p> Lists all audience lists for a property. This method can be used for you to find and reuse existing audience lists rather than creating unnecessary new audience lists. The same audience can have multiple audience lists that represent the list of users that were in an audience on different days.
 * <p>  See [Creating an Audience List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Lists with examples.
 * <p>  This method is available at beta stability at [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list). To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAudienceLists(ListAudienceListsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAudienceLists(PropertyName parent)
 *           <li><p> listAudienceLists(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAudienceListsPagedCallable()
 *           <li><p> listAudienceListsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRecurringAudienceList</td>
 *      <td><p> Creates a recurring audience list. Recurring audience lists produces new audience lists each day. Audience lists are users in an audience at the time of the list's creation.
 * <p>  A recurring audience list ensures that you have audience list based on the most recent data available for use each day. If you manually create audience list, you don't know when an audience list based on an additional day's data is available. This recurring audience list automates the creation of an audience list when an additional day's data is available. You will consume fewer quota tokens by using recurring audience list versus manually creating audience list at various times of day trying to guess when an additional day's data is ready.
 * <p>  This method is introduced at alpha stability with the intention of gathering feedback on syntax and capabilities before entering beta. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRecurringAudienceList(CreateRecurringAudienceListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRecurringAudienceList(PropertyName parent, RecurringAudienceList recurringAudienceList)
 *           <li><p> createRecurringAudienceList(String parent, RecurringAudienceList recurringAudienceList)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRecurringAudienceListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRecurringAudienceList</td>
 *      <td><p> Gets configuration metadata about a specific recurring audience list. This method can be used to understand a recurring audience list's state after it has been created. For example, a recurring audience list resource will generate audience list instances for each day, and this method can be used to get the resource name of the most recent audience list instance.
 * <p>  This method is introduced at alpha stability with the intention of gathering feedback on syntax and capabilities before entering beta. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRecurringAudienceList(GetRecurringAudienceListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRecurringAudienceList(RecurringAudienceListName name)
 *           <li><p> getRecurringAudienceList(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRecurringAudienceListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRecurringAudienceLists</td>
 *      <td><p> Lists all recurring audience lists for a property. This method can be used for you to find and reuse existing recurring audience lists rather than creating unnecessary new recurring audience lists. The same audience can have multiple recurring audience lists that represent different dimension combinations; for example, just the dimension `deviceId` or both the dimensions `deviceId` and `userId`.
 * <p>  This method is introduced at alpha stability with the intention of gathering feedback on syntax and capabilities before entering beta. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRecurringAudienceLists(ListRecurringAudienceListsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRecurringAudienceLists(PropertyName parent)
 *           <li><p> listRecurringAudienceLists(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRecurringAudienceListsPagedCallable()
 *           <li><p> listRecurringAudienceListsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReportTask</td>
 *      <td><p> Initiates the creation of a report task. This method quickly returns a report task and initiates a long running asynchronous request to form a customized report of your Google Analytics event data.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReportTaskAsync(CreateReportTaskRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createReportTaskAsync(PropertyName parent, ReportTask reportTask)
 *           <li><p> createReportTaskAsync(String parent, ReportTask reportTask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReportTaskOperationCallable()
 *           <li><p> createReportTaskCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryReportTask</td>
 *      <td><p> Retrieves a report task's content. After requesting the `CreateReportTask`, you are able to retrieve the report content once the report is ACTIVE. This method will return an error if the report task's state is not `ACTIVE`. A query response will return the tabular row &amp; column values of the report.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryReportTask(QueryReportTaskRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> queryReportTask(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryReportTaskCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetReportTask</td>
 *      <td><p> Gets report metadata about a specific report task. After creating a report task, use this method to check its processing state or inspect its report definition.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReportTask(GetReportTaskRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReportTask(ReportTaskName name)
 *           <li><p> getReportTask(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReportTaskCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReportTasks</td>
 *      <td><p> Lists all report tasks for a property.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReportTasks(ListReportTasksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReportTasks(PropertyName parent)
 *           <li><p> listReportTasks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReportTasksPagedCallable()
 *           <li><p> listReportTasksCallable()
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
 * <p>This class can be customized by passing in a custom instance of AlphaAnalyticsDataSettings to
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
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
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
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
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
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newHttpJsonBuilder().build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AlphaAnalyticsDataClient implements BackgroundResource {
  private final AlphaAnalyticsDataSettings settings;
  private final AlphaAnalyticsDataStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AlphaAnalyticsDataClient with default settings. */
  public static final AlphaAnalyticsDataClient create() throws IOException {
    return create(AlphaAnalyticsDataSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AlphaAnalyticsDataClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AlphaAnalyticsDataClient create(AlphaAnalyticsDataSettings settings)
      throws IOException {
    return new AlphaAnalyticsDataClient(settings);
  }

  /**
   * Constructs an instance of AlphaAnalyticsDataClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AlphaAnalyticsDataSettings).
   */
  public static final AlphaAnalyticsDataClient create(AlphaAnalyticsDataStub stub) {
    return new AlphaAnalyticsDataClient(stub);
  }

  /**
   * Constructs an instance of AlphaAnalyticsDataClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AlphaAnalyticsDataClient(AlphaAnalyticsDataSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AlphaAnalyticsDataStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AlphaAnalyticsDataClient(AlphaAnalyticsDataStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AlphaAnalyticsDataSettings getSettings() {
    return settings;
  }

  public AlphaAnalyticsDataStub getStub() {
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
   * Returns a customized funnel report of your Google Analytics event data. The data returned from
   * the API is as a table with columns for the requested dimensions and metrics.
   *
   * <p>Funnel exploration lets you visualize the steps your users take to complete a task and
   * quickly see how well they are succeeding or failing at each step. For example, how do prospects
   * become shoppers and then become buyers? How do one time buyers become repeat buyers? With this
   * information, you can improve inefficient or abandoned customer journeys. To learn more, see
   * [GA4 Funnel Explorations](https://support.google.com/analytics/answer/9327974).
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Data API Funnel Reporting
   * Feedback](https://docs.google.com/forms/d/e/1FAIpQLSdwOlQDJAUoBiIgUZZ3S_Lwi8gr7Bb0k1jhvc-DEg7Rol3UjA/viewform).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RunFunnelReportRequest request =
   *       RunFunnelReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDateRanges(new ArrayList<DateRange>())
   *           .setFunnel(Funnel.newBuilder().build())
   *           .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
   *           .setFunnelNextAction(FunnelNextAction.newBuilder().build())
   *           .addAllSegments(new ArrayList<Segment>())
   *           .setLimit(102976443)
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setReturnPropertyQuota(true)
   *           .build();
   *   RunFunnelReportResponse response = alphaAnalyticsDataClient.runFunnelReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunFunnelReportResponse runFunnelReport(RunFunnelReportRequest request) {
    return runFunnelReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized funnel report of your Google Analytics event data. The data returned from
   * the API is as a table with columns for the requested dimensions and metrics.
   *
   * <p>Funnel exploration lets you visualize the steps your users take to complete a task and
   * quickly see how well they are succeeding or failing at each step. For example, how do prospects
   * become shoppers and then become buyers? How do one time buyers become repeat buyers? With this
   * information, you can improve inefficient or abandoned customer journeys. To learn more, see
   * [GA4 Funnel Explorations](https://support.google.com/analytics/answer/9327974).
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Data API Funnel Reporting
   * Feedback](https://docs.google.com/forms/d/e/1FAIpQLSdwOlQDJAUoBiIgUZZ3S_Lwi8gr7Bb0k1jhvc-DEg7Rol3UjA/viewform).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RunFunnelReportRequest request =
   *       RunFunnelReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDateRanges(new ArrayList<DateRange>())
   *           .setFunnel(Funnel.newBuilder().build())
   *           .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
   *           .setFunnelNextAction(FunnelNextAction.newBuilder().build())
   *           .addAllSegments(new ArrayList<Segment>())
   *           .setLimit(102976443)
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setReturnPropertyQuota(true)
   *           .build();
   *   ApiFuture<RunFunnelReportResponse> future =
   *       alphaAnalyticsDataClient.runFunnelReportCallable().futureCall(request);
   *   // Do something.
   *   RunFunnelReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportCallable() {
    return stub.runFunnelReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience list for later retrieval. This method quickly returns the audience list's
   * resource name and initiates a long running asynchronous request to form an audience list. To
   * list the users in an audience list, first create the audience list through this method and then
   * send the audience resource name to the `QueryAudienceList` method.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>An audience list is a snapshot of the users currently in the audience at the time of
   * audience list creation. Creating audience lists for one audience on different days will return
   * different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience lists contain the users in each
   * audience.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   AudienceList audienceList = AudienceList.newBuilder().build();
   *   AudienceList response =
   *       alphaAnalyticsDataClient.createAudienceListAsync(parent, audienceList).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this audience list will be created. Format:
   *     `properties/{property}`
   * @param audienceList Required. The audience list to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AudienceList, AudienceListMetadata> createAudienceListAsync(
      PropertyName parent, AudienceList audienceList) {
    CreateAudienceListRequest request =
        CreateAudienceListRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAudienceList(audienceList)
            .build();
    return createAudienceListAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience list for later retrieval. This method quickly returns the audience list's
   * resource name and initiates a long running asynchronous request to form an audience list. To
   * list the users in an audience list, first create the audience list through this method and then
   * send the audience resource name to the `QueryAudienceList` method.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>An audience list is a snapshot of the users currently in the audience at the time of
   * audience list creation. Creating audience lists for one audience on different days will return
   * different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience lists contain the users in each
   * audience.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   AudienceList audienceList = AudienceList.newBuilder().build();
   *   AudienceList response =
   *       alphaAnalyticsDataClient.createAudienceListAsync(parent, audienceList).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this audience list will be created. Format:
   *     `properties/{property}`
   * @param audienceList Required. The audience list to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AudienceList, AudienceListMetadata> createAudienceListAsync(
      String parent, AudienceList audienceList) {
    CreateAudienceListRequest request =
        CreateAudienceListRequest.newBuilder()
            .setParent(parent)
            .setAudienceList(audienceList)
            .build();
    return createAudienceListAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience list for later retrieval. This method quickly returns the audience list's
   * resource name and initiates a long running asynchronous request to form an audience list. To
   * list the users in an audience list, first create the audience list through this method and then
   * send the audience resource name to the `QueryAudienceList` method.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>An audience list is a snapshot of the users currently in the audience at the time of
   * audience list creation. Creating audience lists for one audience on different days will return
   * different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience lists contain the users in each
   * audience.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   CreateAudienceListRequest request =
   *       CreateAudienceListRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAudienceList(AudienceList.newBuilder().build())
   *           .build();
   *   AudienceList response = alphaAnalyticsDataClient.createAudienceListAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AudienceList, AudienceListMetadata> createAudienceListAsync(
      CreateAudienceListRequest request) {
    return createAudienceListOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience list for later retrieval. This method quickly returns the audience list's
   * resource name and initiates a long running asynchronous request to form an audience list. To
   * list the users in an audience list, first create the audience list through this method and then
   * send the audience resource name to the `QueryAudienceList` method.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>An audience list is a snapshot of the users currently in the audience at the time of
   * audience list creation. Creating audience lists for one audience on different days will return
   * different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience lists contain the users in each
   * audience.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   CreateAudienceListRequest request =
   *       CreateAudienceListRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAudienceList(AudienceList.newBuilder().build())
   *           .build();
   *   OperationFuture<AudienceList, AudienceListMetadata> future =
   *       alphaAnalyticsDataClient.createAudienceListOperationCallable().futureCall(request);
   *   // Do something.
   *   AudienceList response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationCallable() {
    return stub.createAudienceListOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience list for later retrieval. This method quickly returns the audience list's
   * resource name and initiates a long running asynchronous request to form an audience list. To
   * list the users in an audience list, first create the audience list through this method and then
   * send the audience resource name to the `QueryAudienceList` method.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>An audience list is a snapshot of the users currently in the audience at the time of
   * audience list creation. Creating audience lists for one audience on different days will return
   * different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience lists contain the users in each
   * audience.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.create](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/create).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   CreateAudienceListRequest request =
   *       CreateAudienceListRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAudienceList(AudienceList.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       alphaAnalyticsDataClient.createAudienceListCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAudienceListRequest, Operation> createAudienceListCallable() {
    return stub.createAudienceListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an audience list of users. After creating an audience, the users are not immediately
   * available for listing. First, a request to `CreateAudienceList` is necessary to create an
   * audience list of users, and then second, this method is used to retrieve the users in the
   * audience list.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.query](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/query).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String name = "name3373707";
   *   QueryAudienceListResponse response = alphaAnalyticsDataClient.queryAudienceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the audience list to retrieve users from. Format:
   *     `properties/{property}/audienceLists/{audience_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryAudienceListResponse queryAudienceList(String name) {
    QueryAudienceListRequest request = QueryAudienceListRequest.newBuilder().setName(name).build();
    return queryAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an audience list of users. After creating an audience, the users are not immediately
   * available for listing. First, a request to `CreateAudienceList` is necessary to create an
   * audience list of users, and then second, this method is used to retrieve the users in the
   * audience list.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.query](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/query).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   QueryAudienceListRequest request =
   *       QueryAudienceListRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .build();
   *   QueryAudienceListResponse response = alphaAnalyticsDataClient.queryAudienceList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryAudienceListResponse queryAudienceList(QueryAudienceListRequest request) {
    return queryAudienceListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an audience list of users. After creating an audience, the users are not immediately
   * available for listing. First, a request to `CreateAudienceList` is necessary to create an
   * audience list of users, and then second, this method is used to retrieve the users in the
   * audience list.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.query](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/query).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   QueryAudienceListRequest request =
   *       QueryAudienceListRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .build();
   *   ApiFuture<QueryAudienceListResponse> future =
   *       alphaAnalyticsDataClient.queryAudienceListCallable().futureCall(request);
   *   // Do something.
   *   QueryAudienceListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListCallable() {
    return stub.queryAudienceListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an audience list of users to a Google Sheet. After creating an audience, the users are
   * not immediately available for listing. First, a request to `CreateAudienceList` is necessary to
   * create an audience list of users, and then second, this method is used to export those users in
   * the audience list to a Google Sheet.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   AudienceListName name = AudienceListName.of("[PROPERTY]", "[AUDIENCE_LIST]");
   *   SheetExportAudienceListResponse response =
   *       alphaAnalyticsDataClient.sheetExportAudienceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the audience list to retrieve users from. Format:
   *     `properties/{property}/audienceLists/{audience_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SheetExportAudienceListResponse sheetExportAudienceList(AudienceListName name) {
    SheetExportAudienceListRequest request =
        SheetExportAudienceListRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return sheetExportAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an audience list of users to a Google Sheet. After creating an audience, the users are
   * not immediately available for listing. First, a request to `CreateAudienceList` is necessary to
   * create an audience list of users, and then second, this method is used to export those users in
   * the audience list to a Google Sheet.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String name = AudienceListName.of("[PROPERTY]", "[AUDIENCE_LIST]").toString();
   *   SheetExportAudienceListResponse response =
   *       alphaAnalyticsDataClient.sheetExportAudienceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the audience list to retrieve users from. Format:
   *     `properties/{property}/audienceLists/{audience_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SheetExportAudienceListResponse sheetExportAudienceList(String name) {
    SheetExportAudienceListRequest request =
        SheetExportAudienceListRequest.newBuilder().setName(name).build();
    return sheetExportAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an audience list of users to a Google Sheet. After creating an audience, the users are
   * not immediately available for listing. First, a request to `CreateAudienceList` is necessary to
   * create an audience list of users, and then second, this method is used to export those users in
   * the audience list to a Google Sheet.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   SheetExportAudienceListRequest request =
   *       SheetExportAudienceListRequest.newBuilder()
   *           .setName(AudienceListName.of("[PROPERTY]", "[AUDIENCE_LIST]").toString())
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .build();
   *   SheetExportAudienceListResponse response =
   *       alphaAnalyticsDataClient.sheetExportAudienceList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SheetExportAudienceListResponse sheetExportAudienceList(
      SheetExportAudienceListRequest request) {
    return sheetExportAudienceListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an audience list of users to a Google Sheet. After creating an audience, the users are
   * not immediately available for listing. First, a request to `CreateAudienceList` is necessary to
   * create an audience list of users, and then second, this method is used to export those users in
   * the audience list to a Google Sheet.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   SheetExportAudienceListRequest request =
   *       SheetExportAudienceListRequest.newBuilder()
   *           .setName(AudienceListName.of("[PROPERTY]", "[AUDIENCE_LIST]").toString())
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .build();
   *   ApiFuture<SheetExportAudienceListResponse> future =
   *       alphaAnalyticsDataClient.sheetExportAudienceListCallable().futureCall(request);
   *   // Do something.
   *   SheetExportAudienceListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListCallable() {
    return stub.sheetExportAudienceListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific audience list. This method can be used to
   * understand an audience list after it has been created.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   AudienceListName name = AudienceListName.of("[PROPERTY]", "[AUDIENCE_LIST]");
   *   AudienceList response = alphaAnalyticsDataClient.getAudienceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The audience list resource name. Format:
   *     `properties/{property}/audienceLists/{audience_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceList getAudienceList(AudienceListName name) {
    GetAudienceListRequest request =
        GetAudienceListRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific audience list. This method can be used to
   * understand an audience list after it has been created.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String name = AudienceListName.of("[PROPERTY]", "[AUDIENCE_LIST]").toString();
   *   AudienceList response = alphaAnalyticsDataClient.getAudienceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The audience list resource name. Format:
   *     `properties/{property}/audienceLists/{audience_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceList getAudienceList(String name) {
    GetAudienceListRequest request = GetAudienceListRequest.newBuilder().setName(name).build();
    return getAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific audience list. This method can be used to
   * understand an audience list after it has been created.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   GetAudienceListRequest request =
   *       GetAudienceListRequest.newBuilder()
   *           .setName(AudienceListName.of("[PROPERTY]", "[AUDIENCE_LIST]").toString())
   *           .build();
   *   AudienceList response = alphaAnalyticsDataClient.getAudienceList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceList getAudienceList(GetAudienceListRequest request) {
    return getAudienceListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific audience list. This method can be used to
   * understand an audience list after it has been created.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.get](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/get).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   GetAudienceListRequest request =
   *       GetAudienceListRequest.newBuilder()
   *           .setName(AudienceListName.of("[PROPERTY]", "[AUDIENCE_LIST]").toString())
   *           .build();
   *   ApiFuture<AudienceList> future =
   *       alphaAnalyticsDataClient.getAudienceListCallable().futureCall(request);
   *   // Do something.
   *   AudienceList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAudienceListRequest, AudienceList> getAudienceListCallable() {
    return stub.getAudienceListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience lists for a property. This method can be used for you to find and reuse
   * existing audience lists rather than creating unnecessary new audience lists. The same audience
   * can have multiple audience lists that represent the list of users that were in an audience on
   * different days.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (AudienceList element : alphaAnalyticsDataClient.listAudienceLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. All audience lists for this property will be listed in the response.
   *     Format: `properties/{property}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceListsPagedResponse listAudienceLists(PropertyName parent) {
    ListAudienceListsRequest request =
        ListAudienceListsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAudienceLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience lists for a property. This method can be used for you to find and reuse
   * existing audience lists rather than creating unnecessary new audience lists. The same audience
   * can have multiple audience lists that represent the list of users that were in an audience on
   * different days.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (AudienceList element : alphaAnalyticsDataClient.listAudienceLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. All audience lists for this property will be listed in the response.
   *     Format: `properties/{property}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceListsPagedResponse listAudienceLists(String parent) {
    ListAudienceListsRequest request =
        ListAudienceListsRequest.newBuilder().setParent(parent).build();
    return listAudienceLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience lists for a property. This method can be used for you to find and reuse
   * existing audience lists rather than creating unnecessary new audience lists. The same audience
   * can have multiple audience lists that represent the list of users that were in an audience on
   * different days.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListAudienceListsRequest request =
   *       ListAudienceListsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AudienceList element :
   *       alphaAnalyticsDataClient.listAudienceLists(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceListsPagedResponse listAudienceLists(ListAudienceListsRequest request) {
    return listAudienceListsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience lists for a property. This method can be used for you to find and reuse
   * existing audience lists rather than creating unnecessary new audience lists. The same audience
   * can have multiple audience lists that represent the list of users that were in an audience on
   * different days.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListAudienceListsRequest request =
   *       ListAudienceListsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AudienceList> future =
   *       alphaAnalyticsDataClient.listAudienceListsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AudienceList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAudienceListsRequest, ListAudienceListsPagedResponse>
      listAudienceListsPagedCallable() {
    return stub.listAudienceListsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience lists for a property. This method can be used for you to find and reuse
   * existing audience lists rather than creating unnecessary new audience lists. The same audience
   * can have multiple audience lists that represent the list of users that were in an audience on
   * different days.
   *
   * <p>See [Creating an Audience
   * List](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Lists with examples.
   *
   * <p>This method is available at beta stability at
   * [audienceExports.list](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties.audienceExports/list).
   * To give your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListAudienceListsRequest request =
   *       ListAudienceListsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAudienceListsResponse response =
   *         alphaAnalyticsDataClient.listAudienceListsCallable().call(request);
   *     for (AudienceList element : response.getAudienceListsList()) {
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
  public final UnaryCallable<ListAudienceListsRequest, ListAudienceListsResponse>
      listAudienceListsCallable() {
    return stub.listAudienceListsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a recurring audience list. Recurring audience lists produces new audience lists each
   * day. Audience lists are users in an audience at the time of the list's creation.
   *
   * <p>A recurring audience list ensures that you have audience list based on the most recent data
   * available for use each day. If you manually create audience list, you don't know when an
   * audience list based on an additional day's data is available. This recurring audience list
   * automates the creation of an audience list when an additional day's data is available. You will
   * consume fewer quota tokens by using recurring audience list versus manually creating audience
   * list at various times of day trying to guess when an additional day's data is ready.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   RecurringAudienceList recurringAudienceList = RecurringAudienceList.newBuilder().build();
   *   RecurringAudienceList response =
   *       alphaAnalyticsDataClient.createRecurringAudienceList(parent, recurringAudienceList);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this recurring audience list will be created.
   *     Format: `properties/{property}`
   * @param recurringAudienceList Required. The recurring audience list to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecurringAudienceList createRecurringAudienceList(
      PropertyName parent, RecurringAudienceList recurringAudienceList) {
    CreateRecurringAudienceListRequest request =
        CreateRecurringAudienceListRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRecurringAudienceList(recurringAudienceList)
            .build();
    return createRecurringAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a recurring audience list. Recurring audience lists produces new audience lists each
   * day. Audience lists are users in an audience at the time of the list's creation.
   *
   * <p>A recurring audience list ensures that you have audience list based on the most recent data
   * available for use each day. If you manually create audience list, you don't know when an
   * audience list based on an additional day's data is available. This recurring audience list
   * automates the creation of an audience list when an additional day's data is available. You will
   * consume fewer quota tokens by using recurring audience list versus manually creating audience
   * list at various times of day trying to guess when an additional day's data is ready.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   RecurringAudienceList recurringAudienceList = RecurringAudienceList.newBuilder().build();
   *   RecurringAudienceList response =
   *       alphaAnalyticsDataClient.createRecurringAudienceList(parent, recurringAudienceList);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this recurring audience list will be created.
   *     Format: `properties/{property}`
   * @param recurringAudienceList Required. The recurring audience list to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecurringAudienceList createRecurringAudienceList(
      String parent, RecurringAudienceList recurringAudienceList) {
    CreateRecurringAudienceListRequest request =
        CreateRecurringAudienceListRequest.newBuilder()
            .setParent(parent)
            .setRecurringAudienceList(recurringAudienceList)
            .build();
    return createRecurringAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a recurring audience list. Recurring audience lists produces new audience lists each
   * day. Audience lists are users in an audience at the time of the list's creation.
   *
   * <p>A recurring audience list ensures that you have audience list based on the most recent data
   * available for use each day. If you manually create audience list, you don't know when an
   * audience list based on an additional day's data is available. This recurring audience list
   * automates the creation of an audience list when an additional day's data is available. You will
   * consume fewer quota tokens by using recurring audience list versus manually creating audience
   * list at various times of day trying to guess when an additional day's data is ready.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   CreateRecurringAudienceListRequest request =
   *       CreateRecurringAudienceListRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setRecurringAudienceList(RecurringAudienceList.newBuilder().build())
   *           .build();
   *   RecurringAudienceList response =
   *       alphaAnalyticsDataClient.createRecurringAudienceList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecurringAudienceList createRecurringAudienceList(
      CreateRecurringAudienceListRequest request) {
    return createRecurringAudienceListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a recurring audience list. Recurring audience lists produces new audience lists each
   * day. Audience lists are users in an audience at the time of the list's creation.
   *
   * <p>A recurring audience list ensures that you have audience list based on the most recent data
   * available for use each day. If you manually create audience list, you don't know when an
   * audience list based on an additional day's data is available. This recurring audience list
   * automates the creation of an audience list when an additional day's data is available. You will
   * consume fewer quota tokens by using recurring audience list versus manually creating audience
   * list at various times of day trying to guess when an additional day's data is ready.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   CreateRecurringAudienceListRequest request =
   *       CreateRecurringAudienceListRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setRecurringAudienceList(RecurringAudienceList.newBuilder().build())
   *           .build();
   *   ApiFuture<RecurringAudienceList> future =
   *       alphaAnalyticsDataClient.createRecurringAudienceListCallable().futureCall(request);
   *   // Do something.
   *   RecurringAudienceList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListCallable() {
    return stub.createRecurringAudienceListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific recurring audience list. This method can be used
   * to understand a recurring audience list's state after it has been created. For example, a
   * recurring audience list resource will generate audience list instances for each day, and this
   * method can be used to get the resource name of the most recent audience list instance.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RecurringAudienceListName name =
   *       RecurringAudienceListName.of("[PROPERTY]", "[RECURRING_AUDIENCE_LIST]");
   *   RecurringAudienceList response = alphaAnalyticsDataClient.getRecurringAudienceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The recurring audience list resource name. Format:
   *     `properties/{property}/recurringAudienceLists/{recurring_audience_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecurringAudienceList getRecurringAudienceList(RecurringAudienceListName name) {
    GetRecurringAudienceListRequest request =
        GetRecurringAudienceListRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRecurringAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific recurring audience list. This method can be used
   * to understand a recurring audience list's state after it has been created. For example, a
   * recurring audience list resource will generate audience list instances for each day, and this
   * method can be used to get the resource name of the most recent audience list instance.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String name =
   *       RecurringAudienceListName.of("[PROPERTY]", "[RECURRING_AUDIENCE_LIST]").toString();
   *   RecurringAudienceList response = alphaAnalyticsDataClient.getRecurringAudienceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The recurring audience list resource name. Format:
   *     `properties/{property}/recurringAudienceLists/{recurring_audience_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecurringAudienceList getRecurringAudienceList(String name) {
    GetRecurringAudienceListRequest request =
        GetRecurringAudienceListRequest.newBuilder().setName(name).build();
    return getRecurringAudienceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific recurring audience list. This method can be used
   * to understand a recurring audience list's state after it has been created. For example, a
   * recurring audience list resource will generate audience list instances for each day, and this
   * method can be used to get the resource name of the most recent audience list instance.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   GetRecurringAudienceListRequest request =
   *       GetRecurringAudienceListRequest.newBuilder()
   *           .setName(
   *               RecurringAudienceListName.of("[PROPERTY]", "[RECURRING_AUDIENCE_LIST]")
   *                   .toString())
   *           .build();
   *   RecurringAudienceList response = alphaAnalyticsDataClient.getRecurringAudienceList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RecurringAudienceList getRecurringAudienceList(
      GetRecurringAudienceListRequest request) {
    return getRecurringAudienceListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific recurring audience list. This method can be used
   * to understand a recurring audience list's state after it has been created. For example, a
   * recurring audience list resource will generate audience list instances for each day, and this
   * method can be used to get the resource name of the most recent audience list instance.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   GetRecurringAudienceListRequest request =
   *       GetRecurringAudienceListRequest.newBuilder()
   *           .setName(
   *               RecurringAudienceListName.of("[PROPERTY]", "[RECURRING_AUDIENCE_LIST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RecurringAudienceList> future =
   *       alphaAnalyticsDataClient.getRecurringAudienceListCallable().futureCall(request);
   *   // Do something.
   *   RecurringAudienceList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListCallable() {
    return stub.getRecurringAudienceListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all recurring audience lists for a property. This method can be used for you to find and
   * reuse existing recurring audience lists rather than creating unnecessary new recurring audience
   * lists. The same audience can have multiple recurring audience lists that represent different
   * dimension combinations; for example, just the dimension `deviceId` or both the dimensions
   * `deviceId` and `userId`.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (RecurringAudienceList element :
   *       alphaAnalyticsDataClient.listRecurringAudienceLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. All recurring audience lists for this property will be listed in the
   *     response. Format: `properties/{property}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecurringAudienceListsPagedResponse listRecurringAudienceLists(
      PropertyName parent) {
    ListRecurringAudienceListsRequest request =
        ListRecurringAudienceListsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRecurringAudienceLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all recurring audience lists for a property. This method can be used for you to find and
   * reuse existing recurring audience lists rather than creating unnecessary new recurring audience
   * lists. The same audience can have multiple recurring audience lists that represent different
   * dimension combinations; for example, just the dimension `deviceId` or both the dimensions
   * `deviceId` and `userId`.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (RecurringAudienceList element :
   *       alphaAnalyticsDataClient.listRecurringAudienceLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. All recurring audience lists for this property will be listed in the
   *     response. Format: `properties/{property}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecurringAudienceListsPagedResponse listRecurringAudienceLists(String parent) {
    ListRecurringAudienceListsRequest request =
        ListRecurringAudienceListsRequest.newBuilder().setParent(parent).build();
    return listRecurringAudienceLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all recurring audience lists for a property. This method can be used for you to find and
   * reuse existing recurring audience lists rather than creating unnecessary new recurring audience
   * lists. The same audience can have multiple recurring audience lists that represent different
   * dimension combinations; for example, just the dimension `deviceId` or both the dimensions
   * `deviceId` and `userId`.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListRecurringAudienceListsRequest request =
   *       ListRecurringAudienceListsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RecurringAudienceList element :
   *       alphaAnalyticsDataClient.listRecurringAudienceLists(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecurringAudienceListsPagedResponse listRecurringAudienceLists(
      ListRecurringAudienceListsRequest request) {
    return listRecurringAudienceListsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all recurring audience lists for a property. This method can be used for you to find and
   * reuse existing recurring audience lists rather than creating unnecessary new recurring audience
   * lists. The same audience can have multiple recurring audience lists that represent different
   * dimension combinations; for example, just the dimension `deviceId` or both the dimensions
   * `deviceId` and `userId`.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListRecurringAudienceListsRequest request =
   *       ListRecurringAudienceListsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RecurringAudienceList> future =
   *       alphaAnalyticsDataClient.listRecurringAudienceListsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RecurringAudienceList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListRecurringAudienceListsRequest, ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsPagedCallable() {
    return stub.listRecurringAudienceListsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all recurring audience lists for a property. This method can be used for you to find and
   * reuse existing recurring audience lists rather than creating unnecessary new recurring audience
   * lists. The same audience can have multiple recurring audience lists that represent different
   * dimension combinations; for example, just the dimension `deviceId` or both the dimensions
   * `deviceId` and `userId`.
   *
   * <p>This method is introduced at alpha stability with the intention of gathering feedback on
   * syntax and capabilities before entering beta. To give your feedback on this API, complete the
   * [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListRecurringAudienceListsRequest request =
   *       ListRecurringAudienceListsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRecurringAudienceListsResponse response =
   *         alphaAnalyticsDataClient.listRecurringAudienceListsCallable().call(request);
   *     for (RecurringAudienceList element : response.getRecurringAudienceListsList()) {
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
  public final UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
      listRecurringAudienceListsCallable() {
    return stub.listRecurringAudienceListsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the creation of a report task. This method quickly returns a report task and
   * initiates a long running asynchronous request to form a customized report of your Google
   * Analytics event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   ReportTask reportTask = ReportTask.newBuilder().build();
   *   ReportTask response =
   *       alphaAnalyticsDataClient.createReportTaskAsync(parent, reportTask).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this report task will be created. Format:
   *     `properties/{propertyId}`
   * @param reportTask Required. The report task configuration to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReportTask, ReportTaskMetadata> createReportTaskAsync(
      PropertyName parent, ReportTask reportTask) {
    CreateReportTaskRequest request =
        CreateReportTaskRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReportTask(reportTask)
            .build();
    return createReportTaskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the creation of a report task. This method quickly returns a report task and
   * initiates a long running asynchronous request to form a customized report of your Google
   * Analytics event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   ReportTask reportTask = ReportTask.newBuilder().build();
   *   ReportTask response =
   *       alphaAnalyticsDataClient.createReportTaskAsync(parent, reportTask).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this report task will be created. Format:
   *     `properties/{propertyId}`
   * @param reportTask Required. The report task configuration to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReportTask, ReportTaskMetadata> createReportTaskAsync(
      String parent, ReportTask reportTask) {
    CreateReportTaskRequest request =
        CreateReportTaskRequest.newBuilder().setParent(parent).setReportTask(reportTask).build();
    return createReportTaskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the creation of a report task. This method quickly returns a report task and
   * initiates a long running asynchronous request to form a customized report of your Google
   * Analytics event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   CreateReportTaskRequest request =
   *       CreateReportTaskRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setReportTask(ReportTask.newBuilder().build())
   *           .build();
   *   ReportTask response = alphaAnalyticsDataClient.createReportTaskAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReportTask, ReportTaskMetadata> createReportTaskAsync(
      CreateReportTaskRequest request) {
    return createReportTaskOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the creation of a report task. This method quickly returns a report task and
   * initiates a long running asynchronous request to form a customized report of your Google
   * Analytics event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   CreateReportTaskRequest request =
   *       CreateReportTaskRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setReportTask(ReportTask.newBuilder().build())
   *           .build();
   *   OperationFuture<ReportTask, ReportTaskMetadata> future =
   *       alphaAnalyticsDataClient.createReportTaskOperationCallable().futureCall(request);
   *   // Do something.
   *   ReportTask response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationCallable() {
    return stub.createReportTaskOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the creation of a report task. This method quickly returns a report task and
   * initiates a long running asynchronous request to form a customized report of your Google
   * Analytics event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   CreateReportTaskRequest request =
   *       CreateReportTaskRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setReportTask(ReportTask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       alphaAnalyticsDataClient.createReportTaskCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReportTaskRequest, Operation> createReportTaskCallable() {
    return stub.createReportTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a report task's content. After requesting the `CreateReportTask`, you are able to
   * retrieve the report content once the report is ACTIVE. This method will return an error if the
   * report task's state is not `ACTIVE`. A query response will return the tabular row &amp; column
   * values of the report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String name = "name3373707";
   *   QueryReportTaskResponse response = alphaAnalyticsDataClient.queryReportTask(name);
   * }
   * }</pre>
   *
   * @param name Required. The report source name. Format:
   *     `properties/{property}/reportTasks/{report}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryReportTaskResponse queryReportTask(String name) {
    QueryReportTaskRequest request = QueryReportTaskRequest.newBuilder().setName(name).build();
    return queryReportTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a report task's content. After requesting the `CreateReportTask`, you are able to
   * retrieve the report content once the report is ACTIVE. This method will return an error if the
   * report task's state is not `ACTIVE`. A query response will return the tabular row &amp; column
   * values of the report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   QueryReportTaskRequest request =
   *       QueryReportTaskRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .build();
   *   QueryReportTaskResponse response = alphaAnalyticsDataClient.queryReportTask(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryReportTaskResponse queryReportTask(QueryReportTaskRequest request) {
    return queryReportTaskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a report task's content. After requesting the `CreateReportTask`, you are able to
   * retrieve the report content once the report is ACTIVE. This method will return an error if the
   * report task's state is not `ACTIVE`. A query response will return the tabular row &amp; column
   * values of the report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   QueryReportTaskRequest request =
   *       QueryReportTaskRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .build();
   *   ApiFuture<QueryReportTaskResponse> future =
   *       alphaAnalyticsDataClient.queryReportTaskCallable().futureCall(request);
   *   // Do something.
   *   QueryReportTaskResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryReportTaskRequest, QueryReportTaskResponse>
      queryReportTaskCallable() {
    return stub.queryReportTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets report metadata about a specific report task. After creating a report task, use this
   * method to check its processing state or inspect its report definition.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ReportTaskName name = ReportTaskName.of("[PROPERTY]", "[REPORT_TASK]");
   *   ReportTask response = alphaAnalyticsDataClient.getReportTask(name);
   * }
   * }</pre>
   *
   * @param name Required. The report task resource name. Format:
   *     `properties/{property}/reportTasks/{report_task}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportTask getReportTask(ReportTaskName name) {
    GetReportTaskRequest request =
        GetReportTaskRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReportTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets report metadata about a specific report task. After creating a report task, use this
   * method to check its processing state or inspect its report definition.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String name = ReportTaskName.of("[PROPERTY]", "[REPORT_TASK]").toString();
   *   ReportTask response = alphaAnalyticsDataClient.getReportTask(name);
   * }
   * }</pre>
   *
   * @param name Required. The report task resource name. Format:
   *     `properties/{property}/reportTasks/{report_task}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportTask getReportTask(String name) {
    GetReportTaskRequest request = GetReportTaskRequest.newBuilder().setName(name).build();
    return getReportTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets report metadata about a specific report task. After creating a report task, use this
   * method to check its processing state or inspect its report definition.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   GetReportTaskRequest request =
   *       GetReportTaskRequest.newBuilder()
   *           .setName(ReportTaskName.of("[PROPERTY]", "[REPORT_TASK]").toString())
   *           .build();
   *   ReportTask response = alphaAnalyticsDataClient.getReportTask(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportTask getReportTask(GetReportTaskRequest request) {
    return getReportTaskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets report metadata about a specific report task. After creating a report task, use this
   * method to check its processing state or inspect its report definition.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   GetReportTaskRequest request =
   *       GetReportTaskRequest.newBuilder()
   *           .setName(ReportTaskName.of("[PROPERTY]", "[REPORT_TASK]").toString())
   *           .build();
   *   ApiFuture<ReportTask> future =
   *       alphaAnalyticsDataClient.getReportTaskCallable().futureCall(request);
   *   // Do something.
   *   ReportTask response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReportTaskRequest, ReportTask> getReportTaskCallable() {
    return stub.getReportTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all report tasks for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (ReportTask element : alphaAnalyticsDataClient.listReportTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. All report tasks for this property will be listed in the response.
   *     Format: `properties/{property}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportTasksPagedResponse listReportTasks(PropertyName parent) {
    ListReportTasksRequest request =
        ListReportTasksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReportTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all report tasks for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (ReportTask element : alphaAnalyticsDataClient.listReportTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. All report tasks for this property will be listed in the response.
   *     Format: `properties/{property}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportTasksPagedResponse listReportTasks(String parent) {
    ListReportTasksRequest request = ListReportTasksRequest.newBuilder().setParent(parent).build();
    return listReportTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all report tasks for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListReportTasksRequest request =
   *       ListReportTasksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ReportTask element : alphaAnalyticsDataClient.listReportTasks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportTasksPagedResponse listReportTasks(ListReportTasksRequest request) {
    return listReportTasksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all report tasks for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListReportTasksRequest request =
   *       ListReportTasksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ReportTask> future =
   *       alphaAnalyticsDataClient.listReportTasksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReportTask element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReportTasksRequest, ListReportTasksPagedResponse>
      listReportTasksPagedCallable() {
    return stub.listReportTasksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all report tasks for a property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   ListReportTasksRequest request =
   *       ListReportTasksRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListReportTasksResponse response =
   *         alphaAnalyticsDataClient.listReportTasksCallable().call(request);
   *     for (ReportTask element : response.getReportTasksList()) {
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
  public final UnaryCallable<ListReportTasksRequest, ListReportTasksResponse>
      listReportTasksCallable() {
    return stub.listReportTasksCallable();
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

  public static class ListAudienceListsPagedResponse
      extends AbstractPagedListResponse<
          ListAudienceListsRequest,
          ListAudienceListsResponse,
          AudienceList,
          ListAudienceListsPage,
          ListAudienceListsFixedSizeCollection> {

    public static ApiFuture<ListAudienceListsPagedResponse> createAsync(
        PageContext<ListAudienceListsRequest, ListAudienceListsResponse, AudienceList> context,
        ApiFuture<ListAudienceListsResponse> futureResponse) {
      ApiFuture<ListAudienceListsPage> futurePage =
          ListAudienceListsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAudienceListsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAudienceListsPagedResponse(ListAudienceListsPage page) {
      super(page, ListAudienceListsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAudienceListsPage
      extends AbstractPage<
          ListAudienceListsRequest,
          ListAudienceListsResponse,
          AudienceList,
          ListAudienceListsPage> {

    private ListAudienceListsPage(
        PageContext<ListAudienceListsRequest, ListAudienceListsResponse, AudienceList> context,
        ListAudienceListsResponse response) {
      super(context, response);
    }

    private static ListAudienceListsPage createEmptyPage() {
      return new ListAudienceListsPage(null, null);
    }

    @Override
    protected ListAudienceListsPage createPage(
        PageContext<ListAudienceListsRequest, ListAudienceListsResponse, AudienceList> context,
        ListAudienceListsResponse response) {
      return new ListAudienceListsPage(context, response);
    }

    @Override
    public ApiFuture<ListAudienceListsPage> createPageAsync(
        PageContext<ListAudienceListsRequest, ListAudienceListsResponse, AudienceList> context,
        ApiFuture<ListAudienceListsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAudienceListsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAudienceListsRequest,
          ListAudienceListsResponse,
          AudienceList,
          ListAudienceListsPage,
          ListAudienceListsFixedSizeCollection> {

    private ListAudienceListsFixedSizeCollection(
        List<ListAudienceListsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAudienceListsFixedSizeCollection createEmptyCollection() {
      return new ListAudienceListsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAudienceListsFixedSizeCollection createCollection(
        List<ListAudienceListsPage> pages, int collectionSize) {
      return new ListAudienceListsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRecurringAudienceListsPagedResponse
      extends AbstractPagedListResponse<
          ListRecurringAudienceListsRequest,
          ListRecurringAudienceListsResponse,
          RecurringAudienceList,
          ListRecurringAudienceListsPage,
          ListRecurringAudienceListsFixedSizeCollection> {

    public static ApiFuture<ListRecurringAudienceListsPagedResponse> createAsync(
        PageContext<
                ListRecurringAudienceListsRequest,
                ListRecurringAudienceListsResponse,
                RecurringAudienceList>
            context,
        ApiFuture<ListRecurringAudienceListsResponse> futureResponse) {
      ApiFuture<ListRecurringAudienceListsPage> futurePage =
          ListRecurringAudienceListsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRecurringAudienceListsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRecurringAudienceListsPagedResponse(ListRecurringAudienceListsPage page) {
      super(page, ListRecurringAudienceListsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRecurringAudienceListsPage
      extends AbstractPage<
          ListRecurringAudienceListsRequest,
          ListRecurringAudienceListsResponse,
          RecurringAudienceList,
          ListRecurringAudienceListsPage> {

    private ListRecurringAudienceListsPage(
        PageContext<
                ListRecurringAudienceListsRequest,
                ListRecurringAudienceListsResponse,
                RecurringAudienceList>
            context,
        ListRecurringAudienceListsResponse response) {
      super(context, response);
    }

    private static ListRecurringAudienceListsPage createEmptyPage() {
      return new ListRecurringAudienceListsPage(null, null);
    }

    @Override
    protected ListRecurringAudienceListsPage createPage(
        PageContext<
                ListRecurringAudienceListsRequest,
                ListRecurringAudienceListsResponse,
                RecurringAudienceList>
            context,
        ListRecurringAudienceListsResponse response) {
      return new ListRecurringAudienceListsPage(context, response);
    }

    @Override
    public ApiFuture<ListRecurringAudienceListsPage> createPageAsync(
        PageContext<
                ListRecurringAudienceListsRequest,
                ListRecurringAudienceListsResponse,
                RecurringAudienceList>
            context,
        ApiFuture<ListRecurringAudienceListsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRecurringAudienceListsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRecurringAudienceListsRequest,
          ListRecurringAudienceListsResponse,
          RecurringAudienceList,
          ListRecurringAudienceListsPage,
          ListRecurringAudienceListsFixedSizeCollection> {

    private ListRecurringAudienceListsFixedSizeCollection(
        List<ListRecurringAudienceListsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRecurringAudienceListsFixedSizeCollection createEmptyCollection() {
      return new ListRecurringAudienceListsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRecurringAudienceListsFixedSizeCollection createCollection(
        List<ListRecurringAudienceListsPage> pages, int collectionSize) {
      return new ListRecurringAudienceListsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReportTasksPagedResponse
      extends AbstractPagedListResponse<
          ListReportTasksRequest,
          ListReportTasksResponse,
          ReportTask,
          ListReportTasksPage,
          ListReportTasksFixedSizeCollection> {

    public static ApiFuture<ListReportTasksPagedResponse> createAsync(
        PageContext<ListReportTasksRequest, ListReportTasksResponse, ReportTask> context,
        ApiFuture<ListReportTasksResponse> futureResponse) {
      ApiFuture<ListReportTasksPage> futurePage =
          ListReportTasksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReportTasksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReportTasksPagedResponse(ListReportTasksPage page) {
      super(page, ListReportTasksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReportTasksPage
      extends AbstractPage<
          ListReportTasksRequest, ListReportTasksResponse, ReportTask, ListReportTasksPage> {

    private ListReportTasksPage(
        PageContext<ListReportTasksRequest, ListReportTasksResponse, ReportTask> context,
        ListReportTasksResponse response) {
      super(context, response);
    }

    private static ListReportTasksPage createEmptyPage() {
      return new ListReportTasksPage(null, null);
    }

    @Override
    protected ListReportTasksPage createPage(
        PageContext<ListReportTasksRequest, ListReportTasksResponse, ReportTask> context,
        ListReportTasksResponse response) {
      return new ListReportTasksPage(context, response);
    }

    @Override
    public ApiFuture<ListReportTasksPage> createPageAsync(
        PageContext<ListReportTasksRequest, ListReportTasksResponse, ReportTask> context,
        ApiFuture<ListReportTasksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReportTasksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReportTasksRequest,
          ListReportTasksResponse,
          ReportTask,
          ListReportTasksPage,
          ListReportTasksFixedSizeCollection> {

    private ListReportTasksFixedSizeCollection(
        List<ListReportTasksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReportTasksFixedSizeCollection createEmptyCollection() {
      return new ListReportTasksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReportTasksFixedSizeCollection createCollection(
        List<ListReportTasksPage> pages, int collectionSize) {
      return new ListReportTasksFixedSizeCollection(pages, collectionSize);
    }
  }
}
