/*
 * Copyright 2022 Google LLC
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

package com.google.dataflow.v1beta3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.dataflow.v1beta3.stub.MessagesV1Beta3Stub;
import com.google.dataflow.v1beta3.stub.MessagesV1Beta3StubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Dataflow Messages API is used for monitoring the progress of Dataflow
 * jobs.
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
 * try (MessagesV1Beta3Client messagesV1Beta3Client = MessagesV1Beta3Client.create()) {
 *   ListJobMessagesRequest request =
 *       ListJobMessagesRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setJobId("jobId101296568")
 *           .setMinimumImportance(JobMessageImportance.forNumber(0))
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .setStartTime(Timestamp.newBuilder().build())
 *           .setEndTime(Timestamp.newBuilder().build())
 *           .setLocation("location1901043637")
 *           .build();
 *   for (JobMessage element : messagesV1Beta3Client.listJobMessages(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MessagesV1Beta3Client object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of MessagesV1Beta3Settings to
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
 * MessagesV1Beta3Settings messagesV1Beta3Settings =
 *     MessagesV1Beta3Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MessagesV1Beta3Client messagesV1Beta3Client =
 *     MessagesV1Beta3Client.create(messagesV1Beta3Settings);
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
 * MessagesV1Beta3Settings messagesV1Beta3Settings =
 *     MessagesV1Beta3Settings.newBuilder().setEndpoint(myEndpoint).build();
 * MessagesV1Beta3Client messagesV1Beta3Client =
 *     MessagesV1Beta3Client.create(messagesV1Beta3Settings);
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
 * MessagesV1Beta3Settings messagesV1Beta3Settings =
 *     MessagesV1Beta3Settings.newHttpJsonBuilder().build();
 * MessagesV1Beta3Client messagesV1Beta3Client =
 *     MessagesV1Beta3Client.create(messagesV1Beta3Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MessagesV1Beta3Client implements BackgroundResource {
  private final MessagesV1Beta3Settings settings;
  private final MessagesV1Beta3Stub stub;

  /** Constructs an instance of MessagesV1Beta3Client with default settings. */
  public static final MessagesV1Beta3Client create() throws IOException {
    return create(MessagesV1Beta3Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of MessagesV1Beta3Client, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MessagesV1Beta3Client create(MessagesV1Beta3Settings settings)
      throws IOException {
    return new MessagesV1Beta3Client(settings);
  }

  /**
   * Constructs an instance of MessagesV1Beta3Client, using the given stub for making calls. This is
   * for advanced usage - prefer using create(MessagesV1Beta3Settings).
   */
  public static final MessagesV1Beta3Client create(MessagesV1Beta3Stub stub) {
    return new MessagesV1Beta3Client(stub);
  }

  /**
   * Constructs an instance of MessagesV1Beta3Client, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MessagesV1Beta3Client(MessagesV1Beta3Settings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MessagesV1Beta3StubSettings) settings.getStubSettings()).createStub();
  }

  protected MessagesV1Beta3Client(MessagesV1Beta3Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MessagesV1Beta3Settings getSettings() {
    return settings;
  }

  public MessagesV1Beta3Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request the job status.
   *
   * <p>To request the status of a job, we recommend using `projects.locations.jobs.messages.list`
   * with a [regional endpoint]
   * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.messages.list` is not recommended, as you can only request the status of jobs
   * that are running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MessagesV1Beta3Client messagesV1Beta3Client = MessagesV1Beta3Client.create()) {
   *   ListJobMessagesRequest request =
   *       ListJobMessagesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setMinimumImportance(JobMessageImportance.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   for (JobMessage element : messagesV1Beta3Client.listJobMessages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListJobMessagesPagedResponse listJobMessages(ListJobMessagesRequest request) {
    return listJobMessagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request the job status.
   *
   * <p>To request the status of a job, we recommend using `projects.locations.jobs.messages.list`
   * with a [regional endpoint]
   * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.messages.list` is not recommended, as you can only request the status of jobs
   * that are running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MessagesV1Beta3Client messagesV1Beta3Client = MessagesV1Beta3Client.create()) {
   *   ListJobMessagesRequest request =
   *       ListJobMessagesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setMinimumImportance(JobMessageImportance.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<JobMessage> future =
   *       messagesV1Beta3Client.listJobMessagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (JobMessage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListJobMessagesRequest, ListJobMessagesPagedResponse>
      listJobMessagesPagedCallable() {
    return stub.listJobMessagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request the job status.
   *
   * <p>To request the status of a job, we recommend using `projects.locations.jobs.messages.list`
   * with a [regional endpoint]
   * (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
   * `projects.jobs.messages.list` is not recommended, as you can only request the status of jobs
   * that are running in `us-central1`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MessagesV1Beta3Client messagesV1Beta3Client = MessagesV1Beta3Client.create()) {
   *   ListJobMessagesRequest request =
   *       ListJobMessagesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setMinimumImportance(JobMessageImportance.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   while (true) {
   *     ListJobMessagesResponse response =
   *         messagesV1Beta3Client.listJobMessagesCallable().call(request);
   *     for (JobMessage element : response.getJobMessagesList()) {
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
  public final UnaryCallable<ListJobMessagesRequest, ListJobMessagesResponse>
      listJobMessagesCallable() {
    return stub.listJobMessagesCallable();
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

  public static class ListJobMessagesPagedResponse
      extends AbstractPagedListResponse<
          ListJobMessagesRequest,
          ListJobMessagesResponse,
          JobMessage,
          ListJobMessagesPage,
          ListJobMessagesFixedSizeCollection> {

    public static ApiFuture<ListJobMessagesPagedResponse> createAsync(
        PageContext<ListJobMessagesRequest, ListJobMessagesResponse, JobMessage> context,
        ApiFuture<ListJobMessagesResponse> futureResponse) {
      ApiFuture<ListJobMessagesPage> futurePage =
          ListJobMessagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListJobMessagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListJobMessagesPagedResponse(ListJobMessagesPage page) {
      super(page, ListJobMessagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListJobMessagesPage
      extends AbstractPage<
          ListJobMessagesRequest, ListJobMessagesResponse, JobMessage, ListJobMessagesPage> {

    private ListJobMessagesPage(
        PageContext<ListJobMessagesRequest, ListJobMessagesResponse, JobMessage> context,
        ListJobMessagesResponse response) {
      super(context, response);
    }

    private static ListJobMessagesPage createEmptyPage() {
      return new ListJobMessagesPage(null, null);
    }

    @Override
    protected ListJobMessagesPage createPage(
        PageContext<ListJobMessagesRequest, ListJobMessagesResponse, JobMessage> context,
        ListJobMessagesResponse response) {
      return new ListJobMessagesPage(context, response);
    }

    @Override
    public ApiFuture<ListJobMessagesPage> createPageAsync(
        PageContext<ListJobMessagesRequest, ListJobMessagesResponse, JobMessage> context,
        ApiFuture<ListJobMessagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListJobMessagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListJobMessagesRequest,
          ListJobMessagesResponse,
          JobMessage,
          ListJobMessagesPage,
          ListJobMessagesFixedSizeCollection> {

    private ListJobMessagesFixedSizeCollection(
        List<ListJobMessagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListJobMessagesFixedSizeCollection createEmptyCollection() {
      return new ListJobMessagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListJobMessagesFixedSizeCollection createCollection(
        List<ListJobMessagesPage> pages, int collectionSize) {
      return new ListJobMessagesFixedSizeCollection(pages, collectionSize);
    }
  }
}
