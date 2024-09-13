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

package com.google.cloud.devtools.containeranalysis.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.GrafeasV1Beta1Stub;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.GrafeasV1Beta1StubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import io.grafeas.v1beta1.BatchCreateNotesRequest;
import io.grafeas.v1beta1.BatchCreateNotesResponse;
import io.grafeas.v1beta1.BatchCreateOccurrencesRequest;
import io.grafeas.v1beta1.BatchCreateOccurrencesResponse;
import io.grafeas.v1beta1.CreateNoteRequest;
import io.grafeas.v1beta1.CreateOccurrenceRequest;
import io.grafeas.v1beta1.DeleteNoteRequest;
import io.grafeas.v1beta1.DeleteOccurrenceRequest;
import io.grafeas.v1beta1.GetNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceRequest;
import io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesResponse;
import io.grafeas.v1beta1.ListNotesRequest;
import io.grafeas.v1beta1.ListNotesResponse;
import io.grafeas.v1beta1.ListOccurrencesRequest;
import io.grafeas.v1beta1.ListOccurrencesResponse;
import io.grafeas.v1beta1.Note;
import io.grafeas.v1beta1.Occurrence;
import io.grafeas.v1beta1.UpdateNoteRequest;
import io.grafeas.v1beta1.UpdateOccurrenceRequest;
import io.grafeas.v1beta1.VulnerabilityOccurrencesSummary;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: [Grafeas](grafeas.io) API.
 *
 * <p>Retrieves analysis results of Cloud components such as Docker container images.
 *
 * <p>Analysis results are stored as a series of occurrences. An `Occurrence` contains information
 * about a specific analysis instance on a resource. An occurrence refers to a `Note`. A note
 * contains details describing the analysis and is generally stored in a separate project, called a
 * `Provider`. Multiple occurrences can refer to the same note.
 *
 * <p>For example, an SSL vulnerability could affect multiple images. In this case, there would be
 * one note for the vulnerability and an occurrence for each image with the vulnerability referring
 * to that note.
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
 * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
 *   GetOccurrenceRequest request =
 *       GetOccurrenceRequest.newBuilder().setName("name3373707").build();
 *   Occurrence response = grafeasV1Beta1Client.getOccurrence(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GrafeasV1Beta1Client object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetOccurrence</td>
 *      <td><p> Gets the specified occurrence.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOccurrence(GetOccurrenceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOccurrenceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOccurrences</td>
 *      <td><p> Lists occurrences for the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOccurrences(ListOccurrencesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOccurrencesPagedCallable()
 *           <li><p> listOccurrencesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteOccurrence</td>
 *      <td><p> Deletes the specified occurrence. For example, use this method to delete an occurrence when the occurrence is no longer applicable for the given resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteOccurrence(DeleteOccurrenceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOccurrenceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateOccurrence</td>
 *      <td><p> Creates a new occurrence.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOccurrence(CreateOccurrenceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOccurrenceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateOccurrences</td>
 *      <td><p> Creates new occurrences in batch.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateOccurrences(BatchCreateOccurrencesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateOccurrencesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateOccurrence</td>
 *      <td><p> Updates the specified occurrence.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateOccurrence(UpdateOccurrenceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOccurrenceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOccurrenceNote</td>
 *      <td><p> Gets the note attached to the specified occurrence. Consumer projects can use this method to get a note that belongs to a provider project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOccurrenceNote(GetOccurrenceNoteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOccurrenceNoteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNote</td>
 *      <td><p> Gets the specified note.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNote(GetNoteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNoteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNotes</td>
 *      <td><p> Lists notes for the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNotes(ListNotesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNotesPagedCallable()
 *           <li><p> listNotesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNote</td>
 *      <td><p> Deletes the specified note.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNote(DeleteNoteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNoteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNote</td>
 *      <td><p> Creates a new note.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNote(CreateNoteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNoteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateNotes</td>
 *      <td><p> Creates new notes in batch.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateNotes(BatchCreateNotesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateNotesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNote</td>
 *      <td><p> Updates the specified note.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNote(UpdateNoteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNoteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNoteOccurrences</td>
 *      <td><p> Lists occurrences referencing the specified note. Provider projects can use this method to get all occurrences across consumer projects referencing the specified note.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNoteOccurrences(ListNoteOccurrencesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNoteOccurrencesPagedCallable()
 *           <li><p> listNoteOccurrencesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVulnerabilityOccurrencesSummary</td>
 *      <td><p> Gets a summary of the number and severity of occurrences.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVulnerabilityOccurrencesSummary(GetVulnerabilityOccurrencesSummaryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVulnerabilityOccurrencesSummaryCallable()
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
 * <p>This class can be customized by passing in a custom instance of GrafeasV1Beta1Settings to
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
 * GrafeasV1Beta1Settings grafeasV1Beta1Settings =
 *     GrafeasV1Beta1Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create(grafeasV1Beta1Settings);
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
 * GrafeasV1Beta1Settings grafeasV1Beta1Settings =
 *     GrafeasV1Beta1Settings.newBuilder().setEndpoint(myEndpoint).build();
 * GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create(grafeasV1Beta1Settings);
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
 * GrafeasV1Beta1Settings grafeasV1Beta1Settings =
 *     GrafeasV1Beta1Settings.newHttpJsonBuilder().build();
 * GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create(grafeasV1Beta1Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrafeasV1Beta1Client implements BackgroundResource {
  private final GrafeasV1Beta1Settings settings;
  private final GrafeasV1Beta1Stub stub;

  /** Constructs an instance of GrafeasV1Beta1Client with default settings. */
  public static final GrafeasV1Beta1Client create() throws IOException {
    return create(GrafeasV1Beta1Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of GrafeasV1Beta1Client, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GrafeasV1Beta1Client create(GrafeasV1Beta1Settings settings)
      throws IOException {
    return new GrafeasV1Beta1Client(settings);
  }

  /**
   * Constructs an instance of GrafeasV1Beta1Client, using the given stub for making calls. This is
   * for advanced usage - prefer using create(GrafeasV1Beta1Settings).
   */
  public static final GrafeasV1Beta1Client create(GrafeasV1Beta1Stub stub) {
    return new GrafeasV1Beta1Client(stub);
  }

  /**
   * Constructs an instance of GrafeasV1Beta1Client, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrafeasV1Beta1Client(GrafeasV1Beta1Settings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GrafeasV1Beta1StubSettings) settings.getStubSettings()).createStub();
  }

  protected GrafeasV1Beta1Client(GrafeasV1Beta1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GrafeasV1Beta1Settings getSettings() {
    return settings;
  }

  public GrafeasV1Beta1Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   GetOccurrenceRequest request =
   *       GetOccurrenceRequest.newBuilder().setName("name3373707").build();
   *   Occurrence response = grafeasV1Beta1Client.getOccurrence(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence getOccurrence(GetOccurrenceRequest request) {
    return getOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   GetOccurrenceRequest request =
   *       GetOccurrenceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Occurrence> future =
   *       grafeasV1Beta1Client.getOccurrenceCallable().futureCall(request);
   *   // Do something.
   *   Occurrence response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable() {
    return stub.getOccurrenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists occurrences for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListOccurrencesRequest request =
   *       ListOccurrencesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Occurrence element : grafeasV1Beta1Client.listOccurrences(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOccurrencesPagedResponse listOccurrences(ListOccurrencesRequest request) {
    return listOccurrencesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists occurrences for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListOccurrencesRequest request =
   *       ListOccurrencesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Occurrence> future =
   *       grafeasV1Beta1Client.listOccurrencesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Occurrence element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable() {
    return stub.listOccurrencesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists occurrences for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListOccurrencesRequest request =
   *       ListOccurrencesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOccurrencesResponse response =
   *         grafeasV1Beta1Client.listOccurrencesCallable().call(request);
   *     for (Occurrence element : response.getOccurrencesList()) {
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
  public final UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesCallable() {
    return stub.listOccurrencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified occurrence. For example, use this method to delete an occurrence when the
   * occurrence is no longer applicable for the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   DeleteOccurrenceRequest request =
   *       DeleteOccurrenceRequest.newBuilder().setName("name3373707").build();
   *   grafeasV1Beta1Client.deleteOccurrence(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteOccurrence(DeleteOccurrenceRequest request) {
    deleteOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified occurrence. For example, use this method to delete an occurrence when the
   * occurrence is no longer applicable for the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   DeleteOccurrenceRequest request =
   *       DeleteOccurrenceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future = grafeasV1Beta1Client.deleteOccurrenceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable() {
    return stub.deleteOccurrenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new occurrence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   CreateOccurrenceRequest request =
   *       CreateOccurrenceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOccurrence(Occurrence.newBuilder().build())
   *           .build();
   *   Occurrence response = grafeasV1Beta1Client.createOccurrence(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence createOccurrence(CreateOccurrenceRequest request) {
    return createOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new occurrence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   CreateOccurrenceRequest request =
   *       CreateOccurrenceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOccurrence(Occurrence.newBuilder().build())
   *           .build();
   *   ApiFuture<Occurrence> future =
   *       grafeasV1Beta1Client.createOccurrenceCallable().futureCall(request);
   *   // Do something.
   *   Occurrence response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable() {
    return stub.createOccurrenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new occurrences in batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   BatchCreateOccurrencesRequest request =
   *       BatchCreateOccurrencesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllOccurrences(new ArrayList<Occurrence>())
   *           .build();
   *   BatchCreateOccurrencesResponse response =
   *       grafeasV1Beta1Client.batchCreateOccurrences(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateOccurrencesResponse batchCreateOccurrences(
      BatchCreateOccurrencesRequest request) {
    return batchCreateOccurrencesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new occurrences in batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   BatchCreateOccurrencesRequest request =
   *       BatchCreateOccurrencesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllOccurrences(new ArrayList<Occurrence>())
   *           .build();
   *   ApiFuture<BatchCreateOccurrencesResponse> future =
   *       grafeasV1Beta1Client.batchCreateOccurrencesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateOccurrencesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesCallable() {
    return stub.batchCreateOccurrencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   UpdateOccurrenceRequest request =
   *       UpdateOccurrenceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOccurrence(Occurrence.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Occurrence response = grafeasV1Beta1Client.updateOccurrence(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence updateOccurrence(UpdateOccurrenceRequest request) {
    return updateOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified occurrence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   UpdateOccurrenceRequest request =
   *       UpdateOccurrenceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOccurrence(Occurrence.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Occurrence> future =
   *       grafeasV1Beta1Client.updateOccurrenceCallable().futureCall(request);
   *   // Do something.
   *   Occurrence response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable() {
    return stub.updateOccurrenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the note attached to the specified occurrence. Consumer projects can use this method to
   * get a note that belongs to a provider project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   GetOccurrenceNoteRequest request =
   *       GetOccurrenceNoteRequest.newBuilder().setName("name3373707").build();
   *   Note response = grafeasV1Beta1Client.getOccurrenceNote(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getOccurrenceNote(GetOccurrenceNoteRequest request) {
    return getOccurrenceNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the note attached to the specified occurrence. Consumer projects can use this method to
   * get a note that belongs to a provider project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   GetOccurrenceNoteRequest request =
   *       GetOccurrenceNoteRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Note> future = grafeasV1Beta1Client.getOccurrenceNoteCallable().futureCall(request);
   *   // Do something.
   *   Note response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable() {
    return stub.getOccurrenceNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   GetNoteRequest request = GetNoteRequest.newBuilder().setName("name3373707").build();
   *   Note response = grafeasV1Beta1Client.getNote(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getNote(GetNoteRequest request) {
    return getNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   GetNoteRequest request = GetNoteRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Note> future = grafeasV1Beta1Client.getNoteCallable().futureCall(request);
   *   // Do something.
   *   Note response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNoteRequest, Note> getNoteCallable() {
    return stub.getNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notes for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListNotesRequest request =
   *       ListNotesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Note element : grafeasV1Beta1Client.listNotes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotesPagedResponse listNotes(ListNotesRequest request) {
    return listNotesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notes for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListNotesRequest request =
   *       ListNotesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Note> future = grafeasV1Beta1Client.listNotesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Note element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable() {
    return stub.listNotesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists notes for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListNotesRequest request =
   *       ListNotesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNotesResponse response = grafeasV1Beta1Client.listNotesCallable().call(request);
   *     for (Note element : response.getNotesList()) {
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
  public final UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable() {
    return stub.listNotesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   DeleteNoteRequest request = DeleteNoteRequest.newBuilder().setName("name3373707").build();
   *   grafeasV1Beta1Client.deleteNote(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNote(DeleteNoteRequest request) {
    deleteNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   DeleteNoteRequest request = DeleteNoteRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future = grafeasV1Beta1Client.deleteNoteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable() {
    return stub.deleteNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   CreateNoteRequest request =
   *       CreateNoteRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setNoteId("noteId-1039694675")
   *           .setNote(Note.newBuilder().build())
   *           .build();
   *   Note response = grafeasV1Beta1Client.createNote(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note createNote(CreateNoteRequest request) {
    return createNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   CreateNoteRequest request =
   *       CreateNoteRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setNoteId("noteId-1039694675")
   *           .setNote(Note.newBuilder().build())
   *           .build();
   *   ApiFuture<Note> future = grafeasV1Beta1Client.createNoteCallable().futureCall(request);
   *   // Do something.
   *   Note response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNoteRequest, Note> createNoteCallable() {
    return stub.createNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new notes in batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   BatchCreateNotesRequest request =
   *       BatchCreateNotesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .putAllNotes(new HashMap<String, Note>())
   *           .build();
   *   BatchCreateNotesResponse response = grafeasV1Beta1Client.batchCreateNotes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateNotesResponse batchCreateNotes(BatchCreateNotesRequest request) {
    return batchCreateNotesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new notes in batch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   BatchCreateNotesRequest request =
   *       BatchCreateNotesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .putAllNotes(new HashMap<String, Note>())
   *           .build();
   *   ApiFuture<BatchCreateNotesResponse> future =
   *       grafeasV1Beta1Client.batchCreateNotesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateNotesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesCallable() {
    return stub.batchCreateNotesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   UpdateNoteRequest request =
   *       UpdateNoteRequest.newBuilder()
   *           .setName("name3373707")
   *           .setNote(Note.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Note response = grafeasV1Beta1Client.updateNote(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note updateNote(UpdateNoteRequest request) {
    return updateNoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   UpdateNoteRequest request =
   *       UpdateNoteRequest.newBuilder()
   *           .setName("name3373707")
   *           .setNote(Note.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Note> future = grafeasV1Beta1Client.updateNoteCallable().futureCall(request);
   *   // Do something.
   *   Note response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable() {
    return stub.updateNoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists occurrences referencing the specified note. Provider projects can use this method to get
   * all occurrences across consumer projects referencing the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListNoteOccurrencesRequest request =
   *       ListNoteOccurrencesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Occurrence element : grafeasV1Beta1Client.listNoteOccurrences(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNoteOccurrencesPagedResponse listNoteOccurrences(
      ListNoteOccurrencesRequest request) {
    return listNoteOccurrencesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists occurrences referencing the specified note. Provider projects can use this method to get
   * all occurrences across consumer projects referencing the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListNoteOccurrencesRequest request =
   *       ListNoteOccurrencesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Occurrence> future =
   *       grafeasV1Beta1Client.listNoteOccurrencesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Occurrence element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable() {
    return stub.listNoteOccurrencesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists occurrences referencing the specified note. Provider projects can use this method to get
   * all occurrences across consumer projects referencing the specified note.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   ListNoteOccurrencesRequest request =
   *       ListNoteOccurrencesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNoteOccurrencesResponse response =
   *         grafeasV1Beta1Client.listNoteOccurrencesCallable().call(request);
   *     for (Occurrence element : response.getOccurrencesList()) {
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
  public final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable() {
    return stub.listNoteOccurrencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   GetVulnerabilityOccurrencesSummaryRequest request =
   *       GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   VulnerabilityOccurrencesSummary response =
   *       grafeasV1Beta1Client.getVulnerabilityOccurrencesSummary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityOccurrencesSummary getVulnerabilityOccurrencesSummary(
      GetVulnerabilityOccurrencesSummaryRequest request) {
    return getVulnerabilityOccurrencesSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
   *   GetVulnerabilityOccurrencesSummaryRequest request =
   *       GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<VulnerabilityOccurrencesSummary> future =
   *       grafeasV1Beta1Client.getVulnerabilityOccurrencesSummaryCallable().futureCall(request);
   *   // Do something.
   *   VulnerabilityOccurrencesSummary response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummaryCallable() {
    return stub.getVulnerabilityOccurrencesSummaryCallable();
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

  public static class ListOccurrencesPagedResponse
      extends AbstractPagedListResponse<
          ListOccurrencesRequest,
          ListOccurrencesResponse,
          Occurrence,
          ListOccurrencesPage,
          ListOccurrencesFixedSizeCollection> {

    public static ApiFuture<ListOccurrencesPagedResponse> createAsync(
        PageContext<ListOccurrencesRequest, ListOccurrencesResponse, Occurrence> context,
        ApiFuture<ListOccurrencesResponse> futureResponse) {
      ApiFuture<ListOccurrencesPage> futurePage =
          ListOccurrencesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOccurrencesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOccurrencesPagedResponse(ListOccurrencesPage page) {
      super(page, ListOccurrencesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOccurrencesPage
      extends AbstractPage<
          ListOccurrencesRequest, ListOccurrencesResponse, Occurrence, ListOccurrencesPage> {

    private ListOccurrencesPage(
        PageContext<ListOccurrencesRequest, ListOccurrencesResponse, Occurrence> context,
        ListOccurrencesResponse response) {
      super(context, response);
    }

    private static ListOccurrencesPage createEmptyPage() {
      return new ListOccurrencesPage(null, null);
    }

    @Override
    protected ListOccurrencesPage createPage(
        PageContext<ListOccurrencesRequest, ListOccurrencesResponse, Occurrence> context,
        ListOccurrencesResponse response) {
      return new ListOccurrencesPage(context, response);
    }

    @Override
    public ApiFuture<ListOccurrencesPage> createPageAsync(
        PageContext<ListOccurrencesRequest, ListOccurrencesResponse, Occurrence> context,
        ApiFuture<ListOccurrencesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOccurrencesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOccurrencesRequest,
          ListOccurrencesResponse,
          Occurrence,
          ListOccurrencesPage,
          ListOccurrencesFixedSizeCollection> {

    private ListOccurrencesFixedSizeCollection(
        List<ListOccurrencesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOccurrencesFixedSizeCollection createEmptyCollection() {
      return new ListOccurrencesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOccurrencesFixedSizeCollection createCollection(
        List<ListOccurrencesPage> pages, int collectionSize) {
      return new ListOccurrencesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNotesPagedResponse
      extends AbstractPagedListResponse<
          ListNotesRequest, ListNotesResponse, Note, ListNotesPage, ListNotesFixedSizeCollection> {

    public static ApiFuture<ListNotesPagedResponse> createAsync(
        PageContext<ListNotesRequest, ListNotesResponse, Note> context,
        ApiFuture<ListNotesResponse> futureResponse) {
      ApiFuture<ListNotesPage> futurePage =
          ListNotesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListNotesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListNotesPagedResponse(ListNotesPage page) {
      super(page, ListNotesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotesPage
      extends AbstractPage<ListNotesRequest, ListNotesResponse, Note, ListNotesPage> {

    private ListNotesPage(
        PageContext<ListNotesRequest, ListNotesResponse, Note> context,
        ListNotesResponse response) {
      super(context, response);
    }

    private static ListNotesPage createEmptyPage() {
      return new ListNotesPage(null, null);
    }

    @Override
    protected ListNotesPage createPage(
        PageContext<ListNotesRequest, ListNotesResponse, Note> context,
        ListNotesResponse response) {
      return new ListNotesPage(context, response);
    }

    @Override
    public ApiFuture<ListNotesPage> createPageAsync(
        PageContext<ListNotesRequest, ListNotesResponse, Note> context,
        ApiFuture<ListNotesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotesRequest, ListNotesResponse, Note, ListNotesPage, ListNotesFixedSizeCollection> {

    private ListNotesFixedSizeCollection(List<ListNotesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotesFixedSizeCollection createEmptyCollection() {
      return new ListNotesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotesFixedSizeCollection createCollection(
        List<ListNotesPage> pages, int collectionSize) {
      return new ListNotesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNoteOccurrencesPagedResponse
      extends AbstractPagedListResponse<
          ListNoteOccurrencesRequest,
          ListNoteOccurrencesResponse,
          Occurrence,
          ListNoteOccurrencesPage,
          ListNoteOccurrencesFixedSizeCollection> {

    public static ApiFuture<ListNoteOccurrencesPagedResponse> createAsync(
        PageContext<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence> context,
        ApiFuture<ListNoteOccurrencesResponse> futureResponse) {
      ApiFuture<ListNoteOccurrencesPage> futurePage =
          ListNoteOccurrencesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNoteOccurrencesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNoteOccurrencesPagedResponse(ListNoteOccurrencesPage page) {
      super(page, ListNoteOccurrencesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNoteOccurrencesPage
      extends AbstractPage<
          ListNoteOccurrencesRequest,
          ListNoteOccurrencesResponse,
          Occurrence,
          ListNoteOccurrencesPage> {

    private ListNoteOccurrencesPage(
        PageContext<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence> context,
        ListNoteOccurrencesResponse response) {
      super(context, response);
    }

    private static ListNoteOccurrencesPage createEmptyPage() {
      return new ListNoteOccurrencesPage(null, null);
    }

    @Override
    protected ListNoteOccurrencesPage createPage(
        PageContext<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence> context,
        ListNoteOccurrencesResponse response) {
      return new ListNoteOccurrencesPage(context, response);
    }

    @Override
    public ApiFuture<ListNoteOccurrencesPage> createPageAsync(
        PageContext<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence> context,
        ApiFuture<ListNoteOccurrencesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNoteOccurrencesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNoteOccurrencesRequest,
          ListNoteOccurrencesResponse,
          Occurrence,
          ListNoteOccurrencesPage,
          ListNoteOccurrencesFixedSizeCollection> {

    private ListNoteOccurrencesFixedSizeCollection(
        List<ListNoteOccurrencesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNoteOccurrencesFixedSizeCollection createEmptyCollection() {
      return new ListNoteOccurrencesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNoteOccurrencesFixedSizeCollection createCollection(
        List<ListNoteOccurrencesPage> pages, int collectionSize) {
      return new ListNoteOccurrencesFixedSizeCollection(pages, collectionSize);
    }
  }
}
