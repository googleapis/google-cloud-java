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

package io.grafeas.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grafeas.v1.stub.GrafeasStub;
import io.grafeas.v1.stub.GrafeasStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: [Grafeas](https://grafeas.io) API.
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
 * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
 *   OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
 *   Occurrence response = grafeasClient.getOccurrence(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GrafeasClient object to clean up resources such as
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
 *      <td><p> GetOccurrence</td>
 *      <td><p> Gets the specified occurrence.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOccurrence(GetOccurrenceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOccurrence(OccurrenceName name)
 *           <li><p> getOccurrence(String name)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOccurrences(ProjectName parent, String filter)
 *           <li><p> listOccurrences(String parent, String filter)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteOccurrence(OccurrenceName name)
 *           <li><p> deleteOccurrence(String name)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createOccurrence(ProjectName parent, Occurrence occurrence)
 *           <li><p> createOccurrence(String parent, Occurrence occurrence)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchCreateOccurrences(ProjectName parent, List&lt;Occurrence&gt; occurrences)
 *           <li><p> batchCreateOccurrences(String parent, List&lt;Occurrence&gt; occurrences)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateOccurrence(OccurrenceName name, Occurrence occurrence, FieldMask updateMask)
 *           <li><p> updateOccurrence(String name, Occurrence occurrence, FieldMask updateMask)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOccurrenceNote(OccurrenceName name)
 *           <li><p> getOccurrenceNote(String name)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNote(NoteName name)
 *           <li><p> getNote(String name)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNotes(ProjectName parent, String filter)
 *           <li><p> listNotes(String parent, String filter)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteNote(NoteName name)
 *           <li><p> deleteNote(String name)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createNote(ProjectName parent, String noteId, Note note)
 *           <li><p> createNote(String parent, String noteId, Note note)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchCreateNotes(ProjectName parent, Map&lt;String, Note&gt; notes)
 *           <li><p> batchCreateNotes(String parent, Map&lt;String, Note&gt; notes)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateNote(NoteName name, Note note, FieldMask updateMask)
 *           <li><p> updateNote(String name, Note note, FieldMask updateMask)
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
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNoteOccurrences(NoteName name, String filter)
 *           <li><p> listNoteOccurrences(String name, String filter)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNoteOccurrencesPagedCallable()
 *           <li><p> listNoteOccurrencesCallable()
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
 * <p>This class can be customized by passing in a custom instance of GrafeasSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GrafeasSettings grafeasSettings =
 *     GrafeasSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GrafeasClient grafeasClient = GrafeasClient.create(grafeasSettings);
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
 * GrafeasSettings grafeasSettings = GrafeasSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GrafeasClient grafeasClient = GrafeasClient.create(grafeasSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GrafeasClient implements BackgroundResource {
  private final GrafeasSettings settings;
  private final GrafeasStub stub;

  /** Constructs an instance of GrafeasClient with default settings. */
  public static final GrafeasClient create() throws IOException {
    return create(GrafeasSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GrafeasClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GrafeasClient create(GrafeasSettings settings) throws IOException {
    return new GrafeasClient(settings);
  }

  /**
   * Constructs an instance of GrafeasClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(GrafeasSettings).
   */
  public static final GrafeasClient create(GrafeasStub stub) {
    return new GrafeasClient(stub);
  }

  /**
   * Constructs an instance of GrafeasClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrafeasClient(GrafeasSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GrafeasStubSettings) settings.getStubSettings()).createStub();
  }

  protected GrafeasClient(GrafeasStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GrafeasSettings getSettings() {
    return settings;
  }

  public GrafeasStub getStub() {
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence response = grafeasClient.getOccurrence(name);
   * }
   * }</pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence getOccurrence(OccurrenceName name) {
    GetOccurrenceRequest request =
        GetOccurrenceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString();
   *   Occurrence response = grafeasClient.getOccurrence(name);
   * }
   * }</pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence getOccurrence(String name) {
    GetOccurrenceRequest request = GetOccurrenceRequest.newBuilder().setName(name).build();
    return getOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   GetOccurrenceRequest request =
   *       GetOccurrenceRequest.newBuilder()
   *           .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
   *           .build();
   *   Occurrence response = grafeasClient.getOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   GetOccurrenceRequest request =
   *       GetOccurrenceRequest.newBuilder()
   *           .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
   *           .build();
   *   ApiFuture<Occurrence> future = grafeasClient.getOccurrenceCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "filter-1274492040";
   *   for (Occurrence element : grafeasClient.listOccurrences(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the project to list occurrences for in the form of
   *     `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOccurrencesPagedResponse listOccurrences(ProjectName parent, String filter) {
    ListOccurrencesRequest request =
        ListOccurrencesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listOccurrences(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   String filter = "filter-1274492040";
   *   for (Occurrence element : grafeasClient.listOccurrences(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the project to list occurrences for in the form of
   *     `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOccurrencesPagedResponse listOccurrences(String parent, String filter) {
    ListOccurrencesRequest request =
        ListOccurrencesRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listOccurrences(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListOccurrencesRequest request =
   *       ListOccurrencesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Occurrence element : grafeasClient.listOccurrences(request).iterateAll()) {
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListOccurrencesRequest request =
   *       ListOccurrencesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Occurrence> future =
   *       grafeasClient.listOccurrencesPagedCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListOccurrencesRequest request =
   *       ListOccurrencesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOccurrencesResponse response = grafeasClient.listOccurrencesCallable().call(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
   *   grafeasClient.deleteOccurrence(name);
   * }
   * }</pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteOccurrence(OccurrenceName name) {
    DeleteOccurrenceRequest request =
        DeleteOccurrenceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString();
   *   grafeasClient.deleteOccurrence(name);
   * }
   * }</pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteOccurrence(String name) {
    DeleteOccurrenceRequest request = DeleteOccurrenceRequest.newBuilder().setName(name).build();
    deleteOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   DeleteOccurrenceRequest request =
   *       DeleteOccurrenceRequest.newBuilder()
   *           .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
   *           .build();
   *   grafeasClient.deleteOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   DeleteOccurrenceRequest request =
   *       DeleteOccurrenceRequest.newBuilder()
   *           .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
   *           .build();
   *   ApiFuture<Empty> future = grafeasClient.deleteOccurrenceCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   Occurrence response = grafeasClient.createOccurrence(parent, occurrence);
   * }
   * }</pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     occurrence is to be created.
   * @param occurrence The occurrence to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence createOccurrence(ProjectName parent, Occurrence occurrence) {
    CreateOccurrenceRequest request =
        CreateOccurrenceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOccurrence(occurrence)
            .build();
    return createOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   Occurrence response = grafeasClient.createOccurrence(parent, occurrence);
   * }
   * }</pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     occurrence is to be created.
   * @param occurrence The occurrence to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence createOccurrence(String parent, Occurrence occurrence) {
    CreateOccurrenceRequest request =
        CreateOccurrenceRequest.newBuilder().setParent(parent).setOccurrence(occurrence).build();
    return createOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   CreateOccurrenceRequest request =
   *       CreateOccurrenceRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setOccurrence(Occurrence.newBuilder().build())
   *           .build();
   *   Occurrence response = grafeasClient.createOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   CreateOccurrenceRequest request =
   *       CreateOccurrenceRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setOccurrence(Occurrence.newBuilder().build())
   *           .build();
   *   ApiFuture<Occurrence> future = grafeasClient.createOccurrenceCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   List<Occurrence> occurrences = new ArrayList<>();
   *   BatchCreateOccurrencesResponse response =
   *       grafeasClient.batchCreateOccurrences(parent, occurrences);
   * }
   * }</pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     occurrences are to be created.
   * @param occurrences The occurrences to create. Max allowed length is 1000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateOccurrencesResponse batchCreateOccurrences(
      ProjectName parent, List<Occurrence> occurrences) {
    BatchCreateOccurrencesRequest request =
        BatchCreateOccurrencesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllOccurrences(occurrences)
            .build();
    return batchCreateOccurrences(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   List<Occurrence> occurrences = new ArrayList<>();
   *   BatchCreateOccurrencesResponse response =
   *       grafeasClient.batchCreateOccurrences(parent, occurrences);
   * }
   * }</pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     occurrences are to be created.
   * @param occurrences The occurrences to create. Max allowed length is 1000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateOccurrencesResponse batchCreateOccurrences(
      String parent, List<Occurrence> occurrences) {
    BatchCreateOccurrencesRequest request =
        BatchCreateOccurrencesRequest.newBuilder()
            .setParent(parent)
            .addAllOccurrences(occurrences)
            .build();
    return batchCreateOccurrences(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   BatchCreateOccurrencesRequest request =
   *       BatchCreateOccurrencesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .addAllOccurrences(new ArrayList<Occurrence>())
   *           .build();
   *   BatchCreateOccurrencesResponse response = grafeasClient.batchCreateOccurrences(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   BatchCreateOccurrencesRequest request =
   *       BatchCreateOccurrencesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .addAllOccurrences(new ArrayList<Occurrence>())
   *           .build();
   *   ApiFuture<BatchCreateOccurrencesResponse> future =
   *       grafeasClient.batchCreateOccurrencesCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Occurrence response = grafeasClient.updateOccurrence(name, occurrence, updateMask);
   * }
   * }</pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @param occurrence The updated occurrence.
   * @param updateMask The fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence updateOccurrence(
      OccurrenceName name, Occurrence occurrence, FieldMask updateMask) {
    UpdateOccurrenceRequest request =
        UpdateOccurrenceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOccurrence(occurrence)
            .setUpdateMask(updateMask)
            .build();
    return updateOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString();
   *   Occurrence occurrence = Occurrence.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Occurrence response = grafeasClient.updateOccurrence(name, occurrence, updateMask);
   * }
   * }</pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @param occurrence The updated occurrence.
   * @param updateMask The fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Occurrence updateOccurrence(
      String name, Occurrence occurrence, FieldMask updateMask) {
    UpdateOccurrenceRequest request =
        UpdateOccurrenceRequest.newBuilder()
            .setName(name)
            .setOccurrence(occurrence)
            .setUpdateMask(updateMask)
            .build();
    return updateOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   UpdateOccurrenceRequest request =
   *       UpdateOccurrenceRequest.newBuilder()
   *           .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
   *           .setOccurrence(Occurrence.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Occurrence response = grafeasClient.updateOccurrence(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   UpdateOccurrenceRequest request =
   *       UpdateOccurrenceRequest.newBuilder()
   *           .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
   *           .setOccurrence(Occurrence.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Occurrence> future = grafeasClient.updateOccurrenceCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
   *   Note response = grafeasClient.getOccurrenceNote(name);
   * }
   * }</pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getOccurrenceNote(OccurrenceName name) {
    GetOccurrenceNoteRequest request =
        GetOccurrenceNoteRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOccurrenceNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString();
   *   Note response = grafeasClient.getOccurrenceNote(name);
   * }
   * }</pre>
   *
   * @param name The name of the occurrence in the form of
   *     `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getOccurrenceNote(String name) {
    GetOccurrenceNoteRequest request = GetOccurrenceNoteRequest.newBuilder().setName(name).build();
    return getOccurrenceNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   GetOccurrenceNoteRequest request =
   *       GetOccurrenceNoteRequest.newBuilder()
   *           .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
   *           .build();
   *   Note response = grafeasClient.getOccurrenceNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   GetOccurrenceNoteRequest request =
   *       GetOccurrenceNoteRequest.newBuilder()
   *           .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
   *           .build();
   *   ApiFuture<Note> future = grafeasClient.getOccurrenceNoteCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
   *   Note response = grafeasClient.getNote(name);
   * }
   * }</pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getNote(NoteName name) {
    GetNoteRequest request =
        GetNoteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String name = NoteName.of("[PROJECT]", "[NOTE]").toString();
   *   Note response = grafeasClient.getNote(name);
   * }
   * }</pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note getNote(String name) {
    GetNoteRequest request = GetNoteRequest.newBuilder().setName(name).build();
    return getNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   GetNoteRequest request =
   *       GetNoteRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .build();
   *   Note response = grafeasClient.getNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   GetNoteRequest request =
   *       GetNoteRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .build();
   *   ApiFuture<Note> future = grafeasClient.getNoteCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "filter-1274492040";
   *   for (Note element : grafeasClient.listNotes(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the project to list notes for in the form of `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotesPagedResponse listNotes(ProjectName parent, String filter) {
    ListNotesRequest request =
        ListNotesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listNotes(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   String filter = "filter-1274492040";
   *   for (Note element : grafeasClient.listNotes(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the project to list notes for in the form of `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotesPagedResponse listNotes(String parent, String filter) {
    ListNotesRequest request =
        ListNotesRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listNotes(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListNotesRequest request =
   *       ListNotesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Note element : grafeasClient.listNotes(request).iterateAll()) {
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListNotesRequest request =
   *       ListNotesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Note> future = grafeasClient.listNotesPagedCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListNotesRequest request =
   *       ListNotesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNotesResponse response = grafeasClient.listNotesCallable().call(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
   *   grafeasClient.deleteNote(name);
   * }
   * }</pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNote(NoteName name) {
    DeleteNoteRequest request =
        DeleteNoteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String name = NoteName.of("[PROJECT]", "[NOTE]").toString();
   *   grafeasClient.deleteNote(name);
   * }
   * }</pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNote(String name) {
    DeleteNoteRequest request = DeleteNoteRequest.newBuilder().setName(name).build();
    deleteNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   DeleteNoteRequest request =
   *       DeleteNoteRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .build();
   *   grafeasClient.deleteNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   DeleteNoteRequest request =
   *       DeleteNoteRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .build();
   *   ApiFuture<Empty> future = grafeasClient.deleteNoteCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String noteId = "noteId-1039694675";
   *   Note note = Note.newBuilder().build();
   *   Note response = grafeasClient.createNote(parent, noteId, note);
   * }
   * }</pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     note is to be created.
   * @param noteId The ID to use for this note.
   * @param note The note to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note createNote(ProjectName parent, String noteId, Note note) {
    CreateNoteRequest request =
        CreateNoteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNoteId(noteId)
            .setNote(note)
            .build();
    return createNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   String noteId = "noteId-1039694675";
   *   Note note = Note.newBuilder().build();
   *   Note response = grafeasClient.createNote(parent, noteId, note);
   * }
   * }</pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     note is to be created.
   * @param noteId The ID to use for this note.
   * @param note The note to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note createNote(String parent, String noteId, Note note) {
    CreateNoteRequest request =
        CreateNoteRequest.newBuilder().setParent(parent).setNoteId(noteId).setNote(note).build();
    return createNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   CreateNoteRequest request =
   *       CreateNoteRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setNoteId("noteId-1039694675")
   *           .setNote(Note.newBuilder().build())
   *           .build();
   *   Note response = grafeasClient.createNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   CreateNoteRequest request =
   *       CreateNoteRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setNoteId("noteId-1039694675")
   *           .setNote(Note.newBuilder().build())
   *           .build();
   *   ApiFuture<Note> future = grafeasClient.createNoteCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Map<String, Note> notes = new HashMap<>();
   *   BatchCreateNotesResponse response = grafeasClient.batchCreateNotes(parent, notes);
   * }
   * }</pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     notes are to be created.
   * @param notes The notes to create. Max allowed length is 1000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateNotesResponse batchCreateNotes(
      ProjectName parent, Map<String, Note> notes) {
    BatchCreateNotesRequest request =
        BatchCreateNotesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .putAllNotes(notes)
            .build();
    return batchCreateNotes(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Map<String, Note> notes = new HashMap<>();
   *   BatchCreateNotesResponse response = grafeasClient.batchCreateNotes(parent, notes);
   * }
   * }</pre>
   *
   * @param parent The name of the project in the form of `projects/[PROJECT_ID]`, under which the
   *     notes are to be created.
   * @param notes The notes to create. Max allowed length is 1000.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateNotesResponse batchCreateNotes(String parent, Map<String, Note> notes) {
    BatchCreateNotesRequest request =
        BatchCreateNotesRequest.newBuilder().setParent(parent).putAllNotes(notes).build();
    return batchCreateNotes(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   BatchCreateNotesRequest request =
   *       BatchCreateNotesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .putAllNotes(new HashMap<String, Note>())
   *           .build();
   *   BatchCreateNotesResponse response = grafeasClient.batchCreateNotes(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   BatchCreateNotesRequest request =
   *       BatchCreateNotesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .putAllNotes(new HashMap<String, Note>())
   *           .build();
   *   ApiFuture<BatchCreateNotesResponse> future =
   *       grafeasClient.batchCreateNotesCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
   *   Note note = Note.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Note response = grafeasClient.updateNote(name, note, updateMask);
   * }
   * }</pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @param note The updated note.
   * @param updateMask The fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note updateNote(NoteName name, Note note, FieldMask updateMask) {
    UpdateNoteRequest request =
        UpdateNoteRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNote(note)
            .setUpdateMask(updateMask)
            .build();
    return updateNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String name = NoteName.of("[PROJECT]", "[NOTE]").toString();
   *   Note note = Note.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Note response = grafeasClient.updateNote(name, note, updateMask);
   * }
   * }</pre>
   *
   * @param name The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @param note The updated note.
   * @param updateMask The fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Note updateNote(String name, Note note, FieldMask updateMask) {
    UpdateNoteRequest request =
        UpdateNoteRequest.newBuilder()
            .setName(name)
            .setNote(note)
            .setUpdateMask(updateMask)
            .build();
    return updateNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   UpdateNoteRequest request =
   *       UpdateNoteRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .setNote(Note.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Note response = grafeasClient.updateNote(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   UpdateNoteRequest request =
   *       UpdateNoteRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .setNote(Note.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Note> future = grafeasClient.updateNoteCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
   *   String filter = "filter-1274492040";
   *   for (Occurrence element : grafeasClient.listNoteOccurrences(name, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name The name of the note to list occurrences for in the form of
   *     `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNoteOccurrencesPagedResponse listNoteOccurrences(NoteName name, String filter) {
    ListNoteOccurrencesRequest request =
        ListNoteOccurrencesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setFilter(filter)
            .build();
    return listNoteOccurrences(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   String name = NoteName.of("[PROJECT]", "[NOTE]").toString();
   *   String filter = "filter-1274492040";
   *   for (Occurrence element : grafeasClient.listNoteOccurrences(name, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name The name of the note to list occurrences for in the form of
   *     `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNoteOccurrencesPagedResponse listNoteOccurrences(String name, String filter) {
    ListNoteOccurrencesRequest request =
        ListNoteOccurrencesRequest.newBuilder().setName(name).setFilter(filter).build();
    return listNoteOccurrences(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListNoteOccurrencesRequest request =
   *       ListNoteOccurrencesRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Occurrence element : grafeasClient.listNoteOccurrences(request).iterateAll()) {
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListNoteOccurrencesRequest request =
   *       ListNoteOccurrencesRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Occurrence> future =
   *       grafeasClient.listNoteOccurrencesPagedCallable().futureCall(request);
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
   * try (GrafeasClient grafeasClient = GrafeasClient.create()) {
   *   ListNoteOccurrencesRequest request =
   *       ListNoteOccurrencesRequest.newBuilder()
   *           .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNoteOccurrencesResponse response =
   *         grafeasClient.listNoteOccurrencesCallable().call(request);
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
