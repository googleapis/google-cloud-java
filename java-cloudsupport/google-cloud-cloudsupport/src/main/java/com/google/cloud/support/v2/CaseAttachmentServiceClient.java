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

package com.google.cloud.support.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2.stub.CaseAttachmentServiceStub;
import com.google.cloud.support.v2.stub.CaseAttachmentServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service to manage file attachment for Google Cloud support cases.
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
 * try (CaseAttachmentServiceClient caseAttachmentServiceClient =
 *     CaseAttachmentServiceClient.create()) {
 *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
 *   for (Attachment element : caseAttachmentServiceClient.listAttachments(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CaseAttachmentServiceClient object to clean up
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
 *      <td><p> ListAttachments</td>
 *      <td><p> Retrieve all attachments associated with a support case.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAttachments(ListAttachmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAttachments(CaseName parent)
 *           <li><p> listAttachments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAttachmentsPagedCallable()
 *           <li><p> listAttachmentsCallable()
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
 * <p>This class can be customized by passing in a custom instance of CaseAttachmentServiceSettings
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
 * CaseAttachmentServiceSettings caseAttachmentServiceSettings =
 *     CaseAttachmentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CaseAttachmentServiceClient caseAttachmentServiceClient =
 *     CaseAttachmentServiceClient.create(caseAttachmentServiceSettings);
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
 * CaseAttachmentServiceSettings caseAttachmentServiceSettings =
 *     CaseAttachmentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CaseAttachmentServiceClient caseAttachmentServiceClient =
 *     CaseAttachmentServiceClient.create(caseAttachmentServiceSettings);
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
 * CaseAttachmentServiceSettings caseAttachmentServiceSettings =
 *     CaseAttachmentServiceSettings.newHttpJsonBuilder().build();
 * CaseAttachmentServiceClient caseAttachmentServiceClient =
 *     CaseAttachmentServiceClient.create(caseAttachmentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CaseAttachmentServiceClient implements BackgroundResource {
  private final CaseAttachmentServiceSettings settings;
  private final CaseAttachmentServiceStub stub;

  /** Constructs an instance of CaseAttachmentServiceClient with default settings. */
  public static final CaseAttachmentServiceClient create() throws IOException {
    return create(CaseAttachmentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CaseAttachmentServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CaseAttachmentServiceClient create(CaseAttachmentServiceSettings settings)
      throws IOException {
    return new CaseAttachmentServiceClient(settings);
  }

  /**
   * Constructs an instance of CaseAttachmentServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CaseAttachmentServiceSettings).
   */
  public static final CaseAttachmentServiceClient create(CaseAttachmentServiceStub stub) {
    return new CaseAttachmentServiceClient(stub);
  }

  /**
   * Constructs an instance of CaseAttachmentServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CaseAttachmentServiceClient(CaseAttachmentServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CaseAttachmentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CaseAttachmentServiceClient(CaseAttachmentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CaseAttachmentServiceSettings getSettings() {
    return settings;
  }

  public CaseAttachmentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all attachments associated with a support case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseAttachmentServiceClient caseAttachmentServiceClient =
   *     CaseAttachmentServiceClient.create()) {
   *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
   *   for (Attachment element : caseAttachmentServiceClient.listAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of Case object for which attachments should be
   *     listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachmentsPagedResponse listAttachments(CaseName parent) {
    ListAttachmentsRequest request =
        ListAttachmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all attachments associated with a support case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseAttachmentServiceClient caseAttachmentServiceClient =
   *     CaseAttachmentServiceClient.create()) {
   *   String parent = CaseName.ofOrganizationCaseName("[ORGANIZATION]", "[CASE]").toString();
   *   for (Attachment element : caseAttachmentServiceClient.listAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of Case object for which attachments should be
   *     listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachmentsPagedResponse listAttachments(String parent) {
    ListAttachmentsRequest request = ListAttachmentsRequest.newBuilder().setParent(parent).build();
    return listAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all attachments associated with a support case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseAttachmentServiceClient caseAttachmentServiceClient =
   *     CaseAttachmentServiceClient.create()) {
   *   ListAttachmentsRequest request =
   *       ListAttachmentsRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Attachment element : caseAttachmentServiceClient.listAttachments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttachmentsPagedResponse listAttachments(ListAttachmentsRequest request) {
    return listAttachmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all attachments associated with a support case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseAttachmentServiceClient caseAttachmentServiceClient =
   *     CaseAttachmentServiceClient.create()) {
   *   ListAttachmentsRequest request =
   *       ListAttachmentsRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Attachment> future =
   *       caseAttachmentServiceClient.listAttachmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Attachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAttachmentsRequest, ListAttachmentsPagedResponse>
      listAttachmentsPagedCallable() {
    return stub.listAttachmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all attachments associated with a support case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseAttachmentServiceClient caseAttachmentServiceClient =
   *     CaseAttachmentServiceClient.create()) {
   *   ListAttachmentsRequest request =
   *       ListAttachmentsRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAttachmentsResponse response =
   *         caseAttachmentServiceClient.listAttachmentsCallable().call(request);
   *     for (Attachment element : response.getAttachmentsList()) {
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
  public final UnaryCallable<ListAttachmentsRequest, ListAttachmentsResponse>
      listAttachmentsCallable() {
    return stub.listAttachmentsCallable();
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

  public static class ListAttachmentsPagedResponse
      extends AbstractPagedListResponse<
          ListAttachmentsRequest,
          ListAttachmentsResponse,
          Attachment,
          ListAttachmentsPage,
          ListAttachmentsFixedSizeCollection> {

    public static ApiFuture<ListAttachmentsPagedResponse> createAsync(
        PageContext<ListAttachmentsRequest, ListAttachmentsResponse, Attachment> context,
        ApiFuture<ListAttachmentsResponse> futureResponse) {
      ApiFuture<ListAttachmentsPage> futurePage =
          ListAttachmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAttachmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAttachmentsPagedResponse(ListAttachmentsPage page) {
      super(page, ListAttachmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAttachmentsPage
      extends AbstractPage<
          ListAttachmentsRequest, ListAttachmentsResponse, Attachment, ListAttachmentsPage> {

    private ListAttachmentsPage(
        PageContext<ListAttachmentsRequest, ListAttachmentsResponse, Attachment> context,
        ListAttachmentsResponse response) {
      super(context, response);
    }

    private static ListAttachmentsPage createEmptyPage() {
      return new ListAttachmentsPage(null, null);
    }

    @Override
    protected ListAttachmentsPage createPage(
        PageContext<ListAttachmentsRequest, ListAttachmentsResponse, Attachment> context,
        ListAttachmentsResponse response) {
      return new ListAttachmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAttachmentsPage> createPageAsync(
        PageContext<ListAttachmentsRequest, ListAttachmentsResponse, Attachment> context,
        ApiFuture<ListAttachmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAttachmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAttachmentsRequest,
          ListAttachmentsResponse,
          Attachment,
          ListAttachmentsPage,
          ListAttachmentsFixedSizeCollection> {

    private ListAttachmentsFixedSizeCollection(
        List<ListAttachmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAttachmentsFixedSizeCollection createEmptyCollection() {
      return new ListAttachmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAttachmentsFixedSizeCollection createCollection(
        List<ListAttachmentsPage> pages, int collectionSize) {
      return new ListAttachmentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
